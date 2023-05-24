package ms.coleta.ic.flex.askey;

import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.drivercoleta.PararDeProcessarArquivoSemSalvarLinhaException;
import ms.coleta.ic.flex.TrataArquivoRN;
import ms.model.dto.IcUpDTO;

public class TrataArquivoRNAskey extends TrataArquivoRN{

	public TrataArquivoRNAskey(String pathRelativo, IcUpDTO icupdto, ColetaFileType fileType, IdwLogger log, int idLog) {
		super(pathRelativo, icupdto, fileType, log, idLog);
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
	protected boolean processaUmaLinhaDoArquivoCustom(File file, String name, int lineCount, String linhaArquivo) throws PararDeProcessarArquivoSemSalvarLinhaException {
		// 2018/06/13 07:19:17 fSendData:(0) 172.16.51.34 RTV7313VW-D271(RoHS) 1CB04489B070 Final L12 0000000000 CX-INDIVIDUAL TIME=20180613 07:17:56,1CB04489B070,4181B068168,2018/06/13,07:19:17,ANT1,2644,ANT2,1593,3000,0,0,L12 CHECK LED FAIL
		// 2018/06/13 07:21:31 fSendData:(0) 172.16.51.34 RTV7313VW-D271(RoHS) 1CB04489B070 Final L12 0000000000 CX-INDIVIDUAL TIME=20180613 07:20:18,1CB04489B070,4181B068168,2018/06/13,07:21:31,ANT1,2564,ANT2,1395,3000,0,0,L12 CHECK LED FAIL
		// 2018/06/13 15:25:52 fSendData:(0) 172.16.51.34 RTV7313VW-D271(RoHS) 1CB04489B070 Final 00 0000000000 CX-INDIVIDUAL TIME=20180613 15:24:02,1CB04489B070,4181B068168,2018/06/13,15:25:52,ANT1,1830,ANT2,1884,3000,4503,36735,00 PASS
		
		// String[] parameters = linhaArquivo.split("\\s+");
		// Como o final do arquivo tem virgulas, o split sera por elas
		String[] parameters = linhaArquivo.split(",");
		// Nos casos observados, existiam 13 parametros apos o split
		if (parameters.length >= 13) {
			String parametroInicial = parameters[0];
			String mac = parameters[1];
			String dataFim = parameters[3];
			String horaFim = parameters[4];
			String result = parameters[12];
			
			String programa;			
			String nomePosto;
			// Faz split por 1 caracter de espaco
			String[] additionalParameters = parametroInicial.split("\\s");
			// Nos casos observados, existiam 12 parametros apos o split
			if (additionalParameters.length > 10) {
				programa = additionalParameters[4];
				nomePosto = additionalParameters[9];
			}
			if (dataFim != null && !dataFim.equals("")
					&& horaFim != null && !horaFim.equals("")
					&& result != null && !result.equals("")) {
				DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date datePassagem;
				try {
					datePassagem = (Date) formatter.parse(dataFim + " " + horaFim);
				} catch (ParseException e) {
					log.info(idLog, 0, "Erro", e);
					return true;
				}
				
				String[] arrayResult = result.split("\\s");
				if (arrayResult != null && arrayResult.length > 0) {
					String resultCode = arrayResult[0]; 
					int stTeste = 0;
					if (resultCode.equals("00")) {
						stTeste = 1;
						lancaTesteSimples(linhaArquivo, datePassagem, mac, stTeste);
					} else {
						lancaTesteComDefeito(linhaArquivo, datePassagem, mac, stTeste, resultCode);
					}
				}
			}
		}
		return false; // retornando false o processamento da linha nao ira parar
	}

	@Override
	protected void tratativaFinalDoArquivo() {
	}
}
