/**
 * Ijamostragemdet.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijamostragemdet  implements java.io.Serializable {
    private idw.idwws.IjamostragemdetId id;

    private idw.idwws.Ijamostragem ijamostragem;

    private idw.idwws.Ijamostragemdetobs[] ijamostragemdetobses;

    private idw.idwws.Ijqldultinsp[] ijqldultinsps;

    private org.apache.axis.types.UnsignedShort resultado;

    private double vllido;

    public Ijamostragemdet() {
    }

    public Ijamostragemdet(
           idw.idwws.IjamostragemdetId id,
           idw.idwws.Ijamostragem ijamostragem,
           idw.idwws.Ijamostragemdetobs[] ijamostragemdetobses,
           idw.idwws.Ijqldultinsp[] ijqldultinsps,
           org.apache.axis.types.UnsignedShort resultado,
           double vllido) {
           this.id = id;
           this.ijamostragem = ijamostragem;
           this.ijamostragemdetobses = ijamostragemdetobses;
           this.ijqldultinsps = ijqldultinsps;
           this.resultado = resultado;
           this.vllido = vllido;
    }


    /**
     * Gets the id value for this Ijamostragemdet.
     * 
     * @return id
     */
    public idw.idwws.IjamostragemdetId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijamostragemdet.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjamostragemdetId id) {
        this.id = id;
    }


    /**
     * Gets the ijamostragem value for this Ijamostragemdet.
     * 
     * @return ijamostragem
     */
    public idw.idwws.Ijamostragem getIjamostragem() {
        return ijamostragem;
    }


    /**
     * Sets the ijamostragem value for this Ijamostragemdet.
     * 
     * @param ijamostragem
     */
    public void setIjamostragem(idw.idwws.Ijamostragem ijamostragem) {
        this.ijamostragem = ijamostragem;
    }


    /**
     * Gets the ijamostragemdetobses value for this Ijamostragemdet.
     * 
     * @return ijamostragemdetobses
     */
    public idw.idwws.Ijamostragemdetobs[] getIjamostragemdetobses() {
        return ijamostragemdetobses;
    }


    /**
     * Sets the ijamostragemdetobses value for this Ijamostragemdet.
     * 
     * @param ijamostragemdetobses
     */
    public void setIjamostragemdetobses(idw.idwws.Ijamostragemdetobs[] ijamostragemdetobses) {
        this.ijamostragemdetobses = ijamostragemdetobses;
    }

    public idw.idwws.Ijamostragemdetobs getIjamostragemdetobses(int i) {
        return this.ijamostragemdetobses[i];
    }

    public void setIjamostragemdetobses(int i, idw.idwws.Ijamostragemdetobs _value) {
        this.ijamostragemdetobses[i] = _value;
    }


    /**
     * Gets the ijqldultinsps value for this Ijamostragemdet.
     * 
     * @return ijqldultinsps
     */
    public idw.idwws.Ijqldultinsp[] getIjqldultinsps() {
        return ijqldultinsps;
    }


    /**
     * Sets the ijqldultinsps value for this Ijamostragemdet.
     * 
     * @param ijqldultinsps
     */
    public void setIjqldultinsps(idw.idwws.Ijqldultinsp[] ijqldultinsps) {
        this.ijqldultinsps = ijqldultinsps;
    }

    public idw.idwws.Ijqldultinsp getIjqldultinsps(int i) {
        return this.ijqldultinsps[i];
    }

    public void setIjqldultinsps(int i, idw.idwws.Ijqldultinsp _value) {
        this.ijqldultinsps[i] = _value;
    }


    /**
     * Gets the resultado value for this Ijamostragemdet.
     * 
     * @return resultado
     */
    public org.apache.axis.types.UnsignedShort getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this Ijamostragemdet.
     * 
     * @param resultado
     */
    public void setResultado(org.apache.axis.types.UnsignedShort resultado) {
        this.resultado = resultado;
    }


    /**
     * Gets the vllido value for this Ijamostragemdet.
     * 
     * @return vllido
     */
    public double getVllido() {
        return vllido;
    }


    /**
     * Sets the vllido value for this Ijamostragemdet.
     * 
     * @param vllido
     */
    public void setVllido(double vllido) {
        this.vllido = vllido;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijamostragemdet)) return false;
        Ijamostragemdet other = (Ijamostragemdet) obj;
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
            ((this.ijamostragem==null && other.getIjamostragem()==null) || 
             (this.ijamostragem!=null &&
              this.ijamostragem.equals(other.getIjamostragem()))) &&
            ((this.ijamostragemdetobses==null && other.getIjamostragemdetobses()==null) || 
             (this.ijamostragemdetobses!=null &&
              java.util.Arrays.equals(this.ijamostragemdetobses, other.getIjamostragemdetobses()))) &&
            ((this.ijqldultinsps==null && other.getIjqldultinsps()==null) || 
             (this.ijqldultinsps!=null &&
              java.util.Arrays.equals(this.ijqldultinsps, other.getIjqldultinsps()))) &&
            ((this.resultado==null && other.getResultado()==null) || 
             (this.resultado!=null &&
              this.resultado.equals(other.getResultado()))) &&
            this.vllido == other.getVllido();
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
        if (getIjamostragem() != null) {
            _hashCode += getIjamostragem().hashCode();
        }
        if (getIjamostragemdetobses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjamostragemdetobses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjamostragemdetobses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjqldultinsps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjqldultinsps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjqldultinsps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        _hashCode += new Double(getVllido()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijamostragemdet.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamostragemdet"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamostragemdetId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijamostragem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijamostragem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamostragem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijamostragemdetobses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijamostragemdetobses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamostragemdetobs"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijqldultinsps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijqldultinsps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijqldultinsp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vllido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vllido"));
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
