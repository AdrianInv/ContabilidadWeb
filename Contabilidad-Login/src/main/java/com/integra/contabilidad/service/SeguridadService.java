/**
 * ************************************************************************************
 * Fecha de Creación        : 13/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.service;

import java.rmi.RemoteException;
import java.util.List;

import com.integra.contabilidad.bean.MenuAplicativo;
import com.integra.contabilidad.bean.UsuarioSeguridad;

public interface SeguridadService {

	public List<MenuAplicativo> listarMenuAplicativo(String token) throws RemoteException;
	
	public UsuarioSeguridad obtenerDatosSesion(String token) throws RemoteException;
	
}