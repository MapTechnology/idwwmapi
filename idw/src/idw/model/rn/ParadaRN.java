package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwTParadaDAO;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwTAlerta;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.DwTParada; 
import idw.model.pojos.MsPtColeta;
import idw.model.pojos.MsUp;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.DwTParadaTemplate;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.CamposEmUsoOmCfgDTO;
import idw.webservices.dto.DWParadaDTO;
import idw.webservices.dto.DetalhamentoParadaDTO;
import idw.webservices.dto.DetalheParadaDTO;
import idw.webservices.dto.FiltroParadasDTO;
import idw.webservices.dto.FiltroRelatorioParadaDTO;
import idw.webservices.dto.ParadasDTO;
import idw.webservices.dto.ResultadoDTO;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.ListaParadasDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;
import idw.webservices.rest.idw.v2.dto.ParadaCadDTO; 
import idw.webservices.rest.idw.v2.dto.TimeOutAlertaParCadDTO;
import idw.webservices.rest.idw.v2.dto.TimeOutParadaParCadDTO;

public class ParadaRN extends AbstractRN<DAOGenerico> {

	public static String CD_PARADA_DEFAULT = "0";

	public ParadaRN() {
		this(null);
	}

	public ParadaRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	/* Esse metodo é usado apenas para pesquisar se o motivo de parada existe quando
	 * o coletor for inova pelo C#. Assim, existe um teste de encontrar ou nao o motivo da parada
	 * caso a op atual do posto seja critia. Ou seka, se a OP for critica os motivos sem peso não serão
	 * encontrador
	 */
	public DwTParada getDwTParadaByMsUpCdParada(BigDecimal idUp, String cdParada){
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("select msup");
		q.append("from MsUp msup");
		q.append("where msup.idUp = :idup");
		q.defineParametro("idup", idUp);
		
		MsUp msup = (MsUp) q.uniqueResult();
		if (msup == null)
			return null;
		
		PTRN prn = new PTRN(getDao());
		OmPt ompt;
		try {
			ompt = prn.getOmPt(msup.getCdUp());
		} catch (RegistroDesconhecidoException e) {
			return null;
		}
		
		q.novaConsulta();
		q.append("SELECT dwTParada FROM DwTParada dwTParada");
		q.append("join dwTParada.omTppt omtppt");
		q.append("join omtppt.omPts ompt");
		q.append("WHERE dwTParada.stAtivo = :stAtivo");
		q.append("AND dwTParada.cdTparada = :cdParada");
		q.append("and ompt.cdPt = :cdpt");
		q.append("and ompt.stAtivo = 1");
		
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("cdParada", cdParada);
		q.defineParametro("cdpt", msup.getCdUp());
		q.setMaxResults(1);
		DwTParada dwTParada = (DwTParada) q.uniqueResult();
		
		// Se a op for critica e a parada sem peso, entao nao retornar a perada
		if (ompt.getPpCp() != null && ompt.getPpCp().getIsFinalserie() != null && ompt.getPpCp().getIsFinalserie() && dwTParada != null && dwTParada.getIsPesa() == false)
			return null;
		
		
		return dwTParada;
	}
	public DwTParada getDwTParadaByMsUpCdParada(String cdUp, String cdParada){
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("select msup");
		q.append("from MsUp msup");
		q.append("where msup.cdUp = :cdup");
		q.append("and msup.stAtivo = 1");
		q.defineParametro("cdup", cdUp);
		
		MsUp msup = (MsUp) q.uniqueResult();
		if (msup == null)
			return null;
		
		q.novaConsulta();
		q.append("SELECT dwTParada FROM DwTParada dwTParada");
		q.append("join dwTParada.omTppt omtppt");
		q.append("join omtppt.omPts ompt");
		q.append("WHERE dwTParada.stAtivo = :stAtivo");
		q.append("AND dwTParada.cdTparada = :cdParada");
		q.append("and ompt.cdPt = :cdpt");
		q.append("and ompt.stAtivo = 1");
		
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("cdParada", cdParada);
		q.defineParametro("cdpt", msup.getCdUp());
		q.setMaxResults(1);
		DwTParada dwTParada = (DwTParada) q.uniqueResult();		
		return dwTParada;
	}

	/**
	 * Pega a parada marcada como sem conex�o. Deve ter apenas 1 parada deste tipo
	 * @return
	 */
	public DwTParada getDwTParadaSemConexao(){
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("SELECT dwTParada FROM DwTParada dwTParada");
		q.append("WHERE dwTParada.stAtivo = :stAtivo");
		q.append("AND dwTParada.isSemConexao = :isSEmConexao");
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("isSEmConexao", true);		
		q.setMaxResults(1);
		DwTParada dwTParada = (DwTParada) q.uniqueResult();		
		return dwTParada;
	}
	
	/**
	 * Pega a parada marcada como sem evento. Deve ter apenas 1 parada deste tipo
	 * @return
	 */
	public DwTParada getDwTParadaSemEvento(){
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("SELECT dwTParada FROM DwTParada dwTParada");
		q.append("WHERE dwTParada.stAtivo = :stAtivo");
		q.append("AND dwTParada.isSemEvento = :isSemEvento");
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("isSemEvento", true);
		q.setMaxResults(1);
		DwTParada dwTParada = (DwTParada) q.uniqueResult();		
		return dwTParada;
	}

	/**
	 * Desativa todos os registros da tabela de paradas
	 *
	 * @param dataHoraDesativacao
	 * @param omUsr
	 *            Usuário que desativou a parada
	 */
	public void desativarParadas(Date dataHoraDesativacao, OmUsr omUsr) {
		this.getDao().desativarMuitos(DwTParada.class,
				DwTParadaTemplate._FIELD_NAME_CD, null, false,
				dataHoraDesativacao, omUsr);
	}

	/**
	 * Desativa registros da tabela de paradas
	 *
	 * @param listaCdParadaDevemFicarAtivos
	 *            Lista de códigos de devem ficar permanecer ativos
	 * @param dataHoraDesativacao
	 * @param omUsr
	 *            Usuário que desativou a parada
	 */
	public void desativarParadas(List<String> listaCdParadaDevemFicarAtivos,
			Date dataHoraDesativacao, OmUsr omUsr) {
		this.getDao()
				.desativarMuitos(DwTParada.class,
						DwTParadaTemplate._FIELD_NAME_CD,
						listaCdParadaDevemFicarAtivos, true,
						dataHoraDesativacao, omUsr);
	}

	/**
	 * Desativa relacionado ao código e tipo do posto de trabalho
	 *
	 * @param cdParada
	 * @param omTppt
	 * @param date
	 * @param omUsr
	 *            usuário que está desativando
	 * @throws RegistroJaDesativadoException
	 * @throws RegistroDesconhecidoException
	 */
	public void desativarParada(String cdParada, OmTppt omTppt, Date date,
			OmUsr omUsr) throws RegistroDesconhecidoException,
			RegistroJaDesativadoException {
		this.getDao().desativar(DwTParada.class, cdParada,
				DwTParadaTemplate._FIELD_NAME_CD, omTppt, date, omUsr);
	}

	/**
	 * Desativa {@code DwTParada} relacionado ao id da parada
	 *
	 * @param idParada
	 * @param date
	 * @throws RegistroJaDesativadoException
	 */
	public void desativarParada(long idParada, Date date, OmUsr omUsr)
			throws RegistroJaDesativadoException {
		this.getDao().desativar(DwTParada.class, idParada, date, omUsr);
	}

