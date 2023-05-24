/**
 * PrBridgeCollectorDatabase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PrBridgeCollectorDatabase  implements java.io.Serializable {
    private java.util.Calendar dthrultacessobd;

    private java.lang.String idmasterbridgecollecdatabase;

    private double msdthrultacessobd;

    private idw.idwws.PrConexoesInjet[] prConexoesInjets;

    private org.apache.axis.types.UnsignedShort stonline;

    private double tmptimeoutmaster;

    public PrBridgeCollectorDatabase() {
    }

    public PrBridgeCollectorDatabase(
           java.util.Calendar dthrultacessobd,
           java.lang.String idmasterbridgecollecdatabase,
           double msdthrultacessobd,
           idw.idwws.PrConexoesInjet[] prConexoesInjets,
           org.apache.axis.types.UnsignedShort stonline,
           double tmptimeoutmaster) {
           this.dthrultacessobd = dthrultacessobd;
           this.idmasterbridgecollecdatabase = idmasterbridgecollecdatabase;
           this.msdthrultacessobd = msdthrultacessobd;
           this.prConexoesInjets = prConexoesInjets;
           this.stonline = stonline;
           this.tmptimeoutmaster = tmptimeoutmaster;
    }


    /**
     * Gets the dthrultacessobd value for this PrBridgeCollectorDatabase.
     * 
     * @return dthrultacessobd
     */
    public java.util.Calendar getDthrultacessobd() {
        return dthrultacessobd;
    }


    /**
     * Sets the dthrultacessobd value for this PrBridgeCollectorDatabase.
     * 
     * @param dthrultacessobd
     */
    public void setDthrultacessobd(java.util.Calendar dthrultacessobd) {
        this.dthrultacessobd = dthrultacessobd;
    }


    /**
     * Gets the idmasterbridgecollecdatabase value for this PrBridgeCollectorDatabase.
     * 
     * @return idmasterbridgecollecdatabase
     */
    public java.lang.String getIdmasterbridgecollecdatabase() {
        return idmasterbridgecollecdatabase;
    }


    /**
     * Sets the idmasterbridgecollecdatabase value for this PrBridgeCollectorDatabase.
     * 
     * @param idmasterbridgecollecdatabase
     */
    public void setIdmasterbridgecollecdatabase(java.lang.String idmasterbridgecollecdatabase) {
        this.idmasterbridgecollecdatabase = idmasterbridgecollecdatabase;
    }


    /**
     * Gets the msdthrultacessobd value for this PrBridgeCollectorDatabase.
     * 
     * @return msdthrultacessobd
     */
    public double getMsdthrultacessobd() {
        return msdthrultacessobd;
    }


    /**
     * Sets the msdthrultacessobd value for this PrBridgeCollectorDatabase.
     * 
     * @param msdthrultacessobd
     */
    public void setMsdthrultacessobd(double msdthrultacessobd) {
        this.msdthrultacessobd = msdthrultacessobd;
    }


    /**
     * Gets the prConexoesInjets value for this PrBridgeCollectorDatabase.
     * 
     * @return prConexoesInjets
     */
    public idw.idwws.PrConexoesInjet[] getPrConexoesInjets() {
        return prConexoesInjets;
    }


    /**
     * Sets the prConexoesInjets value for this PrBridgeCollectorDatabase.
     * 
     * @param prConexoesInjets
     */
    public void setPrConexoesInjets(idw.idwws.PrConexoesInjet[] prConexoesInjets) {
        this.prConexoesInjets = prConexoesInjets;
    }

    public idw.idwws.PrConexoesInjet getPrConexoesInjets(int i) {
        return this.prConexoesInjets[i];
    }

    public void setPrConexoesInjets(int i, idw.idwws.PrConexoesInjet _value) {
        this.prConexoesInjets[i] = _value;
    }


    /**
     * Gets the stonline value for this PrBridgeCollectorDatabase.
     * 
     * @return stonline
     */
    public org.apache.axis.types.UnsignedShort getStonline() {
        return stonline;
    }


    /**
     * Sets the stonline value for this PrBridgeCollectorDatabase.
     * 
     * @param stonline
     */
    public void setStonline(org.apache.axis.types.UnsignedShort stonline) {
        this.stonline = stonline;
    }


    /**
     * Gets the tmptimeoutmaster value for this PrBridgeCollectorDatabase.
     * 
     * @return tmptimeoutmaster
     */
    public double getTmptimeoutmaster() {
        return tmptimeoutmaster;
    }


    /**
     * Sets the tmptimeoutmaster value for this PrBridgeCollectorDatabase.
     * 
     * @param tmptimeoutmaster
     */
    public void setTmptimeoutmaster(double tmptimeoutmaster) {
        this.tmptimeoutmaster = tmptimeoutmaster;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrBridgeCollectorDatabase)) return false;
        PrBridgeCollectorDatabase other = (PrBridgeCollectorDatabase) obj;
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
            ((this.idmasterbridgecollecdatabase==null && other.getIdmasterbridgecollecdatabase()==null) || 
             (this.idmasterbridgecollecdatabase!=null &&
              this.idmasterbridgecollecdatabase.equals(other.getIdmasterbridgecollecdatabase()))) &&
            this.msdthrultacessobd == other.getMsdthrultacessobd() &&
            ((this.prConexoesInjets==null && other.getPrConexoesInjets()==null) || 
             (this.prConexoesInjets!=null &&
              java.util.Arrays.equals(this.prConexoesInjets, other.getPrConexoesInjets()))) &&
            ((this.stonline==null && other.getStonline()==null) || 
             (this.stonline!=null &&
              this.stonline.equals(other.getStonline()))) &&
            this.tmptimeoutmaster == other.getTmptimeoutmaster();
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
        if (getIdmasterbridgecollecdatabase() != null) {
            _hashCode += getIdmasterbridgecollecdatabase().hashCode();
        }
        _hashCode += new Double(getMsdthrultacessobd()).hashCode();
        if (getPrConexoesInjets() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrConexoesInjets());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrConexoesInjets(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStonline() != null) {
            _hashCode += getStonline().hashCode();
        }
        _hashCode += new Double(getTmptimeoutmaster()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PrBridgeCollectorDatabase.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prBridgeCollectorDatabase"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrultacessobd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrultacessobd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idmasterbridgecollecdatabase");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idmasterbridgecollecdatabase"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msdthrultacessobd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msdthrultacessobd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prConexoesInjets");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prConexoesInjets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prConexoesInjet"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stonline");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stonline"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tmptimeoutmaster");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmptimeoutmaster"));
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
