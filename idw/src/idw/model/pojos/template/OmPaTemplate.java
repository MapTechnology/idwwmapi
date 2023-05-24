package idw.model.pojos.template;

import idw.model.IPojoMAP;
import idw.model.pojos.OmPa;
import idw.model.pojos.OmUsr;


public abstract class OmPaTemplate extends AbstractTemplate<OmPa> implements IPojoMAP{
	public static final String _FIELD_NAME_CD = "CdPa";

	@Override
	public Long getId() {		
		return getInstanceT().getIdPa();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdPa(id == null ? 0L: id.longValue());
	}	
	
	@Override
	public String getCd() {
		return ((OmPa)this).getCdPa();
	}

	@Override
	public String getFieldNameCd() {
		return OmPaTemplate._FIELD_NAME_CD;
	}

	@Override
	protected OmPa atribuir(OmPa from, OmPa to, boolean isCopiarFK) {
		if(to == null){
			to = new OmPa();
		}
		to.setIdPa(from.getIdPa());
		to.setCdPa(from.getCdPa());
		to.setDsPa(from.getDsPa());
		to.setDepara(from.getDepara());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setDesvio(from.getDesvio());
		to.setOrdem(from.getOrdem());		
		to.setRevisao(from.getRevisao());
		to.setStAtivo(from.getStAtivo());
		to.setIsDesagruparAlimentacao(from.getIsDesagruparAlimentacao());

		if (isCopiarFK == true) {
			OmUsr omUsrRev = new OmUsr();
			try {
				omUsrRev.setCdUsr(from.getOmUsrByIdUsrrevisao().getCdUsr());
				omUsrRev.setDsNome(from.getOmUsrByIdUsrrevisao().getDsNome());
			} catch (Exception e) {
				
			}		
			to.setOmUsrByIdUsrrevisao(omUsrRev);
	
			OmUsr omUsrSt = new OmUsr();
			try {
				omUsrSt.setCdUsr(from.getOmUsrByIdUsrstativo().getCdUsr());
				omUsrSt.setDsNome(from.getOmUsrByIdUsrstativo().getDsNome());
			} catch (Exception e) {
				
			}
			to.setOmUsrByIdUsrstativo(omUsrSt);
		}
		
		return to;
    }
}
