package dic2.ial.gestionhopital.modele;

import java.io.Serializable;

public class Secretaire implements Serializable{
	private int matricule;
	private String nom;
	private String prenom;
	private String username;
	private String password;
	
	public Secretaire() {
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
