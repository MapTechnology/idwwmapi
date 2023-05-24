package ms.coleta.ic.juki.errlog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.util.IdwLogger;
import ms.coleta.ic.juki.ArquivoJuki;
import ms.coleta.ic.juki.ICJuki;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;

public class ArquivoErrLog extends ArquivoJuki{

	public ArquivoErrLog(IdwLogger log) {
		super(log);
	}

	/* Obtem os eventos a partir da data de modificacao
	 * do arquivo ErrLog
	 * (non-Javadoc)
	 * @see ms.coleta.ic.juki.ArquivoJuki#obtemEvento(ms.coleta.ic.juki.ICJuki)
	 */
	public List<EventoColetado> obtemEvento(ICJuki ic) {
		List<EventoColetado> retorno = new ArrayList<>();
		EventoColetado eventoCiclo = null;
		
		String linhaAlvo = null;
		List<String> linhas = getLinhas();
		int numeroLinhas = linhas.size(); 
		String lProductPwbNumAnterior = null;
		
		// Se o arqivo tiver menos de 10 linhas,
		// com certeza nao tem producao
		if (numeroLinhas < 10)
			return retorno;
		
		// Procura nas ultimas dez linhas
		for (int i = 0; i < 10; i++) {
			linhaAlvo = linhas.get(numeroLinhas -1 -i);
			if (linhaAlvo.contains("=") && linhaAlvo.contains("lBeforePwb")
					&& linhaAlvo.contains("::")) {				
				// Tenta obter o ultimo lProductPwbNum
				lProductPwbNumAnterior = obtemLProductPwbNumAnterior(ic);
				eventoCiclo = geraEventoFimCiclo(linhaAlvo, lProductPwbNumAnterior);
				break;
			}
		}
		//EventoColetado eventoCiclo = geraEventoFimCiclo();
		if (eventoCiclo != null) {
			if (isMaquinaParada(ic)) {
				EventoColetado eventoFimParada = geraEventoFimParada(eventoCiclo); 
				retorno.add(eventoFimParada);
				log.info("EventoLogJuki: Gerou evento de fim de parada:;"
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventoFimParada.getDthrEvento())
						+ ";" + eventoFimParada.getCdparada());
			}
			retorno.add(eventoCiclo);
			log.info("EventoLogJuki: Gerou evento de fim de ciclo:;"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventoCiclo.getDthrEvento())
					+ ";" + eventoCiclo.getQtde());
		} else {
			log.error("eventoCiclo == null, Evento de Fim de Ciclo nao gerado pq possivelmente o arquivo: "+ getNomeArquivo() 
			+" nao possui lBeforePwb e lProductPwbNum");
		}
		
		if (retorno.size() > 0) {
			ic.getUltimoEventoGerado().put(getIcUpDTO().getUpDTO().getCd_up(), retorno.get(retorno.size() - 1));
		}
		
		return retorno;
	}
	
//	private EventoColetado geraEventoFimCiclo(String linhaAlvo) {		
//		String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(getDataUltimaModificacao());
//		EventoColetado eventoColetado = new EventoColetado();
//		eventoColetado.setTipoEvento(ServicoFactory._FIM_CICLO); // Fim de Ciclo
//		eventoColetado.setDthrEvento(getDataUltimaModificacao());
//		// eventoColetado.setCdop(shopOrder);
//		eventoColetado.setCb("");
//		eventoColetado.setIcUpDTO(getIcUpDTO());
//		eventoColetado.setOrigem(dateString + " " + getIcUpDTO().getUpDTO().getCd_up()); 
//		eventoColetado.setQtde("1");
//		return eventoColetado;
//}
	
	private boolean isMaquinaParada(ICJuki ic) {
		String cdUp = getIcUpDTO().getUpDTO().getCd_up();
		EventoColetado ultimoEvento = null;
		if (ic.getUltimoEventoGerado().containsKey(cdUp))
		{
			ultimoEvento = ic.getUltimoEventoGerado().get(cdUp);
			if (ultimoEvento.getTipoEvento() == ServicoFactory._INICIO_PARADA)
				return true;
		}
		return false;
	}

	private String obtemLProductPwbNumAnterior(ICJuki ic) {
		String cdUp = getIcUpDTO().getUpDTO().getCd_up();
		EventoColetado ultimoEvento = null;
		String retorno = null;
		
		if (ic.getUltimoEventoGerado().containsKey(cdUp))
		{
			ultimoEvento = ic.getUltimoEventoGerado().get(cdUp);
			if (ultimoEvento.getOrigem() != null && !ultimoEvento.getOrigem().equals("")) {
				String origem = ultimoEvento.getOrigem();
				try {
					if (origem.split(";").length > 3)
						retorno = origem.split(";")[3];
				} catch (Exception e) {
					log.error("ArquivoErrLog: Excecao ao tentar obter LProductPwbNum Anterior: " 
							+ e.toString());
				}				
			}								
		}
		return retorno;
	}

	// Versao de geraEventoFimCiclo que considera lBeforePwb e lProductPwbNum
	private EventoColetado geraEventoFimCiclo(String ultimaLinha, String lProductPwbNumAnterior) {
		String lBeforePwb;
		String lProductPwbNum;
		EventoColetado eventoColetado = new EventoColetado();
		
		try {
			String[] midle = ultimaLinha.split("::");
			lBeforePwb = midle[midle.length - 1].split(" ")[0];
			lProductPwbNum = midle[midle.length - 1].split(" ")[1];
		} catch (Exception e) {
			log.error("ArquivoErrLog: Erro ao obter lBeforePwb e lProductPwbNum: " + e);
			return null;
		}
		// Se nao houve mudanca no sequencial da placa,deve-se descatar o evento
		if (lProductPwbNumAnterior != null && lProductPwbNumAnterior.equals(lProductPwbNum)) {
			log.info("ArquivoErrLog: lProductPwbNum: " + lProductPwbNum 
					+ " e lProductPwbNumAnterior: "+ lProductPwbNumAnterior + " estao iguais");
			return null;
		}
			
		String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(getDataUltimaModificacao());
		eventoColetado.setTipoEvento(ServicoFactory._FIM_CICLO); // Fim de Ciclo
		eventoColetado.setDthrEvento(getDataUltimaModificacao());
		// eventoColetado.setCdop(shopOrder);
		eventoColetado.setCb("");
		eventoColetado.setIcUpDTO(getIcUpDTO());
		eventoColetado.setOrigem(dateString + ";" + getIcUpDTO().getUpDTO().getCd_up()
				+ ";" + lBeforePwb + ";" + lProductPwbNum);
		eventoColetado.setQtde("1");
		return eventoColetado;
	}

	private EventoColetado geraEventoFimParada(EventoColetado eventoCiclo) {
		Date dataEfetiva = new Date(getDataUltimaModificacao().getTime() - 10);
		EventoColetado eventoColetado = new EventoColetado();
		eventoColetado.setTipoEvento(ServicoFactory._INICIO_PARADA); // Fim de Parada
		eventoColetado.setDthrEvento(dataEfetiva);
		// eventoColetado.setCdop(shopOrder);
		eventoColetado.setCb("");
		eventoColetado.setIcUpDTO(getIcUpDTO());
		eventoColetado.setOrigem(eventoCiclo.getOrigem());
		eventoColetado.setCdparada("1000");

		return eventoColetado;
	}
	
	@Override
	protected void processarLinha(ICJuki ic, List<EventoColetado> retorno, String linha, int forIndex) {

	}

	@Override
	protected String getUltimaLinha(ICJuki ic, String cdUp) {
		return null;
	}


}
