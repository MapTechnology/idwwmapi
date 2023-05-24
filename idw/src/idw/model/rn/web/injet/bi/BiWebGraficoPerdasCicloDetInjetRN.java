package idw.model.rn.web.injet.bi;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiParetoPerdasCicloDetDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiParetoPerdasCicloDetalheDTO;
import ms.util.ConversaoTipos;

public class BiWebGraficoPerdasCicloDetInjetRN extends AbstractRN<DAOGenericoInjet> {

	
	private static final String COR_CELULA_SEM_COR = "";
	private static final String COR_CELULA_PERDA_CICLO_SUB_TOTAL_MOLDE = "#f7c7bd";
	private static final String COR_CELULA_PERDA_CICLO_SUB_TOTAL_MAQUINA = "#fddcb9";
	private static final String COR_CELULA_PERDA_CICLO_SUB_TOTAL_PRODUTO = "#f7c7bd";
	
	private static final String TEXTO_CELULA_PERDA_CICLO_SUB_TOTAL_MOLDE = "SALDO DA FERRAMENTA";
	private static final String TEXTO_CELULA_PERDA_CICLO_SUB_TOTAL_MAQUINA = "SALDO DO PT";
	private static final String TEXTO_CELULA_PERDA_CICLO_SUB_TOTAL_PRODUTO = "SALDO DO PRODUTO";
	
	private class PerdasCiclosDetProduto {
		String cdPt;
		String cdIdentificacaoPt;
		String cdFerramenta;
		String cdEstrutura;
		BigDecimal cicloPadrao = BigDecimal.ZERO;
		String cicloPadraoStr;
		String cdProduto;
		String dsProduto;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
	}

	
	private class PerdasCiclosMaqDetProdutoTempos {
		String cdPt;
		String cdFerramenta;
		String cdEstrutura;
		BigDecimal cicloPadrao = BigDecimal.ZERO;
		String cicloPadraoStr;
		BigDecimal tmpCicNormal = BigDecimal.ZERO;
		BigDecimal qtdCicNormal = BigDecimal.ZERO;
		BigDecimal cicloMedio = BigDecimal.ZERO;		
	}
		
	private class PerdasCiclosMaqDetFerramentaEstrutura {
		String cdEstrutura;
		String cicloPadraoStr;
		BigDecimal cicloPadrao = BigDecimal.ZERO;
		BigDecimal cicloMedio = BigDecimal.ZERO;
		BigDecimal tmpCicNormal = BigDecimal.ZERO;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;		
		Map<String, PerdasCiclosDetProduto> produtos = new HashMap<String, PerdasCiclosDetProduto>();
	}

	private class PerdasCiclosMaqDetFerramenta {
		String cdFerramenta;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;			
		Map<String, PerdasCiclosMaqDetFerramentaEstrutura> estruturas = new HashMap<String, PerdasCiclosMaqDetFerramentaEstrutura>();
	}

	private class PerdasCiclosMaqDetMaquina {
		String cdPt;
		String cdIdentificacaoPt;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		Map<String, PerdasCiclosMaqDetFerramenta> ferramentas = new HashMap<String, PerdasCiclosMaqDetFerramenta>();
	}
	
	
	private class PerdasCiclosProdutoDetFerramentaEstrutura {
		String cdFerramenta;
		String cdEstrutura;
		String cicloPadraoStr;
		BigDecimal cicloPadrao = BigDecimal.ZERO;
		BigDecimal cicloMedio = BigDecimal.ZERO;
		BigDecimal tmpCicNormal = BigDecimal.ZERO;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;			
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
	}
		
	private class PerdasCiclosProdutoDetMaquina {
		String cdPt;
		String cdIdentificacaoPt;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
		Map<String, PerdasCiclosProdutoDetFerramentaEstrutura> ferramentas = new HashMap<String, PerdasCiclosProdutoDetFerramentaEstrutura>();
	}
	
	private class PerdasCiclosProdutoDetProduto {
		String cdProduto;
		String dsProduto;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
		Map<String, PerdasCiclosProdutoDetMaquina> maquinas = new HashMap<String, PerdasCiclosProdutoDetMaquina>();
	}	
	
	
	private static final Comparator<PerdasCiclosMaqDetMaquina> comparaPerdasCicloMaqMaqUB = new Comparator<PerdasCiclosMaqDetMaquina>() {
		@Override
        public int compare(PerdasCiclosMaqDetMaquina o1, PerdasCiclosMaqDetMaquina o2) {
			return o1.perdaUB.compareTo(o2.perdaUB) * -1;
        }
    };	

	private static final Comparator<PerdasCiclosMaqDetFerramenta> comparaPerdasCicloMaqMolUB = new Comparator<PerdasCiclosMaqDetFerramenta>() {
		@Override
        public int compare(PerdasCiclosMaqDetFerramenta o1, PerdasCiclosMaqDetFerramenta o2) {
			return o1.perdaUB.compareTo(o2.perdaUB) * -1;
        }
    };	

	private static final Comparator<PerdasCiclosMaqDetFerramentaEstrutura> comparaPerdasCicloMaqEstruUB = new Comparator<PerdasCiclosMaqDetFerramentaEstrutura>() {
		@Override
        public int compare(PerdasCiclosMaqDetFerramentaEstrutura o1, PerdasCiclosMaqDetFerramentaEstrutura o2) {
			return o1.perdaUB.compareTo(o2.perdaUB) * -1;
        }
    };	    
    
	private static final Comparator<PerdasCiclosDetProduto> comparaPerdasCicloMaqProdutoUB = new Comparator<PerdasCiclosDetProduto>() {
		@Override
        public int compare(PerdasCiclosDetProduto o1, PerdasCiclosDetProduto o2) {
			return o1.perdaUB.compareTo(o2.perdaUB) * -1;
        }
    };	    

    
    
