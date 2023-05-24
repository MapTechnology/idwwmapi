package idw.model.pojos.template;

import idw.model.pojos.DwCalavu;
import idw.model.pojos.DwTurno;


public abstract class DwCalavuTemplate implements Cloneable{
	
	@Override
	public Object clone() {
		DwCalavu itemGet = (DwCalavu) this;
		
		DwCalavu itemSet = new DwCalavu();
		itemSet.setIdCalavu(itemGet.getIdCalavu());
		itemSet.setHrFinal(itemGet.getHrFinal());
		itemSet.setHrFinalGui(itemGet.getHrFinalGui());
		itemSet.setHrinicial(itemGet.getHrinicial());		
		itemSet.setHrInicialGui(itemGet.getHrInicialGui());		
		itemSet.setIsFimturno(itemGet.getIsFimturno());
		itemSet.setIsInicioturno(itemGet.getIsInicioturno());
		itemSet.setSegTempocalendario(itemGet.getSegTempocalendario());
		itemSet.setSegTempocalsempeso(itemGet.getSegTempocalsempeso());
		itemSet.setSegToleranciapos(itemGet.getSegToleranciapos());
		itemSet.setSegToleranciapre(itemGet.getSegToleranciapre());
		itemSet.setTpDtreferencia(itemGet.getTpDtreferencia());		
		itemSet.setDtAvulso(itemGet.getDtAvulso());
		itemSet.setIsCalsemdesativado(itemGet.getIsCalsemdesativado());
		itemSet.setTpCalavu(itemGet.getTpCalavu());		
		itemSet.setDwTurno((DwTurno)itemGet.getDwTurno().clone());
		if (itemGet.getDwCalsem() != null)
			itemSet.setDwCalsem(itemGet.getDwCalsem().clone());
		
		return itemSet;

	  }
	
	public void copy(DwCalavu itemGet,boolean copiarFK){
		DwCalavu itemSet = (DwCalavu) this;
		itemSet.setIdCalavu(itemGet.getIdCalavu());
		itemSet.setHrFinal(itemGet.getHrFinal());
		itemSet.setHrFinalGui(itemGet.getHrFinalGui());
		itemSet.setHrinicial(itemGet.getHrinicial());		
		itemSet.setHrInicialGui(itemGet.getHrInicialGui());		
		itemSet.setIsFimturno(itemGet.getIsFimturno());
		itemSet.setIsInicioturno(itemGet.getIsInicioturno());
		itemSet.setSegTempocalendario(itemGet.getSegTempocalendario());
		itemSet.setSegTempocalsempeso(itemGet.getSegTempocalsempeso());
		itemSet.setSegToleranciapos(itemGet.getSegToleranciapos());
		itemSet.setSegToleranciapre(itemGet.getSegToleranciapre());
		itemSet.setTpDtreferencia(itemGet.getTpDtreferencia());		
		itemSet.setDtAvulso(itemGet.getDtAvulso());
		itemSet.setIsCalsemdesativado(itemGet.getIsCalsemdesativado());
		itemSet.setTpCalavu(itemGet.getTpCalavu());		
		
		if (copiarFK){
			itemSet.setDwTurno(itemGet.getDwTurno());		
			
		}
		
	}
}
