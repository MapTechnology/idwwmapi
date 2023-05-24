package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.webservices.dto.PeriodoDTO;

public final class PeriodoRN {
    
	public static PeriodoDTO obtemPeriodoDaHoraAtual(Date dtHr){
		Validate.notNull(dtHr, "Data/hora referencia não pode ser nula");
		PeriodoDTO periodoDTO = new PeriodoDTO();

		// referencia em segundos do início do dia
		final int INICIO_HORA_REF_EM_SEG = 0;

		// referencia em segundos do início do dia
		final int TOTAL_SEG_1_HORA = 3600;

		int segNoDia = DataHoraRN.getSegundosDoDia(dtHr);

		// hora do dia
		int horaDia = segNoDia / (TOTAL_SEG_1_HORA + INICIO_HORA_REF_EM_SEG);

		// Coloca a data de início Ã© baseada na data de passada
		periodoDTO.setDtHrInicio(DataHoraRN.getDataSemHora(dtHr));

		// Coloca a hora de início
		periodoDTO.setDtHrInicio(DataHoraRN.adicionaSegundosNaData(periodoDTO.getDtHrInicio(), horaDia * TOTAL_SEG_1_HORA));

		// Adiciona os minutos e segundos para a hora de início
		periodoDTO.setDtHrInicio(DataHoraRN.adicionaSegundosNaData(periodoDTO.getDtHrInicio(), INICIO_HORA_REF_EM_SEG));

		// Atualiza fim da hora
		periodoDTO.setDtHrFim(DataHoraRN.adicionaSegundosNaData(periodoDTO.getDtHrInicio(), TOTAL_SEG_1_HORA));

		return periodoDTO;

	}    

	
	/**
	 * Lista os intervalos por hora, em que ocorreu os datas de inicio e fim
	 * @param dtHrIni
	 * @param dtHrFim
	 * @return
	 */
	public static List<PeriodoDTO> obtemHorasPeriodo(Date dtHrIni, Date dtHrFim){

		List<PeriodoDTO> periodos = new ArrayList<>();

		Validate.notNull(dtHrIni, "início deve ser preenchido");
		Validate.notNull(dtHrFim, "Fim deve ser preenchido");
		Validate.isTrue(DataHoraRN.compareTo(dtHrIni, dtHrFim) <= 0, "início (" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtHrIni) + ") não pode ser maior que fim (" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtHrFim));

		Date dtHrRef = dtHrIni;


		do{

			PeriodoDTO periodo = obtemPeriodoDaHoraAtual(dtHrRef);
			dtHrRef = periodo.getDtHrFim();
			periodos.add(periodo);

		}while(DataHoraRN.before(dtHrRef, dtHrFim));

		return periodos;

	}
	
}
