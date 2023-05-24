package idw.util;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class FormulasInjetTest {

	@Test
	public void testCalcularTempoCicloProdutivoSemParadaVariacaoRitmo(){
		
		BigDecimal segTempoCicloProdutivo = BigDecimal.ZERO;
		BigDecimal segTempoparadaCpVarRitmo = BigDecimal.ZERO;
		BigDecimal segTempoparadaSpVarRitmo = BigDecimal.ZERO;
		BigDecimal resultado = BigDecimal.ZERO;
		
		resultado = FormulasInjet.calcularTempoCicloProdutivoSemParadaVariacaoRitmo(segTempoCicloProdutivo, segTempoparadaCpVarRitmo, segTempoparadaSpVarRitmo);
		
		assertTrue(resultado.equals(BigDecimal.ZERO));
		
		
	}	
	
}
