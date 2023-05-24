/**
 * Ijmanutchklst.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijmanutchklst  implements java.io.Serializable {
    private java.lang.String cdchklst;

    private java.lang.String dschklst;

    private java.util.Calendar dtfimval;

    private java.util.Calendar dtinival;

    private java.lang.String idchklst;

    private idw.idwws.Ijmanutchklstdet[] ijmanutchklstdets;

    private idw.idwws.Ijmanutexec[] ijmanutexecs;

    private idw.idwws.Ijtbusu ijtbusu;

    private java.lang.String nrrevisao;

    private java.lang.String nrversao;

    public Ijmanutchklst() {
    }

    public Ijmanutchklst(
           java.lang.String cdchklst,
           java.lang.String dschklst,
           java.util.Calendar dtfimval,
           java.util.Calendar dtinival,
           java.lang.String idchklst,
           idw.idwws.Ijmanutchklstdet[] ijmanutchklstdets,
           idw.idwws.Ijmanutexec[] ijmanutexecs,
           idw.idwws.Ijtbusu ijtbusu,
           java.lang.String nrrevisao,
           java.lang.String nrversao) {
           this.cdchklst = cdchklst;
           this.dschklst = dschklst;
           this.dtfimval = dtfimval;
           this.dtinival = dtinival;
           this.idchklst = idchklst;
           this.ijmanutchklstdets = ijmanutchklstdets;
           this.ijmanutexecs = ijmanutexecs;
           this.ijtbusu = ijtbusu;
           this.nrrevisao = nrrevisao;
           this.nrversao = nrversao;
    }


    /**
     * Gets the cdchklst value for this Ijmanutchklst.
     * 
     * @return cdchklst
     */
    public java.lang.String getCdchklst() {
        return cdchklst;
    }


    /**
     * Sets the cdchklst value for this Ijmanutchklst.
     * 
     * @param cdchklst
     */
    public void setCdchklst(java.lang.String cdchklst) {
        this.cdchklst = cdchklst;
    }


    /**
     * Gets the dschklst value for this Ijmanutchklst.
     * 
     * @return dschklst
     */
    public java.lang.String getDschklst() {
        return dschklst;
    }


    /**
     * Sets the dschklst value for this Ijmanutchklst.
     * 
     * @param dschklst
     */
    public void setDschklst(java.lang.String dschklst) {
        this.dschklst = dschklst;
    }


    /**
     * Gets the dtfimval value for this Ijmanutchklst.
     * 
     * @return dtfimval
     */
    public java.util.Calendar getDtfimval() {
        return dtfimval;
    }


    /**
     * Sets the dtfimval value for this Ijmanutchklst.
     * 
     * @param dtfimval
     */
    public void setDtfimval(java.util.Calendar dtfimval) {
        this.dtfimval = dtfimval;
    }


    /**
     * Gets the dtinival value for this Ijmanutchklst.
     * 
     * @return dtinival
     */
    public java.util.Calendar getDtinival() {
        return dtinival;
    }


    /**
     * Sets the dtinival value for this Ijmanutchklst.
     * 
     * @param dtinival
     */
    public void setDtinival(java.util.Calendar dtinival) {
        this.dtinival = dtinival;
    }


    /**
     * Gets the idchklst value for this Ijmanutchklst.
     * 
     * @return idchklst
     */
    public java.lang.String getIdchklst() {
        return idchklst;
    }


    /**
     * Sets the idchklst value for this Ijmanutchklst.
     * 
     * @param idchklst
     */
    public void setIdchklst(java.lang.String idchklst) {
        this.idchklst = idchklst;
    }


    /**
     * Gets the ijmanutchklstdets value for this Ijmanutchklst.
     * 
     * @return ijmanutchklstdets
     */
    public idw.idwws.Ijmanutchklstdet[] getIjmanutchklstdets() {
        return ijmanutchklstdets;
    }


    /**
     * Sets the ijmanutchklstdets value for this Ijmanutchklst.
     * 
     * @param ijmanutchklstdets
     */
    public void setIjmanutchklstdets(idw.idwws.Ijmanutchklstdet[] ijmanutchklstdets) {
        this.ijmanutchklstdets = ijmanutchklstdets;
    }

    public idw.idwws.Ijmanutchklstdet getIjmanutchklstdets(int i) {
        return this.ijmanutchklstdets[i];
    }

    public void setIjmanutchklstdets(int i, idw.idwws.Ijmanutchklstdet _value) {
        this.ijmanutchklstdets[i] = _value;
    }


    /**
     * Gets the ijmanutexecs value for this Ijmanutchklst.
     * 
     * @return ijmanutexecs
     */
    public idw.idwws.Ijmanutexec[] getIjmanutexecs() {
        return ijmanutexecs;
    }


    /**
     * Sets the ijmanutexecs value for this Ijmanutchklst.
     * 
     * @param ijmanutexecs
     */
    public void setIjmanutexecs(idw.idwws.Ijmanutexec[] ijmanutexecs) {
        this.ijmanutexecs = ijmanutexecs;
    }

    public idw.idwws.Ijmanutexec getIjmanutexecs(int i) {
        return this.ijmanutexecs[i];
    }

    public void setIjmanutexecs(int i, idw.idwws.Ijmanutexec _value) {
        this.ijmanutexecs[i] = _value;
    }


    /**
     * Gets the ijtbusu value for this Ijmanutchklst.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijmanutchklst.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the nrrevisao value for this Ijmanutchklst.
     * 
     * @return nrrevisao
     */
    public java.lang.String getNrrevisao() {
        return nrrevisao;
    }


    /**
     * Sets the nrrevisao value for this Ijmanutchklst.
     * 
     * @param nrrevisao
     */
    public void setNrrevisao(java.lang.String nrrevisao) {
        this.nrrevisao = nrrevisao;
    }


    /**
     * Gets the nrversao value for this Ijmanutchklst.
     * 
     * @return nrversao
     */
    public java.lang.String getNrversao() {
        return nrversao;
    }


    /**
     * Sets the nrversao value for this Ijmanutchklst.
     * 
     * @param nrversao
     */
    public void setNrversao(java.lang.String nrversao) {
        this.nrversao = nrversao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijmanutchklst)) return false;
        Ijmanutchklst other = (Ijmanutchklst) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdchklst==null && other.getCdchklst()==null) || 
             (this.cdchklst!=null &&
              this.cdchklst.equals(other.getCdchklst()))) &&
            ((this.dschklst==null && other.getDschklst()==null) || 
             (this.dschklst!=null &&
              this.dschklst.equals(other.getDschklst()))) &&
            ((this.dtfimval==null && other.getDtfimval()==null) || 
             (this.dtfimval!=null &&
              this.dtfimval.equals(other.getDtfimval()))) &&
            ((this.dtinival==null && other.getDtinival()==null) || 
             (this.dtinival!=null &&
              this.dtinival.equals(other.getDtinival()))) &&
            ((this.idchklst==null && other.getIdchklst()==null) || 
             (this.idchklst!=null &&
              this.idchklst.equals(other.getIdchklst()))) &&
            ((this.ijmanutchklstdets==null && other.getIjmanutchklstdets()==null) || 
             (this.ijmanutchklstdets!=null &&
              java.util.Arrays.equals(this.ijmanutchklstdets, other.getIjmanutchklstdets()))) &&
            ((this.ijmanutexecs==null && other.getIjmanutexecs()==null) || 
             (this.ijmanutexecs!=null &&
              java.util.Arrays.equals(this.ijmanutexecs, other.getIjmanutexecs()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu()))) &&
            ((this.nrrevisao==null && other.getNrrevisao()==null) || 
             (this.nrrevisao!=null &&
              this.nrrevisao.equals(other.getNrrevisao()))) &&
            ((this.nrversao==null && other.getNrversao()==null) || 
             (this.nrversao!=null &&
              this.nrversao.equals(other.getNrversao())));
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
        if (getCdchklst() != null) {
            _hashCode += getCdchklst().hashCode();
        }
        if (getDschklst() != null) {
            _hashCode += getDschklst().hashCode();
        }
        if (getDtfimval() != null) {
            _hashCode += getDtfimval().hashCode();
        }
        if (getDtinival() != null) {
            _hashCode += getDtinival().hashCode();
        }
        if (getIdchklst() != null) {
            _hashCode += getIdchklst().hashCode();
        }
        if (getIjmanutchklstdets() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmanutchklstdets());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmanutchklstdets(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmanutexecs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmanutexecs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmanutexecs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        if (getNrrevisao() != null) {
            _hashCode += getNrrevisao().hashCode();
        }
        if (getNrversao() != null) {
            _hashCode += getNrversao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijmanutchklst.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutchklst"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdchklst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdchklst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dschklst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dschklst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtfimval");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtfimval"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtinival");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtinival"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idchklst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idchklst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanutchklstdets");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanutchklstdets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutchklstdet"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanutexecs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanutexecs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutexec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrversao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrversao"));
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
