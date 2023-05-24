package idw.model.rn.integracao.semptoshiba.trilha;



import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ArquivosTrilhaDTO implements Serializable {

	private List<ArquivoTrilhaDTO> listaArquivosDTO;

	public ArquivosTrilhaDTO() {

	}

	public List<ArquivoTrilhaDTO> getListaArquivosDTO() {
		return listaArquivosDTO;
	}

	public void setListaArquivosDTO(List<ArquivoTrilhaDTO> listaArquivosDTO) {
		this.listaArquivosDTO = listaArquivosDTO;
	}
	
}