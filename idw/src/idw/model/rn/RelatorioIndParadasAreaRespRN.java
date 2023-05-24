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
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTParada;
import idw.webservices.dto.FiltroRelatorioIndiceParadasDTO;
import idw.webservices.dto.ListaRelatorioIndiceParadaAreaRespDTO;
import idw.webservices.dto.RelatorioIndiceParadaAreaResponsavelDTO;

public class RelatorioIndParadasAreaRespRN extends AbstractParadaRN {

	public RelatorioIndParadasAreaRespRN() {
		this(null);
	}

	public RelatorioIndParadasAreaRespRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	public ListaRelatorioIndiceParadaAreaRespDTO getConsolpasAreaRespDTO(FiltroRelatorioIndiceParadasDTO filtro) {
		List<DwConsolpa> listaConsolpa = new ArrayList<>();
		MapQuery q = new MapQuery(getDaoSession());

		
		if ((filtro.getIsTodasParadas() == true && filtro.getIsTodasAreas() == true)  ||
			(filtro.getIsTodasParadas() == true && filtro.getDwTAreas() == null)  ||
			(filtro.getIsTodasAreas() == true && filtro.getDwTParadas() == null) 
			){
			listaConsolpa.addAll(getListaDwConsolpa(q, filtro, null, null));
			
		} else if (filtro.getDwTParadas() != null && filtro.getDwTAreas() == null) {
			for (DwTParada parada : filtro.getDwTParadas()) {
				listaConsolpa.addAll(getListaDwConsolpa(q, filtro, parada, null));
			}

		} else if (filtro.getDwTAreas() != null && filtro.getDwTParadas() == null) {
			for (DwTArea area : filtro.getDwTAreas()) {
				listaConsolpa.addAll(getListaDwConsolpa(q, filtro, null, area));
			}
		} else {
			for (DwTArea area : filtro.getDwTAreas()) {
				for (DwTParada parada : filtro.getDwTParadas()) {
					List<DwConsolpa> listaAux = getListaDwConsolpa(q, filtro, parada, area);
					for (DwConsolpa pa : listaAux) {
						if (listaConsolpa.contains(pa)== false)
							listaConsolpa.add(pa);
					}
					
				}
			}
		}		
		
		return montaRelatorioIndiceParadaAreaResp(listaConsolpa, filtro);

	}

	public List<DwConsolpa> getListaDwConsolpa(MapQuery q,
			FiltroRelatorioIndiceParadasDTO filtro, DwTParada parada,
			DwTArea area) {
		q.novaConsulta();
		q.append("SELECT distinct consolpa");
		q.append("FROM DwConsolpa consolpa");
		q.append("JOIN consolpa.dwConsol consol");
		q.append("JOIN consol.dwConsolid consolid");
		q.append("JOIN consolid.ppCp ppcp");
		q.append("JOIN ppcp.ppCpprodutos ppcpproduto");
		q.append("LEFT JOIN consolid.omPt pt");
		q.append("LEFT JOIN pt.omObjs omobj");
		q.append("LEFT JOIN consolpa.dwTParada parada");
		q.append("LEFT JOIN parada.dwTArea area");
		q.append("LEFT JOIN consolid.dwFolha folha");
		q.append("LEFT JOIN folha.dwFolharaps folharap");
		q.append("LEFT JOIN folharap.dwRap rap");
		q.append("LEFT JOIN rap.dwRapGrupos rapgrupo");
		q.append("LEFT JOIN rapgrupo.dwGrupoFerramenta grupoferramenta");
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
			q.append("AND consolid.dwTurno.idTurno <> 1");
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
			q.append("AND grupoferramenta.idGrupoFerramenta = :idgpRap");
		}
		if (parada != null) {
			//Marcos Sardinha: 2017-06-02 >> validacao deve ser pelo id pq o codigo pode estar vinculado a mais de um tipo de pt
			//q.append("AND parada.cdTparada = :cdTparada");
			q.append("AND parada.idTparada = :idTparada");
		}
		if (area != null) {
			q.append("AND area.cdArea = :cdArea");
		}

