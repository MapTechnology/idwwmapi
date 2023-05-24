package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.DwTParada;
import idw.model.rn.monitorizacao.detalhes.GraficoParettoParadaRN;
import idw.util.AritmeticaUtil;
import idw.webservices.dto.FiltroRelatorioIndiceParadasDTO;
import idw.webservices.dto.ListaRelatorioOcorrenciaParadasDTO;
import idw.webservices.dto.RelatorioOcorrenciaParadasDTO;

public class RelatorioOcorrenciaParadasRN extends AbstractParadaRN {

	public RelatorioOcorrenciaParadasRN() {
		this(null);
	}

	public RelatorioOcorrenciaParadasRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	/*
	 * MEtodo principal para criacao do relatorio
	 */
	public ListaRelatorioOcorrenciaParadasDTO getConsolpaocoDTO(FiltroRelatorioIndiceParadasDTO filtro) {
		List<DwConsolpaoco> listaConsolpaoco = new ArrayList<>();
		MapQuery q = new MapQuery(getDaoSession());
		
		if (filtro.getIsTodasAreas()  && filtro.getIsTodasParadas()) {
			listaConsolpaoco.addAll(getListaDwConsolpaoco(q, filtro, null, null));			
		}else if (filtro.getIsTodasAreas() == false && filtro.getIsTodasParadas() == true && filtro.getDwTAreas() != null) {
			for(DwTArea area : filtro.getDwTAreas()) {
				listaConsolpaoco.addAll(getListaDwConsolpaoco(q, filtro, null, area));				
			}
		}else if (filtro.getIsTodasAreas() == true && filtro.getIsTodasParadas() == false && filtro.getDwTParadas() != null){
			for(DwTParada parada : filtro.getDwTParadas()) {
				listaConsolpaoco.addAll(getListaDwConsolpaoco(q, filtro, parada, null));				
			}
		}
		
		else if (filtro.getIsTodasAreas() == false && filtro.getIsTodasParadas() == false && filtro.getDwTParadas() != null && filtro.getDwTAreas() != null){
			for(DwTParada parada : filtro.getDwTParadas()) {
				listaConsolpaoco.addAll(getListaDwConsolpaoco(q, filtro, parada, null));				
			}
			for(DwTArea area : filtro.getDwTAreas()) {
				listaConsolpaoco.addAll(getListaDwConsolpaoco(q, filtro, null, area));
			}
		}
				
		else if (filtro.getIsTodasAreas() == false && filtro.getIsTodasParadas() == true && filtro.getDwTAreas() == null ) {
			for(DwTParada parada : filtro.getDwTParadas()) {
				listaConsolpaoco.addAll(getListaDwConsolpaoco(q, filtro, parada, null));
			}
		
		}else if(filtro.getIsTodasAreas() == true && filtro.getIsTodasParadas() == false && filtro.getDwTParadas() == null ){
			for(DwTArea area : filtro.getDwTAreas()) {
				listaConsolpaoco.addAll(getListaDwConsolpaoco(q, filtro, null, area));
			}
		} else if (filtro.getDwTAreas() != null && filtro.getDwTParadas() != null) {
			for(DwTArea area : filtro.getDwTAreas()) {
				for(DwTParada parada : filtro.getDwTParadas()) {
					listaConsolpaoco.addAll(getListaDwConsolpaoco(q, filtro, parada, area));
				}
			}
		} else if(filtro.getIsTodasAreas() == false 
				&& filtro.getDwTAreas() == null 
				&& filtro.getIsTodasParadas() == false
				&& filtro.getDwTParadas() != null){
			for(DwTParada parada : filtro.getDwTParadas()) {
				listaConsolpaoco.addAll(getListaDwConsolpaoco(q, filtro, parada, null));
			}
		} else if(filtro.getIsTodasAreas() == false 
				&& filtro.getDwTAreas() != null 
				&& filtro.getIsTodasParadas() == false
				&& filtro.getDwTParadas() == null){
			for(DwTArea area : filtro.getDwTAreas()) {
				listaConsolpaoco.addAll(getListaDwConsolpaoco(q, filtro, null, area));
			}
		}
		
		listaConsolpaoco = removeConsolpaocoComIdRepetido(listaConsolpaoco);

		return montaRelatorioOcorrenciaParadas(filtro, listaConsolpaoco);

	}

