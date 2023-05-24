/**
 * FiltroRelDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class FiltroRelDTO  implements java.io.Serializable {
    private java.lang.Integer agrupamento;

    private java.lang.Integer apontamento;

    private java.util.Calendar dataFinal;

    private java.util.Calendar dataInicial;

    private long idPt;

    private long idTurno;

    private idw.idwws.OmProgrp[] plataformas;

    public FiltroRelDTO() {
    }

    public FiltroRelDTO(
           java.lang.Integer agrupamento,
           java.lang.Integer apontamento,
           java.util.Calendar dataFinal,
           java.util.Calendar dataInicial,
           long idPt,
           long idTurno,
           idw.idwws.OmProgrp[] plataformas) {
           this.agrupamento = agrupamento;
           this.apontamento = apontamento;
           this.dataFinal = dataFinal;
           this.dataInicial = dataInicial;
           this.idPt = idPt;
           this.idTurno = idTurno;
           this.plataformas = plataformas;
    }


    /**
     * Gets the agrupamento value for this FiltroRelDTO.
     * 
     * @return agrupamento
     */
    public java.lang.Integer getAgrupamento() {
        return agrupamento;
    }


    /**
     * Sets the agrupamento value for this FiltroRelDTO.
     * 
     * @param agrupamento
     */
    public void setAgrupamento(java.lang.Integer agrupamento) {
        this.agrupamento = agrupamento;
    }


    /**
     * Gets the apontamento value for this FiltroRelDTO.
     * 
     * @return apontamento
     */
    public java.lang.Integer getApontamento() {
        return apontamento;
    }


    /**
     * Sets the apontamento value for this FiltroRelDTO.
     * 
     * @param apontamento
     */
    public void setApontamento(java.lang.Integer apontamento) {
        this.apontamento = apontamento;
    }


    /**
     * Gets the dataFinal value for this FiltroRelDTO.
     * 
     * @return dataFinal
     */
    public java.util.Calendar getDataFinal() {
        return dataFinal;
    }


    /**
     * Sets the dataFinal value for this FiltroRelDTO.
     * 
     * @param dataFinal
     */
    public void setDataFinal(java.util.Calendar dataFinal) {
        this.dataFinal = dataFinal;
    }


    /**
     * Gets the dataInicial value for this FiltroRelDTO.
     * 
     * @return dataInicial
     */
    public java.util.Calendar getDataInicial() {
        return dataInicial;
    }


    /**
     * Sets the dataInicial value for this FiltroRelDTO.
     * 
     * @param dataInicial
     */
    public void setDataInicial(java.util.Calendar dataInicial) {
        this.dataInicial = dataInicial;
    }


    /**
     * Gets the idPt value for this FiltroRelDTO.
     * 
     * @return idPt
     */
    public long getIdPt() {
        return idPt;
    }


    /**
     * Sets the idPt value for this FiltroRelDTO.
     * 
     * @param idPt
     */
    public void setIdPt(long idPt) {
        this.idPt = idPt;
    }


    /**
     * Gets the idTurno value for this FiltroRelDTO.
     * 
     * @return idTurno
     */
    public long getIdTurno() {
        return idTurno;
    }


    /**
     * Sets the idTurno value for this FiltroRelDTO.
     * 
     * @param idTurno
     */
    public void setIdTurno(long idTurno) {
        this.idTurno = idTurno;
    }


    /**
     * Gets the plataformas value for this FiltroRelDTO.
     * 
     * @return plataformas
     */
    public idw.idwws.OmProgrp[] getPlataformas() {
        return plataformas;
    }


    /**
     * Sets the plataformas value for this FiltroRelDTO.
     * 
     * @param plataformas
     */
    public void setPlataformas(idw.idwws.OmProgrp[] plataformas) {
        this.plataformas = plataformas;
    }

    public idw.idwws.OmProgrp getPlataformas(int i) {
        return this.plataformas[i];
    }

    public void setPlataformas(int i, idw.idwws.OmProgrp _value) {
        this.plataformas[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FiltroRelDTO)) return false;
        FiltroRelDTO other = (FiltroRelDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.agrupamento==null && other.getAgrupamento()==null) || 
             (this.agrupamento!=null &&
              this.agrupamento.equals(other.getAgrupamento()))) &&
            ((this.apontamento==null && other.getApontamento()==null) || 
             (this.apontamento!=null &&
              this.apontamento.equals(other.getApontamento()))) &&
            ((this.dataFinal==null && other.getDataFinal()==null) || 
             (this.dataFinal!=null &&
              this.dataFinal.equals(other.getDataFinal()))) &&
            ((this.dataInicial==null && other.getDataInicial()==null) || 
             (this.dataInicial!=null &&
              this.dataInicial.equals(other.getDataInicial()))) &&
            this.idPt == other.getIdPt() &&
            this.idTurno == other.getIdTurno() &&
            ((this.plataformas==null && other.getPlataformas()==null) || 
             (this.plataformas!=null &&
              java.util.Arrays.equals(this.plataformas, other.getPlataformas())));
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
        if (getAgrupamento() != null) {
            _hashCode += getAgrupamento().hashCode();
        }
        if (getApontamento() != null) {
            _hashCode += getApontamento().hashCode();
        }
        if (getDataFinal() != null) {
            _hashCode += getDataFinal().hashCode();
        }
        if (getDataInicial() != null) {
            _hashCode += getDataInicial().hashCode();
        }
        _hashCode += new Long(getIdPt()).hashCode();
        _hashCode += new Long(getIdTurno()).hashCode();
        if (getPlataformas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPlataformas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPlataformas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FiltroRelDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "filtroRelDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agrupamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agrupamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apontamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "apontamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataFinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataFinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataInicial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataInicial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plataformas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "plataformas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProgrp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
