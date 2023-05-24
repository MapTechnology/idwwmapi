package ms.coleta.ic.flex.fornoheller1809;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import idw.util.IdwLogger;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsString;

public class LinhaArquivoForno {
	private IdwLogger log;
	private String linha;
	private String[] linhaSplitada;
	private IcUpDTO icUpDTO;
		
	// Campos do log
	private String dataId = null;
	private String dateTime = null;
	private List<String> pvs = new ArrayList<String>();
	private String linhaResumida = null;
	
	// Dados
	private Date dateDateTime = null;

	public LinhaArquivoForno(IdwLogger log, IcUpDTO icUpDTO, String linha) {
		this.log = log;
		this.icUpDTO = icUpDTO;
		this.linha = linha;
		parseLinhaTratada();
	}

	private void parseLinhaTratada() {
		linhaSplitada = idw.util.UtilsString.quebrarStringEmVetor(linha, "\t").toArray(new String[0]);
		try {
			/* Alessandre em 19-10-22 abaixo o if testava um len de 500 diminui oara 100 */
			if(linhaSplitada.length > 100) {
				dataId = linhaSplitada[0];
				dateTime = linhaSplitada[1];
				// dateDateTime = UtilsString.convertToDateLogSony(dateTime);
				dateDateTime = UtilsString.convertToDateLogFornosHeller(dateTime);
				
				for (int i = 3; i < 70; i++) {
					if (i % 3 == 0) {
						pvs.add(linhaSplitada[i]);
					}
				}
				
				linhaResumida = dataId + "\t" + dateTime;
				for (int i = 0; i < pvs.size(); i++) {
					//linhaResumida = linhaResumida + "\t" + pvs.get(i) + "\t"
					linhaResumida = linhaResumida + " " + pvs.get(i);
							
				}
			}
		} catch (Exception e) {
			log.error("LinhaArquivoData: falha ao realizar parseLinhaTratada() " + e);
		}
	}

	public String getLinha() {
		return linha;
	}

	public boolean isLinhaNoPadraoEsperado() {
		if ((dataId != null) && (!dataId.equals(""))
				&& (dateTime !=null) && (!dateTime.equals(""))
				&& (dateDateTime != null)) {
			return true;
		}
		return false;
	}

	public List<EventoColetado> obtemEvento() {
		List<EventoColetado> retorno = new ArrayList<>();
		
		// ------------------------------------------
		// MedTemp
		List<EventoColetado> eventosMedTemp = geraEventosMedTemp();
		if (eventosMedTemp != null && eventosMedTemp.size() > 0) {
			retorno.addAll(eventosMedTemp);
			log.info("LinhaArquivoForno: Gerou eventos de Medicao de Temperatura:;"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventosMedTemp.get(0).getDthrEvento())
					+ ";" + eventosMedTemp.get(0).getCdop());
		}
		
		//if (retorno.size() > 0)
			//ic.getUltimasLinhasProcessadasForno().put(icUpDTO.getUpDTO().getCd_up(), this);
		
