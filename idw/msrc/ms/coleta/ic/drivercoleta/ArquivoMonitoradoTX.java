package ms.coleta.ic.drivercoleta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;

public class ArquivoMonitoradoTX extends ArquivoMonitorado {
	
	int estruturaDiretorio = 0;
	
	private FileFilter onlyNewCalibrationLogs = new FileFilter() {
		@Override
		public boolean accept(File file) {
			boolean isretorno = file.getName().contains("Calibration.log") && (_LAST_CPY_DTHR < file.lastModified());
			
			return isretorno;
		}
	};
	
	public ArquivoMonitoradoTX(String urlDestino, ColetaFileType fileType) {
		super(urlDestino, fileType);
		carregaConfig();
	}
	
	private void carregaConfig() {
		// Carrega a partir de arquivo uma das diferentes formas de navegar em
		// pastas
		String locConfig = this.getUrlDestino() + "/" + "TXConfig.txt";
		File arq = new File(locConfig);
		if (arq.exists()) {
			BufferedReader br = null;
			String linha = "";
			try {
				br = new BufferedReader(new FileReader(locConfig));
				// A primeira linha tem a informacao necessaria
				linha = br.readLine();
				br.close();
				// Remove espacos e quebras de linha
				linha.replaceAll(" ", "");
				linha.replaceAll("\n", "");
				
				if (!linha.equals("") && linha.contains(";")) {
					String[] linhaVect = linha.split(";");
					if (linhaVect.length > 1)
						try {
							estruturaDiretorio = Integer.parseInt(linhaVect[1].trim());
						} catch (NumberFormatException e) {
							estruturaDiretorio = 0;
							log.error("Erro ao fazer parseInt do valor no arquivo de configuracao do Posto TX: "+e);
							e.printStackTrace();
						}
				}

			} catch (FileNotFoundException e) {
				log.error("Erro ao obter uma das diferentes formas de navegar em pastas: " + e);
				e.printStackTrace();
			} catch (IOException e) {
				log.error("Erro ao obter uma das diferentes formas de navegar em pastas: " + e);
				e.printStackTrace();
			} 
		} else {
			// Se o arquivo de configuracao nao existe, cria-se um default
			try {
				BufferedWriter brW = new BufferedWriter(new FileWriter(locConfig));
				String configDefault = "estruturaDiretorio ; 0";
				String stringASerInserida = configDefault.concat("\n");
				stringASerInserida = stringASerInserida.concat("estruturaDiretorio = 0 Ex: \\172.10.0.18\\81-017-162010a0b-archcom\\05\\31\\2017\\Calibration.log\n");
				stringASerInserida = stringASerInserida.concat("estruturaDiretorio = 1 Ex: \\172.10.0.18\\81-017-162010a0b-archcom\\05Apr17\\Calibration.log\n");
				brW.append(stringASerInserida );
				brW.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

	@Override
	protected void trataFiscalCustom(File dirOrFileOrigem, String destination) throws IOException {
		if (estruturaDiretorio == 0)
			estruturaDeDiretorios0(dirOrFileOrigem, destination);
	}
	
	
	/* Alessandre em 30-10-2017 o objetivo desse metodo eh encontrar os arquivos Calibration.log dentro de ate 3 niveis de diretorio a partir
	 * do diretorio definido em urlConexao. Entretanto, verificando a arvore de diretorios disponibilizada pelo Elton, detectei que o arquivo
	 * Calibration pode estar no 3o ou 4o nivel de diretorio.
	 */
	// Ex: \\172.10.0.18\81-017-162010a0b-archcom\05\31\2017\Calibration.log
	private void estruturaDeDiretorios0(File dirOrFileOrigem, String destination) throws IOException {
		File[] mesDirs = dirOrFileOrigem.listFiles(onlyDirectories);
		Arrays.sort(mesDirs, ordenaUltimaModificacaoDirAsc);
		for (File mesDir : mesDirs) {
			File[] diaDirs = mesDir.listFiles(onlyDirectories);
			Arrays.sort(diaDirs, ordenaUltimaModificacaoDirAsc);
			for (File diaDir : diaDirs) {
				File[] anoDirs = diaDir.listFiles(onlyDirectories);
				Arrays.sort(anoDirs, ordenaAlfabeticaAsc);
				for (File anoDir : anoDirs) {
					File[] calibrationFiles = anoDir.listFiles(onlyNewCalibrationLogs);
					if (calibrationFiles.length == 1) {
						log.info("COPIADO - ArquivoCalibration(" + calibrationFiles[0].toPath() + ") encontrado. Modificado as " + calibrationFiles[0].lastModified());
						Files.copy(calibrationFiles[0].toPath(), getPathComSufixo(destination, ".txt"), StandardCopyOption.REPLACE_EXISTING);
						return;
					}
					
					/* Alessandre em 31-10-17 em algumas situacoes o diretorio MES não existe, mas sim um diretorio com o nome do programa
					 * e esse programa é que tem o diretorio MES. Entao se nao tiver o arquivo desejado entao pegar outro dir
					 * 
					 */
					if (calibrationFiles.length == 0) {
						File[] anoDirs2 = diaDir.listFiles(onlyDirectories);
						Arrays.sort(anoDirs2, ordenaAlfabeticaAsc);
						for (File anoDir2 : anoDirs) {
							File[] calibrationFiles2 = anoDir2.listFiles(onlyNewCalibrationLogs);
							if (calibrationFiles2.length == 1) {
								log.info("COPIADO - ArquivoCalibration(" + calibrationFiles2[0].toPath() + ") encontrado. Modificado as " + calibrationFiles2[0].lastModified());
								Files.copy(calibrationFiles2[0].toPath(), getPathComSufixo(destination, ".txt"), StandardCopyOption.REPLACE_EXISTING);
								return;
							}
						}
					}
				}
			}
		}
	}
}
