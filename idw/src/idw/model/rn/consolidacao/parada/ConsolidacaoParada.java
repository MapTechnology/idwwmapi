package idw.model.rn.consolidacao.parada;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwConsolpalogDAO;
import idw.model.dao.DwConsolpaocoDAO;
import idw.model.dao.MapQuery;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPacoteOuFatorException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmo;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpamo;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwRt;
import idw.model.pojos.DwTParada;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwRtTemplate;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.TempoRealRN;
import idw.model.rn.consolidacao.variacaoritmo.ConsolidacaoVariacaoRitmo;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;
import ms.util.UtilsThreads;

public class ConsolidacaoParada extends ConsolidaRN {

	public ConsolidacaoParada() {
		super();
	}

	public ConsolidacaoParada(DAOGenerico dao) {
		super(dao);
	}

	/**
	 * Consolida tempo da parada para o DwConsolid (turno, hora, mes, ano, acumado)
	 *
	 * <p>
	 * Se for uma consolidação de parada aberta ou alteração de código de parada aberta, e tiver mudança de folha, remover toda a
	 * consolidação feita com a folha anterior, e reconsolidar com a nova. <br>
	 * Se for alteração de alteração de código de parada fechada, usar a folha/calendário do código de parada.
	 *
	 */
	public void consolidarTempoParadaDwConsolid(
			IdwLogger log, int idLog, int identacao,
			boolean isAbater, Date dtHrIPeriodo, Date dtHrFPeriodo,
			DwConsolid dwConsolid, DwConsolpt dwConsolpt, OmPt omPt, PpCp ppCp,
			DwConsolpalog dwConsolpalog, OmCfg omcfg, Date dtHrIniParRef, Date dtHrFimParRef, DwPepro dwPepro,
			boolean isAjustarLinhaTempo, Map<String, BigDecimal> mapCavAtivaProduto, Date dtHrDwRt,
			String chamador)
			throws SemCicloPadraoException {

		log.info(idLog, identacao, "inicio do consolidarTempoParadaDwConsolid com chamado=" + chamador);
		log.iniciaAvaliacao(idLog, "fim do consolidarTempoParadaDwConsolid");
		BigDecimal cicloPadrao = getCicloPadrao(omPt, dwConsolid.getDwFolha());

		Date dtHrIRef = (DataHoraRN.compareTo(dtHrIniParRef, dtHrIPeriodo) < 0 ? dtHrIPeriodo : dtHrIniParRef);

		Date dtHrFRef = (DataHoraRN.compareTo(dtHrFimParRef, dtHrFPeriodo) < 0 ? dtHrFimParRef : dtHrFPeriodo);

		boolean isUltimoPeriodo = (DataHoraRN.equals(dtHrFRef, dtHrFimParRef));

		if (dwConsolpalog.getIsVarritmo() == null) {
			dwConsolpalog.setIsVarritmo(false);
		}

		// Parada será considerada como de variação de ritmo, sen�o � considerada no tempo ativo
		boolean isParadaVarRitmo = dwConsolpalog.getIsVarritmo();

		DwTParada dwTParada = dwConsolpalog.getDwTParada();

		// Pega dwConsol
		DwConsol dwConsol = dwConsolid.getDwConsols().iterator().next();

		BigDecimal cavAtiva = getCavAtivasAjustaDwConsolSenaoTiver(dwConsol);
		BigDecimal fatorContagem = BigDecimal.ONE;
		FolhaRN frn = new FolhaRN(getDao());
		try {
			fatorContagem = frn.getFatorContagemFromDwFolha(dwConsolid.getDwFolha(), omPt);
		} catch (SemPacoteOuFatorException e) {
			fatorContagem = BigDecimal.ONE;
		}
		
		/*
		 * Ajusta as cavtotais se estiver nulo
		 * Quando cavAtivas e cavTotais estão nulo, vestigio de versão antiga,
		 * ao entrar neste trecho, só a cavAtiva estava sendo preenchida por causa no método
		 * #getCavAtivasAjustaDwConsolSenaoTiver.
		 * Mas cavTotais permanecia nulo, e isso acabava gerando problema na ficha da máquina,
		 * pois ele esperar que se um dos dois estiver preenchido, vai considerar ambos como não nulo
		 * a linha abaixo garante que as cavTotais seja preenchida
		 */
		setCavTotaisDwConsolSeNulo(dwConsol);
		

		ppCp.mudarDthrIniciorealIfNull(dtHrIniParRef);

		if (isAjustarLinhaTempo) {
			if (isAbater) {
				dwConsolid.setDthrFconsol(dtHrIRef);
			}else {
				dwConsolid.setDtHr(dtHrIRef, dtHrFRef);
			}			
		}

		BigDecimal tempoParada = DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodoComScale5(dtHrIRef, dtHrFRef);
		
		

		BigDecimal qtOcorrenciaParada = BigDecimal.ONE;
		if (isAbater) {
			qtOcorrenciaParada = qtOcorrenciaParada.negate();
			tempoParada = tempoParada.negate();
		} else {

			DwConsolpaocoDAO dwConsolpaocoDAO = new DwConsolpaocoDAO(getDaoSession());
			DwConsolpaoco dwConsolpaoco = dwConsolpaocoDAO.getDwConsolpaoco(dwConsol, dwTParada, dwConsolpalog);
			if (dwConsolpaoco != null) {
				// se já existir um DwConsolpaoco para a parada, indica que ela já foi contabilizada anteriormente.
				qtOcorrenciaParada = BigDecimal.ZERO;
			}

		}

		log.mostrarAvaliacaoCompleta(idLog, identacao);
		
		log.info(idLog, identacao, "vou ajustar dwconsolpa");
		DwConsolpa dwConsolpa = this.getDwConsolpaSeNaoEncontrarGerarNovo(dwConsol, dwTParada);

		ajustarParadaDeDwConsolEDwConsolpa(cicloPadrao, cavAtiva, isParadaVarRitmo, dwTParada, dwConsol, dwConsolpa, tempoParada, qtOcorrenciaParada, fatorContagem, log, idLog, identacao);
		
		// Checa tempo total depois da consolidação
		checarTempoTotal(this.getClass().getSimpleName(), log, idLog, identacao, dwConsolid, omPt, dwConsol);
		
		this.getDao().makePersistent(dwConsol);
		
		this.getDao().makePersistent(dwConsolpa);

		
		log.info(idLog, identacao, "ajustando dwconsolmo");
		List<DwConsolmo> dwConsolmoComLoginAberto = this.getDwConsolmoComLoginAberto(dwConsol.getIdConsol());

		// TODO milton - rever trecho para consolidar apenas o tempo em que o operador estava logado dentro do DwConsolid
		// Atualizar DwConsolmo (DwConsol)
		for (DwConsolmo dwConsolmo : dwConsolmoComLoginAberto) {

			// dw_consolpamo
			DwConsolpamo dwConsolpamo = this.getDwConsolpamoSeNaoEncontrarNovo(dwConsolpa, dwConsolmo);

			ajustarParadaEmDwConsolmoEDwConsolpamo(isParadaVarRitmo, dwTParada, dwConsol, tempoParada, qtOcorrenciaParada,
					dwConsolmo, dwConsolpamo);

			this.getDao().makePersistent(dwConsolmo);
			this.getDao().makePersistent(dwConsolpamo);
			
			UtilsThreads.pausaNaThread(50l);

		}
		log.info(idLog, identacao, "executou ajustando dwconsolmo");

		FolhaRN folhaRN = new FolhaRN(getDao());
		ajustarParadaEmDwConsolpaprs(dwConsol, folhaRN, mapCavAtivaProduto);
		if (dwConsol.getDwConsolprs() != null)
			log.info(idLog, identacao, "executou ajustarParadaEmDwConsolpaprs para qt dwConsol.getDwConsolprs()=" + dwConsol.getDwConsolprs().size());
		else
			log.info(idLog, identacao, "executou ajustarParadaEmDwConsolpaprs para dwConsol.getDwConsolprs null");
		
		// DwConsolpaoco
		log.info(idLog, identacao, "ajustando dwconsolpaoco com idConsolpa=" + dwConsolpa.getIdConsolpa() + " e idConsolpalog=" + dwConsolpalog.getIdConsolpalog());
		DwConsolpaoco dwConsolpaoco = this.getDwConsolpaoco(dwConsolpa.getIdConsolpa(), dwConsolpalog.getIdConsolpalog());

		if (dwConsolpaoco == null)
			log.info(idLog, identacao, "Não encontrou dwconsolpaoco");
		else
			log.info(idLog, identacao, "Encontrou dwconsolpaoco com idConsolpaoco=" + dwConsolpaoco.getIdConsolpaoco());
		
		// Remove registro se estiver abatendo
		if (isAbater) {
			if (dwConsolpaoco != null) {
				log.info(idLog, identacao, "excluindo dwconsolpaoco com id " + dwConsolpaoco.getIdConsolpaoco());
				this.getDao().getSession().delete(dwConsolpaoco);
			}
		} else {

			if (dwConsolpaoco == null) {
				dwConsolpaoco = new DwConsolpaoco();
				dwConsolpaoco.setDwConsolpa(dwConsolpa);
				dwConsolpaoco.setDwConsolpalog(dwConsolpalog);
				dwConsolpaoco.setDthrCadastro(DataHoraRN.getDataHoraAtual());
				dwConsolpaoco.setOrigem(chamador);
				
				log.info(idLog, identacao, "Vou incluir dwconsolpaoco com dthrCadastro = " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dwConsolpaoco.getDthrCadastro()) + " para chamado " + chamador);
			}

			// Parada fechada?
			if (!dwConsolpalog.isAberta()) {
				// Limpa campo de fim de consolidação aberta
				dwConsolpaoco.setDthrFparadaAb(null);
			} else {
				// Atualiza data/hora ultima consolidação com o fim de referencia do periodo
				dwConsolpaoco.setDthrFparadaAb(dtHrFRef);
			}

			dwConsolpaoco.setDthrIparada(DataHoraRN.getMenorData(dtHrIRef, dwConsolpaoco.getDthrIparada()));
			dwConsolpaoco.setDthrFparada(DataHoraRN.getMaiorData(dtHrFRef, dwConsolpaoco.getDthrFparada()));
			dwConsolpaoco.setIsContinuaproximoperiodo(!isUltimoPeriodo);

			dwConsolpaoco.setDwTCausa(dwConsolpalog.getDwTCausa());
			dwConsolpaoco.setDwTAcao(dwConsolpalog.getDwTAcao());
			dwConsolpaoco.setDwTJust(dwConsolpalog.getDwTJust());

			ajustarParadaEmDwConsolpaoco(dwConsolpaoco, dwTParada, cicloPadrao, cavAtiva);

			this.getDao().makePersistent(dwConsolpaoco);

		}
		log.info(idLog, identacao, "executou ajustando dwconsolpaoco");

