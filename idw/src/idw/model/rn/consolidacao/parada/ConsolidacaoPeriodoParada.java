package idw.model.rn.consolidacao.parada;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwCalDAO;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwPepro;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.rn.AbstractRN;
import idw.model.rn.consolidacao.ConsolidacaoPeriodo;
import idw.model.rn.consolidacao.IConsolidacaoPeriodo;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;

/**
 * 
 * @author Milton
 */
final class ConsolidacaoPeriodoParada extends AbstractRN<DAOGenerico> implements IConsolidacaoPeriodo {

	private final ConsolidacaoParada consolidacaoParada;
	private final DwConsolpt dwConsolpt;
	private final OmCfg omCfg;
	private final PpCp ppCp;
	private final DwFolha dwFolha;
	private final DwPepro dwPepro;
	private final OmPt omPt;
	private final IdwLogger log;
	private final int idLog;
	private final int identacao;
	private final boolean isAjustarLinhaTempo;
	private final Map<String, BigDecimal> mapCavAtivasProduto;
	private DwConsolpalog dwConsolpalog;
	private boolean isAbater;
	private Date dtHrDwRt;

	public ConsolidacaoPeriodoParada(IdwLogger log, int idLog, int identacao, ConsolidacaoParada consolidacaoParada, OmCfg omCfg, DwConsolpt dwConsolpt, PpCp ppCp,
			DwFolha dwFolha, DwPepro dwPepro, boolean isAjustarLinhaTempo) {
		super(consolidacaoParada.getDao());
		this.log = log;
		this.idLog = idLog;
		this.identacao = identacao;
		this.consolidacaoParada = consolidacaoParada;
		this.omCfg = omCfg;
		this.ppCp = ppCp;
		this.dwFolha = dwFolha;
		this.dwPepro = dwPepro;
		this.dwConsolpt = dwConsolpt;
		this.isAjustarLinhaTempo = isAjustarLinhaTempo;
		this.omPt = dwConsolpt.getOmPt();
		this.mapCavAtivasProduto = new HashMap<>();
	}

	public void consolidar(boolean isAbater, Date dtHrInicio, Date dtHrFim, DwConsolpalog dwConsolpalog, Date dtHrDwRt, String chamador) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException {
		this.isAbater = isAbater;
		this.dwConsolpalog = dwConsolpalog;
		this.dtHrDwRt = dtHrDwRt;

		DwCal dwCal = getDwCalDaParada(dwConsolpalog);		
		ConsolidacaoPeriodo consolidacaoPeriodo = new ConsolidacaoPeriodo(getDao(), omPt, omCfg, dtHrInicio, dtHrFim, dwCal, log, idLog, identacao);
		consolidacaoPeriodo.consolidar(log, idLog, identacao, ppCp, dwFolha, dwPepro, this, chamador);
	}
	
	private DwCal getDwCalDaParada(DwConsolpalog dwConsolpalog) {
		DwCalDAO dwCalDAO = new DwCalDAO(getDaoSession());
		DwCal dwCal = dwCalDAO.getDwCalFromDwConsolpalog(dwConsolpalog, omCfg.getDwCal());
		return dwCal;
	}
	
	@Override
	public void consolidarTurno(DwConsolid dwConsolid, Date dtHrIRef, Date dtHrFRef, Long duracao, IdwLogger log, int idLog, int identacao, String chamador)
			throws SemCicloPadraoException {
		consolidacaoParada.consolidarTempoParadaDwConsolid(log, idLog, identacao, isAbater, dtHrIRef, dtHrFRef,
				dwConsolid, dwConsolpt, omPt, ppCp, dwConsolpalog, omCfg, dtHrIRef, dtHrFRef, dwPepro, isAjustarLinhaTempo,
				mapCavAtivasProduto, dtHrDwRt, chamador + "-PeriodoParadaTurno");
	}

	@Override
	public void consolidarHora(DwConsolid dwConsolid, Date dtHrIRef, Date dtHrFRef, Long duracao, IdwLogger log, int idLog, int identacao, String chamador)
			throws SemCicloPadraoException {
		consolidacaoParada.consolidarTempoParadaDwConsolid(log, idLog, identacao, isAbater, dtHrIRef, dtHrFRef,
				dwConsolid, dwConsolpt, omPt, ppCp, dwConsolpalog, omCfg, dtHrIRef, dtHrFRef, dwPepro, isAjustarLinhaTempo,
				mapCavAtivasProduto, dtHrDwRt, chamador + "-PeriodoParadaHora");
	}

	@Override
	public void consolidarMes(DwConsolid dwConsolid, Date dtHrIRef, Date dtHrFRef, Long duracao, IdwLogger log, int idLog, int identacao, String chamador)
			throws SemCicloPadraoException {
		consolidacaoParada.consolidarTempoParadaDwConsolid(log, idLog, identacao, isAbater, dtHrIRef, dtHrFRef,
				dwConsolid, dwConsolpt, omPt, ppCp, dwConsolpalog, omCfg, dtHrIRef, dtHrFRef, dwPepro, isAjustarLinhaTempo,
				mapCavAtivasProduto, dtHrDwRt, chamador + "-PeriodoParadaMes");
	}

	@Override
	public void consolidarAcumulado(DwConsolid dwConsolid, Date dtHrIRef, Date dtHrFRef, Long duracao, IdwLogger log, int idLog, int identacao, String chamador)
			throws SemCicloPadraoException {
		consolidacaoParada.consolidarTempoParadaDwConsolid(log, idLog, identacao, isAbater, dtHrIRef, dtHrFRef,
				dwConsolid, dwConsolpt, omPt, ppCp, dwConsolpalog, omCfg, dtHrIRef, dtHrFRef, dwPepro, isAjustarLinhaTempo,
				mapCavAtivasProduto, dtHrDwRt, chamador + "-PeriodoParadaAcumulado");
	}

}
