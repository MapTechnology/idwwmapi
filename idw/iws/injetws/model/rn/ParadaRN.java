package injetws.model.rn;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.Validate;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.rn.DataHoraRN;
import idw.model.rn.pdba.ParadaPdbaMsEvtRN;
import idw.util.IdwLogger;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.excessoes.SemSGBDException;
import injetws.model.pojos.PrColetorEventos;
import injetws.model.pojos.PrUp;
import injetws.model.pojos.PrUpUltimaParada;
import injetws.model.rn.injet.InjetParadaRN;
import injetws.webservices.dto.IwsCicloDTO;
import injetws.webservices.dto.IwsParadaDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.ServicoFalhouException;
import ms.model.dao.AbstractPdbaInjetDAO;
import ms.model.dto.IcUpDTO;

public class ParadaRN extends AbstractPdbaInjetDAO{
	
	public ParadaRN(DAOGenericoInjet daoInjet, DAOGenerico daoPdba){
		Validate.notNull(daoInjet);
		Validate.notNull(daoPdba);
		
		this.setDaoPdba(daoPdba);
		this.setDaoInjet(daoInjet);
	}
	
	public IwsCicloDTO setTr_paradaInicio(
			IdwLogger log, int idLog,
			String idUp, 
			Date dthrInicio,
			Boolean isParadaAutomatica,
			Boolean isParadaPersistente,
			Boolean isParPeriodSemConex
			) throws ServicoFalhouException {

		IwsCicloDTO retorno = new IwsCicloDTO();
		retorno.setCicloValido(false);
		
		retorno = setTr_paradaInicio(log, idLog, idUp, dthrInicio, isParadaAutomatica,isParPeriodSemConex);
		if(retorno != null)
				setTr_UltimaParadaInicio(log, idLog, idUp, dthrInicio, isParadaPersistente);
		
		if(retorno == null)
		{
			retorno = new IwsCicloDTO();
			retorno.setCicloValido(false);
		}
		return retorno;
	}

