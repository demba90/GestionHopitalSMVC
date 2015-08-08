package dic2.ial.gestionhopital.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dic2.ial.gestionhopital.modele.User;
import dic2.ial.gestionhopital.modele.Medecin;
import dic2.ial.gestionhopital.modele.Secretaire;
import dic2.ial.gestionhopital.modele.Patient;

public interface IHopitalDao {
	//CRUD mdecin
	public void saveMedecin( Medecin valueObject) throws  SQLException;
	public Medecin getMedecin(int mat);
	public void updateMedecin(Medecin m);
	public Medecin getObjectMedecin( int matricule) throws   SQLException;
	public List loadAllMedecin( ) throws SQLException;
	public void createMedecin(Medecin valueObject) throws SQLException;
	public void deleteMedecin(  Medecin valueObject) throws  SQLException;
	public void deleteAllMedecin() throws SQLException ;
	public int countAllMedecin() throws SQLException ;
	 public List searchMatchingMedecin(Medecin valueObject) throws SQLException;
	
	//CRUD secretaire
	public void addSecretaire(Secretaire s);
	public Medecin getSecretaire(int code);
	public ArrayList<Secretaire> getAllSecretaire();
	public void updateSecretaire(Secretaire s);
	public void deleteSecretaire(Secretaire s);
	
	//CRUD patient
	public void addPatient(Patient p);
	public Patient getPatient(int code);
	public ArrayList<Patient> getAllPatient();
	public void updatePatient(Patient p);
	public void deletePatient(Patient p);
	
	//CRUD rendezvous
	public void addRendezVous(Patient p, Medecin m);
	
	//CRUD user
	public void addAdmin(User user);
	public boolean authentification(User user);
}
