package idw.model.dao;

import idw.builders.DwEstBuilder;
import idw.builders.DwEstmovBuilder;
import idw.builders.DwEstproBuilder;
import idw.builders.DwTurnoBuilder;
import idw.builders.OmAlgocorBuilder;
import idw.builders.OmCcBuilder;
import idw.builders.OmProdutoBuilder;
import idw.builders.OmProgrpBuilder;
import idw.builders.OmPtBuilder;
import idw.builders.OmTpptBuilder;
import idw.builders.OmUsrBuilder;
import idw.builders.OmUsrgrpBuilder;
import idw.builders.PpClienteBuilder;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstmov;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmAlgocor;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.OmUsrgrp;
import idw.model.pojos.PpCliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwEstmovDaoTest {

	private DAOGenericoTest daoGenericoTest;

	@Before
	public void setUp() throws Exception {
		daoGenericoTest = new DAOGenericoTest();
		daoGenericoTest.iniciaSessao();
	}
	
	@Test
	public void testeGetDwEstmov(){
		
		daoGenericoTest.flush();
		daoGenericoTest.rollBackTransacao();
		daoGenericoTest.iniciaTransacao();		
		
		Date data = new Date(114, 4, 9);
		
		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
		
		OmUsr omUsr = new OmUsrBuilder().withDsUsuario("miltons").withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
		
		OmProgrp omProgrp = new OmProgrpBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmCc OmCc = new OmCcBuilder().withOmUsrrevisao(omUsr).withOmUsrstativo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmProduto omProduto = new OmProdutoBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmProgrp(omProgrp).withOmCc(OmCc).buildAndPersist(daoGenericoTest);
		
		DwEst dwEst = new DwEstBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		PpCliente ppCliente = new PpClienteBuilder().buildAndPersist(daoGenericoTest);
		
		DwEstpro dwEstpro = new DwEstproBuilder().withOmProduto(omProduto).withDwEst(dwEst).withPpCliente(ppCliente).buildAndPersist(daoGenericoTest);
		
		OmAlgocor omAlgocor = new OmAlgocorBuilder().buildAndPersist(daoGenericoTest);
		
		OmTppt omTppt = new OmTpptBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmAlgocor(omAlgocor).buildAndPersist(daoGenericoTest); 

		OmPt omPt = new OmPtBuilder().withCdPt("edu").withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmCc(OmCc).withOmTppt(omTppt).buildAndPersist(daoGenericoTest);
		
		DwTurno dwTurno = new DwTurnoBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		DwEstmov dwEstmov = new DwEstmovBuilder().withOmUsr(omUsr).withDwTurno(dwTurno).withDtHrMov(data).withOmPt(omPt).withDwEstpro(dwEstpro).buildAndPersist(daoGenericoTest);
		
		Assert.assertEquals(dwEstmov.getOmPt().getCdPt(), "edu");
		
		DwEstmovDAO dao = new DwEstmovDAO(daoGenericoTest.getSession());
		
		DwEstmov estmov = dao.getDwEstmov(omProduto, dwEst, data);
		
		Assert.assertEquals(estmov.getOmPt().getCdPt(), "edu");
		
		daoGenericoTest.rollBackTransacao();
		
	}
	
	@Test
	public void testeGetDwEstmovPeriodo1(){
		
		daoGenericoTest.flush();
		daoGenericoTest.rollBackTransacao();
		daoGenericoTest.iniciaTransacao();		
		
		Date data = new Date(114, 4, 9);
		
		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
		
		OmUsr omUsr = new OmUsrBuilder().withDsUsuario("miltons").withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
		
		OmProgrp omProgrp = new OmProgrpBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmCc OmCc = new OmCcBuilder().withOmUsrrevisao(omUsr).withOmUsrstativo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmProduto omProduto = new OmProdutoBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmProgrp(omProgrp).withOmCc(OmCc).buildAndPersist(daoGenericoTest);

		DwEst dwEst = new DwEstBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		PpCliente ppCliente = new PpClienteBuilder().buildAndPersist(daoGenericoTest);
		
		DwEstpro dwEstpro = new DwEstproBuilder().withOmProduto(omProduto).withDwEst(dwEst).withPpCliente(ppCliente).buildAndPersist(daoGenericoTest);
		DwEstpro dwEstpro1 = new DwEstproBuilder().withOmProduto(omProduto).withDwEst(dwEst).withPpCliente(ppCliente).buildAndPersist(daoGenericoTest);
		DwEstpro dwEstpro2 = new DwEstproBuilder().withOmProduto(omProduto).withDwEst(dwEst).withPpCliente(ppCliente).buildAndPersist(daoGenericoTest);
		
		OmAlgocor omAlgocor = new OmAlgocorBuilder().buildAndPersist(daoGenericoTest);
		
		OmTppt omTppt = new OmTpptBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmAlgocor(omAlgocor).buildAndPersist(daoGenericoTest); 

		OmPt omPt = new OmPtBuilder().withCdPt("edu").withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmCc(OmCc).withOmTppt(omTppt).buildAndPersist(daoGenericoTest);
		
		DwTurno dwTurno = new DwTurnoBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		DwEstmov dwEstmov = new DwEstmovBuilder().withDtHrMov(data).withOmUsr(omUsr).withDwTurno(dwTurno).withOmPt(omPt).withDwEstpro(dwEstpro).buildAndPersist(daoGenericoTest);
		DwEstmov dwEstmov1 = new DwEstmovBuilder().withDtHrMov(data).withOmUsr(omUsr).withDwTurno(dwTurno).withOmPt(omPt).withDwEstpro(dwEstpro1).buildAndPersist(daoGenericoTest);
		DwEstmov dwEstmov2 = new DwEstmovBuilder().withDtHrMov(data).withOmUsr(omUsr).withDwTurno(dwTurno).withOmPt(omPt).withDwEstpro(dwEstpro2).buildAndPersist(daoGenericoTest);
		
		List<OmProduto> listaProdutos = new ArrayList<OmProduto>();
		listaProdutos.add(omProduto);
		listaProdutos.add(omProduto);
		listaProdutos.add(omProduto);
		
		DwEstmovDAO dao = new DwEstmovDAO(daoGenericoTest.getSession());
		
		List<DwEstmov> lista = dao.getDwEstmovPeriodo(listaProdutos, dwEst, data, data);
		
		Assert.assertEquals(lista.size(), 3);
		
		daoGenericoTest.rollBackTransacao();
		
	}
	
	@Test
	public void testeGetDwEstmovPeriodo2(){
		
		daoGenericoTest.flush();
		daoGenericoTest.rollBackTransacao();
		daoGenericoTest.iniciaTransacao();
		
		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
		
		OmUsr omUsr = new OmUsrBuilder().withDsUsuario("miltons").withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
		
		OmProgrp omProgrp = new OmProgrpBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmCc OmCc = new OmCcBuilder().withOmUsrrevisao(omUsr).withOmUsrstativo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmProduto omProduto = new OmProdutoBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmProgrp(omProgrp).withOmCc(OmCc).buildAndPersist(daoGenericoTest);
		
		DwEst dwEst = new DwEstBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		PpCliente ppCliente = new PpClienteBuilder().buildAndPersist(daoGenericoTest);
		
		DwEstpro dwEstpro = new DwEstproBuilder().withOmProduto(omProduto).withDwEst(dwEst).withPpCliente(ppCliente).buildAndPersist(daoGenericoTest);
		
		OmAlgocor omAlgocor = new OmAlgocorBuilder().buildAndPersist(daoGenericoTest);
		
		OmTppt omTppt = new OmTpptBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmAlgocor(omAlgocor).buildAndPersist(daoGenericoTest); 

		OmPt omPt = new OmPtBuilder().withCdPt("edu").withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmCc(OmCc).withOmTppt(omTppt).buildAndPersist(daoGenericoTest);
		
		DwTurno dwTurno = new DwTurnoBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		Date data = new Date(114, 4, 9);
		
		DwEstmov dwEstmov = new DwEstmovBuilder().withOmUsr(omUsr).withDwTurno(dwTurno).withDtHrMov(data).withOmPt(omPt).withDwEstpro(dwEstpro).buildAndPersist(daoGenericoTest);

		DwEstmovDAO dao = new DwEstmovDAO(daoGenericoTest.getSession());
		
		List<DwEstmov> lista = dao.getDwEstmovPeriodo(omProduto, dwEst, data, data);
		
		Assert.assertEquals(lista.get(0).getOmPt().getCdPt(), "edu");
		
		daoGenericoTest.rollBackTransacao();
	}
	
	@Test
	public void testeGetDwEstmovPeriodo3(){
		
		daoGenericoTest.flush();
		daoGenericoTest.rollBackTransacao();
		daoGenericoTest.iniciaTransacao();
		
		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
		
		OmUsr omUsr = new OmUsrBuilder().withDsUsuario("miltons").withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
		
		OmProgrp omProgrp = new OmProgrpBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmCc OmCc = new OmCcBuilder().withOmUsrrevisao(omUsr).withOmUsrstativo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmProduto omProduto = new OmProdutoBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmProgrp(omProgrp).withOmCc(OmCc).buildAndPersist(daoGenericoTest);
		
		DwEst dwEst = new DwEstBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		PpCliente ppCliente = new PpClienteBuilder().buildAndPersist(daoGenericoTest);
		
		DwEstpro dwEstpro = new DwEstproBuilder().withOmProduto(omProduto).withDwEst(dwEst).withPpCliente(ppCliente).buildAndPersist(daoGenericoTest);
		
		OmAlgocor omAlgocor = new OmAlgocorBuilder().buildAndPersist(daoGenericoTest);
		
		OmTppt omTppt = new OmTpptBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmAlgocor(omAlgocor).buildAndPersist(daoGenericoTest); 

		OmPt omPt = new OmPtBuilder().withCdPt("edu").withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmCc(OmCc).withOmTppt(omTppt).buildAndPersist(daoGenericoTest);
		
		DwTurno dwTurno = new DwTurnoBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		Date data = new Date(114, 4, 9);
		
		DwEstmov dwEstmov = new DwEstmovBuilder().withOmUsr(omUsr).withDwTurno(dwTurno).withDtHrMov(data).withOmPt(omPt).withDwEstpro(dwEstpro).buildAndPersist(daoGenericoTest);

		DwEstmovDAO dao = new DwEstmovDAO(daoGenericoTest.getSession());
		
		List<DwEstmov> lista = dao.getDwEstmovPeriodo(dwEst, data, data);
		
		Assert.assertEquals(lista.get(0).getOmPt().getCdPt(), "edu");
		
		daoGenericoTest.rollBackTransacao();
		
	}
	
	@Test
	public void testeApagarMovimentacaoEstoqueDwEstmovs(){
		
		daoGenericoTest.flush();
		daoGenericoTest.rollBackTransacao();
		daoGenericoTest.iniciaTransacao();
		
		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
		
		OmUsr omUsr = new OmUsrBuilder().withDsUsuario("miltons").withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
		
		OmProgrp omProgrp = new OmProgrpBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmCc OmCc = new OmCcBuilder().withOmUsrrevisao(omUsr).withOmUsrstativo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmProduto omProduto = new OmProdutoBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmProgrp(omProgrp).withOmCc(OmCc).buildAndPersist(daoGenericoTest);
		
		DwEst dwEst = new DwEstBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		PpCliente ppCliente = new PpClienteBuilder().buildAndPersist(daoGenericoTest);
		
		DwEstpro dwEstpro = new DwEstproBuilder().withOmProduto(omProduto).withDwEst(dwEst).withPpCliente(ppCliente).buildAndPersist(daoGenericoTest);
		
		OmAlgocor omAlgocor = new OmAlgocorBuilder().buildAndPersist(daoGenericoTest);
		
		OmTppt omTppt = new OmTpptBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmAlgocor(omAlgocor).buildAndPersist(daoGenericoTest); 

		OmPt omPt = new OmPtBuilder().withCdPt("edu").withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmCc(OmCc).withOmTppt(omTppt).buildAndPersist(daoGenericoTest);
		
		DwTurno dwTurno = new DwTurnoBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);

		DwEstmov dwEstmov = new DwEstmovBuilder().withOmUsr(omUsr).withDwTurno(dwTurno).withOmPt(omPt).withDwEstpro(dwEstpro).buildAndPersist(daoGenericoTest);

		DwEstmovDAO dao = new DwEstmovDAO(daoGenericoTest.getSession());
		
		dao.apagarMovimentacaoEstoque(dwEst);
		
		List<DwEstmov> lista = dao.getDwEstmovs();
		
		Assert.assertEquals(lista.size(), 0);
		
		daoGenericoTest.rollBackTransacao();
		
	}
	
	@Test
	public void testeApagarMovimentacaoEstoqueDwEstpros(){
		
		daoGenericoTest.flush();
		daoGenericoTest.rollBackTransacao();
		daoGenericoTest.iniciaTransacao();
		
		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
		
		OmUsr omUsr = new OmUsrBuilder().withDsUsuario("miltons").withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
		
		OmProgrp omProgrp = new OmProgrpBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmCc OmCc = new OmCcBuilder().withOmUsrrevisao(omUsr).withOmUsrstativo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmProduto omProduto = new OmProdutoBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmProgrp(omProgrp).withOmCc(OmCc).buildAndPersist(daoGenericoTest);
		
		DwEst dwEst = new DwEstBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		PpCliente ppCliente = new PpClienteBuilder().buildAndPersist(daoGenericoTest);
		
		DwEstpro dwEstpro = new DwEstproBuilder().withOmProduto(omProduto).withDwEst(dwEst).withPpCliente(ppCliente).buildAndPersist(daoGenericoTest);

		DwEstproDAO dao = new DwEstproDAO(daoGenericoTest.getSession());
		
		dao.apagarTodosEstoqueProduto();
		
		List<DwEstpro> lista = dao.getDwEstpros();
		
		Assert.assertEquals(lista.size(), 0);
		
		daoGenericoTest.rollBackTransacao();
		
	}
	
	@After
	public void tearDown() throws Exception {
		daoGenericoTest.flush();
		daoGenericoTest.rollBackTransacao();
		daoGenericoTest.finalizaConexaoBanco();
		daoGenericoTest = null;
	}
	
}