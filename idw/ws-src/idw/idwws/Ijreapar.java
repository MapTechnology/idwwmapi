/**
 * Ijreapar.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijreapar  implements java.io.Serializable {
    private java.math.BigDecimal acumulado;

    private java.lang.String cdestruturaentrada;

    private java.lang.String cdmoldeentrada;

    private java.util.Calendar dthrextrtmplimite;

    private java.util.Calendar dthrfparada;

    private java.util.Calendar dthrivalcic;

    private java.util.Calendar dthrivalestru;

    private java.math.BigDecimal estourotempolimite;

    private org.apache.axis.types.UnsignedShort fds;

    private idw.idwws.IjreaparId id;

    private idw.idwws.Ijctrliniproc ijctrliniproc;

    private idw.idwws.Ijestmol ijestmol;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijreaparintbet[] ijreaparintbets;

    private idw.idwws.Ijreaparintrasalog[] ijreaparintrasalogs;

    private idw.idwws.Ijreaparintrasa[] ijreaparintrasas;

    private idw.idwws.Ijreaparoprd[] ijreaparoprds;

    private idw.idwws.Ijtbaco ijtbaco;

    private idw.idwws.Ijtbcau ijtbcau;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbjup ijtbjup;

    private idw.idwws.Ijtbpar ijtbpar;

    private idw.idwws.Ijtbusu ijtbusuByDrtecnico1;

    private idw.idwws.Ijtbusu ijtbusuByDrtresponsa;

    private idw.idwws.Ijtbusu ijtbusuByDrttecnico2;

    private org.apache.axis.types.UnsignedShort mdo;

    private org.apache.axis.types.UnsignedShort pa;

    private org.apache.axis.types.UnsignedShort pao;

    private java.math.BigDecimal paradaconsolidada;

    private java.math.BigDecimal paradaprep;

    private java.math.BigDecimal paradaprevista;

    private java.math.BigDecimal paradasetup;

    private org.apache.axis.types.UnsignedShort pcta;

    private org.apache.axis.types.UnsignedShort ptp;

    private java.math.BigDecimal quedaescravo;

    private org.apache.axis.types.UnsignedShort scp;

    private java.math.BigDecimal tempoparada;

    public Ijreapar() {
    }

    public Ijreapar(
           java.math.BigDecimal acumulado,
           java.lang.String cdestruturaentrada,
           java.lang.String cdmoldeentrada,
           java.util.Calendar dthrextrtmplimite,
           java.util.Calendar dthrfparada,
           java.util.Calendar dthrivalcic,
           java.util.Calendar dthrivalestru,
           java.math.BigDecimal estourotempolimite,
           org.apache.axis.types.UnsignedShort fds,
           idw.idwws.IjreaparId id,
           idw.idwws.Ijctrliniproc ijctrliniproc,
           idw.idwws.Ijestmol ijestmol,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijreaparintbet[] ijreaparintbets,
           idw.idwws.Ijreaparintrasalog[] ijreaparintrasalogs,
           idw.idwws.Ijreaparintrasa[] ijreaparintrasas,
           idw.idwws.Ijreaparoprd[] ijreaparoprds,
           idw.idwws.Ijtbaco ijtbaco,
           idw.idwws.Ijtbcau ijtbcau,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbjup ijtbjup,
           idw.idwws.Ijtbpar ijtbpar,
           idw.idwws.Ijtbusu ijtbusuByDrtecnico1,
           idw.idwws.Ijtbusu ijtbusuByDrtresponsa,
           idw.idwws.Ijtbusu ijtbusuByDrttecnico2,
           org.apache.axis.types.UnsignedShort mdo,
           org.apache.axis.types.UnsignedShort pa,
           org.apache.axis.types.UnsignedShort pao,
           java.math.BigDecimal paradaconsolidada,
           java.math.BigDecimal paradaprep,
           java.math.BigDecimal paradaprevista,
           java.math.BigDecimal paradasetup,
           org.apache.axis.types.UnsignedShort pcta,
           org.apache.axis.types.UnsignedShort ptp,
           java.math.BigDecimal quedaescravo,
           org.apache.axis.types.UnsignedShort scp,
           java.math.BigDecimal tempoparada) {
           this.acumulado = acumulado;
           this.cdestruturaentrada = cdestruturaentrada;
           this.cdmoldeentrada = cdmoldeentrada;
           this.dthrextrtmplimite = dthrextrtmplimite;
           this.dthrfparada = dthrfparada;
           this.dthrivalcic = dthrivalcic;
           this.dthrivalestru = dthrivalestru;
           this.estourotempolimite = estourotempolimite;
           this.fds = fds;
           this.id = id;
           this.ijctrliniproc = ijctrliniproc;
           this.ijestmol = ijestmol;
           this.ijop = ijop;
           this.ijreaparintbets = ijreaparintbets;
           this.ijreaparintrasalogs = ijreaparintrasalogs;
           this.ijreaparintrasas = ijreaparintrasas;
           this.ijreaparoprds = ijreaparoprds;
           this.ijtbaco = ijtbaco;
           this.ijtbcau = ijtbcau;
           this.ijtbinj = ijtbinj;
           this.ijtbjup = ijtbjup;
           this.ijtbpar = ijtbpar;
           this.ijtbusuByDrtecnico1 = ijtbusuByDrtecnico1;
           this.ijtbusuByDrtresponsa = ijtbusuByDrtresponsa;
           this.ijtbusuByDrttecnico2 = ijtbusuByDrttecnico2;
           this.mdo = mdo;
           this.pa = pa;
           this.pao = pao;
           this.paradaconsolidada = paradaconsolidada;
           this.paradaprep = paradaprep;
           this.paradaprevista = paradaprevista;
           this.paradasetup = paradasetup;
           this.pcta = pcta;
           this.ptp = ptp;
           this.quedaescravo = quedaescravo;
           this.scp = scp;
           this.tempoparada = tempoparada;
    }


    /**
     * Gets the acumulado value for this Ijreapar.
     * 
     * @return acumulado
     */
    public java.math.BigDecimal getAcumulado() {
        return acumulado;
    }


    /**
     * Sets the acumulado value for this Ijreapar.
     * 
     * @param acumulado
     */
    public void setAcumulado(java.math.BigDecimal acumulado) {
        this.acumulado = acumulado;
    }


    /**
     * Gets the cdestruturaentrada value for this Ijreapar.
     * 
     * @return cdestruturaentrada
     */
    public java.lang.String getCdestruturaentrada() {
        return cdestruturaentrada;
    }


    /**
     * Sets the cdestruturaentrada value for this Ijreapar.
     * 
     * @param cdestruturaentrada
     */
    public void setCdestruturaentrada(java.lang.String cdestruturaentrada) {
        this.cdestruturaentrada = cdestruturaentrada;
    }


    /**
     * Gets the cdmoldeentrada value for this Ijreapar.
     * 
     * @return cdmoldeentrada
     */
    public java.lang.String getCdmoldeentrada() {
        return cdmoldeentrada;
    }


    /**
     * Sets the cdmoldeentrada value for this Ijreapar.
     * 
     * @param cdmoldeentrada
     */
    public void setCdmoldeentrada(java.lang.String cdmoldeentrada) {
        this.cdmoldeentrada = cdmoldeentrada;
    }


    /**
     * Gets the dthrextrtmplimite value for this Ijreapar.
     * 
     * @return dthrextrtmplimite
     */
    public java.util.Calendar getDthrextrtmplimite() {
        return dthrextrtmplimite;
    }


    /**
     * Sets the dthrextrtmplimite value for this Ijreapar.
     * 
     * @param dthrextrtmplimite
     */
    public void setDthrextrtmplimite(java.util.Calendar dthrextrtmplimite) {
        this.dthrextrtmplimite = dthrextrtmplimite;
    }


    /**
     * Gets the dthrfparada value for this Ijreapar.
     * 
     * @return dthrfparada
     */
    public java.util.Calendar getDthrfparada() {
        return dthrfparada;
    }


    /**
     * Sets the dthrfparada value for this Ijreapar.
     * 
     * @param dthrfparada
     */
    public void setDthrfparada(java.util.Calendar dthrfparada) {
        this.dthrfparada = dthrfparada;
    }


    /**
     * Gets the dthrivalcic value for this Ijreapar.
     * 
     * @return dthrivalcic
     */
    public java.util.Calendar getDthrivalcic() {
        return dthrivalcic;
    }


    /**
     * Sets the dthrivalcic value for this Ijreapar.
     * 
     * @param dthrivalcic
     */
    public void setDthrivalcic(java.util.Calendar dthrivalcic) {
        this.dthrivalcic = dthrivalcic;
    }


    /**
     * Gets the dthrivalestru value for this Ijreapar.
     * 
     * @return dthrivalestru
     */
    public java.util.Calendar getDthrivalestru() {
        return dthrivalestru;
    }


    /**
     * Sets the dthrivalestru value for this Ijreapar.
     * 
     * @param dthrivalestru
     */
    public void setDthrivalestru(java.util.Calendar dthrivalestru) {
        this.dthrivalestru = dthrivalestru;
    }


    /**
     * Gets the estourotempolimite value for this Ijreapar.
     * 
     * @return estourotempolimite
     */
    public java.math.BigDecimal getEstourotempolimite() {
        return estourotempolimite;
    }


    /**
     * Sets the estourotempolimite value for this Ijreapar.
     * 
     * @param estourotempolimite
     */
    public void setEstourotempolimite(java.math.BigDecimal estourotempolimite) {
        this.estourotempolimite = estourotempolimite;
    }


    /**
     * Gets the fds value for this Ijreapar.
     * 
     * @return fds
     */
    public org.apache.axis.types.UnsignedShort getFds() {
        return fds;
    }


    /**
     * Sets the fds value for this Ijreapar.
     * 
     * @param fds
     */
    public void setFds(org.apache.axis.types.UnsignedShort fds) {
        this.fds = fds;
    }


    /**
     * Gets the id value for this Ijreapar.
     * 
     * @return id
     */
    public idw.idwws.IjreaparId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijreapar.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjreaparId id) {
        this.id = id;
    }


    /**
     * Gets the ijctrliniproc value for this Ijreapar.
     * 
     * @return ijctrliniproc
     */
    public idw.idwws.Ijctrliniproc getIjctrliniproc() {
        return ijctrliniproc;
    }


    /**
     * Sets the ijctrliniproc value for this Ijreapar.
     * 
     * @param ijctrliniproc
     */
    public void setIjctrliniproc(idw.idwws.Ijctrliniproc ijctrliniproc) {
        this.ijctrliniproc = ijctrliniproc;
    }


    /**
     * Gets the ijestmol value for this Ijreapar.
     * 
     * @return ijestmol
     */
    public idw.idwws.Ijestmol getIjestmol() {
        return ijestmol;
    }


    /**
     * Sets the ijestmol value for this Ijreapar.
     * 
     * @param ijestmol
     */
    public void setIjestmol(idw.idwws.Ijestmol ijestmol) {
        this.ijestmol = ijestmol;
    }


    /**
     * Gets the ijop value for this Ijreapar.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijreapar.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijreaparintbets value for this Ijreapar.
     * 
     * @return ijreaparintbets
     */
    public idw.idwws.Ijreaparintbet[] getIjreaparintbets() {
        return ijreaparintbets;
    }


    /**
     * Sets the ijreaparintbets value for this Ijreapar.
     * 
     * @param ijreaparintbets
     */
    public void setIjreaparintbets(idw.idwws.Ijreaparintbet[] ijreaparintbets) {
        this.ijreaparintbets = ijreaparintbets;
    }

    public idw.idwws.Ijreaparintbet getIjreaparintbets(int i) {
        return this.ijreaparintbets[i];
    }

    public void setIjreaparintbets(int i, idw.idwws.Ijreaparintbet _value) {
        this.ijreaparintbets[i] = _value;
    }


    /**
     * Gets the ijreaparintrasalogs value for this Ijreapar.
     * 
     * @return ijreaparintrasalogs
     */
    public idw.idwws.Ijreaparintrasalog[] getIjreaparintrasalogs() {
        return ijreaparintrasalogs;
    }


    /**
     * Sets the ijreaparintrasalogs value for this Ijreapar.
     * 
     * @param ijreaparintrasalogs
     */
    public void setIjreaparintrasalogs(idw.idwws.Ijreaparintrasalog[] ijreaparintrasalogs) {
        this.ijreaparintrasalogs = ijreaparintrasalogs;
    }

    public idw.idwws.Ijreaparintrasalog getIjreaparintrasalogs(int i) {
        return this.ijreaparintrasalogs[i];
    }

    public void setIjreaparintrasalogs(int i, idw.idwws.Ijreaparintrasalog _value) {
        this.ijreaparintrasalogs[i] = _value;
    }


    /**
     * Gets the ijreaparintrasas value for this Ijreapar.
     * 
     * @return ijreaparintrasas
     */
    public idw.idwws.Ijreaparintrasa[] getIjreaparintrasas() {
        return ijreaparintrasas;
    }


    /**
     * Sets the ijreaparintrasas value for this Ijreapar.
     * 
     * @param ijreaparintrasas
     */
    public void setIjreaparintrasas(idw.idwws.Ijreaparintrasa[] ijreaparintrasas) {
        this.ijreaparintrasas = ijreaparintrasas;
    }

    public idw.idwws.Ijreaparintrasa getIjreaparintrasas(int i) {
        return this.ijreaparintrasas[i];
    }

    public void setIjreaparintrasas(int i, idw.idwws.Ijreaparintrasa _value) {
        this.ijreaparintrasas[i] = _value;
    }


    /**
     * Gets the ijreaparoprds value for this Ijreapar.
     * 
     * @return ijreaparoprds
     */
    public idw.idwws.Ijreaparoprd[] getIjreaparoprds() {
        return ijreaparoprds;
    }


    /**
     * Sets the ijreaparoprds value for this Ijreapar.
     * 
     * @param ijreaparoprds
     */
    public void setIjreaparoprds(idw.idwws.Ijreaparoprd[] ijreaparoprds) {
        this.ijreaparoprds = ijreaparoprds;
    }

    public idw.idwws.Ijreaparoprd getIjreaparoprds(int i) {
        return this.ijreaparoprds[i];
    }

    public void setIjreaparoprds(int i, idw.idwws.Ijreaparoprd _value) {
        this.ijreaparoprds[i] = _value;
    }


    /**
     * Gets the ijtbaco value for this Ijreapar.
     * 
     * @return ijtbaco
     */
    public idw.idwws.Ijtbaco getIjtbaco() {
        return ijtbaco;
    }


    /**
     * Sets the ijtbaco value for this Ijreapar.
     * 
     * @param ijtbaco
     */
    public void setIjtbaco(idw.idwws.Ijtbaco ijtbaco) {
        this.ijtbaco = ijtbaco;
    }


    /**
     * Gets the ijtbcau value for this Ijreapar.
     * 
     * @return ijtbcau
     */
    public idw.idwws.Ijtbcau getIjtbcau() {
        return ijtbcau;
    }


    /**
     * Sets the ijtbcau value for this Ijreapar.
     * 
     * @param ijtbcau
     */
    public void setIjtbcau(idw.idwws.Ijtbcau ijtbcau) {
        this.ijtbcau = ijtbcau;
    }


    /**
     * Gets the ijtbinj value for this Ijreapar.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijreapar.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbjup value for this Ijreapar.
     * 
     * @return ijtbjup
     */
    public idw.idwws.Ijtbjup getIjtbjup() {
        return ijtbjup;
    }


    /**
     * Sets the ijtbjup value for this Ijreapar.
     * 
     * @param ijtbjup
     */
    public void setIjtbjup(idw.idwws.Ijtbjup ijtbjup) {
        this.ijtbjup = ijtbjup;
    }


    /**
     * Gets the ijtbpar value for this Ijreapar.
     * 
     * @return ijtbpar
     */
    public idw.idwws.Ijtbpar getIjtbpar() {
        return ijtbpar;
    }


    /**
     * Sets the ijtbpar value for this Ijreapar.
     * 
     * @param ijtbpar
     */
    public void setIjtbpar(idw.idwws.Ijtbpar ijtbpar) {
        this.ijtbpar = ijtbpar;
    }


    /**
     * Gets the ijtbusuByDrtecnico1 value for this Ijreapar.
     * 
     * @return ijtbusuByDrtecnico1
     */
    public idw.idwws.Ijtbusu getIjtbusuByDrtecnico1() {
        return ijtbusuByDrtecnico1;
    }


    /**
     * Sets the ijtbusuByDrtecnico1 value for this Ijreapar.
     * 
     * @param ijtbusuByDrtecnico1
     */
    public void setIjtbusuByDrtecnico1(idw.idwws.Ijtbusu ijtbusuByDrtecnico1) {
        this.ijtbusuByDrtecnico1 = ijtbusuByDrtecnico1;
    }


    /**
     * Gets the ijtbusuByDrtresponsa value for this Ijreapar.
     * 
     * @return ijtbusuByDrtresponsa
     */
    public idw.idwws.Ijtbusu getIjtbusuByDrtresponsa() {
        return ijtbusuByDrtresponsa;
    }


    /**
     * Sets the ijtbusuByDrtresponsa value for this Ijreapar.
     * 
     * @param ijtbusuByDrtresponsa
     */
    public void setIjtbusuByDrtresponsa(idw.idwws.Ijtbusu ijtbusuByDrtresponsa) {
        this.ijtbusuByDrtresponsa = ijtbusuByDrtresponsa;
    }


    /**
     * Gets the ijtbusuByDrttecnico2 value for this Ijreapar.
     * 
     * @return ijtbusuByDrttecnico2
     */
    public idw.idwws.Ijtbusu getIjtbusuByDrttecnico2() {
        return ijtbusuByDrttecnico2;
    }


    /**
     * Sets the ijtbusuByDrttecnico2 value for this Ijreapar.
     * 
     * @param ijtbusuByDrttecnico2
     */
    public void setIjtbusuByDrttecnico2(idw.idwws.Ijtbusu ijtbusuByDrttecnico2) {
        this.ijtbusuByDrttecnico2 = ijtbusuByDrttecnico2;
    }


    /**
     * Gets the mdo value for this Ijreapar.
     * 
     * @return mdo
     */
    public org.apache.axis.types.UnsignedShort getMdo() {
        return mdo;
    }


    /**
     * Sets the mdo value for this Ijreapar.
     * 
     * @param mdo
     */
    public void setMdo(org.apache.axis.types.UnsignedShort mdo) {
        this.mdo = mdo;
    }


    /**
     * Gets the pa value for this Ijreapar.
     * 
     * @return pa
     */
    public org.apache.axis.types.UnsignedShort getPa() {
        return pa;
    }


    /**
     * Sets the pa value for this Ijreapar.
     * 
     * @param pa
     */
    public void setPa(org.apache.axis.types.UnsignedShort pa) {
        this.pa = pa;
    }


    /**
     * Gets the pao value for this Ijreapar.
     * 
     * @return pao
     */
    public org.apache.axis.types.UnsignedShort getPao() {
        return pao;
    }


    /**
     * Sets the pao value for this Ijreapar.
     * 
     * @param pao
     */
    public void setPao(org.apache.axis.types.UnsignedShort pao) {
        this.pao = pao;
    }


    /**
     * Gets the paradaconsolidada value for this Ijreapar.
     * 
     * @return paradaconsolidada
     */
    public java.math.BigDecimal getParadaconsolidada() {
        return paradaconsolidada;
    }


    /**
     * Sets the paradaconsolidada value for this Ijreapar.
     * 
     * @param paradaconsolidada
     */
    public void setParadaconsolidada(java.math.BigDecimal paradaconsolidada) {
        this.paradaconsolidada = paradaconsolidada;
    }


    /**
     * Gets the paradaprep value for this Ijreapar.
     * 
     * @return paradaprep
     */
    public java.math.BigDecimal getParadaprep() {
        return paradaprep;
    }


    /**
     * Sets the paradaprep value for this Ijreapar.
     * 
     * @param paradaprep
     */
    public void setParadaprep(java.math.BigDecimal paradaprep) {
        this.paradaprep = paradaprep;
    }


    /**
     * Gets the paradaprevista value for this Ijreapar.
     * 
     * @return paradaprevista
     */
    public java.math.BigDecimal getParadaprevista() {
        return paradaprevista;
    }


    /**
     * Sets the paradaprevista value for this Ijreapar.
     * 
     * @param paradaprevista
     */
    public void setParadaprevista(java.math.BigDecimal paradaprevista) {
        this.paradaprevista = paradaprevista;
    }


    /**
     * Gets the paradasetup value for this Ijreapar.
     * 
     * @return paradasetup
     */
    public java.math.BigDecimal getParadasetup() {
        return paradasetup;
    }


    /**
     * Sets the paradasetup value for this Ijreapar.
     * 
     * @param paradasetup
     */
    public void setParadasetup(java.math.BigDecimal paradasetup) {
        this.paradasetup = paradasetup;
    }


    /**
     * Gets the pcta value for this Ijreapar.
     * 
     * @return pcta
     */
    public org.apache.axis.types.UnsignedShort getPcta() {
        return pcta;
    }


    /**
     * Sets the pcta value for this Ijreapar.
     * 
     * @param pcta
     */
    public void setPcta(org.apache.axis.types.UnsignedShort pcta) {
        this.pcta = pcta;
    }


    /**
     * Gets the ptp value for this Ijreapar.
     * 
     * @return ptp
     */
    public org.apache.axis.types.UnsignedShort getPtp() {
        return ptp;
    }


    /**
     * Sets the ptp value for this Ijreapar.
     * 
     * @param ptp
     */
    public void setPtp(org.apache.axis.types.UnsignedShort ptp) {
        this.ptp = ptp;
    }


    /**
     * Gets the quedaescravo value for this Ijreapar.
     * 
     * @return quedaescravo
     */
    public java.math.BigDecimal getQuedaescravo() {
        return quedaescravo;
    }


    /**
     * Sets the quedaescravo value for this Ijreapar.
     * 
     * @param quedaescravo
     */
    public void setQuedaescravo(java.math.BigDecimal quedaescravo) {
        this.quedaescravo = quedaescravo;
    }


    /**
     * Gets the scp value for this Ijreapar.
     * 
     * @return scp
     */
    public org.apache.axis.types.UnsignedShort getScp() {
        return scp;
    }


    /**
     * Sets the scp value for this Ijreapar.
     * 
     * @param scp
     */
    public void setScp(org.apache.axis.types.UnsignedShort scp) {
        this.scp = scp;
    }


    /**
     * Gets the tempoparada value for this Ijreapar.
     * 
     * @return tempoparada
     */
    public java.math.BigDecimal getTempoparada() {
        return tempoparada;
    }


    /**
     * Sets the tempoparada value for this Ijreapar.
     * 
     * @param tempoparada
     */
    public void setTempoparada(java.math.BigDecimal tempoparada) {
        this.tempoparada = tempoparada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijreapar)) return false;
        Ijreapar other = (Ijreapar) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.acumulado==null && other.getAcumulado()==null) || 
             (this.acumulado!=null &&
              this.acumulado.equals(other.getAcumulado()))) &&
            ((this.cdestruturaentrada==null && other.getCdestruturaentrada()==null) || 
             (this.cdestruturaentrada!=null &&
              this.cdestruturaentrada.equals(other.getCdestruturaentrada()))) &&
            ((this.cdmoldeentrada==null && other.getCdmoldeentrada()==null) || 
             (this.cdmoldeentrada!=null &&
              this.cdmoldeentrada.equals(other.getCdmoldeentrada()))) &&
            ((this.dthrextrtmplimite==null && other.getDthrextrtmplimite()==null) || 
             (this.dthrextrtmplimite!=null &&
              this.dthrextrtmplimite.equals(other.getDthrextrtmplimite()))) &&
            ((this.dthrfparada==null && other.getDthrfparada()==null) || 
             (this.dthrfparada!=null &&
              this.dthrfparada.equals(other.getDthrfparada()))) &&
            ((this.dthrivalcic==null && other.getDthrivalcic()==null) || 
             (this.dthrivalcic!=null &&
              this.dthrivalcic.equals(other.getDthrivalcic()))) &&
            ((this.dthrivalestru==null && other.getDthrivalestru()==null) || 
             (this.dthrivalestru!=null &&
              this.dthrivalestru.equals(other.getDthrivalestru()))) &&
            ((this.estourotempolimite==null && other.getEstourotempolimite()==null) || 
             (this.estourotempolimite!=null &&
              this.estourotempolimite.equals(other.getEstourotempolimite()))) &&
            ((this.fds==null && other.getFds()==null) || 
             (this.fds!=null &&
              this.fds.equals(other.getFds()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijctrliniproc==null && other.getIjctrliniproc()==null) || 
             (this.ijctrliniproc!=null &&
              this.ijctrliniproc.equals(other.getIjctrliniproc()))) &&
            ((this.ijestmol==null && other.getIjestmol()==null) || 
             (this.ijestmol!=null &&
              this.ijestmol.equals(other.getIjestmol()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijreaparintbets==null && other.getIjreaparintbets()==null) || 
             (this.ijreaparintbets!=null &&
              java.util.Arrays.equals(this.ijreaparintbets, other.getIjreaparintbets()))) &&
            ((this.ijreaparintrasalogs==null && other.getIjreaparintrasalogs()==null) || 
             (this.ijreaparintrasalogs!=null &&
              java.util.Arrays.equals(this.ijreaparintrasalogs, other.getIjreaparintrasalogs()))) &&
            ((this.ijreaparintrasas==null && other.getIjreaparintrasas()==null) || 
             (this.ijreaparintrasas!=null &&
              java.util.Arrays.equals(this.ijreaparintrasas, other.getIjreaparintrasas()))) &&
            ((this.ijreaparoprds==null && other.getIjreaparoprds()==null) || 
             (this.ijreaparoprds!=null &&
              java.util.Arrays.equals(this.ijreaparoprds, other.getIjreaparoprds()))) &&
            ((this.ijtbaco==null && other.getIjtbaco()==null) || 
             (this.ijtbaco!=null &&
              this.ijtbaco.equals(other.getIjtbaco()))) &&
            ((this.ijtbcau==null && other.getIjtbcau()==null) || 
             (this.ijtbcau!=null &&
              this.ijtbcau.equals(other.getIjtbcau()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbjup==null && other.getIjtbjup()==null) || 
             (this.ijtbjup!=null &&
              this.ijtbjup.equals(other.getIjtbjup()))) &&
            ((this.ijtbpar==null && other.getIjtbpar()==null) || 
             (this.ijtbpar!=null &&
              this.ijtbpar.equals(other.getIjtbpar()))) &&
            ((this.ijtbusuByDrtecnico1==null && other.getIjtbusuByDrtecnico1()==null) || 
             (this.ijtbusuByDrtecnico1!=null &&
              this.ijtbusuByDrtecnico1.equals(other.getIjtbusuByDrtecnico1()))) &&
            ((this.ijtbusuByDrtresponsa==null && other.getIjtbusuByDrtresponsa()==null) || 
             (this.ijtbusuByDrtresponsa!=null &&
              this.ijtbusuByDrtresponsa.equals(other.getIjtbusuByDrtresponsa()))) &&
            ((this.ijtbusuByDrttecnico2==null && other.getIjtbusuByDrttecnico2()==null) || 
             (this.ijtbusuByDrttecnico2!=null &&
              this.ijtbusuByDrttecnico2.equals(other.getIjtbusuByDrttecnico2()))) &&
            ((this.mdo==null && other.getMdo()==null) || 
             (this.mdo!=null &&
              this.mdo.equals(other.getMdo()))) &&
            ((this.pa==null && other.getPa()==null) || 
             (this.pa!=null &&
              this.pa.equals(other.getPa()))) &&
            ((this.pao==null && other.getPao()==null) || 
             (this.pao!=null &&
              this.pao.equals(other.getPao()))) &&
            ((this.paradaconsolidada==null && other.getParadaconsolidada()==null) || 
             (this.paradaconsolidada!=null &&
              this.paradaconsolidada.equals(other.getParadaconsolidada()))) &&
            ((this.paradaprep==null && other.getParadaprep()==null) || 
             (this.paradaprep!=null &&
              this.paradaprep.equals(other.getParadaprep()))) &&
            ((this.paradaprevista==null && other.getParadaprevista()==null) || 
             (this.paradaprevista!=null &&
              this.paradaprevista.equals(other.getParadaprevista()))) &&
            ((this.paradasetup==null && other.getParadasetup()==null) || 
             (this.paradasetup!=null &&
              this.paradasetup.equals(other.getParadasetup()))) &&
            ((this.pcta==null && other.getPcta()==null) || 
             (this.pcta!=null &&
              this.pcta.equals(other.getPcta()))) &&
            ((this.ptp==null && other.getPtp()==null) || 
             (this.ptp!=null &&
              this.ptp.equals(other.getPtp()))) &&
            ((this.quedaescravo==null && other.getQuedaescravo()==null) || 
             (this.quedaescravo!=null &&
              this.quedaescravo.equals(other.getQuedaescravo()))) &&
            ((this.scp==null && other.getScp()==null) || 
             (this.scp!=null &&
              this.scp.equals(other.getScp()))) &&
            ((this.tempoparada==null && other.getTempoparada()==null) || 
             (this.tempoparada!=null &&
              this.tempoparada.equals(other.getTempoparada())));
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
        if (getAcumulado() != null) {
            _hashCode += getAcumulado().hashCode();
        }
        if (getCdestruturaentrada() != null) {
            _hashCode += getCdestruturaentrada().hashCode();
        }
        if (getCdmoldeentrada() != null) {
            _hashCode += getCdmoldeentrada().hashCode();
        }
        if (getDthrextrtmplimite() != null) {
            _hashCode += getDthrextrtmplimite().hashCode();
        }
        if (getDthrfparada() != null) {
            _hashCode += getDthrfparada().hashCode();
        }
        if (getDthrivalcic() != null) {
            _hashCode += getDthrivalcic().hashCode();
        }
        if (getDthrivalestru() != null) {
            _hashCode += getDthrivalestru().hashCode();
        }
        if (getEstourotempolimite() != null) {
            _hashCode += getEstourotempolimite().hashCode();
        }
        if (getFds() != null) {
            _hashCode += getFds().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjctrliniproc() != null) {
            _hashCode += getIjctrliniproc().hashCode();
        }
        if (getIjestmol() != null) {
            _hashCode += getIjestmol().hashCode();
        }
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjreaparintbets() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreaparintbets());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreaparintbets(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjreaparintrasalogs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreaparintrasalogs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreaparintrasalogs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjreaparintrasas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreaparintrasas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreaparintrasas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjreaparoprds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreaparoprds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreaparoprds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbaco() != null) {
            _hashCode += getIjtbaco().hashCode();
        }
        if (getIjtbcau() != null) {
            _hashCode += getIjtbcau().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbjup() != null) {
            _hashCode += getIjtbjup().hashCode();
        }
        if (getIjtbpar() != null) {
            _hashCode += getIjtbpar().hashCode();
        }
        if (getIjtbusuByDrtecnico1() != null) {
            _hashCode += getIjtbusuByDrtecnico1().hashCode();
        }
        if (getIjtbusuByDrtresponsa() != null) {
            _hashCode += getIjtbusuByDrtresponsa().hashCode();
        }
        if (getIjtbusuByDrttecnico2() != null) {
            _hashCode += getIjtbusuByDrttecnico2().hashCode();
        }
        if (getMdo() != null) {
            _hashCode += getMdo().hashCode();
        }
        if (getPa() != null) {
            _hashCode += getPa().hashCode();
        }
        if (getPao() != null) {
            _hashCode += getPao().hashCode();
        }
        if (getParadaconsolidada() != null) {
            _hashCode += getParadaconsolidada().hashCode();
        }
        if (getParadaprep() != null) {
            _hashCode += getParadaprep().hashCode();
        }
        if (getParadaprevista() != null) {
            _hashCode += getParadaprevista().hashCode();
        }
        if (getParadasetup() != null) {
            _hashCode += getParadasetup().hashCode();
        }
        if (getPcta() != null) {
            _hashCode += getPcta().hashCode();
        }
        if (getPtp() != null) {
            _hashCode += getPtp().hashCode();
        }
        if (getQuedaescravo() != null) {
            _hashCode += getQuedaescravo().hashCode();
        }
        if (getScp() != null) {
            _hashCode += getScp().hashCode();
        }
        if (getTempoparada() != null) {
            _hashCode += getTempoparada().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijreapar.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreapar"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acumulado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "acumulado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdestruturaentrada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdestruturaentrada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmoldeentrada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmoldeentrada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrextrtmplimite");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrextrtmplimite"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrivalcic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrivalcic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrivalestru");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrivalestru"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estourotempolimite");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estourotempolimite"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreaparId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrliniproc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrliniproc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrliniproc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijestmol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijestmol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreaparintbets");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreaparintbets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreaparintbet"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreaparintrasalogs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreaparintrasalogs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreaparintrasalog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreaparintrasas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreaparintrasas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreaparintrasa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreaparoprds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreaparoprds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreaparoprd"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbaco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbaco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbaco"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbcau");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbcau"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcau"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbjup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbjup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbjup"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpar"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusuByDrtecnico1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByDrtecnico1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusuByDrtresponsa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByDrtresponsa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusuByDrttecnico2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByDrttecnico2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mdo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mdo"));
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
        elemField.setFieldName("paradaconsolidada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaconsolidada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paradaprep");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradaprep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("paradasetup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paradasetup"));
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
        elemField.setFieldName("ptp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ptp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quedaescravo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quedaescravo"));
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
        elemField.setFieldName("tempoparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoparada"));
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
