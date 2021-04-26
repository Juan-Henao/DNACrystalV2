package com.ceiba.configuracion;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.ServicioActualizarCompra;
import com.ceiba.compra.servicio.ServicioCrearCompra;
import com.ceiba.compra.servicio.ServicioEliminarCompra;
import com.ceiba.itemsCompra.puerto.dao.DaoItemsCompra;
import com.ceiba.itemsCompra.puerto.repositorio.RepositorioItemsCompra;
import com.ceiba.itemsCompra.servicio.ServicioActualizarItemsCompra;
import com.ceiba.itemsCompra.servicio.ServicioCrearItemsCompra;
import com.ceiba.itemsCompra.servicio.ServicioEliminarItemsCompra;
import com.ceiba.parametro.puerto.dao.DaoParametro;
import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {
	
	/*
	 * 
	 * SERVICIOS DEL USUARIO
	 * 
	 */
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
    
	
	/*
	 * 
	 * SERVICIOS DEL COMPRA
	 * 
	 */
    @Bean
    public ServicioCrearCompra servicioCrearCompra(RepositorioCompra repositorioCompra, DaoParametro daoParametro, DaoItemsCompra daoItemsCompra) {
        return new ServicioCrearCompra(repositorioCompra, daoParametro, daoItemsCompra);
    }

    @Bean
    public ServicioEliminarCompra servicioEliminarCompra(RepositorioCompra repositorioCompra) {
        return new ServicioEliminarCompra(repositorioCompra);
    }

    @Bean
    public ServicioActualizarCompra servicioActualizarCompra(RepositorioCompra repositorioCompra, 
    		DaoParametro daoParametro, DaoItemsCompra daoItemsCompra) {
        return new ServicioActualizarCompra(repositorioCompra,daoParametro);
    }
    
    /*
	 * 
	 * SERVICIOS DE ITEMSCOMPRA
	 * 
	 */
    @Bean
    public ServicioCrearItemsCompra servicioCrearItemsCompra(RepositorioItemsCompra repositorioItemsCompra, DaoParametro daoParametro,
    		ServicioActualizarCompra servicioActualizarCompra, DaoCompra daoCompra) {
        return new ServicioCrearItemsCompra(repositorioItemsCompra, daoParametro,servicioActualizarCompra,daoCompra);
    }

    @Bean
    public ServicioEliminarItemsCompra servicioEliminarItemsCompra(RepositorioItemsCompra repositorioItemsCompra,ServicioActualizarCompra servicioActualizarCompra,
    		DaoCompra daoCompra,DaoItemsCompra daoItemsCompra) {
        return new ServicioEliminarItemsCompra(repositorioItemsCompra, servicioActualizarCompra, daoCompra, daoItemsCompra);
    }

    @Bean
    public ServicioActualizarItemsCompra servicioActualizarItemsCompra(RepositorioItemsCompra repositorioItemsCompra ,
    		DaoParametro daoParametro,ServicioActualizarCompra servicioActualizarCompra, DaoCompra daoCompra) {
        return new ServicioActualizarItemsCompra(repositorioItemsCompra, daoParametro, servicioActualizarCompra, daoCompra);
    }
    


    
	

}
