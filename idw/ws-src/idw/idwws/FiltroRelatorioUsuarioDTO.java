/**
 * FiltroRelatorioUsuarioDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class FiltroRelatorioUsuarioDTO  implements java.io.Serializable {
    private boolean adm;

    private boolean engenharia;

    private boolean gerencial;

    private boolean gt;

    private boolean manutencao;

    private boolean materiaprima;

    private boolean metrologia;

    private boolean montemporeal;

    private boolean operador;

    private boolean ordenarUsuario;

    public FiltroRelatorioUsuarioDTO() {
    }

    public FiltroRelatorioUsuarioDTO(
           boolean adm,
           boolean engenharia,
           boolean gerencial,
           boolean gt,
           boolean manutencao,
           boolean materiaprima,
           boolean metrologia,
           boolean montemporeal,
           boolean operador,
           boolean ordenarUsuario) {
           this.adm = adm;
           this.engenharia = engenharia;
           this.gerencial = gerencial;
           this.gt = gt;
           this.manutencao = manutencao;
           this.materiaprima = materiaprima;
           this.metrologia = metrologia;
           this.montemporeal = montemporeal;
           this.operador = operador;
           this.ordenarUsuario = ordenarUsuario;
    }


    /**
     * Gets the adm value for this FiltroRelatorioUsuarioDTO.
     * 
     * @return adm
     */
    public boolean isAdm() {
        return adm;
    }


    /**
     * Sets the adm value for this FiltroRelatorioUsuarioDTO.
     * 
     * @param adm
     */
    public void setAdm(boolean adm) {
        this.adm = adm;
    }


    /**
     * Gets the engenharia value for this FiltroRelatorioUsuarioDTO.
     * 
     * @return engenharia
     */
    public boolean isEngenharia() {
        return engenharia;
    }


    /**
     * Sets the engenharia value for this FiltroRelatorioUsuarioDTO.
     * 
     * @param engenharia
     */
    public void setEngenharia(boolean engenharia) {
        this.engenharia = engenharia;
    }


    /**
     * Gets the gerencial value for this FiltroRelatorioUsuarioDTO.
     * 
     * @return gerencial
     */
    public boolean isGerencial() {
        return gerencial;
    }


    /**
     * Sets the gerencial value for this FiltroRelatorioUsuarioDTO.
     * 
     * @param gerencial
     */
    public void setGerencial(boolean gerencial) {
        this.gerencial = gerencial;
    }


    /**
     * Gets the gt value for this FiltroRelatorioUsuarioDTO.
     * 
     * @return gt
     */
    public boolean isGt() {
        return gt;
    }


    /**
     * Sets the gt value for this FiltroRelatorioUsuarioDTO.
     * 
     * @param gt
     */
    public void setGt(boolean gt) {
        this.gt = gt;
    }


    /**
     * Gets the manutencao value for this FiltroRelatorioUsuarioDTO.
     * 
     * @return manutencao
     */
    public boolean isManutencao() {
        return manutencao;
    }


    /**
     * Sets the manutencao value for this FiltroRelatorioUsuarioDTO.
     * 
     * @param manutencao
     */
    public void setManutencao(boolean manutencao) {
        this.manutencao = manutencao;
    }


    /**
     * Gets the materiaprima value for this FiltroRelatorioUsuarioDTO.
     * 
     * @return materiaprima
     */
    public boolean isMateriaprima() {
        return materiaprima;
    }


    /**
     * Sets the materiaprima value for this FiltroRelatorioUsuarioDTO.
     * 
     * @param materiaprima
     */
    public void setMateriaprima(boolean materiaprima) {
        this.materiaprima = materiaprima;
    }


    /**
     * Gets the metrologia value for this FiltroRelatorioUsuarioDTO.
     * 
     * @return metrologia
     */
    public boolean isMetrologia() {
        return metrologia;
    }


    /**
     * Sets the metrologia value for this FiltroRelatorioUsuarioDTO.
     * 
     * @param metrologia
     */
    public void setMetrologia(boolean metrologia) {
        this.metrologia = metrologia;
    }


    /**
     * Gets the montemporeal value for this FiltroRelatorioUsuarioDTO.
     * 
     * @return montemporeal
     */
    public boolean isMontemporeal() {
        return montemporeal;
    }


    /**
     * Sets the montemporeal value for this FiltroRelatorioUsuarioDTO.
     * 
     * @param montemporeal
     */
    public void setMontemporeal(boolean montemporeal) {
        this.montemporeal = montemporeal;
    }


    /**
     * Gets the operador value for this FiltroRelatorioUsuarioDTO.
     * 
     * @return operador
     */
    public boolean isOperador() {
        return operador;
    }


    /**
     * Sets the operador value for this FiltroRelatorioUsuarioDTO.
     * 
     * @param operador
     */
    public void setOperador(boolean operador) {
        this.operador = operador;
    }


    /**
     * Gets the ordenarUsuario value for this FiltroRelatorioUsuarioDTO.
     * 
     * @return ordenarUsuario
     */
    public boolean isOrdenarUsuario() {
        return ordenarUsuario;
    }


    /**
     * Sets the ordenarUsuario value for this FiltroRelatorioUsuarioDTO.
     * 
     * @param ordenarUsuario
     */
    public void setOrdenarUsuario(boolean ordenarUsuario) {
        this.ordenarUsuario = ordenarUsuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FiltroRelatorioUsuarioDTO)) return false;
        FiltroRelatorioUsuarioDTO other = (FiltroRelatorioUsuarioDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.adm == other.isAdm() &&
            this.engenharia == other.isEngenharia() &&
            this.gerencial == other.isGerencial() &&
            this.gt == other.isGt() &&
            this.manutencao == other.isManutencao() &&
            this.materiaprima == other.isMateriaprima() &&
            this.metrologia == other.isMetrologia() &&
            this.montemporeal == other.isMontemporeal() &&
            this.operador == other.isOperador() &&
            this.ordenarUsuario == other.isOrdenarUsuario();
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
        _hashCode += (isAdm() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isEngenharia() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isGerencial() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isGt() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isManutencao() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isMateriaprima() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isMetrologia() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isMontemporeal() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isOperador() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isOrdenarUsuario() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FiltroRelatorioUsuarioDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "filtroRelatorioUsuarioDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "adm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("engenharia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "engenharia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gerencial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gerencial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("manutencao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "manutencao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("materiaprima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "materiaprima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metrologia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metrologia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("montemporeal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "montemporeal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordenarUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordenarUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
