package idw.model.rn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCpproduto;
import idw.webservices.dto.DsEspecializaAponDTO;
import idw.webservices.dto.DwConsolidDTO;
import idw.webservices.dto.DwConsolidDTOs;
import idw.webservices.dto.PTsDTO;
import idw.webservices.dto.PtDTO;
import idw.webservices.dto.ResultadoDTO;

public class ApontamentoManualRN extends AbstractRN<DAOGenerico>  {

	public ApontamentoManualRN() {
		super(new DAOGenerico());
	}
	
	public ApontamentoManualRN(DAOGenerico dao) {
		super(dao);
	}

	public PTsDTO pesquisarOmPts() throws RegistroDesconhecidoException {

		PTsDTO retorno = new PTsDTO();
		List<PtDTO> listaPts = new ArrayList<PtDTO>();
		List<OmPt> listaOmPt;
		MapQuery query = new MapQuery(getDaoSession());
		query.append("select distinct pt");
		query.append("from OmPt pt");
		query.append("join fetch  pt.omGt gt");
		query.append("where pt.stAtivo = 1");

		listaOmPt = query.list();

		if (listaOmPt == null) {
			throw new RegistroDesconhecidoException();
		}
		for (OmPt pt : listaOmPt) {
			PtDTO ptDTO = new PtDTO();
			ptDTO.setPt(pt.clone(false));
			ptDTO.getPt().setOmGt(pt.getOmGt().clone(false));
			listaPts.add(ptDTO);
		}
		retorno.setPts(listaPts);
		return retorno;

	}

	public DwConsolidDTOs pesquisarApontamentoProducao(DwConsolidDTO dto) throws RegistroDesconhecidoException {
		DwConsolidDTOs retorno = new DwConsolidDTOs();
		retorno.setResultadoDTO(new ResultadoDTO());
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select distinct c");
		q.append("from DwConsolid c");
		q.append("left join fetch c.dwConsols");
		q.append("where c.dtReferencia = :data");
		q.append("and c.omPt.idPt = :idPt");
		q.append("and c.tpId = 1");
		q.append("and c.dwTurno = :dwturno");
		
		// Alessandre em 29-05-17 acrescentei o filtro abaixo para nao trazer dados do turno atual, mesmo qua a op
		// ja tenha saido do posto
		q.append("and :dthrAtual not between c.dthrIturno and c.dthrFturno");
		

		q.defineParametroTimestamp("dthrAtual", DataHoraRN.getDataHoraAtual());
		q.defineParametroData("data", dto.getDwConsolid().getDtReferencia());
		q.defineParametro("idPt", dto.getDwConsolid().getOmPt().getIdPt());
		q.defineParametro("dwturno", dto.getDwConsolid().getDwTurno());

		List<DwConsolid> listaDwConsolid = q.list();
		List<DwConsolidDTO> listaDwConsolidDTO = new ArrayList<DwConsolidDTO>();

		if (listaDwConsolid == null) {

			throw new RegistroDesconhecidoException();
		} else {
			for (DwConsolid c : listaDwConsolid) {
				
				DwConsolidDTO cDTO = new DwConsolidDTO();
				cDTO.setDwConsolid(c.clone(true));
				cDTO.getDwConsolid().setDwFolha(c.getDwFolha().clone(true));
				cDTO.getDwConsolid().getPpCp().setOmPt(c.getPpCp().getOmPt().clone(false));
				cDTO.getDwConsolid().getOmPt().setOmTppt(c.getOmPt().getOmTppt().clone(false));
				
				// Clonar ppcpproduto para se obter o nrop
				if(c.getPpCp().getPpCpprodutos() != null && !c.getPpCp().getPpCpprodutos().isEmpty()) {
					for(PpCpproduto prod : c.getPpCp().getPpCpprodutos()) {
						cDTO.getDwConsolid().getPpCp().getPpCpprodutos().add(prod.clone(true));
					}
				}
				
				// Clonar tambem dwconsol e dwconsolpr pois eh de la que devemos pegar a producao bruta e refugada
				Set<DwConsol> clones = new HashSet<>();
				for (DwConsol consol : c.getDwConsols()) {
					DwConsol cloneConsol = consol.clone(false);
					// Clonar dwconsolpr
					Set<DwConsolpr> clonesPr = new HashSet<>();
					for (DwConsolpr consolpr : consol.getDwConsolprs()) {
						DwConsolpr clonepr = consolpr.clone(true);
						clonesPr.add(clonepr);
					}
					cloneConsol.setDwConsolprs(clonesPr);
					clones.add(cloneConsol);
				}
				cDTO.getDwConsolid().setDwConsols(clones);

				listaDwConsolidDTO.add(cDTO);
			}
			
			// Prepara nova lista separando um produto por linha
			List<DwConsolidDTO> novaLista = new ArrayList<DwConsolidDTO>();
	        for (DwConsolidDTO iddto : listaDwConsolidDTO) {
	            DwConsolid id = iddto.getDwConsolid();
	            for (DwConsol consol : id.getDwConsols()) {
	                for (DwConsolpr pr : consol.getDwConsolprs()) {
	                    // Clona um novo pr para adicionar o caminho completo na listaProducao
	                    DwConsolidDTO dtoNovo = new DwConsolidDTO();
	                    
	                    DwConsolid idNovo = id.clone(false);
	                    idNovo.setDwCal(id.getDwCal());
	                    idNovo.setDwFolha(id.getDwFolha());
	                    idNovo.setDwPepro(id.getDwPepro());
	                    idNovo.setOmPt(id.getOmPt());
	                    idNovo.setPpCp(id.getPpCp());
	                    idNovo.setDwTurno(id.getDwTurno());
	                    
	                    DwConsol consolNovo = consol.clone(false);
	                    consolNovo.setDwConsolParams(null);
	                    
	                    idNovo.setDwConsols(new HashSet<DwConsol>());
	                    idNovo.getDwConsols().add(consolNovo);
	                    
	                    DwConsolpr prNovo = pr.clone(false);
	                    prNovo.setOmProduto(pr.getOmProduto());
	                    consolNovo.setDwConsolprs(new HashSet<DwConsolpr>());
	                    consolNovo.getDwConsolprs().add(prNovo);
	                    
	                    dtoNovo.setDwConsolid(idNovo);
	                    
	                    novaLista.add(dtoNovo);
	                }
	            }
	        }

			retorno.setListaDwConsolidDTO(novaLista);
			retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().COM_SUCESSO);
		}

		return retorno;
	}

	public DsEspecializaAponDTO getEspecializaApon() {
		DsEspecializaAponDTO retorno = new DsEspecializaAponDTO();
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select distinct c.dsEspecializaapon");
		q.append("from DwConsolid c");

		List<String> lista = q.list();
		if (lista == null) {
			lista = new ArrayList<String>();
		}
		retorno.setListaEspecializaApon(lista);

		return retorno;
	}

	/* Esse metodo tem como objetivo salvar o apontamento manual em dwconsol e dwconsolpr
	 * 
	 */
	public void salvarApontamento(DwConsolidDTOs dwConsolidDTOs) {
		ApontamentoRefugoRN rnrefugo = new ApontamentoRefugoRN();
		ApontamentoProducaoRN rnprod = new ApontamentoProducaoRN();
		
		rnrefugo.setDao(getDao());
		rnprod.setDao(getDao());
		
		rnprod.salvarApontamentoProducao(dwConsolidDTOs);
		rnrefugo.salvarApontamentoRefugo(dwConsolidDTOs);
		
	}
}
