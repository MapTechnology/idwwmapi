package ms.model.rn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.hibernate.LockMode;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFtParam;
import idw.model.pojos.DwPepro;
import idw.model.pojos.MsEvt;
import idw.model.pojos.MsEvtcep;
import idw.model.pojos.MsEvtdefeito;
import idw.model.pojos.MsEvtmontagem;
import idw.model.pojos.MsMsicup;
import idw.model.pojos.MsTpevt;
import idw.model.pojos.MsUp;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmPtcp;
import idw.model.pojos.template.DwPeproTemplate;
import idw.model.pojos.template.MsEvtTemplate;
import idw.model.pojos.template.MsTpevtTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.DefeitoDTO;
import idw.webservices.dto.MontagemDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.EvtDTO;
import ms.model.dto.IcUpDTO;
import ms.model.dto.ListaEvtDTO;
import ms.model.dto.ResultadoMSDTO;

public class EventoRN extends DAOGenerico {
	
	// Metodo usado pelo WS para incluir um evento de log
	public MsEvt incluirEventoLog(EventoColetado evento) {
		IdwLogger log = new IdwLogger("EventoRN");
		int idLog = log.getIdAleatorio();
		
		// Encontra o idIcup correto a partir do cdup
		evento.setTipoEvento(MsTpevtTemplate.Type.OBS_PROCEDIMENTO.getId());
		evento.setEventoApenasInformativo(true);
		evento.setIcUpDTO(Stubedelegate.getInstancia().getMsthread().getIcUp(evento.getUp()));
		
		return incluirEvento(log, idLog, 0, evento, evento.getTipoEvento(), null).clone();
	}

	public MsEvt incluirEvento(EventoColetado evento) {
		IdwLogger log = new IdwLogger("EventoRN-" + evento.getUp());
		int idLog = log.getIdAleatorio();
		
		// Encontra o idIcup correto a partir do cdup
		evento.setIcUpDTO(Stubedelegate.getInstancia().getMsthread().getIcUp(evento.getUp()));
		
		return incluirEvento(log, idLog, 0, evento, evento.getTipoEvento(), null).clone();
	}

	// Incluir em MsEvt
	public MsEvt incluirEvento(IdwLogger log, int idLog, int identacao, EventoColetado evento, int tipoEvento, MsEvt msevtBase){
		MsEvt retorno = null;
		
		// Alessandre em 25-02-15 vou mudar para tirar essas varias tentativas de salvar o msevt pois se der erro toda a transacao deve ser desfeita inclusive a do injet
		
		retorno = saveMsEvt(log, idLog, identacao, evento, tipoEvento, msevtBase);
		
		if (retorno != null)
			log.info(idLog, identacao, "Pesquisei o evento com idEvt = " + retorno.getIdEvt());
		else
			log.info(idLog, identacao, "Pesquisei o evento mas nao encontrei");
		
		return retorno;
	}
	
