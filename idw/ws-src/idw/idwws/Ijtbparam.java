/**
 * Ijtbparam.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbparam  implements java.io.Serializable {
    private java.lang.String cdinterno;

    private java.lang.String cdparam;

    private idw.idwws.Ijlinguas ijlinguas;

    private idw.idwws.Ijparaminf[] ijparaminfs;

    private idw.idwws.Ijparamitensarq[] ijparamitensarqs;

    private java.lang.String nomeparam;

    private java.lang.String nometabela;

    private java.lang.String tipoparam;

    public Ijtbparam() {
    }

    public Ijtbparam(
           java.lang.String cdinterno,
           java.lang.String cdparam,
           idw.idwws.Ijlinguas ijlinguas,
           idw.idwws.Ijparaminf[] ijparaminfs,
           idw.idwws.Ijparamitensarq[] ijparamitensarqs,
           java.lang.String nomeparam,
           java.lang.String nometabela,
           java.lang.String tipoparam) {
           this.cdinterno = cdinterno;
           this.cdparam = cdparam;
           this.ijlinguas = ijlinguas;
           this.ijparaminfs = ijparaminfs;
           this.ijparamitensarqs = ijparamitensarqs;
           this.nomeparam = nomeparam;
           this.nometabela = nometabela;
           this.tipoparam = tipoparam;
    }


    /**
     * Gets the cdinterno value for this Ijtbparam.
     * 
     * @return cdinterno
     */
    public java.lang.String getCdinterno() {
        return cdinterno;
    }


    /**
     * Sets the cdinterno value for this Ijtbparam.
     * 
     * @param cdinterno
     */
    public void setCdinterno(java.lang.String cdinterno) {
        this.cdinterno = cdinterno;
    }


    /**
     * Gets the cdparam value for this Ijtbparam.
     * 
     * @return cdparam
     */
    public java.lang.String getCdparam() {
        return cdparam;
    }


    /**
     * Sets the cdparam value for this Ijtbparam.
     * 
     * @param cdparam
     */
    public void setCdparam(java.lang.String cdparam) {
        this.cdparam = cdparam;
    }


    /**
     * Gets the ijlinguas value for this Ijtbparam.
     * 
     * @return ijlinguas
     */
    public idw.idwws.Ijlinguas getIjlinguas() {
        return ijlinguas;
    }


    /**
     * Sets the ijlinguas value for this Ijtbparam.
     * 
     * @param ijlinguas
     */
    public void setIjlinguas(idw.idwws.Ijlinguas ijlinguas) {
        this.ijlinguas = ijlinguas;
    }


    /**
     * Gets the ijparaminfs value for this Ijtbparam.
     * 
     * @return ijparaminfs
     */
    public idw.idwws.Ijparaminf[] getIjparaminfs() {
        return ijparaminfs;
    }


    /**
     * Sets the ijparaminfs value for this Ijtbparam.
     * 
     * @param ijparaminfs
     */
    public void setIjparaminfs(idw.idwws.Ijparaminf[] ijparaminfs) {
        this.ijparaminfs = ijparaminfs;
    }

    public idw.idwws.Ijparaminf getIjparaminfs(int i) {
        return this.ijparaminfs[i];
    }

    public void setIjparaminfs(int i, idw.idwws.Ijparaminf _value) {
        this.ijparaminfs[i] = _value;
    }


    /**
     * Gets the ijparamitensarqs value for this Ijtbparam.
     * 
     * @return ijparamitensarqs
     */
    public idw.idwws.Ijparamitensarq[] getIjparamitensarqs() {
        return ijparamitensarqs;
    }


    /**
     * Sets the ijparamitensarqs value for this Ijtbparam.
     * 
     * @param ijparamitensarqs
     */
    public void setIjparamitensarqs(idw.idwws.Ijparamitensarq[] ijparamitensarqs) {
        this.ijparamitensarqs = ijparamitensarqs;
    }

    public idw.idwws.Ijparamitensarq getIjparamitensarqs(int i) {
        return this.ijparamitensarqs[i];
    }

    public void setIjparamitensarqs(int i, idw.idwws.Ijparamitensarq _value) {
        this.ijparamitensarqs[i] = _value;
    }


    /**
     * Gets the nomeparam value for this Ijtbparam.
     * 
     * @return nomeparam
     */
    public java.lang.String getNomeparam() {
        return nomeparam;
    }


    /**
     * Sets the nomeparam value for this Ijtbparam.
     * 
     * @param nomeparam
     */
    public void setNomeparam(java.lang.String nomeparam) {
        this.nomeparam = nomeparam;
    }


    /**
     * Gets the nometabela value for this Ijtbparam.
     * 
     * @return nometabela
     */
    public java.lang.String getNometabela() {
        return nometabela;
    }


    /**
     * Sets the nometabela value for this Ijtbparam.
     * 
     * @param nometabela
     */
    public void setNometabela(java.lang.String nometabela) {
        this.nometabela = nometabela;
    }


    /**
     * Gets the tipoparam value for this Ijtbparam.
     * 
     * @return tipoparam
     */
    public java.lang.String getTipoparam() {
        return tipoparam;
    }


    /**
     * Sets the tipoparam value for this Ijtbparam.
     * 
     * @param tipoparam
     */
    public void setTipoparam(java.lang.String tipoparam) {
        this.tipoparam = tipoparam;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbparam)) return false;
        Ijtbparam other = (Ijtbparam) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdinterno==null && other.getCdinterno()==null) || 
             (this.cdinterno!=null &&
              this.cdinterno.equals(other.getCdinterno()))) &&
            ((this.cdparam==null && other.getCdparam()==null) || 
             (this.cdparam!=null &&
              this.cdparam.equals(other.getCdparam()))) &&
            ((this.ijlinguas==null && other.getIjlinguas()==null) || 
             (this.ijlinguas!=null &&
              this.ijlinguas.equals(other.getIjlinguas()))) &&
            ((this.ijparaminfs==null && other.getIjparaminfs()==null) || 
             (this.ijparaminfs!=null &&
              java.util.Arrays.equals(this.ijparaminfs, other.getIjparaminfs()))) &&
            ((this.ijparamitensarqs==null && other.getIjparamitensarqs()==null) || 
             (this.ijparamitensarqs!=null &&
              java.util.Arrays.equals(this.ijparamitensarqs, other.getIjparamitensarqs()))) &&
            ((this.nomeparam==null && other.getNomeparam()==null) || 
             (this.nomeparam!=null &&
              this.nomeparam.equals(other.getNomeparam()))) &&
            ((this.nometabela==null && other.getNometabela()==null) || 
             (this.nometabela!=null &&
              this.nometabela.equals(other.getNometabela()))) &&
            ((this.tipoparam==null && other.getTipoparam()==null) || 
             (this.tipoparam!=null &&
              this.tipoparam.equals(other.getTipoparam())));
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
        if (getCdinterno() != null) {
            _hashCode += getCdinterno().hashCode();
        }
        if (getCdparam() != null) {
            _hashCode += getCdparam().hashCode();
        }
        if (getIjlinguas() != null) {
            _hashCode += getIjlinguas().hashCode();
        }
        if (getIjparaminfs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjparaminfs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjparaminfs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjparamitensarqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjparamitensarqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjparamitensarqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNomeparam() != null) {
            _hashCode += getNomeparam().hashCode();
        }
        if (getNometabela() != null) {
            _hashCode += getNometabela().hashCode();
        }
        if (getTipoparam() != null) {
            _hashCode += getTipoparam().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbparam.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbparam"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinterno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinterno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdparam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdparam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijlinguas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijlinguas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlinguas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijparaminfs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijparaminfs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijparaminf"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijparamitensarqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijparamitensarqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijparamitensarq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeparam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nomeparam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nometabela");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nometabela"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoparam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoparam"));
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
