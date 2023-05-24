package idw.model.rn.alimentacao;

import idw.model.dao.DAOGenericoTest;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.util.Util;

import java.math.BigDecimal;
import java.util.Date;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConsumoAlimentacaoTest {
	
	private DAOGenericoTest daoGenericoTest;
	
	@Before
	public void setUp() throws Exception {
		daoGenericoTest = new DAOGenericoTest();
		daoGenericoTest.iniciaConexaoBanco();
		OmCfg omCfg = Util.getConfigGeral(daoGenericoTest.getSession());
		Assert.assertNotNull(omCfg);
	}

	@After
	public void tearDown() throws Exception {
		daoGenericoTest.finalizaConexaoBanco();
		daoGenericoTest = null;
	}
	
	@Test
	public void consumirPorCicloTest(){
		ConsumoAlimentacaoRN consumoAlimentacao = new ConsumoAlimentacaoRN(daoGenericoTest);
		OmPt omPt = daoGenericoTest.findById(OmPt.class, 355l, false);
		Date dtReferencia = new Date();
		try {
			consumoAlimentacao.consumirPorCiclo(omPt, dtReferencia, BigDecimal.ONE);
		} catch (SemCalendarioException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}