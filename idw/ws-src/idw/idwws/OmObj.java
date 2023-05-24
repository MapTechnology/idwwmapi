/**
 * OmObj.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmObj  extends idw.idwws.OmObjTemplate  implements java.io.Serializable {
    private java.lang.String corFrente;

    private java.lang.String corFundo;

    private idw.idwws.DwEst dwEstByIdEst;

    private idw.idwws.DwFolha dwFolhaByIdFolha;

    private idw.idwws.DwRota dwRotaByIdRota;

    private idw.idwws.DwRotapasso dwRotapasso;

    private java.lang.Long idObj;

    private java.lang.Byte monitoracao;

    private idw.idwws.OmGt omGtByIdGt;

    private idw.idwws.OmGt omGtByIdGtfilho;

    private idw.idwws.OmImg omImg;

    private idw.idwws.OmObj omObjByIdObjdestino;

    private idw.idwws.OmObj omObjByIdObjorigem;

    private idw.idwws.OmPt omPt;

    private idw.idwws.OmTexto omTexto;

    private idw.idwws.OmWebcam omWebcam;

    private java.lang.Byte tpObj;

    private java.math.BigDecimal x;

    private java.math.BigDecimal x2;

    private java.math.BigDecimal y;

    private java.math.BigDecimal y2;

    public OmObj() {
    }

    public OmObj(
           byte TIPO_OBJ_CIRCULO,
           byte TIPO_OBJ_ESTOQUE,
           byte TIPO_OBJ_FOLHA,
           byte TIPO_OBJ_GT,
           byte TIPO_OBJ_IMAGEM,
           byte TIPO_OBJ_PT,
           byte TIPO_OBJ_RETANGULO,
           byte TIPO_OBJ_RETA_SETA_1,
           byte TIPO_OBJ_RETA_SETA_1_2,
           byte TIPO_OBJ_RETA_SETA_2,
           byte TIPO_OBJ_TEXTO,
           java.lang.String corFrente,
           java.lang.String corFundo,
           idw.idwws.DwEst dwEstByIdEst,
           idw.idwws.DwFolha dwFolhaByIdFolha,
           idw.idwws.DwRota dwRotaByIdRota,
           idw.idwws.DwRotapasso dwRotapasso,
           java.lang.Long idObj,
           java.lang.Byte monitoracao,
           idw.idwws.OmGt omGtByIdGt,
           idw.idwws.OmGt omGtByIdGtfilho,
           idw.idwws.OmImg omImg,
           idw.idwws.OmObj omObjByIdObjdestino,
           idw.idwws.OmObj omObjByIdObjorigem,
           idw.idwws.OmPt omPt,
           idw.idwws.OmTexto omTexto,
           idw.idwws.OmWebcam omWebcam,
           java.lang.Byte tpObj,
           java.math.BigDecimal x,
           java.math.BigDecimal x2,
           java.math.BigDecimal y,
           java.math.BigDecimal y2) {
        super(
            TIPO_OBJ_CIRCULO,
            TIPO_OBJ_ESTOQUE,
            TIPO_OBJ_FOLHA,
            TIPO_OBJ_GT,
            TIPO_OBJ_IMAGEM,
            TIPO_OBJ_PT,
            TIPO_OBJ_RETANGULO,
            TIPO_OBJ_RETA_SETA_1,
            TIPO_OBJ_RETA_SETA_1_2,
            TIPO_OBJ_RETA_SETA_2,
            TIPO_OBJ_TEXTO);
        this.corFrente = corFrente;
        this.corFundo = corFundo;
        this.dwEstByIdEst = dwEstByIdEst;
        this.dwFolhaByIdFolha = dwFolhaByIdFolha;
        this.dwRotaByIdRota = dwRotaByIdRota;
        this.dwRotapasso = dwRotapasso;
        this.idObj = idObj;
        this.monitoracao = monitoracao;
        this.omGtByIdGt = omGtByIdGt;
        this.omGtByIdGtfilho = omGtByIdGtfilho;
        this.omImg = omImg;
        this.omObjByIdObjdestino = omObjByIdObjdestino;
        this.omObjByIdObjorigem = omObjByIdObjorigem;
        this.omPt = omPt;
        this.omTexto = omTexto;
        this.omWebcam = omWebcam;
        this.tpObj = tpObj;
        this.x = x;
        this.x2 = x2;
        this.y = y;
        this.y2 = y2;
    }


    /**
     * Gets the corFrente value for this OmObj.
     * 
     * @return corFrente
     */
    public java.lang.String getCorFrente() {
        return corFrente;
    }


    /**
     * Sets the corFrente value for this OmObj.
     * 
     * @param corFrente
     */
    public void setCorFrente(java.lang.String corFrente) {
        this.corFrente = corFrente;
    }


    /**
     * Gets the corFundo value for this OmObj.
     * 
     * @return corFundo
     */
    public java.lang.String getCorFundo() {
        return corFundo;
    }


    /**
     * Sets the corFundo value for this OmObj.
     * 
     * @param corFundo
     */
    public void setCorFundo(java.lang.String corFundo) {
        this.corFundo = corFundo;
    }


    /**
     * Gets the dwEstByIdEst value for this OmObj.
     * 
     * @return dwEstByIdEst
     */
    public idw.idwws.DwEst getDwEstByIdEst() {
        return dwEstByIdEst;
    }


    /**
     * Sets the dwEstByIdEst value for this OmObj.
     * 
     * @param dwEstByIdEst
     */
    public void setDwEstByIdEst(idw.idwws.DwEst dwEstByIdEst) {
        this.dwEstByIdEst = dwEstByIdEst;
    }


    /**
     * Gets the dwFolhaByIdFolha value for this OmObj.
     * 
     * @return dwFolhaByIdFolha
     */
    public idw.idwws.DwFolha getDwFolhaByIdFolha() {
        return dwFolhaByIdFolha;
    }


    /**
     * Sets the dwFolhaByIdFolha value for this OmObj.
     * 
     * @param dwFolhaByIdFolha
     */
    public void setDwFolhaByIdFolha(idw.idwws.DwFolha dwFolhaByIdFolha) {
        this.dwFolhaByIdFolha = dwFolhaByIdFolha;
    }


    /**
     * Gets the dwRotaByIdRota value for this OmObj.
     * 
     * @return dwRotaByIdRota
     */
    public idw.idwws.DwRota getDwRotaByIdRota() {
        return dwRotaByIdRota;
    }


    /**
     * Sets the dwRotaByIdRota value for this OmObj.
     * 
     * @param dwRotaByIdRota
     */
    public void setDwRotaByIdRota(idw.idwws.DwRota dwRotaByIdRota) {
        this.dwRotaByIdRota = dwRotaByIdRota;
    }


    /**
     * Gets the dwRotapasso value for this OmObj.
     * 
     * @return dwRotapasso
     */
    public idw.idwws.DwRotapasso getDwRotapasso() {
        return dwRotapasso;
    }


    /**
     * Sets the dwRotapasso value for this OmObj.
     * 
     * @param dwRotapasso
     */
    public void setDwRotapasso(idw.idwws.DwRotapasso dwRotapasso) {
        this.dwRotapasso = dwRotapasso;
    }


    /**
     * Gets the idObj value for this OmObj.
     * 
     * @return idObj
     */
    public java.lang.Long getIdObj() {
        return idObj;
    }


    /**
     * Sets the idObj value for this OmObj.
     * 
     * @param idObj
     */
    public void setIdObj(java.lang.Long idObj) {
        this.idObj = idObj;
    }


    /**
     * Gets the monitoracao value for this OmObj.
     * 
     * @return monitoracao
     */
    public java.lang.Byte getMonitoracao() {
        return monitoracao;
    }


    /**
     * Sets the monitoracao value for this OmObj.
     * 
     * @param monitoracao
     */
    public void setMonitoracao(java.lang.Byte monitoracao) {
        this.monitoracao = monitoracao;
    }


    /**
     * Gets the omGtByIdGt value for this OmObj.
     * 
     * @return omGtByIdGt
     */
    public idw.idwws.OmGt getOmGtByIdGt() {
        return omGtByIdGt;
    }


    /**
     * Sets the omGtByIdGt value for this OmObj.
     * 
     * @param omGtByIdGt
     */
    public void setOmGtByIdGt(idw.idwws.OmGt omGtByIdGt) {
        this.omGtByIdGt = omGtByIdGt;
    }


    /**
     * Gets the omGtByIdGtfilho value for this OmObj.
     * 
     * @return omGtByIdGtfilho
     */
    public idw.idwws.OmGt getOmGtByIdGtfilho() {
        return omGtByIdGtfilho;
    }


    /**
     * Sets the omGtByIdGtfilho value for this OmObj.
     * 
     * @param omGtByIdGtfilho
     */
    public void setOmGtByIdGtfilho(idw.idwws.OmGt omGtByIdGtfilho) {
        this.omGtByIdGtfilho = omGtByIdGtfilho;
    }


    /**
     * Gets the omImg value for this OmObj.
     * 
     * @return omImg
     */
    public idw.idwws.OmImg getOmImg() {
        return omImg;
    }


    /**
     * Sets the omImg value for this OmObj.
     * 
     * @param omImg
     */
    public void setOmImg(idw.idwws.OmImg omImg) {
        this.omImg = omImg;
    }


    /**
     * Gets the omObjByIdObjdestino value for this OmObj.
     * 
     * @return omObjByIdObjdestino
     */
    public idw.idwws.OmObj getOmObjByIdObjdestino() {
        return omObjByIdObjdestino;
    }


    /**
     * Sets the omObjByIdObjdestino value for this OmObj.
     * 
     * @param omObjByIdObjdestino
     */
    public void setOmObjByIdObjdestino(idw.idwws.OmObj omObjByIdObjdestino) {
        this.omObjByIdObjdestino = omObjByIdObjdestino;
    }


    /**
     * Gets the omObjByIdObjorigem value for this OmObj.
     * 
     * @return omObjByIdObjorigem
     */
    public idw.idwws.OmObj getOmObjByIdObjorigem() {
        return omObjByIdObjorigem;
    }


    /**
     * Sets the omObjByIdObjorigem value for this OmObj.
     * 
     * @param omObjByIdObjorigem
     */
    public void setOmObjByIdObjorigem(idw.idwws.OmObj omObjByIdObjorigem) {
        this.omObjByIdObjorigem = omObjByIdObjorigem;
    }


    /**
     * Gets the omPt value for this OmObj.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this OmObj.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the omTexto value for this OmObj.
     * 
     * @return omTexto
     */
    public idw.idwws.OmTexto getOmTexto() {
        return omTexto;
    }


    /**
     * Sets the omTexto value for this OmObj.
     * 
     * @param omTexto
     */
    public void setOmTexto(idw.idwws.OmTexto omTexto) {
        this.omTexto = omTexto;
    }


    /**
     * Gets the omWebcam value for this OmObj.
     * 
     * @return omWebcam
     */
    public idw.idwws.OmWebcam getOmWebcam() {
        return omWebcam;
    }


    /**
     * Sets the omWebcam value for this OmObj.
     * 
     * @param omWebcam
     */
    public void setOmWebcam(idw.idwws.OmWebcam omWebcam) {
        this.omWebcam = omWebcam;
    }


    /**
     * Gets the tpObj value for this OmObj.
     * 
     * @return tpObj
     */
    public java.lang.Byte getTpObj() {
        return tpObj;
    }


    /**
     * Sets the tpObj value for this OmObj.
     * 
     * @param tpObj
     */
    public void setTpObj(java.lang.Byte tpObj) {
        this.tpObj = tpObj;
    }


    /**
     * Gets the x value for this OmObj.
     * 
     * @return x
     */
    public java.math.BigDecimal getX() {
        return x;
    }


    /**
     * Sets the x value for this OmObj.
     * 
     * @param x
     */
    public void setX(java.math.BigDecimal x) {
        this.x = x;
    }


    /**
     * Gets the x2 value for this OmObj.
     * 
     * @return x2
     */
    public java.math.BigDecimal getX2() {
        return x2;
    }


    /**
     * Sets the x2 value for this OmObj.
     * 
     * @param x2
     */
    public void setX2(java.math.BigDecimal x2) {
        this.x2 = x2;
    }


    /**
     * Gets the y value for this OmObj.
     * 
     * @return y
     */
    public java.math.BigDecimal getY() {
        return y;
    }


    /**
     * Sets the y value for this OmObj.
     * 
     * @param y
     */
    public void setY(java.math.BigDecimal y) {
        this.y = y;
    }


    /**
     * Gets the y2 value for this OmObj.
     * 
     * @return y2
     */
    public java.math.BigDecimal getY2() {
        return y2;
    }


    /**
     * Sets the y2 value for this OmObj.
     * 
     * @param y2
     */
    public void setY2(java.math.BigDecimal y2) {
        this.y2 = y2;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmObj)) return false;
        OmObj other = (OmObj) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.corFrente==null && other.getCorFrente()==null) || 
             (this.corFrente!=null &&
              this.corFrente.equals(other.getCorFrente()))) &&
            ((this.corFundo==null && other.getCorFundo()==null) || 
             (this.corFundo!=null &&
              this.corFundo.equals(other.getCorFundo()))) &&
            ((this.dwEstByIdEst==null && other.getDwEstByIdEst()==null) || 
             (this.dwEstByIdEst!=null &&
              this.dwEstByIdEst.equals(other.getDwEstByIdEst()))) &&
            ((this.dwFolhaByIdFolha==null && other.getDwFolhaByIdFolha()==null) || 
             (this.dwFolhaByIdFolha!=null &&
              this.dwFolhaByIdFolha.equals(other.getDwFolhaByIdFolha()))) &&
            ((this.dwRotaByIdRota==null && other.getDwRotaByIdRota()==null) || 
             (this.dwRotaByIdRota!=null &&
              this.dwRotaByIdRota.equals(other.getDwRotaByIdRota()))) &&
            ((this.dwRotapasso==null && other.getDwRotapasso()==null) || 
             (this.dwRotapasso!=null &&
              this.dwRotapasso.equals(other.getDwRotapasso()))) &&
            ((this.idObj==null && other.getIdObj()==null) || 
             (this.idObj!=null &&
              this.idObj.equals(other.getIdObj()))) &&
            ((this.monitoracao==null && other.getMonitoracao()==null) || 
             (this.monitoracao!=null &&
              this.monitoracao.equals(other.getMonitoracao()))) &&
            ((this.omGtByIdGt==null && other.getOmGtByIdGt()==null) || 
             (this.omGtByIdGt!=null &&
              this.omGtByIdGt.equals(other.getOmGtByIdGt()))) &&
            ((this.omGtByIdGtfilho==null && other.getOmGtByIdGtfilho()==null) || 
             (this.omGtByIdGtfilho!=null &&
              this.omGtByIdGtfilho.equals(other.getOmGtByIdGtfilho()))) &&
            ((this.omImg==null && other.getOmImg()==null) || 
             (this.omImg!=null &&
              this.omImg.equals(other.getOmImg()))) &&
            ((this.omObjByIdObjdestino==null && other.getOmObjByIdObjdestino()==null) || 
             (this.omObjByIdObjdestino!=null &&
              this.omObjByIdObjdestino.equals(other.getOmObjByIdObjdestino()))) &&
            ((this.omObjByIdObjorigem==null && other.getOmObjByIdObjorigem()==null) || 
             (this.omObjByIdObjorigem!=null &&
              this.omObjByIdObjorigem.equals(other.getOmObjByIdObjorigem()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.omTexto==null && other.getOmTexto()==null) || 
             (this.omTexto!=null &&
              this.omTexto.equals(other.getOmTexto()))) &&
            ((this.omWebcam==null && other.getOmWebcam()==null) || 
             (this.omWebcam!=null &&
              this.omWebcam.equals(other.getOmWebcam()))) &&
            ((this.tpObj==null && other.getTpObj()==null) || 
             (this.tpObj!=null &&
              this.tpObj.equals(other.getTpObj()))) &&
            ((this.x==null && other.getX()==null) || 
             (this.x!=null &&
              this.x.equals(other.getX()))) &&
            ((this.x2==null && other.getX2()==null) || 
             (this.x2!=null &&
              this.x2.equals(other.getX2()))) &&
            ((this.y==null && other.getY()==null) || 
             (this.y!=null &&
              this.y.equals(other.getY()))) &&
            ((this.y2==null && other.getY2()==null) || 
             (this.y2!=null &&
              this.y2.equals(other.getY2())));
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
        if (getCorFrente() != null) {
            _hashCode += getCorFrente().hashCode();
        }
        if (getCorFundo() != null) {
            _hashCode += getCorFundo().hashCode();
        }
        if (getDwEstByIdEst() != null) {
            _hashCode += getDwEstByIdEst().hashCode();
        }
        if (getDwFolhaByIdFolha() != null) {
            _hashCode += getDwFolhaByIdFolha().hashCode();
        }
        if (getDwRotaByIdRota() != null) {
            _hashCode += getDwRotaByIdRota().hashCode();
        }
        if (getDwRotapasso() != null) {
            _hashCode += getDwRotapasso().hashCode();
        }
        if (getIdObj() != null) {
            _hashCode += getIdObj().hashCode();
        }
        if (getMonitoracao() != null) {
            _hashCode += getMonitoracao().hashCode();
        }
        if (getOmGtByIdGt() != null) {
            _hashCode += getOmGtByIdGt().hashCode();
        }
        if (getOmGtByIdGtfilho() != null) {
            _hashCode += getOmGtByIdGtfilho().hashCode();
        }
        if (getOmImg() != null) {
            _hashCode += getOmImg().hashCode();
        }
        if (getOmObjByIdObjdestino() != null) {
            _hashCode += getOmObjByIdObjdestino().hashCode();
        }
        if (getOmObjByIdObjorigem() != null) {
            _hashCode += getOmObjByIdObjorigem().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getOmTexto() != null) {
            _hashCode += getOmTexto().hashCode();
        }
        if (getOmWebcam() != null) {
            _hashCode += getOmWebcam().hashCode();
        }
        if (getTpObj() != null) {
            _hashCode += getTpObj().hashCode();
        }
        if (getX() != null) {
            _hashCode += getX().hashCode();
        }
        if (getX2() != null) {
            _hashCode += getX2().hashCode();
        }
        if (getY() != null) {
            _hashCode += getY().hashCode();
        }
        if (getY2() != null) {
            _hashCode += getY2().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmObj.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omObj"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corFrente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corFrente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corFundo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corFundo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstByIdEst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstByIdEst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhaByIdFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhaByIdFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRotaByIdRota");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRotaByIdRota"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRota"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRotapasso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRotapasso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRotapasso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idObj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idObj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monitoracao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "monitoracao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGtByIdGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGtByIdGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGtByIdGtfilho");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGtByIdGtfilho"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omImg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omImg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omImg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omObjByIdObjdestino");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omObjByIdObjdestino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omObj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omObjByIdObjorigem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omObjByIdObjorigem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omObj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTexto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTexto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTexto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omWebcam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omWebcam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omWebcam"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpObj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpObj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x");
        elemField.setXmlName(new javax.xml.namespace.QName("", "x"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "x2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("y");
        elemField.setXmlName(new javax.xml.namespace.QName("", "y"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("y2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "y2"));
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
