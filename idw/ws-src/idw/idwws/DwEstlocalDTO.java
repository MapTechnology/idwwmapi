/**
 * DwEstlocalDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwEstlocalDTO  implements java.io.Serializable {
    private idw.idwws.DwEstlocal dwEstlocal;

    private int ERRO_CD_LOCAL_ESTOQUE_INVALIDO;

    private int ERRO_DESCONHECIDO;

    private int ERRO_ESTOQUE_DESCONHECIDO;

    private int ERRO_LOCAL_ESTOQUE_JA_EXISTE;

    private int ERRO_USUARIO_REVISAO_DESCONHECIDO;

    private int ERRO_USUARIO_STATIVO_DESCONHECIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private int resultadoEvento;

    public DwEstlocalDTO() {
    }

    public DwEstlocalDTO(
           idw.idwws.DwEstlocal dwEstlocal,
           int ERRO_CD_LOCAL_ESTOQUE_INVALIDO,
           int ERRO_DESCONHECIDO,
           int ERRO_ESTOQUE_DESCONHECIDO,
           int ERRO_LOCAL_ESTOQUE_JA_EXISTE,
           int ERRO_USUARIO_REVISAO_DESCONHECIDO,
           int ERRO_USUARIO_STATIVO_DESCONHECIDO,
           int EVENTO_BEM_SUCEDIDO,
           int resultadoEvento) {
           this.dwEstlocal = dwEstlocal;
           this.ERRO_CD_LOCAL_ESTOQUE_INVALIDO = ERRO_CD_LOCAL_ESTOQUE_INVALIDO;
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.ERRO_ESTOQUE_DESCONHECIDO = ERRO_ESTOQUE_DESCONHECIDO;
           this.ERRO_LOCAL_ESTOQUE_JA_EXISTE = ERRO_LOCAL_ESTOQUE_JA_EXISTE;
           this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
           this.ERRO_USUARIO_STATIVO_DESCONHECIDO = ERRO_USUARIO_STATIVO_DESCONHECIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the dwEstlocal value for this DwEstlocalDTO.
     * 
     * @return dwEstlocal
     */
    public idw.idwws.DwEstlocal getDwEstlocal() {
        return dwEstlocal;
    }


    /**
     * Sets the dwEstlocal value for this DwEstlocalDTO.
     * 
     * @param dwEstlocal
     */
    public void setDwEstlocal(idw.idwws.DwEstlocal dwEstlocal) {
        this.dwEstlocal = dwEstlocal;
    }


    /**
     * Gets the ERRO_CD_LOCAL_ESTOQUE_INVALIDO value for this DwEstlocalDTO.
     * 
     * @return ERRO_CD_LOCAL_ESTOQUE_INVALIDO
     */
    public int getERRO_CD_LOCAL_ESTOQUE_INVALIDO() {
        return ERRO_CD_LOCAL_ESTOQUE_INVALIDO;
    }


    /**
     * Sets the ERRO_CD_LOCAL_ESTOQUE_INVALIDO value for this DwEstlocalDTO.
     * 
     * @param ERRO_CD_LOCAL_ESTOQUE_INVALIDO
     */
    public void setERRO_CD_LOCAL_ESTOQUE_INVALIDO(int ERRO_CD_LOCAL_ESTOQUE_INVALIDO) {
        this.ERRO_CD_LOCAL_ESTOQUE_INVALIDO = ERRO_CD_LOCAL_ESTOQUE_INVALIDO;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this DwEstlocalDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this DwEstlocalDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_ESTOQUE_DESCONHECIDO value for this DwEstlocalDTO.
     * 
     * @return ERRO_ESTOQUE_DESCONHECIDO
     */
    public int getERRO_ESTOQUE_DESCONHECIDO() {
        return ERRO_ESTOQUE_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_ESTOQUE_DESCONHECIDO value for this DwEstlocalDTO.
     * 
     * @param ERRO_ESTOQUE_DESCONHECIDO
     */
    public void setERRO_ESTOQUE_DESCONHECIDO(int ERRO_ESTOQUE_DESCONHECIDO) {
        this.ERRO_ESTOQUE_DESCONHECIDO = ERRO_ESTOQUE_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_LOCAL_ESTOQUE_JA_EXISTE value for this DwEstlocalDTO.
     * 
     * @return ERRO_LOCAL_ESTOQUE_JA_EXISTE
     */
    public int getERRO_LOCAL_ESTOQUE_JA_EXISTE() {
        return ERRO_LOCAL_ESTOQUE_JA_EXISTE;
    }


    /**
     * Sets the ERRO_LOCAL_ESTOQUE_JA_EXISTE value for this DwEstlocalDTO.
     * 
     * @param ERRO_LOCAL_ESTOQUE_JA_EXISTE
     */
    public void setERRO_LOCAL_ESTOQUE_JA_EXISTE(int ERRO_LOCAL_ESTOQUE_JA_EXISTE) {
        this.ERRO_LOCAL_ESTOQUE_JA_EXISTE = ERRO_LOCAL_ESTOQUE_JA_EXISTE;
    }


    /**
     * Gets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this DwEstlocalDTO.
     * 
     * @return ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
        return ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this DwEstlocalDTO.
     * 
     * @param ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public void setERRO_USUARIO_REVISAO_DESCONHECIDO(int ERRO_USUARIO_REVISAO_DESCONHECIDO) {
        this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_STATIVO_DESCONHECIDO value for this DwEstlocalDTO.
     * 
     * @return ERRO_USUARIO_STATIVO_DESCONHECIDO
     */
    public int getERRO_USUARIO_STATIVO_DESCONHECIDO() {
        return ERRO_USUARIO_STATIVO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_STATIVO_DESCONHECIDO value for this DwEstlocalDTO.
     * 
     * @param ERRO_USUARIO_STATIVO_DESCONHECIDO
     */
    public void setERRO_USUARIO_STATIVO_DESCONHECIDO(int ERRO_USUARIO_STATIVO_DESCONHECIDO) {
        this.ERRO_USUARIO_STATIVO_DESCONHECIDO = ERRO_USUARIO_STATIVO_DESCONHECIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this DwEstlocalDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this DwEstlocalDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the resultadoEvento value for this DwEstlocalDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this DwEstlocalDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwEstlocalDTO)) return false;
        DwEstlocalDTO other = (DwEstlocalDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dwEstlocal==null && other.getDwEstlocal()==null) || 
             (this.dwEstlocal!=null &&
              this.dwEstlocal.equals(other.getDwEstlocal()))) &&
            this.ERRO_CD_LOCAL_ESTOQUE_INVALIDO == other.getERRO_CD_LOCAL_ESTOQUE_INVALIDO() &&
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.ERRO_ESTOQUE_DESCONHECIDO == other.getERRO_ESTOQUE_DESCONHECIDO() &&
            this.ERRO_LOCAL_ESTOQUE_JA_EXISTE == other.getERRO_LOCAL_ESTOQUE_JA_EXISTE() &&
            this.ERRO_USUARIO_REVISAO_DESCONHECIDO == other.getERRO_USUARIO_REVISAO_DESCONHECIDO() &&
            this.ERRO_USUARIO_STATIVO_DESCONHECIDO == other.getERRO_USUARIO_STATIVO_DESCONHECIDO() &&
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
        if (getDwEstlocal() != null) {
            _hashCode += getDwEstlocal().hashCode();
        }
        _hashCode += getERRO_CD_LOCAL_ESTOQUE_INVALIDO();
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getERRO_ESTOQUE_DESCONHECIDO();
        _hashCode += getERRO_LOCAL_ESTOQUE_JA_EXISTE();
        _hashCode += getERRO_USUARIO_REVISAO_DESCONHECIDO();
        _hashCode += getERRO_USUARIO_STATIVO_DESCONHECIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        _hashCode += getResultadoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwEstlocalDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEstlocalDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstlocal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstlocal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEstlocal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CD_LOCAL_ESTOQUE_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CD_LOCAL_ESTOQUE_INVALIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_ESTOQUE_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_ESTOQUE_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_LOCAL_ESTOQUE_JA_EXISTE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_LOCAL_ESTOQUE_JA_EXISTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_USUARIO_REVISAO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_USUARIO_REVISAO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_USUARIO_STATIVO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_USUARIO_STATIVO_DESCONHECIDO"));
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
