package injetws.webservices.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class IwsReleDTO implements Serializable {
	
	private String INF01;
	private String INF02;
	private String INF03;
	private String INF04;
	private String INF05;
	private String tmpLimParNaoInf;
	private String vlRefEficUltCiclo;
	private IwsCicloDTO dadosUltCiclo;
	
	
	private Boolean erro;
	
		
	public String getINF01() {
		return(this.INF01);
	}
	
	public void setINF01(String INF01) {
		this.INF01 = INF01;
	}
	
	
	public String getINF02() {
		return(this.INF02);
	}
	
	public void setINF02(String INF02) {
		this.INF02 = INF02;
	}
	
	
	public String getINF03() {
		return(this.INF03);
	}
	
	public void setINF03(String INF03) {
		this.INF03 = INF03;
	}
	
	
	public String getINF04() {
		return(this.INF04);
	}
	
	public void setINF04(String INF04) {
		this.INF04 = INF04;
	}
	
	
	public String getINF05() {
		return(this.INF05);
	}
	
	public void setINF05(String INF05) {
		this.INF05 = INF05;
	}
	
	
	public String getvlRefEficUltCiclo() {
		return(this.vlRefEficUltCiclo);
	}
	
	public void setvlRefEficUltCiclo(String vlRefEficUltCiclo) {
		this.vlRefEficUltCiclo = vlRefEficUltCiclo;
	}
	
	public String gettmpLimParNaoInf() {
		return(this.tmpLimParNaoInf);
	}
	
	public void settmpLimParNaoInf(String tmpLimParNaoInf) {
		this.tmpLimParNaoInf = tmpLimParNaoInf;
	}
	
	
	public Boolean geterro() {
		return(this.erro);
	}
	
	public void seterro(Boolean erro) {
		this.erro = erro;
	}
	
	public void copyFromAndonReleDto(IwsAndonReleDTO andonrele)
	{
		
		this.setINF01(andonrele.getRelayFromBeat().getINF01());
		this.setINF02(andonrele.getRelayFromBeat().getINF02());
		this.setINF03(andonrele.getRelayFromBeat().getINF03());
		this.setINF04(andonrele.getRelayFromBeat().getINF04());
		this.setINF05(andonrele.getRelayFromBeat().getINF05());
		
	}

	public void setDadosUltCiclo(IwsCicloDTO dadosUltCiclo) {
		this.dadosUltCiclo = dadosUltCiclo;
	}

	public IwsCicloDTO getDadosUltCiclo() {
		return dadosUltCiclo;
	}
}
