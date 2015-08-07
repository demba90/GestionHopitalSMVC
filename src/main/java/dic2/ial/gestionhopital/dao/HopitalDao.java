package dic2.ial.gestionhopital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dic2.ial.gestionhopital.modele.Admin;
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
	
	@Override
	public void addMedecin(Medecin m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Medecin getMedecin(String mat) {
		// TODO Auto-generated method stub
		return null;
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
	public Patient getPatient(String code) {
		// TODO Auto-generated method stub
		return null;
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
}
