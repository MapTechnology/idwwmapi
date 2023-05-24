package ms.coleta.ic.sony.bd;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import idw.util.IdwLogger;
import ms.coleta.ic.sony.ICSony;
import ms.coleta.ic.sony.dvd.LinhaArquivoSonyMDB;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsString;

public class LinhaArquivoSonyTPRODUCT {
	private int posDDateTime = EPosicoesBDTPRODUCTDATA.DataTime.getValue();
	private int posProductionStatus = EPosicoesBDTPRODUCTDATA.ProductionStatus.getValue();
	private int posMachineID = EPosicoesBDTPRODUCTDATA.MachineID.getValue();
	private int posShopOrder = EPosicoesBDTPRODUCTDATA.ShopOrder.getValue();
	private int posOrderQuantity = EPosicoesBDTPRODUCTDATA.OrderQuantity.getValue();
	private int posOrderOKQuantity = EPosicoesBDTPRODUCTDATA.OrderOKQuantity.getValue();
	private int posOrderNGQuantity = EPosicoesBDTPRODUCTDATA.OrderNGQuantity.getValue();
	private int posRemainOrder = EPosicoesBDTPRODUCTDATA.RemainOrder.getValue();
	private int posInjectionShots  = EPosicoesBDTPRODUCTDATA.InjectionShots.getValue();
	private int posNID = EPosicoesBDTPRODUCTDATA.NID.getValue();

	// Informacoes para parada
	private int posWaitTime = EPosicoesBDTPRODUCTDATA.WaitTime.getValue();
	private int posStopTime = EPosicoesBDTPRODUCTDATA.StopTime.getValue();
	private int posPreparationTime = EPosicoesBDTPRODUCTDATA.PreparationTime.getValue();
	private int posRepairTime = EPosicoesBDTPRODUCTDATA.RepairTime.getValue();
	private int posErrorTime = EPosicoesBDTPRODUCTDATA.ErrorTime.getValue();
	private int posEmergencyTime = EPosicoesBDTPRODUCTDATA.EmergencyTime.getValue();
	
	// Informacoes de refugo
	private int posNITEM198 = EPosicoesBDTPRODUCTDATA.NITEM198.getValue();
	private int posNITEM199 = EPosicoesBDTPRODUCTDATA.NITEM199.getValue();
	private int posNITEM200 = EPosicoesBDTPRODUCTDATA.NITEM200.getValue();
	private int posNITEM201 = EPosicoesBDTPRODUCTDATA.NITEM201.getValue();
	private int posNITEM202 = EPosicoesBDTPRODUCTDATA.NITEM202.getValue();
	private int posNITEM203 = EPosicoesBDTPRODUCTDATA.NITEM203.getValue();
	private int posNITEM204 = EPosicoesBDTPRODUCTDATA.NITEM204.getValue();
	private int posNITEM205 = EPosicoesBDTPRODUCTDATA.NITEM205.getValue();
	private int posNITEM206 = EPosicoesBDTPRODUCTDATA.NITEM206.getValue();
	private int posNITEM207 = EPosicoesBDTPRODUCTDATA.NITEM207.getValue();
	private int posNITEM208 = EPosicoesBDTPRODUCTDATA.NITEM208.getValue();
	private int posNITEM209 = EPosicoesBDTPRODUCTDATA.NITEM209.getValue();
	private int posNITEM210 = EPosicoesBDTPRODUCTDATA.NITEM210.getValue();
	private int posNITEM211 = EPosicoesBDTPRODUCTDATA.NITEM211.getValue();
	private int posNITEM212 = EPosicoesBDTPRODUCTDATA.NITEM212.getValue();
	
	private String dDateTime;
	private String productionStatus; // ProductionStatus
	private String machineID;
	private String shopOrder;
	private String orderQuantity;
	private String orderOKQuantity;
	private String orderNGQuantity;
	private String remainOrder;
	private String injectionShots;
	private String nid;

	private String waitTime;
	private String stopTime;
	private String preparationTime;
	private String repairTime;
	private String errorTime;
	private String emergencyTime;
	
	private String NITEM198 = "0";
	private String NITEM199 = "0";
	private String NITEM200 = "0";
	private String NITEM201 = "0";
	private String NITEM202 = "0";
	private String NITEM203 = "0";
	private String NITEM204 = "0";
	private String NITEM205 = "0";
	private String NITEM206 = "0";
	private String NITEM207 = "0";
	private String NITEM208 = "0";
	private String NITEM209 = "0";
	private String NITEM210 = "0";
	private String NITEM211 = "0";
	private String NITEM212 = "0";
	private List<Integer> NITEMS;
	
	private String origem;
	// Diferenca da OrderOKQuantity atual para a anterior
	private String difOrderOKQuantity;
	// Diferenca da OrderNGQuantity atual para a anterior
	private String difOrderNGQuantity;

	private LinhaArquivoSonyTPRODUCT instancia;

	private List<LinhaArquivoSonyTPRODUCT> bufferEventosShopOrder;

	// Controle
	private String linha;
	private String linhaResumida;
	private String[] linhas;

	private IdwLogger log;
	private int idLog;
	private ICSony ic;
	private IcUpDTO icUpDTO;
	
	// Validacao
	long limiarParaAceitarDiffInicioParada = 2 * 60;
	
	public LinhaArquivoSonyTPRODUCT() {
		super();
	}

	public LinhaArquivoSonyTPRODUCT(IdwLogger log, String linha, ICSony ic, IcUpDTO icUpDTO) {
		super();
		this.log = log;
		idLog = log.getIdAleatorio();
		this.linha = linha;
		this.ic = ic;
		this.icUpDTO = icUpDTO;
		parseLinhaTratada();
	}
	// -------------------------------------

