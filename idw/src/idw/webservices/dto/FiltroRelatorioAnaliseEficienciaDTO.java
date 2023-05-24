package idw.webservices.dto;

import java.util.Date;

import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;

public class FiltroRelatorioAnaliseEficienciaDTO {

    private Date dt_inicio;
    private Date dt_final;
    private OmPt ompt;
    private OmGt omgt;
    private boolean peso;
    private boolean peca;
    private String unidMedida;
    private String tipo;
    private boolean isUnidMedidaKg;

    public Date getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(Date dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    public Date getDt_final() {
        return dt_final;
    }

    public void setDt_final(Date dt_final) {
        this.dt_final = dt_final;
    }

    public OmPt getOmpt() {
        return ompt;
    }

    public void setOmpt(OmPt ompt) {
        this.ompt = ompt;
    }

    public OmGt getOmgt() {
        return omgt;
    }

    public void setOmgt(OmGt omgt) {
        this.omgt = omgt;
    }

    public boolean isPeca() {
        return peca;
    }

    public void setPeca(boolean peca) {
        this.peca = peca;
    }

    /**
     * @deprecated usar {@link #isUnidMedidaKg()} 
     * @return
     */
    public String getUnidMedida() {
        return unidMedida;
    }
    
    /**
     * @deprecated usar {@link #isUnidMedidaKg()}
     * @param unidMedida
     */
    public void setUnidMedida(String unidMedida) {
        this.unidMedida = unidMedida;
    }
    
    /**
     * Identifica se unidade de medida é por kg<br>
     * Se <code> {@link #isPeso()} == true && {@link #isUnidMedidaKg()} == true </code>, unidade de medida é por quilo.
     * Se <code> {@link #isPeso()} == true && {@link #isUnidMedidaKg()} == false </code>, unidade de medida é por tonelada.
     * @return
     */
    public boolean isUnidMedidaKg() {
        return isUnidMedidaKg;
    }
    
    /**
     * Atribuir <code>true</code> se unidade de medida for por peso<br> 
     * Pré-requisito: <code>{@link #isPeca()} == false && {@link #isPeso()} == true</code>
     * @param isUnidMedidaPeso
     */
    public void setUnidMedidaKg(boolean isUnidMedidaPeso) {
        this.isUnidMedidaKg = isUnidMedidaPeso;
    }

    public boolean isPeso() {
        return peso;
    }

    public void setPeso(boolean peso) {
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "FiltroRelatorioAnaliseEficienciaDTO [dt_inicio=" + dt_inicio + ", dt_final=" + dt_final + ", ompt=" + ompt + ", omgt="
                + omgt + ", peso=" + peso + ", peca=" + peca + ", unidMedida=" + unidMedida + ", tipo=" + tipo + ", isUnidMedidaKg="
                + isUnidMedidaKg + "]";
    }

}
