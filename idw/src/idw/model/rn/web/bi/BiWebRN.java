package idw.model.rn.web.bi;

import java.awt.Color;
import java.math.BigDecimal; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwRt;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN; 
import idw.model.rn.GTRN;
import idw.model.rn.GrupoFerramentaRN;
import idw.model.rn.PTRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.TurnoRN; 
import idw.model.rn.injet.FuncoesApoioInjet;
import idw.model.rn.web.bi.BiWebRN;
import idw.model.rn.web.injet.monitorizacao.detalhe.DetalheMonitorizacaoWebInjetRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebIndicadorRN;
import idw.util.AritmeticaUtil;
import idw.util.Cor;
import idw.util.FormulasInjet;
import idw.webservices.rest.dto.GtDTO;
import idw.webservices.rest.dto.PtDTO;
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
import idw.webservices.rest.idw.v2.dto.GrupoFerramentasDTO2;
import idw.webservices.rest.idw.v2.dto.GtDTO2;
import idw.webservices.rest.idw.v2.dto.ProdutoDTO2;
import idw.webservices.rest.idw.v2.dto.PtDTO2;
import idw.webservices.rest.idw.v2.dto.TurnoDTO2;
import ms.util.ConversaoTipos;

public class BiWebRN extends AbstractRN<DAOGenerico> {

	public static final int CASAS_DECIMAIS_KG_TON = 4;
	public static final BigDecimal DIVISOR_KG = new BigDecimal(1000);
	public static final BigDecimal DIVISOR_TON = new BigDecimal(1000000);
	public static final BigDecimal DIVISOR_HORAS_DECIMAL = new BigDecimal(3600);

	public enum FiltroAgrupamentoBI {
		BI_TOTAL_GERAL(0), 
		BI_TOTAL_ANO_MES(1), 
		BI_TOTAL_DATA(2), 
		BI_TOTAL_MAQUINA(3), 
		BI_TOTAL_MAQUINA_FERRAMENTA_ESTRUTURA(4), 
		BI_TOTAL_TURNO(5),
		BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO(6);

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


	private DetalheMonitorizacaoWebIndicadorRN indicadorRN;
	
	private class Indicadores {
		String ano;
		String mes;			
		Date dtTurno ;			
		String cdPt;
		String cdRap; 
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
	

	public BiWebRN(String formatoData, String formatoDataHora) {
		this(new DAOGenerico(), formatoData, formatoDataHora);
	}

	
	public BiWebRN(DAOGenerico dao, String formatoData, String formatoDataHora) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
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
		HQL += "  FROM DwRap a ";
		HQL += " WHERE a.stAtivo = 1 ";
		HQL += " ORDER BY a.cdRap ";
		
		List<DwRap> lista = null;

		Query q = getDaoSession().createQuery(HQL);

