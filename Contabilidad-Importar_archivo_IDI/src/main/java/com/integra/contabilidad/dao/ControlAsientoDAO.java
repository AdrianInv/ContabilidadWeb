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

import com.integra.contabilidad.bean.ControlEnvioAsiento;
import com.integra.contabilidad.bean.Asiento;

public interface ControlAsientoDAO {

	public Asiento obtenerUsuarioMotivo(String nombreArchivo);
	
	public Asiento obtenerUUID(String nombreArchivo);
	
	public void actualizarEstadoEnvio(Asiento asiento);
	
	public List<ControlEnvioAsiento> listarArchivosTransferenciaPREMIUM(String fondo);
	
}