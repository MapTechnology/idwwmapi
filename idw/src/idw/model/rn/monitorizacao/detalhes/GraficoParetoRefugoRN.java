package idw.model.rn.monitorizacao.detalhes;

import java.awt.Color;
import java.awt.Paint;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolrelog;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.model.rn.geraplano.dtos.DatasDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParetoRefugosDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficosParetoRefugosDTO;
import idw.util.AritmeticaUtil;
import idw.util.CompareUtils;
import idw.util.Cor;
import idw.util.FormulasInjet;
import idw.util.GrafTendenciaUtils;
import idw.util.IdwLogger;
import idw.util.IntervaloGrafTendenciaRefugoParada;
import idw.util.Util;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.OcorrenciasEvtDTO;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.dto.ProdutosDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiFiltroDTO;
import ms.util.ConversaoTipos;

public class GraficoParetoRefugoRN extends AbstractRN<DAOGenerico> {

	public GraficoParetoRefugoRN(){
		this(new DAOGenerico());
	}
	
	public GraficoParetoRefugoRN(DAOGenerico dao) {
		super(dao);
	}


	public GraficosParetoRefugosDTO getGraficoParetoRefugosBIDTO(Date dtInicial, Date dtFinal, String cdTurno, String cdPt, String cdGt, BigDecimal totalRefugado) 
	{
		final int _idtrefugo = 0;
		final int _cdrefugo = 1;
		final int _dsrefugo = 2;
		final int _qtdrefauto = 3;
		final int _qtdrefmanual = 4;

		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select distinct dwtrefugo.idTrefugo,");
		q.append("dwtrefugo.cdTrefugo,");
		q.append("dwtrefugo.dsTrefugo,");
		q.append("sum(dwconsolre.pcsAutoProducaorefugada),");
		q.append("sum(dwconsolre.pcsManuProducaorefugada)");
		q.append("from DwConsolre dwconsolre");
		q.append("join dwconsolre.dwConsol dwconsol");
		q.append("join dwconsol.dwConsolid dwconsolid");
		q.append("join dwconsolre.dwTRefugo dwtrefugo");
		q.append("join dwconsolid.omPt ompt");
		
		if (cdGt != null && cdGt.equals("") == false) 
		{
			q.append("left join ompt.omObjs omobj");
			q.append("left join omobj.omGtByIdGt omgt");
		}
		
		q.append("where dwconsolid.dtReferencia between :dtinicial and :dtfinal");
		q.append("and dwconsolid.dwCal.idCal <> :idcalindefinido");
		
		if (cdTurno != null && cdTurno.equals("") == false)
			q.append("and dwconsolid.dwTurno.cdTurno = :cdturno");
		
		if (cdPt != null && cdPt.equals("") == false )
			q.append("and dwconsolid.omPt.cdPt = :cdpt");
		
		if (cdGt != null && cdGt.equals("") == false)
			q.append("and omgt.cdGt = :cdgt");
		
		q.append("and dwconsolid.tpId = 1");
		q.append("and dwconsolid.stAtivo is null");
		
		q.append("group by dwtrefugo.idTrefugo, dwtrefugo.cdTrefugo, dwtrefugo.dsTrefugo");
		
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		
		q.defineParametro("idcalindefinido", omcfg.getDwCal().getIdCal());
		q.defineParametro("dtinicial", dtInicial);
		q.defineParametro("dtfinal", dtFinal);
		
		if (cdTurno != null)
			q.defineParametro("cdturno", cdTurno);

		if (cdPt != null)
			q.defineParametro("cdpt", cdPt);
		
		if (cdGt != null)
			q.defineParametro("cdgt", cdGt);
		
		List<Object> lista = q.list();
		List<GraficoParetoRefugosDTO> refugos = new ArrayList<GraficoParetoRefugosDTO>();
		
		for (Object reg : lista) {
			GraficoParetoRefugosDTO dto = new GraficoParetoRefugosDTO();
			Object[] registro = (Object[]) reg;
			dto.setCdRefugo(registro[_cdrefugo].toString());
			dto.setCorBarra("");
			dto.setDsRefugo(registro[_dsrefugo].toString());
			
			BigDecimal qtdref = BigDecimal.ZERO;
			
			if (registro[_qtdrefauto] != null)
			{
				qtdref = AritmeticaUtil.somar(qtdref, (BigDecimal) registro[_qtdrefauto]);
			}
			
			if (registro[_qtdrefmanual] != null)
			{
				qtdref = AritmeticaUtil.somar(qtdref, (BigDecimal) registro[_qtdrefmanual]);
			}

			
			if (CompareUtils.equals(qtdref, BigDecimal.ZERO))
			{
				continue;
			}
			
			double indiceRefugo = FormulasInjet.calcularIndiceParada(qtdref, totalRefugado);
			dto.setIndiceRefugo(ConversaoTipos.converterParaBigDecimal(indiceRefugo).setScale(2, RoundingMode.HALF_UP).doubleValue());
			dto.setQtdRefugada(ConversaoTipos.converterParaBigDecimal(qtdref.doubleValue()).setScale(2, RoundingMode.HALF_UP).doubleValue());
			dto.setIdTRefugo(Long.parseLong(registro[_idtrefugo].toString()));
			
			refugos.add(dto);
		}
		
		GraficosParetoRefugosDTO retorno = new GraficosParetoRefugosDTO();
		retorno.setRefugos(refugos);
		DatasDTO datas = new DatasDTO();
		datas.setDtIAtendimento(DataHoraRN.getDataHoraAtual());
		datas.setDtFAtendimento(DataHoraRN.getDataHoraAtual());
		retorno.setCorAmarela(datas);
		retorno.setCorLaranja(datas);
		retorno.setCorVerde(datas);
		retorno.setCorVermelho(datas);
		
		return retorno;
	}
	
	public GraficosParetoRefugosDTO getGraficoParetoRefugosBIDTO(Date dtInicial, Date dtFinal, BigDecimal idTurno, BigDecimal idPt, BigDecimal idGt, BigDecimal totalRefugado) 
	{
		final int _idtrefugo = 0;
		final int _cdrefugo = 1;
		final int _dsrefugo = 2;
		final int _qtdrefauto = 3;
		final int _qtdrefmanual = 4;

		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select distinct dwtrefugo.idTrefugo,");
		q.append("dwtrefugo.cdTrefugo,");
		q.append("dwtrefugo.dsTrefugo,");
		q.append("sum(dwconsolre.pcsAutoProducaorefugada),");
		q.append("sum(dwconsolre.pcsManuProducaorefugada)");
		q.append("from DwConsolre dwconsolre");
		q.append("join dwconsolre.dwConsol dwconsol");
		q.append("join dwconsol.dwConsolid dwconsolid");
		q.append("join dwconsolre.dwTRefugo dwtrefugo");
		q.append("join dwconsolid.omPt ompt");
		
		if (idGt != null && idGt.equals(BigDecimal.ZERO) == false) 
		{
			q.append("left join ompt.omObjs omobj");
			q.append("left join omobj.omGtByIdGt omgt");
		}
		
		q.append("where dwconsolid.dtReferencia between :dtinicial and :dtfinal");
		q.append("and dwconsolid.dwCal.idCal <> :idcalindefinido");
		
		if (idTurno != null && idTurno.equals(BigDecimal.ZERO) == false)
			q.append("and dwconsolid.dwTurno.idTurno = :idturno");
		
		if (idPt != null && idPt.equals(BigDecimal.ZERO) == false )
			q.append("and dwconsolid.omPt.idPt = :idpt");
		
		if (idGt != null && idGt.equals(BigDecimal.ZERO) == false)
			q.append("and omgt.idGt = :idgt");
		
		q.append("and dwconsolid.tpId = 1");
		q.append("and dwconsolid.stAtivo is null");
		
		q.append("group by dwtrefugo.idTrefugo, dwtrefugo.cdTrefugo, dwtrefugo.dsTrefugo");
		
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		
		q.defineParametro("idcalindefinido", omcfg.getDwCal().getIdCal());
		q.defineParametro("dtinicial", dtInicial);
		q.defineParametro("dtfinal", dtFinal);
		if (idTurno != null)
			q.defineParametro("idturno", idTurno.longValue());
		if (idPt != null)
			q.defineParametro("idpt", idPt.longValue());
		
		if (idGt != null)
			q.defineParametro("idgt", idGt.longValue());
		
		List<Object> lista = q.list();
		List<GraficoParetoRefugosDTO> refugos = new ArrayList<GraficoParetoRefugosDTO>();
		
		for (Object reg : lista) {
			GraficoParetoRefugosDTO dto = new GraficoParetoRefugosDTO();
			Object[] registro = (Object[]) reg;
			dto.setCdRefugo(registro[_cdrefugo].toString());
			dto.setCorBarra("");
			dto.setDsRefugo(registro[_dsrefugo].toString());
			
			BigDecimal qtdref = BigDecimal.ZERO;
			
			if (registro[_qtdrefauto] != null)
			{
				qtdref = AritmeticaUtil.somar(qtdref, (BigDecimal) registro[_qtdrefauto]);
			}
			
			if (registro[_qtdrefmanual] != null)
			{
				qtdref = AritmeticaUtil.somar(qtdref, (BigDecimal) registro[_qtdrefmanual]);
			}

			
			if (CompareUtils.equals(qtdref, BigDecimal.ZERO))
			{
				continue;
			}
			
			double indiceRefugo = FormulasInjet.calcularIndiceParada(qtdref, totalRefugado);
			dto.setIndiceRefugo(indiceRefugo);
			dto.setIdTRefugo(Long.parseLong(registro[_idtrefugo].toString()));
			
			refugos.add(dto);
		}
		
		GraficosParetoRefugosDTO retorno = new GraficosParetoRefugosDTO();
		retorno.setRefugos(refugos);
		DatasDTO datas = new DatasDTO();
		datas.setDtIAtendimento(DataHoraRN.getDataHoraAtual());
		datas.setDtFAtendimento(DataHoraRN.getDataHoraAtual());
		retorno.setCorAmarela(datas);
		retorno.setCorLaranja(datas);
		retorno.setCorVerde(datas);
		retorno.setCorVermelho(datas);
		
		return retorno;
	}


