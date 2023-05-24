package idw.webservices.dto;

import java.util.Date;

public class ResultadoMedicaoDTO {
	private Date dthrMedicao;
	private double vlcorrente;
	private int fluxoe; //0- sem fluxo 1-comfluxo
	private int fluxos;
	private double tensao;
	private boolean isMedicaoPosFalha;
	private int ordemSubetapa;
	private boolean transdutorDePecisao;
	
	public boolean isTransdutorDePecisao() {
		return transdutorDePecisao;
	}
	public void setTransdutorDePecisao(boolean transdutorDePecisao) {
		this.transdutorDePecisao = transdutorDePecisao;
	}
	public int getOrdemSubetapa() {
		return ordemSubetapa;
	}
	public void setOrdemSubetapa(int ordemSubetapa) {
		this.ordemSubetapa = ordemSubetapa;
	}
	public boolean isMedicaoPosFalha() {
		return isMedicaoPosFalha;
	}
	public void setMedicaoPosFalha(boolean isMedicaoPosFalha) {
		this.isMedicaoPosFalha = isMedicaoPosFalha;
	}
	public Date getDthrMedicao() {
		return dthrMedicao;
	}
	public void setDthrMedicao(Date dthrMedicao) {
		this.dthrMedicao = dthrMedicao;
	}
	public double getVlcorrente() {
		return vlcorrente;
	}
	public void setVlcorrente(double vlcorrente) {
		this.vlcorrente = vlcorrente;
	}
	public int getFluxoe() {
		return fluxoe;
	}
	public void setFluxoe(int fluxoe) {
		this.fluxoe = fluxoe;
	}	
	public int getFluxos() {
		return fluxos;
	}
	public void setFluxos(int fluxos) {
		this.fluxos = fluxos;
	}		
	public double getTensao() {
		return tensao;
	}
	public void setTensao(double tensao) {
		this.tensao = tensao;
	}
}
