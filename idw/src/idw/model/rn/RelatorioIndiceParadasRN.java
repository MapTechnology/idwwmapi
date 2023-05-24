package idw.model.rn;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTParada;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroRelatorioIndiceParadasDTO;
import idw.webservices.dto.ListaRelatorioIndiceParadaDTO;
import idw.webservices.dto.RelatorioIndiceParadasDTO;

public class RelatorioIndiceParadasRN extends AbstractRN<DAOGenerico> {

	private BigDecimal tempoTotalParadas = BigDecimal.ZERO;
	private BigDecimal tempoTotalParadasCP = BigDecimal.ZERO;
	private BigDecimal tempoTotalParadasSP = BigDecimal.ZERO;
	private HashMap<String, Double> mapTemposFerramenta = new HashMap<>();
	private HashMap<String, Double> mapTemposMaquina = new HashMap<>();
	
	public RelatorioIndiceParadasRN() {
		this(null);
	}

	public RelatorioIndiceParadasRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
		
	public ListaRelatorioIndiceParadaDTO getRelatorioIndiceParadas (FiltroRelatorioIndiceParadasDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioIndiceParadasRN.getRelatorioIndiceParadas");
		log.info( idLog , 0, "RelatorioIndiceParadasRN.getRelatorioIndiceParadas filtro usado:" + filtro.toString());
		
		HashMap<String, DwTParada> mapParadasFiltro = new HashMap<>();
		if(filtro.getDwTParadas() != null) {
			for(DwTParada parada : filtro.getDwTParadas()) {
				mapParadasFiltro.put(parada.getCdTparada(), parada);
			}
		}
		HashMap<String, DwTArea> mapAreasFiltro = new HashMap<>();
		// Alessandre em 27-7-16 removi do if abaixo o teste de null dw dwtparadas pois qdo nao se define uma parada e apenas uma area
		// nao estava funcionando
		if(/*filtro.getDwTParadas() != null &&*/ filtro.getDwTAreas() != null) {
			for(DwTArea area : filtro.getDwTAreas()) {
				mapAreasFiltro.put(area.getCdArea(), area);
			}
		}
		
		ListaRelatorioIndiceParadaDTO retorno = new ListaRelatorioIndiceParadaDTO();
		List<DwConsolpa> todosConsolpa = new ArrayList<DwConsolpa>();
		HashMap<String, RelatorioIndiceParadasDTO> mapRelatorioPorParada = new HashMap<>();
		
		List<DwConsolid> consolids = getConsolids(filtro);
		
		for (DwConsolid consolid : consolids) {
						
			for (DwConsol consol : consolid.getDwConsols()) {
				for (DwConsolpa consolpa : consol.getDwConsolpas()) {
					//Se nao tiver ocorrencia desconsiderar dwconsolpa
					if (consolpa.getDwConsolpaocos() == null || consolpa.getDwConsolpaocos().size() <= 0)
						continue;

					if(mapParadasFiltro.get(consolpa.getDwTParada().getCdTparada()) != null || (consolpa.getDwTParada().getDwTArea() != null ? mapAreasFiltro.get(consolpa.getDwTParada().getDwTArea().getCdArea()) != null : false)) {
						boolean isJaExiste = false;
						for (DwConsolpa pa : todosConsolpa) {
							if (pa.getIdConsolpa().equals(consolpa.getIdConsolpa())) {
								isJaExiste = true;
							}
						}					
						
						if (consolpa.getSegAutoTempoparadaCp() != null) { 
							tempoTotalParadas = tempoTotalParadas.add(consolpa.getSegAutoTempoparadaCp());
						}
						if (consolpa.getSegAutoTempoparadaSp() != null) {
							tempoTotalParadas = tempoTotalParadas.add(consolpa.getSegAutoTempoparadaSp());
						}
						
						if (isJaExiste == false) {
							todosConsolpa.add(consolpa);
						}
					}
				}
			}
		}

		for(DwConsolpa consolpa : todosConsolpa) {
			double tempoParadasCP = 0d;
			double tempoParadasSP = 0d;
			String produto;

			if(consolpa.getDwConsol() != null && consolpa.getDwConsol().getDwConsolprs() != null) {
				if(!consolpa.getDwConsol().getDwConsolprs().isEmpty()) {
					produto = consolpa.getDwConsol().getDwConsolprs().iterator().next().getOmProduto().getCdProduto();
				} else {
					produto = "DESCONHECIDO";
				}
			} else {
				produto = "DESCONHECIDO";
			}
			
			if (consolpa.getDwTParada().getIsPesa() != null && consolpa.getDwTParada().getIsPesa() == false) {
				tempoParadasSP = consolpa.getSegAutoTempoparadaSp() != null ? consolpa.getSegAutoTempoparadaSp().doubleValue() : 0d;
			} else {
				tempoParadasCP = consolpa.getSegAutoTempoparadaCp() != null ? consolpa.getSegAutoTempoparadaCp().doubleValue() : 0d;
			}
			
			String maquina;
			if(consolpa.getDwConsol() != null) {
				if(consolpa.getDwConsol().getDwConsolid().getOmPt() != null) {
					//Marcos Sardinha: 2017-09-28 >> Defeito #3388
					maquina = consolpa.getDwConsol().getDwConsolid().getOmPt().getCdPt();
				} else {
					maquina = "DESCONHECIDA";
				}				
			} else {
				maquina = "DESCONHECIDA";
			}
			
			String ferramenta;
			if(consolpa.getDwConsol() != null) {
				DwFolha dwfolha = consolpa.getDwConsol().getDwConsolid().getDwFolha();
				if( dwfolha != null && dwfolha.getDwFolharaps() != null && dwfolha.getDwFolharaps().size() > 0) {
					ferramenta = dwfolha.getDwFolharaps().iterator().next().getDwRap().getCdRap();
				} else {
					ferramenta = "DESCONHECIDA";
				}
			} else {
				ferramenta = "DESCONHECIDA";
			}
			
			Double tempo = tempoParadasCP + tempoParadasSP;
			String parada = consolpa.getDwTParada() != null ? consolpa.getDwTParada().getCdTparada() + " - " + consolpa.getDwTParada().getDsTparada() : "";
			
			adicionarNoMap(mapRelatorioPorParada, parada, tempo, ferramenta, produto, maquina, tempoParadasCP, tempoParadasSP, filtro.getTipo(), filtro.getTipo().equals("ferramenta"), filtro.getTipo().equals("produto"));
			
		}

		List<RelatorioIndiceParadasDTO> listaDadosRelatorio = new ArrayList<>();
		
		for(String parada : mapRelatorioPorParada.keySet()){
			RelatorioIndiceParadasDTO relatorio = mapRelatorioPorParada.get(parada);
			if(relatorio.getTempo() <= 0) {
				continue;
			}
			
			if(filtro.getTipo().equals("ferramenta")) {
				relatorio.setIndice(getIndice(relatorio.getTempo(), mapTemposMaquina.get(relatorio.getFerramenta() + relatorio.getMaquina())));			
				relatorio.setTempoFerProd(mapTemposFerramenta.get(relatorio.getFerramenta()));
			} else if(filtro.getTipo().equals("produto")) {
				relatorio.setIndice(getIndice(relatorio.getTempo(), mapTemposMaquina.get(relatorio.getProduto() + relatorio.getMaquina())));			
				relatorio.setTempoFerProd(mapTemposFerramenta.get(relatorio.getProduto()));
			} else {
				relatorio.setIndice(getIndice(relatorio.getTempo(), tempoTotalParadasCP.doubleValue() + tempoTotalParadasSP.doubleValue()));
			}
			
			listaDadosRelatorio.add(relatorio);
		}		
		
		Comparator<RelatorioIndiceParadasDTO> comparator = null;
		if(filtro.getTipo().equals("padrao")) {
			comparator = new Comparator<RelatorioIndiceParadasDTO>() {
				@Override
				public int compare(RelatorioIndiceParadasDTO o1, RelatorioIndiceParadasDTO o2) {
					return o1.getTempo().compareTo(o2.getTempo()) * -1;
				}
			};
		}
		if(filtro.getTipo().equals("ferramenta")) {
			comparator = new Comparator<RelatorioIndiceParadasDTO>() {
				@Override
				public int compare(RelatorioIndiceParadasDTO o1, RelatorioIndiceParadasDTO o2) {
					int retorno = 0;
					if(o1.getFerramenta().compareTo(o2.getFerramenta()) == 0) {
						retorno = o1.getMaquina().compareTo(o2.getMaquina());
					} else {
						retorno = o1.getFerramenta().compareTo(o2.getFerramenta());
					}
					return retorno;
				}
			};
		}
		if(filtro.getTipo().equals("produto")) {
			comparator = new Comparator<RelatorioIndiceParadasDTO>() {
				@Override
				public int compare(RelatorioIndiceParadasDTO o1, RelatorioIndiceParadasDTO o2) {
					int retorno = 0;
					if(o1.getProduto().compareTo(o2.getProduto()) == 0) {
						retorno = o1.getMaquina().compareTo(o2.getMaquina());
					} else {
						retorno = o1.getProduto().compareTo(o2.getProduto());
					}
					return retorno;
				}
			};
		}		
		
		retorno.setTempoTotal(tempoTotalParadas.doubleValue());
		Collections.sort(listaDadosRelatorio, comparator);
		retorno.setIndiceParadasDTO(listaDadosRelatorio);
		log.mostrarAvaliacaoCompleta();
		return retorno;		
	}
	
