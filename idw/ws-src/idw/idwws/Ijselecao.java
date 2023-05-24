/**
 * Ijselecao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijselecao  implements java.io.Serializable {
    private java.lang.String cdselecao;

    private java.lang.String dsselecao;

    private java.util.Calendar dthrcadastro;

    private idw.idwws.Ijgrpemail ijgrpemail;

    private idw.idwws.Ijselitensarq[] ijselitensarqs;

    private idw.idwws.Ijselitensmen[] ijselitensmens;

    private java.lang.String indativa;

    public Ijselecao() {
    }

    public Ijselecao(
           java.lang.String cdselecao,
           java.lang.String dsselecao,
           java.util.Calendar dthrcadastro,
           idw.idwws.Ijgrpemail ijgrpemail,
           idw.idwws.Ijselitensarq[] ijselitensarqs,
           idw.idwws.Ijselitensmen[] ijselitensmens,
           java.lang.String indativa) {
           this.cdselecao = cdselecao;
           this.dsselecao = dsselecao;
           this.dthrcadastro = dthrcadastro;
           this.ijgrpemail = ijgrpemail;
           this.ijselitensarqs = ijselitensarqs;
           this.ijselitensmens = ijselitensmens;
           this.indativa = indativa;
    }


    /**
     * Gets the cdselecao value for this Ijselecao.
     * 
     * @return cdselecao
     */
    public java.lang.String getCdselecao() {
        return cdselecao;
    }


    /**
     * Sets the cdselecao value for this Ijselecao.
     * 
     * @param cdselecao
     */
    public void setCdselecao(java.lang.String cdselecao) {
        this.cdselecao = cdselecao;
    }


    /**
     * Gets the dsselecao value for this Ijselecao.
     * 
     * @return dsselecao
     */
    public java.lang.String getDsselecao() {
        return dsselecao;
    }


    /**
     * Sets the dsselecao value for this Ijselecao.
     * 
     * @param dsselecao
     */
    public void setDsselecao(java.lang.String dsselecao) {
        this.dsselecao = dsselecao;
    }


    /**
     * Gets the dthrcadastro value for this Ijselecao.
     * 
     * @return dthrcadastro
     */
    public java.util.Calendar getDthrcadastro() {
        return dthrcadastro;
    }


    /**
     * Sets the dthrcadastro value for this Ijselecao.
     * 
     * @param dthrcadastro
     */
    public void setDthrcadastro(java.util.Calendar dthrcadastro) {
        this.dthrcadastro = dthrcadastro;
    }


    /**
     * Gets the ijgrpemail value for this Ijselecao.
     * 
     * @return ijgrpemail
     */
    public idw.idwws.Ijgrpemail getIjgrpemail() {
        return ijgrpemail;
    }


    /**
     * Sets the ijgrpemail value for this Ijselecao.
     * 
     * @param ijgrpemail
     */
    public void setIjgrpemail(idw.idwws.Ijgrpemail ijgrpemail) {
        this.ijgrpemail = ijgrpemail;
    }


    /**
     * Gets the ijselitensarqs value for this Ijselecao.
     * 
     * @return ijselitensarqs
     */
    public idw.idwws.Ijselitensarq[] getIjselitensarqs() {
        return ijselitensarqs;
    }


    /**
     * Sets the ijselitensarqs value for this Ijselecao.
     * 
     * @param ijselitensarqs
     */
    public void setIjselitensarqs(idw.idwws.Ijselitensarq[] ijselitensarqs) {
        this.ijselitensarqs = ijselitensarqs;
    }

    public idw.idwws.Ijselitensarq getIjselitensarqs(int i) {
        return this.ijselitensarqs[i];
    }

    public void setIjselitensarqs(int i, idw.idwws.Ijselitensarq _value) {
        this.ijselitensarqs[i] = _value;
    }


    /**
     * Gets the ijselitensmens value for this Ijselecao.
     * 
     * @return ijselitensmens
     */
    public idw.idwws.Ijselitensmen[] getIjselitensmens() {
        return ijselitensmens;
    }


    /**
     * Sets the ijselitensmens value for this Ijselecao.
     * 
     * @param ijselitensmens
     */
    public void setIjselitensmens(idw.idwws.Ijselitensmen[] ijselitensmens) {
        this.ijselitensmens = ijselitensmens;
    }

    public idw.idwws.Ijselitensmen getIjselitensmens(int i) {
        return this.ijselitensmens[i];
    }

    public void setIjselitensmens(int i, idw.idwws.Ijselitensmen _value) {
        this.ijselitensmens[i] = _value;
    }


    /**
     * Gets the indativa value for this Ijselecao.
     * 
     * @return indativa
     */
    public java.lang.String getIndativa() {
        return indativa;
    }


    /**
     * Sets the indativa value for this Ijselecao.
     * 
     * @param indativa
     */
    public void setIndativa(java.lang.String indativa) {
        this.indativa = indativa;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijselecao)) return false;
        Ijselecao other = (Ijselecao) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdselecao==null && other.getCdselecao()==null) || 
             (this.cdselecao!=null &&
              this.cdselecao.equals(other.getCdselecao()))) &&
            ((this.dsselecao==null && other.getDsselecao()==null) || 
             (this.dsselecao!=null &&
              this.dsselecao.equals(other.getDsselecao()))) &&
            ((this.dthrcadastro==null && other.getDthrcadastro()==null) || 
             (this.dthrcadastro!=null &&
              this.dthrcadastro.equals(other.getDthrcadastro()))) &&
            ((this.ijgrpemail==null && other.getIjgrpemail()==null) || 
             (this.ijgrpemail!=null &&
              this.ijgrpemail.equals(other.getIjgrpemail()))) &&
            ((this.ijselitensarqs==null && other.getIjselitensarqs()==null) || 
             (this.ijselitensarqs!=null &&
              java.util.Arrays.equals(this.ijselitensarqs, other.getIjselitensarqs()))) &&
            ((this.ijselitensmens==null && other.getIjselitensmens()==null) || 
             (this.ijselitensmens!=null &&
              java.util.Arrays.equals(this.ijselitensmens, other.getIjselitensmens()))) &&
            ((this.indativa==null && other.getIndativa()==null) || 
             (this.indativa!=null &&
              this.indativa.equals(other.getIndativa())));
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
        if (getCdselecao() != null) {
            _hashCode += getCdselecao().hashCode();
        }
        if (getDsselecao() != null) {
            _hashCode += getDsselecao().hashCode();
        }
        if (getDthrcadastro() != null) {
            _hashCode += getDthrcadastro().hashCode();
        }
        if (getIjgrpemail() != null) {
            _hashCode += getIjgrpemail().hashCode();
        }
        if (getIjselitensarqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjselitensarqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjselitensarqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjselitensmens() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjselitensmens());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjselitensmens(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIndativa() != null) {
            _hashCode += getIndativa().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijselecao.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijselecao"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdselecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdselecao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsselecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsselecao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrcadastro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrcadastro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpemail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpemail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpemail"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijselitensarqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijselitensarqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijselitensarq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijselitensmens");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijselitensmens"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijselitensmen"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indativa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indativa"));
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
