package ms.coleta.ic.flex.wc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import idw.util.IdwLogger;
import idw.webservices.dto.DefeitoDTO;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsString;

public class LinhaArquivoWcZTE {
	private IdwLogger log;
	private String nomeArquivo;
	private String linha;
	private String[] linhaSplitada;
	private IcUpDTO icUpDTO;
	
	
	// Campos do log
	
	private String dateTime = null;
	private String linhaResumida = null;
	private String result = null;
	private String numeroSerie = null;
	
	// Dados
	private Date dateDateTime = null;

	public LinhaArquivoWcZTE(IdwLogger log, IcUpDTO icUpDTO, String linha,String nomeArquivo) {
		this.log = log;
		this.icUpDTO = icUpDTO;
		this.linha = linha;
		this.nomeArquivo = nomeArquivo;
		
	}

	protected EventoColetado processarLinha() {
		EventoColetado retorno = null;
				
		this.linhaSplitada = linha.split(",");
		
		dateTime = linhaSplitada[1].replace("Date=","" ) + " " + linhaSplitada[2].replace("Time=", "");
		result = linhaSplitada[3].replace("Result=", "");
		numeroSerie =linhaSplitada[0].replace("SN=","");
		
		
		dateDateTime = UtilsString.convertToDateLogWcZTE(dateTime);
		linhaResumida = linhaSplitada[0] + linhaSplitada[1] + linhaSplitada[2] + linhaSplitada[3] + linhaSplitada[4]  ; 
		String cdUp = icUpDTO.getUpDTO().getCd_up();
		
		if (dateDateTime == null) {
			log.error("Erro oa realizar parse da data, processamento do arquivo sendo descartado: " + nomeArquivo);
			return retorno;
		}
		
		if(result.equals("PASS")){
			retorno = criaEventoColetadoTesteSimples(cdUp, "op", "", dateDateTime, "1");
		}else 
			retorno = criaEventoColetadoTesteDefeito(cdUp, "op", "", dateDateTime, "1",linhaSplitada[4].replace("ErrorCode=", ""));
		
		
				
		return retorno;
	}
	
	private EventoColetado criaEventoColetadoTesteSimples(String cdUp, String cdOp, String string, Date dataHoraFimTeste, String qtde) {
		EventoColetado ev = new EventoColetado();
		
		ev.setCb(numeroSerie);
		
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
		ev.setCb(numeroSerie);
		
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
		defeito.setCb(numeroSerie); // codigo do barras
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
		if ((dateTime !=null) && (!dateTime.equals(""))
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
				if (eventoObtido != null)
					retorno.add(eventoObtido);
			}
		} catch (Exception e) {
			log.error("LinhaArquivoWcZTE: Excessao em obtemEvento da maquina: "
					+ getIcUpDTO().getUpDTO().getCd_up() + " - " + e);
		}
		return retorno;
	}
	
	private IcUpDTO getIcUpDTO() {
		return icUpDTO;
	}

}
