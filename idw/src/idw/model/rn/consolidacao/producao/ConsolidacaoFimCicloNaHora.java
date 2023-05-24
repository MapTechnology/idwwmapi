package idw.model.rn.consolidacao.producao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import idw.model.excessoes.CicloJaContabilizadoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwFolha;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.rn.DataHoraRN;
import idw.model.rn.TurnoRN;
import idw.util.IdwLogger;
import idw.webservices.dto.PeriodoDTO;
import idw.webservices.dto.TurnoAtualDTO;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoFimCicloNaHora extends ConsolidacaoProducao{

	/**
	 * Consolida ciclo por Hora
	 * @param log
	 * @param omPt
	 * @param ppCp
	 * @param omcfg
	 * @param dtHrIniCiclo
	 * @param dtHrFimCiclo
	 * @param isProdutivo
	 * @param isRegulagem
	 * @param tempoCiclo
	 * @throws SemCalendarioException
	 * @throws SemSGBDException
	 */
	protected void consolidarCicloHora(IdwLogger log, int idLog, int identacao, OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, PpCp ppCp, DwFolha dwFolha, OmCfg omcfg,
			Date dtHrIniCiclo, Date dtHrFimCiclo,
			boolean isProdutivo, boolean isRegulagem, BigDecimal tempoCiclo, MsEvt msevt, List<DwConsolpalog> paradasNoCiclo,
			Map<String, BigDecimal> mapCavAtivaProduto, Map<String, BigDecimal> mapCavTotalProduto) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException, CicloJaContabilizadoException{

		TurnoRN turnoRN = new TurnoRN(this.getDao());

		// Pega os periodos com os turnos
		List<PeriodoDTO>  listaHoraAtualDTO = obtemHorasPeriodo(dtHrIniCiclo, dtHrFimCiclo);

		// Periodo em que a parada
		for(PeriodoDTO periodoDTO:listaHoraAtualDTO){
			/*
			 * As duas linhas abaixo foram comentadas pq nao se pode usar a dthr do evento como referencia para se encontrar o turno analisado
			 * pois podem haver varias horas a serem consolidades e cada hora pode estar em um turno diferente. Se usarmos a dthr do evento
			 * vai acontecer de termos horas passadas todas no mesmo turno. Isso foi visto qdo se deixou uma up parada de um dia para outro
			 * e apos consolidar o 1o ciclo no dia seguinte, todos os horarios anteriores foram registrados no turno do dia seguinte
			 * Isso foi pego no relatorio de acompanhamento de producao hora a hora
			 * O codigo seguinte foi usado em substituicao
			log.info("Obtendo turno para hora do evento " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(msevt.getDthrEvento()));
			TurnoAtualDTO turnoAtualDTO = turnoRN.getTurnoAtualDTO(dwCalsems, msevt.getDthrEvento());
			 */

			/* Obter o turno  usando como base a data e hora de inicio da hora do periodo
			 * Alessandre: em 11-03-16 nao eh valido usar a data e hora inicial do periodo pois pode ter 2 turnos com o mesmo periodo
			 * assim comentei a linha abaixo e substitui para usar a dt e hora do fim do ciclo
			 */
			//Date dtRefParaTurno = periodoDTO.getDtHrInicio();
			List<TurnoAtualDTO> lista = turnoRN.getTurnoAtualDTOsPeriodo(dwCalsems, periodoDTO.getDtHrInicio(), periodoDTO.getDtHrFim(), log, idLog, identacao);
			
			for (TurnoAtualDTO turnoAtualDTO : lista) {
				
				log.info(idLog, identacao, "elemento " + turnoAtualDTO);
				/* Alessandre em 08-04-19. Foi identificado que na coleta de arquivos de logs muito antigos (ou caso o IC retroceda a data em varios meses)
				 * o fim de ciclo terá um intervalo muito grande, gerando demora excessiva na consolidacao. Visto que todos os turnos, horas e acumulados
				 * no intervalo serão consolidados.
				 * Abaixo foi feito um filtro para considerar somente três dias de consolidacao
				 */
				Date dtReferenciaMinimo = DataHoraRN.getDataHoraAtual();
				dtReferenciaMinimo = DataHoraRN.subtraiDiasDaData(dtReferenciaMinimo, 4);
				if (turnoAtualDTO.getDtReferencia().before(dtReferenciaMinimo))
					continue;

				
				
				// aqui um ciclo comecou no dia 14 e terminou no 15 o if abaixo tem que contabilizar a producao no fim do ciclo
				// mas contabilizou 2x o mesmo ciclo
				if (DataHoraRN.isIntersecao(dtHrFimCiclo, turnoAtualDTO.getDtHrITurno(), turnoAtualDTO.getDtHrFTurno())) {
					log.info(idLog, identacao, "Avaliadno turno " + turnoAtualDTO.getCdTurno());
					// Pega ConsolId
					DwConsolid dwConsolid = this.obtemConsolIdHora(omPt, ppCp, dwFolha, periodoDTO.getDtHrInicio(), turnoAtualDTO, msevt != null ? msevt.getDwPepro() : null);
					log.info(idLog, identacao, "obtido o idConsolid = " + dwConsolid.getIdConsolid() + " inicio=" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(periodoDTO.getDtHrInicio()) + " para idturno " + turnoAtualDTO.getIdTurno());
			
					// Consolida o ciclo para o turno
					consolidarFimCicloDwConsolid(log, idLog, identacao, omPt, dwConsolpt, ppCp, dwFolha, dwConsolid, omcfg, periodoDTO.getDtHrInicio(), 
							periodoDTO.getDtHrFim(), dtHrIniCiclo, dtHrFimCiclo, isProdutivo, isRegulagem, tempoCiclo, msevt,
							paradasNoCiclo, mapCavAtivaProduto, mapCavTotalProduto);
				}
			}
		}
	}
}
