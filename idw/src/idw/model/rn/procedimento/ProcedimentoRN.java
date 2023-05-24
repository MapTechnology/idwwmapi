package idw.model.rn.procedimento;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwFolhaDAO;
import idw.model.dao.DwProcedimentoDAO;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.DwDetativ;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwGrpativ;
import idw.model.pojos.DwProcarhom;
import idw.model.pojos.DwProcativ;
import idw.model.pojos.DwProcedimento;
import idw.model.pojos.DwTArea;
import idw.model.pojos.OmCargo;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.DwProcedimentoTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.AreaRN;
import idw.model.rn.CargoRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.UsuarioRN;
import idw.webservices.dto.DwGrpativDTO;
import idw.webservices.dto.DwGrpativDTOs;
import idw.webservices.dto.DwProcedimentoDTO;
import idw.webservices.dto.DwProcedimentosDTO;
import idw.webservices.dto.OmCargoDTO;
import idw.webservices.dto.OmCargosDTO;

public class ProcedimentoRN extends AbstractRN<DAOGenerico>{

	public ProcedimentoRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public ProcedimentoRN() {
		this(null);
	}

	public DwProcedimentosDTO getDwProcedimento(DwProcedimentoDTO filtro){
		DwProcedimentoDAO procedimentoDAO = new DwProcedimentoDAO(this.getDao().getSession());
		List<DwProcedimento> listaPesquisa = null;
		try{
			listaPesquisa = procedimentoDAO.getDwProcedimento(filtro);
		} catch (Exception e){
			e.printStackTrace();
		}

		List<DwProcedimentoDTO> lista = new ArrayList<DwProcedimentoDTO>();

		if (listaPesquisa != null) {
			for (DwProcedimento item : listaPesquisa) {
				DwProcedimentoDTO DwProcedimentoDTO = new DwProcedimentoDTO();
				DwProcedimentoDTO.setDwProcedimento(item.clone());
				if(item.getDwProcativs() != null){
					DwProcedimentoDTO.getDwProcedimento().setDwProcativs(new HashSet<DwProcativ>());
					for(DwProcativ itemProcativ: item.getDwProcativs()){
						DwProcativ procativ = (DwProcativ)itemProcativ.clone(false);
						
						procativ.setDwGrpativ(itemProcativ.getDwGrpativ().clone(false));
						procativ.setDwTArea(itemProcativ.getDwTArea()!=null?itemProcativ.getDwTArea().clone(false):null);
						procativ.setDwProcedimento(itemProcativ.getDwProcedimento().clone(false));
						
						if (itemProcativ.getDwDetativs() != null){
							procativ.setDwDetativs(new HashSet<DwDetativ>());
							for (DwDetativ dwDetativ : itemProcativ.getDwDetativs()){
								procativ.getDwDetativs().add((DwDetativ) dwDetativ.clone());
							}
						}
						DwProcedimentoDTO.getDwProcedimento().getDwProcativs().add(procativ);
					}
				}
				if(item.getDwProcarhoms()!=null){
					DwProcedimentoDTO.getDwProcedimento().setDwProcarhoms(new HashSet<DwProcarhom>());
					for(DwProcarhom itemProcarhom: item.getDwProcarhoms()){
						DwProcarhom procarhom = (DwProcarhom)itemProcarhom.clone(false);
						procarhom.setDwProcedimento(itemProcarhom.getDwProcedimento().clone(false));
						procarhom.setOmCargo(itemProcarhom.getOmCargo().clone(false));
						
						DwProcedimentoDTO.getDwProcedimento().getDwProcarhoms().add(procarhom);
					}
				}
				lista.add(DwProcedimentoDTO);
			}
		}

		DwProcedimentosDTO listaRetorno = new DwProcedimentosDTO();
		listaRetorno.setListaDwProcedimentoDTO(lista);

		return listaRetorno;
	}
	
//	public DwProcedimentoDTO setDwProcedimento(DwProcedimentoDTO itemDTO) throws RegistroDesconhecidoException {
//
//		UsuarioRN usuarioRN = new UsuarioRN(this.getDao());		
//		OmUsr omUser = new OmUsr();
//		omUser = usuarioRN.getOmUsr(itemDTO.getDwProcedimento().getOmUsrByIdUsrrevisao().getCdUsr());
//		
//		Long idAntigo = itemDTO.getDwProcedimento().getIdProcedimento();
//		
//		DwProcedimento procedimentoRevisaoAntiga = null;
//		DwFolhaDAO dwFolhaDAO = new DwFolhaDAO(this.getDaoSession());
//		
//		DwProcedimentoDAO dwProcedimentoDAO = new DwProcedimentoDAO(getDaoSession());
//		DwProcedimento itemOriginal = new DwProcedimento();
//		
//		if (idAntigo != null) {
//			procedimentoRevisaoAntiga = dwProcedimentoDAO.getDwProcedimentoPorId(idAntigo);
//			itemOriginal = itemDTO.getDwProcedimento().clone(false);
//			salvarDesativandoOriginal(itemOriginal, new Date(), omUser);
//			dwFolhaDAO.alterarDwProcedimentoTodasFolhas(procedimentoRevisaoAntiga, itemOriginal);
//		} else {
//			itemOriginal.setIdProcedimento(null);
//			itemOriginal.setRevisao(1l);
//			itemOriginal.setDtRevisao(DataHoraRN.getDataHoraAtual());
//			itemOriginal.setDtStativo(DataHoraRN.getDataHoraAtual());
//			itemOriginal.setOmUsrByIdUsrrevisao(omUser);
//			itemOriginal.setOmUsrByIdUsrstativo(omUser);
//			itemOriginal.setCdProcedimento(itemDTO.getDwProcedimento().getCdProcedimento());
//			itemOriginal.setDsProcedimento(itemDTO.getDwProcedimento().getDsProcedimento());
//			itemOriginal.setStAtivo((byte) 1); 
//			
//			getDao().makePersistent(itemOriginal);
//			
//		}
//		
//		
//		if(itemDTO.getDwProcedimento().getDwProcativs() != null){
//			
//			for(DwProcativ dwProcativ: itemDTO.getDwProcedimento().getDwProcativs()){
//				
//				DwProcativ dwProcativPersistido = dwProcativ.clone(false);
//				dwProcativPersistido.setDwProcedimento(itemOriginal);
//				
//				DwGrpativ dwGrpativ = getDwGrpativ(dwProcativ.getDwGrpativ());
//				
//				if(dwProcativPersistido.getDwDetativs() != null){
//					dwProcativPersistido.getDwDetativs().clear();
//				}
//				AreaRN areaRN = new AreaRN();
//				areaRN.setDao(getDao());
//				DwTArea dwtarea = null;
//				try {
//					if (dwProcativ.getDwTArea() != null)
//						dwtarea = areaRN.getDwTArea(dwProcativ.getDwTArea().getCdArea(), true);
//				} catch (RegistroDesconhecidoException e) {
//					dwtarea = null;
//				}
//
//				dwProcativPersistido.setDwTArea(dwtarea);
//				dwProcativPersistido.setDwGrpativ(dwGrpativ);
//				getDao().makePersistent(dwProcativPersistido);
//				
//				//make dwProcativ.getDwDetativs()
//				for(DwDetativ dwDetativ : dwProcativ.getDwDetativs()){
//					setDwDetativ(dwProcativPersistido, dwDetativ);
//				}
//				
//			}
//		}
//		if(itemDTO.getDwProcedimento().getDwProcarhoms() != null){
//			
//			for(DwProcarhom dwProcarhom: itemDTO.getDwProcedimento().getDwProcarhoms()){
//				
//				DwProcarhom dwProcarhomPersistido = dwProcarhom.clone(false);
//				dwProcarhomPersistido.setDwProcedimento(itemOriginal);
//				
//				OmCargo omCargo = getOmCargo(dwProcarhom.getOmCargo());
//				
//				dwProcarhomPersistido.setOmCargo(omCargo);
//				getDao().makePersistent(dwProcarhomPersistido);
//				
//			}
//		}
//
//		FolhaDTO folhaDTO;
//		FolhaRN rn = new FolhaRN();
//		rn.setDao(getDao());
//		Set<DwFolha> folhas = itemDTO.getDwProcedimento().getDwFolhas();
//		if (itemDTO.getDwProcedimento().getDwFolhas() != null && itemDTO.getDwProcedimento().getDwFolhas().size() > 0) {
//            for (DwFolha itemFolha : folhas) {
//            	DwFolha dwFolha = itemFolha.clone(true);
//            	dwFolha.setDwProcedimento(itemOriginal);
//            	FolhaDTO filtro = new FolhaDTO();
//            	filtro.setFolha(dwFolha);
//        		folhaDTO = rn.setFolhaSemCadastroEtapaDTO(filtro);
//        		if(folhaDTO.getResultadoEvento() != folhaDTO.getEVENTO_BEM_SUCEDIDO()) {
//        			throw new RegistroDesconhecidoException();
//        		}
//            }
//        }
//
//		return itemDTO;
//	}
	
