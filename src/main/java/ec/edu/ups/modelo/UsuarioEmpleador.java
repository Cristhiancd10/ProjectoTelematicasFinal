package ec.edu.ups.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class UsuarioEmpleador implements Serializable {

	@Id
	@NotNull
	private int codigo;
	@NotNull
	private double totalIngresos;
	@NotNull
	private int anio;

	@OneToOne
	private Usuario usuario;
	@OneToOne
	private Empleador empleador;

	public UsuarioEmpleador() {

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getTotalIngresos() {
		return totalIngresos;
	}

	public void setTotalIngresos(double totalIngresos) {
		this.totalIngresos = totalIngresos;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Empleador getEmpleador() {
		return empleador;
	}

	public void setEmpleador(Empleador empleador) {
		this.empleador = empleador;
	}

	@Override
	public String toString() {
		return "UsuarioEmpleador [codigo=" + codigo + ", totalIngresos=" + totalIngresos + ", anio=" + anio
				+ ", usuario=" + usuario + ", empleador=" + empleador + "]";
	}

}