	public IwsCicloDTO setTr_paradaInicio(
			IdwLogger log, int idLog,
			String idUp, 
			Date dthrInicio,
			Boolean isParadaAutomatica,
			Boolean isParPeriodSemConex) throws ServicoFalhouException {
		
		IwsCicloDTO dadosCiclo = new IwsCicloDTO();

		InfoRN rn = new InfoRN(getDaoInjet(),getDaoPdba());
		PrUp prUp = rn.pesquisaPrup(log, idLog, idUp);
	
		// M�quina com OP?
		// Se n�o, aborta metodo
		if (prUp.getNrop() == null || prUp.getNrop().equals("")){
			return null;
		}
		if(rn.verificaSeFinalizaOP(log, idLog, prUp)){			
			prUp.mudaIsOPConcluida(true);
			//finaliza OP
			rn.fimPlanejamento(log, idLog, idUp, dthrInicio, 0, false); //TODO: passar batidas para este trecho
			dadosCiclo.setFinaizouOP(true);
			return dadosCiclo;
		}
		if((prUp.getStparadaemaberto()!=null) &&  (prUp.getStparadaemaberto()=='1')){ //verifica��o � feita devido a poss�vel perda de eventos no coletor
			if(DataHoraRN.compareTo(dthrInicio,  DataHoraRN.getDataComMilisegundos(prUp.getDthriniultimaparada(), prUp.getMsdthriniultimaparada()))<=0){
				log.info("---IDUP:"+idUp+"- Evento desprezado por conflito de abertura de parada: Parada anterior � posterior � nova parada");
				return null;
			}
			prUp.mudaDtHrUltimoHeartBeat(dthrInicio);
			prUp.mudaMsDthrUltimoHeartBeat((double)DataHoraRN.getApenasMilisegundos(dthrInicio));
			rn.fecharParada(log, idLog, prUp);
		}
		
		// Se sim, 
		// Parada fecha ciclo?
		// Se n?o Guardar dados de in?cio da Parada em PR_UP (DtHrIniUltimaParada msDtHrIniUltimaParada StParadaEmAberta = 1)
		// Se sim, In?cio de ciclo j? preenchido?(DtHrIniCiclo, msDtHrIniCiclo preenchido)
		// Se configura??o de tamanho pacote ciclo ? maior que 1, n?o se deve fechar o ciclo por parada.
		if((prUp.getCfgtamanhoumpacoteciclos() != null) && (prUp.getCfgtamanhoumpacoteciclos().intValue() == 1)){
			if (prUp.getCfginterrupcaociclo() == null || prUp.getCfginterrupcaociclo().equals('1')){
				if (prUp.getDthrinicic() != null && prUp.getMsdthrinicic() != null){
					// Se sim, fechar ciclo
					if(rn.fecharCiclo(log, idLog, prUp, dthrInicio, 1, false, true,"Inicio Parada"))
						dadosCiclo.setCicloValido(true);
					else
						dadosCiclo.setCicloValido(false);
					//Garante que o ciclo sempre seja finalizado mesmo que haja perda de sincronismo no fechamento do ciclo.
					prUp.setDthrinicic(null);
					prUp.setMsdthrinicic(0d);
					//Adicionado para tratamaneto de tempo de espera by Senoj
					prUp.setDthrfimcic(null);
					prUp.setMsdthrfimcic(0d);
					prUp.setStcicloemaberto('0');
					dadosCiclo.setNumeroCiclosCont(prUp.getQtdciclosexecutados());
				}
			}
		}

		// Obtem ultimo evento lancado
		PrColetorEventos prcoletoreventosPesquisa = rn.obtemUltimoPrColetorEventos(prUp);

		
		// Se a data e hora de inicio da parada for inferior a data e hora do evento lido em pelo menos 1 segundos, entao
		// deve-se assumir a data e hora do ultimo evento para evitar perda de sincronia. Esse teste est� sendo feito
		// pq o MCU est� enviando um inicio de parada com tempo inferior ao fim de um ciclo e ainda n�o descobrimos o pq
		// disso est� acontecendo no MCU. Entretanto, se o inicio da parada for inferior a mais de 2 segundos em relacao ao 
		// ultimo evento, entao, nada deve ser feito e deixar o BC resetar o MCU por perda de sincronia
		String inf20 = "";
		Date dthrReferencia = dthrInicio;
		Date dthrUltimoEvento = DataHoraRN.getDataComMilisegundos(prcoletoreventosPesquisa.getDthr2evento(), prcoletoreventosPesquisa.getMsdthr2evento());

		if (dthrReferencia.before(dthrUltimoEvento)){
			if (DataHoraRN.getQuantidadeSegundosNoPeriodo(dthrReferencia, dthrUltimoEvento) <= 1){
				inf20 = dthrInicio.toString();
				dthrInicio = dthrUltimoEvento;
			} else {
				inf20 ="dif deve ser > 1s";
			}
		}
		
		PrColetorEventos evento = new PrColetorEventos();
		evento.setTpevento(new BigDecimal(8));
		evento.setDthr1evento(dthrInicio);
		evento.setMsdthr1evento(DataHoraRN.getApenasMilisegundos(dthrInicio));
		evento.setNrop(prUp.getNrop());
		evento.setCdmolde(prUp.getCdmolde());
		evento.setCdestrutura(prUp.getCdestrutura());
		evento.setDthriniplanejada(prUp.getDthriniplanejada());
		evento.setPrUp(prUp);
		evento.setInf01("1");
		if(isParPeriodSemConex == true) 
			evento.setInf03("1");
		else
			evento.setInf03("0");
		
		evento.setInf20(inf20);

		rn.lancarEventoEsperaPrColetorEventos(log, idLog, evento, false);
		
		return dadosCiclo;
	}

	/* Esse metodo eh chamado apenas pelo MS, com o objetivo de poder passar a sessao ao inves de chamar o WS diretamente */
	public boolean setTr_paradaFimWS(
			IdwLogger log, int idLog,
			String idUp, 
			Date dthrFim) {

		boolean retorno = true;

		try {
			retorno = setTr_paradaFim(log, idLog, idUp, dthrFim);
			if(retorno)
				retorno = setTr_UltimaParadaFim(log, idLog, idUp, dthrFim);
		} catch (SemSGBDException e) {
			retorno = false;
		}

		return retorno;
	}

