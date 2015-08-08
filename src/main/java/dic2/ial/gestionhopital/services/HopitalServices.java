package dic2.ial.gestionhopital.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dic2.ial.gestionhopital.dao.IHopitalDao;
import dic2.ial.gestionhopital.modele.Diagnostique;
import dic2.ial.gestionhopital.modele.Patient;
import dic2.ial.gestionhopital.modele.RendezVous;
import dic2.ial.gestionhopital.modele.Secretaire;
import dic2.ial.gestionhopital.modele.Medecin;

public class HopitalServices implements IHopitalServices{
	private IHopitalDao dao;
	
	//setters pour l'injection des dépendances 
	public void setDao(IHopitalDao dao) {
		this.dao = dao;
	}
	
	
	@Override
	public void createMedecin(Medecin m) {
		try {
			dao.createMedecin(m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Medecin getObjectMedecin(int mat) {
		try {
			return dao.getObjectMedecin(mat);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<Medecin> loadAllMedecin() {
		try {
			return (ArrayList<Medecin>) dao.loadAllMedecin();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateMedecin(Medecin m) {
		try {
			dao.updateMedecin(m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMedecin(Medecin m) {
		try {
			dao.deleteMedecin(m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteAllMedecin() throws SQLException {
		dao.deleteAllMedecin();
	}

	@Override
	public int countAllMedecin() throws SQLException {
		return dao.countAllMedecin();
	}

	@Override
	public List searchMatchingMedecin(Medecin valueObject) throws SQLException {
		return dao.searchMatchingMedecin(valueObject);
	}

	@Override
	public void createSecretaire(Secretaire s) {
		try {
			dao.createSecretaire(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Secretaire getObjectSecretaire(int code) {
		try {
			return dao.getObjectSecretaire(code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Secretaire> loadAllSecretaire() {
		try {
			return (ArrayList<Secretaire>) dao.loadAllSecretaire();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateSecretaire(Secretaire s) {
		try {
			dao.updateSecretaire(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteSecretaire(Secretaire s) {
		try {
			dao.deleteSecretaire(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void deleteAllSecretaire() throws SQLException {
		dao.deleteAllSecretaire();
		
	}


	@Override
	public int countAllSecretaire() throws SQLException {
		return dao.countAllSecretaire();
	}


	@Override
	public List searchMatchingSecretaire(Secretaire valueObject)
			throws SQLException {
		return dao.searchMatchingSecretaire(valueObject);
	}


	@Override
	public Diagnostique getObjectDiagnostique(int iddiagnostique)
			throws SQLException {
		return dao.getObjectDiagnostique(iddiagnostique);
	}


	@Override
	public void loadDiagnostique(Diagnostique valueObject) throws SQLException {
		dao.loadDiagnostique(valueObject);
	}


	@Override
	public List loadAllDiagnostique() throws SQLException {
		return dao.loadAllDiagnostique();
	}


	@Override
	public void createDiagnostique(Diagnostique valueObject)
			throws SQLException {
		dao.createDiagnostique(valueObject);
	}


	@Override
	public void updateDiagnostique(Diagnostique valueObject)
			throws SQLException {
		dao.updateDiagnostique(valueObject);
	}


	@Override
	public void deleteDiagnostique(Diagnostique valueObject)
			throws SQLException {
		dao.deleteDiagnostique(valueObject);
	}


	@Override
	public void deleteAllDiagnostique() throws SQLException {
		dao.deleteAllDiagnostique();
	}


	@Override
	public int countAllDiagnostique() throws SQLException {
		return dao.countAllDiagnostique();
	}


	@Override
	public List searchMatchingDiagnostique(Diagnostique valueObject)
			throws SQLException {
		
		return dao.searchMatchingDiagnostique(valueObject);
	}


	@Override
	public RendezVous getObjectRendezVous(int code) throws SQLException {
		return dao.getObjectRendezVous(code);
	}


	@Override
	public void loadRendezVous(RendezVous valueObject) throws SQLException {
		dao.loadRendezVous(valueObject);
	}


	@Override
	public List loadAllRendezVous() throws SQLException {
		return dao.loadAllRendezVous();
	}


	@Override
	public void createRendezVous(RendezVous valueObject) throws SQLException {
		dao.createRendezVous(valueObject);
	}


	@Override
	public void updateRendezVous(RendezVous valueObject) throws SQLException {
		dao.updateRendezVous(valueObject);
	}


	@Override
	public void deleteRendezVous(RendezVous valueObject) throws SQLException {
		dao.deleteRendezVous(valueObject);
	}


	@Override
	public void deleteAllRendezVous() throws SQLException {
		dao.deleteAllRendezVous();
	}


	@Override
	public int countAllRendezVous() throws SQLException {
		return dao.countAllRendezVous();
	}


	@Override
	public List searchMatchingRendezVous(RendezVous valueObject)
			throws SQLException {
		return dao.searchMatchingRendezVous(valueObject);
	}


	@Override
	public Patient getObjectPatient(int matricule) throws SQLException {
		return dao.getObjectPatient(matricule);
	}


	@Override
	public void loadPatient(Patient valueObject) throws SQLException {
		dao.loadPatient(valueObject);
	}


	@Override
	public List loadAllPatient() throws SQLException {
		return dao.loadAllPatient();
	}


	@Override
	public void createPatient(Patient valueObject) throws SQLException {
		dao.createPatient(valueObject);	
	}


	@Override
	public void updatePatient(Patient valueObject) throws SQLException {
		dao.updatePatient(valueObject);
	}


	@Override
	public void deletePatient(Patient valueObject) throws SQLException {
		dao.deletePatient(valueObject);
	}


	@Override
	public void deleteAllPatient() throws SQLException {
		dao.deleteAllPatient();
	}


	@Override
	public int countAllPatient() throws SQLException {
		return dao.countAllPatient();
	}


	@Override
	public List searchMatchingPatient(Patient valueObject) throws SQLException {
		return dao.searchMatchingPatient(valueObject);
	}


	public void loadMedecin(Medecin valueObject) throws SQLException {
		dao.loadMedecin(valueObject);
	}
}
