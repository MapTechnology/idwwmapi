/**
 * DwPasstfse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwPasstfse  extends idw.idwws.DwPasstfseTemplate  implements java.io.Serializable {
    private java.util.Calendar dthrFposfalha;

    private java.util.Calendar dthrFsubetapa;

    private java.util.Calendar dthrIposfalha;

    private java.util.Calendar dthrIsubetapa;

    private idw.idwws.DwFtSub dwFtSub;

    private idw.idwws.DwPasstf dwPasstf;

    private idw.idwws.DwPasstfsepmView[] dwPasstfsepmViews;

    private idw.idwws.DwPasstfsepm[] dwPasstfsepms;

    private long idPasstfse;

    private java.math.BigDecimal msDthrfposfalha;

    private java.math.BigDecimal msDthrfsubetapa;

    private java.math.BigDecimal msDthriposfalha;

    private java.math.BigDecimal msDthrisubetapa;

    private java.lang.Integer ordemsubetapa;

    private java.lang.Integer stSubetapa;

    public DwPasstfse() {
    }

    public DwPasstfse(
           java.util.Calendar dthrFposfalha,
           java.util.Calendar dthrFsubetapa,
           java.util.Calendar dthrIposfalha,
           java.util.Calendar dthrIsubetapa,
           idw.idwws.DwFtSub dwFtSub,
           idw.idwws.DwPasstf dwPasstf,
           idw.idwws.DwPasstfsepmView[] dwPasstfsepmViews,
           idw.idwws.DwPasstfsepm[] dwPasstfsepms,
           long idPasstfse,
           java.math.BigDecimal msDthrfposfalha,
           java.math.BigDecimal msDthrfsubetapa,
           java.math.BigDecimal msDthriposfalha,
           java.math.BigDecimal msDthrisubetapa,
           java.lang.Integer ordemsubetapa,
           java.lang.Integer stSubetapa) {
        this.dthrFposfalha = dthrFposfalha;
        this.dthrFsubetapa = dthrFsubetapa;
        this.dthrIposfalha = dthrIposfalha;
        this.dthrIsubetapa = dthrIsubetapa;
        this.dwFtSub = dwFtSub;
        this.dwPasstf = dwPasstf;
        this.dwPasstfsepmViews = dwPasstfsepmViews;
        this.dwPasstfsepms = dwPasstfsepms;
        this.idPasstfse = idPasstfse;
        this.msDthrfposfalha = msDthrfposfalha;
        this.msDthrfsubetapa = msDthrfsubetapa;
        this.msDthriposfalha = msDthriposfalha;
        this.msDthrisubetapa = msDthrisubetapa;
        this.ordemsubetapa = ordemsubetapa;
        this.stSubetapa = stSubetapa;
    }


    /**
     * Gets the dthrFposfalha value for this DwPasstfse.
     * 
     * @return dthrFposfalha
     */
    public java.util.Calendar getDthrFposfalha() {
        return dthrFposfalha;
    }


    /**
     * Sets the dthrFposfalha value for this DwPasstfse.
     * 
     * @param dthrFposfalha
     */
    public void setDthrFposfalha(java.util.Calendar dthrFposfalha) {
        this.dthrFposfalha = dthrFposfalha;
    }


    /**
     * Gets the dthrFsubetapa value for this DwPasstfse.
     * 
     * @return dthrFsubetapa
     */
    public java.util.Calendar getDthrFsubetapa() {
        return dthrFsubetapa;
    }


    /**
     * Sets the dthrFsubetapa value for this DwPasstfse.
     * 
     * @param dthrFsubetapa
     */
    public void setDthrFsubetapa(java.util.Calendar dthrFsubetapa) {
        this.dthrFsubetapa = dthrFsubetapa;
    }


    /**
     * Gets the dthrIposfalha value for this DwPasstfse.
     * 
     * @return dthrIposfalha
     */
    public java.util.Calendar getDthrIposfalha() {
        return dthrIposfalha;
    }


    /**
     * Sets the dthrIposfalha value for this DwPasstfse.
     * 
     * @param dthrIposfalha
     */
    public void setDthrIposfalha(java.util.Calendar dthrIposfalha) {
        this.dthrIposfalha = dthrIposfalha;
    }


    /**
     * Gets the dthrIsubetapa value for this DwPasstfse.
     * 
     * @return dthrIsubetapa
     */
    public java.util.Calendar getDthrIsubetapa() {
        return dthrIsubetapa;
    }


    /**
     * Sets the dthrIsubetapa value for this DwPasstfse.
     * 
     * @param dthrIsubetapa
     */
    public void setDthrIsubetapa(java.util.Calendar dthrIsubetapa) {
        this.dthrIsubetapa = dthrIsubetapa;
    }


    /**
     * Gets the dwFtSub value for this DwPasstfse.
     * 
     * @return dwFtSub
     */
    public idw.idwws.DwFtSub getDwFtSub() {
        return dwFtSub;
    }


    /**
     * Sets the dwFtSub value for this DwPasstfse.
     * 
     * @param dwFtSub
     */
    public void setDwFtSub(idw.idwws.DwFtSub dwFtSub) {
        this.dwFtSub = dwFtSub;
    }


    /**
     * Gets the dwPasstf value for this DwPasstfse.
     * 
     * @return dwPasstf
     */
    public idw.idwws.DwPasstf getDwPasstf() {
        return dwPasstf;
    }


    /**
     * Sets the dwPasstf value for this DwPasstfse.
     * 
     * @param dwPasstf
     */
    public void setDwPasstf(idw.idwws.DwPasstf dwPasstf) {
        this.dwPasstf = dwPasstf;
    }


    /**
     * Gets the dwPasstfsepmViews value for this DwPasstfse.
     * 
     * @return dwPasstfsepmViews
     */
    public idw.idwws.DwPasstfsepmView[] getDwPasstfsepmViews() {
        return dwPasstfsepmViews;
    }


    /**
     * Sets the dwPasstfsepmViews value for this DwPasstfse.
     * 
     * @param dwPasstfsepmViews
     */
    public void setDwPasstfsepmViews(idw.idwws.DwPasstfsepmView[] dwPasstfsepmViews) {
        this.dwPasstfsepmViews = dwPasstfsepmViews;
    }

    public idw.idwws.DwPasstfsepmView getDwPasstfsepmViews(int i) {
        return this.dwPasstfsepmViews[i];
    }

    public void setDwPasstfsepmViews(int i, idw.idwws.DwPasstfsepmView _value) {
        this.dwPasstfsepmViews[i] = _value;
    }


    /**
     * Gets the dwPasstfsepms value for this DwPasstfse.
     * 
     * @return dwPasstfsepms
     */
    public idw.idwws.DwPasstfsepm[] getDwPasstfsepms() {
        return dwPasstfsepms;
    }


    /**
     * Sets the dwPasstfsepms value for this DwPasstfse.
     * 
     * @param dwPasstfsepms
     */
    public void setDwPasstfsepms(idw.idwws.DwPasstfsepm[] dwPasstfsepms) {
        this.dwPasstfsepms = dwPasstfsepms;
    }

    public idw.idwws.DwPasstfsepm getDwPasstfsepms(int i) {
        return this.dwPasstfsepms[i];
    }

    public void setDwPasstfsepms(int i, idw.idwws.DwPasstfsepm _value) {
        this.dwPasstfsepms[i] = _value;
    }


    /**
     * Gets the idPasstfse value for this DwPasstfse.
     * 
     * @return idPasstfse
     */
    public long getIdPasstfse() {
        return idPasstfse;
    }


    /**
     * Sets the idPasstfse value for this DwPasstfse.
     * 
     * @param idPasstfse
     */
    public void setIdPasstfse(long idPasstfse) {
        this.idPasstfse = idPasstfse;
    }


    /**
     * Gets the msDthrfposfalha value for this DwPasstfse.
     * 
     * @return msDthrfposfalha
     */
    public java.math.BigDecimal getMsDthrfposfalha() {
        return msDthrfposfalha;
    }


    /**
     * Sets the msDthrfposfalha value for this DwPasstfse.
     * 
     * @param msDthrfposfalha
     */
    public void setMsDthrfposfalha(java.math.BigDecimal msDthrfposfalha) {
        this.msDthrfposfalha = msDthrfposfalha;
    }


    /**
     * Gets the msDthrfsubetapa value for this DwPasstfse.
     * 
     * @return msDthrfsubetapa
     */
    public java.math.BigDecimal getMsDthrfsubetapa() {
        return msDthrfsubetapa;
    }


    /**
     * Sets the msDthrfsubetapa value for this DwPasstfse.
     * 
     * @param msDthrfsubetapa
     */
    public void setMsDthrfsubetapa(java.math.BigDecimal msDthrfsubetapa) {
        this.msDthrfsubetapa = msDthrfsubetapa;
    }


    /**
     * Gets the msDthriposfalha value for this DwPasstfse.
     * 
     * @return msDthriposfalha
     */
    public java.math.BigDecimal getMsDthriposfalha() {
        return msDthriposfalha;
    }


    /**
     * Sets the msDthriposfalha value for this DwPasstfse.
     * 
     * @param msDthriposfalha
     */
    public void setMsDthriposfalha(java.math.BigDecimal msDthriposfalha) {
        this.msDthriposfalha = msDthriposfalha;
    }


    /**
     * Gets the msDthrisubetapa value for this DwPasstfse.
     * 
     * @return msDthrisubetapa
     */
    public java.math.BigDecimal getMsDthrisubetapa() {
        return msDthrisubetapa;
    }


    /**
     * Sets the msDthrisubetapa value for this DwPasstfse.
     * 
     * @param msDthrisubetapa
     */
    public void setMsDthrisubetapa(java.math.BigDecimal msDthrisubetapa) {
        this.msDthrisubetapa = msDthrisubetapa;
    }


    /**
     * Gets the ordemsubetapa value for this DwPasstfse.
     * 
     * @return ordemsubetapa
     */
    public java.lang.Integer getOrdemsubetapa() {
        return ordemsubetapa;
    }


    /**
     * Sets the ordemsubetapa value for this DwPasstfse.
     * 
     * @param ordemsubetapa
     */
    public void setOrdemsubetapa(java.lang.Integer ordemsubetapa) {
        this.ordemsubetapa = ordemsubetapa;
    }


    /**
     * Gets the stSubetapa value for this DwPasstfse.
     * 
     * @return stSubetapa
     */
    public java.lang.Integer getStSubetapa() {
        return stSubetapa;
    }


    /**
     * Sets the stSubetapa value for this DwPasstfse.
     * 
     * @param stSubetapa
     */
    public void setStSubetapa(java.lang.Integer stSubetapa) {
        this.stSubetapa = stSubetapa;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwPasstfse)) return false;
        DwPasstfse other = (DwPasstfse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dthrFposfalha==null && other.getDthrFposfalha()==null) || 
             (this.dthrFposfalha!=null &&
              this.dthrFposfalha.equals(other.getDthrFposfalha()))) &&
            ((this.dthrFsubetapa==null && other.getDthrFsubetapa()==null) || 
             (this.dthrFsubetapa!=null &&
              this.dthrFsubetapa.equals(other.getDthrFsubetapa()))) &&
            ((this.dthrIposfalha==null && other.getDthrIposfalha()==null) || 
             (this.dthrIposfalha!=null &&
              this.dthrIposfalha.equals(other.getDthrIposfalha()))) &&
            ((this.dthrIsubetapa==null && other.getDthrIsubetapa()==null) || 
             (this.dthrIsubetapa!=null &&
              this.dthrIsubetapa.equals(other.getDthrIsubetapa()))) &&
            ((this.dwFtSub==null && other.getDwFtSub()==null) || 
             (this.dwFtSub!=null &&
              this.dwFtSub.equals(other.getDwFtSub()))) &&
            ((this.dwPasstf==null && other.getDwPasstf()==null) || 
             (this.dwPasstf!=null &&
              this.dwPasstf.equals(other.getDwPasstf()))) &&
            ((this.dwPasstfsepmViews==null && other.getDwPasstfsepmViews()==null) || 
             (this.dwPasstfsepmViews!=null &&
              java.util.Arrays.equals(this.dwPasstfsepmViews, other.getDwPasstfsepmViews()))) &&
            ((this.dwPasstfsepms==null && other.getDwPasstfsepms()==null) || 
             (this.dwPasstfsepms!=null &&
              java.util.Arrays.equals(this.dwPasstfsepms, other.getDwPasstfsepms()))) &&
            this.idPasstfse == other.getIdPasstfse() &&
            ((this.msDthrfposfalha==null && other.getMsDthrfposfalha()==null) || 
             (this.msDthrfposfalha!=null &&
              this.msDthrfposfalha.equals(other.getMsDthrfposfalha()))) &&
            ((this.msDthrfsubetapa==null && other.getMsDthrfsubetapa()==null) || 
             (this.msDthrfsubetapa!=null &&
              this.msDthrfsubetapa.equals(other.getMsDthrfsubetapa()))) &&
            ((this.msDthriposfalha==null && other.getMsDthriposfalha()==null) || 
             (this.msDthriposfalha!=null &&
              this.msDthriposfalha.equals(other.getMsDthriposfalha()))) &&
            ((this.msDthrisubetapa==null && other.getMsDthrisubetapa()==null) || 
             (this.msDthrisubetapa!=null &&
              this.msDthrisubetapa.equals(other.getMsDthrisubetapa()))) &&
            ((this.ordemsubetapa==null && other.getOrdemsubetapa()==null) || 
             (this.ordemsubetapa!=null &&
              this.ordemsubetapa.equals(other.getOrdemsubetapa()))) &&
            ((this.stSubetapa==null && other.getStSubetapa()==null) || 
             (this.stSubetapa!=null &&
              this.stSubetapa.equals(other.getStSubetapa())));
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
        if (getDthrFposfalha() != null) {
            _hashCode += getDthrFposfalha().hashCode();
        }
        if (getDthrFsubetapa() != null) {
            _hashCode += getDthrFsubetapa().hashCode();
        }
        if (getDthrIposfalha() != null) {
            _hashCode += getDthrIposfalha().hashCode();
        }
        if (getDthrIsubetapa() != null) {
            _hashCode += getDthrIsubetapa().hashCode();
        }
        if (getDwFtSub() != null) {
            _hashCode += getDwFtSub().hashCode();
        }
        if (getDwPasstf() != null) {
            _hashCode += getDwPasstf().hashCode();
        }
        if (getDwPasstfsepmViews() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwPasstfsepmViews());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwPasstfsepmViews(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwPasstfsepms() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwPasstfsepms());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwPasstfsepms(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdPasstfse()).hashCode();
        if (getMsDthrfposfalha() != null) {
            _hashCode += getMsDthrfposfalha().hashCode();
        }
        if (getMsDthrfsubetapa() != null) {
            _hashCode += getMsDthrfsubetapa().hashCode();
        }
        if (getMsDthriposfalha() != null) {
            _hashCode += getMsDthriposfalha().hashCode();
        }
        if (getMsDthrisubetapa() != null) {
            _hashCode += getMsDthrisubetapa().hashCode();
        }
        if (getOrdemsubetapa() != null) {
            _hashCode += getOrdemsubetapa().hashCode();
        }
        if (getStSubetapa() != null) {
            _hashCode += getStSubetapa().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwPasstfse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPasstfse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFposfalha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFposfalha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFsubetapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFsubetapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIposfalha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIposfalha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIsubetapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIsubetapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFtSub");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtSub"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtSub"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPasstf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPasstf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPasstf"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPasstfsepmViews");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPasstfsepmViews"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPasstfsepmView"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPasstfsepms");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPasstfsepms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPasstfsepm"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPasstfse");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPasstfse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrfposfalha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrfposfalha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrfsubetapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrfsubetapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthriposfalha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthriposfalha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrisubetapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrisubetapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordemsubetapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordemsubetapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stSubetapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stSubetapa"));
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
