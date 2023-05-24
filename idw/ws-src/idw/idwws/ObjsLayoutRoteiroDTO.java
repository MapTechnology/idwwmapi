/**
 * ObjsLayoutRoteiroDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ObjsLayoutRoteiroDTO  implements java.io.Serializable {
    private idw.idwws.EstoquesDTO estoquesDTO;

    private idw.idwws.DwFolhaDTO[] folhasDTO;

    private idw.idwws.ImgDTO[] imgsDTO;

    private idw.idwws.PtDTO[] ptsDTO;

    public ObjsLayoutRoteiroDTO() {
    }

    public ObjsLayoutRoteiroDTO(
           idw.idwws.EstoquesDTO estoquesDTO,
           idw.idwws.DwFolhaDTO[] folhasDTO,
           idw.idwws.ImgDTO[] imgsDTO,
           idw.idwws.PtDTO[] ptsDTO) {
           this.estoquesDTO = estoquesDTO;
           this.folhasDTO = folhasDTO;
           this.imgsDTO = imgsDTO;
           this.ptsDTO = ptsDTO;
    }


    /**
     * Gets the estoquesDTO value for this ObjsLayoutRoteiroDTO.
     * 
     * @return estoquesDTO
     */
    public idw.idwws.EstoquesDTO getEstoquesDTO() {
        return estoquesDTO;
    }


    /**
     * Sets the estoquesDTO value for this ObjsLayoutRoteiroDTO.
     * 
     * @param estoquesDTO
     */
    public void setEstoquesDTO(idw.idwws.EstoquesDTO estoquesDTO) {
        this.estoquesDTO = estoquesDTO;
    }


    /**
     * Gets the folhasDTO value for this ObjsLayoutRoteiroDTO.
     * 
     * @return folhasDTO
     */
    public idw.idwws.DwFolhaDTO[] getFolhasDTO() {
        return folhasDTO;
    }


    /**
     * Sets the folhasDTO value for this ObjsLayoutRoteiroDTO.
     * 
     * @param folhasDTO
     */
    public void setFolhasDTO(idw.idwws.DwFolhaDTO[] folhasDTO) {
        this.folhasDTO = folhasDTO;
    }


    /**
     * Gets the imgsDTO value for this ObjsLayoutRoteiroDTO.
     * 
     * @return imgsDTO
     */
    public idw.idwws.ImgDTO[] getImgsDTO() {
        return imgsDTO;
    }


    /**
     * Sets the imgsDTO value for this ObjsLayoutRoteiroDTO.
     * 
     * @param imgsDTO
     */
    public void setImgsDTO(idw.idwws.ImgDTO[] imgsDTO) {
        this.imgsDTO = imgsDTO;
    }


    /**
     * Gets the ptsDTO value for this ObjsLayoutRoteiroDTO.
     * 
     * @return ptsDTO
     */
    public idw.idwws.PtDTO[] getPtsDTO() {
        return ptsDTO;
    }


    /**
     * Sets the ptsDTO value for this ObjsLayoutRoteiroDTO.
     * 
     * @param ptsDTO
     */
    public void setPtsDTO(idw.idwws.PtDTO[] ptsDTO) {
        this.ptsDTO = ptsDTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObjsLayoutRoteiroDTO)) return false;
        ObjsLayoutRoteiroDTO other = (ObjsLayoutRoteiroDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.estoquesDTO==null && other.getEstoquesDTO()==null) || 
             (this.estoquesDTO!=null &&
              this.estoquesDTO.equals(other.getEstoquesDTO()))) &&
            ((this.folhasDTO==null && other.getFolhasDTO()==null) || 
             (this.folhasDTO!=null &&
              java.util.Arrays.equals(this.folhasDTO, other.getFolhasDTO()))) &&
            ((this.imgsDTO==null && other.getImgsDTO()==null) || 
             (this.imgsDTO!=null &&
              java.util.Arrays.equals(this.imgsDTO, other.getImgsDTO()))) &&
            ((this.ptsDTO==null && other.getPtsDTO()==null) || 
             (this.ptsDTO!=null &&
              java.util.Arrays.equals(this.ptsDTO, other.getPtsDTO())));
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
        if (getEstoquesDTO() != null) {
            _hashCode += getEstoquesDTO().hashCode();
        }
        if (getFolhasDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFolhasDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFolhasDTO(), i);
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
        if (getPtsDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPtsDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPtsDTO(), i);
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
        new org.apache.axis.description.TypeDesc(ObjsLayoutRoteiroDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "objsLayoutRoteiroDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estoquesDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estoquesDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "estoquesDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folhasDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "folhasDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhaDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "listaDwFolhaDTO"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imgsDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "imgsDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "imgDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "imgs"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ptsDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ptsDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ptDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "pts"));
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
