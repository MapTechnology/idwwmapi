package ms.coleta.ic.drivercoleta;

import idw.model.IdwFacade;
import idw.model.pojos.DwFolhamoncomp;
import idw.model.rn.DataHoraRN;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import idw.webservices.dto.MontagemDTO;
import idw.webservices.dto.MontagensDTO;

import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.model.dto.IcUpDTO;

public class TrataArquivoRNPTRXPK extends TrataArquivoRN{
	private int indexOfDateIni = 130;
	private int indexOfDateFim = 140;
	
	private int indexOfStartTimeIni = 144;
	private int indexOfStartTimeFim = 152;
	
	private int indexOfEndTimeIni = 161;
	private int indexOfEndTimeFim = 169;
	
	private int indexOfTestTimeIni = 200;
	private int indexOfTestTimeFim = 208;
	
	private int indexOfSerialNumberIni = 217;
	private int indexOfSerialNumberFim = 229;
	
	private int indexOfCartonSerialNumberIni = 255;
	private int indexOfCartonSerialNumberFim = 277;
	
	private int indexOfMACIni = 277;
	private int indexOfMACFim = 305;
	
	private int indexOfErrorCodeIni = 604;
	private int indexOfErrorCodeFim = 608;
	
	public TrataArquivoRNPTRXPK(String pathRelativo, IcUpDTO icupdto, ColetaFileType fileType, IdwLogger log) {
		super(pathRelativo, icupdto, fileType, log);
	}
	
	public static void main(String[] args) {
		String mac = "A4B7C0D5E4EF";
		Long macBaseInteger = Long.parseLong(mac, 16);
		for(int i=0; i<5; i++) {
			Long newMac = macBaseInteger+i;
			String newMacString = Long.toHexString(newMac).toUpperCase();
			System.out.println("MAC"+i+"="+newMacString);
		}
	}

	//Metodo para pegar os Indexes dos campos do arquivoLog
	private void setIndexOfParametersPTRXPK(ColetaFileType fileType, String linhaArquivo, int lineCounter) {
		if(lineCounter == 2) {
			//RK E PK quando tiver oportunidade é mais seguro pegar os indexes direto do nome dos campos
			indexOfDateIni = linhaArquivo.indexOf("DATE");
			indexOfDateFim = linhaArquivo.indexOf("START_TIME");
			
			indexOfStartTimeIni = indexOfDateFim;
			indexOfStartTimeFim = linhaArquivo.indexOf("END_TIME");
			
			indexOfEndTimeIni = indexOfStartTimeFim;
			indexOfEndTimeFim = linhaArquivo.indexOf("SFCS_Time");
			
			indexOfTestTimeIni = linhaArquivo.indexOf("TEST Time");
			indexOfTestTimeFim  = linhaArquivo.indexOf("S/N");
			
			indexOfSerialNumberIni = indexOfTestTimeFim;
			indexOfSerialNumberFim = linhaArquivo.indexOf("CSN");
			
			indexOfCartonSerialNumberIni = indexOfSerialNumberFim;
			indexOfCartonSerialNumberFim = linhaArquivo.indexOf("MAC ");
			
			indexOfMACIni = indexOfCartonSerialNumberFim;
			indexOfMACFim = linhaArquivo.indexOf("LAST_MAC");
			
			indexOfErrorCodeIni = linhaArquivo.indexOf("ERR_CODE");
			indexOfErrorCodeFim = linhaArquivo.indexOf("ERROR_MESSAGE");
		}
	}
	
