package idw.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.math.BigDecimal;

import org.junit.Test;

public class HashCodeBuilderIdwTest {
	
	/**
	 * Tratamento de hashCode para {@code BigDecimal}, mesmo com tamanho de scala diferente, considera igual
	 * <br> Padroniza {@code BigDecimal} com {@code Util#getBigDecimalDefault(BigDecimal)}
	 * <br> {@code new BigDecimal("2.00000").hashCode() == new BigDecimal(2.0").hashCode()} 
	 */	
	@Test
	public void testHashCodeBigDecimalScalaDiferente(){
		
		BigDecimal o1 = new BigDecimal("31231543767623.423423535435");
		BigDecimal o2 = new BigDecimal("31231543767623.42342");		
		assertTrue(new HashCodeBuilderIdw().append(o1).toHashCode() == new HashCodeBuilderIdw().append(o2).toHashCode());
		
		o1 = new BigDecimal("31231543767623.0000");
		o2 = new BigDecimal("31231543767623");				
		assertTrue(new HashCodeBuilderIdw().append(o1).toHashCode() == new HashCodeBuilderIdw().append(o2).toHashCode());

		o1 = new BigDecimal("31231543767623.00001");
		o2 = new BigDecimal("31231543767623.000012");				
		assertTrue(new HashCodeBuilderIdw().append(o1).toHashCode() == new HashCodeBuilderIdw().append(o2).toHashCode());

		o1 = new BigDecimal("31231543767623.0019");
		o2 = new BigDecimal("31231543767623.001");				
		assertFalse(new HashCodeBuilderIdw().append(o1).toHashCode() == new HashCodeBuilderIdw().append(o2).toHashCode());		
	}
	
}
