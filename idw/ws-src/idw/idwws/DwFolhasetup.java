/**
 * DwFolhasetup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwFolhasetup  extends idw.idwws.DwFolhasetupTemplate  implements java.io.Serializable {
    private idw.idwws.DwFolha dwFolhaByIdFolhaentrando;

    private idw.idwws.DwFolha dwFolhaByIdFolhasaindo;

    private java.lang.Long idFolhasetup;

    private java.math.BigDecimal segSetup;

    public DwFolhasetup() {
    }

    public DwFolhasetup(
           idw.idwws.DwFolha dwFolhaByIdFolhaentrando,
           idw.idwws.DwFolha dwFolhaByIdFolhasaindo,
           java.lang.Long idFolhasetup,
           java.math.BigDecimal segSetup) {
        this.dwFolhaByIdFolhaentrando = dwFolhaByIdFolhaentrando;
        this.dwFolhaByIdFolhasaindo = dwFolhaByIdFolhasaindo;
        this.idFolhasetup = idFolhasetup;
        this.segSetup = segSetup;
    }


    /**
     * Gets the dwFolhaByIdFolhaentrando value for this DwFolhasetup.
     * 
     * @return dwFolhaByIdFolhaentrando
     */
    public idw.idwws.DwFolha getDwFolhaByIdFolhaentrando() {
        return dwFolhaByIdFolhaentrando;
    }


    /**
     * Sets the dwFolhaByIdFolhaentrando value for this DwFolhasetup.
     * 
     * @param dwFolhaByIdFolhaentrando
     */
    public void setDwFolhaByIdFolhaentrando(idw.idwws.DwFolha dwFolhaByIdFolhaentrando) {
        this.dwFolhaByIdFolhaentrando = dwFolhaByIdFolhaentrando;
    }


    /**
     * Gets the dwFolhaByIdFolhasaindo value for this DwFolhasetup.
     * 
     * @return dwFolhaByIdFolhasaindo
     */
    public idw.idwws.DwFolha getDwFolhaByIdFolhasaindo() {
        return dwFolhaByIdFolhasaindo;
    }


    /**
     * Sets the dwFolhaByIdFolhasaindo value for this DwFolhasetup.
     * 
     * @param dwFolhaByIdFolhasaindo
     */
    public void setDwFolhaByIdFolhasaindo(idw.idwws.DwFolha dwFolhaByIdFolhasaindo) {
        this.dwFolhaByIdFolhasaindo = dwFolhaByIdFolhasaindo;
    }


    /**
     * Gets the idFolhasetup value for this DwFolhasetup.
     * 
     * @return idFolhasetup
     */
    public java.lang.Long getIdFolhasetup() {
        return idFolhasetup;
    }


    /**
     * Sets the idFolhasetup value for this DwFolhasetup.
     * 
     * @param idFolhasetup
     */
    public void setIdFolhasetup(java.lang.Long idFolhasetup) {
        this.idFolhasetup = idFolhasetup;
    }


    /**
     * Gets the segSetup value for this DwFolhasetup.
     * 
     * @return segSetup
     */
    public java.math.BigDecimal getSegSetup() {
        return segSetup;
    }


    /**
     * Sets the segSetup value for this DwFolhasetup.
     * 
     * @param segSetup
     */
    public void setSegSetup(java.math.BigDecimal segSetup) {
        this.segSetup = segSetup;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwFolhasetup)) return false;
        DwFolhasetup other = (DwFolhasetup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwFolhaByIdFolhaentrando==null && other.getDwFolhaByIdFolhaentrando()==null) || 
             (this.dwFolhaByIdFolhaentrando!=null &&
              this.dwFolhaByIdFolhaentrando.equals(other.getDwFolhaByIdFolhaentrando()))) &&
            ((this.dwFolhaByIdFolhasaindo==null && other.getDwFolhaByIdFolhasaindo()==null) || 
             (this.dwFolhaByIdFolhasaindo!=null &&
              this.dwFolhaByIdFolhasaindo.equals(other.getDwFolhaByIdFolhasaindo()))) &&
            ((this.idFolhasetup==null && other.getIdFolhasetup()==null) || 
             (this.idFolhasetup!=null &&
              this.idFolhasetup.equals(other.getIdFolhasetup()))) &&
            ((this.segSetup==null && other.getSegSetup()==null) || 
             (this.segSetup!=null &&
              this.segSetup.equals(other.getSegSetup())));
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
        if (getDwFolhaByIdFolhaentrando() != null) {
            _hashCode += getDwFolhaByIdFolhaentrando().hashCode();
        }
        if (getDwFolhaByIdFolhasaindo() != null) {
            _hashCode += getDwFolhaByIdFolhasaindo().hashCode();
        }
        if (getIdFolhasetup() != null) {
            _hashCode += getIdFolhasetup().hashCode();
        }
        if (getSegSetup() != null) {
            _hashCode += getSegSetup().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwFolhasetup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhasetup"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhaByIdFolhaentrando");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhaByIdFolhaentrando"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhaByIdFolhasaindo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhaByIdFolhasaindo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFolhasetup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFolhasetup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segSetup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segSetup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
