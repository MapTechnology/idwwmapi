package ms.coleta.ic.cckModbus;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.excessoes.SemComunicacaoException;
import idw.model.pojos.MsMsicup;
import idw.model.pojos.OmCfg;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import injetws.webservices.dto.IwsDadosCCKDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
import ms.coleta.ic.inovastandalone.DadosLocaisCCK;
import ms.coleta.ic.inovastandalone.ProcessaLinhaEvento;
import ms.coleta.ic.inovastandalone.VerificaCCK;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
import ms.model.dto.UpDTO;
import ms.model.rn.IcRN;

public class CckModbus implements IIC{
	
	private static int INTERVALO_COLETA_CCK_SEG = 60;

	private static boolean isColetaMemoriaOnline = false;
	private IcDTO icdto = null;
	private Float versaoCCK= 0f;
	private ModBusIO modbusio = null;
	private Date lastUpdate = null;
	private Date lastHeartBeat = null;
	private List<IcUpDTO> icupdtos;
	private List<IcUpDTO> icupdtosEquivalentes = new ArrayList<IcUpDTO>();
	private boolean isPrimeiraLeitura=true;
	private Map<IcUpDTO, Integer> ultimosConsumos = new HashMap<>();
	private Map<IcUpDTO, Integer> ultimosPonteiros = new HashMap<>();
	private Map<IcUpDTO, Integer> ultimosTimeStamp = new HashMap<>();
	
	//Luiz 20180614 - Criei a variavel offset para facilitar os gets do resultado dos registradores no protocolo MODBUS
	private int offset = 512;
	private boolean isExecutandoPrimeiraVez = true;
		
	public CckModbus(IcDTO icdto) {
		this.icdto = icdto;
		String urlConexao = icdto.getUrl_conexao();
		this.icupdtos = icdto.getMsIcUpDTOLocais();

		if (urlConexao.indexOf(ipSeparador) != -1) {
			ipColetor = urlConexao.split(ipSeparador)[0];
			portaColetor = Integer.parseInt(urlConexao.split(ipSeparador)[1]);
		} else {
			ipColetor = urlConexao;
			portaColetor = 502;
		}
	}	
	DadosLocaisCCK dadosLocais = new DadosLocaisCCK();
	public String ipColetor = null;
	private Integer portaColetor = null;
	private String ipSeparador = ":";

	private IdwLogger log = null;
	private Integer idLog = null;
	private boolean isConectado = false;

