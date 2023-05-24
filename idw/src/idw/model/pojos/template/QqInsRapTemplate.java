package idw.model.pojos.template;

import idw.model.IPojoMAP;
import idw.model.pojos.QqInsRap;

public abstract class QqInsRapTemplate extends AbstractTemplate<QqInsRap> implements IPojoMAP {

	public static final String _FIELD_NAME_CD = "CdInspecao";
	
	
	public enum _ST_INSPECAO {
		_NAO_CONFORME( (byte) 0),
		_CONFORME((byte) 1);
		
		private byte st_inspecao;
		
		private _ST_INSPECAO(byte tp) {
			this.st_inspecao = tp;
		}
		
		public byte getValue() {
			return this.st_inspecao;
		}
	}

	
	@Override
	public Long getId() {
		return getInstanceT().getIdInsRap();
	}

	@Override
	public void setId(Long id) {
		getInstanceT().setIdInsRap(id);
	}

	@Override
	public String getCd() {
		return ((QqInsRap) this).getCdInspecao();
	}

	@Override
	public String getFieldNameCd() {
		return MmOsTemplate._FIELD_NAME_CD;
	}

	@Override
	protected QqInsRap atribuir(QqInsRap from, QqInsRap to, boolean isCopiarFK) {
		if (to == null)
			to = new QqInsRap();
		
		to.setIdInsRap(from.getIdInsRap());
		to.setCdInspecao(from.getCdInspecao());
		to.setRevisao(from.getRevisao());
		to.setStAtivo(from.getStAtivo());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setDsInspecao(from.getDsInspecao());
		to.setStInspecao(from.getStInspecao());
		
		if (isCopiarFK) {
			if (from.getDwRap() != null)
				to.setDwRap(from.getDwRap().clone(false));
			else
				to.setDwRap(null);
			
			if (from.getMmOsInsRap() != null)
				to.setMmOsInsRap(from.getMmOsInsRap().clone(false));
			else
				to.setMmOsInsRap(null);
			
			if (from.getOmUsrByIdUsrrevisao() != null)
				to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone(false));
			else
				to.setOmUsrByIdUsrrevisao(null);
			
			if (from.getOmUsrByIdUsrstativo() != null)
				to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo().clone(false));
			else
				to.setOmUsrByIdUsrstativo(null);
			
		}
		
		return to;
	}
}
