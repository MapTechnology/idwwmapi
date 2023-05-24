/**
 * IwsConsultaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IwsConsultaDTO  implements java.io.Serializable {
    private java.lang.String campoRSP1;

    private java.lang.String campoRSP2;

    private java.lang.String campoRSP3;

    private java.lang.String campoRSP4;

    private java.lang.String campoRSP5;

    private java.lang.String campoRSP6;

    private java.lang.String campoRSP7;

    private java.lang.String campoRSP8;

    private boolean resposta;

    public IwsConsultaDTO() {
    }

    public IwsConsultaDTO(
           java.lang.String campoRSP1,
           java.lang.String campoRSP2,
           java.lang.String campoRSP3,
           java.lang.String campoRSP4,
           java.lang.String campoRSP5,
           java.lang.String campoRSP6,
           java.lang.String campoRSP7,
           java.lang.String campoRSP8,
           boolean resposta) {
           this.campoRSP1 = campoRSP1;
           this.campoRSP2 = campoRSP2;
           this.campoRSP3 = campoRSP3;
           this.campoRSP4 = campoRSP4;
           this.campoRSP5 = campoRSP5;
           this.campoRSP6 = campoRSP6;
           this.campoRSP7 = campoRSP7;
           this.campoRSP8 = campoRSP8;
           this.resposta = resposta;
    }


    /**
     * Gets the campoRSP1 value for this IwsConsultaDTO.
     * 
     * @return campoRSP1
     */
    public java.lang.String getCampoRSP1() {
        return campoRSP1;
    }


    /**
     * Sets the campoRSP1 value for this IwsConsultaDTO.
     * 
     * @param campoRSP1
     */
    public void setCampoRSP1(java.lang.String campoRSP1) {
        this.campoRSP1 = campoRSP1;
    }


    /**
     * Gets the campoRSP2 value for this IwsConsultaDTO.
     * 
     * @return campoRSP2
     */
    public java.lang.String getCampoRSP2() {
        return campoRSP2;
    }


    /**
     * Sets the campoRSP2 value for this IwsConsultaDTO.
     * 
     * @param campoRSP2
     */
    public void setCampoRSP2(java.lang.String campoRSP2) {
        this.campoRSP2 = campoRSP2;
    }


    /**
     * Gets the campoRSP3 value for this IwsConsultaDTO.
     * 
     * @return campoRSP3
     */
    public java.lang.String getCampoRSP3() {
        return campoRSP3;
    }


    /**
     * Sets the campoRSP3 value for this IwsConsultaDTO.
     * 
     * @param campoRSP3
     */
    public void setCampoRSP3(java.lang.String campoRSP3) {
        this.campoRSP3 = campoRSP3;
    }


    /**
     * Gets the campoRSP4 value for this IwsConsultaDTO.
     * 
     * @return campoRSP4
     */
    public java.lang.String getCampoRSP4() {
        return campoRSP4;
    }


    /**
     * Sets the campoRSP4 value for this IwsConsultaDTO.
     * 
     * @param campoRSP4
     */
    public void setCampoRSP4(java.lang.String campoRSP4) {
        this.campoRSP4 = campoRSP4;
    }


    /**
     * Gets the campoRSP5 value for this IwsConsultaDTO.
     * 
     * @return campoRSP5
     */
    public java.lang.String getCampoRSP5() {
        return campoRSP5;
    }


    /**
     * Sets the campoRSP5 value for this IwsConsultaDTO.
     * 
     * @param campoRSP5
     */
    public void setCampoRSP5(java.lang.String campoRSP5) {
        this.campoRSP5 = campoRSP5;
    }


    /**
     * Gets the campoRSP6 value for this IwsConsultaDTO.
     * 
     * @return campoRSP6
     */
    public java.lang.String getCampoRSP6() {
        return campoRSP6;
    }


    /**
     * Sets the campoRSP6 value for this IwsConsultaDTO.
     * 
     * @param campoRSP6
     */
    public void setCampoRSP6(java.lang.String campoRSP6) {
        this.campoRSP6 = campoRSP6;
    }


    /**
     * Gets the campoRSP7 value for this IwsConsultaDTO.
     * 
     * @return campoRSP7
     */
    public java.lang.String getCampoRSP7() {
        return campoRSP7;
    }


    /**
     * Sets the campoRSP7 value for this IwsConsultaDTO.
     * 
     * @param campoRSP7
     */
    public void setCampoRSP7(java.lang.String campoRSP7) {
        this.campoRSP7 = campoRSP7;
    }


    /**
     * Gets the campoRSP8 value for this IwsConsultaDTO.
     * 
     * @return campoRSP8
     */
    public java.lang.String getCampoRSP8() {
        return campoRSP8;
    }


    /**
     * Sets the campoRSP8 value for this IwsConsultaDTO.
     * 
     * @param campoRSP8
     */
    public void setCampoRSP8(java.lang.String campoRSP8) {
        this.campoRSP8 = campoRSP8;
    }


    /**
     * Gets the resposta value for this IwsConsultaDTO.
     * 
     * @return resposta
     */
    public boolean isResposta() {
        return resposta;
    }


    /**
     * Sets the resposta value for this IwsConsultaDTO.
     * 
     * @param resposta
     */
    public void setResposta(boolean resposta) {
        this.resposta = resposta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IwsConsultaDTO)) return false;
        IwsConsultaDTO other = (IwsConsultaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.campoRSP1==null && other.getCampoRSP1()==null) || 
             (this.campoRSP1!=null &&
              this.campoRSP1.equals(other.getCampoRSP1()))) &&
            ((this.campoRSP2==null && other.getCampoRSP2()==null) || 
             (this.campoRSP2!=null &&
              this.campoRSP2.equals(other.getCampoRSP2()))) &&
            ((this.campoRSP3==null && other.getCampoRSP3()==null) || 
             (this.campoRSP3!=null &&
              this.campoRSP3.equals(other.getCampoRSP3()))) &&
            ((this.campoRSP4==null && other.getCampoRSP4()==null) || 
             (this.campoRSP4!=null &&
              this.campoRSP4.equals(other.getCampoRSP4()))) &&
            ((this.campoRSP5==null && other.getCampoRSP5()==null) || 
             (this.campoRSP5!=null &&
              this.campoRSP5.equals(other.getCampoRSP5()))) &&
            ((this.campoRSP6==null && other.getCampoRSP6()==null) || 
             (this.campoRSP6!=null &&
              this.campoRSP6.equals(other.getCampoRSP6()))) &&
            ((this.campoRSP7==null && other.getCampoRSP7()==null) || 
             (this.campoRSP7!=null &&
              this.campoRSP7.equals(other.getCampoRSP7()))) &&
            ((this.campoRSP8==null && other.getCampoRSP8()==null) || 
             (this.campoRSP8!=null &&
              this.campoRSP8.equals(other.getCampoRSP8()))) &&
            this.resposta == other.isResposta();
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
        if (getCampoRSP1() != null) {
            _hashCode += getCampoRSP1().hashCode();
        }
        if (getCampoRSP2() != null) {
            _hashCode += getCampoRSP2().hashCode();
        }
        if (getCampoRSP3() != null) {
            _hashCode += getCampoRSP3().hashCode();
        }
        if (getCampoRSP4() != null) {
            _hashCode += getCampoRSP4().hashCode();
        }
        if (getCampoRSP5() != null) {
            _hashCode += getCampoRSP5().hashCode();
        }
        if (getCampoRSP6() != null) {
            _hashCode += getCampoRSP6().hashCode();
        }
        if (getCampoRSP7() != null) {
            _hashCode += getCampoRSP7().hashCode();
        }
        if (getCampoRSP8() != null) {
            _hashCode += getCampoRSP8().hashCode();
        }
        _hashCode += (isResposta() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IwsConsultaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "iwsConsultaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campoRSP1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "campoRSP1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campoRSP2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "campoRSP2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campoRSP3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "campoRSP3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campoRSP4");
        elemField.setXmlName(new javax.xml.namespace.QName("", "campoRSP4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campoRSP5");
        elemField.setXmlName(new javax.xml.namespace.QName("", "campoRSP5"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campoRSP6");
        elemField.setXmlName(new javax.xml.namespace.QName("", "campoRSP6"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campoRSP7");
        elemField.setXmlName(new javax.xml.namespace.QName("", "campoRSP7"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campoRSP8");
        elemField.setXmlName(new javax.xml.namespace.QName("", "campoRSP8"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resposta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resposta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
