package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolciplog;
import idw.model.pojos.DwConsolcipoco;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwFolharap;
import idw.util.IdwLogger;
import idw.webservices.dto.DadosRelEficienciaSetupDTO;
import idw.webservices.dto.FiltroRelatorioIndiceParadasDTO;
import idw.webservices.dto.ListaRelatorioParadasInicioProcessoDTO;
import idw.webservices.dto.RelatorioParadasInicioProcessoDTO;
import ms.util.ConversaoTipos;

public class RelatorioEficienciaSetupRN extends AbstractRN<DAOGenerico> {

	public RelatorioEficienciaSetupRN() {
		this(null);
	}

	public RelatorioEficienciaSetupRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	public DadosRelEficienciaSetupDTO getRelatorioEficienciaSetup(FiltroRelatorioIndiceParadasDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioEficienciaSetupRN.getRelatorioEficienciaSetup");
		log.info( idLog , 0, "RelatorioEficienciaSetupRN.getRelatorioEficienciaSetup filtro usado:" + filtro.toString());
		
		List<DwConsolid> listaConsolids = consultaInicioProcesso(filtro);
		DadosRelEficienciaSetupDTO retorno = montarRelatorio(listaConsolids, filtro);
		// Alessandre em 2405-22 chamado #7798
//		mesclarLinhasIguais(retorno.getItens());
		
		log.mostrarAvaliacaoCompleta();
		
		return retorno;
	
	}

	public ListaRelatorioParadasInicioProcessoDTO getRelatorioEficienciaSetupComParadas(FiltroRelatorioIndiceParadasDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioEficienciaSetupRN.getRelatorioEficienciaSetupComParadas");
		log.info( idLog , 0, "RelatorioEficienciaSetupRN.getRelatorioEficienciaSetupComParadas filtro usado:" + filtro.toString());
		
		List<DwConsolid> listaConsolids = consultaInicioProcesso(filtro);		
		DadosRelEficienciaSetupDTO retorno = montarRelatorio(listaConsolids, filtro);
		mesclarLinhasIguais(retorno.getItens());
		
		log.mostrarAvaliacaoCompleta();
		
		return montarRelatorioParadas(retorno);
	
	}

	// Relatorio principal sem as paradas
	private DadosRelEficienciaSetupDTO montarRelatorio(List<DwConsolid> listaConsolids, FiltroRelatorioIndiceParadasDTO filtro) {
		
		DadosRelEficienciaSetupDTO retorno = new DadosRelEficienciaSetupDTO();
		retorno.setItens(new ArrayList<DadosRelEficienciaSetupDTO>());
		retorno.setListaParadas(new ArrayList<RelatorioParadasInicioProcessoDTO>());
		
		HashMap<Date, DadosRelEficienciaSetupDTO> controle = new HashMap<>();		

		// bug no CIP: alguns periodos com problema
		Map<Long, Long> mapConsolIdProcessado = new HashMap<Long, Long>();
		
		
		Comparator<DwConsolcipoco> comparatorCipOco = new Comparator<DwConsolcipoco>() {
			@Override
			public int compare(DwConsolcipoco o1, DwConsolcipoco o2) {				
				return o1.getIdConsolcipoco().compareTo(o2.getIdConsolcipoco());
			}
		};
				
		// o loop abaixo vai criar as linhas do relatorio para os dwconsolid com idpepro = 2
		for (DwConsolid consolid : listaConsolids) {
			/*
			 * Obtem uma lista de dwconsolciplog
			 */
			for (DwConsol consol : consolid.getDwConsols()) {
				 // Pegar lista de dwconsolcipoco incluindo o ciplog em aberto
				List<DwConsolcipoco> ocos = new ArrayList<DwConsolcipoco>(consol.getDwConsolcipocos());
				Collections.sort(ocos, comparatorCipOco);
				
				
				DwConsolcipoco aberto = getDwConsolcipocoEmAberto(consolid);
				if (ocos.isEmpty() && aberto != null && aberto.getDthrIcip() != null)
					ocos.add(aberto);
				for (DwConsolcipoco oco : ocos) {
					// se retornar false eh pq o dwconsolciplog ja foi
					// processado antes entao atualizar somentee a producao
					// bruta
					
					// bug no CIP: alguns periodos com problema
					if (mapConsolIdProcessado.containsKey(consolid.getIdConsolid()) == false) {
						mapConsolIdProcessado.put(consolid.getIdConsolid(), consolid.getIdConsolid());
						novoCip(consolid, oco, consol, retorno, controle);
					}
					
				}
			}
		}
		

		Comparator<DadosRelEficienciaSetupDTO> comparatorMaquina = new Comparator<DadosRelEficienciaSetupDTO>() {
			@Override
			public int compare(DadosRelEficienciaSetupDTO o1, DadosRelEficienciaSetupDTO o2) {
				int ordem = o1.getMaquina().compareTo(o2.getMaquina());
				if (ordem == 0)
					ordem = o1.getInicioProcesso().compareTo(o2.getInicioProcesso());
				return ordem;
			}
		};
		Collections.sort(retorno.getItens(), comparatorMaquina);

		return retorno;
	}
	
