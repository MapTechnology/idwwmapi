package ms.coleta.ic.inovastandalone;

import ms.model.dto.IcUpDTO;
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

import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;

public class ProcessaHeartbeat{

	public List<EventoColetado> processar(String heartbeat, IdwLogger log , IcUpDTO icupdto) {
		/*
			2013-11-11 14:00:00,VERSAOLINUX,VERSAOALTUS
		*/
		List<EventoColetado> retorno = new ArrayList<EventoColetado>();
		
		//  Abrir arquivo displog
		ArquivoLeitura arq = null;
		try {
			arq = new ArquivoLeitura(new FileReader(heartbeat));
			String linha = "";
			String dthr = "";
			Date dthrEvento;
			
			// Varrer linha  a linha o arquivo
			while (arq.ready()) {
				linha = arq.readLine();
				if (linha == null || linha.equals("") || (linha.charAt(0)==0x00))
					continue;
				
				log.info("Processando linha [" + linha + "]");
				//System.out.println("Processando linha [" + linha + "]");

				List<String> linhaQuebrada = UtilsString.quebrarStringEmVetor(linha, ",");
				
				dthr = linhaQuebrada.get(0);
				dthrEvento = DataHoraRN.stringToDate(dthr, "yyyy-MM-dd HH:mm:ss.SSS");
				
				EventoColetado evento = new EventoColetado();
				evento.setTipoEvento(ServicoFactory._IC_HEART_BEAT);
				evento.setDthrEvento(dthrEvento);
				//System.out.println(dthrEvento);
				//TODO DENIS : adicionar UPDTO
				evento.setExisteEvento(true);
				evento.setIcUpDTO(icupdto);
				if (evento.getTipoEvento() >= 0)
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

		// Apagar o arquivo heartbeat
		/*Esta dentro do while pois deletava o arquivo apenas na segunda vez que passava neste ponto*/
		while(!ArquivosDiretorios.delete(heartbeat));
		return retorno;
	}
}
