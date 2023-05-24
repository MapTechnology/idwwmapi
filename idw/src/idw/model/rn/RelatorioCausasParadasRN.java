package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.DwTParada;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroRelatorioIndiceParadasDTO;
import idw.webservices.dto.ListaRelatorioCausasParadasDTO;
import idw.webservices.dto.RelatorioCausasParadasDTO;

public class RelatorioCausasParadasRN extends AbstractParadaRN{

	public RelatorioCausasParadasRN() {
		this(null);
	}
	
	public RelatorioCausasParadasRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public ListaRelatorioCausasParadasDTO getCausasParadas( FiltroRelatorioIndiceParadasDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioCausasParadasRN.getCausasParadas");
		log.info( idLog , 0, "RelatorioCausasParadasRN.getCausasParadas filtro usado:" + filtro.toString());
		
		List<DwConsolpa> listaConsolpa = new ArrayList<>();
		MapQuery q = new MapQuery(getDaoSession());
		if (filtro.getIsTodasParadas() != null && filtro.getIsTodasParadas() == true) {
			listaConsolpa.addAll(consultaRelatorioParadas(q, filtro, null));
		} else if(filtro.getDwTParadas() != null && !filtro.getDwTParadas().isEmpty()){
			for(DwTParada parada : filtro.getDwTParadas()) {
				listaConsolpa.addAll(consultaRelatorioParadas(q, filtro, parada));
			}
		}
		
		ListaRelatorioCausasParadasDTO retorno = new ListaRelatorioCausasParadasDTO();
		if (!listaConsolpa.isEmpty()) {
			if(filtro.getTipo().equals("consolidado")) {
				retorno = montaRelatorioConsolidado(listaConsolpa);
			}
			if(filtro.getTipo().equals("parada")) {
				retorno = montaRelatorioParada(listaConsolpa);
			}
			
		}
		log.mostrarAvaliacaoCompleta();
		return retorno;
		
	}
	
