/**
 * Ijdriverparam.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijdriverparam  implements java.io.Serializable {
    private java.lang.String dsparametro;

    private idw.idwws.IjdriverparamId id;

    private idw.idwws.Ijtbdrivers ijtbdrivers;

    private java.lang.String parametro;

    public Ijdriverparam() {
    }

    public Ijdriverparam(
           java.lang.String dsparametro,
           idw.idwws.IjdriverparamId id,
           idw.idwws.Ijtbdrivers ijtbdrivers,
           java.lang.String parametro) {
           this.dsparametro = dsparametro;
           this.id = id;
           this.ijtbdrivers = ijtbdrivers;
           this.parametro = parametro;
    }


    /**
     * Gets the dsparametro value for this Ijdriverparam.
     * 
     * @return dsparametro
     */
    public java.lang.String getDsparametro() {
        return dsparametro;
    }


    /**
     * Sets the dsparametro value for this Ijdriverparam.
     * 
     * @param dsparametro
     */
    public void setDsparametro(java.lang.String dsparametro) {
        this.dsparametro = dsparametro;
    }


    /**
     * Gets the id value for this Ijdriverparam.
     * 
     * @return id
     */
    public idw.idwws.IjdriverparamId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijdriverparam.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjdriverparamId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbdrivers value for this Ijdriverparam.
     * 
     * @return ijtbdrivers
     */
    public idw.idwws.Ijtbdrivers getIjtbdrivers() {
        return ijtbdrivers;
    }


    /**
     * Sets the ijtbdrivers value for this Ijdriverparam.
     * 
     * @param ijtbdrivers
     */
    public void setIjtbdrivers(idw.idwws.Ijtbdrivers ijtbdrivers) {
        this.ijtbdrivers = ijtbdrivers;
    }


    /**
     * Gets the parametro value for this Ijdriverparam.
     * 
     * @return parametro
     */
    public java.lang.String getParametro() {
        return parametro;
    }


    /**
     * Sets the parametro value for this Ijdriverparam.
     * 
     * @param parametro
     */
    public void setParametro(java.lang.String parametro) {
        this.parametro = parametro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijdriverparam)) return false;
        Ijdriverparam other = (Ijdriverparam) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dsparametro==null && other.getDsparametro()==null) || 
             (this.dsparametro!=null &&
              this.dsparametro.equals(other.getDsparametro()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijtbdrivers==null && other.getIjtbdrivers()==null) || 
             (this.ijtbdrivers!=null &&
              this.ijtbdrivers.equals(other.getIjtbdrivers()))) &&
            ((this.parametro==null && other.getParametro()==null) || 
             (this.parametro!=null &&
              this.parametro.equals(other.getParametro())));
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
        if (getDsparametro() != null) {
            _hashCode += getDsparametro().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjtbdrivers() != null) {
            _hashCode += getIjtbdrivers().hashCode();
        }
        if (getParametro() != null) {
            _hashCode += getParametro().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijdriverparam.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdriverparam"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsparametro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsparametro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdriverparamId"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parametro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parametro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
