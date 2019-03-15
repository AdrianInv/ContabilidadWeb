package com.integra.contabilidad.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.integra.contabilidad.bean.Trabajador;
import com.integra.contabilidad.dao.TrabajadorDAO;
import com.integra.contabilidad.dao.sp.ObtenerDatosTrabajadorSP;

@Repository
public class TrabajadorDAOImpl implements TrabajadorDAO {

	@Qualifier("dsAdryan")
	@Autowired
	private DataSource dsContabilidadAdryan;

	@Override
	public Trabajador obtenerDatosTrabajador(String codigoTrajador) {
		ObtenerDatosTrabajadorSP sp = new ObtenerDatosTrabajadorSP(dsContabilidadAdryan);
		return sp.executeProcedure(codigoTrajador);
	}

}