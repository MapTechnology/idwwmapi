package idw.model.rn.monitorizacao.roteiro;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwRota;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.OmObj;
import idw.model.pojos.OmProduto;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.RoteiroRN;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.util.FormulasInjet;

public class MonitorizacaoVisaoRoteiroRN extends AbstractRN<DAOGenerico>{

	public MonitorizacaoVisaoRoteiroRN() {
		super(new DAOGenerico());
	}
	
	public MonitorizacaoVisaoRoteiroRN(DAOGenerico dao) {
		super(dao);
	}

	public ListaOmObjDTO obterMonitorizacaoVisaoRoteiro(Date dtReferencia, String cdTurno, String cdProduto) {
		ListaOmObjDTO retorno = new ListaOmObjDTO();
		
		ConsolidaRN cRN = new ConsolidaRN(getDao());
		
		// Pesquisar o roteiro a partir do cdProduto
		RoteiroRN rn = new RoteiroRN(getDao());
		OmProduto omproduto = new OmProduto();
		omproduto.setCdProduto(cdProduto);
		DwRota dwrota = rn.pesquisarDwRotaByCdProduto(omproduto, true, true);
		
		if (dwrota != null && dwrota.getOmObjsForIdRota() != null && dwrota.getOmObjsForIdRota().size() > 0) {
			// Interagir sobre todos os objetos de layout do roteiro
			for (OmObj omobj : dwrota.getOmObjsForIdRota()) {
				OmObjDTO dto = new OmObjDTO(omobj);

				// No momento a monitorizacao por roteiro sempre eh por turno
				dto.setTpId(DwConsolidTemplate.TpId.TURNO.getValue());
				
				// Se for folha
				if (omobj.getDwFolhaByIdFolha() != null) {
					
					// Verificar qual o pt que esta produzindo o semiacabado no turno de referencia
					List<DwConsolid> dwconsolids = cRN.pesquisarDwConsolid(dtReferencia, cdTurno, omobj.getDwFolhaByIdFolha());
					
					// Se nao existe ninguem produzindo entao setar que a folha est� offline. Folhas offline ficar�o brancas
					// e o click nelas informar� que n�o existe PT produzindo a folha
					if (dwconsolids == null || dwconsolids.size() == 0) {
						dto.setOffline(true);
					} else {
						DwConsolid dwconsolid = dwconsolids.get(0);
						DwConsol dwconsol = (DwConsol) dwconsolid.getDwConsols().iterator().next();
						
						dto.setDwconsolid(dwconsolid.clone(false));
						dto.getDwconsolid().getOmPt().setOmTppt(dwconsolid.getOmPt().getOmTppt().clone(false));
						dto.getDwconsolid().getOmPt().getOmTppt().setOmAlgocor(dwconsolid.getOmPt().getOmTppt().getOmAlgocor().clone(false));
						dto.setForaMeta( !dwconsolid.getDwRt().getIsConforme() );
						dto.setParada( !dwconsolid.getDwRt().getStFuncionamento().equals( (byte) 1));
						// Verificar o tempo do ciclo padrao do pt
						dto.setSegCicloPadrao(dwconsolid.getDwFolha().getSegCiclopadrao().intValue());

						if (dwconsol.getSegAutoCiclomedio() != null)
							dto.setSegCiclomedio((double)dwconsol.getSegAutoCiclomedio().intValue());
						else
							dto.setSegCiclomedio(0d);
						// Calcular ER, EC, IP
						dto.setEr((double)FormulasInjet.calcularEficienciaRealizacao(dwconsol.getPcsProducaoLiquida(), dwconsol.getPcsAutoProducaoprevista()).intValue());
						dto.setEc((double)FormulasInjet.calcularEficienciaCiclo(new BigDecimal(dto.getSegCicloPadrao()), new BigDecimal(dto.getSegCiclomedio())).intValue());
						dto.setIp(0d);
						
					}
					// Obter a soma dos ciclos medios da folha e suas predecessoras
					//dto.setSegCiclosomado(segCiclosomado);
					DwRotapasso dwrotapasso = null;
					for (DwRotapasso p : dwrota.getDwRotapassos()) {
						if (p.getDwFolha() != null && p.getDwFolha().getCdFolha().equals(omobj.getDwFolhaByIdFolha().getCdFolha())) {
							dwrotapasso = p;
						}
					}
					if (dwrotapasso != null) {
						PassosDTO passo = new PassosDTO(dwrotapasso);
						passo.inicializaPredecessoras(getDao());
						dto.mudaPasso(passo);
					}
				}
				
				retorno.getListaOmObjDTO().add(dto);
			}
			
			// Apos montar o retorno, entao devemos 
			for (OmObjDTO dto : retorno.getListaOmObjDTO()) {
				if (dto.getOmImg() == null || dto.getOmImg().getCdImg().equals("114") == false)
					continue;
				
				System.out.println("avaliando folha " + dto.getIdentificacao());
				double segCicloSomado = 0d;
				if (dto.obtemPasso() != null && dto.obtemPasso().getPassosPredecessoras() != null) {
					for (PassosDTO pre : dto.obtemPasso().getPassosPredecessorasRecursivamente()) {
						// Interage novamente para pegar  o ciclo medio em retorno.getListaOmObjDTO
						List<String> listaFolhasAvaliadas = new ArrayList<>(); // essa lista serve para nao acumular mais de uma vez a mesma folha
						for (OmObjDTO dtoAux : retorno.getListaOmObjDTO()) {
							if (listaFolhasAvaliadas.contains(dtoAux.getIdentificacao()))
								continue;
							listaFolhasAvaliadas.add(dtoAux.getIdentificacao());
							if (dtoAux.getIdentificacao().equals(pre.getDwfolha().getCdFolha())) {
								if (dtoAux.getSegCiclomedio() != null) {
									segCicloSomado += dtoAux.getSegCiclomedio();
									System.out.println(".....ciclomedio=" + segCicloSomado);
								}
							}
						}
					}
				}
				dto.setSegCiclosomado(segCicloSomado);
			}
		}
		return retorno;
	}
}
