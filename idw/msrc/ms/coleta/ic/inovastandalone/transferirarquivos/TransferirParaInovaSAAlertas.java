package ms.coleta.ic.inovastandalone.transferirarquivos;

import ms.coleta.dto.SessaoUPDTO;
import idw.model.pojos.DwTAlerta;
import idw.util.ArquivosDiretorios;

public class TransferirParaInovaSAAlertas extends TransferirParaInovaSAFactory {

	private DwTAlerta dwtalerta = null;
	
	private SessaoUPDTO sessaoUP;

	@Override
	public void criarArquivo() {

		String urlConexao = msmsicup.getMsIc().getUrlConexao();

		try {
			urlConexao = urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (IndexOutOfBoundsException e){
			urlConexao = msmsicup.getMsIc().getUrlConexao();
		}
		String dir = getDiretorioDestino() + "/" + urlConexao + "/reg/alerta/";

		String fileName = "ale" + dwtalerta.getOmTppt().getIdTppt() + "-" + dwtalerta.getCdTalerta();

		// Se o arquivo existir nao precisa criar denovo
		if(ArquivosDiretorios.isExisteArquivo(dir + fileName) == true)
			return;
		
		log.info("Gerando arquivo em " + dir + fileName);

		ArquivoAlertas alertas = new ArquivoAlertas();
		alertas.setLog(log);
		alertas.setDwtalerta(dwtalerta);
		alertas.gerarArquivo(dir, fileName);

	}

	public void criarArquivoStatus() {
		String urlConexao = msmsicup.getMsIc().getUrlConexao();

		try {
			urlConexao = urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (IndexOutOfBoundsException e){
			urlConexao = msmsicup.getMsIc().getUrlConexao();
		}
		String dir = getDiretorioDestino() + "/" + urlConexao + "/status/alerta/";
		
		String fileName = "ale" + sessaoUP.getIdPt();
		
		log.info("Gerando arquivo em " + dir + fileName);
		
		ArquivoAlertas alertas = new ArquivoAlertas();
		alertas.setLog(log);
		alertas.setAlertasDTO(sessaoUP.getAlertas().getListaAlertas());
		alertas.gerarArquivoStatus(dir, fileName);

	}
	
	public DwTAlerta getDwtalerta() {
		return dwtalerta;
	}

	public void setDwtalerta(DwTAlerta dwtalerta) {
		this.dwtalerta = dwtalerta;
	}

	public SessaoUPDTO getSessaoUP() {
		return sessaoUP;
	}

	public void setSessaoUP(SessaoUPDTO sessaoUP) {
		this.sessaoUP = sessaoUP;
	}
	
}
