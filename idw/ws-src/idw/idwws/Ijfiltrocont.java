/**
 * Ijfiltrocont.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijfiltrocont  implements java.io.Serializable {
    private idw.idwws.IjfiltrocontId id;

    private idw.idwws.Ijgrpfiltro[] ijgrpfiltrosForSysC0013021;

    private idw.idwws.Ijgrpfiltro[] ijgrpfiltrosForSysC0013022;

    private idw.idwws.Ijtbcont ijtbcont;

    private idw.idwws.Ijtbtipofiltro ijtbtipofiltro;

    private java.lang.String indnumopcao;

    private java.lang.String indobrigatorio;

    private java.lang.String indseq;

    private java.lang.String indtipoicone;

    public Ijfiltrocont() {
    }

    public Ijfiltrocont(
           idw.idwws.IjfiltrocontId id,
           idw.idwws.Ijgrpfiltro[] ijgrpfiltrosForSysC0013021,
           idw.idwws.Ijgrpfiltro[] ijgrpfiltrosForSysC0013022,
           idw.idwws.Ijtbcont ijtbcont,
           idw.idwws.Ijtbtipofiltro ijtbtipofiltro,
           java.lang.String indnumopcao,
           java.lang.String indobrigatorio,
           java.lang.String indseq,
           java.lang.String indtipoicone) {
           this.id = id;
           this.ijgrpfiltrosForSysC0013021 = ijgrpfiltrosForSysC0013021;
           this.ijgrpfiltrosForSysC0013022 = ijgrpfiltrosForSysC0013022;
           this.ijtbcont = ijtbcont;
           this.ijtbtipofiltro = ijtbtipofiltro;
           this.indnumopcao = indnumopcao;
           this.indobrigatorio = indobrigatorio;
           this.indseq = indseq;
           this.indtipoicone = indtipoicone;
    }


    /**
     * Gets the id value for this Ijfiltrocont.
     * 
     * @return id
     */
    public idw.idwws.IjfiltrocontId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijfiltrocont.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjfiltrocontId id) {
        this.id = id;
    }


    /**
     * Gets the ijgrpfiltrosForSysC0013021 value for this Ijfiltrocont.
     * 
     * @return ijgrpfiltrosForSysC0013021
     */
    public idw.idwws.Ijgrpfiltro[] getIjgrpfiltrosForSysC0013021() {
        return ijgrpfiltrosForSysC0013021;
    }


    /**
     * Sets the ijgrpfiltrosForSysC0013021 value for this Ijfiltrocont.
     * 
     * @param ijgrpfiltrosForSysC0013021
     */
    public void setIjgrpfiltrosForSysC0013021(idw.idwws.Ijgrpfiltro[] ijgrpfiltrosForSysC0013021) {
        this.ijgrpfiltrosForSysC0013021 = ijgrpfiltrosForSysC0013021;
    }

    public idw.idwws.Ijgrpfiltro getIjgrpfiltrosForSysC0013021(int i) {
        return this.ijgrpfiltrosForSysC0013021[i];
    }

    public void setIjgrpfiltrosForSysC0013021(int i, idw.idwws.Ijgrpfiltro _value) {
        this.ijgrpfiltrosForSysC0013021[i] = _value;
    }


    /**
     * Gets the ijgrpfiltrosForSysC0013022 value for this Ijfiltrocont.
     * 
     * @return ijgrpfiltrosForSysC0013022
     */
    public idw.idwws.Ijgrpfiltro[] getIjgrpfiltrosForSysC0013022() {
        return ijgrpfiltrosForSysC0013022;
    }


    /**
     * Sets the ijgrpfiltrosForSysC0013022 value for this Ijfiltrocont.
     * 
     * @param ijgrpfiltrosForSysC0013022
     */
    public void setIjgrpfiltrosForSysC0013022(idw.idwws.Ijgrpfiltro[] ijgrpfiltrosForSysC0013022) {
        this.ijgrpfiltrosForSysC0013022 = ijgrpfiltrosForSysC0013022;
    }

    public idw.idwws.Ijgrpfiltro getIjgrpfiltrosForSysC0013022(int i) {
        return this.ijgrpfiltrosForSysC0013022[i];
    }

    public void setIjgrpfiltrosForSysC0013022(int i, idw.idwws.Ijgrpfiltro _value) {
        this.ijgrpfiltrosForSysC0013022[i] = _value;
    }


    /**
     * Gets the ijtbcont value for this Ijfiltrocont.
     * 
     * @return ijtbcont
     */
    public idw.idwws.Ijtbcont getIjtbcont() {
        return ijtbcont;
    }


    /**
     * Sets the ijtbcont value for this Ijfiltrocont.
     * 
     * @param ijtbcont
     */
    public void setIjtbcont(idw.idwws.Ijtbcont ijtbcont) {
        this.ijtbcont = ijtbcont;
    }


    /**
     * Gets the ijtbtipofiltro value for this Ijfiltrocont.
     * 
     * @return ijtbtipofiltro
     */
    public idw.idwws.Ijtbtipofiltro getIjtbtipofiltro() {
        return ijtbtipofiltro;
    }


    /**
     * Sets the ijtbtipofiltro value for this Ijfiltrocont.
     * 
     * @param ijtbtipofiltro
     */
    public void setIjtbtipofiltro(idw.idwws.Ijtbtipofiltro ijtbtipofiltro) {
        this.ijtbtipofiltro = ijtbtipofiltro;
    }


    /**
     * Gets the indnumopcao value for this Ijfiltrocont.
     * 
     * @return indnumopcao
     */
    public java.lang.String getIndnumopcao() {
        return indnumopcao;
    }


    /**
     * Sets the indnumopcao value for this Ijfiltrocont.
     * 
     * @param indnumopcao
     */
    public void setIndnumopcao(java.lang.String indnumopcao) {
        this.indnumopcao = indnumopcao;
    }


    /**
     * Gets the indobrigatorio value for this Ijfiltrocont.
     * 
     * @return indobrigatorio
     */
    public java.lang.String getIndobrigatorio() {
        return indobrigatorio;
    }


    /**
     * Sets the indobrigatorio value for this Ijfiltrocont.
     * 
     * @param indobrigatorio
     */
    public void setIndobrigatorio(java.lang.String indobrigatorio) {
        this.indobrigatorio = indobrigatorio;
    }


    /**
     * Gets the indseq value for this Ijfiltrocont.
     * 
     * @return indseq
     */
    public java.lang.String getIndseq() {
        return indseq;
    }


    /**
     * Sets the indseq value for this Ijfiltrocont.
     * 
     * @param indseq
     */
    public void setIndseq(java.lang.String indseq) {
        this.indseq = indseq;
    }


    /**
     * Gets the indtipoicone value for this Ijfiltrocont.
     * 
     * @return indtipoicone
     */
    public java.lang.String getIndtipoicone() {
        return indtipoicone;
    }


    /**
     * Sets the indtipoicone value for this Ijfiltrocont.
     * 
     * @param indtipoicone
     */
    public void setIndtipoicone(java.lang.String indtipoicone) {
        this.indtipoicone = indtipoicone;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijfiltrocont)) return false;
        Ijfiltrocont other = (Ijfiltrocont) obj;
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
            ((this.ijgrpfiltrosForSysC0013021==null && other.getIjgrpfiltrosForSysC0013021()==null) || 
             (this.ijgrpfiltrosForSysC0013021!=null &&
              java.util.Arrays.equals(this.ijgrpfiltrosForSysC0013021, other.getIjgrpfiltrosForSysC0013021()))) &&
            ((this.ijgrpfiltrosForSysC0013022==null && other.getIjgrpfiltrosForSysC0013022()==null) || 
             (this.ijgrpfiltrosForSysC0013022!=null &&
              java.util.Arrays.equals(this.ijgrpfiltrosForSysC0013022, other.getIjgrpfiltrosForSysC0013022()))) &&
            ((this.ijtbcont==null && other.getIjtbcont()==null) || 
             (this.ijtbcont!=null &&
              this.ijtbcont.equals(other.getIjtbcont()))) &&
            ((this.ijtbtipofiltro==null && other.getIjtbtipofiltro()==null) || 
             (this.ijtbtipofiltro!=null &&
              this.ijtbtipofiltro.equals(other.getIjtbtipofiltro()))) &&
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
        if (getIjgrpfiltrosForSysC0013021() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpfiltrosForSysC0013021());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpfiltrosForSysC0013021(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjgrpfiltrosForSysC0013022() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpfiltrosForSysC0013022());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpfiltrosForSysC0013022(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbcont() != null) {
            _hashCode += getIjtbcont().hashCode();
        }
        if (getIjtbtipofiltro() != null) {
            _hashCode += getIjtbtipofiltro().hashCode();
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
        new org.apache.axis.description.TypeDesc(Ijfiltrocont.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfiltrocont"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfiltrocontId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpfiltrosForSysC0013021");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpfiltrosForSysC0013021"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpfiltro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpfiltrosForSysC0013022");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpfiltrosForSysC0013022"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpfiltro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbcont");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbcont"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcont"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbtipofiltro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbtipofiltro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtipofiltro"));
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
