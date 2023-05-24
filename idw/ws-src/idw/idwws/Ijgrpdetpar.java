/**
 * Ijgrpdetpar.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgrpdetpar  implements java.io.Serializable {
    private idw.idwws.IjgrpdetparId id;

    private idw.idwws.Ijgrppar ijgrppar;

    private idw.idwws.Ijtbpar ijtbpar;

    public Ijgrpdetpar() {
    }

    public Ijgrpdetpar(
           idw.idwws.IjgrpdetparId id,
           idw.idwws.Ijgrppar ijgrppar,
           idw.idwws.Ijtbpar ijtbpar) {
           this.id = id;
           this.ijgrppar = ijgrppar;
           this.ijtbpar = ijtbpar;
    }


    /**
     * Gets the id value for this Ijgrpdetpar.
     * 
     * @return id
     */
    public idw.idwws.IjgrpdetparId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijgrpdetpar.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjgrpdetparId id) {
        this.id = id;
    }


    /**
     * Gets the ijgrppar value for this Ijgrpdetpar.
     * 
     * @return ijgrppar
     */
    public idw.idwws.Ijgrppar getIjgrppar() {
        return ijgrppar;
    }


    /**
     * Sets the ijgrppar value for this Ijgrpdetpar.
     * 
     * @param ijgrppar
     */
    public void setIjgrppar(idw.idwws.Ijgrppar ijgrppar) {
        this.ijgrppar = ijgrppar;
    }


    /**
     * Gets the ijtbpar value for this Ijgrpdetpar.
     * 
     * @return ijtbpar
     */
    public idw.idwws.Ijtbpar getIjtbpar() {
        return ijtbpar;
    }


    /**
     * Sets the ijtbpar value for this Ijgrpdetpar.
     * 
     * @param ijtbpar
     */
    public void setIjtbpar(idw.idwws.Ijtbpar ijtbpar) {
        this.ijtbpar = ijtbpar;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgrpdetpar)) return false;
        Ijgrpdetpar other = (Ijgrpdetpar) obj;
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
            ((this.ijgrppar==null && other.getIjgrppar()==null) || 
             (this.ijgrppar!=null &&
              this.ijgrppar.equals(other.getIjgrppar()))) &&
            ((this.ijtbpar==null && other.getIjtbpar()==null) || 
             (this.ijtbpar!=null &&
              this.ijtbpar.equals(other.getIjtbpar())));
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
        if (getIjgrppar() != null) {
            _hashCode += getIjgrppar().hashCode();
        }
        if (getIjtbpar() != null) {
            _hashCode += getIjtbpar().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgrpdetpar.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetpar"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetparId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrppar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrppar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrppar"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpar"));
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
