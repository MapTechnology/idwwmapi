package idw.model.rn.alimentacao;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.OmCfg;
import idw.model.rn.estoque.MovimentacaoLocalEstoque;
import idw.util.Util;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;

public class EntradaSetupTest {
	
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
	
	public void entradaSetupTest(){
		try {
			String cdProduto = "490172"; //CONECTOR USB 4P
			String CdDwEstlocal = "1"; //AREA DE SETUP
			String cdUsuario = "0"; //MAP
			int qtdEntrada = 10000;
						
			MovimentacaoLocalEstoque movimentacao = new MovimentacaoLocalEstoque(daoGenericoTest);
			movimentacao.setEntradaLocalProduto(cdProduto, CdDwEstlocal, qtdEntrada,cdUsuario);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
