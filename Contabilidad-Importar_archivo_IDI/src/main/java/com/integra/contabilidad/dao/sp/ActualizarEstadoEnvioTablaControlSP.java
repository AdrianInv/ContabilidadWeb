/**
 * ************************************************************************************
 * Fecha de Creación        : 09/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.dao.sp;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.integra.contabilidad.bean.Asiento;
import com.integra.contabilidad.util.Procedimientos;

public class ActualizarEstadoEnvioTablaControlSP extends StoredProcedure {
	
	public ActualizarEstadoEnvioTablaControlSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.ACTUALIZAR_ESTADO_ENVIO_TABLA_CONTROL);
		
		declareParameter(new SqlParameter("PUUIDAP", Types.VARCHAR));
		declareParameter(new SqlParameter("PESTADO", Types.VARCHAR));
		declareParameter(new SqlParameter("PSAPOBS", Types.VARCHAR));
		declareParameter(new SqlParameter("PSAPU01", Types.VARCHAR));
		
		compile();
	}
	
	public void executeProcedure(Asiento asiento) {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("PUUIDAP", asiento.getUuid());
		parametrosIn.put("PESTADO", asiento.getEstado());
		parametrosIn.put("PSAPOBS", asiento.getObservacion());
		parametrosIn.put("PSAPU01", asiento.getUsuarioCreacion());
		
		super.execute(parametrosIn);
	}

}