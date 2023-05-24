package idw.model.dao;

import java.math.BigDecimal;
import java.util.List;

import junit.framework.Assert;
import idw.builders.DwCalBuilder;
import idw.builders.DwEstBuilder;
import idw.builders.DwEstlocalBuilder;
import idw.builders.DwEstlocalproBuilder;
import idw.builders.DwEstproBuilder;
import idw.builders.OmAlgocorBuilder;
import idw.builders.OmCcBuilder;
import idw.builders.OmProdutoBuilder;
import idw.builders.OmProgrpBuilder;
import idw.builders.OmPtBuilder;
import idw.builders.OmTpptBuilder;
import idw.builders.OmUsrBuilder;
import idw.builders.OmUsrgrpBuilder;
import idw.builders.PpClienteBuilder;
import idw.builders.PpCpBuilder;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstlocal;
import idw.model.pojos.DwEstlocalpro;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.OmAlgocor;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.OmUsrgrp;
import idw.model.pojos.PpCliente;
import idw.model.pojos.PpCp;
import idw.webservices.dto.DwEstlocalproDTO;
import idw.webservices.dto.FiltroConsolLocalEstoqueDTO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwEstlocalproDaoTest {
	
	private DAOGenericoTest daoGenericoTest;
	
	@Before
	public void setUp() throws Exception {
		daoGenericoTest = new DAOGenericoTest();
		daoGenericoTest.iniciaSessao();
	}
	
	@Test
	public void testMetodo(){
		
		daoGenericoTest.flush();
		daoGenericoTest.rollBackTransacao();
		daoGenericoTest.iniciaTransacao();
		
		OmUsrgrp omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);
		
		OmUsr omUsr = new OmUsrBuilder().withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
		
		OmProgrp omProgrp = new OmProgrpBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmCc cc = new OmCcBuilder().withOmUsrrevisao(omUsr).withOmUsrstativo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmProduto produto = new OmProdutoBuilder().withCdProduto("###").withOmProgrp(omProgrp).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmCc(cc).buildAndPersist(daoGenericoTest);
		
		DwEst dwEst = new DwEstBuilder().withCdEst("edu").withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		PpCliente ppCliente = new PpClienteBuilder().buildAndPersist(daoGenericoTest);
		
		DwEstpro dwEstpro = new DwEstproBuilder().withOmProduto(produto).withDwEst(dwEst).withPpCliente(ppCliente).buildAndPersist(daoGenericoTest);
		
		DwEstlocal dwEstlocal = new DwEstlocalBuilder().withCdLocal("milton").withDwEst(dwEst).withOmUsrStAtivo(omUsr).withOmUsrRevisao(omUsr).buildAndPersist(daoGenericoTest);
		
		DwCal dwCal = new DwCalBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmAlgocor algocor = new OmAlgocorBuilder().buildAndPersist(daoGenericoTest);
		
		OmTppt omTppt = new OmTpptBuilder().withOmAlgocor(algocor).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		
		OmPt omPt = new OmPtBuilder().withOmTppt(omTppt).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withOmCc(cc).buildAndPersist(daoGenericoTest);
		
		PpCp ppCp = new PpCpBuilder().withDwCal(dwCal).withOmPt(omPt).buildAndPersist(daoGenericoTest);
		
		DwEstlocalpro estlocalpro = new DwEstlocalproBuilder().withQtSaida(new BigDecimal(5)).withDwEstlocal(dwEstlocal).withDwEstpro(dwEstpro).withPpCp(ppCp).buildAndPersist(daoGenericoTest);
		
		Assert.assertEquals(1, estlocalpro.getIdEstlocalpro());
		
		DwEstlocalproDAO dao = new DwEstlocalproDAO(daoGenericoTest.getSession());
		
		FiltroConsolLocalEstoqueDTO filtro = new FiltroConsolLocalEstoqueDTO();
		DwEstlocalpro localPro = new DwEstlocalpro();
		localPro.setDwEstpro(dwEstpro);
//		e.setDwEstlocal(new DwEstlocal());
//		e.getDwEstlocal().setDwEst(dwEst);
		localPro.setDwEstlocal(dwEstlocal);
		localPro.setPpCp(ppCp);
//		filtro.setDwEstlocalpro(localPro);
//		
//		List<DwEstlocalpro> lista = dao.getDwEstlocalpros(filtro);
//
//		Assert.assertEquals(new BigDecimal(5), lista.get(0).getQtSaida());

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
