package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwTAreaDAO;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTDefeito;
import idw.model.pojos.DwTJust;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.DwTAreaTemplate;
import idw.util.IdwLogger;
import idw.webservices.dto.DwTAreaDTO;
import idw.webservices.dto.DwTAreasDTO;
import idw.webservices.rest.idw.v2.dto.AreaResponsavelDTO;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.JustificativaDTO;
import idw.webservices.rest.idw.v2.dto.ListaAreaRespDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;

@SuppressWarnings("unchecked")
public class AreaRN extends AbstractRN<DAOGenerico> {

	public static String CD_AREA_DEFAULT = "0";

	public AreaRN() {
		this(null);
	}

	public AreaRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	/**
	 * Desativa {@code DwTArea} relacionado ao id da area
	 * @param idArea
	 * @param dataHoraAtual
	 * @throws RegistroJaDesativadoException
	 */
	public void desativarArea(long idArea,  Date date, OmUsr omUsr) throws RegistroJaDesativadoException{
		this.getDao().desativar(DwTArea.class, idArea, date, omUsr);
	}

	public void desativarAreas(List<String> listaCdAreaDevemFicarAtivos, Date dataHoraDesativacao, OmUsr omUsr){
		this.getDao().desativarMuitos(DwTArea.class, DwTAreaTemplate._FIELD_NAME_CD, listaCdAreaDevemFicarAtivos, true, dataHoraDesativacao, omUsr);
	}
	
	public void desativarAreas(Date dataHoraDesativacao, OmUsr omUsr){
		this.getDao().desativarMuitos(DwTArea.class, DwTAreaTemplate._FIELD_NAME_CD, null, false, dataHoraDesativacao, omUsr);
	}
	
	public void salvarDesativandoOriginal(DwTArea dwTArea, Date dateOperacao, OmUsr omUsrOperacao) {
		this.getDao().salvarDesativandoOriginal(dwTArea, dateOperacao, omUsrOperacao);
	}
	
	public void salvarDesativandoOriginal(DwTArea dwTAreaDB, DwTArea dwTArea, Date dateOperacao, OmUsr omUsrOperacao) {
		this.getDao().salvarDesativandoOriginal(dwTAreaDB, dwTArea, dateOperacao, omUsrOperacao);
	}

	public DwTAreasDTO getTArea(DwTAreaDTO filtro){
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "AreaRN.getTArea");
		log.info( idLog , 0, "AreaRN.getTArea filtro usado:" + filtro.toString());
		
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t ");
		q.append("from DwTArea t ");
		q.append("where 1=1 ");

