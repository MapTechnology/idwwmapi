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

public abstract class ObjetoNaTelaFactory {
	public abstract void criar(ObjRtMonitorizacaoDTO retorno, OmObj omobj, OmCfg omcfg, IdwLogger log, Date dtreferencia, DwTurno dwturno, MonitorizacaoVisaoMaquinaRN rn, DwConsolidTemplate.TpId tpId, boolean isTurnoAtual, Integer filtroOp);
	
	public abstract void criar(ObjRtMonitorizacaoDTO retorno, OmObj omobj, OmCfg omcfg, IdwLogger log, Date dtreferencia, DwTurno dwturno, MonitorizacaoVisaoMaquinaInjetRN rn, DwConsolidTemplate.TpId tpId, boolean isTurnoAtual, Integer filtroOp);

	public abstract void criar(ObjRtMonitorizacaoDTO retorno, OmObj omobj, OmCfg omcfg, IdwLogger log, Date dtreferencia, DwTurno dwturno, MonitorizacaoVisaoMaquinaInjetV2RN rn, DwConsolidTemplate.TpId tpId, boolean isTurnoAtual, Integer filtroOp);

	public static ObjetoNaTelaFactory getInstancia(OmObj omobj) {
		
		if (omobj.getTpObj().byteValue() == omobj.getTIPO_OBJ_PT()) {
			return new ObjetoNaTelaPT();
		} else if (omobj.getTpObj().byteValue() == omobj.getTIPO_OBJ_GT()) {
			return new ObjetoNaTelaGT();
		} else if (omobj.getTpObj().byteValue() == omobj.getTIPO_OBJ_RETANGULO()) {
			return new ObjetoNaTelaRetangulo();
		} else if (omobj.getTpObj().byteValue() == omobj.getTIPO_OBJ_RETA_SETA_1()) {
			return new ObjetoNaTelaSeta();
		}
		return null;
	}
}
