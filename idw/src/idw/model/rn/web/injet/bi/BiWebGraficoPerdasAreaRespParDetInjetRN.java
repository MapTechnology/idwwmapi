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
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiParetoPerdasAreaRespParadaDetDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiParetoPerdasAreaRespParadaDetalheDTO;
import ms.util.ConversaoTipos;

public class BiWebGraficoPerdasAreaRespParDetInjetRN  extends AbstractRN<DAOGenericoInjet> {	
	private static final String COR_CELULA_SEM_COR = "";
	private static final String COR_CELULA_PERDA_PARADA_SUB_TOTAL_AREA = "#e0e0e0";
	private static final String TEXTO_CELULA_PERDA_PARADA_SUB_TOTAL_AREA = "TOTAL DA AREA";

	
	private class RegistroAreaParada {
		String cdArea;
		String dsArea;
		String cdParada;
		String dsParada;
		BigDecimal segTempoPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrMicroPar = BigDecimal.ZERO;
	}

	private class RegistroParadaProduto {
		String cdArea;
		String cdParada;
		String cdProduto;
		String dsProduto;
		String cdPt;
		String dsPt;
		BigDecimal segTempoPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrMicroPar = BigDecimal.ZERO;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
	}
	
	

	private class PerdasDetMaquina {
		String cdPt;
		String cdIdentificacaoPt;
		BigDecimal tmpParada = BigDecimal.ZERO;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
	}
	
	private class PerdasDetProduto {
		String cdProduto;
		String dsProduto;
		BigDecimal tmpParada = BigDecimal.ZERO;
		BigDecimal qtdOcorrPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrMicroPar = BigDecimal.ZERO;
		BigDecimal indiceMicroPar = BigDecimal.ZERO;		
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
		Map<String, PerdasDetMaquina> maquinas = new HashMap<String, PerdasDetMaquina>();
	}
	
	private class PerdasDetParada {
		String cdParada;
		String dsParada;
		BigDecimal tmpParada = BigDecimal.ZERO;
		BigDecimal qtdOcorrPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrMicroPar = BigDecimal.ZERO;
		BigDecimal indiceMicroPar = BigDecimal.ZERO;		
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
		Map<String, PerdasDetProduto> produtos = new HashMap<String, PerdasDetProduto>();		
	}
	
	private class PerdasDetArea {
		String cdArea;
		String dsArea;
		BigDecimal tmpParada = BigDecimal.ZERO;
		BigDecimal qtdOcorrPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrMicroPar = BigDecimal.ZERO;
		BigDecimal indiceMicroPar = BigDecimal.ZERO;		
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
		Map<String, PerdasDetParada> paradas = new HashMap<String, PerdasDetParada>();
	}

	

	private static final Comparator<PerdasDetArea> comparaPerdasAreaTempo = new Comparator<PerdasDetArea>() {
		@Override
		public int compare(PerdasDetArea o1, PerdasDetArea o2) {
			return o1.tmpParada.compareTo(o2.tmpParada) * -1;
		}
	};

	
	private static final Comparator<PerdasDetParada> comparaPerdasParadaTempo = new Comparator<PerdasDetParada>() {

		@Override
		public int compare(PerdasDetParada o1, PerdasDetParada o2) {
			return o1.tmpParada.compareTo(o2.tmpParada) * -1;
		}
	};
	
	private static final Comparator<PerdasDetProduto> comparaPerdasProdutoTempo = new Comparator<PerdasDetProduto>() {

		@Override
		public int compare(PerdasDetProduto o1, PerdasDetProduto o2) {
			return o1.tmpParada.compareTo(o2.tmpParada) * -1;
		}
	};

	private static final Comparator<PerdasDetMaquina> comparaPerdasMaquinaTempo = new Comparator<PerdasDetMaquina>() {
		@Override
		public int compare(PerdasDetMaquina o1, PerdasDetMaquina o2) {
			return o1.tmpParada.compareTo(o2.tmpParada) * -1;
		}
	};
	

	
	
	private static final Comparator<PerdasDetArea> comparaPerdasAreaPerda = new Comparator<PerdasDetArea>() {
		@Override
		public int compare(PerdasDetArea o1, PerdasDetArea o2) {
			return o1.perdaOrdenacao.compareTo(o2.perdaOrdenacao) * -1;
		}
	};

	
	
	private static final Comparator<PerdasDetParada> comparaPerdasParadaPerda = new Comparator<PerdasDetParada>() {

		@Override
		public int compare(PerdasDetParada o1, PerdasDetParada o2) {
			return o1.perdaOrdenacao.compareTo(o2.perdaOrdenacao) * -1;
		}
	};
	
	
	private static final Comparator<PerdasDetProduto> comparaPerdasProdutoPerda = new Comparator<PerdasDetProduto>() {

		@Override
		public int compare(PerdasDetProduto o1, PerdasDetProduto o2) {
			return o1.perdaOrdenacao.compareTo(o2.perdaOrdenacao) * -1;
		}
	};

	private static final Comparator<PerdasDetMaquina> comparaPerdasMaquinaPerda = new Comparator<PerdasDetMaquina>() {
		@Override
		public int compare(PerdasDetMaquina o1, PerdasDetMaquina o2) {
			return o1.perdaOrdenacao.compareTo(o2.perdaOrdenacao) * -1;
		}
	};
	

	
	
