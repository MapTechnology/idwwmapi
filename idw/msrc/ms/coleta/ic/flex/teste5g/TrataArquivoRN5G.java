package ms.coleta.ic.flex.teste5g;

import java.io.PrintWriter;
import java.io.RandomAccessFile;

import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.flex.teste24g.TrataArquivoRN24G;
import ms.model.dto.IcUpDTO;

/* O tratamento do 5G é exatamente o mesmo do 24G. Se houver alguma diferença no futuro deve-se reescrever os metodos nessa classe
 * 
 */
public class TrataArquivoRN5G extends TrataArquivoRN24G {


	public TrataArquivoRN5G(String pathRelativo, IcUpDTO icupdto, ColetaFileType fileType, IdwLogger log, int idLog) {
		super(pathRelativo, icupdto, fileType, log, idLog);
	}	

	
	
	@Override
	protected boolean obtemInformacoesNecessarias(String arquivoProcessado) {
		boolean retorno = false;

		String fileName = pathDirParaProcessamento + maquina + "-" + arquivoProcessado + ".txt";

		if (ArquivosDiretorios.isExisteArquivo(fileName) == true) {
			try (RandomAccessFile reader = new RandomAccessFile(fileName, "r")) {
//				this.ultimaLinhaProcessada = reader.readLine(); nao salva a ultima linha, pois no 5g sempre pegaremos o arquivo inteiro
				this.lineCounter = Integer.parseInt(reader.readLine());
				this.ultimoArquivoProcessado = reader.readLine();
				retorno = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return retorno;
	}

	@Override
	protected void salvaInformacoesNecessarias(String arquivoProcessado) {
		try {
			String fileName = pathDirParaProcessamento + maquina + "-" + arquivoProcessado + ".txt";
			log.info("Salvando ultimaLinhaProcessada" + lineCounter + " em " + fileName);
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
//			writer.println(ultimaLinhaProcessada); nao salva a ultima linha pois o arquivo sempre sera reprocessado
			writer.println(String.valueOf(lineCounter));
			writer.println(ultimoArquivoProcessado);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