	public List<DwConsolid> getConsolids(FiltroRelatorioIndiceParadasDTO filtro) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwConsols consol");
		q.append("JOIN consolid.dwTurno turno");
		q.append("JOIN consolid.omPt pt");
		q.append("join consolid.ppCp ppcp");
		q.append("join ppcp.ppCpprodutos ppcpproduto");
		q.append("LEFT JOIN consolid.dwFolha folha");
		q.append("LEFT JOIN folha.dwFolharaps folharap");
		q.append("LEFT JOIN folharap.dwRap rap");
		q.append("LEFT JOIN rap.dwRapGrupos rapgrupo");
		q.append("LEFT JOIN rapgrupo.dwGrupoFerramenta gpferramenta");
		q.append("LEFT JOIN pt.omObjs obj");
		q.append("LEFT JOIN obj.omGtByIdGt gt");
		q.append("LEFT JOIN consol.dwConsolpas consolpa");
		q.append("LEFT JOIN consol.dwConsolprs consolpr");		
		q.append("WHERE consolid.tpId = :tpId");
		
		if (filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null)
			q.append("and consolid.dtReferencia BETWEEN :dtInicio AND :dtFim");
		
		if(filtro.getTurnoDTO() != null) {
			q.append("AND turno.idTurno = :idTurno");
		} else{
			q.append("and turno.idTurno <> 1");
		}
		
