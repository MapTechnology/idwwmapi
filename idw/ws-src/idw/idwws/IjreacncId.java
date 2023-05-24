/**
 * IjreacncId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjreacncId  implements java.io.Serializable {
    private java.lang.String cdestrutura;

    private java.lang.String cdinjetora;

    private java.lang.String cditemcnc;

    private java.lang.String cdmolde;

    private java.util.Calendar dthrleituravl;

    public IjreacncId() {
    }

    public IjreacncId(
           java.lang.String cdestrutura,
           java.lang.String cdinjetora,
           java.lang.String cditemcnc,
           java.lang.String cdmolde,
           java.util.Calendar dthrleituravl) {
           this.cdestrutura = cdestrutura;
           this.cdinjetora = cdinjetora;
           this.cditemcnc = cditemcnc;
           this.cdmolde = cdmolde;
           this.dthrleituravl = dthrleituravl;
    }


    /**
     * Gets the cdestrutura value for this IjreacncId.
     * 
     * @return cdestrutura
     */
    public java.lang.String getCdestrutura() {
        return cdestrutura;
    }


    /**
     * Sets the cdestrutura value for this IjreacncId.
     * 
     * @param cdestrutura
     */
    public void setCdestrutura(java.lang.String cdestrutura) {
        this.cdestrutura = cdestrutura;
    }


    /**
     * Gets the cdinjetora value for this IjreacncId.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this IjreacncId.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the cditemcnc value for this IjreacncId.
     * 
     * @return cditemcnc
     */
    public java.lang.String getCditemcnc() {
        return cditemcnc;
    }


    /**
     * Sets the cditemcnc value for this IjreacncId.
     * 
     * @param cditemcnc
     */
    public void setCditemcnc(java.lang.String cditemcnc) {
        this.cditemcnc = cditemcnc;
    }


    /**
     * Gets the cdmolde value for this IjreacncId.
     * 
     * @return cdmolde
     */
    public java.lang.String getCdmolde() {
        return cdmolde;
    }


    /**
     * Sets the cdmolde value for this IjreacncId.
     * 
     * @param cdmolde
     */
    public void setCdmolde(java.lang.String cdmolde) {
        this.cdmolde = cdmolde;
    }


    /**
     * Gets the dthrleituravl value for this IjreacncId.
     * 
     * @return dthrleituravl
     */
    public java.util.Calendar getDthrleituravl() {
        return dthrleituravl;
    }


    /**
     * Sets the dthrleituravl value for this IjreacncId.
     * 
     * @param dthrleituravl
     */
    public void setDthrleituravl(java.util.Calendar dthrleituravl) {
        this.dthrleituravl = dthrleituravl;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjreacncId)) return false;
        IjreacncId other = (IjreacncId) obj;
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
            ((this.cditemcnc==null && other.getCditemcnc()==null) || 
             (this.cditemcnc!=null &&
              this.cditemcnc.equals(other.getCditemcnc()))) &&
            ((this.cdmolde==null && other.getCdmolde()==null) || 
             (this.cdmolde!=null &&
              this.cdmolde.equals(other.getCdmolde()))) &&
            ((this.dthrleituravl==null && other.getDthrleituravl()==null) || 
             (this.dthrleituravl!=null &&
              this.dthrleituravl.equals(other.getDthrleituravl())));
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
        if (getCditemcnc() != null) {
            _hashCode += getCditemcnc().hashCode();
        }
        if (getCdmolde() != null) {
            _hashCode += getCdmolde().hashCode();
        }
        if (getDthrleituravl() != null) {
            _hashCode += getDthrleituravl().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjreacncId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreacncId"));
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
        elemField.setFieldName("cditemcnc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cditemcnc"));
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
        elemField.setFieldName("dthrleituravl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrleituravl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
