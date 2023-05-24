/**
 * IjespecinspromediaId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjespecinspromediaId  implements java.io.Serializable {
    private java.lang.String cdmolde;

    private java.lang.String cdproduto;

    private java.util.Calendar dthrivalespecific;

    private java.lang.String idespecific;

    private java.lang.String idespecificmedia;

    public IjespecinspromediaId() {
    }

    public IjespecinspromediaId(
           java.lang.String cdmolde,
           java.lang.String cdproduto,
           java.util.Calendar dthrivalespecific,
           java.lang.String idespecific,
           java.lang.String idespecificmedia) {
           this.cdmolde = cdmolde;
           this.cdproduto = cdproduto;
           this.dthrivalespecific = dthrivalespecific;
           this.idespecific = idespecific;
           this.idespecificmedia = idespecificmedia;
    }


    /**
     * Gets the cdmolde value for this IjespecinspromediaId.
     * 
     * @return cdmolde
     */
    public java.lang.String getCdmolde() {
        return cdmolde;
    }


    /**
     * Sets the cdmolde value for this IjespecinspromediaId.
     * 
     * @param cdmolde
     */
    public void setCdmolde(java.lang.String cdmolde) {
        this.cdmolde = cdmolde;
    }


    /**
     * Gets the cdproduto value for this IjespecinspromediaId.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this IjespecinspromediaId.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }


    /**
     * Gets the dthrivalespecific value for this IjespecinspromediaId.
     * 
     * @return dthrivalespecific
     */
    public java.util.Calendar getDthrivalespecific() {
        return dthrivalespecific;
    }


    /**
     * Sets the dthrivalespecific value for this IjespecinspromediaId.
     * 
     * @param dthrivalespecific
     */
    public void setDthrivalespecific(java.util.Calendar dthrivalespecific) {
        this.dthrivalespecific = dthrivalespecific;
    }


    /**
     * Gets the idespecific value for this IjespecinspromediaId.
     * 
     * @return idespecific
     */
    public java.lang.String getIdespecific() {
        return idespecific;
    }


    /**
     * Sets the idespecific value for this IjespecinspromediaId.
     * 
     * @param idespecific
     */
    public void setIdespecific(java.lang.String idespecific) {
        this.idespecific = idespecific;
    }


    /**
     * Gets the idespecificmedia value for this IjespecinspromediaId.
     * 
     * @return idespecificmedia
     */
    public java.lang.String getIdespecificmedia() {
        return idespecificmedia;
    }


    /**
     * Sets the idespecificmedia value for this IjespecinspromediaId.
     * 
     * @param idespecificmedia
     */
    public void setIdespecificmedia(java.lang.String idespecificmedia) {
        this.idespecificmedia = idespecificmedia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjespecinspromediaId)) return false;
        IjespecinspromediaId other = (IjespecinspromediaId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdmolde==null && other.getCdmolde()==null) || 
             (this.cdmolde!=null &&
              this.cdmolde.equals(other.getCdmolde()))) &&
            ((this.cdproduto==null && other.getCdproduto()==null) || 
             (this.cdproduto!=null &&
              this.cdproduto.equals(other.getCdproduto()))) &&
            ((this.dthrivalespecific==null && other.getDthrivalespecific()==null) || 
             (this.dthrivalespecific!=null &&
              this.dthrivalespecific.equals(other.getDthrivalespecific()))) &&
            ((this.idespecific==null && other.getIdespecific()==null) || 
             (this.idespecific!=null &&
              this.idespecific.equals(other.getIdespecific()))) &&
            ((this.idespecificmedia==null && other.getIdespecificmedia()==null) || 
             (this.idespecificmedia!=null &&
              this.idespecificmedia.equals(other.getIdespecificmedia())));
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
        if (getCdmolde() != null) {
            _hashCode += getCdmolde().hashCode();
        }
        if (getCdproduto() != null) {
            _hashCode += getCdproduto().hashCode();
        }
        if (getDthrivalespecific() != null) {
            _hashCode += getDthrivalespecific().hashCode();
        }
        if (getIdespecific() != null) {
            _hashCode += getIdespecific().hashCode();
        }
        if (getIdespecificmedia() != null) {
            _hashCode += getIdespecificmedia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjespecinspromediaId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijespecinspromediaId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmolde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmolde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrivalespecific");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrivalespecific"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idespecific");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idespecific"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idespecificmedia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idespecificmedia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
