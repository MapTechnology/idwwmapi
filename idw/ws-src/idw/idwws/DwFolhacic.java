/**
 * DwFolhacic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwFolhacic  extends idw.idwws.DwFolhacicTemplate  implements java.io.Serializable {
    private idw.idwws.DwFolha dwFolha;

    private java.lang.Long idFolhacic;

    private idw.idwws.OmGt omGt;

    private idw.idwws.OmPt omPt;

    private java.math.BigDecimal segCiclopadrao;

    public DwFolhacic() {
    }

    public DwFolhacic(
           idw.idwws.DwFolha dwFolha,
           java.lang.Long idFolhacic,
           idw.idwws.OmGt omGt,
           idw.idwws.OmPt omPt,
           java.math.BigDecimal segCiclopadrao) {
        this.dwFolha = dwFolha;
        this.idFolhacic = idFolhacic;
        this.omGt = omGt;
        this.omPt = omPt;
        this.segCiclopadrao = segCiclopadrao;
    }


    /**
     * Gets the dwFolha value for this DwFolhacic.
     * 
     * @return dwFolha
     */
    public idw.idwws.DwFolha getDwFolha() {
        return dwFolha;
    }


    /**
     * Sets the dwFolha value for this DwFolhacic.
     * 
     * @param dwFolha
     */
    public void setDwFolha(idw.idwws.DwFolha dwFolha) {
        this.dwFolha = dwFolha;
    }


    /**
     * Gets the idFolhacic value for this DwFolhacic.
     * 
     * @return idFolhacic
     */
    public java.lang.Long getIdFolhacic() {
        return idFolhacic;
    }


    /**
     * Sets the idFolhacic value for this DwFolhacic.
     * 
     * @param idFolhacic
     */
    public void setIdFolhacic(java.lang.Long idFolhacic) {
        this.idFolhacic = idFolhacic;
    }


    /**
     * Gets the omGt value for this DwFolhacic.
     * 
     * @return omGt
     */
    public idw.idwws.OmGt getOmGt() {
        return omGt;
    }


    /**
     * Sets the omGt value for this DwFolhacic.
     * 
     * @param omGt
     */
    public void setOmGt(idw.idwws.OmGt omGt) {
        this.omGt = omGt;
    }


    /**
     * Gets the omPt value for this DwFolhacic.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this DwFolhacic.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the segCiclopadrao value for this DwFolhacic.
     * 
     * @return segCiclopadrao
     */
    public java.math.BigDecimal getSegCiclopadrao() {
        return segCiclopadrao;
    }


    /**
     * Sets the segCiclopadrao value for this DwFolhacic.
     * 
     * @param segCiclopadrao
     */
    public void setSegCiclopadrao(java.math.BigDecimal segCiclopadrao) {
        this.segCiclopadrao = segCiclopadrao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwFolhacic)) return false;
        DwFolhacic other = (DwFolhacic) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwFolha==null && other.getDwFolha()==null) || 
             (this.dwFolha!=null &&
              this.dwFolha.equals(other.getDwFolha()))) &&
            ((this.idFolhacic==null && other.getIdFolhacic()==null) || 
             (this.idFolhacic!=null &&
              this.idFolhacic.equals(other.getIdFolhacic()))) &&
            ((this.omGt==null && other.getOmGt()==null) || 
             (this.omGt!=null &&
              this.omGt.equals(other.getOmGt()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.segCiclopadrao==null && other.getSegCiclopadrao()==null) || 
             (this.segCiclopadrao!=null &&
              this.segCiclopadrao.equals(other.getSegCiclopadrao())));
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
        if (getDwFolha() != null) {
            _hashCode += getDwFolha().hashCode();
        }
        if (getIdFolhacic() != null) {
            _hashCode += getIdFolhacic().hashCode();
        }
        if (getOmGt() != null) {
            _hashCode += getOmGt().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getSegCiclopadrao() != null) {
            _hashCode += getSegCiclopadrao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwFolhacic.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhacic"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFolhacic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFolhacic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omGt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGt"));
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
        elemField.setFieldName("segCiclopadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segCiclopadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
