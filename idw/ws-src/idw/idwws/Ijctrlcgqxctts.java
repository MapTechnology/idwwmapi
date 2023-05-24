/**
 * Ijctrlcgqxctts.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijctrlcgqxctts  implements java.io.Serializable {
    private double idregistro;

    private idw.idwws.Ijctrlcgqalt ijctrlcgqalt;

    private idw.idwws.Ijtbclixcttcgq ijtbclixcttcgq;

    public Ijctrlcgqxctts() {
    }

    public Ijctrlcgqxctts(
           double idregistro,
           idw.idwws.Ijctrlcgqalt ijctrlcgqalt,
           idw.idwws.Ijtbclixcttcgq ijtbclixcttcgq) {
           this.idregistro = idregistro;
           this.ijctrlcgqalt = ijctrlcgqalt;
           this.ijtbclixcttcgq = ijtbclixcttcgq;
    }


    /**
     * Gets the idregistro value for this Ijctrlcgqxctts.
     * 
     * @return idregistro
     */
    public double getIdregistro() {
        return idregistro;
    }


    /**
     * Sets the idregistro value for this Ijctrlcgqxctts.
     * 
     * @param idregistro
     */
    public void setIdregistro(double idregistro) {
        this.idregistro = idregistro;
    }


    /**
     * Gets the ijctrlcgqalt value for this Ijctrlcgqxctts.
     * 
     * @return ijctrlcgqalt
     */
    public idw.idwws.Ijctrlcgqalt getIjctrlcgqalt() {
        return ijctrlcgqalt;
    }


    /**
     * Sets the ijctrlcgqalt value for this Ijctrlcgqxctts.
     * 
     * @param ijctrlcgqalt
     */
    public void setIjctrlcgqalt(idw.idwws.Ijctrlcgqalt ijctrlcgqalt) {
        this.ijctrlcgqalt = ijctrlcgqalt;
    }


    /**
     * Gets the ijtbclixcttcgq value for this Ijctrlcgqxctts.
     * 
     * @return ijtbclixcttcgq
     */
    public idw.idwws.Ijtbclixcttcgq getIjtbclixcttcgq() {
        return ijtbclixcttcgq;
    }


    /**
     * Sets the ijtbclixcttcgq value for this Ijctrlcgqxctts.
     * 
     * @param ijtbclixcttcgq
     */
    public void setIjtbclixcttcgq(idw.idwws.Ijtbclixcttcgq ijtbclixcttcgq) {
        this.ijtbclixcttcgq = ijtbclixcttcgq;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijctrlcgqxctts)) return false;
        Ijctrlcgqxctts other = (Ijctrlcgqxctts) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idregistro == other.getIdregistro() &&
            ((this.ijctrlcgqalt==null && other.getIjctrlcgqalt()==null) || 
             (this.ijctrlcgqalt!=null &&
              this.ijctrlcgqalt.equals(other.getIjctrlcgqalt()))) &&
            ((this.ijtbclixcttcgq==null && other.getIjtbclixcttcgq()==null) || 
             (this.ijtbclixcttcgq!=null &&
              this.ijtbclixcttcgq.equals(other.getIjtbclixcttcgq())));
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
        _hashCode += new Double(getIdregistro()).hashCode();
        if (getIjctrlcgqalt() != null) {
            _hashCode += getIjctrlcgqalt().hashCode();
        }
        if (getIjtbclixcttcgq() != null) {
            _hashCode += getIjtbclixcttcgq().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijctrlcgqxctts.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlcgqxctts"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idregistro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idregistro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrlcgqalt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrlcgqalt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlcgqalt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbclixcttcgq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbclixcttcgq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbclixcttcgq"));
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
