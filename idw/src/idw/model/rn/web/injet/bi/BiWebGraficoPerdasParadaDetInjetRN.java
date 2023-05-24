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
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiParetoPerdasParadaDetDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiParetoPerdasParadaDetalheDTO;
import ms.util.ConversaoTipos;

public class BiWebGraficoPerdasParadaDetInjetRN extends AbstractRN<DAOGenericoInjet> {
	private static final String COR_CELULA_SEM_COR = "";
	private static final String COR_CELULA_PERDA_PARADA_SUB_TOTAL_MOLDE = "#f7c7bd";
	private static final String COR_CELULA_PERDA_PARADA_SUB_TOTAL_PRODUTO = "#e0e0e0";
	private static final String COR_CELULA_PERDA_PARADA_SUB_TOTAL_TURNO = "#bbfffe";
	private static final String COR_CELULA_PERDA_PARADA_SUB_TOTAL_MAQUINA = "#e0e0e0";

	private static final String TEXTO_CELULA_PERDA_PARADA_SUB_TOTAL_MOLDE = "TOTAL DA FERRAMENTA";
	private static final String TEXTO_CELULA_PERDA_PARADA_SUB_TOTAL_PRODUTO = "TOTAL DO PRODUTO";
	private static final String TEXTO_CELULA_PERDA_PARADA_SUB_TOTAL_MAQUINA = "TOTAL DO PT";

	private class RegistroParadaTempo {
		String cdPt;
		String dsPt;
		String cdFerramenta;
		String cdEstrutura;
		String cdParada;
		String dsParada;
		String cdTurno;
		String dsTurno;
		BigDecimal segTempoPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrMicroPar = BigDecimal.ZERO;
	}

	private class RegistroParadasQtd {
		String cdPt;
		String cdFerramenta;
		String cdEstrutura;
		String cdProduto;
		String dsProduto;
		String cdParada;
		String cdTurno;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal prodLiqUB = BigDecimal.ZERO;
		BigDecimal prodPrevUB = BigDecimal.ZERO;
	}

	private class RegistroMicroParadaProduto {
		String cdProduto;
		String cdFerramenta;
		String cdEstrutura;
		String cdPt;
		String cdParada;
		BigDecimal qtdOcorrMicroPar = BigDecimal.ZERO;
	}

	private class RegistroParadaProduto {
		String cdProduto;
		String dsProduto;
		String cdFerramenta;
		String cdEstrutura;
		String cdPt;
		String dsPt;
		String cdParada;
		String dsParada;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
		BigDecimal segTempoPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrMicroPar = BigDecimal.ZERO;
	}

	private class RegistroProdPrevProdBruta {
		String id;
		BigDecimal prodLiqUB = BigDecimal.ZERO;
		BigDecimal prodPrevUB = BigDecimal.ZERO;
	}

	private class PerdasMaqDetProduto {
		String cdProduto;
		String dsProduto;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal prodLiqUB = BigDecimal.ZERO;
		BigDecimal prodPrevUB = BigDecimal.ZERO;
		BigDecimal indiceUB = BigDecimal.ZERO;
	}

	private class PerdasMaqDetParada {
		String cdParada;
		String dsParada;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal prodLiqUB = BigDecimal.ZERO;
		BigDecimal prodPrevUB = BigDecimal.ZERO;
		BigDecimal tmpParada = BigDecimal.ZERO;
		BigDecimal qtdOcorrPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrMicroPar = BigDecimal.ZERO;
		BigDecimal indiceMicroPar = BigDecimal.ZERO;
		Map<String, PerdasMaqDetProduto> produtos = new HashMap<String, PerdasMaqDetProduto>();
	}

	private class PerdasMaqDetEstru {
		String cdEstrutura;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal prodLiqUB = BigDecimal.ZERO;
		BigDecimal prodPrevUB = BigDecimal.ZERO;
		BigDecimal indiceUB = BigDecimal.ZERO;
		BigDecimal tmpParada = BigDecimal.ZERO;
		BigDecimal qtdOcorrPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrMicroPar = BigDecimal.ZERO;
		BigDecimal indiceMicroPar = BigDecimal.ZERO;
		Map<String, PerdasMaqDetParada> paradas = new HashMap<String, PerdasMaqDetParada>();
	}

	private class PerdasMaqDetFerramenta {
		String cdFerramenta;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal prodLiqUB = BigDecimal.ZERO;
		BigDecimal indiceUB = BigDecimal.ZERO;
		BigDecimal prodPrevUB = BigDecimal.ZERO;
		BigDecimal tmpParada = BigDecimal.ZERO;
		BigDecimal qtdOcorrPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrMicroPar = BigDecimal.ZERO;
		BigDecimal indiceMicroPar = BigDecimal.ZERO;
		Map<String, PerdasMaqDetEstru> estruturas = new HashMap<String, PerdasMaqDetEstru>();
	}

	private class PerdasMaqDetTurno {
		String cdTurno;
		String dsTurno;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal prodLiqUB = BigDecimal.ZERO;
		BigDecimal prodPrevUB = BigDecimal.ZERO;
		BigDecimal indiceUB = BigDecimal.ZERO;
		BigDecimal tmpParada = BigDecimal.ZERO;
		BigDecimal qtdOcorrPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrMicroPar = BigDecimal.ZERO;
		BigDecimal indiceMicroPar = BigDecimal.ZERO;
	}

	private class PerdasMaqDetMaquina {
		String cdPt;
		String cdIdentificacaoPt;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal prodLiqUB = BigDecimal.ZERO;
		BigDecimal prodPrevUB = BigDecimal.ZERO;
		BigDecimal indiceUB = BigDecimal.ZERO;
		BigDecimal tmpParada = BigDecimal.ZERO;
		BigDecimal qtdOcorrPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrMicroPar = BigDecimal.ZERO;
		BigDecimal indiceMicroPar = BigDecimal.ZERO;
		Map<String, PerdasMaqDetFerramenta> ferramentas = new HashMap<String, PerdasMaqDetFerramenta>();
		Map<String, PerdasMaqDetTurno> turnos = new HashMap<String, PerdasMaqDetTurno>();
	}

	private class PerdasProDetParada {
		String cdParada;
		String dsParada;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
		BigDecimal tmpParada = BigDecimal.ZERO;
		BigDecimal qtdOcorrPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrMicroPar = BigDecimal.ZERO;
		BigDecimal indiceMicroPar = BigDecimal.ZERO;
	}

	private class PerdasProDetMaquina {
		String cdPt;
		String cdIdentificacaoPt;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
		BigDecimal tmpParada = BigDecimal.ZERO;
		BigDecimal qtdOcorrPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrMicroPar = BigDecimal.ZERO;
		BigDecimal indiceMicroPar = BigDecimal.ZERO;
		Map<String, PerdasProDetParada> paradas = new HashMap<String, PerdasProDetParada>();
	}

	private class PerdasProDetEstru {
		String cdEstrutura;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
		BigDecimal tmpParada = BigDecimal.ZERO;
		BigDecimal qtdOcorrPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrMicroPar = BigDecimal.ZERO;
		BigDecimal indiceMicroPar = BigDecimal.ZERO;
		Map<String, PerdasProDetMaquina> maquinas = new HashMap<String, PerdasProDetMaquina>();
	}

	private class PerdasProDetFerramenta {
		String cdFerramenta;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
		BigDecimal tmpParada = BigDecimal.ZERO;
		BigDecimal qtdOcorrPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrMicroPar = BigDecimal.ZERO;
		BigDecimal indiceMicroPar = BigDecimal.ZERO;
		Map<String, PerdasProDetEstru> estruturas = new HashMap<String, PerdasProDetEstru>();
	}

	private class PerdasProDetProduto {
		String cdProduto;
		String dsProduto;
		BigDecimal prodLiqUB = BigDecimal.ZERO;
		BigDecimal prodPrevUB = BigDecimal.ZERO;
		BigDecimal perdaUB = BigDecimal.ZERO;
		BigDecimal perdaGr = BigDecimal.ZERO;
		BigDecimal perdaUM = BigDecimal.ZERO;
		BigDecimal perdaOrdenacao = BigDecimal.ZERO;
		BigDecimal indiceUB = BigDecimal.ZERO;
		BigDecimal tmpParada = BigDecimal.ZERO;
		BigDecimal qtdOcorrPar = BigDecimal.ZERO;
		BigDecimal qtdOcorrMicroPar = BigDecimal.ZERO;
		BigDecimal indiceMicroPar = BigDecimal.ZERO;
		Map<String, PerdasProDetFerramenta> ferramentas = new HashMap<String, PerdasProDetFerramenta>();
	}

	private static final Comparator<PerdasMaqDetTurno> comparaPerdasMaqTur = new Comparator<PerdasMaqDetTurno>() {
		@Override
		public int compare(PerdasMaqDetTurno o1, PerdasMaqDetTurno o2) {
			return o1.cdTurno.compareTo(o2.cdTurno);
		}
	};

	private static final Comparator<PerdasMaqDetMaquina> comparaPerdasMaqMaq = new Comparator<PerdasMaqDetMaquina>() {
		@Override
		public int compare(PerdasMaqDetMaquina o1, PerdasMaqDetMaquina o2) {
			return o1.tmpParada.compareTo(o2.tmpParada) * -1;
		}
	};

	private static final Comparator<PerdasMaqDetFerramenta> comparaPerdasMaqMol = new Comparator<PerdasMaqDetFerramenta>() {

		@Override
		public int compare(PerdasMaqDetFerramenta o1, PerdasMaqDetFerramenta o2) {
			return o1.tmpParada.compareTo(o2.tmpParada) * -1;
		}
	};

	private static final Comparator<PerdasMaqDetEstru> comparaPerdasMaqEstru = new Comparator<PerdasMaqDetEstru>() {

		@Override
		public int compare(PerdasMaqDetEstru o1, PerdasMaqDetEstru o2) {
			return o1.tmpParada.compareTo(o2.tmpParada) * -1;
		}
	};

	private static final Comparator<PerdasMaqDetParada> comparaPerdasMaqParada = new Comparator<PerdasMaqDetParada>() {
		@Override
		public int compare(PerdasMaqDetParada o1, PerdasMaqDetParada o2) {
			return o1.tmpParada.compareTo(o2.tmpParada) * -1;
		}
	};

	private static final Comparator<PerdasMaqDetProduto> comparaPerdasMaqProduto = new Comparator<PerdasMaqDetProduto>() {
		@Override
		public int compare(PerdasMaqDetProduto o1, PerdasMaqDetProduto o2) {
			return o1.perdaUB.compareTo(o2.perdaUB) * -1;
		}
	};

	private static final Comparator<PerdasProDetProduto> comparaPerdasProProduto = new Comparator<PerdasProDetProduto>() {
		@Override
		public int compare(PerdasProDetProduto o1, PerdasProDetProduto o2) {
			return o1.perdaOrdenacao.compareTo(o2.perdaOrdenacao) * -1;
		}
	};

	private static final Comparator<PerdasProDetFerramenta> comparaPerdasProMol = new Comparator<PerdasProDetFerramenta>() {
		@Override
		public int compare(PerdasProDetFerramenta o1, PerdasProDetFerramenta o2) {
			return o1.perdaOrdenacao.compareTo(o2.perdaOrdenacao) * -1;
		}
	};

