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

import com.integra.contabilidad.util.Procedimientos;

public class ValidarFacturaFormatoCorrectoSP extends StoredProcedure {
	
	public ValidarFacturaFormatoCorrectoSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.VALIDAR_CUENTA_ARCHIVO);
		
		declareParameter(new SqlReturnResultSet("C_VALIDAR_CUENTA_ARCHIVO", new RowMapper<String>() {
			
			@Override
			public String mapRow(ResultSet arg0, int arg1) throws SQLException {
				return arg0.getString("nbavou");
			}
		}));
		
		declareParameter(new SqlParameter("@usuario", Types.VARCHAR));
		compile();
	}
	
	@SuppressWarnings("unchecked")
	public int executeProcedure(String usuarioWindows) {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("@usuario", usuarioWindows);
		
		Map<String, Object> out = super.execute(parametrosIn);
		List<String> list = (List<String>) out.get("C_VALIDAR_CUENTA_ARCHIVO");
		
		return !list.isEmpty() ? list.size() : 0;
	}

}