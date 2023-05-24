package injetws.model.rn;

import idw.model.IdwFacade;

public class UtilRN {
	
	public final static int TEMPO_MEDIO_TRATRAMENTO_BC =250; // tempo m�dio de tratamento do BC
	public static String setZeroEsquerda(String sCod)
	{		
		return(getCodigoPadraoInjet(sCod));
	}

	public static String getCodigoPadraoInjet(String codigo){
		//adicionado para não utilizar o padrão de códgio injet com o IDW
		//Marcos Sardinha: VFWEB - Injet
		if(IdwFacade.IS_IDW_ATIVO){
			return codigo;
		}
		String retorno = "";
		
		// Acrescentei o if abaixo para evitar o null pointer q estava acontecendo
		if (codigo == null)
			return retorno;
				
		for (int contador = codigo.length(); contador <= 5 ; contador++){
			retorno += "0";
		}
		retorno += codigo;
		return retorno;
	}

	/* Repete uma string n vezes */
	public static String repeat(String str, int times){
		   StringBuilder ret = new StringBuilder();
		   for(int i = 0;i < times;i++) ret.append(str);
		   return ret.toString();
	}
	
	public static void pausaNaThread(long milisegundos){
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
		}
	}
}
