package idw.model.rn.consolidacao.variacaoritmo;

import java.util.Date;

import idw.model.dao.DAOGenerico;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwTParada;
import idw.model.rn.AbstractRN;
import idw.model.rn.consolidacao.ConsolidacaoPeriodo;
import idw.model.rn.consolidacao.IConsolidacaoPeriodo;
import idw.util.IdwLogger;

/**
 * 
 * @author Milton
 * @deprecated Atualmente o tratamento para tempo de variação de ritmo está desativado. <br>
 * Além disso, fazia parte um novo design para consolidação de eventos que ainda está incompleto. <br> 
 * A idéia do tratamento de variação de ritmo  era usar este tempo para abater dos tempos de ciclos, e assim saber o tempo correto do ciclo, que seria o tempo que veio da máquina
 * menos o tempo das paradas que ocorreram dentro dele
 */
public class ConsolidacaoPeriodoVariacaoRitmo extends AbstractRN<DAOGenerico> implements IConsolidacaoPeriodo {
	
	private final DwTParada dwTParada;
	private final boolean isAbater;
	private final IConsolidacaoVariacaoRitmo consolidacaoVariacaoRitmo;
	
	public ConsolidacaoPeriodoVariacaoRitmo(DAOGenerico dao, DwTParada dwTParada, boolean isAbater, IConsolidacaoVariacaoRitmo consolidacaoVariacaoRitmo){
		super(dao);
		this.dwTParada = dwTParada;
		this.isAbater = isAbater;
		this.consolidacaoVariacaoRitmo = consolidacaoVariacaoRitmo;
	}
	
	@Override
	public void consolidarTurno(DwConsolid dwConsolid, Date dtHrIRef, Date dtHrFRef, Long duracao, IdwLogger log, int idLog, int identacao, String chamador)
			throws SemCicloPadraoException {
		
		consolidacaoVariacaoRitmo.consolidar(dwConsolid, duracao, dwTParada, isAbater);

	}

	@Override
	public void consolidarHora(DwConsolid dwConsolid, Date dtHrIRef, Date dtHrFRef, Long duracao, IdwLogger log, int idLog, int identacao, String chamador)
			throws SemCicloPadraoException {
		
		consolidacaoVariacaoRitmo.consolidar(dwConsolid, duracao, dwTParada, isAbater);

	}

	@Override
	public void consolidarMes(DwConsolid dwConsolid, Date dtHrIRef, Date dtHrFRef, Long duracao, IdwLogger log, int idLog, int identacao, String chamador) {
		
		if(ConsolidacaoPeriodo.USAR_CONSOLIDACAO_POR_MESANO){
			consolidacaoVariacaoRitmo.consolidar(dwConsolid, duracao, dwTParada, isAbater);
		}


	}

	@Override
	public void consolidarAcumulado(DwConsolid dwConsolid, Date dtHrIRef, Date dtHrFRef, Long duracao, IdwLogger log, int idLog, int identacao, String chamador) {
		
		consolidacaoVariacaoRitmo.consolidar(dwConsolid, duracao, dwTParada, isAbater);

	}

}
