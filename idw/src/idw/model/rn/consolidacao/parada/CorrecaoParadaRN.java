package idw.model.rn.consolidacao.parada;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwTAcaoDAO;
import idw.model.dao.DwTCausaDAO;
import idw.model.dao.DwTJustDAO;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPacoteOuFatorException;
import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolmo;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpamo;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.DwTJust;
import idw.model.pojos.DwTParada;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.consolidacao.variacaoritmo.ConsolidacaoVariacaoRitmo;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.util.IdwLogger;
import idw.util.SQLUtils;
import idw.webservices.dto.DetalhamentoParadaDTO;
import idw.webservices.dto.DetalheParadaDTO;
import injetws.model.excessoes.SemSGBDException;
import ms.util.UtilsThreads;

public class CorrecaoParadaRN extends AbstractRN<DAOGenerico>{

	public CorrecaoParadaRN(){
		super (new DAOGenerico());
	}
	
	public CorrecaoParadaRN(DAOGenerico dao) {
		super(dao);
	}
	

	/*
	 * Metodo principal para correcao de paradas
	 */
	public void correcaoParadas(DetalhamentoParadaDTO paradas) throws RegistroDesconhecidoException, SemPlanejamentoException, SemCalendarioException, SemSGBDException, SemCicloPadraoException{
		String maquina = paradas.getListaparadas().get(0).getMaquina();
		String dthrCorrecao = DataHoraRN.getDataHoraAtualFormatada();
		
		correcaoNaHora(paradas, maquina, dthrCorrecao);
		correcaoNoTurno(paradas, maquina, dthrCorrecao);
		correcaoNoAcumulado(paradas, maquina, dthrCorrecao);
	}

	private void correcaoNoAcumulado(DetalhamentoParadaDTO paradas, String maquina, String dthrCorrecao) throws RegistroDesconhecidoException{
		IdwLogger log = new IdwLogger("CorrecaoParadaRN-Acumulado-PT" + maquina);
		
		DetalhamentoParadaDTO paradasNaHora = getParadasNoAcumulado(paradas);
		paradasNaHora.setDwConsolpalog(paradas.getDwConsolpalog());
		paradasNaHora.setDuracaoParadas(paradas.getDuracaoParadas());
		paradasNaHora.setParada(paradas.getParada());
		paradasNaHora.setUsuarioLogado(paradas.getUsuarioLogado());
		correcaoParadas(paradasNaHora, maquina, dthrCorrecao, log);
	}

	private void correcaoNaHora(DetalhamentoParadaDTO paradas, String maquina, String dthrCorrecao) throws RegistroDesconhecidoException{
		IdwLogger log = new IdwLogger("CorrecaoParadaRN-Hora-PT" + maquina);
		
		DetalhamentoParadaDTO paradasNaHora = getParadasNaHora(paradas);
		paradasNaHora.setDwConsolpalog(paradas.getDwConsolpalog());
		paradasNaHora.setDuracaoParadas(paradas.getDuracaoParadas());
		paradasNaHora.setParada(paradas.getParada());
		paradasNaHora.setUsuarioLogado(paradas.getUsuarioLogado());
		correcaoParadas(paradasNaHora, maquina, dthrCorrecao, log);
	}

	private void correcaoNoTurno(DetalhamentoParadaDTO paradas, String maquina, String dthrCorrecao) throws RegistroDesconhecidoException{
		IdwLogger log = new IdwLogger("CorrecaoParadaRN-Turno-PT" + maquina);
		correcaoParadas(paradas, maquina, dthrCorrecao, log);
	}
	
