package co.ufps.tiendau.util;

import co.ufps.tiendau.dao.ClienteDao;
import co.ufps.tiendau.dao.ServicioDao;
import co.ufps.tiendau.dao.TiendaDao;
import co.ufps.tiendau.model.Cliente;
import co.ufps.tiendau.model.Servicio;
import co.ufps.tiendau.model.Tienda;

public class Prueba {
	static ClienteDao cliDao = new ClienteDao();
	static TiendaDao tiDao = new TiendaDao();
	static ServicioDao serDao = new ServicioDao();

	public Prueba() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cli = new Cliente();
		cli.setNombre("Gregorio");
		cli.setEmail("gregorio@gmail.com");
		cli.setClave("1234");
		cliDao.insert(cli);
		
		Tienda ti = new Tienda();
		ti.setFacebook("https://www.facebook.com/josegregorio.perezm");
		ti.setNombre("Gretrozh");
		ti.setLema("Calidad de persona");
		ti.setDescripcion("Estudiante Ingenieria Sistemas");
		ti.setEmail("gretrozh@gmail.com");
		ti.setClave("1234");
		ti.setPropietario("gregorioPerez");
		ti.setWeb("https://www.milanlive.it/");
		ti.setImagen("https://scontent.fbga1-3.fna.fbcdn.net/v/t1.0-9/p720x720/33020332_1642011672579972_8003355197394911232_o.jpg?_nc_cat=103&ccb=2&_nc_sid=174925&_nc_ohc=SF-bUsyvGewAX_f9KF4&_nc_ht=scontent.fbga1-3.fna&tp=6&oh=cd5d56010eee62012ab04b0c6ade9e0a&oe=5FE00A5E");
		tiDao.insert(ti);
		
		Servicio ser = new Servicio();
		ser.setNombre("Limpieza");
		ser.setDescripcion("Limpieza a tu hogar");
		ser.setTiendaBean(ti);
		serDao.insert(ser);
		

	}

}