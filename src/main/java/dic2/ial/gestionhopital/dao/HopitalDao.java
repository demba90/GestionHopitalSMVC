package dic2.ial.gestionhopital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dic2.ial.gestionhopital.modele.User;
import dic2.ial.gestionhopital.modele.Medecin;
import dic2.ial.gestionhopital.modele.Secretaire;
import dic2.ial.gestionhopital.modele.Patient;

public class HopitalDao implements IHopitalDao{
	
	private Connection cnx = null ;
    private PreparedStatement stmt = null ;
    private ResultSet resultat = null ;


    public HopitalDao()
    {
        try
		{
			//chargement du pilote
			Class.forName("com.mysql.jdbc.Driver").newInstance( ) ;
			//connexion à  la base de données
			cnx = DriverManager.getConnection ("jdbc:mysql://localhost/hopital","root","") ;
                        //creation d'une connexion
                        
		}
		catch (Exception se )
		{
			System.out.println("Erreur de connexion "+ se.getMessage());
		}
    }
    
    public Medecin getObjectMedecin( int matricule) throws   SQLException {

        Medecin valueObject = new Medecin();
        valueObject.setMatricule(matricule);
        loadMedecin(valueObject);
        return valueObject;
  }


  public void loadMedecin( Medecin valueObject) throws  SQLException {

        String sql = "SELECT * FROM Medecin WHERE (matricule = ? ) "; 
        PreparedStatement stmt = null;

        try {
             stmt = cnx.prepareStatement(sql);
             stmt.setInt(1, valueObject.getMatricule()); 

             singleQueryMedecin( stmt, valueObject);

        } finally {
            if (stmt != null)
                stmt.close();
        }
  }



  public List loadAllMedecin( ) throws SQLException {

        String sql = "SELECT * FROM Medecin ORDER BY matricule ASC ";
        List searchResults = listQueryMedecin(cnx.prepareStatement(sql));

        return searchResults;
  }

public void createMedecin(Medecin valueObject) throws SQLException {

        String sql = "";
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
             sql = "INSERT INTO Medecin ( matricule, prenom, nom, "
             + "username, password, specialite) VALUES (?, ?, ?, ?, ?, ?) ";
             stmt = cnx.prepareStatement(sql);

             stmt.setInt(1, valueObject.getMatricule()); 
             stmt.setString(2, valueObject.getPrenom()); 
             stmt.setString(3, valueObject.getNom()); 
             stmt.setString(4, valueObject.getUsername()); 
             stmt.setString(5, valueObject.getPassword()); 
             stmt.setString(6, valueObject.getSpecialite()); 

             int rowcount = databaseUpdateMedecin(stmt);
             if (rowcount != 1) {
                  //System.out.println("PrimaryKey Error when updating DB!");
                  throw new SQLException("PrimaryKey Error when updating DB!");
             }

        } finally {
            if (stmt != null)
                stmt.close();
        }


  }



  public void saveMedecin( Medecin valueObject) 
        throws  SQLException {

        String sql = "UPDATE Medecin SET prenom = ?, nom = ?, username = ?, "
             + "password = ?, specialite = ? WHERE (matricule = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = cnx.prepareStatement(sql);
            stmt.setString(1, valueObject.getPrenom()); 
            stmt.setString(2, valueObject.getNom()); 
            stmt.setString(3, valueObject.getUsername()); 
            stmt.setString(4, valueObject.getPassword()); 
            stmt.setString(5, valueObject.getSpecialite()); 

            stmt.setInt(6, valueObject.getMatricule()); 

            int rowcount = databaseUpdateMedecin( stmt);
            if (rowcount == 0) {
                 System.out.println("Object could not be saved! (PrimaryKey not found)");
                 //throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                 System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                 //throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
            }
        } finally {
            if (stmt != null)
                stmt.close();
        }
  }



  public void deleteMedecin(  Medecin valueObject) 
        throws  SQLException {

        String sql = "DELETE FROM Medecin WHERE (matricule = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = cnx.prepareStatement(sql);
            stmt.setInt(1, valueObject.getMatricule()); 

            int rowcount = databaseUpdateMedecin(stmt);
            if (rowcount == 0) {
                 System.out.println("Object could not be deleted (PrimaryKey not found)");
                 //throw new NotFoundException("Object could not be deleted! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                 System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                 //throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
            }
        } finally {
            if (stmt != null)
                stmt.close();
        }
  }



  public void deleteAllMedecin() throws SQLException {

        String sql = "DELETE FROM Medecin";
        PreparedStatement stmt = null;

        try {
            stmt = cnx.prepareStatement(sql);
            int rowcount = databaseUpdateMedecin(stmt);
        } finally {
            if (stmt != null)
                stmt.close();
        }
  }

