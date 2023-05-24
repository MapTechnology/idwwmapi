package idw.model.rn.monitorizacao.injet;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.SemCalendarioException;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.model.rn.injet.FuncoesApoioInjet;
import idw.util.AritmeticaUtil;
import idw.webservices.dto.DetalhamentoRefugoDTO;
import idw.webservices.dto.DetalheRefugoDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiFiltroDTO;
import ms.util.ConversaoTipos;

public class OcorrenciaParetoRefugoInjetRN  extends AbstractRN<DAOGenericoInjet>  {

	int _cdrefugo = 0;
	int _dsrefugo = _cdrefugo + 1;
	int _cdacao = _dsrefugo + 1;
	int _dsacao = _cdacao + 1;
	int _cdcausa = _dsacao + 1;
	int _dscausa = _cdcausa + 1;
	int _cdpt = _dscausa + 1;
	int _dspt = _cdpt + 1;
	int _cdfolha = _dspt + 1;
	int _cdestrutura = _cdfolha + 1;
	int _dthrocorrencia = _cdestrutura + 1;
	int _cdproduto = _dthrocorrencia + 1;
	int _dsproduto = _cdproduto + 1;
	int _qtdrefauto = _dsproduto + 1;

	class RegistroLido {
		String cdRefugo;
		String dsRefugo;
		String cdAcao;
		String dsAcao;
		String cdCausa;
		String dsCausa;
		String cdPt;
		String dsPt;
		String cdFolha;
		String cdEstrutura;
		Date dthrOcorrencia;
		String cdProduto;
		String dsProduto;
		BigDecimal qtdRefAuto = BigDecimal.ZERO;		
		BigDecimal qtdRefAutoGr = BigDecimal.ZERO;
	}
	
	
	public OcorrenciaParetoRefugoInjetRN() {
		super(new DAOGenericoInjet());
	}
	
	public OcorrenciaParetoRefugoInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}


	@SuppressWarnings({ "unchecked", "unused" })
	public DetalhamentoRefugoDTO getOcorrenciaParetoRefugoFichaMaqDTO(
			Byte tpId, 
			Date dtInicial,
			Date dtFinal,
			BigDecimal idTurno, 
			String cdPt, 
			String cdCp,
			String cdRefugo,
			String cdProduto) {

		int _dthrirefugo = 0;
		int _cdinjetora = _dthrirefugo + 1;
		int _cdinjestendido = _cdinjetora + 1;
		int _cdidentific = _cdinjestendido + 1;
		
		int _cdmolde = _cdidentific + 1;
		int _cdmolestendido = _cdmolde + 1;
		int _cdestrutura = _cdmolestendido + 1;
		int _dthrivalcic = _cdestrutura + 1;
		int _dthrivalestru =  _dthrivalcic + 1;
		
		int _nrop = _dthrivalestru + 1;
		int _nropexibicao = _nrop + 1;		
		
		int _cdrefugo = _nropexibicao + 1;
		int _dsrefugo = _cdrefugo + 1;
		int _cdarea = _dsrefugo + 1;
		int _dsarea = _cdarea + 1;
		
		int _cdacao = _dsarea + 1;
		int _dsacao = _cdacao + 1;
		int _cdcausa = _dsacao + 1;
		int _dscausa = _cdcausa + 1;
		
		int _cdidentificacao = _dscausa + 1;
		int _cdproduto = _cdidentificacao + 1;		
		int _dsproduto = _cdproduto + 1;
		
		int _qtdrefauto = _dsproduto + 1;
		int _qtdrefautoGr = _qtdrefauto + 1;

		
		Date dthrIniTur = null;
		Date dthrFimTur = null;
		String cdTurno = null;
		
		if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO)) {			
			// se for turno: tem que ter soh uma data e um turno especifico
			cdTurno = FuncoesApoioInjet.getStrZero(idTurno.longValue(), 6);
			
			try {
				dthrIniTur = FuncoesApoioInjet.calcularInicioTurno(getDao(), dtInicial, cdTurno);
				dthrFimTur = FuncoesApoioInjet.calcularFimTurno(getDao(), dtInicial,  cdTurno);
			} catch (SemCalendarioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
		}
		
		
		
		DetalhamentoRefugoDTO retorno = new DetalhamentoRefugoDTO();
		List<DetalheRefugoDTO> listaRefugos = new ArrayList<DetalheRefugoDTO>();

		BigDecimal qtdRefugada = BigDecimal.ZERO;
				
		
		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.dthrirefugo, a.cdinjetora, i.cdinjestendido, i.cdidentific, ");
		strSQL = strSQL.concat("       a.cdmolde, m.cdmolestendido, a.cdestrutura, a.dthrivalcic, a.dthrivalestru, ");
		strSQL = strSQL.concat("       a.nrop, rot.nropexibicao, ");
		strSQL = strSQL.concat("       a.cdrefugo, r.dsrefugo, r.cdarea, ar.dsarea, ");
		strSQL = strSQL.concat("       a.cdacoes, aco.dsacoes,  a.cdcausas, cau.dscausas, ");
		strSQL = strSQL.concat("       a.cdidentificacao, c.cdproduto, p.dsproduto, ");
		strSQL = strSQL.concat("       a.qtrefugada, (a.qtrefugada * c.pbrutomedio) as qtrefugadagr ");
		strSQL = strSQL.concat("  FROM ijrearef a ");
		strSQL = strSQL.concat("  JOIN ijtbref b ON (b.cdrefugo = a.cdrefugo) ");
		strSQL = strSQL.concat(
				"  JOIN ijmolpro c ON (c.cdmolde = a.cdmolde AND c.cdestrutura = a.cdestrutura AND c.dthrival = a.dthrivalestru AND c.cdidentificacao = a.cdidentificacao) ");
		strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol m ON (m.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijtbref r ON (r.cdrefugo = a.cdrefugo) ");
		strSQL = strSQL.concat("  JOIN ijtbpro p ON (p.cdproduto = c.cdproduto) ");
		strSQL = strSQL.concat(
				"  JOIN ijoproteiro rot ON (rot.nrop = a.nrop AND rot.cdinjetora = a.cdinjetora AND rot.cdmolde = a.cdmolde AND rot.cdestrutura = a.cdestrutura) ");
		strSQL = strSQL.concat("  LEFT JOIN ijareres ar ON (ar.cdarea = r.cdarea) ");
		strSQL = strSQL.concat("  LEFT JOIN ijtbaco aco ON (aco.cdacoes = a.cdacoes) ");
		strSQL = strSQL.concat("  LEFT JOIN ijtbcau cau ON (cau.cdcausas = a.cdcausas) ");
		strSQL = strSQL.concat(" WHERE (a.lcancelado = 0  OR a.lcancelado IS NULL)");
		
		// produto
		if (cdProduto != null && cdProduto != "") {
			strSQL = strSQL.concat("   AND c.cdproduto = :cdproduto ");
		}
		
		if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO)) {
			strSQL = strSQL.concat(" AND a.dthrirefugo BETWEEN :dthrini AND :dthrfim ");
		}
		
		if (!tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP))
		{
			// máquina
			if (!cdPt.equals("") && !cdPt.equals(null))
			{
				strSQL = strSQL.concat("   AND i.cdinjestendido = :cdinjetora ");
			}
		}
		
		// op
		if (!cdCp.equals("") && !cdCp.equals(null)) {
			strSQL = strSQL.concat("   AND a.nrop = :nrop ");
		}
		
		// filtro de refugo
		if (cdRefugo != null && cdRefugo.equals("") == false) 
		{
			strSQL = strSQL.concat("   AND a.cdrefugo = :cdrefugo");
		}
		
		strSQL = strSQL.concat(" ORDER BY a.dthrirefugo");

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);

		
		// definicao de parameros
		if (cdProduto != null && cdProduto != "") {
			q.setString("cdproduto", cdProduto);
		}		
		if (tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO)) {
			q.setTimestamp("dthrini", dthrIniTur);
			q.setTimestamp("dthrfim", dthrFimTur);
		}		
		if (!tpId.equals(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_OP))
		{
			q.setString("cdinjetora", cdPt);
		}		
		if (!cdCp.equals("") && !cdCp.equals(null)) {
			q.setString("nrop", cdCp);
		}		
		if (cdRefugo != null && cdRefugo.equals("") == false) 
		{
			q.setString("cdrefugo", cdRefugo);
		}
		
		
		List<Object> lista = new ArrayList<Object>();
		lista = q.list();

		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			
			registro.cdRefugo = (String) registroLido[_cdrefugo];
			registro.dsRefugo = (String) registroLido[_dsrefugo];

			if (registroLido[_cdacao] != null)
			{
				registro.cdAcao = (String) registroLido[_cdacao];
				registro.dsAcao = (String) registroLido[_dsacao];
			}
			
			if (registroLido[_cdcausa] != null)
			{
				registro.cdCausa = (String) registroLido[_cdcausa];
				registro.dsCausa = (String) registroLido[_dscausa];
			}
			
			
			registro.cdPt = (String) registroLido[_cdinjestendido];
			registro.dsPt = (String) registroLido[_cdidentific];
			registro.cdFolha = (String) registroLido[_cdmolestendido];
			registro.cdEstrutura = (String) registroLido[_cdestrutura];
			registro.dthrOcorrencia = (Date) registroLido[_dthrirefugo];
			registro.cdProduto = (String) registroLido[_cdproduto];
			registro.dsProduto = (String) registroLido[_dsproduto];
			registro.qtdRefAuto = ConfiguracoesInjetRN.converterParaUnidadeBasicaInjet(ConversaoTipos.converterParaBigDecimal(registroLido[_qtdrefauto]));

			
			DetalheRefugoDTO detalhe = new DetalheRefugoDTO();
			
			if (registroLido[_cdacao] != null)
			{
				detalhe.setAcao(registro.cdAcao + "-" + registro.dsAcao);
			}
			else
			{
				detalhe.setAcao("");
			}
			
			if (registroLido[_cdcausa] != null)
			{
				detalhe.setCausa(registro.cdCausa + "-" + registro.dsCausa);
			}
			else
			{
				detalhe.setCausa("");
			}
			
			qtdRefugada = BigDecimal.ZERO;
			qtdRefugada = AritmeticaUtil.somar(qtdRefugada, (BigDecimal) registro.qtdRefAuto);

			detalhe.setQtde_refugo(qtdRefugada.doubleValue());
			detalhe.setFerramenta(registro.cdFolha + "/" + registro.cdEstrutura);
			detalhe.setMaquina(registro.cdPt);
			detalhe.setDsPt(registro.dsPt);
			detalhe.setDthrocorrencia(registro.dthrOcorrencia);

			String produto = "";			
			detalhe.setProduto(registro.cdProduto + "-" + registro.dsProduto);
			produto = registro.cdProduto;
			produto = produto.trim();				
			
			detalhe.setRefugo(registro.cdRefugo + "-" + registro.dsRefugo);

			detalhe.setCdRap("");
			
			listaRefugos.add(detalhe); 			
		}


		Collections.sort(listaRefugos,
				new Comparator<DetalheRefugoDTO>() {
					@Override
					public int compare(final DetalheRefugoDTO o1,
							final DetalheRefugoDTO o2) {
						final DetalheRefugoDTO item1 = o1;
						final DetalheRefugoDTO item2 = o2;

						return (item1.getDthrocorrencia().compareTo(item2.getDthrocorrencia()));
					}
				});
		
		
		
		retorno.setListarefugos(listaRefugos);
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public DetalhamentoRefugoDTO getOcorrenciaBIParetoRefugoDTO(
			BiFiltroDTO filtroBI,
			String cdRefugo,
			BigDecimal qtTotalRefugada) {

		int _dthrirefugo = 0;
		int _cdinjetora = _dthrirefugo + 1;
		int _cdinjestendido = _cdinjetora + 1;
		int _cdidentific = _cdinjestendido + 1;
		
		int _cdmolde = _cdidentific + 1;
		int _cdmolestendido = _cdmolde + 1;
		int _cdestrutura = _cdmolestendido + 1;
		int _dthrivalcic = _cdestrutura + 1;
		int _dthrivalestru =  _dthrivalcic + 1;
		
		int _nrop = _dthrivalestru + 1;
		int _nropexibicao = _nrop + 1;		
		
		int _cdrefugo = _nropexibicao + 1;
		int _dsrefugo = _cdrefugo + 1;
		int _cdarea = _dsrefugo + 1;
		int _dsarea = _cdarea + 1;
		
		int _cdacao = _dsarea + 1;
		int _dsacao = _cdacao + 1;
		int _cdcausa = _dsacao + 1;
		int _dscausa = _cdcausa + 1;
		
		int _cdidentificacao = _dscausa + 1;
		int _cdproduto = _cdidentificacao + 1;		
		int _dsproduto = _cdproduto + 1;
		
		int _qtdrefauto = _dsproduto + 1;
		int _qtdrefautoGr = _qtdrefauto + 1;

			
		
		DetalhamentoRefugoDTO retorno = new DetalhamentoRefugoDTO();
		List<DetalheRefugoDTO> listaRefugos = new ArrayList<DetalheRefugoDTO>();

		BigDecimal qtdRefugada = BigDecimal.ZERO;
				
		
		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.dthrirefugo, a.cdinjetora, i.cdinjestendido, i.cdidentific, ");
		strSQL = strSQL.concat("       a.cdmolde, m.cdmolestendido, a.cdestrutura, a.dthrivalcic, a.dthrivalestru, ");
		strSQL = strSQL.concat("       a.nrop, rot.nropexibicao, ");
		strSQL = strSQL.concat("       a.cdrefugo, r.dsrefugo, r.cdarea, ar.dsarea, ");
		strSQL = strSQL.concat("       a.cdacoes, aco.dsacoes,  a.cdcausas, cau.dscausas, ");
		strSQL = strSQL.concat("       a.cdidentificacao, c.cdproduto, p.dsproduto, ");
		strSQL = strSQL.concat("       (a.qtrefugada / dc.divisorUB) as qtrefugada, ((a.qtrefugada / dc.divisorUB) * c.pbrutomedio) as qtrefugadagr ");
		strSQL = strSQL.concat("  FROM ijrearef a ");
		strSQL = strSQL.concat("  JOIN viewDivisorContagem dc ON (1=1) ");
		
		if (filtroBI.getCdTurno().equals("")) {
			strSQL = strSQL.concat("  JOIN ijcnsTurIniFim ht ON (ht.dtref BETWEEN :dtini AND :dtfim) ");
		} else {
			strSQL = strSQL.concat("  JOIN ijcnsTurIniFim ht ON (ht.dtref BETWEEN :dtini AND :dtfim AND ht.cdturno = :cdturno) ");
		}
		
		strSQL = strSQL.concat("  JOIN ijtbref b ON (b.cdrefugo = a.cdrefugo) ");
		strSQL = strSQL.concat(
				"  JOIN ijmolpro c ON (c.cdmolde = a.cdmolde AND c.cdestrutura = a.cdestrutura AND c.dthrival = a.dthrivalestru AND c.cdidentificacao = a.cdidentificacao) ");
		strSQL = strSQL.concat("  JOIN ijtbinj i ON (i.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  JOIN ijtbmol m ON (m.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  JOIN ijtbref r ON (r.cdrefugo = a.cdrefugo) ");
		strSQL = strSQL.concat("  JOIN ijtbpro p ON (p.cdproduto = c.cdproduto) ");
		strSQL = strSQL.concat(
				"  JOIN ijoproteiro rot ON (rot.nrop = a.nrop AND rot.cdinjetora = a.cdinjetora AND rot.cdmolde = a.cdmolde AND rot.cdestrutura = a.cdestrutura) ");
		strSQL = strSQL.concat("  LEFT JOIN ijareres ar ON (ar.cdarea = r.cdarea) ");
		strSQL = strSQL.concat("  LEFT JOIN ijtbaco aco ON (aco.cdacoes = a.cdacoes) ");
		strSQL = strSQL.concat("  LEFT JOIN ijtbcau cau ON (cau.cdcausas = a.cdcausas) ");
		
		// tabelas relacionadas a grupo de maquina
		if (!filtroBI.getCdGt().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetinj gm ON (gm.cdinjetora = a.cdinjetora) ");		
		} else {
			if (!filtroBI.getCdClasseMaquina().equals("")) {
				strSQL = strSQL.concat("  LEFT JOIN ijtbinjclassABC cm ON (cm.cdinjetora = maq.cdinjetora) ");
			}
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  JOIN ijgrpdetmol gf ON (gf.cdmolde = a.cdmolde) ");	
		}
		
		
		strSQL = strSQL.concat(" WHERE (a.lcancelado = 0  OR a.lcancelado IS NULL)");
		strSQL = strSQL.concat("   AND a.dthrirefugo BETWEEN  ht.dthrini AND ht.dthrfim ");
		
		
		// máquina
		if (!filtroBI.getCdPt().equals("")) {
			strSQL = strSQL.concat("  AND i.cdinjestendido = :cdpt ");	
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				strSQL = strSQL.concat("  AND gm.cdgrpinj = :cdgt ");		
			} else {			
				strSQL = strSQL.concat("  AND h.classe = :cdclasse ");
			}
		}

		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			strSQL = strSQL.concat("  AND m.cdmolestendido = :cdrap ");	
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			strSQL = strSQL.concat("  AND gf.cdgrpmol = :cdgrprap ");	
		}
		
		// produto
		if (! filtroBI.getCdProduto().equals("")) {
			strSQL = strSQL.concat("   AND c.cdproduto = :cdproduto ");
		}
		
		
		// filtro de refugo
		if (!cdRefugo.equals("")) 
		{
			strSQL = strSQL.concat("   AND a.cdrefugo = :cdrefugo");
		}
		
		strSQL = strSQL.concat(" ORDER BY a.dthrirefugo");

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);


		// filtros 
		
		// máquina
		if (! filtroBI.getCdPt().equals("")) {
			q.setString("cdinjetora", filtroBI.getCdPt());
		} else {
			if (!filtroBI.getCdGt().equals("")) {
				q.setString("cdgt", filtroBI.getCdGt());
			} else {			
				q.setString("cdclasse", filtroBI.getCdClasseMaquina());
			}
		}


		// produto
		if (!filtroBI.getCdProduto().equals("")) {
			q.setString("cdproduto", filtroBI.getCdProduto());
		}

		// periodo
		q.setTimestamp("dtini", filtroBI.getDtIniDt());
		q.setTimestamp("dtfim", filtroBI.getDtFimDt());
		
		// turno
		if (!filtroBI.getCdTurno().equals("")) {
			q.setString("cdturno", filtroBI.getCdTurno());
		}

		
		// tabela relacionados a ferramenta
		if (!filtroBI.getCdRap().equals("")) {
			q.setString("cdrap", filtroBI.getCdRap());
		}
		
		// tabela relacionado a grupo de ferramenta
		if (!filtroBI.getCdGrpRap().equals("")) {
			q.setString("cdgrprap", filtroBI.getCdGrpRap());
		}

		
		if (! cdRefugo.equals("")) 
		{
			q.setString("cdrefugo", cdRefugo);
		}
		
		
		List<Object> lista = new ArrayList<Object>();
		lista = q.list();

		for (Object reg : lista) {
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			
			registro.cdRefugo = (String) registroLido[_cdrefugo];
			registro.dsRefugo = (String) registroLido[_dsrefugo];

			if (registroLido[_cdacao] != null)
			{
				registro.cdAcao = (String) registroLido[_cdacao];
				registro.dsAcao = (String) registroLido[_dsacao];
			}
			
			if (registroLido[_cdcausa] != null)
			{
				registro.cdCausa = (String) registroLido[_cdcausa];
				registro.dsCausa = (String) registroLido[_dscausa];
			}
			
			
			registro.cdPt = (String) registroLido[_cdinjestendido];
			registro.dsPt = (String) registroLido[_cdidentific];
			registro.cdFolha = (String) registroLido[_cdmolestendido];
			registro.cdEstrutura = (String) registroLido[_cdestrutura];
			registro.dthrOcorrencia = (Date) registroLido[_dthrirefugo];
			registro.cdProduto = (String) registroLido[_cdproduto];
			registro.dsProduto = (String) registroLido[_dsproduto];
			registro.qtdRefAuto = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdrefauto]);
			registro.qtdRefAutoGr = ConversaoTipos.converterParaBigDecimal(registroLido[_qtdrefautoGr]);

			
			DetalheRefugoDTO detalhe = new DetalheRefugoDTO();
			
			if (registroLido[_cdacao] != null)
			{
				detalhe.setAcao(registro.cdAcao + "-" + registro.dsAcao);
			}
			else
			{
				detalhe.setAcao("");
			}
			
			if (registroLido[_cdcausa] != null)
			{
				detalhe.setCausa(registro.cdCausa + "-" + registro.dsCausa);
			}
			else
			{
				detalhe.setCausa("");
			}
			
			qtdRefugada = BigDecimal.ZERO;
			qtdRefugada = AritmeticaUtil.somar(qtdRefugada, (BigDecimal) registro.qtdRefAuto);

			detalhe.setQtde_refugo(qtdRefugada.doubleValue());
			detalhe.setFerramenta(registro.cdFolha + "/" + registro.cdEstrutura);
			detalhe.setMaquina(registro.cdPt);
			detalhe.setDsPt(registro.dsPt);
			detalhe.setDthrocorrencia(registro.dthrOcorrencia);

			String produto = "";			
			detalhe.setProduto(registro.cdProduto + "-" + registro.dsProduto);
			produto = registro.cdProduto;
			produto = produto.trim();				
			
			detalhe.setRefugo(registro.cdRefugo + "-" + registro.dsRefugo);

			detalhe.setCdRap("");
			
			listaRefugos.add(detalhe); 			
		}


		Collections.sort(listaRefugos,
				new Comparator<DetalheRefugoDTO>() {
					@Override
					public int compare(final DetalheRefugoDTO o1,
							final DetalheRefugoDTO o2) {
						final DetalheRefugoDTO item1 = o1;
						final DetalheRefugoDTO item2 = o2;

						return (item1.getDthrocorrencia().compareTo(item2.getDthrocorrencia()));
					}
				});
		
		
		
		retorno.setListarefugos(listaRefugos);
		return retorno;
	}

}
