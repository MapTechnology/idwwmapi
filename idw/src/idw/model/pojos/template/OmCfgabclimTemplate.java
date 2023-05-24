package idw.model.pojos.template;

import java.math.BigDecimal;

import idw.model.pojos.OmCfgabclim;

public abstract class OmCfgabclimTemplate extends AbstractTemplate<OmCfgabclim>{
	
	public enum TpClasseABC {
		CLASSE_A((byte)1), CLASSE_B((byte)2), CLASSE_C((byte)3);

		private final byte value;
		
		private TpClasseABC(byte value){
			this.value = value;
		}
		
		public boolean equals(Byte id) {
			return (id != null && id.equals(id));
		}
		
		public boolean equals(Short id) {
			return (id != null && id.byteValue() == value);
		}
		
		public byte getValue(){
			return this.value;
		}
	}
	
	@Override
	protected OmCfgabclim atribuir(OmCfgabclim from, OmCfgabclim to, boolean isCopiarFK) {
		if (to == null) {
			to = new OmCfgabclim();
		}
		
		to.setCorClasse(from.getCorClasse());
		to.setClasse(from.getClasse());
		to.setIdCfgabclim(from.getIdCfgabclim());
		to.setLimiteInf(from.getLimiteInf());
		to.setLimiteInfClasse(from.getLimiteInfClasse());
		to.setLimiteInfMeta(from.getLimiteInfMeta());
		to.setLimiteSup(from.getLimiteSup());
		to.setLimiteSupClasse(from.getLimiteSupClasse());
		to.setLimiteSupMeta(from.getLimiteSupMeta());
		
		if (isCopiarFK) {
			if (from.getOmInd() != null)
				to.setOmInd(from.getOmInd().clone(false));
		}
		
		return to;
	}
	
	public void inicializarLimites() {
		OmCfgabclim obj = (OmCfgabclim) this;
		obj.setLimiteInf(BigDecimal.ZERO);
		obj.setLimiteInfClasse(BigDecimal.ZERO);
		obj.setLimiteInfMeta(BigDecimal.ZERO);
		obj.setLimiteSup(BigDecimal.ZERO);
		obj.setLimiteSupClasse(BigDecimal.ZERO);
		obj.setLimiteSupMeta(BigDecimal.ZERO);
	}
}
