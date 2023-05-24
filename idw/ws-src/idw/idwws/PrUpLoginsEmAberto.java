/**
 * PrUpLoginsEmAberto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PrUpLoginsEmAberto  implements java.io.Serializable {
    private java.lang.String cdoperacao;

    private java.lang.String cdusuario;

    private java.util.Calendar dthrlogin;

    private java.lang.String idloginaberto;

    private double msdthrlogin;

    private idw.idwws.PrUp prUp;

    public PrUpLoginsEmAberto() {
    }

    public PrUpLoginsEmAberto(
           java.lang.String cdoperacao,
           java.lang.String cdusuario,
           java.util.Calendar dthrlogin,
           java.lang.String idloginaberto,
           double msdthrlogin,
           idw.idwws.PrUp prUp) {
           this.cdoperacao = cdoperacao;
           this.cdusuario = cdusuario;
           this.dthrlogin = dthrlogin;
           this.idloginaberto = idloginaberto;
           this.msdthrlogin = msdthrlogin;
           this.prUp = prUp;
    }


    /**
     * Gets the cdoperacao value for this PrUpLoginsEmAberto.
     * 
     * @return cdoperacao
     */
    public java.lang.String getCdoperacao() {
        return cdoperacao;
    }


    /**
     * Sets the cdoperacao value for this PrUpLoginsEmAberto.
     * 
     * @param cdoperacao
     */
    public void setCdoperacao(java.lang.String cdoperacao) {
        this.cdoperacao = cdoperacao;
    }


    /**
     * Gets the cdusuario value for this PrUpLoginsEmAberto.
     * 
     * @return cdusuario
     */
    public java.lang.String getCdusuario() {
        return cdusuario;
    }


    /**
     * Sets the cdusuario value for this PrUpLoginsEmAberto.
     * 
     * @param cdusuario
     */
    public void setCdusuario(java.lang.String cdusuario) {
        this.cdusuario = cdusuario;
    }


    /**
     * Gets the dthrlogin value for this PrUpLoginsEmAberto.
     * 
     * @return dthrlogin
     */
    public java.util.Calendar getDthrlogin() {
        return dthrlogin;
    }


    /**
     * Sets the dthrlogin value for this PrUpLoginsEmAberto.
     * 
     * @param dthrlogin
     */
    public void setDthrlogin(java.util.Calendar dthrlogin) {
        this.dthrlogin = dthrlogin;
    }


    /**
     * Gets the idloginaberto value for this PrUpLoginsEmAberto.
     * 
     * @return idloginaberto
     */
    public java.lang.String getIdloginaberto() {
        return idloginaberto;
    }


    /**
     * Sets the idloginaberto value for this PrUpLoginsEmAberto.
     * 
     * @param idloginaberto
     */
    public void setIdloginaberto(java.lang.String idloginaberto) {
        this.idloginaberto = idloginaberto;
    }


    /**
     * Gets the msdthrlogin value for this PrUpLoginsEmAberto.
     * 
     * @return msdthrlogin
     */
    public double getMsdthrlogin() {
        return msdthrlogin;
    }


    /**
     * Sets the msdthrlogin value for this PrUpLoginsEmAberto.
     * 
     * @param msdthrlogin
     */
    public void setMsdthrlogin(double msdthrlogin) {
        this.msdthrlogin = msdthrlogin;
    }


    /**
     * Gets the prUp value for this PrUpLoginsEmAberto.
     * 
     * @return prUp
     */
    public idw.idwws.PrUp getPrUp() {
        return prUp;
    }


    /**
     * Sets the prUp value for this PrUpLoginsEmAberto.
     * 
     * @param prUp
     */
    public void setPrUp(idw.idwws.PrUp prUp) {
        this.prUp = prUp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrUpLoginsEmAberto)) return false;
        PrUpLoginsEmAberto other = (PrUpLoginsEmAberto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdoperacao==null && other.getCdoperacao()==null) || 
             (this.cdoperacao!=null &&
              this.cdoperacao.equals(other.getCdoperacao()))) &&
            ((this.cdusuario==null && other.getCdusuario()==null) || 
             (this.cdusuario!=null &&
              this.cdusuario.equals(other.getCdusuario()))) &&
            ((this.dthrlogin==null && other.getDthrlogin()==null) || 
             (this.dthrlogin!=null &&
              this.dthrlogin.equals(other.getDthrlogin()))) &&
            ((this.idloginaberto==null && other.getIdloginaberto()==null) || 
             (this.idloginaberto!=null &&
              this.idloginaberto.equals(other.getIdloginaberto()))) &&
            this.msdthrlogin == other.getMsdthrlogin() &&
            ((this.prUp==null && other.getPrUp()==null) || 
             (this.prUp!=null &&
              this.prUp.equals(other.getPrUp())));
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
        if (getCdoperacao() != null) {
            _hashCode += getCdoperacao().hashCode();
        }
        if (getCdusuario() != null) {
            _hashCode += getCdusuario().hashCode();
        }
        if (getDthrlogin() != null) {
            _hashCode += getDthrlogin().hashCode();
        }
        if (getIdloginaberto() != null) {
            _hashCode += getIdloginaberto().hashCode();
        }
        _hashCode += new Double(getMsdthrlogin()).hashCode();
        if (getPrUp() != null) {
            _hashCode += getPrUp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PrUpLoginsEmAberto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prUpLoginsEmAberto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdoperacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdoperacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdusuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdusuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrlogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrlogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idloginaberto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idloginaberto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msdthrlogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msdthrlogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prUp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prUp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prUp"));
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
