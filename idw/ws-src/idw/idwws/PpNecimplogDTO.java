/**
 * PpNecimplogDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpNecimplogDTO  extends idw.idwws.PpNecimplog  implements java.io.Serializable {
    private idw.idwws.ResultadoDTO resultadoDTO;

    public PpNecimplogDTO() {
    }

    public PpNecimplogDTO(
           java.lang.Integer anoReferencia,
           java.util.Calendar dthrFimportacao,
           java.util.Calendar dthrIimportacao,
           java.lang.Long idNecimplog,
           java.lang.Integer mesReferencia,
           idw.idwws.OmUsr omUsr,
           idw.idwws.PpNecimp ppNecimp,
           idw.idwws.PpNecimpurllog[] ppNecimpurllogs,
           idw.idwws.ResultadoDTO resultadoDTO) {
        super(
            anoReferencia,
            dthrFimportacao,
            dthrIimportacao,
            idNecimplog,
            mesReferencia,
            omUsr,
            ppNecimp,
            ppNecimpurllogs);
        this.resultadoDTO = resultadoDTO;
    }


    /**
     * Gets the resultadoDTO value for this PpNecimplogDTO.
     * 
     * @return resultadoDTO
     */
    public idw.idwws.ResultadoDTO getResultadoDTO() {
        return resultadoDTO;
    }


    /**
     * Sets the resultadoDTO value for this PpNecimplogDTO.
     * 
     * @param resultadoDTO
     */
    public void setResultadoDTO(idw.idwws.ResultadoDTO resultadoDTO) {
        this.resultadoDTO = resultadoDTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpNecimplogDTO)) return false;
        PpNecimplogDTO other = (PpNecimplogDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.resultadoDTO==null && other.getResultadoDTO()==null) || 
             (this.resultadoDTO!=null &&
              this.resultadoDTO.equals(other.getResultadoDTO())));
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
        if (getResultadoDTO() != null) {
            _hashCode += getResultadoDTO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpNecimplogDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecimplogDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoDTO"));
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
