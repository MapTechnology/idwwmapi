package injetws.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class IwsDadosCCKDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6244342086219592834L;
	/**
	 * 
	 */
	private BigDecimal consumoAtivo;
	private BigDecimal fatorDePotencia;
	private BigDecimal demandaAtiva;
	private BigDecimal tensaoA;
	private BigDecimal tensaoB;
	private BigDecimal tensaoC;
	private BigDecimal tensaoAB;
	private BigDecimal tensaoBC;
	private BigDecimal tensaoAC;
	private BigDecimal correnteA;
	private BigDecimal correnteB;
	private BigDecimal correnteC;
	private BigDecimal tensaoMedia;
	private BigDecimal correnteMedia;
	
	
	public IwsDadosCCKDTO(){
		
	}
	
	public IwsDadosCCKDTO(BigDecimal consumoAtivo, BigDecimal fatorDePotencia,
			BigDecimal demandaAtiva, BigDecimal tensaoA, BigDecimal tensaoB, BigDecimal tensaoC,
			BigDecimal tensaoAB, BigDecimal tensaoBC, BigDecimal tensaoAC, BigDecimal correnteA,
			BigDecimal correnteB, BigDecimal correnteC, BigDecimal tensaoMedia, BigDecimal correnteMedia) {
		this.consumoAtivo = consumoAtivo;
		this.fatorDePotencia = fatorDePotencia;
		this.demandaAtiva = demandaAtiva;
		this.tensaoA = tensaoA;
		this.tensaoB = tensaoB;
		this.tensaoC = tensaoC;
		this.tensaoAB = tensaoAB;
		this.tensaoBC = tensaoBC;
		this.tensaoAC = tensaoAC;
		this.correnteA = correnteA;
		this.correnteB = correnteB;
		this.correnteC = correnteC;
		this.tensaoMedia = tensaoMedia;
		this.correnteMedia = correnteMedia;
	}
	
	
	public void truncateAllValuesPrecision(int precision) {
		try{
			this.consumoAtivo =this.consumoAtivo.setScale(precision, BigDecimal.ROUND_HALF_EVEN);
			this.fatorDePotencia = this.fatorDePotencia.setScale(precision, BigDecimal.ROUND_HALF_EVEN);
			//this.demandaAtiva = this.demandaAtiva.setScale(precision, BigDecimal.ROUND_HALF_EVEN);
			this.tensaoA = this.tensaoA.setScale(precision, BigDecimal.ROUND_HALF_EVEN);
			this.tensaoB = this.tensaoB.setScale(precision, BigDecimal.ROUND_HALF_EVEN);
			this.tensaoC = this.tensaoC.setScale(precision, BigDecimal.ROUND_HALF_EVEN);
			this.tensaoAB = this.tensaoAB.setScale(precision, BigDecimal.ROUND_HALF_EVEN);
			this.tensaoBC = this.tensaoBC.setScale(precision, BigDecimal.ROUND_HALF_EVEN);
			this.tensaoAC = this.tensaoAC.setScale(precision, BigDecimal.ROUND_HALF_EVEN);
			this.correnteA = this.correnteA.setScale(precision, BigDecimal.ROUND_HALF_EVEN);
			this.correnteB = this.correnteB.setScale(precision, BigDecimal.ROUND_HALF_EVEN);
			this.correnteC = this.correnteC.setScale(precision, BigDecimal.ROUND_HALF_EVEN);
			this.tensaoMedia = this.tensaoMedia.setScale(precision, BigDecimal.ROUND_HALF_EVEN);
			this.correnteMedia = this.correnteMedia.setScale(precision, BigDecimal.ROUND_HALF_EVEN);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public BigDecimal getConsumoAtivo() {
		return consumoAtivo;
	}
	public void setConsumoAtivo(BigDecimal consumoAtivo) {
		this.consumoAtivo = consumoAtivo;
	}
	
	public void setConsumoAtivo(Double consumoAtivo) {
		this.consumoAtivo = new BigDecimal(consumoAtivo);
	}
	
	public BigDecimal getFatorDePotencia() {
		return fatorDePotencia;
	}
	public void setFatorDePotencia(BigDecimal fatorDePotencia) {
		this.fatorDePotencia = fatorDePotencia;
	}
	
	public void setFatorDePotencia(Double fatorDePotencia) {
		this.fatorDePotencia = new BigDecimal(fatorDePotencia);
	}
	
	public BigDecimal getDemandaAtiva() {
		return demandaAtiva;
	}
	
	public void setDemandaAtiva(BigDecimal demandaAtiva) {
		this.demandaAtiva = demandaAtiva;
	}
	
	public BigDecimal getTensaoA() {
		return tensaoA;
	}

	public void setTensaoA(BigDecimal tensaoA) {
		this.tensaoA = tensaoA;
	}

	public void setTensaoA(Double tensaoA) {
		this.tensaoA = new BigDecimal(tensaoA);
	}
	
	public BigDecimal getTensaoB() {
		return tensaoB;
	}

	public void setTensaoB(BigDecimal tensaoB) {
		this.tensaoB = tensaoB;
	}
	
	public void setTensaoB(Double tensaoB) {
		this.tensaoB = new BigDecimal(tensaoB);
	}

	public BigDecimal getTensaoC() {
		return tensaoC;
	}

	public void setTensaoC(BigDecimal tensaoC) {
		this.tensaoC = tensaoC;
	}
	
	public void setTensaoC(Double tensaoC) {
		this.tensaoC = new BigDecimal(tensaoC);
	}

	public BigDecimal getTensaoAB() {
		return tensaoAB;
	}

	public void setTensaoAB(BigDecimal tensaoAB) {
		this.tensaoAB = tensaoAB;
	}
	
	public void setTensaoAB(Double tensaoAB) {
		this.tensaoAB = new BigDecimal(tensaoAB);
	}

	public BigDecimal getTensaoBC() {
		return tensaoBC;
	}

	public void setTensaoBC(BigDecimal tensaoBC) {
		this.tensaoBC = tensaoBC;
	}
	
	public void setTensaoBC(Double tensaoBC) {
		this.tensaoBC = new BigDecimal(tensaoBC);
	}

	public BigDecimal getTensaoAC() {
		return tensaoAC;
	}

	public void setTensaoAC(BigDecimal tensaoAC) {
		this.tensaoAC = tensaoAC;
	}
	
	public void setTensaoAC(Double tensaoAC) {
		this.tensaoAC = new BigDecimal(tensaoAC);
	}

	public BigDecimal getCorrenteA() {
		return correnteA;
	}

	public void setCorrenteA(BigDecimal correnteA) {
		this.correnteA = correnteA;
	}
	
	public void setCorrenteA(Double correnteA) {
		this.correnteA = new BigDecimal(correnteA);
	}

	public BigDecimal getCorrenteB() {
		return correnteB;
	}

	public void setCorrenteB(BigDecimal correnteB) {
		this.correnteB = correnteB;
	}
	
	public void setCorrenteB(Double correnteB) {
		this.correnteB = new BigDecimal(correnteB);
	}


	public BigDecimal getCorrenteC() {
		return correnteC;
	}

	public void setCorrenteC(BigDecimal correnteC) {
		this.correnteC = correnteC;
	}
	
	public void setCorrenteC(Double correnteC) {
		this.correnteC = new BigDecimal(correnteC);
	}

	public BigDecimal getTensaoMedia() {
		return tensaoMedia;
	}

	public void setTensaoMedia(BigDecimal tensaoMedia) {
		this.tensaoMedia = tensaoMedia;
	}
	
	public void setTensaoMedia(Double tensaoMedia) {
		this.tensaoMedia = new BigDecimal(tensaoMedia);
	}

	public BigDecimal getCorrenteMedia() {
		return correnteMedia;
	}

	public void setCorrenteMedia(BigDecimal correnteMedia) {
		this.correnteMedia = correnteMedia;
	}
	
	public void setCorrenteMedia(Double correnteMedia) {
		this.correnteMedia = new BigDecimal(correnteMedia);
	}
	

}
