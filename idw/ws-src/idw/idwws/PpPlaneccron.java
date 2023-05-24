/**
 * PpPlaneccron.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpPlaneccron  extends idw.idwws.PpPlaneccronTemplate  implements java.io.Serializable {
    private java.util.Calendar dthrNecessaria;

    private java.lang.Long idPlaneccron;

    private java.lang.Boolean isAntecipacao;

    private idw.idwws.OmProduto omProduto;

    private java.lang.Integer ordem;

    private idw.idwws.PpCpneccron[] ppCpneccrons;

    private idw.idwws.PpNeccron ppNeccron;

    private idw.idwws.PpPlano ppPlano;

    private java.lang.Double qtAcumprir;

    private java.lang.Double qtEstoque;

    private java.lang.Double qtNecessaria;

    public PpPlaneccron() {
    }

    public PpPlaneccron(
           java.util.Calendar dthrNecessaria,
           java.lang.Long idPlaneccron,
           java.lang.Boolean isAntecipacao,
           idw.idwws.OmProduto omProduto,
           java.lang.Integer ordem,
           idw.idwws.PpCpneccron[] ppCpneccrons,
           idw.idwws.PpNeccron ppNeccron,
           idw.idwws.PpPlano ppPlano,
           java.lang.Double qtAcumprir,
           java.lang.Double qtEstoque,
           java.lang.Double qtNecessaria) {
        this.dthrNecessaria = dthrNecessaria;
        this.idPlaneccron = idPlaneccron;
        this.isAntecipacao = isAntecipacao;
        this.omProduto = omProduto;
        this.ordem = ordem;
        this.ppCpneccrons = ppCpneccrons;
        this.ppNeccron = ppNeccron;
        this.ppPlano = ppPlano;
        this.qtAcumprir = qtAcumprir;
        this.qtEstoque = qtEstoque;
        this.qtNecessaria = qtNecessaria;
    }


    /**
     * Gets the dthrNecessaria value for this PpPlaneccron.
     * 
     * @return dthrNecessaria
     */
    public java.util.Calendar getDthrNecessaria() {
        return dthrNecessaria;
    }


    /**
     * Sets the dthrNecessaria value for this PpPlaneccron.
     * 
     * @param dthrNecessaria
     */
    public void setDthrNecessaria(java.util.Calendar dthrNecessaria) {
        this.dthrNecessaria = dthrNecessaria;
    }


    /**
     * Gets the idPlaneccron value for this PpPlaneccron.
     * 
     * @return idPlaneccron
     */
    public java.lang.Long getIdPlaneccron() {
        return idPlaneccron;
    }


    /**
     * Sets the idPlaneccron value for this PpPlaneccron.
     * 
     * @param idPlaneccron
     */
    public void setIdPlaneccron(java.lang.Long idPlaneccron) {
        this.idPlaneccron = idPlaneccron;
    }


    /**
     * Gets the isAntecipacao value for this PpPlaneccron.
     * 
     * @return isAntecipacao
     */
    public java.lang.Boolean getIsAntecipacao() {
        return isAntecipacao;
    }


    /**
     * Sets the isAntecipacao value for this PpPlaneccron.
     * 
     * @param isAntecipacao
     */
    public void setIsAntecipacao(java.lang.Boolean isAntecipacao) {
        this.isAntecipacao = isAntecipacao;
    }


    /**
     * Gets the omProduto value for this PpPlaneccron.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this PpPlaneccron.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the ordem value for this PpPlaneccron.
     * 
     * @return ordem
     */
    public java.lang.Integer getOrdem() {
        return ordem;
    }


    /**
     * Sets the ordem value for this PpPlaneccron.
     * 
     * @param ordem
     */
    public void setOrdem(java.lang.Integer ordem) {
        this.ordem = ordem;
    }


    /**
     * Gets the ppCpneccrons value for this PpPlaneccron.
     * 
     * @return ppCpneccrons
     */
    public idw.idwws.PpCpneccron[] getPpCpneccrons() {
        return ppCpneccrons;
    }


    /**
     * Sets the ppCpneccrons value for this PpPlaneccron.
     * 
     * @param ppCpneccrons
     */
    public void setPpCpneccrons(idw.idwws.PpCpneccron[] ppCpneccrons) {
        this.ppCpneccrons = ppCpneccrons;
    }

    public idw.idwws.PpCpneccron getPpCpneccrons(int i) {
        return this.ppCpneccrons[i];
    }

    public void setPpCpneccrons(int i, idw.idwws.PpCpneccron _value) {
        this.ppCpneccrons[i] = _value;
    }


    /**
     * Gets the ppNeccron value for this PpPlaneccron.
     * 
     * @return ppNeccron
     */
    public idw.idwws.PpNeccron getPpNeccron() {
        return ppNeccron;
    }


    /**
     * Sets the ppNeccron value for this PpPlaneccron.
     * 
     * @param ppNeccron
     */
    public void setPpNeccron(idw.idwws.PpNeccron ppNeccron) {
        this.ppNeccron = ppNeccron;
    }


    /**
     * Gets the ppPlano value for this PpPlaneccron.
     * 
     * @return ppPlano
     */
    public idw.idwws.PpPlano getPpPlano() {
        return ppPlano;
    }


    /**
     * Sets the ppPlano value for this PpPlaneccron.
     * 
     * @param ppPlano
     */
    public void setPpPlano(idw.idwws.PpPlano ppPlano) {
        this.ppPlano = ppPlano;
    }


    /**
     * Gets the qtAcumprir value for this PpPlaneccron.
     * 
     * @return qtAcumprir
     */
    public java.lang.Double getQtAcumprir() {
        return qtAcumprir;
    }


    /**
     * Sets the qtAcumprir value for this PpPlaneccron.
     * 
     * @param qtAcumprir
     */
    public void setQtAcumprir(java.lang.Double qtAcumprir) {
        this.qtAcumprir = qtAcumprir;
    }


    /**
     * Gets the qtEstoque value for this PpPlaneccron.
     * 
     * @return qtEstoque
     */
    public java.lang.Double getQtEstoque() {
        return qtEstoque;
    }


    /**
     * Sets the qtEstoque value for this PpPlaneccron.
     * 
     * @param qtEstoque
     */
    public void setQtEstoque(java.lang.Double qtEstoque) {
        this.qtEstoque = qtEstoque;
    }


    /**
     * Gets the qtNecessaria value for this PpPlaneccron.
     * 
     * @return qtNecessaria
     */
    public java.lang.Double getQtNecessaria() {
        return qtNecessaria;
    }


    /**
     * Sets the qtNecessaria value for this PpPlaneccron.
     * 
     * @param qtNecessaria
     */
    public void setQtNecessaria(java.lang.Double qtNecessaria) {
        this.qtNecessaria = qtNecessaria;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpPlaneccron)) return false;
        PpPlaneccron other = (PpPlaneccron) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dthrNecessaria==null && other.getDthrNecessaria()==null) || 
             (this.dthrNecessaria!=null &&
              this.dthrNecessaria.equals(other.getDthrNecessaria()))) &&
            ((this.idPlaneccron==null && other.getIdPlaneccron()==null) || 
             (this.idPlaneccron!=null &&
              this.idPlaneccron.equals(other.getIdPlaneccron()))) &&
            ((this.isAntecipacao==null && other.getIsAntecipacao()==null) || 
             (this.isAntecipacao!=null &&
              this.isAntecipacao.equals(other.getIsAntecipacao()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.ordem==null && other.getOrdem()==null) || 
             (this.ordem!=null &&
              this.ordem.equals(other.getOrdem()))) &&
            ((this.ppCpneccrons==null && other.getPpCpneccrons()==null) || 
             (this.ppCpneccrons!=null &&
              java.util.Arrays.equals(this.ppCpneccrons, other.getPpCpneccrons()))) &&
            ((this.ppNeccron==null && other.getPpNeccron()==null) || 
             (this.ppNeccron!=null &&
              this.ppNeccron.equals(other.getPpNeccron()))) &&
            ((this.ppPlano==null && other.getPpPlano()==null) || 
             (this.ppPlano!=null &&
              this.ppPlano.equals(other.getPpPlano()))) &&
            ((this.qtAcumprir==null && other.getQtAcumprir()==null) || 
             (this.qtAcumprir!=null &&
              this.qtAcumprir.equals(other.getQtAcumprir()))) &&
            ((this.qtEstoque==null && other.getQtEstoque()==null) || 
             (this.qtEstoque!=null &&
              this.qtEstoque.equals(other.getQtEstoque()))) &&
            ((this.qtNecessaria==null && other.getQtNecessaria()==null) || 
             (this.qtNecessaria!=null &&
              this.qtNecessaria.equals(other.getQtNecessaria())));
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
        if (getDthrNecessaria() != null) {
            _hashCode += getDthrNecessaria().hashCode();
        }
        if (getIdPlaneccron() != null) {
            _hashCode += getIdPlaneccron().hashCode();
        }
        if (getIsAntecipacao() != null) {
            _hashCode += getIsAntecipacao().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getOrdem() != null) {
            _hashCode += getOrdem().hashCode();
        }
        if (getPpCpneccrons() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpCpneccrons());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpCpneccrons(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpNeccron() != null) {
            _hashCode += getPpNeccron().hashCode();
        }
        if (getPpPlano() != null) {
            _hashCode += getPpPlano().hashCode();
        }
        if (getQtAcumprir() != null) {
            _hashCode += getQtAcumprir().hashCode();
        }
        if (getQtEstoque() != null) {
            _hashCode += getQtEstoque().hashCode();
        }
        if (getQtNecessaria() != null) {
            _hashCode += getQtNecessaria().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpPlaneccron.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppPlaneccron"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrNecessaria");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrNecessaria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPlaneccron");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPlaneccron"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAntecipacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isAntecipacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCpneccrons");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCpneccrons"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpneccron"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppNeccron");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppNeccron"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNeccron"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppPlano");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppPlano"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppPlano"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAcumprir");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAcumprir"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtEstoque");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtEstoque"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtNecessaria");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtNecessaria"));
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
