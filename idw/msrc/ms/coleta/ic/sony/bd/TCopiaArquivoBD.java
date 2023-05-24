package ms.coleta.ic.sony.bd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import idw.util.IdwLogger;
import ms.coleta.ic.sony.ArquivoSony;
import ms.coleta.ic.sony.ICSony;
import ms.util.UtilsString;

public class TCopiaArquivoBD {

	private String nomeMaquina;
	private String pathDestino = ""; // arg0.getServletContext().getRealPath("")+"/coletaSony"
	private ICSony icSony;

	private IdwLogger log;
	private int idLog;
	
	private String prefixoArquivo = null; //Ex: VM-BR-SPARE, BRAZIL-SPARE 
	
	public TCopiaArquivoBD(String nomeMaquina, String diretorioDestino, IdwLogger log, ICSony icSony) {
	
		this.nomeMaquina = nomeMaquina;

		this.log = log;
		this.idLog = log.getIdAleatorio();
		this.icSony = icSony;
		
		pathDestino = diretorioDestino;
		
	}

	public boolean isTPRODUCTDATA(File arquivoOrigem) {
		if(arquivoOrigem.getName().contains("TPRODUCTDATA")) {
			return true;
		}
		return false;
	}
	
	/**
	 * Dado um arquivoOrigem, trata o arquivo, copia e retorna a versao tratada
	 * em memoria
	 * @param arquivoOrigem
	 * @return ArquivoSony
	 */
	public final ArquivoSony doJob(File arquivoOrigem) {
		
		// Checa o tipo de arquivo
		if(isTPRODUCTDATA(arquivoOrigem)) {
			
			return trataArquivoTPRODUCDATA(arquivoOrigem);
			
		} else if(arquivoOrigem.getName().contains("_TALARM")) {
			
			// 2018-01-10: alarmes nao estarao mais sendo coletados temporariamente
			// return trataArquivoTALARM(arquivoOrigem);
			
		} 
		return null;
	}
	
	public ArquivoSony doJob(String tipoArquivo, File arquivoReferencia) {
		if(tipoArquivo.contains("TDOWNTIME")) {
			return trataArquivoTDOWNTIME(arquivoReferencia);
		}
		log.error("TCopiaArquivoBD: if(tipoArquivo.contains(TDOWNTIME)) nao pego");
		return null;
	}


