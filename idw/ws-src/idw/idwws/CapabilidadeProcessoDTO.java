/**
 * CapabilidadeProcessoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class CapabilidadeProcessoDTO  implements java.io.Serializable {
    private double cp;

    private double cpi;

    private double cpk;

    private double cps;

    private double desvioPadrao;

    private double lie;

    private double lse;

    private double media;

    private long n;

    public CapabilidadeProcessoDTO() {
    }

    public CapabilidadeProcessoDTO(
           double cp,
           double cpi,
           double cpk,
           double cps,
           double desvioPadrao,
           double lie,
           double lse,
           double media,
           long n) {
           this.cp = cp;
           this.cpi = cpi;
           this.cpk = cpk;
           this.cps = cps;
           this.desvioPadrao = desvioPadrao;
           this.lie = lie;
           this.lse = lse;
           this.media = media;
           this.n = n;
    }


    /**
     * Gets the cp value for this CapabilidadeProcessoDTO.
     * 
     * @return cp
     */
    public double getCp() {
        return cp;
    }


    /**
     * Sets the cp value for this CapabilidadeProcessoDTO.
     * 
     * @param cp
     */
    public void setCp(double cp) {
        this.cp = cp;
    }


    /**
     * Gets the cpi value for this CapabilidadeProcessoDTO.
     * 
     * @return cpi
     */
    public double getCpi() {
        return cpi;
    }


    /**
     * Sets the cpi value for this CapabilidadeProcessoDTO.
     * 
     * @param cpi
     */
    public void setCpi(double cpi) {
        this.cpi = cpi;
    }


    /**
     * Gets the cpk value for this CapabilidadeProcessoDTO.
     * 
     * @return cpk
     */
    public double getCpk() {
        return cpk;
    }


    /**
     * Sets the cpk value for this CapabilidadeProcessoDTO.
     * 
     * @param cpk
     */
    public void setCpk(double cpk) {
        this.cpk = cpk;
    }


    /**
     * Gets the cps value for this CapabilidadeProcessoDTO.
     * 
     * @return cps
     */
    public double getCps() {
        return cps;
    }


    /**
     * Sets the cps value for this CapabilidadeProcessoDTO.
     * 
     * @param cps
     */
    public void setCps(double cps) {
        this.cps = cps;
    }


    /**
     * Gets the desvioPadrao value for this CapabilidadeProcessoDTO.
     * 
     * @return desvioPadrao
     */
    public double getDesvioPadrao() {
        return desvioPadrao;
    }


    /**
     * Sets the desvioPadrao value for this CapabilidadeProcessoDTO.
     * 
     * @param desvioPadrao
     */
    public void setDesvioPadrao(double desvioPadrao) {
        this.desvioPadrao = desvioPadrao;
    }


    /**
     * Gets the lie value for this CapabilidadeProcessoDTO.
     * 
     * @return lie
     */
    public double getLie() {
        return lie;
    }


    /**
     * Sets the lie value for this CapabilidadeProcessoDTO.
     * 
     * @param lie
     */
    public void setLie(double lie) {
        this.lie = lie;
    }


    /**
     * Gets the lse value for this CapabilidadeProcessoDTO.
     * 
     * @return lse
     */
    public double getLse() {
        return lse;
    }


    /**
     * Sets the lse value for this CapabilidadeProcessoDTO.
     * 
     * @param lse
     */
    public void setLse(double lse) {
        this.lse = lse;
    }


    /**
     * Gets the media value for this CapabilidadeProcessoDTO.
     * 
     * @return media
     */
    public double getMedia() {
        return media;
    }


    /**
     * Sets the media value for this CapabilidadeProcessoDTO.
     * 
     * @param media
     */
    public void setMedia(double media) {
        this.media = media;
    }


    /**
     * Gets the n value for this CapabilidadeProcessoDTO.
     * 
     * @return n
     */
    public long getN() {
        return n;
    }


    /**
     * Sets the n value for this CapabilidadeProcessoDTO.
     * 
     * @param n
     */
    public void setN(long n) {
        this.n = n;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CapabilidadeProcessoDTO)) return false;
        CapabilidadeProcessoDTO other = (CapabilidadeProcessoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cp == other.getCp() &&
            this.cpi == other.getCpi() &&
            this.cpk == other.getCpk() &&
            this.cps == other.getCps() &&
            this.desvioPadrao == other.getDesvioPadrao() &&
            this.lie == other.getLie() &&
            this.lse == other.getLse() &&
            this.media == other.getMedia() &&
            this.n == other.getN();
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
        _hashCode += new Double(getCp()).hashCode();
        _hashCode += new Double(getCpi()).hashCode();
        _hashCode += new Double(getCpk()).hashCode();
        _hashCode += new Double(getCps()).hashCode();
        _hashCode += new Double(getDesvioPadrao()).hashCode();
        _hashCode += new Double(getLie()).hashCode();
        _hashCode += new Double(getLse()).hashCode();
        _hashCode += new Double(getMedia()).hashCode();
        _hashCode += new Long(getN()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CapabilidadeProcessoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "capabilidadeProcessoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cpi");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cpi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cpk");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cpk"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("desvioPadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "desvioPadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lie");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lse");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("media");
        elemField.setXmlName(new javax.xml.namespace.QName("", "media"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("n");
        elemField.setXmlName(new javax.xml.namespace.QName("", "n"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
