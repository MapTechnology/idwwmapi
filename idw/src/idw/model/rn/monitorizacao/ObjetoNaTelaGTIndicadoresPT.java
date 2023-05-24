package idw.model.rn.monitorizacao;

import java.util.Date;
import java.util.List;

import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmObj;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.model.rn.detalhemonitorizacao.IndicadoresDoDetalheRN;
import idw.util.IdwLogger;
import idw.webservices.dto.DetalheMonitorizacaoPTInjetDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;

public class ObjetoNaTelaGTIndicadoresPT {

	/* Inicializa valores para o grupo de trabalho simples, ou seja, considerando todos os postos do grupo
	 * 
	 */
	public void criarDadosParaGt(
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
		
		List<DwConsolid> ids;
		DetalheMonitorizacaoPTInsertRN rnid =  new DetalheMonitorizacaoPTInsertRN(rn.getDao());
		FiltroDetalhePTInjetDTO filtro = new FiltroDetalhePTInjetDTO();
		
		filtro.setDtReferencia(dtreferencia);
		filtro.setDwTurno(dwturno);
		filtro.setTpId(tpId.getValue());
		filtro.setOmGt(omobj.getOmGtByIdGtfilho());
		filtro.setFiltroOp(filtroOp);
		
		ids = rnid.pesquisarDwConsolids(log, filtro);
		
		DetalheMonitorizacaoPTInjetDTO detalhe = new DetalheMonitorizacaoPTInjetDTO();
		
		IndicadoresDoDetalheRN iRN = new IndicadoresDoDetalheRN(
				rn.getDao(), 
				log, 
				omcfg, 
				ids,
				false /* isRecuperarListaProdutos */, 
				false /* isRecuperarListaOperadores */,
				false /* isRecuperarListaAlertas */, 
				false /* isRecuperarListaPerdas */,
				false /* isRecuperarListaResumoDatas */, 
				false /* isRecuperarListaResumoTurnos */, 
				detalhe, 
				filtro);
		
		
		
		iRN.setResumoIndicadores();

		retorno.setProdutividadeOEE(detalhe.getProdutividadeOEE());
		retorno.setEfiRealizacao(detalhe.getEfiRealizacao());
		retorno.setEfiCiclos(detalhe.getEfiCiclos());
		retorno.setEfiInstantanea(detalhe.getCiclosEficienciaUltCic());
		retorno.setIndiceCavAtivas(detalhe.getIndiceCavAtivas());
		retorno.setIndiceRefugos(detalhe.getIndiceRefugos());
		retorno.setIndiceParadas(detalhe.getIndiceParadas());
		retorno.setIndiceProducao(detalhe.getIndiceProducao());
		retorno.setCdProduto("cdproduto");
		retorno.setDsProduto("dsproduto");
		retorno.setIndiceDefeito(detalhe.getIndiceDefeito());
	}
}
