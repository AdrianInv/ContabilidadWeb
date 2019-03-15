/**
 * ************************************************************************************
 * Fecha de Creación        : 07/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.dao;

import java.util.Map;

import com.integra.contabilidad.bean.Empresa;
import com.integra.contabilidad.bean.UsuarioContabilidad;

public interface LoginDAO {

	public UsuarioContabilidad obtenerDatosUsuario(String codigoUsuario);
	
	public Map<String, Object> actualizarPeriodo(UsuarioContabilidad usuario);
	
	public Empresa obtenerDatosEmpresa(String codigoEmpresa);
	
}