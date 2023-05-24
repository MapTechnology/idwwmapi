/**
 * Ijtbcont.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbcont  implements java.io.Serializable {
    private java.lang.String cdcont;

    private java.lang.String cdinterno;

    private java.lang.String dscontcomp;

    private java.lang.String dscontred;

    private idw.idwws.Ijclassificcont[] ijclassificconts;

    private idw.idwws.Ijfiltrocont[] ijfiltroconts;

    private idw.idwws.Ijlinguas ijlinguas;

    private idw.idwws.Ijtbtipoger ijtbtipoger;

    private java.lang.String indcalculo;

    private java.lang.String unidcont;

    public Ijtbcont() {
    }

    public Ijtbcont(
           java.lang.String cdcont,
           java.lang.String cdinterno,
           java.lang.String dscontcomp,
           java.lang.String dscontred,
           idw.idwws.Ijclassificcont[] ijclassificconts,
           idw.idwws.Ijfiltrocont[] ijfiltroconts,
           idw.idwws.Ijlinguas ijlinguas,
           idw.idwws.Ijtbtipoger ijtbtipoger,
           java.lang.String indcalculo,
           java.lang.String unidcont) {
           this.cdcont = cdcont;
           this.cdinterno = cdinterno;
           this.dscontcomp = dscontcomp;
           this.dscontred = dscontred;
           this.ijclassificconts = ijclassificconts;
           this.ijfiltroconts = ijfiltroconts;
           this.ijlinguas = ijlinguas;
           this.ijtbtipoger = ijtbtipoger;
           this.indcalculo = indcalculo;
           this.unidcont = unidcont;
    }


    /**
     * Gets the cdcont value for this Ijtbcont.
     * 
     * @return cdcont
     */
    public java.lang.String getCdcont() {
        return cdcont;
    }


    /**
     * Sets the cdcont value for this Ijtbcont.
     * 
     * @param cdcont
     */
    public void setCdcont(java.lang.String cdcont) {
        this.cdcont = cdcont;
    }


    /**
     * Gets the cdinterno value for this Ijtbcont.
     * 
     * @return cdinterno
     */
    public java.lang.String getCdinterno() {
        return cdinterno;
    }


    /**
     * Sets the cdinterno value for this Ijtbcont.
     * 
     * @param cdinterno
     */
    public void setCdinterno(java.lang.String cdinterno) {
        this.cdinterno = cdinterno;
    }


    /**
     * Gets the dscontcomp value for this Ijtbcont.
     * 
     * @return dscontcomp
     */
    public java.lang.String getDscontcomp() {
        return dscontcomp;
    }


    /**
     * Sets the dscontcomp value for this Ijtbcont.
     * 
     * @param dscontcomp
     */
    public void setDscontcomp(java.lang.String dscontcomp) {
        this.dscontcomp = dscontcomp;
    }


    /**
     * Gets the dscontred value for this Ijtbcont.
     * 
     * @return dscontred
     */
    public java.lang.String getDscontred() {
        return dscontred;
    }


    /**
     * Sets the dscontred value for this Ijtbcont.
     * 
     * @param dscontred
     */
    public void setDscontred(java.lang.String dscontred) {
        this.dscontred = dscontred;
    }


    /**
     * Gets the ijclassificconts value for this Ijtbcont.
     * 
     * @return ijclassificconts
     */
    public idw.idwws.Ijclassificcont[] getIjclassificconts() {
        return ijclassificconts;
    }


    /**
     * Sets the ijclassificconts value for this Ijtbcont.
     * 
     * @param ijclassificconts
     */
    public void setIjclassificconts(idw.idwws.Ijclassificcont[] ijclassificconts) {
        this.ijclassificconts = ijclassificconts;
    }

    public idw.idwws.Ijclassificcont getIjclassificconts(int i) {
        return this.ijclassificconts[i];
    }

    public void setIjclassificconts(int i, idw.idwws.Ijclassificcont _value) {
        this.ijclassificconts[i] = _value;
    }


    /**
     * Gets the ijfiltroconts value for this Ijtbcont.
     * 
     * @return ijfiltroconts
     */
    public idw.idwws.Ijfiltrocont[] getIjfiltroconts() {
        return ijfiltroconts;
    }


    /**
     * Sets the ijfiltroconts value for this Ijtbcont.
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
     * Gets the ijlinguas value for this Ijtbcont.
     * 
     * @return ijlinguas
     */
    public idw.idwws.Ijlinguas getIjlinguas() {
        return ijlinguas;
    }


    /**
     * Sets the ijlinguas value for this Ijtbcont.
     * 
     * @param ijlinguas
     */
    public void setIjlinguas(idw.idwws.Ijlinguas ijlinguas) {
        this.ijlinguas = ijlinguas;
    }


    /**
     * Gets the ijtbtipoger value for this Ijtbcont.
     * 
     * @return ijtbtipoger
     */
    public idw.idwws.Ijtbtipoger getIjtbtipoger() {
        return ijtbtipoger;
    }


    /**
     * Sets the ijtbtipoger value for this Ijtbcont.
     * 
     * @param ijtbtipoger
     */
    public void setIjtbtipoger(idw.idwws.Ijtbtipoger ijtbtipoger) {
        this.ijtbtipoger = ijtbtipoger;
    }


    /**
     * Gets the indcalculo value for this Ijtbcont.
     * 
     * @return indcalculo
     */
    public java.lang.String getIndcalculo() {
        return indcalculo;
    }


    /**
     * Sets the indcalculo value for this Ijtbcont.
     * 
     * @param indcalculo
     */
    public void setIndcalculo(java.lang.String indcalculo) {
        this.indcalculo = indcalculo;
    }


    /**
     * Gets the unidcont value for this Ijtbcont.
     * 
     * @return unidcont
     */
    public java.lang.String getUnidcont() {
        return unidcont;
    }


    /**
     * Sets the unidcont value for this Ijtbcont.
     * 
     * @param unidcont
     */
    public void setUnidcont(java.lang.String unidcont) {
        this.unidcont = unidcont;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbcont)) return false;
        Ijtbcont other = (Ijtbcont) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcont==null && other.getCdcont()==null) || 
             (this.cdcont!=null &&
              this.cdcont.equals(other.getCdcont()))) &&
            ((this.cdinterno==null && other.getCdinterno()==null) || 
             (this.cdinterno!=null &&
              this.cdinterno.equals(other.getCdinterno()))) &&
            ((this.dscontcomp==null && other.getDscontcomp()==null) || 
             (this.dscontcomp!=null &&
              this.dscontcomp.equals(other.getDscontcomp()))) &&
            ((this.dscontred==null && other.getDscontred()==null) || 
             (this.dscontred!=null &&
              this.dscontred.equals(other.getDscontred()))) &&
            ((this.ijclassificconts==null && other.getIjclassificconts()==null) || 
             (this.ijclassificconts!=null &&
              java.util.Arrays.equals(this.ijclassificconts, other.getIjclassificconts()))) &&
            ((this.ijfiltroconts==null && other.getIjfiltroconts()==null) || 
             (this.ijfiltroconts!=null &&
              java.util.Arrays.equals(this.ijfiltroconts, other.getIjfiltroconts()))) &&
            ((this.ijlinguas==null && other.getIjlinguas()==null) || 
             (this.ijlinguas!=null &&
              this.ijlinguas.equals(other.getIjlinguas()))) &&
            ((this.ijtbtipoger==null && other.getIjtbtipoger()==null) || 
             (this.ijtbtipoger!=null &&
              this.ijtbtipoger.equals(other.getIjtbtipoger()))) &&
            ((this.indcalculo==null && other.getIndcalculo()==null) || 
             (this.indcalculo!=null &&
              this.indcalculo.equals(other.getIndcalculo()))) &&
            ((this.unidcont==null && other.getUnidcont()==null) || 
             (this.unidcont!=null &&
              this.unidcont.equals(other.getUnidcont())));
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
        if (getCdcont() != null) {
            _hashCode += getCdcont().hashCode();
        }
        if (getCdinterno() != null) {
            _hashCode += getCdinterno().hashCode();
        }
        if (getDscontcomp() != null) {
            _hashCode += getDscontcomp().hashCode();
        }
        if (getDscontred() != null) {
            _hashCode += getDscontred().hashCode();
        }
        if (getIjclassificconts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjclassificconts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjclassificconts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getIjlinguas() != null) {
            _hashCode += getIjlinguas().hashCode();
        }
        if (getIjtbtipoger() != null) {
            _hashCode += getIjtbtipoger().hashCode();
        }
        if (getIndcalculo() != null) {
            _hashCode += getIndcalculo().hashCode();
        }
        if (getUnidcont() != null) {
            _hashCode += getUnidcont().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbcont.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcont"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcont");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcont"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinterno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinterno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dscontcomp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dscontcomp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dscontred");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dscontred"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijclassificconts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijclassificconts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijclassificcont"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
        elemField.setFieldName("ijlinguas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijlinguas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlinguas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbtipoger");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbtipoger"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtipoger"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indcalculo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indcalculo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidcont");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unidcont"));
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
