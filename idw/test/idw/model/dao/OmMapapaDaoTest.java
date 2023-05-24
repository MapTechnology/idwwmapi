package idw.model.dao;

import idw.builders.OmAlgocorBuilder;
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
import idw.webservices.dto.LeituraCODTO;
import idw.webservices.dto.PosicaoCODTO;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OmMapapaDaoTest {

	private DAOGenericoTest daoGenericoTest;

	@Before
	public void setUp() throws Exception {
		daoGenericoTest = new DAOGenericoTest();
		daoGenericoTest.iniciaConexaoBanco();
	}
	
//	@Test
//	public void testeSetRealimentacao(){
//		
//		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
//		
//		OmUsr omUsr = new OmUsrBuilder().withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
//		
//		OmCc omCc = new OmCcBuilder().withOmUsrrevisao(omUsr).withOmUsrstativo(omUsr).buildAndPersist(daoGenericoTest);
//	
//		OmProgrp omProgrp = new OmProgrpBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
//		
//		OmProduto omProduto = new OmProdutoBuilder().withOmCc(omCc).withOmProgrp(omProgrp).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
//		
//		OmAlgocor omAlgocor = new OmAlgocorBuilder().buildAndPersist(daoGenericoTest);
//		
//		OmTppt omTppt = new OmTpptBuilder().withOmAlgocor(omAlgocor).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
//		
//		OmPt omPt = new OmPtBuilder().withOmCc(omCc).withOmTppt(omTppt).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
//		
//		OmPrg omPrg = new OmPrgBuilder().withOmProduto(omProduto).withOmPt(omPt).buildAndPersist(daoGenericoTest);
//		
//		OmMapa omMapa = new OmMapaBuilder().withOmPrg(omPrg).withOmProduto(omProduto).withOmPt(omPt).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
//		
//		OmPa omPa = new OmPaBuilder().withOmPt(omPt).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
//		
//		OmMapapa omMapapa = new OmMapapaBuilder().withOmMap(omMapa).withOmPa(omPa).withOmProduto(omProduto).buildAndPersist(daoGenericoTest);
//		
//		Assert.assertEquals(omMapapa.getIdMapapa(), 1l);
//		
//		LeituraCODTO filtro = new LeituraCODTO();
//		PosicaoCODTO posicao = new PosicaoCODTO();
//		posicao.setIdMapapa(omMapa.getIdMapa());
//		filtro.setPosicaoASerLida(posicao);
//		
//		OmMapapaDAO dao = new OmMapapaDAO(daoGenericoTest.getSession());
//		List<OmMapapa> lista = dao.setRealimentacao(filtro);
//		
//		Assert.assertEquals(lista.size(), 1);
//	}
	
	@Test
	public void testeSetCorrente(){
		
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
		
		Assert.assertEquals(omMapapa.getIdMapapa(), 1l);
		
		LeituraCODTO filtro = new LeituraCODTO();
		PosicaoCODTO posicao = new PosicaoCODTO();
		posicao.setCdFeeder(omPa.getCdPa());
		filtro.setPosicaoASerLida(posicao);
		
		OmMapapaDAO dao = new OmMapapaDAO(daoGenericoTest.getSession());
		List<OmMapapa> lista = dao.getOmMapaPA(filtro, omMapa);
		
		Assert.assertEquals(lista.size(), 1);
	}
	
	@After
	public void tearDown() throws Exception {
		daoGenericoTest.finalizaConexaoBanco();
		daoGenericoTest = null;
	}
	
}