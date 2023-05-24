package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmGtDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwCalavu;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProturno;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.DwCalsemTemplate;
import idw.model.pojos.template.DwCalsemTemplate.DiaSemana;
import idw.model.pojos.template.DwCalsemTemplate.TpDtReferencia;
import idw.model.rn.monitorizacao.MonitorizacaoRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.ObjDTO;
import idw.webservices.dto.ObjsDTO;
import idw.webservices.dto.TurnoAtualDTO;
import idw.webservices.dto.TurnoDTO;
import idw.webservices.dto.TurnosDTO;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.ListaTurnosDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;
import idw.webservices.rest.idw.v2.dto.TurnoDTO2;
import injetws.model.excessoes.SemSGBDException;
import ms.util.ConversaoTipos;

@SuppressWarnings({ "unchecked" })
public class TurnoRN extends AbstractRN<DAOGenerico> {

	/** Código para o turno indefinido é o 0 (zero) */
	public static String CD_TURNO_INDEFINIDO = "0";

	/** Código para o calendário indefinido é o 0 (zero) */
	public static String CD_CALENDARIO_INDEFINIDO = "0";

	public TurnoRN() {
		this(null);
	}

	public TurnoRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	public TurnosDTO getTurnos(){
		TurnosDTO retorno = new TurnosDTO();
		MapQuery query = new MapQuery(getDao().getSession());
		query.append("SELECT t");
		query.append("FROM DwTurno t");
		query.append("WHERE t.stAtivo = 1");
		// Alessandre: removi a linha abaixo em 21/10/12 pois desejo que ate o turno indefinido retorne para a monitorizacao em tempo real
		//query.append("AND t.idTurno > 1");

		List<DwTurno> listaDwTurno = new ArrayList<DwTurno>();
		listaDwTurno =  query.list();
		List<TurnoDTO> listaTurnoDTO = new ArrayList<TurnoDTO>();
		if (listaDwTurno != null){
			for (DwTurno dwTurno :listaDwTurno){
				TurnoDTO turno = new TurnoDTO();
				turno.setTurno(dwTurno.clone(false));
				listaTurnoDTO.add(turno);
			}
		}
		retorno.setTurnos(listaTurnoDTO);
		return retorno;
	}

