/**
 * PpPlanec.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpPlanec  extends idw.idwws.PpPlanecTemplate  implements java.io.Serializable {
    private java.lang.Long idPlanec;

    private idw.idwws.PpNec ppNec;

    private idw.idwws.PpPlano ppPlano;

    private java.lang.Integer prioridade;

    public PpPlanec() {
    }

    public PpPlanec(
           java.lang.Long idPlanec,
           idw.idwws.PpNec ppNec,
           idw.idwws.PpPlano ppPlano,
           java.lang.Integer prioridade) {
        this.idPlanec = idPlanec;
        this.ppNec = ppNec;
        this.ppPlano = ppPlano;
        this.prioridade = prioridade;
    }


    /**
     * Gets the idPlanec value for this PpPlanec.
     * 
     * @return idPlanec
     */
    public java.lang.Long getIdPlanec() {
        return idPlanec;
    }


    /**
     * Sets the idPlanec value for this PpPlanec.
     * 
     * @param idPlanec
     */
    public void setIdPlanec(java.lang.Long idPlanec) {
        this.idPlanec = idPlanec;
    }


    /**
     * Gets the ppNec value for this PpPlanec.
     * 
     * @return ppNec
     */
    public idw.idwws.PpNec getPpNec() {
        return ppNec;
    }


    /**
     * Sets the ppNec value for this PpPlanec.
     * 
     * @param ppNec
     */
    public void setPpNec(idw.idwws.PpNec ppNec) {
        this.ppNec = ppNec;
    }


    /**
     * Gets the ppPlano value for this PpPlanec.
     * 
     * @return ppPlano
     */
    public idw.idwws.PpPlano getPpPlano() {
        return ppPlano;
    }


    /**
     * Sets the ppPlano value for this PpPlanec.
     * 
     * @param ppPlano
     */
    public void setPpPlano(idw.idwws.PpPlano ppPlano) {
        this.ppPlano = ppPlano;
    }


    /**
     * Gets the prioridade value for this PpPlanec.
     * 
     * @return prioridade
     */
    public java.lang.Integer getPrioridade() {
        return prioridade;
    }


    /**
     * Sets the prioridade value for this PpPlanec.
     * 
     * @param prioridade
     */
    public void setPrioridade(java.lang.Integer prioridade) {
        this.prioridade = prioridade;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpPlanec)) return false;
        PpPlanec other = (PpPlanec) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.idPlanec==null && other.getIdPlanec()==null) || 
             (this.idPlanec!=null &&
              this.idPlanec.equals(other.getIdPlanec()))) &&
            ((this.ppNec==null && other.getPpNec()==null) || 
             (this.ppNec!=null &&
              this.ppNec.equals(other.getPpNec()))) &&
            ((this.ppPlano==null && other.getPpPlano()==null) || 
             (this.ppPlano!=null &&
              this.ppPlano.equals(other.getPpPlano()))) &&
            ((this.prioridade==null && other.getPrioridade()==null) || 
             (this.prioridade!=null &&
              this.prioridade.equals(other.getPrioridade())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getIdPlanec() != null) {
            _hashCode += getIdPlanec().hashCode();
        }
        if (getPpNec() != null) {
            _hashCode += getPpNec().hashCode();
        }
        if (getPpPlano() != null) {
            _hashCode += getPpPlano().hashCode();
        }
        if (getPrioridade() != null) {
            _hashCode += getPrioridade().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpPlanec.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppPlanec"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPlanec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPlanec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppNec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppNec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppPlano");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppPlano"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppPlano"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prioridade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prioridade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
