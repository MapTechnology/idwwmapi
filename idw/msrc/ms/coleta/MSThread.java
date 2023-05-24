package ms.coleta;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.util.UtilsString;
import ms.coleta.dto.AndonDTO;
import ms.coleta.dto.ClienteRegistrado;
import ms.coleta.servico.ServicoFactory;
import ms.coleta.tcp.UtilsTcp;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
import ms.model.dto.IhmDTO;
import ms.model.dto.MsDTO;
import ms.model.dto.UpIhmDTO;
import ms.util.UtilsThreads;

public class MSThread extends Thread{
	private IdwLogger log;
	private boolean isThreadExecutando = true;
	private MsDTO msdto = new MsDTO();
	private List<IcDTO> threadsCriadas = new CopyOnWriteArrayList<IcDTO>();
	private boolean isPrimeiraExecucao = true;
	private int idLog;
	private int identacao = 0;
	private String pathCacheColeta;

	public MSThread(String pathCacheColeta) {
		this.log = new IdwLogger("MSThread");
		this.setName("MSThread-" + DataHoraRN.dateToStringYYYYMMDDHHMMSSms(DataHoraRN.getDataHoraAtual()));
		this.pathCacheColeta = pathCacheColeta;
	}


	@Override
	public void run() {
		idLog = log.getIdAleatorio();
		int identacao = 5;
		// Loop infinito para thread do MS
		while (this.isThreadExecutando == true){
			
			log.info(idLog, 0, "INICIALIZANDO MSTHREAD");
			try {

		        // Obtem dados do MS que ira ser executado. Esses dados sao procurados pela lista de MACs ou de IPs
		        inicializarMSDTO();

		        // Ordenar os ICs pelo Id. Nao vejo necessidade desse passo
		        Collections.sort(msdto.getIcsColetados(), new Comparator<IcUpDTO>() {
		        	@Override
					public int compare(IcUpDTO o1, IcUpDTO o2) {
		        		IcUpDTO p1 = o1;
		        		IcUpDTO p2 = o2;
		    			return (p1.getIc().getIdIc() < p2.getIc().getIdIc() ? -1 : p1.getIc().getIdIc() > p2.getIc().getIdIc() ? +1 : 0);
		    		}
		        });


		        // Marcando para remocao todas as threads. Entretando aquelas que ainda continuam no cadastro permanecerao
		        for (Iterator<IcDTO> itc = threadsCriadas.iterator() ; itc.hasNext() ; ){
		        	IcDTO tc = itc.next();
	        		tc.setRemoverThread(true);
	        		//Alexandre 13/06/2016 - IcUpDTOs dentro da lista threadCriadas nao estavam sendo inicializados com isUpSendoTratada=false,
	        		//logo IcUpDTOs removidos do MS nunca eram excluidos.
	        		for(Iterator<IcUpDTO> iIcupdto = tc.getMsIcUpDTOLocais().iterator() ; iIcupdto.hasNext() ; ) {
	        			IcUpDTO icupdto = iIcupdto.next();
	        			icupdto.setIsUpSendoTratada(false);
        				UtilsThreads.pausaNaThread(2l);
	        		}
	        	}


		        // Marca as thread que ainda tem UP ou inicia novas threads
		        for (Iterator<IcUpDTO> iIcupdto = msdto.getIcsColetados().iterator() ; iIcupdto.hasNext() ; ){
		        	IcUpDTO icupdto = iIcupdto.next();
		        	boolean isUpExisteNaListaDeThreads=false;
		        	icupdto.setIsUpSendoTratada(false);

		        	// O if abaixo sempre eh TRUE ver comentario do metodo
		        	if(icupdto.isThreadExclusivaParaColetarOIC() == true){

		        		// Verifica se o IC ainda deve ser monitorizado
			        	for (Iterator<IcDTO> itc = threadsCriadas.iterator() ; itc.hasNext() ; ){
			        		IcDTO tc = itc.next();

			        		/* Se o IC permanece entao verificar se o tipo dele ainda eh o mesmo. Se o tipo mudar, entao
			            	 * os metodos de finalizacao e inicializa�ao devem ser chamados
			            	 */
			        		if ( tc.getIdIc().equals(icupdto.getIc().getIdIc()) && tc.getTp_ic().equals(icupdto.getIc().getTp_ic()) ) {
			        			
//				        		log.info(idLog, identacao, "IGUAIS tc.getIdIc=" + tc.getIdIc() + " com icupdto.getIc=" + icupdto.getIc().getIdIc() + " e tc.tpIc=" + tc.getTp_ic() + " com icupdto.tpIc=" + icupdto.getIc().getTp_ic());
			        			
				        		/* Ja que nao teve mudanca no tipo, verificar se teve mudanca na urlconexao da UP
				        		 * entao devemos interagir sobre os registros das ups do ic
				        		 */
			        			boolean isMudou = false;
			        			for (Iterator<IcUpDTO> iIcupAux = tc.getMsIcUpDTOLocais().iterator() ; iIcupAux.hasNext() ; ) {
			        				IcUpDTO icupAux = iIcupAux.next();
			        				if (icupAux.getUpDTO().getCd_up().equals(icupdto.getUpDTO().getCd_up())) {
			        					
			        					// Avalia se algum dos parametros abaixo mudou. O idup é testado pois o coleta concentrador inova manda esse idup ao inves de cdup
			        					if ( (icupAux.getUrlConexao() == null && icupdto.getUrlConexao() == null) ||
			        						 (icupAux.getUrlConexao().equals(icupdto.getUrlConexao()) == false)  ||
			        						 (icupAux.getUpDTO().getIdUp().compareTo(icupdto.getUpDTO().getIdUp()) != 0)
			        						 ) {
			        						log.info(idLog, identacao, "a thread sera parada e recriada <> em icupAux.getUrlConexao " + icupAux.getUrlConexao() + " e icupdto.getUrlConexao=" + icupdto.getUrlConexao() + " idUp = " + icupAux.getUpDTO().getIdUp() + " = " + icupdto.getUpDTO().getIdUp());
				        					isMudou = true;
				        					break;
			        					}
			        				}
			        				UtilsThreads.pausaNaThread(2l);
			        			}
			        			if ( isMudou == false ) {
//			        				log.info(idLog,  identacao, "Nao mudou o cadastrado para up " + icupdto.getUpDTO().getCd_up());
					            	icupdto.setIsUpSendoTratada(true);
					            	tc.setRemoverThread(false);
					            	isThreadExecutando=true;
					            	//Atualiza dados de Up
					            	tc.addOrSetIcUpDTO(icupdto);
					            	tc.obtemThreadGerenciadora().setOmcfg(msdto.getOmcfg());
					            	isUpExisteNaListaDeThreads=true;
			        			} else {
			        				log.info(idLog, identacao, "MUDOU o cadastro para a up  "+ icupdto.getUpDTO().getCd_up());
			        			}
			        		}
	        				UtilsThreads.pausaNaThread(2l);
			        	}

			        	// Se for um IC novo entao inicia nova thread. Se o tipo do IC mudar tambem uma nova thread deve ser iniciada pois a anterior sera parada mais adiante
			        	if(isUpExisteNaListaDeThreads == false){
		        			log.info(idLog, identacao, "O IC " + icupdto.getIc().getIdIc() + " - " + icupdto.getIc().getCd_ic() + " NAO existe. Criando nova thread para UP " + icupdto.getUpDTO().getCd_up());
			        		IcDTO dadosIcDTO = icupdto.getIc();
			        		icupdto.setIsUpSendoTratada(true);
			        		dadosIcDTO.setRemoverThread(false);
			        		dadosIcDTO.addOrSetIcUpDTO(icupdto);


							ICThread clientThread = new ICThread(dadosIcDTO);
							clientThread.setOmcfg(msdto.getOmcfg());

							clientThread.start();
							dadosIcDTO.mudaThreadGerenciadora(clientThread);
		                    threadsCriadas.add(dadosIcDTO);
			        	}
		        	}
    				UtilsThreads.pausaNaThread(2l);
		        }


		        // O for abaixo deve iniciar dados de ANDON mas acredito q nao esteja servindo para nada
		        for (Iterator<IcDTO> itc = threadsCriadas.iterator() ; itc.hasNext() ; ){
		        	IcDTO tc = itc.next();
	        		if(tc.isRemoverThread() == false)
	        			tc.executaServicoAndonHeartbeat(tc.getInterfaceAdam());
    				UtilsThreads.pausaNaThread(2l);
	        	}

		        // Parar a execucao de todas as threads que nao foram atualizadas
		        // como as threadsCriadas sao do tipo CopyOnWriteArrayList que nao implementa o remove, teremos que criar um novo vetor e utiliza-lo no final se houver mudanca
		        List<IcDTO> copiaThreadsCriadas = new  CopyOnWriteArrayList<IcDTO>();
		        boolean isAtualizou = false;
		        for (Iterator<IcDTO> iDadosIcDTO = threadsCriadas.iterator() ; iDadosIcDTO.hasNext() ; ) {
		        	IcDTO dadosIcDTO = iDadosIcDTO.next();
		        	// Remover a thread se for necessario
		        	if (dadosIcDTO.isRemoverThread() == true){

		        		log.info(idLog, identacao, "REMOVENDO IC " + dadosIcDTO.getCd_ic());
		        		dadosIcDTO.obtemThreadGerenciadora().pararThread();
		        		isAtualizou = true;
		        		continue;
		        	} else {
		        		copiaThreadsCriadas.add(dadosIcDTO);
		        	}

		        	if (dadosIcDTO.getMsIcUpDTOLocais() != null){
		        		
		        		/* Alessandre em 28-08-18 como dadosIcDTO.getMsIcUpDTOLocais passou a ser do tipo CopyOnWriteArrayList
		        		 * devido a um problema de acesso concorrente no vetor, o metodo .remove deixou de existir. Enta
		        		 * iremos fazer uma copia dos itens válidos, mas só usaremo a copia se tiver tido alguma alteracao
		        		 * 
			        	Iterator<IcUpDTO> iIcUpDTO = dadosIcDTO.getMsIcUpDTOLocais().iterator();
			        	while (iIcUpDTO.hasNext()){
			        		IcUpDTO icUpDTO = iIcUpDTO.next();
			        		if (icUpDTO.getIsUpSendoTratada() == false){
			        			log.info(idLog, identacao, "REMOVENDO UP " + icUpDTO.getUrlConexao());
			        			iIcUpDTO.remove();
			        			


			        		}
			        	}
		        		 */
		        		List<IcUpDTO> copia = new CopyOnWriteArrayList<IcUpDTO>();
		        		boolean isHouveRemocao = false;
		        		Iterator<IcUpDTO> iIcUpDTO = dadosIcDTO.getMsIcUpDTOLocais().iterator();
			        	while (iIcUpDTO.hasNext()){
			        		IcUpDTO icUpDTO = iIcUpDTO.next();
			        		if (icUpDTO.getIsUpSendoTratada() == false){
			        			log.info(idLog, identacao, "REMOVENDO UP " + icUpDTO.getUrlConexao());
			        			isHouveRemocao = true;
			        		} else {
			        			copia.add(icUpDTO);
			        		}
			        	}
		        		// Se teve remocao entao utilizar a copia
			        	if (isHouveRemocao == true) {
			        		dadosIcDTO.setMsIcUpDTOLocais(copia);
			        	}
		        		
		        	}
    				UtilsThreads.pausaNaThread(2l);
		        }
		        if (isAtualizou == true) {
		        	threadsCriadas = copiaThreadsCriadas;
		        }


		        if (isPrimeiraExecucao == true){
			        // Varre todos os IHMs registrados para inicializacao no ServicoFactory
			        for (IhmDTO ihm : msdto.getIhmsRegistrados()){
			        	ClienteRegistrado c = new ClienteRegistrado();

			        	c.setIp(ihm.getConexaoIHM().getIp());
			        	c.setPorta(ihm.getConexaoIHM().getPorta());
			        	c.setUrlConexao(ihm.getUrl_Conexao());
			        	// adiciona as ups do ihm

			        	//c.addUpDTO(ihm.get);
			        	ServicoFactory.getInstancia().addCliente(c);
			        	
        				UtilsThreads.pausaNaThread(2l);
			        }
		        }

		        // Seta isPrimeiraExecucao para false a fim de evitar a atualizacao dos clientesRegistrados
		        this.isPrimeiraExecucao = false;

		        log.paraAvaliacao();
		        log.info(idLog, identacao, log.getAvaliacaoCompleta() + ". Esperando 10s para proximo heart-beat.");
		        // Pausa para um novo heart-beat

		        //ve se encontra o o idup 607
		        //IcUpDTO teste = Stubedelegate.getInstancia().getMsthread().getIcUpDTOdaListaByIdUpPdba("607");
		        //teste = Stubedelegate.getInstancia().getMsthread().getIcUpDTOdaListaByIdUp("607");
		        //teste = Stubedelegate.getInstancia().getMsthread().getIcUpDTOdaListaByCdUp("607");

		        // Mostrar todos os ics criados e suas up para debug
		        for (Iterator<IcDTO> iIdto = this.threadsCriadas.iterator() ; iIdto.hasNext() ; ) {
		        	IcDTO idto = iIdto.next();
		        	log.info(idLog, identacao, "Thread criada para o IC " + idto.getCd_ic());
		        }
		        log.info(idLog, 0, "FINALIZANDO MSTHREAD");
		        UtilsThreads.pausaNaThread(60000);
			} catch (Exception e) {
				e.printStackTrace();
				log.info(idLog, identacao, "Erro ", e);
				// Anteriormente o sleep estava em 10s fazendo com q a consolidacao esperasse 10 a 20s para consolidar o proximo registro, causando um acumulo de eventos
				UtilsThreads.pausaNaThread(500);
			}
			
		}
		log.info(idLog, identacao, "Fechando MSTHREAD.");
	}

