package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.DwOperacao;
import idw.model.pojos.DwOperacaocomp;
import idw.model.pojos.DwOperacaomidia;
import idw.model.pojos.DwOperacaopredecessora;
import idw.model.pojos.DwOperacaorap;
import idw.model.pojos.DwTOperacao;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.webservices.dto.DwOperacaoDTO;
import idw.webservices.dto.DwOperacoesDTO;
import idw.webservices.dto.ResultadoDTO;

public class OperacaoRN extends AbstractRN<DAOGenerico> {

	public OperacaoRN() {
		this(null);
	}

	public OperacaoRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public DwOperacoesDTO getDwOperacao(DwOperacaoDTO filtro){	
		DwOperacoesDTO dtoRetorno = new DwOperacoesDTO();
		dtoRetorno.setListaOperacoesDTO(new ArrayList<DwOperacaoDTO>());
		
		OmProduto produtoAcabado = null;
		OmProduto produtoSemiAcabado = null;
		
		ProdutoRN produtoRN = new ProdutoRN(this.getDao());
		
		if (filtro.getDwOperacao().getOmProdutoByIdProdutoacabado() !=  null && filtro.getDwOperacao().getOmProdutoByIdProdutoacabado().getCd() != null && filtro.getDwOperacao().getOmProdutoByIdProdutoacabado().getCd().trim().equals("") == false)
			produtoAcabado = produtoRN.getProdutoByCdEStAtivo(filtro.getDwOperacao().getOmProdutoByIdProdutoacabado().getCd());

		if (filtro.getDwOperacao().getOmProdutoByIdProdutosemiacabado() != null && filtro.getDwOperacao().getOmProdutoByIdProdutosemiacabado().getCd() != null && filtro.getDwOperacao().getOmProdutoByIdProdutosemiacabado().getCd().trim().equals("") == false)
			produtoSemiAcabado = produtoRN.getProdutoByCdEStAtivo(filtro.getDwOperacao().getOmProdutoByIdProdutosemiacabado().getCd());
		
		List<DwOperacao> operacoes = null;
		operacoes = getOperacoes(produtoAcabado, produtoSemiAcabado);
		
		if(operacoes != null){
			for(DwOperacao operacao : operacoes){
				DwOperacaoDTO dto = new DwOperacaoDTO();
				dto.setDwOperacao(operacao.clone());
				dtoRetorno.getListaOperacoesDTO().add(dto);
			}
		}		
		
		return dtoRetorno;
	}
	

    public List<DwOperacao> getOperacoes(OmProduto produtoAcabado, OmProduto produtoSemiAcabado){
		List<DwOperacao> operacoes = null;
		if(produtoAcabado == null || produtoSemiAcabado == null){
			return operacoes;
		}
		
		MapQuery q = new MapQuery(this.getDao().getSession());
		
		q.append("SELECT DISTINCT operacao");
		q.append("FROM DwOperacao operacao");
		q.append("join operacao.omProdutoByIdProdutoacabado b");
		q.append("join operacao.omProdutoByIdProdutosemiacabado c");
		q.append("WHERE operacao.stAtivo = 1");
		
		if (produtoAcabado !=  null)
			q.append("AND b.cdProduto = :cdProdutoAcabado");
		if (produtoSemiAcabado != null) {
			q.append("AND c.cdProduto = :cdProdutoSemiAcabado");
			q.defineParametro("cdProdutoSemiAcabado", produtoSemiAcabado.getCdProduto());
		}
		if (produtoAcabado !=  null)
			q.defineParametro("cdProdutoAcabado", produtoAcabado.getCdProduto());
		
		List<DwOperacao> resultadoPesquisa = q.list();
		operacoes = new ArrayList<>();
		for(DwOperacao operacao : resultadoPesquisa){
			operacoes.add(operacao.clone());
		}
		
		return operacoes;
	}
	
	@SuppressWarnings("unchecked")
    public DwOperacoesDTO getDwOperacaoInProcess() {
		
		DwOperacoesDTO retorno = new DwOperacoesDTO();
		List<DwOperacao> temp    = new ArrayList<DwOperacao>();
		List<DwOperacaoDTO> lista    = new ArrayList<DwOperacaoDTO>();
		
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("SELECT operacao");
		q.append("FROM DwOperacao operacao");
		q.append("WHERE operacao.stAtivo = 1");
		
		temp = q.query().list();
		int i;
		for( i = 0 ; i < temp.size() ; i ++){
			lista.add(new DwOperacaoDTO(temp.get(i).clone()));
		}
		retorno.setListaOperacoesDTO(lista);
		return retorno;
	}
	
