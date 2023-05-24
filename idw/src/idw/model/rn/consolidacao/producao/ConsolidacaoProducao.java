package idw.model.rn.consolidacao.producao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.Validate;

import idw.model.excessoes.CicloJaContabilizadoException;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.ReprocessarMsEvtException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPacoteOuFatorException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmo;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwConsolprmo;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwRt;
import idw.model.pojos.DwRtcic;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.pojos.template.DwRtTemplate;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.CpRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.NumeroSerieRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.TempoRealRN;
import idw.model.rn.consolidacao.parada.ConsolidacaoFimParada;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.util.IdwLogger;
import idw.util.Util;
import injetws.model.excessoes.SemSGBDException;
import ms.model.rn.EventoRN;

public abstract class ConsolidacaoProducao extends ConsolidaRN {

	/**
	 * Força a finalização de parada aberta no tratamento de um novo ciclo. Quando a máquina pode ter tempo de parada de ciclo, pode ser que
	 * a parada inicie dentro de um ciclo e termine em outro. Nos outros tipo de máquina, se existir uma parada aberta, possivelmente é uma
	 * do tratamento dos dados da coleta, então para evitar problemas maiores a parada é fechada.
	 * 
	 * @param dtHrInicioCiclo
	 * @param dthrFimCiclo
	 * @param omPt
	 * @param dwConsolpt
	 * @param dwCalsems
	 * @param ppCp
	 * @param dwFolha
	 * @param omcfg
	 * @param log
	 * @param idLog
	 * @param identacao
	 * @throws ReprocessarMsEvtException
	 */
	protected void forcarFinalizacaoParadaAbertaEmNovoCiclo(
			Date dtHrInicioCiclo,
			Date dthrFimCiclo,
			OmPt omPt,
			DwConsolpt dwConsolpt,
			List<DwCalsem> dwCalsems,
			PpCp ppCp,
			DwFolha dwFolha,
			OmCfg omcfg,
			IdwLogger log,
			int idLog,
			int identacao,
			DwPepro dwPepro,
			MsEvt msevt) throws ReprocessarMsEvtException {

		Date dtHrFinalizacao = null;

		/*
		 * Se o posto estiver configurado para parada fechar ciclo, signiifca que esse metodo foi chamado por FimCiclo ou InicioCiclo Se
		 * tiver sido chamdo pelo InicioCIclo a variavel dthrInicioCiclo terá a hora no novo ciclo que se inicia, entao faz sentido fechar a
		 * parada com esse inicio de ciclo.
		 */
		if (omPt.getOmTppt().isMaquinaCiclica() && omPt.getIsParadaFechaciclo() != null && omPt.getIsParadaFechaciclo()) {
			dtHrFinalizacao = dtHrInicioCiclo;
		} else {
			// Alessadnre Em 23-4-15 acrescentei o if abaixo pois dthrFimCiclo esta null nesse caso assumir dthrInicioCiclo
			if (dthrFimCiclo != null)
				dtHrFinalizacao = dthrFimCiclo;
			else
				dtHrFinalizacao = dtHrInicioCiclo;
		}

		if (msevt == null || msevt.getOrigem() == null || msevt.getOrigem().trim().equals("FIMPACOTE") == false) {

			DwConsolpalog dwConsolpalog = getUltimaParadaFromDwConsolpalog(omPt);
			if (dwConsolpalog != null && dwConsolpalog.isAberta()) {
				ConsolidacaoFimParada consolidacaoFimParada = new ConsolidacaoFimParada(this.getDao());

				String motivoFinalizacao = "Encontrada parada aberta ao iniciar um ciclo. Parada será finalizada com início de ciclo. "
						+ "dthriparada=" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dwConsolpalog.getDthrIparada())
						+ "dthriciclo=" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtHrInicioCiclo);

				consolidacaoFimParada.forcarFinalizacaoParadaAberta(dtHrFinalizacao, omPt, dwConsolpt, dwConsolpalog, omcfg, log, idLog,
						identacao, motivoFinalizacao);

			}
		}

	}

	/**
	 * Inclui registro de ocorrencia de ciclo
	 * 
	 * @param dwRt
	 * @param dtHrIniCic
	 * @param dtHrFimCic
	 * @param tempoCiclo
	 */
	protected DwRtcic consolidarDwRtCic(DwRt dwRt,
			DwFolha dwfolha, Date dtHrIniCic, Date dtHrFimCic, BigDecimal tempoCiclo,
			boolean isRegulagem,
			IdwLogger log,
			int idLog,
			int identacao) {

		DwRtcic dwRtcic = new DwRtcic();
		dwRtcic.setDwRt(dwRt);
		dwRtcic.setDthrIciclo(dtHrIniCic);
		dwRtcic.setDthrFciclo(dtHrFimCic);
		dwRtcic.setSegDuracao(tempoCiclo);
		dwRtcic.setIsRegulagem(isRegulagem);
		dwRtcic.setPpCp(dwRt.getPpCp());
		dwRtcic.setDwFolha(dwfolha);

		log.info(idLog, identacao, "vou executar makePersistent dwRtcic");
		DwRtcic retorno = this.getDao().makePersistent(dwRtcic);
		log.info(idLog, identacao, "executou makePersistent dwRtcic");

		return retorno;
	}

	/**
	 * Consolida ciclo para DwConsolid (hora, turno, ano, mês ou acumulado)
	 * 
	 * @paradam log
	 * @param omPt
	 * @param dwConsolpt
	 * @param ppCp
	 * @param dwConsolid
	 * @param omcfg
	 * @param dtHrIniPeriodo
	 * @param dtHrFimPeriodo
	 * @param dtHrIniCic
	 * @param dtHrFimCic
	 * @param isProdutivo
	 * @param isRegulagem
	 * @param tempoCiclo
	 * @throws SemSGBDException
	 * @throws SemCalendarioException
	 */
	protected void consolidarFimCicloDwConsolid(IdwLogger log, int idLog, int identacao, OmPt omPt, DwConsolpt dwConsolpt, PpCp ppCp,
			DwFolha dwFolha, DwConsolid dwConsolid, OmCfg omcfg,
			Date dtHrIniPeriodo, Date dtHrFimPeriodo, Date dtHrIniCic, Date dtHrFimCic,
			boolean isProdutivo, boolean isRegulagem, BigDecimal tempoCiclo,
			MsEvt msevt, List<DwConsolpalog> paradasNoCiclo, Map<String, BigDecimal> mapCavAtivaProduto,
			Map<String, BigDecimal> mapCavTotalProduto)
			throws SemCicloPadraoException, SemCalendarioException, SemSGBDException, CicloJaContabilizadoException {

		Validate.notNull(omPt, "Posto de trabalho está nulo");
		Validate.notNull(ppCp, "ppCp está nulo");
		Validate.notNull(dtHrIniCic, "Data hora de início de ciclo está nulo");
		Validate.notNull(dtHrFimCic, "Data hora de fim de ciclo está nulo");
		Validate.notNull(dtHrIniPeriodo, "Data hora de início de ciclo para consolidação está nulo");
		Validate.notNull(dtHrFimPeriodo, "Data hora de fim de ciclo para consolidação está nulo");
		Validate.notNull(omPt.getIdPt(), "idPt está nulo");

		Validate.isTrue(DataHoraRN.compareTo(dtHrIniPeriodo, dtHrFimPeriodo) < 1,
				"Início do ciclo é maior que o fim (referencia para consolidaçao). Inicio " +
						DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dtHrIniPeriodo) +
						" fim " + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dtHrFimPeriodo) + " maquina " + omPt.getCd());

		Validate.isTrue(DataHoraRN.compareTo(dtHrIniCic, dtHrFimCic) < 1, "Início do ciclo é maior que o fim. Inicio " +
				DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dtHrIniCic) +
				" fim " + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dtHrFimCic) + " maquina " + omPt.getCd());

		Date dtHrIRef = (DataHoraRN.before(dtHrIniCic, dtHrIniPeriodo) ? dtHrIniPeriodo : dtHrIniCic);
		Date dtHrFRef = (DataHoraRN.before(dtHrFimCic, dtHrFimPeriodo) ? dtHrFimCic : dtHrFimPeriodo);

		Long qtdCic = new Long(1); // O Ciclo é sempre 1 pois o metodo trata apenas um ciclo por vez

		FolhaRN folhaRN = new FolhaRN(getDao());

		Integer pacoteCiclo = null;
		try {
			pacoteCiclo = folhaRN.getPacoteCicloFromDwFolha(dwFolha, omPt);
		} catch (SemPacoteOuFatorException e) {
			pacoteCiclo = null;
		}

		BigDecimal fatorContagem = null;
		try {
			fatorContagem = folhaRN.getFatorContagemFromDwFolha(dwFolha, omPt);
		} catch (SemPacoteOuFatorException e) {
			fatorContagem = BigDecimal.ONE;
		}

		// Se qtde do evento vier definida entao utiliza-la ao inves da producao por ciclo
		final boolean isQtdProduzidaNoMsEvt =
				msevt.getQtde() != null &&
						msevt.getQtde().intValue() > 0 &&
						((omPt.getIsSolicitaqtde() != null && omPt.getIsSolicitaqtde() && omPt.getOmTppt().isMaquinaCiclica() == false) ||
								(omPt.getOmTppt().isMaquinaCiclica() && pacoteCiclo != null && pacoteCiclo >= 1));

		// isPacoteCompleto será true quando o pacote de ciclo estiver definido da folha e se todas as batidas foram efetuadas
		boolean isPacoteCompleto = omPt.getOmTppt().isMaquinaCiclica() && pacoteCiclo != null && pacoteCiclo >= 1
				&& msevt.getQtdeCiclos() != null && pacoteCiclo == msevt.getQtdeCiclos().intValue();

		// So podemos ter pacote incompleto para maquinas ciclicas. As nao ciclicas o pacote sempre sera completo
		if (omPt.getOmTppt().isMaquinaCiclica() == false)
			isPacoteCompleto = true;

		DwConsol dwConsol = dwConsolid.getDwConsol();

		BigDecimal cavAtivaDwConsol = getCavAtivasAjustaDwConsolSenaoTiver(dwConsol);
		BigDecimal cavTotalDwConsol = getCavTotaisAjustaDwConsolSenaoTiver(dwConsol);

		BigDecimal cavAtiva = cavAtivaDwConsol;
		BigDecimal cavTotal = cavTotalDwConsol;

		if (isQtdProduzidaNoMsEvt) {
			cavAtiva = msevt.getQtde();
			cavTotal = msevt.getQtde();
		}

		BigDecimal cicloPadrao = this.getCicloPadrao(omPt, dwFolha);

		BigDecimal tempoCicloRef = BigDecimal.ZERO;

		boolean isCicloNoPeriodoConsolidado = DataHoraRN.equals(dtHrFimCic, dtHrFRef);

		// Ciclo está quebrado em mais de um período ?
		if (!DataHoraRN.equals(dtHrIRef, dtHrIniCic) || !DataHoraRN.equals(dtHrFRef, dtHrFimCic)) {
			// TODO realizar um calculo mais adequado para esta situação, guardando o tempo proporcional de cada período
			tempoCicloRef = DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodoComScale5(dtHrIRef, dtHrFRef);
		} else {
			tempoCicloRef = tempoCiclo;
		}

		CpRN cprn = new CpRN(getDao());
		PpCp ppcp = dwConsolid.getPpCp();
		if (ppcp != null) {
			if (dwConsolid.getPpCp().getPpCpprodutos() == null || dwConsolid.getPpCp().getPpCpprodutos().size() <= 0) {
				ppcp = cprn.pesquisarPpCpeProdutoByIdCp(dwConsolid.getPpCp());
			}
		}

		// Verificar se o CB esta preenchido e se existe o NS. Se existir, entao marcar o flag abaixo para nao realizar filtros do CB
		boolean isNSerieValido = false;
		if (msevt.getCb() != null && msevt.getCb().equals("") == false) {
			NumeroSerieRN rn = new NumeroSerieRN(getDao());
			DwNserie dwnserie;
			try {
				dwnserie = rn.getDwNserieCb(msevt.getCb());
			} catch (NumeroSerieIrregularException e) {
				dwnserie = null;
			}
			if (dwnserie != null
					&& ((omPt.getIsSolicitaqtde() != null && omPt.getIsSolicitaqtde() == false) || omPt.getIsSolicitaqtde() == null)) {
				isNSerieValido = true;
			} else {
				log.info(idLog, identacao, "NS " + msevt.getCb()
						+ " nao valido pois nao encontrou em dwnserie. Logo producaobruta nao sera acrescida em dwconsolpr");
			}

			/*
			 * O filtro abaixo verifica se ja existe um apontamento de producao para o CB na mesma OP e no mesmo PT. Se existir, entao o
			 * msevt deve ser descartado, pois a producao é contada apenas uma vez para essa situacao. Para se saber que ja contaou
			 * producao, pesqusiar se existe um envento consolidado para o cb, nrop e pt. Entretanto qdo o posto pedir qtde essa regra nao
			 * eh valida
			 */
			if (omPt.getIsSolicitaqtde() != null && omPt.getIsSolicitaqtde() == false) {
				EventoRN ern = new EventoRN();
				ern.setDao(getDao());
				MsEvt msevtDoCb = ern.pesquisarMsEvtByCBePtNropFinalCiclo(msevt.getCb(), omPt.getCdPt(), msevt.getNrop());

				if (msevtDoCb != null && msevtDoCb.getIdEvt().equals(msevt.getIdEvt()) == false) {
					throw new CicloJaContabilizadoException(
							"IdEvtBASE = " + msevtDoCb.getIdEvt() + " <> idEvt=" + msevt.getIdEvt() + " pt=" + omPt.getCdPt() + " op="
									+ msevt.getNrop() + " dthrEvt=" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(msevt.getDthrEvento()),
							dwFolha.getIdFolha(), omPt.getIdPt(), "idEvtAnt=" + msevt.getIdEvt() + " ptAnt=" + omPt.getCdPt() + " opAnt="
									+ msevt.getNrop() + " dthrEvtAnt=" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(msevt.getDthrEvento()));
				}
			}
		}

		// Avaliar se eh necessario incluir o produto em ppCpProduto
		// Soh eh nececssario qdo em msevt veio um CB com o produto e a qtde produzida.
		// Coloquei aqui um teste pra inserir em ppCpProduto um produto que nao exista la mas que veio no CB do msevt
		// A inclusao do produto na OP eh necessario qdo se passa uma etiqueta de produto que nao faz parte da OP
		// como electrolux chile que o produto volta do reprocesso
		if (isNSerieValido == false && msevt.getCb() != null && msevt.getCb().equals("") == false) {

			boolean isCbExisteProduto = false;
			String nrDoc = "";
			BigDecimal producaoPlanejada = null;
			for (PpCpproduto ppcpproduto : ppcp.getPpCpprodutos()) {
				log.info(idLog, identacao, "Comparando " + ppcpproduto.getOmProduto().getCdProduto() + " = " + msevt.getCb());
				if (msevt.getCb().contains(ppcpproduto.getOmProduto().getCdProduto())) {
					isCbExisteProduto = true;
					log.info(idLog, identacao,
							"Achou " + ppcpproduto.getOmProduto().getCdProduto() + " = " + msevt.getCb() + " verdadeiro");
				}
				nrDoc = ppcpproduto.getNrDoc();
				producaoPlanejada = ppcpproduto.getPcsProducaoplanejada();
			}
			if (isCbExisteProduto == false) {
				ProdutoRN rn = new ProdutoRN(getDao());
				OmProduto omProduto = null;
				String cdProduto = "";
				try {
					cdProduto = Util.extraiPorMascara(msevt.getCb(), omcfg.getMascaracdprodutoCB());
					omProduto = rn.getOmProduto(cdProduto);
					log.info(idLog, identacao, "Produto encontrado " + msevt.getCb());
				} catch (RegistroDesconhecidoException e) {
					omProduto = null;
					// Alessandre em 14-08-15 o evento de fim do ciclo sera descartado pois o CB nao existe em omproduto
					// Alessandre em 08-03-17 nao vou mais descartar o ciclo pois se o CB lido nao for do produto da op
					// mesmo assim vou contar a produção
					// Validate.notNull(omProduto, "produto nao existe " + cdProduto + " com mascara " + omcfg.getMascaracdprodutoCB());
				}

				if (omProduto != null) {
					PpCpproduto novo = new PpCpproduto();
					novo.setIdCpproduto(null);
					novo.setNrDoc(nrDoc);
					novo.setOmProduto(omProduto);
					novo.setPcsProducaoplanejada(producaoPlanejada);
					novo.setPpCp(ppcp);

					getDao().makePersistent(novo);

					// Incluir tb em dwConsolpr
					DwConsolpr novopr = new DwConsolpr();
					novopr.setDwConsol(dwConsol);
					novopr.setGAutoPesoBruto(BigDecimal.ZERO);
					novopr.setGAutoPesoLiquido(BigDecimal.ZERO);
					novopr.setIdConsolpr(null);
					novopr.setOmProduto(omProduto);
					novopr.setPcsAutoProducaobruta(null);
					novopr.setPcsAutoProducaorefugada(null);
					novopr.setPcsAutoProducaoliquida(null);
					getDao().makePersistent(novopr);
					dwConsol.getDwConsolprs().add(novopr);
				}
			}
		}

		// Testar se existe dwConsolPr, se não existir incluir um novo
		if (dwConsol != null && (dwConsol.getDwConsolprs() == null || dwConsol.getDwConsolprs().size() <= 0)) {
			// Inserir dwconsolpr
			dwConsol.setDwConsolprs(new HashSet<DwConsolpr>());
			if (ppcp != null) {
				for (PpCpproduto ppcpproduto : ppcp.getPpCpprodutos()) {
					log.info(idLog, identacao, "Inserindo dwconsolpr para idConsol " + dwConsol.getIdConsol() + " ppcp.produto "
							+ ppcpproduto.getOmProduto().getCdProduto());
					DwConsolpr dwconsolpr = new DwConsolpr();
					dwconsolpr.setDwConsol(dwConsol);
					dwconsolpr.setOmProduto(ppcpproduto.getOmProduto());

					dwConsol.getDwConsolprs().add(dwconsolpr);
				}
			}
		}
		// Se mesmo assim continuar sem dwconsolpr, entao usar o produto da folha
		if (dwConsol != null && (dwConsol.getDwConsolprs() == null || dwConsol.getDwConsolprs().size() <= 0)) {
			if (dwConsolid.getDwFolha().getDwFolhaiacs() != null && dwConsolid.getDwFolha().getDwFolhaiacs().size() > 0) {
				DwFolhaiac folhaiac = dwConsolid.getDwFolha().getDwFolhaiacs().iterator().next();
				if (folhaiac.getOmProduto() != null) {
					log.info(idLog, identacao, "Inserindo dwconsolpr para idConsol " + dwConsol.getIdConsol() + " folhaiac.produto "
							+ folhaiac.getOmProduto().getCdProduto());
					DwConsolpr dwconsolpr = new DwConsolpr();
					dwconsolpr.setDwConsol(dwConsol);
					dwconsolpr.setOmProduto(folhaiac.getOmProduto());
					dwConsol.getDwConsolprs().add(dwconsolpr);
				}
			}
		}

		// Guarda a diferença em relação ao início e fim do ciclo (dtHrIRef e dtHrFRef)
		BigDecimal tempoCicloCTA = BigDecimal.ZERO;
		// Guarda a diferença em relação ao início e fim da consolidação
		BigDecimal tempoCTA = BigDecimal.ZERO;

		if (TRATAR_CORRECAO_TEMPO_ATIVO) {
			// Guarda tempo correto do ciclo
			tempoCicloCTA = DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodo(dtHrIRef, dtHrFRef);

			// Calcular a diferença para o tempo de ciclo CTA
			tempoCicloCTA = tempoCicloCTA.subtract(tempoCicloRef);

			// Ajusta tempo do ciclo
			tempoCicloRef = tempoCicloRef.add(tempoCicloCTA);

			if (TRATAR_CORRECAO_TEMPO_ATIVO_CICLO_COMPARANDO_ULT_DTHRF_PT) {
				// Se fim já estiver preenchido, indica que teve consolidação de evento que impacta no tempo ativo no período
				if (dwConsolpt.getDthrFim() != null) {
					// Faz ajuste no tempo em relação ao que já foi consolidado
					BigDecimal tempoIntersecao = DataHoraRN.getTempoIntersecaoEmSegundosComMilisegundos(dwConsolid.getDthrIconsol(),
							dwConsolpt.getDthrFim(), dtHrIRef, dtHrFRef);
					if (tempoIntersecao.compareTo(BigDecimal.ZERO) != 0) {
						tempoCTA = tempoIntersecao;
						tempoCicloRef = tempoCicloRef.subtract(tempoCTA);
					}
				}
			}

			dwConsol.setSegAutoCta(AritmeticaUtil.somar(dwConsol.getSegAutoCta(), tempoCTA));

			if (isProdutivo) {
				dwConsol.setSegAutoCicloprodutivoCta(AritmeticaUtil.somar(dwConsol.getSegAutoCicloprodutivoCta(), tempoCicloCTA));
			} else {
				dwConsol.setSegAutoCicloimprodutivoCta(AritmeticaUtil.somar(dwConsol.getSegAutoCicloimprodutivoCta(), tempoCicloCTA));
			}

		}

		// Atualiza início e fim
		dwConsolid.setDtHr(dtHrIRef, dtHrFRef);

		// Atualiza os últimos dados consolidação do pt, id do dwconsolid e inicio e fim de consolidação do registro
		dwConsolpt.setDwConsolid(dwConsolid);

		// Ciclo padrão
		dwConsol.setSegAutoCiclopadrao(cicloPadrao);

		// Ciclo é de regulagem
		if (isRegulagem) {

			if (isCicloNoPeriodoConsolidado) {
				// Quantidade de ciclos de regulagem
				dwConsol.setQtAutoCicloregulagem(AritmeticaUtil.somar(dwConsol.getQtAutoCicloregulagem(), qtdCic));
			}
		}

		BigDecimal pcsProducao = BigDecimal.ZERO;
		if (isCicloNoPeriodoConsolidado) {
			pcsProducao = getQtdProduzida(
					cavAtivaDwConsol,
					isQtdProduzidaNoMsEvt,
					isPacoteCompleto,
					msevt.getQtde(),
					pacoteCiclo,
					msevt.getQtdeCiclos(),
					fatorContagem,
					msevt,
					omPt);
		}
		// Se for regualgem entrar tambem para poder contabilizar em pcsautoproducaobruta
		if (isProdutivo || isRegulagem) {
			contabilizacaoCicloProdutivo(
					paradasNoCiclo,
					dtHrIRef,
					dtHrFRef,
					qtdCic,
					dwConsol,
					cavAtivaDwConsol,
					cavTotalDwConsol,
					cavAtiva,
					cavTotal,
					tempoCicloRef,
					isCicloNoPeriodoConsolidado,
					log,
					idLog,
					identacao,
					pcsProducao,
					omPt,
					msevt);
		} else {
			contabilizacaoCicloImprodutivo(qtdCic, dwConsol, tempoCicloRef);
			log.info(idLog, identacao, "ciclo improdutivo para idConsol=" + dwConsol.getIdConsol());
		}

		// Atualiza os restantes dos campos em DwConsol
		atualizacaoDeDwConsol(log, idLog, identacao, omPt, dwConsolid, dwConsol, cavAtivaDwConsol, cicloPadrao, fatorContagem);

		// Atualizar DwConsolpr
		atualizacaoDeDwConsolpr(
				dwFolha,
				dwConsol,
				isProdutivo,
				isRegulagem,
				folhaRN,
				isQtdProduzidaNoMsEvt,
				pcsProducao,
				isCicloNoPeriodoConsolidado,
				msevt.getCb(),
				isNSerieValido,
				log,
				idLog,
				identacao,
				mapCavAtivaProduto,
				mapCavTotalProduto,
				isPacoteCompleto,
				pcsProducao,
				pacoteCiclo,
				msevt.getQtdeCiclos(),
				fatorContagem,
				omPt,
				msevt);

		this.getDao().makePersistent(dwConsol);

		// Atualizacao da consolidacao dos operadores
		atualizacaoDeDwConsolmo(isProdutivo, isRegulagem, qtdCic, dwConsol, cavAtivaDwConsol, cicloPadrao, tempoCicloRef,
				isCicloNoPeriodoConsolidado, tempoCicloCTA,
				tempoCTA, fatorContagem, pcsProducao, folhaRN, dwFolha, isQtdProduzidaNoMsEvt, msevt.getCb(), isNSerieValido, log, idLog,
				identacao, mapCavAtivaProduto);

		// Ele deve entrar no if abaixo somente quando for turno
		if (DwConsolidTemplate.TpId.TURNO.equals(dwConsolid)) {

			DwRt dwRt = dwConsolid.getDwRt();
			if (dwRt != null) {

				dwRt.setIsRegulagem(isRegulagem);

				// Verificação do gargalo teorico e dinamico
				verificacaoGargaloTeoricoDinamico(dwConsol, dwRt);

				TempoRealRN.setDthrEmDwRtBaseadoNosEventos(dwRt, dtHrFRef);

				if (isCicloNoPeriodoConsolidado) {
					consolidacaoDwRTePpCp(
							log,
							dwConsolpt,
							ppCp,
							dwFolha,
							dwConsolid,
							dtHrIniCic,
							dtHrFimCic,
							isRegulagem,
							tempoCiclo,
							idLog,
							identacao,
							cicloPadrao,
							dwRt,
							msevt,
							pcsProducao,
							isQtdProduzidaNoMsEvt,
							msevt.getCb(),
							isNSerieValido,
							folhaRN, mapCavAtivaProduto,
							msevt.getQtdeCiclos(),
							fatorContagem,
							pacoteCiclo
							); // producao por ciclo considerando pacote de ciclo

					log.info(idLog, identacao, "executou consolidacaoDwRTePpCp");
				}
			} else {
				// Se nao houver dwRt dentro de dwConsolid possivelmente é pq o consolid é referente a um periodo de regulagem
				// logo devemos identificar qual o dwRt correto do periodo e inserir o ciclo de regulagem que está ocorrendo
				// Se esse ciclo da regualgem nao for incluido teremos um efeito que eh o posto vira o turno em regulagem e ciclando
				// e os ciclos de regualgem nao aparecem no grafico dos ultimos ciclos na ficha da maquina,
				TempoRealRN trn = new TempoRealRN(getDao());
				dwRt = trn.getDwRt(dwConsolid.getDtReferencia(), dwConsolid.getDwTurno().getIdTurno(), omPt.getIdPt(), ppcp, dwFolha);

				/*
				 * Alessandre em 27-08-18 outra situacao recorrente é a excessao do tipo abaixo: java.lang.IllegalStateException: DwRt não
				 * encontrado. dtReferencia=27/08/2018 00:00:00;cdTurno=1;idPt=1566;idCp=201026;cdPt=QP2L09;idFolha=9555;cdCp=F24L6 -
				 * 24W_L09_T00;cdFolha=F24L6 - 24W_L09_T00-SMD ela ocorre pq não existe um dwconsolid com referencia ao dwrt que tenha um
				 * idfolha como referencia. Nesse caso pegaremos o dwrt do turno sem considerar a folha
				 */
				if (dwRt == null) {
					dwRt = trn.getDwRt(dwConsolid.getDtReferencia(), dwConsolid.getDwTurno().getIdTurno(), omPt.getIdPt(), ppcp, null);
				}
				// Removi pois estava causando perda de eventos
				// if (dwRt == null) {
				// throw new IllegalStateException("DwRt não encontrado. " +
				// "dtReferencia=" + DataHoraRN.dateToStringDDMMYYYYHHMMSS(dwConsolid.getDtReferencia()) +
				// ";cdTurno=" + dwConsolid.getDwTurno().getCdTurno() +
				// ";idPt=" + omPt.getIdPt() +
				// ";idCp=" + ppcp.getIdCp() +
				// ";cdPt=" + omPt.getCdPt() +
				// ";idFolha=" + dwFolha.getIdFolha() +
				// ";cdCp=" + ppcp.getCdCp() +
				// ";cdFolha=" + dwFolha.getCdFolha());
				// }
				// Atualiza tambem o tempo do ultimo ciclo para ser mostrado na ficha da maquina a eficiencia do ultimo ciclo
				if (dwRt != null) {
					DwRtcic dwRtcic =
							consolidarDwRtCic(dwRt, dwFolha, dtHrIniCic, dtHrFimCic, tempoCiclo, isRegulagem, log, idLog, identacao);
					dwConsolpt.setDwRtcic(dwRtcic);

					// Tempo do último ciclo
					if (tempoCiclo.compareTo(BigDecimal.ZERO) > 0)
						dwRt.setSegUltimociclo(tempoCiclo);
				}

			}

		}

		log.info(idLog, identacao, "finalizou ConsolidacaoProducao");
	}

	/** Esse metodo tem como objetivo atualizar dwrt e ppcp com os nvos dados de consolidacao
	 * 
	 * @param log
	 * @param dwConsolpt
	 * @param ppCp
	 * @param dwFolha
	 * @param dwConsolid
	 * @param dtHrIniCic
	 * @param dtHrFimCic
	 * @param isRegulagem
	 * @param tempoCiclo
	 * @param idLog
	 * @param cicloPadrao
	 * @param dwRt
	 * @param cb 
	 * @param isNSerieValido 
	 * @param folhaRN 
	 * @param mapCavAtivaProduto 
	 */
	private void consolidacaoDwRTePpCp(
			IdwLogger log,
			DwConsolpt dwConsolpt, 
			PpCp ppCp, 
			DwFolha dwFolha,
			DwConsolid dwConsolid, 
			Date dtHrIniCic, 
			Date dtHrFimCic,
			boolean isRegulagem, 
			BigDecimal tempoCiclo,
			int idLog, 
			int identacao,
			BigDecimal cicloPadrao, 
			DwRt dwRt,
			MsEvt msevt,	
			BigDecimal pcsProducao, 
			boolean isQtdProduzidaNoMsEvt,			
			String cb, 
			boolean isNSerieValido, 
			FolhaRN folhaRN, 
			Map<String, BigDecimal> mapCavAtivaProduto,
			BigDecimal batidas,
			BigDecimal fatorContagem,
			Integer pacoteCiclo) {
		
		ConsolidacaoInicioCiclo consolidacaoInicioCiclo = new ConsolidacaoInicioCiclo();
		consolidacaoInicioCiclo.setDao(getDao());
		
		// Atualiza informações sobre o início do ciclo
		consolidacaoInicioCiclo.consolidarInicioCicloDwRt(dwRt,dtHrIniCic, cicloPadrao, log, idLog, identacao);

		//TODO milton calcular is_vidautilmolde

		// Tempo do último ciclo
		if (tempoCiclo.compareTo(BigDecimal.ZERO) > 0)
			dwRt.setSegUltimociclo(tempoCiclo);

		//pcs_producaoliquida_op
		if(dwRt.getPcsProducaoliquidaOp() == null){
			dwRt.setPcsProducaoliquidaOp(BigDecimal.ZERO);
		}
		
		// Atualizar a producao da OP
		BigDecimal producaoOp = BigDecimal.ZERO;

		for (PpCpproduto ppcpproduto : ppCp.getPpCpprodutos() ) {
			
			OmProduto omProduto = ppcpproduto.getOmProduto();
			
			if (!isProdutoValidoParaContagemQuandoUsaCB(omProduto, cb, isNSerieValido, log, idLog, identacao)) {
				continue;
			}
			
			BigDecimal cavAtivaDoProduto =  folhaRN.getPcsPorCicloAtivas(mapCavAtivaProduto, dwFolha, omProduto);
			
			if (batidas == null || batidas.compareTo(BigDecimal.ZERO) == 0 )
				batidas = BigDecimal.ONE;
			if (fatorContagem == null || fatorContagem.compareTo(BigDecimal.ZERO) == 0)
				fatorContagem = BigDecimal.ONE;
			if (pacoteCiclo == null || pacoteCiclo == 0)
				pacoteCiclo = 1;

			BigDecimal producaoDoProduto = cavAtivaDoProduto
					.multiply(batidas)
					.multiply(fatorContagem)
					.divide(new BigDecimal(pacoteCiclo), RoundingMode.DOWN).setScale(2, RoundingMode.DOWN);


			if (ppcpproduto.getPcsProducaobruta() != null) {					
				ppcpproduto.setPcsProducaobruta(ppcpproduto.getPcsProducaobruta().add(producaoDoProduto));					
			} else {
				ppcpproduto.setPcsProducaobruta(producaoDoProduto);
			}
			
			producaoOp = producaoOp.add(ppcpproduto.getPcsProducaobruta());
		}

		dwRt.setPcsProducaoliquidaOp(producaoOp);

		
		// Se modificado o status para produzindo se o campo origem for diferente de FIMPACOTE, pois um ciclo
		// com essa origem foi finalizado por uma parada de REGULAGEM
		if (msevt.getOrigem() != null && msevt.getOrigem().trim().equals("FIMPACOTE") == false) {
			// Indica que está em produção
			dwRt.setStFuncionamento(DwRtTemplate.StFuncionamento.PRODUZINDO.getId());
		}

		log.info(idLog, identacao, "makePersistent em dwrt.id=" + dwRt.getIdRt());
		this.getDao().makePersistent(dwRt);
		log.info(idLog, identacao, "makePersistent executado em dwrt.id=" + dwRt.getIdRt());

		// Inclui evento de ciclo
		if(dwConsolid != null && dwConsolid.getDwRt() != null){
			log.info(idLog, identacao, "vou executar consolidarDwRtCic");
			DwRtcic dwRtcic = consolidarDwRtCic(dwConsolid.getDwRt(), dwConsolid.getDwFolha(), dtHrIniCic, dtHrFimCic, tempoCiclo, isRegulagem, log, idLog,  identacao);
			log.info(idLog, identacao, "executei consolidarDwRtCic");
			dwConsolpt.setDwRtcic(dwRtcic);
		}
	}

	private BigDecimal getQtdProduzida(
			BigDecimal cavAtiva,
			boolean isQtdProduzidaNoMsEvt,
			boolean isPacoteCompleta,
			BigDecimal producaoDoMsEvt,
			Integer pacoteCiclo,
			BigDecimal batidas,
			BigDecimal fatorContagem,
			MsEvt msevt,
			OmPt ompt) {
		
		
		/* Alessandre em 02-05-22 os calculos da producaoDoProduto estao errados pq em msevt.qtde já tem tudo calculos (pacote,fator, etc) para as maquinas ciclicas
		 * 
		 */

		/*
		 * Alessandre em 17-08-17 ao inves de calcular o indice de participacao, que em alguma situacoes poderá contar a produção do produto
		 * de forma errada, O mais acertado eh usar a formula ProducaoNoCiclo = (cavAtivas * batidas * fator) / pacoteCiclo) BigDecimal
		 * indiceParticipacao = cavAtivaPorProduto.divide(cavTotal, 2, BigDecimal.ROUND_HALF_UP);
		 */
		BigDecimal producaoDoProduto = cavAtiva;
		/*
		 * A producao do produto deve considerar o indiceParticipacao apenas quando for pacote de ciclo e o pacote for parcial
		 */
		if (isQtdProduzidaNoMsEvt) {
			
			if (isPacoteCompleta) {
				producaoDoProduto = producaoDoMsEvt; // tirei a multiplicacao pelo fator de contagem pois na teoriaca ja esta multiplicado .multiply(fatorContagem);
				
			} else {
				/*
				 * Novo calculo mais adequado obtido do algoritmo feito no injet ProducaoNoCiclo = (cavAtivas * batidas * fator) /
				 * pacoteCiclo). Exemplo: cavAtiva = 10, batidas = 6, fatorContagem =1 e pacote = 10 producaoDoProduto = 10 * 6 * 1 / 10 = 6
				 */
				if (batidas == null || batidas.compareTo(BigDecimal.ZERO) == 0)
					batidas = BigDecimal.ONE;
				
				if (fatorContagem == null || fatorContagem.compareTo(BigDecimal.ZERO) == 0 )
					fatorContagem = BigDecimal.ONE;
				
				if (pacoteCiclo == null || pacoteCiclo == 0)
					pacoteCiclo = 1;

				producaoDoProduto = cavAtiva
						.multiply(batidas)
						.multiply(fatorContagem)
						.divide(new BigDecimal(pacoteCiclo), RoundingMode.DOWN).setScale(2, RoundingMode.DOWN);
			}
			
			
		} else if (ompt.getIsCiclocomrefugo() != null && ompt.getIsCiclocomrefugo()) {
			// Se a producao nao vier em msevt.qtde, avaliar se a producaoLiquida ou refugada vieram. Se sim, entao devemos zerar a producao
			// de retorno desse metodo
			if (msevt.getProducaoliquida() != null && msevt.getProducaoliquida().intValue() > 0)
				producaoDoProduto = BigDecimal.ZERO;
			if (msevt.getProducaorefugada() != null && msevt.getProducaorefugada().intValue() > 0)
				producaoDoProduto = BigDecimal.ZERO;
		}
		return producaoDoProduto;
	}

	private void atualizacaoDeDwConsolmo(boolean isProdutivo, boolean isRegulagem, Long qtdCic, DwConsol dwConsol,
			BigDecimal cavAtivaDwConsol, BigDecimal cicloPadrao, BigDecimal tempoCicloRef, boolean isCicloNoPeriodoConsolidado,
			BigDecimal tempoCicloCTA, BigDecimal tempoCTA, BigDecimal fatorContagem, BigDecimal pcsProducao,
			FolhaRN folhaRN, DwFolha dwFolha, boolean isQtdProduzidaNoMsEvt, String cb, boolean isNSerieValido, IdwLogger log, int idLog,
			int identacao, Map<String, BigDecimal> mapCavAtivaProduto) {
		List<DwConsolmo> dwConsolmoComLoginAberto = this.getDwConsolmoComLoginAberto(dwConsol.getIdConsol());

		// TODO milton - rever trecho para consolidar apenas o tempo em que o operador estava logado dentro do DwConsolid
		// Atualizar DwConsolmo (DwConsol)
		for (DwConsolmo dwConsolmo : dwConsolmoComLoginAberto) {

			if (TRATAR_CORRECAO_TEMPO_ATIVO) {
				dwConsolmo.setSegAutoCta(AritmeticaUtil.somar(dwConsolmo.getSegAutoCta(), tempoCTA));
				if (isProdutivo) {
					dwConsolmo.setSegAutoCicloprodutivoCta(AritmeticaUtil.somar(dwConsolmo.getSegAutoCicloprodutivoCta(), tempoCicloCTA));
				} else {
					dwConsolmo
							.setSegAutoCicloimprodutivoCta(AritmeticaUtil.somar(dwConsolmo.getSegAutoCicloimprodutivoCta(), tempoCicloCTA));
				}

			}

			if (isRegulagem) {

				if (isCicloNoPeriodoConsolidado) {
					// Tempos de ciclo de regulagem
					dwConsolmo.setQtAutoCicloregulagem(AritmeticaUtil.somar(dwConsolmo.getQtAutoCicloregulagem(), qtdCic));
				}

				// Quantidade de ciclos de regulagem
				dwConsolmo.setSegAutoCicloregulagem(AritmeticaUtil.somar(dwConsolmo.getSegAutoCicloregulagem(), tempoCicloRef));

			} else {

				if (isProdutivo) {
					// TODO calcular tempo baseado no periodo que está logado

					// Tempo do ciclo produtivo
					dwConsolmo.setSegAutoCicloprodutivo(AritmeticaUtil.somar(dwConsolmo.getSegAutoCicloprodutivo(), tempoCicloRef));

					if (isCicloNoPeriodoConsolidado) {
						// Quantidade de ciclo produtivo
						dwConsolmo.setQtAutoCicloprodutivo(AritmeticaUtil.somar(dwConsolmo.getQtAutoCicloprodutivo(), qtdCic));

						// Producao Bruta
						dwConsolmo.setPcsAutoProducaobruta(AritmeticaUtil.somar(dwConsolmo.getPcsAutoProducaobruta(), pcsProducao));
					}

				} else {
					// Tempo do ciclo improdutivo
					dwConsolmo.setSegAutoCicloimprodutivo(AritmeticaUtil.somar(dwConsolmo.getSegAutoCicloimprodutivo(), tempoCicloRef));

					if (isCicloNoPeriodoConsolidado) {
						// Quantidade de ciclo improdutivo
						dwConsolmo.setQtAutoCicloimprodutivo(AritmeticaUtil.somar(dwConsolmo.getQtAutoCicloimprodutivo(), qtdCic));
					}

				}

				// Tempo disponível: Tempo dos ciclos normais + Tempos dos ciclos finalizados por parada + Tempo das paradas com peso
				BigDecimal tempoDisponivel =
						FormulasInjet.calcularTempoAtivo(
								dwConsolmo.getSegAutoCicloprodutivo(), dwConsolmo.getSegAutoTempoparadaCp(),
								dwConsolmo.getSegAutoCicloimprodutivo(),
								dwConsolmo.getSegAutoTempoparadaCpVr(), dwConsolmo.getSegAutoTempoparadaSpVr());

				// Produção prevista: (Horas Disponíveis / Ciclo Padrão) * Cavidades Ativas
				dwConsolmo.setPcsAutoProducaoprevista(FormulasInjet.calcularProducaoPrevista(
						tempoDisponivel,
						cicloPadrao,
						cavAtivaDwConsol,
						fatorContagem,
						dwConsol.getDwConsolid().getOmPt().getIndOee()));

				// Tempo trabalhado: Horas disponíveis - Horas das paradas com peso
				dwConsolmo.setSegAutoTempotrabalhado(
						FormulasInjet.calcularTempoTrabalhado(tempoDisponivel, dwConsolmo.getSegAutoTempoparadaCp()));

			}

			// FIXME DwConsolprmo não está sendo gerada. Por isso não está passando no loop abaixo.
			// Atualizar DwConsolprmo (DwConsolmo)
			for (DwConsolprmo dwConsolprmo : dwConsolmo.getDwConsolprmos()) {

				OmProduto omProduto = dwConsolprmo.getDwConsolpr().getOmProduto();

				if (!isProdutoValidoParaContagemQuandoUsaCB(
						omProduto, cb, isNSerieValido, log, idLog, identacao)) {
					continue;
				}

				if ((isProdutivo || isRegulagem) && isCicloNoPeriodoConsolidado) {

					BigDecimal cavAtivaPorProduto = folhaRN.getPcsPorCicloAtivas(mapCavAtivaProduto, dwFolha, omProduto);

					BigDecimal producaoDoProduto = (isQtdProduzidaNoMsEvt ? pcsProducao : cavAtivaPorProduto);
					dwConsolprmo.setPcsAutoProducaobruta(
							AritmeticaUtil.somar(dwConsolprmo.getPcsAutoProducaobruta(), producaoDoProduto.longValue()));

					this.getDao().makePersistent(dwConsolprmo);
				}

			}

			this.getDao().makePersistent(dwConsolmo);

		}
	}

	private void atualizacaoDeDwConsol(IdwLogger log, int idLog, int identacao, OmPt omPt, DwConsolid dwConsolid, DwConsol dwConsol,
			BigDecimal cavAtivaDwConsol, BigDecimal cicloPadrao, BigDecimal fatorContagem) {
		// Ciclo Médio - Tempo dos ciclos normais / Qtde de ciclos normais
		dwConsol.setSegAutoCiclomedio(
				FormulasInjet.calcularCicloMedio(dwConsol.getSegAutoCicloprodutivo(), dwConsol.getQtAutoCicloprodutivo()));

		// Tempo ativo (tempo disponível)
		dwConsol.setSegAutoTempoativo(
				FormulasInjet.calcularTempoAtivo(dwConsol.getSegAutoCicloprodutivo(), dwConsol.getSegAutoTempoparadaCp(),
						dwConsol.getSegAutoCicloimprodutivo(), dwConsol.getSegAutoTempoparadaCpVr(), dwConsol.getSegAutoTempoparadaSpVr()));

		// Tempo trabalhado: Horas disponíveis - Horas das paradas com peso + tempo parada com peso variação ritmo + tempo parada sem peso
		// com variação ritmo
		dwConsol.setSegAutoTempotrabalhado(
				FormulasInjet.calcularTempoTrabalhado(dwConsol.getSegAutoTempoativo(), dwConsol.getSegAutoTempoparadaCp()));

		// Tempo de refugo
		dwConsol.setSegAutoTemporefugadas(FormulasInjet.calcularTempoRefugoComBaseNoCiclo(
				dwConsol.getPcsProducaoBruta(),
				dwConsol.getPcsProducaoRefugada(),
				dwConsol.getSegAutoCicloprodutivo()));

		// Horas boas: tempo de ciclo produtivo - Refugo em segundos
		dwConsol.setSegAutoBoas(FormulasInjet.calcularTempoBoas(dwConsol.getSegAutoCicloprodutivo(), dwConsol.getSegAutoTemporefugadas(),
				dwConsol.getSegAutoTempoparadaCpVr(), dwConsol.getSegAutoTempoparadaSpVr()));

		// Ritmo: [ (Tempo dos ciclos normais / Ciclo padrão) - Qtde de ciclos normais ] * Ciclo padrão
		dwConsol.setSegAutoRitmo(FormulasInjet.calcularRitmo(dwConsol.getSegAutoCicloprodutivo(), dwConsol.getQtAutoCicloprodutivo(),
				cicloPadrao, dwConsol.getSegAutoTempoparadaCpVr(), dwConsol.getSegAutoTempoparadaSpVr()));

		// Cavidades inativas em segundos - (Tempo dos ciclos normais / Cavidades totais) * (Cavidades totais - Cavidades ativas)
		dwConsol.setSegAutoPerdacav(
				FormulasInjet.calcularCavidadesInativaSeg(
						dwConsol.getPcsAutoCavTotal(),
						dwConsol.getPcsAutoCavAtivas(),
						dwConsol.getSegAutoCicloprodutivo()));

		// Tempo produtivo: Horas boas - Cavidades inativas em segundos - Ritmo (se resultado for negativo, considerar ZERO)
		dwConsol.setSegAutoTempoprodutivo(FormulasInjet.calcularTempoprodutivas(dwConsol.getSegAutoBoas(), dwConsol.getSegAutoPerdacav(),
				dwConsol.getSegAutoRitmo()));

		// Produção prevista: (Horas Disponíveis / Ciclo Padrão) * Cavidades Ativas
		BigDecimal pPrevista = FormulasInjet.calcularProducaoPrevista(
				dwConsol.getSegAutoTempoativo(),
				cicloPadrao,
				cavAtivaDwConsol,
				fatorContagem,
				omPt.getIndOee());

		dwConsol.setPcsAutoProducaoprevista(pPrevista);

		// Perda ciclo por peças, é o mesmo que ritmo por peças:
		// [ (Tempo dos ciclos normais / Ciclo padrão) - Qtde de ciclos normais ] * ciclo padrão
		// ou
		// ritmo por segundos / ciclo padrão * cavidades ativas
		dwConsol.setPcsAutoPerdaciclo(FormulasInjet.calcularPcsPerdaciclo(dwConsol.getSegAutoRitmo(), cicloPadrao, cavAtivaDwConsol));

		// Checa tempo total depois da consolidação
		checarTempoTotal(this.getClass().getSimpleName(), log, idLog, identacao, dwConsolid, omPt, dwConsol);
	}

	private void contabilizacaoCicloImprodutivo(Long qtdCic, DwConsol dwConsol, BigDecimal tempoCicloRef) {
		// Tempo ciclo improdutivo
		dwConsol.setSegAutoCicloimprodutivo(AritmeticaUtil.somar(dwConsol.getSegAutoCicloimprodutivo(), tempoCicloRef));

		// Quantidade de ciclo improdutivo
		dwConsol.setQtAutoCicloimprodutivo(AritmeticaUtil.somar(dwConsol.getQtAutoCicloimprodutivo(), qtdCic));
	}

	private void contabilizacaoCicloProdutivo(
			List<DwConsolpalog> paradasNoCiclo,
			Date dtHrIRef,
			Date dtHrFRef,
			Long qtdCic,
			DwConsol dwConsol,
			BigDecimal cavAtivaDwConsol,
			BigDecimal cavTotalDwConsol,
			BigDecimal cavAtiva,
			BigDecimal cavTotal,
			BigDecimal tempoCicloRef,
			boolean isCicloNoPeriodoConsolidado,
			IdwLogger log,
			int idLog,
			int identacao,
			BigDecimal pcsProducao,
			OmPt ompt,
			MsEvt msevt) {
		BigDecimal tempoCicloSemParada = BigDecimal.ZERO;

		BigDecimal tempoParadasNoCiclo = getTempoParadaNoCiclo(paradasNoCiclo, dtHrIRef, dtHrFRef);

		tempoCicloSemParada = tempoCicloRef.subtract(tempoParadasNoCiclo);

		// Somar apenas se o tempo do ciclo sem a parada for positivo
		if (tempoCicloSemParada.compareTo(BigDecimal.ZERO) > 0) {
			dwConsol.setSegAutoCicloprodutivo(AritmeticaUtil.somar(dwConsol.getSegAutoCicloprodutivo(), tempoCicloSemParada));
		}

		dwConsol.setQtAutoCavativas(cavAtivaDwConsol);
		dwConsol.setQtAutoCavtotal(cavTotalDwConsol);

		if (isCicloNoPeriodoConsolidado) {
			// Quantidade de ciclo produtivo
			dwConsol.setQtAutoCicloprodutivo(AritmeticaUtil.somar(dwConsol.getQtAutoCicloprodutivo(), qtdCic));

			// pcs_cav_total
			dwConsol.setPcsAutoCavTotal(AritmeticaUtil.somar(dwConsol.getPcsAutoCavTotal(), cavTotal));

			// pcs_cav_ativas
			dwConsol.setPcsAutoCavAtivas(AritmeticaUtil.somar(dwConsol.getPcsAutoCavAtivas(), cavAtiva));

			// Peças da perda por cavidade
			dwConsol.setPcsAutoPerdacavidades(AritmeticaUtil.somar(dwConsol.getPcsAutoPerdacavidades(),
					FormulasInjet.calcularPerdaCavidade(cavTotalDwConsol, cavAtivaDwConsol)));

			// Peças da produção bruta
			log.info(idLog, identacao, "atualizando pcsAutoProducaobruta de " + dwConsol.getPcsAutoProducaobruta() + " para "
					+ AritmeticaUtil.somar(dwConsol.getPcsAutoProducaobruta(), pcsProducao) + " em idConsol=" + dwConsol.getIdConsol());
			dwConsol.setPcsAutoProducaobruta(AritmeticaUtil.somar(dwConsol.getPcsAutoProducaobruta(), pcsProducao));

			/*
			 * Para a coleta da Sony, se o Pt estiver configurado para contabilizar refugo junto com o ciclo entao devemos contabilizar
			 * tambem a producao liquida se a mesma for fornecida
			 */
			if (ompt.getIsCiclocomrefugo() != null && ompt.getIsCiclocomrefugo()) {
				if (msevt.getProducaoliquida() != null) {
					dwConsol.setPcsAutoProducaoliquida(
							AritmeticaUtil.somar(dwConsol.getPcsAutoProducaoliquida(), msevt.getProducaoliquida()));
				}
				if (msevt.getProducaorefugada() != null) {
					dwConsol.setPcsAutoProducaorefugada(
							AritmeticaUtil.somar(dwConsol.getPcsAutoProducaorefugada(), msevt.getProducaorefugada()));
				}
			}
		} else {
			log.info(idLog, identacao, "NAO atualizou pcsAutoProducaobruta de " + dwConsol.getPcsAutoProducaobruta() + " para "
					+ AritmeticaUtil.somar(dwConsol.getPcsAutoProducaobruta(), pcsProducao) + " em idConsol=" + dwConsol.getIdConsol());
			dwConsol.setQtAutoCicloimprodutivo(AritmeticaUtil.somar(dwConsol.getQtAutoCicloimprodutivo(), qtdCic));
		}
	}

	private void verificacaoGargaloTeoricoDinamico(DwConsol dwConsol, DwRt dwRt) {
		// mudar aqui a verfiicacao de gargalo dinamico e teorico considerando o ompt.omgt como grupo dos pts
		// 1o pegar os dwconsol para o turno e dtreferencia dos outros pts que compoem o ompt.omgt
		// 2o varrer todos eles e descobrir os gargalos
		List<DwConsolid> listaConsolDosOutrosPts = null; // pesquisarDwConsolidsDosPtsDoGtExcluindoPT(omPt);

		// comentado para evitar que seja feita a análise de gargalo
		// ainda está muito lento, compromentendo a consolidação
		// List<DwConsolid> listaConsolDosOutrosPts = null;

		DwRt dwrtGargaloTeorico = null;
		DwRt dwrtGargaloDinamico = null;
		DwConsol dwconsolGargaloTeorico = null;
		DwConsol dwconsolGargaloDinamico = null;
		// Verificar se existe gargalo teorico ou dinamico somente se o ompt.omgt tiver mais de um registro
		if (listaConsolDosOutrosPts != null && listaConsolDosOutrosPts.size() > 1) {
			for (DwConsolid outrosIds : listaConsolDosOutrosPts) {
				DwConsol outroConsol = null;
				for (DwConsol outroConsolAux : outrosIds.getDwConsols()) {
					outroConsol = outroConsolAux;
					break;
				}
				if (outroConsol != null && outroConsol.getSegAutoCiclomedio() != null && outroConsol.getSegAutoCiclopadrao() != null) {
					// Primeiro o dwrt deixa de ser qualquer gargalo
					DwRt dwRtAux = outrosIds.getDwRt();
					dwRtAux.setIsGargalodinamico(false);
					dwRtAux.setIsGargaloteorico(false);

					// Somente analisar o gargalo se o ciclo medio for maior que o ciclo padrao
					if (outroConsol.getSegAutoCiclomedio().compareTo(outroConsol.getSegAutoCiclopadrao()) <= 0)
						continue;

					// Verifica quem eh o gargalo teorico e quem é o dinamico
					// Gargalo dinamico
					if (dwrtGargaloDinamico == null) {
						dwrtGargaloDinamico = dwRtAux;
						dwconsolGargaloDinamico = outroConsol;
						continue;
					}
					if (dwrtGargaloTeorico == null) {
						dwrtGargaloTeorico = dwRtAux;
						dwconsolGargaloTeorico = outroConsol;
					}
					if (outroConsol.getSegAutoCiclomedio().compareTo(dwconsolGargaloDinamico.getSegAutoCiclomedio()) > 1) {
						dwrtGargaloDinamico = dwRtAux;
						dwconsolGargaloDinamico = outroConsol;
					} else if (outroConsol.getSegAutoCiclomedio().compareTo(dwconsolGargaloTeorico.getSegAutoCiclomedio()) > 1) {
						dwrtGargaloTeorico = dwRtAux;
						dwconsolGargaloTeorico = outroConsol;
					}
				}
			}
		}

		// Agora comparar com o dwConsol que esta sendo consolidado
		try {
			if (dwConsol.getSegAutoCiclomedio().compareTo(dwconsolGargaloDinamico.getSegAutoCiclomedio()) > 1) {
				dwrtGargaloDinamico = dwRt;
			} else if (dwConsol.getSegAutoCiclomedio().compareTo(dwconsolGargaloTeorico.getSegAutoCiclomedio()) > 1) {
				dwrtGargaloTeorico = dwRt;
			}
		} catch (NullPointerException e) {
			dwrtGargaloDinamico = null;
			dwrtGargaloTeorico = null;
		}

		// Se foi definido algum gargalo setar abaixo
		if (dwrtGargaloDinamico != null) {
			dwrtGargaloDinamico.setIsGargalodinamico(true);
			getDao().makePersistent(dwrtGargaloDinamico);
		}
		if (dwrtGargaloTeorico != null) {
			dwrtGargaloTeorico.setIsGargaloteorico(true);
			getDao().makePersistent(dwrtGargaloTeorico);
		}
	}

	private void atualizacaoDeDwConsolpr(
			DwFolha dwFolha, 
			DwConsol dwConsol, 
			boolean isProdutivo, 
			boolean isRegulagem,
			FolhaRN folhaRN,
			final boolean isQtdProduzidaNoMsEvt, 
			BigDecimal pcsProducao, 
			boolean isCicloNoPeriodoConsolidado, 
			String cb,
			boolean isNSerieValido, 
			IdwLogger log, 
			int idLog, 
			int identacao,
			Map<String, BigDecimal> mapCavAtivaProduto, 
			Map<String, BigDecimal> mapCavTotalProduto,
			boolean isPacoteCompleto,
			BigDecimal producaoDoMsEvt, 
			Integer pacoteCiclo, 
			BigDecimal batidas, 
			BigDecimal fatorContagem,
			OmPt ompt,
			MsEvt msevt) {
		
		// Soma as producoes de cada produto, depois compara com as producoes em dw_consol. Se houver divergencia atualiza dw_consol. Tem alguma situacao que 
		// acontece uma divergencia entre dw_consol e dw_consolpr. 
		BigDecimal pcsAutoProducaobrutaDosProdutos = BigDecimal.ZERO;
		
		for(DwConsolpr dwConsolpr: dwConsol.getDwConsolprs()){
			
			BigDecimal cavAtivaPorProduto = null;
			BigDecimal cavTotalPorProduto = null;
			
			OmProduto omProduto = dwConsolpr.getOmProduto();
			
			if (isProdutoValidoParaContagemQuandoUsaCB(omProduto, cb, isNSerieValido, log, idLog, identacao) == false) {
				log.info(idLog, identacao, "descartando contagem producao para o produto");
				continue;
			}
			
			// Só efetua procedimento se quantidade de ciclos for informada
			log.info(idLog, identacao, "isProdutivo = " + isProdutivo + " isCicloNoPeriodoConsolidado=" + isCicloNoPeriodoConsolidado + " para idCOnsolpr=" + dwConsolpr.getIdConsolpr());
			
			if ((isProdutivo || isRegulagem) && isCicloNoPeriodoConsolidado) {
				
				cavAtivaPorProduto =  folhaRN.getPcsPorCicloAtivas(mapCavAtivaProduto, dwFolha, dwConsolpr.getOmProduto());				
				cavTotalPorProduto =  folhaRN.getPcsPorCicloTodas(mapCavTotalProduto, dwFolha, dwConsolpr.getOmProduto());
				
				//BigDecimal producaoDoProduto = (isQtdProduzidaNoMsEvt ? pcsProducao : cavAtivaPorProduto);
				BigDecimal producaoDoProduto = getQtdProduzida(
						cavAtivaPorProduto, 
						isQtdProduzidaNoMsEvt, 
						isPacoteCompleto, 
						producaoDoMsEvt, 
						pacoteCiclo, 
						batidas, 
						fatorContagem,
						msevt,
						ompt);
						

				// Peças da produção bruta
				dwConsolpr.setPcsAutoProducaobruta(AritmeticaUtil.somar(dwConsolpr.getPcsAutoProducaobruta(), producaoDoProduto));

				/* Avaliar para a sony se a producao liquida e refugada estarão vindo na coleta
				 * 
				 */
				if (ompt.getIsCiclocomrefugo() != null && ompt.getIsCiclocomrefugo()) {
					if (msevt.getProducaoliquida() != null)
						dwConsolpr.setPcsAutoProducaoliquida(AritmeticaUtil.somar(dwConsolpr.getPcsAutoProducaoliquida(), msevt.getProducaoliquida()));
					if (msevt.getProducaorefugada() != null)
						dwConsolpr.setPcsAutoProducaorefugada(AritmeticaUtil.somar(dwConsolpr.getPcsAutoProducaorefugada(), msevt.getProducaorefugada()));
				}
				
				// Peso bruto do produto
				if (dwConsolpr.getOmProduto().getGPesoBruto() != null) {
					dwConsolpr.setGAutoPesoBruto(AritmeticaUtil.somar(dwConsolpr.getGAutoPesoBruto(), dwConsolpr.getOmProduto().getGPesoBruto().multiply(producaoDoProduto)));
				}
				
				// Peso líquido do produto
				if (dwConsolpr.getOmProduto().getGPesoLiquido() != null) {
					dwConsolpr.setGAutoPesoLiquido(AritmeticaUtil.somar(dwConsolpr.getGAutoPesoLiquido(), dwConsolpr.getOmProduto().getGPesoLiquido().multiply(producaoDoProduto)));
				}
				
				/* Calcular perda por cavidade
				 * 
				 */
				dwConsolpr.setPcsAutoPerdacavidades(AritmeticaUtil.somar(dwConsolpr.getPcsAutoPerdacavidades(), FormulasInjet.calcularPerdaCavidade(cavTotalPorProduto, cavAtivaPorProduto)));

				this.getDao().makePersistent(dwConsolpr);

			}
			pcsAutoProducaobrutaDosProdutos = AritmeticaUtil.somar(pcsAutoProducaobrutaDosProdutos, dwConsolpr.getPcsAutoProducaobruta());
		}
		if (
				
				pcsAutoProducaobrutaDosProdutos != null &&
				pcsAutoProducaobrutaDosProdutos.compareTo(BigDecimal.ZERO) != 0 &&
				dwConsol.getPcsAutoProducaobruta() != null && 
				dwConsol.getPcsAutoProducaobruta().compareTo(pcsAutoProducaobrutaDosProdutos) != 0) {
			log.info(idLog, identacao, "<> PB no consol.pcsAutoProducaobruta = " + dwConsol.getPcsAutoProducaobruta() + " <> " + pcsAutoProducaobrutaDosProdutos + " para o idConsol=" + dwConsol.getIdConsol());
			dwConsol.setPcsAutoProducaobruta(pcsAutoProducaobrutaDosProdutos);
			this.getDao().makePersistent(dwConsol);
		}

	}

	private boolean isProdutoValidoParaContagemQuandoUsaCB(OmProduto omProduto, String cb, boolean isNSerieValido, IdwLogger log, int idLog,
			int identacao) {

		boolean isContabilizaParaProdutoQuandoUsaCB = true;

		// Contabilizar a producao apenas para o produto do evento se CB veio preenchido
		if (isNSerieValido == false && cb != null && cb.equals("") == false) {
			if (cb.contains(omProduto.getCdProduto()) == false) {
				log.info(idLog, identacao, cb + " nao contem o produto " + omProduto.getCdProduto());
				isContabilizaParaProdutoQuandoUsaCB = false;
			}
		}
		return isContabilizaParaProdutoQuandoUsaCB;

	}

	private BigDecimal getTempoParadaNoCiclo(List<DwConsolpalog> dwConsolpalogs, Date dtHrIRef, Date dtHrFRef) {
		BigDecimal tempoParadasNoCiclo = BigDecimal.ZERO;
		if (dwConsolpalogs == null)
			return tempoParadasNoCiclo;

		for (DwConsolpalog parada : dwConsolpalogs) {
			/*
			 * Alessandre em 18-08-17 o Fim da parada será null quando um fim de ciclo for lancado ao se informar o motivo de parada
			 * REGUALGEM
			 */
			Date dthrFParada = parada.getDthrFparada();
			if (dthrFParada == null)
				dthrFParada = dtHrFRef;
			BigDecimal tempoParada = DataHoraRN.getTempoIntersecaoEmSegundosComMilisegundos(
					parada.getDthrIparada(), dthrFParada,
					dtHrIRef, dtHrFRef);
			tempoParadasNoCiclo = tempoParadasNoCiclo.add(tempoParada);
		}
		return tempoParadasNoCiclo;
	}

}
