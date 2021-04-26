select count(*)
	from compra
where str_to_date(fecha_cita, "%Y-%m-%d") = :fechaCompra