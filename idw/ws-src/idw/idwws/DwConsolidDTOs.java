/**
 * DwConsolidDTOs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolidDTOs  implements java.io.Serializable {
    private int ERRO_DESCONHECIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private idw.idwws.DwConsolidDTO[] listaDwConsolidDTO;

    private idw.idwws.ResultadoDTO resultadoDTO;

    public DwConsolidDTOs() {
    }

    public DwConsolidDTOs(
           int ERRO_DESCONHECIDO,
           int EVENTO_BEM_SUCEDIDO,
           idw.idwws.DwConsolidDTO[] listaDwConsolidDTO,
           idw.idwws.ResultadoDTO resultadoDTO) {
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.listaDwConsolidDTO = listaDwConsolidDTO;
           this.resultadoDTO = resultadoDTO;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this DwConsolidDTOs.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this DwConsolidDTOs.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this DwConsolidDTOs.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this DwConsolidDTOs.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the listaDwConsolidDTO value for this DwConsolidDTOs.
     * 
     * @return listaDwConsolidDTO
     */
    public idw.idwws.DwConsolidDTO[] getListaDwConsolidDTO() {
        return listaDwConsolidDTO;
    }


    /**
     * Sets the listaDwConsolidDTO value for this DwConsolidDTOs.
     * 
     * @param listaDwConsolidDTO
     */
    public void setListaDwConsolidDTO(idw.idwws.DwConsolidDTO[] listaDwConsolidDTO) {
        this.listaDwConsolidDTO = listaDwConsolidDTO;
    }

    public idw.idwws.DwConsolidDTO getListaDwConsolidDTO(int i) {
        return this.listaDwConsolidDTO[i];
    }

    public void setListaDwConsolidDTO(int i, idw.idwws.DwConsolidDTO _value) {
        this.listaDwConsolidDTO[i] = _value;
    }


    /**
     * Gets the resultadoDTO value for this DwConsolidDTOs.
     * 
     * @return resultadoDTO
     */
    public idw.idwws.ResultadoDTO getResultadoDTO() {
        return resultadoDTO;
    }


    /**
     * Sets the resultadoDTO value for this DwConsolidDTOs.
     * 
     * @param resultadoDTO
     */
    public void setResultadoDTO(idw.idwws.ResultadoDTO resultadoDTO) {
        this.resultadoDTO = resultadoDTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolidDTOs)) return false;
        DwConsolidDTOs other = (DwConsolidDTOs) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            ((this.listaDwConsolidDTO==null && other.getListaDwConsolidDTO()==null) || 
             (this.listaDwConsolidDTO!=null &&
              java.util.Arrays.equals(this.listaDwConsolidDTO, other.getListaDwConsolidDTO()))) &&
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
        int _hashCode = 1;
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        if (getListaDwConsolidDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaDwConsolidDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaDwConsolidDTO(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getResultadoDTO() != null) {
            _hashCode += getResultadoDTO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolidDTOs.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolidDTOs"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EVENTO_BEM_SUCEDIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EVENTO_BEM_SUCEDIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaDwConsolidDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaDwConsolidDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolidDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
