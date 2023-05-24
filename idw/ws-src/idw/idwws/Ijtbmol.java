/**
 * Ijtbmol.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbmol  implements java.io.Serializable {
    private java.lang.Double altura;

    private java.lang.String cdglobal;

    private java.lang.String cdmolde;

    private java.lang.String cdmolestendido;

    private java.lang.String dsmolde;

    private java.util.Calendar dtchegada;

    private java.util.Calendar dtcompra;

    private java.util.Calendar dtinstalacao;

    private java.util.Calendar dtsaida;

    private idw.idwws.Exportacao006[] exportacao006S;

    private java.lang.Double freqmanutprev;

    private idw.idwws.Ijdeparamol[] ijdeparamols;

    private idw.idwws.Ijestmol[] ijestmols;

    private idw.idwws.Ijgrpdetmol[] ijgrpdetmols;

    private idw.idwws.Ijkanbanidcartao[] ijkanbanidcartaos;

    private idw.idwws.Ijkanbanlote[] ijkanbanlotes;

    private idw.idwws.Ijlogexcdadosmolde[] ijlogexcdadosmoldes;

    private idw.idwws.Ijlogvidautil[] ijlogvidautils;

    private idw.idwws.Ijmatrizsetup[] ijmatrizsetupsForCdmoldeentra;

    private idw.idwws.Ijmatrizsetup[] ijmatrizsetupsForCdmoldesai;

    private idw.idwws.Ijoplotes[] ijoploteses;

    private idw.idwws.Ijtbcli ijtbcli;

    private idw.idwws.Ijtbfab ijtbfab;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbmolgen[] ijtbmolgens;

    private idw.idwws.Ijtbmolidcav[] ijtbmolidcavs;

    private idw.idwws.Ijtbmolusaidcav[] ijtbmolusaidcavs;

    private idw.idwws.Ijtboperacoes ijtboperacoes;

    private idw.idwws.Ijtbori ijtbori;

    private java.lang.Double largura;

    private java.lang.String localizacao;

    private double percalevidautil;

    private java.lang.String pistoes;

    private java.lang.Double profundidade;

    private double qtcavativas;

    private double qtcavidades;

    private java.lang.Double qtciclosexecutados;

    private java.math.BigDecimal qtinjecoes;

    private java.math.BigDecimal qtinjman;

    private java.math.BigDecimal qtinjreset;

    private java.math.BigDecimal qtoperadores;

    private double qttotcicexec;

    private org.apache.axis.types.UnsignedShort stagrup;

    private java.lang.String tpentrada;

    private java.lang.String tpextracao;

    private java.lang.String tpinjecao;

    private org.apache.axis.types.UnsignedShort tpvalconflitoplng;

    private double vidautil;

    public Ijtbmol() {
    }

    public Ijtbmol(
           java.lang.Double altura,
           java.lang.String cdglobal,
           java.lang.String cdmolde,
           java.lang.String cdmolestendido,
           java.lang.String dsmolde,
           java.util.Calendar dtchegada,
           java.util.Calendar dtcompra,
           java.util.Calendar dtinstalacao,
           java.util.Calendar dtsaida,
           idw.idwws.Exportacao006[] exportacao006S,
           java.lang.Double freqmanutprev,
           idw.idwws.Ijdeparamol[] ijdeparamols,
           idw.idwws.Ijestmol[] ijestmols,
           idw.idwws.Ijgrpdetmol[] ijgrpdetmols,
           idw.idwws.Ijkanbanidcartao[] ijkanbanidcartaos,
           idw.idwws.Ijkanbanlote[] ijkanbanlotes,
           idw.idwws.Ijlogexcdadosmolde[] ijlogexcdadosmoldes,
           idw.idwws.Ijlogvidautil[] ijlogvidautils,
           idw.idwws.Ijmatrizsetup[] ijmatrizsetupsForCdmoldeentra,
           idw.idwws.Ijmatrizsetup[] ijmatrizsetupsForCdmoldesai,
           idw.idwws.Ijoplotes[] ijoploteses,
           idw.idwws.Ijtbcli ijtbcli,
           idw.idwws.Ijtbfab ijtbfab,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbmolgen[] ijtbmolgens,
           idw.idwws.Ijtbmolidcav[] ijtbmolidcavs,
           idw.idwws.Ijtbmolusaidcav[] ijtbmolusaidcavs,
           idw.idwws.Ijtboperacoes ijtboperacoes,
           idw.idwws.Ijtbori ijtbori,
           java.lang.Double largura,
           java.lang.String localizacao,
           double percalevidautil,
           java.lang.String pistoes,
           java.lang.Double profundidade,
           double qtcavativas,
           double qtcavidades,
           java.lang.Double qtciclosexecutados,
           java.math.BigDecimal qtinjecoes,
           java.math.BigDecimal qtinjman,
           java.math.BigDecimal qtinjreset,
           java.math.BigDecimal qtoperadores,
           double qttotcicexec,
           org.apache.axis.types.UnsignedShort stagrup,
           java.lang.String tpentrada,
           java.lang.String tpextracao,
           java.lang.String tpinjecao,
           org.apache.axis.types.UnsignedShort tpvalconflitoplng,
           double vidautil) {
           this.altura = altura;
           this.cdglobal = cdglobal;
           this.cdmolde = cdmolde;
           this.cdmolestendido = cdmolestendido;
           this.dsmolde = dsmolde;
           this.dtchegada = dtchegada;
           this.dtcompra = dtcompra;
           this.dtinstalacao = dtinstalacao;
           this.dtsaida = dtsaida;
           this.exportacao006S = exportacao006S;
           this.freqmanutprev = freqmanutprev;
           this.ijdeparamols = ijdeparamols;
           this.ijestmols = ijestmols;
           this.ijgrpdetmols = ijgrpdetmols;
           this.ijkanbanidcartaos = ijkanbanidcartaos;
           this.ijkanbanlotes = ijkanbanlotes;
           this.ijlogexcdadosmoldes = ijlogexcdadosmoldes;
           this.ijlogvidautils = ijlogvidautils;
           this.ijmatrizsetupsForCdmoldeentra = ijmatrizsetupsForCdmoldeentra;
           this.ijmatrizsetupsForCdmoldesai = ijmatrizsetupsForCdmoldesai;
           this.ijoploteses = ijoploteses;
           this.ijtbcli = ijtbcli;
           this.ijtbfab = ijtbfab;
           this.ijtbinj = ijtbinj;
           this.ijtbmolgens = ijtbmolgens;
           this.ijtbmolidcavs = ijtbmolidcavs;
           this.ijtbmolusaidcavs = ijtbmolusaidcavs;
           this.ijtboperacoes = ijtboperacoes;
           this.ijtbori = ijtbori;
           this.largura = largura;
           this.localizacao = localizacao;
           this.percalevidautil = percalevidautil;
           this.pistoes = pistoes;
           this.profundidade = profundidade;
           this.qtcavativas = qtcavativas;
           this.qtcavidades = qtcavidades;
           this.qtciclosexecutados = qtciclosexecutados;
           this.qtinjecoes = qtinjecoes;
           this.qtinjman = qtinjman;
           this.qtinjreset = qtinjreset;
           this.qtoperadores = qtoperadores;
           this.qttotcicexec = qttotcicexec;
           this.stagrup = stagrup;
           this.tpentrada = tpentrada;
           this.tpextracao = tpextracao;
           this.tpinjecao = tpinjecao;
           this.tpvalconflitoplng = tpvalconflitoplng;
           this.vidautil = vidautil;
    }


    /**
     * Gets the altura value for this Ijtbmol.
     * 
     * @return altura
     */
    public java.lang.Double getAltura() {
        return altura;
    }


    /**
     * Sets the altura value for this Ijtbmol.
     * 
     * @param altura
     */
    public void setAltura(java.lang.Double altura) {
        this.altura = altura;
    }


    /**
     * Gets the cdglobal value for this Ijtbmol.
     * 
     * @return cdglobal
     */
    public java.lang.String getCdglobal() {
        return cdglobal;
    }


    /**
     * Sets the cdglobal value for this Ijtbmol.
     * 
     * @param cdglobal
     */
    public void setCdglobal(java.lang.String cdglobal) {
        this.cdglobal = cdglobal;
    }


    /**
     * Gets the cdmolde value for this Ijtbmol.
     * 
     * @return cdmolde
     */
    public java.lang.String getCdmolde() {
        return cdmolde;
    }


    /**
     * Sets the cdmolde value for this Ijtbmol.
     * 
     * @param cdmolde
     */
    public void setCdmolde(java.lang.String cdmolde) {
        this.cdmolde = cdmolde;
    }


    /**
     * Gets the cdmolestendido value for this Ijtbmol.
     * 
     * @return cdmolestendido
     */
    public java.lang.String getCdmolestendido() {
        return cdmolestendido;
    }


    /**
     * Sets the cdmolestendido value for this Ijtbmol.
     * 
     * @param cdmolestendido
     */
    public void setCdmolestendido(java.lang.String cdmolestendido) {
        this.cdmolestendido = cdmolestendido;
    }


    /**
     * Gets the dsmolde value for this Ijtbmol.
     * 
     * @return dsmolde
     */
    public java.lang.String getDsmolde() {
        return dsmolde;
    }


    /**
     * Sets the dsmolde value for this Ijtbmol.
     * 
     * @param dsmolde
     */
    public void setDsmolde(java.lang.String dsmolde) {
        this.dsmolde = dsmolde;
    }


    /**
     * Gets the dtchegada value for this Ijtbmol.
     * 
     * @return dtchegada
     */
    public java.util.Calendar getDtchegada() {
        return dtchegada;
    }


    /**
     * Sets the dtchegada value for this Ijtbmol.
     * 
     * @param dtchegada
     */
    public void setDtchegada(java.util.Calendar dtchegada) {
        this.dtchegada = dtchegada;
    }


    /**
     * Gets the dtcompra value for this Ijtbmol.
     * 
     * @return dtcompra
     */
    public java.util.Calendar getDtcompra() {
        return dtcompra;
    }


    /**
     * Sets the dtcompra value for this Ijtbmol.
     * 
     * @param dtcompra
     */
    public void setDtcompra(java.util.Calendar dtcompra) {
        this.dtcompra = dtcompra;
    }


    /**
     * Gets the dtinstalacao value for this Ijtbmol.
     * 
     * @return dtinstalacao
     */
    public java.util.Calendar getDtinstalacao() {
        return dtinstalacao;
    }


    /**
     * Sets the dtinstalacao value for this Ijtbmol.
     * 
     * @param dtinstalacao
     */
    public void setDtinstalacao(java.util.Calendar dtinstalacao) {
        this.dtinstalacao = dtinstalacao;
    }


    /**
     * Gets the dtsaida value for this Ijtbmol.
     * 
     * @return dtsaida
     */
    public java.util.Calendar getDtsaida() {
        return dtsaida;
    }


    /**
     * Sets the dtsaida value for this Ijtbmol.
     * 
     * @param dtsaida
     */
    public void setDtsaida(java.util.Calendar dtsaida) {
        this.dtsaida = dtsaida;
    }


    /**
     * Gets the exportacao006S value for this Ijtbmol.
     * 
     * @return exportacao006S
     */
    public idw.idwws.Exportacao006[] getExportacao006S() {
        return exportacao006S;
    }


    /**
     * Sets the exportacao006S value for this Ijtbmol.
     * 
     * @param exportacao006S
     */
    public void setExportacao006S(idw.idwws.Exportacao006[] exportacao006S) {
        this.exportacao006S = exportacao006S;
    }

    public idw.idwws.Exportacao006 getExportacao006S(int i) {
        return this.exportacao006S[i];
    }

    public void setExportacao006S(int i, idw.idwws.Exportacao006 _value) {
        this.exportacao006S[i] = _value;
    }


    /**
     * Gets the freqmanutprev value for this Ijtbmol.
     * 
     * @return freqmanutprev
     */
    public java.lang.Double getFreqmanutprev() {
        return freqmanutprev;
    }


    /**
     * Sets the freqmanutprev value for this Ijtbmol.
     * 
     * @param freqmanutprev
     */
    public void setFreqmanutprev(java.lang.Double freqmanutprev) {
        this.freqmanutprev = freqmanutprev;
    }


    /**
     * Gets the ijdeparamols value for this Ijtbmol.
     * 
     * @return ijdeparamols
     */
    public idw.idwws.Ijdeparamol[] getIjdeparamols() {
        return ijdeparamols;
    }


    /**
     * Sets the ijdeparamols value for this Ijtbmol.
     * 
     * @param ijdeparamols
     */
    public void setIjdeparamols(idw.idwws.Ijdeparamol[] ijdeparamols) {
        this.ijdeparamols = ijdeparamols;
    }

    public idw.idwws.Ijdeparamol getIjdeparamols(int i) {
        return this.ijdeparamols[i];
    }

    public void setIjdeparamols(int i, idw.idwws.Ijdeparamol _value) {
        this.ijdeparamols[i] = _value;
    }


    /**
     * Gets the ijestmols value for this Ijtbmol.
     * 
     * @return ijestmols
     */
    public idw.idwws.Ijestmol[] getIjestmols() {
        return ijestmols;
    }


    /**
     * Sets the ijestmols value for this Ijtbmol.
     * 
     * @param ijestmols
     */
    public void setIjestmols(idw.idwws.Ijestmol[] ijestmols) {
        this.ijestmols = ijestmols;
    }

    public idw.idwws.Ijestmol getIjestmols(int i) {
        return this.ijestmols[i];
    }

    public void setIjestmols(int i, idw.idwws.Ijestmol _value) {
        this.ijestmols[i] = _value;
    }


    /**
     * Gets the ijgrpdetmols value for this Ijtbmol.
     * 
     * @return ijgrpdetmols
     */
    public idw.idwws.Ijgrpdetmol[] getIjgrpdetmols() {
        return ijgrpdetmols;
    }


    /**
     * Sets the ijgrpdetmols value for this Ijtbmol.
     * 
     * @param ijgrpdetmols
     */
    public void setIjgrpdetmols(idw.idwws.Ijgrpdetmol[] ijgrpdetmols) {
        this.ijgrpdetmols = ijgrpdetmols;
    }

    public idw.idwws.Ijgrpdetmol getIjgrpdetmols(int i) {
        return this.ijgrpdetmols[i];
    }

    public void setIjgrpdetmols(int i, idw.idwws.Ijgrpdetmol _value) {
        this.ijgrpdetmols[i] = _value;
    }


    /**
     * Gets the ijkanbanidcartaos value for this Ijtbmol.
     * 
     * @return ijkanbanidcartaos
     */
    public idw.idwws.Ijkanbanidcartao[] getIjkanbanidcartaos() {
        return ijkanbanidcartaos;
    }


    /**
     * Sets the ijkanbanidcartaos value for this Ijtbmol.
     * 
     * @param ijkanbanidcartaos
     */
    public void setIjkanbanidcartaos(idw.idwws.Ijkanbanidcartao[] ijkanbanidcartaos) {
        this.ijkanbanidcartaos = ijkanbanidcartaos;
    }

    public idw.idwws.Ijkanbanidcartao getIjkanbanidcartaos(int i) {
        return this.ijkanbanidcartaos[i];
    }

    public void setIjkanbanidcartaos(int i, idw.idwws.Ijkanbanidcartao _value) {
        this.ijkanbanidcartaos[i] = _value;
    }


    /**
     * Gets the ijkanbanlotes value for this Ijtbmol.
     * 
     * @return ijkanbanlotes
     */
    public idw.idwws.Ijkanbanlote[] getIjkanbanlotes() {
        return ijkanbanlotes;
    }


    /**
     * Sets the ijkanbanlotes value for this Ijtbmol.
     * 
     * @param ijkanbanlotes
     */
    public void setIjkanbanlotes(idw.idwws.Ijkanbanlote[] ijkanbanlotes) {
        this.ijkanbanlotes = ijkanbanlotes;
    }

    public idw.idwws.Ijkanbanlote getIjkanbanlotes(int i) {
        return this.ijkanbanlotes[i];
    }

    public void setIjkanbanlotes(int i, idw.idwws.Ijkanbanlote _value) {
        this.ijkanbanlotes[i] = _value;
    }


    /**
     * Gets the ijlogexcdadosmoldes value for this Ijtbmol.
     * 
     * @return ijlogexcdadosmoldes
     */
    public idw.idwws.Ijlogexcdadosmolde[] getIjlogexcdadosmoldes() {
        return ijlogexcdadosmoldes;
    }


    /**
     * Sets the ijlogexcdadosmoldes value for this Ijtbmol.
     * 
     * @param ijlogexcdadosmoldes
     */
    public void setIjlogexcdadosmoldes(idw.idwws.Ijlogexcdadosmolde[] ijlogexcdadosmoldes) {
        this.ijlogexcdadosmoldes = ijlogexcdadosmoldes;
    }

    public idw.idwws.Ijlogexcdadosmolde getIjlogexcdadosmoldes(int i) {
        return this.ijlogexcdadosmoldes[i];
    }

    public void setIjlogexcdadosmoldes(int i, idw.idwws.Ijlogexcdadosmolde _value) {
        this.ijlogexcdadosmoldes[i] = _value;
    }


    /**
     * Gets the ijlogvidautils value for this Ijtbmol.
     * 
     * @return ijlogvidautils
     */
    public idw.idwws.Ijlogvidautil[] getIjlogvidautils() {
        return ijlogvidautils;
    }


    /**
     * Sets the ijlogvidautils value for this Ijtbmol.
     * 
     * @param ijlogvidautils
     */
    public void setIjlogvidautils(idw.idwws.Ijlogvidautil[] ijlogvidautils) {
        this.ijlogvidautils = ijlogvidautils;
    }

    public idw.idwws.Ijlogvidautil getIjlogvidautils(int i) {
        return this.ijlogvidautils[i];
    }

    public void setIjlogvidautils(int i, idw.idwws.Ijlogvidautil _value) {
        this.ijlogvidautils[i] = _value;
    }


    /**
     * Gets the ijmatrizsetupsForCdmoldeentra value for this Ijtbmol.
     * 
     * @return ijmatrizsetupsForCdmoldeentra
     */
    public idw.idwws.Ijmatrizsetup[] getIjmatrizsetupsForCdmoldeentra() {
        return ijmatrizsetupsForCdmoldeentra;
    }


    /**
     * Sets the ijmatrizsetupsForCdmoldeentra value for this Ijtbmol.
     * 
     * @param ijmatrizsetupsForCdmoldeentra
     */
    public void setIjmatrizsetupsForCdmoldeentra(idw.idwws.Ijmatrizsetup[] ijmatrizsetupsForCdmoldeentra) {
        this.ijmatrizsetupsForCdmoldeentra = ijmatrizsetupsForCdmoldeentra;
    }

    public idw.idwws.Ijmatrizsetup getIjmatrizsetupsForCdmoldeentra(int i) {
        return this.ijmatrizsetupsForCdmoldeentra[i];
    }

    public void setIjmatrizsetupsForCdmoldeentra(int i, idw.idwws.Ijmatrizsetup _value) {
        this.ijmatrizsetupsForCdmoldeentra[i] = _value;
    }


    /**
     * Gets the ijmatrizsetupsForCdmoldesai value for this Ijtbmol.
     * 
     * @return ijmatrizsetupsForCdmoldesai
     */
    public idw.idwws.Ijmatrizsetup[] getIjmatrizsetupsForCdmoldesai() {
        return ijmatrizsetupsForCdmoldesai;
    }


    /**
     * Sets the ijmatrizsetupsForCdmoldesai value for this Ijtbmol.
     * 
     * @param ijmatrizsetupsForCdmoldesai
     */
    public void setIjmatrizsetupsForCdmoldesai(idw.idwws.Ijmatrizsetup[] ijmatrizsetupsForCdmoldesai) {
        this.ijmatrizsetupsForCdmoldesai = ijmatrizsetupsForCdmoldesai;
    }

    public idw.idwws.Ijmatrizsetup getIjmatrizsetupsForCdmoldesai(int i) {
        return this.ijmatrizsetupsForCdmoldesai[i];
    }

    public void setIjmatrizsetupsForCdmoldesai(int i, idw.idwws.Ijmatrizsetup _value) {
        this.ijmatrizsetupsForCdmoldesai[i] = _value;
    }


    /**
     * Gets the ijoploteses value for this Ijtbmol.
     * 
     * @return ijoploteses
     */
    public idw.idwws.Ijoplotes[] getIjoploteses() {
        return ijoploteses;
    }


    /**
     * Sets the ijoploteses value for this Ijtbmol.
     * 
     * @param ijoploteses
     */
    public void setIjoploteses(idw.idwws.Ijoplotes[] ijoploteses) {
        this.ijoploteses = ijoploteses;
    }

    public idw.idwws.Ijoplotes getIjoploteses(int i) {
        return this.ijoploteses[i];
    }

    public void setIjoploteses(int i, idw.idwws.Ijoplotes _value) {
        this.ijoploteses[i] = _value;
    }


    /**
     * Gets the ijtbcli value for this Ijtbmol.
     * 
     * @return ijtbcli
     */
    public idw.idwws.Ijtbcli getIjtbcli() {
        return ijtbcli;
    }


    /**
     * Sets the ijtbcli value for this Ijtbmol.
     * 
     * @param ijtbcli
     */
    public void setIjtbcli(idw.idwws.Ijtbcli ijtbcli) {
        this.ijtbcli = ijtbcli;
    }


    /**
     * Gets the ijtbfab value for this Ijtbmol.
     * 
     * @return ijtbfab
     */
    public idw.idwws.Ijtbfab getIjtbfab() {
        return ijtbfab;
    }


    /**
     * Sets the ijtbfab value for this Ijtbmol.
     * 
     * @param ijtbfab
     */
    public void setIjtbfab(idw.idwws.Ijtbfab ijtbfab) {
        this.ijtbfab = ijtbfab;
    }


    /**
     * Gets the ijtbinj value for this Ijtbmol.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijtbmol.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbmolgens value for this Ijtbmol.
     * 
     * @return ijtbmolgens
     */
    public idw.idwws.Ijtbmolgen[] getIjtbmolgens() {
        return ijtbmolgens;
    }


    /**
     * Sets the ijtbmolgens value for this Ijtbmol.
     * 
     * @param ijtbmolgens
     */
    public void setIjtbmolgens(idw.idwws.Ijtbmolgen[] ijtbmolgens) {
        this.ijtbmolgens = ijtbmolgens;
    }

    public idw.idwws.Ijtbmolgen getIjtbmolgens(int i) {
        return this.ijtbmolgens[i];
    }

    public void setIjtbmolgens(int i, idw.idwws.Ijtbmolgen _value) {
        this.ijtbmolgens[i] = _value;
    }


    /**
     * Gets the ijtbmolidcavs value for this Ijtbmol.
     * 
     * @return ijtbmolidcavs
     */
    public idw.idwws.Ijtbmolidcav[] getIjtbmolidcavs() {
        return ijtbmolidcavs;
    }


    /**
     * Sets the ijtbmolidcavs value for this Ijtbmol.
     * 
     * @param ijtbmolidcavs
     */
    public void setIjtbmolidcavs(idw.idwws.Ijtbmolidcav[] ijtbmolidcavs) {
        this.ijtbmolidcavs = ijtbmolidcavs;
    }

    public idw.idwws.Ijtbmolidcav getIjtbmolidcavs(int i) {
        return this.ijtbmolidcavs[i];
    }

    public void setIjtbmolidcavs(int i, idw.idwws.Ijtbmolidcav _value) {
        this.ijtbmolidcavs[i] = _value;
    }


    /**
     * Gets the ijtbmolusaidcavs value for this Ijtbmol.
     * 
     * @return ijtbmolusaidcavs
     */
    public idw.idwws.Ijtbmolusaidcav[] getIjtbmolusaidcavs() {
        return ijtbmolusaidcavs;
    }


    /**
     * Sets the ijtbmolusaidcavs value for this Ijtbmol.
     * 
     * @param ijtbmolusaidcavs
     */
    public void setIjtbmolusaidcavs(idw.idwws.Ijtbmolusaidcav[] ijtbmolusaidcavs) {
        this.ijtbmolusaidcavs = ijtbmolusaidcavs;
    }

    public idw.idwws.Ijtbmolusaidcav getIjtbmolusaidcavs(int i) {
        return this.ijtbmolusaidcavs[i];
    }

    public void setIjtbmolusaidcavs(int i, idw.idwws.Ijtbmolusaidcav _value) {
        this.ijtbmolusaidcavs[i] = _value;
    }


    /**
     * Gets the ijtboperacoes value for this Ijtbmol.
     * 
     * @return ijtboperacoes
     */
    public idw.idwws.Ijtboperacoes getIjtboperacoes() {
        return ijtboperacoes;
    }


    /**
     * Sets the ijtboperacoes value for this Ijtbmol.
     * 
     * @param ijtboperacoes
     */
    public void setIjtboperacoes(idw.idwws.Ijtboperacoes ijtboperacoes) {
        this.ijtboperacoes = ijtboperacoes;
    }


    /**
     * Gets the ijtbori value for this Ijtbmol.
     * 
     * @return ijtbori
     */
    public idw.idwws.Ijtbori getIjtbori() {
        return ijtbori;
    }


    /**
     * Sets the ijtbori value for this Ijtbmol.
     * 
     * @param ijtbori
     */
    public void setIjtbori(idw.idwws.Ijtbori ijtbori) {
        this.ijtbori = ijtbori;
    }


    /**
     * Gets the largura value for this Ijtbmol.
     * 
     * @return largura
     */
    public java.lang.Double getLargura() {
        return largura;
    }


    /**
     * Sets the largura value for this Ijtbmol.
     * 
     * @param largura
     */
    public void setLargura(java.lang.Double largura) {
        this.largura = largura;
    }


    /**
     * Gets the localizacao value for this Ijtbmol.
     * 
     * @return localizacao
     */
    public java.lang.String getLocalizacao() {
        return localizacao;
    }


    /**
     * Sets the localizacao value for this Ijtbmol.
     * 
     * @param localizacao
     */
    public void setLocalizacao(java.lang.String localizacao) {
        this.localizacao = localizacao;
    }


    /**
     * Gets the percalevidautil value for this Ijtbmol.
     * 
     * @return percalevidautil
     */
    public double getPercalevidautil() {
        return percalevidautil;
    }


    /**
     * Sets the percalevidautil value for this Ijtbmol.
     * 
     * @param percalevidautil
     */
    public void setPercalevidautil(double percalevidautil) {
        this.percalevidautil = percalevidautil;
    }


    /**
     * Gets the pistoes value for this Ijtbmol.
     * 
     * @return pistoes
     */
    public java.lang.String getPistoes() {
        return pistoes;
    }


    /**
     * Sets the pistoes value for this Ijtbmol.
     * 
     * @param pistoes
     */
    public void setPistoes(java.lang.String pistoes) {
        this.pistoes = pistoes;
    }


    /**
     * Gets the profundidade value for this Ijtbmol.
     * 
     * @return profundidade
     */
    public java.lang.Double getProfundidade() {
        return profundidade;
    }


    /**
     * Sets the profundidade value for this Ijtbmol.
     * 
     * @param profundidade
     */
    public void setProfundidade(java.lang.Double profundidade) {
        this.profundidade = profundidade;
    }


    /**
     * Gets the qtcavativas value for this Ijtbmol.
     * 
     * @return qtcavativas
     */
    public double getQtcavativas() {
        return qtcavativas;
    }


    /**
     * Sets the qtcavativas value for this Ijtbmol.
     * 
     * @param qtcavativas
     */
    public void setQtcavativas(double qtcavativas) {
        this.qtcavativas = qtcavativas;
    }


    /**
     * Gets the qtcavidades value for this Ijtbmol.
     * 
     * @return qtcavidades
     */
    public double getQtcavidades() {
        return qtcavidades;
    }


    /**
     * Sets the qtcavidades value for this Ijtbmol.
     * 
     * @param qtcavidades
     */
    public void setQtcavidades(double qtcavidades) {
        this.qtcavidades = qtcavidades;
    }


    /**
     * Gets the qtciclosexecutados value for this Ijtbmol.
     * 
     * @return qtciclosexecutados
     */
    public java.lang.Double getQtciclosexecutados() {
        return qtciclosexecutados;
    }


    /**
     * Sets the qtciclosexecutados value for this Ijtbmol.
     * 
     * @param qtciclosexecutados
     */
    public void setQtciclosexecutados(java.lang.Double qtciclosexecutados) {
        this.qtciclosexecutados = qtciclosexecutados;
    }


    /**
     * Gets the qtinjecoes value for this Ijtbmol.
     * 
     * @return qtinjecoes
     */
    public java.math.BigDecimal getQtinjecoes() {
        return qtinjecoes;
    }


    /**
     * Sets the qtinjecoes value for this Ijtbmol.
     * 
     * @param qtinjecoes
     */
    public void setQtinjecoes(java.math.BigDecimal qtinjecoes) {
        this.qtinjecoes = qtinjecoes;
    }


    /**
     * Gets the qtinjman value for this Ijtbmol.
     * 
     * @return qtinjman
     */
    public java.math.BigDecimal getQtinjman() {
        return qtinjman;
    }


    /**
     * Sets the qtinjman value for this Ijtbmol.
     * 
     * @param qtinjman
     */
    public void setQtinjman(java.math.BigDecimal qtinjman) {
        this.qtinjman = qtinjman;
    }


    /**
     * Gets the qtinjreset value for this Ijtbmol.
     * 
     * @return qtinjreset
     */
    public java.math.BigDecimal getQtinjreset() {
        return qtinjreset;
    }


    /**
     * Sets the qtinjreset value for this Ijtbmol.
     * 
     * @param qtinjreset
     */
    public void setQtinjreset(java.math.BigDecimal qtinjreset) {
        this.qtinjreset = qtinjreset;
    }


    /**
     * Gets the qtoperadores value for this Ijtbmol.
     * 
     * @return qtoperadores
     */
    public java.math.BigDecimal getQtoperadores() {
        return qtoperadores;
    }


    /**
     * Sets the qtoperadores value for this Ijtbmol.
     * 
     * @param qtoperadores
     */
    public void setQtoperadores(java.math.BigDecimal qtoperadores) {
        this.qtoperadores = qtoperadores;
    }


    /**
     * Gets the qttotcicexec value for this Ijtbmol.
     * 
     * @return qttotcicexec
     */
    public double getQttotcicexec() {
        return qttotcicexec;
    }


    /**
     * Sets the qttotcicexec value for this Ijtbmol.
     * 
     * @param qttotcicexec
     */
    public void setQttotcicexec(double qttotcicexec) {
        this.qttotcicexec = qttotcicexec;
    }


    /**
     * Gets the stagrup value for this Ijtbmol.
     * 
     * @return stagrup
     */
    public org.apache.axis.types.UnsignedShort getStagrup() {
        return stagrup;
    }


    /**
     * Sets the stagrup value for this Ijtbmol.
     * 
     * @param stagrup
     */
    public void setStagrup(org.apache.axis.types.UnsignedShort stagrup) {
        this.stagrup = stagrup;
    }


    /**
     * Gets the tpentrada value for this Ijtbmol.
     * 
     * @return tpentrada
     */
    public java.lang.String getTpentrada() {
        return tpentrada;
    }


    /**
     * Sets the tpentrada value for this Ijtbmol.
     * 
     * @param tpentrada
     */
    public void setTpentrada(java.lang.String tpentrada) {
        this.tpentrada = tpentrada;
    }


    /**
     * Gets the tpextracao value for this Ijtbmol.
     * 
     * @return tpextracao
     */
    public java.lang.String getTpextracao() {
        return tpextracao;
    }


    /**
     * Sets the tpextracao value for this Ijtbmol.
     * 
     * @param tpextracao
     */
    public void setTpextracao(java.lang.String tpextracao) {
        this.tpextracao = tpextracao;
    }


    /**
     * Gets the tpinjecao value for this Ijtbmol.
     * 
     * @return tpinjecao
     */
    public java.lang.String getTpinjecao() {
        return tpinjecao;
    }


    /**
     * Sets the tpinjecao value for this Ijtbmol.
     * 
     * @param tpinjecao
     */
    public void setTpinjecao(java.lang.String tpinjecao) {
        this.tpinjecao = tpinjecao;
    }


    /**
     * Gets the tpvalconflitoplng value for this Ijtbmol.
     * 
     * @return tpvalconflitoplng
     */
    public org.apache.axis.types.UnsignedShort getTpvalconflitoplng() {
        return tpvalconflitoplng;
    }


    /**
     * Sets the tpvalconflitoplng value for this Ijtbmol.
     * 
     * @param tpvalconflitoplng
     */
    public void setTpvalconflitoplng(org.apache.axis.types.UnsignedShort tpvalconflitoplng) {
        this.tpvalconflitoplng = tpvalconflitoplng;
    }


    /**
     * Gets the vidautil value for this Ijtbmol.
     * 
     * @return vidautil
     */
    public double getVidautil() {
        return vidautil;
    }


    /**
     * Sets the vidautil value for this Ijtbmol.
     * 
     * @param vidautil
     */
    public void setVidautil(double vidautil) {
        this.vidautil = vidautil;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbmol)) return false;
        Ijtbmol other = (Ijtbmol) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.altura==null && other.getAltura()==null) || 
             (this.altura!=null &&
              this.altura.equals(other.getAltura()))) &&
            ((this.cdglobal==null && other.getCdglobal()==null) || 
             (this.cdglobal!=null &&
              this.cdglobal.equals(other.getCdglobal()))) &&
            ((this.cdmolde==null && other.getCdmolde()==null) || 
             (this.cdmolde!=null &&
              this.cdmolde.equals(other.getCdmolde()))) &&
            ((this.cdmolestendido==null && other.getCdmolestendido()==null) || 
             (this.cdmolestendido!=null &&
              this.cdmolestendido.equals(other.getCdmolestendido()))) &&
            ((this.dsmolde==null && other.getDsmolde()==null) || 
             (this.dsmolde!=null &&
              this.dsmolde.equals(other.getDsmolde()))) &&
            ((this.dtchegada==null && other.getDtchegada()==null) || 
             (this.dtchegada!=null &&
              this.dtchegada.equals(other.getDtchegada()))) &&
            ((this.dtcompra==null && other.getDtcompra()==null) || 
             (this.dtcompra!=null &&
              this.dtcompra.equals(other.getDtcompra()))) &&
            ((this.dtinstalacao==null && other.getDtinstalacao()==null) || 
             (this.dtinstalacao!=null &&
              this.dtinstalacao.equals(other.getDtinstalacao()))) &&
            ((this.dtsaida==null && other.getDtsaida()==null) || 
             (this.dtsaida!=null &&
              this.dtsaida.equals(other.getDtsaida()))) &&
            ((this.exportacao006S==null && other.getExportacao006S()==null) || 
             (this.exportacao006S!=null &&
              java.util.Arrays.equals(this.exportacao006S, other.getExportacao006S()))) &&
            ((this.freqmanutprev==null && other.getFreqmanutprev()==null) || 
             (this.freqmanutprev!=null &&
              this.freqmanutprev.equals(other.getFreqmanutprev()))) &&
            ((this.ijdeparamols==null && other.getIjdeparamols()==null) || 
             (this.ijdeparamols!=null &&
              java.util.Arrays.equals(this.ijdeparamols, other.getIjdeparamols()))) &&
            ((this.ijestmols==null && other.getIjestmols()==null) || 
             (this.ijestmols!=null &&
              java.util.Arrays.equals(this.ijestmols, other.getIjestmols()))) &&
            ((this.ijgrpdetmols==null && other.getIjgrpdetmols()==null) || 
             (this.ijgrpdetmols!=null &&
              java.util.Arrays.equals(this.ijgrpdetmols, other.getIjgrpdetmols()))) &&
            ((this.ijkanbanidcartaos==null && other.getIjkanbanidcartaos()==null) || 
             (this.ijkanbanidcartaos!=null &&
              java.util.Arrays.equals(this.ijkanbanidcartaos, other.getIjkanbanidcartaos()))) &&
            ((this.ijkanbanlotes==null && other.getIjkanbanlotes()==null) || 
             (this.ijkanbanlotes!=null &&
              java.util.Arrays.equals(this.ijkanbanlotes, other.getIjkanbanlotes()))) &&
            ((this.ijlogexcdadosmoldes==null && other.getIjlogexcdadosmoldes()==null) || 
             (this.ijlogexcdadosmoldes!=null &&
              java.util.Arrays.equals(this.ijlogexcdadosmoldes, other.getIjlogexcdadosmoldes()))) &&
            ((this.ijlogvidautils==null && other.getIjlogvidautils()==null) || 
             (this.ijlogvidautils!=null &&
              java.util.Arrays.equals(this.ijlogvidautils, other.getIjlogvidautils()))) &&
            ((this.ijmatrizsetupsForCdmoldeentra==null && other.getIjmatrizsetupsForCdmoldeentra()==null) || 
             (this.ijmatrizsetupsForCdmoldeentra!=null &&
              java.util.Arrays.equals(this.ijmatrizsetupsForCdmoldeentra, other.getIjmatrizsetupsForCdmoldeentra()))) &&
            ((this.ijmatrizsetupsForCdmoldesai==null && other.getIjmatrizsetupsForCdmoldesai()==null) || 
             (this.ijmatrizsetupsForCdmoldesai!=null &&
              java.util.Arrays.equals(this.ijmatrizsetupsForCdmoldesai, other.getIjmatrizsetupsForCdmoldesai()))) &&
            ((this.ijoploteses==null && other.getIjoploteses()==null) || 
             (this.ijoploteses!=null &&
              java.util.Arrays.equals(this.ijoploteses, other.getIjoploteses()))) &&
            ((this.ijtbcli==null && other.getIjtbcli()==null) || 
             (this.ijtbcli!=null &&
              this.ijtbcli.equals(other.getIjtbcli()))) &&
            ((this.ijtbfab==null && other.getIjtbfab()==null) || 
             (this.ijtbfab!=null &&
              this.ijtbfab.equals(other.getIjtbfab()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbmolgens==null && other.getIjtbmolgens()==null) || 
             (this.ijtbmolgens!=null &&
              java.util.Arrays.equals(this.ijtbmolgens, other.getIjtbmolgens()))) &&
            ((this.ijtbmolidcavs==null && other.getIjtbmolidcavs()==null) || 
             (this.ijtbmolidcavs!=null &&
              java.util.Arrays.equals(this.ijtbmolidcavs, other.getIjtbmolidcavs()))) &&
            ((this.ijtbmolusaidcavs==null && other.getIjtbmolusaidcavs()==null) || 
             (this.ijtbmolusaidcavs!=null &&
              java.util.Arrays.equals(this.ijtbmolusaidcavs, other.getIjtbmolusaidcavs()))) &&
            ((this.ijtboperacoes==null && other.getIjtboperacoes()==null) || 
             (this.ijtboperacoes!=null &&
              this.ijtboperacoes.equals(other.getIjtboperacoes()))) &&
            ((this.ijtbori==null && other.getIjtbori()==null) || 
             (this.ijtbori!=null &&
              this.ijtbori.equals(other.getIjtbori()))) &&
            ((this.largura==null && other.getLargura()==null) || 
             (this.largura!=null &&
              this.largura.equals(other.getLargura()))) &&
            ((this.localizacao==null && other.getLocalizacao()==null) || 
             (this.localizacao!=null &&
              this.localizacao.equals(other.getLocalizacao()))) &&
            this.percalevidautil == other.getPercalevidautil() &&
            ((this.pistoes==null && other.getPistoes()==null) || 
             (this.pistoes!=null &&
              this.pistoes.equals(other.getPistoes()))) &&
            ((this.profundidade==null && other.getProfundidade()==null) || 
             (this.profundidade!=null &&
              this.profundidade.equals(other.getProfundidade()))) &&
            this.qtcavativas == other.getQtcavativas() &&
            this.qtcavidades == other.getQtcavidades() &&
            ((this.qtciclosexecutados==null && other.getQtciclosexecutados()==null) || 
             (this.qtciclosexecutados!=null &&
              this.qtciclosexecutados.equals(other.getQtciclosexecutados()))) &&
            ((this.qtinjecoes==null && other.getQtinjecoes()==null) || 
             (this.qtinjecoes!=null &&
              this.qtinjecoes.equals(other.getQtinjecoes()))) &&
            ((this.qtinjman==null && other.getQtinjman()==null) || 
             (this.qtinjman!=null &&
              this.qtinjman.equals(other.getQtinjman()))) &&
            ((this.qtinjreset==null && other.getQtinjreset()==null) || 
             (this.qtinjreset!=null &&
              this.qtinjreset.equals(other.getQtinjreset()))) &&
            ((this.qtoperadores==null && other.getQtoperadores()==null) || 
             (this.qtoperadores!=null &&
              this.qtoperadores.equals(other.getQtoperadores()))) &&
            this.qttotcicexec == other.getQttotcicexec() &&
            ((this.stagrup==null && other.getStagrup()==null) || 
             (this.stagrup!=null &&
              this.stagrup.equals(other.getStagrup()))) &&
            ((this.tpentrada==null && other.getTpentrada()==null) || 
             (this.tpentrada!=null &&
              this.tpentrada.equals(other.getTpentrada()))) &&
            ((this.tpextracao==null && other.getTpextracao()==null) || 
             (this.tpextracao!=null &&
              this.tpextracao.equals(other.getTpextracao()))) &&
            ((this.tpinjecao==null && other.getTpinjecao()==null) || 
             (this.tpinjecao!=null &&
              this.tpinjecao.equals(other.getTpinjecao()))) &&
            ((this.tpvalconflitoplng==null && other.getTpvalconflitoplng()==null) || 
             (this.tpvalconflitoplng!=null &&
              this.tpvalconflitoplng.equals(other.getTpvalconflitoplng()))) &&
            this.vidautil == other.getVidautil();
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
        if (getAltura() != null) {
            _hashCode += getAltura().hashCode();
        }
        if (getCdglobal() != null) {
            _hashCode += getCdglobal().hashCode();
        }
        if (getCdmolde() != null) {
            _hashCode += getCdmolde().hashCode();
        }
        if (getCdmolestendido() != null) {
            _hashCode += getCdmolestendido().hashCode();
        }
        if (getDsmolde() != null) {
            _hashCode += getDsmolde().hashCode();
        }
        if (getDtchegada() != null) {
            _hashCode += getDtchegada().hashCode();
        }
        if (getDtcompra() != null) {
            _hashCode += getDtcompra().hashCode();
        }
        if (getDtinstalacao() != null) {
            _hashCode += getDtinstalacao().hashCode();
        }
        if (getDtsaida() != null) {
            _hashCode += getDtsaida().hashCode();
        }
        if (getExportacao006S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExportacao006S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExportacao006S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFreqmanutprev() != null) {
            _hashCode += getFreqmanutprev().hashCode();
        }
        if (getIjdeparamols() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjdeparamols());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjdeparamols(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjestmols() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjestmols());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjestmols(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjgrpdetmols() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpdetmols());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpdetmols(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjkanbanidcartaos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjkanbanidcartaos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjkanbanidcartaos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjkanbanlotes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjkanbanlotes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjkanbanlotes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjlogexcdadosmoldes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjlogexcdadosmoldes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjlogexcdadosmoldes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjlogvidautils() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjlogvidautils());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjlogvidautils(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmatrizsetupsForCdmoldeentra() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmatrizsetupsForCdmoldeentra());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmatrizsetupsForCdmoldeentra(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmatrizsetupsForCdmoldesai() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmatrizsetupsForCdmoldesai());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmatrizsetupsForCdmoldesai(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjoploteses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjoploteses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjoploteses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbcli() != null) {
            _hashCode += getIjtbcli().hashCode();
        }
        if (getIjtbfab() != null) {
            _hashCode += getIjtbfab().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbmolgens() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbmolgens());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbmolgens(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbmolidcavs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbmolidcavs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbmolidcavs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbmolusaidcavs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbmolusaidcavs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbmolusaidcavs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtboperacoes() != null) {
            _hashCode += getIjtboperacoes().hashCode();
        }
        if (getIjtbori() != null) {
            _hashCode += getIjtbori().hashCode();
        }
        if (getLargura() != null) {
            _hashCode += getLargura().hashCode();
        }
        if (getLocalizacao() != null) {
            _hashCode += getLocalizacao().hashCode();
        }
        _hashCode += new Double(getPercalevidautil()).hashCode();
        if (getPistoes() != null) {
            _hashCode += getPistoes().hashCode();
        }
        if (getProfundidade() != null) {
            _hashCode += getProfundidade().hashCode();
        }
        _hashCode += new Double(getQtcavativas()).hashCode();
        _hashCode += new Double(getQtcavidades()).hashCode();
        if (getQtciclosexecutados() != null) {
            _hashCode += getQtciclosexecutados().hashCode();
        }
        if (getQtinjecoes() != null) {
            _hashCode += getQtinjecoes().hashCode();
        }
        if (getQtinjman() != null) {
            _hashCode += getQtinjman().hashCode();
        }
        if (getQtinjreset() != null) {
            _hashCode += getQtinjreset().hashCode();
        }
        if (getQtoperadores() != null) {
            _hashCode += getQtoperadores().hashCode();
        }
        _hashCode += new Double(getQttotcicexec()).hashCode();
        if (getStagrup() != null) {
            _hashCode += getStagrup().hashCode();
        }
        if (getTpentrada() != null) {
            _hashCode += getTpentrada().hashCode();
        }
        if (getTpextracao() != null) {
            _hashCode += getTpextracao().hashCode();
        }
        if (getTpinjecao() != null) {
            _hashCode += getTpinjecao().hashCode();
        }
        if (getTpvalconflitoplng() != null) {
            _hashCode += getTpvalconflitoplng().hashCode();
        }
        _hashCode += new Double(getVidautil()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbmol.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmol"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("altura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "altura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdglobal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdglobal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmolestendido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmolestendido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsmolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsmolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtchegada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtchegada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtcompra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtcompra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtinstalacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtinstalacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtsaida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtsaida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exportacao006S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exportacao006s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "exportacao006"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("freqmanutprev");
        elemField.setXmlName(new javax.xml.namespace.QName("", "freqmanutprev"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijdeparamols");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijdeparamols"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdeparamol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijestmols");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijestmols"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpdetmols");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpdetmols"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijkanbanidcartaos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbanidcartaos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanidcartao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijkanbanlotes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbanlotes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanlote"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijlogexcdadosmoldes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijlogexcdadosmoldes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlogexcdadosmolde"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijlogvidautils");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijlogvidautils"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlogvidautil"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmatrizsetupsForCdmoldeentra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmatrizsetupsForCdmoldeentra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmatrizsetup"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmatrizsetupsForCdmoldesai");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmatrizsetupsForCdmoldesai"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmatrizsetup"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijoploteses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijoploteses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoplotes"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbcli");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbcli"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcli"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbfab");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbfab"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbfab"));
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
        elemField.setFieldName("ijtbmolgens");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmolgens"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmolgen"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmolidcavs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmolidcavs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmolidcav"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmolusaidcavs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmolusaidcavs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmolusaidcav"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtboperacoes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtboperacoes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtboperacoes"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbori");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbori"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbori"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("largura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "largura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("localizacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "localizacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("percalevidautil");
        elemField.setXmlName(new javax.xml.namespace.QName("", "percalevidautil"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pistoes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pistoes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profundidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "profundidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtcavativas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtcavativas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtcavidades");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtcavidades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtciclosexecutados");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtciclosexecutados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtinjecoes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtinjecoes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtinjman");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtinjman"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtinjreset");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtinjreset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtoperadores");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtoperadores"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qttotcicexec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qttotcicexec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stagrup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stagrup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpentrada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpentrada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpextracao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpextracao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpinjecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpinjecao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpvalconflitoplng");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpvalconflitoplng"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vidautil");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vidautil"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