		if(filtro.getDwTArea().getIdArea() != 0){
			q.append("AND t.idArea=:idArea ");
		}else{
			if(filtro.getDwTArea().getCdArea()!=null && !filtro.getDwTArea().getCdArea().equals("")){
				q.append("AND t.cdArea=:cdArea ");
			}
			if(filtro.getDwTArea().getDsArea()!=null &&
					!filtro.getDwTArea().getDsArea().equals("")){
				q.append("AND t.dsArea=:dsArea ");
			}
			if((filtro.getDwTArea().getOmUsrByIdUsrstativo()!= null)
					&& (filtro.getDwTArea().getOmUsrByIdUsrstativo().getCdUsr() != null)
					&& (!filtro.getDwTArea().getOmUsrByIdUsrstativo().getCdUsr().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.cdUsr=:cdUsrSt ");
			}
			if((filtro.getDwTArea().getOmUsrByIdUsrstativo() != null)
					&& (filtro.getDwTArea().getOmUsrByIdUsrstativo().getDsNome() != null)
					&& (!filtro.getDwTArea().getOmUsrByIdUsrstativo().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.dsNome=:dsNomeSt ");
			}
			if((filtro.getDwTArea().getOmUsrByIdUsrrevisao()!= null)
					&& (filtro.getDwTArea().getOmUsrByIdUsrrevisao().getCdUsr() != null)
					&& (!filtro.getDwTArea().getOmUsrByIdUsrrevisao().getCdUsr().equals(""))){
				q.append("AND t.omUsrByIdUsrrevisao.cdUsr=:cdUsrRev ");
			}
			if((filtro.getDwTArea().getOmUsrByIdUsrrevisao() != null)
					&& (filtro.getDwTArea().getOmUsrByIdUsrrevisao().getDsNome() != null)
					&& (!filtro.getDwTArea().getOmUsrByIdUsrrevisao().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrrevisao.dsNome=:dsNomeRev ");
			}
			if(filtro.getDwTArea().getDtRevisao() != null){
				q.append("AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF ");
			}
			if(filtro.getDwTArea().getDtStativo() != null){
				q.append("AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF ");
			}
			if (filtro.getDwTArea().getRevisao()==null){
				q.append("AND t.revisao = (SELECT max(tr.revisao) as Revisao from DwTArea tr where tr.cdArea = t.cdArea ) ");
		    }else{
				q.append("AND t.revisao=:revisao ");
			}
			if (filtro.getDwTArea().getStAtivo() != null && filtro.getDwTArea().getStAtivo()<(byte)2){
				q.append("AND t.stAtivo=:stAtivo ");
			}
		}
		if(filtro.getDwTArea().getIdArea()!=0){
			q.defineParametro("idArea", filtro.getDwTArea().getIdArea());
		}
		if(filtro.getDwTArea().getCdArea() != null){
			q.defineParametro("cdArea", filtro.getDwTArea().getCdArea());
		}
		if(filtro.getDwTArea().getDsArea()!=null){
			q.defineParametro("dsArea", filtro.getDwTArea().getDsArea());
		}
		if(filtro.getDwTArea().getDtRevisao()!=null){
			q.defineParametro("dtRevisao", filtro.getDwTArea().getDtRevisao());
			q.defineParametro("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getDwTArea().getDtRevisao()));
		}

		if(filtro.getDwTArea().getDtStativo()!=null){
			q.defineParametro("dtStativo", filtro.getDwTArea().getDtStativo());
			q.defineParametro("dtStativoF",DataHoraRN.getDataHora235959(filtro.getDwTArea().getDtStativo()));
		}

		q.defineParametro("revisao", filtro.getDwTArea().getRevisao());
		q.defineParametro("stAtivo", filtro.getDwTArea().getStAtivo());

		if (filtro.getDwTArea().getOmUsrByIdUsrrevisao() != null) {
			q.defineParametro("cdUsrRev", filtro.getDwTArea().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getDwTArea().getOmUsrByIdUsrrevisao().getDsNome());
		}

		if (filtro.getDwTArea().getOmUsrByIdUsrstativo() != null){
			q.defineParametro("cdUsrSt", filtro.getDwTArea().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getDwTArea().getOmUsrByIdUsrstativo().getDsNome());
		}

		List<DwTArea> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<DwTAreaDTO> lista = new ArrayList<DwTAreaDTO>();

		if (listaPesquisa != null) {
			for (DwTArea item : listaPesquisa) {
				DwTAreaDTO dwTAreaDTO = new DwTAreaDTO();
				dwTAreaDTO.setDwTArea(item.clone());
				lista.add(dwTAreaDTO);
			}
		}

		DwTAreasDTO listaRetorno = new DwTAreasDTO();
		listaRetorno.setListaAreasDTO(lista);
		
		log.mostrarAvaliacaoCompleta();

		return listaRetorno;
	}

	public DwTAreaDTO setTArea(DwTAreaDTO itemDTO) {
		DwTArea itemOriginal = new DwTArea();
		itemOriginal = itemDTO.getDwTArea().clone();
		//System.out.println(itemOriginal.getEmail());
		OmUsr omUser = new OmUsr();
		UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
		try {
			omUser = usuarioRN.getOmUsr(itemOriginal.getOmUsrByIdUsrrevisao().getCdUsr());
		} catch (RegistroDesconhecidoException e) {
			e.printStackTrace();
		}

		//20160928FVA:
		if (itemOriginal != null && itemOriginal.getIdArea() > 0 && itemOriginal.getStAtivo().equals((byte)0)) {
			itemDTO.setResultadoEvento(itemDTO.getERRO_REATIVACAO_INDISPONIVEL());
			return itemDTO;
		}
		
		salvarDesativandoOriginal(itemOriginal, new Date(), omUser);
		return itemDTO;
	}

	/**
	 * Busca a área através do código
	 * @param cdArea
	 * @param isFiltroAtivo
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwTArea getDwTArea(String cdArea, boolean isFiltroAtivo) throws RegistroDesconhecidoException {
		return this.getDao().findByCd(DwTArea.class, cdArea, DwTAreaTemplate._FIELD_NAME_CD, isFiltroAtivo);
	}
	
	public DwTArea getTArea(String cdArea) {
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select a");
		q.append("from DwTArea a");
		q.append("where ");
		q.append(" a.cdArea = :cdarea");
		q.append("and a.stAtivo = 1");
		q.defineParametro("cdarea", cdArea);
		q.setMaxResults(1);
		return (DwTArea) q.uniqueResult();
	}

	public DwTAreasDTO removeTArea(DwTAreasDTO itens){
	List<DwTAreaDTO> listaRetorno = new ArrayList<DwTAreaDTO>();

		for(DwTAreaDTO item: itens.getListaAreasDTO()){
			OmUsr omUser = new OmUsr();
			UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
			try {
				omUser = usuarioRN.getOmUsr(item.getDwTArea().getOmUsrByIdUsrrevisao().getCdUsr());
			} catch (RegistroDesconhecidoException e) {
				e.printStackTrace();
			}
			try {
				desativarArea(item.getDwTArea().getIdArea(),new Date(), omUser);
			} catch (RegistroJaDesativadoException e) {
				e.printStackTrace();
			}
			listaRetorno.add(item);
		}

		DwTAreasDTO itensRetorno = new DwTAreasDTO();
		itensRetorno.setListaAreasDTO(listaRetorno);
		return itensRetorno;
	}

	public DwTAreasDTO getListaAreasAtivas(){
		DwTAreasDTO retorno = new DwTAreasDTO();
		DwTAreaDAO dao = new DwTAreaDAO(getDaoSession());
		List<DwTArea> lista = dao.getAreasAtivas();
		List<DwTAreaDTO> listaRetorno = new ArrayList<>();
		for(DwTArea area : lista){
			DwTAreaDTO areaDTO = new DwTAreaDTO();
			areaDTO.setDwTArea(area.clone(false));
			listaRetorno.add(areaDTO);
		}
		retorno.setListaAreasDTO(listaRetorno);
		return retorno;
	}
	
	public DwTArea getTArea(long idArea) {
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select a");
		q.append("from DwTArea a");
		q.append("where ");
		q.append(" a.idArea = :idarea");
		q.defineParametro("idarea", idArea);
		q.setMaxResults(1);
		return (DwTArea) q.uniqueResult();
	}
	
	

	@SuppressWarnings("unused")
	public ListaAreaRespDTO getAreasResponsaveisDTO(FiltroPesquisaDTO filtro) {
		ListaAreaRespDTO retorno = new ListaAreaRespDTO();
		retorno.setItems(new ArrayList<AreaResponsavelDTO>());
		retorno.setMeta(new MetaDTO(filtro));
		
		MapQuery q = new MapQuery(getDao().getSession());
		
		q.append("select t ");
		q.append("from DwTArea t ");
		q.append("where t.stAtivo = 1 ");
		
		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")){
			q.append("AND (");
			q.append(" upper(t.cdArea) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.dsArea) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");
		}
		
		q.append("order by t.cdArea");
		
		// Lista do pojo
		List<DwTArea> listaPesquisa = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
		
 		for (DwTArea registro : listaPesquisa) {
 			
 			AreaResponsavelDTO regDTO = new AreaResponsavelDTO();
 			
 			regDTO.setIdAreaResponsavel(registro.getIdArea());
 			regDTO.setCdAreaResponsavel(registro.getCdArea());
 			regDTO.setDsAreaResponsavel(registro.getDsArea());
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
	public AreaResponsavelDTO getAreaResponsavelByCd(String cdAreaResponsavel) {
		AreaResponsavelDTO retorno = new AreaResponsavelDTO();
		
		MapQuery q = new MapQuery(getDao().getSession());
		
		q.append("select t ");
		q.append("from DwTArea t ");
		q.append("where t.stAtivo = 1 ");
		q.append("and t.cdArea = :cdAreaResponsavel ");
		q.append("order by t.cdArea");
		
 		q.defineParametro("cdAreaResponsavel", cdAreaResponsavel);

 		// Lista do pojo
 		List<DwTArea> lista = q.list();
 		
 		if (lista.size() == 1) {
 			
 			retorno.setIdAreaResponsavel(lista.get(0).getIdArea());
 			retorno.setCdAreaResponsavel(lista.get(0).getCdArea());
 			retorno.setDsAreaResponsavel(lista.get(0).getDsArea());
 			retorno.setStRegistro(lista.get(0).getStAtivo().intValue());
 			
 		}
		
		return retorno;
	}
	

}