package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.webservices.dto.ConjuntoDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.GrupoFerramentaDTO;
import idw.webservices.dto.GruposFerramentaDTO;
import idw.webservices.dto.ItemConjuntoDTO;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.dto.ProdutosDTO;

public class FiltrosParaBIRN extends AbstractRN<DAOGenerico> {
	public FiltrosParaBIRN() {
		super(new DAOGenerico());
	}
	
	public FiltrosParaBIRN(DAOGenerico dao) {
		super(dao);
	}


	public ConjuntoDTO getItensConjuntoProduto(String cdProduto)
	{
		ConjuntoDTO retorno = new ConjuntoDTO();
		ItemConjuntoDTO itemConjunto = new ItemConjuntoDTO();
		
		
		final int _cdProduto = 0;
		final int _dsProduto = 1;
		final int _qtde = 2;

		// inicializa lista
		retorno.setListaItensConjunto(new ArrayList<ItemConjuntoDTO>());

		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("SELECT DISTINCT filho.cdProduto, filho.dsProduto, est.qtUsada");
		q.append("FROM OmProcomest est");
		q.append("JOIN est.omProdutoByIdProduto pai");
		q.append("JOIN est.omProdutoByIdProdutomp filho");
		q.append("WHERE pai.cdProduto = :cdproduto");
		
		q.defineParametro("cdproduto", cdProduto);
		
		List<Object> lista = q.list();

		for (Object reg : lista) 
		{
			Object[] registro = (Object[]) reg;
			String cdProdutoFilho = (String) registro[_cdProduto];
			String dsProdutoDsFilho = (String) registro[_dsProduto];
			BigDecimal qtdUsada = (BigDecimal) registro[_qtde];
			
			itemConjunto = new ItemConjuntoDTO();
			itemConjunto.setCdProduto(cdProdutoFilho);
			itemConjunto.setDsProduto(dsProdutoDsFilho);
			itemConjunto.setQtde(qtdUsada);
			
			retorno.getListaItensConjunto().add(itemConjunto);
		}
		
		return retorno;
	}
	

	public GruposFerramentaDTO getGruposFerramenta() {
		
		GruposFerramentaDTO retorno = new GruposFerramentaDTO();

		// inicializa lista
		retorno.setListaGruposFerramenta(new ArrayList<GrupoFerramentaDTO>()); 

		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT grp");
		q.append("FROM DwGrupoFerramenta grp");
		q.append("WHERE grp.stAtivo = 1");
		q.append("ORDER BY grp.cdGrupoFerramenta");
		
		List<DwGrupoFerramenta> lista = q.list();
		for(DwGrupoFerramenta reg : lista) {
			GrupoFerramentaDTO item = new GrupoFerramentaDTO();
			item.setDwGrupoFerramenta(reg.clone(false));
			retorno.getListaGruposFerramenta().add(item);
		}
		
		return retorno;
	}
	
