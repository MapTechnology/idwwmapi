/**
 * DireitoAcessoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DireitoAcessoDTO  implements java.io.Serializable {
    private idw.idwws.OmGrnts direitoAcesso;

    private int ERRO_DESCONHECIDO;

    private int ERRO_RESGUI_INVALIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private int resultadoEvento;

    public DireitoAcessoDTO() {
    }

    public DireitoAcessoDTO(
           idw.idwws.OmGrnts direitoAcesso,
           int ERRO_DESCONHECIDO,
           int ERRO_RESGUI_INVALIDO,
           int EVENTO_BEM_SUCEDIDO,
           int resultadoEvento) {
           this.direitoAcesso = direitoAcesso;
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.ERRO_RESGUI_INVALIDO = ERRO_RESGUI_INVALIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the direitoAcesso value for this DireitoAcessoDTO.
     * 
     * @return direitoAcesso
     */
    public idw.idwws.OmGrnts getDireitoAcesso() {
        return direitoAcesso;
    }


    /**
     * Sets the direitoAcesso value for this DireitoAcessoDTO.
     * 
     * @param direitoAcesso
     */
    public void setDireitoAcesso(idw.idwws.OmGrnts direitoAcesso) {
        this.direitoAcesso = direitoAcesso;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this DireitoAcessoDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this DireitoAcessoDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_RESGUI_INVALIDO value for this DireitoAcessoDTO.
     * 
     * @return ERRO_RESGUI_INVALIDO
     */
    public int getERRO_RESGUI_INVALIDO() {
        return ERRO_RESGUI_INVALIDO;
    }


    /**
     * Sets the ERRO_RESGUI_INVALIDO value for this DireitoAcessoDTO.
     * 
     * @param ERRO_RESGUI_INVALIDO
     */
    public void setERRO_RESGUI_INVALIDO(int ERRO_RESGUI_INVALIDO) {
        this.ERRO_RESGUI_INVALIDO = ERRO_RESGUI_INVALIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this DireitoAcessoDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this DireitoAcessoDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the resultadoEvento value for this DireitoAcessoDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this DireitoAcessoDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DireitoAcessoDTO)) return false;
        DireitoAcessoDTO other = (DireitoAcessoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.direitoAcesso==null && other.getDireitoAcesso()==null) || 
             (this.direitoAcesso!=null &&
              this.direitoAcesso.equals(other.getDireitoAcesso()))) &&
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.ERRO_RESGUI_INVALIDO == other.getERRO_RESGUI_INVALIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            this.resultadoEvento == other.getResultadoEvento();
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
        if (getDireitoAcesso() != null) {
            _hashCode += getDireitoAcesso().hashCode();
        }
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getERRO_RESGUI_INVALIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        _hashCode += getResultadoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DireitoAcessoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "direitoAcessoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("direitoAcesso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "direitoAcesso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGrnts"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_RESGUI_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_RESGUI_INVALIDO"));
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
        elemField.setFieldName("resultadoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
