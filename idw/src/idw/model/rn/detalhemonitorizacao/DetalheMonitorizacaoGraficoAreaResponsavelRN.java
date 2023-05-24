package idw.model.rn.detalhemonitorizacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmPtDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRtcic;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.rn.CpRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.injet.PlanejamentoInjetRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebRN.FiltroOp;
import idw.util.FormulasInjet;
import idw.util.IdwLogger;
import idw.webservices.dto.DwConsolidDTO;
import idw.webservices.dto.DwConsolidDTOs;
import idw.webservices.dto.FiltroGraficoDetalhePtDTO;
import idw.webservices.dto.GraficoDetalhePtDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalhePostoDTO;

public class DetalheMonitorizacaoGraficoAreaResponsavelRN extends DetalheMonitorizacaoPTInsertRN {

	public DetalheMonitorizacaoGraficoAreaResponsavelRN() {
		super(new DAOGenerico());
	}

	public DetalheMonitorizacaoGraficoAreaResponsavelRN(DAOGenerico dao) {
		super(dao);
	}

	/*
	 * Gerado para poder usar um limite de linhas retornadas na consulta, e casos com muitas linhas havia estouro de memÃ³ria no Android
	 */
	public GraficoDetalhePtDTO getGraficoDetalhePtDTO(FiltroGraficoDetalhePtDTO filtro) {
		return getGraficoDetalhePtDTO(filtro, 0);
	}

