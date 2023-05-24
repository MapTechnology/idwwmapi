package ms.coleta.dto;

import idw.model.pojos.DwFolhamedtemp;
import idw.model.pojos.DwFolhamedtemphorcfg;
import idw.model.pojos.template.DwFtParamTemplate.Type;

import java.math.BigDecimal;
public class ColetaParametroDTO {
		
	
	private BigDecimal tpArmazenamento;
	private BigDecimal qtArmazenamento;
	private BigDecimal segIntervaloLeitura;
	private BigDecimal limInfTemp=null;
	private BigDecimal limSupTemp=null;
	private BigDecimal limInfTempCritico=null;
	private BigDecimal limSupTempCritico=null;
	private String cdFolha =null;
	private Type tpparametro;
	
	public Type getTpparametro() {
		return tpparametro;
	}
	public void setTpparametro(Type tpparametro) {
		this.tpparametro = tpparametro;
	}
	private DwFolhamedtemphorcfg DwFolhamedtemphorcfg;
	
	public BigDecimal getTpArmazenamento() {
		return tpArmazenamento;
	}
	public void setTpArmazenamento(BigDecimal tpArmazenamento) {
		this.tpArmazenamento = tpArmazenamento;
	}
	public BigDecimal getQtArmazenamento() {
		return qtArmazenamento;
	}
	public DwFolhamedtemphorcfg getDwFolhamedtemphorcfg() {
		return DwFolhamedtemphorcfg;
	}
	public void setDwFolhamedtemphorcfg(DwFolhamedtemphorcfg dwFolhamedtemphorcfg) {
		DwFolhamedtemphorcfg = dwFolhamedtemphorcfg;
	}
	public void setQtArmazenamento(BigDecimal qtArmazenamento) {
		this.qtArmazenamento = qtArmazenamento;
	}
	public BigDecimal getSegIntervaloLeitura() {
		return segIntervaloLeitura;
	}
	public void setSegIntervaloLeitura(BigDecimal segIntervaloLeitura) {
		this.segIntervaloLeitura = segIntervaloLeitura;
	}
	public BigDecimal getLimInfTemp() {
		return limInfTemp;
	}
	public void setLimInfTemp(BigDecimal limInfTemp) {
		this.limInfTemp = limInfTemp;
	}
	public BigDecimal getLimSupTemp() {
		return limSupTemp;
	}
	public void setLimSupTemp(BigDecimal limSupTemp) {
		this.limSupTemp = limSupTemp;
	}
	public BigDecimal getLimInfTempCritico() {
		return limInfTempCritico;
	}
	public void setLimInfTempCritico(BigDecimal limInfTempCritico) {
		this.limInfTempCritico = limInfTempCritico;
	}
	public BigDecimal getLimSupTempCritico() {
		return limSupTempCritico;
	}
	public void setLimSupTempCritico(BigDecimal limSupTempCritico) {
		this.limSupTempCritico = limSupTempCritico;
	}
	
	public void setLimites(DwFolhamedtemphorcfg temphorcfg){
			if(temphorcfg.getLimInfTemp()==null){
				this.limInfTempCritico=temphorcfg.getLimSupTemp();
				return;
			}
			if(temphorcfg.getLimSupTemp()==null){
				this.limSupTempCritico=temphorcfg.getLimInfTemp();
				return;
			}
			//POG para facilitar a vincula��o de zonas de temperatura
			if(temphorcfg.getCorIntervalo().contains("H0000C000")||temphorcfg.getDsCfg().contains("Ideal")){
				this.limInfTemp=temphorcfg.getLimInfTemp();
				this.limSupTemp=temphorcfg.getLimSupTemp();
			};
	}	
	
	public void setDadosDeControle(DwFolhamedtemp medtemp){
		qtArmazenamento=medtemp.getQtArmazenamento();
		tpArmazenamento=medtemp.getTpArmazenamento();
		segIntervaloLeitura=medtemp.getSegIntervaloLeitura();
	}
	public void setCdFolha(String cdFolha) {
		this.cdFolha=cdFolha;		
	}
	public String getCdFolha() {
		return this.cdFolha;		
	}
	
}
