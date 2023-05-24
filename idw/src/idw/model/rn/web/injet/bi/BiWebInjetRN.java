package idw.model.rn.web.injet.bi;

import java.awt.Color;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import idw.model.dao.OmPtDAO;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;
import idw.model.pojos.injet.Ijgrpinj;
import idw.model.pojos.injet.Ijgrpmol;
import idw.model.pojos.injet.Ijtbmol;
import idw.model.pojos.injet.Ijtbpro;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.DiversosInjetRN;
import idw.model.rn.injet.ProdutoInjetRN;
import idw.model.rn.injet.TurnoInjetRN;
import idw.model.rn.web.injet.monitorizacao.detalhe.DetalheMonitorizacaoWebIndicadorInjetRN;
import idw.model.rn.web.injet.monitorizacao.detalhe.DetalheMonitorizacaoWebInjetRN;
import idw.util.AritmeticaUtil;
import idw.util.Cor;
import idw.util.FormulasInjet;
import idw.webservices.rest.dto.GtDTO;
import idw.webservices.rest.dto.TurnoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoIndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoPizzaDTO;
import idw.webservices.rest.dto.monitorizacao.MetaIndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.PtIndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.PtTemposDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiFiltroDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiIndicadoresAnoMesDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiIndicadoresDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiIndicadoresDtRefDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiIndicadoresFicTecDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiIndicadoresPTDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiIndicadoresTurnoDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiResumoDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.FiltroBIParetoParadaDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.FiltroBIParetoPerdasCicloDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.FiltroBIParetoPerdasPCIDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.FiltroBIParetoPerdasParadaDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.FiltroBIParetoPerdasTodasDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.FiltroBIParetoRefugoDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.FiltroBIPerdasAreaRespDetDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.FiltroBIPerdasCicloMaqDetDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.FiltroBIPerdasCicloProdDetDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.FiltroBIPerdasParadaMaqDetDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.FiltroBIPerdasParadaProdDetDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.FiltroBIPerdasRefugoMaqDetDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.FiltroBIPerdasRefugoProdDetDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.FiltroBIPerdasTodasDetDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.FiltroBIPizzaAreaRespParDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.GraficoIndicadorPerdaDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.GrupoFerramentaBIDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.ProdutoBIDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.RapBIDTO;
import ms.util.ConversaoTipos;

public class BiWebInjetRN extends AbstractRN<DAOGenericoInjet> {

	public static final int CASAS_DECIMAIS_KG_TON = 4;
	public static final BigDecimal DIVISOR_KG = new BigDecimal(1000);
	public static final BigDecimal DIVISOR_TON = new BigDecimal(1000000);
	public static final BigDecimal DIVISOR_HORAS_DECIMAL = new BigDecimal(3600);

	public enum FiltroAgrupamentoBI {
		BI_TOTAL_GERAL(0), BI_TOTAL_ANO_MES(1), BI_TOTAL_DATA(2), BI_TOTAL_MAQUINA(3), BI_TOTAL_MAQUINA_FERRAMENTA_ESTRUTURA(4), BI_TOTAL_TURNO(5);

		private final int valor;

		private FiltroAgrupamentoBI(int valor) {
			this.valor = valor;
		}

		public int getValor() {
			return valor;
		}
	}
	
	public enum TipoParetoPerdasBI {
		PARETO_TODAS(1), PARETO_CICLOS(2), PARETO_PCI(3), PARETO_PARADAS(4), PARETO_REFUGOS(5);
		
		private final int valor;
		
		private TipoParetoPerdasBI(int valor) {
			this.valor = valor;
		}

		public int getValor() {
			return valor;
		}	
	}
	
	public enum UnidadeExibicaoOuOrdenacaoQtdBI {
		TEMPO(0), QTD_PARETO_PERDAS_BI_EM_UB(1), QTD_PARETO_PERDAS_BI_EM_KG(2), QTD_PARETO_PERDAS_BI_EM_TON(3), QTD_PARETO_PERDAS_BI_EM_UM(4);
		
		private final int valor;
		
		private UnidadeExibicaoOuOrdenacaoQtdBI(int valor) {
			this.valor = valor;
		}

		public int getValor() {
			return valor;
		}	
	}
	
	public enum TipoAgrupamentoParetoBI {
		PARETO_BI_PRODUTOS(1), PARETO_BI_MAQUINAS(2);
		
		private final int valor;
		
		private TipoAgrupamentoParetoBI(int valor) {
			this.valor = valor;
		}

		public int getValor() {
			return valor;
		}	
	}


	private DetalheMonitorizacaoWebIndicadorInjetRN indicadorRN;
	
	private class Indicadores {
		String ano;
		String mes;			
		Date dtTurno ;			
		String cdPt;
		String cdRap;
		String cdEstrutura;
		String cdTurno;
		String dsTurno;
		
		BigDecimal tmpProdRefugada = BigDecimal.ZERO;			
		BigDecimal tmpCavidades = BigDecimal.ZERO;
		
		BigDecimal tmpCicNormal = BigDecimal.ZERO;
		BigDecimal tmpCicFinParada = BigDecimal.ZERO;
		BigDecimal tmpParadasCP = BigDecimal.ZERO;
		BigDecimal tmpParadasSP = BigDecimal.ZERO;
		BigDecimal tmpRitmo = BigDecimal.ZERO;
		BigDecimal tmpAtivo = BigDecimal.ZERO;
		BigDecimal tmpCTA = BigDecimal.ZERO;
		BigDecimal tmpProdutivas = BigDecimal.ZERO;
		BigDecimal tmpTotal = BigDecimal.ZERO;
		BigDecimal tmpBoas = BigDecimal.ZERO;
		BigDecimal tmpPerdas = BigDecimal.ZERO;
		BigDecimal tmpTrabalhadas = BigDecimal.ZERO;
		
		BigDecimal prodPrev = BigDecimal.ZERO;
		BigDecimal qtdPerdasParCP = BigDecimal.ZERO;
		BigDecimal qtdPCI = BigDecimal.ZERO;
		BigDecimal prodBruta = BigDecimal.ZERO;
		BigDecimal prodRefugada = BigDecimal.ZERO;
		BigDecimal prodLiquida = BigDecimal.ZERO;
		BigDecimal qtdRitmo = BigDecimal.ZERO;
		BigDecimal qtdPerdas = BigDecimal.ZERO;
	
		BigDecimal prodPrevGr = BigDecimal.ZERO;
		BigDecimal qtdPerdasParCPGr = BigDecimal.ZERO;
		BigDecimal qtdPCIGr = BigDecimal.ZERO;
		BigDecimal prodBrutaGr = BigDecimal.ZERO;
		BigDecimal prodRefugadaGr = BigDecimal.ZERO;
		BigDecimal prodLiquidaGr = BigDecimal.ZERO;
		BigDecimal qtdRitmoGr = BigDecimal.ZERO;
		BigDecimal qtdPerdasGr = BigDecimal.ZERO;
		
		BigDecimal efiRea = BigDecimal.ZERO;
		BigDecimal efiReaP = BigDecimal.ZERO;
		BigDecimal efiReaT = BigDecimal.ZERO;
		BigDecimal indRef = BigDecimal.ZERO;
		BigDecimal indRefP = BigDecimal.ZERO;
		BigDecimal indRefT = BigDecimal.ZERO;
		BigDecimal indPerda = BigDecimal.ZERO;
		BigDecimal indPerdaP = BigDecimal.ZERO;
		BigDecimal indPerdaT = BigDecimal.ZERO;
		BigDecimal indPar = BigDecimal.ZERO;
		BigDecimal OEE = BigDecimal.ZERO;
		BigDecimal OEECapital = BigDecimal.ZERO;
		BigDecimal utilizacao = BigDecimal.ZERO;
		BigDecimal eficiencia = BigDecimal.ZERO;
		
		BigDecimal efiCic = BigDecimal.ZERO;
		BigDecimal efiCicPond = BigDecimal.ZERO;
		BigDecimal indPCA = BigDecimal.ZERO;		
	}
	
	
	private class ResumoBI  {
		String ano;
		String mes;
		
		Date dtTurno;
		
		String cdTurno;
		String dsTurno;
		
		String cdPt;
		String cdRap;
		String cdEstrutura;
		
		BiIndicadoresDTO indicadoresBI = new BiIndicadoresDTO();
		Indicadores indicadores = new Indicadores();
		GraficoIndicadorDTO indicadoresGrafico = new GraficoIndicadorDTO();
		GraficoIndicadorPerdaDTO indicadoresPerdaGrafico = new GraficoIndicadorPerdaDTO();
		PtTemposDTO temposDiagrama = new PtTemposDTO();		
		List<GraficoPizzaDTO> graficoPerdasPizza = new ArrayList<GraficoPizzaDTO>();
		List<ResumoBI> resumoBIPorTurno = new ArrayList<ResumoBI>();
	}
	
	
	private final String formatoData;
	private final String formatoDataHora;
	
	
	//comparators 
	private static final Comparator<BiIndicadoresAnoMesDTO> comparaAnoMes = new Comparator<BiIndicadoresAnoMesDTO>() {
		@Override
		public int compare(BiIndicadoresAnoMesDTO o1, BiIndicadoresAnoMesDTO o2) {
			
			if (o1.getAno().compareTo(o2.getAno()) > 0) {
				return 1;
			} else {
				if (o1.getAno().compareTo(o2.getAno()) < 0) {
					return -1;
				} else {
					// iguais - compara mês
					return o1.getMes().compareTo(o2.getMes());
				}
			}
		}
	};
	
	private static final Comparator<BiIndicadoresDtRefDTO> comparaDtRef = new Comparator<BiIndicadoresDtRefDTO>() {
		@Override
		public int compare(BiIndicadoresDtRefDTO o1, BiIndicadoresDtRefDTO o2) {
			return o1.getDtTurno().compareTo(o2.getDtTurno());
		}
	};
	
	private static final Comparator<BiIndicadoresPTDTO> comparaPt = new Comparator<BiIndicadoresPTDTO>() {
		@Override
		public int compare(BiIndicadoresPTDTO o1, BiIndicadoresPTDTO o2) {
			return o1.getCdPt().compareTo(o2.getCdPt());
		}
	};

	private static final Comparator<BiIndicadoresPTDTO> comparaPtDetProduto = new Comparator<BiIndicadoresPTDTO>() {
		@Override
		public int compare(BiIndicadoresPTDTO o1, BiIndicadoresPTDTO o2) {
			BigDecimal o1EfiRea = ConversaoTipos.converteParaBigDecimal(o1.getIndicadores().getEfiRea());
			BigDecimal o2EfiRea = ConversaoTipos.converteParaBigDecimal(o2.getIndicadores().getEfiRea());
			
			if (o1EfiRea.compareTo(o2EfiRea) > 0) {
				return -1;
			} else {
				if (o1EfiRea.compareTo(o2EfiRea) < 0) {
					return 1;
				} else {
					// iguais - compara maquina
					return o1.getCdPt().compareTo(o2.getCdPt());
				}
			}
		}
	};
	
	private static final Comparator<BiIndicadoresFicTecDTO> comparaDetalhesGraficoProduto = new Comparator<BiIndicadoresFicTecDTO>() {
		@Override
		public int compare(BiIndicadoresFicTecDTO o1, BiIndicadoresFicTecDTO o2) {
			BigDecimal o1EfiRea = ConversaoTipos.converteParaBigDecimal(o1.getIndicadores().getEfiRea());
			BigDecimal o2EfiRea = ConversaoTipos.converteParaBigDecimal(o2.getIndicadores().getEfiRea());
			
			if (o1EfiRea.compareTo(o2EfiRea) > 0) {
				return -1;
			} else {
				if (o1EfiRea.compareTo(o2EfiRea) < 0) {
					return 1;
				} else {
					// iguais - compara maquina
					if (o1.getCdPt().compareTo(o2.getCdPt()) > 0) {
						return 1;
					} else {
						if (o1.getCdPt().compareTo(o2.getCdPt()) < 0) {
							return -1;
						} else {
							// iguais - compara molde					
							if (o1.getCdRap().compareTo(o2.getCdRap()) > 0) {
								return 1;
							} else {
								if (o1.getCdRap().compareTo(o2.getCdRap()) < 0) {
									return -1;
								} else {
									// iguais - compara estrutura
									return o1.getCdEstrutura().compareTo(o2.getCdEstrutura());
								}
							}		
						}
					}			
				}
			}
		}
	};
	
	
	private static final Comparator<BiIndicadoresTurnoDTO> comparaTurno = new Comparator<BiIndicadoresTurnoDTO>() {
		@Override
		public int compare(BiIndicadoresTurnoDTO o1, BiIndicadoresTurnoDTO o2) {
			return o1.getCdTurno().compareTo(o2.getCdTurno());
		}
	};
	

