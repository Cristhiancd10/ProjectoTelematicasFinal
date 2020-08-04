package ec.edu.ups.on;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.DeducibleDAO;
import ec.edu.ups.dao.FacturaDAO;
import ec.edu.ups.modelo.Deducible;
import ec.edu.ups.modelo.Factura;

@Stateless
public class FacturaON {

	@Inject
	private FacturaDAO facturaDAO;
	@Inject
	private DeducibleDAO deducibleDAO;
	@Inject
	private DeducibleON deducibleON;
	
	

	public void registrar(Factura f) {
		//Deducible deducible = deducibleON.read(numero);

		List<Deducible> deducibles = new ArrayList<Deducible>();
		for (int i = 0; i < f.getDeducibles().size(); i++) {
			f.getDeducibles().get(i).setFactura(f);
		}
		
		 facturaDAO.create(f);
		 

	}
	
	public List<Factura> getListadoFacturas(){
		return facturaDAO.getFacturas();
	}
	
public Factura getFactura(int codigo) {
		
		Factura aux=facturaDAO.read3(codigo);
		
		return aux;
	}
}
