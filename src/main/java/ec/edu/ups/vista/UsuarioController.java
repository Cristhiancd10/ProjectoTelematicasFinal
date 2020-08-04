package ec.edu.ups.vista;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.objetos.User;
import ec.edu.ups.on.UsuarioON;

@ManagedBean
@ViewScoped
public class UsuarioController {

	private String cedula;
	private boolean editing;
	private Usuario usuario;
	private List<Usuario> usuarios;
	@Inject
	private UsuarioON usuarioON;
	@Inject
	private FacesContext facesContext;

	@PostConstruct
	public void init() {
		editing = false;
		usuario = new Usuario();
		usuarios=usuarioON.listarUsuarios();
	}

	public void cargarDatosUsuario() {
		if (cedula == null)
			return;
		try {
			usuario = usuarioON.read();
			editing = true;
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
	}

	
	  public String guardar() { 
		  
		  
		  if (editing) { 
			  if(usuarioON.validadorDeCedula(usuario.getCedula()))
				  usuarioON.update(usuario);
	  } else {
		  if (usuarioON.validadorDeCedula(usuario.getCedula()))
			  	usuarioON.create(usuario); 
		  }
	  
	  return listar();
	  
	  }
	 
	

	public String editar(Usuario _usuario) {
		return "usuario?faces-redirect=true&cedula=" + _usuario.getCedula();
	}

	public String eliminar(Usuario _usuario) {
		usuarioON.delete(_usuario.getCedula());
		return crear();
	}

	public Usuario login(User user) {
		usuario = usuarioON.login(user);
		return usuario;
	}

	public Usuario getUsuariosPorCedula(String cedula) {
		return usuarioON.getUsuariosPorCedula(cedula);
	}

	public Usuario read(String cedula) {
		return usuarioON.read();
	}

	public String crear() {
		return "usuario";
	}

	public String listar() {
		return "lista-usuario";
	}

	public void recuperarRegistros() {
		usuarios = new ArrayList<>();
		usuarios = usuarioON.listarUsuarios();
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public boolean isEditing() {
		return editing;
	}

	public void setEditing(boolean editing) {
		this.editing = editing;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
