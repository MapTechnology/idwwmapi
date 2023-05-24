/**
 * Ijtbcoletores.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbcoletores  implements java.io.Serializable {
    private idw.idwws.IjtbcoletoresId id;

    private java.lang.String idalterncoletor;

    private idw.idwws.Ijtbmestres ijtbmestres;

    private idw.idwws.Ijtbsubcoletores[] ijtbsubcoletoreses;

    private org.apache.axis.types.UnsignedShort mdcoletor;

    private double precrelogio;

    private org.apache.axis.types.UnsignedShort stmonitoraespera;

    private java.math.BigDecimal tpcoletor;

    public Ijtbcoletores() {
    }

    public Ijtbcoletores(
           idw.idwws.IjtbcoletoresId id,
           java.lang.String idalterncoletor,
           idw.idwws.Ijtbmestres ijtbmestres,
           idw.idwws.Ijtbsubcoletores[] ijtbsubcoletoreses,
           org.apache.axis.types.UnsignedShort mdcoletor,
           double precrelogio,
           org.apache.axis.types.UnsignedShort stmonitoraespera,
           java.math.BigDecimal tpcoletor) {
           this.id = id;
           this.idalterncoletor = idalterncoletor;
           this.ijtbmestres = ijtbmestres;
           this.ijtbsubcoletoreses = ijtbsubcoletoreses;
           this.mdcoletor = mdcoletor;
           this.precrelogio = precrelogio;
           this.stmonitoraespera = stmonitoraespera;
           this.tpcoletor = tpcoletor;
    }


    /**
     * Gets the id value for this Ijtbcoletores.
     * 
     * @return id
     */
    public idw.idwws.IjtbcoletoresId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijtbcoletores.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjtbcoletoresId id) {
        this.id = id;
    }


    /**
     * Gets the idalterncoletor value for this Ijtbcoletores.
     * 
     * @return idalterncoletor
     */
    public java.lang.String getIdalterncoletor() {
        return idalterncoletor;
    }


    /**
     * Sets the idalterncoletor value for this Ijtbcoletores.
     * 
     * @param idalterncoletor
     */
    public void setIdalterncoletor(java.lang.String idalterncoletor) {
        this.idalterncoletor = idalterncoletor;
    }


    /**
     * Gets the ijtbmestres value for this Ijtbcoletores.
     * 
     * @return ijtbmestres
     */
    public idw.idwws.Ijtbmestres getIjtbmestres() {
        return ijtbmestres;
    }


    /**
     * Sets the ijtbmestres value for this Ijtbcoletores.
     * 
     * @param ijtbmestres
     */
    public void setIjtbmestres(idw.idwws.Ijtbmestres ijtbmestres) {
        this.ijtbmestres = ijtbmestres;
    }


    /**
     * Gets the ijtbsubcoletoreses value for this Ijtbcoletores.
     * 
     * @return ijtbsubcoletoreses
     */
    public idw.idwws.Ijtbsubcoletores[] getIjtbsubcoletoreses() {
        return ijtbsubcoletoreses;
    }


    /**
     * Sets the ijtbsubcoletoreses value for this Ijtbcoletores.
     * 
     * @param ijtbsubcoletoreses
     */
    public void setIjtbsubcoletoreses(idw.idwws.Ijtbsubcoletores[] ijtbsubcoletoreses) {
        this.ijtbsubcoletoreses = ijtbsubcoletoreses;
    }

    public idw.idwws.Ijtbsubcoletores getIjtbsubcoletoreses(int i) {
        return this.ijtbsubcoletoreses[i];
    }

    public void setIjtbsubcoletoreses(int i, idw.idwws.Ijtbsubcoletores _value) {
        this.ijtbsubcoletoreses[i] = _value;
    }


    /**
     * Gets the mdcoletor value for this Ijtbcoletores.
     * 
     * @return mdcoletor
     */
    public org.apache.axis.types.UnsignedShort getMdcoletor() {
        return mdcoletor;
    }


    /**
     * Sets the mdcoletor value for this Ijtbcoletores.
     * 
     * @param mdcoletor
     */
    public void setMdcoletor(org.apache.axis.types.UnsignedShort mdcoletor) {
        this.mdcoletor = mdcoletor;
    }


    /**
     * Gets the precrelogio value for this Ijtbcoletores.
     * 
     * @return precrelogio
     */
    public double getPrecrelogio() {
        return precrelogio;
    }


    /**
     * Sets the precrelogio value for this Ijtbcoletores.
     * 
     * @param precrelogio
     */
    public void setPrecrelogio(double precrelogio) {
        this.precrelogio = precrelogio;
    }


    /**
     * Gets the stmonitoraespera value for this Ijtbcoletores.
     * 
     * @return stmonitoraespera
     */
    public org.apache.axis.types.UnsignedShort getStmonitoraespera() {
        return stmonitoraespera;
    }


    /**
     * Sets the stmonitoraespera value for this Ijtbcoletores.
     * 
     * @param stmonitoraespera
     */
    public void setStmonitoraespera(org.apache.axis.types.UnsignedShort stmonitoraespera) {
        this.stmonitoraespera = stmonitoraespera;
    }


    /**
     * Gets the tpcoletor value for this Ijtbcoletores.
     * 
     * @return tpcoletor
     */
    public java.math.BigDecimal getTpcoletor() {
        return tpcoletor;
    }


    /**
     * Sets the tpcoletor value for this Ijtbcoletores.
     * 
     * @param tpcoletor
     */
    public void setTpcoletor(java.math.BigDecimal tpcoletor) {
        this.tpcoletor = tpcoletor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbcoletores)) return false;
        Ijtbcoletores other = (Ijtbcoletores) obj;
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
            ((this.idalterncoletor==null && other.getIdalterncoletor()==null) || 
             (this.idalterncoletor!=null &&
              this.idalterncoletor.equals(other.getIdalterncoletor()))) &&
            ((this.ijtbmestres==null && other.getIjtbmestres()==null) || 
             (this.ijtbmestres!=null &&
              this.ijtbmestres.equals(other.getIjtbmestres()))) &&
            ((this.ijtbsubcoletoreses==null && other.getIjtbsubcoletoreses()==null) || 
             (this.ijtbsubcoletoreses!=null &&
              java.util.Arrays.equals(this.ijtbsubcoletoreses, other.getIjtbsubcoletoreses()))) &&
            ((this.mdcoletor==null && other.getMdcoletor()==null) || 
             (this.mdcoletor!=null &&
              this.mdcoletor.equals(other.getMdcoletor()))) &&
            this.precrelogio == other.getPrecrelogio() &&
            ((this.stmonitoraespera==null && other.getStmonitoraespera()==null) || 
             (this.stmonitoraespera!=null &&
              this.stmonitoraespera.equals(other.getStmonitoraespera()))) &&
            ((this.tpcoletor==null && other.getTpcoletor()==null) || 
             (this.tpcoletor!=null &&
              this.tpcoletor.equals(other.getTpcoletor())));
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
        if (getIdalterncoletor() != null) {
            _hashCode += getIdalterncoletor().hashCode();
        }
        if (getIjtbmestres() != null) {
            _hashCode += getIjtbmestres().hashCode();
        }
        if (getIjtbsubcoletoreses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbsubcoletoreses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbsubcoletoreses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMdcoletor() != null) {
            _hashCode += getMdcoletor().hashCode();
        }
        _hashCode += new Double(getPrecrelogio()).hashCode();
        if (getStmonitoraespera() != null) {
            _hashCode += getStmonitoraespera().hashCode();
        }
        if (getTpcoletor() != null) {
            _hashCode += getTpcoletor().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbcoletores.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcoletores"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcoletoresId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idalterncoletor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idalterncoletor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmestres");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmestres"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmestres"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbsubcoletoreses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbsubcoletoreses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbsubcoletores"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mdcoletor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mdcoletor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("precrelogio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "precrelogio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stmonitoraespera");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stmonitoraespera"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpcoletor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpcoletor"));
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
