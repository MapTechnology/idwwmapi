package idw.model.rn.servemail;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwConsolid;
import idw.model.pojos.MsDetector;
import idw.model.pojos.MsTrigger;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.MsTpevtTemplate;
import idw.util.IdwLogger;

public abstract class ServicoEmailFactory extends ServicoEmailRN {
	
	private BigDecimal tpParametroLido;


	public abstract void tratarEnviarEmail(DwConsolid dwConsolid, MsTrigger msTrigger, OmPt ompt, List<OmUsr> listOmUsr);
	
	public ServicoEmailFactory(IdwLogger log, int idLog, int identacao, Session session) {
		super(log, idLog, identacao, session);
	}

	public enum TpEvt {
		FINAL_CICLO(MsTpevtTemplate.Type.FIM_CICLO.getId()),
		FINAL_SAIDA_PLANEJAMENTO(MsTpevtTemplate.Type.FINAL_SAIDA_PLANEJAMENTO.getId()) ,
		FINAL_TURNO(MsTpevtTemplate.Type.FINAL_TURNO.getId()),
		FINAL_HORA_CALENDARIO(MsTpevtTemplate.Type.FINAL_HORA_CALENDARIO.getId()) ,
		FINAL_HEART_BEAT(MsTpevtTemplate.Type.HEART_BEAT.getId()),
		ALERTA_PARAMETRO(MsTpevtTemplate.Type.PARAMETRO_MEDICAO.getId()),
		ALERTA_OFFLINE(MsTpevtTemplate.Type.MAQUINA_OFFLINE.getId()),
		OBS_PROCEDIMENTO(MsTpevtTemplate.Type.OBS_PROCEDIMENTO.getId()),
		PERDA_MATERIA_PRIMA(MsTpevtTemplate.Type.PERDA_MATERIA_PRIMA.getId());

		private final int typeID;

		private TpEvt(int typeID) {
			this.typeID = typeID;
		}

		public int getTypeID() {
			return this.typeID;
		}

		public static TpEvt getType(int typeID) {

			for (TpEvt type : TpEvt.values()) {
				if (type.getTypeID() == typeID) {
					return type;
				}
			}
			return null;
		}


	}

	public static ServicoEmailFactory getInstance(IdwLogger log, int idLog, int identacao, Session session, TpEvt tp) {
		switch (tp) {

		case FINAL_CICLO:
			return new ServicoEmailFinalCicloRN(log, idLog, identacao, session);

		case FINAL_HEART_BEAT:
			return new ServicoEmailHeartBeatRN(log, idLog, identacao, session);

		case FINAL_HORA_CALENDARIO:
			return new ServicoEmailFinalHoraRN(log, idLog, identacao, session);

		case FINAL_SAIDA_PLANEJAMENTO:
			return new ServicoEmailSaidaPlanejamentoRN(log,  idLog, identacao, session);

		case FINAL_TURNO:
			return new ServicoEmailFinalTurnoRN(log, idLog, identacao, session);
		
		case ALERTA_OFFLINE:
			return new ServicoEmailOfflineRN(log, idLog, identacao, session);
		
		case ALERTA_PARAMETRO:
			return new ServicoEmailAlertaParametroRN(log, idLog, identacao, session);
			
		case OBS_PROCEDIMENTO:
			return new ServicoEmailProcedimentoRN(log, idLog, identacao, session);
			
		case PERDA_MATERIA_PRIMA:
			return new ServicoEmailPerdaMateriaPrimaRN(log, idLog, identacao, session);
			
		default:
			break;
		}
		return null;
	}

	public void gerarAlerta(DwConsolid dwConsolid) {
		// Busca detectores
		List<MsDetector> listaMsDetector = this.loadDetectores();

		if (listaMsDetector != null) {
			for (MsDetector msDetector : listaMsDetector) {
				// Se estiver diferente de 1, indica que email n�o precisa ser
				// enviado
				if (msDetector.getIsEmail() != null && msDetector.getIsEmail()) {

					if (msDetector.getMsTriggers() != null) {
						List<OmUsr> listOmUsr =  this.getUsuariosParaEnviarEmail(msDetector);
						for (MsTrigger msTrigger : msDetector.getMsTriggers()) {
							if (dwConsolid != null) {
								log.info(idLog, identacao, "chamando tratarEnviarEmail");
								tratarEnviarEmail(dwConsolid, msTrigger, dwConsolid.getOmPt(), listOmUsr);
							}
						}
					}
				}
			}
		}
		
		// Marcar registro indicando que email foi enviado
		this.marcaDwConsolIdEmailEnviado(dwConsolid);
	}
	
	public BigDecimal getTpParametroLido() {
		return tpParametroLido;
	}

	public void setTpParametroLido(BigDecimal tpParametroLido) {
		this.tpParametroLido = tpParametroLido;
	}
	
}
