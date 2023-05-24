package idw.model.pojos.template;


import java.math.BigDecimal;

import idw.model.pojos.MsTpevt;
import ms.model.APojoMs;

public abstract class MsTpevtTemplate extends APojoMs<MsTpevt> {
	public enum Type {
		INICIO_CICLO(1, "-ciclo.log"),
		FIM_CICLO(2, "-ciclo.log"),
		INICIO_PARADA(3, "-parada.log"),
		FIM_PARADA(4, "-parada.log"),
		INICIO_ALERTA(5, "-alerta.log"),
		FIM_ALERTA(6, "-alerta.log"),
		INICIO_LOGIN(7, "-login.log"),
		FIM_LOGIN(8, "-login.log"),
		MOTIVO_PARADA(9, "-parada.log"),
		MOTIVO_REFUGO(10, "-refugo.log"),
		SOLICITACAO_CONSULTA(11, "-consulta.log"),
		FINAL_SAIDA_PLANEJAMENTO(12, "-planejamento.log"),
		ENTRADA_PLANEJAMENTO(13, "-planejamento.log"),
		INICIO_TURNO(14, "-turno.log"),
		FINAL_TURNO(15, "-turno.log"),
		INICIO_HORA_CALENDARIO(16, "-turno.log"),
		FINAL_HORA_CALENDARIO(17, "-turno.log"), 
		HEART_BEAT(18, "-heartbeat.log"),
		SEM_FOLHA_PROCESSO(19, ""),
		CANCELAMENTO_REFUGO(20, "-refugo.log"), //verificar esse valor, pois no banco da semp esta com ID 101
		PARAMETRO_MEDICAO(21, "-parametromedicao.log"),
		MAQUINA_OFFLINE(22, "-heartbeat.log"),
		MAQUINA_ONLINE(23, "-heartbeat.log"),
		PERDA_MATERIA_PRIMA(24, "-erro_insersora.log"),
		OBS_PROCEDIMENTO(25, "-heartbeat.log"),
		PASSAGEM(26, "-heartbeat.log"),
		INICIO_CIP(27, "-cip.log"),
		FIM_CIP(28, "-cip.log"),
		INICIA_VARRITMO(29, "-varritmo.log"),
		MOTIVO_VARRITMO(30, "-varritmo.log"),
		FIM_VARRITMO(31, "-varritmo.log");
		
		private final int id;
		private final String sufixoLog;

		private Type(int id, String sufixo) {
			this.id = id;
			this.sufixoLog = sufixo;
		}

		public int getId() {
			return this.id;
		}
		
		public Long getIdLong() {
			return Long.valueOf(this.id);
		}
		
		public String getSufixolog() {
			return this.sufixoLog;
		}

		public static Type getType(int id) {
			for (Type type : Type.values()){
				if (type.getId() == id){
					return type;
				}
			}
			return null;
		}
		
		public boolean equals(Integer id){
			return this.id == id.intValue();
		}
		
		public boolean equals(Long id){
			return this.id == id.longValue();
		}		
	}
	
	public Type getType(){
		MsTpevt msTpevt = (MsTpevt) this;
		if(msTpevt.getIdTpevt() != null){
			return Type.getType(msTpevt.getIdTpevt().intValue());
		}
		return null;
	}
	
	@Override
	protected MsTpevt atribuir(MsTpevt from, MsTpevt to, boolean isCopiarFK) {

		if (to == null)
			to = new MsTpevt();

		to.setDsTpevt(from.getDsTpevt());
		if (from.getDeparaPdba() != null) {
			to.setDeparaPdba(new BigDecimal(from.getDeparaPdba().doubleValue()));
		}
		if (from.getIdTpevt() != null) {
			to.setIdTpevt(from.getIdTpevt());
		}

		if (isCopiarFK) {
			/* Alessandre: removi em 12-6-13 o clone abaixo pois esta dando out-of-mmeory
			 * e nao faz sentido clonar os msevt qdo se clona o mstpevt
			if (from.getMsEvts() != null) {
				Set<MsEvt> listaMsEvt = new HashSet<MsEvt>();
				for (MsEvt msEvt : from.getMsEvts()) {
					listaMsEvt.add(msEvt.clone(false));
				}
				to.setMsEvts(listaMsEvt);
			}
			 */

			
			/* Alessandre: Como eu trouxe esse template do projeto idw, tive que comentar esse trecho
			if (from.getMsTriggers() != null) {
				Set<MsTrigger> listaMsTriggers = new HashSet<MsTrigger>();
				for (MsTrigger msTrigger : from.getMsTriggers()) {
					listaMsTriggers.add(msTrigger.clone(false));
				}
				to.setMsTriggers(listaMsTriggers);
			}*/
		}

		return to;
	}

}
