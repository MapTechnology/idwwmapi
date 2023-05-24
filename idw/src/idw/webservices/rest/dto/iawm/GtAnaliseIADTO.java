package idw.webservices.rest.dto.iawm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 

public class GtAnaliseIADTO {
	private String cdGt;
	private String dtReferencia;
	private Long cdTurno;
	private String dsTurno;
	private BigDecimal cicloMedioMedio = BigDecimal.ZERO;
	private BigDecimal cicloPadraoMedio = BigDecimal.ZERO;
	private TotaisAnaliseIADTO totaisGt = new TotaisAnaliseIADTO();
	private boolean oeeNaMeta = false;
	private boolean ritmoNaMeta = false;
	private boolean dispNaMeta = false;
	private boolean refugoNaMeta = false; 
	private MetasIADTO metasEC;
	private MetasIADTO metasOEE;
	private MetasIADTO metasDisp;
	private MetasIADTO metasRitmo;
	private MetasIADTO metasRefugo;
	private List<PtAnaliseIADTO> pts = new ArrayList<PtAnaliseIADTO>();
	private MaiorPerdaMPWMDTO maiorPerdaMP = new MaiorPerdaMPWMDTO();
	private MaiorParadaWMDTO maiorParada = new MaiorParadaWMDTO();
	private MaiorRefugoWMDTO maiorRefugo = new MaiorRefugoWMDTO();
	private List<Long> idsAnalise = new ArrayList<Long>();
	
	
	public String getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(String dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public Long getCdTurno() {
		return cdTurno;
	}
	public void setCdTurno(Long cdTurno) {
		this.cdTurno = cdTurno;
	}
	public String getDsTurno() {
		return dsTurno;
	}
	public void setDsTurno(String dsTurno) {
		this.dsTurno = dsTurno;
	}
	public List<Long> getIdsAnalise() {
		return idsAnalise;
	}
	public void setIdsAnalise(List<Long> idsAnalise) {
		this.idsAnalise = idsAnalise;
	}
	public String getCdGt() {
		return cdGt;
	}
	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
	}
	public BigDecimal getCicloMedioMedio() {
		return cicloMedioMedio;
	}
	public void setCicloMedioMedio(BigDecimal cicloMedioMedio) {
		this.cicloMedioMedio = cicloMedioMedio;
	}
	public BigDecimal getCicloPadraoMedio() {
		return cicloPadraoMedio;
	}
	public void setCicloPadraoMedio(BigDecimal cicloPadraoMedio) {
		this.cicloPadraoMedio = cicloPadraoMedio;
	}
	public TotaisAnaliseIADTO getTotaisGt() {
		return totaisGt;
	}
	public void setTotaisGt(TotaisAnaliseIADTO totaisGt) {
		this.totaisGt = totaisGt;
	}
	public boolean isOeeNaMeta() {
		return oeeNaMeta;
	}
	public void setOeeNaMeta(boolean oeeNaMeta) {
		this.oeeNaMeta = oeeNaMeta;
	}
	public boolean isRitmoNaMeta() {
		return ritmoNaMeta;
	}
	public void setRitmoNaMeta(boolean ritmoNaMeta) {
		this.ritmoNaMeta = ritmoNaMeta;
	}
	public boolean isDispNaMeta() {
		return dispNaMeta;
	}
	public void setDispNaMeta(boolean dispNaMeta) {
		this.dispNaMeta = dispNaMeta;
	}
	public boolean isRefugoNaMeta() {
		return refugoNaMeta;
	}
	public void setRefugoNaMeta(boolean refugoNaMeta) {
		this.refugoNaMeta = refugoNaMeta;
	}
	public MetasIADTO getMetasEC() {
		return metasEC;
	}
	public void setMetasEC(MetasIADTO metasEC) {
		this.metasEC = metasEC;
	}
	public MetasIADTO getMetasOEE() {
		return metasOEE;
	}
	public void setMetasOEE(MetasIADTO metasOEE) {
		this.metasOEE = metasOEE;
	}
	public MetasIADTO getMetasDisp() {
		return metasDisp;
	}
	public void setMetasDisp(MetasIADTO metasDisp) {
		this.metasDisp = metasDisp;
	}
	public MetasIADTO getMetasRitmo() {
		return metasRitmo;
	}
	public void setMetasRitmo(MetasIADTO metasRitmo) {
		this.metasRitmo = metasRitmo;
	}
	public MetasIADTO getMetasRefugo() {
		return metasRefugo;
	}
	public void setMetasRefugo(MetasIADTO metasRefugo) {
		this.metasRefugo = metasRefugo;
	}
	public List<PtAnaliseIADTO> getPts() {
		return pts;
	}
	public void setPts(List<PtAnaliseIADTO> pts) {
		this.pts = pts;
	}
	public MaiorPerdaMPWMDTO getMaiorPerdaMP() {
		return maiorPerdaMP;
	}
	public void setMaiorPerdaMP(MaiorPerdaMPWMDTO maiorPerdaMP) {
		this.maiorPerdaMP = maiorPerdaMP;
	}
	public MaiorParadaWMDTO getMaiorParada() {
		return maiorParada;
	}
	public void setMaiorParada(MaiorParadaWMDTO maiorParada) {
		this.maiorParada = maiorParada;
	}
	public MaiorRefugoWMDTO getMaiorRefugo() {
		return maiorRefugo;
	}
	public void setMaiorRefugo(MaiorRefugoWMDTO maiorRefugo) {
		this.maiorRefugo = maiorRefugo;
	}
	
	
}
