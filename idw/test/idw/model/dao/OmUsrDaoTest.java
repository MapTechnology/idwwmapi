package idw.model.dao;

import junit.framework.Assert;
import idw.builders.OmUsrBuilder;
import idw.builders.OmUsrgrpBuilder;
import idw.model.pojos.OmUsr;
import idw.model.pojos.OmUsrgrp;
import idw.webservices.dto.LeituraCODTO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OmUsrDaoTest {

	private DAOGenericoTest daoGenericoTest;

	@Before
	public void setUp() throws Exception {
		daoGenericoTest = new DAOGenericoTest();
		daoGenericoTest.iniciaConexaoBanco();
	}
	
	@Test
	public void testeDao(){
		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
		
		OmUsr omUsr = new OmUsrBuilder().withOmUsrgrp(omUsrgrp).withCdUsuario("eduardo").buildAndPersist(daoGenericoTest);
		
		Assert.assertEquals(omUsr.getIdUsr(), 1l);
		
		OmUsrDAO dao = new OmUsrDAO(daoGenericoTest.getSession());
		
		LeituraCODTO leitura = new LeituraCODTO();
		leitura.setIdUsuario(omUsr.getIdUsr());
		
		OmUsr ret = dao.getOmUsrPorId(leitura);
		
		Assert.assertEquals(ret.getCdUsr(), "eduardo");
		
	}
	
	@After
	public void tearDown() throws Exception {
		daoGenericoTest.finalizaConexaoBanco();
		daoGenericoTest = null;
	}
	
}