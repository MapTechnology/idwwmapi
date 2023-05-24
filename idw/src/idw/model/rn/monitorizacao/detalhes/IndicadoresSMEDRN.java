package idw.model.rn.monitorizacao.detalhes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwProrea;
import idw.model.pojos.DwProreaativ;
import idw.model.pojos.template.DwProreaTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.monitorizacao.detalhes.dto.HistoricoSmedDTO;

public class IndicadoresSMEDRN extends AbstractRN<DAOGenerico>  {

	public IndicadoresSMEDRN(DAOGenerico dao) {
		super(dao);
	}

	public List<HistoricoSmedDTO> getHistoricoSmedDTO(List<DwConsolid> lista) {
		List<HistoricoSmedDTO> retorno = new ArrayList<>();
		
		for (DwConsolid id : lista) {
			/* Alessandre: o inicio planejado nao podemos considerar o inico planejado da op pois esse inicio é o comeco do setup interno
			 * Assim, o inicio planejado deve ser o inicio planejado da op - tempo definido no procedimento para o setup EXterno. No caso
			 * considerar o primeiro GRUPO como sendo o externo
			 */
			Date dthrIPlanejado = id.getPpCp().getDthrInicio();
			if (dthrIPlanejado == null)
				dthrIPlanejado = DataHoraRN.getDataHoraAtual();
			
			double segSomaTempoPrimeiroGrupo = 0d;
			long idPrimeiroGrupo = 0l;
			for (DwProrea procedimento : id.getDwProreas()) {
				// Apenas os procedimentos fechados serao apresentados
				if (procedimento.getStProrea().equals(DwProreaTemplate.StProrea.STATUS_FECHADO.getValue()) == false)
					continue;

				HistoricoSmedDTO dto = new HistoricoSmedDTO();
				
				dto.setCdPt(id.getOmPt().getCdPt());

				Date dthrIReal = null;
				Date dthrFReal = null;
				String operador = "";
				
				int segDuracaoReal = 0;	
				int segDuracaoPlanejada = 0;
				
				for (DwProreaativ atividade : procedimento.getDwProreaativs()) {
					if (idPrimeiroGrupo == 0l) {
						idPrimeiroGrupo = atividade.getDwProcativ().getDwGrpativ().getIdGrpativ();
					}
					if (atividade.getDwProcativ().getDwGrpativ().getIdGrpativ() == idPrimeiroGrupo) {
						segSomaTempoPrimeiroGrupo += (atividade.getDwProcativ().getSegTempopadrao().intValue());
					}
					segDuracaoPlanejada = segDuracaoPlanejada + (atividade.getDwProcativ().getSegTempopadrao().intValue());

					if (dthrIReal == null || DataHoraRN.before(atividade.getDthrInicio(), dthrIReal)) {
						dthrIReal = atividade.getDthrInicio();
					}
					if (dthrFReal == null || (atividade.getDthrFim() != null && DataHoraRN.after(atividade.getDthrFim(), dthrFReal))) {
						dthrFReal = atividade.getDthrFim();
					}					
					if(atividade.getDthrFim() != null && atividade.getDthrInicio() != null) {
						segDuracaoReal =  segDuracaoReal + DataHoraRN.getQuantidadeSegundosNoPeriodo(atividade.getDthrInicio(), atividade.getDthrFim());
					}
					if (atividade.getOmUsr() != null) {
						operador = atividade.getOmUsr().getDsNome();
					}					
				}
				for(DwConsol consol : id.getDwConsols()) {
					for(DwConsolpr consolpr : consol.getDwConsolprs()) {
						dto.setProduto(consolpr.getOmProduto().getCdProduto());
					}
				}

				// Recalcula o inicio planejado subtranindo o tempo do primeiro grupo (SETUPEXTERNO)
				dthrIPlanejado = DataHoraRN.subtraiSegundosDaData(dthrIPlanejado, (int) (segSomaTempoPrimeiroGrupo));
				dto.setDthrIReal(dthrIReal);
				dto.setDthrFReal(dthrFReal);
				dto.setOperador(operador);
				dto.setSegDuracaoReal((long)DataHoraRN.getQuantidadeSegundosNoPeriodo(dthrIReal, dthrFReal));
				dto.setDthrIPlanejado(dthrIPlanejado);
				dto.setDthrFPlanejado(DataHoraRN.adicionaSegundosNaData(dthrIPlanejado, (segDuracaoPlanejada)));
				dto.setSegDuracaoPlanejada((long)DataHoraRN.getQuantidadeSegundosNoPeriodo(dthrIPlanejado, dto.getDthrFPlanejado()));
				
				retorno.add(dto);
			}

		}
		
		return retorno;
	}
	
}