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
import com.integra.contabilidad.reporte.bean.ValidacionArchivoPlano;

public class ValidacionArchivoPlanoSerializer implements JsonSerializer<ValidacionArchivoPlano> {

	@Override
	public JsonElement serialize(ValidacionArchivoPlano validacionArchivo, Type type, JsonSerializationContext context) {
		final JsonObject root = new JsonObject();
		root.addProperty("nombreArchivoPlano", validacionArchivo.getNombreArchivoPlano());
		root.addProperty("codigoValidacion", validacionArchivo.getCodigoValidacion());
		root.addProperty("numeroRegistro", validacionArchivo.getNumeroRegistro());
		root.addProperty("comentarioValidacion", validacionArchivo.getComentarioValidacion());
		root.addProperty("descripcionValidacion", validacionArchivo.getDescripcionValidacion());
		
		return root;
	}

}