package idw.model.pojos.injet.template;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import idw.model.pojos.injet.IjtbfreshId;

public abstract class IjtbfreshTemplate {
	
	public abstract IjtbfreshId getPk();
	
    public boolean obtemIsConsiderarCorrecaoDeTempo(){
    	return (getPk().getCampo29().equals("³·­") ? true : false);
    }
    
    public boolean obtemIsConsiderarTotalCavidades(){
    	return (getPk().getCampo23().equals("¬¬ª¿±·¿½­") ? true : false);
    }


	public enum EmpresaType{
		/** C�digo 000001*/ 
		MAP("000001"), 
		TESTE("000032"),
		WHIRLPOOL_JOINVILLE_IJ("000076"), 
		WHIRLPOOL_JOINVILLE_IM("000077"), 
		WHIRLPOOL_JOINVILLE_IT("000078"), 
		WHIRLPOOL_JOINVILLE_IC1("000079"), 
		WHIRLPOOL_JOINVILLE_IC2("000080"),
		WHIRLPOOL_JOINVILLE_IC3("000081"), 
		WHIRLPOOL_JOINVILLE_IC5("000180"),
		WHIRLPOOL_JOINVILLE_PU("000104"); 
		
		/**
		 * Cole��o com a indexa��o do c�digos da empresa
		 */
		private static final Map<String, EmpresaType> lookup = new HashMap<String, EmpresaType>();
		
		/**
		 * Indexa os c�digos de empresa
		 */
		static{
			for(EmpresaType empresaType: EnumSet.allOf(EmpresaType.class)){
				EmpresaType.lookup.put(empresaType.getId(), empresaType);
			}
		}
		
		private final String id;
		
		EmpresaType(String id){
			this.id = id;
		}
		public final String getId() {
			return id;
		}
		
		public boolean equals(String id){
			return this.equals(EmpresaType.get(id));
		}
		
		public static EmpresaType get(String id){
			return EmpresaType.lookup.get(id);
		}
	}
}
