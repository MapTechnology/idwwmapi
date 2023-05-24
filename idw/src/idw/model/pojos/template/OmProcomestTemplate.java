package idw.model.pojos.template;


public abstract class OmProcomestTemplate implements Cloneable{
	
	/** Tipo do produto na estrutura */ 
	public enum TpProcomest{
	
		/** Matéria prima (0) */
		MATERIA_PRIMA(0), 
		/** Semi-Acabado (1) */		
		SEMI_ACABADO(1);
		
		private int id;
		private TpProcomest(int id){
			this.id = id;
		}
		public int getId(){
			return this.id;
		}
		
		public boolean equals(Integer id){
			return ( id == null ? false: id.equals(this.id));
		}
		
		public static TpProcomest valueOf(Integer id){
			for(TpProcomest item: TpProcomest.values()){
				if(id.equals(item.getId())){
					return item;
				}
			}
			return null;
		}
		
	}
}
