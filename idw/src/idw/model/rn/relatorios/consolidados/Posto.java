package idw.model.rn.relatorios.consolidados;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwConsolid;
import idw.model.rn.DataHoraRN;
import idw.model.rn.detalhemonitorizacao.IndicadoresDeTempoRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import ms.util.ConversaoTipos;

public class Posto {
    
    private final DwConsolid id;
    private List<DwConsolid> ids = new ArrayList<>();
    
    private String posto;
    private BigDecimal ton = BigDecimal.ZERO;
    private BigDecimal horasTrabalhadas = BigDecimal.ZERO;
    private BigDecimal horasParadas = BigDecimal.ZERO;
    private BigDecimal tempoAtivo = BigDecimal.ZERO;
    private BigDecimal indiceParadas = BigDecimal.ZERO;
    
    private BigDecimal tempoRitmo = BigDecimal.ZERO;
    private BigDecimal tempoProducaoLiquida = BigDecimal.ZERO;
    
    //campos usados em calculos internos
    private BigDecimal tempoParadaSp = BigDecimal.ZERO;
    private BigDecimal tempoTotal = BigDecimal.ZERO;
    
	private Double pcsCicAtiva = 0d;
	private Double pcsCicTotal = 0d;
	private Double indPcsCiclo = 0d;
    
    public Posto() {
    	super();
        id = null;
    }
    
    public Posto(String posto) {
    	super();
        id = null;
        this.posto = posto;
    }
    
    public Posto(DAOGenerico dao, DwConsolid id) {
    	super();
        this.id = id;
        adicionar(id);
        
        this.posto = id.getOmPt().getCdPt();
        
        this.horasTrabalhadas =
                AritmeticaUtil.somar(
                        id.getDwConsol().getSegAutoTempotrabalhado(),
                        id.getDwConsol().getSegManuTempotrabalhado());
        this.horasParadas =
                AritmeticaUtil.somar(
                        id.getDwConsol().getSegAutoTempoparadaCp(),
                        id.getDwConsol().getSegManuTempoparadaCp());
        this.tempoAtivo =
                AritmeticaUtil.somar(
                        id.getDwConsol().getSegAutoTempoativo(),
                        id.getDwConsol().getSegManuTempoativo());
        
        
        IndicadoresDeTempoRN rn = new IndicadoresDeTempoRN(id.getDwConsol());
        
        this.tempoRitmo = rn.getTempoRitmo();
        this.tempoProducaoLiquida = rn.getTempoProducaoLiquida();
        
        this.tempoParadaSp = 
                AritmeticaUtil.somar(
                        id.getDwConsol().getSegAutoTempoparadaSp(),
                        id.getDwConsol().getSegManuTempoparadaSp());
        
        calcularValores(); 
    }
    
    private void calcularOIndPcsPorCiclo(){
    	Map<Long, String> mapIndPcsCiclo = new HashMap<Long, String>();
    	pcsCicAtiva = 0d;
    	pcsCicTotal = 0d;
    	
    	for(DwConsolid id : ids) {
    		if (mapIndPcsCiclo.containsKey(id.getDwFolha().getIdFolha()) == false) {
    			mapIndPcsCiclo.put(id.getDwFolha().getIdFolha(), id.getDwFolha().getCdFolha());
        		pcsCicAtiva += (id.getDwConsol().getQtAutoCavativas() == null ? 0d : id.getDwConsol().getQtAutoCavativas().doubleValue());
        		pcsCicTotal += (id.getDwConsol().getQtAutoCavtotal() == null ? 0d : id.getDwConsol().getQtAutoCavtotal().doubleValue());
    		}
    	}
    	if (pcsCicTotal < pcsCicAtiva)
    		pcsCicTotal = pcsCicAtiva;
    	
    	this.indPcsCiclo = FormulasInjet.calcularIndicePcsPorCicloAtivas(new BigDecimal(pcsCicTotal) , new BigDecimal(pcsCicAtiva)).doubleValue();
    }
    
    public void contabilizarTotal(Posto posto) {
        this.horasTrabalhadas =
                AritmeticaUtil.somar(
                        this.horasTrabalhadas,
                        posto.getHorasTrabalhadas());
        posto.horasTrabalhadas = BigDecimal.ZERO;
        
        this.horasParadas =
                AritmeticaUtil.somar(
                        this.horasParadas,
                        posto.getHorasParadas());
        posto.horasParadas = BigDecimal.ZERO;
        
        this.tempoAtivo =
                AritmeticaUtil.somar(
                        this.tempoAtivo,
                        posto.getTempoAtivo());        
        posto.tempoAtivo = BigDecimal.ZERO;
        
        this.calcularIndiceParadas();
    }
    
    public void adicionar(Posto posto) {
        adicionar(posto.getId());
        
        this.horasTrabalhadas =
                AritmeticaUtil.somar(
                        this.horasTrabalhadas,
                        posto.getHorasTrabalhadas());
        this.horasParadas =
                AritmeticaUtil.somar(
                        this.horasParadas,
                        posto.getHorasParadas());
        this.tempoAtivo =
                AritmeticaUtil.somar(
                        this.tempoAtivo,
                        posto.getTempoAtivo());
        
        this.tempoRitmo = AritmeticaUtil.somar(
        		this.tempoRitmo, 
        		posto.getTempoRitmo());
        
        this.tempoProducaoLiquida = AritmeticaUtil.somar(
        		this.tempoProducaoLiquida, 
        		posto.getTempoProducaoLiquida());
        
        
        this.tempoParadaSp = 
                AritmeticaUtil.somar(
                        this.tempoParadaSp,
                        posto.getTempoParadaSp());
        calcularValores();        
    }
    
