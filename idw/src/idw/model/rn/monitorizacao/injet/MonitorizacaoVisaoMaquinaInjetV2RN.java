package idw.model.rn.monitorizacao.injet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.hibernate.SQLQuery;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwTParada;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgind;
import idw.model.pojos.OmIndpt;
import idw.model.pojos.OmIndtppt;
import idw.model.pojos.OmObj;
import idw.model.pojos.OmPt;
import idw.model.pojos.injet.Ijindiceselabels;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.pojos.template.OmIndTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.DiversosInjetRN;
import idw.model.rn.injet.TurnoInjetRN;
import idw.model.rn.monitorizacao.ObjetoNaTelaFactory;
import idw.util.AritmeticaUtil;
import idw.util.IdwLogger;
import idw.webservices.dto.GtDTO;
import idw.webservices.dto.GtRtDTO;
import idw.webservices.dto.GtRtMonitorizacaoDTO;
import idw.webservices.dto.ObjDTO;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;
import idw.webservices.dto.ObjsDTO;
import idw.webservices.dto.ObjsRtMonitorizacaoDTO;
import idw.webservices.dto.TurnoAtualDTO;
import idw.webservices.rest.dto.monitorizacao.injet.CfgParamConcOP;
import idw.webservices.rest.v2.injet.dto.monitorizacao.DataTurnoReferenciaDTO;
import idw.webservices.rest.v2.injet.dto.monitorizacao.ValoresPtMonitorizacaoDTO;
import injetws.model.excessoes.RegistroDesconhecidoException;
import ms.util.ConversaoTipos;

// Para a versão InjetWeb 2 (node)

public class MonitorizacaoVisaoMaquinaInjetV2RN extends MonitorizacaoInjetV2RN {

	public MonitorizacaoVisaoMaquinaInjetV2RN() {
		super();
	}


	public MonitorizacaoVisaoMaquinaInjetV2RN(DAOGenericoInjet dao) {
		super(dao);
	}

	/**
	 * Esse eh o metodo chamado para criacao da tela de monitorizacao com os
	 * icones Dados Monitorizaçãoo em tempo real do Grupo de Trabalho
	 * 
	 * @param GtRtDTO
	 * @param tpId
	 *            - tipo do período (hora, turno, acumulado, mês/ano)
	 * @return <code>GtRtDTO</code> com detalhes da monitorizaçãoo
	 */
	public GtRtMonitorizacaoDTO getTelaMonitorizacaoMaquina(DAOGenerico dao, GtRtDTO filtro, DwConsolidTemplate.TpId tpId) {
		IdwLogger log = new IdwLogger("MonitorizacaoVisaoMaquina");


		//20200526
		DataTurnoReferenciaDTO dthrefdto = null;
		dthrefdto = getDataTurnoReferencia();


		if (filtro.getDtReferencia()!=null){
			filtro.setDtReferencia(DataHoraRN.getDataSemHora(filtro.getDtReferencia()));
		} else {
			if (dthrefdto!=null && dthrefdto.getDtref()!=null){
				filtro.setDtReferencia(DataHoraRN.getDataSemHora(dthrefdto.getDtref()));
			}
		}


		//20200526
		filtro.setIsTurnoAtual(false);
		if (dthrefdto!=null && dthrefdto.getDtref()!=null && filtro!=null && filtro.getDtReferencia()!=null){
			if ( (filtro.getDtReferencia().equals(dthrefdto.getDtref()))   ){

				if (filtro.getDwTurno()!=null && filtro.getDwTurno().getCdTurno()!=null && !filtro.getDwTurno().getCdTurno().trim().equals("")){

					if(filtro.getDwTurno().getCdTurno().trim().equals(dthrefdto.getCdturno().trim())){
						filtro.setIsTurnoAtual(true);
					} else {
						filtro.setIsTurnoAtual(false);
					}

				} else {
					if (filtro.getDwTurno()==null){	DwTurno dwt = new DwTurno(); }
					filtro.getDwTurno().setCdTurno(dthrefdto.getCdturno().trim());
					filtro.setIsTurnoAtual(true);
				}
			}
		}





		// Instancia objeto de retorno
		GtRtMonitorizacaoDTO retorno = new GtRtMonitorizacaoDTO();
		retorno.setObjsRtMonitorizacaoDTO(new ObjsRtMonitorizacaoDTO());
		retorno.getObjsRtMonitorizacaoDTO().setObjsRtMonitorizacao(new ArrayList<ObjRtMonitorizacaoDTO>());
		retorno.setGtDTO(new GtDTO());
		retorno.getGtDTO().setGt(filtro.getGtDTO().getGt());


		if (retorno.getGtDTO().getGt() == null || filtro.getGtDTO().getGt().getIdGt() == null) {			
			return retorno;
		}



		retorno.setDtReferencia(filtro.getDtReferencia());

		// config de indicadores
		OmCfg omcfg = new OmCfg();
		DAOGenericoInjet daoInj = new DAOGenericoInjet();
		daoInj.iniciaSessao();

		DiversosInjetRN divrn = new DiversosInjetRN(getDao());
		divrn.setDaoSession(getDaoSession());
		String cdLingua = "";

		cdLingua = "000000";//20200519
		/*
		try {
			cdLingua = divrn.getCdLingua();
		} catch (StringIndexOutOfBoundsException e) {
			cdLingua = "000000";
		}*/


		// / * 20200519
		Ijindiceselabels ijindiceselabels = new Ijindiceselabels();
		try {
			ijindiceselabels = divrn.pesquisarIjindiceselabels(cdLingua);
		} catch (RegistroDesconhecidoException e) {
			ijindiceselabels.setCdlingua(cdLingua);
			ijindiceselabels.setEficrealizacao(new BigDecimal(90));
			ijindiceselabels.setEficciclo(new BigDecimal(99));

		}
		// * /


		daoInj.finalizaSessao();


		// pega os objetos que fazem parte do GT		
		log.iniciaAvaliacao("getObjsDTO");
		ObjsDTO listaobjs = this.getObjsDTO(log, filtro.getGtDTO().getGt().getIdGt(), filtro.getIdPt(), true);
		log.mostrarAvaliacaoCompleta();

		// Varre todos os objetos que compoe a tela do GT que sera monitorizado com o objetivo de instancia cada objeto desse, conforme o seu tipo? PT GT Imagem, etc
		log.iniciaAvaliacao("for em getObjs");


		//20200525 trocado posicao
		//TURNO
		TurnoInjetRN rnturnoij = new TurnoInjetRN(getDao());
		TurnoAtualDTO turnoReferencia = null;
		//Se o pt nao tiver um turno entao usar o turno do filtro
		if (turnoReferencia == null) {
			turnoReferencia = new TurnoAtualDTO();
			turnoReferencia.setDwturno(filtro.getDwTurno());
		}
		retorno.setDthrRefresh(DataHoraRN.getDataHoraAtual());
		
		retorno.setTurnoReferencia(turnoReferencia);
		
		log.mostrarAvaliacaoCompleta();
		log.iniciaAvaliacao("Algoritmo TRECHO TURNOREF");
		if (turnoReferencia != null){
			retorno.getTurnoReferencia().prepararSerializacao();
		}
		// Finalizano o metodo preparando algumas informacoes para retorno
		OmPt ompt = new OmPt();	
		//  Pega a referencia o 1o pt e em qual turno ele está
		////log.iniciaAvaliacao("Restante 1 do algoritmo");
		for (ObjRtMonitorizacaoDTO obj : retorno.getObjsRtMonitorizacaoDTO().getObjsRtMonitorizacao()) {
			if (obj.getTipoObj() == 0) { //PT
				ompt.setIdPt(obj.getIdPt());
				ompt.setCdPt(obj.getCdPt());
				try {
					turnoReferencia = rnturnoij.getTurnoAtualDTOPassandoDtTurnoEIdTurno(filtro.getDtReferencia(),filtro.getDwTurno().getIdTurno());
					if (turnoReferencia != null) {
						break;
					}
				} catch (SemCalendarioException e) {
					continue;

				} catch (IllegalStateException e) {
					continue;
				}
			}
		}
		log.mostrarAvaliacaoCompleta();


		//20200525
		String tst= "";
		List<ValoresPtMonitorizacaoDTO> valoresptmonitorizacaodto = null;
		//20200616 valoresptmonitorizacaodto = getDadosParaMonitoracaoInjet(retorno.getDtReferencia(), filtro.getDwTurno().getCdTurno(),  filtro.getGtDTO().getGt().getCdGt(), cdLingua)	;	

		//PRDPLANOPgetDadosParaMonitoracaoInjet //20200616 
///20200729paraentrarProdutoapedidos		valoresptmonitorizacaodto = PRDPLANOP2getDadosParaMonitoracaoInjet(retorno.getDtReferencia(), filtro.getDwTurno().getCdTurno(),  filtro.getGtDTO().getGt().getCdGt(), cdLingua)	;	

		//20200729 acrescentado dsproduto: acrescimo uns 150ms em media considerando srinjet-labmap em 2020729
		valoresptmonitorizacaodto = PRDPLANOP3getDadosParaMonitoracaoInjet(retorno.getDtReferencia(), filtro.getDwTurno().getCdTurno(),  filtro.getGtDTO().getGt().getCdGt(), cdLingua)	;	

//		valoresptmonitorizacaodto = PRDPLANOP3getDadosParaMonitoracaoInjet(retorno.getDtReferencia(), filtro.getDwTurno().getCdTurno(),  filtro.getGtDTO().getGt().getCdGt(), cdLingua)	;	
		
		
		int i = 0;
		i=0;
		for (ObjDTO obj : listaobjs.getObjs()) {


			DwTParada par = new DwTParada();
			par.setCdTparada("999999");

			// parada sem peso
			omcfg.setDwTParada(par);

			omcfg.setOmCfginds(new HashSet<OmCfgind>());




			/* 20200526

			OmCfgind metaEfiRea = divrn.getMetaEfiReaInjetToVF(ijindiceselabels.getEficrealizacao(), obj.getObj().getOmPt().getCdPt());			
			OmCfgind metaEfiCic = divrn.getMetaEfiCicInjetToVF (ijindiceselabels.getEficciclo(), obj.getObj().getOmPt().getCdPt());
			OmCfgind metaIndRef =  divrn.getMetaIndRefInjetToVF();
			//OmCfgind metaIndPar = new OmCfgind();
			omcfg.getOmCfginds().add(metaEfiRea);
			omcfg.getOmCfginds().add(metaEfiCic);
			omcfg.getOmCfginds().add(metaIndRef);
			 */


			ObjRtMonitorizacaoDTO objetoDaTela = this.montaObjetoNaTelaMonitorizacao(log, obj, tpId, retorno.getDtReferencia(), filtro.getDwTurno(), omcfg, filtro.getIsTurnoAtual(), filtro.getFiltroOP());



			if (objetoDaTela != null) {


				/*
				int p = 0;
				if (objetoDaTela.getCdPt().equals("INJ_off_5526")){
					p=0;
				}	
				*/
							
				//20200525
				objetoDaTela = setValoresMonitorizacaoEmObjRtMonitorizacaoDTO(objetoDaTela, valoresptmonitorizacaodto, omcfg, obj, turnoReferencia.getDwturno(), filtro.getIsTurnoAtual());//20200525
				
				objetoDaTela.setIdTurno(filtro.getDwTurno().getIdTurno());

				retorno.getObjsRtMonitorizacaoDTO().getObjsRtMonitorizacao().add(objetoDaTela);
			}
		}
		//log.mostrarAvaliacaoCompleta();

		
		log.iniciaAvaliacao("Restante 2 do algoritmo");




		return retorno;

	}



