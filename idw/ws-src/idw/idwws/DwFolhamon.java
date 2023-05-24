/**
 * DwFolhamon.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwFolhamon  extends idw.idwws.DwFolhamonTemplate  implements java.io.Serializable {
    private idw.idwws.DwFolha dwFolha;

    private idw.idwws.DwFolhamoncomp[] dwFolhamoncomps;

    private long idFolhamon;

    private idw.idwws.OmProduto omProduto;

    public DwFolhamon() {
    }

    public DwFolhamon(
           idw.idwws.DwFolha dwFolha,
           idw.idwws.DwFolhamoncomp[] dwFolhamoncomps,
           long idFolhamon,
           idw.idwws.OmProduto omProduto) {
        this.dwFolha = dwFolha;
        this.dwFolhamoncomps = dwFolhamoncomps;
        this.idFolhamon = idFolhamon;
        this.omProduto = omProduto;
    }


    /**
     * Gets the dwFolha value for this DwFolhamon.
     * 
     * @return dwFolha
     */
    public idw.idwws.DwFolha getDwFolha() {
        return dwFolha;
    }


    /**
     * Sets the dwFolha value for this DwFolhamon.
     * 
     * @param dwFolha
     */
    public void setDwFolha(idw.idwws.DwFolha dwFolha) {
        this.dwFolha = dwFolha;
    }


    /**
     * Gets the dwFolhamoncomps value for this DwFolhamon.
     * 
     * @return dwFolhamoncomps
     */
    public idw.idwws.DwFolhamoncomp[] getDwFolhamoncomps() {
        return dwFolhamoncomps;
    }


    /**
     * Sets the dwFolhamoncomps value for this DwFolhamon.
     * 
     * @param dwFolhamoncomps
     */
    public void setDwFolhamoncomps(idw.idwws.DwFolhamoncomp[] dwFolhamoncomps) {
        this.dwFolhamoncomps = dwFolhamoncomps;
    }

    public idw.idwws.DwFolhamoncomp getDwFolhamoncomps(int i) {
        return this.dwFolhamoncomps[i];
    }

    public void setDwFolhamoncomps(int i, idw.idwws.DwFolhamoncomp _value) {
        this.dwFolhamoncomps[i] = _value;
    }


    /**
     * Gets the idFolhamon value for this DwFolhamon.
     * 
     * @return idFolhamon
     */
    public long getIdFolhamon() {
        return idFolhamon;
    }


    /**
     * Sets the idFolhamon value for this DwFolhamon.
     * 
     * @param idFolhamon
     */
    public void setIdFolhamon(long idFolhamon) {
        this.idFolhamon = idFolhamon;
    }


    /**
     * Gets the omProduto value for this DwFolhamon.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this DwFolhamon.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwFolhamon)) return false;
        DwFolhamon other = (DwFolhamon) obj;
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
            ((this.dwFolhamoncomps==null && other.getDwFolhamoncomps()==null) || 
             (this.dwFolhamoncomps!=null &&
              java.util.Arrays.equals(this.dwFolhamoncomps, other.getDwFolhamoncomps()))) &&
            this.idFolhamon == other.getIdFolhamon() &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto())));
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
        if (getDwFolhamoncomps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolhamoncomps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolhamoncomps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdFolhamon()).hashCode();
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwFolhamon.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhamon"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhamoncomps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhamoncomps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhamoncomp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFolhamon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFolhamon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
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
