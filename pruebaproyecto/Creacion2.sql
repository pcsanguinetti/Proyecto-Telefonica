#Creación de la base de datos
CREATE DATABASE IF NOT EXISTS iRefDataBase;

#Selección de la base de datos
use iRefDataBase;

#Creación de tablas
CREATE TABLE IF NOT EXISTS usuario (
	usuarioId INT NOT NULL AUTO_INCREMENT,
    contraseña VARCHAR(50) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
	PRIMARY kEY(usuarioId)
)ENGINE=InnoDB ;

CREATE TABLE IF NOT EXISTS libro (
	libroId INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(45) NOT NULL,
    autor VARCHAR(45),
    url VARCHAR(255),
    descripcion VARCHAR(320),
   
    PRIMARY KEY (libroId)
   )ENGINE=InnoDB ;

CREATE TABLE IF NOT EXISTS curso (
	cursoId INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    institucion VARCHAR(45),
    url VARCHAR(255),
    descripcion VARCHAR(320),
    PRIMARY KEY (cursoId)    
)ENGINE=InnoDB ;

CREATE TABLE IF NOT EXISTS articulo (
	articuloId INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(45) NOT NULL,
    fuente VARCHAR(45),
    url VARCHAR(255),
    descripcion VARCHAR(320),
    PRIMARY KEY (articuloId)    
)ENGINE=InnoDB ;

CREATE TABLE IF NOT EXISTS usuario_libro (
	usuarioId INT NOT NULL,
    libroId INT NOT NULL,
    PRIMARY KEY(usuarioId, libroId),
    CONSTRAINT fkusuarios_libros
    FOREIGN KEY (usuarioId)
    REFERENCES usuario(usuarioId),
    CONSTRAINT fklibros_usuarios
    FOREIGN KEY (libroId)
    REFERENCES libro(libroId)
)ENGINE=InnoDB ;

CREATE TABLE IF NOT EXISTS usuario_curso (
	usuarioId INT NOT NULL,
    cursoId INT NOT NULL,
    PRIMARY KEY(usuarioId, cursoId),
    CONSTRAINT fkusuarios_cursos
    FOREIGN KEY (usuarioId)
    REFERENCES usuario(usuarioId),
    CONSTRAINT fkcursos_usuarios
    FOREIGN KEY (cursoId)
    REFERENCES curso(cursoId)
)ENGINE=InnoDB ;

CREATE TABLE IF NOT EXISTS usuario_articulo (
	usuarioId INT NOT NULL,
    articuloId INT NOT NULL,
    PRIMARY KEY(usuarioId, articuloId),
    CONSTRAINT fkusuarios_articulos
    FOREIGN KEY (usuarioId)
    REFERENCES usuario(usuarioId),
    CONSTRAINT fkarticulos_usuarios
    FOREIGN KEY (articuloId)
    REFERENCES articulo(articuloId)
)ENGINE=InnoDB ;
