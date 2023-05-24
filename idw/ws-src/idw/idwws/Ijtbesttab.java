/**
 * Ijtbesttab.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbesttab  implements java.io.Serializable {
    private java.lang.String cdtabelafkey;

    private java.lang.String dscoluna;

    private java.math.BigDecimal fkey;

    private idw.idwws.IjtbesttabId id;

    private idw.idwws.Ijlinguas ijlinguas;

    private idw.idwws.Ijtbtab ijtbtab;

    private idw.idwws.Ijtbtpdado ijtbtpdado;

    private java.lang.String nmcoluna;

    private java.math.BigDecimal pkey;

    private java.math.BigDecimal tamanho;

    public Ijtbesttab() {
    }

    public Ijtbesttab(
           java.lang.String cdtabelafkey,
           java.lang.String dscoluna,
           java.math.BigDecimal fkey,
           idw.idwws.IjtbesttabId id,
           idw.idwws.Ijlinguas ijlinguas,
           idw.idwws.Ijtbtab ijtbtab,
           idw.idwws.Ijtbtpdado ijtbtpdado,
           java.lang.String nmcoluna,
           java.math.BigDecimal pkey,
           java.math.BigDecimal tamanho) {
           this.cdtabelafkey = cdtabelafkey;
           this.dscoluna = dscoluna;
           this.fkey = fkey;
           this.id = id;
           this.ijlinguas = ijlinguas;
           this.ijtbtab = ijtbtab;
           this.ijtbtpdado = ijtbtpdado;
           this.nmcoluna = nmcoluna;
           this.pkey = pkey;
           this.tamanho = tamanho;
    }


    /**
     * Gets the cdtabelafkey value for this Ijtbesttab.
     * 
     * @return cdtabelafkey
     */
    public java.lang.String getCdtabelafkey() {
        return cdtabelafkey;
    }


    /**
     * Sets the cdtabelafkey value for this Ijtbesttab.
     * 
     * @param cdtabelafkey
     */
    public void setCdtabelafkey(java.lang.String cdtabelafkey) {
        this.cdtabelafkey = cdtabelafkey;
    }


    /**
     * Gets the dscoluna value for this Ijtbesttab.
     * 
     * @return dscoluna
     */
    public java.lang.String getDscoluna() {
        return dscoluna;
    }


    /**
     * Sets the dscoluna value for this Ijtbesttab.
     * 
     * @param dscoluna
     */
    public void setDscoluna(java.lang.String dscoluna) {
        this.dscoluna = dscoluna;
    }


    /**
     * Gets the fkey value for this Ijtbesttab.
     * 
     * @return fkey
     */
    public java.math.BigDecimal getFkey() {
        return fkey;
    }


    /**
     * Sets the fkey value for this Ijtbesttab.
     * 
     * @param fkey
     */
    public void setFkey(java.math.BigDecimal fkey) {
        this.fkey = fkey;
    }


    /**
     * Gets the id value for this Ijtbesttab.
     * 
     * @return id
     */
    public idw.idwws.IjtbesttabId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijtbesttab.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjtbesttabId id) {
        this.id = id;
    }


    /**
     * Gets the ijlinguas value for this Ijtbesttab.
     * 
     * @return ijlinguas
     */
    public idw.idwws.Ijlinguas getIjlinguas() {
        return ijlinguas;
    }


    /**
     * Sets the ijlinguas value for this Ijtbesttab.
     * 
     * @param ijlinguas
     */
    public void setIjlinguas(idw.idwws.Ijlinguas ijlinguas) {
        this.ijlinguas = ijlinguas;
    }


    /**
     * Gets the ijtbtab value for this Ijtbesttab.
     * 
     * @return ijtbtab
     */
    public idw.idwws.Ijtbtab getIjtbtab() {
        return ijtbtab;
    }


    /**
     * Sets the ijtbtab value for this Ijtbesttab.
     * 
     * @param ijtbtab
     */
    public void setIjtbtab(idw.idwws.Ijtbtab ijtbtab) {
        this.ijtbtab = ijtbtab;
    }


    /**
     * Gets the ijtbtpdado value for this Ijtbesttab.
     * 
     * @return ijtbtpdado
     */
    public idw.idwws.Ijtbtpdado getIjtbtpdado() {
        return ijtbtpdado;
    }


    /**
     * Sets the ijtbtpdado value for this Ijtbesttab.
     * 
     * @param ijtbtpdado
     */
    public void setIjtbtpdado(idw.idwws.Ijtbtpdado ijtbtpdado) {
        this.ijtbtpdado = ijtbtpdado;
    }


    /**
     * Gets the nmcoluna value for this Ijtbesttab.
     * 
     * @return nmcoluna
     */
    public java.lang.String getNmcoluna() {
        return nmcoluna;
    }


    /**
     * Sets the nmcoluna value for this Ijtbesttab.
     * 
     * @param nmcoluna
     */
    public void setNmcoluna(java.lang.String nmcoluna) {
        this.nmcoluna = nmcoluna;
    }


    /**
     * Gets the pkey value for this Ijtbesttab.
     * 
     * @return pkey
     */
    public java.math.BigDecimal getPkey() {
        return pkey;
    }


    /**
     * Sets the pkey value for this Ijtbesttab.
     * 
     * @param pkey
     */
    public void setPkey(java.math.BigDecimal pkey) {
        this.pkey = pkey;
    }


    /**
     * Gets the tamanho value for this Ijtbesttab.
     * 
     * @return tamanho
     */
    public java.math.BigDecimal getTamanho() {
        return tamanho;
    }


    /**
     * Sets the tamanho value for this Ijtbesttab.
     * 
     * @param tamanho
     */
    public void setTamanho(java.math.BigDecimal tamanho) {
        this.tamanho = tamanho;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbesttab)) return false;
        Ijtbesttab other = (Ijtbesttab) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdtabelafkey==null && other.getCdtabelafkey()==null) || 
             (this.cdtabelafkey!=null &&
              this.cdtabelafkey.equals(other.getCdtabelafkey()))) &&
            ((this.dscoluna==null && other.getDscoluna()==null) || 
             (this.dscoluna!=null &&
              this.dscoluna.equals(other.getDscoluna()))) &&
            ((this.fkey==null && other.getFkey()==null) || 
             (this.fkey!=null &&
              this.fkey.equals(other.getFkey()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijlinguas==null && other.getIjlinguas()==null) || 
             (this.ijlinguas!=null &&
              this.ijlinguas.equals(other.getIjlinguas()))) &&
            ((this.ijtbtab==null && other.getIjtbtab()==null) || 
             (this.ijtbtab!=null &&
              this.ijtbtab.equals(other.getIjtbtab()))) &&
            ((this.ijtbtpdado==null && other.getIjtbtpdado()==null) || 
             (this.ijtbtpdado!=null &&
              this.ijtbtpdado.equals(other.getIjtbtpdado()))) &&
            ((this.nmcoluna==null && other.getNmcoluna()==null) || 
             (this.nmcoluna!=null &&
              this.nmcoluna.equals(other.getNmcoluna()))) &&
            ((this.pkey==null && other.getPkey()==null) || 
             (this.pkey!=null &&
              this.pkey.equals(other.getPkey()))) &&
            ((this.tamanho==null && other.getTamanho()==null) || 
             (this.tamanho!=null &&
              this.tamanho.equals(other.getTamanho())));
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
        if (getCdtabelafkey() != null) {
            _hashCode += getCdtabelafkey().hashCode();
        }
        if (getDscoluna() != null) {
            _hashCode += getDscoluna().hashCode();
        }
        if (getFkey() != null) {
            _hashCode += getFkey().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjlinguas() != null) {
            _hashCode += getIjlinguas().hashCode();
        }
        if (getIjtbtab() != null) {
            _hashCode += getIjtbtab().hashCode();
        }
        if (getIjtbtpdado() != null) {
            _hashCode += getIjtbtpdado().hashCode();
        }
        if (getNmcoluna() != null) {
            _hashCode += getNmcoluna().hashCode();
        }
        if (getPkey() != null) {
            _hashCode += getPkey().hashCode();
        }
        if (getTamanho() != null) {
            _hashCode += getTamanho().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbesttab.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbesttab"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtabelafkey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtabelafkey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dscoluna");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dscoluna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fkey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fkey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbesttabId"));
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
        elemField.setFieldName("ijtbtab");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbtab"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtab"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbtpdado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbtpdado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtpdado"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nmcoluna");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nmcoluna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pkey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pkey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tamanho");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tamanho"));
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
