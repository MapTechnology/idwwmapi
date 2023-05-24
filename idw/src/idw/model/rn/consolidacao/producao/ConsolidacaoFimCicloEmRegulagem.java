package idw.model.rn.consolidacao.producao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.Validate;

import idw.model.excessoes.CicloJaContabilizadoException;
import idw.model.excessoes.ReprocessarMsEvtException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwRtcic;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwPeproTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.consolidacao.EventoInvalidoException;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoFimCicloEmRegulagem extends ConsolidacaoFimCiclo{

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
		boolean isQtde = msevt.getQtde() != null && msevt.getQtde().intValue() == 0;
		if (isQtde == true)
			Validate.isTrue(!isQtde, "Qtde do pacote ciclo zerada");
	
		final PpCp ppCp = obtemPpCp(log, idLog, identacao, omPt, dwCalsems, msevt, omcfg);
		
		Date dtHrInicioCiclo = getDtHrInicioCiclo(dwConsolpt, msevt, ppCp);

		Date dtHrFimCiclo = msevt.getDthrEvento();
		
		BigDecimal tempoCiclo = DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodoComScale5(dtHrInicioCiclo, dtHrFimCiclo);

		validarEventoDeveSerMaiorUltimoEventoConsolidado(dwConsolpt, dtHrFimCiclo);

		Validate.notNull(omPt, "Posto de trablaho está nulo");
		Validate.notNull(dtHrInicioCiclo, "Data hora de início de ciclo");
		Validate.notNull(dtHrFimCiclo, "Data hora de fim de ciclo");
		Validate.notNull(omPt.getIdPt(), "idPt está nulo");

		
		Validate.notNull(ppCp, "ppCp nao pode ser nulo");
		ppCp.mudarDthrIniciorealIfNull(dtHrInicioCiclo);
		
		
		// Se início for depois do fim, deixa o fim igual ao início
		if(DataHoraRN.after(dtHrInicioCiclo, dtHrFimCiclo)){
			log.info(idLog, 0, new StringBuilder()
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
			
			log.info(idLog, 0,  new StringBuilder()
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

		boolean isRegulagem = true;
		boolean isProdutivo = false;
		
		Map<String, BigDecimal> mapCavAtivaProduto = new HashMap<String, BigDecimal>();
		Map<String, BigDecimal> mapCavTotalProduto = new HashMap<String, BigDecimal>();
		
		msevt.setIsRegulagem(isRegulagem);
		DwPepro dwpepro = getDao().findById(DwPepro.class, DwPeproTemplate.Type.REGULAGEM.getId(), false);
		msevt.setDwPepro(dwpepro);
		
		ConsolidacaoFimCicloNoTurno cturno = new ConsolidacaoFimCicloNoTurno();
		cturno.setDao(getDao());
		cturno.consolidarCicloTurno(log, idLog, identacao, omPt, dwConsolpt, dwCalsems, ppCp, dwFolha, omcfg, dtHrInicioCiclo, dtHrFimCiclo, 
				isProdutivo, isRegulagem, tempoCiclo, msevt, null, mapCavAtivaProduto, mapCavTotalProduto);

		ConsolidacaoFimCicloNaHora chora = new ConsolidacaoFimCicloNaHora();
		chora.setDao(getDao());
		chora.consolidarCicloHora(log, idLog, identacao, omPt, dwConsolpt, dwCalsems, ppCp, dwFolha, omcfg, dtHrInicioCiclo, dtHrFimCiclo, 
				isProdutivo, isRegulagem, tempoCiclo, msevt, null, mapCavAtivaProduto, mapCavTotalProduto);

		/* Nesse ponto devemos incluir o ciclo de regulagem em dwrtcic. Apesar de estsarmos usando a mesma RN
		 * de um ciclo normal, o dwrt não eh alterado quando o ciclo for em regulagem, logo devemos inclui-lo aqui
		 */
		// Inclui evento de ciclo
		if(dwConsolpt != null && dwConsolpt.getDwRtcic().getDwRt() != null){
			DwRtcic dwRtcic = consolidarDwRtCic(dwConsolpt.getDwRtcic().getDwRt(), dwFolha, dtHrInicioCiclo, dtHrFimCiclo, tempoCiclo, isRegulagem, log, idLog, identacao);
			dwConsolpt.setDwRtcic(dwRtcic);
		}


	
	}
}
