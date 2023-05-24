/**
 * UsuarioCODTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class UsuarioCODTO  implements java.io.Serializable {
    private java.lang.String apelido;

    private java.lang.String dthrServidor;

    private long idUsuario;

    private java.lang.Boolean isAutorizado;

    private java.lang.String matricula;

    public UsuarioCODTO() {
    }

    public UsuarioCODTO(
           java.lang.String apelido,
           java.lang.String dthrServidor,
           long idUsuario,
           java.lang.Boolean isAutorizado,
           java.lang.String matricula) {
           this.apelido = apelido;
           this.dthrServidor = dthrServidor;
           this.idUsuario = idUsuario;
           this.isAutorizado = isAutorizado;
           this.matricula = matricula;
    }


    /**
     * Gets the apelido value for this UsuarioCODTO.
     * 
     * @return apelido
     */
    public java.lang.String getApelido() {
        return apelido;
    }


    /**
     * Sets the apelido value for this UsuarioCODTO.
     * 
     * @param apelido
     */
    public void setApelido(java.lang.String apelido) {
        this.apelido = apelido;
    }


    /**
     * Gets the dthrServidor value for this UsuarioCODTO.
     * 
     * @return dthrServidor
     */
    public java.lang.String getDthrServidor() {
        return dthrServidor;
    }


    /**
     * Sets the dthrServidor value for this UsuarioCODTO.
     * 
     * @param dthrServidor
     */
    public void setDthrServidor(java.lang.String dthrServidor) {
        this.dthrServidor = dthrServidor;
    }


    /**
     * Gets the idUsuario value for this UsuarioCODTO.
     * 
     * @return idUsuario
     */
    public long getIdUsuario() {
        return idUsuario;
    }


    /**
     * Sets the idUsuario value for this UsuarioCODTO.
     * 
     * @param idUsuario
     */
    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }


    /**
     * Gets the isAutorizado value for this UsuarioCODTO.
     * 
     * @return isAutorizado
     */
    public java.lang.Boolean getIsAutorizado() {
        return isAutorizado;
    }


    /**
     * Sets the isAutorizado value for this UsuarioCODTO.
     * 
     * @param isAutorizado
     */
    public void setIsAutorizado(java.lang.Boolean isAutorizado) {
        this.isAutorizado = isAutorizado;
    }


    /**
     * Gets the matricula value for this UsuarioCODTO.
     * 
     * @return matricula
     */
    public java.lang.String getMatricula() {
        return matricula;
    }


    /**
     * Sets the matricula value for this UsuarioCODTO.
     * 
     * @param matricula
     */
    public void setMatricula(java.lang.String matricula) {
        this.matricula = matricula;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UsuarioCODTO)) return false;
        UsuarioCODTO other = (UsuarioCODTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.apelido==null && other.getApelido()==null) || 
             (this.apelido!=null &&
              this.apelido.equals(other.getApelido()))) &&
            ((this.dthrServidor==null && other.getDthrServidor()==null) || 
             (this.dthrServidor!=null &&
              this.dthrServidor.equals(other.getDthrServidor()))) &&
            this.idUsuario == other.getIdUsuario() &&
            ((this.isAutorizado==null && other.getIsAutorizado()==null) || 
             (this.isAutorizado!=null &&
              this.isAutorizado.equals(other.getIsAutorizado()))) &&
            ((this.matricula==null && other.getMatricula()==null) || 
             (this.matricula!=null &&
              this.matricula.equals(other.getMatricula())));
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
        if (getApelido() != null) {
            _hashCode += getApelido().hashCode();
        }
        if (getDthrServidor() != null) {
            _hashCode += getDthrServidor().hashCode();
        }
        _hashCode += new Long(getIdUsuario()).hashCode();
        if (getIsAutorizado() != null) {
            _hashCode += getIsAutorizado().hashCode();
        }
        if (getMatricula() != null) {
            _hashCode += getMatricula().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UsuarioCODTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "usuarioCODTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apelido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "apelido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrServidor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrServidor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAutorizado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isAutorizado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matricula");
        elemField.setXmlName(new javax.xml.namespace.QName("", "matricula"));
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
