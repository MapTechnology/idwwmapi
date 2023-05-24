/**
 * PpCpPre.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpCpPre  implements java.io.Serializable {
    private java.lang.Long idCppre;

    private idw.idwws.PpCp ppCpByIdCp;

    private idw.idwws.PpCp ppCpByIdCppredecessora;

    public PpCpPre() {
    }

    public PpCpPre(
           java.lang.Long idCppre,
           idw.idwws.PpCp ppCpByIdCp,
           idw.idwws.PpCp ppCpByIdCppredecessora) {
           this.idCppre = idCppre;
           this.ppCpByIdCp = ppCpByIdCp;
           this.ppCpByIdCppredecessora = ppCpByIdCppredecessora;
    }


    /**
     * Gets the idCppre value for this PpCpPre.
     * 
     * @return idCppre
     */
    public java.lang.Long getIdCppre() {
        return idCppre;
    }


    /**
     * Sets the idCppre value for this PpCpPre.
     * 
     * @param idCppre
     */
    public void setIdCppre(java.lang.Long idCppre) {
        this.idCppre = idCppre;
    }


    /**
     * Gets the ppCpByIdCp value for this PpCpPre.
     * 
     * @return ppCpByIdCp
     */
    public idw.idwws.PpCp getPpCpByIdCp() {
        return ppCpByIdCp;
    }


    /**
     * Sets the ppCpByIdCp value for this PpCpPre.
     * 
     * @param ppCpByIdCp
     */
    public void setPpCpByIdCp(idw.idwws.PpCp ppCpByIdCp) {
        this.ppCpByIdCp = ppCpByIdCp;
    }


    /**
     * Gets the ppCpByIdCppredecessora value for this PpCpPre.
     * 
     * @return ppCpByIdCppredecessora
     */
    public idw.idwws.PpCp getPpCpByIdCppredecessora() {
        return ppCpByIdCppredecessora;
    }


    /**
     * Sets the ppCpByIdCppredecessora value for this PpCpPre.
     * 
     * @param ppCpByIdCppredecessora
     */
    public void setPpCpByIdCppredecessora(idw.idwws.PpCp ppCpByIdCppredecessora) {
        this.ppCpByIdCppredecessora = ppCpByIdCppredecessora;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpCpPre)) return false;
        PpCpPre other = (PpCpPre) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idCppre==null && other.getIdCppre()==null) || 
             (this.idCppre!=null &&
              this.idCppre.equals(other.getIdCppre()))) &&
            ((this.ppCpByIdCp==null && other.getPpCpByIdCp()==null) || 
             (this.ppCpByIdCp!=null &&
              this.ppCpByIdCp.equals(other.getPpCpByIdCp()))) &&
            ((this.ppCpByIdCppredecessora==null && other.getPpCpByIdCppredecessora()==null) || 
             (this.ppCpByIdCppredecessora!=null &&
              this.ppCpByIdCppredecessora.equals(other.getPpCpByIdCppredecessora())));
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
        if (getIdCppre() != null) {
            _hashCode += getIdCppre().hashCode();
        }
        if (getPpCpByIdCp() != null) {
            _hashCode += getPpCpByIdCp().hashCode();
        }
        if (getPpCpByIdCppredecessora() != null) {
            _hashCode += getPpCpByIdCppredecessora().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpCpPre.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpPre"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCppre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCppre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCpByIdCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCpByIdCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCpByIdCppredecessora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCpByIdCppredecessora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
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
