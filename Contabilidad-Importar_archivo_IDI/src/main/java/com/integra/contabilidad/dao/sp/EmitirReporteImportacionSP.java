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

import com.integra.contabilidad.reporte.bean.ReporteArchivoPlanoImportado;
import com.integra.contabilidad.util.Constantes;
import com.integra.contabilidad.util.Procedimientos;

public class EmitirReporteImportacionSP extends StoredProcedure {
	
	public EmitirReporteImportacionSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.EMITIR_REPORTE_IMPORTACION);
		
		declareParameter(new SqlReturnResultSet("C_EMITIR_REPORTE", new RowMapper<ReporteArchivoPlanoImportado>() {
			
			@Override
			public ReporteArchivoPlanoImportado mapRow(ResultSet arg0, int arg1) throws SQLException {
				ReporteArchivoPlanoImportado archivoImportadoPlanoBean = new ReporteArchivoPlanoImportado();

				archivoImportadoPlanoBean.setNombreArchivoPlano(arg0.getString("nombreArchivoPlano"));
				archivoImportadoPlanoBean.setTotalDebe(arg0.getBigDecimal("total debe"));
				archivoImportadoPlanoBean.setTotalHaber(arg0.getBigDecimal("total haber"));
				//archivoImportadoPlanoBean.setPeriodoAnio(arg0.getString("periodoAño"));
				archivoImportadoPlanoBean.setPeriodoAnio(arg0.getString(Constantes.getPeriodoYear()));
				archivoImportadoPlanoBean.setPeriodoMes(arg0.getString("periodoMes"));
				archivoImportadoPlanoBean.setFondo(arg0.getString("fondo"));
				archivoImportadoPlanoBean.setLibro(arg0.getString("libro"));
				archivoImportadoPlanoBean.setVoucher(arg0.getString("voucher"));
				archivoImportadoPlanoBean.setCantidadPlano(arg0.getInt("cantidad_plano"));
				archivoImportadoPlanoBean.setCcdCantidadRegistros(arg0.getInt("ccd_cantidadRegistros"));
				archivoImportadoPlanoBean.setCcdTotalDebe(arg0.getBigDecimal("ccd_total_debe"));
				archivoImportadoPlanoBean.setCcdTotalHaber(arg0.getBigDecimal("ccd_total_haber"));
				archivoImportadoPlanoBean.setIdiCantidadRegistros(arg0.getInt("idi_cantidadRegistros"));
				archivoImportadoPlanoBean.setIdiSumatoria(arg0.getBigDecimal("idi_sumatoria"));
				archivoImportadoPlanoBean.setIdiTipoMovimiento(arg0.getString("idi_tipoMovimiento"));
				archivoImportadoPlanoBean.setIndOK(arg0.getInt("ind_OK"));
				archivoImportadoPlanoBean.setCantidadArchivosProcesados(arg0.getInt("cantidad_archivos_procesados"));
				archivoImportadoPlanoBean.setCantidadArchivosConError(arg0.getInt("cantidad_archivos_con_error"));
				archivoImportadoPlanoBean.setCantidadArchivosCorrectos(arg0.getInt("cantidad_archivos_correctos"));
				
				return archivoImportadoPlanoBean;
			}
		}));
		
		declareParameter(new SqlParameter("@usuarioWindows", Types.VARCHAR));
		compile();
	}
	
	@SuppressWarnings("unchecked")
	public List<ReporteArchivoPlanoImportado> executeProcedure(String codigoUsuario) {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("@usuarioWindows", codigoUsuario);
		
		Map<String, Object> out = super.execute(parametrosIn);
		return (List<ReporteArchivoPlanoImportado>) out.get("C_EMITIR_REPORTE");
	}

}