package idw.model.rn.relatorios.consolidados;

import java.util.List;

public class PostoConsolidadoDTO {
    
    private List<PostoFerramentaDTO> ferramentas;

    private boolean isPrimeiraLinha;
    private boolean isLinhaTotal;
    private String posto;
    private String ton;
    private String horasTrabalhadas;
    private String horasParadas;
    private String tempoAtivo;
    private String indiceParadas;
    private String oee;
    private String oeeCap;
    private String indPcsCiclo;
    
    public List<PostoFerramentaDTO> getFerramentas() {
        return ferramentas;
    }
    public void setFerramentas(List<PostoFerramentaDTO> ferramentas) {
        this.ferramentas = ferramentas;
    }
    public String getPosto() {
        return posto;
    }
    public void setPosto(String posto) {
        this.posto = posto;
    }
    public String getTon() {
        return ton;
    }
    public void setTon(String ton) {
        this.ton = ton;
    }
    public String getHorasTrabalhadas() {
        return horasTrabalhadas;
    }
    public void setHorasTrabalhadas(String horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
    public String getHorasParadas() {
        return horasParadas;
    }
    public void setHorasParadas(String horasParadas) {
        this.horasParadas = horasParadas;
    }
    public String getTempoAtivo() {
        return tempoAtivo;
    }
    public void setTempoAtivo(String tempoAtivo) {
        this.tempoAtivo = tempoAtivo;
    }
    public String getIndiceParadas() {
        return indiceParadas;
    }
    public void setIndiceParadas(String indiceParadas) {
        this.indiceParadas = indiceParadas;
    }
    public String getOee() {
        return oee;
    }
    public void setOee(String oee) {
        this.oee = oee;
    }
    public String getOeeCap() {
        return oeeCap;
    }
    public void setOeeCap(String oeeCap) {
        this.oeeCap = oeeCap;
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
	public String getIndPcsCiclo() {
		return indPcsCiclo;
	}
	public void setIndPcsCiclo(String indPcsCiclo) {
		this.indPcsCiclo = indPcsCiclo;
	}
    
    
}