		return retorno;
	}

	// Versao 2.0 do lancamento de temperaturas por zonas para o mesmo posto
	private List<EventoColetado> geraEventosMedTemp() {
		List<EventoColetado> retorno = new ArrayList<>();
		Date dateMedTemp = dateDateTime;
		// A quantidade de icupdto sera igual a 2 vezes o numero de zonas
//		// devido ao TOP e BOTTOM
		int numeroZonas = safeParseToInt(icUpDTO.getUrlAuxiliar());
		if (numeroZonas == 0) {
			log.error("Falha ao obter o numero de zonas para icUpDTO: " + icUpDTO.getUpDTO().getCd_up());
			return retorno;
		}

		if (pvs.size() < numeroZonas * 2)
			return retorno;

		String velocidade = pvs.get(13);
		// A coluna 13 nao e temperatura
		pvs.remove(13);
		// A coluna 12 nao e utilizada quando nao existem 13 zonas
		//String pv12 = pvs.get(12);
		pvs.remove(12);
				
		// TOP + BOTTOM
		for (int i = 0; i < numeroZonas * 2 ; i++ ) {
			EventoColetado eventoColetado = new EventoColetado();
			eventoColetado.setTipoEvento(ServicoFactory._MEDICAO_TEMPERATURA);
			// Como os eventos de med de temperatura sao lancados para o mesmo posto
			// e necessario garantir que a data e hora dos eventos seja diferente
			// eventoColetado.setDthrEvento(dateMedTemp);
			eventoColetado.setDthrEvento(new Date(dateMedTemp.getTime() + i * 10));
			// eventoColetado.setCdop(shopOrder);
			eventoColetado.setOrigem("{zona" + i + "};" + linhaResumida);
			eventoColetado.setZona((new Integer(i)).byteValue());
			eventoColetado.setParametroLido(new BigDecimal(pvs.get(i)));
			//if (safeParseToInt(pvs.get(i)) <= 0 
			if (safeParseToDouble(pvs.get(i)) < 0
					|| safeParseToDouble(pvs.get(i)) > 1000) {
				log.error("Temperatura obtida da linha foi menor que zero: " + pvs.get(i) + "i="
					+ i + linhaResumida);
				continue;
			}
			eventoColetado.setIcUpDTO(icUpDTO);
			retorno.add(eventoColetado);
		}
		
				
		// Cria o evento de medicao de velocidade
		EventoColetado eventoColetado = new EventoColetado();
		eventoColetado.setTipoEvento(ServicoFactory._MEDICAO_VELOCIDADE);
		eventoColetado.setDthrEvento(new Date(dateMedTemp.getTime() + 27 * 10));
		eventoColetado.setOrigem("{Velocidade};" + linhaResumida);
		eventoColetado.setParametroLido(new BigDecimal(velocidade));
		if (safeParseToDouble(velocidade) > 0 ) {
			eventoColetado.setIcUpDTO(icUpDTO);
			retorno.add(eventoColetado);
		}
		
		return retorno;
	}
	
	
//	private List<EventoColetado> geraEventosMedTemp() {		
//		List<EventoColetado> retorno = new ArrayList<>();
//		Date dateMedTemp = dateDateTime;
//		// A quantidade de icupdto sera igual a 2 vezes
//		int numeroZonas = safeParseToInt(icUpDTO.getUrlAuxiliar());
//		if (numeroZonas == 0)
//			numeroZonas = 1;
//
//		if (pvs.size() < numeroZonas)
//			return retorno;
//		
//		// TOP
//		for (int i =0; i < numeroZonas; i++) {
//			EventoColetado eventoColetado = new EventoColetado();
//			
//			eventoColetado.setTipoEvento(ServicoFactory._MEDICAO_TEMPERATURA);
//			eventoColetado.setDthrEvento(new Date(dateMedTemp.getTime() + i * 10));
//			// eventoColetado.setCdop(shopOrder);
//			eventoColetado.setIcUpDTO(icUpDTO);
//			eventoColetado.setOrigem(linhaResumida);
//			
//			eventoColetado.setParametroLido(new BigDecimal(pvs.get(i)));
//			
//			retorno.add(eventoColetado);
//		}
//		
//		if (pvs.size() < numeroZonas * 2 + 2)
//			return retorno;
//		
//		// BOTTOM
//		// PVs 12 e 13 nao sao temperaturas
//		for (int i = numeroZonas + 2; i < numeroZonas * 2 + 2; i++) {
//			EventoColetado eventoColetado = new EventoColetado();
//			
//			eventoColetado.setTipoEvento(ServicoFactory._MEDICAO_TEMPERATURA);
//			eventoColetado.setDthrEvento(new Date(dateMedTemp.getTime() + i * 10));
//			// eventoColetado.setCdop(shopOrder);
//			eventoColetado.setIcUpDTO(icUpDTO);
//			eventoColetado.setOrigem(linhaResumida);
//			
//			eventoColetado.setParametroLido(new BigDecimal(pvs.get(i)));
//			
//			retorno.add(eventoColetado);
//		}
//		
//		return retorno;
//	}
	
	// Ailton: 2018-07-12
	// Legacy: Versao que lancava as temperaturas das zonas separadas
	// por postos
