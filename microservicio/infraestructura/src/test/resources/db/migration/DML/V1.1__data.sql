INSERT INTO rol(id, nombre_rol) VALUES ( 1, 'administrador' );
insert into usuario(username,password,idRol) values('test','1234',1);
INSERT INTO parametro(id, enumParametro, valor, descripcion) VALUES ( 1, 'HORA_ENTRADA',1, 'Hora en la que se empieza a atender' );
INSERT INTO parametro(id, enumParametro, valor, descripcion) VALUES ( 2, 'HORA_SALIDA',24, 'Hora en la que termina de atender' );
INSERT INTO parametro(id, enumParametro, valor, descripcion) VALUES ( 3, 'MONOLITICOS',500, 'Cristal de tipo monolitico' );
INSERT INTO parametro(id, enumParametro, valor, descripcion) VALUES ( 4, 'LAMINADOS',2500, 'Cristal de tipo laminado' );
INSERT INTO parametro(id, enumParametro, valor, descripcion) VALUES ( 5, 'DOBLE_ACRISTALAMIENTO',50000, 'Cristal de tipo doble acristalamiento' );
INSERT INTO parametro(id, enumParametro, valor, descripcion) VALUES ( 6, 'TEMPLADOS',10000, 'Cristal de tipo templados' );
INSERT INTO parametro(id, enumParametro, valor, descripcion) VALUES ( 7, 'FESTIVOS','2021-04-16', 'Dia Festivo' );
INSERT INTO parametro(id, enumParametro, valor, descripcion) VALUES ( 8, 'DIAS_MINIMOS_FECHA_COMPRA',5, 'Cantidad minima de dias habiles para entregar la compra' );
INSERT INTO parametro(id, enumParametro, valor, descripcion) VALUES ( 9, 'DIAS_MAXIMOS_FECHA_COMPRA',8, 'Cantidad minima de dias habiles para entregar la compra' );
INSERT INTO parametro(id, enumParametro, valor, descripcion) VALUES ( 10, 'MULTA_CANCELACION_COMPRA',50000, 'Multa en caso de que se cancele la compra' );
INSERT INTO parametro(id, enumParametro, valor, descripcion) VALUES ( 11, 'MAXIMO_ANCHO_ITEM',4, 'Maximo Ancho Item' );
INSERT INTO parametro(id, enumParametro, valor, descripcion) VALUES ( 12, 'MAXIMO_LARGO_ITEM',4, 'Maximo Largo Item' );
INSERT INTO parametro(id, enumParametro, valor, descripcion) VALUES ( 13, 'MAXIMO_ITEMS_POSIBLES',100, 'Maxima Cantidad Items Posibles' );
INSERT INTO parametro(id, enumParametro, valor, descripcion) VALUES ( 14, 'ITEMS_MINIMOS_DESCUENTO',10, 'Cantidad de items para descuento' );
INSERT INTO parametro(id, enumParametro, valor, descripcion) VALUES ( 15, 'DESCUENTO',15, 'Descuento' );
INSERT INTO parametro(id, enumParametro, valor, descripcion) VALUES ( 16, 'RECARGO_FIN_SEMANA',0.1, 'Recargo Fin de Semana' );



INSERT INTO cliente(id, nombres , apellidos , identificacion,email,fecha_creacion) VALUES ( 1, 'Juan','Henao', 12345, 'jhenao@mail.com', now() );
INSERT INTO compra (id, idCliente , total , fechaCompra,fechaEntrega,estadoCompra) VALUES ( 1, 1,20000, '2021-04-21 16:15:16', '2021-04-24 16:15:16' , 'EN_PROCESO');
INSERT INTO itemsCompra(id, cantidad , idCompra , valor, ancho,largo,fechaCreacion) VALUES ( 1, 1,1, 20000, 2, 2, now() );

