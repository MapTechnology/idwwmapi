/**
 * DwEstsalma.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwEstsalma  extends idw.idwws.DwEstsalmaTemplate  implements java.io.Serializable {
    private java.util.Calendar dtReferencia;

    private java.lang.Long idEstsalma;

    private idw.idwws.OmProduto omProduto;

    private java.math.BigDecimal qtSaldofinalmes;

    public DwEstsalma() {
    }

    public DwEstsalma(
           java.util.Calendar dtReferencia,
           java.lang.Long idEstsalma,
           idw.idwws.OmProduto omProduto,
           java.math.BigDecimal qtSaldofinalmes) {
        this.dtReferencia = dtReferencia;
        this.idEstsalma = idEstsalma;
        this.omProduto = omProduto;
        this.qtSaldofinalmes = qtSaldofinalmes;
    }


    /**
     * Gets the dtReferencia value for this DwEstsalma.
     * 
     * @return dtReferencia
     */
    public java.util.Calendar getDtReferencia() {
        return dtReferencia;
    }


    /**
     * Sets the dtReferencia value for this DwEstsalma.
     * 
     * @param dtReferencia
     */
    public void setDtReferencia(java.util.Calendar dtReferencia) {
        this.dtReferencia = dtReferencia;
    }


    /**
     * Gets the idEstsalma value for this DwEstsalma.
     * 
     * @return idEstsalma
     */
    public java.lang.Long getIdEstsalma() {
        return idEstsalma;
    }


    /**
     * Sets the idEstsalma value for this DwEstsalma.
     * 
     * @param idEstsalma
     */
    public void setIdEstsalma(java.lang.Long idEstsalma) {
        this.idEstsalma = idEstsalma;
    }


    /**
     * Gets the omProduto value for this DwEstsalma.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this DwEstsalma.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the qtSaldofinalmes value for this DwEstsalma.
     * 
     * @return qtSaldofinalmes
     */
    public java.math.BigDecimal getQtSaldofinalmes() {
        return qtSaldofinalmes;
    }


    /**
     * Sets the qtSaldofinalmes value for this DwEstsalma.
     * 
     * @param qtSaldofinalmes
     */
    public void setQtSaldofinalmes(java.math.BigDecimal qtSaldofinalmes) {
        this.qtSaldofinalmes = qtSaldofinalmes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwEstsalma)) return false;
        DwEstsalma other = (DwEstsalma) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dtReferencia==null && other.getDtReferencia()==null) || 
             (this.dtReferencia!=null &&
              this.dtReferencia.equals(other.getDtReferencia()))) &&
            ((this.idEstsalma==null && other.getIdEstsalma()==null) || 
             (this.idEstsalma!=null &&
              this.idEstsalma.equals(other.getIdEstsalma()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.qtSaldofinalmes==null && other.getQtSaldofinalmes()==null) || 
             (this.qtSaldofinalmes!=null &&
              this.qtSaldofinalmes.equals(other.getQtSaldofinalmes())));
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
        if (getDtReferencia() != null) {
            _hashCode += getDtReferencia().hashCode();
        }
        if (getIdEstsalma() != null) {
            _hashCode += getIdEstsalma().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getQtSaldofinalmes() != null) {
            _hashCode += getQtSaldofinalmes().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwEstsalma.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEstsalma"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEstsalma");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idEstsalma"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtSaldofinalmes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtSaldofinalmes"));
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
