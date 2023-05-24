package idw.model.rn.relatorios.R100;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import idw.model.excessoes.SemPacoteOuFatorException;
import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwFolha;
import idw.model.pojos.OmPt;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.detalhemonitorizacao.IndicadorCicloMedioRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import ms.util.ConversaoTipos;

public class RelatorioR100DTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<LinhaDetalheR100DTO> linhas = new ArrayList<>();

	public List<LinhaDetalheR100DTO> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<LinhaDetalheR100DTO> linhas) {
		this.linhas = linhas;
	}
	
	public void limpaLinhasComProducaoZerada(){
		List<LinhaDetalheR100DTO> retorno = new ArrayList<>();
		for(LinhaDetalheR100DTO dtoAux : linhas){
			if (dtoAux.getProducaoBruta().equals(BigDecimal.ZERO) == false)
				retorno.add(dtoAux);
		}
		this.linhas = retorno;
	}
	
	public void addId(DwConsolid id, FolhaRN rn) {
		DwConsol dwconsol = id.getDwConsol();
		LinhaDetalheR100DTO dto = null;
		
		for (LinhaDetalheR100DTO dtoAux : linhas) {
			if (dtoAux.getLinha().equals(id.getOmPt().getOmGt().getCdGt() + " (" + id.getOmPt().getCdPt() + ")")
					&& dtoAux.getModelosDoPeriodo().contains(id.getDwFolha().getCdFolha())) {
				dto = dtoAux;
				break;
			}
		}
		if (dto == null) {
			dto = new LinhaDetalheR100DTO();
			dto.setDtReferencia(id.getDtReferencia());
			dto.setDsTurno(id.getDwTurno().getCdTurno());
			dto.setLinha(id.getOmPt().getOmGt().getCdGt() + " (" + id.getOmPt().getCdPt() + ")");
			dto.setProducaoBruta(BigDecimal.ZERO);
			dto.setProducaoLiquida(BigDecimal.ZERO);
			dto.setProducaoPerdida(BigDecimal.ZERO);
			linhas.add(dto);
		} else {
			if (dto.getDsTurno().contains(id.getDwTurno().getCdTurno()) == false) {
				dto.setDsTurno(dto.getDsTurno() + ", " + id.getDwTurno().getCdTurno());
			}
		}
		
		dto.setProducaoBruta(dto.getProducaoBruta().add(dwconsol.getPcsProducaoBruta()));
		dto.setProducaoLiquida(dto.getProducaoLiquida().add(dwconsol.getPcsProducaoLiquida()));
		dto.setProducaoPerdida(AritmeticaUtil.somar(dto.getProducaoPerdida(), dwconsol.getPcsAutoPerdacavidades()));
		dto.setProducaoPerdida(AritmeticaUtil.somar(dto.getProducaoPerdida(), dwconsol.getPcsAutoPerdaciclo()));
		dto.setProducaoPerdida(AritmeticaUtil.somar(dto.getProducaoPerdida(), dwconsol.getPcsAutoPerdaparadaCp()));
		dto.setProducaoPerdida(AritmeticaUtil.somar(dto.getProducaoPerdida(), dwconsol.getPcsProducaoRefugada()));

		// Recalcular producao prevista por produto acumulando. Nao utilizar a consolidada devido ao fator de contagem
		DwFolha folhaId = id.getDwFolha();
		OmPt ptId = id.getOmPt();
		
		BigDecimal fatorContagem = BigDecimal.ONE;
		try {
			fatorContagem = rn.getFatorContagemFromDwFolha(folhaId, ptId);
		} catch (SemPacoteOuFatorException e1) {
			// TODO Auto-generated catch block
		}
		BigDecimal segTempoAtivo_pro = AritmeticaUtil.somar((dwconsol.getSegAutoTempoativo() == null ? BigDecimal.ZERO : dwconsol.getSegAutoTempoativo()),
				    (dwconsol.getSegManuTempoativo() == null ? BigDecimal.ZERO : dwconsol.getSegManuTempoativo()));

		for (DwConsolpr consolpr : dwconsol.getDwConsolprs()) {
			BigDecimal qtPcsCicloAtivas_pro = BigDecimal.ZERO;
			try {
				qtPcsCicloAtivas_pro = rn.getPcsPorCicloAtivas(folhaId, consolpr.getOmProduto());
			} catch (SemPcsPorCicloAtivasException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			BigDecimal pcsProdPrev_pro = FormulasInjet.calcularProducaoPrevista(
					segTempoAtivo_pro, 
					dwconsol.getSegAutoCiclopadrao(), 
					qtPcsCicloAtivas_pro, 
					fatorContagem,
					ptId.getIndOee());

			if (dto.getProducaoPrevista() == null)
				dto.setProducaoPrevista(BigDecimal.ZERO);
			
			dto.setProducaoPrevista(dto.getProducaoPrevista().add(pcsProdPrev_pro));
		}
		dto.setEr(ConversaoTipos.converteParaDouble(FormulasInjet.calcularEficienciaRealizacao(dto.getProducaoLiquida(), dto.getProducaoPrevista()), 2));
		

		/* Adicionar as paradas do id */
		for (DwConsolpa pa : dwconsol.getDwConsolpas()) {
			if (pa.isRegistroInvalido())
				continue;
			// se for parada sem peso, descartar
			if (pa.getDwTParada().getIsPesa() == false)
				continue;
			
			ParadasR100DTO parada = null;
			for (ParadasR100DTO parDTO : dto.getParadas()) {
				if (parDTO.getCdParada().equals(pa.getDwTParada().getCdTparada())) {
					parada = parDTO;
					break;
				}
			}
			if (parada == null) {
				parada = new ParadasR100DTO();
				parada.setCdParada(pa.getDwTParada().getCdTparada());
				parada.setDsParada(pa.getDwTParada().getDsTparada());
				parada.setTempoParada(0d);
				dto.getParadas().add(parada);
			}

			if (pa.getSegAutoTempoparadaCp() != null)
				parada.setTempoParada(parada.getTempoParada() + pa.getSegAutoTempoparadaCp().doubleValue());
			
			parada.setTempoParadaFormatada(DataHoraRN.formatSegundosParaHHMMSS(parada.getTempoParada().intValue()));
			
		}
		/* Adicionar o ciclo padrão e o ciclo médio */
		BigDecimal segCicloPadrao = BigDecimal.ZERO;
		if (dwconsol.getSegAutoCiclopadrao() != null) {
			segCicloPadrao = dwconsol.getSegAutoCiclopadrao();
	    }
		// Encontrar o dto do ciclo padrao
		CiclosR100DTO ciclodto = null;
		for (CiclosR100DTO cicloauxdto : dto.getCiclos()) {
			if (cicloauxdto.getCicloPadrao().equals(segCicloPadrao)) {
				ciclodto = cicloauxdto;
			}
		}
		if (ciclodto == null) {
			ciclodto = new CiclosR100DTO();
			dto.getModelosDoPeriodo().add(id.getDwFolha().getCdFolha());
			ciclodto.setCicloDoProduto(id.getDwFolha().getCdFolha());
			ciclodto.setCicloPadrao(segCicloPadrao);
			ciclodto.setCicloMedio(BigDecimal.ZERO);
			ciclodto.setSegAutoTempoCicloProdutivo(BigDecimal.ZERO);
			ciclodto.setSegAutoQtCicloProdutivo(BigDecimal.ZERO);
			dto.getCiclos().add(ciclodto);
		}
		BigDecimal tempoCicloProdutivoDwConsol = dwconsol.getSegAutoCicloprodutivo();
		
		if (dwconsol.getQtAutoCicloprodutivo() != null) {
			ciclodto.setSegAutoQtCicloProdutivo(ciclodto.getSegAutoQtCicloProdutivo().add(dwconsol.getQtAutoCicloprodutivo()));
			ciclodto.setSegAutoTempoCicloProdutivo(ciclodto.getSegAutoTempoCicloProdutivo().add(tempoCicloProdutivoDwConsol));
			IndicadorCicloMedioRN cmRN = new IndicadorCicloMedioRN(
					null, 
					id.getOmPt(), 
					ciclodto.getSegAutoTempoCicloProdutivo(),
					ciclodto.getSegAutoQtCicloProdutivo(), 
					null);
	
			// Avalia se o ciclo padrao já existe
			ciclodto.setCicloMedio(cmRN.calcularCicloMedio());
		}
		
		// Soma total de paradas com peso NAO apenas as 5 mostradas
		if (dwconsol.getSegAutoTempoparadaCp() != null) {
			dto.setTotalParada(dto.getTotalParada() + dwconsol.getSegAutoTempoparadaCp().doubleValue());
			dto.setTotalParadaFormatada(DataHoraRN.formatSegundosParaHHMMSS(dto.getTotalParada().intValue()));
		}
	}
}
