/**
 * Ijtbcau.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbcau  implements java.io.Serializable {
    private java.lang.String cdcausas;

    private java.lang.String dscausas;

    private idw.idwws.Ijlogcorrreq[] ijlogcorrreqs;

    private idw.idwws.Ijpdcaacao[] ijpdcaacaos;

    private idw.idwws.Ijpdcapadrao[] ijpdcapadraos;

    private idw.idwws.Ijreapar[] ijreapars;

    private idw.idwws.Ijrearef[] ijrearefs;

    private java.lang.Integer stativo;

    private org.apache.axis.types.UnsignedShort tipocausa;

    public Ijtbcau() {
    }

    public Ijtbcau(
           java.lang.String cdcausas,
           java.lang.String dscausas,
           idw.idwws.Ijlogcorrreq[] ijlogcorrreqs,
           idw.idwws.Ijpdcaacao[] ijpdcaacaos,
           idw.idwws.Ijpdcapadrao[] ijpdcapadraos,
           idw.idwws.Ijreapar[] ijreapars,
           idw.idwws.Ijrearef[] ijrearefs,
           java.lang.Integer stativo,
           org.apache.axis.types.UnsignedShort tipocausa) {
           this.cdcausas = cdcausas;
           this.dscausas = dscausas;
           this.ijlogcorrreqs = ijlogcorrreqs;
           this.ijpdcaacaos = ijpdcaacaos;
           this.ijpdcapadraos = ijpdcapadraos;
           this.ijreapars = ijreapars;
           this.ijrearefs = ijrearefs;
           this.stativo = stativo;
           this.tipocausa = tipocausa;
    }


    /**
     * Gets the cdcausas value for this Ijtbcau.
     * 
     * @return cdcausas
     */
    public java.lang.String getCdcausas() {
        return cdcausas;
    }


    /**
     * Sets the cdcausas value for this Ijtbcau.
     * 
     * @param cdcausas
     */
    public void setCdcausas(java.lang.String cdcausas) {
        this.cdcausas = cdcausas;
    }


    /**
     * Gets the dscausas value for this Ijtbcau.
     * 
     * @return dscausas
     */
    public java.lang.String getDscausas() {
        return dscausas;
    }


    /**
     * Sets the dscausas value for this Ijtbcau.
     * 
     * @param dscausas
     */
    public void setDscausas(java.lang.String dscausas) {
        this.dscausas = dscausas;
    }


    /**
     * Gets the ijlogcorrreqs value for this Ijtbcau.
     * 
     * @return ijlogcorrreqs
     */
    public idw.idwws.Ijlogcorrreq[] getIjlogcorrreqs() {
        return ijlogcorrreqs;
    }


    /**
     * Sets the ijlogcorrreqs value for this Ijtbcau.
     * 
     * @param ijlogcorrreqs
     */
    public void setIjlogcorrreqs(idw.idwws.Ijlogcorrreq[] ijlogcorrreqs) {
        this.ijlogcorrreqs = ijlogcorrreqs;
    }

    public idw.idwws.Ijlogcorrreq getIjlogcorrreqs(int i) {
        return this.ijlogcorrreqs[i];
    }

    public void setIjlogcorrreqs(int i, idw.idwws.Ijlogcorrreq _value) {
        this.ijlogcorrreqs[i] = _value;
    }


    /**
     * Gets the ijpdcaacaos value for this Ijtbcau.
     * 
     * @return ijpdcaacaos
     */
    public idw.idwws.Ijpdcaacao[] getIjpdcaacaos() {
        return ijpdcaacaos;
    }


    /**
     * Sets the ijpdcaacaos value for this Ijtbcau.
     * 
     * @param ijpdcaacaos
     */
    public void setIjpdcaacaos(idw.idwws.Ijpdcaacao[] ijpdcaacaos) {
        this.ijpdcaacaos = ijpdcaacaos;
    }

    public idw.idwws.Ijpdcaacao getIjpdcaacaos(int i) {
        return this.ijpdcaacaos[i];
    }

    public void setIjpdcaacaos(int i, idw.idwws.Ijpdcaacao _value) {
        this.ijpdcaacaos[i] = _value;
    }


    /**
     * Gets the ijpdcapadraos value for this Ijtbcau.
     * 
     * @return ijpdcapadraos
     */
    public idw.idwws.Ijpdcapadrao[] getIjpdcapadraos() {
        return ijpdcapadraos;
    }


    /**
     * Sets the ijpdcapadraos value for this Ijtbcau.
     * 
     * @param ijpdcapadraos
     */
    public void setIjpdcapadraos(idw.idwws.Ijpdcapadrao[] ijpdcapadraos) {
        this.ijpdcapadraos = ijpdcapadraos;
    }

    public idw.idwws.Ijpdcapadrao getIjpdcapadraos(int i) {
        return this.ijpdcapadraos[i];
    }

    public void setIjpdcapadraos(int i, idw.idwws.Ijpdcapadrao _value) {
        this.ijpdcapadraos[i] = _value;
    }


    /**
     * Gets the ijreapars value for this Ijtbcau.
     * 
     * @return ijreapars
     */
    public idw.idwws.Ijreapar[] getIjreapars() {
        return ijreapars;
    }


    /**
     * Sets the ijreapars value for this Ijtbcau.
     * 
     * @param ijreapars
     */
    public void setIjreapars(idw.idwws.Ijreapar[] ijreapars) {
        this.ijreapars = ijreapars;
    }

    public idw.idwws.Ijreapar getIjreapars(int i) {
        return this.ijreapars[i];
    }

    public void setIjreapars(int i, idw.idwws.Ijreapar _value) {
        this.ijreapars[i] = _value;
    }


    /**
     * Gets the ijrearefs value for this Ijtbcau.
     * 
     * @return ijrearefs
     */
    public idw.idwws.Ijrearef[] getIjrearefs() {
        return ijrearefs;
    }


    /**
     * Sets the ijrearefs value for this Ijtbcau.
     * 
     * @param ijrearefs
     */
    public void setIjrearefs(idw.idwws.Ijrearef[] ijrearefs) {
        this.ijrearefs = ijrearefs;
    }

    public idw.idwws.Ijrearef getIjrearefs(int i) {
        return this.ijrearefs[i];
    }

    public void setIjrearefs(int i, idw.idwws.Ijrearef _value) {
        this.ijrearefs[i] = _value;
    }


    /**
     * Gets the stativo value for this Ijtbcau.
     * 
     * @return stativo
     */
    public java.lang.Integer getStativo() {
        return stativo;
    }


    /**
     * Sets the stativo value for this Ijtbcau.
     * 
     * @param stativo
     */
    public void setStativo(java.lang.Integer stativo) {
        this.stativo = stativo;
    }


    /**
     * Gets the tipocausa value for this Ijtbcau.
     * 
     * @return tipocausa
     */
    public org.apache.axis.types.UnsignedShort getTipocausa() {
        return tipocausa;
    }


    /**
     * Sets the tipocausa value for this Ijtbcau.
     * 
     * @param tipocausa
     */
    public void setTipocausa(org.apache.axis.types.UnsignedShort tipocausa) {
        this.tipocausa = tipocausa;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbcau)) return false;
        Ijtbcau other = (Ijtbcau) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcausas==null && other.getCdcausas()==null) || 
             (this.cdcausas!=null &&
              this.cdcausas.equals(other.getCdcausas()))) &&
            ((this.dscausas==null && other.getDscausas()==null) || 
             (this.dscausas!=null &&
              this.dscausas.equals(other.getDscausas()))) &&
            ((this.ijlogcorrreqs==null && other.getIjlogcorrreqs()==null) || 
             (this.ijlogcorrreqs!=null &&
              java.util.Arrays.equals(this.ijlogcorrreqs, other.getIjlogcorrreqs()))) &&
            ((this.ijpdcaacaos==null && other.getIjpdcaacaos()==null) || 
             (this.ijpdcaacaos!=null &&
              java.util.Arrays.equals(this.ijpdcaacaos, other.getIjpdcaacaos()))) &&
            ((this.ijpdcapadraos==null && other.getIjpdcapadraos()==null) || 
             (this.ijpdcapadraos!=null &&
              java.util.Arrays.equals(this.ijpdcapadraos, other.getIjpdcapadraos()))) &&
            ((this.ijreapars==null && other.getIjreapars()==null) || 
             (this.ijreapars!=null &&
              java.util.Arrays.equals(this.ijreapars, other.getIjreapars()))) &&
            ((this.ijrearefs==null && other.getIjrearefs()==null) || 
             (this.ijrearefs!=null &&
              java.util.Arrays.equals(this.ijrearefs, other.getIjrearefs()))) &&
            ((this.stativo==null && other.getStativo()==null) || 
             (this.stativo!=null &&
              this.stativo.equals(other.getStativo()))) &&
            ((this.tipocausa==null && other.getTipocausa()==null) || 
             (this.tipocausa!=null &&
              this.tipocausa.equals(other.getTipocausa())));
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
        if (getCdcausas() != null) {
            _hashCode += getCdcausas().hashCode();
        }
        if (getDscausas() != null) {
            _hashCode += getDscausas().hashCode();
        }
        if (getIjlogcorrreqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjlogcorrreqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjlogcorrreqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjpdcaacaos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjpdcaacaos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjpdcaacaos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjpdcapadraos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjpdcapadraos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjpdcapadraos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjreapars() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreapars());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreapars(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjrearefs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjrearefs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjrearefs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStativo() != null) {
            _hashCode += getStativo().hashCode();
        }
        if (getTipocausa() != null) {
            _hashCode += getTipocausa().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbcau.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcau"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcausas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcausas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dscausas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dscausas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijlogcorrreqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijlogcorrreqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlogcorrreq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijpdcaacaos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijpdcaacaos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcaacao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijpdcapadraos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijpdcapadraos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcapadrao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreapars");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreapars"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreapar"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijrearefs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijrearefs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrearef"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipocausa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipocausa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