	private void inicializarMSDTO() {
		msdto.setUrlConexao(UtilsTcp.getMACAddress());
		boolean isUsandoMac = true;
		log.iniciaAvaliacao("Heart-beat para o MS " + msdto.getUrlConexao() + " com idMs = " + msdto.getIdMs());
		MsDTO lcMsDTO=msdto;
		int indexIP = 0;
		do {
		    try {
				msdto = Stubedelegate.getInstancia().heartbeat(lcMsDTO);

				if (msdto != null && msdto.getIcsColetados() == null) {
					log.info(idLog, identacao, "Sem ICs para o " + msdto.getUrlConexao() + ".");
					UtilsThreads.pausaNaThread(10000);
				} else if (msdto == null) {
					// Usa o IP ou MAC para tentar obter o MS
					if (isUsandoMac) {
						List<String> ips = UtilsTcp.getIPAddress();
						if (ips != null && ips.size() > 0) {
							String ip = ips.get(indexIP);

							// Nao considerar os IPs abaixo pois pode dar problema
							if (ip.equals("127.0.0.1") == false)
								lcMsDTO.setUrlConexao(ip);
							indexIP++;
							if (indexIP >= ips.size())
								indexIP = 0;
						}
						isUsandoMac = false;
					} else {
						lcMsDTO.setUrlConexao(UtilsTcp.getMACAddress());
						isUsandoMac = true;
					}

					UtilsThreads.pausaNaThread(10000);
				} else if (msdto.getIcsColetados() == null) {
					log.info(idLog, identacao, "ics coletados nulo");
				}

			} catch (Exception e) {
				e.printStackTrace();
				if(msdto!=null)
					log.info(idLog, identacao, "FALHOU inicializacao MS com MAC " + msdto.getUrlConexao() + " com idMs = " + msdto.getIdMs());
				else
					log.info(idLog, identacao, "SEM RETORNO DE MSDTO(NULL)");
				UtilsThreads.pausaNaThread(10000);
			}
		} while (msdto==null || msdto.getIdMs().longValue() == 0l || msdto.getIcsColetados() == null);
	}

