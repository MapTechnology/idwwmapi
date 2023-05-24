/**
 * Ijmanutregliber.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijmanutregliber  implements java.io.Serializable {
    private java.util.Calendar dthrliberacao;

    private idw.idwws.IjmanutregliberId id;

    private idw.idwws.Ijmanut ijmanut;

    private idw.idwws.Ijtbusu ijtbusu;

    public Ijmanutregliber() {
    }

    public Ijmanutregliber(
           java.util.Calendar dthrliberacao,
           idw.idwws.IjmanutregliberId id,
           idw.idwws.Ijmanut ijmanut,
           idw.idwws.Ijtbusu ijtbusu) {
           this.dthrliberacao = dthrliberacao;
           this.id = id;
           this.ijmanut = ijmanut;
           this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the dthrliberacao value for this Ijmanutregliber.
     * 
     * @return dthrliberacao
     */
    public java.util.Calendar getDthrliberacao() {
        return dthrliberacao;
    }


    /**
     * Sets the dthrliberacao value for this Ijmanutregliber.
     * 
     * @param dthrliberacao
     */
    public void setDthrliberacao(java.util.Calendar dthrliberacao) {
        this.dthrliberacao = dthrliberacao;
    }


    /**
     * Gets the id value for this Ijmanutregliber.
     * 
     * @return id
     */
    public idw.idwws.IjmanutregliberId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijmanutregliber.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjmanutregliberId id) {
        this.id = id;
    }


    /**
     * Gets the ijmanut value for this Ijmanutregliber.
     * 
     * @return ijmanut
     */
    public idw.idwws.Ijmanut getIjmanut() {
        return ijmanut;
    }


    /**
     * Sets the ijmanut value for this Ijmanutregliber.
     * 
     * @param ijmanut
     */
    public void setIjmanut(idw.idwws.Ijmanut ijmanut) {
        this.ijmanut = ijmanut;
    }


    /**
     * Gets the ijtbusu value for this Ijmanutregliber.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijmanutregliber.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijmanutregliber)) return false;
        Ijmanutregliber other = (Ijmanutregliber) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrliberacao==null && other.getDthrliberacao()==null) || 
             (this.dthrliberacao!=null &&
              this.dthrliberacao.equals(other.getDthrliberacao()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijmanut==null && other.getIjmanut()==null) || 
             (this.ijmanut!=null &&
              this.ijmanut.equals(other.getIjmanut()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu())));
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
        if (getDthrliberacao() != null) {
            _hashCode += getDthrliberacao().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjmanut() != null) {
            _hashCode += getIjmanut().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijmanutregliber.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutregliber"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrliberacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrliberacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutregliberId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanut"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
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
