package idw.model.rn;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwRotaDAO;
import idw.model.dao.MapQuery;
import idw.model.dao.OmGtDAO;
import idw.model.dao.OmUsrDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwOperacao;
import idw.model.pojos.DwRota;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.DwRotapassoPt;
import idw.model.pojos.DwRpPredecessora;
import idw.model.pojos.DwTOperacao;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmImg;
import idw.model.pojos.OmObj;
import idw.model.pojos.OmProcomest;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTexto;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpPlano;
import idw.model.pojos.template.OmObjTemplate;
import idw.model.rn.estoque.EstoqueRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.DwFolhaDTO;
import idw.webservices.dto.DwFolhasDTO;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.dto.ProdutosDTO;
import idw.webservices.dto.RoteiroDTO;
import idw.webservices.dto.RoteirosDTO;


public class RoteiroRN extends AbstractRN<DAOGenerico>{

	public RoteiroRN(DAOGenerico dao){
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	public RoteiroRN(){
		this(null);

	}

	public RoteirosDTO getRoteirosDTO(RoteiroDTO filtro){

		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select t ");
		q.append("from DwRota t ");

		q.appendWhere(MapQuery._NULL, "t.idRota=:idRota", filtro.getRoteiro().getIdRota()!=0);
		q.appendWhere(MapQuery._AND, "t.cdRota like :cdRota", (filtro.getRoteiro().getCdRota() != null) && !filtro.getRoteiro().getCdRota().equals(""));
		q.appendWhere(MapQuery._AND, "t.dsRota=:dsRota", (filtro.getRoteiro().getDsRota() != null) && !filtro.getRoteiro().getDsRota().equals(""));
		q.appendWhere(MapQuery._AND, "t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF ", filtro.getRoteiro().getDtRevisao()!=null);
		q.appendWhere(MapQuery._AND, "t.omGt.cdGt=:cdGt", (filtro.getRoteiro().getOmGt() != null) && !filtro.getRoteiro().getOmGt().getCdGt().equals(""));
		q.appendWhere(MapQuery._AND, "t.omGt.dsGt=:dsGt", (filtro.getRoteiro().getOmGt() != null) && !filtro.getRoteiro().getOmGt().getDsGt().equals(""));

		
		q.appendWhere(MapQuery._AND, "t.omProduto.cdProduto=:cdProduto", (filtro.getRoteiro().getOmProduto() != null) && !filtro.getRoteiro().getOmProduto().getCdProduto().equals(""));
		q.appendWhere(MapQuery._AND, "t.omProduto.dsProduto=:dsProduto", (filtro.getRoteiro().getOmProduto() != null) && !filtro.getRoteiro().getOmProduto().getDsProduto().equals(""));
		q.appendWhere(MapQuery._AND, "t.omUsrByIdUsrrevisao.cdUsr=:cdUsrRev", (filtro.getRoteiro().getOmUsrByIdUsrrevisao() != null) && !filtro.getRoteiro().getOmUsrByIdUsrrevisao().getCdUsr().equals(""));
		q.appendWhere(MapQuery._AND, "t.omUsrByIdUsrrevisao.dsNome=:dsNomeRev", (filtro.getRoteiro().getOmUsrByIdUsrrevisao() != null) && !filtro.getRoteiro().getOmUsrByIdUsrrevisao().getDsNome().equals(""));
		q.appendWhere(MapQuery._AND, "t.omUsrByIdUsrstativo.cdUsr=:cdUsrSt", (filtro.getRoteiro().getOmUsrByIdUsrstativo() != null) && !filtro.getRoteiro().getOmUsrByIdUsrstativo().getCdUsr().equals(""));
		q.appendWhere(MapQuery._AND, "t.omUsrByIdUsrstativo.dsNome=:dsNomeSt", (filtro.getRoteiro().getOmUsrByIdUsrstativo() != null) && !filtro.getRoteiro().getOmUsrByIdUsrstativo().getDsNome().equals(""));
		q.appendWhere(MapQuery._AND, "t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF", filtro.getRoteiro().getDtStativo()!=null);
		q.appendWhere(MapQuery._AND, "t.revisao=:revisao", filtro.getRoteiro().getRevisao()!=null);
		q.appendWhere(MapQuery._AND, "t.stAtivo=:stAtivo", (filtro.getRoteiro().getStAtivo() != null) && (filtro.getRoteiro().getStAtivo()<(byte)2));

		q.defineParametro("idRota", filtro.getRoteiro().getIdRota());
		q.defineParametro("cdRota", filtro.getRoteiro().getCdRota());
		q.defineParametro("dsRota", filtro.getRoteiro().getDsRota());
		if (filtro.getRoteiro().getOmGt()!=null){
			q.defineParametro("cdGt", filtro.getRoteiro().getOmGt().getCdGt());
			q.defineParametro("dsGt", filtro.getRoteiro().getOmGt().getDsGt());
		}
		if (filtro.getRoteiro().getOmProduto()!=null){
			q.defineParametro("cdProduto", filtro.getRoteiro().getOmProduto().getCdProduto());
			q.defineParametro("dsProduto", filtro.getRoteiro().getOmProduto().getDsProduto());
		}
		if (filtro.getRoteiro().getOmUsrByIdUsrrevisao()!=null){
			q.defineParametro("cdUsrRev", filtro.getRoteiro().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getRoteiro().getOmUsrByIdUsrrevisao().getDsNome());
		}
		if (filtro.getRoteiro().getOmUsrByIdUsrstativo()!=null){
			q.defineParametro("cdUsrSt", filtro.getRoteiro().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getRoteiro().getOmUsrByIdUsrstativo().getDsNome());
		}
		q.defineParametro("revisao", filtro.getRoteiro().getRevisao());
		q.defineParametro("stAtivo", filtro.getRoteiro().getStAtivo());

		try {
			q.defineParametroData("dtRevisao", filtro.getRoteiro().getDtRevisao());
			q.defineParametroData("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getRoteiro().getDtRevisao()));
		} catch (Exception e) {

		}
		try {
			q.defineParametroData("dtStativo", filtro.getRoteiro().getDtStativo());
			q.defineParametroData("dtStativoF",DataHoraRN.getDataHora235959(filtro.getRoteiro().getDtStativo()));
		} catch (Exception e) {

		}

		q.setMaxResults(10);
		
		List<DwRota> listaPesquisa = null;
		try{
			listaPesquisa = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<RoteiroDTO> lista = new ArrayList<RoteiroDTO>();

		if (listaPesquisa != null){
			for (DwRota item : listaPesquisa) {
				RoteiroDTO itemDTO = new RoteiroDTO();
				itemDTO.setRoteiro((DwRota)item.clone(false));
				itemDTO.getRoteiro().setOmProduto(item.getOmProduto().clone(false));
				itemDTO.getRoteiro().setOmGt(item.getOmGt().clone(false));
				itemDTO.getRoteiro().setOmUsrByIdUsrrevisao(item.getOmUsrByIdUsrrevisao().clone(false));
				itemDTO.getRoteiro().setOmUsrByIdUsrstativo(item.getOmUsrByIdUsrstativo().clone(false));

				if (item.getDwRotapassos() != null){
					itemDTO.getRoteiro().setDwRotapassos(new HashSet<DwRotapasso>());
					for (DwRotapasso itemRotapasso : item.getDwRotapassos()) {
						DwRotapasso rotapasso = (DwRotapasso)itemRotapasso.clone(false);

						rotapasso.setDwFolha(itemRotapasso.getDwFolha().clone(false));
						
						if (itemRotapasso.getDwRotapassoByIdRotapassosucessoNc() != null) {
							rotapasso.setDwRotapassoByIdRotapassosucessoNc(itemRotapasso.getDwRotapassoByIdRotapassosucessoNc().clone());
						}
						
						if (itemRotapasso.getDwEst() != null)
							rotapasso.setDwEst(itemRotapasso.getDwEst().clone(false));
						
						if (itemRotapasso.getDwRpPredecessorasForIdRotapassoPai() != null){
							rotapasso.setDwRpPredecessorasForIdRotapassoPai(new HashSet<DwRpPredecessora>());
							for (DwRpPredecessora dwRpPredecessora : itemRotapasso.getDwRpPredecessorasForIdRotapassoPai()){
								rotapasso.getDwRpPredecessorasForIdRotapassoPai().add((DwRpPredecessora)dwRpPredecessora.clone());
							}
						}

						if (itemRotapasso.getDwRotapassoPts() != null){
							rotapasso.setDwRotapassoPts(new HashSet<DwRotapassoPt>());
							for (DwRotapassoPt dwrotapassopt : itemRotapasso.getDwRotapassoPts()){
								rotapasso.getDwRotapassoPts().add((DwRotapassoPt) dwrotapassopt.clone());
							}
						}
						itemDTO.getRoteiro().getDwRotapassos().add(rotapasso);

					}
				}

				itemDTO.getRoteiro().setOmObjsForIdRota(new HashSet<OmObj>());
				if (item.getOmObjsForIdRota() != null) {
					for (OmObj itemObj : item.getOmObjsForIdRota()) {
						OmObj passos = null;
						passos = itemObj.clone(true); //coloquei true porque nao tava exibindo os obj no layout
						
						//preciso clonar tb os objetos de origem e destino pelo menos a referencia para poder pegar na GUI
						if (itemObj.getOmObjByIdObjorigem() != null) {
							OmObj omobjOrigem = new OmObj();
							omobjOrigem.setIdObj(itemObj.getOmObjByIdObjorigem().getIdObj());
							if (itemObj.getOmObjByIdObjorigem().getDwFolhaByIdFolha() != null) {
								omobjOrigem.setDwFolhaByIdFolha(itemObj.getOmObjByIdObjorigem().getDwFolhaByIdFolha().clone(false));
							}
							if (itemObj.getOmObjByIdObjorigem().getDwEstByIdEst() != null) {
								omobjOrigem.setDwEstByIdEst(itemObj.getOmObjByIdObjorigem().getDwEstByIdEst().clone(false));
							}
							if (itemObj.getOmObjByIdObjorigem().getOmImg() != null) {
								omobjOrigem.setOmImg(itemObj.getOmObjByIdObjorigem().getOmImg().clone(false));
							}
							
							passos.setOmObjByIdObjorigem(omobjOrigem);
						}
						if (itemObj.getOmObjByIdObjdestino() != null) {
							OmObj omobjDestino = new OmObj();
							omobjDestino.setIdObj(itemObj.getOmObjByIdObjdestino().getIdObj());
							if (itemObj.getOmObjByIdObjdestino().getDwFolhaByIdFolha() != null) {
								omobjDestino.setDwFolhaByIdFolha(itemObj.getOmObjByIdObjdestino().getDwFolhaByIdFolha().clone(false));
							}
							if (itemObj.getOmObjByIdObjdestino().getDwEstByIdEst() != null) {
								omobjDestino.setDwEstByIdEst(itemObj.getOmObjByIdObjdestino().getDwEstByIdEst().clone(false));
							}
							if (itemObj.getOmObjByIdObjdestino().getOmImg() != null) {
								omobjDestino.setOmImg(itemObj.getOmObjByIdObjdestino().getOmImg().clone(false));
							}

							passos.setOmObjByIdObjdestino(omobjDestino);
						}
						
						if(itemObj.getOmTexto() != null){
							passos.setOmTexto(itemObj.getOmTexto().clone());
						}
						itemDTO.getRoteiro().getOmObjsForIdRota().add(passos);
					}
				}

				itemDTO.setResultadoEvento(0);
				lista.add(itemDTO);
			}
		}

		RoteirosDTO dtoRetorno = new RoteirosDTO();
		dtoRetorno.setRoteiros(lista);
		return dtoRetorno;
	}
	
	
	public RoteirosDTO getRoteirosDTOSemClonarFilhos(RoteiroDTO filtro){

		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select t ");
		q.append("from DwRota t ");

		q.appendWhere(MapQuery._NULL, "t.idRota=:idRota", filtro.getRoteiro().getIdRota()!=0);
		q.appendWhere(MapQuery._AND, "t.cdRota like :cdRota", (filtro.getRoteiro().getCdRota() != null) && !filtro.getRoteiro().getCdRota().equals(""));
		q.appendWhere(MapQuery._AND, "t.dsRota=:dsRota", (filtro.getRoteiro().getDsRota() != null) && !filtro.getRoteiro().getDsRota().equals(""));
		q.appendWhere(MapQuery._AND, "t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF ", filtro.getRoteiro().getDtRevisao()!=null);
		q.appendWhere(MapQuery._AND, "t.omGt.cdGt=:cdGt", (filtro.getRoteiro().getOmGt() != null) && !filtro.getRoteiro().getOmGt().getCdGt().equals(""));
		q.appendWhere(MapQuery._AND, "t.omGt.dsGt=:dsGt", (filtro.getRoteiro().getOmGt() != null) && !filtro.getRoteiro().getOmGt().getDsGt().equals(""));

		
		q.appendWhere(MapQuery._AND, "t.omProduto.cdProduto=:cdProduto", (filtro.getRoteiro().getOmProduto() != null) && !filtro.getRoteiro().getOmProduto().getCdProduto().equals(""));
		q.appendWhere(MapQuery._AND, "t.omProduto.dsProduto=:dsProduto", (filtro.getRoteiro().getOmProduto() != null) && !filtro.getRoteiro().getOmProduto().getDsProduto().equals(""));
		q.appendWhere(MapQuery._AND, "t.omUsrByIdUsrrevisao.cdUsr=:cdUsrRev", (filtro.getRoteiro().getOmUsrByIdUsrrevisao() != null) && !filtro.getRoteiro().getOmUsrByIdUsrrevisao().getCdUsr().equals(""));
		q.appendWhere(MapQuery._AND, "t.omUsrByIdUsrrevisao.dsNome=:dsNomeRev", (filtro.getRoteiro().getOmUsrByIdUsrrevisao() != null) && !filtro.getRoteiro().getOmUsrByIdUsrrevisao().getDsNome().equals(""));
		q.appendWhere(MapQuery._AND, "t.omUsrByIdUsrstativo.cdUsr=:cdUsrSt", (filtro.getRoteiro().getOmUsrByIdUsrstativo() != null) && !filtro.getRoteiro().getOmUsrByIdUsrstativo().getCdUsr().equals(""));
		q.appendWhere(MapQuery._AND, "t.omUsrByIdUsrstativo.dsNome=:dsNomeSt", (filtro.getRoteiro().getOmUsrByIdUsrstativo() != null) && !filtro.getRoteiro().getOmUsrByIdUsrstativo().getDsNome().equals(""));
		q.appendWhere(MapQuery._AND, "t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF", filtro.getRoteiro().getDtStativo()!=null);
		q.appendWhere(MapQuery._AND, "t.revisao=:revisao", filtro.getRoteiro().getRevisao()!=null);
		q.appendWhere(MapQuery._AND, "t.stAtivo=:stAtivo", (filtro.getRoteiro().getStAtivo() != null) && (filtro.getRoteiro().getStAtivo()<(byte)2));

		q.defineParametro("idRota", filtro.getRoteiro().getIdRota());
		q.defineParametro("cdRota", filtro.getRoteiro().getCdRota());
		q.defineParametro("dsRota", filtro.getRoteiro().getDsRota());
		if (filtro.getRoteiro().getOmGt()!=null){
			q.defineParametro("cdGt", filtro.getRoteiro().getOmGt().getCdGt());
			q.defineParametro("dsGt", filtro.getRoteiro().getOmGt().getDsGt());
		}
		if (filtro.getRoteiro().getOmProduto()!=null){
			q.defineParametro("cdProduto", filtro.getRoteiro().getOmProduto().getCdProduto());
			q.defineParametro("dsProduto", filtro.getRoteiro().getOmProduto().getDsProduto());
		}
		if (filtro.getRoteiro().getOmUsrByIdUsrrevisao()!=null){
			q.defineParametro("cdUsrRev", filtro.getRoteiro().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getRoteiro().getOmUsrByIdUsrrevisao().getDsNome());
		}
		if (filtro.getRoteiro().getOmUsrByIdUsrstativo()!=null){
			q.defineParametro("cdUsrSt", filtro.getRoteiro().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getRoteiro().getOmUsrByIdUsrstativo().getDsNome());
		}
		q.defineParametro("revisao", filtro.getRoteiro().getRevisao());
		q.defineParametro("stAtivo", filtro.getRoteiro().getStAtivo());

		try {
			q.defineParametroData("dtRevisao", filtro.getRoteiro().getDtRevisao());
			q.defineParametroData("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getRoteiro().getDtRevisao()));
		} catch (Exception e) {

		}
		try {
			q.defineParametroData("dtStativo", filtro.getRoteiro().getDtStativo());
			q.defineParametroData("dtStativoF",DataHoraRN.getDataHora235959(filtro.getRoteiro().getDtStativo()));
		} catch (Exception e) {

		}

		q.setMaxResults(10);
		
		List<DwRota> listaPesquisa = null;
		try{
			listaPesquisa = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<RoteiroDTO> lista = new ArrayList<RoteiroDTO>();

		if (listaPesquisa != null){
			for (DwRota item : listaPesquisa) {
				RoteiroDTO itemDTO = new RoteiroDTO();
				itemDTO.setRoteiro((DwRota)item.clone(false));
				//itemDTO.getRoteiro().setOmProduto(item.getOmProduto().clone(false));
				//itemDTO.getRoteiro().setOmGt(item.getOmGt().clone(false));
				//itemDTO.getRoteiro().setOmUsrByIdUsrrevisao(item.getOmUsrByIdUsrrevisao().clone(false));
				//itemDTO.getRoteiro().setOmUsrByIdUsrstativo(item.getOmUsrByIdUsrstativo().clone(false));

				itemDTO.setResultadoEvento(0);
				lista.add(itemDTO);
			}
		}

		RoteirosDTO dtoRetorno = new RoteirosDTO();
		dtoRetorno.setRoteiros(lista);
		return dtoRetorno;
	}
	
	
	
	
	
	
	
	
	
	
	
	

	public RoteiroDTO setRoteiroDTO(RoteiroDTO itemDTO){
		PTRN prn = new PTRN(getDao());
		FolhaRN frn = new FolhaRN(getDao());
		EstoqueRN ern = new EstoqueRN(getDao());
		DiversosRN drn = new DiversosRN();
		drn.setDao(getDao());
		
		RoteiroDTO dtoRetorno = new RoteiroDTO();
		dtoRetorno.setResultadoEvento(dtoRetorno.getEVENTO_BEM_SUCEDIDO());

		if (itemDTO.getRoteiro() == null || itemDTO.getRoteiro().getCdRota().trim().equals("")){
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_CDROTA_INVALIDO());
			return dtoRetorno;
		}
		if (itemDTO.getRoteiro().getIdRota() > 0 && itemDTO.getRoteiro().getStAtivo().equals((byte)0)) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_CADASTRO_NAO_PODE_SER_REATIVADO());
			return dtoRetorno;
		}

		OmProduto produtoFinal = null;
		try {
			ProdutoRN rn = new ProdutoRN(getDao());
			produtoFinal = rn.getOmProduto(itemDTO.getRoteiro().getOmProduto().getCdProduto());
			if (produtoFinal == null) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PRODUTO_DESCONHECIDO());
				return dtoRetorno;
			}
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PRODUTO_DESCONHECIDO());
			e.printStackTrace();
			return dtoRetorno;
		}
		