	private ObjRtMonitorizacaoDTO setValoresMonitorizacaoEmObjRtMonitorizacaoDTO(ObjRtMonitorizacaoDTO objparam, List<ValoresPtMonitorizacaoDTO> listavalores, OmCfg omCfg, ObjDTO obj, DwTurno dwt, boolean isTurnoAtual){
		ObjRtMonitorizacaoDTO retorno = null;
		retorno = objparam;

		TempoRealInjetRN ijrtrn = new TempoRealInjetRN(this.getDao());


		/*
		int p = 0;
		if (objparam.getCdPt().equals("INJ_off_5526")){
			p=0;
		}
		
		if (objparam.getCdPt().equals("INJ_off_5526")){
			p=0;
		}		
		*/


		if (objparam==null ){ return retorno; }
		if (objparam.getCdPt()==null){ return retorno; }
		if (objparam.getCdPt().trim().equals("")){ return retorno; }
		String cdpt = "";
		cdpt = objparam.getCdPt().trim();
		ValoresPtMonitorizacaoDTO valores = null;
		if (listavalores==null){ return retorno; }
		String comparar = "";
		for(ValoresPtMonitorizacaoDTO val : listavalores){
			comparar = val.getCdinjestendido().trim();
			if(comparar.equals(cdpt)){
				valores = val;
				break;
			}
		}
		if (valores==null) {return retorno;}
		OmPt ompt = null;
		if (obj!=null && obj.getObj()!=null && obj.getObj().getOmPt()!=null){
			ompt = obj.getObj().getOmPt();
		}
		if (ompt==null) {return retorno;}


		

		DiversosInjetRN rnIj = new DiversosInjetRN(this.getDao());
		CfgParamConcOP cfgGeralInjet = rnIj.getParamConcOP();
		

		Double eficrealizacao = 0d;//efic_rea
		Double eficciclo = 0d; // efic_cic
		Double eficciclomedio = 0d;
		Double eficinstantanea = 0d; //ind_disp
		Double indiceproducao = 0d; //oee-efireamaq
		Double indicecavativas = 0d; // ind_cav
		Double indiceoee = 0d; //oee



		OmCfgind metaEfiRea = new OmCfgind();			
		OmCfgind metaEfiCic = new OmCfgind();
		OmCfgind metaIndRef = new OmCfgind();
		metaEfiRea.setIndMeta( ConversaoTipos.converterParaBigDecimal(valores.getEfiCicMaq()));			
		metaEfiCic.setIndMeta( ConversaoTipos.converterParaBigDecimal(valores.getEfiCicMaq()));
		metaIndRef.setIndMeta( ConversaoTipos.converterParaBigDecimal(valores.getIndRefMaiorQue()));
		omCfg.getOmCfginds().add(metaEfiRea);
		omCfg.getOmCfginds().add(metaEfiCic);
		omCfg.getOmCfginds().add(metaIndRef);


		eficrealizacao = valores.getEfi_rea().doubleValue();//efic_rea
		eficciclo = valores.getEfi_cic().doubleValue(); // efic_cic
		eficciclomedio = eficciclo;
		eficinstantanea = 0d; //TODO: //valores.getInd_disp().doubleValue(); //ind_disp
		indiceproducao = 0d; //TODO: //todo prdop/plaop ja descrito mas lento execucao
		
		indiceproducao = valores.getIndprd().doubleValue();
		
		indicecavativas = valores.getInd_cav().doubleValue(); // ind_cav
		indiceoee = valores.getOee().doubleValue(); //oee


		// ****************** MAQUINA DENTRO DA META ? ****************
		boolean isMaquinaDentroDaMeta = false;
		isMaquinaDentroDaMeta =  true;	
		for (int i=0;i<1;i++){
			/**
			 * Eficiencia de ciclo medio, calculada usando uma regra de 3 simples e
			 * direta, onde ciclo padrao esta para 100 assim como ciclo medio esta
			 * para x
			 */
			if (ompt.getOmIndpts() != null && ompt.getOmIndpts().isEmpty() == false) {

				for (OmIndpt indPt : ompt.getOmIndpts()) {

					if (IdwFacade.IS_IDW_ATIVO) {
						// testa EficienciaRealizacao
						if (indPt.getIdIndpt() == 1) {

							if (indPt.getIndMeta() == null || indPt.getIndMeta().longValue() > eficrealizacao.longValue()) {
								isMaquinaDentroDaMeta =  false;
								break;
							}

						}

						// testa EficienciaCiclomedio
						if (indPt.getIdIndpt() == 2) {

							if (indPt.getIndMeta() == null || indPt.getIndMeta().longValue() > eficciclo.longValue()) {
								isMaquinaDentroDaMeta =  false;
								break;
							}

							if (indPt.getIndMeta() == null || indPt.getIndMeta().longValue() > eficciclo.longValue()) {
								isMaquinaDentroDaMeta =  false;
								break;
							}
						}
					} else {
						// testa EficienciaRealizacao
						if (indPt.getOmInd().getCdInd().equals("ER")) {

							if (indPt.getIndMeta() == null || indPt.getIndMeta().longValue() > eficrealizacao.longValue()) {
								isMaquinaDentroDaMeta =  false;
								break;
							}

						}

						// testa EficienciaCiclomedio
						if (indPt.getOmInd().getCdInd().equals("EC")) {

							if (indPt.getIndMeta() == null || indPt.getIndMeta().longValue() > eficciclo.longValue()) {
								isMaquinaDentroDaMeta =  false;
								break;
							}

							if (indPt.getIndMeta() == null || indPt.getIndMeta().longValue() > eficciclo.longValue()) {
								isMaquinaDentroDaMeta =  false;
								break;
							}
						}					
					}

				}
			} else if (ompt.getOmTppt().getOmIndtppts() != null && ompt.getOmTppt().getOmIndtppts().isEmpty() == false) {

				// TODO verificar indice dentro do OmTppt
				for (OmIndtppt indTppt : ompt.getOmTppt().getOmIndtppts()) {
					// testa EficienciaCiclomedio
					if (indTppt.getIdIndtppt() == 1) {
						if (indTppt.getNumMeta() == null || indTppt.getNumMeta().longValue() > eficciclo.longValue()) {
							isMaquinaDentroDaMeta =  false;
							break;
						}
					}

					// testa EficienciaUltimoCiclo
					if (indTppt.getIdIndtppt() == 2) {

						if (indTppt.getNumMeta() == null || indTppt.getNumMeta().longValue() > eficciclo.longValue()) {
							isMaquinaDentroDaMeta =  false;
							break;
						}

						if (indTppt.getNumMeta() == null || indTppt.getNumMeta().longValue() > eficciclo.longValue()) {
							isMaquinaDentroDaMeta =  false;
							break;
						}
					}

				}
			} else if (omCfg.getOmCfginds() != null && omCfg.getOmCfginds().isEmpty() == false) {

				for (OmCfgind omCfgInd : omCfg.getOmCfginds()) {
					/*
					 * 1 ER 2 EC 3 IR 4 IP
					 */
					if (omCfgInd.getOmInd().getIdInd() == 1) {
						if (eficrealizacao.longValue() < omCfgInd.getIndMeta().longValue()) {
							isMaquinaDentroDaMeta =  false;
							break;
						}
					}

					if (omCfgInd.getOmInd().getIdInd() == 2) {
						if (eficciclo.longValue() < omCfgInd.getIndMeta().longValue()) {
							isMaquinaDentroDaMeta =  false;
							break;
						}

						if (eficciclo.longValue() < omCfgInd.getIndMeta().longValue()) {
							isMaquinaDentroDaMeta =  false;
							break;
						}
					}

					if (omCfgInd.getOmInd().getIdInd() == 3) {
						if ( valores.getInd_ref().longValue() > omCfgInd.getIndMeta().longValue()) {
							isMaquinaDentroDaMeta =  false;
							break;
						}
					}

					if (omCfgInd.getOmInd().getIdInd() == 4) {
						if ( valores.getInd_par().longValue() > omCfgInd.getIndMeta().longValue()) {
							isMaquinaDentroDaMeta =  false;
							break;
						}
					}

				}
			}
				
			break;
		}


		// *************** FIM ***** MAQ DENT MET ********************

		// setar os valores do Turno
		retorno.setCdTurno(dwt.getCdTurno());
		retorno.setDsTurno(dwt.getDsTurno());
		retorno.setIdTurno(dwt.getIdTurno());

		// set valores obj - setarValoresNoObjeto - 202005
		retorno.setEfiRealizacao( eficrealizacao);
		retorno.setEfiCiclos( eficciclo);
		retorno.setIndiceRefugos( valores.getInd_ref().doubleValue());
		retorno.setIndiceProducao( indiceproducao);
		retorno.setIndiceParadas( valores.getInd_par().doubleValue());
		retorno.setProdutividadeOEE( indiceoee);
		retorno.setIndiceCavAtivas(  indicecavativas);

		// Defeito #6508 - InjetWeb: Tela de monitoramento do web está exibindo dados de indicadores diferentes do injet
		if (isTurnoAtual) { 
			retorno.setEfiInstantanea( eficinstantanea);
		} else {
			retorno.setEfiInstantanea(0d);
		}

		if (valores.getInd_qld() != null){
			retorno.setIndiceDefeito( valores.getInd_qld().doubleValue());}
		else{
			retorno.setIndiceDefeito(0d);}

		retorno.setIndOEE(indiceoee);
		// Verificando se a maquina esta dentro da meta
		retorno.setDentroDaMeta(isMaquinaDentroDaMeta);

		/*
		p = 0;
		if (objparam.getCdPt().equals("INJ_off_5526")){
			p=0;
		}
		*/
		
		
		// isOffline, isParada:
		
		// -- '0' - parada , '1' - produzindo , '2' - sem conexão
		retorno.setParada( valores.getStfuncionamento() != null && valores.getStfuncionamento().trim().equals("0"));

		// -- '0' - parada , '1' - produzindo , '2' - sem conexão
		if(retorno.isParada()){ retorno.setOffline(false); }

		// -- '0' - parada , '1' - produzindo , '2' - sem conexão
		boolean isProduzindo = false;
		isProduzindo = (valores.getStfuncionamento() != null && valores.getStfuncionamento().trim().equals("1"));
		if(isProduzindo){ retorno.setOffline(false); }
		
		// -- '0' - parada , '1' - produzindo , '2' - sem conexão
		retorno.setOffline( valores.getStfuncionamento() != null && valores.getStfuncionamento().trim().equals("2"));
		
		
		

		
		boolean b = false;

		b = false; 
		if (retorno.isParada() && valores.getParcompeso()!=null){
			if (valores.getParcompeso().equals(1)){
				b=true;
			}
		}
		retorno.setParadaComPeso( b );
		
		

		retorno.setTemPlanejamento(true);//TODO: tem planejamento

		b = false; if (valores.getAlertaInspQld() !=null){ if (valores.getAlertaInspQld().longValue()>0){b=true;}}
		if (valores.getQtAleParCIP()  !=null){ if (valores.getQtAleParCIP().longValue()>0){b=true;}}
		if (valores.getQtAlertasExtrInsp() !=null){ if (valores.getQtAlertasExtrInsp().longValue()>0){b=true;}}
		if (valores.getQtAlertasExtrPar() !=null){ if (valores.getQtAlertasExtrPar().longValue()>0){b=true;}}
		if (valores.getQtAlertasOperador() !=null){ if (valores.getQtAlertasOperador().longValue()>0){b=true;}}
		if (valores.getQtAlertasProbQld()  !=null){ if (valores.getQtAlertasProbQld().longValue()>0){b=true;}}
		retorno.setComAlerta(b);



		b = false; 
		if (valores.getStDelayConsol() !=null){ 
			if (valores.getStDelayConsol().longValue()>0){
				b=true;
			}
		}
		retorno.setConsolidacaoPendente( b );//oxe

		// retorno.setTemOperador(b);//oxe

		// retorno.setOffline(b);

		// retorno.setParada(b);

		

		b = false; //setParadaSemPesoEfic
		if (retorno.isParada()){ 
			if (retorno.isParadaComPeso()){
				b=false;
			} else 
			{
				b=true;
			} 
		}
		retorno.setParadaSemPesoEfic(b);
		
		
		b = false; //setParadaNaoInformada
		if (retorno.isParada()){ 
			if (valores.getParnaoinf()!=null && valores.getParnaoinf().equals(1)){
				b=true;
			}
		}
		retorno.setParadaNaoInformada(b);
		

		 
		
		b = false; //setParadaNaoInformada
		if (retorno.isParada()){ 
			if (valores.getParnaoinf()!=null && valores.getParnaoinf().equals(1)){
				b=true;
			} 
		}
		retorno.setParadaNaoInformada(b);		
		
		


		b = false; 
		if (valores.getStManut()  !=null){ if (valores.getStManut().longValue()>0){b=true;}}
		if (valores.getStManut()  !=null){ if (valores.getStManut().equals(1)){b=true;}}
		retorno.setParadaManutencao(b);


		
		/*
		p = 0;
		if (objparam.getCdPt().equals("INJ_off_5526")){
			p=0;
		}
		*/
		
		// efic instantanea
		if (!retorno.isOffline() && !retorno.isParada()){
			if (valores.getEficinstantanea() != null){
				BigDecimal bd = new BigDecimal(0L);
				bd = BigDecimal.valueOf( valores.getEficinstantanea().doubleValue() );
				//?bd = bd.setScale(0, BigDecimal.ROUND_FLOOR);
				retorno.setEfiInstantanea(bd.doubleValue());
			}		
		}





		b= false;
		if (objparam!=null && !objparam.isOffline() && isTurnoAtual && valores!=null && valores.getCdmoldeatual()!=null && !valores.getCdmoldeatual().trim().equals("")){
			b = ijrtrn.isAlertaVidaUtilMolde(valores.getCdmoldeatual());
			retorno.setAlertaVidaUtil(b);
		}		
		
		
		
		
		//op concluida 90%
		
		/*
		p = 0;
		if (objparam.getCdPt().equals("INJ_off_5526")){
			p=0;
		}
		*/
				

		//
		 //  no injet a definicao para conclusao de op tem duas config distintas
		 //  1. Se ijconger.TpVerifConcOP = "1"  >>  ijconger.VlVefifConcOP indica o perc de conclusao da OP (nao necessariamente 90)
		 //  2. Se ijconger.TpVerifConcOP = "2"  >>  ijconger.VlVefifConcOP indica a quantidade de horas para conclusao da OP
		// 
		if (cfgGeralInjet.getTpVerifConcOP().equals("1")) {
			BigDecimal porcentagemOp = new BigDecimal(( valores.getQtpliqop().doubleValue() / valores.getQtplanop().doubleValue()));
			retorno.setOpConcluida90PorCento(porcentagemOp.doubleValue() >= cfgGeralInjet.getVlVerifConcOP().doubleValue());						
		} else {
			if (valores.getNropatual() != null) {
				retorno.setOpConcluida90PorCento(isHorasConclusaoOP(valores.getNropatual(), valores.getCdinjestendido(), cfgGeralInjet.getVlVerifConcOP()));	
			}
		}
		
		
		//op concluida - TODO: pois tem uma rotina demorada para pegar plano op
		// Op estara concluida se Producao Planejada for igual a producao
		// liquida
		retorno.setOpConcluida(valores.getQtplanop().doubleValue() - valores.getQtpliqop().doubleValue() <= 0);

		
		 	

		//indice refugo 3%
				// Verificar se o indice de refugo esta acima da meta
				// obter o limite definido para o indice de refugo. Se nao existir
				// adotar o 3%
				double indiceRefugoMaximo = 3d;
				for (OmCfgind omcfgind : omCfg.getOmCfginds()) { 
					if ( omcfgind!=null && omcfgind.getOmInd()!=null && omcfgind.getOmInd().getIdInd() == OmIndTemplate.Tipo.INDICE_REFUGO.getId()) {
						indiceRefugoMaximo = omcfgind.getIndMeta().doubleValue();
					}
				}

				if ( valores.getInd_ref().doubleValue() >= indiceRefugoMaximo) {
					retorno.setIndiceRefugo3porCento(true);
				} else {
					retorno.setIndiceRefugo3porCento(false);
				}		


				/*
				p = 0;
				if (objparam.getCdPt().equals("INJ_off_5526")){
					p=0;
				}				
				
				if (objparam.getCdPt().equals("INJ_off_5526")){
					p=0;
				}	
				*/	
		
				
		/*		
		//teste cavatva100
		if (retorno!=null){
			if(!retorno.isParada()){
				if(retorno.getIndiceCavAtivas().equals(0d)){
					if(retorno.getEfiRealizacao().equals(0d) 
					   && retorno.getEfiCiclos().equals(0d)
					   && retorno.getIndiceProducao().equals(0d)
					   && retorno.getIndiceParadas().equals(0d)
					   ){
						retorno.setIndiceCavAtivas(100d);//tst
					}
				}
			}
		}*/
				
				
		retorno.setCdProduto(valores.getCdproduto());
		retorno.setDsProduto(valores.getDsproduto());
		
		if (dwt!=null){
			retorno.setIdTurno(dwt.getIdTurno());	
		}
		

		return retorno;

	}


	private boolean isCIPExtrapoladoInjet(String cdPt) {
		boolean isRetorno = false;
		TempoRealInjetRN rn = new TempoRealInjetRN(this.getDao());
		isRetorno = rn.isCipExtrapolado(cdPt);		
		return isRetorno;
	}
		

	@SuppressWarnings("unchecked")
	private boolean isHorasConclusaoOP(String nrOP, String cdPt, BigDecimal horasParaConclusao) {
		boolean retorno = false;
		boolean isOPConcluida = true;
		
		//op concluida 90%
		
		/*
		int p = 0;
		if (cdPt.equals("INJ_off_5526")){
			p=0;
		}		
		*/
		
		
		if (! nrOP.equals("")) {
			int _produto = 0;
			int _cicloPadrao = _produto + 1;
			int _fatorContagem = _cicloPadrao + 1;
			int _pcsCicloAtivas = _fatorContagem + 1;
			int _prodPlan = _pcsCicloAtivas + 1;
			int _prodLiquida = _prodPlan + 1;
			
			
			class Registro {
				String cdProduto;
				BigDecimal cicloPadrao = BigDecimal.ZERO;
				BigDecimal fatorContagem = BigDecimal.ZERO;
				BigDecimal pcsCicloAtivas = BigDecimal.ZERO;
				BigDecimal prodLiquida = BigDecimal.ZERO;
				BigDecimal prodPlan = BigDecimal.ZERO;
			}
			
						
			String strSQL = "";
			strSQL = strSQL.concat("SELECT p.cdproduto, ft.ciclopadrao, ft.fatorcontagemprod, mp.qtcavativas, ");
			strSQL = strSQL.concat("       (p.qtpecasproduzir / dc.divisorUB) as prodplan,  ");
			strSQL = strSQL.concat("       (CASE WHEN r.prodliquida IS NULL THEN 0 ELSE r.prodliquida END) prodliq ");
			strSQL = strSQL.concat("  FROM ijop a ");
			strSQL = strSQL.concat("  JOIN ijopprodutos p on (p.nrop = a.nrop AND p.cdmolde = a.cdmolde AND p.cdestrutura = a.cdestrutura) "); 
			strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
			strSQL = strSQL.concat("  JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrfvalcic IS NULL) ");
			strSQL = strSQL.concat("  JOIN ijmolpro mp ON (mp.cdmolde = ft.cdmolde AND mp.cdestrutura = ft.cdestrutura AND mp.dthrival = ft.dthrivalestru) ");
			strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
			
			//sub-query com total produzido liquido
			strSQL = strSQL.concat("  LEFT JOIN (SELECT a.cdproduto, ");
			strSQL = strSQL.concat("                    SUM(a.prodbruta - a.prodrefugada) as prodliquida ");
			strSQL = strSQL.concat("               FROM viewBIDtRefProdutos a ");
			strSQL = strSQL.concat("              WHERE a.nrop = :nrop ");
			strSQL = strSQL.concat("                AND a.cdinjestendido = :cdpt ");
			strSQL = strSQL.concat("             GROUP BY a.cdproduto) r ON (r.cdproduto = p.cdproduto) ");
						
			strSQL = strSQL.concat(" WHERE a.nrop = :nrop ");
			strSQL = strSQL.concat("   AND i.cdinjestendido = :cdpt ");
			
			List<Object> lista = new ArrayList<Object>();
			SQLQuery q = this.getDao().getSession().createSQLQuery(strSQL);
			q.setString("nrop", nrOP)
			  .setString("cdpt", cdPt);
			
			lista = q.list();
			
			Date dtHrAtual = DataHoraRN.getDataHoraAtual();
			Date dtHrFimPrev = dtHrAtual;
			Date dtHrFimPrevMax = dtHrAtual;

			
			for (Object reg : lista) {
				Object[] registroLido = null;
				Object registroLidoAux = (Object) reg;
				registroLido = (Object[]) registroLidoAux;
				
				Registro registro = new Registro();
				registro.cdProduto = (String) registroLido[_produto];
				registro.cicloPadrao = ConversaoTipos.converterParaBigDecimal(registroLido[_cicloPadrao]);
				registro.fatorContagem = ConversaoTipos.converterParaBigDecimal(registroLido[_fatorContagem]);
				registro.pcsCicloAtivas = ConversaoTipos.converterParaBigDecimal(registroLido[_pcsCicloAtivas]);
				registro.prodLiquida = ConversaoTipos.converterParaBigDecimal(registroLido[_prodLiquida]);
				registro.prodPlan = ConversaoTipos.converterParaBigDecimal(registroLido[_prodPlan]);
				
				if (registro.prodLiquida.doubleValue() < registro.prodPlan.doubleValue()) {
					isOPConcluida = false;
					
					BigDecimal saldoOP = AritmeticaUtil.diminuir(registro.prodPlan, registro.prodLiquida);
					BigDecimal qtdCiclosNec = AritmeticaUtil.dividir(saldoOP, AritmeticaUtil.multiplicar(registro.pcsCicloAtivas, registro.fatorContagem));
					BigDecimal tempoNec = BigDecimal.ZERO;
					
					double resto = saldoOP.doubleValue() % AritmeticaUtil.multiplicar(registro.pcsCicloAtivas, registro.fatorContagem).doubleValue();
					if (resto > 0d) {
						qtdCiclosNec = AritmeticaUtil.somar(qtdCiclosNec, BigDecimal.ONE);
					}
					 
					//calc fim previsto
					tempoNec = AritmeticaUtil.multiplicar(qtdCiclosNec, registro.cicloPadrao);
					dtHrFimPrev = DataHoraRN.somaSegundos(dtHrAtual, tempoNec.intValue());
					
					if (DataHoraRN.after(dtHrFimPrev, dtHrFimPrevMax)) {
						dtHrFimPrevMax = dtHrFimPrev;
					}
				}				
			}	
			
			if (!isOPConcluida) {
				int segParaConclusao = AritmeticaUtil.multiplicar(horasParaConclusao, new BigDecimal(3600)).intValue();
				int segTempoPrevConc = DataHoraRN.getQuantidadeSegundosNoPeriodo(dtHrAtual, dtHrFimPrevMax);
				
				retorno = (segTempoPrevConc <= segParaConclusao);
			}
			
		}
		
		return retorno;
	}	
		

