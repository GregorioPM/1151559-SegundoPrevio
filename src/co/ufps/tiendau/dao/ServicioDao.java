package co.ufps.tiendau.dao;

import co.ufps.tiendau.util.Conexion;
import co.ufps.tiendau.model.Servicio;;

public class ServicioDao extends Conexion<Servicio> implements GenericDao<Servicio> {

	public ServicioDao() {
		super(Servicio.class);
	}

}