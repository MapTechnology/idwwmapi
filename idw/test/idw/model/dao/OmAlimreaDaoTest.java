package idw.model.dao;

import idw.builders.OmAlgocorBuilder;
import idw.builders.OmAlimBuilder;
import idw.builders.OmAlimreaBuilder;
import idw.builders.OmCcBuilder;
import idw.builders.OmMapaBuilder;
import idw.builders.OmMapapaBuilder;
import idw.builders.OmPaBuilder;
import idw.builders.OmPrgBuilder;
import idw.builders.OmProdutoBuilder;
import idw.builders.OmProgrpBuilder;
import idw.builders.OmPtBuilder;
import idw.builders.OmTpptBuilder;
import idw.builders.OmUsrBuilder;
import idw.builders.OmUsrgrpBuilder;
import idw.model.pojos.OmAlgocor;
import idw.model.pojos.OmAlim;
import idw.model.pojos.OmAlimrea;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmMapa;
import idw.model.pojos.OmMapapa;
import idw.model.pojos.OmPa;
import idw.model.pojos.OmPrg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.OmUsrgrp;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OmAlimreaDaoTest {

	private DAOGenericoTest daoGenericoTest;

	@Before
	public void setUp() throws Exception {
		daoGenericoTest = new DAOGenericoTest();
		daoGenericoTest.iniciaConexaoBanco();
	}
	
	@Test
	public void teste(){
		
		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
		
		OmUsr omUsr = new OmUsrBuilder().withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
		
		OmCc omCc = new OmCcBuilder().withOmUsrrevisao(omUsr).withOmUsrstativo(omUsr).buildAndPersist(daoGenericoTest);
	
		OmProgrp omProgrp = new OmProgrpBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmProduto omProduto = new OmProdutoBuilder().withOmCc(omCc).withOmProgrp(omProgrp).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmAlgocor omAlgocor = new OmAlgocorBuilder().buildAndPersist(daoGenericoTest);
		
		OmTppt omTppt = new OmTpptBuilder().withOmAlgocor(omAlgocor).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmPt omPt = new OmPtBuilder().withOmCc(omCc).withOmTppt(omTppt).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmPrg omPrg = new OmPrgBuilder().withOmProduto(omProduto).withOmPt(omPt).buildAndPersist(daoGenericoTest);
		
		OmMapa omMapa = new OmMapaBuilder().withOmPrg(omPrg).withOmProduto(omProduto).withOmPt(omPt).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmPa omPa = new OmPaBuilder().withOmPt(omPt).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmMapapa omMapapa = new OmMapapaBuilder().withOmMap(omMapa).withOmPa(omPa).withOmProduto(omProduto).buildAndPersist(daoGenericoTest);
		
		OmAlim omAlim = new OmAlimBuilder().withOmMapa(omMapa).withOmUsr(omUsr).buildAndPersist(daoGenericoTest);
		
		OmAlimrea alimrea = new OmAlimreaBuilder().withOmMapapa(omMapapa).withOmAlim(omAlim).withOmMapapa(omMapapa).withOmUsr(omUsr).buildAndPersist(daoGenericoTest);
		
		Assert.assertEquals(alimrea.getIdAlimrea(), new Long(1));
		
		OmAlimreaDAO dao = new OmAlimreaDAO(daoGenericoTest.getSession());
		
		List<OmAlimrea> lista = dao.getOmAlimreaPorIdAlim(omAlim.getIdAlim());
		
		Assert.assertEquals(lista.size(), 1);
	}
	
	@After
	public void tearDown() throws Exception {
		daoGenericoTest.finalizaConexaoBanco();
		daoGenericoTest = null;
	}
	
}
