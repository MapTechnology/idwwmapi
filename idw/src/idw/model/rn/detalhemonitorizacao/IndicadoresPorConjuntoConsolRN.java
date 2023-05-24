package idw.model.rn.detalhemonitorizacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolhacic;
import idw.model.pojos.OmCfg;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;

public class IndicadoresPorConjuntoConsolRN extends AbstractRN<DAOGenerico> {

	private BigDecimal er;
	private BigDecimal ec;
	private BigDecimal ip;
	private BigDecimal ipd;
	private BigDecimal icavinat;
	private BigDecimal oee;
	private BigDecimal ir;
	private BigDecimal ipSemPeso;
	
	private BigDecimal producaoRNCiclo;
	private BigDecimal producaoNRParada;
	private BigDecimal producaoRefugada;
	private BigDecimal producaoNRci;
	
	private List<DwConsol> lista;
	private OmCfg omcfg;
	private FiltroDetalhePTInjetDTO filtro;
	
	public IndicadoresPorConjuntoConsolRN(DAOGenerico dao, List<DwConsol> lista, OmCfg omcfg, FiltroDetalhePTInjetDTO filtro) {
		super(dao);
		this.lista = lista;
		this.omcfg = omcfg;
		this.filtro = filtro;
		inicializarValores();
	}

