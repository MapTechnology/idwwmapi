/**
 * DwConsolallog.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolallog  extends idw.idwws.DwConsolallogTemplate  implements java.io.Serializable {
    private java.util.Calendar dthrFalerta;

    private java.util.Calendar dthrIalerta;

    private idw.idwws.DwConsolaloco[] dwConsolalocos;

    private idw.idwws.DwTAlerta dwTAlerta;

    private long idConsolallog;

    private java.lang.Integer msDthrfalerta;

    private java.lang.Integer msDthrialerta;

    private idw.idwws.OmPt omPt;

    private java.math.BigDecimal segAutoTempoalerta;

    private java.math.BigDecimal segManuTempoalerta;

    public DwConsolallog() {
    }

    public DwConsolallog(
           java.util.Calendar dthrFalerta,
           java.util.Calendar dthrIalerta,
           idw.idwws.DwConsolaloco[] dwConsolalocos,
           idw.idwws.DwTAlerta dwTAlerta,
           long idConsolallog,
           java.lang.Integer msDthrfalerta,
           java.lang.Integer msDthrialerta,
           idw.idwws.OmPt omPt,
           java.math.BigDecimal segAutoTempoalerta,
           java.math.BigDecimal segManuTempoalerta) {
        this.dthrFalerta = dthrFalerta;
        this.dthrIalerta = dthrIalerta;
        this.dwConsolalocos = dwConsolalocos;
        this.dwTAlerta = dwTAlerta;
        this.idConsolallog = idConsolallog;
        this.msDthrfalerta = msDthrfalerta;
        this.msDthrialerta = msDthrialerta;
        this.omPt = omPt;
        this.segAutoTempoalerta = segAutoTempoalerta;
        this.segManuTempoalerta = segManuTempoalerta;
    }


    /**
     * Gets the dthrFalerta value for this DwConsolallog.
     * 
     * @return dthrFalerta
     */
    public java.util.Calendar getDthrFalerta() {
        return dthrFalerta;
    }


    /**
     * Sets the dthrFalerta value for this DwConsolallog.
     * 
     * @param dthrFalerta
     */
    public void setDthrFalerta(java.util.Calendar dthrFalerta) {
        this.dthrFalerta = dthrFalerta;
    }


    /**
     * Gets the dthrIalerta value for this DwConsolallog.
     * 
     * @return dthrIalerta
     */
    public java.util.Calendar getDthrIalerta() {
        return dthrIalerta;
    }


    /**
     * Sets the dthrIalerta value for this DwConsolallog.
     * 
     * @param dthrIalerta
     */
    public void setDthrIalerta(java.util.Calendar dthrIalerta) {
        this.dthrIalerta = dthrIalerta;
    }


    /**
     * Gets the dwConsolalocos value for this DwConsolallog.
     * 
     * @return dwConsolalocos
     */
    public idw.idwws.DwConsolaloco[] getDwConsolalocos() {
        return dwConsolalocos;
    }


    /**
     * Sets the dwConsolalocos value for this DwConsolallog.
     * 
     * @param dwConsolalocos
     */
    public void setDwConsolalocos(idw.idwws.DwConsolaloco[] dwConsolalocos) {
        this.dwConsolalocos = dwConsolalocos;
    }

    public idw.idwws.DwConsolaloco getDwConsolalocos(int i) {
        return this.dwConsolalocos[i];
    }

    public void setDwConsolalocos(int i, idw.idwws.DwConsolaloco _value) {
        this.dwConsolalocos[i] = _value;
    }


    /**
     * Gets the dwTAlerta value for this DwConsolallog.
     * 
     * @return dwTAlerta
     */
    public idw.idwws.DwTAlerta getDwTAlerta() {
        return dwTAlerta;
    }


    /**
     * Sets the dwTAlerta value for this DwConsolallog.
     * 
     * @param dwTAlerta
     */
    public void setDwTAlerta(idw.idwws.DwTAlerta dwTAlerta) {
        this.dwTAlerta = dwTAlerta;
    }


    /**
     * Gets the idConsolallog value for this DwConsolallog.
     * 
     * @return idConsolallog
     */
    public long getIdConsolallog() {
        return idConsolallog;
    }


    /**
     * Sets the idConsolallog value for this DwConsolallog.
     * 
     * @param idConsolallog
     */
    public void setIdConsolallog(long idConsolallog) {
        this.idConsolallog = idConsolallog;
    }


    /**
     * Gets the msDthrfalerta value for this DwConsolallog.
     * 
     * @return msDthrfalerta
     */
    public java.lang.Integer getMsDthrfalerta() {
        return msDthrfalerta;
    }


    /**
     * Sets the msDthrfalerta value for this DwConsolallog.
     * 
     * @param msDthrfalerta
     */
    public void setMsDthrfalerta(java.lang.Integer msDthrfalerta) {
        this.msDthrfalerta = msDthrfalerta;
    }


    /**
     * Gets the msDthrialerta value for this DwConsolallog.
     * 
     * @return msDthrialerta
     */
    public java.lang.Integer getMsDthrialerta() {
        return msDthrialerta;
    }


    /**
     * Sets the msDthrialerta value for this DwConsolallog.
     * 
     * @param msDthrialerta
     */
    public void setMsDthrialerta(java.lang.Integer msDthrialerta) {
        this.msDthrialerta = msDthrialerta;
    }


    /**
     * Gets the omPt value for this DwConsolallog.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this DwConsolallog.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the segAutoTempoalerta value for this DwConsolallog.
     * 
     * @return segAutoTempoalerta
     */
    public java.math.BigDecimal getSegAutoTempoalerta() {
        return segAutoTempoalerta;
    }


    /**
     * Sets the segAutoTempoalerta value for this DwConsolallog.
     * 
     * @param segAutoTempoalerta
     */
    public void setSegAutoTempoalerta(java.math.BigDecimal segAutoTempoalerta) {
        this.segAutoTempoalerta = segAutoTempoalerta;
    }


    /**
     * Gets the segManuTempoalerta value for this DwConsolallog.
     * 
     * @return segManuTempoalerta
     */
    public java.math.BigDecimal getSegManuTempoalerta() {
        return segManuTempoalerta;
    }


    /**
     * Sets the segManuTempoalerta value for this DwConsolallog.
     * 
     * @param segManuTempoalerta
     */
    public void setSegManuTempoalerta(java.math.BigDecimal segManuTempoalerta) {
        this.segManuTempoalerta = segManuTempoalerta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolallog)) return false;
        DwConsolallog other = (DwConsolallog) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dthrFalerta==null && other.getDthrFalerta()==null) || 
             (this.dthrFalerta!=null &&
              this.dthrFalerta.equals(other.getDthrFalerta()))) &&
            ((this.dthrIalerta==null && other.getDthrIalerta()==null) || 
             (this.dthrIalerta!=null &&
              this.dthrIalerta.equals(other.getDthrIalerta()))) &&
            ((this.dwConsolalocos==null && other.getDwConsolalocos()==null) || 
             (this.dwConsolalocos!=null &&
              java.util.Arrays.equals(this.dwConsolalocos, other.getDwConsolalocos()))) &&
            ((this.dwTAlerta==null && other.getDwTAlerta()==null) || 
             (this.dwTAlerta!=null &&
              this.dwTAlerta.equals(other.getDwTAlerta()))) &&
            this.idConsolallog == other.getIdConsolallog() &&
            ((this.msDthrfalerta==null && other.getMsDthrfalerta()==null) || 
             (this.msDthrfalerta!=null &&
              this.msDthrfalerta.equals(other.getMsDthrfalerta()))) &&
            ((this.msDthrialerta==null && other.getMsDthrialerta()==null) || 
             (this.msDthrialerta!=null &&
              this.msDthrialerta.equals(other.getMsDthrialerta()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.segAutoTempoalerta==null && other.getSegAutoTempoalerta()==null) || 
             (this.segAutoTempoalerta!=null &&
              this.segAutoTempoalerta.equals(other.getSegAutoTempoalerta()))) &&
            ((this.segManuTempoalerta==null && other.getSegManuTempoalerta()==null) || 
             (this.segManuTempoalerta!=null &&
              this.segManuTempoalerta.equals(other.getSegManuTempoalerta())));
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
        if (getDthrFalerta() != null) {
            _hashCode += getDthrFalerta().hashCode();
        }
        if (getDthrIalerta() != null) {
            _hashCode += getDthrIalerta().hashCode();
        }
        if (getDwConsolalocos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolalocos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolalocos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTAlerta() != null) {
            _hashCode += getDwTAlerta().hashCode();
        }
        _hashCode += new Long(getIdConsolallog()).hashCode();
        if (getMsDthrfalerta() != null) {
            _hashCode += getMsDthrfalerta().hashCode();
        }
        if (getMsDthrialerta() != null) {
            _hashCode += getMsDthrialerta().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getSegAutoTempoalerta() != null) {
            _hashCode += getSegAutoTempoalerta().hashCode();
        }
        if (getSegManuTempoalerta() != null) {
            _hashCode += getSegManuTempoalerta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolallog.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolallog"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolalocos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolalocos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolaloco"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTAlerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTAlerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTAlerta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolallog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolallog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrfalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrfalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrialerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrialerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("segAutoTempoalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoalerta"));
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
