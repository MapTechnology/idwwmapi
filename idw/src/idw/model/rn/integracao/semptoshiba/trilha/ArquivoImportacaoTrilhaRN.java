package idw.model.rn.integracao.semptoshiba.trilha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArquivoImportacaoTrilhaRN {

	private List<String> linhas;
	
	public ArquivoImportacaoTrilhaRN(String conteudo) {
		this.linhas = new ArrayList<String>(Arrays.asList(conteudo.split("\n")));
		this.linhas.remove(0);
	}
	
	public List<String> getLinhas() {
		return linhas;
	}
	
	public LinhaImportacaoTrilhaDTO getCampos(String linha) {
		return new LinhaImportacaoTrilhaDTO(linha);
	}
	
}
