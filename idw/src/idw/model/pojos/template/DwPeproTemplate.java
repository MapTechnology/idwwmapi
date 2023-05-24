package idw.model.pojos.template;

import idw.model.pojos.DwPepro;
import idw.model.pojos.OmTppt;


public abstract class DwPeproTemplate implements Cloneable{
	
	public enum Type {
		
		NORMAL(1), 
		CONTROLE_REINICIO_DE_PROCESSO(2), 
		REGULAGEM(3), 
		PERDA_DE_SINCRONIA(4);
		
		private final long id;
		
		private Type(long id){
			this.id = id;
		}
		
		public long getId(){
			return this.id;
		}
		
		/**
		 * Pega o DwPeproTemplate.Type, com base no id
		 * @param id
		 * @return
		 */
		public static Type get(long id) {
			for (Type type : Type.values()){
				if (type.equals(id)){
					return type;
				}
			}			
			throw new IllegalArgumentException("Não foi possivel identificar o pepro. id = " + id);
		}			
		
		public boolean equals(long id){
			return this.id == id;
		}
		
		public boolean equals(OmTppt omTppt){
			if(omTppt == null){
				return false;
			}
			
			return equals(omTppt.getIdTppt());
		}
		
	}
	
	@Override
	public Object clone() {
		DwPepro dwPepro = (DwPepro) this;
		
		DwPepro clone = new DwPepro();
		clone.setIdPepro(dwPepro.getIdPepro());
		clone.setDsPepro(dwPepro.getDsPepro());
				
		return clone;

	  }
	
	public void copy(DwPepro omFrom,boolean copiarFK){
		DwPepro omTo = (DwPepro) this;
		omTo.setIdPepro(omFrom.getIdPepro());
		omTo.setDsPepro(omFrom.getDsPepro());
	}
	
}
