/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;

/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class RelAbastecimentoComponentesAlimreaDTO implements Serializable {
	
	private int EVENTO_BEM_SUCEDIDO = 0;
	
	private int resultadoEvento;
	private String componente;
	private String dsComponente;
	private String quantidade;
	private String posicaoZ;
	private String matriculaOperador;
	private String operador;
	private String alimOK;
	private String alimNOK;
	private String realimOK;
	private String realimNOK;
	private String conferOK;
	private String conferNOK;	
	private String hora;
	
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
	public String getComponente() {
		return componente;
	}
	public void setComponente(String componente) {
		this.componente = componente;
	}
	public String getPosicaoZ() {
		return posicaoZ;
	}
	public void setPosicaoZ(String posicaoZ) {
		this.posicaoZ = posicaoZ;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public String getAlimOK() {
		return alimOK;
	}
	public void setAlimOK(String alimOK) {
		this.alimOK = alimOK;
	}
	public String getAlimNOK() {
		return alimNOK;
	}
	public void setAlimNOK(String alimNOK) {
		this.alimNOK = alimNOK;
	}
	public String getRealimOK() {
		return realimOK;
	}
	public void setRealimOK(String realimOK) {
		this.realimOK = realimOK;
	}
	public String getRealimNOK() {
		return realimNOK;
	}
	public void setRealimNOK(String realimNOK) {
		this.realimNOK = realimNOK;
	}
	public String getConferOK() {
		return conferOK;
	}
	public void setConferOK(String conferOK) {
		this.conferOK = conferOK;
	}
	public String getConferNOK() {
		return conferNOK;
	}
	public void setConferNOK(String conferNOK) {
		this.conferNOK = conferNOK;
	}	
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getDsComponente() {
		return dsComponente;
	}
	public void setDsComponente(String dsComponente) {
		this.dsComponente = dsComponente;
	}
	public String getMatriculaOperador() {
		return matriculaOperador;
	}
	public void setMatriculaOperador(String matriculaOperador) {
		this.matriculaOperador = matriculaOperador;
	}	

    	
}