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

import com.integra.contabilidad.bean.ControlEnvioAsiento;
import com.integra.contabilidad.reporte.bean.ValidacionArchivoPlano;
import com.integra.contabilidad.util.Procedimientos;
import com.integra.contabilidad.util.Utilitarios;

public class ValidarDetalleArchivoPlanoSP extends StoredProcedure {

	public ValidarDetalleArchivoPlanoSP(DataSource ds) {
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
	public List<ValidacionArchivoPlano> executeProcedure(ControlEnvioAsiento controlAsiento) {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("@cUsuario", controlAsiento.getUsuarioWindows());
		parametrosIn.put("@nAno", !Utilitarios.isNullOrEmpty(controlAsiento.getYear()) ? Integer.parseInt(controlAsiento.getYear()) : 0);
		parametrosIn.put("@nMes", !Utilitarios.isNullOrEmpty(controlAsiento.getMes()) ? Integer.parseInt(controlAsiento.getMes()) : 0);
		parametrosIn.put("@cCodigoFondo", controlAsiento.getFondo());
		parametrosIn.put("@UUID", controlAsiento.getUuid());
		parametrosIn.put("@Nombre_Archivo", controlAsiento.getNombreArchivo());
		
		Map<String, Object> out = super.execute(parametrosIn);
		return (List<ValidacionArchivoPlano>) out.get("C_VALIDA_ARCHIVO_TRANSFERIR");
	}
	
}