package idw.webservices.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DwProreaUsrDTO implements Serializable {

	private static final long serialVersionUID = 7707178923594360687L;
	private Long idomUsr;
	private String dsNome;
	private String cdUsr;
	private Long idProcedimento;
	
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int resultadoEvento;
	
	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}

	public void setEVENTO_BEM_SUCEDIDO(int eVENTO_BEM_SUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTO_BEM_SUCEDIDO;
	}

	public int getResultadoEvento() {
		return resultadoEvento;
	}

	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}

	public Long getIdomUsr() {
		return idomUsr;
	}

	public void setIdomUsr(Long idomUsr) {
		this.idomUsr = idomUsr;
	}

	public String getDsNome() {
		return dsNome;
	}

	public String getCdUsr() {
		return cdUsr;
	}

	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
	}

	public void setCdUsr(String cdUsr) {
		this.cdUsr = cdUsr;
	}

	public Long getIdProcedimento() {
		return idProcedimento;
	}

	public void setIdProcedimento(Long idProcedimento) {
		this.idProcedimento = idProcedimento;
	}
}