	/*
	 * Método que retorna a lista de produtos fabricados no período
	 */
	public ProdutosDTO getListaProdutosPeriodoBI(FiltroDetalhePTInjetDTO filtro) 
	{
		ProdutosDTO retorno = null;
		
		final int _cdProduto = 0;
		final int _dsProduto = 1;
		
		try {
			MapQuery query = new MapQuery(getDao().getSession());
 
			query.append("SELECT DISTINCT pro.cdProduto, pro.dsProduto");
			query.append("FROM DwConsolid dwci");
			query.append("JOIN dwci.dwConsols dwc");
			query.append("JOIN dwc.dwConsolprs dwcpr");
			query.append("JOIN dwcpr.omProduto pro");
			
			// filtro de ferramenta ou grupo de ferramenta
			if ( (filtro.getCdGrupoFerramenta() != null) || (filtro.getDwRap() != null))
			{
				query.append("JOIN dwci.dwFolha folha");
				query.append("JOIN folha.dwFolharaps raps");
				
				if (filtro.getCdGrupoFerramenta() != null)
				{
					query.append("JOIN raps.dwRap.dwRapGrupos grpmol");
				}
			}
			
			query.appendWhere(MapQuery._NULL, "dwci.tpId = 1 and dwci.stAtivo is null ", true);
			
			// filtro de período
			query.appendWhere(MapQuery._AND,"((dwci.ano * 1000) + dwci.mes) BETWEEN :ami AND :amf", filtro.getAnoInicial() != null);
			query.appendWhere(MapQuery._AND, "dwci.dtReferencia BETWEEN :dti AND :dtf", filtro.getAnoInicial() == null);
			query.appendWhere(MapQuery._AND, "dwci.dwTurno.idTurno = :idTurno", filtro.getDwTurno() != null);
			query.appendWhere(MapQuery._AND, "dwci.dwTurno.idTurno <> 1", filtro.getDwTurno() == null);

			// filtro de máq, grp máq, mol ou grp mol
			query.appendWhere(MapQuery._AND, "dwci.omPt.cdPt = :ompt", filtro.getOmPt() != null);
			query.appendWhere(MapQuery._AND, "exists (select ompt from OmPt ompt join ompt.omObjs omobj where omobj.omGtByIdGt.idGt = :idGt and ompt = dwci.omPt)", filtro.getOmGt() != null);
			query.appendWhere(MapQuery._AND, "raps.dwRap.cdRap = :cdmol", (filtro.getDwRap() != null));
			query.appendWhere(MapQuery._AND, "grpmol.dwGrupoFerramenta.cdGrupoFerramenta = :cdgrpmol", (filtro.getCdGrupoFerramenta() != null));
			
			
			query.append("ORDER BY pro.cdProduto, pro.dsProduto");

			// preenchimento dos parametros

			if (filtro.getAnoInicial() != null) 
			{
				query.defineParametro("ami", (filtro.getAnoInicial() * 1000) + filtro.getMesInicial());
				query.defineParametro("amf", (filtro.getAnoFinal() * 1000) + filtro.getMesFinal());
			}
			else
			{
				query.defineParametroData("dti", filtro.getDtReferenciaInicial() != null ? DataHoraRN.getDataSemHora(filtro.getDtReferenciaInicial()) : null); 
				query.defineParametroData("dtf",filtro.getDtReferenciaFinal() != null ? DataHoraRN.getDataSemHora(filtro.getDtReferenciaFinal()) : null); 				
			}
			
			query.defineParametro("idTurno", filtro.getDwTurno() != null ? filtro.getDwTurno().getIdTurno() : 0);
			
			if (filtro.getOmPt() != null && filtro.getOmPt().getCdPt() == null) 
			{
				OmPt ompt = getDao().findById(OmPt.class, filtro.getOmPt().getIdPt(), false);
				filtro.getOmPt().setCdPt(ompt.getCdPt());
			}
			
			if (filtro.getOmPt() != null)
			{
				query.defineParametro("ompt", filtro.getOmPt().getCdPt());
			}

			if (filtro.getDwRap() != null)
			{
				query.defineParametro("cdmol", filtro.getDwRap().getCdRap());
			}
			
			if (filtro.getCdGrupoFerramenta() != null)
			{
				query.defineParametro("cdgrpmol", filtro.getCdGrupoFerramenta());
			}
			
			
			query.defineParametro("idGt", filtro.getOmGt() != null ? filtro.getOmGt().getIdGt() : null); // grupo de máquinas


			List<Object> lista = query.list();
			retorno = new ProdutosDTO();
			retorno.setProdutos(new ArrayList<ProdutoDTO>());
			for (Object reg : lista) 
			{
				Object[] registro = (Object[]) reg;
				String cdProduto = (String) registro[_cdProduto];
				String dsProduto = (String) registro[_dsProduto]; 
				
				ProdutoDTO produto = new ProdutoDTO(); 
				produto.setProduto(new OmProduto());
				produto.getProduto().setCdProduto(cdProduto);
				produto.getProduto().setDsProduto(dsProduto);
				
				retorno.getProdutos().add(produto);
			}
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			retorno = new ProdutosDTO();
		}
		
		
		return retorno;
	}