	private MsEvt saveMsEvt(IdwLogger log, int idLog, int identacao, EventoColetado eventoParametro, int tipoEventoParametro, MsEvt msevtBaseParametro) {	
		// O objetivo do if abaixo eh nao incluir em msevt caso a consolidacao esteja desativada e o injet ativo,
		// assim ganharemos performance nos eventos lancados em pr_coletor_eventos
		if (IdwFacade.getInstancia().isIDWAtivo() == false && tipoEventoParametro != MsTpevtTemplate.Type.PARAMETRO_MEDICAO.getId()) {
			log.info(idLog, identacao, "IDW Inativo, descartando o evento " + eventoParametro);
			return null;
		}
		
		/* Alessandre em 07-08-19 eventos fora da janela de 24hrs a partir da data e hora do servidor serão incluidos como log. O objetivo com isso é reduzir o nivel de processamento
		 * quando ocorrem casos de data e hora com erro em periodos gigantes
		 */
		Date dthrIJanela = DataHoraRN.getDataHoraAtual();
		Date dthrFJanela = DataHoraRN.adicionaHorasDaData(dthrIJanela, 24);
		dthrIJanela = DataHoraRN.subtraiHorasDaData(dthrIJanela, 24);
		
		if (DataHoraRN.between(eventoParametro.getDthrEvento(), dthrIJanela, dthrFJanela) == false &&
				tipoEventoParametro != MsTpevtTemplate.Type.PASSAGEM.getId()) {
			eventoParametro.setEventoApenasInformativo(false);
		}
		
		// Verificar se o evento ja foi lancado. Se sim, descartar o evento gerando um log pra isso
		MsEvt msevt = null;

		// Pesquisa se o evento ja nao foi incluido, considerando a data e hora e a UP, mas se for uma perda de componente, entao nao testar
		if (
				eventoParametro != null && 
				eventoParametro.getIcUpDTO() != null && 
				tipoEventoParametro != MsTpevtTemplate.Type.PERDA_MATERIA_PRIMA.getId()
				/* &&tipoEventoParametro != MsTpevtTemplate.Type.PASSAGEM.getId() alessandre removi a possibilidade de lancar evento de passagem que ja tenha sido lancado, o objetivo eh diminuir a qtde de eventos lacandos qdo houver erro no log*/
				) {
			// Gambi - Se for o evento finaliza OP e o tipo for <> 12 (fim planejamento entao seto para 12 pois no chile inseriu um 12 mesmo ja tendo um 
			if (eventoParametro.getTipoEvento() == 20 && tipoEventoParametro != 12) {
				tipoEventoParametro = 12;
			}
			msevt = pesquisarMsEvtByDtHrUP((long) tipoEventoParametro, 
					eventoParametro.getDthrEvento(), 
					new BigDecimal(eventoParametro.getIcUpDTO().getIdIcUp()));
		}
		
		if (msevt != null){
			log.info(idLog, identacao, "Evento ja existe. Em incluirEvento descartando o evento " + eventoParametro);
			return null;
		} else {
			log.info(idLog, identacao, "Evento NAO existe. VOU incluir evento " + eventoParametro);
		}
		
		OmCfg omcfg = Util.getConfigGeral(getSession());
		
		msevt = new MsEvt();
		
		msevt.setDthrCadastrobanco(DataHoraRN.getDataHoraAtual(this));
		msevt.setDthrCadastroserver(DataHoraRN.getDataHoraAtual());
		msevt.setDthrEvento(eventoParametro.getDthrEvento());
		msevt.setSegCiclopadrao(eventoParametro.getSegCiclopadrao());;


		if (msevtBaseParametro != null){
			// Alessandre em 28-06-17 caso o EventoColetado traga o inicio do evento anterior prioriza-lo ao inves do msevt anterior
			if (eventoParametro.getDthrinicioEvento() != null)
				msevt.setDthrEventoanterior(eventoParametro.getDthrinicioEvento());
			else
				msevt.setDthrEventoanterior(msevtBaseParametro.getDthrEvento());
			msevt.setMsEvt(msevtBaseParametro);
			msevt.setMiliDuracaoevento(DataHoraRN.getQuantidadeMilisegundosNoPeriodo(msevt.getDthrEventoanterior(), msevt.getDthrEvento()));
			// o if abaixo serve para limitiar o tamanho do campo e evitar o estouro na hora de salvar no banco
			if (msevt.getMiliDuracaoevento() > 999999999l)
				msevt.setMiliDuracaoevento(999999999l);
			else if (msevt.getMiliDuracaoevento().intValue() < -999999999)
				msevt.setMiliDuracaoevento(-999999999l);
			
			log.info(idLog, identacao, msevt.getMiliDuracaoevento() + " - DIFERENCA no miliduracaoseg para dthrevento=" + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(msevt.getDthrEvento()) + " - " + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(msevt.getDthrEventoanterior()));
	
		} else {
			msevt.setDthrEventoanterior(null);
			msevt.setMsEvt(null);
			msevt.setMiliDuracaoevento(0l);
		}
		
		
		
		
		// Abaixo iremos descobrir o msicup e msup. Sera util para o metodo pesquisarMsEvtUltimoEventoProcessadoComOpValida
		// para melhoria de performance
		
		/*
		 * Existem tres formas para identificar quem foi a UP que gerou o evento
		 * 
		 * 1o Caso: A UP eh identificada pelo msicup gerado pela coleta do sinal
		 * 2o Caso: A UP eh identificada pelo upihm gerado pelo envio da informacao pelo IHM
		 * 3o Caso: A UP eh identificada pelo idUpPdba gerado pelo concentrador em C#. Nesse caso, a partir dessa informacao iremos localizar a 1a.
		 */
		// Encontra o MsMsicup
		MsRN msrn = new MsRN();
		msrn.setSession(getSession());
		MsMsicup msmsicup = null;
		
		if (eventoParametro != null && eventoParametro.getIcUpDTO() != null) {
			log.info(idLog, identacao, "INICIO - pesquisarMsMsIcupById para evento " + eventoParametro);
			
			msmsicup = msrn.pesquisarMsMsIcupById(new BigDecimal(eventoParametro.getIcUpDTO().getIdIcUp()));
			
			log.info(idLog, identacao, "FIM - pesquisarMsMsIcupById para evento " + eventoParametro);
		}
		
		msevt.setMsMsicup(msmsicup);
		
		if (msevt.getMsMsicup() != null) {
			try {
				log.info(idLog, identacao, "Foi encontrado o MsMsicup com id = " + msevt.getMsMsicup().getIdMsicup());
				
			} catch (NullPointerException e){
				e.printStackTrace();
			}
		} else {
			// Verificando se existe o idPdba
			if (eventoParametro.getIdUpPdba() != null && eventoParametro.getIdUpPdba().equals("") == false) {
				log.info(idLog, identacao, "Nao foi encontrado o MsMsicup pois msevt.getMsMsicup esta null. evento.IdUppdba = " + eventoParametro.getIdUpPdba() + " / TipoEvento = " + eventoParametro.getTipoEvento());
				
				msmsicup = msrn.pesquisarMsMsIcupByIdUpPdba(eventoParametro.getIdUpPdba());
				msevt.setMsMsicup(msmsicup);
			} else {
				
				log.info(idLog, identacao, "Nao foi encontrado o MsMsicup pois msevt.getMsMsicup esta null. evento.IcUpDTo.IdicUp = " + eventoParametro.getIcUpDTO().getIdIcUp() + " / TipoEvento = " + eventoParametro.getTipoEvento());
			}
		}
		// Teoricamente msup nunca sera null
		MsUp msup = msmsicup.getMsUp();

		
		
		
		
		
		
		
		

		// Se a ordem de producao nao foi passada (isso esta ocorrendo na perda de materia-prima) procurar qual foi a ultima op processada com sucesso para a maquina
		if (eventoParametro.getCdop() == null || eventoParametro.getCdop().trim().equals("") == true || eventoParametro.getCdop().trim().equals("op") == true) {
			log.info(idLog, identacao, "OP Vazia obtendo a ultima op valida para cdUp = " + eventoParametro.getIcUpDTO().getUpDTO().getCd_up());
			
			MsEvt msevtComOp = pesquisarMsEvtUltimoEventoProcessadoComOpValida(eventoParametro.getIcUpDTO().getUpDTO().getCd_up());
			if (msevtComOp != null)
				eventoParametro.setCdop(msevtComOp.getNrop());
			else
				eventoParametro.setCdop("op");
		}
		
		// Se for um evento do motivo da parada e nao vier o inicio da parada, entao pesquisar o ultimo evento lancado de inicio e usa-lo como referencia
		if (tipoEventoParametro == MsTpevtTemplate.Type.MOTIVO_PARADA.getId() && msevt.getDthrEventoanterior() == null) {
			MsEvt msevtUltimaparada = pesquisarMsEvtUltimaParada(eventoParametro.getIcUpDTO().getUpDTO().getCd_up());
			if (msevtUltimaparada != null) {
				msevt.setDthrEventoanterior(msevtUltimaparada.getDthrEvento());
				msevt.setMsEvt(msevtUltimaparada);
			}
		}
		
		// Inicializa msevt para inclusao
		msevt.setIdEvt(null);
		msevt.setLogin(eventoParametro.getLogin());
		msevt.setCdAcao(eventoParametro.getCdacao());
		msevt.setCdAlerta(eventoParametro.getCdalerta());
		msevt.setCdCausa(eventoParametro.getCdcausa());
		msevt.setCdConsulta(eventoParametro.getCdconsulta());
		msevt.setCdEstrutura(eventoParametro.getCdestrutura());
		msevt.setCdJustificativa(eventoParametro.getCdjustificativa());
		msevt.setCdMolde(eventoParametro.getCdmolde());
		msevt.setCdParada(eventoParametro.getCdparada());
		msevt.setCdProduto(eventoParametro.getCdproduto());
		msevt.setCdProdutoredz(eventoParametro.getIdRdzProduto());
		msevt.setCdRefugo(eventoParametro.getCdrefugo());
		msevt.setCdArea(eventoParametro.getCdarearesponsavel());
		msevt.setCdTec1(eventoParametro.getCdtec1());
		msevt.setCdTec2(eventoParametro.getCdtec2());
		msevt.setCdTecresp(eventoParametro.getCdtecResponsavel());
		
		
		if(eventoParametro.getIcUpDTO().getUpDTO().getCd_up().contains("_CEP")){
			msevt.setCdUp(eventoParametro.getUp());
			
			
		}else {
			msevt.setCdUp(msup.getCdUp());	
		}
		
		
		msevt.setSequencial(eventoParametro.getSequencial());
		msevt.setOrigem(eventoParametro.getOrigem());
		
		if (eventoParametro.getSeqbigint()!=null && eventoParametro.getSeqbigint().longValue()>0L ){
			msevt.setSeqbigint(eventoParametro.getSeqbigint());	
		}
		
		
		switch (eventoParametro.getTipoEvento()) {
			case ServicoFactory._MEDICAO_CCK:
				MsEvtcep cep1 = new MsEvtcep();
				cep1.setIdMsevtcep(null);
				cep1.setMsEvt(msevt);
				
				cep1.setEnergiaconsumida(eventoParametro.getDadosCCK().getConsumoAtivo());
				cep1.setFatorpotencia(eventoParametro.getDadosCCK().getFatorDePotencia());
				
				cep1.setTensao(eventoParametro.getDadosCCK().getTensaoMedia());
				
				cep1.setTensao1(eventoParametro.getDadosCCK().getTensaoA());
				cep1.setTensao2(eventoParametro.getDadosCCK().getTensaoB());
				cep1.setTensao3(eventoParametro.getDadosCCK().getTensaoC());
				
				cep1.setTensao1e2(eventoParametro.getDadosCCK().getTensaoAB());
				cep1.setTensao1e3(eventoParametro.getDadosCCK().getTensaoAC());
				cep1.setTensao2e3(eventoParametro.getDadosCCK().getTensaoBC());
				
				cep1.setCorrente(eventoParametro.getDadosCCK().getCorrenteMedia());
				
				cep1.setCorrente1(eventoParametro.getDadosCCK().getCorrenteA());
				cep1.setCorrente2(eventoParametro.getDadosCCK().getCorrenteB());
				cep1.setCorrente3(eventoParametro.getDadosCCK().getCorrenteC());
				
				msevt.setMsEvtceps(new HashSet<MsEvtcep>());
				msevt.getMsEvtceps().add(cep1);
				break;
		
			case ServicoFactory._MEDICAO_TEMPERATURA:
				MsEvtcep cep2 = new MsEvtcep();
				cep2.setIdMsevtcep(null);
				cep2.setMsEvt(msevt);
	
				cep2.setTemperatura(eventoParametro.getParametroLido());
				cep2.setZona(eventoParametro.getZona());
				msevt.setMsEvtceps(new HashSet<MsEvtcep>());
				msevt.getMsEvtceps().add(cep2);
				break;
			case ServicoFactory._MEDICAO_VELOCIDADE:
				MsEvtcep cep3 = new MsEvtcep();
				cep3.setIdMsevtcep(null);
				cep3.setMsEvt(msevt);
	
				cep3.setVelocidade(eventoParametro.getParametroLido());
				msevt.setMsEvtceps(new HashSet<MsEvtcep>());
				msevt.getMsEvtceps().add(cep3);
				break;
			case ServicoFactory._MEDICAO_PRESSAO:
				MsEvtcep cep4 = new MsEvtcep();
				cep4.setIdMsevtcep(null);
				cep4.setMsEvt(msevt);
				cep4.setVelocidade(eventoParametro.getVelocidade());
				cep4.setPressao(eventoParametro.getPressao());
				cep4.setTemperatura(eventoParametro.getTemperatura());
				cep4.setZona(eventoParametro.getZona());
				msevt.setMsEvtceps(new HashSet<MsEvtcep>());
				msevt.getMsEvtceps().add(cep4);
				
				
			case ServicoFactory._MEDICAO_TEMPERATURA_ZONAS_OPC:
				MsEvtcep cep5 = new MsEvtcep();
				cep5.setIdMsevtcep(null);
				cep5.setMsEvt(msevt);
				DwFtParam dwTfParamZona = new DwFtParam();
				dwTfParamZona.setIdFtParam(eventoParametro.getVelocidade().longValue());
				
				cep5.setDwFtParam(dwTfParamZona);
				cep5.setValorLidoParam(eventoParametro.getTemperatura());
				cep5.setTemperatura(eventoParametro.getParametroLido());
				cep5.setZona(eventoParametro.getZona());
				msevt.setMsEvtceps(new HashSet<MsEvtcep>());
				msevt.getMsEvtceps().add(cep5);
				break;
				
			case ServicoFactory._MEDICAO_FT_PARAM_OPC:
				
				MsEvtcep cep6 = new MsEvtcep();
 				cep6.setIdMsevtcep(null);
				cep6.setMsEvt(msevt);
				DwFtParam dwTfParamOpc = new DwFtParam();
				dwTfParamOpc.setIdFtParam(eventoParametro.getVelocidade().longValue());
				cep6.setDwFtParam(dwTfParamOpc);
			    cep6.setValorLidoParam(eventoParametro.getTemperatura());
				cep6.setTemperatura(eventoParametro.getTemperatura());
				cep6.setZona(eventoParametro.getZona());
				msevt.setMsEvtceps(new HashSet<MsEvtcep>());
				msevt.getMsEvtceps().add(cep6);
			default:
				break;
		}
				
		//TODO: Inserir as informacoes referentes de erro
		if(eventoParametro.getErroInsersora() != null){
			msevt.setCdFeeder(eventoParametro.getErroInsersora().getFeeder());
			msevt.setCdNozzle(eventoParametro.getErroInsersora().getNozzle());
			msevt.setCdComponente(eventoParametro.getErroInsersora().getComponente());
			msevt.setDepara(eventoParametro.getErroInsersora().getDepara());
			msevt.setCdDefeito(eventoParametro.getErroInsersora().getTipoErro());
			try {
				msevt.setQtErromontagem(Integer.parseInt(eventoParametro.getErroInsersora().getQtErro()));
			} catch (Exception e){
				msevt.setQtErromontagem(1);
			}
			msevt.setTpErromontagem(retornaTipoErro(eventoParametro.getErroInsersora().getTipoErro()));
		} 
		
		if (eventoParametro.getIsCbConforme() != null) {
			if (eventoParametro.getIsCbConforme())
				msevt.setTpErromontagem(0);
			else {
				msevt.setTpErromontagem(1);
				if (eventoParametro.getCddefeito() != null && eventoParametro.getCddefeito().equals("") == false)
					msevt.setCdDefeito(eventoParametro.getCddefeito());
			}
		}
		
		// 2018-08-16 Ailton: informacoes referentes a erro
		if (eventoParametro.getDefeitos() != null && eventoParametro.getDefeitos().size() > 0) {
			msevt.setMsEvtdefeitos(new HashSet<MsEvtdefeito>());
			for (DefeitoDTO defeito : eventoParametro.getDefeitos()) {
				MsEvtdefeito msEvtDefeito = new MsEvtdefeito();
				msEvtDefeito.setIdEvtdefeito(null);
				msEvtDefeito.setMsEvt(msevt);
				
				msEvtDefeito.setCdDefeito(defeito.getCdDefeito());
				msEvtDefeito.setCdPosicao(defeito.getPosicoes());
				if (defeito.getCb() != null)
					msEvtDefeito.setCb(defeito.getCb().trim());
				
				msevt.getMsEvtdefeitos().add(msEvtDefeito);
			}
		}
		
		try {
			msevt.setQtdeCiclos(new BigDecimal(eventoParametro.getQtdeciclos()));
		} catch (Exception e){
			msevt.setQtdeCiclos(null);
		}
		try {
			msevt.setQtde(new BigDecimal(eventoParametro.getQtde()));
		} catch (Exception e){
			msevt.setQtde(null);
		}
		
		msevt.setProducaoliquida(eventoParametro.getProducaoLiquida());
		msevt.setProducaorefugada(eventoParametro.getProducaoRefugada());
		msevt.setMsTpevt(pesquisarMsTpEvtById(new BigDecimal(tipoEventoParametro)));

		PTRN prn = new PTRN(getDao());
		OmPt ompt;
		try {
			ompt = prn.getOmPt(msup.getCdUp(), true);
		} catch (RegistroDesconhecidoException e) {
			ompt = null;
		}
		// Se o sistema estiver configurado habilitando o ihm troca op entao utilizar sempre a op definida em msUP e NAO for um evento de troca de OP
		boolean isIhmtrocaop = false;
		if (ompt != null && ompt.getOmTppt() != null && ompt.getOmTppt().getIsIhmtrocaop() != null) {
			isIhmtrocaop = ompt.getOmTppt().getIsIhmtrocaop();
		} else if (omcfg.getIsIhmtrocaop() != null)
			isIhmtrocaop = omcfg.getIsIhmtrocaop();

		/* Alessandre em 01-09-16 a linha abaixo foi comentada pq o inova deixou de enviar o campo preenchido. Alem disso, caso o cip seja aberto pelo tablet
		 * a inormacao ficaria inconistente
		 */
		msevt.setDwPepro(pesquisarDwPeproById(new BigDecimal(eventoParametro.getPepro())));
		if (ompt != null && msevt.getDwPepro() == null) {
			if (ompt.getIsCipAtivado() != null && ompt.getIsCipAtivado()) {
				msevt.setDwPepro(pesquisarDwPeproById(new BigDecimal(DwPeproTemplate.Type.CONTROLE_REINICIO_DE_PROCESSO.getId())));
			} else {
				msevt.setDwPepro(pesquisarDwPeproById(new BigDecimal(DwPeproTemplate.Type.NORMAL.getId())));
			}
		}


		if (msevt.getMsMsicup() != null) {
			// Verificar se a o programa em MsUp esta igual ao recebido no evento. Se nao for modificar em MsUp
			if (
					msup.getNrop() != null && 
					msevt.getNrop() != null && 
					msup.getNrop().equals(msevt.getNrop()) == false) {
				// Soh mudara a OP se o ihm nao trocar op
				if (isIhmtrocaop == false) {
					msup.setNrop(msevt.getNrop());
					makePersistent(msup);
				}
			}
		}

		if (
				isIhmtrocaop == true && 
				msup.getNrop() != null && 
				msup.getNrop().equals("") == false &&
				eventoParametro.getTipoEvento() != ServicoFactory._NOVA_OP) {
			msevt.setNrop(msup.getNrop());
		} else 
			msevt.setNrop(eventoParametro.getCdop());
		
		if (eventoParametro.getCb() !=  null)
			msevt.setCb(eventoParametro.getCb().trim());
		if (eventoParametro.getCbserial() != null)
			msevt.setCbserial(eventoParametro.getCbserial().trim());
		
		// O UpIhm seria a informacao do 2o Caso. Mas devemos verificar qual informacao esta vindo para podermos grava-la aqui. No momento isso nao foi visto.
		msevt.setMsUpihm(null);
		if (eventoParametro.isEventoApenasInformativo() == true)
			msevt.setStEvt(MsEvtTemplate.StEvt.APENASLOG.getValueBigDecimal());
		else
			msevt.setStEvt(MsEvtTemplate.StEvt.PENDENTE.getValueBigDecimal());
		
		/*
		 * Se houver dados de montagem inicializar pojo MsEvtMontagem
		 */
		if (eventoParametro.getMontagem() != null) {
			msevt.setIsMontagemfechadaantecipadamente(eventoParametro.getIsMontagemFechadaAntecipadamente());
			msevt.setMsEvtmontagems(new HashSet<MsEvtmontagem>());
			for (MontagemDTO dto : eventoParametro.getMontagem()) {
				MsEvtmontagem evtmon = new MsEvtmontagem();
				if (dto.getCb() != null)
					evtmon.setCb(dto.getCb().trim());
				evtmon.setDsmontagem(dto.getDsProdutoEsperado());
				evtmon.setIdEvtmontagem(null);
				evtmon.setMsEvt(msevt);
				evtmon.setOrdem(dto.getOrdem());
				
				evtmon.setCdProduto(dto.getDsProdutoEsperado());
				
				// Se o coletor informar qual o produto acoplado entao usar o informado
				if (dto.getIdProdutoAcoplado() > 0l) {
					OmProduto omprodutoAcoplado = getDao().findById(OmProduto.class, dto.getIdProdutoAcoplado(), false);
					if (omprodutoAcoplado != null)
						evtmon.setCdProduto(omprodutoAcoplado.getCdProduto());
				}
				
				msevt.getMsEvtmontagems().add(evtmon);
			}
		}
		

		log.info(idLog, identacao, "Vou inserir o evento " + msevt.toString());
		msevt.setIdEvt(null);
		msevt = makePersistent(msevt);
		log.info(idLog, identacao, "Inserido evento com sucesso. idEvt = " + msevt.getIdEvt() + " dthrevento = " + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(msevt.getDthrEvento()));
		
		if (msevt.getMsMsicup() == null)
			log.info(idLog, identacao, "O MsMsicup foi salvo null");
		if (msevt.getIdEvt() == null)
			log.info(idLog, identacao, "idevet esta null");
		
		eventoParametro.setIdEvt(new BigDecimal(msevt.getIdEvt()));
		return msevt;
	}
	