	// Retorna false se o dwconsolciplog ja tiver sido processado. Nesse caso atualizar apenas a producao bruta
	private boolean novoCip(DwConsolid consolid,
			DwConsolcipoco oco, 
			DwConsol consol, 
			DadosRelEficienciaSetupDTO retorno, 
			HashMap<Date, 
			DadosRelEficienciaSetupDTO> controle){
		
		
		retorno.setListaParadas(new ArrayList<RelatorioParadasInicioProcessoDTO>());
		
		double tempoTotalEmSegundos = 0d;
		String inicioProcesso = "";
		String fimProcesso = "";
		int prodBoa = (consol.getPcsProducaoLiquida() != null ? consol.getPcsProducaoLiquida().intValue() : 0);
		int prodBruta = consol.getPcsProducaoBruta().intValue();
		int prodRefugada = consol.getPcsProducaoRefugada().intValue();

		Double tempoParadasSegundos =   (
				  (consol.getSegAutoTempoparadaCp() != null ? consol.getSegAutoTempoparadaCp().doubleValue() : 0d)
				+ (consol.getSegManuTempoparadaCp() != null ? consol.getSegManuTempoparadaCp().doubleValue() : 0d)
				+ (consol.getSegAutoTempoparadaSp() != null ? consol.getSegAutoTempoparadaSp().doubleValue() : 0d) 
				+ (consol.getSegManuTempoparadaSp() != null ? consol.getSegManuTempoparadaSp().doubleValue() : 0d) );
		
		int tempoPadraoSegundos = consolid.getDwFolha().getSegSetup() != null ? consolid.getDwFolha().getSegSetup().intValue() : 0;
		
		List<DwConsolid> ids = new ArrayList<>();
		ids.add(consolid);

		DadosRelEficienciaSetupDTO item = new DadosRelEficienciaSetupDTO();
		item.setListaParadas(new ArrayList<RelatorioParadasInicioProcessoDTO>());
		
		String maquina = consolid.getOmPt().getCdPt();
		item.setMaquina(maquina);

		String tecnicoAbertura = "";
		String tecnicoEncerramento = "";
		if (oco != null) {
			Date fim = oco.getDthrFcip();
			if (fim == null)
				fim = DataHoraRN.getDataHoraAtual();
			
			tempoTotalEmSegundos = DataHoraRN.getQuantidadeSegundosNoPeriodo(oco.getDthrIcip(), fim);

			inicioProcesso = DataHoraRN.dateToStringYYYYMMDDHHMMSS(oco.getDthrIcip());
			fimProcesso = DataHoraRN.dateToStringYYYYMMDDHHMMSS(fim);			
			
			item.setDataInicio(oco.getDthrIcip());
			item.setDataFim(fim);
		}

		//Obtem
		String raps = null;
		if (oco.getDwConsolciplog() != null) {
			if (oco.getDwConsolciplog().getOmUsrByIdUsrEntrada() != null) {
				tecnicoAbertura = oco.getDwConsolciplog().getOmUsrByIdUsrEntrada().getCdUsr() + " - " + oco.getDwConsolciplog().getOmUsrByIdUsrEntrada().getDsNome();
			}
	
			if (oco.getDwConsolciplog().getOmUsrByIdUsrSaida() != null) {
				tecnicoEncerramento = oco.getDwConsolciplog().getOmUsrByIdUsrSaida().getCdUsr() + " - " + oco.getDwConsolciplog().getOmUsrByIdUsrSaida().getDsNome();
			}
	
	
			for (DwFolharap folharap : oco.getDwConsolciplog().getDwConsolidByIdConsolidInicio().getDwFolha().getDwFolharaps()) {
				if (raps == null) {
					raps = folharap.getDwRap().getCdRap() + ", ";
				} else if (!raps.contains(folharap.getDwRap().getCdRap())) {
					raps = folharap.getDwRap().getCdRap() + ", ";
				}
			}
			if (raps != null) {
				raps = raps.substring(0, raps.length() - 2);
			}
		}
		
		if (raps == null)
			raps = "---";
		
		//Marcos Sardinha: 2017-09-01 >> Defeito #4382
		Double eficiencia = calcularEficiencia(tempoPadraoSegundos, tempoTotalEmSegundos);
		
		item.setMoldeSaida(pesquisarFerramentaAnterior(consolid));
		item.setMoldeEntrada(raps);
		item.setInicioProcesso(inicioProcesso);
		item.setFinalProcesso(fimProcesso);
		item.setTempoTotal(ConversaoTipos.converteDecimalParaString(DataHoraRN.getSegundosParaMinutos((int)tempoTotalEmSegundos), 2));
		item.setProducaoBruta(String.valueOf(prodBruta));
		item.setProducaoRefugada(String.valueOf(prodRefugada));
		item.setProducaoBoa(String.valueOf(prodBoa));
		item.setTempoParadas(ConversaoTipos.converteDecimalParaString(DataHoraRN.getSegundosParaMinutos(tempoParadasSegundos.intValue()), 2));
		item.setTempoPadrao(ConversaoTipos.converteDecimalParaString(DataHoraRN.getSegundosParaMinutos(tempoPadraoSegundos), 2));
		item.setTecnicoAbertura(tecnicoAbertura);
		item.setTecnicoEncerramento(tecnicoEncerramento);
		item.setEficiencia(ConversaoTipos.converteParaString(eficiencia, 2));
		item.mudaCiplog(oco.getDwConsolciplog());
		item.setSegTempoInicioProcesso(tempoTotalEmSegundos);
		item.setSegTempoParada(tempoParadasSegundos);
		
		
		if (tempoParadasSegundos > 0d) {
			for (DwConsolpa pa : consol.getDwConsolpas()){
				Double tempoPar = (double) (
						  (pa.getSegAutoTempoparadaCp() != null ? pa.getSegAutoTempoparadaCp().doubleValue() : 0d)
						+ (pa.getSegManuTempoparadaCp() != null ? pa.getSegManuTempoparadaCp().doubleValue() : 0d)
						+ (pa.getSegAutoTempoparadaSp() != null ? pa.getSegAutoTempoparadaSp().doubleValue() : 0d) 
						+ (pa.getSegManuTempoparadaSp() != null ? pa.getSegManuTempoparadaSp().doubleValue() : 0d) )  ;
				
				
				if (tempoPar > 0d) {
					RelatorioParadasInicioProcessoDTO itemPar = new RelatorioParadasInicioProcessoDTO();
					itemPar.setMaquina(maquina);
					itemPar.setParada(pa.getDwTParada().getCdTparada() + " - " + pa.getDwTParada().getDsTparada());
					itemPar.setMoldeSaida(item.getMoldeSaida());
					itemPar.setMoldeEntrada(item.getMoldeEntrada());
					itemPar.setIdConsol(consol.getIdConsol());
					itemPar.setTempoInicioProceso(item.getTempoTotal());
					itemPar.setTempoParada(ConversaoTipos.converteDecimalParaString(DataHoraRN.getSegundosParaMinutos(tempoPar.intValue()), 2));
					itemPar.setSegTempoInicioProcesso(tempoTotalEmSegundos);
					itemPar.setSegTempoParada(tempoPar);
					
					item.getListaParadas().add(itemPar);
				}
			}
		}		

		// Verificar se existe um setup com final exatamente igual ao inicio desse. Se sim, entao o setup virou de turno, logo devemos acumular em um unico dto
		DadosRelEficienciaSetupDTO dtoPesquisado = null;
		for (DadosRelEficienciaSetupDTO dto : retorno.getItens()) {
			if (DataHoraRN.equal(dto.getDataFim(), item.getDataInicio()) ){
				dtoPesquisado = dto;
			}
		}
		if (dtoPesquisado != null) {
			dtoPesquisado.add(item);
			controle.put(consolid.getDthrIconsol(), dtoPesquisado);
		} else {
			// Verificar se ja existe uma entrada de inicio e fim. Se existir nao incluir de novo
			boolean isExiste = false;
			for (DadosRelEficienciaSetupDTO dto : retorno.getItens()) {
				if (dto.getInicioProcesso().equals(item.getInicioProcesso()) && dto.getMaquina().equals(item.getMaquina()) ) {
					isExiste = true;
				}
					
			}
			if (isExiste == false) {
				retorno.getItens().add(item);
			}
						
			controle.put(consolid.getDthrIconsol(), item);
		}
		
		return true;
	}
	
