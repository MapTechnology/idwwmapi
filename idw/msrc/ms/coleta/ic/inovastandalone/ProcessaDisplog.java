package ms.coleta.ic.inovastandalone;

import idw.model.rn.DataHoraRN;
import idw.util.ArquivoLeitura;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import idw.util.UtilsString;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ms.coleta.Stubedelegate;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

/*
 * Essa classe processa os eventos dispLog - Log de dispositivos que contem quando um dispositivo foi ativado e desativado
 * Para o inova standalone at� o momento n�o existe esse recurso
 * Um dispositivo pode ser qq coisa gerenciada pelo inova, transdutor, motor, esteira, chave, etc
 */
public class ProcessaDisplog {

	public List<EventoColetado> processar(String displog, IdwLogger log) {
		/*
		 * 	OFF,2013-11-18 14:14:00,COD --> O dispositivo COD ficou offline. No momento COD sera o codigo do dispositivo 2oTRANSDUTOR
			MANUAL,2013-11-18 14:14:00   --> posto foi para manual
			AUTOMATICO,2013-11-18 14:14:00 --> posto foi para automatico
			ON,2013-11-18 14:14:00,COD --> o 2oTRANSDUTOR voltou para online
			OFF,2013-11-18 14:14:00,ALTUS --> o altus do posto ficou offline, ou seja, o UNO nao consegue se comunicar com ele
			ON,2013-11-18 14:14:00,ALTUS --> o altus do posto voltou para online
		 */
		List<EventoColetado> retorno = new ArrayList<>();
		
		//  Abrir arquivo displog
		ArquivoLeitura arq = null;
		try {
			arq = new ArquivoLeitura(new FileReader(displog));
			String linha = "";
			String comando = "";
			String dthr = "";
			Date dthrEvento;
			String complemento = "";
			String stridpt="";
			String cdPt = null;
			
			// Varrer linha  a linha o arquivo
			while (arq.ready()) {
				linha = arq.readLine();
				if (linha == null || linha.equals("") || (linha.charAt(0)==0x00))
					continue;
				
				log.info("Processando linha [" + linha + "]");

				List<String> linhaQuebrada = UtilsString.quebrarStringEmVetor(linha, ",");
				
				comando = linhaQuebrada.get(0);
				dthr = linhaQuebrada.get(1);
				if (linhaQuebrada.size() > 2) {
					complemento = linhaQuebrada.get(2);
				}
				if (linhaQuebrada.size() > 3) {
					stridpt = linhaQuebrada.get(3);
					cdPt=stridpt;
				}
				dthrEvento = DataHoraRN.stringToDate(dthr, "yyyy-MM-dd HH:mm:ss.SSS");
				
				EventoColetado evento = new EventoColetado();
				evento.setTipoEvento(getTipoEvento(comando, complemento));
				evento.setDthrEvento(dthrEvento);
				
				// Identifica a maquina atraves de idPt
				IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(cdPt);

				evento.setIcUpDTO(icupdto);
				
				if (evento.getTipoEvento() > 0)
					retorno.add(evento);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				arq.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Apagar o arquivo displog
		/*Esta dentro do while pois deletava o arquivo apenas na segunda vez que passava neste ponto*/
		while(!ArquivosDiretorios.delete(displog));
		return retorno;
	}
	
	private int getTipoEvento(String comando, String complemento) {
		int retorno = -1;
		return retorno;
	}
}
