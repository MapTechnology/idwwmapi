/**
 * SapEstoqueDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class SapEstoqueDTO  implements java.io.Serializable {
    private boolean ajustarEstoque;

    private idw.idwws.DwConsolid dwconsolid;

    private boolean fechamentoMes;

    private int resultadoEvento;

    private idw.idwws.TtSapEstmppa sapestoque;

    public SapEstoqueDTO() {
    }

    public SapEstoqueDTO(
           boolean ajustarEstoque,
           idw.idwws.DwConsolid dwconsolid,
           boolean fechamentoMes,
           int resultadoEvento,
           idw.idwws.TtSapEstmppa sapestoque) {
           this.ajustarEstoque = ajustarEstoque;
           this.dwconsolid = dwconsolid;
           this.fechamentoMes = fechamentoMes;
           this.resultadoEvento = resultadoEvento;
           this.sapestoque = sapestoque;
    }


    /**
     * Gets the ajustarEstoque value for this SapEstoqueDTO.
     * 
     * @return ajustarEstoque
     */
    public boolean isAjustarEstoque() {
        return ajustarEstoque;
    }


    /**
     * Sets the ajustarEstoque value for this SapEstoqueDTO.
     * 
     * @param ajustarEstoque
     */
    public void setAjustarEstoque(boolean ajustarEstoque) {
        this.ajustarEstoque = ajustarEstoque;
    }


    /**
     * Gets the dwconsolid value for this SapEstoqueDTO.
     * 
     * @return dwconsolid
     */
    public idw.idwws.DwConsolid getDwconsolid() {
        return dwconsolid;
    }


    /**
     * Sets the dwconsolid value for this SapEstoqueDTO.
     * 
     * @param dwconsolid
     */
    public void setDwconsolid(idw.idwws.DwConsolid dwconsolid) {
        this.dwconsolid = dwconsolid;
    }


    /**
     * Gets the fechamentoMes value for this SapEstoqueDTO.
     * 
     * @return fechamentoMes
     */
    public boolean isFechamentoMes() {
        return fechamentoMes;
    }


    /**
     * Sets the fechamentoMes value for this SapEstoqueDTO.
     * 
     * @param fechamentoMes
     */
    public void setFechamentoMes(boolean fechamentoMes) {
        this.fechamentoMes = fechamentoMes;
    }


    /**
     * Gets the resultadoEvento value for this SapEstoqueDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this SapEstoqueDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the sapestoque value for this SapEstoqueDTO.
     * 
     * @return sapestoque
     */
    public idw.idwws.TtSapEstmppa getSapestoque() {
        return sapestoque;
    }


    /**
     * Sets the sapestoque value for this SapEstoqueDTO.
     * 
     * @param sapestoque
     */
    public void setSapestoque(idw.idwws.TtSapEstmppa sapestoque) {
        this.sapestoque = sapestoque;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SapEstoqueDTO)) return false;
        SapEstoqueDTO other = (SapEstoqueDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ajustarEstoque == other.isAjustarEstoque() &&
            ((this.dwconsolid==null && other.getDwconsolid()==null) || 
             (this.dwconsolid!=null &&
              this.dwconsolid.equals(other.getDwconsolid()))) &&
            this.fechamentoMes == other.isFechamentoMes() &&
            this.resultadoEvento == other.getResultadoEvento() &&
            ((this.sapestoque==null && other.getSapestoque()==null) || 
             (this.sapestoque!=null &&
              this.sapestoque.equals(other.getSapestoque())));
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
        _hashCode += (isAjustarEstoque() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDwconsolid() != null) {
            _hashCode += getDwconsolid().hashCode();
        }
        _hashCode += (isFechamentoMes() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getResultadoEvento();
        if (getSapestoque() != null) {
            _hashCode += getSapestoque().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SapEstoqueDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "sapEstoqueDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ajustarEstoque");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ajustarEstoque"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwconsolid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwconsolid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechamentoMes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechamentoMes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sapestoque");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sapestoque"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ttSapEstmppa"));
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