	private ListaRelatorioCausasParadasDTO montaRelatorioParada(List<DwConsolpa> listaConsolpa) {
		
		Double tempoTotalParadasCP = 0d;
		Double tempoTotalParadasSP = 0d;
		
		HashMap<String, RelatorioCausasParadasDTO> mapRelatorioParadas = new HashMap<>();
		HashMap<String, Double> mapTempoTotalParada = new HashMap<>();
						
		for (DwConsolpa pa : listaConsolpa) {
			for (DwConsolpaoco oco : pa.getDwConsolpaocos()) {
				
				DwTParada dwTParada = pa.getDwTParada();
				
				DwTCausa dwTCausa = oco.getDwTCausa();
				
				//20161128F...
				if(dwTCausa == null && oco.getDwConsolpalog()!=null && oco.getDwConsolpalog().getDwTCausa()!=null){
					dwTCausa = oco.getDwConsolpalog().getDwTCausa();
				}
				//20161128.
				
				
				
				if(dwTCausa == null){
					continue;
				}
				
				String parada = dwTParada != null ? dwTParada.getCdTparada() + "-" + dwTParada.getDsTparada() : "";
				String causa = dwTCausa.getCdTcausa() +"-"+dwTCausa.getDsTcausa();
				
				int duracaoCausa = DataHoraRN.getQuantidadeSegundosNoPeriodo(oco.getDthrIparada(), oco.getDthrFparada());
				
				if(duracaoCausa == 0){
					continue;
				}
				
				Double duracaoParada = mapTempoTotalParada.get(parada);
				if(duracaoParada == null){
					duracaoParada = 0d;
					duracaoParada = duracaoParada + duracaoCausa;
					mapTempoTotalParada.put(parada, duracaoParada);
				} else {
					duracaoParada = duracaoParada + duracaoCausa;
					mapTempoTotalParada.put(parada, duracaoParada);
				}
				
				String chave = parada+causa;
			
				if (pa.getDwTParada().getIsPesa() != null && pa.getDwTParada().getIsPesa() == false) {
					tempoTotalParadasSP += duracaoCausa;
		        } else {
		        	tempoTotalParadasCP += duracaoCausa;
		        }
				
				RelatorioCausasParadasDTO relatorio = mapRelatorioParadas.get(chave);
				if(relatorio == null) {
					relatorio = new RelatorioCausasParadasDTO();
					relatorio.setParada(parada);
					relatorio.setCausa(causa);
					relatorio.setDuracao(new BigDecimal(duracaoCausa));
					relatorio.setTempoTotalCausa(new BigDecimal(duracaoCausa));
					mapRelatorioParadas.put(chave, relatorio);
				} else {
					BigDecimal tempoTotalCausaAux = new BigDecimal(duracaoCausa + relatorio.getTempoTotalCausa().doubleValue());
					relatorio.setDuracao(tempoTotalCausaAux);
					relatorio.setTempoTotalCausa(tempoTotalCausaAux);
				}
			}
		}
		
		Double totalTempoTodasParadas = tempoTotalParadasCP + tempoTotalParadasSP;
		
		ListaRelatorioCausasParadasDTO retorno = new ListaRelatorioCausasParadasDTO();
		retorno.setParadasDTOs(new ArrayList<RelatorioCausasParadasDTO>()); 
		retorno.setTempoTotalParadas(DataHoraRN.formatSegundosParaHHMMSS(totalTempoTodasParadas.intValue()));
		retorno.setTempoTotalParadasCP(DataHoraRN.formatSegundosParaHHMMSS(tempoTotalParadasCP.intValue()));
		retorno.setTempoTotalParadasSP(DataHoraRN.formatSegundosParaHHMMSS(tempoTotalParadasSP.intValue()));
		
		int i = 0;
		List<RelatorioCausasParadasDTO> listaDadosRelatorio = new ArrayList<>();
		
		for(String chave : mapRelatorioParadas.keySet()){
			RelatorioCausasParadasDTO relatorio = mapRelatorioParadas.get(chave);
			Double tempoTotalParada = mapTempoTotalParada.get(relatorio.getParada());
			//atualizando o total da parada
			relatorio.setTempoTotalCausa(new BigDecimal(tempoTotalParada));
			listaDadosRelatorio.add(relatorio);
		}		
		
		Comparator<RelatorioCausasParadasDTO> comparator = new Comparator<RelatorioCausasParadasDTO>() {
			@Override
			public int compare(RelatorioCausasParadasDTO o1, RelatorioCausasParadasDTO o2) {
				String parada1 = o1.getParada();
				String parada2 = o2.getParada();
				return parada1.compareTo(parada2);
			}
		};
		
		Collections.sort(listaDadosRelatorio, comparator);
		
		for(RelatorioCausasParadasDTO relatorio : listaDadosRelatorio){
			relatorio.setNumeroLinhaRel(i);
			retorno.getParadasDTOs().add(relatorio);
			i++;
		}
		
		return retorno;
	}

