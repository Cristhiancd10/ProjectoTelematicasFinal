package ec.edu.ups.objetos;

import java.io.Serializable;

public class User implements Serializable {

	private String mail;
	private String clave;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
