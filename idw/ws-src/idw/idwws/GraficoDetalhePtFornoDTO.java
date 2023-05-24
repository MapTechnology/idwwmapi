/**
 * GraficoDetalhePtFornoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class GraficoDetalhePtFornoDTO  implements java.io.Serializable {
    private idw.idwws.DwConsolid[] listaDwConsolId;

    private idw.idwws.DwConsolmedparamlog[] listaDwConsolMedParamLog;

    public GraficoDetalhePtFornoDTO() {
    }

    public GraficoDetalhePtFornoDTO(
           idw.idwws.DwConsolid[] listaDwConsolId,
           idw.idwws.DwConsolmedparamlog[] listaDwConsolMedParamLog) {
           this.listaDwConsolId = listaDwConsolId;
           this.listaDwConsolMedParamLog = listaDwConsolMedParamLog;
    }


    /**
     * Gets the listaDwConsolId value for this GraficoDetalhePtFornoDTO.
     * 
     * @return listaDwConsolId
     */
    public idw.idwws.DwConsolid[] getListaDwConsolId() {
        return listaDwConsolId;
    }


    /**
     * Sets the listaDwConsolId value for this GraficoDetalhePtFornoDTO.
     * 
     * @param listaDwConsolId
     */
    public void setListaDwConsolId(idw.idwws.DwConsolid[] listaDwConsolId) {
        this.listaDwConsolId = listaDwConsolId;
    }

    public idw.idwws.DwConsolid getListaDwConsolId(int i) {
        return this.listaDwConsolId[i];
    }

    public void setListaDwConsolId(int i, idw.idwws.DwConsolid _value) {
        this.listaDwConsolId[i] = _value;
    }


    /**
     * Gets the listaDwConsolMedParamLog value for this GraficoDetalhePtFornoDTO.
     * 
     * @return listaDwConsolMedParamLog
     */
    public idw.idwws.DwConsolmedparamlog[] getListaDwConsolMedParamLog() {
        return listaDwConsolMedParamLog;
    }


    /**
     * Sets the listaDwConsolMedParamLog value for this GraficoDetalhePtFornoDTO.
     * 
     * @param listaDwConsolMedParamLog
     */
    public void setListaDwConsolMedParamLog(idw.idwws.DwConsolmedparamlog[] listaDwConsolMedParamLog) {
        this.listaDwConsolMedParamLog = listaDwConsolMedParamLog;
    }

    public idw.idwws.DwConsolmedparamlog getListaDwConsolMedParamLog(int i) {
        return this.listaDwConsolMedParamLog[i];
    }

    public void setListaDwConsolMedParamLog(int i, idw.idwws.DwConsolmedparamlog _value) {
        this.listaDwConsolMedParamLog[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GraficoDetalhePtFornoDTO)) return false;
        GraficoDetalhePtFornoDTO other = (GraficoDetalhePtFornoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listaDwConsolId==null && other.getListaDwConsolId()==null) || 
             (this.listaDwConsolId!=null &&
              java.util.Arrays.equals(this.listaDwConsolId, other.getListaDwConsolId()))) &&
            ((this.listaDwConsolMedParamLog==null && other.getListaDwConsolMedParamLog()==null) || 
             (this.listaDwConsolMedParamLog!=null &&
              java.util.Arrays.equals(this.listaDwConsolMedParamLog, other.getListaDwConsolMedParamLog())));
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
        if (getListaDwConsolId() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaDwConsolId());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaDwConsolId(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaDwConsolMedParamLog() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaDwConsolMedParamLog());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaDwConsolMedParamLog(), i);
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
        new org.apache.axis.description.TypeDesc(GraficoDetalhePtFornoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "graficoDetalhePtFornoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaDwConsolId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaDwConsolId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaDwConsolMedParamLog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaDwConsolMedParamLog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmedparamlog"));
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