	public DwOperacaoDTO getDwOperacaoByCodigo(DwOperacaoDTO filtro) {
		DwOperacaoDTO dto = new DwOperacaoDTO();
		DwOperacao operacao = getDwOperacao(filtro.getDwOperacao().getCdOperacao());
		if(operacao != null){
			dto.setDwOperacao(operacao.clone());
		}		
		return dto;
	}
		
	public DwOperacao getDwOperacao(String codigo){
		if(codigo.equals("")){
			return null;
		}
		
		MapQuery q = new MapQuery(this.getDao().getSession());
		
		q.append("SELECT operacao");
		q.append("FROM DwOperacao operacao");
		q.append("WHERE operacao.cdOperacao = :cdOperacao");
		q.append("AND operacao.stAtivo = 1");
		
		q.defineParametro("cdOperacao", codigo);
		
		DwOperacao operacao = (DwOperacao) q.query().uniqueResult();		
		
		return operacao;
	}	
	
	public DwOperacoesDTO setListaDwOperacao(DwOperacoesDTO itensDTO) {
	    		
		ResultadoDTO resultadoSucesso = new ResultadoDTO();
		resultadoSucesso.setIdmensagem(resultadoSucesso.getCOM_SUCESSO());
		itensDTO.setResultadoDTO(resultadoSucesso);
				
		for(DwOperacaoDTO dto : itensDTO.getListaOperacoesDTO()){
			for(DwOperacaopredecessora operacaoPredecessora : dto.getDwOperacao().getDwOperacaopredecessorasForIdOperacaoanterior()){
				operacaoPredecessora.setDwOperacaoByIdOperacao(dto.getDwOperacao().clone());
			}
		}
		
		DwOperacao operacaoFiltro = itensDTO.getListaOperacoesDTO().get(0).getDwOperacao();
		removerOperacoesAntigas(
		        operacaoFiltro.getOmProdutoByIdProdutoacabado(), 
		        operacaoFiltro.getOmProdutoByIdProdutosemiacabado());
				
		//salvando operacoes
		List<DwOperacaopredecessora> predecessoras = new ArrayList<>();
		for(DwOperacaoDTO dto : itensDTO.getListaOperacoesDTO()){
			predecessoras.addAll(dto.getDwOperacao().getDwOperacaopredecessorasForIdOperacaoanterior());
			boolean operacaoSalva = setDwOperacao(dto);
			if(operacaoSalva == false){
				getDao().rollBackTransacao();
				ResultadoDTO resultadoErro = new ResultadoDTO();
				resultadoErro.setIdmensagem(resultadoSucesso.getERRO_DESCONHECIDO());
				resultadoErro.setComplemento(dto.getDwOperacao().getCd());
				itensDTO.setResultadoDTO(resultadoErro);
				return itensDTO;
			}
		}
		
		getDao().flushReiniciandoTransacao();
		
		//salvando setas
		for(DwOperacaopredecessora predecessora : predecessoras){
			for(DwOperacaoDTO dto : itensDTO.getListaOperacoesDTO()){
				if(predecessora.getDwOperacaoByIdOperacao().getCdOperacao().equals(dto.getDwOperacao().getCdOperacao())){
					predecessora.setDwOperacaoByIdOperacao(dto.getDwOperacao());
				}
				
				if(predecessora.getDwOperacaoByIdOperacaoanterior().getCdOperacao().equals(dto.getDwOperacao().getCdOperacao())){
					predecessora.setDwOperacaoByIdOperacaoanterior(dto.getDwOperacao());
				}
			}
			getDao().makePersistent(predecessora);
		}	
		
		return itensDTO;
	}	
	
	public boolean setDwOperacao(DwOperacaoDTO itemDTO){
		DwOperacaoDTO retorno = salvarDwOperacao(itemDTO);
		if (retorno != null)
			return true;
		return false;
	}
	
	public DwOperacaoDTO salvarDwOperacao(DwOperacaoDTO itemDTO) {
		
		DwOperacaoDTO dtoRetorno = new DwOperacaoDTO();
		
		if(itemDTO.getDwOperacao().getIdOperacao() == null){
			itemDTO.getDwOperacao().setIdOperacao(0L);
		}
		
		DwOperacao itemOriginal = new DwOperacao();
		itemOriginal = itemDTO.getDwOperacao().clone();
		
		for(DwOperacaocomp componente : itemOriginal.getDwOperacaocomps()){
			componente.setDwOperacao(itemOriginal);
		}
		
		for(DwOperacaorap ferramenta : itemOriginal.getDwOperacaoraps()){
			ferramenta.setDwOperacao(itemOriginal);
		}
		
		for(DwOperacaomidia midia : itemOriginal.getDwOperacaomidias()){
			midia.setDwOperacao(itemOriginal);
		}	
		
		boolean isFKSValido = verificaIntegridadeFKs(itemOriginal, itemDTO, dtoRetorno);
		
		if(isFKSValido){
			itemDTO.setDwOperacao(salvarDesativandoOriginal(itemOriginal, new Date(), itemDTO.getDwOperacao().getOmUsrByIdUsrrevisao()));
			return itemDTO;
		} else {
			return null;
		}
	}
	
