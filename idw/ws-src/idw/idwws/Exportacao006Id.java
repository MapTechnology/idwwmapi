/**
 * Exportacao006Id.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Exportacao006Id  implements java.io.Serializable {
    private java.lang.String cdinjetora;

    private java.lang.String cdmolde;

    private java.util.Calendar dthrfec;

    private org.apache.axis.types.UnsignedShort idareaproducao;

    private java.lang.String idplanta;

    private java.lang.String nrop;

    private java.math.BigDecimal qtdciclos;

    private org.apache.axis.types.UnsignedShort status;

    public Exportacao006Id() {
    }

    public Exportacao006Id(
           java.lang.String cdinjetora,
           java.lang.String cdmolde,
           java.util.Calendar dthrfec,
           org.apache.axis.types.UnsignedShort idareaproducao,
           java.lang.String idplanta,
           java.lang.String nrop,
           java.math.BigDecimal qtdciclos,
           org.apache.axis.types.UnsignedShort status) {
           this.cdinjetora = cdinjetora;
           this.cdmolde = cdmolde;
           this.dthrfec = dthrfec;
           this.idareaproducao = idareaproducao;
           this.idplanta = idplanta;
           this.nrop = nrop;
           this.qtdciclos = qtdciclos;
           this.status = status;
    }


    /**
     * Gets the cdinjetora value for this Exportacao006Id.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this Exportacao006Id.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the cdmolde value for this Exportacao006Id.
     * 
     * @return cdmolde
     */
    public java.lang.String getCdmolde() {
        return cdmolde;
    }


    /**
     * Sets the cdmolde value for this Exportacao006Id.
     * 
     * @param cdmolde
     */
    public void setCdmolde(java.lang.String cdmolde) {
        this.cdmolde = cdmolde;
    }


    /**
     * Gets the dthrfec value for this Exportacao006Id.
     * 
     * @return dthrfec
     */
    public java.util.Calendar getDthrfec() {
        return dthrfec;
    }


    /**
     * Sets the dthrfec value for this Exportacao006Id.
     * 
     * @param dthrfec
     */
    public void setDthrfec(java.util.Calendar dthrfec) {
        this.dthrfec = dthrfec;
    }


    /**
     * Gets the idareaproducao value for this Exportacao006Id.
     * 
     * @return idareaproducao
     */
    public org.apache.axis.types.UnsignedShort getIdareaproducao() {
        return idareaproducao;
    }


    /**
     * Sets the idareaproducao value for this Exportacao006Id.
     * 
     * @param idareaproducao
     */
    public void setIdareaproducao(org.apache.axis.types.UnsignedShort idareaproducao) {
        this.idareaproducao = idareaproducao;
    }


    /**
     * Gets the idplanta value for this Exportacao006Id.
     * 
     * @return idplanta
     */
    public java.lang.String getIdplanta() {
        return idplanta;
    }


    /**
     * Sets the idplanta value for this Exportacao006Id.
     * 
     * @param idplanta
     */
    public void setIdplanta(java.lang.String idplanta) {
        this.idplanta = idplanta;
    }


    /**
     * Gets the nrop value for this Exportacao006Id.
     * 
     * @return nrop
     */
    public java.lang.String getNrop() {
        return nrop;
    }


    /**
     * Sets the nrop value for this Exportacao006Id.
     * 
     * @param nrop
     */
    public void setNrop(java.lang.String nrop) {
        this.nrop = nrop;
    }


    /**
     * Gets the qtdciclos value for this Exportacao006Id.
     * 
     * @return qtdciclos
     */
    public java.math.BigDecimal getQtdciclos() {
        return qtdciclos;
    }


    /**
     * Sets the qtdciclos value for this Exportacao006Id.
     * 
     * @param qtdciclos
     */
    public void setQtdciclos(java.math.BigDecimal qtdciclos) {
        this.qtdciclos = qtdciclos;
    }


    /**
     * Gets the status value for this Exportacao006Id.
     * 
     * @return status
     */
    public org.apache.axis.types.UnsignedShort getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Exportacao006Id.
     * 
     * @param status
     */
    public void setStatus(org.apache.axis.types.UnsignedShort status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Exportacao006Id)) return false;
        Exportacao006Id other = (Exportacao006Id) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora()))) &&
            ((this.cdmolde==null && other.getCdmolde()==null) || 
             (this.cdmolde!=null &&
              this.cdmolde.equals(other.getCdmolde()))) &&
            ((this.dthrfec==null && other.getDthrfec()==null) || 
             (this.dthrfec!=null &&
              this.dthrfec.equals(other.getDthrfec()))) &&
            ((this.idareaproducao==null && other.getIdareaproducao()==null) || 
             (this.idareaproducao!=null &&
              this.idareaproducao.equals(other.getIdareaproducao()))) &&
            ((this.idplanta==null && other.getIdplanta()==null) || 
             (this.idplanta!=null &&
              this.idplanta.equals(other.getIdplanta()))) &&
            ((this.nrop==null && other.getNrop()==null) || 
             (this.nrop!=null &&
              this.nrop.equals(other.getNrop()))) &&
            ((this.qtdciclos==null && other.getQtdciclos()==null) || 
             (this.qtdciclos!=null &&
              this.qtdciclos.equals(other.getQtdciclos()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus())));
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
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        if (getCdmolde() != null) {
            _hashCode += getCdmolde().hashCode();
        }
        if (getDthrfec() != null) {
            _hashCode += getDthrfec().hashCode();
        }
        if (getIdareaproducao() != null) {
            _hashCode += getIdareaproducao().hashCode();
        }
        if (getIdplanta() != null) {
            _hashCode += getIdplanta().hashCode();
        }
        if (getNrop() != null) {
            _hashCode += getNrop().hashCode();
        }
        if (getQtdciclos() != null) {
            _hashCode += getQtdciclos().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Exportacao006Id.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "exportacao006Id"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idareaproducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idareaproducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idplanta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idplanta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdciclos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdciclos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
