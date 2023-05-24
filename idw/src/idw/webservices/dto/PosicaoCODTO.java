package idw.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import idw.model.pojos.OmMapapa;

@XmlRootElement(name="posicaocodto")
public class PosicaoCODTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cdFeeder;
	private String cdRap;
	private Long idFeeder;
	private String cdProduto;
	private Long idProduto;
	private String desvio;
	private Long idMapapa;
	private Boolean lido;
	private Integer ordem;
	private Boolean autorizado = false; //Caso o supervisor autorize o check
	
	private String cdMapa; // codigo do mapa a qual se trata a posicao. Sera usado para decidir qual posicao utilizar quando houver duplicacao devido aos mapas anexados
	
	private BigDecimal qtdeConsumidaPorCiclo;
	
	//Luiz - 20202002 - Deve ser retirado o pojo ommapapa quando for atualizar o wsdl do pidion
	private OmMapapa ommapapa;
	
	
	@XmlTransient
	public OmMapapa getOmmapapa() {
		return ommapapa;
	}
	public void setOmmapapa(OmMapapa ommapapa) {
		this.ommapapa = ommapapa;
	}
	public BigDecimal getQtdeConsumidaPorCiclo() {
		return qtdeConsumidaPorCiclo;
	}
	public void setQtdeConsumidaPorCiclo(BigDecimal qtdeConsumidaPorCiclo) {
		this.qtdeConsumidaPorCiclo = qtdeConsumidaPorCiclo;
	}
	public int getOrdem() {
		return ordem;
	}
	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	public String getCdFeeder() {
		return cdFeeder;
	}
	public void setCdFeeder(String cdFeeder) {
		this.cdFeeder = cdFeeder;
	}
	public long getIdFeeder() {
		return idFeeder;
	}
	public void setIdFeeder(long idFeeder) {
		this.idFeeder = idFeeder;
	}
	public String getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}
	public String getDesvio() {
		return desvio;
	}
	public void setDesvio(String desvio) {
		this.desvio = desvio;
	}
	public long getIdMapapa() {
		return idMapapa;
	}
	public void setIdMapapa(long idMapapa) {
		this.idMapapa = idMapapa;
	}
	public boolean isLido() {
		return lido;
	}
	public void setLido(boolean lido) {
		this.lido = lido;
	}
	public boolean isAutorizado() {
		return autorizado;
	}
	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}
	public String getCdRap() {
		return cdRap;
	}
	public void setCdRap(String cdRap) {
		this.cdRap = cdRap;
	}
	public String getCdMapa() {
		return cdMapa;
	}
	public void setCdMapa(String cdMapa) {
		this.cdMapa = cdMapa;
	}
	
	
}
