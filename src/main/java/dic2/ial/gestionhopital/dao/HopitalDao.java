package dic2.ial.gestionhopital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dic2.ial.gestionhopital.modele.Diagnostique;
import dic2.ial.gestionhopital.modele.Medecin;
import dic2.ial.gestionhopital.modele.Patient;
import dic2.ial.gestionhopital.modele.RendezVous;
import dic2.ial.gestionhopital.modele.Secretaire;


public class HopitalDao extends JdbcDaoSupport implements IHopitalDao{
	
	private Connection cnx = null ;
    private PreparedStatement stmt = null ;
    private ResultSet resultat = null ;


    public HopitalDao()
    {
        try
		{
			//chargement du pilote
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//connexion à  la base de données
			cnx = DriverManager.getConnection ("jdbc:mysql://localhost/hopital","root","") ;
                        //creation d'une connexion
                        
		}
		catch (Exception se )
		{
			System.out.println("Erreur de connexion "+ se.getMessage());
		}
    }
    
    public void inti(){
    	//chargement du pilote
    	try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			cnx = DriverManager.getConnection ("jdbc:mysql://localhost/hopital","root","") ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
             sql = "INSERT INTO Medecin (prenom, nom, "
             + "username, password, specialite) VALUES (?, ?, ?, ?, ?) ";
             stmt = cnx.prepareStatement(sql);

             stmt.setString(1, valueObject.getPrenom()); 
             stmt.setString(2, valueObject.getNom()); 
             stmt.setString(3, valueObject.getUsername()); 
             stmt.setString(4, valueObject.getPassword()); 
             stmt.setString(5, valueObject.getSpecialite()); 

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



  public void updateMedecin( Medecin valueObject) 
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
  
  public Secretaire getObjectSecretaire( int matricule) throws   SQLException {

      Secretaire valueObject = new Secretaire();
      valueObject.setMatricule(matricule);
      loadSecretaire(valueObject);
      return valueObject;
}


public void loadSecretaire( Secretaire valueObject) throws  SQLException {

      String sql = "SELECT * FROM Secretaire WHERE (matricule = ? ) "; 
      PreparedStatement stmt = null;

      try {
           stmt = cnx.prepareStatement(sql);
           stmt.setInt(1, valueObject.getMatricule()); 

           singleQuerySecretaire( stmt, valueObject);

      } finally {
          if (stmt != null)
              stmt.close();
      }
}



public List loadAllSecretaire( ) throws SQLException {

      String sql = "SELECT * FROM Secretaire ORDER BY matricule ASC ";
      List searchResults = listQuerySecretaire(cnx.prepareStatement(sql));

      return searchResults;
}

public void createSecretaire(Secretaire valueObject) throws SQLException {

      String sql = "";
      PreparedStatement stmt = null;
      ResultSet result = null;

      try {
           sql = "INSERT INTO Secretaire (prenom, nom, "
           + "username, password) VALUES (?, ?, ?, ?) ";
           stmt = cnx.prepareStatement(sql);

           stmt.setString(1, valueObject.getPrenom()); 
           stmt.setString(2, valueObject.getNom()); 
           stmt.setString(3, valueObject.getUsername()); 
           stmt.setString(4, valueObject.getPassword()); 

           int rowcount = databaseUpdateSecretaire(stmt);
           if (rowcount != 1) {
                //System.out.println("PrimaryKey Error when updating DB!");
                throw new SQLException("PrimaryKey Error when updating DB!");
           }

      } finally {
          if (stmt != null)
              stmt.close();
      }


}



public void updateSecretaire( Secretaire valueObject) 
      throws  SQLException {

      String sql = "UPDATE Secretaire SET prenom = ?, nom = ?, username = ?, "
           + "password = ?, specialite = ? WHERE (matricule = ? ) ";
      PreparedStatement stmt = null;

      try {
          stmt = cnx.prepareStatement(sql);
          stmt.setString(1, valueObject.getPrenom()); 
          stmt.setString(2, valueObject.getNom()); 
          stmt.setString(3, valueObject.getUsername()); 
          stmt.setString(4, valueObject.getPassword()); 

          stmt.setInt(6, valueObject.getMatricule()); 

          int rowcount = databaseUpdateSecretaire( stmt);
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



public void deleteSecretaire(  Secretaire valueObject) 
      throws  SQLException {

      String sql = "DELETE FROM Secretaire WHERE (matricule = ? ) ";
      PreparedStatement stmt = null;

      try {
          stmt = cnx.prepareStatement(sql);
          stmt.setInt(1, valueObject.getMatricule()); 

          int rowcount = databaseUpdateSecretaire(stmt);
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



public void deleteAllSecretaire() throws SQLException {

      String sql = "DELETE FROM Secretaire";
      PreparedStatement stmt = null;

      try {
          stmt = cnx.prepareStatement(sql);
          int rowcount = databaseUpdateSecretaire(stmt);
      } finally {
          if (stmt != null)
              stmt.close();
      }
}

public int countAllSecretaire() throws SQLException {

      String sql = "SELECT count(*) FROM Secretaire";
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

public List searchMatchingSecretaire(Secretaire valueObject) throws SQLException {

      List searchResults;

      boolean first = true;
      StringBuffer sql = new StringBuffer("SELECT * FROM Secretaire WHERE 1=1 ");

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


      sql.append("ORDER BY matricule ASC ");

      // Prevent accidential full table results.
      // Use loadAll if all rows must be returned.
      if (first)
           searchResults = new ArrayList();
      else
           searchResults = listQuerySecretaire(cnx.prepareStatement(sql.toString()));

      return searchResults;
}




protected int databaseUpdateSecretaire( PreparedStatement stmt) throws SQLException {

      int result = stmt.executeUpdate();

      return result;
}




protected void singleQuerySecretaire( PreparedStatement stmt, Secretaire valueObject) 
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

          } else {
                System.out.println("Secretaire Object Not Found!");
                //throw new NotFoundException("Secretaire Object Not Found!");
          }
      } finally {
          if (result != null)
              result.close();
          if (stmt != null)
              stmt.close();
      }
}



	protected List listQuerySecretaire( PreparedStatement stmt) throws SQLException {
	
	      ArrayList searchResults = new ArrayList();
	      ResultSet result = null;
	
	      try {
	          result = stmt.executeQuery();
	
	          while (result.next()) {
	               Secretaire temp = new Secretaire();
	
	               temp.setMatricule(result.getInt("matricule")); 
	               temp.setPrenom(result.getString("prenom")); 
	               temp.setNom(result.getString("nom")); 
	               temp.setUsername(result.getString("username")); 
	               temp.setPassword(result.getString("password")); 
	
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
    public Diagnostique getObjectDiagnostique(int iddiagnostique) throws SQLException {

        Diagnostique valueObject = new Diagnostique();
        valueObject.setCode(iddiagnostique);
        loadDiagnostique(valueObject);
        return valueObject;
  }


   
  public void loadDiagnostique(Diagnostique valueObject) throws SQLException {

        String sql = "SELECT * FROM diagnostique WHERE (iddiagnostique = ? ) "; 
        PreparedStatement stmt = null;

        try {
             stmt = cnx.prepareStatement(sql);
             stmt.setInt(1, valueObject.getCode()); 

             singleQueryDiagnostique(stmt, valueObject);

        } finally {
            if (stmt != null)
                stmt.close();
        }
  }


  
  public List loadAllDiagnostique() throws SQLException {

        String sql = "SELECT * FROM diagnostique ORDER BY iddiagnostique ASC ";
        List searchResults = listQueryDiagnostique(cnx.prepareStatement(sql));

        return searchResults;
  }



  
  public void createDiagnostique(Diagnostique valueObject) throws SQLException {

        String sql = "";
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
             sql = "INSERT INTO diagnostique ( resultat, etat, "
             + "rendezvous_idrendezvous) VALUES (?, ?, ?) ";
             stmt = cnx.prepareStatement(sql);

             stmt.setString(1, valueObject.getResultat()); 
             stmt.setString(2, valueObject.getEtat()); 
             stmt.setInt(3, valueObject.getCodeRendezVous()); 

             int rowcount = databaseUpdateDiagnostique(stmt);
             if (rowcount != 1) {
                  //System.out.println("PrimaryKey Error when updating DB!");
                  throw new SQLException("PrimaryKey Error when updating DB!");
             }

        } finally {
            if (stmt != null)
                stmt.close();
        }


  }


  
  public void updateDiagnostique(Diagnostique valueObject) 
        throws SQLException {

        String sql = "UPDATE diagnostique SET resultat = ?, etat = ?, rendezvous_idrendezvous = ? WHERE (iddiagnostique = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = cnx.prepareStatement(sql);
            stmt.setString(1, valueObject.getResultat()); 
            stmt.setString(2, valueObject.getEtat()); 
            stmt.setInt(3, valueObject.getCodeRendezVous()); 

            stmt.setInt(4, valueObject.getCode()); 

            int rowcount = databaseUpdateDiagnostique(stmt);
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


   
  public void deleteDiagnostique(Diagnostique valueObject) 
        throws SQLException {

        String sql = "DELETE FROM diagnostique WHERE (iddiagnostique = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = cnx.prepareStatement(sql);
            stmt.setInt(1, valueObject.getCode()); 

            int rowcount = databaseUpdateDiagnostique(stmt);
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


   
  public void deleteAllDiagnostique() throws SQLException {

        String sql = "DELETE FROM diagnostique";
        PreparedStatement stmt = null;

        try {
            stmt = cnx.prepareStatement(sql);
            int rowcount = databaseUpdateDiagnostique(stmt);
        } finally {
            if (stmt != null)
                stmt.close();
        }
  }


  
  public int countAllDiagnostique() throws SQLException {

        String sql = "SELECT count(*) FROM diagnostique";
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


 
  public List searchMatchingDiagnostique(Diagnostique valueObject) throws SQLException {

        List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT * FROM diagnostique WHERE 1=1 ");

        if (valueObject.getCode() != 0) {
            if (first) { first = false; }
            sql.append("AND iddiagnostique = ").append(valueObject.getCode()).append(" ");
        }

        if (valueObject.getResultat() != null) {
            if (first) { first = false; }
            sql.append("AND resultat LIKE '").append(valueObject.getResultat()).append("%' ");
        }

        if (valueObject.getEtat() != null) {
            if (first) { first = false; }
            sql.append("AND etat LIKE '").append(valueObject.getEtat()).append("%' ");
        }

        if (valueObject.getCodeRendezVous() != 0) {
            if (first) { first = false; }
            sql.append("AND rendezvous_idrendezvous = ").append(valueObject.getCodeRendezVous()).append(" ");
        }


        sql.append("ORDER BY iddiagnostique ASC ");

        // Prevent accidential full table results.
        // Use loadAll if all rows must be returned.
        if (first)
             searchResults = new ArrayList();
        else
             searchResults = listQueryDiagnostique(cnx.prepareStatement(sql.toString()));

        return searchResults;
  }


  
  protected int databaseUpdateDiagnostique(PreparedStatement stmt) throws SQLException {
        int result = stmt.executeUpdate();
        return result;
  }



     protected void singleQueryDiagnostique(PreparedStatement stmt, Diagnostique valueObject) 
        throws SQLException {

        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            if (result.next()) {

                 valueObject.setCode(result.getInt("iddiagnostique")); 
                 valueObject.setResultat(result.getString("resultat")); 
                 valueObject.setEtat(result.getString("etat")); 
                 valueObject.setCodeRendezVous(result.getInt("rendezvous_idrendezvous")); 

            } else {
                   System.out.println("Diagnostique Object Not Found!");
                  //throw new NotFoundException("Diagnostique Object Not Found!");
            }
        } finally {
            if (result != null)
                result.close();
            if (stmt != null)
                stmt.close();
        }
  }


  protected List listQueryDiagnostique(PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                 Diagnostique temp = new Diagnostique();

                 temp.setCode(result.getInt("iddiagnostique")); 
                 temp.setResultat(result.getString("resultat")); 
                 temp.setEtat(result.getString("etat")); 
                 temp.setCodeRendezVous(result.getInt("rendezvous_idrendezvous")); 

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
  
  public RendezVous getObjectRendezVous( int code) throws SQLException {

  	RendezVous valueObject = new RendezVous();
        valueObject.setCode(code);
        loadRendezVous(valueObject);
        return valueObject;
  }



  public void loadRendezVous( RendezVous valueObject) throws SQLException {

        String sql = "SELECT * FROM rendezvous WHERE (idrendezvous = ? ) "; 
        PreparedStatement stmt = null;

        try {
             stmt = cnx.prepareStatement(sql);
             stmt.setInt(1, valueObject.getCode()); 

             singleQueryRendezVous(stmt, valueObject);

        } finally {
            if (stmt != null)
                stmt.close();
        }
  }

  public List loadAllRendezVous() throws SQLException {

        String sql = "SELECT * FROM rendezvous ORDER BY idrendezvous ASC ";
        List searchResults = listQueryRendezVous(cnx.prepareStatement(sql));

        return searchResults;
  }



  public synchronized void createRendezVous( RendezVous valueObject) throws SQLException {

        String sql = "";
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
             sql = "INSERT INTO rendezvous ( jour, heure, "
             + "medecin_matricule, patient_idpatient) VALUES (?, ?, ?, ?) ";
             stmt = cnx.prepareStatement(sql);

             stmt.setString(1, valueObject.getJour()); 
             stmt.setString(2, valueObject.getHeure()); 
             stmt.setInt(3, valueObject.getCodeMedecin()); 
             stmt.setInt(4, valueObject.getCodePatient()); 

             int rowcount = databaseUpdateRendezVous(stmt);
             if (rowcount != 1) {
                  //System.out.println("PrimaryKey Error when updating DB!");
                  throw new SQLException("PrimaryKey Error when updating DB!");
             }

        } finally {
            if (stmt != null)
                stmt.close();
        }


  }


  public void updateRendezVous( RendezVous valueObject) 
        throws SQLException {

        String sql = "UPDATE rendezvous SET jour = ?, heure = ?, medecin_matricule = ?, "
             + "patient_idpatient = ? WHERE (idrendezvous = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = cnx.prepareStatement(sql);
            stmt.setString(1, valueObject.getJour()); 
            stmt.setString(2, valueObject.getHeure()); 
            stmt.setInt(3, valueObject.getCodeMedecin()); 
            stmt.setInt(4, valueObject.getCodePatient()); 

            stmt.setInt(5, valueObject.getCode()); 

            int rowcount = databaseUpdateRendezVous(stmt);
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


 
  public void deleteRendezVous( RendezVous valueObject) 
        throws SQLException {

        String sql = "DELETE FROM rendezvous WHERE (idrendezvous = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = cnx.prepareStatement(sql);
            stmt.setInt(1, valueObject.getCode()); 

            int rowcount = databaseUpdateRendezVous(stmt);
            if (rowcount == 0) {
                 System.out.println("Object could not be deleted (PrimaryKey not found)");
                 //throw new NotFoundException("Object could not be deleted! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                 //System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                 throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
            }
        } finally {
            if (stmt != null)
                stmt.close();
        }
  }


   
  public void deleteAllRendezVous() throws SQLException {

        String sql = "DELETE FROM rendezvous";
        PreparedStatement stmt = null;

        try {
            stmt = cnx.prepareStatement(sql);
            int rowcount = databaseUpdateRendezVous(stmt);
        } finally {
            if (stmt != null)
                stmt.close();
        }
  }

  public int countAllRendezVous() throws SQLException {

        String sql = "SELECT count(*) FROM rendezvous";
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


  
  
  public List searchMatchingRendezVous( RendezVous valueObject) throws SQLException {

        List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT * FROM rendezvous WHERE 1=1 ");

        if (valueObject.getCode() != 0) {
            if (first) { first = false; }
            sql.append("AND idrendezvous = ").append(valueObject.getCode()).append(" ");
        }

        if (valueObject.getJour() != null) {
            if (first) { first = false; }
            sql.append("AND jour LIKE '").append(valueObject.getJour()).append("%' ");
        }

        if (valueObject.getHeure() != null) {
            if (first) { first = false; }
            sql.append("AND heure LIKE '").append(valueObject.getHeure()).append("%' ");
        }

        if (valueObject.getCodeMedecin() != 0) {
            if (first) { first = false; }
            sql.append("AND medecin_matricule LIKE '").append(valueObject.getCodeMedecin()).append("%' ");
        }

        if (valueObject.getCodePatient() != 0) {
            if (first) { first = false; }
            sql.append("AND patient_idpatient LIKE '").append(valueObject.getCodePatient()).append("%' ");
        }


        sql.append("ORDER BY idrendezvous ASC ");

        // Prevent accidential full table results.
        // Use loadAll if all rows must be returned.
        if (first)
             searchResults = new ArrayList();
        else
             searchResults = listQueryRendezVous(cnx.prepareStatement(sql.toString()));

        return searchResults;
  }


  

  protected int databaseUpdateRendezVous( PreparedStatement stmt) throws SQLException {

        int result = stmt.executeUpdate();

        return result;
  }



  protected void singleQueryRendezVous( PreparedStatement stmt, RendezVous valueObject) 
        throws SQLException {

        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            if (result.next()) {

                 valueObject.setCode(result.getInt("idrendezvous")); 
                 valueObject.setJour(result.getString("jour")); 
                 valueObject.setHeure(result.getString("heure")); 
                 valueObject.setCodeMedecin(result.getInt("medecin_matricule")); 
                 valueObject.setCodePatient(result.getInt("patient_idpatient")); 

            } else {
                  System.out.println("Rendezvous Object Not Found!");
                  //throw new NotFoundException("Rendezvous Object Not Found!");
            }
        } finally {
            if (result != null)
                result.close();
            if (stmt != null)
                stmt.close();
        }
  }


   
  protected List listQueryRendezVous( PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
          	  RendezVous temp = new RendezVous();

                 temp.setCode(result.getInt("idrendezvous")); 
                 temp.setJour(result.getString("jour")); 
                 temp.setHeure(result.getString("heure")); 
                 temp.setCodeMedecin(result.getInt("medecin_matricule")); 
                 temp.setCodePatient(result.getInt("patient_idpatient")); 

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
  
  public Patient getObjectPatient( int matricule) throws   SQLException {

      Patient valueObject = new Patient();
      valueObject.setMatricule(matricule);
      loadPatient(valueObject);
      return valueObject;
}


public void loadPatient( Patient valueObject) throws  SQLException {

      String sql = "SELECT * FROM Patient WHERE (matricule = ? ) "; 
      PreparedStatement stmt = null;

      try {
           stmt = cnx.prepareStatement(sql);
           stmt.setInt(1, valueObject.getMatricule()); 

           singleQueryPatient( stmt, valueObject);

      } finally {
          if (stmt != null)
              stmt.close();
      }
}



public List loadAllPatient( ) throws SQLException {

      String sql = "SELECT * FROM Patient ORDER BY matricule ASC ";
      List searchResults = listQueryPatient(cnx.prepareStatement(sql));

      return searchResults;
}

public void createPatient(Patient valueObject) throws SQLException {

      String sql = "";
      PreparedStatement stmt = null;
      ResultSet result = null;

      try {
           sql = "INSERT INTO Patient (prenom, nom,pato) VALUES ( ?, ?, ?) ";
           stmt = cnx.prepareStatement(sql);

           stmt.setString(1, valueObject.getPrenom()); 
           stmt.setString(2, valueObject.getNom());  
           stmt.setString(3, valueObject.getPato()); 

           int rowcount = databaseUpdatePatient(stmt);
           if (rowcount != 1) {
                //System.out.println("PrimaryKey Error when updating DB!");
                throw new SQLException("PrimaryKey Error when updating DB!");
           }

      } finally {
          if (stmt != null)
              stmt.close();
      }


}



public void updatePatient( Patient valueObject) 
      throws  SQLException {

      String sql = "UPDATE Patient SET prenom = ?, nom = ?, "
           + "pato = ? WHERE (matricule = ? ) ";
      PreparedStatement stmt = null;

      try {
          stmt = cnx.prepareStatement(sql);
          stmt.setString(1, valueObject.getPrenom()); 
          stmt.setString(2, valueObject.getNom()); 
          stmt.setString(3, valueObject.getPato());  

          stmt.setInt(4, valueObject.getMatricule()); 

          int rowcount = databaseUpdatePatient( stmt);
          if (rowcount == 0) {
               System.out.println("Object could not be saved! (PrimaryKey not found)");
             //Patientow new NotFoundException("Object could not be saved! (PrimaryKey not found)");
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



public void deletePatient(  Patient valueObject) 
      throws  SQLException {

      String sql = "DELETE FROM Patient WHERE (matricule = ? ) ";
      PreparedStatement stmt = null;

      try {
          stmt = cnx.prepareStatement(sql);
          stmt.setInt(1, valueObject.getMatricule()); 

          int rowcount = databaseUpdatePatient(stmt);
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



public void deleteAllPatient() throws SQLException {

      String sql = "DELETE FROM Patient";
      PreparedStatement stmt = null;

      try {
          stmt = cnx.prepareStatement(sql);
          int rowcount = databaseUpdatePatient(stmt);
      } finally {
          if (stmt != null)
              stmt.close();
      }
}

public int countAllPatient() throws SQLException {

      String sql = "SELECT count(*) FROM Patient";
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

public List searchMatchingPatient(Patient valueObject) throws SQLException {

      List searchResults;

      boolean first = true;
      StringBuffer sql = new StringBuffer("SELECT * FROM Patient WHERE 1=1 ");

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

      if (valueObject.getPato() != null) {
          if (first) { first = false; }
          sql.append("AND specialite LIKE '").append(valueObject.getPato()).append("%' ");
      }


      sql.append("ORDER BY matricule ASC ");

      // Prevent accidential full table results.
      // Use loadAll if all rows must be returned.
      if (first)
           searchResults = new ArrayList();
      else
           searchResults = listQueryPatient(cnx.prepareStatement(sql.toString()));

      return searchResults;
}




protected int databaseUpdatePatient( PreparedStatement stmt) throws SQLException {

      int result = stmt.executeUpdate();

      return result;
}




protected void singleQueryPatient( PreparedStatement stmt, Patient valueObject) 
      throws SQLException {

      ResultSet result = null;

      try {
          result = stmt.executeQuery();

          if (result.next()) {

               valueObject.setMatricule(result.getInt("matricule")); 
               valueObject.setPrenom(result.getString("prenom")); 
               valueObject.setNom(result.getString("nom")); 
               valueObject.setPato(result.getString("pato")); 

          } else {
                System.out.println("Patient Object Not Found!");
                //throw new NotFoundException("Patient Object Not Found!");
          }
      } finally {
          if (result != null)
              result.close();
          if (stmt != null)
              stmt.close();
      }
}



protected List listQueryPatient( PreparedStatement stmt) throws SQLException {

      ArrayList searchResults = new ArrayList();
      ResultSet result = null;

      try {
          result = stmt.executeQuery();

          while (result.next()) {
               Patient temp = new Patient();

               temp.setMatricule(result.getInt("matricule")); 
               temp.setPrenom(result.getString("prenom")); 
               temp.setNom(result.getString("nom")); 
               temp.setPato(result.getString("pato")); 

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
	
}