package idw.model.rn.alimentacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmMapapaDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwFolha;
import idw.model.pojos.MsUp;
import idw.model.pojos.OmAlim;
import idw.model.pojos.OmAlimrea;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmMapa;
import idw.model.pojos.OmMapaAnexo;
import idw.model.pojos.OmMapapa;
import idw.model.pojos.OmMapapaproalt;
import idw.model.pojos.OmPa;
import idw.model.pojos.OmPrg;
import idw.model.pojos.OmPrgpos;
import idw.model.pojos.OmPrgposproalt;
import idw.model.pojos.OmProaltglo;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmPtPaEspelho;
import idw.model.pojos.OmUsr;
import idw.model.rn.DataHoraRN;
import idw.model.rn.DiversosRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.GTRN;
import idw.model.rn.PTRN;
import idw.model.rn.UsuarioRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.MapaAlimentacaoDTO;
import idw.webservices.dto.MapaCODTO;
import idw.webservices.dto.MapaPAsDTO;
import idw.webservices.dto.MapaPaDTO;
import idw.webservices.dto.MapasAlimentacaoDTO;
import idw.webservices.dto.MapasCODTO;
import idw.webservices.dto.PosicaoCODTO;
import idw.webservices.dto.PosicoesCODTO;
import idw.webservices.dto.ProgramaInsersoraDTO;

@SuppressWarnings("unchecked")
public class MapaAlimentacaoRN extends DAOGenerico {

