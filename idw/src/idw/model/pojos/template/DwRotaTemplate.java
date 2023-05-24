package idw.model.pojos.template;

import java.util.HashSet;

import org.hibernate.SessionException;

import idw.model.IPojoMAP;
import idw.model.pojos.DwRota;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.OmObj;
import idw.model.pojos.OmProduto;

public abstract class DwRotaTemplate extends AbstractTemplate<DwRota> implements IPojoMAP {

	@Override
	public Long getId() {		
		return getInstanceT().getIdRota();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdRota(id == null ? 0L: id.longValue());
	}	
	
	@Override
	public String getCd() {
		return ((DwRota)this).getCdRota();
	}

	@Override
	public String getFieldNameCd() {
		return "CdRota";
	}

	@Override
	protected DwRota atribuir(DwRota itemGet, DwRota itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwRota();
		
		itemSet.setIdRota(itemGet.getIdRota());
		itemSet.setCdRota(itemGet.getCdRota());
		itemSet.setDsRota(itemGet.getDsRota());
		itemSet.setDtRevisao(itemGet.getDtRevisao());
		itemSet.setDtStativo(itemGet.getDtStativo());
		itemSet.setIsModelo(itemGet.getIsModelo());
		itemSet.setIsPassaadiante(itemGet.getIsPassaadiante());
		itemSet.setAltura(itemGet.getAltura());
		itemSet.setLargura(itemGet.getLargura());
		itemSet.setGridx(itemGet.getGridx());
		itemSet.setGridy(itemGet.getGridy());
		itemSet.setRevisao(itemGet.getRevisao());
		itemSet.setStAtivo(itemGet.getStAtivo());
		
		if (isCopiarFK == true) {
			if (itemGet.getOmGt() != null){
				try {
					itemSet.setOmGt(itemGet.getOmGt().clone());
				}catch(SessionException e) {
					itemSet.setOmGt(null);
				}
			}
			if (itemGet.getOmProduto() != null){
				try {
					itemSet.setOmProduto((OmProduto)itemGet.getOmProduto().clone());
				}catch(SessionException e) {
					itemSet.setOmProduto(null);
				}
			}
			if (itemGet.getOmUsrByIdUsrrevisao() != null){
				try {
					itemSet.setOmUsrByIdUsrrevisao(itemGet.getOmUsrByIdUsrrevisao().clone());
				}catch(SessionException e) {
					itemSet.setOmUsrByIdUsrrevisao(null);
				}
			}
			if (itemGet.getOmUsrByIdUsrstativo() != null){
				try {
					itemSet.setOmUsrByIdUsrstativo(itemGet.getOmUsrByIdUsrstativo().clone());
				}catch(SessionException e) {
					itemSet.setOmUsrByIdUsrstativo(null);
				}
			}
			if((itemGet.getDwRotapassos() != null) && (!itemGet.getDwRotapassos().isEmpty())) {
				try {
					itemSet.setDwRotapassos(new HashSet<DwRotapasso>());
					
					for(DwRotapasso rotapasso : itemGet.getDwRotapassos()) {
						itemSet.getDwRotapassos().add((DwRotapasso) rotapasso.clone());
					}
				}catch(SessionException e) {
					itemSet.setDwRotapassos(null);
				}
			}
			
			if(itemGet.getOmObjsForIdRota() != null && !itemGet.getOmObjsForIdRota().isEmpty()){
				try{
					itemSet.setOmObjsForIdRota(new HashSet<OmObj>());

					for(OmObj obj : itemGet.getOmObjsForIdRota()){
						itemSet.getOmObjsForIdRota().add((OmObj) obj.clone());
					}
				}catch(SessionException e){
					itemSet.setOmObjsForIdRota(null);
				}
			}
			
		}
		
		return itemSet;
	}

}
