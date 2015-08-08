package dic2.ial.gestionhopital.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dic2.ial.gestionhopital.modele.Diagnostique;
import dic2.ial.gestionhopital.modele.RendezVous;
import dic2.ial.gestionhopital.modele.User;
import dic2.ial.gestionhopital.modele.Medecin;
import dic2.ial.gestionhopital.modele.Secretaire;
import dic2.ial.gestionhopital.modele.Patient;

public interface IHopitalServices {
	//CRUD mdecin
		public void updateMedecin( Medecin valueObject) throws  SQLException; 
		public Medecin getObjectMedecin( int matricule) throws   SQLException;
		public List loadAllMedecin( ) throws SQLException;
		public void loadMedecin( Medecin valueObject) throws  SQLException;
		public void createMedecin(Medecin valueObject) throws SQLException;
		public void deleteMedecin(  Medecin valueObject) throws  SQLException;
		public void deleteAllMedecin() throws SQLException ;
		public int countAllMedecin() throws SQLException ;
		public List searchMatchingMedecin(Medecin valueObject) throws SQLException;
		
		//CRUD secretaire
		public void updateSecretaire( Secretaire valueObject) throws  SQLException; 
		public Secretaire getObjectSecretaire( int matricule) throws   SQLException;
		public List loadAllSecretaire( ) throws SQLException;
		public void createSecretaire(Secretaire valueObject) throws SQLException;
		public void deleteSecretaire(  Secretaire valueObject) throws  SQLException;
		public void deleteAllSecretaire() throws SQLException ;
		public int countAllSecretaire() throws SQLException ;
		public List searchMatchingSecretaire(Secretaire valueObject) throws SQLException;
		
		//services pour diagnostique
		 public Diagnostique getObjectDiagnostique(int iddiagnostique) throws SQLException;
		 public void loadDiagnostique(Diagnostique valueObject) throws SQLException;
		 public List loadAllDiagnostique() throws SQLException;
		 public void createDiagnostique(Diagnostique valueObject) throws SQLException ;
		 public void updateDiagnostique(Diagnostique valueObject) throws SQLException ;
		 public void deleteDiagnostique(Diagnostique valueObject) throws SQLException;
		 public void deleteAllDiagnostique() throws SQLException ;
		 public int countAllDiagnostique() throws SQLException ;
		 public List searchMatchingDiagnostique(Diagnostique valueObject) throws SQLException ;
		 
		 //service pour un rendez-vous
		 public RendezVous getObjectRendezVous( int code) throws SQLException;
		 public void loadRendezVous( RendezVous valueObject) throws SQLException;
		 public List loadAllRendezVous() throws SQLException;
		 public void createRendezVous( RendezVous valueObject) throws SQLException;
		 public void updateRendezVous( RendezVous valueObject) throws SQLException ;
		 public void deleteRendezVous( RendezVous valueObject) throws SQLException ;
		 public void deleteAllRendezVous() throws SQLException;
		 public int countAllRendezVous() throws SQLException;
		 public List searchMatchingRendezVous( RendezVous valueObject) throws SQLException;
		 
		//services pour un patient
		 public Patient getObjectPatient( int matricule) throws   SQLException;
		 public void loadPatient( Patient valueObject) throws  SQLException;
		 public List loadAllPatient( ) throws SQLException;
		 public void createPatient(Patient valueObject) throws SQLException;
		 public void updatePatient( Patient valueObject) throws  SQLException ;
		 public void deletePatient(  Patient valueObject) throws  SQLException;
		 public void deleteAllPatient() throws SQLException;
		 public int countAllPatient() throws SQLException;
		 public List searchMatchingPatient(Patient valueObject) throws SQLException ;
		 
		 
}
