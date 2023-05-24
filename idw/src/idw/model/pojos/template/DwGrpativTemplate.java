package idw.model.pojos.template;

import java.util.Date;

import idw.model.IPojoMAP;
import idw.model.pojos.DwGrpativ;
import idw.model.pojos.OmUsr;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;

public abstract class DwGrpativTemplate  extends AbstractTemplate<DwGrpativ> implements IPojoMAP{
	
	public static final String _FIELD_NAME_CD = "CdGrpativ";
	
	@Override
	public Long getId() {
		return getInstanceT().getIdGrpativ();
	}

	@Override
	public void setId(Long id) {
		getInstanceT().setIdGrpativ(id == null ? 0L: id.longValue());
	}

	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final DwGrpativ dwGrpativOther = (DwGrpativ) o;
			final DwGrpativ dwGrpativ = (DwGrpativ) this;
			equals = (new EqualsBuilderIdw())
						.append(dwGrpativ.getCdGrpativ(), dwGrpativOther.getCdGrpativ())
						.append(dwGrpativ.getDsGrpativ(), dwGrpativOther.getDsGrpativ())
						.append(dwGrpativ.getStAtivo(), dwGrpativOther.getStAtivo())
						.isEquals();
		}
		return equals;
	}
	
	@Override
	public String getCd() {
		return ((DwGrpativ) this).getCdGrpativ();
	}

	@Override
	public String getFieldNameCd() {
		return DwGrpativTemplate._FIELD_NAME_CD;
	}
	
	public void set(long idGrpativ, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdGrpativ, Long revisao,
			String dsGrpativ, Date dtRevisao, Byte stAtivo, Date dtStativo) {

		DwGrpativ dwGrpativ = (DwGrpativ) this;

		dwGrpativ.setIdGrpativ(idGrpativ);
		dwGrpativ.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		dwGrpativ.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		dwGrpativ.setCdGrpativ(cdGrpativ);
		dwGrpativ.setRevisao(revisao);
		dwGrpativ.setDsGrpativ(dsGrpativ);
		dwGrpativ.setDtRevisao(dtRevisao);
		dwGrpativ.setStAtivo(stAtivo);
		dwGrpativ.setDtStativo(dtStativo);

	}
	
	@Override
	protected DwGrpativ atribuir(DwGrpativ itemGet, DwGrpativ itemSet,
			boolean isCopiarFK) {
		if (itemSet == null) {
			itemSet = new DwGrpativ();
		}

		itemSet.set(
				itemGet.getIdGrpativ(),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrstativo(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrrevisao(),false) : null),
				itemGet.getCdGrpativ(),
				itemGet.getRevisao(),
				itemGet.getDsGrpativ(),
				itemGet.getDtRevisao(),
				itemGet.getStAtivo(),
				itemGet.getDtStativo());

		return itemSet;
		
	}

}
