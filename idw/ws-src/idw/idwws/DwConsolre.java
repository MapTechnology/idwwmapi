/**
 * DwConsolre.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolre  implements java.io.Serializable {
    private idw.idwws.DwConsol dwConsol;

    private idw.idwws.DwConsolremo[] dwConsolremos;

    private idw.idwws.DwConsolreoco[] dwConsolreocos;

    private idw.idwws.DwTRefugo dwTRefugo;

    private long idConsolre;

    private java.math.BigDecimal pcsAutoProducaorefugada;

    private java.math.BigDecimal pcsManuProducaorefugada;

    public DwConsolre() {
    }

    public DwConsolre(
           idw.idwws.DwConsol dwConsol,
           idw.idwws.DwConsolremo[] dwConsolremos,
           idw.idwws.DwConsolreoco[] dwConsolreocos,
           idw.idwws.DwTRefugo dwTRefugo,
           long idConsolre,
           java.math.BigDecimal pcsAutoProducaorefugada,
           java.math.BigDecimal pcsManuProducaorefugada) {
           this.dwConsol = dwConsol;
           this.dwConsolremos = dwConsolremos;
           this.dwConsolreocos = dwConsolreocos;
           this.dwTRefugo = dwTRefugo;
           this.idConsolre = idConsolre;
           this.pcsAutoProducaorefugada = pcsAutoProducaorefugada;
           this.pcsManuProducaorefugada = pcsManuProducaorefugada;
    }


    /**
     * Gets the dwConsol value for this DwConsolre.
     * 
     * @return dwConsol
     */
    public idw.idwws.DwConsol getDwConsol() {
        return dwConsol;
    }


    /**
     * Sets the dwConsol value for this DwConsolre.
     * 
     * @param dwConsol
     */
    public void setDwConsol(idw.idwws.DwConsol dwConsol) {
        this.dwConsol = dwConsol;
    }


    /**
     * Gets the dwConsolremos value for this DwConsolre.
     * 
     * @return dwConsolremos
     */
    public idw.idwws.DwConsolremo[] getDwConsolremos() {
        return dwConsolremos;
    }


    /**
     * Sets the dwConsolremos value for this DwConsolre.
     * 
     * @param dwConsolremos
     */
    public void setDwConsolremos(idw.idwws.DwConsolremo[] dwConsolremos) {
        this.dwConsolremos = dwConsolremos;
    }

    public idw.idwws.DwConsolremo getDwConsolremos(int i) {
        return this.dwConsolremos[i];
    }

    public void setDwConsolremos(int i, idw.idwws.DwConsolremo _value) {
        this.dwConsolremos[i] = _value;
    }


    /**
     * Gets the dwConsolreocos value for this DwConsolre.
     * 
     * @return dwConsolreocos
     */
    public idw.idwws.DwConsolreoco[] getDwConsolreocos() {
        return dwConsolreocos;
    }


    /**
     * Sets the dwConsolreocos value for this DwConsolre.
     * 
     * @param dwConsolreocos
     */
    public void setDwConsolreocos(idw.idwws.DwConsolreoco[] dwConsolreocos) {
        this.dwConsolreocos = dwConsolreocos;
    }

    public idw.idwws.DwConsolreoco getDwConsolreocos(int i) {
        return this.dwConsolreocos[i];
    }

    public void setDwConsolreocos(int i, idw.idwws.DwConsolreoco _value) {
        this.dwConsolreocos[i] = _value;
    }


    /**
     * Gets the dwTRefugo value for this DwConsolre.
     * 
     * @return dwTRefugo
     */
    public idw.idwws.DwTRefugo getDwTRefugo() {
        return dwTRefugo;
    }


    /**
     * Sets the dwTRefugo value for this DwConsolre.
     * 
     * @param dwTRefugo
     */
    public void setDwTRefugo(idw.idwws.DwTRefugo dwTRefugo) {
        this.dwTRefugo = dwTRefugo;
    }


    /**
     * Gets the idConsolre value for this DwConsolre.
     * 
     * @return idConsolre
     */
    public long getIdConsolre() {
        return idConsolre;
    }


    /**
     * Sets the idConsolre value for this DwConsolre.
     * 
     * @param idConsolre
     */
    public void setIdConsolre(long idConsolre) {
        this.idConsolre = idConsolre;
    }


    /**
     * Gets the pcsAutoProducaorefugada value for this DwConsolre.
     * 
     * @return pcsAutoProducaorefugada
     */
    public java.math.BigDecimal getPcsAutoProducaorefugada() {
        return pcsAutoProducaorefugada;
    }


    /**
     * Sets the pcsAutoProducaorefugada value for this DwConsolre.
     * 
     * @param pcsAutoProducaorefugada
     */
    public void setPcsAutoProducaorefugada(java.math.BigDecimal pcsAutoProducaorefugada) {
        this.pcsAutoProducaorefugada = pcsAutoProducaorefugada;
    }


    /**
     * Gets the pcsManuProducaorefugada value for this DwConsolre.
     * 
     * @return pcsManuProducaorefugada
     */
    public java.math.BigDecimal getPcsManuProducaorefugada() {
        return pcsManuProducaorefugada;
    }


    /**
     * Sets the pcsManuProducaorefugada value for this DwConsolre.
     * 
     * @param pcsManuProducaorefugada
     */
    public void setPcsManuProducaorefugada(java.math.BigDecimal pcsManuProducaorefugada) {
        this.pcsManuProducaorefugada = pcsManuProducaorefugada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolre)) return false;
        DwConsolre other = (DwConsolre) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dwConsol==null && other.getDwConsol()==null) || 
             (this.dwConsol!=null &&
              this.dwConsol.equals(other.getDwConsol()))) &&
            ((this.dwConsolremos==null && other.getDwConsolremos()==null) || 
             (this.dwConsolremos!=null &&
              java.util.Arrays.equals(this.dwConsolremos, other.getDwConsolremos()))) &&
            ((this.dwConsolreocos==null && other.getDwConsolreocos()==null) || 
             (this.dwConsolreocos!=null &&
              java.util.Arrays.equals(this.dwConsolreocos, other.getDwConsolreocos()))) &&
            ((this.dwTRefugo==null && other.getDwTRefugo()==null) || 
             (this.dwTRefugo!=null &&
              this.dwTRefugo.equals(other.getDwTRefugo()))) &&
            this.idConsolre == other.getIdConsolre() &&
            ((this.pcsAutoProducaorefugada==null && other.getPcsAutoProducaorefugada()==null) || 
             (this.pcsAutoProducaorefugada!=null &&
              this.pcsAutoProducaorefugada.equals(other.getPcsAutoProducaorefugada()))) &&
            ((this.pcsManuProducaorefugada==null && other.getPcsManuProducaorefugada()==null) || 
             (this.pcsManuProducaorefugada!=null &&
              this.pcsManuProducaorefugada.equals(other.getPcsManuProducaorefugada())));
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
        if (getDwConsol() != null) {
            _hashCode += getDwConsol().hashCode();
        }
        if (getDwConsolremos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolremos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolremos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolreocos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolreocos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolreocos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTRefugo() != null) {
            _hashCode += getDwTRefugo().hashCode();
        }
        _hashCode += new Long(getIdConsolre()).hashCode();
        if (getPcsAutoProducaorefugada() != null) {
            _hashCode += getPcsAutoProducaorefugada().hashCode();
        }
        if (getPcsManuProducaorefugada() != null) {
            _hashCode += getPcsManuProducaorefugada().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolre.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolre"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolremos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolremos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolremo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolreocos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolreocos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolreoco"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTRefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTRefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTRefugo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsAutoProducaorefugada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsAutoProducaorefugada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsManuProducaorefugada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsManuProducaorefugada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
