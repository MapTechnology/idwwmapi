package idw.model.rn.detalhemonitorizacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRt;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.TempoRealRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;

public class IndicadoresDoDetalheCiclosRN extends AbstractRN<DAOGenerico> {

	public IndicadoresDoDetalheCiclosRN(DAOGenerico dao) {
		super(dao);
	}

	/*
	 * O calculo do ciclo padrao depender� do filtro passado a tela do detalhe.
	 * Caso seja solicitado a partir da ficha da maquina. O ciclo padr�o
	 * considerado ser� sempre o mais atual Caso seja solicitado a partir do BI
	 * deve-se considerar a media dos ciclos entre as varias ocorrencias de PTs
	 * do BI e datas
	 */
	public Double calcularCicloPadrao(List<DwConsolid> ids, FiltroDetalhePTInjetDTO filtro) {
		Double retorno = 0d;

		if (filtro.getDtReferencia() != null) {
			return retorno = getCicloPadraoDetalhePT(ids);
			
		} else if (filtro.getTpId() != null) {
			if (filtro.getTpId().equals(DwConsolidTemplate.TpId.ACUMULADO.getValue()) || filtro.getTpId().equals(DwConsolidTemplate.TpId.OP.getValue())) {
				retorno = getCicloPadraoDetalhePT(ids);
			}
		}

		if (filtro.getDtReferenciaInicial() != null) {
			retorno = getCicloPadraoBI(ids);
		} else {
			//Marcos Sardinha: 2017-08-25 >> Defeito #4404 >> ciclo padrao nao tava sendo calculado para acomp producao - tpid = null
			retorno = getCicloPadraoBI(ids);
		}
		
		
		return retorno;
	}

	private Double getCicloPadraoDetalhePT(List<DwConsolid> ids) {
		// Ordena a lista para pegar o ciclo pdarao da ultima situacao
		Collections.sort(ids, new Comparator<DwConsolid>() {
			@Override
			public int compare(DwConsolid o1, DwConsolid o2) {
				return (o1.getIdConsolid() < o2.getIdConsolid() ? -1 : o1
						.getIdConsolid() > o2.getIdConsolid() ? 1 : 0) * -1;
			}
		});

		DwConsolid id = null;
		if (ids.size() > 0) {
			id = ids.get(0);
		} else
			return 0d;

		DwConsol dwconsol = null;
		for (DwConsol c : id.getDwConsols()) {
			dwconsol = c;
			break;
		}
		double retorno = 0d;
		if (dwconsol != null && dwconsol.getSegAutoCiclopadrao() != null)
			retorno = dwconsol.getSegAutoCiclopadrao().doubleValue();
		
		return retorno;
	}

	private Double getCicloPadraoBI(List<DwConsolid> ids) {
		List<DwFolha> listaFolhas = new ArrayList<>();
		FolhaRN rn = new FolhaRN(getDao());
	
		long folhaId = -1;
		Date dthrIVal = null;
		BigDecimal segCicloPadraoAux = BigDecimal.ZERO;
		for (DwConsolid id : ids) {
			
			if (listaFolhas.contains(id.getDwFolha()))
				continue;
			try {
				
				if (IdwFacade.getInstancia().isIDWAtivo()) {				
					if( id.getDwFolha().getId() >  folhaId ){
					
						segCicloPadraoAux = rn.getCicloPadrao(id.getDwFolha(), id.getOmPt());
						
						folhaId = id.getDwFolha().getId();
					
					}
				} else {
					if (dthrIVal == null) {
						dthrIVal = id.getDwFolha().getDtRevisao();
						segCicloPadraoAux = rn.getCicloPadrao(id.getDwFolha(), id.getOmPt());
					} else {
						if (DataHoraRN.after(id.getDwFolha().getDtRevisao(), dthrIVal)) {
							dthrIVal = id.getDwFolha().getDtRevisao();
							segCicloPadraoAux = rn.getCicloPadrao(id.getDwFolha(), id.getOmPt());							
						}
					}
				}
				
			} catch (SemCicloPadraoException e) {
				continue;
			}
		}
		return segCicloPadraoAux.doubleValue();
	}