	private ListaRelatorioOcorrenciaParadasDTO montaRelatorioOcorrenciaParadas(
			FiltroRelatorioIndiceParadasDTO filtro,
			List<DwConsolpaoco> listaConsolpaoco) {

		BigDecimal tempoTotalParadasCP = BigDecimal.ZERO;
		BigDecimal tempoTotalParadasSP = BigDecimal.ZERO;
		
		ListaRelatorioOcorrenciaParadasDTO retorno = new ListaRelatorioOcorrenciaParadasDTO();
		retorno.setOcorrenciaParadasDTOs(new ArrayList<RelatorioOcorrenciaParadasDTO>());

		/* Incluir em listaConsolpaoco a referencia da parada em aberto */
		GraficoParettoParadaRN rn = new GraficoParettoParadaRN(getDao());

		Set<DwConsolid> ids = new HashSet<DwConsolid>();

		
		if (filtro.getIsTodasParadas() != null && filtro.getIsTodasParadas() == true) {
			
			ids.addAll(getListaIds(filtro, null,null));

		} else if (filtro.getDwTParadas() != null && filtro.getDwTAreas() == null) {
			for (DwTParada parada : filtro.getDwTParadas()) {
				ids.addAll(getListaIds(filtro, parada, null));
			}

		} else if (filtro.getDwTAreas() != null && filtro.getDwTParadas() == null) {
			for (DwTArea area : filtro.getDwTAreas()) {
				ids.addAll(getListaIds(filtro, null, area));
			}
		} else {
			for (DwTArea area : filtro.getDwTAreas()) {
				for (DwTParada parada : filtro.getDwTParadas()) {
					ids.addAll(getListaIds(filtro, parada, area));
				}
			}
		}

		
		for (DwConsolpaoco dwConsolpaoco : listaConsolpaoco) {
			
			if (dwConsolpaoco.getDthrFparada() == null) {
				continue;
			}
			
			DwConsolpa dwConsolpa = dwConsolpaoco.getDwConsolpa();
			
			long duracaoMiliSegundos = DataHoraRN.getQuantidadeMilisegundosNoPeriodo(
					dwConsolpaoco.getDthrIparada(),
					dwConsolpaoco.getDthrFparada());
			
			if (dwConsolpaoco.getDwConsolpa().getDwTParada().getIsPesa() != null && dwConsolpaoco.getDwConsolpa().getDwTParada().getIsPesa() == false) {
				tempoTotalParadasSP = AritmeticaUtil.somar(tempoTotalParadasSP, duracaoMiliSegundos);
			} else {
				tempoTotalParadasCP = AritmeticaUtil.somar(tempoTotalParadasCP, duracaoMiliSegundos);
			}
			
			DwConsolid dwConsolid = dwConsolpa.getDwConsol().getDwConsolid();
			
			String omPt = dwConsolid != null ? dwConsolid.getOmPt().getCdPt() : "";
			String parada = dwConsolpa.getDwTParada() != null ? 
					dwConsolpa.getDwTParada().getCdTparada()
					+ " - "
					+ dwConsolpa.getDwTParada().getDsTparada()
					: "";
			
			DwTCausa dwTCausa = dwConsolpaoco.getDwTCausa();
			
			String causa = dwTCausa != null ? 
					dwTCausa.getCdTcausa() + " - "+ dwTCausa.getDsTcausa()
					: "---";

			String dthrInicio = "";
			if (dwConsolpaoco.getDthrIparada() != null) {
				dthrInicio = DataHoraRN
						.dateToStringDDMMYYYYHHMMSS(dwConsolpaoco
								.getDthrIparada());
			}

			String dthrFinal = "";
			if (dwConsolpaoco.getDthrFparada() != null) {
				dthrFinal = DataHoraRN.dateToStringDDMMYYYYHHMMSS(dwConsolpaoco
						.getDthrFparada());
			}

			RelatorioOcorrenciaParadasDTO relatorio = new RelatorioOcorrenciaParadasDTO();
			relatorio.setMaquina(omPt);
			relatorio.setParada(parada);
			relatorio.setCausa(causa);
			relatorio.setDthrInicio(dthrInicio);
			relatorio.setDthrFinal(dthrFinal);			


			relatorio.setDuracao(DataHoraRN.formatMilisegundosParaHHMMSSmmm(duracaoMiliSegundos));
			retorno.getOcorrenciaParadasDTOs().add(relatorio);

		}
		
		BigDecimal totalTempoTodasParadas =  AritmeticaUtil.somar(tempoTotalParadasCP, tempoTotalParadasSP);

		retorno.setTempoTotalParadas(DataHoraRN.formatMilisegundosParaHHMMSSmmm(totalTempoTodasParadas.longValue()));
		retorno.setTempoTotalParadasCP(DataHoraRN.formatMilisegundosParaHHMMSSmmm(tempoTotalParadasCP.longValue()));
		retorno.setTempoTotalParadasSP(DataHoraRN.formatMilisegundosParaHHMMSSmmm(tempoTotalParadasSP.longValue()));

		Comparator<RelatorioOcorrenciaParadasDTO> comparator = new Comparator<RelatorioOcorrenciaParadasDTO>() {
			@Override
			public int compare(RelatorioOcorrenciaParadasDTO o1,
					RelatorioOcorrenciaParadasDTO o2) {
				String omPt1 = o1.getMaquina();
				String omPt2 = o2.getMaquina();
				int o = omPt1.compareTo(omPt2);
				if (o == 0)
					o = o1.getDthrInicio().compareTo(o2.getDthrFinal());

				return o;
			}
		};
		Collections.sort(retorno.getOcorrenciaParadasDTOs(), comparator);
		return retorno;

	}

