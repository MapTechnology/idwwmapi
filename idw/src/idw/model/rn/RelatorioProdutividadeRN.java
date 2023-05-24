package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmGtDAO;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.OmGt;
import idw.model.pojos.PpCpproduto;
import idw.util.IdwLogger;
import idw.webservices.dto.ListaRelatorioProdutividade;
import idw.webservices.dto.RelatorioProdutividadeDTO;

public class RelatorioProdutividadeRN extends AbstractRN<DAOGenerico> {

	public RelatorioProdutividadeRN() {
		this(null);
	}
	
	public RelatorioProdutividadeRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	/* Metodo principal para retorno do relatorio */
	public ListaRelatorioProdutividade getRelatorioProdutividade(DwConsolid filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioProdutividadeRN.getRelatorioProdutividade");
		log.info( idLog , 0, "RelatorioProdutividadeRN.getRelatorioProdutividade filtro usado:" + filtro.toString());
		
		List<DwConsolid> lista = pesquisarDwConsolids(filtro);
		List<RelatorioProdutividadeDTO> listaRetorno = new ArrayList<>();
		
		// Com base da lista de DwConsolid, determinar os horarios de inicio e fim de cada hora
		// Essa determinacao deve considerar o turno
		Map<String, Integer> horasDisponiveis = new HashMap<>();
		
		// O Map abaixo guarda a sequencia da hora para cada turno
		Map<String, Integer> sequenciaHoras = new HashMap<>();
		
		BigDecimal totalProduzido = BigDecimal.ZERO;
		for (DwConsolid id : lista) {
			// Horas disponiveis deve ser basear no inicio e fim do turno
			//
			
			//Marcos Sardinha: 2017-06-14 >> condicao abaixo so funcionava quando turno tinha hh:mm:ss iguais para inicio e fim 
			//                               tb nao funcionava pq nao atribuia 1 hora a mais para hrInicialTurno
			//for (Date hrInicialTurno = id.getDthrIturno() ; hrInicialTurno.equals(id.getDthrFturno()) == false; DataHoraRN.adicionaHorasDaData(hrInicialTurno, 1)) {
			
			//for (Date hrInicialTurno = id.getDthrIturno() ; hrInicialTurno.compareTo(id.getDthrFturno()) < 0; DataHoraRN.adicionaHorasDaData(hrInicialTurno, 1)) {
			for (Date hrInicialTurno = id.getDthrIhora() ; DataHoraRN.compareTo(hrInicialTurno, id.getDthrFhora()) < 0; DataHoraRN.adicionaHorasDaData(hrInicialTurno, 1)) {
				String horaAvaliada = id.getDwTurno().getCdTurno() + "-" + DataHoraRN.getHoraFormatoHHMMSS(hrInicialTurno);
				
				if (horasDisponiveis.containsKey(horaAvaliada) == false) {
					
					// Obtem qual a sequencia da hora para o turno
					String turnoParaSequencia = id.getDwTurno().getCdTurno();
					int sequenciaHora = 1;
					if (sequenciaHoras.containsKey(turnoParaSequencia)) {
						sequenciaHora = sequenciaHoras.get(turnoParaSequencia);
					}
					horasDisponiveis.put(horaAvaliada, sequenciaHora++);
					sequenciaHoras.put(turnoParaSequencia, sequenciaHora);
				}
				
				hrInicialTurno = DataHoraRN.adicionaHorasDaData(hrInicialTurno, 1);
				
			}
			
		}

		for (DwConsolid id : lista) {
			String horaAvaliada = id.getDwTurno().getCdTurno() + "-" + DataHoraRN.getHoraFormatoHHMMSS(id.getDthrIhora());
			
			
			Integer sequenciaHora = horasDisponiveis.get(horaAvaliada);
			
			if (sequenciaHora != null) {
				for (DwConsol consol : id.getDwConsols()) {
					for (DwConsolpr pr : consol.getDwConsolprs()) {
						RelatorioProdutividadeDTO dto = null;
						// Avaliar se o dto ja existe na lista, se sim utilizar o da lista
						boolean isExiste = false;
						for (RelatorioProdutividadeDTO dtoNaLista : listaRetorno) {
							if (
									dtoNaLista.getDtReferencia().equals(DataHoraRN.toStringDDMMYY(id.getDtReferencia()) ) &&
									dtoNaLista.getLinha().equals(id.getOmPt().getCdPt()) &&
									dtoNaLista.getOp().equals(id.getPpCp().getNrop()) &&
									dtoNaLista.getTurno().equals(id.getDwTurno().getDsTurno()) &&
									dtoNaLista.getModelo().equals(pr.getOmProduto().getCdProduto() + "-" + pr.getOmProduto().getDsProduto())
									) {
								isExiste = true;
								dto = dtoNaLista;
							}
						}
						// se nao existir cria-lo e colocar na lista
						if (isExiste == false) {
							dto = new RelatorioProdutividadeDTO();
							dto.setDtReferencia(DataHoraRN.toStringDDMMYY(id.getDtReferencia()) );
							dto.setTurno(id.getDwTurno().getDsTurno());
							dto.setDtInicio(id.getDthrIhora());
							dto.setDtFim(id.getDthrFhora());
							dto.setLinha(id.getOmPt().getCdPt());
							// Obter qual a OP e a producao planejada
							dto.setOp(id.getPpCp().getNrop());
							dto.setProducaoPlanejada(id.getPpCp().getPpCpproduto(pr.getOmProduto().getCdProduto()).getPcsProducaoplanejada());
							dto.setModelo(pr.getOmProduto().getCdProduto() + "-" + pr.getOmProduto().getDsProduto()); //um produto da OP
	
							listaRetorno.add(dto);
						}
	
						// Atualizar valores
						BigDecimal producaoLiquida = pr.getPcsProducaoLiquida();
	
						if (producaoLiquida != null) {
							dto.setHora(sequenciaHora, horaAvaliada, producaoLiquida.intValue());
							if (dto.getProducaoBruta() != null) {
								dto.setProducaoBruta(dto.getProducaoBruta().add(producaoLiquida));
							} else
								dto.setProducaoBruta(producaoLiquida);
						}
	
						if (producaoLiquida != null)
							totalProduzido = totalProduzido.add(producaoLiquida);
					}
				}
			}
		}

		// Preparando retorno
		ListaRelatorioProdutividade retorno = new ListaRelatorioProdutividade();
		// Inserir no retorno apenas as linhas que tiverem producao
		retorno.setLista(new ArrayList<RelatorioProdutividadeDTO>());
		for (RelatorioProdutividadeDTO dto : listaRetorno) {
			if (dto.getProducaoBruta() != null && dto.getProducaoBruta().intValue() > 0)
				retorno.getLista().add(dto);
		}
		retorno.setTotalProduzido(totalProduzido);
		log.mostrarAvaliacaoCompleta();
		return retorno;
	}

