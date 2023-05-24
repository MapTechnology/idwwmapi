package ms.coleta.ic.flex;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent.Kind;

import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.model.dto.IcUpDTO;

public abstract class AbstractWatcherTrigger {
	
	protected IcUpDTO icup;
	protected IdwLogger log;
	protected int idLog;

	protected boolean isCopiarArquivo = true;
	
	// Metodo que informa se o arquivo é valido ou nao para processamento
	protected abstract boolean isArquivoValido(String arquivo);

	// Metodo que fara o tratamento do arquivo que dependera do tipo dele
	protected abstract void tratarArquivo(Path destino);

	protected abstract void copiarArquivo(String origem, Path destino) throws IOException;
	
	public void tratarArquivo(Kind kind, String origem) {
		// Verificar se é um arquivo válido
		if (isArquivoValido(origem)) {
			// Se for, entao copiar para o diretorio de trabalho
			Path destino = null;
			if (isCopiarArquivo) {
				try {
					log.info(idLog, 0, "Verificando se existe origem " + origem);
					if (ArquivosDiretorios.isExisteArquivo(origem)) {
						log.info(idLog, 0, "Preparando destino para origem " + origem);
						destino = getArquivoDestivo(origem);
						log.info(idLog, 0, "Copiando " + origem.toString() + " para " + destino.toString());

						
						copiarArquivo(origem, destino);
					} else {
						log.info(idLog, 0, "Arquivo nao existe " + origem.toString());
						return;
					}
				} catch (Exception e) {
					e.printStackTrace();
					log.info(idLog, 0, "AbstractWatcherTrigger.tratarArquivo. Erro na copia " + origem.toString(), e);
					return;
				}
			} else {
				log.info(idLog, 0, "O arquivo " + origem + " nao será copiado para destino");
				destino = Paths.get(origem);
			}
			// Tratar o arquivo copiado
			tratarArquivo(destino);
		} else {
			log.info(idLog, 0, "Arquivo ignorado " + origem.toString());
		}
	}
	
	public void tratarArquivo(int kind, String origem, IcUpDTO icup) {
		if (!ArquivosDiretorios.isICUsaAD(icup)) {
			tratarArquivo(null, origem);
		} else {
			origem = ArquivosDiretorios.ajustaPathSMB(origem);
			// Verificar se é um arquivo válido
			if (isArquivoValido(origem)) {
				// Se for, entao copiar para o diretorio de trabalho
				Path destino = null;
				if (isCopiarArquivo) {
					try {
						log.info(idLog, 0, "Verificando se existe origem " + origem);
						if (ArquivosDiretorios.isExisteArquivoSMB(origem, icup.getIc().getLoginAD(), icup.getIc().getSernhaAD())) {
							log.info(idLog, 0, "Preparando destino para origem " + origem);
							destino = getArquivoDestivo(origem);
							log.info(idLog, 0, "Copiando " + origem.toString() + " para " + destino.toString());

							copiarArquivo(origem, destino);
						} else {
							log.info(idLog, 0, "Arquivo nao existe " + origem.toString());
							return;
						}
					} catch (Exception e) {
						e.printStackTrace();
						log.info(idLog, 0, "AbstractWatcherTrigger.tratarArquivo. Erro na copia " + origem.toString(), e);
						return;
					}
				} else {
					log.info(idLog, 0, "O arquivo " + origem + " nao será copiado para destino");
					destino = Paths.get(origem);
				}
				// Tratar o arquivo copiado
				tratarArquivo(destino);
			} else {
				log.info(idLog, 0, "Arquivo ignorado " + origem.toString());
			}
		}
	}
	
	public void setIcUpDTO(IcUpDTO icup, IdwLogger log, int idLog) {
		this.icup = icup;
		this.log = log;
		this.idLog = idLog;
	}
	

	protected Path getArquivoDestivo(String arquivo) {
		String origem = arquivo;
		String destino = Stubedelegate.getInstancia().getMsthread().getPathCacheColeta();
		String origemAux = "";
		String[] origemSplit = null;
		
		log.info(idLog, 0, "destino = " + destino);
		
		if (origem.split("\\\\").length > 1 ){
			 origemSplit = origem.split("\\\\");
			 
		}
		
		if (origem.split("/").length > 1 ){
			 origemSplit = origem.split("/");
			 
		}
		
		origemAux = origemSplit[origemSplit.length-1];
		if (destino == null || destino.equals("")) {
			log.info(idLog, 0, "getArquivoDestivo: Nao foi possivel obter o caminho destino para arquivo" + arquivo.toString());
		}

		destino = destino + icup.getUpDTO().getCd_up();

		ArquivosDiretorios.criarDiretorioSeNaoexistir(destino);
		
		
		destino = destino +  "/" + origemAux;
		
		Path retorno = Paths.get(destino);
		
		return retorno;
	}
}
