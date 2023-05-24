package idw.model.pojos.template;

import idw.model.pojos.PpPlano;

public abstract class PpPlanoTemplate extends AbstractTemplate<PpPlano> {
	//public abstract Set<PpPlanec> getPpPlanecs();
	
	public enum TpPlano{
		CADASTRADO(0), FIRMADO(1), CANCELADO(2);
		private final Integer id;
		private TpPlano(Integer id){
			this.id = id;
		}
		
		public Integer getId(){
			return this.id;
		}
		
		public boolean equals(Integer id){
			return this.id.equals(id);
		}
		
		public static TpPlano get(Integer id){
			for(TpPlano tpPlano: TpPlano.values()){
				if(tpPlano.equals(id)){
					return tpPlano;
				}
			}
			return null;
		}
	}
	
	@Override
	protected PpPlano atribuir(PpPlano from, PpPlano to, boolean isCopiarFK) {
		if(to == null) {
			to = new PpPlano();
		}
		
		to.setIdPlano(from.getIdPlano());
		to.setCdPlano(from.getCdPlano());
		to.setDsPlano(from.getDsPlano());
		to.setDthrPrevisaoinicio(from.getDthrPrevisaoinicio());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setIndOee(from.getIndOee());
		to.setIsConsiderarcal(from.getIsConsiderarcal());
		to.setIsConsiderarcm(from.getIsConsiderarcm());
		to.setIsSimular(from.getIsSimular());
		to.setIsConsiderarest(from.getIsConsiderarest());
		to.setIsConsiderarindisp(from.getIsConsiderarindisp());
		to.setIsConsiderarmo(from.getIsConsiderarmo());
		to.setIsConsiderarmp(from.getIsConsiderarmp());
		to.setIsConsideraroeefinalserie(from.getIsConsideraroeefinalserie());
		to.setIsConsiderarprodutoturno(from.getIsConsiderarprodutoturno());
		to.setIsConsiderarrap(from.getIsConsiderarrap());
		to.setIsDeterminadocal(from.getIsDeterminadocal());
		to.setIsModelo(from.getIsModelo());
		to.setRevisao(from.getRevisao());
		to.setStAtivo(from.getStAtivo());
		to.setStPlano(from.getStPlano());
		
		return to;
	}

}