	private ListaRelatorioCausasParadasDTO montaRelatorioConsolidado(List<DwConsolpa> listaConsolpa) {
		
		Double tempoTotalParadasCP = 0d;
		Double tempoTotalParadasSP = 0d;
		
		HashMap<String, RelatorioCausasParadasDTO> mapRelatorioParadas = new HashMap<>();
						
		for (DwConsolpa pa : listaConsolpa) {
			for (DwConsolpaoco oco : pa.getDwConsolpaocos()) {
				DwTCausa dwTCausa = oco.getDwTCausa();
				
				//20161128F...
				if(dwTCausa == null && oco.getDwConsolpalog()!=null && oco.getDwConsolpalog().getDwTCausa()!=null){
					dwTCausa = oco.getDwConsolpalog().getDwTCausa();
				}
				//20161128.
				
				
				if(dwTCausa == null){
					continue;
				}					
										
				String causa = dwTCausa.getCdTcausa() +"-"+dwTCausa.getDsTcausa();
			
				// Soma os valores da parada se a mesma tiver uma causa
				Integer duracao = DataHoraRN.getQuantidadeSegundosNoPeriodo(oco.getDthrIparada(), oco.getDthrFparada());
				if (pa.getDwTParada().getIsPesa() != null && pa.getDwTParada().getIsPesa() == false) {
		            if(duracao > 0) {
		            	tempoTotalParadasSP = tempoTotalParadasSP.doubleValue() + duracao;
		            }
		        } else {
		            if(duracao > 0){
		            	tempoTotalParadasCP = tempoTotalParadasCP.doubleValue() + duracao;
		            }
		        }
			
				RelatorioCausasParadasDTO relatorio;
				if (mapRelatorioParadas.containsKey(causa)) {
					relatorio = mapRelatorioParadas.get(causa);
					BigDecimal tempoAux = relatorio.getDuracao();
					tempoAux = new BigDecimal(tempoAux.doubleValue() + duracao.doubleValue() );
					relatorio.setDuracao(tempoAux);
				} else {
					relatorio = new RelatorioCausasParadasDTO();
					relatorio.setCausa(causa);
					relatorio.setDuracao(new BigDecimal(duracao));
					mapRelatorioParadas.put(causa, relatorio);
				}
			}
		}
		
		Double totalTempoTodasParadas = tempoTotalParadasCP + tempoTotalParadasSP;
		
		ListaRelatorioCausasParadasDTO retorno = new ListaRelatorioCausasParadasDTO();
		retorno.setParadasDTOs(new ArrayList<RelatorioCausasParadasDTO>()); 
		retorno.setTempoTotalParadas(DataHoraRN.formatSegundosParaHHMMSS(totalTempoTodasParadas.intValue()));
		retorno.setTempoTotalParadasCP(DataHoraRN.formatSegundosParaHHMMSS(tempoTotalParadasCP.intValue()));
		retorno.setTempoTotalParadasSP(DataHoraRN.formatSegundosParaHHMMSS(tempoTotalParadasSP.intValue()));
		
		int i = 0;
		List<RelatorioCausasParadasDTO> listaDadosRelatorio = new ArrayList<>();
		
		for(String chave : mapRelatorioParadas.keySet()){
			RelatorioCausasParadasDTO relatorio = mapRelatorioParadas.get(chave);
			Double tempoTotalParada = relatorio.getDuracao().doubleValue();
			if(tempoTotalParada.doubleValue() <= 0) {
				continue;
			}
			listaDadosRelatorio.add(relatorio);
		}		
		
		Comparator<RelatorioCausasParadasDTO> comparator = new Comparator<RelatorioCausasParadasDTO>() {
			@Override
			public int compare(RelatorioCausasParadasDTO o1, RelatorioCausasParadasDTO o2) {
				String causa1 = o1.getCausa();
				String causa2 = o2.getCausa();
				return causa1.compareTo(causa2);
			}
		};

		//20161205 comparatorDuracao
		Comparator<RelatorioCausasParadasDTO> comparatorDuracao = new Comparator<RelatorioCausasParadasDTO>() {
			@Override
			public int compare(RelatorioCausasParadasDTO o1, RelatorioCausasParadasDTO o2) {
				BigDecimal bdDuracao1 = o1.getDuracao();
				BigDecimal bdDuracao2 = o2.getDuracao();
				return bdDuracao1.compareTo(bdDuracao2);
			}
		};

		Collections.sort(listaDadosRelatorio, comparatorDuracao); //20161205
		Collections.reverse(listaDadosRelatorio);//20161205
		
		for(RelatorioCausasParadasDTO relatorio : listaDadosRelatorio){
			relatorio.setNumeroLinhaRel(i);
			retorno.getParadasDTOs().add(relatorio);
			i++;
		}
		
		return retorno;
	}

	private List<DwConsolpa> consultaRelatorioParadas(MapQuery q, FiltroRelatorioIndiceParadasDTO filtro, DwTParada parada) {

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
		if (parada != null) {
			q.append("AND parada.idTparada = :idparada");
		}

		q.defineParametro("tpId", (byte) 1);
		if (filtro.getCdop() != null) {
			q.defineParametro("cdop", filtro.getCdop());
		}

		if (filtro.getDwGrupoFerramenta() != null) {
			q.defineParametro("idgpRap", filtro.getDwGrupoFerramenta().getIdGrupoFerramenta());
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
			q.defineParametro("idturno", filtro.getTurnoDTO().getTurno().getIdTurno());
		}
		if (parada != null) {
			q.defineParametro("idparada", parada.getIdTparada());
		}
		if (filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null) {
			q.defineParametro("dataincial", DataHoraRN.getDataHoraInicial(filtro.getPeriodoInicial()));
			q.defineParametro("datafinal", DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));
		}
		
		List<DwConsolpa> retorno = q.list();
		
		return retorno;
	}

}
