/**
 * Ijmdoalocdet.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijmdoalocdet  implements java.io.Serializable {
    private idw.idwws.IjmdoalocdetId id;

    private idw.idwws.Ijmdoaloc ijmdoaloc;

    private idw.idwws.Ijtbcar ijtbcar;

    private double qtdmdoalocada;

    public Ijmdoalocdet() {
    }

    public Ijmdoalocdet(
           idw.idwws.IjmdoalocdetId id,
           idw.idwws.Ijmdoaloc ijmdoaloc,
           idw.idwws.Ijtbcar ijtbcar,
           double qtdmdoalocada) {
           this.id = id;
           this.ijmdoaloc = ijmdoaloc;
           this.ijtbcar = ijtbcar;
           this.qtdmdoalocada = qtdmdoalocada;
    }


    /**
     * Gets the id value for this Ijmdoalocdet.
     * 
     * @return id
     */
    public idw.idwws.IjmdoalocdetId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijmdoalocdet.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjmdoalocdetId id) {
        this.id = id;
    }


    /**
     * Gets the ijmdoaloc value for this Ijmdoalocdet.
     * 
     * @return ijmdoaloc
     */
    public idw.idwws.Ijmdoaloc getIjmdoaloc() {
        return ijmdoaloc;
    }


    /**
     * Sets the ijmdoaloc value for this Ijmdoalocdet.
     * 
     * @param ijmdoaloc
     */
    public void setIjmdoaloc(idw.idwws.Ijmdoaloc ijmdoaloc) {
        this.ijmdoaloc = ijmdoaloc;
    }


    /**
     * Gets the ijtbcar value for this Ijmdoalocdet.
     * 
     * @return ijtbcar
     */
    public idw.idwws.Ijtbcar getIjtbcar() {
        return ijtbcar;
    }


    /**
     * Sets the ijtbcar value for this Ijmdoalocdet.
     * 
     * @param ijtbcar
     */
    public void setIjtbcar(idw.idwws.Ijtbcar ijtbcar) {
        this.ijtbcar = ijtbcar;
    }


    /**
     * Gets the qtdmdoalocada value for this Ijmdoalocdet.
     * 
     * @return qtdmdoalocada
     */
    public double getQtdmdoalocada() {
        return qtdmdoalocada;
    }


    /**
     * Sets the qtdmdoalocada value for this Ijmdoalocdet.
     * 
     * @param qtdmdoalocada
     */
    public void setQtdmdoalocada(double qtdmdoalocada) {
        this.qtdmdoalocada = qtdmdoalocada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijmdoalocdet)) return false;
        Ijmdoalocdet other = (Ijmdoalocdet) obj;
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
            ((this.ijmdoaloc==null && other.getIjmdoaloc()==null) || 
             (this.ijmdoaloc!=null &&
              this.ijmdoaloc.equals(other.getIjmdoaloc()))) &&
            ((this.ijtbcar==null && other.getIjtbcar()==null) || 
             (this.ijtbcar!=null &&
              this.ijtbcar.equals(other.getIjtbcar()))) &&
            this.qtdmdoalocada == other.getQtdmdoalocada();
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
        if (getIjmdoaloc() != null) {
            _hashCode += getIjmdoaloc().hashCode();
        }
        if (getIjtbcar() != null) {
            _hashCode += getIjtbcar().hashCode();
        }
        _hashCode += new Double(getQtdmdoalocada()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijmdoalocdet.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmdoalocdet"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmdoalocdetId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmdoaloc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmdoaloc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmdoaloc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbcar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbcar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcar"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdmdoalocada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdmdoalocada"));
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
