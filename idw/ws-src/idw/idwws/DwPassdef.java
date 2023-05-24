/**
 * DwPassdef.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwPassdef  extends idw.idwws.DwPassdefTemplate  implements java.io.Serializable {
    private idw.idwws.DwPassagem dwPassagem;

    private idw.idwws.DwPasscau dwPasscau;

    private idw.idwws.DwTDefeito dwTDefeito;

    private long idPassdef;

    public DwPassdef() {
    }

    public DwPassdef(
           idw.idwws.DwPassagem dwPassagem,
           idw.idwws.DwPasscau dwPasscau,
           idw.idwws.DwTDefeito dwTDefeito,
           long idPassdef) {
        this.dwPassagem = dwPassagem;
        this.dwPasscau = dwPasscau;
        this.dwTDefeito = dwTDefeito;
        this.idPassdef = idPassdef;
    }


    /**
     * Gets the dwPassagem value for this DwPassdef.
     * 
     * @return dwPassagem
     */
    public idw.idwws.DwPassagem getDwPassagem() {
        return dwPassagem;
    }


    /**
     * Sets the dwPassagem value for this DwPassdef.
     * 
     * @param dwPassagem
     */
    public void setDwPassagem(idw.idwws.DwPassagem dwPassagem) {
        this.dwPassagem = dwPassagem;
    }


    /**
     * Gets the dwPasscau value for this DwPassdef.
     * 
     * @return dwPasscau
     */
    public idw.idwws.DwPasscau getDwPasscau() {
        return dwPasscau;
    }


    /**
     * Sets the dwPasscau value for this DwPassdef.
     * 
     * @param dwPasscau
     */
    public void setDwPasscau(idw.idwws.DwPasscau dwPasscau) {
        this.dwPasscau = dwPasscau;
    }


    /**
     * Gets the dwTDefeito value for this DwPassdef.
     * 
     * @return dwTDefeito
     */
    public idw.idwws.DwTDefeito getDwTDefeito() {
        return dwTDefeito;
    }


    /**
     * Sets the dwTDefeito value for this DwPassdef.
     * 
     * @param dwTDefeito
     */
    public void setDwTDefeito(idw.idwws.DwTDefeito dwTDefeito) {
        this.dwTDefeito = dwTDefeito;
    }


    /**
     * Gets the idPassdef value for this DwPassdef.
     * 
     * @return idPassdef
     */
    public long getIdPassdef() {
        return idPassdef;
    }


    /**
     * Sets the idPassdef value for this DwPassdef.
     * 
     * @param idPassdef
     */
    public void setIdPassdef(long idPassdef) {
        this.idPassdef = idPassdef;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwPassdef)) return false;
        DwPassdef other = (DwPassdef) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwPassagem==null && other.getDwPassagem()==null) || 
             (this.dwPassagem!=null &&
              this.dwPassagem.equals(other.getDwPassagem()))) &&
            ((this.dwPasscau==null && other.getDwPasscau()==null) || 
             (this.dwPasscau!=null &&
              this.dwPasscau.equals(other.getDwPasscau()))) &&
            ((this.dwTDefeito==null && other.getDwTDefeito()==null) || 
             (this.dwTDefeito!=null &&
              this.dwTDefeito.equals(other.getDwTDefeito()))) &&
            this.idPassdef == other.getIdPassdef();
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
        if (getDwPassagem() != null) {
            _hashCode += getDwPassagem().hashCode();
        }
        if (getDwPasscau() != null) {
            _hashCode += getDwPasscau().hashCode();
        }
        if (getDwTDefeito() != null) {
            _hashCode += getDwTDefeito().hashCode();
        }
        _hashCode += new Long(getIdPassdef()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwPassdef.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPassdef"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPassagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPassagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPassagem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPasscau");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPasscau"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPasscau"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTDefeito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTDefeito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTDefeito"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPassdef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPassdef"));
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
