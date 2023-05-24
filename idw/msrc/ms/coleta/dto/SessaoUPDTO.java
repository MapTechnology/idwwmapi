package ms.coleta.dto;

public class SessaoUPDTO {
	private SessaoOPDTO opDTO;
	private SessaoUsuariosDTO usuarios;
	private SessaoAlertasDTO alertas;
	private SessaoParadaDTO parada;
	private SessaoRefugoDTO refugo;
	private SessaoVarRitmoDTO varRitmo;
	
	private long idPt;
	
	private long revisaoPt;
	private String cdPt = "";
	private long idTppt;
	private long idGt;
	private String dsGt = "";
	private long ultimaFolha;
	private String dsSessao = "";
	private Byte tpSessao;
	private boolean isCipHabilitado;
	private boolean isVarRitmoHabilitado;
	private float toleranciaVarRitmo;
	private int debounceVarRitmo;
	private boolean isParadaFechaCiclo;
	
	private SessaoCalendarioDTO calendario;

	public SessaoOPDTO getOpDTO() {
		return opDTO;
	}

	public void setOpDTO(SessaoOPDTO opDTO) {
		this.opDTO = opDTO;
	}

	public SessaoUsuariosDTO getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(SessaoUsuariosDTO usuarios) {
		this.usuarios = usuarios;
	}

	public SessaoParadaDTO getParada() {
		return parada;
	}

	public void setParada(SessaoParadaDTO parada) {
		this.parada = parada;
	}

	public SessaoRefugoDTO getRefugo() {
		return refugo;
	}

	public void setRefugo(SessaoRefugoDTO refugo) {
		this.refugo = refugo;
	}

	public SessaoVarRitmoDTO getVarRitmo() {
		return varRitmo;
	}

	public void setVarRitmo(SessaoVarRitmoDTO varRitmo) {
		this.varRitmo = varRitmo;
	}

	public long getIdPt() {
		return idPt;
	}

	public void setIdPt(long idPt) {
		this.idPt = idPt;
	}

	public String getCdPt() {
		return cdPt;
	}

	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}

	public long getIdTppt() {
		return idTppt;
	}

	public void setIdTppt(long idTppt) {
		this.idTppt = idTppt;
	}

	public long getIdGt() {
		return idGt;
	}

	public void setIdGt(long idGt) {
		this.idGt = idGt;
	}

	public String getDsGt() {
		return dsGt;
	}

	public void setDsGt(String dsGt) {
		this.dsGt = dsGt;
	}

	public long getUltimaFolha() {
		return ultimaFolha;
	}

	public void setUltimaFolha(long ultimaFolha) {
		this.ultimaFolha = ultimaFolha;
	}

	public String getDsSessao() {
		return dsSessao;
	}

	public void setDsSessao(String dsSessao) {
		this.dsSessao = dsSessao;
	}

	public Byte getTpSessao() {
		return tpSessao;
	}

	public void setTpSessao(Byte tpSessao) {
		this.tpSessao = tpSessao;
	}

	public boolean isCipHabilitado() {
		return isCipHabilitado;
	}

	public void setCipHabilitado(boolean isCipHabilitado) {
		this.isCipHabilitado = isCipHabilitado;
	}

	public boolean isVarRitmoHabilitado() {
		return isVarRitmoHabilitado;
	}

	public void setVarRitmoHabilitado(boolean isVarRitmoHabilitado) {
		this.isVarRitmoHabilitado = isVarRitmoHabilitado;
	}

	public int getDebounceVarRitmo() {
		return debounceVarRitmo;
	}

	public void setDebounceVarRitmo(int debounceVarRitmo) {
		this.debounceVarRitmo = debounceVarRitmo;
	}

	public float getToleranciaVarRitmo() {
		return toleranciaVarRitmo;
	}

	public void setToleranciaVarRitmo(float toleranciaVarRitmo) {
		this.toleranciaVarRitmo = toleranciaVarRitmo;
	}

	public SessaoCalendarioDTO getCalendario() {
		return calendario;
	}

	public void setCalendario(SessaoCalendarioDTO calendario) {
		this.calendario = calendario;
	}

	public SessaoAlertasDTO getAlertas() {
		return alertas;
	}

	public void setAlertas(SessaoAlertasDTO alertas) {
		this.alertas = alertas;
	}

	public long getRevisaoPt() {
		return revisaoPt;
	}

	public void setRevisaoPt(long revisaoPt) {
		this.revisaoPt = revisaoPt;
	}

	public boolean isParadaFechaCiclo() {
		return isParadaFechaCiclo;
	}

	public void setParadaFechaCiclo(boolean isParadaFechaCiclo) {
		this.isParadaFechaCiclo = isParadaFechaCiclo;
	}
	
}
