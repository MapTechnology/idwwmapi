/**
 * OmCfgind.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmCfgind  extends idw.idwws.OmCfgindTemplate  implements java.io.Serializable {
    private java.lang.Long idCfgind;

    private java.math.BigDecimal indInferior;

    private java.math.BigDecimal indMeta;

    private java.math.BigDecimal indSuperior;

    private idw.idwws.OmCfg omCfg;

    private idw.idwws.OmInd omInd;

    public OmCfgind() {
    }

    public OmCfgind(
           java.lang.Long idCfgind,
           java.math.BigDecimal indInferior,
           java.math.BigDecimal indMeta,
           java.math.BigDecimal indSuperior,
           idw.idwws.OmCfg omCfg,
           idw.idwws.OmInd omInd) {
        this.idCfgind = idCfgind;
        this.indInferior = indInferior;
        this.indMeta = indMeta;
        this.indSuperior = indSuperior;
        this.omCfg = omCfg;
        this.omInd = omInd;
    }


    /**
     * Gets the idCfgind value for this OmCfgind.
     * 
     * @return idCfgind
     */
    public java.lang.Long getIdCfgind() {
        return idCfgind;
    }


    /**
     * Sets the idCfgind value for this OmCfgind.
     * 
     * @param idCfgind
     */
    public void setIdCfgind(java.lang.Long idCfgind) {
        this.idCfgind = idCfgind;
    }


    /**
     * Gets the indInferior value for this OmCfgind.
     * 
     * @return indInferior
     */
    public java.math.BigDecimal getIndInferior() {
        return indInferior;
    }


    /**
     * Sets the indInferior value for this OmCfgind.
     * 
     * @param indInferior
     */
    public void setIndInferior(java.math.BigDecimal indInferior) {
        this.indInferior = indInferior;
    }


    /**
     * Gets the indMeta value for this OmCfgind.
     * 
     * @return indMeta
     */
    public java.math.BigDecimal getIndMeta() {
        return indMeta;
    }


    /**
     * Sets the indMeta value for this OmCfgind.
     * 
     * @param indMeta
     */
    public void setIndMeta(java.math.BigDecimal indMeta) {
        this.indMeta = indMeta;
    }


    /**
     * Gets the indSuperior value for this OmCfgind.
     * 
     * @return indSuperior
     */
    public java.math.BigDecimal getIndSuperior() {
        return indSuperior;
    }


    /**
     * Sets the indSuperior value for this OmCfgind.
     * 
     * @param indSuperior
     */
    public void setIndSuperior(java.math.BigDecimal indSuperior) {
        this.indSuperior = indSuperior;
    }


    /**
     * Gets the omCfg value for this OmCfgind.
     * 
     * @return omCfg
     */
    public idw.idwws.OmCfg getOmCfg() {
        return omCfg;
    }


    /**
     * Sets the omCfg value for this OmCfgind.
     * 
     * @param omCfg
     */
    public void setOmCfg(idw.idwws.OmCfg omCfg) {
        this.omCfg = omCfg;
    }


    /**
     * Gets the omInd value for this OmCfgind.
     * 
     * @return omInd
     */
    public idw.idwws.OmInd getOmInd() {
        return omInd;
    }


    /**
     * Sets the omInd value for this OmCfgind.
     * 
     * @param omInd
     */
    public void setOmInd(idw.idwws.OmInd omInd) {
        this.omInd = omInd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmCfgind)) return false;
        OmCfgind other = (OmCfgind) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.idCfgind==null && other.getIdCfgind()==null) || 
             (this.idCfgind!=null &&
              this.idCfgind.equals(other.getIdCfgind()))) &&
            ((this.indInferior==null && other.getIndInferior()==null) || 
             (this.indInferior!=null &&
              this.indInferior.equals(other.getIndInferior()))) &&
            ((this.indMeta==null && other.getIndMeta()==null) || 
             (this.indMeta!=null &&
              this.indMeta.equals(other.getIndMeta()))) &&
            ((this.indSuperior==null && other.getIndSuperior()==null) || 
             (this.indSuperior!=null &&
              this.indSuperior.equals(other.getIndSuperior()))) &&
            ((this.omCfg==null && other.getOmCfg()==null) || 
             (this.omCfg!=null &&
              this.omCfg.equals(other.getOmCfg()))) &&
            ((this.omInd==null && other.getOmInd()==null) || 
             (this.omInd!=null &&
              this.omInd.equals(other.getOmInd())));
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
        if (getIdCfgind() != null) {
            _hashCode += getIdCfgind().hashCode();
        }
        if (getIndInferior() != null) {
            _hashCode += getIndInferior().hashCode();
        }
        if (getIndMeta() != null) {
            _hashCode += getIndMeta().hashCode();
        }
        if (getIndSuperior() != null) {
            _hashCode += getIndSuperior().hashCode();
        }
        if (getOmCfg() != null) {
            _hashCode += getOmCfg().hashCode();
        }
        if (getOmInd() != null) {
            _hashCode += getOmInd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmCfgind.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfgind"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCfgind");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCfgind"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indInferior");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indInferior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indMeta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indMeta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indSuperior");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indSuperior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omInd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omInd"));
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
