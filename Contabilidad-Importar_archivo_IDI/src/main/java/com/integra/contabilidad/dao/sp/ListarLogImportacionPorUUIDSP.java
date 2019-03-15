/**
 * ************************************************************************************
 * Fecha de Creación        : 09/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.dao.sp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import com.integra.contabilidad.bean.LogImportacion;
import com.integra.contabilidad.util.Procedimientos;

public class ListarLogImportacionPorUUIDSP extends StoredProcedure {
	
	public ListarLogImportacionPorUUIDSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.LISTAR_LOG_IMPORTACION_POR_UUID);
		
		declareParameter(new SqlReturnResultSet("C_LISTAR_LOG_IMPORTACION_XUUID", new RowMapper<LogImportacion>() {

			@Override
			public LogImportacion mapRow(ResultSet arg0, int arg1) throws SQLException {
				LogImportacion logImportacionBean = new LogImportacion();

				logImportacionBean.setNombreArchivo(arg0.getString("Nombre_archivo"));
				logImportacionBean.setTipoValidacion(arg0.getString("Tipo_validacion"));
				logImportacionBean.setSecuencia(arg0.getInt("Secuencia"));
				logImportacionBean.setUuid(arg0.getString("UUID_archivo_plano"));
				logImportacionBean.setCodigoValidacion(arg0.getInt("Codigo_validacion"));
				logImportacionBean.setDescripcionValidacion(arg0.getString("Descripcion_Validacion"));
				
				return logImportacionBean;
			}
		}));
		declareParameter(new SqlParameter("@UUID_archivo_plano", Types.VARCHAR));
		compile();
	}
	
	@SuppressWarnings("unchecked")
	public List<LogImportacion> executeProcedure(String uuid) {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("@UUID_archivo_plano", uuid);
		
		Map<String, Object> out = super.execute(parametrosIn);
		return (List<LogImportacion>) out.get("C_LISTAR_LOG_IMPORTACION_XUUID");
	}

}
