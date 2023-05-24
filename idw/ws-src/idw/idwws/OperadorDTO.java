/**
 * OperadorDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OperadorDTO  implements java.io.Serializable {
    private java.util.Calendar dthrFlogin;

    private java.util.Calendar dthrIlogin;

    private idw.idwws.OmPt maquina;

    private java.lang.Integer msDthrflogin;

    private java.lang.Integer msDthrilogin;

    private idw.idwws.OmUsr omUsr;

    private idw.idwws.PpCp ordemproducao;

    public OperadorDTO() {
    }

    public OperadorDTO(
           java.util.Calendar dthrFlogin,
           java.util.Calendar dthrIlogin,
           idw.idwws.OmPt maquina,
           java.lang.Integer msDthrflogin,
           java.lang.Integer msDthrilogin,
           idw.idwws.OmUsr omUsr,
           idw.idwws.PpCp ordemproducao) {
           this.dthrFlogin = dthrFlogin;
           this.dthrIlogin = dthrIlogin;
           this.maquina = maquina;
           this.msDthrflogin = msDthrflogin;
           this.msDthrilogin = msDthrilogin;
           this.omUsr = omUsr;
           this.ordemproducao = ordemproducao;
    }


    /**
     * Gets the dthrFlogin value for this OperadorDTO.
     * 
     * @return dthrFlogin
     */
    public java.util.Calendar getDthrFlogin() {
        return dthrFlogin;
    }


    /**
     * Sets the dthrFlogin value for this OperadorDTO.
     * 
     * @param dthrFlogin
     */
    public void setDthrFlogin(java.util.Calendar dthrFlogin) {
        this.dthrFlogin = dthrFlogin;
    }


    /**
     * Gets the dthrIlogin value for this OperadorDTO.
     * 
     * @return dthrIlogin
     */
    public java.util.Calendar getDthrIlogin() {
        return dthrIlogin;
    }


    /**
     * Sets the dthrIlogin value for this OperadorDTO.
     * 
     * @param dthrIlogin
     */
    public void setDthrIlogin(java.util.Calendar dthrIlogin) {
        this.dthrIlogin = dthrIlogin;
    }


    /**
     * Gets the maquina value for this OperadorDTO.
     * 
     * @return maquina
     */
    public idw.idwws.OmPt getMaquina() {
        return maquina;
    }


    /**
     * Sets the maquina value for this OperadorDTO.
     * 
     * @param maquina
     */
    public void setMaquina(idw.idwws.OmPt maquina) {
        this.maquina = maquina;
    }


    /**
     * Gets the msDthrflogin value for this OperadorDTO.
     * 
     * @return msDthrflogin
     */
    public java.lang.Integer getMsDthrflogin() {
        return msDthrflogin;
    }


    /**
     * Sets the msDthrflogin value for this OperadorDTO.
     * 
     * @param msDthrflogin
     */
    public void setMsDthrflogin(java.lang.Integer msDthrflogin) {
        this.msDthrflogin = msDthrflogin;
    }


    /**
     * Gets the msDthrilogin value for this OperadorDTO.
     * 
     * @return msDthrilogin
     */
    public java.lang.Integer getMsDthrilogin() {
        return msDthrilogin;
    }


    /**
     * Sets the msDthrilogin value for this OperadorDTO.
     * 
     * @param msDthrilogin
     */
    public void setMsDthrilogin(java.lang.Integer msDthrilogin) {
        this.msDthrilogin = msDthrilogin;
    }


    /**
     * Gets the omUsr value for this OperadorDTO.
     * 
     * @return omUsr
     */
    public idw.idwws.OmUsr getOmUsr() {
        return omUsr;
    }


    /**
     * Sets the omUsr value for this OperadorDTO.
     * 
     * @param omUsr
     */
    public void setOmUsr(idw.idwws.OmUsr omUsr) {
        this.omUsr = omUsr;
    }


    /**
     * Gets the ordemproducao value for this OperadorDTO.
     * 
     * @return ordemproducao
     */
    public idw.idwws.PpCp getOrdemproducao() {
        return ordemproducao;
    }


    /**
     * Sets the ordemproducao value for this OperadorDTO.
     * 
     * @param ordemproducao
     */
    public void setOrdemproducao(idw.idwws.PpCp ordemproducao) {
        this.ordemproducao = ordemproducao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OperadorDTO)) return false;
        OperadorDTO other = (OperadorDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrFlogin==null && other.getDthrFlogin()==null) || 
             (this.dthrFlogin!=null &&
              this.dthrFlogin.equals(other.getDthrFlogin()))) &&
            ((this.dthrIlogin==null && other.getDthrIlogin()==null) || 
             (this.dthrIlogin!=null &&
              this.dthrIlogin.equals(other.getDthrIlogin()))) &&
            ((this.maquina==null && other.getMaquina()==null) || 
             (this.maquina!=null &&
              this.maquina.equals(other.getMaquina()))) &&
            ((this.msDthrflogin==null && other.getMsDthrflogin()==null) || 
             (this.msDthrflogin!=null &&
              this.msDthrflogin.equals(other.getMsDthrflogin()))) &&
            ((this.msDthrilogin==null && other.getMsDthrilogin()==null) || 
             (this.msDthrilogin!=null &&
              this.msDthrilogin.equals(other.getMsDthrilogin()))) &&
            ((this.omUsr==null && other.getOmUsr()==null) || 
             (this.omUsr!=null &&
              this.omUsr.equals(other.getOmUsr()))) &&
            ((this.ordemproducao==null && other.getOrdemproducao()==null) || 
             (this.ordemproducao!=null &&
              this.ordemproducao.equals(other.getOrdemproducao())));
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
        if (getDthrFlogin() != null) {
            _hashCode += getDthrFlogin().hashCode();
        }
        if (getDthrIlogin() != null) {
            _hashCode += getDthrIlogin().hashCode();
        }
        if (getMaquina() != null) {
            _hashCode += getMaquina().hashCode();
        }
        if (getMsDthrflogin() != null) {
            _hashCode += getMsDthrflogin().hashCode();
        }
        if (getMsDthrilogin() != null) {
            _hashCode += getMsDthrilogin().hashCode();
        }
        if (getOmUsr() != null) {
            _hashCode += getOmUsr().hashCode();
        }
        if (getOrdemproducao() != null) {
            _hashCode += getOrdemproducao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OperadorDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "operadorDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFlogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFlogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIlogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIlogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrflogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrflogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrilogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrilogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("ordemproducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordemproducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
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
