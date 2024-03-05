package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.ws.runtime.dev.Session;

import dao.DaoJornada;
import dao.DaoPartido;
import dao.DaoUsuario;
import model.Jornada;
import model.Partido;
import model.Usuario;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Jornada> jornadas = null;
		DaoJornada daoJornada = new DaoJornada();

		HttpSession session = request.getSession();		
		String op = request.getParameter("op");

		switch(op) {

		case "inicio":

			try {
				jornadas= daoJornada.listadoJornadas();
			}catch (Exception e) {
				e.printStackTrace();
			}

			session.setAttribute("jornadas", jornadas);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;	

		case "vajornada":

			List<Partido> listaPartidos = null;
			DaoPartido daoPartido = new DaoPartido();
			long idJornada = Long.parseLong(request.getParameter("jornada"));

			try { 
				listaPartidos = daoPartido.getPartidoPorJornada(idJornada);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			session.setAttribute("listaPartidos", listaPartidos);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;

		case "login":

			DaoUsuario daoUsuario = new DaoUsuario();
			Usuario usuario = null;

			String dni=request.getParameter("dni");
			String nombre=request.getParameter("nombre");

			try {
				usuario = daoUsuario.buscarUsuario(dni);
				if(usuario == null) {
					usuario = new Usuario(dni);
					usuario.setNombre(nombre);
					daoUsuario.addUsuario(usuario);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			session.setAttribute("usuario", usuario);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;

		case "logout":

			session.removeAttribute("usuario");		
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;	

		}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
