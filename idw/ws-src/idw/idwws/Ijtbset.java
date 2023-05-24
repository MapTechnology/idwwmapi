/**
 * Ijtbset.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbset  implements java.io.Serializable {
    private java.lang.String cdsetor;

    private java.lang.String dssetor;

    private java.util.Calendar dtcadastro;

    private java.lang.String gerente;

    private idw.idwws.Ijtbinj[] ijtbinjs;

    private idw.idwws.Ijtbusumail[] ijtbusumails;

    private idw.idwws.Ijtbusu[] ijtbusus;

    private java.lang.String ramal;

    private java.lang.String telefone;

    public Ijtbset() {
    }

    public Ijtbset(
           java.lang.String cdsetor,
           java.lang.String dssetor,
           java.util.Calendar dtcadastro,
           java.lang.String gerente,
           idw.idwws.Ijtbinj[] ijtbinjs,
           idw.idwws.Ijtbusumail[] ijtbusumails,
           idw.idwws.Ijtbusu[] ijtbusus,
           java.lang.String ramal,
           java.lang.String telefone) {
           this.cdsetor = cdsetor;
           this.dssetor = dssetor;
           this.dtcadastro = dtcadastro;
           this.gerente = gerente;
           this.ijtbinjs = ijtbinjs;
           this.ijtbusumails = ijtbusumails;
           this.ijtbusus = ijtbusus;
           this.ramal = ramal;
           this.telefone = telefone;
    }


    /**
     * Gets the cdsetor value for this Ijtbset.
     * 
     * @return cdsetor
     */
    public java.lang.String getCdsetor() {
        return cdsetor;
    }


    /**
     * Sets the cdsetor value for this Ijtbset.
     * 
     * @param cdsetor
     */
    public void setCdsetor(java.lang.String cdsetor) {
        this.cdsetor = cdsetor;
    }


    /**
     * Gets the dssetor value for this Ijtbset.
     * 
     * @return dssetor
     */
    public java.lang.String getDssetor() {
        return dssetor;
    }


    /**
     * Sets the dssetor value for this Ijtbset.
     * 
     * @param dssetor
     */
    public void setDssetor(java.lang.String dssetor) {
        this.dssetor = dssetor;
    }


    /**
     * Gets the dtcadastro value for this Ijtbset.
     * 
     * @return dtcadastro
     */
    public java.util.Calendar getDtcadastro() {
        return dtcadastro;
    }


    /**
     * Sets the dtcadastro value for this Ijtbset.
     * 
     * @param dtcadastro
     */
    public void setDtcadastro(java.util.Calendar dtcadastro) {
        this.dtcadastro = dtcadastro;
    }


    /**
     * Gets the gerente value for this Ijtbset.
     * 
     * @return gerente
     */
    public java.lang.String getGerente() {
        return gerente;
    }


    /**
     * Sets the gerente value for this Ijtbset.
     * 
     * @param gerente
     */
    public void setGerente(java.lang.String gerente) {
        this.gerente = gerente;
    }


    /**
     * Gets the ijtbinjs value for this Ijtbset.
     * 
     * @return ijtbinjs
     */
    public idw.idwws.Ijtbinj[] getIjtbinjs() {
        return ijtbinjs;
    }


    /**
     * Sets the ijtbinjs value for this Ijtbset.
     * 
     * @param ijtbinjs
     */
    public void setIjtbinjs(idw.idwws.Ijtbinj[] ijtbinjs) {
        this.ijtbinjs = ijtbinjs;
    }

    public idw.idwws.Ijtbinj getIjtbinjs(int i) {
        return this.ijtbinjs[i];
    }

    public void setIjtbinjs(int i, idw.idwws.Ijtbinj _value) {
        this.ijtbinjs[i] = _value;
    }


    /**
     * Gets the ijtbusumails value for this Ijtbset.
     * 
     * @return ijtbusumails
     */
    public idw.idwws.Ijtbusumail[] getIjtbusumails() {
        return ijtbusumails;
    }


    /**
     * Sets the ijtbusumails value for this Ijtbset.
     * 
     * @param ijtbusumails
     */
    public void setIjtbusumails(idw.idwws.Ijtbusumail[] ijtbusumails) {
        this.ijtbusumails = ijtbusumails;
    }

    public idw.idwws.Ijtbusumail getIjtbusumails(int i) {
        return this.ijtbusumails[i];
    }

    public void setIjtbusumails(int i, idw.idwws.Ijtbusumail _value) {
        this.ijtbusumails[i] = _value;
    }


    /**
     * Gets the ijtbusus value for this Ijtbset.
     * 
     * @return ijtbusus
     */
    public idw.idwws.Ijtbusu[] getIjtbusus() {
        return ijtbusus;
    }


    /**
     * Sets the ijtbusus value for this Ijtbset.
     * 
     * @param ijtbusus
     */
    public void setIjtbusus(idw.idwws.Ijtbusu[] ijtbusus) {
        this.ijtbusus = ijtbusus;
    }

    public idw.idwws.Ijtbusu getIjtbusus(int i) {
        return this.ijtbusus[i];
    }

    public void setIjtbusus(int i, idw.idwws.Ijtbusu _value) {
        this.ijtbusus[i] = _value;
    }


    /**
     * Gets the ramal value for this Ijtbset.
     * 
     * @return ramal
     */
    public java.lang.String getRamal() {
        return ramal;
    }


    /**
     * Sets the ramal value for this Ijtbset.
     * 
     * @param ramal
     */
    public void setRamal(java.lang.String ramal) {
        this.ramal = ramal;
    }


    /**
     * Gets the telefone value for this Ijtbset.
     * 
     * @return telefone
     */
    public java.lang.String getTelefone() {
        return telefone;
    }


    /**
     * Sets the telefone value for this Ijtbset.
     * 
     * @param telefone
     */
    public void setTelefone(java.lang.String telefone) {
        this.telefone = telefone;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbset)) return false;
        Ijtbset other = (Ijtbset) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdsetor==null && other.getCdsetor()==null) || 
             (this.cdsetor!=null &&
              this.cdsetor.equals(other.getCdsetor()))) &&
            ((this.dssetor==null && other.getDssetor()==null) || 
             (this.dssetor!=null &&
              this.dssetor.equals(other.getDssetor()))) &&
            ((this.dtcadastro==null && other.getDtcadastro()==null) || 
             (this.dtcadastro!=null &&
              this.dtcadastro.equals(other.getDtcadastro()))) &&
            ((this.gerente==null && other.getGerente()==null) || 
             (this.gerente!=null &&
              this.gerente.equals(other.getGerente()))) &&
            ((this.ijtbinjs==null && other.getIjtbinjs()==null) || 
             (this.ijtbinjs!=null &&
              java.util.Arrays.equals(this.ijtbinjs, other.getIjtbinjs()))) &&
            ((this.ijtbusumails==null && other.getIjtbusumails()==null) || 
             (this.ijtbusumails!=null &&
              java.util.Arrays.equals(this.ijtbusumails, other.getIjtbusumails()))) &&
            ((this.ijtbusus==null && other.getIjtbusus()==null) || 
             (this.ijtbusus!=null &&
              java.util.Arrays.equals(this.ijtbusus, other.getIjtbusus()))) &&
            ((this.ramal==null && other.getRamal()==null) || 
             (this.ramal!=null &&
              this.ramal.equals(other.getRamal()))) &&
            ((this.telefone==null && other.getTelefone()==null) || 
             (this.telefone!=null &&
              this.telefone.equals(other.getTelefone())));
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
        if (getCdsetor() != null) {
            _hashCode += getCdsetor().hashCode();
        }
        if (getDssetor() != null) {
            _hashCode += getDssetor().hashCode();
        }
        if (getDtcadastro() != null) {
            _hashCode += getDtcadastro().hashCode();
        }
        if (getGerente() != null) {
            _hashCode += getGerente().hashCode();
        }
        if (getIjtbinjs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbinjs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbinjs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbusumails() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbusumails());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbusumails(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbusus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbusus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbusus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRamal() != null) {
            _hashCode += getRamal().hashCode();
        }
        if (getTelefone() != null) {
            _hashCode += getTelefone().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbset.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbset"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdsetor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdsetor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dssetor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dssetor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtcadastro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtcadastro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gerente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gerente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinjs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinjs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusumails");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusumails"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusumail"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ramal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ramal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "telefone"));
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
