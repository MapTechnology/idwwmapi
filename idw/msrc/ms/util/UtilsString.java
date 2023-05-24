package ms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class UtilsString {

	/* Repete uma string n vezes */
	public static String repeat(String str, int times) {
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < times; i++)
			ret.append(str);
		return ret.toString();
	}

	public static String getChave(String mensagem, String chave) {
		String mensagemTemp = "";
		if (mensagem != null && mensagem.indexOf(chave) >= 0) {
			mensagemTemp = mensagem.substring(mensagem.indexOf(chave));
			mensagemTemp = mensagemTemp
					.substring(mensagemTemp.indexOf("=") + 1);
			mensagemTemp = mensagemTemp.substring(0, mensagemTemp.indexOf("#"));
		}
		return mensagemTemp;
	}

	public static String getValorFromSecaoChave(String mensagem, String secao,
			String chave) {
		String mensagemTemp = "";
		String nSecao = "[" + secao + "]";
		if (mensagem != null && mensagem.indexOf(nSecao) >= 0) {
			mensagemTemp = mensagem.substring(mensagem.indexOf(nSecao));
			if (mensagemTemp.indexOf("[") > 0) {
				mensagemTemp = mensagemTemp.substring(0, mensagem.indexOf("["));
			}
			if (mensagemTemp.indexOf(chave) >= 0) {
				mensagemTemp = mensagemTemp.substring(mensagemTemp
						.indexOf(chave + "="));
				mensagemTemp = mensagemTemp
						.substring(mensagemTemp.indexOf("=") + 1);
				mensagemTemp = mensagemTemp.substring(0,
						mensagemTemp.indexOf("\n"));
			} else {
				mensagemTemp = "";
			}
		}
		return mensagemTemp;
	}

	public static String adicionaZero(String info, int tamanho) {
		for (int qtd = info.length(); info.length() < tamanho; qtd--) {
			info = "0" + info;
		}
		return info;
	}

	/**
	 * Remove as aspas Geralmente, aspas
	 * 
	 * @param valor
	 *            String a ser tratada
	 * @return String sem aspas
	 */
	public static String removeApas(String valor) {
		if (valor != null & !valor.equals("")) {
			return valor.replace("\"", "");
		}
		return "0";
	}

	/**
	 * Método que pega um vetor de strings e retorno uma string concatenada
	 * 
	 * @param linha
	 *            vetor a ser concatenado
	 * @return
	 */
	public static String uneString(String[] linha) {
		String retorno = "";
		for (String l : linha) {
			retorno = retorno.concat(l + " ");
		}
		return retorno;
	}

	/**
	 * Formato Origem: "2017/11/23 01:10:07" Formato Saida: "2017-12-13 12:25:32"
	 * 
	 * @param origem
	 * @return
	 */
	public static Date convertStringToDate(String origem) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;

		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			retorno = formato.parse(origem);
			formato.applyPattern(formatoSaida);

			String aux = formato.format(retorno);

			SimpleDateFormat formatSaida = new SimpleDateFormat(formatoSaida);
			retorno = formatSaida.parse(aux);
			return (retorno);
		} catch (Exception e) {
			retorno = convertToDateLogSonyWithoutDate(origem);
		}
		return retorno;
	}

	/**
	 * Formato Origem: "2018041815445373" Formato Intermediario: "20180418154453" Formato Saida: "2018-04-18 15:44:53"
	 * 
	 * @param origem
	 * @return
	 */
	public static Date convertToDateLogFujiFlex(String origem) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss.SSS");
		Date retorno = null;

		if (origem.length() < 16)
			return convertToDateLogSonyMDB(origem);
		// Truncando nos ms
		// String intermediario = origem.substring(0, 14);

		// Utilizando os ms
		String intermediario = origem;

		SimpleDateFormat formato = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		try {
			retorno = formato.parse(intermediario);
			formato.applyPattern(formatoSaida);

			String aux = formato.format(retorno);

			SimpleDateFormat formatSaida = new SimpleDateFormat(formatoSaida);
			retorno = formatSaida.parse(aux);
			return (retorno);
		} catch (Exception e) {
			retorno = convertToDateLogSonyWithoutDate(origem);
		}
		return retorno;
	}

	/**
	 * Formato Origem: "20171213122532" Formato Saida: "2017-12-13 12:25:32"
	 * 
	 * @param origem
	 * @return
	 */
	public static Date convertToDateLogSonyMDB(String origem) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;

		SimpleDateFormat formato = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			retorno = formato.parse(origem);
			formato.applyPattern(formatoSaida);

			String aux = formato.format(retorno);

			SimpleDateFormat formatSaida = new SimpleDateFormat(formatoSaida);
			retorno = formatSaida.parse(aux);
			return (retorno);
		} catch (Exception e) {
			retorno = convertToDateLogSonyWithoutDate(origem);
		}
		return retorno;
	}

	/**
	 * Formato Origem: "1/18/2017 1:25:32 AM" Formato Saida: "2016-11-30 09:31:33.768"
	 * 
	 * @param origem
	 * @return
	 */
	public static Date convertToDateLogFornosHeller(String origem) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;

		SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
		try {
			retorno = formato.parse(origem);
			formato.applyPattern(formatoSaida);

			String aux = formato.format(retorno);

			SimpleDateFormat formatSaida = new SimpleDateFormat(formatoSaida);
			retorno = formatSaida.parse(aux);
			return (retorno);
		} catch (Exception e) {
			retorno = convertToDateLogFornosHellerFormato2(origem);
		}
		return retorno;
	}

	/**
	 * Formato Origem: "24/1/2019 00:01:28" Formato Saida: "2016-11-30 09:31:33.768"
	 * 
	 * @param origem
	 * @return
	 */
	public static Date convertToDateLogFornosHellerFormato2(String origem) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			retorno = formato.parse(origem);
			formato.applyPattern(formatoSaida);

			String aux = formato.format(retorno);

			SimpleDateFormat formatSaida = new SimpleDateFormat(formatoSaida);
			retorno = formatSaida.parse(aux);
			return (retorno);
		} catch (Exception e) {
			retorno = null;
		}
		return retorno;
	}

	/**
	 * Formato Origem: "1/18/2017 1:25:32 AM" Formato Saida: "2016-11-30 09:31:33.768"
	 * 
	 * @param origem
	 * @return
	 */
	public static Date convertToDateLogSony(String origem) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;

		SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
		try {
			retorno = formato.parse(origem);
			formato.applyPattern(formatoSaida);

			String aux = formato.format(retorno);

			SimpleDateFormat formatSaida = new SimpleDateFormat(formatoSaida);
			retorno = formatSaida.parse(aux);
			return (retorno);
		} catch (Exception e) {
			retorno = convertToDateLogSonyWithoutDate(origem);
		}
		return retorno;
	}

	/**
	 * Formato Origem: "1/18/2017" Formato Saida: "2017-01-18 00:00:00"
	 * 
	 * @param origem
	 * @return
	 */
	public static Date convertToDateLogSonyWithoutDate(String origem) {
		String formatoSaida = ("yyyy-MM-dd");
		Date retorno = null;

		String origemSemEspacos = "";
		// Tentativa 1 de obter dados
		try {
			origemSemEspacos = origem.split(" ")[0];
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Tentativa 2 de obter dados
		if (origemSemEspacos == null || (origemSemEspacos != null && origemSemEspacos.equals(""))) {
			origemSemEspacos = origem.substring(0, 10);
		}

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		try {
			retorno = format.parse(origem);
			format.applyPattern(formatoSaida);

			String aux = format.format(retorno);

			SimpleDateFormat formatSaida = new SimpleDateFormat(formatoSaida);
			retorno = formatSaida.parse(aux);

			Calendar cal = Calendar.getInstance();
			cal.setTime(retorno);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			retorno = cal.getTime();

			return (retorno);

		} catch (Exception e) {
			retorno = convertToDateLogSony3oPadrao(origem);
		}
		return retorno;
	}

	/*
	 * Metodo criado pelo Alessandre em 11-07-2017 para tratar o 3o padrao de data e hora nos arquivos de log da Sony YYYYMMDDHHMISS
	 * 
	 */
	public static Date convertToDateLogSony3oPadrao(String origem) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyyMMddhhmmss");
		java.util.Date datum = null;
		try {
			datum = sim.parse(origem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datum;
	}

	/**
	 * Converte um string com valor de segundos para um objeto Date
	 * 
	 * @param seconds:
	 *            String com o valor em segundos
	 * @return Date
	 */
	public static Date convertSecondsToDate(String seconds) {
		Date retorno = null;
		if (seconds != null && !seconds.equals("")) {
			long millis = Long.valueOf(seconds) * 1000;
			if (millis > 0) {
				retorno = new Date(millis);
			}
		}

		return retorno;
	}

	/**
	 * Converte data do formato 20170124094712 Para o formato aceito pelo bd IDW Log DVD Sony
	 * 
	 * @return Date
	 */
	public static Date dateTimeStringToDate(String dateTimeString) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			retorno = format.parse(dateTimeString);
			format.applyPattern(formatoSaida);

			String aux = format.format(retorno);

			SimpleDateFormat formatSaida = new SimpleDateFormat(formatoSaida);
			retorno = formatSaida.parse(aux);
			return (retorno);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return retorno;
	}

	/**
	 * Formato de entrada 31.07.2018 12:06:27
	 * 
	 * @param dateTimeString
	 * @return
	 */
	public static Date dateTimeStringToDateAOITRI(String dateTimeString) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;

		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		try {
			retorno = format.parse(dateTimeString);
			format.applyPattern(formatoSaida);

			String aux = format.format(retorno);

			SimpleDateFormat formatSaida = new SimpleDateFormat(formatoSaida);
			retorno = formatSaida.parse(aux);
			return (retorno);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return retorno;
	}

	/**
	 * So e necessario verificar se o retorno e diferente de null
	 * 
	 * @param string
	 * @param separador
	 * @return
	 */
	public static String[] safeSplit(String string, String separador) {
		String retorno[] = null;
		try {
			retorno = string.split(separador);
			if (retorno.length == 0)
				retorno = null;
		} catch (Exception e) {
			retorno = null;
		}
		return retorno;
	}

	/**
	 * Formato de entrada 2018-08-30 13:24:33
	 * 
	 * @param dateTimeString
	 * @return
	 */
	public static Date dateTimeStringToDateOMRON(String dateTimeString) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			retorno = format.parse(dateTimeString);
			format.applyPattern(formatoSaida);

			String aux = format.format(retorno);

			SimpleDateFormat formatSaida = new SimpleDateFormat(formatoSaida);
			retorno = formatSaida.parse(aux);
			return (retorno);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return retorno;
	}

	/**
	 * Formato de entrada 2018/08/30 13:24:33
	 * 
	 * @param dateTimeString
	 * @return
	 */
	public static Date dateTimeStringToDateOMRONVTRNS(String dateTimeString) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;

		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			retorno = format.parse(dateTimeString);
			format.applyPattern(formatoSaida);

			String aux = format.format(retorno);

			SimpleDateFormat formatSaida = new SimpleDateFormat(formatoSaida);
			retorno = formatSaida.parse(aux);
			return (retorno);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return retorno;
	}

	/**
	 * Formato de entrada 01/11/2018 10:49:11
	 * 
	 * @param dateTimeString
	 * @return
	 */
	public static Date convertToDateLogPrinterDek(String origem) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			retorno = formato.parse(origem);
			formato.applyPattern(formatoSaida);

			String aux = formato.format(retorno);

			SimpleDateFormat formatSaida = new SimpleDateFormat(formatoSaida);
			retorno = formatSaida.parse(aux);
			return (retorno);
		} catch (Exception e) {
			retorno = null;
		}
		return retorno;
	}

	/**
	 * Formato de entrada 2018-11-02 10:49:11
	 * 
	 * @param dateTimeString
	 * @return
	 */
	public static Date convertToDateLogWcZTE(String origem) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;

		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			retorno = formato.parse(origem);
			formato.applyPattern(formatoSaida);

			String aux = formato.format(retorno);

			SimpleDateFormat formatSaida = new SimpleDateFormat(formatoSaida);
			retorno = formatSaida.parse(aux);
			return (retorno);
		} catch (Exception e) {
			retorno = null;
		}
		return retorno;
	}

	/**
	 * Formato de entrada 11/01/19 10:49:11
	 * 
	 * @param dateTimeString
	 * @return
	 */
	public static Date convertToDateLogIcts(String origem) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		try {
			retorno = formato.parse(origem);
			formato.applyPattern(formatoSaida);

			String aux = formato.format(retorno);

			SimpleDateFormat formatSaida = new SimpleDateFormat(formatoSaida);
			retorno = formatSaida.parse(aux);
			return (retorno);
		} catch (Exception e) {
			retorno = null;
		}
		return retorno;
	}
	
	public static Date convertToDateConveyor(String origem) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;

		SimpleDateFormat formato = new SimpleDateFormat("EEE-MMM-dd-HH:mm:ss-yyyy",Locale.US);
		try {
			retorno = formato.parse(origem);
			formato.applyPattern(formatoSaida);

			String aux = formato.format(retorno);

			SimpleDateFormat formatSaida = new SimpleDateFormat(formatoSaida);
			retorno = formatSaida.parse(aux);
			return (retorno);
		} catch (Exception e) {
			retorno = null;
		}
		return retorno;
	}

	/**
	 * Safe parser from string to int
	 * 
	 * @param integer
	 *            in string format
	 * @return int
	 */
	public static int stringToInt(String param) {
		try {
			return Integer.valueOf(param);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
