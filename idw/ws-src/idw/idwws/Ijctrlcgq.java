/**
 * Ijctrlcgq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijctrlcgq  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedShort aplresultmod;

    private java.lang.Double du;

    private idw.idwws.IjctrlcgqId id;

    private idw.idwws.Ijctrlcgqalt[] ijctrlcgqalts;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijtbpro ijtbpro;

    private java.lang.String nrnota;

    private java.lang.String observacao;

    private org.apache.axis.types.UnsignedShort resultadoinspecao;

    private java.math.BigDecimal revisao;

    private org.apache.axis.types.UnsignedShort tpobservacao;

    public Ijctrlcgq() {
    }

    public Ijctrlcgq(
           org.apache.axis.types.UnsignedShort aplresultmod,
           java.lang.Double du,
           idw.idwws.IjctrlcgqId id,
           idw.idwws.Ijctrlcgqalt[] ijctrlcgqalts,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijtbpro ijtbpro,
           java.lang.String nrnota,
           java.lang.String observacao,
           org.apache.axis.types.UnsignedShort resultadoinspecao,
           java.math.BigDecimal revisao,
           org.apache.axis.types.UnsignedShort tpobservacao) {
           this.aplresultmod = aplresultmod;
           this.du = du;
           this.id = id;
           this.ijctrlcgqalts = ijctrlcgqalts;
           this.ijop = ijop;
           this.ijtbpro = ijtbpro;
           this.nrnota = nrnota;
           this.observacao = observacao;
           this.resultadoinspecao = resultadoinspecao;
           this.revisao = revisao;
           this.tpobservacao = tpobservacao;
    }


    /**
     * Gets the aplresultmod value for this Ijctrlcgq.
     * 
     * @return aplresultmod
     */
    public org.apache.axis.types.UnsignedShort getAplresultmod() {
        return aplresultmod;
    }


    /**
     * Sets the aplresultmod value for this Ijctrlcgq.
     * 
     * @param aplresultmod
     */
    public void setAplresultmod(org.apache.axis.types.UnsignedShort aplresultmod) {
        this.aplresultmod = aplresultmod;
    }


    /**
     * Gets the du value for this Ijctrlcgq.
     * 
     * @return du
     */
    public java.lang.Double getDu() {
        return du;
    }


    /**
     * Sets the du value for this Ijctrlcgq.
     * 
     * @param du
     */
    public void setDu(java.lang.Double du) {
        this.du = du;
    }


    /**
     * Gets the id value for this Ijctrlcgq.
     * 
     * @return id
     */
    public idw.idwws.IjctrlcgqId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijctrlcgq.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjctrlcgqId id) {
        this.id = id;
    }


    /**
     * Gets the ijctrlcgqalts value for this Ijctrlcgq.
     * 
     * @return ijctrlcgqalts
     */
    public idw.idwws.Ijctrlcgqalt[] getIjctrlcgqalts() {
        return ijctrlcgqalts;
    }


    /**
     * Sets the ijctrlcgqalts value for this Ijctrlcgq.
     * 
     * @param ijctrlcgqalts
     */
    public void setIjctrlcgqalts(idw.idwws.Ijctrlcgqalt[] ijctrlcgqalts) {
        this.ijctrlcgqalts = ijctrlcgqalts;
    }

    public idw.idwws.Ijctrlcgqalt getIjctrlcgqalts(int i) {
        return this.ijctrlcgqalts[i];
    }

    public void setIjctrlcgqalts(int i, idw.idwws.Ijctrlcgqalt _value) {
        this.ijctrlcgqalts[i] = _value;
    }


    /**
     * Gets the ijop value for this Ijctrlcgq.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijctrlcgq.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijtbpro value for this Ijctrlcgq.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijctrlcgq.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the nrnota value for this Ijctrlcgq.
     * 
     * @return nrnota
     */
    public java.lang.String getNrnota() {
        return nrnota;
    }


    /**
     * Sets the nrnota value for this Ijctrlcgq.
     * 
     * @param nrnota
     */
    public void setNrnota(java.lang.String nrnota) {
        this.nrnota = nrnota;
    }


    /**
     * Gets the observacao value for this Ijctrlcgq.
     * 
     * @return observacao
     */
    public java.lang.String getObservacao() {
        return observacao;
    }


    /**
     * Sets the observacao value for this Ijctrlcgq.
     * 
     * @param observacao
     */
    public void setObservacao(java.lang.String observacao) {
        this.observacao = observacao;
    }


    /**
     * Gets the resultadoinspecao value for this Ijctrlcgq.
     * 
     * @return resultadoinspecao
     */
    public org.apache.axis.types.UnsignedShort getResultadoinspecao() {
        return resultadoinspecao;
    }


    /**
     * Sets the resultadoinspecao value for this Ijctrlcgq.
     * 
     * @param resultadoinspecao
     */
    public void setResultadoinspecao(org.apache.axis.types.UnsignedShort resultadoinspecao) {
        this.resultadoinspecao = resultadoinspecao;
    }


    /**
     * Gets the revisao value for this Ijctrlcgq.
     * 
     * @return revisao
     */
    public java.math.BigDecimal getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this Ijctrlcgq.
     * 
     * @param revisao
     */
    public void setRevisao(java.math.BigDecimal revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the tpobservacao value for this Ijctrlcgq.
     * 
     * @return tpobservacao
     */
    public org.apache.axis.types.UnsignedShort getTpobservacao() {
        return tpobservacao;
    }


    /**
     * Sets the tpobservacao value for this Ijctrlcgq.
     * 
     * @param tpobservacao
     */
    public void setTpobservacao(org.apache.axis.types.UnsignedShort tpobservacao) {
        this.tpobservacao = tpobservacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijctrlcgq)) return false;
        Ijctrlcgq other = (Ijctrlcgq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.aplresultmod==null && other.getAplresultmod()==null) || 
             (this.aplresultmod!=null &&
              this.aplresultmod.equals(other.getAplresultmod()))) &&
            ((this.du==null && other.getDu()==null) || 
             (this.du!=null &&
              this.du.equals(other.getDu()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijctrlcgqalts==null && other.getIjctrlcgqalts()==null) || 
             (this.ijctrlcgqalts!=null &&
              java.util.Arrays.equals(this.ijctrlcgqalts, other.getIjctrlcgqalts()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            ((this.nrnota==null && other.getNrnota()==null) || 
             (this.nrnota!=null &&
              this.nrnota.equals(other.getNrnota()))) &&
            ((this.observacao==null && other.getObservacao()==null) || 
             (this.observacao!=null &&
              this.observacao.equals(other.getObservacao()))) &&
            ((this.resultadoinspecao==null && other.getResultadoinspecao()==null) || 
             (this.resultadoinspecao!=null &&
              this.resultadoinspecao.equals(other.getResultadoinspecao()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.tpobservacao==null && other.getTpobservacao()==null) || 
             (this.tpobservacao!=null &&
              this.tpobservacao.equals(other.getTpobservacao())));
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
        if (getAplresultmod() != null) {
            _hashCode += getAplresultmod().hashCode();
        }
        if (getDu() != null) {
            _hashCode += getDu().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjctrlcgqalts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjctrlcgqalts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjctrlcgqalts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        if (getNrnota() != null) {
            _hashCode += getNrnota().hashCode();
        }
        if (getObservacao() != null) {
            _hashCode += getObservacao().hashCode();
        }
        if (getResultadoinspecao() != null) {
            _hashCode += getResultadoinspecao().hashCode();
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getTpobservacao() != null) {
            _hashCode += getTpobservacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijctrlcgq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlcgq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aplresultmod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aplresultmod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("du");
        elemField.setXmlName(new javax.xml.namespace.QName("", "du"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlcgqId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrlcgqalts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrlcgqalts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlcgqalt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrnota");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrnota"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("observacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "observacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoinspecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoinspecao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "revisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpobservacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpobservacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
