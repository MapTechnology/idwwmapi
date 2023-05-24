package idw.model.rn.monitorizacao.detalhes;

import java.awt.Color;
import java.awt.Paint;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolvaritmo;
import idw.model.pojos.DwConsolvaritmolog;
import idw.model.pojos.DwConsolvaritmologcau;
import idw.model.pojos.DwConsolvaritmooco;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.consolidacao.variacaoritmo.ConsolidacaoInicioVariacaoRitmo;
import idw.model.rn.geraplano.dtos.DatasDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParettoRitmoDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficosParettoRitmoDTO;
import idw.util.GrafTendenciaUtils;
import idw.util.IdwLogger;
import idw.util.IntervaloGrafTendenciaRefugoParada;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.OcorrenciasEvtDTO;

public class GraficoParettoRitmoRN extends AbstractRN<DAOGenerico> {
	
	public GraficoParettoRitmoRN(){
		this(new DAOGenerico());
	}
	
	public GraficoParettoRitmoRN(DAOGenerico dao) {
		super(dao);
	}

	public GraficosParettoRitmoDTO getGraficoParettoRitmoDTO(FiltroDetalhePTInjetDTO filtroMaquina){
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "GraficoParettoRitmoRN.getGraficoParettoRitmoDTO");
		log.info( idLog , 0, "GraficoParettoRitmoRN.getGraficoParettoRitmoDTO filtro usado:" + filtroMaquina.toString());
		
		GraficosParettoRitmoDTO grafico = new GraficosParettoRitmoDTO();
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT dwConsolvaritmo");		
		q.append("FROM DwConsolvaritmo dwConsolvaritmo");		
		q.append("JOIN dwConsolvaritmo.dwConsol dwconsol");
		q.append("JOIN dwconsol.dwConsolid dwconsolid");
		q.append("JOIN dwConsolvaritmo.dwTRitmo dwTRitmo");
		q.append("JOIN dwConsolvaritmo.dwConsolvaritmoocos dwConsolvaritmooco");
		q.append("WHERE dwconsolid.tpId = 1");
		q.append("and (dwconsolid.stAtivo is null or dwconsolid.stAtivo = 1)");
		
		if (filtroMaquina.getDwTurno() != null)
			q.append("and dwconsolid.dwTurno = :dwturno");
		
		if (filtroMaquina.getDtReferenciaInicial() != null)
			q.append("AND dwconsolid.dtReferencia between :dtinicial and :dtfinal");
		
		q.append("and dwconsolid.omPt = :ompt");
		q.append("and dwconsolid.ppCp = :ppcp");
		
		q.defineParametro("ompt", filtroMaquina.getOmPt());
		q.defineParametro("ppcp", filtroMaquina.getPpCp());
		
		q.defineParametroData("dtinicial", filtroMaquina.getDtReferenciaInicial());
		q.defineParametroData("dtfinal", filtroMaquina.getDtReferenciaFinal());
		q.defineParametro("dwturno", filtroMaquina.getDwTurno());
		
		List<DwConsolvaritmo> listaPesquisa = q.list();
		
		List<GraficoParettoRitmoDTO> ritmos = new ArrayList<>();
		HashMap<Long, List<OcorrenciasEvtDTO>> ocorrenciasPorRitmo = new HashMap<Long, List<OcorrenciasEvtDTO>>();
		Date menorDataInicioRitmo = null;
		Date maiorDataFimRitmo = null;
		
