package idw.model.pojos.template;

import idw.model.pojos.OmPromidia;

public abstract class OmPromidiaTemplate extends AbstractTemplate<OmPromidia>{
	
	public enum TpMidia {
		_TP_MIDIA_GENERIA( (byte)0),
		_TP_MIDIA_SCRIPTTESTE( (byte) 1);
		
		private byte tpmidia;
		
		private TpMidia(byte tpMidia) {
			this.tpmidia = tpMidia;
		}
		
		public byte getTipoMidia() {
			return this.tpmidia;
		}
	}

	@Override
	protected OmPromidia atribuir(OmPromidia from, OmPromidia to, boolean isCopiarFK) {
		if (to == null) {
			to = new OmPromidia();
		}
		
		to.setDsPromidia(from.getDsPromidia());
		to.setExtensaoArquivo(from.getExtensaoArquivo());
		to.setMidia(from.getMidia());
		to.setDthrCadastro(from.getDthrCadastro());
		to.setDthrIvalidade(from.getDthrIvalidade());
		to.setDthrFvalidade(from.getDthrFvalidade());
		to.setStAtivo(from.getStAtivo());
		to.setTpMidia(from.getTpMidia());
		to.setNomearquivo(from.getNomearquivo());
		
		if (isCopiarFK) {
			
			if (from.getOmUsr() != null) {
				to.setOmUsr(from.getOmUsr().clone(false));
			}
			if (from.getOmTppt() != null) {
				to.setOmTppt(from.getOmTppt().clone(false));
			}
			if (from.getOmPt() != null) {
				to.setOmPt(from.getOmPt().clone(false));
			}
		}
		
		return to;
	}
}
