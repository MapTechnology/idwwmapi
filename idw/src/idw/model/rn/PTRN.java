package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.dao.OmCcDAO;
import idw.model.dao.OmGtDAO;
import idw.model.dao.OmMapaDAO;
import idw.model.dao.OmPtDAO;
import idw.model.dao.OmPtcncDAO;
import idw.model.dao.OmTpptDAO;
import idw.model.dao.OmUsrDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.excessoes.TipoPostoDesconhecidoException;
import idw.model.excessoes.UsuarioDesconhecidoException;
import idw.model.pojos.DwCalpt;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.DwRotapassoPt;
import idw.model.pojos.MsUp;
import idw.model.pojos.OmAlim;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgurl;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmHomopt;
import idw.model.pojos.OmMapa;
import idw.model.pojos.OmPa;
import idw.model.pojos.OmPrgpos;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmPtPa;
import idw.model.pojos.OmPtPaEspelho;
import idw.model.pojos.OmPtPaMapa;
import idw.model.pojos.OmPtcnc;
import idw.model.pojos.OmPtcp;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.OmPtTemplate;
import idw.util.UtilsString;
import idw.webservices.dto.HomologacaoDTO;
import idw.webservices.dto.HomologacoesDTO;
import idw.webservices.dto.OmPtcncDTO;
import idw.webservices.dto.OmPtcncsDTO;
import idw.webservices.dto.PAsDTO;
import idw.webservices.dto.PTsDTO;
import idw.webservices.dto.PaDTO;
import idw.webservices.dto.PtDTO;
import idw.webservices.dto.WizPaDTO;
import idw.webservices.rest.idw.v2.dto.CalendarioPtDTO2;
import idw.webservices.rest.idw.v2.dto.CalendarioTurnoIntervaloDTO;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.ListaPTsDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;
import idw.webservices.rest.idw.v2.dto.PtDTO2; 
import injetws.model.pojos.PrConexoesInjet;
import injetws.model.pojos.PrUp;
import ms.model.rn.UpRN;

@SuppressWarnings("unchecked")
public class PTRN extends AbstractRN<DAOGenerico> implements IDao {

	public PTRN() {
		super(new DAOGenerico());
	}

	public PTRN(DAOGenerico dao) {
		super(dao);
	}

	public PTsDTO getOmPtAtivos() throws RegistroDesconhecidoException {
		PTsDTO retorno = new PTsDTO();
		List<PtDTO> listaPts = new ArrayList<PtDTO>();
		OmPtDAO ptDAO = new OmPtDAO(getDaoSession());
		List<OmPt> listaOmPt;
		
		listaOmPt = ptDAO.getOmPtsAtivosOrderByCd();
		
		if (listaOmPt == null) {
			throw new RegistroDesconhecidoException();
		}
		for (OmPt pt : listaOmPt) {
			PtDTO ptDTO = new PtDTO();
			ptDTO.setPt(pt.clone(false));
			ptDTO.getPt().setOmTppt(pt.getOmTppt().clone(false));

			listaPts.add(ptDTO);
		}
		retorno.setPts(listaPts);
		return retorno;
	}

	public PTsDTO getPtsSemCnc() throws RegistroDesconhecidoException {
		PTsDTO retorno = new PTsDTO();
		List<PtDTO> listaPtscnc = new ArrayList<PtDTO>();
		OmPtcncDAO ptDAO = new OmPtcncDAO(getDaoSession());
		List<OmPt> listaPtsSemCNC = ptDAO.getOmPtcAtivoSemCnc();
		for (OmPt pt : listaPtsSemCNC) {
			PtDTO dto = new PtDTO();
			dto.setPt(pt.clone(false));
			listaPtscnc.add(dto);
		}
		retorno.setPts(listaPtscnc);
		return retorno;
	}

	public DwRotapasso getOmPtDwRotapasso(DwRotapasso rotapasso)
			throws RegistroDesconhecidoException {
		DwRotapasso rotaP = new DwRotapasso();

		MapQuery query = new MapQuery(getDao().getSession());
		query.append("select t");
		query.append("from DwRotapasso t");
		query.append("join t.dwRota dwrota ");
		query.append("join t.dwRotapassoPts dwRotaPassoPt ");
		query.append("join dwRotaPassoPt.omPt pts ");
		query.append("join t.dwFolha dwFolha ");
		query.append("where dwFolha.stAtivo = 1 ");
		query.append("and dwFolha.idFolha =:idfolha ");
		query.append("and dwrota.idRota =:idrota ");

		query.defineParametro("idfolha", rotapasso.getDwFolha().getIdFolha());
		query.defineParametro("idrota", rotapasso.getDwRota().getIdRota());

		query.setMaxResults(1);
		DwRotapasso retorno = new DwRotapasso();
		rotaP = (DwRotapasso) query.uniqueResult();
		if (rotaP != null) {
			retorno = rotaP.clone();
			retorno.getDwRotapassoPts().clear();
			retorno.setDwRotapassoPts(new HashSet<DwRotapassoPt>(0));

			if (rotaP.getDwRotapassoPts() != null) {
				for (DwRotapassoPt rotaPassoPt : rotaP.getDwRotapassoPts()) {
					OmPt pt = new OmPt();
					pt = rotaPassoPt.getOmPt().clone();
					DwRotapassoPt rotaPassoPtNew = (DwRotapassoPt) rotaPassoPt
							.clone();
					rotaPassoPtNew.setOmPt(pt);
					retorno.getDwRotapassoPts().add(rotaPassoPtNew);
				}
			}
		}

		return retorno;
	}

	public OmPt getOmPtById(OmPt pt) {
		OmPt resultado = null;

		if ((pt != null) && (pt.getIdPt() != 0)) {
			String hql = "from OmPt t where t.idPt = ::idPt";
			hql = hql.replaceAll("::idPt", String.valueOf(pt.getIdPt()));
			Query q = this.getDaoSession().createQuery(hql);
			resultado = (OmPt) q.list().get(0);
		}

		return resultado;

	}

	public PTsDTO getPtsDTO(PtDTO filtro) {

		OmPtDAO ptDAO = new OmPtDAO(getDaoSession());
		List<OmPt> listaOmpt = ptDAO.getOmPts(filtro);

		List<PtDTO> lista = new ArrayList<PtDTO>();

		for (OmPt omPt : listaOmpt) {
			PtDTO pt = new PtDTO();

			// //
			// OmPtcncsDTO cncs = new OmPtcncsDTO();
			// cncs.setOmPtcncsDTO(new ArrayList<OmPtcncDTO>());
			// pt.setPtsCncs(cncs);

			pt.setPt(omPt.clone());
			pt.setPas(new PAsDTO());
			pt.setPtsCncs(new OmPtcncsDTO());

			/*
			 * Alessandre: removi a clonagem dos pas para o projeto da
			 * panasonic, pois estava dando outofmemory devia a uma
			 * recursividade, qdo for necessario reativar, corrigir o erro
			 */
			List<PaDTO> pas = new ArrayList<PaDTO>();
			for (OmPa item : omPt.getOmPas()) {
				if (item.getStAtivo() == 1) {
					PaDTO pa = new PaDTO();
					pa.setPa((OmPa) item.clone(false));

					pas.add(pa);
				}
			}
			pt.getPas().setPas(pas);

			List<OmPtcncDTO> cncs = new ArrayList<OmPtcncDTO>();
			for (OmPtcnc item : omPt.getOmPtcncsForIdPt()) {
				OmPtcncDTO cnc = new OmPtcncDTO();
				cnc.setOmPtcnc(item.clone());
				cncs.add(cnc);
			}
			pt.getPtsCncs().setOmPtcncsDTO(cncs);

			pt.setPasParaExclusao(new PAsDTO());
			pt.getPasParaExclusao().setPas(new ArrayList<PaDTO>());

			pt.setHomologacoes(new HomologacoesDTO());

			List<HomologacaoDTO> homologacoes = new ArrayList<HomologacaoDTO>();
			for (OmHomopt item : omPt.getOmHomopts()) {
				HomologacaoDTO homologacao = new HomologacaoDTO();
				homologacao.setHomologacaoPt((OmHomopt) item.clone(false));
				homologacao.getHomologacaoPt().setOmPt(item.getOmPt().clone(false));
				homologacao.getHomologacaoPt().getOmPt().setOmGt(item.getOmPt().getOmGt().clone(false));
				homologacao.getHomologacaoPt().getOmPt().setOmTppt(item.getOmPt().getOmTppt().clone(false));
				homologacao.getHomologacaoPt().setOmUsrByIdUsrhomologado(item.getOmUsrByIdUsrhomologado().clone(false));
				homologacao.getHomologacaoPt().getOmUsrByIdUsrhomologado().setOmUsrgrp(item.getOmUsrByIdUsrhomologado().getOmUsrgrp().clone());
				homologacoes.add(homologacao);
			}
			pt.getHomologacoes().setHomologacoesPt(homologacoes);
			
			/* Clonar os PAs espelho e mapas se existirem
			 * 
			 */
			if (pt.getPt().getOmPtPa() != null) {
				
				// Espelhos
				if (omPt.getOmPtPa().getOmPtPaEspelhos() != null) {
					pt.getPt().getOmPtPa().setOmPtPaEspelhos(new HashSet<OmPtPaEspelho>());
					for (OmPtPaEspelho espelho : omPt.getOmPtPa().getOmPtPaEspelhos()) {
						OmPtPaEspelho clone = espelho.clone();
						pt.getPt().getOmPtPa().getOmPtPaEspelhos().add(clone);
					}
				}
				
				// Mapas
				if (omPt.getOmPtPa().getOmPtPaMapas() != null) {
					pt.getPt().getOmPtPa().setOmPtPaMapas(new HashSet<OmPtPaMapa>());
					for (OmPtPaMapa mapa : omPt.getOmPtPa().getOmPtPaMapas()) {
						OmPtPaMapa clone = mapa.clone();
						pt.getPt().getOmPtPa().getOmPtPaMapas().add(clone);
					}
				}
			}
			
			
			
			
			
			
			pt.setResultadoEvento(0);
			lista.add(pt);
		}

		PTsDTO pts = new PTsDTO();
		pts.setPts(lista);
		return pts;
	}

	public PTsDTO getPtsDTOSemClonarFilhos(PtDTO filtro) {

		OmPtDAO ptDAO = new OmPtDAO(getDaoSession());
		List<OmPt> listaOmpt = ptDAO.getOmPts(filtro);

		List<PtDTO> lista = new ArrayList<PtDTO>();

		for (OmPt omPt : listaOmpt) {
			PtDTO pt = new PtDTO();
			pt.setPt(omPt.clone());

			pt.setResultadoEvento(0);
			lista.add(pt);
		}

		PTsDTO pts = new PTsDTO();
		pts.setPts(lista);
		return pts;
	}

