package idw.model.rn.algoritmos.monitorizacao;

import idw.model.pojos.DwRt;
import idw.model.pojos.OmCfg;
import idw.model.rn.monitorizacao.MonitorizacaoRN;
import idw.webservices.dto.ObjRtDTO;

public interface IAlgoritmoMonitorizacao {
	void executar(ObjRtDTO objRtDTOItem, DwRt dwRt, OmCfg omCfg, MonitorizacaoRN rn);
}