	public ProdutosDTO getListaProdutosRefugados(Byte tpId, Date dtInicial, Date dtFinal, BigDecimal idTurno, String cdPt, String cdCp)
	{
		ProdutosDTO retorno = new ProdutosDTO();
		ProdutoDTO produto = new ProdutoDTO();
		
		final int _cdProduto = 0;
		final int _dsProduto = 1;
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT ");
		
		q.append("p.cdProduto, p.dsProduto");
		
		q.append("FROM DwConsolreoco a");
		q.append("JOIN a.dwConsolre b");
		q.append("JOIN b.dwConsol c");
		q.append("JOIN c.dwConsolid d");
		q.append("JOIN a.dwConsolrelog g");
		q.append("JOIN d.omPt ompt");
		q.append("JOIN d.dwFolha dwfolha");
		q.append("JOIN d.dwTurno dwturno");
		q.append("join d.ppCp ppcp");
		//q.append("JOIN ppcp.ppCpprodutos o");
		q.append("JOIN g.omProduto p");
		
		q.append("WHERE d.tpId = :tpid");
		q.append("AND d.dwTurno.idTurno <> 1");
		q.append("AND d.stAtivo is null");
		q.append("AND  (g.isCancelado = :iscancelado OR g.isCancelado IS NULL)");
		
		
		if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO))
		{
			// data
			if (dtInicial != null) 
			{
				q.append("AND d.dtReferencia between :dtinicial and :dtfinal");
			}
	
			// turno
			if (idTurno != null && idTurno.equals(BigDecimal.ZERO) == false)
			{
				q.append("AND d.dwTurno.idTurno = :idturno");		
			}
		}
	
		if (!tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP))
		{
			// máquina
			if (!cdPt.equals("") && !cdPt.equals(null))
			{
				q.append("AND ompt.cdPt = :cdpt");
			}
		}

		// op
		if (!cdCp.equals("") && !cdCp.equals(null))
		{
			q.append("AND ppcp.cdCp = :cdcp");
		}
		
		q.append("ORDER BY p.cdProduto");
		

		// defini��oo de parâmetros

		if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO))
		{
			// data
			if (dtInicial != null) 
			{
				q.defineParametroData("dtinicial", dtInicial);
				q.defineParametroData("dtfinal", dtFinal);			
			}
			
			// turno
			if (idTurno != null && idTurno.equals(BigDecimal.ZERO) == false)
			{
				q.defineParametro("idturno", idTurno.longValue());
			}
		}

		if (!tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP))
		{
			// máquina
			if (!cdPt.equals("") && !cdPt.equals(null))
			{
				q.defineParametro("cdpt", cdPt);
			}
		}

		// op
		if (!cdCp.equals("") && !cdCp.equals(null))
		{
			q.defineParametro("cdcp", cdCp);
		}
		q.defineParametro("iscancelado", false);
		
		if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_ACUMULADO) || tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP))
			q.defineParametro("tpid", DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_ACUMULADO);
		else
			q.defineParametro("tpid", DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO);
		
		List<Object> lista = q.list();
		
		retorno.setProdutos(new ArrayList<ProdutoDTO>());
		for (Object reg : lista) {
			
			Object[] registro = (Object[]) reg;
			String cdProduto = (String) registro[_cdProduto];
			String dsProduto = (String) registro[_dsProduto];
			
			OmProduto produtoLista = new OmProduto();
			produtoLista.setCdProduto(cdProduto);
			produtoLista.setDsProduto(dsProduto);
						
			produto = new ProdutoDTO();
			produto.setProduto(new OmProduto());
			produto.setProduto(produtoLista);
			retorno.getProdutos().add(produto);
		}		


		return retorno;
	}
	
	public GraficosParetoRefugosDTO getGraficoParetoRefugoDTO(Byte tpId, Date dtInicial, Date dtFinal, BigDecimal idTurno, String cdPt, String cdCp, BigDecimal totalRefugado, String cdProduto){
		final int _idconsolre = 0;
		final int _idtrefugo = 1;
		final int _cdrefugo = 2;
		final int _dsrefugo = 3;
		final int _qtdrefauto = 4;
		final int _qtdrefmanual = 5;
        final int _qtdrefautoGr = 6;
        final int _qtdrefmanualGr = 7;

		Date menorDthrOcor = null;
		Date maiorDthrOcor = null;
		        
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT distinct ");
		
		q.append("dwconsolre.idConsolre,");
		q.append("dwtrefugo.idTrefugo,");		
		
		q.append("dwtrefugo.cdTrefugo,");
		q.append("dwtrefugo.dsTrefugo,");
		q.append("sum(dwconsolrelog.pcsAutoProducaorefugada),");
		q.append("sum(dwconsolrelog.pcsManuProducaorefugada),");
        q.append("sum(dwconsolrelog.pcsAutoProducaorefugada * omproduto.GPesoBruto),");
        q.append("sum(dwconsolrelog.pcsManuProducaorefugada * omproduto.GPesoBruto)");
		q.append("FROM DwConsolre dwconsolre");
		// Alessandre em 20-06-17 acrescentei o OCO para chegar no LOG e no produto a fim de obter os pesos do produto.
		// Pelo fato de dwconsolpr estar na lista de joins os refugos se duplicaram qdo tinha mais de 2 produtos
		q.append("join dwconsolre.dwConsolreocos dwconsolreoco");
		q.append("join dwconsolreoco.dwConsolrelog dwconsolrelog");
		q.append("JOIN dwconsolrelog.omProduto omproduto");		

		q.append("JOIN dwconsolre.dwConsol dwconsol");
		q.append("JOIN dwconsol.dwConsolid dwconsolid");
		q.append("JOIN dwconsolre.dwTRefugo dwtrefugo");
		
		q.append("WHERE dwconsolid.tpId = :tpid");
		q.append("and (dwconsolrelog.isCancelado = :iscancelado or dwconsolrelog.isCancelado is null) ");
		
		if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO))
		{
			// data
			if (dtInicial != null) 
			{
				q.append("AND dwconsolid.dtReferencia between :dtinicial and :dtfinal");
			}
	
			// turno
			if (idTurno != null && idTurno.equals(BigDecimal.ZERO) == false) {
				q.append("AND dwconsolid.dwTurno.idTurno = :idturno");		
			} else {
				//Alex 24/05/2017 #3023 item 4
				q.append("AND dwconsolid.dwTurno.idTurno <> 1");
			}
		}
	
			// máquina
			if (!cdPt.equals("") && !cdPt.equals(null))
			{
				q.append("AND dwconsolid.omPt.cdPt = :cdpt");
			}

		// op
		if (!cdCp.equals("") && !cdCp.equals(null))
		{
			q.append("AND dwconsolid.ppCp.cdCp = :cdcp");
		}
		
		q.append("GROUP BY dwconsolre.idConsolre, dwtrefugo.idTrefugo, dwtrefugo.cdTrefugo, dwtrefugo.dsTrefugo");
		

		// defini��oo de parâmetros

		if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO))
		{
			// data
			if (dtInicial != null) 
			{
				q.defineParametroData("dtinicial", dtInicial);
				q.defineParametroData("dtfinal", dtFinal);			
			}
			
			// turno
			if (idTurno != null && idTurno.equals(BigDecimal.ZERO) == false)
			{
				q.defineParametro("idturno", idTurno.longValue());
			}
		}

			// máquina
			if (!cdPt.equals("") && !cdPt.equals(null))
			{
				q.defineParametro("cdpt", cdPt);
			}

		// op
		if (!cdCp.equals("") && !cdCp.equals(null))
		{
			q.defineParametro("cdcp", cdCp);
		}
		
		if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_ACUMULADO) || tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP))
			q.defineParametro("tpid", DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_ACUMULADO);
		else
			q.defineParametro("tpid", DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO);

		q.defineParametro("iscancelado", false);
		
		
		List<Object> lista = q.list();
		List<GraficoParetoRefugosDTO> refugos = new ArrayList<GraficoParetoRefugosDTO>();
		
		HashMap<String, GraficoParetoRefugosDTO> mapRefugos = new HashMap<String, GraficoParetoRefugosDTO>();
		HashMap<String, List<OcorrenciasEvtDTO>> mapOcorrenciasPorRefugo = new HashMap<String, List<OcorrenciasEvtDTO>>();
		HashMap<String, BigDecimal> mapIndicePorRefugo = new HashMap<String, BigDecimal>();
		
		
		for (Object reg : lista) {
			
			Object[] registro = (Object[]) reg;
			Long idConsolre = (Long) registro[_idconsolre];
			Long idTRefugo = (Long) registro[_idtrefugo];
			String cdRefugo = (String) registro[_cdrefugo];
			String dsRefugo = (String) registro[_dsrefugo];
			BigDecimal qtdRefAuto = (BigDecimal) registro[_qtdrefauto];
			BigDecimal qtdRefManual = (BigDecimal) registro[_qtdrefmanual];
            BigDecimal qtdRefAutoGr = (BigDecimal) registro[_qtdrefautoGr];
            BigDecimal qtdRefManualGr = (BigDecimal) registro[_qtdrefmanualGr];
									
			GraficoParetoRefugosDTO refugoGraf = mapRefugos.get(cdRefugo);	
			
			// Se for um motivo de refugo que esta ocorrendo a primeira vez, entao criar um mapRefugo
			if(refugoGraf == null) {
				refugoGraf = new GraficoParetoRefugosDTO();
				
				refugoGraf.setIdTRefugo(idTRefugo);
				refugoGraf.setCdRefugo(cdRefugo);
				refugoGraf.setDsRefugo(dsRefugo);
				
				BigDecimal qtdref = BigDecimal.ZERO;
				
				if (registro[_qtdrefauto] != null)
				{
					qtdref = AritmeticaUtil.somar(qtdref, qtdRefAuto);
				}
				
				if (registro[_qtdrefmanual] != null)
				{
					qtdref = AritmeticaUtil.somar(qtdref, qtdRefManual);
				}
				
				if (qtdref != null && qtdref.intValue() <= 0){
					continue;
				}

				refugoGraf.setQtdRefugada(qtdref.doubleValue());

				// producao refugada em gramas
                BigDecimal qtdrefGr = BigDecimal.ZERO;
                
                if (registro[_qtdrefautoGr] != null)
                {
                    qtdrefGr = AritmeticaUtil.somar(qtdrefGr, qtdRefAutoGr);
                }
                
                if (registro[_qtdrefmanualGr] != null)
                {
                    qtdrefGr = AritmeticaUtil.somar(qtdrefGr, qtdRefManualGr);
                }
                
                if (qtdrefGr != null && qtdrefGr.intValue() <= 0){
                	//Alex - 06/04/2017: comentei o CONTINUE, pq se o produto nao tiver peso ele nao eh mostrado no grafico.
                    //continue;
                }

                // producao refugada em kg e ton
                refugoGraf.setQtdRefugadaKg( qtdrefGr.divide(new BigDecimal(1000), BigDecimal.ROUND_HALF_EVEN).doubleValue() );				
                refugoGraf.setQtdRefugadaTon( qtdrefGr.divide(new BigDecimal(1000000), BigDecimal.ROUND_HALF_EVEN).doubleValue() );
				
                                
				BigDecimal qtdRefMap = mapIndicePorRefugo.get(cdRefugo);
				if(qtdRefMap == null){
					qtdRefMap = qtdref;
					mapIndicePorRefugo.put(cdRefugo, qtdRefMap);
				}
								
				double indiceRefugo = FormulasInjet.calcularIndiceRefugo(qtdref, totalRefugado).doubleValue();
				refugoGraf.setIndiceRefugo(indiceRefugo);

				List<DwConsolrelog> listaOcorrencias = getDwConsolrelogs(idConsolre);
				boolean isIncluirRefugo = false; //Um refugo nao sera incluido qdo existir um filtro pro produto e nao passar pelo filtro
				// O loop abaixo tem dois objetivo pegar as ocorrencias do refugo e inicializar os refugos por produto
				for(DwConsolrelog ocorrencia : listaOcorrencias) {
					// Verificar se ja existe para o motivo de refugo analizado uma referencia do produto
					ProdutoDTO produtoDTO = null;
					for (ProdutoDTO dto : refugoGraf.getRefugosPorProduto()) {
						if (dto.getProduto().getIdProduto() == ocorrencia.getOmProduto().getIdProduto()) {
							produtoDTO = dto;
						}
					}
					if (produtoDTO == null) {
						produtoDTO = new ProdutoDTO();
						produtoDTO.setProduto(ocorrencia.getOmProduto().clone(false));
						produtoDTO.setPcsProducaoRefugada(BigDecimal.ZERO);
						refugoGraf.getRefugosPorProduto().add(produtoDTO);
					}
					// Se for definido um filtro para produto avaliar se o registro do refugo passa pelo filtro
					if (cdProduto != null && cdProduto.equals("") == false) {
						if (produtoDTO.getProduto().getCdProduto().equals(cdProduto)) {
							isIncluirRefugo = true;
						}
					} else {
						isIncluirRefugo = true;
					}
					produtoDTO.setPcsProducaoRefugada(produtoDTO.getPcsProducaoRefugada().add(qtdref));
					
					//PEGA MAIOR E MENOR DATA/HORA DE OCORR�NCIA DE REFUGO
					menorDthrOcor = getMenorDthrOcor(ocorrencia.getDthrRefugo(), menorDthrOcor);
					maiorDthrOcor = getMaiorDthrOcor(ocorrencia.getDthrRefugo(), maiorDthrOcor);
					
					List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorRefugo.get(cdRefugo);
					if(listaOcoDTO == null) {
						listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
						OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
						ocoDTO.setIdEvt(idTRefugo);
						ocoDTO.setDthrIni(ocorrencia.getDthrRefugo()); 
						ocoDTO.setDthrFim(ocorrencia.getDthrRefugo());
						
						int duracaoEvt = 0;
						ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
						ocoDTO.setMsDtHrIni(ocorrencia.getMsDthrrefugo());
						ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrrefugo());
						
						listaOcoDTO.add(ocoDTO);
						mapOcorrenciasPorRefugo.put(cdRefugo, listaOcoDTO);					}
					else {
						OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
						ocoDTO.setIdEvt(idTRefugo);
						ocoDTO.setDthrIni(ocorrencia.getDthrRefugo()); 
						ocoDTO.setDthrFim(ocorrencia.getDthrRefugo());
						
						int duracaoEvt = 0;
						
						ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
						ocoDTO.setMsDtHrIni(ocorrencia.getMsDthrrefugo());
						ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrrefugo());
						
						listaOcoDTO.add(ocoDTO);
					}
				}
				if (isIncluirRefugo) {
					mapRefugos.put(cdRefugo, refugoGraf);
					refugos.add(refugoGraf);
				}
				
			} else {

				//BigDecimal qtdref = BigDecimal.ZERO;
				BigDecimal qtdref = new BigDecimal(mapRefugos.get(cdRefugo).getQtdRefugada());
				
				if (registro[_qtdrefauto] != null)
				{
					qtdref = AritmeticaUtil.somar(qtdref, qtdRefAuto);
				}
				
				if (registro[_qtdrefmanual] != null)
				{
					qtdref = AritmeticaUtil.somar(qtdref, qtdRefManual);
				}

				refugoGraf.setQtdRefugada(qtdref.doubleValue());
				
				if (CompareUtils.equals(qtdref, BigDecimal.ZERO)){
					continue;
				}
				
                // producao refugada em gramas
                BigDecimal qtdrefGr = BigDecimal.ZERO;
                
                if (registro[_qtdrefautoGr] != null)
                {
                    qtdrefGr = AritmeticaUtil.somar(qtdrefGr, qtdRefAutoGr);
                }
                
                if (registro[_qtdrefmanualGr] != null)
                {
                    qtdrefGr = AritmeticaUtil.somar(qtdrefGr, qtdRefManualGr);
                }
                
                if (qtdrefGr != null && qtdrefGr.intValue() <= 0){
                    continue;
                }

                // producao refugada em kg e ton
                refugoGraf.setQtdRefugadaKg( qtdrefGr.divide(new BigDecimal(1000), BigDecimal.ROUND_HALF_EVEN).doubleValue() );             
                refugoGraf.setQtdRefugadaTon( qtdrefGr.divide(new BigDecimal(1000000), BigDecimal.ROUND_HALF_EVEN).doubleValue() );
                
				
				BigDecimal qtdRefMap = mapIndicePorRefugo.get(cdRefugo);
				if(qtdRefMap == null){
					qtdRefMap = qtdref;
					mapIndicePorRefugo.put(cdRefugo, qtdRefMap);
				}

				double indiceRefugo = FormulasInjet.calcularIndiceRefugo(qtdref, totalRefugado).doubleValue();
				refugoGraf.setIndiceRefugo(indiceRefugo);
				
				
				List<DwConsolrelog> listaOcorrencias = getDwConsolrelogs(idConsolre);
								
				for(DwConsolrelog ocorrencia : listaOcorrencias){
					// Verificar se ja existe para o motivo de refugo analizado uma referencia do produto
					ProdutoDTO produtoDTO = null;
					for (ProdutoDTO dto : refugoGraf.getRefugosPorProduto()) {
						if (dto.getProduto().getIdProduto() == ocorrencia.getOmProduto().getIdProduto()) {
							produtoDTO = dto;
						}
					}
					if (produtoDTO == null) {
						produtoDTO = new ProdutoDTO();
						produtoDTO.setProduto(ocorrencia.getOmProduto().clone(false));
						produtoDTO.setPcsProducaoRefugada(BigDecimal.ZERO);
						refugoGraf.getRefugosPorProduto().add(produtoDTO);
					}
					produtoDTO.setPcsProducaoRefugada(produtoDTO.getPcsProducaoRefugada().add(qtdref));

					List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorRefugo.get(cdRefugo);
					if(listaOcoDTO != null){
						OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
						ocoDTO.setIdEvt(idTRefugo);  
						ocoDTO.setDthrIni(ocorrencia.getDthrRefugo()); 
						ocoDTO.setDthrFim(ocorrencia.getDthrRefugo());
						
						int duracaoEvt = 0;						
						ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
						
						ocoDTO.setMsDtHrIni(ocorrencia.getMsDthrrefugo());
						ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrrefugo());
						
						listaOcoDTO.add(ocoDTO);
					}
				}
			}
			
		}
		
 		
		for (GraficoParetoRefugosDTO dto : refugos) {
			dto.setIndiceRefugo(ConversaoTipos.converterParaBigDecimal(dto.getIndiceRefugo()).setScale(2, RoundingMode.HALF_UP).doubleValue());
			dto.setQtdRefugada(ConversaoTipos.converterParaBigDecimal(dto.getQtdRefugada()).setScale(2, RoundingMode.HALF_UP).doubleValue());
		}
		
		GrafTendenciaUtils algoritmoGraf = null;
		
		//MONTA O GRAFICO - NESTE MOMENTO É DEFINIDO O INTERVALO DE CORES
		if(menorDthrOcor != null && maiorDthrOcor != null){
			algoritmoGraf = new GrafTendenciaUtils(menorDthrOcor, maiorDthrOcor);
		}
		
		GraficosParetoRefugosDTO retorno = new GraficosParetoRefugosDTO();
		retorno.setRefugos(refugos);
		DatasDTO datas = new DatasDTO();
		datas.setDtIAtendimento(DataHoraRN.getDataHoraAtual());
		datas.setDtFAtendimento(DataHoraRN.getDataHoraAtual());
		retorno.setCorAmarela(datas);
		retorno.setCorLaranja(datas);
		retorno.setCorVerde(datas);
		retorno.setCorVermelho(datas);
		
		if (totalRefugado.compareTo(BigDecimal.ZERO) >= 1) {
			defineCoresLegendaEBarra(algoritmoGraf, retorno, mapRefugos, mapOcorrenciasPorRefugo);
		}
		
		return retorno;
	}
	

	public GraficosParetoRefugosDTO getGraficoParetoRefugoDTO(Byte tpId, BiFiltroDTO filtroBI){
		final int _idconsolre = 0;
		final int _idtrefugo = 1;
		final int _cdrefugo = 2;
		final int _dsrefugo = 3;
		final int _qtdrefauto = 4;
		final int _qtdrefmanual = 5;
        
		Date menorDthrOcor = null;
		Date maiorDthrOcor = null;
		        
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT distinct ");
		
		q.append("dwconsolre.idConsolre,");
		q.append("dwtrefugo.idTrefugo,");		
		
		q.append("dwtrefugo.cdTrefugo,");
		q.append("dwtrefugo.dsTrefugo,");
		q.append("sum(dwconsolrelog.pcsAutoProducaorefugada),");
		q.append("sum(dwconsolrelog.pcsManuProducaorefugada) ");
		
		q.append("FROM DwConsolre dwconsolre");
		q.append("JOIN dwconsolre.dwConsolreocos dwconsolreoco");
		q.append("JOIN dwconsolreoco.dwConsolrelog dwconsolrelog");
		
		q.append("JOIN dwconsolre.dwConsol dwconsol");
		q.append("JOIN dwconsol.dwConsolid dwconsolid");
		q.append("JOIN dwconsolre.dwTRefugo dwtrefugo");
		q.append("JOIN dwconsolid.omPt pt");
		
		
		// gt
		if (filtroBI.getCdGt() != null && filtroBI.getCdGt().equals("") == false) {
			q.append("left join pt.omObjs omobj");
			q.append("left join omobj.omGtByIdGt omgt");
		}
		
		
		// tabela relacionado a grupo de ferramenta
		if ( (filtroBI.getCdGrpRap() != null && filtroBI.getCdGrpRap().equals("") == false)  || 
			 (filtroBI.getCdRap() != null && filtroBI.getCdRap().equals("") == false)) {
			q.append("  JOIN dwconsolid.dwFolha fl ");	
			q.append("  JOIN fl.dwFolharaps flr ");	
			q.append("  JOIN flr.dwRap rap ");
			q.append("  JOIN rap.dwRapGrupos gr ");	
			q.append("  JOIN gr.dwGrupoFerramenta grf ");	
		}
		
		q.append("WHERE dwconsolid.tpId = :tpid");
		q.append("and (dwconsolrelog.isCancelado = :iscancelado or dwconsolrelog.isCancelado is null) ");
		
		if (filtroBI.getCdGt() != null && filtroBI.getCdGt().equals("") == false) {
			q.append("and omgt.cdGt = :cdgt");
		}

		// grupo rap
		if (filtroBI.getCdGrpRap() != null && filtroBI.getCdGrpRap().equals("") == false) {
			q.append("and grf.cdGrupoFerramenta = :cdgrprap");
		}
	
		// ferramenenta
		if (filtroBI.getCdRap() != null && filtroBI.getCdRap().equals("") == false) {
			q.append("and rap.cdRap = :cdrap");
		}
		
		// data
		if (filtroBI.getDtIniDt() != null && !filtroBI.getDtIni().equals("")) 	{
			q.append("AND dwconsolid.dtReferencia between :dtinicial and :dtfinal");
		}

		if (filtroBI.getAnoIni() != null && !filtroBI.getAnoIni().equals("") ) {
			q.append(" AND ((dwconsolid.ano * 1000) + dwconsolid.mes) BETWEEN :ami AND :amf");
		}  
		
		// turno
		if (filtroBI.getCdTurno() != null && filtroBI.getCdTurno().equals("") == false) {
			q.append("AND dwconsolid.dwTurno.cdTurno = :cdturno");		
		} else {
			q.append("AND dwconsolid.dwTurno.idTurno <> 1");
		}
 
		// máquina
		if (filtroBI.getCdPt() != null && filtroBI.getCdPt().equals("") == false) {
			q.append("AND dwconsolid.omPt.cdPt = :cdpt");
		}

		if (filtroBI.getCdProduto() != null && filtroBI.getCdProduto().equals("") == false) {
			q.append("and dwconsolrelog.omProduto.cdProduto = :cdproduto ");
		}
		
		if (!filtroBI.getCdClasseMaquina().equals("")) {
			if (filtroBI.getCdClasseMaquina().equals("A")) {
				q.append("  AND pt.tpClasseabc = 0 "); 
				
			} else if (filtroBI.getCdClasseMaquina().equals("B")) {
				q.append("  AND pt.tpClasseabc = 1 ");
				
			} else {
				q.append("  AND pt.tpClasseabc = 2 ");	
			}				
		} 
		
		q.append("GROUP BY dwconsolre.idConsolre, dwtrefugo.idTrefugo, dwtrefugo.cdTrefugo, dwtrefugo.dsTrefugo");
		

		// parametros

		
		// ano/mes
		if (filtroBI.getAnoIni() != null && !filtroBI.getAnoIni().equals("") ) {
			Integer ami = (ConversaoTipos.converterParaBigDecimal(filtroBI.getAnoIni()).intValue() * 1000) + ConversaoTipos.converterParaBigDecimal(filtroBI.getMesIni()).intValue();
			Integer amf = (ConversaoTipos.converterParaBigDecimal(filtroBI.getAnoFim()).intValue() * 1000) + ConversaoTipos.converterParaBigDecimal(filtroBI.getMesFim()).intValue();				
			q.defineParametro("ami", ami);
            q.defineParametro("amf", amf);
        }
        
		// data
		if (filtroBI.getDtIniDt() != null && !filtroBI.getDtIni().equals("")) 	{
			q.defineParametroData("dtinicial", filtroBI.getDtIniDt());
			q.defineParametroData("dtfinal", filtroBI.getDtFimDt());			
		}
		
		// turno
		if (filtroBI.getCdTurno() != null && filtroBI.getCdTurno().equals("") == false) {
			q.defineParametro("cdturno", filtroBI.getCdTurno());
		} 

		// máquina
		if (filtroBI.getCdPt() != null && filtroBI.getCdPt().equals("") == false) {
			q.defineParametro("cdpt", filtroBI.getCdPt());
		}

		// gt
		if (filtroBI.getCdGt() != null) {
			q.defineParametro("cdgt", filtroBI.getCdGt()); 
		}

		
		// ferramentas
		if (filtroBI.getCdGrpRap() != null && filtroBI.getCdGrpRap().equals("") == false) {
			q.defineParametro("cdgrprap", filtroBI.getCdGrpRap()); 
		}
		
		if (filtroBI.getCdRap() != null && filtroBI.getCdRap().equals("") == false) {
			q.defineParametro("cdrap", filtroBI.getCdRap()); 
		}
		
		

		// produto
		if (filtroBI.getCdProduto() != null && filtroBI.getCdProduto().equals("") == false) {
			q.defineParametro("cdproduto", filtroBI.getCdProduto());
		}
		
		
		q.defineParametro("tpid", DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO);

		q.defineParametro("iscancelado", false);
		
		
		List<Object> lista = q.list();
		List<GraficoParetoRefugosDTO> refugos = new ArrayList<GraficoParetoRefugosDTO>();
		
		HashMap<String, GraficoParetoRefugosDTO> mapRefugos = new HashMap<String, GraficoParetoRefugosDTO>();
		HashMap<String, List<OcorrenciasEvtDTO>> mapOcorrenciasPorRefugo = new HashMap<String, List<OcorrenciasEvtDTO>>();
		HashMap<String, BigDecimal> mapIndicePorRefugo = new HashMap<String, BigDecimal>();
		
		
		BigDecimal totalRefugado = ConversaoTipos.converterParaBigDecimal(filtroBI.getIndicadores().getPcsProdRefugada());
		
		for (Object reg : lista) {
			
			Object[] registro = (Object[]) reg;
			Long idConsolre = (Long) registro[_idconsolre];
			Long idTRefugo = (Long) registro[_idtrefugo];
			String cdRefugo = (String) registro[_cdrefugo];
			String dsRefugo = (String) registro[_dsrefugo];
			BigDecimal qtdRefAuto = (BigDecimal) registro[_qtdrefauto];
			BigDecimal qtdRefManual = (BigDecimal) registro[_qtdrefmanual]; 
									
			GraficoParetoRefugosDTO refugoGraf = mapRefugos.get(cdRefugo);
			
			// Se for um motivo de refugo que esta ocorrendo a primeira vez, entao criar um mapRefugo
			if(refugoGraf == null) {
				refugoGraf = new GraficoParetoRefugosDTO();
				refugoGraf.setIdTRefugo(idTRefugo);
				refugoGraf.setCdRefugo(cdRefugo);
				refugoGraf.setDsRefugo(dsRefugo);
				
				BigDecimal qtdref = BigDecimal.ZERO;
				
				if (registro[_qtdrefauto] != null){
					qtdref = AritmeticaUtil.somar(qtdref, qtdRefAuto);
				}
				
				if (registro[_qtdrefmanual] != null){
					qtdref = AritmeticaUtil.somar(qtdref, qtdRefManual);
				}
				
				if (qtdref != null && qtdref.intValue() <= 0){
					continue;
				}

				refugoGraf.setQtdRefugada(qtdref.doubleValue());

                                
				BigDecimal qtdRefMap = mapIndicePorRefugo.get(cdRefugo);
				if(qtdRefMap == null){
					qtdRefMap = qtdref;
					mapIndicePorRefugo.put(cdRefugo, qtdRefMap);
				}
								
				double indiceRefugo = FormulasInjet.calcularIndiceRefugo(qtdref, totalRefugado).doubleValue();
				refugoGraf.setIndiceRefugo(indiceRefugo);

				List<DwConsolrelog> listaOcorrencias = getDwConsolrelogs(idConsolre);
				boolean isIncluirRefugo = false; //Um refugo nao sera incluido qdo existir um filtro pro produto e nao passar pelo filtro
				// O loop abaixo tem dois objetivo pegar as ocorrencias do refugo e inicializar os refugos por produto
				for(DwConsolrelog ocorrencia : listaOcorrencias) {
					// Verificar se ja existe para o motivo de refugo analizado uma referencia do produto
					ProdutoDTO produtoDTO = null;
					for (ProdutoDTO dto : refugoGraf.getRefugosPorProduto()) {
						if (dto.getProduto().getIdProduto() == ocorrencia.getOmProduto().getIdProduto()) {
							produtoDTO = dto;
						}
					}
					if (produtoDTO == null) {
						produtoDTO = new ProdutoDTO();
						produtoDTO.setProduto(ocorrencia.getOmProduto().clone(false));
						produtoDTO.setPcsProducaoRefugada(BigDecimal.ZERO);
						refugoGraf.getRefugosPorProduto().add(produtoDTO);
					}
					// Se for definido um filtro para produto avaliar se o registro do refugo passa pelo filtro
					isIncluirRefugo = true;
					produtoDTO.setPcsProducaoRefugada(produtoDTO.getPcsProducaoRefugada().add(qtdref));
					
					//PEGA MAIOR E MENOR DATA/HORA DE OCORR�NCIA DE REFUGO
					menorDthrOcor = getMenorDthrOcor(ocorrencia.getDthrRefugo(), menorDthrOcor);
					maiorDthrOcor = getMaiorDthrOcor(ocorrencia.getDthrRefugo(), maiorDthrOcor);
					
					List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorRefugo.get(cdRefugo);
					if(listaOcoDTO == null) {
						listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
						OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
						ocoDTO.setIdEvt(idTRefugo);
						ocoDTO.setDthrIni(ocorrencia.getDthrRefugo()); 
						ocoDTO.setDthrFim(ocorrencia.getDthrRefugo());
						
						int duracaoEvt = 0;
						ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
						ocoDTO.setMsDtHrIni(ocorrencia.getMsDthrrefugo());
						ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrrefugo());
						
						listaOcoDTO.add(ocoDTO);
						mapOcorrenciasPorRefugo.put(cdRefugo, listaOcoDTO);					}
					else {
						OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
						ocoDTO.setIdEvt(idTRefugo);
						ocoDTO.setDthrIni(ocorrencia.getDthrRefugo()); 
						ocoDTO.setDthrFim(ocorrencia.getDthrRefugo());
						
						int duracaoEvt = 0;
						
						ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
						ocoDTO.setMsDtHrIni(ocorrencia.getMsDthrrefugo());
						ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrrefugo());
						
						listaOcoDTO.add(ocoDTO);
					}
				}
				if (isIncluirRefugo) {
					mapRefugos.put(cdRefugo, refugoGraf);
					refugos.add(refugoGraf);
				}
				
			} else {

				//BigDecimal qtdref = BigDecimal.ZERO;
				BigDecimal qtdref = new BigDecimal(mapRefugos.get(cdRefugo).getQtdRefugada());
				
				if (registro[_qtdrefauto] != null)
				{
					qtdref = AritmeticaUtil.somar(qtdref, qtdRefAuto);
				}
				
				if (registro[_qtdrefmanual] != null)
				{
					qtdref = AritmeticaUtil.somar(qtdref, qtdRefManual);
				}

				refugoGraf.setQtdRefugada(qtdref.doubleValue());
				
				if (CompareUtils.equals(qtdref, BigDecimal.ZERO)){
					continue;
				}
				
              
				BigDecimal qtdRefMap = mapIndicePorRefugo.get(cdRefugo);
				if(qtdRefMap == null){
					qtdRefMap = qtdref;
					mapIndicePorRefugo.put(cdRefugo, qtdRefMap);
				}

				double indiceRefugo = FormulasInjet.calcularIndiceRefugo(qtdref, totalRefugado).doubleValue();
				refugoGraf.setIndiceRefugo(indiceRefugo);
				
				
				List<DwConsolrelog> listaOcorrencias = getDwConsolrelogs(idConsolre);
								
				for(DwConsolrelog ocorrencia : listaOcorrencias){
					// Verificar se ja existe para o motivo de refugo analizado uma referencia do produto
					ProdutoDTO produtoDTO = null;
					for (ProdutoDTO dto : refugoGraf.getRefugosPorProduto()) {
						if (dto.getProduto().getIdProduto() == ocorrencia.getOmProduto().getIdProduto()) {
							produtoDTO = dto;
						}
					}
					if (produtoDTO == null) {
						produtoDTO = new ProdutoDTO();
						produtoDTO.setProduto(ocorrencia.getOmProduto().clone(false));
						produtoDTO.setPcsProducaoRefugada(BigDecimal.ZERO);
						refugoGraf.getRefugosPorProduto().add(produtoDTO);
					}
					produtoDTO.setPcsProducaoRefugada(produtoDTO.getPcsProducaoRefugada().add(qtdref));

					List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorRefugo.get(cdRefugo);
					if(listaOcoDTO != null){
						OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
						ocoDTO.setIdEvt(idTRefugo);  
						ocoDTO.setDthrIni(ocorrencia.getDthrRefugo()); 
						ocoDTO.setDthrFim(ocorrencia.getDthrRefugo());
						
						int duracaoEvt = 0;						
						ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
						
						ocoDTO.setMsDtHrIni(ocorrencia.getMsDthrrefugo());
						ocoDTO.setMsDtHrFim(ocorrencia.getMsDthrrefugo());
						
						listaOcoDTO.add(ocoDTO);
					}
				}
			}
			
		}
		
		
		GrafTendenciaUtils algoritmoGraf = null;
		
		//MONTA O GRAFICO - NESTE MOMENTO É DEFINIDO O INTERVALO DE CORES
		if(menorDthrOcor != null && maiorDthrOcor != null){
			algoritmoGraf = new GrafTendenciaUtils(menorDthrOcor, maiorDthrOcor);
		}
		
		
		for (GraficoParetoRefugosDTO dto : refugos) {
			dto.setIndiceRefugo(ConversaoTipos.converterParaBigDecimal(dto.getIndiceRefugo()).setScale(2, RoundingMode.HALF_UP).doubleValue());
			dto.setQtdRefugada(ConversaoTipos.converterParaBigDecimal(dto.getQtdRefugada()).setScale(2, RoundingMode.HALF_UP).doubleValue());
			dto.setRefugosPorProduto(null);
		}
		
		GraficosParetoRefugosDTO retorno = new GraficosParetoRefugosDTO();
		retorno.setRefugos(refugos);
		DatasDTO datas = new DatasDTO();
		datas.setDtIAtendimento(DataHoraRN.getDataHoraAtual());
		datas.setDtFAtendimento(DataHoraRN.getDataHoraAtual());
		retorno.setCorAmarela(datas);
		retorno.setCorLaranja(datas);
		retorno.setCorVerde(datas);
		retorno.setCorVermelho(datas);
		
		if (totalRefugado.compareTo(BigDecimal.ZERO) >= 1) {
			defineCoresLegendaEBarra(algoritmoGraf, retorno, mapRefugos, mapOcorrenciasPorRefugo);
		}
		
		return retorno;
	}
	
	private Date getMenorDthrOcor(Date dthr, Date menorDthr){
		if(menorDthr == null){
			return dthr;
		}else{
			if(DataHoraRN.before(dthr, menorDthr)){
				return dthr;
			}else{
				return menorDthr;
			}
		}
	}
	
	private Date getMaiorDthrOcor(Date dthr, Date maiorDthr){
		if(maiorDthr == null){
			return dthr;
		}else{
			if(DataHoraRN.after(dthr, maiorDthr)){
				return dthr;
			}else{
				return maiorDthr;
			}
		}
	}
		
	private List<DwConsolrelog> getDwConsolrelogs(long idConsolre){
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT log");
		q.append("FROM DwConsolreoco oco");
		q.append("JOIN oco.dwConsolre re");
		q.append("JOIN oco.dwConsolrelog log");
		q.append("WHERE re.idConsolre = :idConsolre");
		q.defineParametro("idConsolre", idConsolre);
		return q.list();
	}
	
	public GraficosParetoRefugosDTO getGraficoParetoRefugo2DTO(FiltroDetalhePTInjetDTO filtro, BigDecimal totalRefugado)
	{

		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "GraficoParetoRefugoRN.getGraficoParetoRefugo2DTO");
		log.info( idLog , 0, "GraficoParetoRefugoRN.getGraficoParetoRefugo2DTO filtro usado:" + filtro.toString());
		

		Date menorDthrOcor = null;
		Date maiorDthrOcor = null;
		
		MapQuery q = new MapQuery(getDaoSession());

		q.append("SELECT relog ");
		q.append("FROM DwConsolid dwconsolid");
		q.append("JOIN dwconsolid.dwConsols dwconsol");

		q.append("JOIN dwconsol.dwConsolres dwconsolre");
		q.append("JOIN dwconsolre.dwTRefugo dwtrefugo");
		
		q.append("JOIN dwconsolre.dwConsolreocos reoco");
		q.append("JOIN reoco.dwConsolrelog relog");
		q.append("JOIN relog.omProduto omproduto");
		 
		
		q.append("left join dwconsolid.ppCp ppcp");
		
		if (filtro.getOmProduto() != null && filtro.getOmProduto().getIdProduto() > 0) {
	        q.append("left join ppcp.ppCpprodutos ppcpprodutos");		    
		}
                
		q.append("left join dwconsolid.dwFolha dwfolha");

		if ((filtro.getOmProduto() != null
				&& filtro.getOmProduto().getCdProduto() != null && filtro
				.getOmProduto().getCdProduto().equals("") == false)
				| ((filtro.getCdGrupoFerramenta() != null) || (filtro
						.getDwRap() != null))) {
			q.append("left join dwfolha.dwFolharaps dwfolharap");
			q.append("left join dwfolharap.dwFolharapcoms dwfolharapcom");

			// grupo de moldes - novo filtro BI
			if (filtro.getCdGrupoFerramenta() != null) {
				q.append("LEFT JOIN dwfolharap.dwRap.dwRapGrupos grpmol");
			}
		}

		if (filtro.getOmProduto() != null
				&& filtro.getOmProduto().getCdProduto() != null
				&& filtro.getOmProduto().getCdProduto().equals("") == false) {
			q.append("left join dwfolharapcom.omProduto omprodutorap");
		}


		q.append("left join dwconsolid.dwTurno ");
		q.append("left join dwconsolid.omPt ");
		q.append("left join dwfolha.dwFolhaiacs dwfolhaiac");
		q.append("left join dwfolhaiac.omProduto omprodutoiac");


		// conjuntos - novo filtro BI
		if (filtro.getCdProdutoPai() != null) {
			q.append("LEFT JOIN omproduto.omProcomestsForIdProdutomp profilho");
			q.append("LEFT JOIN profilho.omProdutoByIdProduto propai");
		}

		//Marcos Sardinha: 2017-05-31 -- estava considerando refugos cancelados
		q.appendWhere(MapQuery._NULL, "(relog.isCancelado IS NULL OR relog.isCancelado = false)", true);		
		q.appendWhere(MapQuery._AND,
				"dwconsolid.tpId = :tpId and dwconsolid.stAtivo is null ", true);
				
		q.appendWhere(
				MapQuery._AND,
				"((dwconsolid.ano * 1000) + dwconsolid.mes) BETWEEN :ami AND :amf",
				filtro.getAnoInicial() != null
						&& filtro.getMesInicial() != null
						&& filtro.getAnoFinal() != null
						&& filtro.getMesFinal() != null);
		/*
		 * Alessandre: em 29-10-14 o filtroOP pode assumir os seguintes valores
		 * 0 = ultima OP 1 = todas as ops Se o filtroOP for igual a zero, entao
		 * utilizar a ppCP que estï¿½ no filtro
		 */
		q.appendWhere(
				MapQuery._AND,
				"dwconsolid.ppCp.cdCp = :nrop",
				filtro.getCdCp() != null
						&& filtro.getCdCp().equals("") == false
						&& filtro.getFiltroOp() != null
						&& filtro.getFiltroOp() == 0);

		q.appendWhere(MapQuery._AND, "dwconsolid.dtReferencia = :data",
				filtro.getDtReferencia() != null
						&& filtro.getAnoInicial() == null);

		q.appendWhere(MapQuery._AND,
				"dwconsolid.dwTurno.idTurno = :idTurno",
				filtro.getDwTurno() != null);

		q.appendWhere(MapQuery._AND, "dwconsolid.dwTurno.idTurno <> 1",
				filtro.getDwTurno() == null);

		q.appendWhere(MapQuery._AND, "dwconsolid.omPt.cdPt = :ompt",
				filtro.getOmPt() != null);
		q.appendWhere(
				MapQuery._AND,
				"exists (select ompt from OmPt ompt join ompt.omObjs omobj where omobj.omGtByIdGt.idGt = :idGt and ompt = dwconsolid.omPt)",
				filtro.getOmGt() != null);
		
		q.appendWhere(MapQuery._AND,
				"ppcpprodutos.omProduto.idProduto = :idProduto",
				filtro.getOmProduto() != null
						&& filtro.getOmProduto().getIdProduto() > 0);
		q.appendWhere(
				MapQuery._AND,
				"dwconsolid.dtReferencia between :dti and :dtf",
				filtro.getDtReferenciaInicial() != null
						&& filtro.getDtReferenciaFinal() != null
						&& filtro.getAnoInicial() == null);
		q.appendWhere(MapQuery._AND, "dwconsolid.dthrIhora >= :dthrIhora",
				filtro.getDthrIhora() != null);
		q.appendWhere(MapQuery._AND, "dwconsolid.dthrFhora <= :dthrFhora",
				filtro.getDthrFhora() != null);
		q.appendWhere(
				MapQuery._AND,
				"( omprodutoiac.cdProduto = :cdproduto or omprodutorap.cdProduto = :cdproduto ) ",
				filtro.getOmProduto() != null
						&& filtro.getOmProduto().getCdProduto() != null
						&& filtro.getOmProduto().getCdProduto().equals("") == false);

		// novo filtro BI
		q.appendWhere(MapQuery._AND, "dwfolharap.dwRap.cdRap = :cdmol",
				(filtro.getDwRap() != null));
		q.appendWhere(MapQuery._AND,
				"grpmol.dwGrupoFerramenta.cdGrupoFerramenta = :cdgrpmol",
				(filtro.getCdGrupoFerramenta() != null));
		q.appendWhere(MapQuery._AND, "propai.cdProduto = :cdProdutoPai",
				(filtro.getCdProdutoPai() != null));

		//q.append(" GROUP BY  dwconsolre.idConsolre,  dwtrefugo.idTrefugo,  dwtrefugo.cdTrefugo, dwtrefugo.dsTrefugo");

		// preenchimento dos parametros
		q.defineParametro("idTurno", filtro.getDwTurno() != null ? filtro
				.getDwTurno().getIdTurno() : 0);

		if (filtro.getOmPt() != null && filtro.getOmPt().getCdPt() == null) {
			OmPt ompt = getDao().findById(OmPt.class,
					filtro.getOmPt().getIdPt(), false);
			filtro.getOmPt().setCdPt(ompt.getCdPt());
		}

		if (filtro.getOmPt() != null)
			q.defineParametro("ompt", filtro.getOmPt().getCdPt());

		q.defineParametro("idGt", filtro.getOmGt() != null ? filtro
				.getOmGt().getIdGt() : null);
		q.defineParametro("idProduto", filtro.getOmProduto() != null
				&& filtro.getOmProduto().getIdProduto() > 0 ? filtro
				.getOmProduto().getIdProduto() : null);
		q.defineParametro(
				"cdproduto",
				filtro.getOmProduto() != null
						&& filtro.getOmProduto().getCdProduto() != null
						&& filtro.getOmProduto().getCdProduto().equals("") == false ? filtro
						.getOmProduto().getCdProduto() : null);
		q.defineParametroData(
				"data",
				filtro.getDtReferencia() != null ? DataHoraRN
						.getDataSemHora(filtro.getDtReferencia()) : null);
		q.defineParametroData(
				"dti",
				filtro.getDtReferenciaInicial() != null ? DataHoraRN
						.getDataSemHora(filtro.getDtReferenciaInicial()) : null);
		q.defineParametroData(
				"dtf",
				filtro.getDtReferenciaFinal() != null ? DataHoraRN
						.getDataSemHora(filtro.getDtReferenciaFinal()) : null);

		if (filtro.getDthrIhora() != null) {
			q.defineParametroTimestamp("dthrIhora", filtro.getDthrIhora());
		}

		if (filtro.getDthrFhora() != null) {
			q.defineParametroTimestamp("dthrFhora", filtro.getDthrFhora());
		}

		if (filtro.getTpId() == null) {
			filtro.setTpId(DwConsolidTemplate.TpId.TURNO.getValue());
		}

		// mudei o periodo de consolidaÃ§Ã£o pra TURNO pois ainda nÃ£o
		// existe registros para ACUMULADO
		if ((filtro.getTpId() == DetalheMonitorizacaoPTInsertRN. PERIODO_CONSOLIDACAO_ACUMULADO)
				|| (filtro.getTpId() == DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP) ) {
			q.defineParametro("tpId", DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_ACUMULADO);
		} if (filtro.getTpId().equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_MES)) {
			q.defineParametro("tpId", DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO);
		} else {
			q.defineParametro("tpId", filtro.getTpId());
		}

		// Alessandre: em 29-10-14 reativei o trecho abaixo posi agora existe o
		// filtroOP que se for 0 (ver comentario anterior) passar a OP
		if (filtro.getCdCp() != null && filtro.getCdCp().equals("") == false) {
			q.defineParametro("nrop", filtro.getCdCp());
		}

		if (filtro.getAnoInicial() != null && filtro.getMesInicial() != null
				&& filtro.getAnoFinal() != null && filtro.getMesFinal() != null) {
			q.defineParametro("ami", (filtro.getAnoInicial() * 1000)
					+ filtro.getMesInicial());
			q.defineParametro("amf",
					(filtro.getAnoFinal() * 1000) + filtro.getMesFinal());
		}

		// novo filtro BI
		if (filtro.getDwRap() != null) {
			q.defineParametro("cdmol", filtro.getDwRap().getCdRap());
		}
		if (filtro.getCdGrupoFerramenta() != null) {
			q.defineParametro("cdgrpmol", filtro.getCdGrupoFerramenta());
		}

		if (filtro.getCdProdutoPai() != null) {
			q.defineParametro("cdProdutoPai", filtro.getCdProdutoPai());
		}

		
		List<DwConsolrelog> lista = q.list();
		List<GraficoParetoRefugosDTO> refugos = new ArrayList<GraficoParetoRefugosDTO>();
		
		HashMap<String, GraficoParetoRefugosDTO> mapRefugos = new HashMap<String, GraficoParetoRefugosDTO>();
		HashMap<String, List<OcorrenciasEvtDTO>> mapOcorrenciasPorRefugo = new HashMap<String, List<OcorrenciasEvtDTO>>();
		HashMap<String, BigDecimal> mapIndicePorRefugo = new HashMap<String, BigDecimal>();
		
		
		for (DwConsolrelog reg : lista) {			
			Long idTRefugo = reg.getDwTRefugo().getIdTrefugo();
			String cdRefugo = reg.getDwTRefugo().getCdTrefugo();
			String dsRefugo = reg.getDwTRefugo().getDsTrefugo();
			BigDecimal qtdRefAuto = (reg.getPcsAutoProducaorefugada() != null ? reg.getPcsAutoProducaorefugada() : BigDecimal.ZERO);
			BigDecimal qtdRefManual = (reg.getPcsManuProducaorefugada() != null ? reg.getPcsManuProducaorefugada() : BigDecimal.ZERO); 
            BigDecimal pBruto = (reg.getOmProduto().getGPesoBruto() != null ? reg.getOmProduto().getGPesoBruto() : BigDecimal.ZERO);
			BigDecimal qtdrefGr = BigDecimal.ZERO;              
            
			GraficoParetoRefugosDTO refugoGraf = new GraficoParetoRefugosDTO(); 

            refugoGraf = new GraficoParetoRefugosDTO();
            
            refugoGraf.setIdTRefugo(idTRefugo);
            refugoGraf.setCdRefugo(cdRefugo);
            refugoGraf.setDsRefugo(dsRefugo);
            
            BigDecimal qtdref = BigDecimal.ZERO;                
            qtdref = AritmeticaUtil.somar(qtdref, qtdRefAuto);
            qtdref = AritmeticaUtil.somar(qtdref, qtdRefManual);

            // producao refugada em gramas
            qtdrefGr = AritmeticaUtil.multiplicar(qtdref, pBruto);
            refugoGraf.setQtdRefugada(qtdref.doubleValue());
            refugoGraf.setQtdRefugadaKg( qtdrefGr.divide(new BigDecimal(1000), BigDecimal.ROUND_HALF_EVEN).doubleValue() );             
            refugoGraf.setQtdRefugadaTon( qtdrefGr.divide(new BigDecimal(1000000), BigDecimal.ROUND_HALF_EVEN).doubleValue() );
			
			if(! mapRefugos.containsKey(cdRefugo)){
			    
				BigDecimal qtdRefMap = mapIndicePorRefugo.get(cdRefugo);
				if(qtdRefMap == null){
					qtdRefMap = qtdref;
					mapIndicePorRefugo.put(cdRefugo, qtdRefMap);
				}
								
				double indiceRefugo = FormulasInjet.calcularIndiceRefugo(qtdref, totalRefugado).doubleValue();
				refugoGraf.setIndiceRefugo(indiceRefugo);

				
				//PEGA MAIOR E MENOR DATA/HORA DE OCORR�NCIA DE REFUGO
				menorDthrOcor = getMenorDthrOcor(reg.getDthrRefugo(), menorDthrOcor);
				maiorDthrOcor = getMaiorDthrOcor(reg.getDthrRefugo(), maiorDthrOcor);
				
				List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorRefugo.get(cdRefugo);
				if(listaOcoDTO == null)
				{
					listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
					OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
					ocoDTO.setIdEvt(idTRefugo);
					ocoDTO.setDthrIni(reg.getDthrRefugo()); 
					ocoDTO.setDthrFim(reg.getDthrRefugo());
					
					int duracaoEvt = 0;
					ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
					ocoDTO.setMsDtHrIni(reg.getMsDthrrefugo());
					ocoDTO.setMsDtHrFim(reg.getMsDthrrefugo());
					
					listaOcoDTO.add(ocoDTO);
					mapOcorrenciasPorRefugo.put(cdRefugo, listaOcoDTO);					}
				else
				{
					OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
					ocoDTO.setIdEvt(idTRefugo);
					ocoDTO.setDthrIni(reg.getDthrRefugo()); 
					ocoDTO.setDthrFim(reg.getDthrRefugo());
					
					int duracaoEvt = 0;
					
					ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
					ocoDTO.setMsDtHrIni(reg.getMsDthrrefugo());
					ocoDTO.setMsDtHrFim(reg.getMsDthrrefugo());
					
					listaOcoDTO.add(ocoDTO);
				}
				
				mapRefugos.put(cdRefugo, refugoGraf);
				
				refugos.add(refugoGraf);
				
			}
			else
			{
                mapRefugos.get(cdRefugo).setQtdRefugada(mapRefugos.get(cdRefugo).getQtdRefugada() + refugoGraf.getQtdRefugada());
                mapRefugos.get(cdRefugo).setQtdRefugadaKg(mapRefugos.get(cdRefugo).getQtdRefugadaKg() + refugoGraf.getQtdRefugadaKg());             
                mapRefugos.get(cdRefugo).setQtdRefugadaTon(mapRefugos.get(cdRefugo).getQtdRefugadaTon() + refugoGraf.getQtdRefugadaTon());
                
				
				BigDecimal qtdRefMap = new BigDecimal(mapRefugos.get(cdRefugo).getQtdRefugada());
				mapIndicePorRefugo.put(cdRefugo, qtdRefMap);

				double indiceRefugo = FormulasInjet.calcularIndiceRefugo(qtdRefMap, totalRefugado).doubleValue();
				mapRefugos.get(cdRefugo).setIndiceRefugo(indiceRefugo);
				
				
    			List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorRefugo.get(cdRefugo);
    			if(listaOcoDTO != null){
    				OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
    				ocoDTO.setIdEvt(idTRefugo);  
    				ocoDTO.setDthrIni(reg.getDthrRefugo()); 
    				ocoDTO.setDthrFim(reg.getDthrRefugo());
    				
    				int duracaoEvt = 0;						
    				ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
    				
    				ocoDTO.setMsDtHrIni(reg.getMsDthrrefugo());
    				ocoDTO.setMsDtHrFim(reg.getMsDthrrefugo());
    				
    				listaOcoDTO.add(ocoDTO);
				}
			}
			
		}
		
		
		GrafTendenciaUtils algoritmoGraf = null;
		
		//MONTA O GRAFICO - NESTE MOMENTO É DEFINIDO O INTERVALO DE CORES
		if(menorDthrOcor != null && maiorDthrOcor != null){
			algoritmoGraf = new GrafTendenciaUtils(menorDthrOcor, maiorDthrOcor);
		}
		
		GraficosParetoRefugosDTO retorno = new GraficosParetoRefugosDTO();
		retorno.setRefugos(refugos);
		DatasDTO datas = new DatasDTO();
		datas.setDtIAtendimento(DataHoraRN.getDataHoraAtual());
		datas.setDtFAtendimento(DataHoraRN.getDataHoraAtual());
		retorno.setCorAmarela(datas);
		retorno.setCorLaranja(datas);
		retorno.setCorVerde(datas);
		retorno.setCorVermelho(datas);
		
		if (totalRefugado.compareTo(BigDecimal.ZERO) == 1)
		{
			defineCoresLegendaEBarra(algoritmoGraf, retorno, mapRefugos, mapOcorrenciasPorRefugo);
		}
		
		log.mostrarAvaliacaoCompleta();
		
		return retorno;
	}
	
	
	
	private void defineCoresLegendaEBarra(GrafTendenciaUtils algoritmoGraf, GraficosParetoRefugosDTO retorno, 
			HashMap<String, GraficoParetoRefugosDTO> mapRefugos, HashMap<String, List<OcorrenciasEvtDTO>> mapOcorrenciasPorRefugo ){
		
		if(algoritmoGraf != null && algoritmoGraf.getIntervaloGrafTend() != null && algoritmoGraf.getIntervaloGrafTend().isEmpty() == false){
			for(IntervaloGrafTendenciaRefugoParada intervalo : algoritmoGraf.getIntervaloGrafTend()){
				if(intervalo.getCorIntervalo().equals(Color.YELLOW)){
					DatasDTO datasAmarelo = new DatasDTO();
					datasAmarelo.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
					datasAmarelo.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
					datasAmarelo.setCorHexa(Cor.transformarParaCodigoHexadecimal(Color.YELLOW));
					retorno.setCorAmarela(datasAmarelo);
				}
				if(intervalo.getCorIntervalo().equals(Color.ORANGE)){
					DatasDTO datasLaranja = new DatasDTO();
					datasLaranja.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
					datasLaranja.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
					datasLaranja.setCorHexa(Cor.transformarParaCodigoHexadecimal(Color.ORANGE));
					retorno.setCorLaranja(datasLaranja);
				}
				if(intervalo.getCorIntervalo().equals(Color.GREEN)){
					DatasDTO datasVerde = new DatasDTO();
					datasVerde.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
					datasVerde.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
					datasVerde.setCorHexa(Cor.transformarParaCodigoHexadecimal(Color.GREEN));
					retorno.setCorVerde(datasVerde);
				}
				if(intervalo.getCorIntervalo().equals(Color.RED)){
					DatasDTO datasVermelho = new DatasDTO();
					datasVermelho.setDtIAtendimento(intervalo.getIntervaloDtHrIni());
					datasVermelho.setDtFAtendimento(intervalo.getIntervaloDtHrFim());
					datasVermelho.setCorHexa(Cor.transformarParaCodigoHexadecimal(Color.RED));
					retorno.setCorVermelho(datasVermelho);
				}
			}
		}
		
		List<GraficoParetoRefugosDTO> listaRefugos = new ArrayList<GraficoParetoRefugosDTO>();
		
		Set<String> cdsRefugos = mapRefugos.keySet();
		for(String cdRefugo : cdsRefugos){
			GraficoParetoRefugosDTO refugoGraf = mapRefugos.get(cdRefugo);
			List<OcorrenciasEvtDTO> listaOco = mapOcorrenciasPorRefugo.get(cdRefugo);
			Paint paint = algoritmoGraf.corBarraTendencia(refugoGraf.getIdTRefugo(), listaOco);
			Color cor = (Color) paint;
			refugoGraf.setCorBarra(String.valueOf(cor.getRGB()));
			refugoGraf.setCorHexa(Cor.transformarParaCodigoHexadecimal(cor.getRGB()));
			listaRefugos.add(refugoGraf);
		}
		
		retorno.setRefugos(listaRefugos);
		
	}
	
	
	public GraficosParetoRefugosDTO getMaiorRefugoWM(List<Object> listaIdsCns)	{
		BigDecimal totalRefugado = BigDecimal.ZERO;
		
		Date menorDthrOcor = null;
		Date maiorDthrOcor = null;
		
		MapQuery q = new MapQuery(getDaoSession());

		q.append("SELECT relog ");
		q.append("FROM DwConsolid dwconsolid");
		q.append("JOIN dwconsolid.dwConsols dwconsol");

		q.append("JOIN dwconsol.dwConsolres dwconsolre");
		q.append("JOIN dwconsolre.dwTRefugo dwtrefugo");
		
		q.append("JOIN dwconsolre.dwConsolreocos reoco");
		q.append("JOIN reoco.dwConsolrelog relog");
		q.append("JOIN relog.omProduto omproduto");
		 
		
		q.append("left join dwconsolid.ppCp ppcp");
		
		q.append("left join dwconsolid.dwFolha dwfolha");


		q.append("left join dwconsolid.dwTurno ");
		q.append("left join dwconsolid.omPt ");
		q.append("left join dwfolha.dwFolhaiacs dwfolhaiac");
		q.append("left join dwfolhaiac.omProduto omprodutoiac");


		q.append("WHERE (relog.isCancelado IS NULL OR relog.isCancelado = false)");		 
		q.append(" AND dwconsolid.idConsolid in (:listaIds) "); 
		
		// preenchimento dos parametros
		q.defineListaParametro("listaIds", listaIdsCns);
		
		List<DwConsolrelog> lista = q.list();
		List<GraficoParetoRefugosDTO> refugos = new ArrayList<GraficoParetoRefugosDTO>();
		
		HashMap<String, GraficoParetoRefugosDTO> mapRefugos = new HashMap<String, GraficoParetoRefugosDTO>();
		HashMap<String, List<OcorrenciasEvtDTO>> mapOcorrenciasPorRefugo = new HashMap<String, List<OcorrenciasEvtDTO>>();
		HashMap<String, BigDecimal> mapIndicePorRefugo = new HashMap<String, BigDecimal>();
		
		
		
		// total refugado
		for (DwConsolrelog reg : lista) {			
			BigDecimal qtdRefAuto = (reg.getPcsAutoProducaorefugada() != null ? reg.getPcsAutoProducaorefugada() : BigDecimal.ZERO);
			BigDecimal qtdRefManual = (reg.getPcsManuProducaorefugada() != null ? reg.getPcsManuProducaorefugada() : BigDecimal.ZERO); 
            
            
            BigDecimal qtdref = BigDecimal.ZERO;                
            qtdref = AritmeticaUtil.somar(qtdref, qtdRefAuto);
            qtdref = AritmeticaUtil.somar(qtdref, qtdRefManual);

            totalRefugado = AritmeticaUtil.somar(totalRefugado, qtdref);
		}
		
		
		
		for (DwConsolrelog reg : lista) {			
			Long idTRefugo = reg.getDwTRefugo().getIdTrefugo();
			String cdRefugo = reg.getDwTRefugo().getCdTrefugo();
			String dsRefugo = reg.getDwTRefugo().getDsTrefugo();
			BigDecimal qtdRefAuto = (reg.getPcsAutoProducaorefugada() != null ? reg.getPcsAutoProducaorefugada() : BigDecimal.ZERO);
			BigDecimal qtdRefManual = (reg.getPcsManuProducaorefugada() != null ? reg.getPcsManuProducaorefugada() : BigDecimal.ZERO); 
            BigDecimal pBruto = (reg.getOmProduto().getGPesoBruto() != null ? reg.getOmProduto().getGPesoBruto() : BigDecimal.ZERO);
			BigDecimal qtdrefGr = BigDecimal.ZERO;              
            
			GraficoParetoRefugosDTO refugoGraf = new GraficoParetoRefugosDTO(); 

            refugoGraf = new GraficoParetoRefugosDTO();
            
            refugoGraf.setIdTRefugo(idTRefugo);
            refugoGraf.setCdRefugo(cdRefugo);
            refugoGraf.setDsRefugo(dsRefugo);
            
            BigDecimal qtdref = BigDecimal.ZERO;                
            qtdref = AritmeticaUtil.somar(qtdref, qtdRefAuto);
            qtdref = AritmeticaUtil.somar(qtdref, qtdRefManual);

            // producao refugada em gramas
            qtdrefGr = AritmeticaUtil.multiplicar(qtdref, pBruto);
            refugoGraf.setQtdRefugada(qtdref.doubleValue());
            refugoGraf.setQtdRefugadaKg( qtdrefGr.divide(new BigDecimal(1000), BigDecimal.ROUND_HALF_EVEN).doubleValue() );             
            refugoGraf.setQtdRefugadaTon( qtdrefGr.divide(new BigDecimal(1000000), BigDecimal.ROUND_HALF_EVEN).doubleValue() );
			
			if(! mapRefugos.containsKey(cdRefugo)){
			    
				BigDecimal qtdRefMap = mapIndicePorRefugo.get(cdRefugo);
				if(qtdRefMap == null){
					qtdRefMap = qtdref;
					mapIndicePorRefugo.put(cdRefugo, qtdRefMap);
				}
								
				double indiceRefugo = FormulasInjet.calcularIndiceRefugo(qtdref, totalRefugado).doubleValue();
				refugoGraf.setIndiceRefugo(indiceRefugo);

				
				//PEGA MAIOR E MENOR DATA/HORA DE OCORR�NCIA DE REFUGO
				menorDthrOcor = getMenorDthrOcor(reg.getDthrRefugo(), menorDthrOcor);
				maiorDthrOcor = getMaiorDthrOcor(reg.getDthrRefugo(), maiorDthrOcor);
				
				List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorRefugo.get(cdRefugo);
				if(listaOcoDTO == null)
				{
					listaOcoDTO = new ArrayList<OcorrenciasEvtDTO>();
					OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
					ocoDTO.setIdEvt(idTRefugo);
					ocoDTO.setDthrIni(reg.getDthrRefugo()); 
					ocoDTO.setDthrFim(reg.getDthrRefugo());
					
					int duracaoEvt = 0;
					ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
					ocoDTO.setMsDtHrIni(reg.getMsDthrrefugo());
					ocoDTO.setMsDtHrFim(reg.getMsDthrrefugo());
					
					listaOcoDTO.add(ocoDTO);
					mapOcorrenciasPorRefugo.put(cdRefugo, listaOcoDTO);					}
				else
				{
					OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
					ocoDTO.setIdEvt(idTRefugo);
					ocoDTO.setDthrIni(reg.getDthrRefugo()); 
					ocoDTO.setDthrFim(reg.getDthrRefugo());
					
					int duracaoEvt = 0;
					
					ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
					ocoDTO.setMsDtHrIni(reg.getMsDthrrefugo());
					ocoDTO.setMsDtHrFim(reg.getMsDthrrefugo());
					
					listaOcoDTO.add(ocoDTO);
				}
				
				mapRefugos.put(cdRefugo, refugoGraf);
				
				refugos.add(refugoGraf);
				
			}
			else
			{
                mapRefugos.get(cdRefugo).setQtdRefugada(mapRefugos.get(cdRefugo).getQtdRefugada() + refugoGraf.getQtdRefugada());
                mapRefugos.get(cdRefugo).setQtdRefugadaKg(mapRefugos.get(cdRefugo).getQtdRefugadaKg() + refugoGraf.getQtdRefugadaKg());             
                mapRefugos.get(cdRefugo).setQtdRefugadaTon(mapRefugos.get(cdRefugo).getQtdRefugadaTon() + refugoGraf.getQtdRefugadaTon());
                
				
				BigDecimal qtdRefMap = new BigDecimal(mapRefugos.get(cdRefugo).getQtdRefugada());
				mapIndicePorRefugo.put(cdRefugo, qtdRefMap);

				double indiceRefugo = FormulasInjet.calcularIndiceRefugo(qtdRefMap, totalRefugado).doubleValue();
				mapRefugos.get(cdRefugo).setIndiceRefugo(indiceRefugo);
				
				
    			List<OcorrenciasEvtDTO> listaOcoDTO = mapOcorrenciasPorRefugo.get(cdRefugo);
    			if(listaOcoDTO != null){
    				OcorrenciasEvtDTO ocoDTO = new OcorrenciasEvtDTO();
    				ocoDTO.setIdEvt(idTRefugo);  
    				ocoDTO.setDthrIni(reg.getDthrRefugo()); 
    				ocoDTO.setDthrFim(reg.getDthrRefugo());
    				
    				int duracaoEvt = 0;						
    				ocoDTO.setDuracaoEvt(new BigDecimal(duracaoEvt));
    				
    				ocoDTO.setMsDtHrIni(reg.getMsDthrrefugo());
    				ocoDTO.setMsDtHrFim(reg.getMsDthrrefugo());
    				
    				listaOcoDTO.add(ocoDTO);
				}
			}
			
		}
		
		
		GrafTendenciaUtils algoritmoGraf = null;
		
		//MONTA O GRAFICO - NESTE MOMENTO É DEFINIDO O INTERVALO DE CORES
		if(menorDthrOcor != null && maiorDthrOcor != null){
			algoritmoGraf = new GrafTendenciaUtils(menorDthrOcor, maiorDthrOcor);
		}
		
		GraficosParetoRefugosDTO retorno = new GraficosParetoRefugosDTO();
		retorno.setRefugos(refugos);
		DatasDTO datas = new DatasDTO();
		datas.setDtIAtendimento(DataHoraRN.getDataHoraAtual());
		datas.setDtFAtendimento(DataHoraRN.getDataHoraAtual());
		retorno.setCorAmarela(datas);
		retorno.setCorLaranja(datas);
		retorno.setCorVerde(datas);
		retorno.setCorVermelho(datas);
		
		if (totalRefugado.compareTo(BigDecimal.ZERO) == 1)
		{
			defineCoresLegendaEBarra(algoritmoGraf, retorno, mapRefugos, mapOcorrenciasPorRefugo);
		}
 		
		Collections.sort(retorno.getRefugos(), comparaPorQtd);
		
		return retorno;
	}
	
	public static final Comparator<GraficoParetoRefugosDTO> comparaPorQtd = new Comparator<GraficoParetoRefugosDTO>() {
		@Override
        public int compare(GraficoParetoRefugosDTO o1, GraficoParetoRefugosDTO o2) {
			return o1.getQtdRefugada().compareTo(o2.getQtdRefugada()) * -1;
        }
    };
	
	
}