	public void pararThread(){
		this.isThreadExecutando = false;

		// Para as threads dos ICs
		for (IcDTO ms : threadsCriadas){
			log.info("Parando thread do IC = " + ms.getUrl_conexao());
			ms.obtemThreadGerenciadora().pararThread();
			for (IcUpDTO icup : ms.getMsIcUpDTOLocais()){
				for (AndonDTO andon : icup.getUpDTO().getListaEventosAndonUp()){
					andon.finalizaVerificacaoEventoAgendado();
				}
			}
		}
	}

	public List<IcDTO> getListaDadosIcDto() {
		return this.threadsCriadas;
	}

	/*
	 * Esse metodo retorna a identificacao do IcDTO que gerencia o IP do ic.
	 */
	public IcDTO getMsIcDTOdaLista(String ipIc) {
//		log.info(0, 10, "Identificando MsIcDTO para ipIc = " + ipIc);
		int ntentativas = 0;
		do {
			try {
				for(Iterator<IcDTO> iDadosicDTO = this.threadsCriadas.iterator() ; iDadosicDTO.hasNext() ; ) {
					IcDTO dadosicDTO = iDadosicDTO.next();
					if(dadosicDTO.getUrl_conexao() != null && dadosicDTO.getUrl_conexao().equals(ipIc)) {
//						log.info(0, 10, "Encontrada referencia para MsIcDTO com ipIc = " + ipIc);
						return dadosicDTO;
					}
				}
				ntentativas = 10;
				break;
			} catch (Exception e) {
				e.printStackTrace();
				UtilsThreads.pausaNaThread(300);
				ntentativas++;
			}
		} while (ntentativas < 3);
		log.info(0, 10, "NAO Encontrada referencia para MsIcDTO com ipIc = " + ipIc);
		return null;
	}

