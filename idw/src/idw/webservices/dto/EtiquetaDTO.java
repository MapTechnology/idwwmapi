/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class EtiquetaDTO implements Serializable {

	private int EVENTO_BEM_SUCEDIDO = 0;

	private String descricao;
	private String codigoBarra;
	private String descricao2;
	private String descricao3;
	private String script;
	private String modelo;
	private String login;
	private String depara;
	private BigDecimal gPesoBruto;
	private String cdSap;
	private Integer qtEmpilhamento;
	private String cdModelo;
	private String cdPartnumber;
	
	
    private String cdproduto;
    private String lote;
    private String cliente;
    private String op;
    private String filial;
    private String turno;
    private String linha;
    private String dsproduto;
    private String pilha;


	private MontagensDTO montagens;

    private int resultadoEvento;

    public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}
	public void setEVENTO_BEM_SUCEDIDO(int evento_bem_sucedido) {
		EVENTO_BEM_SUCEDIDO = evento_bem_sucedido;
	}
	public int getResultadoEvento() {
		return resultadoEvento;
	}
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	public String getDescricao2() {
		return descricao2;
	}
	public void setDescricao2(String descricao2) {
		this.descricao2 = descricao2;
	}
	public String getDescricao3() {
		return descricao3;
	}
	public void setDescricao3(String descricao3) {
		this.descricao3 = descricao3;
	}
	public String getScript() {
		return script;
	}
	public void setScript(String script) {
		this.script = script;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public MontagensDTO getMontagens() {
		return montagens;
	}
	public void setMontagens(MontagensDTO montagens) {
		this.montagens = montagens;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public void setDepara(String depara) {
		this.depara = depara;
	}

	public String getDepara() {
		return this.depara;
	}

	public void setGPesoBruto(BigDecimal gPesoBruto) {
		this.gPesoBruto = gPesoBruto;
	}

	public BigDecimal getGPesoBruto() {
		return this.gPesoBruto;
	}

	public void setCdSap(String cdSap) {
		this.cdSap = cdSap;
	}

	public String getCdSap() {
		return this.cdSap;
	}

	public void setQtEmpilhamento(Integer qtEmpilhamento) {
		this.qtEmpilhamento = qtEmpilhamento;
	}

	public Integer getQtEmpilhamento() {
		return this.qtEmpilhamento;
	}

	public String getCdModelo() {
		return cdModelo;
	}

	public void setCdModelo(String cdModelo) {
		this.cdModelo = cdModelo;
	}

	public String getCdPartnumber() {
		return cdPartnumber;
	}

	public void setCdPartnumber(String cdEtiqueta) {
		this.cdPartnumber = cdEtiqueta;
	}
	public String getCdproduto() {
		return cdproduto;
	}
	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getLinha() {
		return linha;
	}
	public void setLinha(String linha) {
		this.linha = linha;
	}
	public String getDsproduto() {
		return dsproduto;
	}
	public void setDsproduto(String dsproduto) {
		this.dsproduto = dsproduto;
	}
	public String getPilha() {
		return pilha;
	}
	public void setPilha(String pilha) {
		this.pilha = pilha;
	}
	public String getFilial() {
		return filial;
	}
	public void setFilial(String filial) {
		this.filial = filial;
	}



}