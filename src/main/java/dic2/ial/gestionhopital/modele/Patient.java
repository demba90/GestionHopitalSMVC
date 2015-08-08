package dic2.ial.gestionhopital.modele;

import java.io.Serializable;

public class Patient implements Serializable {
	private int matricule;
	private String nom;
	private String prenom;
	private String pato;
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
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

	public String getPato() {
		return pato;
	}

	public void setPato(String pato) {
		this.pato = pato;
	}
}