	private static final Comparator<PerdasProDetEstru> comparaPerdasProEstru = new Comparator<PerdasProDetEstru>() {
		@Override
		public int compare(PerdasProDetEstru o1, PerdasProDetEstru o2) {
			return o1.perdaOrdenacao.compareTo(o2.perdaOrdenacao) * -1;
		}
	};

	private static final Comparator<PerdasProDetMaquina> comparaPerdasProMaq = new Comparator<PerdasProDetMaquina>() {
		@Override
		public int compare(PerdasProDetMaquina o1, PerdasProDetMaquina o2) {
			return o1.perdaOrdenacao.compareTo(o2.perdaOrdenacao) * -1;
		}
	};

	private static final Comparator<PerdasProDetParada> comparaPerdasProPar = new Comparator<PerdasProDetParada>() {
		@Override
		public int compare(PerdasProDetParada o1, PerdasProDetParada o2) {
			return o1.tmpParada.compareTo(o2.tmpParada) * -1;
		}
	};

	public BiWebGraficoPerdasParadaDetInjetRN() {
		this(new DAOGenericoInjet());
	}

	public BiWebGraficoPerdasParadaDetInjetRN(DAOGenericoInjet dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenericoInjet();
		}
		this.setDao(dao);
	}

	private String getConsultaParadasQtde(BiFiltroDTO filtroBI, Boolean isParComPeso, String cdParada, String cdPtSelecaoPareto,
			String cdProdutoSelecaoPareto) {
		String strSQL;

		strSQL = "";
		strSQL = strSQL.concat(
				"SELECT b.cdinjestendido, b.cdidentific, c.cdmolestendido, a.cdestrutura, a.cdturno, tur.dsturno, mp.cdproduto, f.dsproduto,  a.cdparada, tp.dsparada, ");

		if (isParComPeso) {
			strSQL = strSQL.concat(
					"       SUM( ((a.tmpparadas / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) as qtdPerdaPar, ");
			strSQL = strSQL.concat(
					"       SUM( (((a.tmpparadas / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) * mp.pbrutomedio ) as qtdPerdaParGr, ");
			strSQL = strSQL.concat(
					"       SUM( (((a.tmpparadas / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdPerdaParUM ");
		} else {
			strSQL = strSQL.concat(
					"       SUM( ((a.tmpparadassempeso / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) as qtdPerdaPar, ");
			strSQL = strSQL.concat(
					"       SUM( (((a.tmpparadassempeso / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) * mp.pbrutomedio ) as qtdPerdaParGr, ");
			strSQL = strSQL.concat(
					"       SUM( (((a.tmpparadassempeso / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdPerdaParUM ");
		}

		// tabelas
		strSQL = strSQL.concat("  FROM ijreaparcnsocorTUR a ");
		strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijtbpar tp ON (tp.cdparada = a.cdparada) ");
		strSQL = strSQL.concat("  JOIN ijtbtur tur ON (tur.cdturno = a.cdturno) ");
		strSQL = strSQL.concat(
				"  JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL.concat(
				"  JOIN ijmolpro mp ON (mp.cdmolde = ft.cdmolde AND mp.cdestrutura = ft.cdestrutura AND mp.dthrival = ft.dthrivalestru) ");
		strSQL = strSQL.concat("  JOIN ijtbpro f ON (f.cdproduto = mp.cdproduto) ");

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

		if (!cdParada.equals("")) {
			strSQL = strSQL.concat(" AND a.cdparada  = :cdparada ");
		}
		if (!cdPtSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND b.cdinjestendido  = :cdptSelecaoPareto ");
		}
		if (!cdProdutoSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND mp.cdproduto  = :cdprodutoSelecaoPareto ");
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

		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat("  AND mp.cdproduto = :cdproduto ");
		}

		strSQL = strSQL.concat(
				" GROUP BY b.cdinjestendido, b.cdidentific, c.cdmolestendido, a.cdestrutura, a.cdturno, tur.dsturno, mp.cdproduto, f.dsproduto,  a.cdparada, tp.dsparada ");

		return strSQL;
	}

	private String getConsultaParadasTempos(BiFiltroDTO filtroBI, Boolean isParComPeso, String cdParada, String cdPtSelecaoPareto,
			String cdProdutoSelecaoPareto) {
		String strSQL;

		strSQL = "";
		strSQL = strSQL.concat(
				"SELECT b.cdinjestendido, b.cdidentific, c.cdmolestendido, a.cdestrutura, a.cdturno, tur.dsturno, a.cdparada, tp.dsparada, ");
		strSQL = strSQL.concat("       COUNT(DISTINCT a.dthriparada) as qtdpar, ");

		if (isParComPeso) {
			strSQL = strSQL.concat("       SUM(a.tmpparadas) as tmpPar ");
		} else {
			strSQL = strSQL.concat("       SUM(a.tmpparadassempeso) as tmpPar ");
		}

		// tabelas
		strSQL = strSQL.concat("  FROM ijreaparcnsocorTUR a ");
		strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijtbpar tp ON (tp.cdparada = a.cdparada) ");
		strSQL = strSQL.concat("  JOIN ijtbtur tur ON (tur.cdturno = a.cdturno) ");

		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat(
					"  JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic) ");
			strSQL = strSQL.concat(
					"  JOIN ijmolpro mp ON (mp.cdmolde = ft.cdmolde AND mp.cdestrutura = ft.cdestrutura AND mp.dthrival = ft.dthrivalestru AND mp.cdproduto = :cdproduto) ");
		}

		if (!cdProdutoSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(
					"  JOIN ijfictec ft2 ON (ft2.cdinjetora = a.cdinjetora AND ft2.cdmolde = a.cdmolde AND ft2.cdestrutura = a.cdestrutura AND ft2.dthrivalcic = a.dthrivalcic) ");
			strSQL = strSQL.concat(
					"  JOIN ijmolpro mp2 ON (mp2.cdmolde = ft2.cdmolde AND mp2.cdestrutura = ft2.cdestrutura AND mp2.dthrival = ft2.dthrivalestru AND mp2.cdproduto = :cdprodutoSelecaoPareto) ");
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

		if (!cdParada.equals("")) {
			strSQL = strSQL.concat(" AND a.cdparada  = :cdparada ");
		}
		if (!cdPtSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND b.cdinjestendido  = :cdptSelecaoPareto ");
		}
		if (!cdProdutoSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND mp2.cdproduto  = :cdprodutoSelecaoPareto ");
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

		strSQL = strSQL
				.concat(" GROUP BY b.cdinjestendido, b.cdidentific, c.cdmolestendido, a.cdestrutura,  a.cdturno, tur.dsturno,  a.cdparada, tp.dsparada ");

		return strSQL;
	}

	private String getConsultaParadasMicroPar(BiFiltroDTO filtroBI, Boolean isParComPeso, String cdParada, String cdPtSelecaoPareto,
			String cdProdutoSelecaoPareto) {
		String strSQL;

		strSQL = "";
		strSQL = strSQL
				.concat("SELECT b.cdinjestendido, c.cdmolestendido, a.cdestrutura,  a.cdturno, a.cdparada, ");

		strSQL = strSQL.concat("       COUNT(DISTINCT a.dthriparada) as qtdpar ");

		// tabelas
		strSQL = strSQL.concat("  FROM ijreaparcnsocorTUR a ");
		strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");

		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat(
					"  JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic) ");
			strSQL = strSQL.concat(
					"  JOIN ijmolpro mp ON (mp.cdmolde = ft.cdmolde AND mp.cdestrutura = ft.cdestrutura AND mp.dthrival = ft.dthrivalestru AND mp.cdproduto = :cdproduto) ");
		}

		if (!cdProdutoSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(
					"  JOIN ijfictec ft2 ON (ft2.cdinjetora = a.cdinjetora AND ft2.cdmolde = a.cdmolde AND ft2.cdestrutura = a.cdestrutura AND ft2.dthrivalcic = a.dthrivalcic) ");
			strSQL = strSQL.concat(
					"  JOIN ijmolpro mp2 ON (mp2.cdmolde = ft2.cdmolde AND mp2.cdestrutura = ft2.cdestrutura AND mp2.dthrival = ft2.dthrivalestru AND mp2.cdproduto = :cdprodutoSelecaoPareto) ");
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

		if (!cdParada.equals("")) {
			strSQL = strSQL.concat(" AND a.cdparada  = :cdparada ");
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

		strSQL = strSQL
				.concat(" GROUP BY b.cdinjestendido, c.cdmolestendido, a.cdestrutura,  a.cdturno, a.cdparada ");

		return strSQL;
	}

	private String getConsultaProdLiquidaProdPrev(BiFiltroDTO filtroBI, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		String strSQL;

		strSQL = "";
		strSQL = strSQL.concat("SELECT a.cdinjestendido, a.cdmolestendido, a.cdestrutura, a.cdturno, a.cdproduto,  ");
		strSQL = strSQL.concat("       SUM(a.prodbruta - a.prodrefugada ) as prodliquida, ");
		strSQL = strSQL.concat("       SUM(a.prodprev) as prodprev ");

		// tabelas
		strSQL = strSQL.concat("  FROM viewBIDtRefProdutos a ");

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

		if (!cdPtSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND a.cdinjestendido  = :cdptSelecaoPareto ");
		}
		if (!cdProdutoSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND a.cdproduto  = :cdprodutoSelecaoPareto ");
		}

		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cdturno = :cdturno ");
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

		strSQL = strSQL.concat(" GROUP BY a.cdinjestendido, a.cdmolestendido, a.cdestrutura, a.cdturno, a.cdproduto ");

		return strSQL;
	}

	private String getConsultaParadasProduto(BiFiltroDTO filtroBI, Boolean isParComPeso, String cdParada, String cdPtSelecaoPareto,
			String cdProdutoSelecaoPareto) {
		String strSQL;

		strSQL = "";
		strSQL = strSQL.concat(
				"SELECT mp.cdproduto, f.dsproduto,  c.cdmolestendido, a.cdestrutura, b.cdinjestendido, b.cdidentific, a.cdparada, tp.dsparada, ");

		strSQL = strSQL.concat("       COUNT(DISTINCT a.dthriparada) as qtdpar, ");

		if (isParComPeso) {
			strSQL = strSQL.concat("       SUM(a.tmpparadas) as tmpPar, ");
			strSQL = strSQL.concat(
					"       SUM( ((a.tmpparadas / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) as qtdPerdaPar, ");
			strSQL = strSQL.concat(
					"       SUM( (((a.tmpparadas / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) * mp.pbrutomedio ) as qtdPerdaParGr, ");
			strSQL = strSQL.concat(
					"       SUM( (((a.tmpparadas / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdPerdaParUM ");
		} else {
			strSQL = strSQL.concat("       SUM(a.tmpparadassempeso) as tmpPar, ");
			strSQL = strSQL.concat(
					"       SUM( ((a.tmpparadassempeso / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) as qtdPerdaPar, ");
			strSQL = strSQL.concat(
					"       SUM( (((a.tmpparadassempeso / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) * mp.pbrutomedio ) as qtdPerdaParGr, ");
			strSQL = strSQL.concat(
					"       SUM( (((a.tmpparadassempeso / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdPerdaParUM ");
		}

		// tabelas
		strSQL = strSQL.concat("  FROM ijreaparcnsocorTUR a ");
		strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijtbpar tp ON (tp.cdparada = a.cdparada) ");
		strSQL = strSQL.concat(
				"  JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL.concat(
				"  JOIN ijmolpro mp ON (mp.cdmolde = ft.cdmolde AND mp.cdestrutura = ft.cdestrutura AND mp.dthrival = ft.dthrivalestru) ");
		strSQL = strSQL.concat("  JOIN ijtbpro f ON (f.cdproduto = mp.cdproduto) ");

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

		if (!cdParada.equals("")) {
			strSQL = strSQL.concat(" AND a.cdparada  = :cdparada ");
		}
		if (!cdPtSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND b.cdinjestendido  = :cdptSelecaoPareto ");
		}
		if (!cdProdutoSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND mp.cdproduto  = :cdprodutoSelecaoPareto ");
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

		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat(" AND mp.cdproduto  = :cdproduto ");
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND c.cdmolestendido = :cdrap ");
		}

		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");
		}

		strSQL = strSQL.concat(
				" GROUP BY mp.cdproduto, f.dsproduto,  c.cdmolestendido, a.cdestrutura, b.cdinjestendido, b.cdidentific, a.cdparada, tp.dsparada ");

		return strSQL;
	}

	private String getConsultaParadasMicroParProduto(BiFiltroDTO filtroBI, Boolean isParComPeso, String cdParada, String cdPtSelecaoPareto,
			String cdProdutoSelecaoPareto) {
		String strSQL;

		strSQL = "";
		strSQL = strSQL.concat("SELECT mp.cdproduto, c.cdmolestendido, a.cdestrutura, b.cdinjestendido, a.cdparada, ");

		strSQL = strSQL.concat("       COUNT(DISTINCT a.dthriparada) as qtdpar, ");

		if (isParComPeso) {
			strSQL = strSQL.concat("       SUM(a.tmpparadas) as tmpPar, ");
			strSQL = strSQL.concat(
					"       SUM( ((a.tmpparadas / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) as qtdPerdaPar, ");
			strSQL = strSQL.concat(
					"       SUM( (((a.tmpparadas / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) * mp.pbrutomedio ) as qtdPerdaParGr, ");
			strSQL = strSQL.concat(
					"       SUM( (((a.tmpparadas / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdPerdaParUM ");
		} else {
			strSQL = strSQL.concat("       SUM(a.tmpparadassempeso) as tmpPar, ");
			strSQL = strSQL.concat(
					"       SUM( ((a.tmpparadassempeso / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) as qtdPerdaPar, ");
			strSQL = strSQL.concat(
					"       SUM( (((a.tmpparadassempeso / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) * mp.pbrutomedio ) as qtdPerdaParGr, ");
			strSQL = strSQL.concat(
					"       SUM( (((a.tmpparadassempeso / ft.ciclopadrao)  * (mp.qtcavativas * ft.fatorcontagemprod)) / dc.divisorUB) * (CASE WHEN f.vlproduto IS NULL THEN 0 ELSE f.vlproduto END)) as qtdPerdaParUM ");
		}

		// tabelas
		strSQL = strSQL.concat("  FROM ijreaparcnsocorTUR a ");
		strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol c ON (c.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat(
				"  JOIN ijfictec ft ON (ft.cdinjetora = a.cdinjetora AND ft.cdmolde = a.cdmolde AND ft.cdestrutura = a.cdestrutura AND ft.dthrivalcic = a.dthrivalcic) ");
		strSQL = strSQL.concat(
				"  JOIN ijmolpro mp ON (mp.cdmolde = ft.cdmolde AND mp.cdestrutura = ft.cdestrutura AND mp.dthrival = ft.dthrivalestru)");
		strSQL = strSQL.concat("  JOIN ijtbpro f ON (f.cdproduto = mp.cdproduto) ");

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

		if (!cdParada.equals("")) {
			strSQL = strSQL.concat(" AND a.cdparada  = :cdparada ");
		}
		if (!cdPtSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND b.cdinjestendido  = :cdptSelecaoPareto ");
		}
		if (!cdProdutoSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND mp.cdproduto  = :cdprodutoSelecaoPareto ");
		}

		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat(" AND mp.cdproduto  = :cdproduto ");
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

		strSQL = strSQL.concat(" GROUP BY mp.cdproduto, c.cdmolestendido, a.cdestrutura, b.cdinjestendido, a.cdparada ");

		return strSQL;
	}

	private String getConsultaProdLiquidaProdPrevProduto(BiFiltroDTO filtroBI, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		String strSQL;

		strSQL = "";
		strSQL = strSQL.concat("SELECT a.cdproduto,  ");
		strSQL = strSQL.concat("       SUM(a.prodbruta - a.prodrefugada ) as prodliquida, ");
		strSQL = strSQL.concat("       SUM(a.prodprev) as prodprev ");

		// tabelas
		strSQL = strSQL.concat("  FROM viewBIDtRefProdutos a ");

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

		if (!cdPtSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND a.cdinjestendido  = :cdptSelecaoPareto ");
		}
		if (!cdProdutoSelecaoPareto.equals("")) {
			strSQL = strSQL.concat(" AND a.cdproduto  = :cdprodutoSelecaoPareto ");
		}

		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cdturno = :cdturno ");
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

		strSQL = strSQL.concat(" GROUP BY a.cdproduto ");

		return strSQL;
	}

	private SQLQuery setFiltrosNaQuery(SQLQuery q, BiFiltroDTO filtroBI, String cdParada, String cdPtSelecaoPareto,
			String cdProdutoSelecaoPareto) {
		q.setTimestamp("dthrini", filtroBI.getDtIniDt());
		q.setTimestamp("dthrfim", filtroBI.getDtFimDt());

		if (!cdParada.equals("")) {
			q.setString("cdparada", cdParada);
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
	public BiParetoPerdasParadaDetalheDTO getParetoPerdasParadaMaqDet(BiFiltroDTO filtroBIDet, Boolean isParComPeso, String cdParada,
			String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		BiFiltroDTO filtroBI = new BiFiltroDTO();
		BiWebInjetRN biRN = new BiWebInjetRN(getDao(), BiResource.FORMATO_DATA, BiResource.FORMATO_DATA_HORA);
		filtroBI = biRN.filtroBiTransformado(filtroBIDet);

		BiParetoPerdasParadaDetalheDTO resumo = new BiParetoPerdasParadaDetalheDTO();
		resumo.setDetalhes(new ArrayList<BiParetoPerdasParadaDetDTO>());
		BigDecimal totalCusto = BigDecimal.ZERO;

		Map<String, PerdasMaqDetMaquina> mapResumo = new HashMap<String, PerdasMaqDetMaquina>();
		Map<String, RegistroProdPrevProdBruta> mapPBPP_MFEP = new HashMap<String, RegistroProdPrevProdBruta>();
		Map<String, RegistroProdPrevProdBruta> mapPBPP_MFE = new HashMap<String, RegistroProdPrevProdBruta>();
		Map<String, RegistroProdPrevProdBruta> mapPBPP_MF = new HashMap<String, RegistroProdPrevProdBruta>();
		Map<String, RegistroProdPrevProdBruta> mapPBPP_MT = new HashMap<String, RegistroProdPrevProdBruta>();
		Map<String, RegistroProdPrevProdBruta> mapPBPP_M = new HashMap<String, RegistroProdPrevProdBruta>();

		int _cdpt = 0;
		int _dspt = _cdpt + 1;
		int _cdferramenta = _dspt + 1;
		int _cdestrutura = _cdferramenta + 1;
		int _cdturno = _cdestrutura + 1;
		int _dsturno = _cdturno + 1;

		// tempos
		int _cdparadat = _dsturno + 1;
		int _dsparadat = _cdparadat + 1;
		int _qtdocorrpart = _dsparadat + 1;
		int _tmppart = _qtdocorrpart + 1;

		// microparadas
		int _cdferramentaMP = _cdpt + 1;
		int _cdestruturaMP = _cdferramentaMP + 1;
		int _cdturnoMP = _cdestruturaMP + 1;
		int _cdparadaMP = _cdturnoMP + 1;
		int _qtdocorrMP = _cdparadaMP + 1;

		// quantiades
		int _cdproduto = _dsturno + 1;
		int _dsproduto = _cdproduto + 1;
		int _cdparada = _dsproduto + 1;
		int _dsparada = _cdparada + 1;
		int _perdasUB = _dsparada + 1;
		int _perdasGr = _perdasUB + 1;
		int _perdasUM = _perdasGr + 1;

		// prodbruta liq e prevista
		int _cdptpp = 0;
		int _cdferramentapp = _cdptpp + 1;
		int _cdestruturapp = _cdferramentapp + 1;
		int _cdturnopp = _cdestruturapp + 1;
		int _cdprodutopp = _cdturnopp + 1;
		int _prodliqUB = _cdprodutopp + 1;
		int _prodprevUB = _prodliqUB + 1;

		// producao bruta e prevista
		String strSQL = "";
		List<Object> lista = new ArrayList<Object>();
		strSQL = getConsultaProdLiquidaProdPrev(filtroBI, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosNaQuery(q, filtroBI, "", cdPtSelecaoPareto, cdProdutoSelecaoPareto);

		lista = q.list();
		for (Object reg : lista) {
			RegistroParadasQtd registro = new RegistroParadasQtd();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdPt = (String) registroLido[_cdptpp];
			registro.cdTurno = (String) registroLido[_cdturnopp];
			registro.cdFerramenta = (String) registroLido[_cdferramentapp];
			registro.cdEstrutura = (String) registroLido[_cdestruturapp];
			registro.cdProduto = (String) registroLido[_cdprodutopp];
			registro.prodLiqUB = ConversaoTipos.converterParaBigDecimal(registroLido[_prodliqUB]);
			registro.prodPrevUB = ConversaoTipos.converterParaBigDecimal(registroLido[_prodprevUB]);

			String keyM = registro.cdPt;
			String keyMT = keyM + registro.cdTurno;
			String keyMF = keyM + registro.cdFerramenta;
			String keyMFE = keyMF + registro.cdEstrutura;
			String keyMFEP = keyMFE + registro.cdProduto;

			// maquinas
			if (!mapPBPP_M.containsKey(keyM)) {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP.id = keyM;
				prodBP.prodLiqUB = registro.prodLiqUB;
				prodBP.prodPrevUB = registro.prodPrevUB;

				mapPBPP_M.put(keyM, prodBP);

			} else {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP = mapPBPP_M.get(keyM);

				prodBP.prodLiqUB = AritmeticaUtil.somar(prodBP.prodLiqUB, registro.prodLiqUB);
				prodBP.prodPrevUB = AritmeticaUtil.somar(prodBP.prodPrevUB, registro.prodPrevUB);

				mapPBPP_M.put(keyM, prodBP);
			}

			// turno
			if (!mapPBPP_MT.containsKey(keyMT)) {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP.id = keyMT;
				prodBP.prodLiqUB = registro.prodLiqUB;
				prodBP.prodPrevUB = registro.prodPrevUB;

				mapPBPP_MT.put(keyMT, prodBP);

			} else {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP = mapPBPP_MT.get(keyMT);

				prodBP.prodLiqUB = AritmeticaUtil.somar(prodBP.prodLiqUB, registro.prodLiqUB);
				prodBP.prodPrevUB = AritmeticaUtil.somar(prodBP.prodPrevUB, registro.prodPrevUB);

				mapPBPP_MT.put(keyMT, prodBP);
			}

			// ferramentas
			if (!mapPBPP_MF.containsKey(keyMF)) {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP.id = keyMF;
				prodBP.prodLiqUB = registro.prodLiqUB;
				prodBP.prodPrevUB = registro.prodPrevUB;

				mapPBPP_MF.put(keyMF, prodBP);

			} else {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP = mapPBPP_MF.get(keyMF);

				prodBP.prodLiqUB = AritmeticaUtil.somar(prodBP.prodLiqUB, registro.prodLiqUB);
				prodBP.prodPrevUB = AritmeticaUtil.somar(prodBP.prodPrevUB, registro.prodPrevUB);

				mapPBPP_MF.put(keyMF, prodBP);
			}

			// estrutruas
			if (!mapPBPP_MFE.containsKey(keyMFE)) {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP.id = keyMF;
				prodBP.prodLiqUB = registro.prodLiqUB;
				prodBP.prodPrevUB = registro.prodPrevUB;

				mapPBPP_MFE.put(keyMFE, prodBP);

			} else {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP = mapPBPP_MFE.get(keyMFE);

				prodBP.prodLiqUB = AritmeticaUtil.somar(prodBP.prodLiqUB, registro.prodLiqUB);
				prodBP.prodPrevUB = AritmeticaUtil.somar(prodBP.prodPrevUB, registro.prodPrevUB);

				mapPBPP_MFE.put(keyMFE, prodBP);
			}

			// produtos
			if (!mapPBPP_MFEP.containsKey(keyMFEP)) {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP.id = keyMF;
				prodBP.prodLiqUB = registro.prodLiqUB;
				prodBP.prodPrevUB = registro.prodPrevUB;

				mapPBPP_MFEP.put(keyMFEP, prodBP);

			} else {
				RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
				prodBP = mapPBPP_MFEP.get(keyMFEP);

				prodBP.prodLiqUB = AritmeticaUtil.somar(prodBP.prodLiqUB, registro.prodLiqUB);
				prodBP.prodPrevUB = AritmeticaUtil.somar(prodBP.prodPrevUB, registro.prodPrevUB);

				mapPBPP_MFEP.put(keyMFEP, prodBP);
			}
		}

		// paradas - tempo e qtd ocorr
		strSQL = "";
		lista = new ArrayList<Object>();
		strSQL = getConsultaParadasTempos(filtroBI, isParComPeso, cdParada, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosNaQuery(q, filtroBI, cdParada, cdPtSelecaoPareto, cdProdutoSelecaoPareto);

		lista = q.list();
		for (Object reg : lista) {
			RegistroParadaTempo registro = new RegistroParadaTempo();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdPt = (String) registroLido[_cdpt];
			registro.dsPt = (String) registroLido[_dspt];
			registro.cdFerramenta = (String) registroLido[_cdferramenta];
			registro.cdEstrutura = (String) registroLido[_cdestrutura];
			registro.cdTurno = (String) registroLido[_cdturno];
			registro.dsTurno = (String) registroLido[_dsturno];
			registro.cdParada = (String) registroLido[_cdparadat];
			registro.dsParada = (String) registroLido[_dsparadat];
			registro.segTempoPar = ConversaoTipos.converterParaBigDecimal(registroLido[_tmppart]);
			registro.qtdOcorrPar = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdocorrpart]);

			String keyM = registro.cdPt;
			String keyMT = keyM + registro.cdTurno;
			String keyMF = keyM + registro.cdFerramenta;
			String keyMFE = keyMF + registro.cdEstrutura;

			PerdasMaqDetParada perdaParadaReg = new PerdasMaqDetParada();
			perdaParadaReg.cdParada = registro.cdParada;
			perdaParadaReg.dsParada = registro.dsParada;
			perdaParadaReg.tmpParada = registro.segTempoPar;
			perdaParadaReg.qtdOcorrPar = registro.qtdOcorrPar;

			PerdasMaqDetEstru perdaEstruturaReg = new PerdasMaqDetEstru();
			perdaEstruturaReg.cdEstrutura = registro.cdEstrutura;
			perdaEstruturaReg.tmpParada = registro.segTempoPar;
			perdaEstruturaReg.qtdOcorrPar = registro.qtdOcorrPar;
			perdaEstruturaReg.paradas.put(registro.cdParada, perdaParadaReg);

			perdaEstruturaReg.prodLiqUB = mapPBPP_MFE.get(keyMFE).prodLiqUB;
			perdaEstruturaReg.prodPrevUB = mapPBPP_MFE.get(keyMFE).prodPrevUB;

			PerdasMaqDetFerramenta perdaFerramentaReg = new PerdasMaqDetFerramenta();
			perdaFerramentaReg.cdFerramenta = registro.cdFerramenta;
			perdaFerramentaReg.tmpParada = registro.segTempoPar;
			perdaFerramentaReg.qtdOcorrPar = registro.qtdOcorrPar;
			perdaFerramentaReg.estruturas.put(registro.cdEstrutura, perdaEstruturaReg);

			perdaFerramentaReg.prodLiqUB = mapPBPP_MF.get(keyMF).prodLiqUB;
			perdaFerramentaReg.prodPrevUB = mapPBPP_MF.get(keyMF).prodPrevUB;

			PerdasMaqDetTurno perdaTurnoReg = new PerdasMaqDetTurno();
			perdaTurnoReg.cdTurno = registro.cdTurno;
			perdaTurnoReg.dsTurno = registro.dsTurno;
			perdaTurnoReg.tmpParada = registro.segTempoPar;
			perdaTurnoReg.qtdOcorrPar = registro.qtdOcorrPar;

			perdaTurnoReg.prodLiqUB = mapPBPP_MT.get(keyMT).prodLiqUB;
			perdaTurnoReg.prodPrevUB = mapPBPP_MT.get(keyMT).prodPrevUB;

			PerdasMaqDetMaquina perdaMaquinaReg = new PerdasMaqDetMaquina();
			perdaMaquinaReg.cdPt = registro.cdPt;
			perdaMaquinaReg.cdIdentificacaoPt = registro.dsPt;
			perdaMaquinaReg.tmpParada = registro.segTempoPar;
			perdaMaquinaReg.qtdOcorrPar = registro.qtdOcorrPar;
			perdaMaquinaReg.ferramentas.put(registro.cdFerramenta, perdaFerramentaReg);
			perdaMaquinaReg.turnos.put(registro.cdTurno, perdaTurnoReg);

			perdaMaquinaReg.prodLiqUB = mapPBPP_M.get(keyM).prodLiqUB;
			perdaMaquinaReg.prodPrevUB = mapPBPP_M.get(keyM).prodPrevUB;

			if (!mapResumo.containsKey(registro.cdPt)) {
				mapResumo.put(registro.cdPt, perdaMaquinaReg);

			} else {
				PerdasMaqDetMaquina perdaMaquina = new PerdasMaqDetMaquina();
				perdaMaquina = mapResumo.get(registro.cdPt);

				// atualiza tempos maquina
				perdaMaquina.tmpParada = AritmeticaUtil.somar(perdaMaquina.tmpParada, registro.segTempoPar);
				perdaMaquina.qtdOcorrPar = AritmeticaUtil.somar(perdaMaquina.qtdOcorrPar, registro.qtdOcorrPar);

				if (!perdaMaquina.ferramentas.containsKey(registro.cdFerramenta)) {
					PerdasMaqDetFerramenta perdaFerramenta = new PerdasMaqDetFerramenta();

					perdaFerramenta = perdaFerramentaReg;
					perdaMaquina.ferramentas.put(registro.cdFerramenta, perdaFerramenta);

				} else {
					PerdasMaqDetFerramenta perdaFerramenta = new PerdasMaqDetFerramenta();
					perdaFerramenta = perdaMaquina.ferramentas.get(registro.cdFerramenta);

					// atualiza tempos ferramenta
					perdaFerramenta.tmpParada = AritmeticaUtil.somar(perdaFerramenta.tmpParada, registro.segTempoPar);
					perdaFerramenta.qtdOcorrPar = AritmeticaUtil.somar(perdaFerramenta.qtdOcorrPar, registro.qtdOcorrPar);

					if (!perdaFerramenta.estruturas.containsKey(registro.cdEstrutura)) {
						PerdasMaqDetEstru perdaEstrutura = new PerdasMaqDetEstru();
						perdaEstrutura = perdaEstruturaReg;
						perdaFerramenta.estruturas.put(registro.cdEstrutura, perdaEstrutura);

					} else {
						PerdasMaqDetEstru perdaEstrutura = new PerdasMaqDetEstru();
						perdaEstrutura = perdaFerramenta.estruturas.get(registro.cdEstrutura);

						// atualiza tempos estruturas
						perdaEstrutura.tmpParada = AritmeticaUtil.somar(perdaEstrutura.tmpParada, registro.segTempoPar);
						perdaEstrutura.qtdOcorrPar = AritmeticaUtil.somar(perdaEstrutura.qtdOcorrPar, registro.qtdOcorrPar);

						if (!perdaEstrutura.paradas.containsKey(registro.cdParada)) {
							PerdasMaqDetParada perdaParada = new PerdasMaqDetParada();
							perdaParada = perdaParadaReg;
							perdaEstrutura.paradas.put(registro.cdParada, perdaParada);

						} else {
							PerdasMaqDetParada perdaParada = new PerdasMaqDetParada();
							perdaParada = perdaEstrutura.paradas.get(registro.cdParada);

							// atualiza tempos parada
							perdaParada.tmpParada = AritmeticaUtil.somar(perdaParada.tmpParada, registro.segTempoPar);
							perdaParada.qtdOcorrPar = AritmeticaUtil.somar(perdaParada.qtdOcorrPar, registro.qtdOcorrPar);

							perdaEstrutura.paradas.put(registro.cdParada, perdaParada);
						}

						perdaFerramenta.estruturas.put(registro.cdEstrutura, perdaEstrutura);
					}

					perdaMaquina.ferramentas.put(registro.cdFerramenta, perdaFerramenta);
				}

				/// turnos
				if (!perdaMaquina.turnos.containsKey(registro.cdTurno)) {
					PerdasMaqDetTurno perdaTurno = new PerdasMaqDetTurno();

					perdaTurno = perdaTurnoReg;
					perdaMaquina.turnos.put(registro.cdTurno, perdaTurno);

				} else {
					PerdasMaqDetTurno perdaTurno = new PerdasMaqDetTurno();
					perdaTurno = perdaMaquina.turnos.get(registro.cdTurno);

					// atualiza tempos turno
					perdaTurno.tmpParada = AritmeticaUtil.somar(perdaTurno.tmpParada, registro.segTempoPar);
					perdaTurno.qtdOcorrPar = AritmeticaUtil.somar(perdaTurno.qtdOcorrPar, registro.qtdOcorrPar);
					perdaMaquina.turnos.put(registro.cdTurno, perdaTurno);
				}

				mapResumo.remove(registro.cdPt);
				mapResumo.put(registro.cdPt, perdaMaquina);
			}

		}

		// paradas - tempo e qtd ocorr de microparadas
		strSQL = "";
		lista = new ArrayList<Object>();
		strSQL = getConsultaParadasMicroPar(filtroBI, isParComPeso, cdParada, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosNaQuery(q, filtroBI, cdParada, cdPtSelecaoPareto, cdProdutoSelecaoPareto);

		lista = q.list();
		for (Object reg : lista) {
			RegistroParadaTempo registro = new RegistroParadaTempo();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdPt = (String) registroLido[_cdpt];
			registro.cdFerramenta = (String) registroLido[_cdferramentaMP];
			registro.cdEstrutura = (String) registroLido[_cdestruturaMP];
			registro.cdTurno = (String) registroLido[_cdturnoMP];
			registro.cdParada = (String) registroLido[_cdparadaMP];
			registro.qtdOcorrMicroPar = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdocorrMP]);

			// atualiza microparadas
			mapResumo.get(registro.cdPt).qtdOcorrMicroPar =
					AritmeticaUtil.somar(mapResumo.get(registro.cdPt).qtdOcorrMicroPar, registro.qtdOcorrMicroPar);
			mapResumo.get(registro.cdPt).indiceMicroPar = new BigDecimal(FormulasInjet
					.calcularIndicePerda(mapResumo.get(registro.cdPt).qtdOcorrMicroPar, mapResumo.get(registro.cdPt).qtdOcorrPar));

			mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).qtdOcorrMicroPar = AritmeticaUtil
					.somar(mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).qtdOcorrMicroPar, registro.qtdOcorrMicroPar);
			mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).indiceMicroPar = new BigDecimal(
					FormulasInjet.calcularIndicePerda(mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).qtdOcorrMicroPar,
							mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).qtdOcorrPar));

			mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).qtdOcorrMicroPar =
					AritmeticaUtil.somar(mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas
							.get(registro.cdEstrutura).qtdOcorrMicroPar, registro.qtdOcorrMicroPar);
			mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).indiceMicroPar =
					new BigDecimal(FormulasInjet.calcularIndicePerda(
							mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas
									.get(registro.cdEstrutura).qtdOcorrMicroPar,
							mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas
									.get(registro.cdEstrutura).qtdOcorrPar));

			mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).paradas
					.get(registro.cdParada).qtdOcorrMicroPar =
							AritmeticaUtil.somar(
									mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas
											.get(registro.cdEstrutura).paradas.get(registro.cdParada).qtdOcorrMicroPar,
									registro.qtdOcorrMicroPar);
			mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).paradas
					.get(registro.cdParada).indiceMicroPar = new BigDecimal(FormulasInjet.calcularIndicePerda(
							mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).paradas
									.get(registro.cdParada).qtdOcorrMicroPar,
							mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).paradas
									.get(registro.cdParada).qtdOcorrPar));

			mapResumo.get(registro.cdPt).turnos.get(registro.cdTurno).qtdOcorrMicroPar = AritmeticaUtil
					.somar(mapResumo.get(registro.cdPt).turnos.get(registro.cdTurno).qtdOcorrMicroPar, registro.qtdOcorrMicroPar);
			mapResumo.get(registro.cdPt).turnos.get(registro.cdTurno).indiceMicroPar = new BigDecimal(
					FormulasInjet.calcularIndicePerda(mapResumo.get(registro.cdPt).turnos.get(registro.cdTurno).qtdOcorrMicroPar,
							mapResumo.get(registro.cdPt).turnos.get(registro.cdTurno).qtdOcorrPar));

		}

		// qtdes
		strSQL = "";
		lista = new ArrayList<Object>();
		strSQL = getConsultaParadasQtde(filtroBI, isParComPeso, cdParada, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosNaQuery(q, filtroBI, cdParada, cdPtSelecaoPareto, cdProdutoSelecaoPareto);

		lista = q.list();
		for (Object reg : lista) {
			RegistroParadasQtd registro = new RegistroParadasQtd();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdPt = (String) registroLido[_cdpt];
			registro.cdFerramenta = (String) registroLido[_cdferramenta];
			registro.cdEstrutura = (String) registroLido[_cdestrutura];
			registro.cdTurno = (String) registroLido[_cdturno];
			registro.cdParada = (String) registroLido[_cdparada];
			registro.cdProduto = (String) registroLido[_cdproduto];
			registro.dsProduto = (String) registroLido[_dsproduto];
			registro.perdaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasUB]);
			registro.perdaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasGr]);
			registro.perdaUM = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasUM]);

			String keyM = registro.cdPt;
			String keyMF = keyM + registro.cdFerramenta;
			String keyMFE = keyMF + registro.cdEstrutura;
			String keyMFEP = keyMFE + registro.cdProduto;

			PerdasMaqDetProduto perdaProdutoReg = new PerdasMaqDetProduto();
			perdaProdutoReg.cdProduto = registro.cdProduto;
			perdaProdutoReg.dsProduto = registro.dsProduto;
			perdaProdutoReg.perdaUB = registro.perdaUB;
			perdaProdutoReg.perdaGr = registro.perdaGr;
			perdaProdutoReg.perdaUM = registro.perdaUM;
			perdaProdutoReg.prodLiqUB = mapPBPP_MFEP.get(keyMFEP).prodLiqUB;
			perdaProdutoReg.prodPrevUB = mapPBPP_MFEP.get(keyMFEP).prodPrevUB;
			perdaProdutoReg.indiceUB =
					new BigDecimal(FormulasInjet.calcularIndiceRefugo(perdaProdutoReg.perdaUB, perdaProdutoReg.prodPrevUB));

			// atualiza perdas (quantidades)

			// maaquina
			mapResumo.get(registro.cdPt).perdaUB = AritmeticaUtil.somar(mapResumo.get(registro.cdPt).perdaUB, registro.perdaUB);
			mapResumo.get(registro.cdPt).perdaGr = AritmeticaUtil.somar(mapResumo.get(registro.cdPt).perdaGr, registro.perdaGr);
			mapResumo.get(registro.cdPt).perdaUM = AritmeticaUtil.somar(mapResumo.get(registro.cdPt).perdaUM, registro.perdaUM);
			mapResumo.get(registro.cdPt).indiceUB = new BigDecimal(
					FormulasInjet.calcularIndicePerda(mapResumo.get(registro.cdPt).perdaUB, mapResumo.get(registro.cdPt).prodPrevUB));

			// ferramenta
			mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).perdaUB =
					AritmeticaUtil.somar(mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).perdaUB, registro.perdaUB);
			mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).perdaGr =
					AritmeticaUtil.somar(mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).perdaGr, registro.perdaGr);
			mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).perdaUM =
					AritmeticaUtil.somar(mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).perdaUB, registro.perdaUM);
			mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).indiceUB = new BigDecimal(FormulasInjet
					.calcularIndicePerda(mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).perdaUB, registro.prodPrevUB));

			// estrutura
			mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).perdaUB =
					AritmeticaUtil.somar(mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas
							.get(registro.cdEstrutura).perdaUB, registro.perdaUB);
			mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).perdaGr =
					AritmeticaUtil.somar(mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas
							.get(registro.cdEstrutura).perdaGr, registro.perdaGr);
			mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).perdaUM =
					AritmeticaUtil.somar(mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas
							.get(registro.cdEstrutura).perdaUM, registro.perdaUM);
			mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).indiceUB =
					new BigDecimal(
							FormulasInjet.calcularIndicePerda(mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas
									.get(registro.cdEstrutura).perdaUB, registro.prodPrevUB));

			// parada
			mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).paradas
					.get(registro.cdParada).perdaUB = AritmeticaUtil.somar(
							mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).paradas
									.get(registro.cdParada).perdaUB,
							registro.perdaUB);
			mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).paradas
					.get(registro.cdParada).perdaGr = AritmeticaUtil.somar(
							mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).paradas
									.get(registro.cdParada).perdaGr,
							registro.perdaGr);
			mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).paradas
					.get(registro.cdParada).perdaUM = AritmeticaUtil.somar(
							mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).paradas
									.get(registro.cdParada).perdaUM,
							registro.perdaUM);
			mapResumo.get(registro.cdPt).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).paradas
					.get(registro.cdParada).produtos.put(registro.cdProduto, perdaProdutoReg);

			// turno
			mapResumo.get(registro.cdPt).turnos.get(registro.cdTurno).perdaUB =
					AritmeticaUtil.somar(mapResumo.get(registro.cdPt).turnos.get(registro.cdTurno).perdaUB, registro.perdaUB);
			mapResumo.get(registro.cdPt).turnos.get(registro.cdTurno).perdaGr =
					AritmeticaUtil.somar(mapResumo.get(registro.cdPt).turnos.get(registro.cdTurno).perdaGr, registro.perdaGr);
			mapResumo.get(registro.cdPt).turnos.get(registro.cdTurno).perdaUM =
					AritmeticaUtil.somar(mapResumo.get(registro.cdPt).turnos.get(registro.cdTurno).perdaUM, registro.perdaUM);
			mapResumo.get(registro.cdPt).turnos.get(registro.cdTurno).indiceUB = new BigDecimal(FormulasInjet
					.calcularIndicePerda(mapResumo.get(registro.cdPt).turnos.get(registro.cdTurno).indiceUB, registro.prodPrevUB));

			totalCusto = AritmeticaUtil.somar(totalCusto, registro.perdaUM);
		}

		// Ordenacao por maquina
		List<PerdasMaqDetMaquina> listaMaq = new ArrayList<PerdasMaqDetMaquina>();
		listaMaq.addAll(mapResumo.values());
		Collections.sort(listaMaq, comparaPerdasMaqMaq);

		for (PerdasMaqDetMaquina perdaMaq : listaMaq) {

			if (resumo.getDetalhes().size() > 0) {
				BiParetoPerdasParadaDetDTO linhaDetPerdas = getLinhaEmBranco();
				resumo.getDetalhes().add(linhaDetPerdas);
			}

			// Ordenacao por ferramenta
			List<PerdasMaqDetFerramenta> listaFerr = new ArrayList<PerdasMaqDetFerramenta>();
			listaFerr.addAll(perdaMaq.ferramentas.values());
			Collections.sort(listaFerr, comparaPerdasMaqMol);

			int contadorMol = 0;
			for (PerdasMaqDetFerramenta perdaFerr : listaFerr) {
				contadorMol++;

				// Ordenacao por estrutura
				List<PerdasMaqDetEstru> listaEstru = new ArrayList<PerdasMaqDetEstru>();
				listaEstru.addAll(perdaFerr.estruturas.values());
				Collections.sort(listaEstru, comparaPerdasMaqEstru);

				int contadorEstru = 0;
				for (PerdasMaqDetEstru perdaEstru : listaEstru) {
					contadorEstru++;

					// Ordenacao por parada
					List<PerdasMaqDetParada> listaPar = new ArrayList<PerdasMaqDetParada>();
					listaPar.addAll(perdaEstru.paradas.values());
					Collections.sort(listaPar, comparaPerdasMaqParada);

					int contadorPar = 0;
					for (PerdasMaqDetParada perdaPar : listaPar) {
						contadorPar++;

						// Ordenacao por produto
						List<PerdasMaqDetProduto> listaPro = new ArrayList<PerdasMaqDetProduto>();
						listaPro.addAll(perdaPar.produtos.values());
						Collections.sort(listaPro, comparaPerdasMaqProduto);

						int contadorPro = 0;
						for (PerdasMaqDetProduto perdaPro : listaPro) {
							contadorPro++;

							BiParetoPerdasParadaDetDTO linhaDetPerdas = getLinhaEmBranco();
							linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_SEM_COR);

							if (contadorMol == 1 && contadorEstru == 1 && contadorPar == 1 && contadorPro == 1) {
								linhaDetPerdas.setPt(perdaMaq.cdPt + " (" + perdaMaq.cdIdentificacaoPt + ")");
							}

							if (contadorEstru == 1 && contadorPar == 1 && contadorPro == 1) {
								linhaDetPerdas.setFerramenta(perdaFerr.cdFerramenta + "/" + perdaEstru.cdEstrutura);
							}

							if (contadorPar == 1 && contadorPro == 1) {
								linhaDetPerdas.setParada(perdaPar.cdParada + " (" + perdaPar.dsParada + ")");
								linhaDetPerdas.setTempoPar(DataHoraRN.formatSegundosParaHHMMSS(perdaPar.tmpParada));
								linhaDetPerdas.setQtdOcorrPar(ConversaoTipos.converteParaString(perdaPar.qtdOcorrPar, 0));
								linhaDetPerdas.setQtdOcorrMicroPar(ConversaoTipos.converteParaString(perdaPar.qtdOcorrMicroPar, 0) + " ("
										+ ConversaoTipos.converteParaString(perdaPar.indiceMicroPar, 2) + "%)");
							}

							linhaDetPerdas.setProduto(perdaPro.cdProduto + " (" + perdaPro.dsProduto + ")");
							linhaDetPerdas.setCdProduto(perdaPro.cdProduto);

							linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaPro.perdaUB));
							linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString(
									AritmeticaUtil.dividir(perdaPro.perdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
							linhaDetPerdas.setPerdaTon(
									ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaPro.perdaGr, BiWebInjetRN.DIVISOR_TON),
											BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
							linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaPro.perdaUM, 2));

							resumo.getDetalhes().add(linhaDetPerdas);
						}
					}

					// total da estrutura
					BiParetoPerdasParadaDetDTO linhaDetPerdas = getLinhaEmBranco();
					linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_PERDA_PARADA_SUB_TOTAL_MOLDE);

					linhaDetPerdas.setParada(TEXTO_CELULA_PERDA_PARADA_SUB_TOTAL_MOLDE);
					linhaDetPerdas.setTempoPar(DataHoraRN.formatSegundosParaHHMMSS(perdaEstru.tmpParada));
					linhaDetPerdas.setQtdOcorrPar(ConversaoTipos.converteParaString(perdaEstru.qtdOcorrPar, 0));
					linhaDetPerdas.setQtdOcorrMicroPar(ConversaoTipos.converteParaString(perdaEstru.qtdOcorrMicroPar, 0) + " ("
							+ ConversaoTipos.converteParaString(perdaEstru.indiceMicroPar, 2) + "%)");
					linhaDetPerdas.setProdLiquidaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaEstru.prodLiqUB));
					linhaDetPerdas.setProdPrevUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaEstru.prodPrevUB));
					linhaDetPerdas.setIndicePerdaUB(ConversaoTipos.converteParaString(perdaEstru.indiceUB, 2));
					linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaEstru.perdaUB));
					linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString(
							AritmeticaUtil.dividir(perdaEstru.perdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
					linhaDetPerdas.setPerdaTon(ConversaoTipos.converteParaString(
							AritmeticaUtil.dividir(perdaEstru.perdaGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
					linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaEstru.perdaUM, 2));

					resumo.getDetalhes().add(linhaDetPerdas);
				}

			}

			BiParetoPerdasParadaDetDTO linhaDetPerdas = getLinhaEmBranco();
			resumo.getDetalhes().add(linhaDetPerdas);

			// perdas turno
			List<PerdasMaqDetTurno> listaTur = new ArrayList<PerdasMaqDetTurno>();
			listaTur.addAll(perdaMaq.turnos.values());
			Collections.sort(listaTur, comparaPerdasMaqTur);
			for (PerdasMaqDetTurno perdaTur : listaTur) {
				linhaDetPerdas = getLinhaEmBranco();
				linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_PERDA_PARADA_SUB_TOTAL_TURNO);
				linhaDetPerdas.setParada(perdaTur.cdTurno + " (" + perdaTur.dsTurno + ")");
				linhaDetPerdas.setTempoPar(DataHoraRN.formatSegundosParaHHMMSS(perdaTur.tmpParada));
				linhaDetPerdas.setQtdOcorrPar(ConversaoTipos.converteParaString(perdaTur.qtdOcorrPar, 0));
				linhaDetPerdas.setQtdOcorrMicroPar(ConversaoTipos.converteParaString(perdaTur.qtdOcorrMicroPar, 0) + " ("
						+ ConversaoTipos.converteParaString(perdaTur.indiceMicroPar, 2) + "%)");
				linhaDetPerdas.setProdLiquidaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaTur.prodLiqUB));
				linhaDetPerdas.setProdPrevUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaTur.prodPrevUB));
				linhaDetPerdas.setIndicePerdaUB(ConversaoTipos.converteParaString(perdaTur.indiceUB, 2));
				linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaTur.perdaUB));
				linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString(
						AritmeticaUtil.dividir(perdaTur.perdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
				linhaDetPerdas.setPerdaTon(ConversaoTipos.converteParaString(
						AritmeticaUtil.dividir(perdaTur.perdaGr, BiWebInjetRN.DIVISOR_TON), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
				linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaTur.perdaUM, 2));

				resumo.getDetalhes().add(linhaDetPerdas);
			}

			linhaDetPerdas = getLinhaEmBranco();
			resumo.getDetalhes().add(linhaDetPerdas);

			// perda da maquina
			linhaDetPerdas = getLinhaEmBranco();
			linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_PERDA_PARADA_SUB_TOTAL_MAQUINA);
			linhaDetPerdas.setParada(TEXTO_CELULA_PERDA_PARADA_SUB_TOTAL_MAQUINA);
			linhaDetPerdas.setTempoPar(DataHoraRN.formatSegundosParaHHMMSS(perdaMaq.tmpParada));
			linhaDetPerdas.setQtdOcorrPar(ConversaoTipos.converteParaString(perdaMaq.qtdOcorrPar, 0));
			linhaDetPerdas.setQtdOcorrMicroPar(ConversaoTipos.converteParaString(perdaMaq.qtdOcorrMicroPar, 0) + " ("
					+ ConversaoTipos.converteParaString(perdaMaq.indiceMicroPar, 2) + "%)");
			linhaDetPerdas.setProdLiquidaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaMaq.prodLiqUB));
			linhaDetPerdas.setProdPrevUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaMaq.prodPrevUB));
			linhaDetPerdas.setIndicePerdaUB(ConversaoTipos.converteParaString(perdaMaq.indiceUB, 2));
			linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaMaq.perdaUB));
			linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaMaq.perdaGr, BiWebInjetRN.DIVISOR_KG),
					BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
			linhaDetPerdas.setPerdaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaMaq.perdaGr, BiWebInjetRN.DIVISOR_TON),
					BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
			linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaMaq.perdaUM, 2));

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

	@SuppressWarnings("unchecked")
	public BiParetoPerdasParadaDetalheDTO getParetoPerdasParadaProDet(BiFiltroDTO filtroBIDet, UnidadeExibicaoOuOrdenacaoQtdBI ordenacao,
			Boolean isParComPeso, String cdParada, String cdPtSelecaoPareto, String cdProdutoSelecaoPareto) {
		BiFiltroDTO filtroBI = new BiFiltroDTO();
		BiWebInjetRN biRN = new BiWebInjetRN(getDao(), BiResource.FORMATO_DATA, BiResource.FORMATO_DATA_HORA);
		filtroBI = biRN.filtroBiTransformado(filtroBIDet);

		BiParetoPerdasParadaDetalheDTO resumo = new BiParetoPerdasParadaDetalheDTO();
		resumo.setDetalhes(new ArrayList<BiParetoPerdasParadaDetDTO>());
		BigDecimal totalCusto = BigDecimal.ZERO;

		Map<String, PerdasProDetProduto> mapResumo = new HashMap<String, PerdasProDetProduto>();
		Map<String, RegistroProdPrevProdBruta> mapPBPP_P = new HashMap<String, RegistroProdPrevProdBruta>();

		int _cdproduto = 0;
		int _dsproduto = _cdproduto + 1;
		int _cdferramenta = _dsproduto + 1;
		int _cdestrutura = _cdferramenta + 1;
		int _cdpt = _cdestrutura + 1;
		int _dspt = _cdpt + 1;
		int _cdparada = _dspt + 1;
		int _dsparada = _cdparada + 1;
		int _qtdocorrpar = _dsparada + 1;
		int _tmpparadas = _qtdocorrpar + 1;

		int _perdasUB = _tmpparadas + 1;
		int _perdasGr = _perdasUB + 1;
		int _perdasUM = _perdasGr + 1;

		// prodbruta liq e prevista
		int _prodliqUB = _cdproduto + 1;
		int _prodprevUB = _prodliqUB + 1;

		// microparadas
		int _cdferramentaMP = _cdproduto + 1;
		int _cdestruturaMP = _cdferramentaMP + 1;
		int _cdptMP = _cdestruturaMP + 1;
		int _cdparadaMP = _cdptMP + 1;
		int _qtdocorrparMP = _cdparadaMP + 1;

		// producao bruta e prevista
		String strSQL = "";
		List<Object> lista = new ArrayList<Object>();
		strSQL = getConsultaProdLiquidaProdPrevProduto(filtroBI, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosNaQuery(q, filtroBI, "", cdPtSelecaoPareto, cdProdutoSelecaoPareto);

		lista = q.list();
		for (Object reg : lista) {
			RegistroParadasQtd registro = new RegistroParadasQtd();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdProduto = (String) registroLido[_cdproduto];
			registro.prodLiqUB = ConversaoTipos.converterParaBigDecimal(registroLido[_prodliqUB]);
			registro.prodPrevUB = ConversaoTipos.converterParaBigDecimal(registroLido[_prodprevUB]);

			RegistroProdPrevProdBruta prodBP = new RegistroProdPrevProdBruta();
			prodBP.id = registro.cdProduto;
			prodBP.prodLiqUB = registro.prodLiqUB;
			prodBP.prodPrevUB = registro.prodPrevUB;

			mapPBPP_P.put(registro.cdProduto, prodBP);
		}

		// paradas
		strSQL = "";
		lista = new ArrayList<Object>();
		strSQL = getConsultaParadasProduto(filtroBI, isParComPeso, cdParada, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosNaQuery(q, filtroBI, cdParada, cdPtSelecaoPareto, cdProdutoSelecaoPareto);

		lista = q.list();
		for (Object reg : lista) {
			RegistroParadaProduto registro = new RegistroParadaProduto();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdProduto = (String) registroLido[_cdproduto];
			registro.dsProduto = (String) registroLido[_dsproduto];
			registro.cdFerramenta = (String) registroLido[_cdferramenta];
			registro.cdEstrutura = (String) registroLido[_cdestrutura];
			registro.cdPt = (String) registroLido[_cdpt];
			registro.dsPt = (String) registroLido[_dspt];
			registro.cdParada = (String) registroLido[_cdparada];
			registro.dsParada = (String) registroLido[_dsparada];
			registro.segTempoPar = ConversaoTipos.converterParaBigDecimal(registroLido[_tmpparadas]);
			registro.qtdOcorrPar = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdocorrpar]);
			registro.perdaUB = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasUB]);
			registro.perdaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasGr]);
			registro.perdaUM = ConversaoTipos.converterParaBigDecimal(registroLido[_perdasUM]);
			registro.perdaOrdenacao = getValorPerda(ordenacao, registro);

			PerdasProDetParada perdaParadaReg = new PerdasProDetParada();
			perdaParadaReg.cdParada = registro.cdParada;
			perdaParadaReg.dsParada = registro.dsParada;
			perdaParadaReg.tmpParada = registro.segTempoPar;
			perdaParadaReg.qtdOcorrPar = registro.qtdOcorrPar;
			perdaParadaReg.perdaUB = registro.perdaUB;
			perdaParadaReg.perdaGr = registro.perdaGr;
			perdaParadaReg.perdaUM = registro.perdaUM;
			perdaParadaReg.perdaOrdenacao = registro.perdaOrdenacao;

			PerdasProDetMaquina perdaMaquinaReg = new PerdasProDetMaquina();
			perdaMaquinaReg.cdPt = registro.cdPt;
			perdaMaquinaReg.cdIdentificacaoPt = registro.dsPt;
			perdaMaquinaReg.tmpParada = registro.segTempoPar;
			perdaMaquinaReg.qtdOcorrPar = registro.qtdOcorrPar;
			perdaMaquinaReg.perdaUB = registro.perdaUB;
			perdaMaquinaReg.perdaGr = registro.perdaGr;
			perdaMaquinaReg.perdaUM = registro.perdaUM;
			perdaMaquinaReg.perdaOrdenacao = registro.perdaOrdenacao;
			perdaMaquinaReg.paradas.put(registro.cdParada, perdaParadaReg);

			PerdasProDetEstru perdaEstruturaReg = new PerdasProDetEstru();
			perdaEstruturaReg.cdEstrutura = registro.cdEstrutura;
			perdaEstruturaReg.tmpParada = registro.segTempoPar;
			perdaEstruturaReg.qtdOcorrPar = registro.qtdOcorrPar;
			perdaEstruturaReg.perdaUB = registro.perdaUB;
			perdaEstruturaReg.perdaGr = registro.perdaGr;
			perdaEstruturaReg.perdaUM = registro.perdaUM;
			perdaEstruturaReg.perdaOrdenacao = registro.perdaOrdenacao;
			perdaEstruturaReg.maquinas.put(registro.cdPt, perdaMaquinaReg);

			PerdasProDetFerramenta perdaFerramentaReg = new PerdasProDetFerramenta();
			perdaFerramentaReg.cdFerramenta = registro.cdFerramenta;
			perdaFerramentaReg.tmpParada = registro.segTempoPar;
			perdaFerramentaReg.qtdOcorrPar = registro.qtdOcorrPar;
			perdaFerramentaReg.perdaUB = registro.perdaUB;
			perdaFerramentaReg.perdaGr = registro.perdaGr;
			perdaFerramentaReg.perdaUM = registro.perdaUM;
			perdaFerramentaReg.perdaOrdenacao = registro.perdaOrdenacao;
			perdaFerramentaReg.estruturas.put(registro.cdEstrutura, perdaEstruturaReg);

			PerdasProDetProduto perdaProdutoReg = new PerdasProDetProduto();
			perdaProdutoReg.cdProduto = registro.cdProduto;
			perdaProdutoReg.dsProduto = registro.dsProduto;
			perdaProdutoReg.tmpParada = registro.segTempoPar;
			perdaProdutoReg.qtdOcorrPar = registro.qtdOcorrPar;
			perdaProdutoReg.perdaUB = registro.perdaUB;
			perdaProdutoReg.perdaGr = registro.perdaGr;
			perdaProdutoReg.perdaUM = registro.perdaUM;
			perdaProdutoReg.perdaOrdenacao = registro.perdaOrdenacao;
			perdaProdutoReg.ferramentas.put(registro.cdFerramenta, perdaFerramentaReg);

			if (!mapResumo.containsKey(registro.cdProduto)) {
				mapResumo.put(registro.cdProduto, perdaProdutoReg);

			} else {
				PerdasProDetProduto perdaProduto = new PerdasProDetProduto();
				perdaProduto = mapResumo.get(registro.cdProduto);

				// atualiza produto
				perdaProduto.tmpParada = AritmeticaUtil.somar(perdaProduto.tmpParada, registro.segTempoPar);
				perdaProduto.qtdOcorrPar = AritmeticaUtil.somar(perdaProduto.qtdOcorrPar, registro.qtdOcorrPar);
				perdaProduto.perdaUB = AritmeticaUtil.somar(perdaProduto.perdaUB, registro.perdaUB);
				perdaProduto.perdaGr = AritmeticaUtil.somar(perdaProduto.perdaGr, registro.perdaGr);
				perdaProduto.perdaUM = AritmeticaUtil.somar(perdaProduto.perdaUM, registro.perdaUM);
				perdaProduto.perdaOrdenacao = AritmeticaUtil.somar(perdaProduto.perdaOrdenacao, registro.perdaOrdenacao);

				if (!perdaProduto.ferramentas.containsKey(registro.cdFerramenta)) {
					PerdasProDetFerramenta perdaFerramenta = new PerdasProDetFerramenta();

					perdaFerramenta = perdaFerramentaReg;
					perdaProduto.ferramentas.put(registro.cdFerramenta, perdaFerramenta);

				} else {
					PerdasProDetFerramenta perdaFerramenta = new PerdasProDetFerramenta();
					perdaFerramenta = perdaProduto.ferramentas.get(registro.cdFerramenta);

					// atualiza ferramenta
					perdaFerramenta.tmpParada = AritmeticaUtil.somar(perdaFerramenta.tmpParada, registro.segTempoPar);
					perdaFerramenta.qtdOcorrPar = AritmeticaUtil.somar(perdaFerramenta.qtdOcorrPar, registro.qtdOcorrPar);
					perdaFerramenta.perdaUB = AritmeticaUtil.somar(perdaFerramenta.perdaUB, registro.perdaUB);
					perdaFerramenta.perdaGr = AritmeticaUtil.somar(perdaFerramenta.perdaGr, registro.perdaGr);
					perdaFerramenta.perdaUM = AritmeticaUtil.somar(perdaFerramenta.perdaUM, registro.perdaUM);
					perdaFerramenta.perdaOrdenacao = AritmeticaUtil.somar(perdaFerramenta.perdaOrdenacao, registro.perdaOrdenacao);

					if (!perdaFerramenta.estruturas.containsKey(registro.cdEstrutura)) {
						PerdasProDetEstru perdaEstrutura = new PerdasProDetEstru();
						perdaEstrutura = perdaEstruturaReg;
						perdaFerramenta.estruturas.put(registro.cdEstrutura, perdaEstrutura);

					} else {
						PerdasProDetEstru perdaEstrutura = new PerdasProDetEstru();
						perdaEstrutura = perdaFerramenta.estruturas.get(registro.cdEstrutura);

						// atualiza estruturas
						perdaEstrutura.tmpParada = AritmeticaUtil.somar(perdaEstrutura.tmpParada, registro.segTempoPar);
						perdaEstrutura.qtdOcorrPar = AritmeticaUtil.somar(perdaEstrutura.qtdOcorrPar, registro.qtdOcorrPar);
						perdaEstrutura.perdaUB = AritmeticaUtil.somar(perdaEstrutura.perdaUB, registro.perdaUB);
						perdaEstrutura.perdaGr = AritmeticaUtil.somar(perdaEstrutura.perdaGr, registro.perdaGr);
						perdaEstrutura.perdaUM = AritmeticaUtil.somar(perdaEstrutura.perdaUM, registro.perdaUM);
						perdaEstrutura.perdaOrdenacao = AritmeticaUtil.somar(perdaEstrutura.perdaOrdenacao, registro.perdaOrdenacao);

						if (!perdaEstrutura.maquinas.containsKey(registro.cdPt)) {
							PerdasProDetMaquina perdaMaquina = new PerdasProDetMaquina();
							perdaMaquina = perdaMaquinaReg;
							perdaEstrutura.maquinas.put(registro.cdPt, perdaMaquina);

						} else {
							PerdasProDetMaquina perdaMaquina = new PerdasProDetMaquina();
							perdaMaquina = perdaEstrutura.maquinas.get(registro.cdPt);

							// atualiza maquina
							perdaMaquina.tmpParada = AritmeticaUtil.somar(perdaMaquina.tmpParada, registro.segTempoPar);
							perdaMaquina.qtdOcorrPar = AritmeticaUtil.somar(perdaMaquina.qtdOcorrPar, registro.qtdOcorrPar);
							perdaMaquina.perdaUB = AritmeticaUtil.somar(perdaMaquina.perdaUB, registro.perdaUB);
							perdaMaquina.perdaGr = AritmeticaUtil.somar(perdaMaquina.perdaGr, registro.perdaGr);
							perdaMaquina.perdaUM = AritmeticaUtil.somar(perdaMaquina.perdaUM, registro.perdaUM);
							perdaMaquina.perdaOrdenacao = AritmeticaUtil.somar(perdaMaquina.perdaOrdenacao, registro.perdaOrdenacao);

							if (!perdaMaquina.paradas.containsKey(registro.cdParada)) {
								PerdasProDetParada perdaParada = new PerdasProDetParada();
								perdaParada =  perdaParadaReg;
								perdaMaquina.paradas.put(registro.cdParada, perdaParada);
							}

							perdaEstrutura.maquinas.put(registro.cdPt, perdaMaquina);
						}

						perdaFerramenta.estruturas.put(registro.cdEstrutura, perdaEstrutura);
					}

					perdaProduto.ferramentas.put(registro.cdFerramenta, perdaFerramenta);
				}

				perdaProduto.prodLiqUB = mapPBPP_P.get(registro.cdProduto).prodLiqUB;
				perdaProduto.prodPrevUB = mapPBPP_P.get(registro.cdProduto).prodPrevUB;
				perdaProduto.indiceUB = new BigDecimal(FormulasInjet.calcularIndicePerda(perdaProduto.perdaUB, perdaProduto.prodPrevUB));
				mapResumo.remove(registro.cdProduto);
				mapResumo.put(registro.cdProduto, perdaProduto);

			}
			
			totalCusto = AritmeticaUtil.somar(totalCusto, registro.perdaUM);
		}

		// paradas - microparadas
		strSQL = "";
		lista = new ArrayList<Object>();
		strSQL = getConsultaParadasMicroParProduto(filtroBI, isParComPeso, cdParada, cdPtSelecaoPareto, cdProdutoSelecaoPareto);
		q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosNaQuery(q, filtroBI, cdParada, cdPtSelecaoPareto, cdProdutoSelecaoPareto);

		lista = q.list();
		for (Object reg : lista) {
			RegistroMicroParadaProduto registro = new RegistroMicroParadaProduto();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.cdProduto = (String) registroLido[_cdproduto];
			registro.cdFerramenta = (String) registroLido[_cdferramentaMP];
			registro.cdEstrutura = (String) registroLido[_cdestruturaMP];
			registro.cdPt = (String) registroLido[_cdptMP];
			registro.cdParada = (String) registroLido[_cdparadaMP];
			registro.qtdOcorrMicroPar = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdocorrparMP]);

			// atualiza microparadas
			mapResumo.get(registro.cdProduto).qtdOcorrMicroPar =
					AritmeticaUtil.somar(
							mapResumo.get(registro.cdProduto).qtdOcorrMicroPar,
							registro.qtdOcorrMicroPar);
			mapResumo.get(registro.cdProduto).indiceMicroPar = new BigDecimal(
					FormulasInjet.calcularIndicePerda(
							mapResumo.get(registro.cdProduto).qtdOcorrMicroPar,
							mapResumo.get(registro.cdProduto).qtdOcorrPar));

			mapResumo.get(registro.cdProduto).ferramentas.get(registro.cdFerramenta).qtdOcorrMicroPar =
					AritmeticaUtil.somar(
							mapResumo.get(registro.cdProduto).ferramentas.get(registro.cdFerramenta).qtdOcorrMicroPar,
							registro.qtdOcorrMicroPar);
			mapResumo.get(registro.cdProduto).ferramentas.get(registro.cdFerramenta).indiceMicroPar = new BigDecimal(
					FormulasInjet.calcularIndicePerda(
							mapResumo.get(registro.cdProduto).ferramentas.get(registro.cdFerramenta).qtdOcorrMicroPar,
							mapResumo.get(registro.cdProduto).ferramentas.get(registro.cdFerramenta).qtdOcorrPar));

			mapResumo.get(registro.cdProduto).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).qtdOcorrMicroPar =
					AritmeticaUtil.somar(
							mapResumo.get(registro.cdProduto).ferramentas.get(registro.cdFerramenta).estruturas
									.get(registro.cdEstrutura).qtdOcorrMicroPar,
							registro.qtdOcorrMicroPar);
			mapResumo.get(registro.cdProduto).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).indiceMicroPar =
					new BigDecimal(
							FormulasInjet.calcularIndicePerda(
									mapResumo.get(registro.cdProduto).ferramentas.get(registro.cdFerramenta).estruturas
											.get(registro.cdEstrutura).qtdOcorrMicroPar,
									mapResumo.get(registro.cdProduto).ferramentas.get(registro.cdFerramenta).estruturas
											.get(registro.cdEstrutura).qtdOcorrPar));

			mapResumo.get(registro.cdProduto).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).maquinas
					.get(registro.cdPt).qtdOcorrMicroPar =
							AritmeticaUtil.somar(
									mapResumo.get(registro.cdProduto).ferramentas.get(registro.cdFerramenta).estruturas
											.get(registro.cdEstrutura).maquinas.get(registro.cdPt).qtdOcorrMicroPar,
									registro.qtdOcorrMicroPar);
			mapResumo.get(registro.cdProduto).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).maquinas
					.get(registro.cdPt).indiceMicroPar = new BigDecimal(
							FormulasInjet.calcularIndicePerda(
									mapResumo.get(registro.cdProduto).ferramentas.get(registro.cdFerramenta).estruturas
											.get(registro.cdEstrutura).maquinas.get(registro.cdPt).qtdOcorrMicroPar,
									mapResumo.get(registro.cdProduto).ferramentas.get(registro.cdFerramenta).estruturas
											.get(registro.cdEstrutura).maquinas.get(registro.cdPt).qtdOcorrPar));

			mapResumo.get(registro.cdProduto).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).maquinas
					.get(registro.cdPt).paradas.get(registro.cdParada).qtdOcorrMicroPar =
							AritmeticaUtil.somar(
									mapResumo.get(registro.cdProduto).ferramentas.get(registro.cdFerramenta).estruturas
											.get(registro.cdEstrutura).maquinas.get(registro.cdPt).paradas
													.get(registro.cdParada).qtdOcorrMicroPar,
									registro.qtdOcorrMicroPar);
			mapResumo.get(registro.cdProduto).ferramentas.get(registro.cdFerramenta).estruturas.get(registro.cdEstrutura).maquinas
					.get(registro.cdPt).paradas.get(registro.cdParada).indiceMicroPar = new BigDecimal(
							FormulasInjet.calcularIndicePerda(
									mapResumo.get(registro.cdProduto).ferramentas.get(registro.cdFerramenta).estruturas
											.get(registro.cdEstrutura).maquinas.get(registro.cdPt).paradas
													.get(registro.cdParada).qtdOcorrMicroPar,
									mapResumo.get(registro.cdProduto).ferramentas.get(registro.cdFerramenta).estruturas
											.get(registro.cdEstrutura).maquinas.get(registro.cdPt).paradas
													.get(registro.cdParada).qtdOcorrPar));

		}

		// Ordenacao por produto
		List<PerdasProDetProduto> listaPro = new ArrayList<PerdasProDetProduto>();
		listaPro.addAll(mapResumo.values());
		Collections.sort(listaPro, comparaPerdasProProduto);

		for (PerdasProDetProduto perdaPro : listaPro) {

			if (resumo.getDetalhes().size() > 0) {
				BiParetoPerdasParadaDetDTO linhaDetPerdas = getLinhaEmBranco();
				resumo.getDetalhes().add(linhaDetPerdas);
			}

			// Ordenacao por ferramenta
			List<PerdasProDetFerramenta> listaFerr = new ArrayList<PerdasProDetFerramenta>();
			listaFerr.addAll(perdaPro.ferramentas.values());
			Collections.sort(listaFerr, comparaPerdasProMol);

			int contadorMol = 0;
			for (PerdasProDetFerramenta perdaFerr : listaFerr) {
				contadorMol++;

				// Ordenacao por estrutura
				List<PerdasProDetEstru> listaEstru = new ArrayList<PerdasProDetEstru>();
				listaEstru.addAll(perdaFerr.estruturas.values());
				Collections.sort(listaEstru, comparaPerdasProEstru);

				int contadorEstru = 0;
				for (PerdasProDetEstru perdaEstru : listaEstru) {
					contadorEstru++;

					// Ordenacao por maquina
					List<PerdasProDetMaquina> listaMaq = new ArrayList<PerdasProDetMaquina>();
					listaMaq.addAll(perdaEstru.maquinas.values());
					Collections.sort(listaMaq, comparaPerdasProMaq);

					int contadorMaq = 0;
					for (PerdasProDetMaquina perdaMaq : listaMaq) {
						contadorMaq++;

						// Ordenacao por parada
						List<PerdasProDetParada> listaPar = new ArrayList<PerdasProDetParada>();
						listaPar.addAll(perdaMaq.paradas.values());
						Collections.sort(listaPar, comparaPerdasProPar);

						int contadorPar = 0;
						for (PerdasProDetParada perdaPar : listaPar) {
							contadorPar++;

							BiParetoPerdasParadaDetDTO linhaDetPerdas = getLinhaEmBranco();
							linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_SEM_COR);

							if (contadorMol == 1 && contadorEstru == 1 && contadorMaq == 1 && contadorPar == 1) {
								linhaDetPerdas.setProduto(perdaPro.cdProduto + " (" + perdaPro.dsProduto + ")");
								linhaDetPerdas.setCdProduto(perdaPro.cdProduto);
							}

							if (contadorEstru == 1 && contadorMaq == 1 && contadorPar == 1) {
								linhaDetPerdas.setFerramenta(perdaFerr.cdFerramenta + "/" + perdaEstru.cdEstrutura);
							}

							if (contadorMaq == 1 && contadorPar == 1) {
								linhaDetPerdas.setPt(perdaMaq.cdPt + " (" + perdaMaq.cdIdentificacaoPt + ")");
							}

							linhaDetPerdas.setParada(perdaPar.cdParada + " (" + perdaPar.dsParada + ")");
							linhaDetPerdas.setTempoPar(DataHoraRN.formatSegundosParaHHMMSS(perdaPar.tmpParada));
							linhaDetPerdas.setQtdOcorrPar(ConversaoTipos.converteParaString(perdaPar.qtdOcorrPar, 0));
							linhaDetPerdas.setQtdOcorrMicroPar(ConversaoTipos.converteParaString(perdaPar.qtdOcorrPar, 0) + " ("
									+ ConversaoTipos.converteParaString(perdaPar.indiceMicroPar, 2) + "%)");

							linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaPro.perdaUB));
							linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString(
									AritmeticaUtil.dividir(perdaPro.perdaGr, BiWebInjetRN.DIVISOR_KG), BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
							linhaDetPerdas.setPerdaTon(
									ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaPro.perdaGr, BiWebInjetRN.DIVISOR_TON),
											BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
							linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaPro.perdaUM, 2));

							resumo.getDetalhes().add(linhaDetPerdas);
						}
					}

				}

			}

			// perda do produto
			BiParetoPerdasParadaDetDTO linhaDetPerdas = getLinhaEmBranco();
			linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_PERDA_PARADA_SUB_TOTAL_PRODUTO);
			linhaDetPerdas.setParada(TEXTO_CELULA_PERDA_PARADA_SUB_TOTAL_PRODUTO);
			linhaDetPerdas.setTempoPar(DataHoraRN.formatSegundosParaHHMMSS(perdaPro.tmpParada));
			linhaDetPerdas.setQtdOcorrPar(ConversaoTipos.converteParaString(perdaPro.qtdOcorrPar, 0));
			linhaDetPerdas.setQtdOcorrMicroPar(ConversaoTipos.converteParaString(perdaPro.qtdOcorrMicroPar, 0) + " ("
					+ ConversaoTipos.converteParaString(perdaPro.indiceMicroPar, 2) + "%)");
			linhaDetPerdas.setProdLiquidaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaPro.prodLiqUB));
			linhaDetPerdas.setProdPrevUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaPro.prodPrevUB));
			linhaDetPerdas.setIndicePerdaUB(ConversaoTipos.converteParaString(perdaPro.indiceUB, 2));
			linhaDetPerdas.setPerdaUB(ConfiguracoesInjetRN.aplicarFormatoUnidadeBasicaInjet(perdaPro.perdaUB));
			linhaDetPerdas.setPerdaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaPro.perdaGr, BiWebInjetRN.DIVISOR_KG),
					BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
			linhaDetPerdas.setPerdaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(perdaPro.perdaGr, BiWebInjetRN.DIVISOR_TON),
					BiWebInjetRN.CASAS_DECIMAIS_KG_TON));
			linhaDetPerdas.setPerdaUM(ConversaoTipos.converteParaString(perdaPro.perdaUM, 2));

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

	private BiParetoPerdasParadaDetDTO getLinhaEmBranco() {
		BiParetoPerdasParadaDetDTO linhaDetPerdas = new BiParetoPerdasParadaDetDTO();
		linhaDetPerdas.setPt("");
		linhaDetPerdas.setFerramenta("");
		linhaDetPerdas.setParada("");
		linhaDetPerdas.setProduto("");
		linhaDetPerdas.setCdProduto("");
		linhaDetPerdas.setCorFundoTextoSubTotal(COR_CELULA_SEM_COR);
		linhaDetPerdas.setTempoPar("");
		linhaDetPerdas.setQtdOcorrPar("");
		linhaDetPerdas.setQtdOcorrMicroPar("");
		linhaDetPerdas.setPerdaUB("");
		linhaDetPerdas.setPerdaKg("");
		linhaDetPerdas.setPerdaTon("");
		linhaDetPerdas.setPerdaUM("");
		linhaDetPerdas.setProdLiquidaUB("");
		linhaDetPerdas.setProdPrevUB("");
		linhaDetPerdas.setIndicePerdaUB("");

		return linhaDetPerdas;
	}
}