	// Corrige a parada no turno
	private void correcaoParadas(DetalhamentoParadaDTO paradas, String maquina, String dthrCorrecao, IdwLogger log) throws RegistroDesconhecidoException {
		int idLog = log.getIdAleatorio();
		int identacao = 0;
		
		DwTParada dwtparadaAnterior;
		DwTParada dwtparadaNova;
		
		log.info(idLog, identacao, "Inicia a correcao das paradas");
		
		ConsolidaRN rn  = new ConsolidaRN();
		rn.setDao(getDao());
		
		FolhaRN folhaRN = new FolhaRN(this.getDao());

		if (paradas != null && paradas.getDwConsolpalog() != null && paradas.getDwConsolpalog().getDwTParada() != null && paradas.getDwConsolpalog().getDwTParada().getIdTparada() != null)
			dwtparadaNova = getDao().findById(DwTParada.class, paradas.getDwConsolpalog().getDwTParada().getIdTparada(), false);
		else{
			log.info(idLog, identacao, "nova parada está nula, entao abortando correcao parada");
			return;
		}

		for(DetalheParadaDTO dto : paradas.getListaparadas()){
			DwConsolpaoco consolpaoco = obtemDwConsolpaoco(dto.getDwConsolpaoco().getIdConsolpaoco());
			dwtparadaAnterior = consolpaoco.getDwConsolpa().getDwTParada();
			
			log.info(idLog, identacao + 5, "dthrCorrecao: " + dthrCorrecao + 
					" Usuario:" + paradas.getUsuarioLogado().getLogin() + 
					" - corrigindo parada " +dwtparadaAnterior.getCdTparada() + 
					" as " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(consolpaoco.getDthrIparada()) + 
					" para " + dwtparadaNova.getCdTparada() +
					" idConsolpaoco:" + consolpaoco.getIdConsolpaoco() );

			correcaoDaCausaAcaoJustEmDwConsolpaoco(consolpaoco, paradas.getDwConsolpalog(), dwtparadaNova);
			
			
			/* Obtem cavidade e ciclo para recalculo da perda de producao
			 * 
			 */
			BigDecimal cavAtiva =  null;
			
			try {
				cavAtiva = folhaRN.getPcsPorCicloAtivas(consolpaoco.getDwConsolpa().getDwConsol().getDwConsolid().getDwFolha());
			} catch (SemPcsPorCicloAtivasException e) {
				cavAtiva = BigDecimal.ONE;
			}

			BigDecimal cicloPadrao = null;
			
			try {
				cicloPadrao = folhaRN.getCicloPadrao(consolpaoco.getDwConsolpa().getDwConsol().getDwConsolid().getDwFolha(), consolpaoco.getDwConsolpa().getDwConsol().getDwConsolid().getOmPt());
			} catch (SemCicloPadraoException e) {
				cicloPadrao = BigDecimal.ONE;
			}
			
			BigDecimal fatorContagem = BigDecimal.ONE;
			
			try {
				fatorContagem = folhaRN.getFatorContagemFromDwFolha(consolpaoco.getDwConsolpa().getDwConsol().getDwConsolid().getDwFolha(), consolpaoco.getDwConsolpa().getDwConsol().getDwConsolid().getOmPt());
			} catch (SemPacoteOuFatorException e) {
				fatorContagem = BigDecimal.ONE;
			}

			/*
			 * Calcula a duracao da parada
			 */
			Double duracaoParada = (double) DataHoraRN.getQuantidadeMilisegundosNoPeriodo(consolpaoco.getDthrIparada(), consolpaoco.getDthrFparada());
			duracaoParada /= 1000d; // duracao em segundos
			Double perdaParada = FormulasInjet.calcularProducaoPrevista(
					new BigDecimal(duracaoParada), 
					cicloPadrao, 
					cavAtiva,
					fatorContagem,
					consolpaoco.getDwConsolpa().getDwConsol().getDwConsolid().getOmPt().getIndOee()
					).doubleValue();
			
			// Remover valores do dwconsolpa antigo
			correcaoDeDwConsolpa(
					consolpaoco.getDwConsolpa(), 
					dwtparadaAnterior, 
					-1, 
					-1d * duracaoParada,
					-1d * perdaParada);
			

			// Procurar o consolpa adequado para a nova parada se nao existir criar novo
			DwConsolpa dwconsolpaNovo = null;
			DwConsolpa dwconsolpaAntigo = consolpaoco.getDwConsolpa();
			
			dwconsolpaNovo = rn.getDwConsolpa(consolpaoco.getDwConsolpa().getDwConsol().getIdConsol(), dwtparadaNova.getIdTparada());
			if (dwconsolpaNovo == null) {
				dwconsolpaNovo = new DwConsolpa();
				dwconsolpaNovo.setDwConsol(consolpaoco.getDwConsolpa().getDwConsol());
				dwconsolpaNovo.setDwTParada(dwtparadaNova);
				dwconsolpaNovo.setIdConsolpa(null);
				
				getDao().makePersistent(dwconsolpaNovo);
				
			}
			consolpaoco.setDwConsolpa(dwconsolpaNovo);
			
			getDao().makePersistent(consolpaoco);
			
			
			// Adicionar valores para novo dwconsolpa
			correcaoDeDwConsolpa(
					dwconsolpaNovo, 
					dwtparadaNova, 
					1, 
					duracaoParada,
					perdaParada);
			
			
			correcaoDwDwConsol(
					consolpaoco.getDwConsolpa().getDwConsol(), 
					dwtparadaAnterior, 
					dwtparadaNova, 
					duracaoParada, log, idLog, identacao);
			
			getDao().makePersistent(consolpaoco);
			
			
			//Alex 23/06/2017 #3998 Tratamento do DwConsolpamo
			DwConsol dwConsol = consolpaoco.getDwConsolpa().getDwConsol();
			DwConsolpalog dwConsolpalog = consolpaoco.getDwConsolpalog();
			boolean isParadaVarRitmo = ObjectUtils.defaultIfNull(dwConsolpalog.getIsVarritmo(), false);
			ConsolidacaoParada consolidacaoParada = new ConsolidacaoParada(getDao());
			
			for(DwConsolmo dwConsolmo : dwConsol.getDwConsolmos()) {				
				//Adicionando no novo
				BigDecimal qt = BigDecimal.ONE;
				BigDecimal tempoParada = new BigDecimal(duracaoParada);
				correcaoDeDwConsolpamo(consolidacaoParada, dwConsolmo, dwconsolpaNovo, isParadaVarRitmo, qt, tempoParada);

				//Removendo do antigo
				qt = qt.negate();
				tempoParada = new BigDecimal(duracaoParada).negate();
				correcaoDeDwConsolpamo(consolidacaoParada, dwConsolmo, dwconsolpaAntigo, isParadaVarRitmo, qt, tempoParada);
				//26/09/2019 - Adição de pausa para melhoria de perfomance
				UtilsThreads.pausaNaThread(10);
			}
			
			// Tentar excluir o consolpa antigo
//			dwconsolpaAntigo = obtemDwConsolpa(dwconsolpaAntigo.getIdConsolpa());
//			if (dwconsolpaAntigo.getDwConsolpaocos() == null || 
//					(dwconsolpaAntigo.getDwConsolpaocos() != null && dwconsolpaAntigo.getDwConsolpaocos().size() <= 0) ) {
//				
//				if (consolpaoco.getDwConsolpa() == null || 
//						(consolpaoco.getDwConsolpa() != null && consolpaoco.getDwConsolpa().getIdConsolpa().equals(dwconsolpaAntigo.getIdConsolpa()) == false))
//					getDao().delete(dwconsolpaAntigo);
//			}
			
			//-- fim #3998
			//26/09/2019 - Adição de pausa para melhoria de perfomance
			UtilsThreads.pausaNaThread(10);
		}
	}

