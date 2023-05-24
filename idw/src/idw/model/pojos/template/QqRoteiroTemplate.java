package idw.model.pojos.template;

import idw.model.IPojoMAP;
import idw.model.pojos.QqRoteiro;
import idw.model.pojos.QqRoteiroMov;

public abstract class QqRoteiroTemplate extends AbstractTemplate<QqRoteiro> implements IPojoMAP {

	@Override
	public Long getId() {		
		return getInstanceT().getIdRoteiro();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdRoteiro(id == null ? 0L: id.longValue());
	}	
	
	@Override
	public String getCd() {
		return ((QqRoteiro)this).getCdRoteiro();
	}

	@Override
	public String getFieldNameCd() {
		return "CdRoteiro";
	}

	@Override
	protected QqRoteiro atribuir(QqRoteiro from, QqRoteiro to, boolean isCopiarFK) {
		if (to == null)
			to = new QqRoteiro();
		
		to.setIdRoteiro(from.getIdRoteiro());
		to.setCdRoteiro(from.getCdRoteiro());
		to.setRevisao(from.getRevisao());
		to.setDsRoteiro(from.getDsRoteiro());
		to.setStAtivo(from.getStAtivo());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		
		
		if (isCopiarFK) {
			if (from.getOmProduto() != null)
				to.setOmProduto(from.getOmProduto().clone(false));
			
			if (from.getOmUsrByIdUsrrevisao() != null)
				to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone(false));
			
			if (from.getOmUsrByIdUsrstativo() != null)
				to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo().clone(false));
			
			if (from.getQqRoteiroMovs().isEmpty() == false) {
				for (QqRoteiroMov mov : from.getQqRoteiroMovs()) {
					to.getQqRoteiroMovs().add(mov.clone(false));
				}
			}
		}
		
		return to;
	}

}
