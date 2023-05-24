package ms.coleta.ic.inovastandalone;

import idw.model.pojos.OmCfg;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.util.UtilsString;
import injetws.webservices.dto.IwsDadosCCKDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ms.coleta.Stubedelegate;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class ProcessaLinhaEvento {
	
	//Andre: Posi��oo das informações na linha do arquivo
	public static final int _ID_PT 				= 0;
	public static final int _DS_UP				= 1;
	public static final int _DTHR 				= 2;
	public static final int _TIPO_EVENTO 		= 3;
	public static final int _CD_MOTIVO_PARADA 	= 4;
	public static final int _BARCODE 			= 5;
	public static final int _OP_NUMERO		 	= 6;
	public static final int _CD_ALERTA          = 7;
	public static final int _CD_REFUGO          = 8;
	public static final int _CD_ACAO            = 9;
	public static final int _CD_PRODUTO         = 10;
	public static final int _QNTD               = 11;
	public static final int _DTHR_ULTIMO_REFUGO = 12;
	public static final int _CD_CAUSA           = 13;
	public static final int _CD_JUSTIFICATIVA	= 14;
	public static final int _CD_TECRESPONSAVEL	= 15;
	public static final int _CD_TEC1			= 16;
	public static final int _CD_TEC2			= 17;
	public static final int _CD_TECCIP			= 18;
	public static final int _PERIODO_PRODUTIVO	= 19;//1-Normal, 2-CIP
	
	public static final int _CONSUMO_ATIVO 		= 6;
	public static final int _DEMANDA_TOTAL_ATIVA = 16;
	public static final int _FATOR_DE_POTENCIA 	= 18;
	
	public static final int _TENSAO_A 	= 8;
	public static final int _TENSAO_B 	= 9;
	public static final int _TENSAO_C 	= 10;
	public static final int _TENSAO_MEDIA 	= 11;
	
	public static final int _CORRENTE_A 	= 12;
	public static final int _CORRENTE_B 	= 13;
	public static final int _CORRENTE_C 	= 14;
	public static final int _CORRENTE_MEDIA	= 15;
	
	public static final int _TENSAO_AB 	= 33;
	public static final int _TENSAO_BC	= 34;
	public static final int _TENSAO_AC 	= 35;
	
	public static List<EventoColetado> processar(String linha, IdwLogger log, OmCfg omcfg) {

		List<EventoColetado> retorno = new ArrayList<>();
		EventoColetado evento = new EventoColetado();
		IcUpDTO icupdto=null;
		Date dtHrEvento=null;
		
		if (linha == null || linha.equals("") || linha.trim().equals("") || linha.charAt(0)==0x00)
			return retorno;

		log.info("Processando linha [" + linha + "]");
		
		try {
			List<String> elementosLinha = UtilsString.quebrarStringEmVetor(linha, ",");
	
			int iele = 0;
			log.info("qtde de elemento na linha " + elementosLinha.size());
			for (String ele : elementosLinha) {
				log.info(iele + " - " + ele);
				iele++;
			}			
			
			evento = new EventoColetado();
			
			try{
				dtHrEvento=DataHoraRN.stringToDate(elementosLinha.get(_DTHR), "yyyy-MM-dd HH:mm:ss.SSS");
				icupdto=Stubedelegate.getInstancia().getMsthread().getIcUp(elementosLinha.get(_DS_UP));
				evento.setIcUpDTO(icupdto);
				evento.setDthrEvento(dtHrEvento);
	
				
				switch (Integer.parseInt(elementosLinha.get(_TIPO_EVENTO))){
				case ServicoFactory._INICIO_PARADA:
					evento.setTipoEvento(Integer.parseInt(elementosLinha.get(_TIPO_EVENTO)));
					evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
					evento.setOrigem(linha);
					evento.setLog(log);
					break;
	
				case ServicoFactory._MOTIVO_PARADA:
					evento.setTipoEvento(Integer.parseInt(elementosLinha.get(_TIPO_EVENTO)));
					evento.setCdparada(elementosLinha.get(_CD_MOTIVO_PARADA));
					evento.setCdacao(elementosLinha.get(_CD_ACAO));
					evento.setCdcausa(elementosLinha.get(_CD_CAUSA));
					evento.setCdjustificativa(elementosLinha.get(_CD_JUSTIFICATIVA));
					evento.setCdtecResponsavel(elementosLinha.get(_CD_TECRESPONSAVEL));
					evento.setCdtec1(elementosLinha.get(_CD_TEC1));
					evento.setCdtec2(elementosLinha.get(_CD_TEC2));
					evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
					evento.setOrigem(linha);
					evento.setLog(log);
					break;
	
				case ServicoFactory._FIM_PARADA:
					evento.setTipoEvento(Integer.parseInt(elementosLinha.get(_TIPO_EVENTO)));
					evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
					evento.setOrigem(linha);
					evento.setLog(log);
					break;
	
				case ServicoFactory._FINALIZA_OP:
					evento.setTipoEvento(Integer.parseInt(elementosLinha.get(_TIPO_EVENTO)));
					evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
					evento.setOrigem(linha);
					break;
	
				case ServicoFactory._NOVA_OP:
					evento.setTipoEvento(Integer.parseInt(elementosLinha.get(_TIPO_EVENTO)) );
					evento.setCdop(elementosLinha.get(_OP_NUMERO));
					evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
					evento.setOrigem(linha);
					evento.setLog(log);
					break;
	
				case ServicoFactory._PASSAGEM:
					evento.setTipoEvento(Integer.parseInt(elementosLinha.get(_TIPO_EVENTO)));
					evento.setCdop(elementosLinha.get(_OP_NUMERO));
					evento.setCdproduto(Util.extraiPorMascara(elementosLinha.get(_BARCODE), omcfg.getMascaracdprodutoCB()));
					evento.setCb(Util.extraiPorMascara(elementosLinha.get(_BARCODE), omcfg.getMascaracb()));
					evento.setQtde(elementosLinha.get(_QNTD));
					evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
					evento.setOrigem(linha);
					evento.setLog(log);
					break;
	
				case ServicoFactory._INICIA_ALERTA:
					evento.setTipoEvento(Integer.parseInt(elementosLinha.get(_TIPO_EVENTO)));
					evento.setCdalerta(elementosLinha.get(_CD_ALERTA));
					evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
					evento.setOrigem(linha);
					evento.setLog(log);
					break;
					
				case ServicoFactory._REMOVE_ALERTA:
					evento.setTipoEvento(Integer.parseInt(elementosLinha.get(_TIPO_EVENTO)));
					evento.setCdalerta(elementosLinha.get(_CD_ALERTA));
					evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
					evento.setOrigem(linha);
					evento.setLog(log);
					break;
					
				case ServicoFactory._NOVOREFUGO:
					evento.setTipoEvento(Integer.parseInt(elementosLinha.get(_TIPO_EVENTO)));
					evento.setCdrefugo(elementosLinha.get(_CD_REFUGO));
					evento.setDthrUltimoRefugo(elementosLinha.get(_DTHR_ULTIMO_REFUGO));
					evento.setMilisec(String.valueOf(DataHoraRN.stringToDate(elementosLinha.get(_DTHR_ULTIMO_REFUGO), "yyyy-MM-dd HH:mm:ss.SSS").getTime()));
					evento.setChamarInjetWs(false);
					evento.setCdacao(elementosLinha.get(_CD_ACAO));
					evento.setCdcausa(elementosLinha.get(_CD_CAUSA));
					evento.setQtde(elementosLinha.get(_QNTD));
					evento.setIdRdzProduto(elementosLinha.get(_CD_PRODUTO));
					evento.setCb(elementosLinha.get(_BARCODE));
					evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
					evento.setOrigem(linha);
					evento.setLog(log);
					break;
					
				case ServicoFactory._APAGAULTIMOREFUGO:
					evento.setTipoEvento(Integer.parseInt(elementosLinha.get(_TIPO_EVENTO)));
					evento.setCdrefugo(elementosLinha.get(_CD_REFUGO));
					evento.setDthrUltimoRefugo(elementosLinha.get(_DTHR_ULTIMO_REFUGO));
					evento.setQtde(elementosLinha.get(_QNTD));
					evento.setMilisec(String.valueOf(DataHoraRN.stringToDate(elementosLinha.get(_DTHR_ULTIMO_REFUGO), "yyyy-MM-dd HH:mm:ss.SSS").getTime()));
					evento.setIdRdzProduto(elementosLinha.get(_CD_PRODUTO));
					evento.setCb(elementosLinha.get(_BARCODE));
					evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
					evento.setOrigem(linha);
					evento.setLog(log);
					break;
				
				case ServicoFactory._INICIO_CICLO:
					evento.setTipoEvento(Integer.parseInt(elementosLinha.get(_TIPO_EVENTO)));
					evento.setCdop(elementosLinha.get(_OP_NUMERO));
					evento.setQtde(elementosLinha.get(_QNTD));
					evento.setIdRdzProduto(elementosLinha.get(_CD_PRODUTO));
					evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
					evento.setOrigem(linha);
					evento.setLog(log);
					break;
					
				case ServicoFactory._FIM_CICLO:
					evento.setTipoEvento(Integer.parseInt(elementosLinha.get(_TIPO_EVENTO)));
					evento.setCdop(elementosLinha.get(_OP_NUMERO));
					evento.setQtde(elementosLinha.get(_QNTD));
					evento.setIdRdzProduto(elementosLinha.get(_CD_PRODUTO));
					evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
					evento.setOrigem(linha);
					evento.setLog(log);
					break;
					
				case ServicoFactory._INICIAR_CIP_INOVASA:
					evento.setTipoEvento(Integer.parseInt(elementosLinha.get(_TIPO_EVENTO)));
					evento.setCdop(elementosLinha.get(_OP_NUMERO));
					evento.setCdtecResponsavel(elementosLinha.get(_CD_TECCIP));
					evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
					evento.setOrigem(linha);
					evento.setLog(log);
					break;
					
				case ServicoFactory._FINALIZAR_CIP_INOVASA:
					evento.setTipoEvento(Integer.parseInt(elementosLinha.get(_TIPO_EVENTO)));
					evento.setCdop(elementosLinha.get(_OP_NUMERO));
					evento.setCdtecResponsavel(elementosLinha.get(_CD_TECCIP));
					evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
					evento.setOrigem(linha);
					evento.setLog(log);
					break;
					
				case ServicoFactory._INICIO_VARIACAO_RITMO:
					evento.setTipoEvento(Integer.parseInt(elementosLinha.get(_TIPO_EVENTO)));
					evento.setCdop(elementosLinha.get(_OP_NUMERO));
					evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
					evento.setOrigem(linha);
					evento.setLog(log);
					break;
					
				case ServicoFactory._MOTIVO_VARRITMO:
					evento.setTipoEvento(Integer.parseInt(elementosLinha.get(_TIPO_EVENTO)));
					evento.setCdop(elementosLinha.get(_OP_NUMERO));
					evento.setCdjustificativa(elementosLinha.get(_CD_JUSTIFICATIVA));
					evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
					evento.setOrigem(linha);
					evento.setLog(log);
					break;
					
				case ServicoFactory._FIM_VARIACAO_RITMO:
					evento.setTipoEvento(Integer.parseInt(elementosLinha.get(_TIPO_EVENTO)));
					evento.setCdop(elementosLinha.get(_OP_NUMERO));
					evento.setPepro(Integer.parseInt(elementosLinha.get(_PERIODO_PRODUTIVO)));
					evento.setOrigem(linha);
					evento.setLog(log);
					break;
					
				case ServicoFactory._CCK:
					log.info("Evento CCK");
					Double consumoAtivo=null,fatorPotencia=null,correnteA=null,correnteB=null,correnteC=null,
					tensaoA=null,tensaoAB=null,tensaoAC=null,tensaoBC=null,tensaoB=null,tensaoC=null,tensaoMedia=null,
					correnteMedia=null;
					
					VerificaCCK vcck= new VerificaCCK();
					DadosLocaisCCK dadosLocaisCCK=null;
					try{
						consumoAtivo=Double.parseDouble(elementosLinha.get(_CONSUMO_ATIVO))/1000;
						
						fatorPotencia=Double.parseDouble(elementosLinha.get(_FATOR_DE_POTENCIA))/1000;
						correnteA=Double.parseDouble(elementosLinha.get(_CORRENTE_A))/1000;
						correnteB=Double.parseDouble(elementosLinha.get(_CORRENTE_B))/1000;
						correnteC=Double.parseDouble(elementosLinha.get(_CORRENTE_C))/1000;
						correnteMedia=Double.parseDouble(elementosLinha.get(_CORRENTE_MEDIA))/1000;
						tensaoA=Double.parseDouble(elementosLinha.get(_TENSAO_A))/10;		
						tensaoB=Double.parseDouble(elementosLinha.get(_TENSAO_B))/10;
						tensaoC=Double.parseDouble(elementosLinha.get(_TENSAO_C))/10;
						tensaoAB=Double.parseDouble(elementosLinha.get(_TENSAO_AB))/10;
						tensaoAC=Double.parseDouble(elementosLinha.get(_TENSAO_AC))/10;
						tensaoBC=Double.parseDouble(elementosLinha.get(_TENSAO_BC))/10;
						tensaoMedia=Double.parseDouble(elementosLinha.get(_TENSAO_MEDIA))/10;
						
						dadosLocaisCCK=vcck.getDadosLocaisFromIcUpdtoVerificaUpdate(icupdto, _CONSUMO_ATIVO);
						
						if(dadosLocaisCCK!=null){
							
							boolean isVerifica = vcck.verificaLancaAlerta(log, dadosLocaisCCK,consumoAtivo);
							
							if(isVerifica==true){
								evento = new EventoColetado();
								evento.setDthrEvento(dtHrEvento);
								evento.setIcUpDTO(icupdto);
								evento.setOrigem(linha);
								evento.setLog(log);
								evento.setParametroLido(BigDecimal.valueOf(consumoAtivo));
								evento.setTipoEvento(ServicoFactory._ALERTA_CONSUMO_ATIVO);
								retorno.add(evento);
							}
						}
	
						dadosLocaisCCK=vcck.getDadosLocaisFromIcUpdtoVerificaUpdate(icupdto, _FATOR_DE_POTENCIA);
						if(dadosLocaisCCK!=null){
							if(vcck.verificaLancaAlerta(log, dadosLocaisCCK,fatorPotencia)==true){
								evento = new EventoColetado();
								evento.setDthrEvento(dtHrEvento);
								evento.setIcUpDTO(icupdto);
								evento.setOrigem(linha);
								evento.setLog(log);
								evento.setParametroLido(BigDecimal.valueOf(fatorPotencia));
								evento.setTipoEvento(ServicoFactory._ALERTA_FATOR_DE_POTENCIA);
								retorno.add(evento);
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
								retorno.add(evento);
							}	
						}		
						*/
						
						evento = new EventoColetado();
						evento.setDthrEvento(dtHrEvento);
						evento.setIcUpDTO(icupdto);
						evento.setOrigem(linha);
						
						IwsDadosCCKDTO dadosCCK = new IwsDadosCCKDTO();
						
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
						evento.setTipoEvento(ServicoFactory._MEDICAO_CCK);
						retorno.add(evento);
					} catch (Exception e) {
						e.printStackTrace();
						log.info("Erro", e);
					}
					
					evento=null;
					break;
				
				default:
					break;
				}
	
				if (evento!=null && evento.getTipoEvento() >= 0)
					retorno.add(evento);
				
			} catch(Exception e){
				log.info("Evento INVALIDO - [" + evento.getOrigem()+"]", e);
			}
		} catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
			log.info(e);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			log.info(e);
		}

		return retorno;
	}
	
}
