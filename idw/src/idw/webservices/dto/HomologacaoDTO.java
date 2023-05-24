/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.OmHomogt;
import idw.model.pojos.OmHomopt;


/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class HomologacaoDTO implements Serializable, Cloneable {
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_USUARIO_JA_HOMOLOGADO = 1;
	private int ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR = 2;
	private int ERRO_USUARIO_DESCONHECIDO = 3;
	private int ERRO_PT_DESCONHECIDO = 4;
	private int ERRO_TIPOHOMOLOGACAO_INVALIDA = 5;
	
    private OmHomopt homologacaoPt;
    private OmHomogt homologacaoGt;
    private int resultadoEvento;
    
    public HomologacaoDTO(){
    	super();
    }
    /**
     * @return the resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }

    /**
     * @param resultadoEvento the resultadoEvento to set
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }
	
	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}

	public void setEVENTO_BEM_SUCEDIDO(int evento_bem_sucedido) {
		EVENTO_BEM_SUCEDIDO = evento_bem_sucedido;
	}

	public int getERRO_USUARIO_JA_HOMOLOGADO() {
		return ERRO_USUARIO_JA_HOMOLOGADO;
	}

	public void setERRO_USUARIO_JA_HOMOLOGADO(int eRROUSUARIOJAHOMOLOGADO) {
		ERRO_USUARIO_JA_HOMOLOGADO = eRROUSUARIOJAHOMOLOGADO;
	}

	public int getERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR() {
		return ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR;
	}

	public void setERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR(
			int eRROUSUARIOJAHOMOLOGADOSUPERVISOR) {
		ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR = eRROUSUARIOJAHOMOLOGADOSUPERVISOR;
	}

	public int getERRO_USUARIO_DESCONHECIDO() {
		return ERRO_USUARIO_DESCONHECIDO;
	}

	public void setERRO_USUARIO_DESCONHECIDO(int eRROUSUARIODESCONHECIDO) {
		ERRO_USUARIO_DESCONHECIDO = eRROUSUARIODESCONHECIDO;
	}

	public int getERRO_PT_DESCONHECIDO() {
		return ERRO_PT_DESCONHECIDO;
	}

	public void setERRO_PT_DESCONHECIDO(int eRROPTDESCONHECIDO) {
		ERRO_PT_DESCONHECIDO = eRROPTDESCONHECIDO;
	}

	public int getERRO_TIPOHOMOLOGACAO_INVALIDA() {
		return ERRO_TIPOHOMOLOGACAO_INVALIDA;
	}

	public void setERRO_TIPOHOMOLOGACAO_INVALIDA(int eRROTIPOHOMOLOGACAOINVALIDA) {
		ERRO_TIPOHOMOLOGACAO_INVALIDA = eRROTIPOHOMOLOGACAOINVALIDA;
	}

	public OmHomopt getHomologacaoPt() {
		return homologacaoPt;
	}

	public void setHomologacaoPt(OmHomopt homologacaoPt) {
		this.homologacaoPt = homologacaoPt;
	}
	
	public OmHomogt getHomologacaoGt() {
		return homologacaoGt;
	}

	public void setHomologacaoGt(OmHomogt homologacaoGt) {
		this.homologacaoGt = homologacaoGt;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() {
		
		HomologacaoDTO homo = (HomologacaoDTO) this;
	    
		HomologacaoDTO clone = null;
		
		try {
			clone = (HomologacaoDTO) super.clone();
		} catch (CloneNotSupportedException e) {
			clone = new HomologacaoDTO();
		}
		
		clone.setHomologacaoPt((OmHomopt)homo.getHomologacaoPt().clone());
		clone.setResultadoEvento(homo.getResultadoEvento());				
		
		return clone;

    }	
	
}