	private void inicializarValores(){
		BigDecimal prodBruta = BigDecimal.ZERO;
		BigDecimal prodRef = BigDecimal.ZERO;
		BigDecimal prodPrev = BigDecimal.ZERO;
		Double segCicloMedio = 0d;
		Double tempoparadacp = 0d;
		Double tempoparadasp = 0d;
		Double tempoativo = 0d;
		
		Double tempoBoas = 0d;
		Double tempoRitmo = 0d;
		
		Date dthrITurnoMenor = null;
		Date dthrFTurnoMaior = null;

		Long perdaCiclo = 0l;
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		DwFolhacic dwFolhaCic;

		Double segcicloPadraoAux = 1d; // teve um caso no posto de reporcesso que o ciclo nao foi definido
		//Long qtPcsCiclo = 0l;
		Double tempoparada = 0d;
		Long perdaParada = 0l;
		Double perdaRefugo = 0d;

		Double qtPcsCicloAtivas = 0d;
		Double qtPcsCicloTotais = 0d;
		Double perdaPCI = 0d;
		
		Double tempodisponivelAux = 0d;
		
		Double producaoPorCicloAtivo = 0d;
		Double producaoPorCicloTotal = 0d;
	
		List<DwConsolid> ids = new ArrayList<>();
		Map<Long, String> mapIndPcsCiclo = new HashMap<Long, String>();
		
		
		for (DwConsol dwconsol : lista){
			ids.add(dwconsol.getDwConsolid());
			IndicadorCicloMedioRN cmRN = new IndicadorCicloMedioRN(omcfg,
					dwconsol.getDwConsolid().getOmPt(),
					dwconsol.getSegAutoCicloprodutivo(),
					dwconsol.getQtAutoCicloprodutivo(),
					dwconsol.getSegAutoTempoparadaSp());

			Double segCicloMedioAux = cmRN.calcularCicloMedio().doubleValue();
			segCicloMedio += segCicloMedioAux;
			
			prodBruta = AritmeticaUtil.somar(dwconsol.getPcsProducaoBruta(), prodBruta);

			prodRef = AritmeticaUtil.somar(dwconsol.getPcsProducaoRefugada(), prodRef);

			prodPrev = AritmeticaUtil.somar(dwconsol.getPcsAutoProducaoprevista(), prodPrev);
			prodPrev = AritmeticaUtil.somar(dwconsol.getPcsManuProducaoprevista(), prodPrev);

			perdaCiclo += dwconsol.getPcsAutoPerdaciclo() != null ? dwconsol.getPcsAutoPerdaciclo().longValue() : 0l;
			perdaCiclo += dwconsol.getPcsManuPerdaciclo() != null ? dwconsol.getPcsManuPerdaciclo().longValue() : 0l;

			perdaRefugo += dwconsol.getPcsAutoProducaorefugada() != null ? dwconsol.getPcsAutoProducaorefugada().doubleValue() : 0d;
			perdaRefugo += dwconsol.getPcsManuProducaorefugada() != null ? dwconsol.getPcsManuProducaorefugada().doubleValue() : 0d;

			if (dthrITurnoMenor == null || DataHoraRN.before(dwconsol.getDwConsolid().getDthrIturno(), dthrITurnoMenor))
				dthrITurnoMenor = dwconsol.getDwConsolid().getDthrIturno();
			
			if (dthrFTurnoMaior == null || DataHoraRN.after(dwconsol.getDwConsolid().getDthrFturno(), dthrFTurnoMaior))
				dthrFTurnoMaior = dwconsol.getDwConsolid().getDthrFturno();

			if (dwconsol.getSegAutoTempoparadaCp() == null) 
				dwconsol.setSegAutoTempoparadaCp(BigDecimal.ZERO);

			if (dwconsol.getSegAutoTempoparadaSp() == null) 
				dwconsol.setSegAutoTempoparadaSp(BigDecimal.ZERO);

			
			if (dwconsol.getSegAutoTempoativo() == null) 
				dwconsol.setSegAutoTempoativo(BigDecimal.ZERO);
			

			tempoparadacp += dwconsol.getSegAutoTempoparadaCp().doubleValue();
			tempoparadasp += dwconsol.getSegAutoTempoparadaSp().doubleValue();
			tempoativo += dwconsol.getSegAutoTempoativo().doubleValue();

			if (dwconsol.getSegAutoCiclopadrao() != null)
				segcicloPadraoAux = dwconsol.getSegAutoCiclopadrao().doubleValue();
			
			if (segcicloPadraoAux == null) {
				try {
					dwFolhaCic = folhaRN.getFolhacic(dwconsol.getDwConsolid().getDwFolha(), dwconsol.getDwConsolid().getOmPt());
					segcicloPadraoAux = dwFolhaCic.getSegCiclopadrao().doubleValue();
	
				} catch (SemCicloPadraoException e) {
					segcicloPadraoAux = dwconsol.getDwConsolid().getDwFolha().getSegCiclopadrao().doubleValue();
				}
			}
			
			// recupera pcs por ciclo ativas
			qtPcsCicloAtivas = 0d;
			qtPcsCicloTotais = 0d;
			
			
			//Marcos Sardinha: 2017-06-27 >> calcula de pcs por ciclo inativa considerando as diferentes flhas
			qtPcsCicloAtivas = (dwconsol.getQtAutoCavativas() == null ? 0d : dwconsol.getQtAutoCavativas().doubleValue());
			qtPcsCicloTotais = (dwconsol.getQtAutoCavtotal() == null ? 0d : dwconsol.getQtAutoCavtotal().doubleValue());
			
			if (mapIndPcsCiclo.containsKey(dwconsol.getDwConsolid().getDwFolha().getIdFolha()) == false) {
				producaoPorCicloAtivo += qtPcsCicloAtivas;
				producaoPorCicloTotal += qtPcsCicloTotais;		
				
				mapIndPcsCiclo.put(dwconsol.getDwConsolid().getDwFolha().getIdFolha(), dwconsol.getDwConsolid().getDwFolha().getCdFolha());
			}
			
			/*
			if (dwconsol.getQtAutoCavativas() != null)
				qtPcsCicloAtivas = dwconsol.getQtAutoCavativas().doubleValue();

			if (dwconsol.getQtAutoCavtotal() != null)
				qtPcsCicloTotais = dwconsol.getQtAutoCavtotal().doubleValue();
			
			if (qtPcsCicloAtivas == 0d) {
				try {
					if (dwconsol.getDwConsolid().getDwFolha().getDwFolharaps() != null) {
						for (DwFolharap rap : dwconsol.getDwConsolid().getDwFolha().getDwFolharaps()) {
							for (DwFolharapcom rapcom : rap.getDwFolharapcoms()) {
								qtPcsCicloAtivas += rapcom.getQtAtiva().doubleValue();
								qtPcsCicloTotais += rapcom.getQtTotal().doubleValue();
							}
						}
					}
	
				} catch (Exception e) {
					// se ocorrer erro considera cavidades como 1
					qtPcsCicloAtivas = 0d;
					qtPcsCicloTotais = 0d;
				}
			
				// Se ainda nao tiver as cavidades ativas, tentar novamente na folhaiac
				if (qtPcsCicloAtivas == 0d) {
					try {
						qtPcsCicloAtivas = folhaRN.getPcsPorCicloAtivas(dwconsol.getDwConsolid().getDwFolha()).doubleValue();
					} catch (SemPcsPorCicloAtivasException e) {
						qtPcsCicloAtivas = 1d;
					}
				}
	
				// se cavidades ativas for maior qt
				if (qtPcsCicloAtivas > qtPcsCicloTotais)
					qtPcsCicloTotais = qtPcsCicloAtivas;
				
			} */
			
			
			tempoparada = dwconsol.getSegAutoTempoparadaCp() != null ? dwconsol.getSegAutoTempoparadaCp().doubleValue() : 0d;
			perdaParada += FormulasInjet.calcularPcsPerdaParada(
					new BigDecimal(tempoparada),
					new BigDecimal(segcicloPadraoAux),
					new BigDecimal(qtPcsCicloAtivas)).longValue();

			/*

			qtCiclosExec = AritmeticaUtil.somar(
					dwconsol.getQtAutoCicloprodutivo() != null ? dwconsol.getQtAutoCicloprodutivo() : BigDecimal.ZERO,
					dwconsol.getQtManuCicloprodutivo() != null ? dwconsol.getQtManuCicloprodutivo() : BigDecimal.ZERO).longValue();

			perdaPCI += FormulasInjet.calcularPerdaCavidade(
					new BigDecimal(qtCiclosExec),
					new BigDecimal(qtPcsCicloTotais), 
					new BigDecimal(qtPcsCicloAtivas)).doubleValue();*/
			
			if (dwconsol.getPcsAutoPerdacavidades() == null) {
				dwconsol.setPcsAutoPerdacavidades(BigDecimal.ZERO);
			}
			if (dwconsol.getPcsManuPerdacavidades() == null) {
				dwconsol.setPcsManuPerdacavidades(BigDecimal.ZERO);
			}
			Long perdaPCIAux = dwconsol.getPcsAutoPerdacavidades().longValue() + dwconsol.getPcsManuPerdacavidades().longValue();
			perdaPCI += perdaPCIAux;
			
			//producaoPorCicloAtivo += qtPcsCicloAtivas;
			//producaoPorCicloTotal += qtPcsCicloTotais;
			
			
			BigDecimal tempoCicloProdutivoDwConsol = dwconsol.getSegAutoCicloprodutivo();
			Double tempoboasAux = 0d;
			Double temporitmoAux = 0d;
			BigDecimal cicloPadrao = dwconsol.getSegAutoCiclopadrao();
			if (cicloPadrao == null)
				cicloPadrao = BigDecimal.ZERO;

			double tempoRitmoAutoItemAux = FormulasInjet.calcularRitmo(
					tempoCicloProdutivoDwConsol,
					dwconsol.getQtAutoCicloprodutivo(), cicloPadrao,
					dwconsol.getSegAutoTempoparadaCpVr(),
					dwconsol.getSegAutoTempoparadaSpVr()).doubleValue();

			double tempoRitmoManuItemAux = FormulasInjet.calcularRitmo(
					dwconsol.getSegManuCicloprodutivo(),
					dwconsol.getQtManuCicloprodutivo(), cicloPadrao,
					dwconsol.getSegManuTempoparadaCpVr(),
					dwconsol.getSegManuTempoparadaSpVr()).doubleValue();

			if (dwconsol.getPcsProducaoBruta() != null && dwconsol.getPcsProducaoBruta().compareTo(BigDecimal.ZERO) > 0) {
				temporitmoAux += tempoRitmoAutoItemAux + tempoRitmoManuItemAux;
			} else {
				tempoRitmoAutoItemAux = 0d;
				tempoRitmoManuItemAux = 0d;
			}

			Double tempoBoasAutoItem = FormulasInjet.calcularTempoBoas(
					tempoCicloProdutivoDwConsol,
					dwconsol.getSegAutoTemporefugadas(),
					dwconsol.getSegAutoTempoparadaCpVr(),
					dwconsol.getSegAutoTempoparadaSpVr()).doubleValue();
			Double tempoBoasManuItem = FormulasInjet.calcularTempoBoas(
					dwconsol.getSegManuCicloprodutivo(),
					dwconsol.getSegManuTemporefugadas(),
					dwconsol.getSegManuTempoparadaCpVr(),
					dwconsol.getSegManuTempoparadaSpVr()).doubleValue();
			if (dwconsol.getPcsProducaoBruta() == null || dwconsol.getPcsProducaoBruta().doubleValue() == 0d) {
				tempoBoasAutoItem = 0d;
				tempoBoasManuItem = 0d;
			}

			tempoboasAux += tempoBoasAutoItem + tempoBoasManuItem;
			if (tempoboasAux < 0)
				tempoboasAux = 0d;


			tempoBoas += tempoboasAux;
			tempoRitmo += temporitmoAux;
			

			tempodisponivelAux += dwconsol.getSegAutoTempoativo() != null ? dwconsol.getSegAutoTempoativo().doubleValue() : 0l;
			tempodisponivelAux += dwconsol.getSegManuTempoativo() != null ? dwconsol.getSegManuTempoativo().doubleValue() : 0l;


		}
		
		BigDecimal producaoLiquida = AritmeticaUtil.diminuir(prodBruta, prodRef);
		
		
		// Obtem parada em aberto
		/*
		for (DwConsolpalog palog : paradasEmAberto) {
			int tempoParadasEmAberto = 0;
			// Se a parada em aberto tiver intersecao nos turnos avaliados entao
			// considera-la
			if (DataHoraRN.isIntersecao(palog.getDthrIparada(), DataHoraRN.getDataHoraAtual(), dthrITurnoMenor, dthrFTurnoMaior)) {
				Date inicio = palog.getDthrIparada().after(dthrITurnoMenor) ? palog.getDthrIparada() : dthrITurnoMenor;
				Date fim = DataHoraRN.getDataHoraAtual().before(dthrFTurnoMaior) ? DataHoraRN.getDataHoraAtual() : dthrFTurnoMaior;
				tempoParadasEmAberto += DataHoraRN.getQuantidadeSegundosNoPeriodo(inicio, fim);				
			}
		}
		*/
		
		if (tempoparadacp < 0d)
			tempoparadacp = 0d;
		
		Double tempoProdutivoAutoItem = FormulasInjet.calcularTempoprodutivas(new BigDecimal(tempoBoas), BigDecimal.ZERO, new BigDecimal(tempoRitmo)).doubleValue();
		if (prodBruta.longValue() <= 0l) {
			tempoProdutivoAutoItem = 0d;
		}

		// Calcular a eficiencia de ciclo
		
		IndicadoresDoDetalheCiclosRN irn = new IndicadoresDoDetalheCiclosRN(getDao());
		double cicloPadrao = 0;
		double cicloMedio = 0;

		if (IdwFacade.IS_IDW_ATIVO) {
			cicloPadrao = irn.calcularCicloPadrao(ids, filtro);
			cicloMedio = irn.calcularCicloMedio(ids, filtro);			 
		} else {
			cicloPadrao = irn.calcularCicloPadraoInjet(ids, filtro);
			cicloMedio = irn.calcularCicloMedioInjet(ids, filtro);			 			
		}
		
		
		ip = new BigDecimal(FormulasInjet.calcularIndiceParada(BigDecimal.valueOf(tempoparadacp), BigDecimal.valueOf(tempoativo)));
		ipSemPeso = new BigDecimal(FormulasInjet.calcularIndiceParada(BigDecimal.valueOf(tempoparadasp), BigDecimal.valueOf(tempoativo)));
		ec = new BigDecimal(FormulasInjet.calcularEficienciaCiclo(new BigDecimal(cicloPadrao), new BigDecimal(cicloMedio)));
		er = new BigDecimal(FormulasInjet.calcularEficienciaRealizacao(producaoLiquida, prodPrev));
		ipd = new BigDecimal(FormulasInjet.calcularIndicePerda(perdaCiclo.longValue(), perdaParada.longValue(), perdaRefugo.longValue(), perdaPCI.longValue(), prodPrev.longValue()));
		ir = new BigDecimal(FormulasInjet.calcularIndiceRefugo(perdaRefugo.longValue(), prodBruta.longValue()));
		
		oee = new BigDecimal(FormulasInjet.calcularOEE(BigDecimal.valueOf(tempoProdutivoAutoItem), BigDecimal.valueOf(tempodisponivelAux)).doubleValue());
		
		if (producaoPorCicloAtivo > 0d && producaoPorCicloTotal > 0d)
			icavinat = new BigDecimal(FormulasInjet.calcularIndiceCavidades(new BigDecimal(producaoPorCicloAtivo), new BigDecimal(producaoPorCicloTotal)));
		else
			icavinat = BigDecimal.ZERO;
		
		producaoRNCiclo = new BigDecimal(perdaCiclo);
		producaoNRParada = new BigDecimal(perdaParada);
		producaoRefugada = new BigDecimal(perdaRefugo);
		producaoNRci = new BigDecimal(perdaPCI);

	}

	public BigDecimal getEr() {
		return er;
	}

	public BigDecimal getEc() {
		return ec;
	}

	public BigDecimal getIp() {
		return ip;
	}

	public BigDecimal getIpd() {
		return ipd;
	}

	public BigDecimal getIcavinat() {
		return icavinat;
	}

	public BigDecimal getOee() {
		return oee;
	}

	public BigDecimal getProducaoRNCiclo() {
		return producaoRNCiclo;
	}

	public BigDecimal getProducaoNRParada() {
		return producaoNRParada;
	}

	public BigDecimal getProducaoRefugada() {
		return producaoRefugada;
	}

	public BigDecimal getProducaoNRci() {
		return producaoNRci;
	}

	public BigDecimal getIr() {
		return ir;
	}

	public BigDecimal getIpSemPeso() {
		return ipSemPeso;
	}


}
