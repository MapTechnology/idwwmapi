/**
 * IwsVariacaoRitmoValidaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IwsVariacaoRitmoValidaDTO  implements java.io.Serializable {
    private java.lang.String cdVariacaoRitmo;

    private java.lang.String dsVariacaoRitmo;

    private java.lang.Boolean isVariacaoValida;

    private java.lang.Integer limitePercentual;

    private long quantidade;

    public IwsVariacaoRitmoValidaDTO() {
    }

    public IwsVariacaoRitmoValidaDTO(
           java.lang.String cdVariacaoRitmo,
           java.lang.String dsVariacaoRitmo,
           java.lang.Boolean isVariacaoValida,
           java.lang.Integer limitePercentual,
           long quantidade) {
           this.cdVariacaoRitmo = cdVariacaoRitmo;
           this.dsVariacaoRitmo = dsVariacaoRitmo;
           this.isVariacaoValida = isVariacaoValida;
           this.limitePercentual = limitePercentual;
           this.quantidade = quantidade;
    }


    /**
     * Gets the cdVariacaoRitmo value for this IwsVariacaoRitmoValidaDTO.
     * 
     * @return cdVariacaoRitmo
     */
    public java.lang.String getCdVariacaoRitmo() {
        return cdVariacaoRitmo;
    }


    /**
     * Sets the cdVariacaoRitmo value for this IwsVariacaoRitmoValidaDTO.
     * 
     * @param cdVariacaoRitmo
     */
    public void setCdVariacaoRitmo(java.lang.String cdVariacaoRitmo) {
        this.cdVariacaoRitmo = cdVariacaoRitmo;
    }


    /**
     * Gets the dsVariacaoRitmo value for this IwsVariacaoRitmoValidaDTO.
     * 
     * @return dsVariacaoRitmo
     */
    public java.lang.String getDsVariacaoRitmo() {
        return dsVariacaoRitmo;
    }


    /**
     * Sets the dsVariacaoRitmo value for this IwsVariacaoRitmoValidaDTO.
     * 
     * @param dsVariacaoRitmo
     */
    public void setDsVariacaoRitmo(java.lang.String dsVariacaoRitmo) {
        this.dsVariacaoRitmo = dsVariacaoRitmo;
    }


    /**
     * Gets the isVariacaoValida value for this IwsVariacaoRitmoValidaDTO.
     * 
     * @return isVariacaoValida
     */
    public java.lang.Boolean getIsVariacaoValida() {
        return isVariacaoValida;
    }


    /**
     * Sets the isVariacaoValida value for this IwsVariacaoRitmoValidaDTO.
     * 
     * @param isVariacaoValida
     */
    public void setIsVariacaoValida(java.lang.Boolean isVariacaoValida) {
        this.isVariacaoValida = isVariacaoValida;
    }


    /**
     * Gets the limitePercentual value for this IwsVariacaoRitmoValidaDTO.
     * 
     * @return limitePercentual
     */
    public java.lang.Integer getLimitePercentual() {
        return limitePercentual;
    }


    /**
     * Sets the limitePercentual value for this IwsVariacaoRitmoValidaDTO.
     * 
     * @param limitePercentual
     */
    public void setLimitePercentual(java.lang.Integer limitePercentual) {
        this.limitePercentual = limitePercentual;
    }


    /**
     * Gets the quantidade value for this IwsVariacaoRitmoValidaDTO.
     * 
     * @return quantidade
     */
    public long getQuantidade() {
        return quantidade;
    }


    /**
     * Sets the quantidade value for this IwsVariacaoRitmoValidaDTO.
     * 
     * @param quantidade
     */
    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IwsVariacaoRitmoValidaDTO)) return false;
        IwsVariacaoRitmoValidaDTO other = (IwsVariacaoRitmoValidaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdVariacaoRitmo==null && other.getCdVariacaoRitmo()==null) || 
             (this.cdVariacaoRitmo!=null &&
              this.cdVariacaoRitmo.equals(other.getCdVariacaoRitmo()))) &&
            ((this.dsVariacaoRitmo==null && other.getDsVariacaoRitmo()==null) || 
             (this.dsVariacaoRitmo!=null &&
              this.dsVariacaoRitmo.equals(other.getDsVariacaoRitmo()))) &&
            ((this.isVariacaoValida==null && other.getIsVariacaoValida()==null) || 
             (this.isVariacaoValida!=null &&
              this.isVariacaoValida.equals(other.getIsVariacaoValida()))) &&
            ((this.limitePercentual==null && other.getLimitePercentual()==null) || 
             (this.limitePercentual!=null &&
              this.limitePercentual.equals(other.getLimitePercentual()))) &&
            this.quantidade == other.getQuantidade();
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
        if (getCdVariacaoRitmo() != null) {
            _hashCode += getCdVariacaoRitmo().hashCode();
        }
        if (getDsVariacaoRitmo() != null) {
            _hashCode += getDsVariacaoRitmo().hashCode();
        }
        if (getIsVariacaoValida() != null) {
            _hashCode += getIsVariacaoValida().hashCode();
        }
        if (getLimitePercentual() != null) {
            _hashCode += getLimitePercentual().hashCode();
        }
        _hashCode += new Long(getQuantidade()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IwsVariacaoRitmoValidaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "iwsVariacaoRitmoValidaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdVariacaoRitmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdVariacaoRitmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsVariacaoRitmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsVariacaoRitmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isVariacaoValida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isVariacaoValida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limitePercentual");
        elemField.setXmlName(new javax.xml.namespace.QName("", "limitePercentual"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quantidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