	public DwProcedimentoDTO setDwProcedimento(DwProcedimentoDTO itemDTO) throws RegistroDesconhecidoException {
		
		DwProcedimentoDTO retorno = new DwProcedimentoDTO();
		retorno.setResultadoEvento(retorno.getEVENTO_BEM_SUCEDIDO());
		
		Long idAntigo = itemDTO.getDwProcedimento().getIdProcedimento();
				
		DwProcedimentoDAO dwProcedimentoDAO = new DwProcedimentoDAO(getDaoSession());
		DwFolhaDAO dwFolhaDAO = new DwFolhaDAO(this.getDaoSession());
		UsuarioRN usuarioRN = new UsuarioRN(this.getDao());		
		
		OmUsr omUser = new OmUsr();
		omUser = usuarioRN.getOmUsr(itemDTO.getDwProcedimento().getOmUsrByIdUsrrevisao().getCdUsr());
		
		DwProcedimento procedimentoRevisaoAntiga = null;
		DwProcedimento itemOriginal = new DwProcedimento();
		
		if(idAntigo != null){
			procedimentoRevisaoAntiga = dwProcedimentoDAO.getDwProcedimentoPorId(idAntigo);
			itemOriginal = itemDTO.getDwProcedimento().clone(false);
			salvarDesativandoOriginal(itemOriginal, new Date(), omUser);
			
			procedimentoRevisaoAntiga.setStAtivo((byte) 0);
			getDao().makePersistent(procedimentoRevisaoAntiga);
			
			/// Alessandre, comentei o trecho abaixo pois nao eh necessario fazer isso
			//dwFolhaDAO.alterarDwProcedimentoTodasFolhas(procedimentoRevisaoAntiga, itemOriginal);
			
			// Remove das folhas antigas a referencia do procedimento antigo
			for (Iterator<DwFolha> i = procedimentoRevisaoAntiga.getDwFolhas().iterator(); i.hasNext();) {
				DwFolha folha = i.next();
				folha.setDwProcedimento(null);
				getDao().makePersistent(folha);
				i.remove();
			}
			
		} else {
			itemOriginal.setIdProcedimento(null);
			itemOriginal.setRevisao(1l);
			itemOriginal.setDtRevisao(DataHoraRN.getDataHoraAtual());
			itemOriginal.setDtStativo(DataHoraRN.getDataHoraAtual());
			itemOriginal.setOmUsrByIdUsrrevisao(omUser);
			itemOriginal.setOmUsrByIdUsrstativo(omUser);
			itemOriginal.setCdProcedimento(itemDTO.getDwProcedimento().getCdProcedimento());
			itemOriginal.setDsProcedimento(itemDTO.getDwProcedimento().getDsProcedimento());
			itemOriginal.setObs(itemDTO.getDwProcedimento().getObs());
			itemOriginal.setStAtivo((byte) 1); 
			
			DwProcedimento aux = dwProcedimentoDAO.getDwProcedimentoFromCd(itemOriginal.getCdProcedimento());
			if(aux != null) {
				retorno.setResultadoEvento(retorno.getERRO_PROCEDIMENTO_JA_EXISTE());
				return retorno;
			}
		}
		
		//SALVANDO DWPROCATIVS
		if(itemDTO.getDwProcedimento().getDwProcativs() != null){	
			for(DwProcativ item: itemDTO.getDwProcedimento().getDwProcativs()){
				DwProcativ procativ = new DwProcativ();
				procativ.copy(item, false);
				procativ.setIdProcativ(0l);
				DwGrpativ grupoAtividade = getDwGrpativ(item.getDwGrpativ());
				
				DwTArea area = null;
				if (item.getDwTArea() != null && item.getDwTArea().getCdArea() != null && item.getDwTArea().getCdArea().equals("") == false) {
					AreaRN areaRN = new AreaRN(getDao());
					area = areaRN.getDwTArea(item.getDwTArea().getCdArea(), true);
				}
				
				procativ.setDwProcedimento(itemOriginal);
				procativ.setDwGrpativ(grupoAtividade);
				procativ.setDwTArea(area);

				//SALVANDO DWDETATIVS
				for(DwDetativ dwDetativ : item.getDwDetativs()){
					DwDetativ dwDetativPersistido = new DwDetativ();
					dwDetativPersistido.copy(dwDetativ, false);
					dwDetativPersistido.setIdDetativ(0l);
					//deleteDwDetativ(dwDetativ);
					dwDetativPersistido.setDwProcativ(procativ);
					procativ.getDwDetativs().add(dwDetativPersistido);
				}
				itemOriginal.getDwProcativs().add(procativ);
			}
		}
				
		if(itemDTO.getDwProcedimento().getDwProcarhoms() != null){
			for(DwProcarhom item: itemDTO.getDwProcedimento().getDwProcarhoms()){				
				DwProcarhom procarhom = new DwProcarhom();
				procarhom.copy(item, false);
				procarhom.setIdProcarhom(0l);
				procarhom.setDwProcedimento(itemOriginal);
				OmCargo omCargo = getOmCargo(item.getOmCargo());
				procarhom.setOmCargo(omCargo);
				itemOriginal.getDwProcarhoms().add(procarhom);				
			}
		}
		
		try {
			itemOriginal = getDao().makePersistent(itemOriginal);
		} catch (Exception e) {
			e.printStackTrace();
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
			return retorno;
		}

		retorno.setDwProcedimento(itemOriginal.clone());
		
		if (itemDTO.getDwProcedimento().getDwFolhas() != null && itemDTO.getDwProcedimento().getDwFolhas().size() > 0) {
			FolhaRN rn = new FolhaRN(getDao());
			for (DwFolha itemFolha : itemDTO.getDwProcedimento().getDwFolhas()) {
				DwFolha folha = rn.pesquisaFolhaByCdEStSemRota(itemFolha.getCdFolha());
	           	folha.setDwProcedimento(itemOriginal);
	           	getDao().makePersistent(folha);
	           	DwFolha dwFolha = itemFolha.clone(false);
        		retorno.getDwProcedimento().getDwFolhas().add(dwFolha);
            }
        }
		
		retorno.getDwProcedimento().getDwProcarhoms().clear();
		for(DwProcarhom procarhom : itemDTO.getDwProcedimento().getDwProcarhoms()) {
			retorno.getDwProcedimento().getDwProcarhoms().add(procarhom);
		}
		
		return retorno;
	}
	
