package ms.coleta.ic.inovastandalone;

import idw.model.rn.DataHoraRN;
import idw.util.ArquivoLeitura;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import ms.coleta.Stubedelegate;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;

public class ProcessaLoginout {

	public List<EventoColetado> processar(String displog, IdwLogger log) {
		/*
		dspt,LOGINOPERADOR,2013-11-18 14:14:00,FFFFFFFFF, senha
		LOGINSUPERVISOR,2013-11-18 14:14:00,FFFFFFFFF, senha
		LOGOUTOPERADOR,2013-11-18 14:14:00,FFFFFFFFF, senha
		LOGOUTSUPERVISOR,2013-11-18 14:14:00,FFFFFFFFF, senha
		 */
		List<EventoColetado> retorno = new ArrayList<EventoColetado>();
		
		//  Abrir arquivo displog
		ArquivoLeitura arq = null;
		try {
			arq = new ArquivoLeitura(new FileReader(displog));
			String linha = "";
			String comando = "";
			String dthr = "";
			Date dthrEvento;
			String complemento = "";
			
			// Varrer linha  a linha o arquivo
			while (arq.ready()) {
				linha = arq.readLine();
				if (linha == null || linha.equals("") || (linha.charAt(0)==0x00))
					continue;
				
				log.info("Processando linha [" + linha + "]");
				//System.out.println("Processando linha [" + linha + "]");

				//List<String> linhaQuebrada = UtilsString.quebrarStringEmVetor(linha, ",");
				List<String> linhaQuebrada = Arrays.asList(linha.split(","));
				
				comando = linhaQuebrada.get(1);
				dthr = linhaQuebrada.get(2);
				if (linhaQuebrada.size() > 3) {
					complemento = linhaQuebrada.get(3);
				}
				dthrEvento = DataHoraRN.stringToDate(dthr, "yyyy-MM-dd HH:mm:ss.SSS");
				
				EventoColetado evento = new EventoColetado();
				evento.setTipoEvento(getTipoEvento(comando, complemento));
				evento.setDthrEvento(dthrEvento);
				evento.setOrigem(complemento);
				evento.setIcUpDTO(Stubedelegate.getInstancia().getMsthread().getIcUp(linhaQuebrada.get(0)));
				evento.setLogin(complemento);
				evento.setSenha(linhaQuebrada.get(4));
				log.info("SETSENHA - SENHA: " + linhaQuebrada.get(4)+ " END.");
				//System.out.println("SETSENHA - SENHA: " + linhaQuebrada.get(4)+ " END.");
				evento.setLog(log);
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

		// Apagar o arquivo loginout
		/*Esta dentro do while pois deletava o arquivo apenas na segunda vez que passava neste ponto*/
		while(!ArquivosDiretorios.delete(displog));
		return retorno;
	}
	
	private int getTipoEvento(String comando, String complemento) {
		int retorno = -1;
		if (comando.equals("LOGINOPERADOR")) {
			retorno = ServicoFactory._LOGIN;
		} else if (comando.equals("LOGOUTOPERADOR")) {
			retorno = ServicoFactory._LOGOUT;
		}
		
		return retorno;
	}
}
