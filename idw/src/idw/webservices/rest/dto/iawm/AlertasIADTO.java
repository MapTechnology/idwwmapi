package idw.webservices.rest.dto.iawm;

public class AlertasIADTO {
	private GtAnaliseIADTO dadosAnaliseGT;
	private boolean gerarAlertaRitmoSuper;
	private boolean gerarAlertaRitmo;
	private boolean gerarAlertaPerdaMP;
	private boolean gerarAlertaParada;
	private boolean gerarAlertaRefugo;
	
	public GtAnaliseIADTO getDadosAnaliseGT() {
		return dadosAnaliseGT;
	}
	public void setDadosAnaliseGT(GtAnaliseIADTO dadosAnaliseGT) {
		this.dadosAnaliseGT = dadosAnaliseGT;
	}
	public boolean isGerarAlertaRitmo() {
		return gerarAlertaRitmo;
	}
	public void setGerarAlertaRitmo(boolean gerarAlertaRitmo) {
		this.gerarAlertaRitmo = gerarAlertaRitmo;
	}
	public boolean isGerarAlertaPerdaMP() {
		return gerarAlertaPerdaMP;
	}
	public void setGerarAlertaPerdaMP(boolean gerarAlertaPerdaMP) {
		this.gerarAlertaPerdaMP = gerarAlertaPerdaMP;
	}
	public boolean isGerarAlertaParada() {
		return gerarAlertaParada;
	}
	public void setGerarAlertaParada(boolean gerarAlertaParada) {
		this.gerarAlertaParada = gerarAlertaParada;
	}
	public boolean isGerarAlertaRefugo() {
		return gerarAlertaRefugo;
	}
	public void setGerarAlertaRefugo(boolean gerarAlertaRefugo) {
		this.gerarAlertaRefugo = gerarAlertaRefugo;
	}
	public boolean isGerarAlertaRitmoSuper() {
		return gerarAlertaRitmoSuper;
	}
	public void setGerarAlertaRitmoSuper(boolean gerarAlertaRitmoSuper) {
		this.gerarAlertaRitmoSuper = gerarAlertaRitmoSuper;
	}
	
	
}
