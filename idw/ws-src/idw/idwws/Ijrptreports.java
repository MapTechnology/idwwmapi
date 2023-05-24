/**
 * Ijrptreports.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijrptreports  implements java.io.Serializable {
    private idw.idwws.IjrptreportsId id;

    private idw.idwws.Ijlinguas ijlinguas;

    private idw.idwws.Ijrptlabels[] ijrptlabelses;

    private java.lang.String subtagrupamento;

    private java.lang.String subtcontagem;

    private java.lang.String subtperiodo;

    private java.lang.String subtturnos;

    private java.lang.String titulo;

    public Ijrptreports() {
    }

    public Ijrptreports(
           idw.idwws.IjrptreportsId id,
           idw.idwws.Ijlinguas ijlinguas,
           idw.idwws.Ijrptlabels[] ijrptlabelses,
           java.lang.String subtagrupamento,
           java.lang.String subtcontagem,
           java.lang.String subtperiodo,
           java.lang.String subtturnos,
           java.lang.String titulo) {
           this.id = id;
           this.ijlinguas = ijlinguas;
           this.ijrptlabelses = ijrptlabelses;
           this.subtagrupamento = subtagrupamento;
           this.subtcontagem = subtcontagem;
           this.subtperiodo = subtperiodo;
           this.subtturnos = subtturnos;
           this.titulo = titulo;
    }


    /**
     * Gets the id value for this Ijrptreports.
     * 
     * @return id
     */
    public idw.idwws.IjrptreportsId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijrptreports.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjrptreportsId id) {
        this.id = id;
    }


    /**
     * Gets the ijlinguas value for this Ijrptreports.
     * 
     * @return ijlinguas
     */
    public idw.idwws.Ijlinguas getIjlinguas() {
        return ijlinguas;
    }


    /**
     * Sets the ijlinguas value for this Ijrptreports.
     * 
     * @param ijlinguas
     */
    public void setIjlinguas(idw.idwws.Ijlinguas ijlinguas) {
        this.ijlinguas = ijlinguas;
    }


    /**
     * Gets the ijrptlabelses value for this Ijrptreports.
     * 
     * @return ijrptlabelses
     */
    public idw.idwws.Ijrptlabels[] getIjrptlabelses() {
        return ijrptlabelses;
    }


    /**
     * Sets the ijrptlabelses value for this Ijrptreports.
     * 
     * @param ijrptlabelses
     */
    public void setIjrptlabelses(idw.idwws.Ijrptlabels[] ijrptlabelses) {
        this.ijrptlabelses = ijrptlabelses;
    }

    public idw.idwws.Ijrptlabels getIjrptlabelses(int i) {
        return this.ijrptlabelses[i];
    }

    public void setIjrptlabelses(int i, idw.idwws.Ijrptlabels _value) {
        this.ijrptlabelses[i] = _value;
    }


    /**
     * Gets the subtagrupamento value for this Ijrptreports.
     * 
     * @return subtagrupamento
     */
    public java.lang.String getSubtagrupamento() {
        return subtagrupamento;
    }


    /**
     * Sets the subtagrupamento value for this Ijrptreports.
     * 
     * @param subtagrupamento
     */
    public void setSubtagrupamento(java.lang.String subtagrupamento) {
        this.subtagrupamento = subtagrupamento;
    }


    /**
     * Gets the subtcontagem value for this Ijrptreports.
     * 
     * @return subtcontagem
     */
    public java.lang.String getSubtcontagem() {
        return subtcontagem;
    }


    /**
     * Sets the subtcontagem value for this Ijrptreports.
     * 
     * @param subtcontagem
     */
    public void setSubtcontagem(java.lang.String subtcontagem) {
        this.subtcontagem = subtcontagem;
    }


    /**
     * Gets the subtperiodo value for this Ijrptreports.
     * 
     * @return subtperiodo
     */
    public java.lang.String getSubtperiodo() {
        return subtperiodo;
    }


    /**
     * Sets the subtperiodo value for this Ijrptreports.
     * 
     * @param subtperiodo
     */
    public void setSubtperiodo(java.lang.String subtperiodo) {
        this.subtperiodo = subtperiodo;
    }


    /**
     * Gets the subtturnos value for this Ijrptreports.
     * 
     * @return subtturnos
     */
    public java.lang.String getSubtturnos() {
        return subtturnos;
    }


    /**
     * Sets the subtturnos value for this Ijrptreports.
     * 
     * @param subtturnos
     */
    public void setSubtturnos(java.lang.String subtturnos) {
        this.subtturnos = subtturnos;
    }


    /**
     * Gets the titulo value for this Ijrptreports.
     * 
     * @return titulo
     */
    public java.lang.String getTitulo() {
        return titulo;
    }


    /**
     * Sets the titulo value for this Ijrptreports.
     * 
     * @param titulo
     */
    public void setTitulo(java.lang.String titulo) {
        this.titulo = titulo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijrptreports)) return false;
        Ijrptreports other = (Ijrptreports) obj;
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
            ((this.ijlinguas==null && other.getIjlinguas()==null) || 
             (this.ijlinguas!=null &&
              this.ijlinguas.equals(other.getIjlinguas()))) &&
            ((this.ijrptlabelses==null && other.getIjrptlabelses()==null) || 
             (this.ijrptlabelses!=null &&
              java.util.Arrays.equals(this.ijrptlabelses, other.getIjrptlabelses()))) &&
            ((this.subtagrupamento==null && other.getSubtagrupamento()==null) || 
             (this.subtagrupamento!=null &&
              this.subtagrupamento.equals(other.getSubtagrupamento()))) &&
            ((this.subtcontagem==null && other.getSubtcontagem()==null) || 
             (this.subtcontagem!=null &&
              this.subtcontagem.equals(other.getSubtcontagem()))) &&
            ((this.subtperiodo==null && other.getSubtperiodo()==null) || 
             (this.subtperiodo!=null &&
              this.subtperiodo.equals(other.getSubtperiodo()))) &&
            ((this.subtturnos==null && other.getSubtturnos()==null) || 
             (this.subtturnos!=null &&
              this.subtturnos.equals(other.getSubtturnos()))) &&
            ((this.titulo==null && other.getTitulo()==null) || 
             (this.titulo!=null &&
              this.titulo.equals(other.getTitulo())));
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
        if (getIjlinguas() != null) {
            _hashCode += getIjlinguas().hashCode();
        }
        if (getIjrptlabelses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjrptlabelses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjrptlabelses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSubtagrupamento() != null) {
            _hashCode += getSubtagrupamento().hashCode();
        }
        if (getSubtcontagem() != null) {
            _hashCode += getSubtcontagem().hashCode();
        }
        if (getSubtperiodo() != null) {
            _hashCode += getSubtperiodo().hashCode();
        }
        if (getSubtturnos() != null) {
            _hashCode += getSubtturnos().hashCode();
        }
        if (getTitulo() != null) {
            _hashCode += getTitulo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijrptreports.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrptreports"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrptreportsId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijlinguas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijlinguas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlinguas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijrptlabelses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijrptlabelses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrptlabels"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subtagrupamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subtagrupamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subtcontagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subtcontagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subtperiodo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subtperiodo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subtturnos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subtturnos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titulo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "titulo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
