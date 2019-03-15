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
import com.integra.contabilidad.bean.ArchivoImportadoIDIDetalle;
import com.integra.contabilidad.util.Procedimientos;

public class IngresarImportacionArchivoPlanosDetalleSPEliminar extends StoredProcedure {

    public IngresarImportacionArchivoPlanosDetalleSPEliminar(DataSource ds) {
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

    public void executeProcedure(ArchivoImportadoIDI archivo, ArchivoImportadoIDIDetalle detalleArchivo) {
        Map<String, Object> parametrosIn = new HashMap<>();
        
        parametrosIn.put("@cUsuVou", archivo.getUsuarioWindows());
        parametrosIn.put("@cPerVou", archivo.getYear() + archivo.getMes());
        parametrosIn.put("@cConVou", detalleArchivo.getCodigoEmpresa());
        parametrosIn.put("@cDfuVou", detalleArchivo.getCodigoLibroAuxiliar());
        parametrosIn.put("@cNduVou", detalleArchivo.getNumeroVoucher());
        parametrosIn.put("@nSecVou", detalleArchivo.getCorrelativoVoucher());
        parametrosIn.put("@dFecVou", archivo.getFecha());
        parametrosIn.put("@cAsiVou", detalleArchivo.getCodigoTipoAsiento());
        parametrosIn.put("@cCtaVou", detalleArchivo.getCodigoCuentaContable());
        parametrosIn.put("@cCecVou", detalleArchivo.getCodigoCentroCosto());
        parametrosIn.put("@cCteVou", detalleArchivo.getCodigoCuentaCorrienteTercero());
        parametrosIn.put("@cTteVou", detalleArchivo.getTipoCuentaCorrienteTercero());
        parametrosIn.put("@cDbaVou", detalleArchivo.getCodigoTipoDocumento());
        parametrosIn.put("@cNbaVou", detalleArchivo.getNumeroDocumento());
        parametrosIn.put("@dFveVou", detalleArchivo.getFechaVencimiento());
        parametrosIn.put("@nDebVou", detalleArchivo.getDebe());
        parametrosIn.put("@nHabVou", detalleArchivo.getHaber());
        parametrosIn.put("@cMonVou", detalleArchivo.getTipoMoneda());
        parametrosIn.put("@nTcaVou", detalleArchivo.getTipoCambioMovimiento());
        parametrosIn.put("@nVomVou", detalleArchivo.getValorOtraMonedaMovimiento());
        parametrosIn.put("@cCgeVou", detalleArchivo.getCodigoCentroGestion());
        parametrosIn.put("@cNteVou", detalleArchivo.getNombreCuentaCorrienteTercero());
        parametrosIn.put("@cGloVou", detalleArchivo.getGlosaVoucher());
        parametrosIn.put("@cDes_Trans", detalleArchivo.getDescripcionArchivoInterfase());
        parametrosIn.put("@cPer_Trans", archivo.getYear() + archivo.getMes());
        parametrosIn.put("@nReg_Trans", detalleArchivo.getNumeroRegistro());
        parametrosIn.put("@cfdoVou", detalleArchivo.getFechaDocumento());
        parametrosIn.put("@fecha_doc_rel", detalleArchivo.getFechaDocumentoRel());
        parametrosIn.put("@tipo_doc_rel", detalleArchivo.getTipoDocumentoRel());
        parametrosIn.put("@nro_doc_rel", detalleArchivo.getNumeroDocumentoRel());
        parametrosIn.put("@NombreArchivoPlano", archivo.getNombreArchivo());

        super.execute(parametrosIn);
    }
}