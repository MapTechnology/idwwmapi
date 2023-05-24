package idw.model.pojos.template;

import java.util.HashSet;

import org.hibernate.SessionException;

import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwProcedimento;
import idw.model.pojos.DwProrea;
import idw.model.pojos.DwProreaativ;
import idw.util.CloneUtil;

public abstract class DwProreaTemplate extends AbstractTemplate<DwProrea>{
	
	public enum StProrea{
		STATUS_ABERTO((byte)0),
		STATUS_FECHADO((byte)1);

		private final byte value;
		private StProrea(byte value){
			this.value = value;
		}
		public byte getValue(){
			return this.value;
		}

	}

	public void set(long idProrea,
			DwConsolid dwConsolid,DwProcedimento dwProcedimento,Byte stProrea) {

		DwProrea dwProrea = (DwProrea) this;
		dwProrea.setIdProrea(idProrea);
		dwProrea.setDwProcedimento(dwProcedimento);
		dwProrea.setDwConsolid(dwConsolid);
		dwProrea.setStProrea(stProrea);
		
	}
	@Override
	protected DwProrea atribuir(DwProrea itemGet, DwProrea itemSet,
			boolean isCopiarFK) {
		if (itemSet == null) {
			itemSet = new DwProrea();
		}

		itemSet.set(
				itemGet.getIdProrea(),
				(isCopiarFK ? CloneUtil.clone(itemGet.getDwConsolid(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getDwProcedimento(),false) : null),
				itemGet.getStProrea()
				);
		if(isCopiarFK){
			if (itemGet.getDwProreaativs()!= null && itemGet.getDwProreaativs().isEmpty() == false){
				try {
					itemSet.setDwProreaativs(new HashSet<DwProreaativ>());
					for (DwProreaativ dwProreaativ : itemGet.getDwProreaativs()) {
						DwProreaativ item= new DwProreaativ();
						item = dwProreaativ.clone(false);
						item.setOmUsr(dwProreaativ.getOmUsr().clone(false));
						/* Alessandre: em 16-02-16 removi o clone abaixo para analise de estouro de memoria
						 * item.setDwProrea(dwProreaativ.getDwProrea().clone(false));
						DwProcativ dwProcativRet = dwProreaativ.getDwProcativ().clone(false);
						dwProcativRet.setDwGrpativ(dwProreaativ.getDwProcativ().getDwGrpativ().clone(false));
						dwProcativRet.setDwProcedimento(dwProreaativ.getDwProcativ().getDwProcedimento().clone(false));
						item.setDwProcativ(dwProcativRet);
						 */
						
						itemSet.getDwProreaativs().add(item);
					}
				} catch (SessionException e) {
					itemSet.setDwProreaativs(null);
				}
			}
		}
		return itemSet;
		
	}
}