package ms.coleta.ic.flex;


import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.EmailException;

import idw.model.pojos.OmPromidia;
import idw.model.pojos.OmPt;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.util.ArquivosDiretorios;
import idw.util.EnviarEmail;
import idw.util.IdwLogger;
import idw.util.UtilsString;
import ms.coleta.MSThread;
import ms.coleta.Stubedelegate;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
import ms.model.dto.UpDTO;
import ms.model.rn.MsRN;

public class ThreadScriptPadrao {
//	private boolean isExecutando = true;
	private final IdwLogger log;
	private final int idLog;
	private final IcUpDTO icup;

	private String trechoPadrao;
	private String trechoExecutado;
	private String trechoDiferente;
	
	public ThreadScriptPadrao(IdwLogger log, int idLog, IcUpDTO icup) {
		super();
		this.log = log;
		this.idLog = this.log.getIdAleatorio();
		this.icup = icup;
//		setName("ThreadScriptPadrao-" + icup.getUpDTO().getCd_up());
	}

	// comentado pois nao eh mais thread
//	public void run() {
//		log.info(idLog, 0, "ThreadScriptPadrao.run() para " + icup.getUpDTO().getCd_up());
//		while (isExecutando) {
//			// Avaliar o script padrao se for  o caso
//			avaliarScriptPadrao();
//			UtilsThreads.pausaNaThread(3600000);
//		}
//		log.info(idLog, 0, "Finalizando ThreadScriptPadrao.run() para " + icup.getUpDTO().getCd_up());
//
//	}
//	
	
	public static void main(String[] args) {
		IdwLogger log = new IdwLogger("testeScriptPadrao");
		int idLog = log.getIdAleatorio();
		IcUpDTO icup = new IcUpDTO();
		OmPt ompt = new OmPt();

		MsRN msrn = new MsRN();
		MSThread ms = new MSThread("C:/idwtemp/");
		Stubedelegate.getInstancia().setMsthread(ms);
		
		PTRN prn = new PTRN();
		
		try {
			msrn.iniciaConexaoBanco();
			prn.setDao(msrn.getDao());
			
			ompt = prn.getOmPt("TX_03_LIN04");
			
			OmPromidia ompromidia = msrn.inicializarScriptPadrao(ompt);
			// obtem o script
			if (ompromidia != null) {
				icup.setScriptTeste(new StringBuilder(new String(ompromidia.getMidia())));
				icup.setNomeArquivoScript(ompromidia.getDsPromidia());
				icup.setExtensaoArquivoScript(ompromidia.getExtensaoArquivo());
			}
			icup.setUrlAuxiliar("C:/arquivos_log_flex/" + ompt.getCdPt());
			
			UpDTO up = new UpDTO();
			up.setCd_up(ompt.getCdPt());
			icup.setUpDTO(up);
			
			IcDTO ic = new IcDTO();
			icup.setIc(ic);
			
			ThreadScriptPadrao nr = new ThreadScriptPadrao(log, idLog, icup);
			
			nr.avaliarScriptPadrao();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			msrn.finalizaConexaoBanco();
		}
	}

