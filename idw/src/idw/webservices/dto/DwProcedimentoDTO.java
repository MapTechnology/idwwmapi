package idw.webservices.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import idw.model.pojos.DwProcedimento;

@XmlRootElement
@SuppressWarnings("serial")
public class DwProcedimentoDTO implements Serializable{
	
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_PROCEDIMENTO_JA_EXISTE = 1;
	private int ERRO_DESCONHECIDO = 2;
	private int resultadoEvento;
	
	private DwProcedimento dwProcedimento;
	
	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}

	public void setEVENTO_BEM_SUCEDIDO(int eVENTO_BEM_SUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTO_BEM_SUCEDIDO;
	}

	public int getERRO_PROCEDIMENTO_JA_EXISTE() {
		return ERRO_PROCEDIMENTO_JA_EXISTE;
	}

	public void setERRO_PROCEDIMENTO_JA_EXISTE(int eRRO_PROCEDIMENTO_JA_EXISTE) {
		ERRO_PROCEDIMENTO_JA_EXISTE = eRRO_PROCEDIMENTO_JA_EXISTE;
	}

	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}

	public void setERRO_DESCONHECIDO(int eRRO_DESCONHECIDO) {
		ERRO_DESCONHECIDO = eRRO_DESCONHECIDO;
	}

	public int getResultadoEvento() {
		return resultadoEvento;
	}

	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}

	public DwProcedimento getDwProcedimento() {
		return dwProcedimento;
	}

	public void setDwProcedimento(DwProcedimento dwProcedimento) {
		this.dwProcedimento = dwProcedimento;
	}

}