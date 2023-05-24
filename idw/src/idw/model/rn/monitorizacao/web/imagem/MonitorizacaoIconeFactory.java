package idw.model.rn.monitorizacao.web.imagem;

import idw.model.pojos.template.OmTpptTemplate;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;

public class MonitorizacaoIconeFactory {

	// Fonte Netbeans: PImagePTAbstract.getInstance()
	public MonitorizacaoIcone getMonitorizacaoIcone(ObjRtMonitorizacaoDTO obj) {
		if(obj.getTipoPT() == OmTpptTemplate.Type.CEP.getId()) {
			return new MonitorizacaoIconeForno();
		}
		
		return new MonitorizacaoIconeDefault();
	}
}
