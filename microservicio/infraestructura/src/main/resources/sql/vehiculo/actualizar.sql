update compra
set idCliente = :idCliente,
	total = :total,
		fechaCompra = :fechaCompra,	
	fechaEntrega = :fechaEntrega,
	estadoCompra = :estadoCompra
where id = :id
