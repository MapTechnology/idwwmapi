package idw.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.lang3.ObjectUtils;

public abstract class AritmeticaUtil {
    /**
     * Incrementa valor de v1 com v2 (v1 + v2)
     *
     * @param v1
     * @param v2
     * @return Se v1 e v2 estive null, � retornado BigDecimal.ZERO <br>
     *         Se apenas v1 for null, retorna nova instancia de BigDecimal com o valor de v2 {@code new BigDecimal(v2.toString())} <br>
     *         Se apenas v2 for null, retorna instancia de v1 depois de v1 + v2
     */
    public static BigDecimal somar(BigDecimal v1, BigDecimal v2) {
        v1 = ObjectUtils.defaultIfNull(v1, BigDecimal.ZERO);
        v2 = ObjectUtils.defaultIfNull(v2, BigDecimal.ZERO);
        return Util.getBigDecimalDefault(v1.add(v2));
    }

    /**
     *
     * @param v1
     * @param v2
     * @return
     * @see AritmeticaUtil#somar(BigDecimal, BigDecimal)
     */
    public static BigDecimal somar(BigDecimal v1, Double v2) {
        return somar(v1, new BigDecimal(v2));
    }

    /**
     *
     * @param v1
     * @param v2
     * @return
     * @see AritmeticaUtil#somar(BigDecimal, BigDecimal)
     */
    public static BigDecimal somar(BigDecimal v1, Long v2) {
    	if (v2 == null)
    		v2 = 0l;
        return somar(v1, new BigDecimal(v2));
    }

    public static BigDecimal somar(Double v1, Long v2) {
    	BigDecimal valor1 = (v1 == null ? BigDecimal.ZERO : new BigDecimal(v1));
        BigDecimal valor2 = (v2 == null ? BigDecimal.ZERO : new BigDecimal(v2));
        return somar(valor1, valor2);
    }
    public static BigDecimal somar(Double v1, Double v2) {
    	BigDecimal valor1 = (v1 == null ? BigDecimal.ZERO : new BigDecimal(v1));
        BigDecimal valor2 = (v2 == null ? BigDecimal.ZERO : new BigDecimal(v2));
        return somar(valor1, valor2);
    }
    /**
     *
     * @param v1
     * @param v2
     * @return
     * @see AritmeticaUtil#somar(BigDecimal, BigDecimal)
     */
    public static BigDecimal somar(BigDecimal v1, Integer v2) {
        return somar(v1, new BigDecimal(v2));
    }

    /**
     * Descrementa valor de v1 por v2 (v1 - v2)
     *
     * @param v1
     * @param v2
     * @return Se v1 e v2 estive null, � retornado 0 <br>
     *         Se apenas v1 for null, retorna -v2 <br>
     *         Se apenas v2 for null, retorna v1
     */
    public static BigDecimal diminuir(BigDecimal v1, BigDecimal v2) {
        v1 = ObjectUtils.defaultIfNull(v1, BigDecimal.ZERO);
        v2 = ObjectUtils.defaultIfNull(v2, BigDecimal.ZERO);
        return Util.getBigDecimalDefault(v1.subtract(v2));
    }

    /**
     *
     * @param v1
     * @param v2
     * @return
     * @see AritmeticaUtil#diminuir(BigDecimal, BigDecimal)
     */
    public static BigDecimal diminuir(BigDecimal v1, Double v2) {
        return diminuir(v1, new BigDecimal(v2));
    }

    /**
     *
     * @param v1
     * @param v2
     * @return
     * @see AritmeticaUtil#diminuir(BigDecimal, BigDecimal)
     */
    public static BigDecimal diminuir(BigDecimal v1, Long v2) {
        return diminuir(v1, new BigDecimal(v2));
    }

    /**
     *
     * @param v1
     * @param v2
     * @return
     * @see AritmeticaUtil#diminuir(BigDecimal, BigDecimal)
     */
    public static BigDecimal diminuir(BigDecimal v1, Integer v2) {
        return diminuir(v1, new BigDecimal(v2));
    }

