/**
 * Ijfiltroitensmen.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijfiltroitensmen  implements java.io.Serializable {
    private java.lang.String cdfiltroitensmen;

    private idw.idwws.Ijitensfiltro[] ijitensfiltros;

    private idw.idwws.Ijselitensmen ijselitensmen;

    private idw.idwws.Ijtbtipofiltro ijtbtipofiltro;

    private java.lang.String itemsel;

    public Ijfiltroitensmen() {
    }

    public Ijfiltroitensmen(
           java.lang.String cdfiltroitensmen,
           idw.idwws.Ijitensfiltro[] ijitensfiltros,
           idw.idwws.Ijselitensmen ijselitensmen,
           idw.idwws.Ijtbtipofiltro ijtbtipofiltro,
           java.lang.String itemsel) {
           this.cdfiltroitensmen = cdfiltroitensmen;
           this.ijitensfiltros = ijitensfiltros;
           this.ijselitensmen = ijselitensmen;
           this.ijtbtipofiltro = ijtbtipofiltro;
           this.itemsel = itemsel;
    }


    /**
     * Gets the cdfiltroitensmen value for this Ijfiltroitensmen.
     * 
     * @return cdfiltroitensmen
     */
    public java.lang.String getCdfiltroitensmen() {
        return cdfiltroitensmen;
    }


    /**
     * Sets the cdfiltroitensmen value for this Ijfiltroitensmen.
     * 
     * @param cdfiltroitensmen
     */
    public void setCdfiltroitensmen(java.lang.String cdfiltroitensmen) {
        this.cdfiltroitensmen = cdfiltroitensmen;
    }


    /**
     * Gets the ijitensfiltros value for this Ijfiltroitensmen.
     * 
     * @return ijitensfiltros
     */
    public idw.idwws.Ijitensfiltro[] getIjitensfiltros() {
        return ijitensfiltros;
    }


    /**
     * Sets the ijitensfiltros value for this Ijfiltroitensmen.
     * 
     * @param ijitensfiltros
     */
    public void setIjitensfiltros(idw.idwws.Ijitensfiltro[] ijitensfiltros) {
        this.ijitensfiltros = ijitensfiltros;
    }

    public idw.idwws.Ijitensfiltro getIjitensfiltros(int i) {
        return this.ijitensfiltros[i];
    }

    public void setIjitensfiltros(int i, idw.idwws.Ijitensfiltro _value) {
        this.ijitensfiltros[i] = _value;
    }


    /**
     * Gets the ijselitensmen value for this Ijfiltroitensmen.
     * 
     * @return ijselitensmen
     */
    public idw.idwws.Ijselitensmen getIjselitensmen() {
        return ijselitensmen;
    }


    /**
     * Sets the ijselitensmen value for this Ijfiltroitensmen.
     * 
     * @param ijselitensmen
     */
    public void setIjselitensmen(idw.idwws.Ijselitensmen ijselitensmen) {
        this.ijselitensmen = ijselitensmen;
    }


    /**
     * Gets the ijtbtipofiltro value for this Ijfiltroitensmen.
     * 
     * @return ijtbtipofiltro
     */
    public idw.idwws.Ijtbtipofiltro getIjtbtipofiltro() {
        return ijtbtipofiltro;
    }


    /**
     * Sets the ijtbtipofiltro value for this Ijfiltroitensmen.
     * 
     * @param ijtbtipofiltro
     */
    public void setIjtbtipofiltro(idw.idwws.Ijtbtipofiltro ijtbtipofiltro) {
        this.ijtbtipofiltro = ijtbtipofiltro;
    }


    /**
     * Gets the itemsel value for this Ijfiltroitensmen.
     * 
     * @return itemsel
     */
    public java.lang.String getItemsel() {
        return itemsel;
    }


    /**
     * Sets the itemsel value for this Ijfiltroitensmen.
     * 
     * @param itemsel
     */
    public void setItemsel(java.lang.String itemsel) {
        this.itemsel = itemsel;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijfiltroitensmen)) return false;
        Ijfiltroitensmen other = (Ijfiltroitensmen) obj;
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
            ((this.ijitensfiltros==null && other.getIjitensfiltros()==null) || 
             (this.ijitensfiltros!=null &&
              java.util.Arrays.equals(this.ijitensfiltros, other.getIjitensfiltros()))) &&
            ((this.ijselitensmen==null && other.getIjselitensmen()==null) || 
             (this.ijselitensmen!=null &&
              this.ijselitensmen.equals(other.getIjselitensmen()))) &&
            ((this.ijtbtipofiltro==null && other.getIjtbtipofiltro()==null) || 
             (this.ijtbtipofiltro!=null &&
              this.ijtbtipofiltro.equals(other.getIjtbtipofiltro()))) &&
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
        if (getIjitensfiltros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjitensfiltros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjitensfiltros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjselitensmen() != null) {
            _hashCode += getIjselitensmen().hashCode();
        }
        if (getIjtbtipofiltro() != null) {
            _hashCode += getIjtbtipofiltro().hashCode();
        }
        if (getItemsel() != null) {
            _hashCode += getItemsel().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijfiltroitensmen.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfiltroitensmen"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdfiltroitensmen");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdfiltroitensmen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijitensfiltros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijitensfiltros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijitensfiltro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijselitensmen");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijselitensmen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijselitensmen"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbtipofiltro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbtipofiltro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtipofiltro"));
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