	public DwPepro pesquisarDwPeproById(BigDecimal idPepro){
		MapQuery q = new MapQuery(this.getSession());
		q.append("from DwPepro dwpepro where dwpepro.idPepro = :idpepro");
		q.defineParametro("idpepro", idPepro.longValue());
		q.setMaxResults(1);
		return (DwPepro) q.uniqueResult();
	}
	public MsTpevt pesquisarMsTpEvtById(BigDecimal idTpEvt){
		MapQuery q = new MapQuery(this.getSession());
		q.append("from MsTpevt mstpevt where mstpevt.idTpevt = :idtpevt");
		q.defineParametro("idtpevt", idTpEvt.longValue());
		q.setMaxResults(1);
		return (MsTpevt) q.uniqueResult();
	}
	public MsEvt pesquisarMsEvtById(Long idEvt){
		MapQuery q = new MapQuery(this.getSession());
		q.append("select msevt");
		q.append("from MsEvt msevt");
		q.append("join fetch msevt.msMsicup msmsicup");
		q.append("join fetch msmsicup.msIc");
		q.append("where msevt.idEvt = :idevt");

		q.defineParametro("idevt", idEvt);

		return (MsEvt) q.uniqueResult();
	}
	
	/* O objetivo desse metodo eh saber se um evento de determinado tipo na data e hora existe. Se existir o chamador do metodo nao dever� incluir
	 * um evento que ja exista.
	 */
	private MsEvt pesquisarMsEvtByDtHrUP(Long idTpevt, Date dthr, BigDecimal id){
		MapQuery q = new MapQuery(this.getSession());
		q.append("select msevt");
		q.append("from MsEvt msevt");
		q.append("join msevt.msMsicup msmsicup");
		q.append("where msevt.dthrEvento = :dthr and msmsicup.idMsicup = :id");
		q.append("and msevt.msTpevt.idTpevt = :idtpevt");

		q.defineParametroTimestamp("dthr", dthr);
		q.defineParametro("id", id);
		q.defineParametro("idtpevt", idTpevt);
		
		q.setMaxResults(1);

		return (MsEvt) q.uniqueResult();
	}

