CREATE DATABASE catalogo;

USE catalogo ;
CREATE TABLE Usuario_Profesor (
    idUsuario INT PRIMARY KEY AUTO_INCREMENT,
    nombreUsuario VARCHAR(50) NOT NULL,
    contrasena VARCHAR(50) NOT NULL,
    rol ENUM('profesor', 'administrador') NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    RFC VARCHAR(15) NOT NULL
);

CREATE TABLE UnidadAprendizaje (
    idUnidadAprendizaje INT PRIMARY KEY AUTO_INCREMENT,
    nombreUnidad VARCHAR(100) NOT NULL,
    horasClase INT NOT NULL,
    horasTaller INT NOT NULL,
    horasLaboratorio INT NOT NULL
);

CREATE TABLE Usuario_Unidad (
    idRegistro INT PRIMARY KEY AUTO_INCREMENT,
    idUsuario INT,
    idUnidadAprendizaje INT,
    FOREIGN KEY (idUsuario) REFERENCES Usuario_Profesor(idUsuario),
    FOREIGN KEY (idUnidadAprendizaje) REFERENCES UnidadAprendizaje(idUnidadAprendizaje)
);