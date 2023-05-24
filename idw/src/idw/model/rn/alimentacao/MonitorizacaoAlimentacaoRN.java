package idw.model.rn.alimentacao;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwConsolidDAO;
import idw.model.dao.DwRtDAO;
import idw.model.dao.MapQuery;
import idw.model.dao.OmpaproDao;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRt;
import idw.model.pojos.OmMapa;
import idw.model.pojos.OmMapapa;
import idw.model.pojos.OmPapro;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.FolhaRN;
import idw.webservices.dto.MonitorizacaoAlimDTO;
import idw.webservices.dto.MonitorizacaoCheckFeederDTO;
import idw.webservices.dto.MonitorizacoesAlimsDTO;
import idw.webservices.dto.MonitorizacoesCheckFeederDTO;
import idw.webservices.dto.PTsDTO;
import idw.webservices.dto.PtDTO;

public class MonitorizacaoAlimentacaoRN extends AbstractRN<DAOGenerico> {

	public Map<String, BigDecimal> ciclosPts = new HashMap<String, BigDecimal>();

	public MonitorizacaoAlimentacaoRN() {
		super(new DAOGenerico());
	}

	public MonitorizacaoAlimentacaoRN(DAOGenerico dao) {
		super(dao);
	}

	public MonitorizacoesAlimsDTO monitorizacaoAlimentacao(String cdPt, boolean isMaisDeUmProduto){
		MonitorizacoesAlimsDTO retorno = null;
		
		if(isMaisDeUmProduto){
			retorno = getListaOmPaproComMaisDeUmProduto();
		}else{
			retorno = getListaOmPapro();
		}
		
		if (cdPt != null && !cdPt.isEmpty()) {
			
			List<MonitorizacaoAlimDTO> lista = new ArrayList<MonitorizacaoAlimDTO>();
			
			for(MonitorizacaoAlimDTO dto : retorno.getOmpaproList()){
				if(cdPt.equals(dto.getOmpapro().getOmPt().getCdPt())){
					lista.add(dto);
				}
			}
			
			retorno.setOmpaproList(lista);

		}
		return retorno;
	}


	private MonitorizacoesAlimsDTO getListaOmPapro() {

		Map<String, Long> mapCavAtivDoPt = new HashMap<String, Long>();

		MonitorizacoesAlimsDTO retorno = new MonitorizacoesAlimsDTO();

		OmpaproDao ompaproDao = new OmpaproDao(getDaoSession());

		List<OmPapro> listaOmPapros = ompaproDao.getTodosProdutosDoPa();

		List<MonitorizacaoAlimDTO> listaMonitorizacao = new ArrayList<MonitorizacaoAlimDTO>();
		if (listaOmPapros != null) {
			for (OmPapro omPaPro : listaOmPapros) {
				
				if (isProdutoConsumido(omPaPro)) {
					MonitorizacaoAlimDTO monitorizacaoCheck = criarItemMonitorizacaoAlimDTO(mapCavAtivDoPt, omPaPro);	
					listaMonitorizacao.add(monitorizacaoCheck);
				}
				
			}
		}

		ordenarListaPelaPrevisaoTermino(listaMonitorizacao);

		retorno.setOmpaproList(listaMonitorizacao);

		return retorno;

	}

