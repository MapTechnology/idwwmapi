/**
 * Ijoprotoper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijoprotoper  implements java.io.Serializable {
    private idw.idwws.IjoprotoperId id;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijtboperacoes ijtboperacoes;

    public Ijoprotoper() {
    }

    public Ijoprotoper(
           idw.idwws.IjoprotoperId id,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijtboperacoes ijtboperacoes) {
           this.id = id;
           this.ijop = ijop;
           this.ijtboperacoes = ijtboperacoes;
    }


    /**
     * Gets the id value for this Ijoprotoper.
     * 
     * @return id
     */
    public idw.idwws.IjoprotoperId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijoprotoper.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjoprotoperId id) {
        this.id = id;
    }


    /**
     * Gets the ijop value for this Ijoprotoper.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijoprotoper.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijtboperacoes value for this Ijoprotoper.
     * 
     * @return ijtboperacoes
     */
    public idw.idwws.Ijtboperacoes getIjtboperacoes() {
        return ijtboperacoes;
    }


    /**
     * Sets the ijtboperacoes value for this Ijoprotoper.
     * 
     * @param ijtboperacoes
     */
    public void setIjtboperacoes(idw.idwws.Ijtboperacoes ijtboperacoes) {
        this.ijtboperacoes = ijtboperacoes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijoprotoper)) return false;
        Ijoprotoper other = (Ijoprotoper) obj;
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
            ((this.ijtboperacoes==null && other.getIjtboperacoes()==null) || 
             (this.ijtboperacoes!=null &&
              this.ijtboperacoes.equals(other.getIjtboperacoes())));
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
        if (getIjtboperacoes() != null) {
            _hashCode += getIjtboperacoes().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijoprotoper.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoprotoper"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoprotoperId"));
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
        elemField.setFieldName("ijtboperacoes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtboperacoes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtboperacoes"));
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
