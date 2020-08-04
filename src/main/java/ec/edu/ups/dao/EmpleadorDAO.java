package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Empleador;

@Stateless
public class EmpleadorDAO {

	@Inject
	private EntityManager em;

	public void create(Empleador e) {
		em.persist(e);

	}

	public Empleador read(String ruc) {
		return em.find(Empleador.class, ruc);

	}

	public void update(Empleador e) {
		em.merge(e);

	}

	public void delete(String ruc) {
		em.remove(read(ruc));
	}

	public List<Empleador> listar() {
		String jpql = "SELECT  e FROM Empleador e ";
		Query q = em.createQuery(jpql, Empleador.class);
		List<Empleador> empleadores = q.getResultList();

		return empleadores;

	}

	public Empleador getEmpleadorPorRuc(String ruc) {
		String jpql = "SELECT e FROM Cliente e WHERE e.ruc LIKE :ruc";
		Query q = em.createQuery(jpql, Empleador.class);
		q.setParameter("cedula", ruc);
		Empleador empleador = (Empleador) q.getSingleResult();
		return empleador;
	}

}
