package idw.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compress {
	static final int TAMANHO_BUFFER = 2048; // 2kb

	public static void main (String[] args){
		Compress.compactar("C:/alessandre/temporario/", "exportaexcel", ".csv", "c:/alessandre/temporario/exportaexcel.zip");
		
	}
	public static void compactar(String caminho, String padraoArquivos, String extensao, String arqSaida) {
		int i, cont;
		// Contadores.

		byte[] dados = new byte[TAMANHO_BUFFER];
		// Este array receberá os bytes lidos do arquivo a ser compactado.
		// Veja que TAMANHO_BUFFER foi declarado como uma constante inteira de
		// valor 2048, logo, o arquivo
		// será lido de 2 em 2 KB. Você pode optar por ler blocos maiores ou
		// menores, sem problema.

		String arquivos[];
		// Receberá a lista dos arquivos a serem compactados.

		File f = null;
		// f nos dará informações sobre a pasta (entrada) em que se encontra a
		// classe.
		BufferedInputStream origem = null;
		FileInputStream streamDeEntrada = null;
		FileOutputStream destino = null;
		// Streams de entrada e saída. (Vide documentação do pacote java.io)

		ZipOutputStream saida = null;
		// saida será usada para gravar nossos dados de forma comprimida.

		ZipEntry entry = null;
		// Cada entrada do nosso arquivo ZIP

		try {
			destino = new FileOutputStream(arqSaida);
			saida = new ZipOutputStream(new BufferedOutputStream(destino));
			f = new File(caminho); // Todos os arquivos da pasta onde a classe está
			
			arquivos = f.list(new FiltroArquivo(padraoArquivos, extensao));

			if (arquivos != null) {
				for (i = 0; i < arquivos.length; i++) {
					File arquivo = new File(caminho + arquivos[i]);
	
					if (arquivo.isFile() && !(arquivo.getName()).equals(arqSaida)) {
						streamDeEntrada = new FileInputStream(arquivo);
						origem = new BufferedInputStream(streamDeEntrada,
								TAMANHO_BUFFER);
						entry = new ZipEntry(arquivos[i]);
						saida.putNextEntry(entry);
	
						while ((cont = origem.read(dados, 0, TAMANHO_BUFFER)) != -1) {
							saida.write(dados, 0, cont);
						}
	
						origem.close();
					}
				}
			}
			saida.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		f = null;
		saida = null;
		arquivos = null;
		
	}// fim compactar()

	public static void gzipFile(String from, String to) throws IOException {
		FileInputStream in = new FileInputStream(from);
		GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(to));
		byte[] buffer = new byte[4096];
		int bytesRead;
		while ((bytesRead = in.read(buffer)) != -1)
			out.write(buffer, 0, bytesRead);
		in.close();
		out.close();
	}

	/** Zip the contents of the directory, and save it in the zipfile */
	public static void zipDirectory(String dir, String zipfile)
			throws IOException, IllegalArgumentException {
		// Check that the directory is a directory, and get its contents
		File d = new File(dir);
		if (!d.isDirectory())
			throw new IllegalArgumentException("Not a directory:  " + dir);
		String[] entries = d.list();
		byte[] buffer = new byte[4096]; // Create a buffer for copying
		int bytesRead;

		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));

		for (int i = 0; i < entries.length; i++) {
			File f = new File(d, entries[i]);
			if (f.isDirectory())
				continue;// Ignore directory
			FileInputStream in = new FileInputStream(f); // Stream to read file
			ZipEntry entry = new ZipEntry(f.getPath()); // Make a ZipEntry
			out.putNextEntry(entry); // Store entry
			while ((bytesRead = in.read(buffer)) != -1)
				out.write(buffer, 0, bytesRead);
			in.close();
		}
		out.close();
	}
	public static void compactar(List<String> listaArquivos, String arqSaida) {
		int i, cont;
		// Contadores.

		byte[] dados = new byte[TAMANHO_BUFFER];
		// Este array receberá os bytes lidos do arquivo a ser compactado.
		// Veja que TAMANHO_BUFFER foi declarado como uma constante inteira de
		// valor 2048, logo, o arquivo
		// será lido de 2 em 2 KB. Você pode optar por ler blocos maiores ou
		// menores, sem problema.

		File f = null;
		// f nos dará informações sobre a pasta (entrada) em que se encontra a
		// classe.
		BufferedInputStream origem = null;
		FileInputStream streamDeEntrada = null;
		FileOutputStream destino = null;
		// Streams de entrada e saída. (Vide documentação do pacote java.io)

		ZipOutputStream saida = null;
		// saida será usada para gravar nossos dados de forma comprimida.

		ZipEntry entry = null;
		// Cada entrada do nosso arquivo ZIP

		try {
			destino = new FileOutputStream(arqSaida);
			saida = new ZipOutputStream(new BufferedOutputStream(destino));
			
			if (listaArquivos != null) {
				for (i = 0; i < listaArquivos.size(); i++) {
					File arquivo = new File(listaArquivos.get(i));
	
					if (arquivo.isFile() && !(arquivo.getName()).equals(arqSaida)) {
						streamDeEntrada = new FileInputStream(arquivo);
						origem = new BufferedInputStream(streamDeEntrada,TAMANHO_BUFFER);
						entry = new ZipEntry(arquivo.getName()); // aqui usar apenas o nome
						saida.putNextEntry(entry);

						while ((cont = origem.read(dados, 0, TAMANHO_BUFFER)) != -1) {
							saida.write(dados, 0, cont);
						}
	
						origem.close();
					}
				}
			}
			saida.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		f = null;
		saida = null;
		
	}// fim compactar()
}

class FiltroArquivo implements FilenameFilter {

	private String extensao;
	private String inicio;
	
	public FiltroArquivo(String inicio, String extensao){
		this.inicio = inicio;
		this.extensao = extensao;
	}
	
	@Override
	public boolean accept(File arg0, String nome) {
		return nome.endsWith(extensao) && nome.startsWith(inicio);
	}
	
}