	private ArquivoSony trataArquivoTDOWNTIME(File arquivoReferencia) {
		if (prefixoArquivo == null || prefixoArquivo.equals("")) {
			log.error(idLog, 0, "TCopiaArquivo: Em trataArquivoTDOWNTIME, prefixoArquivo == null || prefixoArquivo.equals() na maquina: " + nomeMaquina);
			return null;
		}
		String nomeArquivo = prefixoArquivo + "TDOWNTIME.CSV";
		String absolutePath = arquivoReferencia.getAbsolutePath();
		String pathTratado = Paths.get(absolutePath).getParent().toString();
		File arquivo = new File(pathTratado + "//" + nomeArquivo );
		boolean tratarArquivo = false;
		
		if (!arquivo.exists()) {
			nomeArquivo = prefixoArquivo + "TDOWNTIME.csv";
			absolutePath = arquivoReferencia.getAbsolutePath();
			pathTratado = Paths.get(absolutePath).getParent().toString();
			arquivo = new File(pathTratado + "//" + nomeArquivo );
		}
		
		if (arquivo.exists()) {
			// Verifica se houve mudanca na data de ultima modificacao
//			if (icSony.getDatasTDownTime().containsKey(nomeMaquina)) {
//				Date ultimaModificacaoRegistrada = icSony.getDatasTDownTime().get(nomeMaquina);
//				Date ultimaModificacao = new Date(arquivo.lastModified());
//				
//				int comparacao = ultimaModificacao.compareTo(ultimaModificacaoRegistrada);
//				if (comparacao > 0) {
//					tratarArquivo = true;
//				}
//			} else {
//				// Se o arquivo nao esta na lista, e a primeira ocorrencia dele
//				tratarArquivo = true;
//				icSony.getDatasTDownTime().put(nomeMaquina, new Date(arquivo.lastModified()));
//			}
			tratarArquivo = true;
		} else {
			log.error("Arquivo " + nomeArquivo + " nao existe: arquivo.exists() != true");
		}
		
		if (tratarArquivo) {
			// tratar arquivo
			String nomeArquivoDestino = "tdowntime-" + nomeMaquina + ".csv";
			String arquivoDestino = pathDestino + "//" + nomeArquivoDestino;
			Path pathArquivoDestino = Paths.get(arquivoDestino);
			try {
				Files.copy(arquivo.toPath(), pathArquivoDestino, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				log.error(idLog, 0, "TCopiaArquivo: Erro ao copiar arquivo: " + arquivo.getName() + " Erro foi: " + e.toString());
				return null;
			}
			ArquivoSonyTDOWNTIME retorno = new ArquivoSonyTDOWNTIME(log);
			retorno.setNomeArquivo(nomeArquivoDestino);
			retorno.setPathArquivo(pathDestino);
			log.info(idLog, 0, "TCopiaArquivo: Arquivo: " + arquivo.getName() + " copiado com sucesso para a maquina: " +nomeMaquina+ " as:"  + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
			return retorno;
		}
		log.error("TCopiaArquivo: Ocorreu algum erro em trataArquivoTDOWNTIME da maquina: " + nomeMaquina);
		return null;
	}

	private ArquivoSony trataArquivoTALARM(File arquivoOrigem) {
		String nomeArquivoDestino = "alarmes-" + nomeMaquina + ".csv";
		String arquivoDestino = pathDestino + "//" + nomeArquivoDestino;
		//Path pathArquivoDestino = Paths.get(pathDestino + "//" + "alarmes-" + nomeMaquina + ".csv");
		Path pathArquivoDestino = Paths.get(arquivoDestino);
		try {
			Files.copy(arquivoOrigem.toPath(), pathArquivoDestino, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			log.error(idLog, 0, "TCopiaArquivo: Erro ao copiar arquivo: " + arquivoOrigem.getName() + " Erro foi: " + e.toString());
			return null;
		}
		// Tratamentos no arquivo copiado
		ArquivoSony retorno = realizaTratamentoTALARM(arquivoDestino);
		retorno.setNomeArquivo(nomeArquivoDestino);
		retorno.setPathArquivo(pathDestino);
		
		log.info(idLog, 0, "TCopiaArquivo: Arquivo: " + arquivoOrigem.getName() + " copiado com sucesso");
		return retorno;
		
		// Trecho utilizado quando o TALARM nao era tratado, era apenas copiado
		// O retorno deve ser null pq esse arquivo nao deve ter os eventos processado de forma alguma nesta etapa
		// return null;
	}


	private ArquivoSony trataArquivoTPRODUCDATA(File arquivoOrigem) {
		String nomeArquivoDestino = "eventos-" + nomeMaquina + ".csv";
		String arquivoDestino = pathDestino + "//" + nomeArquivoDestino;
		// Path pathArquivoDestino = Paths.get(pathDestino + "//" + "eventos-" + nomeMaquina + ".csv");
		Path pathArquivoDestino = Paths.get(arquivoDestino);
		try {
			Files.copy(arquivoOrigem.toPath(), pathArquivoDestino, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			log.error(idLog, 0, "TCopiaArquivo: Erro ao copiar arquivo: " + arquivoOrigem.getName() + " Erro foi: " + e.toString());
			return null;
		}
		
		// Tratamentos no arquivo copiado
		// Sao temporarios, a principio
		// Ailton 04/09/17: Tratamentos nao sao mais necessarios aqui
		// ArquivoSonyTPRODUCT retorno = realizaTratamentoTPRODUCTDATA(arquivoDestino);
		ArquivoSonyTPRODUCT retorno = new ArquivoSonyTPRODUCT(log);
		retorno.setNomeArquivo(nomeArquivoDestino);
		retorno.setPathArquivo(pathDestino);
		
		// Setando o prefixo
		String prefixoArquivoAux = arquivoOrigem.getName().replaceAll("TPRODUCTDATA.csv", "");
		prefixoArquivo = prefixoArquivoAux.replaceAll("TPRODUCTDATA.CSV", "");
		
		log.info(idLog, 0, "TCopiaArquivo: Arquivo: " + arquivoOrigem.getName() + " com prefixo: " + prefixoArquivo + " copiado com sucesso para a maquina: " 
				+ nomeMaquina + " as:"  + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
		
		return retorno;
	}
	
	
	private String removeCarriageReturnRaw (String loc) {
		File arq = new File(loc);
		char ch;
		String retorno = null;
		StringBuilder stringBuilderString = new StringBuilder();
	
		if (arq.exists()) {
			
			InputStream is;
			try {
				is = new FileInputStream(loc);
				try {
					int size = is.available();
					for(int i = 0; i < size; i++) {
						ch = (char)is.read();
			            if(ch == '\r') {
			            	//Ignora
			            }
			            else {
			            	stringBuilderString.append(ch);
						}
			         }
					 is.close();
					
				} catch (IOException e) {
					log.error("TCopiaArquivoBD: Erro ao removeCarriageReturnRaw: " + e);
					e.printStackTrace();
				}
				
			} catch (FileNotFoundException e) {
				log.error("TCopiaArquivoBD: Erro ao removeCarriageReturnRaw: " + e);
				e.printStackTrace();
			}
		}
		retorno = stringBuilderString.toString();
		return retorno;
	}
	
	private ArquivoSony realizaTratamentoTALARM(String loc) {
		ArquivoSonyTALARM retorno = null;
		File arq = new File(loc);
		List<String> fileLinhas = new ArrayList<String>();
		
		if (arq.exists()) {
			BufferedReader br = null;
			String linha = "";
			try {
				br = new BufferedReader(new FileReader(loc));
				while ((linha = br.readLine()) != null) {
					// linha.replaceAll("\r", "");
					fileLinhas.add(linha);
				}
				br.close();
				
				// Neste ponto, todo o conteudo do arquivo estÃ¡ en fileLinhas
				// Remove cabecalho
				fileLinhas.remove(0);
				
				// Ordenacao
				Collections.sort(fileLinhas, new Comparator<String>() {
					
					@Override
					public int compare(String o1, String o2) {
						String array1[] = o1.split(",");
				        String array2[] = o2.split(",");
				        Date date1 = null;
				        Date date2 = null;
				        
				        try {
							date1 = UtilsString.convertToDateLogSony(UtilsString.removeApas(array1[0]));
							date2 = UtilsString.convertToDateLogSony(UtilsString.removeApas(array2[0]));
							
						} catch (Exception e) {
							log.info(idLog, 0, "TrataLogSony: Falha na ordenacao do TALARM; Erro: " + e);
						}
						return date1.compareTo(date2);
					}
				});
				
				// Salva
				try {
					BufferedWriter brW = new BufferedWriter(new FileWriter(loc));
					for (String string : fileLinhas) {
						brW.append(string + "\n");
					}
					brW.close();
				} catch (FileNotFoundException e) {
					retorno = null;
					e.printStackTrace();
				} catch (IOException e) {
					retorno = null;
					e.printStackTrace();
				}
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				log.info(idLog, 0, "TrataLogSony: Erro: " + e);
			} catch (IOException e) {
				e.printStackTrace();
				log.info(idLog, 0, "TrataLogSony: Erro: " + e);
			}
			
			retorno = new ArquivoSonyTALARM(log, fileLinhas);
		}
		
		
		return retorno;
	}
	
private ArquivoSonyTPRODUCT realizaTratamentoTPRODUCTDATA(String loc) {
		
		ArquivoSonyTPRODUCT retorno = null;

		String arquivoRaw = removeCarriageReturnRaw(loc);

		List<String> fileLinhas = new ArrayList<String>();

		if (arquivoRaw != null && !arquivoRaw.equals("")) {

			String[] arquivoRawSplitted = arquivoRaw.split("\n");

			if (arquivoRawSplitted != null && arquivoRawSplitted.length > 0) {

				for (String linha : arquivoRawSplitted) {
					try {
						if (linha.split(",").length >= 537)
							fileLinhas.add(linha);
					} catch (Exception e) {
						log.error("TCopiaArquivoBD: Erro ao remover \\r ");
						e.printStackTrace();
					}
				}
				// Neste ponto, todo o conteudo do arquivo estÃ¡ en fileLinhas
				// Remove cabecalho
				// int size = fileLinhas.size();
				fileLinhas.remove(0);

				// Ailton 04/09/17
				// Ordenacao nao e mais necessaria
				// Ordenacao
//				Collections.sort(fileLinhas, new Comparator<String>() {
//
//					@Override
//					public int compare(String o1, String o2) {
//						String array1[] = o1.split(",");
//						String array2[] = o2.split(",");
//						Date date1 = null;
//						Date date2 = null;
//
//						try {
//							date1 = UtilsString.convertToDateLogSony(UtilsString.removeApas(array1[0]));
//							date2 = UtilsString.convertToDateLogSony(UtilsString.removeApas(array2[0]));
//
//						} catch (Exception e) {
//							log.info(idLog, 0, "TrataLogSony: Falha na ordenacao do TALARM; Erro: " + e);
//						}
//						return date1.compareTo(date2);
//					}
//				});

				// Salva
				try {
					BufferedWriter brW = new BufferedWriter(new FileWriter(loc));
					for (String string : fileLinhas) {
						brW.append(string + "\n");
					}
					brW.close();
					//retorno = new ArquivoSonyTPRODUCT(log, fileLinhas);
					retorno = new ArquivoSonyTPRODUCT(log);
				} catch (FileNotFoundException e) {
					retorno = null;
					e.printStackTrace();
				} catch (IOException e) {
					retorno = null;
					e.printStackTrace();
				}
			}

		}
		return retorno;
	}
	
// ****************** METODOS DESCONTINUADOS OU OBSOLETOS
//	private ArquivoSonyTPRODUCT realizaTratamentoTPRODUCTDATA(String loc) {
//		
//		removeCarriageReturn(loc);
//		
//		ArquivoSonyTPRODUCT retorno = null;
//		
//		File arq = new File(loc + "Out.csv");
//		
//		List<String> fileLinhas = new ArrayList<String>();
//		if (arq.exists()) {
//			BufferedReader br = null;
//			String linha = "";
//			try {
//				br = new BufferedReader(new FileReader(loc + "Out.csv"));
//				while ((linha = br.readLine()) != null) {
//					linha.replaceAll("\r", "");
//					try {
//						if (linha.split(",").length >= 537)
//							fileLinhas.add(linha);
//					} catch (Exception e) {
//						log.error("TCopiaArquivoBD: Erro ao remover \\r ");
//						e.printStackTrace();
//					}
//				}
//				br.close();
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//				log.info(idLog, 0, "TrataLogSony: Erro: " + e);
//			} catch (IOException e) {
//				e.printStackTrace();
//				log.info(idLog, 0, "TrataLogSony: Erro: " + e);
//			}
//			
//			// Neste ponto, todo o conteudo do arquivo estÃ¡ en fileLinhas
//			// Remove cabecalho
//			// int size = fileLinhas.size();
//			fileLinhas.remove(0);
//			
//			// Ordenacao
//			Collections.sort(fileLinhas, new Comparator<String>() {
//				
//				@Override
//				public int compare(String o1, String o2) {
//					String array1[] = o1.split(",");
//			        String array2[] = o2.split(",");
//			        Date date1 = null;
//			        Date date2 = null;
//			        
//			        try {
//						date1 = UtilsString.convertToDateLogSony(UtilsString.removeApas(array1[0]));
//						date2 = UtilsString.convertToDateLogSony(UtilsString.removeApas(array2[0]));
//						
//					} catch (Exception e) {
//						log.info(idLog, 0, "TrataLogSony: Falha na ordenacao do TALARM; Erro: " + e);
//					}
//					return date1.compareTo(date2);
//				}
//			});
//			
//			// Salva
//			try {
//				BufferedWriter brW = new BufferedWriter(new FileWriter(loc));
//				for (String string : fileLinhas) {
//					brW.append(string + "\n");
//				}
//				brW.close();
//				retorno = new ArquivoSonyTPRODUCT(log, fileLinhas);
//			} catch (FileNotFoundException e) {
//				retorno = null;
//				e.printStackTrace();
//			} catch (IOException e) {
//				retorno = null;
//				e.printStackTrace();
//			}
//		}
//		return retorno;
//	}


/**
 * Tem alto custo computacional,
 * mas vai ser usado temporariamente apenas
 * Ate o script da sony estar ok
 * @param loc
 */
//private void removeCarriageReturn (String loc) {
//	File arq = new File(loc);
//	byte ch;
//
//	if (arq.exists()) {
//		
//		InputStream is;
//		OutputStream os;
//		try {
//			is = new FileInputStream(loc);
//			os = new FileOutputStream(loc + "Out.csv");
//			try {
//				int size = is.available();
//				for(int i = 0; i < size; i++) {
//					ch = (byte)is.read();
//		            if((char)ch == '\r') {
//		            	os.write(new String("").getBytes());
//		            }
//		            else {
//						os.write(ch);
//					}
//		         }
//				 os.close();
//				 is.close();
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}


}
