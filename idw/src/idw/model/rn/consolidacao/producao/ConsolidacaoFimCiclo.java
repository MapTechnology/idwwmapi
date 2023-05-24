package idw.model.rn.consolidacao.producao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DwConsolpalogDAO;
import idw.model.excessoes.CicloJaContabilizadoException;
import idw.model.excessoes.ReprocessarMsEvtException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwRtcic;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.MsEvtTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.consolidacao.EventoInvalidoException;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoFimCiclo extends ConsolidacaoProducao implements IConsolidacao{

	/**
	 * @param omPt
	 * @param dwCalsems <dwCalSem>
	 * @param msevt
	 * @param omcfg
	 * @param log
	 * @throws SemCicloPadraoException 
	 * @throws SemSGBDException 
	 * @throws SemCalendarioException 
	 * @throws SemPlanejamentoException 
	 * @throws EventoInvalidoException 
	 * @throws EstocarProducaoException 
	 */
	@Override
	public void executarConsolidacao(OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, MsEvt msevt, OmCfg omcfg, IdwLogger log, int idLog, int identacao)  throws SemCalendarioException, SemSGBDException, SemCicloPadraoException, SemPlanejamentoException, ReprocessarMsEvtException, CicloJaContabilizadoException, EventoInvalidoException {

		// Alessandre em 17-08-15 se a qtde enviado no msevt for = 0 entao descartar o ciclo
		// Alessandre em 09-02-18 com as modificações feitas pra Sony, onde a producao bruta, liquida e refugada são enviadas separadamente, pode ocorrer de qtde ser 0 mas a refugada ou liquida nao
		boolean isProducaoBrutaZerada = msevt.getQtde() != null && msevt.getQtde().intValue() == 0;
		boolean isProducaoLiquidaZerada = msevt.getProducaoliquida() == null || (msevt.getProducaoliquida() != null && msevt.getProducaoliquida().intValue() == 0);
		boolean isProducaoRefugadaZerada = msevt.getProducaorefugada() == null || (msevt.getProducaorefugada() != null && msevt.getProducaorefugada().intValue() == 0);
		if (isProducaoBrutaZerada && isProducaoLiquidaZerada && isProducaoRefugadaZerada) {
			Validate.isTrue(!isProducaoBrutaZerada, "Qtde do pacote ciclo zerada para idEvt=" + msevt.getIdEvt());
			Validate.isTrue(!isProducaoLiquidaZerada, "Producao liquida zerada para idEvt=" + msevt.getIdEvt());
			Validate.isTrue(!isProducaoRefugadaZerada, "Producao refugada zerada para idEvt=" + msevt.getIdEvt());
		}
	
		log.iniciaAvaliacao("obtemPpCp");
//		a questao aqui é que ppcp foi alterada no tm e obtemppcp criou uma nova???? isso ta criando nova qdo nao encontra pois esta sendo alterada
				
		final PpCp ppCp = obtemPpCp(log, idLog, identacao, omPt, dwCalsems, msevt, omcfg);
		log.paraAvaliacao(new BigDecimal(msevt.getIdEvt()), getDao());	
		
		Date dtHrInicioCiclo = getDtHrInicioCiclo(dwConsolpt, msevt, ppCp);

		Date dtHrFimCiclo = msevt.getDthrEvento();
		
		BigDecimal tempoCiclo = DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodoComScale5(dtHrInicioCiclo, dtHrFimCiclo);

		validarEventoDeveSerMaiorUltimoEventoConsolidado(dwConsolpt, dtHrFimCiclo);

		Validate.notNull(omPt, "Posto de trabalho está nulo");
		Validate.notNull(dtHrInicioCiclo, "Data hora de início de ciclo");
		Validate.notNull(dtHrFimCiclo, "Data hora de fim de ciclo");
		Validate.notNull(omPt.getIdPt(), "idPt está nulo");

		
		Validate.notNull(ppCp, "ppCp nao pode ser nulo");
		ppCp.mudarDthrIniciorealIfNull(dtHrInicioCiclo);
		
		
		// Se início for depois do fim, deixa o fim igual ao início
		if(DataHoraRN.after(dtHrInicioCiclo, dtHrFimCiclo)){
			log.info( new StringBuilder()
						.append("Início do ciclo é maior que o fim. Inicio ")
						.append(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dtHrInicioCiclo))
						.append(" fim ")
						.append(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dtHrFimCiclo))
						.append(". Fim do ciclo será consolidado como igual ao início")
						.append(". maquina ")
						.append(omPt.getCd())
						.toString());
			
			// Ajusta fim do ciclo
			dtHrFimCiclo = dtHrInicioCiclo;
			
			// Ajusta tempo do ciclo
			tempoCiclo= BigDecimal.ZERO;
		}
		
		// Se o tempo do ciclo for menor que zero, ajusta para o tamanho da diferença entre o início e fim da data
		if(tempoCiclo.compareTo(BigDecimal.ZERO) == -1){
			
			final BigDecimal tempoCicloDiferenaInicioFim = DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodoComScale5(dtHrInicioCiclo, dtHrFimCiclo);
			
			log.info( new StringBuilder()
			.append("Tempo do ciclo é menor que zero ")
			.append("(").append(tempoCiclo.doubleValue()).append(")")
			.append(" ciclo ajustado para ")
			.append(tempoCicloDiferenaInicioFim.doubleValue())
			.append(" . Início do ciclo")
			.append(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dtHrInicioCiclo))
			.append(". maquina ")
			.append(omPt.getCd())
			.toString());
			
			// Ajusta o tempo do ciclo
			tempoCiclo = tempoCicloDiferenaInicioFim;
			
		}
		
		Validate.isTrue(DataHoraRN.compareTo(dtHrInicioCiclo, dtHrFimCiclo) < 1, "Início do ciclo é maior que o fim. Inicio " + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dtHrInicioCiclo) + " fim " + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dtHrFimCiclo) + " maquina " + omPt.getCd());

		// Pega a folha ativa
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		final DwFolha dwFolha = folhaRN.getDwFolhaAtiva(ppCp);
		Validate.notNull(dwFolha,"não tem folha ativa para o ppCp");
		BigDecimal producaoPorCiclo;
		try {
			producaoPorCiclo = folhaRN.getPcsPorCicloAtivas(dwFolha);
		} catch (SemPcsPorCicloAtivasException e1) {
			producaoPorCiclo = BigDecimal.ONE;
		}
		
		DwPepro dwPepro = msevt.getDwPepro();
		
		// Força finalização de parada aberta
		forcarFinalizacaoParadaAbertaEmNovoCiclo(dtHrInicioCiclo, dtHrFimCiclo, omPt, dwConsolpt,  dwCalsems, ppCp, dwFolha, omcfg, log, idLog, identacao, dwPepro, msevt);

		DwConsolpalog dwConsolpalog = getUltimaParadaFromDwConsolpalog(omPt);
		boolean isRegulagem = false;
		if(dwConsolpalog != null ){
			isRegulagem = dwConsolpalog.isDtHrDentroParadaComRegulagem(dtHrFimCiclo);			
		}

		boolean isProdutivo = (isRegulagem == false);
		
		msevt.setIsRegulagem(isRegulagem);
		
		DwConsolpalogDAO dwConsolpalogDAO = new DwConsolpalogDAO(getDaoSession());
		
		Map<String, BigDecimal> mapCavAtivaProduto = new HashMap<String, BigDecimal>();
		Map<String, BigDecimal> mapCavTotalProduto = new HashMap<String, BigDecimal>();
		
		List<DwConsolpalog> paradasNoCiclo = dwConsolpalogDAO.getParadasFechadasNoPeriodo(omPt, dtHrInicioCiclo, dtHrFimCiclo); 	


		// Consolidacao do ciclo no turno
		ConsolidacaoFimCicloNoTurno cturno = new ConsolidacaoFimCicloNoTurno();
		cturno.setDao(getDao());
		cturno.consolidarCicloTurno(log, idLog, identacao, omPt, dwConsolpt, dwCalsems, ppCp, dwFolha, omcfg, dtHrInicioCiclo, dtHrFimCiclo, isProdutivo, isRegulagem, tempoCiclo, msevt, paradasNoCiclo, mapCavAtivaProduto, mapCavTotalProduto);
		
		
		// Consolidacao do ciclo na hora
		ConsolidacaoFimCicloNaHora chora = new ConsolidacaoFimCicloNaHora();
		chora.setDao(getDao());
		chora.consolidarCicloHora(log, idLog, identacao, omPt, dwConsolpt, dwCalsems, ppCp, dwFolha, omcfg, dtHrInicioCiclo, dtHrFimCiclo, isProdutivo, isRegulagem, tempoCiclo, msevt, paradasNoCiclo, mapCavAtivaProduto, mapCavTotalProduto);

		// Consolidacao do ciclo acumulado
		ConsolidacaoFimCicloAcumulado cacum = new ConsolidacaoFimCicloAcumulado();
		cacum.setDao(getDao());
		cacum.consolidarCicloAcumulado(log, idLog, identacao, omPt, dwConsolpt, dwCalsems, ppCp, dwFolha, omcfg, dtHrInicioCiclo, dtHrFimCiclo, isProdutivo, isRegulagem, tempoCiclo, msevt, paradasNoCiclo, mapCavAtivaProduto, mapCavTotalProduto);

		

		
		// Atualizar dados na OP do PT
		ConsolidacaoFimCicloNaOP cop = new ConsolidacaoFimCicloNaOP(getDao());
		cop.consolidarCicloNaOP(omPt, ppCp, dtHrInicioCiclo);

		
		// Consolida ciclo no estoque
		ConsolidacaoFimCicloNoEstoque ce = new ConsolidacaoFimCicloNoEstoque(getDao());
		ce.consolidarCicloNoEstoque(log, idLog, identacao, isProdutivo, omcfg, omPt, ppCp, dwFolha, dtHrFimCiclo, producaoPorCiclo, msevt);

		
	}

	protected Date getDtHrInicioCiclo(DwConsolpt dwConsolpt, MsEvt msevt, final PpCp ppCp) throws EventoInvalidoException {
		// Alessandre: 29-5-14 comentei a linha abaixo pois qdo ocorre uma parada por regulagem, os ciclos internos e recusados fazem com que o 
		// ciclo que sera processado fique com um tempo inferior.
		Date dtHrInicioCiclo = msevt.getDthrEventoanterior();
		
		// Se o evento de inicio de ciclo foi processado com sucesso entao utilizar a dthrdoeventoanterior como inicio do ciclo
		if (msevt.getMsEvt() == null || MsEvtTemplate.StEvt.REJEITADO.equals(msevt.getMsEvt())) {
			DwRtcic ultimoCiclo = dwConsolpt.getDwRtcic();
			if(ultimoCiclo != null && ppCp.getCdCp().equals(ultimoCiclo.getPpCp().getCdCp()) ){
				dtHrInicioCiclo = ultimoCiclo.getDthrFciclo();
			}else {
				dtHrInicioCiclo = DataHoraRN.subtraiMilisegundosNaData(msevt.getDthrEvento(), msevt.getMiliDuracaoevento().intValue());
			}
		}
		
		if(dtHrInicioCiclo == null) {
			throw new EventoInvalidoException(msevt, "Nao foi possivel encontrar uma data/hora inicio de ciclo");
		}
		
		return dtHrInicioCiclo;
	}


}
