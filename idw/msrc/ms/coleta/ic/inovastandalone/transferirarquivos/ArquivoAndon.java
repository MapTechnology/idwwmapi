package ms.coleta.ic.inovastandalone.transferirarquivos;

import idw.util.IdwLogger;

import ms.coleta.dto.AndonSADTO;
import ms.coleta.dto.TAndonSADTO;

public class ArquivoAndon {
	
	private TAndonSADTO listaAndon;
	private Long idPerfilAndon;
	private IdwLogger log;
	
	public boolean gerarArquivo(String diretorio, String nomeArquivo) {
		ArquivoInovaSA arquivoInovaSA = new ArquivoInovaSA(diretorio, nomeArquivo, log);
		
		if(arquivoInovaSA.openOrCreateFile() == false)
			return false;

		arquivoInovaSA.addLineToBeWritten(""+idPerfilAndon);
		if (this.listaAndon != null && this.listaAndon.getListaAndonSA() != null) {
			for(AndonSADTO andon : this.listaAndon.getListaAndonSA()){
				arquivoInovaSA.addLineToBeWritten( andon.getLinha() );
			}
		}
		
		if(arquivoInovaSA.writeLinesToFile() == false) {
			arquivoInovaSA.close();
			return false;
		}
		
		if(arquivoInovaSA.close() == false)
			return false;
		
		return true;
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

	public IdwLogger getLog() {
		return log;
	}

	public void setLog(IdwLogger log) {
		this.log = log;
	}
	

}
