/**
 * ************************************************************************************
 * Fecha de Creación        : 12/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.dao;

import java.util.List;

import com.integra.contabilidad.bean.LogImportacion;

public interface LogImportacionDAO {

	public List<LogImportacion> listarLogPorUUID(String uuid, String codigoEmpresa);
	
	public void ingresarLogTablaValidacion(LogImportacion log);
	
}