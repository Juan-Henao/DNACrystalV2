insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());
INSERT INTO cliente(id, nombres , apellidos , identificacion,email,fecha_creacion) VALUES ( 1, 'Juan','Henao', 12345, 'jhenao@mail.com', now() );insert into vehiculo(cliente,placa) values('1','test');
INSERT INTO vehiculo (id, idCliente , total , fechaCompra,fechaEntrega,estadoCompra) VALUES ( 1, 1,20000, '2021-04-21 16:15:16', '2021-04-24 16:15:16' , 'EN_PROCESO');

insert into servicio (vehiculo, fecha_entrada, activo) values ('1', '2021-04-13 08:08:52', '1');