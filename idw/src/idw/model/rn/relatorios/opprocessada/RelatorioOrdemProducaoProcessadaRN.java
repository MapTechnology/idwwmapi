	package idw.model.rn.relatorios.opprocessada;

import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolid;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroRelatorioOPProcessadaDTO;

public class RelatorioOrdemProducaoProcessadaRN extends AbstractRN<DAOGenerico> {
	
	public RelatorioOrdemProducaoProcessadaRN() {
		super(new DAOGenerico());
	}
	
	public RelatorioOrdemProducaoProcessadaRN(DAOGenerico dao) {
		super(dao);
	}

	/*
	 * Metodo principal para retorno do relatorio por op
	 */
	public ListaRelatorioOPProcessadaDTO getRelatorioOPProcessada(FiltroRelatorioOPProcessadaDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioOrdemProducaoProcessadaRN.getRelatorioOPProcessada");
		log.info( idLog , 0, "RelatorioOrdemProducaoProcessadaRN.getRelatorioOPProcessada filtro usado:" + filtro.toString());
		
		ListaRelatorioOPProcessadaDTO retorno = new ListaRelatorioOPProcessadaDTO();
		List<DwConsolid> ids = this.consultaRelatorioOPProcessada(filtro);
		
		// Interage sobre a pesquisa para montagem do DTO de retorno
		for (DwConsolid id : ids) {
			// Determinar se agrupara por OP ou maquina
			RelatorioOrdemProducaoProcessadaDTO detalhesDoAgrupador = obtemAgrupadorOPouPosto(filtro, retorno, id);
			
			// obtem dados do detalhe do agrupador combase na OP e Posto
			RelatorioOrdemProducaoProcessadaDetalheDTO linha = obenLinhaDetalhe(id, detalhesDoAgrupador);
			
			// Soma a linha os dados necessarios ao relatorio
			GeraLinhaDetalhe gerador = new GeraLinhaDetalhe(linha, getDao());
			gerador.acumularNovosValoresDoBanco(id);
		}
		
		// Cria total do agrupador
		GeraTotalAgrupador tarn = new GeraTotalAgrupador();
		tarn.geraTotalAgrupador(retorno);
		
		
		// Cria total geral do relatorio a partir dos dados do agrupador
		GeraTotalGeral tgrn = new GeraTotalGeral();
		tgrn.geraTotalGeral(retorno);
		
		log.mostrarAvaliacaoCompleta();
		
		return retorno;
	}

	private RelatorioOrdemProducaoProcessadaDetalheDTO obenLinhaDetalhe(DwConsolid id, RelatorioOrdemProducaoProcessadaDTO detalhesDoAgrupador) {
		RelatorioOrdemProducaoProcessadaDetalheDTO linha;
		DeterminaDetalhe detalhe = new DeterminaDetalhe(id);
		if (detalhesDoAgrupador.getDetalhes().containsKey(detalhe)) {
			linha = detalhesDoAgrupador.getDetalhes().get(detalhe);
		} else {
			linha = new RelatorioOrdemProducaoProcessadaDetalheDTO();
			linha.setOp(id.getPpCp().getNrop());
			linha.setPosto(id.getOmPt().getCdPt());
			//Marcos Sardinha: 2017-09-14 >> Defeito #4340
			linha.setDtInicial(id.getDthrIturno());
			linha.setDtFinal(id.getDthrIturno());
			linha.setPeriodo(DataHoraRN.dateToStringDDMMYYYYHHMMSS(linha.getDtInicial()) + "\n" + DataHoraRN.dateToStringDDMMYYYYHHMMSS(linha.getDtFinal()));
			
			
			linha.setTempoCiclosProdutivos(0d);
			linha.setQtdCiclosProdutivos(0d);
			linha.setTempoCicloPadrao(0d);
			detalhesDoAgrupador.getDetalhes().put(detalhe, linha);
		}
		return linha;
	}

	private RelatorioOrdemProducaoProcessadaDTO obtemAgrupadorOPouPosto(FiltroRelatorioOPProcessadaDTO filtro, ListaRelatorioOPProcessadaDTO retorno, DwConsolid id) {
		DeterminaAgrupador agrupador = new DeterminaAgrupador(id, filtro);
		
		// Obtem detalhes do agrupador desejado
		RelatorioOrdemProducaoProcessadaDTO detalhesDoAgrupador;
		if (retorno.getAgrupamento().containsKey(agrupador)) {
			detalhesDoAgrupador = retorno.getAgrupamento().get(agrupador);
		} else {
			detalhesDoAgrupador = new RelatorioOrdemProducaoProcessadaDTO();
			retorno.getAgrupamento().put(agrupador, detalhesDoAgrupador);
		}
		return detalhesDoAgrupador;
	}

