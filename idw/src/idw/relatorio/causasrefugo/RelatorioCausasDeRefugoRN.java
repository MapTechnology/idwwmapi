package idw.relatorio.causasrefugo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwConsolre;
import idw.model.pojos.DwConsolrelog;
import idw.model.pojos.DwConsolreoco;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.util.IdwLogger;

public class RelatorioCausasDeRefugoRN extends AbstractRN<DAOGenerico> {

	public RelatorioCausasDeRefugoRN() {
		this(null);
	}

	public RelatorioCausasDeRefugoRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public ListaRelatorioCausasDeRefugoDTO getRelatorioCausasDeRefugo(FiltroRelatorioCausasDeRefugoDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioCausasDeRefugoRN.getRelatorioCausasDeRefugo");
		log.info( idLog , 0, "RelatorioCausasDeRefugoRN.getRelatorioCausasDeRefugo filtro usado:" + filtro.toString());
		
		List<DwConsolid> listaConsolid = new ArrayList<>();

		MapQuery q = new MapQuery(getDaoSession());
		ListaRelatorioCausasDeRefugoDTO lista = new ListaRelatorioCausasDeRefugoDTO();

		//Marcos Sardinha: 2017-08-31 >> Defeito #4347 >>> faltava LEFT JOIN nas tabelas associadas ao refugo
		q.append("SELECT DISTINCT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("join consolid.ppCp ppcp");
		q.append("join ppcp.ppCpprodutos ppcpproduto");
		q.append("JOIN consolid.dwConsols consol");
		q.append("JOIN consol.dwConsolprs consolpr");
		q.append("JOIN consolpr.omProduto produto");
		q.append("LEFT JOIN consol.dwConsolres consolre");
		q.append("LEFT JOIN consolre.dwTRefugo trefugo");
		q.append("LEFT JOIN trefugo.dwConsolrelogs relog");
		q.append("LEFT JOIN relog.dwTCausa causa");
		q.append("JOIN consolid.omPt pt");
		q.append("JOIN consolid.dwFolha folha");
		
		// Alessandre em 18-01-18 acrescentei left nas duas linhas abaixo, pois muitos pts não usam RAP
		q.append("left JOIN folha.dwFolharaps folharap");
		q.append("left JOIN folharap.dwRap rap");
		
		q.append("LEFT JOIN pt.omObjs obj");
		q.append("LEFT JOIN obj.omGtByIdGt gt");
		q.append("LEFT JOIN rap.dwRapGrupos rapgp");
		q.append("LEFT JOIN rapgp.dwGrupoFerramenta gpferramenta");
		q.append("WHERE consolid.tpId = :tpid");
		q.append("and consolid.stAtivo is null");

		if (filtro.getNrDoc() != null && filtro.getNrDoc().trim().equals("") == false)
			q.append("and ppcpproduto.nrDoc = :nrdoc");
		
		if (filtro.getPeriodoInicial() != null)
			q.append("AND consolid.dtReferencia BETWEEN :dtincio AND :dtfim");

		if (filtro.getTurnoDTO() != null) {
			q.append("AND consolid.dwTurno.idTurno = :idturno");
		} else {
			q.append("AND consolid.dwTurno.idTurno != 1");
		}
		if (filtro.getOmpt() != null) {
			q.append("AND consolid.omPt.idPt = :idPt");
		}
		if (filtro.getOmgt() != null) {
			q.append("AND gt.idGt = :idgt");
		}
		if (filtro.getRap() != null) {
			q.append("AND rap.idRap = :idRap");
		}
		if (filtro.getDwGrupoFerramenta() != null) {
			q.append("AND gpferramenta.idGrupoFerramenta = :idgpferramenta");
		}

		q.defineParametro("nrdoc", filtro.getNrDoc());
		q.defineParametro("tpid", (byte) 1);
		if (filtro.getPeriodoInicial() != null) {
			q.defineParametroData("dtincio", filtro.getPeriodoInicial());
			q.defineParametroData("dtfim", DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));
		}
		
		if (filtro.getTurnoDTO() != null) {
			q.defineParametro("idturno", filtro.getTurnoDTO().getTurno().getIdTurno());
		}

		if (filtro.getOmpt() != null) {
			q.defineParametro("idPt", filtro.getOmpt().getIdPt());
		}
		if (filtro.getOmgt() != null) {
			q.defineParametro("idgt", filtro.getOmgt().getIdGt());
		}
		if (filtro.getRap() != null) {
			q.defineParametro("idRap", filtro.getRap().getIdRap());
		}
		if (filtro.getDwGrupoFerramenta() != null) {
			q.defineParametro("idgpferramenta", filtro.getDwGrupoFerramenta().getIdGrupoFerramenta());
		}

		listaConsolid = q.list();

		if (!listaConsolid.isEmpty()) {
			lista = montarDTO(listaConsolid);
		}
		log.mostrarAvaliacaoCompleta();
		return lista;
	}

