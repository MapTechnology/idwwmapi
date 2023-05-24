package idw.model.dao;

import idw.builders.DwEstBuilder;
import idw.builders.DwEstproBuilder;
import idw.builders.OmCcBuilder;
import idw.builders.OmProdutoBuilder;
import idw.builders.OmProgrpBuilder;
import idw.builders.OmUsrBuilder;
import idw.builders.OmUsrgrpBuilder;
import idw.builders.PpClienteBuilder;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.OmUsr;
import idw.model.pojos.OmUsrgrp;
import idw.model.pojos.PpCliente;

import java.math.BigDecimal;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwEstproDaoTest {
	
	private DAOGenericoTest daoGenericoTest;

	@Before
	public void setUp() throws Exception {
		daoGenericoTest = new DAOGenericoTest();
		daoGenericoTest.iniciaSessao();
	}
	
	@Test
	public void testePesquisarDwEstproByIdProduto(){
		
		daoGenericoTest.flush();
		daoGenericoTest.rollBackTransacao();
		daoGenericoTest.iniciaTransacao();	
		
		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
		
		OmUsr omUsr = new OmUsrBuilder().withDsUsuario("miltons").withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
		
		OmProgrp omProgrp = new OmProgrpBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmCc omCc = new OmCcBuilder().withOmUsrrevisao(omUsr).withOmUsrstativo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmProduto omProduto = new OmProdutoBuilder().withOmProgrp(omProgrp).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmCc(omCc).buildAndPersist(daoGenericoTest);
		
		DwEst dwEst = new DwEstBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		PpCliente ppCliente = new PpClienteBuilder().withCdCliente("eu").buildAndPersist(daoGenericoTest); 
		
		DwEstpro dwEstpro = new DwEstproBuilder().withOmProduto(omProduto).withPpCliente(ppCliente).withDwEst(dwEst).buildAndPersist(daoGenericoTest);
		
//		Assert.assertEquals(dwEstpro.getIdEstpro(), new Long(1));
		
		DwEstproDAO dao = new DwEstproDAO(daoGenericoTest.getSession());
		List<DwEstpro> lista = dao.pesquisarDwEstproByIdProduto(dwEstpro.getIdEstpro());
		
		Assert.assertEquals(lista.get(0).getPpCliente().getCdCliente(), "eu");
		
		daoGenericoTest.rollBackTransacao();
	}
	
	@Test
	public void testeGetMapQueryDwEstpro(){
		
		daoGenericoTest.flush();
		daoGenericoTest.rollBackTransacao();
		daoGenericoTest.iniciaTransacao();	
		
		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
		
		OmUsr omUsr = new OmUsrBuilder().withDsUsuario("miltons").withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
		
		OmProgrp omProgrp = new OmProgrpBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmCc omCc = new OmCcBuilder().withOmUsrrevisao(omUsr).withOmUsrstativo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmProduto omProduto = new OmProdutoBuilder().withOmProgrp(omProgrp).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmCc(omCc).buildAndPersist(daoGenericoTest);
		
		DwEst dwEst = new DwEstBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		PpCliente ppCliente = new PpClienteBuilder().withCdCliente("eu").buildAndPersist(daoGenericoTest); 
		
		DwEstpro dwEstpro = new DwEstproBuilder().withOmProduto(omProduto).withPpCliente(ppCliente).withDwEst(dwEst).buildAndPersist(daoGenericoTest);
		
//		Assert.assertEquals(dwEstpro.getIdEstpro(), new Long(1));
		
		DwEstproDAO dao = new DwEstproDAO(daoGenericoTest.getSession());
		List<DwEstpro> lista = dao.getDwEstproList(omProduto, dwEst);
		
		Assert.assertEquals(lista.get(0).getPpCliente().getCdCliente(), "eu");
		
		daoGenericoTest.rollBackTransacao();
	}
	
	@Test
	public void testeApagarEstoqueProdutos(){
		
		daoGenericoTest.flush();
		daoGenericoTest.rollBackTransacao();
		daoGenericoTest.iniciaTransacao();	
		
		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
		
		OmUsr omUsr = new OmUsrBuilder().withDsUsuario("miltons").withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
		
		OmProgrp omProgrp = new OmProgrpBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmCc omCc = new OmCcBuilder().withOmUsrrevisao(omUsr).withOmUsrstativo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmProduto omProduto = new OmProdutoBuilder().withOmProgrp(omProgrp).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmCc(omCc).buildAndPersist(daoGenericoTest);
		
		DwEst dwEst = new DwEstBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		PpCliente ppCliente = new PpClienteBuilder().withCdCliente("eu").buildAndPersist(daoGenericoTest); 
		
		DwEstpro dwEstpro = new DwEstproBuilder().withOmProduto(omProduto).withPpCliente(ppCliente).withDwEst(dwEst).buildAndPersist(daoGenericoTest);
		
//		Assert.assertEquals(dwEstpro.getIdEstpro(), new Long(1));
		
		DwEstproDAO dao = new DwEstproDAO(daoGenericoTest.getSession());
		dao.apagarEstoqueProdutos(dwEst);
		List<DwEstpro> lista = dao.getDwEstpros();
		
		Assert.assertEquals(lista.size(), 0);
		
		daoGenericoTest.rollBackTransacao();
	}
	
	//METODO ZERARESTOQUEPRODUTOS APARENTEMENTE TA EXECUTANDO PORÉM NÃO ESTA REALIZANDO AS ALTERAÇÕES NO REGISTRO (VERIFICAR)
	@Test
	public void testeZerarEstoqueProdutos(){
		
		daoGenericoTest.flush();
		daoGenericoTest.rollBackTransacao();
		daoGenericoTest.iniciaTransacao();		
		
		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
		
		OmUsr omUsr = new OmUsrBuilder().withDsUsuario("miltons").withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
		
		OmProgrp omProgrp = new OmProgrpBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmCc omCc = new OmCcBuilder().withOmUsrrevisao(omUsr).withOmUsrstativo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmProduto omProduto = new OmProdutoBuilder().withOmProgrp(omProgrp).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmCc(omCc).buildAndPersist(daoGenericoTest);
		
		DwEst dwEst = new DwEstBuilder().withCdEst("milton").withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
//		Assert.assertEquals(dwEst.getIdEst(), 1l);
		
		PpCliente ppCliente = new PpClienteBuilder().withCdCliente("eu").buildAndPersist(daoGenericoTest); 
		
		DwEstpro dwEstpro = new DwEstproBuilder().withQtEntrada(new BigDecimal(2)).withOmProduto(omProduto).withPpCliente(ppCliente).withDwEst(dwEst).buildAndPersist(daoGenericoTest);
		
		Assert.assertEquals(dwEstpro.getQtEntrada(), new BigDecimal(2));
		
		DwEstproDAO dao = new DwEstproDAO(daoGenericoTest.getSession());
		dao.zerarEstoqueProdutos(dwEst);
		daoGenericoTest.getSession().flush();
		
		List<DwEstpro> lista = dao.getDwEstpros();
		daoGenericoTest.getSession().refresh(dwEstpro);
		
		Assert.assertEquals(lista.get(0).getDwEst().getIdEst(), dwEst.getIdEst());
		Assert.assertEquals(lista.get(0).getQtEntrada().longValue(), BigDecimal.ZERO.longValue());
		
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
