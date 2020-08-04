package ec.edu.ups.utils;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resource {

	@Produces
	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * @param injectionPoint
	 * @return
	 */
	@Produces
	public Logger produceLog(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}

	@Produces
	@RequestScoped
	public FacesContext prodiceFC() {
		return FacesContext.getCurrentInstance();
	}

}