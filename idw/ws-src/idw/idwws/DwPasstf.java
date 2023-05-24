/**
 * DwPasstf.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwPasstf  extends idw.idwws.DwPasstfTemplate  implements java.io.Serializable {
    private java.util.Calendar dthrFetapa;

    private java.util.Calendar dthrIetapa;

    private idw.idwws.DwFtEtapa dwFtEtapa;

    private idw.idwws.DwPassagem dwPassagem;

    private idw.idwws.DwPasscau dwPasscau;

    private idw.idwws.DwPasstfse[] dwPasstfses;

    private long idPasstf;

    private java.math.BigDecimal msDthrfetapa;

    private java.math.BigDecimal msDthrietapa;

    private java.lang.Integer ordemetapa;

    private java.lang.Integer stEtapa;

    public DwPasstf() {
    }

    public DwPasstf(
           java.util.Calendar dthrFetapa,
           java.util.Calendar dthrIetapa,
           idw.idwws.DwFtEtapa dwFtEtapa,
           idw.idwws.DwPassagem dwPassagem,
           idw.idwws.DwPasscau dwPasscau,
           idw.idwws.DwPasstfse[] dwPasstfses,
           long idPasstf,
           java.math.BigDecimal msDthrfetapa,
           java.math.BigDecimal msDthrietapa,
           java.lang.Integer ordemetapa,
           java.lang.Integer stEtapa) {
        this.dthrFetapa = dthrFetapa;
        this.dthrIetapa = dthrIetapa;
        this.dwFtEtapa = dwFtEtapa;
        this.dwPassagem = dwPassagem;
        this.dwPasscau = dwPasscau;
        this.dwPasstfses = dwPasstfses;
        this.idPasstf = idPasstf;
        this.msDthrfetapa = msDthrfetapa;
        this.msDthrietapa = msDthrietapa;
        this.ordemetapa = ordemetapa;
        this.stEtapa = stEtapa;
    }


    /**
     * Gets the dthrFetapa value for this DwPasstf.
     * 
     * @return dthrFetapa
     */
    public java.util.Calendar getDthrFetapa() {
        return dthrFetapa;
    }


    /**
     * Sets the dthrFetapa value for this DwPasstf.
     * 
     * @param dthrFetapa
     */
    public void setDthrFetapa(java.util.Calendar dthrFetapa) {
        this.dthrFetapa = dthrFetapa;
    }


    /**
     * Gets the dthrIetapa value for this DwPasstf.
     * 
     * @return dthrIetapa
     */
    public java.util.Calendar getDthrIetapa() {
        return dthrIetapa;
    }


    /**
     * Sets the dthrIetapa value for this DwPasstf.
     * 
     * @param dthrIetapa
     */
    public void setDthrIetapa(java.util.Calendar dthrIetapa) {
        this.dthrIetapa = dthrIetapa;
    }


    /**
     * Gets the dwFtEtapa value for this DwPasstf.
     * 
     * @return dwFtEtapa
     */
    public idw.idwws.DwFtEtapa getDwFtEtapa() {
        return dwFtEtapa;
    }


    /**
     * Sets the dwFtEtapa value for this DwPasstf.
     * 
     * @param dwFtEtapa
     */
    public void setDwFtEtapa(idw.idwws.DwFtEtapa dwFtEtapa) {
        this.dwFtEtapa = dwFtEtapa;
    }


    /**
     * Gets the dwPassagem value for this DwPasstf.
     * 
     * @return dwPassagem
     */
    public idw.idwws.DwPassagem getDwPassagem() {
        return dwPassagem;
    }


    /**
     * Sets the dwPassagem value for this DwPasstf.
     * 
     * @param dwPassagem
     */
    public void setDwPassagem(idw.idwws.DwPassagem dwPassagem) {
        this.dwPassagem = dwPassagem;
    }


    /**
     * Gets the dwPasscau value for this DwPasstf.
     * 
     * @return dwPasscau
     */
    public idw.idwws.DwPasscau getDwPasscau() {
        return dwPasscau;
    }


    /**
     * Sets the dwPasscau value for this DwPasstf.
     * 
     * @param dwPasscau
     */
    public void setDwPasscau(idw.idwws.DwPasscau dwPasscau) {
        this.dwPasscau = dwPasscau;
    }


    /**
     * Gets the dwPasstfses value for this DwPasstf.
     * 
     * @return dwPasstfses
     */
    public idw.idwws.DwPasstfse[] getDwPasstfses() {
        return dwPasstfses;
    }


    /**
     * Sets the dwPasstfses value for this DwPasstf.
     * 
     * @param dwPasstfses
     */
    public void setDwPasstfses(idw.idwws.DwPasstfse[] dwPasstfses) {
        this.dwPasstfses = dwPasstfses;
    }

    public idw.idwws.DwPasstfse getDwPasstfses(int i) {
        return this.dwPasstfses[i];
    }

    public void setDwPasstfses(int i, idw.idwws.DwPasstfse _value) {
        this.dwPasstfses[i] = _value;
    }


    /**
     * Gets the idPasstf value for this DwPasstf.
     * 
     * @return idPasstf
     */
    public long getIdPasstf() {
        return idPasstf;
    }


    /**
     * Sets the idPasstf value for this DwPasstf.
     * 
     * @param idPasstf
     */
    public void setIdPasstf(long idPasstf) {
        this.idPasstf = idPasstf;
    }


    /**
     * Gets the msDthrfetapa value for this DwPasstf.
     * 
     * @return msDthrfetapa
     */
    public java.math.BigDecimal getMsDthrfetapa() {
        return msDthrfetapa;
    }


    /**
     * Sets the msDthrfetapa value for this DwPasstf.
     * 
     * @param msDthrfetapa
     */
    public void setMsDthrfetapa(java.math.BigDecimal msDthrfetapa) {
        this.msDthrfetapa = msDthrfetapa;
    }


    /**
     * Gets the msDthrietapa value for this DwPasstf.
     * 
     * @return msDthrietapa
     */
    public java.math.BigDecimal getMsDthrietapa() {
        return msDthrietapa;
    }


    /**
     * Sets the msDthrietapa value for this DwPasstf.
     * 
     * @param msDthrietapa
     */
    public void setMsDthrietapa(java.math.BigDecimal msDthrietapa) {
        this.msDthrietapa = msDthrietapa;
    }


    /**
     * Gets the ordemetapa value for this DwPasstf.
     * 
     * @return ordemetapa
     */
    public java.lang.Integer getOrdemetapa() {
        return ordemetapa;
    }


    /**
     * Sets the ordemetapa value for this DwPasstf.
     * 
     * @param ordemetapa
     */
    public void setOrdemetapa(java.lang.Integer ordemetapa) {
        this.ordemetapa = ordemetapa;
    }


    /**
     * Gets the stEtapa value for this DwPasstf.
     * 
     * @return stEtapa
     */
    public java.lang.Integer getStEtapa() {
        return stEtapa;
    }


    /**
     * Sets the stEtapa value for this DwPasstf.
     * 
     * @param stEtapa
     */
    public void setStEtapa(java.lang.Integer stEtapa) {
        this.stEtapa = stEtapa;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwPasstf)) return false;
        DwPasstf other = (DwPasstf) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dthrFetapa==null && other.getDthrFetapa()==null) || 
             (this.dthrFetapa!=null &&
              this.dthrFetapa.equals(other.getDthrFetapa()))) &&
            ((this.dthrIetapa==null && other.getDthrIetapa()==null) || 
             (this.dthrIetapa!=null &&
              this.dthrIetapa.equals(other.getDthrIetapa()))) &&
            ((this.dwFtEtapa==null && other.getDwFtEtapa()==null) || 
             (this.dwFtEtapa!=null &&
              this.dwFtEtapa.equals(other.getDwFtEtapa()))) &&
            ((this.dwPassagem==null && other.getDwPassagem()==null) || 
             (this.dwPassagem!=null &&
              this.dwPassagem.equals(other.getDwPassagem()))) &&
            ((this.dwPasscau==null && other.getDwPasscau()==null) || 
             (this.dwPasscau!=null &&
              this.dwPasscau.equals(other.getDwPasscau()))) &&
            ((this.dwPasstfses==null && other.getDwPasstfses()==null) || 
             (this.dwPasstfses!=null &&
              java.util.Arrays.equals(this.dwPasstfses, other.getDwPasstfses()))) &&
            this.idPasstf == other.getIdPasstf() &&
            ((this.msDthrfetapa==null && other.getMsDthrfetapa()==null) || 
             (this.msDthrfetapa!=null &&
              this.msDthrfetapa.equals(other.getMsDthrfetapa()))) &&
            ((this.msDthrietapa==null && other.getMsDthrietapa()==null) || 
             (this.msDthrietapa!=null &&
              this.msDthrietapa.equals(other.getMsDthrietapa()))) &&
            ((this.ordemetapa==null && other.getOrdemetapa()==null) || 
             (this.ordemetapa!=null &&
              this.ordemetapa.equals(other.getOrdemetapa()))) &&
            ((this.stEtapa==null && other.getStEtapa()==null) || 
             (this.stEtapa!=null &&
              this.stEtapa.equals(other.getStEtapa())));
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
        if (getDthrFetapa() != null) {
            _hashCode += getDthrFetapa().hashCode();
        }
        if (getDthrIetapa() != null) {
            _hashCode += getDthrIetapa().hashCode();
        }
        if (getDwFtEtapa() != null) {
            _hashCode += getDwFtEtapa().hashCode();
        }
        if (getDwPassagem() != null) {
            _hashCode += getDwPassagem().hashCode();
        }
        if (getDwPasscau() != null) {
            _hashCode += getDwPasscau().hashCode();
        }
        if (getDwPasstfses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwPasstfses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwPasstfses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdPasstf()).hashCode();
        if (getMsDthrfetapa() != null) {
            _hashCode += getMsDthrfetapa().hashCode();
        }
        if (getMsDthrietapa() != null) {
            _hashCode += getMsDthrietapa().hashCode();
        }
        if (getOrdemetapa() != null) {
            _hashCode += getOrdemetapa().hashCode();
        }
        if (getStEtapa() != null) {
            _hashCode += getStEtapa().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwPasstf.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPasstf"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFetapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFetapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIetapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIetapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFtEtapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtEtapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtEtapa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPassagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPassagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPassagem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPasscau");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPasscau"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPasscau"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPasstfses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPasstfses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPasstfse"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPasstf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPasstf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrfetapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrfetapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDthrietapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDthrietapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordemetapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordemetapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stEtapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stEtapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
