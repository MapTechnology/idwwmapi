/**
 * Ijiniopinj.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijiniopinj  implements java.io.Serializable {
    private java.util.Calendar dthrireal;

    private idw.idwws.IjiniopinjId id;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijtbinj ijtbinj;

    public Ijiniopinj() {
    }

    public Ijiniopinj(
           java.util.Calendar dthrireal,
           idw.idwws.IjiniopinjId id,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijtbinj ijtbinj) {
           this.dthrireal = dthrireal;
           this.id = id;
           this.ijop = ijop;
           this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the dthrireal value for this Ijiniopinj.
     * 
     * @return dthrireal
     */
    public java.util.Calendar getDthrireal() {
        return dthrireal;
    }


    /**
     * Sets the dthrireal value for this Ijiniopinj.
     * 
     * @param dthrireal
     */
    public void setDthrireal(java.util.Calendar dthrireal) {
        this.dthrireal = dthrireal;
    }


    /**
     * Gets the id value for this Ijiniopinj.
     * 
     * @return id
     */
    public idw.idwws.IjiniopinjId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijiniopinj.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjiniopinjId id) {
        this.id = id;
    }


    /**
     * Gets the ijop value for this Ijiniopinj.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijiniopinj.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijtbinj value for this Ijiniopinj.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijiniopinj.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijiniopinj)) return false;
        Ijiniopinj other = (Ijiniopinj) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrireal==null && other.getDthrireal()==null) || 
             (this.dthrireal!=null &&
              this.dthrireal.equals(other.getDthrireal()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj())));
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
        if (getDthrireal() != null) {
            _hashCode += getDthrireal().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijiniopinj.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijiniopinj"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrireal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrireal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijiniopinjId"));
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
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
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
