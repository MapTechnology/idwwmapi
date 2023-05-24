/**
 * IjparamitensarqId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjparamitensarqId  implements java.io.Serializable {
    private java.lang.String cdinf;

    private java.lang.String cdparam;

    private java.lang.String cdselecao;

    private java.lang.String cdtipoinf;

    private java.lang.String itemsel;

    public IjparamitensarqId() {
    }

    public IjparamitensarqId(
           java.lang.String cdinf,
           java.lang.String cdparam,
           java.lang.String cdselecao,
           java.lang.String cdtipoinf,
           java.lang.String itemsel) {
           this.cdinf = cdinf;
           this.cdparam = cdparam;
           this.cdselecao = cdselecao;
           this.cdtipoinf = cdtipoinf;
           this.itemsel = itemsel;
    }


    /**
     * Gets the cdinf value for this IjparamitensarqId.
     * 
     * @return cdinf
     */
    public java.lang.String getCdinf() {
        return cdinf;
    }


    /**
     * Sets the cdinf value for this IjparamitensarqId.
     * 
     * @param cdinf
     */
    public void setCdinf(java.lang.String cdinf) {
        this.cdinf = cdinf;
    }


    /**
     * Gets the cdparam value for this IjparamitensarqId.
     * 
     * @return cdparam
     */
    public java.lang.String getCdparam() {
        return cdparam;
    }


    /**
     * Sets the cdparam value for this IjparamitensarqId.
     * 
     * @param cdparam
     */
    public void setCdparam(java.lang.String cdparam) {
        this.cdparam = cdparam;
    }


    /**
     * Gets the cdselecao value for this IjparamitensarqId.
     * 
     * @return cdselecao
     */
    public java.lang.String getCdselecao() {
        return cdselecao;
    }


    /**
     * Sets the cdselecao value for this IjparamitensarqId.
     * 
     * @param cdselecao
     */
    public void setCdselecao(java.lang.String cdselecao) {
        this.cdselecao = cdselecao;
    }


    /**
     * Gets the cdtipoinf value for this IjparamitensarqId.
     * 
     * @return cdtipoinf
     */
    public java.lang.String getCdtipoinf() {
        return cdtipoinf;
    }


    /**
     * Sets the cdtipoinf value for this IjparamitensarqId.
     * 
     * @param cdtipoinf
     */
    public void setCdtipoinf(java.lang.String cdtipoinf) {
        this.cdtipoinf = cdtipoinf;
    }


    /**
     * Gets the itemsel value for this IjparamitensarqId.
     * 
     * @return itemsel
     */
    public java.lang.String getItemsel() {
        return itemsel;
    }


    /**
     * Sets the itemsel value for this IjparamitensarqId.
     * 
     * @param itemsel
     */
    public void setItemsel(java.lang.String itemsel) {
        this.itemsel = itemsel;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjparamitensarqId)) return false;
        IjparamitensarqId other = (IjparamitensarqId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdinf==null && other.getCdinf()==null) || 
             (this.cdinf!=null &&
              this.cdinf.equals(other.getCdinf()))) &&
            ((this.cdparam==null && other.getCdparam()==null) || 
             (this.cdparam!=null &&
              this.cdparam.equals(other.getCdparam()))) &&
            ((this.cdselecao==null && other.getCdselecao()==null) || 
             (this.cdselecao!=null &&
              this.cdselecao.equals(other.getCdselecao()))) &&
            ((this.cdtipoinf==null && other.getCdtipoinf()==null) || 
             (this.cdtipoinf!=null &&
              this.cdtipoinf.equals(other.getCdtipoinf()))) &&
            ((this.itemsel==null && other.getItemsel()==null) || 
             (this.itemsel!=null &&
              this.itemsel.equals(other.getItemsel())));
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
        if (getCdinf() != null) {
            _hashCode += getCdinf().hashCode();
        }
        if (getCdparam() != null) {
            _hashCode += getCdparam().hashCode();
        }
        if (getCdselecao() != null) {
            _hashCode += getCdselecao().hashCode();
        }
        if (getCdtipoinf() != null) {
            _hashCode += getCdtipoinf().hashCode();
        }
        if (getItemsel() != null) {
            _hashCode += getItemsel().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjparamitensarqId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijparamitensarqId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdparam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdparam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdselecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdselecao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtipoinf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtipoinf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itemsel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "itemsel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
