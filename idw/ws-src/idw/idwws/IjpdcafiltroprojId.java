/**
 * IjpdcafiltroprojId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjpdcafiltroprojId  implements java.io.Serializable {
    private java.lang.String conteudofiltro;

    private java.lang.String idfiltro;

    private java.lang.String nrprojeto;

    public IjpdcafiltroprojId() {
    }

    public IjpdcafiltroprojId(
           java.lang.String conteudofiltro,
           java.lang.String idfiltro,
           java.lang.String nrprojeto) {
           this.conteudofiltro = conteudofiltro;
           this.idfiltro = idfiltro;
           this.nrprojeto = nrprojeto;
    }


    /**
     * Gets the conteudofiltro value for this IjpdcafiltroprojId.
     * 
     * @return conteudofiltro
     */
    public java.lang.String getConteudofiltro() {
        return conteudofiltro;
    }


    /**
     * Sets the conteudofiltro value for this IjpdcafiltroprojId.
     * 
     * @param conteudofiltro
     */
    public void setConteudofiltro(java.lang.String conteudofiltro) {
        this.conteudofiltro = conteudofiltro;
    }


    /**
     * Gets the idfiltro value for this IjpdcafiltroprojId.
     * 
     * @return idfiltro
     */
    public java.lang.String getIdfiltro() {
        return idfiltro;
    }


    /**
     * Sets the idfiltro value for this IjpdcafiltroprojId.
     * 
     * @param idfiltro
     */
    public void setIdfiltro(java.lang.String idfiltro) {
        this.idfiltro = idfiltro;
    }


    /**
     * Gets the nrprojeto value for this IjpdcafiltroprojId.
     * 
     * @return nrprojeto
     */
    public java.lang.String getNrprojeto() {
        return nrprojeto;
    }


    /**
     * Sets the nrprojeto value for this IjpdcafiltroprojId.
     * 
     * @param nrprojeto
     */
    public void setNrprojeto(java.lang.String nrprojeto) {
        this.nrprojeto = nrprojeto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjpdcafiltroprojId)) return false;
        IjpdcafiltroprojId other = (IjpdcafiltroprojId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.conteudofiltro==null && other.getConteudofiltro()==null) || 
             (this.conteudofiltro!=null &&
              this.conteudofiltro.equals(other.getConteudofiltro()))) &&
            ((this.idfiltro==null && other.getIdfiltro()==null) || 
             (this.idfiltro!=null &&
              this.idfiltro.equals(other.getIdfiltro()))) &&
            ((this.nrprojeto==null && other.getNrprojeto()==null) || 
             (this.nrprojeto!=null &&
              this.nrprojeto.equals(other.getNrprojeto())));
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
        if (getConteudofiltro() != null) {
            _hashCode += getConteudofiltro().hashCode();
        }
        if (getIdfiltro() != null) {
            _hashCode += getIdfiltro().hashCode();
        }
        if (getNrprojeto() != null) {
            _hashCode += getNrprojeto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjpdcafiltroprojId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcafiltroprojId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conteudofiltro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "conteudofiltro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idfiltro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idfiltro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrprojeto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrprojeto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
