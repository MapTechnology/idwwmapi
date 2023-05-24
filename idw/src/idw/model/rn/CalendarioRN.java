package idw.model.rn;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwCalDAO;
import idw.model.dao.MapQuery;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwCalavu;
import idw.model.pojos.DwCalpt;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpPlano;
import idw.model.pojos.template.DwCalsemTemplate;
import idw.model.rn.geraplano.dtos.IdCtDTO;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.CalendarioAvulsoDTO;
import idw.webservices.dto.CalendarioDTO;
import idw.webservices.dto.CalendarioPtsDTO;
import idw.webservices.dto.CalendarioSemanalDTO;
import idw.webservices.dto.CalendarioSemanalFiltroDTO;
import idw.webservices.dto.CalendarioWizardDTO;
import idw.webservices.dto.CalendariosDTO;
import idw.webservices.dto.CalendariosSemanaisDTO;
import idw.webservices.dto.CamposEmUsoOmCfgDTO;
import idw.webservices.rest.idw.v2.dto.CalendarioDTO2;
import idw.webservices.rest.idw.v2.dto.CalendarioPtDTO2;
import idw.webservices.rest.idw.v2.dto.CalendarioTurnoIntervaloDTO;
import idw.webservices.rest.idw.v2.dto.CalendarioTurnoDTO;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.ListaCalendariosDTO;
import idw.webservices.rest.idw.v2.dto.ListaPTsDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;
import idw.webservices.rest.idw.v2.dto.PtDTO2;
import ms.util.ConversaoTipos;


@SuppressWarnings("unchecked")

public class CalendarioRN extends DAOGenerico{
	
	private DAOGenerico dao;
	
	public CalendarioRN(){
	}
	
	public CalendarioRN (DAOGenerico dao){
		this.dao = dao;
	}

	@Override
	public DAOGenerico getDao() {
		return dao;
	}

	@Override
	public void setDao(DAOGenerico dao) {
		this.dao = dao;
	}
	
	/**
	 * Guarda a lista de todos os calendários ativos que possuem registros semanais (DwCalsem) 
	 * <br> Calendários semanais est�o clonados
	 * @return
	 */
	public Map<Long, List<DwCalsem>> getCalendariosSemanaisAtivos(){
		Map<Long, List<DwCalsem>> retorno = new HashMap<Long, List<DwCalsem>>();
		
		// Filtro para apenas os calendários ativos
		CalendarioDTO filtro = new CalendarioDTO();
		filtro.setCalendario(new DwCal());
		filtro.getCalendario().setStAtivo((byte)1);
		
		// Pega lista dos calendários ativos
		List<DwCal> dwCals = getCalendarios(filtro);
		
		TurnoRN turnoRN = new TurnoRN(this.getDao());
		
		// Pega cada calendário, pega os dados do calendário semanal
		for(DwCal dwCal: dwCals){
			
			// Pega lista de calendário com os turnos indefinidos
			List<DwCalsem> dwCalsems;
			try {
				dwCalsems = turnoRN.getCalendarioSemanalComTurnosIndefinidos(dwCal.getIdCal());
				
				// Clona lista de calendário
				dwCalsems = DwCalsemTemplate.cloneDwCalsems(dwCalsems, true);
				
				retorno.put(dwCal.getIdCal(), dwCalsems);

			} catch (SemCalendarioException e) {
				// Se n�o encontrar calendário semanal, n�o inclui na lista
			}

		}
		
		return retorno;
	}
	