public int countAllMedecin() throws SQLException {

        String sql = "SELECT count(*) FROM Medecin";
        PreparedStatement stmt = null;
        ResultSet result = null;
        int allRows = 0;

        try {
            stmt = cnx.prepareStatement(sql);
            result = stmt.executeQuery();

            if (result.next())
                allRows = result.getInt(1);
        } finally {
            if (result != null)
                result.close();
            if (stmt != null)
                stmt.close();
        }
        return allRows;
  }

  public List searchMatchingMedecin(Medecin valueObject) throws SQLException {

        List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT * FROM Medecin WHERE 1=1 ");

        if (valueObject.getMatricule() != 0) {
            if (first) { first = false; }
            sql.append("AND matricule = ").append(valueObject.getMatricule()).append(" ");
        }

        if (valueObject.getPrenom() != null) {
            if (first) { first = false; }
            sql.append("AND prenom LIKE '").append(valueObject.getPrenom()).append("%' ");
        }

        if (valueObject.getNom() != null) {
            if (first) { first = false; }
            sql.append("AND nom LIKE '").append(valueObject.getNom()).append("%' ");
        }

        if (valueObject.getUsername() != null) {
            if (first) { first = false; }
            sql.append("AND username LIKE '").append(valueObject.getUsername()).append("%' ");
        }

        if (valueObject.getPassword() != null) {
            if (first) { first = false; }
            sql.append("AND password LIKE '").append(valueObject.getPassword()).append("%' ");
        }

        if (valueObject.getSpecialite() != null) {
            if (first) { first = false; }
            sql.append("AND specialite LIKE '").append(valueObject.getSpecialite()).append("%' ");
        }


        sql.append("ORDER BY matricule ASC ");

        // Prevent accidential full table results.
        // Use loadAll if all rows must be returned.
        if (first)
             searchResults = new ArrayList();
        else
             searchResults = listQueryMedecin(cnx.prepareStatement(sql.toString()));

        return searchResults;
  }


 

  protected int databaseUpdateMedecin( PreparedStatement stmt) throws SQLException {

        int result = stmt.executeUpdate();

        return result;
  }



 
  protected void singleQueryMedecin( PreparedStatement stmt, Medecin valueObject) 
        throws SQLException {

        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            if (result.next()) {

                 valueObject.setMatricule(result.getInt("matricule")); 
                 valueObject.setPrenom(result.getString("prenom")); 
                 valueObject.setNom(result.getString("nom")); 
                 valueObject.setUsername(result.getString("username")); 
                 valueObject.setPassword(result.getString("password")); 
                 valueObject.setSpecialite(result.getString("specialite")); 

            } else {
                  System.out.println("Medecin Object Not Found!");
                  //throw new NotFoundException("Medecin Object Not Found!");
            }
        } finally {
            if (result != null)
                result.close();
            if (stmt != null)
                stmt.close();
        }
  }


  
  protected List listQueryMedecin( PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                 Medecin temp = new Medecin();

                 temp.setMatricule(result.getInt("matricule")); 
                 temp.setPrenom(result.getString("prenom")); 
                 temp.setNom(result.getString("nom")); 
                 temp.setUsername(result.getString("username")); 
                 temp.setPassword(result.getString("password")); 
                 temp.setSpecialite(result.getString("specialite")); 

                 searchResults.add(temp);
            }

        } finally {
            if (result != null)
                result.close();
            if (stmt != null)
                stmt.close();
        }

        return (List)searchResults;
  }


	
    


	@Override
	public void addPatient(Patient p) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<Patient> getAllPatient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePatient(Patient p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePatient(Patient p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRendezVous(Patient p, Medecin m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAdmin(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean authentification(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void addSecretaire(Secretaire s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Medecin getSecretaire(int code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Secretaire> getAllSecretaire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSecretaire(Secretaire m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSecretaire(Secretaire m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Patient getPatient(int code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medecin getMedecin(int mat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMedecin(Medecin m) {
		// TODO Auto-generated method stub
		
	}
}
