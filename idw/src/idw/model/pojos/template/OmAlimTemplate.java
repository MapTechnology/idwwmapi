package idw.model.pojos.template;

import idw.model.pojos.OmAlim;
import idw.model.pojos.OmMapa;
import idw.model.pojos.OmUsr;


public abstract class OmAlimTemplate implements Cloneable{
	
	public enum TpAlim{
		@Deprecated
		PRE_CONFERENCIA((byte)1), 
		CONFERENCIA((byte)2), 
		ALIMENTACAO((byte)3);

		private final byte id;
		
		private TpAlim(Byte id){
			this.id = id;
		}
		
		public byte getId(){
			return this.id;
		}
		
		public boolean equals(Byte id){
			if (id != null) {
				return id.byteValue() == this.id;
			}
			return false;			
		}
		
		public static TpAlim get(Byte id){
			for(TpAlim tpAlim: TpAlim.values()){
				if(tpAlim.equals(id)){
					return tpAlim;
				}
			}
			return null;
		}
		
	}
	
	public enum StAlim{
		SUCESSO((byte) 1), 
		ABORTADA((byte) 2);
		
		private final byte id;
		
		private StAlim(byte id){
			this.id = id;
		}
		
		public byte getId(){
			return this.id;
		}
		
		public boolean equals(Byte id){
			if (id != null) {
				return id.byteValue() == this.id;
			}
			return false;			
		}
		public static StAlim get(Byte id){
			for(StAlim stAlim: StAlim.values()){
				if(stAlim.equals(id)){
					return stAlim;
				}
			}
			return null;
		}
	}
	
	@Override
	public Object clone() {
		OmAlim omAlim = (OmAlim) this;
	    
	    OmAlim clone = new OmAlim();
		clone.setIdAlim(omAlim.getIdAlim());
		clone.setCdAlim(omAlim.getCdAlim());
		clone.setDsAlim(omAlim.getDsAlim());
		clone.setDtStativo(omAlim.getDtStativo());
		clone.setTpAlim(omAlim.getTpAlim());
		clone.setStAlim(omAlim.getStAlim());
		
		OmMapa omMapa = new OmMapa();
		try {
			omMapa.setCdMapa(omAlim.getOmMapa().getCdMapa());
			omMapa.setDsMapa(omAlim.getOmMapa().getDsMapa());
			omMapa.setOmPt(omAlim.getOmMapa().getOmPt().clone());
		} catch (Exception e) {
			
		}				
		clone.setOmMapa(omMapa);

		OmUsr omUsr = new OmUsr();
		try {
			omUsr.setCdUsr(omAlim.getOmUsr().getCdUsr());
			omUsr.setDsNome(omAlim.getOmUsr().getDsNome());
		} catch (Exception e) {
			
		}		
		clone.setOmUsr(omUsr);		
				
		return clone;

    }
	
	public void copy(OmAlim omFrom, boolean copiarFK){
		OmAlim omTo = (OmAlim) this;
		omTo.setIdAlim(omFrom.getIdAlim());
		omTo.setCdAlim(omFrom.getCdAlim());
		omTo.setDsAlim(omFrom.getDsAlim());
		omTo.setDtStativo(omFrom.getDtStativo());
		omTo.setTpAlim(omFrom.getTpAlim());				
		omTo.setStAlim(omFrom.getStAlim().byteValue());

		if (copiarFK){
			omTo.setOmMapa(omFrom.getOmMapa());
			omTo.setOmUsr(omFrom.getOmUsr());			
		}

	}
}
