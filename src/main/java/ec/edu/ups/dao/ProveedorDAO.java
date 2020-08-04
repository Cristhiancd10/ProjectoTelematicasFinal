package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Proveedor;

@Stateless
public class ProveedorDAO {

	@Inject
	private EntityManager em;

	public void create(Proveedor p) {
		em.persist(p);

	}

	public Proveedor read(String ruc) {
		return em.find(Proveedor.class, ruc);

	}

	public void update(Proveedor p) {
		em.merge(p);

	}

	public void delete(String ruc) {
		em.remove(read(ruc));
	}

	public List<Proveedor> listarProveedores() {
		String jpql = "SELECT  prov FROM Proveedor prov";
		Query q = em.createQuery(jpql, Proveedor.class);
		List<Proveedor> proveedores = q.getResultList();

		return proveedores;

	}

	public Proveedor getProveedorPorRuc(String ruc) {
		String jpql = "SELECT prov FROM Proveedor prov WHERE p.ruc LIKE :ruc";
		Query q = em.createQuery(jpql, Proveedor.class);
		q.setParameter("ruc", ruc);
		Proveedor proveedor = (Proveedor) q.getSingleResult();
		return proveedor;
	}

	public Proveedor readNombre(String nombre) {
		String jpql = "SELECT prov FROM Proveedor prov" + "WHERE prov.nombre LIKE ?1";
		Query q = em.createNativeQuery(jpql, Proveedor.class);
		Proveedor proveedor = (Proveedor) q.getSingleResult();
		return proveedor;

	}
}