    /**
     * Soma v1 e v2
     *
     * @param v1
     * @param v2
     * @return Se v1 e v2 estive null, � retornado 0 <br>
     *         Se apenas v1 for null, retorna v2 <br>
     *         Se apenas v2 for null, retorna v1 <br>
     *         retorna v1 + v2
     */
    public static Long somar(Long v1, Long v2) {
        v1 = ObjectUtils.defaultIfNull(v1, new Long(0));
        v2 = ObjectUtils.defaultIfNull(v2, new Long(0));
        return v1 + v2;
    }

    public static Long diminuir(Long v1, Long v2) {
        v1 = ObjectUtils.defaultIfNull(v1, new Long(0));
        v2 = ObjectUtils.defaultIfNull(v2, new Long(0));
        return v1 - v2;
    }

    public static Double multiplicar(Long v1, Double v2) {
    	// Alessandre em 16-05-17 comentei a linha abaixo e substitui pela seguinte
    	// pois no relatorio R014 qdo exisita parada em aberto estava trazendo producao 1 que nao existia. Alem disso valor 1 para
    	// como default nao faz sentido, o correto eh retorna 0. Alem disso esse metodo esta sendo chamado apenas 3x para multiplicar
    	// uma producao por um multiplicador
        //v1 = ObjectUtils.defaultIfNull(v1, 1L);
    	v1 = ObjectUtils.defaultIfNull(v1, 0L);
        v2 = ObjectUtils.defaultIfNull(v2, 0d);
        return v1 * v2;
    }

    public static BigDecimal multiplicar(BigDecimal v1, BigDecimal v2) {
        v1 = ObjectUtils.defaultIfNull(v1, BigDecimal.ZERO);
        v2 = ObjectUtils.defaultIfNull(v2, BigDecimal.ZERO);
        return Util.getBigDecimalDefault(v1.multiply(v2));
    }
    public static BigDecimal multiplicar(BigDecimal v1, Double v2) {
        v1 = ObjectUtils.defaultIfNull(v1, BigDecimal.ZERO);
        BigDecimal v2B = new BigDecimal(v2);
        v2B = ObjectUtils.defaultIfNull(v2B, BigDecimal.ZERO);
        return Util.getBigDecimalDefault(v1.multiply(v2B));
    }

    public static BigDecimal dividir(BigDecimal v1, BigDecimal v2) {
        v1 = ObjectUtils.defaultIfNull(v1, BigDecimal.ZERO);
        v2 = ObjectUtils.defaultIfNull(v2, BigDecimal.ZERO);
        if(v2.intValue() == 0){
            return v1;
        }
        return Util.getBigDecimalDefault(v1.divide(v2, BigDecimal.ROUND_UP));
    }

    public static BigDecimal dividir(BigDecimal v1, BigDecimal v2, int casasDecimais, RoundingMode roundingMode) {
        v1 = ObjectUtils.defaultIfNull(v1, BigDecimal.ZERO);
        v2 = ObjectUtils.defaultIfNull(v2, BigDecimal.ZERO);

        if (v1.equals(BigDecimal.ZERO) || v2.equals(BigDecimal.ZERO)) {
        	return BigDecimal.ZERO;
        } else {

//        	BigDecimal resultado = v1.divide(v2, MathContext.DECIMAL32);
        	BigDecimal resultado = v1.divide(v2, casasDecimais, roundingMode);
        	//resultado = resultado.setScale(casasDecimais, roundingMode);
        	return resultado;
        }

    }

    public static BigDecimal calcularPorcentagem(BigDecimal valorParcial, BigDecimal valorTotal) {
    	valorParcial = ObjectUtils.defaultIfNull(valorParcial, BigDecimal.ZERO);
    	valorTotal = ObjectUtils.defaultIfNull(valorTotal, BigDecimal.ZERO);
        if(valorTotal.equals(BigDecimal.ZERO)){
        	return BigDecimal.ZERO;
        }

        BigDecimal resultado = valorParcial.divide(valorTotal, 5, RoundingMode.HALF_UP);
        resultado = resultado.multiply(new BigDecimal("100"));
    	return resultado;
    }

}
