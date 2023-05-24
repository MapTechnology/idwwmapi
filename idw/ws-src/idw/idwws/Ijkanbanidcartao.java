/**
 * Ijkanbanidcartao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijkanbanidcartao  implements java.io.Serializable {
    private java.util.Calendar dthrultleitura;

    private java.lang.String idcartaokanban;

    private idw.idwws.Ijkanbancartoes[] ijkanbancartoeses;

    private idw.idwws.Ijkanbanlocal ijkanbanlocal;

    private idw.idwws.Ijkanbanlote ijkanbanlote;

    private idw.idwws.Ijkanbanmov[] ijkanbanmovs;

    private idw.idwws.Ijtbmol ijtbmol;

    private idw.idwws.Ijtbpro ijtbpro;

    private double qtunidades;

    private org.apache.axis.types.UnsignedShort stcartao;

    public Ijkanbanidcartao() {
    }

    public Ijkanbanidcartao(
           java.util.Calendar dthrultleitura,
           java.lang.String idcartaokanban,
           idw.idwws.Ijkanbancartoes[] ijkanbancartoeses,
           idw.idwws.Ijkanbanlocal ijkanbanlocal,
           idw.idwws.Ijkanbanlote ijkanbanlote,
           idw.idwws.Ijkanbanmov[] ijkanbanmovs,
           idw.idwws.Ijtbmol ijtbmol,
           idw.idwws.Ijtbpro ijtbpro,
           double qtunidades,
           org.apache.axis.types.UnsignedShort stcartao) {
           this.dthrultleitura = dthrultleitura;
           this.idcartaokanban = idcartaokanban;
           this.ijkanbancartoeses = ijkanbancartoeses;
           this.ijkanbanlocal = ijkanbanlocal;
           this.ijkanbanlote = ijkanbanlote;
           this.ijkanbanmovs = ijkanbanmovs;
           this.ijtbmol = ijtbmol;
           this.ijtbpro = ijtbpro;
           this.qtunidades = qtunidades;
           this.stcartao = stcartao;
    }


    /**
     * Gets the dthrultleitura value for this Ijkanbanidcartao.
     * 
     * @return dthrultleitura
     */
    public java.util.Calendar getDthrultleitura() {
        return dthrultleitura;
    }


    /**
     * Sets the dthrultleitura value for this Ijkanbanidcartao.
     * 
     * @param dthrultleitura
     */
    public void setDthrultleitura(java.util.Calendar dthrultleitura) {
        this.dthrultleitura = dthrultleitura;
    }


    /**
     * Gets the idcartaokanban value for this Ijkanbanidcartao.
     * 
     * @return idcartaokanban
     */
    public java.lang.String getIdcartaokanban() {
        return idcartaokanban;
    }


    /**
     * Sets the idcartaokanban value for this Ijkanbanidcartao.
     * 
     * @param idcartaokanban
     */
    public void setIdcartaokanban(java.lang.String idcartaokanban) {
        this.idcartaokanban = idcartaokanban;
    }


    /**
     * Gets the ijkanbancartoeses value for this Ijkanbanidcartao.
     * 
     * @return ijkanbancartoeses
     */
    public idw.idwws.Ijkanbancartoes[] getIjkanbancartoeses() {
        return ijkanbancartoeses;
    }


    /**
     * Sets the ijkanbancartoeses value for this Ijkanbanidcartao.
     * 
     * @param ijkanbancartoeses
     */
    public void setIjkanbancartoeses(idw.idwws.Ijkanbancartoes[] ijkanbancartoeses) {
        this.ijkanbancartoeses = ijkanbancartoeses;
    }

    public idw.idwws.Ijkanbancartoes getIjkanbancartoeses(int i) {
        return this.ijkanbancartoeses[i];
    }

    public void setIjkanbancartoeses(int i, idw.idwws.Ijkanbancartoes _value) {
        this.ijkanbancartoeses[i] = _value;
    }


    /**
     * Gets the ijkanbanlocal value for this Ijkanbanidcartao.
     * 
     * @return ijkanbanlocal
     */
    public idw.idwws.Ijkanbanlocal getIjkanbanlocal() {
        return ijkanbanlocal;
    }


    /**
     * Sets the ijkanbanlocal value for this Ijkanbanidcartao.
     * 
     * @param ijkanbanlocal
     */
    public void setIjkanbanlocal(idw.idwws.Ijkanbanlocal ijkanbanlocal) {
        this.ijkanbanlocal = ijkanbanlocal;
    }


    /**
     * Gets the ijkanbanlote value for this Ijkanbanidcartao.
     * 
     * @return ijkanbanlote
     */
    public idw.idwws.Ijkanbanlote getIjkanbanlote() {
        return ijkanbanlote;
    }


    /**
     * Sets the ijkanbanlote value for this Ijkanbanidcartao.
     * 
     * @param ijkanbanlote
     */
    public void setIjkanbanlote(idw.idwws.Ijkanbanlote ijkanbanlote) {
        this.ijkanbanlote = ijkanbanlote;
    }


    /**
     * Gets the ijkanbanmovs value for this Ijkanbanidcartao.
     * 
     * @return ijkanbanmovs
     */
    public idw.idwws.Ijkanbanmov[] getIjkanbanmovs() {
        return ijkanbanmovs;
    }


    /**
     * Sets the ijkanbanmovs value for this Ijkanbanidcartao.
     * 
     * @param ijkanbanmovs
     */
    public void setIjkanbanmovs(idw.idwws.Ijkanbanmov[] ijkanbanmovs) {
        this.ijkanbanmovs = ijkanbanmovs;
    }

    public idw.idwws.Ijkanbanmov getIjkanbanmovs(int i) {
        return this.ijkanbanmovs[i];
    }

    public void setIjkanbanmovs(int i, idw.idwws.Ijkanbanmov _value) {
        this.ijkanbanmovs[i] = _value;
    }


    /**
     * Gets the ijtbmol value for this Ijkanbanidcartao.
     * 
     * @return ijtbmol
     */
    public idw.idwws.Ijtbmol getIjtbmol() {
        return ijtbmol;
    }


    /**
     * Sets the ijtbmol value for this Ijkanbanidcartao.
     * 
     * @param ijtbmol
     */
    public void setIjtbmol(idw.idwws.Ijtbmol ijtbmol) {
        this.ijtbmol = ijtbmol;
    }


    /**
     * Gets the ijtbpro value for this Ijkanbanidcartao.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijkanbanidcartao.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the qtunidades value for this Ijkanbanidcartao.
     * 
     * @return qtunidades
     */
    public double getQtunidades() {
        return qtunidades;
    }


    /**
     * Sets the qtunidades value for this Ijkanbanidcartao.
     * 
     * @param qtunidades
     */
    public void setQtunidades(double qtunidades) {
        this.qtunidades = qtunidades;
    }


    /**
     * Gets the stcartao value for this Ijkanbanidcartao.
     * 
     * @return stcartao
     */
    public org.apache.axis.types.UnsignedShort getStcartao() {
        return stcartao;
    }


    /**
     * Sets the stcartao value for this Ijkanbanidcartao.
     * 
     * @param stcartao
     */
    public void setStcartao(org.apache.axis.types.UnsignedShort stcartao) {
        this.stcartao = stcartao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijkanbanidcartao)) return false;
        Ijkanbanidcartao other = (Ijkanbanidcartao) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrultleitura==null && other.getDthrultleitura()==null) || 
             (this.dthrultleitura!=null &&
              this.dthrultleitura.equals(other.getDthrultleitura()))) &&
            ((this.idcartaokanban==null && other.getIdcartaokanban()==null) || 
             (this.idcartaokanban!=null &&
              this.idcartaokanban.equals(other.getIdcartaokanban()))) &&
            ((this.ijkanbancartoeses==null && other.getIjkanbancartoeses()==null) || 
             (this.ijkanbancartoeses!=null &&
              java.util.Arrays.equals(this.ijkanbancartoeses, other.getIjkanbancartoeses()))) &&
            ((this.ijkanbanlocal==null && other.getIjkanbanlocal()==null) || 
             (this.ijkanbanlocal!=null &&
              this.ijkanbanlocal.equals(other.getIjkanbanlocal()))) &&
            ((this.ijkanbanlote==null && other.getIjkanbanlote()==null) || 
             (this.ijkanbanlote!=null &&
              this.ijkanbanlote.equals(other.getIjkanbanlote()))) &&
            ((this.ijkanbanmovs==null && other.getIjkanbanmovs()==null) || 
             (this.ijkanbanmovs!=null &&
              java.util.Arrays.equals(this.ijkanbanmovs, other.getIjkanbanmovs()))) &&
            ((this.ijtbmol==null && other.getIjtbmol()==null) || 
             (this.ijtbmol!=null &&
              this.ijtbmol.equals(other.getIjtbmol()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            this.qtunidades == other.getQtunidades() &&
            ((this.stcartao==null && other.getStcartao()==null) || 
             (this.stcartao!=null &&
              this.stcartao.equals(other.getStcartao())));
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
        if (getDthrultleitura() != null) {
            _hashCode += getDthrultleitura().hashCode();
        }
        if (getIdcartaokanban() != null) {
            _hashCode += getIdcartaokanban().hashCode();
        }
        if (getIjkanbancartoeses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjkanbancartoeses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjkanbancartoeses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjkanbanlocal() != null) {
            _hashCode += getIjkanbanlocal().hashCode();
        }
        if (getIjkanbanlote() != null) {
            _hashCode += getIjkanbanlote().hashCode();
        }
        if (getIjkanbanmovs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjkanbanmovs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjkanbanmovs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbmol() != null) {
            _hashCode += getIjtbmol().hashCode();
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        _hashCode += new Double(getQtunidades()).hashCode();
        if (getStcartao() != null) {
            _hashCode += getStcartao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijkanbanidcartao.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanidcartao"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrultleitura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrultleitura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idcartaokanban");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idcartaokanban"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijkanbancartoeses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbancartoeses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbancartoes"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijkanbanlocal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbanlocal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanlocal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijkanbanlote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbanlote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanlote"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijkanbanmovs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbanmovs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanmov"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmol"));
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
        elemField.setFieldName("qtunidades");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtunidades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stcartao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stcartao"));
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
