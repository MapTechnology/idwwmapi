/**
 * Ijreaparoprd.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijreaparoprd  implements java.io.Serializable {
    private java.util.Calendar dthrlogoutpar;

    private idw.idwws.IjreaparoprdId id;

    private idw.idwws.Ijreapar ijreapar;

    private idw.idwws.Ijtbusu ijtbusu;

    public Ijreaparoprd() {
    }

    public Ijreaparoprd(
           java.util.Calendar dthrlogoutpar,
           idw.idwws.IjreaparoprdId id,
           idw.idwws.Ijreapar ijreapar,
           idw.idwws.Ijtbusu ijtbusu) {
           this.dthrlogoutpar = dthrlogoutpar;
           this.id = id;
           this.ijreapar = ijreapar;
           this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the dthrlogoutpar value for this Ijreaparoprd.
     * 
     * @return dthrlogoutpar
     */
    public java.util.Calendar getDthrlogoutpar() {
        return dthrlogoutpar;
    }


    /**
     * Sets the dthrlogoutpar value for this Ijreaparoprd.
     * 
     * @param dthrlogoutpar
     */
    public void setDthrlogoutpar(java.util.Calendar dthrlogoutpar) {
        this.dthrlogoutpar = dthrlogoutpar;
    }


    /**
     * Gets the id value for this Ijreaparoprd.
     * 
     * @return id
     */
    public idw.idwws.IjreaparoprdId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijreaparoprd.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjreaparoprdId id) {
        this.id = id;
    }


    /**
     * Gets the ijreapar value for this Ijreaparoprd.
     * 
     * @return ijreapar
     */
    public idw.idwws.Ijreapar getIjreapar() {
        return ijreapar;
    }


    /**
     * Sets the ijreapar value for this Ijreaparoprd.
     * 
     * @param ijreapar
     */
    public void setIjreapar(idw.idwws.Ijreapar ijreapar) {
        this.ijreapar = ijreapar;
    }


    /**
     * Gets the ijtbusu value for this Ijreaparoprd.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijreaparoprd.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijreaparoprd)) return false;
        Ijreaparoprd other = (Ijreaparoprd) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrlogoutpar==null && other.getDthrlogoutpar()==null) || 
             (this.dthrlogoutpar!=null &&
              this.dthrlogoutpar.equals(other.getDthrlogoutpar()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijreapar==null && other.getIjreapar()==null) || 
             (this.ijreapar!=null &&
              this.ijreapar.equals(other.getIjreapar()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu())));
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
        if (getDthrlogoutpar() != null) {
            _hashCode += getDthrlogoutpar().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjreapar() != null) {
            _hashCode += getIjreapar().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijreaparoprd.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreaparoprd"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrlogoutpar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrlogoutpar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreaparoprdId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreapar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreapar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreapar"));
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
