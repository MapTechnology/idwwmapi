/**
 * Ijctrlcgqalt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijctrlcgqalt  implements java.io.Serializable {
    private java.lang.String cavidades;

    private org.apache.axis.types.UnsignedShort cavidadesedt;

    private java.lang.String cdcimplast;

    private org.apache.axis.types.UnsignedShort cdcimplastedt;

    private java.lang.String cdcliente;

    private java.lang.String cdclientecgq;

    private org.apache.axis.types.UnsignedShort cdclientecgqedt;

    private org.apache.axis.types.UnsignedShort cdproinjetedt;

    private java.lang.String dapa;

    private org.apache.axis.types.UnsignedShort dapaedt;

    private java.util.Calendar dtfabricacao;

    private org.apache.axis.types.UnsignedShort dtfabricacaoedt;

    private java.util.Calendar dthralteracao;

    private java.util.Calendar dtvalidade;

    private org.apache.axis.types.UnsignedShort dtvalidadeedt;

    private java.lang.Double du;

    private org.apache.axis.types.UnsignedShort enviohabilitado;

    private org.apache.axis.types.UnsignedShort enviointernohab;

    private java.lang.String etiquetas;

    private org.apache.axis.types.UnsignedShort etiquetasedt;

    private java.lang.String fep;

    private org.apache.axis.types.UnsignedShort fepedt;

    private org.apache.axis.types.UnsignedShort houvealteramstr;

    private double idctrlaltcgq;

    private idw.idwws.Ijamstraltcgq[] ijamstraltcgqs;

    private idw.idwws.Ijctrlcgq ijctrlcgq;

    private idw.idwws.Ijctrlcgqxctts[] ijctrlcgqxcttses;

    private idw.idwws.Ijctrlcgqxmprima[] ijctrlcgqxmprimas;

    private idw.idwws.Ijctrlcgqxplantas[] ijctrlcgqxplantases;

    private idw.idwws.Ijduimpressaocgq[] ijduimpressaocgqs;

    private idw.idwws.Ijtbpro ijtbpro;

    private idw.idwws.Ijtbusu ijtbusu;

    private org.apache.axis.types.UnsignedShort novoresultado;

    private java.lang.String nrnota;

    private org.apache.axis.types.UnsignedShort nrnotaedt;

    private java.lang.String nropdurev;

    private org.apache.axis.types.UnsignedShort nropedt;

    private java.lang.String obsalteracao;

    private java.lang.String obscgq;

    private org.apache.axis.types.UnsignedShort obscgqedt;

    private java.lang.String obsdu;

    private org.apache.axis.types.UnsignedShort obsduedt;

    private java.math.BigDecimal qtdpcsaval;

    private org.apache.axis.types.UnsignedShort qtdpcsavaledt;

    private org.apache.axis.types.UnsignedShort resultadoinspecao;

    private java.math.BigDecimal revisao;

    private org.apache.axis.types.UnsignedShort stregistro;

    public Ijctrlcgqalt() {
    }

    public Ijctrlcgqalt(
           java.lang.String cavidades,
           org.apache.axis.types.UnsignedShort cavidadesedt,
           java.lang.String cdcimplast,
           org.apache.axis.types.UnsignedShort cdcimplastedt,
           java.lang.String cdcliente,
           java.lang.String cdclientecgq,
           org.apache.axis.types.UnsignedShort cdclientecgqedt,
           org.apache.axis.types.UnsignedShort cdproinjetedt,
           java.lang.String dapa,
           org.apache.axis.types.UnsignedShort dapaedt,
           java.util.Calendar dtfabricacao,
           org.apache.axis.types.UnsignedShort dtfabricacaoedt,
           java.util.Calendar dthralteracao,
           java.util.Calendar dtvalidade,
           org.apache.axis.types.UnsignedShort dtvalidadeedt,
           java.lang.Double du,
           org.apache.axis.types.UnsignedShort enviohabilitado,
           org.apache.axis.types.UnsignedShort enviointernohab,
           java.lang.String etiquetas,
           org.apache.axis.types.UnsignedShort etiquetasedt,
           java.lang.String fep,
           org.apache.axis.types.UnsignedShort fepedt,
           org.apache.axis.types.UnsignedShort houvealteramstr,
           double idctrlaltcgq,
           idw.idwws.Ijamstraltcgq[] ijamstraltcgqs,
           idw.idwws.Ijctrlcgq ijctrlcgq,
           idw.idwws.Ijctrlcgqxctts[] ijctrlcgqxcttses,
           idw.idwws.Ijctrlcgqxmprima[] ijctrlcgqxmprimas,
           idw.idwws.Ijctrlcgqxplantas[] ijctrlcgqxplantases,
           idw.idwws.Ijduimpressaocgq[] ijduimpressaocgqs,
           idw.idwws.Ijtbpro ijtbpro,
           idw.idwws.Ijtbusu ijtbusu,
           org.apache.axis.types.UnsignedShort novoresultado,
           java.lang.String nrnota,
           org.apache.axis.types.UnsignedShort nrnotaedt,
           java.lang.String nropdurev,
           org.apache.axis.types.UnsignedShort nropedt,
           java.lang.String obsalteracao,
           java.lang.String obscgq,
           org.apache.axis.types.UnsignedShort obscgqedt,
           java.lang.String obsdu,
           org.apache.axis.types.UnsignedShort obsduedt,
           java.math.BigDecimal qtdpcsaval,
           org.apache.axis.types.UnsignedShort qtdpcsavaledt,
           org.apache.axis.types.UnsignedShort resultadoinspecao,
           java.math.BigDecimal revisao,
           org.apache.axis.types.UnsignedShort stregistro) {
           this.cavidades = cavidades;
           this.cavidadesedt = cavidadesedt;
           this.cdcimplast = cdcimplast;
           this.cdcimplastedt = cdcimplastedt;
           this.cdcliente = cdcliente;
           this.cdclientecgq = cdclientecgq;
           this.cdclientecgqedt = cdclientecgqedt;
           this.cdproinjetedt = cdproinjetedt;
           this.dapa = dapa;
           this.dapaedt = dapaedt;
           this.dtfabricacao = dtfabricacao;
           this.dtfabricacaoedt = dtfabricacaoedt;
           this.dthralteracao = dthralteracao;
           this.dtvalidade = dtvalidade;
           this.dtvalidadeedt = dtvalidadeedt;
           this.du = du;
           this.enviohabilitado = enviohabilitado;
           this.enviointernohab = enviointernohab;
           this.etiquetas = etiquetas;
           this.etiquetasedt = etiquetasedt;
           this.fep = fep;
           this.fepedt = fepedt;
           this.houvealteramstr = houvealteramstr;
           this.idctrlaltcgq = idctrlaltcgq;
           this.ijamstraltcgqs = ijamstraltcgqs;
           this.ijctrlcgq = ijctrlcgq;
           this.ijctrlcgqxcttses = ijctrlcgqxcttses;
           this.ijctrlcgqxmprimas = ijctrlcgqxmprimas;
           this.ijctrlcgqxplantases = ijctrlcgqxplantases;
           this.ijduimpressaocgqs = ijduimpressaocgqs;
           this.ijtbpro = ijtbpro;
           this.ijtbusu = ijtbusu;
           this.novoresultado = novoresultado;
           this.nrnota = nrnota;
           this.nrnotaedt = nrnotaedt;
           this.nropdurev = nropdurev;
           this.nropedt = nropedt;
           this.obsalteracao = obsalteracao;
           this.obscgq = obscgq;
           this.obscgqedt = obscgqedt;
           this.obsdu = obsdu;
           this.obsduedt = obsduedt;
           this.qtdpcsaval = qtdpcsaval;
           this.qtdpcsavaledt = qtdpcsavaledt;
           this.resultadoinspecao = resultadoinspecao;
           this.revisao = revisao;
           this.stregistro = stregistro;
    }


    /**
     * Gets the cavidades value for this Ijctrlcgqalt.
     * 
     * @return cavidades
     */
    public java.lang.String getCavidades() {
        return cavidades;
    }


    /**
     * Sets the cavidades value for this Ijctrlcgqalt.
     * 
     * @param cavidades
     */
    public void setCavidades(java.lang.String cavidades) {
        this.cavidades = cavidades;
    }


    /**
     * Gets the cavidadesedt value for this Ijctrlcgqalt.
     * 
     * @return cavidadesedt
     */
    public org.apache.axis.types.UnsignedShort getCavidadesedt() {
        return cavidadesedt;
    }


    /**
     * Sets the cavidadesedt value for this Ijctrlcgqalt.
     * 
     * @param cavidadesedt
     */
    public void setCavidadesedt(org.apache.axis.types.UnsignedShort cavidadesedt) {
        this.cavidadesedt = cavidadesedt;
    }


    /**
     * Gets the cdcimplast value for this Ijctrlcgqalt.
     * 
     * @return cdcimplast
     */
    public java.lang.String getCdcimplast() {
        return cdcimplast;
    }


    /**
     * Sets the cdcimplast value for this Ijctrlcgqalt.
     * 
     * @param cdcimplast
     */
    public void setCdcimplast(java.lang.String cdcimplast) {
        this.cdcimplast = cdcimplast;
    }


    /**
     * Gets the cdcimplastedt value for this Ijctrlcgqalt.
     * 
     * @return cdcimplastedt
     */
    public org.apache.axis.types.UnsignedShort getCdcimplastedt() {
        return cdcimplastedt;
    }


    /**
     * Sets the cdcimplastedt value for this Ijctrlcgqalt.
     * 
     * @param cdcimplastedt
     */
    public void setCdcimplastedt(org.apache.axis.types.UnsignedShort cdcimplastedt) {
        this.cdcimplastedt = cdcimplastedt;
    }


    /**
     * Gets the cdcliente value for this Ijctrlcgqalt.
     * 
     * @return cdcliente
     */
    public java.lang.String getCdcliente() {
        return cdcliente;
    }


    /**
     * Sets the cdcliente value for this Ijctrlcgqalt.
     * 
     * @param cdcliente
     */
    public void setCdcliente(java.lang.String cdcliente) {
        this.cdcliente = cdcliente;
    }


    /**
     * Gets the cdclientecgq value for this Ijctrlcgqalt.
     * 
     * @return cdclientecgq
     */
    public java.lang.String getCdclientecgq() {
        return cdclientecgq;
    }


    /**
     * Sets the cdclientecgq value for this Ijctrlcgqalt.
     * 
     * @param cdclientecgq
     */
    public void setCdclientecgq(java.lang.String cdclientecgq) {
        this.cdclientecgq = cdclientecgq;
    }


    /**
     * Gets the cdclientecgqedt value for this Ijctrlcgqalt.
     * 
     * @return cdclientecgqedt
     */
    public org.apache.axis.types.UnsignedShort getCdclientecgqedt() {
        return cdclientecgqedt;
    }


    /**
     * Sets the cdclientecgqedt value for this Ijctrlcgqalt.
     * 
     * @param cdclientecgqedt
     */
    public void setCdclientecgqedt(org.apache.axis.types.UnsignedShort cdclientecgqedt) {
        this.cdclientecgqedt = cdclientecgqedt;
    }


    /**
     * Gets the cdproinjetedt value for this Ijctrlcgqalt.
     * 
     * @return cdproinjetedt
     */
    public org.apache.axis.types.UnsignedShort getCdproinjetedt() {
        return cdproinjetedt;
    }


    /**
     * Sets the cdproinjetedt value for this Ijctrlcgqalt.
     * 
     * @param cdproinjetedt
     */
    public void setCdproinjetedt(org.apache.axis.types.UnsignedShort cdproinjetedt) {
        this.cdproinjetedt = cdproinjetedt;
    }


    /**
     * Gets the dapa value for this Ijctrlcgqalt.
     * 
     * @return dapa
     */
    public java.lang.String getDapa() {
        return dapa;
    }


    /**
     * Sets the dapa value for this Ijctrlcgqalt.
     * 
     * @param dapa
     */
    public void setDapa(java.lang.String dapa) {
        this.dapa = dapa;
    }


    /**
     * Gets the dapaedt value for this Ijctrlcgqalt.
     * 
     * @return dapaedt
     */
    public org.apache.axis.types.UnsignedShort getDapaedt() {
        return dapaedt;
    }


    /**
     * Sets the dapaedt value for this Ijctrlcgqalt.
     * 
     * @param dapaedt
     */
    public void setDapaedt(org.apache.axis.types.UnsignedShort dapaedt) {
        this.dapaedt = dapaedt;
    }


    /**
     * Gets the dtfabricacao value for this Ijctrlcgqalt.
     * 
     * @return dtfabricacao
     */
    public java.util.Calendar getDtfabricacao() {
        return dtfabricacao;
    }


    /**
     * Sets the dtfabricacao value for this Ijctrlcgqalt.
     * 
     * @param dtfabricacao
     */
    public void setDtfabricacao(java.util.Calendar dtfabricacao) {
        this.dtfabricacao = dtfabricacao;
    }


    /**
     * Gets the dtfabricacaoedt value for this Ijctrlcgqalt.
     * 
     * @return dtfabricacaoedt
     */
    public org.apache.axis.types.UnsignedShort getDtfabricacaoedt() {
        return dtfabricacaoedt;
    }


    /**
     * Sets the dtfabricacaoedt value for this Ijctrlcgqalt.
     * 
     * @param dtfabricacaoedt
     */
    public void setDtfabricacaoedt(org.apache.axis.types.UnsignedShort dtfabricacaoedt) {
        this.dtfabricacaoedt = dtfabricacaoedt;
    }


    /**
     * Gets the dthralteracao value for this Ijctrlcgqalt.
     * 
     * @return dthralteracao
     */
    public java.util.Calendar getDthralteracao() {
        return dthralteracao;
    }


    /**
     * Sets the dthralteracao value for this Ijctrlcgqalt.
     * 
     * @param dthralteracao
     */
    public void setDthralteracao(java.util.Calendar dthralteracao) {
        this.dthralteracao = dthralteracao;
    }


    /**
     * Gets the dtvalidade value for this Ijctrlcgqalt.
     * 
     * @return dtvalidade
     */
    public java.util.Calendar getDtvalidade() {
        return dtvalidade;
    }


    /**
     * Sets the dtvalidade value for this Ijctrlcgqalt.
     * 
     * @param dtvalidade
     */
    public void setDtvalidade(java.util.Calendar dtvalidade) {
        this.dtvalidade = dtvalidade;
    }


    /**
     * Gets the dtvalidadeedt value for this Ijctrlcgqalt.
     * 
     * @return dtvalidadeedt
     */
    public org.apache.axis.types.UnsignedShort getDtvalidadeedt() {
        return dtvalidadeedt;
    }


    /**
     * Sets the dtvalidadeedt value for this Ijctrlcgqalt.
     * 
     * @param dtvalidadeedt
     */
    public void setDtvalidadeedt(org.apache.axis.types.UnsignedShort dtvalidadeedt) {
        this.dtvalidadeedt = dtvalidadeedt;
    }


    /**
     * Gets the du value for this Ijctrlcgqalt.
     * 
     * @return du
     */
    public java.lang.Double getDu() {
        return du;
    }


    /**
     * Sets the du value for this Ijctrlcgqalt.
     * 
     * @param du
     */
    public void setDu(java.lang.Double du) {
        this.du = du;
    }


    /**
     * Gets the enviohabilitado value for this Ijctrlcgqalt.
     * 
     * @return enviohabilitado
     */
    public org.apache.axis.types.UnsignedShort getEnviohabilitado() {
        return enviohabilitado;
    }


    /**
     * Sets the enviohabilitado value for this Ijctrlcgqalt.
     * 
     * @param enviohabilitado
     */
    public void setEnviohabilitado(org.apache.axis.types.UnsignedShort enviohabilitado) {
        this.enviohabilitado = enviohabilitado;
    }


    /**
     * Gets the enviointernohab value for this Ijctrlcgqalt.
     * 
     * @return enviointernohab
     */
    public org.apache.axis.types.UnsignedShort getEnviointernohab() {
        return enviointernohab;
    }


    /**
     * Sets the enviointernohab value for this Ijctrlcgqalt.
     * 
     * @param enviointernohab
     */
    public void setEnviointernohab(org.apache.axis.types.UnsignedShort enviointernohab) {
        this.enviointernohab = enviointernohab;
    }


    /**
     * Gets the etiquetas value for this Ijctrlcgqalt.
     * 
     * @return etiquetas
     */
    public java.lang.String getEtiquetas() {
        return etiquetas;
    }


    /**
     * Sets the etiquetas value for this Ijctrlcgqalt.
     * 
     * @param etiquetas
     */
    public void setEtiquetas(java.lang.String etiquetas) {
        this.etiquetas = etiquetas;
    }


    /**
     * Gets the etiquetasedt value for this Ijctrlcgqalt.
     * 
     * @return etiquetasedt
     */
    public org.apache.axis.types.UnsignedShort getEtiquetasedt() {
        return etiquetasedt;
    }


    /**
     * Sets the etiquetasedt value for this Ijctrlcgqalt.
     * 
     * @param etiquetasedt
     */
    public void setEtiquetasedt(org.apache.axis.types.UnsignedShort etiquetasedt) {
        this.etiquetasedt = etiquetasedt;
    }


    /**
     * Gets the fep value for this Ijctrlcgqalt.
     * 
     * @return fep
     */
    public java.lang.String getFep() {
        return fep;
    }


    /**
     * Sets the fep value for this Ijctrlcgqalt.
     * 
     * @param fep
     */
    public void setFep(java.lang.String fep) {
        this.fep = fep;
    }


    /**
     * Gets the fepedt value for this Ijctrlcgqalt.
     * 
     * @return fepedt
     */
    public org.apache.axis.types.UnsignedShort getFepedt() {
        return fepedt;
    }


    /**
     * Sets the fepedt value for this Ijctrlcgqalt.
     * 
     * @param fepedt
     */
    public void setFepedt(org.apache.axis.types.UnsignedShort fepedt) {
        this.fepedt = fepedt;
    }


    /**
     * Gets the houvealteramstr value for this Ijctrlcgqalt.
     * 
     * @return houvealteramstr
     */
    public org.apache.axis.types.UnsignedShort getHouvealteramstr() {
        return houvealteramstr;
    }


    /**
     * Sets the houvealteramstr value for this Ijctrlcgqalt.
     * 
     * @param houvealteramstr
     */
    public void setHouvealteramstr(org.apache.axis.types.UnsignedShort houvealteramstr) {
        this.houvealteramstr = houvealteramstr;
    }


    /**
     * Gets the idctrlaltcgq value for this Ijctrlcgqalt.
     * 
     * @return idctrlaltcgq
     */
    public double getIdctrlaltcgq() {
        return idctrlaltcgq;
    }


    /**
     * Sets the idctrlaltcgq value for this Ijctrlcgqalt.
     * 
     * @param idctrlaltcgq
     */
    public void setIdctrlaltcgq(double idctrlaltcgq) {
        this.idctrlaltcgq = idctrlaltcgq;
    }


    /**
     * Gets the ijamstraltcgqs value for this Ijctrlcgqalt.
     * 
     * @return ijamstraltcgqs
     */
    public idw.idwws.Ijamstraltcgq[] getIjamstraltcgqs() {
        return ijamstraltcgqs;
    }


    /**
     * Sets the ijamstraltcgqs value for this Ijctrlcgqalt.
     * 
     * @param ijamstraltcgqs
     */
    public void setIjamstraltcgqs(idw.idwws.Ijamstraltcgq[] ijamstraltcgqs) {
        this.ijamstraltcgqs = ijamstraltcgqs;
    }

    public idw.idwws.Ijamstraltcgq getIjamstraltcgqs(int i) {
        return this.ijamstraltcgqs[i];
    }

    public void setIjamstraltcgqs(int i, idw.idwws.Ijamstraltcgq _value) {
        this.ijamstraltcgqs[i] = _value;
    }


    /**
     * Gets the ijctrlcgq value for this Ijctrlcgqalt.
     * 
     * @return ijctrlcgq
     */
    public idw.idwws.Ijctrlcgq getIjctrlcgq() {
        return ijctrlcgq;
    }


    /**
     * Sets the ijctrlcgq value for this Ijctrlcgqalt.
     * 
     * @param ijctrlcgq
     */
    public void setIjctrlcgq(idw.idwws.Ijctrlcgq ijctrlcgq) {
        this.ijctrlcgq = ijctrlcgq;
    }


    /**
     * Gets the ijctrlcgqxcttses value for this Ijctrlcgqalt.
     * 
     * @return ijctrlcgqxcttses
     */
    public idw.idwws.Ijctrlcgqxctts[] getIjctrlcgqxcttses() {
        return ijctrlcgqxcttses;
    }


    /**
     * Sets the ijctrlcgqxcttses value for this Ijctrlcgqalt.
     * 
     * @param ijctrlcgqxcttses
     */
    public void setIjctrlcgqxcttses(idw.idwws.Ijctrlcgqxctts[] ijctrlcgqxcttses) {
        this.ijctrlcgqxcttses = ijctrlcgqxcttses;
    }

    public idw.idwws.Ijctrlcgqxctts getIjctrlcgqxcttses(int i) {
        return this.ijctrlcgqxcttses[i];
    }

    public void setIjctrlcgqxcttses(int i, idw.idwws.Ijctrlcgqxctts _value) {
        this.ijctrlcgqxcttses[i] = _value;
    }


    /**
     * Gets the ijctrlcgqxmprimas value for this Ijctrlcgqalt.
     * 
     * @return ijctrlcgqxmprimas
     */
    public idw.idwws.Ijctrlcgqxmprima[] getIjctrlcgqxmprimas() {
        return ijctrlcgqxmprimas;
    }


    /**
     * Sets the ijctrlcgqxmprimas value for this Ijctrlcgqalt.
     * 
     * @param ijctrlcgqxmprimas
     */
    public void setIjctrlcgqxmprimas(idw.idwws.Ijctrlcgqxmprima[] ijctrlcgqxmprimas) {
        this.ijctrlcgqxmprimas = ijctrlcgqxmprimas;
    }

    public idw.idwws.Ijctrlcgqxmprima getIjctrlcgqxmprimas(int i) {
        return this.ijctrlcgqxmprimas[i];
    }

    public void setIjctrlcgqxmprimas(int i, idw.idwws.Ijctrlcgqxmprima _value) {
        this.ijctrlcgqxmprimas[i] = _value;
    }


    /**
     * Gets the ijctrlcgqxplantases value for this Ijctrlcgqalt.
     * 
     * @return ijctrlcgqxplantases
     */
    public idw.idwws.Ijctrlcgqxplantas[] getIjctrlcgqxplantases() {
        return ijctrlcgqxplantases;
    }


    /**
     * Sets the ijctrlcgqxplantases value for this Ijctrlcgqalt.
     * 
     * @param ijctrlcgqxplantases
     */
    public void setIjctrlcgqxplantases(idw.idwws.Ijctrlcgqxplantas[] ijctrlcgqxplantases) {
        this.ijctrlcgqxplantases = ijctrlcgqxplantases;
    }

    public idw.idwws.Ijctrlcgqxplantas getIjctrlcgqxplantases(int i) {
        return this.ijctrlcgqxplantases[i];
    }

    public void setIjctrlcgqxplantases(int i, idw.idwws.Ijctrlcgqxplantas _value) {
        this.ijctrlcgqxplantases[i] = _value;
    }


    /**
     * Gets the ijduimpressaocgqs value for this Ijctrlcgqalt.
     * 
     * @return ijduimpressaocgqs
     */
    public idw.idwws.Ijduimpressaocgq[] getIjduimpressaocgqs() {
        return ijduimpressaocgqs;
    }


    /**
     * Sets the ijduimpressaocgqs value for this Ijctrlcgqalt.
     * 
     * @param ijduimpressaocgqs
     */
    public void setIjduimpressaocgqs(idw.idwws.Ijduimpressaocgq[] ijduimpressaocgqs) {
        this.ijduimpressaocgqs = ijduimpressaocgqs;
    }

    public idw.idwws.Ijduimpressaocgq getIjduimpressaocgqs(int i) {
        return this.ijduimpressaocgqs[i];
    }

    public void setIjduimpressaocgqs(int i, idw.idwws.Ijduimpressaocgq _value) {
        this.ijduimpressaocgqs[i] = _value;
    }


    /**
     * Gets the ijtbpro value for this Ijctrlcgqalt.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijctrlcgqalt.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the ijtbusu value for this Ijctrlcgqalt.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijctrlcgqalt.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the novoresultado value for this Ijctrlcgqalt.
     * 
     * @return novoresultado
     */
    public org.apache.axis.types.UnsignedShort getNovoresultado() {
        return novoresultado;
    }


    /**
     * Sets the novoresultado value for this Ijctrlcgqalt.
     * 
     * @param novoresultado
     */
    public void setNovoresultado(org.apache.axis.types.UnsignedShort novoresultado) {
        this.novoresultado = novoresultado;
    }


    /**
     * Gets the nrnota value for this Ijctrlcgqalt.
     * 
     * @return nrnota
     */
    public java.lang.String getNrnota() {
        return nrnota;
    }


    /**
     * Sets the nrnota value for this Ijctrlcgqalt.
     * 
     * @param nrnota
     */
    public void setNrnota(java.lang.String nrnota) {
        this.nrnota = nrnota;
    }


    /**
     * Gets the nrnotaedt value for this Ijctrlcgqalt.
     * 
     * @return nrnotaedt
     */
    public org.apache.axis.types.UnsignedShort getNrnotaedt() {
        return nrnotaedt;
    }


    /**
     * Sets the nrnotaedt value for this Ijctrlcgqalt.
     * 
     * @param nrnotaedt
     */
    public void setNrnotaedt(org.apache.axis.types.UnsignedShort nrnotaedt) {
        this.nrnotaedt = nrnotaedt;
    }


    /**
     * Gets the nropdurev value for this Ijctrlcgqalt.
     * 
     * @return nropdurev
     */
    public java.lang.String getNropdurev() {
        return nropdurev;
    }


    /**
     * Sets the nropdurev value for this Ijctrlcgqalt.
     * 
     * @param nropdurev
     */
    public void setNropdurev(java.lang.String nropdurev) {
        this.nropdurev = nropdurev;
    }


    /**
     * Gets the nropedt value for this Ijctrlcgqalt.
     * 
     * @return nropedt
     */
    public org.apache.axis.types.UnsignedShort getNropedt() {
        return nropedt;
    }


    /**
     * Sets the nropedt value for this Ijctrlcgqalt.
     * 
     * @param nropedt
     */
    public void setNropedt(org.apache.axis.types.UnsignedShort nropedt) {
        this.nropedt = nropedt;
    }


    /**
     * Gets the obsalteracao value for this Ijctrlcgqalt.
     * 
     * @return obsalteracao
     */
    public java.lang.String getObsalteracao() {
        return obsalteracao;
    }


    /**
     * Sets the obsalteracao value for this Ijctrlcgqalt.
     * 
     * @param obsalteracao
     */
    public void setObsalteracao(java.lang.String obsalteracao) {
        this.obsalteracao = obsalteracao;
    }


    /**
     * Gets the obscgq value for this Ijctrlcgqalt.
     * 
     * @return obscgq
     */
    public java.lang.String getObscgq() {
        return obscgq;
    }


    /**
     * Sets the obscgq value for this Ijctrlcgqalt.
     * 
     * @param obscgq
     */
    public void setObscgq(java.lang.String obscgq) {
        this.obscgq = obscgq;
    }


    /**
     * Gets the obscgqedt value for this Ijctrlcgqalt.
     * 
     * @return obscgqedt
     */
    public org.apache.axis.types.UnsignedShort getObscgqedt() {
        return obscgqedt;
    }


    /**
     * Sets the obscgqedt value for this Ijctrlcgqalt.
     * 
     * @param obscgqedt
     */
    public void setObscgqedt(org.apache.axis.types.UnsignedShort obscgqedt) {
        this.obscgqedt = obscgqedt;
    }


    /**
     * Gets the obsdu value for this Ijctrlcgqalt.
     * 
     * @return obsdu
     */
    public java.lang.String getObsdu() {
        return obsdu;
    }


    /**
     * Sets the obsdu value for this Ijctrlcgqalt.
     * 
     * @param obsdu
     */
    public void setObsdu(java.lang.String obsdu) {
        this.obsdu = obsdu;
    }


    /**
     * Gets the obsduedt value for this Ijctrlcgqalt.
     * 
     * @return obsduedt
     */
    public org.apache.axis.types.UnsignedShort getObsduedt() {
        return obsduedt;
    }


    /**
     * Sets the obsduedt value for this Ijctrlcgqalt.
     * 
     * @param obsduedt
     */
    public void setObsduedt(org.apache.axis.types.UnsignedShort obsduedt) {
        this.obsduedt = obsduedt;
    }


    /**
     * Gets the qtdpcsaval value for this Ijctrlcgqalt.
     * 
     * @return qtdpcsaval
     */
    public java.math.BigDecimal getQtdpcsaval() {
        return qtdpcsaval;
    }


    /**
     * Sets the qtdpcsaval value for this Ijctrlcgqalt.
     * 
     * @param qtdpcsaval
     */
    public void setQtdpcsaval(java.math.BigDecimal qtdpcsaval) {
        this.qtdpcsaval = qtdpcsaval;
    }


    /**
     * Gets the qtdpcsavaledt value for this Ijctrlcgqalt.
     * 
     * @return qtdpcsavaledt
     */
    public org.apache.axis.types.UnsignedShort getQtdpcsavaledt() {
        return qtdpcsavaledt;
    }


    /**
     * Sets the qtdpcsavaledt value for this Ijctrlcgqalt.
     * 
     * @param qtdpcsavaledt
     */
    public void setQtdpcsavaledt(org.apache.axis.types.UnsignedShort qtdpcsavaledt) {
        this.qtdpcsavaledt = qtdpcsavaledt;
    }


    /**
     * Gets the resultadoinspecao value for this Ijctrlcgqalt.
     * 
     * @return resultadoinspecao
     */
    public org.apache.axis.types.UnsignedShort getResultadoinspecao() {
        return resultadoinspecao;
    }


    /**
     * Sets the resultadoinspecao value for this Ijctrlcgqalt.
     * 
     * @param resultadoinspecao
     */
    public void setResultadoinspecao(org.apache.axis.types.UnsignedShort resultadoinspecao) {
        this.resultadoinspecao = resultadoinspecao;
    }


    /**
     * Gets the revisao value for this Ijctrlcgqalt.
     * 
     * @return revisao
     */
    public java.math.BigDecimal getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this Ijctrlcgqalt.
     * 
     * @param revisao
     */
    public void setRevisao(java.math.BigDecimal revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stregistro value for this Ijctrlcgqalt.
     * 
     * @return stregistro
     */
    public org.apache.axis.types.UnsignedShort getStregistro() {
        return stregistro;
    }


    /**
     * Sets the stregistro value for this Ijctrlcgqalt.
     * 
     * @param stregistro
     */
    public void setStregistro(org.apache.axis.types.UnsignedShort stregistro) {
        this.stregistro = stregistro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijctrlcgqalt)) return false;
        Ijctrlcgqalt other = (Ijctrlcgqalt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cavidades==null && other.getCavidades()==null) || 
             (this.cavidades!=null &&
              this.cavidades.equals(other.getCavidades()))) &&
            ((this.cavidadesedt==null && other.getCavidadesedt()==null) || 
             (this.cavidadesedt!=null &&
              this.cavidadesedt.equals(other.getCavidadesedt()))) &&
            ((this.cdcimplast==null && other.getCdcimplast()==null) || 
             (this.cdcimplast!=null &&
              this.cdcimplast.equals(other.getCdcimplast()))) &&
            ((this.cdcimplastedt==null && other.getCdcimplastedt()==null) || 
             (this.cdcimplastedt!=null &&
              this.cdcimplastedt.equals(other.getCdcimplastedt()))) &&
            ((this.cdcliente==null && other.getCdcliente()==null) || 
             (this.cdcliente!=null &&
              this.cdcliente.equals(other.getCdcliente()))) &&
            ((this.cdclientecgq==null && other.getCdclientecgq()==null) || 
             (this.cdclientecgq!=null &&
              this.cdclientecgq.equals(other.getCdclientecgq()))) &&
            ((this.cdclientecgqedt==null && other.getCdclientecgqedt()==null) || 
             (this.cdclientecgqedt!=null &&
              this.cdclientecgqedt.equals(other.getCdclientecgqedt()))) &&
            ((this.cdproinjetedt==null && other.getCdproinjetedt()==null) || 
             (this.cdproinjetedt!=null &&
              this.cdproinjetedt.equals(other.getCdproinjetedt()))) &&
            ((this.dapa==null && other.getDapa()==null) || 
             (this.dapa!=null &&
              this.dapa.equals(other.getDapa()))) &&
            ((this.dapaedt==null && other.getDapaedt()==null) || 
             (this.dapaedt!=null &&
              this.dapaedt.equals(other.getDapaedt()))) &&
            ((this.dtfabricacao==null && other.getDtfabricacao()==null) || 
             (this.dtfabricacao!=null &&
              this.dtfabricacao.equals(other.getDtfabricacao()))) &&
            ((this.dtfabricacaoedt==null && other.getDtfabricacaoedt()==null) || 
             (this.dtfabricacaoedt!=null &&
              this.dtfabricacaoedt.equals(other.getDtfabricacaoedt()))) &&
            ((this.dthralteracao==null && other.getDthralteracao()==null) || 
             (this.dthralteracao!=null &&
              this.dthralteracao.equals(other.getDthralteracao()))) &&
            ((this.dtvalidade==null && other.getDtvalidade()==null) || 
             (this.dtvalidade!=null &&
              this.dtvalidade.equals(other.getDtvalidade()))) &&
            ((this.dtvalidadeedt==null && other.getDtvalidadeedt()==null) || 
             (this.dtvalidadeedt!=null &&
              this.dtvalidadeedt.equals(other.getDtvalidadeedt()))) &&
            ((this.du==null && other.getDu()==null) || 
             (this.du!=null &&
              this.du.equals(other.getDu()))) &&
            ((this.enviohabilitado==null && other.getEnviohabilitado()==null) || 
             (this.enviohabilitado!=null &&
              this.enviohabilitado.equals(other.getEnviohabilitado()))) &&
            ((this.enviointernohab==null && other.getEnviointernohab()==null) || 
             (this.enviointernohab!=null &&
              this.enviointernohab.equals(other.getEnviointernohab()))) &&
            ((this.etiquetas==null && other.getEtiquetas()==null) || 
             (this.etiquetas!=null &&
              this.etiquetas.equals(other.getEtiquetas()))) &&
            ((this.etiquetasedt==null && other.getEtiquetasedt()==null) || 
             (this.etiquetasedt!=null &&
              this.etiquetasedt.equals(other.getEtiquetasedt()))) &&
            ((this.fep==null && other.getFep()==null) || 
             (this.fep!=null &&
              this.fep.equals(other.getFep()))) &&
            ((this.fepedt==null && other.getFepedt()==null) || 
             (this.fepedt!=null &&
              this.fepedt.equals(other.getFepedt()))) &&
            ((this.houvealteramstr==null && other.getHouvealteramstr()==null) || 
             (this.houvealteramstr!=null &&
              this.houvealteramstr.equals(other.getHouvealteramstr()))) &&
            this.idctrlaltcgq == other.getIdctrlaltcgq() &&
            ((this.ijamstraltcgqs==null && other.getIjamstraltcgqs()==null) || 
             (this.ijamstraltcgqs!=null &&
              java.util.Arrays.equals(this.ijamstraltcgqs, other.getIjamstraltcgqs()))) &&
            ((this.ijctrlcgq==null && other.getIjctrlcgq()==null) || 
             (this.ijctrlcgq!=null &&
              this.ijctrlcgq.equals(other.getIjctrlcgq()))) &&
            ((this.ijctrlcgqxcttses==null && other.getIjctrlcgqxcttses()==null) || 
             (this.ijctrlcgqxcttses!=null &&
              java.util.Arrays.equals(this.ijctrlcgqxcttses, other.getIjctrlcgqxcttses()))) &&
            ((this.ijctrlcgqxmprimas==null && other.getIjctrlcgqxmprimas()==null) || 
             (this.ijctrlcgqxmprimas!=null &&
              java.util.Arrays.equals(this.ijctrlcgqxmprimas, other.getIjctrlcgqxmprimas()))) &&
            ((this.ijctrlcgqxplantases==null && other.getIjctrlcgqxplantases()==null) || 
             (this.ijctrlcgqxplantases!=null &&
              java.util.Arrays.equals(this.ijctrlcgqxplantases, other.getIjctrlcgqxplantases()))) &&
            ((this.ijduimpressaocgqs==null && other.getIjduimpressaocgqs()==null) || 
             (this.ijduimpressaocgqs!=null &&
              java.util.Arrays.equals(this.ijduimpressaocgqs, other.getIjduimpressaocgqs()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu()))) &&
            ((this.novoresultado==null && other.getNovoresultado()==null) || 
             (this.novoresultado!=null &&
              this.novoresultado.equals(other.getNovoresultado()))) &&
            ((this.nrnota==null && other.getNrnota()==null) || 
             (this.nrnota!=null &&
              this.nrnota.equals(other.getNrnota()))) &&
            ((this.nrnotaedt==null && other.getNrnotaedt()==null) || 
             (this.nrnotaedt!=null &&
              this.nrnotaedt.equals(other.getNrnotaedt()))) &&
            ((this.nropdurev==null && other.getNropdurev()==null) || 
             (this.nropdurev!=null &&
              this.nropdurev.equals(other.getNropdurev()))) &&
            ((this.nropedt==null && other.getNropedt()==null) || 
             (this.nropedt!=null &&
              this.nropedt.equals(other.getNropedt()))) &&
            ((this.obsalteracao==null && other.getObsalteracao()==null) || 
             (this.obsalteracao!=null &&
              this.obsalteracao.equals(other.getObsalteracao()))) &&
            ((this.obscgq==null && other.getObscgq()==null) || 
             (this.obscgq!=null &&
              this.obscgq.equals(other.getObscgq()))) &&
            ((this.obscgqedt==null && other.getObscgqedt()==null) || 
             (this.obscgqedt!=null &&
              this.obscgqedt.equals(other.getObscgqedt()))) &&
            ((this.obsdu==null && other.getObsdu()==null) || 
             (this.obsdu!=null &&
              this.obsdu.equals(other.getObsdu()))) &&
            ((this.obsduedt==null && other.getObsduedt()==null) || 
             (this.obsduedt!=null &&
              this.obsduedt.equals(other.getObsduedt()))) &&
            ((this.qtdpcsaval==null && other.getQtdpcsaval()==null) || 
             (this.qtdpcsaval!=null &&
              this.qtdpcsaval.equals(other.getQtdpcsaval()))) &&
            ((this.qtdpcsavaledt==null && other.getQtdpcsavaledt()==null) || 
             (this.qtdpcsavaledt!=null &&
              this.qtdpcsavaledt.equals(other.getQtdpcsavaledt()))) &&
            ((this.resultadoinspecao==null && other.getResultadoinspecao()==null) || 
             (this.resultadoinspecao!=null &&
              this.resultadoinspecao.equals(other.getResultadoinspecao()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.stregistro==null && other.getStregistro()==null) || 
             (this.stregistro!=null &&
              this.stregistro.equals(other.getStregistro())));
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
        if (getCavidades() != null) {
            _hashCode += getCavidades().hashCode();
        }
        if (getCavidadesedt() != null) {
            _hashCode += getCavidadesedt().hashCode();
        }
        if (getCdcimplast() != null) {
            _hashCode += getCdcimplast().hashCode();
        }
        if (getCdcimplastedt() != null) {
            _hashCode += getCdcimplastedt().hashCode();
        }
        if (getCdcliente() != null) {
            _hashCode += getCdcliente().hashCode();
        }
        if (getCdclientecgq() != null) {
            _hashCode += getCdclientecgq().hashCode();
        }
        if (getCdclientecgqedt() != null) {
            _hashCode += getCdclientecgqedt().hashCode();
        }
        if (getCdproinjetedt() != null) {
            _hashCode += getCdproinjetedt().hashCode();
        }
        if (getDapa() != null) {
            _hashCode += getDapa().hashCode();
        }
        if (getDapaedt() != null) {
            _hashCode += getDapaedt().hashCode();
        }
        if (getDtfabricacao() != null) {
            _hashCode += getDtfabricacao().hashCode();
        }
        if (getDtfabricacaoedt() != null) {
            _hashCode += getDtfabricacaoedt().hashCode();
        }
        if (getDthralteracao() != null) {
            _hashCode += getDthralteracao().hashCode();
        }
        if (getDtvalidade() != null) {
            _hashCode += getDtvalidade().hashCode();
        }
        if (getDtvalidadeedt() != null) {
            _hashCode += getDtvalidadeedt().hashCode();
        }
        if (getDu() != null) {
            _hashCode += getDu().hashCode();
        }
        if (getEnviohabilitado() != null) {
            _hashCode += getEnviohabilitado().hashCode();
        }
        if (getEnviointernohab() != null) {
            _hashCode += getEnviointernohab().hashCode();
        }
        if (getEtiquetas() != null) {
            _hashCode += getEtiquetas().hashCode();
        }
        if (getEtiquetasedt() != null) {
            _hashCode += getEtiquetasedt().hashCode();
        }
        if (getFep() != null) {
            _hashCode += getFep().hashCode();
        }
        if (getFepedt() != null) {
            _hashCode += getFepedt().hashCode();
        }
        if (getHouvealteramstr() != null) {
            _hashCode += getHouvealteramstr().hashCode();
        }
        _hashCode += new Double(getIdctrlaltcgq()).hashCode();
        if (getIjamstraltcgqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjamstraltcgqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjamstraltcgqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjctrlcgq() != null) {
            _hashCode += getIjctrlcgq().hashCode();
        }
        if (getIjctrlcgqxcttses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjctrlcgqxcttses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjctrlcgqxcttses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjctrlcgqxmprimas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjctrlcgqxmprimas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjctrlcgqxmprimas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjctrlcgqxplantases() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjctrlcgqxplantases());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjctrlcgqxplantases(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjduimpressaocgqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjduimpressaocgqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjduimpressaocgqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        if (getNovoresultado() != null) {
            _hashCode += getNovoresultado().hashCode();
        }
        if (getNrnota() != null) {
            _hashCode += getNrnota().hashCode();
        }
        if (getNrnotaedt() != null) {
            _hashCode += getNrnotaedt().hashCode();
        }
        if (getNropdurev() != null) {
            _hashCode += getNropdurev().hashCode();
        }
        if (getNropedt() != null) {
            _hashCode += getNropedt().hashCode();
        }
        if (getObsalteracao() != null) {
            _hashCode += getObsalteracao().hashCode();
        }
        if (getObscgq() != null) {
            _hashCode += getObscgq().hashCode();
        }
        if (getObscgqedt() != null) {
            _hashCode += getObscgqedt().hashCode();
        }
        if (getObsdu() != null) {
            _hashCode += getObsdu().hashCode();
        }
        if (getObsduedt() != null) {
            _hashCode += getObsduedt().hashCode();
        }
        if (getQtdpcsaval() != null) {
            _hashCode += getQtdpcsaval().hashCode();
        }
        if (getQtdpcsavaledt() != null) {
            _hashCode += getQtdpcsavaledt().hashCode();
        }
        if (getResultadoinspecao() != null) {
            _hashCode += getResultadoinspecao().hashCode();
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getStregistro() != null) {
            _hashCode += getStregistro().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijctrlcgqalt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlcgqalt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cavidades");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cavidades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cavidadesedt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cavidadesedt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcimplast");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcimplast"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcimplastedt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcimplastedt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdclientecgq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdclientecgq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdclientecgqedt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdclientecgqedt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdproinjetedt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdproinjetedt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dapaedt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dapaedt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtfabricacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtfabricacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtfabricacaoedt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtfabricacaoedt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthralteracao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthralteracao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtvalidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtvalidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtvalidadeedt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtvalidadeedt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("du");
        elemField.setXmlName(new javax.xml.namespace.QName("", "du"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enviohabilitado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "enviohabilitado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enviointernohab");
        elemField.setXmlName(new javax.xml.namespace.QName("", "enviointernohab"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etiquetas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "etiquetas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etiquetasedt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "etiquetasedt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fep");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fepedt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fepedt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("houvealteramstr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "houvealteramstr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idctrlaltcgq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idctrlaltcgq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijamstraltcgqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijamstraltcgqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamstraltcgq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrlcgq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrlcgq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlcgq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrlcgqxcttses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrlcgqxcttses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlcgqxctts"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrlcgqxmprimas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrlcgqxmprimas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlcgqxmprima"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrlcgqxplantases");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrlcgqxplantases"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlcgqxplantas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijduimpressaocgqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijduimpressaocgqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijduimpressaocgq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("novoresultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "novoresultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrnota");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrnota"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrnotaedt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrnotaedt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nropdurev");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nropdurev"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nropedt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nropedt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obsalteracao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "obsalteracao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obscgq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "obscgq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obscgqedt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "obscgqedt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obsdu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "obsdu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obsduedt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "obsduedt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdpcsaval");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdpcsaval"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdpcsavaledt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdpcsavaledt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoinspecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoinspecao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "revisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stregistro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stregistro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