	/*
	 * O ciclo medio tamb�m dever� considerar o filtro da mesma forma que o
	 * ciclo padrao
	 */
	public Double calcularCicloMedio(List<DwConsolid> ids,
			FiltroDetalhePTInjetDTO filtro) {
		Double retorno = 0d;
		if (filtro.getDtReferencia() != null) {
			Double cicloPadrao = getCicloPadraoDetalhePT(ids);
			retorno = getCicloMediParaCicloPadrao(ids, cicloPadrao);
		} else if (filtro.getTpId() != null) {

			if (filtro.getTpId().equals(
					DwConsolidTemplate.TpId.ACUMULADO.getValue())
					|| filtro.getTpId().equals(
							DwConsolidTemplate.TpId.OP.getValue())) {

				Double cicloPadrao = getCicloPadraoDetalhePT(ids);
				retorno = getCicloMediParaCicloPadrao(ids, cicloPadrao);

			}

		}
		if (filtro.getDtReferenciaInicial() != null) {
			retorno = getCicloMediParaCicloPadrao(ids, null);
		}  else {
			//Marcos Sardinha: 2017-08-25 >> Defeito #4404 >> ciclo padrao nao tava sendo calculado para acomp producao - tpid = null
			retorno = getCicloMediParaCicloPadrao(ids, null);
		}
		
		return retorno;
	}

	private Double getCicloMediParaCicloPadrao(List<DwConsolid> ids, Double segCicloPadrao) {
		BigDecimal segAutoTempoCicloProdutivo = BigDecimal.ZERO;
		BigDecimal segAutoQtCicloProdutivo = BigDecimal.ZERO;
		BigDecimal segAutoTempoparadasp = BigDecimal.ZERO;

		for (DwConsolid id : ids) {
			for (DwConsol consol : id.getDwConsols()) {
				// Se segCicloPadrao for passado entao calcular o ciclo medio
				// apenas qdo for do ciclo padrao solicitado.
				if (consol.getSegAutoCiclopadrao() == null)
					continue;
				
				if (segCicloPadrao != null && segCicloPadrao.equals(consol.getSegAutoCiclopadrao().doubleValue()) == false)
					continue;
				
				if (consol.getSegAutoCicloprodutivo() != null)
					segAutoTempoCicloProdutivo = segAutoTempoCicloProdutivo
							.add(consol.getSegAutoCicloprodutivo());
				if (consol.getQtAutoCicloprodutivo() != null)
					segAutoQtCicloProdutivo = segAutoQtCicloProdutivo
							.add(consol.getQtAutoCicloprodutivo());
				if (consol.getSegAutoTempoparadaSp() != null)
					segAutoTempoparadasp = segAutoTempoparadasp.add(consol
							.getSegAutoTempoparadaSp());
			}
		}
		IndicadorCicloMedioRN rn = new IndicadorCicloMedioRN(null, null,
				segAutoTempoCicloProdutivo, segAutoQtCicloProdutivo,
				segAutoTempoparadasp);

		return rn.calcularCicloMedio().doubleValue();
	}

	public Double getUltimoCiclo(List<DwConsolid> ids, FiltroDetalhePTInjetDTO filtro) {
		DwRt dwrt = null;
		TempoRealRN crn = new TempoRealRN(getDao());

		if (filtro.getTpId() != null && filtro.getTpId().equals(DwConsolidTemplate.TpId.ACUMULADO.getValue()) ) {
			dwrt = crn.getDwRt(
					filtro.getDtReferencia(), 
					filtro.getDwTurno().getIdTurno(), 
					filtro.getOmPt().getIdPt(),
					filtro.getPpCp(), 
					null);
		} else if (filtro.getTpId() != null && filtro.getTpId().equals(DwConsolidTemplate.TpId.OP.getValue())) {
			if (filtro.getCdCp() != null && filtro.getCdCp().equals("") == false)
				dwrt = crn.getUltimoDwRtByCdCp(filtro.getCdCp());
			else if (filtro.getIdCp() > 0)
				dwrt = crn.getUltimoDwRtByIdCp(filtro.getIdCp());
		} else {
			dwrt = getUltimoDwRt(ids);
		}

		if (dwrt != null && dwrt.getSegUltimociclo() != null)
			return dwrt.getSegUltimociclo().doubleValue();

		return 0d;
	}