	// Pesquisa a ferramenta da OP anterrior
	private String pesquisarFerramentaAnterior(DwConsolid id) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwConsolid a");
		q.append("where a.tpId = 1");
		q.append("and a.omPt = :ompt");
		q.append("and a.ppCp <> :ppcp");
		q.append("and a.idConsolid < :id");
		q.append("order by a.idConsolid desc");
		
		q.setMaxResults(1);
		q.defineParametro("ompt", id.getOmPt());
		q.defineParametro("ppcp", id.getPpCp());
		q.defineParametro("id", id.getIdConsolid());
		
		DwConsolid result = (DwConsolid) q.uniqueResult();
		String raps = null;
		for (DwFolharap folharap : result.getDwFolha().getDwFolharaps()) {
			if (raps == null) {
				raps = folharap.getDwRap().getCdRap() + ", ";
			} else if (!raps.contains(folharap.getDwRap().getCdRap())) {
				raps = folharap.getDwRap().getCdRap() + ", ";
			}
		}
		if (raps != null) {
			raps = raps.substring(0, raps.length() - 2);
		} else
			raps = "---";
		return raps;
	}

	private ListaRelatorioParadasInicioProcessoDTO montarRelatorioParadas(DadosRelEficienciaSetupDTO cips) {
		ListaRelatorioParadasInicioProcessoDTO retorno = new ListaRelatorioParadasInicioProcessoDTO();
		retorno.setRelatorios(new ArrayList<RelatorioParadasInicioProcessoDTO>());
		
		//ordenacao
		Comparator<DadosRelEficienciaSetupDTO> comparatorMaq = new Comparator<DadosRelEficienciaSetupDTO>() {
			@Override
			public int compare(DadosRelEficienciaSetupDTO o1, DadosRelEficienciaSetupDTO o2) {
				String campo1 = o1.getMaquina() + " - " + o1.getDataInicio();
				String campo2 = o2.getMaquina() + " - " + o2.getDataInicio();
				return campo1.compareTo(campo2);
			}
		};


		//ordenacao
		Comparator<RelatorioParadasInicioProcessoDTO> comparatorPar = new Comparator<RelatorioParadasInicioProcessoDTO>() {
			@Override
			public int compare(RelatorioParadasInicioProcessoDTO o1, RelatorioParadasInicioProcessoDTO o2) {
				Double campo1 = o1.getSegTempoParada();
				Double campo2 = o2.getSegTempoParada();
				return campo1.compareTo(campo2) * -1 ;
			}
		};
		
		
		Collections.sort(cips.getItens(), comparatorMaq);
		for (DadosRelEficienciaSetupDTO item : cips.getItens()) {
			Collections.sort(item.getListaParadas(), comparatorPar);
			retorno.getRelatorios().addAll(item.getListaParadas());
		}
		

		return retorno;
	}
	
	
	


	private List<DwConsolid> consultaInicioProcesso(FiltroRelatorioIndiceParadasDTO filtro) {
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwConsols consol");
		q.append("JOIN consolid.omPt pt");
		q.append("JOIN consolid.dwFolha folha");
		q.append("left join folha.dwFolharaps folharap");
		q.append("left join folharap.dwRap rap");
		q.append("left join rap.dwRapGrupos rapgp");
		q.append("left join rapgp.dwGrupoFerramenta gpferramenta");
		q.append("left join consol.dwConsolcipocos dwconsolcipoco");
		q.append("left join dwconsolcipoco.dwConsolciplog dwconsolciplog");
		q.append("WHERE consolid.tpId = :tpid");
		q.append("and (consolid.stAtivo is null or consolid.stAtivo = 1)");
		q.append("AND consolid.dwPepro.idPepro = :idPepro");
		q.append("AND consolid.dtReferencia BETWEEN :dtincio AND :dtfim");

		if (filtro.getTurnoDTO() != null) {
			q.append("AND consolid.dwTurno.idTurno = :idturno");
		}else{
			q.append("AND consolid.dwTurno.idTurno != 1");
		}
		if (filtro.getOmpt() != null) {
			q.append("AND pt.idPt = :idPt");
		}
		if (filtro.getOmgt() != null) {
			q.append("AND pt.idPt IN (SELECT p.omPt.idPt FROM OmObj p WHERE p.omGtByIdGt.idGt = :idGt))");
		}
		if (filtro.getDwRap() != null) {
			q.append("AND rap.idRap = :idRap");
		}
		if (filtro.getDwGrupoFerramenta() != null) {
			q.append("AND gpferramenta.idGrupoFerramenta = :idgpferramenta");
		}

		q.defineParametro("tpid", (byte) 1);
		q.defineParametro("idPepro", 2L);
		q.defineParametroData("dtincio", DataHoraRN.getDataHoraInicial(filtro.getPeriodoInicial()));
		q.defineParametroData("dtfim", DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));
		
		if (filtro.getTurnoDTO() != null) {
			q.defineParametro("idturno", filtro.getTurnoDTO().getTurno().getIdTurno());
		}

		if (filtro.getOmpt() != null) {
			q.defineParametro("idPt", filtro.getOmpt().getIdPt());
		}
		if (filtro.getOmgt() != null) {
			q.defineParametro("idGt", filtro.getOmgt().getIdGt());
		}
		if (filtro.getDwRap() != null) {
			q.defineParametro("idRap", filtro.getDwRap().getIdRap());
		}
		if (filtro.getDwGrupoFerramenta() != null) {
			q.defineParametro("idgpferramenta", filtro.getDwGrupoFerramenta().getIdGrupoFerramenta());
		}
		
		List<DwConsolid> retorno = q.list();
		
		return retorno;
	}
	
	private DwConsolcipoco getDwConsolcipocoEmAberto(DwConsolid id) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwConsolciplog a");
		q.append("where a.omPt = :ompt");
		q.append("and a.dthrFcip is null");
		
		q.defineParametro("ompt", id.getOmPt());
		
		List<DwConsolciplog> logs = q.list();
		DwConsolcipoco retorno = new DwConsolcipoco();
		for (DwConsolciplog ciplog : logs) {
			
			Date dthriRef = ciplog.getDthrIcip();
			Date dthrFRef = DataHoraRN.getDataHoraAtual();
			
			if (DataHoraRN.isIntersecao(id.getDthrIturno(), id.getDthrFturno(), dthriRef, dthrFRef)) {
				if (DataHoraRN.before(dthriRef, id.getDthrIturno())) {
					dthriRef = id.getDthrIturno();
				}
				if (DataHoraRN.after(dthrFRef, id.getDthrFturno())) {
					dthrFRef = id.getDthrFturno();
				}
			
				retorno.setDthrIcip(dthriRef);
				retorno.setDthrFcip(dthrFRef);
				retorno.setDwConsolciplog(ciplog);
			}
		}
		return retorno;
	}
	
	private double calcularEficiencia(double tempoPadraoSegundos, double tempoTotalEmMinutos){
	    if(tempoPadraoSegundos != 0){
            return (tempoPadraoSegundos / tempoTotalEmMinutos) * 100d;
        }
	    return 0d;
	}
	
	private boolean isLinhasIguais(DadosRelEficienciaSetupDTO linha1, DadosRelEficienciaSetupDTO linha2){
	    if(!linha1.getMaquina().equals(linha2.getMaquina())){
	        return false;
	    }
	    if(linha1 != null && linha2 != null && linha1.getMoldeSaida() != null && linha2.getMoldeSaida() != null && !linha1.getMoldeSaida().equals(linha2.getMoldeSaida())){
	        return false;
	    }
	    if(linha1.getMoldeEntrada().equals(linha2.getMoldeEntrada()) == false){
            return false;
        }
	    
	    String dataInicioLinha1 = DataHoraRN.dateToStringDDMMYYYY(linha1.getDataInicio());
	    String dataInicioLinha2 = DataHoraRN.dateToStringDDMMYYYY(linha2.getDataInicio());
	    
	    if(!dataInicioLinha1.equals(dataInicioLinha2)){
	        return false;
	    }
	    
	    if(!linha1.getTecnicoAbertura().equals(linha2.getTecnicoAbertura())){
	        return false;
	    }
	    
	    if(!linha1.getTecnicoEncerramento().equals(linha2.getTecnicoEncerramento())){
            return false;
        }
	    
	    if(!linha1.getTempoPadrao().equals(linha2.getTempoPadrao())){
            return false;
        }
	    
	    return true;
	}
	
	private void mesclarLinhas(DadosRelEficienciaSetupDTO linha1, DadosRelEficienciaSetupDTO linha2){
		linha1.setDataFim(linha2.getDataFim());
	    linha1.setFinalProcesso(DataHoraRN.dateToStringYYYYMMDDHHMMSS(linha1.getDataFim()));
	    
	    int producaoBoa = ConversaoTipos.converterParaInt(linha1.getProducaoBoa()) 
	            + ConversaoTipos.converterParaInt(linha2.getProducaoBoa());
	    int producaoBruta = ConversaoTipos.converterParaInt(linha1.getProducaoBruta()) 
                + ConversaoTipos.converterParaInt(linha2.getProducaoBruta());
	    int producaoRefugada = ConversaoTipos.converterParaInt(linha1.getProducaoRefugada()) 
                + ConversaoTipos.converterParaInt(linha2.getProducaoRefugada());
	    
	    /*
	    double tempoParadas = ConversaoTipos.converteParaDouble(linha1.getTempoParadas()) 
	            + ConversaoTipos.converteParaDouble(linha2.getTempoParadas());
	    double tempoTotal = ConversaoTipos.converteParaDouble(linha1.getTempoTotal()) 
                + ConversaoTipos.converteParaDouble(linha2.getTempoTotal());
	    */

	    Double tempoParadas = linha1.getSegTempoParada() + linha2.getSegTempoParada();
	    //Double tempoTotal = linha1.getSegTempoInicioProcesso() + linha2.getSegTempoInicioProcesso(); 
	    int tempoTotal = DataHoraRN.getQuantidadeSegundosNoPeriodo(linha1.getDataInicio(), linha2.getDataFim());
	    
	    int tempoPadrao = ConversaoTipos.converterParaBigDecimal(linha1.getTempoPadrao()).intValue();
	    Double eficiencia = calcularEficiencia(tempoPadrao, tempoTotal);
	    
	    linha1.setProducaoBoa(String.valueOf(producaoBoa));
	    linha1.setProducaoBruta(String.valueOf(producaoBruta));
	    linha1.setProducaoRefugada(String.valueOf(producaoRefugada));

	    linha1.setTempoParadas(ConversaoTipos.converteParaString(DataHoraRN.getSegundosParaMinutos(tempoParadas.intValue()), 2));
	    linha1.setSegTempoParada(tempoParadas);
	    
	    linha1.setTempoTotal(ConversaoTipos.converteParaString(DataHoraRN.getSegundosParaMinutos(tempoTotal), 2));
	    linha1.setSegTempoInicioProcesso(new BigDecimal(tempoTotal).doubleValue());
	    linha1.setTempoProcesso(ConversaoTipos.converteDecimalParaString(DataHoraRN.getSegundosParaMinutos(tempoTotal), 2));
	    linha1.setEficiencia(ConversaoTipos.converteParaString(eficiencia, 2));

	    
	    // mesclar paradas
	    for (RelatorioParadasInicioProcessoDTO par2 : linha2.getListaParadas()) {
	    	boolean existeParada = false;
	    	
	    	for (RelatorioParadasInicioProcessoDTO par1 : linha1.getListaParadas()) {
	    		if (par1.getParada().equals(par2.getParada())) {	    			
	    			existeParada = true;
	    			par1.setSegTempoParada(par1.getSegTempoParada() + par2.getSegTempoParada());
	    			par1.setTempoParada(ConversaoTipos.converteDecimalParaString(DataHoraRN.getSegundosParaMinutos(par1.getSegTempoParada().intValue()), 2));
	    			break;
	    		}
	    	}
	    	
	    	if (! existeParada) {
	    		if (linha1.getListaParadas() != null) {
	    			if (linha1.getListaParadas().size() > 0) {
	    				par2.setIdConsol(linha1.getListaParadas().iterator().next().getIdConsol());
	    			}
	    		}
	    		linha1.getListaParadas().add(par2);
	    	}
	    }

    	for (RelatorioParadasInicioProcessoDTO par1 : linha1.getListaParadas()) {
			par1.setSegTempoInicioProcesso(new BigDecimal(tempoTotal).doubleValue());
			par1.setTempoInicioProceso(ConversaoTipos.converteDecimalParaString(DataHoraRN.getSegundosParaMinutos(par1.getSegTempoInicioProcesso().intValue()), 2));
    	}
	    
	}
	
	private void mesclarLinhasIguais(List<DadosRelEficienciaSetupDTO> linhas){
	    int numeroDaLinhaASerLida = 0;
	    while(numeroDaLinhaASerLida < linhas.size()){
	        boolean isUltimaLinha = (numeroDaLinhaASerLida + 1) == linhas.size();
	        if(isUltimaLinha){
	            break;
	        }
	        int posicaoLinha1 = numeroDaLinhaASerLida;
	        int posicaoLinha2 = numeroDaLinhaASerLida + 1;
	        DadosRelEficienciaSetupDTO linha1 = linhas.get(posicaoLinha1);
	        DadosRelEficienciaSetupDTO linha2 = linhas.get(posicaoLinha2);
	        
	        if(isLinhasIguais(linha1, linha2)){
	            mesclarLinhas(linha1, linha2);
	            linhas.remove(posicaoLinha2);
	        } else {
	            ++numeroDaLinhaASerLida;
	        }
	    }	    
	}

}