package idw.util;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class EqualsBuilderIdw extends EqualsBuilder {
		
	/**
	 * Tratamento de equals para {@code BigDecimal}, mesmo com tamanho de scala diferente, considera igual
	 * <br> Padroniza {@code BigDecimal} com {@code Util#bigDecimalDefault(BigDecimal)}
	 * <br> {@code 2.000 = 2.0}
	 * @param lhs
	 * @param rhs
	 * @return
	 */
	private EqualsBuilder appendBigDecimal(BigDecimal lhs, BigDecimal rhs){
		if(lhs != null && rhs != null){
			return super.append(Util.getBigDecimalDefault(lhs), Util.getBigDecimalDefault(rhs));
		}
		return super.append(lhs, rhs);
	}
	@Override
	public EqualsBuilder append(Object lhs, Object rhs) {
		if(lhs != null && rhs != null){
			if(lhs instanceof BigDecimal && rhs instanceof BigDecimal){
				return appendBigDecimal((BigDecimal)lhs, (BigDecimal)rhs);
			}
		}
		return super.append(lhs, rhs);
	}
}
