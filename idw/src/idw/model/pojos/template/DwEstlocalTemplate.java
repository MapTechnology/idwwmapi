package idw.model.pojos.template;

import idw.model.IPojoMAP;
import idw.model.pojos.DwEstlocal;

public abstract class DwEstlocalTemplate extends AbstractTemplate<DwEstlocal> implements IPojoMAP{

	public static final String _FIELD_NAME_CD = "CdPt";
	
	public enum TpLocalEstoque{
		
		DESCONHECIDO((byte)0),
		ALIMENTACAO((byte)1),
		DESALIMENTACAO((byte)2);
		
		private final byte id;
		
		TpLocalEstoque(byte id){
			this.id = id;
		}
		
		public byte getId(){
			return this.id; 
		}
	}
	
	@Override
	public Long getId() {
		return getInstanceT().getIdEstlocal();
	}

	@Override
	public void setId(Long id) {
		getInstanceT().setIdEstlocal(id);
	}

	@Override
	public String getCd() {
		return ((DwEstlocal)this).getCdLocal();
	}

	@Override
	public String getFieldNameCd() {
		return DwEstlocalTemplate._FIELD_NAME_CD;
	}

	@Override
	protected DwEstlocal atribuir(DwEstlocal from, DwEstlocal to, boolean isCopiarFK) {
		if(to == null){
			to = new DwEstlocal();
		}
		
		to.setIdEstlocal(from.getIdEstlocal());
		to.setCdLocal(from.getCdLocal());
		to.setDsLocal(from.getDsLocal());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setStAtivo(from.getStAtivo());
		to.setRevisao(from.getRevisao());
		to.setAutomatico(from.getAutomatico());
		to.setTpLocalEstoque(from.getTpLocalEstoque());
		
		if (isCopiarFK == true){
			if(from.getOmUsrByIdUsrrevisao() != null){
				to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone(false));
			}
			if(from.getOmUsrByIdUsrstativo() != null){
				to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo().clone(false));
			}
			if(from.getDwEst() != null){
				to.setDwEst(from.getDwEst().clone(false));
			}
			if(from.getOmGt() != null) {
				to.setOmGt(from.getOmGt().clone(false));
			}
			if(from.getOmPt() != null) {
				to.setOmPt(from.getOmPt().clone(false));
			}
			if(from.getOmPa() != null) {
				to.setOmPa(from.getOmPa().clone(false));
			}
		}
		return to;
	}

	

}
