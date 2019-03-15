/**
 * ************************************************************************************
 * Fecha de Creación        : 12/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.integra.contabilidad.bean.ControlEnvioAsiento;
import com.integra.contabilidad.bean.Asiento;
import com.integra.contabilidad.dao.ControlAsientoDAO;
import com.integra.contabilidad.dao.sp.ActualizarEstadoEnvioTablaControlSP;
import com.integra.contabilidad.dao.sp.ListarAsientoATransferirPremiumSP;
import com.integra.contabilidad.dao.sp.ObtenerUUIDSP;
import com.integra.contabilidad.dao.sp.ObtenerUsuarioYMotivoSP;

@Repository
public class ControlAsientoDAOImpl implements ControlAsientoDAO {

	@Qualifier("dsContaAS400")
	@Autowired
	private DataSource dsContabilidadAS400;

	@Override
	public Asiento obtenerUsuarioMotivo(String nombreArchivo) {
		ObtenerUsuarioYMotivoSP sp = new ObtenerUsuarioYMotivoSP(dsContabilidadAS400);
		return sp.executeProcedure(nombreArchivo);
	}

	@Override
	public Asiento obtenerUUID(String nombreArchivo) {
		ObtenerUUIDSP sp = new ObtenerUUIDSP(dsContabilidadAS400);
		return sp.executeProcedure(nombreArchivo);
	}

	@Override
	public void actualizarEstadoEnvio(Asiento asiento) {
		ActualizarEstadoEnvioTablaControlSP sp = new ActualizarEstadoEnvioTablaControlSP(dsContabilidadAS400);
		sp.executeProcedure(asiento);
	}

	@Override
	public List<ControlEnvioAsiento> listarArchivosTransferenciaPREMIUM(String fondo) {
		ListarAsientoATransferirPremiumSP sp = new ListarAsientoATransferirPremiumSP(dsContabilidadAS400);
		return sp.executeProcedure(fondo);
	}
	
}