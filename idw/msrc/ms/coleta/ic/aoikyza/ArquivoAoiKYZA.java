package ms.coleta.ic.aoikyza;

import java.text.SimpleDateFormat;
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

public class ArquivoAoiKYZA {
	protected IdwLogger log;
	// nomeArquivoDestino
	protected String nomeArquivo;
	// pathDestino
	protected String pathArquivo;
	protected IcUpDTO icUpDTO;
	protected List<String> linhas = new ArrayList<>();

	protected String programName = "";
	private String createDate = "";
	//protected String reviseEndDate = ""; 

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
		
		MachineID(0), JobFile(1), EndTime(5), Result(6), Barcode(2);
		// Result : 'GOOD' 'PASS' 'PASSED', passou
		
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

	public ArquivoAoiKYZA() {
		
	}
	
	public ArquivoAoiKYZA(IdwLogger log, String nomeArquivoDestino, String pathDestino, String nomeArquivoOrigem, String pathArquivoOrigem) {
		super();
		
		this.log = log;
		this.nomeArquivo = nomeArquivoDestino;
		this.pathArquivo = pathDestino;

		this.nomeArquivoOrigem = nomeArquivoOrigem;
		this.pathArquivoOrigem = pathArquivoOrigem;
	}

	public List<EventoColetado> obtemEvento(ICAoiKYZA ic) {
		List<EventoColetado> retorno = new ArrayList<>();
		try {
			if (linhas != null) {
				retorno = processarLog();
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("ArquivoAoiKYZA: Excessao em obtemEvento da maquina: " + getIcUpDTO().getUpDTO().getCd_up() + " - " + e);
		}
		return retorno;
	}

	protected List<EventoColetado> processarLog() {

		List<EventoColetado> retorno = new ArrayList<>();

		String cdUp = icUpDTO.getUpDTO().getCd_up();
		String cdOp = "op";
		String machName = null;
		String botOrTop = "";
		String result = "";
		
		boolean placaOk = true;

		Date dataHoraFimTeste = null;
		
		String[] linhanaformavetorstringauxiliar = null;


		if (this.linhas.isEmpty() == false) {
			String linha = this.linhas.get(0);
			String[] linhaSplitada = UtilsString.safeSplit(linha, ",");

			machName = UtilsString.removeApas(linhaSplitada[Posicoes.MachineID.getValor()]);
			machName = machName.replaceAll("[^a-zA-Z0-9_: -]*","");

			
			
			programName = UtilsString.removeApas(linhaSplitada[Posicoes.JobFile.getValor()]);
			programName = programName.replaceAll("[^a-zA-Z0-9_.: -\\\\]*","");
			if(programName !=null) {
				linhanaformavetorstringauxiliar  = UtilsString.safeSplit(programName, "\\\\");
			}
			if (linhanaformavetorstringauxiliar!=null && linhanaformavetorstringauxiliar.length>0) {
				programName = linhanaformavetorstringauxiliar[linhanaformavetorstringauxiliar.length-1];
			}
			if (programName!=null && !programName.trim().equals("") ) {
				programName = programName.substring(0, Math.min(programName.length(), 60));
			}

			botOrTop = "";

			createDate = UtilsString.removeApas(linhaSplitada[Posicoes.EndTime.getValor()]);
			createDate = createDate.replaceAll("[^a-zA-Z0-9_: -]*","");
			
			
			dataHoraFimTeste = DataHoraRN.getDataHoraAtual();

			
			placaOk = true;
			result = "";
			result = UtilsString.removeApas(linhaSplitada[Posicoes.Result.getValor()]);
			result = result.replaceAll("[^a-zA-Z0-9_: -]*","");
			
			
			if (result!=null){
				result = result.trim();
			}
			if (result!=null) {
				placaOk = false;
				if ( (result.equals("GOOD"))  || (result.equals("PASS")) || (result.equals("PASSED")) ) {
					placaOk = true;
				}
			}
			
			defeitos = null;
			if (! placaOk ) {
				//202208 defeitos = criaDefeitosAPartirDoLog(this.linhas, dataHoraFimTeste);
				defeitos = criaDefeitosDefault( dataHoraFimTeste);				
			}
			
			

			// CB
			if ((linhaSplitada[Posicoes.Barcode.getValor()] != null) && linhaSplitada[Posicoes.Barcode.getValor()].length() > 0) {
				cbPlaca = UtilsString.removeApas(linhaSplitada[Posicoes.Barcode.getValor()]);
				cbPlaca = cbPlaca.replaceAll("[^a-zA-Z0-9_: -]*","");
				
				
				/*202208NA
				//Trecho para tratar API extra da máquina
				if (this.icUpDTO.getUrlAuxiliar() == null && this.icUpDTO.getUrlAuxiliar().equals("")) {
					StringBuilder msg = new StringBuilder();
					msg.append("Cadastro do icup não possui ip na urlAuxiliar, logo a API não funcionará para a UP ");
					msg.append(cdUp);
					this.log.info(msg);
					this.enviarEmail("sem CB", cdOp, cdUp, this.icUpDTO, msg, "semArq", "semArq");
				}
				*/
				
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
		


		// UtilsString.dateTimeStringToDateKYZA(createDate);;
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
		
		
		Date dataevento;
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd K:mm:ss a"); 
		if(createDate!=null) {
			try {
				dataevento = formato.parse(createDate);
				dataHoraFimTeste = dataevento;
			}catch(Exception e) {}
		}
		
		

		if (placaOk) {
			retorno = criaEventoColetadoTesteSimples(cdUp, cdOp, dataHoraFimTeste, "1", cbPlaca, machName, botOrTop, icUpDTO, nomeArquivoOrigem, pathArquivoOrigem);
		} else {
			retorno = criaEventoColetadoTesteDefeito(cdUp, cdOp, dataHoraFimTeste, "1", cbPlaca, machName, botOrTop, icUpDTO, nomeArquivoOrigem, pathArquivoOrigem, defeitos);
		}

		
		/* 20220902NA NAOAPLICAVEL 
		if (cbPlaca != null && cbPlaca.length() > 0)
			preencheCbserialDasPlacasNaoPrincipais(retorno, cbPlaca);
		*/
		

		//20220822 //NA // Luiz 20191105 Adicionei essa condicao casa aconteca erro no log independente do cb da placa
		//20220822 if (defeitos != null && defeitos.size() > 0) {
		//20220822 	adicionaDefeitosNaPlacaPrincipal(retorno, defeitos, cbPlaca);
		//20220822 }
		

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
			componentNo = UtilsString.removeApas(linhaSplitadaDefeito[Posicoes.Barcode.getValor()]);
			partsName = UtilsString.removeApas(linhaSplitadaDefeito[Posicoes.Barcode.getValor()]);
			partsArticleNo = UtilsString.removeApas(linhaSplitadaDefeito[Posicoes.Barcode.getValor()]);
//			faultCode = UtilsString.removeApas(linhaSplitadaDefeito[Posicoes.FaultCode.getValor()]); Alessandre sem uso
			revisedFaultId = UtilsString.removeApas(linhaSplitadaDefeito[Posicoes.EndTime.getValor()]);

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
	
	
	private List<DefeitoDTO> criaDefeitosDefault(Date dataHoraFimTeste) {
		List<DefeitoDTO> defeitos = new ArrayList<DefeitoDTO>();
		DefeitoDTO defeito = new DefeitoDTO();
		defeito.setCdDefeito("DEF");
		defeito.setDthrDefeito(dataHoraFimTeste);
		defeito.setCb("PCB"); // codigo do componente
		defeito.setPosicoes("PCB"); // Posicao Mecanica
		defeitos.add(defeito);
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

			/* No trecho abaixo existe um filtro para identificar que a API da KYZA enviou um CB em branco
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
			
			String cbDuplicado = null;
			
			cbDuplicado = verificaCBDuplicados(cdUp, cbPai, cbFilhos);
			
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
			
			pasSemAlimentacao=null;
			/* NA NAOAPLICAVEL
			//202208NA NA-PARA-AOI
			// Verifica se falta alimentar alguma materia-prima
			try {
				//202208NA NA-PARA-AOI pasSemAlimentacao = IdwFacade.getInstancia().obtemPaSemAlimentacao(cdUp);
			} catch (SemFeedersException e) {
				isRetorno = false;
				msgEmail.append(cdUp + " - Ocorreu a excessao: " + e.getMessage() + "\n\r");
			} catch (PostoSemDadoException e) {
				isRetorno = false;
				msgEmail.append(e.getComplemento());
			}
			*/
			
			
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
			trataCBAnomalo(cdOp, cdUp, "ArquivoAoiKYZA.class", cdParada, dsParada);

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

		APIClientKYZA clienteAPI = null;
		if (icup.getUrlAuxiliar() != null && icup.getUrlAuxiliar().trim().equals("") == false) {
			//TODO: POR ENQUANTO NAO FAZ NADA POIS NAO APLICAVEL CONSULTA ADICIONAL PARA LISTA CB clienteAPI = new APIClientKYZA(this.log, icup.getUrlAuxiliar());
		}
		

		
		List<String> cbLidos = null;
		String[] listaSplitadaCB = null;

		//LISTACB-COM-CLIENTE-API...
		//Prepara Lista de Barcodes 
		if (clienteAPI != null) {
			//202208 cbLidos = clienteAPI.getBarcodesFromBlanck(cbLido, machName, botOrTop)

		}
		//LISTACB-COM-CLIENTE-API.
		

		//LISTACB-sem-API...
		//Prepara Lista de Barcodes  - FORÇAR quando há algo em <cbLido>
		///if (clienteAPI == null && (cbLidos==null  && cbLido != null)) {
		if ((cbLidos==null  && cbLido != null && !cbLido.trim().equals(""))) {
			if (cbLido != null && !cbLido.trim().equals("")) {
				cbLidos = new ArrayList<>();
				listaSplitadaCB = UtilsString.safeSplit(cbLido, ":");
				for(String o : listaSplitadaCB) {
					cbLidos.add(o.trim());}
				
				if (listaSplitadaCB.length>1) {
					// neste caso o BC da Placa Principal é gerado pois não vem no Log quando Itens do Blanck é informado.
					try {
						cbLido = "NS" + cdUp + DataHoraRN.dateToString(dataHoraFimTeste, "yyyyMMddHHmmss");
						this.cbPlaca = cbLido;
					} catch (Exception e) {}
				}
			}
		}
		//LISTACB-sem-API.		

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
				if (cbLido == null || cbLido.trim().equals("")) {

					//202208 cbLido = "NS" + cdUp + DataHoraRN.dateToStringDDMMYYYYHHMMSS(dataHoraFimTeste);	
					try {
						cbLido = "NS" + cdUp + DataHoraRN.dateToString(dataHoraFimTeste, "yyyyMMddHHmmss");
						
					} catch (Exception e) {}

				}
				cbLidos.add(cbLido);
				
			} else {
				
				isCBValido = false;
				/*
				isCBValido = false;
				StringBuilder msgEmail = new StringBuilder();
				msgEmail.append("O arquivo de log em anexo não apresenta nenhum código de barras ");
				msgEmail.append("\n\rEsperado ");
				msgEmail.append(String.valueOf(nTotalEsperado));
				msgEmail.append(" CBs, mas nenhum foi lido");
				// Manda email avisa q a qtde esperado <> da real
				enviarEmail(cbLido, cdOp, cdUp, icup, msgEmail, nomeArquivo, arquivo);
				*/
				
			}

		}
		
		if (isCBValido) {
			
			int qtdePorCiclo = 1; //SEMPRE 1 pois foi requisitado contar cada um dos CB lidos internamente da PCBBlanck
			/*
			if (cbLidos != null) {
				qtdePorCiclo = cbLidos.size();	
			}*/


			// Caso
			Date dthrEvento = DataHoraRN.getDataHoraAtual();
			for (String cbDaPlaca : cbLidos) {
				if (cbDaPlaca == null || (cbDaPlaca != null && cbDaPlaca.trim().equals("")))
					continue;
				
				EventoColetado ev = new EventoColetado();
				ev.setCb(cbDaPlaca);
				ev.setCdop(cdOp);
				ev.setUp(cdUp);
				ev.setIcUpDTO(icUpDTO);
				ev.setQtde("1"); //(String.valueOf(qtdePorCiclo))
				ev.setQtdeciclos("1");
				ev.setIsCbConforme(true);
				ev.setDthrEvento(dthrEvento);
				ev.setLog(log);
				ev.setTipoEvento(ServicoFactory._PASSAGEM); // Passagem
				ev.setOrigem(nomeArquivo);
				retorno.add(ev);

				dthrEvento = DataHoraRN.adicionaMilisegundosNaData(dthrEvento, 50);
			}
		}
		return retorno;

	}
	
	// Cria o eventoColetado tratando os CBs anomalos
	private List<EventoColetado> criaEventoColetadoTesteDefeito(
			String cdUp, 
			String cdOp, 
			Date dataHoraFimTeste, 
			String qtde, 
			String cbLido,
			String machName, 
			String botOrTop, 
			IcUpDTO icup, 
			String nomeArquivo, 
			String arquivo,
			List<DefeitoDTO> defeitosLista
			) {

		List<EventoColetado> retorno = new ArrayList<>();

		APIClientKYZA clienteAPI = null;
		if (icup.getUrlAuxiliar() != null && icup.getUrlAuxiliar().trim().equals("") == false) {
			//TODO: POR ENQUANTO NAO FAZ NADA POIS NAO APLICAVEL CONSULTA ADICIONAL PARA LISTA CB clienteAPI = new APIClientKYZA(this.log, icup.getUrlAuxiliar());
		}
		
		

		
		List<String> cbLidos = null;
		String[] listaSplitadaCB = null;

		//LISTACB-COM-CLIENTE-API...
		//Prepara Lista de Barcodes 
		if (clienteAPI != null) {
			//202208 cbLidos = clienteAPI.getBarcodesFromBlanck(cbLido, machName, botOrTop)
		}
		//LISTACB-COM-CLIENTE-API.
		

		//LISTACB-sem-API...
		//Prepara Lista de Barcodes  - FORÇAR quando há algo em <cbLido>
		///if (clienteAPI == null && (cbLidos==null  && cbLido != null)) {
		if ((cbLidos==null  && cbLido != null && !cbLido.trim().equals(""))) {
			if (cbLido != null && !cbLido.trim().equals("")) {
				cbLidos = new ArrayList<>();
				listaSplitadaCB = UtilsString.safeSplit(cbLido, ":");
				for(String o : listaSplitadaCB) {
					cbLidos.add(o.trim());}
				
				if (listaSplitadaCB.length>1) {
					// neste caso o BC da Placa Principal é gerado pois não vem no Log quando Itens do Blanck é informado.
					try {
						cbLido = "NS" + cdUp + DataHoraRN.dateToString(dataHoraFimTeste, "yyyyMMddHHmmss");
						this.cbPlaca = cbLido;
					} catch (Exception e) {}
				}
			}
		}
		//LISTACB-sem-API.		



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
				if (cbLido == null || cbLido.trim().equals("")) {

					//202208 cbLido = "NS" + cdUp + DataHoraRN.dateToStringDDMMYYYYHHMMSS(dataHoraFimTeste);	
					try {
						cbLido = "NS" + cdUp + DataHoraRN.dateToString(dataHoraFimTeste, "yyyyMMddHHmmss");
					} catch (Exception e) {}

				}
				cbLidos.add(cbLido);
			} else {
				
				isCBValido = false;
				/*
				isCBValido = false;
				StringBuilder msgEmail = new StringBuilder();
				msgEmail.append("O arquivo de log em anexo não apresenta nenhum código de barras ");
				msgEmail.append("\n\rEsperado ");
				msgEmail.append(String.valueOf(nTotalEsperado));
				msgEmail.append(" CBs, mas nenhum foi lido");
				// Manda email avisa q a qtde esperado <> da real
				enviarEmail(cbLido, cdOp, cdUp, icup, msgEmail, nomeArquivo, arquivo);
				*/
				
			}

		}
		
		if (isCBValido) {

			int qtdePorCiclo = 1; //SEMPRE 1 pois foi requisitado contar cada um dos CB lidos internamente da PCBBlanck
			/*
			if (cbLidos != null) {
				qtdePorCiclo = cbLidos.size();	
			}*/


			
			// Caso
			Date dthrEvento = DataHoraRN.getDataHoraAtual();
			for (String cbDaPlaca : cbLidos) {
				if (cbDaPlaca == null || (cbDaPlaca != null && cbDaPlaca.trim().equals("")))
					continue;
				
				EventoColetado ev = new EventoColetado();
				ev.setCb(cbDaPlaca);
				ev.setCdop(cdOp);
				ev.setUp(cdUp);
				ev.setIcUpDTO(icUpDTO);
				ev.setQtde("1");
				ev.setQtdeciclos("1");
				ev.setIsCbConforme(false);//false = deu DEFEITO
				ev.setDthrEvento(dthrEvento);
				ev.setLog(log);
				ev.setTipoEvento(ServicoFactory._PASSAGEM); // Passagem
				ev.setOrigem(nomeArquivo);
				ev.setEventoApenasInformativo(false);
				
				if (defeitosLista.size() > 0)
					ev.setDefeitos(defeitosLista);		
				
				retorno.add(ev);

				dthrEvento = DataHoraRN.adicionaMilisegundosNaData(dthrEvento, 10);
			}
		}
		
		
		
		return retorno;

	}	
	
	
	private EventoColetado criaEventoColetadoTesteDefeitoV1
	(
			String cdUp, String cdOp, String string, Date dataHoraFimTeste, 
			String qtde, String cb,
			List<DefeitoDTO> defeitosLista
			) {
		EventoColetado ev = new EventoColetado();		
		ev.setCb(cb);
		// A op nao esta sendo passada pq sera deixado para o sistema determinar
	    // qual op esta carregada
		// 2018-08-24: Op esta sendo considerada novamente
		ev.setCdop(cdOp);
		ev.setUp(cdUp);
		ev.setIcUpDTO(icUpDTO);
		ev.setQtde(qtde);
		ev.setIsCbConforme(false);
		ev.setDthrEvento(dataHoraFimTeste);
		ev.setLog(log);
		ev.setTipoEvento(ServicoFactory._PASSAGEM); // // Passagem
		ev.setOrigem(nomeArquivo);
		ev.setEventoApenasInformativo(false);

		if (defeitosLista.size() > 0)
			ev.setDefeitos(defeitosLista);		
		
		return ev;
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
			boolean isAoMenosUmComStNserieIgual1 = false;
			String cbdwpassagemretorno = null;
			Byte b1 = new Byte((byte)1);
			for (DwPassagem dwpassagem : passagens) {
				
				//20220826IF no entanto, tratamento especial para ignorar os NG (stnserie=0)
				
				//20220826IF
				if (dwpassagem.getStNserie()!=null && dwpassagem.getStNserie().equals(b1) )
				{
					isAoMenosUmComStNserieIgual1 = true;
					cbdwpassagemretorno = dwpassagem.getDwNserie().getCb(); //20220826IF 
					break;
				}
				
				//20220826IF retorno = dwpassagem.getDwNserie().getCb();
			}
			if (isAoMenosUmComStNserieIgual1) {//20220826IF
				retorno = cbdwpassagemretorno;
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
