package dic2.ial.gestionhopital.dao;

import java.util.ArrayList;

import dic2.ial.gestionhopital.modele.User;
import dic2.ial.gestionhopital.modele.Medecin;
import dic2.ial.gestionhopital.modele.Secretaire;
import dic2.ial.gestionhopital.modele.Patient;

public interface IHopitalDao {
	//CRUD mdecin
	public void addMedecin(Medecin m);
	public Medecin getMedecin(int mat);
	public ArrayList<Medecin> getAllMedecin();
	public void updateMedecin(Medecin m);
	public void deleteMedecin(Medecin m);
	
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
