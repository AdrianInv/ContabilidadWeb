/**
 * ************************************************************************************
 * Fecha de Creación        : 09/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.dao.sp;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.integra.contabilidad.bean.ArchivoImportadoIDI;
import com.integra.contabilidad.util.Procedimientos;
import com.integra.contabilidad.util.Utilitarios.ConversionBigDecimal;

public class ObtenerSumaImportesCargadosPatrimonioSP extends StoredProcedure {
	
	private static final String PARAMETRO_OUT_SUMAS_IDI = "@sumas_del_idi";
	private static final String PARAMETRO_OUT_TIPO_MOVIMIENTO_IDI = "@tipo_movimiento_idi";
	private static final String PARAMETRO_OUT_CANT_REG_IDI = "@cantidad_registros_idi";
	
	public ObtenerSumaImportesCargadosPatrimonioSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.OBTENER_IMPORTES_CARGADOS_PATRIMONIO);
		
		declareParameter(new SqlParameter("@usuarioWindows", Types.VARCHAR));
		declareParameter(new SqlParameter("@fecha_informe", Types.VARCHAR));
		declareParameter(new SqlParameter("@Modulo_Origen", Types.VARCHAR));
		declareParameter(new SqlOutParameter(PARAMETRO_OUT_SUMAS_IDI, Types.NUMERIC));
		declareParameter(new SqlOutParameter(PARAMETRO_OUT_TIPO_MOVIMIENTO_IDI, Types.CHAR));
		declareParameter(new SqlOutParameter(PARAMETRO_OUT_CANT_REG_IDI, Types.INTEGER));
		
		compile();
	}
	
	public ArchivoImportadoIDI executeProcedure(ArchivoImportadoIDI archivo) {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("@usuarioWindows", archivo.getUsuarioWindows());
		parametrosIn.put("@fecha_informe", Integer.parseInt(archivo.getFechaFormatoAS400()));
		parametrosIn.put("@Modulo_Origen", archivo.getTipoModalidad());
		
		Map<String, Object> out = super.execute(parametrosIn);
		archivo.setSumasIDI(out.get(PARAMETRO_OUT_SUMAS_IDI) != null
				? ConversionBigDecimal.forceBigDecimal(String.valueOf(out.get(PARAMETRO_OUT_SUMAS_IDI)))
				: BigDecimal.ZERO);
		archivo.setTipoMovimientoIDI(out.get(PARAMETRO_OUT_TIPO_MOVIMIENTO_IDI) != null
				? String.valueOf(out.get(PARAMETRO_OUT_TIPO_MOVIMIENTO_IDI))
				: "");
		archivo.setCantidadRegistrosIDI(out.get(PARAMETRO_OUT_CANT_REG_IDI) != null
				? Integer.parseInt(out.get(PARAMETRO_OUT_CANT_REG_IDI).toString())
				: 0);

		return archivo;
	}

}