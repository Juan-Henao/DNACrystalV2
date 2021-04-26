insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());
INSERT INTO cliente(id, nombres , apellidos , identificacion,email,fecha_creacion) VALUES ( 1, 'Juan','Henao', 12345, 'jhenao@mail.com', now() );
INSERT INTO compra (id, idCliente , total , fechaCompra,fechaEntrega,estadoCompra) VALUES ( 1, 1,20000, '2021-04-21 16:15:16', '2021-04-24 16:15:16' , 'EN_PROCESO');
INSERT INTO itemsCompra(id, cantidad , idCompra , valor, ancho,largo,fechaCreacion) VALUES ( 1, 1,1, 20000, 2, 2, now() );