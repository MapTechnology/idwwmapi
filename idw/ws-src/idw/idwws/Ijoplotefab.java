/**
 * Ijoplotefab.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijoplotefab  implements java.io.Serializable {
    private idw.idwws.IjoplotefabId id;

    private idw.idwws.Ijop ijop;

    private double qtplanejada;

    public Ijoplotefab() {
    }

    public Ijoplotefab(
           idw.idwws.IjoplotefabId id,
           idw.idwws.Ijop ijop,
           double qtplanejada) {
           this.id = id;
           this.ijop = ijop;
           this.qtplanejada = qtplanejada;
    }


    /**
     * Gets the id value for this Ijoplotefab.
     * 
     * @return id
     */
    public idw.idwws.IjoplotefabId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijoplotefab.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjoplotefabId id) {
        this.id = id;
    }


    /**
     * Gets the ijop value for this Ijoplotefab.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijoplotefab.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the qtplanejada value for this Ijoplotefab.
     * 
     * @return qtplanejada
     */
    public double getQtplanejada() {
        return qtplanejada;
    }


    /**
     * Sets the qtplanejada value for this Ijoplotefab.
     * 
     * @param qtplanejada
     */
    public void setQtplanejada(double qtplanejada) {
        this.qtplanejada = qtplanejada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijoplotefab)) return false;
        Ijoplotefab other = (Ijoplotefab) obj;
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
            this.qtplanejada == other.getQtplanejada();
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
        _hashCode += new Double(getQtplanejada()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijoplotefab.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoplotefab"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoplotefabId"));
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
        elemField.setFieldName("qtplanejada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtplanejada"));
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
