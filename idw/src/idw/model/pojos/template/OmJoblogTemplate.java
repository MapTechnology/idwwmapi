package idw.model.pojos.template;

import idw.model.pojos.OmJoblog;


public abstract class OmJoblogTemplate extends AbstractTemplate<OmJoblog>{

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
	protected OmJoblog atribuir(OmJoblog from, OmJoblog to, boolean isCopiarFK) {
		if(to == null) {
			to = new OmJoblog();
		}

		to.setDsExecucao(from.getDsExecucao());
		to.setDthrFexecucao(from.getDthrFexecucao());
		to.setDthrIexecucao(from.getDthrIexecucao());
		to.setStExecucao(from.getStExecucao());
		to.setIdJoblog(from.getIdJoblog());
		
		if (isCopiarFK) {
		}
		
		return to;
	}
}
