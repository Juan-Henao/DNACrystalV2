select 
co.id as id_compra ,
co.total as total_compra ,
co.fechaCompra as fecha_compra ,
co.fechaEntrega as fecha_entrega,
co.estadoCompra as estado_compra,
 cl.id as id_cliente,
 cl.nombres as nombres_cliente,
 cl.apellidos as apellidos_cliente,
 cl.email as email_cliente,
 cl.identificacion as identificacion_cliente,
 cl.fecha_creacion as fecha_creacion_cliente
from  compra co join cliente cl on cl.id = co.idCliente
