package idw.model.rn.algoritmos.monitorizacao;

import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwRt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.model.rn.monitorizacao.MonitorizacaoRN;
import idw.model.rn.monitorizacao.injet.MonitorizacaoInjetRN;
import idw.model.rn.monitorizacao.injet.MonitorizacaoInjetV2RN;
import idw.util.IdwLogger;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.injet.RtFolhaDTO;

public class AlgoritmoMonitorizacaoWHP implements IAlgoritmo{

	@Override
	public void executar(IdwLogger log, ObjRtMonitorizacaoDTO objRtDTOItem, DwConsolidTemplate.TpId tpId, DwRt dwRt, OmCfg omCfg,MonitorizacaoRN rn, boolean isTurnoAtual, Integer filtroOp) {
		Long idPt = objRtDTOItem.getIdPt();

		objRtDTOItem.setTemOperador((dwRt.getIsOperador() != null) && dwRt.getIsOperador().booleanValue());

		// setar os valores do Turno
		objRtDTOItem.setCdTurno(dwRt.getDwTurno().getCdTurno());
		objRtDTOItem.setDsTurno(dwRt.getDwTurno().getDsTurno());
		objRtDTOItem.setIdTurno(dwRt.getDwTurno().getIdTurno());

		
		//setar o tipo do algoritmo
		objRtDTOItem.setTipoAlgoritmo(ObjRtMonitorizacaoDTO.ALG_WHP);

		PTRN ptRN = new PTRN(rn.getDao());
		OmPt omPtTemp = ptRN.getOmPtById(idPt);

		if(objRtDTOItem.isTemOmCfg()){

			if(objRtDTOItem.isTemDwRt() && dwRt.getIsOffline() != null && dwRt.getIsOffline() == false){

					long diffTime = 0;

					if ((dwRt.getDthrHeartbeat() != null) && (objRtDTOItem.getDtReferencia() != null)) {
						diffTime = DataHoraRN.getQuantidadeSegundosNoPeriodo(dwRt.getDthrHeartbeat(), objRtDTOItem.getDtReferencia());
					}

					objRtDTOItem.setOffline(diffTime > 60);
					boolean rtOffline = dwRt.getIsOffline() == null ? true : dwRt.getIsOffline();
					if(objRtDTOItem.isOffline() != rtOffline){
						//atualizar dwrt.offline
						dwRt.setIsOffline(objRtDTOItem.isOffline());
					}

				

				objRtDTOItem.setParada(dwRt.getStFuncionamento().equals( (byte) 0)
						|| !dwRt.getIsOperador()
						|| dwRt.getIsManutencaopre());

			} else {
				objRtDTOItem.setOffline(true);
				objRtDTOItem.setParada(true);

			}
			DwPassagem dwPassagem = rn.getDwPassagemFromOmPt(omPtTemp);
			OmTppt omTppt = rn.getOmTpptForOmPt(omPtTemp);


			if(dwPassagem == null){
				objRtDTOItem.setDentroDaMeta(false);
				//objRtDTOItem.setOmproduto(new OmProduto());
			} else {
				// Obtem o ultimo produto passado no posto
				objRtDTOItem.setDsProduto(dwPassagem.getDwNserie().getOmProduto().getDsProduto());
				//objRtDTOItem.setOmproduto( (OmProduto) dwPassagem.getDwNserie().getOmProduto().clone());

				// Se for um posto de montagem
				if(omTppt.getIdTppt() == omCfg.getOmTpptByIdTpptpts().getIdTppt()){

					objRtDTOItem.setDentroDaMeta(
							(dwPassagem.getDwNserie() != null)
							&& (dwPassagem.getDwNserie().getDwPassagem() != null)
							&& (dwPassagem.getDwNserie().getDwPassagem().getStNserie() != null)
							&& (dwPassagem.getDwNserie().getDwPassagem().getStNserie().byteValue() == 1));

				}

				// Se for posto de teste funcional ou posto de passa/n�o passa ou um posto de passa/defeito ou um posto de passagem
				if((omTppt.getIdTppt() == omCfg.getOmTpptByIdTpptptf().getIdTppt())
						|| (omTppt.getIdTppt() == omCfg.getOmTpptByIdTpptpts().getIdTppt())
						|| (omTppt.getIdTppt() == omCfg.getOmTpptByIdTpptptscd().getIdTppt())
						|| (omTppt.getIdTppt() == omCfg.getOmTpptByIdTpptppass().getIdTppt())){


					objRtDTOItem.setDentroDaMeta(
							(dwPassagem.getStNserie() != null)
							&& (dwPassagem.getStNserie().byteValue() == 1));
				}
				// Se for posto de reprocesso
				if(omTppt.getIdTppt() == omCfg.getOmTpptByIdTpptprepro().getIdTppt()){
					objRtDTOItem.setDentroDaMeta(
							(dwPassagem.getDwEst() != null)
							&&  (dwPassagem.getDwEst().getIdEst() != 4));
				}
			}
		}

		if(objRtDTOItem.isOffline()){
			objRtDTOItem.setCorFundo(objRtDTOItem.getCOR_FUNDO_OFFLINE());
		} else {
			if(objRtDTOItem.isParada()){
				objRtDTOItem.setCorFundo(objRtDTOItem.getCOR_FUNDO_PARADA());
			} else {
				objRtDTOItem.setCorFundo(objRtDTOItem.isDentroDaMeta()? objRtDTOItem.getCOR_FUNDO_DENTRO_META():objRtDTOItem.getCOR_FUNDO_FORA_META());
			}
		}
		
	}

	//Marcos Sardinha: VFWEB - Injet
	@Override
	public void executar(IdwLogger log, ObjRtMonitorizacaoDTO objRtDTOItem, DwConsolidTemplate.TpId tpId, RtFolhaDTO dwRt, OmCfg omCfg,MonitorizacaoInjetRN rn, boolean isTurnoAtual, Integer filtroOp) {
	}	
	
	
	//WEB - Injet - V2 (node)
	@Override
	public void executar(IdwLogger log, ObjRtMonitorizacaoDTO objRtDTOItem, DwConsolidTemplate.TpId tpId, RtFolhaDTO dwRt, OmCfg omCfg,MonitorizacaoInjetV2RN rn, boolean isTurnoAtual, Integer filtroOp) {
	}	
		
}
