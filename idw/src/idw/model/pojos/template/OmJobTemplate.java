package idw.model.pojos.template;

import idw.model.IPojoMAP;
import idw.model.pojos.OmJob;


public abstract class OmJobTemplate extends AbstractTemplate<OmJob> implements IPojoMAP{

	public final static String _FIELD_NAME_CD = "CdJob";

	public enum _TpIntegracao{
		TDBA(0), 
		ARQUIVOTEXTO(1),
		ERP_FLEX(2),
		MANUTENCAO(3);
		
		private final int value;
		
		_TpIntegracao(int value){
			this.value = value;
		}
		
		public int getValue(){
			return this.value;
		}
	}
	
	
	@Override
	protected OmJob atribuir(OmJob from, OmJob to, boolean isCopiarFK) {
		if(to == null) {
			to = new OmJob();
		}
		
		to.setCdJob(from.getCdJob());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setIdJob(from.getIdJob());
		to.setPadraoSchedule(from.getPadraoSchedule());
		to.setStAtivo(from.getStAtivo());
		to.setRevisao(from.getRevisao());
		to.setTpIntegracao(from.getTpIntegracao());
		to.setDsJob(from.getDsJob());
		
		if (isCopiarFK) {
			if (from.getOmUsrByIdUsrrevisao() != null)
				to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone(false));
			if (from.getOmUsrByIdUsrstativo() != null)
				to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo().clone(false));
		}
		
		return to;
	}
	
	@Override
	public String getCd() {
		return ((OmJob)this).getCdJob();
	}

	@Override
	public String getFieldNameCd() {
		return OmJobTemplate._FIELD_NAME_CD;
	}
	@Override
	public Long getId() {		
		return getInstanceT().getIdJob();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdJob(id);
	}	
}
