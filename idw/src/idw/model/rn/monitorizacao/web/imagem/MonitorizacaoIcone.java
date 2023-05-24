package idw.model.rn.monitorizacao.web.imagem;

import idw.webservices.dto.ObjRtMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.PtIconeDTO;

public interface MonitorizacaoIcone {
	
	public static final String CAMINHO_POSTO_VAZIO = "om/img/monitorizacao/posto_vazio_48x48.gif";
	
	PtIconeDTO getIcone(ObjRtMonitorizacaoDTO obj);

}
