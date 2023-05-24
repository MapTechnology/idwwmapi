/**
 * PlanoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PlanoDTO  extends idw.idwws.PpPlano  implements java.io.Serializable {
    private java.util.Calendar dtReferenciaAntecipacao;

    private java.lang.String mensagem;

    private idw.idwws.ResultadoDTO resultadoDTO;

    public PlanoDTO() {
    }

    public PlanoDTO(
           java.lang.String cdPlano,
           java.lang.String dsPlano,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           java.util.Calendar dthrPrevisaoinicio,
           idw.idwws.DwCal dwCal,
           java.lang.Long idPlano,
           java.math.BigDecimal indOee,
           java.lang.Boolean isConsiderarcal,
           java.lang.Boolean isConsiderarcm,
           java.lang.Boolean isConsiderarest,
           java.lang.Boolean isConsiderarindisp,
           java.lang.Boolean isConsiderarmo,
           java.lang.Boolean isConsiderarmp,
           java.lang.Boolean isConsideraroeefinalserie,
           java.lang.Boolean isConsiderarprodutoturno,
           java.lang.Boolean isConsiderarrap,
           java.lang.Boolean isDeterminadocal,
           java.lang.Boolean isModelo,
           java.lang.Boolean isSimular,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           idw.idwws.PpCp[] ppCps,
           idw.idwws.PpPlancol[] ppPlancols,
           idw.idwws.PpPlaneccron[] ppPlaneccrons,
           idw.idwws.PpPlanec[] ppPlanecs,
           idw.idwws.PpPlanptgt[] ppPlanptgts,
           idw.idwws.PpTpplano ppTpplano,
           java.lang.Integer revisao,
           java.lang.Integer stAtivo,
           java.lang.Integer stPlano,
           java.util.Calendar dtReferenciaAntecipacao,
           java.lang.String mensagem,
           idw.idwws.ResultadoDTO resultadoDTO) {
        super(
            cdPlano,
            dsPlano,
            dtRevisao,
            dtStativo,
            dthrPrevisaoinicio,
            dwCal,
            idPlano,
            indOee,
            isConsiderarcal,
            isConsiderarcm,
            isConsiderarest,
            isConsiderarindisp,
            isConsiderarmo,
            isConsiderarmp,
            isConsideraroeefinalserie,
            isConsiderarprodutoturno,
            isConsiderarrap,
            isDeterminadocal,
            isModelo,
            isSimular,
            omUsrByIdUsrrevisao,
            omUsrByIdUsrstativo,
            ppCps,
            ppPlancols,
            ppPlaneccrons,
            ppPlanecs,
            ppPlanptgts,
            ppTpplano,
            revisao,
            stAtivo,
            stPlano);
        this.dtReferenciaAntecipacao = dtReferenciaAntecipacao;
        this.mensagem = mensagem;
        this.resultadoDTO = resultadoDTO;
    }


    /**
     * Gets the dtReferenciaAntecipacao value for this PlanoDTO.
     * 
     * @return dtReferenciaAntecipacao
     */
    public java.util.Calendar getDtReferenciaAntecipacao() {
        return dtReferenciaAntecipacao;
    }


    /**
     * Sets the dtReferenciaAntecipacao value for this PlanoDTO.
     * 
     * @param dtReferenciaAntecipacao
     */
    public void setDtReferenciaAntecipacao(java.util.Calendar dtReferenciaAntecipacao) {
        this.dtReferenciaAntecipacao = dtReferenciaAntecipacao;
    }


    /**
     * Gets the mensagem value for this PlanoDTO.
     * 
     * @return mensagem
     */
    public java.lang.String getMensagem() {
        return mensagem;
    }


    /**
     * Sets the mensagem value for this PlanoDTO.
     * 
     * @param mensagem
     */
    public void setMensagem(java.lang.String mensagem) {
        this.mensagem = mensagem;
    }


    /**
     * Gets the resultadoDTO value for this PlanoDTO.
     * 
     * @return resultadoDTO
     */
    public idw.idwws.ResultadoDTO getResultadoDTO() {
        return resultadoDTO;
    }


    /**
     * Sets the resultadoDTO value for this PlanoDTO.
     * 
     * @param resultadoDTO
     */
    public void setResultadoDTO(idw.idwws.ResultadoDTO resultadoDTO) {
        this.resultadoDTO = resultadoDTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PlanoDTO)) return false;
        PlanoDTO other = (PlanoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dtReferenciaAntecipacao==null && other.getDtReferenciaAntecipacao()==null) || 
             (this.dtReferenciaAntecipacao!=null &&
              this.dtReferenciaAntecipacao.equals(other.getDtReferenciaAntecipacao()))) &&
            ((this.mensagem==null && other.getMensagem()==null) || 
             (this.mensagem!=null &&
              this.mensagem.equals(other.getMensagem()))) &&
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
        if (getDtReferenciaAntecipacao() != null) {
            _hashCode += getDtReferenciaAntecipacao().hashCode();
        }
        if (getMensagem() != null) {
            _hashCode += getMensagem().hashCode();
        }
        if (getResultadoDTO() != null) {
            _hashCode += getResultadoDTO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PlanoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "planoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtReferenciaAntecipacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtReferenciaAntecipacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mensagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
