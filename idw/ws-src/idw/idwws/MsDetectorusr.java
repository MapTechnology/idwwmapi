/**
 * MsDetectorusr.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MsDetectorusr  implements java.io.Serializable {
    private java.math.BigDecimal idDetectorusr;

    private idw.idwws.MsDetector msDetector;

    private idw.idwws.MsUsr msUsr;

    public MsDetectorusr() {
    }

    public MsDetectorusr(
           java.math.BigDecimal idDetectorusr,
           idw.idwws.MsDetector msDetector,
           idw.idwws.MsUsr msUsr) {
           this.idDetectorusr = idDetectorusr;
           this.msDetector = msDetector;
           this.msUsr = msUsr;
    }


    /**
     * Gets the idDetectorusr value for this MsDetectorusr.
     * 
     * @return idDetectorusr
     */
    public java.math.BigDecimal getIdDetectorusr() {
        return idDetectorusr;
    }


    /**
     * Sets the idDetectorusr value for this MsDetectorusr.
     * 
     * @param idDetectorusr
     */
    public void setIdDetectorusr(java.math.BigDecimal idDetectorusr) {
        this.idDetectorusr = idDetectorusr;
    }


    /**
     * Gets the msDetector value for this MsDetectorusr.
     * 
     * @return msDetector
     */
    public idw.idwws.MsDetector getMsDetector() {
        return msDetector;
    }


    /**
     * Sets the msDetector value for this MsDetectorusr.
     * 
     * @param msDetector
     */
    public void setMsDetector(idw.idwws.MsDetector msDetector) {
        this.msDetector = msDetector;
    }


    /**
     * Gets the msUsr value for this MsDetectorusr.
     * 
     * @return msUsr
     */
    public idw.idwws.MsUsr getMsUsr() {
        return msUsr;
    }


    /**
     * Sets the msUsr value for this MsDetectorusr.
     * 
     * @param msUsr
     */
    public void setMsUsr(idw.idwws.MsUsr msUsr) {
        this.msUsr = msUsr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MsDetectorusr)) return false;
        MsDetectorusr other = (MsDetectorusr) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idDetectorusr==null && other.getIdDetectorusr()==null) || 
             (this.idDetectorusr!=null &&
              this.idDetectorusr.equals(other.getIdDetectorusr()))) &&
            ((this.msDetector==null && other.getMsDetector()==null) || 
             (this.msDetector!=null &&
              this.msDetector.equals(other.getMsDetector()))) &&
            ((this.msUsr==null && other.getMsUsr()==null) || 
             (this.msUsr!=null &&
              this.msUsr.equals(other.getMsUsr())));
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
        if (getIdDetectorusr() != null) {
            _hashCode += getIdDetectorusr().hashCode();
        }
        if (getMsDetector() != null) {
            _hashCode += getMsDetector().hashCode();
        }
        if (getMsUsr() != null) {
            _hashCode += getMsUsr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MsDetectorusr.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msDetectorusr"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idDetectorusr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idDetectorusr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDetector");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDetector"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msDetector"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msUsr"));
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
