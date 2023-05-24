/**
 * Ijpdcaagndacmp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijpdcaagndacmp  implements java.io.Serializable {
    private java.util.Calendar dtenviorelatorio;

    private idw.idwws.IjpdcaagndacmpId id;

    private idw.idwws.Ijpdcaparticipproj ijpdcaparticipproj;

    public Ijpdcaagndacmp() {
    }

    public Ijpdcaagndacmp(
           java.util.Calendar dtenviorelatorio,
           idw.idwws.IjpdcaagndacmpId id,
           idw.idwws.Ijpdcaparticipproj ijpdcaparticipproj) {
           this.dtenviorelatorio = dtenviorelatorio;
           this.id = id;
           this.ijpdcaparticipproj = ijpdcaparticipproj;
    }


    /**
     * Gets the dtenviorelatorio value for this Ijpdcaagndacmp.
     * 
     * @return dtenviorelatorio
     */
    public java.util.Calendar getDtenviorelatorio() {
        return dtenviorelatorio;
    }


    /**
     * Sets the dtenviorelatorio value for this Ijpdcaagndacmp.
     * 
     * @param dtenviorelatorio
     */
    public void setDtenviorelatorio(java.util.Calendar dtenviorelatorio) {
        this.dtenviorelatorio = dtenviorelatorio;
    }


    /**
     * Gets the id value for this Ijpdcaagndacmp.
     * 
     * @return id
     */
    public idw.idwws.IjpdcaagndacmpId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijpdcaagndacmp.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjpdcaagndacmpId id) {
        this.id = id;
    }


    /**
     * Gets the ijpdcaparticipproj value for this Ijpdcaagndacmp.
     * 
     * @return ijpdcaparticipproj
     */
    public idw.idwws.Ijpdcaparticipproj getIjpdcaparticipproj() {
        return ijpdcaparticipproj;
    }


    /**
     * Sets the ijpdcaparticipproj value for this Ijpdcaagndacmp.
     * 
     * @param ijpdcaparticipproj
     */
    public void setIjpdcaparticipproj(idw.idwws.Ijpdcaparticipproj ijpdcaparticipproj) {
        this.ijpdcaparticipproj = ijpdcaparticipproj;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijpdcaagndacmp)) return false;
        Ijpdcaagndacmp other = (Ijpdcaagndacmp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dtenviorelatorio==null && other.getDtenviorelatorio()==null) || 
             (this.dtenviorelatorio!=null &&
              this.dtenviorelatorio.equals(other.getDtenviorelatorio()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijpdcaparticipproj==null && other.getIjpdcaparticipproj()==null) || 
             (this.ijpdcaparticipproj!=null &&
              this.ijpdcaparticipproj.equals(other.getIjpdcaparticipproj())));
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
        if (getDtenviorelatorio() != null) {
            _hashCode += getDtenviorelatorio().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjpdcaparticipproj() != null) {
            _hashCode += getIjpdcaparticipproj().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijpdcaagndacmp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcaagndacmp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtenviorelatorio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtenviorelatorio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcaagndacmpId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijpdcaparticipproj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijpdcaparticipproj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcaparticipproj"));
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
