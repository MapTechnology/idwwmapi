package idw.model.rn.alimentacao;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.OmCfg;
import idw.util.Util;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DesalimentacaoTest {
	
	private DAOGenericoTest daoGenericoTest;
	
	@Before
	public void iniciaConexaoBanco() throws Exception {
		daoGenericoTest = new DAOGenericoTest();
		daoGenericoTest.iniciaConexaoBanco();
		OmCfg omCfg = Util.getConfigGeral(daoGenericoTest.getSession());
		Assert.assertNotNull(omCfg);
	}
	
	@After
	public void finalizaConexaoBanco() throws Exception {
		daoGenericoTest.finalizaConexaoBanco();
		daoGenericoTest = null;
	}
	
	@Test
	public void realizarDesalimentacaoTest(){
		String cdPt = "CM402-2_L6";
		Long idUsr = 1l;
		try {
			DesalimentacaoRN rn = new DesalimentacaoRN(daoGenericoTest);
			rn.desalimentaPontosAlimentacaoDoPT(cdPt, idUsr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