	public boolean setTr_paradaFim(IdwLogger log, int idLog, String idUp, Date dthr) throws SemSGBDException{

		InfoRN rn = new InfoRN(getDaoInjet(),getDaoPdba());

		PrUp prup = rn.pesquisaPrup(log, idLog, idUp);
		// Setar a datahora do ultimo heart beat para ser usada como fim da parada
		prup.mudaDtHrUltimoHeartBeat(dthr);
		prup.mudaMsDthrUltimoHeartBeat((double)DataHoraRN.getApenasMilisegundos(dthr));
		try {
			rn.fecharParada(log, idLog, prup);
		} catch (ServicoFalhouException e) {
			throw new SemSGBDException();
		}

		return true;
	}	
	
	public boolean setTr_paradaMotivo(
			IdwLogger log, int idLog,
			String idUp,
			Date dthr,
			String idParada,
			String idAcao,
			String idCausa,
			String idJustificativa,
			String idTecnicoResponsavel,
			String idTecnicoUm,
			String idTecnicoDois,
			String idLocal		
	) throws ServicoFalhouException {	
		
		return setTr_paradaMotivo(log, idLog, idUp,dthr,idParada, idAcao, idCausa, idJustificativa,
				idTecnicoResponsavel, idTecnicoUm, idTecnicoDois, idLocal, null,null,0);
	}
		
