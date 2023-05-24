/**
 * Ijmdoalocop.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijmdoalocop  implements java.io.Serializable {
    private idw.idwws.IjmdoalocopId id;

    private idw.idwws.Ijmdoaloc ijmdoaloc;

    private idw.idwws.Ijop ijop;

    public Ijmdoalocop() {
    }

    public Ijmdoalocop(
           idw.idwws.IjmdoalocopId id,
           idw.idwws.Ijmdoaloc ijmdoaloc,
           idw.idwws.Ijop ijop) {
           this.id = id;
           this.ijmdoaloc = ijmdoaloc;
           this.ijop = ijop;
    }


    /**
     * Gets the id value for this Ijmdoalocop.
     * 
     * @return id
     */
    public idw.idwws.IjmdoalocopId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijmdoalocop.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjmdoalocopId id) {
        this.id = id;
    }


    /**
     * Gets the ijmdoaloc value for this Ijmdoalocop.
     * 
     * @return ijmdoaloc
     */
    public idw.idwws.Ijmdoaloc getIjmdoaloc() {
        return ijmdoaloc;
    }


    /**
     * Sets the ijmdoaloc value for this Ijmdoalocop.
     * 
     * @param ijmdoaloc
     */
    public void setIjmdoaloc(idw.idwws.Ijmdoaloc ijmdoaloc) {
        this.ijmdoaloc = ijmdoaloc;
    }


    /**
     * Gets the ijop value for this Ijmdoalocop.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijmdoalocop.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijmdoalocop)) return false;
        Ijmdoalocop other = (Ijmdoalocop) obj;
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
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop())));
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
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijmdoalocop.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmdoalocop"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmdoalocopId"));
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
        elemField.setFieldName("ijop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
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
