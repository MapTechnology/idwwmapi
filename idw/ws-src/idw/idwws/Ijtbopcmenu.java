/**
 * Ijtbopcmenu.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbopcmenu  implements java.io.Serializable {
    private java.lang.String cdopcao;

    private java.lang.String dsopcao;

    private idw.idwws.Ijdirace[] ijdiraces;

    private idw.idwws.Ijdiremp[] ijdiremps;

    private idw.idwws.Ijtbmodulos ijtbmodulos;

    private java.math.BigDecimal nivel;

    private java.lang.String nmfuncao;

    private java.lang.String nmobjeto;

    private java.lang.String nmopcao;

    private java.lang.String shortcut;

    private java.math.BigDecimal stopcao;

    private java.lang.String subniveldecdopcao;

    public Ijtbopcmenu() {
    }

    public Ijtbopcmenu(
           java.lang.String cdopcao,
           java.lang.String dsopcao,
           idw.idwws.Ijdirace[] ijdiraces,
           idw.idwws.Ijdiremp[] ijdiremps,
           idw.idwws.Ijtbmodulos ijtbmodulos,
           java.math.BigDecimal nivel,
           java.lang.String nmfuncao,
           java.lang.String nmobjeto,
           java.lang.String nmopcao,
           java.lang.String shortcut,
           java.math.BigDecimal stopcao,
           java.lang.String subniveldecdopcao) {
           this.cdopcao = cdopcao;
           this.dsopcao = dsopcao;
           this.ijdiraces = ijdiraces;
           this.ijdiremps = ijdiremps;
           this.ijtbmodulos = ijtbmodulos;
           this.nivel = nivel;
           this.nmfuncao = nmfuncao;
           this.nmobjeto = nmobjeto;
           this.nmopcao = nmopcao;
           this.shortcut = shortcut;
           this.stopcao = stopcao;
           this.subniveldecdopcao = subniveldecdopcao;
    }


    /**
     * Gets the cdopcao value for this Ijtbopcmenu.
     * 
     * @return cdopcao
     */
    public java.lang.String getCdopcao() {
        return cdopcao;
    }


    /**
     * Sets the cdopcao value for this Ijtbopcmenu.
     * 
     * @param cdopcao
     */
    public void setCdopcao(java.lang.String cdopcao) {
        this.cdopcao = cdopcao;
    }


    /**
     * Gets the dsopcao value for this Ijtbopcmenu.
     * 
     * @return dsopcao
     */
    public java.lang.String getDsopcao() {
        return dsopcao;
    }


    /**
     * Sets the dsopcao value for this Ijtbopcmenu.
     * 
     * @param dsopcao
     */
    public void setDsopcao(java.lang.String dsopcao) {
        this.dsopcao = dsopcao;
    }


    /**
     * Gets the ijdiraces value for this Ijtbopcmenu.
     * 
     * @return ijdiraces
     */
    public idw.idwws.Ijdirace[] getIjdiraces() {
        return ijdiraces;
    }


    /**
     * Sets the ijdiraces value for this Ijtbopcmenu.
     * 
     * @param ijdiraces
     */
    public void setIjdiraces(idw.idwws.Ijdirace[] ijdiraces) {
        this.ijdiraces = ijdiraces;
    }

    public idw.idwws.Ijdirace getIjdiraces(int i) {
        return this.ijdiraces[i];
    }

    public void setIjdiraces(int i, idw.idwws.Ijdirace _value) {
        this.ijdiraces[i] = _value;
    }


    /**
     * Gets the ijdiremps value for this Ijtbopcmenu.
     * 
     * @return ijdiremps
     */
    public idw.idwws.Ijdiremp[] getIjdiremps() {
        return ijdiremps;
    }


    /**
     * Sets the ijdiremps value for this Ijtbopcmenu.
     * 
     * @param ijdiremps
     */
    public void setIjdiremps(idw.idwws.Ijdiremp[] ijdiremps) {
        this.ijdiremps = ijdiremps;
    }

    public idw.idwws.Ijdiremp getIjdiremps(int i) {
        return this.ijdiremps[i];
    }

    public void setIjdiremps(int i, idw.idwws.Ijdiremp _value) {
        this.ijdiremps[i] = _value;
    }


    /**
     * Gets the ijtbmodulos value for this Ijtbopcmenu.
     * 
     * @return ijtbmodulos
     */
    public idw.idwws.Ijtbmodulos getIjtbmodulos() {
        return ijtbmodulos;
    }


    /**
     * Sets the ijtbmodulos value for this Ijtbopcmenu.
     * 
     * @param ijtbmodulos
     */
    public void setIjtbmodulos(idw.idwws.Ijtbmodulos ijtbmodulos) {
        this.ijtbmodulos = ijtbmodulos;
    }


    /**
     * Gets the nivel value for this Ijtbopcmenu.
     * 
     * @return nivel
     */
    public java.math.BigDecimal getNivel() {
        return nivel;
    }


    /**
     * Sets the nivel value for this Ijtbopcmenu.
     * 
     * @param nivel
     */
    public void setNivel(java.math.BigDecimal nivel) {
        this.nivel = nivel;
    }


    /**
     * Gets the nmfuncao value for this Ijtbopcmenu.
     * 
     * @return nmfuncao
     */
    public java.lang.String getNmfuncao() {
        return nmfuncao;
    }


    /**
     * Sets the nmfuncao value for this Ijtbopcmenu.
     * 
     * @param nmfuncao
     */
    public void setNmfuncao(java.lang.String nmfuncao) {
        this.nmfuncao = nmfuncao;
    }


    /**
     * Gets the nmobjeto value for this Ijtbopcmenu.
     * 
     * @return nmobjeto
     */
    public java.lang.String getNmobjeto() {
        return nmobjeto;
    }


    /**
     * Sets the nmobjeto value for this Ijtbopcmenu.
     * 
     * @param nmobjeto
     */
    public void setNmobjeto(java.lang.String nmobjeto) {
        this.nmobjeto = nmobjeto;
    }


    /**
     * Gets the nmopcao value for this Ijtbopcmenu.
     * 
     * @return nmopcao
     */
    public java.lang.String getNmopcao() {
        return nmopcao;
    }


    /**
     * Sets the nmopcao value for this Ijtbopcmenu.
     * 
     * @param nmopcao
     */
    public void setNmopcao(java.lang.String nmopcao) {
        this.nmopcao = nmopcao;
    }


    /**
     * Gets the shortcut value for this Ijtbopcmenu.
     * 
     * @return shortcut
     */
    public java.lang.String getShortcut() {
        return shortcut;
    }


    /**
     * Sets the shortcut value for this Ijtbopcmenu.
     * 
     * @param shortcut
     */
    public void setShortcut(java.lang.String shortcut) {
        this.shortcut = shortcut;
    }


    /**
     * Gets the stopcao value for this Ijtbopcmenu.
     * 
     * @return stopcao
     */
    public java.math.BigDecimal getStopcao() {
        return stopcao;
    }


    /**
     * Sets the stopcao value for this Ijtbopcmenu.
     * 
     * @param stopcao
     */
    public void setStopcao(java.math.BigDecimal stopcao) {
        this.stopcao = stopcao;
    }


    /**
     * Gets the subniveldecdopcao value for this Ijtbopcmenu.
     * 
     * @return subniveldecdopcao
     */
    public java.lang.String getSubniveldecdopcao() {
        return subniveldecdopcao;
    }


    /**
     * Sets the subniveldecdopcao value for this Ijtbopcmenu.
     * 
     * @param subniveldecdopcao
     */
    public void setSubniveldecdopcao(java.lang.String subniveldecdopcao) {
        this.subniveldecdopcao = subniveldecdopcao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbopcmenu)) return false;
        Ijtbopcmenu other = (Ijtbopcmenu) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdopcao==null && other.getCdopcao()==null) || 
             (this.cdopcao!=null &&
              this.cdopcao.equals(other.getCdopcao()))) &&
            ((this.dsopcao==null && other.getDsopcao()==null) || 
             (this.dsopcao!=null &&
              this.dsopcao.equals(other.getDsopcao()))) &&
            ((this.ijdiraces==null && other.getIjdiraces()==null) || 
             (this.ijdiraces!=null &&
              java.util.Arrays.equals(this.ijdiraces, other.getIjdiraces()))) &&
            ((this.ijdiremps==null && other.getIjdiremps()==null) || 
             (this.ijdiremps!=null &&
              java.util.Arrays.equals(this.ijdiremps, other.getIjdiremps()))) &&
            ((this.ijtbmodulos==null && other.getIjtbmodulos()==null) || 
             (this.ijtbmodulos!=null &&
              this.ijtbmodulos.equals(other.getIjtbmodulos()))) &&
            ((this.nivel==null && other.getNivel()==null) || 
             (this.nivel!=null &&
              this.nivel.equals(other.getNivel()))) &&
            ((this.nmfuncao==null && other.getNmfuncao()==null) || 
             (this.nmfuncao!=null &&
              this.nmfuncao.equals(other.getNmfuncao()))) &&
            ((this.nmobjeto==null && other.getNmobjeto()==null) || 
             (this.nmobjeto!=null &&
              this.nmobjeto.equals(other.getNmobjeto()))) &&
            ((this.nmopcao==null && other.getNmopcao()==null) || 
             (this.nmopcao!=null &&
              this.nmopcao.equals(other.getNmopcao()))) &&
            ((this.shortcut==null && other.getShortcut()==null) || 
             (this.shortcut!=null &&
              this.shortcut.equals(other.getShortcut()))) &&
            ((this.stopcao==null && other.getStopcao()==null) || 
             (this.stopcao!=null &&
              this.stopcao.equals(other.getStopcao()))) &&
            ((this.subniveldecdopcao==null && other.getSubniveldecdopcao()==null) || 
             (this.subniveldecdopcao!=null &&
              this.subniveldecdopcao.equals(other.getSubniveldecdopcao())));
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
        if (getCdopcao() != null) {
            _hashCode += getCdopcao().hashCode();
        }
        if (getDsopcao() != null) {
            _hashCode += getDsopcao().hashCode();
        }
        if (getIjdiraces() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjdiraces());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjdiraces(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjdiremps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjdiremps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjdiremps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbmodulos() != null) {
            _hashCode += getIjtbmodulos().hashCode();
        }
        if (getNivel() != null) {
            _hashCode += getNivel().hashCode();
        }
        if (getNmfuncao() != null) {
            _hashCode += getNmfuncao().hashCode();
        }
        if (getNmobjeto() != null) {
            _hashCode += getNmobjeto().hashCode();
        }
        if (getNmopcao() != null) {
            _hashCode += getNmopcao().hashCode();
        }
        if (getShortcut() != null) {
            _hashCode += getShortcut().hashCode();
        }
        if (getStopcao() != null) {
            _hashCode += getStopcao().hashCode();
        }
        if (getSubniveldecdopcao() != null) {
            _hashCode += getSubniveldecdopcao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbopcmenu.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbopcmenu"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdopcao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdopcao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsopcao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsopcao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijdiraces");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijdiraces"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdirace"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijdiremps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijdiremps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijdiremp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmodulos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmodulos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmodulos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nivel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nivel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nmfuncao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nmfuncao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nmobjeto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nmobjeto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nmopcao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nmopcao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shortcut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "shortcut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stopcao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stopcao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subniveldecdopcao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subniveldecdopcao"));
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