    public void adicionar(DwConsolid novoId) {
        if(novoId == null) {
            return;
        }
        
        boolean isSalvarNovoId = true;
        for(DwConsolid i : ids) {
            if(i.getIdConsolid() == novoId.getIdConsolid()) {
                isSalvarNovoId = false;
                break;
            }
        }
        
        if(isSalvarNovoId) {
            ids.add(novoId);
        }
    }
    
    public void calcularValores() {
        calcularIndiceParadas();
        calcularTempoTotal();
        calcularOIndPcsPorCiclo();
    }
    
    public String getChave() {
        return getPosto();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Posto) {
            Posto objeto = (Posto) obj;
            if(objeto.getChave().equals(getChave())) {
                return true;
            }
        }
        return false;
    }
    
    private void calcularIndiceParadas() {
        this.indiceParadas = 
                new BigDecimal(
                        FormulasInjet.calcularIndiceParada(
                                horasParadas, 
                                tempoAtivo));
    }
    
    private void calcularTempoTotal() {
        this.tempoTotal = 
                new BigDecimal(
                        FormulasInjet.calcularTempoTotal(
                                tempoParadaSp,
                                tempoAtivo));
    }
    
    
    
    //GETTERS FORMATADO
    public String getTonFormatado() {
        return ConversaoTipos.converteParaStringComFormat(getTon().doubleValue(), 0);
    }
    
    public String getHorasTrabalhadasFormatado() {
        return DataHoraRN.formatSegundosParaHHMMSS(getHorasTrabalhadas().intValue());
    }
    
    public String getHorasParadasFormatado() {
        return DataHoraRN.formatSegundosParaHHMMSS(getHorasParadas().intValue());
    }
    
    public String getTempoAtivoFormatado() {
        return DataHoraRN.formatSegundosParaHHMMSS(getTempoAtivo().intValue());
    }
    
    public String getIndiceParadasFormatado() {
        return ConversaoTipos.converteParaStringComFormat(getIndiceParadas().doubleValue(), 2);
    }
    
    public String getOeeFormatado() {
        return ConversaoTipos.converteParaStringComFormat(getOee().doubleValue(), 2);
    }
    
    public String getOeeCapFormatado() {
        return ConversaoTipos.converteParaStringComFormat(getOeeCap().doubleValue(), 2);
    }

    public String getIndPcsCicloFormatado() {
    	return ConversaoTipos.converteParaStringComFormat(getIndPcsCiclo(),2);
    }
    
    //GETTERS
    public DwConsolid getId() {
        return id;
    }

    public List<DwConsolid> getIds() {
        return ids;
    }

    public void setIds(List<DwConsolid> ids) {
        this.ids = ids;
    }

    public String getPosto() {
        return posto;
    }

    public BigDecimal getTon() {
        return ton;
    }

    public BigDecimal getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public BigDecimal getHorasParadas() {
        return horasParadas;
    }

    public BigDecimal getTempoAtivo() {
        return tempoAtivo;
    }

    public BigDecimal getIndiceParadas() {
        return indiceParadas;
    }

    public BigDecimal getOee() {
    	IndicadoresDeTempoRN rn = new IndicadoresDeTempoRN(null);
    	BigDecimal tempoProdutivo = rn.getSegTempoProdutivo(
    			BigDecimal.ONE, 
    			tempoProducaoLiquida, 
    			tempoRitmo);
    	
        BigDecimal oee = new BigDecimal(
                        FormulasInjet.calcularOEE(
                                tempoProdutivo,
                                tempoTotal.subtract(tempoParadaSp)));
        
        return oee;
    }

    public BigDecimal getOeeCap() {
    	IndicadoresDeTempoRN rn = new IndicadoresDeTempoRN(null);
    	BigDecimal tempoProdutivo = rn.getSegTempoProdutivo(
    			BigDecimal.ONE, 
    			tempoProducaoLiquida, 
    			tempoRitmo);

    	BigDecimal oeeCap = 
                new BigDecimal(
                        FormulasInjet.calcularOEECapital(
                                tempoProdutivo,
                                tempoTotal));
    	return oeeCap;
    }

    public BigDecimal getTempoParadaSp() {
        return tempoParadaSp;
    }

    public BigDecimal getTempoTotal() {
        return tempoTotal;
    }

	public BigDecimal getTempoRitmo() {
		return tempoRitmo;
	}

	public BigDecimal getTempoProducaoLiquida() {
		return tempoProducaoLiquida;
	}

	public Double getPcsCicAtiva() {
		return pcsCicAtiva;
	}

	public void setPcsCicAtiva(Double pcsCicAtiva) {
		this.pcsCicAtiva = pcsCicAtiva;
	}

	public Double getPcsCicTotal() {
		return pcsCicTotal;
	}

	public void setPcsCicTotal(Double pcsCicTotal) {
		this.pcsCicTotal = pcsCicTotal;
	}

	public Double getIndPcsCiclo() {
		return indPcsCiclo;
	}

	public void setIndPcsCiclo(Double indPcsCiclo) {
		this.indPcsCiclo = indPcsCiclo;
	}

}
