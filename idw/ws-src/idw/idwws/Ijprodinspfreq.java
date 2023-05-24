/**
 * Ijprodinspfreq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijprodinspfreq  implements java.io.Serializable {
    private java.lang.String cdproduto;

    private idw.idwws.Ijprodxfreq[] ijprodxfreqs;

    private idw.idwws.Ijregultinspqld1[] ijregultinspqld1S;

    private idw.idwws.Ijtbpro ijtbpro;

    private double qtdprodaleiniop;

    private double qtdprodaposprobqld;

    private double qtdrejgeracaoale;

    private double tamminlote;

    private java.math.BigDecimal tpfrequencia;

    public Ijprodinspfreq() {
    }

    public Ijprodinspfreq(
           java.lang.String cdproduto,
           idw.idwws.Ijprodxfreq[] ijprodxfreqs,
           idw.idwws.Ijregultinspqld1[] ijregultinspqld1S,
           idw.idwws.Ijtbpro ijtbpro,
           double qtdprodaleiniop,
           double qtdprodaposprobqld,
           double qtdrejgeracaoale,
           double tamminlote,
           java.math.BigDecimal tpfrequencia) {
           this.cdproduto = cdproduto;
           this.ijprodxfreqs = ijprodxfreqs;
           this.ijregultinspqld1S = ijregultinspqld1S;
           this.ijtbpro = ijtbpro;
           this.qtdprodaleiniop = qtdprodaleiniop;
           this.qtdprodaposprobqld = qtdprodaposprobqld;
           this.qtdrejgeracaoale = qtdrejgeracaoale;
           this.tamminlote = tamminlote;
           this.tpfrequencia = tpfrequencia;
    }


    /**
     * Gets the cdproduto value for this Ijprodinspfreq.
     * 
     * @return cdproduto
     */
    public java.lang.String getCdproduto() {
        return cdproduto;
    }


    /**
     * Sets the cdproduto value for this Ijprodinspfreq.
     * 
     * @param cdproduto
     */
    public void setCdproduto(java.lang.String cdproduto) {
        this.cdproduto = cdproduto;
    }


    /**
     * Gets the ijprodxfreqs value for this Ijprodinspfreq.
     * 
     * @return ijprodxfreqs
     */
    public idw.idwws.Ijprodxfreq[] getIjprodxfreqs() {
        return ijprodxfreqs;
    }


    /**
     * Sets the ijprodxfreqs value for this Ijprodinspfreq.
     * 
     * @param ijprodxfreqs
     */
    public void setIjprodxfreqs(idw.idwws.Ijprodxfreq[] ijprodxfreqs) {
        this.ijprodxfreqs = ijprodxfreqs;
    }

    public idw.idwws.Ijprodxfreq getIjprodxfreqs(int i) {
        return this.ijprodxfreqs[i];
    }

    public void setIjprodxfreqs(int i, idw.idwws.Ijprodxfreq _value) {
        this.ijprodxfreqs[i] = _value;
    }


    /**
     * Gets the ijregultinspqld1S value for this Ijprodinspfreq.
     * 
     * @return ijregultinspqld1S
     */
    public idw.idwws.Ijregultinspqld1[] getIjregultinspqld1S() {
        return ijregultinspqld1S;
    }


    /**
     * Sets the ijregultinspqld1S value for this Ijprodinspfreq.
     * 
     * @param ijregultinspqld1S
     */
    public void setIjregultinspqld1S(idw.idwws.Ijregultinspqld1[] ijregultinspqld1S) {
        this.ijregultinspqld1S = ijregultinspqld1S;
    }

    public idw.idwws.Ijregultinspqld1 getIjregultinspqld1S(int i) {
        return this.ijregultinspqld1S[i];
    }

    public void setIjregultinspqld1S(int i, idw.idwws.Ijregultinspqld1 _value) {
        this.ijregultinspqld1S[i] = _value;
    }


    /**
     * Gets the ijtbpro value for this Ijprodinspfreq.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijprodinspfreq.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the qtdprodaleiniop value for this Ijprodinspfreq.
     * 
     * @return qtdprodaleiniop
     */
    public double getQtdprodaleiniop() {
        return qtdprodaleiniop;
    }


    /**
     * Sets the qtdprodaleiniop value for this Ijprodinspfreq.
     * 
     * @param qtdprodaleiniop
     */
    public void setQtdprodaleiniop(double qtdprodaleiniop) {
        this.qtdprodaleiniop = qtdprodaleiniop;
    }


    /**
     * Gets the qtdprodaposprobqld value for this Ijprodinspfreq.
     * 
     * @return qtdprodaposprobqld
     */
    public double getQtdprodaposprobqld() {
        return qtdprodaposprobqld;
    }


    /**
     * Sets the qtdprodaposprobqld value for this Ijprodinspfreq.
     * 
     * @param qtdprodaposprobqld
     */
    public void setQtdprodaposprobqld(double qtdprodaposprobqld) {
        this.qtdprodaposprobqld = qtdprodaposprobqld;
    }


    /**
     * Gets the qtdrejgeracaoale value for this Ijprodinspfreq.
     * 
     * @return qtdrejgeracaoale
     */
    public double getQtdrejgeracaoale() {
        return qtdrejgeracaoale;
    }


    /**
     * Sets the qtdrejgeracaoale value for this Ijprodinspfreq.
     * 
     * @param qtdrejgeracaoale
     */
    public void setQtdrejgeracaoale(double qtdrejgeracaoale) {
        this.qtdrejgeracaoale = qtdrejgeracaoale;
    }


    /**
     * Gets the tamminlote value for this Ijprodinspfreq.
     * 
     * @return tamminlote
     */
    public double getTamminlote() {
        return tamminlote;
    }


    /**
     * Sets the tamminlote value for this Ijprodinspfreq.
     * 
     * @param tamminlote
     */
    public void setTamminlote(double tamminlote) {
        this.tamminlote = tamminlote;
    }


    /**
     * Gets the tpfrequencia value for this Ijprodinspfreq.
     * 
     * @return tpfrequencia
     */
    public java.math.BigDecimal getTpfrequencia() {
        return tpfrequencia;
    }


    /**
     * Sets the tpfrequencia value for this Ijprodinspfreq.
     * 
     * @param tpfrequencia
     */
    public void setTpfrequencia(java.math.BigDecimal tpfrequencia) {
        this.tpfrequencia = tpfrequencia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijprodinspfreq)) return false;
        Ijprodinspfreq other = (Ijprodinspfreq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdproduto==null && other.getCdproduto()==null) || 
             (this.cdproduto!=null &&
              this.cdproduto.equals(other.getCdproduto()))) &&
            ((this.ijprodxfreqs==null && other.getIjprodxfreqs()==null) || 
             (this.ijprodxfreqs!=null &&
              java.util.Arrays.equals(this.ijprodxfreqs, other.getIjprodxfreqs()))) &&
            ((this.ijregultinspqld1S==null && other.getIjregultinspqld1S()==null) || 
             (this.ijregultinspqld1S!=null &&
              java.util.Arrays.equals(this.ijregultinspqld1S, other.getIjregultinspqld1S()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            this.qtdprodaleiniop == other.getQtdprodaleiniop() &&
            this.qtdprodaposprobqld == other.getQtdprodaposprobqld() &&
            this.qtdrejgeracaoale == other.getQtdrejgeracaoale() &&
            this.tamminlote == other.getTamminlote() &&
            ((this.tpfrequencia==null && other.getTpfrequencia()==null) || 
             (this.tpfrequencia!=null &&
              this.tpfrequencia.equals(other.getTpfrequencia())));
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
        if (getCdproduto() != null) {
            _hashCode += getCdproduto().hashCode();
        }
        if (getIjprodxfreqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjprodxfreqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjprodxfreqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjregultinspqld1S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjregultinspqld1S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjregultinspqld1S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        _hashCode += new Double(getQtdprodaleiniop()).hashCode();
        _hashCode += new Double(getQtdprodaposprobqld()).hashCode();
        _hashCode += new Double(getQtdrejgeracaoale()).hashCode();
        _hashCode += new Double(getTamminlote()).hashCode();
        if (getTpfrequencia() != null) {
            _hashCode += getTpfrequencia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijprodinspfreq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprodinspfreq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijprodxfreqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijprodxfreqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprodxfreq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijregultinspqld1S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijregultinspqld1s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijregultinspqld1"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdprodaleiniop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdprodaleiniop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdprodaposprobqld");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdprodaposprobqld"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdrejgeracaoale");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdrejgeracaoale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tamminlote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tamminlote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpfrequencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpfrequencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
