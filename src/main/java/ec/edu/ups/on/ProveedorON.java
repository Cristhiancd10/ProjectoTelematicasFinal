package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.ProveedorDAO;
import ec.edu.ups.modelo.Proveedor;

@Stateless
public class ProveedorON {

	@Inject
	private ProveedorDAO provDAO;

	public void crearProveedor(Proveedor prov) {
		provDAO.create(prov);
	}

	public Proveedor read(String ruc) {
		return provDAO.read(ruc);
	}

	public void actualizarProveedor(Proveedor prov) {
		provDAO.update(prov);
	}

	public void eliminarProveedor(String ruc) {
		provDAO.delete(ruc);
	}

	public List<Proveedor> listadoProveedores() {
		return provDAO.listarProveedores();

	}

	public Proveedor readNombre(String nombre) {
		return provDAO.readNombre(nombre);
	}
}
