/**
 * Ijcgfandonsinc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijcgfandonsinc  implements java.io.Serializable {
    private idw.idwws.IjcgfandonsincId id;

    private idw.idwws.Ijcfgandon ijcfgandon;

    private idw.idwws.Ijtbmestres ijtbmestres;

    private org.apache.axis.types.UnsignedShort stsincronismo;

    public Ijcgfandonsinc() {
    }

    public Ijcgfandonsinc(
           idw.idwws.IjcgfandonsincId id,
           idw.idwws.Ijcfgandon ijcfgandon,
           idw.idwws.Ijtbmestres ijtbmestres,
           org.apache.axis.types.UnsignedShort stsincronismo) {
           this.id = id;
           this.ijcfgandon = ijcfgandon;
           this.ijtbmestres = ijtbmestres;
           this.stsincronismo = stsincronismo;
    }


    /**
     * Gets the id value for this Ijcgfandonsinc.
     * 
     * @return id
     */
    public idw.idwws.IjcgfandonsincId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijcgfandonsinc.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjcgfandonsincId id) {
        this.id = id;
    }


    /**
     * Gets the ijcfgandon value for this Ijcgfandonsinc.
     * 
     * @return ijcfgandon
     */
    public idw.idwws.Ijcfgandon getIjcfgandon() {
        return ijcfgandon;
    }


    /**
     * Sets the ijcfgandon value for this Ijcgfandonsinc.
     * 
     * @param ijcfgandon
     */
    public void setIjcfgandon(idw.idwws.Ijcfgandon ijcfgandon) {
        this.ijcfgandon = ijcfgandon;
    }


    /**
     * Gets the ijtbmestres value for this Ijcgfandonsinc.
     * 
     * @return ijtbmestres
     */
    public idw.idwws.Ijtbmestres getIjtbmestres() {
        return ijtbmestres;
    }


    /**
     * Sets the ijtbmestres value for this Ijcgfandonsinc.
     * 
     * @param ijtbmestres
     */
    public void setIjtbmestres(idw.idwws.Ijtbmestres ijtbmestres) {
        this.ijtbmestres = ijtbmestres;
    }


    /**
     * Gets the stsincronismo value for this Ijcgfandonsinc.
     * 
     * @return stsincronismo
     */
    public org.apache.axis.types.UnsignedShort getStsincronismo() {
        return stsincronismo;
    }


    /**
     * Sets the stsincronismo value for this Ijcgfandonsinc.
     * 
     * @param stsincronismo
     */
    public void setStsincronismo(org.apache.axis.types.UnsignedShort stsincronismo) {
        this.stsincronismo = stsincronismo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijcgfandonsinc)) return false;
        Ijcgfandonsinc other = (Ijcgfandonsinc) obj;
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
            ((this.ijcfgandon==null && other.getIjcfgandon()==null) || 
             (this.ijcfgandon!=null &&
              this.ijcfgandon.equals(other.getIjcfgandon()))) &&
            ((this.ijtbmestres==null && other.getIjtbmestres()==null) || 
             (this.ijtbmestres!=null &&
              this.ijtbmestres.equals(other.getIjtbmestres()))) &&
            ((this.stsincronismo==null && other.getStsincronismo()==null) || 
             (this.stsincronismo!=null &&
              this.stsincronismo.equals(other.getStsincronismo())));
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
        if (getIjcfgandon() != null) {
            _hashCode += getIjcfgandon().hashCode();
        }
        if (getIjtbmestres() != null) {
            _hashCode += getIjtbmestres().hashCode();
        }
        if (getStsincronismo() != null) {
            _hashCode += getStsincronismo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijcgfandonsinc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcgfandonsinc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcgfandonsincId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcfgandon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcfgandon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcfgandon"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmestres");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmestres"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmestres"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stsincronismo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stsincronismo"));
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
