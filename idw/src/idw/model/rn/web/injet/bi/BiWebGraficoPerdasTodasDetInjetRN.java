package idw.model.rn.web.injet.bi;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.SQLQuery;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.monitorizacao.injet.ConfiguracoesInjetRN;
import idw.model.rn.web.injet.bi.BiWebInjetRN.UnidadeExibicaoOuOrdenacaoQtdBI;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.webservices.rest.BiResource;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiFiltroDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiParetoPerdasTodasDetDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiParetoPerdasTodasDetalheDTO;
import ms.util.ConversaoTipos;

public class BiWebGraficoPerdasTodasDetInjetRN extends AbstractRN<DAOGenericoInjet>  {
	
	private class PerdasTodasDetProduto {
		String cdProduto;
		String dsProduto;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
		BigDecimal prevUB = BigDecimal.ZERO;
		BigDecimal prevGr = BigDecimal.ZERO;
		BigDecimal boasUB = BigDecimal.ZERO;
		BigDecimal boasGr = BigDecimal.ZERO;
		BigDecimal efiRea = BigDecimal.ZERO;
	}

	
    
    private static final Comparator<PerdasTodasDetProduto> comparaPerdasTodasProduto = new Comparator<PerdasTodasDetProduto>() {
		@Override
        public int compare(PerdasTodasDetProduto o1, PerdasTodasDetProduto o2) {
			return o1.perdaOrdenacao.compareTo(o2.perdaOrdenacao) * -1;
        }
    };	    
	    
    
	public BiWebGraficoPerdasTodasDetInjetRN() {
		this(new DAOGenericoInjet());
	}
	
