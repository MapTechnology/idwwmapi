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
public class WizPaDTO implements Serializable {	
    private Integer qtdFeeders;
    private boolean subFeederLR;
    private Integer qtdMesas;
    private Integer qtdBandejas;
    private boolean mudarOrdemLeitura;
    private int resultadoEvento;
    private int mesaInicial;
    private int qtdTrays;
    private int qtdBandejaTray;
    private int bandejaInicialTray;
    private int tamSlot;
	
    
    public int getTamSlot() {
		return tamSlot;
	}
	public void setTamSlot(int tamSlot) {
		this.tamSlot = tamSlot;
	}
	public int getQtdBandejaTray() {
		return qtdBandejaTray;
	}
	public void setQtdBandejaTray(int qtdBandejaTray) {
		this.qtdBandejaTray = qtdBandejaTray;
	}
	public int getBandejaInicialTray() {
		return bandejaInicialTray;
	}
	public void setBandejaInicialTray(int bandejaInicialTray) {
		this.bandejaInicialTray = bandejaInicialTray;
	}
	public int getQtdTrays() {
		return qtdTrays;
	}
	public void setQtdTrays(int qtdTrays) {
		this.qtdTrays = qtdTrays;
	}
	public int getMesaInicial() {
		return mesaInicial;
	}
	public void setMesaInicial(int mesaInicial) {
		this.mesaInicial = mesaInicial;
	}
	public int getResultadoEvento() {
		return resultadoEvento;
	}
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	public Integer getQtdFeeders() {
		return qtdFeeders;
	}
	public void setQtdFeeders(Integer qtdFeeders) {
		this.qtdFeeders = qtdFeeders;
	}
	public boolean isSubFeederLR() {
		return subFeederLR;
	}
	public void setSubFeederLR(boolean subFeederLR) {
		this.subFeederLR = subFeederLR;
	}
	public Integer getQtdMesas() {
		return qtdMesas;
	}
	public void setQtdMesas(Integer qtdMesas) {
		this.qtdMesas = qtdMesas;
	}
	public Integer getQtdBandejas() {
		return qtdBandejas;
	}
	public void setQtdBandejas(Integer qtdBandejas) {
		this.qtdBandejas = qtdBandejas;
	}
	public boolean isMudarOrdemLeitura() {
		return mudarOrdemLeitura;
	}
	public void setMudarOrdemLeitura(boolean mudarOrdemLeitura) {
		this.mudarOrdemLeitura = mudarOrdemLeitura;
	}
	
}