	EventosColetados eventos = null;

//	public static void main(String args[]) {
//		IdwLogger logger = new IdwLogger("Teste");
//		ModBusIO io= new ModBusIO("192.168.1.12", 502, logger);
//		int tentativas=1000;
//		int erros= 0;
//		while(1000>0){
//			try{	
//				tentativas--;
//				List<Float> result = io.leVetorFloatHoldingRegister(CckModbusDefines.BASE,110 );
//				int i = CckModbusDefines.BASE;
//				for(Float foo : result){
//					System.out.println(i+" - "+foo);
//					i+=2;
//				}
//			}catch (Exception e) {
//				erros++;
//				e.printStackTrace();
//			}
//			System.out.println("Tentativa:"+tentativas+" - Erros:"+erros);
//		}
//	}
	
		
	/*
	 * Executa Heart-Beat Executa na primeira execuão e a cada ~30 segundos
	 * após isso
	 */
	private void verificaHeartBeat(Date dthrEvento) {	
		for (IcUpDTO icupdto : icupdtos) {
			String cd_upSemSufixo = icupdto.getUpDTO().getCd_up().replace(CckModbusDefines.SUFIXO_CCK, "");
			IcUpDTO icupdtoEquivalente = new IcUpDTO();
			icupdtoEquivalente = Stubedelegate.getInstancia().getMsthread().getIcUp(cd_upSemSufixo);

			//TODO: levar isto para Construtor OU fazer lista [icupdtosEquivalentes] ser criada e conferida aqui antes de buscar upsemsufixo
			if(icupdtoEquivalente==null){

				IcRN icrn = new IcRN();
				MsMsicup msicupEquivalente = new MsMsicup();
				IcDTO icdto = new IcDTO();
				UpDTO updto = new UpDTO();
				try{
					msicupEquivalente = icrn.pesquisarMsIcUpByCdUp(cd_upSemSufixo);
				}catch(Exception e) {}
				if (msicupEquivalente!=null){
					if(msicupEquivalente.getMsIc()!=null){
						icdto.setCd_ic( msicupEquivalente.getMsIc().getCdIc());
						icdto.setDs_ic(msicupEquivalente.getMsIc().getDsIc());
						icdto.setDthr_heartbeat(msicupEquivalente.getMsIc().getDthrHeartbeat());
						icdto.setIdIc( (msicupEquivalente.getMsIc().getIdIc()).intValue() );
						icdto.setTp_ic(msicupEquivalente.getMsIc().getTpIc().intValue());
					}
					if (msicupEquivalente.getMsUp()!=null){
						updto.setCd_up(msicupEquivalente.getMsUp().getCdUp());
						updto.setCdBc(msicupEquivalente.getMsUp().getCdBc());
						updto.setIdUp(msicupEquivalente.getMsUp().getIdUp());
						updto.setIdUpPDBA(msicupEquivalente.getMsUp().getIduppdba());
					}
					if (icupdtoEquivalente==null){
						icupdtoEquivalente = new IcUpDTO();
					}
					icupdtoEquivalente.setIc(icdto);
					icupdtoEquivalente.setIdIcUp(msicupEquivalente.getIdMsicup().intValue());
					icupdtoEquivalente.setUpDTO(updto);
					icupdtoEquivalente.setTpConexao(msicupEquivalente.getTpConexao().intValue());
					icupdtoEquivalente.setUrlAuxiliar(msicupEquivalente.getUrlAuxiliar());
					icupdtoEquivalente.setUrlConexao(msicupEquivalente.getUrlConexao());
				}
				icrn = null;
				
			}

			int i =0;
			i = 1;			
			
			if (icupdtoEquivalente == null) {
				continue;
			} else {
				if (!icupdtosEquivalentes.contains(icupdtoEquivalente)) {
				icupdtosEquivalentes.add(icupdtoEquivalente);
				}
			}
		}
		if (lastHeartBeat == null || DataHoraRN.getQuantidadeSegundosNoPeriodo(lastHeartBeat, dthrEvento) > 30) {
			//this.icupdto = icdto.getMsIcUpDTOLocais().get(0);
			if (isConectado == false) { // Não executa o heart-Beat por estar sem conexão
				log.info(idLog, 0, modbusio + ":HeartBeat não executado CCK7200ME sem conexão!");
			}else{
				EventoColetado ev = new EventoColetado();
				ev.setTipoEvento(ServicoFactory._IC_HEART_BEAT);
				ev.setDthrEvento(dthrEvento);
				ev.setLog(log);
				eventos.addEventoColetado(ev);
			}
			lastHeartBeat = dthrEvento;
		}
	}
	
	
	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		
		if(eventos!=null && eventos.getEventosColetados().size()>0){
			eventos.clearEventos();
			eventos=null;
		}		
		
		eventos = new EventosColetados();	
		Date dthrEvento = new Date();
		