	/** V1 - tentativa otimz injetwebv1
	 * Esse eh o metodo chamado para criacao da tela de monitorizacao com os
	 * icones Dados Monitorizaçãoo em tempo real do Grupo de Trabalho
	 * 
	 * @param GtRtDTO
	 * @param tpId
	 *            - tipo do período (hora, turno, acumulado, mês/ano)
	 * @return <code>GtRtDTO</code> com detalhes da monitorizaçãoo
	 */
	public GtRtMonitorizacaoDTO getTelaMonitorizacaoMaquinaV1(DAOGenerico dao, GtRtDTO filtro, DwConsolidTemplate.TpId tpId) {
		IdwLogger log = new IdwLogger("MonitorizacaoVisaoMaquina");

		filtro.setDtReferencia(DataHoraRN.getDataSemHora(filtro.getDtReferencia()));

		// Instancia objeto de retorno
		GtRtMonitorizacaoDTO retorno = new GtRtMonitorizacaoDTO();
		retorno.setObjsRtMonitorizacaoDTO(new ObjsRtMonitorizacaoDTO());
		retorno.getObjsRtMonitorizacaoDTO().setObjsRtMonitorizacao(new ArrayList<ObjRtMonitorizacaoDTO>());
		retorno.setGtDTO(new GtDTO());
		retorno.getGtDTO().setGt(filtro.getGtDTO().getGt());


		if (retorno.getGtDTO().getGt() == null || filtro.getGtDTO().getGt().getIdGt() == null) {			
			return retorno;
		}

		/*
		 	- Guardar a data/hora atual para o grupo de trabalho
		 	- gtRtDTO dtreferencia tem que ser a do filtro, senao os dados nao vem corretamente
			- Entretanto, antes de retornar do ws devemos alterar essa referencia  para a dt e hr atual q sera mostrada na GUI.
		 */


		retorno.setDtReferencia(filtro.getDtReferencia());

		// config de indicadores
		OmCfg omcfg = new OmCfg();
		DAOGenericoInjet daoInj = new DAOGenericoInjet();
		daoInj.iniciaSessao();

		DiversosInjetRN divrn = new DiversosInjetRN(getDao());
		divrn.setDaoSession(getDaoSession());
		String cdLingua = "";

		cdLingua = "000000";//20200519
		/*
		try {
			cdLingua = divrn.getCdLingua();
		} catch (StringIndexOutOfBoundsException e) {
			cdLingua = "000000";
		}*/


		// / * 20200519
		Ijindiceselabels ijindiceselabels = new Ijindiceselabels();
		try {
			ijindiceselabels = divrn.pesquisarIjindiceselabels(cdLingua);
		} catch (RegistroDesconhecidoException e) {
			ijindiceselabels.setCdlingua(cdLingua);
			ijindiceselabels.setEficrealizacao(new BigDecimal(90));
			ijindiceselabels.setEficciclo(new BigDecimal(99));

		}
		// * /


		daoInj.finalizaSessao();



		// pega os objetos que fazem parte do GT		
		log.iniciaAvaliacao("getObjsDTO");
		ObjsDTO listaobjs = this.getObjsDTO(log, filtro.getGtDTO().getGt().getIdGt(), filtro.getIdPt(), true);
		log.mostrarAvaliacaoCompleta();

		// Varre todos os objetos que compoe a tela do GT que sera monitorizado com o objetivo de instancia cada objeto desse, conforme o seu tipo? PT GT Imagem, etc
		log.iniciaAvaliacao("for em getObjs");

		int i = 0;
		for (ObjDTO obj : listaobjs.getObjs()) {


			/*			 AQUI TESTE

			//20200519
			i++;
			if (i>1){break;}
			 */			


			DwTParada par = new DwTParada();
			par.setCdTparada("999999");

			// parada sem peso
			omcfg.setDwTParada(par);

			omcfg.setOmCfginds(new HashSet<OmCfgind>());



			// / * 20200519
			OmCfgind metaEfiRea = divrn.getMetaEfiReaInjetToVF(ijindiceselabels.getEficrealizacao(), obj.getObj().getOmPt().getCdPt());			
			OmCfgind metaEfiCic = divrn.getMetaEfiCicInjetToVF (ijindiceselabels.getEficciclo(), obj.getObj().getOmPt().getCdPt());
			OmCfgind metaIndRef =  divrn.getMetaIndRefInjetToVF();
			//OmCfgind metaIndPar = new OmCfgind();
			omcfg.getOmCfginds().add(metaEfiRea);
			omcfg.getOmCfginds().add(metaEfiCic);
			omcfg.getOmCfginds().add(metaIndRef);
			// * /


			ObjRtMonitorizacaoDTO objetoDaTela = this.montaObjetoNaTelaMonitorizacao(log, obj, tpId, retorno.getDtReferencia(), filtro.getDwTurno(), omcfg, filtro.getIsTurnoAtual(), filtro.getFiltroOP());
			if (objetoDaTela != null) {
				retorno.getObjsRtMonitorizacaoDTO().getObjsRtMonitorizacao().add(objetoDaTela);
			}
		}
		log.mostrarAvaliacaoCompleta();

		// Finalizano o metodo preparando algumas informacoes para retorno

		TurnoInjetRN rn = new TurnoInjetRN(getDao());
		TurnoAtualDTO turnoReferencia = null;
		OmPt ompt = new OmPt();

		//  Pega a referencia o 1o pt e em qual turno ele está
		log.iniciaAvaliacao("Restante 1 do algoritmo");
		for (ObjRtMonitorizacaoDTO obj : retorno.getObjsRtMonitorizacaoDTO().getObjsRtMonitorizacao()) {
			if (obj.getTipoObj() == 0) { //PT
				ompt.setIdPt(obj.getIdPt());
				ompt.setCdPt(obj.getCdPt());
				try {
					turnoReferencia = rn.getTurnoAtualDTOPassandoDtTurnoEIdTurno(filtro.getDtReferencia(),filtro.getDwTurno().getIdTurno());
					if (turnoReferencia != null) {
						break;
					}
				} catch (SemCalendarioException e) {
					continue;

				} catch (IllegalStateException e) {
					continue;
				}
			}
		}
		log.mostrarAvaliacaoCompleta();
		log.iniciaAvaliacao("Restante 2 do algoritmo");

		//Se o pt nao tiver um turno entao usar o turno do filtro
		if (turnoReferencia == null) {
			turnoReferencia = new TurnoAtualDTO();
			turnoReferencia.setDwturno(filtro.getDwTurno());
		}

		retorno.setDthrRefresh(DataHoraRN.getDataHoraAtual());
		retorno.setTurnoReferencia(turnoReferencia);
		log.mostrarAvaliacaoCompleta();
		log.iniciaAvaliacao("Restante 3 do algoritmo");


		if (turnoReferencia != null)
			retorno.getTurnoReferencia().prepararSerializacao();

		log.mostrarAvaliacaoCompleta();
		return retorno;

	}


	/**
	 * Coleta dos dados de tempo real do objeto
	 * 
	 * @param objDTO
	 * @return Dados do tempo real do objeto
	 */
	private ObjRtMonitorizacaoDTO montaObjetoNaTelaMonitorizacao(IdwLogger log, ObjDTO objDTO, DwConsolidTemplate.TpId tpId, Date dtReferencia, DwTurno dwTurno, OmCfg omcfg,  boolean isTurnoAtual, Integer filtroOp) {

		ObjRtMonitorizacaoDTO retorno = new ObjRtMonitorizacaoDTO();
		OmObj omObj = objDTO.getObj();

		retorno.setUrlImg(omObj.getOmImg() != null ? omObj.getOmImg().getUrlImg() : "");

		retorno.setX(objDTO.getObj().getX().doubleValue());
		if (objDTO.getObj().getY() != null)
			retorno.setY(objDTO.getObj().getY().doubleValue());
		else
			retorno.setY(0d);

		// Factory para tratar o objeto em tela
		ObjetoNaTelaFactory objeto = ObjetoNaTelaFactory.getInstancia(omObj);
		try {

			log.iniciaAvaliacao("fim - objeto.criar");
			log.info("objeto.criar");

			objeto.criar(retorno, omObj, omcfg, log, dtReferencia, dwTurno, this, tpId, isTurnoAtual, filtroOp);
		} catch (NullPointerException e) {
			e.printStackTrace();
			log.info("ObjetoNaTela nao suportado nesse metodo. TpObj=" + omObj.getTpObj(), e);
			retorno = null;
		} finally {
			log.mostrarAvaliacaoCompleta();
		}
		return retorno;
	}


