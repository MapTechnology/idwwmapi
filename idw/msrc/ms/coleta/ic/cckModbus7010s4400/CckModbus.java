package ms.coleta.ic.cckModbus7010s4400;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import idw.model.pojos.OmCfg;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import injetws.webservices.dto.IwsDadosCCKDTO;
import modbus.ModBusIO;
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

public class CckModbus implements IIC{

	private IcDTO icdto = null;
	private Float versaoCCK= 0f;
	private ModBusIO modbusio = null;
	private Date lastUpdate = null;
	private Date lastHeartBeat = null;
	private Double ConsumoAtivoAcumulado = 0d;
	private IcUpDTO icupdto=null;
	private boolean isPrimeiraLeitura=true;
		
	public CckModbus(IcDTO icdto) {
		this.icdto = icdto;
		String urlConexao = icdto.getUrl_conexao();
		this.icupdto = icdto.getMsIcUpDTOLocais().get(0);

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
		if (lastHeartBeat == null || DataHoraRN.getQuantidadeSegundosNoPeriodo(lastHeartBeat, dthrEvento) > 30) {
			this.icupdto = icdto.getMsIcUpDTOLocais().get(0);
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
			if (lastUpdate == null || DataHoraRN.getQuantidadeSegundosNoPeriodo(lastUpdate, dthrEvento) > 600) {
				ledados(dthrEvento);
				if(isConectado==true){
					lastUpdate=dthrEvento;
				}else{
					idw.util.ThreadUtil.pausaNaThread(10000);
				}
			}			
		} catch (Exception e) {
		}		
		return eventos;		
	}

	private void ledados(Date dthrEvento) {
		Double consumoAtivoAmostra=null,consumoAtivo=null,fatorPotencia=null,correnteA=null,correnteB=null,correnteC=null,
				tensaoA=null,tensaoAB=null,tensaoAC=null,tensaoBC=null,tensaoB=null,tensaoC=null,tensaoMedia=null,
				correnteMedia=null;
		VerificaCCK vcck= new VerificaCCK();
		DadosLocaisCCK dadosLocaisCCK=null;
		IwsDadosCCKDTO dadosCCK= new IwsDadosCCKDTO();
		EventoColetado evento=null;
		List<Float> result;
		
		try{	
			result = modbusio.leVetorFloatHoldingRegister(512,60);
			isConectado=true;
		}catch (Exception e) {
			isConectado=false;
			return; 			//Sem sucesso  set isconectado==false
		}
						
		consumoAtivo=result.get(CckModbusDefines.i_CONSUMO_TTk+(CckModbusDefines.i_CONSUMO_TTm/1000)).doubleValue();//dadosCCK.getConsumoAtivo().doubleValue()/10000;
		
		if(consumoAtivo<ConsumoAtivoAcumulado){
			consumoAtivoAmostra=0d;
		}else{
			if(isPrimeiraLeitura==false){
				consumoAtivoAmostra=ConsumoAtivoAcumulado-consumoAtivo;
			}
			isPrimeiraLeitura=false;
		}	
		this.ConsumoAtivoAcumulado=consumoAtivo;
		versaoCCK= result.get(CckModbusDefines.i_VERSAO);
		fatorPotencia=result.get(CckModbusDefines.i_FP_TT).doubleValue();//dadosCCK.getFatorDePotencia().doubleValue()/1000;
		correnteA=result.get(CckModbusDefines.i_CORRENTE_R).doubleValue();//dadosCCK.getCorrenteA().doubleValue()/1000;
		correnteB=result.get(CckModbusDefines.i_CORRENTE_S).doubleValue();//dadosCCK.getCorrenteB().doubleValue()/1000;
		correnteC=result.get(CckModbusDefines.i_CORRENTE_T).doubleValue();//dadosCCK.getCorrenteC().doubleValue()/1000;
		correnteMedia=result.get(CckModbusDefines.i_CORRENTE_M).doubleValue();//dadosCCK.getCorrenteMedia().doubleValue()/1000;
		tensaoA=result.get(CckModbusDefines.i_TENSAOFN_R).doubleValue();//dadosCCK.getTensaoA().doubleValue()/10;		
		tensaoB=result.get(CckModbusDefines.i_TENSAOFN_S).doubleValue();//dadosCCK.getTensaoB().doubleValue()/10;
		tensaoC=result.get(CckModbusDefines.i_TENSAOFN_T).doubleValue();//dadosCCK.getTensaoC().doubleValue()/10;
		tensaoAB=result.get(CckModbusDefines.i_TENSAOFF_RS).doubleValue();//dadosCCK.getTensaoAB().doubleValue()/10;
		tensaoAC=result.get(CckModbusDefines.i_TENSAOFF_ST).doubleValue();//dadosCCK.getTensaoAC().doubleValue()/10;
		tensaoBC=result.get(CckModbusDefines.i_TENSAOFF_TR).doubleValue();//dadosCCK.getTensaoBC().doubleValue()/10;
		tensaoMedia=result.get(CckModbusDefines.i_TENSAOFF_M).doubleValue();//dadosCCK.getTensaoMedia().doubleValue()/10;
		
		//demandaTotalAtiva=dadosCCK.getDemandaAtiva().doubleValue()/10;
		
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
		evento.setIcUpDTO(icupdto);
		evento.setOrigem("CCK 7200ME Con:"+consumoAtivoAmostra +" cp:"+fatorPotencia
				+" tA:" + tensaoA +" tB:" + tensaoB +" tC:" + tensaoC +" tM:" + tensaoMedia
				+" tAB:" + tensaoAB +" tAC:" + tensaoAC+" tBC:" + tensaoBC
				+" cA:" + correnteA +" cB:" + correnteA+" cC:" + correnteA+" cM:" + correnteMedia);
		
		dadosCCK.setConsumoAtivo(consumoAtivoAmostra);
		dadosCCK.setFatorDePotencia(fatorPotencia);
		
		dadosCCK.setCorrenteA(correnteA);
		dadosCCK.setCorrenteB(correnteB);
		dadosCCK.setCorrenteC(correnteC);
		
		dadosCCK.setCorrenteMedia(correnteMedia);
		
		dadosCCK.setTensaoAB(tensaoAB);
		dadosCCK.setTensaoAC(tensaoAC);
		dadosCCK.setTensaoBC(tensaoBC);
		
		dadosCCK.setTensaoA(tensaoA);
		dadosCCK.setTensaoB(tensaoB);
		dadosCCK.setTensaoC(tensaoC);
		
		dadosCCK.setTensaoMedia(tensaoMedia);		
		
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

}