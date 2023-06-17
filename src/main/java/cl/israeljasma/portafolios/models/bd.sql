CREATE DATABASE cvdb;

use cvdb;

-- Tabla de role
CREATE TABLE role (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    fechaCreacion TIMESTAMP,
    fechaModificacion TIMESTAMP
);

-- Tabla de usuario
CREATE TABLE usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE,
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    active BOOLEAN,
    fecha_creacion TIMESTAMP,
    fecha_modificacion TIMESTAMP
);

-- Tabla de authorities
CREATE TABLE authorities (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE user_authority (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    authority_id INT,
    FOREIGN KEY (user_id) REFERENCES usuario(id),
    FOREIGN KEY (authority_id) REFERENCES authorities(id)
);

-- Tabla de perfil
CREATE TABLE perfil (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombres VARCHAR(50),
    apellidoPaterno VARCHAR(50),
    apellidoMaterno VARCHAR(50),
    rut VARCHAR(12) UNIQUE,
    emailContacto VARCHAR(100),
    fechaNacimiento DATE,
    genero VARCHAR(20),
    direccion VARCHAR(100),
    ciudad VARCHAR(50),
    pais VARCHAR(50),
    telefono VARCHAR(20),
    fechaCreacion TIMESTAMP,
    fechaModificacion TIMESTAMP,
    idUsuario INT,
    FOREIGN KEY (idUsuario) REFERENCES usuario(id)
);

-- Tabla de usuarios roles
CREATE TABLE usuarios_roles (
    idUsuario INT AUTO_INCREMENT,
    idRol INT,
    fechaCreacion TIMESTAMP,
    fechaModificacion TIMESTAMP,
    FOREIGN KEY (idUsuario) REFERENCES usuario(id),
    FOREIGN KEY (idRol) REFERENCES role(id)
);

-- Tabla de experiencia laboral
CREATE TABLE experienciaLaboral (
    id INT PRIMARY KEY AUTO_INCREMENT,
    empresa VARCHAR(50),
    cargo TEXT(100) UNIQUE,
    fechaInicio DATE,
    fechaTermino DATE,
    descripcion TEXT,
    referenciaContacto TEXT,
    fechaCreacion TIMESTAMP,
    fechaModificacion TIMESTAMP,
    idPerfil INT,
    FOREIGN KEY (idPerfil) REFERENCES perfil(id)
);

-- Tabla de educacion
CREATE TABLE educacion (
    id INT PRIMARY KEY AUTO_INCREMENT,
    institucion VARCHAR(50),
    titulo VARCHAR(50),
    fechaInicio DATE,
    fechaTermino DATE,
    descripcion TEXT,
    pais VARCHAR(50),
    fechaCreacion TIMESTAMP,
    fechaModificacion TIMESTAMP,
    idPerfil INT,
    FOREIGN KEY (idPerfil) REFERENCES perfil(id)
);

-- Tabla de habilidad
CREATE TABLE habilidad (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    nivel INT,
    descripcion TEXT,
    categoria VARCHAR(50),
    fechaCreacion TIMESTAMP,
    fechaModificacion TIMESTAMP,
    idPerfil INT,
    FOREIGN KEY (idPerfil) REFERENCES perfil(id)
);

-- Tabla de proyectos
CREATE TABLE proyectos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    descripcion TEXT,
    rol VARCHAR(50),
    fechaInicio DATE,
    fechaTermino DATE,
    fechaCreacion TIMESTAMP,
    fechaModificacion TIMESTAMP,
    idPerfil INT,
    FOREIGN KEY (idPerfil) REFERENCES perfil(id)
);

-- Tabla de certificacion
CREATE TABLE certificacion (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    institucionEmisora VARCHAR(50),
    fechaObtencion TIMESTAMP,
    descripcion TEXT,
    url VARCHAR(50),
    fechaCreacion TIMESTAMP,
    fechaModificacion TIMESTAMP,
    idPerfil INT,
    FOREIGN KEY (idPerfil) REFERENCES perfil(id)
);

-- Tabla de referencias
CREATE TABLE referencias (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    cargo VARCHAR(50),
    empresa VARCHAR(50),
    email VARCHAR(50),
    telefono VARCHAR(50),
    relacion TEXT,
    fechaCreacion TIMESTAMP,
    fechaModificacion TIMESTAMP,
    idExperienciaLaboral INT,
    FOREIGN KEY (idExperienciaLaboral) REFERENCES experienciaLaboral(id)
);

-- Tabla de logros
CREATE TABLE logros (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descripcion TEXT,
    fecha DATE,
    categoria VARCHAR(50),
    detallesAdicionales TEXT,
    fechaCreacion TIMESTAMP,
    fechaModificacion TIMESTAMP,
    idPerfil INT,
    FOREIGN KEY (idPerfil) REFERENCES perfil(id)
);

-- Tabla de intereses
CREATE TABLE intereses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descripcion TEXT,
    categoria VARCHAR(50),
    nivel VARCHAR(50),
    fechaCreacion TIMESTAMP,
    fechaModificacion TIMESTAMP,
    idPerfil INT,
    FOREIGN KEY (idPerfil) REFERENCES perfil(id)
);

-- Datos Tabla de role
INSERT INTO role (nombre, fechaCreacion, fechaModificacion)
VALUES ('Administrador', '2023-05-21 10:00:00', '2023-05-21 10:30:00');
INSERT INTO role (nombre, fechaCreacion, fechaModificacion)
VALUES ('Cliente', '2023-05-21 10:00:00', '2023-05-21 10:30:00');

-- Datos Tabla de usuario
INSERT INTO usuario (username, email, password, active, fecha_creacion, fecha_modificacion)
VALUES ('doravan', 'doravan@example.com', '1234', true, '2023-05-21 10:00:00', '2023-05-21 10:30:00');

INSERT INTO usuario (username, email, password, active, fecha_creacion, fecha_modificacion)
VALUES ('pepito', 'pepito@example.com', '4321', true, '2023-05-21 10:00:00', '2023-05-21 10:30:00');

-- Datos Tabla de authorities
INSERT INTO authorities (name) VALUES ('ADMIN');
INSERT INTO authorities (name) VALUES ('WRITE');
INSERT INTO authorities (name) VALUES ('READ');

-- Datos Tabla de user_authority
INSERT INTO user_authority (user_id, authority_id) VALUES (1,1);
INSERT INTO user_authority (user_id, authority_id) VALUES (2,2);
INSERT INTO user_authority (user_id, authority_id) VALUES (3,3);