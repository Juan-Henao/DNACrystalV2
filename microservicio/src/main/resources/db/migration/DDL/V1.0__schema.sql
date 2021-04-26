create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table cliente (
	id INT NOT NULL AUTO_INCREMENT,
	nombres varchar(100) NOT NULL,
	apellidos varchar(100) NOT NULL,
	identificacion varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	fecha_creacion datetime,
	PRIMARY KEY (id)
);

create table vehiculo (
	id INT NOT NULL AUTO_INCREMENT,
    idCliente INT NOT NULL,
    total DOUBLE NOT NULL,
    fechaCompra datetime,
    fechaEntrega datetime,
    estadoCompra varchar(100) NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (idCliente) REFERENCES cliente(id)
);

create table servicio (
    id int(11) not null auto_increment,
    vehiculo int(11) not null,
    fecha_entrada datetime null,
    fecha_salida datetime null,
    activo int(1) null,
    valor_a_pagar double null,
    horas int(11) null,
    primary key (id),
    foreign key (vehiculo) references vehiculo(id)
    on delete restrict
);