/**
 * FolhaEtapaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class FolhaEtapaDTO  implements java.io.Serializable {
    private idw.idwws.DwFtEtapa etapa;

    private int ordem;

    private idw.idwws.DwTestesub[] testesSub;

    public FolhaEtapaDTO() {
    }

    public FolhaEtapaDTO(
           idw.idwws.DwFtEtapa etapa,
           int ordem,
           idw.idwws.DwTestesub[] testesSub) {
           this.etapa = etapa;
           this.ordem = ordem;
           this.testesSub = testesSub;
    }


    /**
     * Gets the etapa value for this FolhaEtapaDTO.
     * 
     * @return etapa
     */
    public idw.idwws.DwFtEtapa getEtapa() {
        return etapa;
    }


    /**
     * Sets the etapa value for this FolhaEtapaDTO.
     * 
     * @param etapa
     */
    public void setEtapa(idw.idwws.DwFtEtapa etapa) {
        this.etapa = etapa;
    }


    /**
     * Gets the ordem value for this FolhaEtapaDTO.
     * 
     * @return ordem
     */
    public int getOrdem() {
        return ordem;
    }


    /**
     * Sets the ordem value for this FolhaEtapaDTO.
     * 
     * @param ordem
     */
    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }


    /**
     * Gets the testesSub value for this FolhaEtapaDTO.
     * 
     * @return testesSub
     */
    public idw.idwws.DwTestesub[] getTestesSub() {
        return testesSub;
    }


    /**
     * Sets the testesSub value for this FolhaEtapaDTO.
     * 
     * @param testesSub
     */
    public void setTestesSub(idw.idwws.DwTestesub[] testesSub) {
        this.testesSub = testesSub;
    }

    public idw.idwws.DwTestesub getTestesSub(int i) {
        return this.testesSub[i];
    }

    public void setTestesSub(int i, idw.idwws.DwTestesub _value) {
        this.testesSub[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FolhaEtapaDTO)) return false;
        FolhaEtapaDTO other = (FolhaEtapaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.etapa==null && other.getEtapa()==null) || 
             (this.etapa!=null &&
              this.etapa.equals(other.getEtapa()))) &&
            this.ordem == other.getOrdem() &&
            ((this.testesSub==null && other.getTestesSub()==null) || 
             (this.testesSub!=null &&
              java.util.Arrays.equals(this.testesSub, other.getTestesSub())));
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
        if (getEtapa() != null) {
            _hashCode += getEtapa().hashCode();
        }
        _hashCode += getOrdem();
        if (getTestesSub() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTestesSub());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTestesSub(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FolhaEtapaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "folhaEtapaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "etapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtEtapa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("testesSub");
        elemField.setXmlName(new javax.xml.namespace.QName("", "testesSub"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTestesub"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
