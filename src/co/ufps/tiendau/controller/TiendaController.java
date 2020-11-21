package co.ufps.tiendau.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.ufps.tiendau.dao.TiendaDao;
import co.ufps.tiendau.model.Tienda;

/**
 * Servlet implementation class TiendaDao
 */
@WebServlet("/Tienda")
public class TiendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TiendaDao  tiendaDao= new TiendaDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TiendaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		String action = request.getParameter("action");
		System.out.println(action);
			switch(action) {
			case "new":
				showNewForm(request, response);
				break;
			case "insert":
				insertarTienda(request, response);
				break;
			
				
			default:
				index(request,response);	
					
			}
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List <Tienda> listatienda = tiendaDao.list();;
		request.getSession().setAttribute("listatienda", listatienda);	
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}



	private void insertarTienda(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		Tienda tienda= new Tienda();
		tienda.setClave(request.getParameter("password"));
		tienda.setDescripcion(request.getParameter("descripcion"));
		tienda.setEmail(request.getParameter("email"));
		tienda.setFacebook(request.getParameter("facebook"));
		tienda.setImagen(request.getParameter("imagen"));
		tienda.setLema(request.getParameter("lema"));
		tienda.setNombre(request.getParameter("nombre"));
		tienda.setPropietario(request.getParameter("propietario"));
		tienda.setWeb(request.getParameter("web"));
		Tienda tiendaDB = tiendaDao.findByField("email", tienda.getEmail());
		if (tiendaDB == null) {
			tiendaDao.insert(tienda);
			List <Tienda> listatienda = tiendaDao.list();;
			request.getSession().setAttribute("listatienda", listatienda);	
		    response.sendRedirect("index.jsp");

		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("registoTienda.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