		log.info(idLog, identacao, "ajustarDwRt");
		ajustarDwRt(log, idLog, isAbater, dwConsolid, dwConsolpt, omPt, dwConsolpalog, dwPepro, dtHrFRef, isUltimoPeriodo, dtHrDwRt);
		log.info(idLog, identacao, "executou ajustarDwRt");

	}

	private void ajustarParadaEmDwConsolpaoco(DwConsolpaoco dwConsolpaoco, DwTParada dwTParada, BigDecimal cicloPadrao, BigDecimal cavAtiva) {

		BigDecimal tempoParadaDwConsolpaoco =
				DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodo(
						dwConsolpaoco.getDthrIparada(), dwConsolpaoco.getDthrFparada());

		BigDecimal pcsAutoPerdaparada = FormulasInjet.calcularPcsPerdaParada(tempoParadaDwConsolpaoco, cicloPadrao, cavAtiva);

		if (dwTParada.getIsPesa() != null && dwTParada.getIsPesa()) {
			dwConsolpaoco.setPcsAutoPerdaparadaCp(pcsAutoPerdaparada);
			dwConsolpaoco.setPcsAutoPerdaparadaSp(BigDecimal.ZERO);
		} else {
			dwConsolpaoco.setPcsAutoPerdaparadaCp(BigDecimal.ZERO);
			dwConsolpaoco.setPcsAutoPerdaparadaSp(pcsAutoPerdaparada);
		}
	}

	private void ajustarParadaEmDwConsolpaprs(DwConsol dwConsol, FolhaRN folhaRN, Map<String, BigDecimal> mapCavAtivaProduto) {
		if (dwConsol.getDwConsolprs() != null){
			DwFolha dwFolha = dwConsol.getDwConsolid().getDwFolha();
			for (DwConsolpr dwConsolpr : dwConsol.getDwConsolprs()) {
				
				BigDecimal cicloPadrao = dwConsol.getSegAutoCiclopadrao();
				BigDecimal cavAtivaPorProduto = BigDecimal.ONE;
				cavAtivaPorProduto =  folhaRN.getPcsPorCicloAtivas(mapCavAtivaProduto, dwFolha, dwConsolpr.getOmProduto());
				ajustarParadaEmDwConsolpapr(dwConsol, dwConsolpr, cicloPadrao, cavAtivaPorProduto);
				
				UtilsThreads.pausaNaThread(5l);
			}
		}
	}
	
	private void ajustarParadaEmDwConsolpapr(DwConsol dwConsol, DwConsolpr dwConsolpr, BigDecimal cicloPadrao, BigDecimal cavAtiva) {
		
		BigDecimal tempoParadaSp =  ObjectUtils.defaultIfNull(dwConsol.getSegAutoTempoparadaSp(), BigDecimal.ZERO);
		BigDecimal tempoParadaCp =  ObjectUtils.defaultIfNull(dwConsol.getSegAutoTempoparadaCp(), BigDecimal.ZERO);
		
		BigDecimal pcsAutoPerdaParadaCp = FormulasInjet.calcularPcsPerdaParada(tempoParadaCp, cicloPadrao, cavAtiva);
		BigDecimal pcsAutoPerdaParadaSp = FormulasInjet.calcularPcsPerdaParada(tempoParadaSp, cicloPadrao, cavAtiva);
		
		if (dwConsolpr.getPcsAutoPerdaparadaCp() == null || dwConsolpr.getPcsAutoPerdaparadaCp().compareTo(pcsAutoPerdaParadaCp) != 0)
			dwConsolpr.setPcsAutoPerdaparadaCp(pcsAutoPerdaParadaCp);
		if (dwConsolpr.getPcsAutoPerdaparadaSp() == null || dwConsolpr.getPcsAutoPerdaparadaSp().compareTo(pcsAutoPerdaParadaSp) != 0)
			dwConsolpr.setPcsAutoPerdaparadaSp(pcsAutoPerdaParadaSp);
		
	}	
	
	private void ajustarDwRt(IdwLogger log, int idLog, boolean isAbater, DwConsolid dwConsolid, DwConsolpt dwConsolpt, OmPt omPt,
			DwConsolpalog dwConsolpalog, DwPepro dwPepro, Date dtHrFRef, boolean isUltimoPeriodo, Date dtHrParaDwRt) {
		
		if (dwConsolid.getDwRt() != null) {

			if (isAbater) {

				DwConsolpalogDAO dwConsolpalogDAO = new DwConsolpalogDAO(getDaoSession());
				// Pega última parada antes da atual
				dwConsolpalog = dwConsolpalogDAO.getUltimaParadaPeriodoComFimParadaDiferenteFimPeriodo(
						dwConsolid.getOmPt(), dwConsolid.getPpCp(),
						dwConsolid.getDthrIturno(), dwConsolpalog.getDthrIparada());
			}

			DwRt dwRt = dwConsolid.getDwRt();

			if (dwConsolpalog != null) {

				if (dwConsolpalog.isAberta()) {
					dwRt.setStFuncionamento(DwRtTemplate.StFuncionamento.PARADA.getId());
				} else {
					dwRt.setStFuncionamento(DwRtTemplate.StFuncionamento.PRODUZINDO.getId());
				}
				DwTParada dwTParada = dwConsolpalog.getDwTParada();

				dwRt.setDwConsolpalog(dwConsolpalog);
				dwRt.setIsRegulagem(dwTParada.getIsRegulagem());
				dwRt.setIsParadapeso(dwTParada.getIsPesa());
				
				if (!isAbater) {
					if (dtHrParaDwRt != null) {
						dtHrParaDwRt = DataHoraRN.getMenorData(dtHrFRef, dtHrParaDwRt);
						TempoRealRN.setDthrEmDwRtBaseadoNosEventos(dwRt, dtHrParaDwRt);						
					}
				}
				
			} else {
				dwRt.setDwConsolpalog(null);
				dwRt.setIsRegulagem(false);
				dwRt.setIsParadapeso(null);
			}

			
			//180710F Trecho IF inserido. Antes apenas set false: [dwRt.setIsOffline(false);]
			//180710F Antes as máquinas que estavam corretamente sinalizadas com OFFLINE=true
			// tinham seu estado trocado para Offline=FALSE na rotina de Consolidação de Parada,
			// em casos de Parada Aberta, ainda que a Máquina não esteja mais enviando Heartbeat;
			// como a máquina não envia Heartbeat, o estado que deveria se sobrepor é o de Offline,
			// ainda que em segundo plano esteja ocorrendo uma consolidação de parada-aberta.
			//180710F dwRt.setIsOffline(false);
			//180710F IF block
			boolean isPermiteTrocarStatusOfflineTrueParaFalse = true;
			if (dwConsolpalog!=null &&
				dwRt!=null &&
				dwRt.getIsOffline()!=null &&
				dwConsolpalog.isAberta() &&
				dwRt.getIsOffline() &&
				dwRt.getDthrHeartbeat()==null
				){
				isPermiteTrocarStatusOfflineTrueParaFalse = false;
			}
			if (isPermiteTrocarStatusOfflineTrueParaFalse){
				dwRt.setIsOffline(false);
			}
			
			
			dwRt.setIsSemplanejamento(false);

			this.getDao().makePersistent(dwRt);
		}
	}

	private void ajustarParadaEmDwConsolmoEDwConsolpamo(boolean isParadaVarRitmo, DwTParada dwTParada, DwConsol dwConsol,
			BigDecimal tempoParada, BigDecimal qt,
			DwConsolmo dwConsolmo, DwConsolpamo dwConsolpamo) {
		// Parada � de variação de ritmo
		if (isParadaVarRitmo) {
			ConsolidacaoVariacaoRitmo.ajustarParadaVarRitmoDeDwConsolmoEDwConsolpamo(dwTParada.getIsPesa() != null && dwTParada.getIsPesa(),
					tempoParada, qt, dwConsolmo, dwConsolpamo);
		}

		// Pesa na eficiencia
		if (dwTParada.getIsPesa() == null || dwTParada.getIsPesa()) {
			dwConsolmo.setSegAutoTempoparadaCp(AritmeticaUtil.somar(tempoParada, dwConsolmo.getSegAutoTempoparadaCp()));
			dwConsolpamo.setSegAutoTempoparadaCp(AritmeticaUtil.somar(tempoParada, dwConsolpamo.getSegAutoTempoparadaCp()));
			dwConsolpamo.setQtAutoTempoparadaCp(AritmeticaUtil.somar(qt, dwConsolpamo.getQtAutoTempoparadaCp()));

		} else {
			dwConsolmo.setSegAutoTempoparadaSp(AritmeticaUtil.somar(tempoParada, dwConsolmo.getSegAutoTempoparadaSp()));
			dwConsolpamo.setSegAutoTempoparadaSp(AritmeticaUtil.somar(tempoParada, dwConsolpamo.getSegAutoTempoparadaSp()));
			dwConsolpamo.setQtAutoTempoparadaSp(AritmeticaUtil.somar(qt, dwConsolpamo.getQtAutoTempoparadaSp()));

		}

		// Parada padr�o
		if (dwTParada.getIsDefault() != null && dwTParada.getIsDefault()) {
			dwConsolmo.setSegAutoTempoparadaDefault(AritmeticaUtil.somar(dwConsol.getSegAutoTempoparadaDefault(), tempoParada));
			dwConsolmo.setQtAutoTempoparadaDefault(AritmeticaUtil.somar(qt, dwConsol.getQtAutoTempoparadaDefault()));
		}

		// Parada para per�odo sem op
		if (dwTParada.getIsSemOp() != null && dwTParada.getIsSemOp()) {
			dwConsolmo.setSegAutoTempoparadaSemOp(AritmeticaUtil.somar(dwConsolmo.getSegAutoTempoparadaSemOp(), tempoParada));
			dwConsolpamo.setSegAutoTempoparadaSemOp(
					AritmeticaUtil.somar(dwConsolpamo.getSegAutoTempoparadaSemOp(), tempoParada));
			dwConsolmo.setQtAutoTempoparadaSemOp(AritmeticaUtil.somar(qt, dwConsolmo.getQtAutoTempoparadaSemOp()));
			dwConsolpamo.setQtAutoTempoparadaSemOp(AritmeticaUtil.somar(qt, dwConsolpamo.getQtAutoTempoparadaSemOp()));
		}

		// Parada para per�odo sem evento
		if (dwTParada.getIsSemEvento() != null && dwTParada.getIsSemEvento()) {
			dwConsolmo.setSegAutoTempoparadaSemEvt(AritmeticaUtil.somar(dwConsolmo.getSegAutoTempoparadaSemEvt(), tempoParada));
			dwConsolpamo.setSegAutoTempoparadaSemEvt(
					AritmeticaUtil.somar(dwConsolpamo.getSegAutoTempoparadaSemEvt(), tempoParada));
			dwConsolmo.setQtAutoTempoparadaSemEvt(AritmeticaUtil.somar(qt, dwConsolmo.getQtAutoTempoparadaSemEvt()));
			dwConsolpamo.setQtAutoTempoparadaSemEvt(AritmeticaUtil.somar(qt, dwConsolpamo.getQtAutoTempoparadaSemEvt()));
		}

		// Parada para per�odo sem conex�o
		if (dwTParada.getIsSemConexao() != null && dwTParada.getIsSemConexao()) {
			dwConsolmo.setSegAutoTempoparadaSemCnx(AritmeticaUtil.somar(dwConsolmo.getSegAutoTempoparadaSemCnx(), tempoParada));
			dwConsolpamo.setSegAutoTempoparadaSemCnx(
					AritmeticaUtil.somar(dwConsolpamo.getSegAutoTempoparadaSemCnx(), tempoParada));
			dwConsolmo.setQtAutoTempoparadaSemCnx(AritmeticaUtil.somar(qt, dwConsolmo.getQtAutoTempoparadaSemCnx()));
			dwConsolpamo.setQtAutoTempoparadaSemCnx(AritmeticaUtil.somar(qt, dwConsolpamo.getQtAutoTempoparadaSemCnx()));
		}
	}

	private void ajustarParadaDeDwConsolEDwConsolpa(BigDecimal cicloPadrao, BigDecimal cavAtiva, boolean isParadaVarRitmo,
			DwTParada dwTParada, DwConsol dwConsol, DwConsolpa dwConsolpa, BigDecimal tempoParada, BigDecimal qt, BigDecimal fatorContagem,
			IdwLogger log, int idLog, int identacao
			) {

		// Parada de variação de ritmo
		if (isParadaVarRitmo) {
			log.info(idLog, identacao, "ajustarParadaVarRitmoDeDwConsolEDwConsolpa");
			ConsolidacaoVariacaoRitmo.ajustarParadaVarRitmoDeDwConsolEDwConsolpa(
					dwTParada.getIsPesa() != null && dwTParada.getIsPesa(),
					tempoParada, qt, dwConsol, dwConsolpa);
			log.info(idLog, identacao, "executou ajustarParadaVarRitmoDeDwConsolEDwConsolpa");
		}
		
		log.info(idLog, identacao, "inicio ajustarParadaDeDwConsolEDwConsolpa");

		// Parada com peso
		if (dwTParada.getIsPesa() != null && dwTParada.getIsPesa()) {
			dwConsol.setSegAutoTempoparadaCp(AritmeticaUtil.somar(tempoParada, dwConsol.getSegAutoTempoparadaCp()));
			dwConsol.setQtAutoOcoparadaCp(AritmeticaUtil.somar(qt, dwConsol.getQtAutoOcoparadaCp()));
			dwConsolpa.setSegAutoTempoparadaCp(AritmeticaUtil.somar(tempoParada, dwConsolpa.getSegAutoTempoparadaCp()));
			dwConsolpa.setQtAutoOcoparadaCp(AritmeticaUtil.somar(qt, dwConsolpa.getQtAutoOcoparadaCp()));
			dwConsolpa.setPcsAutoPerdaparadaCp(FormulasInjet.calcularPcsPerdaParada(dwConsolpa.getSegAutoTempoparadaCp(), cicloPadrao, cavAtiva));
			log.info(idLog, identacao, "Alterando dwConsol.segAutoTempoparadaCP = " + dwConsol.getSegAutoTempoparadaCp() + " no id=" + dwConsol.getIdConsol() + " dwConsolpa.segAutoTempoParadaCP=" + dwConsolpa.getSegAutoTempoparadaCp() + " idpa=" + dwConsolpa.getIdConsolpa());
		} else {
			// Parada sem peso
			dwConsol.setSegAutoTempoparadaSp(AritmeticaUtil.somar(tempoParada, dwConsol.getSegAutoTempoparadaSp()));
			dwConsol.setQtAutoOcoparadaSp(AritmeticaUtil.somar(qt, dwConsol.getQtAutoOcoparadaSp()));
			dwConsolpa.setSegAutoTempoparadaSp(AritmeticaUtil.somar(tempoParada, dwConsolpa.getSegAutoTempoparadaSp()));
			dwConsolpa.setQtAutoOcoparadaSp(AritmeticaUtil.somar(qt, dwConsolpa.getQtAutoOcoparadaSp()));
			dwConsolpa.setPcsAutoPerdaparadaSp(FormulasInjet.calcularPcsPerdaParada(dwConsolpa.getSegAutoTempoparadaSp(), cicloPadrao, cavAtiva));
		}

		// Parada de fim de semana
		if (dwTParada.getIsFds() != null && dwTParada.getIsFds()) {
			dwConsol.setSegAutoTempoparadafds(AritmeticaUtil.somar(dwConsol.getSegAutoTempoparadafds(), tempoParada));
			dwConsol.setQtAutoOcoparadafds(AritmeticaUtil.somar(qt, dwConsol.getQtAutoOcoparadafds()));
		}

		// Parada de mao de obra
		if (dwTParada.getIsMdo() != null && dwTParada.getIsMdo()) {
			dwConsol.setSegAutoTempoparadamdo(AritmeticaUtil.somar(dwConsol.getSegAutoTempoparadamdo(), tempoParada));
			dwConsol.setQtAutoOcoparadamdo(AritmeticaUtil.somar(qt, dwConsol.getQtAutoOcoparadamdo()));
		}

		// Tempo medio entre falhas
		if (dwTParada.getIsMtbf() != null && dwTParada.getIsMtbf()) {
			dwConsol.setSegAutoTempoparadamtbf(AritmeticaUtil.somar(dwConsol.getSegAutoTempoparadamtbf(), tempoParada));
			dwConsol.setQtAutoOcoparadamtbf(AritmeticaUtil.somar(qt, dwConsol.getQtAutoOcoparadamtbf()));
		}

		// Parada de avaria
		if (dwTParada.getIsPa() != null && dwTParada.getIsPa()) {
			dwConsol.setSegAutoTempoparadapa(AritmeticaUtil.somar(dwConsol.getSegAutoTempoparadapa(), tempoParada));
			dwConsol.setQtAutoOcoparadapa(AritmeticaUtil.somar(qt, dwConsol.getQtAutoOcoparadapa()));
		}

		// Parada de anomalia organizacional
		if (dwTParada.getIsPao() != null && dwTParada.getIsPao()) {
			dwConsol.setSegAutoTempoparadapao(AritmeticaUtil.somar(dwConsol.getSegAutoTempoparadapao(), tempoParada));
			dwConsol.setQtAutoOcoparadapao(AritmeticaUtil.somar(qt, dwConsol.getQtAutoOcoparadapao()));
		}

		// Parada de prepara��o
		if (dwTParada.getIsPp() != null && dwTParada.getIsPp()) {
			dwConsol.setSegAutoTempoparadapp(AritmeticaUtil.somar(dwConsol.getSegAutoTempoparadapp(), tempoParada));
			dwConsol.setQtAutoOcoparadapp(AritmeticaUtil.somar(qt, dwConsol.getQtAutoOcoparadapp()));
		}

		// Parada prevista
		if (dwTParada.getIsPrev() != null && dwTParada.getIsPrev()) {
			dwConsol.setSegAutoTempoparadaprev(AritmeticaUtil.somar(dwConsol.getSegAutoTempoparadaprev(), tempoParada));
			dwConsol.setQtAutoOcoparadaprev(AritmeticaUtil.somar(qt, dwConsol.getQtAutoOcoparadaprev()));
		}

		// Parada de troca de produ��o
		if (dwTParada.getIsPtp() != null && dwTParada.getIsPtp()) {
			dwConsol.setSegAutoTempoparadaptp(AritmeticaUtil.somar(dwConsol.getSegAutoTempoparadaptp(), tempoParada));
			dwConsol.setQtAutoOcoparadaptp(AritmeticaUtil.somar(qt, dwConsol.getQtAutoOcoparadaptp()));
		}

		// Parada de regulagem
		if (dwTParada.getIsRegulagem() != null && dwTParada.getIsRegulagem()) {
			dwConsol.setSegAutoTempoparadaregulagem(AritmeticaUtil.somar(dwConsol.getSegAutoTempoparadaregulagem(), tempoParada));
			dwConsol.setQtAutoOcoparadaregulagem(AritmeticaUtil.somar(qt, dwConsol.getQtAutoOcoparadaregulagem()));
		}

		// Parada sem carteira de pedido
		if (dwTParada.getIsScp() != null && dwTParada.getIsScp()) {
			dwConsol.setSegAutoTempoparadascp(AritmeticaUtil.somar(dwConsol.getSegAutoTempoparadascp(), tempoParada));
			dwConsol.setQtAutoOcoparadascp(AritmeticaUtil.somar(qt, dwConsol.getQtAutoOcoparadascp()));
		}

		// Parada padr�o
		if (dwTParada.getIsDefault() != null && dwTParada.getIsDefault()) {
			dwConsol.setSegAutoTempoparadaDefault(AritmeticaUtil.somar(dwConsol.getSegAutoTempoparadaDefault(), tempoParada));
			dwConsol.setQtAutoTempoparadaDefault(AritmeticaUtil.somar(qt, dwConsol.getQtAutoTempoparadaDefault()));
		}

		// Parada para per�odo sem op
		if (dwTParada.getIsSemOp() != null && dwTParada.getIsSemOp()) {
			dwConsol.setSegAutoTempoparadaSemOp(AritmeticaUtil.somar(dwConsol.getSegAutoTempoparadaSemOp(), tempoParada));
			dwConsol.setQtAutoTempoparadaSemOp(AritmeticaUtil.somar(qt, dwConsol.getQtAutoTempoparadaSemOp()));
		}

		// Parada para per�odo sem evento
		if (dwTParada.getIsSemEvento() != null && dwTParada.getIsSemEvento()) {
			dwConsol.setSegAutoTempoparadaSemEvt(AritmeticaUtil.somar(dwConsol.getSegAutoTempoparadaSemEvt(), tempoParada));
			dwConsol.setQtAutoTempoparadaSemEvt(AritmeticaUtil.somar(qt, dwConsol.getQtAutoTempoparadaSemEvt()));
		}

		// Parada para per�odo sem conex�o
		if (dwTParada.getIsSemConexao() != null && dwTParada.getIsSemConexao()) {
			dwConsol.setSegAutoTempoparadaSemCnx(AritmeticaUtil.somar(dwConsol.getSegAutoTempoparadaSemCnx(), tempoParada));
			dwConsol.setQtAutoTempoparadaSemCnx(AritmeticaUtil.somar(qt, dwConsol.getQtAutoTempoparadaSemCnx()));
		}

		// Tempo ativo (tempo dispon�vel)
		dwConsol.setSegAutoTempoativo(FormulasInjet.calcularTempoAtivo(
				dwConsol.getSegAutoCicloprodutivo(),
				dwConsol.getSegAutoTempoparadaCp(),
				dwConsol.getSegAutoCicloimprodutivo(),
				dwConsol.getSegAutoTempoparadaCpVr(),
				dwConsol.getSegAutoTempoparadaSpVr()));

		// Tempo trabalhado
		dwConsol.setSegAutoTempotrabalhado(
				FormulasInjet.calcularTempoTrabalhado(dwConsol.getSegAutoTempoativo(), dwConsol.getSegAutoTempoparadaCp()));

		// Produ��o prevista: (Horas Dispon�veis / Ciclo Padr�o) * Cavidades Ativas
		dwConsol.setPcsAutoProducaoprevista(
				FormulasInjet.calcularProducaoPrevista(
						dwConsol.getSegAutoTempoativo(), 
						cicloPadrao, 
						cavAtiva,
						fatorContagem,
						dwConsol.getDwConsolid().getOmPt().getIndOee()));

		// Pe�as perdidas por parada
		dwConsol.setPcsAutoPerdaparadaCp(
				FormulasInjet.calcularPcsPerdaParada(dwConsol.getSegAutoTempoparadaCp(), cicloPadrao, cavAtiva));
		dwConsol.setPcsAutoPerdaparadaSp(
				FormulasInjet.calcularPcsPerdaParada(dwConsol.getSegAutoTempoparadaSp(), cicloPadrao, cavAtiva));
		dwConsol.setPcsManuPerdaparadaSp(
				FormulasInjet.calcularPcsPerdaParada(dwConsol.getSegManuTempoparadaSp(), cicloPadrao, cavAtiva));

		// TODO milton - criar o campo abaixo no modelo
		// dwConsol.setPcsManuPerdaparadaCp(FormulasInjet.calcularPcsPerdaParada(dwConsol.getSegManuTempoparadaCp() , cicloPadrao,
		// cavAtiva));
		
		
		log.info(idLog, identacao, "executou ajustarParadaDeDwConsolEDwConsolpa");
	}

	/**
	 * Busca DwConsolpalog
	 *
	 * @param idPt
	 * @param dthrIparada
	 *            se for null retorna a ultima parada da Maquina
	 * @return
	 */
	public DwConsolpalog obtemDwConsolpalog(Long idPt, Date dthrIparada) {
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("SELECT dwConsolpalog ");
		q.append("FROM DwConsolpalog dwConsolpalog ");
		q.append("WHERE dwConsolpalog.omPt.idPt = :idPt ");
		if (dthrIparada != null) {
			q.append("AND dwConsolpalog.dthrIparada = :dthrIparada");
		}
		q.append("order by dwConsolpalog.idConsolpalog desc");

		q.defineParametro("idPt", idPt);
		if (dthrIparada != null) {
			q.defineParametroTimestamp("dthrIparada", dthrIparada);
		}
		q.setMaxResults(1);
		DwConsolpalog dwConsolpalog = null;
		dwConsolpalog = (DwConsolpalog) q.query().uniqueResult();
		q = null;
		return (dwConsolpalog);
	}

	/*
	 * public DwConsol getDwConsolComParadaEmAberto(OmPt ompt, List<DwConsolid> consolids) { Date dthrITurnoOuHora = null; Date
	 * dthrFTurnoOuHora = null;
	 * 
	 * // Sera null qdo for por OP if (ompt == null || consolids.size() == 0) return null;
	 * 
	 * DwConsolpalog ultimaParada = getUltimaParadaFromDwConsolpalog(ompt); DwConsol consolAberto = null; if (ultimaParada != null &&
	 * ultimaParada.isAberta()) { // Veriica se o motivo da parada em aberto existe em DwConsolpa. Se existir atualizar com novos valores,
	 * se n�o incluir (em // memoria) um dwconsolpa for (DwConsolid id : consolids) { if
	 * (id.getTpId().equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO)) { if (dthrITurnoOuHora == null || (dthrITurnoOuHora
	 * != null && dthrITurnoOuHora.after(id.getDthrIturno()))) { dthrITurnoOuHora = id.getDthrIturno(); } if (dthrFTurnoOuHora == null ||
	 * (dthrFTurnoOuHora != null && dthrFTurnoOuHora.before(id.getDthrFturno()))) dthrFTurnoOuHora = id.getDthrFturno(); } else if
	 * (id.getTpId().equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_HORA)) { if (dthrITurnoOuHora == null || (dthrITurnoOuHora
	 * != null && dthrITurnoOuHora.after(id.getDthrIhora()))) { dthrITurnoOuHora = id.getDthrIhora(); } if (dthrFTurnoOuHora == null ||
	 * (dthrFTurnoOuHora != null && dthrFTurnoOuHora.before(id.getDthrFhora()))) dthrFTurnoOuHora = id.getDthrFhora(); } } Date dthrAtual =
	 * DataHoraRN.getDataHoraAtual(); Date inicio = ultimaParada.getDthrIparada(); if (dthrITurnoOuHora != null &&
	 * dthrITurnoOuHora.after(ultimaParada.getDthrIparada())) inicio = dthrITurnoOuHora;
	 * 
	 * Date fim = dthrAtual; if (dthrFTurnoOuHora != null && dthrFTurnoOuHora.before(dthrAtual)) fim = dthrFTurnoOuHora;
	 * 
	 * if (fim.before(inicio)) fim = inicio; // Avaliar se existe alguma interseccao entre o turno e a parada em aberto. Se nao descartar
	 * parada em aberto // As datas abaixo estarao nulas qdo for acumulado if (dthrITurnoOuHora == null) { dthrITurnoOuHora = inicio; } if
	 * (dthrFTurnoOuHora == null) dthrFTurnoOuHora = fim;
	 * 
	 * if (DataHoraRN.isIntersecao(inicio, fim, dthrITurnoOuHora, dthrFTurnoOuHora)) { if (consolAberto == null) { consolAberto = new
	 * DwConsol(); getDao().evict(consolAberto); consolAberto.setIdConsol(0l); consolAberto.setSegAutoTempoparadaCp(BigDecimal.ZERO); }
	 * 
	 * Integer tempoParadaEmAberto = DataHoraRN.getQuantidadeSegundosNoPeriodo(inicio, fim); // totalParadas = totalParadas.add(new
	 * BigDecimal(tempoParadaEmAberto)); if (ultimaParada.getDwTParada().getIsPesa() != null && ultimaParada.getDwTParada().getIsPesa() ==
	 * true) { if (consolAberto.getSegAutoTempoparadaCp() != null) consolAberto
	 * .setSegAutoTempoparadaCp(consolAberto.getSegAutoTempoparadaCp().add(new BigDecimal(tempoParadaEmAberto))); else
	 * consolAberto.setSegAutoTempoparadaCp(new BigDecimal(tempoParadaEmAberto)); } else { if (consolAberto.getSegAutoTempoparadaSp() !=
	 * null) consolAberto .setSegAutoTempoparadaSp(consolAberto.getSegAutoTempoparadaSp().add(new BigDecimal(tempoParadaEmAberto))); else
	 * consolAberto.setSegAutoTempoparadaSp(new BigDecimal(tempoParadaEmAberto)); } } } return consolAberto;
	 * 
	 * }
	 */

	// public void consolidarTempoParada(boolean isAbater, boolean isTrataQtd, OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems,
	// PpCp ppCp, DwFolha dwFolha,
	// OmCfg omcfg, IdwLogger log, int idLog, int identacao, DwPepro dwPepro, DwConsolpalog dwConsolpalog,
	// Date dtHrIParadaRef, Date DtHrFimParadaRef)
	// throws SemPlanejamentoException, SemCalendarioException, SemSGBDException, SemCicloPadraoException {
	//
	//
	// ConsolidacaoFimParadaNoTurno cturno = new ConsolidacaoFimParadaNoTurno(getDao());
	// ConsolidacaoFimParadaNaHora chora = new ConsolidacaoFimParadaNaHora(getDao());
	// ConsolidacaoFimParadaAcumulado cacum = new ConsolidacaoFimParadaAcumulado(getDao());
	//
	// cturno.consolidarTempoParadaTurno(isAbater, isTrataQtd, omPt, dwConsolpt, dwCalsems, ppCp, dwFolha, dwConsolpalog,
	// dtHrIParadaRef, DtHrFimParadaRef, omcfg, log, idLog, identacao, dwPepro);
	// chora.consolidarTempoParadaHora(isAbater, isTrataQtd, omPt, dwConsolpt, dwCalsems, ppCp, dwFolha, dwConsolpalog,
	// dtHrIParadaRef, DtHrFimParadaRef,
	// omcfg, log, dwPepro);
	// cacum.consolidarTempoParadaAcumulado(isAbater, isTrataQtd, omPt, dwConsolpt, dwCalsems, ppCp, dwFolha, dwConsolpalog,
	// dtHrIParadaRef, DtHrFimParadaRef, omcfg, log, dwPepro);
	//
	//
	//
	// }

	
	/* A parada deve ser abatida na seguinte situacao
	 * Quando a parada anterior tiver o mesmo ID da nova parada
	 * E Quando o NOVO FIM for anterior ao FIM da parada anterior (ou da parada em aberto)
	 */
	public boolean isAbaterTempoParada(DwConsolpt dwConsolpt, DwConsolpalog dwConsolpalog, DwTParada dwTParadaNova, Date novaDtHrFim) throws SemPlanejamentoException, SemCalendarioException, SemSGBDException, SemCicloPadraoException {

		Date dtHrFRef = (dwConsolpalog.isAberta() ? dwConsolpalog.getDthrFparadaAb() : dwConsolpalog.getDthrFparada());

		if (dtHrFRef == null) {
			dtHrFRef = dwConsolpalog.getDthrIparada();
		}

		boolean isMesmaParada = dwConsolpalog.getDwTParada().getIdTparada().equals(dwTParadaNova.getIdTparada());
		boolean isNovoFimMenorFimAnterior = DataHoraRN.before(novaDtHrFim, dtHrFRef);

		return (!isMesmaParada) || isNovoFimMenorFimAnterior;

	}

}
