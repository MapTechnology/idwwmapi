
package ms.coleta.ic.kic;

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

public class LinhaArquivoKic {
	private IdwLogger log;
	private String linhaTop;
	private String linhaBot;
	private String linhaVel;
	private String[] linhaSplitadaTop;
	private String[] linhaSplitadaBot;
	private String[] linhaSplitadaVel;
	private IcUpDTO icUpDTO;

	// Campos do log

	private String dateTime = null;
	private String velocidade = null;
	private List<String> tempBot = new ArrayList<String>();
	private List<String> tempTop = new ArrayList<String>();
	private String linhaResumida = null;

	// Dados
	private Date dateDateTime = null;

	public LinhaArquivoKic(IdwLogger log, IcUpDTO icUpDTO, String linhaVel) {
		this.log = log;
		this.icUpDTO = icUpDTO;
		this.linhaVel = linhaVel;
		parseLinhaTratada();
	}

	private void parseLinhaTratada() {

		try {
			double velAux = 0;
			linhaSplitadaVel = idw.util.UtilsString.quebrarStringEmVetor(linhaVel, " ").toArray(new String[0]);
			// Velocidade
			velAux = Double.parseDouble(linhaSplitadaVel[12]) * 2.54;
			velocidade = String.valueOf(velAux);
			dateTime = linhaSplitadaVel[1] + " " + linhaSplitadaVel[2] + " " + linhaSplitadaVel[3].replace(",", "") + " "
					+ linhaSplitadaVel[4];
			dateDateTime = convertDate(dateTime);

		} catch (Exception e) {
			log.info("LinhaArquivoKic: falha ao realizar parseLinhaTratada() " + e);
		}
	}

	public void parseLinhaTop(String linha) {
		linhaTop = linha;

		try {
			linhaSplitadaTop = idw.util.UtilsString.quebrarStringEmVetor(linhaTop, " ").toArray(new String[0]);

			// Temperaturas top
			int i = 0;
			for (String temp : linhaSplitadaTop) {

				if (i > 9) {
					tempTop.add(temp);
				}
				i++;
			}
			tempTop.remove(tempTop.size() - 1);
			linhaResumida = linhaTop + " " + dateTime;
		} catch (Exception e) {
			log.info("LinhaArquivoKic: falha ao realizar parseLinhaTop() " + e);
		}

	}

	public void parseLinhaBot(String linha) {
		try {
			linhaBot = linha;
			linhaSplitadaBot = idw.util.UtilsString.quebrarStringEmVetor(linhaBot, " ").toArray(new String[0]);

			// Temperaturas bottom

			int i = 0;
			for (String temp : linhaSplitadaTop) {

				if (i > 9) {
					tempBot.add(temp);
				}

				i++;
			}

			tempBot.remove(tempBot.size() - 1);
		} catch (Exception e) {
			log.info("LinhaArquivoKic: falha ao realizar parseLinhaBot() " + e);
		}
	}

	public List<EventoColetado> obtemEvento() {

		List<EventoColetado> retorno = new ArrayList<>();

		List<EventoColetado> eventosMedTemp = geraEventosMedTemp();
		/* Se o evento for muito antigo entao não deve ser incluido na lista de retorno */
		Date dthrReferencia = DataHoraRN.getDataHoraAtual();
		dthrReferencia = DataHoraRN.subtraiDiasDaData(dthrReferencia, 1);

		if (eventosMedTemp != null && eventosMedTemp.size() > 0
				&& DataHoraRN.after(eventosMedTemp.get(0).getDthrEvento(), dthrReferencia)) {
			retorno.addAll(eventosMedTemp);
			log.info("LinhaArquivoKic: Gerou eventos de Medicao de Temperatura:;"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventosMedTemp.get(0).getDthrEvento())
					+ ";" + eventosMedTemp.get(0).getCdop());
		} else
			log.info("Evento com data " + eventosMedTemp.get(0).getDthrEvento() + " foi descartado");

		return retorno;
	}

	private List<EventoColetado> geraEventosMedTemp() {
		List<EventoColetado> retorno = new ArrayList<>();
		Date dateMedTemp = dateDateTime;

		// TOP + BOTTOM
		int j = 0;
		for (int i = 0; i < tempTop.size(); i++) {
			// Evento top
			EventoColetado eventoColetado = new EventoColetado();
			eventoColetado.setTipoEvento(ServicoFactory._MEDICAO_TEMPERATURA);
			eventoColetado.setDthrEvento(new Date(dateMedTemp.getTime() + j * 10));
			eventoColetado.setOrigem("{zona" + j + "};" + linhaResumida);
			eventoColetado.setZona((new Integer(j)).byteValue());
			eventoColetado.setParametroLido(new BigDecimal(tempTop.get(i)));
			eventoColetado.setIcUpDTO(icUpDTO);
			retorno.add(eventoColetado);
			j++;

			// Evento bottom
			eventoColetado = new EventoColetado();
			eventoColetado.setTipoEvento(ServicoFactory._MEDICAO_TEMPERATURA);
			eventoColetado.setDthrEvento(new Date(dateMedTemp.getTime() + j * 10));
			eventoColetado.setOrigem("{zona" + j + "};" + linhaResumida);
			eventoColetado.setZona((new Integer(j)).byteValue());
			eventoColetado.setParametroLido(new BigDecimal(tempBot.get(i)));
			eventoColetado.setIcUpDTO(icUpDTO);
			retorno.add(eventoColetado);
			j++;

		}
		// Cria o evento de medicao de velocidade
		EventoColetado eventoColetado = new EventoColetado();
		eventoColetado.setTipoEvento(ServicoFactory._MEDICAO_VELOCIDADE);
		eventoColetado.setDthrEvento(new Date(dateMedTemp.getTime() + 27 * 10));
		eventoColetado.setOrigem("{Velocidade};" + linhaResumida);
		eventoColetado.setParametroLido(new BigDecimal(velocidade));
		if (safeParseToDouble(velocidade) > 0) {
			eventoColetado.setIcUpDTO(icUpDTO);
			retorno.add(eventoColetado);
		}
		return retorno;
	}

	public Date convertDate(String origem) {

		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;

		SimpleDateFormat formato = new SimpleDateFormat("MMM dd yy HH:mm:ss", Locale.US);
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

	public String getLinhaTop() {
		return this.linhaTop;
	}

	public String getLinhaBot() {
		return this.linhaBot;
	}
	
	public String getLinhaVel() {
		return this.linhaVel;
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
}
