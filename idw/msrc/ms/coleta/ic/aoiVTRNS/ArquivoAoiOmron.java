package ms.coleta.ic.aoiVTRNS;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.util.IdwLogger;
import idw.webservices.dto.DefeitoDTO;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsString;

public class ArquivoAoiOmron {
	protected IdwLogger log;
	// nomeArquivoDestino
	protected String nomeArquivo;
	// pathDestino
	private String pathArquivo;
	protected IcUpDTO icUpDTO;
	
	protected List<String> linhas = new ArrayList<>();
	
	protected String programName = "";
	
	private String createDate = "";
	private String reviseEndDate = "";
	private String componentNo = "";
	private String partsName = "";
	private String partsArticleNo = "";
	private String faultCode = "";
	private String revisedFaultId = "";
	
	private boolean placaOk = true;
	
	
	private enum Posicoes {
		ProgramNamePos(7), CreateDate(18), ReviseEndDate(22), TestResult(23), ReviseResult(24), ComponentNo(41), PartsName(42), 
		PartsArticleNo(46), FaultCode(49), RevisedFaultId(50);
		
		private final int valor;
		Posicoes(int valorOpcao){
	        valor = valorOpcao;
	    }
	    public int getValor(){
	        return valor;
	    }
	}
	
	//Fabricio (04/09/2018) alterei o mapa de defeitos
	private Map<String,String> listaCdComp_PosicaoMec = new HashMap<String,String>();
	private Map<String,String> listaCdComp_CdDefeito = new HashMap<String,String>();
	private List <String> listaComponente = new ArrayList<String>();
	private List <String> listaDefeito = new ArrayList<String>();;

	public ArquivoAoiOmron(IdwLogger log, String nomeArquivoDestino, String pathDestino) {
		this.log = log;
		this.nomeArquivo = nomeArquivoDestino;
		this.pathArquivo = pathDestino;
	}

	

	public List<EventoColetado> obtemEvento(ICAoiVTRNS ic) {
		List<EventoColetado> retorno  = new ArrayList<>();
		try {
			if (linhas != null) {
				EventoColetado eventoObtido = processarLog();
				if (eventoObtido != null)
					retorno.add(eventoObtido);
			}
		} catch (Exception e) {
			log.error("ArquivoAoiVTRNS: Excessao em obtemEvento da maquina: "
					+ getIcUpDTO().getUpDTO().getCd_up() + " - " + e);
		}
		return retorno;
	}
	
	protected EventoColetado processarLog() {
		EventoColetado retorno = null;
		String cdUp = icUpDTO.getUpDTO().getCd_up();
		String cdOp = "op";
		Date dataHoraFimTeste = null;
		
		for (String linha : linhas) {
			String[] linhaSplitada = UtilsString.safeSplit(linha, ",");
			programName = UtilsString.removeApas(linhaSplitada[Posicoes.ProgramNamePos.getValor()]);
			createDate = UtilsString.removeApas(linhaSplitada[Posicoes.CreateDate.getValor()].replace("U", ""));
			
			// Se nao houve revisao, a data sera vazia
			reviseEndDate = UtilsString.removeApas(linhaSplitada[Posicoes.ReviseEndDate.getValor()]);
			
			componentNo	 = UtilsString.removeApas(linhaSplitada[Posicoes.ComponentNo.getValor()]);
			partsName = UtilsString.removeApas(linhaSplitada[Posicoes.PartsName.getValor()]);
			partsArticleNo = UtilsString.removeApas(linhaSplitada[Posicoes.PartsArticleNo.getValor()]);
			
			faultCode = UtilsString.removeApas(linhaSplitada[Posicoes.FaultCode.getValor()]);
			revisedFaultId = UtilsString.removeApas(linhaSplitada[Posicoes.RevisedFaultId.getValor()]);
			
			if (!componentNo.equals("") && !partsName.equals("") && !partsArticleNo.equals("") && !revisedFaultId.equals("")) {
				if (!revisedFaultId.equals("0")) {
					String posicaoMec = partsName + "_" + componentNo;
					listaCdComp_PosicaoMec.put(partsArticleNo, posicaoMec);
					listaCdComp_CdDefeito.put(partsArticleNo, revisedFaultId);
					listaComponente.add(partsArticleNo);
					listaDefeito.add(revisedFaultId);
					placaOk = false;
				} 
				
			} 
			
		}
		
		dataHoraFimTeste = UtilsString.dateTimeStringToDateOMRONVTRNS(createDate);
		cdOp = programName;
		if (dataHoraFimTeste == null) {
			log.error("Erro oa realizar parse da data, processamento do arquivo sendo descartado: " + nomeArquivo);
			return retorno;
		}
		
		if (placaOk) {
			retorno = criaEventoColetadoTesteSimples(cdUp, cdOp, "", dataHoraFimTeste, "1");
		} else {
			retorno = criaEventoColetadoTesteDefeito(cdUp, cdOp, "", dataHoraFimTeste, "1");
		}
		return retorno;
	}
	
	private EventoColetado criaEventoColetadoTesteDefeito(String cdUp, String cdOp, String string, Date dataHoraFimTeste, String qtde) {
		EventoColetado ev = new EventoColetado();		
		ev.setCb("NS-"+icUpDTO.getUpDTO().getCd_up() +"-" + (new Date()).getTime());
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

		List<DefeitoDTO> defeitos = new ArrayList<DefeitoDTO>();
		// Validacao
		if (listaCdComp_PosicaoMec.size() == 0 || listaCdComp_CdDefeito.size() == 0) 
			return null;
		
		for (int i = 0; i < listaComponente.size() ; i++) {
			DefeitoDTO defeito = new DefeitoDTO();
			defeito.setCdDefeito(listaDefeito.get(i));
			defeito.setDthrDefeito(dataHoraFimTeste);
			defeito.setCb(listaComponente.get(i)); // codigo do componente
			defeito.setPosicoes(listaCdComp_PosicaoMec.get(listaComponente.get(i))); // Posicao Mecanica
			defeitos.add(defeito);
		}
		
		if (defeitos.size() > 0)
			ev.setDefeitos(defeitos);		
		
		return ev;
	}
	
	private EventoColetado criaEventoColetadoTesteSimples(String cdUp, String cdOp, String string, Date dataHoraFimTeste, String qtde) {
		EventoColetado ev = new EventoColetado();
		
		ev.setCb("NS-"+icUpDTO.getUpDTO().getCd_up() +"-" + (new Date()).getTime());
		// A op nao esta sendo passada pq sera deixado para o sistema determinar
		// qual op esta carregada
		// 2018-08-24: Op esta sendo considerada novamente
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

	private IcUpDTO getIcUpDTO() {
		return icUpDTO;
	}

	public void setLinhas(List<String> retorno) {
		this.linhas = retorno;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getPathArquivo() {
		return pathArquivo;
	}

	public void setPathArquivo(String pathArquivo) {
		this.pathArquivo = pathArquivo;
	}

	public void setIcUpDTO(IcUpDTO icUpDTO) {
		this.icUpDTO = icUpDTO;
	}

}
