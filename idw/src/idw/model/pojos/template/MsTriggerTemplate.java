package idw.model.pojos.template;

import java.math.BigDecimal;

import idw.model.AbstractPojoMs;
import idw.model.pojos.MsTrigger;

public abstract class MsTriggerTemplate extends AbstractPojoMs<MsTrigger> {
	
	public enum Type {
		PRODUCAO_BRUTA_PERCENTUAL(1), 
		EFICIENCIA_CICLO_MEDIO(4), 
		EFICIENCIA_ULTIMOS_CICLOS(5), 
		GARGALO(6),
		PROGRAMA_MAQUINA(7),
		CHEGADA_MATERIA_PRIMA(8),
		MUDANCA_ESTRUTURA_PROGRAMA_IAC(9),		
		DATA_ENTREGA_CLIENTE_INVIAVEL(10),
		FOLHA_DESCONHECIDA(11),
		ALERTA_TEMPERATURA(12),
		ALERTA_SEMCONEXAO(13),
		OBS_PROCEDIMENTO(25);

		private final int typeID;

		private Type(int typeID) {
			this.typeID = typeID;
		}

		public int getTypeID() {
			return this.typeID;
		}

		public static Type getType(int typeID) {
			for (Type type : Type.values()){
				if (type.getTypeID() == typeID){
					return type;
				}
			}
			return null;
		}

	}
	
	public enum TypeOperadorLogico {
		IGUAL(0) {
			@Override
			public String getDescricao() {
				return "igual";
			}
		}, 
		DIFERENTE(1) {
			@Override
			public String getDescricao() {
				return "diferente";
			}
		}, 
		MAIOR(2) {
			@Override
			public String getDescricao() {
				return "maior";
			}
		}, 
		MAIOR_IGUAL(3) {
			@Override
			public String getDescricao() {
				return "maior igual";
			}
		},
		MENOR(4) {
			@Override
			public String getDescricao() {
				return "menor";
			}
		},
		MENOR_IGUAL(5) {
			@Override
			public String getDescricao() {
				return "menor igual";
			}
		};

		private final int typeID;

		private TypeOperadorLogico(int typeID) {
			this.typeID = typeID;
		}

		public int getTypeID() {
			return this.typeID;
		}

		public static TypeOperadorLogico getType(int typeID) {
			for (TypeOperadorLogico type : TypeOperadorLogico.values()){
				if (type.getTypeID() == typeID){
					return type;
				}
			}
			return null;
		}
		
		public abstract String getDescricao();

	}	
	
	public Type getType(){
		MsTrigger msTrigger = (MsTrigger) this;
		if(msTrigger.getMsInd() != null){
			return Type.getType(msTrigger.getMsInd().getIdInd().intValue());
		}
		return null;
	}
	
	public TypeOperadorLogico getTypeOperadorLogico(){
		MsTrigger msTrigger = (MsTrigger) this;
		if(msTrigger.getOperadorlogico() != null){
			return TypeOperadorLogico.getType(msTrigger.getOperadorlogico().intValue());
		}
		return null;
	}
	
	@Override
	protected MsTrigger atribuir(MsTrigger from, MsTrigger to,
			boolean isCopiarFK) {
		
		if (to == null)
			to = new MsTrigger();
		
		
		
		if(from.getIdTrigger() != null){
			to.setIdTrigger(new BigDecimal(from.getIdTrigger().longValue()));
		}
		
		if(from.getOperadorlogico() != null){
			to.setOperadorlogico(new BigDecimal(from.getOperadorlogico().intValue()));
		}
		
		if(from.getOrdem() != null){
			to.setOrdem(new BigDecimal(from.getOrdem().intValue()));
		}
		
		if(from.getQtCiclos() != null){
			to.setQtCiclos(new BigDecimal(from.getQtCiclos().intValue()));
		}
		
		if(from.getVlInd() != null){
			to.setVlInd(new BigDecimal(from.getVlInd().doubleValue()));
		}						
		
		if(isCopiarFK){
			if(from.getMsDetector() != null){
				to.setMsDetector(from.getMsDetector().clone(false));
			}
			if(from.getMsInd() != null){
				to.setMsInd(from.getMsInd().clone(false));
			}
			if(from.getMsTpevt() != null){
				to.setMsTpevt(from.getMsTpevt().clone(false));
			}
			if(from.getOmPt() != null){
				to.setOmPt(from.getOmPt().clone(false));
			}
			if(from.getOmTppt() != null){
				to.setOmTppt(from.getOmTppt().clone(false));
			}
		}
		
		return to;
	}

}