	public ListaRelatorioCausasDeRefugoDTO montarDTO(List<DwConsolid> listaConsolid) {
		
		Map<String, RelatorioCausasDeRefugoDTO> produtosMap = new HashMap<String, RelatorioCausasDeRefugoDTO>();

		ListaRelatorioCausasDeRefugoDTO retorno = new ListaRelatorioCausasDeRefugoDTO();
		retorno.setListaDeRefugos(new ArrayList<RelatorioCausasDeRefugoDTO>());

		for (DwConsolid consolid : listaConsolid) {
			for(DwConsol consol : consolid.getDwConsols()) {

				if (consol.getDwConsolprs() != null) {
					for (DwConsolpr consolpr : consol.getDwConsolprs()) {
						
						if(consolpr.getOmProduto() == null)
							continue;

						String produto = consolpr.getOmProduto().getCdProduto() + " - " + consolpr.getOmProduto().getDsProduto();
						

						BigDecimal quantidadeProduzida = BigDecimal.ZERO;
						BigDecimal producaoRefugada = BigDecimal.ZERO;
						BigDecimal producaoLiquida = BigDecimal.ZERO;
						BigDecimal indiceRefugo = BigDecimal.ZERO;
	
						quantidadeProduzida = consolpr.getPcsProducaoBruta();
	
						producaoRefugada = consolpr.getPcsProducaoRefugada();
						
						producaoLiquida = FormulasInjet.calcularProducaoLiquida(quantidadeProduzida, producaoRefugada);
						
						indiceRefugo = new BigDecimal(FormulasInjet.calcularIndiceRefugo(producaoRefugada, quantidadeProduzida));
						
						RelatorioCausasDeRefugoDTO dto = new RelatorioCausasDeRefugoDTO();
						dto.setProduto(produto);
						dto.setQuantidadeProduzida(quantidadeProduzida);
						dto.setQuantidadeRefugada(producaoRefugada);
						dto.setQuantidadeLiquida(producaoLiquida);
						dto.setIndiceRefugo(indiceRefugo);
	
						adicionarDTOnoMap(dto, produtosMap);
					}
				}
				
				if (consol.getDwConsolres() != null) {
					for(DwConsolre consolre : consol.getDwConsolres()) {
						
						if(consolre.getDwConsolreocos() != null) {
							for(DwConsolreoco oco : consolre.getDwConsolreocos()) {
								
								if(oco.getDwConsolrelog() != null) {
									DwConsolrelog log = oco.getDwConsolrelog();
									
									if(log.getOmProduto() == null) {
										continue;
									}
									String produto = log.getOmProduto().getCdProduto() + " - " + log.getOmProduto().getDsProduto();
									RelatorioCausasDeRefugoDTO dto = recuperarDTOdoMap(produto, produtosMap);
									
									String refugo = "***";
									String causa = "***";
									BigDecimal quantidadeRefugada = BigDecimal.ZERO;
									
									if(log.getDwTRefugo() != null) {
										refugo = log.getDwTRefugo().getCdTrefugo() + " - " + log.getDwTRefugo().getDsTrefugo();
									}
									
									if(log.getDwTCausa() != null) {
										causa = log.getDwTCausa().getCdTcausa() + " - " + log.getDwTCausa().getDsTcausa();
									}
									
									quantidadeRefugada = AritmeticaUtil.somar(log.getPcsAutoProducaorefugada(), log.getPcsManuProducaorefugada());
									
									RelatorioCausasDeRefugoDetalheDTO detalheDTO = new RelatorioCausasDeRefugoDetalheDTO();
									
									detalheDTO.setRefugo(refugo);
									detalheDTO.setCausa(causa);
									detalheDTO.setQuantidadeRefugada(quantidadeRefugada);

									adicionarDetalheNoDTO(detalheDTO, dto);
								}
							}
						}						
					}
				}
			}
		}
		
		for(String chave : produtosMap.keySet()) {
			RelatorioCausasDeRefugoDTO dto = produtosMap.get(chave);
			if (dto.getProduto() == null)
				continue;
			calcularIndiceRefugoDosDetalhes(dto);
			retorno.getListaDeRefugos().add(dto);
		}

		calcularTotal(retorno);
		ordenarPorIndiceRefugo(retorno);
		return retorno;
	}
	
