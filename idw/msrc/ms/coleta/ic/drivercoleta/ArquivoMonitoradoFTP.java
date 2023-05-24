package ms.coleta.ic.drivercoleta;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;

public class ArquivoMonitoradoFTP  extends ArquivoMonitorado {
	
	public ArquivoMonitoradoFTP(String urlDestino, ColetaFileType fileType) {
		super(urlDestino, fileType);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void trataFiscalCustom(File dirOrFileOrigem, String destination) throws IOException {
		File[] fileChildren = dirOrFileOrigem.listFiles();
		if(fileChildren != null && fileChildren.length > 0) {
			Arrays.sort(fileChildren, ordenaUltimaModificacaoDesc);
			
			for (File fileChild : fileChildren)
			{
				if(!fileChild.isDirectory())
				{
					log.info("COPIADO - ArquivoFilho("+fileChild.getName()+") encontrado. Modificado as "+ fileChild.lastModified());

					Files.copy(fileChild.toPath(), getPathComSufixo(destination, ".txt"), StandardCopyOption.REPLACE_EXISTING);
					//if(_LAST_CPY_DTHR == 0)
						break;
				}
			}
		}
	}
}