
package ms.coleta.ic.flex.fornobtu;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class LinhaArquivoBtu {
	private IdwLogger log;
	private String linhaTop;
	private String linhaBot;
	private String linhaVel;
	private IcUpDTO icUpDTO;

	// Campos do log

	private String dateTime = null;
	public String velocidade = null;
	public List<String> tempBot = new ArrayList<String>();
	public List<String> tempTop = new ArrayList<String>();
	private String linhaResumida = null;
	public String op = null;

	// Dados
	private Date dateDateTime = null;

	public LinhaArquivoBtu(IdwLogger log, IcUpDTO icUpDTO, String linhaTop) {
		this.log = log;
		this.icUpDTO = icUpDTO;
		this.linhaTop = linhaTop;
		parseLinhaTratada();
	}

	private void parseLinhaTratada() {

		try {
			tempTop.add(getParametro(linhaTop));					

		} catch (Exception e) {
			log.info("LinhaArquivoBtu: falha ao realizar parseLinhaTratada() " + e);
		}
	}
	
	public String getParametro(String linha){
		String retorno;
		String linhaSplitada[];
		
		linhaSplitada = idw.util.UtilsString.quebrarStringEmVetor(linha,"\t").toArray(new String[0]);
		retorno = linhaSplitada[2];
		return retorno;
	}	

	public List<EventoColetado> obtemEvento(String linha) {

		List<EventoColetado> retorno = new ArrayList<>();
		String linhaSplitada[] = idw.util.UtilsString.quebrarStringEmVetor(linha,"\t").toArray(new String[0]);
		dateTime = linhaSplitada[1];
		dateDateTime = convertDate(dateTime); 
		
		List<EventoColetado> eventosMedTemp = geraEventosMedTemp();
		/* Se o evento for muito antigo entao não deve ser incluido na lista de retorno */
		Date dthrReferencia = DataHoraRN.getDataHoraAtual();
		dthrReferencia = DataHoraRN.subtraiDiasDaData(dthrReferencia, 1);

		if (eventosMedTemp != null && eventosMedTemp.size() > 0
				//&& DataHoraRN.after(eventosMedTemp.get(0).getDthrEvento(), dthrReferencia)
				) {
			retorno.addAll(eventosMedTemp);
			log.info("LinhaArquivoBtu: Gerou eventos de Medicao de Temperatura:;"
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
		//Estou colocando a OP do forno, talvez isso gere conflito com o KIC
		int j = 0;
		for (int i = 0; i < tempTop.size(); i++) {
			// Evento top
			EventoColetado eventoColetado = new EventoColetado();
			eventoColetado.setTipoEvento(ServicoFactory._MEDICAO_TEMPERATURA);
			eventoColetado.setDthrEvento(new Date(dateMedTemp.getTime() + j * 10));
			eventoColetado.setOrigem("{zona" + j + "};" + dateTime);
			eventoColetado.setCdop(op);
			eventoColetado.setZona((new Integer(j)).byteValue());
			eventoColetado.setParametroLido(new BigDecimal(tempTop.get(i)));
			eventoColetado.setIcUpDTO(icUpDTO);
			retorno.add(eventoColetado);
			j++;

			// Evento bottom
			eventoColetado = new EventoColetado();
			eventoColetado.setTipoEvento(ServicoFactory._MEDICAO_TEMPERATURA);
			eventoColetado.setDthrEvento(new Date(dateMedTemp.getTime() + j * 10));
			eventoColetado.setOrigem("{zona" + j + "};" + dateTime);
			eventoColetado.setZona((new Integer(j)).byteValue());
			eventoColetado.setCdop(op);
			eventoColetado.setParametroLido(new BigDecimal(tempBot.get(i)));
			eventoColetado.setIcUpDTO(icUpDTO);
			retorno.add(eventoColetado);
			j++;

		}
		// Cria o evento de medicao de velocidade
		EventoColetado eventoColetado = new EventoColetado();
		eventoColetado.setTipoEvento(ServicoFactory._MEDICAO_VELOCIDADE);
		eventoColetado.setDthrEvento(new Date(dateMedTemp.getTime() + 27 * 10));
		if (linhaResumida != null)
			eventoColetado.setOrigem("{Velocidade};" + linhaResumida);
		else
			eventoColetado.setOrigem("{Velocidade}");
		
		if (velocidade == null)
			velocidade = "0";
		
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

		SimpleDateFormat formato = new SimpleDateFormat("MM-dd-yyyy,HH:mm:ss");
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
	
	public String getOpLinha(String linha){
		String retorno = null;
		String linhaSplitada[];
		String opSplitada[];
		
		linhaSplitada = idw.util.UtilsString.quebrarStringEmVetor(linha,"\t").toArray(new String[0]);
		opSplitada = idw.util.UtilsString.quebrarStringEmVetor(linhaSplitada[2],"\\").toArray(new String[0]);
		retorno = opSplitada[opSplitada.length - 1];
		
		return retorno;
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
