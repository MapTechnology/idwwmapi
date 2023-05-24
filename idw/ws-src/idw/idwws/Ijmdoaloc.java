/**
 * Ijmdoaloc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijmdoaloc  implements java.io.Serializable {
    private java.util.Calendar dthrfval;

    private java.util.Calendar dthrinival;

    private java.lang.String idmdoaloc;

    private idw.idwws.Ijmdoalocdet[] ijmdoalocdets;

    private idw.idwws.Ijmdoalocop[] ijmdoalocops;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbpro ijtbpro;

    private idw.idwws.Ijtbusu ijtbusu;

    public Ijmdoaloc() {
    }

    public Ijmdoaloc(
           java.util.Calendar dthrfval,
           java.util.Calendar dthrinival,
           java.lang.String idmdoaloc,
           idw.idwws.Ijmdoalocdet[] ijmdoalocdets,
           idw.idwws.Ijmdoalocop[] ijmdoalocops,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbpro ijtbpro,
           idw.idwws.Ijtbusu ijtbusu) {
           this.dthrfval = dthrfval;
           this.dthrinival = dthrinival;
           this.idmdoaloc = idmdoaloc;
           this.ijmdoalocdets = ijmdoalocdets;
           this.ijmdoalocops = ijmdoalocops;
           this.ijtbinj = ijtbinj;
           this.ijtbpro = ijtbpro;
           this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the dthrfval value for this Ijmdoaloc.
     * 
     * @return dthrfval
     */
    public java.util.Calendar getDthrfval() {
        return dthrfval;
    }


    /**
     * Sets the dthrfval value for this Ijmdoaloc.
     * 
     * @param dthrfval
     */
    public void setDthrfval(java.util.Calendar dthrfval) {
        this.dthrfval = dthrfval;
    }


    /**
     * Gets the dthrinival value for this Ijmdoaloc.
     * 
     * @return dthrinival
     */
    public java.util.Calendar getDthrinival() {
        return dthrinival;
    }


    /**
     * Sets the dthrinival value for this Ijmdoaloc.
     * 
     * @param dthrinival
     */
    public void setDthrinival(java.util.Calendar dthrinival) {
        this.dthrinival = dthrinival;
    }


    /**
     * Gets the idmdoaloc value for this Ijmdoaloc.
     * 
     * @return idmdoaloc
     */
    public java.lang.String getIdmdoaloc() {
        return idmdoaloc;
    }


    /**
     * Sets the idmdoaloc value for this Ijmdoaloc.
     * 
     * @param idmdoaloc
     */
    public void setIdmdoaloc(java.lang.String idmdoaloc) {
        this.idmdoaloc = idmdoaloc;
    }


    /**
     * Gets the ijmdoalocdets value for this Ijmdoaloc.
     * 
     * @return ijmdoalocdets
     */
    public idw.idwws.Ijmdoalocdet[] getIjmdoalocdets() {
        return ijmdoalocdets;
    }


    /**
     * Sets the ijmdoalocdets value for this Ijmdoaloc.
     * 
     * @param ijmdoalocdets
     */
    public void setIjmdoalocdets(idw.idwws.Ijmdoalocdet[] ijmdoalocdets) {
        this.ijmdoalocdets = ijmdoalocdets;
    }

    public idw.idwws.Ijmdoalocdet getIjmdoalocdets(int i) {
        return this.ijmdoalocdets[i];
    }

    public void setIjmdoalocdets(int i, idw.idwws.Ijmdoalocdet _value) {
        this.ijmdoalocdets[i] = _value;
    }


    /**
     * Gets the ijmdoalocops value for this Ijmdoaloc.
     * 
     * @return ijmdoalocops
     */
    public idw.idwws.Ijmdoalocop[] getIjmdoalocops() {
        return ijmdoalocops;
    }


    /**
     * Sets the ijmdoalocops value for this Ijmdoaloc.
     * 
     * @param ijmdoalocops
     */
    public void setIjmdoalocops(idw.idwws.Ijmdoalocop[] ijmdoalocops) {
        this.ijmdoalocops = ijmdoalocops;
    }

    public idw.idwws.Ijmdoalocop getIjmdoalocops(int i) {
        return this.ijmdoalocops[i];
    }

    public void setIjmdoalocops(int i, idw.idwws.Ijmdoalocop _value) {
        this.ijmdoalocops[i] = _value;
    }


    /**
     * Gets the ijtbinj value for this Ijmdoaloc.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijmdoaloc.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbpro value for this Ijmdoaloc.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijmdoaloc.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the ijtbusu value for this Ijmdoaloc.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijmdoaloc.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijmdoaloc)) return false;
        Ijmdoaloc other = (Ijmdoaloc) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrfval==null && other.getDthrfval()==null) || 
             (this.dthrfval!=null &&
              this.dthrfval.equals(other.getDthrfval()))) &&
            ((this.dthrinival==null && other.getDthrinival()==null) || 
             (this.dthrinival!=null &&
              this.dthrinival.equals(other.getDthrinival()))) &&
            ((this.idmdoaloc==null && other.getIdmdoaloc()==null) || 
             (this.idmdoaloc!=null &&
              this.idmdoaloc.equals(other.getIdmdoaloc()))) &&
            ((this.ijmdoalocdets==null && other.getIjmdoalocdets()==null) || 
             (this.ijmdoalocdets!=null &&
              java.util.Arrays.equals(this.ijmdoalocdets, other.getIjmdoalocdets()))) &&
            ((this.ijmdoalocops==null && other.getIjmdoalocops()==null) || 
             (this.ijmdoalocops!=null &&
              java.util.Arrays.equals(this.ijmdoalocops, other.getIjmdoalocops()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
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
        if (getDthrfval() != null) {
            _hashCode += getDthrfval().hashCode();
        }
        if (getDthrinival() != null) {
            _hashCode += getDthrinival().hashCode();
        }
        if (getIdmdoaloc() != null) {
            _hashCode += getIdmdoaloc().hashCode();
        }
        if (getIjmdoalocdets() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmdoalocdets());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmdoalocdets(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmdoalocops() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmdoalocops());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmdoalocops(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijmdoaloc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmdoaloc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfval");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfval"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrinival");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrinival"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idmdoaloc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idmdoaloc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmdoalocdets");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmdoalocdets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmdoalocdet"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmdoalocops");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmdoalocops"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmdoalocop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
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
