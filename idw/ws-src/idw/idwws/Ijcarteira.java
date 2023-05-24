/**
 * Ijcarteira.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijcarteira  implements java.io.Serializable {
    private java.lang.String doc;

    private java.util.Calendar dthrpedido;

    private idw.idwws.Ijplano[] ijplanos;

    private idw.idwws.Ijprocarteira[] ijprocarteiras;

    private idw.idwws.Ijtbcli ijtbcli;

    private java.lang.String nrcarteira;

    private java.lang.String obs;

    private java.lang.String solicitante;

    private java.math.BigDecimal stpedido;

    public Ijcarteira() {
    }

    public Ijcarteira(
           java.lang.String doc,
           java.util.Calendar dthrpedido,
           idw.idwws.Ijplano[] ijplanos,
           idw.idwws.Ijprocarteira[] ijprocarteiras,
           idw.idwws.Ijtbcli ijtbcli,
           java.lang.String nrcarteira,
           java.lang.String obs,
           java.lang.String solicitante,
           java.math.BigDecimal stpedido) {
           this.doc = doc;
           this.dthrpedido = dthrpedido;
           this.ijplanos = ijplanos;
           this.ijprocarteiras = ijprocarteiras;
           this.ijtbcli = ijtbcli;
           this.nrcarteira = nrcarteira;
           this.obs = obs;
           this.solicitante = solicitante;
           this.stpedido = stpedido;
    }


    /**
     * Gets the doc value for this Ijcarteira.
     * 
     * @return doc
     */
    public java.lang.String getDoc() {
        return doc;
    }


    /**
     * Sets the doc value for this Ijcarteira.
     * 
     * @param doc
     */
    public void setDoc(java.lang.String doc) {
        this.doc = doc;
    }


    /**
     * Gets the dthrpedido value for this Ijcarteira.
     * 
     * @return dthrpedido
     */
    public java.util.Calendar getDthrpedido() {
        return dthrpedido;
    }


    /**
     * Sets the dthrpedido value for this Ijcarteira.
     * 
     * @param dthrpedido
     */
    public void setDthrpedido(java.util.Calendar dthrpedido) {
        this.dthrpedido = dthrpedido;
    }


    /**
     * Gets the ijplanos value for this Ijcarteira.
     * 
     * @return ijplanos
     */
    public idw.idwws.Ijplano[] getIjplanos() {
        return ijplanos;
    }


    /**
     * Sets the ijplanos value for this Ijcarteira.
     * 
     * @param ijplanos
     */
    public void setIjplanos(idw.idwws.Ijplano[] ijplanos) {
        this.ijplanos = ijplanos;
    }

    public idw.idwws.Ijplano getIjplanos(int i) {
        return this.ijplanos[i];
    }

    public void setIjplanos(int i, idw.idwws.Ijplano _value) {
        this.ijplanos[i] = _value;
    }


    /**
     * Gets the ijprocarteiras value for this Ijcarteira.
     * 
     * @return ijprocarteiras
     */
    public idw.idwws.Ijprocarteira[] getIjprocarteiras() {
        return ijprocarteiras;
    }


    /**
     * Sets the ijprocarteiras value for this Ijcarteira.
     * 
     * @param ijprocarteiras
     */
    public void setIjprocarteiras(idw.idwws.Ijprocarteira[] ijprocarteiras) {
        this.ijprocarteiras = ijprocarteiras;
    }

    public idw.idwws.Ijprocarteira getIjprocarteiras(int i) {
        return this.ijprocarteiras[i];
    }

    public void setIjprocarteiras(int i, idw.idwws.Ijprocarteira _value) {
        this.ijprocarteiras[i] = _value;
    }


    /**
     * Gets the ijtbcli value for this Ijcarteira.
     * 
     * @return ijtbcli
     */
    public idw.idwws.Ijtbcli getIjtbcli() {
        return ijtbcli;
    }


    /**
     * Sets the ijtbcli value for this Ijcarteira.
     * 
     * @param ijtbcli
     */
    public void setIjtbcli(idw.idwws.Ijtbcli ijtbcli) {
        this.ijtbcli = ijtbcli;
    }


    /**
     * Gets the nrcarteira value for this Ijcarteira.
     * 
     * @return nrcarteira
     */
    public java.lang.String getNrcarteira() {
        return nrcarteira;
    }


    /**
     * Sets the nrcarteira value for this Ijcarteira.
     * 
     * @param nrcarteira
     */
    public void setNrcarteira(java.lang.String nrcarteira) {
        this.nrcarteira = nrcarteira;
    }


    /**
     * Gets the obs value for this Ijcarteira.
     * 
     * @return obs
     */
    public java.lang.String getObs() {
        return obs;
    }


    /**
     * Sets the obs value for this Ijcarteira.
     * 
     * @param obs
     */
    public void setObs(java.lang.String obs) {
        this.obs = obs;
    }


    /**
     * Gets the solicitante value for this Ijcarteira.
     * 
     * @return solicitante
     */
    public java.lang.String getSolicitante() {
        return solicitante;
    }


    /**
     * Sets the solicitante value for this Ijcarteira.
     * 
     * @param solicitante
     */
    public void setSolicitante(java.lang.String solicitante) {
        this.solicitante = solicitante;
    }


    /**
     * Gets the stpedido value for this Ijcarteira.
     * 
     * @return stpedido
     */
    public java.math.BigDecimal getStpedido() {
        return stpedido;
    }


    /**
     * Sets the stpedido value for this Ijcarteira.
     * 
     * @param stpedido
     */
    public void setStpedido(java.math.BigDecimal stpedido) {
        this.stpedido = stpedido;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijcarteira)) return false;
        Ijcarteira other = (Ijcarteira) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.doc==null && other.getDoc()==null) || 
             (this.doc!=null &&
              this.doc.equals(other.getDoc()))) &&
            ((this.dthrpedido==null && other.getDthrpedido()==null) || 
             (this.dthrpedido!=null &&
              this.dthrpedido.equals(other.getDthrpedido()))) &&
            ((this.ijplanos==null && other.getIjplanos()==null) || 
             (this.ijplanos!=null &&
              java.util.Arrays.equals(this.ijplanos, other.getIjplanos()))) &&
            ((this.ijprocarteiras==null && other.getIjprocarteiras()==null) || 
             (this.ijprocarteiras!=null &&
              java.util.Arrays.equals(this.ijprocarteiras, other.getIjprocarteiras()))) &&
            ((this.ijtbcli==null && other.getIjtbcli()==null) || 
             (this.ijtbcli!=null &&
              this.ijtbcli.equals(other.getIjtbcli()))) &&
            ((this.nrcarteira==null && other.getNrcarteira()==null) || 
             (this.nrcarteira!=null &&
              this.nrcarteira.equals(other.getNrcarteira()))) &&
            ((this.obs==null && other.getObs()==null) || 
             (this.obs!=null &&
              this.obs.equals(other.getObs()))) &&
            ((this.solicitante==null && other.getSolicitante()==null) || 
             (this.solicitante!=null &&
              this.solicitante.equals(other.getSolicitante()))) &&
            ((this.stpedido==null && other.getStpedido()==null) || 
             (this.stpedido!=null &&
              this.stpedido.equals(other.getStpedido())));
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
        if (getDoc() != null) {
            _hashCode += getDoc().hashCode();
        }
        if (getDthrpedido() != null) {
            _hashCode += getDthrpedido().hashCode();
        }
        if (getIjplanos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjplanos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjplanos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjprocarteiras() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjprocarteiras());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjprocarteiras(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbcli() != null) {
            _hashCode += getIjtbcli().hashCode();
        }
        if (getNrcarteira() != null) {
            _hashCode += getNrcarteira().hashCode();
        }
        if (getObs() != null) {
            _hashCode += getObs().hashCode();
        }
        if (getSolicitante() != null) {
            _hashCode += getSolicitante().hashCode();
        }
        if (getStpedido() != null) {
            _hashCode += getStpedido().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijcarteira.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcarteira"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("doc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "doc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrpedido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrpedido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijplanos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijplanos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijplano"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijprocarteiras");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijprocarteiras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijprocarteira"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbcli");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbcli"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcli"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrcarteira");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrcarteira"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "obs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("solicitante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "solicitante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stpedido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stpedido"));
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