	/*
	 * O objetivo desse metodo eh saber se existe um lancamento de ciclo no PT para determinado CB afim de nao lancar mais um ciclo caso exista
	 */
	public MsEvt pesquisarMsEvtByCBeUP(String cb, BigDecimal id, String nrop ){
		MapQuery q = new MapQuery(this.getSession());
		q.append("select msevt");
		q.append("from MsEvt msevt");
		q.append("join msevt.msMsicup msmsicup");
		q.append("where msmsicup.idMsicup = :id");
		q.append("and msevt.cb = :cb");
		q.append("and msevt.nrop = :nrop");
		q.append("and msevt.qtde > 0");

		q.defineParametro("id", id);
		q.defineParametro("cb", cb);
		q.defineParametro("nrop", nrop);
		
		q.setMaxResults(1);
		MsEvt retorno= (MsEvt) q.uniqueResult();
		
		return retorno;
	}

	
	
	
	/* Usado para avaliar se a passagem ja foi lancada com mesmo CB e horario e posto
	 * 
	 */
	public MsEvt pesquisarMsEvtByCBeUPeDthr(String cb, String cdup, Date dthr ){
		MapQuery q = new MapQuery(this.getSession());
		q.append("select msevt");
		q.append("from MsEvt msevt");
		q.append("where msevt.cdUp = :cd");
		q.append("and msevt.cb = :cb");
		q.append("and msevt.dthrEvento = :dthr");
		q.append("and msevt.stEvt = 1");

		q.defineParametro("cd", cdup);
		q.defineParametro("cb", cb);
		q.defineParametroTimestamp("dthr", dthr);
		
		q.setMaxResults(1);
		MsEvt retorno= (MsEvt) q.uniqueResult();
		
		return retorno;
	}

	
	/*
	 * O objetivo desse metodo eh saber se existe um lancamento de ciclo no PT para determinado CB afim de nao lancar mais um ciclo caso exista
	 */
	public MsEvt pesquisarMsEvtByCBePtNropFinalCiclo(String cb, String cdpt, String nrop ){
		MapQuery q = new MapQuery(this.getSession());
		q.append("select msevt");
		q.append("from MsEvt msevt");
		q.append("join msevt.msMsicup msmsicup");
		q.append("join msmsicup.msUp msup");
		q.append("where msup.cdUp = :cdpt");
		q.append("and msevt.cb = :cb");
		q.append("and msevt.nrop = :nrop");
		q.append("and msevt.qtde > 0");
		q.append("and msevt.stEvt = 1");
		q.append("and msevt.msTpevt.idTpevt = 2");

		q.defineParametro("cdpt", cdpt);
		q.defineParametro("cb", cb);
		q.defineParametro("nrop", nrop);
		
		q.setMaxResults(1);
		MsEvt retorno= (MsEvt) q.uniqueResult();
		
		return retorno;
	}
	
