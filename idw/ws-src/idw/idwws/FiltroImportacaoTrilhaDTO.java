/**
 * FiltroImportacaoTrilhaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class FiltroImportacaoTrilhaDTO  extends idw.idwws.FiltroExportacaoTrilhaDTO  implements java.io.Serializable {
    private idw.idwws.ArquivoTrilhaDTO arquivo;

    private idw.idwws.UsuarioDTO usuarioLogado;

    public FiltroImportacaoTrilhaDTO() {
    }

    public FiltroImportacaoTrilhaDTO(
           idw.idwws.PpPlano plano,
           idw.idwws.ArquivoTrilhaDTO arquivo,
           idw.idwws.UsuarioDTO usuarioLogado) {
        super(
            plano);
        this.arquivo = arquivo;
        this.usuarioLogado = usuarioLogado;
    }


    /**
     * Gets the arquivo value for this FiltroImportacaoTrilhaDTO.
     * 
     * @return arquivo
     */
    public idw.idwws.ArquivoTrilhaDTO getArquivo() {
        return arquivo;
    }


    /**
     * Sets the arquivo value for this FiltroImportacaoTrilhaDTO.
     * 
     * @param arquivo
     */
    public void setArquivo(idw.idwws.ArquivoTrilhaDTO arquivo) {
        this.arquivo = arquivo;
    }


    /**
     * Gets the usuarioLogado value for this FiltroImportacaoTrilhaDTO.
     * 
     * @return usuarioLogado
     */
    public idw.idwws.UsuarioDTO getUsuarioLogado() {
        return usuarioLogado;
    }


    /**
     * Sets the usuarioLogado value for this FiltroImportacaoTrilhaDTO.
     * 
     * @param usuarioLogado
     */
    public void setUsuarioLogado(idw.idwws.UsuarioDTO usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FiltroImportacaoTrilhaDTO)) return false;
        FiltroImportacaoTrilhaDTO other = (FiltroImportacaoTrilhaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.arquivo==null && other.getArquivo()==null) || 
             (this.arquivo!=null &&
              this.arquivo.equals(other.getArquivo()))) &&
            ((this.usuarioLogado==null && other.getUsuarioLogado()==null) || 
             (this.usuarioLogado!=null &&
              this.usuarioLogado.equals(other.getUsuarioLogado())));
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
        if (getArquivo() != null) {
            _hashCode += getArquivo().hashCode();
        }
        if (getUsuarioLogado() != null) {
            _hashCode += getUsuarioLogado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FiltroImportacaoTrilhaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "filtroImportacaoTrilhaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arquivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arquivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "arquivoTrilhaDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuarioLogado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "usuarioLogado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "usuarioDTO"));
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
