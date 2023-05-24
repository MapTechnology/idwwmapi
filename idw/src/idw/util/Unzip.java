package idw.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Unzip {
	public static final void copyInputStream(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[1024];
		int len;
		while ((len = in.read(buffer)) >= 0)
			out.write(buffer, 0, len);
		in.close();
		out.close();
	}

	public static final void unzip(String arq, String dirDestino, IdwLogger log) {
		Enumeration entries;
		ZipFile zipFile;
		log.info("Descompactando " + arq + " em " + dirDestino);
		ArquivosDiretorios.criarDiretorioSeNaoexistir(dirDestino);
		try {
			zipFile = new ZipFile(arq);
			entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = (ZipEntry) entries.nextElement();
				if (entry.isDirectory()) {
					log.info("Extraindo diretório: " + dirDestino + entry.getName());
					(new File(dirDestino + entry.getName())).mkdir();
					continue;
				}
				log.info("Extraindo para arquivo " + dirDestino + entry.getName());
				copyInputStream(
						zipFile.getInputStream(entry),
						new BufferedOutputStream(new FileOutputStream(dirDestino + entry.getName())));
			}
			zipFile.close();
		} catch (IOException ioe) {
			log.info("Erro ao extrair:" + ioe.getMessage());
			return;
		}
	}
}
