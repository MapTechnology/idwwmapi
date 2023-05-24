package ms.coleta.ic.drivercoleta;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;

public class ArquivoMonitorado24G5G extends ArquivoMonitorado {

	private FileFilter onlyNewPassOrFailCsv = new FileFilter() {
		@Override
		public boolean accept(File file) {
			String name = file.getName();
			
			log.info("_LAST_CPY_DTHR("+_LAST_CPY_DTHR +") < file.lastModified("+file.lastModified()+") = " + (_LAST_CPY_DTHR < file.lastModified()));
			return (name.endsWith("_PASS.csv") || name.endsWith("_FAIL.csv")) && (_LAST_CPY_DTHR < file.lastModified());
		}
	};
	
	private FileFilter onlyNewDirectoriesPassOrFail = new FileFilter() {
		@Override
		public boolean accept(File file) {
			String name = file.getName();
			if (file.isDirectory() == false)
				return false;
			long ultimaModificacao = folderLastModified(file);
			boolean isAceitar = file.isDirectory() && (name.endsWith("_PASS") || name.endsWith("_FAIL")) && (_LAST_CPY_DTHR < ultimaModificacao);
			
			return isAceitar;
		}
	};
	
	public ArquivoMonitorado24G5G(String urlDestino, ColetaFileType fileType) {
		super(urlDestino, fileType);
	}
	
	@Override
	protected void trataFiscalCustom(File dirOrFileOrigem, String destination) throws IOException {
		
		// Estrutura antiga : \\100.100.100.21\11ac_gpt-2541gnac_hgu_5g
		//Arquivos ficam na mesma pasta, na pasta raiz definida em dirOrFileOrigem
		//Deve-se copiar o arquivo modificado mais recentemente.
		//Copiar com o nome com a Data e Hora para poder ser ordenado e tratado na ordem cronologica.
		
		// Estrutura nova: \\100.100.100.21\d\11AC_GPT-2541GNAC_HGU_5G
		File[] dirOrigem = dirOrFileOrigem.listFiles(onlyDirectories);
		
		List<File> recentDirs = new ArrayList<File>();	
	
		for (File dir : dirOrigem)
		{
			recentDirs.add(dir);
		}
		
		Collections.sort(recentDirs, ordenaUltimaModificacaoDesc);
		
		
		File dirOrFileOrigemLvl2 = recentDirs.get(0);
		
		
		File[] dirChildren = dirOrFileOrigemLvl2.listFiles(onlyNewDirectoriesPassOrFail);
		
		/* Alessandre em 01-11-17 se nao encontrou nenhum dir pode ser que os arquivos csv estejam no 1o dir
		 * isso acontece no 24G, entao eh necessário procurar as ocorrencias de .csv
		 */
		boolean isPossuiSubdiretorios = true;
		if (dirChildren == null || dirChildren.length == 0) {
			
			dirChildren = dirOrFileOrigemLvl2.listFiles(onlyNewPassOrFailCsv);
			isPossuiSubdiretorios = false;
		}

		if(dirChildren != null && dirChildren.length > 0) {
			List<File> passOrFailFiles = new ArrayList<File>();
			if (isPossuiSubdiretorios) {
				for (File dir : dirChildren)
				{
					File[] dirFiles = dir.listFiles(onlyNewPassOrFailCsv);
					passOrFailFiles.addAll(Arrays.asList(dirFiles));
				}
			} else {
				passOrFailFiles.addAll(Arrays.asList(dirChildren));
			}
			
			//Caso seja a primeira vez, copiar o mais recente e tratar apenas ele.
			//Caso nao seja a primeira vez, copiar do modificado mais anteriormente até o atual, para manter a ordem cronologica.
			if(_LAST_CPY_DTHR == 0)
				Collections.sort(passOrFailFiles, ordenaUltimaModificacaoDesc);
			else
				Collections.sort(passOrFailFiles, ordenaUltimaModificacaoAsc);
			for (File file : passOrFailFiles)
			{
				if(file.getName().endsWith("_PASS.csv")){
					
					log.info("COPIADO - ArquivoFilho("+file.getName()+") encontrado. Modificado as "+ file.lastModified());
					Files.copy(file.toPath(), getPathComSufixo(destination, "_PASS.csv"), StandardCopyOption.REPLACE_EXISTING);
				}
				if(file.getName().endsWith("_FAIL.csv")){
					
					log.info("COPIADO - ArquivoFilho("+file.getName()+") encontrado. Modificado as "+ file.lastModified());
					Files.copy(file.toPath(), getPathComSufixo(destination, "_FAIL.csv"), StandardCopyOption.REPLACE_EXISTING);
				}
				if(_LAST_CPY_DTHR == 0)
					break;
			}
		}
	}

}
