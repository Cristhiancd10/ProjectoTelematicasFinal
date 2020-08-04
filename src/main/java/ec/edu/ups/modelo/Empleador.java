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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Empleador implements Serializable {

	@Id
	@NotNull
	private String ruc;
	@Pattern(regexp = "[^0-9]*", message = "Campo no admite numeros")
	@NotEmpty
	private String nombre;
	private String razon;
	@OneToMany(mappedBy = "empleador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<UsuarioEmpleador> usuarioEmpleador;

	public Empleador() {

	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRazon() {
		return razon;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}

	public List<UsuarioEmpleador> getUsuarioEmpleador() {
		return usuarioEmpleador;
	}

	public void setUsuarioEmpleador(List<UsuarioEmpleador> usuarioEmpleador) {
		this.usuarioEmpleador = usuarioEmpleador;
	}

	@Override
	public String toString() {
		return "Empleador [ruc=" + ruc + ", nombre=" + nombre + ", razon=" + razon + ", usuarioEmpleador="
				+ usuarioEmpleador + "]";
	}

}
