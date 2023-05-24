package ms.coleta.ic.flex;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import idw.model.IdwFacade;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.drivercoleta.PararDeProcessarArquivoSemSalvarLinhaException;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsThreads;

public abstract class TrataArquivoRN {
	
	protected abstract void tratativaFinalDoArquivo() throws PararDeProcessarArquivoSemSalvarLinhaException; // Atualmente apenas o TrataArquivoRN24G tem implementacao para esse metodo, devido o produto HPNA nao ter o motivo da falha

	/**************************************************************************
	 ** Variaveis genericas para todos os tipos de coletas ** Essas variaveis sao utilizadas por todas as coletas **
	 **************************************************************************/
	protected String pathDirParaProcessamento = "C:/coleta/arquivosparaprocessamento/";
	protected String maquina;

	protected String ultimaLinhaProcessada = null;
	protected String ultimoArquivoProcessado = null; // Alessandre em 31-10-2017. Inclui esse atributo para guardar o nome
														// do ultimo arquivo, pois soh a linha podemos perder testes, visto que
														// a ultima linha pode ser repetir em outro arquivo

	protected IdwLogger log;
	protected int idLog;
	protected IcUpDTO icupdto;
	protected ColetaFileType fileType;

	private Thread threadProcessaEventData = null;

	private boolean isProcessarEventdata;
	protected int lineCounter = 0;

	protected List<String> ultimosArquivoTratados = new ArrayList<String>();

	private Runnable runnableTrataArquivo = new Runnable() {
		@Override
		public void run() {
			processaTodosOsArquivos();
		}
	};

	private Comparator<File> ordenaAlfabeticaAsc = new Comparator<File>() {
		public int compare(File f1, File f2) {
			return f1.getName().compareTo(f2.getName());
		}
	};

	/**************************************************************************
	 ** Variaveis espeficias FLEX/MITRASTAR ** Essas variaveis so sao utilizadas por coletas da FLEX/MITRASTAR **
	 **************************************************************************/
	protected String linhaTemp = "";

	/**************************************************************************
	 ** Funcoes GENERICAS estao abaixo desse ponto ** Essas funcoes sao as mesmas utilizadas por todos os tipos de coletas **
	 **************************************************************************/

	public TrataArquivoRN(String pathRelativo, IcUpDTO icupdto, ColetaFileType fileType, IdwLogger log, int idLog) {
		super();
		
		this.icupdto = icupdto;
		this.pathDirParaProcessamento = pathRelativo;
		this.maquina = icupdto.getUpDTO().getCd_up();
		this.fileType = fileType;
		this.log = log;
		this.idLog = idLog;
		this.isProcessarEventdata = true;

		log.info(idLog, 0, "TrataArquivoRN.super(" + this.pathDirParaProcessamento + ") para posto " + this.maquina);

		if (this.pathDirParaProcessamento == null)
			this.pathDirParaProcessamento = "";

		if (this.pathDirParaProcessamento.equals("")) {
			this.pathDirParaProcessamento = "/" + this.maquina + "/";
		} else {
			if (this.pathDirParaProcessamento.endsWith("/") == false) {
				this.pathDirParaProcessamento += "/";
			}
		}
	}

	public void inicializaThread() {
		log.info("TrataArquivoRN.inicializaThread(" + this.maquina + ") INI");

		try {
			this.isProcessarEventdata = true;
			threadProcessaEventData = new Thread(runnableTrataArquivo);
			threadProcessaEventData.start();
		} catch (Exception e) {
			log.info("TrataArquivoRN erro: excecao ao executar: threadProcessaEventData = new Thread(runnableTrataArquivo); ou linhas seguintes " + e);
			e.printStackTrace();
		}

		log.info("TrataArquivoRN.inicializaThread(" + this.maquina + ") FIM");
	}

	public void pararExecucaoThread() {
		isProcessarEventdata = false;
	}

	
	/* Metodo principal para tratar o arquivo
	 * 
	 */
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