	public boolean setTr_paradaMotivo(
			IdwLogger log, int idLog,
			String idUp,
			Date dthr,
			String idParada,
			String idAcao,
			String idCausa,
			String idJustificativa,
			String idTecnicoResponsavel,
			String idTecnicoUm,
			String idTecnicoDois,
			String idLocal,
			String tipoParPreConfig,
			String txtAnotacao,
			int batidas) throws ServicoFalhouException {		
		
		
		boolean retorno = true;

		InfoRN rn = new InfoRN(getDaoInjet(),getDaoPdba());

		PrUp prUp = rn.pesquisaPrup(log, idLog, idUp);
		
		if(prUp.getStparadaemaberto()==null){
			setTr_paradaInicio(log, idLog, idUp, dthr, false, false);
			prUp.setDthriniultimaparada(dthr);
			prUp.setMsdthriniultimaparada((double)DataHoraRN.getApenasMilisegundos(dthr));
		}
		// Verifica se o motivo da parada, causa, acao, justificativa existem
		//
		InjetParadaRN injparRN = new InjetParadaRN(getDaoInjet(),getDaoPdba());
		log.info(idLog, 0, "injparRN.validaApontamento");
		IwsParadaDTO paradadto 	= injparRN.validaApontamento(log, idLog, idUp, idParada, idCausa, idAcao, idJustificativa, idTecnicoUm, idTecnicoDois, idTecnicoResponsavel, idLocal);
		if(paradadto==null) {
			log.info(idLog, 0, "paradadto = null. return false");
			return false;
		}
		// Guardar dados da nova parada em PrUp
		prUp.setCdultimaparada(paradadto.getCdParada());
		
		try{
			 
			if(paradadto.getIsRegulagem()==true){
				if(prUp.getDthrinicic()!=null){					
					rn.fecharCiclo(log, idLog, prUp, DataHoraRN.getDataComMilisegundos(prUp.getDthriniultimaparada(),
							prUp.getMsdthriniultimaparada()),
							batidas, 
							false, true,"Inicio de Regulagem");

					prUp.setDthrinicic(null);
					prUp.setMsdthrfimcic(0d);
					//Adicionado para tratamaneto de tempo de espera by Senoj
					prUp.setDthrfimcic(null);
					prUp.setMsdthrfimcic(0d);
					prUp.setStcicloemaberto('0');
					getDaoPdba().flushReiniciandoTransacao();					
				}
			}
		}catch(Exception e){
			log.info("erro", e);
			e.printStackTrace();			
		}
		getDaoPdba().getSession().merge(prUp);
		

		PrColetorEventos evento = new PrColetorEventos();
		evento.setTpevento(new BigDecimal(9));
		evento.setDthr1evento(dthr);
		evento.setMsdthr1evento(DataHoraRN.getApenasMilisegundos(dthr));
		evento.setNrop(prUp.getNrop());
		evento.setCdmolde(prUp.getCdmolde());
		evento.setCdestrutura(prUp.getCdestrutura());
		evento.setDthriniplanejada(prUp.getDthriniplanejada());
		evento.setPrUp(prUp);
		if (prUp.getDthriniultimaparada() != null) {
			evento.setInf01(DataHoraRN.dateToStringYYYYMMDDHHMMSS(prUp.getDthriniultimaparada()));
			evento.setInf02(String.valueOf(prUp.getMsdthriniultimaparada()));
		}		
		evento.setInf03(idParada);
		evento.setInf04(idCausa);
		evento.setInf05(idAcao);
		evento.setInf06(idJustificativa);
		evento.setInf07(idTecnicoUm);
		evento.setInf08(idTecnicoDois);
		evento.setInf09(idTecnicoResponsavel);
		evento.setInf10(idLocal);
		evento.setInf20(tipoParPreConfig);
		evento.setTxtMensagem(txtAnotacao);
		evento.setStevento("0");

		rn.lancarEventoEsperaPrColetorEventos(log, idLog, evento, false);

		return retorno;
	}	
	
	
	public boolean setTr_UltimaParadaInicio(IdwLogger log, int idLog, String idUp, Date dthrInicio, Boolean isParadaPersistente)
	{
		boolean retorno = false;

		InfoRN rn = new InfoRN(getDaoInjet(),getDaoPdba());
		
		PrUp prup = rn.pesquisaPrup(log, idLog, idUp);
		
		PrUpUltimaParada oPrUpUltimaParada = rn.pesquisaPrup_ultimaparada(log, idLog, prup);
		
		try {		
			if(isParadaPersistente && oPrUpUltimaParada!=null){
				prup.setDthriniultimaparada(dthrInicio);
				prup.setMsdthriniultimaparada((double)DataHoraRN.getApenasMilisegundos(dthrInicio));
				retorno = setTr_paradaMotivo(log, idLog, idUp, dthrInicio,
						oPrUpUltimaParada.getCdParada(),
						oPrUpUltimaParada.getCdAcao(),
						oPrUpUltimaParada.getCdCausa(),
						oPrUpUltimaParada.getCdJustificativa(),
						oPrUpUltimaParada.getCdTecnicoResponsavel(),
						oPrUpUltimaParada.getCdTecnico1(),
						oPrUpUltimaParada.getCdTecnico2(),
						oPrUpUltimaParada.getCdLocalParada(),null,null,0);	
				prup.setStparadaemaberto('1');
				prup.setCdultimaparada(oPrUpUltimaParada.getCdParada());				
			} else {
				// Guardar dados de in�cio da Parada em PR_UP (DtHrIniUltimaParada msDtHrIniUltimaParada StParadaEmAberta = 1)
				if(oPrUpUltimaParada!=null){
					oPrUpUltimaParada.setCdAcao(null);
					oPrUpUltimaParada.setCdCausa(null);
					oPrUpUltimaParada.setCdJustificativa(null);
					oPrUpUltimaParada.setCdLocalParada(null);
					oPrUpUltimaParada.setCdParada("999999");
					oPrUpUltimaParada.setCdTecnico1(null);
					oPrUpUltimaParada.setCdTecnico2(null);
					oPrUpUltimaParada.setCdTecnicoResponsavel(null);
					oPrUpUltimaParada.setDtHrFParada(null);
					oPrUpUltimaParada.setDtHrIParada(dthrInicio);
					oPrUpUltimaParada.setIsParadaPeriodoSemConexao('0');
					oPrUpUltimaParada.setisParadaRegulagem('0');
					oPrUpUltimaParada.setTxtAnotacao(null);
					
				}else{
					oPrUpUltimaParada= new PrUpUltimaParada(prup.getIdup().toString(),dthrInicio);
				}
				prup.setDthriniultimaparada(dthrInicio);
				prup.setMsdthriniultimaparada((double)DataHoraRN.getApenasMilisegundos(dthrInicio));
				prup.setStparadaemaberto('1');
				prup.setCdultimaparada("999999");				
				retorno = true;
			}
			getDaoPdba().makePersistent(prup);
			getDaoPdba().makePersistent(oPrUpUltimaParada);
			getDaoPdba().flushReiniciandoTransacao();
		} catch (Exception e) {
			retorno = false;
			e.printStackTrace();
		}		
		return(retorno);
	}
	
