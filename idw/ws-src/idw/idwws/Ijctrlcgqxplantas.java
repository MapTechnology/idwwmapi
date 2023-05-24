/**
 * Ijctrlcgqxplantas.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijctrlcgqxplantas  implements java.io.Serializable {
    private double idregistro;

    private idw.idwws.Ijctrlcgqalt ijctrlcgqalt;

    private idw.idwws.Ijtbclixplantas ijtbclixplantas;

    public Ijctrlcgqxplantas() {
    }

    public Ijctrlcgqxplantas(
           double idregistro,
           idw.idwws.Ijctrlcgqalt ijctrlcgqalt,
           idw.idwws.Ijtbclixplantas ijtbclixplantas) {
           this.idregistro = idregistro;
           this.ijctrlcgqalt = ijctrlcgqalt;
           this.ijtbclixplantas = ijtbclixplantas;
    }


    /**
     * Gets the idregistro value for this Ijctrlcgqxplantas.
     * 
     * @return idregistro
     */
    public double getIdregistro() {
        return idregistro;
    }


    /**
     * Sets the idregistro value for this Ijctrlcgqxplantas.
     * 
     * @param idregistro
     */
    public void setIdregistro(double idregistro) {
        this.idregistro = idregistro;
    }


    /**
     * Gets the ijctrlcgqalt value for this Ijctrlcgqxplantas.
     * 
     * @return ijctrlcgqalt
     */
    public idw.idwws.Ijctrlcgqalt getIjctrlcgqalt() {
        return ijctrlcgqalt;
    }


    /**
     * Sets the ijctrlcgqalt value for this Ijctrlcgqxplantas.
     * 
     * @param ijctrlcgqalt
     */
    public void setIjctrlcgqalt(idw.idwws.Ijctrlcgqalt ijctrlcgqalt) {
        this.ijctrlcgqalt = ijctrlcgqalt;
    }


    /**
     * Gets the ijtbclixplantas value for this Ijctrlcgqxplantas.
     * 
     * @return ijtbclixplantas
     */
    public idw.idwws.Ijtbclixplantas getIjtbclixplantas() {
        return ijtbclixplantas;
    }


    /**
     * Sets the ijtbclixplantas value for this Ijctrlcgqxplantas.
     * 
     * @param ijtbclixplantas
     */
    public void setIjtbclixplantas(idw.idwws.Ijtbclixplantas ijtbclixplantas) {
        this.ijtbclixplantas = ijtbclixplantas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijctrlcgqxplantas)) return false;
        Ijctrlcgqxplantas other = (Ijctrlcgqxplantas) obj;
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
            ((this.ijtbclixplantas==null && other.getIjtbclixplantas()==null) || 
             (this.ijtbclixplantas!=null &&
              this.ijtbclixplantas.equals(other.getIjtbclixplantas())));
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
        if (getIjtbclixplantas() != null) {
            _hashCode += getIjtbclixplantas().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijctrlcgqxplantas.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlcgqxplantas"));
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
        elemField.setFieldName("ijtbclixplantas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbclixplantas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbclixplantas"));
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
