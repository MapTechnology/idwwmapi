/**
 * IjbroneproseccompId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjbroneproseccompId  implements java.io.Serializable {
    private java.lang.String cdmprima;

    private java.lang.String cdprodutocomp;

    private java.util.Calendar dthrinicomp;

    public IjbroneproseccompId() {
    }

    public IjbroneproseccompId(
           java.lang.String cdmprima,
           java.lang.String cdprodutocomp,
           java.util.Calendar dthrinicomp) {
           this.cdmprima = cdmprima;
           this.cdprodutocomp = cdprodutocomp;
           this.dthrinicomp = dthrinicomp;
    }


    /**
     * Gets the cdmprima value for this IjbroneproseccompId.
     * 
     * @return cdmprima
     */
    public java.lang.String getCdmprima() {
        return cdmprima;
    }


    /**
     * Sets the cdmprima value for this IjbroneproseccompId.
     * 
     * @param cdmprima
     */
    public void setCdmprima(java.lang.String cdmprima) {
        this.cdmprima = cdmprima;
    }


    /**
     * Gets the cdprodutocomp value for this IjbroneproseccompId.
     * 
     * @return cdprodutocomp
     */
    public java.lang.String getCdprodutocomp() {
        return cdprodutocomp;
    }


    /**
     * Sets the cdprodutocomp value for this IjbroneproseccompId.
     * 
     * @param cdprodutocomp
     */
    public void setCdprodutocomp(java.lang.String cdprodutocomp) {
        this.cdprodutocomp = cdprodutocomp;
    }


    /**
     * Gets the dthrinicomp value for this IjbroneproseccompId.
     * 
     * @return dthrinicomp
     */
    public java.util.Calendar getDthrinicomp() {
        return dthrinicomp;
    }


    /**
     * Sets the dthrinicomp value for this IjbroneproseccompId.
     * 
     * @param dthrinicomp
     */
    public void setDthrinicomp(java.util.Calendar dthrinicomp) {
        this.dthrinicomp = dthrinicomp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjbroneproseccompId)) return false;
        IjbroneproseccompId other = (IjbroneproseccompId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdmprima==null && other.getCdmprima()==null) || 
             (this.cdmprima!=null &&
              this.cdmprima.equals(other.getCdmprima()))) &&
            ((this.cdprodutocomp==null && other.getCdprodutocomp()==null) || 
             (this.cdprodutocomp!=null &&
              this.cdprodutocomp.equals(other.getCdprodutocomp()))) &&
            ((this.dthrinicomp==null && other.getDthrinicomp()==null) || 
             (this.dthrinicomp!=null &&
              this.dthrinicomp.equals(other.getDthrinicomp())));
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
        if (getCdmprima() != null) {
            _hashCode += getCdmprima().hashCode();
        }
        if (getCdprodutocomp() != null) {
            _hashCode += getCdprodutocomp().hashCode();
        }
        if (getDthrinicomp() != null) {
            _hashCode += getDthrinicomp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjbroneproseccompId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijbroneproseccompId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmprima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmprima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdprodutocomp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdprodutocomp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrinicomp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrinicomp"));
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