	//Transforma List<DwFolhamoncomp> em MontagensDTO preenchendo CB com o MAC incrementado
	private MontagensDTO getMontagensDTOPreenchidoComMAC(List<DwFolhamoncomp> listaMontagemComponente, String mac) {
        List<MontagemDTO> listadto = new ArrayList<>();
        
        for(DwFolhamoncomp comp : listaMontagemComponente) {
        	int total = 1;
        	if(comp.getQtAmontar() != null)
        		total = comp.getQtAmontar();
        	for(int i=0; i<total; i++) {
                MontagemDTO dto = new MontagemDTO();
                dto.setCb("");
                dto.setDsProdutoEsperado(comp.getDsMon());
                dto.setOrdem(comp.getOrdem());
                dto.setIdProdutoEsperado(comp.getOmProduto().getIdProduto());
                dto.setIdProdutoAcoplado(comp.getOmProduto().getIdProduto());
                listadto.add(dto);        		
        	}
        }
        
        Collections.sort(listadto, new Comparator<MontagemDTO>() {
            @Override
            public int compare(MontagemDTO o1, MontagemDTO o2) {
                Integer m1 = o1.getOrdem();
                Integer m2 = o2.getOrdem();
                return m1.compareTo(m2);
            }
        });
        
        int i=0;
        Long macBaseInteger = Long.parseLong(mac, 16);
        
        for(MontagemDTO dto : listadto) {
			Long newMac = macBaseInteger+i;
			String newMacString = Long.toHexString(newMac).toUpperCase();
        	dto.setCb(newMacString);
        	i++;
        }
        
        MontagensDTO montagens = new MontagensDTO();
        montagens.setListaMontagem(listadto);
        
        return montagens;
	}
	