		/*
		 * Verificar se existe um evento de ritmo em aberto, adiciona-lo a lista para tambem ser processado
		 */
		ConsolidacaoInicioVariacaoRitmo rn = new ConsolidacaoInicioVariacaoRitmo();
		rn.setDao(getDao());
		DwConsolvaritmolog logaberto = rn.pesquisarDwConsolvaritmologUnicoEmAberto(filtroMaquina.getOmPt());
		if (logaberto != null) {

			// Cria o pojo a partir de dwconsolvaritmolog
			List<DwConsolvaritmo> listaAberto = criarAPartirDwConsolvaritmolog(logaberto);

			// Verifica se algum elemento da lista em aberto ja existe consolidado, se sim,
			// clonar e acumular o em aberto. Se nao incluir na lista
			List<DwConsolvaritmo> listaAbertoFinal = new ArrayList<>();
			for (DwConsolvaritmo aberto : listaAberto) {
				boolean isExiste = false;
				Iterator<DwConsolvaritmo> i = listaPesquisa.iterator(); 
				while ( i.hasNext() ) {
					DwConsolvaritmo fechado = i.next();
					
					if (aberto.getDwTRitmo().getCdTritmo().equals(fechado.getDwTRitmo().getCdTritmo())) {
						isExiste = true;
						
						// Clona fechado
						DwConsolvaritmo clonado = fechado.clone();
						
						// Acumula aberto no clonado
						clonado.setSegAutoTemporitmo(clonado.getSegAutoTemporitmo().add(aberto.getSegAutoTemporitmo()));
						clonado.getDwConsolvaritmoocos().addAll(aberto.getDwConsolvaritmoocos());
						
						// coloca na lista aberto final
						listaAbertoFinal.add(clonado);
						
						// remove da listaPesquisa o elemento clonado
						i.remove();
					}
				}
				if (isExiste == false) {
					listaAbertoFinal.add(aberto);
				}
			}
			listaPesquisa.addAll(listaAbertoFinal);
		}
		
		
		for(DwConsolvaritmo consolvaritmo : listaPesquisa){
			long idTritmo = consolvaritmo.getDwTRitmo().getIdTritmo();
			String dsTritmo = consolvaritmo.getDwTRitmo().getDsTritmo();
			String cdTritmo = consolvaritmo.getDwTRitmo().getCdTritmo();
			
			GraficoParettoRitmoDTO dto = new GraficoParettoRitmoDTO();
			dto.setIdTritmo(idTritmo);
			dto.setDsTritmo(dsTritmo);
			dto.setCdTritmo(cdTritmo);
			
			// Verificar se ja existe a ocorrencia na lista ritmo, se exisitr ignorar
			boolean isExiste = false;
			for (GraficoParettoRitmoDTO idto : ritmos) {
				if (idto.getCdTritmo().equals(dto.getCdTritmo()) ) {
					isExiste = true;
					dto = idto; // assim as ocorrencias serao atualizadas
				}
			}
			if (isExiste == false)
				ritmos.add(dto);

			for(DwConsolvaritmooco oco : consolvaritmo.getDwConsolvaritmoocos()){
				Date inicioRitmo = oco.getDthrIvaritmo();
				Date fimRitmo = oco.getDthrFvaritmo();
				
				menorDataInicioRitmo = getMenorData(menorDataInicioRitmo, inicioRitmo);
				maiorDataFimRitmo = getMaiorData(maiorDataFimRitmo, fimRitmo);
				
				List<OcorrenciasEvtDTO> listaOcoDTO = ocorrenciasPorRitmo.get(idTritmo);
				if(listaOcoDTO == null){
					listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
					OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
					ocoDTO.setIdEvt(idTritmo);
					ocoDTO.setDthrIni(inicioRitmo);
					ocoDTO.setDthrFim(fimRitmo);
					ocoDTO.setDsritmo(cdTritmo + "-" + dsTritmo);
					
					int duracaoEvt = DataHoraRN.getQuantidadeSegundosNoPeriodo(inicioRitmo, fimRitmo);
					ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
					ocoDTO.setMsDtHrIni(new BigDecimal(inicioRitmo.getTime()));
					ocoDTO.setMsDtHrFim(new BigDecimal(fimRitmo.getTime()));
					
					listaOcoDTO.add(ocoDTO);
					ocorrenciasPorRitmo.put(idTritmo, listaOcoDTO);
					
					// adicionar somente se nao existir a ocorrencia
					boolean isExiste2 = false;
					for (OcorrenciasEvtDTO oevt : dto.getOcorrencias()) {
						oevt.setDthrIni(DataHoraRN.setMiliNaData(oevt.getDthrIni(), 0));
						ocoDTO.setDthrIni(DataHoraRN.setMiliNaData(ocoDTO.getDthrIni(), 0));
						if (oevt.getDthrIni().equals(ocoDTO.getDthrIni()))
							isExiste2 = true;
					}
					if (isExiste2 == false) {
						dto.getOcorrencias().add(ocoDTO);
						// atualiza duracao
						dto.setDuracao(dto.getDuracao() + duracaoEvt);
						dto.setDuracaoFormatado(DataHoraRN.formatSegundosParaHHMMSS((int) dto.getDuracao()));
					}
				}else{
					OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
					ocoDTO.setIdEvt(idTritmo);
					ocoDTO.setDthrIni(inicioRitmo);
					ocoDTO.setDthrFim(fimRitmo);
					ocoDTO.setDsritmo(cdTritmo + "-" + dsTritmo);
					
					int duracaoEvt = DataHoraRN.getQuantidadeSegundosNoPeriodo(inicioRitmo, fimRitmo);
					ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
					ocoDTO.setMsDtHrIni(new BigDecimal(inicioRitmo.getTime()));
					ocoDTO.setMsDtHrFim(new BigDecimal(fimRitmo.getTime()));
					
					listaOcoDTO.add(ocoDTO);
					
					// adicionar somente se nao existir a ocorrencia
					boolean isExiste2 = false;
					for (OcorrenciasEvtDTO oevt : dto.getOcorrencias()) {
						oevt.setDthrIni(DataHoraRN.setMiliNaData(oevt.getDthrIni(), 0));
						ocoDTO.setDthrIni(DataHoraRN.setMiliNaData(ocoDTO.getDthrIni(), 0));
						if (oevt.getDthrIni().equals(ocoDTO.getDthrIni()))
							isExiste2 = true;
					}
					if (isExiste2 == false) {
						// atualiza duracao
						dto.setDuracao(dto.getDuracao() + duracaoEvt);
						dto.setDuracaoFormatado(DataHoraRN.formatSegundosParaHHMMSS((int) dto.getDuracao()));
						dto.getOcorrencias().add(ocoDTO);
					}
				}
			}		
			
		}
		
