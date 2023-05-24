package idw.model.rn.monitorizacao;

import java.util.Date;

import idw.model.pojos.DwRt;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmAlgocor;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmObj;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.TempoRealRN;
import idw.model.rn.algoritmos.monitorizacao.AlgoritmoMonitorizacaoFactory;
import idw.model.rn.monitorizacao.injet.MonitorizacaoVisaoMaquinaInjetRN;
import idw.model.rn.monitorizacao.injet.MonitorizacaoVisaoMaquinaInjetV2RN;
import idw.model.rn.monitorizacao.injet.TempoRealInjetRN;
import idw.util.IdwLogger;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.injet.RtFolhaDTO;

public class ObjetoNaTelaPT extends ObjetoNaTelaFactory {

	@Override
	public void criar(ObjRtMonitorizacaoDTO retorno, OmObj omobj, OmCfg omcfg, IdwLogger log, Date dtreferencia, DwTurno dwturno, MonitorizacaoVisaoMaquinaRN rn, DwConsolidTemplate.TpId tpId, boolean isTurnoAtual, Integer filtroOp) {
		OmPt omPt = omobj.getOmPt();
			
		
		retorno.setOmobj(omobj.clone(false));
		
		
		retorno.setDsPt(omPt.getDsPt());
		retorno.setDsCurta(omPt.getDsCurta());
		retorno.setCdPt(omPt.getCdPt());
		retorno.setIdPt(omPt.getIdPt());
		retorno.setIsCIPHabilitado(omPt.getIsHabilitaCip());

		/* Alessandre em 04-11-16 nao se deve pegar o GT do PT pois a monitorizacao pode estar sendo feita em um GT diferente. E isso
		 * causa o desaparecimento do icone na ficha da maquina
		 * O correto eh usar o mesmo GT da monitorizacao
		if (omPt.getOmGt() != null) {
			retorno.setIdGt(omPt.getOmGt().getIdGt());
			retorno.setCdGt(omPt.getOmGt().getCdGt());
			retorno.setDsGt(omPt.getOmGt().getDsGt());
		} else  {
			retorno.setIdGt(0);
			retorno.setCdGt("null");
			retorno.setDsGt("null");
		}*/
		retorno.setIdGt(omobj.getOmGtByIdGt().getIdGt());
		retorno.setCdGt(omobj.getOmGtByIdGt().getCdGt());
		retorno.setDsGt(omobj.getOmGtByIdGt().getDsGt());

		retorno.setTipoObj(retorno.getTipoPT());
		retorno.setTipoPT(omPt.getOmTppt().getIdTppt().intValue());
		retorno.setCdTipoPT(omPt.getOmTppt().getCdTppt());

		// Pega configura��o
		retorno.setTemOmCfg(omcfg != null);

		// Pega Algoritmo
		OmAlgocor omAlgocor = omPt.getOmTppt().getOmAlgocor(); // this.getOmAlgocorForOmPt(omPt);
		retorno.setTemOmAlgocor(omAlgocor != null);

		// Operadores logados
		retorno.setDwConsolmologs(rn.getOperadoresLogados(null, omobj.getOmPt()));

		// Pega dados do tempo Real
		/**
		 * Bug da DATA ocorre neste ponto, verificar metodo getDwRtForOmPt 1 -
		 * Tentei mudar o fuso horario no computador local, sem resultados. 2 -
		 * Tentei inverter a ordem do GET e SET no pojo DwRt e nada 3 - A data
		 * que vem errada � a data do objeto retornado na consulta
		 * 
		 * Milton 08/02/2013 - Foi o Alessandre que fez o coment�rio acima,
		 * quando estava na PST. Estava com este problema no Java 7.4, mudou
		 * para o Java 6.35 e funcionou.
		 */
		TempoRealRN trn = new TempoRealRN(rn.getDao());
		
		DwRt dwRt = trn.getDwRt(dtreferencia, dwturno.getIdTurno(), omPt.getIdPt(), omPt.getPpCp(), null);
		if (dwRt == null && isTurnoAtual) {
			// Se nao encontrou o dwRt para o turno e for tempo real entao utilizar o ultimo dwrt
			dwRt = trn.getUltimoDwRt(omPt.getIdPt());
		}
		
		retorno.setTemDwRt(dwRt != null);
		if (dwRt != null && dwRt.getPpCp() != null) {
			retorno.setIdCp(dwRt.getPpCp().getIdCp());
			retorno.setCdCp(dwRt.getPpCp().getCdCp());
		}
		retorno.setOffline(true);

		retorno.setDtReferencia(dwRt != null ? dwRt.getDtReferencia() : null);

		// Guarda o idDwConsolId, �til para a monitoriza��o do Android
		if (dwRt != null) {
			if (dwRt.getDwConsolids() != null && dwRt.getDwConsolids().isEmpty() == false) {
				retorno.setIdDwConsolId(dwRt.getDwConsolids().iterator().next().getIdConsolid());
			}
		}


		if (retorno.isTemDwRt() && retorno.isTemOmAlgocor()) {
			//Alessandre em 18-12-15 Acrecentei no if abaixo o isTurnoAtual para entrar no algoritmo sempre q for turno atual
			// permitindo assim que qdo for realtime durante a virada de turno se utilize o dwrt do turno anterior
			// qdo nao exisitir do turno atual, evitando os postos irem para offline
			if (dwRt.getDtReferencia().getTime() == dtreferencia.getTime() && 
					(isTurnoAtual || dwturno == null || dwRt.getDwTurno().getIdTurno() == dwturno.getIdTurno())) {
				
				int idLog = log.getIdAleatorio();
				log.iniciaAvaliacao("Fim executarAlgoritmo em ObjetoNaTelaPT.criar");
				log.info(idLog, 0, "executarAlgoritmo em ObjetoNaTelaPT.criar");
				AlgoritmoMonitorizacaoFactory.getInstancia().executarAlgoritmo(log, omAlgocor.getIdAlgocor(), retorno, tpId, dwRt,omcfg, rn, isTurnoAtual, filtroOp);
				log.info(idLog, 0, "fim - executarAlgoritmo em ObjetoNaTelaPT.criar");
				log.mostrarAvaliacaoCompleta();
			}
		}
	}
	