	private void adicionarDTOnoMap(RelatorioCausasDeRefugoDTO novoDTO, Map<String, RelatorioCausasDeRefugoDTO> map) {
		if(novoDTO == null) {
			return;
		}
		
		String produto = novoDTO.getProduto();
		
		RelatorioCausasDeRefugoDTO dto = map.get(produto);
		if(dto == null) {
			map.put(produto, novoDTO);
		} else {
			mesclarDto(dto, novoDTO);
		}
	}
	
	private RelatorioCausasDeRefugoDTO mesclarDto(RelatorioCausasDeRefugoDTO dto1, RelatorioCausasDeRefugoDTO dto2) {
		BigDecimal quantidadeProduzida = dto1.getQuantidadeProduzida();
		BigDecimal producaoRefugada = dto1.getQuantidadeRefugada();
		BigDecimal producaoLiquida = dto1.getQuantidadeLiquida();
		BigDecimal indiceRefugo = BigDecimal.ZERO;
		
		quantidadeProduzida = AritmeticaUtil.somar(quantidadeProduzida, dto2.getQuantidadeProduzida());

		producaoRefugada = AritmeticaUtil.somar(producaoRefugada, dto2.getQuantidadeRefugada());
		
		producaoLiquida = FormulasInjet.calcularProducaoLiquida(quantidadeProduzida, producaoRefugada);
		
		indiceRefugo = new BigDecimal(FormulasInjet.calcularIndiceRefugo(producaoRefugada, quantidadeProduzida));
		
		dto1.setQuantidadeProduzida(quantidadeProduzida);
		dto1.setQuantidadeRefugada(producaoRefugada);
		dto1.setQuantidadeLiquida(producaoLiquida);
		dto1.setIndiceRefugo(indiceRefugo);
		
		dto1.getListaDetalheRefugo().addAll(dto2.getListaDetalheRefugo());
		
		return dto1;
	}
	
	private RelatorioCausasDeRefugoDTO recuperarDTOdoMap(String produto, Map<String, RelatorioCausasDeRefugoDTO> map) {
		RelatorioCausasDeRefugoDTO dto = map.get(produto);
		if(dto == null) {
			dto = new RelatorioCausasDeRefugoDTO();
			map.put(produto, dto);
		}
		return dto;
	}
	
	private void adicionarDetalheNoDTO(RelatorioCausasDeRefugoDetalheDTO novoDetalheDTO, RelatorioCausasDeRefugoDTO dto) {
		if(dto == null || novoDetalheDTO == null) {
			return;
		}
		
		for(RelatorioCausasDeRefugoDetalheDTO detalheDTO : dto.getListaDetalheRefugo()) {
			if(detalheDTO.getRefugo().equals(novoDetalheDTO.getRefugo())) {
				if(detalheDTO.getCausa().equals(novoDetalheDTO.getCausa())) {
					mesclarDetalheDTO(detalheDTO, novoDetalheDTO);
					return;
				}
			}
		}
		
		dto.getListaDetalheRefugo().add(novoDetalheDTO);
	}
	