	/*
	 * Esse metodo foi chamado no momento de se montar o grafico de parada por area responsavel. Acredito que sera chamado por outros
	 * graficos tambem
	 */
	public GraficoDetalhePtDTO getGraficoDetalhePtDTO(FiltroGraficoDetalhePtDTO filtro, int limiteMaxresult) {

		IdwLogger log = new IdwLogger("getGraficoDetalhePt");
		GraficoDetalhePtDTO retorno = new GraficoDetalhePtDTO();
		DwConsolidDTOs dwconsolidDTOs = new DwConsolidDTOs();
		List<DwConsolidDTO> listaDwConsolidDTO = new ArrayList<DwConsolidDTO>();

		Byte tpId = filtro.getTpId();

		if (filtro.getIdCp() != null) {
			filtro.setPpCp(new PpCp());
			filtro.getPpCp().setIdCp(filtro.getIdCp());
		}

		// Marcos Sardinha 2017-07-04: Defeito #4061
		List<DwConsolid> listadwconsolid = null;
		if (filtro.getIdConsolid() != 0) {
			listadwconsolid = this.getDwConsolid(log, filtro.getIdConsolid(),
					filtro.isComParadas(), false, false,
					false, false, false);
		} else {
			listadwconsolid = this.getDwConsolid(log, tpId,
					filtro.getOmPt(), filtro.getPpCp(), filtro.getDwTurno(),
					filtro.getDwTParada(), null, filtro.getDtReferencia(),
					filtro.getDtReferenciaInicial(), filtro.getDtReferenciaFinal(),
					filtro.getDthrIturno(), filtro.getDthrFturno(),
					filtro.getDthrIhora(), filtro.getDthrFhora(),
					filtro.isComParadas(), false, false, limiteMaxresult,
					filtro.getOmGt(), false, false, false);
		}

		if (listadwconsolid != null && listadwconsolid.isEmpty() == false) {

			for (DwConsolid dwconsolid : listadwconsolid) {

				DwConsolidDTO dto = new DwConsolidDTO();
				dto.setDwConsolid(dwconsolid.clone(false));
				dto.getDwConsolid().setDwFolha(dwconsolid.getDwFolha().clone());

				DwConsol dwConsol = dwconsolid.getDwConsols().iterator().next();

				// Marcos Sardinha: 2017-07-11 - Defeito #4160 >> clone de dwconsolid mesmo com false estava clonando dwconsol (por isso a
				// duplicidade de barras)

				/*
				 * if(dto.getDwConsolid().getDwConsols() == null){ dto.getDwConsolid().setDwConsols(new HashSet<DwConsol>()); }
				 */

				dto.getDwConsolid().setDwConsols(new HashSet<DwConsol>());

				for (DwConsol consol : dwconsolid.getDwConsols()) {
					DwConsol consolClone = consol.clone(false);
					consolClone.setDwConsoldefs(consol.cloneDwConsoldefs());
					consolClone.setDwConsolres(consol.cloneDwConsolres());
					dto.getDwConsolid().getDwConsols().add(consolClone);
				}

				dto.getDwConsolid().setDwTurno(dwconsolid.getDwTurno().clone(false));

				if (dwConsol.isTemParada()) {
					retorno.setComParadas(true);
				}

				// Calcula a eficiencia do ciclo
				// IndicadorCicloMedioRN cmRN = new IndicadorCicloMedioRN(omcfg,
				// dwconsolid.getOmPt(), dwConsol.getSegAutoTempoprodutivo(),
				// dwConsol.getQtAutoCicloprodutivo(),
				// dwConsol.getSegAutoTempoparadaSp());
				Float eficienciaCiclo = FormulasInjet.calcularEficienciaCiclo(dwConsol.getSegAutoCiclopadrao(), dwConsol.getSegAutoCiclomedio()).floatValue();
				dto.setEficienciaCiclo(new Double(eficienciaCiclo == null ? 0 : eficienciaCiclo));

				dto.getDwConsolid().setOmPt(dwconsolid.getOmPt().clone(false));

				// adiciona em listaConsolidDTO. Se for PT diferente, entao acumula na mesma hora os valores
				dto = adicionaEmListaDwConsolidDTO(listaDwConsolidDTO, dto);

				// Carrega dados de parada
				if (filtro.isComParadas()) {
					DwConsol dwConsolClonado = dto.getDwConsolid().getDwConsols().iterator().next();
					dwConsolClonado.setDwConsolpas(dwConsol.cloneDwConsolpas());

					List<DwConsolid> consolids = new ArrayList<DwConsolid>();
					consolids.add(dwconsolid);

				}
			}

			DwFolha dwFolha = listadwconsolid.get(listadwconsolid.size() - 1).getDwFolha();
			OmPt omPt = listadwconsolid.get(listadwconsolid.size() - 1).getOmPt();

			FolhaRN folhaRN = new FolhaRN(this.getDao());
			dwFolha = folhaRN.pesquisaFolhaByCdEStSemRota(dwFolha.getCdFolha());

			// Pega ciclo padrÃ£o
			BigDecimal cicloPadrao;
			try {
				cicloPadrao = folhaRN.getCicloPadrao(dwFolha, omPt);
				if (cicloPadrao == null || cicloPadrao.compareTo(BigDecimal.ZERO) == 0)
					cicloPadrao = BigDecimal.ONE;
			} catch (SemCicloPadraoException e) {
				cicloPadrao = BigDecimal.ONE;
			} catch (NullPointerException e) {
				// Alex 02/06/2017 #3824
				cicloPadrao = BigDecimal.ONE;
			}
			retorno.setCicloPadrao(cicloPadrao.doubleValue());

			BigDecimal cicloMinimo;
			try {
				cicloMinimo = folhaRN.getCicloMinimoFromDwFolha(dwFolha, omPt);
				if (cicloMinimo == null)
					cicloMinimo = BigDecimal.ZERO;
			} catch (SemCicloPadraoException e) {
				cicloMinimo = BigDecimal.ZERO;
			} catch (NullPointerException e) {
				// Alex 02/06/2017 #3824
				cicloMinimo = BigDecimal.ZERO;
			}

			BigDecimal perCicloMaximo;
			try {
				perCicloMaximo = folhaRN.getCicloMaximoFromDwFolha(dwFolha, omPt);
				if (perCicloMaximo == null)
					perCicloMaximo = new BigDecimal(100);
			} catch (SemCicloPadraoException e) {
				perCicloMaximo = new BigDecimal(100);
			} catch (NullPointerException e) {
				// Alex 02/06/2017 #3824
				perCicloMaximo = new BigDecimal(100);
			}

			// Pega cavidades ativas
			// Guarda as cavidades ativas
			BigDecimal cavAtivas;
			try {
				cavAtivas = folhaRN.getPcsPorCicloAtivas(dwFolha);
			} catch (SemPcsPorCicloAtivasException e) {
				e.printStackTrace();
				cavAtivas = BigDecimal.ONE;
			} catch (NullPointerException e) {
				// Alex 02/06/2017 #3824
				cavAtivas = BigDecimal.ONE;
			}
			retorno.setCavAtivas(cavAtivas.doubleValue());

			// Limite superior e inferior do ciclo (lse, lie)
			BigDecimal lse = cicloPadrao.multiply(perCicloMaximo.divide(new BigDecimal(100)));
			BigDecimal lie = cicloMinimo;

			retorno.setLimitesuperior(lse.doubleValue());
			retorno.setLimiteinferior(lie.doubleValue());

			// Metahora
			try {
				retorno.setMetaHora(FormulasInjet.calcularMetaHora(cicloPadrao, cavAtivas.longValue(), omPt.getIndOee()).doubleValue());
			} catch (NumberFormatException e) {
				retorno.setMetaHora(-1d);
			}

		}

		//
		DwRtcic cic = null;
		if (filtro != null && filtro.getIdCp() != null)
			cic = getHoraInicioAndFimUltOcorrencia(filtro.getIdCp());

		if (cic != null) {
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(cic.getDthrIciclo());
			retorno.setDataIocorrencia(cal1);

			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(cic.getDthrFciclo());
			retorno.setDataFocorrencia(cal2);
		}

		dwconsolidDTOs.setListaDwConsolidDTO(listaDwConsolidDTO);
		retorno.setDwConsolidDTOs(dwconsolidDTOs);
		
		// imprime o retorno
//		for (DwConsolidDTO dto : listaDwConsolidDTO) {
//			System.out.println("retorno=" + dto.getDwConsolid().getDwConsol().getPcsAutoProducaoliquida());
//		}

		return retorno;
	}

