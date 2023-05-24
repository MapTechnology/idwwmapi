/**
 * Ijcomequipcent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijcomequipcent  implements java.io.Serializable {
    private java.lang.String cdequipamento;

    private idw.idwws.Ijtbcentinsp ijtbcentinsp;

    private idw.idwws.Ijtbequipamentos ijtbequipamentos;

    private java.lang.String portacomunic;

    public Ijcomequipcent() {
    }

    public Ijcomequipcent(
           java.lang.String cdequipamento,
           idw.idwws.Ijtbcentinsp ijtbcentinsp,
           idw.idwws.Ijtbequipamentos ijtbequipamentos,
           java.lang.String portacomunic) {
           this.cdequipamento = cdequipamento;
           this.ijtbcentinsp = ijtbcentinsp;
           this.ijtbequipamentos = ijtbequipamentos;
           this.portacomunic = portacomunic;
    }


    /**
     * Gets the cdequipamento value for this Ijcomequipcent.
     * 
     * @return cdequipamento
     */
    public java.lang.String getCdequipamento() {
        return cdequipamento;
    }


    /**
     * Sets the cdequipamento value for this Ijcomequipcent.
     * 
     * @param cdequipamento
     */
    public void setCdequipamento(java.lang.String cdequipamento) {
        this.cdequipamento = cdequipamento;
    }


    /**
     * Gets the ijtbcentinsp value for this Ijcomequipcent.
     * 
     * @return ijtbcentinsp
     */
    public idw.idwws.Ijtbcentinsp getIjtbcentinsp() {
        return ijtbcentinsp;
    }


    /**
     * Sets the ijtbcentinsp value for this Ijcomequipcent.
     * 
     * @param ijtbcentinsp
     */
    public void setIjtbcentinsp(idw.idwws.Ijtbcentinsp ijtbcentinsp) {
        this.ijtbcentinsp = ijtbcentinsp;
    }


    /**
     * Gets the ijtbequipamentos value for this Ijcomequipcent.
     * 
     * @return ijtbequipamentos
     */
    public idw.idwws.Ijtbequipamentos getIjtbequipamentos() {
        return ijtbequipamentos;
    }


    /**
     * Sets the ijtbequipamentos value for this Ijcomequipcent.
     * 
     * @param ijtbequipamentos
     */
    public void setIjtbequipamentos(idw.idwws.Ijtbequipamentos ijtbequipamentos) {
        this.ijtbequipamentos = ijtbequipamentos;
    }


    /**
     * Gets the portacomunic value for this Ijcomequipcent.
     * 
     * @return portacomunic
     */
    public java.lang.String getPortacomunic() {
        return portacomunic;
    }


    /**
     * Sets the portacomunic value for this Ijcomequipcent.
     * 
     * @param portacomunic
     */
    public void setPortacomunic(java.lang.String portacomunic) {
        this.portacomunic = portacomunic;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijcomequipcent)) return false;
        Ijcomequipcent other = (Ijcomequipcent) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdequipamento==null && other.getCdequipamento()==null) || 
             (this.cdequipamento!=null &&
              this.cdequipamento.equals(other.getCdequipamento()))) &&
            ((this.ijtbcentinsp==null && other.getIjtbcentinsp()==null) || 
             (this.ijtbcentinsp!=null &&
              this.ijtbcentinsp.equals(other.getIjtbcentinsp()))) &&
            ((this.ijtbequipamentos==null && other.getIjtbequipamentos()==null) || 
             (this.ijtbequipamentos!=null &&
              this.ijtbequipamentos.equals(other.getIjtbequipamentos()))) &&
            ((this.portacomunic==null && other.getPortacomunic()==null) || 
             (this.portacomunic!=null &&
              this.portacomunic.equals(other.getPortacomunic())));
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
        if (getCdequipamento() != null) {
            _hashCode += getCdequipamento().hashCode();
        }
        if (getIjtbcentinsp() != null) {
            _hashCode += getIjtbcentinsp().hashCode();
        }
        if (getIjtbequipamentos() != null) {
            _hashCode += getIjtbequipamentos().hashCode();
        }
        if (getPortacomunic() != null) {
            _hashCode += getPortacomunic().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijcomequipcent.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcomequipcent"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdequipamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdequipamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbcentinsp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbcentinsp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcentinsp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbequipamentos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbequipamentos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbequipamentos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("portacomunic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "portacomunic"));
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
