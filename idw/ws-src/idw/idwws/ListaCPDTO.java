/**
 * ListaCPDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ListaCPDTO  implements java.io.Serializable {
    private idw.idwws.CpDTO[] listaCps;

    private idw.idwws.CpDTO[] listaCpsAux;

    private idw.idwws.ResultadoDTO resultado;

    public ListaCPDTO() {
    }

    public ListaCPDTO(
           idw.idwws.CpDTO[] listaCps,
           idw.idwws.CpDTO[] listaCpsAux,
           idw.idwws.ResultadoDTO resultado) {
           this.listaCps = listaCps;
           this.listaCpsAux = listaCpsAux;
           this.resultado = resultado;
    }


    /**
     * Gets the listaCps value for this ListaCPDTO.
     * 
     * @return listaCps
     */
    public idw.idwws.CpDTO[] getListaCps() {
        return listaCps;
    }


    /**
     * Sets the listaCps value for this ListaCPDTO.
     * 
     * @param listaCps
     */
    public void setListaCps(idw.idwws.CpDTO[] listaCps) {
        this.listaCps = listaCps;
    }

    public idw.idwws.CpDTO getListaCps(int i) {
        return this.listaCps[i];
    }

    public void setListaCps(int i, idw.idwws.CpDTO _value) {
        this.listaCps[i] = _value;
    }


    /**
     * Gets the listaCpsAux value for this ListaCPDTO.
     * 
     * @return listaCpsAux
     */
    public idw.idwws.CpDTO[] getListaCpsAux() {
        return listaCpsAux;
    }


    /**
     * Sets the listaCpsAux value for this ListaCPDTO.
     * 
     * @param listaCpsAux
     */
    public void setListaCpsAux(idw.idwws.CpDTO[] listaCpsAux) {
        this.listaCpsAux = listaCpsAux;
    }

    public idw.idwws.CpDTO getListaCpsAux(int i) {
        return this.listaCpsAux[i];
    }

    public void setListaCpsAux(int i, idw.idwws.CpDTO _value) {
        this.listaCpsAux[i] = _value;
    }


    /**
     * Gets the resultado value for this ListaCPDTO.
     * 
     * @return resultado
     */
    public idw.idwws.ResultadoDTO getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this ListaCPDTO.
     * 
     * @param resultado
     */
    public void setResultado(idw.idwws.ResultadoDTO resultado) {
        this.resultado = resultado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListaCPDTO)) return false;
        ListaCPDTO other = (ListaCPDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listaCps==null && other.getListaCps()==null) || 
             (this.listaCps!=null &&
              java.util.Arrays.equals(this.listaCps, other.getListaCps()))) &&
            ((this.listaCpsAux==null && other.getListaCpsAux()==null) || 
             (this.listaCpsAux!=null &&
              java.util.Arrays.equals(this.listaCpsAux, other.getListaCpsAux()))) &&
            ((this.resultado==null && other.getResultado()==null) || 
             (this.resultado!=null &&
              this.resultado.equals(other.getResultado())));
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
        if (getListaCps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaCps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaCps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaCpsAux() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaCpsAux());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaCpsAux(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListaCPDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "listaCPDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaCps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaCps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "cpDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaCpsAux");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaCpsAux"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "cpDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultado"));
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
