/**
 * Ijmanutexectec.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijmanutexectec  implements java.io.Serializable {
    private idw.idwws.IjmanutexectecId id;

    private idw.idwws.Ijmanutexec ijmanutexec;

    private idw.idwws.Ijtbusu ijtbusu;

    private double qtdhrs;

    public Ijmanutexectec() {
    }

    public Ijmanutexectec(
           idw.idwws.IjmanutexectecId id,
           idw.idwws.Ijmanutexec ijmanutexec,
           idw.idwws.Ijtbusu ijtbusu,
           double qtdhrs) {
           this.id = id;
           this.ijmanutexec = ijmanutexec;
           this.ijtbusu = ijtbusu;
           this.qtdhrs = qtdhrs;
    }


    /**
     * Gets the id value for this Ijmanutexectec.
     * 
     * @return id
     */
    public idw.idwws.IjmanutexectecId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijmanutexectec.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjmanutexectecId id) {
        this.id = id;
    }


    /**
     * Gets the ijmanutexec value for this Ijmanutexectec.
     * 
     * @return ijmanutexec
     */
    public idw.idwws.Ijmanutexec getIjmanutexec() {
        return ijmanutexec;
    }


    /**
     * Sets the ijmanutexec value for this Ijmanutexectec.
     * 
     * @param ijmanutexec
     */
    public void setIjmanutexec(idw.idwws.Ijmanutexec ijmanutexec) {
        this.ijmanutexec = ijmanutexec;
    }


    /**
     * Gets the ijtbusu value for this Ijmanutexectec.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijmanutexectec.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the qtdhrs value for this Ijmanutexectec.
     * 
     * @return qtdhrs
     */
    public double getQtdhrs() {
        return qtdhrs;
    }


    /**
     * Sets the qtdhrs value for this Ijmanutexectec.
     * 
     * @param qtdhrs
     */
    public void setQtdhrs(double qtdhrs) {
        this.qtdhrs = qtdhrs;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijmanutexectec)) return false;
        Ijmanutexectec other = (Ijmanutexectec) obj;
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
            ((this.ijmanutexec==null && other.getIjmanutexec()==null) || 
             (this.ijmanutexec!=null &&
              this.ijmanutexec.equals(other.getIjmanutexec()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu()))) &&
            this.qtdhrs == other.getQtdhrs();
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
        if (getIjmanutexec() != null) {
            _hashCode += getIjmanutexec().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        _hashCode += new Double(getQtdhrs()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijmanutexectec.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutexectec"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutexectecId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanutexec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanutexec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutexec"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdhrs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdhrs"));
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
