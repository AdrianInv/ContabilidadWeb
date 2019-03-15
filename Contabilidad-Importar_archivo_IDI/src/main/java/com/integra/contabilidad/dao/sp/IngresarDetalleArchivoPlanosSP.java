package com.integra.contabilidad.dao.sp;

import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.integra.contabilidad.util.Procedimientos;

public class IngresarDetalleArchivoPlanosSP extends StoredProcedure {

	public IngresarDetalleArchivoPlanosSP(DataSource ds) {
		setDataSource(ds);
        setSql(Procedimientos.INGRESAR_DETALLE_ARCHIVO);
        
        declareParameter(new SqlParameter("@cUsuVou", Types.VARCHAR));
        declareParameter(new SqlParameter("@cPerVou", Types.VARCHAR));
        declareParameter(new SqlParameter("@cConVou", Types.VARCHAR));
        declareParameter(new SqlParameter("@cDfuVou", Types.VARCHAR));
        declareParameter(new SqlParameter("@cNduVou", Types.VARCHAR));
        declareParameter(new SqlParameter("@nSecVou", Types.FLOAT));
        declareParameter(new SqlParameter("@dFecVou", Types.VARCHAR));
        declareParameter(new SqlParameter("@cAsiVou", Types.VARCHAR));
        declareParameter(new SqlParameter("@cCtaVou", Types.VARCHAR));
        declareParameter(new SqlParameter("@cCecVou", Types.VARCHAR));
        declareParameter(new SqlParameter("@cCteVou", Types.VARCHAR));
        declareParameter(new SqlParameter("@cTteVou", Types.VARCHAR));
        declareParameter(new SqlParameter("@cDbaVou", Types.VARCHAR));
        declareParameter(new SqlParameter("@cNbaVou", Types.VARCHAR));
        declareParameter(new SqlParameter("@dFveVou", Types.VARCHAR));
        declareParameter(new SqlParameter("@nDebVou", Types.FLOAT));
        declareParameter(new SqlParameter("@nHabVou", Types.FLOAT));
        declareParameter(new SqlParameter("@cMonVou", Types.VARCHAR));
        declareParameter(new SqlParameter("@nTcaVou", Types.FLOAT));
        declareParameter(new SqlParameter("@nVomVou", Types.FLOAT));
        declareParameter(new SqlParameter("@cCgeVou", Types.VARCHAR));
        declareParameter(new SqlParameter("@cNteVou", Types.VARCHAR));
        declareParameter(new SqlParameter("@cGloVou", Types.VARCHAR));
        declareParameter(new SqlParameter("@cDes_Trans", Types.VARCHAR));
        declareParameter(new SqlParameter("@cPer_Trans", Types.VARCHAR));
        declareParameter(new SqlParameter("@nReg_Trans", Types.FLOAT));
        declareParameter(new SqlParameter("@cfdoVou", Types.VARCHAR));
        declareParameter(new SqlParameter("@fecha_doc_rel", Types.VARCHAR));
        declareParameter(new SqlParameter("@tipo_doc_rel", Types.VARCHAR));
        declareParameter(new SqlParameter("@nro_doc_rel", Types.VARCHAR));
        declareParameter(new SqlParameter("@NombreArchivoPlano", Types.VARCHAR));
        declareParameter(new SqlOutParameter("@cMsgRetorno", Types.VARCHAR));
        compile();
	}

	public void executeProcedure(Map<String, Object> parametrosIn) {
		super.execute(parametrosIn);
	}

}