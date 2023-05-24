/**
 * Ijoppmedioprod.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijoppmedioprod  implements java.io.Serializable {
    private idw.idwws.IjoppmedioprodId id;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijtbpro ijtbpro;

    private double pesolidoacum;

    private double qtpesoslidos;

    public Ijoppmedioprod() {
    }

    public Ijoppmedioprod(
           idw.idwws.IjoppmedioprodId id,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijtbpro ijtbpro,
           double pesolidoacum,
           double qtpesoslidos) {
           this.id = id;
           this.ijop = ijop;
           this.ijtbpro = ijtbpro;
           this.pesolidoacum = pesolidoacum;
           this.qtpesoslidos = qtpesoslidos;
    }


    /**
     * Gets the id value for this Ijoppmedioprod.
     * 
     * @return id
     */
    public idw.idwws.IjoppmedioprodId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijoppmedioprod.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjoppmedioprodId id) {
        this.id = id;
    }


    /**
     * Gets the ijop value for this Ijoppmedioprod.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijoppmedioprod.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijtbpro value for this Ijoppmedioprod.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijoppmedioprod.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the pesolidoacum value for this Ijoppmedioprod.
     * 
     * @return pesolidoacum
     */
    public double getPesolidoacum() {
        return pesolidoacum;
    }


    /**
     * Sets the pesolidoacum value for this Ijoppmedioprod.
     * 
     * @param pesolidoacum
     */
    public void setPesolidoacum(double pesolidoacum) {
        this.pesolidoacum = pesolidoacum;
    }


    /**
     * Gets the qtpesoslidos value for this Ijoppmedioprod.
     * 
     * @return qtpesoslidos
     */
    public double getQtpesoslidos() {
        return qtpesoslidos;
    }


    /**
     * Sets the qtpesoslidos value for this Ijoppmedioprod.
     * 
     * @param qtpesoslidos
     */
    public void setQtpesoslidos(double qtpesoslidos) {
        this.qtpesoslidos = qtpesoslidos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijoppmedioprod)) return false;
        Ijoppmedioprod other = (Ijoppmedioprod) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            this.pesolidoacum == other.getPesolidoacum() &&
            this.qtpesoslidos == other.getQtpesoslidos();
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        _hashCode += new Double(getPesolidoacum()).hashCode();
        _hashCode += new Double(getQtpesoslidos()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijoppmedioprod.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoppmedioprod"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoppmedioprodId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pesolidoacum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pesolidoacum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtpesoslidos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtpesoslidos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
