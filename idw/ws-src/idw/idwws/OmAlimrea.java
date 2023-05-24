/**
 * OmAlimrea.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmAlimrea  extends idw.idwws.OmAlimreaTemplate  implements java.io.Serializable {
    private java.lang.String cbRap;

    private java.lang.String cdLido;

    private java.util.Calendar dthrLeitura;

    private java.lang.Long idAlimrea;

    private idw.idwws.OmAlim omAlim;

    private idw.idwws.OmMapapa omMapapa;

    private idw.idwws.OmUsr omUsr;

    private java.lang.Integer qtAlimentada;

    private java.lang.Byte stLeitura;

    private java.lang.Byte tpLeitura;

    public OmAlimrea() {
    }

    public OmAlimrea(
           java.lang.String cbRap,
           java.lang.String cdLido,
           java.util.Calendar dthrLeitura,
           java.lang.Long idAlimrea,
           idw.idwws.OmAlim omAlim,
           idw.idwws.OmMapapa omMapapa,
           idw.idwws.OmUsr omUsr,
           java.lang.Integer qtAlimentada,
           java.lang.Byte stLeitura,
           java.lang.Byte tpLeitura) {
        this.cbRap = cbRap;
        this.cdLido = cdLido;
        this.dthrLeitura = dthrLeitura;
        this.idAlimrea = idAlimrea;
        this.omAlim = omAlim;
        this.omMapapa = omMapapa;
        this.omUsr = omUsr;
        this.qtAlimentada = qtAlimentada;
        this.stLeitura = stLeitura;
        this.tpLeitura = tpLeitura;
    }


    /**
     * Gets the cbRap value for this OmAlimrea.
     * 
     * @return cbRap
     */
    public java.lang.String getCbRap() {
        return cbRap;
    }


    /**
     * Sets the cbRap value for this OmAlimrea.
     * 
     * @param cbRap
     */
    public void setCbRap(java.lang.String cbRap) {
        this.cbRap = cbRap;
    }


    /**
     * Gets the cdLido value for this OmAlimrea.
     * 
     * @return cdLido
     */
    public java.lang.String getCdLido() {
        return cdLido;
    }


    /**
     * Sets the cdLido value for this OmAlimrea.
     * 
     * @param cdLido
     */
    public void setCdLido(java.lang.String cdLido) {
        this.cdLido = cdLido;
    }


    /**
     * Gets the dthrLeitura value for this OmAlimrea.
     * 
     * @return dthrLeitura
     */
    public java.util.Calendar getDthrLeitura() {
        return dthrLeitura;
    }


    /**
     * Sets the dthrLeitura value for this OmAlimrea.
     * 
     * @param dthrLeitura
     */
    public void setDthrLeitura(java.util.Calendar dthrLeitura) {
        this.dthrLeitura = dthrLeitura;
    }


    /**
     * Gets the idAlimrea value for this OmAlimrea.
     * 
     * @return idAlimrea
     */
    public java.lang.Long getIdAlimrea() {
        return idAlimrea;
    }


    /**
     * Sets the idAlimrea value for this OmAlimrea.
     * 
     * @param idAlimrea
     */
    public void setIdAlimrea(java.lang.Long idAlimrea) {
        this.idAlimrea = idAlimrea;
    }


    /**
     * Gets the omAlim value for this OmAlimrea.
     * 
     * @return omAlim
     */
    public idw.idwws.OmAlim getOmAlim() {
        return omAlim;
    }


    /**
     * Sets the omAlim value for this OmAlimrea.
     * 
     * @param omAlim
     */
    public void setOmAlim(idw.idwws.OmAlim omAlim) {
        this.omAlim = omAlim;
    }


    /**
     * Gets the omMapapa value for this OmAlimrea.
     * 
     * @return omMapapa
     */
    public idw.idwws.OmMapapa getOmMapapa() {
        return omMapapa;
    }


    /**
     * Sets the omMapapa value for this OmAlimrea.
     * 
     * @param omMapapa
     */
    public void setOmMapapa(idw.idwws.OmMapapa omMapapa) {
        this.omMapapa = omMapapa;
    }


    /**
     * Gets the omUsr value for this OmAlimrea.
     * 
     * @return omUsr
     */
    public idw.idwws.OmUsr getOmUsr() {
        return omUsr;
    }


    /**
     * Sets the omUsr value for this OmAlimrea.
     * 
     * @param omUsr
     */
    public void setOmUsr(idw.idwws.OmUsr omUsr) {
        this.omUsr = omUsr;
    }


    /**
     * Gets the qtAlimentada value for this OmAlimrea.
     * 
     * @return qtAlimentada
     */
    public java.lang.Integer getQtAlimentada() {
        return qtAlimentada;
    }


    /**
     * Sets the qtAlimentada value for this OmAlimrea.
     * 
     * @param qtAlimentada
     */
    public void setQtAlimentada(java.lang.Integer qtAlimentada) {
        this.qtAlimentada = qtAlimentada;
    }


    /**
     * Gets the stLeitura value for this OmAlimrea.
     * 
     * @return stLeitura
     */
    public java.lang.Byte getStLeitura() {
        return stLeitura;
    }


    /**
     * Sets the stLeitura value for this OmAlimrea.
     * 
     * @param stLeitura
     */
    public void setStLeitura(java.lang.Byte stLeitura) {
        this.stLeitura = stLeitura;
    }


    /**
     * Gets the tpLeitura value for this OmAlimrea.
     * 
     * @return tpLeitura
     */
    public java.lang.Byte getTpLeitura() {
        return tpLeitura;
    }


    /**
     * Sets the tpLeitura value for this OmAlimrea.
     * 
     * @param tpLeitura
     */
    public void setTpLeitura(java.lang.Byte tpLeitura) {
        this.tpLeitura = tpLeitura;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmAlimrea)) return false;
        OmAlimrea other = (OmAlimrea) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cbRap==null && other.getCbRap()==null) || 
             (this.cbRap!=null &&
              this.cbRap.equals(other.getCbRap()))) &&
            ((this.cdLido==null && other.getCdLido()==null) || 
             (this.cdLido!=null &&
              this.cdLido.equals(other.getCdLido()))) &&
            ((this.dthrLeitura==null && other.getDthrLeitura()==null) || 
             (this.dthrLeitura!=null &&
              this.dthrLeitura.equals(other.getDthrLeitura()))) &&
            ((this.idAlimrea==null && other.getIdAlimrea()==null) || 
             (this.idAlimrea!=null &&
              this.idAlimrea.equals(other.getIdAlimrea()))) &&
            ((this.omAlim==null && other.getOmAlim()==null) || 
             (this.omAlim!=null &&
              this.omAlim.equals(other.getOmAlim()))) &&
            ((this.omMapapa==null && other.getOmMapapa()==null) || 
             (this.omMapapa!=null &&
              this.omMapapa.equals(other.getOmMapapa()))) &&
            ((this.omUsr==null && other.getOmUsr()==null) || 
             (this.omUsr!=null &&
              this.omUsr.equals(other.getOmUsr()))) &&
            ((this.qtAlimentada==null && other.getQtAlimentada()==null) || 
             (this.qtAlimentada!=null &&
              this.qtAlimentada.equals(other.getQtAlimentada()))) &&
            ((this.stLeitura==null && other.getStLeitura()==null) || 
             (this.stLeitura!=null &&
              this.stLeitura.equals(other.getStLeitura()))) &&
            ((this.tpLeitura==null && other.getTpLeitura()==null) || 
             (this.tpLeitura!=null &&
              this.tpLeitura.equals(other.getTpLeitura())));
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
        if (getCbRap() != null) {
            _hashCode += getCbRap().hashCode();
        }
        if (getCdLido() != null) {
            _hashCode += getCdLido().hashCode();
        }
        if (getDthrLeitura() != null) {
            _hashCode += getDthrLeitura().hashCode();
        }
        if (getIdAlimrea() != null) {
            _hashCode += getIdAlimrea().hashCode();
        }
        if (getOmAlim() != null) {
            _hashCode += getOmAlim().hashCode();
        }
        if (getOmMapapa() != null) {
            _hashCode += getOmMapapa().hashCode();
        }
        if (getOmUsr() != null) {
            _hashCode += getOmUsr().hashCode();
        }
        if (getQtAlimentada() != null) {
            _hashCode += getQtAlimentada().hashCode();
        }
        if (getStLeitura() != null) {
            _hashCode += getStLeitura().hashCode();
        }
        if (getTpLeitura() != null) {
            _hashCode += getTpLeitura().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmAlimrea.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omAlimrea"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cbRap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cbRap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdLido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdLido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrLeitura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrLeitura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idAlimrea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idAlimrea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omAlim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omAlim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omAlim"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omMapapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omMapapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omMapapa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAlimentada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAlimentada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stLeitura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stLeitura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpLeitura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpLeitura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
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
