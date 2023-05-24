package idw.model.rn;

import idw.model.dao.DAOGenericoTest;

import org.junit.After;
import org.junit.Before;

public class ConfiguracaoRNTest {

	private DAOGenericoTest daoGenericoTest;
	
	@Before
	public void setUp() throws Exception {
		daoGenericoTest = new DAOGenericoTest();
		daoGenericoTest.iniciaConexaoBanco(null);	
	}
	
	@After
	public void tearDown() throws Exception {
		daoGenericoTest.finalizaConexaoBanco();
		daoGenericoTest = null;
	}
	
}
