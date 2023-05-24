/**
 * DwConsolprmo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolprmo  implements java.io.Serializable {
    private idw.idwws.DwConsolmo dwConsolmo;

    private idw.idwws.DwConsolpr dwConsolpr;

    private long idConsolprmo;

    private java.lang.Long pcsAutoProducaobruta;

    private java.lang.Long pcsAutoProducaorefugada;

    private java.lang.Long pcsManuProducaobruta;

    private java.lang.Long pcsManuProducaorefugada;

    public DwConsolprmo() {
    }

    public DwConsolprmo(
           idw.idwws.DwConsolmo dwConsolmo,
           idw.idwws.DwConsolpr dwConsolpr,
           long idConsolprmo,
           java.lang.Long pcsAutoProducaobruta,
           java.lang.Long pcsAutoProducaorefugada,
           java.lang.Long pcsManuProducaobruta,
           java.lang.Long pcsManuProducaorefugada) {
           this.dwConsolmo = dwConsolmo;
           this.dwConsolpr = dwConsolpr;
           this.idConsolprmo = idConsolprmo;
           this.pcsAutoProducaobruta = pcsAutoProducaobruta;
           this.pcsAutoProducaorefugada = pcsAutoProducaorefugada;
           this.pcsManuProducaobruta = pcsManuProducaobruta;
           this.pcsManuProducaorefugada = pcsManuProducaorefugada;
    }


    /**
     * Gets the dwConsolmo value for this DwConsolprmo.
     * 
     * @return dwConsolmo
     */
    public idw.idwws.DwConsolmo getDwConsolmo() {
        return dwConsolmo;
    }


    /**
     * Sets the dwConsolmo value for this DwConsolprmo.
     * 
     * @param dwConsolmo
     */
    public void setDwConsolmo(idw.idwws.DwConsolmo dwConsolmo) {
        this.dwConsolmo = dwConsolmo;
    }


    /**
     * Gets the dwConsolpr value for this DwConsolprmo.
     * 
     * @return dwConsolpr
     */
    public idw.idwws.DwConsolpr getDwConsolpr() {
        return dwConsolpr;
    }


    /**
     * Sets the dwConsolpr value for this DwConsolprmo.
     * 
     * @param dwConsolpr
     */
    public void setDwConsolpr(idw.idwws.DwConsolpr dwConsolpr) {
        this.dwConsolpr = dwConsolpr;
    }


    /**
     * Gets the idConsolprmo value for this DwConsolprmo.
     * 
     * @return idConsolprmo
     */
    public long getIdConsolprmo() {
        return idConsolprmo;
    }


    /**
     * Sets the idConsolprmo value for this DwConsolprmo.
     * 
     * @param idConsolprmo
     */
    public void setIdConsolprmo(long idConsolprmo) {
        this.idConsolprmo = idConsolprmo;
    }


    /**
     * Gets the pcsAutoProducaobruta value for this DwConsolprmo.
     * 
     * @return pcsAutoProducaobruta
     */
    public java.lang.Long getPcsAutoProducaobruta() {
        return pcsAutoProducaobruta;
    }


    /**
     * Sets the pcsAutoProducaobruta value for this DwConsolprmo.
     * 
     * @param pcsAutoProducaobruta
     */
    public void setPcsAutoProducaobruta(java.lang.Long pcsAutoProducaobruta) {
        this.pcsAutoProducaobruta = pcsAutoProducaobruta;
    }


    /**
     * Gets the pcsAutoProducaorefugada value for this DwConsolprmo.
     * 
     * @return pcsAutoProducaorefugada
     */
    public java.lang.Long getPcsAutoProducaorefugada() {
        return pcsAutoProducaorefugada;
    }


    /**
     * Sets the pcsAutoProducaorefugada value for this DwConsolprmo.
     * 
     * @param pcsAutoProducaorefugada
     */
    public void setPcsAutoProducaorefugada(java.lang.Long pcsAutoProducaorefugada) {
        this.pcsAutoProducaorefugada = pcsAutoProducaorefugada;
    }


    /**
     * Gets the pcsManuProducaobruta value for this DwConsolprmo.
     * 
     * @return pcsManuProducaobruta
     */
    public java.lang.Long getPcsManuProducaobruta() {
        return pcsManuProducaobruta;
    }


    /**
     * Sets the pcsManuProducaobruta value for this DwConsolprmo.
     * 
     * @param pcsManuProducaobruta
     */
    public void setPcsManuProducaobruta(java.lang.Long pcsManuProducaobruta) {
        this.pcsManuProducaobruta = pcsManuProducaobruta;
    }


    /**
     * Gets the pcsManuProducaorefugada value for this DwConsolprmo.
     * 
     * @return pcsManuProducaorefugada
     */
    public java.lang.Long getPcsManuProducaorefugada() {
        return pcsManuProducaorefugada;
    }


    /**
     * Sets the pcsManuProducaorefugada value for this DwConsolprmo.
     * 
     * @param pcsManuProducaorefugada
     */
    public void setPcsManuProducaorefugada(java.lang.Long pcsManuProducaorefugada) {
        this.pcsManuProducaorefugada = pcsManuProducaorefugada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolprmo)) return false;
        DwConsolprmo other = (DwConsolprmo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dwConsolmo==null && other.getDwConsolmo()==null) || 
             (this.dwConsolmo!=null &&
              this.dwConsolmo.equals(other.getDwConsolmo()))) &&
            ((this.dwConsolpr==null && other.getDwConsolpr()==null) || 
             (this.dwConsolpr!=null &&
              this.dwConsolpr.equals(other.getDwConsolpr()))) &&
            this.idConsolprmo == other.getIdConsolprmo() &&
            ((this.pcsAutoProducaobruta==null && other.getPcsAutoProducaobruta()==null) || 
             (this.pcsAutoProducaobruta!=null &&
              this.pcsAutoProducaobruta.equals(other.getPcsAutoProducaobruta()))) &&
            ((this.pcsAutoProducaorefugada==null && other.getPcsAutoProducaorefugada()==null) || 
             (this.pcsAutoProducaorefugada!=null &&
              this.pcsAutoProducaorefugada.equals(other.getPcsAutoProducaorefugada()))) &&
            ((this.pcsManuProducaobruta==null && other.getPcsManuProducaobruta()==null) || 
             (this.pcsManuProducaobruta!=null &&
              this.pcsManuProducaobruta.equals(other.getPcsManuProducaobruta()))) &&
            ((this.pcsManuProducaorefugada==null && other.getPcsManuProducaorefugada()==null) || 
             (this.pcsManuProducaorefugada!=null &&
              this.pcsManuProducaorefugada.equals(other.getPcsManuProducaorefugada())));
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
        if (getDwConsolmo() != null) {
            _hashCode += getDwConsolmo().hashCode();
        }
        if (getDwConsolpr() != null) {
            _hashCode += getDwConsolpr().hashCode();
        }
        _hashCode += new Long(getIdConsolprmo()).hashCode();
        if (getPcsAutoProducaobruta() != null) {
            _hashCode += getPcsAutoProducaobruta().hashCode();
        }
        if (getPcsAutoProducaorefugada() != null) {
            _hashCode += getPcsAutoProducaorefugada().hashCode();
        }
        if (getPcsManuProducaobruta() != null) {
            _hashCode += getPcsManuProducaobruta().hashCode();
        }
        if (getPcsManuProducaorefugada() != null) {
            _hashCode += getPcsManuProducaorefugada().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolprmo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolprmo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolpr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolpr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolprmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolprmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsAutoProducaobruta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsAutoProducaobruta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsAutoProducaorefugada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsAutoProducaorefugada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsManuProducaobruta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsManuProducaobruta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsManuProducaorefugada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsManuProducaorefugada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