	/*
	 * Alessandre em 02-03-2020 um dos graficos que utilizam a lista de dwconsolid é o producao liquida por hora e o efeito que está
	 * ocorrendo é o grafico mostrar barras separadas para cada posto. O idenal é acumulular os valores quando o posto for diferente. Asssim
	 * o grafico mostrará a producao por hora com a soma de todos os postos do GT quando o BI é acionado
	 */
	private DwConsolidDTO adicionaEmListaDwConsolidDTO(List<DwConsolidDTO> listaDwConsolidDTO, DwConsolidDTO dto) {
		DwConsolidDTO retorno = dto;
		// Verifica se a data e hora ja estao incluidas. Se sim, entao acumular. Se nao, adicionar
		boolean isExiste = false;
		for (DwConsolidDTO id : listaDwConsolidDTO) {
			if (id.equals(dto)) {

				id.addDTO(dto);
				
				retorno = id;

				isExiste = true;
			}
		}
		if (isExiste == false)
			listaDwConsolidDTO.add(dto);
		
		return retorno;
	}

	public DwRtcic getHoraInicioAndFimUltOcorrencia(long idcp) {
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("SELECT cic FROM DwRtcic cic JOIN cic.dwRt rt WHERE cic.ppCp.idCp = :idcp");
		q.defineParametro("idcp", idcp);
		q.setMaxResults(1);
		return (DwRtcic) q.uniqueResult();
	}

	
    public FiltroGraficoDetalhePtDTO montarFiltroPorTurno(FiltroDetalhePostoDTO filtro, String formatoData) throws RegistroDesconhecidoException {
    	FiltroGraficoDetalhePtDTO retorno = new FiltroGraficoDetalhePtDTO();

    	OmPtDAO omPtDAO = new OmPtDAO(getDao().getSession());
    	OmPt omPt = omPtDAO.getOmPtAtivoComUltimaRevisao(filtro.getCdPosto());		
    	retorno.setOmPt(omPt);
    	
    	CpRN rn = new CpRN(getDao());
     	if(filtro.getFiltroOp() == FiltroOp.ULTIMA_OP_NO_TURNO.getValor()) {
     		PpCp ppCp = rn.pesquisarPpCpByCdCpCdPt(filtro.getCdCp(), filtro.getCdPosto());    	
     	   	
     		retorno.setPpCp(ppCp);
        }
    	retorno.setDtReferencia(DataHoraRN.stringToDate(filtro.getDtReferencia(), formatoData));
    	
    	DwTurno turno = new DwTurno();
    	turno.setIdTurno(filtro.getIdTurno());
    	retorno.setDwTurno(turno);
    	
    	retorno.setTpId(filtro.getTpId());
    	
    	retorno.setComParadas(true);
    	return retorno;
     }
}
