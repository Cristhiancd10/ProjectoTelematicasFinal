package ec.edu.ups.modelo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

@Entity
public class Factura implements Serializable {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	
	private String fecha;
	@NotNull
	private double valor;

	@OneToOne
	private Usuario usuario;
	@OneToOne
	private Proveedor proveedor;
	@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Deducible> deducibles;

	@PrePersist
    public void prePersist() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 Date date = new Date();
		fecha=dateFormat.format(date);
	}
	
	public Factura() {

	}
	public Factura(int numero) {

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		fecha = fecha;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public List<Deducible> getDeducibles() {
		return deducibles;
	}

	public void setDeducibles(List<Deducible> deducibles) {
		this.deducibles = deducibles;
	}
	
	public void addDeducible(Deducible dec) {
		if (deducibles==null) {
			deducibles=new ArrayList<>();
		}
		this.deducibles.add(dec);
		
	}

	@Override
	public String toString() {
		return "Factura [numero=" + numero + ", Fecha=" + fecha + ", valor=" + valor + ", usuario=" + usuario
				+ ", proveedor=" + proveedor + ", deducibles=" + deducibles + "]";
	}

}