		lista = q.list();
		for(DwRap molde : lista) {
			RapBIDTO rap = new RapBIDTO();

			rap.setIdRap(molde.getId());
			rap.setCdRap(molde.getCdRap());
			rap.setCdRapView(molde.getDsRap());
			rap.setDsRap(molde.getDsRap());
			
			retorno.add(rap);
		}
		
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public List<GrupoFerramentaBIDTO> getGrupoFerramentasAtivas() {
		List<GrupoFerramentaBIDTO> retorno = new ArrayList<>();
		
		String HQL = "";
		
		HQL += "SELECT a ";
		HQL += "  FROM DwGrupoFerramenta a ";
		HQL += " WHERE a.stAtivo = 1";
		HQL += " ORDER BY a.cdGrupoFerramenta ";
		
		List<DwGrupoFerramenta> lista = null;

		Query q = getDaoSession().createQuery(HQL);

		lista = q.list();
		for(DwGrupoFerramenta grp : lista) {
			GrupoFerramentaBIDTO grupo = new GrupoFerramentaBIDTO();

			grupo.setCdGrpRAP(grp.getCdGrupoFerramenta());
			grupo.setDsGrpRAP(grp.getDsGrupoFerramenta());
			
			retorno.add(grupo);
		}			

		return retorno;
	}

	
	@SuppressWarnings("unchecked")
	public List<GtDTO> getGtsAtivos() {
		List<GtDTO> retorno = new ArrayList<>();
		
		String HQL = "";
		
		HQL += "SELECT DISTINCT a ";
		HQL += "  FROM OmGt a ";
		HQL += " WHERE a.stAtivo = 1 ";
		HQL += " ORDER BY a.cdGt ";
		
		List<OmGt> lista = null;

		Query q = getDaoSession().createQuery(HQL);

		lista = q.list();
		for(OmGt grp : lista) {
			GtDTO grupo = new GtDTO();

			grupo.setIdGt(grp.getIdGt().toString());
			grupo.setCdGt(grp.getCdGt());
			grupo.setDsGt(grp.getDsGt());
			grupo.setDsView(grp.getDsGt());
			
			retorno.add(grupo);
		}			

		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public List<PtDTO> getPtsAtivos() {
		List<PtDTO> retorno = new ArrayList<>();
		
		String HQL = "";
		
		HQL += "SELECT DISTINCT a ";
		HQL += "  FROM OmPt a ";
		HQL += " WHERE a.stAtivo = 1 ";
		HQL += "   AND a.omTppt.cdTppt = 'CIC' "; 
		HQL += "   AND a.tpSessao IN (0, 1, 2) ";		
		HQL += " ORDER BY a.cdPt ";
		

		
		List<OmPt> lista = null;

		Query q = getDaoSession().createQuery(HQL);

		lista = q.list();
		for(OmPt pt : lista) {
			PtDTO dto = new PtDTO();

			dto.setIdPt(pt.getId());
			dto.setCdPt(pt.getCdPt());
			dto.setDsPt(pt.getDsPt());
			
			retorno.add(dto);
		}			

		return retorno;
	}
 
	@SuppressWarnings("unchecked")
	public List<ProdutoBIDTO> getProdutosAtivos() {
		List<ProdutoBIDTO> retorno = new ArrayList<>();
		
		String HQL = "";
		
		HQL += "SELECT a ";
		HQL += "  FROM OmProduto a ";
		HQL += " WHERE a.stAtivo = 1";
		HQL += " AND a.cdProduto <> '0' ";		
		HQL += " ORDER BY a.cdProduto ";
		
		List<OmProduto> lista = null;

		Query q = getDaoSession().createQuery(HQL);

		lista = q.list();
		for(OmProduto pro : lista) {
			ProdutoBIDTO produto = new ProdutoBIDTO();

			produto.setCdProduto(pro.getCdProduto());
			produto.setDsProduto(pro.getDsProduto());
			
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
		
		strSQL = strSQL.concat("SELECT DISTINCT c.cd_produto, c.ds_produto ");
		
		if (!filtroBI.getAnoIni().equals("")){
			strSQL = strSQL.concat("  FROM viewBIAnoMesProdutos a ");
		} else {
			strSQL = strSQL.concat("  FROM viewBIDtRefProdutos a ");	
		}		
		
		strSQL = strSQL.concat("  JOIN om_pt b ON (b.cd_pt = a.cd_pt AND b.st_ativo = 1) ");
		strSQL = strSQL.concat("  JOIN om_produto c ON (c.cd_produto = a.cd_produto AND c.st_ativo = 1) ");
		
		// grupo de trabalho
		if (!filtroBI.getCdGt().equals("")) {
			strSQL = strSQL.concat("  JOIN om_obj f ON (f.id_pt = b.id_pt) ");		
			strSQL = strSQL.concat("  JOIN om_gt gt ON (gt.id_gt = f.id_gt AND gt.cd_gt = :cdgt AND gt.st_ativo = 1)  ");			
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN dw_rap g ON (g.cd_rap = a.cd_rap AND g.st_ativo =1) ");	
			strSQL = strSQL.concat("  JOIN dw_rap_grupo gr ON (gr.id_rap = gr.id_rap) ");	
			strSQL = strSQL.concat("  JOIN dw_grupo_ferramenta grf ON (grf.id_grupo_ferramenta = gr.id_grupo_ferramenta AND grf.cd_grupo_ferramenta = :cdgrprap AND grf.st_ativo = 1)");	
		}

		
		// filtros		
		if (!filtroBI.getAnoIni().equals("")) {
			strSQL = strSQL.concat(" WHERE ((a.ano * 1000) + a.mes) BETWEEN :ami AND :amf");
		} else {
			strSQL = strSQL.concat(" WHERE a.dt_referencia BETWEEN :dthrini AND :dthrfim ");	
		}
		

		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cd_turno = :cdturno ");
		}
		
		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND a.cd_pt = :cdpt ");	
		} else {
			if (!filtroBI.getCdClasseMaquina().equals("")) {
				if (filtroBI.getCdClasseMaquina().equals("A")) {
					strSQL = strSQL.concat("  AND b.tp_classeabc = 0 "); 
					
				} else if (filtroBI.getCdClasseMaquina().equals("B")) {
					strSQL = strSQL.concat("  AND b.tp_classeabc = 1 ");
					
				} else {
					strSQL = strSQL.concat("  AND b.tp_classeabc = 2 ");	
				}				
			} 
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND a.cd_rap = :cdrap ");	
		}
		
		strSQL = strSQL.concat(" ORDER BY c.cd_produto ");
		
		
		
		// recupera prrodutos
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		

		if (!filtroBI.getAnoIni().equals("")){
			Integer ami = (ConversaoTipos.converterParaBigDecimal(filtroBI.getAnoIni()).intValue() * 1000) + ConversaoTipos.converterParaBigDecimal(filtroBI.getMesIni()).intValue();
			Integer amf = (ConversaoTipos.converterParaBigDecimal(filtroBI.getAnoFim()).intValue() * 1000) + ConversaoTipos.converterParaBigDecimal(filtroBI.getMesFim()).intValue();				
			q.setParameter("ami", ami);
            q.setParameter("amf", amf);
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
		
		
		return retorno;
	}
	
	
	@SuppressWarnings("unchecked")
	private List<String> getListaUltimasOPs(Date dtReferencia, String cdTurno, String cdGt) {
		List<String> listaOPs = new ArrayList<String>();

		Map<String, String> mapPtxCp = new HashMap<String, String>();
		
		MapQuery q = new MapQuery(this.getDao().getSession());

		// recupera lista de postos do gt 
		q.append("SELECT rt ");
		q.append("  FROM DwRt rt ");
		q.append("  JOIN rt.omPt pt ");
		q.append("  JOIN pt.omObjs objs ");
		q.append("  JOIN objs.omGtByIdGt gt ");
		q.append(" WHERE rt.dtReferencia = :dtReferencia ");
		q.append("   AND rt.dwTurno.cdTurno = :cdTurno ");
		q.append("   AND gt.cdGt = :cdGt ");
		q.append(" ORDER BY rt.dthrHeartbeat desc, rt.dthrEvento DESC, rt.idRt DESC");

		q.defineParametroData("dtReferencia", dtReferencia);
		q.defineParametro("cdTurno", cdTurno);
		q.defineParametro("cdGt", cdGt);
		
	
		List<DwRt> lista = q.query().list();
		for (DwRt rt : lista) {
			if (! mapPtxCp.containsKey(rt.getOmPt().getCdPt())) {
				mapPtxCp.put(rt.getOmPt().getCdPt(), rt.getPpCp().getCdCp());
				listaOPs.add(rt.getPpCp().getCdCp());
			}
		}
		
		mapPtxCp = null;
		q = null;
		lista = null;
		
		return listaOPs;
	}
	
	@SuppressWarnings("unchecked")
	private BigDecimal getProdPlan(List<String> listaOPs) { 
		MapQuery q = new MapQuery(this.getDao().getSession());
		List<Object> lista = new ArrayList<Object>();

		for (String cp: listaOPs) {
			Object objCp = cp;
			lista.add(objCp);
		}
		
		// recupera lista de postos do gt 
		q.append("SELECT SUM(cpp.pcsProducaoplanejada) as qtdplan ");
		q.append("  FROM PpCp cp ");
		q.append("  JOIN cp.ppCpprodutos cpp ");
		q.append(" WHERE cp.cdCp IN (:lista) ");
		
		q.defineListaParametro("lista", lista);
		
	
		BigDecimal totalPlan = ConversaoTipos.converterParaBigDecimal(q.query().uniqueResult());
		
		q = null;
		lista = null;
		
		return totalPlan;
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
			strSQLGroup = "t.ano, t.mes ";
			strSQLGroupBySubQuery = "b.ano, b.mes ";
		} 
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA) {
			strSQLGroup = "t.dt_referencia ";
			strSQLGroupBySubQuery = "b.dt_referencia ";
		}
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA || agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO) {
			strSQLGroup = "t.cd_pt ";
			strSQLGroupBySubQuery = "b.cd_pt ";
		} 		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_FERRAMENTA_ESTRUTURA) {
			strSQLGroup = "t.cd_pt, t.cd_rap";
			strSQLGroupBySubQuery = "b.cd_pt, b.cd_rap";
		} 				
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_TURNO) {
			strSQLGroup = "t.cd_turno, t.ds_turno ";
			strSQLGroupBySubQuery = "b.cd_turno, tur.ds_turno ";
		} 		
		
		// indicadores
		
		// tempos que dependem dos produtos
		strSQLIndicadores = strSQLIndicadores.concat(" t.seg_temporefugo, t.seg_pci, ");
		
		// qtdes na unidade básica
		strSQLIndicadores = strSQLIndicadores.concat(" FLOOR(t.pcs_prodprev) as pcs_prodprev, FLOOR(t.pcs_perdasparcp) as pcs_perdasparcp, FLOOR(t.pcs_perdaspci) as pcs_perdaspci, t.pcs_prodbruta, ");
		strSQLIndicadores = strSQLIndicadores.concat(" t.pcs_prodref, t.pcs_prodliq, (CASE WHEN t.pcs_perdasritmo >=0 THEN FLOOR(t.pcs_perdasritmo)  ELSE FLOOR(ABS(t.pcs_perdasritmo)) * -1 END) as pcs_perdasritmo, ");
		strSQLIndicadores = strSQLIndicadores.concat(" ( FLOOR(t.pcs_perdasparcp) + FLOOR(t.pcs_perdaspci) + (CASE WHEN t.pcs_perdasritmo >=0 THEN FLOOR(t.pcs_perdasritmo)  ELSE FLOOR(ABS(t.pcs_perdasritmo)) * -1 END) + t.pcs_prodref ) as pcs_perdas, "); 
		
		// qtdes em gramas
		strSQLIndicadores = strSQLIndicadores.concat(" t.gr_prodprev, t.gr_perdasparcp, t.gr_perdaspci, t.gr_prodbruta, ");
		strSQLIndicadores = strSQLIndicadores.concat(" t.gr_prodref, t.gr_prodliq, t.gr_perdasritmo, ");
		strSQLIndicadores = strSQLIndicadores.concat(" ( t.gr_perdasparcp + t.gr_perdaspci + (CASE WHEN gr_perdasritmo >= 0 THEN t.gr_perdasritmo ELSE (ABS(t.gr_perdasritmo)) * -1 END) + t.gr_prodref ) as gr_perdas,  ");
		
		// indicadores - efi rea
		strSQLIndicadores = strSQLIndicadores.concat(" (CASE WHEN FLOOR(t.pcs_prodprev) = 0 THEN 0 ELSE (t.pcs_prodliq / FLOOR(t.pcs_prodprev)) * 100 END) as efirea, ");
		strSQLIndicadores = strSQLIndicadores.concat(" (CASE WHEN t.gr_prodprev = 0 THEN 0 ELSE (t.gr_prodliq / t.gr_prodprev) * 100 END) as efireaP, ");

		// indicadores - ind ref
		strSQLIndicadores = strSQLIndicadores.concat(" (CASE WHEN t.pcs_prodbruta = 0 THEN 0 ELSE (t.pcs_prodref / t.pcs_prodbruta) * 100 END) as indref, ");
		strSQLIndicadores = strSQLIndicadores.concat(" (CASE WHEN t.gr_prodbruta = 0 THEN 0 ELSE (t.gr_prodref / t.gr_prodbruta) * 100 END) as indrefP, ");

		// indicadores - ind perdas
		strSQLIndicadores = strSQLIndicadores.concat(" (CASE WHEN FLOOR(t.pcs_prodprev) = 0 THEN 0 ELSE (( FLOOR(t.pcs_perdasparcp) + FLOOR(t.pcs_perdaspci) + (CASE WHEN t.pcs_perdasritmo >=0 THEN FLOOR(t.pcs_perdasritmo)  ELSE FLOOR(ABS(t.pcs_perdasritmo)) * -1 END) + t.pcs_prodref ) / FLOOR(t.pcs_prodprev)) * 100 END) as indperda, ");
		strSQLIndicadores = strSQLIndicadores.concat(" (CASE WHEN t.gr_prodprev = 0 THEN 0 ELSE (( t.gr_perdasparcp + t.gr_perdaspci + (CASE WHEN gr_perdasritmo >= 0 THEN t.gr_perdasritmo ELSE (ABS(t.gr_perdasritmo)) * -1 END) + t.gr_prodref ) / t.gr_prodprev) * 100 END) as indperdaP ");

		
		// tempos que dependem dos produtos
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.seg_temporefugo) as seg_temporefugo, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.seg_pci) as seg_pci, ");
		
		
		//  qtdes na unidade básica
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.pcs_prodprev) as pcs_prodprev, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.pcs_perdasparcp) as pcs_perdasparcp, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.pcs_perdaspci) as pcs_perdaspci, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.pcs_prodbruta) as pcs_prodbruta, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.pcs_prodref) as pcs_prodref, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.pcs_prodbruta - b.pcs_prodref) as pcs_prodliq, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.pcs_perdasritmo) as pcs_perdasritmo, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.pcs_perdasparcp + b.pcs_prodref + b.pcs_perdaspci + b.pcs_perdasritmo) as pcs_perdas, ");
		
		// qtdes em gramas
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.gr_prodprev) as gr_prodprev, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.gr_perdasparcp) as gr_perdasparcp, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.gr_perdaspci) as gr_perdaspci, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.gr_prodbruta) as gr_prodbruta, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.gr_prodref) as gr_prodref, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.gr_prodbruta - b.gr_prodref) as gr_prodliq, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.gr_perdasritmo) as gr_perdasritmo, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(b.gr_perdasparcp + b.gr_prodref + b.gr_perdaspci + b.gr_perdasritmo) as qtdperdasGr ");
		
		
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
				
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN dw_turno tur ON (tur.cd_turno = b.cd_turno AND tur.st_ativo = 1) ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN om_pt pt ON (pt.cd_pt = b.cd_pt AND pt.st_ativo = 1) ");				
		
		// grupo de trabalho
		if (!filtroBI.getCdGt().equals("")) {				
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN om_obj f ON (f.id_pt = pt.id_pt) ");		
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN om_gt gt ON (gt.id_gt = f.id_gt AND gt.cd_gt = :cdgt AND gt.st_ativo = 1)  ");			
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN dw_rap g ON (g.cd_rap = b.cd_rap AND g.st_ativo =1) ");	
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN dw_rap_grupo gr ON (gr.id_rap = gr.id_rap) ");	
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN dw_grupo_ferramenta grf ON (grf.id_grupo_ferramenta = gr.id_grupo_ferramenta AND grf.cd_grupo_ferramenta = :cdgrprap AND grf.st_ativo = 1)");	
		}

		
		// filtros	
		if (!filtroBI.getAnoIni().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" WHERE ((b.ano * 1000) + b.mes) BETWEEN :ami AND :amf ");
		} else {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" WHERE b.dt_referencia BETWEEN :dthrini AND :dthrfim ");	
		}
		

		if (!filtroBI.getCdTurno().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" AND b.cd_turno = :cdturno ");
		}
		
		if (!filtroBI.getCdPt().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND b.cd_pt = :cdpt ");	
		} else {
			if (!filtroBI.getCdClasseMaquina().equals("")) {
				if (filtroBI.getCdClasseMaquina().equals("A")) {
					strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND pt.tp_classeabc = 0 "); 
					
				} else if (filtroBI.getCdClasseMaquina().equals("B")) {
					strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND pt.tp_classeabc = 1 ");
					
				} else {
					strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND pt.tp_classeabc = 2 ");	
				}				
			} 
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND b.cd_rap = :cdrap ");	
		}
		
		
		
		if (!filtroBI.getCdProduto().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND b.cd_produto = :cdproduto ");	
		}
		
		
		
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO) {
			// recupera lista de ops que devem ser filtradas
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" AND b.cd_cp IN (:lista) ");
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
			strSQLGroup = "t.ano, t.mes ";
			strSQLGroupBySubQuery = "a.ano, a.mes ";
		} 
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA) {
			strSQLGroup = "t.dt_referencia ";
			strSQLGroupBySubQuery = "a.dt_referencia ";
		}
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA || agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO) {
			strSQLGroup = "t.cd_pt ";
			strSQLGroupBySubQuery = "a.cd_pt ";
		}
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_FERRAMENTA_ESTRUTURA) {
			strSQLGroup = "t.cd_pt, t.cd_rap ";
			strSQLGroupBySubQuery = "a.cd_pt, a.cd_rap ";
		} 				
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_TURNO) {
			strSQLGroup = "t.cd_turno, t.ds_turno ";
			strSQLGroupBySubQuery = "a.cd_turno, tur.ds_turno ";
		} 

		// indicadores
		
		// tempos que NAO dependem dos produtos
		strSQLIndicadores = strSQLIndicadores.concat(" t.seg_ciclosprodutivos, t.seg_ciclosimprodutivos, t.seg_tempoparada_cp, t.seg_tempoparada_sp,  ");
		strSQLIndicadores = strSQLIndicadores.concat(" t.seg_ritmo, t.seg_tempoativo, ");
		
		strSQLIndicadores = strSQLIndicadores.concat(" (t.seg_tempoativo + seg_tempoparada_sp) as tmpTotal, ");

		// indicadores - ind par
		strSQLIndicadores = strSQLIndicadores.concat(" (CASE WHEN t.seg_tempoativo = 0 THEN 0 ELSE (t.seg_tempoparada_cp / t.seg_tempoativo) * 100 END) as indpar, ");
		// indicadores - utilizacao
		strSQLIndicadores = strSQLIndicadores.concat(" (CASE WHEN t.seg_tempoativo = 0 THEN 0 ELSE ( (t.seg_tempoativo - t.seg_tempoparada_sp) / t.seg_tempoativo) * 100 END) as utilizacao ");		
		
		
		// tempos que NAO dependem dos produtos	
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(a.seg_ciclosprodutivos) as seg_ciclosprodutivos, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(a.seg_ciclosimprodutivos) as seg_ciclosimprodutivos, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(a.seg_tempoparada_cp) as seg_tempoparada_cp, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(a.seg_tempoparada_sp) as seg_tempoparada_sp, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(a.seg_ritmo) as seg_ritmo, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(a.seg_tempoativo) as seg_tempoativo "); 
		
		
		if (!filtroBI.getAnoIni().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  FROM viewBIAnoMesTempos a ");
		} else {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  FROM viewBIDtRefTempos a ");
		}
		
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN dw_turno tur ON (tur.cd_turno = a.cd_turno AND tur.st_ativo = 1) ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN om_pt pt ON (pt.cd_pt = a.cd_pt AND pt.st_ativo = 1) ");	

		
		// tabelas relacionadas a grupo de maquina
		if (!filtroBI.getCdGt().equals("")) {				
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN om_obj f ON (f.id_pt = pt.id_pt) ");		
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN om_gt gt ON (gt.id_gt = f.id_gt AND gt.cd_gt = :cdgt AND gt.st_ativo = 1)  ");			
		}
		
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN dw_rap g ON (g.cd_rap = a.cd_rap AND g.st_ativo =1) ");	
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN dw_rap_grupo gr ON (gr.id_rap = gr.id_rap) ");	
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN dw_grupo_ferramenta grf ON (grf.id_grupo_ferramenta = gr.id_grupo_ferramenta AND grf.cd_grupo_ferramenta = :cdgrprap AND grf.st_ativo = 1)");	
		}

		
		if (!filtroBI.getCdProduto().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN dw_folha fl ON (fl.cd_folha = a.cd_folha AND fl.st_ativo = 1)  ");
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN dw_folharap flr ON (flr.id_folha = fl.id_folha)  ");
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN dw_folharapcom flrc ON (flrc.id_folharap = flr.id_folharap)  "); 
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN om_produto pro ON (pro.id_produto = flrc.id_produto AND pro.cd_produto = :cdproduto)  ");			
		} 
		
		
		// filtros	
		if (!filtroBI.getAnoIni().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" WHERE ((a.ano * 1000) + a.mes) BETWEEN :ami AND :amf ");
		} else {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" WHERE a.dt_referencia BETWEEN :dthrini AND :dthrfim ");	
		}
		

		if (!filtroBI.getCdTurno().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" AND a.cd_turno = :cdturno ");
		}
		
		if (!filtroBI.getCdPt().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND a.cd_pt = :cdpt ");	
		} else {
			if (!filtroBI.getCdClasseMaquina().equals("")) {
				if (filtroBI.getCdClasseMaquina().equals("A")) {
					strSQL = strSQL.concat("  AND pt.tp_classeabc = 0 "); 
					
				} else if (filtroBI.getCdClasseMaquina().equals("B")) {
					strSQL = strSQL.concat("  AND pt.tp_classeabc = 1 ");
					
				} else {
					strSQL = strSQL.concat("  AND pt.tp_classeabc = 2 ");	
				}				
			} 
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND a.cd_rap = :cdrap ");	
		}
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO) {
			// recupera lista de ops que devem ser filtradas
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" AND a.cd_cp IN (:lista) ");
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
		String strSQLGroupBySubQuery = " a.cd_pt, a.cd_rap, a.dt_rev_folha, a.folha_ciclopadrao ";
		String strSQLIndicadores = "";
		String strSQLTotaisSubQuery = "";
		String strSQLTabelasSubQuery = "";
		String strSQLWhereSubQuery = "";
		String strSQLHavingSubQuery = " HAVING SUM(a.seg_ciclosprodutivos) > 0 AND SUM(a.qt_ciclosprodutivos) > 0 ";
		
		
		// indicadores		
		strSQLIndicadores = strSQLIndicadores.concat(" AVG(t.folha_ciclopadrao) as ciclopadraomedio, ");
		strSQLIndicadores = strSQLIndicadores.concat(" AVG(t.seg_ciclosprodutivos / t.qt_ciclosprodutivos) as ciclolidomedio ");
		
		
		// sub-totais
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(a.seg_ciclosprodutivos) as seg_ciclosprodutivos, ");
		strSQLTotaisSubQuery = strSQLTotaisSubQuery.concat(" SUM(a.qt_ciclosprodutivos) as qt_ciclosprodutivos ");
		
		
		if (!filtroBI.getAnoIni().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  FROM viewBIAnoMesTempos a ");
		} else {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  FROM viewBIDtRefTempos a ");
		}
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN om_pt b ON (b.cd_pt = a.cd_pt AND b.st_ativo = 1) ");
		
		// grupo de trabalho
		if (!filtroBI.getCdGt().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN om_obj f ON (f.id_pt = b.id_pt) ");		
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN om_gt gt ON (gt.id_gt = f.id_gt AND gt.cd_gt = :cdgt AND gt.st_ativo = 1)  ");				
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN dw_rap g ON (g.cd_rap = a.cd_rap AND g.st_ativo =1) ");	
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN dw_rap_grupo gr ON (gr.id_rap = gr.id_rap) ");	
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN dw_grupo_ferramenta grf ON (grf.id_grupo_ferramenta = gr.id_grupo_ferramenta AND grf.cd_grupo_ferramenta = :cdgrprap AND grf.st_ativo = 1)");	
		}

		
		if (!filtroBI.getCdProduto().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN dw_folha fl ON (fl.cd_folha = a.cd_folha AND fl.st_ativo = 1)  ");
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN dw_folharap flr ON (flr.id_folha = fl.id_folha)  ");
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN dw_folharapcom flrc ON (flrc.id_folharap = flr.id_folharap)  "); 
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN om_produto pro ON (pro.id_produto = flrc.id_produto AND pro.cd_produto = :cdproduto)  ");			
		}
		
		// filtros		
		if (!filtroBI.getAnoIni().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" WHERE ((a.ano * 1000) + a.mes) BETWEEN :ami AND :amf ");
		} else {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" WHERE a.dt_referencia BETWEEN :dthrini AND :dthrfim ");	
		}


		if (!filtroBI.getCdTurno().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" AND a.cd_turno = :cdturno ");
		}
		
		if (!filtroBI.getCdPt().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND a.cd_pt = :cdpt ");	
		} else {
			if (!filtroBI.getCdClasseMaquina().equals("")) {
				if (filtroBI.getCdClasseMaquina().equals("A")) {
					strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND b.tp_classeabc = 0 "); 
					
				} else if (filtroBI.getCdClasseMaquina().equals("B")) {
					strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND b.tp_classeabc = 1 ");
					
				} else {
					strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND b.tp_classeabc = 2 ");	
				}				
			} 
		}
		
		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND a.cd_rap = :cdrap ");	
		}
				
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO) {
			// recupera lista de ops que devem ser filtradas
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" AND a.cd_cp IN (:lista) ");
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
		
		strSQL = strSQL.concat("SELECT a.cd_rap, a.dt_rev_folha, COUNT(DISTINCT a.cd_pt) ");
		
		if (!filtroBI.getAnoIni().equals("")) {
			strSQL = strSQL.concat("  FROM viewBIAnoMesTempos a ");
		} else {
			strSQL = strSQL.concat("  FROM viewBIDtRefTempos a ");
		}
		strSQL = strSQL.concat(" JOIN om_pt pt ON (pt.cd_pt = a.cd_pt AND pt.st_ativo = 1) ");
		
		// tabelas relacionadas a grupo de maquina
		// grupo de trabalho
		if (!filtroBI.getCdGt().equals("")) {				
			strSQL = strSQL.concat("  JOIN om_obj f ON (f.id_pt = pt.id_pt) ");		
			strSQL = strSQL.concat("  JOIN om_gt gt ON (gt.id_gt = f.id_gt AND gt.cd_gt = :cdgt AND gt.st_ativo = 1)  ");			
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN dw_rap g ON (g.cd_rap = a.cd_rap AND g.st_ativo =1) ");	
			strSQL = strSQL.concat("  JOIN dw_rap_grupo gr ON (gr.id_rap = gr.id_rap) ");	
			strSQL = strSQL.concat("  JOIN dw_grupo_ferramenta grf ON (grf.id_grupo_ferramenta = gr.id_grupo_ferramenta AND grf.cd_grupo_ferramenta = :cdgrprap AND grf.st_ativo = 1)");	
		}


		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat(" JOIN dw_folha fl ON (fl.cd_folha = a.cd_folha AND fl.st_ativo = 1)  ");
			strSQL = strSQL.concat(" JOIN dw_folharap flr ON (flr.id_folha = fl.id_folha)  ");
			strSQL = strSQL.concat(" JOIN dw_folharapcom flrc ON (flrc.id_folharap = flr.id_folharap)  "); 
			strSQL = strSQL.concat(" JOIN om_produto pro ON (pro.id_produto = flrc.id_produto AND pro.cd_produto = :cdproduto)  ");			
		}
		

		// filtros		
		if (!filtroBI.getAnoIni().equals("")) {
			strSQL = strSQL.concat(" WHERE ((a.ano * 1000) + a.mes) BETWEEN :ami AND :amf ");
		} else {
			strSQL = strSQL.concat(" WHERE a.dt_referencia BETWEEN :dthrini AND :dthrfim ");	
		}


		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cd_turno = :cdturno ");
		}
		
		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND a.cd_pt = :cdpt ");	
		} else {
			if (!filtroBI.getCdClasseMaquina().equals("")) {
				if (filtroBI.getCdClasseMaquina().equals("A")) {
					strSQL = strSQL.concat("  AND pt.tp_classeabc = 0 "); 
					
				} else if (filtroBI.getCdClasseMaquina().equals("B")) {
					strSQL = strSQL.concat("  AND pt.tp_classeabc = 1 ");
					
				} else {
					strSQL = strSQL.concat("  AND pt.tp_classeabc = 2 ");	
				}				
			} 
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND a.cd_rap = :cdrap ");	
		}
			
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO) {
			// recupera lista de ops que devem ser filtradas
			strSQL = strSQL.concat(" AND a.cd_cp IN (:lista) ");
		}
 
		strSQL = strSQL.concat("   AND a.qt_ciclosprodutivos > 0");
		strSQL = strSQL.concat(" GROUP BY a.cd_rap, a.dt_rev_folha ");
		strSQL = strSQL.concat(" HAVING COUNT(DISTINCT a.cd_pt) > 1 ");
		
		return strSQL;
	}

	private String getConsultaIndicadorEfiCicPondBI(BiFiltroDTO filtroBI, FiltroAgrupamentoBI agrupamento) {
		String strSQL = "";
		
		
		strSQL = strSQL.concat("SELECT AVG(ecp.efixtempoativo / ecp.tempoativo) as eficicpond ");
		strSQL = strSQL.concat("  FROM ( ");
		
		strSQL = strSQL.concat("        SELECT p.cd_rap, p.dt_rev_folha, ");
		strSQL = strSQL.concat("               SUM(p.eficic * p.seg_tempoativo) as efixtempoativo, ");
		strSQL = strSQL.concat("               SUM(p.seg_tempoativo) as tempoativo ");
		strSQL = strSQL.concat("          FROM ( ");
		
		strSQL = strSQL.concat("                 SELECT t.*, ");
		strSQL = strSQL.concat("                        (t.folha_ciclopadrao / (t.seg_ciclosprodutivos / t.qt_ciclosprodutivos) ) * 100 as eficic ");
		strSQL = strSQL.concat("                   FROM ( ");
		
		
		// inicio sub-query		
		strSQL = strSQL.concat("						 SELECT a.cd_pt, a.cd_rap, a.dt_rev_folha, a.folha_ciclopadrao,");
		strSQL = strSQL.concat("       						    SUM(a.seg_ciclosprodutivos) as seg_ciclosprodutivos, ");
		strSQL = strSQL.concat("       							SUM(a.qt_ciclosprodutivos) as qt_ciclosprodutivos, ");
		strSQL = strSQL.concat("       						    SUM(a.seg_tempoativo) as seg_tempoativo ");	
		
		if (!filtroBI.getAnoIni().equals("")) {
			strSQL = strSQL.concat("  FROM viewBIAnoMesTempos a ");
		} else {
			strSQL = strSQL.concat("  FROM viewBIDtRefTempos a ");
		}
		strSQL = strSQL.concat(" JOIN om_pt pt ON (pt.cd_pt = a.cd_pt AND pt.st_ativo = 1) ");
		
		// grupo de trabalho
		if (!filtroBI.getCdGt().equals("")) {				
			strSQL = strSQL.concat("  JOIN om_obj f ON (f.id_pt = pt.id_pt) ");		
			strSQL = strSQL.concat("  JOIN om_gt gt ON (gt.id_gt = f.id_gt AND gt.cd_gt = :cdgt AND gt.st_ativo = 1)  ");			
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN dw_rap g ON (g.cd_rap = a.cd_rap AND g.st_ativo =1) ");	
			strSQL = strSQL.concat("  JOIN dw_rap_grupo gr ON (gr.id_rap = gr.id_rap) ");	
			strSQL = strSQL.concat("  JOIN dw_grupo_ferramenta grf ON (grf.id_grupo_ferramenta = gr.id_grupo_ferramenta AND grf.cd_grupo_ferramenta = :cdgrprap AND grf.st_ativo = 1)");	
		}
 
		// produto
		if (!filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat(" JOIN dw_folha fl ON (fl.cd_folha = a.cd_folha AND fl.st_ativo = 1)  ");
			strSQL = strSQL.concat(" JOIN dw_folharap flr ON (flr.id_folha = fl.id_folha)  ");
			strSQL = strSQL.concat(" JOIN dw_folharapcom flrc ON (flrc.id_folharap = flr.id_folharap)  "); 
			strSQL = strSQL.concat(" JOIN om_produto pro ON (pro.id_produto = flrc.id_produto AND pro.cd_produto = :cdproduto)  ");			
		} 
		
		// filtros		
		if (!filtroBI.getAnoIni().equals("")) {
			strSQL = strSQL.concat(" WHERE ((a.ano * 1000) + a.mes) BETWEEN :ami AND :amf ");
		} else {
			strSQL = strSQL.concat(" WHERE a.dt_referencia BETWEEN :dthrini AND :dthrfim ");	
		}



		if (!filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat(" AND a.cd_turno = :cdturno ");
		}
		
		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND a.cd_pt = :cdpt ");	
		} else {
			if (!filtroBI.getCdClasseMaquina().equals("")) {
				if (filtroBI.getCdClasseMaquina().equals("A")) {
					strSQL = strSQL.concat("  AND pt.tp_classeabc = 0 "); 
					
				} else if (filtroBI.getCdClasseMaquina().equals("B")) {
					strSQL = strSQL.concat("  AND pt.tp_classeabc = 1 ");
					
				} else {
					strSQL = strSQL.concat("  AND pt.tp_classeabc = 2 ");	
				}				
			} 
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND a.cd_rap = :cdrap ");	
		}
			
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO) {
			// recupera lista de ops que devem ser filtradas
			strSQL = strSQL.concat(" AND a.cd_cp IN (:lista) ");
		}
 
		
		strSQL = strSQL.concat(" GROUP BY a.cd_pt, a.cd_rap, a.dt_rev_folha, a.folha_ciclopadrao ");
		strSQL = strSQL.concat(" HAVING SUM(a.seg_ciclosprodutivos) > 0 AND SUM(a.qt_ciclosprodutivos) > 0 ");
		// fim sub-query
		
		
		strSQL = strSQL.concat(" 				) t ");
		strSQL = strSQL.concat(" 		) p  ");
		strSQL = strSQL.concat(" 	GROUP BY p.cd_rap, p.dt_rev_folha ");
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
			strSQLGroupBySubQuery = "a.ano, a.mes ";
		} 
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA) {
			strSQLGroupBySubQuery = "a.dt_referencia ";
		}
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA || agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO) {
			strSQLGroupBySubQuery = "a.cd_pt ";
		}
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_FERRAMENTA_ESTRUTURA) {
			strSQLGroupBySubQuery = "a.dt_referencia, a.cd_rap ";
		} 				
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_TURNO) {
			strSQLGroupBySubQuery = "a.cd_turno, tur.ds_turno ";
		} 		
		
		// indicadores		
		strSQLIndicadores = strSQLIndicadores.concat(" SUM(t.qt_ativa) as qt_ativa, ");
		strSQLIndicadores = strSQLIndicadores.concat(" SUM(t.qt_total) as qt_total ");
		
		
		if (!filtroBI.getAnoIni().equals("")) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  FROM viewBIAnoMesTempos a ");
		} else {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  FROM viewBIDtRefTempos a ");
		}
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN om_pt pt ON (pt.cd_pt = a.cd_pt AND pt.st_ativo = 1) ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN dw_turno tur ON (tur.cd_turno = a.cd_turno) ");
		
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN dw_folha fl ON (fl.cd_folha = a.cd_folha AND fl.st_ativo = 1)  ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN dw_folharap flr ON (flr.id_folha = fl.id_folha)  ");
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN dw_folharapcom flrc ON (flrc.id_folharap = flr.id_folharap)  "); 
		strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat(" JOIN om_produto pro ON (pro.id_produto = flrc.id_produto)  ");	
			
				
		// grupo de trabalho
		if (!filtroBI.getCdGt().equals("")) {				
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN om_obj f ON (f.id_pt = pt.id_pt) ");		
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN om_gt gt ON (gt.id_gt = f.id_gt AND gt.cd_gt = :cdgt AND gt.st_ativo = 1)  ");			
		}
		
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("") ) {
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN dw_rap g ON (g.cd_rap = a.cd_rap AND g.st_ativo =1) ");	
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN dw_rap_grupo gr ON (gr.id_rap = gr.id_rap) ");	
			strSQLTabelasSubQuery = strSQLTabelasSubQuery.concat("  JOIN dw_grupo_ferramenta grf ON (grf.id_grupo_ferramenta = gr.id_grupo_ferramenta AND grf.cd_grupo_ferramenta = :cdgrprap AND grf.st_ativo = 1)");	
		}

 				
		
		// filtros		
		if (!filtroBI.getAnoIni().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" WHERE ((a.ano * 1000) + a.mes) BETWEEN :ami AND :amf ");
		} else {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" WHERE a.dt_referencia BETWEEN :dthrini AND :dthrfim ");	
		}

		if (!filtroBI.getCdTurno().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" AND a.cd_turno = :cdturno ");
		}
		
		if (!filtroBI.getCdPt().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND a.cd_pt = :cdpt ");	
		} else {
			if (!filtroBI.getCdClasseMaquina().equals("")) {
				if (filtroBI.getCdClasseMaquina().equals("A")) {
					strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND pt.tp_classeabc = 0 "); 
					
				} else if (filtroBI.getCdClasseMaquina().equals("B")) {
					strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND pt.tp_classeabc = 1 ");
					
				} else {
					strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND pt.tp_classeabc = 2 ");	
				}				
			} 
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND a.cd_rap = :cdrap ");	
		}
		
 
		if (!filtroBI.getCdProduto().equals("")) {
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat("  AND pro.cd_produto = :cdproduto ");	
		}
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO) {
			// recupera lista de ops que devem ser filtradas
			strSQLWhereSubQuery = strSQLWhereSubQuery.concat(" AND a.cd_cp IN (:lista) ");
		}
 
		
		strSQL = "SELECT ";
		
		strSQL = strSQL.concat(strSQLIndicadores);
		
		strSQL = strSQL.concat(" FROM (SELECT DISTINCT ");
		
		if (!strSQLGroupBySubQuery.equals("")) {
			strSQL = strSQL.concat(strSQLGroupBySubQuery + ", ");
		}
		strSQL = strSQL.concat(" a.cd_pt, a.cd_rap, pro.cd_produto, flrc.qt_ativa, flrc.qt_total ");
		
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
			TurnoRN rnTur = new TurnoRN(getDao());
			TurnoDTO2 turno = rnTur.getTurnoByCd(filtroBI.getCdTurno());
			
			filtroBI.setDsTurno(turno.getDsTurno());
			
			turno = null;
			rnTur = null;
		}
		 
		if (! filtroBI.getCdPt().equals("")) {			
			PTRN rnPt = new PTRN(getDao());
			PtDTO2 pt = rnPt.getPtByCd(filtroBI.getCdPt());
			
			filtroBI.setDsPt(pt.getDsPt());			
			
			pt = null;
			rnPt = null;
		}
		
		if (! filtroBI.getCdGt().equals("")) {
			GTRN rnGt = new GTRN();
			rnGt.setDao(getDao());			
			GtDTO2 gt = rnGt.getGtByCd(filtroBI.getCdGt());
			
			filtroBI.setDsGt(gt.getDsGt());
			
			gt = null;
			rnGt = null;
		}
		
		if (! filtroBI.getCdGrpRap().equals("")) {
			GrupoFerramentaRN rnGR = new GrupoFerramentaRN(getDao());
			GrupoFerramentasDTO2 grR = rnGR.getGrpFerramentaByCd(filtroBI.getCdGrpRap()); 
			
			filtroBI.setDsGrpRap(grR.getDsGrupoFerramenta());
			
			grR = null;
			rnGR = null;
		}
		
		if (! filtroBI.getCdProduto().equals("")) {
			ProdutoRN rnP = new ProdutoRN(getDao());
			ProdutoDTO2 pro = rnP.getProdutoByCd(filtroBI.getCdProduto());
			filtroBI.setDsProduto(pro.getDsProduto());		}
		
		
		// inicializa listas
		resumo.setTemposDiagrama(new PtTemposDTO());
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_ANO_MES) {
			resumo.setIndicadoresAnoMes(new ArrayList<BiIndicadoresAnoMesDTO>());			
		}
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA) {
			resumo.setIndicadoresDtRef(new ArrayList<BiIndicadoresDtRefDTO>());
		}
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA || agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO) {
			resumo.setIndicadoresPt(new ArrayList<BiIndicadoresPTDTO>());
		}
		
		if (filtroBI.getCdTurno().equals("")) {
			resumo.setIndicadoresTurno(new ArrayList<BiIndicadoresTurnoDTO>());	
		}
		
		if (! filtroBI.getCdProduto().equals("")) {
			resumo.setIndicadoresFichaTec(new ArrayList<BiIndicadoresFicTecDTO>());
		}
		
		//metas
		indicadorRN = new DetalheMonitorizacaoWebIndicadorRN(getDao(), formatoData, formatoDataHora);
		List<MetaIndicadorDTO> listaMetaIndicadores = DetalheMonitorizacaoWebIndicadorRN.getMetaIndicadores(getDao());
		List<MetaIndicadorDTO> listaMetas = new ArrayList<>();
		for (MetaIndicadorDTO meta : listaMetaIndicadores) {
			if (meta.getCdIndicador() != null) {
				listaMetas.add(meta);
			}
		}
		
		List<MetaIndicadorDTO> listaMetaIndicadoresPontos = listaMetas;
		resumo.setMetaIndicadores(listaMetas);
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
			
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA || agrupamento ==  FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO) {
				listaIndicadoresBI = resumoIndicadoresBI(filtroBI, agrupamento, listaMetaIndicadores);
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

			
			filtroItem.setAnoIni("");
			filtroItem.setMesIni("");
			filtroItem.setAnoFim("");
			filtroItem.setMesFim("");
			filtroItem.setAgrupamentoBI(FiltroAgrupamentoBI.BI_TOTAL_DATA.valor);
			filtroItem.setDtIni(DataHoraRN.dateToStringYYYYMMDDHHMMSS(DataHoraRN.getInicioMes(ConversaoTipos.converterParaBigDecimal(item.ano).intValue(), ConversaoTipos.converteParaInt(item.mes))));
			filtroItem.setDtFim(DataHoraRN.dateToStringYYYYMMDDHHMMSS(DataHoraRN.getFimMes(ConversaoTipos.converterParaBigDecimal(item.ano).intValue(), ConversaoTipos.converteParaInt(item.mes))));
			
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
			filtroItem.setDtIni(DataHoraRN.dateToStringYYYYMMDDHHMMSS(item.dtTurno));
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
				if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA || agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO) {
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
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_GERAL) {
			if (isComDados) {
				if (filtroBI.getAgrupamentoBI() == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO.valor) {
					// recuperar prod plan
					BigDecimal prodPlan = getProdPlan(getListaUltimasOPs(filtroBI.getDtIniDt(), filtroBI.getCdTurno(), filtroBI.getCdGt()));
					retorno.get(0).indicadoresBI.setProdPlan(ConversaoTipos.converteParaString(prodPlan, 2));
				}
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
		Map<String, ResumoBI> retorno = new HashMap<String, BiWebRN.ResumoBI>();
		String keyMap = "";

		int _dtturno = 0;
		
		int _cdPt = 0;

		int _cdRap = 1; 
		
		int _ano = 0;
		int _mes = 1;
		
		int _cdturno = 0;
		int _dsturno = 1;

		int _cdproduto = 0;
		int _dsproduto = 1;
		
		int _tmpcicnormal = 0;
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_GERAL) {
			_tmpcicnormal = 0;
		}
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA || 
		    agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA ||
		    agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO) {
			_tmpcicnormal = 1;
		} 		
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_ANO_MES || 
			agrupamento == FiltroAgrupamentoBI.BI_TOTAL_TURNO ||
			agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_FERRAMENTA_ESTRUTURA) {
			_tmpcicnormal = 2;
		} 
	
		int _tmpcicfinparada = _tmpcicnormal + 1;
		int _tmpparadasCP = _tmpcicfinparada + 1;
		int _tmpparadasSP = _tmpparadasCP + 1;
		int _tmpritmo = _tmpparadasSP + 1;
		int _tmpativo = _tmpritmo + 1;
		int _tmpTotal = _tmpativo + 1;
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
				registro.ano = String.valueOf(ConversaoTipos.converterParaBigDecimal(registroLido[_ano]).intValue());
				registro.mes = FuncoesApoioInjet.getStrZero(ConversaoTipos.converterParaBigDecimal(registroLido[_mes]).longValue(), 2);
				
				resumo.ano = registro.ano;
				resumo.mes = registro.mes;
				
				keyMap = (String) registro.ano + registro.mes;
				
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

			
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA || agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO) {
				registro.cdPt = (String) registroLido[_cdPt];
				
				resumo.cdPt = registro.cdPt;
				
				keyMap = resumo.cdPt;
				
				filtroBIEfiCicPCI.setCdPt(registro.cdPt);
			}

			
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_FERRAMENTA_ESTRUTURA) {
				registro.cdPt = (String) registroLido[_cdPt];
				registro.cdRap = (String) registroLido[_cdRap]; 
				
				resumo.cdPt = registro.cdPt;
				resumo.cdRap = registro.cdRap; 
				
				keyMap = resumo.cdPt + resumo.cdRap;
				
				filtroBIEfiCicPCI.setCdPt(registro.cdPt);
				filtroBIEfiCicPCI.setCdRap(registro.cdRap); 
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

		int _ano = 0;
		int _mes = 1;
		
		int _cdturno = 0;
		int _dsturno = 1;
				
		int _cdproduto = 0;
		int _dsproduto = 1;
		
		int _tmpprodrefugada = 0;
		
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_GERAL) {
			_tmpprodrefugada = 0;
		}
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA || 
			agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA ||
			agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO) {
			_tmpprodrefugada = 1;
		} 		
		
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_ANO_MES || 
			agrupamento == FiltroAgrupamentoBI.BI_TOTAL_TURNO ||
			agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_FERRAMENTA_ESTRUTURA) {
			_tmpprodrefugada = 2;
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
				registro.ano = String.valueOf(ConversaoTipos.converterParaBigDecimal(registroLido[_ano]).intValue());
				registro.mes = FuncoesApoioInjet.getStrZero(ConversaoTipos.converterParaBigDecimal(registroLido[_mes]).longValue(), 2);
				
				resumo.ano = registro.ano;
				resumo.mes = registro.mes;
				
				keyMap = (String) registro.ano + registro.mes; 
			}
			
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA) {
				registro.dtTurno = (Date) registroLido[_dtturno];
				
				resumo.dtTurno = registro.dtTurno;
				
				keyMap = DataHoraRN.toStringYYYYMMDD(resumo.dtTurno);				
			}

			
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA || agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO) {
				registro.cdPt = (String) registroLido[_cdPt];
				
				resumo.cdPt = registro.cdPt;
				
				keyMap = resumo.cdPt;
			}

			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_FERRAMENTA_ESTRUTURA) {
				registro.cdPt = (String) registroLido[_cdPt];
				registro.cdRap = (String) registroLido[_cdRap]; 
				
				resumo.cdPt = registro.cdPt;
				resumo.cdRap = registro.cdRap; 
				
				keyMap = resumo.cdPt + resumo.cdRap;
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
			
			if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_GERAL || 
				agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_FERRAMENTA_ESTRUTURA) {
				if (registro.indPerda.doubleValue() < 0d) {
					registro.indPerda = BigDecimal.ZERO;
					registro.indPerdaP = BigDecimal.ZERO;				
				}
			}
			
			//outros indicadores
			registro.tmpPerdas = new BigDecimal(FormulasInjet.calcularTotalPerdas(registro.tmpRitmo.doubleValue(), registro.tmpParadasCP.doubleValue(), registro.tmpProdRefugada.doubleValue(), registro.tmpCavidades.doubleValue()));
			registro.tmpTrabalhadas = FormulasInjet.calcularTempoTrabalhado(registro.tmpAtivo, registro.tmpParadasCP);
			registro.tmpProdutivas = FormulasInjet.calcularTempoProdutivas(registro.tmpCicFinParada, registro.tmpProdRefugada, registro.tmpCavidades, registro.tmpRitmo);
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
			Integer ami = (ConversaoTipos.converterParaBigDecimal(filtroBI.getAnoIni()).intValue() * 1000) + ConversaoTipos.converterParaBigDecimal(filtroBI.getMesIni()).intValue();
			Integer amf = (ConversaoTipos.converterParaBigDecimal(filtroBI.getAnoFim()).intValue() * 1000) + ConversaoTipos.converterParaBigDecimal(filtroBI.getMesFim()).intValue();				
			q.setParameter("ami", ami);
            q.setParameter("amf", amf);
            
		} else {
			q.setTimestamp("dthrini", filtroBI.getDtIniDt());
			q.setTimestamp("dthrfim", filtroBI.getDtFimDt());
		}
		

		if (!filtroBI.getCdTurno().equals("")) {
			q.setString("cdturno", filtroBI.getCdTurno());
		}
		
		if (!filtroBI.getCdPt().equals("")) {
			q.setString("cdpt", filtroBI.getCdPt());
		} 
		
		if (!filtroBI.getCdGt().equals("")) {
				q.setString("cdgt", filtroBI.getCdGt());
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
		
		
		List<String> listaOPs = null;
		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO) {
			// recupera lista de ops que devem ser filtradas
			listaOPs = getListaUltimasOPs(filtroBI.getDtIniDt(), filtroBI.getCdTurno(), filtroBI.getCdGt());
			q.setParameterList("lista", listaOPs);
		}
		
		
		return q;
	}


}
