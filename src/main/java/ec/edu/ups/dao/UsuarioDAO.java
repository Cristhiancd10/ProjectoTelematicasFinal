package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.objetos.IngresosTmp;
import ec.edu.ups.objetos.User;

@Stateless
public class UsuarioDAO {

	@Inject
	private EntityManager em;
	
	private Usuario u1=new Usuario(); 

	public void create(Usuario u) {
		em.persist(u);

	}

	public Usuario read(String cedula) {
		return em.find(Usuario.class, cedula);

	}
public Usuario read1() {
		
		System.out.println("uDao cedula "+u1.getCedula().toString());
		return em.find(Usuario.class, u1.getCedula().toString());
		

	}
	
	public void update(Usuario u) {
		em.merge(u);

	}

	public void delete(String cedula) {
		em.remove(read(cedula));
	}

	public List<Usuario> listar() {
		String jpql = "SELECT  u FROM Usuario u ";
		Query q = em.createQuery(jpql, Usuario.class);
		List<Usuario> usuarios = q.getResultList();

		return usuarios;

	}

	public Usuario getUserbyEmailAndPassword(User user) {
		
		try {
			String jpql = "SELECT u FROM Usuario u WHERE u.mail LIKE :mail AND u.clave LIKE :clave";
			Query q = em.createQuery(jpql, Usuario.class);
			q.setParameter("mail", user.getMail());
			q.setParameter("clave", user.getClave());
			Usuario us = (Usuario) q.getSingleResult();
			u1=us;
			return us;
		} catch (Exception e) {
			return null;
		}
		
	}

	public Usuario getUsuarioPorCedula(String cedula) {
		String jpql = "SELECT u FROM Usuario u WHERE u.cedula LIKE :cedula";
		Query q = em.createQuery(jpql, Usuario.class);
		q.setParameter("cedula", cedula);
		Usuario cliente = (Usuario) q.getSingleResult();
		u1 = cliente;
		return cliente;
	}
	
	public IngresosTmp Ingresos(String cedula) {
		String sql = "select sum(ue.totalIngresos) from usuario u, usuarioEmpleador ue where u.cedula =:cedula and ue.usuario_cedula=u.cedula";
		Query q = em.createNativeQuery(sql);
		q.setParameter("cedula", cedula);
		IngresosTmp vt = new IngresosTmp();
		double a = (double) q.getSingleResult();
		System.out.println(a);
		vt.setTotalIngresos((a));
		
		
		return vt;
	}

}
