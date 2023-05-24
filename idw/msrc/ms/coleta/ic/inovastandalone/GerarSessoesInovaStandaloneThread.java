package ms.coleta.ic.inovastandalone;

import idw.model.pojos.MsMs;
import idw.model.pojos.MsMsicup;
import idw.model.pojos.OmCfg;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.util.ZipDirectory;
import injetws.model.IwsFacade;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ms.coleta.ic.inovastandalone.transferirarquivos.TransferirParaInovaSAFactory;
import ms.coleta.ic.inovastandalone.transferirarquivos.TransferirParaInovaSARevisao;
import ms.model.rn.MsRN;

import org.hibernate.Session;

public class GerarSessoesInovaStandaloneThread extends Thread{

	private boolean isPararThread = false;
	private IdwLogger log;
	private String dirDestino;

	@Override
	public void run() {
		dirDestino=IwsFacade.getRealRootPath();
		log = new IdwLogger("TransferenciaParaUnoThread");
		log.info("Inicializando TransferenciaParaUnoThread");
		MsRN rn = null;
		OmCfg omcfg = null;
		while (isPararThread == false) {
			// Obtem a lista de registros que devem ser atualizados
			rn = new MsRN();
			List<String> dirParaZipar = new ArrayList<String>();
			long fNanoTime = 0;
			long iNanoTime = System.nanoTime();
			
			try {
				rn.iniciaConexaoBanco();
	
				omcfg = Util.getConfigGeral(rn.getSession());
	
				List<MsMs> lista = rn.pesquisarMsMsByAtivas();
				log.info("Qtde registros para transferencia " + lista.size());
	
				// Primeiro apagar os diretorios existentes
				for (MsMs msms : lista) {
					for (MsMsicup msmsicup : msms.getMsMsicups()) {
						apagarDiretorio(msmsicup.getMsIc().getUrlConexao());
						sleep(1);
					}
				}

				// Gerar os arquivos necessarios
				for (MsMs msms : lista) {
					List<MsMsicup> msmsicups = new ArrayList<MsMsicup>();
					msmsicups.addAll(msms.getMsMsicups());
					dirParaZipar.addAll(geraSessaoParaListaMsMsicups(msmsicups, omcfg, rn.getSession()));
					sleep(1000);
				}
				
				try {
					zipListaDiretorios(dirParaZipar, log);
				}catch (Exception e) {
					// Tentativa de descobrir porque a thread est� morrendo
					e.printStackTrace();
					log.info("Erro no ZIP", e);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					rn.finalizaConexaoBanco();
				} catch (Exception e){
					e.printStackTrace();
				}
				rn = null;
				dirParaZipar = null;
			}
			fNanoTime = System.nanoTime();
			
			long sleepTimeSeg = (fNanoTime - iNanoTime)/1000000000;
			
			sleepTimeSeg = sleepTimeSeg > 120 ? 0 : 120 - sleepTimeSeg;
			log.info("Finalizou transferencia registros " + sleepTimeSeg + "s");

			try {
				for(int i=0; i< sleepTimeSeg; i++) {
					String icIp = InovaSAStartingUpManager.getInstancia().getInovaSAIP();
					if(icIp == null) {
						sleep(1000);
						continue;
					}
					
					iNanoTime = System.nanoTime();
					
					rn = new MsRN();
					dirParaZipar = new ArrayList<String>();
					try {
						rn.iniciaConexaoBanco();
						omcfg = Util.getConfigGeral(rn.getSession());
						while(icIp != null) {
							apagarDiretorio(icIp);
							ArquivosDiretorios.delete(dirDestino + icIp + ".zip");
							
							List<MsMsicup> msmsicups = rn.pesquisarMsMsicupsByIcUrlConexao(icIp);
							
							dirParaZipar.addAll(geraSessaoParaListaMsMsicups(msmsicups, omcfg, rn.getSession()));

							icIp = InovaSAStartingUpManager.getInstancia().getInovaSAIP();
						}
						
						try {
							zipListaDiretorios(dirParaZipar, log);
						}catch (Exception e) {
							// Tentativa de descobrir porque a thread est� morrendo
							e.printStackTrace();
							log.info("Erro no ZIP", e);
						}
					} catch(Exception e) {
						e.printStackTrace();
					} finally {
						try{
							rn.finalizaConexaoBanco();
						} catch(Exception e) {
							e.printStackTrace();
						}
						rn = null;
						dirParaZipar = null;
					}
					fNanoTime = System.nanoTime();
					i += (fNanoTime - iNanoTime)/1000000;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		log.info("Finalizando TransferenciaParaUnoThread");
	}

	public List<String> geraSessaoParaListaMsMsicups(List<MsMsicup> msmsicups, OmCfg omcfg, Session session) {
		List<String> dirParaZipar = new ArrayList<String>();
		for  (MsMsicup msmsicup : msmsicups) {
			
			// Gerar as sessoes apenas para os ICs do tipo inova standalone
			if (msmsicup.getMsIc().getTpIc() == null || msmsicup.getMsIc().getTpIc().equals(new BigDecimal(8)) == false)
				continue;

			// Gerar 1o as sessoes
			String diretorio = gerarArquivoPara(TransferirParaInovaSAFactory.TpArquivo._SESSAO.getValue(), msmsicup, omcfg, session);
			if(diretorio != null){
				if(dirParaZipar.contains(diretorio) == false){
					dirParaZipar.add(diretorio);

					// Gerar arquivo com a identificacao da revisao para o clp ao final de todo o processo
					gerarArquivoParaRevisao(msmsicup);
				}
				
			}
		}
		return dirParaZipar;
	}
	
	public void zipListaDiretorios(List<String> dirParaZipar, IdwLogger log) {
		// Compactando os arquivos para transferencia ao InovaSA
		for (String dir : dirParaZipar) {
			log.info("Compactando " + dir);

			List<File> fileList = new ArrayList<File>();
			File fil = new File(dir);
			
			if (fil != null && fileList != null) {
				ZipDirectory.getAllFiles(fil, fileList);
				ArquivosDiretorios.delete(fil.getPath() + ".tmp");
				ArquivosDiretorios.delete(fil.getPath() + ".zip");
				ZipDirectory.writeZipFile(fil, fileList, false);
			} else {
				log.info("NAO GEROU ZIP fil=" + fil + " fileList=" + fileList);
				//System.out.println("NAO GEROU ZIP fil=" + fil + " fileList=" + fileList);
			}
			
		}
	}
	
	public void pararThread(){
		this.isPararThread = true;
	}

	private void gerarArquivoParaRevisao(MsMsicup msmsicup) {
		TransferirParaInovaSAFactory rn = new TransferirParaInovaSARevisao(msmsicup, log, dirDestino);
		rn.criarArquivo();
	}

	private void apagarDiretorio(String urlConexao){
		try {
			urlConexao = "/" + urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (StringIndexOutOfBoundsException e) {
			urlConexao = "/" + urlConexao;
		}
		ArquivosDiretorios.delete(dirDestino + urlConexao);
	}

	private String gerarArquivoPara(byte tipoArquivo, MsMsicup msmsicup, OmCfg omcfg, Session session){
		TransferirParaInovaSAFactory rn = TransferirParaInovaSAFactory.getInstancia(tipoArquivo, msmsicup, omcfg, dirDestino, log, session);
		if(rn.getMsmsicup().equals(msmsicup)){
			rn.criarArquivo();
			rn.criarArquivoStatus();
		}


		String urlConexao = msmsicup.getMsIc().getUrlConexao();
		try {
			urlConexao = urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (StringIndexOutOfBoundsException e) {
			urlConexao = msmsicup.getMsIc().getUrlConexao();
			return dirDestino + "/" + urlConexao;
		}
		return null;
	}
}
