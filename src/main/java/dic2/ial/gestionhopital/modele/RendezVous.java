package dic2.ial.gestionhopital.modele;

import java.io.Serializable;

public class RendezVous implements Serializable {
	private int code;
	private String jour;
	private String heure;
	private int codeMedecin;
	private int codePatient;
	
	public RendezVous() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public int getCodeMedecin() {
		return codeMedecin;
	}

	public void setCodeMedecin(int codeMedecin) {
		this.codeMedecin = codeMedecin;
	}

	public int getCodePatient() {
		return codePatient;
	}

	public void setCodePatient(int codePatient) {
		this.codePatient = codePatient;
	}	
	

}
