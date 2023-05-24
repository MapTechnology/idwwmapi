package idw.model.rn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCm;
import idw.model.pojos.PpCmcom;
import idw.webservices.dto.PpCmDTO;
import idw.webservices.dto.PpCmsDTO;
import idw.webservices.dto.ResultadoDTO;

public class PpCmRN implements IDao{

	private DAOGenerico dao;


	public PpCmRN(){
		if (this.dao == null){
			this.dao = new DAOGenerico();
		}
	}

	public PpCmRN(DAOGenerico dao){
		this.dao = dao;
	}

	@Override
	public void finalizaConexaoBanco() {
		this.dao.finalizaTransacao();
		this.dao.finalizaSessao();

	}
	public void iniciaConexaoBanco() {
		iniciaConexaoBanco(null);
	}

	@Override
	public void iniciaConexaoBanco(Session sessao) {
		this.dao.iniciaSessao();
		this.dao.iniciaTransacao();

	}

	public PpCm pesquisarPpCmPorCd(String cdCm){

		//verifica se j� existe um registro com  cd
		MapQuery q = new MapQuery(this.dao.getSession());
		q.append("select p");
		q.append("from PpCm p");
		q.append("where p.cdCm = :cdCm");
		q.append("and p.stAtivo =1");

		q.defineParametro("cdCm", cdCm);
		q.setMaxResults(1);

		PpCm retorno = (PpCm) q.uniqueResult();
		return retorno;
	}

