/**
 * Ijinspecaoctrl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijinspecaoctrl  implements java.io.Serializable {
    private java.lang.String idinspecao;

    private idw.idwws.Ijinspecao ijinspecao;

    private java.math.BigDecimal qtdamostras;

    private java.math.BigDecimal qtdamostraslidas;

    public Ijinspecaoctrl() {
    }

    public Ijinspecaoctrl(
           java.lang.String idinspecao,
           idw.idwws.Ijinspecao ijinspecao,
           java.math.BigDecimal qtdamostras,
           java.math.BigDecimal qtdamostraslidas) {
           this.idinspecao = idinspecao;
           this.ijinspecao = ijinspecao;
           this.qtdamostras = qtdamostras;
           this.qtdamostraslidas = qtdamostraslidas;
    }


    /**
     * Gets the idinspecao value for this Ijinspecaoctrl.
     * 
     * @return idinspecao
     */
    public java.lang.String getIdinspecao() {
        return idinspecao;
    }


    /**
     * Sets the idinspecao value for this Ijinspecaoctrl.
     * 
     * @param idinspecao
     */
    public void setIdinspecao(java.lang.String idinspecao) {
        this.idinspecao = idinspecao;
    }


    /**
     * Gets the ijinspecao value for this Ijinspecaoctrl.
     * 
     * @return ijinspecao
     */
    public idw.idwws.Ijinspecao getIjinspecao() {
        return ijinspecao;
    }


    /**
     * Sets the ijinspecao value for this Ijinspecaoctrl.
     * 
     * @param ijinspecao
     */
    public void setIjinspecao(idw.idwws.Ijinspecao ijinspecao) {
        this.ijinspecao = ijinspecao;
    }


    /**
     * Gets the qtdamostras value for this Ijinspecaoctrl.
     * 
     * @return qtdamostras
     */
    public java.math.BigDecimal getQtdamostras() {
        return qtdamostras;
    }


    /**
     * Sets the qtdamostras value for this Ijinspecaoctrl.
     * 
     * @param qtdamostras
     */
    public void setQtdamostras(java.math.BigDecimal qtdamostras) {
        this.qtdamostras = qtdamostras;
    }


    /**
     * Gets the qtdamostraslidas value for this Ijinspecaoctrl.
     * 
     * @return qtdamostraslidas
     */
    public java.math.BigDecimal getQtdamostraslidas() {
        return qtdamostraslidas;
    }


    /**
     * Sets the qtdamostraslidas value for this Ijinspecaoctrl.
     * 
     * @param qtdamostraslidas
     */
    public void setQtdamostraslidas(java.math.BigDecimal qtdamostraslidas) {
        this.qtdamostraslidas = qtdamostraslidas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijinspecaoctrl)) return false;
        Ijinspecaoctrl other = (Ijinspecaoctrl) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idinspecao==null && other.getIdinspecao()==null) || 
             (this.idinspecao!=null &&
              this.idinspecao.equals(other.getIdinspecao()))) &&
            ((this.ijinspecao==null && other.getIjinspecao()==null) || 
             (this.ijinspecao!=null &&
              this.ijinspecao.equals(other.getIjinspecao()))) &&
            ((this.qtdamostras==null && other.getQtdamostras()==null) || 
             (this.qtdamostras!=null &&
              this.qtdamostras.equals(other.getQtdamostras()))) &&
            ((this.qtdamostraslidas==null && other.getQtdamostraslidas()==null) || 
             (this.qtdamostraslidas!=null &&
              this.qtdamostraslidas.equals(other.getQtdamostraslidas())));
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
        if (getIdinspecao() != null) {
            _hashCode += getIdinspecao().hashCode();
        }
        if (getIjinspecao() != null) {
            _hashCode += getIjinspecao().hashCode();
        }
        if (getQtdamostras() != null) {
            _hashCode += getQtdamostras().hashCode();
        }
        if (getQtdamostraslidas() != null) {
            _hashCode += getQtdamostraslidas().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijinspecaoctrl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijinspecaoctrl"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idinspecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idinspecao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijinspecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijinspecao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijinspecao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdamostras");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdamostras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdamostraslidas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdamostraslidas"));
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
