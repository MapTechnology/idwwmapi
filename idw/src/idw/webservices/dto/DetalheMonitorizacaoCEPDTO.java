package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class DetalheMonitorizacaoCEPDTO 
{
	private Date dthrIni;
	private Date dthrFim;
	private String cdTurno;
	private String dsTurno;
	private Date dtTurno;
	
	private Byte tpReferencia;
	private Long idFtParam;
	private String dsParamentro;	
	private String cdFtGrupo;
	private String dsFtGrupo;
    private BigDecimal vlMinimo;
    private BigDecimal vlMaximo;
    private BigDecimal vlMedio;
    private BigDecimal vlSomado;
    private Integer qtMedicoes;    
	private BigDecimal vlMonetario; 
	private FolhaCEPDTO folhaCEPSemListas;
    private List<DetalheMonitorizacaoCEPOcorrDTO> listaOcorrencias;
    
    private Byte zona;
    
    private BigDecimal vlUltimo;
    
	public Date getDthrIni() {
		return dthrIni;
	}
	public void setDthrIni(Date dthrIni) {
		this.dthrIni = dthrIni;
	}
	public Date getDthrFim() {
		return dthrFim;
	}
	public void setDthrFim(Date dthrFim) {
		this.dthrFim = dthrFim;
	}
	public String getCdTurno() {
		return cdTurno;
	}
	public void setCdTurno(String cdTurno) {
		this.cdTurno = cdTurno;
	}
	public String getDsTurno() {
		return dsTurno;
	}
	public void setDsTurno(String dsTurno) {
		this.dsTurno = dsTurno;
	}
	public Date getDtTurno() {
		return dtTurno;
	}
	public void setDtTurno(Date dtTurno) {
		this.dtTurno = dtTurno;
	}
	public Byte getTpReferencia() {
		return tpReferencia;
	}
	public void setTpReferencia(Byte tpReferencia) {
		this.tpReferencia = tpReferencia;
	}
	public Long getIdFtParam() {
		return idFtParam;
	}
	public void setIdFtParam(Long idFtParam) {
		this.idFtParam = idFtParam;
	}
	public String getDsParamentro() {
		return dsParamentro;
	}
	public void setDsParamentro(String dsParamentro) {
		this.dsParamentro = dsParamentro;
	}
	public String getCdFtGrupo() {
		return cdFtGrupo;
	}
	public void setCdFtGrupo(String cdFtGrupo) {
		this.cdFtGrupo = cdFtGrupo;
	}
	public String getDsFtGrupo() {
		return dsFtGrupo;
	}
	public void setDsFtGrupo(String dsFtGrupo) {
		this.dsFtGrupo = dsFtGrupo;
	}
	public BigDecimal getVlMinimo() {
		return vlMinimo;
	}
	public void setVlMinimo(BigDecimal vlMinimo) {
		this.vlMinimo = vlMinimo;
	}
	public BigDecimal getVlMaximo() {
		return vlMaximo;
	}
	public void setVlMaximo(BigDecimal vlMaximo) {
		this.vlMaximo = vlMaximo;
	}
	public BigDecimal getVlMedio() {
		return vlMedio;
	}
	public void setVlMedio(BigDecimal vlMedio) {
		this.vlMedio = vlMedio;
	}
	public BigDecimal getVlSomado() {
		return vlSomado;
	}
	public void setVlSomado(BigDecimal vlSomado) {
		this.vlSomado = vlSomado;
	}
	public Integer getQtMedicoes() {
		return qtMedicoes;
	}
	public void setQtMedicoes(Integer qtMedicoes) {
		this.qtMedicoes = qtMedicoes;
	}
	public BigDecimal getVlMonetario() {
		return vlMonetario;
	}
	public void setVlMonetario(BigDecimal vlMonetario) {
		this.vlMonetario = vlMonetario;
	}
	
	public FolhaCEPDTO getFolhaCEPSemListas() {
		return folhaCEPSemListas;
	}
	public void setFolhaCEPSemListas(FolhaCEPDTO folhaCEPSemListas) {
		this.folhaCEPSemListas = folhaCEPSemListas;
	}
	public List<DetalheMonitorizacaoCEPOcorrDTO> getListaOcorrencias() {
		return listaOcorrencias;
	}
	public void setListaOcorrencias(
			List<DetalheMonitorizacaoCEPOcorrDTO> listaOcorrencias) {
		this.listaOcorrencias = listaOcorrencias;
	}
	public Byte getZona() {
		return zona;
	}
	public void setZona(Byte zona) {
		this.zona = zona;
	}
	
	public BigDecimal getVlUltimo() {
		return vlUltimo;
	}
	public void setVlUltimo(BigDecimal vlUltimo) {
		this.vlUltimo = vlUltimo;
	}
	
}