    private static final Comparator<PerdasCiclosProdutoDetProduto> comparaPerdasCicloProProduto = new Comparator<PerdasCiclosProdutoDetProduto>() {
		@Override
        public int compare(PerdasCiclosProdutoDetProduto o1, PerdasCiclosProdutoDetProduto o2) {
			return o1.perdaOrdenacao.compareTo(o2.perdaOrdenacao) * -1;
        }
    };	    
       
	private static final Comparator<PerdasCiclosProdutoDetMaquina> comparaPerdasCicloProMaq = new Comparator<PerdasCiclosProdutoDetMaquina>() {
		@Override
        public int compare(PerdasCiclosProdutoDetMaquina o1, PerdasCiclosProdutoDetMaquina o2) {
			return o1.perdaOrdenacao.compareTo(o2.perdaOrdenacao) * -1;
        }
    };	

	private static final Comparator<PerdasCiclosProdutoDetFerramentaEstrutura> comparaPerdasCicloProEstru = new Comparator<PerdasCiclosProdutoDetFerramentaEstrutura>() {
		@Override
        public int compare(PerdasCiclosProdutoDetFerramentaEstrutura o1, PerdasCiclosProdutoDetFerramentaEstrutura o2) {
			return o1.perdaOrdenacao.compareTo(o2.perdaOrdenacao) * -1;
        }
    };	

	    
    
	public BiWebGraficoPerdasCicloDetInjetRN() {
		this(new DAOGenericoInjet());
	}
	
