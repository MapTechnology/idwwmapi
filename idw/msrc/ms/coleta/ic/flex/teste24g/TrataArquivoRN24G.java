package ms.coleta.ic.flex.teste24g;

import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.List;

import idw.model.rn.DataHoraRN;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import idw.util.UtilsString;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.drivercoleta.PararDeProcessarArquivoSemSalvarLinhaException;
import ms.coleta.ic.flex.TrataArquivoRN;
import ms.model.dto.IcUpDTO;

public class TrataArquivoRN24G extends TrataArquivoRN {

	private String nsTemp = "";
	private int stTesteTemp = 0;
	private boolean isDeveriaLancarDefeito = false;
	private boolean isLancouDefeito = false;


	public TrataArquivoRN24G(String pathRelativo, IcUpDTO icupdto, ColetaFileType fileType, IdwLogger log, int idLog) {
		super(pathRelativo, icupdto, fileType, log, idLog);
	}

	protected boolean processaUmaLinhaDoArquivoCustom(File file, String name, int lineCount, String linhaArquivo) throws PararDeProcessarArquivoSemSalvarLinhaException {
		/*
		 * Abaixo exemplo de arquivo _FAIL.CSV de registro de falha no arquivo DUT S/N, 561743000287 DUT MAC, 561743000287 ;; TestName, CH,
		 * Demod, Rate, Ants, Data, Unit, LimitLo, LimitHi, P/F, ReTest, UsedTime, Remark Init Test, 0, <NA>, <NA>, 0, 1, , 1, 1, PASS, 0,
		 * 532, 2.4G HT40 CLPD delta Power, 6, HT40, MCS7, 1, 0.07, dB, -2, 2, PASS, 0, 1032, ActualPower = 14.57 dBm 2.4G HT40 CLPD delta
		 * Power, 6, HT40, MCS7, 2, -0.54, dB, -2, 2, PASS, 0, 297, ActualPower = 13.96 dBm 2.4G HT40 TX Mask, 3, HT40, MCS7, 1, 0.00, %, 0,
		 * 5, PASS, 0, 1453, BandPower = 14.61 dBm, FailedPoints = 0 2.4G HT40 TX Mask, 3, HT40, MCS7, 2, 0.00, %, 0, 5, PASS, 0, 766,
		 * BandPower = 14.29 dBm, FailedPoints = 0 2.4G HT40 TX Mask, 6, HT40, MCS7, 1, 0.12, %, 0, 5, PASS, 0, 1547, BandPower = 14.74 dBm,
		 * FailedPoints = 3 2.4G HT40 TX Mask, 6, HT40, MCS7, 2, 0.00, %, 0, 5, PASS, 0, 703, BandPower = 14.72 dBm, FailedPoints = 0 2.4G
		 * HT40 TX Mask, 9, HT40, MCS7, 1, 0.49, %, 0, 5, PASS, 0, 1515, BandPower = 14.54 dBm, FailedPoints = 12 2.4G HT40 TX Mask, 9,
		 * HT40, MCS7, 2, 0.00, %, 0, 5, PASS, 0, 704, BandPower = 14.50 dBm, FailedPoints = 0 2.4G HT40 TX EVM, 9, HT40, MCS7, 1, -30.06,
		 * dB, -9999, -27, PASS, 0, 1375, BurstPower = 14.30 dBm 2.4G Carrier Accuracy, 9, HT40, MCS7, 1, 6.53, ppm, -25, 25, PASS, 0, 0,
		 * EVM = -30.06 dB 2.4G HT40 TX EVM, 9, HT40, MCS7, 2, -30.11, dB, -9999, -27, PASS, 0, 593, BurstPower = 14.51 dBm 2.4G Carrier
		 * Accuracy, 9, HT40, MCS7, 2, 6.50, ppm, -25, 25, PASS, 0, 0, EVM = -30.11 dB 2.4G HT40 RX SEN, 6, HT40, MCS7, 1, 100.00, %, 0, 10,
		 * FAIL, 0, 32219, 500 pkts @ -61 dBm
		 * 
		 * Na linha acima existe uma coluna com o conteudo FAIL indicando o motivo de falha no teste. HT40 RX SEN é o cddefeito
		 */

		/*
		 * Alessandre em 11-07-18 identificamos que o 24G do produto HPNA é diferente do padrão. O diretorio nao é criado nem o arquivo
		 * _PASS.csv. Mas os dados do teste estão presentes no arquivo RUN_PASS.csv ou RUN_FAIL.csv com a seguinte estrutura
		 * 
		 * RUN_PASS.csv ;; ItemName, Mode, Chan, Rate, Pass, Data, Unit, UpLimit, LowLimit, Note ;; Report Date: 2018/07/11 11:25:07 ;; DUT
		 * S/N: 561828001247 ;; TestItem, CH, Demod, Rate, Ants, Data, Unit, Lo, Hi, P/F, ReTest, UsedTime, Remark
		 * XTalCalibration,6,11g,54,1,-0.310012,ppm,-10,10,PASS,0,5.63, TxEVM,1,11nHT20,2007,1,-34.1383,dB,-999,-27,PASS,0,3.59,
		 * Freq_Err,1,11nHT20,2007,1,-0.717534,ppm,-25,25,PASS,0,3.66, GatedPower,1,11nHT20,2007,1,16.9272,dBm,15.5,18.5,PASS,0,3.66,
		 * TxSpectralMask,1,11nHT20,2007,1,0,Points,0,50,PASS,0,3.69, TxEVM,1,11nHT20,2007,2,-32.4384,dB,-999,-27,PASS,0,3.73,
		 * Freq_Err,1,11nHT20,2007,2,-0.759118,ppm,-25,25,PASS,0,3.80, GatedPower,1,11nHT20,2007,2,16.8797,dBm,15.5,18.5,PASS,0,3.80,
		 * TxSpectralMask,1,11nHT20,2007,2,0,Points,0,50,PASS,0,3.83, RxSEN,13,11nHT20,2007,1,0,%,-999,10,PASS,0,2.47,64 dBm
		 * RxSEN,13,11nHT20,2007,2,0,%,-999,10,PASS,0,4.66,64 dBm
		 * ;;--------------------------------------------------------------------------------
		 * 
		 * 
		 * RUN_FAIL.csv
		 * 
		 * ;; ItemName, Mode, Chan, Rate, Pass, Data, Unit, UpLimit, LowLimit, Note ;; Report Date: 2018/07/11 10:13:01 ;; DUT S/N:
		 * 561828001190 ;; TestItem, CH, Demod, Rate, Ants, Data, Unit, Lo, Hi, P/F, ReTest, UsedTime, Remark
		 * ;;--------------------------------------------------------------------------------
		 * 
		 * aparentemente nao existe um motivo de defeito nesse arquivo.
		 * 
		 * 
		 * 
		 * 
		 * Alessandre em 26-12-18 para a linha 16 o 2.4G gerou um log diferente. Não existe um diretorio para o resultado dos testes e não
		 * existe arquivo com a extensão .csv. Existe apenas o _PASS.txt ou o _FAIL.txt no proprio diretorio de teste
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		boolean retorno;

		if (name.toUpperCase().endsWith("_PASS.CSV") || name.toUpperCase().endsWith("_PASS.TXT")) {
			isDeveriaLancarDefeito = false;
			retorno = trataLinhaArquivoComSucesso(name, lineCount, linhaArquivo);
		} else {
			isDeveriaLancarDefeito = true;
			retorno = trataLinhaArquivoComFalha(name, lineCount, linhaArquivo);
		}

		return retorno;
	}

	private boolean trataLinhaArquivoComFalha(String name, int lineCount, String linhaArquivo) throws PararDeProcessarArquivoSemSalvarLinhaException {
		boolean retorno = false;
		if (linhaArquivo.startsWith("DUT S/N, ")) {
			String[] splitted = linhaArquivo.split("DUT S/N, ");
			nsTemp = splitted[1];
			log.info(idLog, 0, "ns=" + nsTemp);
			linhaTemp = new String(linhaArquivo);
		} else if (linhaArquivo.startsWith(";; DUT S/N: ")) {
			String[] splitted = linhaArquivo.split(";; DUT S/N: ");
			nsTemp = splitted[1];
			log.info(idLog, 0, "ns=" + nsTemp);
			linhaTemp = new String(linhaArquivo);
		} else {
			// verifica se existe o conteudo FAIL na linha. Se sim, obter o codigo e lancar um teste com defeito
			if (linhaArquivo.contains("FAIL")) {
				List<String> colunas = UtilsString.quebrarStringEmVetor(linhaArquivo, ",");
				String cddefeito = colunas.get(0);
				Date datePassagem = DataHoraRN.getDataHoraAtual();
				lancaTesteComDefeito(linhaArquivo, datePassagem, nsTemp, 0, cddefeito);
				isLancouDefeito = true;
			}
		}

		return retorno;
	}

	/*
	 * Metodo usado para tratar uma linha do arquivo com sucesso no teste. No caso apenas as linhas 1 e 2 são consideradas. As outras sao
	 * descartadas
	 * 
	 */

	/*
	 * Alessandre em 26-12-2018, comentei o metodo abaixo pois nao esta funcionou para os diversos tipos de arquivos 2.4G private boolean
	 * trataLinhaArquivoComSucesso(String name, int lineCount, String linhaArquivo) throws PararDeProcessarArquivoSemSalvarLinhaException {
	 * boolean retorno = false; switch (lineCount) { case 1: case 3: if (linhaArquivo.startsWith("DUT S/N, ")) { String[] splitted =
	 * linhaArquivo.split("DUT S/N, "); nsTemp = splitted[1]; log.info("ns=" + nsTemp); linhaTemp = new String(linhaArquivo); } else if
	 * (linhaArquivo.startsWith(";; DUT S/N: ")) { String[] splitted = linhaArquivo.split(";; DUT S/N: "); nsTemp = splitted[1];
	 * log.info("ns=" + nsTemp); linhaTemp = new String(linhaArquivo); } else { retorno = true; } break; case 2: case 4: if
	 * (linhaArquivo.startsWith("DUT MAC, ")) { String[] splitted = linhaArquivo.split("DUT MAC, "); macTemp = splitted[1]; log.info("mac="
	 * + macTemp); linhaTemp += "\n" + linhaArquivo;
	 * 
	 * // Sempre com sucesso para esse metodo, que eh executado apenas quando o teste passa stTesteTemp = 1;
	 * 
	 * // Adotar esta data causa um bug, o ideal e utilizar a data de dentro do arquivo // Date datePassagem = new
	 * Date(file.lastModified()); // Porem, a data de dentro do arquivo e do formato: 04/07 08:52:52.562 // Ou seja, sem ano // Como a
	 * diferenca entre as horas correta e errada e de 4 horas, sera feita // uma compensacao // 1 segundo 1000 ms // 1 minuto 60000 ms // 1
	 * hora 3600000 ms // 4 horas 4*3600000 = 14400000 /* Alessandre em 24-04-18 comentei a linha abaixo e substitui pela seguinte. A
	 * compensacao das 4h foi removida pois estava causando um retrocesso de 4horas nos eventos Date datePassagem = new
	 * Date(file.lastModified() - 14400000); Date datePassagem = DataHoraRN.getDataHoraAtual();
	 * 
	 * // Verificar como usar o mac nesse posto. // Verificar quando há a assimilação desse mac na placa. lancaTesteSimples(linhaTemp,
	 * datePassagem, nsTemp, stTesteTemp);
	 * 
	 * isLancouDefeito = true; } retorno = false; break; default: lineCounter = 2; throw new
	 * PararDeProcessarArquivoSemSalvarLinhaException(); } return retorno; }
	 */
	private boolean trataLinhaArquivoComSucesso(String name, int lineCount, String linhaArquivo) throws PararDeProcessarArquivoSemSalvarLinhaException {
		boolean retorno = false;
		if (linhaArquivo.startsWith("DUT S/N, ")) {
			String[] splitted = linhaArquivo.split("DUT S/N, ");
			nsTemp = splitted[1];
			log.info(idLog, 0, "ns=" + nsTemp);
			linhaTemp = new String(linhaArquivo);
		} else if (linhaArquivo.startsWith(";; DUT S/N: ")) {
			String[] splitted = linhaArquivo.split(";; DUT S/N: ");
			nsTemp = splitted[1];
			log.info(idLog, 0, "ns=" + nsTemp);
			linhaTemp = new String(linhaArquivo);
		} else if (linhaArquivo.startsWith("DUT MAC, ")) {
			linhaTemp += "\n" + linhaArquivo;
			// Sempre com sucesso para esse metodo, que eh executado apenas quando o teste passa
			stTesteTemp = 1;
			Date datePassagem = DataHoraRN.getDataHoraAtual();
			// Verificar como usar o mac nesse posto.
			// Verificar quando há a assimilação desse mac na placa.
			lancaTesteSimples(linhaTemp, datePassagem, nsTemp, stTesteTemp);
			isLancouDefeito = true;
			retorno = true;
		} else if (linhaArquivo.contains("DUT S/N:")) {
			nsTemp = linhaArquivo.substring(linhaArquivo.indexOf("DUT S/N:") + 9);
			stTesteTemp = 1;
			Date datePassagem = DataHoraRN.getDataHoraAtual();
			// Verificar como usar o mac nesse posto.
			// Verificar quando há a assimilação desse mac na placa.
			lancaTesteSimples(linhaTemp, datePassagem, nsTemp, stTesteTemp);
			isLancouDefeito = true;
			retorno = true;
		}
		return retorno;
	}

	/*
	 * Metodo é utilizado para avaliar se a falha foi lancada. Nao sera lancada quando o arquivo CSV nao tiver o motivo, nesse caso devemos
	 * lancar com codigo de defeito generico
	 * 
	 */
	@Override
	protected void tratativaFinalDoArquivo() throws PararDeProcessarArquivoSemSalvarLinhaException {
		if (isLancouDefeito == false) {
			Date datePassagem = DataHoraRN.getDataHoraAtual();

			stTesteTemp = isDeveriaLancarDefeito ? 0 : 1;

			lancaTesteSimples(linhaTemp, datePassagem, nsTemp, stTesteTemp);
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
				log.info(idLog, 0, "Excessao", e);
			}
		}
		return retorno;
	}

	@Override
	protected void salvaInformacoesNecessarias(String arquivoProcessado) {
		try {
			String fileName = pathDirParaProcessamento + maquina + "-" + arquivoProcessado + ".txt";
			log.info(idLog, 0, "Salvando ultimaLinhaProcessada" + lineCounter + " em " + fileName);
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			writer.println(ultimaLinhaProcessada);
			writer.println(String.valueOf(lineCounter));
			writer.println(ultimoArquivoProcessado);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.info(idLog, 0, "Excessao", e);
		}
	}

}
