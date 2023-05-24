/**
 * IjtbsubcoletoresId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjtbsubcoletoresId  implements java.io.Serializable {
    private java.lang.String cdcoletor;

    private java.lang.String cdmestre;

    private java.math.BigDecimal cdsubcoletor;

    public IjtbsubcoletoresId() {
    }

    public IjtbsubcoletoresId(
           java.lang.String cdcoletor,
           java.lang.String cdmestre,
           java.math.BigDecimal cdsubcoletor) {
           this.cdcoletor = cdcoletor;
           this.cdmestre = cdmestre;
           this.cdsubcoletor = cdsubcoletor;
    }


    /**
     * Gets the cdcoletor value for this IjtbsubcoletoresId.
     * 
     * @return cdcoletor
     */
    public java.lang.String getCdcoletor() {
        return cdcoletor;
    }


    /**
     * Sets the cdcoletor value for this IjtbsubcoletoresId.
     * 
     * @param cdcoletor
     */
    public void setCdcoletor(java.lang.String cdcoletor) {
        this.cdcoletor = cdcoletor;
    }


    /**
     * Gets the cdmestre value for this IjtbsubcoletoresId.
     * 
     * @return cdmestre
     */
    public java.lang.String getCdmestre() {
        return cdmestre;
    }


    /**
     * Sets the cdmestre value for this IjtbsubcoletoresId.
     * 
     * @param cdmestre
     */
    public void setCdmestre(java.lang.String cdmestre) {
        this.cdmestre = cdmestre;
    }


    /**
     * Gets the cdsubcoletor value for this IjtbsubcoletoresId.
     * 
     * @return cdsubcoletor
     */
    public java.math.BigDecimal getCdsubcoletor() {
        return cdsubcoletor;
    }


    /**
     * Sets the cdsubcoletor value for this IjtbsubcoletoresId.
     * 
     * @param cdsubcoletor
     */
    public void setCdsubcoletor(java.math.BigDecimal cdsubcoletor) {
        this.cdsubcoletor = cdsubcoletor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjtbsubcoletoresId)) return false;
        IjtbsubcoletoresId other = (IjtbsubcoletoresId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcoletor==null && other.getCdcoletor()==null) || 
             (this.cdcoletor!=null &&
              this.cdcoletor.equals(other.getCdcoletor()))) &&
            ((this.cdmestre==null && other.getCdmestre()==null) || 
             (this.cdmestre!=null &&
              this.cdmestre.equals(other.getCdmestre()))) &&
            ((this.cdsubcoletor==null && other.getCdsubcoletor()==null) || 
             (this.cdsubcoletor!=null &&
              this.cdsubcoletor.equals(other.getCdsubcoletor())));
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
        if (getCdcoletor() != null) {
            _hashCode += getCdcoletor().hashCode();
        }
        if (getCdmestre() != null) {
            _hashCode += getCdmestre().hashCode();
        }
        if (getCdsubcoletor() != null) {
            _hashCode += getCdsubcoletor().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjtbsubcoletoresId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbsubcoletoresId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcoletor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcoletor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmestre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmestre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdsubcoletor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdsubcoletor"));
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
