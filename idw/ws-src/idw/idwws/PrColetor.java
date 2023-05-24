/**
 * PrColetor.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PrColetor  implements java.io.Serializable {
    private java.util.Calendar dthrultacessobd;

    private java.util.Calendar dthrultacessows;

    private java.lang.String idcoletor;

    private java.lang.String idcoletor2;

    private java.math.BigDecimal idregcoletor;

    private java.lang.Double msdthrultacessobd;

    private java.lang.Double msdthrultacessows;

    private idw.idwws.PrConexoesInjet prConexoesInjet;

    private idw.idwws.PrSubColetor[] prSubColetors;

    private org.apache.axis.types.UnsignedShort stmonitoraespera;

    public PrColetor() {
    }

    public PrColetor(
           java.util.Calendar dthrultacessobd,
           java.util.Calendar dthrultacessows,
           java.lang.String idcoletor,
           java.lang.String idcoletor2,
           java.math.BigDecimal idregcoletor,
           java.lang.Double msdthrultacessobd,
           java.lang.Double msdthrultacessows,
           idw.idwws.PrConexoesInjet prConexoesInjet,
           idw.idwws.PrSubColetor[] prSubColetors,
           org.apache.axis.types.UnsignedShort stmonitoraespera) {
           this.dthrultacessobd = dthrultacessobd;
           this.dthrultacessows = dthrultacessows;
           this.idcoletor = idcoletor;
           this.idcoletor2 = idcoletor2;
           this.idregcoletor = idregcoletor;
           this.msdthrultacessobd = msdthrultacessobd;
           this.msdthrultacessows = msdthrultacessows;
           this.prConexoesInjet = prConexoesInjet;
           this.prSubColetors = prSubColetors;
           this.stmonitoraespera = stmonitoraespera;
    }


    /**
     * Gets the dthrultacessobd value for this PrColetor.
     * 
     * @return dthrultacessobd
     */
    public java.util.Calendar getDthrultacessobd() {
        return dthrultacessobd;
    }


    /**
     * Sets the dthrultacessobd value for this PrColetor.
     * 
     * @param dthrultacessobd
     */
    public void setDthrultacessobd(java.util.Calendar dthrultacessobd) {
        this.dthrultacessobd = dthrultacessobd;
    }


    /**
     * Gets the dthrultacessows value for this PrColetor.
     * 
     * @return dthrultacessows
     */
    public java.util.Calendar getDthrultacessows() {
        return dthrultacessows;
    }


    /**
     * Sets the dthrultacessows value for this PrColetor.
     * 
     * @param dthrultacessows
     */
    public void setDthrultacessows(java.util.Calendar dthrultacessows) {
        this.dthrultacessows = dthrultacessows;
    }


    /**
     * Gets the idcoletor value for this PrColetor.
     * 
     * @return idcoletor
     */
    public java.lang.String getIdcoletor() {
        return idcoletor;
    }


    /**
     * Sets the idcoletor value for this PrColetor.
     * 
     * @param idcoletor
     */
    public void setIdcoletor(java.lang.String idcoletor) {
        this.idcoletor = idcoletor;
    }


    /**
     * Gets the idcoletor2 value for this PrColetor.
     * 
     * @return idcoletor2
     */
    public java.lang.String getIdcoletor2() {
        return idcoletor2;
    }


    /**
     * Sets the idcoletor2 value for this PrColetor.
     * 
     * @param idcoletor2
     */
    public void setIdcoletor2(java.lang.String idcoletor2) {
        this.idcoletor2 = idcoletor2;
    }


    /**
     * Gets the idregcoletor value for this PrColetor.
     * 
     * @return idregcoletor
     */
    public java.math.BigDecimal getIdregcoletor() {
        return idregcoletor;
    }


    /**
     * Sets the idregcoletor value for this PrColetor.
     * 
     * @param idregcoletor
     */
    public void setIdregcoletor(java.math.BigDecimal idregcoletor) {
        this.idregcoletor = idregcoletor;
    }


    /**
     * Gets the msdthrultacessobd value for this PrColetor.
     * 
     * @return msdthrultacessobd
     */
    public java.lang.Double getMsdthrultacessobd() {
        return msdthrultacessobd;
    }


    /**
     * Sets the msdthrultacessobd value for this PrColetor.
     * 
     * @param msdthrultacessobd
     */
    public void setMsdthrultacessobd(java.lang.Double msdthrultacessobd) {
        this.msdthrultacessobd = msdthrultacessobd;
    }


    /**
     * Gets the msdthrultacessows value for this PrColetor.
     * 
     * @return msdthrultacessows
     */
    public java.lang.Double getMsdthrultacessows() {
        return msdthrultacessows;
    }


    /**
     * Sets the msdthrultacessows value for this PrColetor.
     * 
     * @param msdthrultacessows
     */
    public void setMsdthrultacessows(java.lang.Double msdthrultacessows) {
        this.msdthrultacessows = msdthrultacessows;
    }


    /**
     * Gets the prConexoesInjet value for this PrColetor.
     * 
     * @return prConexoesInjet
     */
    public idw.idwws.PrConexoesInjet getPrConexoesInjet() {
        return prConexoesInjet;
    }


    /**
     * Sets the prConexoesInjet value for this PrColetor.
     * 
     * @param prConexoesInjet
     */
    public void setPrConexoesInjet(idw.idwws.PrConexoesInjet prConexoesInjet) {
        this.prConexoesInjet = prConexoesInjet;
    }


    /**
     * Gets the prSubColetors value for this PrColetor.
     * 
     * @return prSubColetors
     */
    public idw.idwws.PrSubColetor[] getPrSubColetors() {
        return prSubColetors;
    }


    /**
     * Sets the prSubColetors value for this PrColetor.
     * 
     * @param prSubColetors
     */
    public void setPrSubColetors(idw.idwws.PrSubColetor[] prSubColetors) {
        this.prSubColetors = prSubColetors;
    }

    public idw.idwws.PrSubColetor getPrSubColetors(int i) {
        return this.prSubColetors[i];
    }

    public void setPrSubColetors(int i, idw.idwws.PrSubColetor _value) {
        this.prSubColetors[i] = _value;
    }


    /**
     * Gets the stmonitoraespera value for this PrColetor.
     * 
     * @return stmonitoraespera
     */
    public org.apache.axis.types.UnsignedShort getStmonitoraespera() {
        return stmonitoraespera;
    }


    /**
     * Sets the stmonitoraespera value for this PrColetor.
     * 
     * @param stmonitoraespera
     */
    public void setStmonitoraespera(org.apache.axis.types.UnsignedShort stmonitoraespera) {
        this.stmonitoraespera = stmonitoraespera;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrColetor)) return false;
        PrColetor other = (PrColetor) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrultacessobd==null && other.getDthrultacessobd()==null) || 
             (this.dthrultacessobd!=null &&
              this.dthrultacessobd.equals(other.getDthrultacessobd()))) &&
            ((this.dthrultacessows==null && other.getDthrultacessows()==null) || 
             (this.dthrultacessows!=null &&
              this.dthrultacessows.equals(other.getDthrultacessows()))) &&
            ((this.idcoletor==null && other.getIdcoletor()==null) || 
             (this.idcoletor!=null &&
              this.idcoletor.equals(other.getIdcoletor()))) &&
            ((this.idcoletor2==null && other.getIdcoletor2()==null) || 
             (this.idcoletor2!=null &&
              this.idcoletor2.equals(other.getIdcoletor2()))) &&
            ((this.idregcoletor==null && other.getIdregcoletor()==null) || 
             (this.idregcoletor!=null &&
              this.idregcoletor.equals(other.getIdregcoletor()))) &&
            ((this.msdthrultacessobd==null && other.getMsdthrultacessobd()==null) || 
             (this.msdthrultacessobd!=null &&
              this.msdthrultacessobd.equals(other.getMsdthrultacessobd()))) &&
            ((this.msdthrultacessows==null && other.getMsdthrultacessows()==null) || 
             (this.msdthrultacessows!=null &&
              this.msdthrultacessows.equals(other.getMsdthrultacessows()))) &&
            ((this.prConexoesInjet==null && other.getPrConexoesInjet()==null) || 
             (this.prConexoesInjet!=null &&
              this.prConexoesInjet.equals(other.getPrConexoesInjet()))) &&
            ((this.prSubColetors==null && other.getPrSubColetors()==null) || 
             (this.prSubColetors!=null &&
              java.util.Arrays.equals(this.prSubColetors, other.getPrSubColetors()))) &&
            ((this.stmonitoraespera==null && other.getStmonitoraespera()==null) || 
             (this.stmonitoraespera!=null &&
              this.stmonitoraespera.equals(other.getStmonitoraespera())));
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
        if (getDthrultacessobd() != null) {
            _hashCode += getDthrultacessobd().hashCode();
        }
        if (getDthrultacessows() != null) {
            _hashCode += getDthrultacessows().hashCode();
        }
        if (getIdcoletor() != null) {
            _hashCode += getIdcoletor().hashCode();
        }
        if (getIdcoletor2() != null) {
            _hashCode += getIdcoletor2().hashCode();
        }
        if (getIdregcoletor() != null) {
            _hashCode += getIdregcoletor().hashCode();
        }
        if (getMsdthrultacessobd() != null) {
            _hashCode += getMsdthrultacessobd().hashCode();
        }
        if (getMsdthrultacessows() != null) {
            _hashCode += getMsdthrultacessows().hashCode();
        }
        if (getPrConexoesInjet() != null) {
            _hashCode += getPrConexoesInjet().hashCode();
        }
        if (getPrSubColetors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrSubColetors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrSubColetors(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStmonitoraespera() != null) {
            _hashCode += getStmonitoraespera().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PrColetor.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prColetor"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrultacessobd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrultacessobd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrultacessows");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrultacessows"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idcoletor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idcoletor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idcoletor2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idcoletor2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idregcoletor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idregcoletor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msdthrultacessobd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msdthrultacessobd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msdthrultacessows");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msdthrultacessows"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prConexoesInjet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prConexoesInjet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prConexoesInjet"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prSubColetors");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prSubColetors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prSubColetor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stmonitoraespera");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stmonitoraespera"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
