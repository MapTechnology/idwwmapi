package idw.model.pojos.template;

import idw.model.pojos.OmProrange;

public class OmProrangeTemplate extends AbstractTemplate<OmProrange>{
	
	public enum _TPREGRA {
		TP_REGRA_DECIMAL((byte)0),
		TP_REGRA_HEXADECIMAL((byte)1);
		
		private byte tp;
		
		private _TPREGRA(byte tp) {
			this.tp = tp;
		}
		
		public byte getValue() {
			return this.tp;
		}
	}

	@Override
	protected OmProrange atribuir(OmProrange from, OmProrange to, boolean isCopiarFK) {
		
		if (to == null)
			to = new OmProrange();
		
		to.setConsumoporciclo(from.getConsumoporciclo());
		to.setIdProrange(from.getIdProrange());
		to.setNsFinal(from.getNsFinal());
		to.setNsInicial(from.getNsInicial());
		to.setQtConsumida(from.getQtConsumida());
		to.setQtTotal(from.getQtTotal());
		to.setStAtivo(from.getStAtivo());
		to.setTpRegra(from.getTpRegra());
		to.setIsExclusivo(from.getIsExclusivo());
		to.setDthrRevisao(from.getDthrRevisao());
		to.setDthrStativo(from.getDthrStativo());
		
		if (isCopiarFK) {
			if (from.getDwMacrange() != null)
				to.setDwMacrange(from.getDwMacrange().clone(false));
			
			if (from.getOmProduto() != null)
				to.setOmProduto(from.getOmProduto().clone(false));
			
			if (from.getOmUsrByIdUsrrevisao() != null)
				to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone(false));
			
			if (from.getOmUsrByIdUsrstativo() != null)
				to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo().clone(false));
		}
		return to;
		
	}

}
