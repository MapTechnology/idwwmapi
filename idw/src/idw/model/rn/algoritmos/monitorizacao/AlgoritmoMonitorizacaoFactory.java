package idw.model.rn.algoritmos.monitorizacao;

import java.util.HashMap;
import java.util.Map;

import idw.model.pojos.DwRt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.monitorizacao.MonitorizacaoRN;
import idw.model.rn.monitorizacao.injet.MonitorizacaoInjetRN;
import idw.model.rn.monitorizacao.injet.MonitorizacaoInjetV2RN;
import idw.util.IdwLogger;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.injet.RtFolhaDTO;

public class AlgoritmoMonitorizacaoFactory {
	
	private static AlgoritmoMonitorizacaoFactory instancia;
	@SuppressWarnings("rawtypes")
	private Map<Long, Class> algoritmosDisponiveis = new HashMap<Long, Class>();
	private static final long _ALGORITMO_WHP = 2;
	private static final long _ALGORITMO_INJET = 3;
	private static final long _ALGORITMO_TEMPERATURA = 4;
	
	public AlgoritmoMonitorizacaoFactory(){
		algoritmosDisponiveis.put(_ALGORITMO_WHP, AlgoritmoMonitorizacaoWHP.class);
		algoritmosDisponiveis.put(_ALGORITMO_INJET, AlgoritmoMonitorizacaoInjet.class);
		algoritmosDisponiveis.put(_ALGORITMO_TEMPERATURA, AlgoritmoMonitorizacaoTemperatura.class);
	}
	
	public static AlgoritmoMonitorizacaoFactory getInstancia(){
		if (instancia == null){
			return new AlgoritmoMonitorizacaoFactory();
		}
		
		return instancia;
	}
	
	
	private IAlgoritmo getAlgoritmo(long id){
	  try{
		  return (IAlgoritmo) algoritmosDisponiveis.get(Long.valueOf(id)).newInstance();  
	  }catch(Exception e){
		  e.printStackTrace();
		  throw new RuntimeException("Nao foi possivel Executar o Algoritmo: " + id);
	  }
		
	}
	
	public void executarAlgoritmo(IdwLogger log, long id,ObjRtMonitorizacaoDTO objRtDTOItem, DwConsolidTemplate.TpId tpId, DwRt dwRt, OmCfg omCfg,MonitorizacaoRN rn, boolean isTurnoAtual, Integer filtroOp){
		getAlgoritmo(id).executar(log, objRtDTOItem, tpId, dwRt, omCfg,rn, isTurnoAtual, filtroOp);
	}

	//Marcos Sardinha: VFWEB - Injet
	public void executarAlgoritmo(IdwLogger log, long id,ObjRtMonitorizacaoDTO objRtDTOItem, DwConsolidTemplate.TpId tpId, RtFolhaDTO rtf, OmCfg omCfg,MonitorizacaoInjetRN rn, boolean isTurnoAtual, Integer filtroOp){
		getAlgoritmo(id).executar(log, objRtDTOItem, tpId, rtf, omCfg,rn, isTurnoAtual, filtroOp);
	}	


	//WEB - Injet - V2 (node)
	public void executarAlgoritmo(IdwLogger log, long id,ObjRtMonitorizacaoDTO objRtDTOItem, DwConsolidTemplate.TpId tpId, RtFolhaDTO rtf, OmCfg omCfg,MonitorizacaoInjetV2RN rn, boolean isTurnoAtual, Integer filtroOp){
		getAlgoritmo(id).executar(log, objRtDTOItem, tpId, rtf, omCfg,rn, isTurnoAtual, filtroOp);
	}	
	
}
