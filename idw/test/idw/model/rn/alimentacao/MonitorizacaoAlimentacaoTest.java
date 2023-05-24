package idw.model.rn.alimentacao;

import idw.builders.OmAlgocorBuilder;
import idw.builders.OmMapaBuilder;
import idw.builders.OmPaBuilder;
import idw.builders.OmPrgBuilder;
import idw.builders.OmProdutoBuilder;
import idw.builders.OmProgrpBuilder;
import idw.builders.OmPtBuilder;
import idw.builders.OmTpptBuilder;
import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmMapa;
import idw.model.pojos.OmPa;
import idw.model.pojos.OmPrg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.util.Util;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MonitorizacaoAlimentacaoTest {
	
	private DAOGenericoTest daoGenericoTest;
	
	private OmPt omPt;
	
	@Before
	public void setUp() throws Exception {
		daoGenericoTest = new DAOGenericoTest();
		daoGenericoTest.iniciaConexaoBanco();
		
		daoGenericoTest.createOmCfg();
		
		OmCfg omCfg = Util.getConfigGeral(daoGenericoTest.getSession());
		Assert.assertNotNull(omCfg);

		OmUsr omUsr = omCfg.getOmUsrByIdUsrrevisao();
		OmCc omCc = omCfg.getOmCcdefault();
		
		OmTppt omTppt = new OmTpptBuilder()
		.withOmAlgocor(new OmAlgocorBuilder().buildAndPersist(daoGenericoTest))
		.withOmUsrRevisao(omUsr)
		.withOmUsrStAtivo(omUsr)
		.buildAndPersist(daoGenericoTest);
		
		omPt = new OmPtBuilder()
		.withOmTppt(omTppt)
		.withOmCc(omCc)
		.withOmUsrRevisao(omUsr)
		.withOmUsrStAtivo(omUsr)
		.buildAndPersist(daoGenericoTest);
	
		daoGenericoTest.flush();
		
		OmPa omPa = new OmPaBuilder()
		.withOmPt(omPt)
		.withOmUsrStAtivo(omUsr)
		.withOmUsrRevisao(omUsr)
		.buildAndPersist(daoGenericoTest);
		
		OmProgrp omProgrp = new OmProgrpBuilder()
		.withOmUsrRevisao(omUsr)
		.withOmUsrStAtivo(omUsr)
		.buildAndPersist(daoGenericoTest);
		
		OmProduto omProduto = new OmProdutoBuilder()
		.withOmCc(omCc)
		.withOmProgrp(omProgrp)
		.withOmUsrRevisao(omUsr)
		.withOmUsrStAtivo(omUsr)
		.buildAndPersist(daoGenericoTest);
		
		OmPrg omPrg = new OmPrgBuilder()
		.withOmProduto(omProduto)
		.withOmPt(omPt)
		.buildAndPersist(daoGenericoTest);
		
		OmMapa omMapapa = new OmMapaBuilder()
		.withOmPrg(omPrg)
		.withOmProduto(omProduto)
		.withOmPt(omPt)
		.withOmUsrStAtivo(omUsr)
		.withOmUsrRevisao(omUsr)
		.buildAndPersist(daoGenericoTest);
		
		Assert.assertEquals(omPt.getIdPt().longValue(), 1l);
		Assert.assertEquals(omPa.getIdPa(), 1l);
		Assert.assertEquals(omProduto.getIdProduto(), 1l);
		Assert.assertEquals(omMapapa.getIdMapa(), 1l);
	}


	@After
	public void tearDown() throws Exception {
		daoGenericoTest.finalizaConexaoBanco();
		daoGenericoTest = null;
	}
	
	
	@Test
	public void consumirPorCicloTest(){
		
	}

}
