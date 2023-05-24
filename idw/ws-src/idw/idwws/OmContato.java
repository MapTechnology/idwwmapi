/**
 * OmContato.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmContato  implements java.io.Serializable {
    private java.lang.String email1;

    private java.lang.String email2;

    private java.lang.String email3;

    private double idContato;

    private java.lang.String nmContato;

    private java.lang.String obs;

    private idw.idwws.OmGarantia[] omGarantias;

    private idw.idwws.PpCliente ppCliente;

    private java.lang.String telefone1;

    private java.lang.String telefone2;

    private java.lang.String telefone3;

    public OmContato() {
    }

    public OmContato(
           java.lang.String email1,
           java.lang.String email2,
           java.lang.String email3,
           double idContato,
           java.lang.String nmContato,
           java.lang.String obs,
           idw.idwws.OmGarantia[] omGarantias,
           idw.idwws.PpCliente ppCliente,
           java.lang.String telefone1,
           java.lang.String telefone2,
           java.lang.String telefone3) {
           this.email1 = email1;
           this.email2 = email2;
           this.email3 = email3;
           this.idContato = idContato;
           this.nmContato = nmContato;
           this.obs = obs;
           this.omGarantias = omGarantias;
           this.ppCliente = ppCliente;
           this.telefone1 = telefone1;
           this.telefone2 = telefone2;
           this.telefone3 = telefone3;
    }


    /**
     * Gets the email1 value for this OmContato.
     * 
     * @return email1
     */
    public java.lang.String getEmail1() {
        return email1;
    }


    /**
     * Sets the email1 value for this OmContato.
     * 
     * @param email1
     */
    public void setEmail1(java.lang.String email1) {
        this.email1 = email1;
    }


    /**
     * Gets the email2 value for this OmContato.
     * 
     * @return email2
     */
    public java.lang.String getEmail2() {
        return email2;
    }


    /**
     * Sets the email2 value for this OmContato.
     * 
     * @param email2
     */
    public void setEmail2(java.lang.String email2) {
        this.email2 = email2;
    }


    /**
     * Gets the email3 value for this OmContato.
     * 
     * @return email3
     */
    public java.lang.String getEmail3() {
        return email3;
    }


    /**
     * Sets the email3 value for this OmContato.
     * 
     * @param email3
     */
    public void setEmail3(java.lang.String email3) {
        this.email3 = email3;
    }


    /**
     * Gets the idContato value for this OmContato.
     * 
     * @return idContato
     */
    public double getIdContato() {
        return idContato;
    }


    /**
     * Sets the idContato value for this OmContato.
     * 
     * @param idContato
     */
    public void setIdContato(double idContato) {
        this.idContato = idContato;
    }


    /**
     * Gets the nmContato value for this OmContato.
     * 
     * @return nmContato
     */
    public java.lang.String getNmContato() {
        return nmContato;
    }


    /**
     * Sets the nmContato value for this OmContato.
     * 
     * @param nmContato
     */
    public void setNmContato(java.lang.String nmContato) {
        this.nmContato = nmContato;
    }


    /**
     * Gets the obs value for this OmContato.
     * 
     * @return obs
     */
    public java.lang.String getObs() {
        return obs;
    }


    /**
     * Sets the obs value for this OmContato.
     * 
     * @param obs
     */
    public void setObs(java.lang.String obs) {
        this.obs = obs;
    }


    /**
     * Gets the omGarantias value for this OmContato.
     * 
     * @return omGarantias
     */
    public idw.idwws.OmGarantia[] getOmGarantias() {
        return omGarantias;
    }


    /**
     * Sets the omGarantias value for this OmContato.
     * 
     * @param omGarantias
     */
    public void setOmGarantias(idw.idwws.OmGarantia[] omGarantias) {
        this.omGarantias = omGarantias;
    }

    public idw.idwws.OmGarantia getOmGarantias(int i) {
        return this.omGarantias[i];
    }

    public void setOmGarantias(int i, idw.idwws.OmGarantia _value) {
        this.omGarantias[i] = _value;
    }


    /**
     * Gets the ppCliente value for this OmContato.
     * 
     * @return ppCliente
     */
    public idw.idwws.PpCliente getPpCliente() {
        return ppCliente;
    }


    /**
     * Sets the ppCliente value for this OmContato.
     * 
     * @param ppCliente
     */
    public void setPpCliente(idw.idwws.PpCliente ppCliente) {
        this.ppCliente = ppCliente;
    }


    /**
     * Gets the telefone1 value for this OmContato.
     * 
     * @return telefone1
     */
    public java.lang.String getTelefone1() {
        return telefone1;
    }


    /**
     * Sets the telefone1 value for this OmContato.
     * 
     * @param telefone1
     */
    public void setTelefone1(java.lang.String telefone1) {
        this.telefone1 = telefone1;
    }


    /**
     * Gets the telefone2 value for this OmContato.
     * 
     * @return telefone2
     */
    public java.lang.String getTelefone2() {
        return telefone2;
    }


    /**
     * Sets the telefone2 value for this OmContato.
     * 
     * @param telefone2
     */
    public void setTelefone2(java.lang.String telefone2) {
        this.telefone2 = telefone2;
    }


    /**
     * Gets the telefone3 value for this OmContato.
     * 
     * @return telefone3
     */
    public java.lang.String getTelefone3() {
        return telefone3;
    }


    /**
     * Sets the telefone3 value for this OmContato.
     * 
     * @param telefone3
     */
    public void setTelefone3(java.lang.String telefone3) {
        this.telefone3 = telefone3;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmContato)) return false;
        OmContato other = (OmContato) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.email1==null && other.getEmail1()==null) || 
             (this.email1!=null &&
              this.email1.equals(other.getEmail1()))) &&
            ((this.email2==null && other.getEmail2()==null) || 
             (this.email2!=null &&
              this.email2.equals(other.getEmail2()))) &&
            ((this.email3==null && other.getEmail3()==null) || 
             (this.email3!=null &&
              this.email3.equals(other.getEmail3()))) &&
            this.idContato == other.getIdContato() &&
            ((this.nmContato==null && other.getNmContato()==null) || 
             (this.nmContato!=null &&
              this.nmContato.equals(other.getNmContato()))) &&
            ((this.obs==null && other.getObs()==null) || 
             (this.obs!=null &&
              this.obs.equals(other.getObs()))) &&
            ((this.omGarantias==null && other.getOmGarantias()==null) || 
             (this.omGarantias!=null &&
              java.util.Arrays.equals(this.omGarantias, other.getOmGarantias()))) &&
            ((this.ppCliente==null && other.getPpCliente()==null) || 
             (this.ppCliente!=null &&
              this.ppCliente.equals(other.getPpCliente()))) &&
            ((this.telefone1==null && other.getTelefone1()==null) || 
             (this.telefone1!=null &&
              this.telefone1.equals(other.getTelefone1()))) &&
            ((this.telefone2==null && other.getTelefone2()==null) || 
             (this.telefone2!=null &&
              this.telefone2.equals(other.getTelefone2()))) &&
            ((this.telefone3==null && other.getTelefone3()==null) || 
             (this.telefone3!=null &&
              this.telefone3.equals(other.getTelefone3())));
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
        if (getEmail1() != null) {
            _hashCode += getEmail1().hashCode();
        }
        if (getEmail2() != null) {
            _hashCode += getEmail2().hashCode();
        }
        if (getEmail3() != null) {
            _hashCode += getEmail3().hashCode();
        }
        _hashCode += new Double(getIdContato()).hashCode();
        if (getNmContato() != null) {
            _hashCode += getNmContato().hashCode();
        }
        if (getObs() != null) {
            _hashCode += getObs().hashCode();
        }
        if (getOmGarantias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmGarantias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmGarantias(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpCliente() != null) {
            _hashCode += getPpCliente().hashCode();
        }
        if (getTelefone1() != null) {
            _hashCode += getTelefone1().hashCode();
        }
        if (getTelefone2() != null) {
            _hashCode += getTelefone2().hashCode();
        }
        if (getTelefone3() != null) {
            _hashCode += getTelefone3().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmContato.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omContato"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idContato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idContato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nmContato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nmContato"));
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
        elemField.setFieldName("omGarantias");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omGarantias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omGarantia"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCliente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefone1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "telefone1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefone2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "telefone2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefone3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "telefone3"));
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
