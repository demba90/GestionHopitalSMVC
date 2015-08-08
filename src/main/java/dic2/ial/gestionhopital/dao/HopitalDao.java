package dic2.ial.gestionhopital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
			//connexion � la base de donn�es
			cnx = DriverManager.getConnection ("jdbc:mysql://localhost/hopital","root","") ;
                        //creation d'une connexion
                        
		}
		catch (Exception se )
		{
			System.out.println("Erreur de connexion "+ se.getMessage());
		}
    }
	
	@Override
	public void addMedecin(Medecin m) {
		boolean res = false;
		int rowsaffected = 0 ;
		try
		{
			stmt = cnx.prepareStatement("insert into agence(nomag,adresseag) values (?,?) ") ;
			stmt.setString(1, age.getNomag()) ;
			stmt.setString(2, age.getAdresseag()) ;
			rowsaffected = stmt.executeUpdate();
			if(rowsaffected > 0)
				res = true ;
		}
		catch (Exception e)
		{
			e.getMessage() ;
		}
		return res ;
		
	}

	@Override
	public ArrayList<Medecin> getAllMedecin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMedecin(Medecin m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMedecin(Medecin m) {
		// TODO Auto-generated method stub
		
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
	public Medecin getMedecin(int mat) {
		// TODO Auto-generated method stub
		return null;
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
}
