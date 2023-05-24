/**
 * PpCpneccron.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpCpneccron  extends idw.idwws.PpCpneccronTemplate  implements java.io.Serializable {
    private java.lang.Long idCpneccron;

    private idw.idwws.PpCp ppCp;

    private idw.idwws.PpPlaneccron ppPlaneccron;

    private java.lang.Double qtAtendida;

    public PpCpneccron() {
    }

    public PpCpneccron(
           java.lang.Long idCpneccron,
           idw.idwws.PpCp ppCp,
           idw.idwws.PpPlaneccron ppPlaneccron,
           java.lang.Double qtAtendida) {
        this.idCpneccron = idCpneccron;
        this.ppCp = ppCp;
        this.ppPlaneccron = ppPlaneccron;
        this.qtAtendida = qtAtendida;
    }


    /**
     * Gets the idCpneccron value for this PpCpneccron.
     * 
     * @return idCpneccron
     */
    public java.lang.Long getIdCpneccron() {
        return idCpneccron;
    }


    /**
     * Sets the idCpneccron value for this PpCpneccron.
     * 
     * @param idCpneccron
     */
    public void setIdCpneccron(java.lang.Long idCpneccron) {
        this.idCpneccron = idCpneccron;
    }


    /**
     * Gets the ppCp value for this PpCpneccron.
     * 
     * @return ppCp
     */
    public idw.idwws.PpCp getPpCp() {
        return ppCp;
    }


    /**
     * Sets the ppCp value for this PpCpneccron.
     * 
     * @param ppCp
     */
    public void setPpCp(idw.idwws.PpCp ppCp) {
        this.ppCp = ppCp;
    }


    /**
     * Gets the ppPlaneccron value for this PpCpneccron.
     * 
     * @return ppPlaneccron
     */
    public idw.idwws.PpPlaneccron getPpPlaneccron() {
        return ppPlaneccron;
    }


    /**
     * Sets the ppPlaneccron value for this PpCpneccron.
     * 
     * @param ppPlaneccron
     */
    public void setPpPlaneccron(idw.idwws.PpPlaneccron ppPlaneccron) {
        this.ppPlaneccron = ppPlaneccron;
    }


    /**
     * Gets the qtAtendida value for this PpCpneccron.
     * 
     * @return qtAtendida
     */
    public java.lang.Double getQtAtendida() {
        return qtAtendida;
    }


    /**
     * Sets the qtAtendida value for this PpCpneccron.
     * 
     * @param qtAtendida
     */
    public void setQtAtendida(java.lang.Double qtAtendida) {
        this.qtAtendida = qtAtendida;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpCpneccron)) return false;
        PpCpneccron other = (PpCpneccron) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.idCpneccron==null && other.getIdCpneccron()==null) || 
             (this.idCpneccron!=null &&
              this.idCpneccron.equals(other.getIdCpneccron()))) &&
            ((this.ppCp==null && other.getPpCp()==null) || 
             (this.ppCp!=null &&
              this.ppCp.equals(other.getPpCp()))) &&
            ((this.ppPlaneccron==null && other.getPpPlaneccron()==null) || 
             (this.ppPlaneccron!=null &&
              this.ppPlaneccron.equals(other.getPpPlaneccron()))) &&
            ((this.qtAtendida==null && other.getQtAtendida()==null) || 
             (this.qtAtendida!=null &&
              this.qtAtendida.equals(other.getQtAtendida())));
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
        if (getIdCpneccron() != null) {
            _hashCode += getIdCpneccron().hashCode();
        }
        if (getPpCp() != null) {
            _hashCode += getPpCp().hashCode();
        }
        if (getPpPlaneccron() != null) {
            _hashCode += getPpPlaneccron().hashCode();
        }
        if (getQtAtendida() != null) {
            _hashCode += getQtAtendida().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpCpneccron.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpneccron"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCpneccron");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCpneccron"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppPlaneccron");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppPlaneccron"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppPlaneccron"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAtendida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAtendida"));
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
