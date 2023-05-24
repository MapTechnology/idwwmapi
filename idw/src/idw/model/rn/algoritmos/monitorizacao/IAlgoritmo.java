package idw.model.rn.algoritmos.monitorizacao;

import idw.model.pojos.DwRt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.monitorizacao.MonitorizacaoRN;
import idw.model.rn.monitorizacao.injet.MonitorizacaoInjetRN;
import idw.model.rn.monitorizacao.injet.MonitorizacaoInjetV2RN;
import idw.util.IdwLogger;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.injet.RtFolhaDTO;

public interface IAlgoritmo {
	void executar(IdwLogger log, ObjRtMonitorizacaoDTO objRtDTOItem, DwConsolidTemplate.TpId tpId, DwRt dwRt, OmCfg omCfg, MonitorizacaoRN rn, boolean isTurnoAtual, Integer filtroOp);
	
	//Marcos Sardinha: VFWEB - Injet
	void executar(IdwLogger log, ObjRtMonitorizacaoDTO objRtDTOItem, DwConsolidTemplate.TpId tpId, RtFolhaDTO rtf, OmCfg omCfg, MonitorizacaoInjetRN rn, boolean isTurnoAtual, Integer filtroOp);

	//WEB - Injet - V2 (node)
	void executar(IdwLogger log, ObjRtMonitorizacaoDTO objRtDTOItem, DwConsolidTemplate.TpId tpId, RtFolhaDTO rtf, OmCfg omCfg, MonitorizacaoInjetV2RN rn, boolean isTurnoAtual, Integer filtroOp);

}
