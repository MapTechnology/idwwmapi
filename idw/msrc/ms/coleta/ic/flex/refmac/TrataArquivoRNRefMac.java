package ms.coleta.ic.flex.refmac;

import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.drivercoleta.PararDeProcessarArquivoSemSalvarLinhaException;
import ms.coleta.ic.flex.TrataArquivoRN;
import ms.model.dto.IcUpDTO;

public class TrataArquivoRNRefMac extends TrataArquivoRN {

	private BufferedEventos bufferEvento;
	
	public TrataArquivoRNRefMac(String pathRelativo, IcUpDTO icupdto, ColetaFileType fileType, IdwLogger log, int idLog) {
		super(pathRelativo, icupdto, fileType, log, idLog);
	}


	@Override
	protected boolean processaUmaLinhaDoArquivoCustom(File file, String name, int lineCount, String linhaArquivo) throws PararDeProcessarArquivoSemSalvarLinhaException {
		LinhaArquivoRefMac linha = new LinhaArquivoRefMac(log, icupdto, linhaArquivo, file.toString());
		bufferEvento.addEventos(linha.obtemEvento());
		return false;
	}


	@Override
	protected void salvaInformacoesNecessarias(String arquivoProcessado) {
		try {
			String fileName = pathDirParaProcessamento + maquina + "-" + arquivoProcessado + ".txt";
			log.info("Salvando ultimaLinhaProcessada" + lineCounter + " em " + fileName);
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			writer.println(ultimaLinhaProcessada);
			writer.println(String.valueOf(lineCounter));
			writer.println(ultimoArquivoProcessado);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	protected boolean obtemInformacoesNecessarias(String arquivoProcessado) {
		boolean retorno = false;

		/* A ultima linha processada da maquina deve considerar tambem o nome do arquivo
		 * que está sendo processado, pois enquanto o arquivo principal é criado, outros arqruivos
		 * que não interessam também são, e esses arquivos.
		 */
		String fileName = pathDirParaProcessamento + maquina + "-" + arquivoProcessado + ".txt";

		if (ArquivosDiretorios.isExisteArquivo(fileName) == true) {
			try (RandomAccessFile reader = new RandomAccessFile(fileName, "r")) {
				this.ultimaLinhaProcessada = reader.readLine();
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
	protected void tratativaFinalDoArquivo() {
	}
	
	
	public void setBufferEvento(BufferedEventos bufferEvento) {
		this.bufferEvento = bufferEvento;
	}
}
