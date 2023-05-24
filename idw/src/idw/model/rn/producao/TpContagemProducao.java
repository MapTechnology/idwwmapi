package idw.model.rn.producao;

/**
 * 
 * Tipo de contagem de produção.<br>
 * Usando a mesma configuração usada no Injet.<br>
 */
public enum TpContagemProducao {
    PECA(1, 1, 0, "pç", "peca"),
    METRO(2, 1000, 3, "m", "metro"),
    FOLHA(3, 1, 0, "fl", "folha"),
    QUILO(4, 1000, 3, "kg", "kilo"),
    PECAS_DECIMAL(5, 100, 2, "pç", "peca_decimal"),
    TONELADA(6, 1000000, 3, "T", "tonelada"),
    METRO_QUADRADO(7, 1000, 3, "m²", "metro_quadrado");

    private final int id;
    private final int divisor;
    private final int casaDecimais;
    private final String sigla;
    private final String idTxt;

    private TpContagemProducao(int id, int divisor, int casaDecimais, String sigla, String idTxt) {
        this.id = id;
        this.divisor = divisor;
        this.casaDecimais = casaDecimais;
        this.sigla = sigla;
        this.idTxt = idTxt;
    }

    public static TpContagemProducao get(int id) {
        for (TpContagemProducao tp : TpContagemProducao.values()) {
            if (tp.getId() == id) {
                return tp;
            }
        }
        throw new IllegalArgumentException();
    }
    
    /**
     * Pega o {@link TpContagemProducao} através do idTxt
     * @deprecated usar {@link TpContagemProducao#get(int)}
     * @see TpContagemProducao#getIdTxt()
     * @param txtId
     * @return Tipo da contagem de produção
     */
    public static TpContagemProducao get(String txtId) {
        for (TpContagemProducao tp : TpContagemProducao.values()) {
            if (tp.getIdTxt().equals(txtId)) {
                return tp;
            }

        }
        throw new IllegalArgumentException();
    }

    public int getId() {
        return this.id;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getCasaDecimais() {
        return casaDecimais;
    }

    public String getSigla() {
        return sigla;
    }
    
    /**
     * Criado para suprir situações em que estavam usando <br>
     * "kilo" e "tonelada" para identificar o divisor de contagem
     * @deprecated usar {@link TpContagemProducao#getId()} para identificar o tipo da contagem
     * @return texto que identifica o tipo da contagem de produção
     */
    public String getIdTxt() {
        return idTxt;
    }
    
    public double aplicarDivisor(double dividendo) {
        return dividendo / this.divisor;
    }
    
}
