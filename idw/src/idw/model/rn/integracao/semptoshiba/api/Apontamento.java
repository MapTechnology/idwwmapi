package idw.model.rn.integracao.semptoshiba.api;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Apontamento {
	private final String id;
	private final String cdPlaca;
	private final BigDecimal qtdProduzido;
	private final Date dataApontamento;
	
	public Apontamento(String id, String cdPlaca,
			BigDecimal qtdProduzido, Date dataApontamento) {
		
		super();
		
		this.id = id;
		this.cdPlaca = cdPlaca;
		this.qtdProduzido = qtdProduzido;
		this.dataApontamento = dataApontamento;
	}

	public String getId() {
		return id;
	}

	public String getCdPlaca() {
		return cdPlaca;
	}

	public BigDecimal getQtdProduzido() {
		return qtdProduzido;
	}

	public Date getDataApontamento() {
		return dataApontamento;
	}
	
	public String toString(){
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("Id", this.id)
		.append("cdPlaca", this.cdPlaca)
		.append("QtdProduzido", this.qtdProduzido)
		.append("DataApontamento", this.dataApontamento)		
		.toString();		
	}	
	
}
