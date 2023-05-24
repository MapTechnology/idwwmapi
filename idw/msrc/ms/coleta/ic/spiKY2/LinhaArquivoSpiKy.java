package ms.coleta.ic.spiKY2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.webservices.dto.DefeitoDTO;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;


public class LinhaArquivoSpiKy {
	private IdwLogger log;
	private String nomeArquivo;
	private String linha;
	private String[] linhaSplitada;
	private IcUpDTO icUpDTO;
		
	// Campos do log
	
	private String dateTime = null;
	private String inspectionTime = null;
	private Map<String,Integer> resultadoSpi = new HashMap<String,Integer>();
	@SuppressWarnings("unused")
	private String linhaResumida = null;
	
	// Dados
	private Date dateDateTime = null;

	public LinhaArquivoSpiKy(IdwLogger log, IcUpDTO icUpDTO, String linha,String nomeArquivo) {
		this.log = log;
		this.icUpDTO = icUpDTO;
		this.linha = linha;
		this.nomeArquivo = nomeArquivo.replace(".txt","");
	}

	protected EventoColetado processarLinha() {
		EventoColetado retorno;
		
		this.linhaSplitada = linha.split(",");
		
		inspectionTime = linhaSplitada[0];
		resultadoSpi.put("Warning", safeParseToInt(linhaSplitada[1]));
		resultadoSpi.put("Error", safeParseToInt(linhaSplitada[2]));
		resultadoSpi.put("Excessive-Warning", safeParseToInt(linhaSplitada[3]));
		resultadoSpi.put("Excessive-Error", safeParseToInt(linhaSplitada[4]));
		resultadoSpi.put("Insufficient-Warning", safeParseToInt(linhaSplitada[5]));
		resultadoSpi.put("Insufficient-Error", safeParseToInt(linhaSplitada[6]));
		resultadoSpi.put("Position-Warning", safeParseToInt(linhaSplitada[7]));
		resultadoSpi.put("Position-Error", safeParseToInt(linhaSplitada[8]));
		resultadoSpi.put("Bridge", safeParseToInt(linhaSplitada[9]));
		resultadoSpi.put("GoldTab",safeParseToInt(linhaSplitada[10]));
		resultadoSpi.put("Shape", safeParseToInt(linhaSplitada[11]));
		resultadoSpi.put("Coplanarity-Warning", safeParseToInt(linhaSplitada[12]));
		resultadoSpi.put("Coplanarity-Error", safeParseToInt(linhaSplitada[13]));
		resultadoSpi.put("Area-Warning", safeParseToInt(linhaSplitada[14]));
		resultadoSpi.put("Area-Error", safeParseToInt(linhaSplitada[15]));
		resultadoSpi.put("Smear-Warning", safeParseToInt(linhaSplitada[16]));
		resultadoSpi.put("Smear-Error", safeParseToInt(linhaSplitada[17]));
		
		
		dateTime = nomeArquivo + ' ' + inspectionTime;
		dateDateTime = LinhaArquivoSpiKy.convertToDateLogSpiKy(dateTime);
		linhaResumida = dateTime; 
		String cdUp = icUpDTO.getUpDTO().getCd_up();
		
		int erros = resultadoSpi.get("Error");
		if(erros > 0){
			retorno = criaEventoColetadoTesteDefeito(cdUp, "op", "", dateDateTime, "1");
			
			
		}else retorno = criaEventoColetadoTesteSimples(cdUp, "op", "", dateDateTime, "1");
		
		return retorno;
	}
	
	private EventoColetado criaEventoColetadoTesteSimples(String cdUp, String cdOp, String string, Date dataHoraFimTeste, String qtde) {
		EventoColetado ev = new EventoColetado();
		
		ev.setCb("NS-"+icUpDTO.getUpDTO().getCd_up() +"-" + (new Date()).getTime());
		
		ev.setCdop("op");
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
		if (resultadoSpi.size() == 0) 
			return null;
		
		for (Map.Entry<String, Integer> entry : resultadoSpi.entrySet()) {
			
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
		if ((inspectionTime != null) && (!inspectionTime.equals(""))
				&& (dateTime !=null) && (!dateTime.equals(""))
				&& (dateDateTime != null)) {
			return true;
		}
		return false;
	}

	public List<EventoColetado> obtemEvento() {
		
		List<EventoColetado> retorno = new ArrayList<>();
		
		try {
			if (linha != null) {
				EventoColetado eventoObtido = processarLinha();
				
				/* Se o evento for muito antigo entao não deve ser incluido na lista de retorno */
				Date dthrReferencia = DataHoraRN.getDataHoraAtual();
				dthrReferencia = DataHoraRN.subtraiDiasDaData(dthrReferencia, 1);
														
				if (eventoObtido != null && DataHoraRN.after(eventoObtido.getDthrEvento(), dthrReferencia))
					retorno.add(eventoObtido);
			}
		} catch (Exception e) {
			log.info("LinhaArquivoSpiky: Excessao em obtemEvento da maquina: "
					+ getIcUpDTO().getUpDTO().getCd_up() + " - " + e);
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
	
	public static Date convertToDateLogSpiKy(String origem) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;
		
		SimpleDateFormat formato = new SimpleDateFormat("yyMMdd HH:mm:ss");
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
}
