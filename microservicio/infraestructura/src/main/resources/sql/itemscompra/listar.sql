select 
ic.id as id_item_compra,
ic.cantidad as item_cantidad ,
ic.valor as item_valor ,
ic.ancho as item_largo,
ic.largo as item_ancho,
ic.fechaCreacion item_fecha_creacion,
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
from itemsCompra ic join compra co on ic.idCompra = co.id join cliente cl on cl.id = co.idCliente