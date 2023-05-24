package idw.model.rn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroRelDivergenciaDTO;
import idw.webservices.dto.RelatorioDivergenciaDTO;

public class RelatorioDivergenciaRN extends AbstractRN<DAOGenerico> {

	public RelatorioDivergenciaRN() {
		this(null);
	}

	public RelatorioDivergenciaRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public RelatorioDivergenciaDTO getRelatorioDivergencia(FiltroRelDivergenciaDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioDivergenciaRN.getRelatorioDivergencia");
		log.info( idLog , 0, "RelatorioDivergenciaRN.getRelatorioDivergencia filtro usado:" + filtro.toString());
		
		List<DwConsolid> lista = consulta(filtro);
		RelatorioDivergenciaDTO retorno = montarEstruturaRelatorio(lista, filtro.isOrdQtdProduzida(), filtro);
		
		log.mostrarAvaliacaoCompleta();
		
		return retorno;
	
	}

	private List<DwConsolid> consulta(FiltroRelDivergenciaDTO filtro) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT distinct consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwTurno turno");
		q.append("JOIN consolid.dwConsols consol");
		q.append("LEFT JOIN consol.dwConsolmos consolmo");
		q.append("LEFT JOIN consolmo.omUsr operador");
		q.append("LEFT JOIN consolid.dwFolha folha");
		q.append("LEFT JOIN folha.dwFolharaps folharap");		
		q.append("LEFT JOIN folharap.dwRap rap");
		q.append("LEFT JOIN rap.dwRapGrupos rapgrupo");
		q.append("LEFT JOIN rapgrupo.dwGrupoFerramenta grupoferramenta");
		q.append("LEFT JOIN consolid.omPt pt");

		q.append("LEFT JOIN pt.omObjs obj");
		q.append("LEFT JOIN obj.omGtByIdGt gt");

		
		q.append("LEFT JOIN consol.dwConsolprs consolpr");
		q.append("LEFT JOIN consolpr.omProduto produto");		
		q.append("WHERE consolid.tpId = :tpId");
		q.append("AND consolid.dtReferencia BETWEEN :dtInicio AND :dtFim");
		
		if(filtro.getTurno() != null) {
			q.append("AND turno.idTurno = :idTurno");
		}else{
			q.append("AND consolid.dwTurno.idTurno != 1");
		}
		if(filtro.getUsuario() != null) {
			q.append("AND operador.idUsr = :idUsr");
		}
		if(filtro.getRap() != null) {
			q.append("AND rap.idRap = :idRap");
		}
		if (filtro.getGrupoFerramenta() != null){
			q.append("AND grupoferramenta.cdGrupoFerramenta = :cdgrupoferramenta");
		}
		if(filtro.getPt() != null) {
			q.append("AND pt.idPt = :idPt");
		}
		if(filtro.getGt() != null) {
			q.append("AND gt.idGt = :idGt");
		}
		if(filtro.getProduto() != null) {
			q.append("AND produto.cdProduto = :cdProduto");
		}
		
		q.defineParametro("tpId", (byte) 1);
		q.defineParametroData("dtInicio", filtro.getDataInicio());
		q.defineParametroData("dtFim", filtro.getDataFim());
		
		if(filtro.getTurno() != null) {
			q.defineParametro("idTurno", filtro.getTurno().getIdTurno());
		}
		if(filtro.getUsuario() != null) {
			q.defineParametro("idUsr", filtro.getUsuario().getIdUsr());
		}
		if(filtro.getRap() != null) {
			q.defineParametro("idRap", filtro.getRap().getIdRap());
		}
		if (filtro.getGrupoFerramenta() != null) {
			q.defineParametro("cdgrupoferramenta", filtro.getGrupoFerramenta().getCdGrupoFerramenta());
		}
		if(filtro.getPt() != null) {
			q.defineParametro("idPt", filtro.getPt().getIdPt());
		}
		if(filtro.getGt() != null) {
			q.defineParametro("idGt", filtro.getGt().getIdGt());
		}
		if(filtro.getProduto() != null) {
			q.defineParametro("cdProduto", filtro.getProduto().getCdProduto());
		}
		return q.list();
	}
	
	private RelatorioDivergenciaDTO montarEstruturaRelatorio(List<DwConsolid> lista, boolean isOrdQtdProduzida, FiltroRelDivergenciaDTO filtro) {
		RelatorioDivergenciaDTO retorno = new RelatorioDivergenciaDTO();
		retorno.setItens(new ArrayList<RelatorioDivergenciaDTO>());
		for(DwConsolid consolid : lista) {
			for(DwConsol consol : consolid.getDwConsols()) {
				for(DwConsolpr consolpr : consol.getDwConsolprs()) {
					String produto = consolpr.getOmProduto().getCdProduto() + " - " + consolpr.getOmProduto().getDsProduto();	
					
					// Verifica se o filtro de produto foi definido. Se sim e o produto avaliar for diferente do filtro ignorar
					// Apensar do WHERER filtrar por produto, se a ferramenta tiver 2 produtos os 2 virão na consulta
					if (filtro.getProduto() != null && filtro.getProduto().getCdProduto().equals(consolpr.getOmProduto().getCdProduto()) == false)
						continue;
					Double pesoTeorico = consolpr.getGAutoPesoBruto() != null ? consolpr.getGAutoPesoBruto().doubleValue() : 0d;
					Double pesoMedioLido = consolpr.getGAutoPesoLiquido() != null ? consolpr.getGAutoPesoLiquido().doubleValue() : 0d;
					Integer qtdProduzida = consolpr.getPcsProducaoBruta() != null ? consolpr.getPcsProducaoBruta().intValue() : 0;
					Double qtdDivergencia = consolpr.getGAutoPesoLiquido() != null ? consolpr.getGAutoPesoLiquido().doubleValue() : 0d;
					
					RelatorioDivergenciaDTO item = new RelatorioDivergenciaDTO();
					item.setProduto(produto);
					item.setPesoTeorico(pesoTeorico);
					item.setPesoMedioLido(pesoMedioLido);
					item.setQtdProduzida(qtdProduzida);
					item.setQtdDivergencia(qtdDivergencia);
					retorno.getItens().add(item);
				}
			}
		}
		
		Comparator<RelatorioDivergenciaDTO> comparator;
		
		if(isOrdQtdProduzida){
			comparator = new Comparator<RelatorioDivergenciaDTO>() {			
				@Override
				public int compare(RelatorioDivergenciaDTO o1, RelatorioDivergenciaDTO o2) {
					int valor = o1.getProduto().compareTo(o2.getProduto());
					if (valor == 0)
						valor = o1.getQtdProduzida().compareTo(o2.getQtdProduzida());
					return valor;
				}
			};
		} else {
			comparator = new Comparator<RelatorioDivergenciaDTO>() {			
				@Override
				public int compare(RelatorioDivergenciaDTO o1, RelatorioDivergenciaDTO o2) {					
					int valor = o1.getProduto().compareTo(o2.getProduto());
					if (valor == 0)
						valor = o1.getQtdDivergencia().compareTo(o2.getQtdDivergencia());
					return valor;
				}
			};
		}
		Collections.sort(retorno.getItens(), comparator);
		
		return retorno;
	}
	
}