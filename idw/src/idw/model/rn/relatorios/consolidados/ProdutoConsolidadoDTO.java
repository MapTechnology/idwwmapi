package idw.model.rn.relatorios.consolidados;

import java.util.ArrayList;
import java.util.List;

public class ProdutoConsolidadoDTO {
    
    private List<ProdutoFerramentaDTO> ferramentas = new ArrayList<>();
    
    private boolean isPrimeiraLinha;
    private boolean isLinhaTotal;
    private String produto;
    private String pecasPrevistas;
    private String pecasProduzidas;
    private String pecasRefugadas;
    private String pecasBoas;
    private String indiceRefugo;
    private String eficienciaRealizacao;
    
    public List<ProdutoFerramentaDTO> getFerramentas() {
        return ferramentas;
    }
    public void setFerramentas(List<ProdutoFerramentaDTO> ferramentas) {
        this.ferramentas = ferramentas;
    }
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public String getPecasPrevistas() {
        return pecasPrevistas;
    }
    public void setPecasPrevistas(String pecasPrevistas) {
        this.pecasPrevistas = pecasPrevistas;
    }
    public String getPecasProduzidas() {
        return pecasProduzidas;
    }
    public void setPecasProduzidas(String pecasProduzidas) {
        this.pecasProduzidas = pecasProduzidas;
    }
    public String getPecasRefugadas() {
        return pecasRefugadas;
    }
    public void setPecasRefugadas(String pecasRefugadas) {
        this.pecasRefugadas = pecasRefugadas;
    }
    public String getPecasBoas() {
        return pecasBoas;
    }
    public void setPecasBoas(String pecasBoas) {
        this.pecasBoas = pecasBoas;
    }
    public String getIndiceRefugo() {
        return indiceRefugo;
    }
    public void setIndiceRefugo(String indiceRefugo) {
        this.indiceRefugo = indiceRefugo;
    }
    public String getEficienciaRealizacao() {
        return eficienciaRealizacao;
    }
    public void setEficienciaRealizacao(String eficienciaRealizacao) {
        this.eficienciaRealizacao = eficienciaRealizacao;
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
