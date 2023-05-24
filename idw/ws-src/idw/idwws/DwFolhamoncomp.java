/**
 * DwFolhamoncomp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwFolhamoncomp  extends idw.idwws.DwFolhamoncompTemplate  implements java.io.Serializable {
    private java.lang.String dsMon;

    private idw.idwws.DwFolhamon dwFolhamon;

    private long idFolhamoncomp;

    private java.lang.Boolean isAceitarAlter;

    private idw.idwws.OmProduto omProduto;

    private java.lang.Integer ordem;

    public DwFolhamoncomp() {
    }

    public DwFolhamoncomp(
           java.lang.String dsMon,
           idw.idwws.DwFolhamon dwFolhamon,
           long idFolhamoncomp,
           java.lang.Boolean isAceitarAlter,
           idw.idwws.OmProduto omProduto,
           java.lang.Integer ordem) {
        this.dsMon = dsMon;
        this.dwFolhamon = dwFolhamon;
        this.idFolhamoncomp = idFolhamoncomp;
        this.isAceitarAlter = isAceitarAlter;
        this.omProduto = omProduto;
        this.ordem = ordem;
    }


    /**
     * Gets the dsMon value for this DwFolhamoncomp.
     * 
     * @return dsMon
     */
    public java.lang.String getDsMon() {
        return dsMon;
    }


    /**
     * Sets the dsMon value for this DwFolhamoncomp.
     * 
     * @param dsMon
     */
    public void setDsMon(java.lang.String dsMon) {
        this.dsMon = dsMon;
    }


    /**
     * Gets the dwFolhamon value for this DwFolhamoncomp.
     * 
     * @return dwFolhamon
     */
    public idw.idwws.DwFolhamon getDwFolhamon() {
        return dwFolhamon;
    }


    /**
     * Sets the dwFolhamon value for this DwFolhamoncomp.
     * 
     * @param dwFolhamon
     */
    public void setDwFolhamon(idw.idwws.DwFolhamon dwFolhamon) {
        this.dwFolhamon = dwFolhamon;
    }


    /**
     * Gets the idFolhamoncomp value for this DwFolhamoncomp.
     * 
     * @return idFolhamoncomp
     */
    public long getIdFolhamoncomp() {
        return idFolhamoncomp;
    }


    /**
     * Sets the idFolhamoncomp value for this DwFolhamoncomp.
     * 
     * @param idFolhamoncomp
     */
    public void setIdFolhamoncomp(long idFolhamoncomp) {
        this.idFolhamoncomp = idFolhamoncomp;
    }


    /**
     * Gets the isAceitarAlter value for this DwFolhamoncomp.
     * 
     * @return isAceitarAlter
     */
    public java.lang.Boolean getIsAceitarAlter() {
        return isAceitarAlter;
    }


    /**
     * Sets the isAceitarAlter value for this DwFolhamoncomp.
     * 
     * @param isAceitarAlter
     */
    public void setIsAceitarAlter(java.lang.Boolean isAceitarAlter) {
        this.isAceitarAlter = isAceitarAlter;
    }


    /**
     * Gets the omProduto value for this DwFolhamoncomp.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this DwFolhamoncomp.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the ordem value for this DwFolhamoncomp.
     * 
     * @return ordem
     */
    public java.lang.Integer getOrdem() {
        return ordem;
    }


    /**
     * Sets the ordem value for this DwFolhamoncomp.
     * 
     * @param ordem
     */
    public void setOrdem(java.lang.Integer ordem) {
        this.ordem = ordem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwFolhamoncomp)) return false;
        DwFolhamoncomp other = (DwFolhamoncomp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dsMon==null && other.getDsMon()==null) || 
             (this.dsMon!=null &&
              this.dsMon.equals(other.getDsMon()))) &&
            ((this.dwFolhamon==null && other.getDwFolhamon()==null) || 
             (this.dwFolhamon!=null &&
              this.dwFolhamon.equals(other.getDwFolhamon()))) &&
            this.idFolhamoncomp == other.getIdFolhamoncomp() &&
            ((this.isAceitarAlter==null && other.getIsAceitarAlter()==null) || 
             (this.isAceitarAlter!=null &&
              this.isAceitarAlter.equals(other.getIsAceitarAlter()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.ordem==null && other.getOrdem()==null) || 
             (this.ordem!=null &&
              this.ordem.equals(other.getOrdem())));
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
        if (getDsMon() != null) {
            _hashCode += getDsMon().hashCode();
        }
        if (getDwFolhamon() != null) {
            _hashCode += getDwFolhamon().hashCode();
        }
        _hashCode += new Long(getIdFolhamoncomp()).hashCode();
        if (getIsAceitarAlter() != null) {
            _hashCode += getIsAceitarAlter().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getOrdem() != null) {
            _hashCode += getOrdem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwFolhamoncomp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhamoncomp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsMon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsMon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhamon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhamon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhamon"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFolhamoncomp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFolhamoncomp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAceitarAlter");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isAceitarAlter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
