package idw.model.pojos.template;

import idw.model.pojos.OmGrnts;
import idw.util.CloneUtil;



public abstract class OmGrntsTemplate extends AbstractTemplate<OmGrnts> {

	public enum _TpAcesso{
		_ACESSOLIBERADO((byte)0),
		_ACESSONEGADO((byte)1);

		private final byte value;
		private _TpAcesso(byte value){
			this.value = value;
		}
		public byte getValue(){
			return this.value;
		}

	}

	@Override
	protected OmGrnts atribuir(OmGrnts from, OmGrnts to, boolean isCopiarFK) {
		if(to == null){
			to = new OmGrnts();
		}

		to.setIdGrnts(CloneUtil.clone(from.getIdGrnts()));
		to.setTpAcesso(CloneUtil.clone(from.getTpAcesso()));

		if(isCopiarFK){
			to.setOmResgui(CloneUtil.clone(from.getOmResgui(),false));
			to.setOmUsrgrp(CloneUtil.clone(from.getOmUsrgrp(),false));
		}

		return to;
	}


}
