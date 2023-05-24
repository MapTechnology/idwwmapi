package idw.webservices.dto;

import java.util.ArrayList;
import java.util.List;

public class ConfiguracoesNecessidadesDTO {

	private List<ConfiguracaoNecessidadeDTO> configuracoesNecessidadesDTO =  new ArrayList<ConfiguracaoNecessidadeDTO>();

	public List<ConfiguracaoNecessidadeDTO> getConfiguracoesNecessidadesDTO() {
		return configuracoesNecessidadesDTO;
	}

	public void setConfiguracoesNecessidadesDTO(
			List<ConfiguracaoNecessidadeDTO> configuracoesNecessidadesDTO) {
		this.configuracoesNecessidadesDTO = configuracoesNecessidadesDTO;
	}
	
	
}
