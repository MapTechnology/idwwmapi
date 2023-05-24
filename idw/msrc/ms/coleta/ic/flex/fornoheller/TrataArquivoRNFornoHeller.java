package ms.coleta.ic.flex.fornoheller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.List;

import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.drivercoleta.PararDeProcessarArquivoSemSalvarLinhaException;
import ms.coleta.ic.flex.TrataArquivoRN;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsThreads;

public class TrataArquivoRNFornoHeller extends TrataArquivoRN{
	
	private BufferedEventos bufferEvento;

	public TrataArquivoRNFornoHeller(String pathRelativo, IcUpDTO icupdto, ColetaFileType fileType, IdwLogger log, int idLog) {
		super(pathRelativo, icupdto, fileType, log, idLog);
	}
	
	
	// Como os arquivos de Log dos Fornos Heller possuem uma codificação diferente de UTF-8 e ANSI
	// o metodo principal para tratar o arquivo de TrataArquivoRN.java que e  processaUmArquivoDaMaquina
	// precisou ser sobrecarregado
	public boolean processaUmArquivoDaMaquina(File file) {
		if (file == null)
			return false;
		
		log.info(idLog, 0, "processaUmArquivoDaMaquina(" + file.getPath() + ")");

		boolean retorno = false;
		boolean isMesmoArquivoEncontrouUltimaLinha = false;

		String linhaArquivo = "";
		
		obtemInformacoesNecessarias(file.getName());

		try {
			if (ultimosArquivoTratados.size() >= 10)
				ultimosArquivoTratados.remove(ultimosArquivoTratados.size() - 1);

			if (isArquivoEntreUltimosTratados(file))
				return true;

			ultimosArquivoTratados.add(0, file.getName());

			try (RandomAccessFile reader = new RandomAccessFile(file.getPath(), "r")) {

				isMesmoArquivoEncontrouUltimaLinha = isMesmoArquivoEncontrouUltimaLinha(reader, file.getName());


				// Se for um arquivo diferente do anterior ou se NAO encontrou a ultima linha entao ir para inicio do arquivo
				// e processa-lo integralmente. O ultimo arquivo tambem deve ser levado em conta pois vimos um caso em que o arquivo mudou
				// mas a ultima linha estava dentro dele
				if (isMesmoArquivoEncontrouUltimaLinha == false) {
					log.info(idLog, 0, "isSameFile=" + isMesmoArquivoEncontrouUltimaLinha + " entao indo para inicio do arquivo.");
					reader.seek(0);
					lineCounter = 0;
				}

				boolean pararDeProcessarArquivo = false;
				do {
					linhaArquivo = reader.readLine();
					// Encoding para UTF-8
					linhaArquivo = ucs2ToUTF8(linhaArquivo.getBytes());
					if (linhaArquivo != null && !linhaArquivo.equals("ï¿½")) {
						
						lineCounter++;
						
						/* Existe uma situacao em que linhaArquivo inicializada acima pode ser igual a ultima linha processada
						 * Isso ocorre caso existe alguma repetição da ultima linha processada. Nesse caso devemos descartar a
						 * segunda ocorrencia da linha e pegar a proxima
						 */
						if (linhaArquivo.equals(ultimaLinhaProcessada))
							continue;
						
						
						try {
							if (!linhaArquivo.equals("\t\t\t\t\t\t\t\t") && !linhaArquivo.equals("") && !linhaArquivo.equals("                                ")) {
								log.info(idLog, 0, "processando linha " + lineCounter + "(" + linhaArquivo + ")");
								pararDeProcessarArquivo = processaUmaLinhaDoArquivo(file, file.getName(), lineCounter, linhaArquivo, fileType);
								this.ultimaLinhaProcessada = linhaArquivo;
								this.ultimoArquivoProcessado = file.getName();
								retorno = true;
								salvaInformacoesNecessarias(file.getName());
							}
						} catch (PararDeProcessarArquivoSemSalvarLinhaException e) {
							log.info(idLog, 0, "TrataArquivoRN erro0: excecao ao executar: linhaArquivo = reader.readLine(); ou linhas seguintes ", e);
							System.out.println(e.getMessage());
							pararDeProcessarArquivo = true;
							retorno = true;
							break;
						} catch (Exception e) {
							log.info(idLog, 0, "TrataArquivoRN erro1: excecao ao executar: linhaArquivo = reader.readLine(); ou linhas seguintes ", e);
							System.out.println(e.getMessage());
							retorno = false;
						}

					}
					UtilsThreads.pausaNaThread(10l);
				} while (linhaArquivo != null && pararDeProcessarArquivo == false);
				
				tratativaFinalDoArquivo();
			}
		} catch (Exception e) {
			log.info(idLog, 0, "TrataArquivoRN erro2: excecao ao executar:  if(isArquivoEntreUltimosTratados(file)) ou linhas seguintes " + e);
			e.printStackTrace();
			retorno = false;
		}
		log.info(idLog, 0, "Finalizou processaUmArquivoDaMaquina. Retorno=" + retorno);
		return retorno;
	}

