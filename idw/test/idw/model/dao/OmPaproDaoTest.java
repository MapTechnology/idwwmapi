package idw.model.dao;

import idw.builders.OmAlgocorBuilder;
import idw.builders.OmCcBuilder;
import idw.builders.OmMapaBuilder;
import idw.builders.OmMapapaBuilder;
import idw.builders.OmPaBuilder;
import idw.builders.OmPaproBuilder;
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
import idw.model.pojos.OmPapro;
import idw.model.pojos.OmPrg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.OmUsrgrp;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OmPaproDaoTest {

	private DAOGenericoTest daoGenericoTest;
	private List<OmPapro> listaRegistros = new ArrayList<OmPapro>(); 
	
	@Before
	public void setUp() throws Exception {
		daoGenericoTest = new DAOGenericoTest();
		daoGenericoTest.iniciaConexaoBanco();
	}
	
	public void salvarRegistrosOmPapro(){
		
		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder()
		.buildAndPersist(daoGenericoTest);		
		
		OmUsr omUsr = new OmUsrBuilder()
		.withOmUsrgrp(omUsrgrp)
		.buildAndPersist(daoGenericoTest);
		
		OmCc omCc = new OmCcBuilder()
		.withOmUsrrevisao(omUsr)
		.withOmUsrstativo(omUsr)
		.buildAndPersist(daoGenericoTest);
		
		OmAlgocor omAlgocor = new OmAlgocorBuilder()
		.buildAndPersist(daoGenericoTest);
		
		OmTppt omTppt = new OmTpptBuilder()
		.withOmAlgocor(omAlgocor)
		.withOmUsrRevisao(omUsr)
		.withOmUsrStAtivo(omUsr)
		.buildAndPersist(daoGenericoTest);
		
		OmPt omPt = new OmPtBuilder()
		.withOmCc(omCc)
		.withOmTppt(omTppt)
		.withOmUsrRevisao(omUsr)
		.withOmUsrStAtivo(omUsr)
		.buildAndPersist(daoGenericoTest);
		
		OmPt omPt2 = new OmPtBuilder()
		.withCdPt("eduu2")
		.withOmCc(omCc)
		.withOmTppt(omTppt)
		.withOmUsrRevisao(omUsr)
		.withOmUsrStAtivo(omUsr)
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
		
		OmMapa omMapa = new OmMapaBuilder()
		.withOmPrg(omPrg)
		.withOmProduto(omProduto)
		.withOmPt(omPt)
		.withOmUsrRevisao(omUsr)
		.withOmUsrStAtivo(omUsr)
		.buildAndPersist(daoGenericoTest);
		
		OmPa omPa = new OmPaBuilder()
		.withOmPt(omPt)
		.withOmUsrRevisao(omUsr)
		.withOmUsrStAtivo(omUsr)
		.buildAndPersist(daoGenericoTest);
		
		OmMapapa omMapapa = new OmMapapaBuilder()
		.withOmMap(omMapa)
		.withOmPa(omPa)
		.withOmProduto(omProduto)
		.buildAndPersist(daoGenericoTest);
		
		OmPapro omPapro = new OmPaproBuilder()
		.withOmMapapa(omMapapa)
		.withOmPa(omPa)
		.withOmProduto(omProduto)
		.withOmPt(omPt)
		.buildAndPersist(daoGenericoTest);
		
		OmPapro omPapro2 = new OmPaproBuilder()
		.withOmMapapa(omMapapa)
		.withOmPa(omPa)
		.withOmProduto(omProduto)
		.withOmPt(omPt)
		.buildAndPersist(daoGenericoTest);
		
		OmPapro omPapro3 = new OmPaproBuilder()
		.withOmMapapa(omMapapa)
		.withOmPa(omPa)
		.withOmProduto(omProduto)
		.withOmPt(omPt2)
		.buildAndPersist(daoGenericoTest);
		
		listaRegistros.add(omPapro);
		listaRegistros.add(omPapro2);
		listaRegistros.add(omPapro3);
		
	}
	
	public void salvarRegistrosOmPapro2(){
		
		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder()
		.withCodigo("teste")
		.buildAndPersist(daoGenericoTest);		
		
		OmUsr omUsr = new OmUsrBuilder()
		.withCdUsuario("teste")
		.withOmUsrgrp(omUsrgrp)
		.buildAndPersist(daoGenericoTest);
		
		OmCc omCc = new OmCcBuilder()
		.withCdCc("teste")
		.withOmUsrrevisao(omUsr)
		.withOmUsrstativo(omUsr)
		.buildAndPersist(daoGenericoTest);
		
		OmAlgocor omAlgocor = new OmAlgocorBuilder()
		.withDsAlgocor("teste")
		.buildAndPersist(daoGenericoTest);
		
		OmTppt omTppt = new OmTpptBuilder()
		.withCdTppt("teste")
		.withOmAlgocor(omAlgocor)
		.withOmUsrRevisao(omUsr)
		.withOmUsrStAtivo(omUsr)
		.buildAndPersist(daoGenericoTest);
		
		OmPt omPt = new OmPtBuilder()
		.withCdPt("teste")
		.withOmCc(omCc)
		.withOmTppt(omTppt)
		.withOmUsrRevisao(omUsr)
		.withOmUsrStAtivo(omUsr)
		.buildAndPersist(daoGenericoTest);
		
		OmPt omPt2 = new OmPtBuilder()
		.withCdPt("teste")
		.withOmCc(omCc)
		.withOmTppt(omTppt)
		.withOmUsrRevisao(omUsr)
		.withOmUsrStAtivo(omUsr)
		.buildAndPersist(daoGenericoTest);
		
		OmProgrp omProgrp = new OmProgrpBuilder()
		.withCdProgrp("teste")
		.withOmUsrRevisao(omUsr)
		.withOmUsrStAtivo(omUsr)
		.buildAndPersist(daoGenericoTest);
		
		OmProduto omProduto = new OmProdutoBuilder()
		.withCdProduto("teste")
		.withOmCc(omCc)
		.withOmProgrp(omProgrp)
		.withOmUsrRevisao(omUsr)
		.withOmUsrStAtivo(omUsr)
		.buildAndPersist(daoGenericoTest);
		
		OmPrg omPrg = new OmPrgBuilder()
		.withCdPrg("teste")
		.withOmProduto(omProduto)
		.withOmPt(omPt)
		.buildAndPersist(daoGenericoTest);
		
		OmMapa omMapa = new OmMapaBuilder()
		.withCdMapa("teste")
		.withOmPrg(omPrg)
		.withOmProduto(omProduto)
		.withOmPt(omPt)
		.withOmUsrRevisao(omUsr)
		.withOmUsrStAtivo(omUsr)
		.buildAndPersist(daoGenericoTest);
		
		OmPa omPa = new OmPaBuilder()
		.withCdPa("teste")
		.withOmPt(omPt)
		.withOmUsrRevisao(omUsr)
		.withOmUsrStAtivo(omUsr)
		.buildAndPersist(daoGenericoTest);
		
		OmMapapa omMapapa = new OmMapapaBuilder()
		.withOmMap(omMapa)
		.withOmPa(omPa)
		.withOmProduto(omProduto)
		.buildAndPersist(daoGenericoTest);
		
		OmPapro omPapro = new OmPaproBuilder()
		.withOmMapapa(omMapapa)
		.withOmPa(omPa)
		.withOmProduto(omProduto)
		.withOmPt(omPt)
		.buildAndPersist(daoGenericoTest);
		
		OmPapro omPapro2 = new OmPaproBuilder()
		.withOmMapapa(omMapapa)
		.withOmPa(omPa)
		.withOmProduto(omProduto)
		.withOmPt(omPt)
		.buildAndPersist(daoGenericoTest);
		
		OmPapro omPapro3 = new OmPaproBuilder()
		.withOmMapapa(omMapapa)
		.withOmPa(omPa)
		.withOmProduto(omProduto)
		.withOmPt(omPt2)
		.buildAndPersist(daoGenericoTest);
		
		listaRegistros.add(omPapro);
		listaRegistros.add(omPapro2);
		listaRegistros.add(omPapro3);
		
	}
	
	@Test
	public void getTodosProdutosDoPaDoPtTest(){
		salvarRegistrosOmPapro();
		OmpaproDao dao = new OmpaproDao(daoGenericoTest.getSession());
		List<OmPapro> listaConsulta = dao.getTodosProdutosDoPaDoPt(listaRegistros.get(2).getOmPt());
		Assert.assertEquals(1, listaConsulta.size());
		
		listaConsulta = dao.getTodosProdutosDoPaDoPt(listaRegistros.get(0).getOmPt());
		Assert.assertEquals(2, listaConsulta.size());
		
		daoGenericoTest.flush();
	}
	
	@Test
	public void removerTodosProdutosDoPaDoPtTest(){
		salvarRegistrosOmPapro2();
		OmpaproDao dao = new OmpaproDao(daoGenericoTest.getSession());
		dao.removerTodosProdutosDoPaDoPt(listaRegistros.get(2).getOmPt());
		List<OmPapro> retorno = dao.getTodosProdutosDoPaDoPt(listaRegistros.get(2).getOmPt());
		Assert.assertEquals(0, retorno.size());
		daoGenericoTest.flush();
	}
	
	@After
	public void tearDown() throws Exception {
		daoGenericoTest.finalizaConexaoBanco();
		daoGenericoTest = null;
		listaRegistros = new ArrayList<OmPapro>();
	}
	
}