package idw.webservices.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import idw.model.pojos.DwOperacao;

public class OperacoesInprocessDTO {

	private List<OperacaoInprocessDTO> listaOperacao;


	public void adicionaOperacaoInprocessDTO(DwOperacao operacao){
		if(listaOperacao.isEmpty()){
			listaOperacao.add(new OperacaoInprocessDTO(operacao));
		}
		else{
			for(Iterator<OperacaoInprocessDTO> iterator = listaOperacao.iterator(); iterator.hasNext(); ) {
				OperacaoInprocessDTO oper =  iterator.next();
				if(oper.getIdProdutoAcabado() == operacao.getOmProdutoByIdProdutoacabado().getIdProduto() && oper.getIdProdutoSemiAcabado() == operacao.getOmProdutoByIdProdutosemiacabado().getIdProduto()  ){
					oper.getIdOperacao().add(operacao.getIdOperacao());
					oper.getListaCdOperacao().add(operacao.getCdOperacao());
					return;
				}
			}
			listaOperacao.add(new OperacaoInprocessDTO(operacao));
		}
	}

	public OperacoesInprocessDTO(){
		this.listaOperacao = new ArrayList<OperacaoInprocessDTO>();
	}

	public OperacoesInprocessDTO(List<OperacaoInprocessDTO> listaOperacao) {
		super();
		this.listaOperacao = listaOperacao;
	}

	public List<OperacaoInprocessDTO> getListaOperacao() {
		return listaOperacao;
	}

	public void setListaOperacao(List<OperacaoInprocessDTO> listaOperacao) {
		this.listaOperacao = listaOperacao;
	}



}
