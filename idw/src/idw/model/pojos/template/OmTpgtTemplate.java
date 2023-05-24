package idw.model.pojos.template;

import java.util.Date;

import idw.model.pojos.OmTpgt;

public abstract class OmTpgtTemplate extends AbstractTemplate<OmTpgt> {

	public enum _TP_CONSOLIDACAO {
		_TP_CONSOLIDACAO_SEMCONSOLIDACAO( (byte) 0),
		_TP_CONSOLIDACAO_TODOSOSPOSTOS( (byte) 1);
		
		private byte tpConsolidacao;
		
		private _TP_CONSOLIDACAO(byte tpconsolidacao) {
			this.tpConsolidacao = tpconsolidacao;
		}
		
		public byte getTpConsolidacao() {
			return this.tpConsolidacao;
		}
	}
	
	
	public enum Type {

		EMPRESA(1), 
		FABRICA(2), 
		CELULA_LINHA(3), 
		BRACO(4), 
		ESTACAO_TESTE(5), 
		SMD(6);

		private final long id;

		private Type(long id) {
			this.id = id;
		}

		public long getId() {
			return this.id;
		}

		/**
		 * Pega o OmTpgtTemplate.Type, com base no id 
		 * @param id
		 * @return
		 */
		public static Type get(long id) {
			for (Type type : Type.values()) {
				if (type.equals(id)) {
					return type;
				}
			}

			throw new IllegalArgumentException(
					"Nao foi possivel identificar o tipo do grupo de trabalho. id="
							+ id);
		}

		public boolean equals(long id) {
			return this.id == id;
		}

	}

	@Override
	protected OmTpgt atribuir(OmTpgt itemGet, OmTpgt itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new OmTpgt();

		itemSet.setIdTpgt(itemGet.getIdTpgt());
		itemSet.setCdTpgt(itemGet.getCdTpgt());
		itemSet.setDsTpgt(itemGet.getDsTpgt());
		itemSet.setTpConsolidacao(itemGet.getTpConsolidacao());
		itemSet.setStAtivo(itemGet.getStAtivo());
		itemSet.setRevisao(itemGet.getRevisao());

		if (itemGet.getDtRevisao() != null) {
			itemSet.setDtRevisao((Date) itemGet.getDtRevisao().clone());
		}

		if (itemGet.getDtStativo() != null) {
			itemSet.setDtStativo((Date) itemGet.getDtStativo().clone());
		}

		if (isCopiarFK) {
			if (itemGet.getOmUsrByIdUsrrevisao() != null) {
				itemSet.setOmUsrByIdUsrrevisao(itemGet.getOmUsrByIdUsrrevisao()
						.clone());
			}
			if (itemGet.getOmUsrByIdUsrstativo() != null) {
				itemSet.setOmUsrByIdUsrstativo(itemGet.getOmUsrByIdUsrstativo()
						.clone());
			}
		}

		return itemSet;
	}
}
