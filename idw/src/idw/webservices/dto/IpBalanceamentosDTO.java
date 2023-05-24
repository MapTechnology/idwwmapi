package idw.webservices.dto;


import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class IpBalanceamentosDTO implements Serializable {

	private List<IpBalanceamentoDTO> lista;
	private ResultadoDTO resultado;
	
	public List<IpBalanceamentoDTO> getLista() {
		return lista;
	}
	public void setLista(List<IpBalanceamentoDTO> lista) {
		this.lista = lista;
	}
	public ResultadoDTO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}
	
	
}