		q.defineParametro("tpId", (byte) 1);
		q.defineParametro("cdop", filtro.getCdop());

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
			q.defineParametro("idturno", filtro.getTurnoDTO().getTurno()
					.getIdTurno());
		}
		if (parada != null) {
			//Marcos Sardinha: 2017-06-02 >> validacao deve ser pelo id pq o codigo pode estar vinculado a mais de um tipo de pt
			//q.defineParametro("cdTparada", parada.getCdTparada());
			q.defineParametro("idTparada", parada.getIdTparada());
		}
		if (area != null) {
			q.defineParametro("cdArea", area.getCdArea());
		}
		if (filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null) {
			q.defineParametroTimestamp("dataincial", filtro.getPeriodoInicial());
			q.defineParametroTimestamp("datafinal", DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));
		}
		
		List<DwConsolpa> retorno = q.list();
		return retorno;
	}

	private ListaRelatorioIndiceParadaAreaRespDTO montaRelatorioIndiceParadaAreaResp(
			List<DwConsolpa> listaDwConsolpa,
			FiltroRelatorioIndiceParadasDTO filtro) {

		HashMap<String, RelatorioIndiceParadaAreaResponsavelDTO> mapRelatorioParadaAreaResp = new HashMap<>();

		//Marcos Sardinha: 2017-06-02 -- deve considerar os milissegundos (variaveis de totalizacao de tempo eram int)
		Double tempoTotalParadasCP = 0d;
		Double tempoTotalParadasSP = 0d;

		for (DwConsolpa dwConsolpa : listaDwConsolpa) {
			Double contador = 0d;
			for(DwConsolpaoco oco : dwConsolpa.getDwConsolpaocos()){
				contador += DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodo(oco.getDthrIparada(), oco.getDthrFparada()).doubleValue() ;
			}
			
			if (dwConsolpa.getDwTParada().getIsPesa() != null && dwConsolpa.getDwTParada().getIsPesa() == false) {
				tempoTotalParadasSP += contador;
	        } else {
	        	tempoTotalParadasCP += contador;
	        }			
			
			Double tempo = contador ;
			
			String parada = dwConsolpa.getDwTParada() != null ? dwConsolpa
					.getDwTParada().getCdTparada()
					+ "-"
					+ dwConsolpa.getDwTParada().getDsTparada() : "";
			String areaResp = dwConsolpa.getDwTParada().getDwTArea() != null ? dwConsolpa
					.getDwTParada().getDwTArea().getCdArea()
					+ "-" + dwConsolpa.getDwTParada().getDwTArea().getDsArea()
					: "";
			String chave = areaResp + parada;

			RelatorioIndiceParadaAreaResponsavelDTO relatorio = mapRelatorioParadaAreaResp.get(chave);
			if (relatorio == null) {
				relatorio = new RelatorioIndiceParadaAreaResponsavelDTO();
				relatorio.setAreaResponsavel(areaResp);
				relatorio.setParada(parada);
				relatorio.setTempo(tempo.toString());
				mapRelatorioParadaAreaResp.put(chave, relatorio);
			} else {
				Double tempoAux = Double.parseDouble(relatorio.getTempo());
				tempoAux = tempoAux + tempo;
				relatorio.setTempo(tempoAux.toString());
			}
		}

		Double totalTempoTodasParadas = tempoTotalParadasCP + tempoTotalParadasSP;

		ListaRelatorioIndiceParadaAreaRespDTO retorno = new ListaRelatorioIndiceParadaAreaRespDTO();
		retorno.setAreaResponsavelDTOs(new ArrayList<RelatorioIndiceParadaAreaResponsavelDTO>());
		retorno.setTempoTotalParadas(DataHoraRN
				.formatSegundosParaHHMMSSmmm(totalTempoTodasParadas));
		retorno.setTempoTotalParadasCP(DataHoraRN
				.formatSegundosParaHHMMSSmmm(tempoTotalParadasCP));
		retorno.setTempoTotalParadasSP(DataHoraRN
				.formatSegundosParaHHMMSSmmm(tempoTotalParadasSP));

		int i = 0;
		List<RelatorioIndiceParadaAreaResponsavelDTO> listaDadosRelatorio = new ArrayList<>();

		for (String chave : mapRelatorioParadaAreaResp.keySet()) {
			RelatorioIndiceParadaAreaResponsavelDTO relatorio = mapRelatorioParadaAreaResp
					.get(chave);
			Double tempoTotalParada = Double.parseDouble(relatorio.getTempo());
			if (tempoTotalParada.doubleValue() <= 0) {
				continue;
			}
			listaDadosRelatorio.add(relatorio);
		}

		Comparator<RelatorioIndiceParadaAreaResponsavelDTO> comparator = new Comparator<RelatorioIndiceParadaAreaResponsavelDTO>() {
			@Override
			public int compare(RelatorioIndiceParadaAreaResponsavelDTO o1,
					RelatorioIndiceParadaAreaResponsavelDTO o2) {

				int retorno = 0;
				if (o1.getAreaResponsavel().compareTo(o2.getAreaResponsavel()) == 0) {
					retorno = o1.getParada().compareTo(o2.getParada());
				} else {
					retorno = o1.getAreaResponsavel().compareTo(
							o2.getAreaResponsavel());
				}
				return retorno;
			}
		};

		Collections.sort(listaDadosRelatorio, comparator);

		for (RelatorioIndiceParadaAreaResponsavelDTO relatorio : listaDadosRelatorio) {
			Double tempoTotalParada = Double.parseDouble(relatorio.getTempo());
			relatorio.setTempo(DataHoraRN
					.formatSegundosParaHHMMSSmmm(tempoTotalParada));
			double porcentagemParada = (tempoTotalParada.doubleValue() * 100)
					/ totalTempoTodasParadas;
			String indice = String.valueOf(arredondarPorcentagem(
					porcentagemParada, 2)) + "%";
			relatorio.setIndice(indice);
			relatorio.setNumeroLinhaRel(i);
			retorno.getAreaResponsavelDTOs().add(relatorio);
			i++;
		}

		return retorno;
	}

	private double arredondarPorcentagem(double valor, int casas) {
		BigDecimal arredondado = new BigDecimal(valor); 
		arredondado = arredondado.setScale(casas, BigDecimal.ROUND_HALF_UP);

		return arredondado.doubleValue();
	}
}
