package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import idw.model.AbstractPojoMs;
import idw.model.pojos.MsInd;
import idw.model.pojos.MsTrigger;

public class MsIndTemplate extends AbstractPojoMs<MsInd>{
	
	
	@Override
	protected MsInd atribuir(MsInd from, MsInd to,
			boolean isCopiarFK) {
		
		if (to == null)
			to = new MsInd();
		
		to.setDsCalculo(from.getDsCalculo());
		
		to.setDsInd(from.getDsInd());
		
		to.setDsUnidade(from.getDsUnidade());
		
		
		
		if(from.getIdInd() != null){
			to.setIdInd(new BigDecimal(from.getIdInd().longValue()));
		}
		
		if(isCopiarFK){
			if(from.getMsTriggers() != null){
				Set<MsTrigger> listaMsTriggers = new HashSet<MsTrigger>();
				for(MsTrigger msTrigger: from.getMsTriggers()){
					listaMsTriggers.add(msTrigger.clone(false));
				}			
				to.setMsTriggers(listaMsTriggers);
			}
		}
		
		return to;
	}

}
