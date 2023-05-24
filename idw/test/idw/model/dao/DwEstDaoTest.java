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
import idw.webservices.dto.EstoqueDTO;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DwEstDaoTest {
	
	private DAOGenericoTest daoGenericoTest;

	@Before
	public void setUp() throws Exception {
		daoGenericoTest = new DAOGenericoTest();
		daoGenericoTest.iniciaSessao();
	}
	
	@Test
	public void testeGetEstoquesDTO(){
		
		daoGenericoTest.flush();
		daoGenericoTest.rollBackTransacao();
		daoGenericoTest.iniciaTransacao();		
		
		Date data = new Date(114, 4, 9);
		
		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
		
		OmUsr omUsr = new OmUsrBuilder().withDsUsuario("miltons").withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
		
		DwEst dwEst = new DwEstBuilder().withDtRevisao(data).withDtStAtivo(data).withCdEst("alessandre").withDsEst("fredson").withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
//		Assert.assertEquals(dwEst.getIdEst(), 1);
		
		EstoqueDTO filtro = new EstoqueDTO();
		DwEst estoque = new DwEst();
//		estoque.setIdEst(1l);
//		estoque.setCdEst("alessandre");
//		estoque.setDsEst("fredson");
//		estoque.setDtRevisao(data);
//		OmUsr usuarioFiltro = new OmUsr();
//		usuarioFiltro.setCdUsr("");
//		usuarioFiltro.setDsNome("miltons");
//		estoque.setOmUsrByIdUsrrevisao(usuarioFiltro);
//		estoque.setOmUsrByIdUsrstativo(usuarioFiltro);
//		estoque.setDtStativo(data);
//		estoque.setStAtivo((byte)1);
		filtro.setEstoque(estoque);
		
		DwEstDAO dao = new DwEstDAO(daoGenericoTest.getSession());
		List<DwEst> lista = dao.getEstoquesDTO(filtro);
		
		Assert.assertEquals(lista.get(0).getOmUsrByIdUsrrevisao().getDsNome(), "miltons");
		
		daoGenericoTest.rollBackTransacao();
	}
	
	@Test
	public void testePesquisarEstoqueMateriaPrima(){
		
		daoGenericoTest.flush();
		daoGenericoTest.rollBackTransacao();
		daoGenericoTest.iniciaTransacao();		
		
		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
		
		OmUsr omUsr = new OmUsrBuilder().withDsUsuario("miltons").withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
		
		DwEst dwEst = new DwEstBuilder().withCdEst("cdEst").withDsEst("fredson").withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmCc omCc = new OmCcBuilder().withOmUsrrevisao(omUsr).withOmUsrstativo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmProgrp omProgrp = new OmProgrpBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		PpCliente ppCliente = new PpClienteBuilder().withCdCliente("cdCliente").buildAndPersist(daoGenericoTest);
		
		OmProduto omProduto = new OmProdutoBuilder().withCdProduto("cdProduto").withOmCc(omCc).withOmProgrp(omProgrp).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		DwEstpro dwEstpro = new DwEstproBuilder().withDwEst(dwEst).withOmProduto(omProduto).withPpCliente(ppCliente).buildAndPersist(daoGenericoTest);
		
//		Assert.assertEquals(dwEst.getIdEst(), 1);
		
		DwEstDAO dao = new DwEstDAO(daoGenericoTest.getSession());
		List<DwEst> lista = dao.pesquisarEstoqueMateriaPrima(null /*"cdEst"*/, null /*"cdProduto"*/, "cdCliente");
		
		Assert.assertEquals(lista.get(0).getDsEst(), "fredson");
		
		daoGenericoTest.rollBackTransacao();
	}
	
	@Test
	public void testeSetEstoqueDTO(){
		
		daoGenericoTest.flush();
		daoGenericoTest.rollBackTransacao();
		daoGenericoTest.iniciaTransacao();		

		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
		
		OmUsr omUsr = new OmUsrBuilder().withDsUsuario("miltons").withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
		
		DwEst dwEst = new DwEstBuilder().withCdEst("alessandre").withDsEst("fredson").withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
//		Assert.assertEquals(dwEst.getIdEst(), 1);
		
		EstoqueDTO filtro = new EstoqueDTO();
		DwEst estoque = new DwEst();
		estoque.setIdEst(dwEst.getIdEst());
		filtro.setEstoque(estoque);
		
		DwEstDAO dao = new DwEstDAO(daoGenericoTest.getSession());
		DwEst retorno = dao.setEstoqueDTO(filtro);
		
		Assert.assertEquals(retorno.getCdEst(), "alessandre");
		
		daoGenericoTest.rollBackTransacao();
	}
	
	@Test
	public void testeGetDwEstPorCd(){
		
		daoGenericoTest.flush();
		daoGenericoTest.rollBackTransacao();
		daoGenericoTest.iniciaTransacao();		
		
		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
		
		OmUsr omUsr = new OmUsrBuilder().withDsUsuario("miltons").withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
		
		DwEst dwEst = new DwEstBuilder().withCdEst("alessandre").withDsEst("fredson").withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
//		Assert.assertEquals(dwEst.getIdEst(), 1);
		
		DwEstDAO dao = new DwEstDAO(daoGenericoTest.getSession());
		List<DwEst> lista = dao.getDwEstPorCd("alessandre");
		
		Assert.assertEquals(lista.get(0).getDsEst(), "fredson");
		
		daoGenericoTest.rollBackTransacao();
		
	}
	
	@Test
	public void testeAtivaEstoqueDTO(){
		
		daoGenericoTest.flush();
		daoGenericoTest.rollBackTransacao();
		daoGenericoTest.iniciaTransacao();		
		
		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
		
		OmUsr omUsr = new OmUsrBuilder().withDsUsuario("miltons").withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
		
		DwEst dwEst = new DwEstBuilder().withCdEst("alessandre").withDsEst("fredson").withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
//		Assert.assertEquals(dwEst.getIdEst(), 1);
		
		EstoqueDTO filtro = new EstoqueDTO();
		DwEst estoque = new DwEst();
		estoque.setRevisao(0l);
		estoque.setCdEst("alessandre");
		filtro.setEstoque(estoque);
		
		DwEstDAO dao = new DwEstDAO(daoGenericoTest.getSession());
		List<DwEst> lista = dao.ativaEstoqueDTO(filtro);
		
		Assert.assertEquals(lista.get(0).getDsEst(), "fredson");
		
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