package idw.model.rn.monitorizacao.detalhes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.OmCfg;
import idw.model.rn.AbstractRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.util.AritmeticaUtil;
import idw.util.Util;
import idw.webservices.dto.DetalhamentoRefugoDTO;
import idw.webservices.dto.DetalheRefugoDTO;

public class OcorrenciaParetoRefugoRN extends AbstractRN<DAOGenerico>  {

	static final int _cdrefugo = 0;
	static final int _dsrefugo = 1;
	static final int _cdacao = 2;
	static final int _dsacao = 3;
	static final int _cdcausa = 4;
	static final int _dscausa = 5;
	static final int _cdpt = 6;
	static final int _dspt = 7;
	static final int _cdfolha = 8;
	static final int _dthrocorrencia = 9;
	static final int _cdproduto = 10;
	static final int _dsproduto = 11;
	static final int _qtdrefauto = 12;
	static final int _qtdrefmanual = 13;
	static final int _folharap = 14;
	
	public OcorrenciaParetoRefugoRN() {
		super(new DAOGenerico());
	}
	
	public OcorrenciaParetoRefugoRN(DAOGenerico dao) {
		super(dao);
	}

	public DetalhamentoRefugoDTO getOcorrenciaParetoRefugoDTO(
			Date dtReferencia, 
			BigDecimal idTurno, 
			BigDecimal idPt, 
			String cdRefugo) {
		
		BigDecimal totalRefugado = BigDecimal.ZERO;
		
		DetalhamentoRefugoDTO retorno = new DetalhamentoRefugoDTO();
		List<DetalheRefugoDTO > listaRefugos = new ArrayList<DetalheRefugoDTO>();
		MapQuery q = new MapQuery(getDaoSession());

		q.append("select distinct");
		q.append("e.cdTrefugo,");
		q.append("e.dsTrefugo,");
		q.append("f.cdTacao,");
		q.append("f.dsTacao,");
		q.append("i.cdTcausa,");
		q.append("i.dsTcausa,");
		q.append("ompt.cdPt,");
		q.append("ompt.dsPt,");
		q.append("dwfolha.cdFolha,");
		q.append("g.dthrRefugo,");		
		q.append("p.cdProduto,");
		q.append("p.dsProduto,");		
		q.append("g.pcsAutoProducaorefugada,");
		q.append("g.pcsManuProducaorefugada,");
		q.append("fr");		
		q.append("from DwConsolreoco a");
		q.append("join a.dwConsolre b");
		q.append("join b.dwConsol c");
		q.append("join c.dwConsolid d");
		q.append("join b.dwTRefugo e");
		q.append("join a.dwConsolrelog g");
		q.append("join d.omPt ompt");
		q.append("join d.dwFolha dwfolha");
		q.append("join d.dwTurno dwturno");
		q.append("left join g.dwTAcao f");
		q.append("left join g.dwTCausa i");
		q.append("left join g.omProduto p");
		q.append("left join dwfolha.dwFolharaps fr");
		q.append("left join fetch fr.dwFolharapcoms rc"); 
		q.append("where d.dtReferencia = :dtreferencia");
		q.append("and d.dwTurno.idTurno = :idturno");
		q.append("and d.stAtivo is null");
		q.append("and d.tpId = 1");
		q.append("and ompt.idPt = :idpt");
		q.append("and (g.isCancelado = :iscancelado or g.isCancelado IS NULL)"); 
		
		if (cdRefugo != null && cdRefugo.equals("") == false) {
			q.append("and e.cdTrefugo = :cdrefugo");
			q.defineParametro("cdrefugo", cdRefugo);
		}

		q.defineParametro("iscancelado", false);
		q.defineParametro("dtreferencia", dtReferencia);
		q.defineParametro("idturno", idTurno.longValue());
		q.defineParametro("idpt", idPt.longValue());
		
		List<Object> lista = q.list();
		
		for (Object reg : lista) {
			Object[] registro = (Object[]) reg;
			
			DetalheRefugoDTO detalhe = new DetalheRefugoDTO();
			

			if (registro[_cdacao] != null)
			{
				detalhe.setAcao(registro[_cdacao] + "-" + registro[_dsacao]);
			}
			else
			{
				detalhe.setAcao("");
			}
			
			if (registro[_cdcausa] != null)
			{
				detalhe.setCausa(registro[_cdcausa] + "-" + registro[_dscausa]);
			}
			else
			{
				detalhe.setCausa("");
			}
			
			
			totalRefugado = BigDecimal.ZERO;
			if (registro[_qtdrefauto] != null)
			{
				totalRefugado = AritmeticaUtil.somar(totalRefugado, (BigDecimal) registro[_qtdrefauto]);
			}
			
			if (registro[_qtdrefmanual] != null)
			{
				totalRefugado = AritmeticaUtil.somar(totalRefugado, (BigDecimal) registro[_qtdrefmanual]);
			}

			detalhe.setQtde_refugo(totalRefugado.doubleValue());
			detalhe.setFerramenta(registro[_cdfolha].toString());
			detalhe.setMaquina(registro[_cdpt].toString());
			detalhe.setDsPt(registro[_dspt].toString());
			detalhe.setDthrocorrencia((Date) registro[_dthrocorrencia]);
			
			String produto = "";			
			if (registro[_cdproduto] !=  null)
			{
				detalhe.setProduto(registro[_cdproduto] + "-" + registro[_dsproduto]);
				produto = (String) registro[_cdproduto];
				produto = produto.trim();				
			}
			else
			{
				detalhe.setProduto("");
			}
			
			if (registro[_cdrefugo] != null)
			{
				detalhe.setRefugo(registro[_cdrefugo] + "-" + registro[_dsrefugo]);
			}
			else
			{
				detalhe.setRefugo("");
			}

			if (registro[_folharap] != null)
			{				
				DwFolharap fr = (DwFolharap) registro[_folharap];
				
				for (DwFolharapcom rc : fr.getDwFolharapcoms()) {
					if (rc.getOmProduto().getCdProduto().equals(produto)) {
						detalhe.setCdRap(fr.getDwRap().getCdRap());
						break;
					}
				}				
			} 
			else 
			{
				detalhe.setCdRap("");
			}
			
			listaRefugos.add(detalhe);
		}
		retorno.setQtdRefuga(totalRefugado);
		retorno.setListarefugos(listaRefugos);
		return retorno;
	}
	
