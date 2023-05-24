/**
 * Ijcomppromprima.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijcomppromprima  implements java.io.Serializable {
    private java.util.Calendar dtfimval;

    private java.util.Calendar dtinival;

    private idw.idwws.IjcomppromprimaId id;

    private idw.idwws.Ijtbmprima ijtbmprima;

    private idw.idwws.Ijtbpro ijtbpro;

    private double perccomposicao;

    public Ijcomppromprima() {
    }

    public Ijcomppromprima(
           java.util.Calendar dtfimval,
           java.util.Calendar dtinival,
           idw.idwws.IjcomppromprimaId id,
           idw.idwws.Ijtbmprima ijtbmprima,
           idw.idwws.Ijtbpro ijtbpro,
           double perccomposicao) {
           this.dtfimval = dtfimval;
           this.dtinival = dtinival;
           this.id = id;
           this.ijtbmprima = ijtbmprima;
           this.ijtbpro = ijtbpro;
           this.perccomposicao = perccomposicao;
    }


    /**
     * Gets the dtfimval value for this Ijcomppromprima.
     * 
     * @return dtfimval
     */
    public java.util.Calendar getDtfimval() {
        return dtfimval;
    }


    /**
     * Sets the dtfimval value for this Ijcomppromprima.
     * 
     * @param dtfimval
     */
    public void setDtfimval(java.util.Calendar dtfimval) {
        this.dtfimval = dtfimval;
    }


    /**
     * Gets the dtinival value for this Ijcomppromprima.
     * 
     * @return dtinival
     */
    public java.util.Calendar getDtinival() {
        return dtinival;
    }


    /**
     * Sets the dtinival value for this Ijcomppromprima.
     * 
     * @param dtinival
     */
    public void setDtinival(java.util.Calendar dtinival) {
        this.dtinival = dtinival;
    }


    /**
     * Gets the id value for this Ijcomppromprima.
     * 
     * @return id
     */
    public idw.idwws.IjcomppromprimaId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijcomppromprima.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjcomppromprimaId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbmprima value for this Ijcomppromprima.
     * 
     * @return ijtbmprima
     */
    public idw.idwws.Ijtbmprima getIjtbmprima() {
        return ijtbmprima;
    }


    /**
     * Sets the ijtbmprima value for this Ijcomppromprima.
     * 
     * @param ijtbmprima
     */
    public void setIjtbmprima(idw.idwws.Ijtbmprima ijtbmprima) {
        this.ijtbmprima = ijtbmprima;
    }


    /**
     * Gets the ijtbpro value for this Ijcomppromprima.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijcomppromprima.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the perccomposicao value for this Ijcomppromprima.
     * 
     * @return perccomposicao
     */
    public double getPerccomposicao() {
        return perccomposicao;
    }


    /**
     * Sets the perccomposicao value for this Ijcomppromprima.
     * 
     * @param perccomposicao
     */
    public void setPerccomposicao(double perccomposicao) {
        this.perccomposicao = perccomposicao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijcomppromprima)) return false;
        Ijcomppromprima other = (Ijcomppromprima) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dtfimval==null && other.getDtfimval()==null) || 
             (this.dtfimval!=null &&
              this.dtfimval.equals(other.getDtfimval()))) &&
            ((this.dtinival==null && other.getDtinival()==null) || 
             (this.dtinival!=null &&
              this.dtinival.equals(other.getDtinival()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijtbmprima==null && other.getIjtbmprima()==null) || 
             (this.ijtbmprima!=null &&
              this.ijtbmprima.equals(other.getIjtbmprima()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            this.perccomposicao == other.getPerccomposicao();
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
        if (getDtfimval() != null) {
            _hashCode += getDtfimval().hashCode();
        }
        if (getDtinival() != null) {
            _hashCode += getDtinival().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjtbmprima() != null) {
            _hashCode += getIjtbmprima().hashCode();
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        _hashCode += new Double(getPerccomposicao()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijcomppromprima.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcomppromprima"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtfimval");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtfimval"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtinival");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtinival"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcomppromprimaId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmprima");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmprima"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmprima"));
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
        elemField.setFieldName("perccomposicao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perccomposicao"));
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
