package ms.coleta.ic.sony.dvd;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import idw.util.IdwLogger;
import ms.coleta.ic.sony.ICSony;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsString;

public class LinhaArquivoSonyMDB {

	private IdwLogger log;
	private int idLog;
	
	private int posDateTime = 0;
	private int posCmd = 1;
	private int posMachineID = 2;
	private int posShopOrder = 3;
	private int posOrderStatus = 4;
	private int posQuantity = 5;
	private int posOKQuantity = 6;
    private int posBndReject0 = 7;

	private String cmd;
	private String machineID;
	private String shopOrder;
	private String orderStatus;
	private String bShot;
	private String bndOk;
	private String origem;
	
	private List<Integer> bndRejectsERefugos;
	private String bndReject0 = "0";
	private String bndReject1 = "0";
	private String bndReject2 = "0";
	private String bndReject3 = "0";
	private String bndReject4 = "0";
	private String bndReject5 = "0";
	private String bndReject6 = "0";
	
	// Adicoes Ailton: 2018-02-07
	// segundo email do Marcio (Assunto: BD e DVD)
	// mandado 06/02/18
	private String bndDrop = "0";
	private String bndScrap = "0";
	private String bndClear = "0";
	private String bndReflected = "0";
	private String bndVisual = "0";
	private String bndPatrol = "0";
	//private String bndDef1 = "0";
	
	// Adicoes Ailton: 2018-02-09
	// segundo email do Marcio (Assunto:Fwd: RES: Rejeitos DVD)
	// mandado 09/02/18
	// Sao 16 BNDdefs (de 1 a 16)
	List<String> bndDefs = Arrays.asList("0", "0", "0", "0","0", "0","0", "0","0", "0","0", "0",
			"0", "0","0", "0");

	private String mldDrop1 = "0";
	private String mldDrop2 = "0";
	private String mldDrop3 = "0";
	private String mldDrop4 = "0";
	
	private String bndInSystem = "0";
	private String totalizadorRefugoValido = "0";
	
	List<String> camposAdicionaisRefugo =
			Arrays.asList("BNDdrop", "BNDscrap", "BNDclear", "BNDreflected", "BNDvisual", "BNDpatrol");

	private IcUpDTO icUpDTO;
	private ICSony ic;

	private String linha;
	private String[] linhas;

	private String dateTime;

	public LinhaArquivoSonyMDB() {
		super();
	}

	public LinhaArquivoSonyMDB(IdwLogger log, String linha, ICSony ic, IcUpDTO icUpDTO) {
		super();
		this.log = log;
		this.idLog = log.getIdAleatorio();
		this.linha = linha;
		this.ic = ic;
		this.icUpDTO = icUpDTO;

		parseLinhaTratada();
	}

	private void parseLinhaTratada() {

		linhas = idw.util.UtilsString.quebrarStringEmVetor(linha, ",").toArray(new String[0]);

		this.dateTime = linhas[posDateTime];
		this.cmd = linhas[posCmd];
		this.machineID = linhas[posMachineID];
		this.shopOrder = linhas[posShopOrder];
		this.orderStatus = linhas[posOrderStatus];
		this.bShot = linhas[posQuantity];
		this.bndOk = linhas[posOKQuantity];
		
		if (linhas.length > 7) {
			this.bndReject0 = linhas[posBndReject0];
			this.bndReject1 = linhas[posBndReject0 + 1];
			this.bndReject2 = linhas[posBndReject0 + 2];
			this.bndReject3 = linhas[posBndReject0 + 3];
			this.bndReject4 = linhas[posBndReject0 + 4];
			this.bndReject5 = linhas[posBndReject0 + 5];
			this.bndReject6 = linhas[posBndReject0 + 6];
		}
		if (linhas.length > 14) {
			this.bndDrop = linhas[posBndReject0 + 7];
			this.bndScrap = linhas[posBndReject0 + 8];
			this.bndClear = linhas[posBndReject0 + 9];
			this.bndReflected = linhas[posBndReject0 + 10];
			this.bndVisual = linhas[posBndReject0 + 11];
			this.bndPatrol = linhas[posBndReject0 + 12];
			bndDefs.set(0, linhas[posBndReject0 + 13]); // BNDdef1: 7 + 13
		}
		if (linhas.length > 20) {
			for (int i = 0; i < 15; i++) {
				bndDefs.set(i, linhas[posBndReject0 + 14 + i]);
			}
			this.mldDrop1 = linhas[posBndReject0 + 29];
			this.mldDrop2 = linhas[posBndReject0 + 30];
			this.mldDrop3 = linhas[posBndReject0 + 31];
			this.mldDrop4 = linhas[posBndReject0 + 32];
			
			this.bndInSystem = linhas[posBndReject0 + 33];
		}
		
		povoaBndRejects();

		try {
			String.valueOf(Integer.parseInt(bShot) - Integer.parseInt(bndOk));
		} catch (Exception e) {
			log.error("Falha ao obter quantidade orderNGQuantity " + toString());
		}

		this.origem = linha;
	}

