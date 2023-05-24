package idw.model.rn;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.util.AritmeticaUtil;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroRelCavInativaDTO;
import idw.webservices.dto.RelatorioCavInativasDTO;

public class RelatorioCavInativasRN extends AbstractRN<DAOGenerico> {

	public RelatorioCavInativasRN() {
		this(null);
	}

	public RelatorioCavInativasRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public RelatorioCavInativasDTO getRelatorioCavidadeInativas(FiltroRelCavInativaDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioCavInativasRN.getRelatorioCavidadeInativas");
		log.info( idLog , 0, "RelatorioCavInativasRN.getRelatorioCavidadeInativas filtro usado:" + filtro.toString());

		RelatorioCavInativasDTO retorno = montarRelatorio(consulta(filtro));
		
		log.mostrarAvaliacaoCompleta();
		
		return retorno;//montarRelatorio(consulta(filtro));
		
	}
	
	private List<Object> consulta(FiltroRelCavInativaDTO filtro) {
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT ");
		q.append("pt.cdPt,");
		q.append("rap.cdRap,");
		q.append("MAX (folharap.idFolharap)");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwTurno turno");
		q.append("JOIN consolid.omPt pt");
		q.append("LEFT JOIN pt.omObjs omobj");
		q.append("JOIN consolid.dwFolha folha");
		q.append("JOIN folha.dwFolharaps folharap");
		q.append("JOIN folharap.dwFolharapcoms folharapcom");
		q.append("LEFT JOIN folharap.dwRap rap");
		q.append("LEFT JOIN rap.dwRapGrupos rapgp");
		q.append("LEFT JOIN rapgp.dwGrupoFerramenta gpferramenta");
		q.append("WHERE consolid.tpId = :tpId");
		q.append("AND consolid.dtReferencia BETWEEN :dtInicio AND :dtFim");
		if(filtro.getDwTurno() != null) {
			q.append("AND turno.idTurno = :idTurno");
		}
		if(filtro.getOmPt() != null) {
			q.append("AND pt.idPt = :idPt");
		}
		if(filtro.getOmGt() != null) {
			q.append("AND omobj.omGtByIdGt.idGt = :idGt");
		}
		if(filtro.getDwRap() != null) {
			q.append("AND rap.idRap = :idRap");
		}
		if(filtro.getDwGrupoFerramenta() != null) {
			q.append("AND gpferramenta.idGrupoFerramenta = :idGpFerramenta");
		}
		if(filtro.isCavInativas()) {
			q.append("AND folharapcom.qtAtiva <> folharapcom.qtTotal");
		}
		
		q.append("GROUP BY pt.cdPt, rap.cdRap");
		q.append("ORDER BY pt.cdPt");
		
		q.defineParametro("tpId", (byte) 1);
		q.defineParametroData("dtInicio", filtro.getDataInicial());
		q.defineParametroData("dtFim", DataHoraRN.getDataHora235959(filtro.getDataFinal()));
		if(filtro.getDwTurno() != null) {
			q.defineParametro("idTurno", filtro.getDwTurno().getIdTurno());
		}
		if(filtro.getOmPt() != null) {
			q.defineParametro("idPt", filtro.getOmPt().getIdPt());
		}
		if(filtro.getOmGt() != null) {
			q.defineParametro("idGt", filtro.getOmGt().getIdGt());
		}
		if(filtro.getDwRap() != null) {
			q.defineParametro("idRap", filtro.getDwRap().getIdRap());
		}
		if(filtro.getDwGrupoFerramenta() != null) {
			q.defineParametro("idGpFerramenta", filtro.getDwGrupoFerramenta().getIdGrupoFerramenta());
		}
		return q.list();
	}

	
	
	private List<Object> consultaValores(Long id){
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT ");
		q.append("sum(folharapcom.qtAtiva),");
		q.append("sum(folharapcom.qtTotal)");
		q.append("FROM DwFolharapcom folharapcom");
		q.append("WHERE folharapcom.dwFolharap.idFolharap = :id");
	
		q.defineParametro("id", id);
		
		
		return  q.list();
	}
	
	
	
	private RelatorioCavInativasDTO montarRelatorio(List<Object> listaConsolid) {
		RelatorioCavInativasDTO retorno = new RelatorioCavInativasDTO();
		retorno.setItens(new ArrayList<RelatorioCavInativasDTO>());
		
		int MAQUINA = 0;
		int MOLDE = 1;
		int ID = 2;
		
		for(Object obj : listaConsolid) {
			Object[] reg = (Object[]) obj;
			String maquina = (String) reg[MAQUINA];
			String molde = (String) reg[MOLDE];
			Long id  = (Long) reg[ID];
			
			BigDecimal qtdTotal = BigDecimal.ZERO;
			BigDecimal qtdAtiva = BigDecimal.ZERO;
			
			if (id!=null){
				Object[] reg2 = (Object[]) consultaValores(id).get(0);
				
				qtdAtiva = ((BigDecimal) (reg2[0])).setScale(2) ;
				qtdTotal = ((BigDecimal) (reg2[1])).setScale(2);				
			}
			
			
			RelatorioCavInativasDTO item = new RelatorioCavInativasDTO();
			item.setMaquina(maquina);
			item.setMolde(molde);
			item.setQtdCavs(String.valueOf(qtdTotal.setScale(3)));
			item.setQtdCavsAtivas(String.valueOf(qtdAtiva.setScale(3)));
			if(qtdAtiva != qtdTotal) {
				item.setIndicePerdas(calcularIndice(qtdTotal, qtdAtiva));
			} else {
				item.setIndicePerdas(String.valueOf(BigDecimal.ZERO.setScale(2)));
			}
			retorno.getItens().add(item);
		}
		return retorno;
	}
	
	private String calcularIndice(BigDecimal qtdTotal, BigDecimal qtdAtiva) {
		double porcentagem = (100 - (AritmeticaUtil.dividir(qtdAtiva, qtdTotal).doubleValue() * 100));		
		BigDecimal por = new BigDecimal(porcentagem);  
		return por.setScale(2,BigDecimal.ROUND_HALF_UP).toString();  
	}
	
}