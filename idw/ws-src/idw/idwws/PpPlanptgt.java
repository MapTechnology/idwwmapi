/**
 * PpPlanptgt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpPlanptgt  extends idw.idwws.PpPlanptgtTemplate  implements java.io.Serializable {
    private java.lang.String aba;

    private java.math.BigDecimal coluna;

    private java.lang.Long idPlanptgt;

    private java.lang.Boolean isCoordenadarelativa;

    private java.math.BigDecimal linha;

    private idw.idwws.OmGt omGt;

    private idw.idwws.OmPt omPt;

    private idw.idwws.PpPlano ppPlano;

    public PpPlanptgt() {
    }

    public PpPlanptgt(
           java.lang.String aba,
           java.math.BigDecimal coluna,
           java.lang.Long idPlanptgt,
           java.lang.Boolean isCoordenadarelativa,
           java.math.BigDecimal linha,
           idw.idwws.OmGt omGt,
           idw.idwws.OmPt omPt,
           idw.idwws.PpPlano ppPlano) {
        this.aba = aba;
        this.coluna = coluna;
        this.idPlanptgt = idPlanptgt;
        this.isCoordenadarelativa = isCoordenadarelativa;
        this.linha = linha;
        this.omGt = omGt;
        this.omPt = omPt;
        this.ppPlano = ppPlano;
    }


    /**
     * Gets the aba value for this PpPlanptgt.
     * 
     * @return aba
     */
    public java.lang.String getAba() {
        return aba;
    }


    /**
     * Sets the aba value for this PpPlanptgt.
     * 
     * @param aba
     */
    public void setAba(java.lang.String aba) {
        this.aba = aba;
    }


    /**
     * Gets the coluna value for this PpPlanptgt.
     * 
     * @return coluna
     */
    public java.math.BigDecimal getColuna() {
        return coluna;
    }


    /**
     * Sets the coluna value for this PpPlanptgt.
     * 
     * @param coluna
     */
    public void setColuna(java.math.BigDecimal coluna) {
        this.coluna = coluna;
    }


    /**
     * Gets the idPlanptgt value for this PpPlanptgt.
     * 
     * @return idPlanptgt
     */
    public java.lang.Long getIdPlanptgt() {
        return idPlanptgt;
    }


    /**
     * Sets the idPlanptgt value for this PpPlanptgt.
     * 
     * @param idPlanptgt
     */
    public void setIdPlanptgt(java.lang.Long idPlanptgt) {
        this.idPlanptgt = idPlanptgt;
    }


    /**
     * Gets the isCoordenadarelativa value for this PpPlanptgt.
     * 
     * @return isCoordenadarelativa
     */
    public java.lang.Boolean getIsCoordenadarelativa() {
        return isCoordenadarelativa;
    }


    /**
     * Sets the isCoordenadarelativa value for this PpPlanptgt.
     * 
     * @param isCoordenadarelativa
     */
    public void setIsCoordenadarelativa(java.lang.Boolean isCoordenadarelativa) {
        this.isCoordenadarelativa = isCoordenadarelativa;
    }


    /**
     * Gets the linha value for this PpPlanptgt.
     * 
     * @return linha
     */
    public java.math.BigDecimal getLinha() {
        return linha;
    }


    /**
     * Sets the linha value for this PpPlanptgt.
     * 
     * @param linha
     */
    public void setLinha(java.math.BigDecimal linha) {
        this.linha = linha;
    }


    /**
     * Gets the omGt value for this PpPlanptgt.
     * 
     * @return omGt
     */
    public idw.idwws.OmGt getOmGt() {
        return omGt;
    }


    /**
     * Sets the omGt value for this PpPlanptgt.
     * 
     * @param omGt
     */
    public void setOmGt(idw.idwws.OmGt omGt) {
        this.omGt = omGt;
    }


    /**
     * Gets the omPt value for this PpPlanptgt.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this PpPlanptgt.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the ppPlano value for this PpPlanptgt.
     * 
     * @return ppPlano
     */
    public idw.idwws.PpPlano getPpPlano() {
        return ppPlano;
    }


    /**
     * Sets the ppPlano value for this PpPlanptgt.
     * 
     * @param ppPlano
     */
    public void setPpPlano(idw.idwws.PpPlano ppPlano) {
        this.ppPlano = ppPlano;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpPlanptgt)) return false;
        PpPlanptgt other = (PpPlanptgt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.aba==null && other.getAba()==null) || 
             (this.aba!=null &&
              this.aba.equals(other.getAba()))) &&
            ((this.coluna==null && other.getColuna()==null) || 
             (this.coluna!=null &&
              this.coluna.equals(other.getColuna()))) &&
            ((this.idPlanptgt==null && other.getIdPlanptgt()==null) || 
             (this.idPlanptgt!=null &&
              this.idPlanptgt.equals(other.getIdPlanptgt()))) &&
            ((this.isCoordenadarelativa==null && other.getIsCoordenadarelativa()==null) || 
             (this.isCoordenadarelativa!=null &&
              this.isCoordenadarelativa.equals(other.getIsCoordenadarelativa()))) &&
            ((this.linha==null && other.getLinha()==null) || 
             (this.linha!=null &&
              this.linha.equals(other.getLinha()))) &&
            ((this.omGt==null && other.getOmGt()==null) || 
             (this.omGt!=null &&
              this.omGt.equals(other.getOmGt()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.ppPlano==null && other.getPpPlano()==null) || 
             (this.ppPlano!=null &&
              this.ppPlano.equals(other.getPpPlano())));
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
        if (getAba() != null) {
            _hashCode += getAba().hashCode();
        }
        if (getColuna() != null) {
            _hashCode += getColuna().hashCode();
        }
        if (getIdPlanptgt() != null) {
            _hashCode += getIdPlanptgt().hashCode();
        }
        if (getIsCoordenadarelativa() != null) {
            _hashCode += getIsCoordenadarelativa().hashCode();
        }
        if (getLinha() != null) {
            _hashCode += getLinha().hashCode();
        }
        if (getOmGt() != null) {
            _hashCode += getOmGt().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getPpPlano() != null) {
            _hashCode += getPpPlano().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpPlanptgt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppPlanptgt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aba");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aba"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coluna");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coluna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPlanptgt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPlanptgt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isCoordenadarelativa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isCoordenadarelativa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "linha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
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
