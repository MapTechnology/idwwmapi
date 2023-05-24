package ms.coleta.ic.inovastandalone.transferirarquivos;

import idw.model.pojos.DwTCausa;
import idw.util.ArquivosDiretorios;

public class TransferirParaInovaSACausas extends TransferirParaInovaSAFactory{

	private DwTCausa dwtcausa = null;
	
	@Override
	public void criarArquivo() {

		String urlConexao = msmsicup.getMsIc().getUrlConexao();

		try {
			urlConexao = urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (IndexOutOfBoundsException e){
			urlConexao = msmsicup.getMsIc().getUrlConexao();
		}
		String dir = getDiretorioDestino() + "/" + urlConexao + "/reg/causa/";

		String fileName = "cau" + dwtcausa.getOmTppt().getIdTppt() + "-" + dwtcausa.getCd();

		// Se o arquivo existir nao precisa criar denovo
		if(ArquivosDiretorios.isExisteArquivo(dir+fileName) == true)
			return;
		
		log.info("Gerando arquivo em " + dir+fileName);
		
		ArquivoCausas causas = new ArquivoCausas();
		causas.setLog(log);
		causas.setDwtcausa(dwtcausa);
		causas.gerarArquivo(dir, fileName);
	}

	@Override
	public void criarArquivoStatus() {
		// TODO Auto-generated method stub
		
	}

	public DwTCausa getDwtcausa() {
		return dwtcausa;
	}

	public void setDwtcausa(DwTCausa dwtcausa) {
		this.dwtcausa = dwtcausa;
	}


}
