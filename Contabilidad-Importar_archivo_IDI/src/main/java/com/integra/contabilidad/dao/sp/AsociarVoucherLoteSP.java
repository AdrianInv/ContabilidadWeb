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

import com.integra.contabilidad.bean.ArchivoImportadoIDI;
import com.integra.contabilidad.util.Procedimientos;

public class AsociarVoucherLoteSP extends StoredProcedure {
	
	public AsociarVoucherLoteSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.ASOCIAR_VOUCHER_LOTE);
		
		declareParameter(new SqlParameter("@CODIGO_FONDO", Types.VARCHAR));
		declareParameter(new SqlParameter("@ANO", Types.VARCHAR));
		declareParameter(new SqlParameter("@MES", Types.VARCHAR));
		declareParameter(new SqlParameter("@USUARIO", Types.VARCHAR));
		declareParameter(new SqlOutParameter("@mensajeRetorno", Types.VARCHAR));
		
		compile();
	}
	
	public void executeProcedure(ArchivoImportadoIDI archivo) {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("@CODIGO_FONDO", archivo.getCodigoFondo());
		parametrosIn.put("@ANO", archivo.getYear());
		parametrosIn.put("@MES", archivo.getMes());
		parametrosIn.put("@USUARIO", archivo.getUsuarioWindows());
		
		super.execute(parametrosIn);	
	}

}