		try {
			verificaHeartBeat(dthrEvento);
			//O TEMPO ERA DE 600s

			if (lastUpdate == null || DataHoraRN.getQuantidadeSegundosNoPeriodo(lastUpdate, dthrEvento) > INTERVALO_COLETA_CCK_SEG) {

				for (IcUpDTO icupdto : this.icupdtos){
					int slaveId = 0;
					try {
						slaveId = Integer.parseInt(icupdto.getUrlConexao());
					}
					catch (Exception e) {
						log.info(idLog, 0, " A urlConexao do MsIcUp da Up: " + icupdto.getUpDTO().getCd_up() + "é inválida");
						continue;
					}
				if (this.isExecutandoPrimeiraVez) {
					recuperaMedicoesPendentes();
					this.isExecutandoPrimeiraVez = false;
				} else {
					ledados(dthrEvento, slaveId, icupdto);
					salvaUltimosRegitrosDeMassaLidos(this.icdto);
				}
				if(isConectado==true){
					lastUpdate=dthrEvento;
				}else{
					idw.util.ThreadUtil.pausaNaThread(10000);
				}
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return eventos;		
	}

	private void carregaUltimosRegistrosDeMassaLidos() throws IOException {
		// TODO Auto-generated method stub
		String everything = "";
		IcUpDTO icupdto = new IcUpDTO();
		Integer ponteiroLido = 0;
		Integer timestmpLido = 0;
		String[] parts;
		//File file = new File(pathDosArquivos + this.icdto.getCd_ic() + ".txt");
		File catalinaBase = new File(System.getProperty("catalina.base")).getAbsoluteFile();
		// Prepara o diretorio onde vao ficar as copias dos logs
		String diretorioDestino = catalinaBase.getAbsolutePath(); // Path do log salvo
		diretorioDestino += "//ColetaCck//";

		File file = new File(diretorioDestino + this.icdto.getCd_ic() + ".txt");
		if ((file.exists())&& (!file.isDirectory())){
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(file));
			    String line = br.readLine();
			    while (line != null && line.length()>0) {
			        parts = line.split(";");
			        if (parts.length != 3) {
			        	log.info("O arquivo dos ultimos registros do ic: " + this.icdto.getCd_ic() + "foi modificado ou contém erro");
			        	continue;
			        }
			        icupdto = getUpByCdUp(parts[0]);
			        if (icupdto == null) {
			        	continue;
			        }
			        try {
			        	ponteiroLido = Integer.parseInt(parts[1]);
			        	timestmpLido = Integer.parseInt(parts[2]);
			        } catch (Exception e) {
			        	log.info("O campo de ponteiros lidos da up: " + icupdto.getUpDTO().getCd_up() + "encontra-se invalido");
			        	continue;
			        }
			        ultimosPonteiros.put(icupdto, ponteiroLido);
			        ultimosTimeStamp.put(icupdto, timestmpLido);
			        line = br.readLine();
			    }
			    br.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		else
			return;
		
	}
	
	private IcUpDTO getUpByCdUp(String string) {
		// TODO Auto-generated method stub
		for(IcUpDTO icupdto : this.icupdtos) {
			if (icupdto.getUpDTO().getCd_up().equals(string)) {
				return icupdto;
			}
		}
		return null;
	}


	public void salvaUltimosRegitrosDeMassaLidos(IcDTO icdto) throws IOException {
		// TODO Auto-generated method stub
		File catalinaBase = new File(System.getProperty("catalina.base")).getAbsoluteFile();
		// Prepara o diretorio onde vao ficar as copias dos logs
		String diretorioDestino = catalinaBase.getAbsolutePath(); // Path do log salvo
		diretorioDestino += "//ColetaCck//";
		criaDiretorioSeNaoExistir(diretorioDestino);
		
		log.info("urlDiretorio " + diretorioDestino);
		
		File file = new File(diretorioDestino + this.icdto.getCd_ic() + ".txt");
		ArrayList<String> conteudoRegistroDeMassa;
		conteudoRegistroDeMassa = montaStatusPonteiros();
			PrintWriter writer;
			if (conteudoRegistroDeMassa.size() != 0) {
			try {
				writer = new PrintWriter(file, "UTF-8");
				for(String linha: conteudoRegistroDeMassa) { 
					writer.println(linha);
				}
				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	}

	
	
	
	private void criaDiretorioSeNaoExistir(String urlDiretorio) {
		File dir = new File(urlDiretorio);
		if (!dir.exists()) {
			dir.mkdir();
		}
	}
	
	
	private ArrayList<String> montaStatusPonteiros() {
		String linha = "";
		ArrayList<String> retorno = new ArrayList<String>();
		for(IcUpDTO icupdto: this.icupdtos) {
			linha = new String();
			if ((ultimosPonteiros.containsKey(icupdto)) && (ultimosTimeStamp.containsKey(icupdto))) {
				linha = icupdto.getUpDTO().getCd_up() + ";" + ultimosPonteiros.get(icupdto) + ";" + ultimosTimeStamp.get(icupdto); 
				retorno.add(linha);
			}
			else
				continue;
		}
		return retorno;
	}
	private void ledados(Date dthrEvento, int slaveId, IcUpDTO icupdto) {
		Integer ponteiroDeMassa = 0;
		Integer ponteiroAnterior = 0;
		Integer consumoAtivoAmostra=null,consumoAtivo=null, ConsumoAtivoAcumulado = null, consumoAtivoMassa = null,
				
				 relacaoTC=null, ponteiroMemoriaMassa = null;
		Double correnteMedia=null, correnteA=null,correnteB=null,correnteC=null, fatorPotencia=null, 
				tensaoA=null,tensaoAB=null,tensaoAC=null,tensaoBC=null,tensaoB=null,tensaoC=null,tensaoMedia=null;
		VerificaCCK vcck= new VerificaCCK();
		DadosLocaisCCK dadosLocaisCCK=null;
		IwsDadosCCKDTO dadosCCK= new IwsDadosCCKDTO();
		EventoColetado evento=null;
		List<Integer> result = new ArrayList<Integer>();
		List<Integer> resultMassa = new ArrayList<Integer>();
		int timestamp = 0;
		int dia, mes, hora, qh;
		boolean deveUsarNovoPonteiro = false;
		
		

		if (ultimosConsumos.containsKey(icupdto)) {
			ConsumoAtivoAcumulado = ultimosConsumos.get(icupdto);
			isPrimeiraLeitura = false;
		}
		else {
			isPrimeiraLeitura = true;
			ConsumoAtivoAcumulado = 0;
		}
		
		try{
			result = modbusio.leVetorHoldingRegister(slaveId, offset, 50);
			if (!isColetaMemoriaOnline) {
				ponteiroDeMassa = modbusio.lePointerMassaRegister(slaveId);
			}
			isConectado=true;
		}catch (Exception e) {
			isConectado=false;
			e.printStackTrace();
			return; 			//Sem sucesso  set isconectado==false
		}
				
		if (!isColetaMemoriaOnline) {
		if (ultimosPonteiros.containsKey(icupdto)) {
			ponteiroAnterior = ultimosPonteiros.get(icupdto);
			if (ponteiroAnterior.equals(ponteiroDeMassa)) {
				deveUsarNovoPonteiro = false;
			}
			else {
				deveUsarNovoPonteiro = true;
				ultimosPonteiros.put(icupdto, ponteiroDeMassa);
			}
		}
		else {
			ultimosPonteiros.put(icupdto, ponteiroDeMassa);
			deveUsarNovoPonteiro = true;
		}
		}
		if (isColetaMemoriaOnline) {
		//consumoAtivo=(int)result.get(CckModbusDefines.i_CONSUMO_TTk+(CckModbusDefines.i_CONSUMO_TTm/1000)).doubleValue();//dadosCCK.getConsumoAtivo().doubleValue()/10000;
		consumoAtivo =(int)result.get(CckModbusDefines.i_CONSUMO_TTk - offset);
		consumoAtivo = ((int)consumoAtivo << 16) | (int)result.get(CckModbusDefines.i_CONSUMO_TTk + 1 - offset);
		
		if(consumoAtivo<=ConsumoAtivoAcumulado){
			consumoAtivoAmostra=0;
		}else{
			if(isPrimeiraLeitura==false){
				consumoAtivoAmostra=consumoAtivo - ConsumoAtivoAcumulado;
			} else {
				isPrimeiraLeitura=false;
				consumoAtivoAmostra = 0;
			}
		}
		//Inserido por Fabricio em 24.07
		relacaoTC = (int)result.get(CckModbusDefines.i_PR_TC - offset);
		consumoAtivoAmostra = (relacaoTC/5)*consumoAtivoAmostra/10;
		ConsumoAtivoAcumulado=(int)consumoAtivo;
		ultimosConsumos.put(icupdto, ConsumoAtivoAcumulado);
		}
		//Se a coleta for de memoria de massa entao deve-se apenas buscar o consumo no registrador de massa e multiplicar pelo fator
		else {
			if(deveUsarNovoPonteiro){
				try {
					resultMassa = modbusio.leVetorMassaRegister(slaveId, ponteiroDeMassa, 4);
				}
				catch (Exception e) {
					isConectado=false;
					e.printStackTrace();
					return; 			//Sem sucesso  set isconectado==false
				}
					consumoAtivoAmostra = resultMassa.get(CckModbusDefines.i_CONSUMO_REGISTRO_MASSA);
					timestamp =  resultMassa.get(CckModbusDefines.i_TIMESTAMP_REGISTRO_MASSA);
					ultimosTimeStamp.put(icupdto, resultMassa.get(CckModbusDefines.i_TIMESTAMP_REGISTRO_MASSA));
					dia = (int)((timestamp&(CckModbusDefines.i_RELOGIO_DIA))>>12);
					mes = (int)((timestamp&(CckModbusDefines.i_RELOGIO_MES))>>7);
					hora = (int)((timestamp&(CckModbusDefines.i_RELOGIO_HORA))>>2);
					qh = (int)(timestamp&(CckModbusDefines.i_RELOGIO_QH));
					evento = new EventoColetado();
					//dthrEvento.setDate(dia);
					//dthrEvento.setMonth(mes);
					//dthrEvento.setHours(hora);
					//dthrEvento.setMinutes(qh*15);
					relacaoTC = (int)result.get(CckModbusDefines.i_PR_TC - offset);
					consumoAtivoAmostra = (relacaoTC/5)*consumoAtivoAmostra/10;
					if (consumoAtivo == null){
						consumoAtivo = 0;
					}
			}
			//Luiz - 20180802 inclui o return para o caso de nao ter passado os 15 minutos necessarios pra mudanca do registro de massa
			else {
				consumoAtivoAmostra = 0;
				return;
			}
		}

		
		try {
		versaoCCK= (float)result.get(CckModbusDefines.i_VERSAO - offset);
		fatorPotencia=(int)result.get(CckModbusDefines.i_FP_TT - offset)/(double)1000;//dadosCCK.getFatorDePotencia().doubleValue()/1000;
		correnteA=(int)result.get(CckModbusDefines.i_CORRENTE_R - offset) * (relacaoTC/5)/(double)1000;//dadosCCK.getCorrenteA().doubleValue()/1000;
		correnteB=(int)result.get(CckModbusDefines.i_CORRENTE_S - offset) * (relacaoTC/5)/(double)1000;//dadosCCK.getCorrenteB().doubleValue()/1000;
		correnteC=(int)result.get(CckModbusDefines.i_CORRENTE_T - offset) * (relacaoTC/5)/(double)1000;//dadosCCK.getCorrenteC().doubleValue()/1000;
		correnteMedia=(int)result.get(CckModbusDefines.i_CORRENTE_M - offset) * (relacaoTC/5)/(double)1000;//dadosCCK.getCorrenteMedia().doubleValue()/1000;
		tensaoA=(int)result.get(CckModbusDefines.i_TENSAOFN_R - offset)/(double)10;//dadosCCK.getTensaoA().doubleValue()/10;		
		tensaoB=(int)result.get(CckModbusDefines.i_TENSAOFN_S - offset)/(double)10;//dadosCCK.getTensaoB().doubleValue()/10;
		tensaoC=(int)result.get(CckModbusDefines.i_TENSAOFN_T - offset)/(double)10;//dadosCCK.getTensaoC().doubleValue()/10;
		tensaoAB=(int)result.get(CckModbusDefines.i_TENSAOFF_RS - offset)/(double)10;//dadosCCK.getTensaoAB().doubleValue()/10;
		tensaoAC=(int)result.get(CckModbusDefines.i_TENSAOFF_ST - offset)/(double)10;//dadosCCK.getTensaoAC().doubleValue()/10;
		tensaoBC=(int)result.get(CckModbusDefines.i_TENSAOFF_TR - offset)/(double)10;//dadosCCK.getTensaoBC().doubleValue()/10;
		tensaoMedia=(int)result.get(CckModbusDefines.i_TENSAOFF_M - offset)/(double)10;//dadosCCK.getTensaoMedia().doubleValue()/10;
		
		//demandaTotalAtiva=dadosCCK.getDemandaAtiva().doubleValue()/10;
		}catch (Exception e) {
			e.printStackTrace();
		return; 			//Sem sucesso  set isconectado==false
		}
		dadosLocaisCCK=vcck.getDadosLocaisFromIcUpdtoVerificaUpdate(icupdto, ProcessaLinhaEvento._CONSUMO_ATIVO);
		if(dadosLocaisCCK!=null){
			if(vcck.verificaLancaAlerta(log, dadosLocaisCCK,consumoAtivo)==true){
				evento = new EventoColetado();
				evento.setDthrEvento(dthrEvento);
				evento.setIcUpDTO(icupdto);
				evento.setOrigem("CCK 7200ME Consumo Ativo:"+consumoAtivo);
				evento.setLog(log);
				evento.setParametroLido(BigDecimal.valueOf(consumoAtivo));
				evento.setTipoEvento(ServicoFactory._ALERTA_CONSUMO_ATIVO);
				eventos.addEventoColetado(evento);
			}
		}

		dadosLocaisCCK=vcck.getDadosLocaisFromIcUpdtoVerificaUpdate(icupdto, ProcessaLinhaEvento._FATOR_DE_POTENCIA);
		if(dadosLocaisCCK!=null){
			if(vcck.verificaLancaAlerta(log, dadosLocaisCCK,fatorPotencia)==true){
				evento = new EventoColetado();
				evento.setDthrEvento(dthrEvento);
				evento.setIcUpDTO(icupdto);
				evento.setOrigem("CCK 7200ME Fator Potencia:"+fatorPotencia);
				evento.setLog(log);
				evento.setParametroLido(BigDecimal.valueOf(fatorPotencia));
				evento.setTipoEvento(ServicoFactory._ALERTA_FATOR_DE_POTENCIA);
				eventos.addEventoColetado(evento);
			}
		}
		/*
		dadosLocaisCCK=vcck.getDadosLocaisFromIcUpdtoVerificaUpdate(icupdto, ProcessaListaEvento._DEMANDA_TOTAL_ATIVA);
		if(dadosLocaisCCK!=null){
		   
		    boolean deveLancarDemandaMaxima=vcck.verificaDemandaMaximaEAtualizaMedia(dadosLocaisCCK,demandaTotalAtiva);
			if(deveLancarDemandaMaxima==true){									
				evento = new EventoColetado();
				evento.setDthrEvento(dthrEvento);
				evento.setIcUpDTO(icupdto);
				evento.setOrigem("CCK 7200ME Demanda Maxima:"+dadosLocaisCCK.getDemandaMaxima());
				evento.setLog(log);
				evento.setParametroLido(BigDecimal.valueOf(dadosLocaisCCK.getDemandaMaxima()));
				evento.setTipoEvento(ServicoFactory._MEDICAO_DEMANDA_MAXIMA);
				msbuffereventos.addEventoColetado(evento);
			}	
		}		
		*/
		
		evento = new EventoColetado();
		evento.setDthrEvento(dthrEvento);
		
		evento.setIcUpDTO(this.getIcUpDTOEquivalente(icupdto.getUpDTO().getCd_up()));

		
		
		
		evento.setOrigem("CCK 7200ME Con:"+consumoAtivoAmostra +" cp:"+fatorPotencia
				+" tA:" + tensaoA +" tB:" + tensaoB +" tC:" + tensaoC +" tM:" + tensaoMedia
				+" tAB:" + tensaoAB +" tAC:" + tensaoAC+" tBC:" + tensaoBC
				+" cA:" + correnteA +" cB:" + correnteA+" cC:" + correnteA+" cM:" + correnteMedia);
		
		dadosCCK.setConsumoAtivo(new BigDecimal(consumoAtivoAmostra));
		dadosCCK.setFatorDePotencia(new BigDecimal(fatorPotencia));
		
		dadosCCK.setCorrenteA(new BigDecimal(correnteA));
		dadosCCK.setCorrenteB(new BigDecimal(correnteB));
		dadosCCK.setCorrenteC(new BigDecimal(correnteC));
		
		dadosCCK.setCorrenteMedia(new BigDecimal(correnteMedia));
		
		dadosCCK.setTensaoAB(new BigDecimal(tensaoAB));
		dadosCCK.setTensaoAC(new BigDecimal(tensaoAC));
		dadosCCK.setTensaoBC(new BigDecimal(tensaoBC));
		
		dadosCCK.setTensaoA(new BigDecimal(tensaoA));
		dadosCCK.setTensaoB(new BigDecimal(tensaoB));
		dadosCCK.setTensaoC(new BigDecimal(tensaoC));
		
		dadosCCK.setTensaoMedia(new BigDecimal(tensaoMedia));		
		
		dadosCCK.truncateAllValuesPrecision(3);
		evento.setDadosCCK(dadosCCK);
		evento.setLog(log);
		evento.setParametroLido(BigDecimal.valueOf(consumoAtivo));
		evento.setTipoEvento(ServicoFactory._MEDICAO_CCK);
		eventos.addEventoColetado(evento);
		return;
	}

	@Override
	public void inicializaIC(IdwLogger logPar) throws SemComunicacaoICException {
		this.log = logPar;
		this.idLog = this.log.getIdAleatorio();
		log.info(idLog, 0, " InicializaIC:" + ipColetor + ":" + portaColetor);
		modbusio = new ModBusIO(ipColetor, portaColetor, log);
		verificaHeartBeat(new Date());
		try {
			carregaUltimosRegistrosDeMassaLidos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void recuperaMedicoesPendentes() {
		int ponteiroDeMassa = 0;
		int timestamp = 0;
		int slaveId = 0;
		for(IcUpDTO icupdto: this.icupdtos) {
		try {
			slaveId = Integer.parseInt(icupdto.getUrlConexao());
		}
		catch (Exception e) {
			log.info(idLog, 0, " A urlConexao do MsIcUp da Up: " + icupdto.getUpDTO().getCd_up() + "é inválida");
			return;
		}
		if (this.ultimosPonteiros.containsKey(icupdto)) {
			try {
				ponteiroDeMassa = modbusio.lePointerMassaRegister(slaveId);
				timestamp = modbusio.leVetorMassaRegister(slaveId, ponteiroDeMassa, 4).get(0);
				if ((ultimosPonteiros.get(icupdto).equals(Integer.valueOf(ponteiroDeMassa))) && (ultimosTimeStamp.get(icupdto).equals(Integer.valueOf(timestamp)))) {
					continue;
				} else {
					geraEventosMedicoesPendentes(ultimosPonteiros.get(icupdto), ponteiroDeMassa, timestamp, slaveId, icupdto);
				}
			} catch (SemComunicacaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			continue;
		}
		}
		return;
		
	}


	private void geraEventosMedicoesPendentes(Integer ponteiroAntigo, int ponteiroDeMassa, int timestampAtual, int slaveId, IcUpDTO icupdto) {
		// TODO Auto-generated method stub
		log.info("Entrei na rotina de recuperação de medoções pedentes do ponteiro : " + ponteiroAntigo.toString() + 
				" até o ponteiro : " + ponteiroDeMassa + "para o ic: "+ icupdto.getIc().getCd_ic() + "do slaveid: " + slaveId);
		EventoColetado evento = new EventoColetado();
		IwsDadosCCKDTO dadosCCK= new IwsDadosCCKDTO();
		int consumoAtivoAmostra = 0;
		List<Integer> resultMassa = new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		Date dthrEvento = new Date();
		GregorianCalendar calendario = new GregorianCalendar();
		int tensaoDeLinhaMedia = 0;
		int dia, mes, hora, qh;
		int relacaoTC, timestamp = 0;
		int penultimoTimestamp = 0;

		
		try {
			result = modbusio.leVetorHoldingRegister(slaveId, CckModbusDefines.i_PR_TC, 1);
		} catch (SemComunicacaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (result == null || result.size()==0) {
			return;
		}
		relacaoTC = (int) result.get(0);
		
		int contadorCircular = ponteiroAntigo.intValue() + 1;
			while(contadorCircular != (ponteiroDeMassa + 1)) {
				try {
					resultMassa = modbusio.leVetorMassaRegister(slaveId, contadorCircular, 4);
					
				} catch (SemComunicacaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Luiz -20180813- Lê consumo da memoria de massa e multiplica pelo fator de transformação
				consumoAtivoAmostra = resultMassa.get(CckModbusDefines.i_CONSUMO_REGISTRO_MASSA);
				consumoAtivoAmostra = (relacaoTC/5)*consumoAtivoAmostra/10;
				tensaoDeLinhaMedia = resultMassa.get(CckModbusDefines.i_TENSAO_LINHA_MEDIA_REGISTRO_MASSA);
				timestamp = resultMassa.get(CckModbusDefines.i_TIMESTAMP_REGISTRO_MASSA);
				
				log.info("Processando o Ponteiro: " + contadorCircular + " timestamp: "+ timestamp + "consumoAtivoAmostra: "+consumoAtivoAmostra);
				//Luiz -20180813- Atualiza ultimo ponteiro lido
				if(timestamp < ultimosTimeStamp.get(icupdto).intValue() && timestamp < penultimoTimestamp) {
					contadorCircular = CckModbusDefines.i_PONTEIRO_MASSA_MINIMO;
					continue;
				}
				else if(timestamp < ultimosTimeStamp.get(icupdto).intValue() && timestamp > penultimoTimestamp) {
					log.info("Temos um possível lixo de memória, ou salto, no ponteiro: "+ contadorCircular+
							" de timestamp: " + timestamp +
							" sendo o ultimo timestamp lido: " + ultimosTimeStamp.get(icupdto).intValue() +
							" e o penultimo: "+ penultimoTimestamp);
				}
				
				penultimoTimestamp = ultimosTimeStamp.get(icupdto);
				ultimosPonteiros.put(icupdto, contadorCircular);
				ultimosTimeStamp.put(icupdto, timestamp);
				
				//Luiz -20180813- Faz o parser do timestamp pra data de acordo com a documentação da cck.
				mes = (int)((timestamp&(CckModbusDefines.i_RELOGIO_MES))>>12);
				dia = (int)((timestamp&(CckModbusDefines.i_RELOGIO_DIA))>>7);
				hora = (int)((timestamp&(CckModbusDefines.i_RELOGIO_HORA))>>2);
				qh = (int)(timestamp&(CckModbusDefines.i_RELOGIO_QH));
				evento = new EventoColetado();
				dadosCCK= new IwsDadosCCKDTO();
				calendario = new GregorianCalendar();
				dthrEvento = calendario.getTime();
				dthrEvento.setDate(dia);
				dthrEvento.setMonth(mes - 1);
				dthrEvento.setHours(hora);
				dthrEvento.setMinutes(qh*15);
				evento.setDthrEvento(dthrEvento);
		
				evento.setIcUpDTO(this.getIcUpDTOEquivalente(icupdto.getUpDTO().getCd_up()));

				evento.setOrigem("CCK 7200ME Con: Evento originado do método de recuperação do endereço de memoria de massa: "
						 + ponteiroAntigo.intValue() + "Até o endereço: " + ponteiroDeMassa + "Sendo este o: " + contadorCircular);
		
				dadosCCK.setConsumoAtivo(new BigDecimal(consumoAtivoAmostra));
				dadosCCK.setFatorDePotencia(new BigDecimal(0));
		
				dadosCCK.setCorrenteA(new BigDecimal(0));
				dadosCCK.setCorrenteB(new BigDecimal(0));
				dadosCCK.setCorrenteC(new BigDecimal(0));
		
				dadosCCK.setCorrenteMedia(new BigDecimal(0));
		
				dadosCCK.setTensaoAB(new BigDecimal(0));
				dadosCCK.setTensaoAC(new BigDecimal(0));
				dadosCCK.setTensaoBC(new BigDecimal(0));
		
				dadosCCK.setTensaoA(new BigDecimal(0));
				dadosCCK.setTensaoB(new BigDecimal(0));
				dadosCCK.setTensaoC(new BigDecimal(0));
		
				dadosCCK.setTensaoMedia(new BigDecimal(tensaoDeLinhaMedia));		
		
				dadosCCK.truncateAllValuesPrecision(3);
				evento.setDadosCCK(dadosCCK);
				evento.setLog(log);
				evento.setParametroLido(BigDecimal.valueOf(consumoAtivoAmostra));
				evento.setTipoEvento(ServicoFactory._MEDICAO_CCK);
				eventos.addEventoColetado(evento);
				contadorCircular++;
				if (contadorCircular > CckModbusDefines.i_PONTEIRO_MASSA_MAXIMO) {
					contadorCircular = CckModbusDefines.i_PONTEIRO_MASSA_MINIMO;
				}
			}
	}


	@Override
	public void finalizaIC() throws SemComunicacaoICException {
		log = icdto.getLog();
		idLog = log.getIdAleatorio();
		modbusio = null;
		log.info(idLog, 0, " finalizaIC:" + ipColetor + ":" + portaColetor);

	}

	@Override
	public String getVersaoDriver() throws SemComunicacaoICException {
		return String.valueOf(CckModbusDefines._VERSAODRIVER);
	}

	@Override
	public String getVersaoIC() throws SemComunicacaoICException {
		if (versaoCCK == -1) {
			return "S";
		}
		return String.valueOf(versaoCCK);
	}


	@Override
	public void setDadosParametrosSaida(List<ParametroDTO> listaParametros) {
	}

	@Override
	public void setUnicoDadoParametroParametroSaida(ParametroDTO parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setParametro(ParametroDTO parametro) {
		// TODO Auto-generated method stub
		
	}
	
	public IcUpDTO getIcUpDTOEquivalente(String cd_up) {
		IcUpDTO retorno = new IcUpDTO();
		for(IcUpDTO a : icupdtosEquivalentes) {
			if (a.getUpDTO().getCd_up().equals(cd_up.replace(CckModbusDefines.SUFIXO_CCK, ""))) {
				retorno = a;
			}
		}
		return retorno;
	}

}