/**
 * Ijparprog.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijparprog  implements java.io.Serializable {
    private java.lang.String dsparprog;

    private java.util.Calendar dthrfinal;

    private idw.idwws.IjparprogId id;

    private idw.idwws.Ijparprogos[] ijparprogoses;

    private idw.idwws.Ijtbinj ijtbinj;

    private java.math.BigDecimal origemparprog;

    public Ijparprog() {
    }

    public Ijparprog(
           java.lang.String dsparprog,
           java.util.Calendar dthrfinal,
           idw.idwws.IjparprogId id,
           idw.idwws.Ijparprogos[] ijparprogoses,
           idw.idwws.Ijtbinj ijtbinj,
           java.math.BigDecimal origemparprog) {
           this.dsparprog = dsparprog;
           this.dthrfinal = dthrfinal;
           this.id = id;
           this.ijparprogoses = ijparprogoses;
           this.ijtbinj = ijtbinj;
           this.origemparprog = origemparprog;
    }


    /**
     * Gets the dsparprog value for this Ijparprog.
     * 
     * @return dsparprog
     */
    public java.lang.String getDsparprog() {
        return dsparprog;
    }


    /**
     * Sets the dsparprog value for this Ijparprog.
     * 
     * @param dsparprog
     */
    public void setDsparprog(java.lang.String dsparprog) {
        this.dsparprog = dsparprog;
    }


    /**
     * Gets the dthrfinal value for this Ijparprog.
     * 
     * @return dthrfinal
     */
    public java.util.Calendar getDthrfinal() {
        return dthrfinal;
    }


    /**
     * Sets the dthrfinal value for this Ijparprog.
     * 
     * @param dthrfinal
     */
    public void setDthrfinal(java.util.Calendar dthrfinal) {
        this.dthrfinal = dthrfinal;
    }


    /**
     * Gets the id value for this Ijparprog.
     * 
     * @return id
     */
    public idw.idwws.IjparprogId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijparprog.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjparprogId id) {
        this.id = id;
    }


    /**
     * Gets the ijparprogoses value for this Ijparprog.
     * 
     * @return ijparprogoses
     */
    public idw.idwws.Ijparprogos[] getIjparprogoses() {
        return ijparprogoses;
    }


    /**
     * Sets the ijparprogoses value for this Ijparprog.
     * 
     * @param ijparprogoses
     */
    public void setIjparprogoses(idw.idwws.Ijparprogos[] ijparprogoses) {
        this.ijparprogoses = ijparprogoses;
    }

    public idw.idwws.Ijparprogos getIjparprogoses(int i) {
        return this.ijparprogoses[i];
    }

    public void setIjparprogoses(int i, idw.idwws.Ijparprogos _value) {
        this.ijparprogoses[i] = _value;
    }


    /**
     * Gets the ijtbinj value for this Ijparprog.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijparprog.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the origemparprog value for this Ijparprog.
     * 
     * @return origemparprog
     */
    public java.math.BigDecimal getOrigemparprog() {
        return origemparprog;
    }


    /**
     * Sets the origemparprog value for this Ijparprog.
     * 
     * @param origemparprog
     */
    public void setOrigemparprog(java.math.BigDecimal origemparprog) {
        this.origemparprog = origemparprog;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijparprog)) return false;
        Ijparprog other = (Ijparprog) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dsparprog==null && other.getDsparprog()==null) || 
             (this.dsparprog!=null &&
              this.dsparprog.equals(other.getDsparprog()))) &&
            ((this.dthrfinal==null && other.getDthrfinal()==null) || 
             (this.dthrfinal!=null &&
              this.dthrfinal.equals(other.getDthrfinal()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijparprogoses==null && other.getIjparprogoses()==null) || 
             (this.ijparprogoses!=null &&
              java.util.Arrays.equals(this.ijparprogoses, other.getIjparprogoses()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.origemparprog==null && other.getOrigemparprog()==null) || 
             (this.origemparprog!=null &&
              this.origemparprog.equals(other.getOrigemparprog())));
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
        if (getDsparprog() != null) {
            _hashCode += getDsparprog().hashCode();
        }
        if (getDthrfinal() != null) {
            _hashCode += getDthrfinal().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjparprogoses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjparprogoses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjparprogoses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getOrigemparprog() != null) {
            _hashCode += getOrigemparprog().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijparprog.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijparprog"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsparprog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsparprog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijparprogId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijparprogoses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijparprogoses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijparprogos"));
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
        elemField.setFieldName("origemparprog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "origemparprog"));
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
