/**
 * Ijficteccel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijficteccel  implements java.io.Serializable {
    private double ciclopadraocel;

    private java.util.Calendar dthrfvalciccel;

    private idw.idwws.IjficteccelId id;

    private idw.idwws.Ijtbcelula ijtbcelula;

    public Ijficteccel() {
    }

    public Ijficteccel(
           double ciclopadraocel,
           java.util.Calendar dthrfvalciccel,
           idw.idwws.IjficteccelId id,
           idw.idwws.Ijtbcelula ijtbcelula) {
           this.ciclopadraocel = ciclopadraocel;
           this.dthrfvalciccel = dthrfvalciccel;
           this.id = id;
           this.ijtbcelula = ijtbcelula;
    }


    /**
     * Gets the ciclopadraocel value for this Ijficteccel.
     * 
     * @return ciclopadraocel
     */
    public double getCiclopadraocel() {
        return ciclopadraocel;
    }


    /**
     * Sets the ciclopadraocel value for this Ijficteccel.
     * 
     * @param ciclopadraocel
     */
    public void setCiclopadraocel(double ciclopadraocel) {
        this.ciclopadraocel = ciclopadraocel;
    }


    /**
     * Gets the dthrfvalciccel value for this Ijficteccel.
     * 
     * @return dthrfvalciccel
     */
    public java.util.Calendar getDthrfvalciccel() {
        return dthrfvalciccel;
    }


    /**
     * Sets the dthrfvalciccel value for this Ijficteccel.
     * 
     * @param dthrfvalciccel
     */
    public void setDthrfvalciccel(java.util.Calendar dthrfvalciccel) {
        this.dthrfvalciccel = dthrfvalciccel;
    }


    /**
     * Gets the id value for this Ijficteccel.
     * 
     * @return id
     */
    public idw.idwws.IjficteccelId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijficteccel.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjficteccelId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbcelula value for this Ijficteccel.
     * 
     * @return ijtbcelula
     */
    public idw.idwws.Ijtbcelula getIjtbcelula() {
        return ijtbcelula;
    }


    /**
     * Sets the ijtbcelula value for this Ijficteccel.
     * 
     * @param ijtbcelula
     */
    public void setIjtbcelula(idw.idwws.Ijtbcelula ijtbcelula) {
        this.ijtbcelula = ijtbcelula;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijficteccel)) return false;
        Ijficteccel other = (Ijficteccel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ciclopadraocel == other.getCiclopadraocel() &&
            ((this.dthrfvalciccel==null && other.getDthrfvalciccel()==null) || 
             (this.dthrfvalciccel!=null &&
              this.dthrfvalciccel.equals(other.getDthrfvalciccel()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijtbcelula==null && other.getIjtbcelula()==null) || 
             (this.ijtbcelula!=null &&
              this.ijtbcelula.equals(other.getIjtbcelula())));
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
        _hashCode += new Double(getCiclopadraocel()).hashCode();
        if (getDthrfvalciccel() != null) {
            _hashCode += getDthrfvalciccel().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjtbcelula() != null) {
            _hashCode += getIjtbcelula().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijficteccel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijficteccel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ciclopadraocel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ciclopadraocel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfvalciccel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfvalciccel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijficteccelId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbcelula");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbcelula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcelula"));
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
