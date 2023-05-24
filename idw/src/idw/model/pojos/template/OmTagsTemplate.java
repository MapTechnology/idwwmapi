package idw.model.pojos.template;

import idw.model.pojos.OmTags;

public class OmTagsTemplate extends AbstractTemplate<OmTags> {

	public enum TAG {
		CAIXA("@caixa"),
		CBGT("@cbgt"),
		SEQUENCIAL_SEMANA_ANO("@sequencialsemanaanual");

		private final String value;

		TAG (String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}

		public boolean equals(String value) {
			if (value != null) {
				return this.value.equals(value);
			}
			return false;
		}

	}

	@Override
	protected OmTags atribuir(OmTags from, OmTags to, boolean isCopiarFK) {

		if(to == null){
			to = new OmTags();
		}

		to.setIdTags(from.getIdTags());
		to.setCdTags(from.getCdTags());
		to.setDsTags(from.getDsTags());

		return to;
	}

}