	/**
	 * O objetivo desse metodo eh obter o ultimo lancamento de ciclo no PT para 
	 * determinado CB
	 * @param cb
	 * @param cdpt
	 * @param nrop
	 * @return
	 */
	public MsEvt pesquisarMsEvtByNropUltimoFinalCiclo(String cb, String cdpt, String nrop ){
		MapQuery q = new MapQuery(this.getSession());
		q.append("select msevt");
		q.append("from MsEvt msevt");
		q.append("join msevt.msMsicup msmsicup");
		q.append("join msmsicup.msUp msup");
		q.append("where msup.cdUp = :cdpt");
		q.append("and msevt.cb = :cb");
		q.append("and msevt.nrop = :nrop");
		q.append("and msevt.qtde > 0");
		// q.append("and msevt.stEvt = 1");
		q.append("and msevt.stEvt != 2");
		q.append("and msevt.msTpevt.idTpevt = 2");
		q.append("order by msevt.idEvt desc");

		q.defineParametro("cdpt", cdpt);
		q.defineParametro("cb", cb);
		q.defineParametro("nrop", nrop);
		
		q.setMaxResults(1);
		MsEvt retorno= (MsEvt) q.uniqueResult();
		
		return retorno;
	}
	
	/**
	 * O objetivo desse metodo eh obter o ultimo refugo lancado 
	 * no PT para determinado CB
	 * @param cb
	 * @param cdpt
	 * @param nrop
	 * @return
	 */
	public MsEvt pesquisarMsEvtByNropUltimoRefugo(String cb, String cdpt, String nrop ){
		MapQuery q = new MapQuery(this.getSession());
		q.append("select msevt");
		q.append("from MsEvt msevt");
		q.append("join msevt.msMsicup msmsicup");
		q.append("join msmsicup.msUp msup");
		q.append("where msup.cdUp = :cdpt");
		q.append("and msevt.cb = :cb");
		q.append("and msevt.nrop = :nrop");
		q.append("and msevt.qtde > 0");
		// q.append("and msevt.stEvt = 1");
		q.append("and msevt.stEvt != 2");
		q.append("and msevt.msTpevt.idTpevt = 10");
		q.append("order by msevt.idEvt desc");

		q.defineParametro("cdpt", cdpt);
		q.defineParametro("cb", cb);
		q.defineParametro("nrop", nrop);
		
		q.setMaxResults(1);
		MsEvt retorno= (MsEvt) q.uniqueResult();
		
		return retorno;
	}

	/*
	 * O objetivo desse metodo eh verificar se existe evento do CB para outro PT
	 */
	public MsEvt pesquisarMsEvtByCBeUPDiferente(String cb, String cdpt){
		MapQuery q = new MapQuery(this.getSession());
		q.append("select msevt");
		q.append("from MsEvt msevt");
		q.append("join msevt.msMsicup msmsicup");
		q.append("join msmsicup.msUp msup");
		q.append("where msup.cdUp = :cd");
		q.append("and msevt.cb = :cb");

		q.defineParametro("cd", cdpt);
		q.defineParametro("cb", cb);
		
		q.setMaxResults(1);
		MsEvt retorno= (MsEvt) q.uniqueResult();
		
		return retorno;
	}
	
