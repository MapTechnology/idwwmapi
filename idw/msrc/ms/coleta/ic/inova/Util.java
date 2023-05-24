package ms.coleta.ic.inova;

import java.io.File;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Calendar;

import idw.util.IdwLogger;

public class Util {
	
	public static String[] PegaArgumentos(String Dado) {
		String texto = Dado;
		String[] matriz;
		try {
			matriz = texto.split(";");
			return matriz;
		} catch (Exception e) {
			matriz = new String[1];
			return matriz;
		}
	}
	
	public static FilenameFilter getFiltroArquivoExtensao(final String sArquivoFinal, final String sExt) {
		FilenameFilter oFiltroArquivo = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return(name.startsWith(sArquivoFinal.substring(0, 8) + sExt));
			}
		};
		
		return(oFiltroArquivo);
	}
	
	public static FilenameFilter getFiltroArquivoVersao(final String sArquivoFinal, final String sExt) {
		FilenameFilter oFiltroArquivo = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if(name.startsWith(sArquivoFinal.substring(0, 6))) {
					if(name.endsWith(sExt))
						return(true);
				}
				return(false);
			}
		};
		
		return(oFiltroArquivo);
	}
	
	public static void escreveArquivoLog(String nomeArquivo, Exception e, IdwLogger log, int idLog) {
		escreveArquivoLog(nomeArquivo, e, null, log, idLog);
	}
	
	
	public static void escreveArquivoLog(String nomeArquivo, Exception e, String sTexto, IdwLogger log, int idLog) {
		log.info(idLog, 0, nomeArquivo);
		log.info(idLog, 1, e.getMessage());
		log.info(idLog, 1, stack2string(e));
		log.info(idLog, 1, e.getCause().toString());
		log.info(idLog, 1, "---------------------");
		if(sTexto != null)
			log.info(idLog, 2, sTexto);
	}

	public static String stack2string(Exception e) {
		try {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			
			e.printStackTrace(pw);
			
			return sw.toString();
		} catch(Exception e2) {
			return "Erro pegando StackTrace";
		}
	}
	
	public static boolean getVerificaElapsedTime(Calendar dthrRef, int refTimeout) {
		try {
			Calendar dtNow = Calendar.getInstance();
			
//			TimeSpan ts = dtNow - dthrRef;
			Long ts = (dtNow.getTimeInMillis() / 1000) - (dthrRef.getTimeInMillis() / 1000);
			
			if(refTimeout > ts.intValue()) {
				return false;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public static double getTempoTranscorridoEmSegundos(Calendar dthrI, Calendar dthrF) {
//		TimeSpan ts = dthrF - dthrI;
		Long ts = (dthrF.getTimeInMillis() / 1000) - (dthrI.getTimeInMillis() / 1000);
		
		return ts;
	}
	
	
}
