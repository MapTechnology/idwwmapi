/**
 * Ijtbusureqtec.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbusureqtec  implements java.io.Serializable {
    private double idregistro;

    private idw.idwws.Ijtbusu ijtbusu;

    private java.math.BigDecimal pedetec1;

    private java.math.BigDecimal pedetec2;

    private java.math.BigDecimal pedetecresp;

    public Ijtbusureqtec() {
    }

    public Ijtbusureqtec(
           double idregistro,
           idw.idwws.Ijtbusu ijtbusu,
           java.math.BigDecimal pedetec1,
           java.math.BigDecimal pedetec2,
           java.math.BigDecimal pedetecresp) {
           this.idregistro = idregistro;
           this.ijtbusu = ijtbusu;
           this.pedetec1 = pedetec1;
           this.pedetec2 = pedetec2;
           this.pedetecresp = pedetecresp;
    }


    /**
     * Gets the idregistro value for this Ijtbusureqtec.
     * 
     * @return idregistro
     */
    public double getIdregistro() {
        return idregistro;
    }


    /**
     * Sets the idregistro value for this Ijtbusureqtec.
     * 
     * @param idregistro
     */
    public void setIdregistro(double idregistro) {
        this.idregistro = idregistro;
    }


    /**
     * Gets the ijtbusu value for this Ijtbusureqtec.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijtbusureqtec.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the pedetec1 value for this Ijtbusureqtec.
     * 
     * @return pedetec1
     */
    public java.math.BigDecimal getPedetec1() {
        return pedetec1;
    }


    /**
     * Sets the pedetec1 value for this Ijtbusureqtec.
     * 
     * @param pedetec1
     */
    public void setPedetec1(java.math.BigDecimal pedetec1) {
        this.pedetec1 = pedetec1;
    }


    /**
     * Gets the pedetec2 value for this Ijtbusureqtec.
     * 
     * @return pedetec2
     */
    public java.math.BigDecimal getPedetec2() {
        return pedetec2;
    }


    /**
     * Sets the pedetec2 value for this Ijtbusureqtec.
     * 
     * @param pedetec2
     */
    public void setPedetec2(java.math.BigDecimal pedetec2) {
        this.pedetec2 = pedetec2;
    }


    /**
     * Gets the pedetecresp value for this Ijtbusureqtec.
     * 
     * @return pedetecresp
     */
    public java.math.BigDecimal getPedetecresp() {
        return pedetecresp;
    }


    /**
     * Sets the pedetecresp value for this Ijtbusureqtec.
     * 
     * @param pedetecresp
     */
    public void setPedetecresp(java.math.BigDecimal pedetecresp) {
        this.pedetecresp = pedetecresp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbusureqtec)) return false;
        Ijtbusureqtec other = (Ijtbusureqtec) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idregistro == other.getIdregistro() &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu()))) &&
            ((this.pedetec1==null && other.getPedetec1()==null) || 
             (this.pedetec1!=null &&
              this.pedetec1.equals(other.getPedetec1()))) &&
            ((this.pedetec2==null && other.getPedetec2()==null) || 
             (this.pedetec2!=null &&
              this.pedetec2.equals(other.getPedetec2()))) &&
            ((this.pedetecresp==null && other.getPedetecresp()==null) || 
             (this.pedetecresp!=null &&
              this.pedetecresp.equals(other.getPedetecresp())));
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
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        if (getPedetec1() != null) {
            _hashCode += getPedetec1().hashCode();
        }
        if (getPedetec2() != null) {
            _hashCode += getPedetec2().hashCode();
        }
        if (getPedetecresp() != null) {
            _hashCode += getPedetecresp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbusureqtec.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusureqtec"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idregistro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idregistro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
        elemField.setFieldName("pedetec1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pedetec1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pedetec2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pedetec2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pedetecresp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pedetecresp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