	// Metodo para retornar os dwconsolid necessarios para montar o relatorio
	private List<DwConsolid> pesquisarDwConsolids(DwConsolid filtro) {
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select distinct a");
		q.append("from DwConsolid a");
		q.append("join fetch a.dwConsols b");
		q.append("join fetch b.dwConsolprs c");
		q.append("join a.ppCp d");
		q.append("join d.ppCpprodutos e");
		q.append("join a.omPt f");
		q.append("join f.omObjs g");
		q.append("join g.omGtByIdGt h");
		q.append("join e.omProduto i");
		q.append("left join f.omGt omgtpt");
		q.append("left join omgtpt.omGtfase omgtfase");

		//Marcos Sardinha: 2017-07-27 >> Defeito #4264
		q.appendWhere(MapQuery._AND, "(a.stAtivo IS NULL OR a.stAtivo = 1)", true);

		q.appendWhere(MapQuery._AND, "a.tpId = :tpId", true);
		q.appendWhere(MapQuery._AND, "a.dtReferencia BETWEEN :dtInicio AND :dtFim", filtro.getDthrIhora() != null && filtro.getDthrFhora() != null);
		q.appendWhere(MapQuery._AND, "a.dwTurno.idTurno = :idTurno", filtro.getDwTurno() != null);
		if (filtro.getDwTurno() == null) {
			q.appendWhere(MapQuery._AND,  "a.dwTurno.idTurno <> 1", true);
		}
		if(filtro.getOmPt() != null) {
			if((filtro.getOmPt().getOmGt() != null && filtro.getOmPt().getOmGt().getCdGt() != null) && (filtro.getOmPt().getOmGt() != null && filtro.getOmPt().getOmGt().getOmGtfase() != null)) {
				q.append("AND (omgtpt = :linha OR omgtfase = :fase)");
			} else {
				if(filtro.getOmPt().getOmGt() != null && filtro.getOmPt().getOmGt().getCdGt() != null) {
					q.append("AND omgtpt = :linha");
				}
				if(filtro.getOmPt().getOmGt() != null && filtro.getOmPt().getOmGt().getOmGtfase() != null) {
					q.append("AND omgtfase = :fase");
				}
			}	
		}
		
		if(filtro.getPpCp() != null) {
			PpCpproduto cpproduto = filtro.getPpCp().getPpCpprodutos().iterator().next();
			if(cpproduto.getNrDoc() != null) {
				q.append("AND e.nrDoc = :nrDoc");
			}
			if(cpproduto.getOmProduto() != null) {
				q.append("AND i.cdProduto = :cdproduto");
			}
		}
		q.append("order by a.dthrIhora");

		
		
		q.defineParametro("tpId", (byte) 0);
		q.defineParametro("dtInicio", filtro.getDthrIhora());
		q.defineParametro("dtFim", filtro.getDthrFhora());
		q.defineParametro("dthrinicio", filtro.getDthrIhora());
		q.defineParametro("dthrfim", DataHoraRN.getDataHora235959(filtro.getDthrFhora()));

		if(filtro.getDwTurno() != null) {
			q.defineParametro("idTurno", filtro.getDwTurno().getIdTurno());
		}
		
		if(filtro.getOmPt() != null) {
			OmGtDAO gtDAO = new OmGtDAO(getDaoSession());
			if(filtro.getOmPt().getOmGt() != null && filtro.getOmPt().getOmGt().getCdGt() != null){
				OmGt linha = gtDAO.getOmGtPorCdAtivoOrderById(filtro.getOmPt().getOmGt().getCdGt());
				q.defineParametro("linha", linha);
			}
			if(filtro.getOmPt().getOmGt() != null && filtro.getOmPt().getOmGt().getOmGtfase() != null) {
				OmGt faseProducao = gtDAO.getOmGtPorCdAtivoOrderById(filtro.getOmPt().getOmGt().getOmGtfase().getCdGt());
				q.defineParametro("fase", faseProducao);
			}			
		}
		
		if(filtro.getPpCp() != null) {
			PpCpproduto cpproduto = filtro.getPpCp().getPpCpprodutos().iterator().next();
			if(cpproduto.getNrDoc() != null) {
				q.defineParametro("nrDoc", cpproduto.getNrDoc());
			}
			if(cpproduto.getOmProduto() != null) {
				q.defineParametro("cdproduto", cpproduto.getOmProduto().getCdProduto());
			}
		}		

		return q.list();
	}
}