	private MonitorizacaoAlimDTO criarItemMonitorizacaoAlimDTO(Map<String, Long> mapCavAtivDoPt, OmPapro omPaPro) {
		MonitorizacaoAlimDTO monitorizacaoCheck = new MonitorizacaoAlimDTO();

		OmPapro omPaproRetorno = omPaPro.clone(false);
		omPaproRetorno.setOmMapapa(new OmMapapa());
		omPaproRetorno.getOmMapapa().setOmMapa((OmMapa) omPaPro.getOmMapapa().getOmMapa().clone(false));
		omPaproRetorno.setOmPa(omPaPro.getOmPa().clone(false));
		omPaproRetorno.setOmProduto(omPaPro.getOmProduto().clone(false));
		omPaproRetorno.setOmPt(omPaPro.getOmPt().clone(false));

		monitorizacaoCheck.setOmpapro(omPaproRetorno);

		BigDecimal cicloPadrao = getCicloPadrao(omPaPro.getOmPt());
		monitorizacaoCheck.setCicloPadrao(cicloPadrao.doubleValue());

		BigDecimal qtUsadaPorCiclo = ObjectUtils.defaultIfNull(omPaPro.getOmMapapa().getQtUsada(), BigDecimal.ONE);
		
		if (qtUsadaPorCiclo.intValue() == 0)
			qtUsadaPorCiclo = BigDecimal.ONE;

		long qtCicloRestante = calcularQtCiclosRestantes(omPaPro.getQtAtual(), qtUsadaPorCiclo);

		monitorizacaoCheck.setQtCicloRestante(qtCicloRestante);

		long previsaoTermino = calcularPrevisaoTermino(cicloPadrao, qtCicloRestante);
		monitorizacaoCheck.setPrevisaoTermino(previsaoTermino);

		long qtProduzidaPorCiclo = getQtProduzidaPorCicloDoPt(mapCavAtivDoPt, omPaPro.getOmPt().getCdPt());
		long produtosRestantes = calcularProdutosRestantes(qtCicloRestante, qtProduzidaPorCiclo);

		monitorizacaoCheck.setQtProdutoRestante(produtosRestantes);
		return monitorizacaoCheck;
	}

	/* Substituida por getTodosPtsComAlimentacao */
	@Deprecated
	public PTsDTO getTodosPtsEmOmPapro(){
		PTsDTO retorno = new PTsDTO();
		retorno.setPts(new ArrayList<PtDTO>());
		OmpaproDao paproDAO = new OmpaproDao(getDaoSession());
		List<OmPapro> listaPapros = paproDAO.getTodosProdutosDoPa();
		
		Map<Long, OmPt> mapPts = new HashMap<Long, OmPt>();
		
		for(OmPapro papro : listaPapros){
			OmPt pt = mapPts.get(papro.getOmPt().getIdPt());
			if(pt == null){
				mapPts.put(papro.getOmPt().getIdPt(), papro.getOmPt());
				PtDTO dto = new PtDTO();
				dto.setPt(papro.getOmPt().clone(false));
				retorno.getPts().add(dto);
			}
		}
		return retorno;
	}

	// Objetivo retornar a lista de pts que tem alimentacao. Esses pts serao mostrados na GUI de onitorizacao
	public PTsDTO getTodosPtsComAlimentacao(){
		PTsDTO retorno = new PTsDTO();
		retorno.setPts(new ArrayList<PtDTO>());
		
		List<OmPt> lista = getOmPtComAlimentacao();
		
		for (OmPt ompt : lista) {
			PtDTO dto = new PtDTO();
			dto.setPt(ompt.clone(false));
			dto.getPt().setOmGt(ompt.getOmGt().clone(false));
			retorno.getPts().add(dto);
		}
		

		return retorno;
	}
	
