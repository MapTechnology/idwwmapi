package idw.model.rn.consolidacao;

import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.excessoes.CicloJaContabilizadoException;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.ReprocessarMsEvtException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;

/**
 * 
 * Interface para execução da consolidação dos dados coletados em {@link MsEvt} 
 * Todas as classes que heram esta interface deve ter construtor default, pois ele � acessado em {@link ConsolidacaoFactory#executarConsolidacao(DAOGenerico, OmPt, DwConsolpt, List, MsEvt, OmCfg, IdwLogger, int, int)} 
 *
 */
public interface IConsolidacao {
	public void executarConsolidacao(OmPt omPt, DwConsolpt dwconsolpt, List<DwCalsem> dwCalsems, MsEvt msEvt, OmCfg omcfg, IdwLogger log, int idLog, int identacao)  throws SemCalendarioException, SemSGBDException, SemCicloPadraoException, SemPlanejamentoException, RegistroDesconhecidoException, EventoInvalidoException, ReprocessarMsEvtException, NumeroSerieIrregularException, CicloJaContabilizadoException;
	public void setDao(DAOGenerico dao);
}
