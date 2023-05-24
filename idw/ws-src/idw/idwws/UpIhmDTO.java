/**
 * UpIhmDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class UpIhmDTO  implements java.io.Serializable {
    private java.util.Calendar dthrCadastro;

    private java.lang.Integer idUpIhm;

    private idw.idwws.IhmDTO ihm;

    public UpIhmDTO() {
    }

    public UpIhmDTO(
           java.util.Calendar dthrCadastro,
           java.lang.Integer idUpIhm,
           idw.idwws.IhmDTO ihm) {
           this.dthrCadastro = dthrCadastro;
           this.idUpIhm = idUpIhm;
           this.ihm = ihm;
    }


    /**
     * Gets the dthrCadastro value for this UpIhmDTO.
     * 
     * @return dthrCadastro
     */
    public java.util.Calendar getDthrCadastro() {
        return dthrCadastro;
    }


    /**
     * Sets the dthrCadastro value for this UpIhmDTO.
     * 
     * @param dthrCadastro
     */
    public void setDthrCadastro(java.util.Calendar dthrCadastro) {
        this.dthrCadastro = dthrCadastro;
    }


    /**
     * Gets the idUpIhm value for this UpIhmDTO.
     * 
     * @return idUpIhm
     */
    public java.lang.Integer getIdUpIhm() {
        return idUpIhm;
    }


    /**
     * Sets the idUpIhm value for this UpIhmDTO.
     * 
     * @param idUpIhm
     */
    public void setIdUpIhm(java.lang.Integer idUpIhm) {
        this.idUpIhm = idUpIhm;
    }


    /**
     * Gets the ihm value for this UpIhmDTO.
     * 
     * @return ihm
     */
    public idw.idwws.IhmDTO getIhm() {
        return ihm;
    }


    /**
     * Sets the ihm value for this UpIhmDTO.
     * 
     * @param ihm
     */
    public void setIhm(idw.idwws.IhmDTO ihm) {
        this.ihm = ihm;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpIhmDTO)) return false;
        UpIhmDTO other = (UpIhmDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrCadastro==null && other.getDthrCadastro()==null) || 
             (this.dthrCadastro!=null &&
              this.dthrCadastro.equals(other.getDthrCadastro()))) &&
            ((this.idUpIhm==null && other.getIdUpIhm()==null) || 
             (this.idUpIhm!=null &&
              this.idUpIhm.equals(other.getIdUpIhm()))) &&
            ((this.ihm==null && other.getIhm()==null) || 
             (this.ihm!=null &&
              this.ihm.equals(other.getIhm())));
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
        if (getDthrCadastro() != null) {
            _hashCode += getDthrCadastro().hashCode();
        }
        if (getIdUpIhm() != null) {
            _hashCode += getIdUpIhm().hashCode();
        }
        if (getIhm() != null) {
            _hashCode += getIhm().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpIhmDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "upIhmDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrCadastro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrCadastro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUpIhm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUpIhm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ihm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ihm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ihmDTO"));
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