	/* Metodo principal para avaliar o script padrao
	 * 
	 */
	public void avaliarScriptPadrao() {
		// Se a url auxiliar tiver sido definida entao o script padrao deve ser avaliado
		if (
				icup.getUrlAuxiliar() != null && icup.getUrlAuxiliar().trim().equals("") == false &&
				icup.getNomeArquivoScript() != null && icup.getNomeArquivoScript().trim().equals("") == false &&
				icup.getExtensaoArquivoScript() != null && icup.getExtensaoArquivoScript().trim().equals("") == false &&
				icup.getScriptTeste() != null) {
			
			
			// Copiar arquivo de testes atual para o servidor
			String dirDestino = Stubedelegate.getInstancia().getMsthread().getPathCacheColeta();
			String arquivoDestino = dirDestino + icup.getUpDTO().getCd_up() + "/" + icup.getNomeArquivoScript();
			String arquivoOrigem = icup.getUrlAuxiliar() + "/" + icup.getNomeArquivoScript();
			
			// Se as datas de modificacoes forem as mesmas entao nao se deve copiar novamente o arquivo,
			// mas se deve avaliar se sao iguais
			Date dthrOrigem = ArquivosDiretorios.getDtHrModificacao(arquivoOrigem, this.icup.getIc().getLoginAD(), this.icup.getIc().getSernhaAD());
			Date dthrDestino = ArquivosDiretorios.getDtHrModificacao(arquivoDestino);
			if (DataHoraRN.equal(dthrOrigem, dthrDestino) == false) {
				try {
					ArquivosDiretorios.copiarArquivo(arquivoOrigem, Paths.get(arquivoDestino), this.icup.getIc().getLoginAD(), icup.getIc().getSernhaAD());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.info(idLog, 0, e);
				}
			}
			
			// Colocar em memoria o arquivo copiado
			String scriptEmExecucao = null;
			try {
				scriptEmExecucao = ArquivosDiretorios.lerArquivo(arquivoDestino);
			} catch (Exception e1) {
				e1.printStackTrace();
				log.info(idLog, 0, e1);
				scriptEmExecucao = e1.getMessage();
			}
			
			// Comparar arquivo copiado com o arquivo padrao
			if (scriptEmExecucao != null && isScriptPadraoValido(scriptEmExecucao, icup.getScriptTeste().toString()) == false) {
				log.info(idLog, 0, "Script padrão alterado. Enviando emails para " + icup.getIc().getEmailsScriptPadraoNC());
				// Incluir envento para disparo de email pela monitorizacao
				List<String> emails = UtilsString.quebrarStringEmVetor(icup.getIc().getEmailsScriptPadraoNC(), ";");
				if (emails.isEmpty() == false) {
					try {
						StringBuilder assunto = new StringBuilder();
						assunto.append("Script de teste fora do padrão - ");
						assunto.append(this.icup.getUpDTO().getCd_up());
						
						StringBuilder conteudo = new StringBuilder();
						conteudo.append("Script esperado: ");
						conteudo.append(this.icup.getScriptTeste());
						conteudo.append(" Script encontrado: ");
						conteudo.append(scriptEmExecucao.toString());
						
						conteudo.append("\nAbaixo resultado da comparação:");
						conteudo.append("\npadrao:  \n");
						conteudo.append(trechoPadrao);
						conteudo.append("\ncorrente:\n");
						conteudo.append(trechoExecutado);
						conteudo.append("\ndifere:  \n");
						conteudo.append(trechoDiferente);
						
						
						EnviarEmail.enviarEmail(
								emails, 
								assunto.toString(), 
								conteudo.toString(),
								icup.getNomeArquivoScript(),
								arquivoOrigem);
					} catch (EmailException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						log.info(idLog, 0, e);
					}
				}
			} else {
				log.info(idLog, 0, "Script padrão sem alterações");
			}
			
			scriptEmExecucao = null;
			arquivoOrigem = null;
			arquivoDestino = null;
			dirDestino = null;
		} else {
			log.info(idLog, 0, "Script padrão não configurado. urlAux=" + icup.getUrlAuxiliar() + " nomeArq=" + icup.getNomeArquivoScript() + " ext=" + icup.getExtensaoArquivoScript() + " scri=" + (icup.getScriptTeste() != null) );
		}
	}

	/* Metodo para avaliar se o script executado esta dentro do padrao
	 * 
	private boolean isScriptPadraoValido(String atual, String padrao) {
		// Remover todoso os ENTER dos dois arquivos antes de comparar
		atual = atual.replaceAll("\n", "");
		atual = atual.replaceAll("\r", "");
		atual = atual.replaceAll(" ", "");
		atual = atual.replaceAll("\t", "");

		padrao = padrao.replaceAll("\n", "");
		padrao = padrao.replaceAll("\r", "");
		padrao = padrao.replaceAll(" ", "");
		padrao = padrao.replaceAll("\t", "");
		
		
		// Se a tag <inicio-desconsiderar> existir é pq o script eh para os postos que realizam calibracao e precisam modificar o script
		if (padrao.contains("<inicio-desconsiderar>")) {
			// Compara o inicio do script ate a 1a tag
			int inicioTag = padrao.indexOf("<inicio-desconsiderar>");
			int fimTag = padrao.indexOf("<fim-desconsiderar>");
			fimTag += 19;
			
			String atualInicio = atual.substring(0, inicioTag);
			String padraoInicio = padrao.substring(0, inicioTag);

			if (atualInicio.equals(padraoInicio) == false) {
				trechoPadrao = padraoInicio;
				trechoExecutado = atualInicio;
				trechoDiferente = StringUtils.difference(trechoPadrao, trechoExecutado);

				int colDif = trechoExecutado.indexOf(trechoDiferente);
				String espacos = StringUtils.repeat(" ", colDif);
				trechoDiferente = espacos + trechoDiferente;
				System.out.println("PRE - padrao     " + trechoPadrao);
				System.out.println("PRE - executados " + trechoExecutado);
				System.out.println("PRE - diferencas "+ trechoDiferente);
				System.out.println("coluna dif.:" + colDif);
				return false;
			}

			// Verifica se o final esta igual
			if (atual.endsWith(padrao.substring(fimTag)) == false) {
				trechoPadrao = padrao.substring(fimTag);
				trechoExecutado = atual.substring(atual.length() - trechoPadrao.length());
				trechoDiferente = StringUtils.difference(trechoPadrao, trechoExecutado);

				String espacos = StringUtils.repeat(" ", trechoExecutado.indexOf(trechoDiferente));
				trechoDiferente = espacos + trechoDiferente;
				System.out.println("POS - padrao     " + trechoPadrao);
				System.out.println("POS - executados " + trechoExecutado);
				System.out.println("POS - diferencas "+ trechoDiferente);

				return false;
			}
			
			return true;
		}
		
		trechoExecutado = atual;
		trechoPadrao = padrao;
		
		boolean isretorno = atual.equals(padrao);
		
		if (isretorno == false) {
			trechoDiferente = StringUtils.difference(padrao, atual);
			// Acrescenta espacos em branco na frente do trecho diferente para facilitar a localizacao da diferenca
			String espacos = StringUtils.repeat(" ", atual.indexOf(trechoDiferente));
			trechoDiferente = espacos + trechoDiferente;
			System.out.println("padrao     " + trechoPadrao);
			System.out.println("executados " + trechoExecutado);
			System.out.println("diferencas "+ trechoDiferente);
		}
		
		return isretorno;
	}
	 */