	//Marcos Sardinha: VFWEB - Injet
	@Override
	public void criar(ObjRtMonitorizacaoDTO retorno, OmObj omobj, OmCfg omcfg, IdwLogger log, Date dtreferencia, DwTurno dwturno, MonitorizacaoVisaoMaquinaInjetRN rn, DwConsolidTemplate.TpId tpId, boolean isTurnoAtual, Integer filtroOp) {
		OmPt omPt = omobj.getOmPt();


				
		retorno.setDsPt(omPt.getDsPt());
		retorno.setDsCurta(omPt.getDsCurta());
		retorno.setCdPt(omPt.getCdPt());
		retorno.setIdPt(omPt.getIdPt());
		retorno.setIsCIPHabilitado(omPt.getIsHabilitaCip());

		retorno.setIdGt(omobj.getOmGtByIdGt().getIdGt());
		retorno.setCdGt(omobj.getOmGtByIdGt().getCdGt());
		retorno.setDsGt(omobj.getOmGtByIdGt().getDsGt());

		retorno.setTipoObj(retorno.getTipoPT());
		retorno.setTipoPT(ObjRtMonitorizacaoDTO.ALG_INJET);

		// Pega config
		retorno.setTemOmCfg(omcfg != null);

		// Pega Algoritmo
		OmAlgocor omAlgocor = omPt.getOmTppt().getOmAlgocor(); 
		retorno.setTemOmAlgocor(omAlgocor != null);

		// Operadores logados
		retorno.setDwConsolmologs(rn.getOperadoresLogadosInjet(null, omobj.getOmPt()));

		// Pega dados do tempo Real
		TempoRealInjetRN trn = new TempoRealInjetRN(rn.getDao());
		
		RtFolhaDTO rtf = trn.getDwRt(isTurnoAtual, dtreferencia, dwturno.getIdTurno(), omPt.getCdPt(), (omPt.getPpCp() != null ? omPt.getPpCp().getCdCp() : ""));
		DwRt dwRt = rtf.getRt();
		/*
		if (dwRt == null && isTurnoAtual) {
			// Se nao encontrou o dwRt para o turno e for tempo real entao utilizar o ultimo dwrt
			dwRt = trn.getUltimoDwRt(omPt.getIdPt());
		}
		*/
		
		retorno.setTemDwRt(dwRt != null);
		if (dwRt != null && dwRt.getPpCp() != null) {
			retorno.setIdCp(dwRt.getPpCp().getIdCp());
			retorno.setCdCp(dwRt.getPpCp().getCdCp());
		}
		retorno.setOffline(true);

		retorno.setDtReferencia(dwRt != null ? dwRt.getDtReferencia() : null);


		if (retorno.isTemDwRt() && retorno.isTemOmAlgocor()) {
			//Alessandre em 18-12-15 Acrecentei no if abaixo o isTurnoAtual para entrar no algoritmo sempre q for turno atual
			// permitindo assim que qdo for realtime durante a virada de turno se utilize o dwrt do turno anterior
			// qdo nao exisitir do turno atual, evitando os postos irem para offline
			if (dwRt.getDtReferencia().getTime() == dtreferencia.getTime() && 
					(isTurnoAtual || dwturno == null || dwRt.getDwTurno().getIdTurno() == dwturno.getIdTurno())) {
				log.iniciaAvaliacao("executarAlgoritmo");
				AlgoritmoMonitorizacaoFactory.getInstancia().executarAlgoritmo(log, omAlgocor.getIdAlgocor(), retorno, tpId, rtf,omcfg, rn, isTurnoAtual, filtroOp);
				log.mostrarAvaliacaoCompleta();
			}
		}
	}
	
	
	
