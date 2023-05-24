package idw.model.pojos.template;

import idw.model.pojos.OmMapapa;
import idw.model.pojos.OmPapro;
import idw.util.CloneUtil;

public abstract class OmPaproTemplate extends AbstractTemplate<OmPapro>{
	@Override
	protected OmPapro atribuir(OmPapro from, OmPapro to, boolean isCopiarFK) {
		if(to == null){
			to = new OmPapro();
		}
		
		to.setIdPapro(from.getIdPapro());
		to.setQtAtual(from.getQtAtual());
		
		if(isCopiarFK){
			
			if(from.getOmMapapa() != null){
				to.setOmMapapa( (OmMapapa) from.getOmMapapa().clone());				
			}
			
			to.setOmPa(CloneUtil.clone(from.getOmPa(), false));			
			to.setOmProduto(CloneUtil.clone(from.getOmProduto(),false));
			to.setOmPt(CloneUtil.clone(from.getOmPt(),false));
			
		}
		
		return to;
		
    }
	
	public String toString(OmPapro pro) {
		StringBuilder retorno = new StringBuilder();
		retorno.append("id=");
		retorno.append(pro.getIdPapro());
		retorno.append(" qtde=");
		retorno.append(pro.getQtAtual());
		return retorno.toString();
	}

}
