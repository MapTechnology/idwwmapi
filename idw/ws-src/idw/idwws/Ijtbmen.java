/**
 * Ijtbmen.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbmen  implements java.io.Serializable {
    private java.math.BigDecimal botaodefault;

    private java.math.BigDecimal botoes;

    private java.math.BigDecimal contexto;

    private java.lang.String dsmensagem1;

    private java.lang.String dsmensagem2;

    private java.lang.String dsmensagem3;

    private java.lang.String helpfile;

    private idw.idwws.IjtbmenId id;

    private idw.idwws.Ijlinguas ijlinguas;

    private java.math.BigDecimal lgmax;

    private java.lang.String titulo;

    public Ijtbmen() {
    }

    public Ijtbmen(
           java.math.BigDecimal botaodefault,
           java.math.BigDecimal botoes,
           java.math.BigDecimal contexto,
           java.lang.String dsmensagem1,
           java.lang.String dsmensagem2,
           java.lang.String dsmensagem3,
           java.lang.String helpfile,
           idw.idwws.IjtbmenId id,
           idw.idwws.Ijlinguas ijlinguas,
           java.math.BigDecimal lgmax,
           java.lang.String titulo) {
           this.botaodefault = botaodefault;
           this.botoes = botoes;
           this.contexto = contexto;
           this.dsmensagem1 = dsmensagem1;
           this.dsmensagem2 = dsmensagem2;
           this.dsmensagem3 = dsmensagem3;
           this.helpfile = helpfile;
           this.id = id;
           this.ijlinguas = ijlinguas;
           this.lgmax = lgmax;
           this.titulo = titulo;
    }


    /**
     * Gets the botaodefault value for this Ijtbmen.
     * 
     * @return botaodefault
     */
    public java.math.BigDecimal getBotaodefault() {
        return botaodefault;
    }


    /**
     * Sets the botaodefault value for this Ijtbmen.
     * 
     * @param botaodefault
     */
    public void setBotaodefault(java.math.BigDecimal botaodefault) {
        this.botaodefault = botaodefault;
    }


    /**
     * Gets the botoes value for this Ijtbmen.
     * 
     * @return botoes
     */
    public java.math.BigDecimal getBotoes() {
        return botoes;
    }


    /**
     * Sets the botoes value for this Ijtbmen.
     * 
     * @param botoes
     */
    public void setBotoes(java.math.BigDecimal botoes) {
        this.botoes = botoes;
    }


    /**
     * Gets the contexto value for this Ijtbmen.
     * 
     * @return contexto
     */
    public java.math.BigDecimal getContexto() {
        return contexto;
    }


    /**
     * Sets the contexto value for this Ijtbmen.
     * 
     * @param contexto
     */
    public void setContexto(java.math.BigDecimal contexto) {
        this.contexto = contexto;
    }


    /**
     * Gets the dsmensagem1 value for this Ijtbmen.
     * 
     * @return dsmensagem1
     */
    public java.lang.String getDsmensagem1() {
        return dsmensagem1;
    }


    /**
     * Sets the dsmensagem1 value for this Ijtbmen.
     * 
     * @param dsmensagem1
     */
    public void setDsmensagem1(java.lang.String dsmensagem1) {
        this.dsmensagem1 = dsmensagem1;
    }


    /**
     * Gets the dsmensagem2 value for this Ijtbmen.
     * 
     * @return dsmensagem2
     */
    public java.lang.String getDsmensagem2() {
        return dsmensagem2;
    }


    /**
     * Sets the dsmensagem2 value for this Ijtbmen.
     * 
     * @param dsmensagem2
     */
    public void setDsmensagem2(java.lang.String dsmensagem2) {
        this.dsmensagem2 = dsmensagem2;
    }


    /**
     * Gets the dsmensagem3 value for this Ijtbmen.
     * 
     * @return dsmensagem3
     */
    public java.lang.String getDsmensagem3() {
        return dsmensagem3;
    }


    /**
     * Sets the dsmensagem3 value for this Ijtbmen.
     * 
     * @param dsmensagem3
     */
    public void setDsmensagem3(java.lang.String dsmensagem3) {
        this.dsmensagem3 = dsmensagem3;
    }


    /**
     * Gets the helpfile value for this Ijtbmen.
     * 
     * @return helpfile
     */
    public java.lang.String getHelpfile() {
        return helpfile;
    }


    /**
     * Sets the helpfile value for this Ijtbmen.
     * 
     * @param helpfile
     */
    public void setHelpfile(java.lang.String helpfile) {
        this.helpfile = helpfile;
    }


    /**
     * Gets the id value for this Ijtbmen.
     * 
     * @return id
     */
    public idw.idwws.IjtbmenId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijtbmen.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjtbmenId id) {
        this.id = id;
    }


    /**
     * Gets the ijlinguas value for this Ijtbmen.
     * 
     * @return ijlinguas
     */
    public idw.idwws.Ijlinguas getIjlinguas() {
        return ijlinguas;
    }


    /**
     * Sets the ijlinguas value for this Ijtbmen.
     * 
     * @param ijlinguas
     */
    public void setIjlinguas(idw.idwws.Ijlinguas ijlinguas) {
        this.ijlinguas = ijlinguas;
    }


    /**
     * Gets the lgmax value for this Ijtbmen.
     * 
     * @return lgmax
     */
    public java.math.BigDecimal getLgmax() {
        return lgmax;
    }


    /**
     * Sets the lgmax value for this Ijtbmen.
     * 
     * @param lgmax
     */
    public void setLgmax(java.math.BigDecimal lgmax) {
        this.lgmax = lgmax;
    }


    /**
     * Gets the titulo value for this Ijtbmen.
     * 
     * @return titulo
     */
    public java.lang.String getTitulo() {
        return titulo;
    }


    /**
     * Sets the titulo value for this Ijtbmen.
     * 
     * @param titulo
     */
    public void setTitulo(java.lang.String titulo) {
        this.titulo = titulo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbmen)) return false;
        Ijtbmen other = (Ijtbmen) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.botaodefault==null && other.getBotaodefault()==null) || 
             (this.botaodefault!=null &&
              this.botaodefault.equals(other.getBotaodefault()))) &&
            ((this.botoes==null && other.getBotoes()==null) || 
             (this.botoes!=null &&
              this.botoes.equals(other.getBotoes()))) &&
            ((this.contexto==null && other.getContexto()==null) || 
             (this.contexto!=null &&
              this.contexto.equals(other.getContexto()))) &&
            ((this.dsmensagem1==null && other.getDsmensagem1()==null) || 
             (this.dsmensagem1!=null &&
              this.dsmensagem1.equals(other.getDsmensagem1()))) &&
            ((this.dsmensagem2==null && other.getDsmensagem2()==null) || 
             (this.dsmensagem2!=null &&
              this.dsmensagem2.equals(other.getDsmensagem2()))) &&
            ((this.dsmensagem3==null && other.getDsmensagem3()==null) || 
             (this.dsmensagem3!=null &&
              this.dsmensagem3.equals(other.getDsmensagem3()))) &&
            ((this.helpfile==null && other.getHelpfile()==null) || 
             (this.helpfile!=null &&
              this.helpfile.equals(other.getHelpfile()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijlinguas==null && other.getIjlinguas()==null) || 
             (this.ijlinguas!=null &&
              this.ijlinguas.equals(other.getIjlinguas()))) &&
            ((this.lgmax==null && other.getLgmax()==null) || 
             (this.lgmax!=null &&
              this.lgmax.equals(other.getLgmax()))) &&
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
        if (getBotaodefault() != null) {
            _hashCode += getBotaodefault().hashCode();
        }
        if (getBotoes() != null) {
            _hashCode += getBotoes().hashCode();
        }
        if (getContexto() != null) {
            _hashCode += getContexto().hashCode();
        }
        if (getDsmensagem1() != null) {
            _hashCode += getDsmensagem1().hashCode();
        }
        if (getDsmensagem2() != null) {
            _hashCode += getDsmensagem2().hashCode();
        }
        if (getDsmensagem3() != null) {
            _hashCode += getDsmensagem3().hashCode();
        }
        if (getHelpfile() != null) {
            _hashCode += getHelpfile().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjlinguas() != null) {
            _hashCode += getIjlinguas().hashCode();
        }
        if (getLgmax() != null) {
            _hashCode += getLgmax().hashCode();
        }
        if (getTitulo() != null) {
            _hashCode += getTitulo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbmen.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmen"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("botaodefault");
        elemField.setXmlName(new javax.xml.namespace.QName("", "botaodefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("botoes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "botoes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contexto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contexto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsmensagem1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsmensagem1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsmensagem2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsmensagem2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsmensagem3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsmensagem3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("helpfile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "helpfile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmenId"));
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
        elemField.setFieldName("lgmax");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lgmax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
