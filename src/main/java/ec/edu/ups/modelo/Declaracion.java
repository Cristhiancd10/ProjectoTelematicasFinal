package ec.edu.ups.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Declaracion implements Serializable {

	@Id
	@NotNull
	private int codigo;
	@NotNull
	private int anio;
	@NotNull
	private double fraccionBasica;
	private double exceso;
	@NotNull
	private double impuestoFB;
	@NotNull
	private double impuestoFE;

	
	public Declaracion() {

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public double getFraccionBasica() {
		return fraccionBasica;
	}

	public void setFraccionBasica(double fraccionBasica) {
		this.fraccionBasica = fraccionBasica;
	}

	public double getExceso() {
		return exceso;
	}

	public void setExceso(double exceso) {
		this.exceso = exceso;
	}

	public double getImpuestoFB() {
		return impuestoFB;
	}

	public void setImpuestoFB(double impuestoFB) {
		this.impuestoFB = impuestoFB;
	}

	public double getImpuestoFE() {
		return impuestoFE;
	}

	public void setImpuestoFE(double impuestoFE) {
		this.impuestoFE = impuestoFE;
	}

	@Override
	public String toString() {
		return "Declaracion [codigo=" + codigo + ", anio=" + anio + ", fraccionBasica=" + fraccionBasica + ", exceso="
				+ exceso + ", impuestoFB=" + impuestoFB + ", impuestoFE=" + impuestoFE + "]";
	}

}