	public void povoaBndRejects() {
		bndRejectsERefugos = new ArrayList<>();
		if (bndReject0 != null && bndReject1 != null && bndReject2 != null 
				&& bndReject3 != null && bndReject4 != null && bndReject5 != null && bndReject6 != null) {
			bndRejectsERefugos.add(safeParseToInt(bndReject0));
			bndRejectsERefugos.add(safeParseToInt(bndReject1));
			bndRejectsERefugos.add(safeParseToInt(bndReject2));
			bndRejectsERefugos.add(safeParseToInt(bndReject3));
			bndRejectsERefugos.add(safeParseToInt(bndReject4));
			bndRejectsERefugos.add(safeParseToInt(bndReject5));
			bndRejectsERefugos.add(safeParseToInt(bndReject6));
		}
		if (bndDrop != null && bndScrap != null && bndClear != null 
				&& bndReflected != null && bndVisual != null && bndPatrol != null && bndDefs.get(0) != null) {
			bndRejectsERefugos.add(safeParseToInt(bndDrop));
			bndRejectsERefugos.add(safeParseToInt(bndScrap));
			bndRejectsERefugos.add(safeParseToInt(bndClear));
			bndRejectsERefugos.add(safeParseToInt(bndReflected));
			bndRejectsERefugos.add(safeParseToInt(bndVisual));
			bndRejectsERefugos.add(safeParseToInt(bndPatrol));
			// bndRejectsERefugos.add(safeParseToInt(bndDefs.get(0)));
		}
		for (String aux: bndDefs) {
			bndRejectsERefugos.add(safeParseToInt(aux));
		}
		bndRejectsERefugos.add(safeParseToInt(mldDrop1));
		bndRejectsERefugos.add(safeParseToInt(mldDrop2));
		bndRejectsERefugos.add(safeParseToInt(mldDrop3));
		bndRejectsERefugos.add(safeParseToInt(mldDrop4));
	}

	public boolean isLinhaNoPadraoEsperado() {
		// validacoes
		return true;
	}

