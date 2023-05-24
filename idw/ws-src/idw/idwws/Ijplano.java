/**
 * Ijplano.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijplano  implements java.io.Serializable {
    private java.lang.String documento;

    private java.util.Calendar dthremissao;

    private idw.idwws.Ijcarteira ijcarteira;

    private idw.idwws.Ijop[] ijops;

    private idw.idwws.Ijproplano[] ijproplanos;

    private java.lang.String nrplano;

    public Ijplano() {
    }

    public Ijplano(
           java.lang.String documento,
           java.util.Calendar dthremissao,
           idw.idwws.Ijcarteira ijcarteira,
           idw.idwws.Ijop[] ijops,
           idw.idwws.Ijproplano[] ijproplanos,
           java.lang.String nrplano) {
           this.documento = documento;
           this.dthremissao = dthremissao;
           this.ijcarteira = ijcarteira;
           this.ijops = ijops;
           this.ijproplanos = ijproplanos;
           this.nrplano = nrplano;
    }


    /**
     * Gets the documento value for this Ijplano.
     * 
     * @return documento
     */
    public java.lang.String getDocumento() {
        return documento;
    }


    /**
     * Sets the documento value for this Ijplano.
     * 
     * @param documento
     */
    public void setDocumento(java.lang.String documento) {
        this.documento = documento;
    }


    /**
     * Gets the dthremissao value for this Ijplano.
     * 
     * @return dthremissao
     */
    public java.util.Calendar getDthremissao() {
        return dthremissao;
    }


    /**
     * Sets the dthremissao value for this Ijplano.
     * 
     * @param dthremissao
     */
    public void setDthremissao(java.util.Calendar dthremissao) {
        this.dthremissao = dthremissao;
    }


    /**
     * Gets the ijcarteira value for this Ijplano.
     * 
     * @return ijcarteira
     */
    public idw.idwws.Ijcarteira getIjcarteira() {
        return ijcarteira;
    }


    /**
     * Sets the ijcarteira value for this Ijplano.
     * 
     * @param ijcarteira
     */
    public void setIjcarteira(idw.idwws.Ijcarteira ijcarteira) {
        this.ijcarteira = ijcarteira;
    }


    /**
     * Gets the ijops value for this Ijplano.
     * 
     * @return ijops
     */
    public idw.idwws.Ijop[] getIjops() {
        return ijops;
    }


    /**
     * Sets the ijops value for this Ijplano.
     * 
     * @param ijops
     */
    public void setIjops(idw.idwws.Ijop[] ijops) {
        this.ijops = ijops;
    }

    public idw.idwws.Ijop getIjops(int i) {
        return this.ijops[i];
    }

    public void setIjops(int i, idw.idwws.Ijop _value) {
        this.ijops[i] = _value;
    }


    /**
     * Gets the ijproplanos value for this Ijplano.
     * 
     * @return ijproplanos
     */
    public idw.idwws.Ijproplano[] getIjproplanos() {
        return ijproplanos;
    }


    /**
     * Sets the ijproplanos value for this Ijplano.
     * 
     * @param ijproplanos
     */
    public void setIjproplanos(idw.idwws.Ijproplano[] ijproplanos) {
        this.ijproplanos = ijproplanos;
    }

    public idw.idwws.Ijproplano getIjproplanos(int i) {
        return this.ijproplanos[i];
    }

    public void setIjproplanos(int i, idw.idwws.Ijproplano _value) {
        this.ijproplanos[i] = _value;
    }


    /**
     * Gets the nrplano value for this Ijplano.
     * 
     * @return nrplano
     */
    public java.lang.String getNrplano() {
        return nrplano;
    }


    /**
     * Sets the nrplano value for this Ijplano.
     * 
     * @param nrplano
     */
    public void setNrplano(java.lang.String nrplano) {
        this.nrplano = nrplano;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijplano)) return false;
        Ijplano other = (Ijplano) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.documento==null && other.getDocumento()==null) || 
             (this.documento!=null &&
              this.documento.equals(other.getDocumento()))) &&
            ((this.dthremissao==null && other.getDthremissao()==null) || 
             (this.dthremissao!=null &&
              this.dthremissao.equals(other.getDthremissao()))) &&
            ((this.ijcarteira==null && other.getIjcarteira()==null) || 
             (this.ijcarteira!=null &&
              this.ijcarteira.equals(other.getIjcarteira()))) &&
            ((this.ijops==null && other.getIjops()==null) || 
             (this.ijops!=null &&
              java.util.Arrays.equals(this.ijops, other.getIjops()))) &&
            ((this.ijproplanos==null && other.getIjproplanos()==null) || 
             (this.ijproplanos!=null &&
              java.util.Arrays.equals(this.ijproplanos, other.getIjproplanos()))) &&
            ((this.nrplano==null && other.getNrplano()==null) || 
             (this.nrplano!=null &&
              this.nrplano.equals(other.getNrplano())));
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
        if (getDocumento() != null) {
            _hashCode += getDocumento().hashCode();
        }
        if (getDthremissao() != null) {
            _hashCode += getDthremissao().hashCode();
        }
        if (getIjcarteira() != null) {
            _hashCode += getIjcarteira().hashCode();
        }
        if (getIjops() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjops());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjops(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjproplanos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjproplanos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjproplanos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNrplano() != null) {
            _hashCode += getNrplano().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijplano.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijplano"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "documento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthremissao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthremissao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcarteira");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcarteira"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcarteira"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijops");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijops"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijproplanos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijproplanos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijproplano"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrplano");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrplano"));
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
