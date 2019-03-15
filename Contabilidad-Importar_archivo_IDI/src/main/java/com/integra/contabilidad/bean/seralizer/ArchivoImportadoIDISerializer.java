/**
 * ************************************************************************************
 * Fecha de Creación        : 09/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.bean.seralizer;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.integra.contabilidad.bean.ArchivoImportadoIDI;

public class ArchivoImportadoIDISerializer implements JsonSerializer<ArchivoImportadoIDI> {

	@Override
	public JsonElement serialize(ArchivoImportadoIDI archivo, Type type, JsonSerializationContext context) {
		final JsonObject root = new JsonObject();
		root.addProperty("uuid", archivo.getUuid());
		root.addProperty("archivoPremium", archivo.getArchivoPremium());
		root.addProperty("archivoIDI", archivo.getArchivoIDI());
		root.addProperty("indicadorPago", archivo.getIndicadorPago());
		root.addProperty("descripcion", archivo.getDescripcion());
		root.addProperty("estadoFinalPremium", archivo.getEstadoFinalPremium());
		root.addProperty("estadoFinalIDI", archivo.getEstadoFinalIDI());
		root.addProperty("codigoUsuario", archivo.getCodigoUsuario());
		root.addProperty("apellidoPaterno", archivo.getApellidoPaterno());
		root.addProperty("primerNombre", archivo.getPrimerNombre());
		root.addProperty("nombreCompletoUsuario", archivo.getNombreCompletoUsuario());
		root.addProperty("motivo", archivo.getMotivo());
		root.addProperty("fecha", archivo.getFecha());
		root.addProperty("periodo", archivo.getPeriodo());
		root.addProperty("empresa", archivo.getEmpresa());
		root.addProperty("provisionPago", archivo.getProvisionPago());
		root.addProperty("importeTotalDebe", archivo.getImporteTotalDebe());
		root.addProperty("importeTotalHaber", archivo.getImporteTotalHaber());
		root.addProperty("importeCuotaDebe", archivo.getImporteCuotaDebe());
		root.addProperty("importeCuotaHaber", archivo.getImporteCuotaHaber());
		root.addProperty("cantidadRegistros", archivo.getCantidadRegistros());
		root.addProperty("flagProcesar", archivo.isFlagProcesar());
		root.addProperty("tipoModalidad", archivo.getTipoModalidad());
		root.addProperty("enabledFactura", archivo.isEnabledFactura());
		root.addProperty("enabledValidacion1", archivo.isEnabledValidacion1());
		root.addProperty("enabledValidacion2", archivo.isEnabledValidacion2());
		root.addProperty("checkedFactura", archivo.isCheckedFactura());
		root.addProperty("checkedValidacion1", archivo.isCheckedValidacion1());
		root.addProperty("checkedValidacion2", archivo.isCheckedValidacion2());
		root.addProperty("checkedValidacion3", archivo.isCheckedValidacion3());
		root.addProperty("comentario", archivo.getComentario());
		root.addProperty("resultadoPremium", archivo.getResultadoPremium());
		root.addProperty("resultadoIDI", archivo.getResultadoIDI());
		
		final JsonElement jsonDetalle = context.serialize(archivo.getDetalle());
		root.add("detalle", jsonDetalle);

		return root;
	}
}