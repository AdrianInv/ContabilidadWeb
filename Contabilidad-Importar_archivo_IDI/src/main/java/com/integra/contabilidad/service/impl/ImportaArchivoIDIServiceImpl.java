/**
 * ************************************************************************************
 * Fecha de Creación        : 12/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.integra.contabilidad.bean.ArchivoImportadoIDI;
import com.integra.contabilidad.bean.ArchivoPlanoEstado;
import com.integra.contabilidad.bean.AsientoContable;
import com.integra.contabilidad.bean.ControlEnvioAsiento;
import com.integra.contabilidad.bean.LogImportacion;
import com.integra.contabilidad.bean.Trabajador;
import com.integra.contabilidad.dao.ArchivoPlanoDAO;
import com.integra.contabilidad.dao.ArchivoPlanoDetalleDAO;
import com.integra.contabilidad.dao.AsientoContableDAO;

import com.integra.contabilidad.dao.ControlEnvioAsientoDAO;
import com.integra.contabilidad.dao.ImportaArchivoIDIDAO;
import com.integra.contabilidad.dao.ImportaArchivoIDIDetalleDAO;
import com.integra.contabilidad.dao.ImportarArchivosPlanoDAO;
import com.integra.contabilidad.dao.LogImportacionDAO;
import com.integra.contabilidad.dao.MovimientoDAO;
import com.integra.contabilidad.dao.TrabajadorDAO;
import com.integra.contabilidad.reporte.bean.ReporteArchivoPlanoImportado;
import com.integra.contabilidad.reporte.bean.ValidacionArchivoPlano;
import com.integra.contabilidad.service.ImportaArchivoIDIService;
import com.integra.contabilidad.util.Constantes;
import com.integra.contabilidad.util.Utilitarios;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class ImportaArchivoIDIServiceImpl implements ImportaArchivoIDIService {

	@Autowired
	private ImportaArchivoIDIDAO importaArchivoIDIDAO;
	
	@Autowired
	private ImportaArchivoIDIDetalleDAO importaArchivoIDIDetalleDAO;
	
	@Autowired
	private TrabajadorDAO trabajadorDAO;
	
	//@Autowired
	//private ControlAsientoDAO controlAsientoDAO;
	
	@Autowired
	private MovimientoDAO movimientoDAO;
	
	@Autowired
	private LogImportacionDAO logImportacionDAO;
	
	@Autowired
	private AsientoContableDAO asientoContableDAO;
	
	/*-- PSC004 --*/
	@Autowired
	private ControlEnvioAsientoDAO controlEnvioAsientoDAO;
	
	@Autowired
	private ImportarArchivosPlanoDAO importarArchivosPlanoDAO;
		
	@Autowired
	private ArchivoPlanoDAO archivoPlanoDAO;
	
	@Autowired
	private ArchivoPlanoDetalleDAO archivoPlanoDetalleDAO;	

	@Override
	@Transactional
	public Map<String, Object> procesar(String parametros) throws IOException {
		Map<String, Object> result = new HashMap<>();
		
		JsonObject jsonObject = new JsonParser().parse(parametros).getAsJsonObject();
		JsonObject parametrosIn = jsonObject.getAsJsonObject(Constantes.KEY_PARAMETROS);
		
		Gson gson = new Gson();
		Type tipoListaArchivo = new TypeToken<List<ArchivoImportadoIDI>>() {}.getType();
		List<ArchivoImportadoIDI> listaArchivosFiltrados = gson.fromJson(jsonObject.getAsJsonArray("listaArchivosFiltrados"), tipoListaArchivo);
		
		for (ArchivoImportadoIDI archivoCurrent : listaArchivosFiltrados) {
			if (archivoCurrent.isFlagProcesar()) {
				/*importaArchivoIDIDetalleDAO.eliminarDetalleArchivoAImportar(
						parametrosIn.get(Constantes.KEY_USUARIO_WINDOWS).getAsString(),
						parametrosIn.get(Constantes.KEY_CODIGO_EMPRESA).getAsString());*/
				
				archivoCurrent.setUsuarioWindows(parametrosIn.get(Constantes.KEY_USUARIO_WINDOWS).getAsString());
				if (archivoCurrent.getArchivoPremium() != null && Constantes.ESTADO_ARCHIVO_PENDIENTE.equals(archivoCurrent.getEstadoFinalPremium())) {
					procesarArchivoPremium(archivoCurrent, 
							parametrosIn.get(Constantes.KEY_CODIGO_EMPRESA).getAsString(),
							parametrosIn.get(Constantes.KEY_RUTA_PREMIUM).getAsString(),
							parametrosIn.get(Constantes.KEY_RUTA_PREMIUM_HISTORICA).getAsString(),
							parametrosIn.get(Constantes.KEY_DOMINIO_SMB).getAsString(),
							parametrosIn.get(Constantes.KEY_USUARIO_SMB).getAsString(),
							parametrosIn.get(Constantes.KEY_CLAVE_SMB).getAsString());
				}

				if (archivoCurrent.getArchivoIDI() != null && Constantes.ESTADO_ARCHIVO_PENDIENTE.equals(archivoCurrent.getEstadoFinalIDI())) {
					procesarArchivoIDI(archivoCurrent, 
							parametrosIn.get(Constantes.KEY_CODIGO_EMPRESA).getAsString(),
							parametrosIn.get(Constantes.KEY_RUTA_IDI).getAsString(),
							parametrosIn.get(Constantes.KEY_RUTA_IDI_HISTORICA).getAsString(),
							parametrosIn.get(Constantes.KEY_DOMINIO_SMB).getAsString(),
							parametrosIn.get(Constantes.KEY_USUARIO_SMB).getAsString(),
							parametrosIn.get(Constantes.KEY_CLAVE_SMB).getAsString());
				}
			}
		}
		
		List<ReporteArchivoPlanoImportado> reporteImportacion = importaArchivoIDIDAO.emitirReporteImportacion(
				parametrosIn.get(Constantes.KEY_USUARIO_WINDOWS).getAsString(),
				parametrosIn.get(Constantes.KEY_CODIGO_EMPRESA).getAsString());
		
		result.put("listaArchivosProcesados", listaArchivosFiltrados);
		result.put("reporteImportacion", reporteImportacion);
		
		return result;
	}
	
	private void procesarArchivoPremium(ArchivoImportadoIDI archivoPremium, String codigoEmpresa,
			String rutaPremium, String rutaPremiumHistorica, String dominioSmb, String usuarioSmb, String claveSmb)
			throws IOException {
		
		//ingresarDetalleArchivoAImportar(archivoPremium, codigoEmpresa);

		if (archivoPremium.isEnabledFactura() && archivoPremium.isCheckedFactura()) {
			importaArchivoIDIDetalleDAO.actualizarFormatoCorrectoDocumento(archivoPremium.getUsuarioWindows(), codigoEmpresa);
		} else if (archivoPremium.isEnabledFactura() && !archivoPremium.isCheckedFactura()) {
			return;
		}

		//importaArchivoIDIDetalleDAO.validarDetalleArchivoPlanoAImportar(archivoPremium, codigoEmpresa);
		
		/*String observacion = obtenerResultadoImportarArchivoPremiun(archivoPremium, codigoEmpresa,
				rutaPremium, rutaPremiumHistorica, dominioSmb, usuarioSmb, claveSmb);
		
		if (archivoPremium.getUuid().length() == 36) {
			Asiento asiento = new Asiento();
			asiento.setUsuarioCreacion(archivoPremium.getUsuarioWindows());
			asiento.setUuid(archivoPremium.getUuid());
			asiento.setObservacion(observacion);
			asiento.setEstado(archivoPremium.isCheckedValidacion3() ? Constantes.ESTADO_ASIENTO_ERROR : Constantes.ESTADO_ASIENTO_GENERADO);
			
			controlAsientoDAO.actualizarEstadoEnvio(asiento);
		}*/
	}
	
	private String obtenerResultadoImportarArchivoPremiun(ArchivoImportadoIDI archivoPremium, String codigoEmpresa, String rutaPremium, 
			String rutaPremiumHistorica, String dominioSmb, String usuarioSmb, String claveSmb) throws IOException {
		String observacion = "";
		if ((archivoPremium.isEnabledValidacion1() && archivoPremium.isCheckedValidacion1()) || 
				(archivoPremium.isEnabledValidacion2() && archivoPremium.isCheckedValidacion2() && "".equals(archivoPremium.getUuid()))) {
			observacion = importarArchivoPremiun(archivoPremium, codigoEmpresa, rutaPremium, rutaPremiumHistorica, dominioSmb, usuarioSmb, claveSmb);
		} else if ((archivoPremium.isEnabledValidacion1() && !archivoPremium.isCheckedValidacion1())
				|| (archivoPremium.isEnabledValidacion2() && !archivoPremium.isCheckedValidacion2())) {
			observacion = "EL USUARIO DECIDIO NO IMPORTAR EL ARCHIVO";
			archivoPremium.setResultadoPremium("El usuario decidio no importar el archivo");
		} else if (archivoPremium.isCheckedValidacion3()) {
			observacion = noImportarArchivoPremium(archivoPremium, codigoEmpresa);
			archivoPremium.setResultadoPremium("Archivo tiene Errores y no se podrá Importar");
		}
		return observacion;
	}

	private String importarArchivoPremiun(ArchivoImportadoIDI archivoPremium, String codigoEmpresa, String rutaPremium,
			String rutaPremiumHistorica, String dominioSmb, String usuarioSmb, String claveSmb) throws IOException {
		String observacion = "";

		Map<String, Object> out = importaArchivoIDIDAO.importarInformacion(archivoPremium.getUsuarioWindows(),
				archivoPremium.getCodigoFondo(), codigoEmpresa);
		
		archivoPremium.setResultadoPremium(out.get("mensajeRetorno").toString());
		
		if (Integer.parseInt(out.get("valorRetorno").toString()) == 0) {
			moverArchivoAProcesados(rutaPremium, rutaPremiumHistorica, archivoPremium.getNombreArchivo(), dominioSmb, usuarioSmb, claveSmb);

			ArchivoPlanoEstado archivoPlanoEstado = new ArchivoPlanoEstado();
			archivoPlanoEstado.setNombreArchivo(archivoPremium.getNombreArchivo());
			archivoPlanoEstado.setEstadoPremium(Constantes.ESTADO_ARCHIVO_CONFORME);
			archivoPlanoEstado.setEstadoIDI("");

			importaArchivoIDIDAO.actualizarEstadoArchivo(archivoPlanoEstado, codigoEmpresa);
			observacion = "LA IMPORTACION SE REALIZO CON EXITO";
		}

		if ("S".equals(archivoPremium.getIndicadorPago())) {
			importaArchivoIDIDAO.asociarVoucherLote(archivoPremium, codigoEmpresa);
		}
		
		importaArchivoIDIDAO.eliminarRangoImpresion(archivoPremium.getUsuarioWindows(), codigoEmpresa);
		
		return observacion;
	}

	private String noImportarArchivoPremium(ArchivoImportadoIDI archivoPremium, String codigoEmpresa) {
		String observacion = "LA IMPORTACION TERMINO CON ERRORES, REVISAR EL LOG";
		if (archivoPremium.getUuid().length() == 36) {
			List<LogImportacion> listaLog = logImportacionDAO.listarLogPorUUID(archivoPremium.getUuid(), codigoEmpresa);
			if (!listaLog.isEmpty()) {
				for (LogImportacion log : listaLog) {
					logImportacionDAO.ingresarLogTablaValidacion(log);
				}
			}
		}
		return observacion;
	}

	private void procesarArchivoIDI(ArchivoImportadoIDI archivoIDI, String codigoEmpresa, String rutaIDI,
			String rutaIDIHistorica, String dominioSmb, String usuarioSmb, String claveSmb)
			throws IOException {
		importaArchivoIDIDAO.ejecutarDTSCargaMovimientosContablesPREMIUM(archivoIDI, rutaIDI);
		importaArchivoIDIDAO.obtenerSumaImportesCargadosPatrimonio(archivoIDI);
		
		importaArchivoIDIDAO.actualizarImportacion(archivoIDI, codigoEmpresa);
		if (archivoIDI.getSumasIDI() != BigDecimal.ZERO && archivoIDI.getCantidadRegistrosIDI() != 0) {
			moverArchivoAProcesados(rutaIDI, rutaIDIHistorica, archivoIDI.getNombreArchivo(), dominioSmb, usuarioSmb, claveSmb);
			
			ArchivoPlanoEstado archivoPlanoEstado = new ArchivoPlanoEstado();
			archivoPlanoEstado.setNombreArchivo(archivoIDI.getNombreArchivo());
			archivoPlanoEstado.setEstadoPremium("");
			archivoPlanoEstado.setEstadoIDI(Constantes.ESTADO_ARCHIVO_CONFORME);
			
			importaArchivoIDIDAO.actualizarEstadoArchivo(archivoPlanoEstado, codigoEmpresa);
			archivoIDI.setResultadoIDI("La importación del archivo se realizó con éxito");
		} else {
			archivoIDI.setResultadoIDI("La importación del archivo no generó registros");
		}
	}

	private void moverArchivoAProcesados(String rutaOrigen, String rutaDestino, String nombreArchivo, String dominioSmb, String usuarioSmb, String claveSmb) throws IOException {
		/*String pathOrigen = rutaOrigen.replace("\\", "/") + nombreArchivo;
		String pathDestino = rutaDestino.replace("\\", "/") + nombreArchivo;
		Utilitarios.copySmbFile(pathOrigen, pathDestino, dominioSmb, usuarioSmb, claveSmb);
		Utilitarios.delete(pathOrigen, dominioSmb, usuarioSmb, claveSmb);*/
	}
	
	@Override
	public byte[] emitirReporteImportacion(String parametros) throws IOException, JRException {
		JsonObject jsonObject = new JsonParser().parse(parametros).getAsJsonObject();
		JsonObject jsonParametros = jsonObject.getAsJsonObject(Constantes.KEY_PARAMETROS);
		
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put(Constantes.KEY_NOMBRE_EMPRESA, jsonParametros.get(Constantes.KEY_NOMBRE_EMPRESA).getAsString());
		parametrosIn.put(Constantes.KEY_REPORTE_IMPORTACION_RUC_EMPRESA, jsonParametros.get(Constantes.KEY_REPORTE_IMPORTACION_RUC_EMPRESA).getAsString());
		parametrosIn.put(Constantes.KEY_REPORTE_IMPORTACION_PERIODO, jsonParametros.get(Constantes.KEY_REPORTE_IMPORTACION_PERIODO).getAsString());
		
		Gson gson = new Gson();
		Type tipoReporteImportacion = new TypeToken<List<ReporteArchivoPlanoImportado>>() {}.getType();
		List<ReporteArchivoPlanoImportado> reporteImportacion = gson.fromJson(jsonObject.getAsJsonArray("reporteImportacion"), tipoReporteImportacion);
		
		String fullPathJasper = Constantes.RUTA_REPORTE + Constantes.NOMBRE_REPORTE_RESULTADO_IMPORTACION + Constantes.EXTENSION_FILE_JASPER;
		File jasperFile = new File(fullPathJasper);
		if (!jasperFile.exists()) {
			String fullPathJrxml = fullPathJasper.replace(Constantes.EXTENSION_FILE_JASPER, Constantes.EXTENSION_FILE_JRXML);
			JasperCompileManager.compileReportToFile(fullPathJrxml, fullPathJasper);
		}
		
		JasperReport reporte = (JasperReport) JRLoader.loadObject(jasperFile);
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametrosIn, new JRBeanCollectionDataSource(reporteImportacion));
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
		
		return stream.toByteArray();
	}

	/*------------------------------------------------------------------------------------------------------PSC004*/
	@Override
	@Transactional(readOnly = true)
	public List<ControlEnvioAsiento> listarArchivosTransferenciaPREMIUM(String fondo, String empresa, String usuarioWindows) {
		List<ControlEnvioAsiento> listaControlAsientos = controlEnvioAsientoDAO.listarAsientosATransferirPREMIUM(fondo);
		
		if (!listaControlAsientos.isEmpty()) {
			for (ControlEnvioAsiento controlAsiento : listaControlAsientos) {
				controlAsiento.setFondo(fondo);
				controlAsiento.setEmpresa(empresa);
				controlAsiento.setUsuarioWindows(usuarioWindows);
				
				this.obtenerDatosAdicionales(controlAsiento);
			}
		}
		
		return listaControlAsientos;
	}
	
	private void obtenerDatosAdicionales(ControlEnvioAsiento controlAsiento) {
		if (!Utilitarios.isNullOrEmpty(controlAsiento.getCodigoUsuarioCreacion())) {
			Trabajador trabajador = trabajadorDAO.obtenerDatosTrabajador(controlAsiento.getCodigoUsuarioCreacion());
			if (trabajador != null) {
				if (!Utilitarios.isNullOrEmpty(trabajador.getPrimerNombre())
						&& !Utilitarios.isNullOrEmpty(trabajador.getApellidoPaterno())) {
					controlAsiento.setNombreCompletoUsuarioCreacion(trabajador.getApellidoPaterno() + "," + trabajador.getPrimerNombre());
				}
			}
		}
		
		controlAsiento.setEstadoPremium(Constantes.ESTADO_ARCHIVO_PENDIENTE);
		controlAsiento.setEstadoIDI(Constantes.ESTADO_ARCHIVO_PENDIENTE);
		importarArchivosPlanoDAO.obtenerEstadoRealesArchivo(controlAsiento);
	}
	
	@Override
	@Transactional
	public Map<String, Object> validarAsientos(List<ControlEnvioAsiento> asientosSelecionados) {
		Map<String, Object> result = new HashMap<>();
		
		List<ControlEnvioAsiento> listaResumenPorAsiento = new ArrayList<>();
		List<ControlEnvioAsiento> listaResumenAsientosPorUsuario = new ArrayList<>();
		List<String> listaAsientosSinUsuarioSinMotivo = new ArrayList<>();
		
		int validacionMovimientos = this.obtenerValidacionMovimientos();
		
		if (validacionMovimientos == 0) {
			int correlativo = 1;
			for(ControlEnvioAsiento asiento : asientosSelecionados) {
				if (!Utilitarios.isNullOrEmpty(asiento.getNombreCompletoUsuarioCreacion())
						&& !Utilitarios.isNullOrEmpty(asiento.getNombreProceso())) {
					correlativo = this.sumarSaldos(asiento, correlativo);
					listaResumenPorAsiento.add(asiento);
				} else {
					listaAsientosSinUsuarioSinMotivo.add(asiento.getNombreArchivo());
				}
			}
			if (!listaResumenPorAsiento.isEmpty()) {
				listaResumenAsientosPorUsuario = this.agruparAsientosPorUsuario(listaResumenPorAsiento);
				saveImportacionArchivoPlano(listaResumenPorAsiento);
			}
		}
		
		result.put("validacionMovimientos", validacionMovimientos);
		result.put("listaResumenPorAsiento", listaResumenPorAsiento);
		result.put("listaResumenAsientosPorUsuario", listaResumenAsientosPorUsuario);
		result.put("listaAsientosSinUsuarioSinMotivo", listaAsientosSinUsuarioSinMotivo);
		
		return result;
	}
	
	private int obtenerValidacionMovimientos() {
		Map<String, Object> out = movimientoDAO.obtenerDiarxYCantRegResmov();
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("@FECHA", out.get("fechaHabil"));
		parametrosIn.put("@CANTREGRESMOV", out.get("cantRegistros"));
		return movimientoDAO.obtenerValidacionMovimiento(parametrosIn);
	}
	
	private int sumarSaldos(ControlEnvioAsiento controlAsiento, int correlativo) {
		List<AsientoContable> asientosContables = asientoContableDAO.listarAsientoContablePorUUID(controlAsiento.getUuid());
		if (asientosContables.isEmpty()) {
			for (AsientoContable asientoContable : asientosContables) {
				asientoContable.setCorrelativo(correlativo);
				
				controlAsiento.setImporteTotalDebe(controlAsiento.getImporteTotalDebe().add(asientoContable.getMontoDebito()));
				controlAsiento.setImporteTotalHaber(controlAsiento.getImporteTotalHaber().add(asientoContable.getMontoCredito()));
				
				if ("C".equals(asientoContable.getMoneda())) {
					controlAsiento.setImporteCuotaDebe(controlAsiento.getImporteCuotaDebe().add(asientoContable.getImporteDolares()));// Llamar a utilitarios cortar a 13
					controlAsiento.setImporteCuotaHaber(controlAsiento.getImporteCuotaHaber().add(asientoContable.getImporteDolares()));
				}
				correlativo++;
			}
			controlAsiento.setAsientosContablesPremium(asientosContables);
			controlAsiento.setCantidadRegistros(asientosContables.size());
		}
		return correlativo;
	}

	private List<ControlEnvioAsiento> agruparAsientosPorUsuario(List<ControlEnvioAsiento> listaResumenPorAsiento) {
		List<ControlEnvioAsiento> listaResumenPorUsuario = new ArrayList<>();
		Map<String, ControlEnvioAsiento> map = new HashMap<>();
		ControlEnvioAsiento asiento = null;
		
		for (ControlEnvioAsiento controlAsiento : listaResumenPorAsiento) {
			if (map.containsKey(controlAsiento.getCodigoUsuarioCreacion())) {
				asiento = map.get(controlAsiento.getCodigoUsuarioCreacion());
				asiento.setImporteTotalDebe(asiento.getImporteTotalDebe().add(controlAsiento.getImporteTotalDebe()));
				asiento.setImporteTotalHaber(asiento.getImporteTotalHaber().add(controlAsiento.getImporteTotalHaber()));
				asiento.setImporteCuotaDebe(asiento.getImporteCuotaDebe().add(controlAsiento.getImporteCuotaDebe()));
				asiento.setImporteCuotaHaber(asiento.getImporteCuotaHaber().add(controlAsiento.getImporteCuotaHaber()));
			} else {
				asiento = new ControlEnvioAsiento();
				
				asiento.setNombreCompletoUsuarioCreacion(controlAsiento.getNombreCompletoUsuarioCreacion());
				asiento.setImporteTotalDebe(controlAsiento.getImporteTotalDebe());
				asiento.setImporteTotalHaber(controlAsiento.getImporteTotalHaber());
				asiento.setImporteCuotaDebe(controlAsiento.getImporteCuotaDebe());
				asiento.setImporteCuotaHaber(controlAsiento.getImporteCuotaHaber());
				
				listaResumenPorUsuario.add(asiento);
				map.put(controlAsiento.getCodigoUsuarioCreacion(), asiento);
			}
		}
		return listaResumenPorUsuario;
	}
	
	private void saveImportacionArchivoPlano(List<ControlEnvioAsiento> listaResumenPorAsiento) {
		String usuarioWindows = listaResumenPorAsiento.get(0).getUsuarioWindows();
		String codigoEmpresa = listaResumenPorAsiento.get(0).getEmpresa();
		
		archivoPlanoDAO.eliminarImportacionArchivoPlano(usuarioWindows, codigoEmpresa);
		
		for (ControlEnvioAsiento controlAsiento : listaResumenPorAsiento) {
			archivoPlanoDAO.ingresarImportacionArchivoPlano(controlAsiento);
		}
	}
	
	@Override
	public List<ControlEnvioAsiento> filtrarAsientos(List<ControlEnvioAsiento> listaArchivosSelecionados, String year, String mes) throws ParseException {
		List<List<ValidacionArchivoPlano>> listaValidaciones = new ArrayList<>();
		for (ControlEnvioAsiento controlAsiento : listaArchivosSelecionados) {
			archivoPlanoDetalleDAO.eliminarDetalleArchivoAImportar(controlAsiento.getUsuarioWindows(), controlAsiento.getEmpresa());
			
			if (isPeriodoYEstadoCorrecto(controlAsiento, year, mes)) {
				if (Constantes.ESTADO_ARCHIVO_PENDIENTE.equals(controlAsiento.getEstadoPremium())) {
					// obtener datos adiccionales de por uuid
					
					this.ingresarDetalleArchivoPlano(controlAsiento);
					
					List<ValidacionArchivoPlano> validacionArchivoPlano = this.validarAsientoPremium(controlAsiento);
					if (!validacionArchivoPlano.isEmpty()) {
						listaValidaciones.add(validacionArchivoPlano);
					}
					controlAsiento.setFlagProcesar(true);
				}
			}
		}
		return null;
	}
	
	private boolean isPeriodoYEstadoCorrecto(ControlEnvioAsiento controlAsiento, String year, String mes) {
		if (year.equals(controlAsiento.getYear()) && mes.equals(controlAsiento.getMes())) {
			if (Constantes.ESTADO_ARCHIVO_PENDIENTE.equals(controlAsiento.getEstadoPremium())
					&& Constantes.ESTADO_ARCHIVO_PENDIENTE.equals(controlAsiento.getEstadoIDI())) {
				return true;
			} else {
				controlAsiento.setComentario(Constantes.MENSAJE_ARCHIVO_NO_PENDIENTE_PARA_PROCESAR);
			}
		} else {
			controlAsiento.setComentario(Constantes.MENSAJE_ARCHIVO_NO_PERTENCE_PERIODO_ACTUAL);
		}
		return false;
	}
	
	private void ingresarDetalleArchivoPlano(ControlEnvioAsiento controlAsiento) throws ParseException {
		List<AsientoContable> asientosContables =  controlAsiento.getAsientosContablesPremium();
		if (!asientosContables.isEmpty()) {
			for (AsientoContable asientoContable : asientosContables) {
				Map<String, Object> parametrosIn = new HashMap<>();
				parametrosIn.put("@cUsuVou", controlAsiento.getUsuarioWindows());
				parametrosIn.put("@cPerVou", controlAsiento.getYear() + controlAsiento.getMes());
		        parametrosIn.put("@cConVou", asientoContable.getCodigoEmpresa());
		        parametrosIn.put("@cDfuVou", asientoContable.getCodigoLibroAuxiliar());
		        parametrosIn.put("@cNduVou", asientoContable.getNumeroVoucher());
		        parametrosIn.put("@nSecVou", asientoContable.getCorrelativoVoucher());
		        parametrosIn.put("@dFecVou", controlAsiento.getFecha());
		        parametrosIn.put("@cAsiVou", asientoContable.getTipoAsiento());
		        parametrosIn.put("@cCtaVou", asientoContable.getCodigoCuentaContable());
		        parametrosIn.put("@cCecVou", asientoContable.getCodigoCentroCosto());
		        parametrosIn.put("@cCteVou", asientoContable.getCodigoCuentaCorrienteTercero());
		        parametrosIn.put("@cTteVou", asientoContable.getTipoCuentaCorrienteTercero());
		        parametrosIn.put("@cDbaVou", asientoContable.getCodigoTipoDocumentoBase());
		        parametrosIn.put("@cNbaVou", asientoContable.getNumeroDocumento());
				parametrosIn.put("@dFveVou", asientoContable.getFechaVencimiento().length() == 8
												? Utilitarios.convertFormatoFecha(asientoContable.getFechaVencimiento(),
																Constantes.FECHA_FORMATO_AS400, Constantes.FECHA_FORMATO_YYYY_MM_DD)
												: "");
		        parametrosIn.put("@nDebVou", asientoContable.getMontoDebito());
		        parametrosIn.put("@nHabVou", asientoContable.getMontoCredito());
		        parametrosIn.put("@cMonVou", asientoContable.getMoneda());
		        parametrosIn.put("@nTcaVou", Utilitarios.cortarDecimales(asientoContable.getTipoCambio(), 7, 13)); // Longitud 13 premium
		        parametrosIn.put("@nVomVou", Utilitarios.cortarDecimales(asientoContable.getImporteDolares(), 7, 13)); // Longitud 13 premium
		        parametrosIn.put("@cCgeVou", asientoContable.getCentroGestion());
		        parametrosIn.put("@cNteVou", asientoContable.getNombreTercero());
		        parametrosIn.put("@cGloVou", asientoContable.getGlosaVoucher());
		        parametrosIn.put("@cDes_Trans", asientoContable.getDescripcionInterfaz());
		        parametrosIn.put("@cPer_Trans", controlAsiento.getYear() + controlAsiento.getMes());
		        parametrosIn.put("@nReg_Trans", asientoContable.getCorrelativo());
		        parametrosIn.put("@cfdoVou", asientoContable.getFechaDocumento().length() == 8 
		        								? Utilitarios.convertFormatoFecha(asientoContable.getFechaDocumento(), 
	        													Constantes.FECHA_FORMATO_AS400_2, Constantes.FECHA_FORMATO_DD_MM_YYYY)
        										: ""); // validar que la longitud sea de 8
		        parametrosIn.put("@fecha_doc_rel", ""); // detalleArchivo.getFechaDocumentoRel()
		        parametrosIn.put("@tipo_doc_rel", ""); // detalleArchivo.getTipoDocumentoRel()
		        parametrosIn.put("@nro_doc_rel", ""); // detalleArchivo.getNumeroDocumentoRel()
		        parametrosIn.put("@NombreArchivoPlano", controlAsiento.getNombreArchivo());
		        
		        archivoPlanoDetalleDAO.ingresarDetalleArchivoAImportar(parametrosIn, controlAsiento.getEmpresa());
			}
		}
	}
	
	private List<ValidacionArchivoPlano> validarAsientoPremium(ControlEnvioAsiento controlAsiento) {
		List<ValidacionArchivoPlano> validacionArchivoPlano = this.validarDetalleArchivoPlano(controlAsiento);

		if (archivoPlanoDetalleDAO.isFormatoFacturaCorrecto(controlAsiento.getUsuarioWindows(), controlAsiento.getEmpresa()) > 0) {
			controlAsiento.setEnabledFactura(true);
		}

		int tipoValidacion = archivoPlanoDetalleDAO.obtenerTipoValidacion(controlAsiento.getUsuarioWindows(), controlAsiento.getEmpresa());
		if (tipoValidacion == 1) {
			controlAsiento.setEnabledValidacion1(true);
		} else if (tipoValidacion == 2) {
			controlAsiento.setEnabledValidacion2(true);
		} else if (tipoValidacion == 3) {
			controlAsiento.setCheckedValidacion3(true);
		}
		
		return validacionArchivoPlano;
	}
	
	private List<ValidacionArchivoPlano> validarDetalleArchivoPlano(ControlEnvioAsiento controlAsiento) {
		List<ValidacionArchivoPlano> validacionArchivoPlano = archivoPlanoDetalleDAO.validarDetalleArchivoPlano(controlAsiento, controlAsiento.getEmpresa());
		if (!validacionArchivoPlano.isEmpty()) {
			validacionArchivoPlano.get(0).setNombreArchivoPlano(controlAsiento.getNombreArchivo());
		}
		return validacionArchivoPlano;
	}
	
	@Override
	public byte[] emitirReporteValidacion(List<List<ValidacionArchivoPlano>> listaValidacionesArchivoPlano, String nombreEmpresa) throws IOException, JRException {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put(Constantes.KEY_NOMBRE_EMPRESA, nombreEmpresa);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try (ZipOutputStream zos = new ZipOutputStream(baos)) {
			String fullPathJasper = Constantes.RUTA_REPORTE + Constantes.NOMBRE_REPORTE_VALIDACION + Constantes.EXTENSION_FILE_JASPER;
			File jasperFile = new File(fullPathJasper);
			if (!jasperFile.exists()) {
				String fullPathJrxml = fullPathJasper.replace(Constantes.EXTENSION_FILE_JASPER, Constantes.EXTENSION_FILE_JRXML);
				JasperCompileManager.compileReportToFile(fullPathJrxml, fullPathJasper);
			}
			
			JasperReport reporte = (JasperReport) JRLoader.loadObject(jasperFile);
			
			byte[] bytes;
			for (List<ValidacionArchivoPlano> validacionArchivo : listaValidacionesArchivoPlano) {
				JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametrosIn, new JRBeanCollectionDataSource(validacionArchivo));
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
				
				bytes = stream.toByteArray();
				
				ZipEntry ze = new ZipEntry("Reporte - " + validacionArchivo.get(0).getNombreArchivoPlano() + Constantes.EXTENSION_FILE_PDF);
				zos.putNextEntry(ze);
				zos.write(bytes, 0, bytes.length);
				zos.closeEntry();
			}
			zos.flush();
		}
		return baos.toByteArray();
	}
	
}