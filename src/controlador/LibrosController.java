package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Libro;
import data.LibroDAO;

/**
 * Servlet implementation class LibrosController
 */
@WebServlet(urlPatterns ={"","/insertar"})
public class LibrosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibrosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher despachador = null;
		
		if (request.getServletPath().equals("")) {
			LibroDAO libroDAO = new LibroDAO();
			ArrayList<Libro> libros = libroDAO.getLibros();
			
			request.setAttribute("libros", libros);
			
			despachador = request.getServletContext().getRequestDispatcher("/index.jsp");
			despachador.forward(request, response);
			
		} else if (request.getServletPath().equals("/insertar")) {
			despachador = request.getServletContext().getRequestDispatcher("/prueba.jsp");
			despachador.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
