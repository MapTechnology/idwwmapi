package idw.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class EqualsBuilderIdwTest {

	@Test
	public void testAppendBigDecimal(){

		assertFalse((new EqualsBuilderIdw()).append(BigDecimal.ONE, BigDecimal.ZERO).isEquals());
		assertFalse((new EqualsBuilderIdw()).append(BigDecimal.ZERO, BigDecimal.ONE).isEquals());
		assertTrue((new EqualsBuilderIdw()).append(BigDecimal.ZERO, BigDecimal.ZERO).isEquals());
		assertTrue((new EqualsBuilderIdw()).append(BigDecimal.ONE, BigDecimal.ONE).isEquals());
		
		BigDecimal o1 = null;
		BigDecimal o2 = null;
		
		// testar se os parametros forem nulos
		assertFalse((new EqualsBuilderIdw()).append(BigDecimal.ONE, null).isEquals());
		// 2 valores nulos
		assertTrue((new EqualsBuilderIdw()).append(o1, o2).isEquals());
		
		// teste com escala diferente
		assertTrue((new EqualsBuilderIdw()).append(new BigDecimal("2.0000"), new BigDecimal("2.0")).isEquals());
		assertTrue((new EqualsBuilderIdw()).append(new BigDecimal("2.0000"), new BigDecimal("2")).append(true, true).isEquals());
		assertTrue((new EqualsBuilderIdw()).append(new BigDecimal("3.0100"), new BigDecimal("3.01")).isEquals());
		assertTrue((new EqualsBuilderIdw()).append(new BigDecimal("31231543767623.423423535435"), new BigDecimal("31231543767623.42342")).isEquals());
		assertTrue((new EqualsBuilderIdw()).append(new BigDecimal("31231543767623"), new BigDecimal("31231543767623.00000000")).isEquals());
		
	}	
	
}
