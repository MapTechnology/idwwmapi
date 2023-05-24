/**
 * IjacumparId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjacumparId  implements java.io.Serializable {
    private java.lang.String cdestrutura;

    private java.lang.String cdinjetora;

    private java.lang.String cdmolde;

    private java.util.Calendar dthrfacumpar;

    private java.util.Calendar dthriacumpar;

    private java.util.Calendar dthrivalestru;

    private java.lang.String nrop;

    private java.lang.Double tempoparada;

    public IjacumparId() {
    }

    public IjacumparId(
           java.lang.String cdestrutura,
           java.lang.String cdinjetora,
           java.lang.String cdmolde,
           java.util.Calendar dthrfacumpar,
           java.util.Calendar dthriacumpar,
           java.util.Calendar dthrivalestru,
           java.lang.String nrop,
           java.lang.Double tempoparada) {
           this.cdestrutura = cdestrutura;
           this.cdinjetora = cdinjetora;
           this.cdmolde = cdmolde;
           this.dthrfacumpar = dthrfacumpar;
           this.dthriacumpar = dthriacumpar;
           this.dthrivalestru = dthrivalestru;
           this.nrop = nrop;
           this.tempoparada = tempoparada;
    }


    /**
     * Gets the cdestrutura value for this IjacumparId.
     * 
     * @return cdestrutura
     */
    public java.lang.String getCdestrutura() {
        return cdestrutura;
    }


    /**
     * Sets the cdestrutura value for this IjacumparId.
     * 
     * @param cdestrutura
     */
    public void setCdestrutura(java.lang.String cdestrutura) {
        this.cdestrutura = cdestrutura;
    }


    /**
     * Gets the cdinjetora value for this IjacumparId.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this IjacumparId.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the cdmolde value for this IjacumparId.
     * 
     * @return cdmolde
     */
    public java.lang.String getCdmolde() {
        return cdmolde;
    }


    /**
     * Sets the cdmolde value for this IjacumparId.
     * 
     * @param cdmolde
     */
    public void setCdmolde(java.lang.String cdmolde) {
        this.cdmolde = cdmolde;
    }


    /**
     * Gets the dthrfacumpar value for this IjacumparId.
     * 
     * @return dthrfacumpar
     */
    public java.util.Calendar getDthrfacumpar() {
        return dthrfacumpar;
    }


    /**
     * Sets the dthrfacumpar value for this IjacumparId.
     * 
     * @param dthrfacumpar
     */
    public void setDthrfacumpar(java.util.Calendar dthrfacumpar) {
        this.dthrfacumpar = dthrfacumpar;
    }


    /**
     * Gets the dthriacumpar value for this IjacumparId.
     * 
     * @return dthriacumpar
     */
    public java.util.Calendar getDthriacumpar() {
        return dthriacumpar;
    }


    /**
     * Sets the dthriacumpar value for this IjacumparId.
     * 
     * @param dthriacumpar
     */
    public void setDthriacumpar(java.util.Calendar dthriacumpar) {
        this.dthriacumpar = dthriacumpar;
    }


    /**
     * Gets the dthrivalestru value for this IjacumparId.
     * 
     * @return dthrivalestru
     */
    public java.util.Calendar getDthrivalestru() {
        return dthrivalestru;
    }


    /**
     * Sets the dthrivalestru value for this IjacumparId.
     * 
     * @param dthrivalestru
     */
    public void setDthrivalestru(java.util.Calendar dthrivalestru) {
        this.dthrivalestru = dthrivalestru;
    }


    /**
     * Gets the nrop value for this IjacumparId.
     * 
     * @return nrop
     */
    public java.lang.String getNrop() {
        return nrop;
    }


    /**
     * Sets the nrop value for this IjacumparId.
     * 
     * @param nrop
     */
    public void setNrop(java.lang.String nrop) {
        this.nrop = nrop;
    }


    /**
     * Gets the tempoparada value for this IjacumparId.
     * 
     * @return tempoparada
     */
    public java.lang.Double getTempoparada() {
        return tempoparada;
    }


    /**
     * Sets the tempoparada value for this IjacumparId.
     * 
     * @param tempoparada
     */
    public void setTempoparada(java.lang.Double tempoparada) {
        this.tempoparada = tempoparada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjacumparId)) return false;
        IjacumparId other = (IjacumparId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdestrutura==null && other.getCdestrutura()==null) || 
             (this.cdestrutura!=null &&
              this.cdestrutura.equals(other.getCdestrutura()))) &&
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora()))) &&
            ((this.cdmolde==null && other.getCdmolde()==null) || 
             (this.cdmolde!=null &&
              this.cdmolde.equals(other.getCdmolde()))) &&
            ((this.dthrfacumpar==null && other.getDthrfacumpar()==null) || 
             (this.dthrfacumpar!=null &&
              this.dthrfacumpar.equals(other.getDthrfacumpar()))) &&
            ((this.dthriacumpar==null && other.getDthriacumpar()==null) || 
             (this.dthriacumpar!=null &&
              this.dthriacumpar.equals(other.getDthriacumpar()))) &&
            ((this.dthrivalestru==null && other.getDthrivalestru()==null) || 
             (this.dthrivalestru!=null &&
              this.dthrivalestru.equals(other.getDthrivalestru()))) &&
            ((this.nrop==null && other.getNrop()==null) || 
             (this.nrop!=null &&
              this.nrop.equals(other.getNrop()))) &&
            ((this.tempoparada==null && other.getTempoparada()==null) || 
             (this.tempoparada!=null &&
              this.tempoparada.equals(other.getTempoparada())));
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
        if (getCdestrutura() != null) {
            _hashCode += getCdestrutura().hashCode();
        }
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        if (getCdmolde() != null) {
            _hashCode += getCdmolde().hashCode();
        }
        if (getDthrfacumpar() != null) {
            _hashCode += getDthrfacumpar().hashCode();
        }
        if (getDthriacumpar() != null) {
            _hashCode += getDthriacumpar().hashCode();
        }
        if (getDthrivalestru() != null) {
            _hashCode += getDthrivalestru().hashCode();
        }
        if (getNrop() != null) {
            _hashCode += getNrop().hashCode();
        }
        if (getTempoparada() != null) {
            _hashCode += getTempoparada().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjacumparId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijacumparId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdestrutura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdestrutura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfacumpar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfacumpar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthriacumpar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthriacumpar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrivalestru");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrivalestru"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoparada"));
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
