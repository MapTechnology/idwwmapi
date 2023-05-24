package idw.model.rn.consolidacao;

import java.util.Date;

import idw.model.dao.DAOGenerico;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.PeriodoDTO;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoPeriodoTest {
	
	public static void main(String[] args) throws RegistroDesconhecidoException, SemCalendarioException, SemSGBDException {
		DAOGenerico dao = new DAOGenerico();
		IdwLogger log = new IdwLogger("teste");
		int idLog = log.getIdAleatorio();
		int identacao = 0;
		try {
			dao.iniciaConexaoBanco();
			
			PTRN ptrn = new PTRN(dao);
			OmPt omPt = ptrn.getOmPt("XP2L01");
			OmCfg omCfg = Util.getConfigGeral(dao.getSession());
			
			Date dtHrInicio = DataHoraRN.getDataHora(2017, 06, 01, 13, 50, 6, 30); // 1478886606030
			Date dtHrFim = DataHoraRN.getDataHora(2017, 06, 10, 13, 53, 35, 290); // 1478886815290
	
			ConsolidacaoPeriodo consolidacaoPeriodo = 
					new ConsolidacaoPeriodo(dao, omPt, omCfg, dtHrInicio, dtHrFim, null, log, idLog, identacao);
			System.out.println("Periodos de "  + 
					DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dtHrInicio) +
					DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dtHrFim));
			
			System.out.println("Periodos por turno");
			for (PeriodoDTO periodoDTO : consolidacaoPeriodo.getPeriodosTurno()) {
				System.out.println(periodoDTO);
			}
			
			System.out.println("Periodos por hora");
			for (PeriodoDTO periodoDTO : consolidacaoPeriodo.getPeriodosHora()) {
				System.out.println(periodoDTO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.finalizaConexaoBancoSemException();
		}
		
	}
}
