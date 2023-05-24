package idw.model.pojos.template;

import java.util.Date;
import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;

import idw.model.IPojoMAP;
import idw.model.pojos.DwGfTpos;
import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.OmUsr;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;

public abstract class DwGrupoFerramentaTemplate extends AbstractTemplate<DwGrupoFerramenta> implements IPojoMAP{
	
	public static final String _FIELD_NAME_CD = "CdGrupoFerramenta";
	private static final int _MAX_LEN_CD_GRUPOFERRAMENTA = 60;
	private static final int _MAX_LEN_DS_GRUPOFERRAMENTA = 100;

	@Override
	public Long getId() {		
		return getInstanceT().getIdGrupoFerramenta();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdGrupoFerramenta(id);
	}	
	
	@Override
	public String getCd() {
		return ((DwGrupoFerramenta)this).getCdGrupoFerramenta();
	}

	@Override
	public String getFieldNameCd() {
		return DwGrupoFerramentaTemplate._FIELD_NAME_CD;
	}

	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final DwGrupoFerramenta dwGrupoFerramentaOther = (DwGrupoFerramenta) o;
			final DwGrupoFerramenta dwGrupoFerramenta = (DwGrupoFerramenta) this;
			equals = (new EqualsBuilderIdw())
						.append(dwGrupoFerramenta.getCdGrupoFerramenta(), dwGrupoFerramentaOther.getCdGrupoFerramenta())
						.append(dwGrupoFerramenta.getDsGrupoFerramenta(), dwGrupoFerramentaOther.getDsGrupoFerramenta())
						.append(dwGrupoFerramenta.getStAtivo(), dwGrupoFerramentaOther.getStAtivo())
						.isEquals();
		}
		return equals;
	}

	@Override
	public int hashCode(){

		DwGrupoFerramenta dwGrupoFerramenta = (DwGrupoFerramenta) this;

		return (new HashCodeBuilderIdw())
						.append(dwGrupoFerramenta.getCdGrupoFerramenta())
						.append(dwGrupoFerramenta.getDsGrupoFerramenta())
						.append(dwGrupoFerramenta.getStAtivo())
						.toHashCode();
	}

	public void set(
			Long id, 
			String cd, 
			Long revisao, 
			Date dtStativo, 
			Date dtRevisao, 
			Byte stAtivo,
			String ds){

		DwGrupoFerramenta dwGrupoFerramenta = (DwGrupoFerramenta) this;
		dwGrupoFerramenta.setIdGrupoFerramenta(id);
		dwGrupoFerramenta.setCdGrupoFerramenta(cd);
		dwGrupoFerramenta.setRevisao(revisao);
		dwGrupoFerramenta.setDtStativo(dtStativo);
		dwGrupoFerramenta.setDtRevisao(dtRevisao);
		dwGrupoFerramenta.setStAtivo(stAtivo);
		dwGrupoFerramenta.setDsGrupoFerramenta(ds);
	}

	public void set(OmUsr omUsrByIdUsrstativo, OmUsr omUsrByIdUsrrevisao){
		DwGrupoFerramenta obj = (DwGrupoFerramenta) this;
		obj.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		obj.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
	}

	@Override
	protected DwGrupoFerramenta atribuir(DwGrupoFerramenta from, DwGrupoFerramenta to, boolean isCopiarFK) {
		if (to == null) {
			to = new DwGrupoFerramenta();
		}

		to.set(
				from.getIdGrupoFerramenta(),
				from.getCdGrupoFerramenta(),
				from.getRevisao(),
				from.getDtStativo(),
				from.getDtRevisao(),
				from.getStAtivo(),
				from.getDsGrupoFerramenta());

		if (isCopiarFK == true){
			to.setOmUsrByIdUsrrevisao(CloneUtil.clone(from.getOmUsrByIdUsrrevisao(),false));
			to.setOmUsrByIdUsrstativo(CloneUtil.clone(from.getOmUsrByIdUsrstativo(),false));
			
			if (from.getDwGfTposes() != null) {
				to.setDwGfTposes(new HashSet<DwGfTpos>());
				for (DwGfTpos tpos : from.getDwGfTposes()) {
					to.getDwGfTposes().add(tpos.clone());
				}
			}
			
		}

		return to;
	}

	public void limitarStrings(){
		DwGrupoFerramenta dwgrupoferramenta = (DwGrupoFerramenta) this;
		dwgrupoferramenta.setCdGrupoFerramenta(StringUtils.left(dwgrupoferramenta.getCdGrupoFerramenta(), DwGrupoFerramentaTemplate._MAX_LEN_CD_GRUPOFERRAMENTA));
		dwgrupoferramenta.setDsGrupoFerramenta(StringUtils.left(dwgrupoferramenta.getDsGrupoFerramenta(), DwGrupoFerramentaTemplate._MAX_LEN_DS_GRUPOFERRAMENTA));
	}

}
