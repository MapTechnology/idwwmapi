package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.pojos.OmAlgocor;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmTppt;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;

public class OmAlgocorTemplate extends AbstractTemplate<OmAlgocor> {

	/**
	 * Campos usados no equals: DsAlgocor
	 */
	@Override
	public boolean equals(Object o){
		boolean equals = false;

		if(o != null && this.getClass().isAssignableFrom(o.getClass())){
			final OmAlgocor omAlgocorOther = (OmAlgocor) o;
			final OmAlgocor omAlgocor = (OmAlgocor) this; 
			equals = (new EqualsBuilderIdw())
						.append(omAlgocor.getDsAlgocor(), omAlgocorOther.getDsAlgocor())							
						.isEquals();
		}
		
		return equals;
	}
	
	/**
	 * Campos usados no hashCode: CdTppt, DsTppt, StAtivo
	 */
	@Override
	public int hashCode(){
		
		OmAlgocor omAlgocor = (OmAlgocor) this;
		
		return (new HashCodeBuilderIdw())	
				.append(omAlgocor.getDsAlgocor())
				.toHashCode();
		
	}
	
	@Override
	protected OmAlgocor atribuir(OmAlgocor from, OmAlgocor to,
			boolean isCopiarFK) {
		if(to == null)
			to = new OmAlgocor();
		
		to.setIdAlgocor(from.getIdAlgocor());
		to.setDsAlgocor(from.getDsAlgocor());
		
		if(isCopiarFK){
			if(from.getOmCfgs() != null){
				to.setOmCfgs(new HashSet<OmCfg>());
				for(OmCfg item: from.getOmCfgs()){
					to.getOmCfgs().add(item.clone(false));
				}
			}
			
			if(from.getOmTppts() != null){
				to.setOmTppts(new HashSet<OmTppt>());
				for(OmTppt item: from.getOmTppts()){
					to.getOmTppts().add(item.clone(false));
				}
			}
			
		}
		
		return to;
	}

}
