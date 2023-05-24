/**
 * IjqldinsploterepId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class IjqldinsploterepId  implements java.io.Serializable {
    private java.lang.String cdrefugo;

    private java.lang.String nrlote;

    private double qtdreprovada;

    public IjqldinsploterepId() {
    }

    public IjqldinsploterepId(
           java.lang.String cdrefugo,
           java.lang.String nrlote,
           double qtdreprovada) {
           this.cdrefugo = cdrefugo;
           this.nrlote = nrlote;
           this.qtdreprovada = qtdreprovada;
    }


    /**
     * Gets the cdrefugo value for this IjqldinsploterepId.
     * 
     * @return cdrefugo
     */
    public java.lang.String getCdrefugo() {
        return cdrefugo;
    }


    /**
     * Sets the cdrefugo value for this IjqldinsploterepId.
     * 
     * @param cdrefugo
     */
    public void setCdrefugo(java.lang.String cdrefugo) {
        this.cdrefugo = cdrefugo;
    }


    /**
     * Gets the nrlote value for this IjqldinsploterepId.
     * 
     * @return nrlote
     */
    public java.lang.String getNrlote() {
        return nrlote;
    }


    /**
     * Sets the nrlote value for this IjqldinsploterepId.
     * 
     * @param nrlote
     */
    public void setNrlote(java.lang.String nrlote) {
        this.nrlote = nrlote;
    }


    /**
     * Gets the qtdreprovada value for this IjqldinsploterepId.
     * 
     * @return qtdreprovada
     */
    public double getQtdreprovada() {
        return qtdreprovada;
    }


    /**
     * Sets the qtdreprovada value for this IjqldinsploterepId.
     * 
     * @param qtdreprovada
     */
    public void setQtdreprovada(double qtdreprovada) {
        this.qtdreprovada = qtdreprovada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IjqldinsploterepId)) return false;
        IjqldinsploterepId other = (IjqldinsploterepId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdrefugo==null && other.getCdrefugo()==null) || 
             (this.cdrefugo!=null &&
              this.cdrefugo.equals(other.getCdrefugo()))) &&
            ((this.nrlote==null && other.getNrlote()==null) || 
             (this.nrlote!=null &&
              this.nrlote.equals(other.getNrlote()))) &&
            this.qtdreprovada == other.getQtdreprovada();
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
        if (getCdrefugo() != null) {
            _hashCode += getCdrefugo().hashCode();
        }
        if (getNrlote() != null) {
            _hashCode += getNrlote().hashCode();
        }
        _hashCode += new Double(getQtdreprovada()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IjqldinsploterepId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijqldinsploterepId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdrefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdrefugo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrlote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrlote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdreprovada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdreprovada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
