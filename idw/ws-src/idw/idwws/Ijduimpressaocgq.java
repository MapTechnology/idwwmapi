/**
 * Ijduimpressaocgq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijduimpressaocgq  implements java.io.Serializable {
    private java.lang.String cdcliente;

    private java.util.Calendar dthrimpressao;

    private double idregistro;

    private idw.idwws.Ijctrlcgqalt ijctrlcgqalt;

    private idw.idwws.Ijduimpxplantas[] ijduimpxplantases;

    private idw.idwws.Ijtbusu ijtbusu;

    private java.lang.String nrnota;

    private double qtdpcsrefnf;

    public Ijduimpressaocgq() {
    }

    public Ijduimpressaocgq(
           java.lang.String cdcliente,
           java.util.Calendar dthrimpressao,
           double idregistro,
           idw.idwws.Ijctrlcgqalt ijctrlcgqalt,
           idw.idwws.Ijduimpxplantas[] ijduimpxplantases,
           idw.idwws.Ijtbusu ijtbusu,
           java.lang.String nrnota,
           double qtdpcsrefnf) {
           this.cdcliente = cdcliente;
           this.dthrimpressao = dthrimpressao;
           this.idregistro = idregistro;
           this.ijctrlcgqalt = ijctrlcgqalt;
           this.ijduimpxplantases = ijduimpxplantases;
           this.ijtbusu = ijtbusu;
           this.nrnota = nrnota;
           this.qtdpcsrefnf = qtdpcsrefnf;
    }


    /**
     * Gets the cdcliente value for this Ijduimpressaocgq.
     * 
     * @return cdcliente
     */
    public java.lang.String getCdcliente() {
        return cdcliente;
    }


    /**
     * Sets the cdcliente value for this Ijduimpressaocgq.
     * 
     * @param cdcliente
     */
    public void setCdcliente(java.lang.String cdcliente) {
        this.cdcliente = cdcliente;
    }


    /**
     * Gets the dthrimpressao value for this Ijduimpressaocgq.
     * 
     * @return dthrimpressao
     */
    public java.util.Calendar getDthrimpressao() {
        return dthrimpressao;
    }


    /**
     * Sets the dthrimpressao value for this Ijduimpressaocgq.
     * 
     * @param dthrimpressao
     */
    public void setDthrimpressao(java.util.Calendar dthrimpressao) {
        this.dthrimpressao = dthrimpressao;
    }


    /**
     * Gets the idregistro value for this Ijduimpressaocgq.
     * 
     * @return idregistro
     */
    public double getIdregistro() {
        return idregistro;
    }


    /**
     * Sets the idregistro value for this Ijduimpressaocgq.
     * 
     * @param idregistro
     */
    public void setIdregistro(double idregistro) {
        this.idregistro = idregistro;
    }


    /**
     * Gets the ijctrlcgqalt value for this Ijduimpressaocgq.
     * 
     * @return ijctrlcgqalt
     */
    public idw.idwws.Ijctrlcgqalt getIjctrlcgqalt() {
        return ijctrlcgqalt;
    }


    /**
     * Sets the ijctrlcgqalt value for this Ijduimpressaocgq.
     * 
     * @param ijctrlcgqalt
     */
    public void setIjctrlcgqalt(idw.idwws.Ijctrlcgqalt ijctrlcgqalt) {
        this.ijctrlcgqalt = ijctrlcgqalt;
    }


    /**
     * Gets the ijduimpxplantases value for this Ijduimpressaocgq.
     * 
     * @return ijduimpxplantases
     */
    public idw.idwws.Ijduimpxplantas[] getIjduimpxplantases() {
        return ijduimpxplantases;
    }


    /**
     * Sets the ijduimpxplantases value for this Ijduimpressaocgq.
     * 
     * @param ijduimpxplantases
     */
    public void setIjduimpxplantases(idw.idwws.Ijduimpxplantas[] ijduimpxplantases) {
        this.ijduimpxplantases = ijduimpxplantases;
    }

    public idw.idwws.Ijduimpxplantas getIjduimpxplantases(int i) {
        return this.ijduimpxplantases[i];
    }

    public void setIjduimpxplantases(int i, idw.idwws.Ijduimpxplantas _value) {
        this.ijduimpxplantases[i] = _value;
    }


    /**
     * Gets the ijtbusu value for this Ijduimpressaocgq.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijduimpressaocgq.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the nrnota value for this Ijduimpressaocgq.
     * 
     * @return nrnota
     */
    public java.lang.String getNrnota() {
        return nrnota;
    }


    /**
     * Sets the nrnota value for this Ijduimpressaocgq.
     * 
     * @param nrnota
     */
    public void setNrnota(java.lang.String nrnota) {
        this.nrnota = nrnota;
    }


    /**
     * Gets the qtdpcsrefnf value for this Ijduimpressaocgq.
     * 
     * @return qtdpcsrefnf
     */
    public double getQtdpcsrefnf() {
        return qtdpcsrefnf;
    }


    /**
     * Sets the qtdpcsrefnf value for this Ijduimpressaocgq.
     * 
     * @param qtdpcsrefnf
     */
    public void setQtdpcsrefnf(double qtdpcsrefnf) {
        this.qtdpcsrefnf = qtdpcsrefnf;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijduimpressaocgq)) return false;
        Ijduimpressaocgq other = (Ijduimpressaocgq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcliente==null && other.getCdcliente()==null) || 
             (this.cdcliente!=null &&
              this.cdcliente.equals(other.getCdcliente()))) &&
            ((this.dthrimpressao==null && other.getDthrimpressao()==null) || 
             (this.dthrimpressao!=null &&
              this.dthrimpressao.equals(other.getDthrimpressao()))) &&
            this.idregistro == other.getIdregistro() &&
            ((this.ijctrlcgqalt==null && other.getIjctrlcgqalt()==null) || 
             (this.ijctrlcgqalt!=null &&
              this.ijctrlcgqalt.equals(other.getIjctrlcgqalt()))) &&
            ((this.ijduimpxplantases==null && other.getIjduimpxplantases()==null) || 
             (this.ijduimpxplantases!=null &&
              java.util.Arrays.equals(this.ijduimpxplantases, other.getIjduimpxplantases()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu()))) &&
            ((this.nrnota==null && other.getNrnota()==null) || 
             (this.nrnota!=null &&
              this.nrnota.equals(other.getNrnota()))) &&
            this.qtdpcsrefnf == other.getQtdpcsrefnf();
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
        if (getCdcliente() != null) {
            _hashCode += getCdcliente().hashCode();
        }
        if (getDthrimpressao() != null) {
            _hashCode += getDthrimpressao().hashCode();
        }
        _hashCode += new Double(getIdregistro()).hashCode();
        if (getIjctrlcgqalt() != null) {
            _hashCode += getIjctrlcgqalt().hashCode();
        }
        if (getIjduimpxplantases() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjduimpxplantases());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjduimpxplantases(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        if (getNrnota() != null) {
            _hashCode += getNrnota().hashCode();
        }
        _hashCode += new Double(getQtdpcsrefnf()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijduimpressaocgq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijduimpressaocgq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrimpressao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrimpressao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idregistro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idregistro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrlcgqalt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrlcgqalt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlcgqalt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijduimpxplantases");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijduimpxplantases"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijduimpxplantas"));
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
        elemField.setFieldName("nrnota");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrnota"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdpcsrefnf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdpcsrefnf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
