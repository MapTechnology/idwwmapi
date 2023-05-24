package idw.model.pojos.template;

import idw.model.pojos.OmJobdetlog;


public abstract class OmJobdetlogTemplate extends AbstractTemplate<OmJobdetlog>{

	public enum _StExecucao{
		ERRO((byte)0), 
		SUCESSO((byte)1);
		
		private final byte value;
		
		_StExecucao(byte value){
			this.value = value;
		}
		
		public byte getValue(){
			return this.value;
		}
	}
	
	
	@Override
	protected OmJobdetlog atribuir(OmJobdetlog from, OmJobdetlog to, boolean isCopiarFK) {
		if(to == null) {
			to = new OmJobdetlog();
		}

		to.setDsExecucao(from.getDsExecucao());
		to.setDthrFexecucao(from.getDthrFexecucao());
		to.setDthrIexecucao(from.getDthrIexecucao());
		to.setStExecucao(from.getStExecucao());
		to.setUrlOrigem(from.getUrlOrigem());
		to.setIdJobdetlog(from.getIdJobdetlog());
		
		if (isCopiarFK) {
		}
		
		return to;
	}
}