	private void mesclarDetalheDTO(RelatorioCausasDeRefugoDetalheDTO dto1, RelatorioCausasDeRefugoDetalheDTO dto2) {
		BigDecimal quantidadeRefugada = dto1.getQuantidadeRefugada();
		
		quantidadeRefugada = AritmeticaUtil.somar(quantidadeRefugada, dto2.getQuantidadeRefugada());
		
		dto1.setQuantidadeRefugada(quantidadeRefugada);
	}
	
	private void calcularIndiceRefugoDosDetalhes(RelatorioCausasDeRefugoDTO dto) {
		BigDecimal quantidadeProduzidaDoProduto = dto.getQuantidadeProduzida();
		
		for(RelatorioCausasDeRefugoDetalheDTO detalheDTO : dto.getListaDetalheRefugo()) {
			BigDecimal indiceRefugoDetalhe = BigDecimal.ZERO;
			indiceRefugoDetalhe = new BigDecimal(
	                FormulasInjet.calcularIndiceRefugo(
	                		detalheDTO.getQuantidadeRefugada(),
	                		quantidadeProduzidaDoProduto));
			detalheDTO.setIndiceRefugo(indiceRefugoDetalhe);
		}
	}
	
	private void calcularTotal(ListaRelatorioCausasDeRefugoDTO retorno) {
		BigDecimal quantidadeProduzida = BigDecimal.ZERO;
		BigDecimal producaoRefugada = BigDecimal.ZERO;
		BigDecimal producaoLiquida = BigDecimal.ZERO;
		BigDecimal indiceRefugo = BigDecimal.ZERO;	
		
		for(RelatorioCausasDeRefugoDTO dto : retorno.getListaDeRefugos()) {
			quantidadeProduzida = 
					AritmeticaUtil.somar(
							quantidadeProduzida,
							dto.getQuantidadeProduzida());

			producaoRefugada = 
					AritmeticaUtil.somar(
							producaoRefugada,
	                        dto.getQuantidadeRefugada());
		}
		
		producaoLiquida = FormulasInjet.calcularProducaoLiquida(
				quantidadeProduzida,
				producaoRefugada);
		
		indiceRefugo = new BigDecimal(
                FormulasInjet.calcularIndiceRefugo(
                		producaoRefugada,
                        quantidadeProduzida));
		
		retorno.setQuantidadeProduzidaTotal(quantidadeProduzida);
		retorno.setQuantidadeRefugadaTotal(producaoRefugada);
		retorno.setQuantidadeLiquidaTotal(producaoLiquida);
		retorno.setIndiceDeRefugoTotal(indiceRefugo);
	}
	
	private void ordenarPorIndiceRefugo(ListaRelatorioCausasDeRefugoDTO retorno) {
        Comparator<RelatorioCausasDeRefugoDTO> comparatorDTO = new Comparator<RelatorioCausasDeRefugoDTO>() {
            @Override
            public int compare(RelatorioCausasDeRefugoDTO o1, RelatorioCausasDeRefugoDTO o2) {
                BigDecimal valor1 = o1.getIndiceRefugo();
                BigDecimal valor2 = o2.getIndiceRefugo();
                if (valor1 == null)
                	valor1 = BigDecimal.ZERO;
                if (valor2 == null)
                	valor2 = BigDecimal.ZERO;
                return valor2.compareTo(valor1);
            }
        };
        
        Comparator<RelatorioCausasDeRefugoDetalheDTO> comparatorDetalheDTO = new Comparator<RelatorioCausasDeRefugoDetalheDTO>() {
            @Override
            public int compare(RelatorioCausasDeRefugoDetalheDTO o1, RelatorioCausasDeRefugoDetalheDTO o2) {
                BigDecimal valor1 = o1.getIndiceRefugo();
                BigDecimal valor2 = o2.getIndiceRefugo();
                return valor2.compareTo(valor1);
            }
        };
        
        for(RelatorioCausasDeRefugoDTO dto : retorno.getListaDeRefugos()) {
        	Collections.sort(dto.getListaDetalheRefugo(), comparatorDetalheDTO);
        }
        
        Collections.sort(retorno.getListaDeRefugos(), comparatorDTO);
    }

}
