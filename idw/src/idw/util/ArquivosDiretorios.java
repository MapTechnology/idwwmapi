package idw.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import jcifs.CIFSContext;
import jcifs.SmbResource;
import jcifs.context.SingletonContext;
import jcifs.smb.NtlmPasswordAuthenticator;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import ms.model.dto.IcUpDTO;



public class ArquivosDiretorios {

	public static void main(String[] args) {
		String[] arqs = ArquivosDiretorios.getArquivosNoDiretorio("C:/lixo");
		if (arqs != null) {
			for (String arq : arqs) {
				System.out.println("arq=" + arq);
			}
		} else
			System.out.println("dir null");
	}
	public static String[] getArquivosNoDiretorio(String diretorio){
		File dir = new File(diretorio); 
		String[] children = dir.list();
		return children;
	}

	public static String[] getArquivosNoDiretorio(String diretorio, String login, String senha){
		String url = ajustaPathSMB(diretorio); 
		if (!url.endsWith("/"))
			url = url + "/";
		//NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null, login, senha);
		// Ailton 2019-06-27: atualizacao do jcifs para jcifs-ng
		// NtlmPasswordAuthenticator auth = new NtlmPasswordAuthenticator(null, login, senha);
		NtlmPasswordAuthenticator auth = new NtlmPasswordAuthenticator(login, senha);
		SmbFile dir;
		
		String[] retorno;
		try {
			//dir = new SmbFile(url, auth);
			// Ailton 2019-06-27: atualizacao do jcifs para jcifs-ng
			CIFSContext base = SingletonContext.getInstance();
			CIFSContext authed1 = base.withCredentials(auth);
			dir = new SmbFile(url, authed1);
			
			retorno = dir.list();
		} catch (MalformedURLException e) {
			return null;
		} catch (SmbException e) {
			e.printStackTrace();
			return null;
		}
		return retorno;
	}

	public static String getCaminhoDiretorio(String diretorio){
		File dir = new File(diretorio); 
		return dir.getParent();
	}

	public static void criarDiretorioSeNaoexistir(String dir) {
		File fdir = new File(dir);
		fdir.mkdirs();
	}

	public static boolean delete(String fileName) {
		// A File object to represent the filename
		File f = new File(fileName);

		// Make sure the file or directory exists and isn't write protected
		if (!f.exists())
			return false;
		
		if (!f.canWrite())
			return false;
		
		// If it is a directory, make sure it is empty
		if (f.isDirectory()) {
			String[] files = f.list();
			if (files !=null) {
				for (String c : files)
					delete(fileName + "/" + c);
			}
		}

		// Attempt to delete it
		boolean success = f.delete();

		if (!success)
			return false;
		
		return true;
	}
	
	
	public static boolean isExisteArquivo(String patharquivo) {
		File arq = new File(patharquivo);
		return arq.exists();
	}
	
	public static boolean isExisteArquivoSMB(String patharquivo, String login, String senha) {
		if (patharquivo.contains("smb:")) {
			NtlmPasswordAuthenticator auth = new NtlmPasswordAuthenticator(login, senha);
			SmbFile dir;
			
			try {
				//dir = new SmbFile(patharquivo, auth);
				// Ailton 2019-06-27: atualizacao do jcifs para jcifs-ng
				CIFSContext base = SingletonContext.getInstance();
				CIFSContext authed1 = base.withCredentials(auth);
				dir = new SmbFile(patharquivo, authed1);
				
				return dir.exists();
			} catch (MalformedURLException e) {
				return false;
			} catch (SmbException e) {
				return false;
			}
		}
		File arq = new File(patharquivo);
		return arq.exists();
	}
	
	public static boolean isDiretorio(String patharquivo) {
		File arq = new File(patharquivo);
		return arq.isDirectory();
	}
	public static boolean isDiretorio(String patharquivo, String login, String senha) {
		if (patharquivo.contains("smb:")) {
			// NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null, login, senha);
			// Ailton 2019-06-27: atualizacao do jcifs para jcifs-ng
			//NtlmPasswordAuthenticator auth = new NtlmPasswordAuthenticator(null, login, senha);
			NtlmPasswordAuthenticator auth = new NtlmPasswordAuthenticator(login, senha);
			SmbFile dir = null;
			
			try {
				//dir = new SmbFile(patharquivo, auth);
				// Ailton 2019-06-27: atualizacao do jcifs para jcifs-ng
				CIFSContext base = SingletonContext.getInstance();
				CIFSContext authed1 = base.withCredentials(auth);
				dir = new SmbFile(patharquivo, authed1);
				
				return (dir.isDirectory() && dir.exists());
			} catch (MalformedURLException e) {
				return false;
			} catch (SmbException e) {
				return false;
			} catch (Exception e) {
				return false;
			}
		}
		File arq = new File(patharquivo);
		return arq.isDirectory();
	}
	
