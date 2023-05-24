package ms.coleta.dto;

public class AndonArgsDTO {
	
	public static final int _ARG_COD_PARADA = 1;
	public static final int _ARG_COD_ALERTA = 2;
	public static final int _ARG_TEMPO_PARADA = 3;
	public static final int _ARG_REFERENCIA_INDICADOR = 4;
    private String IdUp;
    private double IdeventoAndon;
    private int OrdemCondicao;
    private String OperadorLogico;
    private String OperadorCalculo;
    private int TpVlreferencia;
    private String VlReferenciastr;
    private Double VlReferencianum;
    
    public AndonArgsDTO() {    	
    }
    
    
    
    public AndonArgsDTO(injetws.webservices.dto.IwsAndonArgsDTO andonargs)
    {
        if (andonargs != null)
        {
            this.IdUp = andonargs.getIdup();
            this.IdeventoAndon = andonargs.getIdeventoandon();
            if(andonargs.getOrdemcondicao() != null)
            	this.OrdemCondicao = andonargs.getOrdemcondicao().intValue();
            this.OperadorLogico = andonargs.getOperadorlogico();
            this.OperadorCalculo = andonargs.getOperadorcalculo();
            if(andonargs.getTpvlreferencia() != null)
            	this.TpVlreferencia = andonargs.getTpvlreferencia().intValue();
            this.VlReferenciastr = andonargs.getVlreferenciastr();
            this.VlReferencianum = andonargs.getVlreferencianum();
        }
    }
 
    public void copyAndonArgsDTO(AndonArgsDTO andonargs)
    {
        this.IdUp = andonargs.getIdup();
        this.IdeventoAndon = andonargs.getIdeventoandon();
        this.OrdemCondicao = andonargs.getOrdemcondicao();
        this.OperadorLogico = andonargs.getOperadorlogico();
        this.OperadorCalculo = andonargs.getOperadorcalculo();
        this.TpVlreferencia = andonargs.getTpvlreferencia();
        this.VlReferenciastr = andonargs.getVlreferenciastr();
        this.VlReferencianum = andonargs.getVlreferencianum();

    }
    
    public boolean validaValorReferenciaString(String c) {
    	if(c == null || c.equals("") || this.VlReferenciastr == null || this.VlReferenciastr.equals(""))
    		return false;
    	return (this.VlReferenciastr.equals(c));
    }

    public String getIdup()
    {
        return this.IdUp;
    }

    public void setIdup(String idup)
    {
        this.IdUp = idup;
    }

    public double getIdeventoandon()
    {
        return this.IdeventoAndon;
    }

    public void setIdeventoandon(double ideventoandon)
    {
        this.IdeventoAndon = ideventoandon;
    }

    public int getOrdemcondicao()
    {
        return this.OrdemCondicao;
    }

    public void setOrdemcondicao(int ordemCondicao)
    {
        this.OrdemCondicao = ordemCondicao;
    }

    public String getOperadorlogico() {
        return this.OperadorLogico;
    }

    public void setOperadorlogico(String operadorlogico) {
        this.OperadorLogico = operadorlogico;
    }

    public String getOperadorcalculo() {
        return this.OperadorCalculo;
    }

    public void setOperadorcalculo(String operadorcalculo) {
        this.OperadorCalculo = operadorcalculo;
    }

    public int getTpvlreferencia() {
        return this.TpVlreferencia;
    }

    public void setTpvlreferencia(int tpvlreferencia) {
        this.TpVlreferencia = tpvlreferencia;
    }

    public String getVlreferenciastr() {
        return this.VlReferenciastr;
    }

    public void setVlreferenciastr(String vlreferenciastr) {
        this.VlReferenciastr = vlreferenciastr;
    }

    public Double getVlreferencianum() {
        return this.VlReferencianum;
    }

    public void setVlreferencianum(Double vlreferencianum) {
        this.VlReferencianum = vlreferencianum;
    }
}
