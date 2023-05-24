package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.pojos.DwConsolParam;
import idw.model.pojos.DwConsolParammed;


public abstract class DwConsolParamTemplate extends AbstractTemplate<DwConsolParam> {
	
	public enum TpReferencia{
		tempo_avaliar((byte)0),
		tempo_trabalhado_do_dwconsol((byte)1),
		tempo_total_parada_cp_do_dwconsol((byte)2),
		tempo_total_parada_sp_do_dwconsol((byte)3);

		private final byte value;
		private TpReferencia(byte value){
			this.value = value;
		}
		public byte getValue(){
			return this.value;
		}

	}

	
	@Override
	protected DwConsolParam atribuir(DwConsolParam itemGet, DwConsolParam itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwConsolParam();
		
		itemSet.setIdConsolparam(itemGet.getIdConsolparam());
		itemSet.setQtMedicoes(itemGet.getQtMedicoes());
		itemSet.setTpReferencia(itemGet.getTpReferencia());
		itemSet.setVlMaximo(itemGet.getVlMaximo());
		itemSet.setVlMedio(itemGet.getVlMedio());
		itemSet.setVlMinimo(itemGet.getVlMinimo());
		itemSet.setVlSomado(itemGet.getVlSomado());
		itemSet.setVlMonetario(itemGet.getVlMonetario());
		itemSet.setZona(itemGet.getZona());
		itemSet.setIdValorLido(itemGet.getIdValorLido());
		
		if(isCopiarFK == true){
			itemSet.setDwFtParam(itemGet.getDwFtParam().clone(false));
			itemSet.setDwConsolParammeds(new HashSet<DwConsolParammed>());
			for (DwConsolParammed med : itemGet.getDwConsolParammeds()) {
				itemSet.getDwConsolParammeds().add(med.clone(false));
			}
		}
				
		return itemSet;
	}	
}
