package ms.coleta.ic.inovastandalone;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import idw.model.pojos.OmCfg;
import idw.util.ArquivoLeitura;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import ms.model.dto.EventoColetado;

public class ProcessaArquivoListaEvento {
	
	/**
	 * @param arquivo
	 * @param log
	 * @param omcfg
	 * @return
	 */
	public static List<EventoColetado> processar(String arquivo, IdwLogger log, OmCfg omcfg) {

		List<EventoColetado> retorno = new ArrayList<>();

		ArquivoLeitura arq = null;
		try {
			arq = new ArquivoLeitura(new FileReader(arquivo));
			String linha = "";

			// Varrer linha  a linha o arquivo
			while (arq.ready()) {
				linha = arq.readLine();
				
				retorno.addAll(ProcessaLinhaEvento.processar(linha, log, omcfg));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info(e);
		} finally {
			try {
				arq.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Apagar o arquivo
		while(!ArquivosDiretorios.delete(arquivo));
		return retorno;
	}
}
