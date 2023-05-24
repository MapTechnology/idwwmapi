/**
 * Ijtbtipofiltro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbtipofiltro  implements java.io.Serializable {
    private java.lang.String cdinterno;

    private java.lang.String cdtipofiltro;

    private java.lang.String dstipofiltrocomp;

    private java.lang.String dstipofiltrored;

    private idw.idwws.Ijfiltrocont[] ijfiltroconts;

    private idw.idwws.Ijfiltroitensmen[] ijfiltroitensmens;

    private idw.idwws.Ijitensfiltro[] ijitensfiltros;

    private idw.idwws.Ijlinguas ijlinguas;

    private java.lang.String indtipofiltro;

    private java.lang.String nometabela;

    public Ijtbtipofiltro() {
    }

    public Ijtbtipofiltro(
           java.lang.String cdinterno,
           java.lang.String cdtipofiltro,
           java.lang.String dstipofiltrocomp,
           java.lang.String dstipofiltrored,
           idw.idwws.Ijfiltrocont[] ijfiltroconts,
           idw.idwws.Ijfiltroitensmen[] ijfiltroitensmens,
           idw.idwws.Ijitensfiltro[] ijitensfiltros,
           idw.idwws.Ijlinguas ijlinguas,
           java.lang.String indtipofiltro,
           java.lang.String nometabela) {
           this.cdinterno = cdinterno;
           this.cdtipofiltro = cdtipofiltro;
           this.dstipofiltrocomp = dstipofiltrocomp;
           this.dstipofiltrored = dstipofiltrored;
           this.ijfiltroconts = ijfiltroconts;
           this.ijfiltroitensmens = ijfiltroitensmens;
           this.ijitensfiltros = ijitensfiltros;
           this.ijlinguas = ijlinguas;
           this.indtipofiltro = indtipofiltro;
           this.nometabela = nometabela;
    }


    /**
     * Gets the cdinterno value for this Ijtbtipofiltro.
     * 
     * @return cdinterno
     */
    public java.lang.String getCdinterno() {
        return cdinterno;
    }


    /**
     * Sets the cdinterno value for this Ijtbtipofiltro.
     * 
     * @param cdinterno
     */
    public void setCdinterno(java.lang.String cdinterno) {
        this.cdinterno = cdinterno;
    }


    /**
     * Gets the cdtipofiltro value for this Ijtbtipofiltro.
     * 
     * @return cdtipofiltro
     */
    public java.lang.String getCdtipofiltro() {
        return cdtipofiltro;
    }


    /**
     * Sets the cdtipofiltro value for this Ijtbtipofiltro.
     * 
     * @param cdtipofiltro
     */
    public void setCdtipofiltro(java.lang.String cdtipofiltro) {
        this.cdtipofiltro = cdtipofiltro;
    }


    /**
     * Gets the dstipofiltrocomp value for this Ijtbtipofiltro.
     * 
     * @return dstipofiltrocomp
     */
    public java.lang.String getDstipofiltrocomp() {
        return dstipofiltrocomp;
    }


    /**
     * Sets the dstipofiltrocomp value for this Ijtbtipofiltro.
     * 
     * @param dstipofiltrocomp
     */
    public void setDstipofiltrocomp(java.lang.String dstipofiltrocomp) {
        this.dstipofiltrocomp = dstipofiltrocomp;
    }


    /**
     * Gets the dstipofiltrored value for this Ijtbtipofiltro.
     * 
     * @return dstipofiltrored
     */
    public java.lang.String getDstipofiltrored() {
        return dstipofiltrored;
    }


    /**
     * Sets the dstipofiltrored value for this Ijtbtipofiltro.
     * 
     * @param dstipofiltrored
     */
    public void setDstipofiltrored(java.lang.String dstipofiltrored) {
        this.dstipofiltrored = dstipofiltrored;
    }


    /**
     * Gets the ijfiltroconts value for this Ijtbtipofiltro.
     * 
     * @return ijfiltroconts
     */
    public idw.idwws.Ijfiltrocont[] getIjfiltroconts() {
        return ijfiltroconts;
    }


    /**
     * Sets the ijfiltroconts value for this Ijtbtipofiltro.
     * 
     * @param ijfiltroconts
     */
    public void setIjfiltroconts(idw.idwws.Ijfiltrocont[] ijfiltroconts) {
        this.ijfiltroconts = ijfiltroconts;
    }

    public idw.idwws.Ijfiltrocont getIjfiltroconts(int i) {
        return this.ijfiltroconts[i];
    }

    public void setIjfiltroconts(int i, idw.idwws.Ijfiltrocont _value) {
        this.ijfiltroconts[i] = _value;
    }


    /**
     * Gets the ijfiltroitensmens value for this Ijtbtipofiltro.
     * 
     * @return ijfiltroitensmens
     */
    public idw.idwws.Ijfiltroitensmen[] getIjfiltroitensmens() {
        return ijfiltroitensmens;
    }


    /**
     * Sets the ijfiltroitensmens value for this Ijtbtipofiltro.
     * 
     * @param ijfiltroitensmens
     */
    public void setIjfiltroitensmens(idw.idwws.Ijfiltroitensmen[] ijfiltroitensmens) {
        this.ijfiltroitensmens = ijfiltroitensmens;
    }

    public idw.idwws.Ijfiltroitensmen getIjfiltroitensmens(int i) {
        return this.ijfiltroitensmens[i];
    }

    public void setIjfiltroitensmens(int i, idw.idwws.Ijfiltroitensmen _value) {
        this.ijfiltroitensmens[i] = _value;
    }


    /**
     * Gets the ijitensfiltros value for this Ijtbtipofiltro.
     * 
     * @return ijitensfiltros
     */
    public idw.idwws.Ijitensfiltro[] getIjitensfiltros() {
        return ijitensfiltros;
    }


    /**
     * Sets the ijitensfiltros value for this Ijtbtipofiltro.
     * 
     * @param ijitensfiltros
     */
    public void setIjitensfiltros(idw.idwws.Ijitensfiltro[] ijitensfiltros) {
        this.ijitensfiltros = ijitensfiltros;
    }

    public idw.idwws.Ijitensfiltro getIjitensfiltros(int i) {
        return this.ijitensfiltros[i];
    }

    public void setIjitensfiltros(int i, idw.idwws.Ijitensfiltro _value) {
        this.ijitensfiltros[i] = _value;
    }


    /**
     * Gets the ijlinguas value for this Ijtbtipofiltro.
     * 
     * @return ijlinguas
     */
    public idw.idwws.Ijlinguas getIjlinguas() {
        return ijlinguas;
    }


    /**
     * Sets the ijlinguas value for this Ijtbtipofiltro.
     * 
     * @param ijlinguas
     */
    public void setIjlinguas(idw.idwws.Ijlinguas ijlinguas) {
        this.ijlinguas = ijlinguas;
    }


    /**
     * Gets the indtipofiltro value for this Ijtbtipofiltro.
     * 
     * @return indtipofiltro
     */
    public java.lang.String getIndtipofiltro() {
        return indtipofiltro;
    }


    /**
     * Sets the indtipofiltro value for this Ijtbtipofiltro.
     * 
     * @param indtipofiltro
     */
    public void setIndtipofiltro(java.lang.String indtipofiltro) {
        this.indtipofiltro = indtipofiltro;
    }


    /**
     * Gets the nometabela value for this Ijtbtipofiltro.
     * 
     * @return nometabela
     */
    public java.lang.String getNometabela() {
        return nometabela;
    }


    /**
     * Sets the nometabela value for this Ijtbtipofiltro.
     * 
     * @param nometabela
     */
    public void setNometabela(java.lang.String nometabela) {
        this.nometabela = nometabela;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbtipofiltro)) return false;
        Ijtbtipofiltro other = (Ijtbtipofiltro) obj;
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
            ((this.cdtipofiltro==null && other.getCdtipofiltro()==null) || 
             (this.cdtipofiltro!=null &&
              this.cdtipofiltro.equals(other.getCdtipofiltro()))) &&
            ((this.dstipofiltrocomp==null && other.getDstipofiltrocomp()==null) || 
             (this.dstipofiltrocomp!=null &&
              this.dstipofiltrocomp.equals(other.getDstipofiltrocomp()))) &&
            ((this.dstipofiltrored==null && other.getDstipofiltrored()==null) || 
             (this.dstipofiltrored!=null &&
              this.dstipofiltrored.equals(other.getDstipofiltrored()))) &&
            ((this.ijfiltroconts==null && other.getIjfiltroconts()==null) || 
             (this.ijfiltroconts!=null &&
              java.util.Arrays.equals(this.ijfiltroconts, other.getIjfiltroconts()))) &&
            ((this.ijfiltroitensmens==null && other.getIjfiltroitensmens()==null) || 
             (this.ijfiltroitensmens!=null &&
              java.util.Arrays.equals(this.ijfiltroitensmens, other.getIjfiltroitensmens()))) &&
            ((this.ijitensfiltros==null && other.getIjitensfiltros()==null) || 
             (this.ijitensfiltros!=null &&
              java.util.Arrays.equals(this.ijitensfiltros, other.getIjitensfiltros()))) &&
            ((this.ijlinguas==null && other.getIjlinguas()==null) || 
             (this.ijlinguas!=null &&
              this.ijlinguas.equals(other.getIjlinguas()))) &&
            ((this.indtipofiltro==null && other.getIndtipofiltro()==null) || 
             (this.indtipofiltro!=null &&
              this.indtipofiltro.equals(other.getIndtipofiltro()))) &&
            ((this.nometabela==null && other.getNometabela()==null) || 
             (this.nometabela!=null &&
              this.nometabela.equals(other.getNometabela())));
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
        if (getCdtipofiltro() != null) {
            _hashCode += getCdtipofiltro().hashCode();
        }
        if (getDstipofiltrocomp() != null) {
            _hashCode += getDstipofiltrocomp().hashCode();
        }
        if (getDstipofiltrored() != null) {
            _hashCode += getDstipofiltrored().hashCode();
        }
        if (getIjfiltroconts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjfiltroconts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjfiltroconts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjfiltroitensmens() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjfiltroitensmens());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjfiltroitensmens(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjitensfiltros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjitensfiltros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjitensfiltros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjlinguas() != null) {
            _hashCode += getIjlinguas().hashCode();
        }
        if (getIndtipofiltro() != null) {
            _hashCode += getIndtipofiltro().hashCode();
        }
        if (getNometabela() != null) {
            _hashCode += getNometabela().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbtipofiltro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtipofiltro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinterno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinterno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtipofiltro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtipofiltro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dstipofiltrocomp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dstipofiltrocomp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dstipofiltrored");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dstipofiltrored"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijfiltroconts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijfiltroconts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfiltrocont"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijfiltroitensmens");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijfiltroitensmens"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfiltroitensmen"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijitensfiltros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijitensfiltros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijitensfiltro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijlinguas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijlinguas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlinguas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indtipofiltro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indtipofiltro"));
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
