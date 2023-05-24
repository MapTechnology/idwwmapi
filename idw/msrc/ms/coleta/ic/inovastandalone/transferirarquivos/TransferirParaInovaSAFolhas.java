package ms.coleta.ic.inovastandalone.transferirarquivos;

import java.util.ArrayList;
import java.util.List;

import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhasetup;
import idw.util.ArquivosDiretorios;

public class TransferirParaInovaSAFolhas extends TransferirParaInovaSAFactory{
	private DwFolha dwFolha = null;
	
	@Override
	public void criarArquivo() {
		if(dwFolha == null)
			return;

		String urlConexao = msmsicup.getMsIc().getUrlConexao();
		String dir = getDiretorioDestino() + "/" + urlConexao + "/reg/folha/";

		String fileName = "fol" + dwFolha.getIdFolha();

		// Se o arquivo existir nao precisa criar denovo
		if(ArquivosDiretorios.isExisteArquivo(dir + fileName) == true)
			return;
		
		List<DwFolhasetup> dwFolhaSetups = new ArrayList<DwFolhasetup>(); 
		dwFolhaSetups.addAll(dwFolha.getDwFolhasetupsForIdFolhaentrando());
		
		try {
			urlConexao = urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (IndexOutOfBoundsException e){
			urlConexao = msmsicup.getMsIc().getUrlConexao();
		}

		log.info("Gerando arquivo em " + dir + fileName);

		ArquivoFolhas folha = new ArquivoFolhas();
		folha.setLog(log);
		folha.setDwFolha(dwFolha);
		folha.setDwFolhaSetups(dwFolhaSetups);
		folha.gerarArquivo(dir, fileName);
	}

	@Override
	public void criarArquivoStatus() {
		// TODO Auto-generated method stub
		
	}

	public DwFolha getDwFolha() {
		return dwFolha;
	}

	public void setDwFolha(DwFolha dwFolha) {
		this.dwFolha = dwFolha;
	}
}