	public DwProcativ getDwProcativ(Long idProcativ){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select a");
		q.append("from DwProcativ a");
		q.append("inner join a.dwGrpativ b");
		q.append("where a.idProcativ = :idProcativ");
		q.defineParametro("idProcativ", idProcativ);
		q.setMaxResults(1);
		
		DwProcativ retorno = (DwProcativ) q.uniqueResult();
		
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public List<DwDetativ> getDwDetativ(Long idProcativ){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select a");
		q.append("from DwDetativ a");
		q.append("left join a.dwProcativ p");
		q.append("left join p.dwProcedimento pr");
		q.append("where p.idProcativ = :idProcativ");
		q.defineParametro("idProcativ", idProcativ);
		
		List<DwDetativ> listaPesquisa = null;
		listaPesquisa = q.query().list();

		List<DwDetativ> lista = new ArrayList<DwDetativ>();

		if (listaPesquisa != null) {
			for (DwDetativ item : listaPesquisa) {
				lista.add(item.clone(false));
			}
		}
		
		return lista;
	}
	@SuppressWarnings("unchecked")
	public List<DwDetativ> getAllDwDetativs(Long idProcedimento){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select a");
		q.append("from DwDetativ a");
		q.append("left join a.dwProcativ p");
		q.append("left join p.dwProcedimento pr");
		q.append("where pr.idProcedimento = :idProcedimento");
		q.defineParametro("idProcedimento", idProcedimento);
		
		List<DwDetativ> listaPesquisa = null;
		listaPesquisa = q.query().list();

		List<DwDetativ> lista = new ArrayList<DwDetativ>();

		if (listaPesquisa != null) {
			for (DwDetativ item : listaPesquisa) {
				DwDetativ detativ = item.clone(false);
				DwProcativ dwProcativ = item.getDwProcativ().clone(false);
				detativ.setDwProcativ(dwProcativ);
				lista.add(detativ);
				
			}
		}
		
		return lista;
	}
	public DwDetativ getFoto(Long idDetativ){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select a");
		q.append("from DwDetativ a");
		q.append("where a.idDetativ = :idDetativ");
		q.defineParametro("idDetativ", idDetativ);
		
		DwDetativ retorno = (DwDetativ) q.uniqueResult();

		
		return retorno;
	}
	
	private void deleteDwDetativ(DwDetativ dwDetativ){
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("delete ");
		q.append("from DwDetativ a ");
		q.append("where a.idDetativ = :id");
		q.defineParametro("id", dwDetativ.getIdDetativ());
		q.query().executeUpdate();		
	}
	
//	private void setDwDetativ(DwProcativ dwProcativPersistido, DwDetativ dwDetativ){
//		DwDetativ dwDetativPersistido = new DwDetativ();
//		dwDetativPersistido.copy(dwDetativ, false);
//		deleteDwDetativ(dwDetativ);
//		dwDetativPersistido.setDwProcativ(dwProcativPersistido);
//	}
	
	private DwGrpativ getDwGrpativ(DwGrpativ dwGrpativ){
		GrupoAtivRN grupoAtivRN = new GrupoAtivRN(this.getDao());
		DwGrpativDTO filtroDTO = new DwGrpativDTO();
		filtroDTO.setDwGrpativ(dwGrpativ);
		DwGrpativDTOs grpativDTOs = grupoAtivRN.getDwGrpativ(filtroDTO);
		return grpativDTOs.getListaDwGrpativDTO().get(0).getDwGrpativ();
	}
	
	private OmCargo getOmCargo(OmCargo omCargo){
		CargoRN cargoRN = new CargoRN(this.getDao());
		OmCargoDTO filtroDTO = new OmCargoDTO();
		OmCargo filtro = new OmCargo();
		filtro.setCdCargo(omCargo.getCdCargo());
		filtro.setDsCargo(omCargo.getDsCargo());
		filtroDTO.setOmCargo(filtro);
		
		OmCargosDTO omCargosDTO = cargoRN.getCargo(filtroDTO);
		
		return omCargosDTO.getListaOmCargoDTO().get(0).getOmCargo();
	}
	public void salvarDesativandoOriginal(DwProcedimento dwProcedimentoDB, DwProcedimento dwProcedimento, Date dateOperacao, OmUsr omUsrOperacao) {
		this.getDao().salvarDesativandoOriginal(dwProcedimentoDB, dwProcedimento, dateOperacao, omUsrOperacao);
	}

	public void salvarDesativandoOriginal(DwProcedimento dwProcedimento, Date dateOperacao, OmUsr omUsrOperacao) {
		this.getDao().salvarDesativandoOriginal(dwProcedimento, dateOperacao, omUsrOperacao);
	}
	
	public DwProcedimentosDTO removeDwProcedimento(DwProcedimentosDTO itens){
		List<DwProcedimentoDTO> listaRetorno = new ArrayList<DwProcedimentoDTO>();

			for(DwProcedimentoDTO item : itens.getListaDwProcedimentoDTO()){
				OmUsr omUser = new OmUsr();
				UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
				try {
					omUser = usuarioRN.getOmUsr(item.getDwProcedimento().getOmUsrByIdUsrrevisao().getCdUsr());
				} catch (RegistroDesconhecidoException e) {
					e.printStackTrace();
				}
				try {
					removerProcedimentoDaFolha(item.getDwProcedimento());
					desativarDwProcedimento(item.getDwProcedimento().getIdProcedimento(),new Date(), omUser);
				} catch (RegistroJaDesativadoException e) {
					e.printStackTrace();
				}
				listaRetorno.add(item);
			}

			DwProcedimentosDTO itensRetorno = new DwProcedimentosDTO();
			itensRetorno.setListaDwProcedimentoDTO(listaRetorno);
			return itensRetorno;
	}
	
	private void removerProcedimentoDaFolha(DwProcedimento procedimento) {
		DwFolhaDAO dao = new DwFolhaDAO(getDaoSession());
		List<DwFolha> listaFolhas = dao.getDwFolhasPorProcedimento(procedimento.getIdProcedimento());
		for(DwFolha folha : listaFolhas) {
			folha.setDwProcedimento(null);
			getDao().makePersistent(folha);
		}
	}

	/**
	 * Desativa relacionado ao código
	 * @param cdDwProcedimento
	 * @param date
	 * @param omUsr usuário que está desativando
	 * @throws RegistroJaDesativadoException
	 * @throws RegistroDesconhecidoException
	 */
	public void desativarDwProcedimento(String cdDwProcedimento, Date date, OmUsr omUsr) throws RegistroDesconhecidoException, RegistroJaDesativadoException{
		this.getDao().desativar(DwProcedimento.class,cdDwProcedimento, DwProcedimentoTemplate._FIELD_NAME_CD, null, date, omUsr);
	}

	/**
	 * Desativa {@code DwProcedimento} relacionado ao id do procedimento
	 * @param idDwProcedimento
	 * @param dataHoraAtual
	 * @throws RegistroJaDesativadoException
	 */
	public void desativarDwProcedimento(long idDwProcedimento,  Date date, OmUsr omUsr) throws RegistroJaDesativadoException{
		this.getDao().desativar(DwProcedimento.class, idDwProcedimento, date, omUsr);
	}

}
