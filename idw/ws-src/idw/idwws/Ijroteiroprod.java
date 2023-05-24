/**
 * Ijroteiroprod.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijroteiroprod  implements java.io.Serializable {
    private idw.idwws.IjroteiroprodId id;

    private idw.idwws.Ijtboperacoes ijtboperacoes;

    private idw.idwws.Ijtbpro ijtbpro;

    public Ijroteiroprod() {
    }

    public Ijroteiroprod(
           idw.idwws.IjroteiroprodId id,
           idw.idwws.Ijtboperacoes ijtboperacoes,
           idw.idwws.Ijtbpro ijtbpro) {
           this.id = id;
           this.ijtboperacoes = ijtboperacoes;
           this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the id value for this Ijroteiroprod.
     * 
     * @return id
     */
    public idw.idwws.IjroteiroprodId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijroteiroprod.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjroteiroprodId id) {
        this.id = id;
    }


    /**
     * Gets the ijtboperacoes value for this Ijroteiroprod.
     * 
     * @return ijtboperacoes
     */
    public idw.idwws.Ijtboperacoes getIjtboperacoes() {
        return ijtboperacoes;
    }


    /**
     * Sets the ijtboperacoes value for this Ijroteiroprod.
     * 
     * @param ijtboperacoes
     */
    public void setIjtboperacoes(idw.idwws.Ijtboperacoes ijtboperacoes) {
        this.ijtboperacoes = ijtboperacoes;
    }


    /**
     * Gets the ijtbpro value for this Ijroteiroprod.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijroteiroprod.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijroteiroprod)) return false;
        Ijroteiroprod other = (Ijroteiroprod) obj;
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
            ((this.ijtboperacoes==null && other.getIjtboperacoes()==null) || 
             (this.ijtboperacoes!=null &&
              this.ijtboperacoes.equals(other.getIjtboperacoes()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro())));
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
        if (getIjtboperacoes() != null) {
            _hashCode += getIjtboperacoes().hashCode();
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijroteiroprod.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijroteiroprod"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijroteiroprodId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtboperacoes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtboperacoes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtboperacoes"));
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
