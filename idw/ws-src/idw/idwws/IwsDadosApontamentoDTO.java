/**
 * IwsDadosApontamentoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IwsDadosApontamentoDTO  implements java.io.Serializable {
    private boolean deveInformarApont;

    private java.lang.String infoAdicional;

    private idw.idwws.IwsVariacaoRitmoValidaDTO[] listaVariacoes;

    public IwsDadosApontamentoDTO() {
    }

    public IwsDadosApontamentoDTO(
           boolean deveInformarApont,
           java.lang.String infoAdicional,
           idw.idwws.IwsVariacaoRitmoValidaDTO[] listaVariacoes) {
           this.deveInformarApont = deveInformarApont;
           this.infoAdicional = infoAdicional;
           this.listaVariacoes = listaVariacoes;
    }


    /**
     * Gets the deveInformarApont value for this IwsDadosApontamentoDTO.
     * 
     * @return deveInformarApont
     */
    public boolean isDeveInformarApont() {
        return deveInformarApont;
    }


    /**
     * Sets the deveInformarApont value for this IwsDadosApontamentoDTO.
     * 
     * @param deveInformarApont
     */
    public void setDeveInformarApont(boolean deveInformarApont) {
        this.deveInformarApont = deveInformarApont;
    }


    /**
     * Gets the infoAdicional value for this IwsDadosApontamentoDTO.
     * 
     * @return infoAdicional
     */
    public java.lang.String getInfoAdicional() {
        return infoAdicional;
    }


    /**
     * Sets the infoAdicional value for this IwsDadosApontamentoDTO.
     * 
     * @param infoAdicional
     */
    public void setInfoAdicional(java.lang.String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }


    /**
     * Gets the listaVariacoes value for this IwsDadosApontamentoDTO.
     * 
     * @return listaVariacoes
     */
    public idw.idwws.IwsVariacaoRitmoValidaDTO[] getListaVariacoes() {
        return listaVariacoes;
    }


    /**
     * Sets the listaVariacoes value for this IwsDadosApontamentoDTO.
     * 
     * @param listaVariacoes
     */
    public void setListaVariacoes(idw.idwws.IwsVariacaoRitmoValidaDTO[] listaVariacoes) {
        this.listaVariacoes = listaVariacoes;
    }

    public idw.idwws.IwsVariacaoRitmoValidaDTO getListaVariacoes(int i) {
        return this.listaVariacoes[i];
    }

    public void setListaVariacoes(int i, idw.idwws.IwsVariacaoRitmoValidaDTO _value) {
        this.listaVariacoes[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IwsDadosApontamentoDTO)) return false;
        IwsDadosApontamentoDTO other = (IwsDadosApontamentoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.deveInformarApont == other.isDeveInformarApont() &&
            ((this.infoAdicional==null && other.getInfoAdicional()==null) || 
             (this.infoAdicional!=null &&
              this.infoAdicional.equals(other.getInfoAdicional()))) &&
            ((this.listaVariacoes==null && other.getListaVariacoes()==null) || 
             (this.listaVariacoes!=null &&
              java.util.Arrays.equals(this.listaVariacoes, other.getListaVariacoes())));
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
        _hashCode += (isDeveInformarApont() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getInfoAdicional() != null) {
            _hashCode += getInfoAdicional().hashCode();
        }
        if (getListaVariacoes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaVariacoes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaVariacoes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IwsDadosApontamentoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "iwsDadosApontamentoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deveInformarApont");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deveInformarApont"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("infoAdicional");
        elemField.setXmlName(new javax.xml.namespace.QName("", "infoAdicional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaVariacoes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaVariacoes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "iwsVariacaoRitmoValidaDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
