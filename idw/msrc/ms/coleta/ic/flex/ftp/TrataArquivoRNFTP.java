package ms.coleta.ic.flex.ftp;

import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import idw.model.rn.DataHoraRN;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.drivercoleta.PararDeProcessarArquivoSemSalvarLinhaException;
import ms.coleta.ic.flex.TrataArquivoRN;
import ms.model.dto.IcUpDTO;

public class TrataArquivoRNFTP extends TrataArquivoRN {

	public TrataArquivoRNFTP(String pathRelativo, IcUpDTO icupdto, ColetaFileType fileType, IdwLogger log, int idLog) {
		super(pathRelativo, icupdto, fileType, log, idLog);
		// TODO Auto-generated constructor stub
	}

	protected boolean processaUmaLinhaDoArquivoCustom(File file, String name, int lineCount, String linhaArquivo) throws PararDeProcessarArquivoSemSalvarLinhaException {
		// 1o PADRAO DO FTP
		// 0	1			2		3	4			5		6	7		 8	9	   		 10
		// W609 4/1/2016 	3:23:31 PM 	4/1/2016 	3:24:50 PM 	12:01:19 AM 9897D1DCD3D6 41534 GPT-2541GNAC
		// W106 4/1/2016 	3:35:04 PM 	4/1/2016 	3:35:56 PM 	12:00:52 AM 9897D1DCD3D6 41534 GPT-2541GNAC

		// 2o PADRAO DO FTP
		// 0	1			2			3			4			5			6			 	   7	   				8
		// T100 5/16/2018 	9:02:59 	5/16/2018 	9:05:20 	0:02:22 	A433D727F9B6 	   GPT-2541GN2A4 v1     D:\N1\GTP-2541GNAC_N1_2.4G&5G_Mini boot.dat                  158205000  241705000  0          0          0          0                                                              40                                                                                                                                0          0          0          0          0          0          0          0          0          0         ,

		String[] parameters = linhaArquivo.split("\\s+");
		if (parameters.length >= 6) {
			String errorCode = parameters[0];
			/* o inicio do teste é descartado pois não é utilizado
			 * String dataInicio = parameters[1]; String horaInicio = parameters[2]; String ampmInicio = parameters[3];
			 */
			String dataFim = null;
			String horaFim = null;
			String ampmFim = null;
			String serialNumber = null;
			
			// Se na coluna 3 existir AM ou PM entao a data esta no formato AM/PM. Nesse caso a numeracao das colunas se modificam
			DateFormat formatterMMddYY;
			DateFormat formatterDDmmYY;
			if (parameters[3].equals("AM") || parameters[3].equals("PM")) {
				dataFim = parameters[4];
				horaFim = parameters[5];
				ampmFim = parameters[6];
				if (parameters.length >= 9)
					serialNumber = parameters[9];
				formatterMMddYY = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
				formatterDDmmYY = new SimpleDateFormat("dd/MM/yyyy h:mm:ss a");
			} else {
				dataFim = parameters[3];
				horaFim = parameters[4];
				ampmFim = "";
				serialNumber = parameters[6];
				formatterMMddYY = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				formatterDDmmYY = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			}
			
			
			String dateStr = dataFim + " " + horaFim + " " + ampmFim;
			try {
				Date datePassagem = (Date) formatterMMddYY.parse(dateStr);
				Date dtRef = DataHoraRN.getDataHoraAtual();
				dtRef = DataHoraRN.adicionaDiasDaData(dtRef, 1); // Dt usada como referencia para avaliar se a conversao foi feita corretamente. Se nao for utilizar outro formato para converter
				if (DataHoraRN.after(datePassagem, dtRef)) {
					datePassagem = (Date) formatterDDmmYY.parse(dateStr);
				}
				
				// Avaliar se o evento a ser lancado é muito antigo. Se for descarta-lo
				dtRef = DataHoraRN.getDataHoraAtual();
				dtRef = DataHoraRN.subtraiDiasDaData(dtRef, 1);
				
				if (datePassagem.after(dtRef)) {
					int stTeste = 0;
					if (errorCode.compareTo("T100") == 0) {
						stTeste = 1;
						lancaTesteSimples(linhaArquivo, datePassagem, serialNumber, stTeste);
					} else {
						lancaTesteComDefeito(linhaArquivo, datePassagem, serialNumber, stTeste, errorCode);
					}
				}
			} catch (ParseException e) {
				log.info(idLog, 0, "Erro", e);
				return true;
			}
		}
		return false; // retornando false o processamento da linha nao ira parar
	}

	@Override
	protected boolean obtemInformacoesNecessarias(String arquivoProcessado) {
		boolean retorno = false;

		String fileName = pathDirParaProcessamento + maquina + "-" + arquivoProcessado + ".txt";

		if (ArquivosDiretorios.isExisteArquivo(fileName) == true) {
			try (RandomAccessFile reader = new RandomAccessFile(fileName, "r")) {
				this.ultimaLinhaProcessada = reader.readLine();
				this.lineCounter = Integer.parseInt(reader.readLine());
				this.ultimoArquivoProcessado = reader.readLine();
				retorno = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return retorno;
	}

	@Override
	protected void salvaInformacoesNecessarias(String arquivoProcessado) {
		try {
			String fileName = pathDirParaProcessamento + maquina + "-" + arquivoProcessado + ".txt";
			log.info("Salvando ultimaLinhaProcessada" + lineCounter + " em " + fileName);
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			writer.println(ultimaLinhaProcessada);
			writer.println(String.valueOf(lineCounter));
			writer.println(ultimoArquivoProcessado);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void tratativaFinalDoArquivo() {
	}
}
