package co.ufps.tiendau.dao;

import co.ufps.tiendau.model.Cliente;
import co.ufps.tiendau.util.Conexion;


public class ClienteDao extends Conexion<Cliente> implements GenericDao<Cliente> {

	public ClienteDao() {
		super(Cliente.class);
	}

}
