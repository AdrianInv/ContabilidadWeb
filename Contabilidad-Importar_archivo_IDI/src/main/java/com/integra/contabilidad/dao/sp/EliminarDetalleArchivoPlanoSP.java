package com.integra.contabilidad.dao.sp;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.integra.contabilidad.util.Procedimientos;

public class EliminarDetalleArchivoPlanoSP extends StoredProcedure {

	public EliminarDetalleArchivoPlanoSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.ELIMINAR_DETALLE_ARCHIVO);
		
		declareParameter(new SqlParameter("@cUsuario", Types.VARCHAR));
		declareParameter(new SqlOutParameter("@cMsgRetorno", Types.VARCHAR));
		compile();
	}
	
	public void executeProcedure(String usuarioWindows) {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("@cUsuario", usuarioWindows);
		
		super.execute(parametrosIn);
	}
}