	protected boolean isMesmoArquivoEncontrouUltimaLinha(RandomAccessFile reader, String arquivoProcessado) throws IOException {
		String linhaArquivo = null;

		// Se nao existe referencia da ultima linha, entao ja retornar false para o arquivo completo ser processado
		if (this.ultimaLinhaProcessada == null) {
			return false;
		}

		/* O for abaixo deverá procurar a ultima linha processada dentro do arquivo. Se encontrar deve retornar TRUE
		 * 
		 */
		for (int i = 0; i < lineCounter; i++) {
			linhaArquivo = reader.readLine();
			// Encoding para UTF-8
			linhaArquivo = ucs2ToUTF8(linhaArquivo.getBytes());

			if (linhaArquivo == null)
				break;

			if (linhaArquivo != null &&
					this.ultimaLinhaProcessada != null &&
					linhaArquivo.equals("") == false &&
					linhaArquivo.equals(this.ultimaLinhaProcessada)) {
				return true;
			}
		}
		
		// Se chegou ate a quantidade de linhas processadas anteriormente sem encontrar a ultima linha, entao
		// avalia se a ultima linha lida eh igual a ultima processada, senao retorna FALSE
		boolean isRetorno = (linhaArquivo != null &&
				this.ultimaLinhaProcessada != null &&
				linhaArquivo.equals("") == false &&
				linhaArquivo.equals(this.ultimaLinhaProcessada)) ? true : false;

		return isRetorno;
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
			log.info(idLog, 0, "Excessao", e);
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
				log.info(idLog, 0, "Excessao", e);
			}
		}
		return retorno;
	}

	@Override
	protected boolean processaUmaLinhaDoArquivoCustom(File file, String name, int lineCount, String linhaArquivo) throws PararDeProcessarArquivoSemSalvarLinhaException {
		LinhaArquivoFornoHeller linha = new LinhaArquivoFornoHeller(log, icupdto, linhaArquivo, file.toString());
		List<EventoColetado> ev = linha.obtemEvento();
		if (ev.isEmpty() == false) {
			bufferEvento.addEventos(ev);
		}
		return false;
	}

	public void setBufferEvento(BufferedEventos bufferEventos) {
		this.bufferEvento = bufferEventos;
		
	}
	
	@Override
	protected void tratativaFinalDoArquivo() throws PararDeProcessarArquivoSemSalvarLinhaException {
		// TODO Auto-generated method stub
		
	}
	
	public String ucs2ToUTF8(byte[] ucs2Bytes){
		  
	    String unicode = null;
	    String utf8 = null;
		try {
			unicode = new String(ucs2Bytes, "UTF-16");
			utf8 = new String(unicode.getBytes("UTF-8"), "Cp1252");
		} catch (Exception e) {
			log.error("Excecao em TrataArquivoRNFornoHeller ao converter linha; ucs2ToUTF8: " + e);
			return "";
		}  
	    return utf8;  
	}

}
