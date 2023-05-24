/**
 * Ijtbclixcttcgq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbclixcttcgq  implements java.io.Serializable {
    private java.lang.String depto;

    private org.apache.axis.types.UnsignedShort excluido;

    private idw.idwws.IjtbclixcttcgqId id;

    private idw.idwws.Ijctrlcgqxctts[] ijctrlcgqxcttses;

    private idw.idwws.Ijtbclixplantas ijtbclixplantas;

    private java.lang.String nomectt;

    private org.apache.axis.types.UnsignedShort stativo;

    private org.apache.axis.types.UnsignedShort tpcontato;

    public Ijtbclixcttcgq() {
    }

    public Ijtbclixcttcgq(
           java.lang.String depto,
           org.apache.axis.types.UnsignedShort excluido,
           idw.idwws.IjtbclixcttcgqId id,
           idw.idwws.Ijctrlcgqxctts[] ijctrlcgqxcttses,
           idw.idwws.Ijtbclixplantas ijtbclixplantas,
           java.lang.String nomectt,
           org.apache.axis.types.UnsignedShort stativo,
           org.apache.axis.types.UnsignedShort tpcontato) {
           this.depto = depto;
           this.excluido = excluido;
           this.id = id;
           this.ijctrlcgqxcttses = ijctrlcgqxcttses;
           this.ijtbclixplantas = ijtbclixplantas;
           this.nomectt = nomectt;
           this.stativo = stativo;
           this.tpcontato = tpcontato;
    }


    /**
     * Gets the depto value for this Ijtbclixcttcgq.
     * 
     * @return depto
     */
    public java.lang.String getDepto() {
        return depto;
    }


    /**
     * Sets the depto value for this Ijtbclixcttcgq.
     * 
     * @param depto
     */
    public void setDepto(java.lang.String depto) {
        this.depto = depto;
    }


    /**
     * Gets the excluido value for this Ijtbclixcttcgq.
     * 
     * @return excluido
     */
    public org.apache.axis.types.UnsignedShort getExcluido() {
        return excluido;
    }


    /**
     * Sets the excluido value for this Ijtbclixcttcgq.
     * 
     * @param excluido
     */
    public void setExcluido(org.apache.axis.types.UnsignedShort excluido) {
        this.excluido = excluido;
    }


    /**
     * Gets the id value for this Ijtbclixcttcgq.
     * 
     * @return id
     */
    public idw.idwws.IjtbclixcttcgqId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijtbclixcttcgq.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjtbclixcttcgqId id) {
        this.id = id;
    }


    /**
     * Gets the ijctrlcgqxcttses value for this Ijtbclixcttcgq.
     * 
     * @return ijctrlcgqxcttses
     */
    public idw.idwws.Ijctrlcgqxctts[] getIjctrlcgqxcttses() {
        return ijctrlcgqxcttses;
    }


    /**
     * Sets the ijctrlcgqxcttses value for this Ijtbclixcttcgq.
     * 
     * @param ijctrlcgqxcttses
     */
    public void setIjctrlcgqxcttses(idw.idwws.Ijctrlcgqxctts[] ijctrlcgqxcttses) {
        this.ijctrlcgqxcttses = ijctrlcgqxcttses;
    }

    public idw.idwws.Ijctrlcgqxctts getIjctrlcgqxcttses(int i) {
        return this.ijctrlcgqxcttses[i];
    }

    public void setIjctrlcgqxcttses(int i, idw.idwws.Ijctrlcgqxctts _value) {
        this.ijctrlcgqxcttses[i] = _value;
    }


    /**
     * Gets the ijtbclixplantas value for this Ijtbclixcttcgq.
     * 
     * @return ijtbclixplantas
     */
    public idw.idwws.Ijtbclixplantas getIjtbclixplantas() {
        return ijtbclixplantas;
    }


    /**
     * Sets the ijtbclixplantas value for this Ijtbclixcttcgq.
     * 
     * @param ijtbclixplantas
     */
    public void setIjtbclixplantas(idw.idwws.Ijtbclixplantas ijtbclixplantas) {
        this.ijtbclixplantas = ijtbclixplantas;
    }


    /**
     * Gets the nomectt value for this Ijtbclixcttcgq.
     * 
     * @return nomectt
     */
    public java.lang.String getNomectt() {
        return nomectt;
    }


    /**
     * Sets the nomectt value for this Ijtbclixcttcgq.
     * 
     * @param nomectt
     */
    public void setNomectt(java.lang.String nomectt) {
        this.nomectt = nomectt;
    }


    /**
     * Gets the stativo value for this Ijtbclixcttcgq.
     * 
     * @return stativo
     */
    public org.apache.axis.types.UnsignedShort getStativo() {
        return stativo;
    }


    /**
     * Sets the stativo value for this Ijtbclixcttcgq.
     * 
     * @param stativo
     */
    public void setStativo(org.apache.axis.types.UnsignedShort stativo) {
        this.stativo = stativo;
    }


    /**
     * Gets the tpcontato value for this Ijtbclixcttcgq.
     * 
     * @return tpcontato
     */
    public org.apache.axis.types.UnsignedShort getTpcontato() {
        return tpcontato;
    }


    /**
     * Sets the tpcontato value for this Ijtbclixcttcgq.
     * 
     * @param tpcontato
     */
    public void setTpcontato(org.apache.axis.types.UnsignedShort tpcontato) {
        this.tpcontato = tpcontato;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbclixcttcgq)) return false;
        Ijtbclixcttcgq other = (Ijtbclixcttcgq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.depto==null && other.getDepto()==null) || 
             (this.depto!=null &&
              this.depto.equals(other.getDepto()))) &&
            ((this.excluido==null && other.getExcluido()==null) || 
             (this.excluido!=null &&
              this.excluido.equals(other.getExcluido()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijctrlcgqxcttses==null && other.getIjctrlcgqxcttses()==null) || 
             (this.ijctrlcgqxcttses!=null &&
              java.util.Arrays.equals(this.ijctrlcgqxcttses, other.getIjctrlcgqxcttses()))) &&
            ((this.ijtbclixplantas==null && other.getIjtbclixplantas()==null) || 
             (this.ijtbclixplantas!=null &&
              this.ijtbclixplantas.equals(other.getIjtbclixplantas()))) &&
            ((this.nomectt==null && other.getNomectt()==null) || 
             (this.nomectt!=null &&
              this.nomectt.equals(other.getNomectt()))) &&
            ((this.stativo==null && other.getStativo()==null) || 
             (this.stativo!=null &&
              this.stativo.equals(other.getStativo()))) &&
            ((this.tpcontato==null && other.getTpcontato()==null) || 
             (this.tpcontato!=null &&
              this.tpcontato.equals(other.getTpcontato())));
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
        if (getDepto() != null) {
            _hashCode += getDepto().hashCode();
        }
        if (getExcluido() != null) {
            _hashCode += getExcluido().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjctrlcgqxcttses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjctrlcgqxcttses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjctrlcgqxcttses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbclixplantas() != null) {
            _hashCode += getIjtbclixplantas().hashCode();
        }
        if (getNomectt() != null) {
            _hashCode += getNomectt().hashCode();
        }
        if (getStativo() != null) {
            _hashCode += getStativo().hashCode();
        }
        if (getTpcontato() != null) {
            _hashCode += getTpcontato().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbclixcttcgq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbclixcttcgq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "depto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("excluido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "excluido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbclixcttcgqId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrlcgqxcttses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrlcgqxcttses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlcgqxctts"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbclixplantas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbclixplantas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbclixplantas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomectt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nomectt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpcontato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpcontato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
