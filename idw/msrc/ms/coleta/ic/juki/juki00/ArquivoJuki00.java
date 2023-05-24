package ms.coleta.ic.juki.juki00;

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

public class ArquivoJuki00 extends ArquivoJuki{
	
	private String op = "";
	private String linhaTrocaOP = "";

	public ArquivoJuki00(IdwLogger log) {
		super(log);
	}

	/* Obtem os eventos a partir da data de modificacao
	 * do arquivo ErrLog
	 * (non-Javadoc)
	 * @see ms.coleta.ic.juki.ArquivoJuki#obtemEvento(ms.coleta.ic.juki.ICJuki)
	 */
	public List<EventoColetado> obtemEvento(ICJuki ic) {
		List<EventoColetado> retorno = new ArrayList<>();
		Date data = getDataUltimaModificacao();
		
		for (String aux : getLinhas()) {
			if (aux.contains("PrgShare") &&  aux.contains("Save ALL")) {
				linhaTrocaOP = aux;
				break;
			}
		}
		if (!linhaTrocaOP.equals("")) {
			try {
				String pathPrograma = linhaTrocaOP.split("\\(")[1].replaceAll("\\)", "");
				//String pathPrograma = linhaTrocaOP.split("(")[1].replaceAll(")", "");
				File programa = new File (pathPrograma);
				op = programa.getName().replaceAll("\\.", "_");
				log.info("ArquivoJuki00: Op Obtida: " + op);
			} catch (Exception e) {
				log.error("ArquivoJuki00: Falha ao obter op: " + e);
				op = "";
			}
		}
			
		if (!op.equals("")) {
			EventoColetado eventoSaidaPlanejamento = geraEventoSaidaPlanejamento(data);
			if (eventoSaidaPlanejamento != null) {
				retorno.add(eventoSaidaPlanejamento);
				log.info("ArquivoJuki00: Gerou evento eventoSaidaPlanejamento:;"
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventoSaidaPlanejamento.getDthrEvento()) + ";"
						+ eventoSaidaPlanejamento.getCdop());

				EventoColetado eventoCriaOPAutomatica = geraEventoCriaOPAutomatica(data);
				retorno.add(eventoCriaOPAutomatica);
				log.info("ArquivoJuki00: Gerou evento eventoCriaOPAutomatica:;"
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventoCriaOPAutomatica.getDthrEvento())
						+ ";" + eventoCriaOPAutomatica.getCdop());

				EventoColetado eventoEntradaPlanejamento = geraEventoEntradaPlanejamento(data);
				retorno.add(eventoEntradaPlanejamento);
				log.info("ArquivoJuki00: Gerou evento eventoEntradaPlanejamento:;"
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventoEntradaPlanejamento.getDthrEvento())
						+ ";" + eventoEntradaPlanejamento.getCdop());
			}
			
		}
		
		if (retorno.size() > 0) {
			ic.getUltimoEventoGerado().put(getIcUpDTO().getUpDTO().getCd_up(), retorno.get(retorno.size() - 1));
		}
		
		return retorno;
	}
	
	private EventoColetado geraEventoSaidaPlanejamento(Date data) {

		EventoColetado eventoColetado = null;
		eventoColetado = new EventoColetado();
		eventoColetado.setTipoEvento(ServicoFactory._FINALIZA_OP); // Finaliza
																	// OP
		eventoColetado.setDthrEvento(data);
		eventoColetado.setCdop(op);
		eventoColetado.setCb("");
		eventoColetado.setIcUpDTO(getIcUpDTO());
		eventoColetado.setOrigem(linhaTrocaOP);

		return eventoColetado;

	}

	private EventoColetado geraEventoEntradaPlanejamento(Date dataModificadaEventoMaisAntigo) {

		EventoColetado eventoColetado = null;

		// if (!(eventoAnteriorMesmaMaquina.getShopOrder().equals(shopOrder)))
		{
			eventoColetado = new EventoColetado();

			eventoColetado.setTipoEvento(ServicoFactory._NOVA_OP); // Finaliza
																	// OP
			// eventoColetado.setDthrEvento(UtilsString.convertToDateLogSony(dDateTime));
			eventoColetado.setDthrEvento(dataModificadaEventoMaisAntigo);
			eventoColetado.setCdop(op);
			eventoColetado.setCb("");
			eventoColetado.setIcUpDTO(getIcUpDTO());
			eventoColetado.setOrigem(linhaTrocaOP);
			eventoColetado.setQtde("0");
			eventoColetado.setCdFolha(op);
			eventoColetado.setUp(getIcUpDTO().getUpDTO().getCd_up());
		}

		return eventoColetado;

	}

	private EventoColetado geraEventoCriaOPAutomatica(Date dataModificadaEventoMaisAntigo) {

		EventoColetado eventoColetado = null;

		// if (!(eventoAnteriorMesmaMaquina.getShopOrder().equals(shopOrder)))
		{
			eventoColetado = new EventoColetado();

			eventoColetado.setTipoEvento(ServicoFactory._CRIA_OP_AUTOMATICA); // Finaliza
																				// OP
			// eventoColetado.setDthrEvento(UtilsString.convertToDateLogSony(dDateTime));
			eventoColetado.setDthrEvento(dataModificadaEventoMaisAntigo);
			eventoColetado.setCdop(op);
			eventoColetado.setCb("");
			eventoColetado.setIcUpDTO(getIcUpDTO());
			eventoColetado.setOrigem(linhaTrocaOP);
			// Quantidade a ser produzida
			eventoColetado.setQtde("5000");
			eventoColetado.setCdFolha(op);
			eventoColetado.setUp(getIcUpDTO().getUpDTO().getCd_up());
		}

		return eventoColetado;

	}

	@Override
	protected void processarLinha(ICJuki ic, List<EventoColetado> retorno, String linha, int forIndex) {
	}

	@Override
	protected String getUltimaLinha(ICJuki ic, String cdUp) {
		String retorno = null;
		return retorno;
	}


}
