package idw.model.pojos.template;

import java.util.Date;

import idw.model.pojos.DwProcativ;
import idw.model.pojos.DwProrea;
import idw.model.pojos.DwProreaativ;
import idw.model.pojos.OmUsr;
import idw.util.CloneUtil;

public abstract class DwProreaativTemplate extends AbstractTemplate<DwProreaativ>{
	
	public enum Type {
		
		EXECUTANDO((byte) 0),
		EXECUTADO_COM_SUCESSO((byte) 1),
		EXECUTADO_COM_RESALVA((byte) 2),
		NAO_EXECUTADO((byte) 3);
		
		private final byte id;
		
		private Type(byte id){
			this.id = id;
		}
		
		public byte getId(){
			return this.id;
		}

		public static Type get(byte id) {
			for (Type type : Type.values()){
				if (type.equals(id)){
					return type;
				}
			}
			
			throw new IllegalArgumentException("N�o foi possivel identificar o status da atividade. id=" + id);
		}			
		
		public boolean equals(byte id){
			return this.id == id;
		}
		
		public boolean equals(DwProreaativ dwProreaativ){
			if(dwProreaativ == null){
				return false;
			}
			
			return equals(dwProreaativ.getStProreaativ());
		}
		
	}	
		
	public void set(long idProreaativ,OmUsr omUsr,DwProcativ dwProcativ,
			DwProrea dwProrea,Date dthrInicio,Date dthrFim, Byte stProreaativ) {

		DwProreaativ dwProreaativ = (DwProreaativ) this;
		dwProreaativ.setIdProreaativ(idProreaativ);
		dwProreaativ.setOmUsr(omUsr);
		dwProreaativ.setDwProcativ(dwProcativ);
		dwProreaativ.setDwProrea(dwProrea);
		dwProreaativ.setDthrInicio(dthrInicio);
		dwProreaativ.setDthrFim(dthrFim);
		dwProreaativ.setStProreaativ(stProreaativ);
		
	}
	
	@Override
	protected DwProreaativ atribuir(DwProreaativ itemGet, DwProreaativ itemSet,
			boolean isCopiarFK) {
		if (itemSet == null) {
			itemSet = new DwProreaativ();
		}

		itemSet.set(itemGet.getIdProreaativ(), 
				isCopiarFK ? CloneUtil.clone(itemGet.getOmUsr(),false) : null, 
				isCopiarFK ? CloneUtil.clone(itemGet.getDwProcativ(),false) : null, 
				isCopiarFK ? CloneUtil.clone(itemGet.getDwProrea(),false) : null, itemGet.getDthrInicio(), itemGet.getDthrFim(),itemGet.getStProreaativ());
		if(isCopiarFK){
			/* Alessandre em 16-02-16 removi pois estava indo para cadca atividade 
			DwProcativ dwProcativ = itemGet.getDwProcativ().clone(false);
			dwProcativ.setDwGrpativ(itemGet.getDwProcativ().getDwGrpativ().clone(false));
			itemSet.setDwProcativ(dwProcativ);
			*/
		}
		return itemSet;
		
	}
}
