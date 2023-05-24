package idw.model.rn.integracao.semptoshiba.trilha;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public final class ArquivoTrilhaUtils {

	public static ArquivoTrilhaDTO getArquivoTrilhaDTO(ArquivoTrilha arquivoTrilha){
		StringBuilder sb = new StringBuilder();
		sb.append(arquivoTrilha.getHeader());
		sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);
		sb.append(arquivoTrilha.getBody());
		return new ArquivoTrilhaDTO("/" + arquivoTrilha.getFileName(), sb.toString());
	}
	
	public static  String gerarLinha(String... campos){
		
		StringBuilder sb = new StringBuilder();
		for(String campo: campos){
			if(sb.length() != 0){
				sb.append(ArquivoTrilhaUtils.SEPARADOR_CAMPO);
			}
			sb.append(ArquivoTrilhaUtils.DELIMITADOR_CAMPO);
			sb.append(campo);
			sb.append(ArquivoTrilhaUtils.DELIMITADOR_CAMPO);
			
		}
		
		return sb.toString();
		
	}
	
	/**
	 * Formata um <tt>Double<tt> para duas casas decimais: <tt>0.00</tt>
	 * @param decimal
	 * @return <tt>String</tt>
	 */
	public static  String formataDecimal(Double decimal) {
		if (decimal == null)
			return "0.00";
		
		DecimalFormat df = new DecimalFormat("0.00");
		String decimalFormatado = null;
		try {
			decimalFormatado = df.format(decimal).toString();
		} catch (IllegalArgumentException e){
			e.printStackTrace();
		}
		decimalFormatado = decimalFormatado.replace(".", ",");
		return decimalFormatado;
	}
	public static  String formataDecimal(BigDecimal decimal) {
		if (decimal == null)
			return "0.00";
		
		DecimalFormat df = new DecimalFormat("0.00");
		String decimalFormatado = null;
		try {
			decimalFormatado = df.format(decimal).toString();
		} catch (IllegalArgumentException e){
			e.printStackTrace();
		}
		decimalFormatado = decimalFormatado.replace(".", ",");
		return decimalFormatado;
	}

	public static String formataBigDecimal(BigDecimal decimal, int casasDecimais) {
		String str = decimal.setScale(casasDecimais, BigDecimal.ROUND_FLOOR).toString();
		str = str.replace(".", ",");
		return str;
	}
	
	public static String formatarRegistro(String string) {
		string = string.replace("\"", "");
		string = string.replace("'", "");
		return string;
	}

	public static String formataBigDecimal(BigDecimal decimal) {
		return formataBigDecimal(decimal, 2);
	}

	public static final String SEM_VALOR = "-1";
	public static final String LINHA_EM_BRANCO = System.getProperty("line.separator");
	public static final String DELIMITADOR_CAMPO = "\"";
	public static final String SEPARADOR_CAMPO = ";";
	
}
