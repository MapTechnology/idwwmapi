package idw.model.rn.impprog;

import java.util.ArrayList;
import java.util.List;

public class ProgramaSMDPanaSemp extends ProgramaSMDPanasonic{
	
	public ProgramaSMDPanaSemp(String arquivo, String conteudo) {
		super(arquivo, conteudo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<String> obtemLinhas() {
		int posicao = getPrograma().length() - 4;
		String linha = getPrograma().substring(posicao, posicao+2);
		List<String> retorno = new ArrayList<String>();

		if (!linha.substring(0, 1).equals("0") && !linha.substring(0, 1).toUpperCase().equals("L")){
			retorno.add("0" + linha.substring(0, 1));
			retorno.add("0" + linha.substring(1, 2));
		} else {
			retorno.add(linha);
		}
		return retorno;
	}

}
