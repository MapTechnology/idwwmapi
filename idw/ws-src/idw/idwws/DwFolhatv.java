/**
 * DwFolhatv.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwFolhatv  implements java.io.Serializable {
    private idw.idwws.DwFolha dwFolha;

    private double idFolhatv;

    private idw.idwws.OmProduto omProduto;

    public DwFolhatv() {
    }

    public DwFolhatv(
           idw.idwws.DwFolha dwFolha,
           double idFolhatv,
           idw.idwws.OmProduto omProduto) {
           this.dwFolha = dwFolha;
           this.idFolhatv = idFolhatv;
           this.omProduto = omProduto;
    }


    /**
     * Gets the dwFolha value for this DwFolhatv.
     * 
     * @return dwFolha
     */
    public idw.idwws.DwFolha getDwFolha() {
        return dwFolha;
    }


    /**
     * Sets the dwFolha value for this DwFolhatv.
     * 
     * @param dwFolha
     */
    public void setDwFolha(idw.idwws.DwFolha dwFolha) {
        this.dwFolha = dwFolha;
    }


    /**
     * Gets the idFolhatv value for this DwFolhatv.
     * 
     * @return idFolhatv
     */
    public double getIdFolhatv() {
        return idFolhatv;
    }


    /**
     * Sets the idFolhatv value for this DwFolhatv.
     * 
     * @param idFolhatv
     */
    public void setIdFolhatv(double idFolhatv) {
        this.idFolhatv = idFolhatv;
    }


    /**
     * Gets the omProduto value for this DwFolhatv.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this DwFolhatv.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwFolhatv)) return false;
        DwFolhatv other = (DwFolhatv) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dwFolha==null && other.getDwFolha()==null) || 
             (this.dwFolha!=null &&
              this.dwFolha.equals(other.getDwFolha()))) &&
            this.idFolhatv == other.getIdFolhatv() &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto())));
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
        if (getDwFolha() != null) {
            _hashCode += getDwFolha().hashCode();
        }
        _hashCode += new Double(getIdFolhatv()).hashCode();
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwFolhatv.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhatv"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFolhatv");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFolhatv"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
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