	public PTsDTO getPtsDeGtDTO(PtDTO filtro) {
		PTsDTO pts = this.getPtsDTO(filtro);

		StringBuilder hql = new StringBuilder();

		hql.append("select t ");
		hql.append("from OmPt t ");
		hql.append("join fetch t.omObjs omobj ");
		hql.append("where  1=1 ");

		if (filtro.getPt().getIdPt() != null && filtro.getPt().getIdPt() != 0) {
			hql.append("AND t.idPt=:idPt ");
		} else {
			if ((filtro.getPt().getCdPt() != null)
					&& !filtro.getPt().getCdPt().equals("")) {
				hql.append("AND t.cdPt=:cdPt ");
			}
			if ((filtro.getPt().getDsPt() != null)
					&& !filtro.getPt().getDsPt().equals("")) {
				hql.append("AND t.dsPt=:dsPt ");
			}
			if ((filtro.getPt().getDsCurta() != null)
					&& !filtro.getPt().getDsCurta().equals("")) {
				hql.append("AND t.dsCurta=:dsCurta ");
			}
			if (filtro.getPt().getDtRevisao() != null) {
				hql.append("AND t.dtRevisao=:dtRevisao ");
			}
			if (filtro.getPt().getDtStativo() != null) {
				hql.append("AND t.dtStativo=:dtStativo ");
			}
			if ((filtro.getPt().getUrlConexao() != null)
					&& !filtro.getPt().getUrlConexao().equals("")) {
				hql.append("AND t.urlConexao=:urlConexao ");
			}
			if ((filtro.getPt().getDepara() != null)
					&& !filtro.getPt().getDepara().equals("")) {
				hql.append("AND t.dePara=:dePara ");
			}
			if ((filtro.getPt().getTpImpprog() != null)
					&& (filtro.getPt().getTpImpprog() < (byte) 3)) {
				hql.append("AND t.tpImpprog=:tpImpprog ");
			}
			if ((filtro.getPt().getOmGt() != null)
					&& (filtro.getPt().getOmGt().getIdGt() > 0)) {
				hql.append("AND omobj.omGtByIdGt.idGt = :idgt ");
			}

			if ((filtro.getPt().getOmCc() != null)
					&& !filtro.getPt().getOmCc().getCdCc().equals("")) {
				hql.append("AND t.omCc.cdCc=:cdCc ");
			}
			if ((filtro.getPt().getOmCc() != null)
					&& !filtro.getPt().getOmCc().getDsCc().equals("")) {
				hql.append("AND t.omCc.dsCc=:dsCc ");
			}
			if ((filtro.getPt().getOmTppt() != null)
					&& !filtro.getPt().getOmTppt().getCdTppt().equals("")) {
				hql.append("AND t.omTppt.cdTppt=:cdTppt ");
			}
			if ((filtro.getPt().getOmTppt() != null)
					&& !filtro.getPt().getOmTppt().getDsTppt().equals("")) {
				hql.append("AND t.omTppt.dsTppt=:dsTppt ");
			}
			if ((filtro.getPt().getOmUsrByIdUsrrevisao() != null)
					&& !filtro.getPt().getOmUsrByIdUsrrevisao().getCdUsr()
							.equals("")) {
				hql.append("AND t.omUsrByIdUsrrevisao.cdUsr=:cdUsrRev ");
			}
			if ((filtro.getPt().getOmUsrByIdUsrrevisao() != null)
					&& !filtro.getPt().getOmUsrByIdUsrrevisao().getDsNome()
							.equals("")) {
				hql.append("AND t.omUsrByIdUsrrevisao.dsNome=:dsNomeRev ");
			}
			if ((filtro.getPt().getOmUsrByIdUsrstativo() != null)
					&& !filtro.getPt().getOmUsrByIdUsrstativo().getCdUsr()
							.equals("")) {
				hql.append("AND t.omUsrByIdUsrstativo.cdUsr=:cdUsrSt ");
			}
			if ((filtro.getPt().getOmUsrByIdUsrstativo() != null)
					&& !filtro.getPt().getOmUsrByIdUsrstativo().getDsNome()
							.equals("")) {
				hql.append("AND t.omUsrByIdUsrstativo.dsNome=:dsNomeSt ");
			}
			if (filtro.getPt().getRevisao() == null) {
				hql.append("AND t.revisao = (SELECT max(tr.revisao) as Revisao from OmPt tr where tr.cdPt = t.cdPt ) ");
			} else {
				hql.append("AND t.revisao=:revisao ");
			}
			if ((filtro.getPt().getStAtivo() != null)
					&& (filtro.getPt().getStAtivo() < (byte) 2)) {
				hql.append("AND t.stAtivo=:stAtivo ");
			}
		}

		hql.append(" order by t.cdPt ");

		MapQuery q = new MapQuery(this.getDao().getSession()
				.createQuery(hql.toString()));

		if (filtro.getPt().getDtRevisao() != null) {
			q.defineParametroData("dtRevisao", filtro.getPt().getDtRevisao());
		}
		if (filtro.getPt().getDtStativo() != null) {
			q.defineParametroData("dtStativo", filtro.getPt().getDtStativo());
		}
		if (filtro.getPt().getOmGt() != null) {
			q.defineParametro("idgt", filtro.getPt().getOmGt().getIdGt());
			q.defineParametro("cdGt", filtro.getPt().getOmGt().getCdGt());
			q.defineParametro("dsGt", filtro.getPt().getOmGt().getDsGt());
		}
		if (filtro.getPt().getOmTppt() != null) {
			q.defineParametro("cdTppt", filtro.getPt().getOmTppt().getCdTppt());
			q.defineParametro("dsTppt", filtro.getPt().getOmTppt().getDsTppt());
		}
		if (filtro.getPt().getOmCc() != null) {
			q.defineParametro("cdCc", filtro.getPt().getOmCc().getCdCc());
			q.defineParametro("dsCc", filtro.getPt().getOmCc().getDsCc());
		}
		if (filtro.getPt().getOmUsrByIdUsrrevisao() != null) {
			q.defineParametro("cdUsrRev", filtro.getPt()
					.getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getPt()
					.getOmUsrByIdUsrrevisao().getDsNome());
		}
		if (filtro.getPt().getOmUsrByIdUsrstativo() != null) {
			q.defineParametro("cdUsrSt", filtro.getPt()
					.getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getPt()
					.getOmUsrByIdUsrstativo().getDsNome());
		}
		if (filtro.getPt().getRevisao() != null) {
			q.defineParametro("revisao", filtro.getPt().getRevisao());
		}

		if (filtro.getPt().getStAtivo() != null) {
			q.defineParametro("stAtivo", filtro.getPt().getStAtivo());
		}

		if (filtro.getPt() != null) {
			q.defineParametro("idPt", filtro.getPt().getIdPt());
			q.defineParametro("cdPt", filtro.getPt().getCdPt());
			q.defineParametro("dsPt", filtro.getPt().getDsPt());
			q.defineParametro("dsCurta", filtro.getPt().getDsCurta());
			q.defineParametro("urlConexao", filtro.getPt().getUrlConexao());
			q.defineParametro("dePara", filtro.getPt().getDepara());
			q.defineParametro("tpImpprog", filtro.getPt().getTpImpprog());
		}
		List<OmPt> listaOmpt = null;

		listaOmpt = q.query().list();

		List<PtDTO> lista = pts.getPts();
		if (lista == null) {
			lista = new ArrayList<PtDTO>();
		}

		for (OmPt omPt : listaOmpt) {
			// Se o pt ja estiver na lista, desconsiderar
			boolean isExiste = false;
			for (PtDTO ptlista : lista) {
				if (ptlista.getPt().getIdPt().equals(omPt.getIdPt())) {
					isExiste = true;
					break;
				}
			}
			if (isExiste == true) {
				continue;
			}

			PtDTO pt = new PtDTO();
			pt.setPt(omPt.clone());
			pt.setPas(new PAsDTO());

			List<PaDTO> pas = new ArrayList<PaDTO>();
			for (OmPa item : omPt.getOmPas()) {
				if (item.getStAtivo() == 1) {
					PaDTO pa = new PaDTO();
					pa.setPa((OmPa) item.clone());

					pas.add(pa);
				}
			}
			pt.getPas().setPas(pas);

			pt.setPasParaExclusao(new PAsDTO());
			pt.getPasParaExclusao().setPas(new ArrayList<PaDTO>());
			//
			//
			//

			pt.setHomologacoes(new HomologacoesDTO());

			List<HomologacaoDTO> homologacoes = new ArrayList<HomologacaoDTO>();
			for (OmHomopt item : omPt.getOmHomopts()) {
				HomologacaoDTO homologacao = new HomologacaoDTO();
				homologacao.setHomologacaoPt((OmHomopt) item.clone(false));
				homologacao.getHomologacaoPt().setOmPt(
						item.getOmPt().clone(false));
				homologacao.getHomologacaoPt().getOmPt()
						.setOmGt(item.getOmPt().getOmGt().clone(false));
				homologacao.getHomologacaoPt().getOmPt()
						.setOmTppt(item.getOmPt().getOmTppt().clone(false));

				homologacoes.add(homologacao);
			}
			pt.getHomologacoes().setHomologacoesPt(homologacoes);
			pt.setResultadoEvento(0);
			lista.add(pt);
		}

		pts.setPts(lista);
		return pts;
	}

