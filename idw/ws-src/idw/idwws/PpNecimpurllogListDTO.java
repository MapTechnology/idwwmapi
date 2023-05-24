/**
 * PpNecimpurllogListDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpNecimpurllogListDTO  implements java.io.Serializable {
    private java.lang.String[] listaArquivos;

    private idw.idwws.PpNecimpurllogDTO[] listaPpNecimpurllogDTO;

    private idw.idwws.ResultadoDTO resultadoDTO;

    public PpNecimpurllogListDTO() {
    }

    public PpNecimpurllogListDTO(
           java.lang.String[] listaArquivos,
           idw.idwws.PpNecimpurllogDTO[] listaPpNecimpurllogDTO,
           idw.idwws.ResultadoDTO resultadoDTO) {
           this.listaArquivos = listaArquivos;
           this.listaPpNecimpurllogDTO = listaPpNecimpurllogDTO;
           this.resultadoDTO = resultadoDTO;
    }


    /**
     * Gets the listaArquivos value for this PpNecimpurllogListDTO.
     * 
     * @return listaArquivos
     */
    public java.lang.String[] getListaArquivos() {
        return listaArquivos;
    }


    /**
     * Sets the listaArquivos value for this PpNecimpurllogListDTO.
     * 
     * @param listaArquivos
     */
    public void setListaArquivos(java.lang.String[] listaArquivos) {
        this.listaArquivos = listaArquivos;
    }

    public java.lang.String getListaArquivos(int i) {
        return this.listaArquivos[i];
    }

    public void setListaArquivos(int i, java.lang.String _value) {
        this.listaArquivos[i] = _value;
    }


    /**
     * Gets the listaPpNecimpurllogDTO value for this PpNecimpurllogListDTO.
     * 
     * @return listaPpNecimpurllogDTO
     */
    public idw.idwws.PpNecimpurllogDTO[] getListaPpNecimpurllogDTO() {
        return listaPpNecimpurllogDTO;
    }


    /**
     * Sets the listaPpNecimpurllogDTO value for this PpNecimpurllogListDTO.
     * 
     * @param listaPpNecimpurllogDTO
     */
    public void setListaPpNecimpurllogDTO(idw.idwws.PpNecimpurllogDTO[] listaPpNecimpurllogDTO) {
        this.listaPpNecimpurllogDTO = listaPpNecimpurllogDTO;
    }

    public idw.idwws.PpNecimpurllogDTO getListaPpNecimpurllogDTO(int i) {
        return this.listaPpNecimpurllogDTO[i];
    }

    public void setListaPpNecimpurllogDTO(int i, idw.idwws.PpNecimpurllogDTO _value) {
        this.listaPpNecimpurllogDTO[i] = _value;
    }


    /**
     * Gets the resultadoDTO value for this PpNecimpurllogListDTO.
     * 
     * @return resultadoDTO
     */
    public idw.idwws.ResultadoDTO getResultadoDTO() {
        return resultadoDTO;
    }


    /**
     * Sets the resultadoDTO value for this PpNecimpurllogListDTO.
     * 
     * @param resultadoDTO
     */
    public void setResultadoDTO(idw.idwws.ResultadoDTO resultadoDTO) {
        this.resultadoDTO = resultadoDTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpNecimpurllogListDTO)) return false;
        PpNecimpurllogListDTO other = (PpNecimpurllogListDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listaArquivos==null && other.getListaArquivos()==null) || 
             (this.listaArquivos!=null &&
              java.util.Arrays.equals(this.listaArquivos, other.getListaArquivos()))) &&
            ((this.listaPpNecimpurllogDTO==null && other.getListaPpNecimpurllogDTO()==null) || 
             (this.listaPpNecimpurllogDTO!=null &&
              java.util.Arrays.equals(this.listaPpNecimpurllogDTO, other.getListaPpNecimpurllogDTO()))) &&
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
        if (getListaArquivos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaArquivos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaArquivos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaPpNecimpurllogDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaPpNecimpurllogDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaPpNecimpurllogDTO(), i);
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
        new org.apache.axis.description.TypeDesc(PpNecimpurllogListDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecimpurllogListDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaArquivos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaArquivos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaPpNecimpurllogDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaPpNecimpurllogDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecimpurllogDTO"));
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
