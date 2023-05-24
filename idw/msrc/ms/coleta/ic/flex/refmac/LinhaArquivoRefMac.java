package ms.coleta.ic.flex.refmac;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.webservices.dto.MontagemDTO;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;


public class LinhaArquivoRefMac {
	
	private static final int ORDEM_MONTAGEM_SERIAL_PRODUTO = 2;
	private IdwLogger log;
	private String nomeArquivo;
	private String linha;
	private String[] linhaSplitada;
	private IcUpDTO icUpDTO;
	
	
	// Campos do log
	
	private String dateTime = null;
	private String linhaResumida = null;
	private String serialNumber = null;
	private String mac = null;
	
	// Dados
	private Date dateDateTime = null;

	public LinhaArquivoRefMac(IdwLogger log, IcUpDTO icUpDTO, String linha,String nomeArquivo) {
		this.log = log;
		this.icUpDTO = icUpDTO;
		this.linha = linha;
		this.nomeArquivo = nomeArquivo;
		
	}

	/*public static void main(String[] args) {
		String dateTime = "13/12/2018 06:37:39 AM";
		Date dateDateTime;
		if (dateTime.contains("AM") || dateTime.contains("PM"))
			dateDateTime = UtilsString.convertToDateLogPrinterDek(dateTime);
		else
			dateDateTime = UtilsString.convertToDateLogPrinterDek(dateTime);
		
		System.out.println(dateDateTime);
		
	}*/
	protected EventoColetado processarLinha() {
		EventoColetado retorno = null;
				
		this.linhaSplitada = linha.split("\t");
		
		mac = linhaSplitada[0];
		serialNumber = linhaSplitada[1];
		
		dateTime = linhaSplitada[2] + " " + linhaSplitada[3];
		
		
		String FORMATO_DATA_HORA;
		
		if (dateTime.contains("AM") || dateTime.contains("PM")) {
			FORMATO_DATA_HORA = "dd/MM/yy hh:mm:ss a";
		} else {
			FORMATO_DATA_HORA = "dd/MM/yy HH:mm:ss";
		}
		try {
			dateDateTime = new SimpleDateFormat(FORMATO_DATA_HORA).parse(dateTime.trim());
		} catch (ParseException e) {
			dateDateTime = DataHoraRN.stringToDate(dateTime.trim(), "dd/MM/yy HH:mm:ss");
		}
		
		linhaResumida = mac + " " + dateTime + " "; 
		String cdUp = icUpDTO.getUpDTO().getCd_up();
		
		if (dateDateTime == null) {
			log.info("Erro oa realizar parse da data, processamento do arquivo sendo descartado: " + nomeArquivo);
			return retorno;
		}else {
			retorno = criaEventoColetado(cdUp, "op", "", dateDateTime, "1");
			
		}
		
		return retorno;
	}
	
	private EventoColetado criaEventoColetado(String cdUp, String cdOp, String string, Date dataHoraFimTeste, String qtde) {
		EventoColetado ev = new EventoColetado();
		
		ev.setCb(mac);
		ev.setCbserial(serialNumber);
		ev.setCdop("op");
		ev.setUp(cdUp);
		ev.setIcUpDTO(icUpDTO);
		ev.setQtde(qtde);
		ev.setIsCbConforme(true);
		ev.setDthrEvento(dataHoraFimTeste);
		ev.setLog(log);
		ev.setTipoEvento(ServicoFactory._PASSAGEM); // Passagem
		ev.setOrigem(nomeArquivo + " " + linhaResumida);
		
		List<MontagemDTO> montagens = new ArrayList<MontagemDTO>();
		montagens.add(createMontagemSerialProduto());
		ev.setMontagem(montagens);
		
		return ev;
	}
	private MontagemDTO createMontagemSerialProduto() {
		MontagemDTO montagemDTO = new MontagemDTO();
		montagemDTO.setCb(serialNumber);
		montagemDTO.setOrdem(ORDEM_MONTAGEM_SERIAL_PRODUTO);
		return montagemDTO;
	}
	public String getLinha() {
		return linha;
	}

	/*public boolean isLinhaNoPadraoEsperado() {
		if ((dateTime !=null) && (!dateTime.equals(""))
				&& (dateDateTime != null)) {
			return true;
		}
		return false;
	}*/

	public List<EventoColetado> obtemEvento() {
		List<EventoColetado> retorno = new ArrayList<>();
		
		try {
			if (linha != null) {
				EventoColetado eventoObtido = processarLinha();
				if (eventoObtido != null)
					retorno.add(eventoObtido);
			}
		} catch (Exception e) {
			log.info("LinhaArquivoRefMac: Excessao em obtemEvento da maquina: "
					+ getIcUpDTO().getUpDTO().getCd_up() + " - " + e);
		}
		return retorno;
	}
	
	private IcUpDTO getIcUpDTO() {
		return icUpDTO;
	}

}