		DwRotaDAO rotaDAO = new DwRotaDAO(getDaoSession());

		DwRota itemAlteracao = rotaDAO.getDwRotaPorId(itemDTO.getRoteiro().getIdRota());

		DwRota itemOriginal = null;

		if (itemAlteracao == null){
			itemOriginal = (DwRota)itemDTO.getRoteiro().clone();
			itemOriginal.setRevisao(1l);
			itemOriginal.setDtRevisao(new Date());
			itemOriginal.setStAtivo((byte)1);
			itemOriginal.setDtStativo(new Date());

			
			DwRota rotaJaCadastrada = rotaDAO.getDwRotaAtivaPorCd(itemOriginal.getCdRota());
			if (rotaJaCadastrada != null) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_ROTA_JA_EXISTE());
				return dtoRetorno;
			}
			List<DwRota> rotas = rotaDAO.getDwRotasAtivasPorProdutoFinal(produtoFinal, itemDTO.getRoteiro().getOmGt().getCdGt());
			if(!rotas.isEmpty()) {
				dtoRetorno.setRoteiro(rotas.get(0).clone(false));
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PRODUTO_JA_VINCULADO_A_OUTRA_ROTA());
				return dtoRetorno;
			}
		}else{
			// Testar se o registro esta desativado. Se sim retornar erro para GUI
			if (itemAlteracao.getStAtivo().equals((byte) 0)) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_ROTA_JA_EXISTE());
				return dtoRetorno;
			}
			
			itemOriginal = (DwRota)itemDTO.getRoteiro().clone();
			itemOriginal.setIdRota(0l);
			itemOriginal.setRevisao(itemAlteracao.getRevisao()+1);
			itemOriginal.setDtRevisao(new Date());
			itemOriginal.setStAtivo((byte)1);
			itemOriginal.setDtStativo(new Date());
			
			if(produtoFinal.getIdProduto() != itemAlteracao.getOmProduto().getIdProduto()) {
				List<DwRota> rotas = rotaDAO.getDwRotasAtivasPorProdutoFinal(produtoFinal, itemDTO.getRoteiro().getOmGt().getCdGt());
				if(!rotas.isEmpty()) {
					dtoRetorno.setRoteiro(rotas.get(0).clone(false));
					dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PRODUTO_JA_VINCULADO_A_OUTRA_ROTA());
					return dtoRetorno;
				}
			}

			itemAlteracao.setStAtivo((byte)0);
			itemAlteracao.setDtRevisao(new Date());
		}

		dtoRetorno.setResultadoEvento(this.validaRoteiro(itemDTO));
		if (dtoRetorno.getResultadoEvento() != dtoRetorno.getEVENTO_BEM_SUCEDIDO()){
			return dtoRetorno;
		}

		//DwRotapassos
		if (itemDTO.getRoteiro().getDwRotapassos() != null){
			itemOriginal.setDwRotapassos(new HashSet<DwRotapasso>());
			for (DwRotapasso itemList : itemDTO.getRoteiro().getDwRotapassos()) {
				itemList.setIdRotapasso(0l);
				itemList.setDwRota(itemOriginal);
				
				if (itemList.getDwFolha() == null || itemList.getDwFolha().getIdFolha() == null) {
					dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_FOLHA_DESCONHECIDA());
					return dtoRetorno;
				}
				
				// verificar de alguma forma se a predecessora leva ao mesmo passo. se sim retornar erro e nao salvar
				StringBuilder erroRoteiroCircular = avaliarSeRoteiroCircular(itemList, itemList.getDwRpPredecessorasForIdRotapassoPai());
				if (erroRoteiroCircular != null) {
					dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_ROTEIRO_INCONSISTENTE());
					dtoRetorno.setComplemento(erroRoteiroCircular.toString());
				}
				itemOriginal.getDwRotapassos().add(itemList);
				
				for (DwRotapassoPt rotaPassoPt :itemList.getDwRotapassoPts()){
					if (rotaPassoPt.getOmPt() == null || rotaPassoPt.getOmPt().getIdPt() == null || rotaPassoPt.getOmPt().getIdPt() <= 0) {
						dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PT_DESCONHECIDO());
						return dtoRetorno;
					}
 					rotaPassoPt.setDwRotapasso(itemList);
				 }
			}
			
			
			/* Apos inicializar todos os passos, Avaliar se o passo tem uma sucessora NC. Se tiver, possivelmente o id estsa desatualizado, devemos fazer referencia 
			 * ao novo id, que ainda nao foi incluido
			 * 
			 */
			for (DwRotapasso dwrotapassoAux : itemOriginal.getDwRotapassos()) {
				if (dwrotapassoAux.getDwRotapassoByIdRotapassosucessoNc() != null) {
					DwRotapasso dwrotapassoNovo = null;
					// Procurar a referencia correta
					for (DwRotapasso dwrotapassoAuxSub : itemOriginal.getDwRotapassos()) {
						if (dwrotapassoAux.getDwRotapassoByIdRotapassosucessoNc().getDwFolha().getCdFolha().equals(dwrotapassoAuxSub.getDwFolha().getCdFolha())) {
							dwrotapassoNovo = dwrotapassoAuxSub;
							break;
						}
					}
					dwrotapassoAux.setDwRotapassoByIdRotapassosucessoNc(dwrotapassoNovo);
				}
			}
		}
		

		
		
		
		OmGt omGtGeral;
		try {
			OmGtDAO gtDAO = new OmGtDAO(getDaoSession());
			omGtGeral = gtDAO.getOmGtPorCdAtivoOrderById(itemDTO.getRoteiro().getOmGt().getCdGt());
			if(omGtGeral == null) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_GT_DESCONHECIDO());
				return dtoRetorno;	
			}
			itemOriginal.setOmGt(omGtGeral);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_GT_DESCONHECIDO());
			e.printStackTrace();
			return dtoRetorno;
		}

		try {
			ProdutoRN rn = new ProdutoRN(getDao());
			OmProduto omProduto = rn.getOmProduto(itemDTO.getRoteiro().getOmProduto().getCdProduto());
			if (omProduto == null) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PRODUTO_DESCONHECIDO());
				return dtoRetorno;
			}
			itemOriginal.setOmProduto(omProduto);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PRODUTO_DESCONHECIDO());
			e.printStackTrace();
			return dtoRetorno;
		}

		OmUsrDAO usrDAO = new OmUsrDAO(getDaoSession());
		
		try {
			OmUsr omUsrRevisao = usrDAO.getOmUsrPorCdAtivoOrderById(itemDTO.getRoteiro().getOmUsrByIdUsrrevisao().getCdUsr());
			if(omUsrRevisao == null) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
				return dtoRetorno;
			}
			itemOriginal.setOmUsrByIdUsrrevisao(omUsrRevisao);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
			e.printStackTrace();
			return dtoRetorno;
		}

		try {
			OmUsr omUsrStAtivo = usrDAO.getOmUsrPorCdAtivoOrderById(itemDTO.getRoteiro().getOmUsrByIdUsrstativo().getCdUsr());
			if(omUsrStAtivo == null) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
				return dtoRetorno;
			}
			itemOriginal.setOmUsrByIdUsrstativo(omUsrStAtivo);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
			e.printStackTrace();
			return dtoRetorno;
		}
		
		if (itemOriginal.getOmObjsForIdRota() != null){
			itemOriginal.setOmObjsForIdRota(new HashSet<OmObj>());
		}
				
		if (dtoRetorno.getResultadoEvento() == dtoRetorno.getEVENTO_BEM_SUCEDIDO()){
												
			try{
				itemOriginal = this.getDao().makePersistent(itemOriginal);
				if (itemAlteracao != null){
					this.getDao().makePersistent(itemAlteracao);
				}
			} catch (Exception e){
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
				e.printStackTrace();
			}
						
			dtoRetorno.setRoteiro((DwRota)itemOriginal.clone());
			
			if(itemDTO.getRoteiro().getOmObjsForIdRota() != null){
				itemOriginal.setOmObjsForIdRota(new HashSet<OmObj>());

				/* Antes de incluilr os objetos iremos criar um map com os ids.omobjs que vieram da GUI para ter como referencia no momento
				 * de salvar as setas. Isso � importante pq no layout podemos ter a folha estoque ou imagem aparecendo mais de uma vez no desenho
				 */
				Map<Long, OmObj> omobjsSalvos = new HashMap<Long, OmObj>();
				
				// Incluir todos os objetos do layout do roteiro
				// Alias, incluir todos menos as linhas que ser�o incluidas no proximo loop
				// isso � necess�rio para poder salvar as linhas comm as referencias de omobj origem e destino da mesma
				for (OmObj obj : itemDTO.getRoteiro().getOmObjsForIdRota()) {
					
					// Incluir objetos diferentes da seta(linha)
					if (obj.getTpObj().equals(OmObjTemplate.TpObj.TIPO_INFO_MANUAL.getValue()) == false
							&&obj.getTpObj().equals(OmObjTemplate.TpObj.TIPO_INFO_ELETRO.getValue()) == false
							&&obj.getTpObj().equals(OmObjTemplate.TpObj.TIPO_KANBAN.getValue()) == false
							&&obj.getTpObj().equals(OmObjTemplate.TpObj.TIPO_EXTERNO_MATERIAL.getValue()) == false
							&&obj.getTpObj().equals(OmObjTemplate.TpObj.TIPO_EMPURRADA.getValue()) == false) {

						incluirOmObj(omobjsSalvos, frn, prn, drn, ern, omGtGeral, dtoRetorno, itemOriginal, obj);
					
						// se ocorreu algum erro retornar para a GUI
						if (dtoRetorno.getResultadoEvento() != dtoRetorno.getEVENTO_BEM_SUCEDIDO()) {
							return dtoRetorno;
						}
					}
				}
				
				// Agora salvar as setas considerando os objetos de origem e destino
				for (OmObj obj : itemDTO.getRoteiro().getOmObjsForIdRota()) {
					
					// Incluir apenas as setas
					if (obj.getTpObj().equals(OmObjTemplate.TpObj.TIPO_INFO_MANUAL.getValue()) == true
							||obj.getTpObj().equals(OmObjTemplate.TpObj.TIPO_INFO_ELETRO.getValue()) == true
							||obj.getTpObj().equals(OmObjTemplate.TpObj.TIPO_KANBAN.getValue()) == true
							||obj.getTpObj().equals(OmObjTemplate.TpObj.TIPO_EXTERNO_MATERIAL.getValue()) == true
							||obj.getTpObj().equals(OmObjTemplate.TpObj.TIPO_EMPURRADA.getValue()) == true) {

						incluirOmObj(omobjsSalvos, frn, prn, drn, ern, omGtGeral, dtoRetorno, itemOriginal, obj);
					
						// se ocorreu algum erro retornar para a GUI
						if (dtoRetorno.getResultadoEvento() != dtoRetorno.getEVENTO_BEM_SUCEDIDO()) {
							return dtoRetorno;
						}
					}
				}
				
				try{
					itemOriginal = this.getDao().makePersistent(itemOriginal);
				} catch (Exception e){
					dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
					e.printStackTrace();
				}
			}
			
			dtoRetorno.setRoteiro((DwRota)itemOriginal.clone());
			
			if (itemOriginal.getDwRotapassos() != null){
				dtoRetorno.getRoteiro().setDwRotapassos(new HashSet<DwRotapasso>());
				for (DwRotapasso itemRotapasso : itemOriginal.getDwRotapassos()) {
					DwRotapasso rotapasso = (DwRotapasso)itemRotapasso.clone();

					if (itemRotapasso.getDwRpPredecessorasForIdRotapassoPai() != null){
						rotapasso.setDwRpPredecessorasForIdRotapassoPai(new HashSet<DwRpPredecessora>());
						for (DwRpPredecessora dwRpPredecessora : itemRotapasso.getDwRpPredecessorasForIdRotapassoPai()){
							rotapasso.getDwRpPredecessorasForIdRotapassoPai().add((DwRpPredecessora)dwRpPredecessora.clone());
						}
					}
					
					if (itemRotapasso.getDwRotapassoByIdRotapassosucessoNc() != null) {
						rotapasso.setDwRotapassoByIdRotapassosucessoNc(itemRotapasso.getDwRotapassoByIdRotapassosucessoNc().clone());
					}

					dtoRetorno.getRoteiro().getDwRotapassos().add(rotapasso);



				}
			}

		}

		return dtoRetorno;
	}
	
	
	
	/* Avalia se o roteiro tem predecessoras que levam ao passo avaliado */
	private StringBuilder avaliarSeRoteiroCircular(DwRotapasso passo, Set<DwRpPredecessora> pres) {
		StringBuilder retorno = null;
		
		for (DwRpPredecessora pre : pres) {
			for (DwRpPredecessora prepre : pre.getDwRotapassoByIdRotapassoFilho().getDwRpPredecessorasForIdRotapassoPai()) {

				// Avalia se tem como pre o item pai (passo)
				if (prepre.getDwRotapassoByIdRotapassoFilho().getDwFolha().getCdFolha().equals(passo.getDwFolha().getCdFolha())) {
					retorno = new StringBuilder();
					retorno.append("Folha ");
					retorno.append(passo.getDwFolha().getCdFolha());
					retorno.append(" tem predecessora ");
					retorno.append(prepre.getDwRotapassoByIdRotapassoPai().getDwFolha().getCdFolha());
					retorno.append(" fechando um circulo de validação.");
					return retorno;
				}
			}
			
			// Chama recursivamente para avaliar se em algum passo pai vai aparecer
			retorno = avaliarSeRoteiroCircular(passo, pre.getDwRotapassoByIdRotapassoFilho().getDwRpPredecessorasForIdRotapassoPai());
		}
		
		
		return retorno;
	}
	
	
	
	private void incluirOmObj(Map<Long, OmObj> objs, FolhaRN frn, PTRN prn, DiversosRN drn, EstoqueRN ern, OmGt omGtGeral, RoteiroDTO dtoRetorno, DwRota itemOriginal, OmObj obj) {
		OmObj objNovo = obj.clone(true);
		// Arredonda x, y, x2 e y2 para no maximo 4 casas decimais
		objNovo.setX(Util.getBigDecimalComCasas(obj.getX(), 4) );
		objNovo.setY(Util.getBigDecimalComCasas(obj.getY(), 4) );
		objNovo.setX2(Util.getBigDecimalComCasas(obj.getX2(), 4) );
		objNovo.setY2(Util.getBigDecimalComCasas(obj.getY2(), 4) );
		
		// Pesquisar a folha associada
		if(obj.getDwFolhaByIdFolha() != null){
			DwFolha dwfolha = frn.pesquisaFolhaByCdEStSemRota(obj.getDwFolhaByIdFolha().getCdFolha());
			if (dwfolha == null) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_FOLHA_NAO_PERTENCE_ROTEIRO());
				return;
			}
			objNovo.setDwFolhaByIdFolha(dwfolha);
		}else{
			objNovo.setDwFolhaByIdFolha(null);
		}
		
		
		
		// Pesquisar o estoque associado
		if(obj.getDwEstByIdEst() != null){
			DwEst dwest = ern.pesquisarDwEstEStAtivoByCd(obj.getDwEstByIdEst().getCdEst());
			if (dwest == null) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
				return;
			}
			objNovo.setDwEstByIdEst(dwest);
		}else{
			objNovo.setDwEstByIdEst(null);
		}
		
		
		// Pesquisar a imagem associada
		if(obj.getOmImg() != null){
			OmImg omimg = drn.pesquisarOmImgStAvitoByCd(obj.getOmImg().getCdImg());
			if (omimg == null) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
				return;
			}							
			objNovo.setOmImg(omimg);
		}else{
			objNovo.setOmImg(null);
		}

		
		// Pesquisar o pt associado
		if(obj.getOmPt() != null){
			OmPt ompt = prn.pesquisarPtByCdPtStAtivo(obj.getOmPt().getCdPt());
			if (ompt == null) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
				return;
			}
			objNovo.setOmPt(ompt);
		}else{
			objNovo.setOmPt(null);
		}

		
		// Pesquisar o texto associado
		if(obj.getOmTexto() != null){
			try{
				OmTexto omTexto = drn.pesquisarOmTextoStAvitoById(obj.getOmTexto().getIdTexto());
				if(omTexto == null){
					omTexto = obj.getOmTexto();
					omTexto = this.getDao().makePersistent(omTexto);
					objNovo.setOmTexto(omTexto);
				}else{
					omTexto.setDsTexto(obj.getOmTexto().getDsTexto());
					omTexto = this.getDao().makePersistent(omTexto);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		// Se o objeto tiver um objeto de origem, pegar a referencia dele no banco. Isso ocorre para a linha
		if (obj.getOmObjByIdObjorigem() != null) {
			objNovo.setOmObjByIdObjorigem(objs.get(obj.getOmObjByIdObjorigem().getIdObj()));
			
			/*
			for (OmObj omobj : itemOriginal.getOmObjsForIdRota()) {
				// os items de origem de uma seta podem ser uma folha, um estoque, uma imagem. Assim devemos pesquisar usando-se esse tres aspectos
				if (omobj.getDwFolhaByIdFolha() != null && obj.getOmObjByIdObjorigem().getDwFolhaByIdFolha() != null) {
					if (omobj.getDwFolhaByIdFolha().getIdFolha().equals(obj.getOmObjByIdObjorigem().getDwFolhaByIdFolha().getIdFolha())) {
						objNovo.setOmObjByIdObjorigem(omobj);
					}
				} else  if (omobj.getDwEstByIdEst() != null && obj.getOmObjByIdObjorigem().getDwEstByIdEst() != null) {
					if (omobj.getDwEstByIdEst().getIdEst() == obj.getOmObjByIdObjorigem().getDwEstByIdEst().getIdEst()) {
						objNovo.setOmObjByIdObjorigem(omobj);
					}
				} else if (omobj.getOmImg() != null && obj.getOmObjByIdObjorigem().getOmImg() != null) {
					if (omobj.getOmImg().getIdImg() == obj.getOmObjByIdObjorigem().getOmImg().getIdImg()) {
						objNovo.setOmObjByIdObjorigem(omobj);
					}
				}
			}
			*/
		}

		
		// Se o objeto tiver um objeto de destino, pegar a referencia dele no banco. Isso ocorre para a linha
		if (obj.getOmObjByIdObjdestino() != null) {
			objNovo.setOmObjByIdObjdestino(objs.get(obj.getOmObjByIdObjdestino().getIdObj()));
			/*
			for (OmObj omobj : itemOriginal.getOmObjsForIdRota()) {
				// os items de origem de uma seta podem ser uma folha, um estoque, uma imagem. Assim devemos pesquisar usando-se esse tres aspectos
				if (omobj.getDwFolhaByIdFolha() != null && obj.getOmObjByIdObjdestino().getDwFolhaByIdFolha() != null) {
					if (omobj.getDwFolhaByIdFolha().getIdFolha().equals(obj.getOmObjByIdObjdestino().getDwFolhaByIdFolha().getIdFolha())) {
						objNovo.setOmObjByIdObjdestino(omobj);
					}
				} else  if (omobj.getDwEstByIdEst() != null && obj.getOmObjByIdObjdestino().getDwEstByIdEst() != null) {
					if (omobj.getDwEstByIdEst().getIdEst() == obj.getOmObjByIdObjdestino().getDwEstByIdEst().getIdEst()) {
						objNovo.setOmObjByIdObjdestino(omobj);
					}
				} else if (omobj.getOmImg() != null && obj.getOmObjByIdObjdestino().getOmImg() != null) {
					if (omobj.getOmImg().getIdImg() == obj.getOmObjByIdObjdestino().getOmImg().getIdImg()) {
						objNovo.setOmObjByIdObjdestino(omobj);
					}
				}
			}
			*/
		}

		
		
		
		// Preencher outros valores no pojo
		objNovo.setOmWebcam(null);
		objNovo.setDwRotaByIdRota(itemOriginal);
		objNovo.setIdObj(null);
		objNovo.setOmGtByIdGt(omGtGeral);
		objNovo.setOmGtByIdGtfilho(null);
		objNovo.setDwRotapasso(null);
		itemOriginal.getOmObjsForIdRota().add(objNovo);
		objs.put(obj.getIdObj(), objNovo);
	}


	public RoteirosDTO removeRoteirosDTO(RoteirosDTO itensDTO){

		List<RoteiroDTO> listaRetorno = new ArrayList<RoteiroDTO>();
		for (RoteiroDTO item : itensDTO.getRoteiros()){
			RoteiroDTO itemRetorno = new RoteiroDTO();
			String hql = "";

			hql = "from DwRota t where t.idRota = ::idRota";
			hql = hql.replaceAll("::idRota", String.valueOf(item.getRoteiro().getIdRota()));

			Query q = this.getDaoSession().createQuery(hql);

			DwRota itemOriginal = (DwRota) q.uniqueResult();

			if (itemOriginal == null){
				itemRetorno.setResultadoEvento(itemRetorno.getERRO_CDROTA_INVALIDO());
				itemRetorno.setRoteiro(item.getRoteiro());
			}else if (itemOriginal.getStAtivo()==0){
				itemRetorno.setResultadoEvento(itemRetorno.getERRO_CDROTA_INVALIDO());
				itemRetorno.setRoteiro((DwRota)itemOriginal.clone());
			}else{
				itemOriginal.setStAtivo((byte)0);
				itemOriginal.setDtStativo(new Date());

				try{
					itemOriginal = this.getDao().makePersistent(itemOriginal);
				} catch (Exception e){
					e.printStackTrace();
				}

				itemRetorno.setRoteiro((DwRota)itemOriginal.clone());

				itemRetorno.setResultadoEvento(0);
			}

			listaRetorno.add(itemRetorno);
		}

		RoteirosDTO itensRetorno = new RoteirosDTO();
		itensRetorno.setRoteiros(listaRetorno);
		return itensRetorno;
	}
	
	public DwRota pesquisarDwRotaByIdProduto(OmProduto omproduto, boolean isJoinFetchDwRotapassos){
		DwRota retorno = null;

		if ((omproduto == null) || (omproduto.getIdProduto() == 0)) {
			return null;
		}

		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("select dwrota");
		q.append("from DwRota dwrota");
		
		if(isJoinFetchDwRotapassos){
			q.append("LEFT JOIN FETCH dwrota.dwRotapassos dwRotaPasso");
			q.append("LEFT JOIN FETCH dwRotaPasso.dwFolha dwFolha");			
			q.append("LEFT JOIN FETCH dwFolha.dwFolhaiacs dwFolhaiac");
			q.append("LEFT JOIN FETCH dwFolhaiac.omProduto omProduto");
		}
		
		q.append("where dwrota.omProduto.idProduto = :idproduto");
		q.append("and dwrota.stAtivo = 1");
		q.append("order by dwrota.idRota desc");

		q.defineParametro("idproduto", omproduto.getIdProduto());
		q.setMaxResults(1);

		retorno = (DwRota) q.uniqueResult();

		return retorno;
	}

	public DwRota pesquisarDwRotaByCdProduto(OmProduto omproduto, boolean isJoinFetchDwRotapassos, boolean isJoinFetchLayout){
		DwRota retorno = null;

		if ((omproduto == null) || (omproduto.getCdProduto() == null)) {
			return null;
		}

		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("select distinct dwrota");
		q.append("from DwRota dwrota");
		
		if(isJoinFetchDwRotapassos){
			q.append("LEFT JOIN FETCH dwrota.dwRotapassos dwRotaPasso");
			q.append("LEFT JOIN FETCH dwRotaPasso.dwFolha dwFolha");			
			q.append("LEFT JOIN FETCH dwFolha.dwFolhaiacs dwFolhaiac");
			q.append("LEFT JOIN FETCH dwFolhaiac.omProduto omProduto");
		}
		if (isJoinFetchLayout) {
			q.append("left join fetch dwrota.omObjsForIdRota omobj");
			q.append("left join fetch omobj.dwFolhaByIdFolha dwfolha");
		}
		
		q.append("where dwrota.omProduto.cdProduto = :cdproduto");
		q.append("and dwrota.stAtivo = 1");
		q.append("order by dwrota.idRota desc");

		q.defineParametro("cdproduto", omproduto.getCdProduto());
		q.setMaxResults(1);

		retorno = (DwRota) q.uniqueResult();

		return retorno;
	}

	
	public DwRota pesquisarDwRotaByCdRota(String cdRota){
		DwRota retorno = null;

		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("select dwrota");
		q.append("from DwRota dwrota");
		q.append("join fetch dwrota.dwRotapassos dwrotapasso");
		q.append("where dwrota.cdRota = :cdrota");
		q.append("and dwrota.stAtivo = 1");

		q.defineParametro("cdrota", cdRota);
		q.setMaxResults(1);

		retorno = (DwRota) q.uniqueResult();

		return retorno.clone(true);
	}

	private int validaRoteiro(RoteiroDTO roteiro){
		RoteiroDTO retorno = new RoteiroDTO();

		for (DwRotapasso rotapasso : roteiro.getRoteiro().getDwRotapassos()) {
			if (rotapasso != null && rotapasso.getIsLiberacao() != null && rotapasso.getIsLiberacao()){
				//Verifica se o estoque existe
				try {
					String hql = "from DwEst t where t.idEst = ::idEst ";

					hql = hql.replaceAll("::idEst", String.valueOf(rotapasso.getDwEst().getIdEst()));

					Query q = this.getDaoSession().createQuery(hql);

					DwEst dwEst = (DwEst) q.list().get(0);

					rotapasso.setDwEst(dwEst);

				} catch (Exception e) {
					return retorno.getERRO_ESTOQUE_DESCONHECIDO();
				}
			}else{
				rotapasso.setDwEst(null);
			}

			//Verifica se pt existe
			if (rotapasso.getOmPt() != null){
				try {
					String hql = "from OmPt t where t.cdPt = '::cdPt' ";
					hql += "and t.stAtivo = 1 ";
					hql += "order by t.idPt ";

					hql = hql.replaceAll("::cdPt", rotapasso.getOmPt().getCdPt());

					Query q = this.getDaoSession().createQuery(hql);

					OmPt omPt = (OmPt) q.list().get(0);

					rotapasso.setOmPt(omPt);
				} catch (Exception e) {
					return retorno.getERRO_PT_DESCONHECIDO();
				}
			}

			int ocorrencias = 0;
			for (DwRotapasso folha : roteiro.getRoteiro().getDwRotapassos()) {
				if (rotapasso != null && rotapasso.getDwFolha() != null && 
						rotapasso.getDwFolha().getIdFolha() != null &&
						folha != null &&
						folha.getDwFolha() != null &&
						rotapasso.getDwFolha().getIdFolha().equals(folha.getDwFolha().getIdFolha())){
					ocorrencias++;
				}
			}
			if (ocorrencias > 1){
				return retorno.getERRO_FOLHA_DUPLICADA();
			}

			if (rotapasso.getDwRpPredecessorasForIdRotapassoPai() != null){
				for (DwRpPredecessora predecessora : rotapasso.getDwRpPredecessorasForIdRotapassoPai()) {
					predecessora.setDwRotapassoByIdRotapassoPai(rotapasso);
					boolean pertence = false;
					for (DwRotapasso folha : roteiro.getRoteiro().getDwRotapassos()) {
						if (predecessora.getDwRotapassoByIdRotapassoFilho() != null && predecessora.getDwRotapassoByIdRotapassoFilho().getDwFolha().getIdFolha().equals(folha.getDwFolha().getIdFolha())){
							predecessora.setIdRpPredecessora(0l);
							predecessora.setDwRotapassoByIdRotapassoFilho(folha);
							pertence = true;
							break;
						}
					}
					if (!pertence){
						return retorno.getERRO_FOLHA_NAO_PERTENCE_ROTEIRO();
					}

				}
			}

		}

		return retorno.getEVENTO_BEM_SUCEDIDO();
	}

	/**
	 * Esse metodo � usado no algoritmo de geracao das cps para determinar quais os ultimos passos de um roteiro
	 * Os ultimos passos sao importantes pois a geracao da cps comeca por eles
	 * Os ultimos passos sao aqueles que nao sao usados como predecessoras de outros. Apos eles a producao esta completa
	 */
	public List<DwRotapasso> obterUltimosPassos(IdwLogger log, int idLog, DwRota dwrota){
		List<DwRotapasso> ret = new ArrayList<DwRotapasso>();
		List<DwRotapasso> retorno = new ArrayList<DwRotapasso>();
		boolean isPassoEPredecessora = false;
		List<DwRotapasso> listaPassos = null;

		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("select passos");
		q.append("from DwRotapasso passos");
		q.append("left join fetch passos.dwRpPredecessorasForIdRotapassoPai predecessoras");
		q.append("where passos.dwRota = :rota");
		q.append("order by passos.passo, passos.idRotapasso");

		q.defineParametro("rota", dwrota);

		listaPassos = q.list();

		for (DwRotapasso dwrotapasso : listaPassos){
			isPassoEPredecessora = false;
			for (DwRotapasso subpasso : listaPassos){
				for (DwRpPredecessora predecessora : subpasso.getDwRpPredecessorasForIdRotapassoPai()){
					log.info(idLog, 20, "Folha " + dwrotapasso.getDwFolha().getCdFolha() + " � predecessora em " + predecessora.getDwRotapassoByIdRotapassoFilho().getDwFolha().getCdFolha() + "?");
					if (predecessora.getDwRotapassoByIdRotapassoFilho().getIdRotapasso() == dwrotapasso.getIdRotapasso()) {
						log.info(idLog, 20, "� predecessora com id " + dwrotapasso.getIdRotapasso() + " = " + predecessora.getDwRotapassoByIdRotapassoFilho().getIdRotapasso());
						isPassoEPredecessora = true;
						break;
					}
				}
				if (isPassoEPredecessora == true) {
					break;
				}
			}
			if (isPassoEPredecessora == false) {
				ret.add(dwrotapasso);
			}
		}
		
		boolean isPossui = false;
		for (DwRotapasso dwrotapasso: ret){
			for (DwRotapasso dwRota: retorno){
				if (dwrotapasso.getIdRotapasso() == dwRota.getIdRotapasso())
					isPossui = true;
			}
			if (isPossui == false)
				retorno.add(dwrotapasso);
			else isPossui = false;
		}
		return retorno;
	}
	
	public RoteiroDTO sugereRoteiro(String cdProduto){
		
		RoteiroDTO roteiro = new RoteiroDTO();
		DwRota rota = new DwRota();
		rota.setDwRotapassos(new HashSet<DwRotapasso>(0));
		
		List<DwRotapasso> listaRotapasso = new ArrayList<DwRotapasso>();
		List<DwRpPredecessora> listaDwRpPredecessoraAnterior = new ArrayList<DwRpPredecessora>();
		
		ProdutoRN prodRN = new ProdutoRN(this.getDao());
		
		FolhaRN folhaRn = new FolhaRN(this.getDao());
		
		double passo = 1.0;
		
		ProdutoDTO filtro = new ProdutoDTO();
		filtro.setProduto(new OmProduto());
		filtro.getProduto().setCdProduto(cdProduto);
		filtro.getProduto().setStAtivo((byte) 1);
		
		//1 - PASSO : Procurar o produto pelo cd
		ProdutosDTO produtoDTO = prodRN.getProdutosDTO(filtro);
		
		rota.setOmProduto(produtoDTO.getProdutos().get(0).getProduto());
		
		
		if ((produtoDTO.getProdutos() != null)&&(produtoDTO.getProdutos().size()>0)){
			
			if((produtoDTO.getProdutos().get(0).getProduto().getOmProcomestsForIdProduto() != null)&&
					(produtoDTO.getProdutos().get(0).getProduto().getOmProcomestsForIdProduto().size()>0)){
				//2 - PASSO: Selecionar os semi-acabados da estrutura
				recuperarSemiAcabados (produtoDTO, prodRN, folhaRn, listaRotapasso, listaDwRpPredecessoraAnterior, passo+1);
			}

			//3 - PASSO: Procurar as folhas da estrutura
			DwFolhasDTO folhasProduto = folhaRn.pesquisaProdutoNaFolha(cdProduto, -1);
			for(DwFolhaDTO folha: folhasProduto.getListaDwFolhaDTO()){
				
				rota.setOmGt(folha.getDwFolha().getOmGt());
				
				DwRotapasso rotapasso = new DwRotapasso();
				rotapasso.setDwFolha(folha.getDwFolha());
				rotapasso.setIsLiberacao(false);
				rotapasso.setQtMovimentacao(BigDecimal.ZERO);
				rotapasso.setPasso(BigDecimal.valueOf(passo));
				rotapasso.setTpMovimentacao(BigDecimal.ZERO);
				rotapasso.getDwRpPredecessorasForIdRotapassoPai().addAll(listaDwRpPredecessoraAnterior);
				listaRotapasso.add(rotapasso);
			}
			
		}

		rota.getDwRotapassos().addAll(listaRotapasso);
		roteiro.setRoteiro(rota);
		
		return roteiro;
	}
	
	public void recuperarSemiAcabados (ProdutosDTO produtoDTO, ProdutoRN prodRN, FolhaRN folhaRn,
			List<DwRotapasso> listaRotapasso, List<DwRpPredecessora> listaDwRpPredecessoraAnterior, double passo){

		List<DwRpPredecessora> listaDwRpPredecessoraAnt = new ArrayList<DwRpPredecessora>();
		
		for(OmProcomest omEst: produtoDTO.getProdutos().get(0).getProduto().getOmProcomestsForIdProduto()){
			
			ProdutoDTO filtroEST = new ProdutoDTO();
			filtroEST.setProduto(omEst.getOmProdutoByIdProdutomp());
			ProdutosDTO prodDTO = prodRN.getProdutosDTO(filtroEST);
			
			if ((prodDTO.getProdutos() != null) && (prodDTO.getProdutos().size()>0)&&
					(prodDTO.getProdutos().get(0).getProduto().getOmProcomestsForIdProduto() != null)
				&&(prodDTO.getProdutos().get(0).getProduto().getOmProcomestsForIdProduto().size()>0)){
				
					recuperarSemiAcabados (prodDTO, prodRN, folhaRn, listaRotapasso, listaDwRpPredecessoraAnt, passo+1);
			}

			if (omEst.getOmProdutoByIdProdutomp().getTpProduto() == (byte)3){
				
				DwFolhasDTO folhasProduto = folhaRn.pesquisaProdutoNaFolha(omEst.getOmProdutoByIdProdutomp().getCdProduto(), -1);
				
				if ((folhasProduto == null)|| (folhasProduto.getListaDwFolhaDTO().size()<=0)){
					if (listaDwRpPredecessoraAnt!=null && listaDwRpPredecessoraAnt.size()>0){
						listaDwRpPredecessoraAnterior = listaDwRpPredecessoraAnt;
					}
					continue;
				}
			
				listaDwRpPredecessoraAnterior.clear();
				
				
				for(DwFolhaDTO folha: folhasProduto.getListaDwFolhaDTO()){
					DwRotapasso rotapassoDW = new DwRotapasso();
					rotapassoDW.setDwFolha(folha.getDwFolha());
					rotapassoDW.setIsLiberacao(false);
					rotapassoDW.setQtMovimentacao(BigDecimal.ONE);
					rotapassoDW.setPasso(BigDecimal.valueOf(passo));
					rotapassoDW.setTpMovimentacao(BigDecimal.ZERO);
					rotapassoDW.setDwRpPredecessorasForIdRotapassoPai(new HashSet<DwRpPredecessora>(0));
					rotapassoDW.getDwRpPredecessorasForIdRotapassoPai().addAll(listaDwRpPredecessoraAnt);
					
					DwRpPredecessora rpPredecessora = new DwRpPredecessora();
					rpPredecessora.setDwRotapassoByIdRotapassoFilho(rotapassoDW);
					
					listaRotapasso.add(rotapassoDW);
					listaDwRpPredecessoraAnterior.add(rpPredecessora);
				}
			}else if (listaDwRpPredecessoraAnt!=null && listaDwRpPredecessoraAnt.size()>0){
				listaDwRpPredecessoraAnterior = listaDwRpPredecessoraAnt;
			}
		}
		passo=passo-1;
			
	}
	
	/**
	 * Apaga opera��o do produto acabado ou de todos os produtos acabado
	 * @param omProdutoAcabadoFiltro apagar s� as opera��es do produto acabado indicado. Se estiver nulo, apagar de todos os produtos
	 */
	public void apagarOperacoesTempoPadrao(OmProduto omProdutoAcabadoFiltro) {
		MapQuery q = new MapQuery(this.getDaoSession());

		q.append("delete from DwOperacao dwOperacao");
		
		if(omProdutoAcabadoFiltro != null){
			q.append("where dwOperacao.omProdutoByIdProdutoacabado.cdProduto = :cdProduto");
			q.defineParametro("cdProduto", omProdutoAcabadoFiltro.getCdProduto());
		}
		
		q.query().executeUpdate();		

		
	}

	public DwTOperacao getDwTOperacaoCriaSenaoExistir(String dsToperacao) {
		DwTOperacao dwTOperacao;
		try{
			dwTOperacao = this.getDwTOperacao(dsToperacao);
		}catch(RegistroDesconhecidoException e){
			dwTOperacao = this.criarDwTOperacao(dsToperacao);
		}
		return dwTOperacao;
	}

	private DwTOperacao getDwTOperacao(String dsToperacao) throws RegistroDesconhecidoException {
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("SELECT dwTOperacao FROM DwTOperacao dwTOperacao");
		q.append("WHERE dwTOperacao.dsToperacao = :dsToperacao");
		q.defineParametro("dsToperacao", dsToperacao);
		q.setMaxResults(1);
		
		DwTOperacao dwTOperacao = (DwTOperacao) q.uniqueResult();
		if(dwTOperacao == null){
			throw new RegistroDesconhecidoException("Opera��o [" + dsToperacao + "] desconhecida");
		}
		return dwTOperacao;
	}

	private DwTOperacao criarDwTOperacao(String dsToperacao) {
		DwTOperacao dwTOperacao = new DwTOperacao();
		dwTOperacao.setDsToperacao(dsToperacao);
		return this.getDao().makePersistent(dwTOperacao);
	}
	
	public static void main(String[] args){
		testGetDwRotasQueTemProdutoNoPasso();		
	}
	
	
	public List<DwOperacao> getOperacoesDoProdutoAcabado(String cdProduto) {
		MapQuery q = new MapQuery(this.getDaoSession());
		
		q.append("SELECT dwOperacao FROM DwOperacao dwOperacao");
		q.append(" INNER JOIN FETCH dwOperacao.omPt omPt");
		q.append(" INNER JOIN FETCH dwOperacao.omProdutoByIdProdutoacabado omProdutoByIdProdutoacabado");
		q.append(" INNER JOIN FETCH dwOperacao.omProdutoByIdProdutosemiacabado omProdutoByIdProdutosemiacabado");
		q.append(" INNER JOIN FETCH dwOperacao.dwTOperacao dwTOperacao");
		q.append(" WHERE omProdutoByIdProdutoacabado.cdProduto = :cdProdutoAcabado");
		
		q.defineParametro("cdProdutoAcabado", cdProduto);
		
		return q.list();
	}

	public List<DwOperacao> getOperacoesProdutoDoSemiacabado(String cdProduto) {
		MapQuery q = new MapQuery(this.getDaoSession());
		
		q.append("SELECT dwOperacao FROM DwOperacao dwOperacao");
		q.append(" INNER JOIN FETCH dwOperacao.omPt omPt");
		q.append(" INNER JOIN FETCH dwOperacao.omProdutoByIdProdutoacabado omProdutoByIdProdutoacabado");
		q.append(" INNER JOIN FETCH dwOperacao.omProdutoByIdProdutosemiacabado omProdutoByIdProdutosemiacabado");
		q.append(" INNER JOIN FETCH dwOperacao.dwTOperacao dwTOperacao");
		q.append(" WHERE omProdutoByIdProdutosemiacabado.cdProduto = :cdProdutoSemiacabado");
		
		q.defineParametro("cdProdutoSemiacabado", cdProduto);
		
		return q.list();
	}
	
	public List<DwRota> getDwRotaDeProdutosDosPlanosProducoesAtivos(PpPlano ppPlano){
		
		MapQuery query = new MapQuery(this.getDaoSession());
		
		query.append("select distinct dwRota");
		query.append("FROM DwRota dwRota");
		query.append("INNER JOIN FETCH dwRota.omProduto omProduto");
		query.append("INNER JOIN FETCH dwRota.dwRotapassos dwRotapassos");
		query.append("LEFT JOIN FETCH dwRotapassos.dwRpPredecessorasForIdRotapassoPai dwRpPredecessora");
		query.append("LEFT JOIN FETCH dwRpPredecessora.dwRotapassoByIdRotapassoFilho ");		
		query.append("INNER JOIN FETCH dwRotapassos.dwFolha dwFolha");
		query.append("INNER JOIN FETCH dwFolha.omTppt omTppt");
		query.append("WHERE dwRota.stAtivo = :stAtivo");
		query.append("and exists (from PpPlano ppplano join ppplano.ppPlanecs ppplanec ");
		query.append("            join ppplanec.ppNec ppnec");
		query.append("            where ppplano.stPlano = 0 and ppplano.stAtivo = 1 and ppnec.omProduto = omProduto");
		
		if(ppPlano != null){
			query.append(" and ppplano.cdPlano = :cdPlano ");
		}
		
		query.append(")" );

		query.defineParametro("stAtivo", (byte) 1);
		if(ppPlano != null){
			query.defineParametro("cdPlano", ppPlano.getCdPlano());
		}
		
		return query.list();
	}
	
	private MapQuery getMapQueryDwRotasQueTemProdutoNoPasso(String cdProduto){
		MapQuery query = new MapQuery(this.getDaoSession());
		
		query.append("select distinct dwRota");
		query.append("FROM DwRota dwRota");		
		query.append("INNER JOIN FETCH dwRota.dwRotapassos dwRotapassos");
		query.append("LEFT JOIN FETCH dwRotapassos.dwRpPredecessorasForIdRotapassoPai dwRpPredecessora");
		query.append("LEFT JOIN FETCH dwRpPredecessora.dwRotapassoByIdRotapassoFilho ");		
		query.append("left JOIN FETCH dwRotapassos.dwFolha dwFolha");		
		query.append("left JOIN FETCH dwFolha.dwFolhaiacs dwFolhaiac");
		query.append("left JOIN FETCH dwFolhaiac.omProduto omProduto");
		query.append("left join fetch dwFolha.dwFolharaps dwfolharap");
		query.append("left join fetch dwfolharap.dwFolharapcoms dwfolharapcom");
		query.append("left join fetch dwfolharapcom.omProduto omprodutorap");
		
		query.append("WHERE dwRota.stAtivo = :stAtivo");
		query.append("AND (omProduto.cdProduto = :cdProduto or omprodutorap.cdProduto = :cdProduto)");
		
		query.defineParametro("stAtivo", (byte) 1);
		query.defineParametro("cdProduto", cdProduto);
		
		return query;
	}

	public List<DwRotapasso> pesquisarDwRotapassoDaFolha(DwFolha dwfolha) {
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from DwRotapasso a");
		q.append("join a.dwFolha b");
		q.append("join a.dwRota c");
		q.append("where b.cdFolha = :cdfolha");
		q.append("and b.stAtivo = 1");
		q.append("and c.stAtivo = 1");
		
		q.defineParametro("cdfolha", dwfolha.getCdFolha());
		
		return q.list();
	}
	public List<DwRotapasso> pesquisarDwRotapassoComCdProdutoNoPasso(String cdProduto){
		MapQuery query = new MapQuery(this.getDaoSession());
		
		query.append("select distinct dwRotapassos");
		query.append("FROM DwRotapasso dwRotapassos");
		query.append("join dwRotapassos.dwRota dwrota");
		query.append("LEFT JOIN FETCH dwRotapassos.dwRpPredecessorasForIdRotapassoPai dwRpPredecessora");
		query.append("LEFT JOIN FETCH dwRpPredecessora.dwRotapassoByIdRotapassoFilho ");		
		query.append("left JOIN FETCH dwRotapassos.dwFolha dwFolha");		
		query.append("left JOIN FETCH dwFolha.dwFolhaiacs dwFolhaiac");
		query.append("left JOIN FETCH dwFolhaiac.omProduto omProduto");
		query.append("left join fetch dwFolha.dwFolharaps dwfolharap");
		query.append("left join fetch dwfolharap.dwFolharapcoms dwfolharapcom");
		query.append("left join fetch dwfolharapcom.omProduto omprodutorap");
		
		query.append("WHERE dwrota.stAtivo = :stAtivo");
		query.append("AND (omProduto.cdProduto = :cdProduto or omprodutorap.cdProduto = :cdProduto)");
		
		query.defineParametro("stAtivo", (byte) 1);
		query.defineParametro("cdProduto", cdProduto);
		
		return query.list();
	}

	private DwRota getDwRotaDeProdutoAcabado(String cdProdutoAcabado){
		MapQuery query = new MapQuery(this.getDaoSession());
		
		query.append("select distinct dwRota");
		query.append("FROM DwRota dwRota");		
		query.append("INNER JOIN FETCH dwRota.omProduto omProdutoAcabado");
		query.append("INNER JOIN FETCH dwRota.dwRotapassos dwRotapassos");
		query.append("LEFT JOIN FETCH dwRotapassos.dwRpPredecessorasForIdRotapassoPai dwRpPredecessora");
		query.append("LEFT JOIN FETCH dwRpPredecessora.dwRotapassoByIdRotapassoFilho ");		
		query.append("INNER JOIN FETCH dwRotapassos.dwFolha dwFolha");		
		query.append("INNER JOIN FETCH dwFolha.dwFolhaiacs dwFolhaiac");
		query.append("INNER JOIN FETCH dwFolhaiac.omProduto omProduto");
		query.append("WHERE dwRota.stAtivo = :stAtivo");
		query.append("AND omProdutoAcabado.cdProduto = :cdProdutoAcabado");
		
		query.append(")" );

		query.defineParametro("stAtivo", (byte) 1);
		query.defineParametro("cdProdutoAcabado", cdProdutoAcabado);
		
		query.setMaxResults(1);
		
		return (DwRota) query.uniqueResult();
		
	}
	
	/**
	 * 
	 * Pega roteiro que tem produto do IMC no passo.
	 * 
	 * <p>Semp Toshiba
	 * <br>Atualmente as opera��es de IMC n�o s�o cadastradas diretamente no IDW. Mas s�o pegas do ERP da Semp e baixadas na tabela DwOperacao.
	 * <br>Ent�o pego os produtos finais que tem o produto semiacabado em DwOperacao. 
	 * <br>E com base nele, � pego o primeiro roteiro que encontrar. 
	 *  
	 * @param cdProdutoIMC
	 * @return
	 */
	public DwRota getDwRotaQueTemProdutoIMCNoPasso(String cdProdutoIMC){
		List<DwOperacao> listaOperacoesProdutoIMC = getOperacoesProdutoDoSemiacabado(cdProdutoIMC);
		
		for(DwOperacao dwOperacao: listaOperacoesProdutoIMC){
			
			final DwRota dwRota = getDwRotaDeProdutoAcabado(dwOperacao.getOmProdutoByIdProdutoacabado().getCdProduto());
			if(dwRota != null){
				return dwRota;
			}
			
		}
		
		return null;
		
	}
	
	
	public DwRota getDwRotaQueTemProdutoIACNoPasso(String cdProdutoIAC){
		
		MapQuery query =  getMapQueryDwRotasQueTemProdutoNoPasso(cdProdutoIAC);		
		query.setMaxResults(1);
		
		return (DwRota) query.uniqueResult();
		
	}	
	


	public List<DwRota> getDwRotasQueTemProdutoNoPasso(String cdProduto){
		MapQuery query =  getMapQueryDwRotasQueTemProdutoNoPasso(cdProduto);
		return query.list();
	}
	
	public static void testGetDwRotasQueTemProdutoNoPasso(){
		RoteiroRN roteiroRN = new RoteiroRN();
		roteiroRN.setDao(new DAOGenerico());
		try{
			roteiroRN.getDao().iniciaConexaoBanco();
			//530726 item pai
			//System.out.println("roteiroRN.getDwRotaQueTemProdutoNoPasso(530691)");
			List<DwRota> dwRotas = roteiroRN.getDwRotasQueTemProdutoNoPasso("530691");
			if(dwRotas == null || dwRotas.isEmpty()){
				//System.out.println("dwRota == empty");
			}else{
				
				for(DwRota dwRota: dwRotas){
					System.out.println("dwRota == " + dwRota.getCdRota());	
				}
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			roteiroRN.getDao().rollBackTransacao();
		}finally{
			roteiroRN.getDao().finalizaConexaoBancoSemException();
		}
		
	}

	public DwRota getDwRotaByGtProduto(String cdPt) {
		PTRN prn = new PTRN(getDao());
		OmPt ompt;
		try {
			ompt = prn.getOmPt(cdPt);
		} catch (RegistroDesconhecidoException e) {
			return null;
		}
		PpCp ppcp =  ompt.getPpCp();
		if (ppcp == null)
			return null;
		
		OmProduto omproduto = ppcp.obtemPrimeiroProduto();
		if (omproduto == null)
			return null;
		
		DwRota retorno = null;
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwRota a");
		q.append("join a.omGt b");
		q.append("join a.omProduto c");
		q.append("where a.stAtivo = 1");
		q.append("and b.stAtivo = 1");
		q.append("and c.stAtivo = 1");
		q.append("and b.cdGt = :cdgt");
		q.append("and c.cdProduto = :cdproduto");
		q.defineParametro("cdgt", ompt.getOmGt().getCdGt());
		q.defineParametro("cdproduto", omproduto.getCdProduto());
		q.setMaxResults(1);
		retorno = (DwRota) q.uniqueResult();
		return retorno;
	}
}

