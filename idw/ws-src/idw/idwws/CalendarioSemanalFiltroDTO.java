/**
 * CalendarioSemanalFiltroDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class CalendarioSemanalFiltroDTO  implements java.io.Serializable {
    private java.util.Calendar dthrCalendario;

    private java.util.Calendar dthrFCalendario;

    private java.util.Calendar dthrICalendario;

    private long idCal;

    public CalendarioSemanalFiltroDTO() {
    }

    public CalendarioSemanalFiltroDTO(
           java.util.Calendar dthrCalendario,
           java.util.Calendar dthrFCalendario,
           java.util.Calendar dthrICalendario,
           long idCal) {
           this.dthrCalendario = dthrCalendario;
           this.dthrFCalendario = dthrFCalendario;
           this.dthrICalendario = dthrICalendario;
           this.idCal = idCal;
    }


    /**
     * Gets the dthrCalendario value for this CalendarioSemanalFiltroDTO.
     * 
     * @return dthrCalendario
     */
    public java.util.Calendar getDthrCalendario() {
        return dthrCalendario;
    }


    /**
     * Sets the dthrCalendario value for this CalendarioSemanalFiltroDTO.
     * 
     * @param dthrCalendario
     */
    public void setDthrCalendario(java.util.Calendar dthrCalendario) {
        this.dthrCalendario = dthrCalendario;
    }


    /**
     * Gets the dthrFCalendario value for this CalendarioSemanalFiltroDTO.
     * 
     * @return dthrFCalendario
     */
    public java.util.Calendar getDthrFCalendario() {
        return dthrFCalendario;
    }


    /**
     * Sets the dthrFCalendario value for this CalendarioSemanalFiltroDTO.
     * 
     * @param dthrFCalendario
     */
    public void setDthrFCalendario(java.util.Calendar dthrFCalendario) {
        this.dthrFCalendario = dthrFCalendario;
    }


    /**
     * Gets the dthrICalendario value for this CalendarioSemanalFiltroDTO.
     * 
     * @return dthrICalendario
     */
    public java.util.Calendar getDthrICalendario() {
        return dthrICalendario;
    }


    /**
     * Sets the dthrICalendario value for this CalendarioSemanalFiltroDTO.
     * 
     * @param dthrICalendario
     */
    public void setDthrICalendario(java.util.Calendar dthrICalendario) {
        this.dthrICalendario = dthrICalendario;
    }


    /**
     * Gets the idCal value for this CalendarioSemanalFiltroDTO.
     * 
     * @return idCal
     */
    public long getIdCal() {
        return idCal;
    }


    /**
     * Sets the idCal value for this CalendarioSemanalFiltroDTO.
     * 
     * @param idCal
     */
    public void setIdCal(long idCal) {
        this.idCal = idCal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CalendarioSemanalFiltroDTO)) return false;
        CalendarioSemanalFiltroDTO other = (CalendarioSemanalFiltroDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrCalendario==null && other.getDthrCalendario()==null) || 
             (this.dthrCalendario!=null &&
              this.dthrCalendario.equals(other.getDthrCalendario()))) &&
            ((this.dthrFCalendario==null && other.getDthrFCalendario()==null) || 
             (this.dthrFCalendario!=null &&
              this.dthrFCalendario.equals(other.getDthrFCalendario()))) &&
            ((this.dthrICalendario==null && other.getDthrICalendario()==null) || 
             (this.dthrICalendario!=null &&
              this.dthrICalendario.equals(other.getDthrICalendario()))) &&
            this.idCal == other.getIdCal();
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
        if (getDthrCalendario() != null) {
            _hashCode += getDthrCalendario().hashCode();
        }
        if (getDthrFCalendario() != null) {
            _hashCode += getDthrFCalendario().hashCode();
        }
        if (getDthrICalendario() != null) {
            _hashCode += getDthrICalendario().hashCode();
        }
        _hashCode += new Long(getIdCal()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CalendarioSemanalFiltroDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "calendarioSemanalFiltroDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrCalendario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrCalendario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFCalendario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFCalendario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrICalendario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrICalendario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
