package ms.coleta.ic.inovastandalone.transferirarquivos;

import ms.coleta.dto.SessaoUPDTO;
import idw.model.pojos.DwTRitmo;
import idw.util.ArquivosDiretorios;

public class TransferirParaInovaSARitmos extends TransferirParaInovaSAFactory{
	private DwTRitmo dwtritmo = null;
	private SessaoUPDTO sessaoUP = null;
	
	@Override
	public void criarArquivo() {
		if(dwtritmo == null)
			return;

		String urlConexao = msmsicup.getMsIc().getUrlConexao();

		try {
			urlConexao = urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (IndexOutOfBoundsException e){
			urlConexao = msmsicup.getMsIc().getUrlConexao();
		}
		String dir = getDiretorioDestino() + "/" + urlConexao + "/reg/ritmo/";

		String fileName = "rit" + dwtritmo.getOmTppt().getIdTppt() + "-" + dwtritmo.getCd();
		
		// Se o arquivo existir nao precisa criar denovo
		if(ArquivosDiretorios.isExisteArquivo(dir + fileName) == true)
			return;
		
		log.info("Gerando arquivo em " + dir + fileName);
		
		ArquivoRitmos ritmos = new ArquivoRitmos();
		ritmos.setLog(log);
		ritmos.setDwtritmo(dwtritmo);
		ritmos.gerarArquivo(dir, fileName);
	}

	@Override
	public void criarArquivoStatus() {
		if(sessaoUP == null || sessaoUP.getVarRitmo() == null )
			return;
		
		String urlConexao = msmsicup.getMsIc().getUrlConexao();
		
		try {
			urlConexao = urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (IndexOutOfBoundsException e){
			urlConexao = msmsicup.getMsIc().getUrlConexao();
		}
		String dir = getDiretorioDestino() + "/" + urlConexao + "/status/ritmo/";
		
		String fileName = "rit" + sessaoUP.getIdPt();
		
		log.info("Gerando arquivo em " + dir + fileName);
		
		ArquivoRitmos ritmos = new ArquivoRitmos();
		ritmos.setLog(log);
		ritmos.setVarRitmoDTO(sessaoUP.getVarRitmo());
		ritmos.gerarArquivoStatus(dir, fileName);
	}

	public DwTRitmo getDwtritmo() {
		return dwtritmo;
	}

	public void setDwtritmo(DwTRitmo dwtritmo) {
		this.dwtritmo = dwtritmo;
	}

	public SessaoUPDTO getSessaoUP() {
		return sessaoUP;
	}

	public void setSessaoUP(SessaoUPDTO sessaoUP) {
		this.sessaoUP = sessaoUP;
	}

}
