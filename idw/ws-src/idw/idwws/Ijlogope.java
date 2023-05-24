/**
 * Ijlogope.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijlogope  implements java.io.Serializable {
    private java.util.Calendar dthrivalestru;

    private java.util.Calendar dthrlogout;

    private idw.idwws.IjlogopeId id;

    private idw.idwws.Ijestmol ijestmol;

    private idw.idwws.Ijtbusu ijtbusu;

    private java.lang.String nrop;

    private org.apache.axis.types.UnsignedShort operadorauxiliar;

    private java.math.BigDecimal quedaescravo;

    public Ijlogope() {
    }

    public Ijlogope(
           java.util.Calendar dthrivalestru,
           java.util.Calendar dthrlogout,
           idw.idwws.IjlogopeId id,
           idw.idwws.Ijestmol ijestmol,
           idw.idwws.Ijtbusu ijtbusu,
           java.lang.String nrop,
           org.apache.axis.types.UnsignedShort operadorauxiliar,
           java.math.BigDecimal quedaescravo) {
           this.dthrivalestru = dthrivalestru;
           this.dthrlogout = dthrlogout;
           this.id = id;
           this.ijestmol = ijestmol;
           this.ijtbusu = ijtbusu;
           this.nrop = nrop;
           this.operadorauxiliar = operadorauxiliar;
           this.quedaescravo = quedaescravo;
    }


    /**
     * Gets the dthrivalestru value for this Ijlogope.
     * 
     * @return dthrivalestru
     */
    public java.util.Calendar getDthrivalestru() {
        return dthrivalestru;
    }


    /**
     * Sets the dthrivalestru value for this Ijlogope.
     * 
     * @param dthrivalestru
     */
    public void setDthrivalestru(java.util.Calendar dthrivalestru) {
        this.dthrivalestru = dthrivalestru;
    }


    /**
     * Gets the dthrlogout value for this Ijlogope.
     * 
     * @return dthrlogout
     */
    public java.util.Calendar getDthrlogout() {
        return dthrlogout;
    }


    /**
     * Sets the dthrlogout value for this Ijlogope.
     * 
     * @param dthrlogout
     */
    public void setDthrlogout(java.util.Calendar dthrlogout) {
        this.dthrlogout = dthrlogout;
    }


    /**
     * Gets the id value for this Ijlogope.
     * 
     * @return id
     */
    public idw.idwws.IjlogopeId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijlogope.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjlogopeId id) {
        this.id = id;
    }


    /**
     * Gets the ijestmol value for this Ijlogope.
     * 
     * @return ijestmol
     */
    public idw.idwws.Ijestmol getIjestmol() {
        return ijestmol;
    }


    /**
     * Sets the ijestmol value for this Ijlogope.
     * 
     * @param ijestmol
     */
    public void setIjestmol(idw.idwws.Ijestmol ijestmol) {
        this.ijestmol = ijestmol;
    }


    /**
     * Gets the ijtbusu value for this Ijlogope.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijlogope.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the nrop value for this Ijlogope.
     * 
     * @return nrop
     */
    public java.lang.String getNrop() {
        return nrop;
    }


    /**
     * Sets the nrop value for this Ijlogope.
     * 
     * @param nrop
     */
    public void setNrop(java.lang.String nrop) {
        this.nrop = nrop;
    }


    /**
     * Gets the operadorauxiliar value for this Ijlogope.
     * 
     * @return operadorauxiliar
     */
    public org.apache.axis.types.UnsignedShort getOperadorauxiliar() {
        return operadorauxiliar;
    }


    /**
     * Sets the operadorauxiliar value for this Ijlogope.
     * 
     * @param operadorauxiliar
     */
    public void setOperadorauxiliar(org.apache.axis.types.UnsignedShort operadorauxiliar) {
        this.operadorauxiliar = operadorauxiliar;
    }


    /**
     * Gets the quedaescravo value for this Ijlogope.
     * 
     * @return quedaescravo
     */
    public java.math.BigDecimal getQuedaescravo() {
        return quedaescravo;
    }


    /**
     * Sets the quedaescravo value for this Ijlogope.
     * 
     * @param quedaescravo
     */
    public void setQuedaescravo(java.math.BigDecimal quedaescravo) {
        this.quedaescravo = quedaescravo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijlogope)) return false;
        Ijlogope other = (Ijlogope) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrivalestru==null && other.getDthrivalestru()==null) || 
             (this.dthrivalestru!=null &&
              this.dthrivalestru.equals(other.getDthrivalestru()))) &&
            ((this.dthrlogout==null && other.getDthrlogout()==null) || 
             (this.dthrlogout!=null &&
              this.dthrlogout.equals(other.getDthrlogout()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijestmol==null && other.getIjestmol()==null) || 
             (this.ijestmol!=null &&
              this.ijestmol.equals(other.getIjestmol()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu()))) &&
            ((this.nrop==null && other.getNrop()==null) || 
             (this.nrop!=null &&
              this.nrop.equals(other.getNrop()))) &&
            ((this.operadorauxiliar==null && other.getOperadorauxiliar()==null) || 
             (this.operadorauxiliar!=null &&
              this.operadorauxiliar.equals(other.getOperadorauxiliar()))) &&
            ((this.quedaescravo==null && other.getQuedaescravo()==null) || 
             (this.quedaescravo!=null &&
              this.quedaescravo.equals(other.getQuedaescravo())));
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
        if (getDthrivalestru() != null) {
            _hashCode += getDthrivalestru().hashCode();
        }
        if (getDthrlogout() != null) {
            _hashCode += getDthrlogout().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjestmol() != null) {
            _hashCode += getIjestmol().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        if (getNrop() != null) {
            _hashCode += getNrop().hashCode();
        }
        if (getOperadorauxiliar() != null) {
            _hashCode += getOperadorauxiliar().hashCode();
        }
        if (getQuedaescravo() != null) {
            _hashCode += getQuedaescravo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijlogope.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlogope"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrivalestru");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrivalestru"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrlogout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrlogout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlogopeId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijestmol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijestmol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operadorauxiliar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operadorauxiliar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quedaescravo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quedaescravo"));
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