	private void correcaoDeDwConsolpamo(ConsolidacaoParada consolidacaoParada, DwConsolmo dwConsolmo, DwConsolpa dwConsolpa, boolean isParadaVarRitmo, BigDecimal qt, BigDecimal tempoParada) {
		DwConsol dwConsol = dwConsolmo.getDwConsol();
		
		DwConsolpamo dwConsolpamo = consolidacaoParada.getDwConsolpamoSeNaoEncontrarNovo(dwConsolpa, dwConsolmo);
		DwTParada dwTParada = dwConsolpa.getDwTParada();

		if(dwConsolpamo == null || dwTParada == null) {
			return;
		}
		
		// Parada � de varia��o de ritmo
		if(isParadaVarRitmo){
			ConsolidacaoVariacaoRitmo.ajustarParadaVarRitmoDeDwConsolmoEDwConsolpamo(dwTParada.getIsPesa() != null && dwTParada.getIsPesa(), tempoParada, qt, dwConsolmo, dwConsolpamo);
		}
		
		// Pesa na eficiencia
		if(dwTParada.getIsPesa() == null || dwTParada.getIsPesa() == true){
			dwConsolmo.setSegAutoTempoparadaCp(AritmeticaUtil.somar(tempoParada, dwConsolmo.getSegAutoTempoparadaCp()));
			dwConsolpamo.setSegAutoTempoparadaCp(AritmeticaUtil.somar(tempoParada, dwConsolpamo.getSegAutoTempoparadaCp()));
			dwConsolpamo.setQtAutoTempoparadaCp(AritmeticaUtil.somar(qt, dwConsolpamo.getQtAutoTempoparadaCp()));
			
		}else{
			dwConsolmo.setSegAutoTempoparadaSp(AritmeticaUtil.somar(tempoParada, dwConsolmo.getSegAutoTempoparadaSp()));
			dwConsolpamo.setSegAutoTempoparadaSp(AritmeticaUtil.somar(tempoParada, dwConsolpamo.getSegAutoTempoparadaSp()));
			dwConsolpamo.setQtAutoTempoparadaSp(AritmeticaUtil.somar(qt, dwConsolpamo.getQtAutoTempoparadaSp()));				
		}

		// Parada padr�o
		if(dwTParada.getIsDefault() != null && dwTParada.getIsDefault()){
			dwConsolmo.setSegAutoTempoparadaDefault(AritmeticaUtil.somar(dwConsol.getSegAutoTempoparadaDefault(), tempoParada));
			dwConsolmo.setQtAutoTempoparadaDefault(AritmeticaUtil.somar(qt, dwConsol.getQtAutoTempoparadaDefault()));
		}

		// Parada para per�odo sem op
		if(dwTParada.getIsSemOp() != null && dwTParada.getIsSemOp()){
			dwConsolmo.setSegAutoTempoparadaSemOp(AritmeticaUtil.somar(dwConsolmo.getSegAutoTempoparadaSemOp(), tempoParada));
			dwConsolpamo.setSegAutoTempoparadaSemOp(AritmeticaUtil.somar(dwConsolpamo.getSegAutoTempoparadaSemOp(), tempoParada));
			dwConsolmo.setQtAutoTempoparadaSemOp(AritmeticaUtil.somar(qt, dwConsolmo.getQtAutoTempoparadaSemOp()));
			dwConsolpamo.setQtAutoTempoparadaSemOp(AritmeticaUtil.somar(qt, dwConsolpamo.getQtAutoTempoparadaSemOp()));
		}		
		
		// Parada para per�odo sem evento
		if(dwTParada.getIsSemEvento() != null && dwTParada.getIsSemEvento()){
			dwConsolmo.setSegAutoTempoparadaSemEvt(AritmeticaUtil.somar(dwConsolmo.getSegAutoTempoparadaSemEvt(), tempoParada));
			dwConsolpamo.setSegAutoTempoparadaSemEvt(AritmeticaUtil.somar(dwConsolpamo.getSegAutoTempoparadaSemEvt(), tempoParada));
			dwConsolmo.setQtAutoTempoparadaSemEvt(AritmeticaUtil.somar(qt, dwConsolmo.getQtAutoTempoparadaSemEvt()));
			dwConsolpamo.setQtAutoTempoparadaSemEvt(AritmeticaUtil.somar(qt, dwConsolpamo.getQtAutoTempoparadaSemEvt()));
		}	

		// Parada para per�odo sem conex�o
		if(dwTParada.getIsSemConexao() != null && dwTParada.getIsSemConexao()){
			dwConsolmo.setSegAutoTempoparadaSemCnx(AritmeticaUtil.somar(dwConsolmo.getSegAutoTempoparadaSemCnx(), tempoParada));
			dwConsolpamo.setSegAutoTempoparadaSemCnx(AritmeticaUtil.somar(dwConsolpamo.getSegAutoTempoparadaSemCnx(), tempoParada));
			dwConsolmo.setQtAutoTempoparadaSemCnx(AritmeticaUtil.somar(qt, dwConsolmo.getQtAutoTempoparadaSemCnx()));
			dwConsolpamo.setQtAutoTempoparadaSemCnx(AritmeticaUtil.somar(qt, dwConsolpamo.getQtAutoTempoparadaSemCnx()));
		}
		
		this.getDao().makePersistent(dwConsolmo);
		this.getDao().makePersistent(dwConsolpamo);
	}
	
