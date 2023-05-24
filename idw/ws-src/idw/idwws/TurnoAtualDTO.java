/**
 * TurnoAtualDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class TurnoAtualDTO  extends idw.idwws.AbstractTemplate  implements java.io.Serializable {
    private java.lang.String cdTurno;

    private java.math.BigDecimal dtHrFHora;

    private java.util.Calendar dtHrFTurno;

    private java.math.BigDecimal dtHrIHora;

    private java.util.Calendar dtHrITurno;

    private java.util.Calendar dtReferencia;

    private idw.idwws.DwCal dwcal;

    private idw.idwws.DwTurno dwturno;

    private long idCal;

    private long idTurno;

    private java.math.BigDecimal segPosTolerancia;

    private java.math.BigDecimal segPreTolerancia;

    public TurnoAtualDTO() {
    }

    public TurnoAtualDTO(
           java.lang.String cdTurno,
           java.math.BigDecimal dtHrFHora,
           java.util.Calendar dtHrFTurno,
           java.math.BigDecimal dtHrIHora,
           java.util.Calendar dtHrITurno,
           java.util.Calendar dtReferencia,
           idw.idwws.DwCal dwcal,
           idw.idwws.DwTurno dwturno,
           long idCal,
           long idTurno,
           java.math.BigDecimal segPosTolerancia,
           java.math.BigDecimal segPreTolerancia) {
        this.cdTurno = cdTurno;
        this.dtHrFHora = dtHrFHora;
        this.dtHrFTurno = dtHrFTurno;
        this.dtHrIHora = dtHrIHora;
        this.dtHrITurno = dtHrITurno;
        this.dtReferencia = dtReferencia;
        this.dwcal = dwcal;
        this.dwturno = dwturno;
        this.idCal = idCal;
        this.idTurno = idTurno;
        this.segPosTolerancia = segPosTolerancia;
        this.segPreTolerancia = segPreTolerancia;
    }


    /**
     * Gets the cdTurno value for this TurnoAtualDTO.
     * 
     * @return cdTurno
     */
    public java.lang.String getCdTurno() {
        return cdTurno;
    }


    /**
     * Sets the cdTurno value for this TurnoAtualDTO.
     * 
     * @param cdTurno
     */
    public void setCdTurno(java.lang.String cdTurno) {
        this.cdTurno = cdTurno;
    }


    /**
     * Gets the dtHrFHora value for this TurnoAtualDTO.
     * 
     * @return dtHrFHora
     */
    public java.math.BigDecimal getDtHrFHora() {
        return dtHrFHora;
    }


    /**
     * Sets the dtHrFHora value for this TurnoAtualDTO.
     * 
     * @param dtHrFHora
     */
    public void setDtHrFHora(java.math.BigDecimal dtHrFHora) {
        this.dtHrFHora = dtHrFHora;
    }


    /**
     * Gets the dtHrFTurno value for this TurnoAtualDTO.
     * 
     * @return dtHrFTurno
     */
    public java.util.Calendar getDtHrFTurno() {
        return dtHrFTurno;
    }


    /**
     * Sets the dtHrFTurno value for this TurnoAtualDTO.
     * 
     * @param dtHrFTurno
     */
    public void setDtHrFTurno(java.util.Calendar dtHrFTurno) {
        this.dtHrFTurno = dtHrFTurno;
    }


    /**
     * Gets the dtHrIHora value for this TurnoAtualDTO.
     * 
     * @return dtHrIHora
     */
    public java.math.BigDecimal getDtHrIHora() {
        return dtHrIHora;
    }


    /**
     * Sets the dtHrIHora value for this TurnoAtualDTO.
     * 
     * @param dtHrIHora
     */
    public void setDtHrIHora(java.math.BigDecimal dtHrIHora) {
        this.dtHrIHora = dtHrIHora;
    }


    /**
     * Gets the dtHrITurno value for this TurnoAtualDTO.
     * 
     * @return dtHrITurno
     */
    public java.util.Calendar getDtHrITurno() {
        return dtHrITurno;
    }


    /**
     * Sets the dtHrITurno value for this TurnoAtualDTO.
     * 
     * @param dtHrITurno
     */
    public void setDtHrITurno(java.util.Calendar dtHrITurno) {
        this.dtHrITurno = dtHrITurno;
    }


    /**
     * Gets the dtReferencia value for this TurnoAtualDTO.
     * 
     * @return dtReferencia
     */
    public java.util.Calendar getDtReferencia() {
        return dtReferencia;
    }


    /**
     * Sets the dtReferencia value for this TurnoAtualDTO.
     * 
     * @param dtReferencia
     */
    public void setDtReferencia(java.util.Calendar dtReferencia) {
        this.dtReferencia = dtReferencia;
    }


    /**
     * Gets the dwcal value for this TurnoAtualDTO.
     * 
     * @return dwcal
     */
    public idw.idwws.DwCal getDwcal() {
        return dwcal;
    }


    /**
     * Sets the dwcal value for this TurnoAtualDTO.
     * 
     * @param dwcal
     */
    public void setDwcal(idw.idwws.DwCal dwcal) {
        this.dwcal = dwcal;
    }


    /**
     * Gets the dwturno value for this TurnoAtualDTO.
     * 
     * @return dwturno
     */
    public idw.idwws.DwTurno getDwturno() {
        return dwturno;
    }


    /**
     * Sets the dwturno value for this TurnoAtualDTO.
     * 
     * @param dwturno
     */
    public void setDwturno(idw.idwws.DwTurno dwturno) {
        this.dwturno = dwturno;
    }


    /**
     * Gets the idCal value for this TurnoAtualDTO.
     * 
     * @return idCal
     */
    public long getIdCal() {
        return idCal;
    }


    /**
     * Sets the idCal value for this TurnoAtualDTO.
     * 
     * @param idCal
     */
    public void setIdCal(long idCal) {
        this.idCal = idCal;
    }


    /**
     * Gets the idTurno value for this TurnoAtualDTO.
     * 
     * @return idTurno
     */
    public long getIdTurno() {
        return idTurno;
    }


    /**
     * Sets the idTurno value for this TurnoAtualDTO.
     * 
     * @param idTurno
     */
    public void setIdTurno(long idTurno) {
        this.idTurno = idTurno;
    }


    /**
     * Gets the segPosTolerancia value for this TurnoAtualDTO.
     * 
     * @return segPosTolerancia
     */
    public java.math.BigDecimal getSegPosTolerancia() {
        return segPosTolerancia;
    }


    /**
     * Sets the segPosTolerancia value for this TurnoAtualDTO.
     * 
     * @param segPosTolerancia
     */
    public void setSegPosTolerancia(java.math.BigDecimal segPosTolerancia) {
        this.segPosTolerancia = segPosTolerancia;
    }


    /**
     * Gets the segPreTolerancia value for this TurnoAtualDTO.
     * 
     * @return segPreTolerancia
     */
    public java.math.BigDecimal getSegPreTolerancia() {
        return segPreTolerancia;
    }


    /**
     * Sets the segPreTolerancia value for this TurnoAtualDTO.
     * 
     * @param segPreTolerancia
     */
    public void setSegPreTolerancia(java.math.BigDecimal segPreTolerancia) {
        this.segPreTolerancia = segPreTolerancia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TurnoAtualDTO)) return false;
        TurnoAtualDTO other = (TurnoAtualDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdTurno==null && other.getCdTurno()==null) || 
             (this.cdTurno!=null &&
              this.cdTurno.equals(other.getCdTurno()))) &&
            ((this.dtHrFHora==null && other.getDtHrFHora()==null) || 
             (this.dtHrFHora!=null &&
              this.dtHrFHora.equals(other.getDtHrFHora()))) &&
            ((this.dtHrFTurno==null && other.getDtHrFTurno()==null) || 
             (this.dtHrFTurno!=null &&
              this.dtHrFTurno.equals(other.getDtHrFTurno()))) &&
            ((this.dtHrIHora==null && other.getDtHrIHora()==null) || 
             (this.dtHrIHora!=null &&
              this.dtHrIHora.equals(other.getDtHrIHora()))) &&
            ((this.dtHrITurno==null && other.getDtHrITurno()==null) || 
             (this.dtHrITurno!=null &&
              this.dtHrITurno.equals(other.getDtHrITurno()))) &&
            ((this.dtReferencia==null && other.getDtReferencia()==null) || 
             (this.dtReferencia!=null &&
              this.dtReferencia.equals(other.getDtReferencia()))) &&
            ((this.dwcal==null && other.getDwcal()==null) || 
             (this.dwcal!=null &&
              this.dwcal.equals(other.getDwcal()))) &&
            ((this.dwturno==null && other.getDwturno()==null) || 
             (this.dwturno!=null &&
              this.dwturno.equals(other.getDwturno()))) &&
            this.idCal == other.getIdCal() &&
            this.idTurno == other.getIdTurno() &&
            ((this.segPosTolerancia==null && other.getSegPosTolerancia()==null) || 
             (this.segPosTolerancia!=null &&
              this.segPosTolerancia.equals(other.getSegPosTolerancia()))) &&
            ((this.segPreTolerancia==null && other.getSegPreTolerancia()==null) || 
             (this.segPreTolerancia!=null &&
              this.segPreTolerancia.equals(other.getSegPreTolerancia())));
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
        if (getCdTurno() != null) {
            _hashCode += getCdTurno().hashCode();
        }
        if (getDtHrFHora() != null) {
            _hashCode += getDtHrFHora().hashCode();
        }
        if (getDtHrFTurno() != null) {
            _hashCode += getDtHrFTurno().hashCode();
        }
        if (getDtHrIHora() != null) {
            _hashCode += getDtHrIHora().hashCode();
        }
        if (getDtHrITurno() != null) {
            _hashCode += getDtHrITurno().hashCode();
        }
        if (getDtReferencia() != null) {
            _hashCode += getDtReferencia().hashCode();
        }
        if (getDwcal() != null) {
            _hashCode += getDwcal().hashCode();
        }
        if (getDwturno() != null) {
            _hashCode += getDwturno().hashCode();
        }
        _hashCode += new Long(getIdCal()).hashCode();
        _hashCode += new Long(getIdTurno()).hashCode();
        if (getSegPosTolerancia() != null) {
            _hashCode += getSegPosTolerancia().hashCode();
        }
        if (getSegPreTolerancia() != null) {
            _hashCode += getSegPreTolerancia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TurnoAtualDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "turnoAtualDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtHrFHora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtHrFHora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtHrFTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtHrFTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtHrIHora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtHrIHora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtHrITurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtHrITurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwcal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwcal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTurno"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCal"));
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
        elemField.setFieldName("segPosTolerancia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segPosTolerancia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segPreTolerancia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segPreTolerancia"));
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
