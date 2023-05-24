/**
 * OmTppt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmTppt  extends idw.idwws.OmTpptTemplate  implements java.io.Serializable {
    private java.lang.String cdTppt;

    private java.lang.String dsTppt;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private idw.idwws.DwFolha[] dwFolhas;

    private idw.idwws.DwTAcao[] dwTAcaos;

    private idw.idwws.DwTAlerta[] dwTAlertas;

    private idw.idwws.DwTDefeito[] dwTDefeitos;

    private idw.idwws.DwTParada[] dwTParadas;

    private idw.idwws.DwTRefugo[] dwTRefugos;

    private long idTppt;

    private idw.idwws.OmAlgocor omAlgocor;

    private idw.idwws.OmCfg[] omCfgsForIdTpptInsersora;

    private idw.idwws.OmCfg[] omCfgsForIdTpptPm;

    private idw.idwws.OmCfg[] omCfgsForIdTpptPpass;

    private idw.idwws.OmCfg[] omCfgsForIdTpptPrepro;

    private idw.idwws.OmCfg[] omCfgsForIdTpptPtf;

    private idw.idwws.OmCfg[] omCfgsForIdTpptPts;

    private idw.idwws.OmCfg[] omCfgsForIdTpptPtscd;

    private idw.idwws.OmIndtppt[] omIndtppts;

    private idw.idwws.OmPt[] omPts;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public OmTppt() {
    }

    public OmTppt(
           java.lang.Long id,
           java.lang.String cdTppt,
           java.lang.String dsTppt,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           idw.idwws.DwFolha[] dwFolhas,
           idw.idwws.DwTAcao[] dwTAcaos,
           idw.idwws.DwTAlerta[] dwTAlertas,
           idw.idwws.DwTDefeito[] dwTDefeitos,
           idw.idwws.DwTParada[] dwTParadas,
           idw.idwws.DwTRefugo[] dwTRefugos,
           long idTppt,
           idw.idwws.OmAlgocor omAlgocor,
           idw.idwws.OmCfg[] omCfgsForIdTpptInsersora,
           idw.idwws.OmCfg[] omCfgsForIdTpptPm,
           idw.idwws.OmCfg[] omCfgsForIdTpptPpass,
           idw.idwws.OmCfg[] omCfgsForIdTpptPrepro,
           idw.idwws.OmCfg[] omCfgsForIdTpptPtf,
           idw.idwws.OmCfg[] omCfgsForIdTpptPts,
           idw.idwws.OmCfg[] omCfgsForIdTpptPtscd,
           idw.idwws.OmIndtppt[] omIndtppts,
           idw.idwws.OmPt[] omPts,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        super(
            id);
        this.cdTppt = cdTppt;
        this.dsTppt = dsTppt;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dwFolhas = dwFolhas;
        this.dwTAcaos = dwTAcaos;
        this.dwTAlertas = dwTAlertas;
        this.dwTDefeitos = dwTDefeitos;
        this.dwTParadas = dwTParadas;
        this.dwTRefugos = dwTRefugos;
        this.idTppt = idTppt;
        this.omAlgocor = omAlgocor;
        this.omCfgsForIdTpptInsersora = omCfgsForIdTpptInsersora;
        this.omCfgsForIdTpptPm = omCfgsForIdTpptPm;
        this.omCfgsForIdTpptPpass = omCfgsForIdTpptPpass;
        this.omCfgsForIdTpptPrepro = omCfgsForIdTpptPrepro;
        this.omCfgsForIdTpptPtf = omCfgsForIdTpptPtf;
        this.omCfgsForIdTpptPts = omCfgsForIdTpptPts;
        this.omCfgsForIdTpptPtscd = omCfgsForIdTpptPtscd;
        this.omIndtppts = omIndtppts;
        this.omPts = omPts;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdTppt value for this OmTppt.
     * 
     * @return cdTppt
     */
    public java.lang.String getCdTppt() {
        return cdTppt;
    }


    /**
     * Sets the cdTppt value for this OmTppt.
     * 
     * @param cdTppt
     */
    public void setCdTppt(java.lang.String cdTppt) {
        this.cdTppt = cdTppt;
    }


    /**
     * Gets the dsTppt value for this OmTppt.
     * 
     * @return dsTppt
     */
    public java.lang.String getDsTppt() {
        return dsTppt;
    }


    /**
     * Sets the dsTppt value for this OmTppt.
     * 
     * @param dsTppt
     */
    public void setDsTppt(java.lang.String dsTppt) {
        this.dsTppt = dsTppt;
    }


    /**
     * Gets the dtRevisao value for this OmTppt.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this OmTppt.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this OmTppt.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this OmTppt.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dwFolhas value for this OmTppt.
     * 
     * @return dwFolhas
     */
    public idw.idwws.DwFolha[] getDwFolhas() {
        return dwFolhas;
    }


    /**
     * Sets the dwFolhas value for this OmTppt.
     * 
     * @param dwFolhas
     */
    public void setDwFolhas(idw.idwws.DwFolha[] dwFolhas) {
        this.dwFolhas = dwFolhas;
    }

    public idw.idwws.DwFolha getDwFolhas(int i) {
        return this.dwFolhas[i];
    }

    public void setDwFolhas(int i, idw.idwws.DwFolha _value) {
        this.dwFolhas[i] = _value;
    }


    /**
     * Gets the dwTAcaos value for this OmTppt.
     * 
     * @return dwTAcaos
     */
    public idw.idwws.DwTAcao[] getDwTAcaos() {
        return dwTAcaos;
    }


    /**
     * Sets the dwTAcaos value for this OmTppt.
     * 
     * @param dwTAcaos
     */
    public void setDwTAcaos(idw.idwws.DwTAcao[] dwTAcaos) {
        this.dwTAcaos = dwTAcaos;
    }

    public idw.idwws.DwTAcao getDwTAcaos(int i) {
        return this.dwTAcaos[i];
    }

    public void setDwTAcaos(int i, idw.idwws.DwTAcao _value) {
        this.dwTAcaos[i] = _value;
    }


    /**
     * Gets the dwTAlertas value for this OmTppt.
     * 
     * @return dwTAlertas
     */
    public idw.idwws.DwTAlerta[] getDwTAlertas() {
        return dwTAlertas;
    }


    /**
     * Sets the dwTAlertas value for this OmTppt.
     * 
     * @param dwTAlertas
     */
    public void setDwTAlertas(idw.idwws.DwTAlerta[] dwTAlertas) {
        this.dwTAlertas = dwTAlertas;
    }

    public idw.idwws.DwTAlerta getDwTAlertas(int i) {
        return this.dwTAlertas[i];
    }

    public void setDwTAlertas(int i, idw.idwws.DwTAlerta _value) {
        this.dwTAlertas[i] = _value;
    }


    /**
     * Gets the dwTDefeitos value for this OmTppt.
     * 
     * @return dwTDefeitos
     */
    public idw.idwws.DwTDefeito[] getDwTDefeitos() {
        return dwTDefeitos;
    }


    /**
     * Sets the dwTDefeitos value for this OmTppt.
     * 
     * @param dwTDefeitos
     */
    public void setDwTDefeitos(idw.idwws.DwTDefeito[] dwTDefeitos) {
        this.dwTDefeitos = dwTDefeitos;
    }

    public idw.idwws.DwTDefeito getDwTDefeitos(int i) {
        return this.dwTDefeitos[i];
    }

    public void setDwTDefeitos(int i, idw.idwws.DwTDefeito _value) {
        this.dwTDefeitos[i] = _value;
    }


    /**
     * Gets the dwTParadas value for this OmTppt.
     * 
     * @return dwTParadas
     */
    public idw.idwws.DwTParada[] getDwTParadas() {
        return dwTParadas;
    }


    /**
     * Sets the dwTParadas value for this OmTppt.
     * 
     * @param dwTParadas
     */
    public void setDwTParadas(idw.idwws.DwTParada[] dwTParadas) {
        this.dwTParadas = dwTParadas;
    }

    public idw.idwws.DwTParada getDwTParadas(int i) {
        return this.dwTParadas[i];
    }

    public void setDwTParadas(int i, idw.idwws.DwTParada _value) {
        this.dwTParadas[i] = _value;
    }


    /**
     * Gets the dwTRefugos value for this OmTppt.
     * 
     * @return dwTRefugos
     */
    public idw.idwws.DwTRefugo[] getDwTRefugos() {
        return dwTRefugos;
    }


    /**
     * Sets the dwTRefugos value for this OmTppt.
     * 
     * @param dwTRefugos
     */
    public void setDwTRefugos(idw.idwws.DwTRefugo[] dwTRefugos) {
        this.dwTRefugos = dwTRefugos;
    }

    public idw.idwws.DwTRefugo getDwTRefugos(int i) {
        return this.dwTRefugos[i];
    }

    public void setDwTRefugos(int i, idw.idwws.DwTRefugo _value) {
        this.dwTRefugos[i] = _value;
    }


    /**
     * Gets the idTppt value for this OmTppt.
     * 
     * @return idTppt
     */
    public long getIdTppt() {
        return idTppt;
    }


    /**
     * Sets the idTppt value for this OmTppt.
     * 
     * @param idTppt
     */
    public void setIdTppt(long idTppt) {
        this.idTppt = idTppt;
    }


    /**
     * Gets the omAlgocor value for this OmTppt.
     * 
     * @return omAlgocor
     */
    public idw.idwws.OmAlgocor getOmAlgocor() {
        return omAlgocor;
    }


    /**
     * Sets the omAlgocor value for this OmTppt.
     * 
     * @param omAlgocor
     */
    public void setOmAlgocor(idw.idwws.OmAlgocor omAlgocor) {
        this.omAlgocor = omAlgocor;
    }


    /**
     * Gets the omCfgsForIdTpptInsersora value for this OmTppt.
     * 
     * @return omCfgsForIdTpptInsersora
     */
    public idw.idwws.OmCfg[] getOmCfgsForIdTpptInsersora() {
        return omCfgsForIdTpptInsersora;
    }


    /**
     * Sets the omCfgsForIdTpptInsersora value for this OmTppt.
     * 
     * @param omCfgsForIdTpptInsersora
     */
    public void setOmCfgsForIdTpptInsersora(idw.idwws.OmCfg[] omCfgsForIdTpptInsersora) {
        this.omCfgsForIdTpptInsersora = omCfgsForIdTpptInsersora;
    }

    public idw.idwws.OmCfg getOmCfgsForIdTpptInsersora(int i) {
        return this.omCfgsForIdTpptInsersora[i];
    }

    public void setOmCfgsForIdTpptInsersora(int i, idw.idwws.OmCfg _value) {
        this.omCfgsForIdTpptInsersora[i] = _value;
    }


    /**
     * Gets the omCfgsForIdTpptPm value for this OmTppt.
     * 
     * @return omCfgsForIdTpptPm
     */
    public idw.idwws.OmCfg[] getOmCfgsForIdTpptPm() {
        return omCfgsForIdTpptPm;
    }


    /**
     * Sets the omCfgsForIdTpptPm value for this OmTppt.
     * 
     * @param omCfgsForIdTpptPm
     */
    public void setOmCfgsForIdTpptPm(idw.idwws.OmCfg[] omCfgsForIdTpptPm) {
        this.omCfgsForIdTpptPm = omCfgsForIdTpptPm;
    }

    public idw.idwws.OmCfg getOmCfgsForIdTpptPm(int i) {
        return this.omCfgsForIdTpptPm[i];
    }

    public void setOmCfgsForIdTpptPm(int i, idw.idwws.OmCfg _value) {
        this.omCfgsForIdTpptPm[i] = _value;
    }


    /**
     * Gets the omCfgsForIdTpptPpass value for this OmTppt.
     * 
     * @return omCfgsForIdTpptPpass
     */
    public idw.idwws.OmCfg[] getOmCfgsForIdTpptPpass() {
        return omCfgsForIdTpptPpass;
    }


    /**
     * Sets the omCfgsForIdTpptPpass value for this OmTppt.
     * 
     * @param omCfgsForIdTpptPpass
     */
    public void setOmCfgsForIdTpptPpass(idw.idwws.OmCfg[] omCfgsForIdTpptPpass) {
        this.omCfgsForIdTpptPpass = omCfgsForIdTpptPpass;
    }

    public idw.idwws.OmCfg getOmCfgsForIdTpptPpass(int i) {
        return this.omCfgsForIdTpptPpass[i];
    }

    public void setOmCfgsForIdTpptPpass(int i, idw.idwws.OmCfg _value) {
        this.omCfgsForIdTpptPpass[i] = _value;
    }


    /**
     * Gets the omCfgsForIdTpptPrepro value for this OmTppt.
     * 
     * @return omCfgsForIdTpptPrepro
     */
    public idw.idwws.OmCfg[] getOmCfgsForIdTpptPrepro() {
        return omCfgsForIdTpptPrepro;
    }


    /**
     * Sets the omCfgsForIdTpptPrepro value for this OmTppt.
     * 
     * @param omCfgsForIdTpptPrepro
     */
    public void setOmCfgsForIdTpptPrepro(idw.idwws.OmCfg[] omCfgsForIdTpptPrepro) {
        this.omCfgsForIdTpptPrepro = omCfgsForIdTpptPrepro;
    }

    public idw.idwws.OmCfg getOmCfgsForIdTpptPrepro(int i) {
        return this.omCfgsForIdTpptPrepro[i];
    }

    public void setOmCfgsForIdTpptPrepro(int i, idw.idwws.OmCfg _value) {
        this.omCfgsForIdTpptPrepro[i] = _value;
    }


    /**
     * Gets the omCfgsForIdTpptPtf value for this OmTppt.
     * 
     * @return omCfgsForIdTpptPtf
     */
    public idw.idwws.OmCfg[] getOmCfgsForIdTpptPtf() {
        return omCfgsForIdTpptPtf;
    }


    /**
     * Sets the omCfgsForIdTpptPtf value for this OmTppt.
     * 
     * @param omCfgsForIdTpptPtf
     */
    public void setOmCfgsForIdTpptPtf(idw.idwws.OmCfg[] omCfgsForIdTpptPtf) {
        this.omCfgsForIdTpptPtf = omCfgsForIdTpptPtf;
    }

    public idw.idwws.OmCfg getOmCfgsForIdTpptPtf(int i) {
        return this.omCfgsForIdTpptPtf[i];
    }

    public void setOmCfgsForIdTpptPtf(int i, idw.idwws.OmCfg _value) {
        this.omCfgsForIdTpptPtf[i] = _value;
    }


    /**
     * Gets the omCfgsForIdTpptPts value for this OmTppt.
     * 
     * @return omCfgsForIdTpptPts
     */
    public idw.idwws.OmCfg[] getOmCfgsForIdTpptPts() {
        return omCfgsForIdTpptPts;
    }


    /**
     * Sets the omCfgsForIdTpptPts value for this OmTppt.
     * 
     * @param omCfgsForIdTpptPts
     */
    public void setOmCfgsForIdTpptPts(idw.idwws.OmCfg[] omCfgsForIdTpptPts) {
        this.omCfgsForIdTpptPts = omCfgsForIdTpptPts;
    }

    public idw.idwws.OmCfg getOmCfgsForIdTpptPts(int i) {
        return this.omCfgsForIdTpptPts[i];
    }

    public void setOmCfgsForIdTpptPts(int i, idw.idwws.OmCfg _value) {
        this.omCfgsForIdTpptPts[i] = _value;
    }


    /**
     * Gets the omCfgsForIdTpptPtscd value for this OmTppt.
     * 
     * @return omCfgsForIdTpptPtscd
     */
    public idw.idwws.OmCfg[] getOmCfgsForIdTpptPtscd() {
        return omCfgsForIdTpptPtscd;
    }


    /**
     * Sets the omCfgsForIdTpptPtscd value for this OmTppt.
     * 
     * @param omCfgsForIdTpptPtscd
     */
    public void setOmCfgsForIdTpptPtscd(idw.idwws.OmCfg[] omCfgsForIdTpptPtscd) {
        this.omCfgsForIdTpptPtscd = omCfgsForIdTpptPtscd;
    }

    public idw.idwws.OmCfg getOmCfgsForIdTpptPtscd(int i) {
        return this.omCfgsForIdTpptPtscd[i];
    }

    public void setOmCfgsForIdTpptPtscd(int i, idw.idwws.OmCfg _value) {
        this.omCfgsForIdTpptPtscd[i] = _value;
    }


    /**
     * Gets the omIndtppts value for this OmTppt.
     * 
     * @return omIndtppts
     */
    public idw.idwws.OmIndtppt[] getOmIndtppts() {
        return omIndtppts;
    }


    /**
     * Sets the omIndtppts value for this OmTppt.
     * 
     * @param omIndtppts
     */
    public void setOmIndtppts(idw.idwws.OmIndtppt[] omIndtppts) {
        this.omIndtppts = omIndtppts;
    }

    public idw.idwws.OmIndtppt getOmIndtppts(int i) {
        return this.omIndtppts[i];
    }

    public void setOmIndtppts(int i, idw.idwws.OmIndtppt _value) {
        this.omIndtppts[i] = _value;
    }


    /**
     * Gets the omPts value for this OmTppt.
     * 
     * @return omPts
     */
    public idw.idwws.OmPt[] getOmPts() {
        return omPts;
    }


    /**
     * Sets the omPts value for this OmTppt.
     * 
     * @param omPts
     */
    public void setOmPts(idw.idwws.OmPt[] omPts) {
        this.omPts = omPts;
    }

    public idw.idwws.OmPt getOmPts(int i) {
        return this.omPts[i];
    }

    public void setOmPts(int i, idw.idwws.OmPt _value) {
        this.omPts[i] = _value;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this OmTppt.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this OmTppt.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this OmTppt.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this OmTppt.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the revisao value for this OmTppt.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this OmTppt.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this OmTppt.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this OmTppt.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmTppt)) return false;
        OmTppt other = (OmTppt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdTppt==null && other.getCdTppt()==null) || 
             (this.cdTppt!=null &&
              this.cdTppt.equals(other.getCdTppt()))) &&
            ((this.dsTppt==null && other.getDsTppt()==null) || 
             (this.dsTppt!=null &&
              this.dsTppt.equals(other.getDsTppt()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dwFolhas==null && other.getDwFolhas()==null) || 
             (this.dwFolhas!=null &&
              java.util.Arrays.equals(this.dwFolhas, other.getDwFolhas()))) &&
            ((this.dwTAcaos==null && other.getDwTAcaos()==null) || 
             (this.dwTAcaos!=null &&
              java.util.Arrays.equals(this.dwTAcaos, other.getDwTAcaos()))) &&
            ((this.dwTAlertas==null && other.getDwTAlertas()==null) || 
             (this.dwTAlertas!=null &&
              java.util.Arrays.equals(this.dwTAlertas, other.getDwTAlertas()))) &&
            ((this.dwTDefeitos==null && other.getDwTDefeitos()==null) || 
             (this.dwTDefeitos!=null &&
              java.util.Arrays.equals(this.dwTDefeitos, other.getDwTDefeitos()))) &&
            ((this.dwTParadas==null && other.getDwTParadas()==null) || 
             (this.dwTParadas!=null &&
              java.util.Arrays.equals(this.dwTParadas, other.getDwTParadas()))) &&
            ((this.dwTRefugos==null && other.getDwTRefugos()==null) || 
             (this.dwTRefugos!=null &&
              java.util.Arrays.equals(this.dwTRefugos, other.getDwTRefugos()))) &&
            this.idTppt == other.getIdTppt() &&
            ((this.omAlgocor==null && other.getOmAlgocor()==null) || 
             (this.omAlgocor!=null &&
              this.omAlgocor.equals(other.getOmAlgocor()))) &&
            ((this.omCfgsForIdTpptInsersora==null && other.getOmCfgsForIdTpptInsersora()==null) || 
             (this.omCfgsForIdTpptInsersora!=null &&
              java.util.Arrays.equals(this.omCfgsForIdTpptInsersora, other.getOmCfgsForIdTpptInsersora()))) &&
            ((this.omCfgsForIdTpptPm==null && other.getOmCfgsForIdTpptPm()==null) || 
             (this.omCfgsForIdTpptPm!=null &&
              java.util.Arrays.equals(this.omCfgsForIdTpptPm, other.getOmCfgsForIdTpptPm()))) &&
            ((this.omCfgsForIdTpptPpass==null && other.getOmCfgsForIdTpptPpass()==null) || 
             (this.omCfgsForIdTpptPpass!=null &&
              java.util.Arrays.equals(this.omCfgsForIdTpptPpass, other.getOmCfgsForIdTpptPpass()))) &&
            ((this.omCfgsForIdTpptPrepro==null && other.getOmCfgsForIdTpptPrepro()==null) || 
             (this.omCfgsForIdTpptPrepro!=null &&
              java.util.Arrays.equals(this.omCfgsForIdTpptPrepro, other.getOmCfgsForIdTpptPrepro()))) &&
            ((this.omCfgsForIdTpptPtf==null && other.getOmCfgsForIdTpptPtf()==null) || 
             (this.omCfgsForIdTpptPtf!=null &&
              java.util.Arrays.equals(this.omCfgsForIdTpptPtf, other.getOmCfgsForIdTpptPtf()))) &&
            ((this.omCfgsForIdTpptPts==null && other.getOmCfgsForIdTpptPts()==null) || 
             (this.omCfgsForIdTpptPts!=null &&
              java.util.Arrays.equals(this.omCfgsForIdTpptPts, other.getOmCfgsForIdTpptPts()))) &&
            ((this.omCfgsForIdTpptPtscd==null && other.getOmCfgsForIdTpptPtscd()==null) || 
             (this.omCfgsForIdTpptPtscd!=null &&
              java.util.Arrays.equals(this.omCfgsForIdTpptPtscd, other.getOmCfgsForIdTpptPtscd()))) &&
            ((this.omIndtppts==null && other.getOmIndtppts()==null) || 
             (this.omIndtppts!=null &&
              java.util.Arrays.equals(this.omIndtppts, other.getOmIndtppts()))) &&
            ((this.omPts==null && other.getOmPts()==null) || 
             (this.omPts!=null &&
              java.util.Arrays.equals(this.omPts, other.getOmPts()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getCdTppt() != null) {
            _hashCode += getCdTppt().hashCode();
        }
        if (getDsTppt() != null) {
            _hashCode += getDsTppt().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDwFolhas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolhas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolhas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTAcaos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTAcaos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTAcaos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTAlertas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTAlertas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTAlertas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTDefeitos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTDefeitos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTDefeitos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTParadas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTParadas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTParadas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTRefugos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTRefugos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTRefugos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdTppt()).hashCode();
        if (getOmAlgocor() != null) {
            _hashCode += getOmAlgocor().hashCode();
        }
        if (getOmCfgsForIdTpptInsersora() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgsForIdTpptInsersora());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgsForIdTpptInsersora(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmCfgsForIdTpptPm() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgsForIdTpptPm());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgsForIdTpptPm(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmCfgsForIdTpptPpass() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgsForIdTpptPpass());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgsForIdTpptPpass(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmCfgsForIdTpptPrepro() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgsForIdTpptPrepro());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgsForIdTpptPrepro(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmCfgsForIdTpptPtf() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgsForIdTpptPtf());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgsForIdTpptPtf(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmCfgsForIdTpptPts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgsForIdTpptPts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgsForIdTpptPts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmCfgsForIdTpptPtscd() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgsForIdTpptPtscd());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgsForIdTpptPtscd(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmIndtppts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmIndtppts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmIndtppts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmPts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmPts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmPts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmUsrByIdUsrrevisao() != null) {
            _hashCode += getOmUsrByIdUsrrevisao().hashCode();
        }
        if (getOmUsrByIdUsrstativo() != null) {
            _hashCode += getOmUsrByIdUsrstativo().hashCode();
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmTppt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTppt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdTppt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdTppt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsTppt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsTppt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtRevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtRevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtStativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtStativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTAcaos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTAcaos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTAcao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTAlertas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTAlertas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTAlerta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTDefeitos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTDefeitos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTDefeito"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTParadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTParadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTParada"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTRefugos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTRefugos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTRefugo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTppt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTppt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omAlgocor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omAlgocor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omAlgocor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgsForIdTpptInsersora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgsForIdTpptInsersora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgsForIdTpptPm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgsForIdTpptPm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgsForIdTpptPpass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgsForIdTpptPpass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgsForIdTpptPrepro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgsForIdTpptPrepro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgsForIdTpptPtf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgsForIdTpptPtf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgsForIdTpptPts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgsForIdTpptPts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgsForIdTpptPtscd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgsForIdTpptPtscd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omIndtppts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omIndtppts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omIndtppt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrByIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrByIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "revisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stAtivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stAtivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
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
