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

public class ObjetoNaTelaRetangulo extends ObjetoNaTelaFactory{

	@Override
	public void criar(ObjRtMonitorizacaoDTO retorno, OmObj omobj, OmCfg omcfg, IdwLogger log, Date dtreferencia, DwTurno dwturno, MonitorizacaoVisaoMaquinaRN rn, DwConsolidTemplate.TpId tpId, boolean isTurnoAtual, Integer filtroOp) {
		retorno.setTipoObj(omobj.getTIPO_OBJ_RETANGULO());
		if (omobj.getX2() != null)
			retorno.setX2(omobj.getX2().doubleValue());

		if (omobj.getY2() != null)
			retorno.setY2(omobj.getY2().doubleValue());

	}

	@Override
	public void criar(ObjRtMonitorizacaoDTO retorno, OmObj omobj, OmCfg omcfg, IdwLogger log, Date dtreferencia, DwTurno dwturno, MonitorizacaoVisaoMaquinaInjetRN rn, DwConsolidTemplate.TpId tpId, boolean isTurnoAtual, Integer filtroOp) {
		retorno.setTipoObj(omobj.getTIPO_OBJ_RETANGULO());
		if (omobj.getX2() != null)
			retorno.setX2(omobj.getX2().doubleValue());

		if (omobj.getY2() != null)
			retorno.setY2(omobj.getY2().doubleValue());

	}	
	
	//WEB - Injet - V2 (node)
	@Override
	public void criar(ObjRtMonitorizacaoDTO retorno, OmObj omobj, OmCfg omcfg, IdwLogger log, Date dtreferencia, DwTurno dwturno, MonitorizacaoVisaoMaquinaInjetV2RN rn, DwConsolidTemplate.TpId tpId, boolean isTurnoAtual, Integer filtroOp) {
		retorno.setTipoObj(omobj.getTIPO_OBJ_RETANGULO());
		if (omobj.getX2() != null)
			retorno.setX2(omobj.getX2().doubleValue());

		if (omobj.getY2() != null)
			retorno.setY2(omobj.getY2().doubleValue());

	}	
}
