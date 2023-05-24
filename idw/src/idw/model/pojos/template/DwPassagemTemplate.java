package idw.model.pojos.template;

import idw.model.pojos.DwEst;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwTArea;


public abstract class DwPassagemTemplate extends AbstractTemplate<DwPassagem> {
	
	public enum StNserie{
		NAO_CONFORME((byte)0),
		CONFORME((byte)1);

		private final byte value;
		private StNserie(byte value){
			this.value = value;
		}
		public byte getValue(){
			return this.value;
		}
		
		public boolean equals(Byte value) {
			if (value != null) {
				return value.equals(this.value);
			}
			return false;
		}
		
		public static StNserie get(Byte value) {
			if (value != null) {
				for(StNserie item: StNserie.values()) {
					if (value.equals(item.value)) {
						return item;
					}
				}
			}
			return null;
		}

	}

	@Override
	protected DwPassagem atribuir(DwPassagem itemGet, DwPassagem itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwPassagem();
		
		itemSet.setIdPassagem(itemGet.getIdPassagem());
		itemSet.setDthr(itemGet.getDthr());
		itemSet.setDthrInicio(itemGet.getDthrInicio());
		itemSet.setIsTfFinalizado(itemGet.getIsTfFinalizado());
		itemSet.setIsMontagemfechadaantecipadamente(itemGet.getIsMontagemfechadaantecipadamente());
		itemSet.setDsDiariobordo(itemGet.getDsDiariobordo());
		itemSet.setMsDthr(itemGet.getMsDthr());		
		itemSet.setMsDthrinicio(itemGet.getMsDthrinicio());
		itemSet.setSegCiclo(itemGet.getSegCiclo());
		itemSet.setStNserie(itemGet.getStNserie());
		itemSet.setStAtivo(itemGet.getStAtivo());
		itemSet.setSequencial(itemGet.getSequencial() );
		
		if (isCopiarFK){								
			try {
				itemSet.setOmUsrByIdUsroperador(itemGet.getOmUsrByIdUsroperador().clone(false));
			} catch (Exception e) {				
			}
			try {
				itemSet.setOmUsrByIdUsrsupervisor(itemGet.getOmUsrByIdUsrsupervisor().clone(false));
			} catch (Exception e) {				
			}
			try {
				itemSet.setDwConsolid(itemGet.getDwConsolid().clone(false));
			} catch (Exception e) {				
			}
			try {
				itemSet.setOmPt(itemGet.getOmPt().clone(false));
			} catch (Exception e) {				
			}
			try {
				itemSet.setDwEst((DwEst)itemGet.getDwEst().clone(false));
			} catch (Exception e) {				
			}	
			try {
				itemSet.setDwNserie((DwNserie)itemGet.getDwNserie().clone(false));
			} catch (Exception e) {				
			}
			try {
				itemSet.setDwTArea((DwTArea) itemGet.getDwTArea().clone(false));
			} catch (Exception e) {
				
			}
		}
		
		return itemSet;
	}	
}
