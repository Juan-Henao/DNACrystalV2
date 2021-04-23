CREATE TABLE rol (
	id INT NOT NULL AUTO_INCREMENT,
	nombre_rol varchar(100) NOT NULL,
	PRIMARY KEY (id)
);

create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);