	public boolean setTr_UltimaParadaFim(IdwLogger log, int idLog, String idUp, Date dthrFim)
	{
		boolean retorno = false;
		
		InfoRN rn = new InfoRN(getDaoInjet(),getDaoPdba());
		PrUp prup = rn.pesquisaPrup(log, idLog, idUp);
		PrUpUltimaParada oPrUpUltimaParada = rn.pesquisaPrup_ultimaparada(log, idLog, prup);
		
		try{
			oPrUpUltimaParada.setDtHrFParada(dthrFim);
			getDaoPdba().makePersistent(oPrUpUltimaParada);
			retorno=true;
		}catch(Exception e){
			log.info("erro", e);
		}		
		
		return(retorno);
	}
	
	public boolean setTr_UltimaParadaMotivo(
			IdwLogger log, int idLog,
			String idUp, String idParada,
			String idAcao, String idCausa, String idJustificativa,
			String idTecnicoResponsavel, String idTecnicoUm, String idTecnicoDois, String idLocal,boolean isParadaRegulagem)
	{
		boolean retorno = false;

		InfoRN rn = new InfoRN(getDaoInjet(),getDaoPdba());
		PrUp prup = rn.pesquisaPrup(log, idLog, idUp);
		
		PrUpUltimaParada oPrUpUltimaParada = rn.pesquisaPrup_ultimaparada(log, idLog, prup);
		
		if(oPrUpUltimaParada!=null){
			oPrUpUltimaParada.setCdAcao(idAcao);
			oPrUpUltimaParada.setCdCausa(idCausa);
			oPrUpUltimaParada.setCdJustificativa(idJustificativa);
			oPrUpUltimaParada.setCdLocalParada(idLocal);
			oPrUpUltimaParada.setCdParada(idParada);
			oPrUpUltimaParada.setCdTecnico1(idTecnicoUm);
			oPrUpUltimaParada.setCdTecnico2(idTecnicoDois);
			oPrUpUltimaParada.setCdTecnicoResponsavel(idTecnicoResponsavel);
			if(isParadaRegulagem)
				oPrUpUltimaParada.setisParadaRegulagem('1');
			else
				oPrUpUltimaParada.setisParadaRegulagem('0');
			oPrUpUltimaParada.setTxtAnotacao(null);	
			try{
				getDaoPdba().makePersistent(oPrUpUltimaParada);
			}catch(Exception e){
				log.info("erro", e);
			}
			retorno=true;
		}
		return(retorno);
	}
	
