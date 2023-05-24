/**
 * Ijcomequipamento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijcomequipamento  implements java.io.Serializable {
    private idw.idwws.IjcomequipamentoId id;

    private idw.idwws.Ijtbequipamentos ijtbequipamentos;

    private idw.idwws.Ijtbinj ijtbinj;

    private java.math.BigDecimal stequipamento;

    public Ijcomequipamento() {
    }

    public Ijcomequipamento(
           idw.idwws.IjcomequipamentoId id,
           idw.idwws.Ijtbequipamentos ijtbequipamentos,
           idw.idwws.Ijtbinj ijtbinj,
           java.math.BigDecimal stequipamento) {
           this.id = id;
           this.ijtbequipamentos = ijtbequipamentos;
           this.ijtbinj = ijtbinj;
           this.stequipamento = stequipamento;
    }


    /**
     * Gets the id value for this Ijcomequipamento.
     * 
     * @return id
     */
    public idw.idwws.IjcomequipamentoId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijcomequipamento.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjcomequipamentoId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbequipamentos value for this Ijcomequipamento.
     * 
     * @return ijtbequipamentos
     */
    public idw.idwws.Ijtbequipamentos getIjtbequipamentos() {
        return ijtbequipamentos;
    }


    /**
     * Sets the ijtbequipamentos value for this Ijcomequipamento.
     * 
     * @param ijtbequipamentos
     */
    public void setIjtbequipamentos(idw.idwws.Ijtbequipamentos ijtbequipamentos) {
        this.ijtbequipamentos = ijtbequipamentos;
    }


    /**
     * Gets the ijtbinj value for this Ijcomequipamento.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijcomequipamento.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the stequipamento value for this Ijcomequipamento.
     * 
     * @return stequipamento
     */
    public java.math.BigDecimal getStequipamento() {
        return stequipamento;
    }


    /**
     * Sets the stequipamento value for this Ijcomequipamento.
     * 
     * @param stequipamento
     */
    public void setStequipamento(java.math.BigDecimal stequipamento) {
        this.stequipamento = stequipamento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijcomequipamento)) return false;
        Ijcomequipamento other = (Ijcomequipamento) obj;
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
            ((this.ijtbequipamentos==null && other.getIjtbequipamentos()==null) || 
             (this.ijtbequipamentos!=null &&
              this.ijtbequipamentos.equals(other.getIjtbequipamentos()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.stequipamento==null && other.getStequipamento()==null) || 
             (this.stequipamento!=null &&
              this.stequipamento.equals(other.getStequipamento())));
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
        if (getIjtbequipamentos() != null) {
            _hashCode += getIjtbequipamentos().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getStequipamento() != null) {
            _hashCode += getStequipamento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijcomequipamento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcomequipamento"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcomequipamentoId"));
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
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stequipamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stequipamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
