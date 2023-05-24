package ms.coleta.ic.automata;

import idw.model.rn.DataHoraRN;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class CopiaArquivoFTP {
	
	private ArquivoTXT txt;
	private Date dataDoUltimoArquivoLido;
	
	private String servidor;
	private String usuario;
	private String senha;
	private String pasta;	
	
	private String arquivoASerCopiado = null;
	private String pastaDestino;
	
	private List<String> arquivosCopiados;
	
	public CopiaArquivoFTP(String urlConexao, String arquivoASerCopiado, String pastaDestino) {
		lerUrl(urlConexao);
		this.arquivoASerCopiado = arquivoASerCopiado;
		this.pastaDestino = pastaDestino;		
	}
	
	public CopiaArquivoFTP(ArquivoTXT txt, String urlConexao, String pastaDestino) {
		this.txt = txt;
		lerUrl(urlConexao);
		this.pastaDestino = pastaDestino;		
	}
	
	// PADRAO: ftp://usuario:senha@servidor/pasta
	private void lerUrl(String url) {
		//removendo "ftp://"
		url = url.substring(6);
		
		//lendo usuario
		int tamanhoUsuario = url.indexOf(":");
		usuario = url.substring(0, tamanhoUsuario);		
		url = url.substring(tamanhoUsuario+1);
		
		//lendo senha		
		int tamanhoSenha = url.indexOf("@");
		senha = url.substring(0, tamanhoSenha);		
		url = url.substring(tamanhoSenha+1);
		
		//lendo servidor
		int tamanhoServidor = url.indexOf("/");
		servidor = url.substring(0, tamanhoServidor);
		url = url.substring(tamanhoServidor+1);
		
		//lendo pasta
		pasta = url;
	}
	
	public void copiarArquivo() throws SocketException, IOException {
		//realizando a conexao com o servidor
		FTPClient ftp = new FTPClient();
		ftp.connect(servidor);
		ftp.login(usuario, senha);
		
		if(arquivoASerCopiado == null) {
			dataDoUltimoArquivoLido = converterParaDate(txt.getUltimoArquivoLido());
		}		
		arquivosCopiados = new ArrayList<String>();
		
		//buscando o arquivo a ser copiado
		ftp.changeWorkingDirectory(pasta);
		FTPFile[] files = ftp.listFiles();
		for (int i = 0; i < files.length; i++) {
			
			if(files[i].isDirectory() == false) {
				
				String nomeArquivo = files[i].getName();
				
				if(arquivoASerCopiado != null) {
					//copia um arquivo especifico.
					if(nomeArquivo.equals(arquivoASerCopiado)) {
						copiar(ftp, nomeArquivo);
						break;
					}
					
				} else {
					//copia todos os arquivos validos da pasta
					if(podeCopiarArquivo(nomeArquivo)) {
						copiar(ftp, nomeArquivo);
					}
				}
				
			}
			
		}

		ftp.logout();
		ftp.disconnect();
	}
	
	private void copiar(FTPClient ftp, String nomeArquivo) throws IOException {
		File file = new File(pastaDestino + File.separator + nomeArquivo);
		FileOutputStream fos = new FileOutputStream(file);
		ftp.retrieveFile(nomeArquivo, fos);
		fos.close();
		
		arquivosCopiados.add(nomeArquivo);
	}
	
	private boolean podeCopiarArquivo(String nomeArquivo) {
		
		if(nomeArquivo.endsWith(ArquivoAutomata.EXTENSAO_ARQUIVO_ACEITO) == false) {
			return false;
		}
		
		if(dataDoUltimoArquivoLido == null) {
			//nenhum arquivo foi lido
			return true;
		}
		
		//so deve copiar os arquivos que possuem a data maior ou igual a 
		//data do ultimo arquivo lido.
		Date dataDoArquivo = converterParaDate(nomeArquivo);		
		long diferencaTempo = dataDoUltimoArquivoLido.getTime() - dataDoArquivo.getTime();
		if(diferencaTempo > 0L) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * @param "Injet 2017-03-29.csv"
	 * @return Date;
	 */
	private Date converterParaDate(String nomeArquivo) {
		if(nomeArquivo == null) {
			return null;
		}
		
		String padrao = "yyyy-MM-dd";
		
		String data = nomeArquivo.replace("Injet ", "");
		data = data.replace(".csv", "");
		
		Date dataRetorno = null;
		
		try {
			dataRetorno = DataHoraRN.toDateFrom(padrao, data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dataRetorno;
	}

	public List<String> getArquivosCopiados() {
		return arquivosCopiados;
	}
}
