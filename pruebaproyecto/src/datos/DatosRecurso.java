package datos;

import javax.persistence.*;
import java.util.List;
import model.*;



public class DatosRecurso {
	
	private EntityManagerFactory factory;
	private EntityManager em;
	private String mensaje;
	
	public DatosRecurso() {
		try {
			factory = Persistence.createEntityManagerFactory("iRefDataBase");
			em = factory.createEntityManager();
			//this.mensaje = "Hemos obtenido el EntityManager";

		} catch (Exception e) {
			this.mensaje = "Error obteniendo el EntityManager\n" + e.getMessage();
		}
	}

	@Override
	public String toString() {
		return "DatosRecurso [mensaje=" + mensaje + "]";
	}
	
	public List<Libro> getLibros() {
		TypedQuery<Libro> query = em.createNamedQuery("Libro.findAll", Libro.class);
		List<Libro> libros = query.getResultList();
		return libros;
	}
	
	public String getCursos() {
		TypedQuery<Curso> query = em.createNamedQuery("Curso.findAll", Curso.class);
		List<Curso> cursos = query.getResultList();
		String salida="<table>";
		salida=salida + "<tr><th>Curso</th><th>Descripción</th><th>Formador</th><th>Formato</th><th>Enlace</th><th>Opinión</th></tr>";
		for (Curso curso: cursos) {
			salida=salida+"<tr>";
			salida=salida+"<td>"+curso.getNombre()+"</td>";
			salida=salida+"<td>"+curso.getDescripcion()+"</td>";
			salida=salida+"<td>"+curso.getInstitucion()+"</td>";
			salida=salida+"<td>"+curso.getUrl()+"</td>";
			salida=salida+"</tr>";
		}
		salida=salida+"</table>";
		this.mensaje = "Hemos obtenido la lista de cursos";
		return salida;
	}

}
