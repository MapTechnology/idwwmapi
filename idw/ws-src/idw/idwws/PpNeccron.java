/**
 * PpNeccron.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpNeccron  extends idw.idwws.PpNeccronTemplate  implements java.io.Serializable {
    private java.util.Calendar dtDesejada;

    private java.util.Calendar dtEstimada;

    private java.lang.Long idNeccron;

    private idw.idwws.PpNec ppNec;

    private idw.idwws.PpPlaneccron[] ppPlaneccrons;

    private java.lang.Double qtDesejada;

    public PpNeccron() {
    }

    public PpNeccron(
           java.util.Calendar dtDesejada,
           java.util.Calendar dtEstimada,
           java.lang.Long idNeccron,
           idw.idwws.PpNec ppNec,
           idw.idwws.PpPlaneccron[] ppPlaneccrons,
           java.lang.Double qtDesejada) {
        this.dtDesejada = dtDesejada;
        this.dtEstimada = dtEstimada;
        this.idNeccron = idNeccron;
        this.ppNec = ppNec;
        this.ppPlaneccrons = ppPlaneccrons;
        this.qtDesejada = qtDesejada;
    }


    /**
     * Gets the dtDesejada value for this PpNeccron.
     * 
     * @return dtDesejada
     */
    public java.util.Calendar getDtDesejada() {
        return dtDesejada;
    }


    /**
     * Sets the dtDesejada value for this PpNeccron.
     * 
     * @param dtDesejada
     */
    public void setDtDesejada(java.util.Calendar dtDesejada) {
        this.dtDesejada = dtDesejada;
    }


    /**
     * Gets the dtEstimada value for this PpNeccron.
     * 
     * @return dtEstimada
     */
    public java.util.Calendar getDtEstimada() {
        return dtEstimada;
    }


    /**
     * Sets the dtEstimada value for this PpNeccron.
     * 
     * @param dtEstimada
     */
    public void setDtEstimada(java.util.Calendar dtEstimada) {
        this.dtEstimada = dtEstimada;
    }


    /**
     * Gets the idNeccron value for this PpNeccron.
     * 
     * @return idNeccron
     */
    public java.lang.Long getIdNeccron() {
        return idNeccron;
    }


    /**
     * Sets the idNeccron value for this PpNeccron.
     * 
     * @param idNeccron
     */
    public void setIdNeccron(java.lang.Long idNeccron) {
        this.idNeccron = idNeccron;
    }


    /**
     * Gets the ppNec value for this PpNeccron.
     * 
     * @return ppNec
     */
    public idw.idwws.PpNec getPpNec() {
        return ppNec;
    }


    /**
     * Sets the ppNec value for this PpNeccron.
     * 
     * @param ppNec
     */
    public void setPpNec(idw.idwws.PpNec ppNec) {
        this.ppNec = ppNec;
    }


    /**
     * Gets the ppPlaneccrons value for this PpNeccron.
     * 
     * @return ppPlaneccrons
     */
    public idw.idwws.PpPlaneccron[] getPpPlaneccrons() {
        return ppPlaneccrons;
    }


    /**
     * Sets the ppPlaneccrons value for this PpNeccron.
     * 
     * @param ppPlaneccrons
     */
    public void setPpPlaneccrons(idw.idwws.PpPlaneccron[] ppPlaneccrons) {
        this.ppPlaneccrons = ppPlaneccrons;
    }

    public idw.idwws.PpPlaneccron getPpPlaneccrons(int i) {
        return this.ppPlaneccrons[i];
    }

    public void setPpPlaneccrons(int i, idw.idwws.PpPlaneccron _value) {
        this.ppPlaneccrons[i] = _value;
    }


    /**
     * Gets the qtDesejada value for this PpNeccron.
     * 
     * @return qtDesejada
     */
    public java.lang.Double getQtDesejada() {
        return qtDesejada;
    }


    /**
     * Sets the qtDesejada value for this PpNeccron.
     * 
     * @param qtDesejada
     */
    public void setQtDesejada(java.lang.Double qtDesejada) {
        this.qtDesejada = qtDesejada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpNeccron)) return false;
        PpNeccron other = (PpNeccron) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dtDesejada==null && other.getDtDesejada()==null) || 
             (this.dtDesejada!=null &&
              this.dtDesejada.equals(other.getDtDesejada()))) &&
            ((this.dtEstimada==null && other.getDtEstimada()==null) || 
             (this.dtEstimada!=null &&
              this.dtEstimada.equals(other.getDtEstimada()))) &&
            ((this.idNeccron==null && other.getIdNeccron()==null) || 
             (this.idNeccron!=null &&
              this.idNeccron.equals(other.getIdNeccron()))) &&
            ((this.ppNec==null && other.getPpNec()==null) || 
             (this.ppNec!=null &&
              this.ppNec.equals(other.getPpNec()))) &&
            ((this.ppPlaneccrons==null && other.getPpPlaneccrons()==null) || 
             (this.ppPlaneccrons!=null &&
              java.util.Arrays.equals(this.ppPlaneccrons, other.getPpPlaneccrons()))) &&
            ((this.qtDesejada==null && other.getQtDesejada()==null) || 
             (this.qtDesejada!=null &&
              this.qtDesejada.equals(other.getQtDesejada())));
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
        if (getDtDesejada() != null) {
            _hashCode += getDtDesejada().hashCode();
        }
        if (getDtEstimada() != null) {
            _hashCode += getDtEstimada().hashCode();
        }
        if (getIdNeccron() != null) {
            _hashCode += getIdNeccron().hashCode();
        }
        if (getPpNec() != null) {
            _hashCode += getPpNec().hashCode();
        }
        if (getPpPlaneccrons() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpPlaneccrons());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpPlaneccrons(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getQtDesejada() != null) {
            _hashCode += getQtDesejada().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpNeccron.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNeccron"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtDesejada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtDesejada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtEstimada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtEstimada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idNeccron");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idNeccron"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppNec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppNec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppNec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppPlaneccrons");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppPlaneccrons"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppPlaneccron"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtDesejada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtDesejada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
