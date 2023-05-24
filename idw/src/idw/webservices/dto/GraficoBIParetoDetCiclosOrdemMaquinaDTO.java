package idw.webservices.dto;

import java.util.List;

public class GraficoBIParetoDetCiclosOrdemMaquinaDTO 
{
	
    private String cdMaquina;
    private String dsMaquina;
    private Double segCiclosProdutivos;
    private Double qtdEmUB; // unidade básica de contagem
    private Double qtdEmKg;
    private Double qtdEmTon;
    private Double qtdEmUM; // unidade monetária  
    
    private List<GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO> ferramentas;
    
	public GraficoBIParetoDetCiclosOrdemMaquinaDTO()
    {
    	
    }    


	public String getCdMaquina() {
		return cdMaquina;
	}

	public void setCdMaquina(String cdMaquina) {
		this.cdMaquina = cdMaquina;
	}

	public String getDsMaquina() {
		return dsMaquina;
	}

	public void setDsMaquina(String dsMasquina) {
		this.dsMaquina = dsMasquina;
	}
	public Double getQtdEmUB() {
		return qtdEmUB;
	}
	public void setQtdEmUB(Double qtdEmUB) {
		this.qtdEmUB = qtdEmUB;
	}
	public Double getQtdEmKg() {
		return qtdEmKg;
	}
	public void setQtdEmKg(Double qtdEmKg) {
		this.qtdEmKg = qtdEmKg;
	}
	public Double getQtdEmTon() {
		return qtdEmTon;
	}
	public void setQtdEmTon(Double qtdEmTon) {
		this.qtdEmTon = qtdEmTon;
	}
	public Double getQtdEmUM() {
		return qtdEmUM;
	}
	public void setQtdEmUM(Double qtdEmUM) {
		this.qtdEmUM = qtdEmUM;
	}
	
	public Double getSegCiclosProdutivos() {
		return segCiclosProdutivos;
	}
	public void setSegCiclosProdutivos(Double segCiclosProdutivos) {
		this.segCiclosProdutivos = segCiclosProdutivos;
	}	

	public List<GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO> getFerramentas() {
		return ferramentas;
	}


	public void setFerramentas(List<GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO> ferramentas) {
		this.ferramentas = ferramentas;
	}

}
