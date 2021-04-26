package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.ServicioActualizarCompra;
import com.ceiba.compra.servicio.ServicioCrearCompra;
import com.ceiba.compra.servicio.ServicioEliminarCompra;
import com.ceiba.itemsCompra.puerto.repositorio.RepositorioItemsCompra;
import com.ceiba.itemsCompra.servicio.ServicioActualizarItemsCompra;
import com.ceiba.itemsCompra.servicio.ServicioCrearItemsCompra;
import com.ceiba.itemsCompra.servicio.ServicioEliminarItemsCompra;
import com.ceiba.parametro.puerto.dao.DaoParametro;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;

@Configuration
public class BeanServicio {
	
	/*
	 * 
	 * SERVICIOS DE ITEMSCOMPRA
	 * 
	 */
    @Bean
    public ServicioCrearItemsCompra servicioCrearItemsCompra(RepositorioItemsCompra repositorioItemsCompra, DaoParametro daoParametro) {
        return new ServicioCrearItemsCompra(repositorioItemsCompra, daoParametro);
    }

    @Bean
    public ServicioEliminarItemsCompra servicioEliminarItemsCompra(RepositorioItemsCompra repositorioItemsCompra) {
        return new ServicioEliminarItemsCompra(repositorioItemsCompra);
    }

    @Bean
    public ServicioActualizarItemsCompra servicioActualizarItemsCompra(RepositorioItemsCompra repositorioItemsCompra ,
    		DaoParametro daoParametro) {
        return new ServicioActualizarItemsCompra(repositorioItemsCompra, daoParametro);
    }

	/*
	 * 
	 * SERVICIOS DEL COMPRA
	 * 
	 */
    @Bean
    public ServicioCrearCompra servicioCrearCompra(RepositorioCompra repositorioCompra, DaoParametro daoParametro) {
        return new ServicioCrearCompra(repositorioCompra, daoParametro);
    }

    @Bean
    public ServicioEliminarCompra servicioEliminarCompra(RepositorioCompra repositorioCompra) {
        return new ServicioEliminarCompra(repositorioCompra);
    }

    @Bean
    public ServicioActualizarCompra servicioActualizarCompra(RepositorioCompra repositorioCompra, 
    		DaoParametro daoParametro) {
        return new ServicioActualizarCompra(repositorioCompra,daoParametro);
    }
    
    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
	
    
    /*
	 * 
	 * SERVICIOS DEL CLIENTE
	 * 
	 */
    
    @Bean
    public ServicioCrearCliente servicioCrearCliente(RepositorioCliente repositorioCliente) {
        return new ServicioCrearCliente(repositorioCliente);
    }

    @Bean
    public ServicioEliminarCliente servicioEliminarCliente(RepositorioCliente repositorioCliente) {
        return new ServicioEliminarCliente(repositorioCliente);
    }

    @Bean
    public ServicioActualizarCliente servicioActualizarCliente(RepositorioCliente repositorioCliente) {
        return new ServicioActualizarCliente(repositorioCliente);
    }

}