	private boolean verificaIntegridadeFKs(DwOperacao itemOriginal, DwOperacaoDTO dtoRecebido, DwOperacaoDTO dtoRetorno){
		ProdutoRN produtoRN = new ProdutoRN(getDao());
		TipoOperacaoRN tipoOperacaoRN = new TipoOperacaoRN(getDao());
		PTRN postoTrabalhoRN = new PTRN(getDao());
		TpptRN tipoPostoRN = new TpptRN(getDao());
		
		try {
			//VERIFICACAO CAMPOS OBRIGATORIOS
			OmProduto produtoAcabado = produtoRN.getOmProduto(dtoRecebido.getDwOperacao().getOmProdutoByIdProdutoacabado().getCd());
			if(produtoAcabado == null){
				return false;
			}
			itemOriginal.setOmProdutoByIdProdutoacabado(produtoAcabado);
			
			OmProduto produtoSemiAcabado = produtoRN.getOmProduto(dtoRecebido.getDwOperacao().getOmProdutoByIdProdutosemiacabado().getCd());
			if(produtoSemiAcabado == null){
				return false;
			}
			itemOriginal.setOmProdutoByIdProdutosemiacabado(produtoSemiAcabado);
			
			if (dtoRecebido.getDwOperacao().getDwTOperacao() != null) {
				DwTOperacao tipoOperacao = tipoOperacaoRN.getDwTOperacao(dtoRecebido.getDwOperacao().getDwTOperacao().getDsToperacao());
				if(tipoOperacao == null){
					return false;
				}
				itemOriginal.setDwTOperacao(tipoOperacao);
			} else {
				itemOriginal.setDwTOperacao(null);
			}
			//VERIFICACAO CAMPOS NAO OBRIGATORIOS
			if(dtoRecebido.getDwOperacao().getOmPt() != null){
				OmPt postoTrabalho = postoTrabalhoRN.getOmPt(dtoRecebido.getDwOperacao().getOmPt().getDsPt());
				if(postoTrabalho == null){
					return false;
				}
				itemOriginal.setOmPt(postoTrabalho);
			}
						
			if(dtoRecebido.getDwOperacao().getOmTppt() != null){
				OmTppt tipoPostoTrabalho = tipoPostoRN.getOmTpptDTO(dtoRecebido.getDwOperacao().getOmTppt());
				if(tipoPostoTrabalho == null){
					return false;
				}
				itemOriginal.setOmTppt(tipoPostoTrabalho);
			}
			
		} catch (RegistroDesconhecidoException e) {
			return false;
		}
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	private void removerOperacoesAntigas(OmProduto produtoAcabado, OmProduto produtoSemiAcabado){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("SELECT operacao");
		q.append("FROM DwOperacao operacao");
		q.append("WHERE operacao.stAtivo = 1");
		q.append("AND operacao.omProdutoByIdProdutoacabado.cdProduto = :produtoAcabado");
		q.append("AND operacao.omProdutoByIdProdutosemiacabado.cdProduto = :produtoSemiAcabado");
		
		q.defineParametro("produtoAcabado", produtoAcabado.getCdProduto());
		q.defineParametro("produtoSemiAcabado", produtoSemiAcabado.getCdProduto());
		
		List<DwOperacao> operacoes = null;
		operacoes = q.query().list();
		
		if(operacoes != null){
			for(DwOperacao operacao : operacoes){
				try {
                    desativar(operacao, new Date(), operacao.getOmUsrByIdUsrrevisao().clone());
                } catch (RegistroJaDesativadoException e) {
                    
                }
			}
		}
	}	
	
	public DwOperacao salvarDesativandoOriginal(DwOperacao dwOperacao,
			Date dateOperacao, OmUsr omUsrOperacao) {
		return this.getDao().salvarDesativandoOriginal(dwOperacao, dateOperacao,
				omUsrOperacao).clone();
	}
	
	public void desativar(DwOperacao operacao,
			Date dateOperacao, OmUsr omUsrOperacao) throws RegistroJaDesativadoException {		
		this.getDao().desativar(operacao, dateOperacao, omUsrOperacao);		
	}
}
