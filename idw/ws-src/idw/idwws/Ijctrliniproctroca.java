/**
 * Ijctrliniproctroca.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijctrliniproctroca  implements java.io.Serializable {
    private java.lang.String idctrlinicproc;

    private idw.idwws.Ijctrliniproc ijctrliniproc;

    private idw.idwws.Ijestmol ijestmolBySysC0013001;

    private idw.idwws.Ijestmol ijestmolBySysC0013002;

    private idw.idwws.Ijop ijop;

    public Ijctrliniproctroca() {
    }

    public Ijctrliniproctroca(
           java.lang.String idctrlinicproc,
           idw.idwws.Ijctrliniproc ijctrliniproc,
           idw.idwws.Ijestmol ijestmolBySysC0013001,
           idw.idwws.Ijestmol ijestmolBySysC0013002,
           idw.idwws.Ijop ijop) {
           this.idctrlinicproc = idctrlinicproc;
           this.ijctrliniproc = ijctrliniproc;
           this.ijestmolBySysC0013001 = ijestmolBySysC0013001;
           this.ijestmolBySysC0013002 = ijestmolBySysC0013002;
           this.ijop = ijop;
    }


    /**
     * Gets the idctrlinicproc value for this Ijctrliniproctroca.
     * 
     * @return idctrlinicproc
     */
    public java.lang.String getIdctrlinicproc() {
        return idctrlinicproc;
    }


    /**
     * Sets the idctrlinicproc value for this Ijctrliniproctroca.
     * 
     * @param idctrlinicproc
     */
    public void setIdctrlinicproc(java.lang.String idctrlinicproc) {
        this.idctrlinicproc = idctrlinicproc;
    }


    /**
     * Gets the ijctrliniproc value for this Ijctrliniproctroca.
     * 
     * @return ijctrliniproc
     */
    public idw.idwws.Ijctrliniproc getIjctrliniproc() {
        return ijctrliniproc;
    }


    /**
     * Sets the ijctrliniproc value for this Ijctrliniproctroca.
     * 
     * @param ijctrliniproc
     */
    public void setIjctrliniproc(idw.idwws.Ijctrliniproc ijctrliniproc) {
        this.ijctrliniproc = ijctrliniproc;
    }


    /**
     * Gets the ijestmolBySysC0013001 value for this Ijctrliniproctroca.
     * 
     * @return ijestmolBySysC0013001
     */
    public idw.idwws.Ijestmol getIjestmolBySysC0013001() {
        return ijestmolBySysC0013001;
    }


    /**
     * Sets the ijestmolBySysC0013001 value for this Ijctrliniproctroca.
     * 
     * @param ijestmolBySysC0013001
     */
    public void setIjestmolBySysC0013001(idw.idwws.Ijestmol ijestmolBySysC0013001) {
        this.ijestmolBySysC0013001 = ijestmolBySysC0013001;
    }


    /**
     * Gets the ijestmolBySysC0013002 value for this Ijctrliniproctroca.
     * 
     * @return ijestmolBySysC0013002
     */
    public idw.idwws.Ijestmol getIjestmolBySysC0013002() {
        return ijestmolBySysC0013002;
    }


    /**
     * Sets the ijestmolBySysC0013002 value for this Ijctrliniproctroca.
     * 
     * @param ijestmolBySysC0013002
     */
    public void setIjestmolBySysC0013002(idw.idwws.Ijestmol ijestmolBySysC0013002) {
        this.ijestmolBySysC0013002 = ijestmolBySysC0013002;
    }


    /**
     * Gets the ijop value for this Ijctrliniproctroca.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijctrliniproctroca.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijctrliniproctroca)) return false;
        Ijctrliniproctroca other = (Ijctrliniproctroca) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idctrlinicproc==null && other.getIdctrlinicproc()==null) || 
             (this.idctrlinicproc!=null &&
              this.idctrlinicproc.equals(other.getIdctrlinicproc()))) &&
            ((this.ijctrliniproc==null && other.getIjctrliniproc()==null) || 
             (this.ijctrliniproc!=null &&
              this.ijctrliniproc.equals(other.getIjctrliniproc()))) &&
            ((this.ijestmolBySysC0013001==null && other.getIjestmolBySysC0013001()==null) || 
             (this.ijestmolBySysC0013001!=null &&
              this.ijestmolBySysC0013001.equals(other.getIjestmolBySysC0013001()))) &&
            ((this.ijestmolBySysC0013002==null && other.getIjestmolBySysC0013002()==null) || 
             (this.ijestmolBySysC0013002!=null &&
              this.ijestmolBySysC0013002.equals(other.getIjestmolBySysC0013002()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop())));
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
        if (getIdctrlinicproc() != null) {
            _hashCode += getIdctrlinicproc().hashCode();
        }
        if (getIjctrliniproc() != null) {
            _hashCode += getIjctrliniproc().hashCode();
        }
        if (getIjestmolBySysC0013001() != null) {
            _hashCode += getIjestmolBySysC0013001().hashCode();
        }
        if (getIjestmolBySysC0013002() != null) {
            _hashCode += getIjestmolBySysC0013002().hashCode();
        }
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijctrliniproctroca.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrliniproctroca"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idctrlinicproc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idctrlinicproc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrliniproc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrliniproc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrliniproc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijestmolBySysC0013001");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijestmolBySysC0013001"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijestmolBySysC0013002");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijestmolBySysC0013002"));
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
