/**
 * ObjsRtDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ObjsRtDTO  implements java.io.Serializable {
    private idw.idwws.ObjRtDTO[] objsRt;

    private int resultadoEvento;

    public ObjsRtDTO() {
    }

    public ObjsRtDTO(
           idw.idwws.ObjRtDTO[] objsRt,
           int resultadoEvento) {
           this.objsRt = objsRt;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the objsRt value for this ObjsRtDTO.
     * 
     * @return objsRt
     */
    public idw.idwws.ObjRtDTO[] getObjsRt() {
        return objsRt;
    }


    /**
     * Sets the objsRt value for this ObjsRtDTO.
     * 
     * @param objsRt
     */
    public void setObjsRt(idw.idwws.ObjRtDTO[] objsRt) {
        this.objsRt = objsRt;
    }

    public idw.idwws.ObjRtDTO getObjsRt(int i) {
        return this.objsRt[i];
    }

    public void setObjsRt(int i, idw.idwws.ObjRtDTO _value) {
        this.objsRt[i] = _value;
    }


    /**
     * Gets the resultadoEvento value for this ObjsRtDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this ObjsRtDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObjsRtDTO)) return false;
        ObjsRtDTO other = (ObjsRtDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.objsRt==null && other.getObjsRt()==null) || 
             (this.objsRt!=null &&
              java.util.Arrays.equals(this.objsRt, other.getObjsRt()))) &&
            this.resultadoEvento == other.getResultadoEvento();
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
        if (getObjsRt() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getObjsRt());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getObjsRt(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getResultadoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObjsRtDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "objsRtDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objsRt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "objsRt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "objRtDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
