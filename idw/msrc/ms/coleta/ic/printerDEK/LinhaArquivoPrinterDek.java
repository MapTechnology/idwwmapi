package ms.coleta.ic.printerDEK;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.webservices.dto.DefeitoDTO;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsString;

public class LinhaArquivoPrinterDek {
	private IdwLogger log;
	private String linha;
	private String[] linhaSplitada;
	private IcUpDTO icUpDTO;
	
	
	// Campos do log
	
	private String dateTime = null;
	private String linhaResumida = null;
	
	// Dados
	private Date dateDateTime = null;

	public LinhaArquivoPrinterDek(IdwLogger log, IcUpDTO icUpDTO, String linha) {
		this.log = log;
		this.icUpDTO = icUpDTO;
		this.linha = linha;
				
	}

	protected EventoColetado processarLinha() {
		EventoColetado retorno;
		retorno = null;
		
		this.linhaSplitada = linha.split(" ");
		
		dateTime = linhaSplitada[0] + " " + linhaSplitada[1];
				
		dateDateTime = UtilsString.convertToDateLogPrinterDek(dateTime);
		linhaResumida = linha; 
		String cdUp = icUpDTO.getUpDTO().getCd_up();
		
		switch (linhaSplitada[2]){
			
		case "31277": 
			retorno = criaEventoColetadoTesteSimples(cdUp, "op", "", dateDateTime, "1");
			break;
		
		case "31226": //Downline Transfer Error
			retorno = criaEventoColetadoTesteDefeito(cdUp,"op","",dateDateTime,"1",linhaSplitada[2]);
			break;
			
		case "31308": //Camera Y failed to position
			retorno = criaEventoColetadoTesteDefeito(cdUp,"op","",dateDateTime,"1",linhaSplitada[2]);
			break;
		case "31222": //Unable to recover
			retorno = criaEventoColetadoTesteDefeito(cdUp,"op","",dateDateTime,"1",linhaSplitada[2]);
			break;
		
		}
		
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
		ev.setOrigem(linhaResumida);
		
		return ev;
	}
	
	private EventoColetado criaEventoColetadoTesteDefeito(String cdUp, String cdOp, String string, Date dataHoraFimTeste, String qtde, String codigoDefeito) {
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
		ev.setOrigem(linhaResumida);

		List<DefeitoDTO> defeitos = new ArrayList<DefeitoDTO>();
		// Validacao
		DefeitoDTO defeito = new DefeitoDTO();
		defeito.setCdDefeito(codigoDefeito);
		defeito.setDthrDefeito(dataHoraFimTeste);
		//defeito.setCb(mwasPosicaoMec_CdComp.get(entry.getKey())); // codigo do componente
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
