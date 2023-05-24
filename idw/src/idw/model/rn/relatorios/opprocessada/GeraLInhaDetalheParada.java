package idw.model.rn.relatorios.opprocessada;

import idw.model.pojos.DwConsolpa;
import idw.model.rn.DataHoraRN;
import idw.util.AritmeticaUtil;

public class GeraLInhaDetalheParada {
	
	public void acumulaParada(DwConsolpa consolpa, RelatorioOrdemProducaoProcessadaDetalheDTO linha) {
		
		RelatorioOrdemProducaoProcessadaParadaDTO dtoParada = null;
		for (RelatorioOrdemProducaoProcessadaParadaDTO dto : linha.getParadas()) {
			if (dto.getCdParada().equals(consolpa.getDwTParada().getCdTparada())) {
				dtoParada = dto;
				break;
			}
		}
		
		if (dtoParada == null) {
			dtoParada = new RelatorioOrdemProducaoProcessadaParadaDTO();
			dtoParada.setCdParada(consolpa.getDwTParada().getCdTparada());
			dtoParada.setDsParada(consolpa.getDwTParada().getDsTparada());
			dtoParada.setPesa(consolpa.getDwTParada().getIsPesa());
			linha.getParadas().add(dtoParada);
		}
		if (consolpa.getSegAutoTempoparadaCp() != null)
			dtoParada.setTempoParada(AritmeticaUtil.somar(dtoParada.getTempoParada(), consolpa.getSegAutoTempoparadaCp().doubleValue()).doubleValue());
		else if (consolpa.getSegAutoTempoparadaSp() != null)
			dtoParada.setTempoParada(AritmeticaUtil.somar(dtoParada.getTempoParada(), consolpa.getSegAutoTempoparadaSp().doubleValue()).doubleValue());
		
		dtoParada.setTempoParadaFormatado(DataHoraRN.formatSegundosParaHHMMSSmmm(dtoParada.getTempoParada().doubleValue()));
	}

}
