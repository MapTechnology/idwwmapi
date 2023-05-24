package idw.util;

public class ThreadUtil {

	public static void pausaNaThread(long milisegundos){
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
		}
	}
	
	public static String truncaString(String dado,int limite){
		if(dado.length()>limite)
			return dado.substring(0,limite);
		return dado;
	}
}
