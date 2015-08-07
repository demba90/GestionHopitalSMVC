package dic2.ial.gestionhopital.modele;

import java.io.Serializable;

public class RendezVous implements Serializable {
	private String code;
	private String jour;
	private String heure;
	private String codeMedecin;
	private String codePatient;
	
	public RendezVous() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodePatient() {
		return codePatient;
	}
	public void setCodePatient(String codePatient) {
		this.codePatient = codePatient;
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
	public String getCodeMedecin() {
		return codeMedecin;
	}
	public void setCodeMedecin(String codeMedecin) {
		this.codeMedecin = codeMedecin;
	}
	
	

}
