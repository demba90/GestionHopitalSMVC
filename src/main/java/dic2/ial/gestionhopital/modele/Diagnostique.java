package dic2.ial.gestionhopital.modele;

import java.io.Serializable;

public class Diagnostique implements Serializable{
	private int codeRendezVous;
	private int code;
	private String etat;
	private String resultat;
	
	public Diagnostique() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public int getCodeRendezVous() {
		return codeRendezVous;
	}



	public void setCodeRendezVous(int codeRendezVous) {
		this.codeRendezVous = codeRendezVous;
	}



	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
}
