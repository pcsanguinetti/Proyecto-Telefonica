package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int usuarioId;

	private String contraseña;

	private String nombre;

	//bi-directional many-to-many association to Articulo
	@ManyToMany
	@JoinTable(
		name="usuario_articulo"
		, joinColumns={
			@JoinColumn(name="usuarioId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="articuloId")
			}
		)
	private List<Articulo> articulos;

	//bi-directional many-to-many association to Curso
	@ManyToMany
	@JoinTable(
		name="usuario_curso"
		, joinColumns={
			@JoinColumn(name="usuarioId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="cursoId")
			}
		)
	private List<Curso> cursos;

	//bi-directional many-to-many association to Libro
	@ManyToMany
	@JoinTable(
		name="usuario_libro"
		, joinColumns={
			@JoinColumn(name="usuarioId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="libroId")
			}
		)
	private List<Libro> libros;

	public Usuario() {
	}

	public int getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getContraseña() {
		return this.contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Articulo> getArticulos() {
		return this.articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Libro> getLibros() {
		return this.libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

}