	//20200525
	@SuppressWarnings("unchecked")
	private List<ValoresPtMonitorizacaoDTO> getDadosParaMonitoracaoInjet(Date data , String cdturno, String cdgalpao, String cdlingua) {
		List<ValoresPtMonitorizacaoDTO> retorno = null;

		if(data==null || cdturno==null || cdgalpao==null){return null;}

		class Registro {
			BigDecimal coorelobjy = BigDecimal.ZERO; 
			BigDecimal coorelobjx = BigDecimal.ZERO; 
			String cdinjetora = ""; 
			String cdinjestendido = ""; 
			String stfuncionamento = ""; 
			String TpIcone = ""; 
			Integer aguardandomolde = 0; 
			Integer AlertaInspQld = 0; 
			Integer maquinaemalerta = 0; 
			Integer StUltInspQld = 0; 
			Integer StDelayConsol = 0; 
			Integer StManut = 0; 
			Integer StPerdaSinc = 0; 
			Integer StProbQld = 0; 
			BigDecimal QtAleParCIP = BigDecimal.ZERO; 
			BigDecimal QtAlertasExtrInsp = BigDecimal.ZERO; 
			BigDecimal QtAlertasExtrPar = BigDecimal.ZERO; 
			BigDecimal QtAlertasOperador = BigDecimal.ZERO; 
			BigDecimal QtAlertasProbQld = BigDecimal.ZERO; 
			Integer parcompeso = 0; 
			Integer parnaoinf = 0; 
			BigDecimal EfiReaMaq = BigDecimal.ZERO; 
			BigDecimal EfiCicMaq = BigDecimal.ZERO; 
			BigDecimal IndRefMaiorQue = BigDecimal.ZERO; 
			BigDecimal efi_rea = BigDecimal.ZERO; 
			BigDecimal efi_cic = BigDecimal.ZERO; 
			BigDecimal ind_ref = BigDecimal.ZERO; 
			BigDecimal ind_par = BigDecimal.ZERO; 
			BigDecimal ind_cav = BigDecimal.ZERO; 
			BigDecimal ind_qld = BigDecimal.ZERO; 
			BigDecimal ind_disp = BigDecimal.ZERO; 
			BigDecimal oee = BigDecimal.ZERO;
			String cdmoldeatual = null;
		}

		int _coorelobjy = 0;
		int _coorelobjx = 1;
		int _cdinjetora = 2;
		int _cdinjestendido = 3;
		int _stfuncionamento = 4;
		int _TpIcone = 5;
		int _aguardandomolde = 6;
		int _AlertaInspQld = 7;
		int _maquinaemalerta = 8;
		int _StUltInspQld = 9;
		int _StDelayConsol = 10;
		int _StManut = 11;
		int _StPerdaSinc = 12;
		int _StProbQld = 13;
		int _QtAleParCIP = 14;
		int _QtAlertasExtrInsp = 15;
		int _QtAlertasExtrPar = 16;
		int _QtAlertasOperador = 17;
		int _QtAlertasProbQld = 18;
		int _parcompeso = 19;
		int _parnaoinf = 20;
		int _EfiReaMaq = 21;
		int _EfiCicMaq = 22;
		int _IndRefMaiorQue = 23;
		int _efi_rea = 24;
		int _efi_cic = 25;
		int _ind_ref = 26;
		int _ind_par = 27;
		int _ind_cav = 28;
		int _ind_qld = 29;
		int _ind_disp = 30;
		int _oee = 31;			
		int _cdmoldeatual = 32;	

		String strSQL = "";
		// coordenadas do objeto no galpão do Injet
		strSQL = strSQL.concat(" SELECT ");
		strSQL = strSQL.concat("        a.coorelobjy, a.coorelobjx, ");
		strSQL = strSQL.concat("        a.cdinjetora, a.cdinjestendido, ");
		// cod da maq e código estendido (código exibido nas interfaces)
		strSQL = strSQL.concat("        b.stfuncionamento,  "); // '0' - parada , '1' - produzindo , '2' - sem conexão
		strSQL = strSQL.concat("        b.TpIcone,  ");
		strSQL = strSQL.concat("        b.aguardandomolde, b.AlertaInspQld, b.maquinaemalerta, b.StUltInspQld, ");
		strSQL = strSQL.concat("        c.StDelayConsol, c.StManut, c.StPerdaSinc, c.StProbQld, ");
		strSQL = strSQL.concat("        d.QtAleParCIP, d.QtAlertasExtrInsp, d.QtAlertasExtrPar, d.QtAlertasOperador, d.QtAlertasProbQld, ");
		strSQL = strSQL.concat("        (CASE WHEN par.saidademolde IS NULL THEN NULL ELSE par.saidademolde END) as parcompeso,  "); // NULL - não está parada, 0 - par sem peso, 1 - par com peso
		strSQL = strSQL.concat("        (CASE WHEN b.cdparada  IS NULL THEN NULL ELSE (CASE WHEN b.cdparada <> '999999' THEN 0 ELSE 1 END) END) as parnaoinf,  "); //  NULL - não está parada, 0 - par inf, 1 - par nao inf
		// metas
		strSQL = strSQL.concat("        (CASE WHEN e.EficRealizacao IS NULL THEN cfgmeta.eficrealizacao ELSE e.EficRealizacao END) as EfiReaMaq, ");
		strSQL = strSQL.concat("        (CASE WHEN e.EficCiclo IS NULL THEN cfgmeta.eficciclo ELSE e.EficCiclo END) as EfiCicMaq, ");
		strSQL = strSQL.concat("        cfg.IndRefMaiorQue , ");
		// indicadores
		strSQL = strSQL.concat("        (CASE WHEN a.prodprev = 0 THEN 0 ELSE (a.prodliquida / a.prodprev) * 100 END) as efi_rea, ");
		strSQL = strSQL.concat("        (CASE WHEN (a.qtdcicnormal = 0 OR a.tmpcicnormal = 0) THEN 0 ELSE  (a.ciclopadrao /  (a.tmpcicnormal / a.qtdcicnormal)) * 100  END) as efi_cic, ");
		strSQL = strSQL.concat("        (CASE WHEN a.prodbruta = 0 THEN 0 ELSE (a.prodrefugada / a.prodbruta) * 100 END) as ind_ref,  ");
		strSQL = strSQL.concat("        (CASE WHEN a.tmpativo = 0 THEN 0 ELSE (a.tmpparCP / a.tmpativo) * 100 END) as ind_par, ");
		strSQL = strSQL.concat("        ( (a.qtcavativas / a.qtcavidades) * 100 ) as ind_cav, ");
		strSQL = strSQL.concat("        (100 - (CASE WHEN a.prodbruta = 0 THEN 0 ELSE (a.prodrefugada / a.prodbruta) * 100 END)) as ind_qld,  ");
		strSQL = strSQL.concat("        (CASE WHEN a.tmpativo = 0 THEN 0 ELSE (a.tmptrabalhado / a.tmpativo) * 100 END) as ind_disp,  ");
		strSQL = strSQL.concat("        (CASE WHEN a.tmpprodutivas < 0 OR a.tmpativo = 0 THEN 0 ELSE (a.tmpprodutivas / a.tmpativo) * 100 END) as oee         ");
		strSQL = strSQL.concat("   		, b.CdMoldeAtual ");
		strSQL = strSQL.concat("   FROM ( ");
		strSQL = strSQL.concat("          SELECT a.cdinjetora, a.cdinjestendido, ft.ciclopadrao, c2.qtcavativas, c2.qtcavidades, d.coorelobjx, d.coorelobjy, ");
		strSQL = strSQL.concat("                 SUM(b.tmpativo) as tmpativo, ");
		strSQL = strSQL.concat("                 SUM(b.tmpcicnormal - a.tmppcsref - a.tmpcavidades - b.tmpritmo) as tmpprodutivas, ");
		strSQL = strSQL.concat("                 SUM(a.prodrefugada) as prodrefugada, ");
		strSQL = strSQL.concat("                 SUM(a.prodbruta) as prodbruta, ");
		strSQL = strSQL.concat("                 SUM(a.prodbruta - a.prodrefugada) as prodliquida, ");
		strSQL = strSQL.concat("                 SUM(a.prodprev) as prodprev, ");
		strSQL = strSQL.concat("                 SUM(b.tmpativo - b.tmpparadasCP) as tmptrabalhado , ");
		strSQL = strSQL.concat("                 SUM(b.tmpparadasCP) as tmpparCP, ");
		strSQL = strSQL.concat("                 SUM(b.tmpcicnormal) as tmpcicnormal, ");
		strSQL = strSQL.concat("                 SUM(b.qtdciclosnormais) as qtdcicnormal ");
		strSQL = strSQL.concat("            FROM viewBIDtRefQtds a ");
		strSQL = strSQL.concat("            JOIN viewBIDtRefTempos b ON (    b.dtturno = a.dtturno ");
		strSQL = strSQL.concat("                                         AND b.cdturno = a.cdturno ");
		strSQL = strSQL.concat("                                         AND b.cdinjetora = a.cdinjetora ");
		strSQL = strSQL.concat("                                         AND b.nrop = a.nrop ");
		strSQL = strSQL.concat("                                         AND b.cdmolde = a.cdmolde ");
		strSQL = strSQL.concat("                                         AND b.cdestrutura = a.cdestrutura ");
		strSQL = strSQL.concat("                                         AND b.dthrivalestru = a.dthrivalestru ");
		strSQL = strSQL.concat("                                         AND b.dthrivalcic = a.dthrivalcic ) ");

		////20200615 //M20615b c->a TODO FAZER PARA DATAANTERIOR :
		strSQL = strSQL.concat("           JOIN ijtbinj c ON (c.cdinjetora = a.cdinjetora AND c.opatual = a.nrop) ");
		
		
		strSQL = strSQL.concat("           JOIN ijfictec ft ON (    ft.cdinjetora = c.cdinjetora "); ////20200615 //M20615b c->a
		strSQL = strSQL.concat("                                AND ft.cdmolde = c.CdMoldeAtual "); ////20200615 //M20615b (CdMoldeAtual) c->a
		strSQL = strSQL.concat("                                AND ft.cdestrutura = c.CdEstruturaAtual "); ////20200615 //M20615b (CdEstruturaAtual) c->a
		
		
		strSQL = strSQL.concat("                                AND ft.dthrfvalcic IS NULL) ");
		strSQL = strSQL.concat("           JOIN cavidades2 c2 ON (    c2.cdmolde = ft.cdmolde ");
		strSQL = strSQL.concat("                                  AND c2.cdestrutura = ft.cdestrutura ");
		strSQL = strSQL.concat("                                  AND c2.dthrival = ft.dthrivalestru)   ");
		
		strSQL = strSQL.concat("           JOIN ijgalobj d ON (d.cdinjetora = c.cdinjetora) ");

		
		strSQL = strSQL.concat("          WHERE a.dtturno = :data  "); // filtro de data
		strSQL = strSQL.concat("            AND a.cdturno = :cdturno  "); // filtro de turno
		strSQL = strSQL.concat("            AND d.cdgalpao = :cdgalpao  "); // filtro de galpao (GT no caso do VF)
		strSQL = strSQL.concat("          GROUP BY a.cdinjetora, a.cdinjestendido, ft.ciclopadrao, c2.qtcavativas, c2.qtcavidades, d.coorelobjx, d.coorelobjy ");
		strSQL = strSQL.concat("     ) a ");
		strSQL = strSQL.concat("    JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("     JOIN IJTbInjStatus c ON (c.cdinjetora = b.cdinjetora) ");
		strSQL = strSQL.concat("     JOIN IJtbINJALERTA d ON (d.cdinjetora = b.cdinjetora) ");
		strSQL = strSQL.concat("     JOIN IJIndicesELabels cfgmeta ON (cfgmeta.cdlingua = :cdlingua) ");
		strSQL = strSQL.concat("     JOIN ijconger cfg ON (1=1) ");
		strSQL = strSQL.concat("     LEFT JOIN ijInjCfgMetaMonit e ON (e.cdinjetora = b.cdinjetora) ");
		strSQL = strSQL.concat("     LEFT JOIN ijtbpar par ON (par.cdparada = b.cdparada) ");
		strSQL = strSQL.concat("   ORDER BY a.coorelobjy, a.coorelobjx ");

		List<Object> lista = new ArrayList<Object>();
		SQLQuery q = this.getDao().getSession().createSQLQuery(strSQL);
		q.setDate("data", data)
		.setString("cdturno", cdturno)
		.setString("cdgalpao", cdgalpao)
		.setString("cdlingua", cdlingua);

		lista = q.list();

		Date dt  = DataHoraRN.getDataHoraAtual();

		/*
			Registro registro = null;
			List<Registro> registros = null;
		 */

		ValoresPtMonitorizacaoDTO registro = null;
		List<ValoresPtMonitorizacaoDTO> registros = null;

		for (Object reg : lista) {
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro = new ValoresPtMonitorizacaoDTO();

			registro.setCoorelobjy( ConversaoTipos.converterParaBigDecimal(registroLido[_coorelobjy]));
			registro.setCoorelobjx(ConversaoTipos.converterParaBigDecimal(registroLido[_coorelobjx]));
			registro.setCdinjetora((String)  (registroLido[_cdinjetora]));
			registro.setCdinjestendido( (String)  (registroLido[_cdinjestendido]));
			registro.setStfuncionamento ( (String)  registroLido[_stfuncionamento]);
			registro.setTpIcone ( (String) (registroLido[_TpIcone]));
			//202006 registro.setAguardandomolde( (Integer) registroLido[_aguardandomolde]);
			registro.setAguardandomolde( Integer.valueOf( String.valueOf( registroLido[_aguardandomolde] ) ) );

			registro.setAlertaInspQld ( Integer.valueOf( String.valueOf(  registroLido[_AlertaInspQld] ) ) ); //(Integer.valueOf( (Character)   registroLido[_AlertaInspQld] ) );


			//202006 registro.setMaquinaemalerta ( (Integer) registroLido[_maquinaemalerta]);
			registro.setMaquinaemalerta ( Integer.valueOf( String.valueOf(  registroLido[_maquinaemalerta] ) ) ); //202006
			
			
			registro.setStUltInspQld ( Integer.valueOf( String.valueOf(      registroLido[_StUltInspQld] )));
			registro.setStDelayConsol (  Integer.valueOf( String.valueOf(      registroLido[_StDelayConsol] )));
			registro.setStManut ( Integer.valueOf( String.valueOf(      registroLido[_StManut] )));
			registro.setStPerdaSinc( Integer.valueOf( String.valueOf(      registroLido[_StPerdaSinc] )));
			registro.setStProbQld ( Integer.valueOf( String.valueOf(      registroLido[_StProbQld] )));
			registro.setQtAleParCIP ( ConversaoTipos.converterParaBigDecimal(registroLido[_QtAleParCIP]));
			registro.setQtAleParCIP (ConversaoTipos.converterParaBigDecimal(registroLido[_QtAleParCIP]));
			registro.setQtAlertasExtrInsp ( ConversaoTipos.converterParaBigDecimal(registroLido[_QtAlertasExtrInsp]));
			registro.setQtAlertasExtrPar ( ConversaoTipos.converterParaBigDecimal(registroLido[_QtAlertasExtrPar]));
			registro.setQtAlertasOperador ( ConversaoTipos.converterParaBigDecimal(registroLido[_QtAlertasOperador]));
			registro.setQtAlertasProbQld( ConversaoTipos.converterParaBigDecimal(registroLido[_QtAlertasProbQld]));
			if(registroLido[_parcompeso]!=null){
				registro.setParcompeso ( Integer.valueOf( String.valueOf(   registroLido[_parcompeso] ) ) );
			} else {
				registro.setParcompeso ( 0);
			}
			
			if(registroLido[_parnaoinf]!=null){
				registro.setParnaoinf ( Integer.valueOf( String.valueOf(    registroLido[_parnaoinf] ) ) );
			} else {
				registro.setParnaoinf ( 0);
			}			
			registro.setEfiReaMaq ( ConversaoTipos.converterParaBigDecimal(registroLido[_EfiReaMaq]));
			registro.setEfiCicMaq ( ConversaoTipos.converterParaBigDecimal(registroLido[_EfiCicMaq]));
			registro.setIndRefMaiorQue ( ConversaoTipos.converterParaBigDecimal(registroLido[_IndRefMaiorQue]));
			registro.setEfi_rea ( ConversaoTipos.converterParaBigDecimal(registroLido[_efi_rea]));
			registro.setEfi_cic ( ConversaoTipos.converterParaBigDecimal(registroLido[_efi_cic]));
			registro.setInd_ref ( ConversaoTipos.converterParaBigDecimal(registroLido[_ind_ref]));
			registro.setInd_par ( ConversaoTipos.converterParaBigDecimal(registroLido[_ind_par]));
			registro.setInd_cav (ConversaoTipos.converterParaBigDecimal(registroLido[_ind_cav]));
			registro.setInd_qld ( ConversaoTipos.converterParaBigDecimal(registroLido[_ind_disp]));
			registro.setInd_disp ( ConversaoTipos.converterParaBigDecimal(registroLido[_ind_disp]));
			registro.setOee ( ConversaoTipos.converterParaBigDecimal(registroLido[_oee]));	

			registro.setCdmoldeatual( (String)  registroLido[_cdmoldeatual]);

			if (registros==null){registros = new ArrayList<ValoresPtMonitorizacaoDTO>();}

			registros.add(registro);

		}

		retorno = registros;


		return retorno;
	}

	
	//20200525 - mas alerta que este pode ficar bem lento em comparacao com o anterior
	@SuppressWarnings("unchecked")
	private List<ValoresPtMonitorizacaoDTO> PRDPLANOPgetDadosParaMonitoracaoInjet(Date data , String cdturno, String cdgalpao, String cdlingua) {
		List<ValoresPtMonitorizacaoDTO> retorno = null;

		
		//TODO: set DTO. usar se for realmente necessário (indPRDop) pois mais lento que versao anterior por procuar em programacao e viewrealop
		

		
		if(data==null || cdturno==null || cdgalpao==null){return null;}

		class Registro {
			BigDecimal coorelobjy = BigDecimal.ZERO; 
			BigDecimal coorelobjx = BigDecimal.ZERO; 
			String cdinjetora = ""; 
			String cdinjestendido = ""; 
			String stfuncionamento = ""; 
			String TpIcone = ""; 
			Integer aguardandomolde = 0; 
			Integer AlertaInspQld = 0; 
			Integer maquinaemalerta = 0; 
			Integer StUltInspQld = 0; 
			Integer StDelayConsol = 0; 
			Integer StManut = 0; 
			Integer StPerdaSinc = 0; 
			Integer StProbQld = 0; 
			BigDecimal QtAleParCIP = BigDecimal.ZERO; 
			BigDecimal QtAlertasExtrInsp = BigDecimal.ZERO; 
			BigDecimal QtAlertasExtrPar = BigDecimal.ZERO; 
			BigDecimal QtAlertasOperador = BigDecimal.ZERO; 
			BigDecimal QtAlertasProbQld = BigDecimal.ZERO; 
			Integer parcompeso = 0; 
			Integer parnaoinf = 0; 
			BigDecimal EfiReaMaq = BigDecimal.ZERO; 
			BigDecimal EfiCicMaq = BigDecimal.ZERO; 
			BigDecimal IndRefMaiorQue = BigDecimal.ZERO; 
			BigDecimal efi_rea = BigDecimal.ZERO; 
			BigDecimal efi_cic = BigDecimal.ZERO; 
			BigDecimal ind_ref = BigDecimal.ZERO; 
			BigDecimal ind_par = BigDecimal.ZERO; 
			BigDecimal ind_cav = BigDecimal.ZERO; 
			BigDecimal ind_qld = BigDecimal.ZERO; 
			BigDecimal ind_disp = BigDecimal.ZERO; 
			BigDecimal oee = BigDecimal.ZERO;
			
			String nropatual = null;
			String cdmoldeatual = null;
			
			BigDecimal indprd = BigDecimal.ZERO;
			BigDecimal qtpliqop = BigDecimal.ZERO;
			BigDecimal qtplanop = BigDecimal.ZERO;
			
			BigDecimal tmpultimociclo = BigDecimal.ZERO;
			BigDecimal tmpciclopadrao = BigDecimal.ZERO;
			BigDecimal eficinstantanea = BigDecimal.ZERO;
			

			
			
			
		}

		int _coorelobjy = 0;
		int _coorelobjx = 1;
		int _cdinjetora = 2;
		int _cdinjestendido = 3;
		int _stfuncionamento = 4;
		int _TpIcone = 5;
		int _aguardandomolde = 6;
		int _AlertaInspQld = 7;
		int _maquinaemalerta = 8;
		int _StUltInspQld = 9;
		int _StDelayConsol = 10;
		int _StManut = 11;
		int _StPerdaSinc = 12;
		int _StProbQld = 13;
		int _QtAleParCIP = 14;
		int _QtAlertasExtrInsp = 15;
		int _QtAlertasExtrPar = 16;
		int _QtAlertasOperador = 17;
		int _QtAlertasProbQld = 18;
		int _parcompeso = 19;
		int _parnaoinf = 20;
		int _EfiReaMaq = 21;
		int _EfiCicMaq = 22;
		int _IndRefMaiorQue = 23;
		int _efi_rea = 24;
		int _efi_cic = 25;
		int _ind_ref = 26;
		int _ind_par = 27;
		int _ind_cav = 28;
		int _ind_qld = 29;
		int _ind_disp = 30;
		int _oee = 31;			

		int _nropatual = 32;	
		int _cdmoldeatual = 33;	
		
		int _indprd= 34;
		int _qtpliqop= 35;
		int _qtplanop= 36;
		
		int _tmpultimociclo= 37;
		int _tmpciclopadrao= 38;
		int _eficinstantanea= 39;


		String strSQL = "";
		// coordenadas do objeto no galpão do Injet
		strSQL = strSQL.concat(" SELECT ");
		strSQL = strSQL.concat("        a.coorelobjy, a.coorelobjx, ");
		strSQL = strSQL.concat("        a.cdinjetora, a.cdinjestendido, ");
		// cod da maq e código estendido (código exibido nas interfaces)
		strSQL = strSQL.concat("        b.stfuncionamento,  "); // '0' - parada , '1' - produzindo , '2' - sem conexão
		strSQL = strSQL.concat("        b.TpIcone,  ");
		strSQL = strSQL.concat("        b.aguardandomolde, b.AlertaInspQld, b.maquinaemalerta, b.StUltInspQld, ");
		strSQL = strSQL.concat("        c.StDelayConsol, c.StManut, c.StPerdaSinc, c.StProbQld, ");
		strSQL = strSQL.concat("        d.QtAleParCIP, d.QtAlertasExtrInsp, d.QtAlertasExtrPar, d.QtAlertasOperador, d.QtAlertasProbQld, ");
		strSQL = strSQL.concat("        (CASE WHEN par.saidademolde IS NULL THEN NULL ELSE par.saidademolde END) as parcompeso,  "); // NULL - não está parada, 0 - par sem peso, 1 - par com peso
		strSQL = strSQL.concat("        (CASE WHEN b.cdparada  IS NULL THEN NULL ELSE (CASE WHEN b.cdparada <> '999999' THEN 0 ELSE 1 END) END) as parnaoinf,  "); //  NULL - não está parada, 0 - par inf, 1 - par nao inf
		// metas
		strSQL = strSQL.concat("        (CASE WHEN e.EficRealizacao IS NULL THEN cfgmeta.eficrealizacao ELSE e.EficRealizacao END) as EfiReaMaq, ");
		strSQL = strSQL.concat("        (CASE WHEN e.EficCiclo IS NULL THEN cfgmeta.eficciclo ELSE e.EficCiclo END) as EfiCicMaq, ");
		strSQL = strSQL.concat("        cfg.IndRefMaiorQue , ");
	       
		// indicadores
		strSQL = strSQL.concat("        (CASE WHEN a.prodprev = 0 THEN 0 ELSE (a.prodliquida / a.prodprev) * 100 END) as efi_rea, ");
		strSQL = strSQL.concat("        (CASE WHEN (a.qtdcicnormal = 0 OR a.tmpcicnormal = 0) THEN 0 ELSE  (a.ciclopadrao /  (a.tmpcicnormal / a.qtdcicnormal)) * 100  END) as efi_cic, ");
		strSQL = strSQL.concat("        (CASE WHEN a.prodbruta = 0 THEN 0 ELSE (a.prodrefugada / a.prodbruta) * 100 END) as ind_ref,  ");
		strSQL = strSQL.concat("        (CASE WHEN a.tmpativo = 0 THEN 0 ELSE (a.tmpparCP / a.tmpativo) * 100 END) as ind_par, ");
		strSQL = strSQL.concat("        ( (a.qtcavativas / a.qtcavidades) * 100 ) as ind_cav, ");
		strSQL = strSQL.concat("        (100 - (CASE WHEN a.prodbruta = 0 THEN 0 ELSE (a.prodrefugada / a.prodbruta) * 100 END)) as ind_qld,  ");
		strSQL = strSQL.concat("        (CASE WHEN a.tmpativo = 0 THEN 0 ELSE (a.tmptrabalhado / a.tmpativo) * 100 END) as ind_disp,  ");
		strSQL = strSQL.concat("        (CASE WHEN a.tmpprodutivas < 0 OR a.tmpativo = 0 THEN 0 ELSE (a.tmpprodutivas / a.tmpativo) * 100 END) as oee         ");

		strSQL = strSQL.concat("   		, a.NROP ");
		strSQL = strSQL.concat("   		, a.cdmolde ");	
		
		strSQL = strSQL.concat("   		, (CASE WHEN a.qtplanop = 0 THEN 0 ELSE (a.qtpliqop / a.qtplanop) * 100 END) as indprd ");
		strSQL = strSQL.concat("   		, a.qtpliqop ");
		strSQL = strSQL.concat("   		, a.qtplanop ");
		
		strSQL = strSQL.concat("   		, a.TMPCICLOLIDO AS tmpultimociclo ");
		strSQL = strSQL.concat("   		, a.TMPCICPADRAO  AS tmpciclopadrao ");
		strSQL = strSQL.concat("   		, (CASE WHEN a.TMPCICLOLIDO IS NULL THEN 0 ELSE (  a.TMPCICPADRAO / a.TMPCICLOLIDO) * 100 END) as EficInstantanea ");
		
		
  
		
		strSQL = strSQL.concat("   FROM ( ");
		strSQL = strSQL.concat("          SELECT a.cdinjetora, a.cdinjestendido, ft.ciclopadrao, c2.qtcavativas, c2.qtcavidades, d.coorelobjx, d.coorelobjy, ");
		strSQL = strSQL.concat("                 SUM(b.tmpativo) as tmpativo, ");
		strSQL = strSQL.concat("                 SUM(b.tmpcicnormal - a.tmppcsref - a.tmpcavidades - b.tmpritmo) as tmpprodutivas, ");
		strSQL = strSQL.concat("                 SUM(a.prodrefugada) as prodrefugada, ");
		strSQL = strSQL.concat("                 SUM(a.prodbruta) as prodbruta, ");
		strSQL = strSQL.concat("                 SUM(a.prodbruta - a.prodrefugada) as prodliquida, ");
		strSQL = strSQL.concat("                 SUM(a.prodprev) as prodprev, ");
		strSQL = strSQL.concat("                 SUM(b.tmpativo - b.tmpparadasCP) as tmptrabalhado , ");
		strSQL = strSQL.concat("                 SUM(b.tmpparadasCP) as tmpparCP, ");
		strSQL = strSQL.concat("                 SUM(b.tmpcicnormal) as tmpcicnormal, ");
		strSQL = strSQL.concat("                 SUM(b.qtdciclosnormais) as qtdcicnormal ");
		
		strSQL = strSQL.concat("                 , opprd.NROP ");
		strSQL = strSQL.concat("                 , opprd.CDMOLDE ");
         
         
		
		strSQL = strSQL.concat("                 , (opplan.qtpecasproduzir ) qtplanop ");
		strSQL = strSQL.concat("                 , SUM(opprd.qtprodbrutaUB - opprd.qtprodrefugadaUB ) qtpliqop ");

		strSQL = strSQL.concat("                 , AVG( uc.TMPCICLOLIDO ) AS TMPCICLOLIDO ");
		strSQL = strSQL.concat("                 ,  AVG (uc.TMPCICPADRAO ) AS TMPCICPADRAO ");
        		
      
		strSQL = strSQL.concat("            FROM viewBIDtRefQtds a ");
		strSQL = strSQL.concat("            JOIN viewBIDtRefTempos b ON (    b.dtturno = a.dtturno ");
		strSQL = strSQL.concat("                                         AND b.cdturno = a.cdturno ");
		strSQL = strSQL.concat("                                         AND b.cdinjetora = a.cdinjetora ");
		strSQL = strSQL.concat("                                         AND b.nrop = a.nrop ");
		strSQL = strSQL.concat("                                         AND b.cdmolde = a.cdmolde ");
		strSQL = strSQL.concat("                                         AND b.cdestrutura = a.cdestrutura ");
		strSQL = strSQL.concat("                                         AND b.dthrivalestru = a.dthrivalestru ");
		strSQL = strSQL.concat("                                         AND b.dthrivalcic = a.dthrivalcic ) ");
		
		strSQL = strSQL.concat("   		join ijopprodutos opplan ON (opplan.nrop = a.nrop AND opplan.cdmolde = a.cdmolde and opplan.cdestrutura = a.cdestrutura) ");
		strSQL = strSQL.concat("   		join viewDadosCalcOEEOPUT opprd  ON (opprd.nrop = a.nrop AND opprd.cdinjetora = a.cdinjetora AND opprd.cdmolde = a.cdmolde and opprd.cdestrutura = a.cdestrutura) ");
	
		strSQL = strSQL.concat("           LEFT join VIEWULTIMOCICLOOP uc  ON (uc.nrop = a.nrop AND uc.cdinjetora = a.cdinjetora AND uc.cdmolde = a.cdmolde and uc.cdestrutura = a.cdestrutura)  ");
		
	
		strSQL = strSQL.concat("           JOIN ijtbinj c ON (c.cdinjetora = a.cdinjetora AND c.opatual = a.nrop) ");
		strSQL = strSQL.concat("           JOIN ijfictec ft ON (    ft.cdinjetora = c.cdinjetora ");
		strSQL = strSQL.concat("                                AND ft.cdmolde = c.CdMoldeAtual ");
		strSQL = strSQL.concat("                                AND ft.cdestrutura = c.CdEstruturaAtual ");
		strSQL = strSQL.concat("                                AND ft.dthrfvalcic IS NULL) ");
		strSQL = strSQL.concat("           JOIN cavidades2 c2 ON (    c2.cdmolde = ft.cdmolde ");
		strSQL = strSQL.concat("                                  AND c2.cdestrutura = ft.cdestrutura ");
		strSQL = strSQL.concat("                                  AND c2.dthrival = ft.dthrivalestru)   ");
		strSQL = strSQL.concat("           JOIN ijgalobj d ON (d.cdinjetora = c.cdinjetora) ");
		strSQL = strSQL.concat("          WHERE a.dtturno = :data  "); // filtro de data
		strSQL = strSQL.concat("            AND a.cdturno = :cdturno  "); // filtro de turno
		strSQL = strSQL.concat("            AND d.cdgalpao = :cdgalpao  "); // filtro de galpao (GT no caso do VF)
		
		strSQL = strSQL.concat("          GROUP BY a.cdinjetora, a.cdinjestendido, ft.ciclopadrao, c2.qtcavativas, c2.qtcavidades, d.coorelobjx, d.coorelobjy  ");
		
		strSQL = strSQL.concat("     , opprd.NROP  ");
		strSQL = strSQL.concat("     , opprd.cdmolde ");
		strSQL = strSQL.concat("     , opplan.qtpecasproduzir ");
		
		
		strSQL = strSQL.concat("     ) a ");
		strSQL = strSQL.concat("    JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("     JOIN IJTbInjStatus c ON (c.cdinjetora = b.cdinjetora) ");
		strSQL = strSQL.concat("     JOIN IJtbINJALERTA d ON (d.cdinjetora = b.cdinjetora) ");
		strSQL = strSQL.concat("     JOIN IJIndicesELabels cfgmeta ON (cfgmeta.cdlingua = :cdlingua) ");
		strSQL = strSQL.concat("     JOIN ijconger cfg ON (1=1) ");
		strSQL = strSQL.concat("     LEFT JOIN ijInjCfgMetaMonit e ON (e.cdinjetora = b.cdinjetora) ");
		strSQL = strSQL.concat("     LEFT JOIN ijtbpar par ON (par.cdparada = b.cdparada) ");
		strSQL = strSQL.concat("   ORDER BY a.coorelobjy, a.coorelobjx ");

		List<Object> lista = new ArrayList<Object>();
		SQLQuery q = this.getDao().getSession().createSQLQuery(strSQL);
		q.setDate("data", data)
		.setString("cdturno", cdturno)
		.setString("cdgalpao", cdgalpao)
		.setString("cdlingua", cdlingua);

		lista = q.list();

		Date dt  = DataHoraRN.getDataHoraAtual();



		ValoresPtMonitorizacaoDTO registro = null;
		List<ValoresPtMonitorizacaoDTO> registros = null;

		for (Object reg : lista) {
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro = new ValoresPtMonitorizacaoDTO();

			
			registro.setCoorelobjy( ConversaoTipos.converterParaBigDecimal( (( registroLido[_coorelobjy] == null) ? 0 : registroLido[_coorelobjy])     ));
			registro.setCoorelobjx(ConversaoTipos.converterParaBigDecimal( (( registroLido[_coorelobjx] == null) ? 0 : registroLido[_coorelobjx])   ));
			registro.setCdinjetora((String)  ( (( registroLido[_cdinjetora] == null) ? "" : registroLido[_cdinjetora])  ));
			registro.setCdinjestendido( (String)  (  (( registroLido[_cdinjestendido] == null) ? "" : registroLido[_cdinjestendido]) ));
			registro.setStfuncionamento ( (String)  (( registroLido[_stfuncionamento] == null) ? "" : registroLido[_stfuncionamento])  );
			registro.setTpIcone ( (String) ( (( registroLido[_TpIcone] == null) ? "" : registroLido[_TpIcone])  ));
			registro.setAguardandomolde( Integer.valueOf( ( String.valueOf( (( registroLido[_aguardandomolde] == null) ? 0 : registroLido[_aguardandomolde]) )) ) );

			registro.setAlertaInspQld ( Integer.valueOf( String.valueOf( (( registroLido[_AlertaInspQld] == null) ? "" : registroLido[_AlertaInspQld])  ) ) ); //(Integer.valueOf( (Character)   registroLido[_AlertaInspQld] ) );


			registro.setMaquinaemalerta ( Integer.valueOf( String.valueOf( (( registroLido[_maquinaemalerta] == null) ? "" : registroLido[_maquinaemalerta])  )));
			registro.setStUltInspQld ( Integer.valueOf( String.valueOf(   (( registroLido[_StUltInspQld] == null) ? "" : registroLido[_StUltInspQld])    )));
			registro.setStDelayConsol (  Integer.valueOf( String.valueOf(   (( registroLido[_StDelayConsol] == null) ? "" : registroLido[_StDelayConsol])    )));
			registro.setStManut ( Integer.valueOf( String.valueOf(   (( registroLido[_StManut] == null) ? "" : registroLido[_StManut])    )));
			registro.setStPerdaSinc( Integer.valueOf( String.valueOf(  (( registroLido[_StPerdaSinc] == null) ? "" : registroLido[_StPerdaSinc])     )));
			registro.setStProbQld ( Integer.valueOf( String.valueOf(   (( registroLido[_StProbQld] == null) ? "" : registroLido[_StProbQld])    )));
			registro.setQtAleParCIP ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_QtAleParCIP] == null) ? BigDecimal.ZERO : registroLido[_QtAleParCIP])  ));
			registro.setQtAleParCIP (ConversaoTipos.converterParaBigDecimal(  (( registroLido[_QtAleParCIP] == null) ? BigDecimal.ZERO : registroLido[_QtAleParCIP]) ));
			registro.setQtAlertasExtrInsp ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_QtAlertasExtrInsp] == null) ? BigDecimal.ZERO : registroLido[_QtAlertasExtrInsp])  ));
			registro.setQtAlertasExtrPar ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_QtAlertasExtrPar] == null) ? BigDecimal.ZERO : registroLido[_QtAlertasExtrPar])  ));
			registro.setQtAlertasOperador ( ConversaoTipos.converterParaBigDecimal(  (( registroLido[_QtAlertasOperador] == null) ? BigDecimal.ZERO : registroLido[_QtAlertasOperador]) ));
			registro.setQtAlertasProbQld( ConversaoTipos.converterParaBigDecimal( (( registroLido[_QtAlertasProbQld] == null) ? BigDecimal.ZERO : registroLido[_QtAlertasProbQld]) ));
			
			
			
			
			registro.setParcompeso (Integer.valueOf( String.valueOf( (( registroLido[_parcompeso] == null) ? 0 : registroLido[_parcompeso])    )));
			registro.setParnaoinf ( Integer.valueOf( String.valueOf(  (( registroLido[_parnaoinf] == null) ? 0 : registroLido[_parnaoinf])   )));
			
			registro.setEfiReaMaq ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_EfiReaMaq] == null) ? BigDecimal.ZERO : registroLido[_EfiReaMaq]) ));
			registro.setEfiCicMaq ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_EfiCicMaq] == null) ? BigDecimal.ZERO : registroLido[_EfiCicMaq])  ));
			registro.setIndRefMaiorQue ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_IndRefMaiorQue] == null) ? BigDecimal.ZERO : registroLido[_IndRefMaiorQue])  ));
			registro.setEfi_rea ( ConversaoTipos.converterParaBigDecimal(  (( registroLido[_efi_rea] == null) ? BigDecimal.ZERO : registroLido[_efi_rea]) ));
			registro.setEfi_cic ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_efi_cic] == null) ? BigDecimal.ZERO : registroLido[_efi_cic])  ));
			registro.setInd_ref ( ConversaoTipos.converterParaBigDecimal( ((  registroLido[_ind_ref] == null) ? BigDecimal.ZERO :  registroLido[_ind_ref]) ));
			registro.setInd_par ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_ind_par] == null) ? BigDecimal.ZERO : registroLido[_ind_par])  ));
			registro.setInd_cav (ConversaoTipos.converterParaBigDecimal(  (( registroLido[_ind_cav] == null) ? BigDecimal.ZERO : registroLido[_ind_cav])  ));
			registro.setInd_qld ( ConversaoTipos.converterParaBigDecimal( ((  registroLido[_ind_disp] == null) ? BigDecimal.ZERO :  registroLido[_ind_disp]) ));
			registro.setInd_disp ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_ind_disp] == null) ? BigDecimal.ZERO : registroLido[_ind_disp])  ));
			registro.setOee ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_oee] == null) ? BigDecimal.ZERO : registroLido[_oee])  ));	

			
			registro.setNropatual( (String) (( registroLido[_nropatual] == null) ? "" : registroLido[_nropatual]) );
			registro.setCdmoldeatual( (String) (( registroLido[_cdmoldeatual] == null) ? "" : registroLido[_cdmoldeatual]) );
			
			registro.setIndprd ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_indprd] == null) ? BigDecimal.ZERO : registroLido[_indprd]) ));
			registro.setQtpliqop ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_qtpliqop] == null) ? BigDecimal.ZERO : registroLido[_qtpliqop]) ));
			registro.setQtplanop ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_qtplanop] == null) ? BigDecimal.ZERO : registroLido[_qtplanop]) ));

			/*
			int p = 0;
			if (registro.getCdinjestendido().equals("INJ_off_5526")){
				p=0;
			}	
			*/
			

			registro.setTmpultimociclo  ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_tmpultimociclo] == null) ? BigDecimal.ZERO : registroLido[_tmpultimociclo]) ));
			registro.setTmpciclopadrao ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_tmpciclopadrao] == null) ? BigDecimal.ZERO : registroLido[_tmpciclopadrao]) ));
			registro.setEficinstantanea ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_eficinstantanea] == null) ? BigDecimal.ZERO : registroLido[_eficinstantanea]) ));

		
			if (registros==null){registros = new ArrayList<ValoresPtMonitorizacaoDTO>();}

			registros.add(registro);

		}

		retorno = registros;


		return retorno;
	}

	
	//202007 - este UM POUCO MENOS lento que o anterior por nao ir buscar ultimociclo e vista grossa pra CAVATIVAS. Em ultimo caso, avaliar outro modo com o Sardinha de obtermos em todos os casos a CAVIDADESATIVAS e EFrealizacao
	@SuppressWarnings("unchecked")
	private List<ValoresPtMonitorizacaoDTO> PRDPLANOP2getDadosParaMonitoracaoInjet(Date data , String cdturno, String cdgalpao, String cdlingua) {
		List<ValoresPtMonitorizacaoDTO> retorno = null;

		
		//TODO: set DTO. usar se for realmente necessário (indPRDop) pois mais lento que versao anterior por procuar em programacao e viewrealop
		

		
		if(data==null || cdturno==null || cdgalpao==null){return null;}

		class Registro {
			BigDecimal coorelobjy = BigDecimal.ZERO; 
			BigDecimal coorelobjx = BigDecimal.ZERO; 
			String cdinjetora = ""; 
			String cdinjestendido = ""; 
			String stfuncionamento = ""; 
			String TpIcone = ""; 
			Integer aguardandomolde = 0; 
			Integer AlertaInspQld = 0; 
			Integer maquinaemalerta = 0; 
			Integer StUltInspQld = 0; 
			Integer StDelayConsol = 0; 
			Integer StManut = 0; 
			Integer StPerdaSinc = 0; 
			Integer StProbQld = 0; 
			BigDecimal QtAleParCIP = BigDecimal.ZERO; 
			BigDecimal QtAlertasExtrInsp = BigDecimal.ZERO; 
			BigDecimal QtAlertasExtrPar = BigDecimal.ZERO; 
			BigDecimal QtAlertasOperador = BigDecimal.ZERO; 
			BigDecimal QtAlertasProbQld = BigDecimal.ZERO; 
			Integer parcompeso = 0; 
			Integer parnaoinf = 0; 
			BigDecimal EfiReaMaq = BigDecimal.ZERO; 
			BigDecimal EfiCicMaq = BigDecimal.ZERO; 
			BigDecimal IndRefMaiorQue = BigDecimal.ZERO; 
			BigDecimal efi_rea = BigDecimal.ZERO; 
			BigDecimal efi_cic = BigDecimal.ZERO; 
			BigDecimal ind_ref = BigDecimal.ZERO; 
			BigDecimal ind_par = BigDecimal.ZERO; 
			BigDecimal ind_cav = BigDecimal.ZERO; 
			BigDecimal ind_qld = BigDecimal.ZERO; 
			BigDecimal ind_disp = BigDecimal.ZERO; 
			BigDecimal oee = BigDecimal.ZERO;
			
			String nropatual = null;
			String cdmoldeatual = null;
			
			BigDecimal indprd = BigDecimal.ZERO;
			BigDecimal qtpliqop = BigDecimal.ZERO;
			BigDecimal qtplanop = BigDecimal.ZERO;
			
			BigDecimal tmpultimociclo = BigDecimal.ZERO;
			BigDecimal tmpciclopadrao = BigDecimal.ZERO;
			BigDecimal eficinstantanea = BigDecimal.ZERO;
			

			
			
			
		}

		int _coorelobjy = 0;
		int _coorelobjx = 1;
		int _cdinjetora = 2;
		int _cdinjestendido = 3;
		int _stfuncionamento = 4;
		int _TpIcone = 5;
		int _aguardandomolde = 6;
		int _AlertaInspQld = 7;
		int _maquinaemalerta = 8;
		int _StUltInspQld = 9;
		int _StDelayConsol = 10;
		int _StManut = 11;
		int _StPerdaSinc = 12;
		int _StProbQld = 13;
		int _QtAleParCIP = 14;
		int _QtAlertasExtrInsp = 15;
		int _QtAlertasExtrPar = 16;
		int _QtAlertasOperador = 17;
		int _QtAlertasProbQld = 18;
		int _parcompeso = 19;
		int _parnaoinf = 20;
		int _EfiReaMaq = 21;
		int _EfiCicMaq = 22;
		int _IndRefMaiorQue = 23;
		int _efi_rea = 24;
		int _efi_cic = 25;
		int _ind_ref = 26;
		int _ind_par = 27;
		int _ind_cav = 28;
		int _ind_qld = 29;
		int _ind_disp = 30;
		int _oee = 31;			

		int _nropatual = 32;	
		int _cdmoldeatual = 33;	
		
		int _indprd= 34;
		int _qtpliqop= 35;
		int _qtplanop= 36;
		
		int _tmpultimociclo= 37;
		int _tmpciclopadrao= 38;
		int _eficinstantanea= 39;


		String strSQL = "";
		// coordenadas do objeto no galpão do Injet
		strSQL = strSQL.concat(" SELECT ");
		strSQL = strSQL.concat("        a.coorelobjy, a.coorelobjx, ");
		strSQL = strSQL.concat("        a.cdinjetora, a.cdinjestendido, ");
		// cod da maq e código estendido (código exibido nas interfaces)
		strSQL = strSQL.concat("        b.stfuncionamento,  "); // '0' - parada , '1' - produzindo , '2' - sem conexão
		strSQL = strSQL.concat("        b.TpIcone,  ");
		strSQL = strSQL.concat("        b.aguardandomolde, b.AlertaInspQld, b.maquinaemalerta, b.StUltInspQld, ");
		strSQL = strSQL.concat("        c.StDelayConsol, c.StManut, c.StPerdaSinc, c.StProbQld, ");
		strSQL = strSQL.concat("        d.QtAleParCIP, d.QtAlertasExtrInsp, d.QtAlertasExtrPar, d.QtAlertasOperador, d.QtAlertasProbQld, ");
		strSQL = strSQL.concat("        (CASE WHEN par.saidademolde IS NULL THEN NULL ELSE par.saidademolde END) as parcompeso,  "); // NULL - não está parada, 0 - par sem peso, 1 - par com peso
		strSQL = strSQL.concat("        (CASE WHEN b.cdparada  IS NULL THEN NULL ELSE (CASE WHEN b.cdparada <> '999999' THEN 0 ELSE 1 END) END) as parnaoinf,  "); //  NULL - não está parada, 0 - par inf, 1 - par nao inf
		// metas
		strSQL = strSQL.concat("        (CASE WHEN e.EficRealizacao IS NULL THEN cfgmeta.eficrealizacao ELSE e.EficRealizacao END) as EfiReaMaq, ");
		strSQL = strSQL.concat("        (CASE WHEN e.EficCiclo IS NULL THEN cfgmeta.eficciclo ELSE e.EficCiclo END) as EfiCicMaq, ");
		strSQL = strSQL.concat("        cfg.IndRefMaiorQue , ");
	       
		// indicadores
		strSQL = strSQL.concat("        (CASE WHEN a.prodprev = 0 THEN 0 ELSE (a.prodliquida / a.prodprev) * 100 END) as efi_rea, ");
		strSQL = strSQL.concat("        (CASE WHEN (a.qtdcicnormal = 0 OR a.tmpcicnormal = 0) THEN 0 ELSE  (a.ciclopadrao /  (a.tmpcicnormal / a.qtdcicnormal)) * 100  END) as efi_cic, ");
		strSQL = strSQL.concat("        (CASE WHEN a.prodbruta = 0 THEN 0 ELSE (a.prodrefugada / a.prodbruta) * 100 END) as ind_ref,  ");
		strSQL = strSQL.concat("        (CASE WHEN a.tmpativo = 0 THEN 0 ELSE (a.tmpparCP / a.tmpativo) * 100 END) as ind_par, ");
		strSQL = strSQL.concat("        ( (a.qtcavativas / a.qtcavidades) * 100 ) as ind_cav, ");
		strSQL = strSQL.concat("        (100 - (CASE WHEN a.prodbruta = 0 THEN 0 ELSE (a.prodrefugada / a.prodbruta) * 100 END)) as ind_qld,  ");
		strSQL = strSQL.concat("        (CASE WHEN a.tmpativo = 0 THEN 0 ELSE (a.tmptrabalhado / a.tmpativo) * 100 END) as ind_disp,  ");
		strSQL = strSQL.concat("        (CASE WHEN a.tmpprodutivas < 0 OR a.tmpativo = 0 THEN 0 ELSE (a.tmpprodutivas / a.tmpativo) * 100 END) as oee         ");

		strSQL = strSQL.concat("   		, a.NROP ");
		strSQL = strSQL.concat("   		, a.cdmolde ");	
		
		strSQL = strSQL.concat("   		, (CASE WHEN a.qtplanop = 0 THEN 0 ELSE (a.qtpliqop / a.qtplanop) * 100 END) as indprd ");
		strSQL = strSQL.concat("   		, a.qtpliqop ");
		strSQL = strSQL.concat("   		, a.qtplanop ");
		
		strSQL = strSQL.concat("   		, a.TMPCICLOLIDO AS tmpultimociclo ");
		strSQL = strSQL.concat("   		, a.TMPCICPADRAO  AS tmpciclopadrao ");
		strSQL = strSQL.concat("   		, (CASE WHEN a.TMPCICLOLIDO IS NULL THEN 0 ELSE (  a.TMPCICPADRAO / a.TMPCICLOLIDO) * 100 END) as EficInstantanea ");
		
		
  
		
		strSQL = strSQL.concat("   FROM ( ");
		strSQL = strSQL.concat("          SELECT a.cdinjetora, a.cdinjestendido, ft.ciclopadrao, c2.qtcavativas, c2.qtcavidades, d.coorelobjx, d.coorelobjy, ");
		strSQL = strSQL.concat("                 SUM(b.tmpativo) as tmpativo, ");
		strSQL = strSQL.concat("                 SUM(b.tmpcicnormal - a.tmppcsref - a.tmpcavidades - b.tmpritmo) as tmpprodutivas, ");
		strSQL = strSQL.concat("                 SUM(a.prodrefugada) as prodrefugada, ");
		strSQL = strSQL.concat("                 SUM(a.prodbruta) as prodbruta, ");
		strSQL = strSQL.concat("                 SUM(a.prodbruta - a.prodrefugada) as prodliquida, ");
		strSQL = strSQL.concat("                 SUM(a.prodprev) as prodprev, ");
		strSQL = strSQL.concat("                 SUM(b.tmpativo - b.tmpparadasCP) as tmptrabalhado , ");
		strSQL = strSQL.concat("                 SUM(b.tmpparadasCP) as tmpparCP, ");
		strSQL = strSQL.concat("                 SUM(b.tmpcicnormal) as tmpcicnormal, ");
		strSQL = strSQL.concat("                 SUM(b.qtdciclosnormais) as qtdcicnormal ");
		
		strSQL = strSQL.concat("                 , opprd.NROP ");
		strSQL = strSQL.concat("                 , opprd.CDMOLDE ");
         
         
		
		strSQL = strSQL.concat("                 , (opplan.qtpecasproduzir ) qtplanop ");
		strSQL = strSQL.concat("                 , SUM(opprd.qtprodbrutaUB - opprd.qtprodrefugadaUB ) qtpliqop ");


		//20200717 tornar menos lento; esse pedido de gerar esse indicador dá muito problema!
		//20200717 strSQL = strSQL.concat("                 , AVG( uc.TMPCICLOLIDO ) AS TMPCICLOLIDO ");
		//20200717 strSQL = strSQL.concat("                 ,  AVG (uc.TMPCICPADRAO ) AS TMPCICPADRAO ");
		//20200717 : ...
		strSQL = strSQL.concat("                 , 1 AS TMPCICLOLIDO ");
		strSQL = strSQL.concat("                 ,  1 AS TMPCICPADRAO ");

      
		strSQL = strSQL.concat("            FROM viewBIDtRefQtds a ");
		strSQL = strSQL.concat("            JOIN viewBIDtRefTempos b ON (    b.dtturno = a.dtturno ");
		strSQL = strSQL.concat("                                         AND b.cdturno = a.cdturno ");
		strSQL = strSQL.concat("                                         AND b.cdinjetora = a.cdinjetora ");
		strSQL = strSQL.concat("                                         AND b.nrop = a.nrop ");
		strSQL = strSQL.concat("                                         AND b.cdmolde = a.cdmolde ");
		strSQL = strSQL.concat("                                         AND b.cdestrutura = a.cdestrutura ");
		strSQL = strSQL.concat("                                         AND b.dthrivalestru = a.dthrivalestru ");
		strSQL = strSQL.concat("                                         AND b.dthrivalcic = a.dthrivalcic ) ");
		
		strSQL = strSQL.concat("   		join ijopprodutos opplan ON (opplan.nrop = a.nrop AND opplan.cdmolde = a.cdmolde and opplan.cdestrutura = a.cdestrutura) ");
		strSQL = strSQL.concat("   		join viewDadosCalcOEEOPUT opprd  ON (opprd.nrop = a.nrop AND opprd.cdinjetora = a.cdinjetora AND opprd.cdmolde = a.cdmolde and opprd.cdestrutura = a.cdestrutura) ");
	
		//20200717 tornar menos lento; esse pedido de gerar esse indicador dá muito problema! FICA EXTREMAMENTE LENTO
		//20200717 strSQL = strSQL.concat("           LEFT join VIEWULTIMOCICLOOP uc  ON (uc.nrop = a.nrop AND uc.cdinjetora = a.cdinjetora AND uc.cdmolde = a.cdmolde and uc.cdestrutura = a.cdestrutura)  ");
		
	
		strSQL = strSQL.concat("           JOIN ijtbinj c ON (c.cdinjetora = a.cdinjetora AND c.opatual = a.nrop) ");
		strSQL = strSQL.concat("           JOIN ijfictec ft ON (    ft.cdinjetora = c.cdinjetora ");
		strSQL = strSQL.concat("                                AND ft.cdmolde = c.CdMoldeAtual ");
		strSQL = strSQL.concat("                                AND ft.cdestrutura = c.CdEstruturaAtual ");
		strSQL = strSQL.concat("                                AND ft.dthrfvalcic IS NULL) ");
		strSQL = strSQL.concat("           JOIN cavidades2 c2 ON (    c2.cdmolde = ft.cdmolde ");
		strSQL = strSQL.concat("                                  AND c2.cdestrutura = ft.cdestrutura ");
		strSQL = strSQL.concat("                                  AND c2.dthrival = ft.dthrivalestru)   ");
		strSQL = strSQL.concat("           JOIN ijgalobj d ON (d.cdinjetora = c.cdinjetora) ");
		strSQL = strSQL.concat("          WHERE a.dtturno = :data  "); // filtro de data
		strSQL = strSQL.concat("            AND a.cdturno = :cdturno  "); // filtro de turno
		strSQL = strSQL.concat("            AND d.cdgalpao = :cdgalpao  "); // filtro de galpao (GT no caso do VF)
		
		strSQL = strSQL.concat("          GROUP BY a.cdinjetora, a.cdinjestendido, ft.ciclopadrao, c2.qtcavativas, c2.qtcavidades, d.coorelobjx, d.coorelobjy  ");
		
		strSQL = strSQL.concat("     , opprd.NROP  ");
		strSQL = strSQL.concat("     , opprd.cdmolde ");
		strSQL = strSQL.concat("     , opplan.qtpecasproduzir ");
		
		
		strSQL = strSQL.concat("     ) a ");
		strSQL = strSQL.concat("    JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("     JOIN IJTbInjStatus c ON (c.cdinjetora = b.cdinjetora) ");
		strSQL = strSQL.concat("     JOIN IJtbINJALERTA d ON (d.cdinjetora = b.cdinjetora) ");
		strSQL = strSQL.concat("     JOIN IJIndicesELabels cfgmeta ON (cfgmeta.cdlingua = :cdlingua) ");
		strSQL = strSQL.concat("     JOIN ijconger cfg ON (1=1) ");
		strSQL = strSQL.concat("     LEFT JOIN ijInjCfgMetaMonit e ON (e.cdinjetora = b.cdinjetora) ");
		strSQL = strSQL.concat("     LEFT JOIN ijtbpar par ON (par.cdparada = b.cdparada) ");
		strSQL = strSQL.concat("   ORDER BY a.coorelobjy, a.coorelobjx ");

		List<Object> lista = new ArrayList<Object>();
		SQLQuery q = this.getDao().getSession().createSQLQuery(strSQL);
		q.setDate("data", data)
		.setString("cdturno", cdturno)
		.setString("cdgalpao", cdgalpao)
		.setString("cdlingua", cdlingua);

		lista = q.list();

		Date dt  = DataHoraRN.getDataHoraAtual();



		ValoresPtMonitorizacaoDTO registro = null;
		List<ValoresPtMonitorizacaoDTO> registros = null;

		for (Object reg : lista) {
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro = new ValoresPtMonitorizacaoDTO();

			
			registro.setCoorelobjy( ConversaoTipos.converterParaBigDecimal( (( registroLido[_coorelobjy] == null) ? 0 : registroLido[_coorelobjy])     ));
			registro.setCoorelobjx(ConversaoTipos.converterParaBigDecimal( (( registroLido[_coorelobjx] == null) ? 0 : registroLido[_coorelobjx])   ));
			registro.setCdinjetora((String)  ( (( registroLido[_cdinjetora] == null) ? "" : registroLido[_cdinjetora])  ));
			registro.setCdinjestendido( (String)  (  (( registroLido[_cdinjestendido] == null) ? "" : registroLido[_cdinjestendido]) ));
			registro.setStfuncionamento ( (String)  (( registroLido[_stfuncionamento] == null) ? "" : registroLido[_stfuncionamento])  );
			registro.setTpIcone ( (String) ( (( registroLido[_TpIcone] == null) ? "" : registroLido[_TpIcone])  ));
			registro.setAguardandomolde( Integer.valueOf( ( String.valueOf( (( registroLido[_aguardandomolde] == null) ? 0 : registroLido[_aguardandomolde]) )) ) );

			registro.setAlertaInspQld ( Integer.valueOf( String.valueOf( (( registroLido[_AlertaInspQld] == null) ? "" : registroLido[_AlertaInspQld])  ) ) ); //(Integer.valueOf( (Character)   registroLido[_AlertaInspQld] ) );


			registro.setMaquinaemalerta ( Integer.valueOf( String.valueOf( (( registroLido[_maquinaemalerta] == null) ? "" : registroLido[_maquinaemalerta])  )));
			registro.setStUltInspQld ( Integer.valueOf( String.valueOf(   (( registroLido[_StUltInspQld] == null) ? "" : registroLido[_StUltInspQld])    )));
			registro.setStDelayConsol (  Integer.valueOf( String.valueOf(   (( registroLido[_StDelayConsol] == null) ? "" : registroLido[_StDelayConsol])    )));
			registro.setStManut ( Integer.valueOf( String.valueOf(   (( registroLido[_StManut] == null) ? "" : registroLido[_StManut])    )));
			registro.setStPerdaSinc( Integer.valueOf( String.valueOf(  (( registroLido[_StPerdaSinc] == null) ? "" : registroLido[_StPerdaSinc])     )));
			registro.setStProbQld ( Integer.valueOf( String.valueOf(   (( registroLido[_StProbQld] == null) ? "" : registroLido[_StProbQld])    )));
			registro.setQtAleParCIP ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_QtAleParCIP] == null) ? BigDecimal.ZERO : registroLido[_QtAleParCIP])  ));
			registro.setQtAleParCIP (ConversaoTipos.converterParaBigDecimal(  (( registroLido[_QtAleParCIP] == null) ? BigDecimal.ZERO : registroLido[_QtAleParCIP]) ));
			registro.setQtAlertasExtrInsp ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_QtAlertasExtrInsp] == null) ? BigDecimal.ZERO : registroLido[_QtAlertasExtrInsp])  ));
			registro.setQtAlertasExtrPar ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_QtAlertasExtrPar] == null) ? BigDecimal.ZERO : registroLido[_QtAlertasExtrPar])  ));
			registro.setQtAlertasOperador ( ConversaoTipos.converterParaBigDecimal(  (( registroLido[_QtAlertasOperador] == null) ? BigDecimal.ZERO : registroLido[_QtAlertasOperador]) ));
			registro.setQtAlertasProbQld( ConversaoTipos.converterParaBigDecimal( (( registroLido[_QtAlertasProbQld] == null) ? BigDecimal.ZERO : registroLido[_QtAlertasProbQld]) ));
			
			
			
			
			registro.setParcompeso (Integer.valueOf( String.valueOf( (( registroLido[_parcompeso] == null) ? 0 : registroLido[_parcompeso])    )));
			registro.setParnaoinf ( Integer.valueOf( String.valueOf(  (( registroLido[_parnaoinf] == null) ? 0 : registroLido[_parnaoinf])   )));
			
			registro.setEfiReaMaq ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_EfiReaMaq] == null) ? BigDecimal.ZERO : registroLido[_EfiReaMaq]) ));
			registro.setEfiCicMaq ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_EfiCicMaq] == null) ? BigDecimal.ZERO : registroLido[_EfiCicMaq])  ));
			registro.setIndRefMaiorQue ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_IndRefMaiorQue] == null) ? BigDecimal.ZERO : registroLido[_IndRefMaiorQue])  ));
			registro.setEfi_rea ( ConversaoTipos.converterParaBigDecimal(  (( registroLido[_efi_rea] == null) ? BigDecimal.ZERO : registroLido[_efi_rea]) ));
			registro.setEfi_cic ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_efi_cic] == null) ? BigDecimal.ZERO : registroLido[_efi_cic])  ));
			registro.setInd_ref ( ConversaoTipos.converterParaBigDecimal( ((  registroLido[_ind_ref] == null) ? BigDecimal.ZERO :  registroLido[_ind_ref]) ));
			registro.setInd_par ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_ind_par] == null) ? BigDecimal.ZERO : registroLido[_ind_par])  ));
			registro.setInd_cav (ConversaoTipos.converterParaBigDecimal(  (( registroLido[_ind_cav] == null) ? BigDecimal.ZERO : registroLido[_ind_cav])  ));
			registro.setInd_qld ( ConversaoTipos.converterParaBigDecimal( ((  registroLido[_ind_disp] == null) ? BigDecimal.ZERO :  registroLido[_ind_disp]) ));
			registro.setInd_disp ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_ind_disp] == null) ? BigDecimal.ZERO : registroLido[_ind_disp])  ));
			registro.setOee ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_oee] == null) ? BigDecimal.ZERO : registroLido[_oee])  ));	

			
			registro.setNropatual( (String) (( registroLido[_nropatual] == null) ? "" : registroLido[_nropatual]) );
			registro.setCdmoldeatual( (String) (( registroLido[_cdmoldeatual] == null) ? "" : registroLido[_cdmoldeatual]) );
			
			registro.setIndprd ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_indprd] == null) ? BigDecimal.ZERO : registroLido[_indprd]) ));
			registro.setQtpliqop ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_qtpliqop] == null) ? BigDecimal.ZERO : registroLido[_qtpliqop]) ));
			registro.setQtplanop ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_qtplanop] == null) ? BigDecimal.ZERO : registroLido[_qtplanop]) ));

			/*
			int p = 0;
			if (registro.getCdinjestendido().equals("INJ_off_5526")){
				p=0;
			}	
			*/
			

			registro.setTmpultimociclo  ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_tmpultimociclo] == null) ? BigDecimal.ZERO : registroLido[_tmpultimociclo]) ));
			registro.setTmpciclopadrao ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_tmpciclopadrao] == null) ? BigDecimal.ZERO : registroLido[_tmpciclopadrao]) ));
			registro.setEficinstantanea ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_eficinstantanea] == null) ? BigDecimal.ZERO : registroLido[_eficinstantanea]) ));

		
			if (registros==null){registros = new ArrayList<ValoresPtMonitorizacaoDTO>();}

			registros.add(registro);

		}

		retorno = registros;


		return retorno;
	}
	

	
	//20200729 - a pedido Marcel para ijTV, acrescentar cd e ds produto
	@SuppressWarnings("unchecked")
	private List<ValoresPtMonitorizacaoDTO> PRDPLANOP3getDadosParaMonitoracaoInjet(Date data , String cdturno, String cdgalpao, String cdlingua) {
		List<ValoresPtMonitorizacaoDTO> retorno = null;
		
		//TODO: set DTO. usar se for realmente necessário (indPRDop) pois mais lento que versao anterior por procuar em programacao e viewrealop
		
		if(data==null || cdturno==null || cdgalpao==null){return null;}

		class Registro {
			BigDecimal coorelobjy = BigDecimal.ZERO; 
			BigDecimal coorelobjx = BigDecimal.ZERO; 
			String cdinjetora = ""; 
			String cdinjestendido = ""; 
			String stfuncionamento = ""; 
			String TpIcone = ""; 
			Integer aguardandomolde = 0; 
			Integer AlertaInspQld = 0; 
			Integer maquinaemalerta = 0; 
			Integer StUltInspQld = 0; 
			Integer StDelayConsol = 0; 
			Integer StManut = 0; 
			Integer StPerdaSinc = 0; 
			Integer StProbQld = 0; 
			BigDecimal QtAleParCIP = BigDecimal.ZERO; 
			BigDecimal QtAlertasExtrInsp = BigDecimal.ZERO; 
			BigDecimal QtAlertasExtrPar = BigDecimal.ZERO; 
			BigDecimal QtAlertasOperador = BigDecimal.ZERO; 
			BigDecimal QtAlertasProbQld = BigDecimal.ZERO; 
			Integer parcompeso = 0; 
			Integer parnaoinf = 0; 
			BigDecimal EfiReaMaq = BigDecimal.ZERO; 
			BigDecimal EfiCicMaq = BigDecimal.ZERO; 
			BigDecimal IndRefMaiorQue = BigDecimal.ZERO; 
			BigDecimal efi_rea = BigDecimal.ZERO; 
			BigDecimal efi_cic = BigDecimal.ZERO; 
			BigDecimal ind_ref = BigDecimal.ZERO; 
			BigDecimal ind_par = BigDecimal.ZERO; 
			BigDecimal ind_cav = BigDecimal.ZERO; 
			BigDecimal ind_qld = BigDecimal.ZERO; 
			BigDecimal ind_disp = BigDecimal.ZERO; 
			BigDecimal oee = BigDecimal.ZERO;
			
			String nropatual = null;
			String cdmoldeatual = null;
			
			BigDecimal indprd = BigDecimal.ZERO;
			BigDecimal qtpliqop = BigDecimal.ZERO;
			BigDecimal qtplanop = BigDecimal.ZERO;
			
			BigDecimal tmpultimociclo = BigDecimal.ZERO;
			BigDecimal tmpciclopadrao = BigDecimal.ZERO;
			BigDecimal eficinstantanea = BigDecimal.ZERO;
			

			String cdproduto = null;
			String dsproduto = null;
			
			
			
		}

		int _coorelobjy = 0;
		int _coorelobjx = 1;
		int _cdinjetora = 2;
		int _cdinjestendido = 3;
		int _stfuncionamento = 4;
		int _TpIcone = 5;
		int _aguardandomolde = 6;
		int _AlertaInspQld = 7;
		int _maquinaemalerta = 8;
		int _StUltInspQld = 9;
		int _StDelayConsol = 10;
		int _StManut = 11;
		int _StPerdaSinc = 12;
		int _StProbQld = 13;
		int _QtAleParCIP = 14;
		int _QtAlertasExtrInsp = 15;
		int _QtAlertasExtrPar = 16;
		int _QtAlertasOperador = 17;
		int _QtAlertasProbQld = 18;
		int _parcompeso = 19;
		int _parnaoinf = 20;
		int _EfiReaMaq = 21;
		int _EfiCicMaq = 22;
		int _IndRefMaiorQue = 23;
		int _efi_rea = 24;
		int _efi_cic = 25;
		int _ind_ref = 26;
		int _ind_par = 27;
		int _ind_cav = 28;
		int _ind_qld = 29;
		int _ind_disp = 30;
		int _oee = 31;			

		int _nropatual = 32;	
		int _cdmoldeatual = 33;	
		
		int _indprd= 34;
		int _qtpliqop= 35;
		int _qtplanop= 36;
		
		int _tmpultimociclo= 37;
		int _tmpciclopadrao= 38;
		int _eficinstantanea= 39;

		int _cdproduto = 40;//20200729
		int _dsproduto = 41;

		
		String strSQL = "";
		// coordenadas do objeto no galpão do Injet
		strSQL = strSQL.concat(" SELECT ");
		strSQL = strSQL.concat("        a.coorelobjy, a.coorelobjx, ");
		strSQL = strSQL.concat("        a.cdinjetora, a.cdinjestendido, ");
		// cod da maq e código estendido (código exibido nas interfaces)
		strSQL = strSQL.concat("        b.stfuncionamento,  "); // '0' - parada , '1' - produzindo , '2' - sem conexão
		strSQL = strSQL.concat("        b.TpIcone,  ");
		strSQL = strSQL.concat("        b.aguardandomolde, b.AlertaInspQld, b.maquinaemalerta, b.StUltInspQld, ");
		strSQL = strSQL.concat("        c.StDelayConsol, c.StManut, c.StPerdaSinc, c.StProbQld, ");
		strSQL = strSQL.concat("        d.QtAleParCIP, d.QtAlertasExtrInsp, d.QtAlertasExtrPar, d.QtAlertasOperador, d.QtAlertasProbQld, ");
		strSQL = strSQL.concat("        (CASE WHEN par.saidademolde IS NULL THEN NULL ELSE par.saidademolde END) as parcompeso,  "); // NULL - não está parada, 0 - par sem peso, 1 - par com peso
		strSQL = strSQL.concat("        (CASE WHEN b.cdparada  IS NULL THEN NULL ELSE (CASE WHEN b.cdparada <> '999999' THEN 0 ELSE 1 END) END) as parnaoinf,  "); //  NULL - não está parada, 0 - par inf, 1 - par nao inf
		// metas
		strSQL = strSQL.concat("        (CASE WHEN e.EficRealizacao IS NULL THEN cfgmeta.eficrealizacao ELSE e.EficRealizacao END) as EfiReaMaq, ");
		strSQL = strSQL.concat("        (CASE WHEN e.EficCiclo IS NULL THEN cfgmeta.eficciclo ELSE e.EficCiclo END) as EfiCicMaq, ");
		strSQL = strSQL.concat("        cfg.IndRefMaiorQue , ");
	       
		// indicadores
		strSQL = strSQL.concat("        (CASE WHEN a.prodprev = 0 THEN 0 ELSE (a.prodliquida / a.prodprev) * 100 END) as efi_rea, ");
		strSQL = strSQL.concat("        (CASE WHEN (a.qtdcicnormal = 0 OR a.tmpcicnormal = 0) THEN 0 ELSE  (a.ciclopadrao /  (a.tmpcicnormal / a.qtdcicnormal)) * 100  END) as efi_cic, ");
		strSQL = strSQL.concat("        (CASE WHEN a.prodbruta = 0 THEN 0 ELSE (a.prodrefugada / a.prodbruta) * 100 END) as ind_ref,  ");
		strSQL = strSQL.concat("        (CASE WHEN a.tmpativo = 0 THEN 0 ELSE (a.tmpparCP / a.tmpativo) * 100 END) as ind_par, ");
		strSQL = strSQL.concat("        ( (a.qtcavativas / a.qtcavidades) * 100 ) as ind_cav, ");
		strSQL = strSQL.concat("        (100 - (CASE WHEN a.prodbruta = 0 THEN 0 ELSE (a.prodrefugada / a.prodbruta) * 100 END)) as ind_qld,  ");
		strSQL = strSQL.concat("        (CASE WHEN a.tmpativo = 0 THEN 0 ELSE (a.tmptrabalhado / a.tmpativo) * 100 END) as ind_disp,  ");
		strSQL = strSQL.concat("        (CASE WHEN a.tmpprodutivas < 0 OR a.tmpativo = 0 THEN 0 ELSE (a.tmpprodutivas / a.tmpativo) * 100 END) as oee         ");

		strSQL = strSQL.concat("   		, a.NROP ");
		strSQL = strSQL.concat("   		, a.cdmolde ");	
		
		strSQL = strSQL.concat("   		, (CASE WHEN a.qtplanop = 0 THEN 0 ELSE (a.qtpliqop / a.qtplanop) * 100 END) as indprd ");
		strSQL = strSQL.concat("   		, a.qtpliqop ");
		strSQL = strSQL.concat("   		, a.qtplanop ");
		
		strSQL = strSQL.concat("   		, a.TMPCICLOLIDO AS tmpultimociclo ");
		strSQL = strSQL.concat("   		, a.TMPCICPADRAO  AS tmpciclopadrao ");
		strSQL = strSQL.concat("   		, (CASE WHEN a.TMPCICLOLIDO IS NULL THEN 0 ELSE (  a.TMPCICPADRAO / a.TMPCICLOLIDO) * 100 END) as EficInstantanea ");
		
		strSQL = strSQL.concat("   		,prd.cdproduto ,prd.dsproduto ");//20200729

		
  
		
		strSQL = strSQL.concat("   FROM ( ");
		strSQL = strSQL.concat("          SELECT a.cdinjetora, a.cdinjestendido, ft.ciclopadrao, c2.qtcavativas, c2.qtcavidades, d.coorelobjx, d.coorelobjy, ");
		strSQL = strSQL.concat("                 SUM(b.tmpativo) as tmpativo, ");
		strSQL = strSQL.concat("                 SUM(b.tmpcicnormal - a.tmppcsref - a.tmpcavidades - b.tmpritmo) as tmpprodutivas, ");
		strSQL = strSQL.concat("                 SUM(a.prodrefugada) as prodrefugada, ");
		strSQL = strSQL.concat("                 SUM(a.prodbruta) as prodbruta, ");
		strSQL = strSQL.concat("                 SUM(a.prodbruta - a.prodrefugada) as prodliquida, ");
		strSQL = strSQL.concat("                 SUM(a.prodprev) as prodprev, ");
		strSQL = strSQL.concat("                 SUM(b.tmpativo - b.tmpparadasCP) as tmptrabalhado , ");
		strSQL = strSQL.concat("                 SUM(b.tmpparadasCP) as tmpparCP, ");
		strSQL = strSQL.concat("                 SUM(b.tmpcicnormal) as tmpcicnormal, ");
		strSQL = strSQL.concat("                 SUM(b.qtdciclosnormais) as qtdcicnormal ");
		
		strSQL = strSQL.concat("                 , opprd.NROP ");
		strSQL = strSQL.concat("                 , opprd.CDMOLDE ");
         
         
		
		strSQL = strSQL.concat("                 , (opplan.qtpecasproduzir ) qtplanop ");
		strSQL = strSQL.concat("                 , SUM(opprd.qtprodbrutaUB - opprd.qtprodrefugadaUB ) qtpliqop ");


		//20200717 tornar menos lento; esse pedido de gerar esse indicador dá muito problema!
		//20200717 strSQL = strSQL.concat("                 , AVG( uc.TMPCICLOLIDO ) AS TMPCICLOLIDO ");
		//20200717 strSQL = strSQL.concat("                 ,  AVG (uc.TMPCICPADRAO ) AS TMPCICPADRAO ");
		//20200717 : ...
		strSQL = strSQL.concat("                 , 1 AS TMPCICLOLIDO ");
		strSQL = strSQL.concat("                 ,  1 AS TMPCICPADRAO ");

		strSQL = strSQL.concat("                 ,opplan.cdproduto ");
	 	
      
		strSQL = strSQL.concat("            FROM viewBIDtRefQtds a ");
		strSQL = strSQL.concat("            JOIN viewBIDtRefTempos b ON (    b.dtturno = a.dtturno ");
		strSQL = strSQL.concat("                                         AND b.cdturno = a.cdturno ");
		strSQL = strSQL.concat("                                         AND b.cdinjetora = a.cdinjetora ");
		strSQL = strSQL.concat("                                         AND b.nrop = a.nrop ");
		strSQL = strSQL.concat("                                         AND b.cdmolde = a.cdmolde ");
		strSQL = strSQL.concat("                                         AND b.cdestrutura = a.cdestrutura ");
		strSQL = strSQL.concat("                                         AND b.dthrivalestru = a.dthrivalestru ");
		strSQL = strSQL.concat("                                         AND b.dthrivalcic = a.dthrivalcic ) ");
		
		strSQL = strSQL.concat("   		join ijopprodutos opplan ON (opplan.nrop = a.nrop AND opplan.cdmolde = a.cdmolde and opplan.cdestrutura = a.cdestrutura) ");
		strSQL = strSQL.concat("   		join viewDadosCalcOEEOPUT opprd  ON (opprd.nrop = a.nrop AND opprd.cdinjetora = a.cdinjetora AND opprd.cdmolde = a.cdmolde and opprd.cdestrutura = a.cdestrutura) ");
	
		//20200717 tornar menos lento; esse pedido de gerar esse indicador dá muito problema! FICA EXTREMAMENTE LENTO
		//20200717 strSQL = strSQL.concat("           LEFT join VIEWULTIMOCICLOOP uc  ON (uc.nrop = a.nrop AND uc.cdinjetora = a.cdinjetora AND uc.cdmolde = a.cdmolde and uc.cdestrutura = a.cdestrutura)  ");
		
	
		strSQL = strSQL.concat("           JOIN ijtbinj c ON (c.cdinjetora = a.cdinjetora AND c.opatual = a.nrop) ");
		strSQL = strSQL.concat("           JOIN ijfictec ft ON (    ft.cdinjetora = c.cdinjetora ");
		strSQL = strSQL.concat("                                AND ft.cdmolde = c.CdMoldeAtual ");
		strSQL = strSQL.concat("                                AND ft.cdestrutura = c.CdEstruturaAtual ");
		strSQL = strSQL.concat("                                AND ft.dthrfvalcic IS NULL) ");
		strSQL = strSQL.concat("           JOIN cavidades2 c2 ON (    c2.cdmolde = ft.cdmolde ");
		strSQL = strSQL.concat("                                  AND c2.cdestrutura = ft.cdestrutura ");
		strSQL = strSQL.concat("                                  AND c2.dthrival = ft.dthrivalestru)   ");
		strSQL = strSQL.concat("           JOIN ijgalobj d ON (d.cdinjetora = c.cdinjetora) ");
		strSQL = strSQL.concat("          WHERE a.dtturno = :data  "); // filtro de data
		strSQL = strSQL.concat("            AND a.cdturno = :cdturno  "); // filtro de turno
		strSQL = strSQL.concat("            AND d.cdgalpao = :cdgalpao  "); // filtro de galpao (GT no caso do VF)
		
		strSQL = strSQL.concat("          GROUP BY a.cdinjetora, a.cdinjestendido, ft.ciclopadrao, c2.qtcavativas, c2.qtcavidades, d.coorelobjx, d.coorelobjy  ");
		
		strSQL = strSQL.concat("     , opprd.NROP  ");
		strSQL = strSQL.concat("     , opprd.cdmolde ");
		strSQL = strSQL.concat("     , opplan.qtpecasproduzir ");

		strSQL = strSQL.concat("     ,opplan.CDPRODUTO ");
		 
		strSQL = strSQL.concat("     ) a ");
		strSQL = strSQL.concat("    JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("     JOIN IJTbInjStatus c ON (c.cdinjetora = b.cdinjetora) ");
		strSQL = strSQL.concat("     JOIN IJtbINJALERTA d ON (d.cdinjetora = b.cdinjetora) ");
		strSQL = strSQL.concat("     JOIN IJIndicesELabels cfgmeta ON (cfgmeta.cdlingua = :cdlingua) ");
		strSQL = strSQL.concat("     JOIN ijconger cfg ON (1=1) ");
		strSQL = strSQL.concat("     LEFT JOIN ijInjCfgMetaMonit e ON (e.cdinjetora = b.cdinjetora) ");
		strSQL = strSQL.concat("     LEFT JOIN ijtbpar par ON (par.cdparada = b.cdparada) ");

		strSQL = strSQL.concat("     JOIN IJTBPRO prd ON  a.CDPRODUTO = prd.CDPRODUTO  ");
		
		strSQL = strSQL.concat("   ORDER BY a.coorelobjy, a.coorelobjx ");

		List<Object> lista = new ArrayList<Object>();
		SQLQuery q = this.getDao().getSession().createSQLQuery(strSQL);
		q.setDate("data", data)
		.setString("cdturno", cdturno)
		.setString("cdgalpao", cdgalpao)
		.setString("cdlingua", cdlingua);

		lista = q.list();

		Date dt  = DataHoraRN.getDataHoraAtual();



		ValoresPtMonitorizacaoDTO registro = null;
		List<ValoresPtMonitorizacaoDTO> registros = null;

		for (Object reg : lista) {
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro = new ValoresPtMonitorizacaoDTO();

			
			registro.setCoorelobjy( ConversaoTipos.converterParaBigDecimal( (( registroLido[_coorelobjy] == null) ? 0 : registroLido[_coorelobjy])     ));
			registro.setCoorelobjx(ConversaoTipos.converterParaBigDecimal( (( registroLido[_coorelobjx] == null) ? 0 : registroLido[_coorelobjx])   ));
			registro.setCdinjetora((String)  ( (( registroLido[_cdinjetora] == null) ? "" : registroLido[_cdinjetora])  ));
			registro.setCdinjestendido( (String)  (  (( registroLido[_cdinjestendido] == null) ? "" : registroLido[_cdinjestendido]) ));
			registro.setStfuncionamento ( (String)  (( registroLido[_stfuncionamento] == null) ? "" : registroLido[_stfuncionamento])  );
			registro.setTpIcone ( (String) ( (( registroLido[_TpIcone] == null) ? "" : registroLido[_TpIcone])  ));
			registro.setAguardandomolde( Integer.valueOf( ( String.valueOf( (( registroLido[_aguardandomolde] == null) ? 0 : registroLido[_aguardandomolde]) )) ) );

			registro.setAlertaInspQld ( Integer.valueOf( String.valueOf( (( registroLido[_AlertaInspQld] == null) ? "" : registroLido[_AlertaInspQld])  ) ) ); //(Integer.valueOf( (Character)   registroLido[_AlertaInspQld] ) );


			registro.setMaquinaemalerta ( Integer.valueOf( String.valueOf( (( registroLido[_maquinaemalerta] == null) ? "" : registroLido[_maquinaemalerta])  )));
			registro.setStUltInspQld ( Integer.valueOf( String.valueOf(   (( registroLido[_StUltInspQld] == null) ? "" : registroLido[_StUltInspQld])    )));
			registro.setStDelayConsol (  Integer.valueOf( String.valueOf(   (( registroLido[_StDelayConsol] == null) ? "" : registroLido[_StDelayConsol])    )));
			registro.setStManut ( Integer.valueOf( String.valueOf(   (( registroLido[_StManut] == null) ? "" : registroLido[_StManut])    )));
			registro.setStPerdaSinc( Integer.valueOf( String.valueOf(  (( registroLido[_StPerdaSinc] == null) ? "" : registroLido[_StPerdaSinc])     )));
			registro.setStProbQld ( Integer.valueOf( String.valueOf(   (( registroLido[_StProbQld] == null) ? "" : registroLido[_StProbQld])    )));
			registro.setQtAleParCIP ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_QtAleParCIP] == null) ? BigDecimal.ZERO : registroLido[_QtAleParCIP])  ));
			registro.setQtAleParCIP (ConversaoTipos.converterParaBigDecimal(  (( registroLido[_QtAleParCIP] == null) ? BigDecimal.ZERO : registroLido[_QtAleParCIP]) ));
			registro.setQtAlertasExtrInsp ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_QtAlertasExtrInsp] == null) ? BigDecimal.ZERO : registroLido[_QtAlertasExtrInsp])  ));
			registro.setQtAlertasExtrPar ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_QtAlertasExtrPar] == null) ? BigDecimal.ZERO : registroLido[_QtAlertasExtrPar])  ));
			registro.setQtAlertasOperador ( ConversaoTipos.converterParaBigDecimal(  (( registroLido[_QtAlertasOperador] == null) ? BigDecimal.ZERO : registroLido[_QtAlertasOperador]) ));
			registro.setQtAlertasProbQld( ConversaoTipos.converterParaBigDecimal( (( registroLido[_QtAlertasProbQld] == null) ? BigDecimal.ZERO : registroLido[_QtAlertasProbQld]) ));
			
			
			
			
			registro.setParcompeso (Integer.valueOf( String.valueOf( (( registroLido[_parcompeso] == null) ? 0 : registroLido[_parcompeso])    )));
			registro.setParnaoinf ( Integer.valueOf( String.valueOf(  (( registroLido[_parnaoinf] == null) ? 0 : registroLido[_parnaoinf])   )));
			
			registro.setEfiReaMaq ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_EfiReaMaq] == null) ? BigDecimal.ZERO : registroLido[_EfiReaMaq]) ));
			registro.setEfiCicMaq ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_EfiCicMaq] == null) ? BigDecimal.ZERO : registroLido[_EfiCicMaq])  ));
			registro.setIndRefMaiorQue ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_IndRefMaiorQue] == null) ? BigDecimal.ZERO : registroLido[_IndRefMaiorQue])  ));
			registro.setEfi_rea ( ConversaoTipos.converterParaBigDecimal(  (( registroLido[_efi_rea] == null) ? BigDecimal.ZERO : registroLido[_efi_rea]) ));
			registro.setEfi_cic ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_efi_cic] == null) ? BigDecimal.ZERO : registroLido[_efi_cic])  ));
			registro.setInd_ref ( ConversaoTipos.converterParaBigDecimal( ((  registroLido[_ind_ref] == null) ? BigDecimal.ZERO :  registroLido[_ind_ref]) ));
			registro.setInd_par ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_ind_par] == null) ? BigDecimal.ZERO : registroLido[_ind_par])  ));
			registro.setInd_cav (ConversaoTipos.converterParaBigDecimal(  (( registroLido[_ind_cav] == null) ? BigDecimal.ZERO : registroLido[_ind_cav])  ));
			registro.setInd_qld ( ConversaoTipos.converterParaBigDecimal( ((  registroLido[_ind_disp] == null) ? BigDecimal.ZERO :  registroLido[_ind_disp]) ));
			registro.setInd_disp ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_ind_disp] == null) ? BigDecimal.ZERO : registroLido[_ind_disp])  ));
			registro.setOee ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_oee] == null) ? BigDecimal.ZERO : registroLido[_oee])  ));	

			
			registro.setNropatual( (String) (( registroLido[_nropatual] == null) ? "" : registroLido[_nropatual]) );
			registro.setCdmoldeatual( (String) (( registroLido[_cdmoldeatual] == null) ? "" : registroLido[_cdmoldeatual]) );
			
			registro.setIndprd ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_indprd] == null) ? BigDecimal.ZERO : registroLido[_indprd]) ));
			registro.setQtpliqop ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_qtpliqop] == null) ? BigDecimal.ZERO : registroLido[_qtpliqop]) ));
			registro.setQtplanop ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_qtplanop] == null) ? BigDecimal.ZERO : registroLido[_qtplanop]) ));

			/*
			int p = 0;
			if (registro.getCdinjestendido().equals("INJ_off_5526")){
				p=0;
			}	
			*/
			

			registro.setTmpultimociclo  ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_tmpultimociclo] == null) ? BigDecimal.ZERO : registroLido[_tmpultimociclo]) ));
			registro.setTmpciclopadrao ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_tmpciclopadrao] == null) ? BigDecimal.ZERO : registroLido[_tmpciclopadrao]) ));
			registro.setEficinstantanea ( ConversaoTipos.converterParaBigDecimal( (( registroLido[_eficinstantanea] == null) ? BigDecimal.ZERO : registroLido[_eficinstantanea]) ));

			registro.setCdproduto( (String) (( registroLido[_cdproduto] == null) ? "" : registroLido[_cdproduto]) );
			registro.setDsproduto( (String) (( registroLido[_dsproduto] == null) ? "" : registroLido[_dsproduto]) );
			
		
			if (registros==null){registros = new ArrayList<ValoresPtMonitorizacaoDTO>();}

			registros.add(registro);

		}

		retorno = registros;


		return retorno;
	}
	
	
	@SuppressWarnings("unchecked")
	public DataTurnoReferenciaDTO getDataTurnoReferencia() {
		DataTurnoReferenciaDTO retorno = null;


		class Registro {
			Date dtref = null; 
			String cdturno = ""; 
			Date dthrini = null; 
			Date dthrfim = null; 

		}

		int _dtref = 0;
		int _cdturno = 1;
		int _dthrini = 2;
		int _dthrfim = 3;

		String strSQL = "";
		// coordenadas do objeto no galpão do Injet
		strSQL = strSQL.concat(" SELECT ");
		strSQL = strSQL.concat("        dtref, cdturno, dthrini, dthrfim ");
		strSQL = strSQL.concat(" FROM ijcnsTurIniFim ");
		// cod da maq e código estendido (código exibido nas interfaces)
		strSQL = strSQL.concat(" WHERE  "); // '0' - parada , '1' - produzindo , '2' - sem conexão
		strSQL = strSQL.concat("        dthrini = (SELECT max(dthrini) as dthrini FROM ijcnsTurIniFim)  ");


		List<Object> lista = new ArrayList<Object>();
		SQLQuery q = this.getDao().getSession().createSQLQuery(strSQL);

		lista = q.list();

		DataTurnoReferenciaDTO registro = null;


		for (Object reg : lista) {
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			registro = new DataTurnoReferenciaDTO();
			registro.setDtref( (Date)  registroLido[_dtref]);
			registro.setCdturno ( (String)  registroLido[_cdturno]);
			registro.setDthrini( (Date)  registroLido[_dthrini]);
			registro.setDthrfim( (Date)  registroLido[_dthrfim]);
			break;
		}

		retorno = registro;


		return retorno;
	}	



}
