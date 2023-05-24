package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;

import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwRt;
import idw.model.pojos.DwRtcic;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;

public abstract class DwRtTemplate extends AbstractTemplate<DwRt> {
	public enum StFuncionamento {
		PARADA((byte) 0), PRODUZINDO((byte) 1);
		private final byte id;

		private StFuncionamento(final byte id) {
			this.id = id;
		}

		public byte getId() {
			return this.id;
		}
	}

	public void setDefaultValues() {
		DwRt dwRt = (DwRt) this;

		dwRt.setIsAlerta(false);
		dwRt.setIsCip(false);
		dwRt.setIsManutencaopre(false);
		dwRt.setIsConforme(false);
		dwRt.setIsOperador(false);
		dwRt.setIsParadafechaciclo(null);
		dwRt.setIsParadapeso(false);
		dwRt.setIsRegulagem(false);
		dwRt.setIsSemplanejamento(false);
		dwRt.setIsVidautilmolde(false);
		dwRt.setStQualidade((byte) 0);
		dwRt.setStFuncionamento(StFuncionamento.PRODUZINDO.getId());
		dwRt.setDthrIciclo(null);
		dwRt.setMsDthriciclo(0);
		dwRt.setSegParadaparcial(new BigDecimal(0));
		dwRt.setOrdemCiclos(0);
		dwRt.setSegCiclopadraominimo(new BigDecimal(0));
		dwRt.setSegUltimociclo(new BigDecimal(0));
		dwRt.setPcsProducaoplanejadaOp(new BigDecimal(0));
		dwRt.setPcsProducaoliquidaOp(new BigDecimal(0));
		dwRt.setIdRt(0l);
		dwRt.setIsOffline(false);
	}

	@Override
	protected DwRt atribuir(DwRt from, DwRt to, boolean isCopiarFK) {

		if (to == null) {
			to = new DwRt();
		}

		to.setIdRt(from.getIdRt());
		to.setIdRtbase(from.getIdRtbase());

		if (from.getIsSemplanejamento() != null) {
			to.setIsSemplanejamento(from.getIsSemplanejamento().booleanValue());
		}

		if (from.getIsOperador() != null) {
			to.setIsOperador(from.getIsOperador().booleanValue());
		}

		if (from.getStFuncionamento() != null) {
			to.setStFuncionamento(from.getStFuncionamento());
		}

		if (from.getIsManutencaopre() != null) {
			to.setIsManutencaopre(from.getIsManutencaopre().booleanValue());
		}

		if (from.getIsVidautilmolde() != null) {
			to.setIsVidautilmolde(from.getIsVidautilmolde().booleanValue());
		}

		if (from.getStQualidade() != null) {
			to.setStQualidade(from.getStQualidade());
		}

		if (from.getIsParadapeso() != null) {
			to.setIsParadapeso(from.getIsParadapeso().booleanValue());
		}

		if (from.getIsOffline() != null) {
			to.setIsOffline(from.getIsOffline().booleanValue());
		}

		if (from.getDthrIciclo() != null) {
			to.setDthrIciclo((Date) from.getDthrIciclo().clone());
		}

		if (from.getMsDthriciclo() != null) {
			to.setMsDthriciclo(from.getMsDthriciclo().intValue());
		}

		if (from.getSegParadaparcial() != null) {
			to.setSegParadaparcial(new BigDecimal(from.getSegParadaparcial().doubleValue()));
		}

		if (from.getOrdemCiclos() != null) {
			to.setOrdemCiclos(from.getOrdemCiclos().intValue());
		}

		if (from.getIsRegulagem() != null) {
			to.setIsRegulagem(from.getIsRegulagem().booleanValue());
		}

		if (from.getIsParadafechaciclo() != null) {
			to.setIsParadafechaciclo(from.getIsParadafechaciclo().booleanValue());
		}

		if (from.getSegCiclopadraominimo() != null) {
			to.setSegCiclopadraominimo(new BigDecimal(from.getSegCiclopadraominimo().doubleValue()));
		}

		if (from.getSegUltimociclo() != null) {
			to.setSegUltimociclo(new BigDecimal(from.getSegUltimociclo().doubleValue()));
		}

		if (from.getPcsProducaoplanejadaOp() != null) {
			to.setPcsProducaoplanejadaOp(new BigDecimal(from.getPcsProducaoplanejadaOp().doubleValue()));
		}

		if (from.getPcsProducaoliquidaOp() != null) {
			to.setPcsProducaoliquidaOp(new BigDecimal(from.getPcsProducaoliquidaOp().doubleValue()));
		}

		if (from.getDtReferencia() != null) {
			to.setDtReferencia((Date) from.getDtReferencia());
		}

		if (from.getDthrHeartbeat() != null) {
			to.setDthrHeartbeat((Date) from.getDthrHeartbeat().clone());
		}
		
		if (from.getDthrCadastro() != null) {
			to.setDthrCadastro(from.getDthrCadastro());
		}

		if (from.getIsConforme() != null) {
			to.setIsConforme(from.getIsConforme().booleanValue());
		}

		if (from.getOmPt() != null) {
			if (isCopiarFK) {
				to.setOmPt(from.getOmPt().clone());
			} else {
				to.setOmPt(new OmPt());
				to.getOmPt().setIdPt(from.getOmPt().getIdPt());
			}
		}

		if (from.getDwTurno() != null) {
			if (isCopiarFK) {
				to.setDwTurno((DwTurno) from.getDwTurno().clone());
			} else {
				to.setDwTurno(new DwTurno());
				to.getDwTurno().setIdTurno(from.getDwTurno().getIdTurno());
			}

		}

		if (from.getDwConsolpalog() != null) {
			if (isCopiarFK) {
				to.setDwConsolpalog(from.getDwConsolpalog().clone());

			} else {
				to.setDwConsolpalog(new DwConsolpalog());
				to.getDwConsolpalog().setIdConsolpalog(from.getDwConsolpalog().getIdConsolpalog());

			}
		}
		if (from.getPpCp() != null) {
			if (isCopiarFK) {
				to.setPpCp(from.getPpCp().clone(false));
			} else {
				to.setPpCp(new PpCp());
				to.getPpCp().setIdCp(from.getPpCp().getIdCp());
			}
		}

		if (isCopiarFK) {
			if (from.getDwRtcics() != null) {
				to.setDwRtcics(new HashSet<DwRtcic>());

				for (DwRtcic dwrtcic : from.getDwRtcics()) {
					to.getDwRtcics().add(dwrtcic.clone());
				}
			}

		}

		return to;
	}

