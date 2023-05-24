package idw.model.pojos.template;

import java.util.HashSet;
import java.util.Set;

import idw.model.pojos.DwFtSub;
import idw.model.pojos.DwTestesub;
import idw.model.pojos.DwTestesubetapa;


public abstract class DwTestesubTemplate implements Cloneable{
	
	@Override
	public Object clone() {
		DwTestesub itemGet = (DwTestesub) this;
		
		DwTestesub itemSet = new DwTestesub();
		itemSet.setIdTestesub(itemGet.getIdTestesub());
		itemSet.setIsSalvar(itemGet.getIsSalvar());
		itemSet.setMsCapMedPosFalha(itemGet.getMsCapMedPosFalha());
		itemSet.setOrdem(itemGet.getOrdem());
		itemSet.setOrdemEtapa(itemGet.getOrdemEtapa());
		itemSet.setAcenderLampada(itemGet.getAcenderLampada());
		itemSet.setQtMedSeg(itemGet.getQtMedSeg());
		itemSet.setQtMedSegPosFalha(itemGet.getQtMedSegPosFalha());
		
		if (itemGet.getDwFtSub() != null)
			itemSet.setDwFtSub((DwFtSub)itemGet.getDwFtSub().clone());
		
		if (itemGet.getDwTestesubetapas() != null){
			Set<DwTestesubetapa> ld = new HashSet<DwTestesubetapa>();
			for (DwTestesubetapa d : itemGet.getDwTestesubetapas()){
				ld.add((DwTestesubetapa) d.clone());
			}
			itemSet.setDwTestesubetapas(ld);
		}

		return itemSet;

	  }
	
	public void copy(DwTestesub itemGet,boolean copiarFK){
		DwTestesub itemSet = (DwTestesub) this;
		itemSet.setIdTestesub(itemGet.getIdTestesub());
		itemSet.setIsSalvar(itemGet.getIsSalvar());
		itemSet.setMsCapMedPosFalha(itemGet.getMsCapMedPosFalha());
		itemSet.setOrdem(itemGet.getOrdem());
		itemSet.setOrdemEtapa(itemGet.getOrdemEtapa());
		itemSet.setAcenderLampada(itemGet.getAcenderLampada());
		itemSet.setQtMedSeg(itemGet.getQtMedSeg());
		itemSet.setQtMedSegPosFalha(itemGet.getQtMedSegPosFalha());
		
		if (copiarFK){
			itemSet.setDwFtSub(itemGet.getDwFtSub());
		}
		
	}
}