	/**
	 * Pega {@code DwTParada} relacionado com o código da parada e que esteja
	 * ativo, relacionado com o {@code omTppt}
	 *
	 * @param cdParada
	 * @param omTppt
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwTParada getDwTParada(String cdParada, OmTppt omTppt) throws RegistroDesconhecidoException {
		return this.getDwTParada(cdParada, omTppt, true);
	}

	/**
	 * Pega {@code DwTParada} última revis�o relacionado com o código da parada
	 * e relacionado com o {@code omTppt}
	 *
	 * @param cdParada
	 * @param omTppt
	 * @param isFiltroAtivo
	 *            se true, pega apenas o ativo
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwTParada getDwTParada(String cdParada, OmTppt omTppt, boolean isFiltroAtivo) throws RegistroDesconhecidoException {
		return this.getDao().findByCd(DwTParada.class, cdParada, DwTParadaTemplate._FIELD_NAME_CD, omTppt, isFiltroAtivo);
	}

	/**
	 * Pega {@code DwTParada} relacionado com o id
	 *
	 * @param idParada
	 * @return
	 */
	public DwTParada getDwTParada(long idParada) {
		return this.getDao().findById(DwTParada.class, idParada, false);
	}

	public void salvarDesativandoOriginal(DwTParada dwTParadaDB, DwTParada dwTParada, Date dateOperacao, OmUsr omUsrOperacao) {
		this.getDao().salvarDesativandoOriginal(dwTParadaDB, dwTParada, dateOperacao, omUsrOperacao);
	}

	public DwTParada salvarDesativandoOriginal(DwTParada dwTParada, Date dateOperacao, OmUsr omUsrOperacao) {
		return this.getDao().salvarDesativandoOriginal(dwTParada, dateOperacao, omUsrOperacao);
	}

	/**
	 * Grava parada, se já encontrar parada com mesmo código e tipo de posto, muda a sua descri��oo e código
	 * @param cdParada
	 * @param dsParada
	 * @param omTppt
	 * @param dwTArea
	 * @param dateOperacao
	 * @param omUsrOperacao se n�o for passado assume o código de usuario padr�o
	 */
	public DwTParada salvarDesativandoOriginal(String cdParada, String dsParada, OmTppt omTppt, DwTArea dwTArea, Date dateOperacao, OmUsr omUsrOperacao) {
		DwTParada dwTParada;

		// Verifica se já tem parada cadastrada, se encontrar, atualiza os dados da sua referencia
		try {
			dwTParada = getDwTParada(cdParada, omTppt);
		} catch (RegistroDesconhecidoException e) {
			dwTParada = new DwTParada();
			dwTParada.setDefaultValues();
		}

		dwTParada.setCdTparada(cdParada);
		dwTParada.setDsTparada(dsParada);
		dwTParada.setOmTppt(omTppt);
		dwTParada.limitarStrings();

		if(omUsrOperacao == null){
			UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
			// Pega usuário padr�o do sistema. usuário map
			omUsrOperacao = usuarioRN.getOmUsr(1);
		}

		if(dateOperacao == null){
			dateOperacao = DataHoraRN.getDataHoraSgbd(this.getDaoSession());
		}

		if(dwTArea == null){

			AreaRN area = new AreaRN(this.getDao());
			// Pega o código de área padr�o
			// Se n�o encontrar assume null mesmo
			try {
				dwTArea = area.getDwTArea(AreaRN.CD_AREA_DEFAULT, true);
			} catch (RegistroDesconhecidoException e) {
			}
		}
		dwTParada.setDwTArea(dwTArea);

		return this.getDao().salvarDesativandoOriginal(dwTParada, dateOperacao, omUsrOperacao);
	}

	public ParadasDTO getListaParadasAtivas(OmTppt tppt){
		
		DwTParadaDAO paradaDAO = new DwTParadaDAO(getDao().getSession());
		List<DwTParada> listaDwTparada;
		
		if(tppt.getIdTppt() != 0) {
			listaDwTparada = paradaDAO.getDwTParadasAtivasPorTppt(tppt.getIdTppt());
		} else {
			listaDwTparada = paradaDAO.getDwTParadasAtivas();
		}
		
		List<DWParadaDTO> listaDwtparadaRetorno = new ArrayList<DWParadaDTO>();
		for (DwTParada dwtparada : listaDwTparada) {
			DWParadaDTO paradaDTO = new DWParadaDTO();
			paradaDTO.setDwTParada(dwtparada.clone(true));
			if (dwtparada.getDwTArea() != null) {
				paradaDTO.getDwTParada().setDwTArea(
				dwtparada.getDwTArea().clone(false));
			}
			listaDwtparadaRetorno.add(paradaDTO);
		}
		ParadasDTO paradasDto = new ParadasDTO();
		paradasDto.setDwTParadas(listaDwtparadaRetorno);
		return paradasDto;
	}

	public ParadasDTO getParadasDTO(FiltroRelatorioParadaDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "ParadaRN.getParadasDTO");
		log.info( idLog , 0, "ParadaRN.getParadasDTO filtro usado:" + filtro.toString());

		List<DwTParada> listaDwtparada;

		List<DWParadaDTO> listaDwtparadaRetorno = new ArrayList<DWParadaDTO>();
		MapQuery query = new MapQuery(getDao().getSession());
		query.append("SELECT dwtparada ");
		query.append("FROM DwTParada dwtparada");
		query.append("left join dwtparada.omTppt omtppt");
		query.append("left join dwtparada.dwTArea dwtarea");
		if (filtro.getOmTppt() != null) {
			query.append("WHERE omtppt.idTppt = :idTppt");
		} else {
			query.append("");
		} 
		if (filtro.getOmTppt() != null && filtro.getSituacao() != null  && filtro.getSituacao() <(byte)2){
			query.append("AND dwtparada.stAtivo=:stAtivo");
		}else if(filtro.getSituacao() != null  && filtro.getSituacao() <(byte)2){
		 query.append("WHERE dwtparada.stAtivo=:stAtivo");
		}
		if (filtro.isOrdenar() == true) {//
			query.append("ORDER BY dwtparada.cdTparada");
		} else {
			if (filtro.isOrdenar() == false) {
				query.append("ORDER BY dwtarea.cdArea, dwtarea.dsArea , dwtparada.cdTparada");
			}
		}
		if (filtro.getOmTppt() != null) {
			query.defineParametro("idTppt", filtro.getOmTppt().getIdTppt());
		}
		if (filtro.getSituacao() != null){
			 query.defineParametro("stAtivo", filtro.getSituacao());
		}
		listaDwtparada = query.list();

		if (listaDwtparada != null) {
			for (DwTParada dwtparada : listaDwtparada) {

				DWParadaDTO paradaDTO = new DWParadaDTO();
				paradaDTO.setDwTParada(dwtparada.clone(true));
//				paradaDTO.getDwTParada().setDwTArea(
//						dwtparada.getDwTArea().clone(false));
				listaDwtparadaRetorno.add(paradaDTO);
			}
		}
		ParadasDTO paradasDto = new ParadasDTO();
		paradasDto.setDwTParadas(listaDwtparadaRetorno);
		
		log.mostrarAvaliacaoCompleta();
		