	public IcDTO getMsIcDTOdaListaByMacIHM(String macIHM, String cdUp) {
//		log.info(idLog, identacao+5, "Identificando MsIcDTO para macIHM = " + macIHM);
		int ntentativas = 0;
		do {
			try {
				for(Iterator<IcDTO> iDadosicDTO = this.threadsCriadas.iterator() ; iDadosicDTO.hasNext() ; ) {
					IcDTO dadosicDTO = iDadosicDTO.next();
					for (Iterator<IcUpDTO> iICupdto = dadosicDTO.getMsIcUpDTOLocais().iterator() ; iICupdto.hasNext() ; ) {
						IcUpDTO icupdto = iICupdto.next();
						for (Iterator<UpIhmDTO> iUpihm = icupdto.getUpDTO().getUpihmColetados().iterator() ; iUpihm.hasNext() ; ){
							UpIhmDTO upihm = iUpihm.next();
							if (upihm.getIhm().getUrl_Conexao() != null){
								//TODO: Decidindo em qual classe botar o separador - Denis 26/07/2016 17:29h
								for(String url : UtilsString.quebrarStringEmVetor(upihm.getIhm().getUrl_Conexao() , " ")){
									if(url.toUpperCase().equals(macIHM)){
										if (cdUp != null && cdUp.equals("") == false) {
											if (cdUp.equals(icupdto.getUpDTO().getCd_up()) == false)
												continue;
										}
//										log.info(idLog, identacao+5, "Encontrada referencia em icupdto = " + icupdto.getUpDTO().getCd_up() + " em getMsIcDTOdaListaByMacIHM para MsIcDTO com ipIc = " + macIHM);
										return dadosicDTO;
									}
								}
							}
							if (upihm.getIhm().getUrl_ConexaoAlternativo() != null){
								//TODO: Decidindo em qual classe botar o separador - Denis 26/07/2016 17:29h
								for(String url : UtilsString.quebrarStringEmVetor(upihm.getIhm().getUrl_ConexaoAlternativo() , " ")){
									if(url.equals(macIHM)  && icupdto.getUpDTO().getCd_up().equals(cdUp)){
										return dadosicDTO;
									}
								}
							}
						}
					}
				}
				ntentativas = 10;
				break;
			} catch (Exception e) {
				e.printStackTrace();
				UtilsThreads.pausaNaThread(300);
				ntentativas++;
			}
		} while (ntentativas < 3);
		log.info(idLog, identacao+5, "NAO Encontrada referencia para MsIcDTO com ipIc = " + macIHM);
		return null;
	}

