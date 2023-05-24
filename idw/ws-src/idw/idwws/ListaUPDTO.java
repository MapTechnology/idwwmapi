/**
 * ListaUPDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ListaUPDTO  implements java.io.Serializable {
    private idw.idwws.UpDTO[] listaUPDTO;

    private idw.idwws.PrUp[] prUps;

    private idw.idwws.ResultadoMSDTO resultadoDTO;

    public ListaUPDTO() {
    }

    public ListaUPDTO(
           idw.idwws.UpDTO[] listaUPDTO,
           idw.idwws.PrUp[] prUps,
           idw.idwws.ResultadoMSDTO resultadoDTO) {
           this.listaUPDTO = listaUPDTO;
           this.prUps = prUps;
           this.resultadoDTO = resultadoDTO;
    }


    /**
     * Gets the listaUPDTO value for this ListaUPDTO.
     * 
     * @return listaUPDTO
     */
    public idw.idwws.UpDTO[] getListaUPDTO() {
        return listaUPDTO;
    }


    /**
     * Sets the listaUPDTO value for this ListaUPDTO.
     * 
     * @param listaUPDTO
     */
    public void setListaUPDTO(idw.idwws.UpDTO[] listaUPDTO) {
        this.listaUPDTO = listaUPDTO;
    }

    public idw.idwws.UpDTO getListaUPDTO(int i) {
        return this.listaUPDTO[i];
    }

    public void setListaUPDTO(int i, idw.idwws.UpDTO _value) {
        this.listaUPDTO[i] = _value;
    }


    /**
     * Gets the prUps value for this ListaUPDTO.
     * 
     * @return prUps
     */
    public idw.idwws.PrUp[] getPrUps() {
        return prUps;
    }


    /**
     * Sets the prUps value for this ListaUPDTO.
     * 
     * @param prUps
     */
    public void setPrUps(idw.idwws.PrUp[] prUps) {
        this.prUps = prUps;
    }

    public idw.idwws.PrUp getPrUps(int i) {
        return this.prUps[i];
    }

    public void setPrUps(int i, idw.idwws.PrUp _value) {
        this.prUps[i] = _value;
    }


    /**
     * Gets the resultadoDTO value for this ListaUPDTO.
     * 
     * @return resultadoDTO
     */
    public idw.idwws.ResultadoMSDTO getResultadoDTO() {
        return resultadoDTO;
    }


    /**
     * Sets the resultadoDTO value for this ListaUPDTO.
     * 
     * @param resultadoDTO
     */
    public void setResultadoDTO(idw.idwws.ResultadoMSDTO resultadoDTO) {
        this.resultadoDTO = resultadoDTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListaUPDTO)) return false;
        ListaUPDTO other = (ListaUPDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listaUPDTO==null && other.getListaUPDTO()==null) || 
             (this.listaUPDTO!=null &&
              java.util.Arrays.equals(this.listaUPDTO, other.getListaUPDTO()))) &&
            ((this.prUps==null && other.getPrUps()==null) || 
             (this.prUps!=null &&
              java.util.Arrays.equals(this.prUps, other.getPrUps()))) &&
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
        if (getListaUPDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaUPDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaUPDTO(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPrUps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrUps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrUps(), i);
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
        new org.apache.axis.description.TypeDesc(ListaUPDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "listaUPDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaUPDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaUPDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "upDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prUps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prUps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prUp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "resultadoMSDTO"));
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
