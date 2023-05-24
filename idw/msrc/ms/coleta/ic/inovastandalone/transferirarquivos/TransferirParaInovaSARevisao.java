package ms.coleta.ic.inovastandalone.transferirarquivos;

import idw.model.pojos.MsMsicup;
import idw.util.IdwLogger;


public class TransferirParaInovaSARevisao extends TransferirParaInovaSAFactory{

	public TransferirParaInovaSARevisao(MsMsicup msmsicup, IdwLogger log, String dirDestino) {
		super();
		setLog(log);
		setMsmsicup(msmsicup);
		setDiretorioDestino(dirDestino);
	}
	
	@Override
	public void criarArquivo() {

		String urlConexao = msmsicup.getMsIc().getUrlConexao();
		try {
			urlConexao = urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (IndexOutOfBoundsException e) {
			urlConexao = msmsicup.getMsIc().getUrlConexao();
		}
		
		String dir = getDiretorioDestino() + "/" + urlConexao + "/reg/revisao/";

		String fileName = "revisao.ini";

		log.info("Gerando arquivo em " + dir + fileName);
		
		ArquivoRevisao revisao = new ArquivoRevisao();
		revisao.setLog(log);
		revisao.gerarArquivo(dir, fileName);
	}

	@Override
	public void criarArquivoStatus() {
		
	}

}
