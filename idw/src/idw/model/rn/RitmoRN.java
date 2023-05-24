package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwRtcic;
import idw.model.pojos.DwTRitmo;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.DwTRitmoTemplate;
import idw.util.Util;
import idw.webservices.dto.CamposEmUsoOmCfgDTO;
import idw.webservices.dto.CicloDestacandoParadas;
import idw.webservices.dto.DetalheParadaDTO;
import idw.webservices.dto.DwTRitmoDTO;
import idw.webservices.dto.DwTRitmosDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.ResultadoDTO;
import idw.webservices.dto.TodosCiclosDestacandoParadasDTO;

public class RitmoRN extends AbstractRN<DAOGenerico> {

	public RitmoRN() {
		this(null);
	}

	public RitmoRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	@SuppressWarnings("unchecked")
	public DwTRitmosDTO getTRitmos(Long idTppt) {

		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t ");
		q.append("from DwTRitmo t ");
		q.append("where t.stAtivo=1 ");
		q.append("AND t.omTppt.idTppt=:idTppt ");
		q.defineParametro("idTppt", idTppt);

		List<DwTRitmo> listaPesquisa = null;
		try {
			listaPesquisa = q.query().list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<DwTRitmoDTO> lista = new ArrayList<DwTRitmoDTO>();

		if (listaPesquisa != null) {
			for (DwTRitmo item : listaPesquisa) {
				DwTRitmoDTO dwTRitmoDTO = new DwTRitmoDTO();
				dwTRitmoDTO.setDwTRitmo(item.clone());
				lista.add(dwTRitmoDTO);
			}
		}

		DwTRitmosDTO listaRetorno = new DwTRitmosDTO();
		listaRetorno.setListaRitmosDTO(lista);

		return listaRetorno;
	}

	/**
	 * Pega {@code DwTRitmo} relacionado com o id
	 * 
	 * @param idRitmo
	 * @return
	 */
	public DwTRitmo getDwTRitmo(long idRitmo) {
		return this.getDao().findById(DwTRitmo.class, idRitmo, false);
	}

	/**
	 * Pega {@code DwTRitmo} relacionado com o c�digo da Ritmo e que esteja
	 * ativo, relacionado com o {@code omTppt}
	 * 
	 * @param cdRitmo
	 * @param omTppt
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwTRitmo getDwTRitmo(String cdRitmo, OmTppt omTppt)
			throws RegistroDesconhecidoException {
		return this.getDwTRitmo(cdRitmo, omTppt, true);
	}

	/**
	 * Pega {@code DwTRitmo} �ltima revis�o com o c�digo da Ritmo
	 * 
	 * @param cdRitmo
	 * @param omTppt
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwTRitmo getDwTRitmo(String cdRitmo, OmTppt omTppt,
			boolean isFiltroAtivo) throws RegistroDesconhecidoException {
		return this.getDao().findByCd(DwTRitmo.class, cdRitmo,
				DwTRitmoTemplate._FIELD_NAME_CD, omTppt, isFiltroAtivo);
	}

	public DwTRitmo salvarDesativandoOriginal(DwTRitmo dwTRitmo,
			Date dateOperacao, OmUsr omUsrOperacao) {
		return this.getDao().salvarDesativandoOriginal(dwTRitmo, dateOperacao,
				omUsrOperacao);
	}

	/**
	 * Desativa {@code DwTRitmo} relacionado ao id do ritmo
	 * 
	 * @param idRitmo
	 * @param dataHoraAtual
	 * @throws RegistroJaDesativadoException
	 */
	public void desativarRitmo(long idRitmo, Date date, OmUsr omUsr)
			throws RegistroJaDesativadoException {
		this.getDao().desativar(DwTRitmo.class, idRitmo, date, omUsr);
	}

	public DwTRitmoDTO setTRitmo(DwTRitmoDTO itemDTO) {

		itemDTO.setResultado(new ResultadoDTO());
		if (itemDTO.getDwTRitmo() == null
				|| itemDTO.getDwTRitmo().getCdTritmo() == null
				|| itemDTO.getDwTRitmo().getCdTritmo().equals("")) {
			itemDTO.getResultado().setIdmensagem(
					itemDTO.getResultado().CODIGO_DESCONHECIDO);
			return itemDTO;
		}

		OmTppt omTppt = new OmTppt();
		DwTRitmo itemOriginal = new DwTRitmo();
		itemOriginal = itemDTO.getDwTRitmo().clone();
		
		
		//20160926FVA:
		if (itemOriginal != null && itemOriginal.getIdTritmo() > 0 && itemOriginal.getStAtivo().equals((byte)0)){
			ResultadoDTO resultadodto = new ResultadoDTO();
			resultadodto.setIdmensagem(resultadodto.getERRO_REATIVACAO_INDISPONIVEL());
			itemDTO.setResultado(resultadodto);
			return itemDTO;
		}

		

		TpptRN tpptRN = new TpptRN(this.getDao());
		omTppt = tpptRN.getOmTpptDTO(itemDTO.getDwTRitmo().getOmTppt());
		itemOriginal.setOmTppt(omTppt);

		// Pesquisar o registro
		DwTRitmo pojo = null;
		if (itemOriginal.getIdTritmo() > 0) {
			pojo = getDwTRitmo(itemOriginal.getIdTritmo());
		}
		if (pojo != null && pojo.getStAtivo().equals((byte) 0)) {
			itemDTO.getResultado().setIdmensagem(
					itemDTO.getResultado().ERRO_EXCLUI_STATIVO_ZERO);
			return itemDTO;
		}
		if (pojo == null) {
			try {
				pojo = getDwTRitmo(itemOriginal.getCdTritmo(), omTppt);
				if (pojo != null) {
					itemDTO.getResultado().setIdmensagem(
							itemDTO.getResultado().REGISTRO_JA_EXISTE);
					return itemDTO;
				}
			} catch (RegistroDesconhecidoException e) {
				pojo = null;
			}
		}

		itemDTO.setDwTRitmo(salvarDesativandoOriginal(itemOriginal, new Date(),
				itemDTO.getDwTRitmo().getOmUsrByIdUsrrevisao()).clone());
		return itemDTO;
	}

	@SuppressWarnings("unchecked")
	public DwTRitmosDTO getTRitmo(DwTRitmoDTO filtro) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select r ");
		q.append("from DwTRitmo r ");
		q.append("where 1=1 ");

		if (filtro.getDwTRitmo().getIdTritmo() != 0) {
			q.append("AND r.idTritmo=:idTritmo ");
		} else {
			if (filtro.getDwTRitmo().getCdTritmo() != null
					&& !filtro.getDwTRitmo().getCdTritmo().equals("")) {
				q.append("AND r.cdTritmo=:cdTritmo ");
			}
			if (filtro.getDwTRitmo().getDsTritmo() != null
					&& !filtro.getDwTRitmo().getDsTritmo().equals("")) {
				q.append("AND r.dsTritmo=:dsTritmo ");
			}
			if (filtro.getDwTRitmo().getOmTppt() != null
					&& !filtro.getDwTRitmo().getOmTppt().getCdTppt().equals("")) {
				q.append("AND r.omTppt.cdTppt=:cdTppt ");
			}
			if (filtro.getDwTRitmo().getOmTppt() != null
					&& !filtro.getDwTRitmo().getOmTppt().getDsTppt().equals("")) {
				q.append("AND r.omTppt.dsTppt=:dsTppt ");
			}
			if ((filtro.getDwTRitmo().getOmUsrByIdUsrstativo() != null)
					&& (filtro.getDwTRitmo().getOmUsrByIdUsrstativo()
							.getCdUsr() != null)
					&& (!filtro.getDwTRitmo().getOmUsrByIdUsrstativo()
							.getCdUsr().equals(""))) {
				q.append("AND r.omUsrByIdUsrstativo.cdUsr=:cdUsrSt ");
			}
			if ((filtro.getDwTRitmo().getOmUsrByIdUsrstativo() != null)
					&& (filtro.getDwTRitmo().getOmUsrByIdUsrstativo()
							.getDsNome() != null)
					&& (!filtro.getDwTRitmo().getOmUsrByIdUsrstativo()
							.getDsNome().equals(""))) {
				q.append("AND r.omUsrByIdUsrstativo.dsNome=:dsNomeSt ");
			}
			if ((filtro.getDwTRitmo().getOmUsrByIdUsrrevisao() != null)
					&& (filtro.getDwTRitmo().getOmUsrByIdUsrrevisao()
							.getCdUsr() != null)
					&& (!filtro.getDwTRitmo().getOmUsrByIdUsrrevisao()
							.getCdUsr().equals(""))) {
				q.append("AND r.omUsrByIdUsrrevisao.cdUsr=:cdUsrRev ");
			}
			if ((filtro.getDwTRitmo().getOmUsrByIdUsrrevisao() != null)
					&& (filtro.getDwTRitmo().getOmUsrByIdUsrrevisao()
							.getDsNome() != null)
					&& (!filtro.getDwTRitmo().getOmUsrByIdUsrrevisao()
							.getDsNome().equals(""))) {
				q.append("AND r.omUsrByIdUsrrevisao.dsNome=:dsNomeRev ");
			}
			if (filtro.getDwTRitmo().getDtRevisao() != null) {
				q.append("AND r.dtRevisao >= :dtRevisao AND r.dtRevisao <= :dtRevisaoF ");
			}
			if (filtro.getDwTRitmo().getDtStativo() != null) {
				q.append("AND r.dtStativo >= :dtStativo AND r.dtStativo <= :dtStativoF ");
			}
			if (filtro.getDwTRitmo().getRevisao() != null) {
				q.append("AND r.revisao=:revisao ");
			}
			if (filtro.getDwTRitmo().getStAtivo() != null
					&& filtro.getDwTRitmo().getStAtivo() < (byte) 2) {
				q.append("AND r.stAtivo=:stAtivo ");
			}
		}

		q.defineParametro("idTritmo", filtro.getDwTRitmo().getIdTritmo());
		q.defineParametro("cdTritmo", filtro.getDwTRitmo().getCdTritmo());
		q.defineParametro("dsTritmo", filtro.getDwTRitmo().getDsTritmo());

		if (filtro.getDwTRitmo().getOmTppt() != null) {
			q.defineParametro("cdTppt", filtro.getDwTRitmo().getOmTppt()
					.getCdTppt());
			q.defineParametro("dsTppt", filtro.getDwTRitmo().getOmTppt()
					.getDsTppt());
		}

		if (filtro.getDwTRitmo().getDtRevisao() != null) {
			q.defineParametro("dtRevisao", filtro.getDwTRitmo().getDtRevisao());
			q.defineParametro("dtRevisaoF", DataHoraRN.getDataHora235959(filtro
					.getDwTRitmo().getDtRevisao()));
		}

		if (filtro.getDwTRitmo().getDtStativo() != null) {
			q.defineParametro("dtStativo", filtro.getDwTRitmo().getDtStativo());
			q.defineParametro("dtStativoF", DataHoraRN.getDataHora235959(filtro
					.getDwTRitmo().getDtStativo()));
		}

		q.defineParametro("revisao", filtro.getDwTRitmo().getRevisao());
		q.defineParametro("stAtivo", filtro.getDwTRitmo().getStAtivo());

		if (filtro.getDwTRitmo().getOmUsrByIdUsrrevisao() != null) {
			q.defineParametro("cdUsrRev", filtro.getDwTRitmo()
					.getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getDwTRitmo()
					.getOmUsrByIdUsrrevisao().getDsNome());
		}

		if (filtro.getDwTRitmo().getOmUsrByIdUsrstativo() != null) {
			q.defineParametro("cdUsrSt", filtro.getDwTRitmo()
					.getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getDwTRitmo()
					.getOmUsrByIdUsrstativo().getDsNome());
		}

		List<DwTRitmo> listaPesquisa = null;
		try {
			listaPesquisa = q.query().list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<DwTRitmoDTO> lista = new ArrayList<DwTRitmoDTO>();

		if (listaPesquisa != null) {
			for (DwTRitmo item : listaPesquisa) {
				DwTRitmoDTO dwTRitmoDTO = new DwTRitmoDTO();
				dwTRitmoDTO.setDwTRitmo(item.clone());
				lista.add(dwTRitmoDTO);
			}
		}

		DwTRitmosDTO listaRetorno = new DwTRitmosDTO();
		listaRetorno.setListaRitmosDTO(lista);

		return listaRetorno;
	}

	public DwTRitmosDTO removeTRitmo(DwTRitmosDTO itens) {
		List<DwTRitmoDTO> listaRetorno = new ArrayList<DwTRitmoDTO>();
		DwTRitmosDTO itensRetorno = new DwTRitmosDTO();

		
		//17/03/2017 Alex: nao remover codigo em uso na configuracao geral.
		CamposEmUsoOmCfgDTO camposEmUsoOmCfgDTO = getCamposEmUsoOmCfg(itens);
		itensRetorno.setCamposEmUsoOmCfg(camposEmUsoOmCfgDTO);
		if(camposEmUsoOmCfgDTO.getStatus() != camposEmUsoOmCfgDTO.getSTATUS_NENHUM_CAMPO_EM_USO()) {
			//se entrar nesse if eh pq existe algum codigo em uso
			return itensRetorno;
		}
		
		
		for (DwTRitmoDTO item : itens.getListaRitmosDTO()) {
			OmUsr omUser = new OmUsr();
			UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
						
			try {
				omUser = usuarioRN.getOmUsr(item.getDwTRitmo()
						.getOmUsrByIdUsrrevisao().getCdUsr());
			} catch (RegistroDesconhecidoException e) {
				e.printStackTrace();
			}
			try {
				desativarRitmo(item.getDwTRitmo().getIdTritmo(), new Date(),
						omUser);
				item.getDwTRitmo().setStAtivo((byte) 0);
			} catch (RegistroJaDesativadoException e) {
				e.printStackTrace();
			}			
			
			listaRetorno.add(item);
		}
		
		itensRetorno.setListaRitmosDTO(listaRetorno);
		return itensRetorno;
	}
	
	private CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg(DwTRitmosDTO itens) {
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		
		//campos
		DwTRitmo ritmoEmUso = omcfg.getDwTRitmo();
		
		CamposEmUsoOmCfgDTO camposEmUsoOmCfg = new CamposEmUsoOmCfgDTO();
		boolean isTemCodigoEmUso = false;
		for(DwTRitmoDTO item: itens.getListaRitmosDTO()) {
			camposEmUsoOmCfg.setCodigo(item.getDwTRitmo().getCdTritmo());
			
			if(ritmoEmUso != null) {
				if(item.getDwTRitmo().getCdTritmo().equals(ritmoEmUso.getCdTritmo())) {
					camposEmUsoOmCfg.setMotivoPadraoParaVariacaoRitmo(true);
					isTemCodigoEmUso = true;
				}
			}
			
		}
		
		if(isTemCodigoEmUso) {
			
			if(itens.getListaRitmosDTO() != null && itens.getListaRitmosDTO().size() > 1) {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_EXCLUSAO_ABORTADA());
			} else {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_TEM_CAMPO_EM_USO());
			}
			
		} else {
			camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_NENHUM_CAMPO_EM_USO());
		}
		
		return camposEmUsoOmCfg;
	}
	
	public DwTRitmo getDwTRitmoPorCdAtivoOrderById(String cdCfgabc){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("SELECT ritmo FROM DwTRitmo ritmo");
		q.append("WHERE ritmo.stAtivo = :stAtivo");
		q.append("AND ritmo.cdTritmo = :cdTritmo");
		q.append("ORDER BY ritmo.idTritmo");
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cdTritmo", cdCfgabc);
		q.setMaxResults(1);
		return (DwTRitmo) q.uniqueResult();
	}
	
	
	
	
	/* Metodo que retorna todos os ciclos de determinado periodo e PT
	 * 
	 */
	public TodosCiclosDestacandoParadasDTO getTodosCiclosDestacandoParadas(FiltroDetalhePTInjetDTO filtro) {
		TodosCiclosDestacandoParadasDTO retorno = new TodosCiclosDestacandoParadasDTO();
		
		FolhaRN frn = new FolhaRN(getDao());
		Date dtReferencia = filtro.getDtReferencia();
		
		// Descobrir o inicio e fim do turno
		MapQuery q0 = new MapQuery(getDaoSession());
		q0.append("select dwconsolid");
		q0.append("from DwConsolid dwconsolid");
		q0.append("join dwconsolid.omPt ompt");
		q0.append("where dwconsolid.dtReferencia = :dt");
		q0.append("and ompt.cdPt = :cdpt");
		q0.append("and dwconsolid.tpId = 1");
		q0.append("and dwconsolid.dwTurno.idTurno = :id");
		
		q0.setMaxResults(1);
		q0.defineParametroData("dt", dtReferencia);
		q0.defineParametro("cdpt", filtro.getOmPt().getCdPt());
		q0.defineParametro("id", filtro.getDwTurno().getIdTurno());
		
		DwConsolid dwconsolid = (DwConsolid) q0.uniqueResult();
		
		MapQuery q = new MapQuery(getDaoSession());

		q.append("select a");
		q.append("from DwRtcic a");
		q.append("join a.dwRt b");
		q.append("join b.omPt c");
		q.append("where");
		q.append("c.cdPt = :cdpt");
		q.append("and b.dtReferencia = :dtreferencia");
		q.append("and b.dwTurno.idTurno = :idturno");
//		q.append("and (a.dthrIciclo between :dti and :dtf");
//		q.append("or a.dthrFciclo between :dti and :dtf )");
		q.append("order by a.dthrIciclo");
		
		//q.defineParametroTimestamp("dti", dwconsolid.getDthrIturno());
		//q.defineParametroTimestamp("dtf", dwconsolid.getDthrFturno());
		q.defineParametro("cdpt", filtro.getOmPt().getCdPt());
		q.defineParametroData("dtreferencia", dwconsolid.getDtReferencia());
		q.defineParametro("idturno", dwconsolid.getDwTurno().getIdTurno());
		
		List<DwRtcic> lista = q.list();
		
		BigDecimal somaTempoativo = BigDecimal.ZERO;
		BigDecimal somaCicloImpro = BigDecimal.ZERO;
		BigDecimal somaTempoparada = BigDecimal.ZERO;
		double somaDiff = 0d;
		
		// Pesquisa para obter as paradas que ocorreram durante o ciclo, mas filtrando o inicio e fim da parada ao turno
		MapQuery q9 = new MapQuery(getDaoSession());
		q9.append("select distinct a");
		q9.append("from DwConsolpaoco a");
		q9.append("join a.dwConsolpa b");
		q9.append("join b.dwConsol c");
		q9.append("join c.dwConsolid d");
		q9.append("where");
		q9.append("d.tpId = 1");
		q9.append("and d.dtReferencia = :dtreferencia");
		q9.append("and d.dwTurno.idTurno = :idturno");
		q9.append("and d.omPt.idPt = :idpt");
		q9.append("and ( (a.dthrIparada >= :inicio and a.dthrIparada <= :fim) or (a.dthrFparada >= :inicio and a.dthrFparada <= :fim) )");
		q9.append("and a.dthrFparada is not null");
		
		q9.defineParametroData("dtreferencia", dwconsolid.getDtReferencia());
		q9.defineParametro("idturno", dwconsolid.getDwTurno().getIdTurno());
		q9.defineParametro("idpt", dwconsolid.getOmPt().getIdPt());
		
		int qtCiclosProdu = 0;
		
		Date dthrIMenorCiclo = null;
		Date dthrFMaiorCiclo = null;
		
		List<DwRtcic> listaTodosCicloAvalisados = new ArrayList<>();

		for (DwRtcic dwrtcic : lista) {
			CicloDestacandoParadas dto = new CicloDestacandoParadas();
			dto.setIsCicloComConflito(false);
			
			// Verificar seo ciclo avaliado tem conflito com algum ciclo ja processado
			for (DwRtcic japroc : listaTodosCicloAvalisados) {
				if (DataHoraRN.isIntersecao(dwrtcic.getDthrIciclo(), dwrtcic.getDthrFciclo(), japroc.getDthrIciclo(), japroc.getDthrFciclo()))
					dto.setIsCicloComConflito(true);
			}
			DwRtcic clone = dwrtcic.clone(false);
			clone.setDthrIciclo(DataHoraRN.adicionaMilisegundosNaData(clone.getDthrIciclo(), 1));
			clone.setDthrFciclo(DataHoraRN.subtraiSegundosDaData(clone.getDthrFciclo(), 1));
			listaTodosCicloAvalisados.add(clone);
			
			if (dthrIMenorCiclo == null || DataHoraRN.after(dthrIMenorCiclo, dwrtcic.getDthrIciclo()))
				dthrIMenorCiclo = dwrtcic.getDthrIciclo();
			if (dthrFMaiorCiclo == null || DataHoraRN.before(dthrFMaiorCiclo, dwrtcic.getDthrFciclo()))
				dthrFMaiorCiclo = dwrtcic.getDthrFciclo();

			// Procurar as paradas para o ciclo avaliado
			
			BigDecimal tciclo = BigDecimal.ZERO;
			Date dthriciclo = dwrtcic.getDthrIciclo();
			Date dthrfciclo = dwrtcic.getDthrFciclo();

			boolean isCicloFora = false;
			qtCiclosProdu++;
			
			//Alex 01/09/2017 #4533
//			if (DataHoraRN.before(dthriciclo, dwconsolid.getDthrIturno())) {
//				dthriciclo = dwconsolid.getDthrIturno();
//				isCicloFora = true;
//			} else {
//				qtCiclosProdu++;
//			}			
//			if (DataHoraRN.after(dthrfciclo, dwconsolid.getDthrFturno()) && dwconsolid.getDwTurno().getIdTurno() != 1l)
//				dthrfciclo = dwconsolid.getDthrFturno();
			
			tciclo = new BigDecimal(DataHoraRN.getQuantidadeMilisegundosNoPeriodo(dthriciclo, dthrfciclo));
			tciclo = tciclo.divide(new BigDecimal(1000));
			
			if (isCicloFora)
				somaCicloImpro = somaCicloImpro.add(tciclo);

			dto.setIsCicloForaturno(isCicloFora);
			
			somaTempoativo = somaTempoativo.add(tciclo);
			
			q9.defineParametroTimestamp("inicio", dthriciclo);
			q9.defineParametroTimestamp("fim", dthrfciclo);

			dto.setCdFolha(dwrtcic.getDwFolha().getCdFolha());
			dto.setDthrIciclo(dthriciclo);
			dto.setDthrFciclo(dthrfciclo);
			dto.setSegDuracao(tciclo.doubleValue());

			List<DwConsolpaoco> paradas  = q9.list();
			BigDecimal tparada = BigDecimal.ZERO;
			java.util.Collections.sort(paradas, new Comparator<DwConsolpaoco>() {
				@Override
				public int compare(DwConsolpaoco o1, DwConsolpaoco o2) {
					return DataHoraRN.compareTo(o1.getDthrIparada(), o2.getDthrIparada());
				}
			});
			for (DwConsolpaoco parada : paradas) {
				Date dthrFParada = parada.getDthrFparada();
				if (dthrFParada == null)
					dthrFParada = DataHoraRN.getDataHoraAtual();
				double duracao = DataHoraRN.getQuantidadeSegundosNaIntersecao(dthriciclo, dthrfciclo, parada.getDthrIparada(), dthrFParada);
				if (duracao != 0d) {
					DetalheParadaDTO paradaDTO = new DetalheParadaDTO();
					paradaDTO.setInicio(parada.getDthrIparada());
					paradaDTO.setFim(parada.getDthrFparada());
					paradaDTO.setDuracao(DataHoraRN.getSegundosParaHoraFormata((int)duracao));
					paradaDTO.setDuracaoEmSegundos( duracao );

					paradaDTO.setDwConsolpaoco(parada.clone(false));
					dto.getParadas().add(paradaDTO);
				}				
				tparada = tparada.add(new BigDecimal(duracao));
			}
			dto.setSegTempoparada(tparada.doubleValue());
			Double ciclopadrao = 0d;
			try {
				dto.setSegCicloPadrao(frn.getCicloPadrao(dwrtcic.getDwFolha(), filtro.getOmPt()).doubleValue());
			} catch (SemCicloPadraoException e) {
				ciclopadrao = 0d;
			}
			
			double diff =  tciclo.doubleValue() - tparada.doubleValue() - ciclopadrao;
			
			if ( isCicloFora )
				diff = 0d;
			
			dto.setSegDuracaoSemParada(dto.getSegDuracao() - dto.getSegTempoparada());
			
			somaDiff += diff;

			somaTempoparada = somaTempoparada.add(tparada);

			dto.setSegTempoAtivoParcial( (somaTempoativo.subtract(somaTempoparada)).doubleValue() );

			retorno.getCiclos().add(dto);
		}
		retorno.setSegCicloProdutivos(somaDiff);
		retorno.setQtCiclosProdutivos(qtCiclosProdu);
		return retorno;
	}
}
