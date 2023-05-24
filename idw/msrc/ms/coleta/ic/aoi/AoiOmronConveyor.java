package ms.coleta.ic.aoi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.IdwFacade;
import idw.model.excessoes.PostoSemDadoException;
import idw.model.excessoes.SemFeedersException;
import idw.model.pojos.OmMapapa;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.webservices.dto.DefeitoDTO;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class AoiOmronConveyor extends ArquivoAoiOmron{
	
	private String cdUp;
	private String botOrTop;
	private Date dateTime;
	private String machName;
	protected int isOk = 1;
	protected String cdParada="";
	protected String dsParada="";
	
	private int idLog;
	private int identacao;

	public AoiOmronConveyor(
			IdwLogger log, 
			int idLog,
			int identacao,
			String nomeArquivo,
			String nrop,
			String cdup, 
			String botOrTop,  
			List<DefeitoDTO> defeitos, 
			Date data, 
			String machName, 
			String cb, 
			IcUpDTO icUpDTO) {
		
		super();
		
		this.programName = nrop;
		this.cdUp = cdup;
		this.botOrTop = botOrTop;
		this.log = log;
		this.nomeArquivo = nomeArquivo;		
		this.defeitos = defeitos;
		if (data == null)
			this.dateTime = DataHoraRN.getDataHoraAtual();
		else
			this.dateTime = data;
		this.machName = machName;
		this.cbPlaca = cb;
		this.icUpDTO = icUpDTO;
				
		this.identacao = identacao;
		this.idLog = idLog;
	}
	
	public List<EventoColetado> obtemEvento() {
		List<EventoColetado> retorno = new ArrayList<>();
		try {
			if (linhas != null) {
				retorno = processarLog();
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info(idLog, identacao, "ArquivoAoiOmron: Excessao em obtemEvento do Conveyor: " + e);
		}
		return retorno;
	}
	
	@Override
	protected List<EventoColetado> processarLog(){
		List<EventoColetado> retorno = new ArrayList<>();
		
		retorno = criaEventoColetadoTesteSimples(cdUp, programName, dateTime, cbPlaca, machName, botOrTop, icUpDTO, nomeArquivo);
		
		log.info(idLog, identacao, "Apos criaEventoColetaTesteSimples, obtive os cbs abaixo: " + retorno.size());
		for (EventoColetado ev : retorno) {
			log.info(idLog, identacao, "cb: " + ev.getCb());
		}
						
		if (cbPlaca != null && cbPlaca.length() > 0) {
			preencheCbserialDasPlacasNaoPrincipais(retorno, cbPlaca);

			log.info(idLog, identacao, "Apos preencheCbserialDasPlacaNaoPrincipais, obtive os cbs abaixo: " + retorno.size());
			for (EventoColetado ev : retorno) {
				log.info(idLog, identacao, "cb: " + ev.getCb());
			}
		}
		
		// Luiz 20191105 Adicionei essa condicao casa aconteca erro no log independente do cb da placa
		if (defeitos != null && defeitos.size() > 0) {
			adicionaDefeitosNaPlacaPrincipal(retorno, defeitos, cbPlaca);

			log.info(idLog, identacao, "Apos adicionaDefeitosNaPlacaPrincipal, obtive os cbs abaixo: " + retorno.size());
			for (EventoColetado ev : retorno) {
				log.info(idLog, identacao, "cb: " + ev.getCb());
			}
		}
		return retorno;
		
	}
	
	private List<EventoColetado> criaEventoColetadoTesteSimples(
			String cdUp, String cdOp, Date dataHoraFimTeste, String cbLido,
			String machName, String botOrTop, IcUpDTO icup, String nomeArquivo) {
		
		List<EventoColetado> retorno = new ArrayList<>();

		APIClientOmron clienteAPI = null;
		if (icup != null && icup.getUrlAuxiliar() != null && icup.getUrlAuxiliar().trim().equals("") == false) {
			clienteAPI = new APIClientOmron(this.log, icup.getUrlAuxiliar());
		}
		List<String> cbLidos = null;
		if (clienteAPI != null && icup.getUpDTO().isLerCB()) {
			cbLidos = clienteAPI.getBarcodesFromBlanck(cbLido, machName, botOrTop);
		} else {
			// Nesse caso nao existe API para ser lida entao considerar apenas o CB recebido
			cbLidos = new ArrayList<>();
			cbLidos.add(cbLido);
		}

		boolean isCBValido = true;

		int nTotalEsperado = IdwFacade.getInstancia().getProducaoPorCiclo(cdUp);

		if (cbLidos != null && icup.getUpDTO().isLerCB()) {
			isCBValido = isCBValido(
					cbLido,
					cbLidos,
					cdOp,
					cdUp,
					icup,
					nomeArquivo,
					nTotalEsperado);

			log.info(idLog, identacao, "Foram lidos " + cbLidos.size() + " CBs da API e a validade=" + isCBValido + " para producao por ciclo = " + nTotalEsperado);

		} else {
			
			/* Existem duas situacoes. A primeira o driver esta configurado para ler codigo de barras. Nessa situacao caso o CB nao tenha sido lido, entao um email deve ser enviado
			 * A 2a situacao é quando o produto esta configurado para nao ler cb. Nesse caso um CB deve ser gerado para que os defeitos sejam lancados
			 * */
			
			if (icup.getUpDTO().isLerCB() == false) {
				log.info(idLog, identacao, "Produto " + icup.getUpDTO().getCdproduto() + " configurado para não ler CB");
				cbLidos = new ArrayList<>();
				if (cbLido == null || cbLido.trim().equals(""))
					cbLido = "NS" + cdUp + DataHoraRN.dateToStringDDMMYYYYHHMMSS(dataHoraFimTeste);
				cbLidos.add(cbLido);
				isOk = 1;
			} else {
				isCBValido = false;
				isOk = 0;
				this.dsParada = "CB API Ausente";
				StringBuilder msgEmail = new StringBuilder();
				msgEmail.append("O arquivo de log em anexo não apresenta nenhum código de barras ");
				msgEmail.append("\n\rEsperado ");
				msgEmail.append(String.valueOf(nTotalEsperado));
				msgEmail.append(" CBs, mas nenhum foi lido");
	
				// Manda email avisa q a qtde esperado <> da real
				enviarEmail(cbLido, cdOp, cdUp, icup, msgEmail, nomeArquivo, "");
			}
		}
		
		if (isCBValido) {
			// Caso
			int qtdePorCiclo = cbLidos.size();
			//Date dthrEvento = DataHoraRN.getDataHoraAtual();
			for (String cbDaPlaca : cbLidos) {
				log.info(idLog, identacao, "add CB da API [" + cbDaPlaca + "]");
				if (cbDaPlaca == null || (cbDaPlaca != null && cbDaPlaca.trim().equals("")))
					continue;
				
				EventoColetado ev = new EventoColetado();
				ev.setCb(cbDaPlaca);
				ev.setCdop(cdOp);
				ev.setUp(cdUp);
				ev.setIcUpDTO(icUpDTO);
				ev.setQtde(String.valueOf(qtdePorCiclo));
				ev.setIsCbConforme(true);
				ev.setDthrEvento(dateTime);
				ev.setLog(log);
				ev.setTipoEvento(ServicoFactory._PASSAGEM); // Passagem
				ev.setOrigem(nomeArquivo);
				retorno.add(ev);

				dateTime = DataHoraRN.adicionaMilisegundosNaData(dateTime, 10);
			}
		}
		return retorno;
	}
	private boolean isCBValido(String cbPai, List<String> cbFilhos, String cdOp, String cdUp, IcUpDTO icup, String nomeArquivo, int nTotalEsperado){
		boolean isRetorno = true;
		//String cdParada = _CD_CB_AUSENTE;
	    //String dsParada = _CB_AUSENTE;
		List<OmMapapa> pasSemAlimentacao = null;
		StringBuilder msgEmail = new StringBuilder();
						
		// Se o cbPai for nulo ou vazio então o CB eh invalido
		if (cbPai == null || (cbPai != null && cbPai.trim().equals(""))) {
			msgEmail.append("Código de barras está vazio");
			msgEmail.append("\n\r");			
			isRetorno = false;
			isOk = 0;
			dsParada = "CB pai nulo";
		}

		// Verifica se os cbs filhos estão vazios. Nunca estarão pois mesmo que a placa tenha apenas um CB esse CB se repete na lista
		if (cbFilhos == null || cbFilhos.isEmpty()) {
			msgEmail.append("Todos códigos de barras da API estão vazios para o principal ");
			msgEmail.append(cbPai);
			msgEmail.append("\n\r");
			isRetorno = false;
			isOk = 0;
			dsParada = "CBs filhos vazios";
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
			if (contadorCBsValidos == nTotalEsperado || (contadorCBsValidos > 0 && (icup == null || icup.getUrlAuxiliar() == null || icup.getUrlAuxiliar().equals("") )) ) {
				isAlgumVazio = false;
				isRetorno = true;
			} else {
				msgEmail.append("Esperado ");
				msgEmail.append(String.valueOf(nTotalEsperado));
				msgEmail.append(" CBs, mas foram lidos ");
				msgEmail.append(String.valueOf(contadorCBsValidos));
				isOk = 0;
				dsParada = "CBs nao retornados";
				isRetorno = false;
								
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
			log.info(idLog, identacao, "verificando duplicacao cdup=" + cdUp + " cdPai=" + cbPai );
			String cbDuplicado = verificaCBDuplicados(cdUp, cbPai, cbFilhos);
			if (cbDuplicado != null) {
				log.info(idLog, identacao, "CB Duplicado  "+ cbPai);
				isRetorno = false;
				isOk = 0;
				//cdParada = _CD_CB_DUPLICADO;
				dsParada = "CB Duplicado";
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
				log.info(idLog, identacao, cdUp + " - Ocorreu a excessao: " + e.getMessage());
			} catch (PostoSemDadoException e) {
				isRetorno = false;
				log.info(idLog, identacao, e.getComplemento());
			}
			if (pasSemAlimentacao != null && pasSemAlimentacao.isEmpty() == false) {
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

					dsParada = dsParada + ommapa.getOmPa().getCdPa();
					dsParada = dsParada + ";";
					isOk =0;
					isRetorno = false;
				}
				log.info(idLog, identacao, "PAs sem saldo: " + msgEmail.toString());
			}else {
				msgEmail.append("Alimentação feita corretamente. Talvez aqui verificar o BOM.\n\r");
				log.info(idLog, identacao, "Alimentacao feita corretamente.");
			}
			// Apagar as 3 linhas abaixo qdo tiver pegando os pasemalimentacao
			
		}
		if (isRetorno == false) {			

			enviarEmail(cbPai, cdOp, cdUp, icup, msgEmail, nomeArquivo, "semArq");

		}
		
		return isRetorno;
	}
	
	public String getDsParada(){
		return this.dsParada;
	}
	
	public int getStatus(){
		return this.isOk;
	}
}
