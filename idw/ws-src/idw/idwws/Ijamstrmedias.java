/**
 * Ijamstrmedias.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijamstrmedias  implements java.io.Serializable {
    private idw.idwws.IjamstrmediasId id;

    private idw.idwws.Ijamostragem ijamostragemByIdamostragem;

    private idw.idwws.Ijamostragem ijamostragemByIdamstrmedia;

    public Ijamstrmedias() {
    }

    public Ijamstrmedias(
           idw.idwws.IjamstrmediasId id,
           idw.idwws.Ijamostragem ijamostragemByIdamostragem,
           idw.idwws.Ijamostragem ijamostragemByIdamstrmedia) {
           this.id = id;
           this.ijamostragemByIdamostragem = ijamostragemByIdamostragem;
           this.ijamostragemByIdamstrmedia = ijamostragemByIdamstrmedia;
    }


    /**
     * Gets the id value for this Ijamstrmedias.
     * 
     * @return id
     */
    public idw.idwws.IjamstrmediasId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijamstrmedias.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjamstrmediasId id) {
        this.id = id;
    }


    /**
     * Gets the ijamostragemByIdamostragem value for this Ijamstrmedias.
     * 
     * @return ijamostragemByIdamostragem
     */
    public idw.idwws.Ijamostragem getIjamostragemByIdamostragem() {
        return ijamostragemByIdamostragem;
    }


    /**
     * Sets the ijamostragemByIdamostragem value for this Ijamstrmedias.
     * 
     * @param ijamostragemByIdamostragem
     */
    public void setIjamostragemByIdamostragem(idw.idwws.Ijamostragem ijamostragemByIdamostragem) {
        this.ijamostragemByIdamostragem = ijamostragemByIdamostragem;
    }


    /**
     * Gets the ijamostragemByIdamstrmedia value for this Ijamstrmedias.
     * 
     * @return ijamostragemByIdamstrmedia
     */
    public idw.idwws.Ijamostragem getIjamostragemByIdamstrmedia() {
        return ijamostragemByIdamstrmedia;
    }


    /**
     * Sets the ijamostragemByIdamstrmedia value for this Ijamstrmedias.
     * 
     * @param ijamostragemByIdamstrmedia
     */
    public void setIjamostragemByIdamstrmedia(idw.idwws.Ijamostragem ijamostragemByIdamstrmedia) {
        this.ijamostragemByIdamstrmedia = ijamostragemByIdamstrmedia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijamstrmedias)) return false;
        Ijamstrmedias other = (Ijamstrmedias) obj;
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
            ((this.ijamostragemByIdamostragem==null && other.getIjamostragemByIdamostragem()==null) || 
             (this.ijamostragemByIdamostragem!=null &&
              this.ijamostragemByIdamostragem.equals(other.getIjamostragemByIdamostragem()))) &&
            ((this.ijamostragemByIdamstrmedia==null && other.getIjamostragemByIdamstrmedia()==null) || 
             (this.ijamostragemByIdamstrmedia!=null &&
              this.ijamostragemByIdamstrmedia.equals(other.getIjamostragemByIdamstrmedia())));
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
        if (getIjamostragemByIdamostragem() != null) {
            _hashCode += getIjamostragemByIdamostragem().hashCode();
        }
        if (getIjamostragemByIdamstrmedia() != null) {
            _hashCode += getIjamostragemByIdamstrmedia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijamstrmedias.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamstrmedias"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamstrmediasId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijamostragemByIdamostragem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijamostragemByIdamostragem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamostragem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijamostragemByIdamstrmedia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijamostragemByIdamstrmedia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamostragem"));
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
