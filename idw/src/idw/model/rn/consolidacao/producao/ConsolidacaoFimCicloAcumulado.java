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
import idw.model.rn.TurnoRN;
import idw.util.IdwLogger;
import idw.webservices.dto.TurnoAtualDTO;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoFimCicloAcumulado extends ConsolidacaoProducao{
	
	protected void consolidarCicloAcumulado(IdwLogger log, int idLog, int identacao, OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, 
			PpCp ppCp, DwFolha dwFolha, OmCfg omcfg,
			Date dtHrIniCiclo, Date dtHrFimCiclo,
			boolean isProdutivo, boolean isRegulagem, BigDecimal tempoCiclo, MsEvt msevt, 
			List<DwConsolpalog> paradasNoCiclo, 
			Map<String, BigDecimal> mapCavAtivaProduto, Map<String, BigDecimal> mapCavTotalProduto) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException, CicloJaContabilizadoException{
		
		TurnoRN turnoRN = new TurnoRN(getDao());

		// Pega os per�odos com os turnos
		TurnoAtualDTO turnoAtualDTO = turnoRN.getTurnoAtualDTO(dwCalsems, dtHrFimCiclo);

		DwConsolid dwConsolid = this.obtemConsolIdAcumulado(omPt, ppCp, dwFolha, turnoAtualDTO);

		// Consolida o ciclo para o turno
		consolidarFimCicloDwConsolid(
				log, 
				idLog,
				identacao,
				omPt, 
				dwConsolpt, 
				ppCp, 
				dwFolha, 
				dwConsolid, 
				omcfg, 
				dtHrIniCiclo, // periodoDTO.getDtHrInicio(), como eh acumulado o periodo inicial ou final (hora ou turno) eh irrelevante
				dtHrFimCiclo, // periodoDTO.getDtHrFim(), 
				dtHrIniCiclo, 
				dtHrFimCiclo, 
				isProdutivo, 
				isRegulagem, 
				tempoCiclo, 
				msevt, 
				paradasNoCiclo,
				mapCavAtivaProduto, mapCavTotalProduto);
		
		log.info(idLog, identacao, "executou consolidarCicloAcumulado");
	}

}
