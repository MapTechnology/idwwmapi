/**
 * PpTpplanoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpTpplanoDTO  extends idw.idwws.PpTpplano  implements java.io.Serializable {
    private idw.idwws.ResultadoDTO resultado;

    public PpTpplanoDTO() {
    }

    public PpTpplanoDTO(
           java.lang.String dsTpplano,
           java.lang.Long idTpplano,
           java.math.BigDecimal indOee,
           java.lang.Boolean isConsiderarcal,
           java.lang.Boolean isConsiderarcm,
           java.lang.Boolean isConsiderarest,
           java.lang.Boolean isConsiderarindisp,
           java.lang.Boolean isConsiderarmo,
           java.lang.Boolean isConsiderarmp,
           java.lang.Boolean isConsideraroeefinalserie,
           java.lang.Boolean isConsiderarprodutoturno,
           java.lang.Boolean isConsiderarrap,
           java.lang.Boolean isDeterminadocal,
           idw.idwws.PpPlano[] ppPlanos,
           java.lang.Integer tpAlgoritmo,
           idw.idwws.ResultadoDTO resultado) {
        super(
            dsTpplano,
            idTpplano,
            indOee,
            isConsiderarcal,
            isConsiderarcm,
            isConsiderarest,
            isConsiderarindisp,
            isConsiderarmo,
            isConsiderarmp,
            isConsideraroeefinalserie,
            isConsiderarprodutoturno,
            isConsiderarrap,
            isDeterminadocal,
            ppPlanos,
            tpAlgoritmo);
        this.resultado = resultado;
    }


    /**
     * Gets the resultado value for this PpTpplanoDTO.
     * 
     * @return resultado
     */
    public idw.idwws.ResultadoDTO getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this PpTpplanoDTO.
     * 
     * @param resultado
     */
    public void setResultado(idw.idwws.ResultadoDTO resultado) {
        this.resultado = resultado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpTpplanoDTO)) return false;
        PpTpplanoDTO other = (PpTpplanoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.resultado==null && other.getResultado()==null) || 
             (this.resultado!=null &&
              this.resultado.equals(other.getResultado())));
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
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpTpplanoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppTpplanoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoDTO"));
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
