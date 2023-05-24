package idw.model.rn.injet.dto;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class MaquinaPlanejamentoInjetDTO implements Serializable{
	private String nrop;
	private Date dtInicio;
	private String cliente;
	private String cdMolde;
	private String cdEstrutura;
	private Float qtcavidades;
	private Float qtcavativas;
	
	private Float eficienciaRealizacao = 0f;
	private Float indiceProducao = 0f;
	private Float eficienciaCiclo = 0f;
	private Float indiceParada = 0f;
	private Float indiceRefugo = 0f;
	
	public Float getEficienciaRealizacao() {
		return eficienciaRealizacao;
	}
	public void setEficienciaRealizacao(Float eficienciaRealizacao) {
		this.eficienciaRealizacao = eficienciaRealizacao;
	}
	public Float getIndiceProducao() {
		return indiceProducao;
	}
	public void setIndiceProducao(Float indiceProducao) {
		this.indiceProducao = indiceProducao;
	}
	public Float getEficienciaCiclo() {
		return eficienciaCiclo;
	}
	public void setEficienciaCiclo(Float eficienciaCiclo) {
		this.eficienciaCiclo = eficienciaCiclo;
	}
	public Float getIndiceParada() {
		return indiceParada;
	}
	public void setIndiceParada(Float indiceParada) {
		this.indiceParada = indiceParada;
	}
	public Float getIndiceRefugo() {
		return indiceRefugo;
	}
	public void setIndiceRefugo(Float indiceRefugo) {
		this.indiceRefugo = indiceRefugo;
	}
	public String getNrop() {
		return nrop;
	}
	public void setNrop(String nrop) {
		this.nrop = nrop;
	}
	public Date getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getCdMolde() {
		return cdMolde;
	}
	public void setCdMolde(String cdMolde) {
		this.cdMolde = cdMolde;
	}
	public String getCdEstrutura() {
		return cdEstrutura;
	}
	public void setCdEstrutura(String cdEstrutura) {
		this.cdEstrutura = cdEstrutura;
	}
	public Float getQtcavidades() {
		return qtcavidades;
	}
	public void setQtcavidades(Float qtcavidades) {
		this.qtcavidades = qtcavidades;
	}
	public Float getQtcavativas() {
		return qtcavativas;
	}
	public void setQtcavativas(Float qtcavativas) {
		this.qtcavativas = qtcavativas;
	}
}
