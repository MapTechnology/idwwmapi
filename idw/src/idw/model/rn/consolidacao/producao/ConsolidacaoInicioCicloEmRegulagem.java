package idw.model.rn.consolidacao.producao;

import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoInicioCicloEmRegulagem extends ConsolidacaoProducao implements IConsolidacao{
	
	/**
	 * @param omPt
	 * @param dwCalsems <dwCalSem>
	 * @param msEvt
	 * @param omcfg
	 * @param log
	 * @throws SemCicloPadraoException 
	 * @throws SemSGBDException 
	 * @throws SemCalendarioException 
	 * @throws SemPlanejamentoException 
	 */
	@Override
	public void executarConsolidacao(OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, MsEvt msEvt, OmCfg omcfg, IdwLogger log, int idLog, int identacao)  throws SemCalendarioException, SemSGBDException, SemCicloPadraoException, SemPlanejamentoException, RegistroDesconhecidoException {
		// Nao eh necessario modificar nenhum aspecto do inicio de ciclo se for durante uma regulagem
		/* Alessandre em 16-05-17 a coleta vinda do concentrador em c# um ciclo que ocorre durante a regulagem, nunca chega como fim de ciclo
		 * mas sim como inicio de ciclo.
		 * Entao modifiquei a classe ConsolidacaoFactory no metodo executarConsolidacaoEmRegulagem fazendo com que a classe ConsolidacaoInicioCicloEmRegulagem
		 * nunca fosse chamada, mas sim a classe ConsolidacaoFimCicloEmRegulagem
		 */
	}

}
