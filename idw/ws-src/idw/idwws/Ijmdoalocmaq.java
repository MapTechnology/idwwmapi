/**
 * Ijmdoalocmaq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijmdoalocmaq  implements java.io.Serializable {
    private java.lang.String cdproduto;

    private idw.idwws.Ijtbpro ijtbpro;

    private org.apache.axis.types.UnsignedShort sttodasmaquinas;

    public Ijmdoalocmaq() {
    }

    public Ijmdoalocmaq(
           java.lang.String cdproduto,
           idw.idwws.Ijtbpro ijtbpro,
           org.apache.axis.types.UnsignedShort sttodasmaquinas) {
           this.cdproduto = cdproduto;
           this.ijtbpro = ijtbpro;
           this.sttodasmaquinas = sttodasmaquinas;
    }


    /**
     * Gets the cdproduto value for this Ijmdoalocmaq.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this Ijmdoalocmaq.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }


    /**
     * Gets the ijtbpro value for this Ijmdoalocmaq.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijmdoalocmaq.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the sttodasmaquinas value for this Ijmdoalocmaq.
     * 
     * @return sttodasmaquinas
     */
    public org.apache.axis.types.UnsignedShort getSttodasmaquinas() {
        return sttodasmaquinas;
    }


    /**
     * Sets the sttodasmaquinas value for this Ijmdoalocmaq.
     * 
     * @param sttodasmaquinas
     */
    public void setSttodasmaquinas(org.apache.axis.types.UnsignedShort sttodasmaquinas) {
        this.sttodasmaquinas = sttodasmaquinas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijmdoalocmaq)) return false;
        Ijmdoalocmaq other = (Ijmdoalocmaq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdproduto==null && other.getCdproduto()==null) || 
             (this.cdproduto!=null &&
              this.cdproduto.equals(other.getCdproduto()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            ((this.sttodasmaquinas==null && other.getSttodasmaquinas()==null) || 
             (this.sttodasmaquinas!=null &&
              this.sttodasmaquinas.equals(other.getSttodasmaquinas())));
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
        if (getCdproduto() != null) {
            _hashCode += getCdproduto().hashCode();
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        if (getSttodasmaquinas() != null) {
            _hashCode += getSttodasmaquinas().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijmdoalocmaq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmdoalocmaq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sttodasmaquinas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sttodasmaquinas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
