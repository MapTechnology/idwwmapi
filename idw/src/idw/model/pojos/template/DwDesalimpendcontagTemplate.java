package idw.model.pojos.template;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.CompareToBuilder;

import idw.model.pojos.DwDesalimpendcontag;

public class DwDesalimpendcontagTemplate extends AbstractTemplate<DwDesalimpendcontag> implements Comparable<DwDesalimpendcontag>{

	@Override
	public int compareTo(DwDesalimpendcontag o) {
		Validate.notNull(o);
		return new CompareToBuilder()
				.append(getInstanceT().getDthrDesalim(), o.getDthrDesalim())
				.append(getInstanceT().getIdDesalimpendcontag(), o.getIdDesalimpendcontag())
				.toComparison();
	}

	@Override
	protected DwDesalimpendcontag atribuir(DwDesalimpendcontag from, DwDesalimpendcontag to, boolean isCopiarFK) {
		
		if (to == null) {
			to = new DwDesalimpendcontag();
		}
		
		to.setIdDesalimpendcontag(from.getIdDesalimpendcontag());
		to.setDthrDesalim(from.getDthrDesalim());
		to.setQtDesalim(from.getQtDesalim());
		
		if(isCopiarFK){
			to.setDwEstlocalpro(from.getDwEstlocalpro().clone(true));
		}
		return to;
	}

}
