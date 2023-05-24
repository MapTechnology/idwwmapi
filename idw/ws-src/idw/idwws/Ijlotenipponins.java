/**
 * Ijlotenipponins.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijlotenipponins  implements java.io.Serializable {
    private java.math.BigDecimal ativo;

    private idw.idwws.Ijocorreploteins[] ijocorreploteinses;

    private idw.idwws.Ijtbmprima ijtbmprima;

    private java.lang.String nrlote;

    private double qtdinsumo;

    public Ijlotenipponins() {
    }

    public Ijlotenipponins(
           java.math.BigDecimal ativo,
           idw.idwws.Ijocorreploteins[] ijocorreploteinses,
           idw.idwws.Ijtbmprima ijtbmprima,
           java.lang.String nrlote,
           double qtdinsumo) {
           this.ativo = ativo;
           this.ijocorreploteinses = ijocorreploteinses;
           this.ijtbmprima = ijtbmprima;
           this.nrlote = nrlote;
           this.qtdinsumo = qtdinsumo;
    }


    /**
     * Gets the ativo value for this Ijlotenipponins.
     * 
     * @return ativo
     */
    public java.math.BigDecimal getAtivo() {
        return ativo;
    }


    /**
     * Sets the ativo value for this Ijlotenipponins.
     * 
     * @param ativo
     */
    public void setAtivo(java.math.BigDecimal ativo) {
        this.ativo = ativo;
    }


    /**
     * Gets the ijocorreploteinses value for this Ijlotenipponins.
     * 
     * @return ijocorreploteinses
     */
    public idw.idwws.Ijocorreploteins[] getIjocorreploteinses() {
        return ijocorreploteinses;
    }


    /**
     * Sets the ijocorreploteinses value for this Ijlotenipponins.
     * 
     * @param ijocorreploteinses
     */
    public void setIjocorreploteinses(idw.idwws.Ijocorreploteins[] ijocorreploteinses) {
        this.ijocorreploteinses = ijocorreploteinses;
    }

    public idw.idwws.Ijocorreploteins getIjocorreploteinses(int i) {
        return this.ijocorreploteinses[i];
    }

    public void setIjocorreploteinses(int i, idw.idwws.Ijocorreploteins _value) {
        this.ijocorreploteinses[i] = _value;
    }


    /**
     * Gets the ijtbmprima value for this Ijlotenipponins.
     * 
     * @return ijtbmprima
     */
    public idw.idwws.Ijtbmprima getIjtbmprima() {
        return ijtbmprima;
    }


    /**
     * Sets the ijtbmprima value for this Ijlotenipponins.
     * 
     * @param ijtbmprima
     */
    public void setIjtbmprima(idw.idwws.Ijtbmprima ijtbmprima) {
        this.ijtbmprima = ijtbmprima;
    }


    /**
     * Gets the nrlote value for this Ijlotenipponins.
     * 
     * @return nrlote
     */
    public java.lang.String getNrlote() {
        return nrlote;
    }


    /**
     * Sets the nrlote value for this Ijlotenipponins.
     * 
     * @param nrlote
     */
    public void setNrlote(java.lang.String nrlote) {
        this.nrlote = nrlote;
    }


    /**
     * Gets the qtdinsumo value for this Ijlotenipponins.
     * 
     * @return qtdinsumo
     */
    public double getQtdinsumo() {
        return qtdinsumo;
    }


    /**
     * Sets the qtdinsumo value for this Ijlotenipponins.
     * 
     * @param qtdinsumo
     */
    public void setQtdinsumo(double qtdinsumo) {
        this.qtdinsumo = qtdinsumo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijlotenipponins)) return false;
        Ijlotenipponins other = (Ijlotenipponins) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ativo==null && other.getAtivo()==null) || 
             (this.ativo!=null &&
              this.ativo.equals(other.getAtivo()))) &&
            ((this.ijocorreploteinses==null && other.getIjocorreploteinses()==null) || 
             (this.ijocorreploteinses!=null &&
              java.util.Arrays.equals(this.ijocorreploteinses, other.getIjocorreploteinses()))) &&
            ((this.ijtbmprima==null && other.getIjtbmprima()==null) || 
             (this.ijtbmprima!=null &&
              this.ijtbmprima.equals(other.getIjtbmprima()))) &&
            ((this.nrlote==null && other.getNrlote()==null) || 
             (this.nrlote!=null &&
              this.nrlote.equals(other.getNrlote()))) &&
            this.qtdinsumo == other.getQtdinsumo();
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
        if (getAtivo() != null) {
            _hashCode += getAtivo().hashCode();
        }
        if (getIjocorreploteinses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjocorreploteinses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjocorreploteinses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbmprima() != null) {
            _hashCode += getIjtbmprima().hashCode();
        }
        if (getNrlote() != null) {
            _hashCode += getNrlote().hashCode();
        }
        _hashCode += new Double(getQtdinsumo()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijlotenipponins.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlotenipponins"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijocorreploteinses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijocorreploteinses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijocorreploteins"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmprima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmprima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmprima"));
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
        elemField.setFieldName("qtdinsumo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdinsumo"));
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
