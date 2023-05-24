/**
 * Ijtbale.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbale  implements java.io.Serializable {
    private java.lang.String cdalerta;

    private java.lang.String dsalerta;

    private idw.idwws.Ijalertas[] ijalertases;

    public Ijtbale() {
    }

    public Ijtbale(
           java.lang.String cdalerta,
           java.lang.String dsalerta,
           idw.idwws.Ijalertas[] ijalertases) {
           this.cdalerta = cdalerta;
           this.dsalerta = dsalerta;
           this.ijalertases = ijalertases;
    }


    /**
     * Gets the cdalerta value for this Ijtbale.
     * 
     * @return cdalerta
     */
    public java.lang.String getCdalerta() {
        return cdalerta;
    }


    /**
     * Sets the cdalerta value for this Ijtbale.
     * 
     * @param cdalerta
     */
    public void setCdalerta(java.lang.String cdalerta) {
        this.cdalerta = cdalerta;
    }


    /**
     * Gets the dsalerta value for this Ijtbale.
     * 
     * @return dsalerta
     */
    public java.lang.String getDsalerta() {
        return dsalerta;
    }


    /**
     * Sets the dsalerta value for this Ijtbale.
     * 
     * @param dsalerta
     */
    public void setDsalerta(java.lang.String dsalerta) {
        this.dsalerta = dsalerta;
    }


    /**
     * Gets the ijalertases value for this Ijtbale.
     * 
     * @return ijalertases
     */
    public idw.idwws.Ijalertas[] getIjalertases() {
        return ijalertases;
    }


    /**
     * Sets the ijalertases value for this Ijtbale.
     * 
     * @param ijalertases
     */
    public void setIjalertases(idw.idwws.Ijalertas[] ijalertases) {
        this.ijalertases = ijalertases;
    }

    public idw.idwws.Ijalertas getIjalertases(int i) {
        return this.ijalertases[i];
    }

    public void setIjalertases(int i, idw.idwws.Ijalertas _value) {
        this.ijalertases[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbale)) return false;
        Ijtbale other = (Ijtbale) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdalerta==null && other.getCdalerta()==null) || 
             (this.cdalerta!=null &&
              this.cdalerta.equals(other.getCdalerta()))) &&
            ((this.dsalerta==null && other.getDsalerta()==null) || 
             (this.dsalerta!=null &&
              this.dsalerta.equals(other.getDsalerta()))) &&
            ((this.ijalertases==null && other.getIjalertases()==null) || 
             (this.ijalertases!=null &&
              java.util.Arrays.equals(this.ijalertases, other.getIjalertases())));
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
        if (getCdalerta() != null) {
            _hashCode += getCdalerta().hashCode();
        }
        if (getDsalerta() != null) {
            _hashCode += getDsalerta().hashCode();
        }
        if (getIjalertases() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjalertases());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjalertases(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbale.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbale"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijalertases");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijalertases"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijalertas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