	@Override
	public String toString() {
		return ("Data do evento: " + dateTime + "Cmd: " + cmd + "Machine ID: " + machineID + "ShopOrder: " + shopOrder
				+ "Order Status: " + orderStatus + "BShot: " + bShot + "BNDOk: " + bndOk);
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

	public List<EventoColetado> obtemEvento() {
		List<EventoColetado> retorno = new ArrayList<>();

		LinhaArquivoSonyMDB linhaAnteriorMesmoShopOrder = this.ic.obtemUltimaLinhaDaOpMaquinaMDB(getShopOrder(), icUpDTO.getUpDTO().getCd_up());
		if (linhaAnteriorMesmoShopOrder != null) {
			log.info("EventoLogSony: Ultima Linha obtida: " + linhaAnteriorMesmoShopOrder.toString());
			totalizadorRefugoValido = linhaAnteriorMesmoShopOrder.totalizadorRefugoValido;
		} else {
			log.info("EventoLogSony: Nao ha uma ultima Linha obtida ");
		}
		
		LinhaArquivoSonyMDB linhaAnteriorMesmaMaquina = this.ic.obtemUltimaLinhaDaMaquinaMDB(icUpDTO.getUpDTO().getCd_up());
		if (linhaAnteriorMesmaMaquina != null) {
			log.info("EventoLogSony: Ultima Linha obtida da mesma maquina: " + linhaAnteriorMesmaMaquina);
			// Verfica se a linha deve ser processada de acordo com a cronologia dos
			// eventos
			Date dateLinha = UtilsString.convertToDateLogSonyMDB(dateTime);
			if (dateLinha.before(UtilsString.convertToDateLogSonyMDB(linhaAnteriorMesmaMaquina.dateTime)))
				return retorno;
		} else {
			log.info("EventoLogSony: Nao ha uma ultima Linha obtida da mesma maquina");
		}

		// ------------------------------------------
		// Fim de ciclo
		EventoColetado eventoCiclo = geraEventoFimCiclo(linhaAnteriorMesmoShopOrder);
		if (eventoCiclo != null) {
			retorno.add(eventoCiclo);
			log.info("EventoLogSony: Gerou evento de fim de ciclo:;"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventoCiclo.getDthrEvento()) + ";"
					+ eventoCiclo.getCdop() + ";" + eventoCiclo.getQtde());
		}

		// ------------------------------------------
		// Refugo
		
		// Forma antiga de obter refugo: subtracao do Ashot pelo BndOk
		/*
			EventoColetado eventoRefugo = geraEventoRefugo(linhaAnteriorMesmoShopOrder);
			if (eventoRefugo != null) {
				retorno.add(eventoRefugo);
				log.info("EventoLogSony: Gerou evento de refugo:;" + eventoRefugo.getDthrEvento() + ";" + eventoRefugo.getCdop() + ";" + eventoRefugo.getQtde());
			}
		*/
		
		// Nova metodologia para obter refugos, utilizar BNDrejects
		List<EventoColetado> eventosBNDrejects = geraEventosBNDrejects(linhaAnteriorMesmoShopOrder);
		if (eventosBNDrejects != null) {
			retorno.addAll(eventosBNDrejects);
			log.info("EventoLogSony: Gerou eventos de refugos:;" + eventosBNDrejects.get(0).getDthrEvento() + ";" + eventosBNDrejects.get(0).getCdop() + ";" 
			+ eventosBNDrejects.get(0).getQtde());
		}

		if (retorno.size() > 0) {
			ic.getOpsMDB().put(getShopOrder() + icUpDTO.getUpDTO().getCd_up(), this);
			ic.getUltimasLinhasProcessadasMDB().put(icUpDTO.getUpDTO().getCd_up(), this);

			// A entrada e saida de planejamento deve ficar antes de qualquer
			// evento
			// gerado para esta linha
			// Para isso, a lista de eventos sera varrida em busca do evento
			// mais
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
				log.info("EventoLogSony: Gerou evento eventoCriaOPAutomatica:;"
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventoCriaOPAutomatica.getDthrEvento())
						+ ";" + eventoCriaOPAutomatica.getCdop());

				EventoColetado eventoEntradaPlanejamento = geraEventoEntradaPlanejamento(dataModificadaEventoMaisAntigo);
				retorno.add(eventoEntradaPlanejamento);
				log.info("EventoLogSony: Gerou evento eventoEntradaPlanejamento:;"
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventoEntradaPlanejamento.getDthrEvento())
						+ ";" + eventoEntradaPlanejamento.getCdop());

			}
		}

		log.info(idLog, 0, "Quantidade eventos obtidos: " + retorno.size());
		
		return retorno;
	}

	private List<EventoColetado> geraEventosBNDrejects(LinhaArquivoSonyMDB eventoAnteriorMesmoShopOrder) {
		List<EventoColetado> retorno = new ArrayList<>();
		// if (bndRejectsERefugos == null || bndRejectsERefugos.size() != 7 ) // 7 categorias de refugos
		if (bndRejectsERefugos == null )
			return null;
		
		for (int i = 0 ; i< bndRejectsERefugos.size(); i++) {
			EventoColetado eventoColetado = new EventoColetado();
			Date data = UtilsString.dateTimeStringToDate(dateTime);
			int quantidadeRefugadaAtual = bndRejectsERefugos.get(i);
			// Setando objeto que sera enviado
			eventoColetado.setTipoEvento(ServicoFactory._NOVOREFUGO); // Fim de Ciclo
			// Setando data + i pq eventos com datas iguais nao sao processados
			eventoColetado.setDthrEvento(new Date(data.getTime() + i));
			eventoColetado.setCdop(shopOrder);
			eventoColetado.setIcUpDTO(icUpDTO);
			eventoColetado.setCdproduto("1"); // convencao
			
			if (i > 6 && i < 13)
				eventoColetado.setCdrefugo(camposAdicionaisRefugo.get(i - 7)); // Criado no idw: Engenharia de processo
			else if (i > 12 && i < 29)
				//eventoColetado.setCdrefugo("BNDdef" + (i - 12)); // Criado no idw: Engenharia de processo
				eventoColetado.setCdrefugo("BNDdef" + (i - 11)); // Criado no idw: Engenharia de processo
			else if (i > 28)
				eventoColetado.setCdrefugo("MLDDrop" + (i - 28)); // Criado no idw: Engenharia de processo
			else
				eventoColetado.setCdrefugo("BNDreject" + i); // Criado no idw: Engenharia de processo
			
			eventoColetado.setOrigem(origem);
			eventoColetado.setCb("");
					
			if (eventoAnteriorMesmoShopOrder != null && eventoAnteriorMesmoShopOrder.getBndRejects() != null
					&& eventoAnteriorMesmoShopOrder.getBndRejects().get(i) != null) {
				int quantidadeRefugadaAnterior = eventoAnteriorMesmoShopOrder.getBndRejects().get(i);
				trataQuantidadeRefugo(eventoAnteriorMesmoShopOrder, eventoColetado, quantidadeRefugadaAtual, quantidadeRefugadaAnterior);
			} else {
				try {
					eventoColetado.setQtde(String.valueOf(quantidadeRefugadaAtual));
				} catch (Exception e) {
					log.error("Falha ao obter string quantidade refugada ATUAL " + toString());
					eventoColetado.setQtde("0");
				}
			}
			
			// Se a quantidade a ser inserida for maior que zero, envia-se o evento
			int eventoColetadoQtde = safeParseToInt(eventoColetado.getQtde());
			if (eventoColetadoQtde > 0) {
				retorno.add(eventoColetado);
			}
		}
		
		if (retorno.size() == 0)
			return null;
		
		return retorno;
	}

	private EventoColetado geraEventoSaidaPlanejamento(LinhaArquivoSonyMDB eventoAnteriorMesmaMaquina,
			Date dataModificadaEventoMaisAntigo) {

		EventoColetado eventoColetado = null;

		if (((eventoAnteriorMesmaMaquina != null) && (!(eventoAnteriorMesmaMaquina.getShopOrder().equals(shopOrder)))
				&& (dataModificadaEventoMaisAntigo
						.after(UtilsString.dateTimeStringToDate(eventoAnteriorMesmaMaquina.dateTime))))
				|| eventoAnteriorMesmaMaquina == null) {

			// if
			// (!(eventoAnteriorMesmaMaquina.getShopOrder().equals(shopOrder)))
			// {
			eventoColetado = new EventoColetado();
			eventoColetado.setTipoEvento(ServicoFactory._FINALIZA_OP); // Finaliza
																		// OP
			// eventoColetado.setDthrEvento(UtilsString.convertToDateLogSony(dDateTime));
			// eventoMaisAntigo
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
			// eventoColetado.setDthrEvento(UtilsString.convertToDateLogSony(dDateTime));
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

			eventoColetado.setTipoEvento(ServicoFactory._CRIA_OP_AUTOMATICA); // Finaliza
																				// OP
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

	// Antes, o evento de refugo nao considerava o tipo do refugo
	// Agora, os refugos sao classificados em 7 categorias e lancados separadamente
	// Por categoria
//	private EventoColetado geraEventoRefugo(LinhaArquivoSonyMDB eventoAnteriorMesmoShopOrder) {
//		EventoColetado eventoColetado = new EventoColetado();
//
//		// Setando objeto que sera enviado
//		eventoColetado.setTipoEvento(ServicoFactory._NOVOREFUGO); // Fim de Ciclo
//		eventoColetado.setDthrEvento(UtilsString.dateTimeStringToDate(dateTime));
//		eventoColetado.setCdop(shopOrder);
//		eventoColetado.setIcUpDTO(icUpDTO);
//		// eventoColetado.setCdproduto(shopOrder);
//		eventoColetado.setCdproduto("1");
//		eventoColetado.setCdrefugo("100"); // Criado no idw: Engenharia de processo
//		eventoColetado.setOrigem(origem);
//		eventoColetado.setCb("");
//
//		// int quantidadeRefugadaAtual = Integer.parseInt(orderNGQuantity);
//		int quantidadeRefugadaAtual = 0;
//		quantidadeRefugadaAtual = safeParseToInt(orderNGQuantity);
//
//		if (eventoAnteriorMesmoShopOrder != null) {
//			trataQuantidadeRefugo(eventoAnteriorMesmoShopOrder, eventoColetado, quantidadeRefugadaAtual);
//		} else {
//			try {
//				eventoColetado.setQtde(String.valueOf(quantidadeRefugadaAtual));
//			} catch (Exception e) {
//				log.error("Falha ao obter string quantidade refugada ATUAL " + toString());
//				eventoColetado.setQtde("0");
//			}
//
//		}
//
//		// Se a quantidade a ser inserida for maior que zero, envia-se o evento
//		int eventoColetadoQtde = 0;
//		eventoColetadoQtde = safeParseToInt(eventoColetado.getQtde());
//		// if (Integer.parseInt(eventoColetado.getQtde()) <= 0) {
//		if (eventoColetadoQtde <= 0) {
//			eventoColetado = null;
//		}
//
//		return eventoColetado;
//	}

	// Versao anterior que nao considera categorias
//	private void trataQuantidadeRefugo(LinhaArquivoSonyMDB eventoAnteriorMesmoShopOrder, EventoColetado eventoColetado,
//			int quantidadeRefugadaAtual) {
//		int quantidadeRefugadaAnterior = 0;
//		quantidadeRefugadaAnterior = safeParseToInt(eventoAnteriorMesmoShopOrder.orderNGQuantity);
//
//		int diff = quantidadeRefugadaAtual - quantidadeRefugadaAnterior;
//		// Se a diferenca for menor que zero, houve algum processo
//		// ainda nao elucidado de moficacao no Order Quantity
//		if (diff < 0) {
//			// Se a producao liquida nao diminuiu
//			if ((safeParseToInt(bndOk) - safeParseToInt(eventoAnteriorMesmoShopOrder.bndOk)) >= 0) {
//				// Reducao pra teste eletrico
//				// Lancar o evento dessa linha traz erros na contagem
//				eventoColetado.setQtde("0");
//			} else {
//				// Se o refugo diminuiu, trata-se de um novo processo produtivo
//				eventoColetado.setQtde(String.valueOf(quantidadeRefugadaAtual));
//				// eventoColetado.setQtde("0");
//				// eventoColetado.setQtde(String.valueOf(quantidadeRefugadaAtual));
//			}
//		} else {
//			eventoColetado.setQtde(String.valueOf(diff));
//		}
//	}
	
	private void trataQuantidadeRefugo(LinhaArquivoSonyMDB eventoAnteriorMesmoShopOrder, EventoColetado eventoColetado,
			int quantidadeRefugadaAtual, int quantidadeRefugadaAnterior) {
		int diff = quantidadeRefugadaAtual - quantidadeRefugadaAnterior;
		// Se a diferenca for menor que zero, houve algum processo
		// ainda nao elucidado de moficacao no Order Quantity
		if (diff < 0) {
			// Se a producao liquida nao diminuiu
			if ((safeParseToInt(bndOk) - safeParseToInt(eventoAnteriorMesmoShopOrder.bndOk)) >= 0) {
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
	
	private void trataQuantidadeRefugoTotal(LinhaArquivoSonyMDB eventoAnteriorMesmoShopOrder, EventoColetado eventoColetado) {
		// int quantidadeRefugadaAtualTotal = obtemRefugoTotal();
		int quantidadeRefugadaAtualTotal = safeParseToInt(bShot) - safeParseToInt(bndOk);
		int quantidadeRefugadaAnteriorTotal = 0;
		int quantidadeBndOkAnterior = 0;
		int diff = 0;
		
		// Se deve ser lancado refugo agora
		if (safeParseToInt(bndInSystem) == 0)
		{
			if (eventoAnteriorMesmoShopOrder != null && eventoAnteriorMesmoShopOrder.bndOk != null ) {
				// quantidadeRefugadaAnteriorTotal = eventoAnteriorMesmoShopOrder.obtemRefugoTotal();
				// quantidadeRefugadaAnteriorTotal = safeParseToInt(eventoAnteriorMesmoShopOrder.bShot) - safeParseToInt(eventoAnteriorMesmoShopOrder.bndOk);
				quantidadeRefugadaAnteriorTotal = safeParseToInt(eventoAnteriorMesmoShopOrder.totalizadorRefugoValido);
				quantidadeBndOkAnterior = safeParseToInt(eventoAnteriorMesmoShopOrder.bndOk);
			}
			diff = quantidadeRefugadaAtualTotal - quantidadeRefugadaAnteriorTotal;
			// Se a diferenca for menor que zero, houve algum processo
			// ainda nao elucidado de moficacao no Order Quantity
			if (diff < 0) {
				// Se a producao liquida nao diminuiu
				if ((safeParseToInt(bndOk) - quantidadeBndOkAnterior) >= 0) {
					// Reducao pra teste eletrico
					// Lancar o evento dessa linha traz erros na contagem
					eventoColetado.setProducaoRefugada(new BigDecimal("0"));
				} else {
					// Se o refugo diminuiu, trata-se de um novo processo produtivo
					//eventoColetado.setQtde(String.valueOf(quantidadeRefugadaAtualTotal));
					eventoColetado.setProducaoRefugada(new BigDecimal(quantidadeRefugadaAtualTotal));
					// Se foi possivel lancar o refugo atualizar o totalizadorRefugoValido
					totalizadorRefugoValido = String.valueOf(quantidadeRefugadaAtualTotal);
				}
			} else {
				eventoColetado.setProducaoRefugada(new BigDecimal(diff));
				// Se foi possivel lancar o refugo atualizar o totalizadorRefugoValido
				totalizadorRefugoValido = String.valueOf(quantidadeRefugadaAtualTotal);
			}
		} else {
			eventoColetado.setProducaoRefugada(new BigDecimal("0"));
		}
		
		// Atualiza a origem
		origem = origem + "," + totalizadorRefugoValido;
	}
	
	private void trataQuantidadeLiquida(LinhaArquivoSonyMDB eventoAnteriorMesmoShopOrder, EventoColetado eventoColetado) {
		int quantidadeLiquidaAtual = safeParseToInt(bndOk);
		int quantidadeLiquidaAnterior = 0;
		int quantidadeBShotAnterior = 0;
		int diff = 0;
		
		if (eventoAnteriorMesmoShopOrder != null 
				&& eventoAnteriorMesmoShopOrder.bndOk != null
				&& eventoAnteriorMesmoShopOrder.bShot != null) {
			quantidadeLiquidaAnterior = safeParseToInt(eventoAnteriorMesmoShopOrder.bndOk);
			quantidadeBShotAnterior = safeParseToInt(eventoAnteriorMesmoShopOrder.bShot);
		}
		diff = quantidadeLiquidaAtual - quantidadeLiquidaAnterior;
		// Se a diferenca for menor que zero, houve algum processo
		// ainda nao elucidado de moficacao no Order Quantity
		if (diff < 0) {
			// Se a producao bruta nao diminuiu
			if ((safeParseToInt(bShot) - quantidadeBShotAnterior) >= 0) {
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

	private EventoColetado geraEventoFimCiclo(LinhaArquivoSonyMDB eventoAnteriorMesmoShopOrder) {
		EventoColetado eventoColetado = new EventoColetado();
		int quantidadeTotalAtual = safeParseToInt(bShot);

		eventoColetado.setTipoEvento(ServicoFactory._FIM_CICLO); // Fim de Ciclo
		eventoColetado.setDthrEvento(UtilsString.dateTimeStringToDate(dateTime));
		eventoColetado.setCdop(shopOrder);
		eventoColetado.setCb("");
		eventoColetado.setIcUpDTO(icUpDTO);
		// eventoColetado.setOrigem(origem);
		
		if (eventoAnteriorMesmoShopOrder != null) {
			int quantidadeTotalAnterior = safeParseToInt(eventoAnteriorMesmoShopOrder.bShot);
			int diff = quantidadeTotalAtual - quantidadeTotalAnterior;
			// Se a diferenca for menor que zero, houve algum processo
			// ainda nao elucidado de moficacao no Order Quantity
			if (diff < 0) {
				// Se a producao liquida nao diminuiu
				if ((safeParseToInt(bndOk) - safeParseToInt(eventoAnteriorMesmoShopOrder.bndOk)) >= 0) {
					// Reducao pra teste eletrico
					// Lancar o evento dessa linha traz erros na contagem, entao sera lancado 0
					eventoColetado.setQtde("0");
				} else {
					eventoColetado.setQtde(String.valueOf(quantidadeTotalAtual));
					totalizadorRefugoValido = String.valueOf("0");
				}
			} else {
				// Se nao, adota-se a diferenca entre quantidades do estado atual
				// para o anterior
				eventoColetado.setQtde(String.valueOf(diff));
			}
		} else {
			eventoColetado.setQtde(String.valueOf(quantidadeTotalAtual));
			totalizadorRefugoValido = String.valueOf("0");
		}

		// Seta producao liquida
		trataQuantidadeLiquida(eventoAnteriorMesmoShopOrder, eventoColetado);
		// Seta producao refugada total
		trataQuantidadeRefugoTotal(eventoAnteriorMesmoShopOrder, eventoColetado);
		// Como a origem e atualizada em trataQuantidadeRefugoTotal, setOrigem deve ficar aqui
		eventoColetado.setOrigem(origem);

		// Se a quantidade a ser inserida for maior que zero, envia-se o evento
		int eventoColetadoQtde = safeParseToInt(eventoColetado.getQtde());
		if (eventoColetadoQtde <= 0) {
			eventoColetado = null;
		}
		if (quantidadeTotalAtual == 0) {
			totalizadorRefugoValido = String.valueOf("0");
		}
		
		return eventoColetado;
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

	private String getShopOrder() {
		return shopOrder;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getbShot() {
		return bShot;
	}

	public void setbShot(String bShot) {
		this.bShot = bShot;
	}

	public String getBndOk() {
		return bndOk;
	}

	public void setBndOk(String bndOk) {
		this.bndOk = bndOk;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public void setMachineID(String machineID) {
		this.machineID = machineID;
	}

	public void setShopOrder(String shopOrder) {
		this.shopOrder = shopOrder;
	}
	
	public String getLinha() {
		return this.linha;
	}

	public List<Integer> getBndRejects() {
		return bndRejectsERefugos;
	}

	public void setBndRejects(List<Integer> bndRejects) {
		this.bndRejectsERefugos = bndRejects;
	}

	public String getBndReject0() {
		return bndReject0;
	}

	public void setBndReject0(String bndReject0) {
		this.bndReject0 = bndReject0;
	}

	public String getBndReject1() {
		return bndReject1;
	}

	public void setBndReject1(String bndReject1) {
		this.bndReject1 = bndReject1;
	}

	public String getBndReject2() {
		return bndReject2;
	}

	public void setBndReject2(String bndReject2) {
		this.bndReject2 = bndReject2;
	}

	public String getBndReject3() {
		return bndReject3;
	}

	public void setBndReject3(String bndReject3) {
		this.bndReject3 = bndReject3;
	}

	public String getBndReject4() {
		return bndReject4;
	}

	public void setBndReject4(String bndReject4) {
		this.bndReject4 = bndReject4;
	}

	public String getBndReject5() {
		return bndReject5;
	}

	public void setBndReject5(String bndReject5) {
		this.bndReject5 = bndReject5;
	}

	public String getBndReject6() {
		return bndReject6;
	}

	public void setBndReject6(String bndReject6) {
		this.bndReject6 = bndReject6;
	}
	
	public int obtemRefugoTotal() {
		int retorno = 0;
		if (bndRejectsERefugos != null) {
			for (int i = 0; i < bndRejectsERefugos.size(); i++) {
				retorno += bndRejectsERefugos.get(i);
			}
		}
		return retorno;
	}

	public String getBndDrop() {
		return bndDrop;
	}

	public void setBndDrop(String bndDrop) {
		this.bndDrop = bndDrop;
	}

	public String getBndScrap() {
		return bndScrap;
	}

	public void setBndScrap(String bndScrap) {
		this.bndScrap = bndScrap;
	}

	public String getBndClear() {
		return bndClear;
	}

	public void setBndClear(String bndClear) {
		this.bndClear = bndClear;
	}

	public String getBndReflected() {
		return bndReflected;
	}

	public void setBndReflected(String bndReflected) {
		this.bndReflected = bndReflected;
	}

	public String getBndVisual() {
		return bndVisual;
	}

	public void setBndVisual(String bndVisual) {
		this.bndVisual = bndVisual;
	}

	public String getBndPatrol() {
		return bndPatrol;
	}

	public void setBndPatrol(String bndPatrol) {
		this.bndPatrol = bndPatrol;
	}
	public List<String> getBndDefs() {
		return bndDefs;
	}

	public void setBndDefs(List<String> bndDefs) {
		this.bndDefs = bndDefs;
	}

	public String getMldDrop1() {
		return mldDrop1;
	}

	public void setMldDrop1(String mldDrop1) {
		this.mldDrop1 = mldDrop1;
	}

	public String getMldDrop2() {
		return mldDrop2;
	}

	public void setMldDrop2(String mldDrop2) {
		this.mldDrop2 = mldDrop2;
	}

	public String getMldDrop3() {
		return mldDrop3;
	}

	public void setMldDrop3(String mldDrop3) {
		this.mldDrop3 = mldDrop3;
	}

	public String getMldDrop4() {
		return mldDrop4;
	}

	public void setMldDrop4(String mldDrop4) {
		this.mldDrop4 = mldDrop4;
	}

	public String getBndInSystem() {
		return bndInSystem;
	}

	public void setBndInSystem(String bndInSystem) {
		this.bndInSystem = bndInSystem;
	}

	public String getTotalizadorRefugoValido() {
		return totalizadorRefugoValido;
	}

	public void setTotalizadorRefugoValido(String totalizadorRefugoValido) {
		this.totalizadorRefugoValido = totalizadorRefugoValido;
	}
	
}// Fim da Classe
