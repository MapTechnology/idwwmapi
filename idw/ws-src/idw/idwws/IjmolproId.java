/**
 * IjmolproId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjmolproId  implements java.io.Serializable {
    private java.lang.String cdestrutura;

    private java.lang.String cdmolde;

    private java.lang.String cdproduto;

    private java.util.Calendar dthrival;

    public IjmolproId() {
    }

    public IjmolproId(
           java.lang.String cdestrutura,
           java.lang.String cdmolde,
           java.lang.String cdproduto,
           java.util.Calendar dthrival) {
           this.cdestrutura = cdestrutura;
           this.cdmolde = cdmolde;
           this.cdproduto = cdproduto;
           this.dthrival = dthrival;
    }


    /**
     * Gets the cdestrutura value for this IjmolproId.
     * 
     * @return cdestrutura
     */
    public java.lang.String getCdestrutura() {
        return cdestrutura;
    }


    /**
     * Sets the cdestrutura value for this IjmolproId.
     * 
     * @param cdestrutura
     */
    public void setCdestrutura(java.lang.String cdestrutura) {
        this.cdestrutura = cdestrutura;
    }


    /**
     * Gets the cdmolde value for this IjmolproId.
     * 
     * @return cdmolde
     */
    public java.lang.String getCdmolde() {
        return cdmolde;
    }


    /**
     * Sets the cdmolde value for this IjmolproId.
     * 
     * @param cdmolde
     */
    public void setCdmolde(java.lang.String cdmolde) {
        this.cdmolde = cdmolde;
    }


    /**
     * Gets the cdproduto value for this IjmolproId.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this IjmolproId.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }


    /**
     * Gets the dthrival value for this IjmolproId.
     * 
     * @return dthrival
     */
    public java.util.Calendar getDthrival() {
        return dthrival;
    }


    /**
     * Sets the dthrival value for this IjmolproId.
     * 
     * @param dthrival
     */
    public void setDthrival(java.util.Calendar dthrival) {
        this.dthrival = dthrival;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjmolproId)) return false;
        IjmolproId other = (IjmolproId) obj;
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
            ((this.cdmolde==null && other.getCdmolde()==null) || 
             (this.cdmolde!=null &&
              this.cdmolde.equals(other.getCdmolde()))) &&
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
        if (getCdmolde() != null) {
            _hashCode += getCdmolde().hashCode();
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
        new org.apache.axis.description.TypeDesc(IjmolproId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdestrutura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdestrutura"));
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