	public DetalhamentoRefugoDTO getOcorrenciaParetoRefugoFichaMaqDTO(
			Byte tpId, 
			Date dtInicial,
			Date dtFinal,
			BigDecimal idTurno, 
			String cdPt, 
			String cdCp,
			String cdRefugo,
			String cdProduto) {
		
		DetalhamentoRefugoDTO retorno = new DetalhamentoRefugoDTO();
		List<DetalheRefugoDTO> listaRefugos = new ArrayList<DetalheRefugoDTO>();
		MapQuery q = new MapQuery(getDaoSession());

		BigDecimal qtdRefugada = BigDecimal.ZERO;
		
		q.append("select distinct");
		q.append("e.cdTrefugo,");
		q.append("e.dsTrefugo,");
		q.append("f.cdTacao,");
		q.append("f.dsTacao,");
		q.append("i.cdTcausa,");
		q.append("i.dsTcausa,");
		q.append("ompt.cdPt,");
		q.append("ompt.dsPt,");
		q.append("dwfolha.cdFolha,");
		q.append("g.dthrRefugo,");		
		q.append("p.cdProduto,");
		q.append("p.dsProduto,");		
		q.append("g.pcsAutoProducaorefugada,");
		q.append("g.pcsManuProducaorefugada,");
		q.append("dwfolha.idFolha");
		q.append("from DwConsolreoco a");
		q.append("join a.dwConsolre b");
		q.append("join b.dwConsol c");
		q.append("join c.dwConsolid d");
		q.append("join b.dwTRefugo e");
		q.append("join a.dwConsolrelog g");
		q.append("join d.omPt ompt");
		q.append("join d.dwFolha dwfolha");
		q.append("join d.dwTurno dwturno");
		q.append("left join g.dwTAcao f");
		q.append("left join g.dwTCausa i");
		q.append("left join g.omProduto p");
		
		// Alessandre em 20-06-17 removi os dois joins abaixo pois qdo tem 2 produtos as ocorrencias sao duplicadas
		// o select vai retornar apenas o idFolha pra eu pesquisar depois qual a ferramenta
		//q.append("left join dwfolha.dwFolharaps fr");
		//q.append("left join fetch fr.dwFolharapcoms rc");
		
		
		q.append("where d.stAtivo is null");
		q.append("and d.tpId = 1");
		q.append("and (g.isCancelado = :iscancelado or g.isCancelado IS NULL)"); 
		
		if (cdProduto != null && cdProduto.equals("") == false) {
			q.append("and p.cdProduto = :cdproduto");
		}
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
				q.append("AND dwturno.idTurno = :idturno");		
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
			q.append("AND d.ppCp.cdCp = :cdcp");
		}
		

		// filtro de refugo
		if (cdRefugo != null && cdRefugo.equals("") == false) 
		{
			q.append("and e.cdTrefugo = :cdrefugo");
		}
		
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
				
		if (cdRefugo != null && cdRefugo.equals("") == false) {
			q.defineParametro("cdrefugo", cdRefugo);
		}

