/**
 * Ijdrvcntexecprtdef.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijdrvcntexecprtdef  implements java.io.Serializable {
    private idw.idwws.IjdrvcntexecprtdefId id;

    private java.lang.String idportacomdef;

    private idw.idwws.Ijparaminspec ijparaminspec;

    private idw.idwws.Ijprodxgrpparam ijprodxgrpparam;

    private idw.idwws.Ijtbcentinsp ijtbcentinsp;

    private idw.idwws.Ijtbdrivers ijtbdrivers;

    public Ijdrvcntexecprtdef() {
    }

    public Ijdrvcntexecprtdef(
           idw.idwws.IjdrvcntexecprtdefId id,
           java.lang.String idportacomdef,
           idw.idwws.Ijparaminspec ijparaminspec,
           idw.idwws.Ijprodxgrpparam ijprodxgrpparam,
           idw.idwws.Ijtbcentinsp ijtbcentinsp,
           idw.idwws.Ijtbdrivers ijtbdrivers) {
           this.id = id;
           this.idportacomdef = idportacomdef;
           this.ijparaminspec = ijparaminspec;
           this.ijprodxgrpparam = ijprodxgrpparam;
           this.ijtbcentinsp = ijtbcentinsp;
           this.ijtbdrivers = ijtbdrivers;
    }


    /**
     * Gets the id value for this Ijdrvcntexecprtdef.
     * 
     * @return id
     */
    public idw.idwws.IjdrvcntexecprtdefId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijdrvcntexecprtdef.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjdrvcntexecprtdefId id) {
        this.id = id;
    }


    /**
     * Gets the idportacomdef value for this Ijdrvcntexecprtdef.
     * 
     * @return idportacomdef
     */
    public java.lang.String getIdportacomdef() {
        return idportacomdef;
    }


    /**
     * Sets the idportacomdef value for this Ijdrvcntexecprtdef.
     * 
     * @param idportacomdef
     */
    public void setIdportacomdef(java.lang.String idportacomdef) {
        this.idportacomdef = idportacomdef;
    }


    /**
     * Gets the ijparaminspec value for this Ijdrvcntexecprtdef.
     * 
     * @return ijparaminspec
     */
    public idw.idwws.Ijparaminspec getIjparaminspec() {
        return ijparaminspec;
    }


    /**
     * Sets the ijparaminspec value for this Ijdrvcntexecprtdef.
     * 
     * @param ijparaminspec
     */
    public void setIjparaminspec(idw.idwws.Ijparaminspec ijparaminspec) {
        this.ijparaminspec = ijparaminspec;
    }


    /**
     * Gets the ijprodxgrpparam value for this Ijdrvcntexecprtdef.
     * 
     * @return ijprodxgrpparam
     */
    public idw.idwws.Ijprodxgrpparam getIjprodxgrpparam() {
        return ijprodxgrpparam;
    }


    /**
     * Sets the ijprodxgrpparam value for this Ijdrvcntexecprtdef.
     * 
     * @param ijprodxgrpparam
     */
    public void setIjprodxgrpparam(idw.idwws.Ijprodxgrpparam ijprodxgrpparam) {
        this.ijprodxgrpparam = ijprodxgrpparam;
    }


    /**
     * Gets the ijtbcentinsp value for this Ijdrvcntexecprtdef.
     * 
     * @return ijtbcentinsp
     */
    public idw.idwws.Ijtbcentinsp getIjtbcentinsp() {
        return ijtbcentinsp;
    }


    /**
     * Sets the ijtbcentinsp value for this Ijdrvcntexecprtdef.
     * 
     * @param ijtbcentinsp
     */
    public void setIjtbcentinsp(idw.idwws.Ijtbcentinsp ijtbcentinsp) {
        this.ijtbcentinsp = ijtbcentinsp;
    }


    /**
     * Gets the ijtbdrivers value for this Ijdrvcntexecprtdef.
     * 
     * @return ijtbdrivers
     */
    public idw.idwws.Ijtbdrivers getIjtbdrivers() {
        return ijtbdrivers;
    }


    /**
     * Sets the ijtbdrivers value for this Ijdrvcntexecprtdef.
     * 
     * @param ijtbdrivers
     */
    public void setIjtbdrivers(idw.idwws.Ijtbdrivers ijtbdrivers) {
        this.ijtbdrivers = ijtbdrivers;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijdrvcntexecprtdef)) return false;
        Ijdrvcntexecprtdef other = (Ijdrvcntexecprtdef) obj;
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
            ((this.ijparaminspec==null && other.getIjparaminspec()==null) || 
             (this.ijparaminspec!=null &&
              this.ijparaminspec.equals(other.getIjparaminspec()))) &&
            ((this.ijprodxgrpparam==null && other.getIjprodxgrpparam()==null) || 
             (this.ijprodxgrpparam!=null &&
              this.ijprodxgrpparam.equals(other.getIjprodxgrpparam()))) &&
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
        if (getIjparaminspec() != null) {
            _hashCode += getIjparaminspec().hashCode();
        }
        if (getIjprodxgrpparam() != null) {
            _hashCode += getIjprodxgrpparam().hashCode();
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
        new org.apache.axis.description.TypeDesc(Ijdrvcntexecprtdef.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdrvcntexecprtdef"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdrvcntexecprtdefId"));
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
        elemField.setFieldName("ijparaminspec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijparaminspec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijparaminspec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijprodxgrpparam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijprodxgrpparam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprodxgrpparam"));
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
