/**
 * Ijgrpinj.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgrpinj  implements java.io.Serializable {
    private java.lang.String cdgrpinj;

    private java.lang.String dsgrpinj;

    private idw.idwws.Ijgrpdetinj[] ijgrpdetinjs;

    private java.lang.Double metaatendimento;

    private java.lang.Double metaeficiencia;

    private java.lang.Double metaefisetup;

    private java.lang.Double metappmil;

    private java.lang.Double metaprodutividade;

    private java.lang.Double metautilizacao;

    public Ijgrpinj() {
    }

    public Ijgrpinj(
           java.lang.String cdgrpinj,
           java.lang.String dsgrpinj,
           idw.idwws.Ijgrpdetinj[] ijgrpdetinjs,
           java.lang.Double metaatendimento,
           java.lang.Double metaeficiencia,
           java.lang.Double metaefisetup,
           java.lang.Double metappmil,
           java.lang.Double metaprodutividade,
           java.lang.Double metautilizacao) {
           this.cdgrpinj = cdgrpinj;
           this.dsgrpinj = dsgrpinj;
           this.ijgrpdetinjs = ijgrpdetinjs;
           this.metaatendimento = metaatendimento;
           this.metaeficiencia = metaeficiencia;
           this.metaefisetup = metaefisetup;
           this.metappmil = metappmil;
           this.metaprodutividade = metaprodutividade;
           this.metautilizacao = metautilizacao;
    }


    /**
     * Gets the cdgrpinj value for this Ijgrpinj.
     * 
     * @return cdgrpinj
     */
    public java.lang.String getCdgrpinj() {
        return cdgrpinj;
    }


    /**
     * Sets the cdgrpinj value for this Ijgrpinj.
     * 
     * @param cdgrpinj
     */
    public void setCdgrpinj(java.lang.String cdgrpinj) {
        this.cdgrpinj = cdgrpinj;
    }


    /**
     * Gets the dsgrpinj value for this Ijgrpinj.
     * 
     * @return dsgrpinj
     */
    public java.lang.String getDsgrpinj() {
        return dsgrpinj;
    }


    /**
     * Sets the dsgrpinj value for this Ijgrpinj.
     * 
     * @param dsgrpinj
     */
    public void setDsgrpinj(java.lang.String dsgrpinj) {
        this.dsgrpinj = dsgrpinj;
    }


    /**
     * Gets the ijgrpdetinjs value for this Ijgrpinj.
     * 
     * @return ijgrpdetinjs
     */
    public idw.idwws.Ijgrpdetinj[] getIjgrpdetinjs() {
        return ijgrpdetinjs;
    }


    /**
     * Sets the ijgrpdetinjs value for this Ijgrpinj.
     * 
     * @param ijgrpdetinjs
     */
    public void setIjgrpdetinjs(idw.idwws.Ijgrpdetinj[] ijgrpdetinjs) {
        this.ijgrpdetinjs = ijgrpdetinjs;
    }

    public idw.idwws.Ijgrpdetinj getIjgrpdetinjs(int i) {
        return this.ijgrpdetinjs[i];
    }

    public void setIjgrpdetinjs(int i, idw.idwws.Ijgrpdetinj _value) {
        this.ijgrpdetinjs[i] = _value;
    }


    /**
     * Gets the metaatendimento value for this Ijgrpinj.
     * 
     * @return metaatendimento
     */
    public java.lang.Double getMetaatendimento() {
        return metaatendimento;
    }


    /**
     * Sets the metaatendimento value for this Ijgrpinj.
     * 
     * @param metaatendimento
     */
    public void setMetaatendimento(java.lang.Double metaatendimento) {
        this.metaatendimento = metaatendimento;
    }


    /**
     * Gets the metaeficiencia value for this Ijgrpinj.
     * 
     * @return metaeficiencia
     */
    public java.lang.Double getMetaeficiencia() {
        return metaeficiencia;
    }


    /**
     * Sets the metaeficiencia value for this Ijgrpinj.
     * 
     * @param metaeficiencia
     */
    public void setMetaeficiencia(java.lang.Double metaeficiencia) {
        this.metaeficiencia = metaeficiencia;
    }


    /**
     * Gets the metaefisetup value for this Ijgrpinj.
     * 
     * @return metaefisetup
     */
    public java.lang.Double getMetaefisetup() {
        return metaefisetup;
    }


    /**
     * Sets the metaefisetup value for this Ijgrpinj.
     * 
     * @param metaefisetup
     */
    public void setMetaefisetup(java.lang.Double metaefisetup) {
        this.metaefisetup = metaefisetup;
    }


    /**
     * Gets the metappmil value for this Ijgrpinj.
     * 
     * @return metappmil
     */
    public java.lang.Double getMetappmil() {
        return metappmil;
    }


    /**
     * Sets the metappmil value for this Ijgrpinj.
     * 
     * @param metappmil
     */
    public void setMetappmil(java.lang.Double metappmil) {
        this.metappmil = metappmil;
    }


    /**
     * Gets the metaprodutividade value for this Ijgrpinj.
     * 
     * @return metaprodutividade
     */
    public java.lang.Double getMetaprodutividade() {
        return metaprodutividade;
    }


    /**
     * Sets the metaprodutividade value for this Ijgrpinj.
     * 
     * @param metaprodutividade
     */
    public void setMetaprodutividade(java.lang.Double metaprodutividade) {
        this.metaprodutividade = metaprodutividade;
    }


    /**
     * Gets the metautilizacao value for this Ijgrpinj.
     * 
     * @return metautilizacao
     */
    public java.lang.Double getMetautilizacao() {
        return metautilizacao;
    }


    /**
     * Sets the metautilizacao value for this Ijgrpinj.
     * 
     * @param metautilizacao
     */
    public void setMetautilizacao(java.lang.Double metautilizacao) {
        this.metautilizacao = metautilizacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgrpinj)) return false;
        Ijgrpinj other = (Ijgrpinj) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgrpinj==null && other.getCdgrpinj()==null) || 
             (this.cdgrpinj!=null &&
              this.cdgrpinj.equals(other.getCdgrpinj()))) &&
            ((this.dsgrpinj==null && other.getDsgrpinj()==null) || 
             (this.dsgrpinj!=null &&
              this.dsgrpinj.equals(other.getDsgrpinj()))) &&
            ((this.ijgrpdetinjs==null && other.getIjgrpdetinjs()==null) || 
             (this.ijgrpdetinjs!=null &&
              java.util.Arrays.equals(this.ijgrpdetinjs, other.getIjgrpdetinjs()))) &&
            ((this.metaatendimento==null && other.getMetaatendimento()==null) || 
             (this.metaatendimento!=null &&
              this.metaatendimento.equals(other.getMetaatendimento()))) &&
            ((this.metaeficiencia==null && other.getMetaeficiencia()==null) || 
             (this.metaeficiencia!=null &&
              this.metaeficiencia.equals(other.getMetaeficiencia()))) &&
            ((this.metaefisetup==null && other.getMetaefisetup()==null) || 
             (this.metaefisetup!=null &&
              this.metaefisetup.equals(other.getMetaefisetup()))) &&
            ((this.metappmil==null && other.getMetappmil()==null) || 
             (this.metappmil!=null &&
              this.metappmil.equals(other.getMetappmil()))) &&
            ((this.metaprodutividade==null && other.getMetaprodutividade()==null) || 
             (this.metaprodutividade!=null &&
              this.metaprodutividade.equals(other.getMetaprodutividade()))) &&
            ((this.metautilizacao==null && other.getMetautilizacao()==null) || 
             (this.metautilizacao!=null &&
              this.metautilizacao.equals(other.getMetautilizacao())));
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
        if (getCdgrpinj() != null) {
            _hashCode += getCdgrpinj().hashCode();
        }
        if (getDsgrpinj() != null) {
            _hashCode += getDsgrpinj().hashCode();
        }
        if (getIjgrpdetinjs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpdetinjs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpdetinjs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMetaatendimento() != null) {
            _hashCode += getMetaatendimento().hashCode();
        }
        if (getMetaeficiencia() != null) {
            _hashCode += getMetaeficiencia().hashCode();
        }
        if (getMetaefisetup() != null) {
            _hashCode += getMetaefisetup().hashCode();
        }
        if (getMetappmil() != null) {
            _hashCode += getMetappmil().hashCode();
        }
        if (getMetaprodutividade() != null) {
            _hashCode += getMetaprodutividade().hashCode();
        }
        if (getMetautilizacao() != null) {
            _hashCode += getMetautilizacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgrpinj.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpinj"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgrpinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgrpinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsgrpinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsgrpinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpdetinjs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpdetinjs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metaatendimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metaatendimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metaeficiencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metaeficiencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metaefisetup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metaefisetup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metappmil");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metappmil"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metaprodutividade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metaprodutividade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metautilizacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metautilizacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
