package idw.model.rn.monitorizacao;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import idw.model.dao.OmObjDAO;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgind;
import idw.model.pojos.OmObj;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.util.FormulasInjet;
import idw.util.IdwLogger;
import idw.webservices.dto.ColorDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;

public class ObjetoNaTelaGTSimples {

	/* Inicializa valores para o grupo de trabalho simples, ou seja, considerando todos os postos do grupo
	 * 
	 */
	public void criarDadosParaGtSimples(ObjRtMonitorizacaoDTO retorno, OmObj omobj, OmCfg omcfg, IdwLogger log, 
			Date dtreferencia, DwTurno dwturno, MonitorizacaoVisaoMaquinaRN rn, DwConsolidTemplate.TpId tpId, 
			boolean isTurnoAtual, Integer filtroOp) {
		
		List<DwConsolid> ids;
		DetalheMonitorizacaoPTInsertRN rnid =  new DetalheMonitorizacaoPTInsertRN(rn.getDao());
		FiltroDetalhePTInjetDTO filtro = new FiltroDetalhePTInjetDTO();
		
		filtro.setDtReferencia(dtreferencia);
		filtro.setDwTurno(dwturno);
		filtro.setTpId(tpId.getValue());
		filtro.setOmGt(omobj.getOmGtByIdGtfilho());
		filtro.setFiltroOp(filtroOp);
		
		ids = rnid.pesquisarDwConsolids(log, filtro);
		

		calculaOEE(retorno, ids);
		
		// Obtem a quantidade de objetivos do tipo PT dentro do GT analisado
		OmObjDAO objDAO = new OmObjDAO(rn.getDaoSession());
		List<OmObj> listaobj = objDAO.pesquisarOmObsByOmGt(omobj.getOmGtByIdGtfilho());
		int qtdepts = 0;
		for (OmObj iobj : listaobj) {
			if (iobj.getOmPt() != null)
				qtdepts++;
		}
		retorno.setQtdePostos(qtdepts);
		
		
		// Marcos Sardinha: 2017-06-12 >>> metas e cores do galpao multinivel devem ser da config geral, nao do galpao abc
		
		// Obtem a meta de oee dos indicadores
		/*
		for (OmCfgabclim lim : omcfg.getOmCfgabc().getOmCfgabclims()) {
			if (TpClasseABC.CLASSE_A.equals(lim.getClasse())){
				oeeMeta = lim.getLimiteSup();
				
				// Determina a cor do GT
				if (retorno.getIndOEE() <= lim.getLimiteInf().doubleValue()) {
					retorno.setCorGt(new ColorDTO(Color.RED));
				} else if (retorno.getIndOEE() > lim.getLimiteInf().doubleValue() && retorno.getIndOEE() <= lim.getLimiteSup().doubleValue()) {
					retorno.setCorGt(new ColorDTO(Color.YELLOW));
				} else if (retorno.getIndOEE() > lim.getLimiteSup().doubleValue()) {
					retorno.setCorGt(new ColorDTO(Color.GREEN));
				}
			}
		}
		if (oeeMeta != null)
			retorno.setIndOEEMeta(oeeMeta.doubleValue());
		else
			retorno.setIndOEEMeta(0d);
		*/
		
		retorno.setIndOEEMeta(0d);
		retorno.setCorGt(new ColorDTO(Color.RED));
		for (OmCfgind cfg : omcfg.getOmCfginds()) {
			
			if(cfg.getOmInd().getCdInd().equals("OEE")){
				if (retorno.getIndOEE() < cfg.getIndInferior().doubleValue()) {
					retorno.setCorGt(new ColorDTO(Color.RED));
				} else if (retorno.getIndOEE() >= cfg.getIndInferior().doubleValue() && retorno.getIndOEE() <= cfg.getIndMeta().doubleValue()) {
					retorno.setCorGt(new ColorDTO(Color.YELLOW));
				} else if (retorno.getIndOEE() > cfg.getIndMeta().doubleValue()) {
					retorno.setCorGt(new ColorDTO(Color.GREEN));
				}
				
				if (cfg.getIndMeta() != null) {
					retorno.setIndOEEMeta(cfg.getIndMeta().doubleValue());
				}
				
				break;
			}
		}
		
	}

	private void calculaOEE(ObjRtMonitorizacaoDTO retorno, List<DwConsolid> ids) {
		BigDecimal tempoProdutivo = BigDecimal.ZERO;
		BigDecimal tempoAtivo = BigDecimal.ZERO;
		
		// Obtem dados necessarios para calculo do OEE
		for (DwConsolid id : ids) {
			for (DwConsol consol : id.getDwConsols()) {
				BigDecimal tempoCicloProdutivoDwConsol = consol.getSegAutoCicloprodutivo();
				
				Double tempoBoasAutoItem = FormulasInjet
						.calcularTempoBoas(
								tempoCicloProdutivoDwConsol, 
								consol.getSegAutoTemporefugadas(),
								consol.getSegAutoTempoparadaCpVr(), 
								consol.getSegAutoTempoparadaSpVr()).doubleValue();
				Double tempoBoasManuItem = FormulasInjet
						.calcularTempoBoas(
								consol.getSegManuCicloprodutivo(), 
								consol.getSegManuTemporefugadas(),
								consol.getSegManuTempoparadaCpVr(), 
								consol.getSegManuTempoparadaSpVr()).doubleValue();

				Double tempoboas = tempoBoasAutoItem + tempoBoasManuItem;
				if (tempoboas < 0)
					tempoboas = 0d;

				Double temporitmo = 0d;

				Double tempoRitmoAutoItem = FormulasInjet.calcularRitmo(
						tempoCicloProdutivoDwConsol,
						consol.getQtAutoCicloprodutivo(), 
						consol.getSegAutoCiclopadrao(),
						consol.getSegAutoTempoparadaCpVr(), 
						consol.getSegAutoTempoparadaSpVr()).doubleValue();

				Double tempoRitmoManuItem = FormulasInjet.calcularRitmo(
						consol.getSegManuCicloprodutivo(),
						consol.getQtManuCicloprodutivo(), 
						consol.getSegAutoCiclopadrao(),
						consol.getSegManuTempoparadaCpVr(), 
						consol.getSegManuTempoparadaSpVr()).doubleValue();

				
				if (consol.getPcsProducaoBruta() != null && consol.getPcsProducaoBruta().compareTo(BigDecimal.ZERO) > 0) {
					temporitmo = tempoRitmoAutoItem + tempoRitmoManuItem;
				}
				
				Double tempoProdutivoAutoItem = FormulasInjet.calcularTempoprodutivas(new BigDecimal(tempoboas), BigDecimal.ZERO, new BigDecimal(temporitmo)).doubleValue();
				
				if (tempoProdutivoAutoItem != null)
					tempoProdutivo = tempoProdutivo.add(new BigDecimal(tempoProdutivoAutoItem));
				
				if (consol.getSegAutoTempoativo() != null)
					tempoAtivo = tempoAtivo.add(consol.getSegAutoTempoativo());
			}
		}

		// Calcular oee
		retorno.setIndOEE((double) FormulasInjet.calcularOEE(tempoProdutivo, tempoAtivo));
	}
}
