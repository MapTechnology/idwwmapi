/**
 * Ijtbitemcnc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbitemcnc  implements java.io.Serializable {
    private java.lang.String cditemcnc;

    private java.lang.String dsitemcnc;

    private idw.idwws.Ijcncop[] ijcncops;

    private idw.idwws.Ijcncturno[] ijcncturnos;

    private idw.idwws.Ijficcnc[] ijficcncs;

    private idw.idwws.Ijficinj[] ijficinjs;

    private idw.idwws.Ijreacnc[] ijreacncs;

    private idw.idwws.Ijtbgrpitemcnc ijtbgrpitemcnc;

    private java.math.BigDecimal ordem;

    public Ijtbitemcnc() {
    }

    public Ijtbitemcnc(
           java.lang.String cditemcnc,
           java.lang.String dsitemcnc,
           idw.idwws.Ijcncop[] ijcncops,
           idw.idwws.Ijcncturno[] ijcncturnos,
           idw.idwws.Ijficcnc[] ijficcncs,
           idw.idwws.Ijficinj[] ijficinjs,
           idw.idwws.Ijreacnc[] ijreacncs,
           idw.idwws.Ijtbgrpitemcnc ijtbgrpitemcnc,
           java.math.BigDecimal ordem) {
           this.cditemcnc = cditemcnc;
           this.dsitemcnc = dsitemcnc;
           this.ijcncops = ijcncops;
           this.ijcncturnos = ijcncturnos;
           this.ijficcncs = ijficcncs;
           this.ijficinjs = ijficinjs;
           this.ijreacncs = ijreacncs;
           this.ijtbgrpitemcnc = ijtbgrpitemcnc;
           this.ordem = ordem;
    }


    /**
     * Gets the cditemcnc value for this Ijtbitemcnc.
     * 
     * @return cditemcnc
     */
    public java.lang.String getCditemcnc() {
        return cditemcnc;
    }


    /**
     * Sets the cditemcnc value for this Ijtbitemcnc.
     * 
     * @param cditemcnc
     */
    public void setCditemcnc(java.lang.String cditemcnc) {
        this.cditemcnc = cditemcnc;
    }


    /**
     * Gets the dsitemcnc value for this Ijtbitemcnc.
     * 
     * @return dsitemcnc
     */
    public java.lang.String getDsitemcnc() {
        return dsitemcnc;
    }


    /**
     * Sets the dsitemcnc value for this Ijtbitemcnc.
     * 
     * @param dsitemcnc
     */
    public void setDsitemcnc(java.lang.String dsitemcnc) {
        this.dsitemcnc = dsitemcnc;
    }


    /**
     * Gets the ijcncops value for this Ijtbitemcnc.
     * 
     * @return ijcncops
     */
    public idw.idwws.Ijcncop[] getIjcncops() {
        return ijcncops;
    }


    /**
     * Sets the ijcncops value for this Ijtbitemcnc.
     * 
     * @param ijcncops
     */
    public void setIjcncops(idw.idwws.Ijcncop[] ijcncops) {
        this.ijcncops = ijcncops;
    }

    public idw.idwws.Ijcncop getIjcncops(int i) {
        return this.ijcncops[i];
    }

    public void setIjcncops(int i, idw.idwws.Ijcncop _value) {
        this.ijcncops[i] = _value;
    }


    /**
     * Gets the ijcncturnos value for this Ijtbitemcnc.
     * 
     * @return ijcncturnos
     */
    public idw.idwws.Ijcncturno[] getIjcncturnos() {
        return ijcncturnos;
    }


    /**
     * Sets the ijcncturnos value for this Ijtbitemcnc.
     * 
     * @param ijcncturnos
     */
    public void setIjcncturnos(idw.idwws.Ijcncturno[] ijcncturnos) {
        this.ijcncturnos = ijcncturnos;
    }

    public idw.idwws.Ijcncturno getIjcncturnos(int i) {
        return this.ijcncturnos[i];
    }

    public void setIjcncturnos(int i, idw.idwws.Ijcncturno _value) {
        this.ijcncturnos[i] = _value;
    }


    /**
     * Gets the ijficcncs value for this Ijtbitemcnc.
     * 
     * @return ijficcncs
     */
    public idw.idwws.Ijficcnc[] getIjficcncs() {
        return ijficcncs;
    }


    /**
     * Sets the ijficcncs value for this Ijtbitemcnc.
     * 
     * @param ijficcncs
     */
    public void setIjficcncs(idw.idwws.Ijficcnc[] ijficcncs) {
        this.ijficcncs = ijficcncs;
    }

    public idw.idwws.Ijficcnc getIjficcncs(int i) {
        return this.ijficcncs[i];
    }

    public void setIjficcncs(int i, idw.idwws.Ijficcnc _value) {
        this.ijficcncs[i] = _value;
    }


    /**
     * Gets the ijficinjs value for this Ijtbitemcnc.
     * 
     * @return ijficinjs
     */
    public idw.idwws.Ijficinj[] getIjficinjs() {
        return ijficinjs;
    }


    /**
     * Sets the ijficinjs value for this Ijtbitemcnc.
     * 
     * @param ijficinjs
     */
    public void setIjficinjs(idw.idwws.Ijficinj[] ijficinjs) {
        this.ijficinjs = ijficinjs;
    }

    public idw.idwws.Ijficinj getIjficinjs(int i) {
        return this.ijficinjs[i];
    }

    public void setIjficinjs(int i, idw.idwws.Ijficinj _value) {
        this.ijficinjs[i] = _value;
    }


    /**
     * Gets the ijreacncs value for this Ijtbitemcnc.
     * 
     * @return ijreacncs
     */
    public idw.idwws.Ijreacnc[] getIjreacncs() {
        return ijreacncs;
    }


    /**
     * Sets the ijreacncs value for this Ijtbitemcnc.
     * 
     * @param ijreacncs
     */
    public void setIjreacncs(idw.idwws.Ijreacnc[] ijreacncs) {
        this.ijreacncs = ijreacncs;
    }

    public idw.idwws.Ijreacnc getIjreacncs(int i) {
        return this.ijreacncs[i];
    }

    public void setIjreacncs(int i, idw.idwws.Ijreacnc _value) {
        this.ijreacncs[i] = _value;
    }


    /**
     * Gets the ijtbgrpitemcnc value for this Ijtbitemcnc.
     * 
     * @return ijtbgrpitemcnc
     */
    public idw.idwws.Ijtbgrpitemcnc getIjtbgrpitemcnc() {
        return ijtbgrpitemcnc;
    }


    /**
     * Sets the ijtbgrpitemcnc value for this Ijtbitemcnc.
     * 
     * @param ijtbgrpitemcnc
     */
    public void setIjtbgrpitemcnc(idw.idwws.Ijtbgrpitemcnc ijtbgrpitemcnc) {
        this.ijtbgrpitemcnc = ijtbgrpitemcnc;
    }


    /**
     * Gets the ordem value for this Ijtbitemcnc.
     * 
     * @return ordem
     */
    public java.math.BigDecimal getOrdem() {
        return ordem;
    }


    /**
     * Sets the ordem value for this Ijtbitemcnc.
     * 
     * @param ordem
     */
    public void setOrdem(java.math.BigDecimal ordem) {
        this.ordem = ordem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbitemcnc)) return false;
        Ijtbitemcnc other = (Ijtbitemcnc) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cditemcnc==null && other.getCditemcnc()==null) || 
             (this.cditemcnc!=null &&
              this.cditemcnc.equals(other.getCditemcnc()))) &&
            ((this.dsitemcnc==null && other.getDsitemcnc()==null) || 
             (this.dsitemcnc!=null &&
              this.dsitemcnc.equals(other.getDsitemcnc()))) &&
            ((this.ijcncops==null && other.getIjcncops()==null) || 
             (this.ijcncops!=null &&
              java.util.Arrays.equals(this.ijcncops, other.getIjcncops()))) &&
            ((this.ijcncturnos==null && other.getIjcncturnos()==null) || 
             (this.ijcncturnos!=null &&
              java.util.Arrays.equals(this.ijcncturnos, other.getIjcncturnos()))) &&
            ((this.ijficcncs==null && other.getIjficcncs()==null) || 
             (this.ijficcncs!=null &&
              java.util.Arrays.equals(this.ijficcncs, other.getIjficcncs()))) &&
            ((this.ijficinjs==null && other.getIjficinjs()==null) || 
             (this.ijficinjs!=null &&
              java.util.Arrays.equals(this.ijficinjs, other.getIjficinjs()))) &&
            ((this.ijreacncs==null && other.getIjreacncs()==null) || 
             (this.ijreacncs!=null &&
              java.util.Arrays.equals(this.ijreacncs, other.getIjreacncs()))) &&
            ((this.ijtbgrpitemcnc==null && other.getIjtbgrpitemcnc()==null) || 
             (this.ijtbgrpitemcnc!=null &&
              this.ijtbgrpitemcnc.equals(other.getIjtbgrpitemcnc()))) &&
            ((this.ordem==null && other.getOrdem()==null) || 
             (this.ordem!=null &&
              this.ordem.equals(other.getOrdem())));
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
        if (getCditemcnc() != null) {
            _hashCode += getCditemcnc().hashCode();
        }
        if (getDsitemcnc() != null) {
            _hashCode += getDsitemcnc().hashCode();
        }
        if (getIjcncops() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjcncops());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjcncops(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjcncturnos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjcncturnos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjcncturnos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjficcncs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjficcncs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjficcncs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjficinjs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjficinjs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjficinjs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjreacncs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreacncs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreacncs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbgrpitemcnc() != null) {
            _hashCode += getIjtbgrpitemcnc().hashCode();
        }
        if (getOrdem() != null) {
            _hashCode += getOrdem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbitemcnc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbitemcnc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cditemcnc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cditemcnc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsitemcnc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsitemcnc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcncops");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcncops"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcncop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcncturnos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcncturnos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcncturno"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijficcncs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijficcncs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijficcnc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijficinjs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijficinjs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijficinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreacncs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreacncs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreacnc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbgrpitemcnc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbgrpitemcnc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbgrpitemcnc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