	/**
	 * Pega lista de calendários
	 * @param filtro
	 * @return
	 */
	public List<DwCal> getCalendarios(CalendarioDTO filtro) {
		String hql="";
		hql += "select t ";
		hql += "from DwCal t ";
		hql += "where 1=1 ";
		
		if (filtro.getCalendario().getIdCal()!=0){
			hql += "AND t.idCal=::idCal: ";
		}else{
			if (filtro.getCalendario().getCdCal() != null && !filtro.getCalendario().getCdCal().equals("")){
				hql += "AND t.cdCal='::cdCal:' ";
			}
			if (filtro.getCalendario().getDsCal() != null && !filtro.getCalendario().getDsCal().equals("")){
				hql += "AND t.dsCal='::dsCal:' ";
			}
			if (filtro.getCalendario().getDthrFvalidade()!=null){
				hql += "AND t.dthrFvalidade=:dthrFvalidade ";
			}
			if (filtro.getCalendario().getDthrIvalidade()!=null){
				hql += "AND t.dthrIvalidade=:dthrIvalidade ";
			}
			if (filtro.getCalendario().getDtRevisao()!=null){
				hql += "AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF ";
			}
			if (filtro.getCalendario().getOmUsrByIdUsrrevisao() != null && !filtro.getCalendario().getOmUsrByIdUsrrevisao().getCdUsr().equals("")){
				hql += "AND t.omUsrByIdUsrrevisao.cdUsr='::cdUsrRev:' ";
			}
			if (filtro.getCalendario().getOmUsrByIdUsrrevisao() != null && !filtro.getCalendario().getOmUsrByIdUsrrevisao().getDsNome().equals("")){
				hql += "AND t.omUsrByIdUsrrevisao.dsNome='::dsNomeRev:' ";
			}
			if (filtro.getCalendario().getOmUsrByIdUsrstativo() != null && !filtro.getCalendario().getOmUsrByIdUsrstativo().getCdUsr().equals("")){
				hql += "AND t.omUsrByIdUsrstativo.cdUsr='::cdUsrSt:' ";
			}
			if (filtro.getCalendario().getOmUsrByIdUsrstativo() != null && !filtro.getCalendario().getOmUsrByIdUsrstativo().getDsNome().equals("")){
				hql += "AND t.omUsrByIdUsrstativo.dsNome='::dsNomeSt:' ";
			}
			if (filtro.getCalendario().getDtStativo()!=null){
				hql += "AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF ";
			}
			if (filtro.getCalendario().getRevisao()!=null){
				hql += "AND t.revisao=::revisao: ";
			}
			if (filtro.getCalendario().getStAtivo() != null && filtro.getCalendario().getStAtivo()<(byte)2){
				hql += "AND t.stAtivo=::stAtivo: ";
			}
		}

		hql = hql.replaceAll("::idCal:", String.valueOf(filtro.getCalendario().getIdCal()));		
		hql = hql.replaceAll("::cdCal:", filtro.getCalendario().getCdCal());
		hql = hql.replaceAll("::dsCal:", filtro.getCalendario().getDsCal());
		if (filtro.getCalendario().getOmUsrByIdUsrrevisao()!=null){
			hql = hql.replaceAll("::cdUsrRev:", filtro.getCalendario().getOmUsrByIdUsrrevisao().getCdUsr());
			hql = hql.replaceAll("::dsNomeRev:", filtro.getCalendario().getOmUsrByIdUsrrevisao().getDsNome());
		}
		if (filtro.getCalendario().getOmUsrByIdUsrstativo()!=null){
			hql = hql.replaceAll("::cdUsrSt:", filtro.getCalendario().getOmUsrByIdUsrstativo().getCdUsr());
			hql = hql.replaceAll("::dsNomeSt:", filtro.getCalendario().getOmUsrByIdUsrstativo().getDsNome());
		}
		hql = hql.replaceAll("::revisao:", String.valueOf(filtro.getCalendario().getRevisao()));
		hql = hql.replaceAll("::stAtivo:", String.valueOf(filtro.getCalendario().getStAtivo()));

		Query q = getSession().createQuery(hql);

		try {
			q.setTimestamp("dthrFvalidade", filtro.getCalendario().getDthrFvalidade());
		} catch (Exception e) {
			
		}
		try {
			q.setTimestamp("dthrIvalidade", filtro.getCalendario().getDthrIvalidade());
		} catch (Exception e) {
			
		}
		try {
			q.setTimestamp("dtRevisao", filtro.getCalendario().getDtRevisao());
			q.setTimestamp("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getCalendario().getDtRevisao()));
		} catch (Exception e) {
			
		}		
		try {
			q.setTimestamp("dtStativo", filtro.getCalendario().getDtStativo());
			q.setTimestamp("dtStativoF",DataHoraRN.getDataHora235959(filtro.getCalendario().getDtStativo()));
		} catch (Exception e) {
			
		}

		return q.list();
		
	}
	
	/**Método para pesquisar calendariosDTO no banco de dados pelo {@link CalendarioRN#getCalendarios(CalendarioDTO)}
	 * <br> Carrega também lista com os postos de trabalho que usam os caledários do filtro {@code DwCalPt}
	 * @param filtro - Objeto com as informações que deseja filtrar para a pesquisa
	 * @return CalendariosDTO - Lista contendo objetos calendario da pesquisa realizada
	 * @see CalendarioRN#getCalendarios(CalendarioDTO)
	 */
	public CalendariosDTO getCalendariosDTO(CalendarioDTO filtro){

		IdwLogger log = new IdwLogger("CalendarioRN");
		int idLog = log.getIdAleatorio();
		
		log.iniciaAvaliacao("getCalendarios");
		List<DwCal> listaPesquisa = null;
		try{
			listaPesquisa = getCalendarios(filtro);
		} catch (Exception e){
			e.printStackTrace();
		}
		log.mostrarAvaliacaoCompleta();

		List<CalendarioDTO> lista = new ArrayList<>();

		if (listaPesquisa != null){
			log.iniciaAvaliacao("clone qt " + listaPesquisa.size());
			log.info(idLog, 0, "clone qt " + listaPesquisa.size());
			for (DwCal item : listaPesquisa) {
				CalendarioDTO itemDTO = new CalendarioDTO();								
				itemDTO.setCalendario((DwCal)item.clone(false));
				itemDTO.getCalendario().setOmUsrByIdUsrrevisao(item.getOmUsrByIdUsrrevisao().clone(false));
				itemDTO.getCalendario().setOmUsrByIdUsrstativo(item.getOmUsrByIdUsrstativo().clone(false));
				
				//DwCalPts
				itemDTO.setCalendarioPts(new CalendarioPtsDTO());
				
				// Alessandre em 15-03-19 para melhorar a performance o clone abaixo foi comentado. Ao selecionar a pesaquisa na GUI deve-se pesqueisar os pts
//				itemDTO.getCalendarioPts().setPts(new ArrayList<DwCalpt>());
//				log.info(idLog, 5, item.getCdCal() + " - qt de pts do cal " + item.getDwCalpts().size());
//				for (DwCalpt itemList : item.getDwCalpts()) {
//					if (itemList.getOmPt().getStAtivo().equals((byte) 0) )
//						continue;
//					log.info(idLog, 10, "clone pt " + itemList.getOmPt().getCdPt());
//					DwCalpt clone = itemList.clone(false);
//					clone.setOmPt(itemList.getOmPt().clone(false));
//					itemDTO.getCalendarioPts().getPts().add((DwCalpt)clone);
//				}				
//				
				itemDTO.setResultadoEvento(0);
				lista.add(itemDTO);
			}
			log.mostrarAvaliacaoCompleta();
		}

		CalendariosDTO dtoRetorno = new CalendariosDTO();
		dtoRetorno.setCalendarios(lista);
		return dtoRetorno;
	}
	
	/**Metodo para pesquisar os calendariosSemanaisDTO no banco de dados
	 * @param filtro - Objeto com as informações que deseja filtrar para a pesquisa
	 * @returnn CalendariosSemanaisDTO - Lista contendo objetos calendario da pesquisa realizada
	 */
	public CalendariosSemanaisDTO getCalendariosSemanaisDTO(CalendarioSemanalFiltroDTO filtro){

		CalendariosSemanaisDTO calendariosSemanaisRetorno = new CalendariosSemanaisDTO();
		calendariosSemanaisRetorno.setCalendariosSemanais(new ArrayList<CalendarioSemanalDTO>());
		
		MapQuery q = new MapQuery(getSession());
		q.append("select t ");
		q.append("from DwCalsem t ");		
		q.append("where t.dwCal.idCal=:idCal ");
		
		q.defineParametro("idCal", filtro.getIdCal());
		
		List<DwCalsem> lista = null;
		try{
			lista = q.list();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		if (lista != null){
			q.novaConsulta();
			q.append("select t ");
			q.append("from DwCalavu t ");
			q.append("where t.dwCalsem.idCalsem=:idCalsem");
			q.append("and t.dtAvulso between :dtIAvulso and :dtFAvulso");

			for (DwCalsem item : lista){
				CalendarioSemanalDTO calendarioSemanal = new CalendarioSemanalDTO();
				calendarioSemanal.setCalendarioSemanal((DwCalsem)item.clone());
				calendarioSemanal.setVirtual(false);
				
				/* Alessandre: em 09-04-15 desativei esse trecho pois nao entendi a necessidade dele, visto que apos o final do loop do calendario semanal
				 * existe um loop para o avulso. Sera que eh um requerimento o avulso estar associado ao semanal?
				 * Eh requisito o avulso estar dentro do semanal para a GUI mostrar corretamente
				 * Entretanto alterei o trecho abaixo para prever mais de um dwcalavu e nao somente 1
				 */
				
				q.defineParametro("idCalsem", item.getIdCalsem());
				
				try{
					q.defineParametroTimestamp("dtIAvulso", filtro.getDthrICalendario());
				}catch (Exception e){
					e.printStackTrace();
				}
				
				try{
					q.defineParametroTimestamp("dtFAvulso", filtro.getDthrFCalendario());
				}catch (Exception e){
					e.printStackTrace();
				}
				
				DwCalavu dwCalavu = null;
				q.setMaxResults(1);
				try{
					dwCalavu = (DwCalavu) q.uniqueResult();
				}catch (Exception e){
					e.printStackTrace();
				}
				if (dwCalavu != null){
					CalendarioAvulsoDTO calendarioAvulso = new CalendarioAvulsoDTO();
					calendarioAvulso.setCalendarioAvulso((DwCalavu)dwCalavu.clone());
					
					calendarioSemanal.setCalendarioAvulso(calendarioAvulso);
				}
				
				calendariosSemanaisRetorno.getCalendariosSemanais().add(calendarioSemanal);
			}
		}
		
		q.novaConsulta();
		q.append("select t ");
		q.append("from DwCalavu t ");
		q.append("where t.dwCal.idCal = :idCal");
		q.append("and t.dwCalsem.idCalsem = null ");
		q.append("and t.dtAvulso between :dtIAvulso and :dtFAvulso");
		
		q.defineParametro("idCal", filtro.getIdCal());
		
		try{
			q.defineParametroTimestamp("dtIAvulso", filtro.getDthrICalendario());
		}catch (Exception e){
			e.printStackTrace();
		}
		
		try{
			q.defineParametroTimestamp("dtFAvulso", filtro.getDthrFCalendario());
		}catch (Exception e){
			e.printStackTrace();
		}
		
		List<DwCalavu> listaAvu = null;
		try{
			listaAvu = q.list();
		}catch (Exception e){
			e.printStackTrace();
		}
		if (listaAvu != null){
			for (DwCalavu item : listaAvu){
				DwCalavu dwCalavu = (DwCalavu) item.clone();
				DwCalsem dwCalsem = new DwCalsem();
				dwCalsem.setDwCal(dwCalavu.getDwCal());
				dwCalsem.setDwTurno(dwCalavu.getDwTurno());
				dwCalsem.setHrFinal(dwCalavu.getHrFinal());
				dwCalsem.setHrFinalGui(dwCalavu.getHrFinalGui());
				dwCalsem.setHrInicial(dwCalavu.getHrinicial());
				dwCalsem.setHrInicialGui(dwCalavu.getHrInicialGui());
				dwCalsem.setIsFimturno(dwCalavu.getIsFimturno());
				dwCalsem.setIsInicioturno(dwCalavu.getIsFimturno());
				dwCalsem.setSegTempocalendario(dwCalavu.getSegTempocalendario());
				dwCalsem.setSegTempocalsempeso(dwCalavu.getSegTempocalsempeso());
				dwCalsem.setSegToleranciapos(dwCalavu.getSegToleranciapos());
				dwCalsem.setSegToleranciapre(dwCalavu.getSegToleranciapre());
				dwCalsem.setTpDtreferencia(dwCalavu.getTpDtreferencia());
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(dwCalavu.getDtAvulso());
				dwCalsem.setDiasemana(BigDecimal.valueOf(calendar.get(Calendar.DAY_OF_WEEK)-1));				
				
				CalendarioSemanalDTO calendarioSemanal = new CalendarioSemanalDTO();
				calendarioSemanal.setCalendarioSemanal(dwCalsem);
				calendarioSemanal.setVirtual(true);
				
				CalendarioAvulsoDTO calendarioAvulso = new CalendarioAvulsoDTO();
				calendarioAvulso.setCalendarioAvulso(dwCalavu);
				
				calendarioSemanal.setCalendarioAvulso(calendarioAvulso);
				
				calendariosSemanaisRetorno.getCalendariosSemanais().add(calendarioSemanal);
			}
			
		}
		
		ordenaCalendariosSemanais(calendariosSemanaisRetorno);
		
		return calendariosSemanaisRetorno;
		
	}
	
	/**Método para ordena os calendarios semanais passados como parametro
	 * @param calendariosSemanais - lista de calendários semanais
	 */
	private void ordenaCalendariosSemanais(CalendariosSemanaisDTO calendariosSemanais){
		Comparator<CalendarioSemanalDTO> comparator = new Comparator<CalendarioSemanalDTO>() {
            @Override
			public int compare(CalendarioSemanalDTO p1, CalendarioSemanalDTO p2) {
                
            	int retorno;
            	if (p1.getCalendarioSemanal().getDiasemana().byteValue() < p2.getCalendarioSemanal().getDiasemana().byteValue()){
            		retorno = -1;
            	}else if (p1.getCalendarioSemanal().getDiasemana().byteValue() > p2.getCalendarioSemanal().getDiasemana().byteValue()){ 
            		retorno = +1;
            	}else if (p1.getCalendarioSemanal().getHrInicial().longValue() < p2.getCalendarioSemanal().getHrInicial().longValue()){
            		retorno = -1;
            	}else if (p1.getCalendarioSemanal().getHrInicial().longValue() > p2.getCalendarioSemanal().getHrInicial().longValue()){
            		retorno = +1;
            	}else{
            		retorno = 0;
            	}
            	
            	return retorno;
            }
        };
        
        Collections.sort(calendariosSemanais.getCalendariosSemanais(), comparator);
	}

	/**Método para salvar no banco de dados o objeto calendarioDTO
	 * @param calendarioParametroDTO - Objeto calendarioDTO com as informações que deseja salvar no banco de dados
	 * @return CalendarioDTO - Objeto com as informações salva no banco
	 */
	public CalendarioDTO setCalendarioDTO(CalendarioDTO calendarioParametroDTO){
		
		CalendarioDTO retorno = new CalendarioDTO();
		retorno.setResultadoEvento(retorno.getEVENTO_BEM_SUCEDIDO());

		if (calendarioParametroDTO.getCalendario() == null || calendarioParametroDTO.getCalendario().getCdCal() == null || calendarioParametroDTO.getCalendario().getCdCal().trim().equals("")){
			retorno.setResultadoEvento(retorno.getERRO_CDCALENDARIO_INVALIDO());
			return retorno;
		}

		retorno.setResultadoEvento(validaCalendario(calendarioParametroDTO, retorno));
		if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()){
			if (retorno.getCalendario() == null)
				retorno.setCalendario(calendarioParametroDTO.getCalendario());
			return retorno;
		}

		DwCalDAO dao = new DwCalDAO(getSession());

		DwCal pojoNovo = null;
		DwCal pojoPesquisado = null;
		
		if(calendarioParametroDTO.getCalendario().getIdCal()!=0){
			pojoPesquisado = dao.getDwCalPorId(calendarioParametroDTO.getCalendario().getIdCal());
			if (pojoPesquisado != null && pojoPesquisado.getStAtivo() != null && pojoPesquisado.getStAtivo().equals((byte) 0)) {
				retorno.setResultadoEvento(retorno.getERRO_REATIVACAO_INDISPONIVEL());
				return retorno;
			}
		} else {
			// Nesse caso avaliar se o codigo do calendario ja existe
			pojoPesquisado = dao.getDwCalPorCdAtivo(calendarioParametroDTO.getCalendario().getCdCal());
			if (pojoPesquisado != null) {
				retorno.setResultadoEvento(retorno.getERRO_CALENDARIO_JA_EXISTE());
				return retorno;
			}
		}

		// Se encontrou o calendario, desativa-lo
		long revisao = 1l;
		if (pojoPesquisado != null){
			// Desativa idCal antivo
			pojoPesquisado.setStAtivo((byte)0);
			getSession().saveOrUpdate(pojoPesquisado);
			revisao = pojoPesquisado.getRevisao() + 1;
		}
		
		pojoNovo = new DwCal();
		pojoNovo.copy(calendarioParametroDTO.getCalendario(), true);
		pojoNovo.setIdCal(0l);
		pojoNovo.setRevisao(revisao);
		pojoNovo.setDtRevisao(new Date());
		pojoNovo.setStAtivo((byte)1);
		pojoNovo.setDtStativo(new Date());

		//DwCalPts
		pojoNovo.setDwCalpts(new HashSet<DwCalpt>());

		if (calendarioParametroDTO.getCalendarioPts() != null && calendarioParametroDTO.getCalendarioPts().getPts() != null){
			for (DwCalpt dwcalpt : calendarioParametroDTO.getCalendarioPts().getPts()) {
				dwcalpt.setIdCalpt(0);
				dwcalpt.setStAtivo((byte) 1);
				dwcalpt.setDthrStativo(DataHoraRN.getDataHoraAtual());
				
				if (dwcalpt.getDthrivalidade() == null)
					dwcalpt.setDthrivalidade(DataHoraRN.getDataHoraAtual());
				
				dwcalpt.setDwCal(pojoNovo);			
				
				try {
					PTRN ptRN = new PTRN();
					ptRN.getDao().setSession(getSession());
						
					OmPt omPt = ptRN.getOmPtById(dwcalpt.getOmPt().getIdPt()).clone(false);
					dwcalpt.setOmPt(omPt);
				} catch (Exception e) {
					e.printStackTrace();
				}			
					
				pojoNovo.getDwCalpts().add(dwcalpt);
			}	
		}

		//DwCalsems
		if (calendarioParametroDTO.getCalendariosSemanais() != null && calendarioParametroDTO.getCalendariosSemanais().getCalendariosSemanais() != null){
			pojoNovo.setDwCalsems(new HashSet<DwCalsem>());
			pojoNovo.setDwCalavus(new HashSet<DwCalavu>());

			for (CalendarioSemanalDTO semanalParametroDTO : calendarioParametroDTO.getCalendariosSemanais().getCalendariosSemanais()){
				DwCalsem dwcalsem = semanalParametroDTO.getCalendarioSemanal(); 
				dwcalsem.setIdCalsem(0);
				dwcalsem.setDwCal(pojoNovo);

				DwCalavu dwcalavu = null;
				if (semanalParametroDTO.getCalendarioAvulso() != null && semanalParametroDTO.getCalendarioAvulso().getCalendarioAvulso() != null) {
					dwcalavu = semanalParametroDTO.getCalendarioAvulso().getCalendarioAvulso();
					if (dwcalavu != null) {
						dwcalavu.setIdCalavu(0l);
						dwcalavu.setDwCal(pojoNovo);
						dwcalavu.setDwCalsem(dwcalsem);
						pojoNovo.getDwCalavus().add(dwcalavu);
					}
				}				
				pojoNovo.getDwCalsems().add(dwcalsem);
			}
		}
		
			
		UsuarioRN ususarioRN = new UsuarioRN();
		ususarioRN.getDao().setSession(getSession());

		OmUsr usuarioStAtivo = ususarioRN.getUsuarioByCdEStAtivo(calendarioParametroDTO.getCalendario().getOmUsrByIdUsrstativo().getCdUsr()).clone(false);

		pojoNovo.setOmUsrByIdUsrrevisao(usuarioStAtivo);
		pojoNovo.setOmUsrByIdUsrstativo(usuarioStAtivo);

		getSession().saveOrUpdate(pojoNovo);
		
		retorno.setCalendario((DwCal) pojoNovo.clone());
 
		return retorno;
	}	

	/**Método para remover lista de calendarios do banco de dados
	 * @param itensDTO - lista de objetos que deseja remover do banco de dados
	 * @return CalendariosDTO - lista de objetos que foram removidos do banco de dados
	 */
	public CalendariosDTO removeCalendariosDTO(CalendariosDTO itensDTO){

		CalendariosDTO itensRetorno = new CalendariosDTO();
		
		
		//17/03/2017 Alex: nao remover codigo em uso na configuracao geral.
		CamposEmUsoOmCfgDTO camposEmUsoOmCfgDTO = getCamposEmUsoOmCfg(itensDTO);
		itensRetorno.setCamposEmUsoOmCfg(camposEmUsoOmCfgDTO);
		if(camposEmUsoOmCfgDTO.getStatus() != camposEmUsoOmCfgDTO.getSTATUS_NENHUM_CAMPO_EM_USO()) {
			//se entrar nesse if eh pq existe algum codigo em uso
			return itensRetorno;
		}
		
		
		List<CalendarioDTO> listaRetorno = new ArrayList<CalendarioDTO>();
		for (CalendarioDTO item : itensDTO.getCalendarios()){
			CalendarioDTO itemRetorno = new CalendarioDTO();
			String hql = "";

			hql = "from DwCal t where t.idCal = ::idCal";
			hql = hql.replaceAll("::idCal", String.valueOf(item.getCalendario().getIdCal()));

			Query q = getSession().createQuery(hql);

			DwCal itemOriginal = (DwCal) q.uniqueResult();

			if (itemOriginal == null){			
				itemRetorno.setResultadoEvento(itemRetorno.getERRO_CDCALENDARIO_INVALIDO());
				itemRetorno.setCalendario(item.getCalendario());				
			}else if (itemOriginal.getStAtivo()==0){			
				itemRetorno.setResultadoEvento(itemRetorno.getERRO_CDCALENDARIO_INVALIDO());
				itemRetorno.setCalendario((DwCal)itemOriginal.clone());				
			}else{
				
				if(itemOriginal.getDthrFvalidade() == null){
					itemRetorno.setResultadoEvento(itemRetorno.getERRO_EXISTE_CALENDARIO_EM_ABERTO());
					itensRetorno.setCalendarios(new ArrayList<CalendarioDTO>());
					itensRetorno.getCalendarios().add(itemRetorno);
					return itensRetorno;
				}
				
				itemOriginal.setStAtivo((byte)0);
				itemOriginal.setDtStativo(new Date());				

				try{
					itemOriginal = (DwCal) makePersistent(itemOriginal);			
				} catch (Exception e){
					e.printStackTrace();
				}				

				itemRetorno.setCalendario((DwCal)itemOriginal.clone());
				
				itemRetorno.setResultadoEvento(0);
			}									

			listaRetorno.add(itemRetorno);
		}

		itensRetorno.setCalendarios(listaRetorno);
		return itensRetorno;
	}
	
	private CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg(CalendariosDTO itens) {
		OmCfg omcfg = Util.getConfigGeral(getSession());
		
		//campos
		DwCal calendarioEmUso = omcfg.getDwCal();
		
		CamposEmUsoOmCfgDTO camposEmUsoOmCfg = new CamposEmUsoOmCfgDTO();
		boolean isTemCodigoEmUso = false;
		for(CalendarioDTO item: itens.getCalendarios()) {
			camposEmUsoOmCfg.setCodigo(item.getCalendario().getCdCal());
			
			if(calendarioEmUso != null) {
				if(item.getCalendario().getCdCal().equals(calendarioEmUso.getCdCal())) {
					camposEmUsoOmCfg.setCalendario(true);
					isTemCodigoEmUso = true;
				}
			}
			
		}
		
		if(isTemCodigoEmUso) {
			
			if(itens.getCalendarios() != null && itens.getCalendarios().size() > 1) {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_EXCLUSAO_ABORTADA());
			} else {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_TEM_CAMPO_EM_USO());
			}
			
		} else {
			camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_NENHUM_CAMPO_EM_USO());
		}
		
		return camposEmUsoOmCfg;
	}
	
	/**Método para validar as informações do calendarioPts
	 * @param calendarioPts - Objeto com as informações do calendarioPts que deseja validar
	 * @return CalendarioPtsDTO - Objeto com informações do calendarioPts validado ou n�o
	 */
	@Deprecated
	public CalendarioPtsDTO validarCalendarioPts(CalendarioPtsDTO calendarioPts){
		String hql;
		CalendarioPtsDTO calendarioPtsDTO = new CalendarioPtsDTO();
		calendarioPtsDTO.setResultadoEvento(calendarioPtsDTO.getEVENTO_BEM_SUCEDIDO());		
		calendarioPtsDTO.setPts(new ArrayList<DwCalpt>());
		
		for (DwCalpt dwCalpt : calendarioPts.getPts()) {
			calendarioPtsDTO.getPts().add(dwCalpt);
		}
		
		for (DwCalpt dwCalpt : calendarioPtsDTO.getPts()) {					
			//Verifica se o posto de trabalho existe			
			try {
				hql = "from OmPt t where t.idPt = ::idPt and t.stAtivo = 1";
				hql = hql.replaceAll("::idPt", String.valueOf(dwCalpt.getOmPt().getIdPt()));

				Query q = getSession().createQuery(hql);

				q.list().get(0);
					
			} catch (Exception e) {
				calendarioPtsDTO.setResultadoEvento(calendarioPtsDTO.getERRO_PT_DESCONHECIDO());				
				break;
			}						
		}
				
		return calendarioPtsDTO;			
		
	}
	
	/**Método para carregar as informações do calendarioWizard nos calendariosSemanais
	 * @param wizard - Objeto com as informações do calendarioWizard
	 * @return CalendariosSemanaisDTO - Objeto com as informações do calendarioWizard carregadas
	 */
	public CalendariosSemanaisDTO wizardCalendario(CalendarioWizardDTO wizard){
		CalendariosSemanaisDTO calendariosSemanaisRetorno = new CalendariosSemanaisDTO();
		calendariosSemanaisRetorno.setCalendariosSemanais(new ArrayList<CalendarioSemanalDTO>());
		
		calendariosSemanaisRetorno.setResultadoEvento(validaWizard(wizard));
		
		if (calendariosSemanaisRetorno.getResultadoEvento() != calendariosSemanaisRetorno.getEVENTO_BEM_SUCEDIDO()){
			return calendariosSemanaisRetorno;
		}
		
		String strHoraAnteriorAFinal = null;
		double intervaloInicial = wizard.getIntervalo();
		double intervaloFinal = wizard.getIntervalo();
		
		int segHorarioInicioAux = wizard.getHrInicioTurno().intValue(); 
		if(!DataHoraRN.formatSegundosParaHHMM(segHorarioInicioAux).substring(3, 5).equals("00")){
			int horaInicio = Integer.parseInt(DataHoraRN.formatSegundosParaHHMM(segHorarioInicioAux).substring(0, 2));
			int proximaHora = horaInicio + 1; 
			int segProximaHora = proximaHora * 3600;
			int segFaltaParaProximaHora = segProximaHora - segHorarioInicioAux;
			intervaloInicial = segFaltaParaProximaHora;
		}
		
		int segHorarioFinalAux = wizard.getHrFinalTurno().intValue();
		if(!DataHoraRN.formatSegundosParaHHMM(wizard.getHrFinalTurno().intValue()).substring(3, 5).equals("00")){
			int horaFim = Integer.parseInt(DataHoraRN.formatSegundosParaHHMM(segHorarioFinalAux).substring(0, 2));
			int horaAnterior = horaFim - 1;
			if(String.valueOf(horaAnterior).length() == 1){
				strHoraAnteriorAFinal = "0" + horaAnterior;
			}else{
				strHoraAnteriorAFinal = String.valueOf(horaAnterior);
			}
			int segHoraAnterior = horaAnterior * 3600;
			int segFaltaParaHoraFinal = segHorarioFinalAux - segHoraAnterior;
			intervaloFinal = segFaltaParaHoraFinal;
		}
		
		for (int diaSemana : wizard.getDiasSemana()){
			BigDecimal horaAuxiliar = wizard.getHrInicioTurno();
			double intervalo = wizard.getIntervalo();
			int ordem = 1;
			
			boolean isVirouODia = false;
			boolean isPrecisaVirarODia = wizard.getHrFinalTurno().doubleValue() < wizard.getHrInicioTurno().doubleValue();
			
			while (horaAuxiliar.doubleValue() != wizard.getHrFinalTurno().doubleValue()){
				DwCalsem dwCalsem = new DwCalsem();
				dwCalsem.setDiasemana(BigDecimal.valueOf(diaSemana));
				dwCalsem.setOrdem(ordem++);
				dwCalsem.setHrInicial(horaAuxiliar);
				String duracaoHrInicial = DataHoraRN.formatSegundosParaHHMM(dwCalsem.getHrInicial().intValue());
				dwCalsem.setHrInicialGui(duracaoHrInicial);
				dwCalsem.setSegTempocalsempeso(BigDecimal.valueOf(0));
				dwCalsem.setSegToleranciapre(BigDecimal.valueOf(0));
				dwCalsem.setSegToleranciapos(BigDecimal.valueOf(0));
				dwCalsem.setIsInicioturno(false);
				dwCalsem.setIsFimturno(false);
				dwCalsem.setDwTurno(wizard.getTurno());
				
				if (horaAuxiliar.doubleValue() == wizard.getHrInicioTurno().doubleValue()){
					dwCalsem.setSegToleranciapre(wizard.getPreTolerancia());
					dwCalsem.setIsInicioturno(true);			
					/*if(horaAuxiliar.doubleValue() == 24*3600){
						horaAuxiliar = BigDecimal.valueOf(horaAuxiliar.doubleValue() - 24*3600);
						dwCalsem.setHrInicial(horaAuxiliar);
						dwCalsem.setHrInicialGui(DataHoraRN.formatSegundosParaHHMM(dwCalsem.getHrInicial().intValue()));
					}*/
				}
				
				if (wizard.getTpReferencia() == 0){
					if (horaAuxiliar.doubleValue() < wizard.getHrInicioTurno().doubleValue()){
						dwCalsem.setTpDtreferencia((byte)2);
					}else{
						dwCalsem.setTpDtreferencia((byte)0);
					}
				}
				if (wizard.getTpReferencia() == 1){
					if (horaAuxiliar.doubleValue() < wizard.getHrInicioTurno().doubleValue()){
						dwCalsem.setTpDtreferencia((byte)0);
					}else{
						dwCalsem.setTpDtreferencia((byte)1);
					}
				}
				if (wizard.getTpReferencia() == 2){
					dwCalsem.setTpDtreferencia((byte)2);					
				}			
				
				if(!DataHoraRN.formatSegundosParaHHMM(segHorarioInicioAux).substring(3, 5).equals("00") && ordem == 2){
					wizard.setIntervalo(intervaloInicial);
				}
				if(!DataHoraRN.formatSegundosParaHHMM(segHorarioFinalAux).substring(3, 5).equals("00") && 
						DataHoraRN.formatSegundosParaHHMM(horaAuxiliar.intValue()).substring(0, 2).equals(strHoraAnteriorAFinal)){
					wizard.setIntervalo(intervaloFinal);
				}
				
				horaAuxiliar = BigDecimal.valueOf(horaAuxiliar.doubleValue() + wizard.getIntervalo());
				if (horaAuxiliar.doubleValue() > 24*3600){
					horaAuxiliar = BigDecimal.valueOf(horaAuxiliar.doubleValue() - 24*3600);
					isVirouODia = true;
				} else  if (horaAuxiliar.doubleValue() > wizard.getHrFinalTurno().doubleValue())
					if (isPrecisaVirarODia == false || (isPrecisaVirarODia == true && isVirouODia == true) )
						horaAuxiliar = wizard.getHrFinalTurno();
				
				dwCalsem.setHrFinal(horaAuxiliar);
				String duracaoHrFinal = DataHoraRN.formatSegundosParaHHMM(dwCalsem.getHrFinal().intValue());
				dwCalsem.setHrFinalGui(duracaoHrFinal);
				dwCalsem.setSegTempocalendario(BigDecimal.valueOf(dwCalsem.getHrFinal().intValue() - dwCalsem.getHrInicial().intValue()));
				
				if (horaAuxiliar.doubleValue() == wizard.getHrFinalTurno().doubleValue()){
					dwCalsem.setSegToleranciapos(wizard.getPosTolerancia());
					dwCalsem.setIsFimturno(true);
				}
				
				if((dwCalsem.getIsFimturno()==false) && (horaAuxiliar.doubleValue() == 24*3600)){
					horaAuxiliar = BigDecimal.valueOf(horaAuxiliar.doubleValue() - 24*3600);
					if (horaAuxiliar.doubleValue() == wizard.getHrFinalTurno().doubleValue()){
						dwCalsem.setSegToleranciapos(wizard.getPosTolerancia());
						dwCalsem.setIsFimturno(true);
					}
				}
				
				wizard.setIntervalo(intervalo);
				
				CalendarioSemanalDTO calendarioSemanal = new CalendarioSemanalDTO();
				calendarioSemanal.setCalendarioSemanal(dwCalsem);
				
				calendariosSemanaisRetorno.getCalendariosSemanais().add(calendarioSemanal);				
				
			}
		}
		
		return calendariosSemanaisRetorno;
	}
	
	/**Método para validar o calendarioWizard
	 * @param wizard - Objeto com as informações do calendario Wizard
	 * @return int - retornar situa��oo de erro ou de sucesso da valida��oo.
	 */
	private int validaWizard(CalendarioWizardDTO wizard){
		CalendariosSemanaisDTO calendariosSemanaisRetorno = new CalendariosSemanaisDTO();
		
		//Valida a duracao do turno
		double duracaoTurno = wizard.getHrFinalTurno().doubleValue() - wizard.getHrInicioTurno().doubleValue();
		if (wizard.getHrFinalTurno().doubleValue() < wizard.getHrInicioTurno().doubleValue()){
			duracaoTurno += 24*3600; 				
		}
		if ( (int) duracaoTurno != (int)wizard.getDuracao() ) {
			return calendariosSemanaisRetorno.getERRO_DURACAO_INVALIDA();
		}
		
		//Valida a existencia do turno
		try {
			TurnoRN turnoRN = new TurnoRN();
			turnoRN.setDaoSession(getSession());
			DwTurno turno = turnoRN.getDwTurnoPorId(wizard.getTurno().getIdTurno());
			if(turno == null) {
				return calendariosSemanaisRetorno.getERRO_TURNO_DESCONHECIDO();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return calendariosSemanaisRetorno.getERRO_TURNO_DESCONHECIDO();
		}		
		
		//Valida os dias da semana
		if (wizard.getDiasSemana() != null){
			for (int diaSemana : wizard.getDiasSemana()){
				if (diaSemana < 0 || diaSemana > 6){
					return calendariosSemanaisRetorno.getERRO_DIASEMANA_INVALIDO();
				}
			}
		}else{
			return calendariosSemanaisRetorno.getERRO_DIASEMANA_INVALIDO();
		}
		
		//Valida os hor�rios de inicio e fim
		if (wizard.getHrInicioTurno().doubleValue() < 0 || wizard.getHrInicioTurno().doubleValue() > 86400){
			return calendariosSemanaisRetorno.getERRO_INICIOTURNO_INVALIDO();
		}
		if (wizard.getHrFinalTurno().doubleValue() < 0 || wizard.getHrFinalTurno().doubleValue() > 86400){
			return calendariosSemanaisRetorno.getERRO_FIMTURNO_INVALIDO();
		}
		
		//Valida intervalo de quebra da hora
		if (wizard.getIntervalo() <= 0 || wizard.getIntervalo() > wizard.getDuracao()){
			return calendariosSemanaisRetorno.getERRO_INTERVALO_INVALIDO();
		}
//		if (wizard.getDuracao() % wizard.getIntervalo() > 0 ){
//			return calendariosSemanaisRetorno.getERRO_INTERVALOMULTIPLO_DURACAO();
//		}
		
		//Valida toler�ncias
		if (wizard.getPosTolerancia().doubleValue() < 0 || wizard.getPreTolerancia().doubleValue() < 0 || wizard.getPosTolerancia().doubleValue() > wizard.getDuracao() || wizard.getPosTolerancia().doubleValue() > wizard.getDuracao()){
			return calendariosSemanaisRetorno.getERRO_TOLERANCIA_INVALIDA();
		}
		
		//Valida tipo da referencia
		if (wizard.getTpReferencia() < 0 || wizard.getTpReferencia() > 2){
			return calendariosSemanaisRetorno.getERRO_TPREFERENCIA_INVALIDA();
		}
		
		return calendariosSemanaisRetorno.getEVENTO_BEM_SUCEDIDO();
	}
	
	private String getChave(CalendarioSemanalDTO dto) {
		try {
			String chave = String.valueOf(dto.getCalendarioSemanal().getDiasemana().intValue());
			chave += "|";
			chave += dto.getCalendarioSemanal().getHrInicialGui();
			chave += "|";
			chave += dto.getCalendarioSemanal().getHrFinalGui();
			return chave;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "";		
	}
	
	private void removerLinhasIguais(CalendarioDTO calendario) {
		List<CalendarioSemanalDTO> novaListaSemDuplicado = new ArrayList<CalendarioSemanalDTO>();
		String ultimoHorarioAvaliado = "";
		for (CalendarioSemanalDTO dto : calendario.getCalendariosSemanais().getCalendariosSemanais()) {
			String horarioAvaliado = getChave(dto);
			
			if(horarioAvaliado.equals(ultimoHorarioAvaliado)) {
				continue;
			} else {
				ultimoHorarioAvaliado = horarioAvaliado;
				novaListaSemDuplicado.add(dto);
			}
		}
		calendario.getCalendariosSemanais().setCalendariosSemanais(novaListaSemDuplicado);
	}
	
	/**Método para validar o calendarioDTO
	 * @param calendario - Objeto com as informações do calendario para valida��oo
	 * @return int - retornar situa��oo de erro ou de sucesso da valida��oo.
	 */
	private int validaCalendario(CalendarioDTO calendario, CalendarioDTO dtoRetorno){
		CalendarioDTO retorno = new CalendarioDTO();
		
		
		boolean isExisteDataInicioValidade = calendario.getCalendario().getDthrIvalidade() != null;
		if(isExisteDataInicioValidade == false){
			return retorno.getERRO_DATAINICIAL_INVALIDA();
		}
		
		
		boolean isExisteDataFimValidade = calendario.getCalendario().getDthrFvalidade() != null;
		if(isExisteDataFimValidade) {
			
			boolean isDataInicioValidadeMenorQueDataFimValidade =
					calendario.getCalendario().getDthrIvalidade() != null &&
					calendario.getCalendario().getDthrFvalidade() != null &&
					calendario.getCalendario().getDthrIvalidade().getTime() < calendario.getCalendario().getDthrFvalidade().getTime();
			if (isDataInicioValidadeMenorQueDataFimValidade == false){
				return retorno.getERRO_DATAFINAL_INFERIOR();
			}
			
		}
		
		
		boolean isPossuiCalendarioSemanal = 
				calendario != null &&
				calendario.getCalendariosSemanais() != null &&
				calendario.getCalendariosSemanais().getCalendariosSemanais() != null &&
				calendario.getCalendariosSemanais().getCalendariosSemanais().size() > 0;
		if(isPossuiCalendarioSemanal == false) {
			return retorno.getEVENTO_BEM_SUCEDIDO();
		}
		
		
		// Se nao veio calendario semanais entao inicializa o vetor com nada
		if (calendario.getCalendariosSemanais() == null || calendario.getCalendariosSemanais().getCalendariosSemanais() == null) {
			calendario.setCalendariosSemanais(new CalendariosSemanaisDTO());
			calendario.getCalendariosSemanais().setCalendariosSemanais(new ArrayList<CalendarioSemanalDTO>());
		}
		ordenaCalendariosSemanais(calendario.getCalendariosSemanais());
		
		
		int indiceDoPrimeiroInicioDeTurno = getIndiceDoPrimeiroInicioDeTurno(calendario);		
		boolean isNaoPossuiInicioDeTurno = indiceDoPrimeiroInicioDeTurno == -1;
		if(isNaoPossuiInicioDeTurno) {
			return retorno.getERRO_INICIOTURNO_SEM_FIM_ANTERIOR();
		}
		
		removerLinhasIguais(calendario);
		
		// Avaliar se existe intersecao de horario		
		int diaSemana = -1;
		BigDecimal hrinicial = null;
		for (CalendarioSemanalDTO dto : calendario.getCalendariosSemanais().getCalendariosSemanais()) {			
			if (diaSemana == -1) {
				diaSemana = dto.getCalendarioSemanal().getDiasemana().intValue();
			} else  if (diaSemana == dto.getCalendarioSemanal().getDiasemana().intValue()) {
				if (hrinicial != null && hrinicial.equals(dto.getCalendarioSemanal().getHrInicial())) {
					return retorno.getERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO();
				}
			} else {
				diaSemana = dto.getCalendarioSemanal().getDiasemana().intValue();
			}
			hrinicial = dto.getCalendarioSemanal().getHrInicial();
		}
		
		// map temporario que contem todos os turnos de um dia da semana. utilizado para validar o calendario.
		Map<Long, List<DwCalsem>> mapTemporarioContendoTurnosDeUmDiaDaSemana = new HashMap<Long, List<DwCalsem>>();
		
		// turno temporario utilizado apenas para validar o calendario
		DwCalsem turnoTemporario = new DwCalsem();
		DwCalsem ultimoTurnoTemporario = new DwCalsem();
		
		int quantidadeDeHorariosDoCalendario = calendario.getCalendariosSemanais().getCalendariosSemanais().size();
		for (int i = 0; i < quantidadeDeHorariosDoCalendario; i++){
			int inicioReal = i + indiceDoPrimeiroInicioDeTurno;
			if (inicioReal >= quantidadeDeHorariosDoCalendario){
				inicioReal = inicioReal - quantidadeDeHorariosDoCalendario;
			}
			
			CalendarioSemanalDTO calendarioSemanal = calendario.getCalendariosSemanais().getCalendariosSemanais().get(inicioReal);
			
			boolean isDiaDaSemanaValido = 
					calendarioSemanal.getCalendarioSemanal().getDiasemana().longValue() >= 0 ||
					calendarioSemanal.getCalendarioSemanal().getDiasemana().longValue() <= 6;
			if (isDiaDaSemanaValido == false){
				return retorno.getERRO_DIADASEMANA_DESCONHECIDO();
			}
			
			
			boolean isHoraFinalMenorQueAHoraInicial = 
					calendarioSemanal.getCalendarioSemanal().getHrFinal().doubleValue() < 
					calendarioSemanal.getCalendarioSemanal().getHrInicial().doubleValue();
			if (isHoraFinalMenorQueAHoraInicial){
				return retorno.getERRO_HORAFINAL_MENOR_HORAINICIAL();
			}
			
			
			double duracao =
					calendarioSemanal.getCalendarioSemanal().getHrFinal().doubleValue() -
					calendarioSemanal.getCalendarioSemanal().getHrInicial().doubleValue();
			if(isHoraFinalMenorQueAHoraInicial) {
				duracao += 24 * DataHoraRN.SEG_HORA;
			}
			
			
			boolean isTempoCalendarioMenorQueTempoDaDuracao = 
					calendarioSemanal.getCalendarioSemanal().getSegTempocalendario().doubleValue() < 
					duracao;
			if (isTempoCalendarioMenorQueTempoDaDuracao){
				return retorno.getERRO_TEMPOCALENDARIO_INVALIDO();
			}
			
			
			boolean isTipoDaDataDeReferenciaValido = 
					calendarioSemanal.getCalendarioSemanal().getTpDtreferencia() == null ||
					calendarioSemanal.getCalendarioSemanal().getTpDtreferencia() >= 0 ||
					calendarioSemanal.getCalendarioSemanal().getTpDtreferencia() <= 2;
			if (isTipoDaDataDeReferenciaValido == false){
				return retorno.getERRO_TIPODATAREFERENCIA_INVALIDO();
			}
			
			
			BigDecimal diaDaSemana = calendarioSemanal.getCalendarioSemanal().getDiasemana();
			DwTurno turno = calendarioSemanal.getCalendarioSemanal().getDwTurno();
			boolean isInicioDeTurno = calendarioSemanal.getCalendarioSemanal().getIsInicioturno();
			boolean isFimDeTurno = calendarioSemanal.getCalendarioSemanal().getIsFimturno();
			
			
			if(isInicioDeTurno) {
				if (isFimDeTurno == false){
					
					boolean isTurnoAnteriorSemFim = turnoTemporario.getDwTurno() != null;
					if(isTurnoAnteriorSemFim) {
						return retorno.getERRO_INICIOTURNO_SEM_FIM_ANTERIOR();
					}
					
				}
				
				turnoTemporario = new DwCalsem();
				turnoTemporario.setDiasemana(diaDaSemana);
				turnoTemporario.setDwTurno(turno);
				turnoTemporario.setHrInicial(calendarioSemanal.getCalendarioSemanal().getHrInicial());
				turnoTemporario.setHrInicialGui(calendarioSemanal.getCalendarioSemanal().getHrInicialGui());
				turnoTemporario.setTpDtreferencia(calendarioSemanal.getCalendarioSemanal().getTpDtreferencia());
			}
			
			
			boolean isNovoTurnoSemInicioDeTurno = turnoTemporario.getDwTurno() == null;
			if(isNovoTurnoSemInicioDeTurno) {
				return retorno.getERRO_INICIOTURNO_SEM_FIM_ANTERIOR();
			}
			
			
			boolean isMesmoTurno =
					turnoTemporario.getDwTurno() != null &&
					turnoTemporario.getDwTurno().getIdTurno() == turno.getIdTurno();
			if(isMesmoTurno == false) {
				return retorno.getERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO();
			}
			
			ultimoTurnoTemporario = turnoTemporario;
			if(isFimDeTurno) {
				
				boolean isTurnoSemInicio = turnoTemporario.getHrInicialGui() == null;
				if(isTurnoSemInicio) {
					return retorno.getERRO_FIMTURNO_SEM_INICIO_ANTERIOR();
				}
				
				turnoTemporario.setHrFinal(calendarioSemanal.getCalendarioSemanal().getHrFinal());
				turnoTemporario.setHrFinalGui(calendarioSemanal.getCalendarioSemanal().getHrFinalGui());
				
				
				byte tpDtreferencia = turnoTemporario.getTpDtreferencia();
				BigDecimal diaDaSemanaTurnoTemporario = turnoTemporario.getDiasemana();
				if(tpDtreferencia == DwCalsemTemplate.TpDtReferencia.DT_REF_DIA_SEGUINTE.getId()) {
					diaDaSemanaTurnoTemporario = diaDaSemanaTurnoTemporario.add(BigDecimal.ONE);
					
					if(diaDaSemanaTurnoTemporario.longValue() == 7L) {
						diaDaSemanaTurnoTemporario = BigDecimal.ZERO;
					}
				}
				
				if(tpDtreferencia == DwCalsemTemplate.TpDtReferencia.DT_REF_DIA_ANTERIOR.getId()) {
					diaDaSemanaTurnoTemporario = diaDaSemanaTurnoTemporario.subtract(BigDecimal.ONE);
					
					if(diaDaSemanaTurnoTemporario.longValue() == -1L) {
						diaDaSemanaTurnoTemporario = new BigDecimal(6);
					}
				}
				
				turnoTemporario.setDiasemana(diaDaSemanaTurnoTemporario);
				
				List<DwCalsem> listaCalendarioDia = mapTemporarioContendoTurnosDeUmDiaDaSemana.get(diaDaSemanaTurnoTemporario.longValue());
				if(listaCalendarioDia == null) {
					listaCalendarioDia = new ArrayList<DwCalsem>();
					listaCalendarioDia.add(turnoTemporario);
					mapTemporarioContendoTurnosDeUmDiaDaSemana.put(diaDaSemanaTurnoTemporario.longValue(), listaCalendarioDia);
				} else {
					listaCalendarioDia.add(turnoTemporario);
				}
				
				ultimoTurnoTemporario = turnoTemporario;
				turnoTemporario = new DwCalsem();
			}
			
			//Verifica se o turno existe
			try {
				String hql = "from DwTurno t where t.idTurno = ::idTurno ";
				
				hql = hql.replaceAll("::idTurno", String.valueOf(calendarioSemanal.getCalendarioSemanal().getDwTurno().getIdTurno()));

				Query q = getSession().createQuery(hql);

				DwTurno dwTurno = (DwTurno) q.list().get(0);

				calendarioSemanal.getCalendarioSemanal().setDwTurno(dwTurno);
				
				if (calendarioSemanal.getCalendarioAvulso() != null){
					if (calendarioSemanal.getCalendarioAvulso().getCalendarioAvulso() != null){
						calendarioSemanal.getCalendarioAvulso().getCalendarioAvulso().setDwTurno(dwTurno);
					}
				}
			} catch (Exception e) {
				return retorno.getERRO_TURNO_DESCONHECIDO();
			}
			
		}
		
		
		boolean isUltimoTurnoSemFimDeTurno = ultimoTurnoTemporario.getHrFinalGui() == null;
		if(isUltimoTurnoSemFimDeTurno) {
			return retorno.getERRO_FIMTURNO_SEM_INICIO_ANTERIOR();
		}

		
		for(Long chave : mapTemporarioContendoTurnosDeUmDiaDaSemana.keySet()) {
			
			for(DwCalsem c : mapTemporarioContendoTurnosDeUmDiaDaSemana.get(chave)) {
				
				int contadorDeRepeticaoDeTurnoPorDia = 0;
				for(DwCalsem c2 : mapTemporarioContendoTurnosDeUmDiaDaSemana.get(chave)) {
					if(c.getDwTurno().getIdTurno() == c2.getDwTurno().getIdTurno()) {
						contadorDeRepeticaoDeTurnoPorDia += 1;
					}
				}
				
				if(contadorDeRepeticaoDeTurnoPorDia > 1) {
					int dia = c.getDiasemana().intValue();
					String descricao = "";
					
					if(DwCalsemTemplate.DiaSemana.DOMINGO.equals(new BigDecimal(dia)))
						descricao=DwCalsemTemplate.DiaSemana.DOMINGO.getAbrev();
					if(DwCalsemTemplate.DiaSemana.SEGUNDA.equals(new BigDecimal(dia)))
						descricao=DwCalsemTemplate.DiaSemana.SEGUNDA.getAbrev();
					if(DwCalsemTemplate.DiaSemana.TERCA.equals(new BigDecimal(dia)))
						descricao=DwCalsemTemplate.DiaSemana.TERCA.getAbrev();
					if(DwCalsemTemplate.DiaSemana.QUARTA.equals(new BigDecimal(dia)))
						descricao=DwCalsemTemplate.DiaSemana.QUARTA.getAbrev();
					if(DwCalsemTemplate.DiaSemana.QUINTA.equals(new BigDecimal(dia)))
						descricao=DwCalsemTemplate.DiaSemana.QUINTA.getAbrev();
					if(DwCalsemTemplate.DiaSemana.SEXTA.equals(new BigDecimal(dia)))
						descricao=DwCalsemTemplate.DiaSemana.SEXTA.getAbrev();
					if(DwCalsemTemplate.DiaSemana.SABADO.equals(new BigDecimal(dia)))
						descricao=DwCalsemTemplate.DiaSemana.SABADO.getAbrev();
						
					dtoRetorno.setComplementoResultado(" Dia " + descricao + " Turno " + c.getDwTurno().getDsTurno());
					return retorno.getERRO_TURNO_REPETIDO_MESMO_DIA();
				}
				
			}
		}

		// Verificar se existe conflito entre o calendario que se deseja salvar com os calendarios ja cadastrados
		// um conflito acontece quando existe intersecao entre as datas de inicio e fim de validades dos calendarios cadastrados e com o que se dejesa cadastrar
		List<DwCal> calendariosAtivos = getCalendarioAtivos();
		for (DwCal dwcal : calendariosAtivos) {
			// Verificar se os calendarios forem igual, se sim ignorar
			if (dwcal.getCdCal().equals(calendario.getCalendario().getCdCal()))
				continue;
			// Verificar se dwcal possui algum PT em comum com calendario
			boolean isExistePtEmComum = false;
			OmPt ptEmComum = null;
			for (DwCalpt dwcalpt : dwcal.getDwCalpts()) {
				if (calendario.getCalendarioPts() != null && calendario.getCalendarioPts().getPts() != null)
					for (DwCalpt dwcalptCalendario : calendario.getCalendarioPts().getPts()) {
						if (dwcalpt.getOmPt().getCdPt().equals(dwcalptCalendario.getOmPt().getCdPt())) {
							isExistePtEmComum = true;
							ptEmComum = dwcalpt.getOmPt();
							break;
						}
					}
				if (isExistePtEmComum == true)
					break;
			}
			
			// Verifica se existe conflito entre os calendarios, caso tenham pts em comum
			if (isExistePtEmComum == true) {
				Date dthrCalInicio = dwcal.getDthrIvalidade();
				Date dthrCalFim = dwcal.getDthrFvalidade();
				Date dthrCalendarioISalvar = calendario.getCalendario().getDthrIvalidade();
				Date dthrCalendarioFSalvar = calendario.getCalendario().getDthrFvalidade();
				
				/*
				 * o metodo DataHoraRN.isIntersecao espera que as datas de fim tenham valores, mas no cadastro elas podem estar null significando que
				 * a data e infinita. Nessa caso para simplificar a validacao colocarei a mesma data do dia atual avancando 1000 anos
				 * 
				 */
				if (dthrCalFim == null) {
					dthrCalFim = DataHoraRN.getDataHoraAtual();
					dthrCalFim = DataHoraRN.adicionaDiasDaData(dthrCalFim, (365*1000));
				}
				if (dthrCalendarioFSalvar == null) {
					dthrCalendarioFSalvar = DataHoraRN.getDataHoraAtual();
					dthrCalendarioFSalvar = DataHoraRN.adicionaDiasDaData(dthrCalendarioFSalvar, (365*1000));
				}
				
				if (DataHoraRN.isIntersecao(dthrCalInicio, dthrCalFim, dthrCalendarioISalvar, dthrCalendarioFSalvar) == true) {
					dtoRetorno.setCalendario(new DwCal()); 
					dtoRetorno.getCalendario().setCdCal(dwcal.getCdCal());
					dtoRetorno.getCalendario().setDsCal(dwcal.getDsCal());
					dtoRetorno.setComplementoResultado(ptEmComum.getCdPt());
					return retorno.getERRO_PERIODO_CALENDARIO_CONFLITA();
				}
			}

		}
		
		return retorno.getEVENTO_BEM_SUCEDIDO();
		//return retorno.getERRO_PERIODO_CALENDARIO_CONFLITA();
	}
	
	private int getIndiceDoPrimeiroInicioDeTurno(CalendarioDTO calendario) {
		if(
				calendario == null ||
				calendario.getCalendariosSemanais() == null ||
				calendario.getCalendariosSemanais().getCalendariosSemanais() == null) {
			return -1;
		}
		
		int indiceDoPrimeiroInicioDeTurno = -1;
		for (int i = 0; i < calendario.getCalendariosSemanais().getCalendariosSemanais().size(); i++){
			CalendarioSemanalDTO calendarioSemanal = calendario.getCalendariosSemanais().getCalendariosSemanais().get(i);
			if (calendarioSemanal.getCalendarioSemanal().getIsInicioturno()){
				indiceDoPrimeiroInicioDeTurno = i;
				break;
			}
		}
		return indiceDoPrimeiroInicioDeTurno;
	}
	
	/**Método para pesquisar o calendario de acordo com o c�digo
	 * @param calendario - Objeto com as informações do calendario para filtrar a pesquisa.
	 * @return DwCal - Objeto calendario com as informações da pesquisa realizada.
	 */
	public DwCal pesquisarDwCalByCdESt(DwCal calendario) {
		if (calendario == null || calendario.getCdCal() == null){
			return null;
		}
		MapQuery q = new MapQuery(getSession());
		
		q.append("select dwcal from DwCal dwcal");
		q.appendWhere(MapQuery._NULL, "dwcal.cdCal = :cdcal", ((calendario.getCdCal() != null) && (!calendario.getCdCal().isEmpty())));
		q.appendWhere(MapQuery._AND, "dwcal.stAtivo = 1", true);
		
		q.defineParametro("cdcal", calendario.getCdCal());
		
		q.setMaxResults(1);
		
		return (DwCal)q.uniqueResult();
	}

	/**Método para pesquisar o calendario de acordo com o posto de trabalho
	 * @param ompt - Objeto com as informações do posto de trabalho para filtrar a pesquisa.
	 * @return DwCal - Objeto calendario com as informações da pesquisa realizada.
	 */
	public DwCal pesquisarDwCalByOmPt(OmPt ompt){
		MapQuery q = new MapQuery(getSession());
		q.append("select dwcal");
		q.append("from DwCal dwcal");
		q.append("join dwcal.dwCalpts dwcalpt");
		q.append("where dwcal.stAtivo = 1");
		q.append("and dwcalpt.omPt.idPt = :idpt");
		
		q.defineParametro("idpt", ompt.getIdPt());
		q.setMaxResults(1);
		
		DwCal dwcal = (DwCal) q.uniqueResult();
		if (dwcal == null){
			TurnoRN turnoRN = new TurnoRN();
			turnoRN.getDao().setSession(getSession());
			dwcal = turnoRN.getDwCal();
		}
		return dwcal;
	}

	/**Método para pesquisar lista de calendarios de acordo com o posto de trabalho
	 * @param ompt - Objeto com as informações do posto de trabalho para filtrar a pesquisa.
	 * @return List<DwCal> - Lista de objetos calendario com as informações da pesquisa realizada.
	 */
	public List<DwCal> pesquisarListaDwCalByOmPt(OmPt ompt){
		
		MapQuery q = new MapQuery(getSession());
		
		q.append("select distinct dwcal");
		q.append("from DwCal dwcal");
		q.append("join dwcal.dwCalpts dwcalpt");
		q.append("join dwcalpt.omPt pt");
		q.append("join dwcal.dwCalsems dwcalsem");
		q.append("join dwcalsem.dwTurno dwturno");
		q.append("where dwcal.stAtivo = 1");
		q.append("and pt.idPt = :idpt");
		
		q.defineParametro("idpt", ompt.getIdPt());
		
		List<DwCal> dwcal = q.list();
		
		return dwcal;
	}
	
	/**Método para pesquisar lista de calendarios de acordo com o grupo de trabalho
	 * @param omgt - Objeto com as informações do grupo de trabalho para filtrar a pesquisa.
	 * @return List<DwCal> - Lista de objetos calendario com as informações da pesquisa realizada.
	 */
	public List<DwCal> pesquisarListaDwCalByOmGt(OmGt omgt){
		
		MapQuery q = new MapQuery(getSession());
		
		q.append("select dwcal");
		q.append("from DwCal dwcal");
		q.append("join dwcal.dwCalpts dwcalpt");
		q.append("join dwcal.dwCalsems dwcalsem");
		q.append("join dwcalsem.dwTurno dwturno");
		q.append("join dwcalpt.omPt ompt");
		q.append("where dwcal.stAtivo = 1");
		q.append("and ompt.omGt = :omgt");
		
		q.defineParametro("omgt", omgt);
		
		List<DwCal> dwcal = q.list();
		
		return dwcal;
	}
	
	/**Método para pesquisar o calendario de acordo com o posto de trabalho e o PpPlano
	 * @param ompt - Objeto com as informações do posto de trabalho para filtrar a pesquisa.
	 * @param ppplano - Objeto com as informações do PpPlano para filtrar a pesquisa.
	 * @return <DwCal> - Objeto calendario com as informações da pesquisa realizada.
	 */
	public DwCal pesquisarDwCalByOmPt(OmPt ompt, PpPlano ppplano){
		MapQuery q = new MapQuery(getSession());
		q.append("select dwcal");
		q.append("from DwCal dwcal");
		q.append("join dwcal.dwCalpts dwcalpt");
		q.append("where dwcal.stAtivo = 1");
		q.append("and dwcalpt.omPt.idPt = :idpt");
		
		if((ppplano!=null)&&(ppplano.getDwCal() !=null)){
			q.append("and dwcal.idCal = :idcal");
			q.defineParametro("idcal", ppplano.getDwCal().getIdCal());
		}
		
		q.defineParametro("idpt", ompt.getIdPt());
		q.setMaxResults(1);
		
		DwCal dwcal = (DwCal) q.uniqueResult();
		if (dwcal == null){
			TurnoRN turnoRN = new TurnoRN();
			turnoRN.setDaoSession(getSession());
			dwcal = turnoRN.getDwCal();
		}
		return dwcal;
	}

	/**Método para pesquisar o calendario de acordo com o grupo de trabalho
	 * @param omgt - Objeto com as informações do grupo de trabalho para filtrar a pesquisa.
	 * @return <DwCal> - Objeto calendario com as informações da pesquisa realizada.
	 */
	public DwCal pesquisarDwCalByOmGt(OmGt omgt){
		MapQuery q = new MapQuery(getSession());
		q.append("select dwcal");
		q.append("from DwCal dwcal");
		q.append("join dwcal.dwCalpts dwcalpt");
		q.append("join dwcalpt.omPt ompt");
		q.append("where dwcal.stAtivo = 1");
		q.append("and ompt.omGt = :omgt");
		
		q.defineParametro("omgt", omgt);
		q.setMaxResults(1);
		
		DwCal dwcal = (DwCal) q.uniqueResult();
		if (dwcal == null){
			TurnoRN turnoRN = new TurnoRN();
			turnoRN.setDaoSession(getSession());
			dwcal = turnoRN.getDwCal();
		}
		return dwcal;
	}
	
	/**Método para pesquisar o calendario de acordo com grupo de trabalho e o PpPlano
	 * @param omgt - Objeto com as informações do grupo de trabalho para filtrar a pesquisa.
	 * @param ppplano - Objeto com as informações do PpPlano para filtrar a pesquisa.
	 * @return <DwCal> - Objeto calendario com as informações da pesquisa realizada.
	 */
	public DwCal pesquisarDwCalByOmGt(OmGt omgt, PpPlano ppplano){
		MapQuery q = new MapQuery(getSession());
		q.append("select dwcal");
		q.append("from DwCal dwcal");
		q.append("join dwcal.dwCalpts dwcalpt");
		q.append("join dwcalpt.omPt ompt");
		q.append("where dwcal.stAtivo = 1");
		q.append("and ompt.omGt = :omgt");
		
		if((ppplano!=null)&&(ppplano.getDwCal() !=null)){
			q.append("and dwcal.idCal = :idcal");
			q.defineParametro("idcal", ppplano.getDwCal().getIdCal());
		}
		
		q.defineParametro("omgt", omgt);
		q.setMaxResults(1);
		
		DwCal dwcal = (DwCal) q.uniqueResult();
		if (dwcal == null){
			TurnoRN turnoRN = new TurnoRN();
			turnoRN.setDaoSession(getSession());
			dwcal = turnoRN.getDwCal();
		}
		return dwcal;
	}

	/**Método para pesquisar horarios de indisponibilidade no calendario semanal
	 * @param log - objeto com o log
	 * @param idLog - id do log
	 * @param identacao - valor da identacao
	 * @param id - id do IdCtDTO
	 * @param ppplano - objeto com informações do ppplano
	 * @return List<DwCalsem> - Lista de objetos calendario semanais com as informações da pesquisa realizada.
	 */
	public List<DwCalsem> pesquisarHorariosDeIndisponibilidade(IdwLogger log, int idLog, int identacao, IdCtDTO id, PpPlano ppplano){
		
		DwCal dwcal = null;
		
		if (id.getOmptEscolhido() != null){
			dwcal = pesquisarDwCalByOmPt(id.getOmptEscolhido(), ppplano);
		} else if (id.getOmgtEscolhido() != null){
			dwcal = pesquisarDwCalByOmGt(id.getOmgtEscolhido(), ppplano);
		}
		
		MapQuery q = new MapQuery(getSession());
		
		q.append("select dwcalsem");
		q.append("from DwCalsem dwcalsem");
		//q.append("join dwcalsem.dwCal dwcal");
		//q.append("join dwcal.dwCalpts dwcalpt");
		//q.append("join dwcalpt.omPt ompt");
		//q.append("join ompt.omGt omgt");

		q.appendWhere(MapQuery._NULL, "dwcalsem.dwCal.idCal = :dwcal", true);
		/*
		q.appendWhere(MapQuery._AND, "dwcalpt.omPt = :ompt", id.getOmptEscolhido() != null);
		q.appendWhere(MapQuery._AND, "omgt = :omgt", id.getOmgtEscolhido() != null);
		q.appendWhere(MapQuery._AND, "not exists (", true);
		
		q.append("select calsub.diasemana, sum(segTempocalendario)");
		q.append("from DwCalsem calsub where calsub.dwCal = dwcal");
		q.append("and calsub.diasemana = dwcalsem.diasemana");
		q.append("group by calsub.diasemana");
		q.append("having sum(segTempocalendario) >= 86400");
		
		q.append(")"); */

		q.append("order by dwcalsem.diasemana, dwcalsem.hrInicialGui");

//		q.defineParametro("ompt", id.getOmptEscolhido());
//		q.defineParametro("omgt", id.getOmgtEscolhido());
		q.defineParametro("dwcal", dwcal.getIdCal());

		List<DwCalsem> l = q.list();
/*		DwCalsem anterior = null;
		for (DwCalsem d : l){
			if (anterior != null && anterior.getHrFinal().equals(d.getHrInicial()) == false){
				DwCalsem novo = (DwCalsem) anterior.clone(); 
				
				novo.setHrInicial(anterior.getHrInicial());
				novo.setHrFinal(d.getHrFinal());
				retorno.add(novo);	
				if (log != null){
					log.info(idLog, identacao, "Encontrada falta de calendario em " + novo.getHrInicial() + " ate " + novo.getHrFinal());
				}
			}
			anterior = d;
		}*/
		return l; //retorno;
	}
	
	public List<DwCal> getCalendarioAtivos(){
		
		MapQuery q = new MapQuery(getSession());
		
		q.append("select distinct c");
		q.append("FROM DwCal c WHERE c.stAtivo = 1 ");
		
		List<DwCal> listaCalAtivos = q.list();
		
		return listaCalAtivos;
		
	}
	
	private DwCal pesquisarCalendariosEmAberto(List<DwCal> calsAtivos, DwCal calendario){
		DwCal cal = null;
		for(DwCal c : calsAtivos){
			
			if(c.getDthrFvalidade() == null 
					&& c.getIdCal() != calendario.getIdCal() 
					&& !c.getCdCal().equals(TurnoRN.CD_CALENDARIO_INDEFINIDO)){
				cal = c;
			}
		}
		return cal;
	}
	
	private DwCal verificarPeriodosConflitam(List<DwCal> calsAtivos, DwCal cal){
		DwCal retorno = null;
		for(DwCal c : calsAtivos){
			if(DataHoraRN.after(cal.getDthrIvalidade(), c.getDthrIvalidade()) 
					&& c.getIdCal() != cal.getIdCal() 
					&& !c.getCdCal().equals(TurnoRN.CD_CALENDARIO_INDEFINIDO)
					&& c.getDthrFvalidade() != null 
					&& (DataHoraRN.before(cal.getDthrIvalidade(), c.getDthrFvalidade())	|| DataHoraRN.equals(cal.getDthrIvalidade(), c.getDthrFvalidade()))
					){
				retorno = c;
				break;
			} 
		}
		return retorno;
	}
	
	private DwCal verificarPtsDoCal(List<DwCal> calsAtivos, CalendarioDTO cal){
		DwCal retorno = null;
		
		for(DwCal c : calsAtivos){
			if(c.getCdCal().equals(cal.getCalendario().getCdCal()) == false && c.getCdCal().equals(TurnoRN.CD_CALENDARIO_INDEFINIDO) == false){
				List<DwCalpt> calPtsAtivos = new ArrayList<DwCalpt>();
				calPtsAtivos.addAll(c.getDwCalpts());
				
				for(DwCalpt calPtA : calPtsAtivos){
					if(cal.getCalendarioPts() != null && cal.getCalendarioPts().getPts() != null){
						for(DwCalpt cp : cal.getCalendarioPts().getPts()){
							if(calPtA.getOmPt().getIdPt().longValue() == cp.getOmPt().getIdPt().longValue()){
								retorno = c;
								break;
							}
						}
						if(retorno != null){
							break;
						}
					}
				}
				if(retorno != null){
					break;
				}
			}
		}	
		return retorno;
	}

	public CalendariosSemanaisDTO getCalendarioPt(Long idCal){
		IdwLogger log = new IdwLogger("CalendarioRN");
		int idLog = log.getIdAleatorio();
		CalendariosSemanaisDTO retorno = new CalendariosSemanaisDTO();
		
		// Obter também o cal ompt
		MapQuery q = new MapQuery(getSession());
		
		q.append("select distinct a");
		q.append("from DwCalpt a");
		q.append("join fetch a.omPt b");
		q.append("join fetch b.omGt c");
		q.append("where b.stAtivo = 1");
		q.append("and a.dwCal.idCal = :id");
		
		q.defineParametro("id", idCal);
		
		retorno.setCalendarioPts(new CalendarioPtsDTO());
		retorno.getCalendarioPts().setPts(new ArrayList<DwCalpt>());

		log.iniciaAvaliacao("getCalendarioPt.list");
		List<DwCalpt> calspts = q.list();
		log.mostrarAvaliacaoCompleta();
		log.info(idLog, 0, "q.list()=" + calspts.size());
		log.iniciaAvaliacao("getCalendarioPt.clone");
		for (DwCalpt itemList : calspts) {
			DwCalpt clone = itemList.clone(false);
			clone.setOmPt(itemList.getOmPt().clone(false));
			clone.getOmPt().setOmGt(itemList.getOmPt().getOmGt().clone(false));
			clone.getOmPt().setOmTppt(itemList.getOmPt().getOmTppt().clone(false));
			retorno.getCalendarioPts().getPts().add((DwCalpt)clone);
		}
		log.mostrarAvaliacaoCompleta();
		return retorno;
	}
	

	@SuppressWarnings("unused")
	public ListaCalendariosDTO getCalendariosDTO(FiltroPesquisaDTO filtro) {
		ListaCalendariosDTO retorno = new ListaCalendariosDTO();
		retorno.setItems(new ArrayList<CalendarioDTO2>());
		retorno.setMeta(new MetaDTO(filtro));
		
		MapQuery q = new MapQuery(getDao().getSession());
		
		q.append("select distinct t");
		q.append("from DwCal t");
		q.append("left join fetch t.dwCalpts b");
		q.append("left join fetch b.omPt c");
		q.append("left join fetch t.dwCalsems d");
		q.append("left join fetch d.dwTurno e");
		q.append("where t.stAtivo = 1");
		// q.append("and c.omTppt.cdTppt = 'CIC' ");
		
		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")) {
			q.append("AND (");
			q.append(" upper(t.cdCal) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.dsCal) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");		 
		}
		
		// q.append("order by t.cdCal, d.diasemana, d.ordem");
		q.append("order by t.cdCal");
		
		// Lista do pojo
		List<DwCal> listaPesquisa = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
		
		
		// -------------------------------------------------------
		// Carrega todos os postos ativos
		// -------------------------------------------------------
		
		PTRN ptRN = new PTRN();
		FiltroPesquisaDTO filtroPts = new FiltroPesquisaDTO();
		filtroPts.setPagina(1);
		filtroPts.setRegistrosPorPagina(1000);
		ptRN.setDao(getDao());
		ptRN.setDaoSession(getDao().getSession());
		
		ListaPTsDTO ptsAtivos = ptRN.getPtsDTO(filtroPts);
		
		// -------------------------------------------------------
		

		List<CalendarioPtDTO2> ptsComCalendario = ptRN.getPtsComCalendario();
		
		
		// Percorre os calendários ativos
 		for (DwCal registro : listaPesquisa) {
 			
 			String cdCalendario = registro.getCdCal();
 			
 			CalendarioDTO2 regDTO = new CalendarioDTO2();
 			

 			// Seta os dados do cabeçalho do calendário
 			regDTO.setIdCalendario(registro.getIdCal());
 			regDTO.setCdCalendario(registro.getCdCal());
 			regDTO.setDsCalendario(registro.getDsCal());
 			
 			regDTO.setDtHrIValidade(DataHoraRN.dateToStringYYYYMMDDHHMMSS(registro.getDthrIvalidade()));
 			regDTO.setDtHrFValidade(DataHoraRN.dateToStringYYYYMMDDHHMMSS(registro.getDthrFvalidade()));
 			
 			regDTO.setDtHrIValidade(regDTO.getDtHrIValidade().substring(0, 5) +
 					                regDTO.getDtHrIValidade().substring(5, 8) +
 					                regDTO.getDtHrIValidade().substring(8, 10));
 			
 			if (!regDTO.getDtHrFValidade().equals("")) {
 				
 	 			regDTO.setDtHrFValidade(regDTO.getDtHrFValidade().substring(0, 4) +
                                        regDTO.getDtHrFValidade().substring(5, 8) +
                                        regDTO.getDtHrFValidade().substring(8, 10)); 				
 	 			
 			}

 			
 			regDTO.setStRegistro(registro.getStAtivo().intValue());
 			
 			
 		    // Cria objetos
 			List<CalendarioTurnoIntervaloDTO> intervalos;
 			List<CalendarioPtDTO2> pts = new ArrayList<CalendarioPtDTO2>();
 			CalendarioTurnoIntervaloDTO intervalo;
 			CalendarioPtDTO2 pt;
 			
 			List<CalendarioTurnoDTO> turnos = new ArrayList<CalendarioTurnoDTO>();
 			
			// Inicializa os intervalos
			intervalos = new ArrayList<CalendarioTurnoIntervaloDTO>();
			
 		  	// Percorre a semana do calendário
 			for (DwCalsem intervaloSemana : registro.getDwCalsems()) {

				// Inicializa o intervalo
				intervalo = new CalendarioTurnoIntervaloDTO();
 				
			    // Seta os dados do intervalo
				
				if (intervaloSemana.getOrdem() == null) {
					intervalo.setOrdem(0);	
				} else {
					intervalo.setOrdem(intervaloSemana.getOrdem());
				}
						
 				intervalo.setHrInicio(intervaloSemana.getHrInicialGui());
 				intervalo.setHrFim(intervaloSemana.getHrFinalGui());
		 			
		 		// Calcula a duração do intervalo
		 		BigDecimal duracao = intervaloSemana.getHrFinal().subtract(intervaloSemana.getHrInicial());
		 		
		 		// Se a duração for negativa siginifica que o intervalo começa em um dia e termina no outro
		 		if (duracao.intValue() < 0) {
		 			
 					// Recalcula a duração
 					
 					BigDecimal duracao1 = intervaloSemana.getHrFinal();
 					BigDecimal tempo24horas = new BigDecimal(86400);
 					BigDecimal duracao2 = tempo24horas.subtract(intervaloSemana.getHrInicial());
 					
 					duracao = duracao1.add(duracao2);
		 					
		 		}
		 		
 				// Formata a duração para HH:MM
 				String duracaoIntervalo = DataHoraRN.formatSegundosParaHHMM(duracao.intValue());
 				intervalo.setDuracao(duracaoIntervalo);
 				
 				intervalo.setDiaSemana(ConversaoTipos.converteParaInt(ConversaoTipos.converteParaString(intervaloSemana.getDiasemana(), 0)));
 				
				intervalo.setCdTurno(intervaloSemana.getDwTurno().getCdTurno());

				/*
				intervalo.setDsTurno(intervaloSemana.getDwTurno().getDsTurno());
				intervalo.setCor(intervaloSemana.getDwTurno().getCor());
				intervalo.setHrInicioTurno("");
				intervalo.setHrFimTurno("");
				intervalo.setDuracaoTurno("");
				*/
				
				long preToleracia = ConversaoTipos.converterParaLong(intervaloSemana.getSegToleranciapre().intValue());
				long posToleracia = ConversaoTipos.converterParaLong(intervaloSemana.getSegToleranciapos().intValue());
				intervalo.setPreTolerancia(preToleracia);
				intervalo.setPosTolerancia(posToleracia);
				
				intervalo.setTpRefInicioTurno(intervaloSemana.getTpDtreferencia());
				
				intervalo.setIsInicioDeTurno(intervaloSemana.getIsInicioturno());
				intervalo.setIsFimDeTurno(intervaloSemana.getIsFimturno());
				
 				// Adiciona o intervalo
 				intervalos.add(intervalo);
		 				
		 		
			}
			

			// Primeiro ordena os intervalos pelo "dia da semana"
			java.util.Collections.sort(intervalos, new Comparator<CalendarioTurnoIntervaloDTO>() {
				@Override
				public int compare(CalendarioTurnoIntervaloDTO o1, CalendarioTurnoIntervaloDTO o2) {
					return o1.getDiaSemana().compareTo(o2.getDiaSemana());
				}
			});

			
 			// Agora ordena pela "hora de início do intervalo"
			java.util.Collections.sort(intervalos, new Comparator<CalendarioTurnoIntervaloDTO>() {
				@Override
				public int compare(CalendarioTurnoIntervaloDTO o1, CalendarioTurnoIntervaloDTO o2) {
					return o1.getHrInicio().compareTo(o2.getHrInicio());
				}
			});
			
			
			
			// -------------------------------------------------------------------------
			// Define início e fim de cada turno
			// -------------------------------------------------------------------------
			
			List<String> turnosAux = new ArrayList<String>();
			
			// List<CalendarioTurnoDTO> diasSemana = new ArrayList<CalendarioTurnoDTO>();
			// CalendarioTurnoDTO diaSemana = new CalendarioTurnoDTO();
			
			List<Integer> diasSemana = new ArrayList<Integer>();
			
			// Procura início e fim de cada turno
			for (CalendarioTurnoIntervaloDTO inter1 : intervalos) {
				
				// Pega o turno do intervalo
				String cdTurno = inter1.getCdTurno();
				
				// Variável para controle
				boolean definirIntervaloTurno = true;
				
				// Percorre a lista de códigos de turnos com limites já definidos
				for (String turno : turnosAux) {
					
					// Se o turno já existe na lista...
					if (turno.equals(cdTurno)) {
						// Sinaliza que esse turno já teve seus limites definidos
						definirIntervaloTurno = false;
						break;
					}
					
				}
				
				// Se os limites do turno ainda não foram definidos...
				if (definirIntervaloTurno) {
					
					// Se esse intervalo é o início do turno...
					if (inter1.getIsInicioDeTurno()) {
						
						// Inicia a definição dos limites do turno
						
						int hrInicioTurnoEmSeg;
						int hrFimTurnoEmSeg;
						String hrInicioTurno = inter1.getHrInicio();
						String hrFimTurno = "";
						
						long posToleranciaTurno = 0;
						
						// Procura pelo fim do turno
						for (CalendarioTurnoIntervaloDTO inter2 : intervalos) {
							
							if (inter2.getCdTurno().equals(cdTurno) && (inter2.getIsFimDeTurno())) {
								hrFimTurno = inter2.getHrFim();
								posToleranciaTurno = inter2.getPosTolerancia();
								break;
							}
							
						}
						
						if (hrInicioTurno.equals("24:00")) {
							hrInicioTurnoEmSeg = 86400;
						} else {
							hrInicioTurnoEmSeg = DataHoraRN.getHHMMEmSegundosCorrigida(hrInicioTurno);
						}
						
						if (hrFimTurno.equals("24:00")) {
							hrFimTurnoEmSeg = 86400;
						} else {
							hrFimTurnoEmSeg = DataHoraRN.getHHMMEmSegundosCorrigida(hrFimTurno);
						}
						
		 				
						// Calcula a duração do turno
						int duracaoTurnoEmSeg = hrFimTurnoEmSeg - hrInicioTurnoEmSeg;
		 				
						// Se a duração for negativa siginifica que o intervalo começa em um dia e termina no outro
		 				if (duracaoTurnoEmSeg < 0) {
		 					
		 					// Recalcula a duração
		 					
		 					int duracao1 = hrFimTurnoEmSeg;
		 					int duracao2 = 86400 - hrInicioTurnoEmSeg;
		 					
		 					duracaoTurnoEmSeg = duracao1 + duracao2;
		 					
		 				}
		 				
		 				// Transforma a duração para HH:MM
		 				String duracaoTurno = DataHoraRN.formatSegundosParaHHMM(duracaoTurnoEmSeg);

		 				
		 				// ---------------------------------------------------------------
		 				// Seta dados do turno
		 				// ---------------------------------------------------------------

		 				/*
		 				TurnoRN turnoRN = new TurnoRN();
						turnoRN.setDaoSession(getDao().getSession());
						DwTurno dwTurno = turnoRN.getDwTurnoPorCodigo(cdTurno);
						CalendarioTurnoDTO turno = new CalendarioTurnoDTO();
						*/
						
		 				DwTurno dwTurno = new DwTurno();
		 				
		 				CalendarioTurnoDTO turno = new CalendarioTurnoDTO();
						
						for (DwCalsem dwcalsem : registro.getDwCalsems()) {
							if (dwcalsem.getDwTurno().getCdTurno().equals(cdTurno)) {
								dwTurno = dwcalsem.getDwTurno();
								break;
							}
						}
						
						turno.setCdTurno(cdTurno);
						turno.setDsTurno(dwTurno.getDsTurno());
						turno.setCor(dwTurno.getCor());
						turno.setHrInicio(hrInicioTurno);
						turno.setHrFim(hrFimTurno);
						turno.setDuracao(duracaoTurno);
						turno.setIntervaloQuebraTurno(inter1.getDuracao());
						turno.setPreTolerancia(inter1.getPreTolerancia());
						turno.setPosTolerancia(posToleranciaTurno);
						turno.setTpRefInicioTurno(inter1.getTpRefInicioTurno());

						
						diasSemana = new ArrayList<Integer>();
						
						// Procura os dias de semana do turno
						for (CalendarioTurnoIntervaloDTO inter3 : intervalos) {
							
							boolean diaJaAdicionado = false;
							
							if (inter3.getCdTurno().equals(cdTurno)) {
								
								for (int i = 0; i < diasSemana.size(); i++) {
									if (inter3.getDiaSemana() == diasSemana.get(i)) {
										diaJaAdicionado = true;
										break;
									}
								}
								
								if (!diaJaAdicionado) {
									diasSemana.add(inter3.getDiaSemana());
								}
								
							}

						}
						
						// Seta os dias da semana do turno
						turno.setDiasSemana(diasSemana);
						
						
						turnos.add(turno);
						
		 				// ---------------------------------------------------------------
						
						
		 				// -----------------------------------------------------------------------		 				
		 				// Trecho para atualizar a lista de "intervalos" com os limites do turno
		 				// -----------------------------------------------------------------------
		 				
		 				// Índice da lista de "intervalos"
		 				int index = 0;
		 				
		 				// Percorre os intervalos à procura dos itens cujo turno é igual ao turno que está tendo seus limites definidos
		 				for (CalendarioTurnoIntervaloDTO intervaloAux : intervalos) {
		 					
		 					// Se o turno for igual ao turno que está tendo seus limites definidos...
		 					if (intervaloAux.getCdTurno().equals(cdTurno)) {
		 						
	 							// Inicializa o intervalo
	 							intervalo = new CalendarioTurnoIntervaloDTO();
		 						
		 						// Pega o item de "intervalos"
		 						intervalo = intervalos.get(index);
		 						
		 						// Seta os dados de início e fim de turno
		 						intervalo.setHrInicioTurno(hrInicioTurno);
		 						intervalo.setHrFimTurno(hrFimTurno);
		 						intervalo.setDuracaoTurno(duracaoTurno);
		 						
		 						// Atualiza o objeto "intervalos" 
		 						intervalos.set(index, intervalo);
		 						
		 					}
		 					
		 					// Próximo item de "intervalos" que poderá ser atualizado  
		 					index = index + 1;
		 					
		 				}
		 				
		 				// -----------------------------------------------------------------------
		 				
		 				
		 				// Atualiza a lista de turnos com o turno que teve seu início e fim definidos 
		 				turnosAux.add(cdTurno);
		 				
		 				
					}
					
				}
				
			}
			
			// -------------------------------------------------------------------------
			
			// Seta os turnos
			regDTO.setTurnos(turnos);
			
			
			// Seta os intervalos
			regDTO.setIntervalos(intervalos);
			
			
			
 		    // -------------------------------------------------------------------
 			// Postos do calendário
 			// -------------------------------------------------------------------
 			
			List<PtDTO2> listaPtsAtivos = ptsAtivos.getItems();

			pts = new ArrayList<CalendarioPtDTO2>();

			for (int index = 0; index < listaPtsAtivos.size(); index++) {
				
				PtDTO2 item = listaPtsAtivos.get(index);
				
				boolean podeAdicionar = true;

				// Percorre lista de postos com calendário associado
				for (int i = 0; i < ptsComCalendario.size(); i++) {
					
					// Se os pts forem iguais, deve-se testar o calendário (só pode adicionar o pt
					// se os calendários forem iguais).
					if (ptsComCalendario.get(i).getCdPt().equals(item.getCdPt())) {
						
						// Se o calendário for diferente, o pt não pode ser adicionado
						if (!ptsComCalendario.get(i).getCdCal().equals(cdCalendario)) {
							podeAdicionar = false;
						}
						
						break;
						
					}
					
				}

				
				
				if (podeAdicionar) {

					pt = new CalendarioPtDTO2();
					pt.setCdPt(item.getCdPt());
					pt.setDsPt(item.getDsPt());
					pt.setSelecionado(false);
					
		 		  	// Percorre os postos do calendário
		 			for (DwCalpt ptCal : registro.getDwCalpts()) {

		 				// Se o "pt ativo" estiver no calendário...
						if (item.getCdPt().equals(ptCal.getOmPt().getCdPt())) {
							pt.setSelecionado(true);		
							break;
						}
						
		 			}
		 			
		 			pts.add(pt);
					
				}
				
			}
 			
			// Seta os postos
 			regDTO.setPts(pts);
 			
 		    // -------------------------------------------------------------------
 			
 			// Atualiza o retorno
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
	public CalendarioDTO2 getCalendarioByCd(String cdCalendario) {

		FiltroPesquisaDTO filtro = new FiltroPesquisaDTO();
		filtro.setConteudoPesquisa(cdCalendario);
		filtro.setPagina(1);
		filtro.setRegistrosPorPagina(1);

		ListaCalendariosDTO lista = getCalendariosDTO(filtro);
		
		CalendarioDTO2 resultado = new CalendarioDTO2();
		
		if (!lista.getItems().isEmpty()) {
			resultado = lista.getItems().get(0);	
		}
		
		return resultado;
		
	}
	
	public DwCal getCalendarioPeloCodigo(String cdCalendario) {

		String hql="";
		hql += "select t ";
		hql += "from DwCal t ";
		hql += "where t.stAtivo = 1 ";
		hql += "AND t.cdCal = '" + cdCalendario + "'";
		
		Query q = getSession().createQuery(hql);

		DwCal retorno = new DwCal();
		
		List<DwCal> registros = new ArrayList<DwCal>();
		registros = q.list();
		
		for (DwCal registro : registros) {
			retorno = registro;
		}
		
		return retorno;
		
	}
	
}