	/*
	 * Esse metodo retorna a identificacao do IcDTO atraves da mensagem enviada pelo servidor Tcp
	 */
	public IcDTO getMsIcDTOdaListaByUp(String up) {
//		log.info(idLog, identacao + 5, "Identificando MsIcDTO para getMsIcDtodaListaByU = " + up);
		int ntentativas = 0;
		do {
			try {
				for(Iterator<IcDTO> iDadosicDTO = this.threadsCriadas.iterator() ; iDadosicDTO.hasNext() ; ) {
					IcDTO dadosicDTO = iDadosicDTO.next();
					for (Iterator<IcUpDTO> iICUpDTO = dadosicDTO.getMsIcUpDTOLocais().iterator() ;  iICUpDTO.hasNext() ; ){
						IcUpDTO icUpDTO  = iICUpDTO.next();
						if(icUpDTO.getUpDTO().getCd_up().equals(up) == true) {
//							log.info(idLog, identacao + 5, "Encontrada referencia para MsIcDTO com up = " + up);
							return dadosicDTO;
						}
					}
				}
				ntentativas = 10;
				break;
			} catch (Exception e) {
				log.info(idLog, identacao, e);
				UtilsThreads.pausaNaThread(300);
				ntentativas++;
			}
		} while (ntentativas < 3);
		log.info(idLog, identacao, "NAO Encontrada referencia para MsIcDTO com up = " + up);
		return null;
	}

