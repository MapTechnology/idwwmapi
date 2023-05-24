/**
 * OmClidiario.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmClidiario  implements java.io.Serializable {
    private java.lang.String dsDiario;

    private java.util.Calendar dthrFim;

    private java.util.Calendar dthrInicio;

    private double idClidiario;

    private idw.idwws.PpCliente ppCliente;

    public OmClidiario() {
    }

    public OmClidiario(
           java.lang.String dsDiario,
           java.util.Calendar dthrFim,
           java.util.Calendar dthrInicio,
           double idClidiario,
           idw.idwws.PpCliente ppCliente) {
           this.dsDiario = dsDiario;
           this.dthrFim = dthrFim;
           this.dthrInicio = dthrInicio;
           this.idClidiario = idClidiario;
           this.ppCliente = ppCliente;
    }


    /**
     * Gets the dsDiario value for this OmClidiario.
     * 
     * @return dsDiario
     */
    public java.lang.String getDsDiario() {
        return dsDiario;
    }


    /**
     * Sets the dsDiario value for this OmClidiario.
     * 
     * @param dsDiario
     */
    public void setDsDiario(java.lang.String dsDiario) {
        this.dsDiario = dsDiario;
    }


    /**
     * Gets the dthrFim value for this OmClidiario.
     * 
     * @return dthrFim
     */
    public java.util.Calendar getDthrFim() {
        return dthrFim;
    }


    /**
     * Sets the dthrFim value for this OmClidiario.
     * 
     * @param dthrFim
     */
    public void setDthrFim(java.util.Calendar dthrFim) {
        this.dthrFim = dthrFim;
    }


    /**
     * Gets the dthrInicio value for this OmClidiario.
     * 
     * @return dthrInicio
     */
    public java.util.Calendar getDthrInicio() {
        return dthrInicio;
    }


    /**
     * Sets the dthrInicio value for this OmClidiario.
     * 
     * @param dthrInicio
     */
    public void setDthrInicio(java.util.Calendar dthrInicio) {
        this.dthrInicio = dthrInicio;
    }


    /**
     * Gets the idClidiario value for this OmClidiario.
     * 
     * @return idClidiario
     */
    public double getIdClidiario() {
        return idClidiario;
    }


    /**
     * Sets the idClidiario value for this OmClidiario.
     * 
     * @param idClidiario
     */
    public void setIdClidiario(double idClidiario) {
        this.idClidiario = idClidiario;
    }


    /**
     * Gets the ppCliente value for this OmClidiario.
     * 
     * @return ppCliente
     */
    public idw.idwws.PpCliente getPpCliente() {
        return ppCliente;
    }


    /**
     * Sets the ppCliente value for this OmClidiario.
     * 
     * @param ppCliente
     */
    public void setPpCliente(idw.idwws.PpCliente ppCliente) {
        this.ppCliente = ppCliente;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmClidiario)) return false;
        OmClidiario other = (OmClidiario) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dsDiario==null && other.getDsDiario()==null) || 
             (this.dsDiario!=null &&
              this.dsDiario.equals(other.getDsDiario()))) &&
            ((this.dthrFim==null && other.getDthrFim()==null) || 
             (this.dthrFim!=null &&
              this.dthrFim.equals(other.getDthrFim()))) &&
            ((this.dthrInicio==null && other.getDthrInicio()==null) || 
             (this.dthrInicio!=null &&
              this.dthrInicio.equals(other.getDthrInicio()))) &&
            this.idClidiario == other.getIdClidiario() &&
            ((this.ppCliente==null && other.getPpCliente()==null) || 
             (this.ppCliente!=null &&
              this.ppCliente.equals(other.getPpCliente())));
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
        if (getDsDiario() != null) {
            _hashCode += getDsDiario().hashCode();
        }
        if (getDthrFim() != null) {
            _hashCode += getDthrFim().hashCode();
        }
        if (getDthrInicio() != null) {
            _hashCode += getDthrInicio().hashCode();
        }
        _hashCode += new Double(getIdClidiario()).hashCode();
        if (getPpCliente() != null) {
            _hashCode += getPpCliente().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmClidiario.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omClidiario"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsDiario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsDiario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFim"));
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
        elemField.setFieldName("idClidiario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idClidiario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCliente"));
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
