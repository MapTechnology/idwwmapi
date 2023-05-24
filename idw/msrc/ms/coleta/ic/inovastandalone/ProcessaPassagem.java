package ms.coleta.ic.inovastandalone;

import idw.model.pojos.OmCfg;
import idw.model.rn.DataHoraRN;
import idw.util.ArquivoLeitura;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import idw.util.Util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ms.coleta.Stubedelegate;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;

public class ProcessaPassagem {

	private EventoColetado evento = new EventoColetado();
	
	public List<EventoColetado> processar(String arqReceita, IdwLogger log, OmCfg omcfg) {
		/*
		 * 2014-10-27 18:03:10.210,'&$t1turn150000091234
		 * YYYY-MM-DD HH:MM:SS.MMM,BARCODE
		 * idpt,dspt,dthr,barcode
		 */
		/*
			[DADOS]
			idpt=
			cb=
			idreceita=
			dthrinicio =
			dthrfim =
		 */
		List<EventoColetado> retorno = new ArrayList<>();

		evento.setTipoEvento(ServicoFactory._PASSAGEM);

		//  Abrir arquivo displog
		ArquivoLeitura arq = null;
		try {
			arq = new ArquivoLeitura(new FileReader(arqReceita));
			String linha = "";

			// Varrer linha  a linha o arquivo
			while (arq.ready()) {
				linha = arq.readLine();
				
				if (linha == null || linha.equals("") || linha.trim().equals("") || linha.charAt(0)==0x00)
					continue;
				
				log.info("Processando linha [" + linha + "]");
				String[] elementosLinha = linha.split(",");

				evento.setIcUpDTO(Stubedelegate.getInstancia().getMsthread().getIcUp(elementosLinha[1]));
				evento.setOrigem(elementosLinha[3]);
				evento.setDthrEvento(DataHoraRN.stringToDate(elementosLinha[2], "yyyy-MM-dd HH:mm:ss.SSS"));
				evento.setCdop(Util.extraiPorMascara(elementosLinha[3], omcfg.getMascaraop()));
				evento.setCdproduto(Util.extraiPorMascara(elementosLinha[3], omcfg.getMascaracdprodutoCB()));
				//System.out.println("CDPRODUTO=" + evento.getCdproduto() + "MASCARA=" + omcfg.getMascaracdprodutoCB() + " elemento=" + elementosLinha[3]);
				evento.setQtde(Util.extraiPorMascara(elementosLinha[3], omcfg.getMascaraQtd()));

				if (evento.getTipoEvento() >= 0)
					retorno.add(evento);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info(e);
		} catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
			log.info(e);
		} catch (IndexOutOfBoundsException e) {
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
		
		// Apagar o arquivo displog
		ArquivosDiretorios.delete(arqReceita);
		return retorno;
	}
}