		q.defineParametro("iscancelado", false);
		q.defineParametro("dtinicial", dtInicial);
		q.defineParametro("dtfinal", dtFinal);
		q.defineParametro("cdproduto", cdProduto);
		
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		q.defineParametro("idcalindefinido", omcfg.getDwCal().getIdCal());


		List<Object> lista = q.list();
		
		for (Object reg : lista) {
			Object[] registro = (Object[]) reg;
			
			DetalheRefugoDTO detalhe = new DetalheRefugoDTO();

			if (registro[_cdacao] != null)
			{
				detalhe.setAcao(registro[_cdacao] + "-" + registro[_dsacao]);
			}
			else
			{
				detalhe.setAcao("");
			}
			
			if (registro[_cdcausa] != null)
			{
				detalhe.setCausa(registro[_cdcausa] + "-" + registro[_dscausa]);
			}
			else
			{
				detalhe.setCausa("");
			}
			
			qtdRefugada = BigDecimal.ZERO;
			if (registro[_qtdrefauto] != null)
			{
				qtdRefugada = AritmeticaUtil.somar(qtdRefugada, (BigDecimal) registro[_qtdrefauto]);
			}
			
			if (registro[_qtdrefmanual] != null)
			{
				qtdRefugada = AritmeticaUtil.somar(qtdRefugada, (BigDecimal) registro[_qtdrefmanual]);
			}

			detalhe.setQtde_refugo(qtdRefugada.doubleValue());
			detalhe.setFerramenta(registro[_cdfolha].toString());
			detalhe.setMaquina(registro[_cdpt].toString());
			detalhe.setDsPt(registro[_dspt].toString());
			detalhe.setDthrocorrencia((Date) registro[_dthrocorrencia]);

			String produto = "";			
			if (registro[_cdproduto] !=  null)
			{
				detalhe.setProduto(registro[_cdproduto] + "-" + registro[_dsproduto]);
				produto = (String) registro[_cdproduto];
				produto = produto.trim();				
			}
			else
			{
				detalhe.setProduto("");
			}
			
			if (registro[_cdrefugo] != null)
			{
				detalhe.setRefugo(registro[_cdrefugo] + "-" + registro[_dsrefugo]);
			}
			else
			{
				detalhe.setRefugo("");
			}

			if (registro[_folharap] != null)
			{
				// Alessandre em 20-06-17 o select nao retorna mais dwfolharapcom mas somente o idFolha
				Long idFolha = (Long) registro[_folharap];
				FolhaRN rn = new FolhaRN(getDao());
				DwFolha dwfolha = rn.pesquisarFolhaPorID(idFolha);
				
				for (DwFolharap rap : dwfolha.getDwFolharaps()) {
					for (DwFolharapcom rc : rap.getDwFolharapcoms()) {
						if (rc.getOmProduto().getCdProduto().equals(produto)) {
							detalhe.setCdRap(rap.getDwRap().getCdRap());
							break;
						}
					}
				}
			} 
			else 
			{
				detalhe.setCdRap("");
			}
				
			
			listaRefugos.add(detalhe); 
		}
		
