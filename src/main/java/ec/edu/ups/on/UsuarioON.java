package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.objetos.User;

@Stateless
public class UsuarioON {

	@Inject
	private UsuarioDAO usuarioDAO;

	public void create(Usuario u) {
		usuarioDAO.create(u);
	}

	public Usuario read() {
		return usuarioDAO.read1();
	}

	public void update(Usuario u) {
		usuarioDAO.update(u);
	}

	public void delete(String cedula) {
		usuarioDAO.delete(cedula);
	}

	public List<Usuario> listarUsuarios() {
		return usuarioDAO.listar();
	}

	public Usuario getUsuariosPorCedula(String cedula) {
		return usuarioDAO.getUsuarioPorCedula(cedula);

	}

	/**
	 * Verifica que la cedula ingresada sea Ecuatoriana
	 * 
	 * @param cedula
	 * @return
	 */
	public boolean validadorDeCedula(String cedula) {
		boolean cedulaCorrecta = false;
		try {
			if (cedula.length() == 10) {
				int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
				if (tercerDigito < 6) {
					int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					int verificador = Integer.parseInt(cedula.substring(9, 10));
					int suma = 0;
					int digito = 0;
					for (int i = 0; i < (cedula.length() - 1); i++) {
						digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}

					if ((suma % 10 == 0) && (suma % 10 == verificador)) {
						cedulaCorrecta = true;
					} else if ((10 - (suma % 10)) == verificador) {
						cedulaCorrecta = true;
					} else {
						cedulaCorrecta = false;
					}
				} else {
					cedulaCorrecta = false;
				}
			} else {
				cedulaCorrecta = false;
			}
		} catch (NumberFormatException nfe) {
			cedulaCorrecta = false;
		} catch (Exception err) {
			System.out.println(err.getStackTrace());
			System.out.println("Ingrese una cedula correcta por favor");
			cedulaCorrecta = false;
		}
		return cedulaCorrecta;
	}

	public Usuario login(User user) {
		return usuarioDAO.getUserbyEmailAndPassword(user);
	}
}