	/**
	 * Metodo realiza o parser da linha do log para um EventoDTO
	 * 
	 * @param linha
	 *            linha a ser processada
	 */
	private void parseLinhaTratada() {
		try {

			linhas =  idw.util.UtilsString.quebrarStringEmVetor(linha, ",").toArray(new String[0]);

			this.dDateTime = UtilsString.removeApas(linhas[posDDateTime]);
			this.productionStatus = UtilsString.removeApas(linhas[posProductionStatus]);
			this.machineID = UtilsString.removeApas(linhas[posMachineID]);
			this.shopOrder = UtilsString.removeApas(linhas[posShopOrder]);
			this.orderQuantity = UtilsString.removeApas(linhas[posOrderQuantity]);
			this.orderOKQuantity = UtilsString.removeApas(linhas[posOrderOKQuantity]);
			this.orderNGQuantity = UtilsString.removeApas(linhas[posOrderNGQuantity]);
			this.remainOrder = UtilsString.removeApas(linhas[posRemainOrder]);
			this.injectionShots = UtilsString.removeApas(linhas[posInjectionShots]);
			this.nid = UtilsString.removeApas(linhas[posNID]);

			linhaResumida = toString();
			
			// -------------------------------
			// Informacoes para parada
			this.waitTime = UtilsString.removeApas(linhas[posWaitTime]);
			this.stopTime = UtilsString.removeApas(linhas[posStopTime]);
			this.preparationTime = UtilsString.removeApas(linhas[posPreparationTime]);
			this.repairTime = UtilsString.removeApas(linhas[posRepairTime]);
			this.errorTime = UtilsString.removeApas(linhas[posErrorTime]);
			this.emergencyTime = UtilsString.removeApas(linhas[posEmergencyTime]);
			
			this.NITEM198 = UtilsString.removeApas(linhas[posNITEM198]);
			this.NITEM199 = UtilsString.removeApas(linhas[posNITEM199]);
			this.NITEM200 = UtilsString.removeApas(linhas[posNITEM200]);
			this.NITEM201 = UtilsString.removeApas(linhas[posNITEM201]);
			this.NITEM202 = UtilsString.removeApas(linhas[posNITEM202]);
			this.NITEM203 = UtilsString.removeApas(linhas[posNITEM203]);
			this.NITEM204 = UtilsString.removeApas(linhas[posNITEM204]);
			this.NITEM205 = UtilsString.removeApas(linhas[posNITEM205]);
			this.NITEM206 = UtilsString.removeApas(linhas[posNITEM206]);
			this.NITEM207 = UtilsString.removeApas(linhas[posNITEM207]);
			this.NITEM208 = UtilsString.removeApas(linhas[posNITEM208]);
			this.NITEM209 = UtilsString.removeApas(linhas[posNITEM209]);
			this.NITEM210 = UtilsString.removeApas(linhas[posNITEM210]);
			this.NITEM211 = UtilsString.removeApas(linhas[posNITEM211]);
			this.NITEM212 = UtilsString.removeApas(linhas[posNITEM212]);
			
			this.origem = dDateTime + "," + productionStatus + "," + machineID + "," + shopOrder + "," + orderQuantity + "," + 
					orderOKQuantity + "," + orderNGQuantity + "," + remainOrder + ","  + nid + "," + waitTime + "," + stopTime + "," + 
					preparationTime + "," + repairTime + "," + errorTime + "," + emergencyTime + "," + injectionShots + ","
					+ NITEM198 + "," + NITEM199 + "," + NITEM200 + "," + NITEM201 + "," + NITEM202 + "," + NITEM203 + "," + NITEM204 + ","
					+ NITEM205 + "," + NITEM206 + "," + NITEM207 + "," + NITEM208 + "," + NITEM209 + "," + NITEM210 + "," + NITEM211 + ","
					+ NITEM212;
			
			povoaNitems();
			povoaNitemsAdicionais(linhas);

		} catch (Exception e) {
			log.info(idLog, 0, "EventoLogSony: Excecao no setEventoDTO: " + e.toString()
					+ "\nLinha da Excecao no setEventoDTO: " + linha);
		}
	}

	/**
	 * M�todo para validar objeto evento antes de enviar
	 * 
	 * @return true se evento ok
	 */
	public boolean isLinhaNoPadraoEsperado() {
		return (this.dDateTime != null) && (!this.dDateTime.equals("")) &&(this.productionStatus != null)
				&& (this.shopOrder != null) && (!this.shopOrder.equals("") 
					&& (this.orderNGQuantity != null) && (!this.orderNGQuantity.equals(""))
					&& (this.orderOKQuantity != null) && (!this.orderOKQuantity.equals(""))	);
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

	/**
	 * M�todo pra gerar uma string a partir de um objeto do tipo EventoDTO
	 * 
	 * @return o evento parseado para String
	 */
	@Override
	public String toString() {
		return ("Data do evento: " + dDateTime + " Status: " + productionStatus + " Maquina de Id: " + machineID
				+ " Shop Order: " + shopOrder + " Order Quantity: " + orderQuantity + " Order OK Quantity: "
				+ orderOKQuantity + " Order NG Quantity: " + orderNGQuantity + " Remain Order Quantity: "
				+ remainOrder + "InjectionShots" + injectionShots);
	}

	/**
	 * Gera o objeto do tipo eventoColetado e o prepara para envio
	 */
	public List<EventoColetado> obtemEvento() {
		List<EventoColetado> retorno = new ArrayList<>();
		
		// Tipo de evento que causa mudanca na producao
		// if (productionStatus.equals("10") || productionStatus.equals("100")) {
		// Adicao do 200 (fim de turno)
		if (productionStatus.equals("10") || productionStatus.equals("100")
				|| productionStatus.equals("200")) {

			// Obtem evento anterior de mesmo shop order
			// LinhaArquivoSonyTPRODUCT linhaAnteriorMesmoShopOrder = this.ic.obtemUltimaLinhaDaOp(getShopOrder(), getMachineID());
			LinhaArquivoSonyTPRODUCT linhaAnteriorMesmoShopOrder = this.ic.obtemUltimaLinhaDaOpMaquina(getShopOrder(), icUpDTO.getUpDTO().getCd_up());
			if (linhaAnteriorMesmoShopOrder != null) {
				log.info("EventoLogSony: Ultima Linha obtida de mesma OP: " + linhaAnteriorMesmoShopOrder);
			} else {
				log.info("EventoLogSony: Nao ha uma ultima Linha obtida de mesma OP");
			}
			
			LinhaArquivoSonyTPRODUCT linhaAnteriorMesmaMaquina = this.ic.obtemUltimaLinhaDaMaquina(icUpDTO.getUpDTO().getCd_up());
			if (linhaAnteriorMesmaMaquina != null) {
				log.info("EventoLogSony: Ultima Linha obtida da mesma maquina: " + linhaAnteriorMesmaMaquina);
				
				// Verfica se a linha deve ser processada de acordo com a cronologia dos
				// eventos
				Date dateLinha = UtilsString.convertToDateLogSony(dDateTime);
				if (dateLinha.before(UtilsString.convertToDateLogSony(linhaAnteriorMesmaMaquina.getdDateTime())))
					return retorno;
				
			} else {
				log.info("EventoLogSony: Nao ha uma ultima Linha obtida da mesma maquina");			
			}

			
			// ------------------------------------------
 			// Inicio de Parada + Fim de Parada
//			EventoColetado eventoInicioParada = geraEventoInicioParada(linhaAnteriorMesmoShopOrder);
//			if (eventoInicioParada != null) {
//				retorno.add(eventoInicioParada);
//				log.info("EventoLogSony: Gerou evento de Inicio de Parada:;"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventoInicioParada.getDthrEvento()) 
//						+ ";" + eventoInicioParada.getCdop());
//			}
//			
//			EventoColetado eventoFimParada = geraEventoFimParada(linhaAnteriorMesmoShopOrder);
//			if (eventoInicioParada != null && eventoFimParada != null) {
//				retorno.add(eventoFimParada);
//				log.info("EventoLogSony: Gerou evento de Fim de Parada:;"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventoFimParada.getDthrEvento()) 
//						+ ";" + eventoFimParada.getCdop());
//			}
			
			// ------------------------------------------
			// Fim de ciclo

			EventoColetado eventoCiclo = geraEventoFimCiclo(linhaAnteriorMesmoShopOrder);
			if (eventoCiclo != null) {
				retorno.add(eventoCiclo);
				log.info("EventoLogSony: Gerou evento de fim de ciclo:;"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventoCiclo.getDthrEvento()) 
						+ ";" + eventoCiclo.getCdop() + ";" + eventoCiclo.getQtde());
			}

			// ------------------------------------------
			// Refugo
			// Refugo Antigo
//			EventoColetado eventoRefugo = geraEventoRefugo(linhaAnteriorMesmoShopOrder);
//			if (eventoRefugo != null) {
//				retorno.add(eventoRefugo);
//				log.info("EventoLogSony: Gerou evento de refugo:;      "+ eventoRefugo.getDthrEvento() + ";" + eventoRefugo.getCdop() + ";" + eventoRefugo.getQtde());
//			}
			// Novo esquema de refugos por categorias
			List<EventoColetado> eventosRefugos = geraEventosRefugos(linhaAnteriorMesmoShopOrder);
			if (eventosRefugos != null) {
				retorno.addAll(eventosRefugos);
				log.info("EventoLogSony: Gerou evento de refugo:;      "+ eventosRefugos.get(0).getDthrEvento() 
						+ ";" + eventosRefugos.get(0).getCdop() + ";" + eventosRefugos.get(0).getQtde());
			}
			
			if (retorno.size() > 0) {
				ic.getOps().put(getShopOrder() + icUpDTO.getUpDTO().getCd_up(), this);
				ic.getUltimasLinhasProcessadas().put(icUpDTO.getUpDTO().getCd_up(), this);		
		
		
				// A entrada e saida de planejamento deve ficar antes de qualquer evento
				// gerado para esta linha
				// Para isso, a lista de eventos sera varrida em busca do evento mais
				// antigo e
				// os eventos de entrada e saida serao inseridos imediatamente antes
				List<EventoColetado> retornoOrdenado = ordernaListaEventosColetados(retorno);
				
				EventoColetado eventoMaisAntigo = retornoOrdenado.get(0);
				long longDataEventoMaisAntigo = eventoMaisAntigo.getDthrEvento().getTime() - 10;
				Date dataModificadaEventoMaisAntigo = new Date(longDataEventoMaisAntigo);

				EventoColetado eventoSaidaPlanejamento = geraEventoSaidaPlanejamento(linhaAnteriorMesmaMaquina, dataModificadaEventoMaisAntigo);
				if (eventoSaidaPlanejamento != null) {
					retorno.add(eventoSaidaPlanejamento);
					log.info("EventoLogSony: Gerou evento eventoSaidaPlanejamento:;" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventoSaidaPlanejamento.getDthrEvento()) + ";" + eventoSaidaPlanejamento.getCdop());
		
					EventoColetado eventoCriaOPAutomatica = geraEventoCriaOPAutomatica(dataModificadaEventoMaisAntigo);
					retorno.add(eventoCriaOPAutomatica);
					log.info("EventoLogSony: Gerou evento eventoCriaOPAutomatica:;" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
							.format(eventoCriaOPAutomatica.getDthrEvento()) + ";" + eventoCriaOPAutomatica.getCdop());
		
					EventoColetado eventoEntradaPlanejamento = geraEventoEntradaPlanejamento(dataModificadaEventoMaisAntigo);
					retorno.add(eventoEntradaPlanejamento);
					log.info("EventoLogSony: Gerou evento eventoEntradaPlanejamento:;"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
							.format(eventoEntradaPlanejamento.getDthrEvento())+ ";" + eventoEntradaPlanejamento.getCdop());
				}
			}
		}

