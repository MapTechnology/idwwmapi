package idw.model.dao;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import idw.builders.BuilderDefaults;
import idw.builders.OmAlgocorBuilder;
import idw.builders.OmAlimBuilder;
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


public class OmPtDaoTest {

	private DAOGenericoTest daoGenericoTest;

	@Before
	public void setUp() throws Exception {
		daoGenericoTest = new DAOGenericoTest();
		daoGenericoTest.iniciaConexaoBanco();
	}
	

	
	@Test
	public void testeDao(){

		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
		
		OmUsr omUsr = new OmUsrBuilder().withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
		
		OmCc omCc = new OmCcBuilder().withOmUsrrevisao(omUsr).withOmUsrstativo(omUsr).buildAndPersist(daoGenericoTest);
	
		OmProgrp omProgrp = new OmProgrpBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmProduto omProduto = new OmProdutoBuilder().withOmCc(omCc).withOmProgrp(omProgrp).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmAlgocor omAlgocor = new OmAlgocorBuilder().buildAndPersist(daoGenericoTest);
		
		OmTppt omTppt = new OmTpptBuilder().withOmAlgocor(omAlgocor).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmPt omPt = new OmPtBuilder().withOmCc(omCc).withOmTppt(omTppt).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withStAtivo((byte)1).buildAndPersist(daoGenericoTest);
	
		OmPrg omPrg = new OmPrgBuilder().withOmProduto(omProduto).withOmPt(omPt).buildAndPersist(daoGenericoTest);
		
		OmMapa omMapa = new OmMapaBuilder().withOmPrg(omPrg).withOmProduto(omProduto).withOmPt(omPt).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmPa omPa = new OmPaBuilder().withOmPt(omPt).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmMapapa omMapapa = new OmMapapaBuilder().withOmMap(omMapa).withOmPa(omPa).withOmProduto(omProduto).buildAndPersist(daoGenericoTest);
		
		Set<OmPt> omPts = new HashSet<OmPt>();
		omPts.add(omPt);
		
		OmAlim omAlim = new OmAlimBuilder().withOmMapa(omMapa).withOmUsr(omUsr). withOmPts(omPts).buildAndPersist(daoGenericoTest);
		
		Assert.assertEquals(omPt.getIdPt().longValue(), 1l);
		
		OmPtDAO dao = new OmPtDAO(daoGenericoTest.getSession());
		
		OmPt obj = dao.getOmPtAtivoComUltimaRevisao(BuilderDefaults.CODIGO);
		
		Assert.assertNotNull(obj);
	
	}
	
	@After
	public void tearDown() throws Exception {
		daoGenericoTest.finalizaConexaoBanco();
		daoGenericoTest = null;
	}

} 