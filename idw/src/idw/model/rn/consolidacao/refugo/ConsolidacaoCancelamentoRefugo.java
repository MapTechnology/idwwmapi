package idw.model.rn.consolidacao.refugo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DwConsolptDAO;
import idw.model.dao.MapQuery;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.ReprocessarMsEvtException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwConsolrelog;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.rn.FolhaRN;
import idw.model.rn.NumeroSerieRN;
import idw.model.rn.consolidacao.EventoInvalidoException;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoCancelamentoRefugo extends ConsolidacaoRefugoRN implements IConsolidacao{

	@Override
	public void executarConsolidacao(OmPt omPt, DwConsolpt dwconsolpt,
			List<DwCalsem> dwCalsems, MsEvt msevt, OmCfg omcfg, IdwLogger log,
			int idLog, int identacao) throws SemCalendarioException,
			SemSGBDException, SemCicloPadraoException,
			SemPlanejamentoException, RegistroDesconhecidoException,
			EventoInvalidoException, ReprocessarMsEvtException,
			NumeroSerieIrregularException {

		String cdCp = msevt.getNrop();
		Date dthrRefugo = msevt.getDthrEventoanterior();
		Date dthrCancelado = msevt.getDthrEvento();
		String cb = msevt.getCb();
		
		Validate.notNull(omPt, "OmPt esta nulo");
		Validate.notBlank(cdCp, "CdCp esta nulo");
		Validate.notNull(dthrRefugo, "DthrEvento esta nulo");
		Validate.notNull(dthrCancelado, "dtHrCancelado esta nulo");

		MsEvt msevtReferenciaParaCP = msevt;
		
		/*
		 * Se o codigo de barras vier preenchido entao � o cancelamento de refugo de um determinado numero de serie. Nesse caso o NS deve ser direcionado para um ESTOQUE de refugos
		 * Alem de ter um CB o posto devera estar com a configuracao de nao solicitar a qtde
		 */
		if (cb != null && cb.trim().equals("") == false && (omPt.getIsSolicitaqtde() == null || omPt.getIsSolicitaqtde() == false)  ) {
			Validate.notNull(omcfg, "Sem configuracao");
			Validate.notNull(omcfg.getDwEstByIdEstproducao(), "Sem configuracao estoque producao");
			
			// Localiza o numero de serie e aloca ele para o estoque de nulo
			NumeroSerieRN rn = new NumeroSerieRN(getDao());
			DwNserie dwnseriedb = null;
			dwnseriedb = rn.getDwNserieCb(msevt.getCb());

			if (dwnseriedb != null && dwnseriedb.getDwEst() != null) {
				log.info(idLog, identacao, "setando null para dwnseriedb.setDwEst para NS " + msevt.getCb());
				dwnseriedb.setDwEst(null);
				getDao().makePersistent(dwnseriedb);
				
				// Se o cancelamento do refugo for de uma op anterior, entao utilizar essa referencia
				if (msevt.getNrop().equals(msevt.getMsEvt().getNrop()) == false) {
					msevtReferenciaParaCP = msevt.getMsEvt();
				}
			} else {
				log.info(idLog, identacao, "o ns " + cb + " n�o est� refugado");
				Validate.notNull(dwnseriedb, "numero serie nao encontrado");
				Validate.notNull(dwnseriedb.getDwEst(), "numero serie nao esta refugado");
			}
		}

		// Pega referencia da ordem de produ��oo
		PpCp ppCp = obtemPpCp(log, idLog, identacao, omPt, dwCalsems, msevtReferenciaParaCP, omcfg);
		Validate.notNull(ppCp, "PpCp esta nulo");
		ppCp.mudarDthrIniciorealIfNull(dthrRefugo);
		
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		DwFolha dwFolha = folhaRN.getDwFolhaAtiva(ppCp);
		Validate.notNull(dwFolha, "nao encontrou folha ativa para o ppCP");

		// Pt de referencia pode ser outro se for outro PT que refugou
		OmPt omptReferencia = omPt;
		
		DwConsolrelog dwConsolrelog = this.obtemDwConsolrelog(omPt.getIdPt(), dthrRefugo);
		// Se o cancelamento do refugo for de um determinado NS e estiver sendo feito em um PT diferente do que refugou, entao
		// dwconsolrelog ser� null. Nesse caso devemos procurar pelo PT que refugou
		if (dwConsolrelog == null && msevt.getCb() != null) {
			// Obter identificacao do pt que realizou o refugo
			omptReferencia = pesquisarUltimaPassagemComRefugo(msevt.getCb());
			if (omptReferencia != null) {
				dwConsolrelog = this.obtemDwConsolrelog(omptReferencia.getIdPt(), dthrRefugo);
				if (dwConsolrelog != null)
					log.info(idLog, identacao, "encontrado dwConsolrelog.idConsolrelog=" + dwConsolrelog.getIdConsolrelog());
				else
					log.info(idLog, identacao, "nao encontrado dwconsolrelog");
				ppCp = obtemPpCp(log, idLog, identacao, omptReferencia, dwCalsems, msevtReferenciaParaCP, omcfg);
				if (ppCp != null)
					log.info(idLog, identacao, "op encontrada idCp = " + ppCp.getIdCp());
				Validate.notNull(ppCp, "PpCp esta nulo");
				
				DwConsolptDAO dwConsolptDAO = new DwConsolptDAO(getDaoSession());
				// Deve-se encontrar novo dwconsolpt pois o pt eh outro
				dwconsolpt = dwConsolptDAO.getDwConsolptSeNaoEncontraCria(omptReferencia);
				
				// Pesquisar a folha correta
				dwFolha = folhaRN.getDwFolhaAtiva(ppCp);
			}
		}
		
		// Se realmente nao encontrar o log, nao consolidar
		Validate.notNull(dwConsolrelog, "dwConsolrelog esta nulo");

		dwConsolrelog.setDthrCancelado(dthrCancelado);
		dwConsolrelog.setIsCancelado(true);

		consolidarRefugoTodosPeriodos(omptReferencia, dwconsolpt, dwCalsems, ppCp, dwFolha, dwConsolrelog, omcfg, log, idLog, identacao, msevt.getDwPepro());

		// APos consolidar o refugo, atualizar a producao refugada em ppCpProduto
		for (PpCpproduto cpproduto : ppCp.getPpCpprodutos()) {
			if (dwConsolrelog.getOmProduto().equals(cpproduto.getOmProduto())) {
				BigDecimal producaoRefugada = cpproduto.getPcsProducaorefugada();
				if (producaoRefugada == null)
					producaoRefugada = BigDecimal.ZERO;
				
				producaoRefugada = producaoRefugada.subtract(dwConsolrelog.getPcsAutoProducaorefugada());
				cpproduto.setPcsProducaorefugada(producaoRefugada);
				getDao().makePersistent(cpproduto);
			}
		}

	}
	
	/*
	 * Esse metodo tem o objetivo de encontrar o pt que realizou o refugo de um NS
	 */
	private OmPt pesquisarUltimaPassagemComRefugo(String cb) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwPassagem a");
		q.append("join a.dwNserie b");
		q.append("where b.cb = :cb");
		q.append("and a.dwEst is not null");
		q.append("order by a.dthr desc");
		q.defineParametro("cb", cb);
		q.setMaxResults(1);
		DwPassagem dwpassagem = (DwPassagem) q.uniqueResult();
		OmPt ompt = null;
		if (dwpassagem != null)
			ompt = dwpassagem.getOmPt();
		return ompt;
	}
}
