/**
 * MsMsihm.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MsMsihm  extends idw.idwws.MsMsihmTemplate  implements java.io.Serializable {
    private java.util.Calendar dthrRegistro;

    private java.math.BigDecimal idMsihm;

    private idw.idwws.MsIhm msIhm;

    private idw.idwws.MsMs msMs;

    public MsMsihm() {
    }

    public MsMsihm(
           java.util.Calendar dthrRegistro,
           java.math.BigDecimal idMsihm,
           idw.idwws.MsIhm msIhm,
           idw.idwws.MsMs msMs) {
        this.dthrRegistro = dthrRegistro;
        this.idMsihm = idMsihm;
        this.msIhm = msIhm;
        this.msMs = msMs;
    }


    /**
     * Gets the dthrRegistro value for this MsMsihm.
     * 
     * @return dthrRegistro
     */
    public java.util.Calendar getDthrRegistro() {
        return dthrRegistro;
    }


    /**
     * Sets the dthrRegistro value for this MsMsihm.
     * 
     * @param dthrRegistro
     */
    public void setDthrRegistro(java.util.Calendar dthrRegistro) {
        this.dthrRegistro = dthrRegistro;
    }


    /**
     * Gets the idMsihm value for this MsMsihm.
     * 
     * @return idMsihm
     */
    public java.math.BigDecimal getIdMsihm() {
        return idMsihm;
    }


    /**
     * Sets the idMsihm value for this MsMsihm.
     * 
     * @param idMsihm
     */
    public void setIdMsihm(java.math.BigDecimal idMsihm) {
        this.idMsihm = idMsihm;
    }


    /**
     * Gets the msIhm value for this MsMsihm.
     * 
     * @return msIhm
     */
    public idw.idwws.MsIhm getMsIhm() {
        return msIhm;
    }


    /**
     * Sets the msIhm value for this MsMsihm.
     * 
     * @param msIhm
     */
    public void setMsIhm(idw.idwws.MsIhm msIhm) {
        this.msIhm = msIhm;
    }


    /**
     * Gets the msMs value for this MsMsihm.
     * 
     * @return msMs
     */
    public idw.idwws.MsMs getMsMs() {
        return msMs;
    }


    /**
     * Sets the msMs value for this MsMsihm.
     * 
     * @param msMs
     */
    public void setMsMs(idw.idwws.MsMs msMs) {
        this.msMs = msMs;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MsMsihm)) return false;
        MsMsihm other = (MsMsihm) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dthrRegistro==null && other.getDthrRegistro()==null) || 
             (this.dthrRegistro!=null &&
              this.dthrRegistro.equals(other.getDthrRegistro()))) &&
            ((this.idMsihm==null && other.getIdMsihm()==null) || 
             (this.idMsihm!=null &&
              this.idMsihm.equals(other.getIdMsihm()))) &&
            ((this.msIhm==null && other.getMsIhm()==null) || 
             (this.msIhm!=null &&
              this.msIhm.equals(other.getMsIhm()))) &&
            ((this.msMs==null && other.getMsMs()==null) || 
             (this.msMs!=null &&
              this.msMs.equals(other.getMsMs())));
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
        if (getDthrRegistro() != null) {
            _hashCode += getDthrRegistro().hashCode();
        }
        if (getIdMsihm() != null) {
            _hashCode += getIdMsihm().hashCode();
        }
        if (getMsIhm() != null) {
            _hashCode += getMsIhm().hashCode();
        }
        if (getMsMs() != null) {
            _hashCode += getMsMs().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MsMsihm.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msMsihm"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrRegistro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrRegistro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idMsihm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idMsihm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msIhm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msIhm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msIhm"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msMs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msMs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msMs"));
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