		grafico.setRitmos(ritmos);
		
		//Gerar valores da legenda
		GrafTendenciaUtils algoritmoGraf = null;
		if(menorDataInicioRitmo != null && maiorDataFimRitmo != null){
			algoritmoGraf = new GrafTendenciaUtils(menorDataInicioRitmo, maiorDataFimRitmo);
		}
		
		if (algoritmoGraf != null) {
			defineCoresLegendaEBarra(algoritmoGraf, grafico, ocorrenciasPorRitmo);
		}	
		log.mostrarAvaliacaoCompleta();
		return grafico;
	}
	
	private Date getMenorData(Date data1, Date data2){
		if(data1 != null && data2 == null){
			return data1;
		}
		
		if(data1 == null && data2 != null){
			return data2;
		}
		
		if(data1 == null && data2 == null){
			return null;
		}
		
		if(DataHoraRN.before(data1, data2)){
			return data1;
		} else {
			return data2;
		}
	}
	
	private Date getMaiorData(Date data1, Date data2){
		if(data1 != null && data2 == null){
			return data1;
		}
		
		if(data1 == null && data2 != null){
			return data2;
		}
		
		if(data1 == null && data2 == null){
			return null;
		}
		
		if(DataHoraRN.after(data1, data2)){
			return data1;
		} else {
			return data2;
		}
	}
	
	private void defineCoresLegendaEBarra(GrafTendenciaUtils algoritmoGraf, GraficosParettoRitmoDTO retorno, HashMap<Long, List<OcorrenciasEvtDTO>> ocorrenciasPorRitmo){
		if(algoritmoGraf.getIntervaloGrafTend() != null && !algoritmoGraf.getIntervaloGrafTend().isEmpty()){
			for(IntervaloGrafTendenciaRefugoParada intervalo : algoritmoGraf.getIntervaloGrafTend()){
				if(intervalo.getCorIntervalo().equals(Color.YELLOW)){
					DatasDTO datasAmarelo = new DatasDTO();
					datasAmarelo.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
					datasAmarelo.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
					retorno.setCorAmarela(datasAmarelo);
				}
				if(intervalo.getCorIntervalo().equals(Color.ORANGE)){
					DatasDTO datasLaranja = new DatasDTO();
					datasLaranja.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
					datasLaranja.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
					retorno.setCorLaranja(datasLaranja);
				}
				if(intervalo.getCorIntervalo().equals(Color.GREEN)){
					DatasDTO datasVerde = new DatasDTO();
					datasVerde.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
					datasVerde.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
					retorno.setCorVerde(datasVerde);
				}
				if(intervalo.getCorIntervalo().equals(Color.RED)){
					DatasDTO datasVermelho = new DatasDTO();
					datasVermelho.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
					datasVermelho.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
					retorno.setCorVermelho(datasVermelho);
				}
			}
		}
		
		for(GraficoParettoRitmoDTO ritmo : retorno.getRitmos()){
			List<OcorrenciasEvtDTO> listaOco = ocorrenciasPorRitmo.get(ritmo.getIdTritmo());
			if (listaOco != null && listaOco.size() > 0) {
				Paint paint = algoritmoGraf.corBarraTendencia(ritmo.getIdTritmo(), listaOco);
				Color cor = (Color) paint;
				ritmo.setCorBarra(String.valueOf(cor.getRGB()));
			}
		}
	}
	
	private List<DwConsolvaritmo> criarAPartirDwConsolvaritmolog(DwConsolvaritmolog log) {
		List<DwConsolvaritmo> listaRetorno = new ArrayList<>();
		Date inicio = log.getDthrIvaritmo();
		Date fim = DataHoraRN.getDataHoraAtual();
		Integer duracao = DataHoraRN.getQuantidadeSegundosNoPeriodo(inicio, fim);
		
		for (DwConsolvaritmologcau causa : log.getDwConsolvaritmologcaus()) {
			
			DwConsolvaritmo pojo = new DwConsolvaritmo();
			
			pojo.setDwTRitmo(causa.getDwTRitmo().clone(false));
			pojo.setSegAutoTemporitmo(new BigDecimal(duracao));
			
			DwConsolvaritmooco oco = new DwConsolvaritmooco();
			oco.setDthrIvaritmo(inicio);
			oco.setDthrFvaritmo(fim);
			oco.setDwConsolvaritmolog(log);
			
			pojo.getDwConsolvaritmoocos().add(oco);
			
			listaRetorno.add(pojo);
		}
		
		return listaRetorno;
	}
}
