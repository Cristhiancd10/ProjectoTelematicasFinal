package ec.edu.ups.services;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ec.edu.ups.objetos.DeducibleTmp;
import ec.edu.ups.on.DeducibleON;

@WebService
public class GenerarXML {

	@Inject
	private DeducibleON deducibleON;

	@WebMethod
	public List<DeducibleTmp> getDeducibles(@WebParam(name = "codigo") int codigo) {

		return deducibleON.getListadoporCodigo(codigo);

	}

}