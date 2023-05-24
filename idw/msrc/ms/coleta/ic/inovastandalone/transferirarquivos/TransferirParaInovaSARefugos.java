package ms.coleta.ic.inovastandalone.transferirarquivos;

import ms.coleta.dto.SessaoUPDTO;
import idw.model.pojos.DwTRefugo;
import idw.model.pojos.OmPt;
import idw.util.ArquivosDiretorios;

public class TransferirParaInovaSARefugos extends TransferirParaInovaSAFactory {
	
	private DwTRefugo dwtrefugo = null;
	private OmPt ompt = null;
	private SessaoUPDTO sessaoUP;
	
	@Override
	public void criarArquivo() {
		String urlConexao = msmsicup.getMsIc().getUrlConexao();
		
		try {
			urlConexao = urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (IndexOutOfBoundsException e){
			urlConexao = msmsicup.getMsIc().getUrlConexao();
		}
		String dir = getDiretorioDestino() + "/" + urlConexao + "/reg/refugo/";		
		
		String fileName = "ref" + dwtrefugo.getOmTppt().getIdTppt() + "-" + dwtrefugo.getCdTrefugo();
		
		// Se o arquivo existir nao precisa criar denovo
		if(ArquivosDiretorios.isExisteArquivo(dir + fileName) == true)
			return;
		
		log.info("Gerando arquivo em " + dir + fileName);	
		
		ArquivoRefugos refugos = new ArquivoRefugos();
		refugos.setLog(log);
		refugos.setDwtrefugo(dwtrefugo);
		refugos.setOmpt(ompt);
		refugos.gerarArquivo(dir, fileName);
		
	}

	@Override
	public void criarArquivoStatus() {
		String urlConexao = msmsicup.getMsIc().getUrlConexao();
		
		try {
			urlConexao = urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (IndexOutOfBoundsException e){
			urlConexao = msmsicup.getMsIc().getUrlConexao();
		}
		String dir = getDiretorioDestino() + "/" + urlConexao + "/status/refugo/";
		
		String fileName = "ref" + sessaoUP.getIdPt();
		
		log.info("Gerando arquivo em " + dir + fileName);
		
		ArquivoRefugos refugos = new ArquivoRefugos();
		refugos.setLog(log);
		refugos.setRefugoDTO(sessaoUP.getRefugo());
		refugos.gerarArquivoStatus(dir, fileName);
	}

	public DwTRefugo getDwtrefugo() {
		return dwtrefugo;
	}

	public void setDwtrefugo(DwTRefugo dwtrefugo) {
		this.dwtrefugo = dwtrefugo;
	}

	public OmPt getOmpt() {
		return ompt;
	}

	public void setOmpt(OmPt ompt) {
		this.ompt = ompt;
	}

	public SessaoUPDTO getSessaoUP() {
		return sessaoUP;
	}

	public void setSessaoUP(SessaoUPDTO sessaoUP) {
		this.sessaoUP = sessaoUP;
	}

}
