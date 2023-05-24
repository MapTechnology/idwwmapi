/**
 * Ijtbemp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbemp  implements java.io.Serializable {
    private java.lang.String bairro;

    private java.lang.String cdempresa;

    private java.lang.String cep;

    private java.lang.String cgc;

    private java.lang.String dsempresa;

    private java.util.Calendar dtcadastro;

    private java.lang.String endereco;

    private idw.idwws.Ijtbusu[] ijtbusus;

    private java.lang.String pabx1;

    private java.lang.String pabx2;

    public Ijtbemp() {
    }

    public Ijtbemp(
           java.lang.String bairro,
           java.lang.String cdempresa,
           java.lang.String cep,
           java.lang.String cgc,
           java.lang.String dsempresa,
           java.util.Calendar dtcadastro,
           java.lang.String endereco,
           idw.idwws.Ijtbusu[] ijtbusus,
           java.lang.String pabx1,
           java.lang.String pabx2) {
           this.bairro = bairro;
           this.cdempresa = cdempresa;
           this.cep = cep;
           this.cgc = cgc;
           this.dsempresa = dsempresa;
           this.dtcadastro = dtcadastro;
           this.endereco = endereco;
           this.ijtbusus = ijtbusus;
           this.pabx1 = pabx1;
           this.pabx2 = pabx2;
    }


    /**
     * Gets the bairro value for this Ijtbemp.
     * 
     * @return bairro
     */
    public java.lang.String getBairro() {
        return bairro;
    }


    /**
     * Sets the bairro value for this Ijtbemp.
     * 
     * @param bairro
     */
    public void setBairro(java.lang.String bairro) {
        this.bairro = bairro;
    }


    /**
     * Gets the cdempresa value for this Ijtbemp.
     * 
     * @return cdempresa
     */
    public java.lang.String getCdempresa() {
        return cdempresa;
    }


    /**
     * Sets the cdempresa value for this Ijtbemp.
     * 
     * @param cdempresa
     */
    public void setCdempresa(java.lang.String cdempresa) {
        this.cdempresa = cdempresa;
    }


    /**
     * Gets the cep value for this Ijtbemp.
     * 
     * @return cep
     */
    public java.lang.String getCep() {
        return cep;
    }


    /**
     * Sets the cep value for this Ijtbemp.
     * 
     * @param cep
     */
    public void setCep(java.lang.String cep) {
        this.cep = cep;
    }


    /**
     * Gets the cgc value for this Ijtbemp.
     * 
     * @return cgc
     */
    public java.lang.String getCgc() {
        return cgc;
    }


    /**
     * Sets the cgc value for this Ijtbemp.
     * 
     * @param cgc
     */
    public void setCgc(java.lang.String cgc) {
        this.cgc = cgc;
    }


    /**
     * Gets the dsempresa value for this Ijtbemp.
     * 
     * @return dsempresa
     */
    public java.lang.String getDsempresa() {
        return dsempresa;
    }


    /**
     * Sets the dsempresa value for this Ijtbemp.
     * 
     * @param dsempresa
     */
    public void setDsempresa(java.lang.String dsempresa) {
        this.dsempresa = dsempresa;
    }


    /**
     * Gets the dtcadastro value for this Ijtbemp.
     * 
     * @return dtcadastro
     */
    public java.util.Calendar getDtcadastro() {
        return dtcadastro;
    }


    /**
     * Sets the dtcadastro value for this Ijtbemp.
     * 
     * @param dtcadastro
     */
    public void setDtcadastro(java.util.Calendar dtcadastro) {
        this.dtcadastro = dtcadastro;
    }


    /**
     * Gets the endereco value for this Ijtbemp.
     * 
     * @return endereco
     */
    public java.lang.String getEndereco() {
        return endereco;
    }


    /**
     * Sets the endereco value for this Ijtbemp.
     * 
     * @param endereco
     */
    public void setEndereco(java.lang.String endereco) {
        this.endereco = endereco;
    }


    /**
     * Gets the ijtbusus value for this Ijtbemp.
     * 
     * @return ijtbusus
     */
    public idw.idwws.Ijtbusu[] getIjtbusus() {
        return ijtbusus;
    }


    /**
     * Sets the ijtbusus value for this Ijtbemp.
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
     * Gets the pabx1 value for this Ijtbemp.
     * 
     * @return pabx1
     */
    public java.lang.String getPabx1() {
        return pabx1;
    }


    /**
     * Sets the pabx1 value for this Ijtbemp.
     * 
     * @param pabx1
     */
    public void setPabx1(java.lang.String pabx1) {
        this.pabx1 = pabx1;
    }


    /**
     * Gets the pabx2 value for this Ijtbemp.
     * 
     * @return pabx2
     */
    public java.lang.String getPabx2() {
        return pabx2;
    }


    /**
     * Sets the pabx2 value for this Ijtbemp.
     * 
     * @param pabx2
     */
    public void setPabx2(java.lang.String pabx2) {
        this.pabx2 = pabx2;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbemp)) return false;
        Ijtbemp other = (Ijtbemp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bairro==null && other.getBairro()==null) || 
             (this.bairro!=null &&
              this.bairro.equals(other.getBairro()))) &&
            ((this.cdempresa==null && other.getCdempresa()==null) || 
             (this.cdempresa!=null &&
              this.cdempresa.equals(other.getCdempresa()))) &&
            ((this.cep==null && other.getCep()==null) || 
             (this.cep!=null &&
              this.cep.equals(other.getCep()))) &&
            ((this.cgc==null && other.getCgc()==null) || 
             (this.cgc!=null &&
              this.cgc.equals(other.getCgc()))) &&
            ((this.dsempresa==null && other.getDsempresa()==null) || 
             (this.dsempresa!=null &&
              this.dsempresa.equals(other.getDsempresa()))) &&
            ((this.dtcadastro==null && other.getDtcadastro()==null) || 
             (this.dtcadastro!=null &&
              this.dtcadastro.equals(other.getDtcadastro()))) &&
            ((this.endereco==null && other.getEndereco()==null) || 
             (this.endereco!=null &&
              this.endereco.equals(other.getEndereco()))) &&
            ((this.ijtbusus==null && other.getIjtbusus()==null) || 
             (this.ijtbusus!=null &&
              java.util.Arrays.equals(this.ijtbusus, other.getIjtbusus()))) &&
            ((this.pabx1==null && other.getPabx1()==null) || 
             (this.pabx1!=null &&
              this.pabx1.equals(other.getPabx1()))) &&
            ((this.pabx2==null && other.getPabx2()==null) || 
             (this.pabx2!=null &&
              this.pabx2.equals(other.getPabx2())));
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
        if (getBairro() != null) {
            _hashCode += getBairro().hashCode();
        }
        if (getCdempresa() != null) {
            _hashCode += getCdempresa().hashCode();
        }
        if (getCep() != null) {
            _hashCode += getCep().hashCode();
        }
        if (getCgc() != null) {
            _hashCode += getCgc().hashCode();
        }
        if (getDsempresa() != null) {
            _hashCode += getDsempresa().hashCode();
        }
        if (getDtcadastro() != null) {
            _hashCode += getDtcadastro().hashCode();
        }
        if (getEndereco() != null) {
            _hashCode += getEndereco().hashCode();
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
        if (getPabx1() != null) {
            _hashCode += getPabx1().hashCode();
        }
        if (getPabx2() != null) {
            _hashCode += getPabx2().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbemp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbemp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bairro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bairro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdempresa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdempresa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cep");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cgc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cgc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsempresa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsempresa"));
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
        elemField.setFieldName("endereco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endereco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
        elemField.setFieldName("pabx1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pabx1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pabx2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pabx2"));
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
