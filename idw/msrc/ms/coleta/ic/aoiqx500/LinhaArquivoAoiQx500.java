package ms.coleta.ic.aoiqx500;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.webservices.dto.DefeitoDTO;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class LinhaArquivoAoiQx500 {
	private IdwLogger log;
	private String nomeArquivo;
	private String linha;
	private String[] linhaSplitada;
	//private String[] barcodesSplit;
	private Set <String> barcodes = new HashSet<>();
	private List<String> barcodesComDuplicacoes = new ArrayList<String>();
	private IcUpDTO icUpDTO;
	private String dateTime = null;
	private Map<String,Integer> resultadoAoi = new HashMap<String,Integer>();
	String op = "op";
	String cdUp = "";
	//private String linhaResumida = null;
	
	// Dados
	private Date dateDateTime = null;

	public static final String _CD_CB_AUSENTE = "1";
	public static final String _CB_AUSENTE = "CB Ausente";
	public static final String _CD_CB_DUPLICADO = "2";
	public static final String _CB_DUPLICADO = "CB Duplicado";
	
	public LinhaArquivoAoiQx500(IdwLogger log, IcUpDTO icUpDTO, String linha,String nomeArquivo) {
		this.log = log;
		this.icUpDTO = icUpDTO;
		this.linha = linha;
		this.nomeArquivo = nomeArquivo;
				
	}

	protected void processarLinha() {
		
		barcodes = new HashSet<>();
		this.linhaSplitada = linha.split(" ");
		
		String[] barcodesSplit = null;
		boolean cbVazio = false;
								
		dateTime = linhaSplitada[6].replace("EndTime=\"","") + " " + linhaSplitada[7].replace("\"", "") ;
		dateDateTime = LinhaArquivoAoiQx500.convertToDate(dateTime);
		cdUp = icUpDTO.getUpDTO().getCd_up();
		op = nomeArquivo.split("\\.")[0];
		String barcodesAux = linhaSplitada[15].replace("Barcode=", "");
		if (barcodesAux.contains("NO_BARCODE_READ_"))
			barcodesAux = barcodesAux.replaceFirst("NO_BARCODE_READ_", "");
		else
			barcodesAux = barcodesAux.replace("NO_BARCODE_READ", "");
		// remove as aspas
		barcodesAux = barcodesAux.replace("\"", "");
		
		// Se mesmo assim, ainda existe a string "NO_BARCODE_READ", trata-se de um CB ausente
		if (barcodesAux.contains("NO_BARCODE_READ"))
			barcodesAux = barcodesAux.replace("NO_BARCODE_READ", "NOBARCODEREAD");
			
		barcodesSplit = barcodesAux.split("_");
		for(String code:barcodesSplit){
			if (code.trim().equals("NOBARCODEREAD")) {
				cbVazio = true;
			} else if(code.trim().equals("") == false){
				barcodes.add(code);
				barcodesComDuplicacoes.add(code);
			} 
			else {
				cbVazio = true;
			}
		}
		
		if (cbVazio) {
			// Ailton-2019-07-30: modificacao para lancar evento de parada quando detectados CBs ausentes
			trataCBAnomalo("op", cdUp, "CB ausente, linhaSplitada: " + linhaSplitada[15], _CD_CB_AUSENTE, _CB_AUSENTE);
			log.error("CB obtido esta vazio, linhaSplitada:" + linhaSplitada[15]);
		} 	
		
		// Ailton-2019-07-30: modificacao para lancar evento de parada quando detectados CBs duplicados
		String cbDuplicado = verificaCBDuplicados(barcodesComDuplicacoes); 
		if(cbDuplicado != null) {
			trataCBAnomalo("op", cdUp, "CB repetido: " + cbDuplicado, _CD_CB_DUPLICADO, _CB_DUPLICADO);
			log.info("Como foi identificado uma duplicacao de CB, nao serao gerados os eventos de passagem. CB: " + cbDuplicado);
		}
	}
	
	private EventoColetado criaEventoColetadoTesteSimples(String cdUp, String cdOp, String cb, Date dataHoraFimTeste, String qtde) {
		EventoColetado ev = new EventoColetado();
		
		ev.setCb(cb);
		
		ev.setCdop(cdOp);
		ev.setUp(cdUp);
		ev.setIcUpDTO(icUpDTO);
		ev.setQtde(qtde);
		ev.setIsCbConforme(true);
		ev.setDthrEvento(dataHoraFimTeste);
		ev.setLog(log);
		ev.setTipoEvento(ServicoFactory._PASSAGEM); // Passagem
		ev.setOrigem(nomeArquivo);
		
		return ev;
	}
	
	private EventoColetado criaEventoColetadoTesteSimplesSemCB(String cdUp, String cdOp, Date dataHoraFimTeste, String qtde) {
		EventoColetado ev = new EventoColetado();
		
		ev.setCb("NS-"+icUpDTO.getUpDTO().getCd_up() +"-" + (new Date()).getTime());
		
		ev.setCdop(op);
		ev.setUp(cdUp);
		ev.setIcUpDTO(icUpDTO);
		ev.setQtde(qtde);
		ev.setIsCbConforme(true);
		ev.setDthrEvento(dataHoraFimTeste);
		ev.setLog(log);
		ev.setTipoEvento(ServicoFactory._PASSAGEM); // Passagem
		ev.setOrigem(nomeArquivo);
		
		return ev;
	}
	
	/* Falta analisar a captura de defeitos desse driver, entao futuramente esse metodo sera uado para isso
	 * 
	 */
	private EventoColetado criaEventoColetadoTesteDefeito(String cdUp, String cdOp, String string, Date dataHoraFimTeste, String qtde) {
		EventoColetado ev = new EventoColetado();		
		ev.setCb("NS-"+icUpDTO.getUpDTO().getCd_up() +"-" + (new Date()).getTime());
		
		ev.setCdop("op");
		ev.setUp(cdUp);
		ev.setIcUpDTO(icUpDTO);
		ev.setQtde(qtde);
		ev.setIsCbConforme(false);
		ev.setDthrEvento(dataHoraFimTeste);
		ev.setLog(log);
		ev.setTipoEvento(ServicoFactory._PASSAGEM); // // Passagem
		ev.setOrigem(nomeArquivo);

		List<DefeitoDTO> defeitos = new ArrayList<DefeitoDTO>();
		// Validacao
		if (resultadoAoi.size() == 0) 
			return null;
		
		for (Map.Entry<String, Integer> entry : resultadoAoi.entrySet()) {
			
			if (entry.getValue() > 0){
			
			DefeitoDTO defeito = new DefeitoDTO();
			defeito.setCdDefeito(entry.getKey());
			defeito.setDthrDefeito(dataHoraFimTeste);
			//defeito.setCb(mwasPosicaoMec_CdComp.get(entry.getKey())); // codigo do componente
			//defeito.setPosicoes(entry.getKey()); // Posicao Mecanica
			defeitos.add(defeito);
			}
		}
		
		if (defeitos.size() > 0)
			ev.setDefeitos(defeitos);		
		
		return ev;
	}

	public String getLinha() {
		return linha;
	}

	public boolean isLinhaNoPadraoEsperado() {
		if ((dateTime != null) && (!dateTime.equals("")) && (dateDateTime != null)) {
			return true;
		}
		return false;
	}

	public List<EventoColetado> obtemEvento() {
		List<EventoColetado> retorno = new ArrayList<>();
		
		try {
			if (linha != null) {
				processarLinha();
				int i = 0;
				Date dthrevento = DataHoraRN.getDataHoraAtual();
				
				for(String barcode: barcodes){
					i++;
					EventoColetado eventoObtido = criaEventoColetadoTesteSimples(cdUp,op,barcode, dateDateTime, String.valueOf(barcodes.size()));
					
					/* Se o evento for muito antigo entao não deve ser incluido na lista de retorno 
					Date dthrReferencia = DataHoraRN.getDataHoraAtual();
					dthrReferencia = DataHoraRN.subtraiDiasDaData(dthrReferencia, 1);
															
					if (eventoObtido != null && DataHoraRN.after(eventoObtido.getDthrEvento(), dthrReferencia)){
						
					} */
					retorno.add(eventoObtido);
					
				}
				
				if(retorno.size() == 0){
					EventoColetado eventoObtido = criaEventoColetadoTesteSimplesSemCB(cdUp,op,dateDateTime,"4");
					
					/* Se o evento for muito antigo entao não deve ser incluido na lista de retorno 
					Date dthrReferencia = DataHoraRN.getDataHoraAtual();
					dthrReferencia = DataHoraRN.subtraiDiasDaData(dthrReferencia, 1);
															
					if (eventoObtido != null && DataHoraRN.after(eventoObtido.getDthrEvento(), dthrReferencia)) */
					retorno.add(eventoObtido);
				}
				
			}
		} catch (Exception e) {
			log.info("LinhaArquivoAoiQx500: Excessao em obtemEvento da maquina: "
					+ getIcUpDTO().getUpDTO().getCd_up() + " - " + e);
		}
		if (dateDateTime == null) {
			log.info("Erro oa realizar parse da data, processamento do arquivo sendo descartado: " + nomeArquivo);
			retorno = null;
			return retorno;
		}
		return retorno;
	}
	
	private IcUpDTO getIcUpDTO() {
		return icUpDTO;
	}
	

	int safeParseToInt(String valor) {
		int retorno = 0;
		try {
			retorno = Integer.parseInt(valor);
		} catch (Exception e) {
			log.info("Falha ao realizar o parser do valor: " + valor + " da linha " + toString());
			log.info("Excecao: " + e.toString());
			retorno = 0;
		}
		return retorno;
	}
	
	double safeParseToDouble(String valor) {
		double retorno;
		try {
			retorno = Double.parseDouble(valor);
		} catch (Exception e) {
			log.info("Falha ao realizar o parser do valor: " + valor + " da linha " + toString());
			log.info("Excecao: " + e.toString());
			retorno = 0;
		}
		return retorno;
	}
	
	public static Date convertToDate(String origem) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;
		
		SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
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
	
	// Por padrao, cada CB vem repetido 2 vezes no log
	// Assim, se o CB aparecer mais de duas vezes, sera considerado duplicado
	private String verificaCBDuplicados(List<String> cbLidos) {
		int size = cbLidos.size();
		String retorno = null;
		try {
			for (int i = 0; i < size; i++) {
				//for (int j = i + 1; j < size; j++) {
				int contador = 0;
				for (int j = i; j < size; j++) {
					if (cbLidos.get(i).equals(cbLidos.get(j))){
						contador++; 
					}
					if (contador > 2) {
						retorno = cbLidos.get(i);
						return retorno;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	private boolean trataCBAnomalo(String cdOp, String cdUp, String origem, String cdParada, String dsParada) {
		// A primeira medida para o CB ausente deve ser o lancamento de uma parada que requer cancelamento
		EventoColetado ev = criaEventoParada(cdOp, cdUp, cdParada, dsParada);
		if (origem != null && !origem.equals(""))
			ev.setOrigem(nomeArquivo + " - " + origem);		
		// Como e um evento prioritario
		MensagemRecebida mensagemInicioParada = new MensagemRecebida(ev);
		mensagemInicioParada.setLog(log);
		mensagemInicioParada.setDadosIcDTO(icUpDTO.getIc());
		try {
			ServicoFactory.getInstancia().executaServico(null, mensagemInicioParada);
		} catch (ServicoFalhouException e) {
			e.printStackTrace();
			log.error("Excecao ao tratar CB anomalo: " + e);
			return false;
		}
		return true;
	}
	
	private EventoColetado criaEventoParada (String cdOp, String cdUp, String cdParada, String descricaoParada) {
		EventoColetado ev = new EventoColetado();
		ev.setCdop(cdOp);
		ev.setUp(cdUp);
		ev.setIcUpDTO(icUpDTO);
		ev.setIsCbConforme(true);
		ev.setDthrEvento(DataHoraRN.getDataHoraAtual());
		ev.setLog(log);
		ev.setTipoEvento(ServicoFactory._INICIO_PARADA); // Passagem
		ev.setOrigem(nomeArquivo + "_NS-"+icUpDTO.getUpDTO().getCd_up() +"-" + (new Date()).getTime());
		ev.setCdparada(cdParada);
		ev.setCb(descricaoParada);
		return ev;
	}
}