		retorno.setListarefugos(listaRefugos);
		return retorno;
	}
	
	public DetalhamentoRefugoDTO getOcorrenciaBIParetoRefugoDTO(
			Date dtInicial,
			Date dtFinal,
			BigDecimal idTurno, 
			BigDecimal idPt,
			BigDecimal idGt,
			BigDecimal qtTotalRefugada,
			String cdRefugo) {
		
		DetalhamentoRefugoDTO retorno = new DetalhamentoRefugoDTO();
		List<DetalheRefugoDTO> listaRefugos = new ArrayList<DetalheRefugoDTO>();
		MapQuery q = new MapQuery(getDaoSession());

		BigDecimal qtdRefugada = BigDecimal.ZERO;
		
		q.append("select distinct");
		q.append("e.cdTrefugo,");
		q.append("e.dsTrefugo,");
		q.append("f.cdTacao,");
		q.append("f.dsTacao,");
		q.append("i.cdTcausa,");
		q.append("i.dsTcausa,");
		q.append("ompt.cdPt,");
		q.append("ompt.dsPt,");
		q.append("dwfolha.cdFolha,");
		q.append("g.dthrRefugo,");		
		q.append("p.cdProduto,");
		q.append("p.dsProduto,");		
		q.append("g.pcsAutoProducaorefugada,");
		q.append("g.pcsManuProducaorefugada,");
		q.append("fr");
		q.append("from DwConsolreoco a");
		q.append("join a.dwConsolre b");
		q.append("join b.dwConsol c");
		q.append("join c.dwConsolid d");
		q.append("join b.dwTRefugo e");
		q.append("join a.dwConsolrelog g");
		q.append("join d.omPt ompt");
		q.append("join d.dwFolha dwfolha");
		q.append("join d.dwTurno dwturno");
		q.append("left join g.dwTAcao f");
		q.append("left join g.dwTCausa i");
		q.append("left join g.omProduto p");
		q.append("left join dwfolha.dwFolharaps fr");
		q.append("left join fetch fr.dwFolharapcoms rc");
		
		if (idGt != null && idGt.equals(BigDecimal.ZERO) == false) {
			q.append("left join ompt.omObjs omobj");
			q.append("left join omobj.omGtByIdGt omgt");
		}
		
		q.append("where d.dtReferencia between :dtinicial and :dtfinal");
		q.append("and d.stAtivo is null");
		q.append("and d.tpId = 1");
		q.append("and (g.isCancelado = :iscancelado or g.isCancelado IS NULL)"); 
		
		
		if (idTurno != null && idTurno.equals(BigDecimal.ZERO) == false) {
			q.append("and d.dwTurno.idTurno = :idturno");
		}
		
		if (idPt != null && idPt.equals(BigDecimal.ZERO) == false) {
			q.append("and ompt.idPt = :idpt");
		}
		
		if (idGt != null && idGt.equals(BigDecimal.ZERO) == false)
			q.append("and omgt.idGt = :idgt");

		
		if (cdRefugo != null && cdRefugo.equals("") == false) {
			q.append("and e.cdTrefugo = :cdrefugo");
			q.defineParametro("cdrefugo", cdRefugo);
		}

		q.defineParametro("dtinicial", dtInicial);
		q.defineParametro("dtfinal", dtFinal);
		q.defineParametro("iscancelado", false);
		
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		q.defineParametro("idcalindefinido", omcfg.getDwCal().getIdCal());

		if (idTurno != null  && idTurno.equals(BigDecimal.ZERO) == false)
			q.defineParametro("idturno", idTurno.longValue());
		
		if (idPt != null  && idPt.equals(BigDecimal.ZERO) == false)
			q.defineParametro("idpt", idPt.longValue());

		if (idGt != null && idGt.equals(BigDecimal.ZERO) == false)
			q.defineParametro("idgt", idGt.longValue());

		List<Object> lista = q.list();
		
		for (Object reg : lista) {
			Object[] registro = (Object[]) reg;
			
			DetalheRefugoDTO detalhe = new DetalheRefugoDTO();

			if (registro[_cdacao] != null)
			{
				detalhe.setAcao(registro[_cdacao] + "-" + registro[_dsacao]);
			}
			else
			{
				detalhe.setAcao("");
			}
			
			if (registro[_cdcausa] != null)
			{
				detalhe.setCausa(registro[_cdcausa] + "-" + registro[_dscausa]);
			}
			else
			{
				detalhe.setCausa("");
			}
			
			qtdRefugada = BigDecimal.ZERO;
			if (registro[_qtdrefauto] != null)
			{
				qtdRefugada = AritmeticaUtil.somar(qtdRefugada, (BigDecimal) registro[_qtdrefauto]);
			}
			
			if (registro[_qtdrefmanual] != null)
			{
				qtdRefugada = AritmeticaUtil.somar(qtdRefugada, (BigDecimal) registro[_qtdrefmanual]);
			}

			detalhe.setQtde_refugo(qtdRefugada.doubleValue());
			detalhe.setFerramenta(registro[_cdfolha].toString());
			detalhe.setMaquina(registro[_cdpt].toString());
			detalhe.setDsPt(registro[_dspt].toString());
			detalhe.setDthrocorrencia((Date) registro[_dthrocorrencia]);
			
			String produto = "";			
			if (registro[_cdproduto] !=  null)
			{
				detalhe.setProduto(registro[_cdproduto] + "-" + registro[_dsproduto]);
				produto = (String) registro[_cdproduto];
				produto = produto.trim();				
			}
			else
			{
				detalhe.setProduto("");
			}
			
			if (registro[_cdrefugo] != null)
			{
				detalhe.setRefugo(registro[_cdrefugo] + "-" + registro[_dsrefugo]);
			}
			else
			{
				detalhe.setRefugo("");
			}
			
			if (registro[_folharap] != null)
			{				
				DwFolharap fr = (DwFolharap) registro[_folharap];
				
				for (DwFolharapcom rc : fr.getDwFolharapcoms()) {
					if (rc.getOmProduto().getCdProduto().equals(produto)) {
						detalhe.setCdRap(fr.getDwRap().getCdRap());
						break;
					}
				}				
			} 
			else 
			{
				detalhe.setCdRap("");
			}			
			listaRefugos.add(detalhe); 
		}
		
		retorno.setListarefugos(listaRefugos);
		return retorno;
	}

}
