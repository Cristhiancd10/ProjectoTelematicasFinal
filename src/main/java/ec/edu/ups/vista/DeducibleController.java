package ec.edu.ups.vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.dao.DeducibleDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Declaracion;
import ec.edu.ups.modelo.Deducible;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.objetos.DeducibleTmp;
import ec.edu.ups.objetos.IngresosTmp;
import ec.edu.ups.objetos.User;
import ec.edu.ups.on.DeducibleON;
import ec.edu.ups.on.UsuarioON;

@ManagedBean
@ViewScoped
public class DeducibleController {

	private double impuesto;
	private double res;
	private String cedula;
	private Deducible deducible;
	private List<Deducible> listaDeducibles;
	private List<Declaracion> listadoDeclaracion;
	  
	@Inject
	private DeducibleDAO ddao;
	@Inject
	private UsuarioDAO udao;
	@Inject
	private UsuarioON uON;
	private Usuario usu=new Usuario();
	private DeducibleTmp dt;
	
	private IngresosTmp it;
	@Inject
	private DeducibleON dON;
	private User user;
	
	@PostConstruct
	public void init() {
		deducible=new Deducible();
		listaDeducibles=dON.getListadoDeducibles();
		listadoDeclaracion=dON.getListadoDeclaraciones();
		
	}
	
	public String cargarDatos() {
		
		try {
			System.out.println("deducible "+deducible.getCantidad());
			dON.create(deducible);
			init();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<Deducible> getListaDeducibles() {
		return listaDeducibles;
	}

	public void setListaDeducibles(List<Deducible> listaDeducibles) {
		this.listaDeducibles = listaDeducibles;
	}

	public Deducible getDeducible() {
		return deducible;
	}

	public void setDeducible(Deducible deducible) {
		this.deducible = deducible;
	}

	public List<Declaracion> getListadoDeclaracion() {
		return listadoDeclaracion;
	}

	public void setListadoDeclaracion(List<Declaracion> listadoDeclaracion) {
		this.listadoDeclaracion = listadoDeclaracion;
	}

	public String listarDeducible() {
		
		try {
			uON.login(user);
			usu=uON.read();
			//System.out.println("usuario d "+usu.getCedula());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	    dt = ddao.listarMasVendidos(usu.getCedula().toString());
		it=udao.Ingresos(usu.getCedula().toString());
		System.out.println("deducible "+dt.getTotalDeducible()+" ingresos "+it.getTotalIngresos());
		res=it.getTotalIngresos()-dt.getTotalDeducible();
		System.out.println("resta "+(res));
		impuesto=dON.calculoImpuesto(usu.getCedula().toString());
		System.out.println("impuesto "+impuesto);
		return null;
	}
	
	public String impuestos() {
		impuesto=dON.calculoImpuesto(usu.getCedula().toString());
		return null;
	}
	
	public DeducibleTmp getDt() {
		return dt;
	}


	public void setDt(DeducibleTmp dt) {
		this.dt = dt;
	}


	public IngresosTmp getIt() {
		return it;
	}


	public void setIt(IngresosTmp it) {
		this.it = it;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public double getRes() {
		return res;
	}


	public void setRes(double res) {
		this.res = res;
	}
	
	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}
	
	
}