		return retorno;
	}

	private List<EventoColetado> geraEventosRefugos(LinhaArquivoSonyTPRODUCT linhaAnteriorMesmoShopOrder) {
		if (NITEMS == null || NITEMS.size() != 15)
			return null;
		List<EventoColetado> retorno = new ArrayList<>();
		
		for (int i = 0 ; i< NITEMS.size(); i++) {
			int quantidadeRefugadaAtual = getNITEMS().get(i);
			EventoColetado eventoColetado = new EventoColetado();
			Date data = UtilsString.convertToDateLogSony(dDateTime);
			// Setando objeto que sera enviado
			eventoColetado.setTipoEvento(ServicoFactory._NOVOREFUGO);
			eventoColetado.setDthrEvento(new Date(data.getTime() + i)); // As datas precisam ser diferentes entre refugos
			eventoColetado.setCdop(shopOrder);
			eventoColetado.setIcUpDTO(icUpDTO);
			eventoColetado.setCdproduto("1");
			eventoColetado.setCdrefugo("NITEM" + (i + 198)); // Criado no idw: Engenharia de
												// processo
			eventoColetado.setOrigem(origem);
			eventoColetado.setCb("");
			
			if (linhaAnteriorMesmoShopOrder != null && linhaAnteriorMesmoShopOrder.getNITEMS() != null
					&& linhaAnteriorMesmoShopOrder.getNITEMS().get(i) != null) {
				int quantidadeRefugadaAnterior = linhaAnteriorMesmoShopOrder.getNITEMS().get(i);
				trataQuantidadeRefugo(linhaAnteriorMesmoShopOrder, eventoColetado, quantidadeRefugadaAtual, quantidadeRefugadaAnterior);
			} else {
				try {
					eventoColetado.setQtde(String.valueOf(quantidadeRefugadaAtual));
				} catch (Exception e) {
					log.error("Falha ao obter string quantidade refugada ATUAL " + toString());
					eventoColetado.setQtde("0");
				}
			}
			
			int eventoColetadoQtde = safeParseToInt(eventoColetado.getQtde());
			if (eventoColetadoQtde > 0) {
				retorno.add(eventoColetado);
			}
		}
		
		retorno.addAll(geraEventosRefugosNITEMSAdicionais(linhaAnteriorMesmoShopOrder));
		
		if (retorno.size() == 0)
			return null;
		
		return retorno;
	}

	private void trataQuantidadeRefugo(LinhaArquivoSonyTPRODUCT linhaAnteriorMesmoShopOrder, EventoColetado eventoColetado,
			int quantidadeRefugadaAtual, int quantidadeRefugadaAnterior) {
		int diff = quantidadeRefugadaAtual - quantidadeRefugadaAnterior;
		// Se a diferenca for menor que zero, houve algum processo
		// ainda nao elucidado de moficacao no Order Quantity
		if (diff < 0) {
			// Se a producao liquida nao diminuiu
			if ((safeParseToInt(orderOKQuantity) - safeParseToInt(linhaAnteriorMesmoShopOrder.orderOKQuantity)) >= 0) {
				// Reducao pra teste eletrico
				// Lancar o evento dessa linha traz erros na contagem
				eventoColetado.setQtde("0");
			} else {
				// Se o refugo diminuiu, trata-se de um novo processo produtivo
				eventoColetado.setQtde(String.valueOf(quantidadeRefugadaAtual));
			}
		} else {
			eventoColetado.setQtde(String.valueOf(diff));
		}
		
	}
	
	private void trataQuantidadeRefugoNitem(LinhaArquivoSonyTPRODUCT linhaAnteriorMesmoShopOrder, EventoColetado eventoColetado,
			int quantidadeRefugadaAtual, int quantidadeRefugadaAnterior) {
		int diff = quantidadeRefugadaAtual - quantidadeRefugadaAnterior;
		// Se a diferenca for menor que zero, houve algum processo
		// ainda nao elucidado de moficacao no Order Quantity
		if (diff < 0) {
			// Se o refugo diminuiu, trata-se de um novo processo produtivo
			eventoColetado.setQtde(String.valueOf(quantidadeRefugadaAtual));
		} else {
			eventoColetado.setQtde(String.valueOf(diff));
		}
		
	}

	public void povoaNitems() {
		NITEMS = new ArrayList<>();
		if (NITEM198 != null && NITEM199 != null && NITEM200 != null && NITEM201 != null
				&& NITEM202 != null && NITEM203 != null && NITEM204 != null && NITEM205 != null 
				&& NITEM206 != null && NITEM207 != null && NITEM208 != null && NITEM209 != null
				&& NITEM210 != null && NITEM211 != null && NITEM212 != null) {
			NITEMS.add(safeParseToInt(NITEM198));
			NITEMS.add(safeParseToInt(NITEM199));
			NITEMS.add(safeParseToInt(NITEM200));
			NITEMS.add(safeParseToInt(NITEM201));
			NITEMS.add(safeParseToInt(NITEM202));
			NITEMS.add(safeParseToInt(NITEM203));
			NITEMS.add(safeParseToInt(NITEM204));
			NITEMS.add(safeParseToInt(NITEM205));
			NITEMS.add(safeParseToInt(NITEM206));
			NITEMS.add(safeParseToInt(NITEM207));
			NITEMS.add(safeParseToInt(NITEM208));
			NITEMS.add(safeParseToInt(NITEM209));
			NITEMS.add(safeParseToInt(NITEM210));
			NITEMS.add(safeParseToInt(NITEM211));
			NITEMS.add(safeParseToInt(NITEM212));
		}
	}

	private EventoColetado geraEventoSaidaPlanejamento(LinhaArquivoSonyTPRODUCT eventoAnteriorMesmaMaquina, Date dataModificadaEventoMaisAntigo) {
		
		EventoColetado eventoColetado = null;
		
		if( ( (eventoAnteriorMesmaMaquina != null) 
				&& (!(eventoAnteriorMesmaMaquina.getShopOrder().equals(shopOrder))) 
				// Checa se a dataModificadaEventoMaisAntigo e posterior a data do eventoAnteriorMesmaMaquina
				&& (dataModificadaEventoMaisAntigo.after(UtilsString.convertToDateLogSony(eventoAnteriorMesmaMaquina.getdDateTime()))) ) 
				|| eventoAnteriorMesmaMaquina == null) {
		
			// if (!(eventoAnteriorMesmaMaquina.getShopOrder().equals(shopOrder))) {
				eventoColetado = new EventoColetado();
				eventoColetado.setTipoEvento(ServicoFactory._FINALIZA_OP); // Finaliza OP
				// eventoColetado.setDthrEvento(UtilsString.convertToDateLogSony(dDateTime)); eventoMaisAntigo
				eventoColetado.setDthrEvento(dataModificadaEventoMaisAntigo);
				eventoColetado.setCdop(shopOrder);
				eventoColetado.setCb("");
				eventoColetado.setIcUpDTO(icUpDTO);
				eventoColetado.setOrigem(origem);
			}
		
		return eventoColetado;
		
	}

	private EventoColetado geraEventoEntradaPlanejamento(Date dataModificadaEventoMaisAntigo) {

		EventoColetado eventoColetado = null;

		// if (!(eventoAnteriorMesmaMaquina.getShopOrder().equals(shopOrder)))
		{
			eventoColetado = new EventoColetado();

			eventoColetado.setTipoEvento(ServicoFactory._NOVA_OP); // Finaliza
																				// OP
//			eventoColetado.setDthrEvento(UtilsString.convertToDateLogSony(dDateTime));
			eventoColetado.setDthrEvento(dataModificadaEventoMaisAntigo);
			eventoColetado.setCdop(shopOrder);
			eventoColetado.setCb("");
			eventoColetado.setIcUpDTO(icUpDTO);
			eventoColetado.setOrigem(origem);
			eventoColetado.setQtde("0");
			eventoColetado.setCdFolha(shopOrder);
			eventoColetado.setUp(icUpDTO.getUpDTO().getCd_up());
		}

		return eventoColetado;

	}
	
	private EventoColetado geraEventoCriaOPAutomatica(Date dataModificadaEventoMaisAntigo) {
		
		EventoColetado eventoColetado = null;
		
		
		// if (!(eventoAnteriorMesmaMaquina.getShopOrder().equals(shopOrder)))
		{
			eventoColetado = new EventoColetado();
		
			eventoColetado.setTipoEvento(ServicoFactory._CRIA_OP_AUTOMATICA); // Finaliza OP
			// eventoColetado.setDthrEvento(UtilsString.convertToDateLogSony(dDateTime));
			eventoColetado.setDthrEvento(dataModificadaEventoMaisAntigo);
			eventoColetado.setCdop(shopOrder);
			eventoColetado.setCb("");
			eventoColetado.setIcUpDTO(icUpDTO);
			eventoColetado.setOrigem(origem);
			// Quantidade a ser produzida
			eventoColetado.setQtde("5000");
			eventoColetado.setCdFolha(shopOrder);
			eventoColetado.setUp(icUpDTO.getUpDTO().getCd_up());
		}
		
		return eventoColetado;
		
	}
	
	
	/**
	 * Realiza o calculo de quanto tempo a maquina ficou parada, considerando
	 * a linha anterior
	 * 
	 * @param eventoAnteriorMesmoShopOrder
	 * @return tempo de maquina parada
	 */
	private long getTempoMaquinaParada(LinhaArquivoSonyTPRODUCT eventoAnteriorMesmoShopOrder) {
		long tempoParada = 0;
		long validacao = 0;
		try {
			if(eventoAnteriorMesmoShopOrder != null) {
				Date stopTime = UtilsString.convertSecondsToDate(this.stopTime);
				Date stopTimeEventoAnterior = UtilsString.convertSecondsToDate(eventoAnteriorMesmoShopOrder.getStopTime());
				long longStopTimeEventoAnterior = 0;
				if(stopTimeEventoAnterior != null) {
					longStopTimeEventoAnterior = stopTimeEventoAnterior.getTime();
				}
				
				if(stopTime != null) {
					
					validacao = stopTime.getTime() - longStopTimeEventoAnterior;
					if (validacao < 0) {
						tempoParada = tempoParada + stopTime.getTime();
					}
					else if (validacao == 0)
						tempoParada = tempoParada + validacao;
					// Esse -1 é necessario para resolver um bug no log da Sony
					else {
						// tempoParada = tempoParada + validacao -1;
						// tempoParada = tempoParada + validacao + 1;
						// tempoParada = tempoParada + validacao - 1000;
						tempoParada = tempoParada + validacao;
					}
				}
			} else {
				Date stopTime = UtilsString.convertSecondsToDate(this.stopTime);
				if(stopTime != null) {
						tempoParada = tempoParada + stopTime.getTime();
				}
			}

		} catch (Exception e) {
			tempoParada = 0;
			log.error("LinhaArquivoSony: Falha ao obter tempo de máquina parada: " + e.toString());
		}
		
		return tempoParada; // Retorno em ms
	}
	
	
	private EventoColetado geraEventoInicioParada(LinhaArquivoSonyTPRODUCT eventoAnteriorMesmoShopOrder) {
		
		long tempoMaquinaParada = getTempoMaquinaParada(eventoAnteriorMesmoShopOrder);
		if(tempoMaquinaParada == 0)
			return null;
		
		Date dateLogParada = UtilsString.convertToDateLogSony(dDateTime);
		
		// Date dateInicioParada = new Date (dateLogParada.getTime() - tempoMaquinaParada);
		// long longDateInicioParada = dateInicioParada.getTime();
		long longDateInicioParada = dateLogParada.getTime() - tempoMaquinaParada;
		Date dateInicioParada = new Date (longDateInicioParada);
		
		if (eventoAnteriorMesmoShopOrder != null && !eventoAnteriorMesmoShopOrder.getdDateTime().equals(""))
		{
			long longEventoAnteriorDateInicioParada = UtilsString.convertToDateLogSony(eventoAnteriorMesmoShopOrder.getdDateTime()).getTime();
			if(longDateInicioParada <= longEventoAnteriorDateInicioParada) {
				// Ailton: 19_05_17
				// Sem a validacao a seguir, se o arquivo tivesse as linhas reprocessadas
				// Um conjunto de inicio de paradas seria lançado.
				if ((longEventoAnteriorDateInicioParada - longDateInicioParada) <= limiarParaAceitarDiffInicioParada) {
					longDateInicioParada = longEventoAnteriorDateInicioParada + 1;
					dateInicioParada  = new Date (longDateInicioParada);
				}
				else
					return null;
			}
		}
		
		
		EventoColetado eventoColetado = new EventoColetado();
		
		eventoColetado.setTipoEvento(ServicoFactory._INICIO_PARADA); // Fim de Ciclo
		eventoColetado.setDthrEvento(dateInicioParada);
		eventoColetado.setCdop(shopOrder);
		eventoColetado.setCb("");
		eventoColetado.setIcUpDTO(icUpDTO);
		eventoColetado.setOrigem(origem);
		
		eventoColetado.setCdparada("1000");
		
		return eventoColetado;
		
	}
	
	private EventoColetado geraEventoFimParada(LinhaArquivoSonyTPRODUCT eventoAnteriorMesmoShopOrder) {
		
		long tempoMaquinaParada = getTempoMaquinaParada(eventoAnteriorMesmoShopOrder);
		
		if(tempoMaquinaParada < 1)
			return null;
		
		EventoColetado eventoColetado = new EventoColetado();
		// Date dateInicioParada = UtilsString.convertToDateLogSony(dDateTime);
		
		// Date dateFimParada = new Date (dateInicioParada.getTime() + tempoMaquinaParada);
		
		eventoColetado.setTipoEvento(ServicoFactory._FIM_PARADA); // Fim de Ciclo
		eventoColetado.setDthrEvento(UtilsString.convertToDateLogSony(dDateTime));
		eventoColetado.setCdop(shopOrder);
		eventoColetado.setCb("");
		eventoColetado.setIcUpDTO(icUpDTO);
		eventoColetado.setOrigem(origem);
		
		return eventoColetado;
		
	}

	/**
	 * Acrescenta a lista bufferEventos um evento do tipo fim de ciclo
	 * 
	 */
