/**
 * DwTOperacao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwTOperacao  implements java.io.Serializable {
    private java.lang.String dsToperacao;

    private idw.idwws.DwOperacao[] dwOperacaos;

    private long idToperacao;

    public DwTOperacao() {
    }

    public DwTOperacao(
           java.lang.String dsToperacao,
           idw.idwws.DwOperacao[] dwOperacaos,
           long idToperacao) {
           this.dsToperacao = dsToperacao;
           this.dwOperacaos = dwOperacaos;
           this.idToperacao = idToperacao;
    }


    /**
     * Gets the dsToperacao value for this DwTOperacao.
     * 
     * @return dsToperacao
     */
    public java.lang.String getDsToperacao() {
        return dsToperacao;
    }


    /**
     * Sets the dsToperacao value for this DwTOperacao.
     * 
     * @param dsToperacao
     */
    public void setDsToperacao(java.lang.String dsToperacao) {
        this.dsToperacao = dsToperacao;
    }


    /**
     * Gets the dwOperacaos value for this DwTOperacao.
     * 
     * @return dwOperacaos
     */
    public idw.idwws.DwOperacao[] getDwOperacaos() {
        return dwOperacaos;
    }


    /**
     * Sets the dwOperacaos value for this DwTOperacao.
     * 
     * @param dwOperacaos
     */
    public void setDwOperacaos(idw.idwws.DwOperacao[] dwOperacaos) {
        this.dwOperacaos = dwOperacaos;
    }

    public idw.idwws.DwOperacao getDwOperacaos(int i) {
        return this.dwOperacaos[i];
    }

    public void setDwOperacaos(int i, idw.idwws.DwOperacao _value) {
        this.dwOperacaos[i] = _value;
    }


    /**
     * Gets the idToperacao value for this DwTOperacao.
     * 
     * @return idToperacao
     */
    public long getIdToperacao() {
        return idToperacao;
    }


    /**
     * Sets the idToperacao value for this DwTOperacao.
     * 
     * @param idToperacao
     */
    public void setIdToperacao(long idToperacao) {
        this.idToperacao = idToperacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwTOperacao)) return false;
        DwTOperacao other = (DwTOperacao) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dsToperacao==null && other.getDsToperacao()==null) || 
             (this.dsToperacao!=null &&
              this.dsToperacao.equals(other.getDsToperacao()))) &&
            ((this.dwOperacaos==null && other.getDwOperacaos()==null) || 
             (this.dwOperacaos!=null &&
              java.util.Arrays.equals(this.dwOperacaos, other.getDwOperacaos()))) &&
            this.idToperacao == other.getIdToperacao();
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
        if (getDsToperacao() != null) {
            _hashCode += getDsToperacao().hashCode();
        }
        if (getDwOperacaos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwOperacaos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwOperacaos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdToperacao()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwTOperacao.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTOperacao"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsToperacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsToperacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwOperacaos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwOperacaos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwOperacao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idToperacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idToperacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
