CREATE TABLE rol (
	id INT NOT NULL AUTO_INCREMENT,
	nombre_rol varchar(100) NOT NULL,
	PRIMARY KEY (id)
);
CREATE TABLE usuario (
	id INT NOT NULL AUTO_INCREMENT,
	password varchar(100) NOT NULL,
	username varchar(100) NOT NULL,
    idRol INT NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (idRol) REFERENCES rol(id)
);

CREATE TABLE cliente (
	id INT NOT NULL AUTO_INCREMENT,
	nombres varchar(100) NOT NULL,
	apellidos varchar(100) NOT NULL,
	identificacion varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	fecha_creacion datetime,
	PRIMARY KEY (id)
);
CREATE TABLE compra (
	id INT NOT NULL AUTO_INCREMENT,
    idCliente INT NOT NULL,
    total DOUBLE NOT NULL,
    fechaCompra datetime,
    fechaEntrega datetime,
    estadoCompra varchar(100) NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (idCliente) REFERENCES cliente(id)
);
CREATE TABLE itemsCompra (
	id INT NOT NULL AUTO_INCREMENT,
    cantidad INT NOT NULL,
    idCompra INT NOT NULL,
    valor DOUBLE NOT NULL,
    ancho DOUBLE NOT NULL,
    largo DOUBLE NOT NULL,
    fechaCreacion datetime,
	PRIMARY KEY (id),
    FOREIGN KEY (idCompra) REFERENCES compra(id)
);
CREATE TABLE parametro (
	id INT NOT NULL AUTO_INCREMENT,
    enumParametro varchar(100) NOT NULL,
	valor varchar(100) NOT NULL,
    descripcion varchar(100) NOT NULL,
	PRIMARY KEY (id)
);