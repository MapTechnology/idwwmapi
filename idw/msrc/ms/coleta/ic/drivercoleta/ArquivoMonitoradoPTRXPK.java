package ms.coleta.ic.drivercoleta;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Date;

import idw.model.rn.DataHoraRN;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;

public class ArquivoMonitoradoPTRXPK extends ArquivoMonitorado {

	public ArquivoMonitoradoPTRXPK(String urlDestino, ColetaFileType fileType) {
		super(urlDestino, fileType);
	}

	@Override
	protected void trataFiscalCustom(File dirOrFileOrigem, String destination) throws IOException {
		//Arquivos ficam na mesma pasta, na pasta raiz definida em dirOrFileOrigem
		//Deve-se copiar o arquivo modificado mais recentemente.
		//Copiar com o nome com a Data e Hora para poder ser ordenado e tratado na ordem cronologica.
		
		log.info(idLog, 0, "Obtendo lista de arquivo do diretorio " + dirOrFileOrigem.getName());
		File[] fileChildren = dirOrFileOrigem.listFiles(onlyNewFiles);
		if(fileChildren != null && fileChildren.length > 0) {
			log.info(idLog, 0, "Encontrou " + fileChildren.length);
			Arrays.sort(fileChildren, ordenaUltimaModificacaoDesc);
			
			for (File fileChild : fileChildren)
			{
				log.info(idLog, 0, "Avaliando " + fileChild.getName());
				
				if(!fileChild.isDirectory()) {
					log.info("Copiando ArquivoFilho("+fileChild.getName()+") modificado em " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(new Date(fileChild.lastModified())) + " para " + destination);
	
					Files.copy(fileChild.toPath(), getPathComSufixo(destination, ".txt"), StandardCopyOption.REPLACE_EXISTING);
					if(_LAST_CPY_DTHR == 0)
						break;
				} else {
					log.info("IGNORADO DIR - "+fileChild.getName());
				}
			}
		} else {
			log.info(idLog, 0, "Nenhum arquivo encontrado em " + dirOrFileOrigem.getName());
		}
	}
}