	@Override
	public String toString() {
		DwRt dwRt = (DwRt) this;
		StringBuilder formatado = new StringBuilder();

		formatado.append("idRt=").append(dwRt.getIdRt()).append("\n");
		formatado.append("dthrHeartbeat=").append(dwRt.getDthrHeartbeat()).append("\n");
		formatado.append("dthrCadastro=").append(dwRt.getDthrCadastro()).append("\n");
		formatado.append("dtReferencia=").append(dwRt.getDtReferencia()).append("\n");

		formatado.append("ultTemperaturaLida=").append(dwRt.getUlttemperaturalida()).append("\n");
		formatado.append("segUltimociclo=").append(dwRt.getSegUltimociclo()).append("\n");

		formatado.append("isAlerta=").append(dwRt.getIsAlerta()).append("\n");
		formatado.append("isCip=").append(dwRt.getIsCip()).append("\n");
		formatado.append("isManutencaopre=").append(dwRt.getIsManutencaopre()).append("\n");
		formatado.append("isConforme=").append(dwRt.getIsConforme()).append("\n");
		formatado.append("isOperador=").append(dwRt.getIsOperador()).append("\n");
		formatado.append("isPAradafechaciclo=").append(dwRt.getIsParadafechaciclo()).append("\n");
		formatado.append("isParadapeso=").append(dwRt.getIsParadapeso()).append("\n");
		formatado.append("isRegulagem=").append(dwRt.getIsRegulagem()).append("\n");
		formatado.append("isSemplanejamento=").append(dwRt.getIsSemplanejamento()).append("\n");
		formatado.append("isVidautilmolde=").append(dwRt.getIsVidautilmolde()).append("\n");
		formatado.append("stQualidade=").append(dwRt.getStQualidade()).append("\n");
		formatado.append("stFuncionamento=").append(dwRt.getStFuncionamento()).append("\n");
		formatado.append("dthrIciclo=").append(dwRt.getDthrIciclo()).append("\n");
		formatado.append("msDthriciclo=").append(dwRt.getMsDthriciclo()).append("\n");
		formatado.append("segParadaparcial=").append(dwRt.getSegParadaparcial()).append("\n");
		formatado.append("ordemciclos=").append(dwRt.getOrdemCiclos()).append("\n");
		formatado.append("segCiclopadraominimo=").append(dwRt.getSegCiclopadraominimo()).append("\n");
		formatado.append("segUltimoCiclo=").append(dwRt.getSegUltimociclo()).append("\n");
		formatado.append("pcsProducaoPlanejadaOp=").append(dwRt.getPcsProducaoplanejadaOp()).append("\n");
		formatado.append("pcsProducaoLiquidaOp=").append(dwRt.getPcsProducaoliquidaOp()).append("\n");
		formatado.append("isOffline=").append(dwRt.getIsOffline()).append("\n");
		
		return formatado.toString();
	}
}