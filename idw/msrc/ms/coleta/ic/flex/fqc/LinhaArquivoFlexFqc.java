package ms.coleta.ic.flex.fqc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.webservices.dto.DefeitoDTO;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class LinhaArquivoFlexFqc {
	private IdwLogger log;
	private String nomeArquivo;
	private String linha;
	private String[] linhaSplitada;
	private IcUpDTO icUpDTO;
	
	
	// Campos do log
	
	private String dateTime = null;
	private String linhaResumida = null;
	private String result = null;
	private String mac = null;
	
	// Dados
	private Date dateDateTime = null;

	public LinhaArquivoFlexFqc(IdwLogger log, IcUpDTO icUpDTO, String linha, String nomeArquivo) {
		super();
		
		this.log = log;
		this.icUpDTO = icUpDTO;
		this.linha = linha;
		this.nomeArquivo = nomeArquivo;
		
	}

	protected EventoColetado processarLinha() {
		EventoColetado retorno = null;
				
		this.linhaSplitada = linha.split("\t");
		
		mac = linhaSplitada[1];
		dateTime = linhaSplitada[4].replace("DATA: ","" ) + " " + linhaSplitada[5];
		result = linhaSplitada[8];
		
		String FORMATO_DATA_HORA;
		
		if (dateTime.contains("AM") || dateTime.contains("PM")) {
			FORMATO_DATA_HORA = "dd/MM/yyyy hh:mm:ss a";
		} else {
			FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";
		}
		try {
			dateDateTime = new SimpleDateFormat(FORMATO_DATA_HORA).parse(dateTime.trim());
		} catch (ParseException e) {
			dateDateTime = DataHoraRN.stringToDate(dateTime.trim(), "dd/MM/yyyy HH:mm:ss");
		}
		
		linhaResumida = mac + " " + dateTime + " " + result ; 
		String cdUp = icUpDTO.getUpDTO().getCd_up();
		
		if (dateDateTime == null) {
			log.info("Erro oa realizar parse da data, processamento do arquivo sendo descartado: " + nomeArquivo);
			return retorno;
		}
		
		if(result.equals("PASS")){
			retorno = criaEventoColetadoTesteSimples(cdUp, "op", "", dateDateTime, "1");
		}else 
			retorno = criaEventoColetadoTesteDefeito(cdUp, "op", "", dateDateTime, "1", result);
		
		
				
		return retorno;
	}
	
	private EventoColetado criaEventoColetadoTesteSimples(String cdUp, String cdOp, String string, Date dataHoraFimTeste, String qtde) {
		EventoColetado ev = new EventoColetado();
		
		ev.setCb(mac);
		
		ev.setCdop("op");
		ev.setUp(cdUp);
		ev.setIcUpDTO(icUpDTO);
		ev.setQtde(qtde);
		ev.setIsCbConforme(true);
		ev.setDthrEvento(dataHoraFimTeste);
		ev.setLog(log);
		ev.setTipoEvento(ServicoFactory._PASSAGEM); // Passagem
		ev.setOrigem(nomeArquivo + " " + linhaResumida);
		
		return ev;
	}
	
	private EventoColetado criaEventoColetadoTesteDefeito(String cdUp, String cdOp, String string, Date dataHoraFimTeste, String qtde, String codigoDefeito) {
		EventoColetado ev = new EventoColetado();		
		ev.setCb(mac);
		
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
		DefeitoDTO defeito = new DefeitoDTO();
		defeito.setCdDefeito(codigoDefeito);
		defeito.setDthrDefeito(dataHoraFimTeste);
		defeito.setCb(mac); // codigo do barras
		//defeito.setPosicoes(entry.getKey()); // Posicao Mecanica
		defeitos.add(defeito);
			
		
		if (defeitos.size() > 0)
			ev.setDefeitos(defeitos);		
		
		return ev;
	}

	public String getLinha() {
		return linha;
	}

	public boolean isLinhaNoPadraoEsperado() {
		if ((dateTime !=null) && (!dateTime.equals("")) && (dateDateTime != null)) {
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
			log.info("LinhaArquivoFlexFqc: Excessao em obtemEvento da maquina: " + getIcUpDTO().getUpDTO().getCd_up() + " - " + e);
		}
		return retorno;
	}
	
	private IcUpDTO getIcUpDTO() {
		return icUpDTO;
	}

}
