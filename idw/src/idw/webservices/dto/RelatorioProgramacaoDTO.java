package idw.webservices.dto;

import java.util.Date;
import java.util.List;

public class RelatorioProgramacaoDTO {
	
	private String maquina;
	private String op;
	private String molde;
	private String produto;
	private String cliente;
	private String inicioPlanejado;
	private String fimPlanejado;
	private String inicioReal;
	private String fimPrevisto;
	private String gargalo;
	private int setupProg;
	private int eficienciaProg;
	private String paradasProg;
	private double qtdsPlanejada;
	private double qtdsBoas;
	private double saldo;
	private boolean isOpCarteira;
	private boolean isPlanoCritico;
	private Date fimPrevistoDate;
	private List<RelatorioProgramacaoDTO> itens;
	
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getMolde() {
		return molde;
	}
	public void setMolde(String molde) {
		this.molde = molde;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}	
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getInicioPlanejado() {
		return inicioPlanejado;
	}
	public void setInicioPlanejado(String inicioPlanejado) {
		this.inicioPlanejado = inicioPlanejado;
	}
	public String getFimPlanejado() {
		return fimPlanejado;
	}
	public void setFimPlanejado(String fimPlanejado) {
		this.fimPlanejado = fimPlanejado;
	}
	public String getInicioReal() {
		return inicioReal;
	}
	public void setInicioReal(String inicioReal) {
		this.inicioReal = inicioReal;
	}
	public String getFimPrevisto() {
		return fimPrevisto;
	}
	public void setFimPrevisto(String fimPrevisto) {
		this.fimPrevisto = fimPrevisto;
	}
	public String getGargalo() {
		return gargalo;
	}
	public void setGargalo(String gargalo) {
		this.gargalo = gargalo;
	}
	public int getSetupProg() {
		return setupProg;
	}
	public void setSetupProg(int setupProg) {
		this.setupProg = setupProg;
	}
	public int getEficienciaProg() {
		return eficienciaProg;
	}
	public void setEficienciaProg(int eficienciaProg) {
		this.eficienciaProg = eficienciaProg;
	}
	public String getParadasProg() {
		return paradasProg;
	}
	public void setParadasProg(String paradasProg) {
		this.paradasProg = paradasProg;
	}
	public double getQtdsPlanejada() {
		return qtdsPlanejada;
	}
	public void setQtdsPlanejada(double qtdsPlanejada) {
		this.qtdsPlanejada = qtdsPlanejada;
	}
	public double getQtdsBoas() {
		return qtdsBoas;
	}
	public void setQtdsBoas(double qtdsBoas) {
		this.qtdsBoas = qtdsBoas;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public boolean isOpCarteira() {
		return isOpCarteira;
	}
	public void setOpCarteira(boolean isOpCarteira) {
		this.isOpCarteira = isOpCarteira;
	}
	public boolean isPlanoCritico() {
		return isPlanoCritico;
	}
	public void setPlanoCritico(boolean isPlanoCritico) {
		this.isPlanoCritico = isPlanoCritico;
	}
	public List<RelatorioProgramacaoDTO> getItens() {
		return itens;
	}
	public void setItens(List<RelatorioProgramacaoDTO> itens) {
		this.itens = itens;
	}
	public Date getFimPrevistoDate() {
		return fimPrevistoDate;
	}
	public void setFimPrevistoDate(Date fimPrevistoDate) {
		this.fimPrevistoDate = fimPrevistoDate;
	}
	
}