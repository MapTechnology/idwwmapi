/**
 * IjmolproagrupId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjmolproagrupId  implements java.io.Serializable {
    private java.lang.String cdestrutura;

    private java.lang.String cdestruturaagrup;

    private java.lang.String cdmolde;

    private java.lang.String cdmoldeagrup;

    private java.lang.String cdproduto;

    private java.util.Calendar dthrival;

    public IjmolproagrupId() {
    }

    public IjmolproagrupId(
           java.lang.String cdestrutura,
           java.lang.String cdestruturaagrup,
           java.lang.String cdmolde,
           java.lang.String cdmoldeagrup,
           java.lang.String cdproduto,
           java.util.Calendar dthrival) {
           this.cdestrutura = cdestrutura;
           this.cdestruturaagrup = cdestruturaagrup;
           this.cdmolde = cdmolde;
           this.cdmoldeagrup = cdmoldeagrup;
           this.cdproduto = cdproduto;
           this.dthrival = dthrival;
    }


    /**
     * Gets the cdestrutura value for this IjmolproagrupId.
     * 
     * @return cdestrutura
     */
    public java.lang.String getCdestrutura() {
        return cdestrutura;
    }


    /**
     * Sets the cdestrutura value for this IjmolproagrupId.
     * 
     * @param cdestrutura
     */
    public void setCdestrutura(java.lang.String cdestrutura) {
        this.cdestrutura = cdestrutura;
    }


    /**
     * Gets the cdestruturaagrup value for this IjmolproagrupId.
     * 
     * @return cdestruturaagrup
     */
    public java.lang.String getCdestruturaagrup() {
        return cdestruturaagrup;
    }


    /**
     * Sets the cdestruturaagrup value for this IjmolproagrupId.
     * 
     * @param cdestruturaagrup
     */
    public void setCdestruturaagrup(java.lang.String cdestruturaagrup) {
        this.cdestruturaagrup = cdestruturaagrup;
    }


    /**
     * Gets the cdmolde value for this IjmolproagrupId.
     * 
     * @return cdmolde
     */
    public java.lang.String getCdmolde() {
        return cdmolde;
    }


    /**
     * Sets the cdmolde value for this IjmolproagrupId.
     * 
     * @param cdmolde
     */
    public void setCdmolde(java.lang.String cdmolde) {
        this.cdmolde = cdmolde;
    }


    /**
     * Gets the cdmoldeagrup value for this IjmolproagrupId.
     * 
     * @return cdmoldeagrup
     */
    public java.lang.String getCdmoldeagrup() {
        return cdmoldeagrup;
    }


    /**
     * Sets the cdmoldeagrup value for this IjmolproagrupId.
     * 
     * @param cdmoldeagrup
     */
    public void setCdmoldeagrup(java.lang.String cdmoldeagrup) {
        this.cdmoldeagrup = cdmoldeagrup;
    }


    /**
     * Gets the cdproduto value for this IjmolproagrupId.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this IjmolproagrupId.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }


    /**
     * Gets the dthrival value for this IjmolproagrupId.
     * 
     * @return dthrival
     */
    public java.util.Calendar getDthrival() {
        return dthrival;
    }


    /**
     * Sets the dthrival value for this IjmolproagrupId.
     * 
     * @param dthrival
     */
    public void setDthrival(java.util.Calendar dthrival) {
        this.dthrival = dthrival;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjmolproagrupId)) return false;
        IjmolproagrupId other = (IjmolproagrupId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdestrutura==null && other.getCdestrutura()==null) || 
             (this.cdestrutura!=null &&
              this.cdestrutura.equals(other.getCdestrutura()))) &&
            ((this.cdestruturaagrup==null && other.getCdestruturaagrup()==null) || 
             (this.cdestruturaagrup!=null &&
              this.cdestruturaagrup.equals(other.getCdestruturaagrup()))) &&
            ((this.cdmolde==null && other.getCdmolde()==null) || 
             (this.cdmolde!=null &&
              this.cdmolde.equals(other.getCdmolde()))) &&
            ((this.cdmoldeagrup==null && other.getCdmoldeagrup()==null) || 
             (this.cdmoldeagrup!=null &&
              this.cdmoldeagrup.equals(other.getCdmoldeagrup()))) &&
            ((this.cdproduto==null && other.getCdproduto()==null) || 
             (this.cdproduto!=null &&
              this.cdproduto.equals(other.getCdproduto()))) &&
            ((this.dthrival==null && other.getDthrival()==null) || 
             (this.dthrival!=null &&
              this.dthrival.equals(other.getDthrival())));
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
        if (getCdestrutura() != null) {
            _hashCode += getCdestrutura().hashCode();
        }
        if (getCdestruturaagrup() != null) {
            _hashCode += getCdestruturaagrup().hashCode();
        }
        if (getCdmolde() != null) {
            _hashCode += getCdmolde().hashCode();
        }
        if (getCdmoldeagrup() != null) {
            _hashCode += getCdmoldeagrup().hashCode();
        }
        if (getCdproduto() != null) {
            _hashCode += getCdproduto().hashCode();
        }
        if (getDthrival() != null) {
            _hashCode += getDthrival().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjmolproagrupId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproagrupId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdestrutura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdestrutura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdestruturaagrup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdestruturaagrup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmoldeagrup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmoldeagrup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrival");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrival"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