	private void correcaoDaCausaAcaoJustEmDwConsolpaoco(DwConsolpaoco dwconsolpaoco, DwConsolpalog dwconsolpalog, DwTParada dwtparada) throws RegistroDesconhecidoException {
		DwTCausa dwtcausa = null;
		DwTAcao dwtacao = null;
		DwTJust dwtjust = null;

		if(dwtparada.getIsRequerCausa() != null && dwtparada.getIsRequerCausa() && dwconsolpalog.getDwTCausa() != null){
			DwTCausaDAO causaDAO = new DwTCausaDAO(getDaoSession());
			dwtcausa = causaDAO.getDwTCausaPorCdAtivo(dwconsolpalog.getDwTCausa().getCdTcausa());
		}
		if(dwtparada.getIsRequerAcao() != null && dwtparada.getIsRequerAcao() && dwconsolpalog.getDwTAcao() != null){
			DwTAcaoDAO acaoDAO = new DwTAcaoDAO(getDaoSession());
			dwtacao = acaoDAO.getDwTAcaoPorCdAtivo(dwconsolpalog.getDwTAcao().getCdTacao());
		}
		if(dwtparada.getIsRequerJust() != null && dwtparada.getIsRequerJust() && dwconsolpalog.getDwTJust() != null){
			DwTJustDAO justDAO = new DwTJustDAO(getDaoSession());
			dwtjust = justDAO.getDwTJustPorCdAtivo(dwconsolpalog.getDwTJust().getCdTjust());
		}

		dwconsolpaoco.setDwTAcao(dwtacao);
		dwconsolpaoco.setDwTCausa(dwtcausa);
		dwconsolpaoco.setDwTJust(dwtjust);
		
		getDao().makePersistent(dwconsolpaoco);
	}
	
