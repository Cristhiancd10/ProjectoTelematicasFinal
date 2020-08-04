package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Deducible;
import ec.edu.ups.modelo.Factura;

@Stateless
public class FacturaDAO {

	@Inject
	private EntityManager em;

	public void create(Factura f) {
		
		em.persist(f);

	}

	public Factura read(int numero) {
		return em.find(Factura.class, numero);

	}

	public void update(Factura f) {
		em.merge(f);

	}

	public void delete(int numero) {
		em.remove(read(numero));
	}

	public Factura read3(int id) {

		String jpql = "SELECT fact " + "FROM Factura fac  JOIN FETCH fac.deducibles d" + " WHERE fact.numero = :a";

		Query q = em.createQuery(jpql, Factura.class);
		q.setParameter("a", id);
		Factura fact = (Factura) q.getSingleResult();

		return fact;

	}

	public List<Factura> getFacturas() {
		String jpql = "SELECT fac FROM Factura fac";

		Query q = em.createQuery(jpql, Factura.class);
		List<Factura> fac = q.getResultList();
		return fac;

	}
	
	public Factura leerPorCodigo(int codigo) {
		String jpql = "SELECT f FROM Factura f WHERE f.numero = :codigo";
		Query query = em.createQuery(jpql, Factura.class);
		query.setParameter("codigo", codigo);
		Factura cabecera = (Factura) query.getSingleResult();
		List<Deducible> aux = cabecera.getDeducibles();
		List<Deducible> detalles = new ArrayList<>();
		for (Deducible df : aux) {
			df.setFactura(new Factura(cabecera.getNumero()));
			detalles.add(df);
		}
		cabecera.setDeducibles(detalles);
		return cabecera;
	}

	
}
