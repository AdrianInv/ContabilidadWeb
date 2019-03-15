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

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.integra.contabilidad.bean.Asiento;
import com.integra.contabilidad.util.Procedimientos;

public class ObtenerUUIDSP extends StoredProcedure {

	private static final String PARAMETRO_IN_UUID = "PUUID";
	
	public ObtenerUUIDSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.OBTENER_UUID_ARCHIVO);
		
		declareParameter(new SqlParameter("PNOMARC", Types.VARCHAR));
		declareParameter(new SqlOutParameter("PUUID", Types.VARCHAR));
		declareParameter(new SqlOutParameter("PDESASI", Types.VARCHAR));
		declareParameter(new SqlOutParameter("PINDORP", Types.VARCHAR));
		declareParameter(new SqlOutParameter("STATUS", Types.NUMERIC));
		
		compile();
	}
	
	public Asiento executeProcedure(String nombreArchivo) {
		Asiento asiento = null;
		
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("PNOMARC", nombreArchivo);
		
		Map<String, Object> out = super.execute(parametrosIn);
		
		if (out.get(PARAMETRO_IN_UUID) != null) {
			asiento = new Asiento();
			asiento.setUuid(out.get(PARAMETRO_IN_UUID).toString().trim());
			asiento.setDescripcionAsiento(out.get("PDESASI").toString().trim());
			asiento.setFlagGeneraOrdenPago(out.get("PINDORP").toString().trim());
		}
		return asiento;
	}

}