	public void setTr_lancaParadaSemConexao(IdwLogger log, int idLog, String idUp, Date dtHrInicio, Date dtHrFim, Boolean informaParadaDefault) {
		
		
		try{
			//?ltimo par?metro deve lan?ar TRUE por determinar a abertura de uma parada sem conex?o
			IwsCicloDTO dados = new IwsCicloDTO();
			dados = setTr_paradaInicio(log, idLog, idUp, dtHrInicio, false, true);
			if(dados != null){ 
				setTr_UltimaParadaInicio(log, idLog, idUp,dtHrInicio,false);
			}else{
				log.info(idLog,0,"NÃO - foi aberta parada Para período sem Conexão");
				return; // Não foi aberta uma parada por Iconsistência
			}

		} catch (Exception e){
			e.printStackTrace();
		}
		getDaoPdba().flushReiniciandoTransacao();
		
		
		InjetParadaRN injparRN = new InjetParadaRN(getDaoInjet(),getDaoPdba());
		String paradadefault=injparRN.getTr_ParDefSemConexao();
		
		//informaParadaDefault Não é mais utilizado Se houver uma parada default cadastrada será utilizada será utilizada
		try{
			if(dtHrInicio.before(dtHrFim))
			{						
				if(paradadefault != null) {
					setTr_UltimaParadaMotivo(log, idLog, idUp, paradadefault, "", "", "", "", "", "","",false);
					getDaoPdba().flushReiniciandoTransacao();
				}					
			}
			if(paradadefault != null) {
				boolean retorno = setTr_paradaMotivo(log, idLog, idUp, dtHrFim, paradadefault, "", "", "", "", "", "","",null,null,0);
				if(retorno) 
					setTr_UltimaParadaMotivo(log, idLog, idUp, paradadefault, "", "", "", "", "", "","",false);
			}
			else
			{
				setTr_paradaMotivo(log, idLog, idUp, dtHrFim, "999999", "", "", "", "", "", "","",null,null,0);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
			
				
	}
	
	public void setTr_AbrelancaMotivoParada(IdwLogger log, int idLog, PrUp prUp, Date dtHrInicio, String cdparada) {	
	
		boolean retorno = false;
		
		try{			
			InfoRN rn = new InfoRN(getDaoInjet(),getDaoPdba());
			PrColetorEventos evento = new PrColetorEventos();
			evento.setTpevento(new BigDecimal(8));
			evento.setDthr1evento(dtHrInicio);
			evento.setMsdthr1evento(DataHoraRN.getApenasMilisegundos(dtHrInicio));
			evento.setNrop(prUp.getNrop());
			evento.setCdmolde(prUp.getCdmolde());
			evento.setCdestrutura(prUp.getCdestrutura());
			evento.setDthriniplanejada(prUp.getDthriniplanejada());
			evento.setPrUp(prUp);
			evento.setInf01("1");			
			evento.setInf03("0");			

			rn.lancarEventoEsperaPrColetorEventos(log, idLog, evento, false);
			
			if (IdwFacade.getInstancia().isIDWAtivo()) {
					// Alessandre-tanto o inicio da parada qto o final da para estao
					// chamando o mesmo servico, e o servico ira executar inicio ou fim da parada dependendo do 
					// status de funcionamento da maquina. Encontrar uma forma de dizer q a maq esta trabalhando
					// aqui para q o servico inicio uma parada
					IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(prUp.getIdup().toString());
					
					icupdto.getUpDTO().setUpTrabalhando(true);
					
					ParadaPdbaMsEvtRN rnpdba = new ParadaPdbaMsEvtRN();
					rnpdba.executarServico(getDaoPdba().getSession(), prUp.getIdup().toString(), null, dtHrInicio, null, null, ServicoFactory._INICIO_PARADA, "setTr_AbrelancaMotivoParada " + DataHoraRN.getDataHoraAtualFormatada());
			}
			
			setTr_UltimaParadaInicio(log, idLog, prUp.getIdup().toString(),dtHrInicio,false);
			getDaoPdba().flushReiniciandoTransacao();				
			retorno = setTr_paradaMotivo(log, idLog, prUp.getIdup().toString(), dtHrInicio, cdparada, "", "", "", "", "", "","",null,null,0);
			if(retorno) setTr_UltimaParadaMotivo(log, idLog, prUp.getIdup().toString(), cdparada, "", "", "", "", "", "","",false);	
			getDaoPdba().flushReiniciandoTransacao();
						
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}		
	
	public Boolean setTr_InsereAnotacaoParada(IdwLogger log, int idLog, String idUp,String anotacao ,Date dthrevento) throws RegistroDesconhecidoException{				
		boolean retorno = false;

		InfoRN rn = new InfoRN(getDaoInjet(),getDaoPdba());
		
		PrUp prup = rn.pesquisaPrup(log, idLog, idUp);
		
		PrUpUltimaParada oPrUpUltimaParada = rn.pesquisaPrup_ultimaparada(log, idLog, prup);

		if(oPrUpUltimaParada == null)
		{
			return false;
		}
		
		try {	
			
			retorno = setTr_paradaMotivo(log, idLog, idUp, dthrevento,
					oPrUpUltimaParada.getCdParada(),
					oPrUpUltimaParada.getCdAcao(),
					oPrUpUltimaParada.getCdCausa(),
					oPrUpUltimaParada.getCdJustificativa(),
					oPrUpUltimaParada.getCdTecnicoResponsavel(),
					oPrUpUltimaParada.getCdTecnico1(),
					oPrUpUltimaParada.getCdTecnico2(),
					oPrUpUltimaParada.getCdLocalParada(),
					null, anotacao,0
					);	
			if(retorno){
				oPrUpUltimaParada.setTxtAnotacao(anotacao);
				getDaoPdba().getSession().merge(oPrUpUltimaParada);
			}
			getDaoPdba().flushReiniciandoTransacao();
		} catch (Exception e) {
			retorno = false;
			e.printStackTrace();
		}
		return retorno;
	}
	
}
