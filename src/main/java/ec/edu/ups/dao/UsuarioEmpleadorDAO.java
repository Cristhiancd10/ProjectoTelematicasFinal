package ec.edu.ups.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.modelo.UsuarioEmpleador;

@Stateless
public class UsuarioEmpleadorDAO {

	@Inject
	private EntityManager em;

	public void create(UsuarioEmpleador u) {
		em.persist(u);

	}

	public void update(UsuarioEmpleador u) {
		em.merge(u);

	}

}
