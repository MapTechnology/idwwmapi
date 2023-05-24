package idw.model.pojos.template;

import idw.model.pojos.DwTurno;
import idw.model.pojos.OmAlimrea;
import idw.model.pojos.OmMapapa;


public abstract class OmAlimreaTemplate implements Cloneable{
	
	public enum TpLeitura{
		CONFERENCIA_OU_ALIMENTACAO((byte)1), 
		REALIMENTACAO((byte)2),		
		DESALIMENTACAO((byte)4), 
		TERMINO_CONSUMO((byte)5);

		private final byte id;
		
		private TpLeitura(byte id){
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
		public static TpLeitura get(byte id){
			for(TpLeitura tpLeitura: TpLeitura.values()){
				if(tpLeitura.equals(id)){
					return tpLeitura;
				}
			}
			return null;
		}
		
	}
	
	public enum StLeitura{
		SUCESSO((byte) 1), 
		FALHOU((byte) 2);
		
		private final byte id;
		
		private StLeitura(byte id){
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
		public static StLeitura get(Byte id){
			for(StLeitura stLeitura: StLeitura.values()){
				if(stLeitura.equals(id)){
					return stLeitura;
				}
			}
			return null;
		}
	}
	
	@Override
	public Object clone() {
		OmAlimrea omAlimrea = (OmAlimrea) this;
	    
		OmAlimrea clone = new OmAlimrea();
		clone.setIdAlimrea(omAlimrea.getIdAlimrea());
		clone.setCdLido(omAlimrea.getCdLido());
		clone.setCbRap(omAlimrea.getCbRap());
		clone.setDthrLeitura(omAlimrea.getDthrLeitura());
		clone.setTpLeitura(omAlimrea.getTpLeitura());
		clone.setStLeitura(omAlimrea.getStLeitura());
		clone.setQtAlimentada(omAlimrea.getQtAlimentada());
		
		clone.setQtAtual(omAlimrea.getQtAtual());
		clone.setQtPerdida(omAlimrea.getQtPerdida());
		clone.setQtPorplaca(omAlimrea.getQtPorplaca());
		clone.setQtUsada(omAlimrea.getQtUsada());
		
		clone.setCb(omAlimrea.getCb());
		clone.setLoteFab(omAlimrea.getLoteFab());

		clone.setOmMapapa((OmMapapa) omAlimrea.getOmMapapa().clone());
		if (omAlimrea.getDwTurno() != null) {
			clone.setDwTurno((DwTurno) omAlimrea.getDwTurno().cloneParaAlim());
		}
		if (omAlimrea.getDtReferencia() != null) {
			clone.setDtReferencia(omAlimrea.getDtReferencia());
		}
						
		return clone;

    }
	
	public void copy(OmAlimrea omFrom, boolean copiarFK){
		OmAlimrea omTo = (OmAlimrea) this;
		omTo.setIdAlimrea(omFrom.getIdAlimrea());
		omTo.setCdLido(omFrom.getCdLido());
		omTo.setCbRap(omFrom.getCbRap());
		omTo.setDthrLeitura(omFrom.getDthrLeitura());
		omTo.setTpLeitura(omFrom.getTpLeitura());				
		omTo.setStLeitura(omFrom.getStLeitura().byteValue());

		if (copiarFK){
			omTo.setOmMapapa(omFrom.getOmMapapa());
						
		}

	}
	
	public String toString(OmAlimrea rea) {
		StringBuilder retorno = new StringBuilder();
		retorno.append("idAlimrea=");
		retorno.append(rea.getIdAlimrea());
		retorno.append(" cdLido=");
		retorno.append(rea.getCdLido());
		retorno.append(" cdReel=");
		retorno.append(rea.getCb());
		return retorno.toString();
	}
}