	// Nao eh mais thread
//	public void finalizar() {
//		this.isExecutando = false;
//	}

	
//	public static void main(String[] args) {
//		StringBuilder padrao = new StringBuilder();
//		StringBuilder atual = new StringBuilder();
//		ThreadScriptPadrao rn = new ThreadScriptPadrao();
//		
//		padrao.append("1234");
//		atual.append("1234");
//		
//		boolean isRetorno = true; // = rn.isScriptPadraoValido2(atual.toString(), padrao.toString());
//		System.out.println("=" + isRetorno);
//		
//		padrao.append("<inicio-desconsiderar>");
//		padrao.append("desconsiderar");
//		padrao.append("<fim-desconsiderar>");
//		padrao.append("novo inicio");
//		padrao.append("<inicio-desconsiderar>");
//		padrao.append("desconsiderar");
//		padrao.append("<fim-desconsiderar>");
//		padrao.append("novo final");
//		
//		atual.append("desconsiderar2");
//		atual.append("novo inicioa");
//		
//		isRetorno = rn.isScriptPadraoValido2(atual.toString(), padrao.toString());
//		System.out.println("=" + isRetorno);
//		
//	}
	
	
	public boolean isScriptPadraoValido(String atual, String padrao) {
		atual = atual.replaceAll("\n", "");
		atual = atual.replaceAll("\r", "");
		atual = atual.replaceAll(" ", "");
		atual = atual.replaceAll("\t", "");

		padrao = padrao.replaceAll("\n", "");
		padrao = padrao.replaceAll("\r", "");
		padrao = padrao.replaceAll(" ", "");
		padrao = padrao.replaceAll("\t", "");

		// Varre o script padraõ para identificar todas as tags <inicio-desconsiderar>
		String padraoAux = padrao;
		String atualAux = atual;
		do {
			int inicio = padraoAux.indexOf("<inicio-desconsiderar>");
			String padraoParcial;
			String atualParcial;
			if (inicio >= 0) {
				padraoParcial = padraoAux.substring(0, inicio);
				atualParcial = atualAux.substring(0, inicio);
			} else {
				padraoParcial = padraoAux;
				atualParcial = atualAux;
			}
			
			// Verifica se os trechos são iguais
			if (padraoParcial.equals(atualParcial) == false) {
				trechoPadrao = padraoParcial;
				trechoExecutado = atualParcial;
				trechoDiferente = StringUtils.difference(trechoPadrao, trechoExecutado);

				String espacos = StringUtils.repeat(" ", trechoExecutado.indexOf(trechoDiferente));
				trechoDiferente = espacos + trechoDiferente;

				log.info("padrao    :" + trechoPadrao);
				log.info("executados:" + trechoExecutado);
				log.info("diferencas:"+ trechoDiferente);

				return false;
			}
			
			// Inicia novo arquivo com novas referencias
			int fim = padraoAux.indexOf("<fim-desconsiderar>");
			if (fim >= 0) {
				fim += 19;
				
				padraoAux = padraoAux.substring(fim);  // novo arquivo padrao
				atualAux = atualAux.substring(inicio); // atualAux descarta o trecho inicial a fim de nesse novo trecho procurar uma referencia de inicio do proximo trecho a ser avalaido
				
				// Procura nova refernecia para avaliacao
				int inicioProximaReferencia = 10;
				if (padraoAux.length() < 10) {
					inicioProximaReferencia = padraoAux.length();
				}
				inicioProximaReferencia = atualAux.indexOf(padraoAux.substring(0, inicioProximaReferencia)); // usa os 10 primeiros caracateres como referencia para encontrar o proximo trecho
				if (inicioProximaReferencia >= 0)
					atualAux = atualAux.substring(inicioProximaReferencia);
			}			
		} while (padraoAux.indexOf("<inicio-desconsiderar>") >= 0);
		
		// Testa o ultimo trecho
		if (padraoAux.equals(atualAux) == false) {
			trechoPadrao = padraoAux;
			trechoExecutado = atualAux;
			trechoDiferente = StringUtils.difference(trechoPadrao, trechoExecutado);
			String espacos = StringUtils.repeat(" ", trechoExecutado.indexOf(trechoDiferente));
			trechoDiferente = espacos + trechoDiferente;

			log.info("padrao    :" + trechoPadrao);
			log.info("executados:" + trechoExecutado);
			log.info("diferencas:"+ trechoDiferente);
			return false;
		}
		
		System.out.println("padrao: " + padrao);
		System.out.println("atual : " + atual);
		return true;
	}
	
	

}
