package co.ufps.tiendau.dao;

import co.ufps.tiendau.model.Tienda;
import co.ufps.tiendau.util.Conexion;

public class TiendaDao extends Conexion<Tienda> implements GenericDao<Tienda> {

	public TiendaDao() {
		super(Tienda.class);
	}

}

