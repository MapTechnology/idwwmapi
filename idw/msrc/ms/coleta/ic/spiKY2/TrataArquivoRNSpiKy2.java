package ms.coleta.ic.spiKY2;

import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import ms.coleta.ic.aoiVTRNSSQL.ArquivoUltimoID;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.drivercoleta.PararDeProcessarArquivoSemSalvarLinhaException;
import ms.coleta.ic.flex.TrataArquivoRN;
import ms.coleta.ic.spi.LinhaArquivoSpiKy;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsThreads;

public class TrataArquivoRNSpiKy2 extends TrataArquivoRN {

	private BufferedEventos bufferEvento;
	private TrataBD tratador;
	
	private ArquivoUltimoID ultimoID = null;
	private IcDTO icdto;

	public TrataArquivoRNSpiKy2(String pathRelativo, IcDTO icdto, IcUpDTO icupdto, ColetaFileType fileType, IdwLogger log, int idLog) {
		super(pathRelativo, icupdto, fileType, log, idLog);
		this.icdto = icdto;
	}

	@Override
	protected boolean processaUmaLinhaDoArquivoCustom(File file, String name, int lineCount, String linhaArquivo) throws PararDeProcessarArquivoSemSalvarLinhaException {

		if (!linhaArquivo.contains("InspectTime") || !linhaArquivo.contains("Warning") || !linhaArquivo.contains("Error")) {
			String urlAuxiliar = icupdto.getUrlAuxiliar();
			String nomeArquivo = name.replace(".txt", "");
			String time = linhaArquivo.split(",")[0];
			Date dateTime = LinhaArquivoSpiKy.convertToDateLogSpiKy(nomeArquivo + ' ' + time);
			String ano = String.valueOf(dateTime.getYear() + 1900);
			String mes = String.valueOf(dateTime.getMonth() + 1);

			try {
				tratador = new TrataBD(urlAuxiliar, dateTime, ano, mes, log, icdto, icupdto, this.ultimoID);
			} catch (Exception e) {
				tratador = null;
			}
			log.info("Iniciando a Obtenção de eventos");
			List<EventoColetado> ev = null;
			if (tratador != null) 
				ev = tratador.obtemEvento();
			
			if (ev != null && ev.isEmpty() == false) {
				bufferEvento.addEventos(ev);
				log.info("Evento adicionado com sucesso");
			}
		}

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

		/*
		 * A ultima linha processada da maquina deve considerar tambem o nome do arquivo que está sendo processado, pois enquanto o arquivo
		 * principal é criado, outros arqruivos que não interessam também são, e esses arquivos.
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

	public void setBufferEvento(BufferedEventos bufferEvento, ArquivoUltimoID ultimoID) {
		this.bufferEvento = bufferEvento;
		this.ultimoID = ultimoID;
	}

	public static Date convertToDateLogSpiKy(String origem) {
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		Date retorno = null;

		SimpleDateFormat formato = new SimpleDateFormat("yyMMdd HH:mm:ss");
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

	
	
	
	@Override
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
					if (linhaArquivo != null) {
						
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
							pararDeProcessarArquivo = true;
							retorno = true;
							break;
						} catch (Exception e) {
							log.info(idLog, 0, "TrataArquivoRN erro1: excecao ao executar: linhaArquivo = reader.readLine(); ou linhas seguintes ", e);
							retorno = false;
						}

					}
					UtilsThreads.pausaNaThread(10l);
					
					// Alessandre em 25-05-22 para a SpiKy2 é processado apenas uma linha do arquivo, pois o arquivo só server para iniciar a tratativa do MDB
					// nenhum informacao mais é obtida desse arquivo
					pararDeProcessarArquivo = true;
					
					
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

}
