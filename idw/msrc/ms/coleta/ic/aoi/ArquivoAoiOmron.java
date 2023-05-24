package ms.coleta.ic.aoi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.EmailException;

import idw.model.IdwFacade;
import idw.model.excessoes.PostoSemDadoException;
import idw.model.excessoes.SemFeedersException;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.OmMapapa;
import idw.model.rn.DataHoraRN;
import idw.util.EnviarEmail;
import idw.util.IdwLogger;
import idw.webservices.dto.DefeitoDTO;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsString;

public class ArquivoAoiOmron {
	protected IdwLogger log;
	// nomeArquivoDestino
	protected String nomeArquivo;
	// pathDestino
	protected String pathArquivo;
	protected IcUpDTO icUpDTO;
	protected List<String> linhas = new ArrayList<>();

	protected String programName = "";
	private String createDate = "";
	protected String reviseEndDate = "";

	private String nomeArquivoOrigem;
	private String pathArquivoOrigem;

	private String componentNo = "";
	private String partsName = "";
	private String partsArticleNo = "";
//	private String faultCode = ""; Alessandre sem uso no momento
	private String revisedFaultId = "";
	protected List<DefeitoDTO> defeitos = null;

	// Luiz - 20190418 - Adicionado atributo que guardará o código de barras lido pela AOI
	protected String cbPlaca = "";

	private enum Posicoes {
		InspectionMachine(5), ProgramNamePos(7), BothSideCode(8), CreateDate(18), ReviseEndDate(22), TestResult(23), ReviseResult(
				24), Barcode(27), BarcodeAux(36), ComponentNo(41), PartsName(42), PartsArticleNo(46), FaultCode(49), RevisedFaultId(50);

		private final int valor;

		Posicoes(int valorOpcao) {
			valor = valorOpcao;
		}

		public int getValor() {
			return valor;
		}
	}

	// Fabricio (04/09/2018) alterei o mapa de defeitos
	/*
	private Map<String, String> listaCdComp_PosicaoMec = new HashMap<String, String>();
	private Map<String, String> listaCdComp_CdDefeito = new HashMap<String, String>();
	private List<String> listaComponente = new ArrayList<String>();
	private List<String> listaDefeito = new ArrayList<String>();
*/
	
	public static final String _CD_CB_AUSENTE = "1";
	public static final String _CB_AUSENTE = "CB Ausente";
	public static final String _CD_CB_DUPLICADO = "2";
	public static final String _CB_DUPLICADO = "CB Duplicado";

	public ArquivoAoiOmron() {
		
	}
	
	public ArquivoAoiOmron(IdwLogger log, String nomeArquivoDestino, String pathDestino, String nomeArquivoOrigem, String pathArquivoOrigem) {
		super();
		
		this.log = log;
		this.nomeArquivo = nomeArquivoDestino;
		this.pathArquivo = pathDestino;

		this.nomeArquivoOrigem = nomeArquivoOrigem;
		this.pathArquivoOrigem = pathArquivoOrigem;
	}