	public TurnosDTO getTurnosDTO(TurnoDTO filtro) {

		String hql = "";
		hql += "select t ";
		hql += "from DwTurno t ";
		hql += "where 1=1 ";

		if (filtro.getTurno().getIdTurno() != 0) {
			hql += "AND t.idTurno=::idTurno: ";
		} else {
			if (filtro.getTurno().getCdTurno() != null && !filtro.getTurno().getCdTurno().equals("")) {
				hql += "AND t.cdTurno='::cdTurno:' ";
			}
			if (filtro.getTurno().getDsTurno() != null && !filtro.getTurno().getDsTurno().equals("")) {
				hql += "AND t.dsTurno='::dsTurno:' ";
			}
			if (filtro.getTurno().getCor() != null && !filtro.getTurno().getCor().equals("")) {
				hql += "AND t.cor='::cor:' ";
			}
			if (filtro.getTurno().getDtRevisao() != null) {
				hql += "AND t.dtRevisao=:dtRevisao ";
			}
			if (filtro.getTurno().getOmUsrByIdUsrrevisao() != null && !filtro.getTurno().getOmUsrByIdUsrrevisao().getCdUsr().equals("")) {
				hql += "AND t.omUsrByIdUsrrevisao.cdUsr='::cdUsrRev:' ";
			}
			if (filtro.getTurno().getOmUsrByIdUsrrevisao() != null && !filtro.getTurno().getOmUsrByIdUsrrevisao().getDsNome().equals("")) {
				hql += "AND t.omUsrByIdUsrrevisao.dsNome='::dsNomeRev:' ";
			}
			if (filtro.getTurno().getOmUsrByIdUsrstativo() != null && !filtro.getTurno().getOmUsrByIdUsrstativo().getCdUsr().equals("")) {
				hql += "AND t.omUsrByIdUsrstativo.cdUsr='::cdUsrSt:' ";
			}
			if (filtro.getTurno().getOmUsrByIdUsrstativo() != null && !filtro.getTurno().getOmUsrByIdUsrstativo().getDsNome().equals("")) {
				hql += "AND t.omUsrByIdUsrstativo.dsNome='::dsNomeSt:' ";
			}
			if (filtro.getTurno().getDtStativo() != null) {
				hql += "AND t.dtStativo=:dtStativo ";
			}
			if (filtro.getTurno().getRevisao() != null) {
				hql += "AND t.revisao=::revisao: ";
			}
			if (filtro.getTurno().getStAtivo() != null && filtro.getTurno().getStAtivo() < (byte) 2) {
				hql += "AND t.stAtivo=::stAtivo: ";
			}
		}

		hql = hql.replaceAll("::idTurno:", String.valueOf(filtro.getTurno().getIdTurno()));
		hql = hql.replaceAll("::cdTurno:", filtro.getTurno().getCdTurno());
		hql = hql.replaceAll("::dsTurno:", filtro.getTurno().getDsTurno());
		hql = hql.replaceAll("::cor:", filtro.getTurno().getCor());
		if (filtro.getTurno().getOmUsrByIdUsrrevisao() != null) {
			hql = hql.replaceAll("::cdUsrRev:", filtro.getTurno()
					.getOmUsrByIdUsrrevisao().getCdUsr());
			hql = hql.replaceAll("::dsNomeRev:", filtro.getTurno()
					.getOmUsrByIdUsrrevisao().getDsNome());
		}
		if (filtro.getTurno().getOmUsrByIdUsrstativo() != null) {
			hql = hql.replaceAll("::cdUsrSt:", filtro.getTurno().getOmUsrByIdUsrstativo().getCdUsr());
			hql = hql.replaceAll("::dsNomeSt:", filtro.getTurno().getOmUsrByIdUsrstativo().getDsNome());
		}
		hql = hql.replaceAll("::revisao:", String.valueOf(filtro.getTurno().getRevisao()));
		hql = hql.replaceAll("::stAtivo:", String.valueOf(filtro.getTurno().getStAtivo()));

		Query q = getDaoSession().createQuery(hql);

		try {
			// q.setDate("dtRevisao", filtro.getUsuario().getDtRevisao());
			q.setDate("dtRevisao", filtro.getTurno().getDtRevisao());
		} catch (Exception e) {

		}
		try {
			// q.setDate("dtStativo", filtro.getUsuario().getDtStativo());
			q.setDate("dtStativo", filtro.getTurno().getDtStativo());
		} catch (Exception e) {

		}

		List<DwTurno> listaPesquisa = null;
		try {
			listaPesquisa = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<TurnoDTO> lista = new ArrayList<TurnoDTO>();

		if (listaPesquisa != null) {
			for (DwTurno item : listaPesquisa) {
				TurnoDTO itemDTO = new TurnoDTO();
				itemDTO.setTurno(item.clone());

				itemDTO.setResultadoEvento(0);
				lista.add(itemDTO);
			}
		}

		TurnosDTO dtoRetorno = new TurnosDTO();
		dtoRetorno.setTurnos(lista);
		return dtoRetorno;
	}

	
	
	/*
	 * Metodo para salvar o turno
	 * Nao sera gerado um novo id para o novo registro. Eh importante manter o turno 1 com id 1 e assim por diante
	 */
	public TurnoDTO setTurnoDTO(TurnoDTO itemDTO) {
		TurnoDTO dtoRetorno = new TurnoDTO();
		dtoRetorno.setResultadoEvento(dtoRetorno.getEVENTO_BEM_SUCEDIDO());

		if (itemDTO.getTurno().getCdTurno().trim().equals("")) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_CDTURNO_INVALIDO());
			return dtoRetorno;
		}
		if (itemDTO.getTurno().getDsTurno().trim().equals("")) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DS_INVALIDA());
			return dtoRetorno;
		}

		boolean isInclusao = false;

		String hql = "";

		hql = "from DwTurno t where t.idTurno = ::idTurno ";
		hql = hql.replaceAll("::idTurno", String.valueOf(itemDTO.getTurno().getIdTurno()));

		Query q = getDaoSession().createQuery(hql);

		DwTurno itemOriginal = (DwTurno) q.uniqueResult();


		if (itemOriginal != null && itemOriginal.getIdTurno() > 0 && itemOriginal.getStAtivo().equals((byte)0)) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_REATIVACAO_INDISPONIVEL());
			return dtoRetorno;
		}



		DwTurno itemAlteracao = null;

		if (itemOriginal == null) {
			itemOriginal = itemDTO.getTurno().clone();
			itemOriginal.setRevisao(1l);
			itemOriginal.setDtRevisao(new Date());
			itemOriginal.setStAtivo((byte) 1);
			itemOriginal.setDtStativo(new Date());
			isInclusao = true;

			// Verifica se o codigo + revisao ja existe no banco, se exitir
			// retornar ao cliente a excessao
			hql = "";

			hql += "from DwTurno t ";
			hql += "where t.cdTurno = '::cdTurno' ";
			hql += "and t.stAtivo = 1 ";

			hql = hql.replaceAll("::cdTurno", itemOriginal.getCdTurno());
			q = getDaoSession().createQuery(hql);

			if (q.list().size() > 0) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_TURNO_JA_EXISTE());
				return dtoRetorno;
			}
		} else {
			itemAlteracao = itemOriginal.clone();
			itemAlteracao.setDtRevisao(new Date());
			itemAlteracao.setStAtivo((byte) 0);
			itemAlteracao.setIdTurno(0);

			// Limpa os ids de itemAlteracao.OmProturno
			for (OmProturno pojo : itemAlteracao.getOmProturnos()){
				pojo.setIdOmproturno(null);
				pojo.setDwTurno(itemAlteracao);
			}
			// Apagar os produto no turno para poder incluir novamente
			for (Iterator<OmProturno> iterator = itemOriginal.getOmProturnos().iterator(); iterator.hasNext();) {
				OmProturno itemOmProturno = iterator.next();
				this.getDaoSession().delete(itemOmProturno);
				iterator.remove();
			}

			// pesquisa novamente para efetivar a delecao acima
			itemOriginal = (DwTurno) q.uniqueResult();
			itemOriginal.setDsTurno(itemDTO.getTurno().getDsTurno());
			itemOriginal.setCor(itemDTO.getTurno().getCor());
			itemOriginal.setIsImprodutivo(itemDTO.getTurno().getIsImprodutivo());
		}


		itemOriginal.setOmProturnos(new HashSet<OmProturno>());

		ProdutoRN prn = new ProdutoRN(getDao());

		for (OmProturno omproturno: itemDTO.getTurno().getOmProturnos()){
		    OmProturno pojo = new OmProturno();

			pojo.setIdOmproturno(null);
			pojo.setDwTurno(itemOriginal);
			pojo.setTpRelacao(omproturno.getTpRelacao());

			OmProduto omproduto = new OmProduto();
			omproduto = prn.getProdutoByCdEStAtivo(omproturno.getOmProduto().getCdProduto());

			if (omproduto == null){
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
				return dtoRetorno;
			}

			pojo.setOmProduto(omproduto);

			itemOriginal.getOmProturnos().add(pojo);
		}

		// Somente apos pesquisar se a nova revisao ja existe é que o pojo
		// original deve ter a revisao somada, se for antes,
		// a pesquisa acima ira trazer o pojo somado
		if (isInclusao == false) {
			itemOriginal.setRevisao(itemOriginal.getRevisao() + 1);

		}

		try {
			hql = "from OmUsr t where t.cdUsr = '::cdUsr' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idUsr ";

			hql = hql.replaceAll("::cdUsr", itemDTO.getTurno()
					.getOmUsrByIdUsrrevisao().getCdUsr());

			q = getDaoSession().createQuery(hql);

			OmUsr omUsrRevisao = (OmUsr) q.list().get(0);

			itemOriginal.setOmUsrByIdUsrrevisao(omUsrRevisao);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno
					.getERRO_USUARIO_REVISAO_DESCONHECIDO());
			e.printStackTrace();
		}

		try {
			hql = "from OmUsr t where t.cdUsr = '::cdUsr' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idUsr ";
			hql = hql.replaceAll("::cdUsr", itemDTO.getTurno().getOmUsrByIdUsrstativo().getCdUsr());

			q = getDaoSession().createQuery(hql);

			OmUsr omUsrStAtivo = (OmUsr) q.list().get(0);

			itemOriginal.setOmUsrByIdUsrstativo(omUsrStAtivo);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
			e.printStackTrace();
		}

		if (dtoRetorno.getResultadoEvento() == dtoRetorno.getEVENTO_BEM_SUCEDIDO()) {
			try {
				itemOriginal = getDao().makePersistent(itemOriginal);
				if (itemAlteracao != null) {
					getDao().makePersistent(itemAlteracao);
				}
			} catch (Exception e) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
				e.printStackTrace();
			}

			dtoRetorno.setTurno(itemOriginal.clone());

		}

		return dtoRetorno;
	}


	public TurnosDTO removeTurnosDTO(TurnosDTO itensDTO) {

		List<TurnoDTO> listaRetorno = new ArrayList<TurnoDTO>();
		for (TurnoDTO item : itensDTO.getTurnos()) {
			TurnoDTO itemRetorno = new TurnoDTO();
			String hql = "";

			hql = "from DwTurno t where t.idTurno = ::idTurno";
			hql = hql.replaceAll("::idTurno", String.valueOf(item.getTurno()
					.getIdTurno()));

			Query q = getDaoSession().createQuery(hql);

			DwTurno itemOriginal = (DwTurno) q.uniqueResult();

			if (itemOriginal == null) {
				itemRetorno.setResultadoEvento(itemRetorno
						.getERRO_CDTURNO_INVALIDO());
				itemRetorno.setTurno(item.getTurno());
			} else if (itemOriginal.getStAtivo() == 0) {
				itemRetorno.setResultadoEvento(itemRetorno
						.getERRO_CDTURNO_INVALIDO());
				itemRetorno.setTurno(itemOriginal.clone());
			} else {
				itemOriginal.setStAtivo((byte) 0);
				itemOriginal.setDtStativo(new Date());

				try {
					itemOriginal = getDao().makePersistent(itemOriginal);
				} catch (Exception e) {
					e.printStackTrace();
				}

				itemRetorno.setTurno(itemOriginal.clone());

				itemRetorno.setResultadoEvento(0);
			}

			listaRetorno.add(itemRetorno);
		}

		TurnosDTO itensRetorno = new TurnosDTO();
		itensRetorno.setTurnos(listaRetorno);
		return itensRetorno;
	}

	public TurnoDTO ativaTurnoDTO(TurnoDTO itemDTO) {
		TurnoDTO itemRetorno = new TurnoDTO();
		String hql = "";

		// Verifica se a revisao que está sendo reativada é a maior para o
		// codigo
		hql = "";

		hql += "from DwTurno t ";
		hql += "where t.cdTurno = '::cdTurno' ";
		hql += "and t.revisao > ::revisao ";

		hql = hql.replaceAll("::cdTurno", itemDTO.getTurno().getCdTurno());
		hql = hql.replaceAll("::revisao", String.valueOf((itemDTO.getTurno()
				.getRevisao())));
		Query qRev = getDaoSession().createQuery(hql);

		if (qRev.list().size() > 0) {
			itemRetorno.setResultadoEvento(itemRetorno
					.getERRO_REATIVACAO_INDISPONIVEL());
			return itemRetorno;
		}

		hql = "from DwTurno t where t.idTurno = ::idTurno";
		hql = hql.replaceAll("::idTurno", String.valueOf(itemDTO.getTurno()
				.getIdTurno()));

		Query q = getDaoSession().createQuery(hql);

		DwTurno itemOriginal = (DwTurno) q.uniqueResult();

		if (itemOriginal == null) {
			itemRetorno.setResultadoEvento(itemRetorno
					.getERRO_CDTURNO_INVALIDO());
			itemRetorno.setTurno(itemDTO.getTurno());
			return itemRetorno;
		} else if (itemOriginal.getStAtivo() == 1) {
			itemRetorno.setResultadoEvento(itemRetorno
					.getERRO_CDTURNO_INVALIDO());
			itemRetorno.setTurno(itemOriginal.clone());
		} else {
			itemOriginal.setStAtivo((byte) 1);
			itemOriginal.setDtStativo(new Date());
		}

		try {
			itemOriginal = getDao().makePersistent(itemOriginal);
		} catch (Exception e) {
			e.printStackTrace();
		}

		itemRetorno.setTurno(itemOriginal.clone());

		return itemRetorno;
	}

	/**
	 * Esse metodo tem como objetivo encontrar qual o turno do Pt em determinada data e hora
	 */
	public TurnoAtualDTO getTurnoAtualDTOComClone(OmPt ompt, Date dtHrAtual){

		TurnoAtualDTO retorno = new TurnoAtualDTO();

		try {

			retorno = getTurnoAtualDTOSemClone(ompt, dtHrAtual); //obtemTurnoAtual(ompt, dtHrAtual, null, 0, 0, omcfg);
			if(retorno != null){
				retorno = retorno.prepararSerializacao();
			}

		} catch (Exception  e) {
			e.printStackTrace();
		}

		return retorno;
	}



	/**
	 * Retorna o total do tempo do calendário semanal em segundos
	 * @param lista
	 * @return
	 */
	private BigDecimal tempoTotalCalendario(List<DwCalsem> lista){
		BigDecimal totalSegCalendario = BigDecimal.ZERO;

		// calcula quantidade de segundos do calendário
		for(DwCalsem dwCalsem: lista){
			// Calcula tempo do calendário
			// Tempos de tolerancia est�o em minutos
			totalSegCalendario =  totalSegCalendario
					.add(ObjectUtils.defaultIfNull(dwCalsem.getSegTempocalendario(), BigDecimal.ZERO));
//					.add(dwCalsem.getSegToleranciapreEmSeg()) Alessandre em 13-05-22 comentei a adicao das tolerancias pois 
//					.add(dwCalsem.getSegToleranciaposEmSeg()); o calendario semanal estava com um tempo superior ao limite real
		}
		return totalSegCalendario;
	}

	/**
	 * Pega calendário semanal 24/7 do posto de trabalho
	 * Alessandre: Esse metodo deve considerar a data de referencia atual pq eh usado na monitorizacao
	 * de uma data passada. Alem disso, um evento antigo de msevt deve considerar o calendario da epoca em que o evento foi gerado
	 * @see TurnoRN#getCalendarioIndefinido()
	 * @see TurnoRN#getDwCalPtOuDefault(Long)
	 * @param idPt
	 * @return
	 * @throws SemCalendarioException se n�o encontrar calendário semanal (DwCalsem) para o posto de trabalho
	 */
	public List<DwCalsem> getCalendarioSemanalComTurnosIndefinidosParaPt(OmPt ompt, Date dthrReferencia) throws SemCalendarioException{
		try{
			DwCal dwcal = getDwCalPtOuDefault(ompt, dthrReferencia);
			return getCalendarioSemanalComTurnosIndefinidos(dwcal.getIdCal());
		}catch(SemCalendarioException e){
			throw new SemCalendarioException(e.getMessage() + ". Para o idPt " + ompt.getIdPt());
		}
	}
	
	
	
	
	public static void main(String[] args) {
		IdwLogger log = new IdwLogger("teste");
		int idLog = log.getIdAleatorio();
		int identacao = 0;
		
		TurnoRN rn = new TurnoRN();
		rn.iniciaConexaoBanco();
		
		/*
		OmPt omPt = null;
		try {
			omPt = rn.getDao().findByCd(OmPt.class, "NXTL12", "cdPt", true);
		} catch (RegistroDesconhecidoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date dthr = DataHoraRN.getDataHora(2019, 12, 6, 7, 0, 0, 620);
		Date iniCiclo = DataHoraRN.getDataHora(2019, 12, 5, 16, 31, 45, 170);
		Date fimCiclo = DataHoraRN.getDataHora(2019, 12, 6, 7, 0, 0, 620);
		List<DwCalsem> dwCalsems = null;
		try {
			dwCalsems = rn.getCalendarioSemanalComTurnosIndefinidosParaPt(omPt, dthr);
		} catch (SemCalendarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		List<TurnoAtualDTO> turnos = rn.getTurnoAtualDTOsPeriodo(dwCalsems, iniCiclo, fimCiclo, log, idLog, identacao);
		
		
		for (TurnoAtualDTO t : turnos) {
			System.out.println(t.toString());
		}
		*/
		
		
		
		List<DwCalsem> lista;
		try {
			lista = rn.getCalendarioSemanalComTurnosIndefinidos(104l);
		} catch (SemCalendarioException e) {
			lista = new ArrayList<>();
		}
		
		for (DwCalsem sem : lista) {
			System.out.println(sem.toString());
		}
		rn.finalizaConexaoBanco();
	}
	

	
	

	/**
	 * Pega calendário semanal, nos espaços que nao tiver horário, complementa com o calendário e turno indefinido
	 * <br> Dias da semana começam com o id 0
	 * @param idCal
	 * @return calendário semanal 24/7
	 * @throws SemCalendarioException  se calendário semanal n�o for encontrado para o {@code idCal}
	 */
	public List<DwCalsem> getCalendarioSemanalComTurnosIndefinidos(long idCal) throws SemCalendarioException{

		final BigDecimal segundosSemana = new BigDecimal(DataHoraRN.SEG_SEMANA); // 604800

		// Pega calendário semanal na ordem de dia, hrInicial
		List<DwCalsem> lista = this.getDwCalsems(idCal);

		if(lista == null || lista.isEmpty()){
			throw new SemCalendarioException("Calendario semanal (DwCalsem) n�o encontrado para o idCal = " + idCal);
		}

		BigDecimal totalSegCalendario = tempoTotalCalendario(lista);

		int compare = totalSegCalendario.compareTo(segundosSemana);

		// se o calendário semanal estiver completo, nao precisa procurar espaço vazio
		// semana tem 604800 segundos = (3600 * 24 * 7)
		if(compare == 0){
			return lista;
		}

		// Segundos do calendários semanal n�o devem estar ultrapassando o total se segundos da semana
		Validate.validState(compare <= 0,
				"Total de segundos da semana inválido. Calendário semanal (idcal=%s; totalSeg=%s) está ultrapassando o total de segundos da semana (%s)",
				idCal, totalSegCalendario.toString(), DataHoraRN.SEG_SEMANA);


		// Pega instancia do turno indefinido
		DwTurno dwTurnoIndefinido = this.getTurnoIndefinido();

		// Pega calendário indefinido
		DwCal dwCalIndefinido = this.getCalendarioIndefinido();

		// Guarda último como item anterior
		DwCalsem dwCalsemAnterior = lista.get(lista.size() -1);
		List<DwCalsem> listaTurnoIndefinido = new ArrayList<>();

		// Procura espaço vazio entre os horário, inclusive entre dias diferentes, e insere na colecao de períodos com turnos indefinidos.
		// Lista deve estar em ordem crescente em: dia e hrInicial
		// Guarda hora final do período anterior (
		BigDecimal hrFinalAnterior = null;
		
//		System.out.println(dwCalsemAnterior);
//		System.out.println("#################");
		
		boolean isIgnorarPrimeiroTempoVazio = true;

		for(DwCalsem dwCalsem : lista){
			
//			System.out.println(dwCalsem);
			
			
			
			
			
			// hrFinalAnterior sera null na primeira vez a interação for executada
			// Nessa situacao avaliar se existe a necessidade de incluir o calendario indefinido entre o domingo e o 1o dia do calendario
			// Esse trecho sera executado apenas a 1a vez
			if (hrFinalAnterior == null) {
				
				// Entre o final do calendario e o 1o avaliar se existem horario vagos e adicionar
				List<DwCalsem> listaIndefinidosInicioCal = getHorariosIndefinidos(dwCalsemAnterior, dwCalsem, dwTurnoIndefinido, dwCalIndefinido);
				if (listaIndefinidosInicioCal.isEmpty() == false) {
//					for (DwCalsem aux : listaIndefinidosInicioCal) {
//						System.out.println("add " + aux);
//					}
					listaTurnoIndefinido.addAll(listaIndefinidosInicioCal);
				}
				
				
				
				hrFinalAnterior = dwCalsem.getHrFinalComTolerancia(); // dwCalsemAnterior.getHrFinalComTolerancia();
				continue;
			}
			
			
			
			

			
			
			
			
			

			// Guarda hora inicial do período atual
			// o ajuste do horário é feito até esta hora inicial
			BigDecimal hrInicialProximo = dwCalsem.getHrInicialComTolerancia();

			// era aqui
			
			// se hora final do item anterior for diferente de hora inicial do item atual
			// indica que há buraco no calendário
			boolean isPossuiTempoVazio = 
							hrFinalAnterior.compareTo(hrInicialProximo) != 0 ||
							dwCalsemAnterior.getDiasemana().intValue() != dwCalsem.getDiasemana().intValue();
			
			if(isIgnorarPrimeiroTempoVazio) {
				isIgnorarPrimeiroTempoVazio = false;
				isPossuiTempoVazio = false;
			}
			
//			System.out.println("isPossuiTempoVazio:"+isPossuiTempoVazio + " | hrFinalAnterior:" +hrFinalAnterior + "| hrInicialProximo:" + hrInicialProximo + "| diaAnterior:" + dwCalsemAnterior.getDiasemana().intValue() + "| dia:" + dwCalsem.getDiasemana().intValue() + "\n");
			// Se existir GAP entre o calsem atual e o anterior, entao preencher com o calendario indefinido
			if(isPossuiTempoVazio){
				// aqui devemos inserir o turno indefinido desde o dia anterior (se for o caso) ate o dia atual
				// se dwcalsemanterior estiver em um dia anterior entao interagir desde esse dia ate o dia atual
				// Nova instancia com o calendário/turno indefinido, para o buraco na linha do tempo
				DwCalsem dwCalsemIndefinido = null;
				if (dwCalsem.getDiasemana().equals(dwCalsemAnterior.getDiasemana()) == false) {
					// Se for dias diferentes mas se for o dia seguintes e o final do anterior for 24 e o inicio 0, entao ignorar
					int diaSemanaAnterior = dwCalsemAnterior.getDiasemana().intValue();
					int diaSemanaAtual = dwCalsem.getDiasemana().intValue();
					if ( (diaSemanaAnterior + 1) == diaSemanaAtual && dwCalsemAnterior.getHrFinal().intValue() == 86400 && dwCalsem.getHrInicial().intValue() == 0) {
						// ignora pois estao na sequencia
					} else {
						List<DwCalsem> listaIndefinidosInicioCal = getHorariosIndefinidos(dwCalsemAnterior, dwCalsem, dwTurnoIndefinido, dwCalIndefinido);
						if (listaIndefinidosInicioCal.isEmpty() == false) {
//							for (DwCalsem aux : listaIndefinidosInicioCal) {
//								System.out.println("add2 " + aux);
//							}
							listaTurnoIndefinido.addAll(listaIndefinidosInicioCal);
						}
					}
				} else {
					dwCalsemIndefinido = DwCalsemTemplate.newInstance(dwTurnoIndefinido, dwCalIndefinido, dwCalsem.getDiasemana(),
							hrFinalAnterior, hrInicialProximo, hrInicialProximo.subtract(hrFinalAnterior),
							DwCalsemTemplate.TpDtReferencia.DT_REF_MESMO_DIA, true, true);

//					System.out.println("add3 " + dwCalsemIndefinido);

					// Adiciona na lista de turnos indefinidos
					listaTurnoIndefinido.add(dwCalsemIndefinido);

				}
				
			}

			
			
			
			
			
			// guarda item para ser usado como referencia de item anterior
			//dwCalsemAnterior = dwCalsem;
			hrFinalAnterior = dwCalsem.getHrFinalComTolerancia();
			dwCalsemAnterior = dwCalsem;

			// Nao pode haver um delay
//			UtilsThreads.pausaNaThread(10l);
		}
		
		
		
		/* Apos processar todo o calendario pode acontecer do ultimo turno na semana definido pelo usuario terminar as 24h de qualquer dia. Nesse caso, devemos preencher
		 * os horarios que faltam até chegar ao dia de sabado para termos todos os GAPs preenchidos com o turno indefinido
		 */
		if (	dwCalsemAnterior.getDiasemana().compareTo(DiaSemana.SABADO.getId()) < 0 ||
				(dwCalsemAnterior.getDiasemana().compareTo(DiaSemana.SABADO.getId()) == 0 && dwCalsemAnterior.getHrFinal().compareTo(new BigDecimal(86400)) < 0)
				) {

			List<DwCalsem> calsemindef = new ArrayList<>(dwCalIndefinido.getDwCalsems());
			Collections.sort(calsemindef, new Comparator<DwCalsem>() {
				@Override
				public int compare(DwCalsem o1, DwCalsem o2) {
					int retorno = o1.getDiasemana().compareTo(o2.getDiasemana());
					if (retorno == 0)
						retorno = o1.getHrInicial().compareTo(o2.getHrInicial());
					return retorno;
				}
			});

			DwCalsem dwCalsemUltimoIndefinido = calsemindef.get(calsemindef.size() -1);
			
//			System.out.println("ultimo calsem usuario= " + dwCalsemAnterior);
//			System.out.println("ultimo calsem indefin= " + dwCalsemUltimoIndefinido);
			List<DwCalsem> listaIndefinidosInicioCal = getHorariosIndefinidos2(dwCalsemAnterior, dwCalsemUltimoIndefinido, dwTurnoIndefinido, dwCalIndefinido);
			if (listaIndefinidosInicioCal.isEmpty() == false) {
				
				// Se ja existir nao devemos mais incluir
				for (DwCalsem aux : listaIndefinidosInicioCal) {
					boolean isExiste = false;
					for (DwCalsem aux2 : listaTurnoIndefinido) {
						if (aux.getDiasemana().compareTo(aux2.getDiasemana()) == 0 && aux.getHrInicial().compareTo(aux2.getHrInicial()) == 0) {
							isExiste = true;
							break;
						} 
//						else
//							System.out.println("...................." + aux);
						
					}
					if (isExiste == false)
						listaTurnoIndefinido.add(aux);
				}

			}
			
			
			
			
		}
		
		
		
		
		
		
		
//		System.out.println("#################");

		// Adiciona turnos indefinidos no calendário semanal
		lista.addAll(listaTurnoIndefinido);

		// Ordena lista para que os itens do calendário indefinido fiquem na ordem na cole��oo (diasemana e hrInicial)
		Collections.sort(lista, new Comparator<DwCalsem>() {
			@Override
			public int compare(DwCalsem o1, DwCalsem o2) {
				int retorno = o1.getDiasemana().compareTo(o2.getDiasemana());
				if (retorno == 0)
					retorno = o1.getHrInicial().compareTo(o2.getHrInicial());
				return retorno;
			}
		});

		// Calendário semanal deverá ficar completo. Com o total de 604800 segundos
		totalSegCalendario = tempoTotalCalendario(lista);
		compare = totalSegCalendario.compareTo(segundosSemana);


		// Segundos do calendários semanal deve ser igual a quantidade de segundos da semana
		if(compare > 0){
			String error = String.format("Total de segundos da semana invalido. Calendario semanal (idcal=%s totalSeg=%s) esta ultrapassando o total de segundos da semana (%s) \n %s",
					idCal, 
					totalSegCalendario.toString(), 
					DataHoraRN.SEG_SEMANA, 
					DwCalsemTemplate.dwCalsemsToString(lista));
//			System.out.println(error);
			throw new IllegalStateException(error);
		}
		
		return lista;
	}
	
	/* Retorna uma lista de horarios do turno indefinido entre dwCalanterior e dwcalsem
	 * 
	 */
	private List<DwCalsem> getHorariosIndefinidos(DwCalsem dwCalsemAnterior, DwCalsem dwCalsem, DwTurno dwTurnoIndefinido, DwCal dwCalIndefinido) {
		List<DwCalsem> retorno = new ArrayList<>();
		
		/* dwCalsemAnterior.diaSemana poderá ser maior ou menor que dwCalsem.diaSemana.
		 * Quando for maior é pq está sendo avaliado o 1o horario dos turnos da semana.
		 * Quando for menor é pq se está avaliando um horario apos o inicio e antes do final do calendario.
		 * Tambem nao existirao outros dwCalsem entre DwCalsemAnterior e DwCalSem
		 */
		BigDecimal diaSemanaAnterior = dwCalsemAnterior.getDiasemana(); 
		if (diaSemanaAnterior.compareTo(dwCalsem.getDiasemana()) > 0) {
			// Se o dia da semana for maior então devemos criar um DwCalsem para cada dia entre eles
			BigDecimal horaInicial = dwCalsemAnterior.getHrFinalComTolerancia();
			BigDecimal horaFinal = new BigDecimal(24 * 3600);
			for (int diaSemana = diaSemanaAnterior.intValue() ; diaSemana <= 6; diaSemana++) {
				// Se a hora inicial for igual a hora final, então não se deve fazer nada e descartar
				if (horaInicial.compareTo(horaFinal) != 0) {
					DwCalsem dwCalsemIndefinido = DwCalsemTemplate.newInstance(
							dwTurnoIndefinido, 
							dwCalIndefinido, 
							new BigDecimal(diaSemana),
							horaInicial, 
							horaFinal, 
							horaFinal.subtract(horaInicial),
							DwCalsemTemplate.TpDtReferencia.DT_REF_MESMO_DIA, true, true);
					horaInicial = BigDecimal.ZERO; // a partir do 2o dia a hora inicial eh 0h;
					retorno.add(dwCalsemIndefinido);
//					System.out.println("add " + dwCalsemIndefinido);
					dwCalsemAnterior = dwCalsemIndefinido;
				}
				// nao pode haver um delay
//				UtilsThreads.pausaNaThread(10l);
			}
			diaSemanaAnterior = BigDecimal.ZERO; // Apos finalizar até o final da semana, iniciar no 1o dia da semana
		}
		
		// Nesse ponto dwCalsemAnterior.diaSemana deve ser menor ou igual a dwCalsem.diaSemana
//		System.out.println("calanterior = " + dwCalsemAnterior);
		BigDecimal horaInicial = dwCalsemAnterior.getHrFinalComTolerancia();
		BigDecimal horaFinal = new BigDecimal(24 * 3600);
		if (horaInicial.compareTo(new BigDecimal(86400)) == 0) {
			horaInicial = BigDecimal.ZERO;
		}
		for (int diaSemana = diaSemanaAnterior.intValue() ; diaSemana <= dwCalsem.getDiasemana().intValue(); diaSemana++) {
			// Se estiver no dia da semana de dwCalsem é pq se chegou ao dia desejado para insersao dos turnos indefinidos, entao considerar o final como sendo o inicio do turno de dwcalsem
			if (diaSemana == dwCalsem.getDiasemana().intValue()) {
				horaFinal = dwCalsem.getHrInicialComTolerancia();
			}
			// Se a horaFinal ficou maior que a inicial, entao a inicial pode ser 0
			if (horaFinal.compareTo(horaInicial) < 0)
				horaInicial = BigDecimal.ZERO;
			
			/* Se a hora inicial e final forem iguais entao não se deve gerar um calendario indefinido
			 * 
			 */
			if (horaInicial.compareTo(horaFinal) != 0) {
				DwCalsem dwCalsemIndefinido = DwCalsemTemplate.newInstance(
						dwTurnoIndefinido, 
						dwCalIndefinido, 
						new BigDecimal(diaSemana),
						horaInicial, 
						horaFinal, 
						horaFinal.subtract(horaInicial),
						DwCalsemTemplate.TpDtReferencia.DT_REF_MESMO_DIA, true, true);
				retorno.add(dwCalsemIndefinido);
			}
			horaInicial = BigDecimal.ZERO; // a partir do 2o dia a hora inicial eh 0h;
//			System.out.println("add2=" + dwCalsemIndefinido);
		}
		
		
		return retorno;
	}


	
	/* Alessandre em 07-08-18 copiei o metodo acima com outro nnome pois o algoritmo acima funciona de  onde esta sendo chamado, mas nao em determinada situacao
	 * o metodo abaixo esta sendo usado para avaliar essa situracaoo
	 */
	private List<DwCalsem> getHorariosIndefinidos2(DwCalsem dwCalsemAnterior, DwCalsem dwCalsem, DwTurno dwTurnoIndefinido, DwCal dwCalIndefinido) {
		List<DwCalsem> retorno = new ArrayList<>();
		
		BigDecimal diaSemanaAnterior = dwCalsemAnterior.getDiasemana();
		BigDecimal horaInicial = dwCalsemAnterior.getHrFinalComTolerancia();
		if (horaInicial.compareTo(new BigDecimal(86400)) == 0) {
			horaInicial = BigDecimal.ZERO;
			diaSemanaAnterior = diaSemanaAnterior.add(BigDecimal.ONE);
		}
		

		for (int diaSemana = diaSemanaAnterior.intValue() ; diaSemana <= dwCalsem.getDiasemana().intValue(); diaSemana++) {
			
			BigDecimal horaFinal = new BigDecimal(24 * 3600);

			if (diaSemana == dwCalsem.getDiasemana().intValue()) {
				horaFinal = dwCalsem.getHrInicialComTolerancia();
				// Se a hora final for 0 entao transforma-la para 24h
				if (horaFinal.compareTo(BigDecimal.ZERO) == 0) {
					horaFinal = new BigDecimal(24 * 3600);
				}
			}

			
			
			if (horaInicial.compareTo(horaFinal) != 0) {
				DwCalsem dwCalsemIndefinido = DwCalsemTemplate.newInstance(
						dwTurnoIndefinido, 
						dwCalIndefinido, 
						new BigDecimal(diaSemana),
						horaInicial, 
						horaFinal, 
						horaFinal.subtract(horaInicial),
						DwCalsemTemplate.TpDtReferencia.DT_REF_MESMO_DIA, true, true);
				retorno.add(dwCalsemIndefinido);
			}
			horaInicial = BigDecimal.ZERO; // a partir do 2o dia a hora inicial eh 0h;
		}
		
		
		return retorno;
	}

	
	
	
	
	
	
	
	/**
	 * Pegar os turnos do período
	 * @param dwCalsems Calendário 24/7 {@link TurnoRN#getCalendarioSemanalComTurnosIndefinidos(long)}
	 * @param dtHrI
	 * @param dtHrF
	 * @return
	 */
	public List<TurnoAtualDTO> getTurnoAtualDTOsPeriodo(List<DwCalsem> dwCalsems, Date dtHrI, Date dtHrF){
		return getTurnoAtualDTOsPeriodo(dwCalsems, dtHrI, dtHrF, null, 0, 0);
	}

	public List<TurnoAtualDTO> getTurnoAtualDTOsPeriodo(OmPt omPt, Date dtHrI, Date dtHrF) throws SemCalendarioException {
		List<DwCalsem> dwCalsems = getCalendarioSemanalComTurnosIndefinidosParaPt(omPt, dtHrF);
		return getTurnoAtualDTOsPeriodo(dwCalsems, dtHrI, dtHrF);
	}

	public TurnoAtualDTO getTurnoAtualDTO(OmPt omPt, Date dtHr) throws SemCalendarioException {
		List<TurnoAtualDTO> turnos = getTurnoAtualDTOsPeriodo(omPt, dtHr, dtHr);
		if (turnos.isEmpty()) {
			return null;
		} else {
			return turnos.iterator().next();
		}
	}

	public List<TurnoAtualDTO> getTurnoAtualDTOsPeriodoComClone(OmPt omPt, Date dtHrI, Date dtHrF) throws SemCalendarioException {
		List<TurnoAtualDTO> turnos = getTurnoAtualDTOsPeriodo(omPt, dtHrI, dtHrF);
		List<TurnoAtualDTO> turnosClonados = new ArrayList<TurnoAtualDTO>();
		for (TurnoAtualDTO turnoAtualDTO : turnos) {
			turnosClonados.add(turnoAtualDTO.clone());
		}
		return turnosClonados;
	}
	

	public List<TurnoAtualDTO> getTurnoAtualDTOsPeriodo(List<DwCalsem> dwCalsems, Date dtHrI, Date dtHrF, IdwLogger log, int idLog, int identacao){
		Validate.notNull(dtHrI, "Inicio deve ser preenchido");
		Validate.notNull(dtHrF, "Fim deve ser preenchido");
		Validate.isTrue(DataHoraRN.compareTo(dtHrI, dtHrF) <= 0, "Inicio (%s) nao pode ser maior que fim (%s)", DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtHrI), DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtHrF) );

		List<TurnoAtualDTO> listTurnos =  new ArrayList<>();

		Date dtHrRef = dtHrI;
		TurnoAtualDTO turno = null;
		
		if (log != null) {
			log.iniciaAvaliacao(idLog, "getTurnoAtualDTOsPeriodo");
			log.info(idLog, identacao, "entrando no loop de getTurnoAtualDTOsPeriodo");
		}
		
		do{
			turno = getTurnoAtualDTO(dwCalsems, dtHrRef);

			dtHrRef = turno.getDtHrFTurnoComTolerancia();
			//Joga um segundo para pegar proximo turno
			// Alessandre em 11-12-19 alterei para 1 mili pois ocorreu um evento as 07:00;00:620 e nao pegou o turno correto, ficou no turno anterior
			dtHrRef = DataHoraRN.adicionaMilisegundosNaData(dtHrRef, 1);

			listTurnos.add(turno);

			// Alessandre em 25-06-19 comentei a linha abaixo para avaliar se eh o SO que está demorando para liberar a continuidade da thread
			//UtilsThreads.pausaNaThread(5l);

		}while(DataHoraRN.before(dtHrRef, dtHrF));

		if (log != null) {
			log.mostrarAvaliacaoCompleta(idLog, identacao);
			log.info(idLog, identacao, "saindo do loop");
		}
		
		
		try {
			if (log != null && listTurnos != null && listTurnos.size() > 0)
				log.info(idLog, identacao, listTurnos.size() + " TurnoAtualDTOs de " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(listTurnos.get(0).getDtHrITurno()) + " ate " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(listTurnos.get(listTurnos.size()-1).getDtHrFTurno()));
		} catch (Exception e) {
		}

		return listTurnos;

	}

	/**
	 * Pega turno atual da data/hora {@code dtHrAtual} se baseando no calendário semanal (24/7) que tem calendário e turno indefinido preenchendo periodos da semana sem turno.
	 * <br>Turno com os dados de início e fim definidos baseados em {@code dtHrAtual}
	 * @param dwCalsems
	 * @param dtHrAtual
	 * @return
	 */
	public TurnoAtualDTO getTurnoAtualDTO(List<DwCalsem> dwCalsems, Date dtHrAtual){

		// Encontra periodo em que a dtHrAtual pertence
		DwCalsem dwCalsem = getDwCalsemPassandoDtHrAtual(dwCalsems, dtHrAtual);

		// Instancia dados do turno atual
		TurnoAtualDTO turnoAtualDTO = getTurnoAtualDTO(dwCalsem, dtHrAtual, dwCalsems);

		// Seta os parametros de duracao produtiva e impordutiva do DTO
		BigDecimal duracaoProdutiva = BigDecimal.ZERO;
		BigDecimal duracaoImprodutiva = BigDecimal.ZERO;
		
		// Ordenar para facilitar o encontro do proximo turno
		Collections.sort(dwCalsems, new Comparator<DwCalsem>() {
			@Override
			public int compare(DwCalsem o1, DwCalsem o2) {
				int retorno = o1.getDiasemana().compareTo(o2.getDiasemana());
				if (retorno == 0)
					retorno = o1.getHrInicial().compareTo(o2.getHrInicial());
				return retorno;
			}
		});
		
		
		for (DwCalsem semanal : dwCalsems) {
			BigDecimal diaSemana = semanal.getDiasemana();
			
			// Se o tipo da data de referencia for "PERTENCE AO DIA ANTERIRO", então iremos subtrair do dia da semana do calendario avaliado para poder pegar o tempo correto
			if (semanal.getTpDtreferencia().equals(DwCalsemTemplate.TpDtReferencia.DT_REF_DIA_ANTERIOR.getId())) {
				// Se o dia da semana já for 1 = DOMINGO, entao voltar para SABADO
				if (diaSemana.compareTo(BigDecimal.ZERO) == 0)
					diaSemana = new BigDecimal(6);
				else {
					diaSemana = diaSemana.subtract(BigDecimal.ONE);
				}
			}
			if (
					dwCalsem.getDiasemana().compareTo(diaSemana) == 0 && 
					semanal.getDwCal().getIdCal() == dwCalsem.getDwCal().getIdCal() && 
					semanal.getDwTurno().getIdTurno() == dwCalsem.getDwTurno().getIdTurno()) {

				// Se o tempo do calendario tiver sido definido entao somar na duracaoProdutiva
				if (semanal.getSegTempocalendario() != null)
					duracaoProdutiva = duracaoProdutiva.add(semanal.getSegTempocalendario());
				
				// Se o tempo improdutivo tiver sido informado, entao subtratir do tempo produtivo
				if (semanal.getSegTempocalsempeso() != null) {
					// SegTempocalsempeso esta salvo em minutos, entao converter
					// o correto seria o cadastro do calendario pedir na GUI em minutos e salvar em seg
					BigDecimal sempeso = semanal.getSegTempocalsempeso();
					sempeso = sempeso.multiply(new BigDecimal(60));
					duracaoProdutiva = duracaoProdutiva.subtract(sempeso);
					duracaoImprodutiva = duracaoImprodutiva.add(sempeso);
				}
			}
			// Nao pode haver um delay senao degrada a performance do algoritmo inviabilizando a consolidacao
//			UtilsThreads.pausaNaThread(10l);
		}
		turnoAtualDTO.setSegDuracaoProdutiva(duracaoProdutiva);
		turnoAtualDTO.setSegDuracaoImprodutiva(duracaoImprodutiva);

		return turnoAtualDTO;
	}
	/**
	 * Pega o turno atual para o posto de trabalho
	 * @param idPt - id do pt para buscar a lista do calendário
	 * @param dtHrAtual
	 * @return
	 * @throws SemCalendarioException
	 */
	public TurnoAtualDTO getTurnoAtualDTOSemClone(OmPt ompt, Date dtHrAtual) throws SemCalendarioException{

		List<DwCalsem> dwCalsems = getCalendarioSemanalComTurnosIndefinidosParaPt(ompt, dtHrAtual);

		return getTurnoAtualDTO(dwCalsems, dtHrAtual);

	}

	/**
	 * Pega o Turno Atual para um GT
	 * @param omGt
	 * @return
	 * @throws SemCalendarioException
	 */
	public TurnoAtualDTO getTurnoAtualGtDTO(OmGt omGt, Date dataAtual, boolean isTestarGTsFilho) throws SemCalendarioException{

		MonitorizacaoRN monitorizacaoRN = new MonitorizacaoRN(this.getDao());
		ObjsDTO objsDTO = monitorizacaoRN.getObjsDTO(null, omGt.getIdGt(), null, false);
		OmPt pt = null;
		TurnoAtualDTO retorno = null;

		// 1o tentar encontrar o turno atual com base no 1o PT. Se nao encontrar entao se basear nos gts
		for(ObjDTO obj : objsDTO.getObjs()){
			if(obj.getObj().getTpObj().equals(obj.getObj().getTIPO_OBJ_PT())) {
				pt = obj.getObj().getOmPt();
				if (pt.getStAtivo().equals('0') == false) {
					try {
						retorno = getTurnoAtualDTOSemClone(pt, dataAtual);
					} catch (SemCalendarioException e) {
						continue;
					}
					break;
				}
			}
		}

		// 2o se nao tiver pt entao usar o gt
		if (retorno == null && isTestarGTsFilho) {
			for(ObjDTO obj : objsDTO.getObjs()){
				if(obj.getObj().getTpObj().equals(obj.getObj().getTIPO_OBJ_GT())) {
					retorno = getTurnoAtualGtDTO(obj.getObj().getOmGtByIdGtfilho(), dataAtual, false);
				}
			}
		}

		// 3o se nao tiver nem pt e gt usar somente a data e hora
		if (retorno == null) {
			// Assumir o calendario default
			retorno = getTurnoAtual1PTDTO(dataAtual);
		}

		return retorno;
	}

	public TurnoAtualDTO getTurnoAtual1PTDTO(Date dataAtual) throws SemCalendarioException{
		TurnoAtualDTO retorno = null;

		PTRN rn = new PTRN(this.getDao());
		List<OmPt> lista = rn.pesquisarTodosPtStAtivo();

		for(OmPt pt : lista){
			if (pt.getStAtivo().equals('0') == false) {
				try {
					retorno = getTurnoAtualDTOSemClone(pt, dataAtual);
				} catch (SemCalendarioException e) {
					continue;
				}
				break;
			}
		}

		return retorno;
	}

		/**
	 * Instancia objecto com dados do turno atual {@code turnoAtualDTO}
	 * @param dtReferencia
	 * @param dwturno
	 * @return
	 * @see TurnoRN#getCalendarioSemanalComTurnosIndefinidos(long)
	 */
	public TurnoAtualDTO obtemTurnoAtualDTO(Date dtReferencia, DwTurno dwturno, OmPt ompt){
		TurnoAtualDTO turnoAtualDTO = new TurnoAtualDTO();

		// setando retorno
		turnoAtualDTO.setDwturno(dwturno);
		turnoAtualDTO.setIdTurno(dwturno.getIdTurno());
		turnoAtualDTO.setCdTurno(dwturno.getCdTurno());

		return turnoAtualDTO;
	}

	/**
	 * @see TurnoRN#getTurnoAtualDTOPassandoDtTurnoECdTurno(List, Date, String)
	 * @param idPt id do pt, com este id pega os dados do calendário
	 * @param dtTurno
	 * @param cdTurno
	 * @return
	 * @throws SemCalendarioException
	 */
	public TurnoAtualDTO getTurnoAtualDTOPassandoIdPtEDtTurnoECdTurno(OmPt ompt, Date dtTurno, String cdTurno) throws SemCalendarioException{
		Validate.notNull(ompt, "id do pt n�o pode ser nulo");

		List<DwCalsem> dwCalsems = getCalendarioSemanalComTurnosIndefinidosParaPt(ompt, dtTurno);
		DwCalsem dwCalsem = getDwCalsemPassandoDtTurnoECdTurno(dwCalsems, dtTurno, cdTurno);

		TurnoAtualDTO retorno = new TurnoAtualDTO();

		retorno.setCdTurno(cdTurno);
		retorno.setDtHrFTurno(null);
		retorno.setDtHrITurno(null);
		retorno.setDtReferencia(dtTurno);
		retorno.setDwcal(dwCalsem.getDwCal());
		retorno.setDwturno(dwCalsem.getDwTurno());
		retorno.setIdCal(dwCalsem.getDwCal().getIdCal());
		retorno.setIdTurno(dwCalsem.getDwTurno().getIdTurno());

		// Alessandre em 16-04-15 substitui a linha abaixo pela seguinte pois na termotecnica o turno do dia 16 estava retornando como dia 15
		//
		//return getTurnoAtualDTOPassandoDtTurnoECdTurno(dwCalsems, dtTurno, cdTurno);

		/*
		 * Eh necessario o inicio e fim do turno
		 */
		TurnoAtualDTO aux = getTurnoAtualDTOPassandoDtTurnoECdTurno(dwCalsems, dtTurno, cdTurno);;

		retorno.setDtHrITurno(aux.getDtHrITurno());
		retorno.setDtHrFTurno(aux.getDtHrFTurno());

		return retorno;
	}

	/**
	 *
	 * @param idPt id do pt, com este id pega os dados do calendário
	 * @param dtTurno
	 * @param idTurno
	 * @see TurnoRN#getTurnoAtualDTOPassandoDtTurnoEIdTurno(List, Date, Long)
	 * @return
	 * @throws SemCalendarioException
	 */
	public TurnoAtualDTO getTurnoAtualDTOPassandoIdPtEDtTurnoEIdTurno(OmPt ompt, Date dtTurno, Long idTurno) throws SemCalendarioException{
		Validate.notNull(ompt, "id do pt nao pode ser nulo");

		List<DwCalsem> dwCalsems = getCalendarioSemanalComTurnosIndefinidosParaPt(ompt, dtTurno);

		return getTurnoAtualDTOPassandoDtTurnoEIdTurno(dwCalsems, dtTurno, idTurno);

	}


	// Metodo criado para encontrar o turno anterior a um determinado turno
	// Usado no heartbeat
	public TurnoAtualDTO getTurnoAnteriorDTOPassandoIdPtEDtTurnoEIdTurno(OmPt ompt, Date dtTurno, Long idTurno, TurnoAtualDTO turnoAtual) throws SemCalendarioException{
		Validate.notNull(ompt, "id do pt nao pode ser nulo");

		List<DwCalsem> dwCalsems = getCalendarioSemanalComTurnosIndefinidosParaPt(ompt, dtTurno);

		Date dthriTurno = turnoAtual.getDtHrITurno();
		dtTurno = DataHoraRN.getDataSemHora(dthriTurno);

		// Ordenar o calendario por dia da semana e hora
		Collections.sort(dwCalsems, new Comparator<DwCalsem>() {
			@Override
			public int compare(DwCalsem o1, DwCalsem o2) {
				int retorno = o1.getDiasemana().compareTo(o2.getDiasemana());
				if (retorno == 0)
					retorno = o1.getHrInicial().compareTo(o2.getHrInicial());
				return retorno;
			}
		});

		//Procurar o turno passado como referencia
		DwCalsem dwcalsemAnterior = null;
		int diaSemana = DataHoraRN.getDiaSemana(dtTurno) - 1;
		for (DwCalsem calsem : dwCalsems) {
			// Deve-se considerar apenas os registros de inicio de turno
			if (calsem.getIsInicioturno() == null || (calsem.getIsInicioturno() != null && calsem.getIsInicioturno() == false) )
				continue;

			// Se turno de referencia
			if (calsem.getDwTurno().getIdTurno() == idTurno && diaSemana == calsem.getDiasemana().intValue()) {
				break;
			}
			if (calsem.getIsInicioturno() != null && calsem.getIsInicioturno()) {
				dwcalsemAnterior = calsem;
			}
		}
		// Se retornou null eh pq o 1o elemento do vetor já era o turno de referencia. Nesse caso ficar com o ultimo elemento do vetor
		if (dwcalsemAnterior == null && dwCalsems.size() > 0) {
			dwcalsemAnterior = dwCalsems.get(dwCalsems.size() - 1);
		}

		Validate.notNull(dwcalsemAnterior, "sem turno anterior");

		/* Se o dia da semana do dwcalanterior for menor que o dia da semana do turno atual siginifica que o turno anterior
		 * comeca no dia anterior. Alem disso verificar se o turno anterior comeca no mesmo dia, se comecar no dia seguinte a
		 * subtracao nao eh necessária
		 */
		if (dwcalsemAnterior.getDiasemana().intValue() < diaSemana && dwcalsemAnterior.getTpDtreferencia() != DwCalsemTemplate.TpDtReferencia.DT_REF_DIA_SEGUINTE.getId()) {
			dtTurno = DataHoraRN.subtraiDiasDaData(dtTurno, 1);
		}


		// Montar TurnoAtualDTO para retorno
		return getTurnoAtualDTOPassandoDtTurnoEIdTurno(dwCalsems, dtTurno, dwcalsemAnterior.getDwTurno().getIdTurno());
	}

	public TurnoAtualDTO getTurnoAtualDTOComCalendarioIndefinido(Date data) throws SemCalendarioException{
		OmCfg omCfg = Util.getConfigGeral(getDaoSession());
		DwCal dwCal = omCfg.getDwCal();
		if(dwCal == null){
			throw new SemCalendarioException();
		}

		List<DwCalsem> listaDwCalsem = getCalendarioSemanalComTurnosIndefinidos(dwCal.getIdCal());
		return getTurnoAtualDTO(listaDwCalsem, data);

	}

	/**
	 * Pega os detalhes do turno com base na data e id do turno.
	 * <br> Método irá simular uma data/hora que esteja dentro da Data e do turno
	 * <br> e chamará o mesmo método usado para pegar a os dados do turno com a apenas a data/hora {@link TurnoRN#getTurnoAtualDTO(DwCalsem, Date, List)}.
	 * @param dwCalsems
	 * @param dtTurno
	 * @param idTurno
	 * @return
	 */
	public TurnoAtualDTO getTurnoAtualDTOPassandoDtTurnoEIdTurno(List<DwCalsem> dwCalsems, Date dtTurno, Long idTurno){
		Validate.notNull(idTurno, "id do turno esta nulo");
		DwTurno dwTurno = this.getDao().findById(DwTurno.class, idTurno, false);
		Validate.notNull(dwTurno, new StringBuilder("Nao encontrou o turno pelo id ").append(idTurno).toString());
		return getTurnoAtualDTOPassandoDtTurnoECdTurno(dwCalsems, dtTurno, dwTurno.getCdTurno());

	}

	/**
	 * Pega os detalhes do turno com base na data e código do turno.
	 * <br> Método irá simular uma data/hora que esteja dentro da Data e do turno
	 * <br> e chamará o mesmo método usado para pegar a os dados do turno com a apenas a data/hora {@link TurnoRN#getTurnoAtualDTO(DwCalsem, Date, List)}.
	 * @param dwCalsems
	 * @param dtTurno
	 * @param cdTurno
	 * @return
	 */
	/*
	 * Alessandre: em 16-04-15 acho que o metodo está errado. Se dtTurno e cdTurno sao os turnos desejados, entao o fato de se calcular dtHrAtual subtraindo dia
	 * causou na termotecnica se desejar o turno 2 do dia 16 e o algoritmo abaixo retornou como referencia o dia 15
	 */
	public TurnoAtualDTO getTurnoAtualDTOPassandoDtTurnoECdTurno(List<DwCalsem> dwCalsems, Date dtTurno, String cdTurno){
		DwCalsem dwCalsem = getDwCalsemPassandoDtTurnoECdTurno(dwCalsems, dtTurno, cdTurno);


		// Simula uma data atual usando a data do turno, com os segundos da hora inicial do dwCalsem
		// A inten��oo é que esta data hora simulada, correspondda a algum período do DtTurno e CdTurno
		// Assim dará para usar a mesma implementa��oo que buscaa o turno atual, mas só passa a data hora
		Date dtHrAtual = DataHoraRN.adicionaSegundosNaData(dtTurno, dwCalsem.getHrInicial().intValue());

		if(DwCalsemTemplate.TpDtReferencia.DT_REF_DIA_ANTERIOR.equals(dwCalsem.getTpDtreferencia())){
			dtHrAtual = DataHoraRN.adicionaDiasDaData(dtHrAtual, 1);
		}else if(DwCalsemTemplate.TpDtReferencia.DT_REF_DIA_SEGUINTE.equals(dwCalsem.getTpDtreferencia())){
			dtHrAtual = DataHoraRN.adicionaDiasDaData(dtHrAtual, -1);
		}

		// Usa a data hora atual simulada para chamar o método que preenche TurnoAtualDTO.
		return getTurnoAtualDTO(dwCalsem, dtHrAtual, dwCalsems);

	}



	/**
	 * Instancia objecto com dados do turno atual {@code turnoAtualDTO}
	 * @param dwCalsem
	 * @param dtHrAtual
	 * @param dwCalsems lista de calendário 24/7 {@link TurnoRN#getCalendarioSemanalComTurnosIndefinidos(long)}
	 * @return
	 * @see TurnoRN#setTurnoAtualDTOSemInicioFimTurno(TurnoAtualDTO, DwCalsem, Date)
	 * @see TurnoRN#setTurnoAtualDTOApenasInicioFimTurno(TurnoAtualDTO, DwCalsem, Date)
	 * @see TurnoRN#getCalendarioSemanalComTurnosIndefinidos(long)
	 */
	private TurnoAtualDTO getTurnoAtualDTO(DwCalsem dwCalsem, Date dtHrAtual,  List<DwCalsem> dwCalsems){

		// pegando somenta a data de dtHrTurno
		Date dtTurno = DataHoraRN.getDataSemHora(dtHrAtual);

		BigDecimal dtHrIHora = new BigDecimal(dtTurno.getTime());
		// Convertendo para segundos
		dtHrIHora = dtHrIHora.divide(new BigDecimal(1000));
		// Somando com a hora inicial
		dtHrIHora = dtHrIHora.add(dwCalsem.getHrInicial());

		BigDecimal dtHrFHora = new BigDecimal(dtTurno.getTime());
		// Convertendo para segundos
		dtHrFHora = dtHrFHora.divide(new BigDecimal(1000));
		// Somando com a hora inicial
		dtHrFHora = dtHrFHora.add(dwCalsem.getHrFinal());

		TurnoAtualDTO turnoAtualDTO = new TurnoAtualDTO();

		// setando retorno
		turnoAtualDTO.setDwturno(dwCalsem.getDwTurno());
		turnoAtualDTO.setIdTurno(dwCalsem.getDwTurno().getIdTurno());
		turnoAtualDTO.setCdTurno(dwCalsem.getDwTurno().getCdTurno());
		turnoAtualDTO.setIdCal(dwCalsem.getDwCal().getIdCal());
		turnoAtualDTO.setDwcal(dwCalsem.getDwCal());

		// TODO provavelmente o conteúdo dos campos abaixo n�o est�o ok. Por favor avaliar antes de usar
		turnoAtualDTO.setDtHrIHora(dtHrIHora);
		turnoAtualDTO.setDtHrFHora(dtHrFHora);

		// pegando a data com um dia a mais
		Date dtTurnoMaisDia = DataHoraRN.adicionaDiasDaData(dtTurno, 1);

		// pegando a data com um dia a menos
		Date dtTurnoMenosDia = DataHoraRN.adicionaDiasDaData(dtTurno, -1);

		// índice do item encontrado
		int index = dwCalsems.indexOf(dwCalsem);

		Validate.validIndex(dwCalsems, index,  "N�o encontrou item na cole��oo. Método equals do DwCalsem n�o compatível, ou getDwCalsem(List<DwCalsem>, Date) com problema");

		// Pega DwCalsem do início e fim do turno
		DwCalsem dwCalsemITurno = this.getDwCalSemITurnoSemana(dwCalsems, index);
		DwCalsem dwCalsemFTurno = this.getDwCalsemFTurnoSemana(dwCalsems, index);
		
//		System.out.println("#########");
//		for (DwCalsem sem : dwCalsems) {
//			System.out.println(sem.toString());
//		}
//		System.out.println("#########");
//		System.out.println("Inicio turno: " + dwCalsemITurno);
//		System.out.println("Fim turno: " + dwCalsemFTurno);

		turnoAtualDTO.setSegPreTolerancia(dwCalsemITurno.getSegToleranciapreEmSeg());
		turnoAtualDTO.setSegPosTolerancia(dwCalsemFTurno.getSegToleranciaposEmSeg());

		Date dthrITurno = null;
		Date dthrFTurno = null;

		DiaSemana diaSemana = dwCalsem.getDiaSemanaType();
		DiaSemana diaSemanaI = dwCalsemITurno.getDiaSemanaType();
		DiaSemana diaSemanaF = dwCalsemFTurno.getDiaSemanaType();

		// Se dia de início for no sábado e fim no domingo
		if(diaSemanaI.equals(DwCalsemTemplate.DiaSemana.SABADO) && diaSemanaF.equals(DwCalsemTemplate.DiaSemana.DOMINGO)){

			// Se dtturno for sábado
			if(diaSemana.equals(diaSemanaI)){
				dthrITurno = dtTurno;
				dthrITurno = DataHoraRN.adicionaSegundosNaData(dthrITurno, dwCalsemITurno.getHrInicial().intValue());
				dthrFTurno = DataHoraRN.adicionaDiasDaData(dtTurno, 1);
				dthrFTurno = DataHoraRN.adicionaSegundosNaData(dthrFTurno, dwCalsemFTurno.getHrFinal().intValue());

			// Se dtturno for domingo
			}else{
				dthrITurno = DataHoraRN.adicionaDiasDaData(dtTurno, -1);
				dthrITurno = DataHoraRN.adicionaSegundosNaData(dthrITurno, dwCalsemITurno.getHrInicial().intValue());
				dthrFTurno = dtTurno;
				dthrFTurno = DataHoraRN.adicionaSegundosNaData(dthrFTurno, dwCalsemFTurno.getHrFinal().intValue());
			}

		} else{

			// Alessandre em 16-12-2014. Acrescentei o if abaixo para tratar de forma diferenciada quando o dia da semana de inicio do turno
			// for posterior ao do final, por exemplo, comeca sabado e termina segunda. Isso significa que é o sabado anterior a segunda.
			// O que estava ocorrendo era que o inicio do ciclo estava ficando com uma data maior que a final
			if (diaSemanaI.getId().intValue() > diaSemanaF.getId().intValue()) {
				int dias = diaSemana.getId().intValue() + 1;
				dias += (6 - diaSemanaI.getId().intValue() );

				dthrITurno = DataHoraRN.subtraiDiasDaData(dtTurno, dias);
				dthrITurno = DataHoraRN.adicionaSegundosNaData(dthrITurno, dwCalsemITurno.getHrInicial().intValue());
			} else {
				// Ajusta início do turno
				dthrITurno = DataHoraRN.adicionaDiasDaData(dtTurno, diaSemanaI.getId().intValue() - diaSemana.getId().intValue());
				dthrITurno = DataHoraRN.adicionaSegundosNaData(dthrITurno, dwCalsemITurno.getHrInicial().intValue());
			}
			// Ajusta fim do turno
			dthrFTurno = DataHoraRN.adicionaDiasDaData(dtTurno, diaSemanaF.getId().intValue() - diaSemana.getId().intValue());
			dthrFTurno = DataHoraRN.adicionaSegundosNaData(dthrFTurno, dwCalsemFTurno.getHrFinal().intValue());
		}

		// Pega a data de referencia
		TpDtReferencia tpDtReferencia = DwCalsemTemplate.TpDtReferencia.getType(dwCalsem.getTpDtreferencia());

		// Indica o dia de referencia do turno
		switch (tpDtReferencia){

			case DT_REF_MESMO_DIA:
				// Inicia e termina no mesmo dia
				turnoAtualDTO.setDtReferencia(dtTurno);

				break;

			case DT_REF_DIA_SEGUINTE:
				// Termina no dia seguinte
				turnoAtualDTO.setDtReferencia(dtTurnoMaisDia);

				break;

			case DT_REF_DIA_ANTERIOR:
				// Inicia no dia anterior
				turnoAtualDTO.setDtReferencia(dtTurnoMenosDia);

				break;

		}

		turnoAtualDTO.setDtHrITurno(dthrITurno);
		turnoAtualDTO.setDtHrFTurno(dthrFTurno);

		// Início do turno n�o pode ser maior que o fim
		if(DataHoraRN.before(dthrITurno, dthrFTurno) == false){
				throw new IllegalStateException(String.format("ERRO na IDENTIFICAÇÃO DO CALENDARIO MOTIVO:dtHrITurno (%s) > dtHrFTurno (%s) \n dtHrAtual=%s \n turnoAtualDTO=%s \n dwCalsem=%s\n dwCalsemITurno=%s\n dwCalsemFTurno=%s \n dwCalsems=%s\n",
						DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dthrITurno),
						DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dthrFTurno),
						DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dtHrAtual),
						turnoAtualDTO.toString(),
						dwCalsem.toString(),
						dwCalsemITurno.toString(),
						dwCalsemFTurno.toString(),
						DwCalsemTemplate.dwCalsemsToString(dwCalsems)));
		}

		return turnoAtualDTO;

	}

	/**
	 * Com base em calendário semanal completo, podendo ter turnos indefinidos {@link #getCalendarioSemanalComTurnosIndefinidos(long)}
	 * Pega {@code DwCalsem} correspondente a data hora passada
	 * @param dwCalsems
	 * @param dtHr
	 * @return
	 */
	private DwCalsem getDwCalsemPassandoDtHrAtual(List<DwCalsem> dwCalsems, Date dtHr){

		Validate.notNull(dwCalsems, "dwCalsems nao pode ser nulo");

		// verifica se tem a quantidade mínima de itens, que seriam 7, com 1 turno por dia
		Validate.isTrue(dwCalsems.size() >= Calendar.DAY_OF_WEEK, "dwCalsems nao tem quantidade minima de 7 itens");

		 Validate.notNull(dtHr, "dtHr nao pode ser nulo");

		// Pega o dia da semana
		DwCalsemTemplate.DiaSemana diaSemana = DwCalsemTemplate.DiaSemana.get(dtHr);

		// segundos para o dia
		BigDecimal segundosNoDia = new BigDecimal(DataHoraRN.getSegundosDoDia(dtHr));

		// Procura o DwCalSem correspondendo a data/hora
		for(DwCalsem dwCalsem: dwCalsems){

			BigDecimal hrInicial = dwCalsem.getHrInicialComTolerancia();
			BigDecimal hrFinal = dwCalsem.getHrFinalComTolerancia();

			// Se for o mesmo dia
			// e se o horário estiver no mesmo intervalo, ent�o este é o item com o turno para o horário
			if(diaSemana.equals(dwCalsem.getDiaSemanaType())
					&& hrInicial.compareTo(segundosNoDia) <= 0
					&& hrFinal.compareTo(segundosNoDia) > 0){
				
				return dwCalsem;
			}
			// Nao pode haver um delay
//			UtilsThreads.pausaNaThread(10l);

		}
		
//		for (DwCalsem calsem : dwCalsems) {
//			System.out.println(calsem);
//		}

		// Deve encontrar algum item, se n�o encontrar, lança exce��oo com os detalhes.
		throw new IllegalStateException(String.format("Em getDwCalsemPassandoDthrAtual. Nao foi encontrado calendario/turno. Dthr=%s segundosNoDia=%s", dtHr, segundosNoDia));

	}

	/**
	 * * Com base em calendário semanal completo, podendo ter turnos indefinidos {@link #getCalendarioSemanalComTurnosIndefinidos(long)}
	 * Pega {@code DwCalsem} correspondente a data e id do turno
	 * @param dwCalsems
	 * @param dtRef
	 * @param cdTurno
	 * @return
	 */
	private DwCalsem getDwCalsemPassandoDtTurnoECdTurno(List<DwCalsem> dwCalsems, Date dtRef, String cdTurno){

		Validate.notNull(dwCalsems, "dwCalsems nao pode ser nulo");

		// verifica se tem a quantidade mínima de itens, que seriam 7, com 1 turno por dia
		Validate.isTrue(dwCalsems.size() >= Calendar.DAY_OF_WEEK, "dwCalsems nao tem quantidade minima de 7 itens");

		Validate.notNull(dtRef, "dtHr nao pode ser nulo");
		Validate.notEmpty(cdTurno, "cdTurno nao pode ser nulo");

		// Pega o dia da semana
		DwCalsemTemplate.DiaSemana diaSemana = DwCalsemTemplate.DiaSemana.get(dtRef);


		// Procura o DwCalSem correspondendo a dtref e id do turno para mesmo dia
		for(DwCalsem dwCalsem: dwCalsems){
			if(
					diaSemana.equals(dwCalsem.getDiaSemanaType()) &&
					cdTurno.equals(dwCalsem.getDwTurno().getCdTurno()) &&
					DwCalsemTemplate.TpDtReferencia.DT_REF_MESMO_DIA.equals(dwCalsem.getTpDtreferencia()) ){
				return dwCalsem;
			}
		}



		// se n�o encontrar, procura com referecia para o dia anterior
		DwCalsemTemplate.DiaSemana diaSemanaProximo = diaSemana.getProximoDia();
		for(DwCalsem dwCalsem: dwCalsems){
			if(
					diaSemanaProximo.equals(dwCalsem.getDiaSemanaType()) &&
					cdTurno.equals(dwCalsem.getDwTurno().getCdTurno()) &&
					DwCalsemTemplate.TpDtReferencia.DT_REF_DIA_ANTERIOR.equals(dwCalsem.getTpDtreferencia()) ){
				return dwCalsem;
			}
		}

		// se n�o encontrar, procura com referecia para o próximo dia
		DwCalsemTemplate.DiaSemana diaSemanaAnterior = diaSemana.getDiaAnterior();
		for(DwCalsem dwCalsem: dwCalsems){
			if(
					diaSemanaAnterior.equals(dwCalsem.getDiaSemanaType()) &&
					cdTurno.equals(dwCalsem.getDwTurno().getCdTurno()) &&
					DwCalsemTemplate.TpDtReferencia.DT_REF_DIA_SEGUINTE.equals(dwCalsem.getTpDtreferencia()) ){
				return dwCalsem;
			}
		}

	// Deve encontrar algum item, se n�o encontrar, lança exce��oo com os detalhes.
		throw new IllegalStateException(String.format("Em getDwCalsemPassandoDtTurnoECdTurno. Nao foi encontrado calendario/turno. DtRef=%s cdTurno=%s, idCal=%s", dtRef, cdTurno, dwCalsems.get(0).getDwCal().getIdCal()));

	}

	/**
	 * Pega a {@code DwCalsem} correspondente ao início do turno relacionado a {@code inde} do calendário semanal
	 * @param dwCalsems Calendário Semanal 24/7 {@link TurnoRN#getCalendarioSemanalComTurnosIndefinidos(long)}
	 * @param index índice do item de {@code DwCalsem} usado como referencia
	 * @param idTurno
	 * @return
	 */
	private DwCalsem getDwCalSemITurnoSemana(List<DwCalsem> dwCalsems, int index){

		Validate.notNull(dwCalsems, "Calendário semanal n�o pode ser nulo: dwCalsems");
		Validate.validIndex(dwCalsems, index, "indice invalido para a colecao de calendario semanal: index= %s dwCalsems.size()=%s ", index, dwCalsems.size());


		int i = index;
		DwCalsem dwCalsemRef = dwCalsems.get(index);

		do{

			DwCalsem dwCalsem = dwCalsems.get(i);

			// Se estiver marcado como início do turno, retorna hora inicial do item
			if(dwCalsem.getIsInicioturno()){
				return dwCalsem;
			}

			boolean isMesmoTurno = ObjectUtils.compare(dwCalsem.getDwTurno().getIdTurno(), dwCalsemRef.getDwTurno().getIdTurno()) == 0;

			Validate.validState(isMesmoTurno, "Passou para outro turno e nao encontrou HrITurno. Talvez no calendario semanal nao exista item com IsInicioTurno=true");

			// Se chegar no índice zero, vai para o fim da cole��oo
			i = (i > 0 ? i - 1: dwCalsems.size() -1);

		// se i = index, indicar que já deu uma volta na cole��oo de calendário semanal, ent�o n�o encontrou o item
		}while (index != i);

		// Se chegou neste ponto, n�o encontrou o item que representa a hora inicial do turno
		throw new IllegalStateException("N�o encontrou hrITurno. Talvez no calendário semanal n�o haja item com IsInicioTurno=true");

	}

	/**
	 * Pega a {@code DwCalsem} correspondente ao fim do turno relacionado a {@code index} do calendário semanal
	 * @param dwCalsems Calendário Semanal 24/7 {@link TurnoRN#getCalendarioSemanalComTurnosIndefinidos(long)}
	 * @param index índice do item de {@code DwCalsem} usado como referencia
	 * @return
	 */
	private DwCalsem getDwCalsemFTurnoSemana(List<DwCalsem> dwCalsems, int index){

		Validate.notNull(dwCalsems, "Calendário semanal n�o pode ser nulo: dwCalsems");
		Validate.validIndex(dwCalsems, index, "�ndice inv�lido para a cole��o de calend�rio semanal: index= %s dwCalsems.size()=%s ", index, dwCalsems.size());

		int i = index;
		DwCalsem dwCalsemRef = dwCalsems.get(index);

		do{

			DwCalsem dwCalsem = null;

			try {
				dwCalsem = dwCalsems.get(i);
			} catch (IndexOutOfBoundsException e){
				e.printStackTrace();
			}

			//n�o lembro porque esse trecho foi colocado verificar com o milton
			boolean isMesmoCalendario = ObjectUtils.compare(dwCalsem.getDwCal().getIdCal(), dwCalsemRef.getDwCal().getIdCal()) == 0;
//			Validate.validState(isMesmoCalendario, "Passou para outro calendario e n�o encontrou HrFTurno. Talvez no calendário semanal n�o haja item com IsFimTurno=true");

			boolean isMesmoTurno = ObjectUtils.compare(dwCalsem.getDwTurno().getIdTurno(), dwCalsemRef.getDwTurno().getIdTurno()) == 0;
			if(isMesmoCalendario == true && isMesmoTurno == false){
				throw new IllegalStateException("Passou para outro turno e nao encontrou HrFTurno. Talvez no calendario semanal nao exista item com IsFimTurno=true. \n" +
						" dwCalsem " + dwCalsem.toString() + "\n" +
						" dwCalsemRef " + dwCalsemRef.toString() + "\n Index=" + index);
			}
			// Se estiver marcado como fim do turno, retorna hora inicial do item
			if(dwCalsem.getIsFimturno()){
				return dwCalsem;
			}

			// Se chegar no final da cole��oo, volta para o ínicio dela
			// alessandre: em 4-6-13 acrescentei o -1 na linha abaixo pois estava dando erro de indexoutofbound
			i = (i < (dwCalsems.size()-1) ? i + 1: 0);

			// se i = index, indicar que já deu uma volta na cole��oo de calendário semanal, ent�o n�o encontrou o item
			
			
		}while (index != i);

		String strDwcalsemRef = "";
		if(dwCalsemRef != null){
			strDwcalsemRef = dwCalsemRef.toString();
		}

		// Se chegou neste ponto, n�o encontrou o item que representa a hora inicial do turno
		throw new IllegalStateException("N�o encontrou hrFTurno. Talvez no calendário semanal n�o haja item com IsFimTurno=true. \n" + "dwCalsem = " + strDwcalsemRef);

	}

	/**
	 * Lista com os horários do calendário da semana
	 * @param idCal
	 * @return
	 */
	public List<DwCalsem> getDwCalsems(Long idCal) {

		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT dwcalsem ");

		q.append("FROM DwCalsem dwcalsem ");
		q.append("JOIN fetch dwcalsem.dwCal dwcal ");
		q.append("JOIN fetch dwcalsem.dwTurno dwTurno ");

		q.append("WHERE (dwcalsem.dwCal.idCal = :idCal) ");
		q.append("ORDER by dwcalsem.diasemana, dwcalsem.hrInicial");

		q.defineParametro("idCal", idCal);

		return q.list();

	}

	/**
	 * Retorna registro do calendário do dia correspondente ao {@code dtHrTurno} passado
	 * @param idCal
	 * @param dtHrTurno
	 * @param log
	 * @param idLog
	 * @param identacao
	 * @param idPt
	 * @return
	 */
	public DwCalsem getDwCalsem(Long idCal, Date dtHrTurno, IdwLogger log, int idLog, int identacao, OmPt ompt) {

		MapQuery q = new MapQuery(getDaoSession());

		// pegando o dia da semana de dtHrTurno
		Calendar oCalendar = Calendar.getInstance();
		oCalendar.setTime(dtHrTurno);

		// Adicionado "- 1", por que nos cadastro, é usado base zero. Domingo é 0, e sábado é 6
		Integer diaSemana = oCalendar.get(Calendar.DAY_OF_WEEK) - 1;

		// definindo hora da data passada em segundo (somente do dia)
		int segundosDoDia = DataHoraRN.getSegundosDoDia(dtHrTurno);

		q.append("SELECT dwcalsem ");

		q.append("FROM DwCalsem dwcalsem ");
		q.append("JOIN fetch dwcalsem.dwCal dwcal ");
		q.append("JOIN fetch dwcalsem.dwTurno dwTurno ");

		q.append("WHERE (dwcalsem.dwCal.idCal = :idCal) AND ");
		q.append("(dwcalsem.diasemana = :dtHrTurnoDiaSemana) AND ");
		q.append("((dwcalsem.hrInicial - dwcalsem.segToleranciapre) <= :dataSeg) AND ");
		q.append("(:dataSeg <= (dwcalsem.hrFinal + dwcalsem.segToleranciapos))");

		q.defineParametro("idCal", idCal);
		q.defineParametro("dtHrTurnoDiaSemana", new BigDecimal(diaSemana));
		q.defineParametro("dataSeg", new BigDecimal(segundosDoDia));
		q.setMaxResults(1);

		DwCalsem dwCalsem = null;

		try {
			dwCalsem = (DwCalsem) q.uniqueResult();
		} catch (Exception e) {
			// throw new SemSGBDException();
			e.printStackTrace();
			return (dwCalsem);
		}

		if(dwCalsem == null){
			if (log != null) {
				log.info(idLog, identacao, "TURNO INDEFINIDO: " + q.hqlToString() + " PARA " + dtHrTurno + " do PT " + ompt.getIdPt() + " IDcaL: " + idCal + " diaSemana: " + diaSemana + " segundosDia: " + segundosDoDia);
			}
		}

		return (dwCalsem);
	}

	/**
	 * TODO milton - usar MaqQuery
	 * @param idCal
	 * @param dtTurno
	 * @param cdTurno
	 * @return
	 * @throws SemSGBDException
	 * @throws RegistroDesconhecidoException
	 */
	public Date getDtHrFTurnoAvulso(Long idCal, Date dtTurno, String cdTurno)
			throws SemSGBDException, RegistroDesconhecidoException {
		String hql = "";

		hql += "SELECT dwcalavu ";
		hql += "FROM DwCalavu dwcalavu ";
		hql += "JOIN dwcalavu.dwCal dwcal";
		hql += "JOIN dwcalavu.dwTurno dwturno";
		hql += "WHERE (dwcal.idCal = '::idcal') AND ";
		hql += "(dwcalavu.dtAvulso = :dtAvulso) AND ";
		hql += "(dwturno.cdTurno = '::cdTurno') AND ";
		hql += "(dwcalavu.isFimturno = true)";

		hql = hql.replaceAll("::idcal", idCal.toString());
		hql = hql.replaceAll("::cdTurno", cdTurno);

		Query q = getDaoSession().createQuery(hql);

		q.setTimestamp("dtAvulso", dtTurno);

		List<DwCalavu> listaDwCalavu = null;
		try {
			listaDwCalavu = q.list();
		} catch (Exception e) {
			throw new SemSGBDException();
		}

		DwCalavu oDwCalavu = null;

		if (listaDwCalavu.size() > 0) {
			oDwCalavu = listaDwCalavu.get(0);
		} else {
			throw new RegistroDesconhecidoException();
		}

		// setando na data, a hora de inicio
		Date dDtHrFinal = new Date(dtTurno.getTime()
				+ (oDwCalavu.getHrFinal().longValue() * 1000)); // pegando a
																// data somada
																// com a hora

		return (dDtHrFinal);
	}

	/**
	 * TODO milton - usar MapQuery
	 * @param idCal
	 * @param dtTurno
	 * @param cdTurno
	 * @return
	 * @throws SemSGBDException
	 * @throws RegistroDesconhecidoException
	 */
	public Date getDtHrITurnoAvulso(Long idCal, Date dtTurno, String cdTurno)
			throws SemSGBDException, RegistroDesconhecidoException {
		String hql = "";

		hql += "SELECT dwcalavu ";
		hql += "FROM DwCalavu dwcalavu ";
		hql += "JOIN dwcalavu.dwCal dwcal";
		hql += "JOIN dwcalavu.dwTurno dwturno";
		hql += "WHERE (dwcal.idCal = '::idcal') AND ";
		hql += "(dwcalavu.dtAvulso = :dtAvulso) AND ";
		hql += "(dwturno.cdTurno = '::cdTurno') AND ";
		hql += "(dwcalavu.isInicioturno = true)";

		hql = hql.replaceAll("::idcal", idCal.toString());
		hql = hql.replaceAll("::cdTurno", cdTurno);

		Query q = getDaoSession().createQuery(hql);

		q.setTimestamp("dtAvulso", dtTurno);

		List<DwCalavu> listaDwCalavu = null;
		try {
			listaDwCalavu = q.list();
		} catch (Exception e) {
			throw new SemSGBDException();
		}

		DwCalavu oDwCalavu = null;

		if (listaDwCalavu.size() > 0) {
			oDwCalavu = listaDwCalavu.get(0);
		} else {
			throw new RegistroDesconhecidoException();
		}

		// setando na data, a hora de inicio
		Date dDtHrInicial = new Date(dtTurno.getTime()
				+ (oDwCalavu.getHrinicial().longValue() * 1000)); // pegando a
																	// data
																	// somada
																	// com a
																	// hora

		return (dDtHrInicial);
	}

	/**
	 * Funcao que retorna um objeto DwCalavu, dado um idCal e uma data do turno
	 * TODO milton - MapQuery
	 * @param idCal
	 *            - idCal
	 * @param dtHrTurno
	 *            - Data do turno
	 * @return Retorna um objeto DwCalavu
	 * @throws SemCalendarioException
	 * @throws SemSGBDException
	 *             Se houve algum erro com o banco de dados
	 * @throws RegistroDesconhecidoException
	 *             Se nao achou registro com os parametros passados
	 */
	public DwCalavu getDwCalavu(Long idCal, Date dtHrTurno) throws SemCalendarioException {
		String hql = "";

		// se o horario enviado for null lancar excessao
		if ( dtHrTurno == null ) {
			throw new SemCalendarioException();
		}

		// pegando somenta a data de dtHrTurno
		Calendar oCalendar = Calendar.getInstance();
		oCalendar.setTime(dtHrTurno);

		Calendar oCalTurno = Calendar.getInstance();
		oCalTurno.set(oCalendar.get(Calendar.YEAR), oCalendar
				.get(Calendar.MONTH), oCalendar.get(Calendar.DAY_OF_MONTH));
		Date dtTurno = oCalTurno.getTime();

		// definindo hora da data passada em segundo (somente do dia)
		Integer iDataSeg = (oCalendar.get(Calendar.HOUR_OF_DAY) * 60 * 60)
				+ (oCalendar.get(Calendar.MINUTE) * 60)
				+ (oCalendar.get(Calendar.SECOND));

		hql += "SELECT dwcalavu ";
		hql += "FROM DwCalavu dwcalavu ";
		hql += "JOIN fetch dwcalavu.dwCal dwcal ";
		hql += "JOIN fetch dwcalavu.dwTurno dwTurno ";
		hql += "WHERE (dwcalavu.dwCal.idCal = ::idCal) AND ";
		hql += "(dwcalavu.dtAvulso = :dtAvulso) AND ";
		hql += "((dwcalavu.hrinicial - dwcalavu.segToleranciapre) <= ::dataSeg) AND ";
		hql += "(::dataSeg <= (dwcalavu.hrFinal + dwcalavu.segToleranciapos))";

		hql = hql.replaceAll("::idCal", idCal.toString());
		hql = hql.replaceAll("::dataSeg", iDataSeg.toString());

		Query q = getDaoSession().createQuery(hql);

		q.setDate("dtAvulso", dtTurno);

		DwCalavu oDwCalavu = null;

		List<DwCalavu> listaDwCalavu = null;
		try {
			listaDwCalavu = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			// throw new SemSGBDException();
			return (oDwCalavu);
		}

		if (listaDwCalavu.size() > 0) {
			oDwCalavu = listaDwCalavu.get(0);
		} else {
			oDwCalavu = null;
			// throw new RegistroDesconhecidoException();
		}

		return (oDwCalavu);
	}

	/**
	 * Pega calendário relaciona a configura��oo ativa
	 * TODO milton - pesquisar apenas calendário ativo, identificar também o último calendário válido (id_cal desc) e com dthrfvalidade = null
	 * TODO milton - se deixar de usar EXISTS na consulta, fica mais rápido
	 * @return
	 */
	public DwCal getDwCal() {
		MapQuery q = new MapQuery(this.getDaoSession());

		q.append("SELECT dwcal ");
		q.append("FROM DwCal dwcal ");
		q.append("WHERE EXISTS (");
		q.append("	SELECT omcfg ");
		q.append("	FROM OmCfg omcfg ");
		q.append("	WHERE omcfg.dwCal.idCal = dwcal.idCal and omcfg.stAtivo = 1");
		q.append(")");

		DwCal oDwCal = null;

		oDwCal = (DwCal) q.uniqueResult();

		return (oDwCal);
	}

	/**
	 * Pega o calendário do posto de trabalho
	 * @param idPt
	 * @return
	 * Alessandre: Inclui a data e hora de referencia pois eh usada no processamento de eventos antigos, e na monitorizacao de datas antigas
	 */

	private DwCal getDwCalByPtEdthr(OmPt ompt, Date dthrReferencia) {
		MapQuery q = new MapQuery(getDaoSession());

		q.append("SELECT a ");
		q.append("FROM DwCal a");
		q.append("join a.dwCalpts b");
		q.append("join b.omPt c");
		if (ompt.getCdPt() != null && ompt.getCdPt().equals("") == false) {
			q.append("where c.cdPt = :cdpt and c.stAtivo = 1 ");
		} else {
			q.append("where c.idPt = :idpt");
		}
		q.append("and :dtreferencia between a.dthrIvalidade and a.dthrFvalidade");
		q.append("and a.dthrFvalidade is not null");
		q.append("and a.stAtivo = 1");
		q.append("order by a.dthrIvalidade desc");

		q.defineParametro("cdpt", ompt.getCdPt());
		q.defineParametro("idpt", ompt.getIdPt());
		q.defineParametroTimestamp("dtreferencia", dthrReferencia);

		q.setMaxResults(1);

		DwCal retorno = (DwCal) q.uniqueResult();

		// Se nao encontrar um calendario acima, mesmo que desativado, entao procurar no calendario ativo. A maior preocupacao agora eh nao ter periodos de validade com intersessao entre os calendarios que tenham os mesmos pts
		if (retorno == null) {
			q.novaConsulta();
			q.append("SELECT a ");
			q.append("FROM DwCal a");
			q.append("join a.dwCalpts b");
			q.append("join b.omPt c");
			if (ompt.getCdPt() != null && ompt.getCdPt().equals("") == false) {
				q.append("where c.cdPt = :cdpt and c.stAtivo = 1 ");
			} else {
				q.append("where c.idPt = :idpt");
			}
			q.append("and :dtreferencia >= a.dthrIvalidade");
			q.append("and a.dthrFvalidade is null");
			q.append("and a.stAtivo = 1");
			q.append("order by a.dthrIvalidade desc");
			q.defineParametro("cdpt", ompt.getCdPt());
			q.defineParametro("idpt", ompt.getIdPt());
			q.defineParametroTimestamp("dtreferencia", dthrReferencia);

			q.setMaxResults(1);
			retorno = (DwCal) q.uniqueResult();
		}

		q = null;

		return (retorno);
	}

	/**
	 * Pega o calendário do posto de trabalho, mas se n�o tiver calendário definido para ele. Pega o calendário indefinido
	 * @param idPt
	 * @return
	 * @throws SemCalendarioException
	 */
	public DwCal getDwCalPtOuDefault(OmPt ompt, Date dthrReferencia) throws SemCalendarioException{
		DwCal retorno = getDwCalByPtEdthr(ompt, dthrReferencia);
		if(retorno == null){
			try {
				retorno = getCalendarioIndefinido();
			} catch (SemCalendarioException e) {
				throw new SemCalendarioException("Nao tem calendario definido para o posto de trabalho e nem calendario padr�o." + e.getMessage());
			}
		}
		return retorno;
	}

	/**
	 * Funcao generica para executar uma query e retornar um resultado de um
	 * tipo
	 *
	 * @param <T>
	 *            - tipo generico que utilize Hibernate (POJO)
	 * @param oGen
	 *            - novo objeto do tipo T
	 * @param hql
	 *            - hql a ser executada
	 * @return Retorna o objeto passado preenchido pela execucao da query
	 *         passada
	 * @throws SemSGBDException
	 *             Se deu pau no banco
	 * @throws RegistroDesconhecidoException
	 *             Se a query passada nao retornar registro algum
	 */
	public <T> T getDadosBanco(T oGen, String hql) throws SemSGBDException,
			RegistroDesconhecidoException {
		Query q = getDaoSession().createQuery(hql);

		List<T> listaGen = null;
		try {
			listaGen = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SemSGBDException();
		}

		if (listaGen.size() > 0) {
			oGen = listaGen.get(0);
		} else {
			throw new RegistroDesconhecidoException();
		}

		return (oGen);
	}

	/**
	 * Funcao generica para executar uma query e retornar um resultado de um
	 * tipo e pode colocar parametros de data na query
	 *
	 * @param <T>
	 *            - tipo generico que utilize Hibernate (POJO)
	 * @param oGen
	 *            - novo objeto do tipo T
	 * @param hql
	 *            - hql a ser executada
	 * @param saSubQuery
	 *            - String array contendo as referencias das datas
	 * @param DateParams
	 *            - Data para colocar da query
	 * @return Retorna o objeto passado preenchido pela execucao da query
	 *         passada
	 * @throws SemSGBDException
	 *             Se deu pau no banco
	 * @throws RegistroDesconhecidoException
	 *             Se a query passada nao retornar registro algum
	 */
	public <T> T getDadosBanco(T oGen, String hql, String[] saSubQuery,
			Date... DateParams) throws SemSGBDException,
			RegistroDesconhecidoException {
		Query q = getDaoSession().createQuery(hql);

		for (int iCont = 0; iCont < saSubQuery.length; iCont++) {
			String sParam = saSubQuery[iCont];
			Date dParam = DateParams[iCont];

			q.setTimestamp(sParam, dParam);
		}

		List<T> listaGen = null;
		try {
			listaGen = q.list();
		} catch (Exception e) {
			throw new SemSGBDException();
		}

		if (listaGen.size() > 0) {
			oGen = listaGen.get(0);
		} else {
			throw new RegistroDesconhecidoException();
		}

		return (oGen);
	}

	public DwTurno pesquisarTurnoById(Long id){
		MapQuery q = new MapQuery(getDaoSession());

		q.append("select dwturno");
		q.append("from DwTurno dwturno");
		q.append("where dwturno.idTurno = :idturno");

		q.defineParametro("idturno", id);

		return (DwTurno) q.uniqueResult();
	}

	/**
	 * Pega o turno indefinido. Baseado no código {@link #CD_TURNO_INDEFINIDO}
	 * @return
	 * @throws SemCalendarioException se n�o encontrar turno indefinido
	 */
	public DwTurno getTurnoIndefinido() throws SemCalendarioException{

		TurnoDTO filtro = new TurnoDTO();
		filtro.setTurno(new DwTurno());
		filtro.getTurno().setCdTurno(TurnoRN.CD_TURNO_INDEFINIDO);
		filtro.getTurno().setStAtivo((byte) 1);

		TurnosDTO turnos = this.getTurnosDTO(filtro);

		if(turnos.getTurnos().isEmpty()){
			throw new SemCalendarioException("Turno indefinido n�o encontrado. "
					+ " Verifique se turno indefinido (" + TurnoRN.CD_TURNO_INDEFINIDO + ") está cadastrado e está ativo");
		}

		return turnos.getTurnos().get(0).getTurno();

	}

	/**
	 * Pega o calendário indefinido. Baseado no código {@link #CD_CALENDARIO_INDEFINIDO}
	 * @return
	 * @throws SemCalendarioException se n�o encontrar calendário indefinido
	 */
	public DwCal getCalendarioIndefinido() throws SemCalendarioException{
		
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());

		MapQuery q = new MapQuery(this.getDaoSession());

		q.append("select distinct dwCal");
		q.append("from DwCal dwCal");
		q.append("join fetch dwCal.dwCalsems dwcalsem");
		q.append("where dwCal.cdCal = :cal");
		q.append("and dwCal.stAtivo = :stAtivo");
		q.append("ORDER by dwcalsem.diasemana, dwcalsem.hrInicial");


		q.defineParametro("cal", omcfg.getDwCal().getCdCal());
		q.defineParametro("stAtivo", (byte) 1);

		q.setMaxResults(1);

		DwCal dwCal = (DwCal) q.uniqueResult();

		if(dwCal == null){
			throw new SemCalendarioException("Calendário indefinido n�o encontrado. Verifique se calendário indefinido (" + TurnoRN.CD_TURNO_INDEFINIDO + ") está cadastrado e está ativo");
		}

		return dwCal;

	}

	public DwTurno getDwTurnoPorId(long idTurno){
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("FROM DwTurno turno");
		q.append("WHERE turno.idTurno = :idTurno");
		q.defineParametro("idTurno", idTurno);
		return (DwTurno) q.uniqueResult();
	}


	/**
	 * Pega lista com todos os turnos do dia na ordem.
	 * @param turnoAtualDTO
	 * @return
	 * @see #getTurnosDTODoDia(TurnoAtualDTO, boolean, List)
	 */
	public List<TurnoAtualDTO> getTurnosDTODoDia(TurnoAtualDTO turnoAtualDTO, boolean isConsideraTurnoIndefinido) {

		Long idCal = turnoAtualDTO.getDwcal().getIdCal();
		List<DwCalsem> dwCalsems = getDwCalsems(idCal);

		return getTurnosDTODoDia(turnoAtualDTO, isConsideraTurnoIndefinido, dwCalsems);
	}

	/**
	 * Pega lista com todos os turnos do dia na ordem.
	 * @param turnoAtualDTO
	 * @return
	 * @see #getTurnosDTODoDia(TurnoAtualDTO, boolean
	 */
	public List<TurnoAtualDTO> getTurnosDTODoDia(TurnoAtualDTO turnoAtualDTO, boolean isConsideraTurnoIndefinido, List<DwCalsem> dwCalsems) {
		List<TurnoAtualDTO> lista = new ArrayList<TurnoAtualDTO>();

		// Turnos anteriores
		List<TurnoAtualDTO> listaTurnosAnteriores =  getListaTurnosAnterioresOuPosterioresMesmoDia(true, turnoAtualDTO, dwCalsems, isConsideraTurnoIndefinido);
		lista.addAll(listaTurnosAnteriores);

		lista.add(turnoAtualDTO);

		// Pega os turnos posteriores ao turno atual
		List<TurnoAtualDTO> listaPosteriores =  getListaTurnosAnterioresOuPosterioresMesmoDia(false, turnoAtualDTO, dwCalsems, isConsideraTurnoIndefinido);
		lista.addAll(listaPosteriores);

		return lista;
	}

	private List<TurnoAtualDTO> getListaTurnosAnterioresOuPosterioresMesmoDia(
			boolean isSentidoBuscaAnteriores, TurnoAtualDTO turnoAtualDTO,
			List<DwCalsem> dwCalsems , boolean isConsideraTurnoIndefinido) {

		List<TurnoAtualDTO> lista = new ArrayList<>();
		Date dtReferencia = turnoAtualDTO.getDtReferencia();

		Date dthrAvaliada = (isSentidoBuscaAnteriores ? turnoAtualDTO.getDtHrITurno() : turnoAtualDTO.getDtHrFTurno());

		boolean isTurnoValidoParaLista = false;
		boolean isCdTurnoValido = true;

		// Turno anteriores
		do {

			dthrAvaliada = DataHoraRN.adicionaSegundosNaData(dthrAvaliada, (isSentidoBuscaAnteriores ? - 1: 1));

			TurnoAtualDTO turnoAvaliado = getTurnoAtualDTO(dwCalsems, dthrAvaliada);

			Date dtReferenciaAvaliada = turnoAvaliado.getDtReferencia();

			if (!isConsideraTurnoIndefinido) {
				isCdTurnoValido = !turnoAvaliado.getCdTurno().equals(CD_TURNO_INDEFINIDO);
			}

			isTurnoValidoParaLista = isCdTurnoValido && DataHoraRN.equals(dtReferencia, dtReferenciaAvaliada);

			if (isTurnoValidoParaLista) {

				if (isSentidoBuscaAnteriores) {
					// Adiciona na primeira posição da lista, porque está lendo no sentido das anteriores.
					// Assim, para garantir que a lista seja retornada ordenada pelo DtHrITurno,
					// os turnos são sempre adicionados na primeira posição dela
					lista.add(0, turnoAvaliado);
					dthrAvaliada = turnoAvaliado.getDtHrITurno();
				} else {
					lista.add(turnoAvaliado);
					dthrAvaliada = turnoAvaliado.getDtHrFTurno();
				}
			}
		} while (isTurnoValidoParaLista);

		return lista;

	}

	
	public ListaTurnosDTO getTurnosDTO(FiltroPesquisaDTO filtro) {
		ListaTurnosDTO retorno = new ListaTurnosDTO();
		retorno.setItems(new ArrayList<TurnoDTO2>());
		retorno.setMeta(new MetaDTO(filtro));
		
		MapQuery q = new MapQuery(this.getDaoSession());
		
		q.append("select t ");
		q.append("from DwTurno t ");
		q.append("where t.stAtivo = 1 ");
		
		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")){
			q.append("AND (");
			q.append(" upper(t.cdTurno) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.dsTurno) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");		 
		}
		
		q.append("order by t.cdTurno");
		
		
		List<DwTurno> listaPesquisa = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
		
 		for (DwTurno registro : listaPesquisa) {
 			
 			TurnoDTO2 regDTO = new TurnoDTO2();
 			
 			regDTO.setIdTurno(registro.getIdTurno());
 			regDTO.setCdTurno(registro.getCdTurno());
 			regDTO.setDsTurno(registro.getDsTurno());
 			regDTO.setCor(registro.getCor());
 			regDTO.setStRegistro(registro.getStAtivo().intValue());
 			
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
	public TurnoDTO2 getTurnoByCd(String cdTurno) {
		TurnoDTO2 retorno = new TurnoDTO2();
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select t ");
		q.append("from DwTurno t ");
		q.append("where t.stAtivo = 1 ");
		q.append("AND t.cdTurno = :cdTurno ");
		q.append("order by t.cdTurno");

 		q.defineParametro("cdTurno", cdTurno);

 		List<DwTurno> lista = q.list();
 		
 		if (lista.size() == 1) {
 			
 			retorno.setIdTurno(lista.get(0).getIdTurno());
 			retorno.setCdTurno(lista.get(0).getCdTurno());
 			retorno.setDsTurno(lista.get(0).getDsTurno());
 			retorno.setCor(lista.get(0).getCor());
 			retorno.setStRegistro(lista.get(0).getStAtivo().intValue());
 			
 		}
		
		return retorno;
	}
	

	public DwTurno getDwTurnoPorCodigo(String cdTurno) {
		
		MapQuery q = new MapQuery(this.getDaoSession());
		
		q.append("FROM DwTurno t");
		q.append("where t.stAtivo = 1 ");
		q.append("AND t.cdTurno = :cdTurno ");
		
		q.defineParametro("cdTurno", cdTurno);
		
		return (DwTurno) q.uniqueResult();
		
	}
	
	
	public List<TurnoDTO2> geTurnosCalAtivos() throws SemCalendarioException {
		List<TurnoDTO2> retorno = new ArrayList<TurnoDTO2>(); 

		String strSQL = "";
		SQLQuery q = null;
		
		strSQL = "";
		strSQL = strSQL.concat("SELECT DISTINCT tur.id_turno, tur.cd_turno, tur.ds_turno ");
		strSQL = strSQL.concat("  FROM dw_cal cal ");
		strSQL = strSQL.concat("  JOIN dw_calsem csem ON (csem.id_cal = cal.id_cal) ");
		strSQL = strSQL.concat("  JOIN dw_turno tur ON (tur.id_turno = csem.id_turno) ");
		strSQL = strSQL.concat("  WHERE  cal.st_ativo = 1");
		strSQL = strSQL.concat(" ORDER BY tur.cd_turno"); 
 
		q = this.getDaoSession().createSQLQuery(strSQL);
		
		List<Object> lista = q.list();

		for (Object reg : lista) {
			Object[] registroLido = (Object[]) (Object) reg;
			 			
 			TurnoDTO2 regDTO = new TurnoDTO2();
 			
 			regDTO.setIdTurno(ConversaoTipos.converterParaBigDecimal(registroLido[0]).longValue());
 			regDTO.setCdTurno((String) registroLido[1]);
 			regDTO.setDsTurno((String) registroLido[2]); 
 			
 			retorno.add(regDTO);
 		}
		
		
		return retorno;
	}
}
