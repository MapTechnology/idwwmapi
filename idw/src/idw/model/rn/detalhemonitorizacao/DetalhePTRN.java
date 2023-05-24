package idw.model.rn.detalhemonitorizacao;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.SemConfiguracaoException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwPasscau;
import idw.model.pojos.DwPassdef;
import idw.model.pojos.DwPassmon;
import idw.model.pojos.DwPasstf;
import idw.model.pojos.DwPasstfse;
import idw.model.pojos.DwPasstfsepm;
import idw.model.pojos.DwPasstfsepmView;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.model.rn.DataHoraRN;
import idw.model.rn.DiversosRN;
import idw.model.rn.NumeroSerieRN;
import idw.webservices.dto.AcaoDTO;
import idw.webservices.dto.DefeitoDTO;
import idw.webservices.dto.DetalheColetaDTO;
import idw.webservices.dto.DetalhePTDTO;
import idw.webservices.dto.DetalhePTGraficoTesteFuncionalDTO;
import idw.webservices.dto.DetalhePTSerieDTO;
import idw.webservices.dto.DetalhesColetasDTO;
import idw.webservices.dto.FiltroDetalhePTDTO;


@SuppressWarnings("unchecked")
public class DetalhePTRN extends DAOGenerico{

	/*
	 * MEtodo principal de retorno do detalhe do pt quando a tela for de rastreabilidade
	 */
	public DetalhePTDTO detalhePT(FiltroDetalhePTDTO filtro){
		DetalhePTDTO detalhe = new DetalhePTDTO();
		
		MapQuery q = new MapQuery(getSession());
		q.append("select a ");
		q.append("from DwPassagem a ");		
		q.append("join fetch a.dwNserie t ");
		q.append("join fetch a.omPt ompt ");

		/*
		q.append("left join fetch t.dwEst dwest ");
		q.append("left join fetch t.omProduto omproduto ");
		q.append("left join fetch a.dwPasstfs dwpasstf ");
		q.append("left join fetch dwpasstf.dwPasstfses dwpasstfse ");
		q.append("left join fetch a.dwPassmons b ");
		q.append("left join fetch t.dwPassagems c ");
		q.append("left join fetch c.dwEst dwestpass ");
		*/
		
		q.appendWhere(MapQuery._NULL, "b.omProduto.cdProduto=:cdComponente", filtro.getComponente() != null && filtro.getComponente().getCdProduto() != null && filtro.getComponente().getCdProduto().equals("") == false);
		q.appendWhere(MapQuery._AND, "a.dwEst.cdEst=:cdDestino", filtro.getDestino() != null && filtro.getDestino().getCdEst() != null && filtro.getDestino().getCdEst().equals("") == false);
		q.appendWhere(MapQuery._AND, "ompt.omGt.cdGt=:cdgt", filtro.getGt() != null && filtro.getGt().getCdGt()!= null && filtro.getGt().getCdGt().equals("") == false);
		q.appendWhere(MapQuery._AND, "a.omUsrByIdUsroperador.cdUsr=:cdusr", filtro.getOperador() != null && filtro.getOperador().getCdUsr() != null && filtro.getOperador().getCdUsr().equals("") == false);
		q.appendWhere(MapQuery._AND, "a.omUsrByIdUsrsupervisor.cdUsr=:cdusrSup", filtro.getSupervisor() != null && filtro.getSupervisor().getCdUsr() != null && filtro.getSupervisor().getCdUsr().equals("") == false);
		q.appendWhere(MapQuery._AND, "t.omProduto.omProgrp.cdProgrp=:cdprogrp", filtro.getPlataforma() != null && filtro.getPlataforma().getCdProgrp() != null && filtro.getPlataforma().getCdProgrp().equals("") == false);
		q.appendWhere(MapQuery._AND, "t.omProduto.cdProduto=:cdproduto", filtro.getProduto() != null && filtro.getProduto().getCdProduto() != null && filtro.getProduto().getCdProduto().equals("") == false);
		q.appendWhere(MapQuery._AND, "t.ns between :inicio and :fim", filtro.getNrSerieInicial() != null && filtro.getNrSerieInicial().equals("") == false && filtro.getNrSerieFinal() != null && filtro.getNrSerieFinal().equals("") == false);
		q.appendWhere(MapQuery._AND, "ompt.stAtivo = 1 and ompt.cdPt=:cdpt", filtro.getPt() != null && filtro.getPt().getCdPt()!=null && filtro.getPt().getCdPt().equals("") == false);
		q.appendWhere(MapQuery._AND, "ompt.omTppt.cdTppt=:cdtppt", filtro.getTppt() != null && filtro.getTppt().getCdTppt() != null && filtro.getTppt().getCdTppt().equals("") == false);

		// Obtem a lista de periodos do turno selecionado. O ideal seria obter a data de referencia e o turno em dwconsolid
		// Mas por algum bug as passagens não estao sendo associadas corretamente ao dwconsolid
		// e para a lista de passagens vim correta a lista abaixo vai ser montada
		q.appendWhere(MapQuery._AND, "exists (select id from DwConsolid id where id.tpId = 1", true);
		q.appendWhere(MapQuery._AND, "id.stAtivo is null", true);
		q.appendWhere(MapQuery._AND, "a.dthr between id.dthrIturno and id.dthrFturno", true);
		q.appendWhere(MapQuery._AND, "id.dtReferencia between :dtreferencia1 and :dtreferencia2", true);
		q.appendWhere(MapQuery._AND, "id = a.dwConsolid", true);
		q.appendWhere(MapQuery._AND, "id.dwTurno.idTurno = :idturno)", true);
		
		q.append(" order by a.dthr desc, a.msDthr DESC ");
		
		q.defineParametroData("dtreferencia1", filtro.getDtInicial());
		q.defineParametroData("dtreferencia2", filtro.getDtFinal());
		q.defineParametro("inicio", filtro.getNrSerieInicial());
		q.defineParametro("fim", filtro.getNrSerieFinal());
		if (filtro.getTurno() != null) q.defineParametro("idturno", filtro.getTurno().getIdTurno());
		if (filtro.getTppt() != null) q.defineParametro("cdtppt", filtro.getTppt().getCdTppt());
		if (filtro.getPt() != null) q.defineParametro("cdpt", filtro.getPt().getCdPt());
		if (filtro.getProduto() != null) q.defineParametro("cdproduto", filtro.getProduto().getCdProduto());
		if (filtro.getPlataforma() != null) q.defineParametro("cdprogrp", filtro.getPlataforma().getCdProgrp());
		if (filtro.getSupervisor() != null) q.defineParametro("cdusrSup", filtro.getSupervisor().getCdUsr());
		if (filtro.getOperador() != null) q.defineParametro("cdusr", filtro.getOperador().getCdUsr());
		if (filtro.getGt() != null) q.defineParametro("cdgt", filtro.getGt().getCdGt());
		if (filtro.getDestino() != null) q.defineParametro("cdDestino", filtro.getDestino().getCdEst());
		if (filtro.getComponente() != null) q.defineParametro("cdComponente", filtro.getComponente().getCdProduto());
		
		List<DwPassagem> listaPesquisa = null;
		try{
			listaPesquisa = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}
		List<DetalhePTSerieDTO> lista = new ArrayList<DetalhePTSerieDTO>();
		if (listaPesquisa != null){
			for (DwPassagem item : listaPesquisa) {
				addNrSerie(item.getDwNserie(), lista, item.getDwConsolid());
			}
		}
		DiversosRN rn = new DiversosRN();
		rn.setSession(this.getSession());
		OmCfg omCfg = null;
		try {
			omCfg = rn.pesquisaOmcfg();
		} catch (SemConfiguracaoException e){
			detalhe.getResultado().setIdmensagem(detalhe.getResultado().getSEM_CONFIGURACAO());
		}
		detalhe.setSeries(lista);
		if (omCfg != null) {
			detalhe.setOmCfg((OmCfg)omCfg.clone());
		}
		return detalhe;
	}

