package dic2.ial.gestionhopital.modele;

import java.io.Serializable;

public class Secretaire extends User implements Serializable{
	
	private int code ;
	
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
	
}
