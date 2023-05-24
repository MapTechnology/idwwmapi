/**
 * Ijamstraltcgq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijamstraltcgq  implements java.io.Serializable {
    private double amplitudevllidos;

    private org.apache.axis.types.UnsignedShort compoemedia;

    private double idctrlaltcgqamstr;

    private idw.idwws.Ijamostragem ijamostragem;

    private idw.idwws.Ijamstrdetaltcgq[] ijamstrdetaltcgqs;

    private idw.idwws.Ijamstrdetaltmedia[] ijamstrdetaltmediasForIdctrlaltcgammedia;

    private idw.idwws.Ijamstrdetaltmedia[] ijamstrdetaltmediasForIdctrlaltcgqamstr;

    private idw.idwws.Ijctrlcgqalt ijctrlcgqalt;

    private double mediavllidos;

    private org.apache.axis.types.UnsignedShort resultado;

    public Ijamstraltcgq() {
    }

    public Ijamstraltcgq(
           double amplitudevllidos,
           org.apache.axis.types.UnsignedShort compoemedia,
           double idctrlaltcgqamstr,
           idw.idwws.Ijamostragem ijamostragem,
           idw.idwws.Ijamstrdetaltcgq[] ijamstrdetaltcgqs,
           idw.idwws.Ijamstrdetaltmedia[] ijamstrdetaltmediasForIdctrlaltcgammedia,
           idw.idwws.Ijamstrdetaltmedia[] ijamstrdetaltmediasForIdctrlaltcgqamstr,
           idw.idwws.Ijctrlcgqalt ijctrlcgqalt,
           double mediavllidos,
           org.apache.axis.types.UnsignedShort resultado) {
           this.amplitudevllidos = amplitudevllidos;
           this.compoemedia = compoemedia;
           this.idctrlaltcgqamstr = idctrlaltcgqamstr;
           this.ijamostragem = ijamostragem;
           this.ijamstrdetaltcgqs = ijamstrdetaltcgqs;
           this.ijamstrdetaltmediasForIdctrlaltcgammedia = ijamstrdetaltmediasForIdctrlaltcgammedia;
           this.ijamstrdetaltmediasForIdctrlaltcgqamstr = ijamstrdetaltmediasForIdctrlaltcgqamstr;
           this.ijctrlcgqalt = ijctrlcgqalt;
           this.mediavllidos = mediavllidos;
           this.resultado = resultado;
    }


    /**
     * Gets the amplitudevllidos value for this Ijamstraltcgq.
     * 
     * @return amplitudevllidos
     */
    public double getAmplitudevllidos() {
        return amplitudevllidos;
    }


    /**
     * Sets the amplitudevllidos value for this Ijamstraltcgq.
     * 
     * @param amplitudevllidos
     */
    public void setAmplitudevllidos(double amplitudevllidos) {
        this.amplitudevllidos = amplitudevllidos;
    }


    /**
     * Gets the compoemedia value for this Ijamstraltcgq.
     * 
     * @return compoemedia
     */
    public org.apache.axis.types.UnsignedShort getCompoemedia() {
        return compoemedia;
    }


    /**
     * Sets the compoemedia value for this Ijamstraltcgq.
     * 
     * @param compoemedia
     */
    public void setCompoemedia(org.apache.axis.types.UnsignedShort compoemedia) {
        this.compoemedia = compoemedia;
    }


    /**
     * Gets the idctrlaltcgqamstr value for this Ijamstraltcgq.
     * 
     * @return idctrlaltcgqamstr
     */
    public double getIdctrlaltcgqamstr() {
        return idctrlaltcgqamstr;
    }


    /**
     * Sets the idctrlaltcgqamstr value for this Ijamstraltcgq.
     * 
     * @param idctrlaltcgqamstr
     */
    public void setIdctrlaltcgqamstr(double idctrlaltcgqamstr) {
        this.idctrlaltcgqamstr = idctrlaltcgqamstr;
    }


    /**
     * Gets the ijamostragem value for this Ijamstraltcgq.
     * 
     * @return ijamostragem
     */
    public idw.idwws.Ijamostragem getIjamostragem() {
        return ijamostragem;
    }


    /**
     * Sets the ijamostragem value for this Ijamstraltcgq.
     * 
     * @param ijamostragem
     */
    public void setIjamostragem(idw.idwws.Ijamostragem ijamostragem) {
        this.ijamostragem = ijamostragem;
    }


    /**
     * Gets the ijamstrdetaltcgqs value for this Ijamstraltcgq.
     * 
     * @return ijamstrdetaltcgqs
     */
    public idw.idwws.Ijamstrdetaltcgq[] getIjamstrdetaltcgqs() {
        return ijamstrdetaltcgqs;
    }


    /**
     * Sets the ijamstrdetaltcgqs value for this Ijamstraltcgq.
     * 
     * @param ijamstrdetaltcgqs
     */
    public void setIjamstrdetaltcgqs(idw.idwws.Ijamstrdetaltcgq[] ijamstrdetaltcgqs) {
        this.ijamstrdetaltcgqs = ijamstrdetaltcgqs;
    }

    public idw.idwws.Ijamstrdetaltcgq getIjamstrdetaltcgqs(int i) {
        return this.ijamstrdetaltcgqs[i];
    }

    public void setIjamstrdetaltcgqs(int i, idw.idwws.Ijamstrdetaltcgq _value) {
        this.ijamstrdetaltcgqs[i] = _value;
    }


    /**
     * Gets the ijamstrdetaltmediasForIdctrlaltcgammedia value for this Ijamstraltcgq.
     * 
     * @return ijamstrdetaltmediasForIdctrlaltcgammedia
     */
    public idw.idwws.Ijamstrdetaltmedia[] getIjamstrdetaltmediasForIdctrlaltcgammedia() {
        return ijamstrdetaltmediasForIdctrlaltcgammedia;
    }


    /**
     * Sets the ijamstrdetaltmediasForIdctrlaltcgammedia value for this Ijamstraltcgq.
     * 
     * @param ijamstrdetaltmediasForIdctrlaltcgammedia
     */
    public void setIjamstrdetaltmediasForIdctrlaltcgammedia(idw.idwws.Ijamstrdetaltmedia[] ijamstrdetaltmediasForIdctrlaltcgammedia) {
        this.ijamstrdetaltmediasForIdctrlaltcgammedia = ijamstrdetaltmediasForIdctrlaltcgammedia;
    }

    public idw.idwws.Ijamstrdetaltmedia getIjamstrdetaltmediasForIdctrlaltcgammedia(int i) {
        return this.ijamstrdetaltmediasForIdctrlaltcgammedia[i];
    }

    public void setIjamstrdetaltmediasForIdctrlaltcgammedia(int i, idw.idwws.Ijamstrdetaltmedia _value) {
        this.ijamstrdetaltmediasForIdctrlaltcgammedia[i] = _value;
    }


    /**
     * Gets the ijamstrdetaltmediasForIdctrlaltcgqamstr value for this Ijamstraltcgq.
     * 
     * @return ijamstrdetaltmediasForIdctrlaltcgqamstr
     */
    public idw.idwws.Ijamstrdetaltmedia[] getIjamstrdetaltmediasForIdctrlaltcgqamstr() {
        return ijamstrdetaltmediasForIdctrlaltcgqamstr;
    }


    /**
     * Sets the ijamstrdetaltmediasForIdctrlaltcgqamstr value for this Ijamstraltcgq.
     * 
     * @param ijamstrdetaltmediasForIdctrlaltcgqamstr
     */
    public void setIjamstrdetaltmediasForIdctrlaltcgqamstr(idw.idwws.Ijamstrdetaltmedia[] ijamstrdetaltmediasForIdctrlaltcgqamstr) {
        this.ijamstrdetaltmediasForIdctrlaltcgqamstr = ijamstrdetaltmediasForIdctrlaltcgqamstr;
    }

    public idw.idwws.Ijamstrdetaltmedia getIjamstrdetaltmediasForIdctrlaltcgqamstr(int i) {
        return this.ijamstrdetaltmediasForIdctrlaltcgqamstr[i];
    }

    public void setIjamstrdetaltmediasForIdctrlaltcgqamstr(int i, idw.idwws.Ijamstrdetaltmedia _value) {
        this.ijamstrdetaltmediasForIdctrlaltcgqamstr[i] = _value;
    }


    /**
     * Gets the ijctrlcgqalt value for this Ijamstraltcgq.
     * 
     * @return ijctrlcgqalt
     */
    public idw.idwws.Ijctrlcgqalt getIjctrlcgqalt() {
        return ijctrlcgqalt;
    }


    /**
     * Sets the ijctrlcgqalt value for this Ijamstraltcgq.
     * 
     * @param ijctrlcgqalt
     */
    public void setIjctrlcgqalt(idw.idwws.Ijctrlcgqalt ijctrlcgqalt) {
        this.ijctrlcgqalt = ijctrlcgqalt;
    }


    /**
     * Gets the mediavllidos value for this Ijamstraltcgq.
     * 
     * @return mediavllidos
     */
    public double getMediavllidos() {
        return mediavllidos;
    }


    /**
     * Sets the mediavllidos value for this Ijamstraltcgq.
     * 
     * @param mediavllidos
     */
    public void setMediavllidos(double mediavllidos) {
        this.mediavllidos = mediavllidos;
    }


    /**
     * Gets the resultado value for this Ijamstraltcgq.
     * 
     * @return resultado
     */
    public org.apache.axis.types.UnsignedShort getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this Ijamstraltcgq.
     * 
     * @param resultado
     */
    public void setResultado(org.apache.axis.types.UnsignedShort resultado) {
        this.resultado = resultado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijamstraltcgq)) return false;
        Ijamstraltcgq other = (Ijamstraltcgq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.amplitudevllidos == other.getAmplitudevllidos() &&
            ((this.compoemedia==null && other.getCompoemedia()==null) || 
             (this.compoemedia!=null &&
              this.compoemedia.equals(other.getCompoemedia()))) &&
            this.idctrlaltcgqamstr == other.getIdctrlaltcgqamstr() &&
            ((this.ijamostragem==null && other.getIjamostragem()==null) || 
             (this.ijamostragem!=null &&
              this.ijamostragem.equals(other.getIjamostragem()))) &&
            ((this.ijamstrdetaltcgqs==null && other.getIjamstrdetaltcgqs()==null) || 
             (this.ijamstrdetaltcgqs!=null &&
              java.util.Arrays.equals(this.ijamstrdetaltcgqs, other.getIjamstrdetaltcgqs()))) &&
            ((this.ijamstrdetaltmediasForIdctrlaltcgammedia==null && other.getIjamstrdetaltmediasForIdctrlaltcgammedia()==null) || 
             (this.ijamstrdetaltmediasForIdctrlaltcgammedia!=null &&
              java.util.Arrays.equals(this.ijamstrdetaltmediasForIdctrlaltcgammedia, other.getIjamstrdetaltmediasForIdctrlaltcgammedia()))) &&
            ((this.ijamstrdetaltmediasForIdctrlaltcgqamstr==null && other.getIjamstrdetaltmediasForIdctrlaltcgqamstr()==null) || 
             (this.ijamstrdetaltmediasForIdctrlaltcgqamstr!=null &&
              java.util.Arrays.equals(this.ijamstrdetaltmediasForIdctrlaltcgqamstr, other.getIjamstrdetaltmediasForIdctrlaltcgqamstr()))) &&
            ((this.ijctrlcgqalt==null && other.getIjctrlcgqalt()==null) || 
             (this.ijctrlcgqalt!=null &&
              this.ijctrlcgqalt.equals(other.getIjctrlcgqalt()))) &&
            this.mediavllidos == other.getMediavllidos() &&
            ((this.resultado==null && other.getResultado()==null) || 
             (this.resultado!=null &&
              this.resultado.equals(other.getResultado())));
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
        _hashCode += new Double(getAmplitudevllidos()).hashCode();
        if (getCompoemedia() != null) {
            _hashCode += getCompoemedia().hashCode();
        }
        _hashCode += new Double(getIdctrlaltcgqamstr()).hashCode();
        if (getIjamostragem() != null) {
            _hashCode += getIjamostragem().hashCode();
        }
        if (getIjamstrdetaltcgqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjamstrdetaltcgqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjamstrdetaltcgqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjamstrdetaltmediasForIdctrlaltcgammedia() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjamstrdetaltmediasForIdctrlaltcgammedia());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjamstrdetaltmediasForIdctrlaltcgammedia(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjamstrdetaltmediasForIdctrlaltcgqamstr() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjamstrdetaltmediasForIdctrlaltcgqamstr());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjamstrdetaltmediasForIdctrlaltcgqamstr(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjctrlcgqalt() != null) {
            _hashCode += getIjctrlcgqalt().hashCode();
        }
        _hashCode += new Double(getMediavllidos()).hashCode();
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijamstraltcgq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamstraltcgq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amplitudevllidos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amplitudevllidos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compoemedia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "compoemedia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idctrlaltcgqamstr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idctrlaltcgqamstr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijamostragem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijamostragem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamostragem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijamstrdetaltcgqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijamstrdetaltcgqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamstrdetaltcgq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijamstrdetaltmediasForIdctrlaltcgammedia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijamstrdetaltmediasForIdctrlaltcgammedia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamstrdetaltmedia"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijamstrdetaltmediasForIdctrlaltcgqamstr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijamstrdetaltmediasForIdctrlaltcgqamstr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamstrdetaltmedia"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrlcgqalt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrlcgqalt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlcgqalt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mediavllidos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mediavllidos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
