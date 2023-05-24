/**
 * Ijopversaopro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijopversaopro  implements java.io.Serializable {
    private idw.idwws.IjopversaoproId id;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijversaoproducao ijversaoproducao;

    public Ijopversaopro() {
    }

    public Ijopversaopro(
           idw.idwws.IjopversaoproId id,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijversaoproducao ijversaoproducao) {
           this.id = id;
           this.ijop = ijop;
           this.ijversaoproducao = ijversaoproducao;
    }


    /**
     * Gets the id value for this Ijopversaopro.
     * 
     * @return id
     */
    public idw.idwws.IjopversaoproId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijopversaopro.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjopversaoproId id) {
        this.id = id;
    }


    /**
     * Gets the ijop value for this Ijopversaopro.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijopversaopro.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijversaoproducao value for this Ijopversaopro.
     * 
     * @return ijversaoproducao
     */
    public idw.idwws.Ijversaoproducao getIjversaoproducao() {
        return ijversaoproducao;
    }


    /**
     * Sets the ijversaoproducao value for this Ijopversaopro.
     * 
     * @param ijversaoproducao
     */
    public void setIjversaoproducao(idw.idwws.Ijversaoproducao ijversaoproducao) {
        this.ijversaoproducao = ijversaoproducao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijopversaopro)) return false;
        Ijopversaopro other = (Ijopversaopro) obj;
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
            ((this.ijversaoproducao==null && other.getIjversaoproducao()==null) || 
             (this.ijversaoproducao!=null &&
              this.ijversaoproducao.equals(other.getIjversaoproducao())));
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
        if (getIjversaoproducao() != null) {
            _hashCode += getIjversaoproducao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijopversaopro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopversaopro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopversaoproId"));
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
        elemField.setFieldName("ijversaoproducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijversaoproducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijversaoproducao"));
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
