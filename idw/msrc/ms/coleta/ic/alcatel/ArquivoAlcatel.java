package ms.coleta.ic.alcatel;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;

import idw.model.rn.DataHoraRN;
import idw.util.ArquivoLeitura;
import idw.util.IdwLogger;
import idw.util.Util;
import ms.coleta.Stubedelegate;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;

public class ArquivoAlcatel {

	private String serialNumber; // Numero de serie do produto
	private String testBench; // identificco do posto de trbalho
	private String operator; // identificco do operador que realizou o teste
	private String starttime; // data e hora do teste
	private String serviceError; // Se 0 teste com sucesso se <> 0 teste com erro
	private String errorIndex; // codigo do defeito

	private String padraoSerialNumber = "@(?:Serial Number:)(.+)";
	private String padraoTestBench = "@(?:Test Bench:)(.+)";
	private String padraoOperator = "@(?:Operator:)(.+)";
	private String padraStarttime = "@(?:Start Time:)(.+)";
	private String padraoServiceError = "@(?:Service Error:)(.+)";
	private String padraoErrorIndex = "@(?:Error Index:)(.+)";

	private IdwLogger log;
	
	public ArquivoAlcatel(IdwLogger log) {
		super();
		this.log = log;
	}
	
	public EventoColetado obtemEvento(InputStream input) {
		
		ArquivoLeitura arquivo = new ArquivoLeitura(new InputStreamReader(input));
		StringBuilder todoArquivo = new StringBuilder();
		try {
			while (arquivo.ready()) {
				todoArquivo.append(arquivo.readLine());
				todoArquivo.append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
			log.info("Excessao: ", e);
			return null;
		} finally {
			try {
				arquivo.close();
			} catch (IOException e) {
				e.printStackTrace();
				log.info("Excessao:", e);
				return null;
			}
		}
		
		String conteudo = todoArquivo.toString();
		
		serialNumber = Util.extraiPorMascara(conteudo, padraoSerialNumber, 1).trim();
		testBench = Util.extraiPorMascara(conteudo, padraoTestBench, 1).trim();
		operator = Util.extraiPorMascara(conteudo, padraoOperator, 1).trim();
		starttime = Util.extraiPorMascara(conteudo, padraStarttime, 1).trim();
		serviceError = Util.extraiPorMascara(conteudo, padraoServiceError, 1).trim();
		errorIndex = Util.extraiPorMascara(conteudo, padraoErrorIndex, 1).trim();

		EventoColetado evento = new EventoColetado();
		evento.setTipoEvento(ServicoFactory._PASSAGEM);
		evento.setIcUpDTO(Stubedelegate.getInstancia().getMsthread().getIcUp(testBench));
		evento.setCb(serialNumber);
		evento.setNumeroSerie(evento.getCb());
		try {
			evento.setDthrEvento(DataHoraRN.toDateFromYYYYMMDDHHMISS(starttime));
		} catch (ParseException e) {
			e.printStackTrace();
			log.info("Excessao: ", e);
			return null;
		}
		evento.setCdtecResponsavel(operator);
		evento.setCddefeito(errorIndex);
		
		if (serviceError.equals("0") == false) {
			evento.setCddefeito(errorIndex);
			evento.setIsCbConforme(false);
		} else {
			evento.setIsCbConforme(true);
		}
		log.info("serialNumber:" + serialNumber);
		log.info("testBench:" + testBench);
		log.info("Operador:" + operator);
		log.info("Starttime: " + starttime);
		log.info("serviceError:" + serviceError);
		log.info("errorIndex: " + errorIndex);
		return evento;
	}
	
	
	
	
	/* avaliacao do regexe do arquivo
	 * 
	 */
	public static void main(String[] args) {
		StringBuilder arq = new StringBuilder();
		
		String serialNumber; // Numero de serie do produto
		String testBench; // identificco do posto de trbalho
		String operator; // identificco do operador que realizou o teste
		String starttime; // data e hora do teste
		String serviceError; // Se 0 teste com sucesso se <> 0 teste com erro
		String errorIndex; // codigo do defeito

		String padraoSerialNumber = "@(?:Serial Number:)(.+)";
		String padraoTestBench = "@(?:Test Bench:)(.+)";
		String padraoOperator = "@(?:Operator:)(.+)";
		String padraStarttime = "@(?:Start Time:)(.+)";
		String padraoServiceError = "@(?:Service Error:)(.+)";
		String padraoErrorIndex = "@(?:Error Index:)(.+)";

		arq.append("Serial Number:L5KE01J1CLZE8M3\n");
		arq.append("Test Site:HUIZHOU\n");
		arq.append("Test Bench:PT02-LINHAT01\n");
		arq.append("Slot Number:2\n");
		arq.append("Test Mode:Final\n");
		arq.append("LOT Type:MASS PROD\n");
		arq.append("Operator:1234567\n");
		arq.append("Start Time:2016-12-1 09:52:04\n");
		arq.append("Engine Version:4.0.0\n");
		arq.append("GUI Version:4.0.0\n");
		arq.append("Test Service Version:4.0.0\n");
		arq.append("Scenario Version:4.0.0\n");
		arq.append("JIG SN:WAA28H031042\n");
		arq.append("RfDevice:IQXS10859\n");
		arq.append("PowerSupply:2306\n"); 
		arq.append("OtherDevice:NONE\n");
		arq.append("****************************************************************************\n");
		arq.append("----------------------------------------------------------------------------\n");
		arq.append("Code Measure                        Result              Tol Min   Tol Max  \n");
		arq.append("----------------------------------------------------------------------------\n");
		arq.append("PNNN02 CloseJigTest                  :0.00      -    OK   0.00      0.00\n");      
		arq.append("PT0001 CloseJigTestTime              :1.03      -    OK   --        999.99\n");    
		arq.append("PNNN0A ConnectMetaTest               :-1.00     -    NOK  0.00      0.00\n");      
		arq.append("****************************************************************************\n");
		arq.append("Test time: 199 second\n");
		arq.append("****************************************************************************\n");
		arq.append("----------------------------------------------------------------------------\n");
		arq.append("Service Error:PNNN0A\n");
		arq.append("Error Code Group: PNNN0A\n");
		arq.append("Error Index: PNNN0A---Fail\n");

		String conteudo = arq.toString();
		
		serialNumber = Util.extraiPorMascara(conteudo, padraoSerialNumber, 1);
		testBench = Util.extraiPorMascara(conteudo, padraoTestBench, 1);
		operator = Util.extraiPorMascara(conteudo, padraoOperator, 1);
		starttime = Util.extraiPorMascara(conteudo, padraStarttime, 1);
		serviceError = Util.extraiPorMascara(conteudo, padraoServiceError, 1);
		errorIndex = Util.extraiPorMascara(conteudo, padraoErrorIndex, 1);
		
		Date dthr;
		try {
			dthr = DataHoraRN.toDateFromYYYYMMDDHHMISS(starttime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dthr=new Date();
		}
		
		System.out.println("serialNumber " + serialNumber);
		System.out.println("testBench " + testBench);
		System.out.println("operator " + operator);
		System.out.println("starttime " + starttime);
		System.out.println("Data e hora starttime " + dthr);
		System.out.println("serviceError " + serviceError);
		System.out.println("errorIndex " + errorIndex);
		
	}
}
