/**
 * DwTestesubetapa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwTestesubetapa  extends idw.idwws.DwTestesubetapaTemplate  implements java.io.Serializable {
    private idw.idwws.DwFtSubparam dwFtSubparam;

    private idw.idwws.DwTestesub dwTestesub;

    private long idTestesubetapa;

    private java.math.BigDecimal maximo;

    private java.math.BigDecimal meta;

    private java.math.BigDecimal minimo;

    private java.lang.Byte st;

    public DwTestesubetapa() {
    }

    public DwTestesubetapa(
           idw.idwws.DwFtSubparam dwFtSubparam,
           idw.idwws.DwTestesub dwTestesub,
           long idTestesubetapa,
           java.math.BigDecimal maximo,
           java.math.BigDecimal meta,
           java.math.BigDecimal minimo,
           java.lang.Byte st) {
        this.dwFtSubparam = dwFtSubparam;
        this.dwTestesub = dwTestesub;
        this.idTestesubetapa = idTestesubetapa;
        this.maximo = maximo;
        this.meta = meta;
        this.minimo = minimo;
        this.st = st;
    }


    /**
     * Gets the dwFtSubparam value for this DwTestesubetapa.
     * 
     * @return dwFtSubparam
     */
    public idw.idwws.DwFtSubparam getDwFtSubparam() {
        return dwFtSubparam;
    }


    /**
     * Sets the dwFtSubparam value for this DwTestesubetapa.
     * 
     * @param dwFtSubparam
     */
    public void setDwFtSubparam(idw.idwws.DwFtSubparam dwFtSubparam) {
        this.dwFtSubparam = dwFtSubparam;
    }


    /**
     * Gets the dwTestesub value for this DwTestesubetapa.
     * 
     * @return dwTestesub
     */
    public idw.idwws.DwTestesub getDwTestesub() {
        return dwTestesub;
    }


    /**
     * Sets the dwTestesub value for this DwTestesubetapa.
     * 
     * @param dwTestesub
     */
    public void setDwTestesub(idw.idwws.DwTestesub dwTestesub) {
        this.dwTestesub = dwTestesub;
    }


    /**
     * Gets the idTestesubetapa value for this DwTestesubetapa.
     * 
     * @return idTestesubetapa
     */
    public long getIdTestesubetapa() {
        return idTestesubetapa;
    }


    /**
     * Sets the idTestesubetapa value for this DwTestesubetapa.
     * 
     * @param idTestesubetapa
     */
    public void setIdTestesubetapa(long idTestesubetapa) {
        this.idTestesubetapa = idTestesubetapa;
    }


    /**
     * Gets the maximo value for this DwTestesubetapa.
     * 
     * @return maximo
     */
    public java.math.BigDecimal getMaximo() {
        return maximo;
    }


    /**
     * Sets the maximo value for this DwTestesubetapa.
     * 
     * @param maximo
     */
    public void setMaximo(java.math.BigDecimal maximo) {
        this.maximo = maximo;
    }


    /**
     * Gets the meta value for this DwTestesubetapa.
     * 
     * @return meta
     */
    public java.math.BigDecimal getMeta() {
        return meta;
    }


    /**
     * Sets the meta value for this DwTestesubetapa.
     * 
     * @param meta
     */
    public void setMeta(java.math.BigDecimal meta) {
        this.meta = meta;
    }


    /**
     * Gets the minimo value for this DwTestesubetapa.
     * 
     * @return minimo
     */
    public java.math.BigDecimal getMinimo() {
        return minimo;
    }


    /**
     * Sets the minimo value for this DwTestesubetapa.
     * 
     * @param minimo
     */
    public void setMinimo(java.math.BigDecimal minimo) {
        this.minimo = minimo;
    }


    /**
     * Gets the st value for this DwTestesubetapa.
     * 
     * @return st
     */
    public java.lang.Byte getSt() {
        return st;
    }


    /**
     * Sets the st value for this DwTestesubetapa.
     * 
     * @param st
     */
    public void setSt(java.lang.Byte st) {
        this.st = st;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwTestesubetapa)) return false;
        DwTestesubetapa other = (DwTestesubetapa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwFtSubparam==null && other.getDwFtSubparam()==null) || 
             (this.dwFtSubparam!=null &&
              this.dwFtSubparam.equals(other.getDwFtSubparam()))) &&
            ((this.dwTestesub==null && other.getDwTestesub()==null) || 
             (this.dwTestesub!=null &&
              this.dwTestesub.equals(other.getDwTestesub()))) &&
            this.idTestesubetapa == other.getIdTestesubetapa() &&
            ((this.maximo==null && other.getMaximo()==null) || 
             (this.maximo!=null &&
              this.maximo.equals(other.getMaximo()))) &&
            ((this.meta==null && other.getMeta()==null) || 
             (this.meta!=null &&
              this.meta.equals(other.getMeta()))) &&
            ((this.minimo==null && other.getMinimo()==null) || 
             (this.minimo!=null &&
              this.minimo.equals(other.getMinimo()))) &&
            ((this.st==null && other.getSt()==null) || 
             (this.st!=null &&
              this.st.equals(other.getSt())));
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
        if (getDwFtSubparam() != null) {
            _hashCode += getDwFtSubparam().hashCode();
        }
        if (getDwTestesub() != null) {
            _hashCode += getDwTestesub().hashCode();
        }
        _hashCode += new Long(getIdTestesubetapa()).hashCode();
        if (getMaximo() != null) {
            _hashCode += getMaximo().hashCode();
        }
        if (getMeta() != null) {
            _hashCode += getMeta().hashCode();
        }
        if (getMinimo() != null) {
            _hashCode += getMinimo().hashCode();
        }
        if (getSt() != null) {
            _hashCode += getSt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwTestesubetapa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTestesubetapa"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFtSubparam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtSubparam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtSubparam"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTestesub");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTestesub"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTestesub"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTestesubetapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTestesubetapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maximo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maximo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("meta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "meta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minimo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "minimo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("st");
        elemField.setXmlName(new javax.xml.namespace.QName("", "st"));
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