	private DwRt getUltimoDwRt(List<DwConsolid> ids) {
		DwRt dwrt = null;
		for (DwConsolid id : ids) {
			if (dwrt == null)
				dwrt = id.getDwRt();

			if (id.getDwRt() != null && id.getDwRt().getDthrHeartbeat() != null
					&& dwrt.getDthrHeartbeat() != null) {
				if (DataHoraRN.after(id.getDwRt().getDthrHeartbeat(), dwrt.getDthrHeartbeat()))
					dwrt = id.getDwRt();
			} else if (id.getDwRt() != null
					&& id.getDwRt().getIdRt() > dwrt.getIdRt()) {
				dwrt = id.getDwRt();
			}
		}
		return dwrt;
	}
	
	public Double calcularCicloPadraoInjet(List<DwConsolid> ids, FiltroDetalhePTInjetDTO filtro) {
		Double retorno = 0d;
		BigDecimal somaCiclosPadrao = BigDecimal.ZERO;
		Double qtdItensMedia = 0d;
		
		class FicTec {
			String cdMaquina;
			String cdFolha;
			String dthrIVal;
			BigDecimal segCicloPadrao = BigDecimal.ZERO;
			BigDecimal segCiclosNormais = BigDecimal.ZERO;
			BigDecimal qtdCiclosNormais = BigDecimal.ZERO;
			BigDecimal segCicloMedio = BigDecimal.ZERO;
		}
		
		Map<String, FicTec> mapFicTec = new HashMap<String, FicTec>();
		
		for (DwConsolid id : ids) {
			FicTec ficTec = new FicTec();
			ficTec.cdMaquina = id.getOmPt().getCdPt();
			ficTec.cdFolha = id.getDwFolha().getCdFolha();
			ficTec.dthrIVal = DataHoraRN.dateToStringYYYYMMDDHHMMSS(id.getDwFolha().getDtRevisao());
			
			String keyFicTec = ficTec.cdMaquina + " " + ficTec.cdFolha + " " + ficTec.dthrIVal;

			ficTec.segCicloPadrao = id.getDwConsol().getSegAutoCiclopadrao();
			ficTec.segCiclosNormais = id.getDwConsol().getSegAutoCicloprodutivo();
			ficTec.qtdCiclosNormais = id.getDwConsol().getQtAutoCicloprodutivo();
			ficTec.segCicloMedio = FormulasInjet.calcularCicloMedio(ficTec.segCiclosNormais, ficTec.qtdCiclosNormais);
			
			if (! mapFicTec.containsKey(keyFicTec)) {
				mapFicTec.put(keyFicTec, ficTec);			
			} else {
				ficTec = new FicTec();
				ficTec = mapFicTec.get(keyFicTec);				
				mapFicTec.remove(keyFicTec);
				
				ficTec.segCiclosNormais = AritmeticaUtil.somar(ficTec.segCiclosNormais, id.getDwConsol().getSegAutoCicloprodutivo());
				ficTec.qtdCiclosNormais = AritmeticaUtil.somar(ficTec.qtdCiclosNormais, id.getDwConsol().getQtAutoCicloprodutivo());
				ficTec.segCicloMedio = FormulasInjet.calcularCicloMedio(ficTec.segCiclosNormais, ficTec.qtdCiclosNormais);				
				
				mapFicTec.put(keyFicTec, ficTec);;
			}
		}
		
		Set<String> validades = mapFicTec.keySet();
		for (String keyVal : validades) {
			FicTec ficTec = mapFicTec.get(keyVal);
			
			if (ficTec.segCicloPadrao.doubleValue() > 0 && ficTec.segCicloMedio.doubleValue() > 0 && ficTec.qtdCiclosNormais.doubleValue() > 0){
				qtdItensMedia = qtdItensMedia + 1;
				somaCiclosPadrao = AritmeticaUtil.somar(somaCiclosPadrao, ficTec.segCicloPadrao);
			}
		}

		if (mapFicTec.size() > 0 && qtdItensMedia > 0) {
			retorno = somaCiclosPadrao.doubleValue() / qtdItensMedia;
			
		}
		
		return retorno;
	}