	private void correcaoDeDwConsolpa(DwConsolpa dwconsolpa, DwTParada dwtparada, Integer quantidade, Double duracaoParada, Double perda) {
		// Remover a quantidade da parada (1) anterior
		if (dwtparada.getIsPesa() != null && dwtparada.getIsPesa() == true) {
				dwconsolpa.setQtAutoOcoparadaCp(AritmeticaUtil.somar(dwconsolpa.getQtAutoOcoparadaCp(), new BigDecimal(quantidade)));
				dwconsolpa.setQtAutoOcoparadaCpVr(AritmeticaUtil.somar(dwconsolpa.getQtAutoOcoparadaCpVr(), new BigDecimal(quantidade)));
				dwconsolpa.setSegAutoTempoparadaCp(AritmeticaUtil.somar(dwconsolpa.getSegAutoTempoparadaCp(), new BigDecimal(duracaoParada)));
				dwconsolpa.setSegAutoTempoparadaCpVr(AritmeticaUtil.somar(dwconsolpa.getSegAutoTempoparadaCpVr(), new BigDecimal(duracaoParada)));
				dwconsolpa.setPcsAutoPerdaparadaCp(AritmeticaUtil.somar(dwconsolpa.getPcsAutoPerdaparadaCp(), new BigDecimal(perda)));
		} else {
				dwconsolpa.setQtAutoOcoparadaSp(AritmeticaUtil.somar(dwconsolpa.getQtAutoOcoparadaSp(), new BigDecimal(quantidade)));
				dwconsolpa.setQtAutoOcoparadaSpVr(AritmeticaUtil.somar(dwconsolpa.getQtAutoOcoparadaSpVr(), new BigDecimal(quantidade)));
				dwconsolpa.setSegAutoTempoparadaSp(AritmeticaUtil.somar(dwconsolpa.getSegAutoTempoparadaSp(), new BigDecimal(duracaoParada)));	
				dwconsolpa.setSegAutoTempoparadaSpVr(AritmeticaUtil.somar(dwconsolpa.getSegAutoTempoparadaSpVr(), new BigDecimal(duracaoParada)));
				dwconsolpa.setPcsAutoPerdaparadaSp(AritmeticaUtil.somar(dwconsolpa.getPcsAutoPerdaparadaSp(), new BigDecimal(perda)));
		}
	}
	
