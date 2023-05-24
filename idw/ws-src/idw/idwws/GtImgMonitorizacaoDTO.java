/**
 * GtImgMonitorizacaoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class GtImgMonitorizacaoDTO  implements java.io.Serializable {
    private idw.idwws.GtDTO[] gtsDTO;

    private idw.idwws.ImgDTO[] imgsDTO;

    public GtImgMonitorizacaoDTO() {
    }

    public GtImgMonitorizacaoDTO(
           idw.idwws.GtDTO[] gtsDTO,
           idw.idwws.ImgDTO[] imgsDTO) {
           this.gtsDTO = gtsDTO;
           this.imgsDTO = imgsDTO;
    }


    /**
     * Gets the gtsDTO value for this GtImgMonitorizacaoDTO.
     * 
     * @return gtsDTO
     */
    public idw.idwws.GtDTO[] getGtsDTO() {
        return gtsDTO;
    }


    /**
     * Sets the gtsDTO value for this GtImgMonitorizacaoDTO.
     * 
     * @param gtsDTO
     */
    public void setGtsDTO(idw.idwws.GtDTO[] gtsDTO) {
        this.gtsDTO = gtsDTO;
    }


    /**
     * Gets the imgsDTO value for this GtImgMonitorizacaoDTO.
     * 
     * @return imgsDTO
     */
    public idw.idwws.ImgDTO[] getImgsDTO() {
        return imgsDTO;
    }


    /**
     * Sets the imgsDTO value for this GtImgMonitorizacaoDTO.
     * 
     * @param imgsDTO
     */
    public void setImgsDTO(idw.idwws.ImgDTO[] imgsDTO) {
        this.imgsDTO = imgsDTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GtImgMonitorizacaoDTO)) return false;
        GtImgMonitorizacaoDTO other = (GtImgMonitorizacaoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.gtsDTO==null && other.getGtsDTO()==null) || 
             (this.gtsDTO!=null &&
              java.util.Arrays.equals(this.gtsDTO, other.getGtsDTO()))) &&
            ((this.imgsDTO==null && other.getImgsDTO()==null) || 
             (this.imgsDTO!=null &&
              java.util.Arrays.equals(this.imgsDTO, other.getImgsDTO())));
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
        if (getGtsDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGtsDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGtsDTO(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getImgsDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getImgsDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getImgsDTO(), i);
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
        new org.apache.axis.description.TypeDesc(GtImgMonitorizacaoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "gtImgMonitorizacaoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gtsDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gtsDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "gtDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "gts"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imgsDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "imgsDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "imgDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "imgs"));
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
