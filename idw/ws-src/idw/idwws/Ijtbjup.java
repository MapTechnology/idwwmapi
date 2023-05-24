/**
 * Ijtbjup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbjup  implements java.io.Serializable {
    private java.lang.String cdjustparada;

    private java.lang.String dsjustparada;

    private idw.idwws.Ijlogcorrreq[] ijlogcorrreqs;

    private idw.idwws.Ijreapar[] ijreapars;

    private java.lang.Integer stativo;

    public Ijtbjup() {
    }

    public Ijtbjup(
           java.lang.String cdjustparada,
           java.lang.String dsjustparada,
           idw.idwws.Ijlogcorrreq[] ijlogcorrreqs,
           idw.idwws.Ijreapar[] ijreapars,
           java.lang.Integer stativo) {
           this.cdjustparada = cdjustparada;
           this.dsjustparada = dsjustparada;
           this.ijlogcorrreqs = ijlogcorrreqs;
           this.ijreapars = ijreapars;
           this.stativo = stativo;
    }


    /**
     * Gets the cdjustparada value for this Ijtbjup.
     * 
     * @return cdjustparada
     */
    public java.lang.String getCdjustparada() {
        return cdjustparada;
    }


    /**
     * Sets the cdjustparada value for this Ijtbjup.
     * 
     * @param cdjustparada
     */
    public void setCdjustparada(java.lang.String cdjustparada) {
        this.cdjustparada = cdjustparada;
    }


    /**
     * Gets the dsjustparada value for this Ijtbjup.
     * 
     * @return dsjustparada
     */
    public java.lang.String getDsjustparada() {
        return dsjustparada;
    }


    /**
     * Sets the dsjustparada value for this Ijtbjup.
     * 
     * @param dsjustparada
     */
    public void setDsjustparada(java.lang.String dsjustparada) {
        this.dsjustparada = dsjustparada;
    }


    /**
     * Gets the ijlogcorrreqs value for this Ijtbjup.
     * 
     * @return ijlogcorrreqs
     */
    public idw.idwws.Ijlogcorrreq[] getIjlogcorrreqs() {
        return ijlogcorrreqs;
    }


    /**
     * Sets the ijlogcorrreqs value for this Ijtbjup.
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
     * Gets the ijreapars value for this Ijtbjup.
     * 
     * @return ijreapars
     */
    public idw.idwws.Ijreapar[] getIjreapars() {
        return ijreapars;
    }


    /**
     * Sets the ijreapars value for this Ijtbjup.
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
     * Gets the stativo value for this Ijtbjup.
     * 
     * @return stativo
     */
    public java.lang.Integer getStativo() {
        return stativo;
    }


    /**
     * Sets the stativo value for this Ijtbjup.
     * 
     * @param stativo
     */
    public void setStativo(java.lang.Integer stativo) {
        this.stativo = stativo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbjup)) return false;
        Ijtbjup other = (Ijtbjup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdjustparada==null && other.getCdjustparada()==null) || 
             (this.cdjustparada!=null &&
              this.cdjustparada.equals(other.getCdjustparada()))) &&
            ((this.dsjustparada==null && other.getDsjustparada()==null) || 
             (this.dsjustparada!=null &&
              this.dsjustparada.equals(other.getDsjustparada()))) &&
            ((this.ijlogcorrreqs==null && other.getIjlogcorrreqs()==null) || 
             (this.ijlogcorrreqs!=null &&
              java.util.Arrays.equals(this.ijlogcorrreqs, other.getIjlogcorrreqs()))) &&
            ((this.ijreapars==null && other.getIjreapars()==null) || 
             (this.ijreapars!=null &&
              java.util.Arrays.equals(this.ijreapars, other.getIjreapars()))) &&
            ((this.stativo==null && other.getStativo()==null) || 
             (this.stativo!=null &&
              this.stativo.equals(other.getStativo())));
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
        if (getCdjustparada() != null) {
            _hashCode += getCdjustparada().hashCode();
        }
        if (getDsjustparada() != null) {
            _hashCode += getDsjustparada().hashCode();
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
        if (getStativo() != null) {
            _hashCode += getStativo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbjup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbjup"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdjustparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdjustparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsjustparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsjustparada"));
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
        elemField.setFieldName("ijreapars");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreapars"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreapar"));
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
