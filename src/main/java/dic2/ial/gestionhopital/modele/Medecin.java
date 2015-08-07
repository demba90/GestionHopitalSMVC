package dic2.ial.gestionhopital.modele;

import java.io.Serializable;

public class Medecin implements Serializable {
	private String matricule;
	private String nom;
	private String prenom;
	private String specialite;
	
	public Medecin() {
		super();
	}
	
	public Medecin(String matricule, String nom, String prenom,
			String specialite) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.specialite = specialite;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	
	
}