	/*
	 * Salva o mapa de alimentacao a partir dos dados do programa da maquina IAC. Verificará se o PT tem PAs espelhados e irá realizar esse
	 * espelhamento no mapa
	 */
	public MapaAlimentacaoDTO setMapaAlimentacaoDTO(ProgramaInsersoraDTO programa) {
		MapaAlimentacaoDTO retorno = new MapaAlimentacaoDTO();
		retorno.setResultadoEvento(retorno.getEVENTO_BEM_SUCEDIDO());

		DiversosRN rnDiv = new DiversosRN();
		rnDiv.setSession(getSession());

		PTRN prn = new PTRN(getDao());

		MapQuery q = new MapQuery(getSession());

		q.append("select distinct ommapa ");
		q.append("from OmMapa ommapa ");
		q.append("left join fetch ommapa.omPrg omprg ");
		q.append("left join fetch omprg.omPrgposes omprgpos ");
		q.append("where ommapa.cdMapa = :cdMapa and ommapa.stAtivo = 1 ");
		q.append("and ommapa.omPt.idPt = :idpt ");
		q.append("order by ommapa.revisao desc ");

		q.defineParametro("cdMapa", programa.getOmprg().getCdPrg());
		q.defineParametro("idpt", programa.getOmpt().getIdPt());

		OmMapa omMapaOriginal = null;
		OmMapa omMapaNovo = null;

		List<OmMapa> listaOmmapa = q.list();

		if (listaOmmapa.size() > 0) {
			omMapaOriginal = listaOmmapa.get(0);
		}

		omMapaNovo = new OmMapa();
		OmCfg cfg = Util.getConfigGeral(getSession());

		if (omMapaOriginal != null) {
			omMapaOriginal.setStAtivo((byte) 0);
			omMapaOriginal.setDtStativo(new Date());

			omMapaNovo.setRevisao(omMapaOriginal.getRevisao() + 1l);
			omMapaNovo.setOmProduto(omMapaOriginal.getOmProduto());
		} else {
			omMapaNovo.setRevisao(1l);
			omMapaNovo.setOmProduto(cfg.getOmProduto());
		}

		omMapaNovo.setIdMapa(0l);
		omMapaNovo.setCdMapa(programa.getOmprg().getCdPrg());
		omMapaNovo.setDsMapa(programa.getOmprg().getDsPrg());
		omMapaNovo.setDtRevisao(new Date());
		omMapaNovo.setStAtivo((byte) 1);
		omMapaNovo.setDtStativo(new Date());
		omMapaNovo.setOmPrg(programa.getOmprg());
		omMapaNovo.setOmPt(programa.getOmpt());
		omMapaNovo.setOmUsrByIdUsrrevisao(cfg.getOmUsrimpprog());
		omMapaNovo.setOmUsrByIdUsrstativo(cfg.getOmUsrimpprog());

		try {
			OmPt omPtRevisao = prn.getOmPt(omMapaNovo.getOmPt().getCdPt());
			omMapaNovo.setOmPt(omPtRevisao);
		} catch (Exception e) {
			retorno.setResultadoEvento(retorno.getERRO_POSTO_DESCONHECIDO());
			e.printStackTrace();
		}

		// Mantem os mapas anexos na nova revisao do Mapa
		if (omMapaOriginal != null && omMapaOriginal.getOmMapaAnexoForIdMapa() != null) {
			for (OmMapaAnexo anexo : omMapaOriginal.getOmMapaAnexoForIdMapa()) {
				OmMapaAnexo anexoNovo = new OmMapaAnexo();
				anexoNovo.setIdMapaAnexo(null);
				anexoNovo.setOmMapaByIdMapa(omMapaNovo);
				anexoNovo.setOmMapaByIdMapaFilho(anexo.getOmMapaByIdMapaFilho());
				omMapaNovo.getOmMapaAnexoForIdMapa().add(anexoNovo);
			}
		}

		if (retorno.getResultadoEvento() == retorno.getEVENTO_BEM_SUCEDIDO()) {
			try {
				if (omMapaOriginal != null) {
					omMapaOriginal = makePersistent(omMapaOriginal);
				}

				if (omMapaNovo != null) {
					omMapaNovo = makePersistent(omMapaNovo);
					retorno.setOmmapa((OmMapa) omMapaNovo.clone());
				}

				// Verifica se a chave secundaria existe se existir ignora e passa pro proximo
				q.novaConsulta();

				q.append("select ommapapa");
				q.append("from OmMapapa ommapapa ");
				q.append("where ommapapa.omMapa.idMapa = :idmapa ");
				q.append("and ommapapa.omPa.idPa = :idpa ");
				q.append("and ommapapa.omProduto.idProduto = :idproduto ");

				// Abaixo inclusao dos pontos de alimenta��oo do mapa
				for (OmPrgpos omprgpos : programa.getOmprgpos()) {

					// Descarta qq posicao que nao tenha o produto definido
					if (omprgpos.getOmProduto() == null || omprgpos.getOmProduto().getCdProduto() == null
							|| omprgpos.getOmProduto().getCdProduto().trim().equals(""))
						continue;

					OmMapapa ommapapa = new OmMapapa();
					ommapapa.setIdMapapa(0l);
					ommapapa.setOmMapa(omMapaNovo);
					ommapapa.setOmPa(omprgpos.getOmPa());
					ommapapa.setOmProduto(omprgpos.getOmProduto());

					ommapapa.setQtUsada(omprgpos.getQtUsada());
					ommapapa.setIsCiclounico(cfg.getIsImpMapaQtUnica());

					// A consulta abaixo serve para evitar que o mesmo PA para o mesmo mapa e posto seja cadastrado mais de uma vez
					q.defineParametro("idmapa", ommapapa.getOmMapa().getIdMapa());
					q.defineParametro("idpa", ommapapa.getOmPa().getIdPa());
					q.defineParametro("idproduto", ommapapa.getOmProduto().getIdProduto());

					if (q.list().size() <= 0) {
						// se nao existir incluir
						getSession().saveOrUpdate(ommapapa);
					}

					// Alessandre em 22-10-21 Se a posicao do mapa possuir produtos alternativos, então inclui-los no mapa
					if (omprgpos.getOmPrgposproalts() != null && omprgpos.getOmPrgposproalts().isEmpty() == false) {
						// avaliar se cada alternativo existe no banco se nao existir, incluir
						for (OmPrgposproalt omprgposproalt : omprgpos.getOmPrgposproalts()) {
							OmMapapaproalt proaltAux = getOmMapapaproalt(ommapapa, omprgposproalt.getOmProduto());
							if (proaltAux == null) {
								OmMapapaproalt proalt = new OmMapapaproalt();
								proalt.setIdMapapaproalt(null);
								proalt.setOmMapapa(ommapapa);
								proalt.setOmProduto(omprgposproalt.getOmProduto());
								getDao().makePersistent(proalt);
							}
						}
					}

					/*
					 * Verifica se existe um espelhamento para o PA, posto e MAPA. Se houver cadastra-lo
					 * 
					 */
					OmPtPaEspelho espelho = getTemEspelho(programa.getOmpt(), omprgpos.getOmPa(), omMapaNovo);
					if (espelho != null) {
						espelhar(programa.getOmpt(), omMapaNovo, omprgpos.getOmPa(), espelho, ommapapa, q);
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
				retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
			}
		}

		q = null;

		return retorno;
	}

	// metodo para pesquisa OmMapapaproalt a fim de determinar se ja existe ou nao
	private OmMapapaproalt getOmMapapaproalt(OmMapapa ommapapa, OmProduto omproduto) {
		MapQuery q = new MapQuery(getSession());
		q.append("select a");
		q.append("from OmMapapaproalt a");
		q.append("where a.omMapapa = :ommapapa and");
		q.append("a.omProduto = :omproduto");
		q.defineParametro("ommapapa", ommapapa);
		q.defineParametro("omproduto", omproduto);
		q.setMaxResults(1);

		return (OmMapapaproalt) q.uniqueResult();
	}

	// Metodo que criará novo PA em mapa a partir do espelhamento de um PA vindo do programa
	private void espelhar(OmPt ompt, OmMapa ommapa, OmPa ompa, OmPtPaEspelho espelho, OmMapapa ommapapa, MapQuery q2) {
		/* Encontra o PA espelhado a partir da definicao do espelhamento */
		String cdNovaMesa = espelho.getOmPtPa().getCdMesa();
		cdNovaMesa = "Z" + cdNovaMesa + ompa.getCdPa().substring(2);
		MapQuery q = new MapQuery(getSession());
		q.append("select b");
		q.append("from OmPt a");
		q.append("join a.omPas b");
		q.append("where a.stAtivo = 1");
		q.append("and b.stAtivo = 1");
		q.append("and a.cdPt = :cdpt");
		q.append("and b.cdPa = :cdpa");

		q.defineParametro("cdpt", ompt.getCdPt());
		q.defineParametro("cdpa", cdNovaMesa);
		q.setMaxResults(1);

		OmPa ompaNovo = (OmPa) q.uniqueResult();

		if (ompaNovo == null)
			return;

		OmMapapa ommapapaNovo = new OmMapapa();
		ommapapaNovo.setIdMapapa(0l);
		ommapapaNovo.setOmMapa(ommapa);
		ommapapaNovo.setOmPa(ompaNovo);
		ommapapaNovo.setOmProduto(ommapapa.getOmProduto());

		ommapapaNovo.setQtUsada(ommapapa.getQtUsada());
		ommapapaNovo.setIsCiclounico(ommapapa.getIsCiclounico());

		q2.defineParametro("idmapa", ommapapaNovo.getOmMapa().getIdMapa());
		q2.defineParametro("idpa", ommapapaNovo.getOmPa().getIdPa());
		q2.defineParametro("idproduto", ommapapaNovo.getOmProduto().getIdProduto());

		if (q2.list().size() <= 0) {
			// se nao existir incluir
			getSession().saveOrUpdate(ommapapaNovo);
		}

	}

	/* Mesmo que tenha espelho, caso o mapa avaliado esteja na lista de mapas excluidos, entao não devemos espelhar */
	private OmPtPaEspelho getTemEspelho(OmPt ompt, OmPa ompa, OmMapa ommapa) {
		MapQuery q = new MapQuery(getSession());
		q.append("select c");
		q.append("from OmPt a");
		q.append("join a.omPtPa b");
		q.append("join b.omPtPaEspelhos c");
		q.append("join c.omPa d");
		q.append("where a.stAtivo = 1");
		q.append("and a.cdPt = :cd");
		q.append("and d.cdPa = :cdpa");
		q.append("and not exists (from OmPtPaMapa e join e.omMapa f join e.omPtPa g where g.idPt = a.idPt and f.cdMapa = :cdmapa)");

		q.defineParametro("cd", ompt.getCdPt());
		q.defineParametro("cdpa", ompa.getCdPa());
		q.defineParametro("cdmapa", ommapa.getCdMapa());

		q.setMaxResults(1);

		OmPtPaEspelho espelho = (OmPtPaEspelho) q.uniqueResult();

		return espelho;
	}

	public MapasAlimentacaoDTO getMapasAlimentacaoDTO(MapaAlimentacaoDTO filtro) {

		String hql = "";
		hql += "select t ";
		hql += "from OmMapa t ";
		hql += "join fetch t.omPt ompt ";
		hql += "where 1=1 ";

		if (filtro.getOmmapa().getIdMapa() != 0) {
			hql += "AND t.idMapa=::idMapa: ";
		} else {
			if (!filtro.getOmmapa().getCdMapa().equals("")) {
				hql += "AND t.cdMapa like '%::cdMapa:%' ";
			}
			if (!filtro.getOmmapa().getDsMapa().equals("")) {
				hql += "AND t.dsMapa='::dsMapa:' ";
			}
			if (filtro.getOmmapa().getDtRevisao() != null) {
				hql += "AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF ";
			}
			if (filtro.getOmmapa().getDtStativo() != null) {
				hql += "AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF ";
			}
			if (!filtro.getOmmapa().getOmPrg().getCdPrg().equals("")) {
				hql += "AND t.omPrg.cdPrg like '::cdPrg:%' ";
			}
			if (!filtro.getOmmapa().getOmPrg().getDsPrg().equals("")) {
				hql += "AND t.omPrg.dsPrg='::dsPrg:' ";
			}

			if (!filtro.getOmmapa().getOmProduto().getCdProduto().equals("")) {
				hql += "AND t.omProduto.cdProduto='::cdProduto:' ";
			}
			if (!filtro.getOmmapa().getOmProduto().getDsProduto().equals("")) {
				hql += "AND t.omProduto.dsProduto='::dsProduto:' ";
			}
			if (!filtro.getOmmapa().getOmPt().getCdPt().equals("")) {
				hql += "AND ompt.cdPt='::cdPt:' and ompt.stAtivo = 1 ";
			}
			if (!filtro.getOmmapa().getOmPt().getDsPt().equals("")) {
				hql += "AND t.omPt.dsPt='::dsPt:' ";
			}
			if (!filtro.getOmmapa().getOmUsrByIdUsrrevisao().getCdUsr().equals("")) {
				hql += "AND t.omUsrByIdUsrrevisao.cdUsr='::cdUsrRev:' ";
			}
			if (!filtro.getOmmapa().getOmUsrByIdUsrrevisao().getDsNome().equals("")) {
				hql += "AND t.omUsrByIdUsrrevisao.dsNome='::dsNomeRev:' ";
			}
			if (!filtro.getOmmapa().getOmUsrByIdUsrstativo().getCdUsr().equals("")) {
				hql += "AND t.omUsrByIdUsrstativo.cdUsr='::cdUsrSt:' ";
			}
			if (!filtro.getOmmapa().getOmUsrByIdUsrstativo().getDsNome().equals("")) {
				hql += "AND t.omUsrByIdUsrstativo.dsNome='::dsNomeSt:' ";
			}
			if (filtro.getOmmapa().getRevisao() == null) {
				// hql += "AND t.revisao = (SELECT max(tr.revisao) as Revisao from OmMapa tr where tr.cdMapa = t.cdMapa ) ";
			} else {
				hql += "AND t.revisao=::revisao: ";
			}
			if (filtro.getOmmapa().getStAtivo() < (byte) 2) {
				hql += "AND t.stAtivo=::stAtivo: ";
			}
		}

		hql = hql.replaceAll("::idMapa:", String.valueOf(filtro.getOmmapa().getIdMapa()));
		hql = hql.replaceAll("::cdMapa:", filtro.getOmmapa().getCdMapa());
		hql = hql.replaceAll("::dsMapa:", filtro.getOmmapa().getDsMapa());

		hql = hql.replaceAll("::cdPrg:", filtro.getOmmapa().getOmPrg().getCdPrg());
		hql = hql.replaceAll("::dsPrg:", filtro.getOmmapa().getOmPrg().getDsPrg());
		hql = hql.replaceAll("::cdProduto:", filtro.getOmmapa().getOmProduto().getCdProduto());
		hql = hql.replaceAll("::dsProduto:", filtro.getOmmapa().getOmProduto().getDsProduto());
		hql = hql.replaceAll("::cdPt:", filtro.getOmmapa().getOmPt().getCdPt());
		hql = hql.replaceAll("::dsPt:", filtro.getOmmapa().getOmPt().getDsPt());
		hql = hql.replaceAll("::cdUsrRev:", filtro.getOmmapa().getOmUsrByIdUsrrevisao().getCdUsr());
		hql = hql.replaceAll("::dsNomeRev:", filtro.getOmmapa().getOmUsrByIdUsrrevisao().getDsNome());
		hql = hql.replaceAll("::cdUsrSt:", filtro.getOmmapa().getOmUsrByIdUsrstativo().getCdUsr());
		hql = hql.replaceAll("::dsNomeSt:", filtro.getOmmapa().getOmUsrByIdUsrstativo().getDsNome());
		hql = hql.replaceAll("::revisao:", String.valueOf(filtro.getOmmapa().getRevisao()));
		hql = hql.replaceAll("::stAtivo:", String.valueOf(filtro.getOmmapa().getStAtivo()));

		Query q = getSession().createQuery(hql);

		try {
			// q.setDate("dtRevisao", filtro.getOmmapa().getDtRevisao());
			q.setTimestamp("dtRevisao", filtro.getOmmapa().getDtRevisao());
			q.setTimestamp("dtRevisaoF", DataHoraRN.getDataHora235959(filtro.getOmmapa().getDtRevisao()));
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			// q.setDate("dtStativo", filtro.getOmmapa().getDtStativo());
			q.setTimestamp("dtStativo", filtro.getOmmapa().getDtStativo());
			q.setTimestamp("dtStativoF", DataHoraRN.getDataHora235959(filtro.getOmmapa().getDtStativo()));
		} catch (Exception e) {
			// TODO: handle exception
		}

		List<OmMapa> listaOmmapa = null;

		q.setMaxResults(10);
		listaOmmapa = q.list();

		List<MapaAlimentacaoDTO> lista = new ArrayList<MapaAlimentacaoDTO>();

		for (OmMapa ommapa : listaOmmapa) {
			MapaAlimentacaoDTO mapa = new MapaAlimentacaoDTO();
			mapa.setOmmapa((OmMapa) ommapa.clone());
			mapa.getOmmapa().getOmPt().setIdPt(ommapa.getOmPt().getIdPt());
			mapa.setMapaPas(new MapaPAsDTO());

			List<MapaPaDTO> pas = new ArrayList<MapaPaDTO>();
			for (OmMapapa item : ommapa.getOmMapapas()) {
				MapaPaDTO pa = new MapaPaDTO();
				pa.setMapaPa((OmMapapa) item.clone());

				pas.add(pa);
			}
			mapa.getMapaPas().setMapaPas(pas);

			// Retorna tambem os mapas anexados
			for (OmMapaAnexo anexo : ommapa.getOmMapaAnexoForIdMapa()) {
				mapa.getOmmapa().getOmMapaAnexoForIdMapa().add(anexo.clone());
			}

			mapa.setMapaPasParaExclusao(new MapaPAsDTO());
			mapa.getMapaPasParaExclusao().setMapaPas(new ArrayList<MapaPaDTO>());
			mapa.setResultadoEvento(0);
			lista.add(mapa);
		}

		MapasAlimentacaoDTO mapas = new MapasAlimentacaoDTO();
		mapas.setMapas(lista);

		hql = null;
		q = null;

		return mapas;
	}

	public MapaAlimentacaoDTO clearMapaAlimentacaoDTO() {
		MapaAlimentacaoDTO mapa = new MapaAlimentacaoDTO();
		mapa.setOmmapa(new OmMapa());
		mapa.setMapaPas(new MapaPAsDTO());
		mapa.getMapaPas().setMapaPas(new ArrayList<MapaPaDTO>());
		mapa.setMapaPasParaExclusao(new MapaPAsDTO());
		mapa.getMapaPasParaExclusao().setMapaPas(new ArrayList<MapaPaDTO>());
		mapa.getOmmapa().setStAtivo((byte) 1);
		return mapa;
	}

	public MapaAlimentacaoDTO setMapaAlimentacaoDTO(MapaAlimentacaoDTO mapa) {
		MapaAlimentacaoDTO mapaRetorno = new MapaAlimentacaoDTO();
		mapaRetorno.setResultadoEvento(mapaRetorno.getEVENTO_BEM_SUCEDIDO());

		if (mapa.getOmmapa().getCdMapa().trim().equals("")) {
			mapaRetorno.setResultadoEvento(mapaRetorno.getERRO_CDMAPAPA_INVALIDO());
			return mapaRetorno;
		}

		MapQuery q = new MapQuery(getSession());

		q.append("from OmMapa OmMapa where OmMapa.idMapa = :idMapa ");
		q.defineParametro("idMapa", mapa.getOmmapa().getIdMapa());

		OmMapa omMapaAlteracao = (OmMapa) q.uniqueResult();

		OmMapa omMapaOriginal = null;

		if (omMapaAlteracao == null) {
			omMapaOriginal = (OmMapa) mapa.getOmmapa().clone();
			omMapaOriginal.setRevisao(1l);
			omMapaOriginal.setDtRevisao(new Date());
			omMapaOriginal.setStAtivo((byte) 1);
			omMapaOriginal.setDtStativo(new Date());

			// Verifica se o codigo + revisao do usuario ja existe no banco, se exitir retornar ao cliente a excessao
			MapQuery mq = new MapQuery(getSession());

			mq.append("from OmMapa a ");
			mq.append("where a.cdMapa = :cdMapa ");
			mq.append("and a.stAtivo = 1");
			mq.append("and a.omPt.cdPt = :cdpt");

			mq.defineParametro("cdMapa", omMapaOriginal.getCdMapa());
			mq.defineParametro("cdpt", omMapaOriginal.getOmPt().getCdPt());

			if (mq.list().size() > 0) {
				mapaRetorno.setResultadoEvento(mapaRetorno.getERRO_MAPA_JA_EXISTE());
				return mapaRetorno;
			}
		} else {
			omMapaOriginal = (OmMapa) mapa.getOmmapa().clone();
			omMapaOriginal.setIdMapa(0l);
			omMapaOriginal.setRevisao(omMapaAlteracao.getRevisao() + 1);
			omMapaOriginal.setDtRevisao(new Date());
			omMapaOriginal.setStAtivo((byte) 1);
			omMapaOriginal.setDtStativo(new Date());

			omMapaAlteracao.setStAtivo((byte) 0);
			omMapaAlteracao.setDtStativo(new Date());
		}

		Set<OmMapapa> omMapaPas = new HashSet<OmMapapa>();
		if (mapa.getMapaPas().getMapaPas() != null) {
			for (MapaPaDTO item : mapa.getMapaPas().getMapaPas()) {
				omMapaPas.add((OmMapapa) item.getMapaPa().clone());
			}
		}
		omMapaOriginal.setOmMapapas(omMapaPas);

		q.novaConsulta();
		q.append("from OmPa t where t.idPa = :idPa");
		// atualiza OmMapaPas - OmPa e OmProduto

		MapQuery q2 = new MapQuery(getSession());
		q2.append("from OmProduto t where t.idProduto = :idProduto");

		for (OmMapapa item : omMapaOriginal.getOmMapapas()) {
			item.setOmMapa(omMapaOriginal);
			try {

				q.defineParametro("idPa", item.getOmPa().getIdPa());

				OmPa omPa = (OmPa) q.uniqueResult();

				item.setOmPa(omPa);
			} catch (Exception e) {
				mapaRetorno.setResultadoEvento(mapaRetorno.getERRO_POSTO_DESCONHECIDO());
				e.printStackTrace();
			}

			try {

				q2.defineParametro("idProduto", item.getOmProduto().getIdProduto());

				OmProduto omProduto = (OmProduto) q2.uniqueResult();

				item.setOmProduto(omProduto);
			} catch (Exception e) {
				mapaRetorno.setResultadoEvento(mapaRetorno.getERRO_PRODUTO_DESCONHECIDO());
				e.printStackTrace();
			}

		}

		if (!mapa.getOmmapa().getOmPrg().getCdPrg().equals("")) {
			try {
				q.novaConsulta();
				q.append("from OmPrg t where t.cdPrg = :cdPrg and t.stAtivo = 1 ");
				q.append("order by t.idPrg ");

				q.defineParametro("cdPrg", mapa.getOmmapa().getOmPrg().getCdPrg());
				q.setMaxResults(1);

				OmPrg omPrg = (OmPrg) q.uniqueResult();

				omMapaOriginal.setOmPrg(omPrg);
			} catch (Exception e) {
				mapaRetorno.setResultadoEvento(mapaRetorno.getERRO_PROGRAMA_DESCONHECIDO());
				e.printStackTrace();
				return mapaRetorno;
			}
		} else {
			omMapaOriginal.setOmPrg(null);
		}

		if (mapa.getOmmapa().getDwFolha() != null && mapa.getOmmapa().getDwFolha().getCdFolha() != null
				&& mapa.getOmmapa().getDwFolha().getCdFolha().equals("") == false) {
			FolhaRN rn = new FolhaRN(getDao());
			DwFolha dwfolha = rn.pesquisaFolhaByCdEStSemRota(mapa.getOmmapa().getDwFolha().getCdFolha());
			if (dwfolha == null) {
				mapaRetorno.setResultadoEvento(mapaRetorno.getERRO_FOLHA_DESCONHECIDA());
				return mapaRetorno;
			}
			omMapaOriginal.setDwFolha(dwfolha);
		} else {
			omMapaOriginal.setDwFolha(null);
		}

		try {
			q.novaConsulta();
			q.append("from OmProduto t where t.cdProduto = :cdProduto ");
			q.append("and t.stAtivo = 1 ");
			q.append("order by t.idProduto ");
			q.defineParametro("cdProduto", mapa.getOmmapa().getOmProduto().getCdProduto());
			q.setMaxResults(1);

			OmProduto omProduto = (OmProduto) q.uniqueResult();

			if (omProduto == null) {
				mapaRetorno.setResultadoEvento(mapaRetorno.getERRO_PRODUTO_DESCONHECIDO());
				return mapaRetorno;
			}

			omMapaOriginal.setOmProduto(omProduto);
		} catch (Exception e) {
			mapaRetorno.setResultadoEvento(mapaRetorno.getERRO_PRODUTO_DESCONHECIDO());
			e.printStackTrace();
			return mapaRetorno;
		}

		try {
			q.novaConsulta();
			q.append("from OmPt t where t.cdPt = :cdPt ");
			q.append("and t.stAtivo = 1 ");
			q.append("order by t.idPt ");

			q.defineParametro("cdPt", mapa.getOmmapa().getOmPt().getCdPt());
			q.setMaxResults(1);

			OmPt omPt = (OmPt) q.uniqueResult();

			omMapaOriginal.setOmPt(omPt);
		} catch (Exception e) {
			mapaRetorno.setResultadoEvento(mapaRetorno.getERRO_POSTO_DESCONHECIDO());
			e.printStackTrace();
			return mapaRetorno;
		}

		UsuarioRN urn = new UsuarioRN(getDao());
		try {
			OmUsr omUsrRevisao = urn.getOmUsr(mapa.getOmmapa().getOmUsrByIdUsrrevisao().getCdUsr());
			omMapaOriginal.setOmUsrByIdUsrrevisao(omUsrRevisao);
		} catch (Exception e) {
			mapaRetorno.setResultadoEvento(mapaRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
			e.printStackTrace();
			return mapaRetorno;
		}

		try {
			OmUsr omUsrStAtivo = urn.getOmUsr(mapa.getOmmapa().getOmUsrByIdUsrstativo().getCdUsr());
			omMapaOriginal.setOmUsrByIdUsrstativo(omUsrStAtivo);
		} catch (Exception e) {
			mapaRetorno.setResultadoEvento(mapaRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
			e.printStackTrace();
			return mapaRetorno;
		}

		// Prepara para salvar os mapas anexos
		q.novaConsulta();
		q.append("select a");
		q.append("from OmMapa a");
		q.append("where a.stAtivo = 1");
		q.append("and a.cdMapa = :cd");
		q.setMaxResults(1);
		for (OmMapaAnexo anexo : mapa.getOmmapa().getOmMapaAnexoForIdMapa()) {
			anexo.setOmMapaByIdMapa(omMapaOriginal);
			q.defineParametro("cd", anexo.getOmMapaByIdMapaFilho().getCdMapa());
			OmMapa mapafilho = (OmMapa) q.uniqueResult();
			anexo.setOmMapaByIdMapaFilho(mapafilho);
		}
		omMapaOriginal.setOmMapaAnexoForIdMapa(mapa.getOmmapa().getOmMapaAnexoForIdMapa());

		if (mapaRetorno.getResultadoEvento() == mapaRetorno.getEVENTO_BEM_SUCEDIDO()) {
			try {
				omMapaOriginal = makePersistent(omMapaOriginal);
				if (omMapaAlteracao != null) {
					omMapaAlteracao = makePersistent(omMapaAlteracao);
				}
			} catch (Exception e) {
				e.printStackTrace();
				mapaRetorno.setResultadoEvento(mapaRetorno.getERRO_DESCONHECIDO());
				return mapaRetorno;
			}

			mapaRetorno.setOmmapa((OmMapa) omMapaOriginal.clone());
			mapaRetorno.setMapaPas(new MapaPAsDTO());

			List<MapaPaDTO> pas = new ArrayList<MapaPaDTO>();
			for (OmMapapa item : omMapaOriginal.getOmMapapas()) {
				MapaPaDTO pa = new MapaPaDTO();
				pa.setMapaPa((OmMapapa) item.clone());

				pas.add(pa);
			}
			mapaRetorno.getMapaPas().setMapaPas(pas);

			mapaRetorno.setMapaPasParaExclusao(new MapaPAsDTO());
			mapaRetorno.getMapaPasParaExclusao().setMapaPas(new ArrayList<MapaPaDTO>());
		}

		q2 = null;
		q = null;

		return mapaRetorno;
	}

	public MapasAlimentacaoDTO removeMapasAlimentacaoDTO(MapasAlimentacaoDTO mapas) {

		List<MapaAlimentacaoDTO> listaRetorno = new ArrayList<MapaAlimentacaoDTO>();
		for (MapaAlimentacaoDTO mapa : mapas.getMapas()) {
			MapaAlimentacaoDTO mapaRetorno = new MapaAlimentacaoDTO();
			String hql = "";

			hql = "from OmMapa OmMapa where OmMapa.idMapa = ::idMapa";
			hql = hql.replaceAll("::idMapa", String.valueOf(mapa.getOmmapa().getIdMapa()));

			Query q = getSession().createQuery(hql);

			OmMapa OmMapa = (OmMapa) q.uniqueResult();

			if (OmMapa == null) {
				mapaRetorno.setResultadoEvento(4);
				mapaRetorno.setOmmapa(mapa.getOmmapa());
			} else if (OmMapa.getStAtivo() == 0) {
				mapaRetorno.setResultadoEvento(4);
				mapaRetorno.setOmmapa(mapa.getOmmapa());
			} else {
				OmMapa.setStAtivo((byte) 0);
				OmMapa.setDtStativo(new Date());

				try {
					hql = "from OmUsr t where t.cdUsr = '::cdUsr' ";
					hql = hql.replaceAll("::cdUsr", mapa.getOmmapa().getOmUsrByIdUsrstativo().getCdUsr());

					q = getSession().createQuery(hql);

					OmUsr omUsrStAtivo = (OmUsr) q.uniqueResult();

					OmMapa.setOmUsrByIdUsrstativo(omUsrStAtivo);
				} catch (Exception e) {
					// TODO: handle exception
				}

				try {
					OmMapa = makePersistent(OmMapa);
				} catch (Exception e) {
					e.printStackTrace();
				}

				mapaRetorno.setOmmapa((OmMapa) OmMapa.clone());

				mapaRetorno.setMapaPas(new MapaPAsDTO());

				List<MapaPaDTO> mapaPas = new ArrayList<MapaPaDTO>();
				for (OmMapapa item : OmMapa.getOmMapapas()) {
					MapaPaDTO mapaPa = new MapaPaDTO();
					mapaPa.setMapaPa((OmMapapa) item.clone());

					mapaPas.add(mapaPa);
				}
				mapaRetorno.getMapaPas().setMapaPas(mapaPas);

				mapaRetorno.setMapaPasParaExclusao(new MapaPAsDTO());
				mapaRetorno.getMapaPasParaExclusao().setMapaPas(new ArrayList<MapaPaDTO>());

				mapaRetorno.setResultadoEvento(0);
			}

			listaRetorno.add(mapaRetorno);
		}

		MapasAlimentacaoDTO mapasRetorno = new MapasAlimentacaoDTO();
		mapasRetorno.setMapas(listaRetorno);
		return mapasRetorno;
	}

	public MapaAlimentacaoDTO ativaMapaAlimentacaoDTO(MapaAlimentacaoDTO pt) {
		MapaAlimentacaoDTO mapaRetorno = new MapaAlimentacaoDTO();
		String hql = "";

		// Verifica se a revisao que esta sendo reativada a maior para o codigo
		hql = "";

		hql += "from OmMapa OmMapa ";
		hql += "where OmMapa.cdMapa = '::cdMapa' ";
		hql += "and OmMapa.revisao > ::revisao ";

		hql = hql.replaceAll("::cdMapa", pt.getOmmapa().getCdMapa());
		hql = hql.replaceAll("::revisao", String.valueOf((pt.getOmmapa().getRevisao())));
		Query qRev = getSession().createQuery(hql);

		if (qRev.list().size() > 0) {
			mapaRetorno.setResultadoEvento(mapaRetorno.getERRO_REATIVACAO_INDISPONIVEL());
			return mapaRetorno;
		}

		hql = "from OmMapa OmMapa where OmMapa.idMapa = ::idMapa";
		hql = hql.replaceAll("::idMapa", String.valueOf(pt.getOmmapa().getIdMapa()));

		Query q = getSession().createQuery(hql);

		OmMapa OmMapa = (OmMapa) q.uniqueResult();

		if (OmMapa == null) {
			mapaRetorno.setResultadoEvento(4);
			mapaRetorno.setOmmapa(pt.getOmmapa());
			return mapaRetorno;
		} else if (OmMapa.getStAtivo() == 1) {
			mapaRetorno.setResultadoEvento(4);
			mapaRetorno.setOmmapa(pt.getOmmapa());
		} else {
			OmMapa.setStAtivo((byte) 1);
			OmMapa.setDtStativo(new Date());

			try {
				hql = "from OmUsr t where t.cdUsr = '::cdUsr' ";
				hql = hql.replaceAll("::cdUsr", pt.getOmmapa().getOmUsrByIdUsrstativo().getCdUsr());

				q = getSession().createQuery(hql);

				OmUsr omUsrStAtivo = (OmUsr) q.uniqueResult();

				OmMapa.setOmUsrByIdUsrstativo(omUsrStAtivo);
			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				OmMapa = makePersistent(OmMapa);
			} catch (Exception e) {
				e.printStackTrace();
			}

			mapaRetorno.setOmmapa((OmMapa) OmMapa.clone());
			mapaRetorno.setMapaPas(new MapaPAsDTO());

			List<MapaPaDTO> pas = new ArrayList<MapaPaDTO>();
			for (OmMapapa item : OmMapa.getOmMapapas()) {
				MapaPaDTO pa = new MapaPaDTO();
				pa.setMapaPa((OmMapapa) item.clone());

				pas.add(pa);
			}
			mapaRetorno.getMapaPas().setMapaPas(pas);

			mapaRetorno.setMapaPasParaExclusao(new MapaPAsDTO());
			mapaRetorno.getMapaPasParaExclusao().setMapaPas(new ArrayList<MapaPaDTO>());
		}
		hql = null;
		q = null;

		return mapaRetorno;
	}

	public MapaPaDTO validarMapaPaDTO(MapaPaDTO mapaPa) {
		MapaPaDTO mapaRetorno = new MapaPaDTO();
		mapaRetorno.setResultadoEvento(mapaRetorno.getEVENTO_BEM_SUCEDIDO());

		MapQuery q = new MapQuery(getSession());

		OmMapapa omMapapa = new OmMapapa();
		omMapapa.setIdMapapa(mapaPa.getMapaPa().getIdMapapa());
		omMapapa.setQtUsada(mapaPa.getMapaPa().getQtUsada());
		omMapapa.setIsCiclounico(mapaPa.getMapaPa().getIsCiclounico());

		try {
			q.append("from OmPa t where t.idPa = :idPa");

			q.defineParametro("idPa", mapaPa.getMapaPa().getOmPa().getIdPa());

			OmPa omPa = (OmPa) q.uniqueResult();

			if (omPa == null) {
				mapaRetorno.setResultadoEvento(mapaRetorno.getERRO_PA_DESCONHECIDO());
				return mapaRetorno;
			}

			omMapapa.setOmPa(omPa);
		} catch (Exception e) {
			e.printStackTrace();
			mapaRetorno.setResultadoEvento(mapaRetorno.getERRO_PA_DESCONHECIDO());
			return mapaRetorno;
		}

		try {
			q.novaConsulta();
			q.append("from OmProduto t where t.cdProduto = :cdProduto AND t.stAtivo = 1");

			q.defineParametro("cdProduto", mapaPa.getMapaPa().getOmProduto().getCdProduto());

			OmProduto omProduto = (OmProduto) q.uniqueResult();

			if (omProduto == null) {
				mapaRetorno.setResultadoEvento(mapaRetorno.getERRO_PRODUTO_DESCONHECIDO());
				return mapaRetorno;
			}

			omMapapa.setOmProduto(omProduto);
		} catch (Exception e) {
			e.printStackTrace();
			mapaRetorno.setResultadoEvento(mapaRetorno.getERRO_PRODUTO_DESCONHECIDO());
			return mapaRetorno;
		}

		mapaRetorno.setMapaPa((OmMapapa) omMapapa.clone());

		return mapaRetorno;

	}

	public MapasCODTO getMapasCODTO(String maquina) {
		MapasCODTO mapas = new MapasCODTO();

		mapas.setCdPt(maquina);

		MapQuery q = new MapQuery(getSession());

		q.append("select t ");
		q.append("from OmMapa t ");
		q.append("where t.stAtivo = 1 ");
		q.append("AND t.omPt.stAtivo = 1 ");
		q.append("AND t.omPt.cdPt = :maquina");
		q.append("order by t.cdMapa ");

		q.defineParametro("maquina", maquina);

		List<OmMapa> listaOmmapa = null;

		listaOmmapa = q.list();

		if (listaOmmapa.size() > 0) {
			try {
				OmPt omPt = ((OmMapa) q.list().get(0)).getOmPt();
				MapaCODTO mapaAtual = new MapaCODTO();
				MapaCODTO mapaCorrente = new MapaCODTO();

				if (omPt.getOmAlimByIdAlimpre() != null) {
					mapas.setMapaPreConferidoParaPT(omPt.getOmAlimByIdAlimpre().getIdAlim());

					mapaAtual.setCdMapa(omPt.getOmAlimByIdAlimpre().getOmMapa().getCdMapa());
					mapaAtual.setIdMapa(omPt.getOmAlimByIdAlimpre().getOmMapa().getIdMapa());
				}
				if (omPt.getOmAlimByIdAlim() != null) {
					mapas.setMapaConferidoParaPT(omPt.getOmAlimByIdAlim().getIdAlim());

					mapaAtual.setCdMapa(omPt.getOmAlimByIdAlim().getOmMapa().getCdMapa());
					mapaAtual.setIdMapa(omPt.getOmAlimByIdAlim().getOmMapa().getIdMapa());
				}
				if (omPt.getOmAlimByIdAlimcorrente() != null) {
					mapas.setMapaCorrenteParaPT(omPt.getOmAlimByIdAlimcorrente().getIdAlim());

					mapaCorrente.setCdMapa(omPt.getOmAlimByIdAlimcorrente().getOmMapa().getCdMapa());
					mapaCorrente.setIdMapa(omPt.getOmAlimByIdAlimcorrente().getOmMapa().getIdMapa());
				}
				mapas.setMapaAtual(mapaAtual);
				mapas.setMapaCorrente(mapaCorrente);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		DiversosRN rnDiversos = new DiversosRN();
		rnDiversos.setSession(getSession());
		OmCfg omcfg = Util.getConfigGeral(getSession());

		List<MapaCODTO> lista = new ArrayList<MapaCODTO>();

		for (OmMapa omMapa : listaOmmapa) {
			MapaCODTO mapa = new MapaCODTO();
			mapa.setCdMapa(omMapa.getCdMapa());
			mapa.setIdMapa(omMapa.getIdMapa());
			mapa.setIsControlarNivelAlimentacao(omcfg.getIsNivelfeeder());
			lista.add(mapa);
		}

		mapas.setMapas(lista);

		// Verifica se existe um programa carregado na maquina
		q.novaConsulta();
		q.append("select msup");
		q.append("from MsUp msup");
		q.append("where msup.cdUp = :cdup");
		q.append("and msup.stAtivo = 1");

		q.setMaxResults(1);
		q.defineParametro("cdup", maquina);

		MsUp msup = (MsUp) q.uniqueResult();

		if (msup != null) {
			mapas.setProgramaNaMaquina(msup.getNrop());
		}

		q = null;

		return mapas;
	}

	public boolean isMapaValido(String maquina, String mapa) {

		String hql = "";
		hql += "select t ";
		hql += "from OmMapa t ";
		hql += "where t.stAtivo = 1 ";
		hql += "AND t.cdMapa = '::mapa' ";
		hql += "AND t.omPt.stAtivo = 1 ";
		hql += "AND t.omPt.cdPt = '::maquina' ";

		hql = hql.replaceAll("::mapa", mapa);
		hql = hql.replaceAll("::maquina", maquina);

		Query q = getSession().createQuery(hql);

		List<OmMapa> listaOmmapa = null;

		listaOmmapa = q.list();

		hql = null;

		if (listaOmmapa.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public PosicoesCODTO getPosicoesCODTO(String maquina, String mapa, Boolean isUsarEspelhamento) {
		PosicoesCODTO posicoes = new PosicoesCODTO();

		MapQuery qM = new MapQuery(getSession());

		// Verifica se esse mapa junto com a maquina possui espelhamento. Se sim, retorna para o CF perguntar ao operador se o espelhamento
		// será usado
		qM.append("select a");
		qM.append("from OmPt a");
		qM.append("join a.omPtPa b");
		qM.append("join b.omPtPaEspelhos c");
		qM.append("where a.cdPt = :cdpt");
		qM.append("and a.stAtivo = 1");
		qM.append("and not exists (select d from OmPtPaMapa d join d.omMapa e where d.omPtPa = b and e.cdMapa = :cdmapa)");

		qM.defineParametro("cdmapa", mapa);
		qM.defineParametro("cdpt", maquina);

		qM.setMaxResults(1);

		OmPt ompt = (OmPt) qM.uniqueResult();

		if (ompt != null) {
			posicoes.setPosicoesEspelhadas(true);
		} else {
			posicoes.setPosicoesEspelhadas(false);
		}

		// pegar a relacao de todos os MAPAs anexados tambem
		qM.novaConsulta();
		qM.append("select c");
		qM.append("from OmMapa a");
		qM.append("join a.omMapaAnexoForIdMapa b");
		qM.append("join b.omMapaByIdMapaFilho c");
		qM.append("where a.cdMapa = :cdmapa");
		qM.append("and a.stAtivo = 1");

		qM.defineParametro("cdmapa", mapa);

		List<OmMapa> mapas = qM.list();
		List<Object> cdmapas = new ArrayList<>();

		for (OmMapa ommapa : mapas) {
			cdmapas.add(ommapa.getCdMapa());
		}
		cdmapas.add(mapa);

		MapQuery q = new MapQuery(getSession());
		q.append("select t ");
		q.append("from OmMapapa t ");
		q.append("join fetch t.omPa ompa ");
		q.append("join fetch t.omMapa ommapa ");
		q.append("join fetch ommapa.omPt ompt ");
		q.append("where ommapa.cdMapa in :mapa ");
		q.append("AND ommapa.stAtivo = 1 ");
		q.append("AND ompt.cdPt = :maquina ");
		q.append("AND ompt.stAtivo = 1 ");
		q.append("order by ompa.ordem ");

		q.defineListaParametro("mapa", cdmapas);
		q.defineParametro("maquina", maquina);

		List<OmMapapa> listaOmmapaPa = null;

		listaOmmapaPa = q.list();

		List<PosicaoCODTO> lista = new ArrayList<>();

		MapQuery qu = new MapQuery(getSession());
		qu.append("select omalim");
		qu.append("from OmAlim omalim");
		qu.append("join omalim.omAlimreas omalimrea");
		qu.append("where omalim.omMapa = :ommapa");
		qu.append("and omalimrea.omMapapa = :ommapapa");
		qu.append("order by omalim.idAlim desc");
		qu.setMaxResults(1);

		for (OmMapapa omMapapa : listaOmmapaPa) {

			// Verificar se existe espelhamento e se ele deve ser descartado
			if (posicoes.isPosicoesEspelhadas() && isUsarEspelhamento == false
					&& omMapapa.getOmPa().getOrdem() >= ompt.getOmPtPa().getOrdemInicial()) {
				continue;
			}

			// pesquisar qual foi o RAP desse PA
			qu.defineParametro("ommapa", omMapapa.getOmMapa());
			qu.defineParametro("ommapapa", omMapapa);
			OmAlim omalim = (OmAlim) qu.uniqueResult();

			PosicaoCODTO posicao = new PosicaoCODTO();
			posicao.setCdFeeder(omMapapa.getOmPa().getCdPa());

			if (omalim != null && omalim.getOmAlimreas() != null) {
				for (OmAlimrea rea : omalim.getOmAlimreas()) {
					if (rea.getOmMapapa().getIdMapapa() == omMapapa.getIdMapapa()) {
						posicao.setCdRap(rea.getCbRap()); // eh importante ter o rap pois servira para a realimentacao
					}
				}
			}

			posicao.setCdMapa(omMapapa.getOmMapa().getCdMapa());
			posicao.setCdProduto(omMapapa.getOmProduto().getCdProduto());
			posicao.setDesvio(omMapapa.getOmPa().getDesvio());
			posicao.setOrdem(omMapapa.getOmPa().getOrdem());
			if (posicao.getDesvio() == null) {
				posicao.setDesvio(getDesvio(omMapapa));
			}
			posicao.setIdFeeder(omMapapa.getOmPa().getIdPa());
			posicao.setIdMapapa(omMapapa.getIdMapapa());
			posicao.setIdProduto(omMapapa.getOmProduto().getIdProduto());
			posicao.setLido(false);

			lista.add(posicao);

		}

		// Ordena os feeder com o objetivo de verificar se existem cdfeeder repetidos. Se sim, utilizar apens o feeder referente ao mapa
		// solicitado
		Collections.sort(lista, new Comparator<PosicaoCODTO>() {
			@Override
			public int compare(PosicaoCODTO o1, PosicaoCODTO o2) {
				return o1.getCdFeeder().compareTo(o2.getCdFeeder());
			}
		});

		// Avalia se existe duplicacao de feeder
		List<PosicaoCODTO> retorno = new ArrayList<>();
		PosicaoCODTO posicaoAnterior = null;
		for (PosicaoCODTO posicao : lista) {

			// Para o 1o feeder salvar e reavaliar no proixmo
			if (posicaoAnterior == null) {
				posicaoAnterior = posicao;
				continue;
			}

			// Se a posicao avaliada for igual a anterior, decide qual é do mapa passado por parametro e utilizar a do mapa do parametro
			if (posicaoAnterior.getCdFeeder().equals(posicao.getCdFeeder()) && posicaoAnterior.getCdMapa().equals(mapa) == false) {
				retorno.add(posicao);
			} else {
				retorno.add(posicaoAnterior);
			}

			posicaoAnterior = posicao;
		}
		// Ao final utilizar a ultima posicao que faltou entrar no retorno
		if (posicaoAnterior != null)
			retorno.add(posicaoAnterior);

		posicoes.setPosicoes(retorno);
		q = null;
		qu = null;
		qM = null;
		return posicoes;
	}

	public PosicoesCODTO getPosicaoAlternativos(String maquina, String mapa) {
		PosicoesCODTO posicoes = new PosicoesCODTO();

		MapQuery q = new MapQuery(getSession());
		q.append("select b.cdPt, g.cdProduto, d.cdPa ");
		q.append("from OmMapa a");
		q.append("join a.omPt b");
		q.append("join a.omMapapas c");
		q.append("join c.omPa d");
		q.append("join c.omProduto e");
		// q.append("left join e.omProaltglosForIdProdutoMae.omProdutoByIdProdutoMae f ");
		q.append("left join e.omProaltglosForIdProdutoMae f");
		q.append("left join f.omProdutoByIdProdutoFilho g");
		q.append("where a.dsMapa = :mapa");
		q.append("and b.cdPt = :maquina");
		q.append("and a.stAtivo = 1");
		// q.append("and e.cdProduto <> 0");
		// q.append("and e.idProduto = f.omProdutoByIdProdutoMae");
		// q.append("");
		// q.append("and e.cdProduto is not NULL");
		q.append("order by d.cdPa");
		q.defineParametro("mapa", mapa);
		q.defineParametro("maquina", maquina);

		List<Object> resultado = new ArrayList<Object>();
		Iterator<Object> iterator;
		resultado = q.list();
		iterator = q.list().iterator();

		Object[] lista;
		List<PosicaoCODTO> listaPosicao = new ArrayList<>();
		while (iterator.hasNext()) {
			PosicaoCODTO posicao = new PosicaoCODTO();
			lista = (Object[]) iterator.next();
			posicao.setCdFeeder((String) lista[2]);
			posicao.setCdProduto((String) lista[1]);
			listaPosicao.add(posicao);
		}

		posicoes.setPosicoes(listaPosicao);

		return posicoes;

	}

	private String getDesvio(OmMapapa omMapapa) {
		String retorno = "";

		String hql = "";

		hql += "from OmPa ompa ";
		hql += "where ";
		hql += "ompa.omPt.idPt = ::idpt ";
		hql += "and ompa.ordem <= ::ordem ";
		hql += "and ompa.stAtivo = 1 ";
		hql += "order by ompa.ordem desc ";

		hql = hql.replaceAll("::idpt", String.valueOf(omMapapa.getOmPa().getOmPt().getIdPt()));
		hql = hql.replaceAll("::ordem", String.valueOf(omMapapa.getOmPa().getOrdem()));

		Query q = getSession().createQuery(hql);

		List<OmPa> lista = q.list();

		for (OmPa ompa : lista) {
			if (ompa.getDesvio() != null) {
				retorno = ompa.getDesvio();
				break;
			}
		}
		hql = null;
		q = null;

		return retorno;
	}

	public static void main(String[] args) {
		MapaAlimentacaoRN rn = new MapaAlimentacaoRN();
		IdwLogger log = new IdwLogger("teste");
		int idLog = log.getIdAleatorio();
		int identacao = 0;

		PTRN ptrn = new PTRN();
		ptrn.setDao(rn.getDao());
		rn.iniciaConexaoBanco();
		OmPt ompt = null;
		try {
			ompt = ptrn.getOmPt("NXTL12");
		} catch (RegistroDesconhecidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		OmMapapa ommapapa = rn.getMapapaByProdutoFeeder("21-201-710012B", "20025", ompt, log, idLog, identacao);

		// if (ommapapa != null) {
		// System.out.println("idMapapa = " + ommapapa.getIdMapapa());
		// } else
		// System.out.println("ommapapa null");

		rn.finalizaConexaoBanco();
	}

	// FIXME pesquisa em ommappa só está usando cdProduto e cdFeeder, mas deste jeito pode pegar um ommapapa de qualquer OmMapa. O ideal
	// seria usar mais o filtro de pt/programa, para selecionar um mapaespecífco
	// Alessandre em 27-07-18 acrescentei o cdPt para atraves do ompt.omAlim descobrir o mapa correte, entao para encontramos o componente
	// eh necessario estar utilizando o CF adequadamente
	public OmMapapa getMapapaByProdutoFeeder(String cdProduto, String cdFeeder, OmPt ompt, IdwLogger log, int idLog, int identacao) {

		OmMapapa retorno = null;
		MapQuery q = new MapQuery(getSession());
		q.append("select ommapapa");
		q.append("from OmMapa ommapa");
		q.append("join ommapa.omMapapas ommapapa");
		q.append("join ommapapa.omProduto omproduto");
		q.append("join ommapapa.omPa ompa");
		q.append("join ommapa.omAlims omalim");
		q.append("where omproduto.cdProduto = :cdproduto");
		q.append("and ompa.depara = :cdpa");
		// q.append("and ommapa.stAtivo = 1"); comentado pois o mapa pode ja ter sido alterado entao o stativo sera 0
		q.append("and omalim.idAlim = :idalim");

		q.defineParametro("cdproduto", cdProduto);
		q.defineParametro("cdpa", cdFeeder);
		

		// Pesquisa ultima alimentacao da maquina
		AlimentacaoRN arn = new AlimentacaoRN();
		arn.setDao(getDao());
		OmAlim omalim = arn.pesquisarUltimasAlimentacoesSomenteOmAlim(ompt.getCdPt());
		if (omalim == null) {
			log.info(idLog, identacao, "PT nao tem alimentacao pesquisarUltimasAlimentacoesOAlim");
			return null;
		}

		q.defineParametro("idalim", omalim.getIdAlim());

		q.setMaxResults(1);

		retorno = (OmMapapa) q.uniqueResult();

		return retorno;
	}

	public String validaPosicoes(PosicoesCODTO posicoes, String maquina, String mapa) {
		String cdPa = "";
		String cdProduto = "";
		OmMapapaDAO omMapapaDAO = new OmMapapaDAO(getSession());

		for (PosicaoCODTO posicao : posicoes.getPosicoes()) {
			cdPa = posicao.getCdFeeder();
			cdProduto = posicao.getCdProduto();

			boolean isValida = isPosicaoValida(omMapapaDAO, cdPa, cdProduto, maquina, mapa);
			if (!isValida) {
				return posicao.getCdFeeder();
			}

		}

		return "ok";

	}

	private boolean isPosicaoValida(OmMapapaDAO omMapapaDAO, String posicao, String produto,
			String maquina, String mapa) {

		try {
			OmMapapa omMapapa = omMapapaDAO.getPosicaoValida(maquina, mapa, posicao, produto);
			return (omMapapa != null);
		} catch (HibernateException e) {
			throw new RuntimeException(
					String.format("%s. %s. Erro ao ler posicao %s. maquina=%s;mapa=%s;posicao=%s;produto=%s",
							e.getClass().getName(), e.getMessage(),
							posicao, maquina, mapa, posicao, produto),
					e);
		}

	}

	public boolean validaPosicaoEProdutoRealim(String posicao, String produto,
			String maquina, String mapa) {
		OmMapapaDAO omMapapaDAO = new OmMapapaDAO(getSession());
		return isPosicaoValida(omMapapaDAO, posicao, produto, maquina, mapa);
	}

	/*
	 * Metodo retorna os mapas para serem usados na alimentacao da app
	 * 
	 */
	public MapasCODTO getMapasDTO(String cdpt) {
		MapasCODTO mapas = new MapasCODTO();

		mapas.setCdPt(cdpt);

		// Obtem a ultima alimentacao, a fim de pegar o mapa
		OmAlim omalim;
		OmMapa ommapaAtual = null;
		OmMapa ommapaCarregado = null;

		AlimentacaoRN arn = new AlimentacaoRN();
		arn.setDao(getDao());
		omalim = arn.pesquisarUltimasAlimentacoesSomenteOmAlim(cdpt);
		if (omalim != null)
			ommapaAtual = omalim.getOmMapa();

		// Verifica se existe um programa carregado na maquina
		MapQuery qUp = new MapQuery(getSession());
		qUp.append("select msup");
		qUp.append("from MsUp msup");
		qUp.append("where msup.cdUp = :cdup");
		qUp.append("and msup.stAtivo = 1");

		qUp.setMaxResults(1);
		qUp.defineParametro("cdup", cdpt);

		MsUp msup = (MsUp) qUp.uniqueResult();

		if (msup != null) {
			if (msup.getNomePrograma() != null)
				mapas.setProgramaNaMaquina(msup.getNomePrograma());
			else
				mapas.setProgramaNaMaquina(msup.getNrop());
		}

		MapQuery q = new MapQuery(getSession());

		q.append("select t ");
		q.append("from OmMapa t ");
		q.append("where t.stAtivo = 1 ");
		q.append("AND t.omPt.stAtivo = 1 ");
		q.append("AND t.omPt.cdPt = :maquina");
		// q.append("order by t.cdMapa "); a ordenacao sera diferenciada mais a frente

		q.defineParametro("maquina", cdpt);

		List<OmMapa> listaOmmapa = null;

		listaOmmapa = q.list();

		List<MapaCODTO> lista = new ArrayList<MapaCODTO>();

		for (OmMapa omMapa : listaOmmapa) {

			/*
			 * Alessandre em 24-11-21 o mapa atual entra na lista pq pode ser uma nova revisao que desejam alimentar corretamente
			 * 
			 */
			// // O mapa atual não entra nessa lista
			// if (ommapaAtual != null && omMapa.getCdMapa().compareTo(ommapaAtual.getCdMapa()) == 0)
			// continue;

			MapaCODTO mapa = new MapaCODTO();

			// O programa carregado em máquina deve ser indicado afim de aparecer como 1a opcao
			if (mapas.getProgramaNaMaquina() != null && omMapa.getCdMapa().compareTo(mapas.getProgramaNaMaquina()) == 0) {
				ommapaCarregado = omMapa;
				continue; // ano inclui na lista
			}
			mapa.setCdMapa(omMapa.getCdMapa());
			mapa.setIdMapa(omMapa.getIdMapa());
			lista.add(mapa);
		}
		// Ordena a lista
		Collections.sort(lista, new Comparator<MapaCODTO>() {
			@Override
			public int compare(MapaCODTO o1, MapaCODTO o2) {
				return o1.getCdMapa().compareTo(o2.getCdMapa());
			}

		});

		// Se existe um mapa carregado então colocar como 1o. na lista
		if (ommapaCarregado != null) {
			MapaCODTO mapacodto = new MapaCODTO();
			mapacodto.setCdMapa(ommapaCarregado.getCdMapa());
			mapacodto.setIsAlimentacaoCorrenteExclusiva(true); // assim o APP poderá saber que esse eh o mapa carregado atualmente em
																// maquina.
			mapas.setMapas(new ArrayList<MapaCODTO>());
			mapas.getMapas().add(mapacodto);
			mapas.getMapas().addAll(lista);
		} else {
			mapas.setMapas(lista);
		}

		q = null;
		qUp = null;

		return mapas;
	}

	public MapaCODTO getMapaDTO(String cdpt, String cdmapa) {
		MapaCODTO mapa = new MapaCODTO();

		MapQuery q = new MapQuery(getSession());

		q.append("select t ");
		q.append("from OmMapa t ");
		q.append("join fetch t.omMapapas b");
		q.append("where t.stAtivo = 1 ");
		q.append("AND t.omPt.stAtivo = 1 ");
		q.append("AND t.omPt.cdPt = :maquina");
		q.append("and t.cdMapa = :cdmapa");

		q.defineParametro("maquina", cdpt);
		q.defineParametro("cdmapa", cdmapa);
		q.setMaxResults(1);

		OmMapa omMapa = (OmMapa) q.uniqueResult();

		if (omMapa != null) {

			mapa.setIdMapa(omMapa.getIdMapa());
			mapa.setCdMapa(omMapa.getCdMapa());

			// retorna os pontos de alimentacao do mapa
			mapa.setPas(new ArrayList<RealimentacaoDTO>());
			for (OmMapapa mapapa : omMapa.getOmMapapas()) {
				RealimentacaoDTO dto = new RealimentacaoDTO();
				dto.setCdPt(cdpt);
				dto.setCdMapa(cdmapa);
				dto.setCdPa(mapapa.getOmPa().getCdPa());
				dto.setCdProduto(mapapa.getOmProduto().getCdProduto());
				dto.setCdProdutoAlternativo(new ArrayList<String>());
				dto.setOrdem(mapapa.getOmPa().getOrdem());

				// atualiza a lista de produtos alternativos se houver
				for (OmMapapaproalt proalt : mapapa.getOmMapapaproalts()) {
					// System.out.println(dto.getCdPa() + " - obtendo alternativo do mapa " + proalt.getOmProduto().getCdProduto());
					dto.getCdProdutoAlternativo().add(proalt.getOmProduto().getCdProduto());
				}

				// Se a lista de alternativos estiver vazia, entao obter a lista global de alternativos
				if (mapapa.getOmMapapaproalts().isEmpty()) {
					// obtem a lista de alternativos para dto.cdProduto
					for (OmProaltglo alt : mapapa.getOmProduto().getOmProaltglosForIdProdutoMae()) {
						// System.out.println("do pa " + dto.getCdPa() + " vem alt da estrutura " +
						// alt.getOmProdutoByIdProdutoFilho().getCdProduto() + " stAtivo= " +
						// alt.getOmProdutoByIdProdutoFilho().getStAtivo());
						// if (alt.getOmProdutoByIdProdutoFilho().getStAtivo() == (byte) 1) {
						dto.getCdProdutoAlternativo().add(alt.getOmProdutoByIdProdutoFilho().getCdProduto());
						// }
					}
				}

				mapa.getPas().add(dto);
			}

		}

		q = null;

		return mapa;
	}

	public MapasDTO getMapaCorrenteDTO(String cdlinha) {
		MapasDTO retorno = new MapasDTO();

		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select a");
		q.append("from OmPt a");
		q.append("join a.omGt b");
		q.append("where a.stAtivo = 1");
		q.append("and b.cdGt = :cdgt");

		q.defineParametro("cdgt", cdlinha);
		List<OmPt> pts = q.list();

		MapQuery qAlim = new MapQuery(getDao().getSession());
		qAlim.append("select distinct a");
		qAlim.append("from OmAlim a");
		qAlim.append("join a.omMapa b");
		qAlim.append("join b.omPt c");
		qAlim.append("where c.cdPt = :cdpt");
		qAlim.append("and c.stAtivo = 1");
		qAlim.append("and a.tpAlim = 3"); // alimnetacao
		qAlim.append("and a.stAlim = 1"); // sucesso
		qAlim.append("order by a.idAlim desc");
		qAlim.setMaxResults(1);

		retorno.setCdgt(cdlinha);
		retorno.setMapas(new ArrayList<MapaDTO>());

		for (OmPt ompt : pts) {

			qAlim.defineParametro("cdpt", ompt.getCdPt());

			OmAlim omalim = (OmAlim) qAlim.uniqueResult();

			if (omalim != null) {
				MapaDTO mapa = new MapaDTO();
				mapa.setCdpt(ompt.getCdPt());
				mapa.setCdmapa(omalim.getOmMapa().getCdMapa());
				retorno.getMapas().add(mapa);
			}
		}

		return retorno;
	}

	/*
	 * O objetivo do metodo é retornar o mapa completo de todos os postos da linha recebida Assim o CF poderá fazer consulta nesses mapas
	 */
	public MapasCODTO getMapasGT(String cdgt) {
		MapasCODTO retorno = new MapasCODTO();

		// Obtem a ultima alimentacao, a fim de pegar o mapa
		OmAlim omalim;

		AlimentacaoRN arn = new AlimentacaoRN();
		arn.setDao(getDao());
		GTRN gtrn = new GTRN();
		gtrn.setDao(getDao());
		PTRN ptrn = new PTRN(getDao());

		List<MapaCODTO> listaMapas = new ArrayList<MapaCODTO>();
		
		// Encontra o GT
		OmGt omgt = gtrn.getOmGtByCdGt(cdgt);
		
		// Se nao existir o GT retornar excessao
		if (omgt == null) {
			return retorno;
		}

		// Obtem a lista de postos do GT recebido
		List<OmPt> listapts = ptrn.pesquisarPtByGt(omgt);
		
		// Se nao excontrar uma lista de pts retornar excessao
		if (listapts.isEmpty()) {
			return retorno;
		}

		// Interage sobre cada posto para obter o mapa completo
		for (OmPt ompt : listapts) {

			omalim = arn.pesquisarUltimasAlimentacoesSomenteOmAlim(ompt.getCdPt());

			// se nao tem ultima alimentacao passa para proximo posto
			if (omalim == null)
				continue;

			OmMapa ommapa = omalim.getOmMapa();

			MapaCODTO mapa = getMapaDTO(ompt.getCdPt(), ommapa.getCdMapa());
			
			listaMapas.add(mapa);

		}
		
		// prepara retorno dos mapas
		retorno.setMapas(new ArrayList<MapaCODTO>());
		retorno.getMapas().addAll(listaMapas);

		return retorno;
	}

}