	public BiWebGraficoPerdasAreaRespParDetInjetRN() {
		this(new DAOGenericoInjet());
	}

	public BiWebGraficoPerdasAreaRespParDetInjetRN(DAOGenericoInjet dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenericoInjet();
		}
		this.setDao(dao);
	}


	private String getConsultaParadasTempos(BiFiltroDTO filtroBI, Boolean isParComPeso, String cdArea, String cdParada, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		String strSQL;

		strSQL = "";
		strSQL = strSQL.concat("SELECT ar.cdarea, ar.dsarea, a.cdparada, tp.dsparada, ");

		strSQL = strSQL.concat("       COUNT(DISTINCT a.dthriparada) as qtdpar, ");

		if (isParComPeso) {
			strSQL = strSQL.concat("       SUM(a.tmpparadas) as tmpPar ");
		} else {
			strSQL = strSQL.concat("       SUM(a.tmpparadassempeso) as tmpPar ");
		}

		// tabelas
		strSQL = strSQL.concat("  FROM ijreaparcnsocorTUR a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijtbpar tp ON (tp.cdparada = a.cdparada) ");
		strSQL = strSQL.concat("  JOIN ijareres ar ON (ar.cdarea = tp.cdarea) ");
		strSQL = strSQL.concat("  JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL.concat("  JOIN ijmolpro mp ON (mp.cdmolde = ft.cdmolde AND mp.cdestrutura = ft.cdestrutura AND mp.dthrival = ft.dthrivalestru) ");


		if (!cdProdutoSelecaoPareto.equals("")) {
			strSQL = strSQL.concat("  JOIN ijfictec ft2 ON (ft2.cdinjetora = a.cdinjetora AND ft2.cdmolde = a.cdmolde AND ft2.cdestrutura = a.cdestrutura AND ft2.dthrivalcic = a.dthrivalcic) ");
			strSQL = strSQL.concat("  JOIN ijmolpro mp2 ON (mp2.cdmolde = ft2.cdmolde AND mp2.cdestrutura = ft2.cdestrutura AND mp2.dthrival = ft2.dthrivalestru AND mp2.cdproduto = :cdprodutoSelecaoPareto) ");
		}

		
		// tabelas relacionados a maquina
		if (filtroBI.getCdPt().equals("")) {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");
			} else {
				strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC cm ON (cm.cdinjetora = a.cdinjetora) ");	
			}
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");
		}

		// filtros
		strSQL = strSQL.concat(" WHERE a.dtturno BETWEEN :dtini AND :dtfim ");

		if (!cdParada.equals("")) {
			strSQL = strSQL.concat(" AND a.cdparada  = :cdparada ");
		}

		if (!cdArea.equals("")) {
			strSQL = strSQL.concat(" AND ar.cdarea  = :cdarea ");
		}

		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat(" AND mp.cdproduto  = :cdproduto ");
		}


		if (!cdPtSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND b.cdinjestendido  = :cdptSelecaoPareto ");
		}

		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cdturno = :cdturno ");
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

		strSQL = strSQL.concat(" GROUP BY ar.cdarea, ar.dsarea, a.cdparada, tp.dsparada ");

		return strSQL;
	}

	private String getConsultaParadasMicroPar(BiFiltroDTO filtroBI, Boolean isParComPeso, String cdArea, String cdParada, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		String strSQL;

		strSQL = "";
		strSQL = strSQL.concat("SELECT ar.cdarea, ar.dsarea, a.cdparada, tp.dsparada, ");
		strSQL = strSQL.concat("       COUNT(DISTINCT a.dthriparada) as qtdpar ");

		
		// tabelas
		strSQL = strSQL.concat("  FROM ijreaparcnsocorTUR a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijtbpar tp ON (tp.cdparada = a.cdparada) ");
		strSQL = strSQL.concat("  JOIN ijareres ar ON (ar.cdarea = tp.cdarea) ");
		strSQL = strSQL.concat("  JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL.concat("  JOIN ijmolpro mp ON (mp.cdmolde = ft.cdmolde AND mp.cdestrutura = ft.cdestrutura AND mp.dthrival = ft.dthrivalestru) ");

		if (!cdProdutoSelecaoPareto.equals("")) {
			strSQL = strSQL.concat("  JOIN ijfictec ft2 ON (ft2.cdinjetora = a.cdinjetora AND ft2.cdmolde = a.cdmolde AND ft2.cdestrutura = a.cdestrutura AND ft2.dthrivalcic = a.dthrivalcic) ");
			strSQL = strSQL.concat("  JOIN ijmolpro mp2 ON (mp2.cdmolde = ft2.cdmolde AND mp2.cdestrutura = ft2.cdestrutura AND mp2.dthrival = ft2.dthrivalestru AND mp2.cdproduto = :cdprodutoSelecaoPareto) ");
		}

		
		// tabelas relacionados a maquina
		if (filtroBI.getCdPt().equals("")) {			
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");
			} else {
				strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC cm ON (cm.cdinjetora = a.cdinjetora) ");
			}
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");
		}

		// filtros
		strSQL = strSQL.concat(" WHERE a.dtturno BETWEEN :dtini AND :dtfim ");

		if (!cdParada.equals("")) {
			strSQL = strSQL.concat(" AND a.cdparada  = :cdparada ");
		}

		if (!cdArea.equals("")) {
			strSQL = strSQL.concat(" AND ar.cdarea  = :cdarea ");
		}

		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat(" AND mp.cdproduto  = :cdproduto ");
		}

		if (!cdPtSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND b.cdinjestendido  = :cdptSelecaoPareto ");
		}

		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cdturno = :cdturno ");
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

				
		
		if (isParComPeso) {
			strSQL = strSQL.concat(" AND a.tmpparadas > 0 ");
			strSQL = strSQL.concat(" AND a.tmpparadas <= (SELECT MaxTmpMicroParada FROM IJconGER) ");
		} else {
			strSQL = strSQL.concat(" AND a.tmpparadassempeso > 0 ");
			strSQL = strSQL.concat(" AND a.tmpparadassempeso <= (SELECT MaxTmpMicroParada FROM IJconGER) ");
		}

		strSQL = strSQL.concat(" GROUP BY ar.cdarea, ar.dsarea, a.cdparada, tp.dsparada ");

		return strSQL;
	}

	
	private String getConsultaParadasProduto(BiFiltroDTO filtroBI, Boolean isParComPeso, String cdArea, String cdParada, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		String strSQL;

		strSQL = "";
		strSQL = strSQL.concat("SELECT tp.cdarea, a.cdparada, mp.cdproduto, f.dsproduto, b.cdinjestendido, b.cdidentific,  ");
		strSQL = strSQL.concat("      COUNT(DISTINCT a.dthriparada) as qtdpar, ");

		if (isParComPeso) {
			strSQL = strSQL.concat("       SUM(a.tmpparadas) as tmpPar, ");
			strSQL = strSQL.concat("       SUM( ((a.tmpparadas / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) as qtdPerdaPar, ");
			strSQL = strSQL.concat("       SUM( (((a.tmpparadas / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) * mp.pbrutomedio ) as qtdPerdaParGr, ");
			strSQL = strSQL.concat("       SUM( (((a.tmpparadas / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdPerdaParUM ");
		} else {
			strSQL = strSQL.concat("       SUM(a.tmpparadassempeso) as tmpPar, ");
			strSQL = strSQL.concat("       SUM( ((a.tmpparadassempeso / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) as qtdPerdaPar, ");
			strSQL = strSQL.concat("       SUM( (((a.tmpparadassempeso / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) * mp.pbrutomedio ) as qtdPerdaParGr, ");
			strSQL = strSQL.concat("       SUM( (((a.tmpparadassempeso / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdPerdaParUM ");
		}

		// tabelas
		strSQL = strSQL.concat("  FROM ijreaparcnsocorTUR a ");
		strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijtbpar tp ON (tp.cdparada = a.cdparada) ");
		strSQL = strSQL.concat("  JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL.concat("  JOIN ijmolpro mp ON (mp.cdmolde = ft.cdmolde AND mp.cdestrutura = ft.cdestrutura AND mp.dthrival = ft.dthrivalestru) ");
	
		
		if (!cdProdutoSelecaoPareto.equals("")) {
			strSQL = strSQL.concat("  JOIN ijfictec ft2 ON (ft2.cdinjetora = a.cdinjetora AND ft2.cdmolde = a.cdmolde AND ft2.cdestrutura = a.cdestrutura AND ft2.dthrivalcic = a.dthrivalcic) ");
			strSQL = strSQL.concat("  JOIN ijmolpro mp2 ON (mp2.cdmolde = ft2.cdmolde AND mp2.cdestrutura = ft2.cdestrutura AND mp2.dthrival = ft2.dthrivalestru AND mp2.cdproduto = :cdprodutoSelecaoPareto) ");
		}
		
		
		strSQL = strSQL.concat("  JOIN ijtbpro f ON (f.cdproduto = mp.cdproduto) ");
		
		
		// tabelas relacionados a maquina
		if (filtroBI.getCdPt().equals("")) {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");
			} else {
				strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC cm ON (cm.cdinjetora = a.cdinjetora) ");
			}			
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");
		}

		// filtros
		strSQL = strSQL.concat(" WHERE a.dtturno BETWEEN :dtini AND :dtfim ");

		if (!cdParada.equals("")) {
			strSQL = strSQL.concat(" AND a.cdparada  = :cdparada ");
		}
		if (!cdArea.equals("")) {
			strSQL = strSQL.concat(" AND tp.cdarea  = :cdarea ");
		}

		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat(" AND mp.cdproduto  = :cdproduto ");
		}


		if (!cdPtSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND b.cdinjestendido  = :cdptSelecaoPareto ");
		}
		
		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cdturno = :cdturno ");
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

		strSQL = strSQL.concat(" GROUP BY tp.cdarea, a.cdparada, mp.cdproduto, f.dsproduto, b.cdinjestendido, b.cdidentific ");

		return strSQL;
	}

	private String getConsultaParadasMicroParProduto(BiFiltroDTO filtroBI, Boolean isParComPeso, String cdArea, String cdParada, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		String strSQL;

		strSQL = "";
		strSQL = strSQL.concat("SELECT tp.cdarea, a.cdparada, mp.cdproduto, ");
		strSQL = strSQL.concat("      COUNT(DISTINCT a.dthriparada) as qtdpar ");
		// tabelas
		strSQL = strSQL.concat("  FROM ijreaparcnsocorTUR a ");
		strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijtbpar tp ON (tp.cdparada = a.cdparada) ");
		strSQL = strSQL.concat("  JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL.concat("  JOIN ijmolpro mp ON (mp.cdmolde = ft.cdmolde AND mp.cdestrutura = ft.cdestrutura AND mp.dthrival = ft.dthrivalestru) ");
		strSQL = strSQL.concat("  JOIN ijtbpro f ON (f.cdproduto = mp.cdproduto) ");
		

		if (!cdProdutoSelecaoPareto.equals("")) {
			strSQL = strSQL.concat("  JOIN ijfictec ft2 ON (ft2.cdinjetora = a.cdinjetora AND ft2.cdmolde = a.cdmolde AND ft2.cdestrutura = a.cdestrutura AND ft2.dthrivalcic = a.dthrivalcic) ");
			strSQL = strSQL.concat("  JOIN ijmolpro mp2 ON (mp2.cdmolde = ft2.cdmolde AND mp2.cdestrutura = ft2.cdestrutura AND mp2.dthrival = ft2.dthrivalestru AND mp2.cdproduto = :cdprodutoSelecaoPareto) ");
		}		
		
		// tabelas relacionados a maquina
		if (filtroBI.getCdPt().equals("")) {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");
			} else {
				if (!filtroBI.getCdClasseMaquina().equals("")) {
					strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC cm ON (cm.cdinjetora = a.cdinjetora) ");	
				}			
			}			
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");
		}

		// filtros
		strSQL = strSQL.concat(" WHERE a.dtturno BETWEEN :dtini AND :dtfim ");

		if (!cdParada.equals("")) {
			strSQL = strSQL.concat(" AND a.cdparada  = :cdparada ");
		}
		if (!cdArea.equals("")) {
			strSQL = strSQL.concat(" AND tp.cdarea  = :cdarea ");
		}		
		
		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat(" AND mp.cdproduto  = :cdproduto ");
		}
		
		if (!cdPtSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND b.cdinjestendido  = :cdptSelecaoPareto ");
		}

		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cdturno = :cdturno ");
		}

		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND b.cdinjestendido = :cdpt ");
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  AND gm.cdgrpinj = :cdgt ");
			} else {
				if (!filtroBI.getCdClasseMaquina().equals("")) {
					strSQL = strSQL.concat("  AND cm.classe = :cdclasse ");	
				}
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

		if (isParComPeso) {
			strSQL = strSQL.concat(" AND a.tmpparadas > 0 ");
			strSQL = strSQL.concat(" AND a.tmpparadas <= (SELECT MaxTmpMicroParada FROM IJconGER) ");
		} else {
			strSQL = strSQL.concat(" AND a.tmpparadassempeso > 0 ");
			strSQL = strSQL.concat(" AND a.tmpparadassempeso <= (SELECT MaxTmpMicroParada FROM IJconGER) ");
		}
		
		strSQL = strSQL.concat(" GROUP BY tp.cdarea, a.cdparada, mp.cdproduto ");

		return strSQL;
	}


	private SQLQuery setFiltrosNaQuery(SQLQuery q, BiFiltroDTO filtroBI, String cdArea, String cdParada, String cdPtSelecaoPareto,
			String cdProdutoSelecaoPareto) {
		
		q.setTimestamp("dthrini", filtroBI.getDtIniDt());
		q.setTimestamp("dthrfim", filtroBI.getDtFimDt());

		if (!cdParada.equals("")) {
			q.setString("cdparada", cdParada);
		}
		if (!cdArea.equals("")) {
			q.setString("cdarea", cdArea);
		}

		if (!cdPtSelecaoPareto.equals("")) {
			q.setString("cdptSelecaoPareto", cdPtSelecaoPareto);
		}

		if (!cdProdutoSelecaoPareto.equals("")) {
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

	private BigDecimal getValorPerda(UnidadeExibicaoOuOrdenacaoQtdBI ordenacao, RegistroParadaProduto registro) {
		BigDecimal valor = BigDecimal.ZERO;

		if (ordenacao == UnidadeExibicaoOuOrdenacaoQtdBI.QTD_PARETO_PERDAS_BI_EM_UB) {
			valor = registro.perdaUB;
		} else {
			if (ordenacao == UnidadeExibicaoOuOrdenacaoQtdBI.QTD_PARETO_PERDAS_BI_EM_UM) {
				valor = registro.perdaUM;
			} else {
				valor = registro.perdaGr;
			}
		}

		return valor;
	}
	
	@SuppressWarnings("unchecked")
	public BiParetoPerdasAreaRespParadaDetalheDTO getParetoPerdasParadaAreaRespDet(BiFiltroDTO filtroBIDet, UnidadeExibicaoOuOrdenacaoQtdBI ordenacao, Boolean isParComPeso, String cdArea, String cdParada, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		BiFiltroDTO filtroBI = new BiFiltroDTO();
		BiWebInjetRN biRN = new BiWebInjetRN(getDao(), BiResource.FORMATO_DATA, BiResource.FORMATO_DATA_HORA);
		filtroBI = biRN.filtroBiTransformado(filtroBIDet);
		
		BiParetoPerdasAreaRespParadaDetalheDTO resumo = new BiParetoPerdasAreaRespParadaDetalheDTO();
		resumo.setDetalhes(new ArrayList<BiParetoPerdasAreaRespParadaDetDTO>());
		BigDecimal totalCusto = BigDecimal.ZERO;
		
		Map<String, PerdasDetArea> mapResumo = new HashMap<String, PerdasDetArea>();
		
		int _cdarea = 0;
		int _dsarea = _cdarea + 1;
		int _cdparada = _dsarea + 1;
		int _dsparada = _cdparada + 1;	
		
		
		int _cdparadamp = _cdarea + 1;
		int _cdprodutomp = _cdparadamp + 1;
		int _qtdocorrparmp = _cdprodutomp + 1;
		
		int _qtdocorrpar = _dsparada + 1;
		int _tmppar = _qtdocorrpar + 1;
		
		int _cdparadaP = _cdarea + 1;
		int _cdproduto = _cdparadaP + 1;
		int _dsproduto = _cdproduto + 1;
		int _cdpt = _dsproduto + 1;
		int _dspt = _cdpt + 1;
		int _qtdocorrparp = _dspt + 1;
		int _tmpparP = _qtdocorrparp + 1;
		int _perdasUB = _tmpparP + 1;
		int _perdasGr = _perdasUB + 1;
		int _perdasUM = _perdasGr + 1;		
		
		
		
		
		// area resp / paradas - paradas 
		String strSQL = "";		
		List<Object>  lista = new ArrayList<Object>();
		strSQL = getConsultaParadasTempos(filtroBI, isParComPeso, cdArea, cdParada, cdPtSelecaoPareto, cdProdutoSelecaoPareto); 
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosNaQuery(q, filtroBI, cdArea, cdParada, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		
		lista = q.list();		
		for (Object reg : lista) {
			RegistroAreaParada registro = new RegistroAreaParada();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdArea = (String) registroLido[_cdarea];
			registro.dsArea = (String) registroLido[_dsarea];
			registro.cdParada = (String) registroLido[_cdparada];
			registro.dsParada = (String) registroLido[_dsparada];
			registro.segTempoPar = ConversaoTipos.converterParaBigDecimal(registroLido[_tmppar]);
			registro.qtdOcorrPar = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdocorrpar]);
			
			
			PerdasDetParada perdaParReg = new PerdasDetParada();
			perdaParReg.cdParada = registro.cdParada;
			perdaParReg.dsParada = registro.dsParada;
			perdaParReg.qtdOcorrPar = registro.qtdOcorrPar;
			perdaParReg.tmpParada = registro.segTempoPar;
			
			PerdasDetArea perdaAreaReg = new PerdasDetArea();
			perdaAreaReg.cdArea = registro.cdArea;
			perdaAreaReg.dsArea = registro.dsArea;
			perdaAreaReg.qtdOcorrPar = registro.qtdOcorrPar;
			perdaAreaReg.tmpParada = registro.segTempoPar;
			perdaAreaReg.paradas.put(registro.cdParada, perdaParReg);
						
			
			if (! mapResumo.containsKey(registro.cdArea)) {
				mapResumo.put(registro.cdArea, perdaAreaReg);
				
			} else {
				PerdasDetArea perdaArea = new PerdasDetArea();
				perdaArea = mapResumo.get(registro.cdArea);
				
				// atualiza area
				perdaArea.tmpParada = AritmeticaUtil.somar(perdaArea.tmpParada, registro.segTempoPar);
				perdaArea.qtdOcorrPar = AritmeticaUtil.somar(perdaArea.qtdOcorrPar, registro.qtdOcorrPar);
				
				
				if (! perdaArea.paradas.containsKey(registro.cdParada)) {
					PerdasDetParada perdaPar = new PerdasDetParada();
					
					perdaPar = perdaParReg;					
					perdaArea.paradas.put(registro.cdParada, perdaPar);
					
				} else {
					PerdasDetParada perdaPar = new PerdasDetParada();
					perdaPar = perdaArea.paradas.get(registro.cdParada);
				
					// atualiza tempos ferramenta
					perdaPar.tmpParada = AritmeticaUtil.somar(perdaPar.tmpParada, registro.segTempoPar);
					perdaPar.qtdOcorrPar = AritmeticaUtil.somar(perdaPar.qtdOcorrPar, registro.qtdOcorrPar);
					
					perdaArea.paradas.put(registro.cdArea, perdaPar);
				}

				
				mapResumo.remove(registro.cdArea);				
				mapResumo.put(registro.cdArea, perdaArea);
			}
		}
		

		
		// area resp / paradas - micro parada 
		strSQL = "";		
		lista = new ArrayList<Object>();
		strSQL = getConsultaParadasMicroPar(filtroBI, isParComPeso, cdArea, cdParada, cdPtSelecaoPareto, cdProdutoSelecaoPareto); 
		q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosNaQuery(q, filtroBI, cdArea, cdParada, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		
		lista = q.list();		
		for (Object reg : lista) {
			RegistroAreaParada registro = new RegistroAreaParada();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdArea = (String) registroLido[_cdarea];
			registro.cdParada = (String) registroLido[_cdparada];
			registro.qtdOcorrMicroPar = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdocorrpar]);
			
			
			// atualiza microparadas
			mapResumo.get(registro.cdArea).qtdOcorrMicroPar = AritmeticaUtil.somar(
					mapResumo.get(registro.cdArea).qtdOcorrMicroPar, 
					registro.qtdOcorrMicroPar);
			mapResumo.get(registro.cdArea).indiceMicroPar = new BigDecimal(
					FormulasInjet.calcularIndicePerda(
							mapResumo.get(registro.cdArea).qtdOcorrMicroPar,  
							mapResumo.get(registro.cdArea).qtdOcorrPar));

			mapResumo.get(registro.cdArea).paradas.get(registro.cdParada).qtdOcorrMicroPar = AritmeticaUtil.somar(
					mapResumo.get(registro.cdArea).paradas.get(registro.cdParada).qtdOcorrMicroPar, 
					registro.qtdOcorrMicroPar);
			mapResumo.get(registro.cdArea).paradas.get(registro.cdParada).indiceMicroPar = new BigDecimal(
					FormulasInjet.calcularIndicePerda(
							mapResumo.get(registro.cdArea).paradas.get(registro.cdParada).qtdOcorrMicroPar, 
							mapResumo.get(registro.cdArea).paradas.get(registro.cdParada).qtdOcorrPar));
			
		}
		

		
		
		// totais
		strSQL = "";		
		lista = new ArrayList<Object>();
		strSQL = getConsultaParadasProduto(filtroBI, isParComPeso, cdArea, cdParada, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosNaQuery(q, filtroBI, cdArea, cdParada, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		
		lista = q.list();		
		for (Object reg : lista) {		
			RegistroParadaProduto registro = new RegistroParadaProduto();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdArea = (String) registroLido[_cdarea];
			registro.cdParada = (String) registroLido[_cdparadaP];
			registro.cdProduto = (String) registroLido[_cdproduto];
			registro.dsProduto = (String) registroLido[_dsproduto];			
			registro.cdPt = (String) registroLido[_cdpt];
			registro.dsPt = (String) registroLido[_dspt];
			registro.qtdOcorrPar = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdocorrparp]);
			registro.segTempoPar = ConversaoTipos.converterParaBigDecimal(registroLido[_tmpparP]);
			registro.perdaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasUB]);
			registro.perdaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasGr]);
			registro.perdaUM = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasUM]);
			registro.perdaOrdenacao = getValorPerda(ordenacao, registro);
			
			
			PerdasDetMaquina perdaMaquinaReg = new PerdasDetMaquina();
			perdaMaquinaReg.cdPt = registro.cdPt;
			perdaMaquinaReg.cdIdentificacaoPt = registro.dsPt;
			perdaMaquinaReg.tmpParada = registro.segTempoPar;			
			perdaMaquinaReg.perdaUB = registro.perdaUB;
			perdaMaquinaReg.perdaGr = registro.perdaGr;
			perdaMaquinaReg.perdaUM = registro.perdaUM;
			perdaMaquinaReg.perdaOrdenacao = registro.perdaOrdenacao;
			
			PerdasDetProduto perdaProdutoReg = new PerdasDetProduto();
			perdaProdutoReg.cdProduto = registro.cdProduto;
			perdaProdutoReg.dsProduto = registro.dsProduto;
			perdaProdutoReg.qtdOcorrPar = registro.qtdOcorrPar;
			perdaProdutoReg.tmpParada = registro.segTempoPar;			
			perdaProdutoReg.perdaUB = registro.perdaUB;
			perdaProdutoReg.perdaGr = registro.perdaGr;
			perdaProdutoReg.perdaUM = registro.perdaUM;
			perdaProdutoReg.maquinas.put(registro.cdPt, perdaMaquinaReg);
			perdaProdutoReg.perdaOrdenacao = registro.perdaOrdenacao;
			
			PerdasDetParada perdaParadaReg = new PerdasDetParada();
			perdaParadaReg = mapResumo.get(registro.cdArea).paradas.get(registro.cdParada);
			perdaParadaReg.produtos.put(registro.cdProduto, perdaProdutoReg);
			
			PerdasDetArea perdaAreaReg = new PerdasDetArea();
			perdaAreaReg = mapResumo.get(registro.cdArea);
			perdaAreaReg.paradas.put(registro.cdParada, perdaParadaReg);
			mapResumo.put(registro.cdArea, perdaAreaReg);
			
			
			// atualiza perdas 
			
			// area resp
			mapResumo.get(registro.cdArea).perdaUB = AritmeticaUtil.somar(mapResumo.get(registro.cdArea).perdaUB, registro.perdaUB);
			mapResumo.get(registro.cdArea).perdaGr = AritmeticaUtil.somar(mapResumo.get(registro.cdArea).perdaGr, registro.perdaGr);
			mapResumo.get(registro.cdArea).perdaUM = AritmeticaUtil.somar(mapResumo.get(registro.cdArea).perdaUM, registro.perdaUM);
			mapResumo.get(registro.cdArea).perdaOrdenacao = AritmeticaUtil.somar(mapResumo.get(registro.cdArea).perdaUM, registro.perdaOrdenacao);
			
			
			// parada
			mapResumo.get(registro.cdArea).paradas.get(registro.cdParada).perdaUB = AritmeticaUtil.somar(mapResumo.get(registro.cdArea).paradas.get(registro.cdParada).perdaUB, registro.perdaUB);
			mapResumo.get(registro.cdArea).paradas.get(registro.cdParada).perdaGr = AritmeticaUtil.somar(mapResumo.get(registro.cdArea).paradas.get(registro.cdParada).perdaGr, registro.perdaGr);
			mapResumo.get(registro.cdArea).paradas.get(registro.cdParada).perdaUM = AritmeticaUtil.somar(mapResumo.get(registro.cdArea).paradas.get(registro.cdParada).perdaUM, registro.perdaUM);
			mapResumo.get(registro.cdArea).paradas.get(registro.cdParada).perdaOrdenacao = AritmeticaUtil.somar(mapResumo.get(registro.cdArea).paradas.get(registro.cdParada).perdaUM, registro.perdaOrdenacao);
			
			totalCusto = AritmeticaUtil.somar(totalCusto, registro.perdaUM);
		}
		

		// produto - micro parada 
		strSQL = "";		
		lista = new ArrayList<Object>();
		strSQL = getConsultaParadasMicroParProduto(filtroBI, isParComPeso, cdArea, cdParada, cdPtSelecaoPareto, cdProdutoSelecaoPareto); 
		q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosNaQuery(q, filtroBI, cdArea, cdParada, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		
		lista = q.list();		
		for (Object reg : lista) {
			RegistroParadaProduto registro = new RegistroParadaProduto();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdArea = (String) registroLido[_cdarea];
			registro.cdParada = (String) registroLido[_cdparadamp];
			registro.cdProduto = (String) registroLido[_cdprodutomp];
			registro.qtdOcorrMicroPar = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdocorrparmp]);
						
			// atualiza microparadas
			mapResumo.get(registro.cdArea).paradas.get(registro.cdParada).produtos.get(registro.cdProduto).qtdOcorrMicroPar = AritmeticaUtil.somar(
					mapResumo.get(registro.cdArea).paradas.get(registro.cdParada).produtos.get(registro.cdProduto).qtdOcorrMicroPar, 
					registro.qtdOcorrMicroPar);
			mapResumo.get(registro.cdArea).paradas.get(registro.cdParada).produtos.get(registro.cdProduto).indiceMicroPar = new BigDecimal(
					FormulasInjet.calcularIndicePerda(
							mapResumo.get(registro.cdArea).paradas.get(registro.cdParada).produtos.get(registro.cdProduto).qtdOcorrMicroPar, 
							mapResumo.get(registro.cdArea).paradas.get(registro.cdParada).produtos.get(registro.cdProduto).qtdOcorrPar));			
		}
		
				
		// Ordenacao area
		List<PerdasDetArea> listaArea = new ArrayList<PerdasDetArea>();
		listaArea.addAll(mapResumo.values());
		
		if (ordenacao.getValor() != 0) {
			Collections.sort(listaArea, comparaPerdasAreaPerda);
		} else {
			Collections.sort(listaArea, comparaPerdasAreaTempo);	
		}
		
		
		for (PerdasDetArea perdaArea : listaArea) {
			if (resumo.getDetalhes().size() > 0) {
				BiParetoPerdasAreaRespParadaDetDTO linhaDetPerdas =  getLinhaEmBranco();
				resumo.getDetalhes().add(linhaDetPerdas);
			}
			
			
			// Ordenacao por parada
			List<PerdasDetParada> listaPar = new ArrayList<PerdasDetParada>();
			listaPar.addAll(perdaArea.paradas.values());
			
			if (ordenacao.getValor() != 0) {
				Collections.sort(listaPar, comparaPerdasParadaPerda);
			} else {
				Collections.sort(listaPar, comparaPerdasParadaTempo);	
			}
			
			
			int contadorPar = 0;
			for (PerdasDetParada perdaPar : listaPar) {
				contadorPar++;
				
				// Ordenacao por produto
				List<PerdasDetProduto> listaPro = new ArrayList<PerdasDetProduto>();
				listaPro.addAll(perdaPar.produtos.values());
				
				if (ordenacao.getValor() != 0) {
					Collections.sort(listaPro, comparaPerdasProdutoPerda);
				} else {
					Collections.sort(listaPro, comparaPerdasProdutoTempo);	
				}
				
				
				int contadorPro = 0;
				for (PerdasDetProduto perdaPro : listaPro) {
					contadorPro++;
					
					// Ordenacao por maquina
					List<PerdasDetMaquina> listaMaq = new ArrayList<PerdasDetMaquina>();
					listaMaq.addAll(perdaPro.maquinas.values());

					if (ordenacao.getValor() != 0) {
						Collections.sort(listaMaq, comparaPerdasMaquinaPerda);
					} else {
						Collections.sort(listaMaq, comparaPerdasMaquinaTempo);	
					}
					
					
					int contadorMaq = 0;
					for (PerdasDetMaquina perdaMaq : listaMaq) {
						contadorMaq++;
						
						BiParetoPerdasAreaRespParadaDetDTO linhaDetPerdas =  getLinhaEmBranco();
						linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_SEM_COR);		
						
						if (contadorPar == 1 && contadorPro == 1 && contadorMaq == 1) {
							linhaDetPerdas.setAreaResponsavel(perdaArea.cdArea + " (" + perdaArea.dsArea + ")");	
						}
						
						if (contadorPro == 1 && contadorMaq == 1) {
							linhaDetPerdas.setParada(perdaPar.cdParada + " (" + perdaPar.dsParada + ")");
						}

						if (contadorMaq == 1) {
							linhaDetPerdas.setProduto(perdaPro.cdProduto + " (" + perdaPro.dsProduto + ")");
							linhaDetPerdas.setCdProduto(perdaPro.cdProduto);
						}
						
						
						linhaDetPerdas.setTempoPar(DataHoraRN.formatSegundosParaHHMMSS(perdaPro.tmpParada));
						linhaDetPerdas.setQtdOcorrPar(ConversaoTipos.converteParaString(perdaPro.qtdOcorrPar, 0));
						linhaDetPerdas.setQtdOcorrMicroPar(ConversaoTipos.converteParaString(perdaPro.qtdOcorrMicroPar, 0) + " ("  +  ConversaoTipos.converteParaString(perdaPro.indiceMicroPar, 2) + "%)");				
						
						
						linhaDetPerdas.setPt(perdaMaq.cdPt + " (" + perdaMaq.cdIdentificacaoPt + ")");
						linhaDetPerdas.setTempoParPt(DataHoraRN.formatSegundosParaHHMMSS(perdaMaq.tmpParada));
						linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaMaq.perdaUB));
						linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaMaq.perdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
						linhaDetPerdas.setPerdaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaMaq.perdaGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
						linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaMaq.perdaUM, 2));							
						
						resumo.getDetalhes().add(linhaDetPerdas);							
					}
					
				}

			}
			
			// perda da area
			BiParetoPerdasAreaRespParadaDetDTO linhaDetPerdas =  getLinhaEmBranco();
			linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_PERDA_PARADA_SUB_TOTAL_AREA);		
			linhaDetPerdas.setParada(TEXTO_CELULA_PERDA_PARADA_SUB_TOTAL_AREA);			
			
			linhaDetPerdas.setTempoPar(DataHoraRN.formatSegundosParaHHMMSS(perdaArea.tmpParada));
			linhaDetPerdas.setQtdOcorrPar(ConversaoTipos.converteParaString(perdaArea.qtdOcorrPar, 0));
			linhaDetPerdas.setQtdOcorrMicroPar(ConversaoTipos.converteParaString(perdaArea.qtdOcorrMicroPar, 0) + " ("  +  ConversaoTipos.converteParaString(perdaArea.indiceMicroPar, 2) + "%)");			
			
			linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaArea.perdaUB));
			linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaArea.perdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
			linhaDetPerdas.setPerdaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaArea.perdaGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
			linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaArea.perdaUM, 2));							
			resumo.getDetalhes().add(linhaDetPerdas);																	
			
		}
		
		resumo.setTotalCusto(ConversaoTipos.converteParaString(totalCusto, 2));
		resumo.setTempoDisponivel(filtroBI.getIndicadores().getHrsDisp());
		if (isParComPeso) {
			resumo.setTempoParadas(filtroBI.getIndicadores().getHrsParComPeso());
			resumo.setIndPar(filtroBI.getIndicadores().getIndPar());
		} else {
			resumo.setTempoParadas(filtroBI.getIndicadores().getHrsParSemPeso());
			resumo.setIndPar(filtroBI.getIndicadores().getIndPar());
		}
		
		return resumo;		
		
	}
	
	private BiParetoPerdasAreaRespParadaDetDTO getLinhaEmBranco() {
		BiParetoPerdasAreaRespParadaDetDTO linhaDetPerdas = new BiParetoPerdasAreaRespParadaDetDTO();
		linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_SEM_COR);
		
		linhaDetPerdas.setAreaResponsavel("");		
		linhaDetPerdas.setParada("");				
		linhaDetPerdas.setTempoPar("");
		linhaDetPerdas.setQtdOcorrPar("");
		linhaDetPerdas.setQtdOcorrMicroPar("");				
		linhaDetPerdas.setProduto("");
		linhaDetPerdas.setCdProduto("");
		linhaDetPerdas.setPt("");
		linhaDetPerdas.setTempoPar("");
		linhaDetPerdas.setPerdaUB("");
		linhaDetPerdas.setPerdaKg("");
		linhaDetPerdas.setPerdaTon("");
		linhaDetPerdas.setPerdaUM("");			
		
		return linhaDetPerdas;
	}
}