	/*
	 * Método que retorna a lista de conjuntos (produtos-pai) fabricados no período
	 */
	public ProdutosDTO getListaConjuntosPeriodoBI(FiltroDetalhePTInjetDTO filtro) 
	{
		ProdutosDTO retorno = null;
		
		final int _cdProduto = 0;
		final int _dsProduto = 1;
		
		try {
			MapQuery query = new MapQuery(getDao().getSession());
 
 
			query.append("SELECT DISTINCT propai.omProdutoByIdProduto.cdProduto, propai.omProdutoByIdProduto.dsProduto ");
			query.append("FROM DwConsolid dwci");
			query.append("JOIN dwci.dwConsols dwc");
			query.append("JOIN dwc.dwConsolprs dwcpr");
			query.append("JOIN dwcpr.omProduto pro");
			query.append("JOIN pro.omProcomestsForIdProdutomp propai");
			query.append("join propai.omProdutoByIdProduto produtopai");
			
			// filtro de ferramenta ou grupo de ferramenta
			if ( (filtro.getCdGrupoFerramenta() != null) || (filtro.getDwRap() != null))
			{
				query.append("JOIN dwci.dwFolha folha");
				query.append("JOIN folha.dwFolharaps raps");
				
				if (filtro.getCdGrupoFerramenta() != null)
				{
					query.append("JOIN raps.dwRap.dwRapGrupos grpmol");
				}
			}
									
			query.appendWhere(MapQuery._NULL, "dwci.tpId = 1 and dwci.stAtivo is null ", true);
			
			// O Conjunto sao os produtos do tipo AGRUPADOR (fantasma)
			query.appendWhere(MapQuery._AND, "produtopai.tpProduto = :tpAgrupador", true);
			
			// filtro de período
			query.appendWhere(MapQuery._AND,"((dwci.ano * 1000) + dwci.mes) BETWEEN :ami AND :amf", filtro.getAnoInicial() != null);
			query.appendWhere(MapQuery._AND, "dwci.dtReferencia BETWEEN :dti AND :dtf", filtro.getAnoInicial() == null);
			query.appendWhere(MapQuery._AND, "dwci.dwTurno.idTurno = :idTurno", filtro.getDwTurno() != null);
			query.appendWhere(MapQuery._AND, "dwci.dwTurno.idTurno <> 1", filtro.getDwTurno() == null);

			// filtro de máq, grp máq, mol ou grp mol
			query.appendWhere(MapQuery._AND, "dwci.omPt.cdPt = :ompt", filtro.getOmPt() != null);
			query.appendWhere(MapQuery._AND, "exists (select ompt from OmPt ompt join ompt.omObjs omobj where omobj.omGtByIdGt.idGt = :idGt and ompt = dwci.omPt)", filtro.getOmGt() != null);
			query.appendWhere(MapQuery._AND, "raps.dwRap.cdRap = :cdmol", (filtro.getDwRap() != null));
			query.appendWhere(MapQuery._AND, "grpmol.dwGrupoFerramenta.cdGrupoFerramenta = :cdgrpmol", (filtro.getCdGrupoFerramenta() != null));
			

			query.append("ORDER BY propai.omProdutoByIdProduto.cdProduto, propai.omProdutoByIdProduto.dsProduto");

			query.defineParametro("tpAgrupador", OmProdutoTemplate.TpProduto.AGRUPADOR.getId());
			// preenchimento dos parametros

			if (filtro.getAnoInicial() != null) 
			{
				query.defineParametro("ami", (filtro.getAnoInicial() * 1000) + filtro.getMesInicial());
				query.defineParametro("amf", (filtro.getAnoFinal() * 1000) + filtro.getMesFinal());
			}
			else
			{
				query.defineParametroData("dti", filtro.getDtReferenciaInicial() != null ? DataHoraRN.getDataSemHora(filtro.getDtReferenciaInicial()) : null); 
				query.defineParametroData("dtf",filtro.getDtReferenciaFinal() != null ? DataHoraRN.getDataSemHora(filtro.getDtReferenciaFinal()) : null); 				
			}
			
			query.defineParametro("idTurno", filtro.getDwTurno() != null ? filtro.getDwTurno().getIdTurno() : 0);
			
			if (filtro.getOmPt() != null && filtro.getOmPt().getCdPt() == null) 
			{
				OmPt ompt = getDao().findById(OmPt.class, filtro.getOmPt().getIdPt(), false);
				filtro.getOmPt().setCdPt(ompt.getCdPt());
			}
			
			if (filtro.getOmPt() != null)
			{
				query.defineParametro("ompt", filtro.getOmPt().getCdPt());
			}

			if (filtro.getDwRap() != null)
			{
				query.defineParametro("cdmol", filtro.getDwRap().getCdRap());
			}
			
			if (filtro.getCdGrupoFerramenta() != null)
			{
				query.defineParametro("cdgrpmol", filtro.getCdGrupoFerramenta());
			}
			
			
			query.defineParametro("idGt", filtro.getOmGt() != null ? filtro.getOmGt().getIdGt() : null); // grupo de máquinas


			List<Object> lista = query.list();
			retorno = new ProdutosDTO();
			retorno.setProdutos(new ArrayList<ProdutoDTO>());
			for (Object reg : lista) 
			{
				Object[] registro = (Object[]) reg;
				String cdProduto = (String) registro[_cdProduto];
				String dsProduto = (String) registro[_dsProduto]; 
				
				ProdutoDTO produto = new ProdutoDTO(); 
				produto.setProduto(new OmProduto());
				produto.getProduto().setCdProduto(cdProduto);
				produto.getProduto().setDsProduto(dsProduto);
				
				retorno.getProdutos().add(produto);
			}
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			retorno = new ProdutosDTO();
		}
		
		
		return retorno;
	}

}
