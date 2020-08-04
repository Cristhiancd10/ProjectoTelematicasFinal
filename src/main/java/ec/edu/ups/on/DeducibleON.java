package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.DeducibleDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Declaracion;
import ec.edu.ups.modelo.Deducible;
import ec.edu.ups.objetos.DeducibleTmp;
import ec.edu.ups.objetos.IngresosTmp;


@Stateless
public class  DeducibleON{

	
	@Inject
	private DeducibleDAO deDAO;
	
	@Inject
	private DeducibleDAO ddao;
	@Inject
	private UsuarioDAO udao;
	
     private DeducibleTmp dt;
	
	private IngresosTmp it;

	public void create(Deducible de) {
		deDAO.create(de);
	}

	public Deducible read(int codigo) {
		return deDAO.leer(codigo);
	}

	public void update(Deducible de) {
		deDAO.update(de);
	}

	public void delete(int codigo) {
		deDAO.delete(codigo);
	}
	
	public List<Deducible> getListadoDeducibles(){
		return deDAO.getDeducible();
	}
	public List<Declaracion> getListadoDeclaraciones(){
	      
		return deDAO.getDeclaracion();
	}
	public double calculoImpuesto(String cedula){
		dt = ddao.listarMasVendidos(cedula);
		it=udao.Ingresos(cedula);
		System.out.println("restaON "+(it.getTotalIngresos()-dt.getTotalDeducible()));
		double res=(it.getTotalIngresos()-dt.getTotalDeducible());
		System.out.println("res "+res);		
		double va=0;
            
        if (res > 0 &&  res <= deDAO.getDeclaracion().get(0).getExceso()) {
            	va=0;
        }else if( res > deDAO.getDeclaracion().get(1).getFraccionBasica() && res <= deDAO.getDeclaracion().get(1).getExceso() ){
            va= (res-deDAO.getDeclaracion().get(1).getFraccionBasica())*(deDAO.getDeclaracion().get(1).getImpuestoFE()/100);
        }else if( res > deDAO.getDeclaracion().get(2).getFraccionBasica() && res <= deDAO.getDeclaracion().get(2).getExceso() ){
            va= ((res-deDAO.getDeclaracion().get(2).getFraccionBasica())*(deDAO.getDeclaracion().get(2).getImpuestoFE()/100))+deDAO.getDeclaracion().get(2).getImpuestoFB();
        }else if(  res > deDAO.getDeclaracion().get(3).getFraccionBasica() && res <= deDAO.getDeclaracion().get(3).getExceso()  ){
            va= ((res-deDAO.getDeclaracion().get(3).getFraccionBasica())*(deDAO.getDeclaracion().get(3).getImpuestoFE()/100))+deDAO.getDeclaracion().get(3).getImpuestoFB();
        }else if(  res > deDAO.getDeclaracion().get(4).getFraccionBasica() && res <= deDAO.getDeclaracion().get(4).getExceso() ){
            va= ((res-deDAO.getDeclaracion().get(4).getFraccionBasica())*(deDAO.getDeclaracion().get(4).getImpuestoFE()/100))+deDAO.getDeclaracion().get(4).getImpuestoFB();
        }else if(  res > deDAO.getDeclaracion().get(5).getFraccionBasica() && res <= deDAO.getDeclaracion().get(5).getExceso()  ){
            va= ((res-deDAO.getDeclaracion().get(5).getFraccionBasica())*(deDAO.getDeclaracion().get(5).getImpuestoFE()/100))+deDAO.getDeclaracion().get(5).getImpuestoFB();
        }else if(  res > deDAO.getDeclaracion().get(6).getFraccionBasica() && res <= deDAO.getDeclaracion().get(6).getExceso()  ){
            va= ((res-deDAO.getDeclaracion().get(6).getFraccionBasica())*(deDAO.getDeclaracion().get(6).getImpuestoFE()/100))+deDAO.getDeclaracion().get(6).getImpuestoFB();
        }else if(  res > deDAO.getDeclaracion().get(7).getFraccionBasica() && res <= deDAO.getDeclaracion().get(7).getExceso()  ){
            va= ((res-deDAO.getDeclaracion().get(7).getFraccionBasica())*(deDAO.getDeclaracion().get(7).getImpuestoFE()/100))+deDAO.getDeclaracion().get(7).getImpuestoFB();
        }else if(  res > deDAO.getDeclaracion().get(8).getFraccionBasica() && res <= deDAO.getDeclaracion().get(8).getExceso()  ){
            va= ((res-deDAO.getDeclaracion().get(8).getFraccionBasica())*(deDAO.getDeclaracion().get(8).getImpuestoFE()/100))+deDAO.getDeclaracion().get(8).getImpuestoFB();
        }
       
		return va;
	}
	public List<DeducibleTmp> getListadoporCodigo(int codigo) {
		return deDAO.getDeducibles(codigo);
	}
}