	// Metodo chamado pelo botao salvar da GUI de cadastro de PTs
	public PtDTO setPtDTO(PtDTO pt) {
		OmPtDAO ptDAO = new OmPtDAO(getDaoSession());
		OmUsrDAO usrDAO = new OmUsrDAO(getDaoSession());
		OmMapaDAO mapaDAO = new OmMapaDAO(getDaoSession());

		PtDTO ptRetorno = new PtDTO();
		OmPt omPtOriginal = null;
		
		ptRetorno.setResultadoEvento(ptRetorno.getEVENTO_BEM_SUCEDIDO());


		if (pt.getPt().getIdPt() != null && pt.getPt().getIdPt() != 0)
			omPtOriginal = getOmPtById(pt.getPt().getIdPt());

		// Se existir o PT, entao eh uma alteracao. Nesse caso copiar o registro para um novo Id com stAtivo = 0
		if (omPtOriginal != null) {
			salvarPtComNovoIdDesativado(omPtOriginal, pt);
			
			// Atualiza alguns atribuitos para representar a nova revisao
			omPtOriginal.setRevisao(omPtOriginal.getRevisao() + 1);
			omPtOriginal.setDtRevisao(DataHoraRN.getDataHoraAtual());
			omPtOriginal.setDtStativo(omPtOriginal.getDtRevisao());
			
			
		} else {
			omPtOriginal = pt.getPt().clone();
			omPtOriginal.setIdPt(null);
			omPtOriginal.setRevisao(1l);
			omPtOriginal.setDtRevisao(new Date());
			omPtOriginal.setStAtivo((byte) 1);
			omPtOriginal.setDtStativo(new Date());
		}
		
		
		// validacaoSalvarPt deve eecutar todas as validacoes no cadastro recebido
		validacaoSalvarPt(pt, ptRetorno, omPtOriginal, ptDAO, usrDAO);
		
		// Se nesse momento aconteceu algum problema entao retornar
		if (ptRetorno.getResultadoEvento() != ptRetorno.getEVENTO_BEM_SUCEDIDO() ) {
			return ptRetorno;
		}
		


		// SOMENTE APOS PESQUISAR SE A NOVA REVISAO JA EXISTE EH QUE O POJO
		// ORIGINAL DEVE TER A REVISAO SOMADA, SE FOR ANTES,
		// A PESQUISA ACIMA IRA TRAZER O POJO SOMADO
		preparacaoParaPersistencia(pt, ptRetorno, ptDAO, omPtOriginal, usrDAO);
		

		// Preparando as tabelas dependentes para a inclusao ou alteracao
		
		// Variaveis de medicao
		// Remove os omptcns atuais para inclusao novamente
		for (OmPtcnc cnc : omPtOriginal.getOmPtcncsForIdPt()) {
			getDao().delete(cnc);
		}
		
		// Inclusao
		Set<OmPtcnc> omPtcncs = new HashSet<>();
		if (pt.getPtsCncs() != null && pt.getPtsCncs().getOmPtcncsDTO() != null) {
			for (OmPtcncDTO item : pt.getPtsCncs().getOmPtcncsDTO()) {
				omPtcncs.add((OmPtcnc) item.getOmPtcnc().clone());
			}
		}
		omPtOriginal.setOmPtcncsForIdPt(omPtcncs);
		for (OmPtcnc item : omPtOriginal.getOmPtcncsForIdPt()) {
			item.setOmPtByIdPt(omPtOriginal);
		}

		
		// PAs espelho
		if (
				pt.getPt().getOmPtPa() != null && 
				pt.getPt().getOmPtPa().getCdMesa().trim().equals("") == false &&
				pt.getPt().getOmPtPa().getOrdemInicial() >=0 &&
				pt.getPt().getOmPtPa().getDsEspelho().trim().equals("") == false) {
			
			OmPtPa omptpa = null;
			
			if (omPtOriginal.getOmPtPa() == null) {
				omptpa = pt.getPt().getOmPtPa().clone();
				omptpa.setIdPt(omPtOriginal.getIdPt());
				omptpa.setOmPt(omPtOriginal);
			} else {
				omptpa = omPtOriginal.getOmPtPa();
			}
			
			omptpa.setCdMesa(pt.getPt().getOmPtPa().getCdMesa());
			omptpa.setDsEspelho(pt.getPt().getOmPtPa().getDsEspelho());
			omptpa.setOrdemInicial(pt.getPt().getOmPtPa().getOrdemInicial());
			
			Set<OmPtPaEspelho> paespelhos = new HashSet<>();
			for (OmPtPaEspelho paespelho : pt.getPt().getOmPtPa().getOmPtPaEspelhos()) {
				OmPtPaEspelho clone = paespelho.clone();
				clone.setOmPtPa(omptpa);
				paespelhos.add(clone);
			}
			
			Set<OmPtPaMapa> pamapas = new HashSet<>();
			for (OmPtPaMapa mapa : pt.getPt().getOmPtPa().getOmPtPaMapas()) {
				OmPtPaMapa clone = mapa.clone();
				
				// Pesquisar a FK do mapa pois durante a inclusao vem apenas o cdMapa
				OmMapa ommapa;
				
				ommapa = mapaDAO.getMapaDeAlimentacao(clone.getOmMapa().getCdMapa(), omPtOriginal);
				
				clone.setOmMapa(ommapa);
				
				
				clone.setOmPtPa(omptpa);
				pamapas.add(clone);
			}
			
			omptpa.setOmPtPaEspelhos(paespelhos);
			omptpa.setOmPtPaMapas(pamapas);
			
			omPtOriginal.setOmPtPa(omptpa);
			
		}
		
		
		
		
		omPtOriginal.setDepara(pt.getPt().getDepara());
		omPtOriginal.setDsCurta(pt.getPt().getDsCurta());
		omPtOriginal.setDsPt(pt.getPt().getDsPt());
		omPtOriginal.setUrlConexao(pt.getPt().getUrlConexao());
		omPtOriginal.setUrlImpressoracb(pt.getPt().getUrlImpressoracb());
		omPtOriginal.setUrlImpressoradoc(pt.getPt().getUrlImpressoradoc());
		omPtOriginal.setDsSessao(pt.getPt().getDsSessao());
		omPtOriginal.setEstagio(pt.getPt().getEstagio());
		omPtOriginal.setModulo(pt.getPt().getModulo());
		omPtOriginal.setIndOee(pt.getPt().getIndOee());
		omPtOriginal.setTpSessao(pt.getPt().getTpSessao());
		omPtOriginal.setTpImpprog(pt.getPt().getTpImpprog());
		omPtOriginal.setTpClasseabc(pt.getPt().getTpClasseabc());
		omPtOriginal.setQtVaritmo(pt.getPt().getQtVaritmo());
		omPtOriginal.setQtEventosnoclp(pt.getPt().getQtEventosnoclp());
		omPtOriginal.setIsApongt(pt.getPt().getIsApongt());
		omPtOriginal.setIsAponparadagt(pt.getPt().getIsAponparadagt());
		omPtOriginal.setIsApontarposicaomecanica(pt.getPt().getIsApontarposicaomecanica());
		omPtOriginal.setIsCiclocomrefugo(pt.getPt().getIsCiclocomrefugo());
		omPtOriginal.setIsDevepassarns(pt.getPt().getIsDevepassarns());
		omPtOriginal.setIsSolicitaqtde(pt.getPt().getIsSolicitaqtde());
		omPtOriginal.setPercVaritmo(pt.getPt().getPercVaritmo());
		omPtOriginal.setOrdemnogt(pt.getPt().getOrdemnogt());
		omPtOriginal.setIsHabilitaVaritmo(pt.getPt().getIsHabilitaVaritmo());
		omPtOriginal.setIsPlangt(pt.getPt().getIsPlangt());
		omPtOriginal.setIsParadaFechaciclo(pt.getPt().getIsParadaFechaciclo());
		omPtOriginal.setIsTrocaopgt(pt.getPt().getIsTrocaopgt());
		omPtOriginal.setIsParadalinha(pt.getPt().getIsParadalinha());
		omPtOriginal.setIsHabilitaCip(pt.getPt().getIsHabilitaCip());
		
		omPtOriginal.setTpColeta(pt.getPt().getTpColeta());
		omPtOriginal.setTpProducao(pt.getPt().getTpProducao());
		
		// Salva as alteracoes e prepara o retorno
		if (ptRetorno.getResultadoEvento() == ptRetorno.getEVENTO_BEM_SUCEDIDO()) {
			try {
				omPtOriginal = this.getDao().makePersistent(omPtOriginal);
			} catch (Exception e) {
				ptRetorno.setResultadoEvento(ptRetorno.getERRO_DESCONHECIDO());
				e.printStackTrace();
				return ptRetorno;
			}

			ptRetorno.setPt(omPtOriginal.clone());
			ptRetorno.setPas(new PAsDTO());

			// CLona os PAs para retorno
			List<PaDTO> pas = new ArrayList<PaDTO>();
			for (OmPa item : omPtOriginal.getOmPas()) {
				if (item.getStAtivo() == 1) {
					PaDTO pa = new PaDTO();
					pa.setPa((OmPa) item.clone());
					pas.add(pa);
				}
			}
			ptRetorno.getPas().setPas(pas);
			
			// Clonar os PAs espelhos se houvevrem
			if (omPtOriginal.getOmPtPa() != null && omPtOriginal.getOmPtPa().getOmPtPaEspelhos() != null) {
				ptRetorno.getPt().getOmPtPa().setOmPtPaEspelhos(new HashSet<OmPtPaEspelho>());
				for (OmPtPaEspelho espelho : omPtOriginal.getOmPtPa().getOmPtPaEspelhos()) {
					ptRetorno.getPt().getOmPtPa().getOmPtPaEspelhos().add(espelho.clone());
				}
			}
			
			// Clonar os Mapas a serem desconsiderados do espelhamento
			if (omPtOriginal.getOmPtPa() != null && omPtOriginal.getOmPtPa().getOmPtPaMapas() != null) {
				ptRetorno.getPt().getOmPtPa().setOmPtPaMapas(new HashSet<OmPtPaMapa>());
				for (OmPtPaMapa mapa : omPtOriginal.getOmPtPa().getOmPtPaMapas()) {
					ptRetorno.getPt().getOmPtPa().getOmPtPaMapas().add(mapa.clone());
				}
			}

			ptRetorno.setPasParaExclusao(new PAsDTO());
			ptRetorno.getPasParaExclusao().setPas(new ArrayList<PaDTO>());
			
			ptRetorno.setHomologacoes(new HomologacoesDTO());

			List<HomologacaoDTO> homologacoes = new ArrayList<HomologacaoDTO>();
			for (OmHomopt item : omPtOriginal.getOmHomopts()) {
				HomologacaoDTO homologacao = new HomologacaoDTO();
				homologacao.setHomologacaoPt((OmHomopt) item.clone());
				homologacao.getHomologacaoPt().setOmUsrByIdUsrhomologado(item.getOmUsrByIdUsrhomologado().clone(false));
				homologacao.getHomologacaoPt().getOmUsrByIdUsrhomologado().setOmUsrgrp(item.getOmUsrByIdUsrhomologado().getOmUsrgrp().clone());
				homologacoes.add(homologacao);
			}
			ptRetorno.getHomologacoes().setHomologacoesPt(homologacoes);
		}
		
		
		
		return ptRetorno;
	}

	/* Metodo responsavel em duplicar o cadastro atual em novos registros com stAtivo = 0 */
	private void salvarPtComNovoIdDesativado(OmPt omPtOriginal, PtDTO pt) {
		
		// Clonar ompt atual para novos registros
		OmPt omptRevisaoAnterior = omPtOriginal.clone();
		omptRevisaoAnterior.setIdPt(null); // Para gerar novo id
		omptRevisaoAnterior.setStAtivo( (byte) 0);
		omptRevisaoAnterior.setDtStativo(DataHoraRN.getDataHoraAtual());
		omptRevisaoAnterior.setOmUsrByIdUsrstativo(pt.getPt().getOmUsrByIdUsrstativo());
		
		// Duplicar homologacoes de operadores
		Set<OmHomopt> omHomopts = new HashSet<>();
		for (OmHomopt omhomopt : omPtOriginal.getOmHomopts()) {
			OmHomopt clone = (OmHomopt) omhomopt.clone(false);

			// Inicializa atributos para incluir novos registros com o makePersistent do PT via cascade
			clone.setIdHomo(0l);
			clone.setOmPt(omptRevisaoAnterior);
			clone.setOmUsrByIdUsr(omhomopt.getOmUsrByIdUsr());
			clone.setOmUsrByIdUsrhomologado(omhomopt.getOmUsrByIdUsrhomologado());
			omHomopts.add(clone);
		}
		omptRevisaoAnterior.setOmHomopts(omHomopts);
		
		// Duplicar PAs
		Set<OmPa> omPas = new HashSet<>();
		for (OmPa ompa : omPtOriginal.getOmPas()) {
			OmPa clone = ompa.clone(false);
			clone.setId(null);
			clone.setOmPt(omptRevisaoAnterior);
			clone.setOmUsrByIdUsrrevisao(ompa.getOmUsrByIdUsrrevisao());
			clone.setOmUsrByIdUsrstativo(ompa.getOmUsrByIdUsrstativo());
			
			omPas.add(clone);
		}
		omptRevisaoAnterior.setOmPas(omPas);
		
		
		// Duplicar CNC
		Set<OmPtcnc> omPtcncsForIdPt = new HashSet<>();
		for (OmPtcnc cnc : omPtOriginal.getOmPtcncsForIdPt()) {
			OmPtcnc clone = cnc.clone(false);
			clone.setIdPtcnc(0);
			clone.setOmPtByIdPt(omptRevisaoAnterior);
			clone.setOmPtByIdPtFilho(cnc.getOmPtByIdPtFilho());
			omPtcncsForIdPt.add(clone);
		}
		omptRevisaoAnterior.setOmPtcncsForIdPt(omPtcncsForIdPt);
		omptRevisaoAnterior.setOmPtPa(null);
		
		
		// Salvar por cascata
		getDao().makePersistent(omptRevisaoAnterior);
		
		// Duplicar PA Espelho
		if (omPtOriginal.getOmPtPa() != null) {
			OmPtPa clone = omPtOriginal.getOmPtPa().clone(false);
			clone.setIdPt(omptRevisaoAnterior.getIdPt());
			clone.setOmPt(omptRevisaoAnterior);
			
			// Duplica PAs espelhos
			Set<OmPtPaEspelho> espelhos = new HashSet<>();
			for (OmPtPaEspelho espelho : omPtOriginal.getOmPtPa().getOmPtPaEspelhos()) {
				espelho.setOmPtPa(clone);
				espelhos.add(espelho);
			}
			clone.setOmPtPaEspelhos(espelhos);
			omPtOriginal.getOmPtPa().setOmPtPaEspelhos(null);
			

			
			// Duplica mapas que nao serao considerados
			Set<OmPtPaMapa> mapas = new HashSet<>();
			for (OmPtPaMapa mapa : omPtOriginal.getOmPtPa().getOmPtPaMapas()) {
				mapa.setOmPtPa(clone);
				mapas.add(mapa);
			}
			clone.setOmPtPaMapas(mapas);
			omPtOriginal.getOmPtPa().setOmPtPaMapas(null);
			
			
			
			
			omptRevisaoAnterior.setOmPtPa(clone);
			
			// Salva novamente agora com o novo idPt
			getDao().makePersistent(omptRevisaoAnterior);
			
		}
	}

