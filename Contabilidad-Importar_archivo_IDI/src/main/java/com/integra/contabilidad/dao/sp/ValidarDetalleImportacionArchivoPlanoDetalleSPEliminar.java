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

import com.integra.contabilidad.bean.ArchivoImportadoIDI;
import com.integra.contabilidad.reporte.bean.ValidacionArchivoPlano;
import com.integra.contabilidad.util.Procedimientos;

public class ValidarDetalleImportacionArchivoPlanoDetalleSPEliminar extends StoredProcedure {
	
	public ValidarDetalleImportacionArchivoPlanoDetalleSPEliminar(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.VALIDAR_ARCHIVOS_A_TRANSFERIR);
		
		declareParameter(new SqlReturnResultSet("C_VALIDA_ARCHIVO_TRANSFERIR", new RowMapper<ValidacionArchivoPlano>() {
			
			@Override
			public ValidacionArchivoPlano mapRow(ResultSet arg0, int arg1) throws SQLException {
				ValidacionArchivoPlano validacionArchivo = new ValidacionArchivoPlano();
				
				validacionArchivo.setCodigoValidacion(arg0.getInt(1));
				validacionArchivo.setNumeroRegistro((int) arg0.getFloat(2));
				validacionArchivo.setComentarioValidacion(arg0.getString(3).trim());
				
				return validacionArchivo;
			}
		}));
		
		declareParameter(new SqlParameter("@cUsuario", Types.VARCHAR));
		declareParameter(new SqlParameter("@nAno", Types.SMALLINT));
		declareParameter(new SqlParameter("@nMes", Types.SMALLINT));
		declareParameter(new SqlParameter("@cCodigoFondo", Types.VARCHAR));
		declareParameter(new SqlParameter("@UUID", Types.VARCHAR));
		declareParameter(new SqlParameter("@Nombre_Archivo", Types.VARCHAR));
		
		compile();
	}
	
	@SuppressWarnings("unchecked")
	public List<ValidacionArchivoPlano> executeProcedure(ArchivoImportadoIDI archivo) {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("@cUsuario", archivo.getUsuarioWindows());
		parametrosIn.put("@nAno", Integer.parseInt(archivo.getYear()));
		parametrosIn.put("@nMes", Integer.parseInt(archivo.getMes()));
		parametrosIn.put("@cCodigoFondo", archivo.getCodigoFondo());
		parametrosIn.put("@UUID", archivo.getUuid());
		parametrosIn.put("@Nombre_Archivo", archivo.getNombreArchivo());
		
		Map<String, Object> out = super.execute(parametrosIn);
		return (List<ValidacionArchivoPlano>) out.get("C_VALIDA_ARCHIVO_TRANSFERIR");
	}

}