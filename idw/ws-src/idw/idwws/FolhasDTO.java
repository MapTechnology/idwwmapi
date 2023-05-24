/**
 * FolhasDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class FolhasDTO  implements java.io.Serializable {
    private idw.idwws.FolhaDTO[] folhas;

    private java.lang.String mensagem;

    public FolhasDTO() {
    }

    public FolhasDTO(
           idw.idwws.FolhaDTO[] folhas,
           java.lang.String mensagem) {
           this.folhas = folhas;
           this.mensagem = mensagem;
    }


    /**
     * Gets the folhas value for this FolhasDTO.
     * 
     * @return folhas
     */
    public idw.idwws.FolhaDTO[] getFolhas() {
        return folhas;
    }


    /**
     * Sets the folhas value for this FolhasDTO.
     * 
     * @param folhas
     */
    public void setFolhas(idw.idwws.FolhaDTO[] folhas) {
        this.folhas = folhas;
    }

    public idw.idwws.FolhaDTO getFolhas(int i) {
        return this.folhas[i];
    }

    public void setFolhas(int i, idw.idwws.FolhaDTO _value) {
        this.folhas[i] = _value;
    }


    /**
     * Gets the mensagem value for this FolhasDTO.
     * 
     * @return mensagem
     */
    public java.lang.String getMensagem() {
        return mensagem;
    }


    /**
     * Sets the mensagem value for this FolhasDTO.
     * 
     * @param mensagem
     */
    public void setMensagem(java.lang.String mensagem) {
        this.mensagem = mensagem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FolhasDTO)) return false;
        FolhasDTO other = (FolhasDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.folhas==null && other.getFolhas()==null) || 
             (this.folhas!=null &&
              java.util.Arrays.equals(this.folhas, other.getFolhas()))) &&
            ((this.mensagem==null && other.getMensagem()==null) || 
             (this.mensagem!=null &&
              this.mensagem.equals(other.getMensagem())));
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
        if (getFolhas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFolhas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFolhas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMensagem() != null) {
            _hashCode += getMensagem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FolhasDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "folhasDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folhas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "folhas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "folhaDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mensagem"));
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
