/**
 * DwFtSub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwFtSub  extends idw.idwws.DwFtSubTemplate  implements java.io.Serializable {
    private java.lang.String dsSub;

    private idw.idwws.DwFtEtapa dwFtEtapa;

    private idw.idwws.DwFtParam dwFtParam;

    private idw.idwws.DwFtSubparam[] dwFtSubparams;

    private idw.idwws.DwTestesub[] dwTestesubs;

    private long idFtSub;

    private java.lang.Integer ms;

    private idw.idwws.OmProduto omProduto;

    private java.lang.Byte stFtParam;

    private java.lang.Byte tpFtParam;

    private java.lang.Byte tpFtSub;

    private java.lang.Byte tpStatus;

    private java.math.BigDecimal vlFtParam;

    private java.lang.Integer x41;

    private java.lang.Integer x42;

    private java.lang.Integer x45;

    private java.lang.Integer x46;

    private java.lang.Integer x47;

    private java.lang.Integer x48;

    private java.lang.Integer x49;

    private java.math.BigDecimal y81;

    private java.math.BigDecimal y82;

    private java.math.BigDecimal y83;

    private java.math.BigDecimal y84;

    public DwFtSub() {
    }

    public DwFtSub(
           java.lang.String dsSub,
           idw.idwws.DwFtEtapa dwFtEtapa,
           idw.idwws.DwFtParam dwFtParam,
           idw.idwws.DwFtSubparam[] dwFtSubparams,
           idw.idwws.DwTestesub[] dwTestesubs,
           long idFtSub,
           java.lang.Integer ms,
           idw.idwws.OmProduto omProduto,
           java.lang.Byte stFtParam,
           java.lang.Byte tpFtParam,
           java.lang.Byte tpFtSub,
           java.lang.Byte tpStatus,
           java.math.BigDecimal vlFtParam,
           java.lang.Integer x41,
           java.lang.Integer x42,
           java.lang.Integer x45,
           java.lang.Integer x46,
           java.lang.Integer x47,
           java.lang.Integer x48,
           java.lang.Integer x49,
           java.math.BigDecimal y81,
           java.math.BigDecimal y82,
           java.math.BigDecimal y83,
           java.math.BigDecimal y84) {
        this.dsSub = dsSub;
        this.dwFtEtapa = dwFtEtapa;
        this.dwFtParam = dwFtParam;
        this.dwFtSubparams = dwFtSubparams;
        this.dwTestesubs = dwTestesubs;
        this.idFtSub = idFtSub;
        this.ms = ms;
        this.omProduto = omProduto;
        this.stFtParam = stFtParam;
        this.tpFtParam = tpFtParam;
        this.tpFtSub = tpFtSub;
        this.tpStatus = tpStatus;
        this.vlFtParam = vlFtParam;
        this.x41 = x41;
        this.x42 = x42;
        this.x45 = x45;
        this.x46 = x46;
        this.x47 = x47;
        this.x48 = x48;
        this.x49 = x49;
        this.y81 = y81;
        this.y82 = y82;
        this.y83 = y83;
        this.y84 = y84;
    }


    /**
     * Gets the dsSub value for this DwFtSub.
     * 
     * @return dsSub
     */
    public java.lang.String getDsSub() {
        return dsSub;
    }


    /**
     * Sets the dsSub value for this DwFtSub.
     * 
     * @param dsSub
     */
    public void setDsSub(java.lang.String dsSub) {
        this.dsSub = dsSub;
    }


    /**
     * Gets the dwFtEtapa value for this DwFtSub.
     * 
     * @return dwFtEtapa
     */
    public idw.idwws.DwFtEtapa getDwFtEtapa() {
        return dwFtEtapa;
    }


    /**
     * Sets the dwFtEtapa value for this DwFtSub.
     * 
     * @param dwFtEtapa
     */
    public void setDwFtEtapa(idw.idwws.DwFtEtapa dwFtEtapa) {
        this.dwFtEtapa = dwFtEtapa;
    }


    /**
     * Gets the dwFtParam value for this DwFtSub.
     * 
     * @return dwFtParam
     */
    public idw.idwws.DwFtParam getDwFtParam() {
        return dwFtParam;
    }


    /**
     * Sets the dwFtParam value for this DwFtSub.
     * 
     * @param dwFtParam
     */
    public void setDwFtParam(idw.idwws.DwFtParam dwFtParam) {
        this.dwFtParam = dwFtParam;
    }


    /**
     * Gets the dwFtSubparams value for this DwFtSub.
     * 
     * @return dwFtSubparams
     */
    public idw.idwws.DwFtSubparam[] getDwFtSubparams() {
        return dwFtSubparams;
    }


    /**
     * Sets the dwFtSubparams value for this DwFtSub.
     * 
     * @param dwFtSubparams
     */
    public void setDwFtSubparams(idw.idwws.DwFtSubparam[] dwFtSubparams) {
        this.dwFtSubparams = dwFtSubparams;
    }

    public idw.idwws.DwFtSubparam getDwFtSubparams(int i) {
        return this.dwFtSubparams[i];
    }

    public void setDwFtSubparams(int i, idw.idwws.DwFtSubparam _value) {
        this.dwFtSubparams[i] = _value;
    }


    /**
     * Gets the dwTestesubs value for this DwFtSub.
     * 
     * @return dwTestesubs
     */
    public idw.idwws.DwTestesub[] getDwTestesubs() {
        return dwTestesubs;
    }


    /**
     * Sets the dwTestesubs value for this DwFtSub.
     * 
     * @param dwTestesubs
     */
    public void setDwTestesubs(idw.idwws.DwTestesub[] dwTestesubs) {
        this.dwTestesubs = dwTestesubs;
    }

    public idw.idwws.DwTestesub getDwTestesubs(int i) {
        return this.dwTestesubs[i];
    }

    public void setDwTestesubs(int i, idw.idwws.DwTestesub _value) {
        this.dwTestesubs[i] = _value;
    }


    /**
     * Gets the idFtSub value for this DwFtSub.
     * 
     * @return idFtSub
     */
    public long getIdFtSub() {
        return idFtSub;
    }


    /**
     * Sets the idFtSub value for this DwFtSub.
     * 
     * @param idFtSub
     */
    public void setIdFtSub(long idFtSub) {
        this.idFtSub = idFtSub;
    }


    /**
     * Gets the ms value for this DwFtSub.
     * 
     * @return ms
     */
    public java.lang.Integer getMs() {
        return ms;
    }


    /**
     * Sets the ms value for this DwFtSub.
     * 
     * @param ms
     */
    public void setMs(java.lang.Integer ms) {
        this.ms = ms;
    }


    /**
     * Gets the omProduto value for this DwFtSub.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this DwFtSub.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the stFtParam value for this DwFtSub.
     * 
     * @return stFtParam
     */
    public java.lang.Byte getStFtParam() {
        return stFtParam;
    }


    /**
     * Sets the stFtParam value for this DwFtSub.
     * 
     * @param stFtParam
     */
    public void setStFtParam(java.lang.Byte stFtParam) {
        this.stFtParam = stFtParam;
    }


    /**
     * Gets the tpFtParam value for this DwFtSub.
     * 
     * @return tpFtParam
     */
    public java.lang.Byte getTpFtParam() {
        return tpFtParam;
    }


    /**
     * Sets the tpFtParam value for this DwFtSub.
     * 
     * @param tpFtParam
     */
    public void setTpFtParam(java.lang.Byte tpFtParam) {
        this.tpFtParam = tpFtParam;
    }


    /**
     * Gets the tpFtSub value for this DwFtSub.
     * 
     * @return tpFtSub
     */
    public java.lang.Byte getTpFtSub() {
        return tpFtSub;
    }


    /**
     * Sets the tpFtSub value for this DwFtSub.
     * 
     * @param tpFtSub
     */
    public void setTpFtSub(java.lang.Byte tpFtSub) {
        this.tpFtSub = tpFtSub;
    }


    /**
     * Gets the tpStatus value for this DwFtSub.
     * 
     * @return tpStatus
     */
    public java.lang.Byte getTpStatus() {
        return tpStatus;
    }


    /**
     * Sets the tpStatus value for this DwFtSub.
     * 
     * @param tpStatus
     */
    public void setTpStatus(java.lang.Byte tpStatus) {
        this.tpStatus = tpStatus;
    }


    /**
     * Gets the vlFtParam value for this DwFtSub.
     * 
     * @return vlFtParam
     */
    public java.math.BigDecimal getVlFtParam() {
        return vlFtParam;
    }


    /**
     * Sets the vlFtParam value for this DwFtSub.
     * 
     * @param vlFtParam
     */
    public void setVlFtParam(java.math.BigDecimal vlFtParam) {
        this.vlFtParam = vlFtParam;
    }


    /**
     * Gets the x41 value for this DwFtSub.
     * 
     * @return x41
     */
    public java.lang.Integer getX41() {
        return x41;
    }


    /**
     * Sets the x41 value for this DwFtSub.
     * 
     * @param x41
     */
    public void setX41(java.lang.Integer x41) {
        this.x41 = x41;
    }


    /**
     * Gets the x42 value for this DwFtSub.
     * 
     * @return x42
     */
    public java.lang.Integer getX42() {
        return x42;
    }


    /**
     * Sets the x42 value for this DwFtSub.
     * 
     * @param x42
     */
    public void setX42(java.lang.Integer x42) {
        this.x42 = x42;
    }


    /**
     * Gets the x45 value for this DwFtSub.
     * 
     * @return x45
     */
    public java.lang.Integer getX45() {
        return x45;
    }


    /**
     * Sets the x45 value for this DwFtSub.
     * 
     * @param x45
     */
    public void setX45(java.lang.Integer x45) {
        this.x45 = x45;
    }


    /**
     * Gets the x46 value for this DwFtSub.
     * 
     * @return x46
     */
    public java.lang.Integer getX46() {
        return x46;
    }


    /**
     * Sets the x46 value for this DwFtSub.
     * 
     * @param x46
     */
    public void setX46(java.lang.Integer x46) {
        this.x46 = x46;
    }


    /**
     * Gets the x47 value for this DwFtSub.
     * 
     * @return x47
     */
    public java.lang.Integer getX47() {
        return x47;
    }


    /**
     * Sets the x47 value for this DwFtSub.
     * 
     * @param x47
     */
    public void setX47(java.lang.Integer x47) {
        this.x47 = x47;
    }


    /**
     * Gets the x48 value for this DwFtSub.
     * 
     * @return x48
     */
    public java.lang.Integer getX48() {
        return x48;
    }


    /**
     * Sets the x48 value for this DwFtSub.
     * 
     * @param x48
     */
    public void setX48(java.lang.Integer x48) {
        this.x48 = x48;
    }


    /**
     * Gets the x49 value for this DwFtSub.
     * 
     * @return x49
     */
    public java.lang.Integer getX49() {
        return x49;
    }


    /**
     * Sets the x49 value for this DwFtSub.
     * 
     * @param x49
     */
    public void setX49(java.lang.Integer x49) {
        this.x49 = x49;
    }


    /**
     * Gets the y81 value for this DwFtSub.
     * 
     * @return y81
     */
    public java.math.BigDecimal getY81() {
        return y81;
    }


    /**
     * Sets the y81 value for this DwFtSub.
     * 
     * @param y81
     */
    public void setY81(java.math.BigDecimal y81) {
        this.y81 = y81;
    }


    /**
     * Gets the y82 value for this DwFtSub.
     * 
     * @return y82
     */
    public java.math.BigDecimal getY82() {
        return y82;
    }


    /**
     * Sets the y82 value for this DwFtSub.
     * 
     * @param y82
     */
    public void setY82(java.math.BigDecimal y82) {
        this.y82 = y82;
    }


    /**
     * Gets the y83 value for this DwFtSub.
     * 
     * @return y83
     */
    public java.math.BigDecimal getY83() {
        return y83;
    }


    /**
     * Sets the y83 value for this DwFtSub.
     * 
     * @param y83
     */
    public void setY83(java.math.BigDecimal y83) {
        this.y83 = y83;
    }


    /**
     * Gets the y84 value for this DwFtSub.
     * 
     * @return y84
     */
    public java.math.BigDecimal getY84() {
        return y84;
    }


    /**
     * Sets the y84 value for this DwFtSub.
     * 
     * @param y84
     */
    public void setY84(java.math.BigDecimal y84) {
        this.y84 = y84;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwFtSub)) return false;
        DwFtSub other = (DwFtSub) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dsSub==null && other.getDsSub()==null) || 
             (this.dsSub!=null &&
              this.dsSub.equals(other.getDsSub()))) &&
            ((this.dwFtEtapa==null && other.getDwFtEtapa()==null) || 
             (this.dwFtEtapa!=null &&
              this.dwFtEtapa.equals(other.getDwFtEtapa()))) &&
            ((this.dwFtParam==null && other.getDwFtParam()==null) || 
             (this.dwFtParam!=null &&
              this.dwFtParam.equals(other.getDwFtParam()))) &&
            ((this.dwFtSubparams==null && other.getDwFtSubparams()==null) || 
             (this.dwFtSubparams!=null &&
              java.util.Arrays.equals(this.dwFtSubparams, other.getDwFtSubparams()))) &&
            ((this.dwTestesubs==null && other.getDwTestesubs()==null) || 
             (this.dwTestesubs!=null &&
              java.util.Arrays.equals(this.dwTestesubs, other.getDwTestesubs()))) &&
            this.idFtSub == other.getIdFtSub() &&
            ((this.ms==null && other.getMs()==null) || 
             (this.ms!=null &&
              this.ms.equals(other.getMs()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.stFtParam==null && other.getStFtParam()==null) || 
             (this.stFtParam!=null &&
              this.stFtParam.equals(other.getStFtParam()))) &&
            ((this.tpFtParam==null && other.getTpFtParam()==null) || 
             (this.tpFtParam!=null &&
              this.tpFtParam.equals(other.getTpFtParam()))) &&
            ((this.tpFtSub==null && other.getTpFtSub()==null) || 
             (this.tpFtSub!=null &&
              this.tpFtSub.equals(other.getTpFtSub()))) &&
            ((this.tpStatus==null && other.getTpStatus()==null) || 
             (this.tpStatus!=null &&
              this.tpStatus.equals(other.getTpStatus()))) &&
            ((this.vlFtParam==null && other.getVlFtParam()==null) || 
             (this.vlFtParam!=null &&
              this.vlFtParam.equals(other.getVlFtParam()))) &&
            ((this.x41==null && other.getX41()==null) || 
             (this.x41!=null &&
              this.x41.equals(other.getX41()))) &&
            ((this.x42==null && other.getX42()==null) || 
             (this.x42!=null &&
              this.x42.equals(other.getX42()))) &&
            ((this.x45==null && other.getX45()==null) || 
             (this.x45!=null &&
              this.x45.equals(other.getX45()))) &&
            ((this.x46==null && other.getX46()==null) || 
             (this.x46!=null &&
              this.x46.equals(other.getX46()))) &&
            ((this.x47==null && other.getX47()==null) || 
             (this.x47!=null &&
              this.x47.equals(other.getX47()))) &&
            ((this.x48==null && other.getX48()==null) || 
             (this.x48!=null &&
              this.x48.equals(other.getX48()))) &&
            ((this.x49==null && other.getX49()==null) || 
             (this.x49!=null &&
              this.x49.equals(other.getX49()))) &&
            ((this.y81==null && other.getY81()==null) || 
             (this.y81!=null &&
              this.y81.equals(other.getY81()))) &&
            ((this.y82==null && other.getY82()==null) || 
             (this.y82!=null &&
              this.y82.equals(other.getY82()))) &&
            ((this.y83==null && other.getY83()==null) || 
             (this.y83!=null &&
              this.y83.equals(other.getY83()))) &&
            ((this.y84==null && other.getY84()==null) || 
             (this.y84!=null &&
              this.y84.equals(other.getY84())));
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
        if (getDsSub() != null) {
            _hashCode += getDsSub().hashCode();
        }
        if (getDwFtEtapa() != null) {
            _hashCode += getDwFtEtapa().hashCode();
        }
        if (getDwFtParam() != null) {
            _hashCode += getDwFtParam().hashCode();
        }
        if (getDwFtSubparams() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFtSubparams());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFtSubparams(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTestesubs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTestesubs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTestesubs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdFtSub()).hashCode();
        if (getMs() != null) {
            _hashCode += getMs().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getStFtParam() != null) {
            _hashCode += getStFtParam().hashCode();
        }
        if (getTpFtParam() != null) {
            _hashCode += getTpFtParam().hashCode();
        }
        if (getTpFtSub() != null) {
            _hashCode += getTpFtSub().hashCode();
        }
        if (getTpStatus() != null) {
            _hashCode += getTpStatus().hashCode();
        }
        if (getVlFtParam() != null) {
            _hashCode += getVlFtParam().hashCode();
        }
        if (getX41() != null) {
            _hashCode += getX41().hashCode();
        }
        if (getX42() != null) {
            _hashCode += getX42().hashCode();
        }
        if (getX45() != null) {
            _hashCode += getX45().hashCode();
        }
        if (getX46() != null) {
            _hashCode += getX46().hashCode();
        }
        if (getX47() != null) {
            _hashCode += getX47().hashCode();
        }
        if (getX48() != null) {
            _hashCode += getX48().hashCode();
        }
        if (getX49() != null) {
            _hashCode += getX49().hashCode();
        }
        if (getY81() != null) {
            _hashCode += getY81().hashCode();
        }
        if (getY82() != null) {
            _hashCode += getY82().hashCode();
        }
        if (getY83() != null) {
            _hashCode += getY83().hashCode();
        }
        if (getY84() != null) {
            _hashCode += getY84().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwFtSub.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtSub"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsSub");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsSub"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFtEtapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtEtapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtEtapa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFtParam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtParam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtParam"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFtSubparams");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtSubparams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtSubparam"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTestesubs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTestesubs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTestesub"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFtSub");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFtSub"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ms");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stFtParam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stFtParam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpFtParam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpFtParam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpFtSub");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpFtSub"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlFtParam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlFtParam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x41");
        elemField.setXmlName(new javax.xml.namespace.QName("", "x41"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x42");
        elemField.setXmlName(new javax.xml.namespace.QName("", "x42"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x45");
        elemField.setXmlName(new javax.xml.namespace.QName("", "x45"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x46");
        elemField.setXmlName(new javax.xml.namespace.QName("", "x46"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x47");
        elemField.setXmlName(new javax.xml.namespace.QName("", "x47"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x48");
        elemField.setXmlName(new javax.xml.namespace.QName("", "x48"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x49");
        elemField.setXmlName(new javax.xml.namespace.QName("", "x49"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("y81");
        elemField.setXmlName(new javax.xml.namespace.QName("", "y81"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("y82");
        elemField.setXmlName(new javax.xml.namespace.QName("", "y82"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("y83");
        elemField.setXmlName(new javax.xml.namespace.QName("", "y83"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("y84");
        elemField.setXmlName(new javax.xml.namespace.QName("", "y84"));
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
