package idw.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class MontagensDTO implements Serializable {
	private String cdAvo;
	private String cbPai;
	private String cbSerial;
	private String loginSupervisor;
	private String cdProdutoEsperado;
	private List<MontagemDTO> listaMontagem = new ArrayList<MontagemDTO>();
	private ResultadoDTO resultado = new ResultadoDTO();
	
	public ResultadoDTO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}
	public List<MontagemDTO> getListaMontagem() {
		return listaMontagem;
	}
	public void setListaMontagem(List<MontagemDTO> listaMontagem) {
		this.listaMontagem = listaMontagem;
	}
	public String getCbPai() {
		return cbPai;
	}
	public void setCbPai(String cbPai) {
		this.cbPai = cbPai;
	}
	public String getLoginSupervisor() {
		return loginSupervisor;
	}
	public void setLoginSupervisor(String loginSupervisor) {
		this.loginSupervisor = loginSupervisor;
	}
	public String getCbSerial() {
		return cbSerial;
	}
	public void setCbSerial(String cbSerial) {
		this.cbSerial = cbSerial;
	}
	public String getCdAvo() {
		return cdAvo;
	}
	public void setCdAvo(String cdAvo) {
		this.cdAvo = cdAvo;
	}
	public String getCdProdutoEsperado() {
		return cdProdutoEsperado;
	}
	public void setCdProdutoEsperado(String cdProdutoEsperado) {
		this.cdProdutoEsperado = cdProdutoEsperado;
	}
}