	public List<OmPt> getOmPtComAlimentacao() {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select distinct ompt");
		q.append("from OmAlim a");
		q.append("join a.omMapa b");
		q.append("join b.omPt ompt");
		q.append("where a.tpAlim = 3");
		q.append("and a.stAlim = 1");
		q.append("and ompt.stAtivo = 1");
		
		List<OmPt> lista = q.list();
		
		return lista;
	}

	
	private MonitorizacoesAlimsDTO getListaOmPaproComMaisDeUmProduto() {
	
		MonitorizacoesAlimsDTO monitorizacao = getListaOmPapro();	
		
		List<MonitorizacaoAlimDTO> monitList = new ArrayList<MonitorizacaoAlimDTO>();
		
		MonitorizacoesAlimsDTO listaFinal = new MonitorizacoesAlimsDTO();

		Map<String, List<MonitorizacaoAlimDTO>> mapOmPaprosRepetidos = new HashMap<String, List<MonitorizacaoAlimDTO>>();
	
		ArrayList<MonitorizacaoAlimDTO> monitorizacaoListPrincipal = (ArrayList<MonitorizacaoAlimDTO>) monitorizacao.getOmpaproList();

		montarMapAgrupandoPA(mapOmPaprosRepetidos, monitorizacaoListPrincipal);	
		
		for (Map.Entry<String, List<MonitorizacaoAlimDTO>>entry : mapOmPaprosRepetidos.entrySet()) {
			
			double mediaCiclosPadra = 0;
			int quantidadeDeElementos = 0;
			
			MonitorizacaoAlimDTO monit = new MonitorizacaoAlimDTO();	
			OmPapro omPapro = new OmPapro()	;
			
			
			for(int i = 0; i < entry.getValue().size(); i++){		
				
				MonitorizacaoAlimDTO monitorizacaoAlimDTO = entry.getValue().get(i);
				
				omPapro.setIdPapro(monitorizacaoAlimDTO.getOmpapro().getIdPapro());

				omPapro.setOmPa(monitorizacaoAlimDTO.getOmpapro().getOmPa());
				
				OmMapapa omMapapaDoDTO = monitorizacaoAlimDTO.getOmpapro().getOmMapapa();
				
				if(i == 0) {
					omPapro.setOmMapapa(omMapapaDoDTO);
					omPapro.setOmProduto(monitorizacaoAlimDTO.getOmpapro().getOmProduto());
					omPapro.setQtAtual(monitorizacaoAlimDTO.getOmpapro().getQtAtual());
				} else {
					if(!omPapro.getOmMapapa().getOmMapa().getCdMapa().contains(omMapapaDoDTO.getOmMapa().getCdMapa())) {
						omPapro.getOmMapapa().getOmMapa().setCdMapa(omPapro.getOmMapapa().getOmMapa().getCdMapa() + "," + omMapapaDoDTO.getOmMapa().getCdMapa());
					}
					if(omPapro.getOmProduto() != null && 
							omPapro.getOmProduto().getCdProduto().contains(monitorizacaoAlimDTO.getOmpapro().getOmProduto().getCdProduto()) == false) {						
						omPapro.getOmProduto().setCdProduto(omPapro.getOmProduto().getCdProduto() + "," + monitorizacaoAlimDTO.getOmpapro().getOmProduto().getCdProduto());
					}
					omPapro.setQtAtual(new BigDecimal(omPapro.getQtAtual().intValue()+monitorizacaoAlimDTO.getOmpapro().getQtAtual().intValue()));
				}
				
				omPapro.setOmPt(monitorizacaoAlimDTO.getOmpapro().getOmPt());
				
								
				monit.setPrevisaoTermino(monit.getPrevisaoTermino() + monitorizacaoAlimDTO.getPrevisaoTermino());
				monit.setQtCicloRestante(monit.getQtCicloRestante() + monitorizacaoAlimDTO.getQtCicloRestante());
				monit.setQtProdutoRestante(monit.getQtProdutoRestante() + monitorizacaoAlimDTO.getQtProdutoRestante());
				
				mediaCiclosPadra = mediaCiclosPadra + monitorizacaoAlimDTO.getCicloPadrao();
				quantidadeDeElementos = i;
				
			}
				
			monit.setCicloPadrao(mediaCiclosPadra / (quantidadeDeElementos + 1));
			mediaCiclosPadra = 0;
			quantidadeDeElementos = 0;

			monit.setOmpapro(omPapro);

			monitList.add(monit);
			    
		}
			
		ordenarListaPelaPrevisaoTermino(monitList);
		listaFinal.setOmpaproList(monitList);

		return listaFinal;

	}

