package co.ufps.tiendau.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.ufps.tiendau.dao.ClienteDao;
import co.ufps.tiendau.dao.TiendaDao;
import co.ufps.tiendau.model.Cliente;
import co.ufps.tiendau.model.Tienda;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TiendaDao  tiendaDao= new TiendaDao();
	private ClienteDao  clienteDao= new ClienteDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
			case "login":
				showNewForm(request, response);
				break;
			case "logear":
				logearTienda(request, response);
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

	private void logearTienda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cliente cliente = clienteDao.findByField("email", request.getParameter("email"));
		if (cliente != null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		Tienda tienda  = tiendaDao.findByField("email", request.getParameter("email"));
		if (tienda != null) {
			request.getSession().setAttribute("nombredetienda", tienda.getNombre());
			request.getSession().setAttribute("mensajeservicios", tienda.getServicios().size() > 0 ? "" : "No hay servicios registrados");
			request.getSession().setAttribute("servicios", tienda.getServicios());
			
			request.getRequestDispatcher("servicios.jsp").forward(request, response);
			return;
		}
		List <Tienda> tiendas = tiendaDao.list();;
		request.getSession().setAttribute("tiendas", tiendas);	
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
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
