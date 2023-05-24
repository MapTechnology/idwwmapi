package idw.model.rn.estoque;

import java.math.BigDecimal;

public enum TipoAjusteEstoque {
	AJUSTE((byte)0, true), 
	ENTRADA((byte)1, true), 
	SAIDA((byte)2, false), 
	CONSUMO_POR_CICLO((byte)3, false), 
	CONSUMO_POR_PERDA((byte)4, false);
	
	private final boolean isOperacaoAdicao;
	private final byte id;
	
	TipoAjusteEstoque(byte id, boolean isOperacaoAdicao){
		this.id = id;
		this.isOperacaoAdicao = isOperacaoAdicao;
	}
	
	public byte getId(){
		return this.id;
	}
	
	public static TipoAjusteEstoque getTipoAjusteEstoque(Byte id){
		for(TipoAjusteEstoque tipoAjusteEstoque: TipoAjusteEstoque.values()){
			if(id.byteValue() == tipoAjusteEstoque.getId() ){
				return tipoAjusteEstoque;
			}
		}
		return null;
	}
	
	public BigDecimal alterarQtd(BigDecimal qtdTotal, BigDecimal qtdAjuste){
		if(isOperacaoAdicao){
			return qtdTotal.add(qtdAjuste);
		}else{
			return qtdTotal.subtract(qtdAjuste);
		}
	}
	
}