	/*
	 * Alessandre: 08-09-12
	 * Esse metodo foi criado para identificar o IcDTO a partir da idUp. Esse metodo serve para suporte aos dados vindos
	 * Pelos webservices do Concentrador em C#
	 */
	public IcDTO getIcDTOdaListaByIdUpPdba(String idUp) {
//		log.info("Identificando MsIcDTO para getIcDTOdaListaByIdUpPdba = " + idUp);
		int ntentativas = 0;
		do {
			try {
				for(Iterator<IcDTO> iDadosicDTO = this.threadsCriadas.iterator() ; iDadosicDTO.hasNext() ; ) {
					IcDTO dadosicDTO = iDadosicDTO.next();
					
					for (Iterator<IcUpDTO> iICUpDTO = dadosicDTO.getMsIcUpDTOLocais().iterator() ; iICUpDTO.hasNext() ; ){
						IcUpDTO icUpDTO = iICUpDTO.next();
						if (icUpDTO.getUpDTO().getIdUpPDBA() != null && icUpDTO.getUpDTO().getIdUpPDBA().equals(idUp) == true) {
//							log.info("Encontrada referencia para MsIcDTO com up = " + idUp);
							return dadosicDTO;
						}
					}
				}
				ntentativas = 10;
				break;
			} catch (Exception e) {
				e.printStackTrace();
				UtilsThreads.pausaNaThread(300);
				ntentativas++;
			}
		} while (ntentativas < 3);
		log.info("NAO Encontrada referencia para MsIcDTO com up = " + idUp);
		return null;
	}

	public IcDTO getIcDTOdaListaByCdUp(String cdUp) {
//		log.info("Identificando MsIcDTO para msup = " + cdUp);
		int ntentativas = 0;
		do {
			try {
				for(Iterator<IcDTO> iDadosicDTO = this.threadsCriadas.iterator() ;  iDadosicDTO.hasNext() ; ) {
					IcDTO dadosicDTO = iDadosicDTO.next();
					for (Iterator<IcUpDTO> iICUpDTO = dadosicDTO.getMsIcUpDTOLocais().iterator() ; iICUpDTO.hasNext() ; ){
						IcUpDTO icUpDTO = iICUpDTO.next();
						if(icUpDTO.getUpDTO().getCd_up().equals(cdUp) == true) {
//							log.info("Encontrada referencia para MsIcDTO com msup = " + cdUp);
							return dadosicDTO;
						}
					}
				}
				ntentativas = 10;
				break;
			} catch (Exception e) {
				e.printStackTrace();
				UtilsThreads.pausaNaThread(300);
				ntentativas++;
			}
		} while (ntentativas < 3);
		log.info("NAO Encontrada referencia para MsIcDTO com up = " + cdUp);
		return null;
	}

