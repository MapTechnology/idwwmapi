/**
 * IwsAlertaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IwsAlertaDTO  implements java.io.Serializable {
    private java.lang.String cdAlerta;

    private java.lang.String dsAlerta;

    private java.lang.String idAlerta;

    private java.lang.Integer idRevisao;

    private java.lang.Integer stAlerta;

    private double tempolimite;

    private java.lang.Integer tpAlerta;

    private java.util.Calendar dthrinialerta;

    private double msDtHrIniAlerta;

    public IwsAlertaDTO() {
    }

    public IwsAlertaDTO(
           java.lang.String cdAlerta,
           java.lang.String dsAlerta,
           java.lang.String idAlerta,
           java.lang.Integer idRevisao,
           java.lang.Integer stAlerta,
           double tempolimite,
           java.lang.Integer tpAlerta,
           java.util.Calendar dthrinialerta,
           double msDtHrIniAlerta) {
           this.cdAlerta = cdAlerta;
           this.dsAlerta = dsAlerta;
           this.idAlerta = idAlerta;
           this.idRevisao = idRevisao;
           this.stAlerta = stAlerta;
           this.tempolimite = tempolimite;
           this.tpAlerta = tpAlerta;
           this.dthrinialerta = dthrinialerta;
           this.msDtHrIniAlerta = msDtHrIniAlerta;
    }


    /**
     * Gets the cdAlerta value for this IwsAlertaDTO.
     * 
     * @return cdAlerta
     */
    public java.lang.String getCdAlerta() {
        return cdAlerta;
    }


    /**
     * Sets the cdAlerta value for this IwsAlertaDTO.
     * 
     * @param cdAlerta
     */
    public void setCdAlerta(java.lang.String cdAlerta) {
        this.cdAlerta = cdAlerta;
    }


    /**
     * Gets the dsAlerta value for this IwsAlertaDTO.
     * 
     * @return dsAlerta
     */
    public java.lang.String getDsAlerta() {
        return dsAlerta;
    }


    /**
     * Sets the dsAlerta value for this IwsAlertaDTO.
     * 
     * @param dsAlerta
     */
    public void setDsAlerta(java.lang.String dsAlerta) {
        this.dsAlerta = dsAlerta;
    }


    /**
     * Gets the idAlerta value for this IwsAlertaDTO.
     * 
     * @return idAlerta
     */
    public java.lang.String getIdAlerta() {
        return idAlerta;
    }


    /**
     * Sets the idAlerta value for this IwsAlertaDTO.
     * 
     * @param idAlerta
     */
    public void setIdAlerta(java.lang.String idAlerta) {
        this.idAlerta = idAlerta;
    }


    /**
     * Gets the idRevisao value for this IwsAlertaDTO.
     * 
     * @return idRevisao
     */
    public java.lang.Integer getIdRevisao() {
        return idRevisao;
    }


    /**
     * Sets the idRevisao value for this IwsAlertaDTO.
     * 
     * @param idRevisao
     */
    public void setIdRevisao(java.lang.Integer idRevisao) {
        this.idRevisao = idRevisao;
    }


    /**
     * Gets the stAlerta value for this IwsAlertaDTO.
     * 
     * @return stAlerta
     */
    public java.lang.Integer getStAlerta() {
        return stAlerta;
    }


    /**
     * Sets the stAlerta value for this IwsAlertaDTO.
     * 
     * @param stAlerta
     */
    public void setStAlerta(java.lang.Integer stAlerta) {
        this.stAlerta = stAlerta;
    }


    /**
     * Gets the tempolimite value for this IwsAlertaDTO.
     * 
     * @return tempolimite
     */
    public double getTempolimite() {
        return tempolimite;
    }


    /**
     * Sets the tempolimite value for this IwsAlertaDTO.
     * 
     * @param tempolimite
     */
    public void setTempolimite(double tempolimite) {
        this.tempolimite = tempolimite;
    }


    /**
     * Gets the tpAlerta value for this IwsAlertaDTO.
     * 
     * @return tpAlerta
     */
    public java.lang.Integer getTpAlerta() {
        return tpAlerta;
    }


    /**
     * Sets the tpAlerta value for this IwsAlertaDTO.
     * 
     * @param tpAlerta
     */
    public void setTpAlerta(java.lang.Integer tpAlerta) {
        this.tpAlerta = tpAlerta;
    }


    /**
     * Gets the dthrinialerta value for this IwsAlertaDTO.
     * 
     * @return dthrinialerta
     */
    public java.util.Calendar getDthrinialerta() {
        return dthrinialerta;
    }


    /**
     * Sets the dthrinialerta value for this IwsAlertaDTO.
     * 
     * @param dthrinialerta
     */
    public void setDthrinialerta(java.util.Calendar dthrinialerta) {
        this.dthrinialerta = dthrinialerta;
    }


    /**
     * Gets the msDtHrIniAlerta value for this IwsAlertaDTO.
     * 
     * @return msDtHrIniAlerta
     */
    public double getMsDtHrIniAlerta() {
        return msDtHrIniAlerta;
    }


    /**
     * Sets the msDtHrIniAlerta value for this IwsAlertaDTO.
     * 
     * @param msDtHrIniAlerta
     */
    public void setMsDtHrIniAlerta(double msDtHrIniAlerta) {
        this.msDtHrIniAlerta = msDtHrIniAlerta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IwsAlertaDTO)) return false;
        IwsAlertaDTO other = (IwsAlertaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdAlerta==null && other.getCdAlerta()==null) || 
             (this.cdAlerta!=null &&
              this.cdAlerta.equals(other.getCdAlerta()))) &&
            ((this.dsAlerta==null && other.getDsAlerta()==null) || 
             (this.dsAlerta!=null &&
              this.dsAlerta.equals(other.getDsAlerta()))) &&
            ((this.idAlerta==null && other.getIdAlerta()==null) || 
             (this.idAlerta!=null &&
              this.idAlerta.equals(other.getIdAlerta()))) &&
            ((this.idRevisao==null && other.getIdRevisao()==null) || 
             (this.idRevisao!=null &&
              this.idRevisao.equals(other.getIdRevisao()))) &&
            ((this.stAlerta==null && other.getStAlerta()==null) || 
             (this.stAlerta!=null &&
              this.stAlerta.equals(other.getStAlerta()))) &&
            this.tempolimite == other.getTempolimite() &&
            ((this.tpAlerta==null && other.getTpAlerta()==null) || 
             (this.tpAlerta!=null &&
              this.tpAlerta.equals(other.getTpAlerta()))) &&
            ((this.dthrinialerta==null && other.getDthrinialerta()==null) || 
             (this.dthrinialerta!=null &&
              this.dthrinialerta.equals(other.getDthrinialerta()))) &&
            this.msDtHrIniAlerta == other.getMsDtHrIniAlerta();
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
        if (getCdAlerta() != null) {
            _hashCode += getCdAlerta().hashCode();
        }
        if (getDsAlerta() != null) {
            _hashCode += getDsAlerta().hashCode();
        }
        if (getIdAlerta() != null) {
            _hashCode += getIdAlerta().hashCode();
        }
        if (getIdRevisao() != null) {
            _hashCode += getIdRevisao().hashCode();
        }
        if (getStAlerta() != null) {
            _hashCode += getStAlerta().hashCode();
        }
        _hashCode += new Double(getTempolimite()).hashCode();
        if (getTpAlerta() != null) {
            _hashCode += getTpAlerta().hashCode();
        }
        if (getDthrinialerta() != null) {
            _hashCode += getDthrinialerta().hashCode();
        }
        _hashCode += new Double(getMsDtHrIniAlerta()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IwsAlertaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "iwsAlertaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdAlerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdAlerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsAlerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsAlerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idAlerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idAlerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idRevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idRevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stAlerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stAlerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempolimite");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempolimite"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpAlerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpAlerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrinialerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrinialerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDtHrIniAlerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDtHrIniAlerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
