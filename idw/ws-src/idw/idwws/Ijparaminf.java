/**
 * Ijparaminf.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijparaminf  implements java.io.Serializable {
    private idw.idwws.IjparaminfId id;

    private idw.idwws.Ijtbinf ijtbinf;

    private idw.idwws.Ijtbparam ijtbparam;

    private java.lang.String indnumopcao;

    private java.lang.String indobrigatorio;

    private java.lang.String indseq;

    private java.lang.String indtipoicone;

    public Ijparaminf() {
    }

    public Ijparaminf(
           idw.idwws.IjparaminfId id,
           idw.idwws.Ijtbinf ijtbinf,
           idw.idwws.Ijtbparam ijtbparam,
           java.lang.String indnumopcao,
           java.lang.String indobrigatorio,
           java.lang.String indseq,
           java.lang.String indtipoicone) {
           this.id = id;
           this.ijtbinf = ijtbinf;
           this.ijtbparam = ijtbparam;
           this.indnumopcao = indnumopcao;
           this.indobrigatorio = indobrigatorio;
           this.indseq = indseq;
           this.indtipoicone = indtipoicone;
    }


    /**
     * Gets the id value for this Ijparaminf.
     * 
     * @return id
     */
    public idw.idwws.IjparaminfId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijparaminf.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjparaminfId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbinf value for this Ijparaminf.
     * 
     * @return ijtbinf
     */
    public idw.idwws.Ijtbinf getIjtbinf() {
        return ijtbinf;
    }


    /**
     * Sets the ijtbinf value for this Ijparaminf.
     * 
     * @param ijtbinf
     */
    public void setIjtbinf(idw.idwws.Ijtbinf ijtbinf) {
        this.ijtbinf = ijtbinf;
    }


    /**
     * Gets the ijtbparam value for this Ijparaminf.
     * 
     * @return ijtbparam
     */
    public idw.idwws.Ijtbparam getIjtbparam() {
        return ijtbparam;
    }


    /**
     * Sets the ijtbparam value for this Ijparaminf.
     * 
     * @param ijtbparam
     */
    public void setIjtbparam(idw.idwws.Ijtbparam ijtbparam) {
        this.ijtbparam = ijtbparam;
    }


    /**
     * Gets the indnumopcao value for this Ijparaminf.
     * 
     * @return indnumopcao
     */
    public java.lang.String getIndnumopcao() {
        return indnumopcao;
    }


    /**
     * Sets the indnumopcao value for this Ijparaminf.
     * 
     * @param indnumopcao
     */
    public void setIndnumopcao(java.lang.String indnumopcao) {
        this.indnumopcao = indnumopcao;
    }


    /**
     * Gets the indobrigatorio value for this Ijparaminf.
     * 
     * @return indobrigatorio
     */
    public java.lang.String getIndobrigatorio() {
        return indobrigatorio;
    }


    /**
     * Sets the indobrigatorio value for this Ijparaminf.
     * 
     * @param indobrigatorio
     */
    public void setIndobrigatorio(java.lang.String indobrigatorio) {
        this.indobrigatorio = indobrigatorio;
    }


    /**
     * Gets the indseq value for this Ijparaminf.
     * 
     * @return indseq
     */
    public java.lang.String getIndseq() {
        return indseq;
    }


    /**
     * Sets the indseq value for this Ijparaminf.
     * 
     * @param indseq
     */
    public void setIndseq(java.lang.String indseq) {
        this.indseq = indseq;
    }


    /**
     * Gets the indtipoicone value for this Ijparaminf.
     * 
     * @return indtipoicone
     */
    public java.lang.String getIndtipoicone() {
        return indtipoicone;
    }


    /**
     * Sets the indtipoicone value for this Ijparaminf.
     * 
     * @param indtipoicone
     */
    public void setIndtipoicone(java.lang.String indtipoicone) {
        this.indtipoicone = indtipoicone;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijparaminf)) return false;
        Ijparaminf other = (Ijparaminf) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijtbinf==null && other.getIjtbinf()==null) || 
             (this.ijtbinf!=null &&
              this.ijtbinf.equals(other.getIjtbinf()))) &&
            ((this.ijtbparam==null && other.getIjtbparam()==null) || 
             (this.ijtbparam!=null &&
              this.ijtbparam.equals(other.getIjtbparam()))) &&
            ((this.indnumopcao==null && other.getIndnumopcao()==null) || 
             (this.indnumopcao!=null &&
              this.indnumopcao.equals(other.getIndnumopcao()))) &&
            ((this.indobrigatorio==null && other.getIndobrigatorio()==null) || 
             (this.indobrigatorio!=null &&
              this.indobrigatorio.equals(other.getIndobrigatorio()))) &&
            ((this.indseq==null && other.getIndseq()==null) || 
             (this.indseq!=null &&
              this.indseq.equals(other.getIndseq()))) &&
            ((this.indtipoicone==null && other.getIndtipoicone()==null) || 
             (this.indtipoicone!=null &&
              this.indtipoicone.equals(other.getIndtipoicone())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjtbinf() != null) {
            _hashCode += getIjtbinf().hashCode();
        }
        if (getIjtbparam() != null) {
            _hashCode += getIjtbparam().hashCode();
        }
        if (getIndnumopcao() != null) {
            _hashCode += getIndnumopcao().hashCode();
        }
        if (getIndobrigatorio() != null) {
            _hashCode += getIndobrigatorio().hashCode();
        }
        if (getIndseq() != null) {
            _hashCode += getIndseq().hashCode();
        }
        if (getIndtipoicone() != null) {
            _hashCode += getIndtipoicone().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijparaminf.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijparaminf"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijparaminfId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinf"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbparam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbparam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbparam"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indnumopcao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indnumopcao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indobrigatorio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indobrigatorio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indseq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indseq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indtipoicone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indtipoicone"));
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