	// WEB - Injet - V2 (node)
	@Override
	public void criar(ObjRtMonitorizacaoDTO retorno, OmObj omobj, OmCfg omcfg, IdwLogger log, Date dtreferencia, DwTurno dwturno, MonitorizacaoVisaoMaquinaInjetV2RN rn, DwConsolidTemplate.TpId tpId, boolean isTurnoAtual, Integer filtroOp) {
		OmPt omPt = omobj.getOmPt();
			
		retorno.setDsPt(omPt.getDsPt());
		retorno.setDsCurta(omPt.getDsCurta());
		retorno.setCdPt(omPt.getCdPt());
		retorno.setIdPt(omPt.getIdPt());
		retorno.setIsCIPHabilitado(omPt.getIsHabilitaCip());

		retorno.setIdGt(omobj.getOmGtByIdGt().getIdGt());
		retorno.setCdGt(omobj.getOmGtByIdGt().getCdGt());
		retorno.setDsGt(omobj.getOmGtByIdGt().getDsGt());

		retorno.setTipoObj(retorno.getTipoPT());
		retorno.setTipoPT(ObjRtMonitorizacaoDTO.ALG_INJET);

		// Pega config
		retorno.setTemOmCfg(omcfg != null);

		// Pega Algoritmo
		OmAlgocor omAlgocor = omPt.getOmTppt().getOmAlgocor(); 
		retorno.setTemOmAlgocor(omAlgocor != null);

//		TempoRealInjetRN trn = null;
		RtFolhaDTO rtf = null;
		DwRt dwRt= null;		

		
		retorno.setTemDwRt(dwRt != null);

		retorno.setOffline(true);

		retorno.setDtReferencia(dwRt != null ? dwRt.getDtReferencia() : null);


		retorno.setTemDwRt(true);//202005
		
		if (retorno.isTemDwRt() && retorno.isTemOmAlgocor()) {
			
			
			//Alessandre em 18-12-15 Acrecentei no if abaixo o isTurnoAtual para entrar no algoritmo sempre q for turno atual
			// permitindo assim que qdo for realtime durante a virada de turno se utilize o dwrt do turno anterior
			// qdo nao exisitir do turno atual, evitando os postos irem para offline

			
			if (
					(isTurnoAtual || 
					dwturno == null 
					)) {
				log.iniciaAvaliacao("executarAlgoritmo");
				AlgoritmoMonitorizacaoFactory.getInstancia().executarAlgoritmo(log, omAlgocor.getIdAlgocor(), retorno, tpId, rtf,omcfg, rn, isTurnoAtual, filtroOp);
				log.mostrarAvaliacaoCompleta();
			}
			
			
		}
	}	

}
