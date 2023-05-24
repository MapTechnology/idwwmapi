package ms.coleta.ic.mitrastar.ssid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Colunas do arquivo
 * 0 serial placa main
 * 1 mac
 * 2 SSID WIFI 2.4G
 * 3 SENHA wifi 2.4G
 * 4 SSID WIFI 5G
 * 5 SENHA wifi 5G
 * 6 mac/serial
 * 7 Password do produto
 * 8 Serial da bosa
 * 9 Serial interno da bosa (esse é o codigo base para gerar o Serial da bosa)
 * 10 Data
 * 11 Hora
 *
 * @author Milton
 *
 */

public class LinhaArquivoMitraStarSSID {

	private static String FORMATO_DATA_HORA = "dd/MM/yy HH:mm:ss";
	private static final String SEPARATOR = "\\t";

	private final String serialPlaca;
	private final String mac;
	private final String serial;
	private final Date dataHora;
	private final String senha24g;
	private final String bosa;
	
	private final String senha5g;

	private int INDEX_SERIAL_PLACA_N1 = 0;
	private int INDEX_SERIAL_PLACA_GV = 0;
	private int INDEX_SERIAL_PLACA_HPNA = 0;

	private int INDEX_MAC_N1 = 1;
	private int INDEX_MAC_GV = 5;
	private int INDEX_MAC_HPNA = 1;
	
	private int INDEX_SERIALN1 = 6;
	private int INDEX_SERIALGV = 1;
	private int INDEX_SERIALHPNA = 8;
	
	private int INDEX_DATA_N1 = 10;
	private int INDEX_DATA_GV = 7;
	private int INDEX_DATA_HPNA = 10;

	private int INDEX_HORA_N1 = 11;
	private int INDEX_HORA_GV = 8;
	private int INDEX_HORA_HPNA = 11;
	
	private int INDEX_BOSA_N1 = 8;
	private int INDEX_BOSA_GV = 8;
	private int INDEX_BOSA_HPNA = 8;

	private int TOTAL_ITENS_N1 = 12;
	private int TOTAL_ITENS_GV = 9;
	private int TOTAL_ITENS_HPNA = 11;

	private int INDEX_SENHA24_PLACA_GV = 2;
	private int INDEX_SENHA24_PLACA_N1 = 2;
	private int INDEX_SENHA24_PLACA_HPNA = 2;
	
	private int INDEX_SENHA5G_PLACA_GV = 3;
	private int INDEX_SENHA5G_PLACA_N1 = 4;
	private int INDEX_SENHA5G_PLACA_HPNA = 4;

