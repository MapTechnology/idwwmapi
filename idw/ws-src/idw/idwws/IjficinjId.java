/**
 * IjficinjId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjficinjId  implements java.io.Serializable {
    private java.lang.String cdinjetora;

    private java.lang.String cditemcnc;

    private java.math.BigDecimal posicaoordinal;

    public IjficinjId() {
    }

    public IjficinjId(
           java.lang.String cdinjetora,
           java.lang.String cditemcnc,
           java.math.BigDecimal posicaoordinal) {
           this.cdinjetora = cdinjetora;
           this.cditemcnc = cditemcnc;
           this.posicaoordinal = posicaoordinal;
    }


    /**
     * Gets the cdinjetora value for this IjficinjId.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this IjficinjId.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the cditemcnc value for this IjficinjId.
     * 
     * @return cditemcnc
     */
    public java.lang.String getCditemcnc() {
        return cditemcnc;
    }


    /**
     * Sets the cditemcnc value for this IjficinjId.
     * 
     * @param cditemcnc
     */
    public void setCditemcnc(java.lang.String cditemcnc) {
        this.cditemcnc = cditemcnc;
    }


    /**
     * Gets the posicaoordinal value for this IjficinjId.
     * 
     * @return posicaoordinal
     */
    public java.math.BigDecimal getPosicaoordinal() {
        return posicaoordinal;
    }


    /**
     * Sets the posicaoordinal value for this IjficinjId.
     * 
     * @param posicaoordinal
     */
    public void setPosicaoordinal(java.math.BigDecimal posicaoordinal) {
        this.posicaoordinal = posicaoordinal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjficinjId)) return false;
        IjficinjId other = (IjficinjId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora()))) &&
            ((this.cditemcnc==null && other.getCditemcnc()==null) || 
             (this.cditemcnc!=null &&
              this.cditemcnc.equals(other.getCditemcnc()))) &&
            ((this.posicaoordinal==null && other.getPosicaoordinal()==null) || 
             (this.posicaoordinal!=null &&
              this.posicaoordinal.equals(other.getPosicaoordinal())));
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
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        if (getCditemcnc() != null) {
            _hashCode += getCditemcnc().hashCode();
        }
        if (getPosicaoordinal() != null) {
            _hashCode += getPosicaoordinal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjficinjId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijficinjId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cditemcnc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cditemcnc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posicaoordinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "posicaoordinal"));
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