	// Pesquisa as ocorreencias das paradas fechadas
	private List<DwConsolpaoco> getListaDwConsolpaoco(MapQuery q,
			FiltroRelatorioIndiceParadasDTO filtro, DwTParada parada,
			DwTArea area) {
		q.novaConsulta();

		q.append("SELECT distinct consolpaoco");
		q.append("FROM DwConsolpaoco consolpaoco");

		q.append("JOIN consolpaoco.dwConsolpa consolpa");
		q.append("JOIN consolpa.dwConsol consol");
		q.append("JOIN consol.dwConsolid consolid");
		q.append("join consolid.ppCp ppcp");
		q.append("join ppcp.ppCpprodutos ppcpproduto");

		q.append("LEFT JOIN consolpa.dwTParada parada");
		q.append("left JOIN parada.dwTArea area");
		q.append("JOIN consolid.dwFolha folha");
		q.append("left JOIN folha.dwFolharaps folharap");
		q.append("left JOIN folharap.dwRap rap");
		q.append("JOIN consolid.omPt ompt");
		q.append("LEFT JOIN ompt.omObjs omobj");
		q.append("LEFT JOIN rap.dwRapGrupos rapgrupo");
		q.append("LEFT JOIN rapgrupo.dwGrupoFerramenta gpferramenta");

		q.append("WHERE consolid.tpId = :tpId");

		if (filtro.getPeriodoInicial() != null
				&& filtro.getPeriodoFinal() != null) {
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
			q.append("AND omobj.omGtByIdGt.idGt = :idgt");
		}
		if (filtro.getDwRap() != null) {
			q.append("AND rap.idRap = :idrap");
		}
		if (filtro.getDwGrupoFerramenta() != null) {
			q.append("AND gpferramenta.idGrupoFerramenta = :idgpRap");
		}
		if (parada != null) {
			q.append("AND parada.cdTparada = :idparada");
		}
		if (area != null) {
			q.append("AND area.cdArea = :idarea");
		}

		q.defineParametro("tpId", (byte) 1);
		q.defineParametro("cdop", filtro.getCdop());

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
		if (parada != null) {
			q.defineParametro("idparada", parada.getCdTparada());
		}
		if (area != null) {
			q.defineParametro("idarea", area.getCdArea());
		}
		if (filtro.getPeriodoInicial() != null
				&& filtro.getPeriodoFinal() != null) {
			q.defineParametroTimestamp("dataincial",
					DataHoraRN.getDataHoraInicial(filtro.getPeriodoInicial()));
			q.defineParametroTimestamp("datafinal",
					DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));
		}

		return q.list();
	}

	private List<DwConsolid> getListaIds(FiltroRelatorioIndiceParadasDTO filtro,DwTParada parada,
			DwTArea area) {

		MapQuery q = new MapQuery(getDaoSession());

		q.append("select distinct consolid");
		q.append("FROM DwConsolid consolid");
		q.append("join consolid.ppCp ppcp");
		q.append("join consolid.dwConsols consol");
		q.append("join consol.dwConsolpas consolpa");
		q.append("LEFT JOIN consolpa.dwTParada parada");
		q.append("left JOIN parada.dwTArea area");

		q.append("join ppcp.ppCpprodutos ppcpproduto");
		q.append("JOIN consolid.dwFolha folha");
		q.append("left JOIN folha.dwFolharaps folharap");
		q.append("left JOIN folharap.dwRap rap");
		q.append("JOIN consolid.omPt ompt");
		q.append("LEFT JOIN ompt.omObjs obj");
		q.append("LEFT JOIN obj.omGtByIdGt gt");
		q.append("LEFT JOIN rap.dwRapGrupos rapgrupo");
		q.append("LEFT JOIN rapgrupo.dwGrupoFerramenta gpferramenta");

		q.append("WHERE consolid.tpId = :tpId");

		if (filtro.getPeriodoInicial() != null
				&& filtro.getPeriodoFinal() != null) {
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
		
		if (parada != null) {
			q.append("AND parada.idTparada = :idparada");
		}
		if (area != null) {
			q.append("AND area.idArea = :idarea");
		}
		
		if (filtro.getDwRap() != null) {
			q.append("AND rap.idRap = :idrap");
		}
		if (filtro.getDwGrupoFerramenta() != null) {
			q.append("AND gpferramenta.idGrupoFerramenta = :idgpRap");
		}

		q.defineParametro("tpId", (byte) 1);
		q.defineParametro("cdop", filtro.getCdop());

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
		if (parada != null) {
			q.defineParametro("idparada", parada.getIdTparada());
		}
		if (area != null) {
			q.defineParametro("idarea", area.getIdArea());
		}
		
		
		if (filtro.getPeriodoInicial() != null
				&& filtro.getPeriodoFinal() != null) {
			q.defineParametroTimestamp("dataincial",
					DataHoraRN.getDataHoraInicial(filtro.getPeriodoInicial()));
			q.defineParametroTimestamp("datafinal",
					DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));
		}

		return q.list();
	}

}