	public static void main(String[] args) {
		// SSID N1
		String linha = "561817002013	A433D71AE1E0	VIVOFIBRA-E1E0	33d71ae1e0	VIVOFIBRA-E1E0-5G	33d71ae1e0	A433D71AE1E0	e79bba84	MSTC30487AC7	A180Y10056391	23/04/18	12:02:07 AM";
		
		// SSID HPNA 3o tipo
		//linha = "561815000006	ACC662B6B198	VIVOFIBRA-B198	A46A8D2195	VIVOFIBRA-B198-5G	A46A8D2195	ACC662B6B198	492e5c8b	MSTC2CA4D544	S170Z49000004	07/05/18 09:52:00";
		LinhaArquivoMitraStarSSID rn = null;
		try {
			rn = new LinhaArquivoMitraStarSSID(linha);
		} catch (MitraStarSSIDParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("data e hora = " + rn.getDataHora() );
	}
	
	
	public LinhaArquivoMitraStarSSID(String row) throws MitraStarSSIDParseException {
		try {
			String[] values = row.split(SEPARATOR);

			if (values.length != TOTAL_ITENS_N1 && values.length != TOTAL_ITENS_GV && values.length != TOTAL_ITENS_HPNA && values.length != 8){
				StringBuilder msg = new StringBuilder();
				
				msg.append("Total de itens da linha deveria ser de ");
				msg.append(TOTAL_ITENS_N1);
				msg.append(" para N1 ou ");
				msg.append(TOTAL_ITENS_GV);
				msg.append(" para GV.");
				msg.append(TOTAL_ITENS_HPNA);
				msg.append(" para o HPNA.");
				msg.append(" Separador usado é '");
				msg.append(SEPARATOR );
				msg.append("'. ");
				msg.append(" Linha=" );
				msg.append(row);
				
				throw new MitraStarSSIDParseException(msg.toString());
			}

			serialPlaca = getParseSerialPlaca(values);
			mac = getParseMac(values);
			serial = getParseSerial(values);
			dataHora = getParseDataHora(values);
			senha24g = getParseSenha24G(values);
			senha5g = getParseSenha5G(values);
			bosa = getParseBosa(values);

		} catch (MitraStarSSIDParseException e) {
			throw e;
		} catch (Exception e) {
			throw new MitraStarSSIDParseException(e.getMessage() + ". " + row, e);
		}
	}

	
	public String getSenha24g() {
		return senha24g;
	}


	public String getSenha5g() {
		return senha5g;
	}



	public String getSerialPlaca() {
		return serialPlaca;
	}

	public String getMac() {
		return mac;
	}

	public String getSerial() {
		return serial;
	}

	public Date getDataHora() {
		return dataHora;
	}
	
	public String getBosa() {
		return bosa;
	}

	private Date getParseDataHora(String[] values) throws ParseException {
		String data;
		String hora;
		
		if (values.length == TOTAL_ITENS_GV) {
			data = values[INDEX_DATA_GV];
			hora = values[INDEX_HORA_GV];
		} else if (values.length == TOTAL_ITENS_N1) {
			data = values[INDEX_DATA_N1];
			hora = values[INDEX_HORA_N1];
		} else if (values.length == 8) {
			data = values[6];
			hora = values[7];
		} else {
			data = values[INDEX_DATA_HPNA];
			hora = "";
		}
		
		// Verificar ser existe conteudo apos a hora e se existir verificar se o conteudo é AM ou PM. Se for
		// PM a hora deve ser acrescida de 12. Entretanto se a hora for 12 AM, mudar para 0h. Se a hora for 12PM mudar para
		// 12h sem acresentar 12.
		if (hora.contains("AM") || hora.contains("PM")) {
			FORMATO_DATA_HORA = "dd/MM/yy hh:mm:ss a";
		} else {
			FORMATO_DATA_HORA = "dd/MM/yy HH:mm:ss";
		}
		
		String dthr = data + " " + hora;
		Date retorno = new SimpleDateFormat(FORMATO_DATA_HORA).parse(dthr.trim());
		return retorno;
	}


	private String getParseSerial(String[] values) {
		String retorno;
		if (values.length == TOTAL_ITENS_GV)
			retorno = values[INDEX_SERIALGV];
		else if (values.length == TOTAL_ITENS_N1)
			retorno = values[INDEX_SERIALN1];
		else if (values.length == 8)
			retorno = null;
		else
			retorno = values[INDEX_SERIALHPNA];
		return retorno;
	}


	private String getParseMac(String[] values) {
		String retorno;
		if (values.length == TOTAL_ITENS_GV)
			retorno = values[INDEX_MAC_GV];
		else if (values.length == TOTAL_ITENS_N1)
			retorno = values[INDEX_MAC_N1];
		else
			retorno = values[INDEX_MAC_HPNA];
		return retorno;
	}


	private String getParseSerialPlaca(String[] values) {
		String retorno;
		if (values.length == TOTAL_ITENS_GV)
			retorno = values[INDEX_SERIAL_PLACA_GV];
		else if (values.length == TOTAL_ITENS_N1)
			retorno = values[INDEX_SERIAL_PLACA_N1];
		else
			retorno = values[INDEX_SERIAL_PLACA_HPNA];
		
		return retorno;
	}
	
	private String getParseSenha24G(String[] values) {
		String retorno;
		if (values.length == TOTAL_ITENS_GV)
			retorno = values[INDEX_SENHA24_PLACA_GV];
		else if (values.length == TOTAL_ITENS_N1)
			retorno = values[INDEX_SENHA24_PLACA_N1] + values[INDEX_SENHA24_PLACA_N1 + 1];
		else if (values.length == 8)
			retorno = values[2] + values[3];
		else
			retorno = values[INDEX_SENHA24_PLACA_HPNA] + values[INDEX_SENHA24_PLACA_HPNA + 1];
		
		return retorno;
	}



	private String getParseSenha5G(String[] values) {
		String retorno;
		
		if (values.length == TOTAL_ITENS_GV)
			retorno = values[INDEX_SENHA5G_PLACA_GV];
		else if (values.length == TOTAL_ITENS_N1)
			retorno = values[INDEX_SENHA5G_PLACA_N1] + values[INDEX_SENHA5G_PLACA_N1 + 1];
		else if (values.length == 8)
			retorno = null;
		else
			retorno = values[INDEX_SENHA5G_PLACA_HPNA] + values[INDEX_SENHA5G_PLACA_HPNA + 1];
		
		return retorno;
	}

	private String getParseBosa(String[] values) {
		String retorno= null;
		
		if (values.length == TOTAL_ITENS_GV)
			retorno = values[INDEX_BOSA_GV];
		else if (values.length == TOTAL_ITENS_N1)
			retorno = values[INDEX_BOSA_N1];
		else
			retorno = null;
		
		
		
		return retorno;
	}
}