	private void montarMapAgrupandoPA(Map<String, List<MonitorizacaoAlimDTO>> mapOmPaprosRepetidos,
			ArrayList<MonitorizacaoAlimDTO> monitorizacaoListPrincipal) {
		for (MonitorizacaoAlimDTO monitorizacaoAlimDTO : monitorizacaoListPrincipal) {
			String cdPa = monitorizacaoAlimDTO.getOmpapro().getOmPa().getCdPa();
			List<MonitorizacaoAlimDTO> listMonitorizacaoAlimDTO = mapOmPaprosRepetidos.get(cdPa);
		
			if(listMonitorizacaoAlimDTO == null){
				listMonitorizacaoAlimDTO = new ArrayList<MonitorizacaoAlimDTO>();
				mapOmPaprosRepetidos.put(cdPa, listMonitorizacaoAlimDTO);
			}
			
			listMonitorizacaoAlimDTO.add(monitorizacaoAlimDTO);
					
		}
	}

	public MonitorizacoesCheckFeederDTO getListaMonitorizacaoCheckFeeder(String cdPt) {

		Map<String, Long> mapCavAtivDoPt = new HashMap<String, Long>();

		OmpaproDao ompaproDao = new OmpaproDao(getDaoSession());

		List<OmPapro> listaOmPapros = ompaproDao.getTodosProdutosDoPaDoPt(cdPt);

		List<MonitorizacaoCheckFeederDTO> monitorizacao = new ArrayList<MonitorizacaoCheckFeederDTO>();

		MonitorizacoesCheckFeederDTO monitorizacoes = new MonitorizacoesCheckFeederDTO();

		if (listaOmPapros != null) {
			for (OmPapro omPaPro : listaOmPapros) {
				if (isProdutoConsumido(omPaPro)) {
					MonitorizacaoAlimDTO monitAlimDTO = criarItemMonitorizacaoAlimDTO(mapCavAtivDoPt, omPaPro);
					MonitorizacaoCheckFeederDTO monitorizacaoCheckFeeder = criarMonitorizacaoCheckFeederDTO(monitAlimDTO);
					monitorizacao.add(monitorizacaoCheckFeeder);
				}
			}

		}
		
		ordenarListaPelaPrevisaoTerminoCheckFeeder(monitorizacao);
		monitorizacoes.setMonitorizacoesCheckFeederList(monitorizacao);

		return monitorizacoes;

	}

	private boolean isProdutoConsumido(OmPapro omPapro) {
		OmProduto omProduto = omPapro.getOmProduto();
		return omProduto != null && ObjectUtils.defaultIfNull(omProduto.getIsConsumido(), Boolean.TRUE);
	}
	
	private MonitorizacaoCheckFeederDTO criarMonitorizacaoCheckFeederDTO(MonitorizacaoAlimDTO monitAlimDTO) {
		MonitorizacaoCheckFeederDTO monitorizacaoCheckFeeder = new MonitorizacaoCheckFeederDTO();
		OmPapro omPapro = monitAlimDTO.getOmpapro();
		monitorizacaoCheckFeeder.setCdPt(omPapro.getOmPt().getCdPt());
		monitorizacaoCheckFeeder.setCdPa(omPapro.getOmPa().getCdPa());
		monitorizacaoCheckFeeder.setMapapa(omPapro.getOmMapapa().getOmMapa().getCdMapa());
		monitorizacaoCheckFeeder.setOmpt(omPapro.getOmProduto().getCdProduto());
		monitorizacaoCheckFeeder.setCicloPadra(monitAlimDTO.getCicloPadrao());
		monitorizacaoCheckFeeder.setQtd(ObjectUtils.defaultIfNull(omPapro.getQtAtual(), BigDecimal.ZERO).intValueExact());
		monitorizacaoCheckFeeder.setCicloRestante(monitAlimDTO.getQtCicloRestante());
		monitorizacaoCheckFeeder.setPrevisaoTermino(monitAlimDTO.getPrevisaoTermino());
		monitorizacaoCheckFeeder.setPrevisaoTermino(monitAlimDTO.getQtProdutoRestante());
		return monitorizacaoCheckFeeder;
	}

	private long getQtProduzidaPorCicloDoPt(Map<String, Long> mapCavAtivaDoPt,
			String cdPt) {
		Long cavAtiva = mapCavAtivaDoPt.get(cdPt);
		if (cavAtiva == null) {
			cavAtiva = getQtProduzidaPorCicloDoPt(cdPt);
			mapCavAtivaDoPt.put(cdPt, cavAtiva);
		}
		return cavAtiva;
	}