	public BiWebGraficoPerdasTodasDetInjetRN(DAOGenericoInjet dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenericoInjet();
		}
		this.setDao(dao);
	}

	private String getConsultaPerdasTodas(BiFiltroDTO filtroBI, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		String strSQL;

		strSQL = "";
		strSQL = strSQL.concat("SELECT a.cdproduto, f.dsproduto, ");
		strSQL = strSQL.concat("       SUM(a.qtdritmo + a.qtdPCI + a.qtdperdasparCP + a.prodrefugada) as qtdperdasUB, ");
		strSQL = strSQL.concat("       SUM(a.qtdritmoGr + a.qtdPCIGr + a.qtdperdasparCPGr + a.prodrefugadaGr) as qtdperdasGr, ");
		strSQL = strSQL.concat("       SUM((a.qtdritmoGr + a.qtdPCIGr + a.qtdperdasparCPGr + a.prodrefugadaGr) * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdperdasUM, ");
		strSQL = strSQL.concat("       SUM(a.prodprev) as prodprevUB, ");
		strSQL = strSQL.concat("       SUM(a.prodprevGr) as prodprevGr, ");
		strSQL = strSQL.concat("       SUM(a.prodbruta - a.prodrefugada) as prodliqUB, ");
		strSQL = strSQL.concat("       SUM(a.prodbrutaGr - a.prodrefugadaGr) as prodliqGr ");
				
		// tabelas
		strSQL = strSQL.concat("  FROM viewBIDtRefProdutos a ");
		strSQL = strSQL.concat("  JOIN ijtbpro f ON (f.cdproduto = a.cdproduto) ");

		// tabelas relacionados a maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");		
		} else {			
			strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC cm ON (cm.cdinjetora = a.cdinjetora) ");
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");	
		}

		
		// filtros
		strSQL = strSQL.concat(" WHERE a.dtturno BETWEEN :dtini AND :dtfim ");
		
		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cdturno = :cdturno ");
		}		

		
		if (! cdPtSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND a.cdinjestendido = :cdptSelecaoPareto ");
		}
		if (! cdProdutoSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND a.cdproduto = :cdprodutoSelecaoPareto ");
		}		
		
		
		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND a.cdinjestendido = :cdpt ");	
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  AND gm.cdgrpinj = :cdgt ");		
			} else {			
				strSQL = strSQL.concat("  AND cm.classe = :cdclasse ");
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND a.cdmolestendido = :cdrap ");	
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");	
		}
		
		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat("  AND a.cdproduto = :cdproduto ");	
		}

		strSQL = strSQL.concat(" GROUP BY a.cdproduto, f.dsproduto ");
		strSQL = strSQL.concat(" HAVING SUM(a.qtdritmo) <> 0 ");
				
		return strSQL;
	}
	
	private SQLQuery setFiltrosNaQuery(SQLQuery q, BiFiltroDTO filtroBI, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		q.setTimestamp("dthrini", filtroBI.getDtIniDt());
		q.setTimestamp("dthrfim", filtroBI.getDtFimDt());
		
		if (! cdPtSelecaoPareto.equals("")) {
			q.setString("cdptSelecaoPareto", cdPtSelecaoPareto);
		}
		if (! cdProdutoSelecaoPareto.equals("")) {
			q.setString("cdprodutoSelecaoPareto", cdProdutoSelecaoPareto);
		}
		
		
		if (!filtroBI.getCdTurno().equals("")) {
			q.setString("cdturno", filtroBI.getCdTurno());
		}
				
		if (!filtroBI.getCdPt().equals("")) {
			q.setString("cdpt", filtroBI.getCdPt());
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				q.setString("cdgt", filtroBI.getCdGt());
			} else {			
				q.setString("cdclasse", filtroBI.getCdClasseMaquina());
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			q.setString("cdrap", filtroBI.getCdRap());
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			q.setString("cdgrprap", filtroBI.getCdGrpRap());
		}
		
		if (!filtroBI.getCdProduto().equals("")) {
			q.setString("cdproduto", filtroBI.getCdProduto());
		}
		
		return q;
	}
		

	@SuppressWarnings("unchecked")
	public BiParetoPerdasTodasDetalheDTO getParetoPerdasTodasDet(BiFiltroDTO filtroBIDet, UnidadeExibicaoOuOrdenacaoQtdBI ordenacao, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		BiFiltroDTO filtroBI = new BiFiltroDTO();
		BiWebInjetRN biRN = new BiWebInjetRN(getDao(), BiResource.FORMATO_DATA, BiResource.FORMATO_DATA_HORA);
		filtroBI = biRN.filtroBiTransformado(filtroBIDet);
		
		BiParetoPerdasTodasDetalheDTO resumo = new BiParetoPerdasTodasDetalheDTO();
		resumo.setDetalhes(new ArrayList<BiParetoPerdasTodasDetDTO>());
		BigDecimal totalCusto = BigDecimal.ZERO;
		BigDecimal totalGanho = BigDecimal.ZERO;
		BigDecimal totalGanhoGr = BigDecimal.ZERO;
		BigDecimal totalPerda = BigDecimal.ZERO;
		BigDecimal totalPerdaGr = BigDecimal.ZERO;
		
		List<PerdasTodasDetProduto> perdas = new ArrayList<PerdasTodasDetProduto>();
	
		
		int _cdproduto = 0;
		int _dsproduto = _cdproduto + 1;
		
		int _perdasUB = _dsproduto + 1;
		int _perdasGr = _perdasUB + 1;
		int _perdasUM = _perdasGr + 1;
		
		int _prevUB = _perdasUM + 1;
		int _prevGr = _prevUB + 1;
		int _boasUB = _prevGr + 1;
		int _boasGr = _boasUB + 1;
		
		
		// tempos
		String strSQL = "";		
		List<Object>  lista = new ArrayList<Object>();
		strSQL = getConsultaPerdasTodas(filtroBI, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosNaQuery(q, filtroBI, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		
		lista = q.list();		
		for (Object reg : lista) {
			PerdasTodasDetProduto registro = new PerdasTodasDetProduto();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			registro.cdProduto = (String) registroLido[_cdproduto];
			registro.dsProduto = (String) registroLido[_dsproduto];
			registro.perdaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasUB]);
			registro.perdaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasGr]);
			registro.perdaUM = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasUM]);

			registro.perdaOrdenacao = getValorPerda(ordenacao, registro);
			
			registro.prevUB = ConversaoTipos.converterParaBigDecimal(registroLido[_prevUB]);
			registro.prevGr = ConversaoTipos.converterParaBigDecimal(registroLido[_prevGr]);
			registro.boasUB = ConversaoTipos.converterParaBigDecimal(registroLido[_boasUB]);
			registro.boasGr = ConversaoTipos.converterParaBigDecimal(registroLido[_boasGr]);
			
			registro.efiRea = new BigDecimal(FormulasInjet.calcularEficienciaRealizacao(registro.boasUB, registro.prevUB));
			
			perdas.add(registro);
			
			totalCusto = AritmeticaUtil.somar(totalCusto, registro.perdaUM);
			if (registro.perdaUB.doubleValue() < 0) {
				totalGanho = AritmeticaUtil.somar(totalGanho, registro.perdaUB);
				totalGanhoGr = AritmeticaUtil.somar(totalGanho, registro.perdaGr);
			} else {
				totalPerda = AritmeticaUtil.somar(totalPerda, registro.perdaUB);
				totalPerdaGr = AritmeticaUtil.somar(totalPerdaGr, registro.perdaGr);				
			}	
					
			
		}
		
		
		// Ordenacao 
		Collections.sort(perdas, comparaPerdasTodasProduto);
		
		
		for (PerdasTodasDetProduto perda : perdas) {
			BiParetoPerdasTodasDetDTO linhaDetPerdas = new BiParetoPerdasTodasDetDTO();
			linhaDetPerdas.setProduto(perda.cdProduto + " (" + perda.dsProduto  + ")");
			linhaDetPerdas.setCdProduto(perda.cdProduto);

			linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perda.perdaUB));
			linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perda.perdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
			linhaDetPerdas.setPerdaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perda.perdaGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
			linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perda.perdaUM, 2));							

			linhaDetPerdas.setPrevUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perda.prevUB));
			linhaDetPerdas.setPrevKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perda.prevGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
			linhaDetPerdas.setPrevTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perda.prevGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));

			linhaDetPerdas.setBoasUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perda.boasUB));
			linhaDetPerdas.setBoasKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perda.boasGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
			linhaDetPerdas.setBoasTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perda.boasGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));

			linhaDetPerdas.setEfiRea(ConversaoTipos.converteParaString(perda.efiRea, 2));
			
			// adiciona linha 
			resumo.getDetalhes().add(linhaDetPerdas);		
		}
		
		BigDecimal saldoUB = AritmeticaUtil.somar(totalGanho, totalPerda);
		BigDecimal saldoGr = AritmeticaUtil.somar(totalGanhoGr, totalPerdaGr);
		
		resumo.setTotalCusto(ConversaoTipos.converteParaString(totalCusto, 2));
		resumo.setTotalGanhoUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(totalGanho));
		resumo.setTotalGanhoKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(totalGanhoGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
		resumo.setTotalGanhoTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(totalGanhoGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
		resumo.setTotalPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(totalPerda));
		resumo.setTotalPerdaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(totalPerdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
		resumo.setTotalPerdaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(totalPerdaGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
		resumo.setTotalSaldoUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(saldoUB));
		resumo.setTotalSaldoKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(saldoGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
		resumo.setTotalSaldoTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(saldoGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
		
		return resumo;		
	}


	private BigDecimal getValorPerda(UnidadeExibicaoOuOrdenacaoQtdBI ordenacao, PerdasTodasDetProduto registro) {
		BigDecimal valor = BigDecimal.ZERO;
		
		if (ordenacao == UnidadeExibicaoOuOrdenacaoQtdBI.QTD_PARETO_PERDAS_BI_EM_UB) {
			valor = registro.perdaUB;
		} else {
			if (ordenacao == UnidadeExibicaoOuOrdenacaoQtdBI.QTD_PARETO_PERDAS_BI_EM_UM) {
				valor = registro.perdaUM;	
			}  else {
				valor = registro.perdaGr;
			}
		}
		
		return valor;		
	}
	
}
