package idw.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import idw.model.IdwFacade;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwTurno;
import idw.model.pojos.template.AbstractTemplate;
import idw.model.pojos.template.DwCalsemTemplate;
import idw.model.rn.DataHoraRN;

@SuppressWarnings("serial")
public class TurnoAtualDTO extends AbstractTemplate<TurnoAtualDTO> implements Serializable {
	
	private long idTurno;
	private String cdTurno;
	private long idCal;
	private Date dtReferencia;
	private Date dtHrITurno;
	private Date dtHrFTurno;
	private BigDecimal dtHrIHora;
	private BigDecimal  dtHrFHora;
	private DwTurno dwturno;
	private BigDecimal segPosTolerancia;
	private BigDecimal segPreTolerancia;
	
	private BigDecimal segDuracaoProdutiva = BigDecimal.ZERO;
	private BigDecimal segDuracaoImprodutiva = BigDecimal.ZERO;
	
	private transient DwCal dwcal;
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("dia=").append(DwCalsemTemplate.DiaSemana.get(dtReferencia).getId())
			.append(" dtReferencia=").append(DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtReferencia))
			.append(" dtHrITurno=").append(DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtHrITurno))
			.append(" dtHrFTurno=").append(DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtHrFTurno))
			.append(" idTurno=").append(idTurno)
			.append(" cdTurno=").append(cdTurno)
			.append(" idCal=").append(idCal)
			.append(" segPreTolerancia=").append(segPreTolerancia.intValue())
			.append(" segPosTolerancia=").append(segPosTolerancia.intValue())
			.append(" tempoProdutivo=").append(getSegDuracaoProdutiva())
			.append(" tempoSemPeso=").append(getSegDuracaoImprodutiva());
		
		return sb.toString();
	}
	
	/**
	 * Diferen�a entre o in�cio e fim do turno, com o tempo de tolerancia
	 * @return
	 */
	public int tempoTotal(){
		
		return DataHoraRN.getQuantidadeSegundosNoPeriodo(this.getDtHrITurnoComTolerancia(), this.getDtHrFTurnoComTolerancia());
				
	}
	
	public DwCal getDwcal() {
		return dwcal;
	}
	public void setDwcal(DwCal dwcal) {
		this.dwcal = dwcal;
	}
	public DwTurno getDwturno() {
		return dwturno;
	}
	public void setDwturno(DwTurno dwturno) {
		this.dwturno = dwturno;
	}
	public long getIdTurno() {
		return idTurno;
	}
	public void setIdTurno(long idTurno) {
		this.idTurno = idTurno;
	}
	
	public String getCdTurno() {
		return cdTurno;
	}
	public void setCdTurno(String cdTurno) {
		this.cdTurno = cdTurno;
	}
	
	public long getIdCal() {
		return idCal;
	}
	public void setIdCal(long idCal) {
		this.idCal = idCal;
	}
	
	public Date getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	
	public Date getDtHrITurno() {
		return dtHrITurno;
	}
	public void setDtHrITurno(Date dtHrITurno) {
		this.dtHrITurno = dtHrITurno;
	}
	
	public Date getDtHrFTurno() {
		return dtHrFTurno;
	}
	public void setDtHrFTurno(Date dtHrFTurno) {
		this.dtHrFTurno = dtHrFTurno;
	}
	
	public BigDecimal getDtHrIHora() {
		return dtHrIHora;
	}
	public void setDtHrIHora(BigDecimal dtHrIHora) {
		this.dtHrIHora = dtHrIHora;
	}
	
	public BigDecimal getDtHrFHora() {
		return dtHrFHora;
	}
	public void setDtHrFHora(BigDecimal dtHrFHora) {
		this.dtHrFHora = dtHrFHora;
	}
	public BigDecimal getSegPosTolerancia() {
		return segPosTolerancia;
	}
	public void setSegPosTolerancia(BigDecimal segPosTolerancia) {
		this.segPosTolerancia = segPosTolerancia;
	}
	public Date getDtHrITurnoComTolerancia(){
		return DataHoraRN.adicionaSegundosNaData(dtHrITurno, (segPreTolerancia !=null ?  segPreTolerancia.negate().intValue() : 0));
	}
	public Date getDtHrFTurnoComTolerancia() {
		return DataHoraRN.adicionaSegundosNaData(dtHrFTurno, (segPosTolerancia != null ? segPosTolerancia.intValue() : 0));
	}
	public Date getDtHrFTurnoComPreTolerancia(){
		BigDecimal segAuto = IdwFacade.getInstancia().getConfiguracaoAtual().getSegAutologout();
		return DataHoraRN.adicionaSegundosNaData(dtHrFTurno, (segAuto != null ? segAuto.negate().intValue() : 0));
	}
	
	public BigDecimal getSegPreTolerancia() {
		return segPreTolerancia;
	}
	public void setSegPreTolerancia(BigDecimal segPreTolerancia) {
		this.segPreTolerancia = segPreTolerancia;
	}
	
	/**
	 * Prepara dto para a serializa��o, deixando carregado apenas os dados necess�rios
	 */
	public TurnoAtualDTO prepararSerializacao(){
		if(this.getDwcal() != null){
			this.setDwcal((DwCal) this.getDwcal().clone(false));
		}
		if(this.getDwturno() != null){
			this.setDwturno(this.getDwturno().clone(false));	
		}		
		return this;
	}

	
	public BigDecimal getSegDuracaoProdutiva() {
		return segDuracaoProdutiva;
	}

	public void setSegDuracaoProdutiva(BigDecimal segDuracaoProdutiva) {
		this.segDuracaoProdutiva = segDuracaoProdutiva;
	}

	public BigDecimal getSegDuracaoImprodutiva() {
		return segDuracaoImprodutiva;
	}

	public void setSegDuracaoImprodutiva(BigDecimal segDuracaoImprodutiva) {
		this.segDuracaoImprodutiva = segDuracaoImprodutiva;
	}

	@Override
	protected TurnoAtualDTO atribuir(TurnoAtualDTO from, TurnoAtualDTO to, boolean isCopiarFK) {
		TurnoAtualDTO clone = new TurnoAtualDTO();
		clone.setIdTurno(idTurno);
		clone.setCdTurno(cdTurno);
		clone.setIdCal(idCal);
		clone.setDtReferencia(dtReferencia);
		clone.setDtHrITurno(dtHrITurno);
		clone.setDtHrFTurno(dtHrFTurno);
		clone.setDtHrIHora(dtHrIHora);
		clone.setDtHrFHora(dtHrFHora);		
		clone.setSegPosTolerancia(segPosTolerancia);
		clone.setSegPreTolerancia(segPreTolerancia);
		clone.setSegDuracaoImprodutiva(segDuracaoImprodutiva);
		clone.setSegDuracaoProdutiva(segDuracaoProdutiva);
		
		if(isCopiarFK){
			clone.setDwturno(dwturno.clone(false));
			clone.setDwcal((DwCal) dwcal.clone());
		}
		
		return clone;
	}
}
