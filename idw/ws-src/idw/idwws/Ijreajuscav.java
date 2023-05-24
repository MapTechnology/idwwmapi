/**
 * Ijreajuscav.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijreajuscav  implements java.io.Serializable {
    private java.lang.String cdturnoref;

    private java.util.Calendar dtrefturno;

    private idw.idwws.IjreajuscavId id;

    private idw.idwws.Ijestmol ijestmol;

    private idw.idwws.Ijtbjuscav ijtbjuscav;

    private idw.idwws.Ijtbusu ijtbusu;

    public Ijreajuscav() {
    }

    public Ijreajuscav(
           java.lang.String cdturnoref,
           java.util.Calendar dtrefturno,
           idw.idwws.IjreajuscavId id,
           idw.idwws.Ijestmol ijestmol,
           idw.idwws.Ijtbjuscav ijtbjuscav,
           idw.idwws.Ijtbusu ijtbusu) {
           this.cdturnoref = cdturnoref;
           this.dtrefturno = dtrefturno;
           this.id = id;
           this.ijestmol = ijestmol;
           this.ijtbjuscav = ijtbjuscav;
           this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the cdturnoref value for this Ijreajuscav.
     * 
     * @return cdturnoref
     */
    public java.lang.String getCdturnoref() {
        return cdturnoref;
    }


    /**
     * Sets the cdturnoref value for this Ijreajuscav.
     * 
     * @param cdturnoref
     */
    public void setCdturnoref(java.lang.String cdturnoref) {
        this.cdturnoref = cdturnoref;
    }


    /**
     * Gets the dtrefturno value for this Ijreajuscav.
     * 
     * @return dtrefturno
     */
    public java.util.Calendar getDtrefturno() {
        return dtrefturno;
    }


    /**
     * Sets the dtrefturno value for this Ijreajuscav.
     * 
     * @param dtrefturno
     */
    public void setDtrefturno(java.util.Calendar dtrefturno) {
        this.dtrefturno = dtrefturno;
    }


    /**
     * Gets the id value for this Ijreajuscav.
     * 
     * @return id
     */
    public idw.idwws.IjreajuscavId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijreajuscav.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjreajuscavId id) {
        this.id = id;
    }


    /**
     * Gets the ijestmol value for this Ijreajuscav.
     * 
     * @return ijestmol
     */
    public idw.idwws.Ijestmol getIjestmol() {
        return ijestmol;
    }


    /**
     * Sets the ijestmol value for this Ijreajuscav.
     * 
     * @param ijestmol
     */
    public void setIjestmol(idw.idwws.Ijestmol ijestmol) {
        this.ijestmol = ijestmol;
    }


    /**
     * Gets the ijtbjuscav value for this Ijreajuscav.
     * 
     * @return ijtbjuscav
     */
    public idw.idwws.Ijtbjuscav getIjtbjuscav() {
        return ijtbjuscav;
    }


    /**
     * Sets the ijtbjuscav value for this Ijreajuscav.
     * 
     * @param ijtbjuscav
     */
    public void setIjtbjuscav(idw.idwws.Ijtbjuscav ijtbjuscav) {
        this.ijtbjuscav = ijtbjuscav;
    }


    /**
     * Gets the ijtbusu value for this Ijreajuscav.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijreajuscav.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijreajuscav)) return false;
        Ijreajuscav other = (Ijreajuscav) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdturnoref==null && other.getCdturnoref()==null) || 
             (this.cdturnoref!=null &&
              this.cdturnoref.equals(other.getCdturnoref()))) &&
            ((this.dtrefturno==null && other.getDtrefturno()==null) || 
             (this.dtrefturno!=null &&
              this.dtrefturno.equals(other.getDtrefturno()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijestmol==null && other.getIjestmol()==null) || 
             (this.ijestmol!=null &&
              this.ijestmol.equals(other.getIjestmol()))) &&
            ((this.ijtbjuscav==null && other.getIjtbjuscav()==null) || 
             (this.ijtbjuscav!=null &&
              this.ijtbjuscav.equals(other.getIjtbjuscav()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu())));
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
        if (getCdturnoref() != null) {
            _hashCode += getCdturnoref().hashCode();
        }
        if (getDtrefturno() != null) {
            _hashCode += getDtrefturno().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjestmol() != null) {
            _hashCode += getIjestmol().hashCode();
        }
        if (getIjtbjuscav() != null) {
            _hashCode += getIjtbjuscav().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijreajuscav.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreajuscav"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdturnoref");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdturnoref"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtrefturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtrefturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreajuscavId"));
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
        elemField.setFieldName("ijtbjuscav");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbjuscav"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbjuscav"));
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
