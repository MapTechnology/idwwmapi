package idw.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public final class UtilsString {
	private UtilsString(){
	}
	
	public static String removeCarecteresInvalidosDeNomeDeArquivo(String nomearquivo){
		//Replace by _
		try{
			nomearquivo=nomearquivo.replace('\\','_');
			nomearquivo=nomearquivo.replace('/','_');
			nomearquivo=nomearquivo.replace(':','_');
			nomearquivo=nomearquivo.replace('\"','_');
			nomearquivo=nomearquivo.replace('?','_');
			nomearquivo=nomearquivo.replace('<','_');
			nomearquivo=nomearquivo.replace('>','_');
			nomearquivo=nomearquivo.replace('|','_');
		}catch (Exception e){
			e.printStackTrace();
		}
		return nomearquivo;
	}

	/** Repete uma string n vezes
	 * @deprecated usar StringUtils do common apache lang
	 * @see org.apache.commons.lang3.StringUtils#repeat(String, int)
	 * */

	@Deprecated
	public static String repeat(String str, int times){
		   StringBuilder ret = new StringBuilder();
		   for(int i = 0;i < times;i++) {
			ret.append(str);
		}
		   return ret.toString();
	}

	/**
	 * Retorna em string os itens da lista concatenados
	 * @param list
	 * @param separator - separador que ser� usado entre cada item da lista
	 * @return
	 * @deprecated usar StringUtils do common apache lang
	 * @see org.apache.commons.lang3.StringUtils#join(java.util.Iterator, String)
	 */
	@Deprecated
	public static String convertToString(List<?> list, String separator){
		StringBuilder str = new StringBuilder();
		if((list != null) && (list.size() > 0)){
			boolean isFirst = true;
			for(Object item: list){
				if(!isFirst){
					str.append(separator);
				}
				str.append(item);
				isFirst = false;
			}
		}
		return str.toString();
	}

	public static String getZerosAEsquerda(String valor, int tam) {
		return StringUtils.repeat("0", tam - valor.length())  + valor;
	}
	public static List<String> quebrarStringEmVetor(String valor, String caracterRef) {
		List<String> retorno = new ArrayList<String>();
		if (valor == null)
			return retorno;
		
		int localizador = valor.indexOf(caracterRef);
		if (localizador >= 0) {
			retorno.add(valor.substring(0, localizador) );
			valor = valor.substring(localizador + 1);
			retorno.addAll(quebrarStringEmVetor(valor, caracterRef));
		} else {
			retorno.add(valor);
		}
		return retorno;
	}
    public static String removeCaracteresDeCampos(String valor) {
        valor = valor.replaceAll("\"", "");
        return valor.trim();
    }

	// Substitui caracteres nao alfa-numericos por espacos
    public static List<String> removeCaracteresEspeciaisListString (List<String> in) {
    	List<String> retorno = new ArrayList<String>();
    	for (String elemento : in) {
    		retorno.add (elemento.replaceAll("[^a-zA-Z0-9]+", " "));
    	}
    	return retorno;
    }
    
 // Substitui caracteres nao alfa-numericos por espacos
    public static String removeCaracteresEspeciaisListString (String in) {
    	String retorno = null;
    	try {
			retorno = in.replaceAll("[^a-zA-Z0-9]+", " ");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return retorno;
    }
    
    public static String removerUltimoCaracter(String str) {
        return str.substring(0, str.length() - 1);
    }
    
	/* Verifica se o ns está no padrão definido pela mascara */
	public static boolean isConformeMascara(String ns, String mascara) {
		boolean isretorno = true;

		if (mascara.length() > ns.length())
			return false;

		for (int i = 0; i < mascara.length(); i++) {
			if (mascara.charAt(i) != '?' && mascara.charAt(i) != ns.charAt(i)) {
				isretorno = false;
				break;
			}
		}

		return isretorno;
	}
	
	public static String removeZerosEsquerda(String valor) {
		StringBuilder retorno = new StringBuilder();
		for (int i=0; i < valor.length(); i++) {
			if (valor.charAt(i) != '0') {
				retorno.append(valor.substring(i));
				break;
			}
		}
		return retorno.toString();
	}

	public static void main(String[] args) {
		String a = "100,LINHA 1,2015-07-20 14:35:17.437,31,,201500020-00000002,07";
		List<String> ret = UtilsString.quebrarStringEmVetor(a, ",");
		int i = 0;
		for (String reto : ret) {
			System.out.println(i + " - " + reto);
			i++;
		}
		
		
		System.out.println("000007 = " + UtilsString.removeZerosEsquerda("000007"));
		
	}
}