	public PpCmDTO excluirRegistro(PpCmDTO dto) {
		PpCmDTO retorno = dto;
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultadoDTO(resultadoDTO);

		PpCm ppCm = null;

		// Pesquisa o Ppcm para excluir
		if (dto.getPpCm().getIdCm() != null){
			ppCm = this.dao.findById(PpCm.class, dto.getPpCm().getIdCm() , false);
		}


		// Se nao existir o registro desejado para exclusao, entao retornar ao solicitante informando registro desconhecido
		if (ppCm == null){
			resultadoDTO.setIdmensagem(resultadoDTO.CODIGO_DESCONHECIDO);
			return retorno;
		}

		// Se o registro solicitado para exclusao ja estiver marcado como excluir, retornar ao solicitante informando a situacao
		if(ppCm.getStAtivo() == 0) {
			resultadoDTO.setIdmensagem(resultadoDTO.ERRO_EXCLUI_STATIVO_ZERO);
			return retorno;
		}

		// Pesquisar o usuario logado
		OmUsr msusr = null;
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(this.dao.getSession());

		try {
			msusr = usuarioRN.getDao().findById(OmUsr.class, dto.getPpCm().getOmUsrByIdUsrstativo().getIdUsr(), false);

			if(msusr == null){
				resultadoDTO.setIdmensagem(resultadoDTO.USUARIO_DESCONHECIDO);
				return retorno;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}


		// Marca stAtivo com zero informando que registro foi desativado
		ppCm.setStAtivo((byte) 0);
		ppCm.setDtStativo(DataHoraRN.getDataHoraAtual());
		ppCm.setOmUsrByIdUsrstativo(msusr);

		ppCm = this.dao.makePersistent(ppCm);


		retorno = new PpCmDTO();
		retorno.setPpCm((PpCm) ppCm.clone());
		resultadoDTO.setIdmensagem(resultadoDTO.COM_SUCESSO);
		retorno.setResultadoDTO(resultadoDTO);

		return retorno;
	}



	public PpCmDTO salvarCmEstrutura(PpCmDTO itemDto){
		PpCmDTO retorno = new PpCmDTO();
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultadoDTO(resultadoDTO);

		//Pesquisar a CM para saber se j� existe, se existir marcar pra excluir
		PpCm ppCm = this.pesquisarPpCmPorCd(itemDto.getPpCm().getCdCm());
		if(ppCm != null) { // se existir marca como excluido
			ppCm.setStAtivo((byte) '0');
			ppCm.setDtStativo(DataHoraRN.getDataHoraAtual());
			this.dao.makePersistent(ppCm);
		}


        PpCm ppCmNovo = (PpCm) itemDto.getPpCm().clone();

        ppCmNovo.setIdCm(null);
        ppCmNovo.setStAtivo((byte)1);
        ppCmNovo.setDtStativo(DataHoraRN.getDataHoraAtual());
        ppCmNovo.setDtRevisao(DataHoraRN.getDataHoraAtual());

		//verifica a revisao, se ja existe incrementa de 1, seta direto valor 1
		if ((ppCmNovo.getRevisao() == null) || ((ppCmNovo.getRevisao() != null) && (ppCmNovo.getRevisao() <= 0)) ){
			ppCmNovo.setRevisao(1l);
		} else {
			ppCmNovo.setRevisao(ppCmNovo.getRevisao() + 1);
		}


		//verificar usuarios stAtivo e Revisao
		OmUsr omUsrStAtivo = null;
		OmUsr omUsrRevisao = null;
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(this.dao.getSession());

		try {
			omUsrStAtivo = usuarioRN.getDao().findById(OmUsr.class, itemDto.getPpCm().getOmUsrByIdUsrstativo().getIdUsr(), false);

			if(omUsrStAtivo == null) {
				resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.USUARIO_DESCONHECIDO).intValue());
				return retorno;

			}
		} catch(Exception e) {
			resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.USUARIO_DESCONHECIDO).intValue());
			return retorno;
		}

		try {

			omUsrRevisao = usuarioRN.getDao().findById(OmUsr.class, itemDto.getPpCm().getOmUsrByIdUsrstativo().getIdUsr(), false);

			if(omUsrRevisao == null) {
				resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.USUARIO_DESCONHECIDO).intValue());
				return retorno;

			}
		} catch(Exception e) {
			resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.USUARIO_DESCONHECIDO).intValue());
			return retorno;
		}

		ppCmNovo.setOmUsrByIdUsrstativo(omUsrStAtivo);
		ppCmNovo.setOmUsrByIdUsrrevisao(omUsrRevisao);


		//salvar filhos
		ppCmNovo.setPpCmcoms(new HashSet<PpCmcom>());

		ProdutoRN pRN = new ProdutoRN(dao);
		
		for (PpCmcom t :itemDto.getPpCm().getPpCmcoms()){
			t.setIdCmcom(null);
			t.setPpCm(ppCmNovo);
			t.setOmProdutoByFinal(pRN.getProdutoByCdEStAtivo(t.getOmProdutoByFinal().getCdProduto()));
			if (t.getOmProdutoByIdProdutoentra() != null) {
				OmProduto om = t.getOmProdutoByIdProdutoentra();
				t.setOmProdutoByIdProdutoentra(pRN.getProdutoByCdEStAtivo(t.getOmProdutoByIdProdutoentra().getCdProduto()));
				// Se nao encontrou, incluir um novo
				if (t.getOmProdutoByIdProdutoentra() == null){
					om.setIdProduto(0);
					om.setDsProduto("Componente incluido na importa��o da CM");
					om.setRevisao(1l);
					om.setDtRevisao(DataHoraRN.getDataHoraAtual());
					om.setStAtivo((byte) '1');
					om.setOmUsrByIdUsrrevisao(itemDto.getPpCm().getOmUsrByIdUsrrevisao());
					om.setOmUsrByIdUsrstativo(itemDto.getPpCm().getOmUsrByIdUsrrevisao());
					om.setDtStativo(DataHoraRN.getDataHoraAtual());
					om = pRN.incluirComponente(om);
					t.setOmProdutoByIdProdutoentra(om);
				}
			}
			
			if (t.getOmProdutoByIdProdutosai() != null){
				OmProduto om = t.getOmProdutoByIdProdutosai();
				t.setOmProdutoByIdProdutosai(pRN.getProdutoByCdEStAtivo(t.getOmProdutoByIdProdutosai().getCdProduto()));
				// Se nao encontrou, incluir um novo
				if (t.getOmProdutoByIdProdutosai() == null){
					om.setIdProduto(0);
					om.setDsProduto("Componente incluido na importa��o da CM");
					om.setRevisao(1l);
					om.setDtRevisao(DataHoraRN.getDataHoraAtual());
					om.setStAtivo((byte) '1');
					om.setOmUsrByIdUsrrevisao(itemDto.getPpCm().getOmUsrByIdUsrrevisao());
					om.setOmUsrByIdUsrstativo(itemDto.getPpCm().getOmUsrByIdUsrrevisao());
					om.setDtStativo(DataHoraRN.getDataHoraAtual());
					om = pRN.incluirComponente(om);
					t.setOmProdutoByIdProdutosai(om);
				}
			}
			
			ppCmNovo.getPpCmcoms().add(t);
		}



		ppCmNovo = this.dao.makePersistent(ppCmNovo);

		retorno = new PpCmDTO();
		retorno.setPpCm((PpCm) ppCmNovo.clone());
		resultadoDTO.setIdmensagem(resultadoDTO.COM_SUCESSO);
		retorno.setResultadoDTO(resultadoDTO);


		return retorno;
	}




	@SuppressWarnings("static-access")
	public PpCmsDTO pesquisarPpCm(PpCmDTO itemDTO){

		MapQuery q = new MapQuery(this.dao.getSession());
		q.append("select distinct p");
		q.append("from PpCm p");
		//q.append("join fetch p.ppCmcoms");
		q.appendWhere(q._NULL, "p.stAtivo = 1",true );
		q.appendWhere(q._AND, "p.cdCm = :cdCm", !itemDTO.getPpCm().getCdCm().equals(""));
		q.appendWhere(q._AND, "p.dsCm =:dsCm", !itemDTO.getPpCm().getDsCm().equals(""));
//		q.appendWhere(q._AND, "p.isConsumirmp = :isConsumirmp", itemDTO.getPpCm().getIsConsumirmp() != null);
//		q.appendWhere(q._AND, "p.dthrVigor = :dthrVigor", itemDTO.getPpCm().getDthrVigor() != null);

		q.defineParametro("cdCm", itemDTO.getPpCm().getCdCm());
		q.defineParametro("dsCm", itemDTO.getPpCm().getDsCm());
		q.defineParametro("dthrVigor", itemDTO.getPpCm().getDthrVigor());
		q.defineParametro("isConsumirmp", itemDTO.getPpCm().getIsConsumirmp());

		List<PpCm> listaPpCm =  q.list();


		PpCmsDTO retorno = new PpCmsDTO();

		if (listaPpCm == null){
			retorno.setListaPpCmDTO(new ArrayList<PpCmDTO>());
			return retorno;
		}

		List<PpCmDTO> listaDTO = new ArrayList<PpCmDTO>();

		for(PpCm ppCm : listaPpCm){
			PpCmDTO dto = new PpCmDTO();
			dto.setPpCm((PpCm) ppCm.clone());
			listaDTO.add(dto);
		}

		retorno.setListaPpCmDTO(listaDTO);
		return retorno;
	}


}
