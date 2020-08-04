package ec.edu.ups.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Deducible implements Serializable {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Pattern(regexp = "[^0-9]*", message = "Campo no admite numeros")
	private String descripcion;
	@NotNull
	private int cantidad;
	@NotNull
	private double valorDeducibleVivienda;
	@NotNull
	private double valorDeducibleEducacion;
	@NotNull
	private double valorDeducibleSalud;
	@NotNull
	private double valorDeducibleVestimenta;
	@NotNull
	private double valorDeducibleAlimentacion;

	@OneToOne
	private Factura factura;

	public Deducible() {

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getValorDeducibleVivienda() {
		return valorDeducibleVivienda;
	}

	public void setValorDeducibleVivienda(double valorDeducibleVivienda) {
		this.valorDeducibleVivienda = valorDeducibleVivienda;
	}

	public double getValorDeducibleEducacion() {
		return valorDeducibleEducacion;
	}

	public void setValorDeducibleEducacion(double valorDeducibleEducacion) {
		this.valorDeducibleEducacion = valorDeducibleEducacion;
	}

	public double getValorDeducibleSalud() {
		return valorDeducibleSalud;
	}

	public void setValorDeducibleSalud(double valorDeducibleSalud) {
		this.valorDeducibleSalud = valorDeducibleSalud;
	}

	public double getValorDeducibleVestimenta() {
		return valorDeducibleVestimenta;
	}

	public void setValorDeducibleVestimenta(double valorDeducibleVestimenta) {
		this.valorDeducibleVestimenta = valorDeducibleVestimenta;
	}

	public double getValorDeducibleAlimentacion() {
		return valorDeducibleAlimentacion;
	}

	public void setValorDeducibleAlimentacion(double valorDeducibleAlimentacion) {
		this.valorDeducibleAlimentacion = valorDeducibleAlimentacion;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "Deducible [codigo=" + codigo + ", descripcion=" + descripcion + ", cantidad=" + cantidad
				+ ", valorDeducibleVivienda=" + valorDeducibleVivienda + ", valorDeducibleEducacion="
				+ valorDeducibleEducacion + ", valorDeducibleSalud=" + valorDeducibleSalud
				+ ", valorDeducibleVestimenta=" + valorDeducibleVestimenta + ", valorDeducibleAlimentacion="
				+ valorDeducibleAlimentacion + ", factura=" + factura + "]";
	}
	
}