	public static boolean renameFile(String antigo, String novo,boolean deveSobrescrever) {
		File file = new File(antigo);

	    // File (or directory) with new name
	    File file2 = new File(novo);
	    if(file2.exists()){
	    	if(deveSobrescrever==true){
	    		if(file2.delete()==false){
	    			return false;
	    		}  		
	    	}else{
	    		return false;
	    	}
	    }
	    // Rename file (or directory)
	    boolean success = file.renameTo(file2);
	    if (!success) {
	        return false;
	    }
	    return true;
	}
	
	public static Path renameFilePath(String antigo, String novo,boolean deveSobrescrever) {
		Path novoPath = Paths.get(novo);
		Path antigoPath = Paths.get(antigo);
	    // File (or directory) with new name
	    File file2 = new File(novo);
	    if(file2.exists()){
	    	if(deveSobrescrever==true){
	    		if(file2.delete()==false){
	    			return null;
	    		}  		
	    	}else{
	    		return null;
	    	}
	    }
	    // Rename file (or directory)
	    Path success;
		try {
			success = Files.move(antigoPath, novoPath);
		    return success;
		} catch (FileSystemException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static Date getDtHrModificacao(String arquivo) {
		Path novoPath = Paths.get(arquivo);
		BasicFileAttributes attr;
		Date retorno = null; 
		try {
			attr = Files.readAttributes(novoPath, BasicFileAttributes.class);
			retorno = new Date(attr.lastModifiedTime().to(TimeUnit.MILLISECONDS));
		} catch (IOException e) {
			retorno = new Date();
		}

		return retorno;
	}
	public static Date getDtHrModificacao(String arquivo, String login, String senha) {
		if (login == null || login.trim().equals("")) {
			return getDtHrModificacao(arquivo);
		}
		String url = ajustaPathSMB(arquivo);
		NtlmPasswordAuthenticator auth = new NtlmPasswordAuthenticator(login, senha);
		SmbFile dir;
		
		Date retorno;
		try {
			// dir = new SmbFile(url, auth);
			// Ailton 2019-06-27: atualizacao do jcifs para jcifs-ng
			CIFSContext base = SingletonContext.getInstance();
			CIFSContext authed1 = base.withCredentials(auth);
			dir = new SmbFile(url, authed1);
			
			retorno = new Date(dir.lastModified());
		} catch (MalformedURLException | SmbException e) {
			return null;
		}
		return retorno;
	}
	public static void copiarArquivoSMBToLocal(String origem, Path destino, String login, String senha) throws IOException {
		if (login != null && login.trim().equals("") == false && senha != null) {
			NtlmPasswordAuthenticator auth = new NtlmPasswordAuthenticator(login, senha);
			CIFSContext base = SingletonContext.getInstance();
			CIFSContext authed1 = base.withCredentials(auth);
			SmbFile smbOrigem = new SmbFile(origem, authed1);
			InputStream in = null;
			try {
				in = smbOrigem.getInputStream();
				Files.copy(in, destino, StandardCopyOption.REPLACE_EXISTING);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				in.close();
				smbOrigem.close();
			}
		}
	}
	
	public static void copiarArquivo(String origem, Path destino, String login, String senha) throws IOException {
		if (login != null && login.trim().equals("") == false && senha != null) {
			// Se a URL nao esta no formato, ajustar
			origem = ajustaPathSMB(origem);
			if (!destino.toString().contains("smb")) {
				copiarArquivoSMBToLocal(origem, destino,login, senha);
				return;
			}
			NtlmPasswordAuthenticator auth = new NtlmPasswordAuthenticator(login, senha);
			SmbFile smbOrigem;
			SmbFile smbDestino;
			try {
				CIFSContext base = SingletonContext.getInstance();
				CIFSContext authed1 = base.withCredentials(auth);
				smbOrigem = new SmbFile(origem, authed1);
				Files.copy(smbOrigem.getInputStream(), destino);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Files.copy(Paths.get(origem), destino, StandardCopyOption.REPLACE_EXISTING);
		}
	}
	
	public static String lerArquivo(String origem) throws IOException {
		Path pathOrigem = Paths.get(origem);
		String retorno = new String(Files.readAllBytes(pathOrigem));
		return retorno;
	}
	
	// O formato de urls das coletas padrões, sem AD e:
	// 		\\192.168.0.13\logs
	// Enquanto isso, quando existe o AD, o formato passa a ser:
	// 		smb://192.168.0.13/logs
	// Esse ajuste e feito abaixo
	public static String ajustaPathSMB(String diretorio) {
		String url = diretorio;
		if (url!= null && !url.contains("smb:")) {
			url = "smb:" + diretorio;
			url = url.replaceAll("\\\\", "/");
		}
		return url;
	}
	
	public static boolean isICUsaAD(IcUpDTO icup) {
		if ( icup!=null && icup.getIc()!=null
				&& icup.getIc().getIsAutenticacao() != null && icup.getIc().getIsAutenticacao()
				&& icup.getIc().getLoginAD()!=null
				&& icup.getIc().getSernhaAD() !=null) {
			return true;
		}
		return false;
	}
}
