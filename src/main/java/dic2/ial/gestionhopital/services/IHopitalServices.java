package dic2.ial.gestionhopital.services;

import java.util.ArrayList;

import dic2.ial.gestionhopital.modele.Admin;
import dic2.ial.gestionhopital.modele.Medecin;
import dic2.ial.gestionhopital.modele.Secretaire;
import dic2.ial.gestionhopital.modele.Patient;

public interface IHopitalServices {
	//CRUD mdecin
	public void addMedecin(Medecin m);
	public Medecin getMedecin(String mat);
	public ArrayList<Medecin> getAllMedecin();
	public void updateMedecin(Medecin m);
	public void deleteMedecin(Medecin m);
	
	//CRUD patient
	public void addPatient(Patient p);
	public Patient getPatient(String code);
	public ArrayList<Patient> getAllPatient();
	public void updatePatient(Patient p);
	public void deletePatient(Patient p);
	
}