	private List<DwConsolid> consultaRelatorioOPProcessada(FiltroRelatorioOPProcessadaDTO filtro) {

		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwConsols consol");
		q.append("JOIN consolid.omPt pt");
		q.append("JOIN consolid.ppCp cp");
		q.append("JOIN cp.ppCpprodutos ppcpprodutos");
		q.append("JOIN consolid.dwFolha folha");
		q.append("left join pt.omObjs omobj");
		q.append("left JOIN folha.dwFolharaps folharap");
		q.append("left JOIN folharap.dwRap rap");
		q.append("LEFT JOIN rap.dwRapGrupos rapgrupo");
		q.append("LEFT JOIN rapgrupo.dwGrupoFerramenta gpferramenta");
		
		q.appendWhere(MapQuery._NULL, "consolid.tpId = :tpId", true);

		
		/* Alessandre em 08-08-17 comentei a linha abaixo e substitui pela seguintes para compatibilizar  o R039 com o 
		 * mapa das ops
		 * descomentei em 25-05-22 Alessandre para a producao ser de acordo com o periodo
		 */
		q.appendWhere(MapQuery._AND, "consolid.dtReferencia BETWEEN :dataincial and :datafinal", (filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null));

		// Define para 24h a hora final
		filtro.setPeriodoFinal(DataHoraRN.setHoraNaData(filtro.getPeriodoFinal(), 23, 59, 59, 999));

		// Alessandre comentei em 25-05-22 pois as ops serao as que tem dwconsolid
		// Alessandre chamado 7937 em 15-06-22 acredito q tambem resolva para esse chamado
//		q.appendWhere(MapQuery._AND, " ( (cp.dthrInicio BETWEEN :dataincial AND :datafinal) ", filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null);
//		q.appendWhere(MapQuery._OR,"   (cp.dthrFinal BETWEEN :dataincial AND :datafinal) ", filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null);
//		q.appendWhere(MapQuery._OR,"   (:dataincial BETWEEN cp.dthrInicio AND cp.dthrFinal) )", filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null);
//		q.appendWhere(MapQuery._AND,"   cp.dthrInicio IS NOT NULL", filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null);
//		q.appendWhere(MapQuery._AND,"   cp.dthrFinal  IS NOT NULL", filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null);


		//Marcos Sardinha: 2017-08-09 >> pega todo tipo de linha (inclusive regulagem)
		// q.appendWhere(MapQuery._AND, "consolid.stAtivo is null", true);
		
		
		q.appendWhere(MapQuery._AND, "consolid.dwTurno.idTurno <> 1", filtro.getTurnoDTO() == null);
		q.appendWhere(MapQuery._AND, "consolid.dwTurno.idTurno = :idturno", filtro.getTurnoDTO() != null);
		
		q.appendWhere(MapQuery._AND, "consolid.omPt.cdPt = :cdpt", filtro.getOmpt() != null);
		
		q.appendWhere(MapQuery._AND, "omobj.omGtByIdGt.idGt = :idGt", filtro.getOmpt() == null && filtro.getOmgt() != null);

		q.appendWhere(MapQuery._AND, "rap.idRap = :idrap", filtro.getDwRap() != null);
		
		q.appendWhere(MapQuery._AND, "gpferramenta.idGrupoFerramenta = :idGpRap", (filtro.getGrupoFerramenta() != null));
		
		q.appendWhere(MapQuery._AND, "ppcpprodutos.nrDoc = :cdCpOp", filtro.getCdop() != null);

		q.defineParametro("tpId", (byte) 1);
		q.defineParametroTimestamp("dataincial", filtro.getPeriodoInicial());

		if (filtro.getPeriodoFinal() != null) {
			q.defineParametroTimestamp("datafinal", DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));
		}
		if (filtro.getTurnoDTO() != null) {
			q.defineParametro("idturno", filtro.getTurnoDTO().getTurno().getIdTurno());
		}
		if (filtro.getOmgt() != null) {
			q.defineParametro("idGt", filtro.getOmgt().getIdGt());
		} else if (filtro.getOmpt() != null) {
			q.defineParametro("cdpt", filtro.getOmpt().getCdPt());
		}
		if (filtro.getGrupoFerramenta() != null) {
			q.defineParametro("idGpRap", filtro.getGrupoFerramenta().getIdGrupoFerramenta());
		} else if (filtro.getDwRap() != null) {
			q.defineParametro("idrap", filtro.getDwRap().getIdRap());
		} else if (filtro.getCdop() != null) {
			q.defineParametro("cdCpOp", filtro.getCdop());
		}

		List<DwConsolid> retorno = q.list();
		
		return retorno;
	}
}
