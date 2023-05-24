package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwRtcic;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroRelDivergenciaDTO;
import idw.webservices.dto.RelatorioAnaliseCicloDTO;

public class RelatorioAnaliseCicloRN extends AbstractRN<DAOGenerico> {

	public RelatorioAnaliseCicloRN() {
		this(null);
	}

	public RelatorioAnaliseCicloRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	public RelatorioAnaliseCicloDTO getRelatorioAnaliseCiclo(FiltroRelDivergenciaDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioAnaliseCicloRN.getRelatorioAnaliseCiclo");
		log.info( idLog , 0, "RelatorioAnaliseCicloRN.getRelatorioAnaliseCiclo filtro usado:" + filtro.toString());
		
		List<DwConsolid> listaConsolid = getConsulta(filtro);
		
		RelatorioAnaliseCicloDTO retorno = new RelatorioAnaliseCicloDTO();
		retorno.setItens(new ArrayList<RelatorioAnaliseCicloDTO>());
		
		for(DwConsolid consolid : listaConsolid) {
			
			String cdProduto = "";
			
			for(DwFolhaiac folhaiac : consolid.getDwFolha().getDwFolhaiacs()) {
				cdProduto = folhaiac.getOmProduto().getCdProduto();
			}
			for(DwFolharap folharap : consolid.getDwFolha().getDwFolharaps()) {
				for(DwFolharapcom folharapcom : folharap.getDwFolharapcoms()) {
					if (cdProduto.equals("") == false)
						cdProduto += ", ";
					cdProduto += folharapcom.getOmProduto().getCdProduto();
				}
			}

			for(DwRtcic rtcic : consolid.getDwRt().getDwRtcics()) {
				BigDecimal duracao = DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodo(rtcic.getDthrIciclo(), rtcic.getDthrFciclo()).setScale(3);
				RelatorioAnaliseCicloDTO item = new RelatorioAnaliseCicloDTO();
				item.setProduto(cdProduto);
				item.setFolha(consolid.getDwFolha().getCdFolha());
				item.setMaquina(consolid.getOmPt().getCdPt());
				item.setInicioCic(DataHoraRN.dateToStringDDMMYYYYHHMMSSms(rtcic.getDthrIciclo()));
				item.setFimCic(DataHoraRN.dateToStringDDMMYYYYHHMMSSms(rtcic.getDthrFciclo()));
				item.setDuracao(String.valueOf(duracao)+"s");
				retorno.getItens().add(item);
			}
		}
		
		Collections.sort(retorno.getItens(), new Comparator<RelatorioAnaliseCicloDTO>() {
			@Override
			public int compare(RelatorioAnaliseCicloDTO o1, RelatorioAnaliseCicloDTO o2) {
				String s1 = o1.getProduto() + " " + o1.getFolha() + " " + o1.getMaquina() + " " + o1.getInicioCic();  
				String s2 = o2.getProduto() + " " + o2.getFolha() + " " + o2.getMaquina() + " " + o2.getInicioCic();  
				return s1.compareTo(s2);
			}
		});
		
		log.mostrarAvaliacaoCompleta();
		
		return retorno;

	}
	
	private List<DwConsolid> getConsulta(FiltroRelDivergenciaDTO filtro) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwTurno turno");
		q.append("JOIN consolid.omPt pt");
		q.append("JOIN consolid.dwFolha folha");
		q.append("LEFT JOIN pt.omObjs obj");
		q.append("LEFT JOIN obj.omGtByIdGt gt");
		q.append("LEFT JOIN folha.dwFolhaiacs folhaiac"); 
		q.append("LEFT JOIN folha.dwFolharaps folharap");
		q.append("LEFT JOIN folharap.dwFolharapcoms folharapcom");
		q.append("LEFT JOIN folharap.dwRap rap");
		q.append("LEFT JOIN rap.dwRapGrupos rapgrupo");
		q.append("LEFT JOIN rapgrupo.dwGrupoFerramenta gpferramenta");
		q.append("JOIN consolid.dwRt rt");
		q.append("JOIN rt.dwRtcics rtcic");
		q.append("left join folhaiac.omProduto a");
		q.append("left join folharapcom.omProduto b");
		q.append("WHERE consolid.tpId = :tpId");
		q.append("AND consolid.dtReferencia BETWEEN :dtIncial AND :dtFinal");
		if(filtro.getTurno() != null) {
			q.append("AND turno.idTurno = :idTurno");
		}else{
			q.append("AND consolid.dwTurno.idTurno != 1");
		}
		if(filtro.getPt() != null) {
			q.append("AND pt.idPt = :idPt");
		}
		if(filtro.getGt() != null) {
			q.append("AND gt.idGt = :idgt");
		}
		if(filtro.getRap() != null) { 
			q.append("AND rap.cdRap = :cdRap");
		}
		if(filtro.getGrupoFerramenta() != null) {
			q.append("AND gpferramenta.cdGrupoFerramenta = :cdGpFerramenta");
		}
		if(filtro.getProduto() != null) {
			q.append("AND (a.cdProduto = :cdProduto OR b.cdProduto = :cdProduto)");
		}
		
		q.defineParametro("tpId", (byte)1);
		q.defineParametroData("dtIncial", filtro.getDataInicio());
		q.defineParametroData("dtFinal", DataHoraRN.getDataHora235959(filtro.getDataFim()));
		
		if(filtro.getTurno() != null) {
			q.defineParametro("idTurno", filtro.getTurno().getIdTurno());
		}
		if(filtro.getPt() != null) {
			q.defineParametro("idPt", filtro.getPt().getIdPt());
		}
		if(filtro.getGt() != null) {
			q.defineParametro("idgt", filtro.getGt().getIdGt());
		}
		if(filtro.getRap() != null) { 
			q.defineParametro("cdRap", filtro.getRap().getCdRap());
		}
		if(filtro.getGrupoFerramenta() != null) {
			q.defineParametro("cdGpFerramenta", filtro.getGrupoFerramenta().getCdGrupoFerramenta());
		}
		if(filtro.getProduto() != null) {
			q.defineParametro("cdProduto", filtro.getProduto().getCdProduto());
		}
		List<DwConsolid> retorno = q.list();
		
		return retorno;
	}
	
}