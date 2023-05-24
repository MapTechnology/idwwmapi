/**
 * PpPlano.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpPlano  extends idw.idwws.PpPlanoTemplate  implements java.io.Serializable {
    private java.lang.String cdPlano;

    private java.lang.String dsPlano;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private java.util.Calendar dthrPrevisaoinicio;

    private idw.idwws.DwCal dwCal;

    private java.lang.Long idPlano;

    private java.math.BigDecimal indOee;

    private java.lang.Boolean isConsiderarcal;

    private java.lang.Boolean isConsiderarcm;

    private java.lang.Boolean isConsiderarest;

    private java.lang.Boolean isConsiderarindisp;

    private java.lang.Boolean isConsiderarmo;

    private java.lang.Boolean isConsiderarmp;

    private java.lang.Boolean isConsideraroeefinalserie;

    private java.lang.Boolean isConsiderarprodutoturno;

    private java.lang.Boolean isConsiderarrap;

    private java.lang.Boolean isDeterminadocal;

    private java.lang.Boolean isModelo;

    private java.lang.Boolean isSimular;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private idw.idwws.PpCp[] ppCps;

    private idw.idwws.PpPlancol[] ppPlancols;

    private idw.idwws.PpPlaneccron[] ppPlaneccrons;

    private idw.idwws.PpPlanec[] ppPlanecs;

    private idw.idwws.PpPlanptgt[] ppPlanptgts;

    private idw.idwws.PpTpplano ppTpplano;

    private java.lang.Integer revisao;

    private java.lang.Integer stAtivo;

    private java.lang.Integer stPlano;

    public PpPlano() {
    }

    public PpPlano(
           java.lang.String cdPlano,
           java.lang.String dsPlano,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           java.util.Calendar dthrPrevisaoinicio,
           idw.idwws.DwCal dwCal,
           java.lang.Long idPlano,
           java.math.BigDecimal indOee,
           java.lang.Boolean isConsiderarcal,
           java.lang.Boolean isConsiderarcm,
           java.lang.Boolean isConsiderarest,
           java.lang.Boolean isConsiderarindisp,
           java.lang.Boolean isConsiderarmo,
           java.lang.Boolean isConsiderarmp,
           java.lang.Boolean isConsideraroeefinalserie,
           java.lang.Boolean isConsiderarprodutoturno,
           java.lang.Boolean isConsiderarrap,
           java.lang.Boolean isDeterminadocal,
           java.lang.Boolean isModelo,
           java.lang.Boolean isSimular,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           idw.idwws.PpCp[] ppCps,
           idw.idwws.PpPlancol[] ppPlancols,
           idw.idwws.PpPlaneccron[] ppPlaneccrons,
           idw.idwws.PpPlanec[] ppPlanecs,
           idw.idwws.PpPlanptgt[] ppPlanptgts,
           idw.idwws.PpTpplano ppTpplano,
           java.lang.Integer revisao,
           java.lang.Integer stAtivo,
           java.lang.Integer stPlano) {
        this.cdPlano = cdPlano;
        this.dsPlano = dsPlano;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dthrPrevisaoinicio = dthrPrevisaoinicio;
        this.dwCal = dwCal;
        this.idPlano = idPlano;
        this.indOee = indOee;
        this.isConsiderarcal = isConsiderarcal;
        this.isConsiderarcm = isConsiderarcm;
        this.isConsiderarest = isConsiderarest;
        this.isConsiderarindisp = isConsiderarindisp;
        this.isConsiderarmo = isConsiderarmo;
        this.isConsiderarmp = isConsiderarmp;
        this.isConsideraroeefinalserie = isConsideraroeefinalserie;
        this.isConsiderarprodutoturno = isConsiderarprodutoturno;
        this.isConsiderarrap = isConsiderarrap;
        this.isDeterminadocal = isDeterminadocal;
        this.isModelo = isModelo;
        this.isSimular = isSimular;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.ppCps = ppCps;
        this.ppPlancols = ppPlancols;
        this.ppPlaneccrons = ppPlaneccrons;
        this.ppPlanecs = ppPlanecs;
        this.ppPlanptgts = ppPlanptgts;
        this.ppTpplano = ppTpplano;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
        this.stPlano = stPlano;
    }


    /**
     * Gets the cdPlano value for this PpPlano.
     * 
     * @return cdPlano
     */
    public java.lang.String getCdPlano() {
        return cdPlano;
    }


    /**
     * Sets the cdPlano value for this PpPlano.
     * 
     * @param cdPlano
     */
    public void setCdPlano(java.lang.String cdPlano) {
        this.cdPlano = cdPlano;
    }


    /**
     * Gets the dsPlano value for this PpPlano.
     * 
     * @return dsPlano
     */
    public java.lang.String getDsPlano() {
        return dsPlano;
    }


    /**
     * Sets the dsPlano value for this PpPlano.
     * 
     * @param dsPlano
     */
    public void setDsPlano(java.lang.String dsPlano) {
        this.dsPlano = dsPlano;
    }


    /**
     * Gets the dtRevisao value for this PpPlano.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this PpPlano.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this PpPlano.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this PpPlano.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dthrPrevisaoinicio value for this PpPlano.
     * 
     * @return dthrPrevisaoinicio
     */
    public java.util.Calendar getDthrPrevisaoinicio() {
        return dthrPrevisaoinicio;
    }


    /**
     * Sets the dthrPrevisaoinicio value for this PpPlano.
     * 
     * @param dthrPrevisaoinicio
     */
    public void setDthrPrevisaoinicio(java.util.Calendar dthrPrevisaoinicio) {
        this.dthrPrevisaoinicio = dthrPrevisaoinicio;
    }


    /**
     * Gets the dwCal value for this PpPlano.
     * 
     * @return dwCal
     */
    public idw.idwws.DwCal getDwCal() {
        return dwCal;
    }


    /**
     * Sets the dwCal value for this PpPlano.
     * 
     * @param dwCal
     */
    public void setDwCal(idw.idwws.DwCal dwCal) {
        this.dwCal = dwCal;
    }


    /**
     * Gets the idPlano value for this PpPlano.
     * 
     * @return idPlano
     */
    public java.lang.Long getIdPlano() {
        return idPlano;
    }


    /**
     * Sets the idPlano value for this PpPlano.
     * 
     * @param idPlano
     */
    public void setIdPlano(java.lang.Long idPlano) {
        this.idPlano = idPlano;
    }


    /**
     * Gets the indOee value for this PpPlano.
     * 
     * @return indOee
     */
    public java.math.BigDecimal getIndOee() {
        return indOee;
    }


    /**
     * Sets the indOee value for this PpPlano.
     * 
     * @param indOee
     */
    public void setIndOee(java.math.BigDecimal indOee) {
        this.indOee = indOee;
    }


    /**
     * Gets the isConsiderarcal value for this PpPlano.
     * 
     * @return isConsiderarcal
     */
    public java.lang.Boolean getIsConsiderarcal() {
        return isConsiderarcal;
    }


    /**
     * Sets the isConsiderarcal value for this PpPlano.
     * 
     * @param isConsiderarcal
     */
    public void setIsConsiderarcal(java.lang.Boolean isConsiderarcal) {
        this.isConsiderarcal = isConsiderarcal;
    }


    /**
     * Gets the isConsiderarcm value for this PpPlano.
     * 
     * @return isConsiderarcm
     */
    public java.lang.Boolean getIsConsiderarcm() {
        return isConsiderarcm;
    }


    /**
     * Sets the isConsiderarcm value for this PpPlano.
     * 
     * @param isConsiderarcm
     */
    public void setIsConsiderarcm(java.lang.Boolean isConsiderarcm) {
        this.isConsiderarcm = isConsiderarcm;
    }


    /**
     * Gets the isConsiderarest value for this PpPlano.
     * 
     * @return isConsiderarest
     */
    public java.lang.Boolean getIsConsiderarest() {
        return isConsiderarest;
    }


    /**
     * Sets the isConsiderarest value for this PpPlano.
     * 
     * @param isConsiderarest
     */
    public void setIsConsiderarest(java.lang.Boolean isConsiderarest) {
        this.isConsiderarest = isConsiderarest;
    }


    /**
     * Gets the isConsiderarindisp value for this PpPlano.
     * 
     * @return isConsiderarindisp
     */
    public java.lang.Boolean getIsConsiderarindisp() {
        return isConsiderarindisp;
    }


    /**
     * Sets the isConsiderarindisp value for this PpPlano.
     * 
     * @param isConsiderarindisp
     */
    public void setIsConsiderarindisp(java.lang.Boolean isConsiderarindisp) {
        this.isConsiderarindisp = isConsiderarindisp;
    }


    /**
     * Gets the isConsiderarmo value for this PpPlano.
     * 
     * @return isConsiderarmo
     */
    public java.lang.Boolean getIsConsiderarmo() {
        return isConsiderarmo;
    }


    /**
     * Sets the isConsiderarmo value for this PpPlano.
     * 
     * @param isConsiderarmo
     */
    public void setIsConsiderarmo(java.lang.Boolean isConsiderarmo) {
        this.isConsiderarmo = isConsiderarmo;
    }


    /**
     * Gets the isConsiderarmp value for this PpPlano.
     * 
     * @return isConsiderarmp
     */
    public java.lang.Boolean getIsConsiderarmp() {
        return isConsiderarmp;
    }


    /**
     * Sets the isConsiderarmp value for this PpPlano.
     * 
     * @param isConsiderarmp
     */
    public void setIsConsiderarmp(java.lang.Boolean isConsiderarmp) {
        this.isConsiderarmp = isConsiderarmp;
    }


    /**
     * Gets the isConsideraroeefinalserie value for this PpPlano.
     * 
     * @return isConsideraroeefinalserie
     */
    public java.lang.Boolean getIsConsideraroeefinalserie() {
        return isConsideraroeefinalserie;
    }


    /**
     * Sets the isConsideraroeefinalserie value for this PpPlano.
     * 
     * @param isConsideraroeefinalserie
     */
    public void setIsConsideraroeefinalserie(java.lang.Boolean isConsideraroeefinalserie) {
        this.isConsideraroeefinalserie = isConsideraroeefinalserie;
    }


    /**
     * Gets the isConsiderarprodutoturno value for this PpPlano.
     * 
     * @return isConsiderarprodutoturno
     */
    public java.lang.Boolean getIsConsiderarprodutoturno() {
        return isConsiderarprodutoturno;
    }


    /**
     * Sets the isConsiderarprodutoturno value for this PpPlano.
     * 
     * @param isConsiderarprodutoturno
     */
    public void setIsConsiderarprodutoturno(java.lang.Boolean isConsiderarprodutoturno) {
        this.isConsiderarprodutoturno = isConsiderarprodutoturno;
    }


    /**
     * Gets the isConsiderarrap value for this PpPlano.
     * 
     * @return isConsiderarrap
     */
    public java.lang.Boolean getIsConsiderarrap() {
        return isConsiderarrap;
    }


    /**
     * Sets the isConsiderarrap value for this PpPlano.
     * 
     * @param isConsiderarrap
     */
    public void setIsConsiderarrap(java.lang.Boolean isConsiderarrap) {
        this.isConsiderarrap = isConsiderarrap;
    }


    /**
     * Gets the isDeterminadocal value for this PpPlano.
     * 
     * @return isDeterminadocal
     */
    public java.lang.Boolean getIsDeterminadocal() {
        return isDeterminadocal;
    }


    /**
     * Sets the isDeterminadocal value for this PpPlano.
     * 
     * @param isDeterminadocal
     */
    public void setIsDeterminadocal(java.lang.Boolean isDeterminadocal) {
        this.isDeterminadocal = isDeterminadocal;
    }


    /**
     * Gets the isModelo value for this PpPlano.
     * 
     * @return isModelo
     */
    public java.lang.Boolean getIsModelo() {
        return isModelo;
    }


    /**
     * Sets the isModelo value for this PpPlano.
     * 
     * @param isModelo
     */
    public void setIsModelo(java.lang.Boolean isModelo) {
        this.isModelo = isModelo;
    }


    /**
     * Gets the isSimular value for this PpPlano.
     * 
     * @return isSimular
     */
    public java.lang.Boolean getIsSimular() {
        return isSimular;
    }


    /**
     * Sets the isSimular value for this PpPlano.
     * 
     * @param isSimular
     */
    public void setIsSimular(java.lang.Boolean isSimular) {
        this.isSimular = isSimular;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this PpPlano.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this PpPlano.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this PpPlano.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this PpPlano.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the ppCps value for this PpPlano.
     * 
     * @return ppCps
     */
    public idw.idwws.PpCp[] getPpCps() {
        return ppCps;
    }


    /**
     * Sets the ppCps value for this PpPlano.
     * 
     * @param ppCps
     */
    public void setPpCps(idw.idwws.PpCp[] ppCps) {
        this.ppCps = ppCps;
    }

    public idw.idwws.PpCp getPpCps(int i) {
        return this.ppCps[i];
    }

    public void setPpCps(int i, idw.idwws.PpCp _value) {
        this.ppCps[i] = _value;
    }


    /**
     * Gets the ppPlancols value for this PpPlano.
     * 
     * @return ppPlancols
     */
    public idw.idwws.PpPlancol[] getPpPlancols() {
        return ppPlancols;
    }


    /**
     * Sets the ppPlancols value for this PpPlano.
     * 
     * @param ppPlancols
     */
    public void setPpPlancols(idw.idwws.PpPlancol[] ppPlancols) {
        this.ppPlancols = ppPlancols;
    }

    public idw.idwws.PpPlancol getPpPlancols(int i) {
        return this.ppPlancols[i];
    }

    public void setPpPlancols(int i, idw.idwws.PpPlancol _value) {
        this.ppPlancols[i] = _value;
    }


    /**
     * Gets the ppPlaneccrons value for this PpPlano.
     * 
     * @return ppPlaneccrons
     */
    public idw.idwws.PpPlaneccron[] getPpPlaneccrons() {
        return ppPlaneccrons;
    }


    /**
     * Sets the ppPlaneccrons value for this PpPlano.
     * 
     * @param ppPlaneccrons
     */
    public void setPpPlaneccrons(idw.idwws.PpPlaneccron[] ppPlaneccrons) {
        this.ppPlaneccrons = ppPlaneccrons;
    }

    public idw.idwws.PpPlaneccron getPpPlaneccrons(int i) {
        return this.ppPlaneccrons[i];
    }

    public void setPpPlaneccrons(int i, idw.idwws.PpPlaneccron _value) {
        this.ppPlaneccrons[i] = _value;
    }


    /**
     * Gets the ppPlanecs value for this PpPlano.
     * 
     * @return ppPlanecs
     */
    public idw.idwws.PpPlanec[] getPpPlanecs() {
        return ppPlanecs;
    }


    /**
     * Sets the ppPlanecs value for this PpPlano.
     * 
     * @param ppPlanecs
     */
    public void setPpPlanecs(idw.idwws.PpPlanec[] ppPlanecs) {
        this.ppPlanecs = ppPlanecs;
    }

    public idw.idwws.PpPlanec getPpPlanecs(int i) {
        return this.ppPlanecs[i];
    }

    public void setPpPlanecs(int i, idw.idwws.PpPlanec _value) {
        this.ppPlanecs[i] = _value;
    }


    /**
     * Gets the ppPlanptgts value for this PpPlano.
     * 
     * @return ppPlanptgts
     */
    public idw.idwws.PpPlanptgt[] getPpPlanptgts() {
        return ppPlanptgts;
    }


    /**
     * Sets the ppPlanptgts value for this PpPlano.
     * 
     * @param ppPlanptgts
     */
    public void setPpPlanptgts(idw.idwws.PpPlanptgt[] ppPlanptgts) {
        this.ppPlanptgts = ppPlanptgts;
    }

    public idw.idwws.PpPlanptgt getPpPlanptgts(int i) {
        return this.ppPlanptgts[i];
    }

    public void setPpPlanptgts(int i, idw.idwws.PpPlanptgt _value) {
        this.ppPlanptgts[i] = _value;
    }


    /**
     * Gets the ppTpplano value for this PpPlano.
     * 
     * @return ppTpplano
     */
    public idw.idwws.PpTpplano getPpTpplano() {
        return ppTpplano;
    }


    /**
     * Sets the ppTpplano value for this PpPlano.
     * 
     * @param ppTpplano
     */
    public void setPpTpplano(idw.idwws.PpTpplano ppTpplano) {
        this.ppTpplano = ppTpplano;
    }


    /**
     * Gets the revisao value for this PpPlano.
     * 
     * @return revisao
     */
    public java.lang.Integer getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this PpPlano.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Integer revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this PpPlano.
     * 
     * @return stAtivo
     */
    public java.lang.Integer getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this PpPlano.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Integer stAtivo) {
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the stPlano value for this PpPlano.
     * 
     * @return stPlano
     */
    public java.lang.Integer getStPlano() {
        return stPlano;
    }


    /**
     * Sets the stPlano value for this PpPlano.
     * 
     * @param stPlano
     */
    public void setStPlano(java.lang.Integer stPlano) {
        this.stPlano = stPlano;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpPlano)) return false;
        PpPlano other = (PpPlano) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdPlano==null && other.getCdPlano()==null) || 
             (this.cdPlano!=null &&
              this.cdPlano.equals(other.getCdPlano()))) &&
            ((this.dsPlano==null && other.getDsPlano()==null) || 
             (this.dsPlano!=null &&
              this.dsPlano.equals(other.getDsPlano()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dthrPrevisaoinicio==null && other.getDthrPrevisaoinicio()==null) || 
             (this.dthrPrevisaoinicio!=null &&
              this.dthrPrevisaoinicio.equals(other.getDthrPrevisaoinicio()))) &&
            ((this.dwCal==null && other.getDwCal()==null) || 
             (this.dwCal!=null &&
              this.dwCal.equals(other.getDwCal()))) &&
            ((this.idPlano==null && other.getIdPlano()==null) || 
             (this.idPlano!=null &&
              this.idPlano.equals(other.getIdPlano()))) &&
            ((this.indOee==null && other.getIndOee()==null) || 
             (this.indOee!=null &&
              this.indOee.equals(other.getIndOee()))) &&
            ((this.isConsiderarcal==null && other.getIsConsiderarcal()==null) || 
             (this.isConsiderarcal!=null &&
              this.isConsiderarcal.equals(other.getIsConsiderarcal()))) &&
            ((this.isConsiderarcm==null && other.getIsConsiderarcm()==null) || 
             (this.isConsiderarcm!=null &&
              this.isConsiderarcm.equals(other.getIsConsiderarcm()))) &&
            ((this.isConsiderarest==null && other.getIsConsiderarest()==null) || 
             (this.isConsiderarest!=null &&
              this.isConsiderarest.equals(other.getIsConsiderarest()))) &&
            ((this.isConsiderarindisp==null && other.getIsConsiderarindisp()==null) || 
             (this.isConsiderarindisp!=null &&
              this.isConsiderarindisp.equals(other.getIsConsiderarindisp()))) &&
            ((this.isConsiderarmo==null && other.getIsConsiderarmo()==null) || 
             (this.isConsiderarmo!=null &&
              this.isConsiderarmo.equals(other.getIsConsiderarmo()))) &&
            ((this.isConsiderarmp==null && other.getIsConsiderarmp()==null) || 
             (this.isConsiderarmp!=null &&
              this.isConsiderarmp.equals(other.getIsConsiderarmp()))) &&
            ((this.isConsideraroeefinalserie==null && other.getIsConsideraroeefinalserie()==null) || 
             (this.isConsideraroeefinalserie!=null &&
              this.isConsideraroeefinalserie.equals(other.getIsConsideraroeefinalserie()))) &&
            ((this.isConsiderarprodutoturno==null && other.getIsConsiderarprodutoturno()==null) || 
             (this.isConsiderarprodutoturno!=null &&
              this.isConsiderarprodutoturno.equals(other.getIsConsiderarprodutoturno()))) &&
            ((this.isConsiderarrap==null && other.getIsConsiderarrap()==null) || 
             (this.isConsiderarrap!=null &&
              this.isConsiderarrap.equals(other.getIsConsiderarrap()))) &&
            ((this.isDeterminadocal==null && other.getIsDeterminadocal()==null) || 
             (this.isDeterminadocal!=null &&
              this.isDeterminadocal.equals(other.getIsDeterminadocal()))) &&
            ((this.isModelo==null && other.getIsModelo()==null) || 
             (this.isModelo!=null &&
              this.isModelo.equals(other.getIsModelo()))) &&
            ((this.isSimular==null && other.getIsSimular()==null) || 
             (this.isSimular!=null &&
              this.isSimular.equals(other.getIsSimular()))) &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.ppCps==null && other.getPpCps()==null) || 
             (this.ppCps!=null &&
              java.util.Arrays.equals(this.ppCps, other.getPpCps()))) &&
            ((this.ppPlancols==null && other.getPpPlancols()==null) || 
             (this.ppPlancols!=null &&
              java.util.Arrays.equals(this.ppPlancols, other.getPpPlancols()))) &&
            ((this.ppPlaneccrons==null && other.getPpPlaneccrons()==null) || 
             (this.ppPlaneccrons!=null &&
              java.util.Arrays.equals(this.ppPlaneccrons, other.getPpPlaneccrons()))) &&
            ((this.ppPlanecs==null && other.getPpPlanecs()==null) || 
             (this.ppPlanecs!=null &&
              java.util.Arrays.equals(this.ppPlanecs, other.getPpPlanecs()))) &&
            ((this.ppPlanptgts==null && other.getPpPlanptgts()==null) || 
             (this.ppPlanptgts!=null &&
              java.util.Arrays.equals(this.ppPlanptgts, other.getPpPlanptgts()))) &&
            ((this.ppTpplano==null && other.getPpTpplano()==null) || 
             (this.ppTpplano!=null &&
              this.ppTpplano.equals(other.getPpTpplano()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo()))) &&
            ((this.stPlano==null && other.getStPlano()==null) || 
             (this.stPlano!=null &&
              this.stPlano.equals(other.getStPlano())));
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
        if (getCdPlano() != null) {
            _hashCode += getCdPlano().hashCode();
        }
        if (getDsPlano() != null) {
            _hashCode += getDsPlano().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDthrPrevisaoinicio() != null) {
            _hashCode += getDthrPrevisaoinicio().hashCode();
        }
        if (getDwCal() != null) {
            _hashCode += getDwCal().hashCode();
        }
        if (getIdPlano() != null) {
            _hashCode += getIdPlano().hashCode();
        }
        if (getIndOee() != null) {
            _hashCode += getIndOee().hashCode();
        }
        if (getIsConsiderarcal() != null) {
            _hashCode += getIsConsiderarcal().hashCode();
        }
        if (getIsConsiderarcm() != null) {
            _hashCode += getIsConsiderarcm().hashCode();
        }
        if (getIsConsiderarest() != null) {
            _hashCode += getIsConsiderarest().hashCode();
        }
        if (getIsConsiderarindisp() != null) {
            _hashCode += getIsConsiderarindisp().hashCode();
        }
        if (getIsConsiderarmo() != null) {
            _hashCode += getIsConsiderarmo().hashCode();
        }
        if (getIsConsiderarmp() != null) {
            _hashCode += getIsConsiderarmp().hashCode();
        }
        if (getIsConsideraroeefinalserie() != null) {
            _hashCode += getIsConsideraroeefinalserie().hashCode();
        }
        if (getIsConsiderarprodutoturno() != null) {
            _hashCode += getIsConsiderarprodutoturno().hashCode();
        }
        if (getIsConsiderarrap() != null) {
            _hashCode += getIsConsiderarrap().hashCode();
        }
        if (getIsDeterminadocal() != null) {
            _hashCode += getIsDeterminadocal().hashCode();
        }
        if (getIsModelo() != null) {
            _hashCode += getIsModelo().hashCode();
        }
        if (getIsSimular() != null) {
            _hashCode += getIsSimular().hashCode();
        }
        if (getOmUsrByIdUsrrevisao() != null) {
            _hashCode += getOmUsrByIdUsrrevisao().hashCode();
        }
        if (getOmUsrByIdUsrstativo() != null) {
            _hashCode += getOmUsrByIdUsrstativo().hashCode();
        }
        if (getPpCps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpCps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpCps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpPlancols() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpPlancols());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpPlancols(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpPlaneccrons() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpPlaneccrons());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpPlaneccrons(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpPlanecs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpPlanecs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpPlanecs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpPlanptgts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpPlanptgts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpPlanptgts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpTpplano() != null) {
            _hashCode += getPpTpplano().hashCode();
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        if (getStPlano() != null) {
            _hashCode += getStPlano().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpPlano.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppPlano"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdPlano");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdPlano"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsPlano");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsPlano"));
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
        elemField.setFieldName("dthrPrevisaoinicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrPrevisaoinicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwCal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwCal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPlano");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPlano"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indOee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indOee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isConsiderarcal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isConsiderarcal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isConsiderarcm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isConsiderarcm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isConsiderarest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isConsiderarest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isConsiderarindisp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isConsiderarindisp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isConsiderarmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isConsiderarmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isConsiderarmp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isConsiderarmp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isConsideraroeefinalserie");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isConsideraroeefinalserie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isConsiderarprodutoturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isConsiderarprodutoturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isConsiderarrap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isConsiderarrap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isDeterminadocal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isDeterminadocal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isModelo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isModelo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isSimular");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isSimular"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
        elemField.setFieldName("ppCps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppPlancols");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppPlancols"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppPlancol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppPlaneccrons");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppPlaneccrons"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppPlaneccron"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppPlanecs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppPlanecs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppPlanec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppPlanptgts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppPlanptgts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppPlanptgt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppTpplano");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppTpplano"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppTpplano"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "revisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stAtivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stAtivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stPlano");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stPlano"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
