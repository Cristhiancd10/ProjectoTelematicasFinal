package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Usuario implements Serializable {

	@Id
	@NotNull
	private String cedula;
	@Pattern(regexp = "[^0-9]*", message = "Campo no admite numeros")
	@NotNull
	private String nombre;
	@Pattern(regexp = "[^0-9]*", message = "Campo no admite numeros")
	@NotNull
	private String apellido;
	@Email
	@NotEmpty
	private String mail;
	@NotNull
	private String clave;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<UsuarioEmpleador> usuarioEmpleador;
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Factura> facturas;

	public Usuario() {

	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

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

	public List<UsuarioEmpleador> getUsuarioEmpleador() {
		return usuarioEmpleador;
	}

	public void setUsuarioEmpleador(List<UsuarioEmpleador> usuarioEmpleador) {
		this.usuarioEmpleador = usuarioEmpleador;
	}


	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail
				+ ", clave=" + clave + ", usuarioEmpleador=" + usuarioEmpleador + ", facturas=" + facturas + "]";
	}

}
