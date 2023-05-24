/**
 * Ijdeparamol.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijdeparamol  implements java.io.Serializable {
    private java.lang.String cdmoldeauxiliar;

    private idw.idwws.Ijtbmol ijtbmol;

    public Ijdeparamol() {
    }

    public Ijdeparamol(
           java.lang.String cdmoldeauxiliar,
           idw.idwws.Ijtbmol ijtbmol) {
           this.cdmoldeauxiliar = cdmoldeauxiliar;
           this.ijtbmol = ijtbmol;
    }


    /**
     * Gets the cdmoldeauxiliar value for this Ijdeparamol.
     * 
     * @return cdmoldeauxiliar
     */
    public java.lang.String getCdmoldeauxiliar() {
        return cdmoldeauxiliar;
    }


    /**
     * Sets the cdmoldeauxiliar value for this Ijdeparamol.
     * 
     * @param cdmoldeauxiliar
     */
    public void setCdmoldeauxiliar(java.lang.String cdmoldeauxiliar) {
        this.cdmoldeauxiliar = cdmoldeauxiliar;
    }


    /**
     * Gets the ijtbmol value for this Ijdeparamol.
     * 
     * @return ijtbmol
     */
    public idw.idwws.Ijtbmol getIjtbmol() {
        return ijtbmol;
    }


    /**
     * Sets the ijtbmol value for this Ijdeparamol.
     * 
     * @param ijtbmol
     */
    public void setIjtbmol(idw.idwws.Ijtbmol ijtbmol) {
        this.ijtbmol = ijtbmol;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijdeparamol)) return false;
        Ijdeparamol other = (Ijdeparamol) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdmoldeauxiliar==null && other.getCdmoldeauxiliar()==null) || 
             (this.cdmoldeauxiliar!=null &&
              this.cdmoldeauxiliar.equals(other.getCdmoldeauxiliar()))) &&
            ((this.ijtbmol==null && other.getIjtbmol()==null) || 
             (this.ijtbmol!=null &&
              this.ijtbmol.equals(other.getIjtbmol())));
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
        if (getCdmoldeauxiliar() != null) {
            _hashCode += getCdmoldeauxiliar().hashCode();
        }
        if (getIjtbmol() != null) {
            _hashCode += getIjtbmol().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijdeparamol.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdeparamol"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmoldeauxiliar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmoldeauxiliar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmol"));
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