	public List<EventoColetado> obtemEvento(ICAoiOmron ic) {
		List<EventoColetado> retorno = new ArrayList<>();
		try {
			if (linhas != null) {
				retorno = processarLog();
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("ArquivoAoiOmron: Excessao em obtemEvento da maquina: " + getIcUpDTO().getUpDTO().getCd_up() + " - " + e);
		}
		return retorno;
	}

	protected List<EventoColetado> processarLog() {

		List<EventoColetado> retorno = new ArrayList<>();

		String cdUp = icUpDTO.getUpDTO().getCd_up();
		String cdOp = "op";
		String machName = null;
		String botOrTop = "";

		Date dataHoraFimTeste = null;

		if (this.linhas.isEmpty() == false) {
			String linha = this.linhas.get(0);
			String[] linhaSplitada = UtilsString.safeSplit(linha, ",");

			machName = UtilsString.removeApas(linhaSplitada[Posicoes.InspectionMachine.getValor()]);
			programName = UtilsString.removeApas(linhaSplitada[Posicoes.ProgramNamePos.getValor()]);

			botOrTop = UtilsString.removeApas(linhaSplitada[Posicoes.BothSideCode.getValor()]);
			createDate = UtilsString.removeApas(linhaSplitada[Posicoes.CreateDate.getValor()]);
			// Se nao houve revisao, a data sera vazia
			reviseEndDate = UtilsString.removeApas(linhaSplitada[Posicoes.ReviseEndDate.getValor()]);

			dataHoraFimTeste = DataHoraRN.getDataHoraAtual();

			// Luiz - 20191105 Recoloquei a rotina de defeitos
			defeitos = criaDefeitosAPartirDoLog(this.linhas, dataHoraFimTeste);

			// Luiz 20190418 - Tentativa de pegar o CB
			// Luiz 2019022 - Caso o código lido seja diferente nas linhas, pega o consistente
			if ((linhaSplitada[Posicoes.Barcode.getValor()] != null) && linhaSplitada[Posicoes.Barcode.getValor()].length() > 0) {
				cbPlaca = UtilsString.removeApas(linhaSplitada[Posicoes.Barcode.getValor()]);
				if (this.icUpDTO.getUrlAuxiliar() == null && this.icUpDTO.getUrlAuxiliar().equals("")) {
					StringBuilder msg = new StringBuilder();
					msg.append("Cadastro do icup não possui ip na urlAuxiliar, logo a API não funcionará para a UP ");
					msg.append(cdUp);
					this.log.info(msg);
					this.enviarEmail("sem CB", cdOp, cdUp, this.icUpDTO, msg, "semArq", "semArq");
				}
			}
		}

		if (machName == null || machName.equals("0")) {
			StringBuilder msg = new StringBuilder();
			msg.append("Erro ao obter o nome da máquina vindo do log. Arquivo descartado: ");
			msg.append(nomeArquivo);
			msg.append(" da UP ");
			msg.append(cdUp);
			log.info(msg.toString());
			this.enviarEmail("sem CB", cdOp, cdUp, this.icUpDTO, msg, "semArq", "semArq");
			return null;
		}
		if (createDate == null || createDate.equals("0")) {
			StringBuilder msg = new StringBuilder();
			msg.append("Erro ao obter o createDate vindo do log. Arquivo descartado: ");
			msg.append(nomeArquivo);
			msg.append(" da UP ");
			msg.append(cdUp);
			log.info(msg.toString());
			this.enviarEmail("sem CB", cdOp, cdUp, this.icUpDTO, msg, "semArq", "semArq");
			return null;
		}
		if (reviseEndDate == null || reviseEndDate.equals("0")) {
			StringBuilder msg = new StringBuilder();
			msg.append("Erro ao obter o reviseEndDate do log. Arquivo descartado: ");
			msg.append(nomeArquivo);
			msg.append(" da UP ");
			msg.append(cdUp);
			log.info(msg.toString());
			this.enviarEmail("sem CB", cdOp, cdUp, this.icUpDTO, msg, "semArq", "semArq");
			return null;
		}

		// UtilsString.dateTimeStringToDateOMRON(createDate);;
		cdOp = programName;
		if (dataHoraFimTeste == null) {
			StringBuilder msg = new StringBuilder();
			msg.append("Erro oa realizar parse da data, processamento do arquivo sendo descartado: ");
			msg.append(nomeArquivo);
			msg.append(" da UP ");
			msg.append(cdUp);
			log.info(msg.toString());
			this.enviarEmail("sem CB", cdOp, cdUp, this.icUpDTO, msg, "semArq", "semArq");
			return retorno;
		}

		// placaOk sempre true pois o driver da AOI não está lancando defeito, apenas a rastreabilidade
		// isso pq a maior parte dos defeitos da AOI são defeitos falsos.
		// Alessandre em 16-10-19 comentei pois no momento nao tem perspectiva de retornar a captura dos erros falsos
		// placaOk = true;
		// if (placaOk) {
		retorno = criaEventoColetadoTesteSimples(cdUp, cdOp, dataHoraFimTeste, "1", cbPlaca, machName, botOrTop, icUpDTO, nomeArquivoOrigem, pathArquivoOrigem);
		// } else {
		// retorno = criaEventoColetadoTesteDefeito(cdUp, cdOp, "", dataHoraFimTeste, "1", cbPlaca, machName, botOrTop, icUpDTO);
		// }

		if (cbPlaca != null && cbPlaca.length() > 0)
			preencheCbserialDasPlacasNaoPrincipais(retorno, cbPlaca);

		// Luiz 20191105 Adicionei essa condicao casa aconteca erro no log independente do cb da placa
		if (defeitos != null && defeitos.size() > 0) {
			adicionaDefeitosNaPlacaPrincipal(retorno, defeitos, cbPlaca);
		}

		return retorno;
	}

	protected void adicionaDefeitosNaPlacaPrincipal(List<EventoColetado> lista, List<DefeitoDTO> defeitosLista, String cbPlacaPrincipal) {
		if (lista.isEmpty() == false && lista.size() > 1) {
			for (EventoColetado evento : lista) {
				if (evento.getCb().equals(cbPlacaPrincipal))
					evento.setDefeitos(defeitosLista);
			}
		} else {
			// Pode ser que nao tenha elemento na lista. Isso ocorre quando o CB nao foi lido nem gerado. Nessa caso os defeitos serao descartados
			if (lista.size() == 1)
				lista.get(0).setDefeitos(defeitosLista);
		}

	}

	private List<DefeitoDTO> criaDefeitosAPartirDoLog(List<String> linhasArquivo, Date dataHoraFimTeste) {
		List<DefeitoDTO> defeitos = new ArrayList<DefeitoDTO>();
		for (String linhaDefeito : linhasArquivo) {
			String[] linhaSplitadaDefeito = UtilsString.safeSplit(linhaDefeito, ",");
			componentNo = UtilsString.removeApas(linhaSplitadaDefeito[Posicoes.ComponentNo.getValor()]);
			partsName = UtilsString.removeApas(linhaSplitadaDefeito[Posicoes.PartsName.getValor()]);
			partsArticleNo = UtilsString.removeApas(linhaSplitadaDefeito[Posicoes.PartsArticleNo.getValor()]);
//			faultCode = UtilsString.removeApas(linhaSplitadaDefeito[Posicoes.FaultCode.getValor()]); Alessandre sem uso
			revisedFaultId = UtilsString.removeApas(linhaSplitadaDefeito[Posicoes.RevisedFaultId.getValor()]);

			if (!componentNo.equals("") && !partsName.equals("") && !partsArticleNo.equals("") && !revisedFaultId.equals("")) {
				if (!revisedFaultId.equals("0")) {
					String posicaoMecanica = partsName + "_" + componentNo;
					DefeitoDTO defeito = new DefeitoDTO();
					defeito.setCdDefeito(revisedFaultId);
					defeito.setDthrDefeito(dataHoraFimTeste);
					defeito.setCb(partsArticleNo); // codigo do componente
					defeito.setPosicoes(posicaoMecanica); // Posicao Mecanica
					defeitos.add(defeito);
				}
			}
		}
		return defeitos;
	}

	// Avalia se o codigo pai e filhos sao validos
	private boolean isCBValido(String cbPai, List<String> cbFilhos, String cdOp, String cdUp, IcUpDTO icup, String nomeArquivo, String arquivo, int nTotalEsperado) {
		boolean isRetorno = true;
		String cdParada = _CD_CB_AUSENTE;
		String dsParada = _CB_AUSENTE;

		StringBuilder msgEmail = new StringBuilder();

		List<OmMapapa> pasSemAlimentacao = null;

		// Se o cbPai for nulo ou vazio então o CB eh invalido
		if (cbPai == null || (cbPai != null && cbPai.trim().equals(""))) {
			msgEmail.append("Código de barras está vazio");
			msgEmail.append("\n\r");
			isRetorno = false;
		}

		// Verifica se os cbs filhos estão vazios. Nunca estarão pois mesmo que a placa tenha apenas um CB esse CB se repete na lista
		if (cbFilhos == null || cbFilhos.isEmpty()) {
			msgEmail.append("Todos códigos de barras da API estão vazios para o principal ");
			msgEmail.append(cbPai);
			msgEmail.append("\n\r");
			isRetorno = false;
		} else {

			/* No trecho abaixo existe um filtro para identificar que a API da Omron enviou um CB em branco
			 * Entretanto, ocorre da API enviar um CB em branco a mais alem dos validos. Nessa situacao contaremos quantos CBs validos foram enviados e
			 * se esse numero é igual ao esperado em producao por ciclo.
			 */
			int contadorCBsValidos = 0;
			
			// Veificar se existe SERIAL duplicado
			boolean isAlgumVazio = false;
			for (String cbDaPlaca : cbFilhos) {
				if (cbDaPlaca == null || (cbDaPlaca != null && cbDaPlaca.trim().equals(""))) {
					msgEmail.append("Código de barras vazio da API para o principal ");
					msgEmail.append(cbPai);
					msgEmail.append("\n\r");
					isRetorno = false;
					isAlgumVazio = true;
				} else {
					contadorCBsValidos++;
				}
			}
			// Avaliar se a qt CBs validos eh a qtde esperada. Se sim, entao CB esta valido
			if (contadorCBsValidos == nTotalEsperado) {
				isAlgumVazio = false;
				isRetorno = true;
			} else {
				msgEmail.append("Esperado ");
				msgEmail.append(String.valueOf(nTotalEsperado));
				msgEmail.append(" CBs, mas foram lidos ");
				msgEmail.append(String.valueOf(contadorCBsValidos));
			}
			
			
			if (isAlgumVazio) {
				msgEmail.append("\n\rA seguir todos os CBs lidos pela API:");
				int sequencial = 1;
				for (String cbDaPlaca : cbFilhos) {
					msgEmail.append("\n\r");
					msgEmail.append(sequencial);
					msgEmail.append("o CB da API: [");
					msgEmail.append(cbDaPlaca);
					msgEmail.append("]");

					sequencial++;
				}
			}
		}
		if (isRetorno) {
			String cbDuplicado = verificaCBDuplicados(cdUp, cbPai, cbFilhos);
			if (cbDuplicado != null) {
				isRetorno = false;
				cdParada = _CD_CB_DUPLICADO;
				dsParada = _CB_DUPLICADO;
				msgEmail.append("\nCódigo de barras ");
				msgEmail.append(cbPai);
				msgEmail.append(" duplicado");
			}
		}

		if (isRetorno) {
			// Verifica se falta alimentar alguma materia-prima
			try {
				pasSemAlimentacao = IdwFacade.getInstancia().obtemPaSemAlimentacao(cdUp);
			} catch (SemFeedersException e) {
				isRetorno = false;
				msgEmail.append(cdUp + " - Ocorreu a excessao: " + e.getMessage() + "\n\r");
			} catch (PostoSemDadoException e) {
				isRetorno = false;
				msgEmail.append(e.getComplemento());
			}
			if (pasSemAlimentacao != null && pasSemAlimentacao.isEmpty() == false) {
				isRetorno = false;
				msgEmail.append("PAs sem saldo:\n\r");
				for (OmMapapa ommapa : pasSemAlimentacao) {
					msgEmail.append("Posto: ");
					msgEmail.append(ommapa.getOmMapa().getOmPt().getCdPt());
					msgEmail.append("\n\rMapa: ");
					msgEmail.append(ommapa.getOmMapa().getCdMapa());
					msgEmail.append("\n\rPA: ");
					msgEmail.append(ommapa.getOmPa().getCdPa());
					msgEmail.append("\n\rProduto: ");
					msgEmail.append(ommapa.getOmProduto().getCdProduto());
					msgEmail.append("\n\rGrupo= ");
					msgEmail.append(ommapa.getOmProduto().getOmProgrp().getCdProgrp());
					msgEmail.append("\n\rCB principal:");
					msgEmail.append(cbPai);
					if (cbFilhos != null && cbFilhos.isEmpty() == false) {
						msgEmail.append("\n\rCBs:\n\r");
						for (String cbfilho : cbFilhos) {
							msgEmail.append(cbfilho);
							msgEmail.append("\n\r");
						}
					}
				}
				log.info("PAs sem saldo: " + msgEmail.toString());
			} else {
				msgEmail.append("Alimentação feita corretamente. Talvez aqui verificar o BOM.\n\r");
			}

			// Apagar as 3 linhas abaixo qdo tiver pegando os pasemalimentacao
			if (isRetorno == false)
				enviarEmail(cbPai, cdOp, cdUp, icup, msgEmail, nomeArquivo, arquivo);
			
			isRetorno = true;
		}

		if (isRetorno == false) {
			trataCBAnomalo(cdOp, cdUp, "ArquivoAoiOmron.class", cdParada, dsParada);

			enviarEmail(cbPai, cdOp, cdUp, icup, msgEmail, nomeArquivo, arquivo);

		}
		return isRetorno;
	}

	protected void enviarEmail(String cbPai, String cdOp, String cdUp, IcUpDTO icup, StringBuilder msgEmail, String nomeArquivo, String arquivo) {
		List<String> emails = idw.util.UtilsString.quebrarStringEmVetor(icup.getIc().getEmailAoiNC(), ";");
		if (emails.isEmpty() == false && icup.getIc().getEmailAoiNC().trim().equals("") == false) {
			try {
				log.info("Enviando email para " + icup.getIc().getEmailAoiNC());
				log.info("Texto email: " + msgEmail.toString());
				EnviarEmail.enviarEmail(
						emails,
						"NC posto " + cdUp + " com OP " + cdOp + " CB " + cbPai,
						msgEmail.toString(),
						nomeArquivo,
						arquivo);
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.info("EnviarEmail", e);
			}
		}
	}

	// Cria o eventoColetado tratando os CBs anomalos
	private List<EventoColetado> criaEventoColetadoTesteSimples(
			String cdUp, 
			String cdOp, 
			Date dataHoraFimTeste, 
			String qtde, 
			String cbLido,
			String machName, 
			String botOrTop, 
			IcUpDTO icup, 
			String nomeArquivo, 
			String arquivo) {

		List<EventoColetado> retorno = new ArrayList<>();

		APIClientOmron clienteAPI = null;
		if (icup.getUrlAuxiliar() != null && icup.getUrlAuxiliar().trim().equals("") == false) {
			clienteAPI = new APIClientOmron(this.log, icup.getUrlAuxiliar());
		}
		List<String> cbLidos = null;
		if (clienteAPI != null)
			cbLidos = clienteAPI.getBarcodesFromBlanck(cbLido, machName, botOrTop);

		boolean isCBValido = true;

		int nTotalEsperado = IdwFacade.getInstancia().getProducaoPorCiclo(cdUp);

		if (cbLidos != null)
			isCBValido = isCBValido(
					cbLido,
					cbLidos,
					cdOp,
					cdUp,
					icup,
					nomeArquivo,
					arquivo,
					nTotalEsperado);

		else {
			
			/* Existem duas situacoes. A primeira o driver esta configurado para ler codigo de barras. Nessa situacao caso o CB nao tenha sido lido, entao um email deve ser enviado
			 * A 2a situacao é quando o produto esta configurado para nao ler cb. Nesse caso um CB deve ser gerado para que os defeitos sejam lancados
			 * */
			
			if (icup.getUpDTO().isLerCB() == false) {
				log.info("Produto " + icup.getUpDTO().getCdproduto() + " configurado para não ler CB");
				cbLidos = new ArrayList<>();
				if (cbLido == null || cbLido.trim().equals(""))
					cbLido = "NS" + cdUp + DataHoraRN.dateToStringDDMMYYYYHHMMSS(dataHoraFimTeste);
				cbLidos.add(cbLido);
			} else {
				isCBValido = false;
				
				StringBuilder msgEmail = new StringBuilder();
				msgEmail.append("O arquivo de log em anexo não apresenta nenhum código de barras ");
				msgEmail.append("\n\rEsperado ");
				msgEmail.append(String.valueOf(nTotalEsperado));
				msgEmail.append(" CBs, mas nenhum foi lido");
	
				// Manda email avisa q a qtde esperado <> da real
				enviarEmail(cbLido, cdOp, cdUp, icup, msgEmail, nomeArquivo, arquivo);
			}

		}
		
		if (isCBValido) {
			// Caso
			int qtdePorCiclo = cbLidos.size();
			Date dthrEvento = DataHoraRN.getDataHoraAtual();
			for (String cbDaPlaca : cbLidos) {
				if (cbDaPlaca == null || (cbDaPlaca != null && cbDaPlaca.trim().equals("")))
					continue;
				
				EventoColetado ev = new EventoColetado();
				ev.setCb(cbDaPlaca);
				ev.setCdop(cdOp);
				ev.setUp(cdUp);
				ev.setIcUpDTO(icUpDTO);
				ev.setQtde(String.valueOf(qtdePorCiclo));
				ev.setIsCbConforme(true);
				ev.setDthrEvento(dthrEvento);
				ev.setLog(log);
				ev.setTipoEvento(ServicoFactory._PASSAGEM); // Passagem
				ev.setOrigem(nomeArquivo);
				retorno.add(ev);

				dthrEvento = DataHoraRN.adicionaMilisegundosNaData(dthrEvento, 10);
			}
		}
		return retorno;

	}

	protected String verificaCBDuplicados(String cdUp, String cbPai, List<String> cbLidos) {
		int size = cbLidos.size();
		String retorno = null;
		try {
			for (int i = 0; i < size; i++) {
				for (int j = i + 1; j < size; j++) {
					if (cbLidos.get(i).equals(cbLidos.get(j))) {
						retorno = cbLidos.get(i);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Verificar se o CB ja tem registro de passagem no posto. Se tiver entao esta duplicado tambem
		List<DwPassagem> passagens = IdwFacade.getInstancia().pesquisarPassagensDoCbNoPosto(cdUp, new ArrayList<Object>(cbLidos));
		if (passagens.isEmpty() == false) {
			for (DwPassagem dwpassagem : passagens) {
				retorno = dwpassagem.getDwNserie().getCb();
			}
		}
		return retorno;
	}

	private boolean trataCBAnomalo(String cdOp, String cdUp, String origem, String cdParada, String dsParada) {
		// A primeira medida para o CB ausente deve ser o lancamento de uma parada que requer cancelamento
		EventoColetado ev = criaEventoParada(cdOp, cdUp, cdParada, dsParada);
		if (origem != null && !origem.equals(""))
			ev.setOrigem(nomeArquivo + "-" + origem);
		// Como e um evento prioritario
		MensagemRecebida mensagemInicioParada = new MensagemRecebida(ev);
		mensagemInicioParada.setLog(log);
		mensagemInicioParada.setDadosIcDTO(icUpDTO.getIc());
		try {
			ServicoFactory.getInstancia().executaServico(null, mensagemInicioParada);
		} catch (ServicoFalhouException e) {
			e.printStackTrace();
			log.info("Excecao ao tratar CB anomalo: " + e);
			return false;
		}

		return true;
	}

	private EventoColetado criaEventoParada(String cdOp, String cdUp, String cdParada, String descricaoParada) {
		EventoColetado ev = new EventoColetado();
		ev.setCdop(cdOp);
		ev.setUp(cdUp);
		ev.setIcUpDTO(icUpDTO);
		ev.setIsCbConforme(true);
		ev.setDthrEvento(DataHoraRN.getDataHoraAtual());
		ev.setLog(log);
		ev.setTipoEvento(ServicoFactory._INICIO_PARADA); // Passagem
		ev.setOrigem(nomeArquivo + "_NS-" + icUpDTO.getUpDTO().getCd_up() + "-" + (new Date()).getTime());
		ev.setCdparada(cdParada);
		ev.setCb(descricaoParada);
		return ev;
	}

	private IcUpDTO getIcUpDTO() {
		return icUpDTO;
	}

	public void setLinhas(List<String> retorno) {
		this.linhas = retorno;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public String getPathArquivo() {
		return pathArquivo;
	}

	public void setIcUpDTO(IcUpDTO icUpDTO) {
		this.icUpDTO = icUpDTO;
	}

	protected void preencheCbserialDasPlacasNaoPrincipais(List<EventoColetado> lista, String blanck) {
		// Luiz - 20190503 - Ale me pediu para enviar os eventos ordenados dessa forma e com o evento
		// da placa principal por ultimo e com cbSerial vazio. Apenas as outras placas utilizam o cbserial
		// apontando para o principal
		for (EventoColetado evento : lista) {
			if (!evento.getCb().equals(blanck))
				evento.setCbserial(blanck);
		}

	}
}
