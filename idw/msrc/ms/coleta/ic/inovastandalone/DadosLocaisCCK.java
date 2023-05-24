package ms.coleta.ic.inovastandalone;

import java.util.Date;

public class DadosLocaisCCK {
	public final static String[] dsEstado={"IDEAL","ACEITAVEL","CRITICO","SEM CONEXAO"};
	public final static int _NAODEFINIDO =-1;
	public final static int _EstadoOK =0;
	public final static int _Aceitavel =1;
	public final static int _Critico =2;
	public final static int _LImiteMedia =10;
	private double ultimaAmostragem=_NAODEFINIDO;
	private double limiteAceitavelSup=_NAODEFINIDO;
	private double limiteAceitavelInf=_NAODEFINIDO;
	private double limiteCriticoSup=_NAODEFINIDO;
	private double limiteCriticoInf=_NAODEFINIDO;
	private int tpParametro=_NAODEFINIDO;
	private boolean deveTratar=false;
	private Date dthrUltimaAmostragem=null;
	public int nrRetries=5; // N�mero de aferi��es repetidas para considerar uma mudan�a de estado 
	public int countRetries=0;
	private int lastEstadoAferido=_NAODEFINIDO;
	private int ultimoestadoConsolidado=_NAODEFINIDO;  // -1 N�o iniciado,0- OK , 1 -Zona Aceitavel , 2- ZonaCritica  superior,3- Sem Conex�o
	private  Double demandaMaxima=0d;
	private  Double demandaMedia=0d;
	private int sizeMedia=0;

	
	public int getSizeMedia() {
		return sizeMedia;
	}
	public void setSizeMedia(int sizeMedia) {
		this.sizeMedia = sizeMedia;
	}
	public Double getDemandaMaxima() {
		return demandaMaxima;
	}
	public void setDemandaMaxima(Double demandaMaxima) {
		this.demandaMaxima = demandaMaxima;
	}
	public Double getDemandaMedia() {
		return demandaMedia;
	}
	public void setDemandaMedia(Double demandaMedia) {
		this.demandaMedia = demandaMedia;
	}
	public int getUltimoestadoConsolidado() {
		return ultimoestadoConsolidado;
	}
	public void setUltimoestadoConsolidado(int ultimoestadoConsolidado) {
		this.ultimoestadoConsolidado = ultimoestadoConsolidado;
	}
	public int getLastEstadoAferido() {
		return lastEstadoAferido;
	}
	public void setLastEstadoAferido(int lastEstadoAferido) {
		this.lastEstadoAferido = lastEstadoAferido;
	}

	public Date getDthrUltimaAmostragem() {
		return dthrUltimaAmostragem;
	}
	public void setDthrUltimaAmostragem(Date dthrUltimaAmostragem) {
		this.dthrUltimaAmostragem = dthrUltimaAmostragem;
	}
	public boolean isDeveTratar() {
		return deveTratar;
	}
	public void setDeveTratar(boolean deveTratar) {
		this.deveTratar = deveTratar;
	}
	public double getUltimaAmostragem() {
		return ultimaAmostragem;
	}
	public void setUltimaAmostragem(double ultimaAmostragem) {
		this.ultimaAmostragem = ultimaAmostragem;
	}
	public double getLimiteAceitavelSup() {
		return limiteAceitavelSup;
	}
	public void setLimiteAceitavelSup(double limiteAceitavelSup) {
		this.limiteAceitavelSup = limiteAceitavelSup;
	}
	public double getLimiteAceitavelInf() {
		return limiteAceitavelInf;
	}
	public void setLimiteAceitavelInf(double limiteAceitavelInf) {
		this.limiteAceitavelInf = limiteAceitavelInf;
	}
	public double getLimiteCriticoSup() {
		return limiteCriticoSup;
	}
	public void setLimiteCriticoSup(double limiteCriticoSup) {
		this.limiteCriticoSup = limiteCriticoSup;
	}
	public double getLimiteCriticoInf() {
		return limiteCriticoInf;
	}
	public void setLimiteCriticoInf(double limiteCriticoInf) {
		this.limiteCriticoInf = limiteCriticoInf;
	}
	public int getTpParametro() {
		return tpParametro;
	}
	public void setTpParametro(int tpParametro) {
		this.tpParametro = tpParametro;
	}

}
