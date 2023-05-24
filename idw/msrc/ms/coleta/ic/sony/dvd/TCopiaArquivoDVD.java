package ms.coleta.ic.sony.dvd;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.healthmarketscience.jackcess.CursorBuilder;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.IndexCursor;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;

import idw.util.IdwLogger;
import ms.coleta.ic.sony.ArquivoSony;

public class TCopiaArquivoDVD {
	private String nomeMaquina = "";
	private String pathDestino = ""; // arg0.getServletContext().getRealPath("")+"/coletaSony"
	private File arquivoOrigem = null;

	private IdwLogger log;
	private int idLog;

	// Construtor para o arquivo AIMHISBT e MDB
	public TCopiaArquivoDVD(String nomeMaquina, String urlDiretorioDestino,
			IdwLogger log, File arquivoOrigem) {
		this.nomeMaquina = nomeMaquina;
		this.log = log;
		this.idLog = log.getIdAleatorio();
		pathDestino = urlDiretorioDestino;
		this.arquivoOrigem = arquivoOrigem;
	}

	public ArquivoSony doJob() {
		ArquivoSony retorno = null;
		List<String> fileLinhas = new ArrayList<String>();
		String nomeArquivo = nomeMaquina + arquivoOrigem.getName();
		// Realiza Copia
		copiaArquivo();

		if (arquivoOrigem.getAbsolutePath().toLowerCase().contains(".csv")) {
			// // Arquivos .csv nao sao mais tratados na coleta DVD
			// // Carrega arquivo em memoria
			// Revisao 57083

		} else if (arquivoOrigem.getAbsolutePath().toLowerCase().contains(".mdb")) {
			// Caso o arquivo seja .mdb do Access
			Database db = null;
			try {
				db = DatabaseBuilder.open(new File(pathDestino + "//"
						+ nomeArquivo));
				Table table = db.getTable("Orders");

				// Ordenacao por data
				IndexCursor cursor = CursorBuilder.createCursor(table.getIndex("Date")); 
				
				for (Row row : cursor) {
					String parsedRow = parseRow(row); 
					if (parsedRow !=null)
						fileLinhas.add(parsedRow);
					// printRow(row);
				}
				// Fecha arquivo
				db.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			 retorno = new ArquivoSonyMDB(log, fileLinhas);
			 // retorno.setNomeArquivo(arquivoOrigem.getName());
			 retorno.setNomeArquivo(nomeArquivo);
			 retorno.setPathArquivo(pathDestino);

		}

		return retorno;
	}

	private String parseRow(Row row) {
		String retorno;
		// Parser
		Date date = (Date) row.get("Date");
		// String stringDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
		String stringDate = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
		
		String cmd = (String) row.get("CMD");
		String machineID = (String) row.get("Machine_ID");
		int shopOrder = (int) row.get("Shop_Order");
		int orderStatus = (int) row.get("Order_Status");
		int bShot = (int) row.get("Bshot");
		int bndOk = (int) row.get("BNDok");
		
		int bndReject0 = (int) row.get("BNDreject0");
		int bndReject1 = (int) row.get("BNDreject1");
		int bndReject2 = (int) row.get("BNDreject2");
		int bndReject3 = (int) row.get("BNDreject3");
		int bndReject4 = (int) row.get("BNDreject4");
		int bndReject5 = (int) row.get("BNDreject5");
		int bndReject6 = (int) row.get("BNDreject6");
		
		int bndDrop = (int) row.get("BNDdrop");
		int bndScrap = (int) row.get("BNDscrap");
		int bndClear = (int) row.get("BNDclear");
		int bndReflected = (int) row.get("BNDreflected");
		int bndVisual = (int) row.get("BNDvisual");
		int bndPatrol = (int) row.get("BNDpatrol");
		
		List<Integer> bndDefs = new ArrayList<Integer>();
		for (int i = 1; i < 17; i++) {
			bndDefs.add((int) row.get("BNDdef" + i));
		}
		
		int mldDrop1 = (int) row.get("MLDDrop1");
		int mldDrop2 = (int) row.get("MLDDrop2");
		int mldDrop3 = (int) row.get("MLDDrop3");
		int mldDrop4 = (int) row.get("MLDDrop4");
		
		
		int bndInSystem = (int) row.get("BNDinSystem");
		
		if (date == null || cmd == null || orderStatus == 0)
			return null;
		
		retorno = (stringDate + "," + cmd + "," + machineID
				+ "," + shopOrder + "," + orderStatus + "," + bShot + ","
				+ bndOk + ","
				+ bndReject0 + "," + bndReject1 + "," + bndReject2 + ","
				+ bndReject3 + "," + bndReject4 + "," + bndReject5 + ","
				+ bndReject6 + "," + bndDrop + "," + bndScrap  + "," + bndClear + ","
				+ bndReflected + "," + bndVisual + "," + bndPatrol);
		for (int i = 0; i < 16; i++) {
			retorno = retorno + "," + bndDefs.get(i);
		}
		retorno = retorno + "," + mldDrop1 + "," + mldDrop2 + "," + mldDrop3 + "," + mldDrop4
				+ "," + bndInSystem;
		
		return retorno;
	}

	public void copiaArquivo() {
		if (arquivoOrigem != null) {
			String nomeArquivoDestino = arquivoOrigem.getName();
			// String arquivoDestino = pathDestino + "//" + nomeArquivoDestino;
			String arquivoDestino = pathDestino + "//" + nomeMaquina + nomeArquivoDestino;
			Path pathArquivoDestino = Paths.get(arquivoDestino);
			try {
				Files.copy(arquivoOrigem.toPath(), pathArquivoDestino,
						StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				log.error(
						idLog,
						0,
						"TCopiaArquivo: Erro ao copiar arquivo: "
								+ arquivoOrigem.getName() + " Erro foi: "
								+ e.toString());
			}
		}
	}

	private static void printRow(Row row) {

		// Parser
		Date date = (Date) row.get("Date");
		String cmd = (String) row.get("CMD");
		String machineID = (String) row.get("Machine_ID");
		int shopOrder = (int) row.get("Shop_Order");
		int orderStatus = (int) row.get("Order_Status");
		int bShot = (int) row.get("Bshot");
		int bndOk = (int) row.get("BNDok");

		System.out.println(date.toLocaleString() + "," + cmd + "," + machineID
				+ "," + shopOrder + "," + orderStatus + "," + bShot + ","
				+ bndOk);
	}

} // Fim da classe
