package idw.model.rn.consolidacao.variacaoritmo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.MapQuery;
import idw.model.excessoes.CicloJaContabilizadoException;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.ReprocessarMsEvtException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwConsolvaritmo;
import idw.model.pojos.DwConsolvaritmolog;
import idw.model.pojos.DwConsolvaritmologcau;
import idw.model.pojos.DwConsolvaritmooco;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwTRitmo;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.consolidacao.EventoInvalidoException;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.util.IdwLogger;
import idw.webservices.dto.TurnoAtualDTO;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoFimVariacaoRitmo extends ConsolidaRN implements IConsolidacao {

	/*
	 * Metodo principal para consolidacao do final de ritmo. Essa consolidacao
	 * far� a separacao dos horarios em turnos e horas
	 * 
	 * @see
	 * idw.model.rn.consolidacao.IConsolidacao#executarConsolidacao(idw.model.
	 * pojos.OmPt, idw.model.pojos.DwConsolpt, java.util.List,
	 * idw.model.pojos.MsEvt, idw.model.pojos.OmCfg, idw.util.IdwLogger, int,
	 * int)
	 */
	@Override
	public void executarConsolidacao(OmPt omPt, DwConsolpt dwconsolpt, List<DwCalsem> dwCalsems, MsEvt msEvt,
			OmCfg omcfg, IdwLogger log, int idLog, int identacao)
					throws SemCalendarioException, SemSGBDException, SemCicloPadraoException, SemPlanejamentoException,
					RegistroDesconhecidoException, EventoInvalidoException, ReprocessarMsEvtException,
					NumeroSerieIrregularException, CicloJaContabilizadoException {

		Validate.notNull(msEvt.getDthrEvento(), "Inicio de parada esta nulo");

		Date dtHrInicioVarRitmo = msEvt.getDthrEvento();

		Validate.notNull(omPt, "Posto de trabalho esta nulo");
		Validate.notNull(omPt.getIdPt(), "idPt esta nulo");

		PpCp ppCp = obtemPpCp(log, idLog, identacao, omPt, dwCalsems, msEvt, omcfg);
		Validate.notNull(ppCp, "ppCp eh nulo");

		ppCp.mudarDthrIniciorealIfNull(dtHrInicioVarRitmo);

		FolhaRN folhaRN = new FolhaRN(this.getDao());
		DwFolha dwFolha = folhaRN.getDwFolhaAtiva(ppCp);
		Validate.notNull(dwFolha, "nao tem folha ativa para o ppCp");

		//validarEventoDeveSerMaiorUltimoEventoConsolidado(dwconsolpt, dtHrInicioVarRitmo);

		// Finaliza o registro em DwConsolVaRitmolog
		List<DwConsolvaritmolog> logs = pesquisarDwConsolvaritmologEmAberto(omPt);
		for (DwConsolvaritmolog ritmolog : logs) {
			ritmolog.setDthrFvaritmo(msEvt.getDthrEvento());
			getDao().makePersistent(ritmolog);

			// Consolidar o periodo
			consolidarVariacao(ritmolog, omPt, dwCalsems, log, idLog, identacao, msEvt, ppCp, dwFolha);
		}
	}

	/*
	 * Metodo para consolidar a variacao de ritmo nos consolids de turno e hora
	 * 
	 */
	private void consolidarVariacao(DwConsolvaritmolog ritmolog, OmPt ompt, List<DwCalsem> dwCalsems, IdwLogger log,
			int idLog, int identacao, MsEvt msevt, PpCp ppCp, DwFolha dwFolha) {
		
		// Encontrar os turno no periodo avaliado
		TurnoRN turnoRN = new TurnoRN(getDao());
		List<TurnoAtualDTO> listaTurnoAtualDTO = turnoRN.getTurnoAtualDTOsPeriodo(dwCalsems, ritmolog.getDthrIvaritmo(), ritmolog.getDthrFvaritmo(), log, idLog, identacao);
		
		
		// Avalia cada turno para fechar os periodos
		for (TurnoAtualDTO turnoAtualDTO : listaTurnoAtualDTO) {

			
			DwConsolid dwConsolid = null;
			try {
				dwConsolid = this.obtemConsolIdTurno(log, idLog, identacao, ompt, ppCp, dwFolha, turnoAtualDTO, msevt.getDwPepro());
			} catch (SemCalendarioException e) {
			} catch (SemSGBDException e) {
			} catch (SemCicloPadraoException e) {
			}
			if (dwConsolid == null) {
				continue;
			}
			
			
			// Calcula as datas do periodo e o tempo transcorrido
			Date dthrInicio = turnoAtualDTO.getDtHrITurno();
			Date dthrFim = turnoAtualDTO.getDtHrFTurno();
			
			if (DataHoraRN.after(ritmolog.getDthrIvaritmo(), dthrInicio))
				dthrInicio = ritmolog.getDthrIvaritmo();
			
			if (DataHoraRN.before(ritmolog.getDthrFvaritmo(), dthrFim))
				dthrFim = ritmolog.getDthrFvaritmo();
			
			Integer duracao = DataHoraRN.getQuantidadeSegundosNoPeriodo(dthrInicio, dthrFim);

			// Avaliar as consolidacoes
			for (DwConsol consol : dwConsolid.getDwConsols()) {
				// Variar para cada causa e verificar se ela ja existe
				for (DwConsolvaritmologcau causa : ritmolog.getDwConsolvaritmologcaus()) {
					// Atualizacao de DwConsolVaritmo
					boolean isExiste = false;
					DwConsolvaritmo varitmo = null;
					for (DwConsolvaritmo iVaritmo : consol.getDwConsolvaritmos()) {
						// Verificar se ja existe um registro em
						// DWConsolvaritmo. Se exisitr entao nao precisao
						// consolidar
						// Isso ocorrer� somente se existirem 2 ritmos em aberto
						// por algum bug
						if (causa.getDwTRitmo().getCdTritmo().equals(iVaritmo.getDwTRitmo().getCdTritmo())) {
							isExiste = true;
							varitmo = iVaritmo;
						}
					}
					if (isExiste == false) {
						varitmo = new DwConsolvaritmo();
						varitmo.setIdConsolvaritmo(null);
						varitmo.setDwConsol(consol);
						varitmo.setDwTRitmo(causa.getDwTRitmo());
						varitmo.setSegAutoTemporitmo(new BigDecimal(duracao));

						getDao().makePersistent(varitmo);

					}
					
					// Atualizacao DwConsolVaritmOco
					DwConsolvaritmooco oco = new DwConsolvaritmooco();
					oco.setIdConsolvartimooco(null);
					oco.setDthrIvaritmo(dthrInicio);
					oco.setDthrFvaritmo(dthrFim);
					oco.setDwConsolvaritmo(varitmo);
					oco.setDwConsolvaritmolog(ritmolog);
					
					getDao().makePersistent(oco);
					
				} // fim do for para vartimo
			}
		}
	}

	/*
	 * Metodo para pesquisar os dwconsolvartimo em aberto para o posto
	 */
	protected List<DwConsolvaritmolog> pesquisarDwConsolvaritmologEmAberto(OmPt ompt) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwConsolvaritmolog a");
		q.append("where a.omPt = :ompt");
		q.append("and a.dthrFvaritmo is null");

		q.defineParametro("ompt", ompt);

		return q.list();
	}

	/*
	 * Metodo para pesquisar os dwconsolvartimo em aberto para o posto
	 */
	protected DwConsolvaritmolog pesquisarDwConsolvaritmologFechada(OmPt ompt) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwConsolvaritmolog a");
		q.append("where a.omPt = :ompt");
		q.append("and a.dthrFvaritmo is not null");
		q.append("order by a.idConsolvaritmolog desc");
		q.setMaxResults(1);

		q.defineParametro("ompt", ompt);
		q.setMaxResults(1);

		return (DwConsolvaritmolog) q.uniqueResult();
	}

	/*
	 * Pesquisa DwTRitmo com a causa enviada
	 * 
	 */
	protected DwTRitmo pesquisarDwTRitmo(OmPt ompt, String cdVariacao) {
		DwTRitmo retorno = null;
		MapQuery q = new MapQuery(getDaoSession());

		q.append("select a");
		q.append("from DwTRitmo a");
		q.append("where a.cdTritmo = :cd");
		q.append("and a.omTppt = :omtppt");
		q.append("and a.stAtivo = 1");

		q.defineParametro("cd", cdVariacao);
		q.defineParametro("omtppt", ompt.getOmTppt());

		retorno = (DwTRitmo) q.uniqueResult();

		return retorno;
	}
}
