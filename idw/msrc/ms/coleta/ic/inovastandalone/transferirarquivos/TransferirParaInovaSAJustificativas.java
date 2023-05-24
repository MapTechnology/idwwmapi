package ms.coleta.ic.inovastandalone.transferirarquivos;

import idw.model.pojos.DwTJust;
import idw.util.ArquivosDiretorios;

public class TransferirParaInovaSAJustificativas extends TransferirParaInovaSAFactory{
	private DwTJust dwtjust = null;
	
	@Override
	public void criarArquivo() {

		String urlConexao = msmsicup.getMsIc().getUrlConexao();

		try {
			urlConexao = urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (IndexOutOfBoundsException e){
			urlConexao = msmsicup.getMsIc().getUrlConexao();
		}
		String dir = getDiretorioDestino() + "/" + urlConexao + "/reg/justificativa/";

		String fileName = "jus" + dwtjust.getOmTppt().getIdTppt() + "-" + dwtjust.getCd();

		// Se o arquivo existir nao precisa criar denovo
		if(ArquivosDiretorios.isExisteArquivo(dir + fileName) == true)
			return;
		
		log.info("Gerando arquivo em " + dir + fileName);
		
		ArquivoJustificativas justificativas = new ArquivoJustificativas();
		justificativas.setLog(log);
		justificativas.setDwtjust(dwtjust);
		justificativas.gerarArquivo(dir, fileName);
	}

	@Override
	public void criarArquivoStatus() {
		// TODO Auto-generated method stub
		
	}

	public DwTJust getDwtjust() {
		return dwtjust;
	}

	public void setDwtjust(DwTJust dwtjust) {
		this.dwtjust = dwtjust;
	}
}
