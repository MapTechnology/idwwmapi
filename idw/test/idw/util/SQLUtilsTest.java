package idw.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SQLUtilsTest {

    @Test
    public void testBetween() {

        assertTrue(SQLUtils.getSQLBetweenCampos("campo", "inicio", "fim")
                .equals(" ( campo BETWEEN inicio AND fim ) "));

    }

    @Test
    public void testGetSQLDentroPeriodoApenasAberto() {
        String resultado = " ( cp.dthrInicio <= :dtFim AND cp.dthrFinal IS NULL ) ";
        String sql = SQLUtils.getSQLDentroPeriodoApenasAberto("cp.dthrInicio", "cp.dthrFinal", ":dtFim");

        assertTrue(sql.equals(resultado));

    }

    @Test
    public void testGetSQLDentroPeriodo() {

        String resultado = ""
                + " (  ( cp.dthrInicio BETWEEN :dtInicio AND :dtFim ) "
                + "   OR  ( cp.dthrFinal BETWEEN :dtInicio AND :dtFim ) "
                + "   OR  ( cp.dthrInicio <= :dtInicio AND cp.dthrFinal >= :dtFim ) "
                + " ) ";
        String sql = SQLUtils.getSQLDentroPeriodo("cp.dthrInicio", "cp.dthrFinal", ":dtInicio", ":dtFim");

        assertTrue(sql.equals(resultado));

    }

    @Test
    public void testGetSQLDentroPeriodoConsiderandoAberto() {

        String resultado = ""
                + " ( " 
                + " ( cp.dthrInicio <= :dtFim AND cp.dthrFinal IS NULL ) "
                + " OR "
                + " (  ( cp.dthrInicio BETWEEN :dtInicio AND :dtFim ) "
                + "   OR  ( cp.dthrFinal BETWEEN :dtInicio AND :dtFim ) "
                + "   OR  ( cp.dthrInicio <= :dtInicio AND cp.dthrFinal >= :dtFim ) "
                + " ) "
                + " ) ";
        String sql = SQLUtils.getSQLDentroPeriodoConsiderandoAberto("cp.dthrInicio", "cp.dthrFinal", ":dtInicio", ":dtFim");

        assertTrue(sql.equals(resultado));

    }

}
