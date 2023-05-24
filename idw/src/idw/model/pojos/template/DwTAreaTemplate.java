
package idw.model.pojos.template;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import idw.model.IPojoMAP;
import idw.model.pojos.DwTArea;
import idw.model.pojos.OmUsr;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;



public abstract class DwTAreaTemplate extends AbstractTemplate<DwTArea> implements IPojoMAP {

	public static final String _FIELD_NAME_CD = "cdArea";
	private static final int _MAX_LEN_CD_AREA = 30;
	private static final int _MAX_LEN_DS_AREA = 40;

	@Override
	public Long getId() {		
		return getInstanceT().getIdArea();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdArea(id == null ? 0L: id.longValue());
	}	
	
	/**
	 * Campos usados no equals: CdArea, DsArea, StAtivo, Email
	 */
	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final DwTArea dwTAreaOther = (DwTArea) o;
			final DwTArea dwTArea = (DwTArea) this;
			equals = (new EqualsBuilderIdw())
						.append(dwTArea.getCdArea(), dwTAreaOther.getCdArea())
						.append(dwTArea.getDsArea(), dwTAreaOther.getDsArea())
						.append(dwTArea.getStAtivo(), dwTAreaOther.getStAtivo())
						.append(dwTArea.getEmail(), dwTAreaOther.getEmail())
						.isEquals();
		}
		return equals;
	}
	
	/**
	 * Campos usados no hashCode: CdArea, DsArea, StAtivo, Email
	 */
	@Override
	public int hashCode(){

		DwTArea dwTArea = (DwTArea) this;

		return (new HashCodeBuilderIdw())
				.append(dwTArea.getCdArea())
				.append(dwTArea.getDsArea())
				.append(dwTArea.getStAtivo())
				.append(dwTArea.getEmail())
				.toHashCode();
	}
	
	public void set(long idArea, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdArea, Long revisao,
			String dsArea, Date dtRevisao, Byte stAtivo, Date dtStativo, String email) {

		DwTArea dwTArea = (DwTArea) this;

		dwTArea.setIdArea(idArea);
		dwTArea.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		dwTArea.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		dwTArea.setCdArea(cdArea);
		dwTArea.setRevisao(revisao);
		dwTArea.setDsArea(dsArea);
		dwTArea.setDtRevisao(dtRevisao);
		dwTArea.setStAtivo(stAtivo);
		dwTArea.setDtStativo(dtStativo);
		dwTArea.setEmail(email);
		
	}
	
	/*@Override
	protected DwTArea atribuir(DwTArea itemGet, DwTArea itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwTArea();
		
		itemSet.setIdArea(itemGet.getIdArea());
		if(isCopiarFK == true){
		itemSet.setOmUsrByIdUsrstativo(itemGet.getOmUsrByIdUsrstativo().clone(false));
		itemSet.setOmUsrByIdUsrrevisao(itemGet.getOmUsrByIdUsrrevisao().clone(false));
		}
		itemSet.setCdArea(itemGet.getCdArea());
		itemSet.setRevisao(itemGet.getRevisao());
		itemSet.setDsArea(itemGet.getDsArea());
		itemSet.setStAtivo(itemGet.getStAtivo());
		itemSet.setDtStativo(itemGet.getDtStativo());
		itemSet.setDtRevisao(itemGet.getDtRevisao());
		
		
	
		return itemSet;
	}	*/
	
	@Override
	protected DwTArea atribuir(DwTArea itemGet, DwTArea itemSet,
			boolean isCopiarFK) {

		if (itemSet == null) {
			itemSet = new DwTArea();
		}

//		itemSet.setIdArea(CloneUtil.clone(itemGet.getIdArea()));
//		itemSet.setOmUsrByIdUsrstativo(CloneUtil.clone(itemGet.getOmUsrByIdUsrstativo(),false));
//		itemSet.setOmUsrByIdUsrrevisao(CloneUtil.clone(itemGet.getOmUsrByIdUsrrevisao(),false));
//        itemSet.setCdArea(CloneUtil.clone(itemGet.getCdArea()));
//		itemSet.setRevisao(CloneUtil.clone(itemGet.getRevisao()));
//		itemSet.setDsArea(CloneUtil.clone(itemGet.getDsArea()));
//		itemSet.setDtRevisao(CloneUtil.clone(itemGet.getDtRevisao()));
//		itemSet.setStAtivo(CloneUtil.clone(itemGet.getStAtivo()));
//		itemSet.setDtStativo(CloneUtil.clone(itemGet.getDtStativo()));


		itemSet.set(
				itemGet.getIdArea(),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrstativo(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrrevisao(),false) : null),
				itemGet.getCdArea(),
				itemGet.getRevisao(),
				itemGet.getDsArea(),
				itemGet.getDtRevisao(),
				itemGet.getStAtivo(),
				itemGet.getDtStativo(),
				itemGet.getEmail());

		return itemSet;

	}
	
	public void limitarStrings(){
		DwTArea dwTArea = (DwTArea) this;
		dwTArea.setCdArea(StringUtils.left(dwTArea.getCdArea(), DwTAreaTemplate._MAX_LEN_CD_AREA));
		dwTArea.setDsArea(StringUtils.left(dwTArea.getDsArea(), DwTAreaTemplate._MAX_LEN_DS_AREA));
	}
	
	@Override
	public String getCd() {
		return ((DwTArea)this).getCdArea();
	}

	@Override
	public String getFieldNameCd() {
		return DwTAreaTemplate._FIELD_NAME_CD;
	}
}