	public String pesquisarLog(BigDecimal idEvento, BigDecimal tpEvento){
		IdwLogger log = new IdwLogger("Pesquisar Log por IdEvento");
		log.iniciaAvaliacao("pesquisa log por id");
		
		log.info("Inicia PESQUISAR LOG POR ID");
		Log4jRN logRN = new Log4jRN();
		MsEvt msEvt = pesquisarMsEvtById(idEvento.longValue());
		String conexao = msEvt.getMsMsicup().getMsIc().getUrlConexao();
		String dir = logRN.getDiretorioLog();
		String nomeArquivo = getNomeLog(tpEvento);
		
		File file = new File(dir + "\\ms" + conexao + nomeArquivo);
		String linha = "";
		List<String> linhas = new ArrayList<String>();
		StringBuilder retorno = new StringBuilder();
		try {
			log.info("carregando arquivo " + file.getName());
			
			FileReader fileReader = new FileReader(file);
			LineNumberReader leitor = new LineNumberReader(fileReader);
			 
			int pos = 0;
			log.info("procurando evento de id = " + idEvento);
			while ((linha = leitor.readLine()) != null) {
			    linhas.add(linha);
			    
			    if (linha.contains("EventoID:" + idEvento + " - Atividade:")){
					
					 pos = leitor.getLineNumber() - 20;
					 if (pos < 0){
						 pos = 0;
					 }
					 break;
				 }
				
			}
			
			log.info("preparando log de retorno");
			for ( int x = pos; x < linhas.size() ;x++){
				retorno.append(linhas.get(x));
				retorno.append("\n");
			}
			
			leitor.close();
		    fileReader.close();
		    
		} catch (FileNotFoundException e) {
			log.info("Arquivo nao encontrado");
			e.printStackTrace();
		} catch (IOException e) {
			log.info("Erro de leitura do arquivo");
			e.printStackTrace();
		}
		
		log.paraAvaliacao();
		log.info("Concluido com sucesso :" + log.getAvaliacaoCompleta());
		return retorno.toString();
	}
	
	private String getNomeLog(BigDecimal tpEvento){
		int x = tpEvento.intValue();
		return MsTpevtTemplate.Type.getType(x).getSufixolog();
	}
	
	public ListaEvtDTO pesquisarListaEvtDTO(String cdUp, int qtLinhas){
		List<EvtDTO> listaEvtDTO = new ArrayList<EvtDTO>();

		MapQuery q = new MapQuery(this.getSession());
		
		q.append("select msevt ");
		q.append("from MsEvt msevt ");
		q.append("where msevt.cdUp = :cdUp");
		q.append("order by msevt.idEvt desc");

		q.setMaxResults(qtLinhas);
		q.defineParametro("cdUp", cdUp);
		
		List<MsEvt> listaMsEvt = q.list();
		
		for (MsEvt msevt : listaMsEvt){
			listaEvtDTO.add(new EvtDTO(msevt));
		}
		
		ListaEvtDTO retorno = new ListaEvtDTO();
		
		retorno.setListaEvtDTO(listaEvtDTO);
		
		List<MsUp> listaUp = null;
		if (listaEvtDTO == null || listaEvtDTO.isEmpty()) {
			listaUp = pesquisaMsUpPorTpIc(cdUp);
			if(listaUp != null && !listaUp.isEmpty()){
				retorno.setResultadoDTO(new ResultadoMSDTO());
				retorno.getResultadoDTO().setIdMensagem(10);
			}
		}
		
		
		
		return retorno;
	}
	
	private List<MsUp> pesquisaMsUpPorTpIc(String cdUp){
		
		MapQuery q = new MapQuery(this.getSession());
		
		q.append("select msmsicup ");
		q.append("from MsMsicup msmsicup ");
		q.append("where msmsicup.msIc.tpIc = :tpIc");
		q.append(" and msmsicup.msUp.cdUp = :cdUp");

		BigDecimal tpIc = new BigDecimal(3);
		q.defineParametro("tpIc", tpIc);
		q.defineParametro("cdUp", cdUp);
		List<MsUp> listaMsUp = q.list();
		return listaMsUp;
	}



	/*
	 * Encontra o ultimo evento de alerta aberto para determinada UP e determinado alerta
	 */
	public MsEvt pesquisarMsEvtUltimoEventoAberto(EventoColetado evento, Integer idTpEvt){
		// Determina qual o codigo da up a ser usada
		String cdUp = null;
		
		if (evento.getIcUpDTO() != null && evento.getIcUpDTO().getUpDTO() != null && evento.getIcUpDTO().getUpDTO().getCd_up() != null){
			cdUp = evento.getIcUpDTO().getUpDTO().getCd_up();
		} else if (evento.getIdUpPdba() != null){
			cdUp = evento.getIdUpPdba();
		}
		
		// Pesqusia no banco
		MapQuery q = new MapQuery(this.getSession());

		// Se o codigo de barras tiver sido definido entao devemos pegar o ultimo refugo independente da maquina mas dependente do refugo
		if (evento.getCb() != null && evento.getCb().equals("") == false) {
			q.append("select msevt");
			q.append("from MsEvt msevt");
			q.append("where msevt.msTpevt.idTpevt = :idTpevt");
			q.append("and msevt.cb = :cb");
			q.append("order by msevt.idEvt desc");
		} else {
			q.append("select msevt ");
			q.append("from MsEvt msevt ");
			q.append("join msevt.msMsicup msmsicup");
			q.append("where msmsicup.msUp.cdUp = :cdUp");
			q.append("and msevt.msTpevt.idTpevt = :idTpevt");
			q.append("order by msevt.idEvt desc");
		}
		
		q.defineParametro("cdUp", cdUp);
		q.defineParametro("idTpevt", (long) idTpEvt);
		q.defineParametro("cb", evento.getCb());
//		1 	inicio de ciclo        
//		2 	fim de ciclo           
//		3 	inicio de parada       
//		4 	fim de parada          
//		5 	inicio de alerta       
//		6 	fim de alerta          
//		7 	inicio de login        
//		8 	fim de login           
//		9 	motivo de parada       
//		10	refugo                 
//		11	solicitacao de consulta
//		12	saida de planejamento  
//		13	entrada de planejamento
//		14	inicio de turno        
//		15	final de turno         
//		16	inicio de hora         
//		17	final de hora          
//		18	heart-beat  
//		19 erro insersora
		q.setMaxResults(1);
		
		MsEvt retorno = (MsEvt) q.uniqueResult();
		
		return retorno;
	}
	
	
	private int retornaTipoErro(String codigoErro){
		int retorno = 1;
		if(codigoErro != null && !codigoErro.equals("")){
			try {
				if (codigoErro.equals("MISSING"))
					retorno = 5;
				else
					retorno = Integer.parseInt(codigoErro);
			} catch (Exception e) {
				retorno = 1;
			}
		}
		return retorno;
	}
	
	private MsEvt pesquisarMsEvtUltimoEventoProcessadoComOpValida(String cdup){

		MsEvt msevt = null;
		MapQuery q = new MapQuery(this.getSession());
		q.append("select msevt ");
		q.append("from MsEvt msevt ");
		q.append("where");
		q.append("msevt.cdUp = :cdup");
		q.append("and msevt.stEvt <> 2 and msevt.nrop <> 'op'");
		q.append("order by msevt.idEvt desc");

		q.defineParametro("cdup", cdup);

		q.setMaxResults(1);
		
		q.query().setLockMode("msevt", LockMode.NONE);

		msevt = (MsEvt) q.uniqueResult();

		return msevt; //msevt.getIdEvt()
	}
	
	public MsEvt pesquisarMsEvtUltimaParada(String cdUp){
		MapQuery q = new MapQuery(this.getSession());
		q.append("select msevt");
		q.append("from MsEvt msevt");
		q.append("join msevt.msMsicup msicup");
		q.append("join msicup.msUp msup");
		q.append("where msup.cdUp = :cdup");
		q.append("and msevt.msTpevt.idTpevt in (3,4)"); // inicio ou final de parada 
		q.append("order by msevt.idEvt desc");
		q.defineParametro("cdup", cdUp);
		q.setMaxResults(1);
		
		MsEvt msevt = (MsEvt) q.uniqueResult();
		
		return msevt;
	}

