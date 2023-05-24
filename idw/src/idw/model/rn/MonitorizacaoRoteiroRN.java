package idw.model.rn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRota;
import idw.model.pojos.OmImg;
import idw.model.pojos.OmObj;
import idw.model.pojos.OmPt;
import idw.webservices.dto.DwFolhaDTO;
import idw.webservices.dto.DwFolhasDTO;
import idw.webservices.dto.EstoqueDTO;
import idw.webservices.dto.EstoquesDTO;
import idw.webservices.dto.ImgDTO;
import idw.webservices.dto.ImgsDTO;
import idw.webservices.dto.ObjDTO;
import idw.webservices.dto.ObjsDTO;
import idw.webservices.dto.ObjsLayoutRoteiroDTO;
import idw.webservices.dto.PTsDTO;
import idw.webservices.dto.PtDTO;

//public class MonitorizacaoRoteiroRN extends DAOGenerico {
public class MonitorizacaoRoteiroRN extends AbstractRN<DAOGenerico>{

	public MonitorizacaoRoteiroRN() {
		this(null);
	}

	public MonitorizacaoRoteiroRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	/**
	 * Recupera os objetos conforme o filtro
	 * @param filtro
	 * 				<p><code>filtro.getObj().getDwRotaByIdRota().getIdRota()</code> pega objetos relacionados IdRota indicado
	 * 				<p><code>filtro.getObj().getDwFolhaByIdFolha().getIdFolha()</code> pega objetos relacionados IdFolha indicado
	 * 				<p><code>filtro.getObj().getDwEstByIdEst().getIdEst()</code> pega objetos relacionados IdEst indicado
	 * 				<p><code>filtro.getObj().getOmGtByIdGt().getIdGt()</code> pega objetos relacionados IdGt indicado
	 * 				<p><code>filtro.getObj().getOmGtByIdGtfilho().getIdGt()</code> pega objetos relacionados IdGt filho indicado
	 * 				<p><code>filtro.getObj().getOmPt().getIdGt()</code> pega objetos relacionados IdPt indicado
	 * 				<p>pega todos os objetos, caso nenhum filtro foi passado
	 * @param clonaResultado 
	 * 				<p> itens da lista devem ser clonados 
	 * @return lista de OmObj
	 */
	public ObjsDTO getObjsDTO(ObjDTO filtro, boolean clonaResultado) {

		MapQuery q = new MapQuery(getDaoSession());
		
		q.append(" select omObj ");
		q.append(" from OmObj omObj ");
		q.append(" left outer join omObj.dwEstByIdEst");
		q.append(" left outer join omObj.dwFolhaByIdFolha");
		q.append(" left outer join omObj.dwRotaByIdRota");
		q.append(" where 1=1 ");

		if (filtro.getObj() != null) {
			// IdRotaPasso
			if (filtro.getObj().getDwRotaByIdRota() != null && filtro.getObj().getDwRotaByIdRota().getIdRota() != 0) {
				q.append(" and omObj.dwRotaByIdRota.idRota=:idRota");
				q.defineParametro("idRota", filtro.getObj().getDwRotaByIdRota().getIdRota());
			}
			// IdFolha
			if (filtro.getObj().getDwFolhaByIdFolha() != null && filtro.getObj().getDwFolhaByIdFolha().getIdFolha() != 0) {
				q.append(" and omObj.dwFolhaByIdFolha.idFolha=:idFolha");
				q.defineParametro("idFolha", filtro.getObj().getDwFolhaByIdFolha().getIdFolha());
			}
			// IdEst
			if (filtro.getObj().getDwEstByIdEst() != null  && filtro.getObj().getDwEstByIdEst().getIdEst() != 0){
				q.append(" and omObj.dwEstByIdEst.idEst=:idEst");
				q.defineParametro("idEst", filtro.getObj().getDwEstByIdEst().getIdEst());
			}
		}

		List<OmObj> listaOmObj = null;

		listaOmObj = q.list();

		// Passa o resultado para uma lista de ObjDTO
		List<ObjDTO> lista = new ArrayList<ObjDTO>();
		for (OmObj omObj : listaOmObj) {
			ObjDTO obj = new ObjDTO();
			obj.setObj( (clonaResultado ? omObj.clone(true) : omObj ));
			lista.add(obj);
		}
		ObjsDTO Objs = new ObjsDTO();
		Objs.setObjs(lista);
		
		return Objs;
	}

	
	/**
	 * Pega uma lista de imagens
	 * 
	 * @param filtro
	 *            <p>
	 *            filtro.getImg().getIdImg() -> filtra pelo id de OmImg
	 *            <p>
	 *            filtro.getImg().getCdImg() -> filtra pelo c�digo de OmImg
	 *            <p>
	 *            se alguns dos parametros acima estiver null ou "" -> pega
	 *            todos as imagens
	 * @return
	 */
	public ImgsDTO getImgsDTO(ImgDTO filtro, boolean clonaResultado) {
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select omimg ");
		q.append("from OmImg omimg ");
		q.append("where omimg.stAtivo=1 ");
		
		if (filtro != null && filtro.getImg() != null) {
			if (filtro.getImg().getIdImg() != 0) {
				q.append("and omimg.idImg = :idImg");
				q.defineParametro("idImg", filtro.getImg().getIdImg());
			} else if (filtro.getImg().getCdImg() != null && !filtro.getImg().getCdImg().equals("")) {
				q.append("and omimg.cdImg = :cdImg");
				q.defineParametro("cdImg", filtro.getImg().getCdImg());
			}
			if(filtro.getImg().getUrlImg() != null){
				q.append("and omimg.urlImg like :urlImg");
				q.defineParametro("urlImg","'%"  + filtro.getImg().getUrlImg()+ "%'");
			}
		}

		List<OmImg> listaOmImg = null;

		listaOmImg = q.list();

		List<ImgDTO> lista = new ArrayList<>();

		for (OmImg omImg : listaOmImg) {
			ImgDTO img = new ImgDTO();
			img.setImg( (clonaResultado ? (OmImg) omImg.clone() : omImg));

			lista.add(img);
		}

		ImgsDTO imgs = new ImgsDTO();
		imgs.setImgs(lista);
		return imgs;

	}

