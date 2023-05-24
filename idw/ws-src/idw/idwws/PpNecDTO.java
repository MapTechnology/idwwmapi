/**
 * PpNecDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpNecDTO  extends idw.idwws.PpNec  implements java.io.Serializable {
    private java.util.Calendar fimApontamento;

    private java.util.Calendar fimPlanejamento;

    private java.util.Calendar inicioApontamento;

    private java.util.Calendar inicioPlanejamento;

    private idw.idwws.PpNeccronDTO[] plano;

    private idw.idwws.ResultadoDTO resultadoDTO;

    public PpNecDTO() {
    }

    public PpNecDTO(
           java.lang.String cdNec,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           java.math.BigDecimal hrLeadtime,
           java.lang.Long idNec,
           java.lang.String nrDoc,
           idw.idwws.OmProduto omProduto,
           idw.idwws.OmPt omPt,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           idw.idwws.PpCliente ppCliente,
           idw.idwws.PpNeccron[] ppNeccrons,
           idw.idwws.PpNecimpurllog ppNecimpurllog,
           idw.idwws.PpPlanec[] ppPlanecs,
           java.lang.Long revisao,
           java.lang.Integer stAtivo,
           java.lang.Integer tpNec,
           java.lang.String urlOrigem,
           java.util.Calendar fimApontamento,
           java.util.Calendar fimPlanejamento,
           java.util.Calendar inicioApontamento,
           java.util.Calendar inicioPlanejamento,
           idw.idwws.PpNeccronDTO[] plano,
           idw.idwws.ResultadoDTO resultadoDTO) {
        super(
            cdNec,
            dtRevisao,
            dtStativo,
            hrLeadtime,
            idNec,
            nrDoc,
            omProduto,
            omPt,
            omUsrByIdUsrrevisao,
            omUsrByIdUsrstativo,
            ppCliente,
            ppNeccrons,
            ppNecimpurllog,
            ppPlanecs,
            revisao,
            stAtivo,
            tpNec,
            urlOrigem);
        this.fimApontamento = fimApontamento;
        this.fimPlanejamento = fimPlanejamento;
        this.inicioApontamento = inicioApontamento;
        this.inicioPlanejamento = inicioPlanejamento;
        this.plano = plano;
        this.resultadoDTO = resultadoDTO;
    }


    /**
     * Gets the fimApontamento value for this PpNecDTO.
     * 
     * @return fimApontamento
     */
    public java.util.Calendar getFimApontamento() {
        return fimApontamento;
    }


    /**
     * Sets the fimApontamento value for this PpNecDTO.
     * 
     * @param fimApontamento
     */
    public void setFimApontamento(java.util.Calendar fimApontamento) {
        this.fimApontamento = fimApontamento;
    }


    /**
     * Gets the fimPlanejamento value for this PpNecDTO.
     * 
     * @return fimPlanejamento
     */
    public java.util.Calendar getFimPlanejamento() {
        return fimPlanejamento;
    }


    /**
     * Sets the fimPlanejamento value for this PpNecDTO.
     * 
     * @param fimPlanejamento
     */
    public void setFimPlanejamento(java.util.Calendar fimPlanejamento) {
        this.fimPlanejamento = fimPlanejamento;
    }


    /**
     * Gets the inicioApontamento value for this PpNecDTO.
     * 
     * @return inicioApontamento
     */
    public java.util.Calendar getInicioApontamento() {
        return inicioApontamento;
    }


    /**
     * Sets the inicioApontamento value for this PpNecDTO.
     * 
     * @param inicioApontamento
     */
    public void setInicioApontamento(java.util.Calendar inicioApontamento) {
        this.inicioApontamento = inicioApontamento;
    }


    /**
     * Gets the inicioPlanejamento value for this PpNecDTO.
     * 
     * @return inicioPlanejamento
     */
    public java.util.Calendar getInicioPlanejamento() {
        return inicioPlanejamento;
    }


    /**
     * Sets the inicioPlanejamento value for this PpNecDTO.
     * 
     * @param inicioPlanejamento
     */
    public void setInicioPlanejamento(java.util.Calendar inicioPlanejamento) {
        this.inicioPlanejamento = inicioPlanejamento;
    }


    /**
     * Gets the plano value for this PpNecDTO.
     * 
     * @return plano
     */
    public idw.idwws.PpNeccronDTO[] getPlano() {
        return plano;
    }


    /**
     * Sets the plano value for this PpNecDTO.
     * 
     * @param plano
     */
    public void setPlano(idw.idwws.PpNeccronDTO[] plano) {
        this.plano = plano;
    }

    public idw.idwws.PpNeccronDTO getPlano(int i) {
        return this.plano[i];
    }

    public void setPlano(int i, idw.idwws.PpNeccronDTO _value) {
        this.plano[i] = _value;
    }


    /**
     * Gets the resultadoDTO value for this PpNecDTO.
     * 
     * @return resultadoDTO
     */
    public idw.idwws.ResultadoDTO getResultadoDTO() {
        return resultadoDTO;
    }


    /**
     * Sets the resultadoDTO value for this PpNecDTO.
     * 
     * @param resultadoDTO
     */
    public void setResultadoDTO(idw.idwws.ResultadoDTO resultadoDTO) {
        this.resultadoDTO = resultadoDTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpNecDTO)) return false;
        PpNecDTO other = (PpNecDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.fimApontamento==null && other.getFimApontamento()==null) || 
             (this.fimApontamento!=null &&
              this.fimApontamento.equals(other.getFimApontamento()))) &&
            ((this.fimPlanejamento==null && other.getFimPlanejamento()==null) || 
             (this.fimPlanejamento!=null &&
              this.fimPlanejamento.equals(other.getFimPlanejamento()))) &&
            ((this.inicioApontamento==null && other.getInicioApontamento()==null) || 
             (this.inicioApontamento!=null &&
              this.inicioApontamento.equals(other.getInicioApontamento()))) &&
            ((this.inicioPlanejamento==null && other.getInicioPlanejamento()==null) || 
             (this.inicioPlanejamento!=null &&
              this.inicioPlanejamento.equals(other.getInicioPlanejamento()))) &&
            ((this.plano==null && other.getPlano()==null) || 
             (this.plano!=null &&
              java.util.Arrays.equals(this.plano, other.getPlano()))) &&
            ((this.resultadoDTO==null && other.getResultadoDTO()==null) || 
             (this.resultadoDTO!=null &&
              this.resultadoDTO.equals(other.getResultadoDTO())));
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
        if (getFimApontamento() != null) {
            _hashCode += getFimApontamento().hashCode();
        }
        if (getFimPlanejamento() != null) {
            _hashCode += getFimPlanejamento().hashCode();
        }
        if (getInicioApontamento() != null) {
            _hashCode += getInicioApontamento().hashCode();
        }
        if (getInicioPlanejamento() != null) {
            _hashCode += getInicioPlanejamento().hashCode();
        }
        if (getPlano() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPlano());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPlano(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getResultadoDTO() != null) {
            _hashCode += getResultadoDTO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpNecDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNecDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fimApontamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fimApontamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fimPlanejamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fimPlanejamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioApontamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inicioApontamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioPlanejamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inicioPlanejamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plano");
        elemField.setXmlName(new javax.xml.namespace.QName("", "plano"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNeccronDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoDTO"));
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
