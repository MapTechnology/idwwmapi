/**
 * EstoquesDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class EstoquesDTO  implements java.io.Serializable {
    private idw.idwws.EstoqueDTO[] estoques;

    private idw.idwws.DwEstsalma[] saldosAnteriores;

    private idw.idwws.DwEstsalma[] saldosAnterioresExcluidos;

    public EstoquesDTO() {
    }

    public EstoquesDTO(
           idw.idwws.EstoqueDTO[] estoques,
           idw.idwws.DwEstsalma[] saldosAnteriores,
           idw.idwws.DwEstsalma[] saldosAnterioresExcluidos) {
           this.estoques = estoques;
           this.saldosAnteriores = saldosAnteriores;
           this.saldosAnterioresExcluidos = saldosAnterioresExcluidos;
    }


    /**
     * Gets the estoques value for this EstoquesDTO.
     * 
     * @return estoques
     */
    public idw.idwws.EstoqueDTO[] getEstoques() {
        return estoques;
    }


    /**
     * Sets the estoques value for this EstoquesDTO.
     * 
     * @param estoques
     */
    public void setEstoques(idw.idwws.EstoqueDTO[] estoques) {
        this.estoques = estoques;
    }

    public idw.idwws.EstoqueDTO getEstoques(int i) {
        return this.estoques[i];
    }

    public void setEstoques(int i, idw.idwws.EstoqueDTO _value) {
        this.estoques[i] = _value;
    }


    /**
     * Gets the saldosAnteriores value for this EstoquesDTO.
     * 
     * @return saldosAnteriores
     */
    public idw.idwws.DwEstsalma[] getSaldosAnteriores() {
        return saldosAnteriores;
    }


    /**
     * Sets the saldosAnteriores value for this EstoquesDTO.
     * 
     * @param saldosAnteriores
     */
    public void setSaldosAnteriores(idw.idwws.DwEstsalma[] saldosAnteriores) {
        this.saldosAnteriores = saldosAnteriores;
    }

    public idw.idwws.DwEstsalma getSaldosAnteriores(int i) {
        return this.saldosAnteriores[i];
    }

    public void setSaldosAnteriores(int i, idw.idwws.DwEstsalma _value) {
        this.saldosAnteriores[i] = _value;
    }


    /**
     * Gets the saldosAnterioresExcluidos value for this EstoquesDTO.
     * 
     * @return saldosAnterioresExcluidos
     */
    public idw.idwws.DwEstsalma[] getSaldosAnterioresExcluidos() {
        return saldosAnterioresExcluidos;
    }


    /**
     * Sets the saldosAnterioresExcluidos value for this EstoquesDTO.
     * 
     * @param saldosAnterioresExcluidos
     */
    public void setSaldosAnterioresExcluidos(idw.idwws.DwEstsalma[] saldosAnterioresExcluidos) {
        this.saldosAnterioresExcluidos = saldosAnterioresExcluidos;
    }

    public idw.idwws.DwEstsalma getSaldosAnterioresExcluidos(int i) {
        return this.saldosAnterioresExcluidos[i];
    }

    public void setSaldosAnterioresExcluidos(int i, idw.idwws.DwEstsalma _value) {
        this.saldosAnterioresExcluidos[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EstoquesDTO)) return false;
        EstoquesDTO other = (EstoquesDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.estoques==null && other.getEstoques()==null) || 
             (this.estoques!=null &&
              java.util.Arrays.equals(this.estoques, other.getEstoques()))) &&
            ((this.saldosAnteriores==null && other.getSaldosAnteriores()==null) || 
             (this.saldosAnteriores!=null &&
              java.util.Arrays.equals(this.saldosAnteriores, other.getSaldosAnteriores()))) &&
            ((this.saldosAnterioresExcluidos==null && other.getSaldosAnterioresExcluidos()==null) || 
             (this.saldosAnterioresExcluidos!=null &&
              java.util.Arrays.equals(this.saldosAnterioresExcluidos, other.getSaldosAnterioresExcluidos())));
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
        if (getEstoques() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEstoques());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEstoques(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSaldosAnteriores() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSaldosAnteriores());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSaldosAnteriores(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSaldosAnterioresExcluidos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSaldosAnterioresExcluidos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSaldosAnterioresExcluidos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EstoquesDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "estoquesDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estoques");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estoques"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "estoqueDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saldosAnteriores");
        elemField.setXmlName(new javax.xml.namespace.QName("", "saldosAnteriores"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEstsalma"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saldosAnterioresExcluidos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "saldosAnterioresExcluidos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEstsalma"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
