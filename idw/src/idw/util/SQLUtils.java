package idw.util;

public final class SQLUtils {
    private SQLUtils() {
    }

    private static final String SQL_BETWEEN = " ( %s BETWEEN %s AND %s ) ";

    private static final String SQL_ALL_PERIODO_INSIDE_ANOTHER = " ( %s <= %s AND %s >= %s ) ";

    private static final String SQL_INSTERSECTION_WHEN_OPENED = " ( %s <= %s AND %s IS NULL ) ";

    
    /**
     * Início entre o período<br>
     * OR <br>
     * Fim entre período<br>
     * OR início <= início do período AND fim >= fim do período
     */
    private static final String SQL_INTERSECTION = "" +
            " ( " + SQL_BETWEEN +
            "   OR " + SQL_BETWEEN +
            "   OR " + SQL_ALL_PERIODO_INSIDE_ANOTHER +
            " ) ";

    
    private static final String SQL_INTERSECTION_CONSIDERING_IS_OPEN = "" +
            " ( " +
            SQL_INSTERSECTION_WHEN_OPENED +
            " OR " +
            SQL_INTERSECTION +
            " ) ";
    
    /**
     * Monta o SQL de pesquisa dentro do periodo<br>
     * <code> 
     * (( campoTabelaInicio BETWEEN parametroInicio AND parametroFim) <br>
     * 	OR (campoTabelaFim BETWEEN parametroInicio AND parametroFim) <br>
     *  OR (campoTabelaInicio <= parametroInicio AND campoTabelaFim >= parametroFim))
     * </code>
     * @param campoTabelaInicio
     * @param campoTabelaFim
     * @param parametroInicio
     * @param parametroFim
     * @return
     */
    public static String getSQLDentroPeriodo(String campoTabelaInicio, String campoTabelaFim, String parametroInicio, String parametroFim) {
        return String.format(SQL_INTERSECTION,
                campoTabelaInicio, parametroInicio, parametroFim, // início dentro do período
                campoTabelaFim, parametroInicio, parametroFim, // fim dentro do período
                campoTabelaInicio, parametroInicio, campoTabelaFim, parametroFim); // início <= início do período e fim >= fim do período
    }
    
    /**
     * Monta o SQL de pesquisa dentro do periodo<br>
     * <code>
     * (<br>
     *  (campoTabelaInicio <= parametroFim AND campoTabelaFim IS NULL) <br>
     *  OR <br>
     *   ( (campoTabelaInicio BETWEEN parametroInicio AND parametroFim) <br>
     * 	 OR (campoTabelaFim BETWEEN parametroInicio AND parametroFim) <br>
     *   OR (campoTabelaInicio <= parametroInicio AND campoTabelaFim >= parametroFim) ) <br>
     * )
     * </code>
     * @param campoTabelaInicio
     * @param campoTabelaFim
     * @param parametroInicio
     * @param parametroFim
     * @return
     */
    public static String getSQLDentroPeriodoConsiderandoAberto(String campoTabelaInicio, String campoTabelaFim, String parametroInicio,
            String parametroFim) {
        return String.format(SQL_INTERSECTION_CONSIDERING_IS_OPEN,
                campoTabelaInicio, parametroFim, campoTabelaFim,
                campoTabelaInicio, parametroInicio, parametroFim, // início dentro do período
                campoTabelaFim, parametroInicio, parametroFim, // fim dentro do período
                campoTabelaInicio, parametroInicio, campoTabelaFim, parametroFim); // início <= início do período e fim >= fim do período
                
    }

    public static String getSQLDentroPeriodoApenasAberto(String campoInicio, String campoFim, String parametroFim) {
        return String.format(SQL_INSTERSECTION_WHEN_OPENED, campoInicio, parametroFim, campoFim);
    }

    // ( (cp.dthrInicioreal <= :dtFim AND cp.dthrFinalreal IS NULL)");
    public static String getSQLBetweenCampos(String item, String inicio, String fim) {
        return String.format(SQL_BETWEEN, item, inicio, fim);
    }

}