	public MsEvt pesquisarMsEvtUltimaMotivoParada(String cdUp){
		MapQuery q = new MapQuery(this.getSession());
		q.append("select msevt");
		q.append("from MsEvt msevt");
		q.append("join msevt.msMsicup msicup");
		q.append("join msicup.msUp msup");
		q.append("where msup.cdUp = :cdup");
		q.append("and msevt.msTpevt.idTpevt in (9)"); // inicio ou final de parada 
		q.append("order by msevt.idEvt desc");
		q.defineParametro("cdup", cdUp);
		q.setMaxResults(1);
		
		MsEvt msevt = (MsEvt) q.uniqueResult();
		
		return msevt;
	}

	public boolean pesquisaDeletaUltimosMsEvtByDtHr(IdwLogger olog, Date dthrrefExclusao,int numeroRegistros){
		boolean retorno=false;
		if(numeroRegistros>2000){
			numeroRegistros=2000;
			olog.info("Limitando eclusao para 2000 eventos! ");
		}
		try{
			MapQuery q = new MapQuery(this.getSession());
			q = new MapQuery(this.getSession());
			q.append("update MsUp msup ");
			q.append("set msup.msEvtByIdEvtiniciociclo=null, ");
			q.append("msup.msEvtByIdEvtinicioparada=null ");
			q.append("where msup.stAtivo=0 ");
			q.query().executeUpdate();
			
			flushReiniciandoTransacao();
			q = new MapQuery(this.getSession());
			q.append("select msevt.idEvt");
			q.append("from MsEvt msevt");
			q.append("where msevt.stEvt <> 0");
			q.append("and msevt.dthrEvento < :dthr");
			q.append("and msevt.msEvt is not null");
			q.append("and not exists (from MsEvt b where b.msEvt.idEvt = msevt.idEvt)");
			q.append("and not exists (from MsUp c where c.msEvtByIdEvtiniciociclo.idEvt = msevt.idEvt)");
			q.append("and not exists (from MsUp d where d.msEvtByIdEvtinicioparada.idEvt = msevt.idEvt)");
			q.append("order by msevt.idEvt asc");

			q.defineParametro("dthr", dthrrefExclusao);
			
			q.setMaxResults(numeroRegistros);
			
			List<Object> listaIdMsevt=q.list();
			
			if(listaIdMsevt!=null && listaIdMsevt.size()>0){
				q = new MapQuery(this.getSession());
				q.append("update MsEvt msevt");
				q.append("set msevt.msEvt=null");
				q.append("where msevt.msEvt.idEvt in (:lista) ");
				q.append("and msevt.stEvt <> 0 ");
				q.defineListaParametro("lista",listaIdMsevt);	
			}else{
				olog.info("Nao ha eventos para excluir ");
			}
			
			flushReiniciandoTransacao();
			if(listaIdMsevt.size()>0){	
				olog.info("Excluindo "+listaIdMsevt.size()+" registros");
				q = new MapQuery(this.getSession());
				q.append("delete MsEvt msevt ");
				q.append("where msevt.idEvt in (:lista) ");
				q.defineListaParametro("lista",listaIdMsevt);
				q.query().executeUpdate();				
			}	
			listaIdMsevt=null;
			q=null;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return retorno;
	}



	
	// por Alessandre
	public boolean pesquisaDeletaUltimosMsEvtByDtHr2(IdwLogger olog, Date dthrrefExclusao,int numeroRegistros){
		boolean retorno=false;
		if(numeroRegistros>2000){
			numeroRegistros=2000;
			olog.info("Limitando eclusao para 2000 eventos! ");
		}
		try{
			MapQuery q = new MapQuery(this.getSession());
			q = new MapQuery(this.getSession());
			q.append("update MsUp msup ");
			q.append("set msup.msEvtByIdEvtiniciociclo=null, ");
			q.append("msup.msEvtByIdEvtinicioparada=null ");
			q.append("where msup.stAtivo=0 ");
			q.query().executeUpdate();
			
			flushReiniciandoTransacao();
	
			q = new MapQuery(this.getSession());

			q.append("update MsEvt msevt");
			q.append("set msevt.msEvt = null");
			q.append("where msevt.stEvt <> 0");
			q.append("and msevt.dthrEvento < :data");
			q.append("and msevt.msEvt is not null");
			q.append("and not exists (from MsEvt b where b = msevt.msEvt and b.stEvt = 0)");
			q.append("and not exists (from MsUp c where c.msEvtByIdEvtiniciociclo = msevt)");
			q.append("and not exists (from MsUp d where d.msEvtByIdEvtinicioparada = msevt)");
	
			q.defineParametro("data", dthrrefExclusao);
			
			q.setMaxResults(numeroRegistros);

			int i = q.query().executeUpdate();
			
			olog.info("Total registros preparados para exclusao " + i);
			
			flushReiniciandoTransacao();

			q = new MapQuery(this.getSession());
			q.append("delete MsEvt msevt ");
			q.append("where msevt.stEvt <> 0");
			q.append("and msevt.dthrEvento < :data");
			q.append("and msevt.msEvt is null");
			q.append("and not exists (from MsEvt b where b.msEvt.idEvt = msevt.idEvt)");
			q.append("and not exists (from MsUp c where c.msEvtByIdEvtiniciociclo.idEvt = msevt.idEvt)");
			q.append("and not exists (from MsUp d where d.msEvtByIdEvtinicioparada.idEvt = msevt.idEvt)");

			q.defineParametro("data", dthrrefExclusao);
			q.setMaxResults(numeroRegistros);

			i = q.query().executeUpdate();
			
			olog.info("Total excluidos " + i);

			q=null;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public MsEvt pesquisarUltimoEventoLancadoRelativoAOP(IcUpDTO icup, MsUp msup){
		if(icup != null && icup.getIdIcUp() != null) {
			return pesquisarUltimoEventoLancadoRelativoAOPByIdMsIcUp(new BigDecimal(icup.getIdIcUp()));
		}
		if(msup != null && msup.getIdUp() != null)
			return pesquisarUltimoEventoLancadoRelativoAOPByIdUp(msup.getIdUp());
		return null;
	}
	
	public MsEvt pesquisarUltimoEventoLancadoRelativoAOPByIdMsIcUp(BigDecimal idmsicup){
		List<Object> listaTpEvt = new ArrayList<Object>();
		listaTpEvt.add(MsTpevtTemplate.Type.INICIO_CICLO.getIdLong());
		listaTpEvt.add(MsTpevtTemplate.Type.FIM_CICLO.getIdLong());
		listaTpEvt.add(MsTpevtTemplate.Type.MOTIVO_REFUGO.getIdLong());
		listaTpEvt.add(MsTpevtTemplate.Type.FINAL_SAIDA_PLANEJAMENTO.getIdLong());
		listaTpEvt.add(MsTpevtTemplate.Type.ENTRADA_PLANEJAMENTO.getIdLong());
		listaTpEvt.add(MsTpevtTemplate.Type.CANCELAMENTO_REFUGO.getIdLong());
		listaTpEvt.add(MsTpevtTemplate.Type.PASSAGEM.getIdLong());
		listaTpEvt.add(MsTpevtTemplate.Type.INICIO_CIP.getIdLong());
		listaTpEvt.add(MsTpevtTemplate.Type.FIM_CIP.getIdLong());
	
		MsEvt msevt = null;
	
		MapQuery q = new MapQuery(this.getSession());
		
		q.append("select msevt ");
		q.append("from MsEvt msevt ");
		q.append("where ");
		q.append("msevt.msMsicup.idMsicup = :idMsicup");
		q.append("and msevt.msTpevt.idTpevt in (:listaTpEvt) and msevt.stEvt!=0");
		q.append("order by msevt.idEvt desc");
		q.defineParametro("idMsicup", idmsicup);
		
		q.defineListaParametro("listaTpEvt", listaTpEvt);
		q.setMaxResults(1);
		
		msevt = (MsEvt) q.uniqueResult();

		return msevt;
	}
	
	public MsEvt pesquisarUltimoEventoLancadoRelativoAOPByIdUp(BigDecimal idup){
		List<Object> listaTpEvt = new ArrayList<Object>();
		listaTpEvt.add(MsTpevtTemplate.Type.INICIO_CICLO.getIdLong());
		listaTpEvt.add(MsTpevtTemplate.Type.FIM_CICLO.getIdLong());
		listaTpEvt.add(MsTpevtTemplate.Type.MOTIVO_REFUGO.getIdLong());
		listaTpEvt.add(MsTpevtTemplate.Type.FINAL_SAIDA_PLANEJAMENTO.getIdLong());
		listaTpEvt.add(MsTpevtTemplate.Type.ENTRADA_PLANEJAMENTO.getIdLong());
		listaTpEvt.add(MsTpevtTemplate.Type.CANCELAMENTO_REFUGO.getIdLong());
		listaTpEvt.add(MsTpevtTemplate.Type.PASSAGEM.getIdLong());
		listaTpEvt.add(MsTpevtTemplate.Type.INICIO_CIP.getIdLong());
		listaTpEvt.add(MsTpevtTemplate.Type.FIM_CIP.getIdLong());
	
		MsEvt msevt = null;
	
		MapQuery q = new MapQuery(this.getSession());
		
		q.append("select msevt ");
		q.append("from MsEvt msevt ");
		q.append("where msevt.msMsicup.msUp.idUp = :idUp");
		q.append("and msevt.msTpevt.idTpevt in (:listaTpEvt) and msevt.stEvt!=0");
		q.append("order by msevt.idEvt desc");
		q.defineParametro("idUp", idup);
		
		q.defineListaParametro("listaTpEvt", listaTpEvt);
		q.setMaxResults(1);
		
		msevt = (MsEvt) q.uniqueResult();

		return msevt;
	}

	public MsEvt pesquisarMsEvtUltimoEventoLancado(String cdUp){

		MsEvt msevt = null;
		
			MapQuery q = new MapQuery(this.getSession());
			
			q.append("select msevt ");
			q.append("from MsEvt msevt ");
			q.append("join msevt.msMsicup msmsicup");
			q.append("where msmsicup.msUp.cdUp = :cdUp");
			q.append("order by msevt.idEvt desc");

			q.defineParametro("cdUp", cdUp);
			q.setMaxResults(1);
			
			msevt = (MsEvt) q.uniqueResult();

		return msevt;
	}
	
	public MsEvt pesquisarMsEvtUltimoEventoLancadoComOrigem(String cdUp){

		MsEvt msevt = null;
		
			MapQuery q = new MapQuery(this.getSession());
			
			q.append("select msevt ");
			q.append("from MsEvt msevt ");
			q.append("join msevt.msMsicup msmsicup");
			q.append("where msmsicup.msUp.cdUp = :cdUp");
			q.append("and origem not like ''");
			q.append("and msevt.qtde is not null");
			q.append("order by msevt.idEvt desc");

			q.defineParametro("cdUp", cdUp);
			q.setMaxResults(1);
			
			msevt = (MsEvt) q.uniqueResult();

		return msevt;
	}
	
	public MsEvt pesquisarMsEvtUltimoEventoLancado(String nrop, String cdUp){

		MsEvt msevt = null;
		
			MapQuery q = new MapQuery(this.getSession());
			
			q.append("select msevt ");
			q.append("from MsEvt msevt ");
			q.append("join msevt.msMsicup msmsicup");
			q.append("where msmsicup.msUp.cdUp = :cdUp");
			//q.append("and msmsicup.msUp.nrop = :nrop");
			q.append("and msevt.nrop = :nrop");
			q.append("and msevt.qtde is not null");
			q.append("and origem != ''");
			q.append("order by msevt.idEvt desc");

			q.defineParametro("nrop", nrop);
			q.defineParametro("cdUp", cdUp);
			q.setMaxResults(1);
			
			msevt = (MsEvt) q.uniqueResult();

		return msevt;
	}

	public Date pesquisarDthrUltimaEntradaPlanejamento(Long idPt) {

		OmPtcp ptcp = null;
		
		MapQuery q = new MapQuery(this.getSession());
		q.append("select omptcp ");
		q.append("from OmPtcp omptcp");
		q.append("join omptcp.omPt ompt");
		q.append("where ompt.idPt = :idPt");
		q.append("and ompt.stAtivo = 1");
		q.append("and omptcp.dthrEntrada IS NOT NULL");
		q.append("order by omptcp.dthrEntrada desc");

		q.defineParametro("idPt", idPt);
		q.setMaxResults(1);
		
		ptcp = (OmPtcp) q.uniqueResult();
		
		Date retorno = null;
		try{
			retorno = ptcp.getDthrEntrada();
		} catch(Exception e){
			retorno = null;
		}

		return retorno;
	}
	
	public DwFolha obtemDwFolhaDaUltimaOPQueSaiuDeMaquina(OmPt ompt) {
		DwFolha retorno = null;
		
		MapQuery q = new MapQuery(this.getSession());
		q.novaConsulta();
		q.append("select dwfolha ");
		q.append("from OmPtcp omptcp");
		q.append("join omptcp.omPt ompt");
		q.append("join omptcp.ppCp ppcp");
		q.append("join ppcp.dwFolha dwfolha");
		q.append("where ");
		if(ompt.getIdPt() != null) {
			q.append("ompt.idPt = :idPt");
		} else {
			q.append("ompt.cdPt = :cdPt and ompt.stAtivo=1");
		}
		q.append("and omptcp.dthrSaida IS NOT NULL");
		q.append("order by omptcp.dthrSaida desc");
		
		if(ompt.getIdPt() != null) {
			q.defineParametro("idPt", ompt.getIdPt());
		} else {
			q.defineParametro("cdPt", ompt.getCdPt());
		}
		
		q.setMaxResults(1);
		
		try {
			retorno = (DwFolha) q.uniqueResult();
		} catch(Exception e) {
			retorno = null;
		}
		
		return retorno;
	}
}
