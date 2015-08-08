package dic2.ial.gestionhopital.modele;

import java.io.Serializable;

public class Medecin extends User  implements Serializable {
	private int matricule;
	private String specialite;
	
	public Medecin() {
		super();
	}
	
	public Medecin(int matricule,String specialite) {
		super();
		this.matricule = matricule;
		this.specialite = specialite;
	}
	public int getMatricule() {
		return matricule;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	
	
}
