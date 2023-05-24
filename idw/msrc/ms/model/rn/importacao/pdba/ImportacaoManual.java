package ms.model.rn.importacao.pdba;

import java.math.BigDecimal;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.util.IdwLogger;
import ms.excessao.MsDesconhecidoException;
import ms.model.dto.ListaMSDTO;
import ms.model.rn.MsRN;

public class ImportacaoManual implements IDao{
	private IdwLogger log;
	private DAOGenerico daoPdba;
	private DAOGenericoInjet daoInjet;
	
	public ImportacaoManual() {
		this.log = new IdwLogger("ImportacaoManual");
		this.daoPdba = new DAOGenerico();
		this.daoInjet = new DAOGenericoInjet();
	}

	public ListaMSDTO importar(Long idMs, String login) {

		// Obtem dados do MS que irá ser executado
		log.info("Importacao Manual para o PDBA");

		ImportarPrColetorEPrSubColetorParaMsIcMsIhm importa = new ImportarPrColetorEPrSubColetorParaMsIcMsIhm(log, daoInjet, daoPdba);
		
		importa.setIdMs(new BigDecimal(idMs));
		importa.setLogin(login);
		
		importa.importar(null);
		
		ListaMSDTO retorno = new ListaMSDTO();
		retorno.setResultadoDTO(importa.getResultado());
		
		if (importa.getResultado().isComSucesso() == true){
			// Comita para a pesquisa poder pegar os valores atualizados.
			daoPdba.flushReiniciandoTransacao();
			daoPdba.clear();
			
			MsRN msrn = new MsRN();
			msrn.setSession(daoPdba.getSession());
			msrn.setIdMs(new BigDecimal(idMs));
			try {
				retorno= msrn.getListaMSDTO();
			} catch (MsDesconhecidoException e) {
				retorno.setResultadoDTO(importa.getResultado());
			}
		}

		log.info("FIM - Importacao Manual para o PDBA");

		return retorno;
	}
	public void iniciaConexaoBanco() {
		iniciaConexaoBanco(null);
	}

	@Override
	public void iniciaConexaoBanco(Session sessao) {
		daoPdba.iniciaSessao();
		daoPdba.iniciaTransacao();
		
		daoInjet.iniciaSessao();
		daoInjet.iniciaTransacao();
	}

	@Override
	public void finalizaConexaoBanco() {
		daoPdba.finalizaTransacao();
		daoPdba.finalizaSessao();
		
		daoInjet.finalizaTransacao();
		daoInjet.finalizaSessao();
	}
}