//	private EventoColetado geraEventoFimCiclo(LinhaArquivoSonyTPRODUCT eventoAnteriorMesmoShopOrder) {
//		EventoColetado eventoColetado = new EventoColetado();
//
//		// Seta campos do objeto eventoColetado
//
//		eventoColetado.setTipoEvento(ServicoFactory._FIM_CICLO); // Fim de Ciclo
//		eventoColetado.setDthrEvento(UtilsString.convertToDateLogSony(dDateTime));
//		eventoColetado.setCdop(shopOrder);
//		eventoColetado.setCb("");
//		eventoColetado.setIcUpDTO(icUpDTO);
//		eventoColetado.setOrigem(origem);
//
//		int quantidadeTotalAtual = Integer.parseInt(orderOKQuantity) + Integer.parseInt(orderNGQuantity);
//		
//		// Se existe um evento anterior
//		if (eventoAnteriorMesmoShopOrder != null) {
//			int quantidadeTotalAnterior = Integer.parseInt(eventoAnteriorMesmoShopOrder.orderOKQuantity)
//					+ Integer.parseInt(eventoAnteriorMesmoShopOrder.orderNGQuantity);
//			int diff = quantidadeTotalAtual - quantidadeTotalAnterior;
//			// Se a diferenca for menor que zero, houve algum processo
//			// ainda nao elucidado de moficacao no Order Quantity
//			// Entao, adota-se a nova quantidadeTotalAtual como qtde.
//			if (diff < 0 || Integer.parseInt(orderOKQuantity) == 0) {
//				// Se o refugo nao diminui trata-se do mesmo processo produtivo
//				if ((Integer.parseInt(orderNGQuantity) - Integer.parseInt(eventoAnteriorMesmoShopOrder.orderNGQuantity)) >= 0) {
//				// Tratar apenas producaoBruta = refugo
//					trataQuantidadeRefugo(eventoAnteriorMesmoShopOrder,eventoColetado,  Integer.parseInt(orderNGQuantity));
//				} else {
//					eventoColetado.setQtde(String.valueOf(quantidadeTotalAtual));
//				}
//			}
//			// Se nao, adota-se a diferenca entre quantidades do estado atual
//			// para o anterior
//			else {
//				eventoColetado.setQtde(String.valueOf(diff));
//			}
//		} else {
//			eventoColetado.setQtde(String.valueOf(quantidadeTotalAtual));
//		}
//
//		// Se a quantidade a ser inserida for maior que zero, envia-se o evento
//		if (Integer.parseInt(eventoColetado.getQtde()) <= 0) {
//			eventoColetado = null;
//		}
//		return eventoColetado;
//	}
	
	private void trataQuantidadeLiquida(LinhaArquivoSonyTPRODUCT eventoAnteriorMesmoShopOrder, EventoColetado eventoColetado) {
		int quantidadeLiquidaAtual = safeParseToInt(orderOKQuantity);
		int quantidadeLiquidaAnterior = 0;
		int quantidadeInjectionShotsAnterior = 0;
		if (eventoAnteriorMesmoShopOrder != null && eventoAnteriorMesmoShopOrder.orderOKQuantity != null
				&& eventoAnteriorMesmoShopOrder.injectionShots != null) {
			quantidadeLiquidaAnterior = safeParseToInt(eventoAnteriorMesmoShopOrder.orderOKQuantity);
			quantidadeInjectionShotsAnterior = safeParseToInt(eventoAnteriorMesmoShopOrder.injectionShots);
		}

		
		int diff = quantidadeLiquidaAtual - quantidadeLiquidaAnterior;
		
		// Se a diferenca for menor que zero, houve algum processo
		// ainda nao elucidado de moficacao no Order Quantity
		if (diff < 0) {
			// Se a producao bruta nao diminuiu
			if ((safeParseToInt(injectionShots) - quantidadeInjectionShotsAnterior) >= 0) {
				// Reducao pra teste eletrico
				// Lancar o evento dessa linha traz erros na contagem
				eventoColetado.setProducaoLiquida(new BigDecimal("0"));
			} else {
				// Se a producao liquida diminuiu, trata-se de um novo processo produtivo
				// eventoColetado.setProducaoLiquida(String.valueOf(quantidadeLiquidaAtual));
				eventoColetado.setProducaoLiquida(new BigDecimal(quantidadeLiquidaAtual));
			}
		} else {
			// eventoColetado.setProducaoLiquida(String.valueOf(diff));
			eventoColetado.setProducaoLiquida(new BigDecimal(diff));
		}
	}
	
	private void trataQuantidadeRefugadaTotal(LinhaArquivoSonyTPRODUCT eventoAnteriorMesmoShopOrder, EventoColetado eventoColetado) {
		// int quantidadeRefugadaAtual = Integer.parseInt(orderNGQuantity);
		int quantidadeRefugadaAtual = safeParseToInt(orderNGQuantity);

		if (eventoAnteriorMesmoShopOrder != null && eventoAnteriorMesmoShopOrder.orderNGQuantity != null) {
			int quantidadeRefugadaAnterior = safeParseToInt(eventoAnteriorMesmoShopOrder.orderNGQuantity);
			int diff = quantidadeRefugadaAtual - quantidadeRefugadaAnterior;
			// Se a diferenca for menor que zero, houve algum processo
			// ainda nao elucidado de moficacao no refugo
			if (diff < 0) {
				// Se o refugo diminuiu, trata-se de um novo processo produtivo
				eventoColetado.setProducaoRefugada(new BigDecimal(quantidadeRefugadaAtual));
			} else {
				eventoColetado.setProducaoRefugada(new BigDecimal(diff));
			}
		} else {
			eventoColetado.setProducaoRefugada(new BigDecimal(quantidadeRefugadaAtual));
		}
	}
	
	private EventoColetado geraEventoFimCiclo(LinhaArquivoSonyTPRODUCT eventoAnteriorMesmoShopOrder) {
		EventoColetado eventoColetado = new EventoColetado();

		// Seta campos do objeto eventoColetado

		eventoColetado.setTipoEvento(ServicoFactory._FIM_CICLO); // Fim de Ciclo
		eventoColetado.setDthrEvento(UtilsString.convertToDateLogSony(dDateTime));
		eventoColetado.setCdop(shopOrder);
		eventoColetado.setCb("");
		eventoColetado.setIcUpDTO(icUpDTO);
		eventoColetado.setOrigem(origem);

		int quantidadeTotalAtual = safeParseToInt(injectionShots);
		
		// Se existe um evento anterior
		if (eventoAnteriorMesmoShopOrder != null) {
			int quantidadeTotalAnterior = safeParseToInt(eventoAnteriorMesmoShopOrder.injectionShots);
			int diff = quantidadeTotalAtual - quantidadeTotalAnterior;
			// Se a diferenca for menor que zero, houve algum processo
			// ainda nao elucidado de moficacao no Order Quantity
			// Entao, adota-se a nova quantidadeTotalAtual como qtde.
			if (diff < 0) {
				// Se o refugo nao diminui trata-se do mesmo processo produtivo
				if ((safeParseToInt(orderNGQuantity) - safeParseToInt(eventoAnteriorMesmoShopOrder.orderNGQuantity)) >= 0) {
				// Tratar apenas producaoBruta = refugo
					eventoColetado.setQtde("0");
				} else {
					eventoColetado.setQtde(String.valueOf(quantidadeTotalAtual));
				}
			}
			// Se nao, adota-se a diferenca entre quantidades do estado atual
			// para o anterior
			else {
				eventoColetado.setQtde(String.valueOf(diff));
			}
		} else {
			eventoColetado.setQtde(String.valueOf(quantidadeTotalAtual));
		}

		// Seta producao liquida
		trataQuantidadeLiquida(eventoAnteriorMesmoShopOrder, eventoColetado);
		// Seta producao refugada
		trataQuantidadeRefugadaTotal(eventoAnteriorMesmoShopOrder, eventoColetado);
		
		// 2018-01-09: Alessandre definiu que se qtde do evento for zero, 
		// as quantidades do refugo e p.liquida deve ser lancadas na qtde do evento.
		// 2018-02-08: Alessandre esta definindo uma solucao para os fins de ciclo com quantidade igual
		// a zero, mas producao liquida e refugada, nao serem descartados
//		if (eventoColetado.getQtde().equals("0")
//				&& ((eventoColetado.getProducaoLiquida().longValue() > 0) || (eventoColetado.getProducaoRefugada().longValue() > 0)) )
//		{
//			eventoColetado.setQtde(String.valueOf(eventoColetado.getProducaoLiquida().longValue() + eventoColetado.getProducaoRefugada().longValue()));
//			log.info("Evento: " + this.toString() + " teve qtde=0, assim, sera utilizada como a soma producaoLiquida + producaoRefugada");
//		}

		// Se a quantidade a ser inserida for maior que zero, envia-se o evento
		if (Integer.parseInt(eventoColetado.getQtde()) <= 0
				&& (eventoColetado.getProducaoLiquida().longValue() <= 0)
				&& (eventoColetado.getProducaoRefugada().longValue() <= 0) ) {
			eventoColetado = null;
		}
		return eventoColetado;
	}

	/**
	 * Acrescenta a lista bufferEventos um evento do tipo refugo
	 * 
	 * @param bufferEventos
	 * @param bufferEventosShopOrder
	 * @param icUpDTO
	 * @return
	 */
	private EventoColetado geraEventoRefugo(LinhaArquivoSonyTPRODUCT eventoAnteriorMesmoShopOrder) {

		EventoColetado eventoColetado = new EventoColetado();

		// Setando objeto que sera enviado
		eventoColetado.setTipoEvento(ServicoFactory._NOVOREFUGO); // Fim de
																	// Ciclo
		eventoColetado.setDthrEvento(UtilsString.convertToDateLogSony(dDateTime));
		eventoColetado.setCdop(shopOrder);
		// eventoColetado.setCb(shopOrder);
		eventoColetado.setIcUpDTO(icUpDTO);
		// eventoColetado.setCdproduto(shopOrder);
		eventoColetado.setCdproduto("1");
		eventoColetado.setCdrefugo("100"); // Criado no idw: Engenharia de
											// processo
		eventoColetado.setOrigem(origem);
		eventoColetado.setCb("");

		// Obtem evento anterior de mesmo shop order
		// EventoLogSony eventoAnteriorMesmoShopOrder =
		// EventoLogSony.getEventoLogSonyFromList(bufferEventosShopOrder,
		// shopOrder);
		int quantidadeRefugadaAtual = Integer.parseInt(orderNGQuantity);

		if (eventoAnteriorMesmoShopOrder != null) {
			trataQuantidadeRefugo(eventoAnteriorMesmoShopOrder, eventoColetado, quantidadeRefugadaAtual);
		} else {
			eventoColetado.setQtde(String.valueOf(quantidadeRefugadaAtual));
		}

		// Se a quantidade a ser inserida for maior que zero, envia-se o evento
		if (Integer.parseInt(eventoColetado.getQtde()) <= 0) {
			eventoColetado = null;
		}
		return eventoColetado;
	}

	private void trataQuantidadeRefugo(LinhaArquivoSonyTPRODUCT eventoAnteriorMesmoShopOrder, EventoColetado eventoColetado, int quantidadeRefugadaAtual) {
		int quantidadeRefugadaAnterior = Integer.parseInt(eventoAnteriorMesmoShopOrder.orderNGQuantity);
		int diff = quantidadeRefugadaAtual - quantidadeRefugadaAnterior;
		// Se a diferenca for menor que zero, houve algum processo
		// ainda nao elucidado de moficacao no Order Quantity
		if (diff < 0) {
			// Se o refugo diminuiu, trata-se de um novo processo produtivo
			eventoColetado.setQtde(String.valueOf(quantidadeRefugadaAtual));
			// eventoColetado.setQtde("0");
			// eventoColetado.setQtde(String.valueOf(quantidadeRefugadaAtual));
		} else {
			eventoColetado.setQtde(String.valueOf(diff));
		}
	}
	
	// Aux
	
	private List<EventoColetado> ordernaListaEventosColetados(List<EventoColetado> eventos) {
		List<EventoColetado> retorno = eventos;
		// Ordenacao
		Collections.sort(retorno, new Comparator<EventoColetado>() {
			@Override
			public int compare(EventoColetado o1, EventoColetado o2) {
				int comparacao = o1.getDthrEvento().compareTo(o2.getDthrEvento());
				return comparacao;
			}
		});
		return retorno;
	}
	
	public String[] getLinhas() {
		return linhas;
	}

	public String getdDateTime() {
		return dDateTime;
	}

	public void setdDateTime(String dDateTime) {
		this.dDateTime = dDateTime;
	}

	public String getMachineID() {
		return machineID;
	}

	public void setMachineID(String machineID) {
		this.machineID = machineID;
	}

	public String getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(String orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getRemainOrder() {
		return remainOrder;
	}

	public void setRemainOrder(String remainOrder) {
		this.remainOrder = remainOrder;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public List<LinhaArquivoSonyTPRODUCT> getBufferEventosShopOrder() {
		return bufferEventosShopOrder;
	}

	public void setBufferEventosShopOrder(List<LinhaArquivoSonyTPRODUCT> bufferEventosShopOrder) {
		this.bufferEventosShopOrder = bufferEventosShopOrder;
	}

	public String getLinha() {
		return linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}

	public String getLinhaResumida() {
		return linhaResumida;
	}

	public void setLinhaResumida(String linhaResumida) {
		this.linhaResumida = linhaResumida;
	}

	public IdwLogger getLog() {
		return log;
	}

	public void setLog(IdwLogger log) {
		this.log = log;
	}

	public int getIdLog() {
		return idLog;
	}

	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}

	public void setShopOrder(String shopOrder) {
		this.shopOrder = shopOrder;
	}

	public void setLinhas(String[] linhas) {
		this.linhas = linhas;
	}

	public LinhaArquivoSonyTPRODUCT getInstancia() {
		return instancia;
	}

	public void setInstancia(LinhaArquivoSonyTPRODUCT instancia) {
		this.instancia = instancia;
	}

	public String getOrderOKQuantity() {
		return orderOKQuantity;
	}

	public void setOrderOKQuantity(String orderOKQuantity) {
		this.orderOKQuantity = orderOKQuantity;
	}

	public String getOrderNGQuantity() {
		return orderNGQuantity;
	}

	public void setOrderNGQuantity(String orderNGQuantity) {
		this.orderNGQuantity = orderNGQuantity;
	}

	public String getShopOrder() {
		return shopOrder;
	}

	public String getDifOrderOKQuantity() {
		return difOrderOKQuantity;
	}

	public void setDifOrderOKQuantity(String difOrderOKQuantity) {
		this.difOrderOKQuantity = difOrderOKQuantity;
	}

	public String getDifOrderNGQuantity() {
		return difOrderNGQuantity;
	}

	public void setDifOrderNGQuantity(String difOrderNGQuantity) {
		this.difOrderNGQuantity = difOrderNGQuantity;
	}

	public String getProductionStatus() {
		return productionStatus;
	}

	public void setProductionStatus(String productionStatus) {
		this.productionStatus = productionStatus;
	}
	
	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public String getInjectionShots() {
		return injectionShots;
	}

	public void setInjectionShots(String injectionShots) {
		this.injectionShots = injectionShots;
	}

	public String getNITEM198() {
		return NITEM198;
	}

	public void setNITEM198(String nITEM198) {
		NITEM198 = nITEM198;
	}

	public String getNITEM199() {
		return NITEM199;
	}

	public void setNITEM199(String nITEM199) {
		NITEM199 = nITEM199;
	}

	public String getNITEM200() {
		return NITEM200;
	}

	public void setNITEM200(String nITEM200) {
		NITEM200 = nITEM200;
	}

	public String getNITEM201() {
		return NITEM201;
	}

	public void setNITEM201(String nITEM201) {
		NITEM201 = nITEM201;
	}

	public String getNITEM202() {
		return NITEM202;
	}

	public void setNITEM202(String nITEM202) {
		NITEM202 = nITEM202;
	}

	public String getNITEM203() {
		return NITEM203;
	}

	public void setNITEM203(String nITEM203) {
		NITEM203 = nITEM203;
	}

	public String getNITEM204() {
		return NITEM204;
	}

	public void setNITEM204(String nITEM204) {
		NITEM204 = nITEM204;
	}

	public String getNITEM205() {
		return NITEM205;
	}

	public void setNITEM205(String nITEM205) {
		NITEM205 = nITEM205;
	}

	public String getNITEM206() {
		return NITEM206;
	}

	public void setNITEM206(String nITEM206) {
		NITEM206 = nITEM206;
	}

	public String getNITEM207() {
		return NITEM207;
	}

	public void setNITEM207(String nITEM207) {
		NITEM207 = nITEM207;
	}

	public String getNITEM208() {
		return NITEM208;
	}

	public void setNITEM208(String nITEM208) {
		NITEM208 = nITEM208;
	}

	public String getNITEM209() {
		return NITEM209;
	}

	public void setNITEM209(String nITEM209) {
		NITEM209 = nITEM209;
	}

	public String getNITEM210() {
		return NITEM210;
	}

	public void setNITEM210(String nITEM210) {
		NITEM210 = nITEM210;
	}

	public String getNITEM211() {
		return NITEM211;
	}

	public void setNITEM211(String nITEM211) {
		NITEM211 = nITEM211;
	}

	public String getNITEM212() {
		return NITEM212;
	}

	public void setNITEM212(String nITEM212) {
		NITEM212 = nITEM212;
	}

	public List<Integer> getNITEMS() {
		return NITEMS;
	}

	public void setNITEMS(List<Integer> nITEMS) {
		NITEMS = nITEMS;
	}
	
	protected Map<String, String> NITEMSAdicionais = new HashMap<String, String>() {{
		put("NITEM075", "0");
		put("NITEM082", "0");
		put("NITEM144", "0");
		put("NITEM145", "0");
		put("NITEM147", "0");
		put("NITEM148", "0");
		put("NITEM149", "0");
		put("NITEM150", "0");
		put("NITEM151", "0");
		put("NITEM152", "0");
		put("NITEM153", "0");
		put("NITEM154", "0");
		put("NITEM155", "0");
		put("NITEM156", "0");
		put("NITEM157", "0");
		put("NITEM158", "0");
		put("NITEM159", "0");
		put("NITEM160", "0");
		put("NITEM167", "0");
		put("NITEM172", "0");
		put("NITEM177", "0");
		put("NITEM178", "0");
		put("NITEM179", "0");
		put("NITEM180", "0");
		put("NITEM182", "0");
		put("NITEM183", "0");
		put("NITEM185", "0");
		put("NITEM187", "0");
		put("NITEM188", "0");
		put("NITEM220", "0");
		put("NITEM221", "0");
		put("NITEM222", "0");
		put("NITEM223", "0");
		put("NITEM224", "0");
		put("NITEM225", "0");
		put("NITEM226", "0");
		put("NITEM227", "0");
		put("NITEM228", "0");
		put("NITEM232", "0");
		put("NITEM233", "0");
		put("NITEM234", "0");
		put("NITEM235", "0");
		put("NITEM236", "0");
		put("NITEM237", "0");
		put("NITEM238", "0");
		put("NITEM239", "0");
		put("NITEM247", "0");
		put("NITEM248", "0");
		put("NITEM249", "0");
		put("NITEM250", "0");
		put("NITEM251", "0");
		put("NITEM252", "0");
		put("NITEM253", "0");
		put("NITEM254", "0");
		put("NITEM255", "0");
		put("NITEM256", "0");
		put("NITEM257", "0");
		put("NITEM258", "0");
		put("NITEM259", "0");
		put("NITEM260", "0");
		put("NITEM261", "0");
		put("NITEM262", "0");
		put("NITEM270", "0");
		put("NITEM273", "0");
		put("NITEM276", "0");
		put("NITEM279", "0");
		put("NITEM283", "0");
		put("NITEM284", "0");
		put("NITEM285", "0");
		put("NITEM286", "0");
		put("NITEM287", "0");
    }};
    public void povoaNitemsAdicionais(String[] linhas) {
    	Set<String> keys = NITEMSAdicionais.keySet();
    	for (String key: keys) {
    		int posColuna = safeParseToInt(key.replaceAll("NITEM", "")) + 2;
    		String qtde = UtilsString.removeApas(linhas[posColuna]);
    		NITEMSAdicionais.put(key, qtde);
    	}
	}
    
    private List<EventoColetado> geraEventosRefugosNITEMSAdicionais(LinhaArquivoSonyTPRODUCT linhaAnteriorMesmoShopOrder) {
		List<EventoColetado> retorno = new ArrayList<>();
		Set<String> keys = NITEMSAdicionais.keySet();
		// 2019-11-21 Ailton: esses eventos estavam sendo descartados por causa de colisao nas datas
		//int i = 0;
		int i = 25;
    	for (String key: keys) {
    		int quantidadeRefugadaAtual = safeParseToInt(NITEMSAdicionais.get(key));
    		EventoColetado eventoColetado = new EventoColetado();
    		Date data = UtilsString.convertToDateLogSony(dDateTime);
			// Setando objeto que sera enviado
			eventoColetado.setTipoEvento(ServicoFactory._NOVOREFUGO);
			eventoColetado.setDthrEvento(new Date(data.getTime() + i)); // As datas precisam ser diferentes entre refugos
			eventoColetado.setCdop(shopOrder);
			eventoColetado.setIcUpDTO(icUpDTO);
			eventoColetado.setCdproduto("1");
			eventoColetado.setCdrefugo(key); // Criado no idw: Engenharia de
												// processo
			eventoColetado.setOrigem(origem);
			eventoColetado.setCb("");
			
			if (linhaAnteriorMesmoShopOrder != null && linhaAnteriorMesmoShopOrder.getNITEMS() != null
					&& linhaAnteriorMesmoShopOrder.NITEMSAdicionais.get(key) != null) {
				int quantidadeRefugadaAnterior = safeParseToInt(linhaAnteriorMesmoShopOrder.NITEMSAdicionais.get(key));
				trataQuantidadeRefugoNitem(linhaAnteriorMesmoShopOrder, eventoColetado, quantidadeRefugadaAtual, quantidadeRefugadaAnterior);
			} else {
				try {
					eventoColetado.setQtde(String.valueOf(quantidadeRefugadaAtual));
				} catch (Exception e) {
					log.error("Falha ao obter string quantidade refugada ATUAL " + toString());
					eventoColetado.setQtde("0");
				}
			}
			int eventoColetadoQtde = safeParseToInt(eventoColetado.getQtde());
			if (eventoColetadoQtde > 0) {
				retorno.add(eventoColetado);
				i++;
			}
    	}		
		return retorno;
	}
	
} // Fim da Classe