	public Double calcularCicloMedioInjet(List<DwConsolid> ids, FiltroDetalhePTInjetDTO filtro) {
		Double retorno = 0d;
		BigDecimal somaCiclosMedio = BigDecimal.ZERO;
		Double qtdItensMedia = 0d;
		
		class FicTec {
			String cdMaquina;
			String cdFolha;
			String dthrIVal;
			BigDecimal segCicloPadrao = BigDecimal.ZERO;
			BigDecimal segCiclosNormais = BigDecimal.ZERO;
			BigDecimal qtdCiclosNormais = BigDecimal.ZERO;
			BigDecimal segCicloMedio = BigDecimal.ZERO;
		}
		
		Map<String, FicTec> mapFicTec = new HashMap<String, FicTec>();
		
		for (DwConsolid id : ids) {
			FicTec ficTec = new FicTec();
			ficTec.cdMaquina = id.getOmPt().getCdPt();
			ficTec.cdFolha = id.getDwFolha().getCdFolha();
			ficTec.dthrIVal = DataHoraRN.dateToStringYYYYMMDDHHMMSS(id.getDwFolha().getDtRevisao());
			
			String keyFicTec = ficTec.cdMaquina + " " + ficTec.cdFolha + " " + ficTec.dthrIVal;

			ficTec.segCicloPadrao = id.getDwConsol().getSegAutoCiclopadrao();
			ficTec.segCiclosNormais = id.getDwConsol().getSegAutoCicloprodutivo();
			ficTec.qtdCiclosNormais = id.getDwConsol().getQtAutoCicloprodutivo();
			ficTec.segCicloMedio = FormulasInjet.calcularCicloMedio(ficTec.segCiclosNormais, ficTec.qtdCiclosNormais);
			
			if (! mapFicTec.containsKey(keyFicTec)) {
				mapFicTec.put(keyFicTec, ficTec);			
			} else {
				ficTec = new FicTec();
				ficTec = mapFicTec.get(keyFicTec);				
				mapFicTec.remove(keyFicTec);
				
				ficTec.segCiclosNormais = AritmeticaUtil.somar(ficTec.segCiclosNormais, id.getDwConsol().getSegAutoCicloprodutivo());
				ficTec.qtdCiclosNormais = AritmeticaUtil.somar(ficTec.qtdCiclosNormais, id.getDwConsol().getQtAutoCicloprodutivo());
				ficTec.segCicloMedio = FormulasInjet.calcularCicloMedio(ficTec.segCiclosNormais, ficTec.qtdCiclosNormais);				
				
				mapFicTec.put(keyFicTec, ficTec);;
			}
		}
		
		Set<String> validades = mapFicTec.keySet();
		for (String keyVal : validades) {
			FicTec ficTec = mapFicTec.get(keyVal);
			
			if (ficTec.segCicloPadrao.doubleValue() > 0 && ficTec.segCicloMedio.doubleValue() > 0 && ficTec.qtdCiclosNormais.doubleValue() > 0){
				qtdItensMedia = qtdItensMedia + 1;
				somaCiclosMedio = AritmeticaUtil.somar(somaCiclosMedio, ficTec.segCicloMedio);
			}
		}

		if (mapFicTec.size() > 0 && qtdItensMedia > 0) {
			retorno = somaCiclosMedio.doubleValue() / qtdItensMedia;
		}
		
		return retorno;
	}
}