	private void correcaoDwDwConsol(DwConsol dwconsol, DwTParada dwtparadaAnterior, DwTParada dwtparadaNova, Double duracaoParada, IdwLogger log, int idLog, int identacao){
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		BigDecimal cavAtiva =  null;
		
		try {
			cavAtiva = folhaRN.getPcsPorCicloAtivas(dwconsol.getDwConsolid().getDwFolha());
		} catch (SemPcsPorCicloAtivasException e) {
			cavAtiva = BigDecimal.ONE;
		}

		BigDecimal cicloPadrao = null;
		
		try {
			cicloPadrao = folhaRN.getCicloPadrao(dwconsol.getDwConsolid().getDwFolha(), dwconsol.getDwConsolid().getOmPt());
		} catch (SemCicloPadraoException e) {
			cicloPadrao = BigDecimal.ONE;
		}
		
		BigDecimal fatorContagem = BigDecimal.ONE;
		
		try {
			fatorContagem = folhaRN.getFatorContagemFromDwFolha(dwconsol.getDwConsolid().getDwFolha(), dwconsol.getDwConsolid().getOmPt());
		} catch (SemPacoteOuFatorException e) {
			fatorContagem = BigDecimal.ONE;
		}
		
		ajustarDwConsol(dwconsol, dwtparadaAnterior, new BigDecimal(1).negate(), new BigDecimal(duracaoParada).negate(), log, idLog, identacao);
		ajustarDwConsol(dwconsol, dwtparadaNova, new BigDecimal(1), new BigDecimal(duracaoParada), log, idLog, identacao);

		// Tempo ativo (tempo disponível) 
		dwconsol.setSegAutoTempoativo(FormulasInjet.calcularTempoAtivo(
				dwconsol.getSegAutoCicloprodutivo(), 
				dwconsol.getSegAutoTempoparadaCp(), 
				dwconsol.getSegAutoCicloimprodutivo(), 
				dwconsol.getSegAutoTempoparadaCpVr(), 
				dwconsol.getSegAutoTempoparadaSpVr()));

		// Tempo trabalhado
		dwconsol.setSegAutoTempotrabalhado(FormulasInjet.calcularTempoTrabalhado(
				dwconsol.getSegAutoTempoativo(), 
				dwconsol.getSegAutoTempoparadaCp()));

		dwconsol.setPcsAutoProducaoprevista(FormulasInjet.calcularProducaoPrevista(
				dwconsol.getSegAutoTempoativo(), 
				cicloPadrao, 
				cavAtiva,
				fatorContagem,
				dwconsol.getDwConsolid().getOmPt().getIndOee()
				));

		// Peças perdidas por parada
		dwconsol.setPcsAutoPerdaparadaCp(FormulasInjet.calcularPcsPerdaParada(dwconsol.getSegAutoTempoparadaCp() , cicloPadrao, cavAtiva));
		dwconsol.setPcsAutoPerdaparadaSp(FormulasInjet.calcularPcsPerdaParada(dwconsol.getSegAutoTempoparadaSp() , cicloPadrao, cavAtiva));

		getDao().makePersistent(dwconsol);
	}
	
