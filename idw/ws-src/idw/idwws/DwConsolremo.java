/**
 * DwConsolremo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolremo  implements java.io.Serializable {
    private idw.idwws.DwConsolmo dwConsolmo;

    private idw.idwws.DwConsolre dwConsolre;

    private long idConsolremo;

    private java.lang.Long pcsAutoProducaorefugada;

    private java.lang.Long pcsManuProducaorefugada;

    public DwConsolremo() {
    }

    public DwConsolremo(
           idw.idwws.DwConsolmo dwConsolmo,
           idw.idwws.DwConsolre dwConsolre,
           long idConsolremo,
           java.lang.Long pcsAutoProducaorefugada,
           java.lang.Long pcsManuProducaorefugada) {
           this.dwConsolmo = dwConsolmo;
           this.dwConsolre = dwConsolre;
           this.idConsolremo = idConsolremo;
           this.pcsAutoProducaorefugada = pcsAutoProducaorefugada;
           this.pcsManuProducaorefugada = pcsManuProducaorefugada;
    }


    /**
     * Gets the dwConsolmo value for this DwConsolremo.
     * 
     * @return dwConsolmo
     */
    public idw.idwws.DwConsolmo getDwConsolmo() {
        return dwConsolmo;
    }


    /**
     * Sets the dwConsolmo value for this DwConsolremo.
     * 
     * @param dwConsolmo
     */
    public void setDwConsolmo(idw.idwws.DwConsolmo dwConsolmo) {
        this.dwConsolmo = dwConsolmo;
    }


    /**
     * Gets the dwConsolre value for this DwConsolremo.
     * 
     * @return dwConsolre
     */
    public idw.idwws.DwConsolre getDwConsolre() {
        return dwConsolre;
    }


    /**
     * Sets the dwConsolre value for this DwConsolremo.
     * 
     * @param dwConsolre
     */
    public void setDwConsolre(idw.idwws.DwConsolre dwConsolre) {
        this.dwConsolre = dwConsolre;
    }


    /**
     * Gets the idConsolremo value for this DwConsolremo.
     * 
     * @return idConsolremo
     */
    public long getIdConsolremo() {
        return idConsolremo;
    }


    /**
     * Sets the idConsolremo value for this DwConsolremo.
     * 
     * @param idConsolremo
     */
    public void setIdConsolremo(long idConsolremo) {
        this.idConsolremo = idConsolremo;
    }


    /**
     * Gets the pcsAutoProducaorefugada value for this DwConsolremo.
     * 
     * @return pcsAutoProducaorefugada
     */
    public java.lang.Long getPcsAutoProducaorefugada() {
        return pcsAutoProducaorefugada;
    }


    /**
     * Sets the pcsAutoProducaorefugada value for this DwConsolremo.
     * 
     * @param pcsAutoProducaorefugada
     */
    public void setPcsAutoProducaorefugada(java.lang.Long pcsAutoProducaorefugada) {
        this.pcsAutoProducaorefugada = pcsAutoProducaorefugada;
    }


    /**
     * Gets the pcsManuProducaorefugada value for this DwConsolremo.
     * 
     * @return pcsManuProducaorefugada
     */
    public java.lang.Long getPcsManuProducaorefugada() {
        return pcsManuProducaorefugada;
    }


    /**
     * Sets the pcsManuProducaorefugada value for this DwConsolremo.
     * 
     * @param pcsManuProducaorefugada
     */
    public void setPcsManuProducaorefugada(java.lang.Long pcsManuProducaorefugada) {
        this.pcsManuProducaorefugada = pcsManuProducaorefugada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolremo)) return false;
        DwConsolremo other = (DwConsolremo) obj;
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
            ((this.dwConsolre==null && other.getDwConsolre()==null) || 
             (this.dwConsolre!=null &&
              this.dwConsolre.equals(other.getDwConsolre()))) &&
            this.idConsolremo == other.getIdConsolremo() &&
            ((this.pcsAutoProducaorefugada==null && other.getPcsAutoProducaorefugada()==null) || 
             (this.pcsAutoProducaorefugada!=null &&
              this.pcsAutoProducaorefugada.equals(other.getPcsAutoProducaorefugada()))) &&
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
        if (getDwConsolre() != null) {
            _hashCode += getDwConsolre().hashCode();
        }
        _hashCode += new Long(getIdConsolremo()).hashCode();
        if (getPcsAutoProducaorefugada() != null) {
            _hashCode += getPcsAutoProducaorefugada().hashCode();
        }
        if (getPcsManuProducaorefugada() != null) {
            _hashCode += getPcsManuProducaorefugada().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolremo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolremo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolre"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolremo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolremo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
