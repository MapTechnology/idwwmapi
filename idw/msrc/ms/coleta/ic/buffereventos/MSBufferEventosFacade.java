package ms.coleta.ic.buffereventos;

import idw.util.IdwLogger;
import injetws.webservices.dto.IwsDadosCCKDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ms.coleta.ic.inovastandalone.DadosLocaisCCK;
import ms.coleta.ic.inovastandalone.ProcessaLinhaEvento;
import ms.coleta.ic.inovastandalone.VerificaCCK;
import ms.coleta.servico.ServicoFactory;
import ms.model.MsFacade;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.model.dto.MsBufferEventosIcUpDTO;

public class MSBufferEventosFacade {
	private static MSBufferEventosFacade oMSBufferEventosFacade = null;
	private List<MsBufferEventosIcUpDTO> listaMsBufferEventos = null;
	
	public MSBufferEventosFacade() {
	}	
	
	public static MSBufferEventosFacade getInstancia(){
		if (oMSBufferEventosFacade == null) {			
				oMSBufferEventosFacade = new MSBufferEventosFacade();			
		}
		return(oMSBufferEventosFacade);
	}
	
	public boolean isTratandoMsBufferEventosIcUpDTO(){
		if(listaMsBufferEventos==null)
			return false;
		return true;
	}
	
	public MsBufferEventosIcUpDTO getMsBufferEventosIcUpDTO(String idUpPdba){
		MsBufferEventosIcUpDTO retorno=null;
		if(listaMsBufferEventos!=null){
			for(MsBufferEventosIcUpDTO bufferdto:listaMsBufferEventos){
				if(bufferdto.getIcUpdto().getUpDTO().getIdUpPDBA().equals(idUpPdba)){
					retorno=bufferdto;
				}
			}
		}		
		return retorno;
	}	
	
	public MsBufferEventosIcUpDTO getNewMsBufferEventosIcUpDTO(String idUpPdba){
		
		IcUpDTO icupdto= MsFacade.getInstancia().pesquisarIcUpDtoPorIdUpPdba(idUpPdba);
		if(icupdto==null){
			return null;
		}
		if(listaMsBufferEventos==null){
			listaMsBufferEventos=new ArrayList<MsBufferEventosIcUpDTO>();
		}
		MsBufferEventosIcUpDTO retorno=new MsBufferEventosIcUpDTO();
		retorno.setIcUpdto(icupdto);
		listaMsBufferEventos.add(retorno);
		return retorno;
	}	
	
	public boolean lancaEventosCCKFromInjet(String idUP,Date dthrEvento,IwsDadosCCKDTO dadosCCK,IdwLogger log){
		
		Double consumoAtivo=null,fatorPotencia=null,correnteA=null,correnteB=null,correnteC=null,
				tensaoA=null,tensaoAB=null,tensaoAC=null,tensaoBC=null,tensaoB=null,tensaoC=null,tensaoMedia=null,
				correnteMedia=null;
		VerificaCCK vcck= new VerificaCCK();
		DadosLocaisCCK dadosLocaisCCK=null;
		EventoColetado evento=null;
		
		MsBufferEventosIcUpDTO msbuffereventos=getMsBufferEventosIcUpDTO(idUP);
		
		if(msbuffereventos==null)
			msbuffereventos=getNewMsBufferEventosIcUpDTO(idUP);
		if(msbuffereventos==null){
			return false;
		}
		IcUpDTO icupdto = msbuffereventos.getIcUpdto();
						
		consumoAtivo=dadosCCK.getConsumoAtivo().doubleValue()/10000;
		fatorPotencia=dadosCCK.getFatorDePotencia().doubleValue()/1000;
		correnteA=dadosCCK.getCorrenteA().doubleValue()/1000;
		correnteB=dadosCCK.getCorrenteB().doubleValue()/1000;
		correnteC=dadosCCK.getCorrenteC().doubleValue()/1000;
		correnteMedia=dadosCCK.getCorrenteMedia().doubleValue()/1000;
		tensaoA=dadosCCK.getTensaoA().doubleValue()/10;		
		tensaoB=dadosCCK.getTensaoB().doubleValue()/10;
		tensaoC=dadosCCK.getTensaoC().doubleValue()/10;
		tensaoAB=dadosCCK.getTensaoAB().doubleValue()/10;
		tensaoAC=dadosCCK.getTensaoAC().doubleValue()/10;
		tensaoBC=dadosCCK.getTensaoBC().doubleValue()/10;
		tensaoMedia=dadosCCK.getTensaoMedia().doubleValue()/10;
		
		//demandaTotalAtiva=dadosCCK.getDemandaAtiva().doubleValue()/10;
		
		dadosLocaisCCK=vcck.getDadosLocaisFromIcUpdtoVerificaUpdate(icupdto, ProcessaLinhaEvento._CONSUMO_ATIVO);
		if(dadosLocaisCCK!=null){
			if(vcck.verificaLancaAlerta(log, dadosLocaisCCK,consumoAtivo)==true){
				evento = new EventoColetado();
				evento.setDthrEvento(dthrEvento);
				evento.setIcUpDTO(icupdto);
				evento.setOrigem("Injet Consumo Ativo:"+consumoAtivo);
				evento.setLog(log);
				evento.setParametroLido(BigDecimal.valueOf(consumoAtivo));
				evento.setTipoEvento(ServicoFactory._ALERTA_CONSUMO_ATIVO);
				msbuffereventos.addEventoColetado(evento);
			}
		}

		dadosLocaisCCK=vcck.getDadosLocaisFromIcUpdtoVerificaUpdate(icupdto, ProcessaLinhaEvento._FATOR_DE_POTENCIA);
		if(dadosLocaisCCK!=null){
			if(vcck.verificaLancaAlerta(log, dadosLocaisCCK,fatorPotencia)==true){
				evento = new EventoColetado();
				evento.setDthrEvento(dthrEvento);
				evento.setIcUpDTO(icupdto);
				evento.setOrigem("Injet Fator Potencia:"+fatorPotencia);
				evento.setLog(log);
				evento.setParametroLido(BigDecimal.valueOf(fatorPotencia));
				evento.setTipoEvento(ServicoFactory._ALERTA_FATOR_DE_POTENCIA);
				msbuffereventos.addEventoColetado(evento);
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
				evento.setOrigem("Injet Demanda Maxima:"+dadosLocaisCCK.getDemandaMaxima());
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
		evento.setOrigem("Injet Con:"+consumoAtivo +" cp:"+fatorPotencia
				+" tA:" + tensaoA +" tB:" + tensaoB +" tC:" + tensaoC +" tM:" + tensaoMedia
				+" tAB:" + tensaoAB +" tAC:" + tensaoAC+" tBC:" + tensaoBC
				+" cA:" + correnteA +" cB:" + correnteA+" cC:" + correnteA+" cM:" + correnteMedia);
		
		dadosCCK.setConsumoAtivo(consumoAtivo);
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
		msbuffereventos.addEventoColetado(evento);
		
		
		return true;
	}
}