	/* Metodo para validar se os dados recebidos pelo salvar pt estão consistentes */
	private void validacaoSalvarPt(PtDTO pt, PtDTO ptRetorno, OmPt omPtOriginal, OmPtDAO ptDAO, OmUsrDAO usrDAO) {
		// Pre-validacoes
		if (pt == null || pt.getPt() == null || pt.getPt().getCdPt() == null || pt.getPt().getCdPt().trim().equals("")) {
			ptRetorno.setResultadoEvento(ptRetorno.getERRO_CDPT_INVALIDO());
			return;
		}
		
		if(pt.getPt().getIsHabilitaVaritmo() != null && pt.getPt().getIsHabilitaVaritmo()){
			if(pt.getPt().getPercVaritmo() == null){
				ptRetorno.setResultadoEvento(ptRetorno.getERRO_PERC_VARITMO_VAZIO());
				return;
			}
			if(pt.getPt().getQtVaritmo() == null){
				ptRetorno.setResultadoEvento(ptRetorno.getERRO_QTD_VARITMO_VAZIO());
				return;
			}
		}
		
		if (pt.getPt().getTpImpprog() == null) {
			ptRetorno.setResultadoEvento(ptRetorno.getERRO_TP_IMPPROG());
			return;
		}
		
		
		// VERIFICA SE O CODIGO + REVISAO DO USUARIO JA EXISTE NO BANCO, SE
		// EXITIR RETORNAR AO CLIENTE A EXCESSAO
		if (omPtOriginal.getIdPt() == null) {
			OmPt ptAux = ptDAO.getOmPtPorCdAtivoOrderById(omPtOriginal.getCdPt());
			if (ptAux != null) {
				ptRetorno.setResultadoEvento(ptRetorno.getERRO_PT_JA_EXISTE());
				return;
			}
		}

		// Avalia o OmGT
		try {
			OmGtDAO gtDAO = new OmGtDAO(getDaoSession());
			OmGt omGt = gtDAO.getOmGtPorCdAtivoOrderById(pt.getPt().getOmGt().getCdGt());
			omPtOriginal.setOmGt(omGt);
			if (omGt == null) {
				ptRetorno.setResultadoEvento(ptRetorno.getERRO_GRUPOTRABALHO_DESCONHECIDO());
				return;
			}
		} catch (Exception e) {
			ptRetorno.setResultadoEvento(ptRetorno.getERRO_GRUPOTRABALHO_DESCONHECIDO());
			e.printStackTrace();
			return;
		}
		// Avalia o CC
		if ((pt.getPt().getOmCc() != null) && (pt.getPt().getOmCc().getCdCc() != null) && !pt.getPt().getOmCc().getCdCc().equals("")) {
			try {
				OmCcDAO ccDAO = new OmCcDAO(getDaoSession());
				OmCc omCc = ccDAO.getOmCcPorCdAtivoOrderById(pt.getPt().getOmCc().getCdCc());
				omPtOriginal.setOmCc(omCc);
				if (omCc == null) {
					ptRetorno.setResultadoEvento(ptRetorno.getERRO_CC_DESCONHECIDO());
					return;
				}
			} catch (Exception e) {
				ptRetorno.setResultadoEvento(ptRetorno.getERRO_CC_DESCONHECIDO());
				e.printStackTrace();
				return;
			}
		} else {
			omPtOriginal.setOmCc(null);
		}

		
		
		
		// Avalia o tipo de posto
		try {
			OmTpptDAO tpptDAO = new OmTpptDAO(getDaoSession());
			OmTppt omTppt = tpptDAO.getOmTpptPorCdAtivoOrderById(pt.getPt().getOmTppt().getCdTppt());
			omPtOriginal.setOmTppt(omTppt);
			if (omTppt == null) {
				ptRetorno.setResultadoEvento(ptRetorno.getERRO_TIPOPOSTO_DESCONHECIDO());
				return;
			}
			// Se for maquina ciclica entao sempre marcar a solicitacao de qtde
			if (omTppt.isMaquinaCiclica()) {
				omPtOriginal.setIsSolicitaqtde(true);
			}
		} catch (Exception e) {
			ptRetorno.setResultadoEvento(ptRetorno.getERRO_TIPOPOSTO_DESCONHECIDO());
			e.printStackTrace();
			return;
		}

		
		
		
		// Usuario da revisao
		try {
			OmUsr omUsrRevisao = usrDAO.getOmUsrPorCdAtivoOrderById(pt.getPt().getOmUsrByIdUsrrevisao().getCdUsr());
			omPtOriginal.setOmUsrByIdUsrrevisao(omUsrRevisao);
			if (omUsrRevisao == null) {
				ptRetorno.setResultadoEvento(ptRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
				return;
			}
		} catch (Exception e) {
			ptRetorno.setResultadoEvento(ptRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
			e.printStackTrace();
			return;
		}

		
		
		
		// Usuario do st Ativo
		try {
			OmUsr omUsrStAtivo = usrDAO.getOmUsrPorCdAtivoOrderById(pt.getPt().getOmUsrByIdUsrstativo().getCdUsr());
			omPtOriginal.setOmUsrByIdUsrstativo(omUsrStAtivo);
			if (omUsrStAtivo == null) {
				ptRetorno.setResultadoEvento(ptRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
				return;
			}
		} catch (Exception e) {
			ptRetorno.setResultadoEvento(ptRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
			e.printStackTrace();
			return;
		}

		
		
		if (pt.getPas() != null && pt.getPas().getPas() != null) {
			for (PaDTO item : pt.getPas().getPas()) {
				item.getPa().setRevisao(1l);
				item.getPa().setDtRevisao(new Date());
				item.getPa().setStAtivo((byte) 1);
				item.getPa().setDtStativo(new Date());

				try {
					OmUsr omUsrRevisao = usrDAO.getOmUsrPorCdAtivoOrderById(pt.getPt().getOmUsrByIdUsrrevisao().getCdUsr());
					item.getPa().setOmUsrByIdUsrrevisao(omUsrRevisao);
					if (omUsrRevisao == null) {
						ptRetorno.setResultadoEvento(ptRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
						return;
					}
				} catch (Exception e) {
					ptRetorno.setResultadoEvento(ptRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
					e.printStackTrace();
					return;
				}

				try {
					OmUsr omUsrStAtivo = usrDAO.getOmUsrPorCdAtivoOrderById(pt.getPt().getOmUsrByIdUsrstativo().getCdUsr());
					item.getPa().setOmUsrByIdUsrstativo(omUsrStAtivo);
					if (omUsrStAtivo == null) {
						ptRetorno.setResultadoEvento(ptRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
						return;
					}
				} catch (Exception e) {
					ptRetorno.setResultadoEvento(ptRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
					e.printStackTrace();
					return;
				}
			}
		}
	}

	/* Esse metodo sera chamado quando um PT for alterado. O objetivo eh excluir do banco o que foi excluido pela GUI
	 * 
	 */
	private void preparacaoParaPersistencia(PtDTO pt, PtDTO ptRetorno, OmPtDAO ptDAO, OmPt omPtOriginal, OmUsrDAO usrDAO) {
		

		// EXCLUSÃO DOS PAS
		if (pt.getPasParaExclusao() != null && pt.getPasParaExclusao().getPas() != null) {
			for (PaDTO item : pt.getPasParaExclusao().getPas()) {
				for (Iterator<OmPa> iterator = omPtOriginal.getOmPas().iterator(); iterator.hasNext();) {
					OmPa itemPa = iterator.next();
					if (item.getPa().getIdPa() == itemPa.getIdPa()) {
						itemPa.setStAtivo((byte) 0);
						itemPa.setDtStativo(new Date());
						continue;
					}
				}
			}
		}

		// EXCLUSAO DOS CNCs
		if (pt.getCncsParaExclusao() != pt.getCncsParaExclusao() && pt.getCncsParaExclusao().getOmPtcncsDTO() != null) {
			for (OmPtcncDTO item : pt.getCncsParaExclusao().getOmPtcncsDTO()) {
				//for (OmPtcnc cnc : omPtOriginal.getOmPtcncsForIdPt()) {
				for (OmPtcnc cnc : omPtOriginal.getOmPtcncsForIdPt()) {
					if (cnc.getIdPtcnc() == item.getOmPtcnc().getIdPtcnc()) {
						omPtOriginal.getOmPtcncsForIdPt().remove(cnc);
						getDao().delete(cnc);
					}
				}
			}
		}

		// INCLUSAO E ALTERACAO
		if (pt.getPas() != null && pt.getPas().getPas() != null) {
			for (PaDTO item : pt.getPas().getPas()) {
				// INCLUSAO DOS PAs
				if (item.getPa().getIdPa() == 0) {
					OmPa omPa = new OmPa();
					omPa.copy(item.getPa(), false);
					omPa.setStAtivo((byte) 1);
					omPa.setOmPt(omPtOriginal);

					try {
						OmUsr omUsrRevisao = usrDAO.getOmUsrPorCdAtivoOrderById(pt.getPt().getOmUsrByIdUsrrevisao().getCdUsr());
						omPa.setOmUsrByIdUsrrevisao(omUsrRevisao);
						if (omUsrRevisao == null) {
							ptRetorno.setResultadoEvento(ptRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
							return;
						}
					} catch (Exception e) {
						ptRetorno.setResultadoEvento(ptRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
						e.printStackTrace();
						return;
					}

					try {
						OmUsr omUsrStAtivo = usrDAO.getOmUsrPorCdAtivoOrderById(pt.getPt().getOmUsrByIdUsrstativo().getCdUsr());
						omPa.setOmUsrByIdUsrstativo(omUsrStAtivo);
						if (omUsrStAtivo == null) {
							ptRetorno.setResultadoEvento(ptRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
							return;
						}
					} catch (Exception e) {
						ptRetorno.setResultadoEvento(ptRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
						e.printStackTrace();
						return;
					}

					omPtOriginal.getOmPas().add(omPa);
				} else {
					// ALTERACAO DOS PAs
					List<OmPa> listaAlteracao = new ArrayList<OmPa>();
					for (OmPa itemPa : omPtOriginal.getOmPas()) {
						if (item.getPa().getIdPa() == itemPa.getIdPa()) {
							if (this.isHouveAlteracao(item.getPa(), itemPa)) {
								OmPa itemPaAlteracao = new OmPa();
								itemPaAlteracao.copy(itemPa, true);
								itemPaAlteracao.setIdPa(0l);
								itemPaAlteracao.setStAtivo((byte) 0);
								itemPaAlteracao.setOmPt(omPtOriginal);
								itemPaAlteracao.setOmUsrByIdUsrrevisao(itemPa.getOmUsrByIdUsrrevisao());
								itemPaAlteracao.setOmUsrByIdUsrstativo(itemPa.getOmUsrByIdUsrstativo());
								itemPa.copy(item.getPa(), false);
								itemPa.setDtRevisao(new Date());
								itemPa.setRevisao(itemPa.getRevisao() + 1);
								itemPa.setStAtivo((byte) 1);
								listaAlteracao.add(itemPaAlteracao);
							}
						}
					}
					for (OmPa itemAlteracao : listaAlteracao) {
						omPtOriginal.getOmPas().add(itemAlteracao);
					}
				}
			}
		}

		// EXCLUSAO DA HOMOLOGACAO
		if (omPtOriginal.getOmHomopts() != null) {
			for (Iterator<OmHomopt> iterator = omPtOriginal.getOmHomopts().iterator(); iterator.hasNext();) {
				OmHomopt item = iterator.next();
				this.getDao().getSession().delete(item);
				iterator.remove();
				continue;
			}
		}

		// INCLUSAO DAS HOMOLOGACOES
		if (pt.getHomologacoes() != null && pt.getHomologacoes().getHomologacoesPt() != null) {
			omPtOriginal.setOmHomopts(new HashSet<OmHomopt>());
			for (HomologacaoDTO item : pt.getHomologacoes().getHomologacoesPt()) {
				// INCLUSAO
				OmHomopt omHomopt = new OmHomopt();
				omHomopt.copy(item.getHomologacaoPt(), false);
				omHomopt.setIdHomo(0);
				omHomopt.setDthrHomopt(new Date());

				// omHomopt.setOmUsrByIdUsrhomologado(omUsrOriginal);

				// VERIFICA SE O USUaRIO HOMOLOGADO EXISTE
				try {
					OmUsr omUsrhomologado = usrDAO.getOmUsrPorId(item.getHomologacaoPt().getOmUsrByIdUsrhomologado().getIdUsr());
					omHomopt.setOmUsrByIdUsrhomologado(omUsrhomologado);
					if (omUsrhomologado == null) {
						ptRetorno.setResultadoEvento(pt.getERRO_DESCONHECIDO());
						return;
					}
				} catch (Exception e) {
					ptRetorno.setResultadoEvento(pt.getERRO_DESCONHECIDO());
					e.printStackTrace();
					return;
				}
				// VERIFICA SE O USUAIO HOMOLOGADOR EXISTE
				try {
					OmUsr omUsr = usrDAO.getOmUsrPorId(pt.getPt().getOmUsrByIdUsrrevisao().getIdUsr());
					omHomopt.setOmUsrByIdUsr(omUsr);
					if (omUsr == null) {
						ptRetorno.setResultadoEvento(pt.getERRO_DESCONHECIDO());
						return;
					}
				} catch (Exception e) {
					ptRetorno.setResultadoEvento(pt.getERRO_DESCONHECIDO());
					e.printStackTrace();
					return;
				}
				// VERIFICA SE O POSTO DE TRABALHO EXISTE
				try {
					OmPt omPt = ptDAO.getOmPtPorId(pt.getPt().getIdPt());
					omHomopt.setOmPt(omPt);
					if (omPt == null) {
						ptRetorno.setResultadoEvento(pt.getERRO_DESCONHECIDO());
						return;
					}
				} catch (Exception e) {
					ptRetorno.setResultadoEvento(pt.getERRO_DESCONHECIDO());
					e.printStackTrace();
					return;
				}

				omPtOriginal.getOmHomopts().add(omHomopt);
			}
		}
	}

	private boolean isHouveAlteracao(OmPa item1, OmPa item2) {
		if (!item1.getDsPa().trim().equals(item2.getDsPa().trim())) {
			return true;
		}
		if (item1.getOrdem() != null && item2.getOrdem() != null && !item1.getOrdem().equals(item2.getOrdem())) {
			return true;
		}
		if (item2.getDesvio() == null) {
			item2.setDesvio("");
		}

		if (item1.getDesvio() != null && !item1.getDesvio().trim().equals(item2.getDesvio().trim())) {
			return true;
		}
		if (!item1.getDepara().trim().equals(item2.getDepara().trim())) {
			return true;
		}
		
		if (item1.getIsDesagruparAlimentacao() != null && item2.getIsDesagruparAlimentacao() != null && item1.getIsDesagruparAlimentacao().equals(item2.getIsDesagruparAlimentacao()) == false)
			return true;
		else if (item1.getIsDesagruparAlimentacao() == null && item2.getIsDesagruparAlimentacao() != null)
			return true;
		else if (item2.getIsDesagruparAlimentacao() == null && item1.getIsDesagruparAlimentacao() != null)
			return true;
		
		return false;
	}

	public PTsDTO removePTsDTO(PTsDTO pts) {
		PTsDTO ptsRetorno = new PTsDTO();

		List<PtDTO> listaRetorno = new ArrayList<PtDTO>();
		for (PtDTO pt : pts.getPts()) {
			PtDTO ptRetorno = new PtDTO();

			OmPtDAO ptDAO = new OmPtDAO(getDaoSession());
			OmPt omPt = ptDAO.getOmPtPorId(pt.getPt().getIdPt());

			if (omPt == null) {
				ptRetorno.setResultadoEvento(ptRetorno.getERRO_DESCONHECIDO());
				ptRetorno.setPt(pt.getPt());
			} else if (omPt.getStAtivo() == 0) {
				ptRetorno.setResultadoEvento(ptRetorno.getERRO_DESCONHECIDO());
				ptRetorno.setPt(pt.getPt());
			} else {
				
				/* Verificar se existe uma UP. Se existir orientar para primeiro excluir a UP */
				UpRN urn = new UpRN();
				urn.setDaoPdba(getDao());
				MsUp msup;
				try {
					msup = urn.pesquisarMsUpPorCdUpStAtivo(omPt.getCdPt());
				} catch (injetws.model.excessoes.RegistroDesconhecidoException e1) {
					msup = null;
				}
				if (msup != null) {
					ptsRetorno.setStatus("400");
					ptsRetorno.setMsgStatus("UP ainda existe. Excluir primeiro a UP.");
				} else {
					omPt.setStAtivo((byte) 0);
					omPt.setDtStativo(new Date());
	
					try {
						OmUsrDAO usrDAO = new OmUsrDAO(getDaoSession());
						OmUsr omUsrStAtivo = usrDAO.getOmUsrPorCdAtivoOrderById(pt
								.getPt().getOmUsrByIdUsrstativo().getCdUsr()); // (OmUsr)
																				// q.uniqueResult();
						omPt.setOmUsrByIdUsrstativo(omUsrStAtivo);
						if (omUsrStAtivo == null) {
							ptRetorno.setResultadoEvento(ptRetorno
									.getERRO_USUARIO_STATUS_DESCONHECIDO());
							listaRetorno.add(ptRetorno);
							break;
						}
					} catch (Exception e) {
						e.printStackTrace();
						ptRetorno.setResultadoEvento(ptRetorno
								.getERRO_USUARIO_STATUS_DESCONHECIDO());
						listaRetorno.add(ptRetorno);
						break;
					}
	
					try {
						omPt = this.getDao().makePersistent(omPt);
					} catch (Exception e) {
						e.printStackTrace();
					}
	
					ptRetorno.setPt(omPt.clone());
	
					ptRetorno.setPas(new PAsDTO());
	
					List<PaDTO> pas = new ArrayList<PaDTO>();
					for (OmPa item : omPt.getOmPas()) {
						if (item.getStAtivo() == 1) {
							PaDTO pa = new PaDTO();
							pa.setPa((OmPa) item.clone());
	
							pas.add(pa);
						}
					}
					ptRetorno.getPas().setPas(pas);
	
					ptRetorno.setPasParaExclusao(new PAsDTO());
					ptRetorno.getPasParaExclusao().setPas(new ArrayList<PaDTO>());
	
					ptRetorno
							.setResultadoEvento(ptRetorno.getEVENTO_BEM_SUCEDIDO());
				}
	
				listaRetorno.add(ptRetorno);
			}
		}

		ptsRetorno.setPts(listaRetorno);
		return ptsRetorno;
	}

	public PtDTO ativaPtDTO(PtDTO pt) {
		PtDTO ptRetorno = new PtDTO();

		// Verifica se a revisao que esta sendo reativada eh a maior para o
		// codigo
		OmPtDAO ptDAO = new OmPtDAO(getDaoSession());
		OmPt ptAux = ptDAO.getOmPtComMaiorRevisao(pt.getPt().getCdPt(), pt
				.getPt().getRevisao());
		if (ptAux != null) {
			ptRetorno.setResultadoEvento(ptRetorno
					.getERRO_REATIVACAO_INDISPONIVEL());
			return ptRetorno;
		}

		OmPt omPt = ptDAO.getOmPtPorId(pt.getPt().getIdPt());

		if (omPt == null) {
			ptRetorno.setResultadoEvento(ptRetorno.getERRO_DESCONHECIDO());
			ptRetorno.setPt(pt.getPt());
			return ptRetorno;
		} else if (omPt.getStAtivo() == 1) {
			ptRetorno.setResultadoEvento(ptRetorno.getERRO_DESCONHECIDO());
			ptRetorno.setPt(pt.getPt());
		} else {
			omPt.setStAtivo((byte) 1);
			omPt.setDtStativo(new Date());

			try {
				OmUsrDAO usrDAO = new OmUsrDAO(getDaoSession());
				OmUsr omUsrStAtivo = usrDAO.getOmUsrPorCdAtivoOrderById(pt
						.getPt().getOmUsrByIdUsrstativo().getCdUsr());
				omPt.setOmUsrByIdUsrstativo(omUsrStAtivo);
				if (omUsrStAtivo == null) {
					ptRetorno.setResultadoEvento(ptRetorno
							.getERRO_DESCONHECIDO());
					return ptRetorno;
				}
			} catch (Exception e) {
				e.printStackTrace();
				ptRetorno.setResultadoEvento(ptRetorno.getERRO_DESCONHECIDO());
				return ptRetorno;
			}

			try {
				omPt = this.getDao().makePersistent(omPt);
			} catch (Exception e) {
				e.printStackTrace();
			}

			ptRetorno.setPt(omPt.clone());
			ptRetorno.setPas(new PAsDTO());

			List<PaDTO> pas = new ArrayList<PaDTO>();
			for (OmPa item : omPt.getOmPas()) {
				if (item.getStAtivo() == 1) {
					PaDTO pa = new PaDTO();
					pa.setPa((OmPa) item.clone());
					pas.add(pa);
				}
			}
			ptRetorno.getPas().setPas(pas);
			ptRetorno.setPasParaExclusao(new PAsDTO());
			ptRetorno.getPasParaExclusao().setPas(new ArrayList<PaDTO>());
		}
		return ptRetorno;
	}

	public PaDTO validarPaDTO(PaDTO pa) {
		PaDTO paRetorno = new PaDTO();
		paRetorno.setResultadoEvento(paRetorno.getEVENTO_BEM_SUCEDIDO());

		if (pa.getPa().getCdPa().trim().equals("")) {
			paRetorno.setResultadoEvento(paRetorno.getERRO_CDPA_INVALIDO());
			return paRetorno;
		}

		if (pa.getPa().getDsPa().trim().equals("")) {
			paRetorno.setResultadoEvento(paRetorno.getERRO_DSPA_INVALIDO());
			return paRetorno;
		}

		if (pa.getPa().getOrdem() == null) {
			paRetorno.setResultadoEvento(paRetorno.getERRO_ORDEM_INVALIDO());
			return paRetorno;
		}

		if (pa.getPa().getDepara().trim().equals("")) {
			paRetorno.setResultadoEvento(paRetorno.getERRO_DEPARA_INVALIDO());
			return paRetorno;
		}

		paRetorno.setPa(pa.getPa());
		return paRetorno;

	}

	public PAsDTO geracaoAutomaticaPA(PtDTO pt, WizPaDTO wizPa,
			Integer tipoAlgoritmo) {
		if (tipoAlgoritmo == 0) {
			return geracaoAutomaticaPATipo0(pt, wizPa);
		} else {
			return geracaoAutomaticaPATipo1(pt, wizPa);
		}
	}

	private PAsDTO geracaoAutomaticaPATipo1(PtDTO pt, WizPaDTO wizPa) {
		List<PaDTO> listaPas = new ArrayList<PaDTO>();
		PAsDTO retorno = new PAsDTO();
		int ordem = 1;
		Date data = DataHoraRN.getDataHoraAtual();
		// Primeiro gerar o lado (submodulo) 1, depois o 2. Isso pq o lado 1
		// deve ser lido primeiro para depois ler o lado 2
		// senao o operador ira ler o 1o modulo em lado depois dar a volta para
		// ler o outro lado
		for (int lado = 1; lado <= wizPa.getQtdMesas(); lado++) {
			for (int modulo = 1; modulo <= wizPa.getQtdFeeders(); modulo++) {
				for (int posicoes = 1; posicoes <= wizPa.getTamSlot(); posicoes++) {
					PaDTO pa = new PaDTO();
					pa.setPa(new OmPa());
					pa.getPa().setOrdem(ordem++);
					pa.getPa().setRevisao(1l);
					pa.getPa().setDtRevisao(data);
					pa.getPa().setDtStativo(data);
					pa.getPa().setStAtivo((byte) 1);

					String depara = "";

					String z = "";

					if (posicoes < 10) {
						z = String.valueOf(modulo)
								+ UtilsString.getZerosAEsquerda(
										String.valueOf(lado), 2)
								+ String.valueOf(posicoes);

						depara = String.valueOf(modulo)
								+ UtilsString.getZerosAEsquerda(
										String.valueOf(lado), 3)
								+ String.valueOf(posicoes);

					} else {
						z = String.valueOf(modulo) + String.valueOf(lado)
								+ String.valueOf(posicoes);

						depara = String.valueOf(modulo)
								+ UtilsString.getZerosAEsquerda(
										String.valueOf(lado), 2)
								+ UtilsString.getZerosAEsquerda(
										String.valueOf(posicoes), 2);

					}

					pa.getPa().setCdPa("Z" + z);
					pa.getPa().setDsPa(pa.getPa().getCdPa());
					pa.getPa().setDepara(depara);
					pa.getPa().setDesvio(pa.getPa().getCdPa());

					listaPas.add(pa);

				}

				for (int letra = 0; letra <= wizPa.getQtdBandejas(); letra++) {
					for (int posicoes = 1; posicoes <= wizPa.getTamSlot(); posicoes++) {
						PaDTO pa = new PaDTO();
						pa.setPa(new OmPa());
						pa.getPa().setOrdem(ordem++);
						pa.getPa().setRevisao(1l);
						pa.getPa().setDtRevisao(data);
						pa.getPa().setDtStativo(data);
						pa.getPa().setStAtivo((byte) 1);

						String z = String.valueOf(modulo)
								+ String.valueOf(lado)
								+ (char) (65 + letra)
								+ UtilsString.getZerosAEsquerda(
										String.valueOf(posicoes), 2);

						pa.getPa().setCdPa("Z" + z);
						pa.getPa().setDsPa(pa.getPa().getCdPa());
						pa.getPa().setDepara(z);
						pa.getPa().setDesvio(pa.getPa().getCdPa());

						listaPas.add(pa);
					}
				}

			}

		}

		retorno.setPas(listaPas);
		return retorno;
	}

	private PAsDTO geracaoAutomaticaPATipo0(PtDTO pt, WizPaDTO wizPa) {
		PAsDTO pas = new PAsDTO();

		List<PaDTO> listaPas = new ArrayList<PaDTO>();
		Date data = new Date();
		int ordem = 0;
		// primeira gera��oo (feeders)
		if (wizPa.getQtdFeeders() != null) {
			for (int i = 1; i <= wizPa.getQtdFeeders(); i++) {
				ordem++;
				PaDTO pa = new PaDTO();
				pa.setPa(new OmPa());
				pa.getPa().setDesvio("");
				pa.getPa().setOrdem(ordem);
				pa.getPa().setRevisao(1l);
				pa.getPa().setDtRevisao(data);
				pa.getPa().setDtStativo(data);
				pa.getPa().setStAtivo((byte) 1);

				String z = "Z"
						+ String.format("%0" + wizPa.getTamSlot() + "d", i);
				if (wizPa.isSubFeederLR()) {
					pa.getPa().setCdPa(z + "L");
					pa.getPa().setDsPa(z + "L");
					pa.getPa().setDepara(String.format("%04d", i) + "1");

					ordem++;
					PaDTO paR = new PaDTO();
					paR.setPa((OmPa) pa.getPa().clone());
					paR.getPa().setCdPa(z + "R");
					paR.getPa().setDsPa(z + "R");
					paR.getPa().setOrdem(ordem);
					paR.getPa().setDepara(String.format("%04d", i) + "2");

					listaPas.add(paR);
				} else {
					pa.getPa().setCdPa(z);
					pa.getPa().setDsPa(z);
					pa.getPa().setDepara(String.format("%04d", i));
				}

				listaPas.add(pa);
			}
		}

		// segunda gera��oo (mesas e bandejas)
		if ((wizPa.getQtdMesas() != null) && (wizPa.getQtdBandejas() != null)) {
			for (int i = 1; i <= wizPa.getQtdMesas(); i++) {
				for (int j = 1; j <= wizPa.getQtdBandejas(); j++) {
					ordem++;
					PaDTO pa = new PaDTO();
					pa.setPa(new OmPa());
					pa.getPa().setOrdem(ordem);

					String z = "Z"
							+ String.valueOf(wizPa.getMesaInicial() - 1 + i)
							+ String.format("%0" + wizPa.getTamSlot() + "d", j);
					if (wizPa.isSubFeederLR()) {
						pa.getPa().setCdPa(z + "L");
						pa.getPa().setDsPa(z + "L");
						pa.getPa().setDepara(
								String.valueOf(wizPa.getMesaInicial() - 1 + i)
										+ String.format("%04d", j) + "1");

						ordem++;
						PaDTO paR = new PaDTO();
						paR.setPa((OmPa) pa.getPa().clone());
						paR.getPa().setCdPa(z + "R");
						paR.getPa().setDsPa(z + "R");
						paR.getPa().setOrdem(ordem);
						paR.getPa().setRevisao(1l);
						paR.getPa().setDepara(
								String.valueOf(wizPa.getMesaInicial() - 1 + i)
										+ String.format("%04d", j) + "2");
						listaPas.add(paR);
					} else {
						pa.getPa().setCdPa(z);
						pa.getPa().setDsPa(z);
						pa.getPa().setDepara(
								String.valueOf(wizPa.getMesaInicial() - 1 + i)
										+ String.format("%04d", j));
					}

					if ((j == 1) && wizPa.isMudarOrdemLeitura()) {
						if (wizPa.isSubFeederLR()) {
							pa.getPa().setDesvio(z + "L");
						} else {
							pa.getPa().setDesvio(z);
						}
					} else {
						pa.getPa().setDesvio("");
					}

					pa.getPa().setRevisao(1l);
					pa.getPa().setDtRevisao(data);
					pa.getPa().setDtStativo(data);
					pa.getPa().setStAtivo((byte) 1);

					listaPas.add(pa);
				}
			}
		}

		// 3a geracao qtde de trays (bandeijas)
		if (wizPa.getQtdTrays() > 0) {
			for (int i = 1; i <= wizPa.getQtdTrays(); i++) {
				for (int j = 1; j <= wizPa.getQtdBandejaTray(); j++) {
					ordem++;
					PaDTO pa = new PaDTO();
					pa.setPa(new OmPa());
					pa.getPa().setOrdem(ordem);

					String z = "ZT"
							+ String.valueOf(wizPa.getBandejaInicialTray() - 1
									+ i) + String.format("%02d", j);

					pa.getPa().setCdPa(z);
					pa.getPa().setDsPa(z);
					pa.getPa().setDepara("ERR");

					if ((j == 1) && wizPa.isMudarOrdemLeitura()) {
						pa.getPa().setDesvio(z);
					} else {
						pa.getPa().setDesvio("");
					}

					pa.getPa().setRevisao(1l);
					pa.getPa().setDtRevisao(data);
					pa.getPa().setDtStativo(data);
					pa.getPa().setStAtivo((byte) 1);

					listaPas.add(pa);
				}
			}
		}
		pas.setPas(listaPas);

		return pas;

	}

	public OmPa getOmpa(OmPrgpos omprgpos) throws RegistroDesconhecidoException {
		// Procupara em OmPa a partir dos dados de OmPrgPos
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select ompa");
		q.append("from OmPa ompa");
		q.append("join ompa.omPt ompt");
		q.append("where ompa.stAtivo = 1");
		q.append("and ompa.depara = :depara");
		q.append("and ompt = :ompt");

		q.defineParametro("depara", omprgpos.getFeedertrack());
		q.defineParametro("ompt", omprgpos.getOmPrg().getOmPt());
		q.setMaxResults(1);

		OmPa retorno = (OmPa) q.uniqueResult();

		if (retorno == null) {
			throw new RegistroDesconhecidoException();
		}
		return retorno;
	}

	public OmPa setOmpa(OmPt ompt, OmCfg omcfg, OmPrgpos omprgpos) {
		// Salvar Ompa, antes dessa rotina ser chamada deve-se verificar se o
		// reg ja nao existe

		OmPa retorno = null;

		for (OmPa ompa : omprgpos.getOmPrg().getOmPt().getOmPas()) {
			if (ompa.getStAtivo().equals((byte) 0))
				continue;

			if (ompa.getDepara().equals(omprgpos.getFeedertrack())) {
				retorno = ompa;
				break;
			}
		}
		if (retorno == null) {
			retorno = new OmPa();
			retorno.setCdPa(omprgpos.getFeedertrack());
			retorno.setDepara(omprgpos.getFeedertrack());
			retorno.setDesvio(omprgpos.getPocket());
			retorno.setDsPa(omprgpos.getFeedertrack());
			retorno.setDtRevisao(new Date());
			retorno.setDtStativo(new Date());
			retorno.setIdPa(0l);
			retorno.setOmPt(ompt);
			try {
				retorno.setOrdem(Integer.valueOf(omprgpos.getScantrack()));
			} catch (Exception e) {
				retorno.setOrdem(0);
			}
			retorno.setStAtivo((byte) 1);
			retorno.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
			retorno.setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());
			retorno.setRevisao(1l);
		}

		this.getDao().getSession().saveOrUpdate(retorno);

		return retorno;
	}

	public void assumePreConferencia(String maquina) {
		String hql = "";

		hql = "";

		hql += "from OmPt ompt ";
		hql += "where ompt.cdPt = '::cdpt' ";
		hql += "and ompt.stAtivo = 1 ";

		hql = hql.replaceAll("::cdpt", maquina);
		Query q = this.getDao().getSession().createQuery(hql);

		OmPt omPt = (OmPt) q.uniqueResult();
		// MapaCODTO mapaAtual = new MapaCODTO();

		if (omPt != null) {
			OmAlim omAlim = omPt.getOmAlimByIdAlimpre();
			omAlim.setTpAlim((byte) 1);
			this.getDao().getSession().saveOrUpdate(omAlim);

			omPt.setOmAlimByIdAlim(omAlim);
			omPt.setOmAlimByIdAlimpre(null);
			this.getDao().getSession().saveOrUpdate(omPt);

		}
	}

	public HomologacoesDTO validarHomologacoesPt(HomologacoesDTO homologacoes) {
		String hql;
		HomologacoesDTO homologacoesDTO = new HomologacoesDTO();
		homologacoesDTO.setResultadoEvento(homologacoesDTO
				.getEVENTO_BEM_SUCEDIDO());
		homologacoesDTO.setHomologacoesPt(new ArrayList<HomologacaoDTO>());

		for (HomologacaoDTO homologacaoDTO : homologacoes.getHomologacoesPt()) {
			homologacoesDTO.getHomologacoesPt().add(homologacaoDTO);
		}

		for (HomologacaoDTO homologacaoDTO : homologacoesDTO
				.getHomologacoesPt()) {
			// Verifica se o usuário homologado existe
			try {
				hql = "from OmUsr t where t.idUsr = ::idUsr and t.stAtivo = 1";
				hql = hql.replaceAll(
						"::idUsr",
						String.valueOf(homologacaoDTO.getHomologacaoPt()
								.getOmUsrByIdUsrhomologado().getIdUsr()));

				Query q = this.getDao().getSession().createQuery(hql);

				q.list().get(0);

			} catch (Exception e) {
				homologacoesDTO.setResultadoEvento(homologacoesDTO
						.getERRO_USUARIO_DESCONHECIDO());
				break;
			}
			// Verifica se o usuário homologador existe
			try {
				hql = "from OmUsr t where t.idUsr = ::idUsr and t.stAtivo = 1";
				hql = hql.replaceAll(
						"::idUsr",
						String.valueOf(homologacaoDTO.getHomologacaoPt()
								.getOmUsrByIdUsr().getIdUsr()));

				Query q = this.getDao().getSession().createQuery(hql);

				q.list().get(0);

			} catch (Exception e) {
				homologacoesDTO.setResultadoEvento(homologacoesDTO
						.getERRO_USUARIO_DESCONHECIDO());
				break;
			}
			// Verifica se o posto de trabalho existe
			try {
				hql = "from OmPt t where t.idPt = ::idPt and t.stAtivo = 1";
				hql = hql.replaceAll(
						"::idPt",
						String.valueOf(homologacaoDTO.getHomologacaoPt()
								.getOmPt().getIdPt()));

				Query q = this.getDao().getSession().createQuery(hql);

				q.list().get(0);

			} catch (Exception e) {
				homologacoesDTO.setResultadoEvento(homologacoesDTO
						.getERRO_PT_DESCONHECIDO());
				break;
			}
			// Verifica se o tipo da homologa��oo é valida
			if ((homologacaoDTO.getHomologacaoPt().getTpHomopt() < 0)
					|| (homologacaoDTO.getHomologacaoPt().getTpHomopt() > 2)) {
				homologacoesDTO.setResultadoEvento(homologacoesDTO
						.getERRO_TIPOHOMOLOGACAO_INVALIDA());
				break;
			}
			// Verifica se o usuario a ser homologado já existe no cadastro de
			// supervisores
			try {
				hql = "from OmHomogt t where t.omUsrByIdUsrhomologado.idUsr = ::idUsr";
				hql = hql.replaceAll(
						"::idUsr",
						String.valueOf(homologacaoDTO.getHomologacaoPt()
								.getOmUsrByIdUsrhomologado().getIdUsr()));

				Query q = this.getDao().getSession().createQuery(hql);

				q.list().get(0);

				homologacoesDTO.setResultadoEvento(homologacoesDTO
						.getERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR());
				break;
			} catch (Exception e) {

			}
		}

		return homologacoesDTO;

	}

	public OmPt getPtPorId(long idpt) {
		OmPt pt = this.getDao().findById(OmPt.class, idpt, false);
		return pt;
	}

	/**
	 * Pegas as OmTppt que est�o associadas a máquinas ativas
	 * 
	 * @return
	 */
	public List<OmTppt> getOmTpptsAssociadasPt() {
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select distinct omTppt");
		q.append("from OmTppt omTppt");
		q.append("join fetch omTppt.omPts omPt");
		q.append("where omTppt.stAtivo = :ativo");
		q.append("and omPt.stAtivo = :ativo");
		q.defineParametro("ativo", (byte) 1);
		return q.list();
	}

	public List<OmPt> pesquisarPtByGt(OmGt omgt) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select ompt");
		q.append("from OmPt ompt");
		q.append("where ompt.stAtivo = 1");
		q.append("and ompt.omGt = :omgt");

		q.defineParametro("omgt", omgt);
		return q.list();
	}

	/* Pesquisa os pts do gt dentro do layout
	 * 
	 */
	public List<OmPt> pesquisarPtByGtComLayout(OmGt omgt) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select ompt");
		q.append("from OmPt ompt");
		q.append("join ompt.omObjs omobj");
		q.append("join omobj.omGtByIdGt omgt");
		q.append("where ompt.stAtivo = 1");
		q.append("and omgt = :omgt");
		q.append("order by ompt.cdPt");

		q.defineParametro("omgt", omgt);
		return q.list();
	}
	
	public PTsDTO pesquisarPtByGtComLayout(PtDTO filtro) {
		OmGt omgt = null;
		if(filtro.getPt() == null || filtro.getPt().getOmGt() == null){
			return new PTsDTO();
		}
		
		omgt = filtro.getPt().getOmGt();
		List<OmPt> listaPTs = pesquisarPtByGtComLayout(omgt);				
		List<PtDTO> lista = new ArrayList<PtDTO>();
		for (OmPt omPt : listaPTs) {
			boolean isExiste = false;
			for (PtDTO ptlista : lista) {
				if (ptlista.getPt().getIdPt().equals(omPt.getIdPt())) {
					isExiste = true;
					break;
				}
			}
			if (isExiste == true) {
				continue;
			}

			PtDTO pt = new PtDTO();
			pt.setPt(omPt.clone());
			pt.setPas(new PAsDTO());

			List<PaDTO> pas = new ArrayList<PaDTO>();
			for (OmPa item : omPt.getOmPas()) {
				if (item.getStAtivo() == 1) {
					PaDTO pa = new PaDTO();
					pa.setPa((OmPa) item.clone());

					pas.add(pa);
				}
			}
			pt.getPas().setPas(pas);

			pt.setPasParaExclusao(new PAsDTO());
			pt.getPasParaExclusao().setPas(new ArrayList<PaDTO>());

			pt.setHomologacoes(new HomologacoesDTO());

			List<HomologacaoDTO> homologacoes = new ArrayList<HomologacaoDTO>();
			for (OmHomopt item : omPt.getOmHomopts()) {
				HomologacaoDTO homologacao = new HomologacaoDTO();
				homologacao.setHomologacaoPt((OmHomopt) item.clone(false));
				homologacao.getHomologacaoPt().setOmPt(
						item.getOmPt().clone(false));
				homologacao.getHomologacaoPt().getOmPt()
						.setOmGt(item.getOmPt().getOmGt().clone(false));
				homologacao.getHomologacaoPt().getOmPt()
						.setOmTppt(item.getOmPt().getOmTppt().clone(false));

				homologacoes.add(homologacao);
			}
			pt.getHomologacoes().setHomologacoesPt(homologacoes);
			pt.setResultadoEvento(0);
			lista.add(pt);
		}
		
		PTsDTO retorno = new PTsDTO();
		retorno.setPts(lista);
		return retorno;
	}

	/*
	 * Esse metodo deve retornar todos os pts configurados para coleta para determinado gt
	 */
	public List<OmPt> pesquisarPtComColetaByGt(OmGt omgt, OmPt ompt) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select ompt");
		q.append("from OmPt ompt");
		q.append("where ompt.stAtivo = 1");
		q.append("and ompt <> :ompt");
		q.append("and ompt.omGt = :omgt");
		q.append("and exists (select a from MsMs a join a.msMsicups b join b.msUp c where a.stAtivo = 1 and c.stAtivo = 1 and c.cdUp = ompt.cdPt)");

		q.defineParametro("omgt", omgt);
		q.defineParametro("ompt", ompt);
		
		return q.list();
	}
	
	
	public PTsDTO getPtByGt(OmGt omgt) {
		MapQuery q = new MapQuery(this.getDao().getSession());
		PTsDTO dto = new PTsDTO();
		dto.setPts(new ArrayList<PtDTO>());
		List<OmPt> list = new ArrayList<>();

		q.append("select ompt");
		q.append("from OmPt ompt");
		q.append("where ompt.stAtivo = 1");
		q.append("and ompt.omGt = :omgt");

		q.defineParametro("omgt", omgt);
		
		list = q.list();
		
		for(OmPt omPt : list){
			PtDTO ptDTO = new PtDTO();
			ptDTO.setPt(omPt.clone(false));
			
			dto.getPts().add(ptDTO);
			
		}
		return dto;
	}

	public List<OmPt> pesquisarPtByGtEApontaProducao(String cdGt) {
		MapQuery q = new MapQuery(this.getDaoSession());

		q.append("select ompt");
		q.append("from OmPt ompt");
		q.append("join ompt.omGt omgt");
		q.append("where ompt.stAtivo = 1");
		q.append("and omgt.cdGt = :cdgt");
		q.append("and ompt.isApongt = 1");

		q.defineParametro("cdgt", cdGt);
		return q.list();
	}

	public OmPt pesquisarPtByCdPtStAtivo(String cdPt) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select ompt");
		q.append("from OmPt ompt");
		q.append("left join fetch ompt.omTppt omtppt");
		q.append("left join fetch ompt.omGt b");
		q.append("where ompt.stAtivo = 1");
		q.append("and ompt.cdPt = :cdpt");

		q.defineParametro("cdpt", cdPt);
		return (OmPt) q.uniqueResult();
	}

	public OmPt pesquisarPtLikeDeParaPtStAtivo(String depara) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select ompt");
		q.append("from OmPt ompt");
		q.append("where ompt.stAtivo = 1");
		q.append("and ompt.depara like :depara");

		q.defineParametro("depara", ("%" + depara));
		q.setMaxResults(1);

		return (OmPt) q.uniqueResult();
	}

	public List<OmPt> pesquisarListaPtLikeDeParaPtStAtivo(String depara) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select ompt");
		q.append("from OmPt ompt");
		q.append("where ompt.stAtivo = 1");
		q.append("and ompt.depara like :depara");

		q.defineParametro("depara", ("%" + depara));

		return q.list();
	}

	/**
	 * Busca todas as {@code OmPt} que est�o ativas que possuem cadastro em MsUp
	 * 
	 * @return
	 */
	public List<OmPt> pesquisarPtStAtivoComMsUpByCdMs(String cdms) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select ompt");
		q.append("from OmPt ompt");
		q.append("where ompt.stAtivo = :stAtivo");
		q.append("and exists (select msup from MsUp msup ");
		q.append(" 						  join msup.msMsicups msmsicup ");
		q.append("						  join msmsicup.msMs msms");
		q.append("			  where msup.cdUp = ompt.cdPt and msup.stAtivo = 1 and msms.stAtivo = 1 and msms.cdMs = :cdms");
		
		// Alessandre em 29-08-18 adicionei o filtro abaixo para nao consolidar os PT que tiveram a coleta suspensa
		q.append("and (msmsicup.isAtivo = :isativo or msmsicup.isAtivo is null)  )");
		
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("cdms", cdms);
		q.defineParametro("isativo", true);

		return q.list();
	}

	public List<OmPt> pesquisarTodosPtStAtivo() {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select ompt");
		q.append("from OmPt ompt");
		q.append("where ompt.stAtivo = :stAtivo");

		q.defineParametro("stAtivo", (byte) 1);
		return q.list();
	}

	public List<OmPt> pesquisarPtStAtivoComOpEmProducaoDaFolha(String cdfolha) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select ompt");
		q.append("from OmPt ompt");
		q.append("join ompt.ppCp ppcp");
		q.append("join ppcp.dwFolha dwfolha");
		q.append("where ompt.stAtivo = :stAtivo");
		q.append("and ompt.isSemop = :issemop");
		q.append("and ompt.ppCp is not null");
		q.append("and dwfolha.cdFolha = :cdfolha");

		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("cdfolha", cdfolha);
		q.defineParametro("issemop", false);
		
		return q.list();
	}

	/**
	 * Desativa todos os registros da tabela de posto de trabalho
	 * 
	 * @param dataHoraDesativacao
	 * @param omUsr
	 *            Usuário que desativou a justificativa
	 */
	public void desativarOmPts(Date dataHoraDesativacao, OmUsr omUsr) {
		this.getDao().desativarMuitos(OmPt.class, OmPtTemplate._FIELD_NAME_CD,
				null, false, dataHoraDesativacao, omUsr);
	}

	/**
	 * Desativa registros da tabela de posto de trabalho
	 * 
	 * @param listaCdUsrDevemFicarAtivos
	 *            Lista de códigos de devem ficar permanecer ativos
	 * @param dataHoraDesativacao
	 * @param omUsr
	 *            Usuário que desativou a usr
	 */
	public void desativarOmPts(List<String> listaCdUsrDevemFicarAtivos, Date dataHoraDesativacao, OmUsr omUsr) {
		this.getDao().desativarMuitos(OmPt.class, OmPtTemplate._FIELD_NAME_CD, listaCdUsrDevemFicarAtivos, true, dataHoraDesativacao, omUsr);
	}

	/**
	 * Desativa relacionado ao código e tipo do posto de trabalho
	 * 
	 * @param cdPt
	 * @param date
	 * @param omUsr
	 *            usuário que está desativando
	 * @throws RegistroJaDesativadoException
	 * @throws RegistroDesconhecidoException
	 */
	public void desativarOmPt(String cdPt, Date date, OmUsr omUsr) throws RegistroDesconhecidoException, RegistroJaDesativadoException {
		this.getDao().desativar(OmPt.class, cdPt, OmPtTemplate._FIELD_NAME_CD, null, date, omUsr);
	}

	/**
	 * Desativa {@code OmPt} relacionado ao id da posto de trabalho
	 * 
	 * @param idPt
	 * @param dataHoraAtual
	 * @throws RegistroJaDesativadoException
	 */
	public void desativarOmPt(long idPt, Date date, OmUsr omUsr)
			throws RegistroJaDesativadoException {
		this.getDao().desativar(OmPt.class, idPt, date, omUsr);
	}

	/**
	 * Pega {@code OmPt} relacionado com o código do posto de trabalho e que
	 * esteja ativo
	 * 
	 * @param cdPt
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public OmPt getOmPt(String cdPt) throws RegistroDesconhecidoException {
		return getOmPt(cdPt, true);
	}

	public OmPt getOmPt(String cdPt, boolean isApenasAtivos)
			throws RegistroDesconhecidoException {
		return this.getDao().findByCd(OmPt.class, cdPt, OmPtTemplate._FIELD_NAME_CD, null, isApenasAtivos);
	}

	public OmPt criarOmPt(String cdPt, String dsPt, OmTppt omTppt, OmUsr omUsr,
			Date date, boolean isPlangt) throws UsuarioDesconhecidoException,
			TipoPostoDesconhecidoException {
		if (omTppt == null) {
			throw new TipoPostoDesconhecidoException();
		}

		if (omUsr == null) {
			throw new UsuarioDesconhecidoException();
		}

		if (date == null) {
			date = DataHoraRN.getDataHoraAtual();
		}

		// Incluir o PT automaticamente
		OmPt ompt = new OmPt();
		ompt.setId(null);
		ompt.setCdPt(cdPt);
		ompt.setDsPt(dsPt);
		ompt.setOmUsrByIdUsrrevisao(omUsr);
		ompt.setOmUsrByIdUsrstativo(omUsr);
		ompt.setDtRevisao(date);
		ompt.setDtStativo(date);
		ompt.setRevisao(1l);
		ompt.setOmTppt(omTppt);
		ompt.setStAtivo((byte) 1);
		ompt.setTpImpprog((byte) 0);
		ompt.setIsPlangt(false);

		return getDao().makePersistent(ompt);

	}

	public OmPt getOmPtCriaSeNaoExistir(String cdPt,
			OmTppt omTpPtParaInserirSeNaoExistir,
			OmUsr omUsrParaInserirSeNaoExistir,
			String dsPtParaInserirSeNaoExistir, boolean isPlangt)
			throws UsuarioDesconhecidoException, TipoPostoDesconhecidoException {
		OmPt ompt = null;
		try {
			ompt = getOmPt(cdPt);
		} catch (RegistroDesconhecidoException e) {
			ompt = criarOmPt(cdPt, dsPtParaInserirSeNaoExistir,
					omTpPtParaInserirSeNaoExistir,
					omUsrParaInserirSeNaoExistir,
					DataHoraRN.getDataHoraAtual(), isPlangt);
		}
		return ompt;
	}

	/**
	 * Pega {@code OmPt} relacionado com o id do posto de trabalho
	 * 
	 * @param idPt
	 * @return
	 */
	public OmPt getOmPtById(long idPt) {
		return this.getDao().findById(OmPt.class, idPt, false);
	}

	public OmPt salvarDeixandoOriginal(OmPt omPtAnterior, OmPt omPtNovo,
			Date dateOperacao, OmUsr omUsrOperacao) {
		if (omPtAnterior != null) {
			// Deixa o id da nova vers�o com o mesmo número
			omPtNovo.setIdPt(omPtAnterior.getIdPt());

			// Muda o id, para gerar um novo id para a antiga vers�o
			OmPt omPtClonado = omPtAnterior.clone(false);
			omPtClonado.setForeignKeys(omPtAnterior.getOmClp(),
					omPtAnterior.getOmTppt(),
					omPtAnterior.getOmAlimByIdAlimpre(),
					omPtAnterior.getOmAlimByIdAlim(),
					omPtAnterior.getOmAlimByIdAlimcorrente(),
					omPtAnterior.getOmGt(),
					omPtAnterior.getOmUsrByIdUsrstativo(),
					omPtAnterior.getOmUsrByIdUsrrevisao(),
					omPtAnterior.getOmCc(), omPtAnterior.getDwFolha());
			omPtAnterior = omPtClonado;
			omPtAnterior.setIdPt(null);
		}

		return this.getDao().salvarDeixandoOriginal(omPtAnterior, omPtNovo,
				dateOperacao, omUsrOperacao);
	}

	public PtDTO getOmPtPorIdOuCd(OmPt filtro) {
		PtDTO retorno = new PtDTO();
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("FROM OmPt pt ");
		if (filtro.getIdPt() != null) {
			q.append("WHERE pt.idPt =:idPt AND pt.stAtivo = 1 ");
			q.defineParametro("idPt", filtro.getIdPt());
		}
		if (filtro.getCdPt() != null) {
			q.append("WHERE pt.cdPt =:cdPt AND pt.stAtivo = 1 ");
			q.defineParametro("cdPt", filtro.getCdPt());
		}

		q.setMaxResults(1);
		OmPt pt = (OmPt) q.uniqueResult();
		retorno.setPt(pt.clone(false));
		retorno.getPt().setOmGt(pt.getOmGt().clone(false));
		// adicionei esse trecho pois o omtppt estava chegando null na
		// importa��oo dos indicadores do injet
		retorno.getPt().setOmTppt(pt.getOmTppt().clone(false));
		if (pt.getPpCp() != null)
			retorno.getPt().setPpCp(pt.getPpCp().clone(false));

		return retorno;
	}

	public List<OmPt> getPtsPorUrlConexao(OmCfgurl cfgurl) {
		List<OmPt> retorno = new ArrayList<OmPt>();
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("FROM OmPt pt");
		q.append("WHERE pt.urlConexao = :url");
		q.append("AND  pt.stAtivo = 1");
		q.defineParametro("url", cfgurl.getUrlConexao());
		retorno = q.list();
		return retorno;
	}

	public PTsDTO getOmPtPeloTppt(OmTppt omTppt)
			throws RegistroDesconhecidoException {
		PTsDTO retorno = new PTsDTO();
		OmPtDAO ptDAO = new OmPtDAO(getDaoSession());
		List<PtDTO> listaPts = new ArrayList<PtDTO>();
		List<OmPt> listaOmPt = ptDAO.getOmPtsPorTppt(omTppt.getIdTppt());
		if (listaOmPt == null) {
			throw new RegistroDesconhecidoException();
		}
		for (OmPt pt : listaOmPt) {
			PtDTO ptDTO = new PtDTO();
			ptDTO.setPt(pt.clone(false));
			listaPts.add(ptDTO);
		}
		retorno.setPts(listaPts);
		return retorno;
	}

	public boolean validarOmptcnc(OmPtcncDTO omptcncDto) {
		OmPtcncDAO omptcncDao = new OmPtcncDAO(getDaoSession());

		long idPt = omptcncDto.getOmPtcnc().getOmPtByIdPt().getIdPt() != null ? omptcncDto
				.getOmPtcnc().getOmPtByIdPt().getIdPt()
				: 0;

		// long idPtFilho = omptcncDto.getOmPtcnc().getOmPtByIdPtFilho() != null
		// ?
		// omptcncDto.getOmPtcnc().getOmPtByIdPtFilho().getIdPt() : 0;

		List<OmPtcnc> retorno = omptcncDao.getOmPtCncPreenchido(idPt);
		if (!retorno.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	/*
	 * Esse metodo � importante para a consolidacao dos parametros de medicao quando o pt consolidar para um outro PT superior.
	 */
	public List<OmPt> pesquisarPtsPaidoPtCEP(OmPt ompt) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select ompt");
		q.append("from OmPt ompt");
		q.append("join ompt.omPtcncsForIdPtFilho omptcnc");
		q.append("where ompt.stAtivo = 1");
		q.append("and omptcnc.omPtByIdPtFilho = :ompt");
		
		q.defineParametro("ompt", ompt);
		
		return q.list();
	}
	
	public OmPtcp getOmPtCpByIdPtEIdCp(Long idPt , Long idCp)
			throws RegistroDesconhecidoException {

		MapQuery query = new MapQuery(getDao().getSession());
		query.append("select omptcp ");
		query.append("from OmPtcp omptcp ");
		query.append("join omptcp.omPt ompt");
		query.append("join omptcp.ppCp ppcp");
		query.append("where ompt.idPt = :idPt ");
		query.append("and ppcp.idCp = :idCp ");
		query.append("order by omptcp.idPtcp desc");
		query.defineParametro("idPt", idPt);
		query.defineParametro("idCp", idCp);

		query.setMaxResults(1);
		OmPtcp retorno = null;
		retorno =  (OmPtcp) query.uniqueResult();
		return retorno;
	}
	public static void main(String[] args) {
		PTRN rn = new PTRN();			
		rn.iniciaConexaoBanco();				

		PrUp prup = new PrUp();
		
		prup.setCdmaquina("teste");
		
		MapQuery q = new MapQuery(rn.getDaoSession());
		q.append("select a from PrConexoesInjet a where a.idregconexaoinjet = :id");
		q.defineParametro("id", new BigDecimal("20140300000000000000000007"));
		PrConexoesInjet prConexoesInjet = (PrConexoesInjet) q.uniqueResult();
		prup.setPrConexoesInjet(prConexoesInjet);
		System.out.println(prup.toString());
		rn.getDao().makePersistent(prup);
		rn.finalizaConexaoBanco();
	}

	
	public List<OmPt> pesquisarPtStAtivoComCds(List<Object> ups) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from OmPt a");
		q.append("where a.stAtivo = 1");
		q.append("and a.cdPt in (:lista)");
		
		q.defineListaParametro("lista", ups);
		
		return q.list();
	}
	
	public OmPt pesquisarPtApontaOp(String cdgt) {
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from OmPt a");
		q.append("where a.stAtivo = 1");
		q.append("and a.omGt.cdGt = :cdgt");
		q.append("and a.IsTrocaopgt = 1");
		q.setMaxResults(1);
		
		q.defineParametro("cdgt", cdgt);
		
		return (OmPt) q.uniqueResult();
	}
	
	
	@SuppressWarnings("unused")
	public ListaPTsDTO getPtsDTO(FiltroPesquisaDTO filtro){
		ListaPTsDTO retorno = new ListaPTsDTO();
		retorno.setItems(new ArrayList<PtDTO2>());
		retorno.setMeta(new MetaDTO(filtro));
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select t");
		q.append("from OmPt t"); 
		q.append("where t.stAtivo = 1");
		q.append(" AND t.omTppt.cdTppt = 'CIC' "); 
		q.append(" AND t.tpSessao IN (0, 1, 2)");
		
		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")){			
			q.append("AND (");
			q.append(" upper(t.cdPt) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.dsPt) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");		 
		} 
		q.append("order by t.cdPt");
		
		List<OmPt> lista = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());

		for (OmPt reg : lista) {
			PtDTO2 regDTO = new PtDTO2();
			regDTO.setIdPt(reg.getIdPt());
			regDTO.setCdPt(reg.getCdPt());
			regDTO.setDsPt(reg.getDsPt());
			regDTO.setDsCurta(reg.getDsCurta());
			
			if (reg.getOmGt() != null) {
				regDTO.setCdGt(reg.getOmGt().getCdGt());	
			}
			
			regDTO.setClasseABC(getClasseABC(reg.getTpClasseabc()));
			regDTO.setSessaoCLP(reg.getTpSessao().intValue());
			regDTO.setTpPt("CIC");
			regDTO.setParadaFechaCiclo(reg.getIsParadaFechaciclo());
			regDTO.setStRegistro(reg.getStAtivo().intValue());

 			retorno.getItems().add(regDTO);
 		}
		
		
 		if (lista.size() > 0) {
 			ResumoRetornoRegistrosRN resRN = new ResumoRetornoRegistrosRN(getDao());
 			retorno.setMeta(resRN.getMetaDTO(filtro, q, lista.size()));
 			resRN = null;
 		}
		
		q = null;
		lista = null;
				
		return retorno;
	}
	
	@SuppressWarnings("unused")
	public PtDTO2 getPtByCd(String cdPt){
		PtDTO2 retorno = new PtDTO2();
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select t");
		q.append("from OmPt t");
		q.append("where t.stAtivo = 1");
		q.append(" AND t.omTppt.cdTppt = 'CIC' ");
		q.append(" AND t.tpSessao IN (0, 1, 2)");
		
		q.append("AND t.cdPt = :cdPt");
 		q.append("ORDER BY t.cdPt");
 		q.defineParametro("cdPt", cdPt);
 		

 		List<OmPt> lista = q.list();
 		if (lista.size() == 1) {
 			retorno.setIdPt(lista.get(0).getIdPt());
 			retorno.setCdPt(lista.get(0).getCdPt());
 			retorno.setDsPt(lista.get(0).getDsPt());
 			retorno.setDsCurta(lista.get(0).getDsCurta());
 			
 			if (lista.get(0).getOmGt() != null) {
 				retorno.setCdGt(lista.get(0).getOmGt().getCdGt());	
 			}
 			
 			retorno.setClasseABC(getClasseABC(lista.get(0).getTpClasseabc()));
			retorno.setSessaoCLP(lista.get(0).getTpSessao().intValue());
			retorno.setTpPt("CIC");
			retorno.setParadaFechaCiclo(lista.get(0).getIsParadaFechaciclo());
			retorno.setStRegistro(lista.get(0).getStAtivo().intValue());		 
 		}
				
		return retorno;
	}
	
	
	public String getClasseABC(Byte classe) {
		String classeABC = "C";
		
		if (classe != null) {
			if (classe.intValue() == 0) {
				classeABC = "A";
				
			} else if (classe.intValue() == 1) {
				classeABC = "B";

			} else {
				classeABC = "C";				
			}
		}
		
		return classeABC;
	}

	public Byte getClasseValue(String classeABC) {
		Byte classe = 0;
		
		if (classeABC.equals("A")) {
			classe = 0;
			
		} else if (classeABC.equals("B")) {
			classe = 1;

		} else {
			classe = 2;				
		}
		
		return classe;
	}
	
	public String getDsSessao(Byte tpSessao) {
		String retorno = null;
		
		if (tpSessao == 0) {
			retorno = "COD. FOLHA";
		}
		
		return retorno;
	}
	
	@SuppressWarnings("unused")
	public List<CalendarioPtDTO2> getPtsComCalendario() {
		List<CalendarioPtDTO2> pts = new ArrayList<CalendarioPtDTO2>();
		CalendarioPtDTO2 pt = new CalendarioPtDTO2();
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select distinct a.omPt.cdPt, a.dwCal.cdCal ");
		q.append("from DwCalpt a");
		q.append("where a.stAtivo = 1");
		q.append("order by a.omPt.cdPt");

		List<Object> lista = q.list();
		
		for (int i = 0; i < lista.size(); i++) {
			
			List<?> item = convertObjectToList(lista.get(i));
			
			pt = new CalendarioPtDTO2();
			pt.setCdPt((String) item.get(0));
			pt.setCdCal((String) item.get(1));
			pts.add(pt);
			
 		}
		
		q = null;
		lista = null;
		
		return pts;
	}
	
	public static List<?> convertObjectToList(Object obj) {
	    List<?> list = new ArrayList<>();
	    if (obj.getClass().isArray()) {
	        list = Arrays.asList((Object[])obj);
	    } else if (obj instanceof Collection) {
	        list = new ArrayList<>((Collection<?>)obj);
	    }
	    return list;
	}
	
	
	
	@SuppressWarnings("unused")
	public List<PtDTO2> getPtsSemCalendario() {
		List<PtDTO2> pts = new ArrayList<PtDTO2>();
		PtDTO2 pt = new PtDTO2();
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select t");
		q.append("from OmPt t"); 
		q.append("where t.stAtivo = 1");
		q.append(" AND t.omTppt.cdTppt = 'CIC' "); 
		q.append(" AND t.tpSessao IN (0, 1, 2) ");
		q.append(" AND t.idPt NOT IN (select distinct a.omPt.idPt ");
		q.append("                    from DwCalpt a ");
		q.append("                    where a.stAtivo = 1 ");
		q.append("                   ) ");
		q.append("order by t.cdPt");
		
		List<OmPt> lista = q.list();
		
		for (OmPt reg : lista) {
			
			pt = new PtDTO2();
			pt.setCdPt(reg.getCdPt());
			pt.setDsPt(reg.getDsPt());
			pts.add(pt);
			
 		}
		
		q = null;
		lista = null;
		
		return pts;
	}
	
	
	
}