	public DetalhesColetasDTO detalhesColetas(long idSubetapa){
		DetalhesColetasDTO detalhes = new DetalhesColetasDTO();
		MapQuery q = new MapQuery(getSession());
		
		q.append("from DwPasstfsepmView dwpasstfsepm ");
		q.append("where dwpasstfsepm.dwPasstfse.idPasstfse = :idpasstfse ");
		q.append("order by dwpasstfsepm.dthrMedicao, dwpasstfsepm.msDthrmedicao ");
		
		q.defineParametro("idpasstfse", idSubetapa);


		List<DwPasstfsepmView> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		if (listaPesquisa != null){
			for (DwPasstfsepmView item : listaPesquisa) {
				addColeta(item, detalhes);
			}
		}

		return detalhes;
	}
	private void addColeta(DwPasstfsepmView item, DetalhesColetasDTO detalhes){
		DetalheColetaDTO detalhe = new DetalheColetaDTO();
		detalhe.setDthrColeta(item.getDthrMedicao());
		detalhe.setMsDthrColeta(item.getMsDthrmedicao().intValue());

		detalhe.setCorrente(item.getVlcorrente());
		detalhe.setTensao(item.getTensao());

		// Fluxo de entrada
		detalhe.setFluxoEntrada(item.getFluxoe().intValue());

		if (detalhe.getFluxoEntrada() == 1)
			detalhe.setDsFluxoEntrada("COM FLUXO");
		/*Alterado por amaury em 03.11.14 para que apareca o status do fluxo no detalhe da monitorizacao*/
		if (detalhe.getFluxoEntrada() == 2 ||detalhe.getFluxoEntrada() == 0 )
			detalhe.setDsFluxoEntrada("SEM FLUXO");
		if (detalhe.getFluxoEntrada() == 3)
			detalhe.setDsFluxoEntrada("COM FLUXO INICIO, SEM NO FIM");
		if (detalhe.getFluxoEntrada() == 4)
			detalhe.setDsFluxoEntrada("SEM FLUXO INICIO, COM NO FIM");

		// Fluxo de saida
		detalhe.setFluxoSaida(item.getFluxos().intValue());
		if (detalhe.getFluxoSaida() == 1)
			detalhe.setDsFluxoSaida("COM FLUXO");
		/*Alterado por amaury em 03.11.14 para que apareca o status do fluxo no detalhe da monitorizacao*/
		if (detalhe.getFluxoSaida() == 2 ||detalhe.getFluxoSaida() == 0 )
			detalhe.setDsFluxoSaida("SEM FLUXO");
		if (detalhe.getFluxoSaida() == 3)
			detalhe.setDsFluxoSaida("COM FLUXO INICIO, SEM NO FIM");
		if (detalhe.getFluxoSaida() == 4)
			detalhe.setDsFluxoSaida("SEM FLUXO INICIO, COM NO FIM");

		detalhes.addDetalhe(detalhe);
	}

