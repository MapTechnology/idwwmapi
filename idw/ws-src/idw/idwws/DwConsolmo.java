/**
 * DwConsolmo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolmo  implements java.io.Serializable {
    private idw.idwws.DwConsol dwConsol;

    private idw.idwws.DwConsolalmo[] dwConsolalmos;

    private idw.idwws.DwConsolmooco[] dwConsolmoocos;

    private idw.idwws.DwConsolpamo[] dwConsolpamos;

    private idw.idwws.DwConsolprmo[] dwConsolprmos;

    private idw.idwws.DwConsolremo[] dwConsolremos;

    private long idConsolmo;

    private idw.idwws.OmUsr omUsr;

    private java.math.BigDecimal pcsAutoPerda;

    private java.math.BigDecimal pcsAutoProducaobruta;

    private java.math.BigDecimal pcsAutoProducaoprevista;

    private java.math.BigDecimal pcsAutoProducaorefugada;

    private java.math.BigDecimal pcsManuProducaobruta;

    private java.math.BigDecimal pcsManuProducaoprevista;

    private java.math.BigDecimal pcsManuProducaorefugada;

    private java.math.BigDecimal qtAutoCicloimprodutivo;

    private java.math.BigDecimal qtAutoCicloprodutivo;

    private java.math.BigDecimal qtAutoCicloregulagem;

    private java.math.BigDecimal qtAutoOcoparadaCpVr;

    private java.math.BigDecimal qtAutoOcoparadaSpVr;

    private java.math.BigDecimal qtAutoTempoparadaDefault;

    private java.math.BigDecimal qtAutoTempoparadaSemCnx;

    private java.math.BigDecimal qtAutoTempoparadaSemEvt;

    private java.math.BigDecimal qtAutoTempoparadaSemOp;

    private java.math.BigDecimal qtManuCicloimprodutivo;

    private java.math.BigDecimal qtManuCicloprodutivo;

    private java.math.BigDecimal qtManuCicloregulagem;

    private java.math.BigDecimal qtManuOcoparadaCpVr;

    private java.math.BigDecimal qtManuOcoparadaSpVr;

    private java.math.BigDecimal qtManuTempoparadaDefault;

    private java.math.BigDecimal qtManuTempoparadaSemCnx;

    private java.math.BigDecimal qtManuTempoparadaSemEvt;

    private java.math.BigDecimal qtManuTempoparadaSemOp;

    private java.math.BigDecimal segAutoCicloimprodutivo;

    private java.math.BigDecimal segAutoCicloimprodutivoCta;

    private java.math.BigDecimal segAutoCicloprodutivo;

    private java.math.BigDecimal segAutoCicloprodutivoCta;

    private java.math.BigDecimal segAutoCicloregulagem;

    private java.math.BigDecimal segAutoCta;

    private java.math.BigDecimal segAutoTempologin;

    private java.math.BigDecimal segAutoTempoparadaCp;

    private java.math.BigDecimal segAutoTempoparadaCpVr;

    private java.math.BigDecimal segAutoTempoparadaDefault;

    private java.math.BigDecimal segAutoTempoparadaSemCnx;

    private java.math.BigDecimal segAutoTempoparadaSemEvt;

    private java.math.BigDecimal segAutoTempoparadaSemOp;

    private java.math.BigDecimal segAutoTempoparadaSp;

    private java.math.BigDecimal segAutoTempoparadaSpVr;

    private java.math.BigDecimal segAutoTempotrabalhado;

    private java.math.BigDecimal segManuCicloimprodutivo;

    private java.math.BigDecimal segManuCicloimprodutivoCta;

    private java.math.BigDecimal segManuCicloprodutivo;

    private java.math.BigDecimal segManuCicloprodutivoCta;

    private java.math.BigDecimal segManuCicloregulagem;

    private java.math.BigDecimal segManuCta;

    private java.math.BigDecimal segManuTempologin;

    private java.math.BigDecimal segManuTempoparadaCp;

    private java.math.BigDecimal segManuTempoparadaCpVr;

    private java.math.BigDecimal segManuTempoparadaDefault;

    private java.math.BigDecimal segManuTempoparadaSemCnx;

    private java.math.BigDecimal segManuTempoparadaSemEvt;

    private java.math.BigDecimal segManuTempoparadaSemOp;

    private java.math.BigDecimal segManuTempoparadaSp;

    private java.math.BigDecimal segManuTempoparadaSpVr;

    public DwConsolmo() {
    }

    public DwConsolmo(
           idw.idwws.DwConsol dwConsol,
           idw.idwws.DwConsolalmo[] dwConsolalmos,
           idw.idwws.DwConsolmooco[] dwConsolmoocos,
           idw.idwws.DwConsolpamo[] dwConsolpamos,
           idw.idwws.DwConsolprmo[] dwConsolprmos,
           idw.idwws.DwConsolremo[] dwConsolremos,
           long idConsolmo,
           idw.idwws.OmUsr omUsr,
           java.math.BigDecimal pcsAutoPerda,
           java.math.BigDecimal pcsAutoProducaobruta,
           java.math.BigDecimal pcsAutoProducaoprevista,
           java.math.BigDecimal pcsAutoProducaorefugada,
           java.math.BigDecimal pcsManuProducaobruta,
           java.math.BigDecimal pcsManuProducaoprevista,
           java.math.BigDecimal pcsManuProducaorefugada,
           java.math.BigDecimal qtAutoCicloimprodutivo,
           java.math.BigDecimal qtAutoCicloprodutivo,
           java.math.BigDecimal qtAutoCicloregulagem,
           java.math.BigDecimal qtAutoOcoparadaCpVr,
           java.math.BigDecimal qtAutoOcoparadaSpVr,
           java.math.BigDecimal qtAutoTempoparadaDefault,
           java.math.BigDecimal qtAutoTempoparadaSemCnx,
           java.math.BigDecimal qtAutoTempoparadaSemEvt,
           java.math.BigDecimal qtAutoTempoparadaSemOp,
           java.math.BigDecimal qtManuCicloimprodutivo,
           java.math.BigDecimal qtManuCicloprodutivo,
           java.math.BigDecimal qtManuCicloregulagem,
           java.math.BigDecimal qtManuOcoparadaCpVr,
           java.math.BigDecimal qtManuOcoparadaSpVr,
           java.math.BigDecimal qtManuTempoparadaDefault,
           java.math.BigDecimal qtManuTempoparadaSemCnx,
           java.math.BigDecimal qtManuTempoparadaSemEvt,
           java.math.BigDecimal qtManuTempoparadaSemOp,
           java.math.BigDecimal segAutoCicloimprodutivo,
           java.math.BigDecimal segAutoCicloimprodutivoCta,
           java.math.BigDecimal segAutoCicloprodutivo,
           java.math.BigDecimal segAutoCicloprodutivoCta,
           java.math.BigDecimal segAutoCicloregulagem,
           java.math.BigDecimal segAutoCta,
           java.math.BigDecimal segAutoTempologin,
           java.math.BigDecimal segAutoTempoparadaCp,
           java.math.BigDecimal segAutoTempoparadaCpVr,
           java.math.BigDecimal segAutoTempoparadaDefault,
           java.math.BigDecimal segAutoTempoparadaSemCnx,
           java.math.BigDecimal segAutoTempoparadaSemEvt,
           java.math.BigDecimal segAutoTempoparadaSemOp,
           java.math.BigDecimal segAutoTempoparadaSp,
           java.math.BigDecimal segAutoTempoparadaSpVr,
           java.math.BigDecimal segAutoTempotrabalhado,
           java.math.BigDecimal segManuCicloimprodutivo,
           java.math.BigDecimal segManuCicloimprodutivoCta,
           java.math.BigDecimal segManuCicloprodutivo,
           java.math.BigDecimal segManuCicloprodutivoCta,
           java.math.BigDecimal segManuCicloregulagem,
           java.math.BigDecimal segManuCta,
           java.math.BigDecimal segManuTempologin,
           java.math.BigDecimal segManuTempoparadaCp,
           java.math.BigDecimal segManuTempoparadaCpVr,
           java.math.BigDecimal segManuTempoparadaDefault,
           java.math.BigDecimal segManuTempoparadaSemCnx,
           java.math.BigDecimal segManuTempoparadaSemEvt,
           java.math.BigDecimal segManuTempoparadaSemOp,
           java.math.BigDecimal segManuTempoparadaSp,
           java.math.BigDecimal segManuTempoparadaSpVr) {
           this.dwConsol = dwConsol;
           this.dwConsolalmos = dwConsolalmos;
           this.dwConsolmoocos = dwConsolmoocos;
           this.dwConsolpamos = dwConsolpamos;
           this.dwConsolprmos = dwConsolprmos;
           this.dwConsolremos = dwConsolremos;
           this.idConsolmo = idConsolmo;
           this.omUsr = omUsr;
           this.pcsAutoPerda = pcsAutoPerda;
           this.pcsAutoProducaobruta = pcsAutoProducaobruta;
           this.pcsAutoProducaoprevista = pcsAutoProducaoprevista;
           this.pcsAutoProducaorefugada = pcsAutoProducaorefugada;
           this.pcsManuProducaobruta = pcsManuProducaobruta;
           this.pcsManuProducaoprevista = pcsManuProducaoprevista;
           this.pcsManuProducaorefugada = pcsManuProducaorefugada;
           this.qtAutoCicloimprodutivo = qtAutoCicloimprodutivo;
           this.qtAutoCicloprodutivo = qtAutoCicloprodutivo;
           this.qtAutoCicloregulagem = qtAutoCicloregulagem;
           this.qtAutoOcoparadaCpVr = qtAutoOcoparadaCpVr;
           this.qtAutoOcoparadaSpVr = qtAutoOcoparadaSpVr;
           this.qtAutoTempoparadaDefault = qtAutoTempoparadaDefault;
           this.qtAutoTempoparadaSemCnx = qtAutoTempoparadaSemCnx;
           this.qtAutoTempoparadaSemEvt = qtAutoTempoparadaSemEvt;
           this.qtAutoTempoparadaSemOp = qtAutoTempoparadaSemOp;
           this.qtManuCicloimprodutivo = qtManuCicloimprodutivo;
           this.qtManuCicloprodutivo = qtManuCicloprodutivo;
           this.qtManuCicloregulagem = qtManuCicloregulagem;
           this.qtManuOcoparadaCpVr = qtManuOcoparadaCpVr;
           this.qtManuOcoparadaSpVr = qtManuOcoparadaSpVr;
           this.qtManuTempoparadaDefault = qtManuTempoparadaDefault;
           this.qtManuTempoparadaSemCnx = qtManuTempoparadaSemCnx;
           this.qtManuTempoparadaSemEvt = qtManuTempoparadaSemEvt;
           this.qtManuTempoparadaSemOp = qtManuTempoparadaSemOp;
           this.segAutoCicloimprodutivo = segAutoCicloimprodutivo;
           this.segAutoCicloimprodutivoCta = segAutoCicloimprodutivoCta;
           this.segAutoCicloprodutivo = segAutoCicloprodutivo;
           this.segAutoCicloprodutivoCta = segAutoCicloprodutivoCta;
           this.segAutoCicloregulagem = segAutoCicloregulagem;
           this.segAutoCta = segAutoCta;
           this.segAutoTempologin = segAutoTempologin;
           this.segAutoTempoparadaCp = segAutoTempoparadaCp;
           this.segAutoTempoparadaCpVr = segAutoTempoparadaCpVr;
           this.segAutoTempoparadaDefault = segAutoTempoparadaDefault;
           this.segAutoTempoparadaSemCnx = segAutoTempoparadaSemCnx;
           this.segAutoTempoparadaSemEvt = segAutoTempoparadaSemEvt;
           this.segAutoTempoparadaSemOp = segAutoTempoparadaSemOp;
           this.segAutoTempoparadaSp = segAutoTempoparadaSp;
           this.segAutoTempoparadaSpVr = segAutoTempoparadaSpVr;
           this.segAutoTempotrabalhado = segAutoTempotrabalhado;
           this.segManuCicloimprodutivo = segManuCicloimprodutivo;
           this.segManuCicloimprodutivoCta = segManuCicloimprodutivoCta;
           this.segManuCicloprodutivo = segManuCicloprodutivo;
           this.segManuCicloprodutivoCta = segManuCicloprodutivoCta;
           this.segManuCicloregulagem = segManuCicloregulagem;
           this.segManuCta = segManuCta;
           this.segManuTempologin = segManuTempologin;
           this.segManuTempoparadaCp = segManuTempoparadaCp;
           this.segManuTempoparadaCpVr = segManuTempoparadaCpVr;
           this.segManuTempoparadaDefault = segManuTempoparadaDefault;
           this.segManuTempoparadaSemCnx = segManuTempoparadaSemCnx;
           this.segManuTempoparadaSemEvt = segManuTempoparadaSemEvt;
           this.segManuTempoparadaSemOp = segManuTempoparadaSemOp;
           this.segManuTempoparadaSp = segManuTempoparadaSp;
           this.segManuTempoparadaSpVr = segManuTempoparadaSpVr;
    }


    /**
     * Gets the dwConsol value for this DwConsolmo.
     * 
     * @return dwConsol
     */
    public idw.idwws.DwConsol getDwConsol() {
        return dwConsol;
    }


    /**
     * Sets the dwConsol value for this DwConsolmo.
     * 
     * @param dwConsol
     */
    public void setDwConsol(idw.idwws.DwConsol dwConsol) {
        this.dwConsol = dwConsol;
    }


    /**
     * Gets the dwConsolalmos value for this DwConsolmo.
     * 
     * @return dwConsolalmos
     */
    public idw.idwws.DwConsolalmo[] getDwConsolalmos() {
        return dwConsolalmos;
    }


    /**
     * Sets the dwConsolalmos value for this DwConsolmo.
     * 
     * @param dwConsolalmos
     */
    public void setDwConsolalmos(idw.idwws.DwConsolalmo[] dwConsolalmos) {
        this.dwConsolalmos = dwConsolalmos;
    }

    public idw.idwws.DwConsolalmo getDwConsolalmos(int i) {
        return this.dwConsolalmos[i];
    }

    public void setDwConsolalmos(int i, idw.idwws.DwConsolalmo _value) {
        this.dwConsolalmos[i] = _value;
    }


    /**
     * Gets the dwConsolmoocos value for this DwConsolmo.
     * 
     * @return dwConsolmoocos
     */
    public idw.idwws.DwConsolmooco[] getDwConsolmoocos() {
        return dwConsolmoocos;
    }


    /**
     * Sets the dwConsolmoocos value for this DwConsolmo.
     * 
     * @param dwConsolmoocos
     */
    public void setDwConsolmoocos(idw.idwws.DwConsolmooco[] dwConsolmoocos) {
        this.dwConsolmoocos = dwConsolmoocos;
    }

    public idw.idwws.DwConsolmooco getDwConsolmoocos(int i) {
        return this.dwConsolmoocos[i];
    }

    public void setDwConsolmoocos(int i, idw.idwws.DwConsolmooco _value) {
        this.dwConsolmoocos[i] = _value;
    }


    /**
     * Gets the dwConsolpamos value for this DwConsolmo.
     * 
     * @return dwConsolpamos
     */
    public idw.idwws.DwConsolpamo[] getDwConsolpamos() {
        return dwConsolpamos;
    }


    /**
     * Sets the dwConsolpamos value for this DwConsolmo.
     * 
     * @param dwConsolpamos
     */
    public void setDwConsolpamos(idw.idwws.DwConsolpamo[] dwConsolpamos) {
        this.dwConsolpamos = dwConsolpamos;
    }

    public idw.idwws.DwConsolpamo getDwConsolpamos(int i) {
        return this.dwConsolpamos[i];
    }

    public void setDwConsolpamos(int i, idw.idwws.DwConsolpamo _value) {
        this.dwConsolpamos[i] = _value;
    }


    /**
     * Gets the dwConsolprmos value for this DwConsolmo.
     * 
     * @return dwConsolprmos
     */
    public idw.idwws.DwConsolprmo[] getDwConsolprmos() {
        return dwConsolprmos;
    }


    /**
     * Sets the dwConsolprmos value for this DwConsolmo.
     * 
     * @param dwConsolprmos
     */
    public void setDwConsolprmos(idw.idwws.DwConsolprmo[] dwConsolprmos) {
        this.dwConsolprmos = dwConsolprmos;
    }

    public idw.idwws.DwConsolprmo getDwConsolprmos(int i) {
        return this.dwConsolprmos[i];
    }

    public void setDwConsolprmos(int i, idw.idwws.DwConsolprmo _value) {
        this.dwConsolprmos[i] = _value;
    }


    /**
     * Gets the dwConsolremos value for this DwConsolmo.
     * 
     * @return dwConsolremos
     */
    public idw.idwws.DwConsolremo[] getDwConsolremos() {
        return dwConsolremos;
    }


    /**
     * Sets the dwConsolremos value for this DwConsolmo.
     * 
     * @param dwConsolremos
     */
    public void setDwConsolremos(idw.idwws.DwConsolremo[] dwConsolremos) {
        this.dwConsolremos = dwConsolremos;
    }

    public idw.idwws.DwConsolremo getDwConsolremos(int i) {
        return this.dwConsolremos[i];
    }

    public void setDwConsolremos(int i, idw.idwws.DwConsolremo _value) {
        this.dwConsolremos[i] = _value;
    }


    /**
     * Gets the idConsolmo value for this DwConsolmo.
     * 
     * @return idConsolmo
     */
    public long getIdConsolmo() {
        return idConsolmo;
    }


    /**
     * Sets the idConsolmo value for this DwConsolmo.
     * 
     * @param idConsolmo
     */
    public void setIdConsolmo(long idConsolmo) {
        this.idConsolmo = idConsolmo;
    }


    /**
     * Gets the omUsr value for this DwConsolmo.
     * 
     * @return omUsr
     */
    public idw.idwws.OmUsr getOmUsr() {
        return omUsr;
    }


    /**
     * Sets the omUsr value for this DwConsolmo.
     * 
     * @param omUsr
     */
    public void setOmUsr(idw.idwws.OmUsr omUsr) {
        this.omUsr = omUsr;
    }


    /**
     * Gets the pcsAutoPerda value for this DwConsolmo.
     * 
     * @return pcsAutoPerda
     */
    public java.math.BigDecimal getPcsAutoPerda() {
        return pcsAutoPerda;
    }


    /**
     * Sets the pcsAutoPerda value for this DwConsolmo.
     * 
     * @param pcsAutoPerda
     */
    public void setPcsAutoPerda(java.math.BigDecimal pcsAutoPerda) {
        this.pcsAutoPerda = pcsAutoPerda;
    }


    /**
     * Gets the pcsAutoProducaobruta value for this DwConsolmo.
     * 
     * @return pcsAutoProducaobruta
     */
    public java.math.BigDecimal getPcsAutoProducaobruta() {
        return pcsAutoProducaobruta;
    }


    /**
     * Sets the pcsAutoProducaobruta value for this DwConsolmo.
     * 
     * @param pcsAutoProducaobruta
     */
    public void setPcsAutoProducaobruta(java.math.BigDecimal pcsAutoProducaobruta) {
        this.pcsAutoProducaobruta = pcsAutoProducaobruta;
    }


    /**
     * Gets the pcsAutoProducaoprevista value for this DwConsolmo.
     * 
     * @return pcsAutoProducaoprevista
     */
    public java.math.BigDecimal getPcsAutoProducaoprevista() {
        return pcsAutoProducaoprevista;
    }


    /**
     * Sets the pcsAutoProducaoprevista value for this DwConsolmo.
     * 
     * @param pcsAutoProducaoprevista
     */
    public void setPcsAutoProducaoprevista(java.math.BigDecimal pcsAutoProducaoprevista) {
        this.pcsAutoProducaoprevista = pcsAutoProducaoprevista;
    }


    /**
     * Gets the pcsAutoProducaorefugada value for this DwConsolmo.
     * 
     * @return pcsAutoProducaorefugada
     */
    public java.math.BigDecimal getPcsAutoProducaorefugada() {
        return pcsAutoProducaorefugada;
    }


    /**
     * Sets the pcsAutoProducaorefugada value for this DwConsolmo.
     * 
     * @param pcsAutoProducaorefugada
     */
    public void setPcsAutoProducaorefugada(java.math.BigDecimal pcsAutoProducaorefugada) {
        this.pcsAutoProducaorefugada = pcsAutoProducaorefugada;
    }


    /**
     * Gets the pcsManuProducaobruta value for this DwConsolmo.
     * 
     * @return pcsManuProducaobruta
     */
    public java.math.BigDecimal getPcsManuProducaobruta() {
        return pcsManuProducaobruta;
    }


    /**
     * Sets the pcsManuProducaobruta value for this DwConsolmo.
     * 
     * @param pcsManuProducaobruta
     */
    public void setPcsManuProducaobruta(java.math.BigDecimal pcsManuProducaobruta) {
        this.pcsManuProducaobruta = pcsManuProducaobruta;
    }


    /**
     * Gets the pcsManuProducaoprevista value for this DwConsolmo.
     * 
     * @return pcsManuProducaoprevista
     */
    public java.math.BigDecimal getPcsManuProducaoprevista() {
        return pcsManuProducaoprevista;
    }


    /**
     * Sets the pcsManuProducaoprevista value for this DwConsolmo.
     * 
     * @param pcsManuProducaoprevista
     */
    public void setPcsManuProducaoprevista(java.math.BigDecimal pcsManuProducaoprevista) {
        this.pcsManuProducaoprevista = pcsManuProducaoprevista;
    }


    /**
     * Gets the pcsManuProducaorefugada value for this DwConsolmo.
     * 
     * @return pcsManuProducaorefugada
     */
    public java.math.BigDecimal getPcsManuProducaorefugada() {
        return pcsManuProducaorefugada;
    }


    /**
     * Sets the pcsManuProducaorefugada value for this DwConsolmo.
     * 
     * @param pcsManuProducaorefugada
     */
    public void setPcsManuProducaorefugada(java.math.BigDecimal pcsManuProducaorefugada) {
        this.pcsManuProducaorefugada = pcsManuProducaorefugada;
    }


    /**
     * Gets the qtAutoCicloimprodutivo value for this DwConsolmo.
     * 
     * @return qtAutoCicloimprodutivo
     */
    public java.math.BigDecimal getQtAutoCicloimprodutivo() {
        return qtAutoCicloimprodutivo;
    }


    /**
     * Sets the qtAutoCicloimprodutivo value for this DwConsolmo.
     * 
     * @param qtAutoCicloimprodutivo
     */
    public void setQtAutoCicloimprodutivo(java.math.BigDecimal qtAutoCicloimprodutivo) {
        this.qtAutoCicloimprodutivo = qtAutoCicloimprodutivo;
    }


    /**
     * Gets the qtAutoCicloprodutivo value for this DwConsolmo.
     * 
     * @return qtAutoCicloprodutivo
     */
    public java.math.BigDecimal getQtAutoCicloprodutivo() {
        return qtAutoCicloprodutivo;
    }


    /**
     * Sets the qtAutoCicloprodutivo value for this DwConsolmo.
     * 
     * @param qtAutoCicloprodutivo
     */
    public void setQtAutoCicloprodutivo(java.math.BigDecimal qtAutoCicloprodutivo) {
        this.qtAutoCicloprodutivo = qtAutoCicloprodutivo;
    }


    /**
     * Gets the qtAutoCicloregulagem value for this DwConsolmo.
     * 
     * @return qtAutoCicloregulagem
     */
    public java.math.BigDecimal getQtAutoCicloregulagem() {
        return qtAutoCicloregulagem;
    }


    /**
     * Sets the qtAutoCicloregulagem value for this DwConsolmo.
     * 
     * @param qtAutoCicloregulagem
     */
    public void setQtAutoCicloregulagem(java.math.BigDecimal qtAutoCicloregulagem) {
        this.qtAutoCicloregulagem = qtAutoCicloregulagem;
    }


    /**
     * Gets the qtAutoOcoparadaCpVr value for this DwConsolmo.
     * 
     * @return qtAutoOcoparadaCpVr
     */
    public java.math.BigDecimal getQtAutoOcoparadaCpVr() {
        return qtAutoOcoparadaCpVr;
    }


    /**
     * Sets the qtAutoOcoparadaCpVr value for this DwConsolmo.
     * 
     * @param qtAutoOcoparadaCpVr
     */
    public void setQtAutoOcoparadaCpVr(java.math.BigDecimal qtAutoOcoparadaCpVr) {
        this.qtAutoOcoparadaCpVr = qtAutoOcoparadaCpVr;
    }


    /**
     * Gets the qtAutoOcoparadaSpVr value for this DwConsolmo.
     * 
     * @return qtAutoOcoparadaSpVr
     */
    public java.math.BigDecimal getQtAutoOcoparadaSpVr() {
        return qtAutoOcoparadaSpVr;
    }


    /**
     * Sets the qtAutoOcoparadaSpVr value for this DwConsolmo.
     * 
     * @param qtAutoOcoparadaSpVr
     */
    public void setQtAutoOcoparadaSpVr(java.math.BigDecimal qtAutoOcoparadaSpVr) {
        this.qtAutoOcoparadaSpVr = qtAutoOcoparadaSpVr;
    }


    /**
     * Gets the qtAutoTempoparadaDefault value for this DwConsolmo.
     * 
     * @return qtAutoTempoparadaDefault
     */
    public java.math.BigDecimal getQtAutoTempoparadaDefault() {
        return qtAutoTempoparadaDefault;
    }


    /**
     * Sets the qtAutoTempoparadaDefault value for this DwConsolmo.
     * 
     * @param qtAutoTempoparadaDefault
     */
    public void setQtAutoTempoparadaDefault(java.math.BigDecimal qtAutoTempoparadaDefault) {
        this.qtAutoTempoparadaDefault = qtAutoTempoparadaDefault;
    }


    /**
     * Gets the qtAutoTempoparadaSemCnx value for this DwConsolmo.
     * 
     * @return qtAutoTempoparadaSemCnx
     */
    public java.math.BigDecimal getQtAutoTempoparadaSemCnx() {
        return qtAutoTempoparadaSemCnx;
    }


    /**
     * Sets the qtAutoTempoparadaSemCnx value for this DwConsolmo.
     * 
     * @param qtAutoTempoparadaSemCnx
     */
    public void setQtAutoTempoparadaSemCnx(java.math.BigDecimal qtAutoTempoparadaSemCnx) {
        this.qtAutoTempoparadaSemCnx = qtAutoTempoparadaSemCnx;
    }


    /**
     * Gets the qtAutoTempoparadaSemEvt value for this DwConsolmo.
     * 
     * @return qtAutoTempoparadaSemEvt
     */
    public java.math.BigDecimal getQtAutoTempoparadaSemEvt() {
        return qtAutoTempoparadaSemEvt;
    }


    /**
     * Sets the qtAutoTempoparadaSemEvt value for this DwConsolmo.
     * 
     * @param qtAutoTempoparadaSemEvt
     */
    public void setQtAutoTempoparadaSemEvt(java.math.BigDecimal qtAutoTempoparadaSemEvt) {
        this.qtAutoTempoparadaSemEvt = qtAutoTempoparadaSemEvt;
    }


    /**
     * Gets the qtAutoTempoparadaSemOp value for this DwConsolmo.
     * 
     * @return qtAutoTempoparadaSemOp
     */
    public java.math.BigDecimal getQtAutoTempoparadaSemOp() {
        return qtAutoTempoparadaSemOp;
    }


    /**
     * Sets the qtAutoTempoparadaSemOp value for this DwConsolmo.
     * 
     * @param qtAutoTempoparadaSemOp
     */
    public void setQtAutoTempoparadaSemOp(java.math.BigDecimal qtAutoTempoparadaSemOp) {
        this.qtAutoTempoparadaSemOp = qtAutoTempoparadaSemOp;
    }


    /**
     * Gets the qtManuCicloimprodutivo value for this DwConsolmo.
     * 
     * @return qtManuCicloimprodutivo
     */
    public java.math.BigDecimal getQtManuCicloimprodutivo() {
        return qtManuCicloimprodutivo;
    }


    /**
     * Sets the qtManuCicloimprodutivo value for this DwConsolmo.
     * 
     * @param qtManuCicloimprodutivo
     */
    public void setQtManuCicloimprodutivo(java.math.BigDecimal qtManuCicloimprodutivo) {
        this.qtManuCicloimprodutivo = qtManuCicloimprodutivo;
    }


    /**
     * Gets the qtManuCicloprodutivo value for this DwConsolmo.
     * 
     * @return qtManuCicloprodutivo
     */
    public java.math.BigDecimal getQtManuCicloprodutivo() {
        return qtManuCicloprodutivo;
    }


    /**
     * Sets the qtManuCicloprodutivo value for this DwConsolmo.
     * 
     * @param qtManuCicloprodutivo
     */
    public void setQtManuCicloprodutivo(java.math.BigDecimal qtManuCicloprodutivo) {
        this.qtManuCicloprodutivo = qtManuCicloprodutivo;
    }


    /**
     * Gets the qtManuCicloregulagem value for this DwConsolmo.
     * 
     * @return qtManuCicloregulagem
     */
    public java.math.BigDecimal getQtManuCicloregulagem() {
        return qtManuCicloregulagem;
    }


    /**
     * Sets the qtManuCicloregulagem value for this DwConsolmo.
     * 
     * @param qtManuCicloregulagem
     */
    public void setQtManuCicloregulagem(java.math.BigDecimal qtManuCicloregulagem) {
        this.qtManuCicloregulagem = qtManuCicloregulagem;
    }


    /**
     * Gets the qtManuOcoparadaCpVr value for this DwConsolmo.
     * 
     * @return qtManuOcoparadaCpVr
     */
    public java.math.BigDecimal getQtManuOcoparadaCpVr() {
        return qtManuOcoparadaCpVr;
    }


    /**
     * Sets the qtManuOcoparadaCpVr value for this DwConsolmo.
     * 
     * @param qtManuOcoparadaCpVr
     */
    public void setQtManuOcoparadaCpVr(java.math.BigDecimal qtManuOcoparadaCpVr) {
        this.qtManuOcoparadaCpVr = qtManuOcoparadaCpVr;
    }


    /**
     * Gets the qtManuOcoparadaSpVr value for this DwConsolmo.
     * 
     * @return qtManuOcoparadaSpVr
     */
    public java.math.BigDecimal getQtManuOcoparadaSpVr() {
        return qtManuOcoparadaSpVr;
    }


    /**
     * Sets the qtManuOcoparadaSpVr value for this DwConsolmo.
     * 
     * @param qtManuOcoparadaSpVr
     */
    public void setQtManuOcoparadaSpVr(java.math.BigDecimal qtManuOcoparadaSpVr) {
        this.qtManuOcoparadaSpVr = qtManuOcoparadaSpVr;
    }


    /**
     * Gets the qtManuTempoparadaDefault value for this DwConsolmo.
     * 
     * @return qtManuTempoparadaDefault
     */
    public java.math.BigDecimal getQtManuTempoparadaDefault() {
        return qtManuTempoparadaDefault;
    }


    /**
     * Sets the qtManuTempoparadaDefault value for this DwConsolmo.
     * 
     * @param qtManuTempoparadaDefault
     */
    public void setQtManuTempoparadaDefault(java.math.BigDecimal qtManuTempoparadaDefault) {
        this.qtManuTempoparadaDefault = qtManuTempoparadaDefault;
    }


    /**
     * Gets the qtManuTempoparadaSemCnx value for this DwConsolmo.
     * 
     * @return qtManuTempoparadaSemCnx
     */
    public java.math.BigDecimal getQtManuTempoparadaSemCnx() {
        return qtManuTempoparadaSemCnx;
    }


    /**
     * Sets the qtManuTempoparadaSemCnx value for this DwConsolmo.
     * 
     * @param qtManuTempoparadaSemCnx
     */
    public void setQtManuTempoparadaSemCnx(java.math.BigDecimal qtManuTempoparadaSemCnx) {
        this.qtManuTempoparadaSemCnx = qtManuTempoparadaSemCnx;
    }


    /**
     * Gets the qtManuTempoparadaSemEvt value for this DwConsolmo.
     * 
     * @return qtManuTempoparadaSemEvt
     */
    public java.math.BigDecimal getQtManuTempoparadaSemEvt() {
        return qtManuTempoparadaSemEvt;
    }


    /**
     * Sets the qtManuTempoparadaSemEvt value for this DwConsolmo.
     * 
     * @param qtManuTempoparadaSemEvt
     */
    public void setQtManuTempoparadaSemEvt(java.math.BigDecimal qtManuTempoparadaSemEvt) {
        this.qtManuTempoparadaSemEvt = qtManuTempoparadaSemEvt;
    }


    /**
     * Gets the qtManuTempoparadaSemOp value for this DwConsolmo.
     * 
     * @return qtManuTempoparadaSemOp
     */
    public java.math.BigDecimal getQtManuTempoparadaSemOp() {
        return qtManuTempoparadaSemOp;
    }


    /**
     * Sets the qtManuTempoparadaSemOp value for this DwConsolmo.
     * 
     * @param qtManuTempoparadaSemOp
     */
    public void setQtManuTempoparadaSemOp(java.math.BigDecimal qtManuTempoparadaSemOp) {
        this.qtManuTempoparadaSemOp = qtManuTempoparadaSemOp;
    }


    /**
     * Gets the segAutoCicloimprodutivo value for this DwConsolmo.
     * 
     * @return segAutoCicloimprodutivo
     */
    public java.math.BigDecimal getSegAutoCicloimprodutivo() {
        return segAutoCicloimprodutivo;
    }


    /**
     * Sets the segAutoCicloimprodutivo value for this DwConsolmo.
     * 
     * @param segAutoCicloimprodutivo
     */
    public void setSegAutoCicloimprodutivo(java.math.BigDecimal segAutoCicloimprodutivo) {
        this.segAutoCicloimprodutivo = segAutoCicloimprodutivo;
    }


    /**
     * Gets the segAutoCicloimprodutivoCta value for this DwConsolmo.
     * 
     * @return segAutoCicloimprodutivoCta
     */
    public java.math.BigDecimal getSegAutoCicloimprodutivoCta() {
        return segAutoCicloimprodutivoCta;
    }


    /**
     * Sets the segAutoCicloimprodutivoCta value for this DwConsolmo.
     * 
     * @param segAutoCicloimprodutivoCta
     */
    public void setSegAutoCicloimprodutivoCta(java.math.BigDecimal segAutoCicloimprodutivoCta) {
        this.segAutoCicloimprodutivoCta = segAutoCicloimprodutivoCta;
    }


    /**
     * Gets the segAutoCicloprodutivo value for this DwConsolmo.
     * 
     * @return segAutoCicloprodutivo
     */
    public java.math.BigDecimal getSegAutoCicloprodutivo() {
        return segAutoCicloprodutivo;
    }


    /**
     * Sets the segAutoCicloprodutivo value for this DwConsolmo.
     * 
     * @param segAutoCicloprodutivo
     */
    public void setSegAutoCicloprodutivo(java.math.BigDecimal segAutoCicloprodutivo) {
        this.segAutoCicloprodutivo = segAutoCicloprodutivo;
    }


    /**
     * Gets the segAutoCicloprodutivoCta value for this DwConsolmo.
     * 
     * @return segAutoCicloprodutivoCta
     */
    public java.math.BigDecimal getSegAutoCicloprodutivoCta() {
        return segAutoCicloprodutivoCta;
    }


    /**
     * Sets the segAutoCicloprodutivoCta value for this DwConsolmo.
     * 
     * @param segAutoCicloprodutivoCta
     */
    public void setSegAutoCicloprodutivoCta(java.math.BigDecimal segAutoCicloprodutivoCta) {
        this.segAutoCicloprodutivoCta = segAutoCicloprodutivoCta;
    }


    /**
     * Gets the segAutoCicloregulagem value for this DwConsolmo.
     * 
     * @return segAutoCicloregulagem
     */
    public java.math.BigDecimal getSegAutoCicloregulagem() {
        return segAutoCicloregulagem;
    }


    /**
     * Sets the segAutoCicloregulagem value for this DwConsolmo.
     * 
     * @param segAutoCicloregulagem
     */
    public void setSegAutoCicloregulagem(java.math.BigDecimal segAutoCicloregulagem) {
        this.segAutoCicloregulagem = segAutoCicloregulagem;
    }


    /**
     * Gets the segAutoCta value for this DwConsolmo.
     * 
     * @return segAutoCta
     */
    public java.math.BigDecimal getSegAutoCta() {
        return segAutoCta;
    }


    /**
     * Sets the segAutoCta value for this DwConsolmo.
     * 
     * @param segAutoCta
     */
    public void setSegAutoCta(java.math.BigDecimal segAutoCta) {
        this.segAutoCta = segAutoCta;
    }


    /**
     * Gets the segAutoTempologin value for this DwConsolmo.
     * 
     * @return segAutoTempologin
     */
    public java.math.BigDecimal getSegAutoTempologin() {
        return segAutoTempologin;
    }


    /**
     * Sets the segAutoTempologin value for this DwConsolmo.
     * 
     * @param segAutoTempologin
     */
    public void setSegAutoTempologin(java.math.BigDecimal segAutoTempologin) {
        this.segAutoTempologin = segAutoTempologin;
    }


    /**
     * Gets the segAutoTempoparadaCp value for this DwConsolmo.
     * 
     * @return segAutoTempoparadaCp
     */
    public java.math.BigDecimal getSegAutoTempoparadaCp() {
        return segAutoTempoparadaCp;
    }


    /**
     * Sets the segAutoTempoparadaCp value for this DwConsolmo.
     * 
     * @param segAutoTempoparadaCp
     */
    public void setSegAutoTempoparadaCp(java.math.BigDecimal segAutoTempoparadaCp) {
        this.segAutoTempoparadaCp = segAutoTempoparadaCp;
    }


    /**
     * Gets the segAutoTempoparadaCpVr value for this DwConsolmo.
     * 
     * @return segAutoTempoparadaCpVr
     */
    public java.math.BigDecimal getSegAutoTempoparadaCpVr() {
        return segAutoTempoparadaCpVr;
    }


    /**
     * Sets the segAutoTempoparadaCpVr value for this DwConsolmo.
     * 
     * @param segAutoTempoparadaCpVr
     */
    public void setSegAutoTempoparadaCpVr(java.math.BigDecimal segAutoTempoparadaCpVr) {
        this.segAutoTempoparadaCpVr = segAutoTempoparadaCpVr;
    }


    /**
     * Gets the segAutoTempoparadaDefault value for this DwConsolmo.
     * 
     * @return segAutoTempoparadaDefault
     */
    public java.math.BigDecimal getSegAutoTempoparadaDefault() {
        return segAutoTempoparadaDefault;
    }


    /**
     * Sets the segAutoTempoparadaDefault value for this DwConsolmo.
     * 
     * @param segAutoTempoparadaDefault
     */
    public void setSegAutoTempoparadaDefault(java.math.BigDecimal segAutoTempoparadaDefault) {
        this.segAutoTempoparadaDefault = segAutoTempoparadaDefault;
    }


    /**
     * Gets the segAutoTempoparadaSemCnx value for this DwConsolmo.
     * 
     * @return segAutoTempoparadaSemCnx
     */
    public java.math.BigDecimal getSegAutoTempoparadaSemCnx() {
        return segAutoTempoparadaSemCnx;
    }


    /**
     * Sets the segAutoTempoparadaSemCnx value for this DwConsolmo.
     * 
     * @param segAutoTempoparadaSemCnx
     */
    public void setSegAutoTempoparadaSemCnx(java.math.BigDecimal segAutoTempoparadaSemCnx) {
        this.segAutoTempoparadaSemCnx = segAutoTempoparadaSemCnx;
    }


    /**
     * Gets the segAutoTempoparadaSemEvt value for this DwConsolmo.
     * 
     * @return segAutoTempoparadaSemEvt
     */
    public java.math.BigDecimal getSegAutoTempoparadaSemEvt() {
        return segAutoTempoparadaSemEvt;
    }


    /**
     * Sets the segAutoTempoparadaSemEvt value for this DwConsolmo.
     * 
     * @param segAutoTempoparadaSemEvt
     */
    public void setSegAutoTempoparadaSemEvt(java.math.BigDecimal segAutoTempoparadaSemEvt) {
        this.segAutoTempoparadaSemEvt = segAutoTempoparadaSemEvt;
    }


    /**
     * Gets the segAutoTempoparadaSemOp value for this DwConsolmo.
     * 
     * @return segAutoTempoparadaSemOp
     */
    public java.math.BigDecimal getSegAutoTempoparadaSemOp() {
        return segAutoTempoparadaSemOp;
    }


    /**
     * Sets the segAutoTempoparadaSemOp value for this DwConsolmo.
     * 
     * @param segAutoTempoparadaSemOp
     */
    public void setSegAutoTempoparadaSemOp(java.math.BigDecimal segAutoTempoparadaSemOp) {
        this.segAutoTempoparadaSemOp = segAutoTempoparadaSemOp;
    }


    /**
     * Gets the segAutoTempoparadaSp value for this DwConsolmo.
     * 
     * @return segAutoTempoparadaSp
     */
    public java.math.BigDecimal getSegAutoTempoparadaSp() {
        return segAutoTempoparadaSp;
    }


    /**
     * Sets the segAutoTempoparadaSp value for this DwConsolmo.
     * 
     * @param segAutoTempoparadaSp
     */
    public void setSegAutoTempoparadaSp(java.math.BigDecimal segAutoTempoparadaSp) {
        this.segAutoTempoparadaSp = segAutoTempoparadaSp;
    }


    /**
     * Gets the segAutoTempoparadaSpVr value for this DwConsolmo.
     * 
     * @return segAutoTempoparadaSpVr
     */
    public java.math.BigDecimal getSegAutoTempoparadaSpVr() {
        return segAutoTempoparadaSpVr;
    }


    /**
     * Sets the segAutoTempoparadaSpVr value for this DwConsolmo.
     * 
     * @param segAutoTempoparadaSpVr
     */
    public void setSegAutoTempoparadaSpVr(java.math.BigDecimal segAutoTempoparadaSpVr) {
        this.segAutoTempoparadaSpVr = segAutoTempoparadaSpVr;
    }


    /**
     * Gets the segAutoTempotrabalhado value for this DwConsolmo.
     * 
     * @return segAutoTempotrabalhado
     */
    public java.math.BigDecimal getSegAutoTempotrabalhado() {
        return segAutoTempotrabalhado;
    }


    /**
     * Sets the segAutoTempotrabalhado value for this DwConsolmo.
     * 
     * @param segAutoTempotrabalhado
     */
    public void setSegAutoTempotrabalhado(java.math.BigDecimal segAutoTempotrabalhado) {
        this.segAutoTempotrabalhado = segAutoTempotrabalhado;
    }


    /**
     * Gets the segManuCicloimprodutivo value for this DwConsolmo.
     * 
     * @return segManuCicloimprodutivo
     */
    public java.math.BigDecimal getSegManuCicloimprodutivo() {
        return segManuCicloimprodutivo;
    }


    /**
     * Sets the segManuCicloimprodutivo value for this DwConsolmo.
     * 
     * @param segManuCicloimprodutivo
     */
    public void setSegManuCicloimprodutivo(java.math.BigDecimal segManuCicloimprodutivo) {
        this.segManuCicloimprodutivo = segManuCicloimprodutivo;
    }


    /**
     * Gets the segManuCicloimprodutivoCta value for this DwConsolmo.
     * 
     * @return segManuCicloimprodutivoCta
     */
    public java.math.BigDecimal getSegManuCicloimprodutivoCta() {
        return segManuCicloimprodutivoCta;
    }


    /**
     * Sets the segManuCicloimprodutivoCta value for this DwConsolmo.
     * 
     * @param segManuCicloimprodutivoCta
     */
    public void setSegManuCicloimprodutivoCta(java.math.BigDecimal segManuCicloimprodutivoCta) {
        this.segManuCicloimprodutivoCta = segManuCicloimprodutivoCta;
    }


    /**
     * Gets the segManuCicloprodutivo value for this DwConsolmo.
     * 
     * @return segManuCicloprodutivo
     */
    public java.math.BigDecimal getSegManuCicloprodutivo() {
        return segManuCicloprodutivo;
    }


    /**
     * Sets the segManuCicloprodutivo value for this DwConsolmo.
     * 
     * @param segManuCicloprodutivo
     */
    public void setSegManuCicloprodutivo(java.math.BigDecimal segManuCicloprodutivo) {
        this.segManuCicloprodutivo = segManuCicloprodutivo;
    }


    /**
     * Gets the segManuCicloprodutivoCta value for this DwConsolmo.
     * 
     * @return segManuCicloprodutivoCta
     */
    public java.math.BigDecimal getSegManuCicloprodutivoCta() {
        return segManuCicloprodutivoCta;
    }


    /**
     * Sets the segManuCicloprodutivoCta value for this DwConsolmo.
     * 
     * @param segManuCicloprodutivoCta
     */
    public void setSegManuCicloprodutivoCta(java.math.BigDecimal segManuCicloprodutivoCta) {
        this.segManuCicloprodutivoCta = segManuCicloprodutivoCta;
    }


    /**
     * Gets the segManuCicloregulagem value for this DwConsolmo.
     * 
     * @return segManuCicloregulagem
     */
    public java.math.BigDecimal getSegManuCicloregulagem() {
        return segManuCicloregulagem;
    }


    /**
     * Sets the segManuCicloregulagem value for this DwConsolmo.
     * 
     * @param segManuCicloregulagem
     */
    public void setSegManuCicloregulagem(java.math.BigDecimal segManuCicloregulagem) {
        this.segManuCicloregulagem = segManuCicloregulagem;
    }


    /**
     * Gets the segManuCta value for this DwConsolmo.
     * 
     * @return segManuCta
     */
    public java.math.BigDecimal getSegManuCta() {
        return segManuCta;
    }


    /**
     * Sets the segManuCta value for this DwConsolmo.
     * 
     * @param segManuCta
     */
    public void setSegManuCta(java.math.BigDecimal segManuCta) {
        this.segManuCta = segManuCta;
    }


    /**
     * Gets the segManuTempologin value for this DwConsolmo.
     * 
     * @return segManuTempologin
     */
    public java.math.BigDecimal getSegManuTempologin() {
        return segManuTempologin;
    }


    /**
     * Sets the segManuTempologin value for this DwConsolmo.
     * 
     * @param segManuTempologin
     */
    public void setSegManuTempologin(java.math.BigDecimal segManuTempologin) {
        this.segManuTempologin = segManuTempologin;
    }


    /**
     * Gets the segManuTempoparadaCp value for this DwConsolmo.
     * 
     * @return segManuTempoparadaCp
     */
    public java.math.BigDecimal getSegManuTempoparadaCp() {
        return segManuTempoparadaCp;
    }


    /**
     * Sets the segManuTempoparadaCp value for this DwConsolmo.
     * 
     * @param segManuTempoparadaCp
     */
    public void setSegManuTempoparadaCp(java.math.BigDecimal segManuTempoparadaCp) {
        this.segManuTempoparadaCp = segManuTempoparadaCp;
    }


    /**
     * Gets the segManuTempoparadaCpVr value for this DwConsolmo.
     * 
     * @return segManuTempoparadaCpVr
     */
    public java.math.BigDecimal getSegManuTempoparadaCpVr() {
        return segManuTempoparadaCpVr;
    }


    /**
     * Sets the segManuTempoparadaCpVr value for this DwConsolmo.
     * 
     * @param segManuTempoparadaCpVr
     */
    public void setSegManuTempoparadaCpVr(java.math.BigDecimal segManuTempoparadaCpVr) {
        this.segManuTempoparadaCpVr = segManuTempoparadaCpVr;
    }


    /**
     * Gets the segManuTempoparadaDefault value for this DwConsolmo.
     * 
     * @return segManuTempoparadaDefault
     */
    public java.math.BigDecimal getSegManuTempoparadaDefault() {
        return segManuTempoparadaDefault;
    }


    /**
     * Sets the segManuTempoparadaDefault value for this DwConsolmo.
     * 
     * @param segManuTempoparadaDefault
     */
    public void setSegManuTempoparadaDefault(java.math.BigDecimal segManuTempoparadaDefault) {
        this.segManuTempoparadaDefault = segManuTempoparadaDefault;
    }


    /**
     * Gets the segManuTempoparadaSemCnx value for this DwConsolmo.
     * 
     * @return segManuTempoparadaSemCnx
     */
    public java.math.BigDecimal getSegManuTempoparadaSemCnx() {
        return segManuTempoparadaSemCnx;
    }


    /**
     * Sets the segManuTempoparadaSemCnx value for this DwConsolmo.
     * 
     * @param segManuTempoparadaSemCnx
     */
    public void setSegManuTempoparadaSemCnx(java.math.BigDecimal segManuTempoparadaSemCnx) {
        this.segManuTempoparadaSemCnx = segManuTempoparadaSemCnx;
    }


    /**
     * Gets the segManuTempoparadaSemEvt value for this DwConsolmo.
     * 
     * @return segManuTempoparadaSemEvt
     */
    public java.math.BigDecimal getSegManuTempoparadaSemEvt() {
        return segManuTempoparadaSemEvt;
    }


    /**
     * Sets the segManuTempoparadaSemEvt value for this DwConsolmo.
     * 
     * @param segManuTempoparadaSemEvt
     */
    public void setSegManuTempoparadaSemEvt(java.math.BigDecimal segManuTempoparadaSemEvt) {
        this.segManuTempoparadaSemEvt = segManuTempoparadaSemEvt;
    }


    /**
     * Gets the segManuTempoparadaSemOp value for this DwConsolmo.
     * 
     * @return segManuTempoparadaSemOp
     */
    public java.math.BigDecimal getSegManuTempoparadaSemOp() {
        return segManuTempoparadaSemOp;
    }


    /**
     * Sets the segManuTempoparadaSemOp value for this DwConsolmo.
     * 
     * @param segManuTempoparadaSemOp
     */
    public void setSegManuTempoparadaSemOp(java.math.BigDecimal segManuTempoparadaSemOp) {
        this.segManuTempoparadaSemOp = segManuTempoparadaSemOp;
    }


    /**
     * Gets the segManuTempoparadaSp value for this DwConsolmo.
     * 
     * @return segManuTempoparadaSp
     */
    public java.math.BigDecimal getSegManuTempoparadaSp() {
        return segManuTempoparadaSp;
    }


    /**
     * Sets the segManuTempoparadaSp value for this DwConsolmo.
     * 
     * @param segManuTempoparadaSp
     */
    public void setSegManuTempoparadaSp(java.math.BigDecimal segManuTempoparadaSp) {
        this.segManuTempoparadaSp = segManuTempoparadaSp;
    }


    /**
     * Gets the segManuTempoparadaSpVr value for this DwConsolmo.
     * 
     * @return segManuTempoparadaSpVr
     */
    public java.math.BigDecimal getSegManuTempoparadaSpVr() {
        return segManuTempoparadaSpVr;
    }


    /**
     * Sets the segManuTempoparadaSpVr value for this DwConsolmo.
     * 
     * @param segManuTempoparadaSpVr
     */
    public void setSegManuTempoparadaSpVr(java.math.BigDecimal segManuTempoparadaSpVr) {
        this.segManuTempoparadaSpVr = segManuTempoparadaSpVr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolmo)) return false;
        DwConsolmo other = (DwConsolmo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dwConsol==null && other.getDwConsol()==null) || 
             (this.dwConsol!=null &&
              this.dwConsol.equals(other.getDwConsol()))) &&
            ((this.dwConsolalmos==null && other.getDwConsolalmos()==null) || 
             (this.dwConsolalmos!=null &&
              java.util.Arrays.equals(this.dwConsolalmos, other.getDwConsolalmos()))) &&
            ((this.dwConsolmoocos==null && other.getDwConsolmoocos()==null) || 
             (this.dwConsolmoocos!=null &&
              java.util.Arrays.equals(this.dwConsolmoocos, other.getDwConsolmoocos()))) &&
            ((this.dwConsolpamos==null && other.getDwConsolpamos()==null) || 
             (this.dwConsolpamos!=null &&
              java.util.Arrays.equals(this.dwConsolpamos, other.getDwConsolpamos()))) &&
            ((this.dwConsolprmos==null && other.getDwConsolprmos()==null) || 
             (this.dwConsolprmos!=null &&
              java.util.Arrays.equals(this.dwConsolprmos, other.getDwConsolprmos()))) &&
            ((this.dwConsolremos==null && other.getDwConsolremos()==null) || 
             (this.dwConsolremos!=null &&
              java.util.Arrays.equals(this.dwConsolremos, other.getDwConsolremos()))) &&
            this.idConsolmo == other.getIdConsolmo() &&
            ((this.omUsr==null && other.getOmUsr()==null) || 
             (this.omUsr!=null &&
              this.omUsr.equals(other.getOmUsr()))) &&
            ((this.pcsAutoPerda==null && other.getPcsAutoPerda()==null) || 
             (this.pcsAutoPerda!=null &&
              this.pcsAutoPerda.equals(other.getPcsAutoPerda()))) &&
            ((this.pcsAutoProducaobruta==null && other.getPcsAutoProducaobruta()==null) || 
             (this.pcsAutoProducaobruta!=null &&
              this.pcsAutoProducaobruta.equals(other.getPcsAutoProducaobruta()))) &&
            ((this.pcsAutoProducaoprevista==null && other.getPcsAutoProducaoprevista()==null) || 
             (this.pcsAutoProducaoprevista!=null &&
              this.pcsAutoProducaoprevista.equals(other.getPcsAutoProducaoprevista()))) &&
            ((this.pcsAutoProducaorefugada==null && other.getPcsAutoProducaorefugada()==null) || 
             (this.pcsAutoProducaorefugada!=null &&
              this.pcsAutoProducaorefugada.equals(other.getPcsAutoProducaorefugada()))) &&
            ((this.pcsManuProducaobruta==null && other.getPcsManuProducaobruta()==null) || 
             (this.pcsManuProducaobruta!=null &&
              this.pcsManuProducaobruta.equals(other.getPcsManuProducaobruta()))) &&
            ((this.pcsManuProducaoprevista==null && other.getPcsManuProducaoprevista()==null) || 
             (this.pcsManuProducaoprevista!=null &&
              this.pcsManuProducaoprevista.equals(other.getPcsManuProducaoprevista()))) &&
            ((this.pcsManuProducaorefugada==null && other.getPcsManuProducaorefugada()==null) || 
             (this.pcsManuProducaorefugada!=null &&
              this.pcsManuProducaorefugada.equals(other.getPcsManuProducaorefugada()))) &&
            ((this.qtAutoCicloimprodutivo==null && other.getQtAutoCicloimprodutivo()==null) || 
             (this.qtAutoCicloimprodutivo!=null &&
              this.qtAutoCicloimprodutivo.equals(other.getQtAutoCicloimprodutivo()))) &&
            ((this.qtAutoCicloprodutivo==null && other.getQtAutoCicloprodutivo()==null) || 
             (this.qtAutoCicloprodutivo!=null &&
              this.qtAutoCicloprodutivo.equals(other.getQtAutoCicloprodutivo()))) &&
            ((this.qtAutoCicloregulagem==null && other.getQtAutoCicloregulagem()==null) || 
             (this.qtAutoCicloregulagem!=null &&
              this.qtAutoCicloregulagem.equals(other.getQtAutoCicloregulagem()))) &&
            ((this.qtAutoOcoparadaCpVr==null && other.getQtAutoOcoparadaCpVr()==null) || 
             (this.qtAutoOcoparadaCpVr!=null &&
              this.qtAutoOcoparadaCpVr.equals(other.getQtAutoOcoparadaCpVr()))) &&
            ((this.qtAutoOcoparadaSpVr==null && other.getQtAutoOcoparadaSpVr()==null) || 
             (this.qtAutoOcoparadaSpVr!=null &&
              this.qtAutoOcoparadaSpVr.equals(other.getQtAutoOcoparadaSpVr()))) &&
            ((this.qtAutoTempoparadaDefault==null && other.getQtAutoTempoparadaDefault()==null) || 
             (this.qtAutoTempoparadaDefault!=null &&
              this.qtAutoTempoparadaDefault.equals(other.getQtAutoTempoparadaDefault()))) &&
            ((this.qtAutoTempoparadaSemCnx==null && other.getQtAutoTempoparadaSemCnx()==null) || 
             (this.qtAutoTempoparadaSemCnx!=null &&
              this.qtAutoTempoparadaSemCnx.equals(other.getQtAutoTempoparadaSemCnx()))) &&
            ((this.qtAutoTempoparadaSemEvt==null && other.getQtAutoTempoparadaSemEvt()==null) || 
             (this.qtAutoTempoparadaSemEvt!=null &&
              this.qtAutoTempoparadaSemEvt.equals(other.getQtAutoTempoparadaSemEvt()))) &&
            ((this.qtAutoTempoparadaSemOp==null && other.getQtAutoTempoparadaSemOp()==null) || 
             (this.qtAutoTempoparadaSemOp!=null &&
              this.qtAutoTempoparadaSemOp.equals(other.getQtAutoTempoparadaSemOp()))) &&
            ((this.qtManuCicloimprodutivo==null && other.getQtManuCicloimprodutivo()==null) || 
             (this.qtManuCicloimprodutivo!=null &&
              this.qtManuCicloimprodutivo.equals(other.getQtManuCicloimprodutivo()))) &&
            ((this.qtManuCicloprodutivo==null && other.getQtManuCicloprodutivo()==null) || 
             (this.qtManuCicloprodutivo!=null &&
              this.qtManuCicloprodutivo.equals(other.getQtManuCicloprodutivo()))) &&
            ((this.qtManuCicloregulagem==null && other.getQtManuCicloregulagem()==null) || 
             (this.qtManuCicloregulagem!=null &&
              this.qtManuCicloregulagem.equals(other.getQtManuCicloregulagem()))) &&
            ((this.qtManuOcoparadaCpVr==null && other.getQtManuOcoparadaCpVr()==null) || 
             (this.qtManuOcoparadaCpVr!=null &&
              this.qtManuOcoparadaCpVr.equals(other.getQtManuOcoparadaCpVr()))) &&
            ((this.qtManuOcoparadaSpVr==null && other.getQtManuOcoparadaSpVr()==null) || 
             (this.qtManuOcoparadaSpVr!=null &&
              this.qtManuOcoparadaSpVr.equals(other.getQtManuOcoparadaSpVr()))) &&
            ((this.qtManuTempoparadaDefault==null && other.getQtManuTempoparadaDefault()==null) || 
             (this.qtManuTempoparadaDefault!=null &&
              this.qtManuTempoparadaDefault.equals(other.getQtManuTempoparadaDefault()))) &&
            ((this.qtManuTempoparadaSemCnx==null && other.getQtManuTempoparadaSemCnx()==null) || 
             (this.qtManuTempoparadaSemCnx!=null &&
              this.qtManuTempoparadaSemCnx.equals(other.getQtManuTempoparadaSemCnx()))) &&
            ((this.qtManuTempoparadaSemEvt==null && other.getQtManuTempoparadaSemEvt()==null) || 
             (this.qtManuTempoparadaSemEvt!=null &&
              this.qtManuTempoparadaSemEvt.equals(other.getQtManuTempoparadaSemEvt()))) &&
            ((this.qtManuTempoparadaSemOp==null && other.getQtManuTempoparadaSemOp()==null) || 
             (this.qtManuTempoparadaSemOp!=null &&
              this.qtManuTempoparadaSemOp.equals(other.getQtManuTempoparadaSemOp()))) &&
            ((this.segAutoCicloimprodutivo==null && other.getSegAutoCicloimprodutivo()==null) || 
             (this.segAutoCicloimprodutivo!=null &&
              this.segAutoCicloimprodutivo.equals(other.getSegAutoCicloimprodutivo()))) &&
            ((this.segAutoCicloimprodutivoCta==null && other.getSegAutoCicloimprodutivoCta()==null) || 
             (this.segAutoCicloimprodutivoCta!=null &&
              this.segAutoCicloimprodutivoCta.equals(other.getSegAutoCicloimprodutivoCta()))) &&
            ((this.segAutoCicloprodutivo==null && other.getSegAutoCicloprodutivo()==null) || 
             (this.segAutoCicloprodutivo!=null &&
              this.segAutoCicloprodutivo.equals(other.getSegAutoCicloprodutivo()))) &&
            ((this.segAutoCicloprodutivoCta==null && other.getSegAutoCicloprodutivoCta()==null) || 
             (this.segAutoCicloprodutivoCta!=null &&
              this.segAutoCicloprodutivoCta.equals(other.getSegAutoCicloprodutivoCta()))) &&
            ((this.segAutoCicloregulagem==null && other.getSegAutoCicloregulagem()==null) || 
             (this.segAutoCicloregulagem!=null &&
              this.segAutoCicloregulagem.equals(other.getSegAutoCicloregulagem()))) &&
            ((this.segAutoCta==null && other.getSegAutoCta()==null) || 
             (this.segAutoCta!=null &&
              this.segAutoCta.equals(other.getSegAutoCta()))) &&
            ((this.segAutoTempologin==null && other.getSegAutoTempologin()==null) || 
             (this.segAutoTempologin!=null &&
              this.segAutoTempologin.equals(other.getSegAutoTempologin()))) &&
            ((this.segAutoTempoparadaCp==null && other.getSegAutoTempoparadaCp()==null) || 
             (this.segAutoTempoparadaCp!=null &&
              this.segAutoTempoparadaCp.equals(other.getSegAutoTempoparadaCp()))) &&
            ((this.segAutoTempoparadaCpVr==null && other.getSegAutoTempoparadaCpVr()==null) || 
             (this.segAutoTempoparadaCpVr!=null &&
              this.segAutoTempoparadaCpVr.equals(other.getSegAutoTempoparadaCpVr()))) &&
            ((this.segAutoTempoparadaDefault==null && other.getSegAutoTempoparadaDefault()==null) || 
             (this.segAutoTempoparadaDefault!=null &&
              this.segAutoTempoparadaDefault.equals(other.getSegAutoTempoparadaDefault()))) &&
            ((this.segAutoTempoparadaSemCnx==null && other.getSegAutoTempoparadaSemCnx()==null) || 
             (this.segAutoTempoparadaSemCnx!=null &&
              this.segAutoTempoparadaSemCnx.equals(other.getSegAutoTempoparadaSemCnx()))) &&
            ((this.segAutoTempoparadaSemEvt==null && other.getSegAutoTempoparadaSemEvt()==null) || 
             (this.segAutoTempoparadaSemEvt!=null &&
              this.segAutoTempoparadaSemEvt.equals(other.getSegAutoTempoparadaSemEvt()))) &&
            ((this.segAutoTempoparadaSemOp==null && other.getSegAutoTempoparadaSemOp()==null) || 
             (this.segAutoTempoparadaSemOp!=null &&
              this.segAutoTempoparadaSemOp.equals(other.getSegAutoTempoparadaSemOp()))) &&
            ((this.segAutoTempoparadaSp==null && other.getSegAutoTempoparadaSp()==null) || 
             (this.segAutoTempoparadaSp!=null &&
              this.segAutoTempoparadaSp.equals(other.getSegAutoTempoparadaSp()))) &&
            ((this.segAutoTempoparadaSpVr==null && other.getSegAutoTempoparadaSpVr()==null) || 
             (this.segAutoTempoparadaSpVr!=null &&
              this.segAutoTempoparadaSpVr.equals(other.getSegAutoTempoparadaSpVr()))) &&
            ((this.segAutoTempotrabalhado==null && other.getSegAutoTempotrabalhado()==null) || 
             (this.segAutoTempotrabalhado!=null &&
              this.segAutoTempotrabalhado.equals(other.getSegAutoTempotrabalhado()))) &&
            ((this.segManuCicloimprodutivo==null && other.getSegManuCicloimprodutivo()==null) || 
             (this.segManuCicloimprodutivo!=null &&
              this.segManuCicloimprodutivo.equals(other.getSegManuCicloimprodutivo()))) &&
            ((this.segManuCicloimprodutivoCta==null && other.getSegManuCicloimprodutivoCta()==null) || 
             (this.segManuCicloimprodutivoCta!=null &&
              this.segManuCicloimprodutivoCta.equals(other.getSegManuCicloimprodutivoCta()))) &&
            ((this.segManuCicloprodutivo==null && other.getSegManuCicloprodutivo()==null) || 
             (this.segManuCicloprodutivo!=null &&
              this.segManuCicloprodutivo.equals(other.getSegManuCicloprodutivo()))) &&
            ((this.segManuCicloprodutivoCta==null && other.getSegManuCicloprodutivoCta()==null) || 
             (this.segManuCicloprodutivoCta!=null &&
              this.segManuCicloprodutivoCta.equals(other.getSegManuCicloprodutivoCta()))) &&
            ((this.segManuCicloregulagem==null && other.getSegManuCicloregulagem()==null) || 
             (this.segManuCicloregulagem!=null &&
              this.segManuCicloregulagem.equals(other.getSegManuCicloregulagem()))) &&
            ((this.segManuCta==null && other.getSegManuCta()==null) || 
             (this.segManuCta!=null &&
              this.segManuCta.equals(other.getSegManuCta()))) &&
            ((this.segManuTempologin==null && other.getSegManuTempologin()==null) || 
             (this.segManuTempologin!=null &&
              this.segManuTempologin.equals(other.getSegManuTempologin()))) &&
            ((this.segManuTempoparadaCp==null && other.getSegManuTempoparadaCp()==null) || 
             (this.segManuTempoparadaCp!=null &&
              this.segManuTempoparadaCp.equals(other.getSegManuTempoparadaCp()))) &&
            ((this.segManuTempoparadaCpVr==null && other.getSegManuTempoparadaCpVr()==null) || 
             (this.segManuTempoparadaCpVr!=null &&
              this.segManuTempoparadaCpVr.equals(other.getSegManuTempoparadaCpVr()))) &&
            ((this.segManuTempoparadaDefault==null && other.getSegManuTempoparadaDefault()==null) || 
             (this.segManuTempoparadaDefault!=null &&
              this.segManuTempoparadaDefault.equals(other.getSegManuTempoparadaDefault()))) &&
            ((this.segManuTempoparadaSemCnx==null && other.getSegManuTempoparadaSemCnx()==null) || 
             (this.segManuTempoparadaSemCnx!=null &&
              this.segManuTempoparadaSemCnx.equals(other.getSegManuTempoparadaSemCnx()))) &&
            ((this.segManuTempoparadaSemEvt==null && other.getSegManuTempoparadaSemEvt()==null) || 
             (this.segManuTempoparadaSemEvt!=null &&
              this.segManuTempoparadaSemEvt.equals(other.getSegManuTempoparadaSemEvt()))) &&
            ((this.segManuTempoparadaSemOp==null && other.getSegManuTempoparadaSemOp()==null) || 
             (this.segManuTempoparadaSemOp!=null &&
              this.segManuTempoparadaSemOp.equals(other.getSegManuTempoparadaSemOp()))) &&
            ((this.segManuTempoparadaSp==null && other.getSegManuTempoparadaSp()==null) || 
             (this.segManuTempoparadaSp!=null &&
              this.segManuTempoparadaSp.equals(other.getSegManuTempoparadaSp()))) &&
            ((this.segManuTempoparadaSpVr==null && other.getSegManuTempoparadaSpVr()==null) || 
             (this.segManuTempoparadaSpVr!=null &&
              this.segManuTempoparadaSpVr.equals(other.getSegManuTempoparadaSpVr())));
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
        if (getDwConsol() != null) {
            _hashCode += getDwConsol().hashCode();
        }
        if (getDwConsolalmos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolalmos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolalmos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolmoocos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolmoocos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolmoocos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolpamos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolpamos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolpamos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolprmos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolprmos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolprmos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolremos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolremos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolremos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdConsolmo()).hashCode();
        if (getOmUsr() != null) {
            _hashCode += getOmUsr().hashCode();
        }
        if (getPcsAutoPerda() != null) {
            _hashCode += getPcsAutoPerda().hashCode();
        }
        if (getPcsAutoProducaobruta() != null) {
            _hashCode += getPcsAutoProducaobruta().hashCode();
        }
        if (getPcsAutoProducaoprevista() != null) {
            _hashCode += getPcsAutoProducaoprevista().hashCode();
        }
        if (getPcsAutoProducaorefugada() != null) {
            _hashCode += getPcsAutoProducaorefugada().hashCode();
        }
        if (getPcsManuProducaobruta() != null) {
            _hashCode += getPcsManuProducaobruta().hashCode();
        }
        if (getPcsManuProducaoprevista() != null) {
            _hashCode += getPcsManuProducaoprevista().hashCode();
        }
        if (getPcsManuProducaorefugada() != null) {
            _hashCode += getPcsManuProducaorefugada().hashCode();
        }
        if (getQtAutoCicloimprodutivo() != null) {
            _hashCode += getQtAutoCicloimprodutivo().hashCode();
        }
        if (getQtAutoCicloprodutivo() != null) {
            _hashCode += getQtAutoCicloprodutivo().hashCode();
        }
        if (getQtAutoCicloregulagem() != null) {
            _hashCode += getQtAutoCicloregulagem().hashCode();
        }
        if (getQtAutoOcoparadaCpVr() != null) {
            _hashCode += getQtAutoOcoparadaCpVr().hashCode();
        }
        if (getQtAutoOcoparadaSpVr() != null) {
            _hashCode += getQtAutoOcoparadaSpVr().hashCode();
        }
        if (getQtAutoTempoparadaDefault() != null) {
            _hashCode += getQtAutoTempoparadaDefault().hashCode();
        }
        if (getQtAutoTempoparadaSemCnx() != null) {
            _hashCode += getQtAutoTempoparadaSemCnx().hashCode();
        }
        if (getQtAutoTempoparadaSemEvt() != null) {
            _hashCode += getQtAutoTempoparadaSemEvt().hashCode();
        }
        if (getQtAutoTempoparadaSemOp() != null) {
            _hashCode += getQtAutoTempoparadaSemOp().hashCode();
        }
        if (getQtManuCicloimprodutivo() != null) {
            _hashCode += getQtManuCicloimprodutivo().hashCode();
        }
        if (getQtManuCicloprodutivo() != null) {
            _hashCode += getQtManuCicloprodutivo().hashCode();
        }
        if (getQtManuCicloregulagem() != null) {
            _hashCode += getQtManuCicloregulagem().hashCode();
        }
        if (getQtManuOcoparadaCpVr() != null) {
            _hashCode += getQtManuOcoparadaCpVr().hashCode();
        }
        if (getQtManuOcoparadaSpVr() != null) {
            _hashCode += getQtManuOcoparadaSpVr().hashCode();
        }
        if (getQtManuTempoparadaDefault() != null) {
            _hashCode += getQtManuTempoparadaDefault().hashCode();
        }
        if (getQtManuTempoparadaSemCnx() != null) {
            _hashCode += getQtManuTempoparadaSemCnx().hashCode();
        }
        if (getQtManuTempoparadaSemEvt() != null) {
            _hashCode += getQtManuTempoparadaSemEvt().hashCode();
        }
        if (getQtManuTempoparadaSemOp() != null) {
            _hashCode += getQtManuTempoparadaSemOp().hashCode();
        }
        if (getSegAutoCicloimprodutivo() != null) {
            _hashCode += getSegAutoCicloimprodutivo().hashCode();
        }
        if (getSegAutoCicloimprodutivoCta() != null) {
            _hashCode += getSegAutoCicloimprodutivoCta().hashCode();
        }
        if (getSegAutoCicloprodutivo() != null) {
            _hashCode += getSegAutoCicloprodutivo().hashCode();
        }
        if (getSegAutoCicloprodutivoCta() != null) {
            _hashCode += getSegAutoCicloprodutivoCta().hashCode();
        }
        if (getSegAutoCicloregulagem() != null) {
            _hashCode += getSegAutoCicloregulagem().hashCode();
        }
        if (getSegAutoCta() != null) {
            _hashCode += getSegAutoCta().hashCode();
        }
        if (getSegAutoTempologin() != null) {
            _hashCode += getSegAutoTempologin().hashCode();
        }
        if (getSegAutoTempoparadaCp() != null) {
            _hashCode += getSegAutoTempoparadaCp().hashCode();
        }
        if (getSegAutoTempoparadaCpVr() != null) {
            _hashCode += getSegAutoTempoparadaCpVr().hashCode();
        }
        if (getSegAutoTempoparadaDefault() != null) {
            _hashCode += getSegAutoTempoparadaDefault().hashCode();
        }
        if (getSegAutoTempoparadaSemCnx() != null) {
            _hashCode += getSegAutoTempoparadaSemCnx().hashCode();
        }
        if (getSegAutoTempoparadaSemEvt() != null) {
            _hashCode += getSegAutoTempoparadaSemEvt().hashCode();
        }
        if (getSegAutoTempoparadaSemOp() != null) {
            _hashCode += getSegAutoTempoparadaSemOp().hashCode();
        }
        if (getSegAutoTempoparadaSp() != null) {
            _hashCode += getSegAutoTempoparadaSp().hashCode();
        }
        if (getSegAutoTempoparadaSpVr() != null) {
            _hashCode += getSegAutoTempoparadaSpVr().hashCode();
        }
        if (getSegAutoTempotrabalhado() != null) {
            _hashCode += getSegAutoTempotrabalhado().hashCode();
        }
        if (getSegManuCicloimprodutivo() != null) {
            _hashCode += getSegManuCicloimprodutivo().hashCode();
        }
        if (getSegManuCicloimprodutivoCta() != null) {
            _hashCode += getSegManuCicloimprodutivoCta().hashCode();
        }
        if (getSegManuCicloprodutivo() != null) {
            _hashCode += getSegManuCicloprodutivo().hashCode();
        }
        if (getSegManuCicloprodutivoCta() != null) {
            _hashCode += getSegManuCicloprodutivoCta().hashCode();
        }
        if (getSegManuCicloregulagem() != null) {
            _hashCode += getSegManuCicloregulagem().hashCode();
        }
        if (getSegManuCta() != null) {
            _hashCode += getSegManuCta().hashCode();
        }
        if (getSegManuTempologin() != null) {
            _hashCode += getSegManuTempologin().hashCode();
        }
        if (getSegManuTempoparadaCp() != null) {
            _hashCode += getSegManuTempoparadaCp().hashCode();
        }
        if (getSegManuTempoparadaCpVr() != null) {
            _hashCode += getSegManuTempoparadaCpVr().hashCode();
        }
        if (getSegManuTempoparadaDefault() != null) {
            _hashCode += getSegManuTempoparadaDefault().hashCode();
        }
        if (getSegManuTempoparadaSemCnx() != null) {
            _hashCode += getSegManuTempoparadaSemCnx().hashCode();
        }
        if (getSegManuTempoparadaSemEvt() != null) {
            _hashCode += getSegManuTempoparadaSemEvt().hashCode();
        }
        if (getSegManuTempoparadaSemOp() != null) {
            _hashCode += getSegManuTempoparadaSemOp().hashCode();
        }
        if (getSegManuTempoparadaSp() != null) {
            _hashCode += getSegManuTempoparadaSp().hashCode();
        }
        if (getSegManuTempoparadaSpVr() != null) {
            _hashCode += getSegManuTempoparadaSpVr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolmo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolalmos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolalmos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolalmo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolmoocos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolmoocos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmooco"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolpamos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolpamos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpamo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolprmos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolprmos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolprmo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolremos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolremos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolremo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolmo"));
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
        elemField.setFieldName("pcsAutoPerda");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsAutoPerda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsAutoProducaobruta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsAutoProducaobruta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsAutoProducaoprevista");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsAutoProducaoprevista"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsAutoProducaorefugada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsAutoProducaorefugada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsManuProducaobruta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsManuProducaobruta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsManuProducaoprevista");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsManuProducaoprevista"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsManuProducaorefugada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsManuProducaorefugada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoCicloimprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoCicloimprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoCicloprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoCicloprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoCicloregulagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoCicloregulagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadaCpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadaCpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadaSpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadaSpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoTempoparadaDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoTempoparadaDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoTempoparadaSemCnx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoTempoparadaSemCnx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoTempoparadaSemEvt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoTempoparadaSemEvt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoTempoparadaSemOp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoTempoparadaSemOp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuCicloimprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuCicloimprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuCicloprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuCicloprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuCicloregulagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuCicloregulagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadaCpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadaCpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadaSpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadaSpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuTempoparadaDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuTempoparadaDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuTempoparadaSemCnx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuTempoparadaSemCnx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuTempoparadaSemEvt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuTempoparadaSemEvt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuTempoparadaSemOp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuTempoparadaSemOp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoCicloimprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoCicloimprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoCicloimprodutivoCta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoCicloimprodutivoCta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoCicloprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoCicloprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoCicloprodutivoCta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoCicloprodutivoCta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoCicloregulagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoCicloregulagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoCta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoCta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempologin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempologin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaCpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaCpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaSemCnx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaSemCnx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaSemEvt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaSemEvt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaSemOp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaSemOp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaSp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaSp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaSpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaSpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempotrabalhado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempotrabalhado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuCicloimprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuCicloimprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuCicloimprodutivoCta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuCicloimprodutivoCta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuCicloprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuCicloprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuCicloprodutivoCta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuCicloprodutivoCta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuCicloregulagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuCicloregulagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuCta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuCta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempologin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempologin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaCpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaCpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaSemCnx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaSemCnx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaSemEvt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaSemEvt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaSemOp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaSemOp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaSp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaSp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaSpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaSpVr"));
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
