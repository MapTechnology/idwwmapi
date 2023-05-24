/**
 * Ijopnipponinsumo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijopnipponinsumo  implements java.io.Serializable {
    private idw.idwws.IjopnipponinsumoId id;

    private idw.idwws.Ijopprodutos ijopprodutos;

    private idw.idwws.Ijtbmprima ijtbmprima;

    public Ijopnipponinsumo() {
    }

    public Ijopnipponinsumo(
           idw.idwws.IjopnipponinsumoId id,
           idw.idwws.Ijopprodutos ijopprodutos,
           idw.idwws.Ijtbmprima ijtbmprima) {
           this.id = id;
           this.ijopprodutos = ijopprodutos;
           this.ijtbmprima = ijtbmprima;
    }


    /**
     * Gets the id value for this Ijopnipponinsumo.
     * 
     * @return id
     */
    public idw.idwws.IjopnipponinsumoId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijopnipponinsumo.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjopnipponinsumoId id) {
        this.id = id;
    }


    /**
     * Gets the ijopprodutos value for this Ijopnipponinsumo.
     * 
     * @return ijopprodutos
     */
    public idw.idwws.Ijopprodutos getIjopprodutos() {
        return ijopprodutos;
    }


    /**
     * Sets the ijopprodutos value for this Ijopnipponinsumo.
     * 
     * @param ijopprodutos
     */
    public void setIjopprodutos(idw.idwws.Ijopprodutos ijopprodutos) {
        this.ijopprodutos = ijopprodutos;
    }


    /**
     * Gets the ijtbmprima value for this Ijopnipponinsumo.
     * 
     * @return ijtbmprima
     */
    public idw.idwws.Ijtbmprima getIjtbmprima() {
        return ijtbmprima;
    }


    /**
     * Sets the ijtbmprima value for this Ijopnipponinsumo.
     * 
     * @param ijtbmprima
     */
    public void setIjtbmprima(idw.idwws.Ijtbmprima ijtbmprima) {
        this.ijtbmprima = ijtbmprima;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijopnipponinsumo)) return false;
        Ijopnipponinsumo other = (Ijopnipponinsumo) obj;
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
            ((this.ijopprodutos==null && other.getIjopprodutos()==null) || 
             (this.ijopprodutos!=null &&
              this.ijopprodutos.equals(other.getIjopprodutos()))) &&
            ((this.ijtbmprima==null && other.getIjtbmprima()==null) || 
             (this.ijtbmprima!=null &&
              this.ijtbmprima.equals(other.getIjtbmprima())));
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
        if (getIjopprodutos() != null) {
            _hashCode += getIjopprodutos().hashCode();
        }
        if (getIjtbmprima() != null) {
            _hashCode += getIjtbmprima().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijopnipponinsumo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopnipponinsumo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopnipponinsumoId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopprodutos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopprodutos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopprodutos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmprima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmprima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmprima"));
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
