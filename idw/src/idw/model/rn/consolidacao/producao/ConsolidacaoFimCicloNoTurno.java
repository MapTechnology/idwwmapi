package idw.model.rn.consolidacao.producao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.Validate;

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
import idw.webservices.dto.TurnoAtualDTO;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoFimCicloNoTurno extends ConsolidacaoProducao{

	/**
	 * Consolida o ciclo nos turnos em que ele ocorre
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
	public void consolidarCicloTurno(IdwLogger log, int idLog, int identacao, OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, PpCp ppCp, DwFolha dwFolha, OmCfg omcfg,
			Date dtHrIniCiclo, Date dtHrFimCiclo,
			boolean isProdutivo, boolean isRegulagem, BigDecimal tempoCiclo, MsEvt msevt, 
			List<DwConsolpalog> paradasNoCiclo, Map<String, BigDecimal> mapCavAtivaProduto, Map<String, BigDecimal> mapCavTotalProduto) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException, CicloJaContabilizadoException{
		
		TurnoRN turnoRN = new TurnoRN(getDao());
		DwConsolid dwConsolid = null;
		// Pega os per�odos com os turnos
		List<TurnoAtualDTO>  listaTurnoAtualDTO = turnoRN.getTurnoAtualDTOsPeriodo(dwCalsems, dtHrIniCiclo, dtHrFimCiclo);

		// Per�odo em que a parada
		for(TurnoAtualDTO turnoAtualDTO:listaTurnoAtualDTO){

			Validate.notNull(turnoAtualDTO, "turnoAtualDTO esta null");
			Validate.notNull(turnoAtualDTO.getDtHrITurno(), "turnoAtualDTO.getDtHrITurno() esta null");
			Validate.notNull(turnoAtualDTO.getDtHrFTurno(), "turnoAtualDTO.getDtHrFTurno() esta null");
		
			log.info(idLog, identacao, "elemento2 do turno " + turnoAtualDTO);
			
			/* Alessandre em 08-04-19. Foi identificado que na coleta de arquivos de logs muito antigos (ou caso o IC retroceda a data em varios meses)
			 * o fim de ciclo terá um intervalo muito grande, gerando demora excessiva na consolidacao. Visto que todos os turnos, horas e acumulados
			 * no intervalo serão consolidados.
			 * Abaixo foi feito um filtro para considerar somente três dias de consolidacao
			 */
			Date dtReferenciaMinimo = DataHoraRN.getDataHoraAtual();
			dtReferenciaMinimo = DataHoraRN.subtraiDiasDaData(dtReferenciaMinimo, 4);
			if (turnoAtualDTO.getDtReferencia().before(dtReferenciaMinimo))
				continue;
				

			// Pega ConsolId
			dwConsolid = this.obtemConsolIdTurno(log, idLog, identacao, omPt, ppCp, dwFolha, turnoAtualDTO, msevt.getDwPepro());
			// Consolida o ciclo para o turno dwConsolid.getIdConsolid() msevt.getDwPepro().getIdPepro()
			consolidarFimCicloDwConsolid(log, idLog, identacao, omPt, dwConsolpt, ppCp, dwFolha, dwConsolid, omcfg, turnoAtualDTO.getDtHrITurnoComTolerancia(), 
					turnoAtualDTO.getDtHrFTurnoComTolerancia(), dtHrIniCiclo, dtHrFimCiclo, isProdutivo, isRegulagem, tempoCiclo, msevt,
					paradasNoCiclo, mapCavAtivaProduto, mapCavTotalProduto);

			
		}

	}


}
