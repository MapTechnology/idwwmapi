/**
 * DetalheAnaliseGargaloDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DetalheAnaliseGargaloDTO  implements java.io.Serializable {
    private idw.idwws.ListaIndicadoresPtDTO listaIndicadoresPt;

    private idw.idwws.ListaIndicadoresPtDTO listaIndicadoresPtGargaloDinamico;

    private idw.idwws.ListaIndicadoresPtDTO listaIndicadoresPtGargaloTeorico;

    private idw.idwws.ListaIndicadoresPtDTO listaIndicadoresPtSaida;

    public DetalheAnaliseGargaloDTO() {
    }

    public DetalheAnaliseGargaloDTO(
           idw.idwws.ListaIndicadoresPtDTO listaIndicadoresPt,
           idw.idwws.ListaIndicadoresPtDTO listaIndicadoresPtGargaloDinamico,
           idw.idwws.ListaIndicadoresPtDTO listaIndicadoresPtGargaloTeorico,
           idw.idwws.ListaIndicadoresPtDTO listaIndicadoresPtSaida) {
           this.listaIndicadoresPt = listaIndicadoresPt;
           this.listaIndicadoresPtGargaloDinamico = listaIndicadoresPtGargaloDinamico;
           this.listaIndicadoresPtGargaloTeorico = listaIndicadoresPtGargaloTeorico;
           this.listaIndicadoresPtSaida = listaIndicadoresPtSaida;
    }


    /**
     * Gets the listaIndicadoresPt value for this DetalheAnaliseGargaloDTO.
     * 
     * @return listaIndicadoresPt
     */
    public idw.idwws.ListaIndicadoresPtDTO getListaIndicadoresPt() {
        return listaIndicadoresPt;
    }


    /**
     * Sets the listaIndicadoresPt value for this DetalheAnaliseGargaloDTO.
     * 
     * @param listaIndicadoresPt
     */
    public void setListaIndicadoresPt(idw.idwws.ListaIndicadoresPtDTO listaIndicadoresPt) {
        this.listaIndicadoresPt = listaIndicadoresPt;
    }


    /**
     * Gets the listaIndicadoresPtGargaloDinamico value for this DetalheAnaliseGargaloDTO.
     * 
     * @return listaIndicadoresPtGargaloDinamico
     */
    public idw.idwws.ListaIndicadoresPtDTO getListaIndicadoresPtGargaloDinamico() {
        return listaIndicadoresPtGargaloDinamico;
    }


    /**
     * Sets the listaIndicadoresPtGargaloDinamico value for this DetalheAnaliseGargaloDTO.
     * 
     * @param listaIndicadoresPtGargaloDinamico
     */
    public void setListaIndicadoresPtGargaloDinamico(idw.idwws.ListaIndicadoresPtDTO listaIndicadoresPtGargaloDinamico) {
        this.listaIndicadoresPtGargaloDinamico = listaIndicadoresPtGargaloDinamico;
    }


    /**
     * Gets the listaIndicadoresPtGargaloTeorico value for this DetalheAnaliseGargaloDTO.
     * 
     * @return listaIndicadoresPtGargaloTeorico
     */
    public idw.idwws.ListaIndicadoresPtDTO getListaIndicadoresPtGargaloTeorico() {
        return listaIndicadoresPtGargaloTeorico;
    }


    /**
     * Sets the listaIndicadoresPtGargaloTeorico value for this DetalheAnaliseGargaloDTO.
     * 
     * @param listaIndicadoresPtGargaloTeorico
     */
    public void setListaIndicadoresPtGargaloTeorico(idw.idwws.ListaIndicadoresPtDTO listaIndicadoresPtGargaloTeorico) {
        this.listaIndicadoresPtGargaloTeorico = listaIndicadoresPtGargaloTeorico;
    }


    /**
     * Gets the listaIndicadoresPtSaida value for this DetalheAnaliseGargaloDTO.
     * 
     * @return listaIndicadoresPtSaida
     */
    public idw.idwws.ListaIndicadoresPtDTO getListaIndicadoresPtSaida() {
        return listaIndicadoresPtSaida;
    }


    /**
     * Sets the listaIndicadoresPtSaida value for this DetalheAnaliseGargaloDTO.
     * 
     * @param listaIndicadoresPtSaida
     */
    public void setListaIndicadoresPtSaida(idw.idwws.ListaIndicadoresPtDTO listaIndicadoresPtSaida) {
        this.listaIndicadoresPtSaida = listaIndicadoresPtSaida;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DetalheAnaliseGargaloDTO)) return false;
        DetalheAnaliseGargaloDTO other = (DetalheAnaliseGargaloDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listaIndicadoresPt==null && other.getListaIndicadoresPt()==null) || 
             (this.listaIndicadoresPt!=null &&
              this.listaIndicadoresPt.equals(other.getListaIndicadoresPt()))) &&
            ((this.listaIndicadoresPtGargaloDinamico==null && other.getListaIndicadoresPtGargaloDinamico()==null) || 
             (this.listaIndicadoresPtGargaloDinamico!=null &&
              this.listaIndicadoresPtGargaloDinamico.equals(other.getListaIndicadoresPtGargaloDinamico()))) &&
            ((this.listaIndicadoresPtGargaloTeorico==null && other.getListaIndicadoresPtGargaloTeorico()==null) || 
             (this.listaIndicadoresPtGargaloTeorico!=null &&
              this.listaIndicadoresPtGargaloTeorico.equals(other.getListaIndicadoresPtGargaloTeorico()))) &&
            ((this.listaIndicadoresPtSaida==null && other.getListaIndicadoresPtSaida()==null) || 
             (this.listaIndicadoresPtSaida!=null &&
              this.listaIndicadoresPtSaida.equals(other.getListaIndicadoresPtSaida())));
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
        if (getListaIndicadoresPt() != null) {
            _hashCode += getListaIndicadoresPt().hashCode();
        }
        if (getListaIndicadoresPtGargaloDinamico() != null) {
            _hashCode += getListaIndicadoresPtGargaloDinamico().hashCode();
        }
        if (getListaIndicadoresPtGargaloTeorico() != null) {
            _hashCode += getListaIndicadoresPtGargaloTeorico().hashCode();
        }
        if (getListaIndicadoresPtSaida() != null) {
            _hashCode += getListaIndicadoresPtSaida().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DetalheAnaliseGargaloDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalheAnaliseGargaloDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaIndicadoresPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaIndicadoresPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "listaIndicadoresPtDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaIndicadoresPtGargaloDinamico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaIndicadoresPtGargaloDinamico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "listaIndicadoresPtDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaIndicadoresPtGargaloTeorico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaIndicadoresPtGargaloTeorico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "listaIndicadoresPtDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaIndicadoresPtSaida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaIndicadoresPtSaida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "listaIndicadoresPtDTO"));
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