	public BiWebInjetRN(String formatoData, String formatoDataHora) {
		this(new DAOGenericoInjet(), formatoData, formatoDataHora);
	}

	
	public BiWebInjetRN(DAOGenericoInjet dao, String formatoData, String formatoDataHora) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenericoInjet();
		}
		this.setDao(dao);
		this.formatoData = formatoData;
		this.formatoDataHora = formatoDataHora;		
	}

	
	@SuppressWarnings("unchecked")
	public List<RapBIDTO> getFerramentasAtivas() {
		List<RapBIDTO> retorno = new ArrayList<>();
		
		String HQL = "";
		
		HQL += "SELECT a ";
		HQL += "  FROM Ijtbmol a ";
		HQL += " WHERE a.cdmolde <> '999999' ";
		HQL += " ORDER BY a.cdmolestendido ";
		
		List<Ijtbmol> lista = null;

		Query q = getDaoSession().createQuery(HQL);

		lista = q.list();
		for(Ijtbmol molde : lista) {
			RapBIDTO rap = new RapBIDTO();

			if (molde.getCdmolde().substring(0, 1).equals("|")) {
				rap.setIdRap(ConversaoTipos.converteParaBigDecimal(molde.getCdmolde().substring(1, 5)).longValue());
			} else {
				rap.setIdRap(ConversaoTipos.converteParaBigDecimal(molde.getCdmolde()).longValue());
			}
			
			rap.setCdRap(molde.getCdmolde());
			rap.setCdRapView(molde.getCdmolestendido());
			rap.setDsRap(molde.getDsmolde());
			
			retorno.add(rap);
		}
		
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public List<GrupoFerramentaBIDTO> getGrupoFerramentasAtivas() {
		List<GrupoFerramentaBIDTO> retorno = new ArrayList<>();
		
		String HQL = "";
		
		HQL += "SELECT DISTINCT a ";
		HQL += "  FROM Ijgrpmol a ";
		HQL += "  JOIN a.ijgrpdetmols ";
		HQL += " ORDER BY a.cdgrpmol ";
		
		List<Ijgrpmol> lista = null;

		Query q = getDaoSession().createQuery(HQL);

		lista = q.list();
		for(Ijgrpmol grp : lista) {
			GrupoFerramentaBIDTO grupo = new GrupoFerramentaBIDTO();

			grupo.setCdGrpRAP(grp.getCdgrpmol());
			grupo.setDsGrpRAP(grp.getDsgrpmol());
			
			retorno.add(grupo);
		}			

		return retorno;
	}

	@SuppressWarnings("unchecked")
	public List<GtDTO> getGrupoPTsAtivos() {
		List<GtDTO> retorno = new ArrayList<>();
		
		String HQL = "";
		
		HQL += "SELECT DISTINCT a ";
		HQL += "  FROM Ijgrpinj a ";
		HQL += "  JOIN a.ijgrpdetinjs b ";
		HQL += " ORDER BY a.cdgrpinj ";
		
		List<Ijgrpinj> lista = null;

		Query q = getDaoSession().createQuery(HQL);

		lista = q.list();
		for(Ijgrpinj grp : lista) {
			GtDTO grupo = new GtDTO();

			grupo.setIdGt(String.valueOf(grp.getCdgrpinj()));
			grupo.setCdGt(grp.getCdgrpinj());
			grupo.setDsGt(grp.getDsgrpinj());
			grupo.setDsView(grp.getDsgrpinj());
			
			retorno.add(grupo);
		}			

		return retorno;
	}

	@SuppressWarnings("unchecked")
	public List<ProdutoBIDTO> getProdutosAtivos() {
		List<ProdutoBIDTO> retorno = new ArrayList<>();
		
		String HQL = "";
		
		HQL += "SELECT a ";
		HQL += "  FROM Ijtbpro a ";
		HQL += " WHERE a.cdproduto <> '99999999999999999999' ";
		HQL += " ORDER BY a.cdproduto ";
		
		List<Ijtbpro> lista = null;

		Query q = getDaoSession().createQuery(HQL);

		lista = q.list();
		for(Ijtbpro pro : lista) {
			ProdutoBIDTO produto = new ProdutoBIDTO();

			produto.setCdProduto(pro.getCdproduto());
			produto.setDsProduto(pro.getDsproduto());
			
			retorno.add(produto);
		}			

		return retorno;
	}			
	
	@SuppressWarnings("unchecked")
	public List<ProdutoBIDTO> getListaProdutosPeriodo(BiFiltroDTO filtroBI, FiltroAgrupamentoBI agrupamento) {
		List<ProdutoBIDTO> retorno = new ArrayList<>();
		
		
		// se parametros com null, seta para ""
		if (filtroBI.getAnoIni() == null) {
			filtroBI.setAnoIni("");
			filtroBI.setMesIni("");
			filtroBI.setAnoFim("");
			filtroBI.setMesFim("");
		}
		
		if (filtroBI.getCdTurno() == null) {
			filtroBI.setCdTurno("");
		}
		
		if (filtroBI.getCdPt() == null) {
			filtroBI.setCdPt("");
		}
		
		if (filtroBI.getCdGt() == null) {
			filtroBI.setCdGt("");
		}
		
		if (filtroBI.getCdClasseMaquina() == null) {
			filtroBI.setCdClasseMaquina("");
		}
		
		if (filtroBI.getCdRap() == null) {
			filtroBI.setCdRap("");
		}
		
		if (filtroBI.getCdGrpRap() == null) {
			filtroBI.setCdGrpRap("");
		}
				
		if (filtroBI.getCdEstrutura() == null) {
			filtroBI.setCdEstrutura("");
		}
		
		filtroBI.setDsTurno("");
		filtroBI.setDsPt("");
		filtroBI.setDsGt("");
		filtroBI.setDsGrpRap("");
		filtroBI.setDsProduto("");
				
		String strSQL = "";
		
		strSQL = strSQL.concat("SELECT DISTINCT c.cdproduto, c.dsproduto ");
		
		if (!filtroBI.getAnoIni().equals("")){
			strSQL = strSQL.concat("  FROM viewBIAnoMesProdutos a ");
		} else {
			strSQL = strSQL.concat("  FROM viewBIDtRefProdutos a ");	
		}
		
		
		strSQL = strSQL.concat("  JOIN ijmolpro b ON (b.cdmolde = a.cdmolde and b.cdestrutura = a.cdestrutura and b.dthrival = a.dthrivalestru) ");		
		strSQL = strSQL.concat("  JOIN ijtbpro c ON (c.cdproduto = b.cdproduto) ");
		
		
		// tabelas relacionados a maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetinj f ON (f.cdinjetora = a.cdinjetora) ");		
		} else {
			if (!filtroBI.getCdClasseMaquina().equals("")) { 
				strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC h ON (h.cdinjetora = a.cdinjetora) ");
			}  else {
				if (!filtroBI.getCdGalpao().equals("")) {
					strSQL = strSQL.concat("  JOIN ijgalobj gal ON (gal.cdinjetora = a.cdinjetora) ");
				}
			}
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol g ON (g.cdmolde = a.cdmolde) ");	
		}

		
		// filtros		
		if (!filtroBI.getAnoIni().equals("")) {
			strSQL = strSQL.concat(" WHERE a.anomes BETWEEN :anomesini AND :anomesfim ");
		} else {
			strSQL = strSQL.concat(" WHERE a.dtturno BETWEEN :dthrini AND :dthrfim ");	
		}
		

		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cdturno = :cdturno ");
		}
		
		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND a.cdinjestendido = :cdpt ");	
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  AND f.cdgrpinj = :cdgt ");		
			} else {
				if (!filtroBI.getCdClasseMaquina().equals("")) {
					strSQL = strSQL.concat("  AND h.classe = :cdclasse ");
				} else {
					if (!filtroBI.getCdGalpao().equals("")) {
						strSQL = strSQL.concat("  AND gal.cdgalpao = :cdgalpao ");
					}
				}
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND a.cdmolestendido = :cdrap ");	
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND g.cdgrpmol = :cdgrprap ");	
		}
		
		strSQL = strSQL.concat(" ORDER BY c.cdproduto ");
		
		
		
		// recupera prrodutos
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		

		if (!filtroBI.getAnoIni().equals("")){
			q.setString("anomesini", filtroBI.getAnoIni().concat(filtroBI.getMesIni()));
			q.setString("anomesfim", filtroBI.getAnoFim().concat(filtroBI.getMesFim()));
		} else {
			q.setTimestamp("dthrini", filtroBI.getDtIniDt());
			q.setTimestamp("dthrfim", filtroBI.getDtFimDt());
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
				if (!filtroBI.getCdClasseMaquina().equals("")) {
					q.setString("cdclasse", filtroBI.getCdClasseMaquina());
				} else {
					if (!filtroBI.getCdGalpao().equals("")) {
						q.setString("cdgalpao", filtroBI.getCdGalpao());
					}
				}
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
		
		List<Object> listaReg = q.list();			

		for (Object reg : listaReg) {
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			ProdutoBIDTO pro = new ProdutoBIDTO();
			
			pro.setCdProduto((String) registroLido[0]);
			pro.setDsProduto((String) registroLido[1]);
			
			retorno.add(pro);
		}
		
		if (retorno.size() == 0) {
			// trecho necessario por causa do filtro do BI (falicitar a implementacao do front-end)	
			ProdutoBIDTO produtoVazio = new ProdutoBIDTO();
			produtoVazio.setCdProduto("");
			produtoVazio.setDsProduto("");
			retorno.add(produtoVazio);
		}
		
		return retorno;
	}
	
	private String getConsultaIndicadoresQtdBI(BiFiltroDTO filtroBI, FiltroAgrupamentoBI agrupamento) {
		String strSQL = "";
		String strSQLGroup = "";		
		String strSQLGroupBySubQuery = "";
		String strSQLIndicadores = "";
		String strSQLTotaisSubQuery = "";
		String strSQLTabelasSubQuery = "";
		String strSQLWhereSubQuery = "";
		
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_GERAL) {
			strSQLGroup = "";
			strSQLGroupBySubQuery = "";
		} 
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_ANO_MES) {
			strSQLGroup = "t.anomes ";
			strSQLGroupBySubQuery = "b.anomes ";
		} 
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA) {
			strSQLGroup = "t.dtturno ";
			strSQLGroupBySubQuery = "b.dtturno ";
		}
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA) {
			strSQLGroup = "t.cdinjestendido ";
			strSQLGroupBySubQuery = "b.cdinjestendido ";
		} 		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_FERRAMENTA_ESTRUTURA) {
			strSQLGroup = "t.cdinjestendido, t.cdmolestendido, t.cdestrutura  ";
			strSQLGroupBySubQuery = "b.cdinjestendido, b.cdmolestendido, b.cdestrutura ";
		} 				
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_TURNO) {
			strSQLGroup = "t.cdturno, t.dsturno ";
			strSQLGroupBySubQuery = "b.cdturno, tur.dsturno ";
		} 
		
		
		// indicadores
		
		// tempos que dependem dos produtos
		strSQLIndicadores = strSQLIndicadores.concat(" t.tmpprodrefugada, t.tmpcavidades, ");
		
		// qtdes na unidade básica
		strSQLIndicadores = strSQLIndicadores.concat(" FLOOR(t.prodprev) as prodprev, FLOOR(t.qtdperdasparCP) as qtdperdasparCP, FLOOR(t.qtdPCI) as qtdPCI, t.prodbruta, ");
		strSQLIndicadores = strSQLIndicadores.concat(" t.prodrefugada, t.prodliquida, (CASE WHEN t.qtdritmo >=0 THEN FLOOR(t.qtdritmo)  ELSE FLOOR(ABS(t.qtdritmo)) * -1 END) as qtdritmo, ");
		strSQLIndicadores = strSQLIndicadores.concat(" ( FLOOR(t.qtdperdasparCP) + FLOOR(t.qtdPCI) + (CASE WHEN t.qtdritmo >=0 THEN FLOOR(t.qtdritmo)  ELSE FLOOR(ABS(t.qtdritmo)) * -1 END) + t.prodrefugada ) as qtdperdas, "); 
		
		// qtdes em gramas
		strSQLIndicadores = strSQLIndicadores.concat(" t.prodprevGr, t.qtdperdasparCPGr, t.qtdPCIGr, t.prodbrutaGr, ");
		strSQLIndicadores = strSQLIndicadores.concat(" t.prodrefugadaGr, t.prodliquidaGr, t.qtdritmoGr, t.qtdperdasGr, ");
		
		// indicadores - efi rea
		strSQLIndicadores = strSQLIndicadores.concat(" (CASE WHEN FLOOR(t.prodprev) = 0 THEN 0 ELSE (t.prodliquida / FLOOR(t.prodprev)) * 100 END) as efirea, ");
		strSQLIndicadores = strSQLIndicadores.concat(" (CASE WHEN t.prodprevGr = 0 THEN 0 ELSE (t.prodliquidaGr / t.prodprevGr) * 100 END) as efireaP, ");

		// indicadores - ind ref
		strSQLIndicadores = strSQLIndicadores.concat(" (CASE WHEN t.prodbruta = 0 THEN 0 ELSE (t.prodrefugada / t.prodbruta) * 100 END) as indref, ");
		strSQLIndicadores = strSQLIndicadores.concat(" (CASE WHEN t.prodbrutaGr = 0 THEN 0 ELSE (t.prodrefugadaGr / t.prodbrutaGr) * 100 END) as indrefP, ");

		// indicadores - ind perdas
		strSQLIndicadores = strSQLIndicadores.concat(" (CASE WHEN FLOOR(t.prodprev) = 0 THEN 0 ELSE (( FLOOR(t.qtdperdasparCP) + FLOOR(t.qtdPCI) + (CASE WHEN t.qtdritmo >=0 THEN FLOOR(t.qtdritmo)  ELSE FLOOR(ABS(t.qtdritmo)) * -1 END) + t.prodrefugada ) / FLOOR(t.prodprev)) * 100 END) as indperda, ");
		strSQLIndicadores = strSQLIndicadores.concat(" (CASE WHEN t.prodprevGr = 0 THEN 0 ELSE (t.qtdperdasGr / t.prodprevGr) * 100 END) as indperdaP ");

		
		// tempos que dependem dos produtos
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.tmppcsref) as tmpprodrefugada, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.tmpcavidades) as tmpcavidades, ");
		
		
		//  qtdes na unidade básica
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.prodprev) as prodprev, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.qtdperdasparCP) as qtdperdasparCP, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.qtdPCI) as qtdPCI, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.prodbruta) as prodbruta, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.prodrefugada) as prodrefugada, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.prodbruta - b.prodrefugada) as prodliquida, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.qtdritmo) as qtdritmo, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.qtdperdasparCP + b.prodrefugada + b.qtdPCI + b.qtdritmo) as qtdperdas, ");
		
		// qtdes em gramas
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.prodprevGr) as prodprevGr, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.qtdperdasparCPGr) as qtdperdasparCPGr, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.qtdPCIGr) as qtdPCIGr, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.prodbrutaGr) as prodbrutaGr, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.prodrefugadaGr) as prodrefugadaGr, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.prodbrutaGr - b.prodrefugadaGr) as prodliquidaGr, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.qtdritmoGr) as qtdritmoGr, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.qtdperdasparCPGr + b.prodrefugadaGr + b.qtdPCIGr + b.qtdritmoGr) as qtdperdasGr ");
		
		
		if (!filtroBI.getAnoIni().equals("")) {
			if (!filtroBI.getCdProduto().equals("")) {
				strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  FROM viewBIAnoMesProdutos b ");	
			} else {
				strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  FROM viewBIAnoMesQtds b ");
			}			
		} else {
			if (!filtroBI.getCdProduto().equals("")) {
				strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  FROM viewBIDtRefProdutos b ");	
			} else {
				strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  FROM viewBIDtRefQtds b ");
			}			
		}
		
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN ijtbtur tur ON (tur.cdturno = b.cdturno) ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN ijfictec d ON (    d.cdinjetora = b.cdinjetora ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("                     AND d.cdmolde = b.cdmolde ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("                     AND d.cdestrutura = b.cdestrutura ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("                     AND d.dthrivalcic = b.dthrivalcic) ");
		
		// tabelas relacionadas a grupo de maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = b.cdinjetora) ");		
		} else {
			if (!filtroBI.getCdClasseMaquina().equals("")) {
				strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  LEFT JOIN ijtbinjclassABC h ON (h.cdinjetora = b.cdinjetora) ");
			} else {
				if (!filtroBI.getCdGalpao().equals("")) {
					strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN ijgalobj gal ON (gal.cdinjetora = b.cdinjetora) ");
				}
			}
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = b.cdmolde) ");	
		}

		
		// filtros	
		if (!filtroBI.getAnoIni().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" WHERE b.anomes BETWEEN :anomesini AND :anomesfim ");
		} else {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" WHERE b.dtturno BETWEEN :dthrini AND :dthrfim ");	
		}
		

		if (!filtroBI.getCdTurno().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" AND b.cdturno = :cdturno ");
		}
		
		if (!filtroBI.getCdPt().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND b.cdinjestendido = :cdpt ");	
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND gm.cdgrpinj = :cdgt ");		
			} else {	
				if (!filtroBI.getCdClasseMaquina().equals("")) {
					strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND h.classe = :cdclasse ");	
				} else {
					if (!filtroBI.getCdGalpao().equals("")) {
						strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND gal.cdgalpao = :cdgalpao ");
					}					
				}
				
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND b.cdmolestendido = :cdrap ");	
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND gf.cdgrpmol = :cdgrprap ");	
		}
		
		if (!filtroBI.getCdProduto().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND b.cdproduto = :cdproduto ");	
		}
		
		
		strSQL = "SELECT ";
		
		if (!strSQLGroup.equals("")) {
			strSQL = strSQL.concat(strSQLGroup + ", ");
		}
		
		strSQL = strSQL.concat(strSQLIndicadores);
		
		strSQL = strSQL.concat(" FROM (SELECT ");
		
		if (!strSQLGroupBySubQuery.equals("")) {
			strSQL = strSQL.concat(strSQLGroupBySubQuery + ", ");
		}
		
		strSQL = strSQL.concat(strSQLTotaisSubQuery);
		strSQL = strSQL.concat(strSQLTabelasSubQuery);
		strSQL = strSQL.concat(strSQLWhereSubQuery);	
		
		if (!strSQLGroupBySubQuery.equals("")) {
			strSQL = strSQL.concat(" GROUP BY " + strSQLGroupBySubQuery);
		}
		strSQL = strSQL.concat(" ) t ");

		
		return strSQL;
	}

	private String getConsultaIndicadoresTempoBI(BiFiltroDTO filtroBI, FiltroAgrupamentoBI agrupamento) {
		String strSQL = "";
		String strSQLGroup = "";		
		String strSQLGroupBySubQuery = "";
		String strSQLIndicadores = "";
		String strSQLTotaisSubQuery = "";
		String strSQLTabelasSubQuery = "";
		String strSQLWhereSubQuery = "";
		
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_GERAL) {
			strSQLGroup = "";
			strSQLGroupBySubQuery = "";
		} 
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_ANO_MES) {
			strSQLGroup = "t.anomes ";
			strSQLGroupBySubQuery = "a.anomes ";
		} 
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA) {
			strSQLGroup = "t.dtturno ";
			strSQLGroupBySubQuery = "a.dtturno ";
		}
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA) {
			strSQLGroup = "t.cdinjestendido ";
			strSQLGroupBySubQuery = "a.cdinjestendido ";
		}
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_FERRAMENTA_ESTRUTURA) {
			strSQLGroup = "t.cdinjestendido, t.cdmolestendido, t.cdestrutura ";
			strSQLGroupBySubQuery = "a.cdinjestendido, a.cdmolestendido, a.cdestrutura ";
		} 				
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_TURNO) {
			strSQLGroup = "t.cdturno, t.dsturno ";
			strSQLGroupBySubQuery = "a.cdturno, tur.dsturno ";
		} 

		
		// indicadores
		
		// tempos que NAO dependem dos produtos
		strSQLIndicadores = strSQLIndicadores.concat(" t.tmpcicnormal, t.tmpcicfinparada, t.tmpparadasCP, t.tmpparadasSP,  ");
		strSQLIndicadores = strSQLIndicadores.concat(" t.tmpritmo, t.tmpativo, t.tmpCTT, t.tmpCTA, ");
		
		strSQLIndicadores = strSQLIndicadores.concat(" (t.tmpativo + tmpparadasSP) as tmpTotal, ");

		// indicadores - ind par
		strSQLIndicadores = strSQLIndicadores.concat(" (CASE WHEN t.tmpativo = 0 THEN 0 ELSE (t.tmpparadasCP / t.tmpativo) * 100 END) as indpar, ");
		// indicadores - utilizacao
		strSQLIndicadores = strSQLIndicadores.concat(" (CASE WHEN t.tmpativo = 0 THEN 0 ELSE ( (t.tmpativo - t.tmpparadasSP) / t.tmpativo) * 100 END) as utilizacao ");		
		
		
		// tempos que NAO dependem dos produtos	
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(a.tmpcicnormal) as tmpcicnormal, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(a.tmpcicfinparada) as tmpcicfinparada, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(a.tmpparadasCP) as tmpparadasCP, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(a.tmpparadasSP) as tmpparadasSP, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(a.tmpritmo) as tmpritmo, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(a.tmpativo) as tmpativo, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(a.tmpCTT) as tmpCTT, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(a.tmpCTA) as tmpCTA ");		
		
		
		if (!filtroBI.getAnoIni().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  FROM viewBIAnoMesTempos a ");
		} else {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  FROM viewBIDtRefTempos a ");
		}
		
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN ijtbtur tur ON (tur.cdturno = a.cdturno) ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN ijfictec d ON (    d.cdinjetora = a.cdinjetora ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("                     AND d.cdmolde = a.cdmolde ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("                     AND d.cdestrutura = a.cdestrutura ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("                     AND d.dthrivalcic = a.dthrivalcic) ");
		
		// tabelas relacionadas a grupo de maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");		
		} else {
			if (!filtroBI.getCdClasseMaquina().equals("")) {
				strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  LEFT JOIN ijtbinjclassABC h ON (h.cdinjetora = a.cdinjetora) ");
			} else {
				if (!filtroBI.getCdGalpao().equals("")) {
					strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN ijgalobj gal ON (gal.cdinjetora = a.cdinjetora) ");
				} 
			}
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");	
		}

		
		if (!filtroBI.getCdProduto().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN ijmolpro mp ON (    mp.cdmolde = d.cdmolde ");
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("                       AND mp.cdestrutura = d.cdestrutura ");
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("                       AND mp.dthrival = d.dthrivalestru) ");
		}
		
		// filtros	
		if (!filtroBI.getAnoIni().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" WHERE a.anomes BETWEEN :anomesini AND :anomesfim ");
		} else {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" WHERE a.dtturno BETWEEN :dthrini AND :dthrfim ");	
		}
		

		if (!filtroBI.getCdTurno().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" AND a.cdturno = :cdturno ");
		}
		
		if (!filtroBI.getCdPt().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND a.cdinjestendido = :cdpt ");	
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND gm.cdgrpinj = :cdgt ");		
			} else {			
				if (!filtroBI.getCdClasseMaquina().equals("")) {
					strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND h.classe = :cdclasse ");	
				} else {
					if (!filtroBI.getCdGalpao().equals("")) {
						strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND gal.cdgalpao = :cdgalpao ");
					}
				}
				
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND a.cdmolestendido = :cdrap ");	
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND gf.cdgrpmol = :cdgrprap ");	
		}
		
		if (!filtroBI.getCdProduto().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND mp.cdproduto = :cdproduto ");	
		}
		
		
		strSQL = "SELECT ";
		
		if (!strSQLGroup.equals("")) {
			strSQL = strSQL.concat(strSQLGroup + ", ");
		}
		
		strSQL = strSQL.concat(strSQLIndicadores);
		
		strSQL = strSQL.concat(" FROM (SELECT ");
		
		if (!strSQLGroupBySubQuery.equals("")) {
			strSQL = strSQL.concat(strSQLGroupBySubQuery + ", ");
		}
		
		strSQL = strSQL.concat(strSQLTotaisSubQuery);
		strSQL = strSQL.concat(strSQLTabelasSubQuery);
		strSQL = strSQL.concat(strSQLWhereSubQuery);	
		
		if (!strSQLGroupBySubQuery.equals("")) {
			strSQL = strSQL.concat(" GROUP BY " + strSQLGroupBySubQuery);
		}
		strSQL = strSQL.concat(" ) t ");

		
		return strSQL;
	}

	private String getConsultaIndicadorEfiCicBI(BiFiltroDTO filtroBI, FiltroAgrupamentoBI agrupamento) {
		String strSQL = "";
		String strSQLGroupBySubQuery = " a.CdInjetora, a.CdMolde, a.CdEstrutura, a.DtHrIValCic, c.CicloPadrao ";
		String strSQLIndicadores = "";
		String strSQLTotaisSubQuery = "";
		String strSQLTabelasSubQuery = "";
		String strSQLWhereSubQuery = "";
		String strSQLHavingSubQuery = " HAVING SUM(a.tmpcicnormal) > 0 AND SUM(a.qtdciclosnormais) > 0 ";
		
		
		// indicadores		
		strSQLIndicadores = strSQLIndicadores.concat(" AVG(t.ciclopadrao) as ciclopadraomedio, ");
		strSQLIndicadores = strSQLIndicadores.concat(" AVG(t.tmpcicnormal / t.qtdciclosnormais) as ciclolidomedio ");
		
		
		// sub-totais
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(a.tmpcicnormal) as tmpcicnormal, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(a.qtdciclosnormais) as qtdciclosnormais ");
		
		
		if (!filtroBI.getAnoIni().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  FROM viewBIAnoMesTempos a ");
		} else {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  FROM viewBIDtRefTempos a ");
		}
		
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN ijfictec c ON (    c.cdinjetora = a.cdinjetora ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("                     AND c.cdmolde = a.cdmolde ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("                     AND c.cdestrutura = a.cdestrutura ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("                     AND c.dthrivalcic = a.dthrivalcic) ");
		
		// tabelas relacionadas a grupo de maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");		
		} else {
			if (!filtroBI.getCdClasseMaquina().equals("")) {
				strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  LEFT JOIN ijtbinjclassABC h ON (h.cdinjetora = a.cdinjetora) ");
			} else {
				if (!filtroBI.getCdGalpao().equals("")) {
					strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN ijgalobj gal ON (gal.cdinjetora = a.cdinjetora) ");
				}
			} 
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");	
		}

		
		if (!filtroBI.getCdProduto().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN ijmolpro mp ON (    mp.cdmolde = c.cdmolde ");
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("                      AND mp.cdestrutura = c.cdestrutura ");
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("                      AND mp.dthrival = c.dthrivalestru) ");	
		}
		
		// filtros		
		if (!filtroBI.getAnoIni().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" WHERE a.anomes BETWEEN :anomesini AND :anomesfim ");
		} else {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" WHERE a.dtturno BETWEEN :dthrini AND :dthrfim ");	
		}


		if (!filtroBI.getCdTurno().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" AND a.cdturno = :cdturno ");
		}
		
		if (!filtroBI.getCdPt().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND a.cdinjestendido = :cdpt ");	
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND gm.cdgrpinj = :cdgt ");		
			} else {	
				if (!filtroBI.getCdClasseMaquina().equals("")) {
					strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND h.classe = :cdclasse ");	
				} else {
					if (!filtroBI.getCdGalpao().equals("")) {
						strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND gal.cdgalpao = :cdgalpao ");
					}					
				}
				
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND a.cdmolestendido = :cdrap ");	
		}
		
		// estrutura - eventualmente necessaria para efic ciclo
		if (!filtroBI.getCdEstrutura().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND a.cdestrutura = :cdestrutura ");	
		}
				
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND gf.cdgrpmol = :cdgrprap ");	
		}
		
		if (!filtroBI.getCdProduto().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND mp.cdproduto = :cdproduto ");	
		}
		
		
		strSQL = "SELECT ";
		strSQL = strSQL.concat(strSQLIndicadores);
		
		strSQL = strSQL.concat(" FROM (SELECT ");
		strSQL = strSQL.concat(strSQLGroupBySubQuery + ", ");
		strSQL = strSQL.concat(strSQLTotaisSubQuery);
		strSQL = strSQL.concat(strSQLTabelasSubQuery);
		strSQL = strSQL.concat(strSQLWhereSubQuery);		
		strSQL = strSQL.concat("GROUP BY " + strSQLGroupBySubQuery);
		strSQL = strSQL.concat(strSQLHavingSubQuery);
		strSQL = strSQL.concat(" ) t ");
		
		
		return strSQL;
	}

	private String getConsultaDistinctIndicadorEfiCicPondBI(BiFiltroDTO filtroBI, FiltroAgrupamentoBI agrupamento) {
		String strSQL = "";
		
		strSQL = strSQL.concat("SELECT a.CdMolde, a.CdEstrutura, a.DtHrIValCic, COUNT(DISTINCT a.cdinjetora) ");
		
		if (!filtroBI.getAnoIni().equals("")) {
			strSQL = strSQL.concat("  FROM viewBIAnoMesTempos a ");
		} else {
			strSQL = strSQL.concat("  FROM viewBIDtRefTempos a ");
		}
		
		
		// tabelas relacionadas a grupo de maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");		
		} else {
			if (!filtroBI.getCdClasseMaquina().equals("")) {
				strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC h ON (h.cdinjetora = a.cdinjetora) ");
			} else {
				if (!filtroBI.getCdGalpao().equals("")) {
					strSQL = strSQL.concat("  JOIN ijgalobj gal ON (gal.cdinjetora = a.cdinjetora) ");
				}
			} 
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");	
		}

		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat(" JOIN ijfictec c ON (    c.cdinjetora = a.cdinjetora ");
			strSQL = strSQL.concat("                     AND c.cdmolde = a.cdmolde ");
			strSQL = strSQL.concat("                     AND c.cdestrutura = a.cdestrutura ");
			strSQL = strSQL.concat("                     AND c.dthrivalcic = a.dthrivalcic) ");						
			strSQL = strSQL.concat(" JOIN ijmolpro mp ON (    mp.cdmolde = c.cdmolde ");
			strSQL = strSQL.concat("                      AND mp.cdestrutura = c.cdestrutura ");
			strSQL = strSQL.concat("                      AND mp.dthrival = c.dthrivalestru) ");	
		}
		

		// filtros		
		if (!filtroBI.getAnoIni().equals("")) {
			strSQL = strSQL.concat(" WHERE a.anomes BETWEEN :anomesini AND :anomesfim ");
		} else {
			strSQL = strSQL.concat(" WHERE a.dtturno BETWEEN :dthrini AND :dthrfim ");	
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
				if (!filtroBI.getCdClasseMaquina().equals("")) {
					strSQL = strSQL.concat("  AND h.classe = :cdclasse ");	
				} else {
					if (!filtroBI.getCdGalpao().equals("")) {
						strSQL = strSQL.concat("  AND gal.cdgalpao = :cdgalpao ");
					}					
				}				
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND a.cdmolestendido = :cdrap ");	
		}
		
		// estrutura - eventualmente necessaria para efic ciclo
		if (!filtroBI.getCdEstrutura().equals("")) {
			strSQL = strSQL.concat("  AND a.cdestrutura = :cdestrutura ");	
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");	
		}
		
		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat("  AND mp.cdproduto = :cdproduto ");	
		}
		
		strSQL = strSQL.concat("   AND a.qtdciclosnormais > 0");
		strSQL = strSQL.concat(" GROUP BY a.cdmolde, a.cdestrutura, a.dthrivalcic ");
		strSQL = strSQL.concat(" HAVING COUNT(DISTINCT a.cdinjetora) > 1 ");
		
		return strSQL;
	}

	private String getConsultaIndicadorEfiCicPondBI(BiFiltroDTO filtroBI, FiltroAgrupamentoBI agrupamento) {
		String strSQL = "";
		
		
		strSQL = strSQL.concat("SELECT AVG(ecp.efixtempoativo / ecp.tempoativo) as eficicpond ");
		strSQL = strSQL.concat("  FROM ( ");
		
		strSQL = strSQL.concat("        SELECT p.cdmolde, p.cdestrutura, p.dthrivalcic, ");
		strSQL = strSQL.concat("               SUM(p.eficic * p.tmpativo) as efixtempoativo, ");
		strSQL = strSQL.concat("               SUM(p.tmpativo) as tempoativo ");
		strSQL = strSQL.concat("          FROM ( ");
		
		strSQL = strSQL.concat("                 SELECT t.*, ");
		strSQL = strSQL.concat("                        (t.ciclopadrao / (t.tmpcicnormal / t.qtdciclosnormais) ) * 100 as eficic ");
		strSQL = strSQL.concat("                   FROM ( ");
		
		
		// inicio sub-query		
		strSQL = strSQL.concat("						 SELECT a.CdInjetora, a.CdMolde, a.CdEstrutura, a.DtHrIValCic, c.ciclopadrao,");
		strSQL = strSQL.concat("       						    SUM(a.tmpcicnormal) as tmpcicnormal, ");
		strSQL = strSQL.concat("       							SUM(a.qtdciclosnormais) as qtdciclosnormais, ");
		strSQL = strSQL.concat("       						    SUM(a.tmpativo) as tmpativo ");	
		
		if (!filtroBI.getAnoIni().equals("")) {
			strSQL = strSQL.concat("  FROM viewBIAnoMesTempos a ");
		} else {
			strSQL = strSQL.concat("  FROM viewBIDtRefTempos a ");
		}
		
		strSQL = strSQL.concat(" JOIN ijfictec c ON (    c.cdinjetora = a.cdinjetora ");
		strSQL = strSQL.concat("                     AND c.cdmolde = a.cdmolde ");
		strSQL = strSQL.concat("                     AND c.cdestrutura = a.cdestrutura ");
		strSQL = strSQL.concat("                     AND c.dthrivalcic = a.dthrivalcic) ");
		
		
		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat(" JOIN ijmolpro mp ON (    mp.cdmolde = c.cdmolde ");
			strSQL = strSQL.concat("                      AND mp.cdestrutura = c.cdestrutura ");
			strSQL = strSQL.concat("                      AND mp.dthrival = c.dthrivalestru) ");	
		}		
		
		// tabelas relacionadas a grupo de maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");		
		} else {
			if (!filtroBI.getCdClasseMaquina().equals("")) {
				strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC h ON (h.cdinjetora = a.cdinjetora) ");
			} else {
				if (!filtroBI.getCdGalpao().equals("")) {
					strSQL = strSQL.concat("  JOIN ijgalobj gal ON (gal.cdinjetora = a.cdinjetora) ");
				}
			}
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");	
		}

		
		
		
		// filtros		
		if (!filtroBI.getAnoIni().equals("")) {
			strSQL = strSQL.concat(" WHERE a.anomes BETWEEN :anomesini AND :anomesfim ");
		} else {
			strSQL = strSQL.concat(" WHERE a.dtturno BETWEEN :dthrini AND :dthrfim ");	
		}


		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cdturno = :cdturno ");
		}
		
		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND a.cdinjestendido = :cdpt ");	
		} else {
			if (filtroBI.getCdGt() != null && !filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  AND gm.cdgrpinj = :cdgt ");		
			} else {	
				if (!filtroBI.getCdClasseMaquina().equals("")) {
					strSQL = strSQL.concat("  AND h.classe = :cdclasse ");	
				} else {
					if (!filtroBI.getCdGalpao().equals("")) {
						strSQL = strSQL.concat("  AND gal.cdgalpao = :cdgalpao ");
					}
	
				}				
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND a.cdmolestendido = :cdrap ");	
		}
		
		// estrutura - eventualmente necessaria para efic ciclo
		if (!filtroBI.getCdEstrutura().equals("")) {
			strSQL = strSQL.concat("  AND a.cdestrutura = :cdestrutura ");	
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");	
		}
		
		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat("  AND mp.cdproduto = :cdproduto ");	
		}
			
		strSQL = strSQL.concat(" GROUP BY a.CdInjetora, a.CdMolde, a.CdEstrutura, a.DtHrIValCic, c.ciclopadrao ");
		strSQL = strSQL.concat(" HAVING SUM(a.tmpcicnormal) > 0 AND SUM(a.qtdciclosnormais) > 0 ");
		// fim sub-query
		
		
		strSQL = strSQL.concat(" 				) t ");
		strSQL = strSQL.concat(" 		) p  ");
		strSQL = strSQL.concat(" 	GROUP BY p.cdmolde, p.cdestrutura, p.dthrivalcic ");
		strSQL = strSQL.concat(" ) ecp ");
		
		
		return strSQL;
	}

	private String getConsultaIndicadorIndPCABI(BiFiltroDTO filtroBI, FiltroAgrupamentoBI agrupamento) {
		String strSQL = "";
		String strSQLGroupBySubQuery = "";
		String strSQLIndicadores = "";
		String strSQLTabelasSubQuery = "";
		String strSQLWhereSubQuery = "";
		
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_GERAL) {
			strSQLGroupBySubQuery = "";
		} 
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_ANO_MES) {
			strSQLGroupBySubQuery = "a.anomes ";
		} 
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA) {
			strSQLGroupBySubQuery = "a.dtturno ";
		}
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA) {
			strSQLGroupBySubQuery = "a.cdinjestendido ";
		}
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_FERRAMENTA_ESTRUTURA) {
			strSQLGroupBySubQuery = "a.cdinjestendido, a.cdmolestendido ";
		} 				
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_TURNO) {
			strSQLGroupBySubQuery = "a.cdturno, tur.dsturno ";
		} 		
		
		// indicadores		
		strSQLIndicadores = strSQLIndicadores.concat(" SUM(t.qtcavativas) as qtcavativas, ");
		strSQLIndicadores = strSQLIndicadores.concat(" SUM(t.qtcavidades) as qtcavidades ");
		
		
		if (!filtroBI.getAnoIni().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  FROM viewBIAnoMesTempos a ");
		} else {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  FROM viewBIDtRefTempos a ");
		}
		
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN ijfictec c ON (    c.cdinjetora = a.cdinjetora ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("                     AND c.cdmolde = a.cdmolde ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("                     AND c.cdestrutura = a.cdestrutura ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("                     AND c.dthrivalcic = a.dthrivalcic) ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN ijmolpro d ON (    d.cdmolde  = c.cdmolde ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("                     AND d.cdestrutura = c.cdestrutura ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("                     AND d.dthrival = c.dthrivalestru) ");
			
			
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN ijtbtur tur ON (tur.cdturno = a.cdturno) ");
		
		
		// tabelas relacionadas a grupo de maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");		
		} else {
			if (!filtroBI.getCdClasseMaquina().equals("")) {
				strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  LEFT JOIN ijtbinjclassABC h ON (h.cdinjetora = a.cdinjetora) ");
			} else {				 
				if (!filtroBI.getCdGalpao().equals("")) {
					strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN ijgalobj gal ON (gal.cdinjetora = a.cdinjetora) ");
				}				
			}
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");	
		}

		
		// filtros		
		if (!filtroBI.getAnoIni().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" WHERE a.anomes BETWEEN :anomesini AND :anomesfim ");
		} else {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" WHERE a.dtturno BETWEEN :dthrini AND :dthrfim ");	
		}

		if (!filtroBI.getCdTurno().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" AND a.cdturno = :cdturno ");
		}
		
		if (!filtroBI.getCdPt().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND a.cdinjestendido = :cdpt ");	
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND gm.cdgrpinj = :cdgt ");		
			} else {	
				if (!filtroBI.getCdClasseMaquina().equals("")) {
					strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND h.classe = :cdclasse ");	
				} else {
					if (!filtroBI.getCdGalpao().equals("")) {
						strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND gal.cdgalpao = :cdgalpao ");
					}
				}
				
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND a.cdmolestendido = :cdrap ");	
		}
		
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND gf.cdgrpmol = :cdgrprap ");	
		}
		
		if (!filtroBI.getCdProduto().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND d.cdproduto = :cdproduto ");	
		}
		
		
		strSQL = "SELECT ";
		
		strSQL = strSQL.concat(strSQLIndicadores);
		
		strSQL = strSQL.concat(" FROM (SELECT DISTINCT ");
		
		if (!strSQLGroupBySubQuery.equals("")) {
			strSQL = strSQL.concat(strSQLGroupBySubQuery + ", ");
		}
		strSQL = strSQL.concat(" a.CdInjetora, a.CdMolde, a.CdEstrutura, d.cdproduto, d.qtcavativas, d.qtcavidades ");
		
		strSQL = strSQL.concat(strSQLTabelasSubQuery);
		strSQL = strSQL.concat(strSQLWhereSubQuery);	
		
		strSQL = strSQL.concat(" ) t ");

		return strSQL;
	}

	public BiResumoDTO resumoBI(BiFiltroDTO filtroBI, FiltroAgrupamentoBI agrupamento) {
		BiResumoDTO resumo = new BiResumoDTO();
		
		
		// se parametros com null, seta para ""
		if (filtroBI.getAnoIni() == null) {
			filtroBI.setAnoIni("");
			filtroBI.setMesIni("");
			filtroBI.setAnoFim("");
			filtroBI.setMesFim("");
		}
		
		if (filtroBI.getCdTurno() == null) {
			filtroBI.setCdTurno("");
		}
		
		if (filtroBI.getCdPt() == null) {
			filtroBI.setCdPt("");
		}
		
		if (filtroBI.getCdGt() == null) {
			filtroBI.setCdGt("");
		}
		
		if (filtroBI.getCdClasseMaquina() == null) {
			filtroBI.setCdClasseMaquina("");
		}
		
		if (filtroBI.getCdRap() == null) {
			filtroBI.setCdRap("");
		}
		
		if (filtroBI.getCdEstrutura() == null) {
			filtroBI.setCdEstrutura("");
		}
		
		if (filtroBI.getCdGrpRap() == null) {
			filtroBI.setCdGrpRap("");
		}
		
		if (filtroBI.getCdProduto() == null) {
			filtroBI.setCdProduto("");
		}
		
		if (filtroBI.getCdGalpao() == null) {
			filtroBI.setCdGalpao("");
		}
		
		//necessarios para exibicao no cabecalho do BI
		filtroBI.setDsTurno("");
		filtroBI.setDsPt("");
		filtroBI.setDsGt("");
		filtroBI.setDsGrpRap("");
		filtroBI.setDsProduto("");	

		if (! filtroBI.getCdTurno().equals("")) {
			TurnoInjetRN rnT = new TurnoInjetRN(getDao());
			TurnoDTO turno = rnT.getTurnoInjet(filtroBI.getCdTurno());
			filtroBI.setDsTurno(turno.getDsTurno());
		}
		 
		if (! filtroBI.getCdPt().equals("")) {			
			OmPtDAO omPtDAO = new OmPtDAO(getDao().getSession());
			OmPt omPt = omPtDAO.getOmPtAtivoComUltimaRevisaoInjet(getDao(), filtroBI.getCdPt());
			filtroBI.setDsPt(omPt.getDsPt());			
		}
		
		if (! filtroBI.getCdGt().equals("")) {
			DiversosInjetRN rnI = new DiversosInjetRN(getDao());
			OmGt omGt = rnI.pesquisarIjGrpMap(filtroBI.getCdGt());
			filtroBI.setDsGt(omGt.getDsGt());
		}
		
		if (! filtroBI.getCdGrpRap().equals("")) {
			DiversosInjetRN rnI = new DiversosInjetRN(getDao());
			Ijgrpmol gm =  rnI.pesquisarIjGrpMol(filtroBI.getCdGrpRap());
			filtroBI.setDsGrpRap(gm.getDsgrpmol());
		}
		
		if (! filtroBI.getCdProduto().equals("")) {
			ProdutoInjetRN rnP = new ProdutoInjetRN(getDao());
			Ijtbpro pro = rnP.pesquisaIjTbPro(filtroBI.getCdProduto());
			filtroBI.setDsProduto(pro.getDsproduto());
		}
		
		
		// inicializa listas
		resumo.setTemposDiagrama(new PtTemposDTO());
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_ANO_MES) {
			resumo.setIndicadoresAnoMes(new ArrayList<BiIndicadoresAnoMesDTO>());			
		}
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA) {
			resumo.setIndicadoresDtRef(new ArrayList<BiIndicadoresDtRefDTO>());
		}
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA) {
			resumo.setIndicadoresPt(new ArrayList<BiIndicadoresPTDTO>());
		}
		
		if (filtroBI.getCdTurno().equals("")) {
			resumo.setIndicadoresTurno(new ArrayList<BiIndicadoresTurnoDTO>());	
		}
		
		if (! filtroBI.getCdProduto().equals("")) {
			resumo.setIndicadoresFichaTec(new ArrayList<BiIndicadoresFicTecDTO>());
		}
		
		//metas
		indicadorRN = new DetalheMonitorizacaoWebIndicadorInjetRN(getDao(), formatoData, formatoDataHora);
		List<MetaIndicadorDTO> listaMetaIndicadores = indicadorRN.getMetaIndicadores(getDao());
		List<MetaIndicadorDTO> listaMetaIndicadoresPontos = indicadorRN.getMetaIndicadoresGraficoPontos(getDao());
		resumo.setMetaIndicadores(listaMetaIndicadores);
		resumo.setMetaIndicadoresGraficoPontos(listaMetaIndicadoresPontos);
		resumo.setFiltroBI(cloneBiFiltroDTO(filtroBI));
		
		// total geral
		List<ResumoBI> listaIndicadoresBI = new ArrayList<ResumoBI>();
		listaIndicadoresBI = resumoIndicadoresBI(filtroBI, FiltroAgrupamentoBI.BI_TOTAL_GERAL, listaMetaIndicadores);
		if (listaIndicadoresBI.size() > 0) {
			resumo.setIndicadores(listaIndicadoresBI.get(0).indicadoresBI);
			resumo.setTemposDiagrama(listaIndicadoresBI.get(0).temposDiagrama);
			resumo.setGraficoPerdasPizza(listaIndicadoresBI.get(0).graficoPerdasPizza);
			resumo.setFiltroBI(filtroBI);
			
			// inicializa listas
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_ANO_MES) {
				listaIndicadoresBI = resumoIndicadoresBI(filtroBI, FiltroAgrupamentoBI.BI_TOTAL_ANO_MES, listaMetaIndicadores);
				resumo.setIndicadoresAnoMes(resumoMesAno(filtroBI, listaIndicadoresBI));
			}
			
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA) {
				listaIndicadoresBI = resumoIndicadoresBI(filtroBI, FiltroAgrupamentoBI.BI_TOTAL_DATA, listaMetaIndicadores);
				resumo.setIndicadoresDtRef(resumoDtRef(filtroBI, listaIndicadoresBI));
			}
			
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA) {
				listaIndicadoresBI = resumoIndicadoresBI(filtroBI, FiltroAgrupamentoBI.BI_TOTAL_MAQUINA, listaMetaIndicadores);
				resumo.setIndicadoresPt(resumoPt(filtroBI, listaIndicadoresBI));
			}
			
			if (filtroBI.getCdTurno().equals("")  && (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA || agrupamento == FiltroAgrupamentoBI.BI_TOTAL_ANO_MES)) {
				listaIndicadoresBI = resumoIndicadoresBI(filtroBI, FiltroAgrupamentoBI.BI_TOTAL_TURNO, listaMetaIndicadores);
				resumo.setIndicadoresTurno(resumoTurnos(filtroBI, listaIndicadoresBI, agrupamento, listaMetaIndicadores));
			}		
						
			// quando exite filtro de produto precisa montar grafico com maquinas que fabricam o produto
			if (! filtroBI.getCdProduto().equals("")) {
				if (agrupamento != FiltroAgrupamentoBI.BI_TOTAL_MAQUINA) {
					listaIndicadoresBI = resumoIndicadoresBI(filtroBI, FiltroAgrupamentoBI.BI_TOTAL_MAQUINA, listaMetaIndicadores);
					resumo.setIndicadoresPt(resumoPtDetProduto(filtroBI, listaIndicadoresBI));
				}
				
				List<ResumoBI> listaIndicadoresProduto = new ArrayList<ResumoBI>();
				listaIndicadoresProduto = resumoIndicadoresBI(filtroBI, FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_FERRAMENTA_ESTRUTURA, listaMetaIndicadores);
				resumo.setIndicadoresFichaTec(resumoGraficoProduto(filtroBI, listaIndicadoresProduto));							
			}		
		}
		
		return resumo;
	}
		
	private List<GraficoPizzaDTO> getGraficoPerdasProducao(BiIndicadoresDTO dto) {
		List<GraficoPizzaDTO> listaPerdas = new ArrayList<>();

		BigDecimal perdaCicloValor = ConversaoTipos.converterParaBigDecimal(dto.getPcsRitmo()); 
		BigDecimal perdaRefugoValor = ConversaoTipos.converterParaBigDecimal(dto.getPcsProdRefugada());
		BigDecimal perdaParadaValor = ConversaoTipos.converterParaBigDecimal(dto.getPcsPerdasParComPeso());
		BigDecimal perdaPCIValor = ConversaoTipos.converterParaBigDecimal(dto.getPcsPerdasPCI());


		BigDecimal perdaTotal = BigDecimal.ZERO;
		perdaTotal = perdaTotal.add(perdaCicloValor);
		perdaTotal = perdaTotal.add(perdaRefugoValor);
		perdaTotal = perdaTotal.add(perdaParadaValor);
		perdaTotal = perdaTotal.add(perdaPCIValor);

		GraficoPizzaDTO perdaCiclo = new GraficoPizzaDTO();
		GraficoPizzaDTO perdaRefugo = new GraficoPizzaDTO();
		GraficoPizzaDTO perdaParada = new GraficoPizzaDTO();
		GraficoPizzaDTO perdaCavidadesInativas = new GraficoPizzaDTO();

		
		if (perdaCicloValor.doubleValue() > 0) {			
			perdaCiclo.setCodigo("Ciclo");
			perdaCiclo.setValor(ConversaoTipos.converteParaString(perdaCicloValor, 2));
			perdaCiclo.setIndice(ConversaoTipos.converteParaString(FormulasInjet.calcularIndiceDisponibilidade(perdaCicloValor, perdaTotal), 2));
			perdaCiclo.setCor(Cor.transformarParaCodigoHexadecimal(new Color(51, 255, 51)));
		} else {
			// desconsiderar o ganho por ciclo 
			perdaTotal = perdaTotal.add(perdaCicloValor.abs());
			
			perdaCiclo.setCodigo("Ciclo");
			perdaCiclo.setValor(ConversaoTipos.converteParaString(BigDecimal.ZERO, 2));
			perdaCiclo.setIndice(ConversaoTipos.converteParaString(BigDecimal.ZERO, 2));
			perdaCiclo.setCor(Cor.transformarParaCodigoHexadecimal(new Color(51, 255, 51)));			
		}

			
		perdaRefugo.setCodigo("Refugo");
		perdaRefugo.setValor(ConversaoTipos.converteParaString(perdaRefugoValor, 2));
		perdaRefugo.setIndice(ConversaoTipos.converteParaString(FormulasInjet.calcularIndiceDisponibilidade(perdaRefugoValor, perdaTotal), 2));
		perdaRefugo.setCor(Cor.transformarParaCodigoHexadecimal(new Color(255, 153, 153)));

		
		perdaParada.setCodigo("Parada");
		perdaParada.setValor(ConversaoTipos.converteParaString(perdaParadaValor, 2));
		perdaParada.setIndice(ConversaoTipos.converteParaString(FormulasInjet.calcularIndiceDisponibilidade(perdaParadaValor, perdaTotal), 2));
		perdaParada.setCor(Cor.transformarParaCodigoHexadecimal(new Color(255, 51, 51)));

		
		perdaCavidadesInativas.setCodigo("Cav. Inativas");
		perdaCavidadesInativas.setValor(ConversaoTipos.converteParaString(perdaPCIValor, 2));
		perdaCavidadesInativas.setIndice(ConversaoTipos.converteParaString(FormulasInjet.calcularIndiceDisponibilidade(perdaPCIValor, perdaTotal), 2));
		perdaCavidadesInativas.setCor(Cor.transformarParaCodigoHexadecimal(new Color(102, 153, 255)));

		listaPerdas.add(perdaCiclo);
		listaPerdas.add(perdaRefugo);
		listaPerdas.add(perdaParada);
		listaPerdas.add(perdaCavidadesInativas);
		
		return listaPerdas;
	}

	
	public List<BiIndicadoresAnoMesDTO> resumoMesAno(BiFiltroDTO filtroBI, List<ResumoBI> listaIndicadores) {
		List<BiIndicadoresAnoMesDTO> resumo = new ArrayList<BiIndicadoresAnoMesDTO> ();
		
		for (ResumoBI item : listaIndicadores) {
			BiFiltroDTO filtroItem = cloneBiFiltroDTO(filtroBI);
			
			// filtro de cada barra deve conter periodo dos dias

			/*
			filtroItem.setAnoIni(item.ano);
			filtroItem.setMesIni(item.mes);
			filtroItem.setAnoFim(item.ano);
			filtroItem.setMesFim(item.mes);
			*/
			
			
			filtroItem.setAnoIni("");
			filtroItem.setMesIni("");
			filtroItem.setAnoFim("");
			filtroItem.setMesFim("");
			filtroItem.setAgrupamentoBI(FiltroAgrupamentoBI.BI_TOTAL_DATA.valor);
			filtroItem.setDtIni(DataHoraRN.dateToStringYYYYMMDDHHMMSS(DataHoraRN.getInicioMes(ConversaoTipos.converteParaInt(item.ano), ConversaoTipos.converteParaInt(item.mes))));
			filtroItem.setDtFim(DataHoraRN.dateToStringYYYYMMDDHHMMSS(DataHoraRN.getFimMes(ConversaoTipos.converteParaInt(item.ano), ConversaoTipos.converteParaInt(item.mes))));
			
			BiIndicadoresAnoMesDTO indicador = new BiIndicadoresAnoMesDTO();
			indicador.setAno(item.ano);
			indicador.setMes(item.mes);
			indicador.setFiltro(filtroItem);
			indicador.setIndicadores(item.indicadoresBI);
			indicador.setIndicadoresGrafico(item.indicadoresGrafico);
			indicador.setIndicadoresGraficoPerda(item.indicadoresPerdaGrafico);
			indicador.setTemposDiagrama(item.temposDiagrama);
			indicador.setGraficoPerdasPizza(item.graficoPerdasPizza);
			
			resumo.add(indicador);
		}
				
		Collections.sort(resumo, comparaAnoMes);
		
		return resumo;
	}

	public List<BiIndicadoresDtRefDTO> resumoDtRef(BiFiltroDTO filtroBI, List<ResumoBI> listaIndicadores) {
		List<BiIndicadoresDtRefDTO> resumo = new ArrayList<BiIndicadoresDtRefDTO> ();
		
		for (ResumoBI item : listaIndicadores) {
			BiFiltroDTO filtroItem = cloneBiFiltroDTO(filtroBI);
			filtroItem.setDtIni(DataHoraRN.dateToStringYYYYMMDDHHMMSS((item.dtTurno)));
			filtroItem.setDtFim(DataHoraRN.dateToStringYYYYMMDDHHMMSS(item.dtTurno));
			
			BiIndicadoresDtRefDTO indicador = new BiIndicadoresDtRefDTO();
			indicador.setDtTurno(item.dtTurno);
			indicador.setFiltro(filtroItem);
			indicador.setIndicadores(item.indicadoresBI);
			indicador.setIndicadoresGrafico(item.indicadoresGrafico);
			indicador.setIndicadoresGraficoPerda(item.indicadoresPerdaGrafico);
			indicador.setTemposDiagrama(item.temposDiagrama);
			indicador.setGraficoPerdasPizza(item.graficoPerdasPizza);

			resumo.add(indicador);
		}
				
		Collections.sort(resumo, comparaDtRef);
		
		return resumo;
	}
	
	public List<BiIndicadoresPTDTO> resumoPt(BiFiltroDTO filtroBI, List<ResumoBI> listaIndicadores) {
		List<BiIndicadoresPTDTO> resumo = new ArrayList<BiIndicadoresPTDTO> ();
		
		for (ResumoBI item : listaIndicadores) {
			BiFiltroDTO filtroItem = cloneBiFiltroDTO(filtroBI);
			filtroItem.setCdPt(item.cdPt);
			
			BiIndicadoresPTDTO indicador = new BiIndicadoresPTDTO();
			indicador.setCdPt(item.cdPt);
			indicador.setFiltro(filtroItem);
			indicador.setIndicadores(item.indicadoresBI);
			indicador.setIndicadoresGrafico(item.indicadoresGrafico);
			indicador.setTemposDiagrama(item.temposDiagrama);
			indicador.setGraficoPerdasPizza(item.graficoPerdasPizza);

			resumo.add(indicador);
		}
				
		Collections.sort(resumo, comparaPt);
		
		return resumo;
	}	

	public List<BiIndicadoresPTDTO> resumoPtDetProduto(BiFiltroDTO filtroBI, List<ResumoBI> listaIndicadores) {
		List<BiIndicadoresPTDTO> resumo = new ArrayList<BiIndicadoresPTDTO> ();
		
		for (ResumoBI item : listaIndicadores) {
			BiFiltroDTO filtroItem = cloneBiFiltroDTO(filtroBI);
			filtroItem.setCdPt(item.cdPt);
			
			BiIndicadoresPTDTO indicador = new BiIndicadoresPTDTO();
			indicador.setCdPt(item.cdPt);
			indicador.setFiltro(filtroItem);
			indicador.setIndicadores(item.indicadoresBI);
			indicador.setIndicadoresGrafico(item.indicadoresGrafico);
			indicador.setTemposDiagrama(item.temposDiagrama);
			indicador.setGraficoPerdasPizza(item.graficoPerdasPizza);

			resumo.add(indicador);
		}
				
		Collections.sort(resumo, comparaPtDetProduto);
		
		return resumo;
	}	
	
	public List<BiIndicadoresFicTecDTO> resumoGraficoProduto(BiFiltroDTO filtroBI, List<ResumoBI> listaIndicadores) {
		List<BiIndicadoresFicTecDTO> resumo = new ArrayList<BiIndicadoresFicTecDTO>();
		
		for (ResumoBI item : listaIndicadores) {
			BiFiltroDTO filtroItem = cloneBiFiltroDTO(filtroBI);
			filtroItem.setCdPt(item.cdPt);
			
			BiIndicadoresFicTecDTO indicador = new BiIndicadoresFicTecDTO();
			indicador.setCdPt(item.cdPt);
			indicador.setCdRap(item.cdRap);
			indicador.setCdEstrutura(item.cdEstrutura);
			indicador.setIndicadores(item.indicadoresBI);
			
			resumo.add(indicador);
		}
				
		Collections.sort(resumo, comparaDetalhesGraficoProduto);
		
		return resumo;
	}	
	
	public List<BiIndicadoresTurnoDTO> resumoTurnos(BiFiltroDTO filtroBI, List<ResumoBI> listaIndicadores, FiltroAgrupamentoBI agrupamento, List<MetaIndicadorDTO> listaMetaIndicadores) {
		List<BiIndicadoresTurnoDTO> resumo = new ArrayList<BiIndicadoresTurnoDTO> ();
		
		for (ResumoBI item : listaIndicadores) {
			BiFiltroDTO filtroItem = cloneBiFiltroDTO(filtroBI);
			filtroItem.setCdTurno(item.cdTurno);
			
			BiIndicadoresTurnoDTO indicador = new BiIndicadoresTurnoDTO();
			indicador.setCdTurno(item.cdTurno);
			indicador.setDsTurno(item.dsTurno);
			indicador.setFiltro(filtroItem);
			indicador.setIndicadores(item.indicadoresBI);
			//indicador.setGraficoPerdasPizza(item.graficoPerdasPizza);
			//indicador.setTemposDiagrama(item.temposDiagrama);
			
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA) {
				List<ResumoBI> listaIndicadoresBI = resumoIndicadoresBI(filtroItem, FiltroAgrupamentoBI.BI_TOTAL_DATA, listaMetaIndicadores);
				//indicador.setIndicadoresDtRef(resumoDtRef(filtroItem, listaIndicadoresBI));
			}

			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_ANO_MES) {
				List<ResumoBI> listaIndicadoresBI = resumoIndicadoresBI(filtroItem, FiltroAgrupamentoBI.BI_TOTAL_ANO_MES, listaMetaIndicadores);
				//indicador.setIndicadoresAnoMes(resumoMesAno(filtroItem, listaIndicadoresBI));
			}

			resumo.add(indicador);
		}
		
		Collections.sort(resumo, comparaTurno);
		
		return resumo;
	}	
		
	public BiFiltroDTO cloneBiFiltroDTO(BiFiltroDTO filtroOrigem) {
		BiFiltroDTO filtroClone = new BiFiltroDTO();
		
		filtroClone.setAgrupamentoBI(filtroOrigem.getAgrupamentoBI());
		filtroClone.setAnoIni(filtroOrigem.getAnoIni());
		filtroClone.setMesIni(filtroOrigem.getMesIni());
		filtroClone.setAnoFim(filtroOrigem.getAnoFim());
		filtroClone.setMesFim(filtroOrigem.getMesFim());
		filtroClone.setDtIni(filtroOrigem.getDtIni());
		filtroClone.setDtFim(filtroOrigem.getDtFim());
		filtroClone.setCdTurno(filtroOrigem.getCdTurno());
		filtroClone.setCdPt(filtroOrigem.getCdPt());
		filtroClone.setCdGt(filtroOrigem.getCdGt());
		filtroClone.setCdClasseMaquina(filtroOrigem.getCdClasseMaquina());
		filtroClone.setCdRap(filtroOrigem.getCdRap());
		filtroClone.setCdEstrutura(filtroOrigem.getCdEstrutura());
		filtroClone.setCdGrpRap(filtroOrigem.getCdGrpRap());
		filtroClone.setCdProduto(filtroOrigem.getCdProduto());
		filtroClone.setCdGalpao(filtroOrigem.getCdGalpao());
		
		filtroClone.setDsTurno(filtroOrigem.getDsTurno());
		filtroClone.setDsPt(filtroOrigem.getDsPt());
		filtroClone.setDsGt(filtroOrigem.getDsGt());
		filtroClone.setDsGrpRap(filtroOrigem.getDsGrpRap());
		filtroClone.setDsProduto(filtroOrigem.getDsProduto());
		
		
		return filtroClone;
	}

	public BiFiltroDTO filtroBiTransformado(BiFiltroDTO filtroOrigem) {
		BiFiltroDTO filtroBI = cloneBiFiltroDTO(filtroOrigem);

		if (filtroBI.getAgrupamentoBI() == FiltroAgrupamentoBI.BI_TOTAL_ANO_MES.getValor()) {
			// altera agrupamento
			filtroBI.setAgrupamentoBI(FiltroAgrupamentoBI.BI_TOTAL_DATA.getValor());

			// atribui periodo
			filtroBI.setDtIni(DataHoraRN.dateToStringYYYYMMDDHHMMSS(DataHoraRN.getInicioMes(ConversaoTipos.converteParaInt(filtroBI.getAnoIni()),
					ConversaoTipos.converteParaInt(filtroBI.getMesIni()))));
			filtroBI.setDtFim(DataHoraRN.dateToStringYYYYMMDDHHMMSS(DataHoraRN.getFimMes(ConversaoTipos.converteParaInt(filtroBI.getAnoFim()),
					ConversaoTipos.converteParaInt(filtroBI.getMesFim()))));

			// zera ano/mes
			filtroBI.setAnoIni("");
			filtroBI.setMesIni("");
			filtroBI.setAnoFim("");
			filtroBI.setMesFim("");
		}
		
		
			
		if (filtroOrigem.getFiltroBIParetoParada() != null) {
			filtroBI.setFiltroBIParetoParada(new FiltroBIParetoParadaDTO());
			filtroBI.getFiltroBIParetoParada().setCdAreaResp(filtroOrigem.getFiltroBIParetoParada().getCdAreaResp());
			filtroBI.getFiltroBIParetoParada().setIsComPeso(filtroOrigem.getFiltroBIParetoParada().getIsComPeso());
			
		}
		if (filtroOrigem.getFiltroBIPizzaAreaRespPar() != null) {
			filtroBI.setFiltroBIPizzaAreaRespPar(new FiltroBIPizzaAreaRespParDTO());
			filtroBI.getFiltroBIPizzaAreaRespPar().setIsComPeso(filtroOrigem.getFiltroBIPizzaAreaRespPar().getIsComPeso());
			
		}
		
		if (filtroOrigem.getFiltroBIParetoRefugo() != null) {
			filtroBI.setFiltroBIParetoRefugo(new FiltroBIParetoRefugoDTO());
			filtroBI.getFiltroBIParetoRefugo().setCdRefugo(filtroOrigem.getFiltroBIParetoRefugo().getCdRefugo());
			filtroBI.getFiltroBIParetoRefugo().setOrdenacaoPareto(filtroOrigem.getFiltroBIParetoRefugo().getOrdenacaoPareto());
			
			
		}

		if (filtroOrigem.getFiltroBIParetoPerdasParada() != null) {
			filtroBI.setFiltroBIParetoPerdasParada(new FiltroBIParetoPerdasParadaDTO());
			filtroBI.getFiltroBIParetoPerdasParada().setCdAreaResp(filtroOrigem.getFiltroBIParetoPerdasParada().getCdAreaResp());
			filtroBI.getFiltroBIParetoPerdasParada().setCdParada(filtroOrigem.getFiltroBIParetoPerdasParada().getCdParada());
			filtroBI.getFiltroBIParetoPerdasParada().setIsComPeso(filtroOrigem.getFiltroBIParetoPerdasParada().getIsComPeso());
			filtroBI.getFiltroBIParetoPerdasParada().setOrdenacaoPareto(filtroOrigem.getFiltroBIParetoPerdasParada().getOrdenacaoPareto());
			
		}
		
		if (filtroOrigem.getFiltroBIParetoPerdasPCI() != null) {
			filtroBI.setFiltroBIParetoPerdasPCI(new FiltroBIParetoPerdasPCIDTO());
			filtroBI.getFiltroBIParetoPerdasPCI().setOrdenacaoPareto(filtroOrigem.getFiltroBIParetoPerdasPCI().getOrdenacaoPareto()); 
		}
		
		if (filtroOrigem.getFiltroBIParetoPerdasCiclo() != null) {
			filtroBI.setFiltroBIParetoPerdasCiclo(new FiltroBIParetoPerdasCicloDTO());
			filtroBI.getFiltroBIParetoPerdasCiclo().setOrdenacaoPareto(filtroOrigem.getFiltroBIParetoPerdasCiclo().getOrdenacaoPareto()); 
		}
		
		if (filtroOrigem.getFiltroBIParetoPerdasTodas() != null) {
			filtroBI.setFiltroBIParetoPerdasTodas(new FiltroBIParetoPerdasTodasDTO());
			filtroBI.getFiltroBIParetoPerdasTodas().setOrdenacaoPareto(filtroOrigem.getFiltroBIParetoPerdasTodas().getOrdenacaoPareto());
		}

		if (filtroOrigem.getFiltroBIPerdasRefugoProdDet() != null) {
			filtroBI.setFiltroBIPerdasRefugoProdDet(new FiltroBIPerdasRefugoProdDetDTO());
			filtroBI.getFiltroBIPerdasRefugoProdDet().setCdProdutoSelecaoPareto(filtroOrigem.getFiltroBIPerdasRefugoProdDet().getCdProdutoSelecaoPareto());
			filtroBI.getFiltroBIPerdasRefugoProdDet().setCdPtSelecaoPareto(filtroOrigem.getFiltroBIPerdasRefugoProdDet().getCdPtSelecaoPareto());
			filtroBI.getFiltroBIPerdasRefugoProdDet().setCdRefugo(filtroOrigem.getFiltroBIPerdasRefugoProdDet().getCdRefugo());
			filtroBI.getFiltroBIPerdasRefugoProdDet().setOrdenacaoPareto(filtroOrigem.getFiltroBIPerdasRefugoProdDet().getOrdenacaoPareto());
		}
		
		if (filtroOrigem.getFiltroBIPerdasRefugoMaqDet() != null) {
			filtroBI.setFiltroBIPerdasRefugoMaqDet(new FiltroBIPerdasRefugoMaqDetDTO());
			filtroBI.getFiltroBIPerdasRefugoMaqDet().setCdProdutoSelecaoPareto(filtroOrigem.getFiltroBIPerdasRefugoMaqDet().getCdProdutoSelecaoPareto());
			filtroBI.getFiltroBIPerdasRefugoMaqDet().setCdPtSelecaoPareto(filtroOrigem.getFiltroBIPerdasRefugoMaqDet().getCdPtSelecaoPareto());
			filtroBI.getFiltroBIPerdasRefugoMaqDet().setCdRefugo(filtroOrigem.getFiltroBIPerdasRefugoMaqDet().getCdRefugo());
		}
		
		if (filtroOrigem.getFiltroBIPerdasParadaProdDet() != null) {
			filtroBI.setFiltroBIPerdasParadaProdDet(new FiltroBIPerdasParadaProdDetDTO());
			filtroBI.getFiltroBIPerdasParadaProdDet().setCdParada(filtroOrigem.getFiltroBIPerdasParadaProdDet().getCdParada());
			filtroBI.getFiltroBIPerdasParadaProdDet().setCdProdutoSelecaoPareto(filtroOrigem.getFiltroBIPerdasParadaProdDet().getCdProdutoSelecaoPareto());
			filtroBI.getFiltroBIPerdasParadaProdDet().setCdPtSelecaoPareto(filtroOrigem.getFiltroBIPerdasParadaProdDet().getCdPtSelecaoPareto());
			filtroBI.getFiltroBIPerdasParadaProdDet().setIsParComPeso(filtroOrigem.getFiltroBIPerdasParadaProdDet().getIsParComPeso());
			filtroBI.getFiltroBIPerdasParadaProdDet().setOrdenacaoPareto(filtroOrigem.getFiltroBIPerdasParadaProdDet().getOrdenacaoPareto());
			
		}
		
		if (filtroOrigem.getFiltroBIPerdasParadaMaqDet() != null) {
			filtroBI.setFiltroBIPerdasParadaMaqDet(new FiltroBIPerdasParadaMaqDetDTO());
			filtroBI.getFiltroBIPerdasParadaMaqDet().setCdParada(filtroOrigem.getFiltroBIPerdasParadaMaqDet().getCdParada());
			filtroBI.getFiltroBIPerdasParadaMaqDet().setCdProdutoSelecaoPareto(filtroOrigem.getFiltroBIPerdasParadaMaqDet().getCdProdutoSelecaoPareto());
			filtroBI.getFiltroBIPerdasParadaMaqDet().setCdPtSelecaoPareto(filtroOrigem.getFiltroBIPerdasParadaMaqDet().getCdPtSelecaoPareto());
			filtroBI.getFiltroBIPerdasParadaMaqDet().setIsParComPeso(filtroOrigem.getFiltroBIPerdasParadaMaqDet().getIsParComPeso());
		}
		
		if (filtroOrigem.getFiltroBIPerdasAreaRespDet() != null) {
			filtroBI.setFiltroBIPerdasAreaRespDet(new FiltroBIPerdasAreaRespDetDTO() );
			filtroBI.getFiltroBIPerdasAreaRespDet().setCdArea(filtroOrigem.getFiltroBIPerdasAreaRespDet().getCdArea());
			filtroBI.getFiltroBIPerdasAreaRespDet().setCdParada(filtroOrigem.getFiltroBIPerdasAreaRespDet().getCdParada());
			filtroBI.getFiltroBIPerdasAreaRespDet().setCdProdutoSelecaoPareto(filtroOrigem.getFiltroBIPerdasAreaRespDet().getCdProdutoSelecaoPareto());
			filtroBI.getFiltroBIPerdasAreaRespDet().setCdPtSelecaoPareto(filtroOrigem.getFiltroBIPerdasAreaRespDet().getCdPtSelecaoPareto());
			filtroBI.getFiltroBIPerdasAreaRespDet().setIsParComPeso(filtroOrigem.getFiltroBIPerdasAreaRespDet().getIsParComPeso());
			filtroBI.getFiltroBIPerdasAreaRespDet().setOrdenacaoPareto(filtroOrigem.getFiltroBIPerdasAreaRespDet().getOrdenacaoPareto());
		
		}
		
		if (filtroOrigem.getFiltroBIPerdasCicloProdDet() != null) {
			filtroBI.setFiltroBIPerdasCicloProdDet(new FiltroBIPerdasCicloProdDetDTO());
			filtroBI.getFiltroBIPerdasCicloProdDet().setCdProdutoSelecaoPareto(filtroOrigem.getFiltroBIPerdasCicloProdDet().getCdProdutoSelecaoPareto());
			filtroBI.getFiltroBIPerdasCicloProdDet().setCdPtSelecaoPareto(filtroOrigem.getFiltroBIPerdasCicloProdDet().getCdPtSelecaoPareto());
			filtroBI.getFiltroBIPerdasCicloProdDet().setOrdenacaoPareto(filtroOrigem.getFiltroBIPerdasCicloProdDet().getOrdenacaoPareto());
		}
		
		if (filtroOrigem.getFiltroBIPerdasCicloMaqDet() != null) {
			filtroBI.setFiltroBIPerdasCicloMaqDet(new FiltroBIPerdasCicloMaqDetDTO());
			filtroBI.getFiltroBIPerdasCicloMaqDet().setCdProdutoSelecaoPareto(filtroOrigem.getFiltroBIPerdasCicloMaqDet().getCdProdutoSelecaoPareto());
			filtroBI.getFiltroBIPerdasCicloMaqDet().setCdPtSelecaoPareto(filtroOrigem.getFiltroBIPerdasCicloMaqDet().getCdPtSelecaoPareto());
		}
		
		if (filtroOrigem.getFiltroBIPerdasTodasDet() != null) {
			filtroBI.setFiltroBIPerdasTodasDet(new FiltroBIPerdasTodasDetDTO());
			filtroBI.getFiltroBIPerdasTodasDet().setCdProdutoSelecaoPareto(filtroOrigem.getFiltroBIPerdasTodasDet().getCdProdutoSelecaoPareto());
			filtroBI.getFiltroBIPerdasTodasDet().setCdPtSelecaoPareto(filtroOrigem.getFiltroBIPerdasTodasDet().getCdPtSelecaoPareto());
			filtroBI.getFiltroBIPerdasTodasDet().setOrdenacaoPareto(filtroOrigem.getFiltroBIPerdasTodasDet().getOrdenacaoPareto());
		}

		if (filtroOrigem.getIndicadores() != null) {
			filtroBI.setIndicadores(new BiIndicadoresDTO());
			filtroBI.getIndicadores().setEfiCic(filtroOrigem.getIndicadores().getEfiCic());
			filtroBI.getIndicadores().setEfiCicPonderada(filtroOrigem.getIndicadores().getEfiCicPonderada());
			filtroBI.getIndicadores().setEficiencia(filtroOrigem.getIndicadores().getEficiencia());
			filtroBI.getIndicadores().setEfiRea(filtroOrigem.getIndicadores().getEfiRea());
			filtroBI.getIndicadores().setEfiReaGr(filtroOrigem.getIndicadores().getEfiReaGr());
			filtroBI.getIndicadores().setEfiReaSeg(filtroOrigem.getIndicadores().getEfiReaSeg());
			filtroBI.getIndicadores().setHrsBoas(filtroOrigem.getIndicadores().getHrsBoas());
			filtroBI.getIndicadores().setHrsBoasDec(filtroOrigem.getIndicadores().getHrsBoasDec());
			filtroBI.getIndicadores().setHrsCiclosImprodutivos(filtroOrigem.getIndicadores().getHrsCiclosImprodutivos());
			filtroBI.getIndicadores().setHrsCiclosImprodutivosDec(filtroOrigem.getIndicadores().getHrsCiclosImprodutivosDec());
			filtroBI.getIndicadores().setHrsCiclosProdutivos(filtroOrigem.getIndicadores().getHrsCiclosProdutivos());
			filtroBI.getIndicadores().setHrsCiclosProdutivosDec(filtroOrigem.getIndicadores().getHrsCiclosProdutivosDec());
			filtroBI.getIndicadores().setHrsCTA(filtroOrigem.getIndicadores().getHrsCTA());
			filtroBI.getIndicadores().setHrsCTADec(filtroOrigem.getIndicadores().getHrsCTADec());
			filtroBI.getIndicadores().setHrsDisp(filtroOrigem.getIndicadores().getHrsDispDec());
			filtroBI.getIndicadores().setHrsDispDec(filtroOrigem.getIndicadores().getHrsDispDec());
			filtroBI.getIndicadores().setHrsParComPeso(filtroOrigem.getIndicadores().getHrsParSemPeso());
			filtroBI.getIndicadores().setHrsParComPesoDec(filtroOrigem.getIndicadores().getHrsParComPesoDec());
			filtroBI.getIndicadores().setHrsParSemPeso(filtroOrigem.getIndicadores().getHrsParSemPeso());
			filtroBI.getIndicadores().setHrsParSemPesoDec(filtroOrigem.getIndicadores().getHrsParSemPesoDec());
			filtroBI.getIndicadores().setHrsPCI(filtroOrigem.getIndicadores().getHrsPCI());
			filtroBI.getIndicadores().setHrsPCIDec(filtroOrigem.getIndicadores().getHrsPCIDec());
			filtroBI.getIndicadores().setHrsProdutivas(filtroOrigem.getIndicadores().getHrsProdutivas());
			filtroBI.getIndicadores().setHrsCiclosProdutivosDec(filtroOrigem.getIndicadores().getHrsCiclosProdutivosDec());
			filtroBI.getIndicadores().setHrsRefugadas(filtroOrigem.getIndicadores().getHrsRefugadas());
			filtroBI.getIndicadores().setHrsRefugadasDec(filtroOrigem.getIndicadores().getHrsRefugadasDec());
			filtroBI.getIndicadores().setHrsRitmo(filtroOrigem.getIndicadores().getHrsRitmo());
			filtroBI.getIndicadores().setHrsRitmoDec(filtroOrigem.getIndicadores().getHrsRitmoDec());
			filtroBI.getIndicadores().setHrsTotais(filtroOrigem.getIndicadores().getHrsTotais());
			filtroBI.getIndicadores().setHrsTotaisDec(filtroOrigem.getIndicadores().getHrsTotaisDec());
			filtroBI.getIndicadores().setHrsTrabalhadas(filtroOrigem.getIndicadores().getHrsTrabalhadas());
			filtroBI.getIndicadores().setHrsTrabalhadasDec(filtroOrigem.getIndicadores().getHrsTrabalhadasDec());
			filtroBI.getIndicadores().setIndOEE(filtroOrigem.getIndicadores().getIndOEE());
			filtroBI.getIndicadores().setIndOEECapital(filtroOrigem.getIndicadores().getIndOEECapital());
			filtroBI.getIndicadores().setIndPar(filtroOrigem.getIndicadores().getIndPar());
			filtroBI.getIndicadores().setIndPCA(filtroOrigem.getIndicadores().getIndPCA());
			filtroBI.getIndicadores().setIndPerdas(filtroOrigem.getIndicadores().getIndPerdas());
			filtroBI.getIndicadores().setIndPerdasGr(filtroOrigem.getIndicadores().getIndPerdasGr());
			filtroBI.getIndicadores().setIndPerdasSeg(filtroOrigem.getIndicadores().getIndPerdasSeg());
			filtroBI.getIndicadores().setIndRef(filtroOrigem.getIndicadores().getIndRef());
			filtroBI.getIndicadores().setIndRefGr(filtroOrigem.getIndicadores().getIndRefGr());
			filtroBI.getIndicadores().setIndRefSeg(filtroOrigem.getIndicadores().getIndRefSeg());
			filtroBI.getIndicadores().setIndUtilizacao(filtroOrigem.getIndicadores().getIndUtilizacao());
			filtroBI.getIndicadores().setPcsPerdasParComPeso(filtroOrigem.getIndicadores().getPcsPerdasParComPeso());
			filtroBI.getIndicadores().setPcsPerdasParComPesoKg(filtroOrigem.getIndicadores().getPcsPerdasParComPesoKg());
			filtroBI.getIndicadores().setPcsPerdasParComPesoTon(filtroOrigem.getIndicadores().getPcsPerdasParComPesoTon());
			filtroBI.getIndicadores().setPcsPerdasPCI(filtroOrigem.getIndicadores().getPcsPerdasPCI());
			filtroBI.getIndicadores().setPcsPerdasPCIKg(filtroOrigem.getIndicadores().getPcsPerdasPCIKg());
			filtroBI.getIndicadores().setPcsPerdasPCITon(filtroOrigem.getIndicadores().getPcsPerdasPCITon());
			filtroBI.getIndicadores().setPcsPerdasTotal(filtroOrigem.getIndicadores().getPcsPerdasTotal());
			filtroBI.getIndicadores().setPcsPerdasTotalKg(filtroOrigem.getIndicadores().getPcsPerdasTotalKg());
			filtroBI.getIndicadores().setPcsPerdasTotalTon(filtroOrigem.getIndicadores().getPcsPerdasTotalTon());
			filtroBI.getIndicadores().setPcsProdBruta(filtroOrigem.getIndicadores().getPcsProdBruta());
			filtroBI.getIndicadores().setPcsProdBrutaKg(filtroOrigem.getIndicadores().getPcsProdBrutaKg());
			filtroBI.getIndicadores().setPcsProdBrutaTon(filtroOrigem.getIndicadores().getPcsProdBrutaTon());
			filtroBI.getIndicadores().setPcsProdLiquida(filtroOrigem.getIndicadores().getPcsProdLiquida());
			filtroBI.getIndicadores().setPcsProdLiquidaKg(filtroOrigem.getIndicadores().getPcsProdLiquidaKg());
			filtroBI.getIndicadores().setPcsProdLiquidaTon(filtroOrigem.getIndicadores().getPcsProdLiquidaTon());
			filtroBI.getIndicadores().setPcsProdPrev(filtroOrigem.getIndicadores().getPcsProdPrev());
			filtroBI.getIndicadores().setPcsProdPrevKg(filtroOrigem.getIndicadores().getPcsProdPrevKg());
			filtroBI.getIndicadores().setPcsProdPrevTon(filtroOrigem.getIndicadores().getPcsProdPrevTon());
			filtroBI.getIndicadores().setPcsProdRefugada(filtroOrigem.getIndicadores().getPcsProdRefugada());
			filtroBI.getIndicadores().setPcsProdRefugadaKg(filtroOrigem.getIndicadores().getPcsProdRefugadaKg());
			filtroBI.getIndicadores().setPcsProdRefugadaTon(filtroOrigem.getIndicadores().getPcsProdPrevTon());
			filtroBI.getIndicadores().setPcsRitmo(filtroOrigem.getIndicadores().getPcsRitmo());
			filtroBI.getIndicadores().setPcsRitmoKg(filtroOrigem.getIndicadores().getPcsRitmoKg());
			filtroBI.getIndicadores().setPcsRitmoTon(filtroOrigem.getIndicadores().getPcsRitmoTon());			
		}
		
		
		return filtroBI;
	}
	
	
	private Indicadores cloneIndicadores(Indicadores origem) {
		Indicadores destino = new Indicadores();
		
		destino.ano = origem.ano;
		destino.mes = origem.mes;
		destino.dtTurno = origem.dtTurno;			
		destino.cdPt = origem.cdPt;
		destino.cdRap = origem.cdRap;
		destino.cdEstrutura = origem.cdEstrutura;
		destino.cdTurno = origem.cdTurno;
		destino.dsTurno = origem.dsTurno;
		
		destino.tmpProdRefugada = origem.tmpProdRefugada;			
		destino.tmpCavidades = origem.tmpCavidades;
		
		destino.tmpCicNormal = origem.tmpCicNormal;
		destino.tmpCicFinParada = origem.tmpCicFinParada;
		
		destino.tmpParadasCP = origem.tmpParadasCP;
		destino.tmpParadasSP = origem.tmpParadasSP;
		destino.tmpRitmo = origem.tmpRitmo;
		destino.tmpAtivo = origem.tmpAtivo;
		destino.tmpCTA = origem.tmpCTA;
		destino.tmpProdutivas = origem.tmpProdutivas;
		destino.tmpTotal = origem.tmpTotal;
		destino.tmpBoas = origem.tmpBoas;
		destino.tmpPerdas = origem.tmpPerdas;
		destino.tmpTrabalhadas = origem.tmpTrabalhadas;
		
		destino.prodPrev = origem.prodPrev;
		destino.qtdPerdasParCP = origem.qtdPerdasParCP;
		destino.qtdPCI = origem.qtdPCI;
		destino.prodBruta = origem.prodBruta;
		destino.prodRefugada = origem.prodRefugada;
		destino.prodLiquida = origem.prodLiquida;
		destino.qtdRitmo = origem.qtdRitmo;
		destino.qtdPerdas = origem.qtdPerdas;
	
		destino.prodPrevGr = origem.prodPrevGr;
		destino.qtdPerdasParCPGr = origem.qtdPerdasParCPGr;
		destino.qtdPCIGr = origem.qtdPCIGr;
		destino.prodBrutaGr = origem.prodBrutaGr;
		destino.prodRefugadaGr = origem.prodRefugadaGr;
		destino.prodLiquidaGr = origem.prodLiquidaGr;
		destino.qtdRitmoGr = origem.qtdRitmoGr;
		destino.qtdPerdasGr = origem.qtdPerdasGr;
		
		destino.efiRea = origem.efiRea;
		destino.efiReaP = origem.efiReaP;
		destino.efiReaT = origem.efiReaT;
		destino.indRef = origem.indRef;
		destino.indRefP = origem.indRefP;
		destino.indRefT = origem.indRefT;
		destino.indPerda = origem.indPerda;
		destino.indPerdaP = origem.indPerdaP;
		destino.indPerdaT = origem.indPerdaT;
		destino.indPar = origem.indPar;
		destino.OEE = origem.OEE;
		destino.OEECapital = origem.OEECapital;
		destino.utilizacao = origem.utilizacao;
		destino.eficiencia = origem.eficiencia;
		
		destino.efiCic = origem.efiCic;
		destino.efiCicPond = origem.efiCicPond;
		destino.indPCA = origem.indPCA;
			
		return destino;
	}
	
	public List<ResumoBI> resumoIndicadoresBI(BiFiltroDTO filtroBI, FiltroAgrupamentoBI agrupamento, List<MetaIndicadorDTO> listaMetaIndicadores) {
		Map<String, ResumoBI> mapIndicadores = new HashMap<String, ResumoBI>();
		List<ResumoBI> resumoIndicadores = new ArrayList<ResumoBI>();
		List<ResumoBI> retorno = new ArrayList<ResumoBI>();
		BiIndicadoresDTO indicadores = new BiIndicadoresDTO();
		boolean isComDados = false;
		
		mapIndicadores = resumoIndicadoresTempoBI(filtroBI, agrupamento);		
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_GERAL) {
			Indicadores indicadorSemDados = mapIndicadores.get("").indicadores;
			isComDados = (indicadorSemDados.tmpTotal != null);
		} else {
			isComDados = true;
		}
		
		if (isComDados) {
			resumoIndicadores = resumoIndicadoresQtdBI(filtroBI, agrupamento, mapIndicadores);
			mapIndicadores = null;
			
			for (ResumoBI reg : resumoIndicadores) {
				Indicadores registro = cloneIndicadores(reg.indicadores);
				
				ResumoBI resumo = new ResumoBI();			
				indicadores = new BiIndicadoresDTO();
				
				
				indicadores.setEfiCic(ConversaoTipos.converteParaString(registro.efiCic, 2));
				indicadores.setEfiCicPonderada(ConversaoTipos.converteParaString(registro.efiCicPond, 2));
				indicadores.setIndPCA(ConversaoTipos.converteParaString(registro.indPCA, 2));
	
				// indicadores exibidos em apenas uma unidade 
				indicadores.setIndOEE(ConversaoTipos.converteParaString(registro.OEE, 2));
				indicadores.setIndOEECapital(ConversaoTipos.converteParaString(registro.OEECapital, 2));
				indicadores.setEficiencia(ConversaoTipos.converteParaString(registro.eficiencia, 2));
				indicadores.setIndUtilizacao(ConversaoTipos.converteParaString(registro.utilizacao, 2));
				indicadores.setIndPar(ConversaoTipos.converteParaString(registro.indPar, 2));
	
				// indicadores exibidos em mais de uma unidade
				indicadores.setEfiRea(ConversaoTipos.converteParaString(registro.efiRea, 2));
				indicadores.setEfiReaGr(ConversaoTipos.converteParaString(registro.efiReaP, 2));
				indicadores.setEfiReaSeg(ConversaoTipos.converteParaString(registro.efiReaT, 2));
	
				indicadores.setIndRef(ConversaoTipos.converteParaString(registro.indRef, 2));
				indicadores.setIndRefGr(ConversaoTipos.converteParaString(registro.indRefP, 2));
				indicadores.setIndRefSeg(ConversaoTipos.converteParaString(registro.indRefT, 2));
				
				indicadores.setIndPerdas(ConversaoTipos.converteParaString(registro.indPerda, 2));
				indicadores.setIndPerdasGr(ConversaoTipos.converteParaString(registro.indPerdaP, 2));
				indicadores.setIndPerdasSeg(ConversaoTipos.converteParaString(registro.indPerdaT, 2));
		
				
				indicadores.setHrsBoas(DataHoraRN.formatSegundosParaHHMMSS(registro.tmpBoas));
				indicadores.setHrsBoasDec(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.tmpBoas, DIVISOR_HORAS_DECIMAL), 4));			
				indicadores.setHrsCiclosImprodutivos(DataHoraRN.formatSegundosParaHHMMSSRound(registro.tmpCicFinParada));
				indicadores.setHrsCiclosImprodutivosDec(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.tmpCicFinParada, DIVISOR_HORAS_DECIMAL), 4));			
				indicadores.setHrsCiclosProdutivos(DataHoraRN.formatSegundosParaHHMMSSRound(registro.tmpCicNormal));
				indicadores.setHrsCiclosProdutivosDec(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.tmpCicNormal, DIVISOR_HORAS_DECIMAL), 4));			
				indicadores.setHrsCTA(DataHoraRN.formatSegundosParaHHMMSS(registro.tmpCTA));
				indicadores.setHrsCTADec(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.tmpCTA, DIVISOR_HORAS_DECIMAL), 4));			
				indicadores.setHrsDisp(DataHoraRN.formatSegundosParaHHMMSSRound(registro.tmpAtivo));
				indicadores.setHrsDispDec(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.tmpAtivo, DIVISOR_HORAS_DECIMAL), 4));			
				indicadores.setHrsParComPeso(DataHoraRN.formatSegundosParaHHMMSS(registro.tmpParadasCP));
				indicadores.setHrsParComPesoDec(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.tmpParadasCP, DIVISOR_HORAS_DECIMAL), 4));			
				indicadores.setHrsParSemPeso(DataHoraRN.formatSegundosParaHHMMSS(registro.tmpParadasSP));
				indicadores.setHrsParSemPesoDec(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.tmpParadasSP, DIVISOR_HORAS_DECIMAL), 4));			
				indicadores.setHrsPCI(DataHoraRN.formatSegundosParaHHMMSSRound(registro.tmpCavidades));
				indicadores.setHrsPCIDec(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.tmpCavidades, DIVISOR_HORAS_DECIMAL), 4));			
				indicadores.setHrsBoas(DataHoraRN.formatSegundosParaHHMMSSRound(registro.tmpBoas));
				indicadores.setHrsBoasDec(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.tmpBoas, DIVISOR_HORAS_DECIMAL), 4));			
				indicadores.setHrsRefugadas(DataHoraRN.formatSegundosParaHHMMSS(registro.tmpProdRefugada));
				indicadores.setHrsRefugadasDec(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.tmpProdRefugada, DIVISOR_HORAS_DECIMAL), 4));			
				indicadores.setHrsRitmo(DataHoraRN.formatSegundosParaHHMMSSRound(registro.tmpRitmo));
				indicadores.setHrsRitmoDec(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.tmpRitmo, DIVISOR_HORAS_DECIMAL), 4));			
				indicadores.setHrsTotais(DataHoraRN.formatSegundosParaHHMMSSRound(registro.tmpTotal));
				indicadores.setHrsTotaisDec(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.tmpTotal, DIVISOR_HORAS_DECIMAL), 4));
				indicadores.setHrsProdutivas(DataHoraRN.formatSegundosParaHHMMSSRound(registro.tmpProdutivas));
				indicadores.setHrsProdutivasDec(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.tmpProdutivas, DIVISOR_HORAS_DECIMAL), 4));
				indicadores.setHrsTrabalhadas(DataHoraRN.formatSegundosParaHHMMSSRound(registro.tmpTrabalhadas));
				indicadores.setHrsTrabalhadasDec(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.tmpTrabalhadas, DIVISOR_HORAS_DECIMAL), 4));
				
	
				
				indicadores.setPcsPerdasParComPeso(ConversaoTipos.converteParaString(registro.qtdPerdasParCP, 2));
				indicadores.setPcsPerdasParComPesoKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.qtdPerdasParCPGr, DIVISOR_KG), 4));
				indicadores.setPcsPerdasParComPesoTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.qtdPerdasParCPGr, DIVISOR_TON), 4));
				
				indicadores.setPcsPerdasPCI(ConversaoTipos.converteParaString(registro.qtdPCI, 2));
				indicadores.setPcsPerdasPCIKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.qtdPCIGr, DIVISOR_KG), 4));
				indicadores.setPcsPerdasPCITon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.qtdPCIGr, DIVISOR_TON), 4));
				
				indicadores.setPcsPerdasTotal(ConversaoTipos.converteParaString(registro.qtdPerdas, 2));
				indicadores.setPcsPerdasTotalKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.qtdPerdasGr, DIVISOR_KG), 4));
				indicadores.setPcsPerdasTotalTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.qtdPerdasGr, DIVISOR_TON), 4));
				
				indicadores.setPcsProdBruta(ConversaoTipos.converteParaString(registro.prodBruta, 2));
				indicadores.setPcsProdBrutaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.prodBrutaGr, DIVISOR_KG), 4));
				indicadores.setPcsProdBrutaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.prodBrutaGr, DIVISOR_TON), 4));
				
				indicadores.setPcsProdLiquida(ConversaoTipos.converteParaString(registro.prodLiquida, 2));
				indicadores.setPcsProdLiquidaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.prodLiquidaGr, DIVISOR_KG), 4));
				indicadores.setPcsProdLiquidaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.prodLiquidaGr, DIVISOR_TON), 4));
				
				indicadores.setPcsProdPrev(ConversaoTipos.converteParaString(registro.prodPrev, 2));
				indicadores.setPcsProdPrevKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.prodPrevGr, DIVISOR_KG), 4));
				indicadores.setPcsProdPrevTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.prodPrevGr, DIVISOR_TON), 4));
				
				indicadores.setPcsProdRefugada(ConversaoTipos.converteParaString(registro.prodRefugada, 2));
				indicadores.setPcsProdRefugadaKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.prodRefugadaGr, DIVISOR_KG), 4));
				indicadores.setPcsProdRefugadaTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.prodRefugadaGr, DIVISOR_TON), 4));
				
				indicadores.setPcsRitmo(ConversaoTipos.converteParaString(registro.qtdRitmo, 2));
				indicadores.setPcsRitmoKg(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.qtdRitmoGr, DIVISOR_KG), 4));
				indicadores.setPcsRitmoTon(ConversaoTipos.converteParaString(AritmeticaUtil.dividir(registro.qtdRitmoGr, DIVISOR_TON), 4));
				
				resumo.indicadoresGrafico = new GraficoIndicadorDTO();
				resumo.graficoPerdasPizza = new ArrayList<GraficoPizzaDTO>();
				resumo.indicadoresPerdaGrafico = new GraficoIndicadorPerdaDTO();
				resumo.resumoBIPorTurno = new ArrayList<ResumoBI>();
				resumo.temposDiagrama = new PtTemposDTO();
				
				resumo.ano = reg.ano;
				resumo.mes = reg.mes;
				resumo.dtTurno = reg.dtTurno;
				resumo.cdTurno = reg.cdTurno;
				resumo.dsTurno = reg.dsTurno;	
				resumo.cdPt = reg.cdPt;
				resumo.cdRap = reg.cdRap;
				resumo.cdEstrutura = reg.cdEstrutura;
				resumo.indicadores = registro;
				resumo.indicadoresBI = indicadores;
	
				
				if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_ANO_MES) {
					GraficoIndicadorDTO grafico = getGraficoIndicadores(indicadores, listaMetaIndicadores, reg.mes + "/" + reg.ano);
					resumo.indicadoresGrafico = grafico;
					
					GraficoIndicadorPerdaDTO graficoPerda = getIndicadoresPerda(resumo, agrupamento);
					resumo.indicadoresPerdaGrafico = graficoPerda;
				}
				if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA) {
					GraficoIndicadorDTO grafico = getGraficoIndicadores(indicadores, listaMetaIndicadores, DataHoraRN.dateToStringDDMMYYYY(reg.dtTurno));
					resumo.indicadoresGrafico = grafico;
					
					GraficoIndicadorPerdaDTO graficoPerda = getIndicadoresPerda(resumo, agrupamento);
					resumo.indicadoresPerdaGrafico = graficoPerda;				
				}
				if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA) {
					GraficoIndicadorDTO grafico = getGraficoIndicadores(indicadores, listaMetaIndicadores, reg.cdPt);
					resumo.indicadoresGrafico = grafico;
				}
				if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_FERRAMENTA_ESTRUTURA) {
					GraficoIndicadorDTO grafico = new GraficoIndicadorDTO();
					resumo.indicadoresGrafico = grafico;
				}				
				if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_TURNO) {	
					if (! filtroBI.getAnoFim().equals(""))
					{
						resumo.resumoBIPorTurno = resumoIndicadoresBI(filtroBI, FiltroAgrupamentoBI.BI_TOTAL_ANO_MES, listaMetaIndicadores);
					} else {
						resumo.resumoBIPorTurno = resumoIndicadoresBI(filtroBI, FiltroAgrupamentoBI.BI_TOTAL_DATA, listaMetaIndicadores);	
					}									
				}
				
				
				resumo.temposDiagrama = getTempos(indicadores);
				resumo.graficoPerdasPizza = getGraficoPerdasProducao(indicadores);
				
				retorno.add(resumo);
			}
		}
		
		return retorno;
	}
	
	
	private GraficoIndicadorPerdaDTO getIndicadoresPerda(ResumoBI resumo, FiltroAgrupamentoBI agrupamento) {
		GraficoIndicadorPerdaDTO retorno = new GraficoIndicadorPerdaDTO();
		String id = "";
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA) {
			id = DataHoraRN.dateToStringDDMMYYYY(resumo.dtTurno);
		} else {
			id = resumo.mes + "/" + resumo.ano;
		}
		
		retorno.setIdBarra(id);
		retorno.setPerdaCiclos(ConversaoTipos.converteParaString(resumo.indicadores.qtdRitmo, 2));
		retorno.setPerdaParadas(ConversaoTipos.converteParaString(resumo.indicadores.qtdPerdasParCP, 2));
		retorno.setPerdaRefugos(ConversaoTipos.converteParaString(resumo.indicadores.prodRefugada, 2));
		retorno.setPerdaPCI(ConversaoTipos.converteParaString(resumo.indicadores.qtdPCI, 2));
		retorno.setPerdaTodas(ConversaoTipos.converteParaString(resumo.indicadores.qtdPerdas, 2));
		
		retorno.setPerdaCiclosCor(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebInjetRN.COR_TEMPO_RITMO));
		retorno.setPerdaParadasCor(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebInjetRN.COR_TEMPO_PARADAS));
		retorno.setPerdaRefugosCor(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebInjetRN.COR_TEMPO_REFUGOS));
		retorno.setPerdaPCICor(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebInjetRN.COR_TEMPO_BLANK_INATIVO));
		retorno.setPerdaTodasCor(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebInjetRN.COR_TEMPO_TRABALHADO));
		
		return retorno;
	}
	
	
	private PtTemposDTO getTempos(BiIndicadoresDTO dto) {
		BigDecimal tempoRitmo = BigDecimal.ZERO;
		BigDecimal tempoPCI = BigDecimal.ZERO;
		BigDecimal tempoRefugo = BigDecimal.ZERO;
		BigDecimal tempoCicImprod = BigDecimal.ZERO;
		BigDecimal tempoParCP = BigDecimal.ZERO;
		BigDecimal tempoParSP = BigDecimal.ZERO;
		BigDecimal tempoProdutiva = BigDecimal.ZERO;
		BigDecimal tempoTotal = BigDecimal.ZERO;
		
		
		PtTemposDTO temposDTO = new PtTemposDTO();

		temposDTO.setTempoCalendario(dto.getHrsTotais());
		temposDTO.setTempoColeta(dto.getHrsTotais());
		temposDTO.setTempoSemColeta(DataHoraRN.formatSegundosParaHHMMSS(0));
		temposDTO.setTempoDisponivel(dto.getHrsDisp());
		temposDTO.setTempoTrabalhado(dto.getHrsTrabalhadas());
		temposDTO.setCiclosProdutivos(dto.getHrsCiclosProdutivos());
		temposDTO.setTempoProduzidoLiquido(dto.getHrsBoas());
		temposDTO.setTempoProdutivo(dto.getHrsProdutivas());
		temposDTO.setTempoDuplicadoColeta(DataHoraRN.formatSegundosParaHHMMSS(0));
		temposDTO.setTempoParadas(dto.getHrsParComPeso());
		temposDTO.setTempoNaoDisponivel(dto.getHrsParSemPeso());
		temposDTO.setCiclosImprodutivo(dto.getHrsCiclosImprodutivos());
		temposDTO.setTempoProducaoRefugada(dto.getHrsRefugadas());
		temposDTO.setRitmo(dto.getHrsRitmo());
		temposDTO.setBlankInativo(dto.getHrsPCI());

		temposDTO.setTempoCalendarioDec(dto.getHrsTotaisDec());
		temposDTO.setTempoColetaDec(dto.getHrsTotaisDec());
		temposDTO.setTempoSemColetaDec(DataHoraRN.formatSegundosParaHHMMSS(0));
		temposDTO.setTempoDisponivelDec(dto.getHrsDispDec());
		temposDTO.setTempoTrabalhadoDec(dto.getHrsTrabalhadasDec());
		temposDTO.setCiclosProdutivosDec(dto.getHrsCiclosProdutivosDec());
		temposDTO.setTempoProduzidoLiquidoDec(dto.getHrsBoasDec());
		temposDTO.setTempoProdutivoDec(dto.getHrsProdutivasDec());
		temposDTO.setTempoDuplicadoColetaDec(DataHoraRN.formatSegundosParaHHMMSS(0));
		temposDTO.setTempoParadasDec(dto.getHrsParComPesoDec());
		temposDTO.setTempoNaoDisponivelDec(dto.getHrsParSemPesoDec());
		temposDTO.setCiclosImprodutivoDec(dto.getHrsCiclosImprodutivosDec());
		temposDTO.setTempoProducaoRefugadaDec(dto.getHrsRefugadasDec());
		temposDTO.setRitmoDec(dto.getHrsRitmoDec());
		temposDTO.setBlankInativoDec(dto.getHrsPCIDec());

		
		
		
		if (ConversaoTipos.converteParaDouble(dto.getPcsPerdasParComPeso()) > 0 ||  
			ConversaoTipos.converteParaDouble(dto.getPcsProdRefugada()) > 0 ||
			ConversaoTipos.converteParaDouble(dto.getPcsPerdasPCI()) > 0 ||
			ConversaoTipos.converteParaDouble(dto.getPcsRitmo()) > 0) {

			
			temposDTO.setRitmoSegundos(ConversaoTipos.converteParaString(0d, 3));
			temposDTO.setBlankInativoSegundos(ConversaoTipos.converteParaString(0d, 3));
			temposDTO.setTempoProducaoRefugadaSegundos(ConversaoTipos.converteParaString(0d, 3));
			temposDTO.setCiclosImprodutivoSegundos(ConversaoTipos.converteParaString(0d, 3));
			temposDTO.setTempoParadasSegundos(ConversaoTipos.converteParaString(0d, 3));
			temposDTO.setTempoNaoDisponivelSegundos(ConversaoTipos.converteParaString(0d, 3));
			temposDTO.setTempoProdutivoSegundos(ConversaoTipos.converteParaString(0d, 3));

			
			if (ConversaoTipos.converteParaDouble(dto.getPcsPerdasParComPeso()) > 0) {
				temposDTO.setTempoParadasSegundos(ConversaoTipos.converteParaString(ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsParComPeso()), 3));
				tempoParCP = ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsParComPeso());
			}

			if (ConversaoTipos.converteParaDouble(dto.getPcsProdRefugada()) > 0) {					
				temposDTO.setTempoProducaoRefugadaSegundos(ConversaoTipos.converteParaString(ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsRefugadas()), 3));
				tempoRefugo = ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsRefugadas());
			}

			if (ConversaoTipos.converteParaDouble(dto.getPcsPerdasPCI()) > 0) {
				temposDTO.setBlankInativoSegundos(ConversaoTipos.converteParaString(ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsPCI()), 3));
				tempoPCI = ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsPCI());
			}
			
			if (ConversaoTipos.converteParaDouble(dto.getPcsRitmo()) > 0) {
				temposDTO.setRitmoSegundos(ConversaoTipos.converteParaString(ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsRitmo()), 3));
				tempoRitmo = ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsRitmo());
			}

			temposDTO.setTempoProdutivoSegundos(ConversaoTipos.converteParaString(ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsProdutivas()), 3));
			tempoProdutiva = ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsProdutivas());
			
		}
		temposDTO.setTempoNaoDisponivelSegundos(ConversaoTipos.converteParaString(ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsParSemPeso()), 3));
		tempoParSP = ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsParSemPeso());
		
		temposDTO.setCiclosImprodutivoSegundos(ConversaoTipos.converteParaString(ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsCiclosImprodutivos()), 3));
		tempoCicImprod = ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsCiclosImprodutivos());

		temposDTO.setTempoColetaCor(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebInjetRN.COR_TEMPO_COLETA));
		temposDTO.setTempoDisponivelCor(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebInjetRN.COR_TEMPO_DISPONIVEL));
		temposDTO.setTempoTrabalhadoCor(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebInjetRN.COR_TEMPO_TRABALHADO));
		temposDTO.setCiclosProdutivosCor(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebInjetRN.COR_TEMPO_CICLOS_PRODUTIVOS));
		temposDTO.setTempoProduzidoLiquidoCor(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebInjetRN.COR_TEMPO_PRODUCAO_LIQUIDA));
		temposDTO.setTempoProdutivoCor(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebInjetRN.COR_TEMPO_PRODUTIVAS));

		temposDTO.setRitmoCor(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebInjetRN.COR_TEMPO_RITMO));
		temposDTO.setBlankInativoCor(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebInjetRN.COR_TEMPO_BLANK_INATIVO));
		temposDTO.setTempoProducaoRefugadaCor(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebInjetRN.COR_TEMPO_REFUGOS));
		temposDTO.setCiclosImprodutivoCor(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebInjetRN.COR_TEMPO_CICLOS_IMPRODUTIVOS));
		temposDTO.setTempoParadasCor(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebInjetRN.COR_TEMPO_PARADAS));
		temposDTO.setTempoNaoDisponivelCor(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebInjetRN.COR_TEMPO_NAO_DISPONIVEL));
		temposDTO.setTempoProdutivoGraficoCor(Cor.transformarParaCodigoHexadecimal(DetalheMonitorizacaoWebInjetRN.COR_TEMPO_PRODUTIVAS_GRAFICO));
		

		// indices utilizados no tooltip do digrama de produtividade em pizza
		tempoTotal = AritmeticaUtil.somar(tempoTotal, tempoRitmo);
		tempoTotal = AritmeticaUtil.somar(tempoTotal, tempoPCI);
		tempoTotal = AritmeticaUtil.somar(tempoTotal, tempoRefugo);
		tempoTotal = AritmeticaUtil.somar(tempoTotal, tempoCicImprod);
		tempoTotal = AritmeticaUtil.somar(tempoTotal, tempoParCP);
		tempoTotal = AritmeticaUtil.somar(tempoTotal, tempoParSP);
		tempoTotal = AritmeticaUtil.somar(tempoTotal, tempoProdutiva);
		
		BigDecimal indicePizzaRitmo = FormulasInjet.calcularIndiceDisponibilidade(tempoRitmo, tempoTotal);
		BigDecimal indicePizzaPCI = FormulasInjet.calcularIndiceDisponibilidade(tempoPCI, tempoTotal);
		BigDecimal indicePizzaRefugo = FormulasInjet.calcularIndiceDisponibilidade(tempoRefugo, tempoTotal);
		BigDecimal indicePizzaCicImprodutivo = FormulasInjet.calcularIndiceDisponibilidade(tempoCicImprod, tempoTotal);
		BigDecimal indicePizzaParCP = FormulasInjet.calcularIndiceDisponibilidade(tempoParCP, tempoTotal);
		BigDecimal indicePizzaParSP = FormulasInjet.calcularIndiceDisponibilidade(tempoParSP, tempoTotal);
		BigDecimal indicePizzaProdutiva = FormulasInjet.calcularIndiceDisponibilidade(tempoProdutiva, tempoTotal);
		
		temposDTO.setIndicePizzaRitmo(ConversaoTipos.converteParaString(indicePizzaRitmo, 2));
		temposDTO.setIndicePizzaPCI(ConversaoTipos.converteParaString(indicePizzaPCI, 2));
		temposDTO.setIndicePizzaRefugo(ConversaoTipos.converteParaString(indicePizzaRefugo, 2));
		temposDTO.setIndicePizzaCicImprodutivo(ConversaoTipos.converteParaString(indicePizzaCicImprodutivo, 2));
		temposDTO.setIndicePizzaParCP(ConversaoTipos.converteParaString(indicePizzaParCP, 2));
		temposDTO.setIndicePizzaParSP(ConversaoTipos.converteParaString(indicePizzaParSP, 2));
		temposDTO.setIndicePizzaProdutiva(ConversaoTipos.converteParaString(indicePizzaProdutiva, 2));
		
		
		
		// indices utiizados em tooltips do diagrama de produtividade
		BigDecimal indA = new BigDecimal(100);
		
		BigDecimal indB = BigDecimal.ZERO;
		BigDecimal indiceNaoDisp = BigDecimal.ZERO;
				
		BigDecimal indC = BigDecimal.ZERO;
		BigDecimal indiceParadas = BigDecimal.ZERO;
		
		BigDecimal indD = BigDecimal.ZERO;
		BigDecimal indiceCicImprodutivos = BigDecimal.ZERO;
		
		BigDecimal indE = BigDecimal.ZERO;
		BigDecimal indiceRefugos = BigDecimal.ZERO;

		BigDecimal indF = BigDecimal.ZERO;
		BigDecimal indiceRitmo = BigDecimal.ZERO;
		BigDecimal indicePCI = BigDecimal.ZERO;
		
		
		indB =  FormulasInjet.calcularIndiceDisponibilidade(ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsDisp()), ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsTotais()));
		indiceNaoDisp = FormulasInjet.calcularIndiceDisponibilidade(ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsParSemPeso()), ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsTotais()));
		
		indC =  FormulasInjet.calcularIndiceDisponibilidade(ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsTrabalhadas()), ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsDisp()));
		indiceParadas = FormulasInjet.calcularIndiceDisponibilidade(ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsParComPeso()), ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsDisp()));
		
		indD =  FormulasInjet.calcularIndiceDisponibilidade(ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsCiclosProdutivos()), ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsTrabalhadas()));
		indiceCicImprodutivos = FormulasInjet.calcularIndiceDisponibilidade(ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsCiclosImprodutivos()), ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsTrabalhadas()));

		indE =  FormulasInjet.calcularIndiceDisponibilidade(ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsBoas()), ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsCiclosProdutivos()));
		indiceRefugos = FormulasInjet.calcularIndiceDisponibilidade(ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsRefugadas()), ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsCiclosProdutivos()));

		indF =  FormulasInjet.calcularIndiceDisponibilidade(ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsProdutivas()), ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsBoas()));
		indiceRitmo = FormulasInjet.calcularIndiceDisponibilidade(ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsRitmo()), ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsBoas()));
		indicePCI = FormulasInjet.calcularIndiceDisponibilidade(ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsPCI()), ConversaoTipos.converteHoraParaBigDecimal(dto.getHrsBoas()));

		
		temposDTO.setIndiceA(ConversaoTipos.converteParaString(indA, 2));
		temposDTO.setIndiceB(ConversaoTipos.converteParaString(indB, 2));
		temposDTO.setIndiceC(ConversaoTipos.converteParaString(indC, 2));
		temposDTO.setIndiceD(ConversaoTipos.converteParaString(indD, 2));
		temposDTO.setIndiceE(ConversaoTipos.converteParaString(indE, 2));
		temposDTO.setIndiceF(ConversaoTipos.converteParaString(indF, 2));
		temposDTO.setIndiceNaoDisp(ConversaoTipos.converteParaString(indiceNaoDisp, 2));
		temposDTO.setIndiceParadas(ConversaoTipos.converteParaString(indiceParadas, 2));
		temposDTO.setIndiceRefugos(ConversaoTipos.converteParaString(indiceRefugos, 2));
		temposDTO.setIndiceRitmo(ConversaoTipos.converteParaString(indiceRitmo, 2));
		temposDTO.setIndicePCI(ConversaoTipos.converteParaString(indicePCI, 2));
		temposDTO.setIndiceCicImprodutivos(ConversaoTipos.converteParaString(indiceCicImprodutivos, 2));

		
		return temposDTO;
	}


	private GraficoIndicadorDTO getGraficoIndicadores(BiIndicadoresDTO dto, List<MetaIndicadorDTO> listaMetaIndicadores, String idBarra) {
		PtIndicadorDTO indicadoresDTO = new PtIndicadorDTO();

		indicadoresDTO.setEficienciaRealizacao(dto.getEfiRea());
		indicadoresDTO.setEficienciaCiclo(dto.getEfiCic());
		indicadoresDTO.setIndiceParada(dto.getIndPar());
		indicadoresDTO.setIndiceRefugo(dto.getIndRef());
		indicadoresDTO.setIndicePerdaOuNR(dto.getIndPerdas());
		indicadoresDTO.setIndiceCavidadesAtivas(dto.getIndPCA());
		indicadoresDTO.setIndiceProdutividadeOEE(dto.getIndOEE());

		indicadoresDTO.setIndiceProdutividadeOEECapital("");
		indicadoresDTO.setEficienciaCiclosPond("");

		indicadorRN.preencherCamposDeCores(indicadoresDTO, listaMetaIndicadores);

		GraficoIndicadorDTO graficoIndicadorDTO = new GraficoIndicadorDTO();
		graficoIndicadorDTO.setData(idBarra);
		graficoIndicadorDTO.setIndicadores(indicadoresDTO);

		return graficoIndicadorDTO;
	}

	
	@SuppressWarnings("unchecked")
	public Map<String, ResumoBI> resumoIndicadoresTempoBI(BiFiltroDTO filtroBI, FiltroAgrupamentoBI agrupamento) {
		Map<String, ResumoBI> retorno = new HashMap<String, BiWebInjetRN.ResumoBI>();
		String keyMap = "";

		int _dtturno = 0;
		
		int _cdPt = 0;

		int _cdRap = 1;
		int _cdEstrutura = 2;
		
		int _anomes = 0;
		
		int _cdturno = 0;
		int _dsturno = 1;
				
		int _tmpcicnormal = 0;
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_GERAL) {
			_tmpcicnormal = 0;
		}
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_ANO_MES || 
		    agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA || 
		    agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA) {
			_tmpcicnormal = 1;
		} 		
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_TURNO) {
			_tmpcicnormal = 2;
		} 

		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_FERRAMENTA_ESTRUTURA) {
			_tmpcicnormal = 3;
		}
	
		int _tmpcicfinparada = _tmpcicnormal + 1;
		int _tmpparadasCP = _tmpcicfinparada + 1;
		int _tmpparadasSP = _tmpparadasCP + 1;
		int _tmpritmo = _tmpparadasSP + 1;
		int _tmpativo = _tmpritmo + 1;
		int _tmpCTT = _tmpativo + 1;
		int _tmpCTA = _tmpCTT + 1;
		int _tmpTotal = _tmpCTA + 1;
		int _indpar = _tmpTotal + 1;
		int _utilizacao = _indpar + 1;
		
		List<Object> lista = new ArrayList<Object>();
		String strSQL = getConsultaIndicadoresTempoBI(filtroBI, agrupamento);
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosBINaQuery(q, filtroBI, agrupamento);
		
		lista = q.list();		
		for (Object reg : lista) {
			BiFiltroDTO filtroBIEfiCicPCI = cloneBiFiltroDTO(filtroBI);
			
			Indicadores registro = new Indicadores();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			ResumoBI resumo = new ResumoBI();
			
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_GERAL) {
				keyMap = "";
			}
			
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_ANO_MES) {
				registro.ano = ((String) registroLido[_anomes]).substring(0, 4);
				registro.mes = ((String) registroLido[_anomes]).substring(4, 6);
				
				resumo.ano = registro.ano;
				resumo.mes = registro.mes;
				
				keyMap = (String) registroLido[_anomes];
				
				filtroBIEfiCicPCI.setAnoIni(registro.ano);
				filtroBIEfiCicPCI.setMesIni(registro.mes);
				filtroBIEfiCicPCI.setAnoFim(registro.ano);
				filtroBIEfiCicPCI.setMesFim(registro.mes);
			}

			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA) {
				registro.dtTurno = (Date) registroLido[_dtturno];
				
				resumo.dtTurno = registro.dtTurno;
				
				keyMap = DataHoraRN.toStringYYYYMMDD(resumo.dtTurno);		
				
				filtroBIEfiCicPCI.setDtIni(DataHoraRN.dateToStringYYYYMMDDHHMMSS(registro.dtTurno));
				filtroBIEfiCicPCI.setDtFim(DataHoraRN.dateToStringYYYYMMDDHHMMSS(registro.dtTurno));
			}

			
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA) {
				registro.cdPt = (String) registroLido[_cdPt];
				
				resumo.cdPt = registro.cdPt;
				
				keyMap = resumo.cdPt;
				
				filtroBIEfiCicPCI.setCdPt(registro.cdPt);
			}

			
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_FERRAMENTA_ESTRUTURA) {
				registro.cdPt = (String) registroLido[_cdPt];
				registro.cdRap = (String) registroLido[_cdRap];
				registro.cdEstrutura = (String) registroLido[_cdEstrutura];
				
				resumo.cdPt = registro.cdPt;
				resumo.cdRap = registro.cdRap;
				resumo.cdEstrutura = registro.cdEstrutura;
				
				keyMap = resumo.cdPt + resumo.cdRap + resumo.cdEstrutura;
				
				filtroBIEfiCicPCI.setCdPt(registro.cdPt);
				filtroBIEfiCicPCI.setCdRap(registro.cdRap);
				filtroBIEfiCicPCI.setCdEstrutura(registro.cdEstrutura);
			}

			
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_TURNO) {
				registro.cdTurno = (String) registroLido[_cdturno];
				registro.dsTurno = (String) registroLido[_dsturno];
				
				resumo.cdTurno = registro.cdTurno;
				resumo.dsTurno = registro.dsTurno;
				
				keyMap = resumo.cdTurno;
				
				filtroBIEfiCicPCI.setCdTurno(registro.cdTurno);
			} 			
			
			registro.tmpCicNormal = ConversaoTipos.converterParaBigDecimal(registroLido[_tmpcicnormal]);
			registro.tmpCicFinParada = ConversaoTipos.converterParaBigDecimal(registroLido[_tmpcicfinparada]);
			registro.tmpParadasCP = ConversaoTipos.converterParaBigDecimal(registroLido[_tmpparadasCP]);
			registro.tmpParadasSP = ConversaoTipos.converterParaBigDecimal(registroLido[_tmpparadasSP]);
			registro.tmpRitmo = ConversaoTipos.converterParaBigDecimal(registroLido[_tmpritmo]);
			registro.tmpAtivo = ConversaoTipos.converterParaBigDecimal(registroLido[_tmpativo]);
			registro.tmpCTA = ConversaoTipos.converterParaBigDecimal(registroLido[_tmpCTA]);
			registro.tmpTotal = ConversaoTipos.converterParaBigDecimal(registroLido[_tmpTotal]);
					
			registro.indPar = ConversaoTipos.converterParaBigDecimal(registroLido[_indpar]);
			registro.utilizacao = ConversaoTipos.converterParaBigDecimal(registroLido[_utilizacao]);
			
			
			// efi ciclo
			BigDecimal efiCic = resumoEfiCicBI(filtroBIEfiCicPCI, agrupamento);
			BigDecimal efiCicPond = resumoEfiCicPondBI(filtroBIEfiCicPCI, agrupamento);						

			
			registro.efiCic = efiCic;
			if (efiCicPond.intValue() == -1) {
				efiCicPond = efiCic;
			}
			registro.efiCicPond = efiCicPond;
			
			filtroBIEfiCicPCI.setCdEstrutura("");
			BigDecimal indPCA = resumoIndPCABI(filtroBIEfiCicPCI, agrupamento);

			registro.indPCA = indPCA;

			
			registro.utilizacao = registro.utilizacao;
			
			resumo.indicadores = registro;
			retorno.put(keyMap, resumo);
		}
		
		
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public List<ResumoBI> resumoIndicadoresQtdBI(BiFiltroDTO filtroBI, FiltroAgrupamentoBI agrupamento, Map<String, ResumoBI> mapResumoBI) {
		List<ResumoBI> retorno = new ArrayList<ResumoBI>();
		String keyMap = "";
		
		int _dtturno = 0;
		
		int _cdPt = 0;
		
		int _cdRap = 1;
		int _cdEstrutura = 2;

		int _anomes = 0;
		
		int _cdturno = 0;
		int _dsturno = 1;
					
		int _tmpprodrefugada = 0;
		
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_GERAL) {
			_tmpprodrefugada = 0;
		}
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_ANO_MES || 
			agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA || 
			agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA) {
			_tmpprodrefugada = 1;
		} 		
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_TURNO) {
			_tmpprodrefugada = 2;
		} 

		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_FERRAMENTA_ESTRUTURA) {
			_tmpprodrefugada = 3;
		} 

		
		int _tmpcavidades = _tmpprodrefugada + 1;
		
		int _prodprev = _tmpcavidades + 1;
		int _qtdperdasparCP = _prodprev + 1;
		int _qtdPCI = _qtdperdasparCP + 1;
		int _prodbruta = _qtdPCI + 1;		
		int _prodrefugada = _prodbruta + 1;		
		int _prodliquida = _prodrefugada + 1;
		int _qtdritmo = _prodliquida + 1;
		int _qtdperdas = _qtdritmo + 1;
	
		int _prodprevGr = _qtdperdas + 1;
		int _qtdperdasparCPGr = _prodprevGr + 1;
		int _qtdPCIGr = _qtdperdasparCPGr + 1;
		int _prodbrutaGr = _qtdPCIGr + 1;
		int _prodrefugadaGr = _prodbrutaGr + 1;
		int _prodliquidaGr = _prodrefugadaGr + 1;
		int _qtdritmoGr = _prodliquidaGr + 1;
		int _qtdperdasGr = _qtdritmoGr + 1;
		
		int _efirea = _qtdperdasGr + 1;
		int _efireaP = _efirea + 1;
		int _indref = _efireaP + 1;
		int _indrefP = _indref + 1;
		int _indperda = _indrefP + 1;
		int _indperdaP = _indperda + 1;

		
		List<Object> lista = new ArrayList<Object>();
		String strSQL = getConsultaIndicadoresQtdBI(filtroBI, agrupamento);
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosBINaQuery(q, filtroBI, agrupamento);
		
		lista = q.list();		
		for (Object reg : lista) {
			Indicadores registro = new Indicadores();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			ResumoBI resumo = new ResumoBI();
			
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_GERAL) {
				keyMap = "";
			}
			
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_ANO_MES) {
				registro.ano = ((String) registroLido[_anomes]).substring(0, 4);
				registro.mes = ((String) registroLido[_anomes]).substring(4, 6);
				
				resumo.ano = registro.ano;
				resumo.mes = registro.mes;
				
				keyMap = (String) registroLido[_anomes];
			}
			
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA) {
				registro.dtTurno = (Date) registroLido[_dtturno];
				
				resumo.dtTurno = registro.dtTurno;
				
				keyMap = DataHoraRN.toStringYYYYMMDD(resumo.dtTurno);				
			}

			
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA) {
				registro.cdPt = (String) registroLido[_cdPt];
				
				resumo.cdPt = registro.cdPt;
				
				keyMap = resumo.cdPt;
			}

			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_FERRAMENTA_ESTRUTURA) {
				registro.cdPt = (String) registroLido[_cdPt];
				registro.cdRap = (String) registroLido[_cdRap];
				registro.cdEstrutura = (String) registroLido[_cdEstrutura];
				
				resumo.cdPt = registro.cdPt;
				resumo.cdRap = registro.cdRap;
				resumo.cdEstrutura = registro.cdEstrutura;
				
				keyMap = resumo.cdPt + resumo.cdRap + resumo.cdEstrutura;
			}

			
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_TURNO) {
				registro.cdTurno = (String) registroLido[_cdturno];
				registro.dsTurno = (String) registroLido[_dsturno];
				
				resumo.cdTurno = registro.cdTurno;
				resumo.dsTurno = registro.dsTurno;
				
				keyMap = resumo.cdTurno;
			} 			
			
			registro = mapResumoBI.get(keyMap).indicadores;
						
			registro.tmpProdRefugada = ConversaoTipos.converterParaBigDecimal(registroLido[_tmpprodrefugada]);			
			registro.tmpCavidades = ConversaoTipos.converterParaBigDecimal(registroLido[_tmpcavidades]);
					
			registro.prodPrev = ConversaoTipos.converterParaBigDecimal(registroLido[_prodprev]);
			registro.qtdPerdasParCP = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdperdasparCP]);
			registro.qtdPCI = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdPCI]);
			registro.prodBruta = ConversaoTipos.converterParaBigDecimal(registroLido[_prodbruta]);
			registro.prodRefugada = ConversaoTipos.converterParaBigDecimal(registroLido[_prodrefugada]);
			registro.prodLiquida = ConversaoTipos.converterParaBigDecimal(registroLido[_prodliquida]);
			registro.qtdRitmo = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdritmo]);
			registro.qtdPerdas = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdperdas]);
					
			registro.prodPrevGr = ConversaoTipos.converterParaBigDecimal(registroLido[_prodprevGr]);
			registro.qtdPerdasParCPGr = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdperdasparCPGr]);
			registro.qtdPCIGr = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdPCIGr]);
			registro.prodBrutaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_prodbrutaGr]);
			registro.prodRefugadaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_prodrefugadaGr]);
			registro.prodLiquidaGr = ConversaoTipos.converterParaBigDecimal(registroLido[_prodliquidaGr]);
			registro.qtdRitmoGr = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdritmoGr]);
			registro.qtdPerdasGr = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdperdasGr]);
						
			registro.efiRea = ConversaoTipos.converterParaBigDecimal(registroLido[_efirea]);
			registro.efiReaP = ConversaoTipos.converterParaBigDecimal(registroLido[_efireaP]);
			
			registro.indRef = ConversaoTipos.converterParaBigDecimal(registroLido[_indref]);			
			registro.indRefP = ConversaoTipos.converterParaBigDecimal(registroLido[_indrefP]);
			
			registro.indPerda = ConversaoTipos.converterParaBigDecimal(registroLido[_indperda]);
			registro.indPerdaP = ConversaoTipos.converterParaBigDecimal(registroLido[_indperdaP]);
			
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_GERAL || agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_FERRAMENTA_ESTRUTURA) {
				if (registro.indPerda.doubleValue() < 0d) {
					registro.indPerda = BigDecimal.ZERO;
					registro.indPerdaP = BigDecimal.ZERO;				
				}
			}
			
			//outros indicadores
			registro.tmpPerdas = new BigDecimal(FormulasInjet.calcularTotalPerdas(registro.tmpRitmo.doubleValue(), registro.tmpParadasCP.doubleValue(), registro.tmpProdRefugada.doubleValue(), registro.tmpCavidades.doubleValue()));
			registro.tmpTrabalhadas = FormulasInjet.calcularTempoTrabalhado(registro.tmpAtivo, registro.tmpParadasCP);
			registro.tmpProdutivas = FormulasInjet.calcularTempoProdutivas(registro.tmpCicNormal, registro.tmpProdRefugada, registro.tmpCavidades, registro.tmpRitmo);
			registro.tmpBoas = FormulasInjet.calcularTempoBoas(registro.tmpCicNormal, registro.tmpProdRefugada, BigDecimal.ZERO, BigDecimal.ZERO);
			registro.efiReaT = new BigDecimal(FormulasInjet.calcularEficienciaRealizacao(registro.tmpBoas, registro.tmpAtivo));
			registro.indRefT = new BigDecimal(FormulasInjet.calcularIndiceRefugo(registro.tmpProdRefugada, registro.tmpCicNormal));
			registro.indPerdaT = new BigDecimal(FormulasInjet.calcularIndicePerda(registro.tmpPerdas, registro.tmpAtivo));
			registro.OEE = new BigDecimal(FormulasInjet.calcularOEE(registro.tmpProdutivas, registro.tmpAtivo));
			registro.OEECapital = new BigDecimal(FormulasInjet.calcularOEECapital(registro.tmpProdutivas, registro.tmpTotal));
			registro.utilizacao = new BigDecimal(FormulasInjet.calcularUtilizacao(registro.tmpTrabalhadas, registro.tmpAtivo));
			registro.eficiencia = new BigDecimal(FormulasInjet.calcularEficiencia(registro.tmpProdutivas, registro.tmpTrabalhadas)); 
			
			resumo.indicadores = registro;
			mapResumoBI.put(keyMap, resumo);
			
		}
		
		retorno.addAll(mapResumoBI.values());
		
		return retorno;
	}

	@SuppressWarnings("unchecked")
	public BigDecimal resumoEfiCicPondBI(BiFiltroDTO filtroBI, FiltroAgrupamentoBI agrupamento) {
		BigDecimal efiCiclo = BigDecimal.ZERO;


		List<Object> lista = new ArrayList<Object>();
		String strSQL = getConsultaDistinctIndicadorEfiCicPondBI(filtroBI, agrupamento);
		
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosBINaQuery(q, filtroBI, agrupamento);		
		
		lista = q.list();	
		
		if (lista.size() == 0) {
			efiCiclo = new BigDecimal(-1); 
		} else {
			lista = new ArrayList<Object>();
			strSQL = getConsultaIndicadorEfiCicPondBI(filtroBI, agrupamento);	
			q = this.getDaoSession().createSQLQuery(strSQL);
			q = setFiltrosBINaQuery(q, filtroBI, agrupamento);
			lista = q.list();
			
			for (Object reg : lista) {
				if (reg == null) {
					efiCiclo = new BigDecimal(-1);
				} else {
					efiCiclo = ConversaoTipos.converterParaBigDecimal((Object) reg);	
				}				
				break;
			}			
		}
		
		
		return efiCiclo;
	}

	@SuppressWarnings("unchecked")
	public BigDecimal resumoEfiCicBI(BiFiltroDTO filtroBI, FiltroAgrupamentoBI agrupamento) {
		BigDecimal efiCiclo = BigDecimal.ZERO;

		int _ciclopadraomedio = 0;		
		int _ciclolidomedio = 1;
		
		class RegistroLido {
			BigDecimal cicloPadraoMedio = BigDecimal.ZERO;			
			BigDecimal cicloLidoMedio = BigDecimal.ZERO;
		}
		

		List<Object> lista = new ArrayList<Object>();
		String strSQL = getConsultaIndicadorEfiCicBI(filtroBI, agrupamento);
		
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosBINaQuery(q, filtroBI, agrupamento);
		
		lista = q.list();		
		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			
			registro.cicloPadraoMedio = ConversaoTipos.converterParaBigDecimal(registroLido[_ciclopadraomedio]);			
			registro.cicloLidoMedio = ConversaoTipos.converterParaBigDecimal(registroLido[_ciclolidomedio]);
			
			efiCiclo = new BigDecimal(FormulasInjet.calcularEficienciaCiclo(registro.cicloPadraoMedio, registro.cicloLidoMedio));
			
			break;
		}
		
		return efiCiclo;
	}

	@SuppressWarnings("unchecked")
	public BigDecimal resumoIndPCABI(BiFiltroDTO filtroBI, FiltroAgrupamentoBI agrupamento) {
		BigDecimal indPCA = BigDecimal.ZERO;

		int _qtdPCA = 0;		
		int _qtdPC = 1;
		
		class RegistroLido {
			BigDecimal pcsCicloAtivas = BigDecimal.ZERO;			
			BigDecimal pcsCicloTotais = BigDecimal.ZERO;
		}
		

		List<Object> lista = new ArrayList<Object>();
		String strSQL = getConsultaIndicadorIndPCABI(filtroBI, agrupamento);
		
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q = setFiltrosBINaQuery(q, filtroBI, agrupamento);
		
		lista = q.list();		
		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			
			registro.pcsCicloAtivas = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdPCA]);			
			registro.pcsCicloTotais = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdPC]);
			
			indPCA = new BigDecimal(FormulasInjet.calcularIndiceCavidades(registro.pcsCicloAtivas, registro.pcsCicloTotais));
			
			break;
		}
		
		return indPCA;
	}

	private SQLQuery setFiltrosBINaQuery(SQLQuery q, BiFiltroDTO filtroBI, FiltroAgrupamentoBI agrupamento) {
		if (!filtroBI.getAnoIni().equals("")){
			q.setString("anomesini", filtroBI.getAnoIni().concat(filtroBI.getMesIni()));
			q.setString("anomesfim", filtroBI.getAnoFim().concat(filtroBI.getMesFim()));
		} else {
			q.setTimestamp("dthrini", filtroBI.getDtIniDt());
			q.setTimestamp("dthrfim", filtroBI.getDtFimDt());
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
				if (!filtroBI.getCdClasseMaquina().equals("")) {
					q.setString("cdclasse", filtroBI.getCdClasseMaquina());	
				} else {
					if (!filtroBI.getCdGalpao().equals("")) {
						q.setString("cdgalpao", filtroBI.getCdGalpao());
					}
				}
				
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			q.setString("cdrap", filtroBI.getCdRap());
		}
		
		// estrutura - eventualmente necessaria para efic ciclo
		if (!filtroBI.getCdEstrutura().equals("")) {
			q.setString("cdestrutura", filtroBI.getCdEstrutura()); 	
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
}
