package idw.model.rn.relatorios.consolidados;

import java.util.List;

public class FerramentaConsolidadoDTO {
    
    private List<FerramentaPostoDTO> postos;

    private boolean isPrimeiraLinha;
    private boolean isLinhaTotal;
    private String ferramenta;
    private String cicloPadrao;
    private String cicloLido;
    private String eficienciaCiclo;
    private String cavidadesAtivas;
    private String cavidadesTotais;
    private String indiceCavidades;
    
    public List<FerramentaPostoDTO> getPostos() {
        return postos;
    }
    public void setPostos(List<FerramentaPostoDTO> postos) {
        this.postos = postos;
    }
    public String getFerramenta() {
        return ferramenta;
    }
    public void setFerramenta(String ferramenta) {
        this.ferramenta = ferramenta;
    }
    public String getCicloPadrao() {
        return cicloPadrao;
    }
    public void setCicloPadrao(String cicloPadrao) {
        this.cicloPadrao = cicloPadrao;
    }
    public String getCicloLido() {
        return cicloLido;
    }
    public void setCicloLido(String cicloLido) {
        this.cicloLido = cicloLido;
    }
    public String getEficienciaCiclo() {
        return eficienciaCiclo;
    }
    public void setEficienciaCiclo(String eficienciaCiclo) {
        this.eficienciaCiclo = eficienciaCiclo;
    }
    public String getCavidadesAtivas() {
        return cavidadesAtivas;
    }
    public void setCavidadesAtivas(String cavidadesAtivas) {
        this.cavidadesAtivas = cavidadesAtivas;
    }
    public String getCavidadesTotais() {
        return cavidadesTotais;
    }
    public void setCavidadesTotais(String cavidadesTotais) {
        this.cavidadesTotais = cavidadesTotais;
    }
    public String getIndiceCavidades() {
        return indiceCavidades;
    }
    public void setIndiceCavidades(String indiceCavidades) {
        this.indiceCavidades = indiceCavidades;
    }
    public boolean isLinhaTotal() {
        return isLinhaTotal;
    }
    public void setLinhaTotal(boolean isLinhaTotal) {
        this.isLinhaTotal = isLinhaTotal;
    }
    public boolean isPrimeiraLinha() {
        return isPrimeiraLinha;
    }
    public void setPrimeiraLinha(boolean isPrimeiraLinha) {
        this.isPrimeiraLinha = isPrimeiraLinha;
    }
    
    
}