//	private List<EventoColetado> geraEventosMedTemp() {		
//		List<EventoColetado> retorno = new ArrayList<>();
//		Date dateMedTemp = dateDateTime;
//		// A quantidade de icupdto sera igual a 2 vezes o numero de zonas
//		// devido ao TOP e BOTTOM
//		int numeroZonas = safeParseToInt(icUpDTO.getUrlAuxiliar());
//		if (numeroZonas == 0) {
//			log.error("Falha ao obter o numero de zonas para icUpDTO: " + icUpDTO.getUpDTO().getCd_up());
//			return retorno;
//		}
//
//		if (pvs.size() < numeroZonas * 2)
//			return retorno;
//		
//		// Obtem a lista de icupdtos
//		List<IcUpDTO> icUpDTOList = ic.getFornoWatcher().getIcUpDTOList();
//		if (icUpDTOList.size() < 2 * numeroZonas)
//			return retorno;
//		
//		String velocidade = pvs.get(13);
//		// A coluna 13 nao e temperatura
//		pvs.remove(13);
//		// A coluna 12 nao e utilizada quando nao existem 13 zonas
//		if (numeroZonas != 13)
//			pvs.remove(12);
//		
//				
//		
//		// TOP + BOTTOM
//		for (int i = 0; i < numeroZonas * 2 ; i++ ) {
//			EventoColetado eventoColetado = new EventoColetado();
//			eventoColetado.setTipoEvento(ServicoFactory._MEDICAO_TEMPERATURA);
//			// Como os eventos de med de temperatura nao tem problemas com cronologia
//			// nao e necessario garantir que a data e hora dos eventos seja diferente
//			eventoColetado.setDthrEvento(dateMedTemp);
//			// eventoColetado.setDthrEvento(new Date(dateMedTemp.getTime() + i * 10));
//			// eventoColetado.setCdop(shopOrder);
//			eventoColetado.setOrigem(linhaResumida);
//			eventoColetado.setParametroLido(new BigDecimal(pvs.get(i)));
//			// Se i for par a temperatura e top
////			// se nao, e bottom
////			if (i % 2 == 0) {
////				eventoColetado.setIcUpDTO(icUpDTOList.get(i));
////			} else {
////				eventoColetado.setIcUpDTO(icUpDTO);
////			}
//			eventoColetado.setIcUpDTO(icUpDTOList.get(i));
//			retorno.add(eventoColetado);
//		}
//		
//		// Caso o numero de zonas for 13, entao a 13o temperatura top e bottom estao
//		// em posicoes separadas das outras temperaturas
//		if (numeroZonas == 13) {
//			// TOP
//			EventoColetado eventoColetado = new EventoColetado();
////			eventoColetado.setTipoEvento(ServicoFactory._MEDICAO_TEMPERATURA);
////			eventoColetado.setDthrEvento(dateMedTemp);
////			eventoColetado.setOrigem(linhaResumida);
////			eventoColetado.setParametroLido(new BigDecimal(pvs.get(12)));
////			eventoColetado.setIcUpDTO(icUpDTOList.get(12));
////			retorno.add(eventoColetado);
//			
//			// BOTTOM
//			if(pvs.size() > 55 ) {
//				eventoColetado = new EventoColetado();
//				eventoColetado.setTipoEvento(ServicoFactory._MEDICAO_TEMPERATURA);
//				eventoColetado.setDthrEvento(dateMedTemp);
//				eventoColetado.setOrigem(linhaResumida);
//				eventoColetado.setParametroLido(new BigDecimal(pvs.get(55)));
//				eventoColetado.setIcUpDTO(icUpDTOList.get(icUpDTOList.size() - 1));
//				retorno.add(eventoColetado);
//			}
//			
//		}
//		return retorno;
//	}
	

//	private EventoColetado geraEventoMedTemp() {
//		Date dateMedTemp = dateDateTime;
//		
//		EventoColetado eventoColetado = new EventoColetado();
//		
//		eventoColetado.setTipoEvento(ServicoFactory._MEDICAO_TEMPERATURA);
//		eventoColetado.setDthrEvento(dateMedTemp);
//		// eventoColetado.setCdop(shopOrder);
//		eventoColetado.setCdop("OP_FORNO");
//		eventoColetado.setIcUpDTO(icUpDTO);
//		eventoColetado.setOrigem(linhaResumida);
//		eventoColetado.setParametroLido(new BigDecimal(pvs.get(0)));
//		
//		return eventoColetado;
//	}

	int safeParseToInt(String valor) {
		int retorno = 0;
		try {
			retorno = Integer.parseInt(valor);
		} catch (Exception e) {
			log.error("Falha ao realizar o parser do valor: " + valor + " da linha " + toString());
			log.error("Excecao: " + e.toString());
			retorno = 0;
		}
		return retorno;
	}
	
	double safeParseToDouble(String valor) {
		double retorno;
		try {
			retorno = Double.parseDouble(valor);
		} catch (Exception e) {
			log.error("Falha ao realizar o parser do valor: " + valor + " da linha " + toString());
			log.error("Excecao: " + e.toString());
			retorno = 0;
		}
		return retorno;
	}
}
