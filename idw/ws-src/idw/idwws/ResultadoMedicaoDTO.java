/**
 * ResultadoMedicaoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ResultadoMedicaoDTO  implements java.io.Serializable {
    private java.util.Calendar dthrMedicao;

    private long idParametroMedicao;

    private boolean medicaoPosFalha;

    private int statusMedidoFluxo;

    private double valorMedido;

    public ResultadoMedicaoDTO() {
    }

    public ResultadoMedicaoDTO(
           java.util.Calendar dthrMedicao,
           long idParametroMedicao,
           boolean medicaoPosFalha,
           int statusMedidoFluxo,
           double valorMedido) {
           this.dthrMedicao = dthrMedicao;
           this.idParametroMedicao = idParametroMedicao;
           this.medicaoPosFalha = medicaoPosFalha;
           this.statusMedidoFluxo = statusMedidoFluxo;
           this.valorMedido = valorMedido;
    }


    /**
     * Gets the dthrMedicao value for this ResultadoMedicaoDTO.
     * 
     * @return dthrMedicao
     */
    public java.util.Calendar getDthrMedicao() {
        return dthrMedicao;
    }


    /**
     * Sets the dthrMedicao value for this ResultadoMedicaoDTO.
     * 
     * @param dthrMedicao
     */
    public void setDthrMedicao(java.util.Calendar dthrMedicao) {
        this.dthrMedicao = dthrMedicao;
    }


    /**
     * Gets the idParametroMedicao value for this ResultadoMedicaoDTO.
     * 
     * @return idParametroMedicao
     */
    public long getIdParametroMedicao() {
        return idParametroMedicao;
    }


    /**
     * Sets the idParametroMedicao value for this ResultadoMedicaoDTO.
     * 
     * @param idParametroMedicao
     */
    public void setIdParametroMedicao(long idParametroMedicao) {
        this.idParametroMedicao = idParametroMedicao;
    }


    /**
     * Gets the medicaoPosFalha value for this ResultadoMedicaoDTO.
     * 
     * @return medicaoPosFalha
     */
    public boolean isMedicaoPosFalha() {
        return medicaoPosFalha;
    }


    /**
     * Sets the medicaoPosFalha value for this ResultadoMedicaoDTO.
     * 
     * @param medicaoPosFalha
     */
    public void setMedicaoPosFalha(boolean medicaoPosFalha) {
        this.medicaoPosFalha = medicaoPosFalha;
    }


    /**
     * Gets the statusMedidoFluxo value for this ResultadoMedicaoDTO.
     * 
     * @return statusMedidoFluxo
     */
    public int getStatusMedidoFluxo() {
        return statusMedidoFluxo;
    }


    /**
     * Sets the statusMedidoFluxo value for this ResultadoMedicaoDTO.
     * 
     * @param statusMedidoFluxo
     */
    public void setStatusMedidoFluxo(int statusMedidoFluxo) {
        this.statusMedidoFluxo = statusMedidoFluxo;
    }


    /**
     * Gets the valorMedido value for this ResultadoMedicaoDTO.
     * 
     * @return valorMedido
     */
    public double getValorMedido() {
        return valorMedido;
    }


    /**
     * Sets the valorMedido value for this ResultadoMedicaoDTO.
     * 
     * @param valorMedido
     */
    public void setValorMedido(double valorMedido) {
        this.valorMedido = valorMedido;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResultadoMedicaoDTO)) return false;
        ResultadoMedicaoDTO other = (ResultadoMedicaoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrMedicao==null && other.getDthrMedicao()==null) || 
             (this.dthrMedicao!=null &&
              this.dthrMedicao.equals(other.getDthrMedicao()))) &&
            this.idParametroMedicao == other.getIdParametroMedicao() &&
            this.medicaoPosFalha == other.isMedicaoPosFalha() &&
            this.statusMedidoFluxo == other.getStatusMedidoFluxo() &&
            this.valorMedido == other.getValorMedido();
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
        if (getDthrMedicao() != null) {
            _hashCode += getDthrMedicao().hashCode();
        }
        _hashCode += new Long(getIdParametroMedicao()).hashCode();
        _hashCode += (isMedicaoPosFalha() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getStatusMedidoFluxo();
        _hashCode += new Double(getValorMedido()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResultadoMedicaoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoMedicaoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrMedicao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrMedicao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idParametroMedicao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idParametroMedicao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("medicaoPosFalha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "medicaoPosFalha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statusMedidoFluxo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "statusMedidoFluxo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorMedido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valorMedido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
