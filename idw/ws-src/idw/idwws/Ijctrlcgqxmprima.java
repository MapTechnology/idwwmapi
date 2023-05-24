/**
 * Ijctrlcgqxmprima.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijctrlcgqxmprima  implements java.io.Serializable {
    private java.util.Calendar dthrivalcompmprima;

    private double idregistro;

    private idw.idwws.Ijctrlcgqalt ijctrlcgqalt;

    private idw.idwws.Ijtbmprima ijtbmprima;

    private java.lang.String nrlotemprima;

    public Ijctrlcgqxmprima() {
    }

    public Ijctrlcgqxmprima(
           java.util.Calendar dthrivalcompmprima,
           double idregistro,
           idw.idwws.Ijctrlcgqalt ijctrlcgqalt,
           idw.idwws.Ijtbmprima ijtbmprima,
           java.lang.String nrlotemprima) {
           this.dthrivalcompmprima = dthrivalcompmprima;
           this.idregistro = idregistro;
           this.ijctrlcgqalt = ijctrlcgqalt;
           this.ijtbmprima = ijtbmprima;
           this.nrlotemprima = nrlotemprima;
    }


    /**
     * Gets the dthrivalcompmprima value for this Ijctrlcgqxmprima.
     * 
     * @return dthrivalcompmprima
     */
    public java.util.Calendar getDthrivalcompmprima() {
        return dthrivalcompmprima;
    }


    /**
     * Sets the dthrivalcompmprima value for this Ijctrlcgqxmprima.
     * 
     * @param dthrivalcompmprima
     */
    public void setDthrivalcompmprima(java.util.Calendar dthrivalcompmprima) {
        this.dthrivalcompmprima = dthrivalcompmprima;
    }


    /**
     * Gets the idregistro value for this Ijctrlcgqxmprima.
     * 
     * @return idregistro
     */
    public double getIdregistro() {
        return idregistro;
    }


    /**
     * Sets the idregistro value for this Ijctrlcgqxmprima.
     * 
     * @param idregistro
     */
    public void setIdregistro(double idregistro) {
        this.idregistro = idregistro;
    }


    /**
     * Gets the ijctrlcgqalt value for this Ijctrlcgqxmprima.
     * 
     * @return ijctrlcgqalt
     */
    public idw.idwws.Ijctrlcgqalt getIjctrlcgqalt() {
        return ijctrlcgqalt;
    }


    /**
     * Sets the ijctrlcgqalt value for this Ijctrlcgqxmprima.
     * 
     * @param ijctrlcgqalt
     */
    public void setIjctrlcgqalt(idw.idwws.Ijctrlcgqalt ijctrlcgqalt) {
        this.ijctrlcgqalt = ijctrlcgqalt;
    }


    /**
     * Gets the ijtbmprima value for this Ijctrlcgqxmprima.
     * 
     * @return ijtbmprima
     */
    public idw.idwws.Ijtbmprima getIjtbmprima() {
        return ijtbmprima;
    }


    /**
     * Sets the ijtbmprima value for this Ijctrlcgqxmprima.
     * 
     * @param ijtbmprima
     */
    public void setIjtbmprima(idw.idwws.Ijtbmprima ijtbmprima) {
        this.ijtbmprima = ijtbmprima;
    }


    /**
     * Gets the nrlotemprima value for this Ijctrlcgqxmprima.
     * 
     * @return nrlotemprima
     */
    public java.lang.String getNrlotemprima() {
        return nrlotemprima;
    }


    /**
     * Sets the nrlotemprima value for this Ijctrlcgqxmprima.
     * 
     * @param nrlotemprima
     */
    public void setNrlotemprima(java.lang.String nrlotemprima) {
        this.nrlotemprima = nrlotemprima;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijctrlcgqxmprima)) return false;
        Ijctrlcgqxmprima other = (Ijctrlcgqxmprima) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrivalcompmprima==null && other.getDthrivalcompmprima()==null) || 
             (this.dthrivalcompmprima!=null &&
              this.dthrivalcompmprima.equals(other.getDthrivalcompmprima()))) &&
            this.idregistro == other.getIdregistro() &&
            ((this.ijctrlcgqalt==null && other.getIjctrlcgqalt()==null) || 
             (this.ijctrlcgqalt!=null &&
              this.ijctrlcgqalt.equals(other.getIjctrlcgqalt()))) &&
            ((this.ijtbmprima==null && other.getIjtbmprima()==null) || 
             (this.ijtbmprima!=null &&
              this.ijtbmprima.equals(other.getIjtbmprima()))) &&
            ((this.nrlotemprima==null && other.getNrlotemprima()==null) || 
             (this.nrlotemprima!=null &&
              this.nrlotemprima.equals(other.getNrlotemprima())));
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
        if (getDthrivalcompmprima() != null) {
            _hashCode += getDthrivalcompmprima().hashCode();
        }
        _hashCode += new Double(getIdregistro()).hashCode();
        if (getIjctrlcgqalt() != null) {
            _hashCode += getIjctrlcgqalt().hashCode();
        }
        if (getIjtbmprima() != null) {
            _hashCode += getIjtbmprima().hashCode();
        }
        if (getNrlotemprima() != null) {
            _hashCode += getNrlotemprima().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijctrlcgqxmprima.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlcgqxmprima"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrivalcompmprima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrivalcompmprima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idregistro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idregistro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrlcgqalt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrlcgqalt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlcgqalt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmprima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmprima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmprima"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrlotemprima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrlotemprima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