	private void processaTodosOsArquivos() {
		log.info("processaTodosOsArquivos(" + maquina + ")");
		Boolean delFile = false;

		while (isProcessarEventdata == true) {
			List<String> arquivosParaProcessamento = obtemArquivosASeremTratados();

			if (arquivosParaProcessamento != null) {
				try {
					for (String arqNome : arquivosParaProcessamento) {
						if (arqNome == null || arqNome == "")
							continue;

						if (!ArquivosDiretorios.isExisteArquivo(arqNome))
							continue;

						// Sempre obtenho a ultima linha processada pois o aruqivo pode ser outro
						obtemInformacoesNecessarias(arqNome);


						File arq = null;
						boolean isAbriuArquivo = false;
						do {
							try {
								log.info("Abrindo arquivo(" + arqNome + ")");
								arq = new File(arqNome);
								isAbriuArquivo = true;
							} catch (Exception e) {
								log.info("TrataArquivoRN erro: excecao ao executar: arq = new File(arqNome); ou linhas seguintes " + e);
								e.printStackTrace();
								Thread.sleep(3000);
							}
						} while (isAbriuArquivo == false);

						if (arq == null)
							continue;

						try {
							delFile = processaUmArquivoDaMaquina(arq);
						} catch (Exception e) {
							log.info("TrataArquivoRN erro: excecao ao executar: delFile = processaUmArquivoDaMaquina(arq); " + e);
							e.printStackTrace();
						}
						try {
							if (delFile == true) {
								arq.delete();
							}
						} catch (Exception e) {
							log.info("TrataArquivoRN erro: excecao ao executar: arq.delete(); " + e);
							e.printStackTrace();

						}
					}
				} catch (Exception e) {
					log.info("TrataArquivoRN erro: excecao ao executar o try-catch principal de processaTodosOsArquivos() " + e);
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				log.info("TrataArquivoRN erro: excecao ao executar: Thread.sleep(3000); " + e);
				e.printStackTrace();
			} catch (Exception e) {
				log.info("TrataArquivoRN erro: excecao ao executar: Thread.sleep(3000); " + e);
				e.printStackTrace();
			}
		}
		log.info("SAIU - processaTodosOsArquivos()");
	}

	private List<String> obtemArquivosASeremTratados() {
		File diretorio = new File(pathDirParaProcessamento + maquina);
		File[] arquivos = null;
		List<String> retorno = new ArrayList<String>();
		// log.info("obtemArquivosASeremTratados("+urlConexao + maquina+")");
		try {
			arquivos = diretorio.listFiles();
			if (arquivos != null) {
				Arrays.sort(arquivos, ordenaAlfabeticaAsc);
			}
		} catch (Exception e) {
			log.info("TrataArquivoRN erro: excecao ao executar: arquivos = diretorio.listFiles(); ou linhas seguintes " + e);
			e.printStackTrace();
		}
		if (arquivos != null) {
			try {
				for (File f : arquivos) {
					log.info("Adicionado(" + f.getPath() + ")");
					retorno.add(f.getPath());
				}
			} catch (Exception e) {
				log.info("TrataArquivoRN erro: excecao ao executar: retorno.add(f.getPath()); ou linhas seguintes " + e);
				e.printStackTrace();
			}
		} else {
			retorno = null;
		}
		return retorno;
	}

	protected boolean isArquivoEntreUltimosTratados(File file) {
		for (String name : ultimosArquivoTratados) {
			if (file.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Metodo deve retornar true se encontrar a ultima linha que foi processada ou se o arquivo é diferente Encontrei a situacao em que o
	 * arquivo era novo mas a ultima linha existia dentro do arquivo
	 */
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

	protected boolean processaUmaLinhaDoArquivo(File file, String name, int lineCount, String linhaArquivo, ColetaFileType fileType) throws PararDeProcessarArquivoSemSalvarLinhaException {
		boolean retorno = false;
		try {
			retorno = processaUmaLinhaDoArquivoCustom(file, name, lineCount, linhaArquivo);
		} catch (PararDeProcessarArquivoSemSalvarLinhaException e) {
			throw e;
		} catch (Exception e) {
			log.info(idLog, 0, "Falhou ao processar a linha desejada", e);
			log.info(idLog, 0, "Linha " + linhaArquivo);
			e.printStackTrace();
		}
		return retorno;
	}

	protected void lancaTesteSimples(String linha, Date horaPassagem, String serialNumber, int stTeste) throws PararDeProcessarArquivoSemSalvarLinhaException {
		String cdUp = icupdto.getUpDTO().getCd_up();
		log.iniciaAvaliacao("regristrarTesteSimples");
		if (serialNumber != null && !serialNumber.equals("")) {
			try {
				IdwFacade.getInstancia().getValidarNumeroDeSerieComExcessao(cdUp, null, serialNumber, "", 8l, false);
				IdwFacade.getInstancia().regristrarTesteSimplesComExcessao(cdUp, null, serialNumber, horaPassagem, stTeste, "1");
				Thread.sleep(500);
			} catch (Exception e) {
				log.info("TrataArquivoRN erro: excecao ao executar:  String cdUp = icupdto.getUpDTO().getCd_up(); ou linhas seguintes ", e);
				e.printStackTrace();
				throw new PararDeProcessarArquivoSemSalvarLinhaException();
			} finally {
				log.getAvaliacaoCompleta();
			}
		} else {
			log.info("TrataArquivoRN: Em lancaTesteSimples(), serialNumber igual a null ou vazio, para linha origem: " + linha);
		}
	}

	
	protected void lancaTesteComDefeito(String linha, Date horaPassagem, String serialNumber, int stTeste, String cddefeito) throws PararDeProcessarArquivoSemSalvarLinhaException {
		String cdUp = icupdto.getUpDTO().getCd_up();
		log.iniciaAvaliacao("regristrarTesteSimples");
		if (serialNumber != null && !serialNumber.equals("")) {
			try {
				IdwFacade.getInstancia().getValidarNumeroDeSerieComExcessao(cdUp, null, serialNumber, "", 8l, false);
				IdwFacade.getInstancia().regristrarTesteDefeitoComExcessao(
						cdUp, 
						null, 
						serialNumber, 
						horaPassagem, 
						cddefeito, 
						"1", 
						null,
						null);
				Thread.sleep(500);
			} catch (Exception e) {
				log.info("TrataArquivoRN erro: excecao ao executar:  String cdUp = icupdto.getUpDTO().getCd_up(); ou linhas seguintes ", e);
				e.printStackTrace();
				throw new PararDeProcessarArquivoSemSalvarLinhaException();
			} finally {
				log.getAvaliacaoCompleta();
			}
		} else {
			log.info("TrataArquivoRN: Em lancaTesteSimples(), serialNumber igual a null ou vazio, para linha origem: " + linha);
		}
	}

	
	public boolean isEquals(String maquina) {
		return this.maquina.equals(maquina);
	}

	/**************************************************************************
	 ** Funcoes especificas/customizadas estao abaixo desse ponto ** Estas funcoes devem ser implementadas de acordo com o tipo de coleta **
	 **************************************************************************/
	protected abstract void salvaInformacoesNecessarias(String arquivoProcessado);

	protected abstract boolean obtemInformacoesNecessarias(String arquivoProcessado);

	protected abstract boolean processaUmaLinhaDoArquivoCustom(File file, String name, int lineCount, String linhaArquivo) throws PararDeProcessarArquivoSemSalvarLinhaException;

	public IcUpDTO getIcupdto() {
		return icupdto;
	}

	
}
