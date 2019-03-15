/**
 * ************************************************************************************
 * Fecha de Creación        : 12/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.dao;

import com.integra.contabilidad.bean.Trabajador;

public interface TrabajadorDAO {

	public Trabajador obtenerDatosTrabajador(String codigoTrajador);
	
}