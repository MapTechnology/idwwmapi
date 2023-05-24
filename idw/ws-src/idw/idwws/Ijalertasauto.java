/**
 * Ijalertasauto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijalertasauto  implements java.io.Serializable {
    private java.util.Calendar dthrfalertaauto;

    private java.util.Calendar dthrivalestru;

    private idw.idwws.IjalertasautoId id;

    private idw.idwws.Ijestmol ijestmol;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijtbaleauto ijtbaleauto;

    private idw.idwws.Ijtbinj ijtbinj;

    public Ijalertasauto() {
    }

    public Ijalertasauto(
           java.util.Calendar dthrfalertaauto,
           java.util.Calendar dthrivalestru,
           idw.idwws.IjalertasautoId id,
           idw.idwws.Ijestmol ijestmol,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijtbaleauto ijtbaleauto,
           idw.idwws.Ijtbinj ijtbinj) {
           this.dthrfalertaauto = dthrfalertaauto;
           this.dthrivalestru = dthrivalestru;
           this.id = id;
           this.ijestmol = ijestmol;
           this.ijop = ijop;
           this.ijtbaleauto = ijtbaleauto;
           this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the dthrfalertaauto value for this Ijalertasauto.
     * 
     * @return dthrfalertaauto
     */
    public java.util.Calendar getDthrfalertaauto() {
        return dthrfalertaauto;
    }


    /**
     * Sets the dthrfalertaauto value for this Ijalertasauto.
     * 
     * @param dthrfalertaauto
     */
    public void setDthrfalertaauto(java.util.Calendar dthrfalertaauto) {
        this.dthrfalertaauto = dthrfalertaauto;
    }


    /**
     * Gets the dthrivalestru value for this Ijalertasauto.
     * 
     * @return dthrivalestru
     */
    public java.util.Calendar getDthrivalestru() {
        return dthrivalestru;
    }


    /**
     * Sets the dthrivalestru value for this Ijalertasauto.
     * 
     * @param dthrivalestru
     */
    public void setDthrivalestru(java.util.Calendar dthrivalestru) {
        this.dthrivalestru = dthrivalestru;
    }


    /**
     * Gets the id value for this Ijalertasauto.
     * 
     * @return id
     */
    public idw.idwws.IjalertasautoId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijalertasauto.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjalertasautoId id) {
        this.id = id;
    }


    /**
     * Gets the ijestmol value for this Ijalertasauto.
     * 
     * @return ijestmol
     */
    public idw.idwws.Ijestmol getIjestmol() {
        return ijestmol;
    }


    /**
     * Sets the ijestmol value for this Ijalertasauto.
     * 
     * @param ijestmol
     */
    public void setIjestmol(idw.idwws.Ijestmol ijestmol) {
        this.ijestmol = ijestmol;
    }


    /**
     * Gets the ijop value for this Ijalertasauto.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijalertasauto.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijtbaleauto value for this Ijalertasauto.
     * 
     * @return ijtbaleauto
     */
    public idw.idwws.Ijtbaleauto getIjtbaleauto() {
        return ijtbaleauto;
    }


    /**
     * Sets the ijtbaleauto value for this Ijalertasauto.
     * 
     * @param ijtbaleauto
     */
    public void setIjtbaleauto(idw.idwws.Ijtbaleauto ijtbaleauto) {
        this.ijtbaleauto = ijtbaleauto;
    }


    /**
     * Gets the ijtbinj value for this Ijalertasauto.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijalertasauto.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijalertasauto)) return false;
        Ijalertasauto other = (Ijalertasauto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrfalertaauto==null && other.getDthrfalertaauto()==null) || 
             (this.dthrfalertaauto!=null &&
              this.dthrfalertaauto.equals(other.getDthrfalertaauto()))) &&
            ((this.dthrivalestru==null && other.getDthrivalestru()==null) || 
             (this.dthrivalestru!=null &&
              this.dthrivalestru.equals(other.getDthrivalestru()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijestmol==null && other.getIjestmol()==null) || 
             (this.ijestmol!=null &&
              this.ijestmol.equals(other.getIjestmol()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijtbaleauto==null && other.getIjtbaleauto()==null) || 
             (this.ijtbaleauto!=null &&
              this.ijtbaleauto.equals(other.getIjtbaleauto()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj())));
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
        if (getDthrfalertaauto() != null) {
            _hashCode += getDthrfalertaauto().hashCode();
        }
        if (getDthrivalestru() != null) {
            _hashCode += getDthrivalestru().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjestmol() != null) {
            _hashCode += getIjestmol().hashCode();
        }
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjtbaleauto() != null) {
            _hashCode += getIjtbaleauto().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijalertasauto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijalertasauto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfalertaauto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfalertaauto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrivalestru");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrivalestru"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijalertasautoId"));
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
        elemField.setFieldName("ijop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbaleauto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbaleauto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbaleauto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
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
