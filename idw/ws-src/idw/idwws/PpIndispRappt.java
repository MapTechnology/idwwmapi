/**
 * PpIndispRappt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpIndispRappt  extends idw.idwws.PpIndispRapptTemplate  implements java.io.Serializable {
    private java.lang.String dsIndispRappt;

    private java.util.Calendar dthrFinal;

    private java.util.Calendar dthrInicio;

    private idw.idwws.DwRap dwRap;

    private java.lang.Long idIndispRappt;

    private idw.idwws.OmPt omPt;

    private idw.idwws.PpIndisp ppIndisp;

    private java.math.BigDecimal qtIndisp;

    private java.math.BigDecimal tpRecurso;

    public PpIndispRappt() {
    }

    public PpIndispRappt(
           java.lang.String dsIndispRappt,
           java.util.Calendar dthrFinal,
           java.util.Calendar dthrInicio,
           idw.idwws.DwRap dwRap,
           java.lang.Long idIndispRappt,
           idw.idwws.OmPt omPt,
           idw.idwws.PpIndisp ppIndisp,
           java.math.BigDecimal qtIndisp,
           java.math.BigDecimal tpRecurso) {
        this.dsIndispRappt = dsIndispRappt;
        this.dthrFinal = dthrFinal;
        this.dthrInicio = dthrInicio;
        this.dwRap = dwRap;
        this.idIndispRappt = idIndispRappt;
        this.omPt = omPt;
        this.ppIndisp = ppIndisp;
        this.qtIndisp = qtIndisp;
        this.tpRecurso = tpRecurso;
    }


    /**
     * Gets the dsIndispRappt value for this PpIndispRappt.
     * 
     * @return dsIndispRappt
     */
    public java.lang.String getDsIndispRappt() {
        return dsIndispRappt;
    }


    /**
     * Sets the dsIndispRappt value for this PpIndispRappt.
     * 
     * @param dsIndispRappt
     */
    public void setDsIndispRappt(java.lang.String dsIndispRappt) {
        this.dsIndispRappt = dsIndispRappt;
    }


    /**
     * Gets the dthrFinal value for this PpIndispRappt.
     * 
     * @return dthrFinal
     */
    public java.util.Calendar getDthrFinal() {
        return dthrFinal;
    }


    /**
     * Sets the dthrFinal value for this PpIndispRappt.
     * 
     * @param dthrFinal
     */
    public void setDthrFinal(java.util.Calendar dthrFinal) {
        this.dthrFinal = dthrFinal;
    }


    /**
     * Gets the dthrInicio value for this PpIndispRappt.
     * 
     * @return dthrInicio
     */
    public java.util.Calendar getDthrInicio() {
        return dthrInicio;
    }


    /**
     * Sets the dthrInicio value for this PpIndispRappt.
     * 
     * @param dthrInicio
     */
    public void setDthrInicio(java.util.Calendar dthrInicio) {
        this.dthrInicio = dthrInicio;
    }


    /**
     * Gets the dwRap value for this PpIndispRappt.
     * 
     * @return dwRap
     */
    public idw.idwws.DwRap getDwRap() {
        return dwRap;
    }


    /**
     * Sets the dwRap value for this PpIndispRappt.
     * 
     * @param dwRap
     */
    public void setDwRap(idw.idwws.DwRap dwRap) {
        this.dwRap = dwRap;
    }


    /**
     * Gets the idIndispRappt value for this PpIndispRappt.
     * 
     * @return idIndispRappt
     */
    public java.lang.Long getIdIndispRappt() {
        return idIndispRappt;
    }


    /**
     * Sets the idIndispRappt value for this PpIndispRappt.
     * 
     * @param idIndispRappt
     */
    public void setIdIndispRappt(java.lang.Long idIndispRappt) {
        this.idIndispRappt = idIndispRappt;
    }


    /**
     * Gets the omPt value for this PpIndispRappt.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this PpIndispRappt.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the ppIndisp value for this PpIndispRappt.
     * 
     * @return ppIndisp
     */
    public idw.idwws.PpIndisp getPpIndisp() {
        return ppIndisp;
    }


    /**
     * Sets the ppIndisp value for this PpIndispRappt.
     * 
     * @param ppIndisp
     */
    public void setPpIndisp(idw.idwws.PpIndisp ppIndisp) {
        this.ppIndisp = ppIndisp;
    }


    /**
     * Gets the qtIndisp value for this PpIndispRappt.
     * 
     * @return qtIndisp
     */
    public java.math.BigDecimal getQtIndisp() {
        return qtIndisp;
    }


    /**
     * Sets the qtIndisp value for this PpIndispRappt.
     * 
     * @param qtIndisp
     */
    public void setQtIndisp(java.math.BigDecimal qtIndisp) {
        this.qtIndisp = qtIndisp;
    }


    /**
     * Gets the tpRecurso value for this PpIndispRappt.
     * 
     * @return tpRecurso
     */
    public java.math.BigDecimal getTpRecurso() {
        return tpRecurso;
    }


    /**
     * Sets the tpRecurso value for this PpIndispRappt.
     * 
     * @param tpRecurso
     */
    public void setTpRecurso(java.math.BigDecimal tpRecurso) {
        this.tpRecurso = tpRecurso;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpIndispRappt)) return false;
        PpIndispRappt other = (PpIndispRappt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dsIndispRappt==null && other.getDsIndispRappt()==null) || 
             (this.dsIndispRappt!=null &&
              this.dsIndispRappt.equals(other.getDsIndispRappt()))) &&
            ((this.dthrFinal==null && other.getDthrFinal()==null) || 
             (this.dthrFinal!=null &&
              this.dthrFinal.equals(other.getDthrFinal()))) &&
            ((this.dthrInicio==null && other.getDthrInicio()==null) || 
             (this.dthrInicio!=null &&
              this.dthrInicio.equals(other.getDthrInicio()))) &&
            ((this.dwRap==null && other.getDwRap()==null) || 
             (this.dwRap!=null &&
              this.dwRap.equals(other.getDwRap()))) &&
            ((this.idIndispRappt==null && other.getIdIndispRappt()==null) || 
             (this.idIndispRappt!=null &&
              this.idIndispRappt.equals(other.getIdIndispRappt()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.ppIndisp==null && other.getPpIndisp()==null) || 
             (this.ppIndisp!=null &&
              this.ppIndisp.equals(other.getPpIndisp()))) &&
            ((this.qtIndisp==null && other.getQtIndisp()==null) || 
             (this.qtIndisp!=null &&
              this.qtIndisp.equals(other.getQtIndisp()))) &&
            ((this.tpRecurso==null && other.getTpRecurso()==null) || 
             (this.tpRecurso!=null &&
              this.tpRecurso.equals(other.getTpRecurso())));
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
        if (getDsIndispRappt() != null) {
            _hashCode += getDsIndispRappt().hashCode();
        }
        if (getDthrFinal() != null) {
            _hashCode += getDthrFinal().hashCode();
        }
        if (getDthrInicio() != null) {
            _hashCode += getDthrInicio().hashCode();
        }
        if (getDwRap() != null) {
            _hashCode += getDwRap().hashCode();
        }
        if (getIdIndispRappt() != null) {
            _hashCode += getIdIndispRappt().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getPpIndisp() != null) {
            _hashCode += getPpIndisp().hashCode();
        }
        if (getQtIndisp() != null) {
            _hashCode += getQtIndisp().hashCode();
        }
        if (getTpRecurso() != null) {
            _hashCode += getTpRecurso().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpIndispRappt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppIndispRappt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsIndispRappt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsIndispRappt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idIndispRappt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idIndispRappt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppIndisp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppIndisp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppIndisp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtIndisp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtIndisp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpRecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpRecurso"));
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
