/**
 * IwsDadosCIPDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IwsDadosCIPDTO  implements java.io.Serializable {
    private java.lang.String cdmoldeantigo;

    private java.util.Calendar dtHrInicio;

    private java.lang.Boolean isCIPPendente;

    private java.lang.Boolean isEmCIP;

    public IwsDadosCIPDTO() {
    }

    public IwsDadosCIPDTO(
           java.lang.String cdmoldeantigo,
           java.util.Calendar dtHrInicio,
           java.lang.Boolean isCIPPendente,
           java.lang.Boolean isEmCIP) {
           this.cdmoldeantigo = cdmoldeantigo;
           this.dtHrInicio = dtHrInicio;
           this.isCIPPendente = isCIPPendente;
           this.isEmCIP = isEmCIP;
    }


    /**
     * Gets the cdmoldeantigo value for this IwsDadosCIPDTO.
     * 
     * @return cdmoldeantigo
     */
    public java.lang.String getCdmoldeantigo() {
        return cdmoldeantigo;
    }


    /**
     * Sets the cdmoldeantigo value for this IwsDadosCIPDTO.
     * 
     * @param cdmoldeantigo
     */
    public void setCdmoldeantigo(java.lang.String cdmoldeantigo) {
        this.cdmoldeantigo = cdmoldeantigo;
    }


    /**
     * Gets the dtHrInicio value for this IwsDadosCIPDTO.
     * 
     * @return dtHrInicio
     */
    public java.util.Calendar getDtHrInicio() {
        return dtHrInicio;
    }


    /**
     * Sets the dtHrInicio value for this IwsDadosCIPDTO.
     * 
     * @param dtHrInicio
     */
    public void setDtHrInicio(java.util.Calendar dtHrInicio) {
        this.dtHrInicio = dtHrInicio;
    }


    /**
     * Gets the isCIPPendente value for this IwsDadosCIPDTO.
     * 
     * @return isCIPPendente
     */
    public java.lang.Boolean getIsCIPPendente() {
        return isCIPPendente;
    }


    /**
     * Sets the isCIPPendente value for this IwsDadosCIPDTO.
     * 
     * @param isCIPPendente
     */
    public void setIsCIPPendente(java.lang.Boolean isCIPPendente) {
        this.isCIPPendente = isCIPPendente;
    }


    /**
     * Gets the isEmCIP value for this IwsDadosCIPDTO.
     * 
     * @return isEmCIP
     */
    public java.lang.Boolean getIsEmCIP() {
        return isEmCIP;
    }


    /**
     * Sets the isEmCIP value for this IwsDadosCIPDTO.
     * 
     * @param isEmCIP
     */
    public void setIsEmCIP(java.lang.Boolean isEmCIP) {
        this.isEmCIP = isEmCIP;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IwsDadosCIPDTO)) return false;
        IwsDadosCIPDTO other = (IwsDadosCIPDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdmoldeantigo==null && other.getCdmoldeantigo()==null) || 
             (this.cdmoldeantigo!=null &&
              this.cdmoldeantigo.equals(other.getCdmoldeantigo()))) &&
            ((this.dtHrInicio==null && other.getDtHrInicio()==null) || 
             (this.dtHrInicio!=null &&
              this.dtHrInicio.equals(other.getDtHrInicio()))) &&
            ((this.isCIPPendente==null && other.getIsCIPPendente()==null) || 
             (this.isCIPPendente!=null &&
              this.isCIPPendente.equals(other.getIsCIPPendente()))) &&
            ((this.isEmCIP==null && other.getIsEmCIP()==null) || 
             (this.isEmCIP!=null &&
              this.isEmCIP.equals(other.getIsEmCIP())));
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
        if (getCdmoldeantigo() != null) {
            _hashCode += getCdmoldeantigo().hashCode();
        }
        if (getDtHrInicio() != null) {
            _hashCode += getDtHrInicio().hashCode();
        }
        if (getIsCIPPendente() != null) {
            _hashCode += getIsCIPPendente().hashCode();
        }
        if (getIsEmCIP() != null) {
            _hashCode += getIsEmCIP().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IwsDadosCIPDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "iwsDadosCIPDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmoldeantigo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmoldeantigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtHrInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtHrInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isCIPPendente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isCIPPendente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEmCIP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEmCIP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
