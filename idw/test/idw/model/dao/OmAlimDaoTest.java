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
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.AlimentacaoDTO;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OmAlimDaoTest {
	
	private DAOGenericoTest daoGenericoTest;

	@Before
	public void setUp() throws Exception {
		daoGenericoTest = new DAOGenericoTest();
		daoGenericoTest.iniciaConexaoBanco();
	}

//	PRIMEIRO METODO DO DAO
	@Test
	public void pesquisarOmAlimPorCriterio(){
		
		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
		
		OmUsr omUsr = new OmUsrBuilder().withDsUsuario("lek").withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
		
		OmCc omCc = new OmCcBuilder().withOmUsrrevisao(omUsr).withOmUsrstativo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmProgrp omProgrp= new OmProgrpBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmProduto omProduto = new OmProdutoBuilder().withOmCc(omCc).withOmProgrp(omProgrp).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmAlgocor omAlgocor = new OmAlgocorBuilder().buildAndPersist(daoGenericoTest);
		
		OmTppt omTppt = new OmTpptBuilder().withOmAlgocor(omAlgocor).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmPt omPt = new OmPtBuilder().withOmCc(omCc).withOmTppt(omTppt).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmPrg omPrg = new OmPrgBuilder().withOmProduto(omProduto).withOmPt(omPt).buildAndPersist(daoGenericoTest);
		
		OmMapa omMapa = new OmMapaBuilder().withDsMapa("!!!").withOmPrg(omPrg).withOmProduto(omProduto).withOmPt(omPt).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmAlim alim = new OmAlimBuilder().withCdAlim("teste eduardo").withDsAlim("DDD").withTpAlim((byte)2).withOmMapa(omMapa).withOmUsr(omUsr).withStAlim((byte)1).buildAndPersist(daoGenericoTest);
		
		Assert.assertEquals(alim.getIdAlim(), 1l);
		
		OmPa omPa = new OmPaBuilder().withOmPt(omPt).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmMapapa mapapa = new OmMapapaBuilder().withOmMap(omMapa).withOmPa(omPa).withOmProduto(omProduto).buildAndPersist(daoGenericoTest);
		
		OmAlimrea omAlimrea = new OmAlimreaBuilder().withOmAlim(alim).withOmMapapa(mapapa).withOmUsr(omUsr).buildAndPersist(daoGenericoTest);
		
		Assert.assertEquals(omAlimrea.getIdAlimrea(), new Long(1));
		
		//------------------- INICIO FILTRO DA CONSULTA --------------------------------------
		AlimentacaoDTO filtro = new AlimentacaoDTO();
		OmAlim alimentacao = new OmAlim();
		
//		OmAlimrea rea = new OmAlimrea();
//		rea.setCdLido("1");
//		Set<OmAlimrea> omAlimreas = new HashSet<OmAlimrea>();
//		omAlimreas.add(rea);
//		alimentacao.setOmAlimreas(omAlimreas);
		
		alimentacao.setCdAlim("");
		alimentacao.setDsAlim("");
		alimentacao.setTpAlim((byte)6);
		OmPt omPtFiltro = new OmPt();
		omPtFiltro.setCdPt("");
		omPtFiltro.setDsPt("");
		OmMapa mapa = new OmMapa();
		mapa.setCdMapa("");
		mapa.setDsMapa("");
		mapa.setOmPt(omPtFiltro);
		alimentacao.setOmMapa(mapa);
		OmUsr usuario = new OmUsr();
		usuario.setCdUsr("");
		usuario.setDsNome("");
		alimentacao.setOmUsr(usuario);
		alimentacao.setStAlim((byte)6);
		filtro.setAlimentacao(alimentacao);
		//--------------------- FIM FILTRO DA CONSULTA --------------------------------------
		
		OmAlimDAO alimDAO = new OmAlimDAO(daoGenericoTest.getSession());

		List<OmAlim> lista = alimDAO.getAlimentacoesDTO(filtro);
		
		Assert.assertEquals(lista.size(), 1);
		
	}
	
//	@Test
//	public void testeMetodoGetCorrente(){
//		
//		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
//		
//		OmUsr omUsr = new OmUsrBuilder().withCdUsuario("tetetetetetetete").withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
//		
//		OmCc omCc = new OmCcBuilder().withOmUsrrevisao(omUsr).withOmUsrstativo(omUsr).buildAndPersist(daoGenericoTest);
//		
//		OmProgrp omProgrp= new OmProgrpBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
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
//		OmMapa omMapa = new OmMapaBuilder().withCdMapa("XXXXXXL").withOmPrg(omPrg).withOmProduto(omProduto).withOmPt(omPt).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
//
//		OmAlim alim = new OmAlimBuilder().withCdAlim("teste eduardo").withDsAlim("DDD").withTpAlim((byte)2).withOmMapa(omMapa).withOmUsr(omUsr).withStAlim((byte)1).buildAndPersist(daoGenericoTest);
//		
//		OmAlimDAO dao = new OmAlimDAO(daoGenericoTest.getSession());
//		
//		List<OmAlim> lista = dao.getCorrente(alim.getIdAlim());
//		
//		Assert.assertEquals(lista.size(), 1);
//		
//	}
	
//	@Test
//	public void testeMetodoGetRealimentacoes(){
//		
//		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
//		
//		OmUsr omUsr = new OmUsrBuilder().withCdUsuario("tetetetetetetete").withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
//		
//		OmCc omCc = new OmCcBuilder().withOmUsrrevisao(omUsr).withOmUsrstativo(omUsr).buildAndPersist(daoGenericoTest);
//		
//		OmProgrp omProgrp= new OmProgrpBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
//		
//		OmProduto omProduto = new OmProdutoBuilder().withOmCc(omCc).withOmProgrp(omProgrp).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
//		
//		OmAlgocor omAlgocor = new OmAlgocorBuilder().buildAndPersist(daoGenericoTest);
//		
//		OmTppt omTppt = new OmTpptBuilder().withOmAlgocor(omAlgocor).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
//		
//		OmPt omPt = new OmPtBuilder().withCdPt("E").withOmCc(omCc).withOmTppt(omTppt).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
//		
//		OmPrg omPrg = new OmPrgBuilder().withOmProduto(omProduto).withOmPt(omPt).buildAndPersist(daoGenericoTest);
//		
//		OmMapa omMapa = new OmMapaBuilder().withCdMapa("EE").withOmPrg(omPrg).withOmProduto(omProduto).withOmPt(omPt).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
//
//		OmAlim alim = new OmAlimBuilder().withCdAlim("teste eduardo").withDsAlim("DDD").withTpAlim((byte)2).withOmMapa(omMapa).withOmUsr(omUsr).withStAlim((byte)1).buildAndPersist(daoGenericoTest);
//		
//		Assert.assertEquals(alim.getIdAlim(), 1);
//
//		//----------- INICIO FILTO CONSULTA ----------------
//		LeiturasCODTO filtro = new LeiturasCODTO();
//		MapaCODTO mapa = new MapaCODTO();
//		mapa.setCdMapa("EE");
//		filtro.setCdMaquina("E");
//		filtro.setMapa(mapa);
//		//----------- FIM FILTO CONSULTA ----------------
//		
//		OmAlimDAO dao = new OmAlimDAO(daoGenericoTest.getSession());
//		
//		List<OmAlim> lista = dao.getRealimentacoes(filtro);
//		
//		Assert.assertEquals(lista.get(0).getOmMapa().getCdMapa(), "EE");
//		Assert.assertEquals(lista.get(0).getOmMapa().getOmPt().getCdPt(), "E");
//		
//	}
	
	@After
	public void tearDown() throws Exception {
		daoGenericoTest.finalizaConexaoBanco();
		daoGenericoTest = null;
	}

}
