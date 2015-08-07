package dic2.ial.gestionhopital.modele;

import java.io.Serializable;

public class Patient implements Serializable {
	private int code;
	private String nom;
	private String prenom;
	private String pato;
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(int code, String nom, String prenom) {
		super();
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
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
