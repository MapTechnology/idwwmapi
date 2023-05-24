package idw.webservices.dto;

import java.util.List;

public class CEPFolhaDTO 
{
	private Long idFolha;
	private String cdFolha;
	private Long revisao;
	private List<CEPParametroDTO> parametros;
	
	public Long getIdFolha() {
		return idFolha;
	}
	public void setIdFolha(Long idFolha) {
		this.idFolha = idFolha;
	}
	public String getCdFolha() {
		return cdFolha;
	}
	public void setCdFolha(String cdFolha) {
		this.cdFolha = cdFolha;
	}
	public Long getRevisao() {
		return revisao;
	}
	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}
	public List<CEPParametroDTO> getParametros() {
		return parametros;
	}
	public void setParametros(List<CEPParametroDTO> parametros) {
		this.parametros = parametros;
	}
	
	
}