	private void ajustarDwConsol(DwConsol dwconsol, DwTParada dwtparada, BigDecimal quantidade, BigDecimal duracao, IdwLogger log, int idLog, int identacao) {

		if (dwtparada.getIsPesa() != null && dwtparada.getIsPesa() == true) {
			dwconsol.setQtAutoOcoparadaCp(AritmeticaUtil.somar(dwconsol.getQtAutoOcoparadaCp(), quantidade));
			dwconsol.setQtAutoOcoparadaCpVr(AritmeticaUtil.somar(dwconsol.getQtAutoOcoparadaCpVr(), quantidade));
			dwconsol.setSegAutoTempoparadaCp(AritmeticaUtil.somar(dwconsol.getSegAutoTempoparadaCp(), duracao));
			dwconsol.setSegAutoTempoparadaCpVr(AritmeticaUtil.somar(dwconsol.getSegAutoTempoparadaCpVr(), duracao));
		} else {
			dwconsol.setQtAutoOcoparadaSp(AritmeticaUtil.somar(dwconsol.getQtAutoOcoparadaSp(), quantidade));
			dwconsol.setQtAutoOcoparadaSpVr(AritmeticaUtil.somar(dwconsol.getQtAutoOcoparadaSpVr(), quantidade));
			dwconsol.setSegAutoTempoparadaSp(AritmeticaUtil.somar(dwconsol.getSegAutoTempoparadaSp(), duracao));
			dwconsol.setSegAutoTempoparadaSpVr(AritmeticaUtil.somar(dwconsol.getSegAutoTempoparadaSpVr(), duracao));
		}

		if (dwtparada.getIsFds() != null && dwtparada.getIsFds() == true) {
			dwconsol.setQtAutoOcoparadafds(AritmeticaUtil.somar(dwconsol.getQtAutoOcoparadafds(), quantidade));
			dwconsol.setSegAutoTempoparadafds(AritmeticaUtil.somar(dwconsol.getSegAutoTempoparadafds(), duracao));
		}

		if (dwtparada.getIsPrev() != null && dwtparada.getIsPrev() == true) {
			dwconsol.setQtAutoOcoparadaprev(AritmeticaUtil.somar(dwconsol.getQtAutoOcoparadaprev(), quantidade));
			dwconsol.setSegAutoTempoparadaprev(AritmeticaUtil.somar(dwconsol.getSegAutoTempoparadaprev(), duracao));
		} else 	if (dwtparada.getIsPrev() != null && dwtparada.getIsPrev() == false) {
			dwconsol.setQtAutoOcoparadaimprev(AritmeticaUtil.somar(dwconsol.getQtAutoOcoparadaimprev(), quantidade));
			dwconsol.setSegAutoTempoparadaimprev(AritmeticaUtil.somar(dwconsol.getSegAutoTempoparadaimprev(), duracao));
		}
		
		if (dwtparada.getIsMdo() != null && dwtparada.getIsMdo() == true) {
			dwconsol.setQtAutoOcoparadamdo(AritmeticaUtil.somar(dwconsol.getQtAutoOcoparadamdo(), quantidade));
			dwconsol.setSegAutoTempoparadamdo(AritmeticaUtil.somar(dwconsol.getSegAutoTempoparadamdo(), duracao));
		}
		
		if (dwtparada.getIsMtbf() != null && dwtparada.getIsMtbf() == true) {
			dwconsol.setQtAutoOcoparadamtbf(AritmeticaUtil.somar(dwconsol.getQtAutoOcoparadamtbf(), quantidade));
			dwconsol.setSegAutoTempoparadamtbf(AritmeticaUtil.somar(dwconsol.getSegAutoTempoparadamtbf(), duracao));
		}
		
		if (dwtparada.getIsPa() != null && dwtparada.getIsPa() == true) {
			dwconsol.setQtAutoOcoparadapa(AritmeticaUtil.somar(dwconsol.getQtAutoOcoparadapa(), quantidade));
			dwconsol.setSegAutoTempoparadapa(AritmeticaUtil.somar(dwconsol.getSegAutoTempoparadapa(), duracao));
		}
		
		if (dwtparada.getIsPao() != null && dwtparada.getIsPao() == true) {
			dwconsol.setQtAutoOcoparadapao(AritmeticaUtil.somar(dwconsol.getQtAutoOcoparadapao(), quantidade));
			dwconsol.setSegAutoTempoparadapao(AritmeticaUtil.somar(dwconsol.getSegAutoTempoparadapao(), duracao));
		}
		
		if (dwtparada.getIsPp() != null && dwtparada.getIsPp() == true) {
			dwconsol.setQtAutoOcoparadapp(AritmeticaUtil.somar(dwconsol.getQtAutoOcoparadapp(), quantidade));
			dwconsol.setSegAutoTempoparadapp(AritmeticaUtil.somar(dwconsol.getSegAutoTempoparadapp(), duracao));
		}

		if (dwtparada.getIsPtp() != null && dwtparada.getIsPtp() == true) {
			dwconsol.setQtAutoOcoparadaptp(AritmeticaUtil.somar(dwconsol.getQtAutoOcoparadaptp(), quantidade));
			dwconsol.setSegAutoTempoparadaptp(AritmeticaUtil.somar(dwconsol.getSegAutoTempoparadaptp(), duracao));
		}
		
		if (dwtparada.getIsRegulagem() != null && dwtparada.getIsRegulagem() == true) {
			dwconsol.setQtAutoOcoparadaregulagem(AritmeticaUtil.somar(dwconsol.getQtAutoOcoparadaregulagem(), quantidade));
			dwconsol.setSegAutoTempoparadaregulagem(AritmeticaUtil.somar(dwconsol.getSegAutoTempoparadaregulagem(), duracao));
		}
		
		if (dwtparada.getIsScp() != null && dwtparada.getIsScp() == true) {
			dwconsol.setQtAutoOcoparadascp(AritmeticaUtil.somar(dwconsol.getQtAutoOcoparadascp(), quantidade));
			dwconsol.setSegAutoTempoparadascp(AritmeticaUtil.somar(dwconsol.getSegAutoTempoparadascp(), duracao));
		}
		
		if (dwtparada.getIsDefault() != null && dwtparada.getIsDefault() == true) {
			dwconsol.setQtAutoTempoparadaDefault(AritmeticaUtil.somar(dwconsol.getQtAutoTempoparadaDefault(), quantidade));
			dwconsol.setSegAutoTempoparadaDefault(AritmeticaUtil.somar(dwconsol.getSegAutoTempoparadaDefault(), duracao));
		}
		
		if (dwtparada.getIsSemConexao() != null && dwtparada.getIsSemConexao() == true) {
			dwconsol.setQtAutoTempoparadaSemCnx(AritmeticaUtil.somar(dwconsol.getQtAutoTempoparadaSemCnx(), quantidade));
			dwconsol.setSegAutoTempoparadaSemCnx(AritmeticaUtil.somar(dwconsol.getSegAutoTempoparadaSemCnx(), duracao));
		}
		
		if (dwtparada.getIsSemEvento() != null && dwtparada.getIsSemEvento() == true) {
			dwconsol.setQtAutoTempoparadaSemEvt(AritmeticaUtil.somar(dwconsol.getQtAutoTempoparadaSemEvt(), quantidade));
			dwconsol.setSegAutoTempoparadaSemEvt(AritmeticaUtil.somar(dwconsol.getSegAutoTempoparadaSemEvt(), duracao));
		}
		
		if (dwtparada.getIsSemOp() != null && dwtparada.getIsSemOp() == true) {
			dwconsol.setQtAutoTempoparadaSemOp(AritmeticaUtil.somar(dwconsol.getQtAutoTempoparadaSemOp(), quantidade));
			dwconsol.setSegAutoTempoparadaSemOp(AritmeticaUtil.somar(dwconsol.getSegAutoTempoparadaSemOp(), duracao));
		}
		
		getDao().makePersistent(dwconsol);
		try {
			getDao().flushReiniciandoTransacao();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private DetalhamentoParadaDTO getParadasNaHora(DetalhamentoParadaDTO paradas) {
		DetalhamentoParadaDTO retorno = new DetalhamentoParadaDTO();
		retorno.setListaparadas(new ArrayList<DetalheParadaDTO>());
		for (DetalheParadaDTO dto : paradas.getListaparadas()) {
			List<DwConsolpaoco> listaoco = getListaOco(dto, DwConsolidTemplate.TpId.HORA.getValue());
			for (DwConsolpaoco oco : listaoco) {
				DetalheParadaDTO novo = new DetalheParadaDTO();
				novo.setDwConsolpaoco(oco);
				retorno.getListaparadas().add(novo);
			}
		}
		return retorno;
	}
	
	private DetalhamentoParadaDTO getParadasNoAcumulado(DetalhamentoParadaDTO paradas) {
		DetalhamentoParadaDTO retorno = new DetalhamentoParadaDTO();
		retorno.setListaparadas(new ArrayList<DetalheParadaDTO>());
		for (DetalheParadaDTO dto : paradas.getListaparadas()) {
			List<DwConsolpaoco> listaoco = getListaOco(dto, DwConsolidTemplate.TpId.ACUMULADO.getValue());
			for (DwConsolpaoco oco : listaoco) {
				DetalheParadaDTO novo = new DetalheParadaDTO();
				novo.setDwConsolpaoco(oco);
				retorno.getListaparadas().add(novo);
			}
		}
		return retorno;
	}

	private List<DwConsolpaoco> getListaOco(DetalheParadaDTO dto, Byte tpId) {
		DwConsolpaoco consolpaoco = getDao().findById(DwConsolpaoco.class, dto.getDwConsolpaoco().getIdConsolpaoco(), false);

		List<DwConsolpaoco> retorno = null;
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from DwConsolpaoco a");
		q.append("join a.dwConsolpa b");
		q.append("join b.dwConsol c");
		q.append("join c.dwConsolid d");
		q.append("where a.dwConsolpalog = :dwconsolpalog and ");
		q.append("d.tpId = :tpid and ");
		q.append(SQLUtils.getSQLDentroPeriodo("a.dthrIparada", "a.dthrFparada", ":dtinicio", ":dtfim"));
		
		q.defineParametroTimestamp("dtinicio", dto.getDwConsolpaoco().getDthrIparada());
		q.defineParametroTimestamp("dtfim", dto.getDwConsolpaoco().getDthrFparada());
		q.defineParametro("dwconsolpalog", consolpaoco.getDwConsolpalog());
		q.defineParametro("tpid", tpId);
		retorno = q.list();
		
		return retorno;
	}
	
	private DwConsolpaoco obtemDwConsolpaoco(long id) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwConsolpaoco a");
		q.append("where a.idConsolpaoco = :id");
		q.defineParametro("id", id);
		return (DwConsolpaoco) q.uniqueResult();
	}
}