	public IcDTO getIcDTOdaListaByIdUp(BigDecimal idUp) {
//		log.info("Identificando MsIcDTO para msup = " + idUp);
		int ntentativas = 0;
		do {
			try {
				for(Iterator<IcDTO> iDadosicDTO = this.threadsCriadas.iterator() ; iDadosicDTO.hasNext() ; ) {
					IcDTO dadosicDTO = iDadosicDTO.next();
					for (Iterator<IcUpDTO> iICUpDTO = dadosicDTO.getMsIcUpDTOLocais().iterator() ; iICUpDTO.hasNext() ; ){
						IcUpDTO icUpDTO = iICUpDTO.next();
						if(icUpDTO.getUpDTO().getIdUp().equals(idUp) == true) {
//							log.info("Encontrada referencia para MsIcDTO com idup = " + idUp);
							return dadosicDTO;
						}
					}
				}
				ntentativas = 10;
				break;
			} catch (Exception e) {
				e.printStackTrace();
				UtilsThreads.pausaNaThread(300);
				ntentativas++;
			}
		} while (ntentativas < 3);
		log.info("NAO Encontrada referencia para MsIcDTO com idup = " + idUp);
		return null;
	}

	public IcUpDTO getIcUp(String valor) {
		IcUpDTO retorno = null;
		int ntentativas = 0;
		do {
			try {
				retorno = getIcUpDTOdaListaByCdUp(valor);
				if (retorno == null)
					retorno = getIcUpDTOdaListaByIdUp(valor);
				if (retorno == null)
					retorno = getIcUpDTOdaListaByIdUpPdba(valor);
				if (retorno == null) {
					ntentativas++;
					UtilsThreads.pausaNaThread(300);
				} else {
					ntentativas = 10;
				}
			} catch (Exception e) {
				System.out.println("getIcUp: " + e.getMessage() + " tentativa=" + ntentativas);
				UtilsThreads.pausaNaThread(300);
				ntentativas++;
			}
		} while (ntentativas < 3);
		
		/* Alessandre em 06-08-19 para identificar um bug em que o cadastro da cdup nao eh encontrada esteri mostrando no console o conteudo da memoria
		 * 
		 */
		try {
			if (retorno == null || retorno.getUpDTO() == null) {
				Random random = new Random(System.currentTimeMillis());
				int idexe = random.nextInt();
				
				System.out.println(idexe + "*************.threadsCriadas.size=" + this.threadsCriadas.size());
				for(Iterator<IcDTO> iDadosicDTO = this.threadsCriadas.iterator() ; iDadosicDTO.hasNext() ; ) {
					IcDTO dadosicDTO = iDadosicDTO.next();
					System.out.println(idexe + "--------------icup para ic=" + dadosicDTO.getCd_ic() + " size=" + dadosicDTO.getMsIcUpDTOLocais().size() );
					for (Iterator<IcUpDTO> iICUpDTO = dadosicDTO.getMsIcUpDTOLocais().iterator() ; iICUpDTO.hasNext() ; ){
						IcUpDTO icUpDTO = iICUpDTO.next();
						if (icUpDTO.getUpDTO() != null && icUpDTO.getUpDTO().getCd_up() != null) {
							System.out.println(idexe + "----------------------------getIcUp na memoria = " + icUpDTO.getUpDTO().getCd_up() + " = " + valor);
						} else {
							System.out.println(idexe + "----------------------------icUpDTO.getUpDTO eh null para o idUpPdba = " + valor);
						}
					}
				}
				System.out.println(idexe + "*************.fim");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retorno;
	}

	/*
	 * Esse metodo deve retornar o IcUpDTO para o idUpPdba passado
	 * @depracated Como esse metodo e os metodos getIcUpDTOdaListaByIdUp e getIcUpDTOdaListaByCdUp tem o mesmo objetivo
	 * e são chamados sempre na sequencia, substitui pelo metodo getIcup(String valor)
	 */
	private IcUpDTO getIcUpDTOdaListaByIdUpPdba(String idUpPdba) {
		for(Iterator<IcDTO> iDadosicDTO = this.threadsCriadas.iterator() ; iDadosicDTO.hasNext() ; ) {
			IcDTO dadosicDTO = iDadosicDTO.next();
			for (Iterator<IcUpDTO> iICUpDTO = dadosicDTO.getMsIcUpDTOLocais().iterator() ; iICUpDTO.hasNext() ; ){
				IcUpDTO icUpDTO = iICUpDTO.next();
				if (icUpDTO.getUpDTO() != null && icUpDTO.getUpDTO().getIdUpPDBA() != null) {
//					log.info("Comparando " + icUpDTO.getUpDTO().getIdUpPDBA() + " = " + idUpPdba);
					if(icUpDTO.getUpDTO().getIdUpPDBA().equals(idUpPdba) == true) {
//						log.info("Encontrada referencia para MsIcDTO com up = " + idUpPdba + " log = " + icUpDTO.getIc().getLog());
						return icUpDTO;
					}
				} else {
					log.info("icUpDTO.getUpDTO eh null para o idUpPdba = " + idUpPdba);
				}
			}
		}
		log.info("NAO Encontrada referencia para MsIcDTO com iduppdba = " + idUpPdba);
		return null;
	}

	/*
	 * Esse metodo deve retornar o IcUpDTO para o cdUp passado
	 */
	private IcUpDTO getIcUpDTOdaListaByCdUp(String cdUp) {
		for(Iterator<IcDTO> iDadosicDTO = this.threadsCriadas.iterator() ; iDadosicDTO.hasNext() ; ) {
			IcDTO dadosicDTO = iDadosicDTO.next();
			for (Iterator<IcUpDTO> iICUpDTO = dadosicDTO.getMsIcUpDTOLocais().iterator() ; iICUpDTO.hasNext() ; ){
				IcUpDTO icUpDTO = iICUpDTO.next();
				if (icUpDTO.getUpDTO() != null && icUpDTO.getUpDTO().getCd_up() != null) {
//					log.info("Comparando " + icUpDTO.getUpDTO().getCd_up() + " = " + cdUp);
					if(icUpDTO.getUpDTO().getCd_up().equals(cdUp) == true) {
//						log.info("Encontrada referencia para IcUpDTO com up = " + cdUp);
						return icUpDTO;
					}
				} else {
					log.info("icUpDTO.getUpDTO eh null para o idUpPdba = " + cdUp);
				}
			}
		}
		log.info("NAO Encontrada referencia para MsIcDTO com cdup = " + cdUp);
		return null;
	}

	private IcUpDTO getIcUpDTOdaListaByIdUp(String idUp) {
		BigDecimal idUpNum;

		try {
			idUpNum = new BigDecimal(idUp);
		} catch (NumberFormatException e) {
			return null;
		}

		for(Iterator<IcDTO> iDadosicDTO = this.threadsCriadas.iterator() ; iDadosicDTO.hasNext() ; ) {
			IcDTO dadosicDTO = iDadosicDTO.next();
			for (Iterator<IcUpDTO> iICUpDTO = dadosicDTO.getMsIcUpDTOLocais().iterator() ; iICUpDTO.hasNext() ; ){
				IcUpDTO icUpDTO = iICUpDTO.next();
				if (icUpDTO.getUpDTO() != null && icUpDTO.getUpDTO().getIdUp() != null) {
					log.info("Comparando " + icUpDTO.getUpDTO().getIdUp() + " = " + idUpNum);
					if(icUpDTO.getUpDTO().getIdUp().compareTo(idUpNum) == 0) {
						log.info("Encontrada referencia para IcUpDTO com up = " + idUp);
						return icUpDTO;
					}
				} else {
					log.info("icUpDTO.getUpDTO eh null para o idUp = " + idUp);
				}
			}
		}
		log.info("NAO Encontrada referencia para MsIcDTO com idup = " + idUp);
		return null;
	}

	public MsDTO getMsdto() {
		return this.msdto;
	}


	public String getPathCacheColeta() {
		return this.pathCacheColeta;
	}
}
