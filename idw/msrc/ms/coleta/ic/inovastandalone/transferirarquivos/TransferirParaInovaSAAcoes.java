package ms.coleta.ic.inovastandalone.transferirarquivos;

import idw.model.pojos.DwTAcao;
import idw.util.ArquivosDiretorios;

public class TransferirParaInovaSAAcoes extends TransferirParaInovaSAFactory{
	private DwTAcao dwtacao = null;
	
	@Override
	public void criarArquivo() {

		String urlConexao = msmsicup.getMsIc().getUrlConexao();

		try {
			urlConexao = urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (IndexOutOfBoundsException e){
			urlConexao = msmsicup.getMsIc().getUrlConexao();
		}
		String dir = getDiretorioDestino() + "/" + urlConexao + "/reg/acao/";

		String fileName = "aca" + dwtacao.getOmTppt().getIdTppt() + "-" + dwtacao.getCdTacao();
		
		// Se o arquivo existir nao precisa criar denovo
		if(ArquivosDiretorios.isExisteArquivo(fileName) == true)
			return;
		
		log.info("Gerando arquivo em " + dir + fileName);
		
		ArquivoAcoes acoes = new ArquivoAcoes();
		acoes.setLog(log);
		acoes.setDwtacao(dwtacao);
		acoes.gerarArquivo(dir, fileName);
	}

	@Override
	public void criarArquivoStatus() {
		// TODO Auto-generated method stub
		
	}

	public DwTAcao getDwtacao() {
		return dwtacao;
	}

	public void setDwtacao(DwTAcao dwtacao) {
		this.dwtacao = dwtacao;
	}


}
