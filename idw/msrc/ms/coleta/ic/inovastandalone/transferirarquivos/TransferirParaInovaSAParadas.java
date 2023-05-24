package ms.coleta.ic.inovastandalone.transferirarquivos;

import ms.coleta.dto.SessaoUPDTO;
import idw.model.pojos.DwTParada;
import idw.util.ArquivosDiretorios;

public class TransferirParaInovaSAParadas extends TransferirParaInovaSAFactory {

	private DwTParada dwtparada=null;
	private SessaoUPDTO sessaoUP=null;
	
	@Override
	public void criarArquivo() {
		// TODO Auto-generated method stub
		
		String urlConexao = msmsicup.getMsIc().getUrlConexao();
		
		try {
			urlConexao = urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (IndexOutOfBoundsException e){
			urlConexao = msmsicup.getMsIc().getUrlConexao();
		}
		String dir = getDiretorioDestino() + "/" + urlConexao + "/reg/parada/";
		
		String fileName = "par" + dwtparada.getOmTppt().getIdTppt() + "-" + dwtparada.getCdTparada();
		
		// Se o arquivo existir nao precisa criar denovo
		if(ArquivosDiretorios.isExisteArquivo(dir + fileName) == true)
			return;
		
		log.info("Gerando arquivo em " + dir + fileName);
		
		ArquivoParadas paradas = new ArquivoParadas();
		paradas.setLog(log);
		paradas.setDwtparada(dwtparada);
		paradas.gerarArquivo(dir, fileName);
		
	}

	@Override
	public void criarArquivoStatus() {
		String urlConexao = msmsicup.getMsIc().getUrlConexao();
		
		try {
			urlConexao = urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (IndexOutOfBoundsException e){
			urlConexao = msmsicup.getMsIc().getUrlConexao();
		}
		String dir = getDiretorioDestino() + "/" + urlConexao + "/status/parada/";
		
		String fileName = "par" + sessaoUP.getIdPt();
		
		log.info("Gerando arquivo em " + dir + fileName);
		
		ArquivoParadas paradas = new ArquivoParadas();
		paradas.setLog(log);
		paradas.setSessaoParada(sessaoUP.getParada());
		paradas.gerarArquivoStatus(dir, fileName);
		
	}

	public DwTParada getDwtparada() {
		return dwtparada;
	}

	public void setDwtparada(DwTParada dwtparada) {
		this.dwtparada = dwtparada;
	}

	public SessaoUPDTO getSessaoUP() {
		return sessaoUP;
	}

	public void setSessaoUP(SessaoUPDTO sessaoUP) {
		this.sessaoUP = sessaoUP;
	}

}
