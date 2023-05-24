package ms.coleta.ic.flex.spicyber;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.webservices.dto.DefeitoDTO;
import ms.coleta.ic.fuji.ICFuji;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsString;

public class LinhaArquivoSpiCyber {
	private IdwLogger log;
	private String nomeArquivo;
	private List<String> linhas;
	private String op;
	private String[] linhaSplitada;
	private IcUpDTO icUpDTO;
		
	// Campos do log
	
	private String dateTime = null;
	private String inspectionTime = null;
	private Map<String,String> resultadoSpi = new HashMap<String,String>();
	private String linhaResumida = null;
	// Posições dos campos de resultados do defeitos
	private enum posicoes {
		PosicaoMecanica(5), HeightResult(7), AreaResult(12), VolumeResult(17), Valid(22), RegResult(23), BridgeResult(30);
		
		private final int valor;
		posicoes(int valorOpcao){
	        valor = valorOpcao;
	    }
	    public int getValor(){
	        return valor;
	    }
	}
	// Dados
	private Date dateDateTime = null;

	public LinhaArquivoSpiCyber(IdwLogger log, IcUpDTO icUpDTO, List<String> linhas, String nomeArquivo) {
		this.log = log;
		this.icUpDTO = icUpDTO;
		this.linhas = linhas;
		this.nomeArquivo = nomeArquivo;
				
	}

	protected EventoColetado processarLinhas() {
		EventoColetado retorno = null;
		boolean isPlacaOk = true;
		boolean isDados = false;
		
		for(String linha: linhas){
			if (linha.contains("Board") && linha.contains("Date") ){
				isDados = true;
			}
			
			if(isDados){
				if(linha.length() > 20 && linha.contains("SRFFPANELFID")){
					this.linhaSplitada = linha.split(",");
					dateTime = linhaSplitada[1] + " " + linhaSplitada[2];
					dateDateTime = LinhaArquivoSpiCyber.convertToDateLogSpiCyber(dateTime);
				}
				
				if(linha.length() > 20 && !linha.contains("SRFFPANELFID") && !linha.contains("Board")){
					this.linhaSplitada = linha.split(",");
					isPlacaOk = false;
					if(linhaSplitada[posicoes.HeightResult.getValor()].equals("F")){
						resultadoSpi.put(linhaSplitada[posicoes.PosicaoMecanica.getValor()], "Height Fail");
					}
					
					if(linhaSplitada[posicoes.AreaResult.getValor()].equals("F")){
						resultadoSpi.put(linhaSplitada[posicoes.PosicaoMecanica.getValor()], "Area Fail");
					}
					
					if(linhaSplitada[posicoes.VolumeResult.getValor()].equals("F")){
						resultadoSpi.put(linhaSplitada[posicoes.PosicaoMecanica.getValor()], "Volume Fail");
					}
					
					if(linhaSplitada[posicoes.RegResult.getValor()].equals("F")){
						resultadoSpi.put(linhaSplitada[posicoes.PosicaoMecanica.getValor()], "Reg Fail");
					}
					
					if(linhaSplitada[posicoes.BridgeResult.getValor()].equals("F")){
						resultadoSpi.put(linhaSplitada[posicoes.PosicaoMecanica.getValor()], "Bridge Fail");
					}
					
				}
			}
			
		}	
		String[] nomeAux;
		nomeAux = linhas.get(0).split("\\\\");
		
		op = nomeAux[nomeAux.length-1].replace(".srf", "");
		//linhaResumida = dateTime; 
		String cdUp = icUpDTO.getUpDTO().getCd_up();
			
		if (dateDateTime == null) {
			log.info("Erro oa realizar parse da data, processamento do arquivo sendo descartado: " + nomeArquivo);
			return retorno;
		}
		
		if(isPlacaOk){
			retorno = criaEventoColetadoTesteSimples(cdUp, "op", "", dateDateTime, "1");
						
		}else retorno = criaEventoColetadoTesteDefeito(cdUp, "op", "", dateDateTime, "1");
		
		isDados = false;
		isPlacaOk = true;
		return retorno;
	}
	
	private EventoColetado criaEventoColetadoTesteSimples(String cdUp, String cdOp, String string, Date dataHoraFimTeste, String qtde) {
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
	
	private EventoColetado criaEventoColetadoTesteDefeito(String cdUp, String cdOp, String string, Date dataHoraFimTeste, String qtde) {
		EventoColetado ev = new EventoColetado();		
		ev.setCb("NS-"+icUpDTO.getUpDTO().getCd_up() +"-" + (new Date()).getTime());
		
		ev.setCdop(op);
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
		
		for (Map.Entry<String, String> entry : resultadoSpi.entrySet()) {
									
			DefeitoDTO defeito = new DefeitoDTO();
			defeito.setCdDefeito(entry.getValue());
			defeito.setDthrDefeito(dataHoraFimTeste);
			//defeito.setCb(mwasPosicaoMec_CdComp.get(entry.getKey())); // codigo do componente
			defeito.setPosicoes(entry.getKey()); // Posicao Mecanica
			defeitos.add(defeito);
			
		}
		
		if (defeitos.size() > 0)
			ev.setDefeitos(defeitos);		
		
		return ev;
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
			if (linhas != null) {
				EventoColetado eventoObtido = processarLinhas();
				
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
	
	public static Date convertToDateLogSpiCyber(String origem) {
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
}
