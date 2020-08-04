package ec.edu.ups.vista;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DeducibleDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Deducible;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.objetos.DeducibleTmp;
import ec.edu.ups.objetos.IngresosTmp;
import ec.edu.ups.objetos.User;
import ec.edu.ups.on.DeducibleON;


@ManagedBean
@ViewScoped
public class LoginController implements Serializable {
	
	
	@Inject
	private UsuarioController usuarioController;
	
		
	private String cedula;
	private Usuario usuario;
	private User user;
	
	
	
	@Inject
	private DeducibleON dON;
	@PostConstruct
	public void init() {
		usuario = new Usuario();
		user = new User();
	}

	
	
	public String login() {
		usuario = usuarioController.login(user);
		if (usuario != null) {
//			HttpSession session = SessionUtils.getSession();
//			session.setAttribute("username", usuario);
			
			return "Modulos";
		} else {
			return "Error";
		}
	}

	public String registrar() {
		return "usuario";
	}
	public String ingresar() {
		return "deducible";
	}
	public String mostrar() {
		return "CalculoRenta";
	}
	public String generar() {
		return "deducible";
	}
	public String logout() {
		//HttpSession session = SessionUtils.getSession();
		//session.invalidate();
		return "login";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	

}