	public ObjsLayoutRoteiroDTO getObjsLayoutRoteiroDTO(){
		ObjsLayoutRoteiroDTO retorno = new ObjsLayoutRoteiroDTO();
		MapQuery query = new MapQuery(this.getDaoSession());
		
		//metodo para obter imgs disponiveis
		ImgsDTO imgs = getImgsDTO(null, true);
		
		// construindo hql para recuperar PTs
		query.novaConsulta();

		query.append("select pt from OmPt pt");
		query.append("Where pt.stAtivo=1");

		List<OmPt> listaPts = query.list();

		List<PtDTO> listaPtDTO = new ArrayList<PtDTO>();

		if (listaPts != null) {
			for (OmPt pt : listaPts) {
				PtDTO ptDTO = new PtDTO();
				ptDTO.setPt(pt.clone(true));
				listaPtDTO.add(ptDTO);
			}
		}

		PTsDTO ptsDTO = new PTsDTO();
		ptsDTO.setPts(listaPtDTO);
				
		// construindo hql para recuperar Folhas
		query.novaConsulta();
				
		// hql para recupar as folhas disponiveis
		query.append("select folha from DwFolha folha");
		query.append("Where folha.stAtivo=1");
		query.append("order by folha.cdFolha");

		List<DwFolha> listaDwFolha = query.list();
		List<DwFolhaDTO> listaDwFolhaClones = new ArrayList<DwFolhaDTO>();
		DwFolhasDTO folhasDTO = new DwFolhasDTO();

		// clonando as folhas
		if (listaDwFolha != null) {
			for (DwFolha dwFolha : listaDwFolha) {
				DwFolhaDTO folhaDTO = new DwFolhaDTO();
				folhaDTO.setDwFolha(dwFolha.clone(false));
				listaDwFolhaClones.add(folhaDTO);
			}
		}
		folhasDTO.setListaDwFolhaDTO(listaDwFolhaClones);

		
		// construindo hql para recuperar Estoques
		query.novaConsulta();
				
		// hql para recupar os estoques disponiveis
		query.append("select estoque from DwEst estoque");
		query.append("Where estoque.stAtivo=1");

		List<DwEst> listaDwEstoque = query.list();
		List<EstoqueDTO> listaDwEstoqueClones = new ArrayList<EstoqueDTO>();
		EstoquesDTO estoquesDTO = new EstoquesDTO();

		// clonando os estoques
		if (listaDwEstoque != null) {
			for (DwEst dwEstoque : listaDwEstoque) {
				EstoqueDTO estoqueDTO = new EstoqueDTO();
				estoqueDTO.setEstoque(dwEstoque.clone(false));
				listaDwEstoqueClones.add(estoqueDTO);
			}
		}
		estoquesDTO.setEstoques(listaDwEstoqueClones);

		//setando lista para objeto retorno
		retorno.setEstoquesDTO(estoquesDTO);
		retorno.setFolhasDTO(folhasDTO);		
		retorno.setImgsDTO(imgs);
		retorno.setPtsDTO(ptsDTO);
		return retorno;
	}
	
	
	/**	Remove objetos
	 * 
	 * @param objsDTO
	 */
	
	private void removeObj(ObjsDTO objsDTO) {
		List<OmObj> objs = new ArrayList<OmObj>();
		
		for (ObjDTO obj : objsDTO.getObjs()) {
			objs.add(obj.getObj());
		}
		
		removeObj(objs);
	}
	
	/** Remove objetos
	 * 
	 * @param objs
	 */
	private void removeObj(List<OmObj> objs){
		for (OmObj obj : objs){
			this.getDaoSession().delete(obj);
		}
	}
	
	
	

	/** Salva objetos do roteiro
	 * 
	 * @param rota
	 */
	public void setObjsRoteiro(DwRota rota) {
		
		// Crit�rios para n�o continuar o processamento
		//System.out.println("setando os objetos..  1");
		if(rota.getOmObjsForIdRota() == null ) {
			//System.out.println("setando os objetos..  2");
			return;
		}
		
		// Apaga objs que pertenciam ao roteiro
		//System.out.println("setando os objetos..  3");
		removeObjs(rota);
		//System.out.println("setando os objetos..  4");

		// Adiciona os novos objetos do roteiro
		Set<OmObj> objs = new HashSet<OmObj>();
		//System.out.println("setando os objetos..  5");
		for(OmObj objItem: rota.getOmObjsForIdRota()){
			//System.out.println("setando os objetos..  6");
			objs.add( (OmObj) getDao().makePersistent(objItem));
		}
		//System.out.println("setando os objetos..  7");
		// Atualiza objetos de roteiro
		rota.setOmObjsForIdRota(objs);
		//System.out.println("setando os objetos..  8");
		
	}

	private void removeObjs(DwRota rota){
		if(rota == null || rota.getIdRota() == 0){
			return;
		}
		
		OmObj obj = new OmObj();
		obj.setDwRotaByIdRota(rota);
		ObjDTO objDTO = new ObjDTO();
		objDTO.setObj(obj);
		ObjsDTO objsDTO = getObjsDTO(objDTO,false);
		
		// Apaga objs que pertenciam ao GT
		removeObj(objsDTO);
		
	}	
	
}
