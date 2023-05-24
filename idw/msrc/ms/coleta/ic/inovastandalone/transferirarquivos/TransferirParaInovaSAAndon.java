package ms.coleta.ic.inovastandalone.transferirarquivos;

import idw.util.ArquivosDiretorios;
import ms.coleta.dto.TAndonSADTO;

public class TransferirParaInovaSAAndon extends TransferirParaInovaSAFactory{

	private TAndonSADTO listaAndon;
	private Long idPerfilAndon;
	
	@Override
	public void criarArquivo() {

		String urlConexao = msmsicup.getMsIc().getUrlConexao();

		try {
			urlConexao = urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (IndexOutOfBoundsException e){
			urlConexao = msmsicup.getMsIc().getUrlConexao();
		}
		String dir = getDiretorioDestino() + "/" + urlConexao + "/reg/andon/";

		String fileName = "andon";

		// Se o arquivo existir nao precisa criar denovo
		if(ArquivosDiretorios.isExisteArquivo(dir+fileName) == true)
			return;
		
		log.info("Gerando arquivo em " + dir+fileName);
		
		ArquivoAndon andon = new ArquivoAndon();
		andon.setLog(log);
		andon.setIdPerfilAndon(this.idPerfilAndon);
		andon.setListaAndon(this.listaAndon);
		andon.gerarArquivo(dir, fileName);
	}

	@Override
	public void criarArquivoStatus() {
		
	}

	public TAndonSADTO getListaAndon() {
		return listaAndon;
	}

	public void setListaAndon(TAndonSADTO listaAndon) {
		this.listaAndon = listaAndon;
	}

	public Long getIdPerfilAndon() {
		return idPerfilAndon;
	}

	public void setIdPerfilAndon(Long idPerfilAndon) {
		this.idPerfilAndon = idPerfilAndon;
	}

}