	private long getQtProduzidaPorCicloDoPt(String cdPt) {
		DwRtDAO dwRtDAO = new DwRtDAO(this.getDaoSession());

		long retorno = 1l;
		DwRt dwRt = dwRtDAO.getUltimoDwRtDoCdPt(cdPt);
		if (dwRt != null) {
			FolhaRN folhaRN = new FolhaRN(this.getDao());

			DwFolha dwFolha = folhaRN.getDwFolhaAtiva(dwRt.getPpCp());

			retorno = folhaRN.getPcsPorCicloAtivasNaoEncontrandoAssumeUm(
					dwFolha).longValue();

		}
		return retorno;
	}

	private void ordenarListaPelaPrevisaoTermino(
			List<MonitorizacaoAlimDTO> listaMonitorizacao) {

		Collections.sort(listaMonitorizacao,
				new Comparator<MonitorizacaoAlimDTO>() {
					@Override
					public int compare(MonitorizacaoAlimDTO o1,
							MonitorizacaoAlimDTO o2) {
						return Long.compare(o1.getPrevisaoTermino(),
								o2.getPrevisaoTermino());

					}
				});

	}
	
	private void ordenarListaPelaPrevisaoTerminoCheckFeeder(
			List<MonitorizacaoCheckFeederDTO> listaMonitorizacao) {

		Collections.sort(listaMonitorizacao,
				new Comparator<MonitorizacaoCheckFeederDTO>() {
					@Override
					public int compare(MonitorizacaoCheckFeederDTO o1,
							MonitorizacaoCheckFeederDTO o2) {
						return Long.compare(o1.getPrevisaoTermino(),
								o2.getPrevisaoTermino());

					}
				});

	}

	protected long calcularProdutosRestantes(long qtCiclosRestantes,
			long qtProduzidaPorCiclo) {
		return qtCiclosRestantes * qtProduzidaPorCiclo;
	}

	protected long calcularQtCiclosRestantes(BigDecimal qtAtual, BigDecimal qtUsadaPorCiclo) {
		if (qtAtual != null && qtUsadaPorCiclo != null && qtAtual.compareTo(BigDecimal.ZERO) > 0 && qtAtual.compareTo(qtUsadaPorCiclo) >= 0 && qtUsadaPorCiclo.compareTo(BigDecimal.ZERO) > 0 ) {
			return qtAtual.divide(qtUsadaPorCiclo, MathContext.DECIMAL32).longValue();
		} else {
			return 0L;
		}
	}

	protected long calcularPrevisaoTermino(BigDecimal cicloPadrao, long qtCiclosRestantes) {

		long previsaoTermino = 0L;
		
		if (cicloPadrao.compareTo(BigDecimal.ZERO) >= 0 && qtCiclosRestantes > 0) {
			previsaoTermino = cicloPadrao.multiply(new BigDecimal(qtCiclosRestantes)).longValue();
		}

		return previsaoTermino;
	}

	protected BigDecimal getCicloPadrao(OmPt omPt) {

		BigDecimal cicloPadrao = ciclosPts.get(omPt.getCdPt());

		if (cicloPadrao == null) {
			DwConsolidDAO dwConsolidDAO = new DwConsolidDAO(getDaoSession());
			DwConsolid dwConsolid = dwConsolidDAO.getUltimoDwConsolid(omPt,
					DwConsolidTemplate.TpId.TURNO);

			ConsolidaRN consolidaRN = new ConsolidaRN(this.getDao());

			cicloPadrao = BigDecimal.ZERO;

			if (dwConsolid != null) {
				try {
					cicloPadrao = consolidaRN.getCicloPadrao(omPt,
							dwConsolid.getDwFolha());
				} catch (SemCicloPadraoException e) {
				}
			}

			ciclosPts.put(omPt.getCdPt(), cicloPadrao);

		}

		return cicloPadrao;

	}

}
