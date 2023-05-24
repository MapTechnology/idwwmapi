package idw.model.rn.monitorizacao;

import java.util.Date;

import idw.model.pojos.DwTurno;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmObj;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.monitorizacao.injet.MonitorizacaoVisaoMaquinaInjetRN;
import idw.model.rn.monitorizacao.injet.MonitorizacaoVisaoMaquinaInjetV2RN;
import idw.util.IdwLogger;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;

public class ObjetoNaTelaGT extends ObjetoNaTelaFactory {

	@Override
	public void criar(
			ObjRtMonitorizacaoDTO retorno, 
			OmObj omobj, 
			OmCfg omcfg, 
			IdwLogger log, 
			Date dtreferencia, 
			DwTurno dwturno, 
			MonitorizacaoVisaoMaquinaRN rn, 
			DwConsolidTemplate.TpId tpId, 
			boolean isTurnoAtual, 
			Integer filtroOp) {
		
		retorno.setTipoObj(retorno.getTipoGT());
		retorno.setDsGt(omobj.getOmGtByIdGtfilho().getDsCurta());
		retorno.setCdGt(omobj.getOmGtByIdGtfilho().getCdGt());
		retorno.setIdGt(omobj.getOmGtByIdGtfilho().getIdGt());
		
		/* TODO milton 14/02/17 - classes ObjetoNaTelaGTSimples, ObjetoNaTelaGTABC, ObjetoNaTelaGTCritico 
		 * possuem mesmas caracteristicas e poderiam extender uma classe comum com estas caracteristicas
		*/
		
		/*
		 * De acordo com a imagem setar os valores adequados
		 */
		if (omobj.getOmImg().getUrlImg().contains("galpao.png")) {
			ObjetoNaTelaGTSimples orn = new ObjetoNaTelaGTSimples();
			orn.criarDadosParaGtSimples(retorno, omobj, omcfg, log, dtreferencia, dwturno, rn, tpId, isTurnoAtual, filtroOp);
		} else if (omobj.getOmImg().getUrlImg().contains("abc.png")) {
			ObjetoNaTelaGTABC orn = new ObjetoNaTelaGTABC(rn.getDao(), log, omcfg);
			orn.criarDadosParaGtABC(retorno, omobj, dtreferencia, dwturno, tpId, isTurnoAtual, filtroOp);
		} else if (omobj.getOmImg().getUrlImg().contains("criticas.png")) {
			ObjetoNaTelaGTCritico orn = new ObjetoNaTelaGTCritico(rn.getDao(), log, omcfg);
			orn.criarDadosParaGtCritico(retorno, omobj, dtreferencia, dwturno, tpId, isTurnoAtual, filtroOp);
		} else {
			// Qualquer outro icone para o GT deve encontrar os indicadores normais de um PT
			ObjetoNaTelaGTIndicadoresPT orn = new ObjetoNaTelaGTIndicadoresPT();
			orn.criarDadosParaGt(retorno, omobj, omcfg, log, dtreferencia, dwturno, rn, tpId, isTurnoAtual, filtroOp);
		}
	}

	//Marcos Sardinha: VFWEB - Injet
	@Override
	public void criar(
			ObjRtMonitorizacaoDTO retorno, 
			OmObj omobj, 
			OmCfg omcfg, 
			IdwLogger log, 
			Date dtreferencia, 
			DwTurno dwturno, 
			MonitorizacaoVisaoMaquinaInjetRN rn, 
			DwConsolidTemplate.TpId tpId, 
			boolean isTurnoAtual, 
			Integer filtroOp) {
		
	}
	
	//WEB - Injet - V2 (node)
	@Override
	public void criar(
			ObjRtMonitorizacaoDTO retorno, 
			OmObj omobj, 
			OmCfg omcfg, 
			IdwLogger log, 
			Date dtreferencia, 
			DwTurno dwturno, 
			MonitorizacaoVisaoMaquinaInjetV2RN rn, 
			DwConsolidTemplate.TpId tpId, 
			boolean isTurnoAtual, 
			Integer filtroOp) {
		
	}


}
