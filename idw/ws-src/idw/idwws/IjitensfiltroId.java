/**
 * IjitensfiltroId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjitensfiltroId  implements java.io.Serializable {
    private java.lang.String cdfiltroitensmen;

    private java.lang.String cdtipofiltro;

    private java.lang.String itemsel;

    public IjitensfiltroId() {
    }

    public IjitensfiltroId(
           java.lang.String cdfiltroitensmen,
           java.lang.String cdtipofiltro,
           java.lang.String itemsel) {
           this.cdfiltroitensmen = cdfiltroitensmen;
           this.cdtipofiltro = cdtipofiltro;
           this.itemsel = itemsel;
    }


    /**
     * Gets the cdfiltroitensmen value for this IjitensfiltroId.
     * 
     * @return cdfiltroitensmen
     */
    public java.lang.String getCdfiltroitensmen() {
        return cdfiltroitensmen;
    }


    /**
     * Sets the cdfiltroitensmen value for this IjitensfiltroId.
     * 
     * @param cdfiltroitensmen
     */
    public void setCdfiltroitensmen(java.lang.String cdfiltroitensmen) {
        this.cdfiltroitensmen = cdfiltroitensmen;
    }


    /**
     * Gets the cdtipofiltro value for this IjitensfiltroId.
     * 
     * @return cdtipofiltro
     */
    public java.lang.String getCdtipofiltro() {
        return cdtipofiltro;
    }


    /**
     * Sets the cdtipofiltro value for this IjitensfiltroId.
     * 
     * @param cdtipofiltro
     */
    public void setCdtipofiltro(java.lang.String cdtipofiltro) {
        this.cdtipofiltro = cdtipofiltro;
    }


    /**
     * Gets the itemsel value for this IjitensfiltroId.
     * 
     * @return itemsel
     */
    public java.lang.String getItemsel() {
        return itemsel;
    }


    /**
     * Sets the itemsel value for this IjitensfiltroId.
     * 
     * @param itemsel
     */
    public void setItemsel(java.lang.String itemsel) {
        this.itemsel = itemsel;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjitensfiltroId)) return false;
        IjitensfiltroId other = (IjitensfiltroId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdfiltroitensmen==null && other.getCdfiltroitensmen()==null) || 
             (this.cdfiltroitensmen!=null &&
              this.cdfiltroitensmen.equals(other.getCdfiltroitensmen()))) &&
            ((this.cdtipofiltro==null && other.getCdtipofiltro()==null) || 
             (this.cdtipofiltro!=null &&
              this.cdtipofiltro.equals(other.getCdtipofiltro()))) &&
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
        if (getCdfiltroitensmen() != null) {
            _hashCode += getCdfiltroitensmen().hashCode();
        }
        if (getCdtipofiltro() != null) {
            _hashCode += getCdtipofiltro().hashCode();
        }
        if (getItemsel() != null) {
            _hashCode += getItemsel().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjitensfiltroId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijitensfiltroId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdfiltroitensmen");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdfiltroitensmen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtipofiltro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtipofiltro"));
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
