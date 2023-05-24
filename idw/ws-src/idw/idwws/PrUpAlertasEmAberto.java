/**
 * PrUpAlertasEmAberto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PrUpAlertasEmAberto  implements java.io.Serializable {
    private java.lang.String cdalerta;

    private java.util.Calendar dthrinialerta;

    private java.lang.String idalertaaberto;

    private double msdthrinialerta;

    private idw.idwws.PrUp prUp;

    private java.lang.Integer tpalerta;

    public PrUpAlertasEmAberto() {
    }

    public PrUpAlertasEmAberto(
           java.lang.String cdalerta,
           java.util.Calendar dthrinialerta,
           java.lang.String idalertaaberto,
           double msdthrinialerta,
           idw.idwws.PrUp prUp,
           java.lang.Integer tpalerta) {
           this.cdalerta = cdalerta;
           this.dthrinialerta = dthrinialerta;
           this.idalertaaberto = idalertaaberto;
           this.msdthrinialerta = msdthrinialerta;
           this.prUp = prUp;
           this.tpalerta = tpalerta;
    }


    /**
     * Gets the cdalerta value for this PrUpAlertasEmAberto.
     * 
     * @return cdalerta
     */
    public java.lang.String getCdalerta() {
        return cdalerta;
    }


    /**
     * Sets the cdalerta value for this PrUpAlertasEmAberto.
     * 
     * @param cdalerta
     */
    public void setCdalerta(java.lang.String cdalerta) {
        this.cdalerta = cdalerta;
    }


    /**
     * Gets the dthrinialerta value for this PrUpAlertasEmAberto.
     * 
     * @return dthrinialerta
     */
    public java.util.Calendar getDthrinialerta() {
        return dthrinialerta;
    }


    /**
     * Sets the dthrinialerta value for this PrUpAlertasEmAberto.
     * 
     * @param dthrinialerta
     */
    public void setDthrinialerta(java.util.Calendar dthrinialerta) {
        this.dthrinialerta = dthrinialerta;
    }


    /**
     * Gets the idalertaaberto value for this PrUpAlertasEmAberto.
     * 
     * @return idalertaaberto
     */
    public java.lang.String getIdalertaaberto() {
        return idalertaaberto;
    }


    /**
     * Sets the idalertaaberto value for this PrUpAlertasEmAberto.
     * 
     * @param idalertaaberto
     */
    public void setIdalertaaberto(java.lang.String idalertaaberto) {
        this.idalertaaberto = idalertaaberto;
    }


    /**
     * Gets the msdthrinialerta value for this PrUpAlertasEmAberto.
     * 
     * @return msdthrinialerta
     */
    public double getMsdthrinialerta() {
        return msdthrinialerta;
    }


    /**
     * Sets the msdthrinialerta value for this PrUpAlertasEmAberto.
     * 
     * @param msdthrinialerta
     */
    public void setMsdthrinialerta(double msdthrinialerta) {
        this.msdthrinialerta = msdthrinialerta;
    }


    /**
     * Gets the prUp value for this PrUpAlertasEmAberto.
     * 
     * @return prUp
     */
    public idw.idwws.PrUp getPrUp() {
        return prUp;
    }


    /**
     * Sets the prUp value for this PrUpAlertasEmAberto.
     * 
     * @param prUp
     */
    public void setPrUp(idw.idwws.PrUp prUp) {
        this.prUp = prUp;
    }


    /**
     * Gets the tpalerta value for this PrUpAlertasEmAberto.
     * 
     * @return tpalerta
     */
    public java.lang.Integer getTpalerta() {
        return tpalerta;
    }


    /**
     * Sets the tpalerta value for this PrUpAlertasEmAberto.
     * 
     * @param tpalerta
     */
    public void setTpalerta(java.lang.Integer tpalerta) {
        this.tpalerta = tpalerta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrUpAlertasEmAberto)) return false;
        PrUpAlertasEmAberto other = (PrUpAlertasEmAberto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdalerta==null && other.getCdalerta()==null) || 
             (this.cdalerta!=null &&
              this.cdalerta.equals(other.getCdalerta()))) &&
            ((this.dthrinialerta==null && other.getDthrinialerta()==null) || 
             (this.dthrinialerta!=null &&
              this.dthrinialerta.equals(other.getDthrinialerta()))) &&
            ((this.idalertaaberto==null && other.getIdalertaaberto()==null) || 
             (this.idalertaaberto!=null &&
              this.idalertaaberto.equals(other.getIdalertaaberto()))) &&
            this.msdthrinialerta == other.getMsdthrinialerta() &&
            ((this.prUp==null && other.getPrUp()==null) || 
             (this.prUp!=null &&
              this.prUp.equals(other.getPrUp()))) &&
            ((this.tpalerta==null && other.getTpalerta()==null) || 
             (this.tpalerta!=null &&
              this.tpalerta.equals(other.getTpalerta())));
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
        if (getCdalerta() != null) {
            _hashCode += getCdalerta().hashCode();
        }
        if (getDthrinialerta() != null) {
            _hashCode += getDthrinialerta().hashCode();
        }
        if (getIdalertaaberto() != null) {
            _hashCode += getIdalertaaberto().hashCode();
        }
        _hashCode += new Double(getMsdthrinialerta()).hashCode();
        if (getPrUp() != null) {
            _hashCode += getPrUp().hashCode();
        }
        if (getTpalerta() != null) {
            _hashCode += getTpalerta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PrUpAlertasEmAberto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prUpAlertasEmAberto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrinialerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrinialerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idalertaaberto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idalertaaberto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msdthrinialerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msdthrinialerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prUp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prUp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prUp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpalerta"));
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
