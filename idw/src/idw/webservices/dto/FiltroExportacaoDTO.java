/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.DwExpcvs;


/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class FiltroExportacaoDTO implements Serializable {
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_FILTRO_JA_EXISTE = 1;
	private int ERRO_DESCONHECIDO = 2;
	private int ERRO_CDEXPCVS_INVALIDO = 3;
	private int ERRO_DSEXPCVS_INVALIDO = 4;
	
    private DwExpcvs filtro;
    private String plataformasSelecionadas;
    private int resultadoEvento;
    private String path;
    private String prefixo;
	
    public int getEVENTO_BEM_SUCEDIDO() {    	
		return EVENTO_BEM_SUCEDIDO;
	}
	public void setEVENTO_BEM_SUCEDIDO(int eVENTOBEMSUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTOBEMSUCEDIDO;
	}
	public int getERRO_FILTRO_JA_EXISTE() {
		return ERRO_FILTRO_JA_EXISTE;
	}
	public void setERRO_FILTRO_JA_EXISTE(int eRROFILTROJAEXISTE) {
		ERRO_FILTRO_JA_EXISTE = eRROFILTROJAEXISTE;
	}
	public DwExpcvs getFiltro() {
		return filtro;
	}
	public void setFiltro(DwExpcvs filtro) {
		this.filtro = filtro;
	}
	public int getResultadoEvento() {
		return resultadoEvento;
	}
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}
	public void setERRO_DESCONHECIDO(int eRRODESCONHECIDO) {
		ERRO_DESCONHECIDO = eRRODESCONHECIDO;
	}
	public int getERRO_CDEXPCVS_INVALIDO() {
		return ERRO_CDEXPCVS_INVALIDO;
	}
	public void setERRO_CDEXPCVS_INVALIDO(int eRROCDEXPCVSINVALIDO) {
		ERRO_CDEXPCVS_INVALIDO = eRROCDEXPCVSINVALIDO;
	}
	public int getERRO_DSEXPCVS_INVALIDO() {
		return ERRO_DSEXPCVS_INVALIDO;
	}
	public void setERRO_DSEXPCVS_INVALIDO(int eRRODSEXPCVSINVALIDO) {
		ERRO_DSEXPCVS_INVALIDO = eRRODSEXPCVSINVALIDO;
	}
	public String getPlataformasSelecionadas() {
		return plataformasSelecionadas;
	}
	public void setPlataformasSelecionadas(String plataformasSelecionadas) {
		this.plataformasSelecionadas = plataformasSelecionadas;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getPrefixo() {
		return prefixo;
	}
	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}	
	
}