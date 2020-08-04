package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Declaracion;
import ec.edu.ups.modelo.Deducible;
import ec.edu.ups.objetos.DeducibleTmp;

@Stateless
public class DeducibleDAO {

	@Inject
	private EntityManager em;
	
	public void create(Deducible de) {
		System.out.println("Vale "+de.toString());
		em.persist(de);

	}

	public Deducible leer(int codigo) {
		return em.find(Deducible.class, codigo);

	}

	public Deducible leer2(int codigo) {
		Deducible det = em.find(Deducible.class, codigo);
		return det;

	}

	public void delete(int codigo) {

		em.remove(leer(codigo));
	}

	public void update(Deducible de) {
		em.merge(de);

	}
	
	public DeducibleTmp listarMasVendidos(String cedula) {
		String sql = "select COALESCE(sum(valordeduciblealimentacion),0) as alimentacion, COALESCE(sum(valordeducibleeducacion),0) as educacion, COALESCE(sum(valordeduciblesalud),0) as salud, COALESCE(sum(valordeduciblevivienda),0) as vivienda, COALESCE(sum(valordeduciblevestimenta),0) as vestimenta, COALESCE(sum(valordeduciblealimentacion+valordeducibleeducacion+valordeduciblesalud+valordeduciblevivienda+valordeduciblevestimenta),0) as Total from deducible d, factura f, usuario u where u.cedula= :cedula and u.cedula=f.usuario_cedula and f.numero=d.factura_numero ";
			
		Query q = em.createNativeQuery(sql);
		q.setParameter("cedula", cedula);
		List<Object[]> lista = q.getResultList();
		DeducibleTmp vt = new DeducibleTmp();
		for (Object item[] : lista) {
			vt.setValorDeducibleAlimentacion(Double.parseDouble(item[0].toString()));
			vt.setValorDeducibleEducacion(Double.parseDouble(item[1].toString()));
			vt.setValorDeducibleSalud(Double.parseDouble(item[2].toString()));
			vt.setValorDeducibleVivienda(Double.parseDouble(item[3].toString()));
			vt.setValorDeducibleVestimenta(Double.parseDouble(item[4].toString()));
			vt.setTotalDeducible(Double.parseDouble(item[5].toString()));
			System.out.println(item[0]+" "+item[1]+" "+item[2]+" "+item[3]);
			
			//deducible=(Double.parseDouble(item[3].toString()));
		}
		System.out.println("mas ven "+vt.getTotalDeducible());
		//deducible=(vt.getTotalDeducible());
		System.out.println(lista.get(0));
		return vt;
	}
	
	public List<Deducible> getDeducible(){
		String jpql="SELECT d FROM Deducible d";
		Query q=em.createQuery(jpql, Deducible.class);
		
		List<Deducible> deducibles=q.getResultList();
//		for(Deducible d: deducibles)
//			d.getActividades().size();
		return deducibles;
	}
	
	public List<Declaracion> getDeclaracion(){
		String jpql="SELECT d FROM Declaracion d";
		Query q=em.createQuery(jpql, Declaracion.class);
		
		List<Declaracion> declaraciones=q.getResultList();
//		for(Deducible d: deducibles)
//			d.getActividades().size();
		return declaraciones;
	}
	public List<DeducibleTmp> getDeducibles(int codigo) {
		String jpql = "SELECT d FROM Deducible d where d.codigo = :codigo";
		Query q = em.createQuery(jpql, Deducible.class);
		q.setParameter("codigo", codigo);
		List<Deducible> deducibles = q.getResultList();
		List<DeducibleTmp> listado = new ArrayList<DeducibleTmp>();

		for (Deducible de : deducibles) {
			DeducibleTmp dt = new DeducibleTmp();
//			dt.setCodigo(de.getCodigo());
			dt.setValorDeducibleAlimentacion(de.getValorDeducibleAlimentacion());
			dt.setValorDeducibleEducacion(de.getValorDeducibleEducacion());
			dt.setValorDeducibleSalud(de.getValorDeducibleSalud());
			dt.setValorDeducibleVestimenta(de.getValorDeducibleVestimenta());
			dt.setValorDeducibleVivienda(de.getValorDeducibleVivienda());
			listado.add(dt);
		}
		return listado;
	}
}