	//Lancar um evento de Montagem usando o MAC indicado como base
	private void lancaMontagemMac(String linha, Date horaPassagem, String serialNumber, String mac, boolean stTeste) {
		String cdUp = icupdto.getUpDTO().getCd_up();
		String dthrEvento = DataHoraRN.dateToStringDDMMYYYYHHMMSS(horaPassagem);
		log.info("MontagemMac - UP("+cdUp+") NS("+serialNumber+") - DTHR("+dthrEvento+") - MAC0("+mac+")");
		log.iniciaAvaliacao("lancaMontagemMac");
		List<DwFolhamoncomp> listaMontagemComponente = IdwFacade.getInstancia().getListaDwFolhamoncomp(cdUp);
		
		if(listaMontagemComponente == null || listaMontagemComponente.size() == 0) {
			log.info("listaMontagemComponente == null ou listaMontagemComponente.size() == 0");
			return;
		}
		
		MontagensDTO montagens = getMontagensDTOPreenchidoComMAC(listaMontagemComponente, mac);

		try{
			IdwFacade.getInstancia().getValidarNumeroDeSerie(cdUp, null, serialNumber, "", 8l, false);
			IdwFacade.getInstancia().registrarMontagem(cdUp, null, serialNumber, horaPassagem, montagens, "1", stTeste, null);
			Thread.sleep(500);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		log.getAvaliacaoCompleta();
	}
	
	private void processaUmaLinhaDoArquivoPTRX(String linhaArquivo) {
		// Replace tabs to spaces
		if (linhaArquivo != null)
			linhaArquivo = linhaArquivo.replaceAll("\t", "    ");

		String date = linhaArquivo.substring(indexOfDateIni, indexOfDateFim).trim();
		String endTime = linhaArquivo.substring(indexOfEndTimeIni, indexOfEndTimeFim).trim();
		String serialNumber = linhaArquivo.substring(indexOfSerialNumberIni, indexOfSerialNumberFim).trim();
		String errorCode = linhaArquivo.substring(indexOfErrorCodeIni, indexOfErrorCodeFim).trim();

		StringBuilder logTemp = new StringBuilder();
		logTemp.append("date("+indexOfDateIni+","+indexOfDateFim+")="+date);
		logTemp.append("endTime("+indexOfEndTimeIni+","+indexOfEndTimeFim+")="+endTime);
		logTemp.append("serialNumber("+indexOfSerialNumberIni+","+indexOfSerialNumberFim+")="+serialNumber);
		logTemp.append("errorCode("+indexOfErrorCodeIni+","+indexOfErrorCodeFim+")="+errorCode);
		log.info(logTemp.toString());
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date fimCicloDate = null;
		try {
			fimCicloDate = format.parse(date + " " + endTime);
			if(errorCode.equalsIgnoreCase("T908"))
				lancaTesteSimples(linhaArquivo, fimCicloDate, serialNumber, 1);
			else
				lancaTesteSimples(linhaArquivo, fimCicloDate, serialNumber, 0);
		} catch (ParseException e) {
			log.info("ParseException em DTHR_FIM_CICLO: " + e.toString());
		}
	}
	
	private void processaUmaLinhaDoArquivoPK(String linhaArquivo) {
		// Replace tabs to spaces
		if (linhaArquivo != null)
			linhaArquivo = linhaArquivo.replaceAll("\t", "    ");
		String date = linhaArquivo.substring(indexOfDateIni, indexOfDateFim).trim();
		String endTime = linhaArquivo.substring(indexOfEndTimeIni, indexOfEndTimeFim).trim();
		String serialNumber = linhaArquivo.substring(indexOfSerialNumberIni, indexOfSerialNumberFim).trim();
		String mac = linhaArquivo.substring(indexOfMACIni, indexOfMACFim).trim();
		String errorCode = linhaArquivo.substring(indexOfErrorCodeIni, indexOfErrorCodeFim).trim();
		
		StringBuilder logTemp = new StringBuilder();
		logTemp.append("date("+indexOfDateIni+","+indexOfDateFim+")="+date);
		logTemp.append("endTime("+indexOfEndTimeIni+","+indexOfEndTimeFim+")="+endTime);
		logTemp.append("serialNumber("+indexOfSerialNumberIni+","+indexOfSerialNumberFim+")="+serialNumber);
		logTemp.append("mac("+indexOfMACIni+","+indexOfMACFim+")="+mac);
		logTemp.append("errorCode("+indexOfErrorCodeIni+","+indexOfErrorCodeFim+")="+errorCode);
		log.info(logTemp.toString());
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date fimCicloDate = null;
		try {
			fimCicloDate = format.parse(date + " " + endTime);
			if(errorCode.equalsIgnoreCase("T908"))
				lancaMontagemMac(linhaArquivo, fimCicloDate, serialNumber, mac, true);
			else
				lancaMontagemMac(linhaArquivo, fimCicloDate, serialNumber, mac, false);
		} catch (ParseException e) {
			log.info("ParseException em DTHR_FIM_CICLO: " + e.toString());
		}
	}
	

	//Processamento do arquivo de LOG dos postos PT e RX.
	//Homologado para as versões:
	//	PT - V3.00S-19
	//		Neste caso o nome do arquivo tinha um espaço e isso quebrou todo o log. Avaliar junto do Paolo um caso SEM o ESPAÇO
	//	RX - V2.1.41
	//		Neste caso os conteudos estão alinhados com os cabeçalhos.
	//	PK - V2.2.16
	//		Neste caso os conteudos estão alinhados com os cabeçalhos.
	protected boolean processaUmaLinhaDoArquivoCustom(File file, String name, int lineCount, String linhaArquivo) throws PararDeProcessarArquivoSemSalvarLinhaException
	{
		log.info("processaUmaLinhaDoArquivoPTRX"+lineCounter+" - "+linhaArquivo);
		if(lineCounter == 1) {
			if(linhaArquivo.compareToIgnoreCase("V2.1.41") == 0) {
				//RX
				//V2.1.41 em 14/10
				//V2.1.41 em 01/04
			} else if(linhaArquivo.compareToIgnoreCase("V2.2.16") == 0) {
				//PT
				//V2.2.16 em 14/10
				//V3.00S-19 em 06/05
			} else if(linhaArquivo.compareToIgnoreCase("V2.2.26") == 0) {
				//PK
				//V2.2.26 em 14/10
				//V2.2.16 em 02/08
			}
		}
		setIndexOfParametersPTRXPK(fileType, linhaArquivo, lineCount);
		if(lineCounter <= 2)
			return false;
		if(linhaArquivo.length() > 777) {
			if(fileType == ColetaFileType.MITRASTAR_PK)
				processaUmaLinhaDoArquivoPK(linhaArquivo);
			else
				processaUmaLinhaDoArquivoPTRX(linhaArquivo);
		}
		return false;
	}
	
	
	
    protected boolean obtemInformacoesNecessarias()
    {
        boolean retorno = false;
        
        String fileName = pathDirParaProcessamento + maquina + ".txt";
        
        if (ArquivosDiretorios.isExisteArquivo(fileName) == true)
        {
            try(RandomAccessFile reader = new RandomAccessFile(fileName, "r"))
            {
                this.ultimaLinhaProcessada = reader.readLine();
                this.lineCounter = Integer.parseInt(reader.readLine());
                this.indexOfDateIni = Integer.parseInt(reader.readLine());
                this.indexOfDateFim = Integer.parseInt(reader.readLine());
                this.indexOfStartTimeIni = Integer.parseInt(reader.readLine());
                this.indexOfStartTimeFim = Integer.parseInt(reader.readLine());
                this.indexOfEndTimeIni = Integer.parseInt(reader.readLine());
                this.indexOfEndTimeFim = Integer.parseInt(reader.readLine());
                this.indexOfTestTimeIni = Integer.parseInt(reader.readLine());
                this.indexOfTestTimeFim = Integer.parseInt(reader.readLine());
                this.indexOfSerialNumberIni = Integer.parseInt(reader.readLine());
                this.indexOfSerialNumberFim = Integer.parseInt(reader.readLine());
                this.indexOfCartonSerialNumberIni = Integer.parseInt(reader.readLine());
                this.indexOfCartonSerialNumberFim = Integer.parseInt(reader.readLine());
                this.indexOfMACIni = Integer.parseInt(reader.readLine());
                this.indexOfMACFim = Integer.parseInt(reader.readLine());
                this.indexOfErrorCodeIni = Integer.parseInt(reader.readLine());
                this.indexOfErrorCodeFim = Integer.parseInt(reader.readLine());
                this.ultimoArquivoProcessado = reader.readLine();
                retorno = true;
            }
            catch (Exception e)
            {
            	e.printStackTrace();
            }
        }
        return retorno;
    }

	protected void salvaInformacoesNecessarias() 
	{
		try
		{
			String fileName = pathDirParaProcessamento + maquina + ".txt";
			log.info("Salvando ultimaLinhaProcessada"+lineCounter+" em "+fileName);
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			writer.println(ultimaLinhaProcessada);
			writer.println(String.valueOf(lineCounter));
			writer.println(String.valueOf(indexOfDateIni));
			writer.println(String.valueOf(indexOfDateFim));
			writer.println(String.valueOf(indexOfStartTimeIni));
			writer.println(String.valueOf(indexOfStartTimeFim));
			writer.println(String.valueOf(indexOfEndTimeIni));
			writer.println(String.valueOf(indexOfEndTimeFim));
			writer.println(String.valueOf(indexOfTestTimeIni));
			writer.println(String.valueOf(indexOfTestTimeFim));
			writer.println(String.valueOf(indexOfSerialNumberIni));
			writer.println(String.valueOf(indexOfSerialNumberFim));
			writer.println(String.valueOf(indexOfCartonSerialNumberIni));
			writer.println(String.valueOf(indexOfCartonSerialNumberFim));
			writer.println(String.valueOf(indexOfMACIni));
			writer.println(String.valueOf(indexOfMACFim));			
			writer.println(String.valueOf(indexOfErrorCodeIni));
			writer.println(String.valueOf(indexOfErrorCodeFim));
			writer.println(ultimoArquivoProcessado);
			writer.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