		return paradasDto;
		
	}

	@SuppressWarnings("unchecked")
	public ParadasDTO getTParadasDTO(DWParadaDTO filtro) {
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("SELECT t");
		q.append("FROM DwTParada t");
		q.append("WHERE 1 = 1");
		if(filtro.getDwTParada().getIdTparada() != null && filtro.getDwTParada().getIdTparada() != 0) {
			q.append("AND t.idTparada = :idTparada");
		}else{
			if(filtro.getDwTParada().getCdTparada() != null && !filtro.getDwTParada().getCdTparada().equals("")) {
				q.append("AND t.cdTparada = :cdTparada");
			}
			if(filtro.getDwTParada().getDsTparada() != null && !filtro.getDwTParada().getDsTparada().equals("")) {
				q.append("AND t.dsTparada = :dsTparada");
			}
			if (filtro.getDwTParada().getOmTppt() != null && !filtro.getDwTParada().getOmTppt().getCdTppt().equals("")) {
				q.append("AND t.omTppt.cdTppt = :cdTppt");
			}
			if (filtro.getDwTParada().getOmTppt() != null && !filtro.getDwTParada().getOmTppt().getDsTppt().equals("")) {
				q.append("AND t.omTppt.dsTppt = :dsTppt");
			}
			if(filtro.getDwTParada().getDwTArea() != null && !filtro.getDwTParada().getDwTArea().getCdArea().equals("")) {
				q.append("AND t.dwTArea.cdArea = :cdArea");
			}
			if(filtro.getDwTParada().getDwTArea() != null && !filtro.getDwTParada().getDwTArea().getDsArea().equals("")) {
				q.append("AND t.dwTArea.dsArea = :dsArea");
			}
			if((filtro.getDwTParada().getOmUsrByIdUsrstativo() != null)
					&& (filtro.getDwTParada().getOmUsrByIdUsrstativo().getCdUsr() != null)
					&& (!filtro.getDwTParada().getOmUsrByIdUsrstativo().getCdUsr().equals(""))) {
				q.append("AND t.omUsrByIdUsrstativo.cdUsr = :cdUsrSt");
			}
			if((filtro.getDwTParada().getOmUsrByIdUsrstativo() != null)
					&& (filtro.getDwTParada().getOmUsrByIdUsrstativo().getDsNome() != null)
					&& (!filtro.getDwTParada().getOmUsrByIdUsrstativo().getDsNome().equals(""))) {
				q.append("AND t.omUsrByIdUsrstativo.dsNome = :dsNomeSt");
			}
			if((filtro.getDwTParada().getOmUsrByIdUsrrevisao() != null)
					&& (filtro.getDwTParada().getOmUsrByIdUsrrevisao().getCdUsr() != null)
					&& (!filtro.getDwTParada().getOmUsrByIdUsrrevisao().getCdUsr().equals(""))) {
				q.append("AND t.omUsrByIdUsrrevisao.cdUsr = :cdUsrRev");
			}
			if((filtro.getDwTParada().getOmUsrByIdUsrrevisao() != null)
					&& (filtro.getDwTParada().getOmUsrByIdUsrrevisao().getDsNome() != null)
					&& (!filtro.getDwTParada().getOmUsrByIdUsrrevisao().getDsNome().equals(""))) {
				q.append("AND t.omUsrByIdUsrrevisao.dsNome = :dsNomeRev");
			}
			if(filtro.getDwTParada().getDtRevisao() != null) {
				q.append("AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF");
			}
			if(filtro.getDwTParada().getDtStativo() != null) {
				q.append("AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF");
			}
			if(filtro.getDwTParada().getIsFds() != null && filtro.getDwTParada().getIsFds() != false) {
				q.append("AND t.isFds = :isFds");
			}
			if(filtro.getDwTParada().getIsMdo() != null && filtro.getDwTParada().getIsMdo()  != false) {
				q.append("AND t.isMdo = :isMdo");
			}
			if(filtro.getDwTParada().getIsMtbf() != null && filtro.getDwTParada().getIsFds() != false) {
				q.append("AND t.isMtbf = :isMtbf");
			}
			if(filtro.getDwTParada().getIsPa() != null && filtro.getDwTParada().getIsPa() != false) {
				q.append("AND t.isPa = :isPa");
			}
			if(filtro.getDwTParada().getIsPao() != null && filtro.getDwTParada().getIsPao() != false) {
				q.append("AND t.isPao = :isPao");
			}
			if(filtro.getDwTParada().getIsPesa() != null && filtro.getDwTParada().getIsPesa() != false) {
				q.append("AND t.isPesa = :isPesa");
			}
			if(filtro.getDwTParada().getIsPp() != null && filtro.getDwTParada().getIsPp() != false) {
				q.append("AND t.isPp = :isPp ");
			}
			if(filtro.getDwTParada().getIsPrev() != null && filtro.getDwTParada().getIsPrev() != false) {
				q.append("AND t.isPrev = :isPrev");
			}
			if(filtro.getDwTParada().getIsPtp() != null && filtro.getDwTParada().getIsPtp() != false) {
				q.append("AND t.isPtp = :isPtp");
			}
			if(filtro.getDwTParada().getIsRegulagem() != null && filtro.getDwTParada().getIsRegulagem() != false) {
				q.append("AND t.isRegulagem = :isRegulagem");
			}
			if(filtro.getDwTParada().getIsPermitecorrecao() != null && filtro.getDwTParada().getIsPermitecorrecao() != false) {
				q.append("AND t.isPermitecorrecao = :isPermitecorrecao");
			}
			if(filtro.getDwTParada().getIsRequerAcao() != null && filtro.getDwTParada().getIsRequerAcao() != false) {
				q.append("AND t.isRequerAcao = :isRequerAcao");
			}
			if(filtro.getDwTParada().getIsRequerCausa() != null && filtro.getDwTParada().getIsRequerCausa() != false) {
				q.append("AND t.isRequerCausa = :isRequerCausa");
			}
			if(filtro.getDwTParada().getIsRequerJust() != null && filtro.getDwTParada().getIsRequerJust() != false) {
				q.append("AND t.isRequerJust = :isRequerJust");
			}
			if(filtro.getDwTParada().getIsScp() != null && filtro.getDwTParada().getIsScp() != false) {
				q.append("AND t.isScp = :isScp");
			}
			if(filtro.getDwTParada().getIsDefault() != null && filtro.getDwTParada().getIsDefault() != false) {
				q.append("AND t.isDefault = :isDefault");
			}
			if(filtro.getDwTParada().getIsSemConexao() != null && filtro.getDwTParada().getIsSemConexao() != false) {
				q.append("AND t.isSemConexao = :isSemConexao");
			}
			if(filtro.getDwTParada().getIsSemEvento() != null && filtro.getDwTParada().getIsSemEvento() != false) {
				q.append("AND t.isSemEvento = :isSemEvento");
			}			
			if(filtro.getDwTParada().getIsSemOp() != null && filtro.getDwTParada().getIsSemOp() != false) {
				q.append("AND t.isSemOp = :isSemOp");
			}
			if (filtro.getDwTParada().getIsSemOp() != null && filtro.getDwTParada().getIsSolicitarOS() != false) {
				q.append("AND t.isSolicitarOS = :issolicitaop");
			}
			if (filtro.getDwTParada().getRevisao() != null) {
				q.append("AND t.revisao = :revisao");
			}
			if (filtro.getDwTParada().getStAtivo() != null && filtro.getDwTParada().getStAtivo()<(byte)2) {
				q.append("AND t.stAtivo = :stAtivo");
			}
		}

		q.defineParametro("idTparada", filtro.getDwTParada().getIdTparada());
		q.defineParametro("cdTparada", filtro.getDwTParada().getCdTparada());
		q.defineParametro("dsTparada", filtro.getDwTParada().getDsTparada());

		if(filtro.getDwTParada().getOmTppt()!= null) {
			q.defineParametro("cdTppt", filtro.getDwTParada().getOmTppt().getCdTppt());
			q.defineParametro("dsTppt", filtro.getDwTParada().getOmTppt().getDsTppt());
		}

		if(filtro.getDwTParada().getDtRevisao() != null) {
			q.defineParametro("dtRevisao", filtro.getDwTParada().getDtRevisao());
			q.defineParametro("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getDwTParada().getDtRevisao()));
		}

		if(filtro.getDwTParada().getDtStativo() != null) {
			q.defineParametro("dtStativo", filtro.getDwTParada().getDtStativo());
			q.defineParametro("dtStativoF",DataHoraRN.getDataHora235959(filtro.getDwTParada().getDtStativo()));
		}

		q.defineParametro("revisao", filtro.getDwTParada().getRevisao());
		q.defineParametro("stAtivo", filtro.getDwTParada().getStAtivo());

		if (filtro.getDwTParada().getOmUsrByIdUsrrevisao() != null) {
			q.defineParametro("cdUsrRev", filtro.getDwTParada().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getDwTParada().getOmUsrByIdUsrrevisao().getDsNome());
		}

		if (filtro.getDwTParada().getOmUsrByIdUsrstativo() != null) {
			q.defineParametro("cdUsrSt", filtro.getDwTParada().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getDwTParada().getOmUsrByIdUsrstativo().getDsNome());
		}
		if(filtro.getDwTParada().getDwTArea() != null) {
			q.defineParametro("cdArea", filtro.getDwTParada().getDwTArea().getCdArea());
			q.defineParametro("dsArea", filtro.getDwTParada().getDwTArea().getDsArea());
		}
 
		if(filtro.getDwTParada().getIsFds() != null) {
			q.defineParametro("isFds", filtro.getDwTParada().getIsFds());
		}
		if(filtro.getDwTParada().getIsMdo() != null) {
			q.defineParametro("isMdo", filtro.getDwTParada().getIsMdo());
		}
		if(filtro.getDwTParada().getIsMtbf() != null) {
			q.defineParametro("isMtbf", filtro.getDwTParada().getIsMtbf());
		}
		if(filtro.getDwTParada().getIsPa() != null) {
			q.defineParametro("isPa", filtro.getDwTParada().getIsPa());
		}
		if(filtro.getDwTParada().getIsPao() != null) {
			q.defineParametro("isPao", filtro.getDwTParada().getIsPao());
		}
		if(filtro.getDwTParada().getIsPesa() != null) {
			q.defineParametro("isPesa", filtro.getDwTParada().getIsPesa());
		}
		if (filtro.getDwTParada().getIsSolicitarOS() != null) {
			q.defineParametro("issolicitaos", filtro.getDwTParada().getIsSolicitarOS());
		}
		if(filtro.getDwTParada().getIsPp() != null) {
			q.defineParametro("isPp", filtro.getDwTParada().getIsPp());
		}
		if(filtro.getDwTParada().getIsPrev() != null) {
			q.defineParametro("isPrev", filtro.getDwTParada().getIsPrev());
		}
		if(filtro.getDwTParada().getIsPtp() != null) {
			q.defineParametro("isPtp", filtro.getDwTParada().getIsPtp());
		}
		if(filtro.getDwTParada().getIsRegulagem() != null) {
			q.defineParametro("isRegulagem", filtro.getDwTParada().getIsRegulagem());
		}
		if(filtro.getDwTParada().getIsPermitecorrecao() != null) {
			q.defineParametro("isPermitecorrecao", filtro.getDwTParada().getIsPermitecorrecao());
		}
		if(filtro.getDwTParada().getIsRequerAcao() != null) {
			q.defineParametro("isRequerAcao", filtro.getDwTParada().getIsRequerAcao());
		}
		if(filtro.getDwTParada().getIsRequerCausa() != null) {
			q.defineParametro("isRequerCausa", filtro.getDwTParada().getIsRequerCausa());
		}
		if(filtro.getDwTParada().getIsRequerJust() != null) {
			q.defineParametro("isRequerJust", filtro.getDwTParada().getIsRequerJust());
		}
		if(filtro.getDwTParada().getIsScp() != null) {
			q.defineParametro("isScp", filtro.getDwTParada().getIsScp());
		}
		if(filtro.getDwTParada().getIsDefault() != null) {
			q.defineParametro("isDefault", filtro.getDwTParada().getIsDefault());
		}
		if(filtro.getDwTParada().getIsSemEvento() != null) {
			q.defineParametro("isSemEvento", filtro.getDwTParada().getIsSemEvento());
		}
		if(filtro.getDwTParada().getIsSemConexao() != null) {
			q.defineParametro("isSemConexao", filtro.getDwTParada().getIsSemConexao());
		}
		if(filtro.getDwTParada().getIsSemOp() != null) {
			q.defineParametro("isSemOp", filtro.getDwTParada().getIsSemOp());
		}
		List<DwTParada> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<DWParadaDTO> lista = new ArrayList<DWParadaDTO>();

		if (listaPesquisa != null) {
			for (DwTParada item : listaPesquisa) {
				DWParadaDTO paradaDTO = new DWParadaDTO();
				paradaDTO.setDwTParada(item.clone());
				lista.add(paradaDTO);
			}
		}
		ParadasDTO dtoRetorno = new ParadasDTO();
		dtoRetorno.setDwTParadas(lista);
		return dtoRetorno;
	}

	public DWParadaDTO setTparada(DWParadaDTO itemDTO){
		itemDTO.setResultado(new ResultadoDTO());
		if (itemDTO.getDwTParada() == null || itemDTO.getDwTParada().getCdTparada() == null || 
				itemDTO.getDwTParada().getCdTparada().equals("")) {
			itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().CODIGO_DESCONHECIDO);
			return itemDTO;
		}
		
		if(itemDTO.getDwTParada().getQtTec() != null && itemDTO.getDwTParada().getQtTec() > 3) {
			itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().QTD_TEC_INVALIDA);
			return itemDTO;
		}

		DwTParada itemOriginal = new DwTParada();
		itemOriginal = itemDTO.getDwTParada().clone();
		
		
		//20160926FVA:
		if (itemOriginal != null && itemOriginal.getIdTparada()!=null && itemOriginal.getIdTparada() > 0 && itemOriginal.getStAtivo().equals((byte)0)){
			ResultadoDTO resultadodto = new ResultadoDTO();
			resultadodto.setIdmensagem(resultadodto.getERRO_REATIVACAO_INDISPONIVEL());
			itemDTO.setResultado(resultadodto);
			return itemDTO;
		}

		
		TpptRN tpptRN = new TpptRN(this.getDao());
		OmTppt omTppt = tpptRN.getOmTpptDTO(itemDTO.getDwTParada().getOmTppt());
		if (omTppt == null) {
			itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().TIPO_PT_DESCONHECIDO);
			return itemDTO;
		}
		itemOriginal.setOmTppt(omTppt);
		
		DwTArea dwtarea = null;
		if (itemDTO.getDwTParada().getDwTArea() != null && itemDTO.getDwTParada().getDwTArea().getCdArea() != null && !itemDTO.getDwTParada().getDwTArea().getCdArea().isEmpty()) {
			try {
				AreaRN areaRN = new AreaRN(getDao());
				dwtarea = areaRN.getDwTArea(itemDTO.getDwTParada().getDwTArea().getCdArea(), true);
			} catch (RegistroDesconhecidoException e) { }
		}
		itemOriginal.setDwTArea(dwtarea);
		
		DwTAlerta alerta = null;
		if(itemDTO.getDwTParada().getDwTAlerta() != null && itemDTO.getDwTParada().getDwTAlerta().getCdTalerta() != null && itemDTO.getDwTParada().getDwTAlerta().getCdTalerta().isEmpty() == false && itemDTO.getDwTParada().getDwTAlerta().getCdTalerta().trim().equals("") == false) {
			AlertaRN alertaRN = new AlertaRN(getDao());
			try {
				alerta = alertaRN.getDwTAlerta(itemDTO.getDwTParada().getDwTAlerta().getCdTalerta(), omTppt);
			} catch (RegistroDesconhecidoException e) {
				alerta = null;
			}
			if (alerta == null || alerta.getOmTppt().getCdTppt().equals(itemDTO.getDwTParada().getOmTppt().getCdTppt()) == false) {
				itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().ALERTA_TIPO_INVALIDO);
				return itemDTO;
			}
		} else if (itemDTO.getDwTParada().getSegTimeoutalerta() != null && itemDTO.getDwTParada().getSegTimeoutalerta().intValue() > 0) {
			// Se o tempo tiver sido definido e o alerta nao reotrnar erro
			itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().ALERTA_TIPO_INVALIDO);
			return itemDTO;
		} 
		if (alerta != null && (itemDTO.getDwTParada().getSegTimeoutalerta() == null || itemDTO.getDwTParada().getSegTimeoutalerta().equals("")) ) {
			// se o alerta tiver sido definido mas o tempo nao
			itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().TIMEOUT_INVALIDO);
			return itemDTO;
		}
		itemOriginal.setDwTAlerta(alerta);
		DwTParada dwTParada = null;
		if(itemDTO.getDwTParada().getDwTParadaextra() != null &&  itemDTO.getDwTParada().getDwTParadaextra().getCdTparada() != null && itemDTO.getDwTParada().getDwTParadaextra().getCdTparada().isEmpty() == false && itemDTO.getDwTParada().getDwTParadaextra().getCdTparada().trim().equals("") == false) {
			try {
				dwTParada = getDwTParada(itemDTO.getDwTParada().getDwTParadaextra().getCdTparada(), omTppt);
			} catch (RegistroDesconhecidoException e) {
				dwTParada = null;
			}
			if (dwTParada == null || dwTParada.getOmTppt().getCdTppt().equals(itemDTO.getDwTParada().getOmTppt().getCdTppt()) == false) {
				itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().PARADA_TIPO_INVALIDO );
				return itemDTO;
			}
			if (dwTParada == null || dwTParada.getCdTparada().equals(itemDTO.getDwTParada().getCdTparada())) {
				itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().PARADA_TIPO_INVALIDO );
				return itemDTO;
			}
		} else if (itemDTO.getDwTParada().getSegExtrapolacao() != null && itemDTO.getDwTParada().getSegExtrapolacao().intValue() > 0) {
			itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().PARADA_TIPO_INVALIDO );
			return itemDTO;
		}
		if (dwTParada != null && (itemDTO.getDwTParada().getSegExtrapolacao() == null || itemDTO.getDwTParada().getSegExtrapolacao().equals("")) ) {
			// se o alerta tiver sido definido mas o tempo nao
			itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().TIMEOUT_INVALIDO);
			return itemDTO;
		}
		
		itemOriginal.setDwTParadaextra(dwTParada);
		
		// Pesquisar o registro
		DwTParada pojo = null;
		if (itemOriginal != null && itemOriginal.getIdTparada() != null && itemOriginal.getIdTparada() > 0) {
			pojo = getDwTParada(itemOriginal.getIdTparada());
		}
		if (pojo != null && pojo.getStAtivo().equals((byte) 0) ) {
			itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().ERRO_EXCLUI_STATIVO_ZERO );
			return itemDTO;
		}
		if (pojo == null) {
			try {
				pojo = getDwTParada(itemOriginal.getCdTparada(), omTppt);
				if (pojo != null) {
					itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().REGISTRO_JA_EXISTE);
					return itemDTO;
				}
			} catch (RegistroDesconhecidoException e) {
				pojo = null;
			}
		}

		
		itemDTO.setDwTParada(salvarDesativandoOriginal(itemOriginal, new Date(), itemDTO.getDwTParada().getOmUsrByIdUsrrevisao()).clone());
		return itemDTO;
	}

	public ParadasDTO removeTparada(ParadasDTO itens){
		ParadasDTO itensRetorno = new ParadasDTO();
		
		
		//17/03/2017 Alex: nao remover codigo em uso na configuracao geral.
		CamposEmUsoOmCfgDTO camposEmUsoOmCfgDTO = getCamposEmUsoOmCfg(itens);
		itensRetorno.setCamposEmUsoOmCfg(camposEmUsoOmCfgDTO);
		if(camposEmUsoOmCfgDTO.getStatus() != camposEmUsoOmCfgDTO.getSTATUS_NENHUM_CAMPO_EM_USO()) {
			//se entrar nesse if eh pq existe algum codigo em uso
			return itensRetorno;
		}
		
		
		List<DWParadaDTO> listaRetorno = new ArrayList<DWParadaDTO>();

		for(DWParadaDTO item: itens.getDwTParadas()){
			OmUsr omUser = new OmUsr();
			UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
			
			try {
				omUser = usuarioRN.getOmUsr(item.getDwTParada().getOmUsrByIdUsrrevisao().getCdUsr());
			} catch (RegistroDesconhecidoException e) {
				e.printStackTrace();
			}
			try {
				desativarParada(item.getDwTParada().getIdTparada(),new Date(), omUser);
			} catch (RegistroJaDesativadoException e) {
				e.printStackTrace();
			}
			
		}
		
		itensRetorno.setDwTParadas(listaRetorno);
		return itensRetorno;
	}
	
	private CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg(ParadasDTO itens) {
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		
		//campos
		DwTParada paradaEmUso = omcfg.getDwTParada();
		DwTParada paradaSemConexaoEmUso = omcfg.getDwTParadasemconexao();
		DwTParada paradaPadraoCipConexaoEmUso = omcfg.getDwTParadaByIdTparadacip();
		
		CamposEmUsoOmCfgDTO camposEmUsoOmCfg = new CamposEmUsoOmCfgDTO();
		boolean isTemCodigoEmUso = false;
		for(DWParadaDTO item: itens.getDwTParadas()) {
			camposEmUsoOmCfg.setCodigo(item.getDwTParada().getCdTparada());
			
			if(paradaEmUso != null) {
				if(item.getDwTParada().getCdTparada().equals(paradaEmUso.getCdTparada())) {
					camposEmUsoOmCfg.setParada(true);
					isTemCodigoEmUso = true;
				}
			}
			
			if(paradaSemConexaoEmUso != null) {
				if(item.getDwTParada().getCdTparada().equals(paradaSemConexaoEmUso.getCdTparada())) {
					camposEmUsoOmCfg.setParadaPadraoPeriodoSemConexao(true);
					isTemCodigoEmUso = true;
				}
			}
			
			if(paradaPadraoCipConexaoEmUso != null) {
				if(item.getDwTParada().getCdTparada().equals(paradaPadraoCipConexaoEmUso.getCdTparada())) {
					camposEmUsoOmCfg.setParadaPadraoCIP(true);
					isTemCodigoEmUso = true;
				}
			}
			
		}
		
		if(isTemCodigoEmUso) {
			
			if(itens.getDwTParadas() != null && itens.getDwTParadas().size() > 1) {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_EXCLUSAO_ABORTADA());
			} else {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_TEM_CAMPO_EM_USO());
			}
			
		} else {
			camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_NENHUM_CAMPO_EM_USO());
		}
		
		return camposEmUsoOmCfg;
	}
	
	public DetalhamentoParadaDTO pesquisarOcorrenciasParadas(FiltroParadasDTO filtro){
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwConsols dwconsol");
		q.append("JOIN dwconsol.dwConsolpas dwconsolpa");
		q.append("JOIN dwconsolpa.dwConsolpaocos dwconsolpaoco");
		q.append("JOIN dwconsolpa.dwTParada dwtparada");
		q.append("WHERE consolid.dtReferencia BETWEEN :dtInicio AND :dtFim");
		q.append("and dwconsolpaoco.dthrFparada is not null");
		q.append("AND consolid.omPt.idPt = :idpt");
		q.append("AND consolid.tpId = :tpId");
				
		if(filtro.getTurno() != null){
			q.append("AND consolid.dwTurno.idTurno = :idturno");
		}
		
		if (filtro.gettParada() != null && filtro.gettParada().getCdTparada() != null && filtro.gettParada().getCdTparada().equals("") == false) {
			q.append("AND dwtparada.cdTparada = :cdparada");
		}
		q.defineParametro("tpId", (byte)1);
		q.defineParametro("idpt", filtro.getPt().getIdPt());
		q.defineParametroData("dtInicio", filtro.getDataInicio());
		q.defineParametroData("dtFim", DataHoraRN.getDataHora235959(filtro.getDataFim()));
		if(filtro.getTurno() != null){
			q.defineParametro("idturno", filtro.getTurno().getIdTurno());
		}
		if (filtro.gettParada() != null  && filtro.gettParada().getCdTparada() != null && filtro.gettParada().getCdTparada().equals("") == false) {
			q.defineParametro("cdparada", filtro.gettParada().getCdTparada());
		}
		

		List<DwConsolid> listaConsolids = q.list();
		
		List<DetalheParadaDTO> listaParadas = new ArrayList<DetalheParadaDTO>();
	
		for(DwConsolid consolid : listaConsolids){			
			for(DwConsol consol : consolid.getDwConsols()){
				for(DwConsolpa consolpa : consol.getDwConsolpas()){
					for(DwConsolpaoco consolpaoco : consolpa.getDwConsolpaocos()){
						
						boolean isParadaAberta = consolpaoco.getDwConsolpalog().getDthrFparada() == null;
						if(isParadaAberta) {
							continue;
						}
						
						if (consolpaoco.getDthrFparada() == null)
							continue;
						
						MsPtColeta msptcoleta = consolid.getOmPt().getMsPtColeta();
						boolean isUltimaParadaQueAindaEstaNoColetor = 
								msptcoleta != null 
								&& msptcoleta.getDthrIparada() != null
								&& consolpaoco != null
								&& consolpaoco.getDwConsolpalog() != null
								&& consolpaoco.getDwConsolpalog().getDthrIparada() != null
								&& DataHoraRN.equals(msptcoleta.getDthrIparada(), consolpaoco.getDwConsolpalog().getDthrIparada());
						if (isUltimaParadaQueAindaEstaNoColetor)
							continue;

						if(consolpaoco.getDwConsolpa().getDwTParada() != null && 
								consolpaoco.getDwConsolpa().getDwTParada().getIsPermitecorrecao() != null &&
								consolpaoco.getDwConsolpa().getDwTParada().getIsPermitecorrecao()){

							// Se o filtro de parada estiver definido e for diferente da parada lida, ignorar a ocorrencia e passar pra proxima
							if ( filtro.gettParada() != null && filtro.gettParada().getCdTparada() != null &&  filtro.gettParada().getCdTparada().equals(consolpaoco.getDwConsolpa().getDwTParada().getCdTparada()) == false)
								continue;
							
							String parada = consolpaoco.getDwConsolpa().getDwTParada().getCdTparada()+" - "+consolpaoco.getDwConsolpa().getDwTParada().getDsTparada();
							String causa = "";
							String acao = "";
							String justificativa = "";
							
							DwTCausa dwTCausa = null;
							
							if(consolpaoco.getDwTCausa() != null){
								dwTCausa = consolpaoco.getDwTCausa();
							} /* Alessandre em 07-10-16 
								comente o else pq a correcao de parada estava mostrando a
								causa da parada mesmo tendo sido corrigida  else if(consolpaoco.getDwConsolpalog() != null && consolpaoco.getDwConsolpalog().getDwTCausa() != null){
								dwTCausa = consolpaoco.getDwConsolpalog().getDwTCausa();
							} */
							
							if(dwTCausa != null){
								causa = dwTCausa.getCdTcausa()+" - "+dwTCausa.getDsTcausa();
							}
							
							if(consolpaoco.getDwTAcao() != null){
								acao = consolpaoco.getDwTAcao().getCdTacao()+" - "+consolpaoco.getDwTAcao().getDsTacao();
							}
							if(consolpaoco.getDwTJust() != null){
								justificativa = consolpaoco.getDwTJust().getCdTjust()+" - "+consolpaoco.getDwTJust().getDsTjust();
							}
							
							long segDuracao = DataHoraRN.getQuantidadeMilisegundosNoPeriodo(consolpaoco.getDthrIparada(), consolpaoco.getDthrFparada());
							
							DetalheParadaDTO ocorrenciaParada = new DetalheParadaDTO();
							ocorrenciaParada.setDwConsolpaoco(consolpaoco.clone(false));
							ocorrenciaParada.setParada(parada);
							ocorrenciaParada.setInicio(consolpaoco.getDthrIparada());
							ocorrenciaParada.setFim(consolpaoco.getDthrFparada());
							ocorrenciaParada.setDuracao(DataHoraRN.formatMilisegundosParaHHMMSSmmm(segDuracao));
							
							ocorrenciaParada.setDuracaoEmSegundos( (double) (segDuracao / 1000));
							ocorrenciaParada.setCausa(causa);
							ocorrenciaParada.setAcao(acao);
							ocorrenciaParada.setJustificativa(justificativa);
							ocorrenciaParada.setTurno(consolid.getDwTurno().getDsTurno());
							listaParadas.add(ocorrenciaParada);
							
						}	
					}
				}
			}
		}
		
		DetalhamentoParadaDTO retorno = new DetalhamentoParadaDTO();
		retorno.setListaparadas(listaParadas);

		Comparator<DetalheParadaDTO> comparator = new Comparator<DetalheParadaDTO>() {
			@Override
			public int compare(DetalheParadaDTO o1, DetalheParadaDTO o2) {
				return DataHoraRN.compareTo(o1.getInicio(), o2.getInicio());
			}
		};
		
		Collections.sort(retorno.getListaparadas(), comparator);
		
		return retorno;
	}
	