	public DetalhePTSerieDTO detalheEtapasTeste(long idNSerie) {
		MapQuery q = new MapQuery(getSession());
		q.append("select dwnserie ");
		q.append("from DwNserie dwnserie ");
		q.append("left join fetch dwnserie.dwPassagemtf dwpassagemtf ");
		q.append("left join fetch dwpassagemtf.dwPasstfs dwpasstf ");
		q.append("left join fetch dwpasstf.dwPasstfses dwpasstfse ");
		q.append("where dwnserie.idNserie = :idnserie ");

		q.defineParametro("idnserie", idNSerie);
		q.query().setMaxResults(1);

		DwNserie dwnserie = (DwNserie) q.query().uniqueResult();

		DetalhePTSerieDTO retorno = new DetalhePTSerieDTO();
		if (dwnserie != null)
			retorno.setSerie(dwnserie.clone(false));
		if (dwnserie != null && dwnserie.getDwPassagemtf() != null) {
			retorno.getSerie().setDwPassagemtf(dwnserie.getDwPassagemtf().clone(true));
			retorno.getSerie().getDwPassagemtf().setDwPasstfs(new HashSet<DwPasstf>());
			for (DwPasstf dwpasstf : dwnserie.getDwPassagemtf().getDwPasstfs()) {
				DwPasstf dwpasstfclone = dwpasstf.clone(false);
				retorno.getSerie().getDwPassagemtf().getDwPasstfs().add(dwpasstfclone);
				for (DwPasstfse dwpasstfse : dwpasstf.getDwPasstfses()) {
					dwpasstfclone.getDwPasstfses().add(dwpasstfse.clone(false));
				}
			}
			retorno.setUltimaPassagem(retorno.getSerie().getDwPassagemtf());
		}
		return retorno;
	}
	
	
	private void addNrSerie(DwNserie nrSerie, List<DetalhePTSerieDTO> nrSeries, DwConsolid id){
		
		NumeroSerieRN rn = new NumeroSerieRN(getDao());
		
		boolean isExiste = false;
		
		for (DetalhePTSerieDTO item : nrSeries){
			if (nrSerie.getNs().equals(item.getSerie().getNs())){
				isExiste = true;
				break;
			}
		}
		
		if (isExiste == false){
			DwNserie nrSerieClone = (DwNserie)nrSerie.clone(false);
			DwConsol consol = id.getDwConsol();
			DwConsolpr consolpr = null;
			OmProduto omproduto = new OmProduto();
			try {
				consolpr = consol.getDwConsolprs().iterator().next();
				omproduto.copy(consolpr.getOmProduto(), false);
			} catch (NoSuchElementException e) {
				consolpr = null;
				if (nrSerie.getOmProduto() != null)
					omproduto.copy(nrSerie.getOmProduto(), false);
			}
			nrSerieClone.setOmProduto(omproduto);
			if (nrSerie.getDwEst() != null){
				DwEst dwest = (DwEst) nrSerie.getDwEst().clone();
				nrSerieClone.setDwEst(dwest);
			}
			DwPassagem ultimaPassagemClone = getUltimaPassagem(nrSerie);	
			DwPassagem ultimaPassagem = getDao().findById(DwPassagem.class, ultimaPassagemClone.getIdPassagem(), false);
			
			
			

			try {
				if (nrSerie.getDwPassagem() != null){
					Set<DwPassmon> mons = new HashSet<DwPassmon>();
					for (DwPassmon mon : nrSerie.getDwPassagem().getDwPassmons()){
						mons.add((DwPassmon)mon.clone());
					}
					nrSerieClone.setDwPassagem(nrSerie.getDwPassagem().clone(false));
					nrSerieClone.getDwPassagem().setOmPt(nrSerie.getDwPassagem().getOmPt().clone(false));
					
					if (nrSerie.getDwPassagem().getOmUsrByIdUsroperador() != null)
						nrSerieClone.getDwPassagem().setOmUsrByIdUsroperador(nrSerie.getDwPassagem().getOmUsrByIdUsroperador().clone(false));
					
					nrSerieClone.getDwPassagem().setDwPassmons(mons);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				Set<DwPassdef> defs = new HashSet<DwPassdef>();
				for (DwPassdef def : ultimaPassagem.getDwPassdefs()){
					DwPassdef passdef = (DwPassdef)def.clone(true);
					defs.add(passdef);
				}
				ultimaPassagemClone.setDwPassdefs(defs);
			} catch (Exception e) {
				e.printStackTrace();
			}	

			/*
			 * Obtem todas as correcoes feitas nos defeitos
			 */
			List<AcaoDTO> listaAcoes = obterCorrecoesDaNaoConformidades(nrSerie);
			
			
			DetalhePTSerieDTO detalheSerie = new DetalhePTSerieDTO();
			detalheSerie.setSerie(nrSerieClone);
			detalheSerie.setUltimaPassagem(ultimaPassagemClone);
			detalheSerie.setListaAcoes(listaAcoes);
			nrSeries.add(detalheSerie);
		}
	}
	
	private DwPassagem getUltimaPassagem(DwNserie nrSerie) {
		DwPassagem ultimaPassagemClone = null;

		for (DwPassagem passagem : nrSerie.getDwPassagems()){

			if (ultimaPassagemClone == null){
				ultimaPassagemClone = passagem;
			}
		
			Date dthrUltima = DataHoraRN.getDataComMilisegundos(ultimaPassagemClone.getDthr(), ultimaPassagemClone.getMsDthr());
			Date dthrPassagem = DataHoraRN.getDataComMilisegundos(passagem.getDthr(), passagem.getMsDthr());
			if (DataHoraRN.before(dthrUltima, dthrPassagem)){
				ultimaPassagemClone = passagem;
			}
		}
		
		ultimaPassagemClone = ultimaPassagemClone.clone(false);
		
		return ultimaPassagemClone;
	}

	/* Metodo que retorna o historico de determinado NS
	 * 
	 */
	public DwNserie getHistoricoNS(String cb) {
		return getHistoricoNS(cb, new HashMap<String, DwNserie>(), true);
	}
	// Metodo de apoio para a recursividade
	private DwNserie getHistoricoNS(String cb, HashMap<String, DwNserie> desconsiderar, boolean isObterProdutosMontadosAbaixo) {
		
		DwNserie retorno = null;

		NumeroSerieRN rn = new NumeroSerieRN(getDao());
		DwNserie nrSerie;
		try {
			nrSerie = rn.getDwNserieCb(cb);
		} catch (NumeroSerieIrregularException e1) {
			nrSerie = null;
		}
		if (nrSerie == null) {
			retorno = new DwNserie();
			return retorno;
		}
		
		retorno = nrSerie.clone(false);
		
		try {
			/*
			 * Obtem todas as passagens do CB
			 */
			Set<DwPassagem> passagems = new HashSet<DwPassagem>();
			for (DwPassagem passagem : nrSerie.getDwPassagems()){
				
				// Verifica se a passagem já esta na lista
				boolean isExiste = false;
				for (DwPassagem passAux : passagems) {
					if (passAux.getIdPassagem() == passagem.getIdPassagem()) {
						isExiste = true;
						break;
					}
				}
				if (isExiste)
					continue;
				
				DwPassagem pas = (DwPassagem)passagem.clone(false);
				if (passagem.getDwEst() != null)
					pas.setDwEst(passagem.getDwEst().clone(false));
				
				pas.setDwNserie(passagem.getDwNserie().clone(false));
				
				pas.setOmPt(passagem.getOmPt().clone(false));
				pas.getOmPt().setOmTppt(passagem.getOmPt().getOmTppt().clone(false));
				pas.setDwConsolid(passagem.getDwConsolid().clone(false));
				
				if (passagem.getOmUsrByIdUsroperador() != null)
					pas.setOmUsrByIdUsroperador(passagem.getOmUsrByIdUsroperador().clone(false));
				
				passagems.add(pas);
			}
			retorno.getDwPassagems().addAll(passagems);
			
			
			
			/* Obter a lista das montagens realizadas no NS ou as quais o NS participou como parte recursivamente
			 */
			List<DwPassmon> todasMontagens = rn.obtemTodasAsMontagensEAsqueParticipou(nrSerie.getCb(), isObterProdutosMontadosAbaixo);
			for (DwPassmon mon : todasMontagens) {
				DwNserie nserieMontado;
				try {
					if (nrSerie.getCb().equals(mon.getCb())) {
						// Se for igual eh pq o passmon eh do produto em que esse CB foi montado
						nserieMontado = rn.getDwNserieCb(mon.getDwPassagem().getDwNserie().getCb());
					} else
						nserieMontado = rn.getDwNserieCb(mon.getCb());
				} catch (NumeroSerieIrregularException e) {
					nserieMontado = null;
				}
				if (nserieMontado != null && desconsiderar.containsKey(nserieMontado.getCb().trim()) == false) {
					desconsiderar.put(nrSerie.getCb().trim(), nrSerie);
					DwNserie nsHist = getHistoricoNS(nserieMontado.getCb(), desconsiderar, false);
					
					
					// Adicionar apenas os que não existirem
					for (DwPassagem passAux : nsHist.getDwPassagems()) {
						boolean isExiste = false;
						
						for (DwPassagem passRet : retorno.getDwPassagems()) {
							if (passRet.getIdPassagem() == passAux.getIdPassagem()) {
								isExiste = true;
								break;
							}
						}
						if (isExiste == false)
							retorno.getDwPassagems().add(passAux);
						
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	private List<AcaoDTO> obterCorrecoesDaNaoConformidades(DwNserie nrSerie){
		List<AcaoDTO> retorno = new ArrayList<>();
		MapQuery q = new MapQuery(getSession());
		
		q.append("select distinct a");
		q.append("from DwPassagem a");
		q.append("join a.dwPasscaus b");
		q.append("join a.dwNserie c");
		q.append("where a.dwNserie = :dwnserie");
		
		q.defineParametro("dwnserie", nrSerie);
		
		List<DwPassagem> lista = q.list();
		for (DwPassagem passagem : lista) {
			for (DwPasscau cau : passagem.getDwPasscaus()) {
				DefeitoDTO defeito = new DefeitoDTO();
				defeito.setCb(passagem.getDwNserie().getCb());
				defeito.setIdNserie(passagem.getDwNserie().getIdNserie());
				defeito.setIdPassagem(passagem.getIdPassagem());
				defeito.setIdPassdef(0l);
				defeito.setIdPt(passagem.getOmPt().getIdPt());
				defeito.setIdTAcao(cau.getDwTAcao().getIdTacao());
				defeito.setIdTDefeito(cau.getDwTDefeito().getIdTdefeito());
				defeito.setIdTppt(passagem.getOmPt().getOmTppt().getIdTppt());
				defeito.setCdPt(passagem.getOmPt().getCdPt() + "-" + passagem.getOmPt().getDsPt());
				defeito.setCdAcao(cau.getDwTAcao().getCdTacao() + "-" + cau.getDwTAcao().getDsTacao());
				defeito.setCdDefeito(cau.getDwTDefeito().getCdTdefeito() + "-" + cau.getDwTDefeito().getDsTdefeito());
				defeito.setDthrAcao(null);
				defeito.setPosicoes(cau.getDsPosicaomecanica());
				defeito.setDthrDefeito(passagem.getDthr());
				if (passagem.getOmUsrByIdUsroperador() != null)
					defeito.setLogin(passagem.getOmUsrByIdUsroperador().getDsNome());
				defeito.setDsTppt(passagem.getOmPt().getOmTppt().getCdTppt() + "-" + passagem.getOmPt().getOmTppt().getDsTppt());
				
				AcaoDTO dto = new AcaoDTO();
				dto.setCb(defeito.getCb());
				dto.setDefeito(defeito);
				dto.setIdPt(defeito.getIdPt());
				dto.setIdTAcao(defeito.getIdTAcao());
				dto.setIdTppt(defeito.getIdTppt());
				retorno.add(dto);
			}
		}
		return retorno;
	}
	
	public DetalhePTGraficoTesteFuncionalDTO getGraficoTesteFuncional(FiltroDetalhePTDTO filtro){
		DetalhePTGraficoTesteFuncionalDTO detalhe = new DetalhePTGraficoTesteFuncionalDTO();
		
		String hql="";
		hql += "select a ";
		hql += "from DwPasstfsepm a ";		
		hql += "join fetch a.dwPasstfse t ";
		hql += "join fetch t.dwPasstf b ";
		hql += "join fetch b.dwPassagem c ";
		hql += "where 1=1 ";

		if (filtro.getPassagem() != null){
			try {
				String idPassagem = String.valueOf(filtro.getPassagem().getIdPassagem());
				if (!idPassagem.equals("")){
					hql += "AND c.idPassagem=" + idPassagem + " ";
				}
			} catch (Exception e) {				
			}			
		}
		
		
		hql += " order by a.dthrMedicao, a.msDthrmedicao ";
		
		Query q = getSession().createQuery(hql);

		List<DwPasstfsepm> listaPesquisa = null;
		try{
			listaPesquisa = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		DiversosRN rn = new DiversosRN();
		rn.setSession(this.getSession());
		try {
			rn.pesquisaOmcfg();
		} catch (SemConfiguracaoException e){
			detalhe.getResultado().setIdmensagem(detalhe.getResultado().getSEM_CONFIGURACAO());
			return detalhe;
		}
		
		List<DwPasstfsepm> lista = new ArrayList<DwPasstfsepm>();

		if (listaPesquisa != null){
			for (DwPasstfsepm item : listaPesquisa) {
				lista.add(item.clone());
			}
		}
		
		detalhe.setMedicoes(lista);
		
		return detalhe;
	}
}

