/**
 * Ijctrlultturmaq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijctrlultturmaq  implements java.io.Serializable {
    private java.lang.String cdinjetora;

    private java.lang.String cdturno;

    private java.util.Calendar dthrfturno;

    private java.util.Calendar dthriturno;

    private java.util.Calendar dtturno;

    private idw.idwws.Ijtbinj ijtbinj;

    public Ijctrlultturmaq() {
    }

    public Ijctrlultturmaq(
           java.lang.String cdinjetora,
           java.lang.String cdturno,
           java.util.Calendar dthrfturno,
           java.util.Calendar dthriturno,
           java.util.Calendar dtturno,
           idw.idwws.Ijtbinj ijtbinj) {
           this.cdinjetora = cdinjetora;
           this.cdturno = cdturno;
           this.dthrfturno = dthrfturno;
           this.dthriturno = dthriturno;
           this.dtturno = dtturno;
           this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the cdinjetora value for this Ijctrlultturmaq.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this Ijctrlultturmaq.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the cdturno value for this Ijctrlultturmaq.
     * 
     * @return cdturno
     */
    public java.lang.String getCdturno() {
        return cdturno;
    }


    /**
     * Sets the cdturno value for this Ijctrlultturmaq.
     * 
     * @param cdturno
     */
    public void setCdturno(java.lang.String cdturno) {
        this.cdturno = cdturno;
    }


    /**
     * Gets the dthrfturno value for this Ijctrlultturmaq.
     * 
     * @return dthrfturno
     */
    public java.util.Calendar getDthrfturno() {
        return dthrfturno;
    }


    /**
     * Sets the dthrfturno value for this Ijctrlultturmaq.
     * 
     * @param dthrfturno
     */
    public void setDthrfturno(java.util.Calendar dthrfturno) {
        this.dthrfturno = dthrfturno;
    }


    /**
     * Gets the dthriturno value for this Ijctrlultturmaq.
     * 
     * @return dthriturno
     */
    public java.util.Calendar getDthriturno() {
        return dthriturno;
    }


    /**
     * Sets the dthriturno value for this Ijctrlultturmaq.
     * 
     * @param dthriturno
     */
    public void setDthriturno(java.util.Calendar dthriturno) {
        this.dthriturno = dthriturno;
    }


    /**
     * Gets the dtturno value for this Ijctrlultturmaq.
     * 
     * @return dtturno
     */
    public java.util.Calendar getDtturno() {
        return dtturno;
    }


    /**
     * Sets the dtturno value for this Ijctrlultturmaq.
     * 
     * @param dtturno
     */
    public void setDtturno(java.util.Calendar dtturno) {
        this.dtturno = dtturno;
    }


    /**
     * Gets the ijtbinj value for this Ijctrlultturmaq.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijctrlultturmaq.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijctrlultturmaq)) return false;
        Ijctrlultturmaq other = (Ijctrlultturmaq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora()))) &&
            ((this.cdturno==null && other.getCdturno()==null) || 
             (this.cdturno!=null &&
              this.cdturno.equals(other.getCdturno()))) &&
            ((this.dthrfturno==null && other.getDthrfturno()==null) || 
             (this.dthrfturno!=null &&
              this.dthrfturno.equals(other.getDthrfturno()))) &&
            ((this.dthriturno==null && other.getDthriturno()==null) || 
             (this.dthriturno!=null &&
              this.dthriturno.equals(other.getDthriturno()))) &&
            ((this.dtturno==null && other.getDtturno()==null) || 
             (this.dtturno!=null &&
              this.dtturno.equals(other.getDtturno()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj())));
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
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        if (getCdturno() != null) {
            _hashCode += getCdturno().hashCode();
        }
        if (getDthrfturno() != null) {
            _hashCode += getDthrfturno().hashCode();
        }
        if (getDthriturno() != null) {
            _hashCode += getDthriturno().hashCode();
        }
        if (getDtturno() != null) {
            _hashCode += getDtturno().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijctrlultturmaq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlultturmaq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthriturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthriturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
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
