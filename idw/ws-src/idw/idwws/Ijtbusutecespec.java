/**
 * Ijtbusutecespec.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbusutecespec  implements java.io.Serializable {
    private java.lang.String cdusuario;

    private idw.idwws.Ijtbusu ijtbusu;

    private org.apache.axis.types.UnsignedShort master;

    private org.apache.axis.types.UnsignedShort trocadorferramenta;

    public Ijtbusutecespec() {
    }

    public Ijtbusutecespec(
           java.lang.String cdusuario,
           idw.idwws.Ijtbusu ijtbusu,
           org.apache.axis.types.UnsignedShort master,
           org.apache.axis.types.UnsignedShort trocadorferramenta) {
           this.cdusuario = cdusuario;
           this.ijtbusu = ijtbusu;
           this.master = master;
           this.trocadorferramenta = trocadorferramenta;
    }


    /**
     * Gets the cdusuario value for this Ijtbusutecespec.
     * 
     * @return cdusuario
     */
    public java.lang.String getCdusuario() {
        return cdusuario;
    }


    /**
     * Sets the cdusuario value for this Ijtbusutecespec.
     * 
     * @param cdusuario
     */
    public void setCdusuario(java.lang.String cdusuario) {
        this.cdusuario = cdusuario;
    }


    /**
     * Gets the ijtbusu value for this Ijtbusutecespec.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijtbusutecespec.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the master value for this Ijtbusutecespec.
     * 
     * @return master
     */
    public org.apache.axis.types.UnsignedShort getMaster() {
        return master;
    }


    /**
     * Sets the master value for this Ijtbusutecespec.
     * 
     * @param master
     */
    public void setMaster(org.apache.axis.types.UnsignedShort master) {
        this.master = master;
    }


    /**
     * Gets the trocadorferramenta value for this Ijtbusutecespec.
     * 
     * @return trocadorferramenta
     */
    public org.apache.axis.types.UnsignedShort getTrocadorferramenta() {
        return trocadorferramenta;
    }


    /**
     * Sets the trocadorferramenta value for this Ijtbusutecespec.
     * 
     * @param trocadorferramenta
     */
    public void setTrocadorferramenta(org.apache.axis.types.UnsignedShort trocadorferramenta) {
        this.trocadorferramenta = trocadorferramenta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbusutecespec)) return false;
        Ijtbusutecespec other = (Ijtbusutecespec) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdusuario==null && other.getCdusuario()==null) || 
             (this.cdusuario!=null &&
              this.cdusuario.equals(other.getCdusuario()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu()))) &&
            ((this.master==null && other.getMaster()==null) || 
             (this.master!=null &&
              this.master.equals(other.getMaster()))) &&
            ((this.trocadorferramenta==null && other.getTrocadorferramenta()==null) || 
             (this.trocadorferramenta!=null &&
              this.trocadorferramenta.equals(other.getTrocadorferramenta())));
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
        if (getCdusuario() != null) {
            _hashCode += getCdusuario().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        if (getMaster() != null) {
            _hashCode += getMaster().hashCode();
        }
        if (getTrocadorferramenta() != null) {
            _hashCode += getTrocadorferramenta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbusutecespec.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusutecespec"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdusuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdusuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("master");
        elemField.setXmlName(new javax.xml.namespace.QName("", "master"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trocadorferramenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "trocadorferramenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
