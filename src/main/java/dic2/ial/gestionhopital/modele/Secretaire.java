package dic2.ial.gestionhopital.modele;

import java.io.Serializable;

public class Secretaire implements Serializable{
	
	private int code ;
	private String nom;
	private String prenom;
	
	public Secretaire() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
	
	
	
}