		if(filtro.getOmpt() != null) {
			q.append("AND pt.idPt = :idPt");
		}
		
		if(filtro.getOmgt() != null) {
			q.append("AND gt.idGt = :idGt");
		}
		
		if(filtro.getDwFolha() != null) {
			q.append("AND folha.idFolha = :idFolha");
		}
		
		if(filtro.getDwGrupoFerramenta() != null) {
			q.append("AND gpferramenta.idGrupoFerramenta = :idGpRap");
		}
		
		if (filtro.getDwRap() != null) {
			q.append("AND rap.idRap = :idrap");
		}

		if(filtro.getCdop() != null) {
			q.append("AND ppcpproduto.nrDoc = :cdOP");
		}
		
		if (filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null) {
			q.defineParametro("dtInicio", filtro.getPeriodoInicial());
			q.defineParametro("dtFim", DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));
		}
		
		q.defineParametro("tpId", (byte)1);
		
		if(filtro.getTurnoDTO() != null) {
			q.defineParametro("idTurno", filtro.getTurnoDTO().getTurno().getIdTurno());
		}
		
		if(filtro.getOmpt() != null) {
			q.defineParametro("idPt", filtro.getOmpt().getIdPt());
		}
		
		if(filtro.getOmgt() != null) {
			q.defineParametro("idGt", filtro.getOmgt().getIdGt());
		}
		
		if(filtro.getDwFolha() != null) {
			q.defineParametro("idFolha", filtro.getDwFolha().getIdFolha());
		}
		
		if(filtro.getDwGrupoFerramenta() != null) {
			q.defineParametro("idGpRap", filtro.getDwGrupoFerramenta().getIdGrupoFerramenta());
		}
		
		if (filtro.getDwRap() != null) {
			q.defineParametro("idrap", filtro.getDwRap().getIdRap());
		}
		
		if(filtro.getCdop() != null) {
			q.defineParametro("cdOP", filtro.getCdop());
		}
		
		return q.list();
	}
	
	private String getIndice(double tempo, double tempoTotal) {
		DecimalFormat df = new DecimalFormat("0.00");
		double valor = (tempo * 100) / tempoTotal;		
		return df.format(valor) + "%";
	}

	private void adicionarNoMap(HashMap<String, RelatorioIndiceParadasDTO> mapRelatorioPorParada,
								String parada, Double tempoParada, String ferramenta, String produto, 
								String maquina,	double tempoParadasCP, double tempoParadasSP, String modeloPor,
								boolean isFerramenta, boolean isProduto) {
		
		String chave = null;
		
		if(isFerramenta) {
			Double tempoFerramenta = mapTemposFerramenta.get(ferramenta);
			if(tempoFerramenta == null) {
				tempoFerramenta = tempoParadasCP + tempoParadasSP;
				mapTemposFerramenta.put(ferramenta, tempoFerramenta);
			} else {
				mapTemposFerramenta.remove(ferramenta);
				tempoFerramenta = tempoFerramenta + (tempoParadasCP + tempoParadasSP);
				mapTemposFerramenta.put(ferramenta, tempoFerramenta);
			}
			
			String ferMaq = ferramenta + maquina; 
			Double tempoMaquina = mapTemposMaquina.get(ferMaq);
			if(tempoMaquina == null) {
				tempoMaquina = tempoParadasCP + tempoParadasSP;
				mapTemposMaquina.put(ferMaq, tempoMaquina);
			} else {
				mapTemposMaquina.remove(ferMaq);
				tempoMaquina = tempoMaquina + (tempoParadasCP + tempoParadasSP);
				mapTemposMaquina.put(ferMaq, tempoMaquina);
			}
		} else if(isProduto) {
			Double tempoFerramenta = mapTemposFerramenta.get(produto);
			if(tempoFerramenta == null) {
				tempoFerramenta = tempoParadasCP + tempoParadasSP;
				mapTemposFerramenta.put(produto, tempoFerramenta);
			} else {
				mapTemposFerramenta.remove(produto);
				tempoFerramenta = tempoFerramenta + (tempoParadasCP + tempoParadasSP);
				mapTemposFerramenta.put(produto, tempoFerramenta);
			}
			
			String prodMaq = produto + maquina;
			Double tempoMaquina = mapTemposMaquina.get(prodMaq);
			if(tempoMaquina == null) {
				tempoMaquina = tempoParadasCP + tempoParadasSP;
				mapTemposMaquina.put(prodMaq, tempoMaquina);
			} else {
				mapTemposMaquina.remove(prodMaq);
				tempoMaquina = tempoMaquina + (tempoParadasCP + tempoParadasSP);
				mapTemposMaquina.put(prodMaq, tempoMaquina);
			}
		}
		
		if(modeloPor.equals("padrao")) {
			chave = parada;
		}
		if(modeloPor.equals("ferramenta")) {
			chave = ferramenta + " " + maquina + " " + parada;
		}
		if(modeloPor.equals("produto")) {
			chave = produto + " " + maquina + " " + parada;
		}	
		
		RelatorioIndiceParadasDTO relatorio = mapRelatorioPorParada.get(chave);
		if(relatorio == null) {
			relatorio = new RelatorioIndiceParadasDTO();
			relatorio.setParada(parada);
			relatorio.setTempo(tempoParada);
			relatorio.setFerramenta(ferramenta);
			relatorio.setProduto(produto);
			relatorio.setMaquina(maquina);
			relatorio.setTempoParadaCP(tempoParadasCP);
			relatorio.setTempoParadaSP(tempoParadasSP);
			mapRelatorioPorParada.put(chave, relatorio);
		} else {
			double novoTempoCP = tempoParadasCP + relatorio.getTempoParadaCP();
			relatorio.setTempoParadaCP(novoTempoCP);
			double novoTempoSP = tempoParadasSP + relatorio.getTempoParadaSP();
			relatorio.setTempoParadaSP(novoTempoSP);
			double novaDuracaoParada = relatorio.getTempo() + tempoParada;
			relatorio.setTempo(novaDuracaoParada);
		}
		
		tempoTotalParadasCP = tempoTotalParadasCP.add(new BigDecimal(tempoParadasCP));
		tempoTotalParadasSP = tempoTotalParadasSP.add(new BigDecimal(tempoParadasSP));
	}

}