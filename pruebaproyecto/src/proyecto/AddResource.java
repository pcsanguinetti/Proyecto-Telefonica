package proyecto;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DatosRecurso;
import model.Libro;

/**
 * Servlet implementation class InsertarUsuario
 */
@WebServlet("/AddResource")
public class AddResource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddResource() {
        super();
       
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		// Lógica de la conexión con la base de datos.
		ServletContext contextoAplicacion = this.getServletContext();
		DatosRecurso conexionDatosUsuario= new DatosRecurso();
		contextoAplicacion.setAttribute("conexionDatosUsuario", conexionDatosUsuario);
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String nombre = request.getParameter("nombre");
		String autor = request.getParameter("autor");
		String link = request.getParameter("link");
		String tipo = request.getParameter("tipo");
		String descripcion = request.getParameter("descripcion");
		
		EntityManagerFactory factory = null;
		EntityManager em = null;

		try {
			
			factory = Persistence.createEntityManagerFactory("pruebaproyecto");
		
			em = factory.createEntityManager();
	
			DatosRecurso recurso = new DatosRecurso();
			
			Libro libro=new Libro();
			libro.setTitulo(nombre);
			libro.setAutor(autor);
			libro.setUrl(link);
			libro.setDescripcion(descripcion);
			
			
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			em.persist(libro);
			tx.commit();
			

		} catch (Exception err) {
			System.out.println(err.getMessage());
			System.out.println(err.getCause());
			
		}

		
		//ServletContext contextoAplicacion = this.getServletContext();
		//DatosUsuario conexion=(DatosUsuario)contextoAplicacion.getAttribute("conexionDatosUsuario");
		
	
		
		//response.getWriter().append("Served at: ").append(nombreUsuario + " creado");
		
		/*
		RequestDispatcher rd;

		HttpSession sesion = request.getSession(true);
		
		if (n==null && !sesion.isNew()) {
			n = (String) sesion.getAttribute("nombre");
		}
		
		if (n == null)
			rd = request.getRequestDispatcher("/login.jsp");
		else if (n.equals("Pepe") || n.equals("Juan")) {
			rd = request.getRequestDispatcher("/home.jsp");
			sesion.setAttribute("nombre", n);			
		}
		else {
			rd = request.getRequestDispatcher("/denegado.jsp");
			sesion.invalidate();
		}
		
		rd.forward(request, response); */
		
		RequestDispatcher rd = request.getRequestDispatcher("/libros.html");
		rd.forward(request, response);
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
