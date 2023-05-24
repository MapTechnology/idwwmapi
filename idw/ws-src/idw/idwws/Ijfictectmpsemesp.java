/**
 * Ijfictectmpsemesp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijfictectmpsemesp  implements java.io.Serializable {
    private double ciclopadraosemesp;

    private idw.idwws.IjfictectmpsemespId id;

    private idw.idwws.Ijfictec ijfictec;

    public Ijfictectmpsemesp() {
    }

    public Ijfictectmpsemesp(
           double ciclopadraosemesp,
           idw.idwws.IjfictectmpsemespId id,
           idw.idwws.Ijfictec ijfictec) {
           this.ciclopadraosemesp = ciclopadraosemesp;
           this.id = id;
           this.ijfictec = ijfictec;
    }


    /**
     * Gets the ciclopadraosemesp value for this Ijfictectmpsemesp.
     * 
     * @return ciclopadraosemesp
     */
    public double getCiclopadraosemesp() {
        return ciclopadraosemesp;
    }


    /**
     * Sets the ciclopadraosemesp value for this Ijfictectmpsemesp.
     * 
     * @param ciclopadraosemesp
     */
    public void setCiclopadraosemesp(double ciclopadraosemesp) {
        this.ciclopadraosemesp = ciclopadraosemesp;
    }


    /**
     * Gets the id value for this Ijfictectmpsemesp.
     * 
     * @return id
     */
    public idw.idwws.IjfictectmpsemespId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijfictectmpsemesp.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjfictectmpsemespId id) {
        this.id = id;
    }


    /**
     * Gets the ijfictec value for this Ijfictectmpsemesp.
     * 
     * @return ijfictec
     */
    public idw.idwws.Ijfictec getIjfictec() {
        return ijfictec;
    }


    /**
     * Sets the ijfictec value for this Ijfictectmpsemesp.
     * 
     * @param ijfictec
     */
    public void setIjfictec(idw.idwws.Ijfictec ijfictec) {
        this.ijfictec = ijfictec;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijfictectmpsemesp)) return false;
        Ijfictectmpsemesp other = (Ijfictectmpsemesp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ciclopadraosemesp == other.getCiclopadraosemesp() &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijfictec==null && other.getIjfictec()==null) || 
             (this.ijfictec!=null &&
              this.ijfictec.equals(other.getIjfictec())));
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
        _hashCode += new Double(getCiclopadraosemesp()).hashCode();
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjfictec() != null) {
            _hashCode += getIjfictec().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijfictectmpsemesp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfictectmpsemesp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ciclopadraosemesp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ciclopadraosemesp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfictectmpsemespId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijfictec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijfictec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfictec"));
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
