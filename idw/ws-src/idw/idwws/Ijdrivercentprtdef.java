/**
 * Ijdrivercentprtdef.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijdrivercentprtdef  implements java.io.Serializable {
    private idw.idwws.IjdrivercentprtdefId id;

    private java.lang.String idportacomdef;

    private idw.idwws.Ijtbcentinsp ijtbcentinsp;

    private idw.idwws.Ijtbdrivers ijtbdrivers;

    public Ijdrivercentprtdef() {
    }

    public Ijdrivercentprtdef(
           idw.idwws.IjdrivercentprtdefId id,
           java.lang.String idportacomdef,
           idw.idwws.Ijtbcentinsp ijtbcentinsp,
           idw.idwws.Ijtbdrivers ijtbdrivers) {
           this.id = id;
           this.idportacomdef = idportacomdef;
           this.ijtbcentinsp = ijtbcentinsp;
           this.ijtbdrivers = ijtbdrivers;
    }


    /**
     * Gets the id value for this Ijdrivercentprtdef.
     * 
     * @return id
     */
    public idw.idwws.IjdrivercentprtdefId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijdrivercentprtdef.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjdrivercentprtdefId id) {
        this.id = id;
    }


    /**
     * Gets the idportacomdef value for this Ijdrivercentprtdef.
     * 
     * @return idportacomdef
     */
    public java.lang.String getIdportacomdef() {
        return idportacomdef;
    }


    /**
     * Sets the idportacomdef value for this Ijdrivercentprtdef.
     * 
     * @param idportacomdef
     */
    public void setIdportacomdef(java.lang.String idportacomdef) {
        this.idportacomdef = idportacomdef;
    }


    /**
     * Gets the ijtbcentinsp value for this Ijdrivercentprtdef.
     * 
     * @return ijtbcentinsp
     */
    public idw.idwws.Ijtbcentinsp getIjtbcentinsp() {
        return ijtbcentinsp;
    }


    /**
     * Sets the ijtbcentinsp value for this Ijdrivercentprtdef.
     * 
     * @param ijtbcentinsp
     */
    public void setIjtbcentinsp(idw.idwws.Ijtbcentinsp ijtbcentinsp) {
        this.ijtbcentinsp = ijtbcentinsp;
    }


    /**
     * Gets the ijtbdrivers value for this Ijdrivercentprtdef.
     * 
     * @return ijtbdrivers
     */
    public idw.idwws.Ijtbdrivers getIjtbdrivers() {
        return ijtbdrivers;
    }


    /**
     * Sets the ijtbdrivers value for this Ijdrivercentprtdef.
     * 
     * @param ijtbdrivers
     */
    public void setIjtbdrivers(idw.idwws.Ijtbdrivers ijtbdrivers) {
        this.ijtbdrivers = ijtbdrivers;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijdrivercentprtdef)) return false;
        Ijdrivercentprtdef other = (Ijdrivercentprtdef) obj;
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
            ((this.idportacomdef==null && other.getIdportacomdef()==null) || 
             (this.idportacomdef!=null &&
              this.idportacomdef.equals(other.getIdportacomdef()))) &&
            ((this.ijtbcentinsp==null && other.getIjtbcentinsp()==null) || 
             (this.ijtbcentinsp!=null &&
              this.ijtbcentinsp.equals(other.getIjtbcentinsp()))) &&
            ((this.ijtbdrivers==null && other.getIjtbdrivers()==null) || 
             (this.ijtbdrivers!=null &&
              this.ijtbdrivers.equals(other.getIjtbdrivers())));
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
        if (getIdportacomdef() != null) {
            _hashCode += getIdportacomdef().hashCode();
        }
        if (getIjtbcentinsp() != null) {
            _hashCode += getIjtbcentinsp().hashCode();
        }
        if (getIjtbdrivers() != null) {
            _hashCode += getIjtbdrivers().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijdrivercentprtdef.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdrivercentprtdef"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdrivercentprtdefId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idportacomdef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idportacomdef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbcentinsp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbcentinsp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcentinsp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbdrivers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbdrivers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbdrivers"));
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
