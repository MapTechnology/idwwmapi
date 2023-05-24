/**
 * OmEmpresa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmEmpresa  extends idw.idwws.OmEmpresaTemplate  implements java.io.Serializable {
    private java.lang.String cdEmpresa;

    private java.lang.String cidade;

    private java.lang.String dsEmpresa;

    private java.lang.String endereco;

    private java.lang.String estado;

    private java.lang.Long idEmpresa;

    private idw.idwws.OmCfg[] omCfgs;

    private java.lang.String pais;

    public OmEmpresa() {
    }

    public OmEmpresa(
           java.lang.String cdEmpresa,
           java.lang.String cidade,
           java.lang.String dsEmpresa,
           java.lang.String endereco,
           java.lang.String estado,
           java.lang.Long idEmpresa,
           idw.idwws.OmCfg[] omCfgs,
           java.lang.String pais) {
        this.cdEmpresa = cdEmpresa;
        this.cidade = cidade;
        this.dsEmpresa = dsEmpresa;
        this.endereco = endereco;
        this.estado = estado;
        this.idEmpresa = idEmpresa;
        this.omCfgs = omCfgs;
        this.pais = pais;
    }


    /**
     * Gets the cdEmpresa value for this OmEmpresa.
     * 
     * @return cdEmpresa
     */
    public java.lang.String getCdEmpresa() {
        return cdEmpresa;
    }


    /**
     * Sets the cdEmpresa value for this OmEmpresa.
     * 
     * @param cdEmpresa
     */
    public void setCdEmpresa(java.lang.String cdEmpresa) {
        this.cdEmpresa = cdEmpresa;
    }


    /**
     * Gets the cidade value for this OmEmpresa.
     * 
     * @return cidade
     */
    public java.lang.String getCidade() {
        return cidade;
    }


    /**
     * Sets the cidade value for this OmEmpresa.
     * 
     * @param cidade
     */
    public void setCidade(java.lang.String cidade) {
        this.cidade = cidade;
    }


    /**
     * Gets the dsEmpresa value for this OmEmpresa.
     * 
     * @return dsEmpresa
     */
    public java.lang.String getDsEmpresa() {
        return dsEmpresa;
    }


    /**
     * Sets the dsEmpresa value for this OmEmpresa.
     * 
     * @param dsEmpresa
     */
    public void setDsEmpresa(java.lang.String dsEmpresa) {
        this.dsEmpresa = dsEmpresa;
    }


    /**
     * Gets the endereco value for this OmEmpresa.
     * 
     * @return endereco
     */
    public java.lang.String getEndereco() {
        return endereco;
    }


    /**
     * Sets the endereco value for this OmEmpresa.
     * 
     * @param endereco
     */
    public void setEndereco(java.lang.String endereco) {
        this.endereco = endereco;
    }


    /**
     * Gets the estado value for this OmEmpresa.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this OmEmpresa.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the idEmpresa value for this OmEmpresa.
     * 
     * @return idEmpresa
     */
    public java.lang.Long getIdEmpresa() {
        return idEmpresa;
    }


    /**
     * Sets the idEmpresa value for this OmEmpresa.
     * 
     * @param idEmpresa
     */
    public void setIdEmpresa(java.lang.Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }


    /**
     * Gets the omCfgs value for this OmEmpresa.
     * 
     * @return omCfgs
     */
    public idw.idwws.OmCfg[] getOmCfgs() {
        return omCfgs;
    }


    /**
     * Sets the omCfgs value for this OmEmpresa.
     * 
     * @param omCfgs
     */
    public void setOmCfgs(idw.idwws.OmCfg[] omCfgs) {
        this.omCfgs = omCfgs;
    }

    public idw.idwws.OmCfg getOmCfgs(int i) {
        return this.omCfgs[i];
    }

    public void setOmCfgs(int i, idw.idwws.OmCfg _value) {
        this.omCfgs[i] = _value;
    }


    /**
     * Gets the pais value for this OmEmpresa.
     * 
     * @return pais
     */
    public java.lang.String getPais() {
        return pais;
    }


    /**
     * Sets the pais value for this OmEmpresa.
     * 
     * @param pais
     */
    public void setPais(java.lang.String pais) {
        this.pais = pais;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmEmpresa)) return false;
        OmEmpresa other = (OmEmpresa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdEmpresa==null && other.getCdEmpresa()==null) || 
             (this.cdEmpresa!=null &&
              this.cdEmpresa.equals(other.getCdEmpresa()))) &&
            ((this.cidade==null && other.getCidade()==null) || 
             (this.cidade!=null &&
              this.cidade.equals(other.getCidade()))) &&
            ((this.dsEmpresa==null && other.getDsEmpresa()==null) || 
             (this.dsEmpresa!=null &&
              this.dsEmpresa.equals(other.getDsEmpresa()))) &&
            ((this.endereco==null && other.getEndereco()==null) || 
             (this.endereco!=null &&
              this.endereco.equals(other.getEndereco()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.idEmpresa==null && other.getIdEmpresa()==null) || 
             (this.idEmpresa!=null &&
              this.idEmpresa.equals(other.getIdEmpresa()))) &&
            ((this.omCfgs==null && other.getOmCfgs()==null) || 
             (this.omCfgs!=null &&
              java.util.Arrays.equals(this.omCfgs, other.getOmCfgs()))) &&
            ((this.pais==null && other.getPais()==null) || 
             (this.pais!=null &&
              this.pais.equals(other.getPais())));
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
        if (getCdEmpresa() != null) {
            _hashCode += getCdEmpresa().hashCode();
        }
        if (getCidade() != null) {
            _hashCode += getCidade().hashCode();
        }
        if (getDsEmpresa() != null) {
            _hashCode += getDsEmpresa().hashCode();
        }
        if (getEndereco() != null) {
            _hashCode += getEndereco().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getIdEmpresa() != null) {
            _hashCode += getIdEmpresa().hashCode();
        }
        if (getOmCfgs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPais() != null) {
            _hashCode += getPais().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmEmpresa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omEmpresa"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdEmpresa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdEmpresa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsEmpresa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsEmpresa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endereco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endereco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEmpresa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idEmpresa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pais");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pais"));
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
