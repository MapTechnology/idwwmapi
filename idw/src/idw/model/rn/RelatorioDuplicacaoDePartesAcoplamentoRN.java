package idw.model.rn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwPassmon;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroRelatorioDuplicacaoDePartesAcoplamentoDTO;
import idw.webservices.dto.ListaRelatorioDuplicacaoDePartesAcoplamentoDTO;
import idw.webservices.dto.RelatorioDuplicacaoDePartesAcoplamentoDTO;

public class RelatorioDuplicacaoDePartesAcoplamentoRN extends AbstractRN<DAOGenerico> {

	public RelatorioDuplicacaoDePartesAcoplamentoRN() {
		this(null);
	}

	public RelatorioDuplicacaoDePartesAcoplamentoRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	/* Metodo principal para geracao do relatorio */
	public ListaRelatorioDuplicacaoDePartesAcoplamentoDTO getListaRelatorioDuplicacaoDePartesAcoplamentoDTO(FiltroRelatorioDuplicacaoDePartesAcoplamentoDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioDuplicacaoDePartesAcoplamentoRN.getListaRelatorioDuplicacaoDePartesAcoplamentoDTO");
		log.info( idLog , 0, "RelatorioDuplicacaoDePartesAcoplamentoRN.getListaRelatorioDuplicacaoDePartesAcoplamentoDTO filtro usado:" + filtro.toString());
		
		List<DwPassmon> resultadoConsulta = consultaRelatorioDuplicacaoDePartesAcoplamentoRN(filtro);
		
		Comparator<DwPassmon> comparator = new Comparator<DwPassmon>() {
			@Override
			public int compare(DwPassmon o1, DwPassmon o2) {
				if(o1.getDwPassagem() != null && o2.getDwPassagem() != null) {
					return DataHoraRN.compareTo(o1.getDwPassagem().getDthr(), o2.getDwPassagem().getDthr());
				}
				return 0;
			}
		};
		
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwPassmon a");
		q.append("join a.dwPassagem b");
		q.append("join b.dwNserie c");
		q.append("where a.cb = :cb");
		q.append("and a.idPassmon <> :idPassmon");
		
		Collections.sort(resultadoConsulta, comparator);
		
		ListaRelatorioDuplicacaoDePartesAcoplamentoDTO retorno = new ListaRelatorioDuplicacaoDePartesAcoplamentoDTO();

		retorno.setDuplicacaoPartesAcoplamentoDTO(new ArrayList<RelatorioDuplicacaoDePartesAcoplamentoDTO>());
		for (DwPassmon p : resultadoConsulta) {
			adicionaAoRetorno(retorno, p);
			
			/* Adiciona as ocorrencias de uso duplicado */
			q.defineParametro("cb", p.getCb());
			q.defineParametro("idPassmon", p.getIdPassmon());
			List<DwPassmon> duplicado = q.list();
			for (DwPassmon p2 : duplicado) {
				adicionaAoRetorno(retorno, p2);
			}
		}

		log.mostrarAvaliacaoCompleta();
		
		return retorno;
	}

	private void adicionaAoRetorno(ListaRelatorioDuplicacaoDePartesAcoplamentoDTO retorno, DwPassmon p) {
		RelatorioDuplicacaoDePartesAcoplamentoDTO dto = new RelatorioDuplicacaoDePartesAcoplamentoDTO();

		dto.setData(DataHoraRN.dateToStringDDMMYYYYHHMMSS(p.getDwPassagem().getDthr()));
		dto.setPosto(p.getDwPassagem().getOmPt().getCdPt());
		dto.setPsDescricaoProduto(p.getDwPassagem().getDwNserie().getOmProduto().getDsProduto());
		dto.setPsNumeroSerieProduto(p.getDwPassagem().getDwNserie().getNs());
		
		dto.setPmDescricaoProduto(p.getOmProduto().getDsProduto());
		dto.setPmNumeroSerieProduto(p.getCb());

		retorno.getDuplicacaoPartesAcoplamentoDTO().add(dto);
	}

	
	private List<DwPassmon> consultaRelatorioDuplicacaoDePartesAcoplamentoRN(FiltroRelatorioDuplicacaoDePartesAcoplamentoDTO filtro) {
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select distinct a");
		q.append("from DwPassmon a");
		q.append("join a.dwPassagem b");
		q.append("join b.dwNserie c");
		q.append("join b.dwConsolid d");
		q.append("where exists (select a2 from DwPassmon a2 join a2.dwPassagem b2 join b2.dwNserie c2 join c2.omProduto d2  where a2.idPassmon <> a.idPassmon and a2.cb = a.cb and c2.cb <> a2.cb and d2.tpProduto <> 4)");
		q.append("and b.dthr between :dataInicial and :dataFinal");
		q.append("order by a.cb, a.idPassmon");
		
		
		if (filtro.getTurnoDTO() != null) {
			q.append("AND d.dwTurno.idTurno = :idTurno");

		}

		q.defineParametroTimestamp("dataInicial", DataHoraRN.getDataHoraInicial(filtro.getPeriodoInicial()));
		q.defineParametroTimestamp("dataFinal", DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));

		if (filtro.getTurnoDTO() != null) {
			q.defineParametro("idTurno", filtro.getTurnoDTO().getTurno().getIdTurno());
		}
		
		List<DwPassmon> lista = q.list();
		
		return lista;
	}

}