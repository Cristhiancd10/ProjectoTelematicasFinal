package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Declaracion;

@Stateless
public class DeclaracionDAO {

	@Inject
	private EntityManager em;

	public void create(Declaracion d) {
		em.persist(d);

	}

	public Declaracion read(int codigo) {
		return em.find(Declaracion.class, codigo);

	}

	public void update(Declaracion d) {
		em.merge(d);

	}

	public void delete(int codigo) {
		em.remove(read(codigo));
	}

	public List<Declaracion> listar() {
		String jpql = "SELECT  d FROM Declaracion d ";
		Query q = em.createQuery(jpql, Declaracion.class);
		List<Declaracion> declaraciones = q.getResultList();

		return declaraciones;

	}
}
