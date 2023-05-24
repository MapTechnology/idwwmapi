package idw.model.pojos.template;

import idw.model.IPojoMAP;
import idw.model.pojos.MmOs;

public abstract class MmOsTemplate  extends AbstractTemplate<MmOs> implements IPojoMAP{

	public static final String _FIELD_NAME_CD = "CdOs";
	
	
	public enum _ST_OS {
		_ABERTA( (byte) 0),
		_FECHADA((byte) 1);
		
		private byte st_os;
		
		private _ST_OS(byte tp) {
			this.st_os = tp;
		}
		
		public byte getValue() {
			return this.st_os;
		}
	}

	
	
	
	@Override
	public Long getId() {
		return getInstanceT().getIdOs();
	}

	@Override
	public void setId(Long id) {
		getInstanceT().setIdOs(id);
	}

	@Override
	public String getCd() {
		return ((MmOs) this).getCdOs();
	}

	@Override
	public String getFieldNameCd() {
		return MmOsTemplate._FIELD_NAME_CD;
	}

	@Override
	protected MmOs atribuir(MmOs from, MmOs to, boolean isCopiarFK) {
		if (to == null) {
			to = new MmOs();
		}
		
		to.setIdOs(from.getIdOs());
		to.setCdOs(from.getCdOs());
		to.setRevisao(from.getRevisao());
		to.setDsOs(from.getDsOs());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setStAtivo(from.getStAtivo());
		to.setStOs(from.getStOs());
		
		if (isCopiarFK) {
			if (from.getOmUsrByIdUsrrevisao() != null)
				to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone(false));
			else
				to.setOmUsrByIdUsrrevisao(null);
			
			if (from.getOmUsrByIdUsrstativo() != null)
				to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo().clone(false));
			else
				to.setOmUsrByIdUsrstativo(null);
			
			if (from.getMmOsInsRap() != null)
				to.setMmOsInsRap(from.getMmOsInsRap().clone());
			else
				to.setMmOsInsRap(null);
			
			if (from.getMmTpos() != null)
				to.setMmTpos(from.getMmTpos().clone());
			else
				to.setMmTpos(null);
			
		}
		
		return to;
	}

}
