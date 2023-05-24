package idw.model.rn.relatorios.R100;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.FolhaRN;
import idw.util.IdwLogger;

public class RelatorioR100RN extends AbstractRN<DAOGenerico>{

	public RelatorioR100RN() {
		super(new DAOGenerico());
	}
	
	public RelatorioR100RN(DAOGenerico dao) {
		super(dao);
	}
	
	/* Metodo principal para montagem do relatorio R100
	 * 
	 */
	public RelatorioR100DTO getRelatorioR100DTO(FiltroR100DTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorionR100RN.getRelatorioR100DTO");
		log.info( idLog , 0, "RelatorionR100RN.getRelatorioR100DTO filtro usado:" + filtro.toString());
		
		RelatorioR100DTO retorno = new RelatorioR100DTO();
		
		List<DwConsolid> ids = pesquisarIds(filtro);
		FolhaRN rn = new FolhaRN(getDao());
		
		for (DwConsolid id : ids) {
			retorno.addId(id, rn);
		}
		
		retorno.limpaLinhasComProducaoZerada();
		// Se a qtde de parada for diferente de zero, entao filtrar apenas as maiores paradas na quantidade desejada
		if (filtro.getQtParadas() != null && filtro.getQtParadas() > 0) {
			retorno = filtrarParadas(retorno, filtro);
		}
		
		// Finalizar o relatorio deixando apenas os pts que apontam producao para o GT. Se o PT não tiver produção
		// então utilizar o PT anterior, até ter algum com produção
		retorno = finalizarRelatorio(retorno);
		
		log.mostrarAvaliacaoCompleta();
		return retorno;
	}
	
	// Finalizar o relatorio deixando apenas os pts que apontam producao para o GT. Se o PT não tiver produção
	// então utilizar o PT anterior, até ter algum com produção
	private RelatorioR100DTO finalizarRelatorio(RelatorioR100DTO dto) {
		RelatorioR100DTO retorno = new RelatorioR100DTO();
		
		retorno = dto;
		
		return retorno;
	}
	
	
	private RelatorioR100DTO filtrarParadas(RelatorioR100DTO dto, FiltroR100DTO filtro) {
		for (LinhaDetalheR100DTO linha : dto.getLinhas()) {
			Collections.sort(linha.getParadas(), new Comparator<ParadasR100DTO>() {
				@Override
				public int compare(ParadasR100DTO o1, ParadasR100DTO o2) {
					return o1.getTempoParada().compareTo(o2.getTempoParada()) *-1;
				}
			});
			
			Iterator<ParadasR100DTO> iparada = linha.getParadas().iterator();
			int contadorParadasNoRange = 0;
			while (iparada.hasNext()) {
				iparada.next();
				contadorParadasNoRange++;
				if (contadorParadasNoRange > filtro.getQtParadas())
					iparada.remove();
			}
			
			// Interir o total da parada
			ParadasR100DTO total = new ParadasR100DTO();
			total.setCdParada("");
			total.setDsParada("TOTAL PARADA");
			total.setTempoParada(linha.getTotalParada());
			total.setTempoParadaFormatada(linha.getTotalParadaFormatada());
			linha.getParadas().add(total);
		}
		
		return dto;
	}
	
	private List<DwConsolid> pesquisarIds(FiltroR100DTO filtro) {
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from DwConsolid a");
		q.append("join fetch a.dwConsols b");
		q.append("join fetch a.dwTurno c");
		q.append("join fetch a.omPt d");
		q.append("join fetch d.omGt e");
		q.appendWhere(MapQuery._NULL,"a.dtReferencia between :dti and :dtf", true);
		q.appendWhere(MapQuery._AND, "d.stAtivo = 1", true);
		q.appendWhere(MapQuery._AND, "a.stAtivo is null", true);
		q.appendWhere(MapQuery._AND, "a.tpId = :tpid", true);
		q.appendWhere(MapQuery._AND, "d.isApongt = :isapongt", true);
		
		/* Para cada GT filtrar turnos especificos, conforme definicao feita na GUI
		 * 		q.appendWhere(MapQuery._AND, "c.cdTurno = :cdturno", filtro.isTodosOsTurno() == false);
		q.appendWhere(MapQuery._AND, "c.idTurno <> 1", filtro.isTodosOsTurno());
		q.appendWhere(MapQuery._AND, "e.cdGt in (:gts)", true);

		 */
		boolean isPrimeiroGt = true;
		for (GtR100DTO gt : filtro.getListaCdGt()) {
			// Se nenhum turno foi definido entao pegar proximo gt
			if (gt.getCdTurno().isEmpty())
				continue;
			
			if (isPrimeiroGt)
				q.append(" and ( (");
			else
				q.append(") or (");
			
			
			isPrimeiroGt = false;
			
			q.append("e.cdGt = '" + gt.getCdGt() + "' and (");
			boolean isPrimeiraVez = true;
			for (String cdturno : gt.getCdTurno()) {
				if (isPrimeiraVez == false)
					q.append(" or ");
				q.append("c.cdTurno = '" + cdturno + "'");
				isPrimeiraVez = false;
			}
			q.append(")");
			
		}
		q.append(") ) ");
		
		q.append("order by a.dwTurno.idTurno");
		
		q.defineParametro("isapongt", true);
		q.defineParametro("tpid", DwConsolidTemplate.TpId.TURNO.getValue());
		q.defineParametroData("dti", filtro.getDtIReferencia());
		q.defineParametroData("dtf", filtro.getDtFReferencia());

		List<DwConsolid> retorno = q.list();
		
		return retorno;
	}
	
	

}
