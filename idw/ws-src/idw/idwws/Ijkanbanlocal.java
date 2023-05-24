/**
 * Ijkanbanlocal.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijkanbanlocal  implements java.io.Serializable {
    private java.lang.String cdlocalkanban;

    private java.lang.String dslocalkanban;

    private org.apache.axis.types.UnsignedShort filaproducao;

    private idw.idwws.Ijkanbanfluxo[] ijkanbanfluxosForCdlocaldestino;

    private idw.idwws.Ijkanbanfluxo[] ijkanbanfluxosForCdlocalorigem;

    private idw.idwws.Ijkanbanidcartao[] ijkanbanidcartaos;

    private idw.idwws.Ijkanbanmov[] ijkanbanmovsForCdlocaldestino;

    private idw.idwws.Ijkanbanmov[] ijkanbanmovsForCdlocalorigem;

    private org.apache.axis.types.UnsignedShort stlocalkanban;

    public Ijkanbanlocal() {
    }

    public Ijkanbanlocal(
           java.lang.String cdlocalkanban,
           java.lang.String dslocalkanban,
           org.apache.axis.types.UnsignedShort filaproducao,
           idw.idwws.Ijkanbanfluxo[] ijkanbanfluxosForCdlocaldestino,
           idw.idwws.Ijkanbanfluxo[] ijkanbanfluxosForCdlocalorigem,
           idw.idwws.Ijkanbanidcartao[] ijkanbanidcartaos,
           idw.idwws.Ijkanbanmov[] ijkanbanmovsForCdlocaldestino,
           idw.idwws.Ijkanbanmov[] ijkanbanmovsForCdlocalorigem,
           org.apache.axis.types.UnsignedShort stlocalkanban) {
           this.cdlocalkanban = cdlocalkanban;
           this.dslocalkanban = dslocalkanban;
           this.filaproducao = filaproducao;
           this.ijkanbanfluxosForCdlocaldestino = ijkanbanfluxosForCdlocaldestino;
           this.ijkanbanfluxosForCdlocalorigem = ijkanbanfluxosForCdlocalorigem;
           this.ijkanbanidcartaos = ijkanbanidcartaos;
           this.ijkanbanmovsForCdlocaldestino = ijkanbanmovsForCdlocaldestino;
           this.ijkanbanmovsForCdlocalorigem = ijkanbanmovsForCdlocalorigem;
           this.stlocalkanban = stlocalkanban;
    }


    /**
     * Gets the cdlocalkanban value for this Ijkanbanlocal.
     * 
     * @return cdlocalkanban
     */
    public java.lang.String getCdlocalkanban() {
        return cdlocalkanban;
    }


    /**
     * Sets the cdlocalkanban value for this Ijkanbanlocal.
     * 
     * @param cdlocalkanban
     */
    public void setCdlocalkanban(java.lang.String cdlocalkanban) {
        this.cdlocalkanban = cdlocalkanban;
    }


    /**
     * Gets the dslocalkanban value for this Ijkanbanlocal.
     * 
     * @return dslocalkanban
     */
    public java.lang.String getDslocalkanban() {
        return dslocalkanban;
    }


    /**
     * Sets the dslocalkanban value for this Ijkanbanlocal.
     * 
     * @param dslocalkanban
     */
    public void setDslocalkanban(java.lang.String dslocalkanban) {
        this.dslocalkanban = dslocalkanban;
    }


    /**
     * Gets the filaproducao value for this Ijkanbanlocal.
     * 
     * @return filaproducao
     */
    public org.apache.axis.types.UnsignedShort getFilaproducao() {
        return filaproducao;
    }


    /**
     * Sets the filaproducao value for this Ijkanbanlocal.
     * 
     * @param filaproducao
     */
    public void setFilaproducao(org.apache.axis.types.UnsignedShort filaproducao) {
        this.filaproducao = filaproducao;
    }


    /**
     * Gets the ijkanbanfluxosForCdlocaldestino value for this Ijkanbanlocal.
     * 
     * @return ijkanbanfluxosForCdlocaldestino
     */
    public idw.idwws.Ijkanbanfluxo[] getIjkanbanfluxosForCdlocaldestino() {
        return ijkanbanfluxosForCdlocaldestino;
    }


    /**
     * Sets the ijkanbanfluxosForCdlocaldestino value for this Ijkanbanlocal.
     * 
     * @param ijkanbanfluxosForCdlocaldestino
     */
    public void setIjkanbanfluxosForCdlocaldestino(idw.idwws.Ijkanbanfluxo[] ijkanbanfluxosForCdlocaldestino) {
        this.ijkanbanfluxosForCdlocaldestino = ijkanbanfluxosForCdlocaldestino;
    }

    public idw.idwws.Ijkanbanfluxo getIjkanbanfluxosForCdlocaldestino(int i) {
        return this.ijkanbanfluxosForCdlocaldestino[i];
    }

    public void setIjkanbanfluxosForCdlocaldestino(int i, idw.idwws.Ijkanbanfluxo _value) {
        this.ijkanbanfluxosForCdlocaldestino[i] = _value;
    }


    /**
     * Gets the ijkanbanfluxosForCdlocalorigem value for this Ijkanbanlocal.
     * 
     * @return ijkanbanfluxosForCdlocalorigem
     */
    public idw.idwws.Ijkanbanfluxo[] getIjkanbanfluxosForCdlocalorigem() {
        return ijkanbanfluxosForCdlocalorigem;
    }


    /**
     * Sets the ijkanbanfluxosForCdlocalorigem value for this Ijkanbanlocal.
     * 
     * @param ijkanbanfluxosForCdlocalorigem
     */
    public void setIjkanbanfluxosForCdlocalorigem(idw.idwws.Ijkanbanfluxo[] ijkanbanfluxosForCdlocalorigem) {
        this.ijkanbanfluxosForCdlocalorigem = ijkanbanfluxosForCdlocalorigem;
    }

    public idw.idwws.Ijkanbanfluxo getIjkanbanfluxosForCdlocalorigem(int i) {
        return this.ijkanbanfluxosForCdlocalorigem[i];
    }

    public void setIjkanbanfluxosForCdlocalorigem(int i, idw.idwws.Ijkanbanfluxo _value) {
        this.ijkanbanfluxosForCdlocalorigem[i] = _value;
    }


    /**
     * Gets the ijkanbanidcartaos value for this Ijkanbanlocal.
     * 
     * @return ijkanbanidcartaos
     */
    public idw.idwws.Ijkanbanidcartao[] getIjkanbanidcartaos() {
        return ijkanbanidcartaos;
    }


    /**
     * Sets the ijkanbanidcartaos value for this Ijkanbanlocal.
     * 
     * @param ijkanbanidcartaos
     */
    public void setIjkanbanidcartaos(idw.idwws.Ijkanbanidcartao[] ijkanbanidcartaos) {
        this.ijkanbanidcartaos = ijkanbanidcartaos;
    }

    public idw.idwws.Ijkanbanidcartao getIjkanbanidcartaos(int i) {
        return this.ijkanbanidcartaos[i];
    }

    public void setIjkanbanidcartaos(int i, idw.idwws.Ijkanbanidcartao _value) {
        this.ijkanbanidcartaos[i] = _value;
    }


    /**
     * Gets the ijkanbanmovsForCdlocaldestino value for this Ijkanbanlocal.
     * 
     * @return ijkanbanmovsForCdlocaldestino
     */
    public idw.idwws.Ijkanbanmov[] getIjkanbanmovsForCdlocaldestino() {
        return ijkanbanmovsForCdlocaldestino;
    }


    /**
     * Sets the ijkanbanmovsForCdlocaldestino value for this Ijkanbanlocal.
     * 
     * @param ijkanbanmovsForCdlocaldestino
     */
    public void setIjkanbanmovsForCdlocaldestino(idw.idwws.Ijkanbanmov[] ijkanbanmovsForCdlocaldestino) {
        this.ijkanbanmovsForCdlocaldestino = ijkanbanmovsForCdlocaldestino;
    }

    public idw.idwws.Ijkanbanmov getIjkanbanmovsForCdlocaldestino(int i) {
        return this.ijkanbanmovsForCdlocaldestino[i];
    }

    public void setIjkanbanmovsForCdlocaldestino(int i, idw.idwws.Ijkanbanmov _value) {
        this.ijkanbanmovsForCdlocaldestino[i] = _value;
    }


    /**
     * Gets the ijkanbanmovsForCdlocalorigem value for this Ijkanbanlocal.
     * 
     * @return ijkanbanmovsForCdlocalorigem
     */
    public idw.idwws.Ijkanbanmov[] getIjkanbanmovsForCdlocalorigem() {
        return ijkanbanmovsForCdlocalorigem;
    }


    /**
     * Sets the ijkanbanmovsForCdlocalorigem value for this Ijkanbanlocal.
     * 
     * @param ijkanbanmovsForCdlocalorigem
     */
    public void setIjkanbanmovsForCdlocalorigem(idw.idwws.Ijkanbanmov[] ijkanbanmovsForCdlocalorigem) {
        this.ijkanbanmovsForCdlocalorigem = ijkanbanmovsForCdlocalorigem;
    }

    public idw.idwws.Ijkanbanmov getIjkanbanmovsForCdlocalorigem(int i) {
        return this.ijkanbanmovsForCdlocalorigem[i];
    }

    public void setIjkanbanmovsForCdlocalorigem(int i, idw.idwws.Ijkanbanmov _value) {
        this.ijkanbanmovsForCdlocalorigem[i] = _value;
    }


    /**
     * Gets the stlocalkanban value for this Ijkanbanlocal.
     * 
     * @return stlocalkanban
     */
    public org.apache.axis.types.UnsignedShort getStlocalkanban() {
        return stlocalkanban;
    }


    /**
     * Sets the stlocalkanban value for this Ijkanbanlocal.
     * 
     * @param stlocalkanban
     */
    public void setStlocalkanban(org.apache.axis.types.UnsignedShort stlocalkanban) {
        this.stlocalkanban = stlocalkanban;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijkanbanlocal)) return false;
        Ijkanbanlocal other = (Ijkanbanlocal) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdlocalkanban==null && other.getCdlocalkanban()==null) || 
             (this.cdlocalkanban!=null &&
              this.cdlocalkanban.equals(other.getCdlocalkanban()))) &&
            ((this.dslocalkanban==null && other.getDslocalkanban()==null) || 
             (this.dslocalkanban!=null &&
              this.dslocalkanban.equals(other.getDslocalkanban()))) &&
            ((this.filaproducao==null && other.getFilaproducao()==null) || 
             (this.filaproducao!=null &&
              this.filaproducao.equals(other.getFilaproducao()))) &&
            ((this.ijkanbanfluxosForCdlocaldestino==null && other.getIjkanbanfluxosForCdlocaldestino()==null) || 
             (this.ijkanbanfluxosForCdlocaldestino!=null &&
              java.util.Arrays.equals(this.ijkanbanfluxosForCdlocaldestino, other.getIjkanbanfluxosForCdlocaldestino()))) &&
            ((this.ijkanbanfluxosForCdlocalorigem==null && other.getIjkanbanfluxosForCdlocalorigem()==null) || 
             (this.ijkanbanfluxosForCdlocalorigem!=null &&
              java.util.Arrays.equals(this.ijkanbanfluxosForCdlocalorigem, other.getIjkanbanfluxosForCdlocalorigem()))) &&
            ((this.ijkanbanidcartaos==null && other.getIjkanbanidcartaos()==null) || 
             (this.ijkanbanidcartaos!=null &&
              java.util.Arrays.equals(this.ijkanbanidcartaos, other.getIjkanbanidcartaos()))) &&
            ((this.ijkanbanmovsForCdlocaldestino==null && other.getIjkanbanmovsForCdlocaldestino()==null) || 
             (this.ijkanbanmovsForCdlocaldestino!=null &&
              java.util.Arrays.equals(this.ijkanbanmovsForCdlocaldestino, other.getIjkanbanmovsForCdlocaldestino()))) &&
            ((this.ijkanbanmovsForCdlocalorigem==null && other.getIjkanbanmovsForCdlocalorigem()==null) || 
             (this.ijkanbanmovsForCdlocalorigem!=null &&
              java.util.Arrays.equals(this.ijkanbanmovsForCdlocalorigem, other.getIjkanbanmovsForCdlocalorigem()))) &&
            ((this.stlocalkanban==null && other.getStlocalkanban()==null) || 
             (this.stlocalkanban!=null &&
              this.stlocalkanban.equals(other.getStlocalkanban())));
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
        if (getCdlocalkanban() != null) {
            _hashCode += getCdlocalkanban().hashCode();
        }
        if (getDslocalkanban() != null) {
            _hashCode += getDslocalkanban().hashCode();
        }
        if (getFilaproducao() != null) {
            _hashCode += getFilaproducao().hashCode();
        }
        if (getIjkanbanfluxosForCdlocaldestino() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjkanbanfluxosForCdlocaldestino());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjkanbanfluxosForCdlocaldestino(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjkanbanfluxosForCdlocalorigem() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjkanbanfluxosForCdlocalorigem());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjkanbanfluxosForCdlocalorigem(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjkanbanidcartaos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjkanbanidcartaos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjkanbanidcartaos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjkanbanmovsForCdlocaldestino() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjkanbanmovsForCdlocaldestino());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjkanbanmovsForCdlocaldestino(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjkanbanmovsForCdlocalorigem() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjkanbanmovsForCdlocalorigem());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjkanbanmovsForCdlocalorigem(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStlocalkanban() != null) {
            _hashCode += getStlocalkanban().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijkanbanlocal.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanlocal"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdlocalkanban");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdlocalkanban"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dslocalkanban");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dslocalkanban"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filaproducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "filaproducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijkanbanfluxosForCdlocaldestino");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbanfluxosForCdlocaldestino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanfluxo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijkanbanfluxosForCdlocalorigem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbanfluxosForCdlocalorigem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanfluxo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijkanbanidcartaos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbanidcartaos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanidcartao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijkanbanmovsForCdlocaldestino");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbanmovsForCdlocaldestino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanmov"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijkanbanmovsForCdlocalorigem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbanmovsForCdlocalorigem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanmov"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stlocalkanban");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stlocalkanban"));
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
