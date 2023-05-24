/**
 * FiltroCiclosDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class FiltroCiclosDTO  implements java.io.Serializable {
    private idw.idwws.FiltroAnaliseTurnoDTO analiseTurnoDTO;

    private idw.idwws.OmPt omPt;

    private idw.idwws.PpCp ppCp;

    public FiltroCiclosDTO() {
    }

    public FiltroCiclosDTO(
           idw.idwws.FiltroAnaliseTurnoDTO analiseTurnoDTO,
           idw.idwws.OmPt omPt,
           idw.idwws.PpCp ppCp) {
           this.analiseTurnoDTO = analiseTurnoDTO;
           this.omPt = omPt;
           this.ppCp = ppCp;
    }


    /**
     * Gets the analiseTurnoDTO value for this FiltroCiclosDTO.
     * 
     * @return analiseTurnoDTO
     */
    public idw.idwws.FiltroAnaliseTurnoDTO getAnaliseTurnoDTO() {
        return analiseTurnoDTO;
    }


    /**
     * Sets the analiseTurnoDTO value for this FiltroCiclosDTO.
     * 
     * @param analiseTurnoDTO
     */
    public void setAnaliseTurnoDTO(idw.idwws.FiltroAnaliseTurnoDTO analiseTurnoDTO) {
        this.analiseTurnoDTO = analiseTurnoDTO;
    }


    /**
     * Gets the omPt value for this FiltroCiclosDTO.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this FiltroCiclosDTO.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the ppCp value for this FiltroCiclosDTO.
     * 
     * @return ppCp
     */
    public idw.idwws.PpCp getPpCp() {
        return ppCp;
    }


    /**
     * Sets the ppCp value for this FiltroCiclosDTO.
     * 
     * @param ppCp
     */
    public void setPpCp(idw.idwws.PpCp ppCp) {
        this.ppCp = ppCp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FiltroCiclosDTO)) return false;
        FiltroCiclosDTO other = (FiltroCiclosDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.analiseTurnoDTO==null && other.getAnaliseTurnoDTO()==null) || 
             (this.analiseTurnoDTO!=null &&
              this.analiseTurnoDTO.equals(other.getAnaliseTurnoDTO()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.ppCp==null && other.getPpCp()==null) || 
             (this.ppCp!=null &&
              this.ppCp.equals(other.getPpCp())));
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
        if (getAnaliseTurnoDTO() != null) {
            _hashCode += getAnaliseTurnoDTO().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getPpCp() != null) {
            _hashCode += getPpCp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FiltroCiclosDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "filtroCiclosDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("analiseTurnoDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "analiseTurnoDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "filtroAnaliseTurnoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
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
