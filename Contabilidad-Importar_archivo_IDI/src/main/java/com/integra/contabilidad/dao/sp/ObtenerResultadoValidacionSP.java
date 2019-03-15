package com.integra.contabilidad.dao.sp;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.integra.contabilidad.util.Procedimientos;

public class ObtenerResultadoValidacionSP extends StoredProcedure {
	
	private static final String PARAMETRO_OUT_RESULTADO_VALIDACION = "@nValida";
	
	public ObtenerResultadoValidacionSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.OBTENER_RESULTADO_VALIDACION);
		
		declareParameter(new SqlParameter("@cUsuario", Types.VARCHAR));
		declareParameter(new SqlOutParameter("@nValida", Types.INTEGER));
		
		compile();
	}
	
	public int executeProcedure(String usuarioWindows) {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("@cUsuario", usuarioWindows);
		
		Map<String, Object> out = super.execute(parametrosIn);
		return out.get(PARAMETRO_OUT_RESULTADO_VALIDACION) != null
				? Integer.parseInt(out.get(PARAMETRO_OUT_RESULTADO_VALIDACION).toString())
				: 0;
	}

}