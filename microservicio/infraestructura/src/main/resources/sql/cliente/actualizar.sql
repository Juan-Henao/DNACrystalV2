update cliente
set
	nombres = :nombres,
		apellidos = :apellidos,
		identificacion = :identificacion,
		email = :email,
		fecha_creacion = :fechaCreacion
where id = :id	