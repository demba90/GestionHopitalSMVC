package dic2.ial.gestionhopital.services;

import java.util.ArrayList;

import dic2.ial.gestionhopital.dao.IHopitalDao;
import dic2.ial.gestionhopital.modele.Admin;
import dic2.ial.gestionhopital.modele.Medecin;
import dic2.ial.gestionhopital.modele.Secretaire;
import dic2.ial.gestionhopital.modele.Patient;

public class HopitalServices implements IHopitalServices{
	private IHopitalDao dao;
	
	//setters pour l'injection des dépendances 
	public void setDao(IHopitalDao dao) {
		this.dao = dao;
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
