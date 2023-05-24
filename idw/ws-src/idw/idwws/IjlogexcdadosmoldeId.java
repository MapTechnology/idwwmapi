/**
 * IjlogexcdadosmoldeId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjlogexcdadosmoldeId  implements java.io.Serializable {
    private java.lang.String cdestrutura;

    private java.lang.String cdmolde;

    private java.lang.String cdusuario;

    private java.util.Calendar dthrlogexclusao;

    public IjlogexcdadosmoldeId() {
    }

    public IjlogexcdadosmoldeId(
           java.lang.String cdestrutura,
           java.lang.String cdmolde,
           java.lang.String cdusuario,
           java.util.Calendar dthrlogexclusao) {
           this.cdestrutura = cdestrutura;
           this.cdmolde = cdmolde;
           this.cdusuario = cdusuario;
           this.dthrlogexclusao = dthrlogexclusao;
    }


    /**
     * Gets the cdestrutura value for this IjlogexcdadosmoldeId.
     * 
     * @return cdestrutura
     */
    public java.lang.String getCdestrutura() {
        return cdestrutura;
    }


    /**
     * Sets the cdestrutura value for this IjlogexcdadosmoldeId.
     * 
     * @param cdestrutura
     */
    public void setCdestrutura(java.lang.String cdestrutura) {
        this.cdestrutura = cdestrutura;
    }


    /**
     * Gets the cdmolde value for this IjlogexcdadosmoldeId.
     * 
     * @return cdmolde
     */
    public java.lang.String getCdmolde() {
        return cdmolde;
    }


    /**
     * Sets the cdmolde value for this IjlogexcdadosmoldeId.
     * 
     * @param cdmolde
     */
    public void setCdmolde(java.lang.String cdmolde) {
        this.cdmolde = cdmolde;
    }


    /**
     * Gets the cdusuario value for this IjlogexcdadosmoldeId.
     * 
     * @return cdusuario
     */
    public java.lang.String getCdusuario() {
        return cdusuario;
    }


    /**
     * Sets the cdusuario value for this IjlogexcdadosmoldeId.
     * 
     * @param cdusuario
     */
    public void setCdusuario(java.lang.String cdusuario) {
        this.cdusuario = cdusuario;
    }


    /**
     * Gets the dthrlogexclusao value for this IjlogexcdadosmoldeId.
     * 
     * @return dthrlogexclusao
     */
    public java.util.Calendar getDthrlogexclusao() {
        return dthrlogexclusao;
    }


    /**
     * Sets the dthrlogexclusao value for this IjlogexcdadosmoldeId.
     * 
     * @param dthrlogexclusao
     */
    public void setDthrlogexclusao(java.util.Calendar dthrlogexclusao) {
        this.dthrlogexclusao = dthrlogexclusao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjlogexcdadosmoldeId)) return false;
        IjlogexcdadosmoldeId other = (IjlogexcdadosmoldeId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdestrutura==null && other.getCdestrutura()==null) || 
             (this.cdestrutura!=null &&
              this.cdestrutura.equals(other.getCdestrutura()))) &&
            ((this.cdmolde==null && other.getCdmolde()==null) || 
             (this.cdmolde!=null &&
              this.cdmolde.equals(other.getCdmolde()))) &&
            ((this.cdusuario==null && other.getCdusuario()==null) || 
             (this.cdusuario!=null &&
              this.cdusuario.equals(other.getCdusuario()))) &&
            ((this.dthrlogexclusao==null && other.getDthrlogexclusao()==null) || 
             (this.dthrlogexclusao!=null &&
              this.dthrlogexclusao.equals(other.getDthrlogexclusao())));
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
        if (getCdestrutura() != null) {
            _hashCode += getCdestrutura().hashCode();
        }
        if (getCdmolde() != null) {
            _hashCode += getCdmolde().hashCode();
        }
        if (getCdusuario() != null) {
            _hashCode += getCdusuario().hashCode();
        }
        if (getDthrlogexclusao() != null) {
            _hashCode += getDthrlogexclusao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjlogexcdadosmoldeId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlogexcdadosmoldeId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdestrutura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdestrutura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdusuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdusuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrlogexclusao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrlogexclusao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
