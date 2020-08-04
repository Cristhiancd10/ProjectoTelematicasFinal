package ec.edu.ups.vista;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.edu.ups.modelo.Deducible;
import ec.edu.ups.modelo.Factura;
import ec.edu.ups.modelo.Proveedor;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.on.DeducibleON;
import ec.edu.ups.on.FacturaON;
import ec.edu.ups.on.ProveedorON;
import ec.edu.ups.on.UsuarioON;

@ManagedBean
@SessionScoped
public class FacturaController {

	private Factura factura;
	private List<Factura> listadoFacturas;
	private int id;
	private String ruc;
	private String cedula;
	private Date date;
	private Proveedor pro;
	private Usuario usu;
	
	@Inject
	private FacturaON fON;
	@Inject
	private ProveedorON pON;
	@Inject
	private UsuarioON uON;

	
	@PostConstruct
	public void init() {
		 factura= new Factura();
		 factura.addDeducible(new Deducible());
		listadoFacturas= fON.getListadoFacturas();
		pro=new Proveedor();
		usu=new Usuario();
		
	}
	
public String cargarDatos() {
		
		try {
			usu=uON.read();
			factura.setUsuario(usu);
			factura.setProveedor(pro);
						
			fON.registrar(factura);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public void addDeducible() {
		factura.addDeducible(new Deducible());
		System.out.println("tele "+factura.getDeducibles().size());
	}
	
	public void loadData() {
		System.out.println("codigo editar"+id);
		if (id==0) 
			return;
			factura=fON.getFactura(id);
			System.out.println(factura.getNumero()+" "+factura.getValor());
			System.out.println("# Deducible"+" "+factura.getDeducibles().size());
			for(Deducible d : factura.getDeducibles()) {
				System.out.println("\t"+d);
			} 
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	
		
	public Proveedor getPro() {
		return pro;
	}

	public void setPro(Proveedor pro) {
		this.pro = pro;
	}
	

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String buscarProveedor() {
		System.out.println(ruc);
		pro=pON.read(ruc);
		//System.out.println(pro.toString());
		return null;
	}
	
	public String buscarUsuario() {
		System.out.println(cedula);
		usu=uON.read();
		//System.out.println(pro.toString());
		return null;
	}


}
