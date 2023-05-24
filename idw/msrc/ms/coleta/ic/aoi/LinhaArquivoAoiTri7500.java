package ms.coleta.ic.aoi;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.util.IdwLogger;
import ms.coleta.ic.fuji.ICFuji;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsString;


public class LinhaArquivoAoiTri7500 {

	private IdwLogger log;
	private List<String> linhas = new ArrayList<String>();
	private ICAoiOmron ic;
	private IcUpDTO icUpDTO;
		
	//Campos do log
	private String op = null;
	private String date = null;
	private String timeIn = null;
	private String timeOut = null;
	private Map<String,String[]> componentError = new HashMap<String,String[]>();
	private String linhaResumida = null;
	private String logResult;
	//Dados
	private Date dateTime = null;
	
	public LinhaArquivoAoiTri7500(IdwLogger log, ICAoiOmron ic, IcUpDTO icUpDTO, List<String> linhas) {
		this.log = log;
		this.ic = ic;
		this.icUpDTO = icUpDTO;
		this.linhas = linhas;
		parseLinhaTratada();
	}
	
	private void parseLinhaTratada() {
		
		try {
			String[] linhaAux;
			String dataHora;
						
			for(String linha:linhas) {
				
				if(linha.contains("BDT")) {
					op = linha.replace("BDT:","");
				}
				
				if(linha.contains("TTD")) {
					
					date = linha.replace("TTD:","");
				}
				
				if(linha.contains("TTS")) {
					
					timeIn = linha.replace("TTS:","");
				}
				
				if(linha.contains("TTE")) {
					
					timeOut = linha.replace("TTE:","");
				}
				
				if (linha.contains("MWA")) {
					
					linha = linha.replace("MWA:", "");
					linha = linha.replace("[", "");
					linha = linha.replace("]", "");
					
					linhaAux = linha.split(",");
					componentError.put(linhaAux[0], linhaAux[2].split("_"));
					
				}
				
			}
			
			dataHora = date + " " + timeIn;
			dateTime = LinhaArquivoAoiTri7500.convertToDateLogAoiTri(dataHora);
			linhaResumida = op +"\t" + date + "\t" + timeIn; 
			
			logResult = linhas.get(linhas.size()-2);
				
		}catch (Exception e) {
			log.error("LinhaArquivoAOI: falha ao realizar parseLinhaTratada() " + e);
		}
		
	}
	
	public List<String> getLinhas() {
		return linhas;
	}
	
	public String getResult() {
		return logResult;
		
	}
	
	public void obtemEvento() {
		
		if(logResult.equals("PASSED")) {
			//lancaTesteSimples(linhaArquivo, fimCicloDate, serialNumber, 1);	
		}
		
		if(logResult.equals("FAIL")) {
			for (Map.Entry<String, String[]> e : componentError.entrySet()) {
			//lancaTesteComDefeito(linhaArquivo, fimCicloDate, serialNumber, 0, errorCode);
			}
		}
			
	}
		
	public static Date convertToDateLogAoiTri(String origem) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;
			
		SimpleDateFormat formato = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
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
