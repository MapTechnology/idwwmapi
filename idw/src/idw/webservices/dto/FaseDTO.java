package idw.webservices.dto;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import idw.model.pojos.DwOperacao;
import idw.model.pojos.OmGt;

@SuppressWarnings("serial")
public class FaseDTO implements Serializable {

	private OmGt fase;
	private List<PostoBalanceamentoDTO> postos; // tera o resultado do balanceamento
	private List<OperacaoDTO> operacoes = new ArrayList<>(); // tem a lista de todas as operacoes e suas predecessoras
	private Integer ordemFase = 0;
	private BigDecimal segSomaDasOperacoesDaFase = BigDecimal.ZERO;
	
	public List<PostoBalanceamentoDTO> getPostos() {
		return postos;
	}
	public void setPostos(List<PostoBalanceamentoDTO> postos) {
		this.postos = postos;
	}
	public OmGt getFase() {
		return fase;
	}
	public void setFase(OmGt fase) {
		this.fase = fase;
	}
	public List<OperacaoDTO> getOperacoes() {
		return operacoes;
	}
	public void setOperacoes(List<OperacaoDTO> operacoes) {
		this.operacoes = operacoes;
	}
	public BigDecimal getSegSomaDasOperacoesDaFase() {
		return segSomaDasOperacoesDaFase;
	}
	public void setSegSomaDasOperacoesDaFase(BigDecimal segSomaDasOperacoesDaFase) {
		this.segSomaDasOperacoesDaFase = segSomaDasOperacoesDaFase;
	}
	
	public void addOperacaoDTO(OperacaoDTO valor) {
		// Verifica se ja existe um grupo de operacoes na lista das operacoes
		// se ja existir entao adicionar a operacao ao gurpo dela
		
		for (OperacaoDTO dto : getOperacoes()) {
			if (valor.getIdGrupo() != null && valor.getIdGrupo() != 0 && dto.getIdGrupo().equals(valor.getIdGrupo())) {
				BigDecimal segSomaDasOperacoesDaFase = getSegSomaDasOperacoesDaFase();
				segSomaDasOperacoesDaFase = segSomaDasOperacoesDaFase.add(valor.getSegTempoOperacao());
				setSegSomaDasOperacoesDaFase(segSomaDasOperacoesDaFase);

				addOperacaoDTOAoGrupo(dto, valor);
				return;
			}
		}
		
		getOperacoes().add(valor);
		BigDecimal segSomaDasOperacoesDaFase = getSegSomaDasOperacoesDaFase();
		segSomaDasOperacoesDaFase = segSomaDasOperacoesDaFase.add(valor.getSegTempoOperacao());
		setSegSomaDasOperacoesDaFase(segSomaDasOperacoesDaFase);
	}
	
	private void addOperacaoDTOAoGrupo(OperacaoDTO pai, OperacaoDTO filho) {
		pai.addOperacaoDTOFilho(filho);
	}
	
	public void addPosto(PostoBalanceamentoDTO valor) {
		// Verificar se ja existe se sim adicionar senao incluir novo
		PostoBalanceamentoDTO existe = null;
		for (PostoBalanceamentoDTO p : this.getPostos()) {
			if (p.getOrdem() == valor.getOrdem())
				existe = p;
		}
		
		if (existe != null) {
			BigDecimal segTempoPosto = existe.getCicloPadrao();
			for (DwOperacao op : valor.getOperacoes()) {
				segTempoPosto = segTempoPosto.add(op.getSegCiclopadrao());
			}
			existe.setCicloPadrao(segTempoPosto);
			existe.getOperacoes().addAll(valor.getOperacoes());
		} else {
			this.getPostos().add(valor);
		}
	}
	public Integer getOrdemFase() {
		return ordemFase;
	}
	public void setOrdemFase(Integer ordemFase) {
		this.ordemFase = ordemFase;
	}
	
	
}
