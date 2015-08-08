package dic2.ial.gestionhopital.services;

import java.util.ArrayList;

import dic2.ial.gestionhopital.dao.IHopitalDao;
import dic2.ial.gestionhopital.modele.Secretaire;
import dic2.ial.gestionhopital.modele.User;
import dic2.ial.gestionhopital.modele.Medecin;
import dic2.ial.gestionhopital.modele.Patient;

public class HopitalServices implements IHopitalServices{
	private IHopitalDao dao;
	
	//setters pour l'injection des dépendances 
	public void setDao(IHopitalDao dao) {
		this.dao = dao;
	}
	
	@Override
	public void addMedecin(Medecin m) {
		dao.addMedecin(m); 
	}

	@Override
	public Medecin getMedecin(int mat) {
		return dao.getMedecin(mat);
	}

	@Override
	public ArrayList<Medecin> getAllMedecin() {
		return dao.getAllMedecin();
	}

	@Override
	public void updateMedecin(Medecin m) {
		dao.updateMedecin(m);
	}

	@Override
	public void deleteMedecin(Medecin m) {
		dao.deleteMedecin(m);
		
	}

	@Override
	public void addPatient(Patient p) {
		dao.addPatient(p);
		
	}

	@Override
	public ArrayList<Patient> getAllPatient() {
		return dao.getAllPatient();
	}

	@Override
	public void updatePatient(Patient p) {
		dao.updatePatient(p);
	}

	@Override
	public void deletePatient(Patient p) {
		dao.updatePatient(p);
	}

	@Override
	public void addRendezVous(Patient p, Medecin m) {
		dao.addRendezVous(p, m);
	}

	@Override
	public void addAdmin(User user) {
		dao.addAdmin(user);
	}

	@Override
	public boolean authentification(User user) {
		return dao.authentification(user);
	}

	@Override
	public void addSecretaire(Secretaire s) {
		dao.addSecretaire(s);
		
	}

	@Override
	public Medecin getSecretaire(int code) {
		return dao.getSecretaire(code);
	}

	@Override
	public ArrayList<Secretaire> getAllSecretaire() {
		return dao.getAllSecretaire();
	}

	@Override
	public void updateSecretaire(Secretaire m) {
		dao.updateSecretaire(m);
		
	}

	@Override
	public void deleteSecretaire(Secretaire s) {
		dao.deleteSecretaire(s);
	}

	@Override
	public Patient getPatient(int code) {
		return dao.getPatient(code);
	}
}
