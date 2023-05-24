package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.IPojoMAP;
import idw.model.pojos.QqFolhaInsAtiv;
import idw.model.pojos.QqFolhaInsRap;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;

public abstract class QqFolhaInsRapTemplate extends AbstractTemplate<QqFolhaInsRap> implements IPojoMAP{

	public static final String _FIELD_NAME_CD = "CdFolhainsrap";
	
	
	@Override
	public Long getId() {
		return getInstanceT().getIdFolhainsrap();
	}

	@Override
	public void setId(Long id) {
		getInstanceT().setIdFolhainsrap(id);
	}
	@Override
	public String getCd() {
		return ((QqFolhaInsRap) this).getCdFolhainsrap();
	}

	@Override
	public String getFieldNameCd() {
		return QqFolhaInsRapTemplate._FIELD_NAME_CD;
	}

	
	@Override
	public boolean equals(Object o) {
		boolean equals = false;
		if ((o != null) && this.getClass().isAssignableFrom(o.getClass())) {
			final QqFolhaInsRap pojo2 = (QqFolhaInsRap) o;
			final QqFolhaInsRap pojo = (QqFolhaInsRap) this;
			equals = (new EqualsBuilderIdw())
					.append(pojo.getCdFolhainsrap(), pojo2.getCdFolhainsrap())
					.append(pojo.getDsFolhainsrap(), pojo2.getDsFolhainsrap())
					.append(pojo.getDwTprap(), pojo2.getDwTprap())
					.append(pojo.getStAtivo(), pojo2.getStAtivo())
					.append(pojo.getDwGrupoFerramenta(), pojo2.getDwGrupoFerramenta())
					.append(pojo.getOmProduto(), pojo2.getOmProduto())
					.isEquals();
		}
		return equals;
	}

	@Override
	public int hashCode() {
		QqFolhaInsRap pojo = (QqFolhaInsRap) this;
		return (new HashCodeBuilderIdw()).append(pojo.getCdFolhainsrap())
				.append(pojo.getDsFolhainsrap())
				.append(pojo.getStAtivo())
				.append(pojo.getDwTprap())
				.append(pojo.getOmProduto()).toHashCode();
	}
	
	
	@Override
	protected QqFolhaInsRap atribuir(QqFolhaInsRap from, QqFolhaInsRap to, boolean isCopiarFK) {

		if (to == null) {
			to = new QqFolhaInsRap();
		}
		
		to.setIdFolhainsrap(from.getIdFolhainsrap());
		to.setCdFolhainsrap(from.getCdFolhainsrap());
		to.setRevisao(from.getRevisao());
		to.setDsFolhainsrap(from.getDsFolhainsrap());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setStAtivo(from.getStAtivo());

		if (isCopiarFK) {
			if (from.getOmUsrByIdUsrrevisao() != null)
				to.setOmUsrByIdUsrrevisao(CloneUtil.clone(from.getOmUsrByIdUsrrevisao(), false) );
			else
				to.setOmUsrByIdUsrrevisao(null);
			
			if (from.getOmUsrByIdUsrstativo() != null)
				to.setOmUsrByIdUsrstativo(CloneUtil.clone(from.getOmUsrByIdUsrstativo(), false) );
			else
				to.setOmUsrByIdUsrstativo(null);
			
			if (from.getDwGrupoFerramenta() != null)
				to.setDwGrupoFerramenta(CloneUtil.clone(from.getDwGrupoFerramenta(), false));
			else
				to.setDwGrupoFerramenta(null);
			
			if (from.getOmProduto() != null)
				to.setOmProduto(CloneUtil.clone(from.getOmProduto(), false));
			else
				to.setOmProduto(null);
			
			if (from.getDwTprap() != null)
				to.setDwTprap(CloneUtil.clone(from.getDwTprap(), false));
			else
				to.setDwTprap(null);
			
			if (from.getDwRap() != null)
				to.setDwRap(from.getDwRap().clone(false));
			else
				to.setDwRap(null);
			
			if (from.getQqFolhaInsAtivs() != null && from.getQqFolhaInsAtivs().isEmpty() == false) {
				to.setQqFolhaInsAtivs(new HashSet<QqFolhaInsAtiv>());
				for (QqFolhaInsAtiv ativ : from.getQqFolhaInsAtivs()) {
					to.getQqFolhaInsAtivs().add(ativ.clone());
				}
			}

		}
		return to;
	}
}
