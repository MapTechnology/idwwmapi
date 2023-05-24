/**
 * Ijtbpar.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbpar  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedShort calcmtbfmttr;

    private java.lang.String cdparada;

    private java.lang.String dsparada;

    private java.math.BigDecimal entradademolde;

    private idw.idwws.Exportacao001[] exportacao001S;

    private idw.idwws.Exportacao003[] exportacao003S;

    private org.apache.axis.types.UnsignedShort fds;

    private org.apache.axis.types.UnsignedShort fechaloginoperador;

    private idw.idwws.Ijareres ijareres;

    private idw.idwws.Ijgrpdetpar[] ijgrpdetpars;

    private idw.idwws.Ijlogcorrreq[] ijlogcorrreqs;

    private idw.idwws.Ijopintrasa[] ijopintrasas;

    private idw.idwws.Ijpdcapadrao[] ijpdcapadraos;

    private idw.idwws.Ijreapar[] ijreapars;

    private idw.idwws.Ijtbinj[] ijtbinjs;

    private idw.idwws.Ijtbparaux[] ijtbparauxes;

    private idw.idwws.Ijtbpardefctrlipro[] ijtbpardefctrlipros;

    private idw.idwws.Ijtbpardefsemcon[] ijtbpardefsemcons;

    private idw.idwws.Ijtbparintrasa[] ijtbparintrasas;

    private idw.idwws.Ijtbparreqtecespec[] ijtbparreqtecespecs;

    private org.apache.axis.types.UnsignedShort mdo;

    private org.apache.axis.types.UnsignedShort monittmplimite;

    private org.apache.axis.types.UnsignedShort pa;

    private org.apache.axis.types.UnsignedShort pao;

    private org.apache.axis.types.UnsignedShort paradapersistente;

    private java.math.BigDecimal paradaprevista;

    private org.apache.axis.types.UnsignedShort pcta;

    private java.math.BigDecimal pededrtresponsa;

    private java.math.BigDecimal pededrttecnico1;

    private java.math.BigDecimal pededrttecnico2;

    private java.math.BigDecimal permitecorrecao;

    private org.apache.axis.types.UnsignedShort ptp;

    private java.math.BigDecimal reqparadaprep;

    private java.math.BigDecimal reqparadasetup;

    private java.math.BigDecimal requeracao;

    private java.math.BigDecimal requercancelamento;

    private java.math.BigDecimal requercausa;

    private java.math.BigDecimal requerjustificativ;

    private java.math.BigDecimal requisicaonova01;

    private java.math.BigDecimal saidademolde;

    private org.apache.axis.types.UnsignedShort scp;

    private double tempolimite;

    private java.math.BigDecimal teprogramado;

    private java.math.BigDecimal trocademolde;

    public Ijtbpar() {
    }

    public Ijtbpar(
           org.apache.axis.types.UnsignedShort calcmtbfmttr,
           java.lang.String cdparada,
           java.lang.String dsparada,
           java.math.BigDecimal entradademolde,
           idw.idwws.Exportacao001[] exportacao001S,
           idw.idwws.Exportacao003[] exportacao003S,
           org.apache.axis.types.UnsignedShort fds,
           org.apache.axis.types.UnsignedShort fechaloginoperador,
           idw.idwws.Ijareres ijareres,
           idw.idwws.Ijgrpdetpar[] ijgrpdetpars,
           idw.idwws.Ijlogcorrreq[] ijlogcorrreqs,
           idw.idwws.Ijopintrasa[] ijopintrasas,
           idw.idwws.Ijpdcapadrao[] ijpdcapadraos,
           idw.idwws.Ijreapar[] ijreapars,
           idw.idwws.Ijtbinj[] ijtbinjs,
           idw.idwws.Ijtbparaux[] ijtbparauxes,
           idw.idwws.Ijtbpardefctrlipro[] ijtbpardefctrlipros,
           idw.idwws.Ijtbpardefsemcon[] ijtbpardefsemcons,
           idw.idwws.Ijtbparintrasa[] ijtbparintrasas,
           idw.idwws.Ijtbparreqtecespec[] ijtbparreqtecespecs,
           org.apache.axis.types.UnsignedShort mdo,
           org.apache.axis.types.UnsignedShort monittmplimite,
           org.apache.axis.types.UnsignedShort pa,
           org.apache.axis.types.UnsignedShort pao,
           org.apache.axis.types.UnsignedShort paradapersistente,
           java.math.BigDecimal paradaprevista,
           org.apache.axis.types.UnsignedShort pcta,
           java.math.BigDecimal pededrtresponsa,
           java.math.BigDecimal pededrttecnico1,
           java.math.BigDecimal pededrttecnico2,
           java.math.BigDecimal permitecorrecao,
           org.apache.axis.types.UnsignedShort ptp,
           java.math.BigDecimal reqparadaprep,
           java.math.BigDecimal reqparadasetup,
           java.math.BigDecimal requeracao,
           java.math.BigDecimal requercancelamento,
           java.math.BigDecimal requercausa,
           java.math.BigDecimal requerjustificativ,
           java.math.BigDecimal requisicaonova01,
           java.math.BigDecimal saidademolde,
           org.apache.axis.types.UnsignedShort scp,
           double tempolimite,
           java.math.BigDecimal teprogramado,
           java.math.BigDecimal trocademolde) {
           this.calcmtbfmttr = calcmtbfmttr;
           this.cdparada = cdparada;
           this.dsparada = dsparada;
           this.entradademolde = entradademolde;
           this.exportacao001S = exportacao001S;
           this.exportacao003S = exportacao003S;
           this.fds = fds;
           this.fechaloginoperador = fechaloginoperador;
           this.ijareres = ijareres;
           this.ijgrpdetpars = ijgrpdetpars;
           this.ijlogcorrreqs = ijlogcorrreqs;
           this.ijopintrasas = ijopintrasas;
           this.ijpdcapadraos = ijpdcapadraos;
           this.ijreapars = ijreapars;
           this.ijtbinjs = ijtbinjs;
           this.ijtbparauxes = ijtbparauxes;
           this.ijtbpardefctrlipros = ijtbpardefctrlipros;
           this.ijtbpardefsemcons = ijtbpardefsemcons;
           this.ijtbparintrasas = ijtbparintrasas;
           this.ijtbparreqtecespecs = ijtbparreqtecespecs;
           this.mdo = mdo;
           this.monittmplimite = monittmplimite;
           this.pa = pa;
           this.pao = pao;
           this.paradapersistente = paradapersistente;
           this.paradaprevista = paradaprevista;
           this.pcta = pcta;
           this.pededrtresponsa = pededrtresponsa;
           this.pededrttecnico1 = pededrttecnico1;
           this.pededrttecnico2 = pededrttecnico2;
           this.permitecorrecao = permitecorrecao;
           this.ptp = ptp;
           this.reqparadaprep = reqparadaprep;
           this.reqparadasetup = reqparadasetup;
           this.requeracao = requeracao;
           this.requercancelamento = requercancelamento;
           this.requercausa = requercausa;
           this.requerjustificativ = requerjustificativ;
           this.requisicaonova01 = requisicaonova01;
           this.saidademolde = saidademolde;
           this.scp = scp;
           this.tempolimite = tempolimite;
           this.teprogramado = teprogramado;
           this.trocademolde = trocademolde;
    }


    /**
     * Gets the calcmtbfmttr value for this Ijtbpar.
     * 
     * @return calcmtbfmttr
     */
    public org.apache.axis.types.UnsignedShort getCalcmtbfmttr() {
        return calcmtbfmttr;
    }


    /**
     * Sets the calcmtbfmttr value for this Ijtbpar.
     * 
     * @param calcmtbfmttr
     */
    public void setCalcmtbfmttr(org.apache.axis.types.UnsignedShort calcmtbfmttr) {
        this.calcmtbfmttr = calcmtbfmttr;
    }


    /**
     * Gets the cdparada value for this Ijtbpar.
     * 
     * @return cdparada
     */
    public java.lang.String getCdparada() {
        return cdparada;
    }


    /**
     * Sets the cdparada value for this Ijtbpar.
     * 
     * @param cdparada
     */
    public void setCdparada(java.lang.String cdparada) {
        this.cdparada = cdparada;
    }


    /**
     * Gets the dsparada value for this Ijtbpar.
     * 
     * @return dsparada
     */
    public java.lang.String getDsparada() {
        return dsparada;
    }


    /**
     * Sets the dsparada value for this Ijtbpar.
     * 
     * @param dsparada
     */
    public void setDsparada(java.lang.String dsparada) {
        this.dsparada = dsparada;
    }


    /**
     * Gets the entradademolde value for this Ijtbpar.
     * 
     * @return entradademolde
     */
    public java.math.BigDecimal getEntradademolde() {
        return entradademolde;
    }


    /**
     * Sets the entradademolde value for this Ijtbpar.
     * 
     * @param entradademolde
     */
    public void setEntradademolde(java.math.BigDecimal entradademolde) {
        this.entradademolde = entradademolde;
    }


    /**
     * Gets the exportacao001S value for this Ijtbpar.
     * 
     * @return exportacao001S
     */
    public idw.idwws.Exportacao001[] getExportacao001S() {
        return exportacao001S;
    }


    /**
     * Sets the exportacao001S value for this Ijtbpar.
     * 
     * @param exportacao001S
     */
    public void setExportacao001S(idw.idwws.Exportacao001[] exportacao001S) {
        this.exportacao001S = exportacao001S;
    }

    public idw.idwws.Exportacao001 getExportacao001S(int i) {
        return this.exportacao001S[i];
    }

    public void setExportacao001S(int i, idw.idwws.Exportacao001 _value) {
        this.exportacao001S[i] = _value;
    }


    /**
     * Gets the exportacao003S value for this Ijtbpar.
     * 
     * @return exportacao003S
     */
    public idw.idwws.Exportacao003[] getExportacao003S() {
        return exportacao003S;
    }


    /**
     * Sets the exportacao003S value for this Ijtbpar.
     * 
     * @param exportacao003S
     */
    public void setExportacao003S(idw.idwws.Exportacao003[] exportacao003S) {
        this.exportacao003S = exportacao003S;
    }

    public idw.idwws.Exportacao003 getExportacao003S(int i) {
        return this.exportacao003S[i];
    }

    public void setExportacao003S(int i, idw.idwws.Exportacao003 _value) {
        this.exportacao003S[i] = _value;
    }


    /**
     * Gets the fds value for this Ijtbpar.
     * 
     * @return fds
     */
    public org.apache.axis.types.UnsignedShort getFds() {
        return fds;
    }


    /**
     * Sets the fds value for this Ijtbpar.
     * 
     * @param fds
     */
    public void setFds(org.apache.axis.types.UnsignedShort fds) {
        this.fds = fds;
    }


    /**
     * Gets the fechaloginoperador value for this Ijtbpar.
     * 
     * @return fechaloginoperador
     */
    public org.apache.axis.types.UnsignedShort getFechaloginoperador() {
        return fechaloginoperador;
    }


    /**
     * Sets the fechaloginoperador value for this Ijtbpar.
     * 
     * @param fechaloginoperador
     */
    public void setFechaloginoperador(org.apache.axis.types.UnsignedShort fechaloginoperador) {
        this.fechaloginoperador = fechaloginoperador;
    }


    /**
     * Gets the ijareres value for this Ijtbpar.
     * 
     * @return ijareres
     */
    public idw.idwws.Ijareres getIjareres() {
        return ijareres;
    }


    /**
     * Sets the ijareres value for this Ijtbpar.
     * 
     * @param ijareres
     */
    public void setIjareres(idw.idwws.Ijareres ijareres) {
        this.ijareres = ijareres;
    }


    /**
     * Gets the ijgrpdetpars value for this Ijtbpar.
     * 
     * @return ijgrpdetpars
     */
    public idw.idwws.Ijgrpdetpar[] getIjgrpdetpars() {
        return ijgrpdetpars;
    }


    /**
     * Sets the ijgrpdetpars value for this Ijtbpar.
     * 
     * @param ijgrpdetpars
     */
    public void setIjgrpdetpars(idw.idwws.Ijgrpdetpar[] ijgrpdetpars) {
        this.ijgrpdetpars = ijgrpdetpars;
    }

    public idw.idwws.Ijgrpdetpar getIjgrpdetpars(int i) {
        return this.ijgrpdetpars[i];
    }

    public void setIjgrpdetpars(int i, idw.idwws.Ijgrpdetpar _value) {
        this.ijgrpdetpars[i] = _value;
    }


    /**
     * Gets the ijlogcorrreqs value for this Ijtbpar.
     * 
     * @return ijlogcorrreqs
     */
    public idw.idwws.Ijlogcorrreq[] getIjlogcorrreqs() {
        return ijlogcorrreqs;
    }


    /**
     * Sets the ijlogcorrreqs value for this Ijtbpar.
     * 
     * @param ijlogcorrreqs
     */
    public void setIjlogcorrreqs(idw.idwws.Ijlogcorrreq[] ijlogcorrreqs) {
        this.ijlogcorrreqs = ijlogcorrreqs;
    }

    public idw.idwws.Ijlogcorrreq getIjlogcorrreqs(int i) {
        return this.ijlogcorrreqs[i];
    }

    public void setIjlogcorrreqs(int i, idw.idwws.Ijlogcorrreq _value) {
        this.ijlogcorrreqs[i] = _value;
    }


    /**
     * Gets the ijopintrasas value for this Ijtbpar.
     * 
     * @return ijopintrasas
     */
    public idw.idwws.Ijopintrasa[] getIjopintrasas() {
        return ijopintrasas;
    }


    /**
     * Sets the ijopintrasas value for this Ijtbpar.
     * 
     * @param ijopintrasas
     */
    public void setIjopintrasas(idw.idwws.Ijopintrasa[] ijopintrasas) {
        this.ijopintrasas = ijopintrasas;
    }

    public idw.idwws.Ijopintrasa getIjopintrasas(int i) {
        return this.ijopintrasas[i];
    }

    public void setIjopintrasas(int i, idw.idwws.Ijopintrasa _value) {
        this.ijopintrasas[i] = _value;
    }


    /**
     * Gets the ijpdcapadraos value for this Ijtbpar.
     * 
     * @return ijpdcapadraos
     */
    public idw.idwws.Ijpdcapadrao[] getIjpdcapadraos() {
        return ijpdcapadraos;
    }


    /**
     * Sets the ijpdcapadraos value for this Ijtbpar.
     * 
     * @param ijpdcapadraos
     */
    public void setIjpdcapadraos(idw.idwws.Ijpdcapadrao[] ijpdcapadraos) {
        this.ijpdcapadraos = ijpdcapadraos;
    }

    public idw.idwws.Ijpdcapadrao getIjpdcapadraos(int i) {
        return this.ijpdcapadraos[i];
    }

    public void setIjpdcapadraos(int i, idw.idwws.Ijpdcapadrao _value) {
        this.ijpdcapadraos[i] = _value;
    }


    /**
     * Gets the ijreapars value for this Ijtbpar.
     * 
     * @return ijreapars
     */
    public idw.idwws.Ijreapar[] getIjreapars() {
        return ijreapars;
    }


    /**
     * Sets the ijreapars value for this Ijtbpar.
     * 
     * @param ijreapars
     */
    public void setIjreapars(idw.idwws.Ijreapar[] ijreapars) {
        this.ijreapars = ijreapars;
    }

    public idw.idwws.Ijreapar getIjreapars(int i) {
        return this.ijreapars[i];
    }

    public void setIjreapars(int i, idw.idwws.Ijreapar _value) {
        this.ijreapars[i] = _value;
    }


    /**
     * Gets the ijtbinjs value for this Ijtbpar.
     * 
     * @return ijtbinjs
     */
    public idw.idwws.Ijtbinj[] getIjtbinjs() {
        return ijtbinjs;
    }


    /**
     * Sets the ijtbinjs value for this Ijtbpar.
     * 
     * @param ijtbinjs
     */
    public void setIjtbinjs(idw.idwws.Ijtbinj[] ijtbinjs) {
        this.ijtbinjs = ijtbinjs;
    }

    public idw.idwws.Ijtbinj getIjtbinjs(int i) {
        return this.ijtbinjs[i];
    }

    public void setIjtbinjs(int i, idw.idwws.Ijtbinj _value) {
        this.ijtbinjs[i] = _value;
    }


    /**
     * Gets the ijtbparauxes value for this Ijtbpar.
     * 
     * @return ijtbparauxes
     */
    public idw.idwws.Ijtbparaux[] getIjtbparauxes() {
        return ijtbparauxes;
    }


    /**
     * Sets the ijtbparauxes value for this Ijtbpar.
     * 
     * @param ijtbparauxes
     */
    public void setIjtbparauxes(idw.idwws.Ijtbparaux[] ijtbparauxes) {
        this.ijtbparauxes = ijtbparauxes;
    }

    public idw.idwws.Ijtbparaux getIjtbparauxes(int i) {
        return this.ijtbparauxes[i];
    }

    public void setIjtbparauxes(int i, idw.idwws.Ijtbparaux _value) {
        this.ijtbparauxes[i] = _value;
    }


    /**
     * Gets the ijtbpardefctrlipros value for this Ijtbpar.
     * 
     * @return ijtbpardefctrlipros
     */
    public idw.idwws.Ijtbpardefctrlipro[] getIjtbpardefctrlipros() {
        return ijtbpardefctrlipros;
    }


    /**
     * Sets the ijtbpardefctrlipros value for this Ijtbpar.
     * 
     * @param ijtbpardefctrlipros
     */
    public void setIjtbpardefctrlipros(idw.idwws.Ijtbpardefctrlipro[] ijtbpardefctrlipros) {
        this.ijtbpardefctrlipros = ijtbpardefctrlipros;
    }

    public idw.idwws.Ijtbpardefctrlipro getIjtbpardefctrlipros(int i) {
        return this.ijtbpardefctrlipros[i];
    }

    public void setIjtbpardefctrlipros(int i, idw.idwws.Ijtbpardefctrlipro _value) {
        this.ijtbpardefctrlipros[i] = _value;
    }


    /**
     * Gets the ijtbpardefsemcons value for this Ijtbpar.
     * 
     * @return ijtbpardefsemcons
     */
    public idw.idwws.Ijtbpardefsemcon[] getIjtbpardefsemcons() {
        return ijtbpardefsemcons;
    }


    /**
     * Sets the ijtbpardefsemcons value for this Ijtbpar.
     * 
     * @param ijtbpardefsemcons
     */
    public void setIjtbpardefsemcons(idw.idwws.Ijtbpardefsemcon[] ijtbpardefsemcons) {
        this.ijtbpardefsemcons = ijtbpardefsemcons;
    }

    public idw.idwws.Ijtbpardefsemcon getIjtbpardefsemcons(int i) {
        return this.ijtbpardefsemcons[i];
    }

    public void setIjtbpardefsemcons(int i, idw.idwws.Ijtbpardefsemcon _value) {
        this.ijtbpardefsemcons[i] = _value;
    }


    /**
     * Gets the ijtbparintrasas value for this Ijtbpar.
     * 
     * @return ijtbparintrasas
     */
    public idw.idwws.Ijtbparintrasa[] getIjtbparintrasas() {
        return ijtbparintrasas;
    }


    /**
     * Sets the ijtbparintrasas value for this Ijtbpar.
     * 
     * @param ijtbparintrasas
     */
    public void setIjtbparintrasas(idw.idwws.Ijtbparintrasa[] ijtbparintrasas) {
        this.ijtbparintrasas = ijtbparintrasas;
    }

    public idw.idwws.Ijtbparintrasa getIjtbparintrasas(int i) {
        return this.ijtbparintrasas[i];
    }

    public void setIjtbparintrasas(int i, idw.idwws.Ijtbparintrasa _value) {
        this.ijtbparintrasas[i] = _value;
    }


    /**
     * Gets the ijtbparreqtecespecs value for this Ijtbpar.
     * 
     * @return ijtbparreqtecespecs
     */
    public idw.idwws.Ijtbparreqtecespec[] getIjtbparreqtecespecs() {
        return ijtbparreqtecespecs;
    }


    /**
     * Sets the ijtbparreqtecespecs value for this Ijtbpar.
     * 
     * @param ijtbparreqtecespecs
     */
    public void setIjtbparreqtecespecs(idw.idwws.Ijtbparreqtecespec[] ijtbparreqtecespecs) {
        this.ijtbparreqtecespecs = ijtbparreqtecespecs;
    }

    public idw.idwws.Ijtbparreqtecespec getIjtbparreqtecespecs(int i) {
        return this.ijtbparreqtecespecs[i];
    }

    public void setIjtbparreqtecespecs(int i, idw.idwws.Ijtbparreqtecespec _value) {
        this.ijtbparreqtecespecs[i] = _value;
    }


    /**
     * Gets the mdo value for this Ijtbpar.
     * 
     * @return mdo
     */
    public org.apache.axis.types.UnsignedShort getMdo() {
        return mdo;
    }


    /**
     * Sets the mdo value for this Ijtbpar.
     * 
     * @param mdo
     */
    public void setMdo(org.apache.axis.types.UnsignedShort mdo) {
        this.mdo = mdo;
    }


    /**
     * Gets the monittmplimite value for this Ijtbpar.
     * 
     * @return monittmplimite
     */
    public org.apache.axis.types.UnsignedShort getMonittmplimite() {
        return monittmplimite;
    }


    /**
     * Sets the monittmplimite value for this Ijtbpar.
     * 
     * @param monittmplimite
     */
    public void setMonittmplimite(org.apache.axis.types.UnsignedShort monittmplimite) {
        this.monittmplimite = monittmplimite;
    }


    /**
     * Gets the pa value for this Ijtbpar.
     * 
     * @return pa
     */
    public org.apache.axis.types.UnsignedShort getPa() {
        return pa;
    }


    /**
     * Sets the pa value for this Ijtbpar.
     * 
     * @param pa
     */
    public void setPa(org.apache.axis.types.UnsignedShort pa) {
        this.pa = pa;
    }


    /**
     * Gets the pao value for this Ijtbpar.
     * 
     * @return pao
     */
    public org.apache.axis.types.UnsignedShort getPao() {
        return pao;
    }


    /**
     * Sets the pao value for this Ijtbpar.
     * 
     * @param pao
     */
    public void setPao(org.apache.axis.types.UnsignedShort pao) {
        this.pao = pao;
    }


    /**
     * Gets the paradapersistente value for this Ijtbpar.
     * 
     * @return paradapersistente
     */
    public org.apache.axis.types.UnsignedShort getParadapersistente() {
        return paradapersistente;
    }


    /**
     * Sets the paradapersistente value for this Ijtbpar.
     * 
     * @param paradapersistente
     */
    public void setParadapersistente(org.apache.axis.types.UnsignedShort paradapersistente) {
        this.paradapersistente = paradapersistente;
    }


    /**
     * Gets the paradaprevista value for this Ijtbpar.
     * 
     * @return paradaprevista
     */
    public java.math.BigDecimal getParadaprevista() {
        return paradaprevista;
    }


    /**
     * Sets the paradaprevista value for this Ijtbpar.
     * 
     * @param paradaprevista
     */
    public void setParadaprevista(java.math.BigDecimal paradaprevista) {
        this.paradaprevista = paradaprevista;
    }


    /**
     * Gets the pcta value for this Ijtbpar.
     * 
     * @return pcta
     */
    public org.apache.axis.types.UnsignedShort getPcta() {
        return pcta;
    }


    /**
     * Sets the pcta value for this Ijtbpar.
     * 
     * @param pcta
     */
    public void setPcta(org.apache.axis.types.UnsignedShort pcta) {
        this.pcta = pcta;
    }


    /**
     * Gets the pededrtresponsa value for this Ijtbpar.
     * 
     * @return pededrtresponsa
     */
    public java.math.BigDecimal getPededrtresponsa() {
        return pededrtresponsa;
    }


    /**
     * Sets the pededrtresponsa value for this Ijtbpar.
     * 
     * @param pededrtresponsa
     */
    public void setPededrtresponsa(java.math.BigDecimal pededrtresponsa) {
        this.pededrtresponsa = pededrtresponsa;
    }


    /**
     * Gets the pededrttecnico1 value for this Ijtbpar.
     * 
     * @return pededrttecnico1
     */
    public java.math.BigDecimal getPededrttecnico1() {
        return pededrttecnico1;
    }


    /**
     * Sets the pededrttecnico1 value for this Ijtbpar.
     * 
     * @param pededrttecnico1
     */
    public void setPededrttecnico1(java.math.BigDecimal pededrttecnico1) {
        this.pededrttecnico1 = pededrttecnico1;
    }


    /**
     * Gets the pededrttecnico2 value for this Ijtbpar.
     * 
     * @return pededrttecnico2
     */
    public java.math.BigDecimal getPededrttecnico2() {
        return pededrttecnico2;
    }


    /**
     * Sets the pededrttecnico2 value for this Ijtbpar.
     * 
     * @param pededrttecnico2
     */
    public void setPededrttecnico2(java.math.BigDecimal pededrttecnico2) {
        this.pededrttecnico2 = pededrttecnico2;
    }


    /**
     * Gets the permitecorrecao value for this Ijtbpar.
     * 
     * @return permitecorrecao
     */
    public java.math.BigDecimal getPermitecorrecao() {
        return permitecorrecao;
    }


    /**
     * Sets the permitecorrecao value for this Ijtbpar.
     * 
     * @param permitecorrecao
     */
    public void setPermitecorrecao(java.math.BigDecimal permitecorrecao) {
        this.permitecorrecao = permitecorrecao;
    }


    /**
     * Gets the ptp value for this Ijtbpar.
     * 
     * @return ptp
     */
    public org.apache.axis.types.UnsignedShort getPtp() {
        return ptp;
    }


    /**
     * Sets the ptp value for this Ijtbpar.
     * 
     * @param ptp
     */
    public void setPtp(org.apache.axis.types.UnsignedShort ptp) {
        this.ptp = ptp;
    }


    /**
     * Gets the reqparadaprep value for this Ijtbpar.
     * 
     * @return reqparadaprep
     */
    public java.math.BigDecimal getReqparadaprep() {
        return reqparadaprep;
    }


    /**
     * Sets the reqparadaprep value for this Ijtbpar.
     * 
     * @param reqparadaprep
     */
    public void setReqparadaprep(java.math.BigDecimal reqparadaprep) {
        this.reqparadaprep = reqparadaprep;
    }


    /**
     * Gets the reqparadasetup value for this Ijtbpar.
     * 
     * @return reqparadasetup
     */
    public java.math.BigDecimal getReqparadasetup() {
        return reqparadasetup;
    }


    /**
     * Sets the reqparadasetup value for this Ijtbpar.
     * 
     * @param reqparadasetup
     */
    public void setReqparadasetup(java.math.BigDecimal reqparadasetup) {
        this.reqparadasetup = reqparadasetup;
    }


    /**
     * Gets the requeracao value for this Ijtbpar.
     * 
     * @return requeracao
     */
    public java.math.BigDecimal getRequeracao() {
        return requeracao;
    }


    /**
     * Sets the requeracao value for this Ijtbpar.
     * 
     * @param requeracao
     */
    public void setRequeracao(java.math.BigDecimal requeracao) {
        this.requeracao = requeracao;
    }


    /**
     * Gets the requercancelamento value for this Ijtbpar.
     * 
     * @return requercancelamento
     */
    public java.math.BigDecimal getRequercancelamento() {
        return requercancelamento;
    }


    /**
     * Sets the requercancelamento value for this Ijtbpar.
     * 
     * @param requercancelamento
     */
    public void setRequercancelamento(java.math.BigDecimal requercancelamento) {
        this.requercancelamento = requercancelamento;
    }


    /**
     * Gets the requercausa value for this Ijtbpar.
     * 
     * @return requercausa
     */
    public java.math.BigDecimal getRequercausa() {
        return requercausa;
    }


    /**
     * Sets the requercausa value for this Ijtbpar.
     * 
     * @param requercausa
     */
    public void setRequercausa(java.math.BigDecimal requercausa) {
        this.requercausa = requercausa;
    }


    /**
     * Gets the requerjustificativ value for this Ijtbpar.
     * 
     * @return requerjustificativ
     */
    public java.math.BigDecimal getRequerjustificativ() {
        return requerjustificativ;
    }


    /**
     * Sets the requerjustificativ value for this Ijtbpar.
     * 
     * @param requerjustificativ
     */
    public void setRequerjustificativ(java.math.BigDecimal requerjustificativ) {
        this.requerjustificativ = requerjustificativ;
    }


    /**
     * Gets the requisicaonova01 value for this Ijtbpar.
     * 
     * @return requisicaonova01
     */
    public java.math.BigDecimal getRequisicaonova01() {
        return requisicaonova01;
    }


    /**
     * Sets the requisicaonova01 value for this Ijtbpar.
     * 
     * @param requisicaonova01
     */
    public void setRequisicaonova01(java.math.BigDecimal requisicaonova01) {
        this.requisicaonova01 = requisicaonova01;
    }


    /**
     * Gets the saidademolde value for this Ijtbpar.
     * 
     * @return saidademolde
     */
    public java.math.BigDecimal getSaidademolde() {
        return saidademolde;
    }


    /**
     * Sets the saidademolde value for this Ijtbpar.
     * 
     * @param saidademolde
     */
    public void setSaidademolde(java.math.BigDecimal saidademolde) {
        this.saidademolde = saidademolde;
    }


    /**
     * Gets the scp value for this Ijtbpar.
     * 
     * @return scp
     */
    public org.apache.axis.types.UnsignedShort getScp() {
        return scp;
    }


    /**
     * Sets the scp value for this Ijtbpar.
     * 
     * @param scp
     */
    public void setScp(org.apache.axis.types.UnsignedShort scp) {
        this.scp = scp;
    }


    /**
     * Gets the tempolimite value for this Ijtbpar.
     * 
     * @return tempolimite
     */
    public double getTempolimite() {
        return tempolimite;
    }


    /**
     * Sets the tempolimite value for this Ijtbpar.
     * 
     * @param tempolimite
     */
    public void setTempolimite(double tempolimite) {
        this.tempolimite = tempolimite;
    }


    /**
     * Gets the teprogramado value for this Ijtbpar.
     * 
     * @return teprogramado
     */
    public java.math.BigDecimal getTeprogramado() {
        return teprogramado;
    }


    /**
     * Sets the teprogramado value for this Ijtbpar.
     * 
     * @param teprogramado
     */
    public void setTeprogramado(java.math.BigDecimal teprogramado) {
        this.teprogramado = teprogramado;
    }


    /**
     * Gets the trocademolde value for this Ijtbpar.
     * 
     * @return trocademolde
     */
    public java.math.BigDecimal getTrocademolde() {
        return trocademolde;
    }


    /**
     * Sets the trocademolde value for this Ijtbpar.
     * 
     * @param trocademolde
     */
    public void setTrocademolde(java.math.BigDecimal trocademolde) {
        this.trocademolde = trocademolde;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbpar)) return false;
        Ijtbpar other = (Ijtbpar) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.calcmtbfmttr==null && other.getCalcmtbfmttr()==null) || 
             (this.calcmtbfmttr!=null &&
              this.calcmtbfmttr.equals(other.getCalcmtbfmttr()))) &&
            ((this.cdparada==null && other.getCdparada()==null) || 
             (this.cdparada!=null &&
              this.cdparada.equals(other.getCdparada()))) &&
            ((this.dsparada==null && other.getDsparada()==null) || 
             (this.dsparada!=null &&
              this.dsparada.equals(other.getDsparada()))) &&
            ((this.entradademolde==null && other.getEntradademolde()==null) || 
             (this.entradademolde!=null &&
              this.entradademolde.equals(other.getEntradademolde()))) &&
            ((this.exportacao001S==null && other.getExportacao001S()==null) || 
             (this.exportacao001S!=null &&
              java.util.Arrays.equals(this.exportacao001S, other.getExportacao001S()))) &&
            ((this.exportacao003S==null && other.getExportacao003S()==null) || 
             (this.exportacao003S!=null &&
              java.util.Arrays.equals(this.exportacao003S, other.getExportacao003S()))) &&
            ((this.fds==null && other.getFds()==null) || 
             (this.fds!=null &&
              this.fds.equals(other.getFds()))) &&
            ((this.fechaloginoperador==null && other.getFechaloginoperador()==null) || 
             (this.fechaloginoperador!=null &&
              this.fechaloginoperador.equals(other.getFechaloginoperador()))) &&
            ((this.ijareres==null && other.getIjareres()==null) || 
             (this.ijareres!=null &&
              this.ijareres.equals(other.getIjareres()))) &&
            ((this.ijgrpdetpars==null && other.getIjgrpdetpars()==null) || 
             (this.ijgrpdetpars!=null &&
              java.util.Arrays.equals(this.ijgrpdetpars, other.getIjgrpdetpars()))) &&
            ((this.ijlogcorrreqs==null && other.getIjlogcorrreqs()==null) || 
             (this.ijlogcorrreqs!=null &&
              java.util.Arrays.equals(this.ijlogcorrreqs, other.getIjlogcorrreqs()))) &&
            ((this.ijopintrasas==null && other.getIjopintrasas()==null) || 
             (this.ijopintrasas!=null &&
              java.util.Arrays.equals(this.ijopintrasas, other.getIjopintrasas()))) &&
            ((this.ijpdcapadraos==null && other.getIjpdcapadraos()==null) || 
             (this.ijpdcapadraos!=null &&
              java.util.Arrays.equals(this.ijpdcapadraos, other.getIjpdcapadraos()))) &&
            ((this.ijreapars==null && other.getIjreapars()==null) || 
             (this.ijreapars!=null &&
              java.util.Arrays.equals(this.ijreapars, other.getIjreapars()))) &&
            ((this.ijtbinjs==null && other.getIjtbinjs()==null) || 
             (this.ijtbinjs!=null &&
              java.util.Arrays.equals(this.ijtbinjs, other.getIjtbinjs()))) &&
            ((this.ijtbparauxes==null && other.getIjtbparauxes()==null) || 
             (this.ijtbparauxes!=null &&
              java.util.Arrays.equals(this.ijtbparauxes, other.getIjtbparauxes()))) &&
            ((this.ijtbpardefctrlipros==null && other.getIjtbpardefctrlipros()==null) || 
             (this.ijtbpardefctrlipros!=null &&
              java.util.Arrays.equals(this.ijtbpardefctrlipros, other.getIjtbpardefctrlipros()))) &&
            ((this.ijtbpardefsemcons==null && other.getIjtbpardefsemcons()==null) || 
             (this.ijtbpardefsemcons!=null &&
              java.util.Arrays.equals(this.ijtbpardefsemcons, other.getIjtbpardefsemcons()))) &&
            ((this.ijtbparintrasas==null && other.getIjtbparintrasas()==null) || 
             (this.ijtbparintrasas!=null &&
              java.util.Arrays.equals(this.ijtbparintrasas, other.getIjtbparintrasas()))) &&
            ((this.ijtbparreqtecespecs==null && other.getIjtbparreqtecespecs()==null) || 
             (this.ijtbparreqtecespecs!=null &&
              java.util.Arrays.equals(this.ijtbparreqtecespecs, other.getIjtbparreqtecespecs()))) &&
            ((this.mdo==null && other.getMdo()==null) || 
             (this.mdo!=null &&
              this.mdo.equals(other.getMdo()))) &&
            ((this.monittmplimite==null && other.getMonittmplimite()==null) || 
             (this.monittmplimite!=null &&
              this.monittmplimite.equals(other.getMonittmplimite()))) &&
            ((this.pa==null && other.getPa()==null) || 
             (this.pa!=null &&
              this.pa.equals(other.getPa()))) &&
            ((this.pao==null && other.getPao()==null) || 
             (this.pao!=null &&
              this.pao.equals(other.getPao()))) &&
            ((this.paradapersistente==null && other.getParadapersistente()==null) || 
             (this.paradapersistente!=null &&
              this.paradapersistente.equals(other.getParadapersistente()))) &&
            ((this.paradaprevista==null && other.getParadaprevista()==null) || 
             (this.paradaprevista!=null &&
              this.paradaprevista.equals(other.getParadaprevista()))) &&
            ((this.pcta==null && other.getPcta()==null) || 
             (this.pcta!=null &&
              this.pcta.equals(other.getPcta()))) &&
            ((this.pededrtresponsa==null && other.getPededrtresponsa()==null) || 
             (this.pededrtresponsa!=null &&
              this.pededrtresponsa.equals(other.getPededrtresponsa()))) &&
            ((this.pededrttecnico1==null && other.getPededrttecnico1()==null) || 
             (this.pededrttecnico1!=null &&
              this.pededrttecnico1.equals(other.getPededrttecnico1()))) &&
            ((this.pededrttecnico2==null && other.getPededrttecnico2()==null) || 
             (this.pededrttecnico2!=null &&
              this.pededrttecnico2.equals(other.getPededrttecnico2()))) &&
            ((this.permitecorrecao==null && other.getPermitecorrecao()==null) || 
             (this.permitecorrecao!=null &&
              this.permitecorrecao.equals(other.getPermitecorrecao()))) &&
            ((this.ptp==null && other.getPtp()==null) || 
             (this.ptp!=null &&
              this.ptp.equals(other.getPtp()))) &&
            ((this.reqparadaprep==null && other.getReqparadaprep()==null) || 
             (this.reqparadaprep!=null &&
              this.reqparadaprep.equals(other.getReqparadaprep()))) &&
            ((this.reqparadasetup==null && other.getReqparadasetup()==null) || 
             (this.reqparadasetup!=null &&
              this.reqparadasetup.equals(other.getReqparadasetup()))) &&
            ((this.requeracao==null && other.getRequeracao()==null) || 
             (this.requeracao!=null &&
              this.requeracao.equals(other.getRequeracao()))) &&
            ((this.requercancelamento==null && other.getRequercancelamento()==null) || 
             (this.requercancelamento!=null &&
              this.requercancelamento.equals(other.getRequercancelamento()))) &&
            ((this.requercausa==null && other.getRequercausa()==null) || 
             (this.requercausa!=null &&
              this.requercausa.equals(other.getRequercausa()))) &&
            ((this.requerjustificativ==null && other.getRequerjustificativ()==null) || 
             (this.requerjustificativ!=null &&
              this.requerjustificativ.equals(other.getRequerjustificativ()))) &&
            ((this.requisicaonova01==null && other.getRequisicaonova01()==null) || 
             (this.requisicaonova01!=null &&
              this.requisicaonova01.equals(other.getRequisicaonova01()))) &&
            ((this.saidademolde==null && other.getSaidademolde()==null) || 
             (this.saidademolde!=null &&
              this.saidademolde.equals(other.getSaidademolde()))) &&
            ((this.scp==null && other.getScp()==null) || 
             (this.scp!=null &&
              this.scp.equals(other.getScp()))) &&
            this.tempolimite == other.getTempolimite() &&
            ((this.teprogramado==null && other.getTeprogramado()==null) || 
             (this.teprogramado!=null &&
              this.teprogramado.equals(other.getTeprogramado()))) &&
            ((this.trocademolde==null && other.getTrocademolde()==null) || 
             (this.trocademolde!=null &&
              this.trocademolde.equals(other.getTrocademolde())));
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
        if (getCalcmtbfmttr() != null) {
            _hashCode += getCalcmtbfmttr().hashCode();
        }
        if (getCdparada() != null) {
            _hashCode += getCdparada().hashCode();
        }
        if (getDsparada() != null) {
            _hashCode += getDsparada().hashCode();
        }
        if (getEntradademolde() != null) {
            _hashCode += getEntradademolde().hashCode();
        }
        if (getExportacao001S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExportacao001S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExportacao001S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getExportacao003S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExportacao003S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExportacao003S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFds() != null) {
            _hashCode += getFds().hashCode();
        }
        if (getFechaloginoperador() != null) {
            _hashCode += getFechaloginoperador().hashCode();
        }
        if (getIjareres() != null) {
            _hashCode += getIjareres().hashCode();
        }
        if (getIjgrpdetpars() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpdetpars());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpdetpars(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjlogcorrreqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjlogcorrreqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjlogcorrreqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjopintrasas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjopintrasas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjopintrasas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjpdcapadraos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjpdcapadraos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjpdcapadraos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjreapars() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreapars());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreapars(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbinjs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbinjs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbinjs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbparauxes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbparauxes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbparauxes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbpardefctrlipros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbpardefctrlipros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbpardefctrlipros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbpardefsemcons() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbpardefsemcons());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbpardefsemcons(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbparintrasas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbparintrasas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbparintrasas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbparreqtecespecs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbparreqtecespecs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbparreqtecespecs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMdo() != null) {
            _hashCode += getMdo().hashCode();
        }
        if (getMonittmplimite() != null) {
            _hashCode += getMonittmplimite().hashCode();
        }
        if (getPa() != null) {
            _hashCode += getPa().hashCode();
        }
        if (getPao() != null) {
            _hashCode += getPao().hashCode();
        }
        if (getParadapersistente() != null) {
            _hashCode += getParadapersistente().hashCode();
        }
        if (getParadaprevista() != null) {
            _hashCode += getParadaprevista().hashCode();
        }
        if (getPcta() != null) {
            _hashCode += getPcta().hashCode();
        }
        if (getPededrtresponsa() != null) {
            _hashCode += getPededrtresponsa().hashCode();
        }
        if (getPededrttecnico1() != null) {
            _hashCode += getPededrttecnico1().hashCode();
        }
        if (getPededrttecnico2() != null) {
            _hashCode += getPededrttecnico2().hashCode();
        }
        if (getPermitecorrecao() != null) {
            _hashCode += getPermitecorrecao().hashCode();
        }
        if (getPtp() != null) {
            _hashCode += getPtp().hashCode();
        }
        if (getReqparadaprep() != null) {
            _hashCode += getReqparadaprep().hashCode();
        }
        if (getReqparadasetup() != null) {
            _hashCode += getReqparadasetup().hashCode();
        }
        if (getRequeracao() != null) {
            _hashCode += getRequeracao().hashCode();
        }
        if (getRequercancelamento() != null) {
            _hashCode += getRequercancelamento().hashCode();
        }
        if (getRequercausa() != null) {
            _hashCode += getRequercausa().hashCode();
        }
        if (getRequerjustificativ() != null) {
            _hashCode += getRequerjustificativ().hashCode();
        }
        if (getRequisicaonova01() != null) {
            _hashCode += getRequisicaonova01().hashCode();
        }
        if (getSaidademolde() != null) {
            _hashCode += getSaidademolde().hashCode();
        }
        if (getScp() != null) {
            _hashCode += getScp().hashCode();
        }
        _hashCode += new Double(getTempolimite()).hashCode();
        if (getTeprogramado() != null) {
            _hashCode += getTeprogramado().hashCode();
        }
        if (getTrocademolde() != null) {
            _hashCode += getTrocademolde().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbpar.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpar"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calcmtbfmttr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "calcmtbfmttr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entradademolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "entradademolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exportacao001S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exportacao001s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "exportacao001"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exportacao003S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exportacao003s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "exportacao003"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaloginoperador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaloginoperador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijareres");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijareres"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijareres"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpdetpars");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpdetpars"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetpar"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijlogcorrreqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijlogcorrreqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlogcorrreq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopintrasas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopintrasas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopintrasa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijpdcapadraos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijpdcapadraos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcapadrao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreapars");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreapars"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreapar"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinjs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinjs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbparauxes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbparauxes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbparaux"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpardefctrlipros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpardefctrlipros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpardefctrlipro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpardefsemcons");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpardefsemcons"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpardefsemcon"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbparintrasas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbparintrasas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbparintrasa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbparreqtecespecs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbparreqtecespecs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbparreqtecespec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mdo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mdo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monittmplimite");
        elemField.setXmlName(new javax.xml.namespace.QName("", "monittmplimite"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradapersistente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradapersistente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaprevista");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaprevista"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pededrtresponsa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pededrtresponsa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pededrttecnico1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pededrttecnico1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pededrttecnico2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pededrttecnico2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("permitecorrecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "permitecorrecao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ptp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ptp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reqparadaprep");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reqparadaprep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reqparadasetup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reqparadasetup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requeracao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requeracao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requercancelamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requercancelamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requercausa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requercausa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requerjustificativ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requerjustificativ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requisicaonova01");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requisicaonova01"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saidademolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "saidademolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempolimite");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempolimite"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("teprogramado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "teprogramado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trocademolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "trocademolde"));
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