	public BiWebGraficoPerdasCicloDetInjetRN(DAOGenericoInjet dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenericoInjet();
		}
		this.setDao(dao);
	}

	private String getConsultaPerdasCicloMaqDetQtdes(BiFiltroDTO filtroBI, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		String strSQL;

		strSQL = "";
		strSQL = strSQL.concat("SELECT a.cdinjestendido, b.cdidentific, a.cdmolestendido, a.cdestrutura, d.ciclopadrao, a.cdproduto, f.dsproduto,");
		strSQL = strSQL.concat("       SUM(a.qtdritmo) as qtdperdasritmoUB, ");
		strSQL = strSQL.concat("       SUM(a.qtdritmoGr) as qtdperdasritmoGr, ");
		strSQL = strSQL.concat("       SUM(a.qtdritmo * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdperdasritmoUM ");
		
		// tabelas
		strSQL = strSQL.concat("  FROM viewBIDtRefProdutos a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijfictec d ON (d.cdinjetora = a.cdinjetora AND d.cdmolde = a.cdmolde AND d.cdestrutura = a.cdestrutura AND d.dthrivalcic = a.dthrivalcic) "); 
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
			strSQL = strSQL.concat(" AND b.cdinjestendido  = :cdptSelecaoPareto ");
		}
		if (! cdProdutoSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND a.cdproduto  = :cdprodutoSelecaoPareto ");
		}
				
		
		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND b.cdinjestendido = :cdpt ");	
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  AND gm.cdgrpinj = :cdgt ");		
			} else {			
				strSQL = strSQL.concat("  AND cm.classe = :cdclasse ");
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND c.cdmolestendido = :cdrap ");	
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");	
		}
		
		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat("  AND a.cdproduto = :cdproduto ");	
		}

		strSQL = strSQL.concat(" GROUP BY a.cdinjestendido, b.cdidentific, a.cdmolestendido, a.cdestrutura, d.ciclopadrao, a.cdproduto, f.dsproduto ");
		strSQL = strSQL.concat(" HAVING SUM(a.qtdritmo) <> 0 ");
				
		return strSQL;
	}
	
	private String getConsultaPerdasCicloMaqDetTempos(BiFiltroDTO filtroBI, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		String strSQL;

		strSQL = "";
		strSQL = strSQL.concat("SELECT a.cdinjestendido, b.cdidentific, a.cdmolestendido, a.cdestrutura, d.ciclopadrao, ");
		strSQL = strSQL.concat("       SUM(a.tmpcicnormal) as tmpcicnormal, ");
		strSQL = strSQL.concat("       SUM(a.qtdciclosnormais) as qtdcicnormal ");
		
		// tabelas
		strSQL = strSQL.concat("  FROM viewBIDtRefTempos a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijfictec d ON (d.cdinjetora = a.cdinjetora AND d.cdmolde = a.cdmolde AND d.cdestrutura = a.cdestrutura AND d.dthrivalcic = a.dthrivalcic) ");

		
		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat("  JOIN ijmolpro mp ON (mp.cdmolde = d.cdmolde AND mp.cdestrutura = d.cdestrutura AND mp.dthrival = d.dthrivalestru) ");
		}
		
		if (! cdProdutoSelecaoPareto.equals("")) {
			strSQL = strSQL.concat("  JOIN ijmolpro mpSel ON (mpSel.cdmolde = d.cdmolde AND mpSel.cdestrutura = d.cdestrutura AND mpSel.dthrival = d.dthrivalestru) ");
		}
		
		
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

		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat(" AND mp.cdproduto  = :cdproduto ");
		}
		
		if (! cdProdutoSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND mpSel.cdproduto  = :cdprodutoSelecaoPareto ");
		}

		if (! cdPtSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND b.cdinjestendido  = :cdptSelecaoPareto ");
		}
		
		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND b.cdinjestendido = :cdpt ");	
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  AND gm.cdgrpinj = :cdgt ");		
			} else {			
				strSQL = strSQL.concat("  AND cm.classe = :cdclasse ");
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND c.cdmolestendido = :cdrap ");	
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");	
		}
		
		strSQL = strSQL.concat(" GROUP BY a.cdinjestendido, b.cdidentific, a.cdmolestendido, a.cdestrutura, d.ciclopadrao ");
		
		return strSQL;
	}

	private SQLQuery setFiltrosaQuery(SQLQuery q, BiFiltroDTO filtroBI, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		
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
	public BiParetoPerdasCicloDetalheDTO getParetoPerdasCicloMaqDet(BiFiltroDTO filtroBIDet, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		BiFiltroDTO filtroBI = new BiFiltroDTO();
		BiWebInjetRN biRN = new BiWebInjetRN(getDao(), BiResource.FORMATO_DATA, BiResource.FORMATO_DATA_HORA);
		filtroBI = biRN.filtroBiTransformado(filtroBIDet);
				
		
		BiParetoPerdasCicloDetalheDTO resumo = new BiParetoPerdasCicloDetalheDTO();
		resumo.setDetalhes(new ArrayList<BiParetoPerdasCicloDetDTO>());
		BigDecimal totalCusto = BigDecimal.ZERO;
		BigDecimal totalGanho = BigDecimal.ZERO;
		BigDecimal totalGanhoGr = BigDecimal.ZERO;
		BigDecimal totalPerda = BigDecimal.ZERO;
		BigDecimal totalPerdaGr = BigDecimal.ZERO;
		
		Map<String, PerdasCiclosMaqDetMaquina> mapMaquinas = new HashMap<String, PerdasCiclosMaqDetMaquina>();
		Map<String, PerdasCiclosMaqDetProdutoTempos> mapTempos = new HashMap<String, PerdasCiclosMaqDetProdutoTempos>();
		Map<String, PerdasCiclosMaqDetProdutoTempos> mapTemposMaq = new HashMap<String, PerdasCiclosMaqDetProdutoTempos>();
		
		int _cdpt = 0;
		int _dspt = _cdpt + 1;		
		int _cdferramenta = _dspt + 1;
		int _cdestrutura = _cdferramenta + 1;
		int _ciclopadrao = _cdestrutura + 1;
		
		int _cdproduto = _ciclopadrao + 1;
		int _dsproduto = _cdproduto + 1;
		int _perdasUB = _dsproduto + 1;
		int _perdasGr = _perdasUB + 1;
		int _perdasUM = _perdasGr + 1;
		
		int _tmpCicNormal = _ciclopadrao + 1;
		int _qtdCicNormal = _tmpCicNormal + 1;
		

		
		// tempos
		String strSQL = "";		
		List<Object>  lista = new ArrayList<Object>();
		strSQL = getConsultaPerdasCicloMaqDetTempos(filtroBI, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosaQuery(q, filtroBI, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		
		lista = q.list();		
		for (Object reg : lista) {
			PerdasCiclosMaqDetProdutoTempos registro = new PerdasCiclosMaqDetProdutoTempos();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			registro.cdPt = (String) registroLido[_cdpt];
			registro.cdFerramenta = (String) registroLido[_cdferramenta];
			registro.cdEstrutura = (String) registroLido[_cdestrutura];
			registro.cicloPadrao = ConversaoTipos.converterParaBigDecimal(registroLido[_ciclopadrao]);
			registro.cicloPadraoStr = ConversaoTipos.converteParaString(registro.cicloPadrao, 4);
			registro.tmpCicNormal = ConversaoTipos.converterParaBigDecimal(registroLido[_tmpCicNormal]);
			registro.qtdCicNormal = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdCicNormal]);
			registro.cicloMedio = FormulasInjet.calcularCicloMedio(registro.tmpCicNormal, registro.qtdCicNormal);
			
			String keyTempos = registro.cdPt + registro.cdFerramenta + registro.cdEstrutura + registro.cicloPadraoStr;			
			mapTempos.put(keyTempos, registro);
			
			
			PerdasCiclosMaqDetProdutoTempos registroMaq = new PerdasCiclosMaqDetProdutoTempos();
			registroMaq.cdPt = registro.cdPt;
			registroMaq.tmpCicNormal = registro.tmpCicNormal; 
			
			if (! mapTemposMaq.containsKey(registroMaq.cdPt)) {
				mapTemposMaq.put(registroMaq.cdPt, registroMaq);
			} else {
				registroMaq = mapTemposMaq.get(registroMaq.cdPt);
				registroMaq.tmpCicNormal = AritmeticaUtil.somar(registroMaq.tmpCicNormal, registro.tmpCicNormal);
				
				mapTemposMaq.remove(registroMaq.cdPt);
				mapTemposMaq.put(registroMaq.cdPt, registroMaq);				
			}			
		}
				
		
		// qtdes
		strSQL = "";		
		lista = new ArrayList<Object>();
		strSQL = getConsultaPerdasCicloMaqDetQtdes(filtroBI, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosaQuery(q, filtroBI, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		
		lista = q.list();		
		for (Object reg : lista) {
			PerdasCiclosDetProduto registro = new PerdasCiclosDetProduto();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			registro.cdPt = (String) registroLido[_cdpt];
			registro.cdIdentificacaoPt = (String) registroLido[_dspt];
			registro.cdFerramenta = (String) registroLido[_cdferramenta];
			registro.cdEstrutura = (String) registroLido[_cdestrutura];
			registro.cicloPadrao = ConversaoTipos.converterParaBigDecimal(registroLido[_ciclopadrao]);
			registro.cicloPadraoStr = ConversaoTipos.converteParaString(registro.cicloPadrao, 4);
			registro.cdProduto = (String) registroLido[_cdproduto];
			registro.dsProduto = (String) registroLido[_dsproduto];
			registro.perdaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasUB]);
			registro.perdaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasGr]);
			registro.perdaUM = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasUM]);
			
			
			PerdasCiclosMaqDetFerramentaEstrutura perdaEstruturaReg = new PerdasCiclosMaqDetFerramentaEstrutura();
			perdaEstruturaReg.cdEstrutura = registro.cdEstrutura;
			perdaEstruturaReg.cicloPadrao = registro.cicloPadrao;
			perdaEstruturaReg.cicloPadraoStr = registro.cicloPadraoStr;
			perdaEstruturaReg.perdaUB = registro.perdaUB;
			perdaEstruturaReg.perdaGr = registro.perdaGr;
			perdaEstruturaReg.perdaUM = registro.perdaUM;
			perdaEstruturaReg.produtos.put(registro.cdProduto, registro);
			
			PerdasCiclosMaqDetFerramenta perdaFerramentaReg = new PerdasCiclosMaqDetFerramenta();
			perdaFerramentaReg.cdFerramenta = registro.cdFerramenta;
			perdaFerramentaReg.perdaUB = registro.perdaUB;
			perdaFerramentaReg.perdaGr = registro.perdaGr;
			perdaFerramentaReg.perdaUM = registro.perdaUM;
			perdaFerramentaReg.estruturas.put(registro.cdEstrutura + registro.cicloPadraoStr, perdaEstruturaReg);

			PerdasCiclosMaqDetMaquina perdaMaquinaReg = new PerdasCiclosMaqDetMaquina();
			perdaMaquinaReg.cdPt = registro.cdPt;
			perdaMaquinaReg.cdIdentificacaoPt = registro.cdIdentificacaoPt;
			perdaMaquinaReg.perdaUB = registro.perdaUB;
			perdaMaquinaReg.perdaGr = registro.perdaGr;
			perdaMaquinaReg.perdaUM = registro.perdaUM;
			perdaMaquinaReg.ferramentas.put(registro.cdFerramenta, perdaFerramentaReg);
			
			
			if (! mapMaquinas.containsKey(registro.cdPt)) {
				mapMaquinas.put(registro.cdPt, perdaMaquinaReg);
				
			} else {
				PerdasCiclosMaqDetMaquina perdaMaquina = new PerdasCiclosMaqDetMaquina();
				perdaMaquina = mapMaquinas.get(registro.cdPt);
					
				// atualizar perdas maquina
				perdaMaquina.perdaUB = AritmeticaUtil.somar(perdaMaquina.perdaUB, registro.perdaUB);
				perdaMaquina.perdaGr = AritmeticaUtil.somar(perdaMaquina.perdaGr, registro.perdaGr);
				perdaMaquina.perdaUM = AritmeticaUtil.somar(perdaMaquina.perdaUM, registro.perdaUM);
					
				if (! perdaMaquina.ferramentas.containsKey(registro.cdFerramenta)) {
					PerdasCiclosMaqDetFerramenta perdaFerramenta = new PerdasCiclosMaqDetFerramenta();
					perdaFerramenta = perdaFerramentaReg;					
					perdaMaquina.ferramentas.put(registro.cdFerramenta, perdaFerramenta);
					
				} else {
					PerdasCiclosMaqDetFerramenta perdaFerramenta = new PerdasCiclosMaqDetFerramenta();
					perdaFerramenta = perdaMaquina.ferramentas.get(registro.cdFerramenta);
					
					// atualizar perdas ferramenta
					perdaFerramenta.perdaUB = AritmeticaUtil.somar(perdaFerramenta.perdaUB, registro.perdaUB);
					perdaFerramenta.perdaGr = AritmeticaUtil.somar(perdaFerramenta.perdaGr, registro.perdaGr);
					perdaFerramenta.perdaUM = AritmeticaUtil.somar(perdaFerramenta.perdaUM, registro.perdaUM);
										
					
					if (! perdaFerramenta.estruturas.containsKey(registro.cdEstrutura + registro.cicloPadraoStr)) {
						PerdasCiclosMaqDetFerramentaEstrutura perdaEstrutura = new PerdasCiclosMaqDetFerramentaEstrutura();
						perdaEstrutura = perdaEstruturaReg;
						
						perdaFerramenta.estruturas.put(registro.cdEstrutura + registro.cicloPadraoStr, perdaEstrutura);
						perdaMaquina.ferramentas.put(registro.cdFerramenta, perdaFerramenta);
					
					} else {
						PerdasCiclosMaqDetFerramentaEstrutura perdaEstrutura = perdaFerramenta.estruturas.get(registro.cdEstrutura + registro.cicloPadraoStr);
						perdaEstrutura.produtos.put(registro.cicloPadraoStr + registro.cdProduto, registro);
					}
					
					perdaMaquina.ferramentas.put(registro.cdFerramenta, perdaFerramenta);												
				}
				
				mapMaquinas.remove(registro.cdPt);				
				mapMaquinas.put(registro.cdPt, perdaMaquina);
			}
			
			String keyTempos = registro.cdPt + registro.cdFerramenta + registro.cdEstrutura + registro.cicloPadraoStr;
			mapMaquinas.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura + registro.cicloPadraoStr).cicloMedio = mapTempos.get(keyTempos).cicloMedio;	
			mapMaquinas.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura + registro.cicloPadraoStr).tmpCicNormal = mapTempos.get(keyTempos).tmpCicNormal;
			
			totalCusto = AritmeticaUtil.somar(totalCusto, registro.perdaUM);
			if (registro.perdaUB.doubleValue() < 0) {
				totalGanho = AritmeticaUtil.somar(totalGanho, registro.perdaUB);
				totalGanhoGr = AritmeticaUtil.somar(totalGanho, registro.perdaGr);
			} else {
				totalPerda = AritmeticaUtil.somar(totalPerda, registro.perdaUB);
				totalPerdaGr = AritmeticaUtil.somar(totalPerdaGr, registro.perdaGr);				
			}				
		}
		
		
		
		// Ordenacao por maq
		List<PerdasCiclosMaqDetMaquina> listaMaq = new ArrayList<PerdasCiclosMaqDetMaquina>();
		listaMaq.addAll(mapMaquinas.values());
		Collections.sort(listaMaq, comparaPerdasCicloMaqMaqUB);
		
		for (PerdasCiclosMaqDetMaquina perdaMaq : listaMaq) {
			
			if (resumo.getDetalhes().size() > 0) {
				BiParetoPerdasCicloDetDTO linhaDetPerdas = new BiParetoPerdasCicloDetDTO();
				linhaDetPerdas.setPt("");
				linhaDetPerdas.setFerramenta("");
				linhaDetPerdas.setCicloPadrao("");
				linhaDetPerdas.setCicloLido("");
				linhaDetPerdas.setProduto("");
				linhaDetPerdas.setCdProduto("");
				linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_SEM_COR);
				linhaDetPerdas.setCiclosProdutivos("");
				linhaDetPerdas.setPerdaUB("");
				linhaDetPerdas.setPerdaKg("");
				linhaDetPerdas.setPerdaTon("");
				linhaDetPerdas.setPerdaUM("");		
				
				resumo.getDetalhes().add(linhaDetPerdas);
			}
			
			
			// Ordenacao por molde
			List<PerdasCiclosMaqDetFerramenta> listaMol = new ArrayList<PerdasCiclosMaqDetFerramenta>();
			listaMol.addAll(perdaMaq.ferramentas.values());
			Collections.sort(listaMol, comparaPerdasCicloMaqMolUB);

			int contadorMol = 0;
			for (PerdasCiclosMaqDetFerramenta perdaMol: listaMol) {
				contadorMol++;
				
				// Ordenacao por estrutura
				List<PerdasCiclosMaqDetFerramentaEstrutura> listaEstru = new ArrayList<PerdasCiclosMaqDetFerramentaEstrutura>();
				listaEstru.addAll(perdaMol.estruturas.values());
				Collections.sort(listaEstru, comparaPerdasCicloMaqEstruUB);

				int contadorEstru = 0;
				for (PerdasCiclosMaqDetFerramentaEstrutura perdaEstru: listaEstru) {
					contadorEstru++;
					
					// Ordenacao por produto
					List<PerdasCiclosDetProduto> listaPro = new ArrayList<PerdasCiclosDetProduto>();
					listaPro.addAll(perdaEstru.produtos.values());
					Collections.sort(listaPro, comparaPerdasCicloMaqProdutoUB);
					
					int contadorPro = 0;
					for (PerdasCiclosDetProduto perdaPro: listaPro) {
						contadorPro++;
						
						BiParetoPerdasCicloDetDTO linhaDetPerdas = new BiParetoPerdasCicloDetDTO();

						if (contadorMol == 1 && contadorEstru == 1 && contadorPro == 1) {
							linhaDetPerdas.setPt(perdaMaq.cdPt + " (" + perdaMaq.cdIdentificacaoPt + ")");
						} else {
							linhaDetPerdas.setPt("");
						}
						
						if (contadorEstru == 1 && contadorPro == 1) {
							linhaDetPerdas.setFerramenta(perdaMol.cdFerramenta + "/" + perdaEstru.cdEstrutura);							
						} else {
							linhaDetPerdas.setFerramenta("");
						}
						
						if (contadorPro == 1) {
							linhaDetPerdas.setCicloPadrao(ConversaoTipos.converteParaString(perdaEstru.cicloPadrao, 4));
							linhaDetPerdas.setCicloLido(ConversaoTipos.converteParaString(perdaEstru.cicloMedio, 4));
						} else {
							linhaDetPerdas.setFerramenta("");
						}
						linhaDetPerdas.setProduto(perdaPro.cdProduto + " (" + perdaPro.dsProduto + ")");
						linhaDetPerdas.setCdProduto(perdaPro.cdProduto);
						linhaDetPerdas.setCiclosProdutivos(DataHoraRN.formatSegundosParaHHMMSS(perdaEstru.tmpCicNormal));
						linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaPro.perdaUB));
						linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString( AritmeticaUtil.dividir(perdaPro.perdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
						linhaDetPerdas.setPerdaTon(ConversaoTipos.converteParaString( AritmeticaUtil.dividir(perdaPro.perdaGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
						linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaPro.perdaUM, 2));							
						linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_SEM_COR);
						
						
						// adiciona linha 
						resumo.getDetalhes().add(linhaDetPerdas);
					}
					
					// perda do molde/estrutura
					BiParetoPerdasCicloDetDTO linhaDetPerdas = new BiParetoPerdasCicloDetDTO();
					linhaDetPerdas.setPt("");
					linhaDetPerdas.setFerramenta("");
					linhaDetPerdas.setCicloPadrao("");
					linhaDetPerdas.setCicloLido("");
					linhaDetPerdas.setProduto(TEXTO_CELULA_PERDA_CICLO_SUB_TOTAL_MOLDE);
					linhaDetPerdas.setCdProduto("");
					linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_PERDA_CICLO_SUB_TOTAL_MOLDE);				
					linhaDetPerdas.setCiclosProdutivos(DataHoraRN.formatSegundosParaHHMMSS(perdaEstru.tmpCicNormal));
					linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaEstru.perdaUB));
					linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString( AritmeticaUtil.dividir(perdaEstru.perdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
					linhaDetPerdas.setPerdaTon(ConversaoTipos.converteParaString( AritmeticaUtil.dividir(perdaEstru.perdaGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
					linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaEstru.perdaUM, 2));							
					
					// adiciona linha 
					resumo.getDetalhes().add(linhaDetPerdas);					
				}
				
			}
			
			// perda do pt
			BiParetoPerdasCicloDetDTO linhaDetPerdas = new BiParetoPerdasCicloDetDTO();
			linhaDetPerdas.setPt("");
			linhaDetPerdas.setFerramenta("");
			linhaDetPerdas.setCicloPadrao("");
			linhaDetPerdas.setCicloLido("");
			linhaDetPerdas.setProduto(TEXTO_CELULA_PERDA_CICLO_SUB_TOTAL_MAQUINA);
			linhaDetPerdas.setCdProduto("");
			linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_PERDA_CICLO_SUB_TOTAL_MAQUINA);				
			linhaDetPerdas.setCiclosProdutivos(DataHoraRN.formatSegundosParaHHMMSS(mapTemposMaq.get(perdaMaq.cdPt).tmpCicNormal));
			linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaMaq.perdaUB));
			linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString( AritmeticaUtil.dividir(perdaMaq.perdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
			linhaDetPerdas.setPerdaTon(ConversaoTipos.converteParaString( AritmeticaUtil.dividir(perdaMaq.perdaGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
			linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaMaq.perdaUM, 2));							
			
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
		resumo.setEfiCiclo(filtroBI.getIndicadores().getEfiCic());
		
		return resumo;		
	}

	@SuppressWarnings("unchecked")
	public BiParetoPerdasCicloDetalheDTO getParetoPerdasCicloProDet(BiFiltroDTO filtroBIDet, UnidadeExibicaoOuOrdenacaoQtdBI ordenacao, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		BiFiltroDTO filtroBI = new BiFiltroDTO();
		BiWebInjetRN biRN = new BiWebInjetRN(getDao(), BiResource.FORMATO_DATA, BiResource.FORMATO_DATA_HORA);
		filtroBI = biRN.filtroBiTransformado(filtroBIDet);
				
		BiParetoPerdasCicloDetalheDTO resumo = new BiParetoPerdasCicloDetalheDTO();
		resumo.setDetalhes(new ArrayList<BiParetoPerdasCicloDetDTO>());
		BigDecimal totalCusto = BigDecimal.ZERO;
		BigDecimal totalGanho = BigDecimal.ZERO;
		BigDecimal totalGanhoGr = BigDecimal.ZERO;
		BigDecimal totalPerda = BigDecimal.ZERO;
		BigDecimal totalPerdaGr = BigDecimal.ZERO;
		
		Map<String, PerdasCiclosProdutoDetProduto> mapProdutos = new HashMap<String, PerdasCiclosProdutoDetProduto>();
		Map<String, PerdasCiclosMaqDetProdutoTempos> mapTempos = new HashMap<String, PerdasCiclosMaqDetProdutoTempos>();
		
		
		int _cdpt = 0;
		int _dspt = _cdpt + 1;		
		int _cdferramenta = _dspt + 1;
		int _cdestrutura = _cdferramenta + 1;
		int _ciclopadrao = _cdestrutura + 1;
		
		int _cdproduto = _ciclopadrao + 1;
		int _dsproduto = _cdproduto + 1;
		int _perdasUB = _dsproduto + 1;
		int _perdasGr = _perdasUB + 1;
		int _perdasUM = _perdasGr + 1;
		
		int _tmpCicNormal = _ciclopadrao + 1;
		int _qtdCicNormal = _tmpCicNormal + 1;
		
		
		
		// tempos
		String strSQL = "";		
		List<Object>  lista = new ArrayList<Object>();
		strSQL = getConsultaPerdasCicloMaqDetTempos(filtroBI, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosaQuery(q, filtroBI, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		
		lista = q.list();		
		for (Object reg : lista) {
			PerdasCiclosMaqDetProdutoTempos registro = new PerdasCiclosMaqDetProdutoTempos();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			registro.cdPt = (String) registroLido[_cdpt];
			registro.cdFerramenta = (String) registroLido[_cdferramenta];
			registro.cdEstrutura = (String) registroLido[_cdestrutura];
			registro.cicloPadrao = ConversaoTipos.converterParaBigDecimal(registroLido[_ciclopadrao]);
			registro.cicloPadraoStr = ConversaoTipos.converteParaString(registro.cicloPadrao, 4);
			registro.tmpCicNormal = ConversaoTipos.converterParaBigDecimal(registroLido[_tmpCicNormal]);
			registro.qtdCicNormal = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdCicNormal]);
			registro.cicloMedio = FormulasInjet.calcularCicloMedio(registro.tmpCicNormal, registro.qtdCicNormal);
			
			String keyTempos = registro.cdPt + registro.cdFerramenta + registro.cdEstrutura + registro.cicloPadraoStr;			
			mapTempos.put(keyTempos, registro);
			
			
			PerdasCiclosMaqDetProdutoTempos registroMaq = new PerdasCiclosMaqDetProdutoTempos();
			registroMaq.cdPt = registro.cdPt;
			registroMaq.tmpCicNormal = registro.tmpCicNormal; 
			
			if (! mapTempos.containsKey(registroMaq.cdPt)) {
				mapTempos.put(registroMaq.cdPt, registroMaq);
			} else {
				registroMaq = mapTempos.get(registroMaq.cdPt);
				registroMaq.tmpCicNormal = AritmeticaUtil.somar(registroMaq.tmpCicNormal, registro.tmpCicNormal);
				
				mapTempos.remove(registroMaq.cdPt);
				mapTempos.put(registroMaq.cdPt, registroMaq);				
			}			
		}

		
		
		// qtdes
		strSQL = "";		
		lista = new ArrayList<Object>();
		strSQL = getConsultaPerdasCicloMaqDetQtdes(filtroBI, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosaQuery(q, filtroBI, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		
		lista = q.list();		
		for (Object reg : lista) {
			PerdasCiclosDetProduto registro = new PerdasCiclosDetProduto();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			registro.cdPt = (String) registroLido[_cdpt];
			registro.cdIdentificacaoPt = (String) registroLido[_dspt];
			registro.cdFerramenta = (String) registroLido[_cdferramenta];
			registro.cdEstrutura = (String) registroLido[_cdestrutura];
			registro.cicloPadrao = ConversaoTipos.converterParaBigDecimal(registroLido[_ciclopadrao]);
			registro.cicloPadraoStr = ConversaoTipos.converteParaString(registro.cicloPadrao, 4);
			registro.cdProduto = (String) registroLido[_cdproduto];
			registro.dsProduto = (String) registroLido[_dsproduto];
			registro.perdaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasUB]);
			registro.perdaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasGr]);
			registro.perdaUM = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasUM]);
			registro.perdaOrdenacao = getValorPerda(ordenacao, registro);
			
			 
			PerdasCiclosProdutoDetFerramentaEstrutura perdaEstruturaReg = new PerdasCiclosProdutoDetFerramentaEstrutura();
			perdaEstruturaReg.cdFerramenta = registro.cdFerramenta;
			perdaEstruturaReg.cdEstrutura = registro.cdEstrutura;
			perdaEstruturaReg.cicloPadrao = registro.cicloPadrao;
			perdaEstruturaReg.cicloPadraoStr = registro.cicloPadraoStr;
			perdaEstruturaReg.perdaUB = registro.perdaUB;
			perdaEstruturaReg.perdaGr = registro.perdaGr;
			perdaEstruturaReg.perdaUM = registro.perdaUM;
			perdaEstruturaReg.perdaOrdenacao = registro.perdaOrdenacao;
			
			PerdasCiclosProdutoDetMaquina perdaMaquinaReg = new PerdasCiclosProdutoDetMaquina();
			perdaMaquinaReg.cdPt = registro.cdPt;
			perdaMaquinaReg.cdIdentificacaoPt = registro.cdIdentificacaoPt;
			perdaMaquinaReg.perdaUB = registro.perdaUB;
			perdaMaquinaReg.perdaGr = registro.perdaGr;
			perdaMaquinaReg.perdaUM = registro.perdaUM;
			perdaMaquinaReg.perdaOrdenacao = registro.perdaOrdenacao;
			perdaMaquinaReg.ferramentas.put(registro.cdFerramenta + registro.cdEstrutura + registro.cicloPadraoStr, perdaEstruturaReg);
			
			PerdasCiclosProdutoDetProduto perdaProdutoReg = new PerdasCiclosProdutoDetProduto();
			perdaProdutoReg.cdProduto = registro.cdProduto;
			perdaProdutoReg.dsProduto = registro.dsProduto;
			perdaProdutoReg.perdaUB = registro.perdaUB;
			perdaProdutoReg.perdaGr = registro.perdaGr;
			perdaProdutoReg.perdaUM = registro.perdaUM;
			perdaProdutoReg.perdaOrdenacao = registro.perdaOrdenacao;
			perdaProdutoReg.maquinas.put(registro.cdPt, perdaMaquinaReg);
			
			if (! mapProdutos.containsKey(registro.cdProduto)) {
				mapProdutos.put(registro.cdProduto, perdaProdutoReg);
				
			} else {
				PerdasCiclosProdutoDetProduto perdaProduto = new PerdasCiclosProdutoDetProduto();
				perdaProduto = mapProdutos.get(registro.cdProduto);
				
				// atualiza perdas produto
				perdaProduto.perdaUB = AritmeticaUtil.somar(perdaProduto.perdaUB, registro.perdaUB);
				perdaProduto.perdaGr = AritmeticaUtil.somar(perdaProduto.perdaGr, registro.perdaGr);
				perdaProduto.perdaUM = AritmeticaUtil.somar(perdaProduto.perdaUM, registro.perdaUM);
				
				
				if (! perdaProduto.maquinas.containsKey(registro.cdPt)) {
					PerdasCiclosProdutoDetMaquina perdaMaquina = new PerdasCiclosProdutoDetMaquina();
					
					perdaMaquina = perdaMaquinaReg;					
					perdaProduto.maquinas.put(registro.cdPt, perdaMaquina);
					
				} else {
					PerdasCiclosProdutoDetMaquina perdaMaquina = new PerdasCiclosProdutoDetMaquina();
					perdaMaquina = perdaProduto.maquinas.get(registro.cdPt);
				
					// atualiza perdas da maquina
					perdaMaquina.perdaUB = AritmeticaUtil.somar(perdaMaquina.perdaUB, registro.perdaUB);
					perdaMaquina.perdaGr = AritmeticaUtil.somar(perdaMaquina.perdaGr, registro.perdaGr);
					perdaMaquina.perdaUM = AritmeticaUtil.somar(perdaMaquina.perdaUM, registro.perdaUM);
										
					
					PerdasCiclosProdutoDetFerramentaEstrutura perdaEstrutura = new PerdasCiclosProdutoDetFerramentaEstrutura();
					perdaEstrutura = perdaEstruturaReg;
					
					perdaMaquina.ferramentas.put(registro.cdFerramenta + registro.cdEstrutura + registro.cicloPadraoStr, perdaEstrutura);
					perdaProduto.maquinas.put(registro.cdPt, perdaMaquina);					
				}
				
				mapProdutos.remove(registro.cdPt);				
				mapProdutos.put(registro.cdPt, perdaProduto);
			}
			
			
			// atualizar tempos em mapProdutos
			String keyTempo = registro.cdPt + registro.cdFerramenta + registro.cdEstrutura + registro.cicloPadraoStr;
			PerdasCiclosMaqDetProdutoTempos tempo = mapTempos.get(keyTempo);				
			
			mapProdutos.get(registro.cdProduto).maquinas.get(registro.cdPt).ferramentas.get(registro.cdFerramenta + registro.cdEstrutura + registro.cicloPadraoStr).tmpCicNormal = tempo.tmpCicNormal;
			mapProdutos.get(registro.cdProduto).maquinas.get(registro.cdPt).ferramentas.get(registro.cdFerramenta + registro.cdEstrutura + registro.cicloPadraoStr).cicloMedio = tempo.cicloMedio;
			
			totalCusto = AritmeticaUtil.somar(totalCusto, registro.perdaUM);
			if (registro.perdaUB.doubleValue() < 0) {
				totalGanho = AritmeticaUtil.somar(totalGanho, registro.perdaUB);
				totalGanhoGr = AritmeticaUtil.somar(totalGanho, registro.perdaGr);
			} else {
				totalPerda = AritmeticaUtil.somar(totalPerda, registro.perdaUB);
				totalPerdaGr = AritmeticaUtil.somar(totalPerdaGr, registro.perdaGr);				
			}			
		}
		

		
		// Ordenacao por produto
		List<PerdasCiclosProdutoDetProduto> listaPro = new ArrayList<PerdasCiclosProdutoDetProduto>();
		listaPro.addAll(mapProdutos.values());
		Collections.sort(listaPro, comparaPerdasCicloProProduto);
		
		for (PerdasCiclosProdutoDetProduto perdaPro : listaPro) {
			BigDecimal tempoTotalCicNormalProduto = BigDecimal.ZERO;
			
			if (resumo.getDetalhes().size() > 0) {
				BiParetoPerdasCicloDetDTO linhaDetPerdas = new BiParetoPerdasCicloDetDTO();
				linhaDetPerdas.setPt("");
				linhaDetPerdas.setFerramenta("");
				linhaDetPerdas.setCicloPadrao("");
				linhaDetPerdas.setCicloLido("");
				linhaDetPerdas.setProduto("");
				linhaDetPerdas.setCdProduto("");
				linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_SEM_COR);				
				linhaDetPerdas.setCiclosProdutivos("");
				linhaDetPerdas.setPerdaUB("");
				linhaDetPerdas.setPerdaKg("");
				linhaDetPerdas.setPerdaTon("");
				linhaDetPerdas.setPerdaUM("");		
				
				resumo.getDetalhes().add(linhaDetPerdas);
			}
			
			
			// Ordenacao por máquina
			List<PerdasCiclosProdutoDetMaquina> listaMaq = new ArrayList<PerdasCiclosProdutoDetMaquina>();
			listaMaq.addAll(perdaPro.maquinas.values());
			Collections.sort(listaMaq, comparaPerdasCicloProMaq);

			int contadorMaq = 0;
			for (PerdasCiclosProdutoDetMaquina perdaMaq: listaMaq) {
				contadorMaq++;
				
				// Ordenacao por estrutura
				List<PerdasCiclosProdutoDetFerramentaEstrutura> listaEstru = new ArrayList<PerdasCiclosProdutoDetFerramentaEstrutura>();
				listaEstru.addAll(perdaMaq.ferramentas.values());
				Collections.sort(listaEstru, comparaPerdasCicloProEstru);

				int contadorEstru = 0;
				for (PerdasCiclosProdutoDetFerramentaEstrutura perdaEstru: listaEstru) {
					contadorEstru++;
					
					BiParetoPerdasCicloDetDTO linhaDetPerdas = new BiParetoPerdasCicloDetDTO();

					if (contadorMaq == 1 && contadorEstru == 1) {
						linhaDetPerdas.setProduto(perdaPro.cdProduto + " (" + perdaPro.dsProduto + ")");
						linhaDetPerdas.setCdProduto(perdaPro.cdProduto);
					} else {
						linhaDetPerdas.setProduto("");
						linhaDetPerdas.setCdProduto("");
					}
					
					if (contadorEstru == 1) {
						linhaDetPerdas.setPt(perdaMaq.cdPt + " (" + perdaMaq.cdIdentificacaoPt + ")");																		
					} else {
						linhaDetPerdas.setPt("");
					}
					linhaDetPerdas.setFerramenta(perdaEstru.cdFerramenta + "/" + perdaEstru.cdEstrutura);
					linhaDetPerdas.setCicloPadrao(ConversaoTipos.converteParaString(perdaEstru.cicloPadrao, 4));
					linhaDetPerdas.setCicloLido(ConversaoTipos.converteParaString(perdaEstru.cicloMedio, 4));

					linhaDetPerdas.setCiclosProdutivos(DataHoraRN.formatSegundosParaHHMMSS(perdaEstru.tmpCicNormal));
					linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaEstru.perdaUB));
					linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaEstru.perdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
					linhaDetPerdas.setPerdaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaEstru.perdaGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
					linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaEstru.perdaUM, 2));							
					
					linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_SEM_COR);
					
					
					// adiciona linha 
					resumo.getDetalhes().add(linhaDetPerdas);
					
					tempoTotalCicNormalProduto = AritmeticaUtil.somar(tempoTotalCicNormalProduto, perdaEstru.tmpCicNormal);
				}
				
			}
			
			// perda do produto
			BiParetoPerdasCicloDetDTO linhaDetPerdas = new BiParetoPerdasCicloDetDTO();
			linhaDetPerdas.setPt("");
			linhaDetPerdas.setFerramenta("");
			linhaDetPerdas.setCicloPadrao("");
			linhaDetPerdas.setCicloLido(TEXTO_CELULA_PERDA_CICLO_SUB_TOTAL_PRODUTO);
			linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_PERDA_CICLO_SUB_TOTAL_PRODUTO);				
			linhaDetPerdas.setProduto("");
			linhaDetPerdas.setCdProduto("");
			linhaDetPerdas.setCiclosProdutivos(DataHoraRN.formatSegundosParaHHMMSS(tempoTotalCicNormalProduto));
			linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaPro.perdaUB));
			linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaPro.perdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
			linhaDetPerdas.setPerdaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaPro.perdaGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
			linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaPro.perdaUM, 2));							
			
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
		resumo.setEfiCiclo(filtroBI.getIndicadores().getEfiCic());
		
		
		return resumo;		
		
	}


	private BigDecimal getValorPerda(UnidadeExibicaoOuOrdenacaoQtdBI ordenacao, PerdasCiclosDetProduto registro) {
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
