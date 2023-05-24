/**
 * PtGtDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PtGtDTO  implements java.io.Serializable {
    private idw.idwws.OmGt[] listaGt;

    private idw.idwws.OmPt[] listaPt;

    private idw.idwws.ResultadoDTO resultadoDTO;

    public PtGtDTO() {
    }

    public PtGtDTO(
           idw.idwws.OmGt[] listaGt,
           idw.idwws.OmPt[] listaPt,
           idw.idwws.ResultadoDTO resultadoDTO) {
           this.listaGt = listaGt;
           this.listaPt = listaPt;
           this.resultadoDTO = resultadoDTO;
    }


    /**
     * Gets the listaGt value for this PtGtDTO.
     * 
     * @return listaGt
     */
    public idw.idwws.OmGt[] getListaGt() {
        return listaGt;
    }


    /**
     * Sets the listaGt value for this PtGtDTO.
     * 
     * @param listaGt
     */
    public void setListaGt(idw.idwws.OmGt[] listaGt) {
        this.listaGt = listaGt;
    }

    public idw.idwws.OmGt getListaGt(int i) {
        return this.listaGt[i];
    }

    public void setListaGt(int i, idw.idwws.OmGt _value) {
        this.listaGt[i] = _value;
    }


    /**
     * Gets the listaPt value for this PtGtDTO.
     * 
     * @return listaPt
     */
    public idw.idwws.OmPt[] getListaPt() {
        return listaPt;
    }


    /**
     * Sets the listaPt value for this PtGtDTO.
     * 
     * @param listaPt
     */
    public void setListaPt(idw.idwws.OmPt[] listaPt) {
        this.listaPt = listaPt;
    }

    public idw.idwws.OmPt getListaPt(int i) {
        return this.listaPt[i];
    }

    public void setListaPt(int i, idw.idwws.OmPt _value) {
        this.listaPt[i] = _value;
    }


    /**
     * Gets the resultadoDTO value for this PtGtDTO.
     * 
     * @return resultadoDTO
     */
    public idw.idwws.ResultadoDTO getResultadoDTO() {
        return resultadoDTO;
    }


    /**
     * Sets the resultadoDTO value for this PtGtDTO.
     * 
     * @param resultadoDTO
     */
    public void setResultadoDTO(idw.idwws.ResultadoDTO resultadoDTO) {
        this.resultadoDTO = resultadoDTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PtGtDTO)) return false;
        PtGtDTO other = (PtGtDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listaGt==null && other.getListaGt()==null) || 
             (this.listaGt!=null &&
              java.util.Arrays.equals(this.listaGt, other.getListaGt()))) &&
            ((this.listaPt==null && other.getListaPt()==null) || 
             (this.listaPt!=null &&
              java.util.Arrays.equals(this.listaPt, other.getListaPt()))) &&
            ((this.resultadoDTO==null && other.getResultadoDTO()==null) || 
             (this.resultadoDTO!=null &&
              this.resultadoDTO.equals(other.getResultadoDTO())));
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
        if (getListaGt() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaGt());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaGt(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaPt() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaPt());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaPt(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getResultadoDTO() != null) {
            _hashCode += getResultadoDTO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PtGtDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ptGtDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoDTO"));
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
