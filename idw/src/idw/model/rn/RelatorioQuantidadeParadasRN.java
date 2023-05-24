package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTParada;
import idw.webservices.dto.FiltroRelatorioIndiceParadasDTO;
import idw.webservices.dto.ListaRelatorioQuantidadeParadasDTO;
import idw.webservices.dto.RelatorioQuantidadeParadasDTO;

public class RelatorioQuantidadeParadasRN extends AbstractParadaRN {
	
	private final FiltroRelatorioIndiceParadasDTO filtro;
	private List<Object> listaFiltroArea = new ArrayList<Object>();
	private List<Object> listaFiltroParada = new ArrayList<Object>();
	private List<DwConsolpa> listaDaConsultaDoBanco = new ArrayList<>();
	private HashMap<String, RelatorioQuantidadeParadasDTO> mapChaveParadaEAreaResponsavel = new HashMap<>();
	private Double tempoTotalParadasCP = 0d;
	private Double tempoTotalParadasSP = 0d;
	private int quantidadeTotalParadas = 0;
	private ListaRelatorioQuantidadeParadasDTO dto = new ListaRelatorioQuantidadeParadasDTO();

	public RelatorioQuantidadeParadasRN(FiltroRelatorioIndiceParadasDTO filtro) {
		this(filtro, null);
	}
	
	public RelatorioQuantidadeParadasRN(FiltroRelatorioIndiceParadasDTO filtro, DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
		this.filtro = filtro;
	}
	
	public ListaRelatorioQuantidadeParadasDTO gerarRelatorio() {
		preencherListaDeFiltros();
		consultarBanco();
		gerarDTO();
		return this.dto;
	}

	private void preencherListaDeFiltros() {
		boolean isGerarListaFiltroTodasAsParadas = 
				filtro.getIsTodasParadas() == false 
				&& filtro.getDwTParadas() != null;
		if(isGerarListaFiltroTodasAsParadas) {
			for(DwTParada parada : filtro.getDwTParadas()) {
				this.listaFiltroParada.add(parada.getCdTparada());
			}
		}
		
		boolean isGerarListaFiltroTodasAsAreas = 
				filtro.getIsTodasAreas() == false 
				&& filtro.getDwTAreas() != null;
		if(isGerarListaFiltroTodasAsAreas) {
			for(DwTArea area : filtro.getDwTAreas()) {
				this.listaFiltroArea.add(area.getCdArea());
			}
		}
	}
	
	private void consultarBanco() {
		MapQuery q = new MapQuery(getDaoSession());
		q.novaConsulta();
		q.append("SELECT DISTINCT consolpa");
		q.append("FROM DwConsolid consolid");		
		q.append("JOIN consolid.omPt ompt");
		q.append("JOIN consolid.dwFolha folha");
		
		q.append("JOIN consolid.dwConsols consol");
		q.append("JOIN consol.dwConsolpas consolpa");		
		q.append("JOIN consolpa.dwConsolpaocos ocorrencia");
		
		q.append("JOIN consolid.ppCp ppcp");
		q.append("JOIN ppcp.ppCpprodutos ppcpproduto");		
		
		q.append("JOIN consolpa.dwTParada parada");		
		q.append("LEFT JOIN parada.dwTArea area");
		
		q.append("LEFT JOIN ompt.omObjs obj");
		q.append("LEFT JOIN obj.omGtByIdGt gt");
		
		q.append("LEFT JOIN folha.dwFolharaps folharap");
		q.append("LEFT JOIN folharap.dwRap rap");
		q.append("LEFT JOIN rap.dwRapGrupos rapgrupo");
		q.append("LEFT JOIN rapgrupo.dwGrupoFerramenta gpferramenta");

		q.append("WHERE consolid.tpId = :tpId");

		if (filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null) {
			q.append("AND consolid.dtReferencia BETWEEN :dataincial AND :datafinal");
		}
		if (filtro.getCdop() != null) {
			q.append("AND ppcpproduto.nrDoc = :cdop");
		}
		if (filtro.getTurnoDTO() != null) {
			q.append("AND consolid.dwTurno.idTurno = :idturno");
		} else {
			q.append("AND consolid.dwTurno.idTurno != 1");
		}
		if (filtro.getOmpt() != null) {
			q.append("AND consolid.omPt.idPt = :idpt");
		}
		if (filtro.getOmgt() != null) {
			q.append("AND gt.idGt = :idgt");
		}
		if (filtro.getDwRap() != null) {
			q.append("AND rap.idRap = :idrap");
		}
		if (filtro.getDwGrupoFerramenta() != null) {
			q.append("AND gpferramenta.idGrupoFerramenta = :idgpRap");
		}
		
		if(!listaFiltroParada.isEmpty()) {
			q.append("AND parada.cdTparada IN (:paradas)");
		}
		
		if(!listaFiltroArea.isEmpty()) {
			q.append("AND area.cdArea IN (:areas)");
		}	

		q.defineParametro("tpId", (byte) 1);
		if (filtro.getCdop() != null) {
			q.defineParametro("cdop", filtro.getCdop());
		}

		if (filtro.getDwGrupoFerramenta() != null) {
			q.defineParametro("idgpRap", filtro.getDwGrupoFerramenta()
					.getIdGrupoFerramenta());
		}
		if (filtro.getDwRap() != null) {
			q.defineParametro("idrap", filtro.getDwRap().getIdRap());
		}
		if (filtro.getOmgt() != null) {
			q.defineParametro("idgt", filtro.getOmgt().getIdGt());
		}
		if (filtro.getOmpt() != null) {
			q.defineParametro("idpt", filtro.getOmpt().getIdPt());

		}
		if (filtro.getTurnoDTO() != null) {
			q.defineParametro("idturno", filtro.getTurnoDTO().getTurno()
					.getIdTurno());
		}
		
		if(!listaFiltroParada.isEmpty()) {
			q.defineListaParametro("paradas", listaFiltroParada);
		}
		
		if(!listaFiltroArea.isEmpty()) {
			q.defineListaParametro("areas", listaFiltroArea);
		}
		
		if (filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null) {
			q.defineParametroData("dataincial", DataHoraRN.getDataHoraInicial(filtro.getPeriodoInicial()));
			q.defineParametroData("datafinal", DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));
		}
		
