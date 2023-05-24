package ms.coleta.ic.flex.fornoheller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsString;

public class LinhaArquivoFornoHeller {
	private IdwLogger log;
	private String nomeArquivo;
	private String linha;
	private String[] linhaSplitada;
	private IcUpDTO icUpDTO;
	
	// Campos do log
	private String dataId = null;
	private String dateTime = null;
	private List<String> pvs = new ArrayList<String>();
	private List<String> ops = new ArrayList<String>();
	private String linhaResumida = null;
	// Dados
	private Date dateDateTime = null;

	public LinhaArquivoFornoHeller(IdwLogger log, IcUpDTO icupdto, String linhaArquivo, String nomeArquivo) {
		super();
		this.log = log;
		this.icUpDTO = icupdto;
		this.linha = linhaArquivo;
		this.nomeArquivo = nomeArquivo;
	}

	public List<EventoColetado> obtemEvento() {
		List<EventoColetado> retorno = new ArrayList<>();
		try {
			if (linha != null) {
				retorno = processarLinha();
			}
		} catch (Exception e) {
			log.info("LinhaArquivoFornoHeller: Excessao em obtemEvento da maquina: " + icUpDTO.getUpDTO().getCd_up() + " - " + e);
		}
		return retorno;
	}

	private List<EventoColetado> processarLinha() {
		List<EventoColetado> retorno = new ArrayList<>();
		parseLinhaTratada();
		
		List<EventoColetado> eventosMedTemp = geraEventosMedTemp();
		if (eventosMedTemp != null && eventosMedTemp.size() > 0) {
			retorno.addAll(eventosMedTemp);
			log.info("LinhaArquivoData: Gerou eventos de Medicao de Temperatura:;"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventosMedTemp.get(0).getDthrEvento())
					+ ";" + eventosMedTemp.get(0).getCdop());
		}
		return retorno;
	}
	
	private void parseLinhaTratada() {
		linhaSplitada = idw.util.UtilsString.quebrarStringEmVetor(linha, "\t").toArray(new String[0]);
		try {
			if(linhaSplitada.length > 133) {
				dataId = linhaSplitada[0];
				dateTime = linhaSplitada[1];
				dateDateTime = convertToDateLogFornosHeller(dateTime);
				Date dataAtual = new Date(System.currentTimeMillis());
								
				for (int i = 2; i < 134; i++) {
					if (i % 2 == 0) {
						pvs.add(linhaSplitada[i]);
					} else {
						ops.add(linhaSplitada[i]);
					}
				}
				
				linhaResumida = dataId + "\t" + dateTime;
				
				for (int i = 0; i < 20; i++) {
					//linhaResumida = linhaResumida + "\t" + pvs.get(i) + "\t"
					linhaResumida = linhaResumida + " " + pvs.get(i) + " " + ops.get(i);
				}
			}
		} catch (Exception e) {
			log.error("LinhaArquivoData: falha ao realizar parseLinhaTratada() " + e);
		}
	}

	// Versao 2.0 do lancamento de temperaturas por zonas para o mesmo posto
		private List<EventoColetado> geraEventosMedTemp() {
			List<EventoColetado> retorno = new ArrayList<>();
			Date dateMedTemp = dateDateTime;
			// A quantidade de icupdto sera igual a 2 vezes o numero de zonas
//			// devido ao TOP e BOTTOM
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
			String pv12 = pvs.get(12);
			pvs.remove(12);
			if (numeroZonas == 13) {
				pvs.add(24, pv12);
			}
			
			
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
				if (safeParseToInt(pvs.get(i)) < 0
						|| safeParseToInt(pvs.get(i)) > 1000) {
					log.error("Temperatura obtida da linha foi menor que zero (ou maior que o limiar): " + pvs.get(i) + " i="
						+ i + " linhaResumida:" + linhaResumida);
					continue;
				}
				eventoColetado.setIcUpDTO(icUpDTO);
				retorno.add(eventoColetado);
			}
			
			// Caso o numero de zonas for 13, entao a 13o temperatura top e bottom estao
			// em posicoes separadas das outras temperaturas
			if (numeroZonas == 13) {
				// TOP
				EventoColetado eventoColetado = new EventoColetado();
//				eventoColetado.setTipoEvento(ServicoFactory._MEDICAO_TEMPERATURA);
//				eventoColetado.setDthrEvento(dateMedTemp);
//				eventoColetado.setOrigem(linhaResumida);
//				eventoColetado.setParametroLido(new BigDecimal(pvs.get(12)));
//				eventoColetado.setIcUpDTO(icUpDTOList.get(12));
//				retorno.add(eventoColetado);
				// BOTTOM
				if(pvs.size() > 55 ) {
					eventoColetado = new EventoColetado();
					eventoColetado.setTipoEvento(ServicoFactory._MEDICAO_TEMPERATURA);
					eventoColetado.setDthrEvento(new Date(dateMedTemp.getTime() + 25 * 10));
					eventoColetado.setOrigem("{zona25}" + linhaResumida);
					eventoColetado.setZona((new Integer(25)).byteValue());
					eventoColetado.setParametroLido(new BigDecimal(pvs.get(55 - 1)));
					eventoColetado.setIcUpDTO(icUpDTO);
					retorno.add(eventoColetado);
				}
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
	
	public boolean isLinhaNoPadraoEsperado() {
		if ((dataId != null) && (!dataId.equals(""))
				&& (dateTime !=null) && (!dateTime.equals(""))
				&& (dateDateTime != null)) {
			return true;
		}
		return false;
	}
	
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
	
	/**
	 * Formato Origem: "1/18/2017 1:25:32 AM" Formato Saida: "2016-11-30 09:31:33.768"
	 * 
	 * @param origem
	 * @return
	 */
	public static Date convertToDateLogFornosHeller(String origem) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;

		SimpleDateFormat formato = new SimpleDateFormat("M/d/yy hh:mm:ss a");
		try {
			retorno = formato.parse(origem);
			formato.applyPattern(formatoSaida);

			String aux = formato.format(retorno);

			SimpleDateFormat formatSaida = new SimpleDateFormat(formatoSaida);
			retorno = formatSaida.parse(aux);
			return (retorno);
		} catch (Exception e) {
			
			retorno = convertToDateLogFornosHellerAlternativo(origem);
		}
		return retorno;
	}
	
	/**
	 * Formato Origem: "11-Oct-19 1:25:30 AM" Formato Saida: "2016-11-30 09:31:33.768"
	 * 
	 * @param origem
	 * @return
	 */
	public static Date convertToDateLogFornosHellerAlternativo(String origem) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;

		SimpleDateFormat formato = new SimpleDateFormat("d-MMM-yy hh:mm:ss a", Locale.US);
		try {
			retorno = formato.parse(origem);
			formato.applyPattern(formatoSaida);

			String aux = formato.format(retorno);

			SimpleDateFormat formatSaida = new SimpleDateFormat(formatoSaida);
			retorno = formatSaida.parse(aux);
			return (retorno);
		} catch (Exception e) {
			
			retorno = convertToDateLogFornosHellerFormato2(origem);
		}
		return retorno;
	}
	
	/**
	 * Formato Origem: "10/10/2019 17:53:20" Formato Saida: "2016-11-30 09:31:33.768"
	 * 
	 * @param origem
	 * @return
	 */
	public static Date convertToDateLogFornosHellerFormato2(String origem) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;

		SimpleDateFormat formato = new SimpleDateFormat("d/M/yyyy HH:mm:ss");
		try {
			retorno = formato.parse(origem);
			formato.applyPattern(formatoSaida);

			String aux = formato.format(retorno);

			SimpleDateFormat formatSaida = new SimpleDateFormat(formatoSaida);
			retorno = formatSaida.parse(aux);
			return (retorno);
		} catch (Exception e) {
			retorno = null;
		}
		return retorno;
	}
}
