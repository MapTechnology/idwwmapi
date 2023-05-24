/**
 * DwConsollog.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsollog  implements java.io.Serializable {
    private java.lang.String dsLog;

    private java.util.Calendar dthrLog;

    private idw.idwws.DwConsol dwConsol;

    private long idConsollog;

    private idw.idwws.OmUsr omUsr;

    private java.lang.Long pcsCorrPerdacavidades;

    private java.lang.Long pcsCorrPerdaciclo;

    private java.lang.Long pcsCorrPerdaparada;

    private java.lang.Long pcsCorrPerdaparadaSp;

    private java.lang.Long pcsCorrProducaobruta;

    private java.lang.Long pcsCorrProducaoprevista;

    private java.lang.Long pcsCorrProducaorefugada;

    private java.lang.Long pcsCorrQtinjnormal;

    private java.math.BigDecimal segCorrBoas;

    private java.math.BigDecimal segCorrCicloimprodutivo;

    private java.math.BigDecimal segCorrCiclomedio;

    private java.math.BigDecimal segCorrCiclopadrao;

    private java.math.BigDecimal segCorrCicloprodutivo;

    private java.math.BigDecimal segCorrPerdacav;

    private java.math.BigDecimal segCorrPerdaciclo;

    private java.math.BigDecimal segCorrRitmo;

    private java.math.BigDecimal segCorrTempoalerta;

    private java.math.BigDecimal segCorrTempoativo;

    private java.math.BigDecimal segCorrTempocalendario;

    private java.math.BigDecimal segCorrTempocalsempeso;

    private java.math.BigDecimal segCorrTempodisponivel;

    private java.math.BigDecimal segCorrTempoparada;

    private java.math.BigDecimal segCorrTempoparadaSp;

    private java.math.BigDecimal segCorrTempoprodutivas;

    private java.math.BigDecimal segCorrTemporefugadas;

    private java.math.BigDecimal segCorrTempotrabalhado;

    private java.math.BigDecimal segCorrTmpcicnormal;

    public DwConsollog() {
    }

    public DwConsollog(
           java.lang.String dsLog,
           java.util.Calendar dthrLog,
           idw.idwws.DwConsol dwConsol,
           long idConsollog,
           idw.idwws.OmUsr omUsr,
           java.lang.Long pcsCorrPerdacavidades,
           java.lang.Long pcsCorrPerdaciclo,
           java.lang.Long pcsCorrPerdaparada,
           java.lang.Long pcsCorrPerdaparadaSp,
           java.lang.Long pcsCorrProducaobruta,
           java.lang.Long pcsCorrProducaoprevista,
           java.lang.Long pcsCorrProducaorefugada,
           java.lang.Long pcsCorrQtinjnormal,
           java.math.BigDecimal segCorrBoas,
           java.math.BigDecimal segCorrCicloimprodutivo,
           java.math.BigDecimal segCorrCiclomedio,
           java.math.BigDecimal segCorrCiclopadrao,
           java.math.BigDecimal segCorrCicloprodutivo,
           java.math.BigDecimal segCorrPerdacav,
           java.math.BigDecimal segCorrPerdaciclo,
           java.math.BigDecimal segCorrRitmo,
           java.math.BigDecimal segCorrTempoalerta,
           java.math.BigDecimal segCorrTempoativo,
           java.math.BigDecimal segCorrTempocalendario,
           java.math.BigDecimal segCorrTempocalsempeso,
           java.math.BigDecimal segCorrTempodisponivel,
           java.math.BigDecimal segCorrTempoparada,
           java.math.BigDecimal segCorrTempoparadaSp,
           java.math.BigDecimal segCorrTempoprodutivas,
           java.math.BigDecimal segCorrTemporefugadas,
           java.math.BigDecimal segCorrTempotrabalhado,
           java.math.BigDecimal segCorrTmpcicnormal) {
           this.dsLog = dsLog;
           this.dthrLog = dthrLog;
           this.dwConsol = dwConsol;
           this.idConsollog = idConsollog;
           this.omUsr = omUsr;
           this.pcsCorrPerdacavidades = pcsCorrPerdacavidades;
           this.pcsCorrPerdaciclo = pcsCorrPerdaciclo;
           this.pcsCorrPerdaparada = pcsCorrPerdaparada;
           this.pcsCorrPerdaparadaSp = pcsCorrPerdaparadaSp;
           this.pcsCorrProducaobruta = pcsCorrProducaobruta;
           this.pcsCorrProducaoprevista = pcsCorrProducaoprevista;
           this.pcsCorrProducaorefugada = pcsCorrProducaorefugada;
           this.pcsCorrQtinjnormal = pcsCorrQtinjnormal;
           this.segCorrBoas = segCorrBoas;
           this.segCorrCicloimprodutivo = segCorrCicloimprodutivo;
           this.segCorrCiclomedio = segCorrCiclomedio;
           this.segCorrCiclopadrao = segCorrCiclopadrao;
           this.segCorrCicloprodutivo = segCorrCicloprodutivo;
           this.segCorrPerdacav = segCorrPerdacav;
           this.segCorrPerdaciclo = segCorrPerdaciclo;
           this.segCorrRitmo = segCorrRitmo;
           this.segCorrTempoalerta = segCorrTempoalerta;
           this.segCorrTempoativo = segCorrTempoativo;
           this.segCorrTempocalendario = segCorrTempocalendario;
           this.segCorrTempocalsempeso = segCorrTempocalsempeso;
           this.segCorrTempodisponivel = segCorrTempodisponivel;
           this.segCorrTempoparada = segCorrTempoparada;
           this.segCorrTempoparadaSp = segCorrTempoparadaSp;
           this.segCorrTempoprodutivas = segCorrTempoprodutivas;
           this.segCorrTemporefugadas = segCorrTemporefugadas;
           this.segCorrTempotrabalhado = segCorrTempotrabalhado;
           this.segCorrTmpcicnormal = segCorrTmpcicnormal;
    }


    /**
     * Gets the dsLog value for this DwConsollog.
     * 
     * @return dsLog
     */
    public java.lang.String getDsLog() {
        return dsLog;
    }


    /**
     * Sets the dsLog value for this DwConsollog.
     * 
     * @param dsLog
     */
    public void setDsLog(java.lang.String dsLog) {
        this.dsLog = dsLog;
    }


    /**
     * Gets the dthrLog value for this DwConsollog.
     * 
     * @return dthrLog
     */
    public java.util.Calendar getDthrLog() {
        return dthrLog;
    }


    /**
     * Sets the dthrLog value for this DwConsollog.
     * 
     * @param dthrLog
     */
    public void setDthrLog(java.util.Calendar dthrLog) {
        this.dthrLog = dthrLog;
    }


    /**
     * Gets the dwConsol value for this DwConsollog.
     * 
     * @return dwConsol
     */
    public idw.idwws.DwConsol getDwConsol() {
        return dwConsol;
    }


    /**
     * Sets the dwConsol value for this DwConsollog.
     * 
     * @param dwConsol
     */
    public void setDwConsol(idw.idwws.DwConsol dwConsol) {
        this.dwConsol = dwConsol;
    }


    /**
     * Gets the idConsollog value for this DwConsollog.
     * 
     * @return idConsollog
     */
    public long getIdConsollog() {
        return idConsollog;
    }


    /**
     * Sets the idConsollog value for this DwConsollog.
     * 
     * @param idConsollog
     */
    public void setIdConsollog(long idConsollog) {
        this.idConsollog = idConsollog;
    }


    /**
     * Gets the omUsr value for this DwConsollog.
     * 
     * @return omUsr
     */
    public idw.idwws.OmUsr getOmUsr() {
        return omUsr;
    }


    /**
     * Sets the omUsr value for this DwConsollog.
     * 
     * @param omUsr
     */
    public void setOmUsr(idw.idwws.OmUsr omUsr) {
        this.omUsr = omUsr;
    }


    /**
     * Gets the pcsCorrPerdacavidades value for this DwConsollog.
     * 
     * @return pcsCorrPerdacavidades
     */
    public java.lang.Long getPcsCorrPerdacavidades() {
        return pcsCorrPerdacavidades;
    }


    /**
     * Sets the pcsCorrPerdacavidades value for this DwConsollog.
     * 
     * @param pcsCorrPerdacavidades
     */
    public void setPcsCorrPerdacavidades(java.lang.Long pcsCorrPerdacavidades) {
        this.pcsCorrPerdacavidades = pcsCorrPerdacavidades;
    }


    /**
     * Gets the pcsCorrPerdaciclo value for this DwConsollog.
     * 
     * @return pcsCorrPerdaciclo
     */
    public java.lang.Long getPcsCorrPerdaciclo() {
        return pcsCorrPerdaciclo;
    }


    /**
     * Sets the pcsCorrPerdaciclo value for this DwConsollog.
     * 
     * @param pcsCorrPerdaciclo
     */
    public void setPcsCorrPerdaciclo(java.lang.Long pcsCorrPerdaciclo) {
        this.pcsCorrPerdaciclo = pcsCorrPerdaciclo;
    }


    /**
     * Gets the pcsCorrPerdaparada value for this DwConsollog.
     * 
     * @return pcsCorrPerdaparada
     */
    public java.lang.Long getPcsCorrPerdaparada() {
        return pcsCorrPerdaparada;
    }


    /**
     * Sets the pcsCorrPerdaparada value for this DwConsollog.
     * 
     * @param pcsCorrPerdaparada
     */
    public void setPcsCorrPerdaparada(java.lang.Long pcsCorrPerdaparada) {
        this.pcsCorrPerdaparada = pcsCorrPerdaparada;
    }


    /**
     * Gets the pcsCorrPerdaparadaSp value for this DwConsollog.
     * 
     * @return pcsCorrPerdaparadaSp
     */
    public java.lang.Long getPcsCorrPerdaparadaSp() {
        return pcsCorrPerdaparadaSp;
    }


    /**
     * Sets the pcsCorrPerdaparadaSp value for this DwConsollog.
     * 
     * @param pcsCorrPerdaparadaSp
     */
    public void setPcsCorrPerdaparadaSp(java.lang.Long pcsCorrPerdaparadaSp) {
        this.pcsCorrPerdaparadaSp = pcsCorrPerdaparadaSp;
    }


    /**
     * Gets the pcsCorrProducaobruta value for this DwConsollog.
     * 
     * @return pcsCorrProducaobruta
     */
    public java.lang.Long getPcsCorrProducaobruta() {
        return pcsCorrProducaobruta;
    }


    /**
     * Sets the pcsCorrProducaobruta value for this DwConsollog.
     * 
     * @param pcsCorrProducaobruta
     */
    public void setPcsCorrProducaobruta(java.lang.Long pcsCorrProducaobruta) {
        this.pcsCorrProducaobruta = pcsCorrProducaobruta;
    }


    /**
     * Gets the pcsCorrProducaoprevista value for this DwConsollog.
     * 
     * @return pcsCorrProducaoprevista
     */
    public java.lang.Long getPcsCorrProducaoprevista() {
        return pcsCorrProducaoprevista;
    }


    /**
     * Sets the pcsCorrProducaoprevista value for this DwConsollog.
     * 
     * @param pcsCorrProducaoprevista
     */
    public void setPcsCorrProducaoprevista(java.lang.Long pcsCorrProducaoprevista) {
        this.pcsCorrProducaoprevista = pcsCorrProducaoprevista;
    }


    /**
     * Gets the pcsCorrProducaorefugada value for this DwConsollog.
     * 
     * @return pcsCorrProducaorefugada
     */
    public java.lang.Long getPcsCorrProducaorefugada() {
        return pcsCorrProducaorefugada;
    }


    /**
     * Sets the pcsCorrProducaorefugada value for this DwConsollog.
     * 
     * @param pcsCorrProducaorefugada
     */
    public void setPcsCorrProducaorefugada(java.lang.Long pcsCorrProducaorefugada) {
        this.pcsCorrProducaorefugada = pcsCorrProducaorefugada;
    }


    /**
     * Gets the pcsCorrQtinjnormal value for this DwConsollog.
     * 
     * @return pcsCorrQtinjnormal
     */
    public java.lang.Long getPcsCorrQtinjnormal() {
        return pcsCorrQtinjnormal;
    }


    /**
     * Sets the pcsCorrQtinjnormal value for this DwConsollog.
     * 
     * @param pcsCorrQtinjnormal
     */
    public void setPcsCorrQtinjnormal(java.lang.Long pcsCorrQtinjnormal) {
        this.pcsCorrQtinjnormal = pcsCorrQtinjnormal;
    }


    /**
     * Gets the segCorrBoas value for this DwConsollog.
     * 
     * @return segCorrBoas
     */
    public java.math.BigDecimal getSegCorrBoas() {
        return segCorrBoas;
    }


    /**
     * Sets the segCorrBoas value for this DwConsollog.
     * 
     * @param segCorrBoas
     */
    public void setSegCorrBoas(java.math.BigDecimal segCorrBoas) {
        this.segCorrBoas = segCorrBoas;
    }


    /**
     * Gets the segCorrCicloimprodutivo value for this DwConsollog.
     * 
     * @return segCorrCicloimprodutivo
     */
    public java.math.BigDecimal getSegCorrCicloimprodutivo() {
        return segCorrCicloimprodutivo;
    }


    /**
     * Sets the segCorrCicloimprodutivo value for this DwConsollog.
     * 
     * @param segCorrCicloimprodutivo
     */
    public void setSegCorrCicloimprodutivo(java.math.BigDecimal segCorrCicloimprodutivo) {
        this.segCorrCicloimprodutivo = segCorrCicloimprodutivo;
    }


    /**
     * Gets the segCorrCiclomedio value for this DwConsollog.
     * 
     * @return segCorrCiclomedio
     */
    public java.math.BigDecimal getSegCorrCiclomedio() {
        return segCorrCiclomedio;
    }


    /**
     * Sets the segCorrCiclomedio value for this DwConsollog.
     * 
     * @param segCorrCiclomedio
     */
    public void setSegCorrCiclomedio(java.math.BigDecimal segCorrCiclomedio) {
        this.segCorrCiclomedio = segCorrCiclomedio;
    }


    /**
     * Gets the segCorrCiclopadrao value for this DwConsollog.
     * 
     * @return segCorrCiclopadrao
     */
    public java.math.BigDecimal getSegCorrCiclopadrao() {
        return segCorrCiclopadrao;
    }


    /**
     * Sets the segCorrCiclopadrao value for this DwConsollog.
     * 
     * @param segCorrCiclopadrao
     */
    public void setSegCorrCiclopadrao(java.math.BigDecimal segCorrCiclopadrao) {
        this.segCorrCiclopadrao = segCorrCiclopadrao;
    }


    /**
     * Gets the segCorrCicloprodutivo value for this DwConsollog.
     * 
     * @return segCorrCicloprodutivo
     */
    public java.math.BigDecimal getSegCorrCicloprodutivo() {
        return segCorrCicloprodutivo;
    }


    /**
     * Sets the segCorrCicloprodutivo value for this DwConsollog.
     * 
     * @param segCorrCicloprodutivo
     */
    public void setSegCorrCicloprodutivo(java.math.BigDecimal segCorrCicloprodutivo) {
        this.segCorrCicloprodutivo = segCorrCicloprodutivo;
    }


    /**
     * Gets the segCorrPerdacav value for this DwConsollog.
     * 
     * @return segCorrPerdacav
     */
    public java.math.BigDecimal getSegCorrPerdacav() {
        return segCorrPerdacav;
    }


    /**
     * Sets the segCorrPerdacav value for this DwConsollog.
     * 
     * @param segCorrPerdacav
     */
    public void setSegCorrPerdacav(java.math.BigDecimal segCorrPerdacav) {
        this.segCorrPerdacav = segCorrPerdacav;
    }


    /**
     * Gets the segCorrPerdaciclo value for this DwConsollog.
     * 
     * @return segCorrPerdaciclo
     */
    public java.math.BigDecimal getSegCorrPerdaciclo() {
        return segCorrPerdaciclo;
    }


    /**
     * Sets the segCorrPerdaciclo value for this DwConsollog.
     * 
     * @param segCorrPerdaciclo
     */
    public void setSegCorrPerdaciclo(java.math.BigDecimal segCorrPerdaciclo) {
        this.segCorrPerdaciclo = segCorrPerdaciclo;
    }


    /**
     * Gets the segCorrRitmo value for this DwConsollog.
     * 
     * @return segCorrRitmo
     */
    public java.math.BigDecimal getSegCorrRitmo() {
        return segCorrRitmo;
    }


    /**
     * Sets the segCorrRitmo value for this DwConsollog.
     * 
     * @param segCorrRitmo
     */
    public void setSegCorrRitmo(java.math.BigDecimal segCorrRitmo) {
        this.segCorrRitmo = segCorrRitmo;
    }


    /**
     * Gets the segCorrTempoalerta value for this DwConsollog.
     * 
     * @return segCorrTempoalerta
     */
    public java.math.BigDecimal getSegCorrTempoalerta() {
        return segCorrTempoalerta;
    }


    /**
     * Sets the segCorrTempoalerta value for this DwConsollog.
     * 
     * @param segCorrTempoalerta
     */
    public void setSegCorrTempoalerta(java.math.BigDecimal segCorrTempoalerta) {
        this.segCorrTempoalerta = segCorrTempoalerta;
    }


    /**
     * Gets the segCorrTempoativo value for this DwConsollog.
     * 
     * @return segCorrTempoativo
     */
    public java.math.BigDecimal getSegCorrTempoativo() {
        return segCorrTempoativo;
    }


    /**
     * Sets the segCorrTempoativo value for this DwConsollog.
     * 
     * @param segCorrTempoativo
     */
    public void setSegCorrTempoativo(java.math.BigDecimal segCorrTempoativo) {
        this.segCorrTempoativo = segCorrTempoativo;
    }


    /**
     * Gets the segCorrTempocalendario value for this DwConsollog.
     * 
     * @return segCorrTempocalendario
     */
    public java.math.BigDecimal getSegCorrTempocalendario() {
        return segCorrTempocalendario;
    }


    /**
     * Sets the segCorrTempocalendario value for this DwConsollog.
     * 
     * @param segCorrTempocalendario
     */
    public void setSegCorrTempocalendario(java.math.BigDecimal segCorrTempocalendario) {
        this.segCorrTempocalendario = segCorrTempocalendario;
    }


    /**
     * Gets the segCorrTempocalsempeso value for this DwConsollog.
     * 
     * @return segCorrTempocalsempeso
     */
    public java.math.BigDecimal getSegCorrTempocalsempeso() {
        return segCorrTempocalsempeso;
    }


    /**
     * Sets the segCorrTempocalsempeso value for this DwConsollog.
     * 
     * @param segCorrTempocalsempeso
     */
    public void setSegCorrTempocalsempeso(java.math.BigDecimal segCorrTempocalsempeso) {
        this.segCorrTempocalsempeso = segCorrTempocalsempeso;
    }


    /**
     * Gets the segCorrTempodisponivel value for this DwConsollog.
     * 
     * @return segCorrTempodisponivel
     */
    public java.math.BigDecimal getSegCorrTempodisponivel() {
        return segCorrTempodisponivel;
    }


    /**
     * Sets the segCorrTempodisponivel value for this DwConsollog.
     * 
     * @param segCorrTempodisponivel
     */
    public void setSegCorrTempodisponivel(java.math.BigDecimal segCorrTempodisponivel) {
        this.segCorrTempodisponivel = segCorrTempodisponivel;
    }


    /**
     * Gets the segCorrTempoparada value for this DwConsollog.
     * 
     * @return segCorrTempoparada
     */
    public java.math.BigDecimal getSegCorrTempoparada() {
        return segCorrTempoparada;
    }


    /**
     * Sets the segCorrTempoparada value for this DwConsollog.
     * 
     * @param segCorrTempoparada
     */
    public void setSegCorrTempoparada(java.math.BigDecimal segCorrTempoparada) {
        this.segCorrTempoparada = segCorrTempoparada;
    }


    /**
     * Gets the segCorrTempoparadaSp value for this DwConsollog.
     * 
     * @return segCorrTempoparadaSp
     */
    public java.math.BigDecimal getSegCorrTempoparadaSp() {
        return segCorrTempoparadaSp;
    }


    /**
     * Sets the segCorrTempoparadaSp value for this DwConsollog.
     * 
     * @param segCorrTempoparadaSp
     */
    public void setSegCorrTempoparadaSp(java.math.BigDecimal segCorrTempoparadaSp) {
        this.segCorrTempoparadaSp = segCorrTempoparadaSp;
    }


    /**
     * Gets the segCorrTempoprodutivas value for this DwConsollog.
     * 
     * @return segCorrTempoprodutivas
     */
    public java.math.BigDecimal getSegCorrTempoprodutivas() {
        return segCorrTempoprodutivas;
    }


    /**
     * Sets the segCorrTempoprodutivas value for this DwConsollog.
     * 
     * @param segCorrTempoprodutivas
     */
    public void setSegCorrTempoprodutivas(java.math.BigDecimal segCorrTempoprodutivas) {
        this.segCorrTempoprodutivas = segCorrTempoprodutivas;
    }


    /**
     * Gets the segCorrTemporefugadas value for this DwConsollog.
     * 
     * @return segCorrTemporefugadas
     */
    public java.math.BigDecimal getSegCorrTemporefugadas() {
        return segCorrTemporefugadas;
    }


    /**
     * Sets the segCorrTemporefugadas value for this DwConsollog.
     * 
     * @param segCorrTemporefugadas
     */
    public void setSegCorrTemporefugadas(java.math.BigDecimal segCorrTemporefugadas) {
        this.segCorrTemporefugadas = segCorrTemporefugadas;
    }


    /**
     * Gets the segCorrTempotrabalhado value for this DwConsollog.
     * 
     * @return segCorrTempotrabalhado
     */
    public java.math.BigDecimal getSegCorrTempotrabalhado() {
        return segCorrTempotrabalhado;
    }


    /**
     * Sets the segCorrTempotrabalhado value for this DwConsollog.
     * 
     * @param segCorrTempotrabalhado
     */
    public void setSegCorrTempotrabalhado(java.math.BigDecimal segCorrTempotrabalhado) {
        this.segCorrTempotrabalhado = segCorrTempotrabalhado;
    }


    /**
     * Gets the segCorrTmpcicnormal value for this DwConsollog.
     * 
     * @return segCorrTmpcicnormal
     */
    public java.math.BigDecimal getSegCorrTmpcicnormal() {
        return segCorrTmpcicnormal;
    }


    /**
     * Sets the segCorrTmpcicnormal value for this DwConsollog.
     * 
     * @param segCorrTmpcicnormal
     */
    public void setSegCorrTmpcicnormal(java.math.BigDecimal segCorrTmpcicnormal) {
        this.segCorrTmpcicnormal = segCorrTmpcicnormal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsollog)) return false;
        DwConsollog other = (DwConsollog) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dsLog==null && other.getDsLog()==null) || 
             (this.dsLog!=null &&
              this.dsLog.equals(other.getDsLog()))) &&
            ((this.dthrLog==null && other.getDthrLog()==null) || 
             (this.dthrLog!=null &&
              this.dthrLog.equals(other.getDthrLog()))) &&
            ((this.dwConsol==null && other.getDwConsol()==null) || 
             (this.dwConsol!=null &&
              this.dwConsol.equals(other.getDwConsol()))) &&
            this.idConsollog == other.getIdConsollog() &&
            ((this.omUsr==null && other.getOmUsr()==null) || 
             (this.omUsr!=null &&
              this.omUsr.equals(other.getOmUsr()))) &&
            ((this.pcsCorrPerdacavidades==null && other.getPcsCorrPerdacavidades()==null) || 
             (this.pcsCorrPerdacavidades!=null &&
              this.pcsCorrPerdacavidades.equals(other.getPcsCorrPerdacavidades()))) &&
            ((this.pcsCorrPerdaciclo==null && other.getPcsCorrPerdaciclo()==null) || 
             (this.pcsCorrPerdaciclo!=null &&
              this.pcsCorrPerdaciclo.equals(other.getPcsCorrPerdaciclo()))) &&
            ((this.pcsCorrPerdaparada==null && other.getPcsCorrPerdaparada()==null) || 
             (this.pcsCorrPerdaparada!=null &&
              this.pcsCorrPerdaparada.equals(other.getPcsCorrPerdaparada()))) &&
            ((this.pcsCorrPerdaparadaSp==null && other.getPcsCorrPerdaparadaSp()==null) || 
             (this.pcsCorrPerdaparadaSp!=null &&
              this.pcsCorrPerdaparadaSp.equals(other.getPcsCorrPerdaparadaSp()))) &&
            ((this.pcsCorrProducaobruta==null && other.getPcsCorrProducaobruta()==null) || 
             (this.pcsCorrProducaobruta!=null &&
              this.pcsCorrProducaobruta.equals(other.getPcsCorrProducaobruta()))) &&
            ((this.pcsCorrProducaoprevista==null && other.getPcsCorrProducaoprevista()==null) || 
             (this.pcsCorrProducaoprevista!=null &&
              this.pcsCorrProducaoprevista.equals(other.getPcsCorrProducaoprevista()))) &&
            ((this.pcsCorrProducaorefugada==null && other.getPcsCorrProducaorefugada()==null) || 
             (this.pcsCorrProducaorefugada!=null &&
              this.pcsCorrProducaorefugada.equals(other.getPcsCorrProducaorefugada()))) &&
            ((this.pcsCorrQtinjnormal==null && other.getPcsCorrQtinjnormal()==null) || 
             (this.pcsCorrQtinjnormal!=null &&
              this.pcsCorrQtinjnormal.equals(other.getPcsCorrQtinjnormal()))) &&
            ((this.segCorrBoas==null && other.getSegCorrBoas()==null) || 
             (this.segCorrBoas!=null &&
              this.segCorrBoas.equals(other.getSegCorrBoas()))) &&
            ((this.segCorrCicloimprodutivo==null && other.getSegCorrCicloimprodutivo()==null) || 
             (this.segCorrCicloimprodutivo!=null &&
              this.segCorrCicloimprodutivo.equals(other.getSegCorrCicloimprodutivo()))) &&
            ((this.segCorrCiclomedio==null && other.getSegCorrCiclomedio()==null) || 
             (this.segCorrCiclomedio!=null &&
              this.segCorrCiclomedio.equals(other.getSegCorrCiclomedio()))) &&
            ((this.segCorrCiclopadrao==null && other.getSegCorrCiclopadrao()==null) || 
             (this.segCorrCiclopadrao!=null &&
              this.segCorrCiclopadrao.equals(other.getSegCorrCiclopadrao()))) &&
            ((this.segCorrCicloprodutivo==null && other.getSegCorrCicloprodutivo()==null) || 
             (this.segCorrCicloprodutivo!=null &&
              this.segCorrCicloprodutivo.equals(other.getSegCorrCicloprodutivo()))) &&
            ((this.segCorrPerdacav==null && other.getSegCorrPerdacav()==null) || 
             (this.segCorrPerdacav!=null &&
              this.segCorrPerdacav.equals(other.getSegCorrPerdacav()))) &&
            ((this.segCorrPerdaciclo==null && other.getSegCorrPerdaciclo()==null) || 
             (this.segCorrPerdaciclo!=null &&
              this.segCorrPerdaciclo.equals(other.getSegCorrPerdaciclo()))) &&
            ((this.segCorrRitmo==null && other.getSegCorrRitmo()==null) || 
             (this.segCorrRitmo!=null &&
              this.segCorrRitmo.equals(other.getSegCorrRitmo()))) &&
            ((this.segCorrTempoalerta==null && other.getSegCorrTempoalerta()==null) || 
             (this.segCorrTempoalerta!=null &&
              this.segCorrTempoalerta.equals(other.getSegCorrTempoalerta()))) &&
            ((this.segCorrTempoativo==null && other.getSegCorrTempoativo()==null) || 
             (this.segCorrTempoativo!=null &&
              this.segCorrTempoativo.equals(other.getSegCorrTempoativo()))) &&
            ((this.segCorrTempocalendario==null && other.getSegCorrTempocalendario()==null) || 
             (this.segCorrTempocalendario!=null &&
              this.segCorrTempocalendario.equals(other.getSegCorrTempocalendario()))) &&
            ((this.segCorrTempocalsempeso==null && other.getSegCorrTempocalsempeso()==null) || 
             (this.segCorrTempocalsempeso!=null &&
              this.segCorrTempocalsempeso.equals(other.getSegCorrTempocalsempeso()))) &&
            ((this.segCorrTempodisponivel==null && other.getSegCorrTempodisponivel()==null) || 
             (this.segCorrTempodisponivel!=null &&
              this.segCorrTempodisponivel.equals(other.getSegCorrTempodisponivel()))) &&
            ((this.segCorrTempoparada==null && other.getSegCorrTempoparada()==null) || 
             (this.segCorrTempoparada!=null &&
              this.segCorrTempoparada.equals(other.getSegCorrTempoparada()))) &&
            ((this.segCorrTempoparadaSp==null && other.getSegCorrTempoparadaSp()==null) || 
             (this.segCorrTempoparadaSp!=null &&
              this.segCorrTempoparadaSp.equals(other.getSegCorrTempoparadaSp()))) &&
            ((this.segCorrTempoprodutivas==null && other.getSegCorrTempoprodutivas()==null) || 
             (this.segCorrTempoprodutivas!=null &&
              this.segCorrTempoprodutivas.equals(other.getSegCorrTempoprodutivas()))) &&
            ((this.segCorrTemporefugadas==null && other.getSegCorrTemporefugadas()==null) || 
             (this.segCorrTemporefugadas!=null &&
              this.segCorrTemporefugadas.equals(other.getSegCorrTemporefugadas()))) &&
            ((this.segCorrTempotrabalhado==null && other.getSegCorrTempotrabalhado()==null) || 
             (this.segCorrTempotrabalhado!=null &&
              this.segCorrTempotrabalhado.equals(other.getSegCorrTempotrabalhado()))) &&
            ((this.segCorrTmpcicnormal==null && other.getSegCorrTmpcicnormal()==null) || 
             (this.segCorrTmpcicnormal!=null &&
              this.segCorrTmpcicnormal.equals(other.getSegCorrTmpcicnormal())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDsLog() != null) {
            _hashCode += getDsLog().hashCode();
        }
        if (getDthrLog() != null) {
            _hashCode += getDthrLog().hashCode();
        }
        if (getDwConsol() != null) {
            _hashCode += getDwConsol().hashCode();
        }
        _hashCode += new Long(getIdConsollog()).hashCode();
        if (getOmUsr() != null) {
            _hashCode += getOmUsr().hashCode();
        }
        if (getPcsCorrPerdacavidades() != null) {
            _hashCode += getPcsCorrPerdacavidades().hashCode();
        }
        if (getPcsCorrPerdaciclo() != null) {
            _hashCode += getPcsCorrPerdaciclo().hashCode();
        }
        if (getPcsCorrPerdaparada() != null) {
            _hashCode += getPcsCorrPerdaparada().hashCode();
        }
        if (getPcsCorrPerdaparadaSp() != null) {
            _hashCode += getPcsCorrPerdaparadaSp().hashCode();
        }
        if (getPcsCorrProducaobruta() != null) {
            _hashCode += getPcsCorrProducaobruta().hashCode();
        }
        if (getPcsCorrProducaoprevista() != null) {
            _hashCode += getPcsCorrProducaoprevista().hashCode();
        }
        if (getPcsCorrProducaorefugada() != null) {
            _hashCode += getPcsCorrProducaorefugada().hashCode();
        }
        if (getPcsCorrQtinjnormal() != null) {
            _hashCode += getPcsCorrQtinjnormal().hashCode();
        }
        if (getSegCorrBoas() != null) {
            _hashCode += getSegCorrBoas().hashCode();
        }
        if (getSegCorrCicloimprodutivo() != null) {
            _hashCode += getSegCorrCicloimprodutivo().hashCode();
        }
        if (getSegCorrCiclomedio() != null) {
            _hashCode += getSegCorrCiclomedio().hashCode();
        }
        if (getSegCorrCiclopadrao() != null) {
            _hashCode += getSegCorrCiclopadrao().hashCode();
        }
        if (getSegCorrCicloprodutivo() != null) {
            _hashCode += getSegCorrCicloprodutivo().hashCode();
        }
        if (getSegCorrPerdacav() != null) {
            _hashCode += getSegCorrPerdacav().hashCode();
        }
        if (getSegCorrPerdaciclo() != null) {
            _hashCode += getSegCorrPerdaciclo().hashCode();
        }
        if (getSegCorrRitmo() != null) {
            _hashCode += getSegCorrRitmo().hashCode();
        }
        if (getSegCorrTempoalerta() != null) {
            _hashCode += getSegCorrTempoalerta().hashCode();
        }
        if (getSegCorrTempoativo() != null) {
            _hashCode += getSegCorrTempoativo().hashCode();
        }
        if (getSegCorrTempocalendario() != null) {
            _hashCode += getSegCorrTempocalendario().hashCode();
        }
        if (getSegCorrTempocalsempeso() != null) {
            _hashCode += getSegCorrTempocalsempeso().hashCode();
        }
        if (getSegCorrTempodisponivel() != null) {
            _hashCode += getSegCorrTempodisponivel().hashCode();
        }
        if (getSegCorrTempoparada() != null) {
            _hashCode += getSegCorrTempoparada().hashCode();
        }
        if (getSegCorrTempoparadaSp() != null) {
            _hashCode += getSegCorrTempoparadaSp().hashCode();
        }
        if (getSegCorrTempoprodutivas() != null) {
            _hashCode += getSegCorrTempoprodutivas().hashCode();
        }
        if (getSegCorrTemporefugadas() != null) {
            _hashCode += getSegCorrTemporefugadas().hashCode();
        }
        if (getSegCorrTempotrabalhado() != null) {
            _hashCode += getSegCorrTempotrabalhado().hashCode();
        }
        if (getSegCorrTmpcicnormal() != null) {
            _hashCode += getSegCorrTmpcicnormal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsollog.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsollog"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsLog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsLog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrLog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrLog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsollog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsollog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsCorrPerdacavidades");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsCorrPerdacavidades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsCorrPerdaciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsCorrPerdaciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsCorrPerdaparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsCorrPerdaparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsCorrPerdaparadaSp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsCorrPerdaparadaSp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsCorrProducaobruta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsCorrProducaobruta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsCorrProducaoprevista");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsCorrProducaoprevista"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsCorrProducaorefugada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsCorrProducaorefugada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsCorrQtinjnormal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsCorrQtinjnormal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCorrBoas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCorrBoas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCorrCicloimprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCorrCicloimprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCorrCiclomedio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCorrCiclomedio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCorrCiclopadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCorrCiclopadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCorrCicloprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCorrCicloprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCorrPerdacav");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCorrPerdacav"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCorrPerdaciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCorrPerdaciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCorrRitmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCorrRitmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCorrTempoalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCorrTempoalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCorrTempoativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCorrTempoativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCorrTempocalendario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCorrTempocalendario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCorrTempocalsempeso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCorrTempocalsempeso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCorrTempodisponivel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCorrTempodisponivel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCorrTempoparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCorrTempoparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCorrTempoparadaSp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCorrTempoparadaSp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCorrTempoprodutivas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCorrTempoprodutivas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCorrTemporefugadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCorrTemporefugadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCorrTempotrabalhado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCorrTempotrabalhado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segCorrTmpcicnormal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCorrTmpcicnormal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