		this.listaDaConsultaDoBanco = q.list();
	}
	
	private void gerarDTO() {
		preencherAsLinhasDoDTO();
		calcularQuantidadeDeCadaParada();
		preencherOsTotaisDoDTO();
		ordenarLinhasDTO();		
		preencherONumeroDaLinha();
	}
	
	private void preencherAsLinhasDoDTO() {
		for (DwConsolpa dwConsolpa : listaDaConsultaDoBanco) {
			
			boolean ignorarDwConsolpa = 
					dwConsolpa.getSegAutoTempoparadaCp() == null 
					&& dwConsolpa.getSegAutoTempoparadaSp() == null;
			if (ignorarDwConsolpa) {
				continue;
			}			
			
			double somaParadaSpAutoEManuUni = 0;
			double somaParadaCPAutoEManuUni = 0;
			if (dwConsolpa.getDwTParada().getIsPesa() != null && dwConsolpa.getDwTParada().getIsPesa() == false) {
	            double SegAutoTempoparadaSpUni = dwConsolpa.getSegAutoTempoparadaSp() != null ? dwConsolpa.getSegAutoTempoparadaSp().doubleValue() : 0d;
	            double SegManuTempoparadaSpUni = dwConsolpa.getSegManuTempoparadaSp() != null ? dwConsolpa.getSegManuTempoparadaSp().doubleValue() : 0d;
	            somaParadaSpAutoEManuUni = SegAutoTempoparadaSpUni + SegManuTempoparadaSpUni;
	            if(somaParadaSpAutoEManuUni > 0) {
	            	tempoTotalParadasSP = tempoTotalParadasSP.doubleValue() + somaParadaSpAutoEManuUni;
	            }
	        } else {
	            double SegAutoTempoparadaCpUni = dwConsolpa.getSegAutoTempoparadaCp() != null ? dwConsolpa.getSegAutoTempoparadaCp().doubleValue() : 0d;
	            double SegManuTempoparadaCpUni = dwConsolpa.getSegManuTempoparadaCp() != null ? dwConsolpa.getSegManuTempoparadaCp().doubleValue() : 0d;
	            somaParadaCPAutoEManuUni = SegAutoTempoparadaCpUni + SegManuTempoparadaCpUni;
	            if(somaParadaCPAutoEManuUni > 0){
	            	tempoTotalParadasCP = tempoTotalParadasCP.doubleValue() + somaParadaCPAutoEManuUni;
	            }
	        }
			
			BigDecimal tempo = somaParadaSpAutoEManuUni == 0 ? new BigDecimal(somaParadaCPAutoEManuUni) : new BigDecimal(somaParadaSpAutoEManuUni);
			String parada = dwConsolpa.getDwTParada() != null ? dwConsolpa.getDwTParada().getCdTparada() + "-" + dwConsolpa.getDwTParada().getDsTparada() : "";
			String areaResp = dwConsolpa.getDwTParada().getDwTArea() != null ? dwConsolpa.getDwTParada().getDwTArea().getCdArea() + "-" + dwConsolpa.getDwTParada().getDwTArea().getDsArea() : "";
			String chave = getChaveParadaEAreaResponsavel(dwConsolpa.getDwTParada());
						
			RelatorioQuantidadeParadasDTO linha = mapChaveParadaEAreaResponsavel.get(chave);
			
			if(linha == null) {
				linha = new RelatorioQuantidadeParadasDTO();
				linha.setParada(parada);
				linha.setAreaResp(areaResp);
				linha.setQuantidade("0");
				linha.setDuracao(tempo);
				mapChaveParadaEAreaResponsavel.put(chave, linha);
			} else {
				BigDecimal tempoAux = linha.getDuracao();
				tempoAux = new BigDecimal(tempoAux.doubleValue() + tempo.doubleValue());
				linha.setDuracao(tempoAux);
				linha.setQuantidade(String.valueOf(0));
			}
		}
	}
	
	private void calcularQuantidadeDeCadaParada() {
		Set<DwConsolpalog> dwConsolpalogs = new HashSet<DwConsolpalog>();
		for(DwConsolpa pa : listaDaConsultaDoBanco) {
			for(DwConsolpaoco oco : pa.getDwConsolpaocos()) {
				dwConsolpalogs.add(oco.getDwConsolpalog());
			}
		}
		
		for(DwConsolpalog log : dwConsolpalogs) {
			String chave = getChaveParadaEAreaResponsavel(log.getDwTParada());
			RelatorioQuantidadeParadasDTO linha = mapChaveParadaEAreaResponsavel.get(chave);
			int quantidadeDaLinha = Integer.parseInt(linha.getQuantidade());
			quantidadeDaLinha++;
			this.quantidadeTotalParadas++;
			linha.setQuantidade(String.valueOf(quantidadeDaLinha));
		}
	}
	
	private String getChaveParadaEAreaResponsavel(DwTParada parada) {		
		if(parada == null) {
			return "";
		}
		
		if(parada.getDwTArea() == null) {
			return parada.getCdTparada() + "|";
		}
		
		return parada.getCdTparada() + "|" + parada.getDwTArea().getCdArea();
	}

	private void preencherOsTotaisDoDTO() {
		Double totalTempoTodasParadas = this.tempoTotalParadasCP + this.tempoTotalParadasSP;
		
		this.dto = new ListaRelatorioQuantidadeParadasDTO();
		this.dto.setParadasDTOs(new ArrayList<RelatorioQuantidadeParadasDTO>());
		this.dto.setQtdTotal(String.valueOf(quantidadeTotalParadas));
		this.dto.setTempoTotalParadas(DataHoraRN.formatSegundosParaHHMMSS(totalTempoTodasParadas.intValue()));
		this.dto.setTempoTotalParadasCP(DataHoraRN.formatSegundosParaHHMMSS(tempoTotalParadasCP.intValue()));
		this.dto.setTempoTotalParadasSP(DataHoraRN.formatSegundosParaHHMMSS(tempoTotalParadasSP.intValue()));
		
		List<RelatorioQuantidadeParadasDTO> listaLinhas = new ArrayList<>();
		
		for(String chave : mapChaveParadaEAreaResponsavel.keySet()) {
			RelatorioQuantidadeParadasDTO relatorio = mapChaveParadaEAreaResponsavel.get(chave);
			listaLinhas.add(relatorio);
		}
		
		this.dto.setParadasDTOs(listaLinhas);
	}
	
	private void ordenarLinhasDTO() {
		Comparator<RelatorioQuantidadeParadasDTO> comparator = new Comparator<RelatorioQuantidadeParadasDTO>() {
			@Override
			public int compare(RelatorioQuantidadeParadasDTO o1, RelatorioQuantidadeParadasDTO o2) {
				
				int retorno;
				if(filtro.getTipo().equals("quantidade")){
					String qtd1 = o1.getQuantidade();
					String qtd2 = o2.getQuantidade();
					retorno =  qtd1.compareTo(qtd2);
				}else{
					String tempo1 = DataHoraRN.formatSegundosParaHHMMSSSemMilisegundos(o1.getDuracao().doubleValue());
					String tempo2 = DataHoraRN.formatSegundosParaHHMMSSSemMilisegundos(o2.getDuracao().doubleValue());
					retorno = tempo1.compareTo(tempo2);
				}
				return retorno * -1;
			}
		};
		Collections.sort(dto.getParadasDTOs(), comparator);
	}
	
	private void preencherONumeroDaLinha() {
		int numeroLinha = 1;
		for(RelatorioQuantidadeParadasDTO linha: this.dto.getParadasDTOs()) {
			linha.setNumeroLinhaRel(numeroLinha);
			numeroLinha++;
		}
	}

}
