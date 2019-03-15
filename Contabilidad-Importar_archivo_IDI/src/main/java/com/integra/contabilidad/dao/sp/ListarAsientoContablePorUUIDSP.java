package com.integra.contabilidad.dao.sp;

import java.math.BigDecimal;
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

import com.integra.contabilidad.bean.AsientoContable;
import com.integra.contabilidad.util.Procedimientos;

public class ListarAsientoContablePorUUIDSP extends StoredProcedure {

	public ListarAsientoContablePorUUIDSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.LISTAR_ASIENTO_CONTABLES_POR_UUID);
		
		declareParameter(new SqlReturnResultSet("C_LISTAR_ASIENTO_CONTABLES", new RowMapper<AsientoContable>() {

			@Override
			public AsientoContable mapRow(ResultSet arg0, int arg1) throws SQLException {
				AsientoContable asiento = new AsientoContable();
				
				asiento.setPeriodoVoucher(arg0.getString("SAPPE6") != null ? arg0.getString("SAPPE6").trim() : "");
				asiento.setCodigoEmpresa(arg0.getString("SAPC02") != null ? arg0.getString("SAPC02").trim() : "");
				asiento.setCodigoLibroAuxiliar(arg0.getString("SAPC03") != null ? arg0.getString("SAPC03").trim() : "");
				asiento.setNumeroVoucher(arg0.getInt("SAPNU3"));
				asiento.setCorrelativoVoucher(arg0.getInt("SAPCOR"));
				asiento.setFechaVoucher(arg0.getString("SAPF11") != null ? arg0.getString("SAPF11").trim() : "");
				asiento.setTipoAsiento(arg0.getString("SAPTI7") != null ? arg0.getString("SAPTI7").trim() : "");
				asiento.setCodigoCuentaContable(arg0.getString("SAPCU2") != null ? arg0.getString("SAPCU2").trim() : "");
				asiento.setCodigoCentroCosto(arg0.getString("SAPCE2") != null ? arg0.getString("SAPCE2").trim() : "");
				asiento.setCodigoCuentaCorrienteTercero(arg0.getString("SAPCCT") != null ? arg0.getString("SAPCCT").trim() : "");
				asiento.setTipoCuentaCorrienteTercero(arg0.getString("SAPTI8") != null ? arg0.getString("SAPTI8").trim() : "");
				asiento.setCodigoTipoDocumentoBase(arg0.getString("SAPC04") != null ? arg0.getString("SAPC04").trim() : "");
				asiento.setNumeroDocumento(arg0.getString("SAPNU4") != null ? arg0.getString("SAPNU4").trim() : "");
				asiento.setFechaVencimiento(arg0.getString("SAPF12") != null ? arg0.getString("SAPF12").trim() : "");
				asiento.setMontoDebito(arg0.getBigDecimal("SAPMO6") != null ? arg0.getBigDecimal("SAPMO6") : BigDecimal.ZERO);
				asiento.setMontoCredito(arg0.getBigDecimal("SAPMO5") != null ? arg0.getBigDecimal("SAPMO5") : BigDecimal.ZERO);
				asiento.setMoneda(arg0.getString("SAPMO7") != null ? arg0.getString("SAPMO7").trim() : "");
				asiento.setTipoCambio(arg0.getBigDecimal("SAPTI9") != null ? arg0.getBigDecimal("SAPTI9") : BigDecimal.ZERO);
				asiento.setImporteDolares(arg0.getBigDecimal("SAPIM8") != null ? arg0.getBigDecimal("SAPIM8") : BigDecimal.ZERO);
				asiento.setCentroGestion(arg0.getString("SAPCE3") != null ? arg0.getString("SAPCE3").trim() : "");
				asiento.setNombreTercero(arg0.getString("SAPNO4") != null ? arg0.getString("SAPNO4").trim() : "");
				asiento.setGlosaVoucher(arg0.getString("SAPGLO") != null ? arg0.getString("SAPGLO").trim() : "");
				asiento.setDescripcionInterfaz(arg0.getString("SAPD01") != null ? arg0.getString("SAPD01").trim() : "");
				asiento.setPeriodoInterfaz(arg0.getString("SAPPE7") != null ? arg0.getString("SAPPE7").trim() : "");
				asiento.setFechaDocumento(arg0.getString("SAPF13") != null ? arg0.getString("SAPF13").trim() : "");
				
				return asiento;
			}
		}));
		
		declareParameter(new SqlParameter("@PUUID1", Types.VARCHAR));
		compile();
	}
	
	@SuppressWarnings("unchecked")
	public List<AsientoContable> executeProcedure(String uuid) {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("@PUUID1", uuid);
		
		Map<String, Object> out = super.execute(parametrosIn);
		return (List<AsientoContable>) out.get("C_LISTAR_ASIENTO_CONTABLES");
	}

}