/**
 * ObjsDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ObjsDTO  implements java.io.Serializable {
    private idw.idwws.ObjDTO[] objs;

    private int resultadoEvento;

    public ObjsDTO() {
    }

    public ObjsDTO(
           idw.idwws.ObjDTO[] objs,
           int resultadoEvento) {
           this.objs = objs;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the objs value for this ObjsDTO.
     * 
     * @return objs
     */
    public idw.idwws.ObjDTO[] getObjs() {
        return objs;
    }


    /**
     * Sets the objs value for this ObjsDTO.
     * 
     * @param objs
     */
    public void setObjs(idw.idwws.ObjDTO[] objs) {
        this.objs = objs;
    }

    public idw.idwws.ObjDTO getObjs(int i) {
        return this.objs[i];
    }

    public void setObjs(int i, idw.idwws.ObjDTO _value) {
        this.objs[i] = _value;
    }


    /**
     * Gets the resultadoEvento value for this ObjsDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this ObjsDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObjsDTO)) return false;
        ObjsDTO other = (ObjsDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.objs==null && other.getObjs()==null) || 
             (this.objs!=null &&
              java.util.Arrays.equals(this.objs, other.getObjs()))) &&
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
        if (getObjs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getObjs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getObjs(), i);
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
        new org.apache.axis.description.TypeDesc(ObjsDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "objsDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "objs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "objDTO"));
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
