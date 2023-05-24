package ms.coleta.ic.flex.ate;

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

public class LinhaArquivoIctsAte {
	private IdwLogger log;
	private String nomeArquivo;
	private List<String> linha = new ArrayList<String>();
	private String[] primeiraLinhaSplitada;
	private String[] segundaLinhaSplitada;
	private IcUpDTO icUpDTO;
	
	
	// Campos do log
	
	private String dateTime = null;
	private String linhaResumida = null;
	private String result = null;
	private String dut = null;	
	// Dados
	private Date dateDateTime = null;

	public LinhaArquivoIctsAte(IdwLogger log, IcUpDTO icUpDTO, List<String> linha,String nomeArquivo) {
		this.log = log;
		this.icUpDTO = icUpDTO;
		this.linha = linha;
		this.nomeArquivo = nomeArquivo;
		
	}

	protected EventoColetado processarLinha() {
		EventoColetado retorno = null;
				
		this.primeiraLinhaSplitada = linha.get(0).split(";");
		this.segundaLinhaSplitada = linha.get(1).split(" ");
		
		dateTime = primeiraLinhaSplitada[1].replace(" Data: ","" ) + " " + primeiraLinhaSplitada[2].replace(" Hora:", "");
		result = segundaLinhaSplitada[3];
		dut = segundaLinhaSplitada[1];
		
		
		dateDateTime = UtilsString.convertToDateLogIcts(dateTime);
		linhaResumida = dateTime + " " + dut + " " + result; 
		String cdUp = icUpDTO.getUpDTO().getCd_up();
		
		if (dateDateTime == null) {
			log.info("Erro oa realizar parse da data, processamento do arquivo sendo descartado: " + nomeArquivo);
			return retorno;
		}
		
		if(result.equals("PASS")){
			retorno = criaEventoColetadoTesteSimples(cdUp, "op", "", dateDateTime, "1");
		}else 
			retorno = criaEventoColetadoTesteDefeito(cdUp, "op", "", dateDateTime, "1");
		
		
				
		return retorno;
	}
	
	private EventoColetado criaEventoColetadoTesteSimples(String cdUp, String cdOp, String string, Date dataHoraFimTeste, String qtde) {
		EventoColetado ev = new EventoColetado();
		
		ev.setCb(dut);
		
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
	
	private EventoColetado criaEventoColetadoTesteDefeito(String cdUp, String cdOp, String string, Date dataHoraFimTeste, String qtde) {
		EventoColetado ev = new EventoColetado();		
		ev.setCb(dut);
		
		ev.setCdop("op");
		ev.setUp(cdUp);
		ev.setIcUpDTO(icUpDTO);
		ev.setQtde(qtde);
		ev.setIsCbConforme(false);
		ev.setDthrEvento(dataHoraFimTeste);
		ev.setLog(log);
		ev.setTipoEvento(ServicoFactory._PASSAGEM); // // Passagem
		ev.setOrigem(nomeArquivo + " " + linhaResumida);

		List<DefeitoDTO> defeitos = new ArrayList<DefeitoDTO>();
		// Validacao
		DefeitoDTO defeito = new DefeitoDTO();
		defeito.setCdDefeito("FAIL");
		defeito.setDthrDefeito(dataHoraFimTeste);
		defeito.setCb(dut); // codigo do barras
		//defeito.setPosicoes(entry.getKey()); // Posicao Mecanica
		defeitos.add(defeito);
			
		
		if (defeitos.size() > 0)
			ev.setDefeitos(defeitos);		
		
		return ev;
	}

	public List<String> getLinha() {
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
			log.info("LinhaArquivoIctsAte: Excessao em obtemEvento da maquina: "
					+ getIcUpDTO().getUpDTO().getCd_up() + " - " + e);
		}
		return retorno;
	}
	
	private IcUpDTO getIcUpDTO() {
		return icUpDTO;
	}

}