public DetalhamentoParadaDTO pesquisarOcorrenciasParadasREST(FiltroParadasDTO filtro){
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("FROM OmPt ompt");
		q.append("WHERE cdPt = :dsUp");
		q.append("and stAtivo = 1");
		
		q.defineParametro("dsUp", filtro.getPt().getCdPt());
		
		OmPt ompt = (OmPt) q.uniqueResult();
		
		q = new MapQuery(getDaoSession());
		
		q.append("SELECT DISTINCT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwConsols dwconsol");
		q.append("JOIN dwconsol.dwConsolpas dwconsolpa");
		q.append("JOIN dwconsolpa.dwConsolpaocos dwconsolpaoco");
		q.append("JOIN dwconsolpa.dwTParada dwtparada");
		q.append("JOIN dwconsolpaoco.dwConsolpalog dwconsolpalog");
		q.append("WHERE (consolid.dtReferencia BETWEEN :dtInicio AND :dtFim)");
		q.append("and dwconsolpaoco.dthrFparada is not null");
		q.append("AND consolid.omPt.idPt = :idpt");
		q.append("AND consolid.tpId = :tpId");
		q.append("order by consolid.dtReferencia DESC");
				
		if(filtro.getTurno() != null){
			q.append("AND consolid.dwTurno.idTurno = :idturno");
		}
		
		if (filtro.gettParada() != null && filtro.gettParada().getCdTparada() != null && filtro.gettParada().getCdTparada().equals("") == false) {
			q.append("AND dwtparada.cdTparada = :cdparada");
		}
		q.defineParametro("tpId", (byte)1);
		q.defineParametro("idpt", ompt.getIdPt());
		q.defineParametroData("dtInicio", filtro.getDataInicio());
		q.defineParametroData("dtFim",filtro.getDataFim());
		if(filtro.getTurno() != null){
			q.defineParametro("idturno", filtro.getTurno().getIdTurno());
		}
		if (filtro.gettParada() != null  && filtro.gettParada().getCdTparada() != null && filtro.gettParada().getCdTparada().equals("") == false) {
			q.defineParametro("cdparada", filtro.gettParada().getCdTparada());
		}
		
		//q.setMaxResults(100);

		List<DwConsolid> listaConsolids = q.list();

		List<DetalheParadaDTO> listaParadas = new ArrayList<DetalheParadaDTO>();
	
		for(DwConsolid consolid : listaConsolids){			
			for(DwConsol consol : consolid.getDwConsols()){
				for(DwConsolpa consolpa : consol.getDwConsolpas()){
					for(DwConsolpaoco consolpaoco : consolpa.getDwConsolpaocos()){
						
						boolean isParadaAberta = consolpaoco.getDwConsolpalog().getDthrFparada() == null;
						if(isParadaAberta) {
							continue;
						}
						
						if (consolpaoco.getDthrFparada() == null)
							continue;

						if(consolpaoco.getDwConsolpa().getDwTParada() != null && 
								consolpaoco.getDwConsolpa().getDwTParada().getIsPermitecorrecao() != null &&
								consolpaoco.getDwConsolpa().getDwTParada().getIsPermitecorrecao()){

							// Se o filtro de parada estiver definido e for diferente da parada lida, ignorar a ocorrencia e passar pra proxima
							if ( filtro.gettParada() != null && filtro.gettParada().getCdTparada() != null &&  filtro.gettParada().getCdTparada().equals(consolpaoco.getDwConsolpa().getDwTParada().getCdTparada()) == false)
								continue;
							
							String parada = consolpaoco.getDwConsolpa().getDwTParada().getCdTparada()+" - "+consolpaoco.getDwConsolpa().getDwTParada().getDsTparada();
							String causa = "";
							String acao = "";
							String justificativa = "";
									
							if(consolpaoco.getDwTCausa() != null){
								causa = consolpaoco.getDwTCausa().getCdTcausa()+" - "+consolpaoco.getDwTCausa().getDsTcausa();
							}
							if(consolpaoco.getDwTAcao() != null){
								acao = consolpaoco.getDwTAcao().getCdTacao()+" - "+consolpaoco.getDwTAcao().getDsTacao();
							}
							if(consolpaoco.getDwTJust() != null){
								justificativa = consolpaoco.getDwTJust().getCdTjust()+" - "+consolpaoco.getDwTJust().getDsTjust();
							}
							
							long segDuracao = DataHoraRN.getQuantidadeMilisegundosNoPeriodo(consolpaoco.getDthrIparada(), consolpaoco.getDthrFparada());
							
							DetalheParadaDTO ocorrenciaParada = new DetalheParadaDTO();
							ocorrenciaParada.setDwConsolpaoco(consolpaoco.clone(false));
							ocorrenciaParada.getDwConsolpaoco().setDwConsolpalog(consolpaoco.getDwConsolpalog().clone(false));
							ocorrenciaParada.setParada(parada);
							ocorrenciaParada.setInicio(consolpaoco.getDthrIparada());
							ocorrenciaParada.setFim(consolpaoco.getDthrFparada());
							ocorrenciaParada.setDuracao(DataHoraRN.formatMilisegundosParaHHMMSSmmm(segDuracao));
							ocorrenciaParada.setDuracaoEmSegundos( (double) (segDuracao / 1000));

							ocorrenciaParada.setCausa(causa);
							ocorrenciaParada.setAcao(acao);
							ocorrenciaParada.setJustificativa(justificativa);
							ocorrenciaParada.setTurno(consolid.getDwTurno().getDsTurno());
							//if(listaParadas.size() < 100){
								
							
							listaParadas.add(ocorrenciaParada);
							//}
						}	
					}
				}
			}
		}
		
		DetalhamentoParadaDTO retorno = new DetalhamentoParadaDTO();
		retorno.setListaparadas(listaParadas);

		Comparator<DetalheParadaDTO> comparator = new Comparator<DetalheParadaDTO>() {
			@Override
			public int compare(DetalheParadaDTO o1, DetalheParadaDTO o2) {
				return DataHoraRN.compareTo(o1.getInicio(), o2.getInicio());
			}
		};
		
		Collections.sort(retorno.getListaparadas(), comparator);
		
		return retorno;
	}

	public ParadasDTO getDwTParadasDistinctCdDs(){
		final int cd_tparada = 0;
		final int ds_tparada = 1;
		ParadasDTO retorno = new ParadasDTO();
		retorno.setDwTParadas(new ArrayList<DWParadaDTO>());
		DwTParadaDAO paradaDAO = new DwTParadaDAO(getDaoSession());
		List<Object> tipoParadas = paradaDAO.getDwTParadasDistinctCdDs();
		for(Object obj : tipoParadas){
			Object[] registro = (Object[]) obj;
			DwTParada tParada = new DwTParada();
			DWParadaDTO paradaDTO = new DWParadaDTO();
			tParada.setCdTparada((String) registro[cd_tparada]);
			tParada.setDsTparada((String) registro[ds_tparada]);
			paradaDTO.setDwTParada(tParada);
			retorno.getDwTParadas().add(paradaDTO);
		}
		return retorno;
	}
	
	public ParadasDTO getDwTParadasAtivas(){
		ParadasDTO retorno = new ParadasDTO();
		retorno.setDwTParadas(new ArrayList<DWParadaDTO>());
		DwTParadaDAO paradaDAO = new DwTParadaDAO(getDaoSession());
		List<DwTParada> tipoParadas = paradaDAO.getDwTParadasAtivas();
		for(DwTParada parada : tipoParadas){
			DWParadaDTO paradaDTO = new DWParadaDTO();
			paradaDTO.setDwTParada(parada.clone(false));
			retorno.getDwTParadas().add(paradaDTO);
		}
		return retorno;
	}

	@SuppressWarnings("unused")
	public ListaParadasDTO getParadasDTO(FiltroPesquisaDTO filtro) {
		ListaParadasDTO retorno = new ListaParadasDTO();
		retorno.setItems(new ArrayList<ParadaCadDTO>());
		retorno.setMeta(new MetaDTO(filtro));
		
		MapQuery q = new MapQuery(this.getDaoSession());
		
		q.append("select DISTINCT t ");
		q.append("FROM DwTParada t");
		//q.append("JOIN FETCH t.omTppt tt");
		//q.append("JOIN FETCH t.dwTArea ta");
		//q.append("LEFT JOIN FETCH t.dwTAlerta tale");
		//q.append("LEFT JOIN FETCH t.dwTParadaextra tpe");
		q.append("where t.stAtivo = 1 ");
		q.append(" and t.omTppt.cdTppt = 'CIC' ");
		
		
		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")){
			q.append("AND (");
			q.append(" upper(t.cdTparada) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.dsTparada) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");		 
		}
		
		q.append("order by t.cdTparada");
		
		List<DwTParada> listaPesquisa = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
 		for (DwTParada registro : listaPesquisa) {
 			ParadaCadDTO regDTO = new ParadaCadDTO();
 			
 			regDTO.setIdParada(registro.getIdTparada().intValue());
 			regDTO.setCdParada(registro.getCdTparada());
 			regDTO.setDsParada(registro.getDsTparada());
 			regDTO.setCdArea(registro.getDwTArea() == null ? "" : registro.getDwTArea().getCdArea());
 			regDTO.setDsArea(registro.getDwTArea() == null ? "" : registro.getDwTArea().getDsArea());
 			regDTO.setTpPt("CIC");
 			
 			regDTO.setQtdTec(0);
 			if (registro.getQtTec() != null) {
 				regDTO.setQtdTec(registro.getQtTec());
 			}
 			
 			regDTO.setReqCausa(registro.getIsRequerCausa() == null ? false : registro.getIsRequerCausa());
 			regDTO.setReqAcao(registro.getIsRequerAcao() == null ? false : registro.getIsRequerAcao());
 			regDTO.setReqJustificativa(registro.getIsRequerJust() == null ? false : registro.getIsRequerJust());
 			regDTO.setReqMTBFMTTR(registro.getIsMtbf() == null ? false : registro.getIsMtbf());
 			regDTO.setReqPermiteCorrecao(registro.getIsPermitecorrecao() == null ? false : registro.getIsPermitecorrecao());
 			regDTO.setReqCancelamento(registro.getIsRegulagem() == null ? false : registro.getIsRegulagem());
 			regDTO.setReqPesaEficiencia(registro.getIsPesa() == null ? false : registro.getIsPesa());
 			
 			regDTO.setStRegistro(registro.getStAtivo().intValue());
 			regDTO.setRevisao(registro.getRevisao().intValue());


			regDTO.setTimeOutAlerta(new TimeOutAlertaParCadDTO());
 			if (registro.getDwTAlerta() != null) {
 				regDTO.getTimeOutAlerta().setCdAlerta(registro.getDwTAlerta().getCdTalerta());
 				regDTO.getTimeOutAlerta().setTimeout(registro.getSegTimeoutalerta().intValue());
 			} else {
 				regDTO.getTimeOutAlerta().setCdAlerta("");
 				regDTO.getTimeOutAlerta().setTimeout(0); 				
 			}

			regDTO.setTimeOutParada(new TimeOutParadaParCadDTO());
 			if (registro.getDwTParadaextra() != null) {
 				regDTO.getTimeOutParada().setCdParada(registro.getDwTParadaextra().getCdTparada());
 				regDTO.getTimeOutParada().setTimeout(registro.getSegExtrapolacao().intValue());
 			} else {
 				regDTO.getTimeOutParada().setCdParada("");
 				regDTO.getTimeOutParada().setTimeout(0);
 			}
 			
			retorno.getItems().add(regDTO);
 		}
		
		
 		if (listaPesquisa.size() > 0) {
 			ResumoRetornoRegistrosRN resRN = new ResumoRetornoRegistrosRN(getDao());
 			retorno.setMeta(resRN.getMetaDTO(filtro, q, listaPesquisa.size()));
 			resRN = null;
 		}
		
		q = null;
		listaPesquisa = null;
		
		return retorno;
		
	}

	
	@SuppressWarnings("unused")
	public ParadaCadDTO getParadaByCd(String cdParada) {
		ParadaCadDTO retorno = new ParadaCadDTO();
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select DISTINCT t ");
		q.append("FROM DwTParada t");
		//q.append("JOIN FETCH t.omTppt tt");
		//q.append("JOIN FETCH t.dwTArea ta");
		//q.append("LEFT JOIN FETCH t.dwTAlerta tale");
		//q.append("LEFT JOIN FETCH t.dwTParadaextra tpe");
		q.append("where t.stAtivo = 1 ");
		q.append(" and t.omTppt.cdTppt = 'CIC' ");
		
		q.append("AND t.cdTparada = :cdTparada");
		q.append("order by t.cdTparada");
		
 		q.defineParametro("cdTparada", cdParada);

 		List<DwTParada> lista = q.list();
 		
 		if (lista.size() == 1) { 
 			retorno.setIdParada(lista.get(0).getIdTparada().intValue());
 			retorno.setCdParada(lista.get(0).getCdTparada());
 			retorno.setDsParada(lista.get(0).getDsTparada());
 			retorno.setCdArea(lista.get(0).getDwTArea() == null ? "" : lista.get(0).getDwTArea().getCdArea());
 			retorno.setDsArea(lista.get(0).getDwTArea() == null ? "" : lista.get(0).getDwTArea().getDsArea());
 			retorno.setTpPt("CIC");
 			
 			retorno.setQtdTec(0); 			
 			if (lista.get(0).getQtTec() != null) {
 				retorno.setQtdTec(lista.get(0).getQtTec());
 			}
 			
 			retorno.setReqCausa(lista.get(0).getIsRequerCausa() == null ? false : lista.get(0).getIsRequerCausa());
 			retorno.setReqAcao(lista.get(0).getIsRequerAcao() == null ? false : lista.get(0).getIsRequerAcao());
 			retorno.setReqJustificativa(lista.get(0).getIsRequerJust() == null ? false : lista.get(0).getIsRequerJust());
 			retorno.setReqMTBFMTTR(lista.get(0).getIsMtbf() == null ? false : lista.get(0).getIsMtbf());
 			retorno.setReqPermiteCorrecao(lista.get(0).getIsPermitecorrecao() == null ? false : lista.get(0).getIsPermitecorrecao());
 			retorno.setReqCancelamento(lista.get(0).getIsRegulagem() == null ? false : lista.get(0).getIsRegulagem());
 			retorno.setReqPesaEficiencia(lista.get(0).getIsPesa() == null ? false : lista.get(0).getIsPesa());
 			
 			retorno.setStRegistro(lista.get(0).getStAtivo().intValue());
 			retorno.setRevisao(lista.get(0).getRevisao().intValue());

 			retorno.setTimeOutAlerta(new TimeOutAlertaParCadDTO());
 			if (lista.get(0).getDwTAlerta() != null) { 				
 				retorno.getTimeOutAlerta().setCdAlerta(lista.get(0).getDwTAlerta().getCdTalerta());
 				retorno.getTimeOutAlerta().setTimeout(lista.get(0).getSegTimeoutalerta().intValue());
 			} else { 				
 				retorno.getTimeOutAlerta().setCdAlerta("");
 				retorno.getTimeOutAlerta().setTimeout(0);
 			}

			retorno.setTimeOutParada(new TimeOutParadaParCadDTO());
 			if (lista.get(0).getDwTParadaextra() != null) {
 				retorno.getTimeOutParada().setCdParada(lista.get(0).getDwTParadaextra().getCdTparada());
 				retorno.getTimeOutParada().setTimeout(lista.get(0).getSegExtrapolacao().intValue());
 			} else {
 				retorno.getTimeOutParada().setCdParada("");
 				retorno.getTimeOutParada().setTimeout(0); 				
 			}
 		}
 		
 		lista = null;
 		q = null;
 		
		return retorno;
	}
	
}