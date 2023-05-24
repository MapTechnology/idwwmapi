package idw.model.rn.integracao.semptoshiba.api;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import idw.model.rn.DataHoraRN;

public final class ApontamentoDia{
	private final String cdPlaca;
	private final BigDecimal qtdProduzido;
	private final Date dataProducaoSemHora;
	private final String codLinhaDest;
	private final BigDecimal t1;
	private final BigDecimal t2;
	private final BigDecimal t3;
	private final BigDecimal t4;
	
	public ApontamentoDia(String cdPlaca, BigDecimal qtdProduzido,
			Date dataProducao, String codLinhaDest, BigDecimal t1,
			BigDecimal t2, BigDecimal t3, BigDecimal t4) {
		
		super();
		this.cdPlaca = cdPlaca;
		this.qtdProduzido = qtdProduzido;
		
		// Garantir que s� fique a data sem a hora.
		// Atualmente j� vem assim, mesmo assim retira para evitar problemas, ao abater valor 
		this.dataProducaoSemHora = DataHoraRN.getDataSemHora(dataProducao);
		
		this.codLinhaDest = codLinhaDest;
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
		this.t4 = t4;
		
	}
	
	public String getCdPlaca() {
		return cdPlaca;
	}
	public BigDecimal getQtdProduzido() {
		return qtdProduzido;
	}
	public Date getDataProducaoSemHora() {
		return dataProducaoSemHora;
	}
	public String getCodLinhaDest() {
		return codLinhaDest;
	}
	public BigDecimal getT1() {
		return t1;
	}
	public BigDecimal getT2() {
		return t2;
	}
	public BigDecimal getT3() {
		return t3;
	}
	public BigDecimal getT4() {
		return t4;
	}
	
	public String toString(){
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("cdPlaca", this.cdPlaca)
		.append("QtdProduzido", this.qtdProduzido)
		.append("DataProduzido", this.dataProducaoSemHora)
		.append("CodLinhaDest", this.codLinhaDest)
		.append("t1", this.t1)
		.append("t2", this.t2)
		.append("t3", this.t3)
		.append("t4", this.t4)
		.toString();
		
	}
	
}
